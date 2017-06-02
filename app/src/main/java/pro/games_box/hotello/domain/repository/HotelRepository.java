package pro.games_box.hotello.domain.repository;

import java.util.List;

import io.reactivex.Observable;
import pro.games_box.hotello.domain.entity.HotelDetailDomain;
import pro.games_box.hotello.domain.entity.HotelDomain;

/**
 * Created by Tesla on 02.06.2017.
 */

public interface HotelRepository {

    Observable<List<HotelDomain>> getHotels(String source);
    Observable<HotelDetailDomain> getDetail(HotelDomain hotel);
}
