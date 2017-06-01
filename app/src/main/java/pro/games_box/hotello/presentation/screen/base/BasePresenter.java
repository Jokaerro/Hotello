package pro.games_box.hotello.presentation.screen.base;

/**
 * Created by admin on 01.06.2017.
 */

public abstract class BasePresenter<View> {
    protected View mView;

    public void setView(View view) {
        mView = view;
    }

    public void destroy() {
        mView = null;
    }
}
