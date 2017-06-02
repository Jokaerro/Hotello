package pro.games_box.hotello.domain.interactor;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Function;
import pro.games_box.hotello.domain.entity.HotelDetailDomain;
import pro.games_box.hotello.domain.entity.HotelDomain;
import pro.games_box.hotello.domain.executer.PostExecutionThread;
import pro.games_box.hotello.domain.executer.ThreadExecutor;
import pro.games_box.hotello.domain.interactor.base.Interactor;
import pro.games_box.hotello.domain.repository.HotelRepository;
import pro.games_box.hotello.presentation.screen.main.model.Hotel;

/**
 * Created by Tesla on 02.06.2017.
 */

public class HotelInteractor  extends Interactor<HotelDomain, Void>{
    private HotelRepository mHotelRepository;

    @Inject
    HotelInteractor(HotelRepository hotelRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread){
        super(threadExecutor, postExecutionThread);
        mHotelRepository = hotelRepository;
    }

    @Override
    protected Observable<HotelDomain> buildObservable(Void aVoid) {
        mHotelRepository.getHotels("dsfdsf")
                .flatMap(new Function<List<HotelDomain>, Observable<HotelDomain>>(){
                    @Override
                    public Observable<HotelDomain> apply(List<HotelDomain> hotels){
                        return Observable.from(hotels);
                    }
                })
                .flatMap(new Function<HotelDomain, Observable<HotelDomain>>() {
                    @Override
                    public Observable<HotelDomain> apply(@NonNull final HotelDomain hotel) throws Exception {
                        return mHotelRepository.getDetail(hotel)
                                .map(new Function<HotelDetailDomain, HotelDomain>() {
                                    @Override
                                    public HotelDomain apply(@NonNull HotelDetailDomain hotelDetailDomain) throws Exception {
                                        return hotel.setDetails(hotelDetailDomain);
                                    }
                                });
                    }
                })
                .toList()
                .subscribe(new BiConsumer<List<HotelDomain>, Throwable>() {
                    @Override
                    public void accept(@NonNull List<HotelDomain> hotelDomains, @NonNull Throwable throwable) throws Exception {
                        for(HotelDomain hotel : hotelDomains){
                            Log.d(">>>>>>", hotel.getDetails().getImage());
                        }
                    }
                });

        return null;
    }
}
