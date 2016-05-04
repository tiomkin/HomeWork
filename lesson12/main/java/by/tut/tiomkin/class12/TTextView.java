package by.tut.tiomkin.class12;


/*
* The MIT License (MIT)
* Copyright (c) 2015 Timofey Kovalenko <timofey@kiparo.com>
*/
       import android.content.Context;
        import android.content.res.TypedArray;
        import android.graphics.Typeface;
        import android.support.v7.widget.AppCompatTextView;
        import android.util.AttributeSet;
        import android.util.Log;


/**
 * Designed to set custom fonts.
 * @author Timofey Kovalenko
 */
public class TTextView extends AppCompatTextView {

    private static final String TAG = TTextView.class.getSimpleName();

    public TTextView(Context context) {

        super(context);
    }

    public TTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomAttribute(context, attrs);
    }

    public TTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomAttribute(context, attrs);
    }

    private void setCustomAttribute(Context ctx, AttributeSet attrs) {

        if(isInEditMode()) {
            return;
        }

        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TStyle);
        int customFont = a.getInt(R.styleable.TStyle_typeface, -1);
        if (customFont != -1) {
            setCustomFont(ctx, customFont);
            a.recycle();
        }
    }

    public boolean setCustomFont(Context ctx, int fontEnum) {

        Typeface tf;
        try {
            tf = TTypefaces.get(ctx, fontEnum);
        } catch (Exception e) {
            Log.w(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }

        setTypeface(tf);
        return true;
    }
}
