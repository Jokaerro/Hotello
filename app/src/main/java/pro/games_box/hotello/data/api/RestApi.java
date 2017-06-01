package pro.games_box.hotello.data.api;

import java.util.List;

import io.reactivex.Observable;
import pro.games_box.hotello.data.entity.Hotel;
import pro.games_box.hotello.data.entity.HotelDetail;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Tesla on 01.06.2017.
 */

public interface RestApi {
    @GET("iMofas/ios-android-test/master/{source}")
    Observable<List<Hotel>> getHotels(@Path("source") String hotelsSource);

    @GET("iMofas/ios-android-test/master/{source}")
    Observable<HotelDetail> getHotel(@Path("source") String hotelSource);
}
