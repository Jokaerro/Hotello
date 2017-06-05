package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererAdapter;

import org.junit.Test;

import java.util.ArrayList;

import pro.games_box.hotello.data.entity.HotelDetail;

import static org.junit.Assert.*;

/**
 * Created by TESLA on 01.06.2017.
 */
public class MainActivityTest {
    private RendererAdapter<HotelDetail> mAdapter;

    @Test
    public void updateListView() throws Exception {
        ArrayList<HotelDetail> hotels = new ArrayList<>();
        HotelDetail hotelDetail = new HotelDetail();
        hotelDetail.setName("Test hotel");
        hotelDetail.setLat(43.1);
        hotelDetail.setLon(73.1);
        hotelDetail.setAddress("Baiker Street 221b");
        hotelDetail.setStars(5);
        hotelDetail.setDistance(99.9);
        hotelDetail.setSuitesAvailability("1:2");
        hotels.add(hotelDetail);

        AdapteeCollection<HotelDetail> hotelCollection = new ListAdapteeCollection<HotelDetail>(hotels);
        mAdapter = new RendererAdapter<HotelDetail>(new HotelRendererBuilder(), hotelCollection);
    }

}