package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RVRendererAdapter;
import com.pedrogomez.renderers.RendererAdapter;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.games_box.hotello.R;
import pro.games_box.hotello.data.entity.HotelDetail;
import pro.games_box.hotello.presentation.application.App;
import pro.games_box.hotello.presentation.screen.base.BaseActivity;
import pro.games_box.hotello.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {
    private RVRendererAdapter<HotelDetail> mAdapter;
    private List<HotelDetail> mHotels;
    private ProgressDialog mProgressDialog;

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.rv_renderers)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        App.getAppComponent().injectMainActivity(this);

        initListView();

        mPresenter.setView(this);
        mPresenter.updateHotels();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mPresenter.destroy();
    }

    private void initListView() {
        AdapteeCollection<HotelDetail> hotelCollection = new ListAdapteeCollection<HotelDetail>();
        mAdapter = new RVRendererAdapter<>(new HotelRendererBuilder(), hotelCollection);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void updateListView(List<HotelDetail> hotels){
        mHotels = hotels;
        AdapteeCollection<HotelDetail> hotelCollection = new ListAdapteeCollection<HotelDetail>(hotels);
        mAdapter.setCollection(hotelCollection);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loading));
        }
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void errorHandling(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final AlertDialog dialog = builder.create();
        dialog.setTitle(getString(R.string.error));
        dialog.setMessage(message);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.error_button), (dialogInterface, i) -> dialog.dismiss());
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_sort_free_rooms:
                mPresenter.sortByFreeRooms(mHotels);
                break;
            case R.id.menu_sort_from_center:
                mPresenter.sortFromCenter(mHotels);
                break;
            case R.id.menu_sort_from_distance:
                mPresenter.sortFromDistance(mHotels);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }
}
