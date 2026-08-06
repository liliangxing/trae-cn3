package com.bytedance.trae.conversation.chat.menu;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.menu.MessagePopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagePopupWindow.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000fJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0017¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;", "", "context", "Landroid/content/Context;", "text", "", "listener", "Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;", "mode", "Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;", "<init>", "(Landroid/content/Context;Ljava/lang/CharSequence;Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V", "popupWindow", "Landroid/widget/PopupWindow;", "showBelow", "", "anchor", "Landroid/view/View;", "setOnDismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "dismiss", "isShowing", "", "()Z", "dp2px", "", "dp", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ExpandedTextPopupWindow {
    private final MessagePopupWindow.OnMenuClickListener listener;
    private final MessagePopupWindow.Mode mode;
    private final PopupWindow popupWindow;

    public ExpandedTextPopupWindow(Context context, CharSequence charSequence, MessagePopupWindow.OnMenuClickListener onMenuClickListener, MessagePopupWindow.Mode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Intrinsics.checkNotNullParameter(onMenuClickListener, "listener");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.listener = onMenuClickListener;
        this.mode = mode;
        View inflate = LayoutInflater.from(context).inflate(C0637R.layout.conversation_expanded_text_popup, (ViewGroup) null, false);
        ((TextView) inflate.findViewById(C0637R.id.tv_full_text)).setText(charSequence);
        inflate.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandedTextPopupWindow.this.dismiss();
            }
        });
        int i = context.getResources().getDisplayMetrics().widthPixels;
        float f = context.getResources().getDisplayMetrics().density;
        int i2 = (((int) (180 * f)) + i) / 2;
        int i3 = (int) (22 * f);
        View findViewById = inflate.findViewById(C0637R.id.ll_menu_container);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMarginStart(i3);
        layoutParams2.width = i2 - i3;
        findViewById.setLayoutParams(layoutParams2);
        PopupWindow popupWindow = new PopupWindow(inflate, i, -1, true);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(dp2px(context, 8.0f));
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setOutsideTouchable(true);
        inflate.findViewById(C0637R.id.menu_copy).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandedTextPopupWindow._init_$lambda$1(ExpandedTextPopupWindow.this, view);
            }
        });
        View findViewById2 = inflate.findViewById(C0637R.id.menu_delete);
        View findViewById3 = inflate.findViewById(C0637R.id.menu_revert);
        View findViewById4 = inflate.findViewById(C0637R.id.divider_delete);
        View findViewById5 = inflate.findViewById(C0637R.id.divider_revert);
        if (mode == MessagePopupWindow.Mode.Event) {
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
            findViewById5.setVisibility(8);
            return;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandedTextPopupWindow._init_$lambda$2(ExpandedTextPopupWindow.this, view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandedTextPopupWindow._init_$lambda$3(ExpandedTextPopupWindow.this, view);
            }
        });
    }

    public /* synthetic */ ExpandedTextPopupWindow(Context context, CharSequence charSequence, MessagePopupWindow.OnMenuClickListener onMenuClickListener, MessagePopupWindow.Mode mode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, charSequence, onMenuClickListener, (i & 8) != 0 ? MessagePopupWindow.Mode.Message : mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(ExpandedTextPopupWindow expandedTextPopupWindow, View view) {
        expandedTextPopupWindow.listener.onCopyClick();
        expandedTextPopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(ExpandedTextPopupWindow expandedTextPopupWindow, View view) {
        expandedTextPopupWindow.listener.onDeleteClick();
        expandedTextPopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(ExpandedTextPopupWindow expandedTextPopupWindow, View view) {
        expandedTextPopupWindow.listener.onRevertClick();
        expandedTextPopupWindow.dismiss();
    }

    public final void showBelow(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        this.popupWindow.showAtLocation(anchor, 0, 0, 0);
    }

    public final void setOnDismissListener(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.popupWindow.setOnDismissListener(listener);
    }

    public final void dismiss() {
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    private final float dp2px(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }
}
