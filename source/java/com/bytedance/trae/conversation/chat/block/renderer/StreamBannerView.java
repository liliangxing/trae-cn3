package com.bytedance.trae.conversation.chat.block.renderer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StreamBannerView.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0014\u001a\u00020\u0015J/\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00132\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "iconView", "Landroid/widget/ImageView;", "titleView", "Landroid/widget/TextView;", "messageView", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "configure", "", "title", "", "message", "style", "Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;", "iconRes", "", "configureInlineAlert", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;Ljava/lang/Integer;)V", "inlineAlertBackgroundColor", "inlineAlertBorderColor", "updateMessage", "updateTitle", "Style", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StreamBannerView extends LinearLayout {
    private final GradientDrawable backgroundDrawable;
    private final ImageView iconView;
    private final TextView messageView;
    private final TextView titleView;

    /* compiled from: StreamBannerView.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Style.values().length];
            try {
                iArr[Style.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StreamBannerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(1);
        float f = getResources().getDisplayMetrics().density;
        int i = (int) (16 * f);
        float f2 = 12 * f;
        int i2 = (int) f2;
        setPadding(i, i2, i, i2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setStroke((int) (1 * f), 0);
        this.backgroundDrawable = gradientDrawable;
        setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.iconView = imageView;
        int i3 = (int) (20 * f);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i3, i3));
        TextView textView = new TextView(context);
        textView.setTextSize(2, 14.0f);
        textView.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        textView.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_default));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        int i4 = (int) (4 * f);
        layoutParams.setMarginStart(i4);
        textView.setLayoutParams(layoutParams);
        this.titleView = textView;
        linearLayout.addView(textView);
        addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(context);
        textView2.setTextSize(2, 13.0f);
        textView2.setTextColor(ContextCompat.getColor(context, C0591R.color.trae_text_text_secondary));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.topMargin = i4;
        textView2.setLayoutParams(layoutParams2);
        this.messageView = textView2;
        addView(textView2);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: StreamBannerView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;", "", "bgColorRes", "", "borderColorRes", "tintColorRes", "iconRes", "<init>", "(Ljava/lang/String;IIIII)V", "getBgColorRes", "()I", "getBorderColorRes", "getTintColorRes", "getIconRes", "ERROR", "TIPS", "WARNING", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Style {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Style[] $VALUES;
        public static final Style ERROR = new Style("ERROR", 0, C0591R.color.trae_status_error_surface_l1, C0591R.color.trae_status_error_surface_l2, C0591R.color.trae_status_error_default, 0);
        public static final Style TIPS = new Style("TIPS", 1, C0591R.color.trae_status_info_surface_l1, C0591R.color.trae_status_primary_surface_l2, C0591R.color.trae_status_info_default, 0);
        public static final Style WARNING = new Style("WARNING", 2, C0591R.color.trae_status_warning_surface_l1, C0591R.color.trae_status_warning_surface_l2, C0591R.color.trae_status_warning_default, 0);
        private final int bgColorRes;
        private final int borderColorRes;
        private final int iconRes;
        private final int tintColorRes;

        private static final /* synthetic */ Style[] $values() {
            return new Style[]{ERROR, TIPS, WARNING};
        }

        public static EnumEntries<Style> getEntries() {
            return $ENTRIES;
        }

        private Style(String str, int i, int i2, int i3, int i4, int i5) {
            this.bgColorRes = i2;
            this.borderColorRes = i3;
            this.tintColorRes = i4;
            this.iconRes = i5;
        }

        public final int getBgColorRes() {
            return this.bgColorRes;
        }

        public final int getBorderColorRes() {
            return this.borderColorRes;
        }

        public final int getTintColorRes() {
            return this.tintColorRes;
        }

        public final int getIconRes() {
            return this.iconRes;
        }

        static {
            Style[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }
    }

    public final void configure(String title, String message, Style style, int iconRes) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(style, "style");
        float f = getResources().getDisplayMetrics().density;
        this.backgroundDrawable.setColor(ContextCompat.getColor(getContext(), style.getBgColorRes()));
        this.backgroundDrawable.setStroke((int) (1 * f), ContextCompat.getColor(getContext(), style.getBorderColorRes()));
        this.iconView.setImageResource(iconRes);
        this.iconView.setColorFilter(ContextCompat.getColor(getContext(), style.getTintColorRes()));
        this.titleView.setText(title);
        String str = message;
        if (str.length() == 0) {
            this.messageView.setVisibility(8);
        } else {
            this.messageView.setVisibility(0);
            this.messageView.setText(str);
        }
    }

    public static /* synthetic */ void configureInlineAlert$default(StreamBannerView streamBannerView, String str, String str2, Style style, Integer num, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
        }
        streamBannerView.configureInlineAlert(str, str2, style, num);
    }

    public final void configureInlineAlert(String title, String message, Style style, Integer iconRes) {
        LinearLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(style, "style");
        float f = getResources().getDisplayMetrics().density;
        this.backgroundDrawable.setCornerRadius(20 * f);
        this.backgroundDrawable.setColor(inlineAlertBackgroundColor(style));
        this.backgroundDrawable.setStroke(Math.max(1, (int) (1 * f)), inlineAlertBorderColor(style));
        if (iconRes != null) {
            this.iconView.setVisibility(0);
            this.iconView.setImageResource(iconRes.intValue());
            this.iconView.setColorFilter(ContextCompat.getColor(getContext(), style.getTintColorRes()));
            ViewGroup.LayoutParams layoutParams2 = this.titleView.getLayoutParams();
            layoutParams = layoutParams2 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams2 : null;
            if (layoutParams != null) {
                layoutParams.setMarginStart(getResources().getDimensionPixelSize(C0637R.dimen.trae_dp_4));
            }
        } else {
            this.iconView.setVisibility(8);
            ViewGroup.LayoutParams layoutParams3 = this.titleView.getLayoutParams();
            layoutParams = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
            if (layoutParams != null) {
                layoutParams.setMarginStart(0);
            }
        }
        TextView textView = this.titleView;
        textView.setText(title);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setTextColor(Color.parseColor("#0A0A0A"));
        textView.setIncludeFontPadding(true);
        TextViewCompat.setLineHeight(textView, (int) (22 * f));
        TextView textView2 = this.messageView;
        textView2.setTextSize(2, 13.0f);
        textView2.setTextColor(Color.parseColor("#404040"));
        textView2.setIncludeFontPadding(true);
        TextViewCompat.setLineHeight(textView2, (int) (17 * f));
        String str = message;
        if (str.length() == 0) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
    }

    private final int inlineAlertBackgroundColor(Style style) {
        if (WhenMappings.$EnumSwitchMapping$0[style.ordinal()] == 1) {
            return Color.parseColor("#1FE8463A");
        }
        return ContextCompat.getColor(getContext(), style.getBgColorRes());
    }

    private final int inlineAlertBorderColor(Style style) {
        if (WhenMappings.$EnumSwitchMapping$0[style.ordinal()] == 1) {
            return Color.parseColor("#29E8463A");
        }
        return ContextCompat.getColor(getContext(), style.getBorderColorRes());
    }

    public final void updateMessage(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        String str = message;
        if (str.length() == 0) {
            this.messageView.setVisibility(8);
        } else {
            this.messageView.setVisibility(0);
            this.messageView.setText(str);
        }
    }

    public final void updateTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.titleView.setText(title);
    }
}
