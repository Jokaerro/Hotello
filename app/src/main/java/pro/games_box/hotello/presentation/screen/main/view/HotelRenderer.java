package pro.games_box.hotello.presentation.screen.main.view;

import com.pedrogomez.renderers.Renderer;
import com.squareup.picasso.Picasso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.games_box.hotello.R;
import pro.games_box.hotello.presentation.screen.main.model.Hotel;


/**
 * Created by Tesla on 01.06.2017.
 */

public abstract  class HotelRenderer extends Renderer<Hotel> {

    @BindView(R.id.iv_thumbnail)
    ImageView mThumbnail;

    @BindView(R.id.tv_title)
    TextView mTitle;

    @BindView(R.id.ratingBar_indicator)
    RatingBar mStars;

    @BindView(R.id.tv_distance)
    TextView mDistance;

    @Override
    protected View inflate(LayoutInflater inflater, ViewGroup parent) {
        View inflatedView = inflater.inflate(R.layout.hotel_renderer, parent, false);

        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @OnClick(R.id.iv_thumbnail)
    void onHotelClicked() {
        Hotel hotel = getContent();
        Toast.makeText(getContext(), "Hotel clicked. Title = " + hotel.getName(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void render() {
        Hotel hotel = getContent();
        renderThumbnail(hotel);
        renderTitle(hotel);
        renderRating(hotel);
        renderDistance();
    }

    private void renderThumbnail(Hotel hotel) {
        Picasso.with(getContext()).cancelRequest(mThumbnail);
        Picasso.with(getContext())
                .load(hotel.getImage())
                .placeholder(R.drawable.placeholder)
                .into(mThumbnail);
    }

    private void renderTitle(Hotel hotel) {
        this.mTitle.setText(hotel.getName());
    }

    private void renderRating(Hotel hotel) {
        this.mStars.setRating(hotel.getStars());
    }

    protected abstract void renderDistance();

    protected TextView getDistance() {
        return mDistance;
    }

    @Override
    protected void setUpView(View rootView) { }

    @Override protected void hookListeners(View rootView) {  }
}
