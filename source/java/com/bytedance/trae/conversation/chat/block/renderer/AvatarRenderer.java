package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.TocCreditsPolicy;
import com.bytedance.trae.conversation.chat.UserPayIdentityService;
import com.bytedance.trae.conversation.chat.block.AgentContentBlock;
import com.bytedance.trae.conversation.debug.ConversationDebugInfoCopier;
import com.bytedance.trae.conversation.debug.ConversationDebugLogInfo;
import com.bytedance.trae.conversation.widget.BubbleDrawable;
import com.bytedance.trae.multilanguage.I18nTextProvider;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.trae.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AvatarRenderer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bH\u0002J \u0010\u000f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0014\u0010\u0018\u001a\u00020\r*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;", "Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;", "Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;", "<init>", "()V", "currentPopup", "Landroid/widget/PopupWindow;", "render", "Landroid/view/View;", "context", "Landroid/content/Context;", "block", "showFastTooltip", "", "anchor", "setupDoubleTapCopy", "container", "update", "view", "getAvatarIconSize", "", "resources", "Landroid/content/res/Resources;", "getAvatarNameStartMargin", "applyNameStyle", "Landroid/widget/TextView;", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AvatarRenderer implements IBlockRenderer<AgentContentBlock.Avatar> {

    @Deprecated
    public static final String BLOCK_TAG = "AgentBlock";
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final float WORKSPACE_HEADER_NAME_LETTER_SPACING_EM = -0.025294118f;
    private PopupWindow currentPopup;

    /* compiled from: AvatarRenderer.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$Companion;", "", "<init>", "()V", "BLOCK_TAG", "", "WORKSPACE_HEADER_NAME_LETTER_SPACING_EM", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public View render(final Context context, AgentContentBlock.Avatar block) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        FLogger.INSTANCE.i("AgentBlock", "[AvatarRenderer] render: agentType=" + block.getAgentType() + ", cliType=" + block.getCliType() + ", agentName=" + block.getAgentName());
        float f = context.getResources().getDisplayMetrics().density;
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, resources.getDimensionPixelSize(C0637R.dimen.trae_dp_24)));
        LinearLayout linearLayout2 = linearLayout;
        setupDoubleTapCopy(context, linearLayout2, block);
        AssistantAvatarDisplay resolve = AssistantAvatarDisplayConfig.INSTANCE.resolve(block.getAgentType(), block.getCliType());
        Intrinsics.checkNotNull(resources);
        int avatarIconSize = getAvatarIconSize(resources);
        int avatarResId = AssistantAvatarDisplayConfig.INSTANCE.avatarResId(resolve.getAvatarKey());
        ImageView imageView = new ImageView(context);
        imageView.setId(C0637R.id.iv_avatar_icon);
        imageView.setImageResource(avatarResId);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(avatarIconSize, avatarIconSize));
        TextView textView = new TextView(context);
        textView.setId(C0637R.id.tv_avatar_name);
        textView.setText(resolve.getDisplayName());
        applyNameStyle(textView, context);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMarginStart(getAvatarNameStartMargin(resources));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(textView, layoutParams);
        int i = (int) (16 * f);
        final ImageView imageView2 = new ImageView(context);
        if (UserPayIdentityService.getUserPayIdentity() == 100) {
            imageView2.setImageResource(C0637R.drawable.ic_input_bar_express_999);
        } else {
            imageView2.setImageResource(C0637R.drawable.ic_input_bar_use_express_pass);
        }
        imageView2.setId(C0637R.id.iv_avatar_fast);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
        layoutParams2.setMarginStart((int) (4 * f));
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(imageView2, layoutParams2);
        if (Intrinsics.areEqual(block.isExpressPass(), true) && !TocCreditsPolicy.INSTANCE.isEnabled()) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AvatarRenderer.render$lambda$6(AvatarRenderer.this, context, imageView2, view);
            }
        });
        return linearLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void render$lambda$6(AvatarRenderer avatarRenderer, Context context, ImageView imageView, View view) {
        if (TocCreditsPolicy.INSTANCE.isEnabled()) {
            return;
        }
        avatarRenderer.showFastTooltip(context, imageView);
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$showFastTooltip$attachListener$1] */
    private final void showFastTooltip(Context context, final View anchor) {
        try {
            if (!anchor.isAttachedToWindow() || anchor.getWindowToken() == null) {
                return;
            }
            try {
                PopupWindow popupWindow = this.currentPopup;
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                }
            } catch (Exception unused) {
            }
            this.currentPopup = null;
            final float f = context.getResources().getDisplayMetrics().density;
            final View inflate = LayoutInflater.from(context).inflate(C0637R.layout.trae_avatar_fast_tooltip, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(C0637R.id.tv_tooltip_text);
            if (textView != null) {
                I18nTextProvider i18nTextProvider = I18nTextProvider.INSTANCE;
                Resources resources = context.getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                textView.setText(i18nTextProvider.getString(resources, R.string.imkit_fast_pass_used, new Object[0]));
            }
            final BubbleDrawable bubbleDrawable = new BubbleDrawable(context);
            bubbleDrawable.setCornerRadius(12.0f, f);
            bubbleDrawable.setArrowSize(20.0f, 7.0f, f);
            bubbleDrawable.setShadow(10.0f, 0.0f, 4.0f, Color.argb(38, 0, 0, 0), f);
            inflate.setBackground(bubbleDrawable);
            inflate.setLayerType(1, null);
            inflate.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredWidth = inflate.getMeasuredWidth();
            int measuredHeight = inflate.getMeasuredHeight();
            final PopupWindow popupWindow2 = new PopupWindow(inflate, -2, -2, true);
            popupWindow2.setOutsideTouchable(true);
            popupWindow2.setBackgroundDrawable(new ColorDrawable(0));
            inflate.setVisibility(4);
            final int[] iArr = new int[2];
            anchor.getLocationOnScreen(iArr);
            popupWindow2.showAtLocation(anchor, 0, (iArr[0] + (anchor.getWidth() / 2)) - (measuredWidth / 2), (iArr[1] - measuredHeight) - ((int) (4 * f)));
            this.currentPopup = popupWindow2;
            inflate.post(new Runnable() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarRenderer.showFastTooltip$lambda$10(inflate, popupWindow2, iArr, anchor, bubbleDrawable, f);
                }
            });
            final Runnable runnable = new Runnable() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AvatarRenderer.showFastTooltip$lambda$11(popupWindow2);
                }
            };
            final ?? r4 = new View.OnAttachStateChangeListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$showFastTooltip$attachListener$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View v) {
                    Intrinsics.checkNotNullParameter(v, "v");
                    inflate.removeCallbacks(runnable);
                    try {
                        if (popupWindow2.isShowing()) {
                            popupWindow2.dismiss();
                        }
                    } catch (Exception unused2) {
                    }
                }
            };
            anchor.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) r4);
            popupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$$ExternalSyntheticLambda4
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    AvatarRenderer.showFastTooltip$lambda$12(inflate, runnable, anchor, r4, this, popupWindow2);
                }
            });
            inflate.postDelayed(runnable, 2000L);
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFastTooltip$lambda$10(View view, PopupWindow popupWindow, int[] iArr, View view2, BubbleDrawable bubbleDrawable, float f) {
        try {
            view.setVisibility(0);
            if (popupWindow.isShowing() && view.isAttachedToWindow()) {
                view.getLocationOnScreen(new int[2]);
                bubbleDrawable.setArrowCenterX(((iArr[0] + (view2.getWidth() / 2.0f)) - r2[0]) / f, f);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFastTooltip$lambda$11(PopupWindow popupWindow) {
        try {
            if (popupWindow.isShowing()) {
                popupWindow.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFastTooltip$lambda$12(View view, Runnable runnable, View view2, AvatarRenderer$showFastTooltip$attachListener$1 avatarRenderer$showFastTooltip$attachListener$1, AvatarRenderer avatarRenderer, PopupWindow popupWindow) {
        view.removeCallbacks(runnable);
        view2.removeOnAttachStateChangeListener(avatarRenderer$showFastTooltip$attachListener$1);
        if (avatarRenderer.currentPopup == popupWindow) {
            avatarRenderer.currentPopup = null;
        }
    }

    private final void setupDoubleTapCopy(final Context context, View container, final AgentContentBlock.Avatar block) {
        final GestureDetector gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$setupDoubleTapCopy$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                ConversationDebugLogInfo buildInfo;
                Intrinsics.checkNotNullParameter(e, "e");
                ConversationDebugInfoCopier conversationDebugInfoCopier = ConversationDebugInfoCopier.INSTANCE;
                Context context2 = context;
                ConversationDebugInfoCopier conversationDebugInfoCopier2 = ConversationDebugInfoCopier.INSTANCE;
                long createdAt = block.getCreatedAt();
                String messageId = block.getMessageId();
                String replyToMessageId = block.getReplyToMessageId();
                if (replyToMessageId == null) {
                    replyToMessageId = "";
                }
                buildInfo = conversationDebugInfoCopier2.buildInfo(createdAt, (r16 & 2) != 0 ? "" : messageId, (r16 & 4) != 0 ? "" : replyToMessageId, (r16 & 8) != 0 ? "" : block.getSessionId(), (r16 & 16) != 0 ? null : null);
                conversationDebugInfoCopier.copy(context2, ConversationDebugInfoCopier.CLIP_LABEL_AVATAR, buildInfo);
                return true;
            }
        });
        container.setClickable(true);
        container.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                z = AvatarRenderer.setupDoubleTapCopy$lambda$13(gestureDetector, view, motionEvent);
                return z;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setupDoubleTapCopy$lambda$13(GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        gestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    @Override // com.bytedance.trae.conversation.chat.block.renderer.IBlockRenderer
    public void update(View view, AgentContentBlock.Avatar block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        if (view instanceof LinearLayout) {
            try {
                AssistantAvatarDisplay resolve = AssistantAvatarDisplayConfig.INSTANCE.resolve(block.getAgentType(), block.getCliType());
                Resources resources = ((LinearLayout) view).getResources();
                ImageView imageView = (ImageView) view.findViewById(C0637R.id.iv_avatar_icon);
                if (imageView != null) {
                    imageView.setImageResource(AssistantAvatarDisplayConfig.INSTANCE.avatarResId(resolve.getAvatarKey()));
                    Intrinsics.checkNotNull(resources);
                    int avatarIconSize = getAvatarIconSize(resources);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                    if (layoutParams2 != null) {
                        layoutParams2.width = avatarIconSize;
                        layoutParams2.height = avatarIconSize;
                        imageView.setLayoutParams(layoutParams2);
                    }
                }
                TextView textView = (TextView) view.findViewById(C0637R.id.tv_avatar_name);
                if (textView != null) {
                    textView.setText(resolve.getDisplayName());
                    Context context = ((LinearLayout) view).getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    applyNameStyle(textView, context);
                    ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                    LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
                    if (layoutParams4 != null) {
                        Intrinsics.checkNotNull(resources);
                        layoutParams4.setMarginStart(getAvatarNameStartMargin(resources));
                        textView.setLayoutParams(layoutParams4);
                    }
                }
                View findViewById = view.findViewById(C0637R.id.iv_avatar_fast);
                if (findViewById != null) {
                    if (Intrinsics.areEqual(block.isExpressPass(), true) && !TocCreditsPolicy.INSTANCE.isEnabled()) {
                        findViewById.setVisibility(0);
                    } else {
                        findViewById.setVisibility(8);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    private final int getAvatarIconSize(Resources resources) {
        return resources.getDimensionPixelSize(C0637R.dimen.trae_dp_18);
    }

    private final int getAvatarNameStartMargin(Resources resources) {
        return resources.getDimensionPixelSize(C0637R.dimen.trae_dp_4);
    }

    private final void applyNameStyle(TextView textView, Context context) {
        Resources resources = context.getResources();
        textView.setTextColor(context.getColor(C0591R.color.trae_text_text_default));
        textView.setTextSize(0, resources.getDimension(C0591R.dimen.trae_body_body_base_font_size_sp));
        TextViewCompat.setLineHeight(textView, resources.getDimensionPixelSize(C0591R.dimen.trae_body_body_base_line_height_dp));
        textView.setLetterSpacing(-0.025294118f);
        textView.setTypeface(Typeface.create("sans-serif", 0));
        textView.setIncludeFontPadding(false);
    }
}
