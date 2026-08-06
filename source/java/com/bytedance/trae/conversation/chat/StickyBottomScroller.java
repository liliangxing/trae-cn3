package com.bytedance.trae.conversation.chat;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StickyBottomScroller.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0002\u0011\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0012\u0010\u001c\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bJ\u0006\u0010\u001d\u001a\u00020\u0019J\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0019J\b\u0010!\u001a\u00020\u0019H\u0002J\u0012\u0010\"\u001a\u00020\u00192\b\b\u0002\u0010#\u001a\u00020\tH\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\tH\u0002J\u0006\u0010&\u001a\u00020\u0019J\u0006\u0010'\u001a\u00020\u0019J\u0006\u0010(\u001a\u00020\u0019J\b\u0010)\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006*"}, d2 = {"Lcom/bytedance/trae/conversation/chat/StickyBottomScroller;", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/LinearLayoutManager;)V", "isStickToBottom", "", "isUserScrolling", "pendingScroll", "lastRecyclerHeight", "", "hasHandledFirstSubmit", "isDataChangeScrollSuppressed", "scrollListener", "com/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1", "Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$scrollListener$1;", "layoutChangeListener", "Landroid/view/View$OnLayoutChangeListener;", "dataObserver", "com/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1", "Lcom/bytedance/trae/conversation/chat/StickyBottomScroller$dataObserver$1;", "attach", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "detach", "onFirstSubmit", "resetFirstSubmit", "suppressDataChangeScroll", "resumeDataChangeScroll", "handleDataChanged", "scrollToBottomIfNeeded", "animate", "scrollToBottomWithoutAnimation", "isAtBottom", "scrollToBottom", "forceScrollToBottom", "onItemContentChanged", "isContentOverflow", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StickyBottomScroller {
    private final StickyBottomScroller$dataObserver$1 dataObserver;
    private boolean hasHandledFirstSubmit;
    private boolean isDataChangeScrollSuppressed;
    private boolean isStickToBottom;
    private boolean isUserScrolling;
    private int lastRecyclerHeight;
    private final View.OnLayoutChangeListener layoutChangeListener;
    private final LinearLayoutManager layoutManager;
    private boolean pendingScroll;
    private final RecyclerView recyclerView;
    private final StickyBottomScroller$scrollListener$1 scrollListener;

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.trae.conversation.chat.StickyBottomScroller$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.trae.conversation.chat.StickyBottomScroller$dataObserver$1] */
    public StickyBottomScroller(RecyclerView recyclerView, LinearLayoutManager linearLayoutManager) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        this.recyclerView = recyclerView;
        this.layoutManager = linearLayoutManager;
        this.isStickToBottom = true;
        this.scrollListener = new RecyclerView.OnScrollListener() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$scrollListener$1
            public void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                boolean z;
                boolean isAtBottom;
                Intrinsics.checkNotNullParameter(recyclerView2, "recyclerView");
                if (newState != 0) {
                    if (newState != 1) {
                        return;
                    }
                    StickyBottomScroller.this.isUserScrolling = true;
                    StickyBottomScroller.this.isStickToBottom = false;
                    return;
                }
                z = StickyBottomScroller.this.isUserScrolling;
                if (z) {
                    StickyBottomScroller.this.isUserScrolling = false;
                    StickyBottomScroller stickyBottomScroller = StickyBottomScroller.this;
                    isAtBottom = stickyBottomScroller.isAtBottom();
                    stickyBottomScroller.isStickToBottom = isAtBottom;
                }
            }
        };
        this.layoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                StickyBottomScroller.layoutChangeListener$lambda$2(StickyBottomScroller.this, view, i, i2, i3, i4, i5, i6, i7, i8);
            }
        };
        this.dataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$dataObserver$1
            public void onItemRangeInserted(int positionStart, int itemCount) {
                StickyBottomScroller.this.handleDataChanged();
            }

            public void onItemRangeChanged(int positionStart, int itemCount, Object payload) {
                StickyBottomScroller.this.handleDataChanged();
            }

            public void onChanged() {
                StickyBottomScroller.this.handleDataChanged();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutChangeListener$lambda$2(final StickyBottomScroller stickyBottomScroller, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        int i10 = i8 - i6;
        if (i10 > 0 && i9 < i10) {
            stickyBottomScroller.isStickToBottom = true;
            stickyBottomScroller.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    StickyBottomScroller.this.scrollToBottomIfNeeded(false);
                }
            });
        } else if (i10 > 0 && i9 != i10 && stickyBottomScroller.isStickToBottom) {
            stickyBottomScroller.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    StickyBottomScroller.this.scrollToBottomIfNeeded(false);
                }
            });
        }
        stickyBottomScroller.lastRecyclerHeight = i9;
    }

    public final void attach(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.recyclerView.addOnScrollListener(this.scrollListener);
        this.recyclerView.addOnLayoutChangeListener(this.layoutChangeListener);
        adapter.registerAdapterDataObserver(this.dataObserver);
    }

    public final void detach(RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.recyclerView.removeOnScrollListener(this.scrollListener);
        this.recyclerView.removeOnLayoutChangeListener(this.layoutChangeListener);
        adapter.unregisterAdapterDataObserver(this.dataObserver);
    }

    public final void onFirstSubmit() {
        if (this.hasHandledFirstSubmit) {
            return;
        }
        this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.onFirstSubmit$lambda$3(StickyBottomScroller.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onFirstSubmit$lambda$3(StickyBottomScroller stickyBottomScroller) {
        if (stickyBottomScroller.hasHandledFirstSubmit || stickyBottomScroller.layoutManager.getItemCount() == 0) {
            return;
        }
        stickyBottomScroller.hasHandledFirstSubmit = true;
        if (stickyBottomScroller.isContentOverflow()) {
            stickyBottomScroller.scrollToBottomWithoutAnimation();
        }
    }

    public final void resetFirstSubmit() {
        this.hasHandledFirstSubmit = false;
        this.isStickToBottom = true;
    }

    public final void suppressDataChangeScroll() {
        this.isDataChangeScrollSuppressed = true;
    }

    public final void resumeDataChangeScroll() {
        this.isDataChangeScrollSuppressed = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDataChanged() {
        if (this.isDataChangeScrollSuppressed || !this.isStickToBottom || this.isUserScrolling || this.pendingScroll) {
            return;
        }
        this.pendingScroll = true;
        this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.handleDataChanged$lambda$4(StickyBottomScroller.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDataChanged$lambda$4(StickyBottomScroller stickyBottomScroller) {
        stickyBottomScroller.pendingScroll = false;
        if (!stickyBottomScroller.isStickToBottom || stickyBottomScroller.isUserScrolling) {
            return;
        }
        scrollToBottomIfNeeded$default(stickyBottomScroller, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void scrollToBottomIfNeeded$default(StickyBottomScroller stickyBottomScroller, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = stickyBottomScroller.layoutManager.isSmoothScrollbarEnabled();
        }
        stickyBottomScroller.scrollToBottomIfNeeded(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToBottomIfNeeded(boolean animate) {
        int itemCount = this.layoutManager.getItemCount() - 1;
        if (itemCount < 0) {
            return;
        }
        View findViewByPosition = this.layoutManager.findViewByPosition(itemCount);
        if (findViewByPosition != null) {
            int bottom = findViewByPosition.getBottom() - (this.recyclerView.getHeight() - this.recyclerView.getPaddingBottom());
            if (bottom > 0) {
                if (animate) {
                    this.recyclerView.smoothScrollBy(0, bottom);
                    return;
                } else {
                    this.recyclerView.scrollBy(0, bottom);
                    return;
                }
            }
            return;
        }
        scrollToBottomWithoutAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToBottomWithoutAnimation() {
        int itemCount = this.layoutManager.getItemCount();
        if (itemCount == 0) {
            return;
        }
        final int i = itemCount - 1;
        this.layoutManager.scrollToPositionWithOffset(i, Integer.MIN_VALUE);
        this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.scrollToBottomWithoutAnimation$lambda$5(StickyBottomScroller.this, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToBottomWithoutAnimation$lambda$5(StickyBottomScroller stickyBottomScroller, int i) {
        View findViewByPosition = stickyBottomScroller.layoutManager.findViewByPosition(i);
        if (findViewByPosition == null) {
            return;
        }
        int bottom = findViewByPosition.getBottom() - (stickyBottomScroller.recyclerView.getHeight() - stickyBottomScroller.recyclerView.getPaddingBottom());
        if (bottom > 0) {
            stickyBottomScroller.recyclerView.scrollBy(0, bottom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAtBottom() {
        int itemCount = this.layoutManager.getItemCount();
        return itemCount == 0 || this.layoutManager.findLastCompletelyVisibleItemPosition() >= itemCount - 1;
    }

    public final void scrollToBottom() {
        if (isAtBottom()) {
            this.isStickToBottom = true;
            this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    StickyBottomScroller.scrollToBottom$lambda$7(StickyBottomScroller.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scrollToBottom$lambda$7(final StickyBottomScroller stickyBottomScroller) {
        scrollToBottomIfNeeded$default(stickyBottomScroller, false, 1, null);
        stickyBottomScroller.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.scrollToBottomIfNeeded$default(StickyBottomScroller.this, false, 1, null);
            }
        });
    }

    public final void forceScrollToBottom() {
        this.isStickToBottom = true;
        this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.this.scrollToBottomWithoutAnimation();
            }
        });
    }

    public final void onItemContentChanged() {
        if (!this.isStickToBottom || this.isUserScrolling || this.pendingScroll) {
            return;
        }
        this.pendingScroll = true;
        this.recyclerView.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.StickyBottomScroller$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                StickyBottomScroller.onItemContentChanged$lambda$9(StickyBottomScroller.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onItemContentChanged$lambda$9(StickyBottomScroller stickyBottomScroller) {
        stickyBottomScroller.pendingScroll = false;
        if (!stickyBottomScroller.isStickToBottom || stickyBottomScroller.isUserScrolling) {
            return;
        }
        scrollToBottomIfNeeded$default(stickyBottomScroller, false, 1, null);
    }

    private final boolean isContentOverflow() {
        int itemCount = this.layoutManager.getItemCount() - 1;
        if (itemCount < 0) {
            return false;
        }
        View findViewByPosition = this.layoutManager.findViewByPosition(itemCount);
        return findViewByPosition != null ? findViewByPosition.getBottom() > this.recyclerView.getHeight() - this.recyclerView.getPaddingBottom() : this.layoutManager.findLastVisibleItemPosition() < itemCount;
    }
}
