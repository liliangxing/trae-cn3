package com.bytedance.android.anniex.container.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class PullDownCloseIndicatorContainer extends FrameLayout {
    private ForceInterceptConstraintLayout mParent;

    public PullDownCloseIndicatorContainer(Context context) {
        super(context);
    }

    public PullDownCloseIndicatorContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullDownCloseIndicatorContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.mParent == null && (getParent() instanceof ForceInterceptConstraintLayout)) {
            this.mParent = (ForceInterceptConstraintLayout) getParent();
        }
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return super.onTouchEvent(motionEvent);
                    }
                }
            }
            ForceInterceptConstraintLayout forceInterceptConstraintLayout = this.mParent;
            if (forceInterceptConstraintLayout != null) {
                forceInterceptConstraintLayout.setForceInterceptTouchEvent(false);
            }
            return true;
        }
        ForceInterceptConstraintLayout forceInterceptConstraintLayout2 = this.mParent;
        if (forceInterceptConstraintLayout2 != null) {
            forceInterceptConstraintLayout2.setForceInterceptTouchEvent(true);
        }
        return true;
    }
}
