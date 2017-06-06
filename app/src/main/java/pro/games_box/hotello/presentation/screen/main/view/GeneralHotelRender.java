package pro.games_box.hotello.presentation.screen.main.view;

import pro.games_box.hotello.R;
import pro.games_box.hotello.data.entity.HotelDetail;
import pro.games_box.hotello.presentation.screen.hoteldetail.view.HotelDetailActivity;

/**
 * Created by Tesla on 01.06.2017.
 */

public class GeneralHotelRender extends HotelRenderer{
    @Override
    protected void renderDistance() {
        HotelDetail hotel = getContent();
        String distance = String.valueOf(hotel.getDistance()) + " " +getContext().getString(R.string.measure_unit);
        getDistance().setText(distance);
    }

    @Override
    public void onHotelClicked(){
        HotelDetailActivity.start(getContext(), getContent());
    }
}
