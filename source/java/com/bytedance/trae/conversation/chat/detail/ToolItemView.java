package com.bytedance.trae.conversation.chat.detail;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard;
import com.bytedance.trae.conversation.widget.ShimmerTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ToolItemView.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconImageView", "Landroid/widget/ImageView;", "iconEmojiView", "Landroid/widget/TextView;", "titleView", "Lcom/bytedance/trae/conversation/widget/ShimmerTextView;", "subtitleView", "badgeView", "chevronView", "headerRow", "verticalLine", "Landroid/view/View;", "contentContainer", "Landroid/widget/FrameLayout;", "density", "", "iconColumnWidth", "", "bind", "", "card", "Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;", "update", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ToolItemView extends LinearLayout {
    private final TextView badgeView;
    private final ImageView chevronView;
    private final FrameLayout contentContainer;
    private final float density;
    private final LinearLayout headerRow;
    private final int iconColumnWidth;
    private final TextView iconEmojiView;
    private final ImageView iconImageView;
    private final TextView subtitleView;
    private final ShimmerTextView titleView;
    private final View verticalLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ToolItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        float f2 = 16;
        int i = (int) (f2 * f);
        this.iconColumnWidth = i;
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        float f3 = 4;
        layoutParams.bottomMargin = (int) (f3 * f);
        setLayoutParams(layoutParams);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        linearLayout.setMinimumHeight((int) (24 * f));
        this.headerRow = linearLayout;
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(context);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(i, (int) (20 * f)));
        int i2 = (int) (f2 * f);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary)));
        imageView.setVisibility(8);
        this.iconImageView = imageView;
        frameLayout.addView(imageView, new FrameLayout.LayoutParams(i2, i2, 17));
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setGravity(17);
        textView.setVisibility(8);
        this.iconEmojiView = textView;
        frameLayout.addView(textView, new FrameLayout.LayoutParams(i2, i2, 17));
        ShimmerTextView shimmerTextView = new ShimmerTextView(context, null, 0, 6, null);
        shimmerTextView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        shimmerTextView.setTextSize(2, 16.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            shimmerTextView.setLineHeight((int) (22 * f));
        }
        shimmerTextView.setLetterSpacing(-0.019f);
        shimmerTextView.setMaxLines(1);
        shimmerTextView.setEllipsize(TextUtils.TruncateAt.END);
        this.titleView = shimmerTextView;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        float f4 = 8;
        layoutParams2.setMarginStart((int) (f4 * f));
        Unit unit = Unit.INSTANCE;
        linearLayout.addView((View) shimmerTextView, layoutParams2);
        TextView textView2 = new TextView(context);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary));
        textView2.setTextSize(2, 16.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView2.setLineHeight((int) (22 * f));
        }
        textView2.setLetterSpacing(-0.019f);
        textView2.setMaxLines(1);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setVisibility(8);
        this.subtitleView = textView2;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        float f5 = 6;
        layoutParams3.setMarginStart((int) (f5 * f));
        Unit unit2 = Unit.INSTANCE;
        linearLayout.addView(textView2, layoutParams3);
        TextView textView3 = new TextView(context);
        textView3.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_status_warning_default));
        textView3.setTextSize(2, 13.0f);
        if (Build.VERSION.SDK_INT >= 28) {
            textView3.setLineHeight((int) (17 * f));
        }
        textView3.setLetterSpacing(-0.006f);
        textView3.setMaxLines(1);
        int i3 = (int) (f3 * f);
        float f6 = 1;
        int i4 = (int) (f6 * f);
        textView3.setPadding(i3, i4, i3, i4);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ContextCompat.getColor(context, C0591R.color.trae_status_warning_surface_l1));
        gradientDrawable.setCornerRadius(50 * f);
        textView3.setBackground(gradientDrawable);
        textView3.setVisibility(8);
        this.badgeView = textView3;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.setMarginStart((int) (f5 * f));
        Unit unit3 = Unit.INSTANCE;
        linearLayout.addView(textView3, layoutParams4);
        int i5 = (int) (f2 * f);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageResource(C0637R.drawable.ic_tool_chevron_right);
        imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView2.setImageTintList(ColorStateList.valueOf(ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary)));
        imageView2.setVisibility(8);
        this.chevronView = imageView2;
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i5, i5);
        layoutParams5.setMarginStart((int) (f3 * f));
        Unit unit4 = Unit.INSTANCE;
        linearLayout.addView(imageView2, layoutParams5);
        LinearLayout linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(0);
        addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout2 = new FrameLayout(context);
        linearLayout2.addView(frameLayout2, new LinearLayout.LayoutParams(i, -1));
        View view = new View(context);
        view.setBackgroundColor(ContextCompat.getColor(context, C0591R.color.trae_border_border_neutral_l2));
        this.verticalLine = view;
        frameLayout2.addView(view, new FrameLayout.LayoutParams((int) (f6 * f), -1, 1));
        FrameLayout frameLayout3 = new FrameLayout(context);
        frameLayout3.setPadding(0, (int) (f3 * f), 0, (int) (f4 * f));
        this.contentContainer = frameLayout3;
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams6.setMarginStart((int) (f4 * f));
        Unit unit5 = Unit.INSTANCE;
        linearLayout2.addView(frameLayout3, layoutParams6);
    }

    public final void bind(ToolDetailCard card) {
        ColorStateList valueOf;
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.getIconResId() != 0) {
            this.iconImageView.setImageResource(card.getIconResId());
            ImageView imageView = this.iconImageView;
            if (card.getIconTintColorRes() != 0) {
                valueOf = ColorStateList.valueOf(ContextCompat.getColor(getContext(), card.getIconTintColorRes()));
            } else {
                valueOf = ColorStateList.valueOf(ContextCompat.getColor(getContext(), C0591R.color.trae_text_text_secondary));
            }
            imageView.setImageTintList(valueOf);
            this.iconImageView.setVisibility(0);
            this.iconEmojiView.setVisibility(8);
        } else {
            this.iconEmojiView.setText(card.getIconEmoji());
            this.iconEmojiView.setVisibility(0);
            this.iconImageView.setVisibility(8);
        }
        this.titleView.setText(card.getTitle());
        this.titleView.setShimmerEnabled(card.getShimmerTitle());
        String subtitle = card.getSubtitle();
        if (subtitle == null || subtitle.length() == 0) {
            this.subtitleView.setVisibility(8);
        } else {
            this.subtitleView.setText(card.getSubtitle());
            this.subtitleView.setVisibility(0);
        }
        String badgeText = card.getBadgeText();
        if (badgeText == null || badgeText.length() == 0) {
            this.badgeView.setVisibility(8);
        } else {
            this.badgeView.setText(card.getBadgeText());
            this.badgeView.setVisibility(0);
        }
        this.contentContainer.removeAllViews();
        Function1<Context, View> contentView = card.getContentView();
        if (contentView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            View view = (View) contentView.invoke(context);
            if (view != null) {
                this.contentContainer.addView(view);
            }
        }
        boolean z = this.contentContainer.getChildCount() > 0;
        this.verticalLine.setVisibility(z ? 0 : 8);
        this.contentContainer.setVisibility(z ? 0 : 8);
        if (card.getOnDetailClick() != null) {
            this.chevronView.setVisibility(0);
            LinearLayout linearLayout = this.headerRow;
            final Function1<View, Unit> onDetailClick = card.getOnDetailClick();
            linearLayout.setOnClickListener(onDetailClick != null ? new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.ToolItemView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onDetailClick.invoke(view2);
                }
            } : null);
            return;
        }
        this.chevronView.setVisibility(8);
        this.headerRow.setOnClickListener(null);
        this.headerRow.setClickable(false);
    }

    public final void update(ToolDetailCard card) {
        ColorStateList valueOf;
        Intrinsics.checkNotNullParameter(card, "card");
        if (card.getIconResId() != 0) {
            this.iconImageView.setImageResource(card.getIconResId());
            ImageView imageView = this.iconImageView;
            if (card.getIconTintColorRes() != 0) {
                valueOf = ColorStateList.valueOf(ContextCompat.getColor(getContext(), card.getIconTintColorRes()));
            } else {
                valueOf = ColorStateList.valueOf(ContextCompat.getColor(getContext(), C0591R.color.trae_text_text_secondary));
            }
            imageView.setImageTintList(valueOf);
            this.iconImageView.setVisibility(0);
            this.iconEmojiView.setVisibility(8);
        } else {
            this.iconEmojiView.setText(card.getIconEmoji());
            this.iconEmojiView.setVisibility(0);
            this.iconImageView.setVisibility(8);
        }
        this.titleView.setText(card.getTitle());
        this.titleView.setShimmerEnabled(card.getShimmerTitle());
        String subtitle = card.getSubtitle();
        if (subtitle == null || subtitle.length() == 0) {
            this.subtitleView.setVisibility(8);
        } else {
            this.subtitleView.setText(card.getSubtitle());
            this.subtitleView.setVisibility(0);
        }
        String badgeText = card.getBadgeText();
        if (badgeText == null || badgeText.length() == 0) {
            this.badgeView.setVisibility(8);
        } else {
            this.badgeView.setText(card.getBadgeText());
            this.badgeView.setVisibility(0);
        }
        this.contentContainer.removeAllViews();
        Function1<Context, View> contentView = card.getContentView();
        if (contentView != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            View view = (View) contentView.invoke(context);
            if (view != null) {
                this.contentContainer.addView(view);
            }
        }
        boolean z = this.contentContainer.getChildCount() > 0;
        this.verticalLine.setVisibility(z ? 0 : 8);
        this.contentContainer.setVisibility(z ? 0 : 8);
        if (card.getOnDetailClick() != null) {
            this.chevronView.setVisibility(0);
            LinearLayout linearLayout = this.headerRow;
            final Function1<View, Unit> onDetailClick = card.getOnDetailClick();
            linearLayout.setOnClickListener(onDetailClick != null ? new View.OnClickListener() { // from class: com.bytedance.trae.conversation.chat.detail.ToolItemView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    onDetailClick.invoke(view2);
                }
            } : null);
            return;
        }
        this.chevronView.setVisibility(8);
        this.headerRow.setOnClickListener(null);
        this.headerRow.setClickable(false);
    }
}
