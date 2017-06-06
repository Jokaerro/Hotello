package pro.games_box.hotello.presentation.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.games_box.hotello.data.api.RestApi;
import pro.games_box.hotello.data.api.RestApiCreator;
import pro.games_box.hotello.data.datasource.DataSource;
import pro.games_box.hotello.presentation.application.Config;

/**
 * Created by Tesla on 01.06.2017.
 */

@Module
public class DataModule {
    @Provides
    @Singleton
    RestApi provideRestApi() {
        return RestApiCreator.create(Config.API_BASE_URL);
    }

    @Provides
    @Singleton
    DataSource provideDataSource(DataSource dataSource) {
        return dataSource;
    }
}
