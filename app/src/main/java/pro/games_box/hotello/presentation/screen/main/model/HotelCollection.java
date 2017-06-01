package pro.games_box.hotello.presentation.screen.main.model;

import com.pedrogomez.renderers.ListAdapteeCollection;

import java.util.List;

/**
 * Created by Tesla on 01.06.2017.
 */

public class HotelCollection extends ListAdapteeCollection<Hotel>{

    public HotelCollection(List<Hotel> hotels){
        super(hotels);
    }
}
