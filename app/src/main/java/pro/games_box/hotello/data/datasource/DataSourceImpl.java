package pro.games_box.hotello.data.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import pro.games_box.hotello.data.api.RestApi;
import pro.games_box.hotello.data.entity.Hotel;
import pro.games_box.hotello.data.entity.HotelDetail;

/**
 * Created by Tesla on 01.06.2017.
 */

public class DataSourceImpl implements DataSource{

    private RestApi mRestApi;

    @Inject
    public DataSourceImpl(@NonNull RestApi restApi) {
        mRestApi = restApi;
    }

    @Override
    public Observable<List<Hotel>> getHotels(String hotelSource) {
        return mRestApi.getHotels(hotelSource);
    }

    @Override
    public Observable<HotelDetail> getHotel(String hotelSource) {
        return mRestApi.getHotel(hotelSource);
    }
}
