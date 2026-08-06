package com.lynx.tasm.behavior.ui.list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.ui.view.AndroidView;
import com.lynx.tasm.behavior.ui.view.UIComponent;

/* loaded from: classes7.dex */
public class ListViewHolder extends RecyclerView.ViewHolder {
    static final int COMPONENT_LAYOUT_EFFECT = 3;
    static final int COMPONENT_LAYOUT_FINISH = 2;
    static final int COMPONENT_LAYOUT_INIT = 0;
    static final int COMPONENT_LAYOUT_REUSE = 1;
    final WrapView mRootView;
    protected long operationID;

    /* loaded from: classes7.dex */
    interface MeasureListener {
        void onMeasureCompleted(String str, int i, int i2);
    }

    public ListViewHolder(WrapView wrapView) {
        super(wrapView);
        this.operationID = 0L;
        this.mRootView = wrapView;
    }

    public void setEstimatedHeight(int i) {
        if (i > 0) {
            this.mRootView.mEstimatedHeight = i;
        }
    }

    public void setEstimatedWidth(int i) {
        if (i > 0) {
            this.mRootView.mEstimatedWidth = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [android.view.View] */
    public void setUIComponent(UIComponent uIComponent) {
        this.mRootView.mUIComponent = uIComponent;
        this.mRootView.addView((View) uIComponent.getView(), new FrameLayout.LayoutParams(-1, -2));
        this.mRootView.mAdapterPosition = getAdapterPosition();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeUIComponent() {
        if (this.mRootView.mUIComponent != null) {
            String itemKey = this.mRootView.mUIComponent.getItemKey();
            try {
                this.mRootView.removeAllViews();
            } catch (NullPointerException e) {
                LLog.e(UIList.TAG, "ListViewHolder removeUIComponent.the itemKey is " + itemKey + " errorMessage:" + e.getMessage());
            }
            this.mRootView.mUIComponent = null;
        }
    }

    public UIComponent getUIComponent() {
        return this.mRootView.mUIComponent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class WrapView extends FrameLayout {
        protected int mAdapterPosition;
        private boolean mComponentInitMeasure;
        private int mDirection;
        private int mEstimatedHeight;
        private int mEstimatedWidth;
        int mLayoutStatus;
        int mMainAxisGap;
        private MeasureListener mMeasureListener;
        private UIComponent mUIComponent;

        public WrapView(Context context) {
            super(context);
            this.mLayoutStatus = 0;
            this.mEstimatedHeight = 400;
            this.mEstimatedWidth = -1;
            this.mComponentInitMeasure = false;
            this.mMainAxisGap = 0;
            this.mDirection = 0;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void setMeasureListener(MeasureListener measureListener) {
            this.mMeasureListener = measureListener;
        }

        @Override // android.view.View
        public void setLayoutDirection(int i) {
            this.mDirection = i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public MeasureListener getMeasureListener() {
            return this.mMeasureListener;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public UIComponent getUIComponent() {
            return this.mUIComponent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.widget.FrameLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            int measuredWidth;
            int measuredHeight;
            UIComponent uIComponent;
            if (this.mLayoutStatus == 0) {
                measuredWidth = this.mEstimatedWidth;
                if (measuredWidth <= 0) {
                    measuredWidth = View.MeasureSpec.getSize(i);
                }
                measuredHeight = this.mEstimatedHeight;
                if (this.mComponentInitMeasure && (uIComponent = this.mUIComponent) != null && uIComponent.getView() != 0 && ((AndroidView) this.mUIComponent.getView()).isLayoutRequested()) {
                    this.mUIComponent.measureChildren();
                }
            } else {
                UIComponent uIComponent2 = this.mUIComponent;
                if (uIComponent2 != null) {
                    uIComponent2.measure();
                    if (2 == this.mLayoutStatus) {
                        this.mLayoutStatus = 3;
                    }
                    measuredWidth = this.mUIComponent.getMarginRight() + this.mUIComponent.getWidth() + this.mUIComponent.getMarginLeft();
                    measuredHeight = this.mUIComponent.getHeight() + this.mUIComponent.getMarginTop() + this.mUIComponent.getMarginBottom() + this.mMainAxisGap;
                    MeasureListener measureListener = this.mMeasureListener;
                    if (measureListener != null) {
                        measureListener.onMeasureCompleted(this.mUIComponent.getItemKey(), measuredWidth, measuredHeight);
                    }
                } else {
                    measuredWidth = getMeasuredWidth();
                    measuredHeight = getMeasuredHeight();
                }
            }
            setMeasuredDimension(measuredWidth, measuredHeight);
            if (UIList.DEBUG) {
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(this.mAdapterPosition);
                UIComponent uIComponent3 = this.mUIComponent;
                objArr[1] = uIComponent3 != null ? uIComponent3.getItemKey() : "";
                objArr[2] = Integer.valueOf(getMeasuredWidth());
                objArr[3] = Integer.valueOf(getMeasuredHeight());
                objArr[4] = Integer.valueOf(this.mLayoutStatus);
                LLog.i(UIList.TAG, String.format("WrapView.onMeasure: position=%d, itemKey=%s, measuredSize=(w %d, h %d), mLayoutStatus=%d", objArr));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v12, types: [android.view.View] */
        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            if (UIList.DEBUG) {
                Object[] objArr = new Object[7];
                objArr[0] = Integer.valueOf(this.mAdapterPosition);
                UIComponent uIComponent = this.mUIComponent;
                objArr[1] = uIComponent != null ? uIComponent.getItemKey() : "";
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(i2);
                objArr[4] = Integer.valueOf(i3);
                objArr[5] = Integer.valueOf(i4);
                objArr[6] = Integer.valueOf(this.mLayoutStatus);
                LLog.i(UIList.TAG, String.format("WrapView.onLayout: position=%d, itemKey=%s, layout=(l %d, t %d, r %d, b %d), mLayoutStatus=%d", objArr));
            }
            UIComponent uIComponent2 = this.mUIComponent;
            if (uIComponent2 != null) {
                uIComponent2.setTop(0);
                this.mUIComponent.setLeft(0);
                this.mUIComponent.layout();
                int marginLeft = this.mUIComponent.getMarginLeft();
                int marginTop = this.mUIComponent.getMarginTop();
                int width = this.mUIComponent.getWidth();
                int height = this.mUIComponent.getHeight();
                int i5 = this.mDirection == 1 ? (i3 - i) - width : 0;
                ((AndroidView) this.mUIComponent.getView()).layout(marginLeft + i5, marginTop, marginLeft + width + i5, height + marginTop);
                if (this.mUIComponent.getOverflow() != 0 && getParent() != null) {
                    ((ViewGroup) getParent()).setClipChildren(false);
                }
                Rect clipBounds = ViewCompat.getClipBounds(this.mUIComponent.getView());
                if (clipBounds != null) {
                    clipBounds.set(Math.min(clipBounds.left, i), Math.min(clipBounds.top, i2), Math.max(clipBounds.right, i3), Math.max(clipBounds.bottom, i4));
                    ViewCompat.setClipBounds(this, clipBounds);
                }
            }
        }

        public void setComponentInitMeasure(boolean z) {
            this.mComponentInitMeasure = z;
        }
    }
}
