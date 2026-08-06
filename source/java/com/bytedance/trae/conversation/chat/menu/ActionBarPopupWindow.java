package com.bytedance.trae.conversation.chat.menu;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.bytedance.trae.common.widget.ContextMenuPopupWindow;
import com.bytedance.trae.conversation.C0637R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionBarPopupWindow.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow;", "", "context", "Landroid/content/Context;", "listener", "Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;", "showRetry", "", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;Z)V", "contextMenuPopupWindow", "Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;", "showAbove", "", "anchor", "Landroid/view/View;", "horizontalAnchor", "setOnDismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "dismiss", "isShowing", "()Z", "OnMenuClickListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ActionBarPopupWindow {
    private final ContextMenuPopupWindow contextMenuPopupWindow;
    private final OnMenuClickListener listener;
    private final boolean showRetry;

    /* compiled from: ActionBarPopupWindow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/ActionBarPopupWindow$OnMenuClickListener;", "", "onRetryClick", "", "onReportClick", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnMenuClickListener {
        void onReportClick();

        void onRetryClick();
    }

    public ActionBarPopupWindow(Context context, OnMenuClickListener onMenuClickListener, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onMenuClickListener, "listener");
        this.listener = onMenuClickListener;
        this.showRetry = z;
        List createListBuilder = CollectionsKt.createListBuilder();
        if (z) {
            int i = C0637R.drawable.trae_ic_retry;
            String string = context.getString(C0637R.string.trae_message_menu_retry);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            createListBuilder.add(new ContextMenuPopupWindow.Item(i, string, false, null, null, 0, new Function0() { // from class: com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return ActionBarPopupWindow.lambda$2$lambda$0(ActionBarPopupWindow.this);
                }
            }, 60, null));
        }
        int i2 = C0637R.drawable.trae_ic_report;
        String string2 = context.getString(C0637R.string.trae_message_menu_report);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        createListBuilder.add(new ContextMenuPopupWindow.Item(i2, string2, false, null, null, 0, new Function0() { // from class: com.bytedance.trae.conversation.chat.menu.ActionBarPopupWindow$$ExternalSyntheticLambda1
            public final Object invoke() {
                return ActionBarPopupWindow.lambda$2$lambda$1(ActionBarPopupWindow.this);
            }
        }, 60, null));
        Unit unit = Unit.INSTANCE;
        this.contextMenuPopupWindow = new ContextMenuPopupWindow(context, CollectionsKt.build(createListBuilder), 0, 4, null);
    }

    public /* synthetic */ ActionBarPopupWindow(Context context, OnMenuClickListener onMenuClickListener, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onMenuClickListener, (i & 4) != 0 ? true : z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$0(ActionBarPopupWindow actionBarPopupWindow) {
        actionBarPopupWindow.listener.onRetryClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda$2$lambda$1(ActionBarPopupWindow actionBarPopupWindow) {
        actionBarPopupWindow.listener.onReportClick();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void showAbove$default(ActionBarPopupWindow actionBarPopupWindow, View view, View view2, int i, Object obj) {
        if ((i & 2) != 0) {
            view2 = view;
        }
        actionBarPopupWindow.showAbove(view, view2);
    }

    public final void showAbove(View anchor, View horizontalAnchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(horizontalAnchor, "horizontalAnchor");
        this.contextMenuPopupWindow.showAbove(anchor, horizontalAnchor);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.contextMenuPopupWindow.setOnDismissListener(listener);
    }

    public final void dismiss() {
        this.contextMenuPopupWindow.dismiss();
    }

    public final boolean isShowing() {
        return this.contextMenuPopupWindow.isShowing();
    }
}
