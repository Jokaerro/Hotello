package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.Renderer;
import com.pedrogomez.renderers.RendererBuilder;

import java.util.LinkedList;
import java.util.List;

import pro.games_box.hotello.data.entity.HotelDetail;

/**
 * Created by Tesla on 01.06.2017.
 */

public class HotelRendererBuilder extends RendererBuilder<HotelDetail> {

    public HotelRendererBuilder(){
        List<Renderer<HotelDetail>> prototypes = getRendererHotelPrototypes();
        setPrototypes(prototypes);
    }

    private  List<Renderer<HotelDetail>> getRendererHotelPrototypes(){
        List<Renderer<HotelDetail>> prototypes = new LinkedList<Renderer<HotelDetail>>();
        GeneralHotelRender generalHotelRender = new GeneralHotelRender();
        prototypes.add(generalHotelRender);

        return prototypes;
    }
}
