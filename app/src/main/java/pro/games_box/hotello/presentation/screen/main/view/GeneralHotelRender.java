package pro.games_box.hotello.presentation.screen.main.view;

import pro.games_box.hotello.data.entity.HotelDetail;
import pro.games_box.hotello.presentation.screen.hoteldetail.view.HotelDetailActivity;

/**
 * Created by Tesla on 01.06.2017.
 */

public class GeneralHotelRender extends HotelRenderer{
    @Override
    protected void renderDistance() {
        HotelDetail hotel = getContent();
        getDistance().setText(hotel.getDistance());
    }

    @Override
    public void onHotelClicked(){
        HotelDetailActivity.start(getContext(), getContent());
    }
}
