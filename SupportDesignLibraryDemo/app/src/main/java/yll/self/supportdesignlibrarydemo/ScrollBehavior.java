package yll.self.supportdesignlibrarydemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by yll on 2016/3/24.
 *
 */
public class ScrollBehavior extends CoordinatorLayout.Behavior<View> {

    public ScrollBehavior(){}

    public ScrollBehavior(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    /**这里的返回值表明这次滑动我们要不要关心，我们要关心y轴方向上的滑动*/
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        UtilsManager.log("-->"+((nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0));
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    /**滑动的事件*/
    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        int leftScrolled = target.getScrollY();
        UtilsManager.log("dy-->"+dy);
        UtilsManager.log("child.getY()-->" + child.getY());
        ViewHelper.setY(child, child.getY() - dy);
    }

//    /**惯性滑动的事件*/
//    @Override
//    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target, float velocityX, float velocityY, boolean consumed) {
//        child.fling((int)velocityY);
//        return true;
//    }


    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, View child, MotionEvent ev) {
        return super.onInterceptTouchEvent(parent, child, ev);
    }
}
