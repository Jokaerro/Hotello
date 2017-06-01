package pro.games_box.hotello.presentation.di;

import javax.inject.Singleton;

import dagger.Component;
import pro.games_box.hotello.presentation.screen.main.view.MainActivity;

/**
 * Created by Tesla on 01.06.2017.
 */

@Singleton
@Component(modules = {AppModule.class, DataModule.class})
public interface AppComponent {
    void injectMainActivity(MainActivity activity);
}
