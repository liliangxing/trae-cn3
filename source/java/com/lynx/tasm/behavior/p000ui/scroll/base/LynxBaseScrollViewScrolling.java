package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseScrollViewScrolling extends FrameLayout implements LynxBaseScrollViewPublic {
    public static final int SCROLL_STATE_ANIMATING = 2;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_FLING = 3;
    public static final int SCROLL_STATE_IDLE = 0;
    protected final int[] mContentSize;
    private boolean mEnableBounces;
    private boolean mEnableScroll;
    public int mHeight;
    public boolean mIsVertical;
    private LynxBaseScrollViewScroller.ScrollFinishedCallback mProgrammaticallyScrollFinishedCallback;
    protected ScrollDelegate mScrollDelegate;
    protected LynxBaseScrollViewScroller mScrollHelper;
    protected int mScrollState;
    public int mWidth;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ScrollDelegate {
        void onScrollStateChanged(int i, int i2);

        void scrollViewDidScroll(LynxBaseScrollViewScrolling lynxBaseScrollViewScrolling);
    }

    public LynxBaseScrollViewScrolling(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mEnableBounces = true;
        this.mIsVertical = true;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mEnableScroll = true;
        this.mContentSize = new int[2];
        this.mScrollState = 0;
        this.mScrollHelper = new LynxBaseScrollViewScroller(context);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public void enableScroll(boolean z) {
        this.mEnableScroll = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public boolean scrollEnabled() {
        return this.mEnableScroll;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public void stopScrolling() {
        this.mScrollHelper.stopAnimating(false);
        this.mScrollHelper.stopAutoScroll();
        tryToUpdateScrollState(0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public int[] getScrollOffset() {
        return new int[]{getScrollX(), getScrollY()};
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void setScrollContentSize(int[] iArr) {
        if (this.mIsVertical) {
            setScrollContentSizeVertically(iArr[1]);
        } else {
            setScrollContentSizeHorizontally(iArr[0]);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void scrollByUnlimited(int[] iArr) {
        if (this.mIsVertical) {
            scrollByUnlimitedVertically(iArr[1]);
        } else {
            scrollByUnlimitedHorizontally(iArr[0]);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void scrollBy(int[] iArr) {
        if (this.mIsVertical) {
            scrollByVertically(iArr[1]);
        } else {
            scrollByHorizontally(iArr[0]);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void scrollToUnlimited(int[] iArr) {
        if (this.mIsVertical) {
            scrollToUnlimitedVertically(iArr[1]);
        } else {
            scrollToUnlimitedHorizontally(iArr[0]);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void scrollTo(int[] iArr) {
        if (this.mIsVertical) {
            scrollToVertically(iArr[1]);
        } else {
            scrollToHorizontally(iArr[0]);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void animatedScrollTo(int[] iArr, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        if (this.mIsVertical) {
            animatedScrollToVertically(iArr[1], scrollFinishedCallback);
        } else {
            animatedScrollToHorizontally(iArr[0], scrollFinishedCallback);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public void animatedScrollToUnlimited(int[] iArr, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        if (this.mIsVertical) {
            animatedScrollToUnlimitedVertically(iArr[1], scrollFinishedCallback);
        } else {
            animatedScrollToUnlimitedHorizontally(iArr[0], scrollFinishedCallback);
        }
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public int[] getScrollRange() {
        int[] scrollRangeHorizontally = getScrollRangeHorizontally();
        int[] scrollRangeVertically = getScrollRangeVertically();
        return new int[]{scrollRangeHorizontally[0], scrollRangeHorizontally[1], scrollRangeVertically[0], scrollRangeVertically[1]};
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public boolean canScrollForwards() {
        return this.mIsVertical ? canScrollForwardsVertically() : canScrollForwardsHorizontally();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewAuto
    public boolean canScrollBackwards() {
        return this.mIsVertical ? canScrollBackwardsVertically() : canScrollBackwardsHorizontally();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public int getScrollOffsetHorizontally() {
        return getScrollX();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void setScrollContentSizeHorizontally(int i) {
        int[] iArr = this.mContentSize;
        iArr[0] = i;
        iArr[1] = this.mHeight;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void scrollByUnlimitedHorizontally(int i) {
        scrollToUnlimitedHorizontally(getScrollX() + i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void scrollByHorizontally(int i) {
        scrollToHorizontally(getScrollX() + i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void scrollToUnlimitedHorizontally(int i) {
        scrollTo(i, getScrollY());
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void scrollToHorizontally(int i) {
        int[] scrollRangeHorizontally = getScrollRangeHorizontally();
        scrollToUnlimitedHorizontally(Math.min(Math.max(i, scrollRangeHorizontally[0]), scrollRangeHorizontally[1]));
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void animatedScrollToHorizontally(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        int[] scrollRangeHorizontally = getScrollRangeHorizontally();
        animatedScrollToUnlimitedHorizontally(Math.min(Math.max(i, scrollRangeHorizontally[0]), scrollRangeHorizontally[1]), scrollFinishedCallback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public void animatedScrollToUnlimitedHorizontally(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        this.mScrollHelper.animatedScrollTo(i, getScrollY(), new LynxBaseScrollViewScroller.ScrollFinishedCallback() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScrolling.1
            @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
            public void finished(boolean z) {
                if (z) {
                    LynxBaseScrollViewScrolling.this.tryToUpdateScrollState(0);
                    LynxBaseScrollViewScrolling.this.updateProgrammaticallyScrollFinishedCallback(null);
                }
            }
        });
        tryToUpdateScrollState(2);
        updateProgrammaticallyScrollFinishedCallback(scrollFinishedCallback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public int[] getScrollRangeHorizontally() {
        return new int[]{0, Math.max(0, this.mContentSize[0] - this.mWidth)};
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public boolean canScrollForwardsHorizontally() {
        return getScrollOffsetHorizontally() < getScrollRangeHorizontally()[1];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewHorizontal
    public boolean canScrollBackwardsHorizontally() {
        return getScrollOffsetHorizontally() > getScrollRangeHorizontally()[0];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public int getScrollOffsetVertically() {
        return getScrollY();
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void setScrollContentSizeVertically(int i) {
        int[] iArr = this.mContentSize;
        iArr[0] = this.mWidth;
        iArr[1] = i;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void scrollByUnlimitedVertically(int i) {
        scrollToUnlimitedVertically(getScrollY() + i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void scrollByVertically(int i) {
        scrollToVertically(getScrollY() + i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void scrollToUnlimitedVertically(int i) {
        scrollTo(getScrollX(), i);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void scrollToVertically(int i) {
        int[] scrollRangeVertically = getScrollRangeVertically();
        scrollToUnlimitedVertically(Math.min(Math.max(i, scrollRangeVertically[0]), scrollRangeVertically[1]));
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void animatedScrollToVertically(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        int[] scrollRangeVertically = getScrollRangeVertically();
        animatedScrollToUnlimitedVertically(Math.min(Math.max(i, scrollRangeVertically[0]), scrollRangeVertically[1]), scrollFinishedCallback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public void animatedScrollToUnlimitedVertically(int i, LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        this.mScrollHelper.animatedScrollTo(getScrollX(), i, new LynxBaseScrollViewScroller.ScrollFinishedCallback() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScrolling.2
            @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
            public void finished(boolean z) {
                if (z) {
                    LynxBaseScrollViewScrolling.this.tryToUpdateScrollState(0);
                    LynxBaseScrollViewScrolling.this.updateProgrammaticallyScrollFinishedCallback(null);
                }
            }
        });
        tryToUpdateScrollState(2);
        updateProgrammaticallyScrollFinishedCallback(scrollFinishedCallback);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public int[] getScrollRangeVertically() {
        return new int[]{0, Math.max(0, this.mContentSize[1] - this.mHeight)};
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public boolean canScrollForwardsVertically() {
        return getScrollOffsetVertically() < getScrollRangeVertically()[1];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewVertical
    public boolean canScrollBackwardsVertically() {
        return getScrollOffsetVertically() > getScrollRangeVertically()[0];
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public int currentScrollState() {
        return this.mScrollState;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public void enableBounces(boolean z) {
        this.mEnableBounces = z;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewPublic
    public boolean bounces() {
        return this.mEnableBounces;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void tryToUpdateScrollState(int i) {
        int i2 = this.mScrollState;
        if (i2 != i) {
            this.mScrollState = i;
            ScrollDelegate scrollDelegate = this.mScrollDelegate;
            if (scrollDelegate != null) {
                scrollDelegate.onScrollStateChanged(i2, i);
            }
        }
        if (i != 2) {
            updateProgrammaticallyScrollFinishedCallback(null);
        }
    }

    public void setScrollDelegate(ScrollDelegate scrollDelegate) {
        this.mScrollDelegate = scrollDelegate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void updateProgrammaticallyScrollFinishedCallback(LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback) {
        LynxBaseScrollViewScroller.ScrollFinishedCallback scrollFinishedCallback2 = this.mProgrammaticallyScrollFinishedCallback;
        if (scrollFinishedCallback2 != scrollFinishedCallback) {
            if (scrollFinishedCallback2 != null) {
                scrollFinishedCallback2.finished(scrollFinishedCallback == null);
            }
            this.mProgrammaticallyScrollFinishedCallback = scrollFinishedCallback;
        }
    }
}
