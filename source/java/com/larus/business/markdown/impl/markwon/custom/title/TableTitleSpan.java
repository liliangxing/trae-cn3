package com.larus.business.markdown.impl.markwon.custom.title;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.custom.TypingFreeSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TableTitleSpan.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002Jh\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010'\u001a\u00020\t2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0016H\u0016R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/title/TableTitleSpan;", "Landroid/text/style/MetricAffectingSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/custom/TypingFreeSpan;", SettingsTracker.TYPE_THEME, "Lio/noties/markwon/core/MarkwonTheme;", "cornerRadius", "", "titleBgColor", "", "tableTitleStartIndex", "borderColor", "(Lio/noties/markwon/core/MarkwonTheme;FILjava/lang/Integer;I)V", "borderPaint", "Landroid/graphics/Paint;", "paint", "rect", "Landroid/graphics/Rect;", "Ljava/lang/Integer;", "apply", "", AirActionConstant.ActionId.ACTION_ID_PARAMS, "Landroid/text/TextPaint;", "drawLeadingMargin", AirActionConstant.ActionId.ACTION_ID_CALL, "Landroid/graphics/Canvas;", "x", "dir", "top", "baseline", "bottom", "text", "", "start", "end", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "updateDrawState", "tp", "updateMeasureState", "textPaint", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class TableTitleSpan extends MetricAffectingSpan implements LeadingMarginSpan, TypingFreeSpan {
    private final int borderColor;
    private final Paint borderPaint;
    private final float cornerRadius;
    private final Paint paint;
    private final Rect rect;
    private final Integer tableTitleStartIndex;
    private final MarkwonTheme theme;
    private final int titleBgColor;

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint tp) {
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "textPaint");
    }

    public TableTitleSpan(MarkwonTheme theme, float f, int i, Integer num, int i2) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        this.theme = theme;
        this.cornerRadius = f;
        this.titleBgColor = i;
        this.tableTitleStartIndex = num;
        this.borderColor = i2;
        this.rect = new Rect();
        this.paint = new Paint(1);
        this.borderPaint = new Paint(1);
    }

    private final void apply(TextPaint p) {
        this.theme.applyCodeBlockTextStyle(p);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return this.theme.getCodeBlockMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        int i;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (start == end) {
            return;
        }
        this.paint.setStyle(Paint.Style.FILL);
        int width = layout.getWidth();
        if (dir > 0) {
            x = width;
            i = x;
        } else {
            i = x - width;
        }
        int dp2px = MarkdownUnitExtKt.dp2px(Double.valueOf(0.5d));
        Integer num = this.tableTitleStartIndex;
        if (num != null && start == num.intValue()) {
            Path path = new Path();
            float f = x - i;
            int i2 = bottom - top;
            float f2 = this.cornerRadius;
            float f3 = i;
            path.moveTo(f3 + f2, top);
            float f4 = f - (2 * f2);
            path.rLineTo(f4, 0.0f);
            path.rQuadTo(f2, 0.0f, f2, f2);
            float f5 = i2 - f2;
            path.rLineTo(0.0f, f5);
            path.rLineTo(-f, 0.0f);
            float f6 = -f5;
            path.rLineTo(0.0f, f6);
            float f7 = -f2;
            path.rQuadTo(0.0f, f7, f2, f7);
            path.close();
            this.paint.setColor(this.titleBgColor);
            c.drawPath(path, this.paint);
            Path path2 = new Path();
            this.borderPaint.setColor(this.borderColor);
            this.borderPaint.setStyle(Paint.Style.STROKE);
            this.borderPaint.setStrokeWidth(dp2px);
            path2.moveTo(f3, bottom);
            path2.rLineTo(0.0f, f6);
            path2.rQuadTo(0.0f, f7, f2, f7);
            path2.rLineTo(f4, 0.0f);
            path2.rQuadTo(f2, 0.0f, f2, f2);
            path2.rLineTo(0.0f, f5);
            c.drawPath(path2, this.borderPaint);
        }
    }
}
