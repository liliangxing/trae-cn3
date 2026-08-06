package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BgOrderedListItemSpan.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fJp\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0016J\u001a\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006&"}, d2 = {"Lio/noties/markwon/core/spans/BgOrderedListItemSpan;", "Lio/noties/markwon/core/spans/OrderedListItemSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "orderNumber", "", "bgColor", "", "bgMargin", "bgRadius", "", "leading", "(Lio/noties/markwon/core/MarkwonTheme;Ljava/lang/String;IILjava/lang/Float;Ljava/lang/Integer;)V", "bgPaint", "Landroid/graphics/Paint;", "Ljava/lang/Float;", "Ljava/lang/Integer;", "drawLeadingMargin", "", "c", "Landroid/graphics/Canvas;", "p", "x", "dir", AnimationConstant.PROP_STR_TOP, "baseline", AnimationConstant.PROP_STR_BOTTOM, "text", "", "start", "end", "first", "", "layout", "Landroid/text/Layout;", "getLeadingMargin", "getNumberHeight", "number", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class BgOrderedListItemSpan extends OrderedListItemSpan {
    private final int bgColor;
    private final int bgMargin;
    private final Paint bgPaint;
    private final Float bgRadius;
    private final Integer leading;

    public /* synthetic */ BgOrderedListItemSpan(MarkwonTheme markwonTheme, String str, int i, int i2, Float f, Integer num, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(markwonTheme, str, i, i2, (i3 & 16) != 0 ? Float.valueOf(0.0f) : f, (i3 & 32) != 0 ? 0 : num);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BgOrderedListItemSpan(MarkwonTheme markwonTheme, String str, int i, int i2, Float f, Integer num) {
        super(markwonTheme, str);
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(str, "orderNumber");
        this.bgColor = i;
        this.bgMargin = i2;
        this.bgRadius = f;
        this.leading = num;
        this.bgPaint = new Paint(1);
    }

    @Override // io.noties.markwon.core.spans.OrderedListItemSpan, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        Integer num = this.leading;
        return (num != null ? num.intValue() : 0) + (this.bgMargin * 2);
    }

    @Override // io.noties.markwon.core.spans.OrderedListItemSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        if (first && LeadingMarginUtils.selfStart(start, text, this)) {
            this.paint.set(p);
            this.theme.applyListItemStyle(this.paint, true);
            String str = this.number;
            Intrinsics.checkNotNullExpressionValue(str, "number");
            String substring = str.substring(0, this.number.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int measureText = (int) (this.paint.measureText(this.number) + 0.5f);
            int measureText2 = (int) (this.paint.measureText(substring) + 0.5f);
            float numberHeight = getNumberHeight(substring, p) + 0.5f;
            if (measureText > this.theme.getBlockMargin()) {
                this.margin = measureText;
            } else {
                this.margin = 0;
            }
            this.bgPaint.setColor(this.bgColor);
            this.bgPaint.setStyle(Paint.Style.FILL);
            float f = baseline;
            int i = this.bgMargin;
            RectF rectF = new RectF(0.0f, (f - numberHeight) - i, measureText2 + (i * 2), i + f);
            if (c != null) {
                Float f2 = this.bgRadius;
                float floatValue = f2 != null ? f2.floatValue() : 0.0f;
                Float f3 = this.bgRadius;
                c.drawRoundRect(rectF, floatValue, f3 != null ? f3.floatValue() : 0.0f, this.bgPaint);
            }
            if (c != null) {
                c.drawText(this.number, this.bgMargin, f, this.paint);
            }
        }
    }

    private final float getNumberHeight(String number, Paint p) {
        Rect rect = new Rect();
        if (p != null) {
            p.getTextBounds(number, 0, number.length(), rect);
        }
        return rect.height();
    }
}
