package com.jk.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jk on 2017-01-26.
 */

public class CustomView extends View {

    private Paint paint;

    private int halfHeightMeasureSpec;
    private int halfWidthMeasureSpec;

    private int color = Color.BLUE;

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);
    }

    public RectF createOval(int width, int height){
        return new RectF(0, 0, width, height);
    }

    public void swapColor(){

        if(color == Color.BLUE){
            color = Color.RED;
        } else {
            color = Color.BLUE;
        }

        paint.setColor(color);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int w = getWidth();
        int h = getHeight();

        //Choose the smaller
        int size = Math.min(w, h);

        canvas.drawOval(createOval(size, size), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        halfHeightMeasureSpec = heightMeasureSpec / 2;
        halfWidthMeasureSpec = widthMeasureSpec / 2;

        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    public boolean performClick() {
        swapColor();
        return super.performClick();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            performClick();
        }
        return true;
    }
}
