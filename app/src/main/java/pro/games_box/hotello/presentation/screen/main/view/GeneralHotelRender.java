package pro.games_box.hotello.presentation.screen.main.view;

import android.view.View;

import pro.games_box.hotello.presentation.screen.main.model.Hotel;

/**
 * Created by Tesla on 01.06.2017.
 */

public class GeneralHotelRender extends HotelRenderer{
    @Override
    protected void renderDistance() {
        Hotel hotel = getContent();
        getDistance().setText(hotel.getDistance() + "km");
    }
}
