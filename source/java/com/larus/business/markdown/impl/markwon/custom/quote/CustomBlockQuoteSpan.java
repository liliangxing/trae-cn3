package com.larus.business.markdown.impl.markwon.custom.quote;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.core.MarkwonTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: CustomBlockQuoteSpan.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J@\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002Jn\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J@\u0010%\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"H\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/custom/quote/CustomBlockQuoteSpan;", "Landroid/text/style/LeadingMarginSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "lineCornerRadius", "", "blockMargin", "(Lio/noties/markwon/core/MarkwonTheme;II)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "rect", "Landroid/graphics/Rect;", "drawBottomRoundRect", "", "c", "Landroid/graphics/Canvas;", AnimationConstant.PROP_STR_LEFT, "", AnimationConstant.PROP_STR_TOP, AnimationConstant.PROP_STR_RIGHT, AnimationConstant.PROP_STR_BOTTOM, "cornerRadius", "drawLeadingMargin", "p", "x", "dir", "baseline", "text", "", "start", "end", "first", "", "layout", "Landroid/text/Layout;", "drawTopRoundRect", "getLeadingMargin", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CustomBlockQuoteSpan implements LeadingMarginSpan {
    private final int blockMargin;
    private final int lineCornerRadius;
    private final Paint paint;
    private final Path path;
    private final Rect rect;
    private final MarkwonTheme theme;

    public CustomBlockQuoteSpan(MarkwonTheme markwonTheme, int i, int i2) {
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        this.theme = markwonTheme;
        this.lineCornerRadius = i;
        this.blockMargin = i2;
        this.rect = new Rect();
        this.paint = new Paint();
        this.path = new Path();
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        int i = this.blockMargin;
        return i > 0 ? i : this.theme.getBlockMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        Intrinsics.checkNotNullParameter(c, "c");
        int blockQuoteWidth = this.theme.getBlockQuoteWidth();
        this.paint.set(p);
        this.theme.applyBlockQuoteStyle(this.paint);
        int i = (blockQuoteWidth * dir) + x;
        int coerceAtMost = RangesKt.coerceAtMost(x, i);
        int coerceAtLeast = RangesKt.coerceAtLeast(x, i);
        if (this.lineCornerRadius > 0 && (text instanceof Spanned)) {
            Spanned spanned = (Spanned) text;
            if (spanned.getSpanStart(this) == start) {
                drawTopRoundRect(c, coerceAtMost, top, coerceAtLeast, bottom, this.lineCornerRadius, this.path);
                return;
            } else if (spanned.getSpanEnd(this) == end) {
                drawBottomRoundRect(c, coerceAtMost, top, coerceAtLeast, bottom, this.lineCornerRadius, this.path);
                return;
            } else {
                this.rect.set(coerceAtMost, top, coerceAtLeast, bottom);
                c.drawRect(this.rect, this.paint);
                return;
            }
        }
        this.rect.set(coerceAtMost, top, coerceAtLeast, bottom);
        c.drawRect(this.rect, this.paint);
    }

    private final void drawTopRoundRect(Canvas c, float left, float top, float right, float bottom, float cornerRadius, Path path) {
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        path.reset();
        path.moveTo(left, bottom);
        path.lineTo(right, bottom);
        float f = top + cornerRadius;
        path.lineTo(right, f);
        path.arcTo(new RectF(right - cornerRadius, top, right, f), 0.0f, -90.0f, false);
        float f2 = cornerRadius + left;
        path.lineTo(f2, top);
        path.arcTo(new RectF(left, top, f2, f), 270.0f, -90.0f, false);
        path.close();
        c.drawPath(path, this.paint);
    }

    private final void drawBottomRoundRect(Canvas c, float left, float top, float right, float bottom, float cornerRadius, Path path) {
        this.paint.setAntiAlias(true);
        this.paint.setDither(true);
        path.reset();
        path.moveTo(left, top);
        path.lineTo(right, top);
        float f = bottom - cornerRadius;
        path.lineTo(right, f);
        path.arcTo(new RectF(right - cornerRadius, f, right, bottom), 0.0f, 90.0f, false);
        float f2 = cornerRadius + left;
        path.lineTo(f2, bottom);
        path.arcTo(new RectF(left, f, f2, bottom), 90.0f, 90.0f, false);
        path.close();
        c.drawPath(path, this.paint);
    }
}
