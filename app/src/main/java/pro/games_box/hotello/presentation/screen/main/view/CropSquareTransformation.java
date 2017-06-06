package pro.games_box.hotello.presentation.screen.main.view;

import com.squareup.picasso.Transformation;

import android.graphics.Bitmap;

/**
 * Created by TESLA on 03.06.2017.
 */

public class CropSquareTransformation implements Transformation {
    private int mCutWidth;

    public CropSquareTransformation(int cutWidth){
        mCutWidth = cutWidth;
    }
    @Override
    public Bitmap transform(Bitmap source) {
        int x = mCutWidth, y = mCutWidth;
        Bitmap result = Bitmap.createBitmap(source, x, y, source.getWidth()-(mCutWidth*2+mCutWidth),  source.getHeight()-(mCutWidth*2+mCutWidth));
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
