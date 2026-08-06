package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: classes6.dex */
public class BlockQuoteSpan implements LeadingMarginSpan {
    private final int blockMargin;
    private final int lineCornerRadius;
    private final Paint paint;
    private final Path path;
    private final Rect rect;
    private final MarkwonTheme theme;

    public BlockQuoteSpan(MarkwonTheme markwonTheme) {
        this.rect = ObjectsPool.rect();
        this.paint = ObjectsPool.paint();
        this.path = new Path();
        this.theme = markwonTheme;
        this.lineCornerRadius = 0;
        this.blockMargin = 0;
    }

    public BlockQuoteSpan(MarkwonTheme markwonTheme, int i, int i2) {
        this.rect = ObjectsPool.rect();
        this.paint = ObjectsPool.paint();
        this.path = new Path();
        this.theme = markwonTheme;
        this.lineCornerRadius = i;
        this.blockMargin = i2;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i = this.blockMargin;
        return i > 0 ? i : this.theme.getBlockMargin();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int blockQuoteWidth = this.theme.getBlockQuoteWidth();
        this.paint.set(paint);
        this.theme.applyBlockQuoteStyle(this.paint);
        int i8 = blockQuoteWidth * i2;
        int i9 = i + i8;
        int i10 = i8 + i9;
        int min = Math.min(i9, i10);
        int max = Math.max(i9, i10);
        if (this.lineCornerRadius > 0 && (charSequence instanceof Spanned)) {
            Spanned spanned = (Spanned) charSequence;
            if (spanned.getSpanStart(this) == i6) {
                drawTopRoundRect(canvas, min, i3, max, i5, this.lineCornerRadius, this.path);
                return;
            } else if (spanned.getSpanEnd(this) == i7) {
                drawBottomRoundRect(canvas, min, i3, max, i5, this.lineCornerRadius, this.path);
                return;
            } else {
                this.rect.set(min, i3, max, i5);
                canvas.drawRect(this.rect, this.paint);
                return;
            }
        }
        this.rect.set(min, i3, max, i5);
        canvas.drawRect(this.rect, this.paint);
    }

    private void drawTopRoundRect(Canvas canvas, float f, float f2, float f3, float f4, float f5, Path path) {
        RectF rectF = ObjectsPool.rectF();
        path.reset();
        path.moveTo(f, f2 + f5);
        float f6 = 2.0f * f5;
        float f7 = f2 + f6;
        rectF.set(f, f2, f + f6, f7);
        path.arcTo(rectF, 180.0f, 90.0f);
        path.lineTo(f3 - f5, f2);
        rectF.set(f3 - f6, f2, f3, f7);
        path.arcTo(rectF, 270.0f, 90.0f);
        path.lineTo(f3, f4);
        path.lineTo(f, f4);
        path.close();
        canvas.drawPath(path, this.paint);
    }

    private void drawBottomRoundRect(Canvas canvas, float f, float f2, float f3, float f4, float f5, Path path) {
        RectF rectF = ObjectsPool.rectF();
        path.reset();
        path.moveTo(f, f2);
        path.lineTo(f3, f2);
        path.lineTo(f3, f4 - f5);
        float f6 = 2.0f * f5;
        float f7 = f4 - f6;
        rectF.set(f3 - f6, f7, f3, f4);
        path.arcTo(rectF, 0.0f, 90.0f);
        path.lineTo(f5 + f, f4);
        rectF.set(f, f7, f6 + f, f4);
        path.arcTo(rectF, 90.0f, 90.0f);
        path.close();
        canvas.drawPath(path, this.paint);
    }
}
