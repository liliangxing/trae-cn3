package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* loaded from: classes4.dex */
public class SwipeViewPager extends SSViewPager {
    private boolean mSwipeEnabled;

    public SwipeViewPager(Context context) {
        super(context);
        this.mSwipeEnabled = true;
    }

    public SwipeViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSwipeEnabled = true;
    }

    @Override // com.bytedance.ies.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mSwipeEnabled) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.bytedance.ies.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mSwipeEnabled) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    public void setSwipeEnabled(boolean z) {
        this.mSwipeEnabled = z;
    }
}
