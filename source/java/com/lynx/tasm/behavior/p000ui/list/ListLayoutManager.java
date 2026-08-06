package com.lynx.tasm.behavior.p000ui.list;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class ListLayoutManager {
    public static final String TAG = "ListLayoutManager";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ListLayoutInfo {
        float getConsumedX();

        float getConsumedY();
    }

    private static int calculateFullSpanOffset(int i, int i2, int i3, int i4) {
        int i5 = i - i2;
        if (i5 <= 0) {
            return 0;
        }
        int i6 = i4 + i3;
        int i7 = i5 - i6;
        if (i7 >= 0) {
            return i3;
        }
        return i3 + ((int) (i7 * (i3 / i6)));
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ListLinearLayoutManager extends LinearLayoutManager implements ListLayoutInfo {
        private float mConsumedX;
        private float mConsumedY;
        private UIList mList;

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public ListLinearLayoutManager(Context context, UIList uIList) {
            super(context);
            this.mList = uIList;
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            if (1 == getOrientation()) {
                int viewAdapterPosition = view.getLayoutParams().getViewAdapterPosition();
                if (this.mList.getAdapter() == null || this.mList.getAdapter().isFullSpan(viewAdapterPosition)) {
                    ListLayoutManager.layoutFullSpan(this, view, i2, i4, this.mList.mEnableGapItemDecoration);
                    return;
                } else {
                    super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
                    return;
                }
            }
            super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
        }

        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            this.mList.onLayoutCompleted();
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedY() {
            return this.mConsumedY;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedX() {
            return this.mConsumedX;
        }

        public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.mConsumedY = super.scrollVerticallyBy(i, recycler, state);
            this.mList.mListEventManager.onScrollBy(i, (int) this.mConsumedY);
            return (int) this.mConsumedY;
        }

        public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.mConsumedX = super.scrollHorizontallyBy(i, recycler, state);
            this.mList.mListEventManager.onScrollBy(i, (int) this.mConsumedX);
            return (int) this.mConsumedX;
        }

        public boolean canScrollVertically() {
            if (this.mList.mEnableScroll) {
                return super.canScrollVertically();
            }
            return false;
        }

        public boolean canScrollHorizontally() {
            if (this.mList.mEnableScroll) {
                return super.canScrollHorizontally();
            }
            return false;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ListGridLayoutManager extends GridLayoutManager implements ListLayoutInfo {
        private float mConsumedX;
        private float mConsumedY;
        private int mCrossAxisGap;
        private UIList mList;

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public ListGridLayoutManager(Context context, int i, int i2, UIList uIList) {
            super(context, i);
            this.mCrossAxisGap = i2;
            this.mList = uIList;
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            if (1 == getOrientation()) {
                if (view.getLayoutParams().getSpanSize() == getSpanCount()) {
                    ListLayoutManager.layoutFullSpan(this, view, i2, i4, this.mList.mEnableGapItemDecoration);
                    return;
                }
                if (!this.mList.mEnableGapItemDecoration) {
                    i = ListLayoutManager.adjustLeftWithGap(this.mList, getSpanCount(), this.mCrossAxisGap, i, i3);
                    i3 = view.getMeasuredWidth() + i;
                }
                super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
                return;
            }
            super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
        }

        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            this.mList.onLayoutCompleted();
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedY() {
            return this.mConsumedY;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedX() {
            return this.mConsumedX;
        }

        public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.mConsumedY = super.scrollVerticallyBy(i, recycler, state);
            this.mList.mListEventManager.onScrollBy(i, (int) this.mConsumedY);
            return (int) this.mConsumedY;
        }

        public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            this.mConsumedX = super.scrollHorizontallyBy(i, recycler, state);
            this.mList.mListEventManager.onScrollBy(i, (int) this.mConsumedX);
            return (int) this.mConsumedX;
        }

        public boolean canScrollVertically() {
            if (this.mList.mEnableScroll) {
                return super.canScrollVertically();
            }
            return false;
        }

        public boolean canScrollHorizontally() {
            if (this.mList.mEnableScroll) {
                return super.canScrollHorizontally();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCrossAxisGap(int i) {
            this.mCrossAxisGap = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ListStaggeredGridLayoutManager extends StaggeredGridLayoutManager implements ListLayoutInfo {
        public static final String TAG = "ListStaggeredGridLayoutManager";
        private float mConsumedX;
        private float mConsumedY;
        private int mCrossAxisGap;
        private UIList mList;

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public ListStaggeredGridLayoutManager(int i, int i2, int i3, UIList uIList) {
            super(i, i3);
            this.mCrossAxisGap = i2;
            this.mList = uIList;
        }

        public void onScrollStateChanged(int i) {
            try {
                super.onScrollStateChanged(i);
            } catch (Exception e) {
                LLog.e(TAG, e.getMessage());
            }
        }

        public void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
            StaggeredGridLayoutManager.LayoutParams layoutParams = view.getLayoutParams();
            if (1 == getOrientation()) {
                if (layoutParams.isFullSpan()) {
                    ListLayoutManager.layoutFullSpan(this, view, i2, i4, this.mList.mEnableGapItemDecoration);
                    return;
                }
                if (!this.mList.mEnableGapItemDecoration) {
                    i = ListLayoutManager.adjustLeftWithGap(this.mList, getSpanCount(), this.mCrossAxisGap, i, i3);
                    i3 = view.getMeasuredWidth() + i;
                }
                super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
                return;
            }
            super.layoutDecoratedWithMargins(view, i, i2, i3, i4);
        }

        public void onLayoutCompleted(RecyclerView.State state) {
            super.onLayoutCompleted(state);
            this.mList.onLayoutCompleted();
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedY() {
            return this.mConsumedY;
        }

        @Override // com.lynx.tasm.behavior.ui.list.ListLayoutManager.ListLayoutInfo
        public float getConsumedX() {
            return this.mConsumedX;
        }

        public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                int scrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
                this.mList.mListEventManager.onScrollBy(i, scrollVerticallyBy);
                return scrollVerticallyBy;
            } catch (NullPointerException unused) {
                return 0;
            }
        }

        public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                int scrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
                this.mList.mListEventManager.onScrollBy(i, scrollHorizontallyBy);
                return scrollHorizontallyBy;
            } catch (NullPointerException unused) {
                return 0;
            }
        }

        public boolean canScrollVertically() {
            if (this.mList.mEnableScroll) {
                return super.canScrollVertically();
            }
            return false;
        }

        public boolean canScrollHorizontally() {
            if (this.mList.mEnableScroll) {
                return super.canScrollHorizontally();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCrossAxisGap(int i) {
            this.mCrossAxisGap = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void layoutFullSpan(RecyclerView.LayoutManager layoutManager, View view, int i, int i2, boolean z) {
        int calculateFullSpanOffset = calculateFullSpanOffset(layoutManager.getWidth(), view.getMeasuredWidth(), layoutManager.getPaddingLeft(), layoutManager.getPaddingRight());
        int measuredWidth = calculateFullSpanOffset + view.getMeasuredWidth();
        if (z) {
            layoutManager.layoutDecorated(view, calculateFullSpanOffset, i, measuredWidth, i2);
        } else {
            view.layout(calculateFullSpanOffset, i, measuredWidth, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int adjustLeftWithGap(UIList uIList, int i, int i2, int i3, int i4) {
        if (i2 <= 0 || uIList == null || uIList.getRecyclerView() == null) {
            return i3;
        }
        RecyclerView recyclerView = uIList.getRecyclerView();
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = ((recyclerView.getWidth() - paddingLeft) - recyclerView.getPaddingRight()) / i;
        if (width == 0) {
            LLog.i(TAG, "the width of list maybe 0 ");
            return i3;
        }
        return ((i2 + (i4 - i3)) * ((i3 - paddingLeft) / width)) + paddingLeft;
    }
}
