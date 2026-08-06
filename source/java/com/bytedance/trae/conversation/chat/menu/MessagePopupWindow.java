package com.bytedance.trae.conversation.chat.menu;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.trae.ServiceType;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MessagePopupWindow.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\rJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;", "", "context", "Landroid/content/Context;", "listener", "Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;", "mode", "Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V", "popupWindow", "Landroid/widget/PopupWindow;", "showAsDropDown", "", "anchor", "Landroid/view/View;", "xOff", "", "yOff", "showAbove", "showBelow", "setOnDismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "dismiss", "isShowing", "", "()Z", "dp2px", "", "dp", "Mode", "OnMenuClickListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class MessagePopupWindow {
    private final OnMenuClickListener listener;
    private final Mode mode;
    private final PopupWindow popupWindow;

    /* compiled from: MessagePopupWindow.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;", "", "onCopyClick", "", "onDeleteClick", "onRevertClick", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnMenuClickListener {
        void onCopyClick();

        void onDeleteClick();

        void onRevertClick();
    }

    /* compiled from: MessagePopupWindow.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.Event.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.Brainstorm.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public MessagePopupWindow(Context context, OnMenuClickListener onMenuClickListener, Mode mode) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onMenuClickListener, "listener");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.listener = onMenuClickListener;
        this.mode = mode;
        View inflate = LayoutInflater.from(context).inflate(C0637R.layout.conversation_message_popup_menu, (ViewGroup) null, false);
        PopupWindow popupWindow = new PopupWindow(inflate, (int) dp2px(context, 240.0f), -2, true);
        this.popupWindow = popupWindow;
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(dp2px(context, 8.0f));
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setOutsideTouchable(true);
        inflate.findViewById(C0637R.id.menu_copy).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessagePopupWindow._init_$lambda$0(MessagePopupWindow.this, view);
            }
        });
        View findViewById = inflate.findViewById(C0637R.id.menu_copy);
        View findViewById2 = inflate.findViewById(C0637R.id.menu_delete);
        View findViewById3 = inflate.findViewById(C0637R.id.menu_revert);
        View findViewById4 = inflate.findViewById(C0637R.id.divider_delete);
        View findViewById5 = inflate.findViewById(C0637R.id.divider_revert);
        int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
        if (i == 1) {
            findViewById2.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById4.setVisibility(8);
            findViewById5.setVisibility(8);
            return;
        }
        if (i == 2) {
            findViewById.setVisibility(8);
            findViewById4.setVisibility(8);
            findViewById5.setVisibility(8);
            findViewById3.setVisibility(8);
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessagePopupWindow._init_$lambda$1(MessagePopupWindow.this, view);
                }
            });
            return;
        }
        findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessagePopupWindow._init_$lambda$2(MessagePopupWindow.this, view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessagePopupWindow._init_$lambda$3(MessagePopupWindow.this, view);
            }
        });
    }

    public /* synthetic */ MessagePopupWindow(Context context, OnMenuClickListener onMenuClickListener, Mode mode, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, onMenuClickListener, (i & 4) != 0 ? Mode.Message : mode);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: MessagePopupWindow.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;", "", "<init>", "(Ljava/lang/String;I)V", ServiceType.f1279IM, "Event", "Brainstorm", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode Message = new Mode(ServiceType.f1279IM, 0);
        public static final Mode Event = new Mode("Event", 1);
        public static final Mode Brainstorm = new Mode("Brainstorm", 2);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{Message, Event, Brainstorm};
        }

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        private Mode(String str, int i) {
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(MessagePopupWindow messagePopupWindow, View view) {
        messagePopupWindow.listener.onCopyClick();
        messagePopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(MessagePopupWindow messagePopupWindow, View view) {
        messagePopupWindow.listener.onDeleteClick();
        messagePopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(MessagePopupWindow messagePopupWindow, View view) {
        messagePopupWindow.listener.onDeleteClick();
        messagePopupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(MessagePopupWindow messagePopupWindow, View view) {
        messagePopupWindow.listener.onRevertClick();
        messagePopupWindow.dismiss();
    }

    public final void showAsDropDown(View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        this.popupWindow.showAtLocation(anchor, 0, iArr[0] + anchor.getWidth() + xOff, iArr[1] + yOff);
    }

    public final void showAbove(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        View contentView = this.popupWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = contentView.getMeasuredHeight();
        int measuredWidth = contentView.getMeasuredWidth();
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int width = (iArr[0] + anchor.getWidth()) - measuredWidth;
        int i = iArr[1] - measuredHeight;
        Context context = anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.popupWindow.showAtLocation(anchor, 0, width, i - ((int) dp2px(context, 4.0f)));
    }

    public final void showBelow(View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (this.popupWindow.isShowing()) {
            return;
        }
        int[] iArr = new int[2];
        anchor.getLocationOnScreen(iArr);
        int i = anchor.getResources().getDisplayMetrics().widthPixels;
        Context context = anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int width = (i - this.popupWindow.getWidth()) - ((int) dp2px(context, 16.0f));
        int height = iArr[1] + anchor.getHeight();
        Context context2 = anchor.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        this.popupWindow.showAtLocation(anchor, 0, width, height + ((int) dp2px(context2, 4.0f)));
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
