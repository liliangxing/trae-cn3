package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.bytedance.trae.conversation.R;
import com.bytedance.trae.conversation.tracker.InputTracker;
import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes5.dex */
public class MenuPopupWindow {
    private View contentView;
    private boolean isPinned;
    private OnMenuClickListener listener;
    private PopupWindow popupWindow;
    private boolean showArtifact;
    private boolean showPin;

    /* loaded from: classes5.dex */
    public interface OnMenuClickListener {
        void onArtifactClick();

        void onDeleteClick();

        void onExtractClick();

        void onPinClick();

        void onRenameClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$5$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8229xc2c68c87(View view) {
        trackMenuActionClick("extract");
        OnMenuClickListener onMenuClickListener = this.listener;
        if (onMenuClickListener != null) {
            onMenuClickListener.onExtractClick();
        }
        dismiss();
    }

    public MenuPopupWindow(Context context, OnMenuClickListener onMenuClickListener) {
        this(context, onMenuClickListener, true, false, false);
    }

    public MenuPopupWindow(Context context, OnMenuClickListener onMenuClickListener, boolean z) {
        this(context, onMenuClickListener, z, false, false);
    }

    public MenuPopupWindow(Context context, OnMenuClickListener onMenuClickListener, boolean z, boolean z2, boolean z3) {
        this.listener = onMenuClickListener;
        this.showArtifact = z;
        this.showPin = z2;
        this.isPinned = z3;
        init(context);
    }

    private void init(Context context) {
        this.contentView = LayoutInflater.from(context).inflate(R.layout.conversation_popup_menu, (ViewGroup) null, false);
        PopupWindow popupWindow = new PopupWindow(this.contentView, -2, -2, true);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow.setElevation(dp2px(context, 8.0f));
        this.popupWindow.setAnimationStyle(android.R.style.Animation.Dialog);
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda0
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                MenuPopupWindow.this.m8224xbcb6ee2c();
            }
        });
        this.contentView.findViewById(R.id.menu_extract).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuPopupWindow.this.m8229xc2c68c87(view);
            }
        });
        this.contentView.findViewById(R.id.menu_artifact).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuPopupWindow.this.m8225xbded410b(view);
            }
        });
        this.contentView.findViewById(R.id.menu_pin).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuPopupWindow.this.m8226xbf2393ea(view);
            }
        });
        this.contentView.findViewById(R.id.menu_rename).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuPopupWindow.this.m8227xc059e6c9(view);
            }
        });
        this.contentView.findViewById(R.id.menu_delete).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.widget.MenuPopupWindow$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuPopupWindow.this.m8228xc19039a8(view);
            }
        });
        if (!this.showArtifact) {
            this.contentView.findViewById(R.id.menu_artifact).setVisibility(8);
            this.contentView.findViewById(R.id.menu_divider_artifact).setVisibility(8);
        }
        updatePinState(this.showPin, this.isPinned);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$0$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8224xbcb6ee2c() {
        View view = this.contentView;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$1$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8225xbded410b(View view) {
        trackMenuActionClick("artifacts");
        OnMenuClickListener onMenuClickListener = this.listener;
        if (onMenuClickListener != null) {
            onMenuClickListener.onArtifactClick();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$2$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8226xbf2393ea(View view) {
        trackMenuActionClick(this.isPinned ? "unpin" : "pin");
        OnMenuClickListener onMenuClickListener = this.listener;
        if (onMenuClickListener != null) {
            onMenuClickListener.onPinClick();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$3$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8227xc059e6c9(View view) {
        trackMenuActionClick("rename");
        OnMenuClickListener onMenuClickListener = this.listener;
        if (onMenuClickListener != null) {
            onMenuClickListener.onRenameClick();
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$init$4$com-bytedance-trae-conversation-widget-MenuPopupWindow, reason: not valid java name */
    public /* synthetic */ void m8228xc19039a8(View view) {
        trackMenuActionClick("delete");
        OnMenuClickListener onMenuClickListener = this.listener;
        if (onMenuClickListener != null) {
            onMenuClickListener.onDeleteClick();
        }
        dismiss();
    }

    public void updatePinState(boolean z, boolean z2) {
        int i;
        int i2;
        this.showPin = z;
        this.isPinned = z2;
        View view = this.contentView;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.menu_pin);
        View findViewById2 = this.contentView.findViewById(R.id.menu_divider_pin);
        if (z) {
            findViewById.setVisibility(0);
            findViewById2.setVisibility(0);
            ImageView imageView = (ImageView) this.contentView.findViewById(R.id.iv_menu_pin);
            TextView textView = (TextView) this.contentView.findViewById(R.id.tv_menu_pin);
            if (z2) {
                i = com.bytedance.trae.common_ui.R.drawable.trae_ic_context_menu_unpin;
            } else {
                i = com.bytedance.trae.common_ui.R.drawable.trae_ic_context_menu_pin;
            }
            imageView.setImageResource(i);
            if (z2) {
                i2 = com.bytedance.trae.multilanguage.R.string.trae_conversation_menu_unpin;
            } else {
                i2 = com.bytedance.trae.multilanguage.R.string.trae_conversation_menu_pin;
            }
            textView.setText(i2);
            return;
        }
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
    }

    public void showAsDropDown(View view, int i, int i2) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null || popupWindow.isShowing()) {
            return;
        }
        this.contentView.setVisibility(0);
        int dp2px = (int) dp2px(view.getContext(), 16.0f);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.popupWindow.showAtLocation(view, BadgeDrawable.TOP_END, dp2px, iArr[1] + view.getHeight() + i2);
    }

    public void showAtLocation(View view, int i, int i2, int i3) {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null || popupWindow.isShowing()) {
            return;
        }
        this.popupWindow.showAtLocation(view, i, i2, i3);
    }

    public void dismiss() {
        PopupWindow popupWindow = this.popupWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        this.popupWindow.dismiss();
    }

    public boolean isShowing() {
        PopupWindow popupWindow = this.popupWindow;
        return popupWindow != null && popupWindow.isShowing();
    }

    private void trackMenuActionClick(String str) {
        InputTracker.INSTANCE.trackConversationMenuItemClick(str);
    }

    private float dp2px(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }
}
