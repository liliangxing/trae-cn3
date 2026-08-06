package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import com.larus.business.markdown.api.model.ListSymbolStrategy;
import com.larus.business.markdown.api.model.UnorderedSymbol;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes6.dex */
public class BulletListItemSpan2 implements LeadingMarginSpan {
    private static final boolean IS_NOUGAT;
    private int adjustedListItemColor;
    private final RectF circle;
    private boolean drawDot;
    private int extraListBlockMargin;
    private ListMarginInfo info;
    public final int level;
    public ListSymbolStrategy listSymbolStrategy;
    private final Paint paint;
    private final Rect rectangle;
    private MarkwonTheme theme;

    static {
        int i = Build.VERSION.SDK_INT;
        IS_NOUGAT = 24 == i || 25 == i;
    }

    public BulletListItemSpan2(MarkwonTheme markwonTheme, int i, int i2) {
        this.paint = ObjectsPool.paint();
        this.circle = ObjectsPool.rectF();
        this.rectangle = ObjectsPool.rect();
        this.drawDot = true;
        this.info = null;
        this.adjustedListItemColor = 0;
        this.listSymbolStrategy = null;
        this.theme = markwonTheme;
        this.level = i;
        this.extraListBlockMargin = i2;
    }

    public BulletListItemSpan2(MarkwonTheme markwonTheme, ListMarginInfo listMarginInfo, int i, int i2, boolean z) {
        this.paint = ObjectsPool.paint();
        this.circle = ObjectsPool.rectF();
        this.rectangle = ObjectsPool.rect();
        this.adjustedListItemColor = 0;
        this.listSymbolStrategy = null;
        this.theme = markwonTheme;
        this.info = listMarginInfo;
        this.level = i;
        this.extraListBlockMargin = i2;
        this.drawDot = z;
    }

    public BulletListItemSpan2(MarkwonTheme markwonTheme, int i) {
        this(markwonTheme, i, 0);
    }

    public void setAdjustedListItemColor(int i) {
        this.adjustedListItemColor = i;
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
                this.paint.setAlpha((int) (this.paint.getAlpha() * (r0[0].getAlpha() / 255.0f)));
            }
            int i11 = this.adjustedListItemColor;
            if (i11 != 0) {
                MarkwonTheme.builder(this.theme).bulletListItemColor(i11).build().applyListItemStyle(this.paint, false);
            } else {
                this.theme.applyListItemStyle(this.paint, false);
            }
            int save = canvas.save();
            try {
                ListMarginInfo listMarginInfo = this.info;
                int listMargin = listMarginInfo != null ? listMarginInfo.getListMargin() : this.theme.getBlockMargin();
                int descent = (int) ((this.paint.descent() - this.paint.ascent()) + 0.5f);
                ListMarginInfo listMarginInfo2 = this.info;
                int dotDiameter = listMarginInfo2 != null ? listMarginInfo2.getDotDiameter() : this.theme.getBulletWidth(descent);
                int i12 = ((listMargin - dotDiameter) / 2) + this.extraListBlockMargin;
                ListMarginInfo listMarginInfo3 = this.info;
                if (listMarginInfo3 != null) {
                    i12 += listMarginInfo3.getBulletDotOffset();
                }
                if (IS_NOUGAT) {
                    if (i2 < 0) {
                        i10 = i - (layout.getWidth() - (listMargin * this.level));
                    } else {
                        i10 = (listMargin * this.level) - i;
                    }
                    int i13 = (i12 * i2) + i;
                    int i14 = (i2 * dotDiameter) + i13;
                    int i15 = i10 * i2;
                    i9 = Math.min(i13, i14) + i15;
                    i8 = Math.max(i13, i14) + i15;
                } else {
                    int i16 = i2 > 0 ? i + i12 : (i - listMargin) + i12;
                    i8 = i16 + dotDiameter;
                    i9 = i16;
                }
                int descent2 = (i4 + ((int) (((this.paint.descent() + this.paint.ascent()) / 2.0f) + 0.5f))) - (dotDiameter / 2);
                int i17 = dotDiameter + descent2;
                ListSymbolStrategy listSymbolStrategy = this.listSymbolStrategy;
                if (listSymbolStrategy != null) {
                    int i18 = AnonymousClass1.$SwitchMap$com$larus$business$markdown$api$model$UnorderedSymbol[listSymbolStrategy.unorderedSymbol(this.level).ordinal()];
                    if (i18 == 1) {
                        drawOval(true, canvas, i9, descent2, i8, i17);
                    } else if (i18 == 2) {
                        drawOval(false, canvas, i9, descent2, i8, i17);
                    } else if (i18 == 3) {
                        drawRect(canvas, i9, descent2, i8, i17);
                    }
                } else {
                    int i19 = this.level;
                    if (i19 == 0) {
                        drawOval(true, canvas, i9, descent2, i8, i17);
                    } else if (i19 == 1) {
                        drawOval(false, canvas, i9, descent2, i8, i17);
                    } else {
                        drawRect(canvas, i9, descent2, i8, i17);
                    }
                }
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    /* renamed from: io.noties.markwon.core.spans.BulletListItemSpan2$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$larus$business$markdown$api$model$UnorderedSymbol;

        static {
            int[] iArr = new int[UnorderedSymbol.values().length];
            $SwitchMap$com$larus$business$markdown$api$model$UnorderedSymbol = iArr;
            try {
                iArr[UnorderedSymbol.DISC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$larus$business$markdown$api$model$UnorderedSymbol[UnorderedSymbol.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$larus$business$markdown$api$model$UnorderedSymbol[UnorderedSymbol.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void drawOval(boolean z, Canvas canvas, int i, int i2, int i3, int i4) {
        this.circle.set(i, i2, i3, i4);
        this.paint.setStyle(z ? Paint.Style.FILL : Paint.Style.STROKE);
        canvas.drawOval(this.circle, this.paint);
    }

    private void drawRect(Canvas canvas, int i, int i2, int i3, int i4) {
        this.rectangle.set(i, i2, i3, i4);
        this.paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(this.rectangle, this.paint);
    }
}
