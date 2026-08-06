package com.bytedance.ies.uikit.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;

/* loaded from: classes4.dex */
public class SwipeOverlayFrameLayout extends FrameLayout {
    private GestureDetector mDetector;
    private boolean mDisallowIntercept;
    private boolean mDisallowInterceptEnabled;
    private OnSwipeListener mListener;
    private float mMinFlingDistance;
    private boolean mSwipeEnabled;
    private float mThresholdY;

    /* loaded from: classes4.dex */
    public interface OnSwipeListener {
        boolean onSwipeLeft();

        boolean onSwipeRight();
    }

    public SwipeOverlayFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSwipeEnabled = true;
        this.mDisallowInterceptEnabled = false;
        this.mDisallowIntercept = false;
        init(context);
    }

    public SwipeOverlayFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSwipeEnabled = true;
        this.mDisallowInterceptEnabled = false;
        this.mDisallowIntercept = false;
        init(context);
    }

    public SwipeOverlayFrameLayout(Context context) {
        super(context);
        this.mSwipeEnabled = true;
        this.mDisallowInterceptEnabled = false;
        this.mDisallowIntercept = false;
        init(context);
    }

    void init(Context context) {
        GestureDetector.SimpleOnGestureListener simpleOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.ies.uikit.layout.SwipeOverlayFrameLayout.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return SwipeOverlayFrameLayout.this.onSwipeViewFling(motionEvent, motionEvent2, f, f2);
            }
        };
        this.mThresholdY = UIUtils.dip2Px(context, 45.0f);
        this.mMinFlingDistance = UIUtils.dip2Px(context, 65.0f);
        GestureDetector gestureDetector = new GestureDetector(context.getApplicationContext(), simpleOnGestureListener);
        this.mDetector = gestureDetector;
        gestureDetector.setOnDoubleTapListener(null);
        this.mDetector.setIsLongpressEnabled(false);
    }

    boolean onSwipeViewFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (this.mListener == null || Math.abs(motionEvent2.getY() - motionEvent.getY()) > this.mThresholdY) {
            return false;
        }
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        float abs3 = Math.abs(motionEvent2.getX() - motionEvent.getX());
        float abs4 = Math.abs(motionEvent2.getY() - motionEvent.getY());
        if (abs2 >= abs || abs4 >= abs3 || abs3 <= this.mMinFlingDistance) {
            return false;
        }
        if (f > 0.0f) {
            return this.mListener.onSwipeRight();
        }
        if (f < 0.0f) {
            return this.mListener.onSwipeLeft();
        }
        return false;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mListener = onSwipeListener;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.mDisallowIntercept = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        try {
            boolean z = false;
            if (motionEvent.getAction() == 0) {
                this.mDisallowIntercept = false;
            }
            if (this.mDisallowIntercept && this.mDisallowInterceptEnabled) {
                z = true;
            }
            if (this.mSwipeEnabled && (gestureDetector = this.mDetector) != null && !z && gestureDetector.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
                super.dispatchTouchEvent(motionEvent);
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception unused) {
            return true;
        }
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
    }

    public void setDisllowInterceptEnabled(boolean z) {
        this.mDisallowInterceptEnabled = z;
    }
}
