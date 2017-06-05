package pro.games_box.hotello.presentation.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;

import pro.games_box.hotello.R;

/**
 * Created by TESLA on 04.06.2017.
 */

public class OutlineTextView extends android.support.v7.widget.AppCompatTextView{
    private static final int DEFAULT_STROKE_WIDTH = 0;

    private int mStrokeColor;
    private float mStrokeWidth;

    public OutlineTextView(Context context) {
        this(context, null, 0);
    }

    public OutlineTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OutlineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        if(attrs != null) {
            TypedArray mAttr = context.obtainStyledAttributes(attrs, R.styleable.OutlineTextViewAttrs);
            mStrokeColor = mAttr.getColor(R.styleable.OutlineTextViewAttrs_textStrokeColor,
                    getCurrentTextColor());
            mStrokeWidth = mAttr.getDimension(R.styleable.OutlineTextViewAttrs_textStrokeWidth,
                    DEFAULT_STROKE_WIDTH);

            mAttr.recycle();
        }
        else {
            mStrokeColor = getCurrentTextColor();
            mStrokeWidth = DEFAULT_STROKE_WIDTH;
        }
    }

    @Override
    public void onDraw(Canvas canvas) {
        if(mStrokeWidth > 0) {
            Paint p = getPaint();
            p.setStyle(Paint.Style.FILL);
            super.onDraw(canvas);
            int currentTextColor = getCurrentTextColor();
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(mStrokeWidth);
            setTextColor(mStrokeColor);
            super.onDraw(canvas);
            setTextColor(currentTextColor);
        } else {
            super.onDraw(canvas);
        }
    }
}
