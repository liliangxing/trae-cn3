package com.bytedance.trae.conversation.chat.menu;

import android.R;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: AgentMessageMenu.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J.\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;", "", "context", "Landroid/content/Context;", "listener", "Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;", "<init>", "(Landroid/content/Context;Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;)V", "popupWindow", "Landroid/widget/PopupWindow;", "density", "", "showNear", "", "parent", "Landroid/view/View;", "rawX", "rawY", "dismiss", "isShowing", "", "()Z", "buildContentView", "createItemView", "iconRes", "", "textRes", "onClick", "Lkotlin/Function0;", "createDivider", "dp", "value", "resolveSelectableItemBackground", "OnMenuClickListener", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AgentMessageMenu {
    private final float density;
    private final OnMenuClickListener listener;
    private final PopupWindow popupWindow;

    /* compiled from: AgentMessageMenu.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;", "", "onCopyClick", "", "onSelectTextClick", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public interface OnMenuClickListener {
        void onCopyClick();

        void onSelectTextClick();
    }

    public AgentMessageMenu(Context context, OnMenuClickListener onMenuClickListener) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onMenuClickListener, "listener");
        this.listener = onMenuClickListener;
        this.density = context.getResources().getDisplayMetrics().density;
        PopupWindow popupWindow = new PopupWindow(buildContentView(context), m827dp(180), -2, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(m827dp(8));
        popupWindow.setAnimationStyle(R.style.Animation.Dialog);
        popupWindow.setOutsideTouchable(true);
        this.popupWindow = popupWindow;
    }

    public final void showNear(View parent, float rawX, float rawY) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (this.popupWindow.isShowing()) {
            return;
        }
        View contentView = this.popupWindow.getContentView();
        contentView.measure(View.MeasureSpec.makeMeasureSpec(this.popupWindow.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int width = this.popupWindow.getWidth();
        int measuredHeight = contentView.getMeasuredHeight();
        int i = parent.getResources().getDisplayMetrics().widthPixels;
        int i2 = parent.getResources().getDisplayMetrics().heightPixels;
        int coerceIn = RangesKt.coerceIn(MathKt.roundToInt(rawX - (width / 2.0f)), m827dp(8), Math.max(m827dp(8), (i - width) - m827dp(8)));
        int roundToInt = MathKt.roundToInt((rawY - measuredHeight) - m827dp(8));
        if (roundToInt < 0) {
            roundToInt = MathKt.roundToInt(rawY + m827dp(16));
        }
        this.popupWindow.showAtLocation(parent, 0, coerceIn, RangesKt.coerceIn(roundToInt, 0, Math.max(0, i2 - measuredHeight)));
    }

    public final void dismiss() {
        if (this.popupWindow.isShowing()) {
            this.popupWindow.dismiss();
        }
    }

    public final boolean isShowing() {
        return this.popupWindow.isShowing();
    }

    private final View buildContentView(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setBackground(ContextCompat.getDrawable(context, C0591R.drawable.trae_bg_context_menu_popup));
        int m827dp = m827dp(8);
        linearLayout.setPadding(0, m827dp, 0, m827dp);
        linearLayout.addView(createItemView(context, C0637R.drawable.trae_ic_copy, C0637R.string.trae_message_menu_copy, new Function0() { // from class: com.bytedance.trae.conversation.chat.menu.AgentMessageMenu$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit buildContentView$lambda$4$lambda$2;
                buildContentView$lambda$4$lambda$2 = AgentMessageMenu.buildContentView$lambda$4$lambda$2(AgentMessageMenu.this);
                return buildContentView$lambda$4$lambda$2;
            }
        }));
        linearLayout.addView(createDivider(context));
        linearLayout.addView(createItemView(context, C0637R.drawable.trae_ic_select_text, C0637R.string.trae_message_menu_select_text, new Function0() { // from class: com.bytedance.trae.conversation.chat.menu.AgentMessageMenu$$ExternalSyntheticLambda1
            public final Object invoke() {
                Unit buildContentView$lambda$4$lambda$3;
                buildContentView$lambda$4$lambda$3 = AgentMessageMenu.buildContentView$lambda$4$lambda$3(AgentMessageMenu.this);
                return buildContentView$lambda$4$lambda$3;
            }
        }));
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildContentView$lambda$4$lambda$2(AgentMessageMenu agentMessageMenu) {
        agentMessageMenu.dismiss();
        agentMessageMenu.listener.onCopyClick();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildContentView$lambda$4$lambda$3(AgentMessageMenu agentMessageMenu) {
        agentMessageMenu.dismiss();
        agentMessageMenu.listener.onSelectTextClick();
        return Unit.INSTANCE;
    }

    private final View createItemView(Context context, int iconRes, int textRes, final Function0<Unit> onClick) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, m827dp(44)));
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        int m827dp = m827dp(16);
        linearLayout.setPadding(m827dp, 0, m827dp, 0);
        linearLayout.setClickable(true);
        linearLayout.setFocusable(true);
        linearLayout.setBackgroundResource(resolveSelectableItemBackground(context));
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.menu.AgentMessageMenu$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClick.invoke();
            }
        });
        ImageView imageView = new ImageView(context);
        int m827dp2 = m827dp(20);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(m827dp2, m827dp2));
        imageView.setImageResource(iconRes);
        ImageViewCompat.setImageTintList(imageView, ContextCompat.getColorStateList(context, C0591R.color.trae_icon_icon_default));
        imageView.setImportantForAccessibility(2);
        linearLayout.addView(imageView);
        TextView textView = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMarginStart(m827dp(13));
        textView.setLayoutParams(layoutParams);
        TextViewCompat.setTextAppearance(textView, C0591R.style.Trae_Text_Body_Base);
        textView.setText(context.getString(textRes));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        textView.setMaxLines(1);
        linearLayout.addView(textView);
        return linearLayout;
    }

    private final View createDivider(Context context) {
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, MathKt.roundToInt(this.density * 0.5f));
        int m827dp = m827dp(16);
        layoutParams.setMarginStart(m827dp);
        layoutParams.setMarginEnd(m827dp);
        view.setLayoutParams(layoutParams);
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
        return view;
    }

    /* renamed from: dp */
    private final int m827dp(int value) {
        return MathKt.roundToInt(value * this.density);
    }

    private final int resolveSelectableItemBackground(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.selectableItemBackground, typedValue, true);
        return typedValue.resourceId;
    }
}
