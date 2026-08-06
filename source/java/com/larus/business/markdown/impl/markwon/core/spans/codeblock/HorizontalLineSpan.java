package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import android.util.TypedValue;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.larus.business.markdown.impl.common.utils.MarkdownUnitExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HorizontalLineSpan.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJR\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J4\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/HorizontalLineSpan;", "Landroid/text/style/ReplacementSpan;", "context", "Landroid/content/Context;", "startMargin", "", "lineHeight", "lineColor", "(Landroid/content/Context;III)V", "bottomExtraMargin", "realLineHeight", "", WebViewContainer.EVENT_draw, "", "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "top", "y", "bottom", "paint", "Landroid/graphics/Paint;", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class HorizontalLineSpan extends ReplacementSpan {
    private final int bottomExtraMargin;
    private final Context context;
    private final int lineColor;
    private final float realLineHeight;
    private final int startMargin;

    public HorizontalLineSpan(Context context, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.startMargin = i;
        this.lineColor = i3;
        this.realLineHeight = TypedValue.applyDimension(0, i2, context.getResources().getDisplayMetrics());
        this.bottomExtraMargin = MarkdownUnitExtKt.dp2px((Number) 7);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (fm == null) {
            return 0;
        }
        fm.ascent += (fm.descent - fm.ascent) - ((int) this.realLineHeight);
        fm.top = fm.ascent;
        fm.descent = fm.ascent + ((int) (this.realLineHeight + this.bottomExtraMargin));
        fm.bottom = fm.descent;
        return 0;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        float f;
        int width;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        int color = paint.getColor();
        paint.setColor(this.lineColor);
        paint.setStrokeWidth(this.realLineHeight);
        if (this.context.getResources().getConfiguration().getLayoutDirection() == 1) {
            f = canvas.getWidth();
            width = this.startMargin;
        } else {
            f = x - this.startMargin;
            width = canvas.getWidth();
        }
        float f2 = top;
        canvas.drawLine(f, f2, width, f2, paint);
        paint.setColor(color);
    }
}
