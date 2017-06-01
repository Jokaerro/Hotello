package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

import pro.games_box.hotello.presentation.screen.main.model.Hotel;

/**
 * Created by Tesla on 01.06.2017.
 */

public class HotelRendererBuilder extends RendererBuilder<Hotel> {

    public HotelRendererBuilder(){
        List<Renderer<Hotel>> prototypes = getRendererHotelPrototypes();
        setPrototypes(prototypes);
    }

    private  List<Renderer<Hotel>> getRendererHotelPrototypes(){
        List<Renderer<Hotel>> prototypes = new LinkedList<Renderer<Hotel>>();
        GeneralHotelRender generalHotelRender = new GeneralHotelRender();
        prototypes.add(generalHotelRender);

        return prototypes;
    }
}
