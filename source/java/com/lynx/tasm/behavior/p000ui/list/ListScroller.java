package com.lynx.tasm.behavior.p000ui.list;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.PropsConstants;
import com.lynx.tasm.behavior.p000ui.list.ListViewHolder;
import com.lynx.trace.BuildConfig;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ListScroller {
    private static final int DECELERATE_FACTOR = 3;
    private static final int SCROLL_DIRECTION_DOWN = 1;
    private static final int SCROLL_DIRECTION_UP = -1;
    private static int SCROLL_PX_PER_FRAME = 80;
    private final RecyclerView mRecyclerview;
    private SmoothScroller mSmoothScroller;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListScroller(Context context, RecyclerView recyclerView) {
        SCROLL_PX_PER_FRAME = calculatePxPerFrame(context.getResources().getDisplayMetrics());
        this.mRecyclerview = recyclerView;
        this.mSmoothScroller = new SmoothScroller(recyclerView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVerticalOrientation(boolean z) {
        this.mSmoothScroller.setVerticalOrientation(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToPositionInner(int i) {
        scrollToPositionInner(i, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToPositionInner(int i, int i2, Callback callback) {
        LLog.i(UIList.TAG, "ListScroller scrollToPositionNoSmooth: position=" + i + ", offset=" + i2);
        SmoothScroller smoothScroller = this.mSmoothScroller;
        if (smoothScroller != null && smoothScroller.mWorking) {
            LLog.e(UIList.TAG, "ListScroller scrollToPositionSmoothly is scrolling ");
            if (callback != null) {
                callback.invoke(new Object[]{1, "dumplicated, scrollToPositionSmoothly is working"});
                return;
            }
            return;
        }
        RecyclerView recyclerView = this.mRecyclerview;
        if (recyclerView != null) {
            recyclerView.stopScroll();
            this.mRecyclerview.stopNestedScroll();
        }
        LinearLayoutManager layoutManager = this.mRecyclerview.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            layoutManager.scrollToPositionWithOffset(i, i2);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(i, i2);
        }
        if (callback != null) {
            callback.invoke(new Object[]{0});
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToPositionSmoothly(int i, String str, int i2, Callback callback) {
        LLog.i(UIList.TAG, "ListScroller scrollToPositionSmoothly: position=" + i + ", offset=" + i2 + ", alignTo: " + (str != null ? str : BuildConfig.enable_trace));
        this.mSmoothScroller.start(i, str, i2, callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SmoothScroller implements Runnable {
        private String mAlignTo;
        private int mBottomPosition;
        private int mOffset;
        private int mTargetPosition;
        private int mTopPosition;
        private WeakReference<RecyclerView> mViewRef;
        private boolean mVerticalOrientation = true;
        private RecyclerView.SimpleOnItemTouchListener mTouchListener = new RecyclerView.SimpleOnItemTouchListener() { // from class: com.lynx.tasm.behavior.ui.list.ListScroller.SmoothScroller.1
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                SmoothScroller.this.mWorking = false;
                return false;
            }
        };
        private Callback mCallback = null;
        private View mTargetView = null;
        private boolean mWorking = false;

        private boolean isFarAwayToTarget(int i, int i2, int i3) {
            return i > 30 && i2 > i3 * 10;
        }

        SmoothScroller(RecyclerView recyclerView) {
            this.mViewRef = new WeakReference<>(recyclerView);
        }

        void setVerticalOrientation(boolean z) {
            this.mVerticalOrientation = z;
        }

        void start(int i, String str, int i2, Callback callback) {
            RecyclerView recyclerView = this.mViewRef.get();
            if (recyclerView == null || recyclerView.getLayoutManager() == null || recyclerView.getChildCount() == 0) {
                this.mWorking = false;
                callback.invoke(new Object[]{4, "can not scroll before init"});
                return;
            }
            if (!recyclerView.isAttachedToWindow()) {
                this.mWorking = false;
                LLog.e(UIList.TAG, "ListScroller start: early return due to view is not attached to window.");
                callback.invoke(new Object[]{7, "can not invoke scroll when the view is not attached to window."});
                return;
            }
            this.mCallback = callback;
            this.mTargetPosition = i;
            this.mAlignTo = str;
            this.mOffset = i2;
            this.mTargetView = null;
            if (this.mWorking) {
                return;
            }
            this.mWorking = true;
            recyclerView.stopScroll();
            recyclerView.stopNestedScroll();
            recyclerView.addOnItemTouchListener(this.mTouchListener);
            recyclerView.post(this);
        }

        private void stop() {
            LLog.i(UIList.TAG, "ListScroller stop");
            RecyclerView recyclerView = this.mViewRef.get();
            this.mWorking = false;
            if (recyclerView != null) {
                recyclerView.removeOnItemTouchListener(this.mTouchListener);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = this.mViewRef.get();
            if (recyclerView == null || recyclerView.getLayoutManager() == null || recyclerView.getChildCount() == 0) {
                stop();
                return;
            }
            if (!this.mWorking) {
                this.mCallback.invoke(new Object[]{0});
                stop();
            } else if (work(recyclerView)) {
                recyclerView.post(this);
            } else {
                stop();
            }
        }

        private boolean work(RecyclerView recyclerView) {
            int i;
            int min = Math.min(this.mTargetPosition, recyclerView.getLayoutManager().getItemCount() - 1);
            this.mTargetPosition = min;
            this.mTargetPosition = Math.max(min, 0);
            if (!isChildrenLayoutFinished(recyclerView)) {
                return true;
            }
            updateChildPosition(recyclerView);
            if (this.mTargetView == null) {
                int i2 = this.mTopPosition;
                int i3 = this.mTargetPosition;
                int i4 = i2 > i3 ? -1 : 1;
                int i5 = this.mBottomPosition;
                int i6 = (i5 - i2) + 1;
                int i7 = i4 == -1 ? i2 - i3 : i3 - i5;
                int height = this.mVerticalOrientation ? recyclerView.getHeight() : recyclerView.getWidth();
                if (!isFarAwayToTarget(i7, (i7 * height) / i6, height)) {
                    i = Math.min(height, ListScroller.SCROLL_PX_PER_FRAME * i7) * i4;
                } else {
                    int i8 = this.mTopPosition;
                    int i9 = this.mTargetPosition;
                    if (i8 <= i9) {
                        i8 = this.mBottomPosition;
                    }
                    recyclerView.scrollToPosition(((i8 - i9) / 2) + i9);
                    return true;
                }
            } else {
                int onTargetFound = onTargetFound(recyclerView);
                if (onTargetFound != 0) {
                    int min2 = Math.min(Math.max(Math.abs(onTargetFound) / 3, 1), ListScroller.SCROLL_PX_PER_FRAME);
                    i = onTargetFound > 0 ? min2 : -min2;
                    if ((this.mVerticalOrientation ? this.mTargetView.getHeight() : this.mTargetView.getWidth()) == 0 && i == 1) {
                        this.mCallback.invoke(new Object[]{0});
                        return false;
                    }
                } else {
                    this.mCallback.invoke(new Object[]{0});
                    return false;
                }
            }
            boolean tryScroll = ListScroller.tryScroll(recyclerView, this.mVerticalOrientation, i);
            if (!tryScroll) {
                this.mCallback.invoke(new Object[]{4, "can not scroll when come to border"});
            }
            return tryScroll;
        }

        private int onTargetFound(RecyclerView recyclerView) {
            int decoratedMeasuredWidth;
            int i;
            if (this.mTargetView == null) {
                return 0;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int decoratedTop = this.mVerticalOrientation ? layoutManager.getDecoratedTop(this.mTargetView) : layoutManager.getDecoratedLeft(this.mTargetView);
            if (this.mVerticalOrientation) {
                decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredHeight(this.mTargetView);
            } else {
                decoratedMeasuredWidth = layoutManager.getDecoratedMeasuredWidth(this.mTargetView);
            }
            int height = this.mVerticalOrientation ? layoutManager.getHeight() : layoutManager.getWidth();
            int paddingTop = this.mVerticalOrientation ? layoutManager.getPaddingTop() : layoutManager.getPaddingLeft();
            int paddingBottom = (height - paddingTop) - (this.mVerticalOrientation ? layoutManager.getPaddingBottom() : layoutManager.getPaddingRight());
            if (TextUtils.equals(this.mAlignTo, "middle")) {
                i = this.mOffset + paddingTop + ((paddingBottom - decoratedMeasuredWidth) / 2);
            } else if (TextUtils.equals(this.mAlignTo, PropsConstants.HIT_SLOP_BOTTOM)) {
                i = ((this.mOffset + paddingTop) + paddingBottom) - decoratedMeasuredWidth;
            } else {
                i = this.mOffset + paddingTop;
            }
            return decoratedTop - i;
        }

        private boolean isChildrenLayoutFinished(RecyclerView recyclerView) {
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                ListViewHolder.WrapView wrapView = (ListViewHolder.WrapView) recyclerView.getChildAt(i);
                if (wrapView.mLayoutStatus != 3 && ((ListViewHolder) recyclerView.getChildViewHolder(wrapView)).getUIComponent() != null) {
                    return false;
                }
            }
            return true;
        }

        private void updateChildPosition(RecyclerView recyclerView) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            int childCount = recyclerView.getChildCount();
            this.mTopPosition = layoutManager.getItemCount();
            this.mBottomPosition = 0;
            for (int i = 0; i < childCount; i++) {
                ListViewHolder.WrapView wrapView = (ListViewHolder.WrapView) recyclerView.getChildAt(i);
                int viewLayoutPosition = wrapView.getLayoutParams().getViewLayoutPosition();
                this.mBottomPosition = Math.max(viewLayoutPosition, this.mBottomPosition);
                this.mTopPosition = Math.min(viewLayoutPosition, this.mTopPosition);
                if (viewLayoutPosition == this.mTargetPosition) {
                    this.mTargetView = wrapView;
                    return;
                }
            }
        }
    }

    private int calculatePxPerFrame(DisplayMetrics displayMetrics) {
        return displayMetrics.densityDpi / 4;
    }

    private static boolean canScroll(RecyclerView recyclerView, boolean z, int i) {
        int width;
        int paddingRight;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = recyclerView.getChildCount();
        boolean z2 = recyclerView.findViewHolderForLayoutPosition(0) != null;
        boolean z3 = recyclerView.findViewHolderForLayoutPosition(layoutManager.getItemCount() - 1) != null;
        if ((z2 && -1 == i) || (z3 && 1 == i)) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = recyclerView.getChildAt(i4);
                if (z) {
                    i2 = Math.min(layoutManager.getDecoratedTop(childAt), i2);
                } else {
                    i2 = Math.min(layoutManager.getDecoratedLeft(childAt), i2);
                }
                if (z) {
                    i3 = Math.max(layoutManager.getDecoratedBottom(childAt), i3);
                } else {
                    i3 = Math.max(layoutManager.getDecoratedRight(childAt), i3);
                }
            }
            int paddingTop = z ? layoutManager.getPaddingTop() : layoutManager.getPaddingLeft();
            if (z) {
                width = layoutManager.getHeight();
                paddingRight = layoutManager.getPaddingBottom();
            } else {
                width = layoutManager.getWidth();
                paddingRight = layoutManager.getPaddingRight();
            }
            return (z2 && -1 == i) ? i2 < paddingTop : (z3 && 1 == i && i3 <= width - paddingRight) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean tryScroll(RecyclerView recyclerView, boolean z, int i) {
        if (i == 0) {
            return false;
        }
        if (!canScroll(recyclerView, z, i > 0 ? 1 : -1)) {
            return false;
        }
        if (z) {
            recyclerView.scrollBy(0, i);
        } else {
            recyclerView.scrollBy(i, 0);
        }
        return true;
    }
}
