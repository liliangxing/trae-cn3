package com.bytedance.ies.uikit.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

/* loaded from: classes4.dex */
public class InScrollViewPager extends SSViewPager {
    public InScrollViewPager(Context context) {
        super(context);
    }

    public InScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.bytedance.ies.uikit.viewpager.SSViewPager, androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        int action = motionEvent.getAction() & 255;
        if (action == 0 || action == 2) {
            ViewParent parent2 = getParent();
            if (parent2 != null) {
                parent2.requestDisallowInterceptTouchEvent(true);
            }
        } else if ((action == 1 || action == 3) && (parent = getParent()) != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        super.onTouchEvent(motionEvent);
        return true;
    }
}
