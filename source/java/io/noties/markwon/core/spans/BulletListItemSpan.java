package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes6.dex */
public class BulletListItemSpan implements LeadingMarginSpan {
    private static final boolean IS_NOUGAT;
    private final RectF circle;
    private boolean drawDot;
    private int extraListBlockMargin;
    private ListMarginInfo info;
    private final int level;
    private final Paint paint;
    private final Rect rectangle;
    private MarkwonTheme theme;

    static {
        int i = Build.VERSION.SDK_INT;
        IS_NOUGAT = 24 == i || 25 == i;
    }

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i, int i2) {
        this.paint = ObjectsPool.paint();
        this.circle = ObjectsPool.rectF();
        this.rectangle = ObjectsPool.rect();
        this.drawDot = true;
        this.info = null;
        this.theme = markwonTheme;
        this.level = i;
        this.extraListBlockMargin = i2;
    }

    public BulletListItemSpan(MarkwonTheme markwonTheme, ListMarginInfo listMarginInfo, int i, int i2, boolean z) {
        this.paint = ObjectsPool.paint();
        this.circle = ObjectsPool.rectF();
        this.rectangle = ObjectsPool.rect();
        this.theme = markwonTheme;
        this.info = listMarginInfo;
        this.level = i;
        this.extraListBlockMargin = i2;
        this.drawDot = z;
    }

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i) {
        this(markwonTheme, i, 0);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        ListMarginInfo listMarginInfo = this.info;
        return this.extraListBlockMargin + (listMarginInfo != null ? listMarginInfo.getListMargin() : this.theme.getBlockMargin());
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
        int i8;
        int i9;
        int i10;
        if (this.drawDot && z && LeadingMarginUtils.selfStart(i6, charSequence, this)) {
            this.paint.set(paint);
            if (((MarkdownSpanInfo[]) ((Spanned) charSequence).getSpans(i6, Math.min(i6 + 1, i7), MarkdownSpanInfo.class)).length > 0) {
                this.paint.setAlpha((int) (this.paint.getAlpha() * (r2[0].getAlpha() / 255.0f)));
            }
            this.theme.applyListItemStyle(this.paint, false);
            int save = canvas.save();
            try {
                ListMarginInfo listMarginInfo = this.info;
                int listMargin = listMarginInfo != null ? listMarginInfo.getListMargin() : this.theme.getBlockMargin();
                int descent = (int) ((this.paint.descent() - this.paint.ascent()) + 0.5f);
                ListMarginInfo listMarginInfo2 = this.info;
                int dotDiameter = listMarginInfo2 != null ? listMarginInfo2.getDotDiameter() : this.theme.getBulletWidth(descent);
                int i11 = ((listMargin - dotDiameter) / 2) + this.extraListBlockMargin;
                ListMarginInfo listMarginInfo3 = this.info;
                if (listMarginInfo3 != null) {
                    i11 += listMarginInfo3.getBulletDotOffset();
                }
                if (IS_NOUGAT) {
                    if (i2 < 0) {
                        i10 = i - (layout.getWidth() - (listMargin * this.level));
                    } else {
                        i10 = (listMargin * this.level) - i;
                    }
                    int i12 = i + (i11 * i2);
                    int i13 = (i2 * dotDiameter) + i12;
                    int i14 = i2 * i10;
                    i8 = Math.min(i12, i13) + i14;
                    i9 = Math.max(i12, i13) + i14;
                } else {
                    if (i2 <= 0) {
                        i -= listMargin;
                    }
                    i8 = i + i11;
                    i9 = i8 + dotDiameter;
                }
                int descent2 = (i4 + ((int) (((this.paint.descent() + this.paint.ascent()) / 2.0f) + 0.5f))) - (dotDiameter / 2);
                int i15 = dotDiameter + descent2;
                int i16 = this.level;
                if (i16 != 0 && i16 != 1) {
                    this.rectangle.set(i8, descent2, i9, i15);
                    this.paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.rectangle, this.paint);
                }
                this.circle.set(i8, descent2, i9, i15);
                this.paint.setStyle(this.level == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                canvas.drawOval(this.circle, this.paint);
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }
}
