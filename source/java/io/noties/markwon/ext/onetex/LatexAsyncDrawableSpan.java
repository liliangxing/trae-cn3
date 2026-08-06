package io.noties.markwon.ext.onetex;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spanned;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.core.spans.MarkdownSpanInfo;
import io.noties.markwon.custom.TypingFreeSpan;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.utils.SpanUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LatexAsyncDrawableSpan extends AsyncDrawableSpan implements TypingFreeSpan {
    private final Paint backgroundPaint;
    private final LatexAsyncDrawable drawable;
    protected int selectedColor;

    public LatexAsyncDrawableSpan(MarkwonTheme markwonTheme, LatexAsyncDrawable latexAsyncDrawable) {
        super(markwonTheme, latexAsyncDrawable, 2, false);
        this.backgroundPaint = new Paint(1);
        this.selectedColor = 0;
        this.drawable = latexAsyncDrawable;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.drawable.hasResult()) {
            Rect bounds = this.drawable.getBounds();
            if (fontMetricsInt != null) {
                Paint.FontMetricsInt fontMetricsInt2 = paint.getFontMetricsInt();
                fontMetricsInt.descent = fontMetricsInt2.descent + ((bounds.height() - (fontMetricsInt2.descent - fontMetricsInt2.ascent)) / 2);
                fontMetricsInt.ascent = fontMetricsInt.descent - bounds.height();
                fontMetricsInt.top = fontMetricsInt.ascent;
                fontMetricsInt.bottom = fontMetricsInt.descent;
            }
            return bounds.right;
        }
        return (int) (paint.measureText(charSequence, i, i2) + 0.5f);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        this.drawable.initWithKnownDimensions(SpanUtils.width(canvas, charSequence), paint.getTextSize());
        LatexAsyncDrawable latexAsyncDrawable = this.drawable;
        MarkdownSpanInfo[] markdownSpanInfoArr = (MarkdownSpanInfo[]) ((Spanned) charSequence).getSpans(i, i2, MarkdownSpanInfo.class);
        if (markdownSpanInfoArr.length > 0) {
            latexAsyncDrawable.setAlpha(markdownSpanInfoArr[0].getAlpha());
        } else {
            latexAsyncDrawable.setAlpha(255);
        }
        if (latexAsyncDrawable.hasResult()) {
            onPreDraw(Math.max(latexAsyncDrawable.getLastKnownCanvasWidth() - f, 0.0f));
            int save = canvas.save();
            float f2 = i4;
            try {
                float ascent = ((paint.ascent() + f2) + (f2 + paint.descent())) / 2.0f;
                float centerY = latexAsyncDrawable.getBounds().centerY();
                Drawable result = latexAsyncDrawable.getResult();
                int width = result instanceof LatexDrawable ? ((LatexDrawable) result).getTexIcon().getWidth() : 0;
                this.backgroundPaint.setColor(this.selectedColor);
                canvas.drawRect(f, i3, f + width, i5, this.backgroundPaint);
                canvas.translate(f, (int) (ascent - centerY));
                latexAsyncDrawable.draw(canvas);
                return;
            } finally {
                canvas.restoreToCount(save);
            }
        }
        canvas.drawText(charSequence, i, i2, f, textCenterY(i3, i5, paint), paint);
    }

    public LatexAsyncDrawable drawable() {
        return this.drawable;
    }

    protected void onPreDraw(float f) {
        super.onPreDraw(f);
        Drawable result = this.drawable.getResult();
        if (result instanceof LatexDrawable) {
            ((LatexDrawable) result).setAvailableWidth(f);
        }
    }

    private static float textCenterY(int i, int i2, Paint paint) {
        return (int) ((i + ((i2 - i) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    public void setBackgroundSelectedColor(int i) {
        this.selectedColor = i;
    }
}
