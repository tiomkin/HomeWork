package by.tut.tiomkin.class12;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class MyCircleDiagram extends View{


    private static final String TAG = "MyCircleDiagram";
    private double mDiagramSize = 0.0;
    private Paint mLinePaint;
    private Paint mFillPaint;
    private HashMap<String, Integer> data;
    private int itemsQuantity = 0;
    private int total = 0;
    private Canvas mCanvas;

    public MyCircleDiagram(Context context) {
        super(context);
        init(context, null);
    }

    public MyCircleDiagram(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.MyCircleDiagram,
                0,0);

        try {
            mDiagramSize = a.getDimension(R.styleable.MyCircleDiagram_diagramSize,0);
        } finally {
            a.recycle();
        }
    }

    public MyCircleDiagram(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyCircleDiagram(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public double getDiagramSize() {
        return mDiagramSize;
    }

    public void setDiagramSize(double diagramSize) {
        mDiagramSize = diagramSize;
        invalidate();
        requestLayout();
    }

    public void init(Context context, AttributeSet attrs) {

        data = new HashMap<>();
        mFillPaint = new Paint();
        mFillPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mFillPaint.setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float radius = (float)mDiagramSize;
        //float radius = 50f;
        float center_x = 200f;
        float center_y = 200f;
        float px = center_x - radius;
        float py = center_y - radius;
        float tx = center_x + radius;
        float ty = center_y + radius;
        RectF rectF = new RectF(px,py,tx,ty);
        float startAngle = 0;
        for (Map.Entry<String, Integer> pair : data.entrySet()) {
            String color = pair.getKey();
            float value = (float)pair.getValue();

            Log.d(TAG, "onDraw color = " + color);
            Log.d(TAG, "onDraw value = " + value);

            float sweepAngle = value / total * 360;
            chooseColor(color);
            Log.d(TAG, "onDraw startAngle = " + startAngle +
            " sweepAngle " + sweepAngle);
            canvas.drawArc(rectF, startAngle, sweepAngle, true, mFillPaint);
            startAngle += sweepAngle;
        }

    }

    private void chooseColor(String color) {
        Log.d(TAG, "chooseColor color = " + color);
        String c = color.toUpperCase();
        switch (c) {
            case "GREEN":
                mFillPaint.setColor(Color.GREEN);
                Log.d(TAG, "done color is GREEN");
                break;
            case "RED":
                mFillPaint.setColor(Color.RED);
                Log.d(TAG, "done color is RED");
                break;
            case "BLUE":
                mFillPaint.setColor(Color.BLUE);
                Log.d(TAG, "done color is BLUE");
                break;
            case "YELLOW":
                mFillPaint.setColor(Color.YELLOW);
                Log.d(TAG, "done color is YELLOW");
                break;
        }
    }

    public void setData(HashMap<String, Integer> map) {
        data = map;
        for (int e : data.values()) {

            total += e;
        }
        Log.d(TAG, "setData() total = " + total);
        Log.d(TAG, "data = " + data.entrySet().iterator().next().getValue());

    }
}
