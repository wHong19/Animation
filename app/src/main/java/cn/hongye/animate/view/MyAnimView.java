package cn.hongye.animate.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import cn.hongye.animate.util.PointEvaluator;
import cn.hongye.animate.widget.Point;

/**
 * author 汪洪
 * date 2015/12/31
 * Created by Ethan on 10.
 */
public class MyAnimView extends View{
    public static final float RADIUS=50f;

    private Point mCurrentPoint;

    private Paint mPaint;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(null==mCurrentPoint){
            mCurrentPoint=new Point(RADIUS,RADIUS);
            drawCircle(canvas);
            startAnimation();
        }else {
            drawCircle(canvas);
        }
    }


    private void drawCircle(Canvas canvas){
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    private void startAnimation(){
        Point startPoint=new Point(RADIUS,RADIUS);
        Point endPoint=new Point(getWidth()-RADIUS,getHeight()-RADIUS);
        final ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint= (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        anim.setDuration(50000);
        anim.start();
    }
}
