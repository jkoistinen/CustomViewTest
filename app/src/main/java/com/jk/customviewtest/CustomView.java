package com.jk.customviewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by jk on 2017-01-26.
 */

public class CustomView extends View {

    private Paint paint;

    private int halfHeightMeasureSpec;
    private int halfWidthMeasureSpec;

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
        paint.setColor(Color.BLUE);
    }

    public RectF createOval(int width, int height){
        return new RectF(0, 0, width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(createOval(getWidth(), getHeight()), paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        halfHeightMeasureSpec = heightMeasureSpec / 2;
        halfWidthMeasureSpec = widthMeasureSpec / 2;

        setMeasuredDimension(widthMeasureSpec, halfHeightMeasureSpec);

    }

    @Override
    public boolean performClick() {
        Toast.makeText(getContext(), "Clicked!", Toast.LENGTH_SHORT).show();
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
