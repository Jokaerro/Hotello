package pro.games_box.hotello.data.datasource;

import java.util.List;

import io.reactivex.Observable;
import pro.games_box.hotello.data.entity.Hotel;
import pro.games_box.hotello.data.entity.HotelDetail;

/**
 * Created by Tesla on 01.06.2017.
 */

public interface DataSource {

    Observable<List<Hotel>> getHotels(String hotelSource);

    Observable<HotelDetail> getHotel(String hotelSource);
}
