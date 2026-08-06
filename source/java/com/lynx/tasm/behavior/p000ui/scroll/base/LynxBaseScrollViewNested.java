package com.lynx.tasm.behavior.p000ui.scroll.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewScroller;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxBaseScrollViewNested extends LynxBaseScrollViewDragging implements LynxBaseScrollViewNestedInternal {
    protected int mBackwardNestedScrollMode;
    protected int mForwardNestedScrollMode;
    public final LynxNestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;

    public LynxBaseScrollViewNested(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mForwardNestedScrollMode = 0;
        this.mBackwardNestedScrollMode = 0;
        this.mNestedScrollingChildHelper = new LynxNestedScrollingChildHelper(this);
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mScrollHelper.scrollView = this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    public boolean hasNestedScrollingParent(int i) {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent(i);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewDragging, com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public boolean startNestedScroll(int i, int i2) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i, i2);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return startNestedScroll(i, 0);
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewDragging, com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public void stopNestedScroll(int i) {
        this.mNestedScrollingChildHelper.stopNestedScroll(i);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return dispatchNestedScroll(i, i2, i3, i4, iArr, 0);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i, i2, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return this.mIsVertical ? (i & 2) != 0 : (i & 1) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return onStartNestedScroll(view, view2, i, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i, i2);
        if (this.mIsVertical) {
            startNestedScroll(2, i2);
        } else {
            startNestedScroll(1, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        onNestedScrollAccepted(view, view2, i, 0);
    }

    public void onStopNestedScroll(View view, int i) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view, i);
        stopNestedScroll(i);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        int[] dispatchScroll = dispatchScroll(this.mIsVertical ? 0 : i, this.mIsVertical ? i2 : 0, i3, null, null);
        iArr[0] = i - dispatchScroll[0];
        iArr[1] = i2 - dispatchScroll[1];
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        onNestedPreScroll(view, i, i2, iArr, 0);
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        dispatchScroll(this.mIsVertical ? 0 : i3, this.mIsVertical ? i4 : 0, i5, null, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        onNestedScroll(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        return flingWithNestedDispatch((int) f, (int) f2);
    }

    @Override // android.view.ViewGroup, com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    private boolean flingWithNestedDispatch(int i, int i2) {
        if (this.mIsVertical || Math.abs(i) < this.mConfig.minFlingVelocity) {
            i = 0;
        }
        if (!this.mIsVertical || Math.abs(i2) < this.mConfig.minFlingVelocity) {
            i2 = 0;
        }
        if (i == 0 && i2 == 0) {
            return false;
        }
        float f = i;
        float f2 = i2;
        if (dispatchNestedPreFling(f, f2)) {
            return false;
        }
        dispatchNestedFling(f, f2, true);
        startNestedScroll(getNestedScrollAxis(), 1);
        int max = Math.max(-this.mConfig.maxFlingVelocity, Math.min(i, this.mConfig.maxFlingVelocity));
        int max2 = Math.max(-this.mConfig.maxFlingVelocity, Math.min(i2, this.mConfig.maxFlingVelocity));
        tryToUpdateScrollState(3);
        this.mScrollHelper.fling(max, max2, new LynxBaseScrollViewScroller.ScrollFinishedCallback() { // from class: com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewNested.1
            @Override // com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollViewScroller.ScrollFinishedCallback
            public void finished(boolean z) {
                if (z) {
                    LynxBaseScrollViewNested.this.tryToUpdateScrollState(0);
                }
            }
        });
        return true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.mIsVertical || i == 0) {
            return false;
        }
        int scrollOffsetHorizontally = getScrollOffsetHorizontally();
        int[] scrollRangeHorizontally = getScrollRangeHorizontally();
        boolean z = i > 0;
        int forwardNestedScrollMode = z ? getForwardNestedScrollMode() : this.mBackwardNestedScrollMode;
        if (forwardNestedScrollMode == 0) {
            return true;
        }
        if (forwardNestedScrollMode != 1 && forwardNestedScrollMode != 2 && forwardNestedScrollMode != 3) {
            return super.canScrollHorizontally(i);
        }
        if (z) {
            if (scrollRangeHorizontally[1] <= scrollOffsetHorizontally + 1) {
                return false;
            }
        } else if (scrollOffsetHorizontally - 1 <= scrollRangeHorizontally[0]) {
            return false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        if (!this.mIsVertical || i == 0) {
            return false;
        }
        int scrollOffsetVertically = getScrollOffsetVertically();
        int[] scrollRangeVertically = getScrollRangeVertically();
        boolean z = i > 0;
        int i2 = z ? this.mForwardNestedScrollMode : this.mBackwardNestedScrollMode;
        if (i2 == 0) {
            return true;
        }
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            return super.canScrollVertically(i);
        }
        if (z) {
            if (scrollRangeVertically[1] <= scrollOffsetVertically + 1) {
                return false;
            }
        } else if (scrollOffsetVertically - 1 <= scrollRangeVertically[0]) {
            return false;
        }
        return true;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getForwardNestedScrollMode() {
        return this.mForwardNestedScrollMode;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewNestedInternal
    public int getBackwardNestedScrollMode() {
        return this.mBackwardNestedScrollMode;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewNestedInternal
    public LynxBaseScrollViewNestedInternal getNestedScrollingParentForType(int i) {
        ViewParent nestedScrollingParentForType = this.mNestedScrollingChildHelper.getNestedScrollingParentForType(i);
        if (nestedScrollingParentForType instanceof LynxBaseScrollViewNestedInternal) {
            return (LynxBaseScrollViewNestedInternal) nestedScrollingParentForType;
        }
        return null;
    }

    @Override // com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewDragging, com.lynx.tasm.behavior.p000ui.scroll.base.LynxBaseScrollViewInternal
    public int[] dispatchScroll(int i, int i2, int i3, MotionEvent motionEvent, int[] iArr) {
        int[] iArr2;
        int[] iArr3;
        int[] scrollOffset = getScrollOffset();
        int[] scrollRange = getScrollRange();
        int[] iArr4 = {0, 0};
        boolean z = !this.mIsVertical ? i <= 0 : i2 <= 0;
        int i4 = z ? this.mForwardNestedScrollMode : this.mBackwardNestedScrollMode;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    int[] iArr5 = new int[2];
                    int[] iArr6 = new int[2];
                    if (i3 == 2147483634 && bounces()) {
                        iArr5[0] = 0;
                        iArr5[1] = 0;
                        iArr6[0] = 0;
                        iArr6[0] = 0;
                        iArr2 = iArr6;
                        iArr3 = iArr5;
                    } else {
                        iArr2 = iArr6;
                        iArr3 = iArr5;
                        dispatchNestedPreScroll(i, i2, iArr5, iArr2, i3);
                    }
                    int i5 = i - iArr3[0];
                    int i6 = i2 - iArr3[1];
                    if (bounces()) {
                        tryBouncingThanScroll(i5, i6, z, scrollOffset, scrollRange, i3);
                    } else {
                        scrollByWithLefts(i5, i6, iArr4);
                    }
                    int[] iArr7 = new int[2];
                    if (i3 == 2147483634 && bounces()) {
                        iArr7[0] = 0;
                        iArr7[0] = 0;
                    } else {
                        int i7 = iArr4[0];
                        int i8 = iArr4[1];
                        dispatchNestedScroll(i5 - i7, i6 - i8, i7, i8, iArr7, i3);
                    }
                    if (iArr != null) {
                        iArr[0] = iArr7[0] + iArr2[0];
                        iArr[1] = iArr7[1] + iArr2[1];
                    }
                } else if (i4 == 3) {
                    int[] iArr8 = new int[2];
                    dispatchNestedPreScroll(i, i2, new int[2], iArr8, i3);
                    if (bounces()) {
                        tryBouncingThanScroll(i, i2, z, scrollOffset, scrollRange, i3);
                    } else {
                        scrollByWithLefts(i, i2, iArr4);
                    }
                    dispatchNestedScroll(i, i2, 0, 0, null, i3);
                    if (iArr != null) {
                        iArr[0] = iArr8[0];
                        iArr[1] = iArr8[1];
                    }
                }
            } else if (!bounces()) {
                dispatchNestedPreScroll(0, 0, new int[2], null, i3);
                if (i3 != 2147483634 || bounces()) {
                    scrollByWithLefts(i, i2, iArr4);
                } else {
                    iArr4[0] = i;
                    iArr4[1] = i2;
                }
                int i9 = iArr4[0];
                int i10 = iArr4[1];
                dispatchNestedScroll(i - i9, i2 - i10, i9, i10, iArr, i3);
            }
        } else if (bounces()) {
            tryBouncingThanScroll(i, i2, z, scrollOffset, scrollRange, i3);
        } else {
            scrollByWithLefts(i, i2, iArr4);
        }
        return iArr4;
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

    private int bouncingDist2TouchDist(int i, boolean z) {
        int i2 = z ? this.mHeight : this.mWidth;
        return (int) ((i * i2) / ((i2 - i) * 0.55d));
    }

    private int touchDist2BouncingDist(int i, boolean z) {
        double d = i * 0.55d;
        double d2 = z ? this.mHeight : this.mWidth;
        return (int) ((1.0d - (1.0d / ((d / d2) + 1.0d))) * d2);
    }

    private int doBounce(int i, int i2, int[] iArr, int i3, boolean z) {
        int max;
        int min;
        if (isBouncingForwards(i2, iArr)) {
            if (i >= 0) {
                if (i3 != 0 && i3 != 2147483632) {
                    if (z) {
                        scrollToUnlimitedVertically(i2 + i);
                        return 0;
                    }
                    scrollToUnlimitedHorizontally(i2 + i);
                    return 0;
                }
                int i4 = touchDist2BouncingDist(bouncingDist2TouchDist(i2 - iArr[1], z) + i, z);
                if (z) {
                    scrollToUnlimitedVertically(iArr[1] + i4);
                    return 0;
                }
                scrollToUnlimitedHorizontally(iArr[1] + i4);
                return 0;
            }
            if (i3 == 0 || i3 == 2147483632) {
                int bouncingDist2TouchDist = bouncingDist2TouchDist(i2 - iArr[1], z);
                int i5 = -i;
                int max2 = Math.max(bouncingDist2TouchDist - iArr[1], i5);
                int i6 = touchDist2BouncingDist(Math.max(bouncingDist2TouchDist + i, 0), z);
                if (z) {
                    scrollToUnlimitedVertically(iArr[1] + i6);
                } else {
                    scrollToUnlimitedHorizontally(iArr[1] + i6);
                }
                return -(i5 - max2);
            }
            min = Math.max(i2 + i, iArr[1]);
            if (z) {
                scrollToUnlimitedVertically(min);
            } else {
                scrollToUnlimitedHorizontally(min);
            }
        } else {
            if (!isBouncingBackwards(i2, iArr)) {
                return 0;
            }
            if (i <= 0) {
                if (i3 != 0 && i3 != 2147483632) {
                    if (z) {
                        scrollToUnlimitedVertically(i2 + i);
                        return 0;
                    }
                    scrollToUnlimitedHorizontally(i2 + i);
                    return 0;
                }
                int i7 = touchDist2BouncingDist(bouncingDist2TouchDist(iArr[0] - i2, z) - i, z);
                if (z) {
                    scrollToUnlimitedVertically(-i7);
                    return 0;
                }
                scrollToUnlimitedHorizontally(-i7);
                return 0;
            }
            if (i3 == 0 || i3 == 2147483632) {
                int bouncingDist2TouchDist2 = bouncingDist2TouchDist(iArr[0] - i2, z);
                max = Math.max((-bouncingDist2TouchDist2) - iArr[0], i);
                int i8 = touchDist2BouncingDist(Math.max(bouncingDist2TouchDist2 - i, 0), z);
                if (z) {
                    scrollToUnlimitedVertically(-i8);
                } else {
                    scrollToUnlimitedHorizontally(-i8);
                }
                return i - max;
            }
            min = Math.min(i2 + i, iArr[0]);
            if (z) {
                scrollToUnlimitedVertically(min);
            } else {
                scrollToUnlimitedHorizontally(min);
            }
        }
        max = min - i2;
        return i - max;
    }

    private int[] bouncing(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        int[] iArr3 = {0, 0};
        if (this.mIsVertical) {
            iArr3[1] = doBounce(i2, iArr[1], new int[]{iArr2[2], iArr2[3]}, i3, true);
        } else {
            iArr3[0] = doBounce(i, iArr[0], new int[]{iArr2[0], iArr2[1]}, i3, false);
        }
        return iArr3;
    }

    private void tryBouncingThanScroll(int i, int i2, boolean z, int[] iArr, int[] iArr2, int i3) {
        boolean isBouncingForwards;
        boolean isBouncingBackwards;
        if (this.mIsVertical) {
            isBouncingForwards = isBouncingForwards(iArr[1], new int[]{iArr2[2], iArr2[3]});
        } else {
            isBouncingForwards = isBouncingForwards(iArr[0], new int[]{iArr2[0], iArr2[1]});
        }
        if (this.mIsVertical) {
            isBouncingBackwards = isBouncingBackwards(iArr[1], new int[]{iArr2[2], iArr2[3]});
        } else {
            isBouncingBackwards = isBouncingBackwards(iArr[0], new int[]{iArr2[0], iArr2[1]});
        }
        if (isBouncingForwards) {
            if (z) {
                bouncing(i, i2, iArr, iArr2, i3);
                return;
            } else {
                int[] bouncing = bouncing(i, i2, iArr, iArr2, i3);
                scrollBy(bouncing[0], bouncing[1]);
                return;
            }
        }
        if (isBouncingBackwards) {
            if (!z) {
                bouncing(i, i2, iArr, iArr2, i3);
                return;
            } else {
                int[] bouncing2 = bouncing(i, i2, iArr, iArr2, i3);
                scrollBy(bouncing2[0], bouncing2[1]);
                return;
            }
        }
        if (i3 != 2147483634) {
            scrollBy(i, i2);
            int[] scrollOffset = getScrollOffset();
            bouncing(i - (scrollOffset[0] - iArr[0]), i2 - (scrollOffset[1] - iArr[1]), iArr, iArr2, i3);
        }
    }
}
