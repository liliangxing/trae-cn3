package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes6.dex */
public class OrderedListItemSpan implements LeadingMarginSpan {
    boolean drawNumber;
    final int extraListBlockMargin;
    private ListMarginInfo info;
    int margin;
    final String number;
    final Paint paint;
    final MarkwonTheme theme;

    public static void measure(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            OrderedListItemSpan[] orderedListItemSpanArr = (OrderedListItemSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), OrderedListItemSpan.class);
            if (orderedListItemSpanArr != null) {
                TextPaint paint = textView.getPaint();
                for (OrderedListItemSpan orderedListItemSpan : orderedListItemSpanArr) {
                    orderedListItemSpan.margin = (int) (paint.measureText(orderedListItemSpan.number) + 0.5f);
                }
            }
        }
    }

    public OrderedListItemSpan(MarkwonTheme markwonTheme, String str) {
        this.paint = ObjectsPool.paint();
        this.drawNumber = true;
        this.info = null;
        this.theme = markwonTheme;
        this.number = str;
        this.extraListBlockMargin = 0;
    }

    public OrderedListItemSpan(MarkwonTheme markwonTheme, String str, int i) {
        this.paint = ObjectsPool.paint();
        this.drawNumber = true;
        this.info = null;
        this.theme = markwonTheme;
        this.number = str;
        this.extraListBlockMargin = i;
    }

    public OrderedListItemSpan(MarkwonTheme markwonTheme, ListMarginInfo listMarginInfo, String str, int i, boolean z) {
        this.paint = ObjectsPool.paint();
        this.theme = markwonTheme;
        this.info = listMarginInfo;
        this.number = str;
        this.extraListBlockMargin = i;
        this.drawNumber = z;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        ListMarginInfo listMarginInfo = this.info;
        return Math.max(this.margin, listMarginInfo != null ? listMarginInfo.getListMargin() : this.theme.getBlockMargin()) + this.extraListBlockMargin;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint);
            if (((MarkdownSpanInfo[]) ((Spanned) charSequence).getSpans(i6, Math.min(i6 + 1, i7), MarkdownSpanInfo.class)).length > 0) {
                this.paint.setAlpha((int) (this.paint.getAlpha() * (r2[0].getAlpha() / 255.0f)));
            }
            this.theme.applyListItemStyle(this.paint, true);
            if (this.drawNumber) {
                int measureText = (int) (this.paint.measureText(this.number) + 0.5f);
                ListMarginInfo listMarginInfo = this.info;
                int listMargin = listMarginInfo != null ? listMarginInfo.getListMargin() : this.theme.getBlockMargin();
                if (measureText > listMargin) {
                    this.margin = measureText;
                    listMargin = measureText;
                } else {
                    this.margin = 0;
                }
                int i8 = listMargin + this.extraListBlockMargin;
                canvas.drawText(this.number, i2 > 0 ? (i + (i8 * i2)) - measureText : i + (i2 * i8) + (i8 - measureText), i4, this.paint);
            }
        }
    }
}
