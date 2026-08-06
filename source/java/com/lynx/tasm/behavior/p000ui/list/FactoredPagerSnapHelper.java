package com.lynx.tasm.behavior.p000ui.list;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FactoredPagerSnapHelper extends PagerSnapHelper {
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;
    public FactoredPagerHooks mPagerHooks = null;
    public RecyclerView mRecyclerView = null;
    private double mFactor = 0.5d;
    private int mOffset = 0;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FactoredPagerHooks {
        void willSnapTo(int i, int i2, int i3, int i4, int i5);
    }

    public void setPagerAlignFactor(double d) {
        this.mFactor = d;
    }

    public void setPagerAlignOffset(int i) {
        this.mOffset = i;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = distanceToItem(layoutManager, view, getHorizontalHelper(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = distanceToItem(layoutManager, view, getVerticalHelper(layoutManager));
        } else {
            iArr[1] = 0;
        }
        if (this.mRecyclerView != null) {
            this.mPagerHooks.willSnapTo(layoutManager.getPosition(view), this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY(), iArr[0], iArr[1]);
        }
        return iArr;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return findTargetView(layoutManager, getVerticalHelper(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return findTargetView(layoutManager, getHorizontalHelper(layoutManager));
        }
        return null;
    }

    private int distanceToItem(RecyclerView.LayoutManager layoutManager, View view, OrientationHelper orientationHelper) {
        double end;
        int i;
        int decoratedStart = (int) (orientationHelper.getDecoratedStart(view) + (orientationHelper.getDecoratedMeasurement(view) * this.mFactor) + this.mOffset);
        if (layoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() * this.mFactor);
            i = this.mOffset;
        } else {
            end = orientationHelper.getEnd() * this.mFactor;
            i = this.mOffset;
        }
        return decoratedStart - ((int) (end + i));
    }

    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        OrientationHelper horizontalHelper;
        if (this.mRecyclerView == null) {
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            this.mPagerHooks.willSnapTo(-1, this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY(), this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY());
            return -1;
        }
        if (layoutManager.canScrollVertically()) {
            horizontalHelper = getVerticalHelper(layoutManager);
        } else {
            horizontalHelper = getHorizontalHelper(layoutManager);
        }
        int childCount = layoutManager.getChildCount();
        View view = null;
        int i3 = Integer.MAX_VALUE;
        int i4 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = layoutManager.getChildAt(i5);
            if (childAt != null) {
                int distanceToItem = distanceToItem(layoutManager, childAt, horizontalHelper);
                if (distanceToItem <= 0 && distanceToItem > i4) {
                    view2 = childAt;
                    i4 = distanceToItem;
                }
                if (distanceToItem >= 0 && distanceToItem < i3) {
                    view = childAt;
                    i3 = distanceToItem;
                }
            }
        }
        boolean isForwardFling = isForwardFling(layoutManager, i, i2);
        if (isForwardFling && view != null) {
            return layoutManager.getPosition(view);
        }
        if (!isForwardFling && view2 != null) {
            return layoutManager.getPosition(view2);
        }
        if (isForwardFling) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int position = layoutManager.getPosition(view) + (!isForwardFling ? -1 : 1);
        int i6 = position >= 0 ? position : 0;
        if (i6 >= itemCount) {
            return -1;
        }
        return i6;
    }

    private boolean isForwardFling(RecyclerView.LayoutManager layoutManager, int i, int i2) {
        return layoutManager.canScrollHorizontally() ? i >= 0 : i2 >= 0;
    }

    private View findTargetView(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        double end;
        int i;
        View view = null;
        if (this.mRecyclerView == null) {
            return null;
        }
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            this.mPagerHooks.willSnapTo(-1, this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY(), this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY());
            return null;
        }
        if (layoutManager.getClipToPadding()) {
            end = orientationHelper.getStartAfterPadding() + (orientationHelper.getTotalSpace() * this.mFactor);
            i = this.mOffset;
        } else {
            end = orientationHelper.getEnd() * this.mFactor;
            i = this.mOffset;
        }
        int i2 = (int) (end + i);
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = layoutManager.getChildAt(i4);
            int abs = Math.abs(((int) ((orientationHelper.getDecoratedStart(childAt) + (orientationHelper.getDecoratedMeasurement(childAt) * this.mFactor)) + this.mOffset)) - i2);
            if (abs < i3) {
                view = childAt;
                i3 = abs;
            }
        }
        if (view == null) {
            this.mPagerHooks.willSnapTo(-1, this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY(), this.mRecyclerView.getScrollX(), this.mRecyclerView.getScrollY());
        }
        return view;
    }

    private OrientationHelper getVerticalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mVerticalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.mVerticalHelper = OrientationHelper.createVerticalHelper(layoutManager);
        }
        return this.mVerticalHelper;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.mHorizontalHelper;
        if (orientationHelper == null || orientationHelper.getLayoutManager() != layoutManager) {
            this.mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        }
        return this.mHorizontalHelper;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
        this.mRecyclerView = recyclerView;
    }
}
