package cn.hongye.animate.util;

import android.animation.TypeEvaluator;

import cn.hongye.animate.widget.Point;

/**
 * author 汪洪
 * date 2015/12/31
 * Created by Ethan on 10.
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
