package pro.games_box.hotello.presentation.application;

import android.app.Application;

import pro.games_box.hotello.R;
import pro.games_box.hotello.presentation.di.AppComponent;
import pro.games_box.hotello.presentation.di.AppModule;
import pro.games_box.hotello.presentation.di.DaggerAppComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Tesla on 01.06.2017.
 */

public class App extends Application {
    private static AppComponent sAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getResources().getString(R.string.font_normal))
                .setFontAttrId(R.attr.fontPath)
                .build());

        initComponent();
    }

    private void initComponent() {
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}
