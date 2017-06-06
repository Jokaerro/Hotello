package pro.games_box.hotello.presentation.screen.main.presenter;

import org.reactivestreams.Subscription;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import pro.games_box.hotello.R;
import pro.games_box.hotello.data.datasource.DataSourceImpl;
import pro.games_box.hotello.data.entity.Hotel;
import pro.games_box.hotello.data.entity.HotelDetail;
import pro.games_box.hotello.presentation.application.App;
import pro.games_box.hotello.presentation.screen.base.BasePresenter;
import pro.games_box.hotello.presentation.screen.main.view.MainView;

/**
 * Created by Tesla on 01.06.2017.
 */

public class MainPresenter extends BasePresenter<MainView>{

    @Inject
    public Context mContext;

    @Inject
    public DataSourceImpl mDataSource;

    public MainPresenter(){
        App.getAppComponent().injectMainPresenter(this);
    }

    public void updateHotels(){
        mView.showProgressDialog();
        mDataSource.getHotels("0777.json")
                .flatMapIterable(new Function<List<Hotel>, Iterable<Hotel>>() {
                    @Override
                    public Iterable<Hotel> apply(@NonNull List<Hotel> hotels) throws Exception {
                        return hotels;
                    }
                })
                .flatMap(new Function<Hotel, ObservableSource<HotelDetail>>() {
                    @Override
                    public ObservableSource<HotelDetail> apply(@NonNull Hotel hotel) throws Exception {
                        return mDataSource.getHotel(hotel.getId());
                    }
                })
                .toList()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<HotelDetail>>() {
                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onSuccess(List<HotelDetail> hotelDetails) {
                                   processHotels(hotelDetails);
                               }

                               @Override
                               public void onError(Throwable e) {
                                   mView.errorHandling(e.getMessage());
                                   mView.hideProgressDialog();
                               }
                           }
                );
    }

    private void processHotels(List<HotelDetail> details) {
        mView.updateListView(details);
        mView.hideProgressDialog();
    }

    public void sortFromCenter(List<HotelDetail> hotels){
        sortHotel(hotels, SortType.FROM_CENTER);
    }

    public void sortByFreeRooms(List<HotelDetail> hotels){
        sortHotel(hotels, SortType.EMPTY_ROOMS);
    }

    public void sortFromDistance(List<HotelDetail> hotels){
        sortHotel(hotels, SortType.FROM_DISTANCE);
    }

    public enum SortType {
        FROM_CENTER,
        FROM_DISTANCE,
        EMPTY_ROOMS
    }

    public void sortHotel(List<HotelDetail> hotels, final SortType typeSort) {
        if(hotels == null || hotels.isEmpty()){
            mView.errorHandling(mContext.getString(R.string.error_empty_hotel_list));
            return;
        }
        hotels = new ArrayList<>(hotels);
        Observable.just(hotels)
                .doOnNext(hotelsDetails -> {
                    switch (typeSort) {
                        case FROM_CENTER:
                            Collections.sort(hotelsDetails, (o1, o2) -> o1.getDistanceInMetres() - o2.getDistanceInMetres());
                            break;
                        case EMPTY_ROOMS:
                            Collections.sort(hotelsDetails, (o1, o2) -> o2.getFreeRoomsCount() - o1.getFreeRoomsCount());
                            break;
                        case FROM_DISTANCE:
                            Collections.sort(hotelsDetails, (o1, o2) -> o1.getDistance().intValue() - o2.getDistance().intValue());
                            break;
                        default:
                            break;
                    }
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(hotelDetailLists -> {
                    mView.updateListView(hotelDetailLists);
                    mView.hideProgressDialog();
                });
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
