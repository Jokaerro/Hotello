package pro.games_box.hotello.presentation.screen.hoteldetail.view;

import com.squareup.picasso.Picasso;
import com.willy.ratingbar.ScaleRatingBar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.games_box.hotello.R;
import pro.games_box.hotello.data.entity.HotelDetail;
import pro.games_box.hotello.presentation.screen.base.BaseActivity;
import pro.games_box.hotello.presentation.screen.main.view.CropSquareTransformation;

/**
 * Created by Tesla on 01.06.2017.
 */

public class HotelDetailActivity extends BaseActivity{
    private static final String HOTEL_DATA = "hotel";
    private HotelDetail mHotelDetail;

    @BindView(R.id.image)
    ImageView mImage;

    @BindView(R.id.ratingBar_indicator)
    ScaleRatingBar mBar;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.address)
    TextView mAddress;

    @BindView(R.id.distance)
    TextView mDistance;

    @BindView(R.id.coordinates)
    TextView mCoordinates;

    @BindView(R.id.suits)
    GridView suits;

    public static void start(Context context, HotelDetail data) {
        Intent intent = new Intent(context, HotelDetailActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable(HOTEL_DATA, data);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_info);

        Bundle bundle = getIntent().getExtras();
        mHotelDetail = (HotelDetail) bundle.getSerializable(HOTEL_DATA);

        ButterKnife.bind(this);

        Picasso.with(this)
                .load(mHotelDetail.getImage())
                .transform(new CropSquareTransformation(getResources().getInteger(R.integer.cut_width)))
                .error(R.drawable.placeholder)
                .placeholder(R.drawable.placeholder)
                .into(mImage);

        mBar.setRating(mHotelDetail.getStars());
        mTitle.setText(mHotelDetail.getName());
        mAddress.setText(mHotelDetail.getAddress());
        String distance = mHotelDetail.getDistance() + " " + getString(R.string.measure_unit);
        mDistance.setText(distance);
        String coordinates = mHotelDetail.getLat() + " : " + mHotelDetail.getLon();
        mCoordinates.setText(coordinates);

        ArrayList<String> items = new ArrayList<>();
        Collections.addAll(items, mHotelDetail.getSuitesAvailability().split(":"));
        suits.setFocusable(false);
        suits.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));
    }
}
