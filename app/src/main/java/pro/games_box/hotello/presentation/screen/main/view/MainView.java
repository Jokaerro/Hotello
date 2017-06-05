package pro.games_box.hotello.presentation.screen.main.view;

import java.util.List;

import pro.games_box.hotello.data.entity.HotelDetail;

/**
 * Created by Tesla on 01.06.2017.
 */

public interface MainView {

    void updateListView(List<HotelDetail> hotels);

    void showProgressDialog();

    void hideProgressDialog();

    void errorHandling(String message);
}
