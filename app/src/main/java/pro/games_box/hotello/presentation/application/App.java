package pro.games_box.hotello.presentation.application;

import android.app.Application;
import android.content.Context;

import pro.games_box.hotello.R;
import pro.games_box.hotello.data.api.RestApiCreator;
import pro.games_box.hotello.data.datasource.DataSource;
import pro.games_box.hotello.data.datasource.DataSourceImpl;
import pro.games_box.hotello.presentation.di.AppComponent;
import pro.games_box.hotello.presentation.di.AppModule;
import pro.games_box.hotello.presentation.di.DaggerAppComponent;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Tesla on 01.06.2017.
 */

public class App extends Application {
    private static AppComponent sAppComponent;
    private DataSource mDataSource;

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getResources().getString(R.string.font_normal))
                .setFontAttrId(R.attr.fontPath)
                .build());

        initComponent();
        mDataSource = new DataSourceImpl(RestApiCreator.create(Config.API_BASE_URL));
    }

    public static DataSource getDataSource(Context context) {
        return getApplication(context).mDataSource;
    }

    private static App getApplication(Context context) {

        return (App) context.getApplicationContext();
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
