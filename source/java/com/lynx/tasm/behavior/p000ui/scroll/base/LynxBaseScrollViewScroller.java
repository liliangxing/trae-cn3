package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.content.Context;
import android.view.Choreographer;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.p000ui.list.container.ListCustomScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseScrollViewScroller implements Runnable {
    public static final int NESTED_SCROLL_MODE_PARALLEL = 3;
    public static final int NESTED_SCROLL_MODE_PARENT_FIRST = 2;
    public static final int NESTED_SCROLL_MODE_SELF_FIRST = 1;
    public static final int NESTED_SCROLL_MODE_SELF_ONLY = 0;
    protected static final int TYPE_EXTEND_BOUNCING_BACKWARDS = 2147483634;
    protected static final int TYPE_EXTEND_FLING = 2147483632;
    protected final ListCustomScroller mProgrammaticScroller;
    private ScrollFinishedCallback mScrollFinishedCallback;
    protected LynxBaseScrollViewNestedInternal scrollView;
    private int mScrollType = 1;
    private int mAutoScrollRate = 0;
    private LynxAutoScrollFrameCallback mAutoScrollCallback = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ScrollFinishedCallback {
        void finished(boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class LynxAutoScrollFrameCallback implements Choreographer.FrameCallback {
        LynxAutoScrollFrameCallback() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j) {
            if (LynxBaseScrollViewScroller.this.mAutoScrollRate >= 0 ? LynxBaseScrollViewScroller.this.scrollView.canScrollForwards() : LynxBaseScrollViewScroller.this.scrollView.canScrollBackwards()) {
                LynxBaseScrollViewScroller.this.scrollView.scrollBy(new int[]{LynxBaseScrollViewScroller.this.mAutoScrollRate, LynxBaseScrollViewScroller.this.mAutoScrollRate});
                if (LynxBaseScrollViewScroller.this.mAutoScrollCallback != null) {
                    Choreographer.getInstance().postFrameCallback(LynxBaseScrollViewScroller.this.mAutoScrollCallback);
                    return;
                }
                return;
            }
            LynxBaseScrollViewScroller.this.stopAutoScroll();
        }
    }

    public LynxBaseScrollViewScroller(Context context) {
        this.mProgrammaticScroller = new ListCustomScroller(context, new Interpolator() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                float f2 = f - 1.0f;
                return (f2 * f2 * f2 * f2 * f2) + 1.0f;
            }
        });
    }

    private void startAutoScrollInternal(int i) {
        stopAutoScroll();
        this.mAutoScrollRate = i;
        this.mAutoScrollCallback = new LynxAutoScrollFrameCallback();
        Choreographer.getInstance().postFrameCallback(this.mAutoScrollCallback);
    }

    public void stopAutoScroll() {
        if (this.mAutoScrollCallback != null) {
            Choreographer.getInstance().removeFrameCallback(this.mAutoScrollCallback);
            this.mAutoScrollCallback = null;
        }
    }

    public boolean tryBouncesBack(LynxBaseScrollViewNestedInternal lynxBaseScrollViewNestedInternal, boolean z, ScrollFinishedCallback scrollFinishedCallback) {
        if (lynxBaseScrollViewNestedInternal.bounces()) {
            int scrollOffsetVertically = z ? lynxBaseScrollViewNestedInternal.getScrollOffsetVertically() : lynxBaseScrollViewNestedInternal.getScrollOffsetHorizontally();
            int[] scrollRangeVertically = z ? lynxBaseScrollViewNestedInternal.getScrollRangeVertically() : lynxBaseScrollViewNestedInternal.getScrollRangeHorizontally();
            if (lynxBaseScrollViewNestedInternal.isBouncingForwards(scrollOffsetVertically, scrollRangeVertically)) {
                bouncesBack(lynxBaseScrollViewNestedInternal, -10000, scrollOffsetVertically, scrollRangeVertically, z, scrollFinishedCallback);
                return true;
            }
            if (!lynxBaseScrollViewNestedInternal.isBouncingBackwards(scrollOffsetVertically, scrollRangeVertically)) {
                return false;
            }
            bouncesBack(lynxBaseScrollViewNestedInternal, 10000, scrollOffsetVertically, scrollRangeVertically, z, scrollFinishedCallback);
            return true;
        }
        LynxBaseScrollViewNestedInternal nestedScrollingParentForType = lynxBaseScrollViewNestedInternal.getNestedScrollingParentForType(1);
        if (nestedScrollingParentForType != null) {
            return tryBouncesBack(nestedScrollingParentForType, z, scrollFinishedCallback);
        }
        return false;
    }

    private void bouncesBack(LynxBaseScrollViewInternal lynxBaseScrollViewInternal, int i, int i2, int[] iArr, boolean z, ScrollFinishedCallback scrollFinishedCallback) {
        stopAnimating(false);
        lynxBaseScrollViewInternal.startNestedScroll(getNestedScrollAxis(), 1);
        int scrollOffsetVertically = z ? lynxBaseScrollViewInternal.getScrollOffsetVertically() : lynxBaseScrollViewInternal.getScrollOffsetHorizontally();
        int[] scrollRangeVertically = z ? lynxBaseScrollViewInternal.getScrollRangeVertically() : lynxBaseScrollViewInternal.getScrollRangeHorizontally();
        this.mScrollFinishedCallback = scrollFinishedCallback;
        if (i >= 0) {
            this.mProgrammaticScroller.fling(lynxBaseScrollViewInternal.getScrollX(), lynxBaseScrollViewInternal.getScrollY(), z ? 0 : i, z ? i : 0, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, (-scrollOffsetVertically) - scrollRangeVertically[0], 0);
        } else {
            this.mProgrammaticScroller.fling(lynxBaseScrollViewInternal.getScrollX(), lynxBaseScrollViewInternal.getScrollY(), z ? 0 : i, z ? i : 0, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, 0, scrollOffsetVertically - scrollRangeVertically[1]);
        }
        this.mScrollType = TYPE_EXTEND_BOUNCING_BACKWARDS;
        postOnAnimationCompat();
    }

    public void autoScrollTo(int i, boolean z, ScrollFinishedCallback scrollFinishedCallback) {
        stopAnimating(false);
        startAutoScrollInternal(i);
        this.mScrollFinishedCallback = scrollFinishedCallback;
    }

    public void animatedScrollTo(int i, int i2, ScrollFinishedCallback scrollFinishedCallback) {
        stopAnimating(false);
        this.mProgrammaticScroller.startScroll(this.scrollView.getScrollX(), this.scrollView.getScrollY(), i - this.scrollView.getScrollX(), i2 - this.scrollView.getScrollY());
        this.mScrollFinishedCallback = scrollFinishedCallback;
        this.mScrollType = 1;
        postOnAnimationCompat();
    }

    public void fling(int i, int i2, ScrollFinishedCallback scrollFinishedCallback) {
        int i3;
        int i4;
        int i5;
        int i6;
        int backwardNestedScrollMode;
        stopAnimating(false);
        this.scrollView.startNestedScroll(getNestedScrollAxis(), 1);
        int[] scrollOffset = this.scrollView.getScrollOffset();
        this.scrollView.getScrollRange();
        boolean isVertical = this.scrollView.isVertical();
        this.mScrollFinishedCallback = scrollFinishedCallback;
        int i7 = scrollOffset[0];
        int i8 = scrollOffset[1];
        int[] calculateMaxFlingDistance = calculateMaxFlingDistance(this.scrollView, !isVertical ? i <= 0 : i2 <= 0, isVertical);
        if (this.scrollView.hasNestedScrollingParent(1)) {
            LynxBaseScrollViewNestedInternal nestedScrollingParentForType = this.scrollView.getNestedScrollingParentForType(1);
            int i9 = isVertical ? i2 : i;
            if (i9 != 0 && (nestedScrollingParentForType instanceof LynxBaseScrollViewNestedInternal)) {
                LynxBaseScrollView lynxBaseScrollView = (LynxBaseScrollView) nestedScrollingParentForType;
                int[] calculateMaxFlingDistance2 = calculateMaxFlingDistance(nestedScrollingParentForType, !lynxBaseScrollView.isVertical() ? i <= 0 : i2 <= 0, lynxBaseScrollView.isVertical());
                if (i9 > 0) {
                    backwardNestedScrollMode = this.scrollView.getForwardNestedScrollMode();
                } else {
                    backwardNestedScrollMode = this.scrollView.getBackwardNestedScrollMode();
                }
                if (backwardNestedScrollMode == 3) {
                    calculateMaxFlingDistance[0] = Math.min(calculateMaxFlingDistance[0], calculateMaxFlingDistance2[0]);
                    calculateMaxFlingDistance[1] = Math.max(calculateMaxFlingDistance[1], calculateMaxFlingDistance2[1]);
                }
            }
        }
        if (isVertical) {
            int i10 = calculateMaxFlingDistance[0];
            int i11 = scrollOffset[1];
            i4 = i10 + i11;
            i5 = calculateMaxFlingDistance[1] + i11;
            i6 = i7;
            i3 = i6;
        } else {
            int i12 = calculateMaxFlingDistance[0];
            int i13 = scrollOffset[0];
            i3 = calculateMaxFlingDistance[1] + i13;
            i4 = i8;
            i5 = i4;
            i6 = i12 + i13;
        }
        this.mProgrammaticScroller.fling(this.scrollView.getScrollX(), this.scrollView.getScrollY(), i, i2, i6, i3, i4, i5);
        this.mScrollType = TYPE_EXTEND_FLING;
        postOnAnimationCompat();
    }

    private int[] calculateMaxFlingDistance(LynxBaseScrollViewNestedInternal lynxBaseScrollViewNestedInternal, boolean z, boolean z2) {
        int[] flingRange = lynxBaseScrollViewNestedInternal.getFlingRange(z2);
        int scrollOffsetVertically = z2 ? lynxBaseScrollViewNestedInternal.getScrollOffsetVertically() : lynxBaseScrollViewNestedInternal.getScrollOffsetHorizontally();
        LynxBaseScrollViewNestedInternal nestedScrollingParentForType = lynxBaseScrollViewNestedInternal.getNestedScrollingParentForType(1);
        int forwardNestedScrollMode = z ? lynxBaseScrollViewNestedInternal.getForwardNestedScrollMode() : lynxBaseScrollViewNestedInternal.getBackwardNestedScrollMode();
        if (forwardNestedScrollMode != 1) {
            if (forwardNestedScrollMode != 2) {
                if (forwardNestedScrollMode == 3 && nestedScrollingParentForType != null) {
                    int[] calculateMaxFlingDistance = calculateMaxFlingDistance(nestedScrollingParentForType, z, z2);
                    flingRange[0] = Math.max(flingRange[0], calculateMaxFlingDistance[0]);
                    flingRange[1] = Math.max(flingRange[1], calculateMaxFlingDistance[1]);
                }
            } else if (nestedScrollingParentForType != null) {
                int[] calculateMaxFlingDistance2 = calculateMaxFlingDistance(nestedScrollingParentForType, z, z2);
                flingRange[0] = flingRange[0] + calculateMaxFlingDistance2[0];
                flingRange[1] = flingRange[1] + calculateMaxFlingDistance2[1];
            }
        } else if (nestedScrollingParentForType != null) {
            int[] calculateMaxFlingDistance3 = calculateMaxFlingDistance(nestedScrollingParentForType, z, z2);
            flingRange[0] = flingRange[0] + calculateMaxFlingDistance3[0];
            flingRange[1] = flingRange[1] + calculateMaxFlingDistance3[1];
        }
        return new int[]{flingRange[0] - scrollOffsetVertically, flingRange[1] - scrollOffsetVertically};
    }

    public void stopAnimating(boolean z) {
        this.scrollView.getView().removeCallbacks(this);
        this.mProgrammaticScroller.abortAnimation();
        ScrollFinishedCallback scrollFinishedCallback = this.mScrollFinishedCallback;
        if (scrollFinishedCallback != null) {
            this.mScrollFinishedCallback = null;
            scrollFinishedCallback.finished(z);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mProgrammaticScroller.computeScrollOffset()) {
            boolean isVertical = this.scrollView.isVertical();
            this.scrollView.dispatchScroll(isVertical ? 0 : this.mProgrammaticScroller.getCurrX() - this.mProgrammaticScroller.getPreviousX(), isVertical ? this.mProgrammaticScroller.getCurrY() - this.mProgrammaticScroller.getPreviousY() : 0, this.mScrollType, null, null);
            postOnAnimationCompat();
            return;
        }
        stopAnimating(true);
    }

    private void postOnAnimationCompat() {
        this.scrollView.getView().removeCallbacks(this);
        ViewCompat.postOnAnimation(this.scrollView.getView(), this);
    }

    private int getNestedScrollAxis() {
        return this.scrollView.isVertical() ? 2 : 1;
    }
}
