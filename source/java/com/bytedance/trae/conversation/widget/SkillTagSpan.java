package com.bytedance.trae.conversation.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ReplacementSpan;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.common_ui.C0591R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SkillTagSpan.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J4\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016JR\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/trae/conversation/widget/SkillTagSpan;", "Landroid/text/style/ReplacementSpan;", "Lcom/bytedance/trae/conversation/widget/InputTagSpan;", "context", "Landroid/content/Context;", "skillName", "", "iconRes", "", "skillItem", "Lcom/bytedance/trae/conversation/widget/SkillItem;", "tagTextSize", "", "tagPaddingH", "tagPaddingV", "iconSize", "iconMarginEnd", "tagBgColor", "tagTextColor", "cornerRadius", "<init>", "(Landroid/content/Context;Ljava/lang/String;ILcom/bytedance/trae/conversation/widget/SkillItem;FFFFFIIF)V", "getSkillItem", "()Lcom/bytedance/trae/conversation/widget/SkillItem;", "textPaint", "Landroid/graphics/Paint;", "bgPaint", "spanWidth", "getSize", "paint", "text", "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "top", "y", "bottom", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SkillTagSpan extends ReplacementSpan implements InputTagSpan {
    private final Paint bgPaint;
    private final Context context;
    private final float cornerRadius;
    private final float iconMarginEnd;
    private final int iconRes;
    private final float iconSize;
    private final SkillItem skillItem;
    private final String skillName;
    private int spanWidth;
    private final int tagBgColor;
    private final float tagPaddingH;
    private final float tagPaddingV;
    private final int tagTextColor;
    private final float tagTextSize;
    private final Paint textPaint;

    public final SkillItem getSkillItem() {
        return this.skillItem;
    }

    public /* synthetic */ SkillTagSpan(Context context, String str, int i, SkillItem skillItem, float f, float f2, float f3, float f4, float f5, int i2, int i3, float f6, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, i, (i4 & 8) != 0 ? null : skillItem, (i4 & 16) != 0 ? SkillTagSpanKt.m867dp(14.0f, context) : f, (i4 & 32) != 0 ? SkillTagSpanKt.m867dp(10.0f, context) : f2, (i4 & 64) != 0 ? SkillTagSpanKt.m867dp(4.0f, context) : f3, (i4 & 128) != 0 ? SkillTagSpanKt.m867dp(16.0f, context) : f4, (i4 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? SkillTagSpanKt.m867dp(4.0f, context) : f5, (i4 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? ContextCompat.getColor(context, C0591R.color.trae_accent_accent_skill) : i2, (i4 & 1024) != 0 ? ContextCompat.getColor(context, C0591R.color.trae_text_text_default) : i3, (i4 & 2048) != 0 ? SkillTagSpanKt.m867dp(6.0f, context) : f6);
    }

    public SkillTagSpan(Context context, String str, int i, SkillItem skillItem, float f, float f2, float f3, float f4, float f5, int i2, int i3, float f6) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "skillName");
        this.context = context;
        this.skillName = str;
        this.iconRes = i;
        this.skillItem = skillItem;
        this.tagTextSize = f;
        this.tagPaddingH = f2;
        this.tagPaddingV = f3;
        this.iconSize = f4;
        this.iconMarginEnd = f5;
        this.tagBgColor = i2;
        this.tagTextColor = i3;
        this.cornerRadius = f6;
        Paint paint = new Paint(1);
        paint.setTextSize(f);
        paint.setColor(i3);
        paint.setTypeface(Typeface.DEFAULT);
        this.textPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(i2);
        paint2.setStyle(Paint.Style.FILL);
        this.bgPaint = paint2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        float measureText = this.textPaint.measureText(this.skillName);
        float f = this.tagPaddingH;
        this.spanWidth = (int) (this.iconSize + f + this.iconMarginEnd + measureText + f);
        if (fm != null) {
            Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
            int i = (int) (this.iconSize + (this.tagPaddingV * 2));
            int i2 = (fontMetricsInt.top + fontMetricsInt.bottom) / 2;
            int i3 = i / 2;
            fm.top = i2 - i3;
            fm.bottom = i2 + i3;
            fm.ascent = fm.top;
            fm.descent = fm.bottom;
        }
        return this.spanWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Paint.FontMetricsInt fontMetricsInt = this.textPaint.getFontMetricsInt();
        float f = (top + bottom) / 2.0f;
        float f2 = 2;
        float f3 = (this.iconSize + (this.tagPaddingV * f2)) / f2;
        RectF rectF = new RectF(x, f - f3, this.spanWidth + x, f3 + f);
        float f4 = this.cornerRadius;
        canvas.drawRoundRect(rectF, f4, f4, this.bgPaint);
        Drawable drawable = ContextCompat.getDrawable(this.context, this.iconRes);
        if (drawable != null) {
            int i = (int) (this.tagPaddingH + x);
            float f5 = this.iconSize;
            int i2 = (int) (f - (f5 / f2));
            drawable.setBounds(i, i2, (int) (i + f5), (int) (i2 + f5));
            drawable.draw(canvas);
        }
        canvas.drawText(this.skillName, x + this.tagPaddingH + this.iconSize + this.iconMarginEnd, f - ((fontMetricsInt.top + fontMetricsInt.bottom) / 2.0f), this.textPaint);
    }
}
