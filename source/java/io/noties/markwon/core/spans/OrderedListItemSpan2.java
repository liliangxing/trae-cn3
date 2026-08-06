package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class OrderedListItemSpan2 extends OrderedListItemSpan {
    private int adjustedListItemColor;
    private ListMarginInfo info;
    public String orderNumber;

    public OrderedListItemSpan2(MarkwonTheme markwonTheme, ListMarginInfo listMarginInfo, String str, int i, boolean z) {
        super(markwonTheme, listMarginInfo, str, i, z);
        this.adjustedListItemColor = 0;
        this.orderNumber = str;
        this.info = listMarginInfo;
    }

    public void setAdjustedListItemColor(int i) {
        this.adjustedListItemColor = i;
    }

    @Override // io.noties.markwon.core.spans.OrderedListItemSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        if (z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint);
            if (((MarkdownSpanInfo[]) ((Spanned) charSequence).getSpans(i6, Math.min(i6 + 1, i7), MarkdownSpanInfo.class)).length > 0) {
                this.paint.setAlpha((int) (this.paint.getAlpha() * (r2[0].getAlpha() / 255.0f)));
            }
            int i8 = this.adjustedListItemColor;
            if (i8 != 0) {
                MarkwonTheme.builder(this.theme).orderedListItemColor(i8).build().applyListItemStyle(this.paint, true);
            } else {
                this.theme.applyListItemStyle(this.paint, true);
            }
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
                int i9 = listMargin + this.extraListBlockMargin;
                canvas.drawText(this.number, i2 > 0 ? (i + (i9 * i2)) - measureText : i + (i2 * i9) + (i9 - measureText), i4, this.paint);
            }
        }
    }
}
