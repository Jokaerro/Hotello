package pro.games_box.hotello.presentation.screen.main.view;

import com.squareup.picasso.Transformation;

import android.graphics.Bitmap;

/**
 * Created by TESLA on 03.06.2017.
 */

public class CropSquareTransformation implements Transformation {
    @Override
    public Bitmap transform(Bitmap source) {
        int x = 2;
        int y = 2;
        Bitmap result = Bitmap.createBitmap(source, x, y, source.getWidth()-2,  source.getHeight()-2);
        if (result != source) {
            source.recycle();
        }
        return result;
    }

    @Override
    public String key() {
        return "square()";
    }
}
