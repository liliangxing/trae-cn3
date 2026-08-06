package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer;
import com.bytedance.trae.conversation.chat.viewholder.AgentMessageViewHolder;
import com.bytedance.trae.multilanguage.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionBarRenderer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J<\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\rH\u0002J\u0018\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\rH\u0002¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;", "<init>", "()V", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "createIconButton", "Landroid/widget/FrameLayout;", "iconRes", "", "btnSize", "iconSize", "enabled", "", "iconColor", "setIconTint", "", "icon", "Landroid/widget/ImageView;", "color", "dimenPx", "resId", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ActionBarRenderer implements IBlockRenderer<AgentContentBlock.ActionBar> {
    private static final String BLOCK_TAG = "AgentBlock";
    public static final String COPY_TAG = "copy_button";
    public static final String THUMBS_DOWN_TAG = "thumbs_down_button";
    public static final String THUMBS_UP_TAG = "thumbs_up_button";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<Integer, Drawable.ConstantState> drawableCache = new HashMap<>();

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.ActionBar actionBar) {
        IBlockRenderer.DefaultImpls.update(this, view, actionBar);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00de  */
    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View render(Context context, AgentContentBlock.ActionBar block) {
        Integer num;
        Integer valueOf;
        int i;
        LinearLayout linearLayout;
        final AgentContentBlock.ActionBar actionBar;
        int i2;
        int i3;
        Resources resources;
        int i4;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        int i5;
        LinearLayout.LayoutParams layoutParams;
        int i6;
        LinearLayout.LayoutParams layoutParams2;
        LinearLayout linearLayout4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        Resources resources2 = context.getResources();
        float f = resources2.getDisplayMetrics().density;
        int dimenPx = block.isVoiceSummaryStyle() ? (int) (30 * f) : dimenPx(context, C0637R.dimen.trae_dp_36);
        int dimenPx2 = block.isVoiceSummaryStyle() ? (int) (18 * f) : dimenPx(context, C0637R.dimen.trae_dp_20);
        int dimenPx3 = dimenPx(context, block.isVoiceSummaryStyle() ? C0637R.dimen.trae_dp_8 : C0637R.dimen.trae_dp_2);
        int dimenPx4 = dimenPx(context, C0637R.dimen.trae_dp_4);
        int dimenPx5 = dimenPx(context, C0637R.dimen.trae_dp_8);
        int dimenPx6 = dimenPx(context, C0637R.dimen.trae_dp_16);
        int dimenPx7 = dimenPx(context, C0637R.dimen.trae_action_bar_divider_width);
        int color = ContextCompat.getColor(context, C0591R.color.trae_icon_icon_default);
        int color2 = ContextCompat.getColor(context, C0591R.color.trae_icon_icon_brand);
        if (block.getShowInterjectedStatus()) {
            valueOf = Integer.valueOf(C0637R.string.trae_chat_append_interjected_status);
        } else {
            if (!block.getShowManualStopStatus()) {
                num = null;
                LinearLayout linearLayout5 = new LinearLayout(context);
                linearLayout5.setOrientation(1);
                linearLayout5.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                LinearLayout linearLayout6 = new LinearLayout(context);
                linearLayout6.setOrientation(0);
                linearLayout6.setGravity(16);
                LinearLayout linearLayout7 = linearLayout6;
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, dimenPx);
                if (block.getShowFeedback() || !block.isVoiceSummaryStyle()) {
                    i = !block.getShowFeedback() ? dimenPx6 : dimenPx5;
                } else {
                    i = (int) (12 * f);
                }
                layoutParams3.topMargin = i;
                Unit unit = Unit.INSTANCE;
                linearLayout5.addView(linearLayout7, layoutParams3);
                if (num == null) {
                    LinearLayout linearLayout8 = new LinearLayout(context);
                    linearLayout8.setOrientation(0);
                    linearLayout8.setGravity(16);
                    linearLayout8.setPadding(0, 0, dimenPx4, 0);
                    linearLayout = linearLayout5;
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams4.gravity = 16;
                    Unit unit2 = Unit.INSTANCE;
                    linearLayout6.addView(linearLayout8, layoutParams4);
                    FrameLayout frameLayout = new FrameLayout(context);
                    LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(dimenPx(context, C0637R.dimen.trae_dp_20), dimenPx(context, C0637R.dimen.trae_dp_20));
                    layoutParams5.gravity = 16;
                    Unit unit3 = Unit.INSTANCE;
                    linearLayout8.addView(frameLayout, layoutParams5);
                    ImageView imageView = new ImageView(context);
                    imageView.setImageResource(C0637R.drawable.trae_ic_minus_circle);
                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    setIconTint(imageView, color);
                    FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(dimenPx(context, C0637R.dimen.trae_dp_18), dimenPx(context, C0637R.dimen.trae_dp_18));
                    layoutParams6.gravity = 17;
                    Unit unit4 = Unit.INSTANCE;
                    frameLayout.addView(imageView, layoutParams6);
                    TextView textView = new TextView(context);
                    textView.setText(num.intValue());
                    textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
                    textView.setIncludeFontPadding(false);
                    textView.setTextSize(0, resources2.getDimension(C0591R.dimen.trae_body_body_xs_font_size_sp));
                    TextViewCompat.setLineHeight(textView, resources2.getDimensionPixelSize(C0591R.dimen.trae_body_body_xs_line_height_dp));
                    LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams7.gravity = 16;
                    layoutParams7.setMarginStart(dimenPx4);
                    Unit unit5 = Unit.INSTANCE;
                    linearLayout8.addView(textView, layoutParams7);
                    View view = new View(context);
                    view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l1));
                    LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(dimenPx7, dimenPx(context, C0637R.dimen.trae_dp_16));
                    layoutParams8.gravity = 16;
                    layoutParams8.setMarginStart(dimenPx5);
                    Unit unit6 = Unit.INSTANCE;
                    linearLayout6.addView(view, layoutParams8);
                } else {
                    linearLayout = linearLayout5;
                }
                if (block.getShowFeedback()) {
                    actionBar = block;
                    i2 = dimenPx5;
                    i3 = dimenPx4;
                    resources = resources2;
                    i4 = dimenPx3;
                    linearLayout2 = linearLayout;
                    linearLayout3 = linearLayout6;
                    i5 = color;
                } else {
                    boolean z = block.getFeedbackState() == AgentContentBlock.FeedbackState.THUMBS_UP;
                    linearLayout2 = linearLayout;
                    i5 = color;
                    i2 = dimenPx5;
                    i3 = dimenPx4;
                    FrameLayout createIconButton$default = createIconButton$default(this, context, z ? C0637R.drawable.trae_ic_thumbs_up_filled : C0637R.drawable.trae_ic_thumbs_up, dimenPx, dimenPx2, false, 0, 48, null);
                    createIconButton$default.setTag(THUMBS_UP_TAG);
                    View childAt = createIconButton$default.getChildAt(0);
                    Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                    setIconTint((ImageView) childAt, z ? color2 : i5);
                    actionBar = block;
                    createIconButton$default.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ActionBarRenderer.render$lambda$12(AgentContentBlock.ActionBar.this, view2);
                        }
                    });
                    linearLayout6.addView(createIconButton$default);
                    boolean z2 = block.getFeedbackState() == AgentContentBlock.FeedbackState.THUMBS_DOWN;
                    resources = resources2;
                    linearLayout3 = linearLayout6;
                    FrameLayout createIconButton$default2 = createIconButton$default(this, context, z2 ? C0637R.drawable.trae_ic_thumbs_down_filled : C0637R.drawable.trae_ic_thumbs_down, dimenPx, dimenPx2, false, 0, 48, null);
                    createIconButton$default2.setTag(THUMBS_DOWN_TAG);
                    View childAt2 = createIconButton$default2.getChildAt(0);
                    Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.widget.ImageView");
                    setIconTint((ImageView) childAt2, z2 ? color2 : i5);
                    createIconButton$default2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ActionBarRenderer.render$lambda$13(AgentContentBlock.ActionBar.this, view2);
                        }
                    });
                    ViewGroup.LayoutParams layoutParams9 = createIconButton$default2.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams10 = layoutParams9 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams9 : null;
                    i4 = dimenPx3;
                    if (layoutParams10 != null) {
                        layoutParams10.setMarginStart(i4);
                    }
                    linearLayout3.addView(createIconButton$default2);
                }
                int i7 = i4;
                FrameLayout createIconButton$default3 = createIconButton$default(this, context, C0637R.drawable.trae_ic_copy, dimenPx, dimenPx2, false, i5, 16, null);
                createIconButton$default3.setTag(COPY_TAG);
                createIconButton$default3.setContentDescription(context.getString(C0637R.string.trae_message_menu_copy));
                createIconButton$default3.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ActionBarRenderer.render$lambda$14(AgentContentBlock.ActionBar.this, view2);
                    }
                });
                int i8 = !block.getShowFeedback() ? i7 : num != null ? i2 : 0;
                ViewGroup.LayoutParams layoutParams11 = createIconButton$default3.getLayoutParams();
                layoutParams = !(layoutParams11 instanceof LinearLayout.LayoutParams) ? (LinearLayout.LayoutParams) layoutParams11 : null;
                if (layoutParams != null) {
                    layoutParams.setMarginStart(i8);
                }
                linearLayout3.addView(createIconButton$default3);
                if (block.isVoiceSummaryStyle()) {
                    linearLayout3.addView(new Space(context), new LinearLayout.LayoutParams(0, 0, 1.0f));
                }
                if (!block.isVoiceSummaryStyle()) {
                    i6 = C0637R.drawable.trae_ic_more;
                } else {
                    i6 = C0637R.drawable.trae_ic_more;
                }
                FrameLayout createIconButton$default4 = createIconButton$default(this, context, i6, dimenPx, dimenPx2, false, 0, 48, null);
                createIconButton$default4.setTag(AgentMessageViewHolder.MORE_BUTTON_TAG);
                Intrinsics.checkNotNull(createIconButton$default4, "null cannot be cast to non-null type android.widget.FrameLayout");
                View childAt3 = createIconButton$default4.getChildAt(0);
                Intrinsics.checkNotNull(childAt3, "null cannot be cast to non-null type android.widget.ImageView");
                ((ImageView) childAt3).setColorFilter(!block.isVoiceSummaryStyle() ? Color.rgb(49, 53, 58) : i5);
                createIconButton$default4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ActionBarRenderer.render$lambda$15(AgentContentBlock.ActionBar.this, view2);
                    }
                });
                ViewGroup.LayoutParams layoutParams12 = createIconButton$default4.getLayoutParams();
                layoutParams2 = layoutParams12 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams12 : null;
                if (layoutParams2 != null) {
                    layoutParams2.setMarginStart(i7);
                }
                linearLayout3.addView(createIconButton$default4);
                if (!block.isVoiceSummaryStyle()) {
                    linearLayout3.addView(new Space(context), new LinearLayout.LayoutParams(0, 0, 1.0f));
                }
                if (block.getShowFeedback() || block.isVoiceSummaryStyle()) {
                    linearLayout4 = linearLayout2;
                } else {
                    TextView textView2 = new TextView(context);
                    textView2.setText(R.string.trae_conversation_generated_by_ai);
                    textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
                    textView2.setTextSize(0, resources.getDimension(C0591R.dimen.trae_font_size_sp));
                    LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams13.topMargin = i3;
                    Unit unit7 = Unit.INSTANCE;
                    linearLayout4 = linearLayout2;
                    linearLayout4.addView(textView2, layoutParams13);
                }
                return linearLayout4;
            }
            valueOf = Integer.valueOf(C0637R.string.trae_chat_manual_stop_status);
        }
        num = valueOf;
        LinearLayout linearLayout52 = new LinearLayout(context);
        linearLayout52.setOrientation(1);
        linearLayout52.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout62 = new LinearLayout(context);
        linearLayout62.setOrientation(0);
        linearLayout62.setGravity(16);
        LinearLayout linearLayout72 = linearLayout62;
        LinearLayout.LayoutParams layoutParams32 = new LinearLayout.LayoutParams(-1, dimenPx);
        if (block.getShowFeedback()) {
        }
        if (!block.getShowFeedback()) {
        }
        layoutParams32.topMargin = i;
        Unit unit8 = Unit.INSTANCE;
        linearLayout52.addView(linearLayout72, layoutParams32);
        if (num == null) {
        }
        if (block.getShowFeedback()) {
        }
        int i72 = i4;
        FrameLayout createIconButton$default32 = createIconButton$default(this, context, C0637R.drawable.trae_ic_copy, dimenPx, dimenPx2, false, i5, 16, null);
        createIconButton$default32.setTag(COPY_TAG);
        createIconButton$default32.setContentDescription(context.getString(C0637R.string.trae_message_menu_copy));
        createIconButton$default32.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionBarRenderer.render$lambda$14(AgentContentBlock.ActionBar.this, view2);
            }
        });
        if (!block.getShowFeedback()) {
        }
        ViewGroup.LayoutParams layoutParams112 = createIconButton$default32.getLayoutParams();
        if (!(layoutParams112 instanceof LinearLayout.LayoutParams)) {
        }
        if (layoutParams != null) {
        }
        linearLayout3.addView(createIconButton$default32);
        if (block.isVoiceSummaryStyle()) {
        }
        if (!block.isVoiceSummaryStyle()) {
        }
        FrameLayout createIconButton$default42 = createIconButton$default(this, context, i6, dimenPx, dimenPx2, false, 0, 48, null);
        createIconButton$default42.setTag(AgentMessageViewHolder.MORE_BUTTON_TAG);
        Intrinsics.checkNotNull(createIconButton$default42, "null cannot be cast to non-null type android.widget.FrameLayout");
        View childAt32 = createIconButton$default42.getChildAt(0);
        Intrinsics.checkNotNull(childAt32, "null cannot be cast to non-null type android.widget.ImageView");
        ((ImageView) childAt32).setColorFilter(!block.isVoiceSummaryStyle() ? Color.rgb(49, 53, 58) : i5);
        createIconButton$default42.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ActionBarRenderer.render$lambda$15(AgentContentBlock.ActionBar.this, view2);
            }
        });
        ViewGroup.LayoutParams layoutParams122 = createIconButton$default42.getLayoutParams();
        layoutParams2 = layoutParams122 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams122 : null;
        if (layoutParams2 != null) {
        }
        linearLayout3.addView(createIconButton$default42);
        if (!block.isVoiceSummaryStyle()) {
        }
        if (block.getShowFeedback()) {
        }
        linearLayout4 = linearLayout2;
        return linearLayout4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$12(AgentContentBlock.ActionBar actionBar, View view) {
        Function1<AgentContentBlock.ActionType, Unit> onActionClick = actionBar.getOnActionClick();
        if (onActionClick != null) {
            onActionClick.invoke(AgentContentBlock.ActionType.THUMBS_UP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$13(AgentContentBlock.ActionBar actionBar, View view) {
        Function1<AgentContentBlock.ActionType, Unit> onActionClick = actionBar.getOnActionClick();
        if (onActionClick != null) {
            onActionClick.invoke(AgentContentBlock.ActionType.THUMBS_DOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$14(AgentContentBlock.ActionBar actionBar, View view) {
        Function1<AgentContentBlock.ActionType, Unit> onActionClick = actionBar.getOnActionClick();
        if (onActionClick != null) {
            onActionClick.invoke(AgentContentBlock.ActionType.COPY);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$15(AgentContentBlock.ActionBar actionBar, View view) {
        Function1<AgentContentBlock.ActionType, Unit> onActionClick = actionBar.getOnActionClick();
        if (onActionClick != null) {
            onActionClick.invoke(AgentContentBlock.ActionType.MORE);
        }
    }

    static /* synthetic */ FrameLayout createIconButton$default(ActionBarRenderer actionBarRenderer, Context context, int i, int i2, int i3, boolean z, int i4, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i5 & 32) != 0) {
            i4 = ContextCompat.getColor(context, C0591R.color.trae_icon_icon_default);
        }
        return actionBarRenderer.createIconButton(context, i, i2, i3, z2, i4);
    }

    private final FrameLayout createIconButton(Context context, int iconRes, int btnSize, int iconSize, boolean enabled, int iconColor) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setEnabled(enabled);
        frameLayout.setClickable(enabled);
        frameLayout.setFocusable(enabled);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(btnSize, btnSize));
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(INSTANCE.getCachedDrawable(context, iconRes));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setIconTint(imageView, iconColor);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iconSize, iconSize);
        layoutParams.gravity = 17;
        frameLayout.addView(imageView, layoutParams);
        return frameLayout;
    }

    private final void setIconTint(ImageView icon, int color) {
        ImageViewCompat.setImageTintList(icon, ColorStateList.valueOf(color));
    }

    private final int dimenPx(Context context, int resId) {
        return context.getResources().getDimensionPixelSize(resId);
    }

    /* compiled from: ActionBarRenderer.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "THUMBS_UP_TAG", "THUMBS_DOWN_TAG", "COPY_TAG", "drawableCache", "Ljava/util/HashMap;", "", "Landroid/graphics/drawable/Drawable$ConstantState;", "Lkotlin/collections/HashMap;", "getCachedDrawable", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "resId", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Drawable getCachedDrawable(Context context, int resId) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) ActionBarRenderer.drawableCache.get(Integer.valueOf(resId));
            if (constantState != null) {
                Drawable mutate = constantState.newDrawable(context.getResources()).mutate();
                Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
                return mutate;
            }
            Drawable drawable = ContextCompat.getDrawable(context, resId);
            if (drawable == null) {
                Drawable drawable2 = ContextCompat.getDrawable(context, resId);
                Intrinsics.checkNotNull(drawable2);
                return drawable2;
            }
            Drawable.ConstantState constantState2 = drawable.getConstantState();
            if (constantState2 != null) {
                ActionBarRenderer.drawableCache.put(Integer.valueOf(resId), constantState2);
            }
            Drawable mutate2 = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate2, "mutate(...)");
            return mutate2;
        }
    }
}
