package pro.games_box.hotello.presentation.screen.base;

import android.support.annotation.LayoutRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import pro.games_box.hotello.R;

/**
 * Created by Tesla on 01.06.2017.
 */

public class BaseActivity extends AppCompatActivity {

    private TextView titleView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
    }

    private void initToolbar() {
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);

                titleView = (TextView) toolbar.findViewById(R.id.toolbar_title);
            }
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if (titleView == null) {
            super.setTitle(title);
        } else {
            titleView.setText(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
