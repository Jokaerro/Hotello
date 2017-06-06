package pro.games_box.hotello.presentation.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pro.games_box.hotello.presentation.screen.main.presenter.MainPresenter;

/**
 * Created by Tesla on 06.06.2017.
 */

@Module
public class PresenterModule {
    @Provides
    @Singleton
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}
