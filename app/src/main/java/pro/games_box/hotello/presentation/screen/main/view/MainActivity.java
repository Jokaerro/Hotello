package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.AdapteeCollection;
import com.pedrogomez.renderers.ListAdapteeCollection;
import com.pedrogomez.renderers.RendererAdapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.games_box.hotello.R;
import pro.games_box.hotello.presentation.application.App;
import pro.games_box.hotello.presentation.screen.base.BaseActivity;
import pro.games_box.hotello.presentation.screen.main.model.Hotel;
import pro.games_box.hotello.presentation.screen.main.presenter.MainPresenter;

public class MainActivity extends BaseActivity implements MainView {
    private RendererAdapter<Hotel> mAdapter;

    @Inject
    MainPresenter mPresenter;

    @BindView(R.id.hotel_list)
    ListView mHotelList;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        App.getAppComponent().injectMainActivity(this);

        initAdapter();
        initListView();

        mPresenter.setView(this);
    }
    private void initAdapter(List<Hotel> hotels) {
        AdapteeCollection<Hotel> hotelCollection = new ListAdapteeCollection<Hotel>(hotels);
        mAdapter = new RendererAdapter<Hotel>(new HotelRendererBuilder(), hotelCollection);
    }

    private void initListView() {
        mHotelList.setAdapter(mAdapter);
    }

    @Override
    public void goToDetailHotel() {

    }
}
