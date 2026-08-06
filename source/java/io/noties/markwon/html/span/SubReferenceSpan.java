package io.noties.markwon.html.span;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.bytedance.webx.core.webview.WebViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: SubReferenceSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJP\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J2\u0010\"\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006&"}, d2 = {"Lio/noties/markwon/html/span/SubReferenceSpan;", "Landroid/text/style/ReplacementSpan;", "content", "", "title", "href", SettingsTracker.TYPE_THEME, "Lio/noties/markwon/html/span/SubReferenceSpan$Theme;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lio/noties/markwon/html/span/SubReferenceSpan$Theme;)V", "bounds", "Landroid/graphics/RectF;", "getContent", "()Ljava/lang/String;", "getHref", "lengthWithoutMargin", "", AirActionConstant.ActionId.ACTION_ID_PARAMS, "Landroid/text/TextPaint;", "getTitle", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "Theme", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes6.dex */
public final class SubReferenceSpan extends ReplacementSpan {
    private final RectF bounds;
    private final String content;
    private final String href;
    private float lengthWithoutMargin;
    private final TextPaint p;
    private final Theme theme;
    private final String title;

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getHref() {
        return this.href;
    }

    public SubReferenceSpan(String content, String title, String href, Theme theme) {
        Intrinsics.checkParameterIsNotNull(content, "content");
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(href, "href");
        Intrinsics.checkParameterIsNotNull(theme, "theme");
        this.content = content;
        this.title = title;
        this.href = href;
        this.theme = theme;
        this.bounds = new RectF();
        this.p = new TextPaint();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Intrinsics.checkParameterIsNotNull(text, "text");
        if (paint instanceof TextPaint) {
            this.p.set((TextPaint) paint);
        } else {
            this.p.set(paint);
        }
        if (this.theme.getTextSize() > 0.0f) {
            this.p.setTextSize(this.theme.getTextSize());
        }
        float f = 2;
        float measureText = this.p.measureText(this.content) + (this.theme.getPaddingHorizontal() * f);
        this.lengthWithoutMargin = measureText;
        return MathKt.roundToInt(measureText + (f * this.theme.getMarginHorizontal()));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(text, "text");
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Paint.FontMetrics fontMetrics = this.p.getFontMetrics();
        float marginHorizontal = x + this.theme.getMarginHorizontal();
        float marginVertical = top + this.theme.getMarginVertical();
        this.bounds.set(marginHorizontal, marginVertical, this.lengthWithoutMargin + marginHorizontal, (fontMetrics.descent - fontMetrics.ascent) + marginVertical + (this.theme.getPaddingVertical() * 2));
        if (this.theme.getBgColor() > 0) {
            this.p.setColor(this.theme.getBgColor());
            if (this.theme.getBgRadius() > 0.0f) {
                canvas.drawRoundRect(this.bounds, this.theme.getBgRadius(), this.theme.getBgRadius(), this.p);
            } else {
                canvas.drawRect(this.bounds, this.p);
            }
        }
        this.p.setColor(this.theme.getTextColor());
        canvas.drawText(this.content, this.bounds.left + this.theme.getPaddingHorizontal(), (this.bounds.top + this.theme.getPaddingVertical()) - fontMetrics.ascent, this.p);
    }

    /* compiled from: SubReferenceSpan.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006\u0012\b\b\u0003\u0010\t\u001a\u00020\u0006\u0012\b\b\u0003\u0010\n\u001a\u00020\u0006\u0012\b\b\u0003\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u00062\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006&"}, d2 = {"Lio/noties/markwon/html/span/SubReferenceSpan$Theme;", "", "bgColor", "", "textColor", "textSize", "", "bgRadius", "paddingVertical", "paddingHorizontal", "marginVertical", "marginHorizontal", "(IIFFFFFF)V", "getBgColor", "()I", "getBgRadius", "()F", "getMarginHorizontal", "getMarginVertical", "getPaddingHorizontal", "getPaddingVertical", "getTextColor", "getTextSize", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "markwon-html_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes6.dex */
    public static final /* data */ class Theme {
        private final int bgColor;
        private final float bgRadius;
        private final float marginHorizontal;
        private final float marginVertical;
        private final float paddingHorizontal;
        private final float paddingVertical;
        private final int textColor;
        private final float textSize;

        public Theme() {
            this(0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255, null);
        }

        /* renamed from: component1, reason: from getter */
        public final int getBgColor() {
            return this.bgColor;
        }

        /* renamed from: component2, reason: from getter */
        public final int getTextColor() {
            return this.textColor;
        }

        /* renamed from: component3, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        /* renamed from: component4, reason: from getter */
        public final float getBgRadius() {
            return this.bgRadius;
        }

        /* renamed from: component5, reason: from getter */
        public final float getPaddingVertical() {
            return this.paddingVertical;
        }

        /* renamed from: component6, reason: from getter */
        public final float getPaddingHorizontal() {
            return this.paddingHorizontal;
        }

        /* renamed from: component7, reason: from getter */
        public final float getMarginVertical() {
            return this.marginVertical;
        }

        /* renamed from: component8, reason: from getter */
        public final float getMarginHorizontal() {
            return this.marginHorizontal;
        }

        public final Theme copy(int bgColor, int textColor, float textSize, float bgRadius, float paddingVertical, float paddingHorizontal, float marginVertical, float marginHorizontal) {
            return new Theme(bgColor, textColor, textSize, bgRadius, paddingVertical, paddingHorizontal, marginVertical, marginHorizontal);
        }

        public boolean equals(Object other) {
            if (this != other) {
                if (other instanceof Theme) {
                    Theme theme = (Theme) other;
                    if (this.bgColor == theme.bgColor) {
                        if (!(this.textColor == theme.textColor) || Float.compare(this.textSize, theme.textSize) != 0 || Float.compare(this.bgRadius, theme.bgRadius) != 0 || Float.compare(this.paddingVertical, theme.paddingVertical) != 0 || Float.compare(this.paddingHorizontal, theme.paddingHorizontal) != 0 || Float.compare(this.marginVertical, theme.marginVertical) != 0 || Float.compare(this.marginHorizontal, theme.marginHorizontal) != 0) {
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((((((((((this.bgColor * 31) + this.textColor) * 31) + Float.floatToIntBits(this.textSize)) * 31) + Float.floatToIntBits(this.bgRadius)) * 31) + Float.floatToIntBits(this.paddingVertical)) * 31) + Float.floatToIntBits(this.paddingHorizontal)) * 31) + Float.floatToIntBits(this.marginVertical)) * 31) + Float.floatToIntBits(this.marginHorizontal);
        }

        public String toString() {
            return "Theme(bgColor=" + this.bgColor + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", bgRadius=" + this.bgRadius + ", paddingVertical=" + this.paddingVertical + ", paddingHorizontal=" + this.paddingHorizontal + ", marginVertical=" + this.marginVertical + ", marginHorizontal=" + this.marginHorizontal + ")";
        }

        public Theme(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6) {
            this.bgColor = i;
            this.textColor = i2;
            this.textSize = f;
            this.bgRadius = f2;
            this.paddingVertical = f3;
            this.paddingHorizontal = f4;
            this.marginVertical = f5;
            this.marginHorizontal = f6;
        }

        public final int getBgColor() {
            return this.bgColor;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        public final float getBgRadius() {
            return this.bgRadius;
        }

        public final float getPaddingVertical() {
            return this.paddingVertical;
        }

        public final float getPaddingHorizontal() {
            return this.paddingHorizontal;
        }

        public final float getMarginVertical() {
            return this.marginVertical;
        }

        public /* synthetic */ Theme(int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? -16777216 : i2, (i3 & 4) != 0 ? -1.0f : f, (i3 & 8) != 0 ? 0.0f : f2, (i3 & 16) != 0 ? 0.0f : f3, (i3 & 32) != 0 ? 0.0f : f4, (i3 & 64) != 0 ? 0.0f : f5, (i3 & 128) == 0 ? f6 : 0.0f);
        }

        public final float getMarginHorizontal() {
            return this.marginHorizontal;
        }
    }
}
