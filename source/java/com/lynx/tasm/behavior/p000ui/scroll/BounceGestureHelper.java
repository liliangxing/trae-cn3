package com.lynx.tasm.behavior.p000ui.scroll;

import android.view.MotionEvent;
import android.view.View;
import android.widget.OverScroller;
import androidx.core.view.NestedScrollingParentHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BounceGestureHelper {
    private static final boolean DEBUG = false;
    private static final String TAG = "BounceGestureHelper";
    private int mBounceScrollRange;
    private boolean mHasTriggerEndBounce;
    private boolean mHasTriggerStartBounce;
    private boolean mIsVertical;
    private final NestedScrollingParentHelper mParentHelper;
    private int mScrollRange;
    private final View mView;

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public BounceGestureHelper(View view, boolean z, NestedScrollingParentHelper nestedScrollingParentHelper) {
        this.mView = view;
        this.mIsVertical = z;
        this.mParentHelper = nestedScrollingParentHelper;
    }

    public void setBounceScrollRange(int i) {
        this.mBounceScrollRange = i;
    }

    public void setScrollRange(int i) {
        this.mScrollRange = i;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OverScroller vScroller;
        boolean z = this.mIsVertical;
        if (!z) {
            View view = this.mView;
            if (view instanceof NestedHorizontalScrollView) {
                OverScroller hScroller = ((NestedHorizontalScrollView) view).getHScroller();
                return (hScroller == null || hScroller.isFinished()) ? false : true;
            }
        }
        if (!z) {
            return false;
        }
        View view2 = this.mView;
        return (!(view2 instanceof NestedScrollView) || (vScroller = ((NestedScrollView) view2).getVScroller()) == null || vScroller.isFinished()) ? false : true;
    }

    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        return ((this.mIsVertical ? 2 : 1) & i) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i, i2);
    }

    public void onStopNestedScroll(View view, int i) {
        int scrollX = this.mView.getScrollX();
        int scrollY = this.mView.getScrollY();
        if (1 == i) {
            return;
        }
        boolean z = this.mIsVertical;
        if (!z) {
            View view2 = this.mView;
            if (view2 instanceof NestedHorizontalScrollView) {
                NestedHorizontalScrollView nestedHorizontalScrollView = (NestedHorizontalScrollView) view2;
                int i2 = this.mBounceScrollRange;
                if (scrollX != i2) {
                    nestedHorizontalScrollView.smoothScrollToInternal(i2, scrollY);
                }
                nestedHorizontalScrollView.stopNestedScroll(i);
                return;
            }
        }
        if (z) {
            View view3 = this.mView;
            if (view3 instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view3;
                int i3 = this.mBounceScrollRange;
                if (scrollY != i3) {
                    nestedScrollView.smoothScrollToInternal(scrollX, i3);
                }
                nestedScrollView.stopNestedScroll(i);
            }
        }
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr, int i3) {
        if (1 == i3) {
            return;
        }
        int scrollX = this.mView.getScrollX();
        int scrollY = this.mView.getScrollY();
        boolean z = this.mIsVertical;
        if (!z) {
            View view2 = this.mView;
            if (view2 instanceof NestedHorizontalScrollView) {
                onNestedPreScrollHorizontally((NestedHorizontalScrollView) view2, view, scrollX, scrollY, i, this.mScrollRange, this.mBounceScrollRange, iArr);
                return;
            }
        }
        if (z) {
            View view3 = this.mView;
            if (view3 instanceof NestedScrollView) {
                onNestedPreScrollVertically((NestedScrollView) view3, view, scrollX, scrollY, i2, this.mScrollRange, this.mBounceScrollRange, iArr);
            }
        }
    }

    protected void onNestedPreScrollHorizontally(NestedHorizontalScrollView nestedHorizontalScrollView, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (!view.canScrollHorizontally(-1) && i3 < 0) {
            if (i + i3 < 0) {
                nestedHorizontalScrollView.scrollTo(0, i2);
            } else {
                nestedHorizontalScrollView.requestDisallowInterceptTouchEvent(true);
                nestedHorizontalScrollView.scrollBy(i3, 0);
            }
            iArr[0] = i3;
        } else if (i < i5 && i3 > 0) {
            nestedHorizontalScrollView.requestDisallowInterceptTouchEvent(true);
            if (i + i3 > i5) {
                nestedHorizontalScrollView.scrollBy(i5 - i, 0);
            } else {
                nestedHorizontalScrollView.scrollBy(i3, 0);
            }
            iArr[0] = i3;
        }
        if (!view.canScrollHorizontally(1) && i3 > 0) {
            if (i + i3 > i4) {
                nestedHorizontalScrollView.scrollTo(i4, i2);
            } else {
                nestedHorizontalScrollView.requestDisallowInterceptTouchEvent(true);
                nestedHorizontalScrollView.scrollBy(i3, 0);
            }
            iArr[0] = i3;
            return;
        }
        if (i5 >= i || i > i4 || i3 >= 0) {
            return;
        }
        nestedHorizontalScrollView.requestDisallowInterceptTouchEvent(true);
        if (i + i3 < i5) {
            nestedHorizontalScrollView.scrollBy(i5 - i, 0);
        } else {
            nestedHorizontalScrollView.scrollBy(i3, 0);
        }
        iArr[0] = i3;
    }

    protected void onNestedPreScrollVertically(NestedScrollView nestedScrollView, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (!view.canScrollVertically(-1) && i3 < 0) {
            if (i2 + i3 < 0) {
                nestedScrollView.scrollTo(i, 0);
            } else {
                nestedScrollView.requestDisallowInterceptTouchEvent(true);
                nestedScrollView.scrollBy(0, i3);
            }
            iArr[1] = i3;
        } else if (i2 < i5 && i3 > 0) {
            nestedScrollView.requestDisallowInterceptTouchEvent(true);
            if (i2 + i3 > i5) {
                nestedScrollView.scrollBy(0, i5 - i2);
            } else {
                nestedScrollView.scrollBy(0, i3);
            }
            iArr[1] = i3;
        }
        if (!view.canScrollVertically(1) && i3 > 0) {
            if (i2 + i3 > i4) {
                nestedScrollView.scrollTo(i, i4);
            } else {
                nestedScrollView.requestDisallowInterceptTouchEvent(true);
                nestedScrollView.scrollBy(0, i3);
            }
            iArr[1] = i3;
            return;
        }
        if (i5 >= i2 || i2 > i4 || i3 >= 0) {
            return;
        }
        nestedScrollView.requestDisallowInterceptTouchEvent(true);
        if (i2 + i3 < i5) {
            nestedScrollView.scrollBy(0, i5 - i2);
        } else {
            nestedScrollView.scrollBy(0, i3);
        }
        iArr[1] = i3;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
        NestedScrollView nestedScrollView;
        OverScroller vScroller;
        if (i5 == 0) {
            return;
        }
        int scrollX = this.mView.getScrollX();
        int scrollY = this.mView.getScrollY();
        boolean z = this.mIsVertical;
        if (!z) {
            View view2 = this.mView;
            if (view2 instanceof NestedHorizontalScrollView) {
                NestedHorizontalScrollView nestedHorizontalScrollView = (NestedHorizontalScrollView) view2;
                OverScroller hScroller = nestedHorizontalScrollView.getHScroller();
                if (hScroller == null) {
                    return;
                }
                onNestedScrollHorizontally(nestedHorizontalScrollView, hScroller, scrollX, scrollY, i, i3, this.mScrollRange, this.mBounceScrollRange);
                return;
            }
        }
        if (z) {
            View view3 = this.mView;
            if (!(view3 instanceof NestedScrollView) || (vScroller = (nestedScrollView = (NestedScrollView) view3).getVScroller()) == null) {
                return;
            }
            onNestedScrollVertically(nestedScrollView, vScroller, scrollX, scrollY, i2, i4, this.mScrollRange, this.mBounceScrollRange);
        }
    }

    protected void onNestedScrollHorizontally(NestedHorizontalScrollView nestedHorizontalScrollView, OverScroller overScroller, int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = this.mHasTriggerStartBounce;
        if (!z && i3 < 0 && i4 < 0) {
            nestedHorizontalScrollView.smoothScrollToInternal(0, i2);
            this.mHasTriggerStartBounce = true;
        } else if (z && i == 0 && overScroller.isFinished()) {
            nestedHorizontalScrollView.smoothScrollToInternal(i6, i2);
            this.mHasTriggerStartBounce = false;
        }
        boolean z2 = this.mHasTriggerEndBounce;
        if (!z2 && i3 > 0 && i4 > 0) {
            nestedHorizontalScrollView.smoothScrollToInternal(i5, i2);
            this.mHasTriggerEndBounce = true;
        } else if (z2 && i == i5 && overScroller.isFinished()) {
            nestedHorizontalScrollView.smoothScrollToInternal(i6, i2);
            this.mHasTriggerEndBounce = false;
        }
    }

    protected void onNestedScrollVertically(NestedScrollView nestedScrollView, OverScroller overScroller, int i, int i2, int i3, int i4, int i5, int i6) {
        boolean z = this.mHasTriggerStartBounce;
        if (!z && i3 < 0 && i4 < 0) {
            nestedScrollView.smoothScrollToInternal(i, 0);
            this.mHasTriggerStartBounce = true;
        } else if (z && i2 == 0 && overScroller.isFinished()) {
            nestedScrollView.smoothScrollToInternal(i, i6);
            this.mHasTriggerStartBounce = false;
        }
        boolean z2 = this.mHasTriggerEndBounce;
        if (!z2 && i3 > 0 && i4 > 0) {
            nestedScrollView.smoothScrollToInternal(i, i5);
            this.mHasTriggerEndBounce = true;
        } else if (z2 && i2 == i5 && overScroller.isFinished()) {
            nestedScrollView.smoothScrollToInternal(i, i6);
            this.mHasTriggerEndBounce = false;
        }
    }

    public void checkNestedStateByDeadLine() {
        int scrollX = this.mView.getScrollX();
        int scrollY = this.mView.getScrollY();
        boolean z = this.mIsVertical;
        if (!z) {
            View view = this.mView;
            if (view instanceof NestedHorizontalScrollView) {
                NestedHorizontalScrollView nestedHorizontalScrollView = (NestedHorizontalScrollView) view;
                if (this.mHasTriggerStartBounce) {
                    nestedHorizontalScrollView.smoothScrollToInternal(this.mBounceScrollRange, scrollY);
                    this.mHasTriggerStartBounce = false;
                    return;
                } else {
                    if (this.mHasTriggerEndBounce) {
                        nestedHorizontalScrollView.smoothScrollToInternal(this.mBounceScrollRange, scrollY);
                        this.mHasTriggerEndBounce = false;
                        return;
                    }
                    return;
                }
            }
        }
        if (z) {
            View view2 = this.mView;
            if (view2 instanceof NestedScrollView) {
                NestedScrollView nestedScrollView = (NestedScrollView) view2;
                if (this.mHasTriggerStartBounce) {
                    nestedScrollView.smoothScrollToInternal(scrollX, this.mBounceScrollRange);
                    this.mHasTriggerStartBounce = false;
                } else if (this.mHasTriggerEndBounce) {
                    nestedScrollView.smoothScrollToInternal(scrollX, this.mBounceScrollRange);
                    this.mHasTriggerEndBounce = false;
                }
            }
        }
    }

    public int getScrollRange() {
        return this.mScrollRange;
    }

    public int getBounceScrollRange() {
        return this.mBounceScrollRange;
    }
}
