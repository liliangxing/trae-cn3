package com.bytedance.ies.uikit.scrollview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* loaded from: classes4.dex */
public class FlowScrollView extends ScrollView {
    public static final int START = -100;
    int mLastY;
    FlowListener mListener;

    /* loaded from: classes4.dex */
    public interface FlowListener {
        int getBottomThreshold();

        void onScrollChanged(int i, int i2, int i3, int i4, int i5);

        void onScrollToBottom();
    }

    public FlowScrollView(Context context) {
        super(context);
        this.mLastY = -100;
    }

    public FlowScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastY = -100;
    }

    public FlowScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLastY = -100;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mListener != null) {
            int height = getHeight();
            int computeVerticalScrollRange = computeVerticalScrollRange();
            if (computeVerticalScrollRange - i2 <= this.mListener.getBottomThreshold() + height) {
                this.mListener.onScrollToBottom();
            }
            int i5 = this.mLastY;
            if (i5 == -100) {
                this.mLastY = i2;
                this.mListener.onScrollChanged(i2, i4, i5, height, computeVerticalScrollRange);
            } else if (Math.abs(i2 - i5) > height) {
                int i6 = this.mLastY;
                this.mLastY = i2;
                this.mListener.onScrollChanged(i2, i4, i6, height, computeVerticalScrollRange);
            }
        }
    }

    public void setFLowListener(FlowListener flowListener) {
        this.mListener = flowListener;
    }
}
