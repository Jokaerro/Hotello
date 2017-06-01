package pro.games_box.hotello.presentation.di;

import com.squareup.picasso.Picasso;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Tesla on 01.06.2017.
 */

@Module
public class AppModule {
    private Context mContext;
    private Picasso mPicasso;

    public AppModule(Context context) {
        mContext = context;
        mPicasso = Picasso.with(context);
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mContext;
    }


    @Provides
    @Singleton
    Picasso providePicasso() {
        return mPicasso;
    }
}
