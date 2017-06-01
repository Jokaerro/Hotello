package pro.games_box.hotello.presentation.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Tesla on 01.06.2017.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
}
