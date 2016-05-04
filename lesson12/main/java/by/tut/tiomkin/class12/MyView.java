package by.tut.tiomkin.class12;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View{
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
        initView(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void initView(Context context, AttributeSet attrs) {
        mPaint = new Paint();
        //mPaint.setColor(context.getColor(R.color.colorAccent));
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(5);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //canvas.save();

        /*canvas.drawCircle(getWidth()/2, getHeight()/2, 50, mPaint);
        canvas.drawLine(0,0,getWidth(), getHeight(), mPaint);*/
        int step = 360/12;
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(getWidth()/2, 80, getWidth()/2, 120, mPaint);
            canvas.rotate(step, getWidth()/2, getHeight()/2);
        }
        //canvas.restore();
    }
}
