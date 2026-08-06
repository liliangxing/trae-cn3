package com.lynx.tasm.behavior.p000ui.list;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.p000ui.LynxUI;
import com.lynx.tasm.behavior.p000ui.view.AndroidView;
import com.lynx.tasm.behavior.p000ui.view.ComponentView;
import com.lynx.tasm.behavior.p000ui.view.UIComponent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ListStickyManager extends RecyclerView.OnScrollListener implements View.OnAttachStateChangeListener {
    private ContainerView mListContainer;
    private UIList mUIList;
    private int mStickyOffset = 0;
    private boolean mOldStickCategory = true;
    private int mStickyTopPosition = -1;
    private int mStickyBottomPosition = -1;
    private StickyItemInfo mStickTopInfo = new StickyItemInfo();
    private StickyItemInfo mStickBottomInfo = new StickyItemInfo();

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ListStickyManager(UIList uIList) {
        this.mUIList = uIList;
        this.mListContainer = new ContainerView(uIList.getLynxContext());
        uIList.getRecyclerView().addOnScrollListener(this);
        uIList.getRecyclerView().addOnAttachStateChangeListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        if (this.mListContainer.indexOfChild(view) >= 0) {
            return;
        }
        this.mListContainer.addRecyclerView(view);
    }

    public void onScrolled(final RecyclerView recyclerView, int i, int i2) {
        if (i2 == 0) {
            recyclerView.post(new Runnable() { // from class: com.lynx.tasm.behavior.ui.list.ListStickyManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ListStickyManager.this.updateSticky(recyclerView, 0);
                }
            });
        } else {
            updateSticky(recyclerView, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStickyOffset(int i) {
        this.mStickyOffset = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUseOldStickCategory(boolean z) {
        this.mOldStickCategory = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSticky(RecyclerView recyclerView, int i) {
        if (i > 0) {
            restoreToHolder(this.mStickBottomInfo, false);
        } else if (i < 0) {
            restoreToHolder(this.mStickTopInfo, true);
        }
        updateTopAndBottomStickyPosition(recyclerView);
        moveStickyIfNeed(this.mStickTopInfo, this.mStickyTopPosition, true);
        moveStickyIfNeed(this.mStickBottomInfo, this.mStickyBottomPosition, false);
        offsetStickyItemIfNeed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        if (this.mStickTopInfo.mPosition != -1) {
            cleanOldStickyItem(this.mStickTopInfo);
        }
        if (this.mStickBottomInfo.mPosition != -1) {
            cleanOldStickyItem(this.mStickBottomInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewGroup getContainer() {
        return this.mListContainer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public EventTarget hitTest(int i, int i2, boolean z) {
        if (this.mStickTopInfo.mComponent != null) {
            Rect rect = new Rect();
            ((AndroidView) this.mStickTopInfo.mComponent.getView()).getHitRect(rect);
            if (rect.contains(i, i2)) {
                return this.mStickTopInfo.mComponent.hitTest(i - ((AndroidView) this.mStickTopInfo.mComponent.getView()).getLeft(), i2 - ((AndroidView) this.mStickTopInfo.mComponent.getView()).getTop(), z);
            }
        }
        if (this.mStickBottomInfo.mComponent == null) {
            return null;
        }
        Rect rect2 = new Rect();
        ((AndroidView) this.mStickBottomInfo.mComponent.getView()).getHitRect(rect2);
        if (rect2.contains(i, i2)) {
            return this.mStickBottomInfo.mComponent.hitTest(i - ((AndroidView) this.mStickBottomInfo.mComponent.getView()).getLeft(), i2 - ((AndroidView) this.mStickBottomInfo.mComponent.getView()).getTop(), z);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushStickyComponent() {
        flushStickyComponent(this.mStickBottomInfo);
        flushStickyComponent(this.mStickTopInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flushStickyComponentAfterScrolling() {
        if (this.mOldStickCategory) {
            return;
        }
        UIListAdapter adapter = this.mUIList.getAdapter();
        int i = this.mStickBottomInfo.mPosition;
        if (i != -1) {
            if (adapter.isStickyBottomItem(i)) {
                flushStickyComponent(this.mStickBottomInfo);
            } else {
                forceRestoreToHolder(this.mStickBottomInfo, false, false);
                updateSticky(this.mUIList.getView(), 0);
            }
        }
        int i2 = this.mStickTopInfo.mPosition;
        if (i2 != -1) {
            if (adapter.isStickyTopItem(i2)) {
                RecyclerView recyclerView = (RecyclerView) this.mUIList.getView();
                int i3 = Integer.MAX_VALUE;
                int i4 = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < recyclerView.getChildCount(); i5++) {
                    View childAt = recyclerView.getChildAt(i5);
                    if (childAt.getTop() <= this.mStickyOffset && childAt.getBottom() > this.mStickyOffset) {
                        i3 = ((ListViewHolder) recyclerView.getChildViewHolder(childAt)).getAdapterPosition();
                    }
                    if (childAt.getTop() < recyclerView.getHeight() - this.mStickyOffset && childAt.getBottom() >= recyclerView.getHeight() - this.mStickyOffset) {
                        i4 = ((ListViewHolder) recyclerView.getChildViewHolder(childAt)).getAdapterPosition();
                    }
                }
                int stickySectionHeaderForPosition = adapter.getStickySectionHeaderForPosition(i3);
                adapter.getStickySectionFooterForPosition(i4);
                if (stickySectionHeaderForPosition != this.mStickTopInfo.mPosition) {
                    forceRestoreToHolder(this.mStickTopInfo, true, false);
                    updateSticky(this.mUIList.getView(), 0);
                    return;
                }
                return;
            }
            forceRestoreToHolder(this.mStickTopInfo, true, false);
        }
    }

    private void flushStickyComponent(StickyItemInfo stickyItemInfo) {
        if (stickyItemInfo.mPosition == -1 || this.mUIList.getAdapter() == null || stickyItemInfo.mPosition >= this.mUIList.getAdapter().getItemCount()) {
            return;
        }
        if (this.mUIList.getAdapter().mNewArch) {
            if (!this.mUIList.isAsyncThreadStrategy()) {
                this.mUIList.obtainChild(stickyItemInfo.mPosition, this.mUIList.getAdapter().generateOperationId(), this.mUIList.getAdapter().getReuseNotificationEnabled());
                return;
            } else {
                this.mUIList.obtainChildAsync(stickyItemInfo.mPosition, this.mUIList.getAdapter().generateOperationId());
                return;
            }
        }
        this.mUIList.updateChild(stickyItemInfo.mComponent, stickyItemInfo.mPosition, this.mUIList.getAdapter().generateOperationId());
    }

    private static ViewGroup removeViewFromParent(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        return (ViewGroup) parent;
    }

    private void updateTopAndBottomStickyPosition(RecyclerView recyclerView) {
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < recyclerView.getChildCount(); i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt.getTop() <= this.mStickyOffset && childAt.getBottom() > this.mStickyOffset) {
                i = ((ListViewHolder) recyclerView.getChildViewHolder(childAt)).getAdapterPosition();
            }
            if (childAt.getTop() < recyclerView.getHeight() - this.mStickyOffset && childAt.getBottom() >= recyclerView.getHeight() - this.mStickyOffset) {
                i2 = ((ListViewHolder) recyclerView.getChildViewHolder(childAt)).getAdapterPosition();
            }
        }
        UIListAdapter adapter = this.mUIList.getAdapter();
        if (adapter == null) {
            return;
        }
        int sectionHeaderForPosition = this.mOldStickCategory ? adapter.getSectionHeaderForPosition(i) : adapter.getStickySectionHeaderForPosition(i);
        int sectionFooterForPosition = this.mOldStickCategory ? adapter.getSectionFooterForPosition(i2) : adapter.getStickySectionFooterForPosition(i2);
        if (adapter.isStickyTopItem(sectionHeaderForPosition)) {
            if (this.mStickyTopPosition != sectionHeaderForPosition) {
                this.mStickyTopPosition = sectionHeaderForPosition;
                if (UIList.DEBUG) {
                    LLog.i(UIList.TAG, String.format("new sticky-top position %d", Integer.valueOf(this.mStickyTopPosition)));
                }
            }
        } else {
            this.mStickyTopPosition = -1;
        }
        if (adapter.isStickyBottomItem(sectionFooterForPosition)) {
            if (this.mStickyBottomPosition != sectionFooterForPosition) {
                this.mStickyBottomPosition = sectionFooterForPosition;
                if (UIList.DEBUG) {
                    LLog.i(UIList.TAG, String.format("new sticky-bottom position %d", Integer.valueOf(this.mStickyBottomPosition)));
                }
            }
        } else {
            this.mStickyBottomPosition = -1;
        }
        if (this.mStickTopInfo.mPosition != -1 && this.mStickyTopPosition != -1 && this.mStickTopInfo.mPosition != this.mStickyTopPosition) {
            cleanOldStickyItem(this.mStickTopInfo);
        }
        if (this.mStickBottomInfo.mPosition == -1 || this.mStickyBottomPosition == -1 || this.mStickBottomInfo.mPosition == this.mStickyBottomPosition) {
            return;
        }
        cleanOldStickyItem(this.mStickBottomInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r2v7, types: [android.view.View] */
    private void moveStickyIfNeed(StickyItemInfo stickyItemInfo, int i, boolean z) {
        UIComponent uIComponent;
        if (i == -1 || i == stickyItemInfo.mPosition) {
            return;
        }
        RecyclerView recyclerView = this.mUIList.getRecyclerView();
        ListViewHolder listViewHolder = (ListViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
        boolean z2 = true;
        if (listViewHolder == null) {
            listViewHolder = (ListViewHolder) recyclerView.getAdapter().createViewHolder(recyclerView, recyclerView.getAdapter().getItemViewType(i));
            if (this.mUIList.getAdapter().mNewArch) {
                this.mUIList.getAdapter().bindViewHolderOnNewArch(listViewHolder, i);
            } else {
                this.mUIList.getAdapter().bindViewHolder(listViewHolder, i);
            }
        } else {
            boolean z3 = z && listViewHolder.mRootView.getTop() < this.mStickyOffset;
            boolean z4 = !z && listViewHolder.mRootView.getBottom() > this.mListContainer.getHeight() - this.mStickyOffset;
            if (!z3 && !z4) {
                z2 = false;
            }
        }
        if (!z2 || (uIComponent = listViewHolder.getUIComponent()) == null) {
            return;
        }
        listViewHolder.removeUIComponent();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2, z ? 48 : 80);
        layoutParams.topMargin = z ? this.mStickyOffset : 0;
        layoutParams.bottomMargin = z ? 0 : this.mStickyOffset;
        removeViewFromParent(uIComponent.getView());
        this.mListContainer.addView((View) uIComponent.getView(), layoutParams);
        stickyItemInfo.mComponent = uIComponent;
        stickyItemInfo.mPosition = i;
        if (UIList.DEBUG) {
            LLog.i(UIList.TAG, "finish moveSticky " + i);
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [android.view.View] */
    private void forceRestoreToHolder(StickyItemInfo stickyItemInfo, boolean z, boolean z2) {
        if (stickyItemInfo.mPosition == -1) {
            return;
        }
        ListViewHolder listViewHolder = (ListViewHolder) this.mUIList.getRecyclerView().findViewHolderForAdapterPosition(stickyItemInfo.mPosition);
        if (listViewHolder != null) {
            restoreToHolderIfNeed(stickyItemInfo, listViewHolder, z, z2);
            return;
        }
        removeViewFromParent(stickyItemInfo.mComponent.getView());
        stickyItemInfo.mPosition = -1;
        stickyItemInfo.mComponent = null;
    }

    private void restoreToHolder(StickyItemInfo stickyItemInfo, boolean z) {
        ListViewHolder listViewHolder;
        if (stickyItemInfo.mPosition == -1 || (listViewHolder = (ListViewHolder) this.mUIList.getRecyclerView().findViewHolderForAdapterPosition(stickyItemInfo.mPosition)) == null) {
            return;
        }
        restoreToHolderIfNeed(stickyItemInfo, listViewHolder, z, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resetStickyView() {
        forceRestoreToHolder(this.mStickTopInfo, true, true);
        forceRestoreToHolder(this.mStickBottomInfo, false, true);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r7v6, types: [android.view.View] */
    private void restoreToHolderIfNeed(StickyItemInfo stickyItemInfo, ListViewHolder listViewHolder, boolean z, boolean z2) {
        if (stickyItemInfo.mPosition == -1) {
            return;
        }
        int top = listViewHolder.mRootView.getTop();
        ?? view = stickyItemInfo.mComponent.getView();
        if (view == 0) {
            return;
        }
        if (((z && top > view.getTop()) || (!z && top < view.getTop())) || z2) {
            if (UIList.DEBUG) {
                LLog.i(UIList.TAG, "restoreToHolderIfNeed stickyItem position" + stickyItemInfo.mPosition);
            }
            resetComponentViewTranslationY(stickyItemInfo);
            removeViewFromParent(stickyItemInfo.mComponent.getView());
            if (listViewHolder.getUIComponent() != null) {
                if (this.mUIList.getAdapter().mNewArch) {
                    this.mUIList.recycleChild(listViewHolder.getUIComponent());
                }
                listViewHolder.removeUIComponent();
            }
            listViewHolder.setUIComponent(stickyItemInfo.mComponent);
            stickyItemInfo.mPosition = -1;
            stickyItemInfo.mComponent = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void resetComponentViewTranslationY(StickyItemInfo stickyItemInfo) {
        if (stickyItemInfo == null || stickyItemInfo.mComponent == null || stickyItemInfo.mComponent.getView() == 0) {
            return;
        }
        ((AndroidView) stickyItemInfo.mComponent.getView()).setTranslationY(0.0f);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [android.view.View] */
    private void cleanOldStickyItem(StickyItemInfo stickyItemInfo) {
        if (UIList.DEBUG) {
            LLog.d(UIList.TAG, "cleanOldStickyItem position " + stickyItemInfo.mPosition);
        }
        resetComponentViewTranslationY(stickyItemInfo);
        ListViewHolder listViewHolder = (ListViewHolder) this.mUIList.getRecyclerView().findViewHolderForAdapterPosition(stickyItemInfo.mPosition);
        removeViewFromParent(stickyItemInfo.mComponent.getView());
        if (listViewHolder == null) {
            if (this.mUIList.getAdapter().mNewArch) {
                this.mUIList.recycleChild(stickyItemInfo.mComponent);
                return;
            } else {
                this.mUIList.removeChild((LynxUI) stickyItemInfo.mComponent);
                return;
            }
        }
        listViewHolder.setUIComponent(stickyItemInfo.mComponent);
        stickyItemInfo.mPosition = -1;
        stickyItemInfo.mComponent = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void offsetStickyItemIfNeed() {
        offsetStickyTopItemIfNeed();
        offsetStickyBottomInNeed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void offsetStickyTopItemIfNeed() {
        RecyclerView recyclerView;
        int nextStickySectionHeaderForPosition;
        if (this.mStickTopInfo.mPosition == -1 || (recyclerView = (RecyclerView) this.mUIList.getView()) == null || recyclerView.getChildCount() <= 1) {
            return;
        }
        View childAt = recyclerView.getChildAt(0);
        View childAt2 = recyclerView.getChildAt(recyclerView.getChildCount() - 1);
        if (childAt == null || childAt2 == null) {
            return;
        }
        RecyclerView.ViewHolder childViewHolder = recyclerView.getChildViewHolder(childAt);
        RecyclerView.ViewHolder childViewHolder2 = recyclerView.getChildViewHolder(childAt2);
        if (childViewHolder == null || childViewHolder2 == null) {
            return;
        }
        int adapterPosition = childViewHolder.getAdapterPosition();
        int adapterPosition2 = childViewHolder2.getAdapterPosition();
        if (adapterPosition < 0 || adapterPosition2 < 0 || (nextStickySectionHeaderForPosition = this.mUIList.getAdapter().getNextStickySectionHeaderForPosition(this.mStickTopInfo.mPosition + 1)) < adapterPosition || nextStickySectionHeaderForPosition > adapterPosition2 || nextStickySectionHeaderForPosition == -1) {
            return;
        }
        if (this.mOldStickCategory || this.mUIList.getAdapter().isStickyTopItem(nextStickySectionHeaderForPosition)) {
            ListViewHolder listViewHolder = (ListViewHolder) this.mUIList.getRecyclerView().findViewHolderForAdapterPosition(nextStickySectionHeaderForPosition);
            int min = listViewHolder != null ? Math.min(0, listViewHolder.itemView.getTop() - ((AndroidView) this.mStickTopInfo.mComponent.getView()).getBottom()) : 0;
            ((AndroidView) this.mStickTopInfo.mComponent.getView()).setTranslationY(min);
            if (((AndroidView) this.mStickTopInfo.mComponent.getView()).getBottom() + min < 0) {
                cleanOldStickyItem(this.mStickTopInfo);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void offsetStickyBottomInNeed() {
        int sectionHeaderForPosition;
        if (this.mStickBottomInfo.mPosition == -1 || (sectionHeaderForPosition = this.mUIList.getAdapter().getSectionHeaderForPosition(this.mStickBottomInfo.mPosition - 1)) == -1) {
            return;
        }
        if (this.mOldStickCategory || this.mUIList.getAdapter().isStickyBottomItem(sectionHeaderForPosition)) {
            RecyclerView recyclerView = this.mUIList.getRecyclerView();
            ListViewHolder listViewHolder = (ListViewHolder) recyclerView.findViewHolderForAdapterPosition(sectionHeaderForPosition);
            int max = listViewHolder != null ? Math.max(0, listViewHolder.itemView.getBottom() - ((AndroidView) this.mStickBottomInfo.mComponent.getView()).getTop()) : 0;
            ((AndroidView) this.mStickBottomInfo.mComponent.getView()).setTranslationY(max);
            if (((AndroidView) this.mStickBottomInfo.mComponent.getView()).getTop() + max > recyclerView.getHeight()) {
                cleanOldStickyItem(this.mStickBottomInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class ContainerView extends FrameLayout {
        public ContainerView(Context context) {
            super(context);
        }

        void addRecyclerView(View view) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup == null) {
                LLog.e("ListStickyManager", "addRecyclerView failed, parent is null.");
                return;
            }
            int indexOfChild = viewGroup.indexOfChild(view);
            viewGroup.removeViewAt(indexOfChild);
            addView(view, new FrameLayout.LayoutParams(-1, -1));
            viewGroup.addView(this, indexOfChild);
        }

        @Override // android.view.ViewGroup
        protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
            if (view instanceof ComponentView) {
                view.measure(view.getMeasuredWidth(), view.getMeasuredHeight());
            } else {
                super.measureChildWithMargins(view, i, i2, i3, i4);
            }
        }

        @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            try {
                super.onLayout(z, i, i2, i3, i4);
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            ListStickyManager.this.offsetStickyItemIfNeed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UIComponent getStickyTopComponent() {
        return this.mStickTopInfo.mComponent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UIComponent getStickyBottomComponent() {
        return this.mStickBottomInfo.mComponent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class StickyItemInfo {
        private UIComponent mComponent = null;
        private int mPosition = -1;
    }
}
