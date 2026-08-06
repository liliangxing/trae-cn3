package com.bytedance.trae.conversation.chat.block.renderer.ref;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: TraeRefChipSpan.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001(B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J4\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JR\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;", "Landroid/text/style/ReplacementSpan;", "group", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "spanStyle", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;", "<init>", "(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V", "getGroup", "()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;", "pressed", "", "getPressed", "()Z", "setPressed", "(Z)V", "bgPaint", "Landroid/graphics/Paint;", "textPaint", "displayText", "", "cachedWidth", "", "getSize", "paint", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", "top", "y", "bottom", "Style", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRefChipSpan extends ReplacementSpan {
    private final Paint bgPaint;
    private int cachedWidth;
    private final String displayText;
    private final TraeRefGroup group;
    private boolean pressed;
    private final Style spanStyle;
    private final Paint textPaint;

    public final TraeRefGroup getGroup() {
        return this.group;
    }

    public /* synthetic */ TraeRefChipSpan(TraeRefGroup traeRefGroup, Style style, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(traeRefGroup, (i & 2) != 0 ? new Style(0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 511, null) : style);
    }

    public TraeRefChipSpan(TraeRefGroup traeRefGroup, Style style) {
        Intrinsics.checkNotNullParameter(traeRefGroup, "group");
        Intrinsics.checkNotNullParameter(style, "spanStyle");
        this.group = traeRefGroup;
        this.spanStyle = style;
        this.bgPaint = new Paint(1);
        Paint paint = new Paint(1);
        paint.setColor(style.getTextColor());
        paint.setTextSize(style.getTextSizePx());
        paint.setTypeface(Typeface.DEFAULT);
        this.textPaint = paint;
        this.displayText = traeRefGroup.getDisplayText();
        this.cachedWidth = -1;
    }

    /* compiled from: TraeRefChipSpan.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00012Ba\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003J\t\u0010*\u001a\u00020\u0007HÆ\u0003Jc\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u00020\u0003HÖ\u0001J\t\u00100\u001a\u000201HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b!\u0010\u0014¨\u00063"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;", "", "bgColor", "", "bgColorPressed", "textColor", "textSizePx", "", "horizontalPaddingDp", "verticalPaddingDp", "cornerRadiusDp", "marginDp", "density", "<init>", "(IIIFFFFFF)V", "getBgColor", "()I", "getBgColorPressed", "getTextColor", "getTextSizePx", "()F", "getHorizontalPaddingDp", "getVerticalPaddingDp", "getCornerRadiusDp", "getMarginDp", "getDensity", "horizontalPaddingPx", "getHorizontalPaddingPx", "verticalPaddingPx", "getVerticalPaddingPx", "cornerRadiusPx", "getCornerRadiusPx", "marginPx", "getMarginPx", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Style {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int bgColor;
        private final int bgColorPressed;
        private final float cornerRadiusDp;
        private final float density;
        private final float horizontalPaddingDp;
        private final float marginDp;
        private final int textColor;
        private final float textSizePx;
        private final float verticalPaddingDp;

        public Style() {
            this(0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 511, null);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBgColor() {
            return this.bgColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getBgColorPressed() {
            return this.bgColorPressed;
        }

        /* renamed from: component3, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        /* renamed from: component4, reason: from getter */
        public final float getTextSizePx() {
            return this.textSizePx;
        }

        /* renamed from: component5, reason: from getter */
        public final float getHorizontalPaddingDp() {
            return this.horizontalPaddingDp;
        }

        /* renamed from: component6, reason: from getter */
        public final float getVerticalPaddingDp() {
            return this.verticalPaddingDp;
        }

        /* renamed from: component7, reason: from getter */
        public final float getCornerRadiusDp() {
            return this.cornerRadiusDp;
        }

        /* renamed from: component8, reason: from getter */
        public final float getMarginDp() {
            return this.marginDp;
        }

        /* renamed from: component9, reason: from getter */
        public final float getDensity() {
            return this.density;
        }

        public final Style copy(int bgColor, int bgColorPressed, int textColor, float textSizePx, float horizontalPaddingDp, float verticalPaddingDp, float cornerRadiusDp, float marginDp, float density) {
            return new Style(bgColor, bgColorPressed, textColor, textSizePx, horizontalPaddingDp, verticalPaddingDp, cornerRadiusDp, marginDp, density);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Style)) {
                return false;
            }
            Style style = (Style) other;
            return this.bgColor == style.bgColor && this.bgColorPressed == style.bgColorPressed && this.textColor == style.textColor && Float.compare(this.textSizePx, style.textSizePx) == 0 && Float.compare(this.horizontalPaddingDp, style.horizontalPaddingDp) == 0 && Float.compare(this.verticalPaddingDp, style.verticalPaddingDp) == 0 && Float.compare(this.cornerRadiusDp, style.cornerRadiusDp) == 0 && Float.compare(this.marginDp, style.marginDp) == 0 && Float.compare(this.density, style.density) == 0;
        }

        public int hashCode() {
            return (((((((((((((((Integer.hashCode(this.bgColor) * 31) + Integer.hashCode(this.bgColorPressed)) * 31) + Integer.hashCode(this.textColor)) * 31) + Float.hashCode(this.textSizePx)) * 31) + Float.hashCode(this.horizontalPaddingDp)) * 31) + Float.hashCode(this.verticalPaddingDp)) * 31) + Float.hashCode(this.cornerRadiusDp)) * 31) + Float.hashCode(this.marginDp)) * 31) + Float.hashCode(this.density);
        }

        public String toString() {
            return "Style(bgColor=" + this.bgColor + ", bgColorPressed=" + this.bgColorPressed + ", textColor=" + this.textColor + ", textSizePx=" + this.textSizePx + ", horizontalPaddingDp=" + this.horizontalPaddingDp + ", verticalPaddingDp=" + this.verticalPaddingDp + ", cornerRadiusDp=" + this.cornerRadiusDp + ", marginDp=" + this.marginDp + ", density=" + this.density + ')';
        }

        public Style(int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6) {
            this.bgColor = i;
            this.bgColorPressed = i2;
            this.textColor = i3;
            this.textSizePx = f;
            this.horizontalPaddingDp = f2;
            this.verticalPaddingDp = f3;
            this.cornerRadiusDp = f4;
            this.marginDp = f5;
            this.density = f6;
        }

        public /* synthetic */ Style(int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 343110515 : i, (i4 & 2) != 0 ? 510882675 : i2, (i4 & 4) != 0 ? -9211021 : i3, (i4 & 8) != 0 ? 13.0f : f, (i4 & 16) != 0 ? 8.0f : f2, (i4 & 32) != 0 ? 2.0f : f3, (i4 & 64) != 0 ? 30.0f : f4, (i4 & 128) == 0 ? f5 : 2.0f, (i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 1.0f : f6);
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final int getBgColorPressed() {
            return this.bgColorPressed;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final float getTextSizePx() {
            return this.textSizePx;
        }

        public final float getHorizontalPaddingDp() {
            return this.horizontalPaddingDp;
        }

        public final float getVerticalPaddingDp() {
            return this.verticalPaddingDp;
        }

        public final float getCornerRadiusDp() {
            return this.cornerRadiusDp;
        }

        public final float getMarginDp() {
            return this.marginDp;
        }

        public final float getDensity() {
            return this.density;
        }

        public final float getHorizontalPaddingPx() {
            return this.horizontalPaddingDp * this.density;
        }

        public final float getVerticalPaddingPx() {
            return this.verticalPaddingDp * this.density;
        }

        public final float getCornerRadiusPx() {
            return this.cornerRadiusDp * this.density;
        }

        public final float getMarginPx() {
            return this.marginDp * this.density;
        }

        /* compiled from: TraeRefChipSpan.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;", "", "<init>", "()V", "from", "Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;", "context", "Landroid/content/Context;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final Style from(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                float f = context.getResources().getDisplayMetrics().density;
                float dimension = context.getResources().getDimension(C0591R.dimen.trae_footnote_footnote_font_size_sp);
                return new Style(ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l1), ContextCompat.getColor(context, C0591R.color.trae_bg_bg_overlay_l2), ContextCompat.getColor(context, C0591R.color.trae_text_text_tertiary), dimension, 0.0f, 0.0f, 0.0f, 0.0f, f, 240, null);
            }
        }
    }

    public final boolean getPressed() {
        return this.pressed;
    }

    public final void setPressed(boolean z) {
        this.pressed = z;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float f = 2;
        this.cachedWidth = MathKt.roundToInt(this.textPaint.measureText(this.displayText) + (this.spanStyle.getHorizontalPaddingPx() * f) + (this.spanStyle.getMarginPx() * f));
        if (fm != null) {
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            fm.ascent = fontMetricsInt.ascent;
            fm.descent = fontMetricsInt.descent;
            fm.top = fontMetricsInt.top;
            fm.bottom = fontMetricsInt.bottom;
        }
        return this.cachedWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        float marginPx = this.spanStyle.getMarginPx() + x;
        float marginPx2 = x + (this.cachedWidth - this.spanStyle.getMarginPx());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f = 2;
        float verticalPaddingPx = (fontMetrics.descent - fontMetrics.ascent) + (this.spanStyle.getVerticalPaddingPx() * f);
        float verticalPaddingPx2 = (y + fontMetrics.ascent) - this.spanStyle.getVerticalPaddingPx();
        RectF rectF = new RectF(marginPx, verticalPaddingPx2, marginPx2, verticalPaddingPx2 + verticalPaddingPx);
        this.bgPaint.setColor(this.pressed ? this.spanStyle.getBgColorPressed() : this.spanStyle.getBgColor());
        canvas.drawRoundRect(rectF, this.spanStyle.getCornerRadiusPx(), this.spanStyle.getCornerRadiusPx(), this.bgPaint);
        canvas.drawText(this.displayText, marginPx + this.spanStyle.getHorizontalPaddingPx(), (verticalPaddingPx2 + ((verticalPaddingPx - (this.textPaint.descent() - this.textPaint.ascent())) / f)) - this.textPaint.ascent(), this.textPaint);
    }
}
