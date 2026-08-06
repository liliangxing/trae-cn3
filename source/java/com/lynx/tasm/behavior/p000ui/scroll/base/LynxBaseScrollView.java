package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.lynx.tasm.behavior.p000ui.IDrawChildHook;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseScrollView extends LynxBaseScrollViewNested implements IDrawChildHook.IDrawChildHookBinding {
    private IDrawChildHook mDrawChildHook;
    private boolean mLayoutFromEnd;

    public void setFooter(View view) {
    }

    public void setHeader(View view) {
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook.IDrawChildHookBinding
    public void bindDrawChildHook(IDrawChildHook iDrawChildHook) {
        this.mDrawChildHook = iDrawChildHook;
    }

    public LynxBaseScrollView(Context context) {
        this(context, null);
    }

    public LynxBaseScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LynxBaseScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLayoutFromEnd = false;
        setNestedScrollingEnabled(true);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return !LynxBaseScrollView.this.scrollEnabled();
            }
        });
    }

    private void scrollByWithLefts(int i, int i2, int[] iArr) {
        if (this.mIsVertical) {
            int scrollOffsetVertically = getScrollOffsetVertically() + i2;
            int[] scrollRangeVertically = getScrollRangeVertically();
            int min = Math.min(Math.max(scrollOffsetVertically, scrollRangeVertically[0]), scrollRangeVertically[1]);
            scrollToUnlimitedVertically(min);
            iArr[0] = 0;
            iArr[1] = scrollOffsetVertically - min;
            return;
        }
        int scrollOffsetHorizontally = getScrollOffsetHorizontally() + i;
        int[] scrollRangeHorizontally = getScrollRangeHorizontally();
        int min2 = Math.min(Math.max(scrollOffsetHorizontally, scrollRangeHorizontally[0]), scrollRangeHorizontally[1]);
        scrollToUnlimitedHorizontally(min2);
        iArr[0] = scrollOffsetHorizontally - min2;
        iArr[1] = 0;
    }

    public void setForwardNestedScrollMode(int i) {
        this.mForwardNestedScrollMode = i;
    }

    public void setBackwardNestedScrollMode(int i) {
        this.mBackwardNestedScrollMode = i;
    }

    public void setVertical(boolean z) {
        this.mIsVertical = z;
    }

    public void setLayoutFromEnd(boolean z) {
        this.mLayoutFromEnd = z;
    }

    public boolean isLayoutFromEnd() {
        return this.mLayoutFromEnd;
    }

    public void autoScrollWithRate(int i, boolean z, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        tryToUpdateScrollState(2);
        updateProgrammaticallyScrollFinishedCallback(scrollFinishedCallback);
        this.mScrollHelper.autoScrollTo(i, z, scrollFinishedCallback);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.mScrollDelegate.scrollViewDidScroll(this);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IDrawChildHook iDrawChildHook;
        if (getRootView().isLayoutRequested() || (iDrawChildHook = this.mDrawChildHook) == null) {
            return;
        }
        iDrawChildHook.performLayoutChildrenUI();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        IDrawChildHook iDrawChildHook;
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
        if (getRootView().isLayoutRequested() || (iDrawChildHook = this.mDrawChildHook) == null) {
            return;
        }
        iDrawChildHook.performMeasureChildrenUI();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        if (iDrawChildHook != null) {
            iDrawChildHook.beforeDispatchDraw(canvas);
        }
        super.dispatchDraw(canvas);
        IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
        if (iDrawChildHook2 != null) {
            iDrawChildHook2.afterDispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        boolean drawChild;
        IDrawChildHook iDrawChildHook = this.mDrawChildHook;
        Rect beforeDrawChild = iDrawChildHook != null ? iDrawChildHook.beforeDrawChild(canvas, view, j) : null;
        if (beforeDrawChild != null) {
            canvas.save();
            canvas.clipRect(beforeDrawChild);
            drawChild = super.drawChild(canvas, view, j);
            canvas.restore();
        } else {
            drawChild = super.drawChild(canvas, view, j);
        }
        IDrawChildHook iDrawChildHook2 = this.mDrawChildHook;
        if (iDrawChildHook2 != null) {
            iDrawChildHook2.afterDrawChild(canvas, view, j);
        }
        return drawChild;
    }
}
