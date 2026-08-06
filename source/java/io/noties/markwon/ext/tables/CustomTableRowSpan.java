package io.noties.markwon.ext.tables;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import com.larus.business.markdown.api.view.text.IMarkdownTextView;
import io.noties.markwon.SizeVal;
import io.noties.markwon.core.spans.TextLayoutSpan;
import io.noties.markwon.core.spans.TextViewSpan;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.utils.LeadingMarginUtils;
import io.noties.markwon.utils.SpanUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class CustomTableRowSpan extends ReplacementSpan {
    public static final int ALIGN_CENTER = 1;
    public static final int ALIGN_LEFT = 0;
    public static final int ALIGN_RIGHT = 2;
    private final List<Cell> cells;
    private final boolean header;
    private int height;
    private Invalidator invalidator;
    private final List<Layout> layouts;
    private final boolean odd;
    private final TableTheme theme;
    private int width;
    private final Rect rect = new Rect();
    private final Paint paint = new Paint(1);
    private final TextPaint textPaint = new TextPaint();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public @interface Alignment {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface Invalidator {
        void invalidate();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Cell {
        final int alignment;
        final CharSequence text;

        public Cell(int i, CharSequence charSequence) {
            this.alignment = i;
            this.text = charSequence;
        }

        public int alignment() {
            return this.alignment;
        }

        public CharSequence text() {
            return this.text;
        }

        public String toString() {
            return "Cell{alignment=" + this.alignment + ", text=" + ((Object) this.text) + '}';
        }
    }

    public CustomTableRowSpan(TableTheme tableTheme, List<Cell> list, boolean z, boolean z2) {
        this.theme = tableTheme;
        this.cells = list;
        this.layouts = new ArrayList(list.size());
        this.header = z;
        this.odd = z2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        if (this.layouts.size() == 0 && SizeVal.INSTANCE.getPaint() != null && SizeVal.INSTANCE.getWidth() > 0 && recreateLayouts(SizeVal.INSTANCE.getWidth())) {
            this.width = SizeVal.INSTANCE.getWidth();
            this.textPaint.set(SizeVal.INSTANCE.getPaint());
            makeNewLayouts();
        }
        if (this.layouts.size() > 0 && fontMetricsInt != null) {
            Iterator<Layout> it = this.layouts.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i3) {
                    i3 = height;
                }
            }
            this.height = i3;
            fontMetricsInt.ascent = -(i3 + (this.theme.tableCellPadding() * 2));
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = fontMetricsInt.ascent;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x019a A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #0 {all -> 0x01ab, blocks: (B:40:0x0151, B:43:0x0158, B:44:0x0166, B:46:0x0171, B:47:0x0188, B:49:0x019a, B:54:0x015f), top: B:39:0x0151 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019f A[SYNTHETIC] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int save;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        Invalidator invalidator;
        int i10;
        float f2 = f;
        int width = SpanUtils.width(canvas, charSequence);
        if (recreateLayouts(width)) {
            this.width = width;
            if (paint instanceof TextPaint) {
                this.textPaint.set((TextPaint) paint);
            } else {
                this.textPaint.set(paint);
            }
            makeNewLayouts();
        }
        int tableCellPadding = this.theme.tableCellPadding();
        int size = this.layouts.size();
        int cellWidth = cellWidth(size);
        int i11 = cellWidth - (this.width / size);
        if (this.header) {
            this.theme.applyTableHeaderRowStyle(this.paint);
        } else if (this.odd) {
            this.theme.applyTableOddRowStyle(this.paint);
        } else {
            this.theme.applyTableEvenRowStyle(this.paint);
        }
        IMarkdownTextView textViewOf = TextViewSpan.textViewOf(charSequence);
        boolean z2 = (textViewOf instanceof IMarkdownTextView) && textViewOf.isSelected(i, i2);
        if (this.paint.getColor() != 0 || z2) {
            save = canvas.save();
            i6 = tableCellPadding;
            try {
                i7 = i11;
                i8 = cellWidth;
                i9 = size;
                this.rect.set(0, 0, this.width, i5 - i3);
                canvas.translate(f2, i3);
                if (this.paint.getColor() != 0) {
                    canvas.drawRect(this.rect, this.paint);
                }
                if (z2) {
                    this.paint.setColor(textViewOf.getSelectedColor());
                    canvas.drawRect(this.rect, this.paint);
                }
            } finally {
            }
        } else {
            i6 = tableCellPadding;
            i9 = size;
            i8 = cellWidth;
            i7 = i11;
        }
        this.paint.set(paint);
        this.theme.applyTableBorderStyle(this.paint);
        int tableBorderWidth = this.theme.tableBorderWidth(this.paint);
        boolean z3 = tableBorderWidth > 0;
        int i12 = i5 - i3;
        int i13 = (i12 - this.height) / 4;
        if (z3) {
            TableSpan[] tableSpanArr = (TableSpan[]) ((Spanned) charSequence).getSpans(i, i2, TableSpan.class);
            if (tableSpanArr == null || tableSpanArr.length <= 0 || !LeadingMarginUtils.selfStart(i, charSequence, tableSpanArr[0])) {
                z = false;
            } else {
                this.rect.set((int) f2, i3, this.width, i3 + tableBorderWidth);
                canvas.drawRect(this.rect, this.paint);
                z = true;
            }
            this.rect.set((int) f2, i5 - tableBorderWidth, this.width, i5);
            canvas.drawRect(this.rect, this.paint);
        } else {
            z = false;
        }
        int i14 = tableBorderWidth / 2;
        int i15 = z ? tableBorderWidth : 0;
        int i16 = i12 - tableBorderWidth;
        int i17 = i9;
        int i18 = 0;
        int i19 = 0;
        while (i18 < i17) {
            Layout layout = this.layouts.get(i18);
            save = canvas.save();
            try {
                canvas.translate((i18 * i8) + f2, i3);
                if (z3) {
                    if (i18 == 0) {
                        this.rect.set(0, i15, tableBorderWidth, i16);
                    } else {
                        this.rect.set(-i14, i15, i14, i16);
                    }
                    canvas.drawRect(this.rect, this.paint);
                    if (i18 == i17 - 1) {
                        i10 = i14;
                        this.rect.set((i8 - tableBorderWidth) - i7, i15, i8 - i7, i16);
                        canvas.drawRect(this.rect, this.paint);
                        int i20 = i6;
                        canvas.translate(i20, i20 + i13);
                        layout.draw(canvas);
                        if (layout.getHeight() <= i19) {
                            i19 = layout.getHeight();
                        }
                        canvas.restoreToCount(save);
                        i18++;
                        f2 = f;
                        i6 = i20;
                        i14 = i10;
                    }
                }
                i10 = i14;
                int i202 = i6;
                canvas.translate(i202, i202 + i13);
                layout.draw(canvas);
                if (layout.getHeight() <= i19) {
                }
                canvas.restoreToCount(save);
                i18++;
                f2 = f;
                i6 = i202;
                i14 = i10;
            } finally {
            }
        }
        if (this.height == i19 || (invalidator = this.invalidator) == null) {
            return;
        }
        invalidator.invalidate();
    }

    private boolean recreateLayouts(int i) {
        return this.width != i;
    }

    private void makeNewLayouts() {
        this.textPaint.setFakeBoldText(this.header);
        int size = this.cells.size();
        int cellWidth = cellWidth(size) - (this.theme.tableCellPadding() * 2);
        int max = Math.max(cellWidth, 0);
        this.layouts.clear();
        int size2 = this.cells.size();
        for (int i = 0; i < size2; i++) {
            makeLayout(i, max, this.cells.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(final int i, final int i2, final Cell cell) {
        Spannable spannableString;
        Runnable runnable = new Runnable() { // from class: io.noties.markwon.ext.tables.CustomTableRowSpan.1
            @Override // java.lang.Runnable
            public void run() {
                Invalidator invalidator = CustomTableRowSpan.this.invalidator;
                if (invalidator != null) {
                    CustomTableRowSpan.this.layouts.remove(i);
                    CustomTableRowSpan.this.makeLayout(i, i2, cell);
                    invalidator.invalidate();
                }
            }
        };
        if (cell.text instanceof Spannable) {
            spannableString = (Spannable) cell.text;
        } else {
            spannableString = new SpannableString(cell.text);
        }
        StaticLayout staticLayout = new StaticLayout(spannableString, this.textPaint, i2, alignment(cell.alignment), 1.0f, 0.0f, false);
        TextLayoutSpan.applyTo(spannableString, staticLayout);
        scheduleAsyncDrawables(spannableString, runnable);
        this.layouts.add(i, staticLayout);
    }

    private void scheduleAsyncDrawables(Spannable spannable, final Runnable runnable) {
        AsyncDrawableSpan[] asyncDrawableSpanArr = (AsyncDrawableSpan[]) spannable.getSpans(0, spannable.length(), AsyncDrawableSpan.class);
        if (asyncDrawableSpanArr == null || asyncDrawableSpanArr.length <= 0) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArr) {
            AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
            if (!drawable.isAttached()) {
                drawable.setCallback2(new CallbackAdapter() { // from class: io.noties.markwon.ext.tables.CustomTableRowSpan.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // io.noties.markwon.ext.tables.CustomTableRowSpan.CallbackAdapter, android.graphics.drawable.Drawable.Callback
                    public void invalidateDrawable(Drawable drawable2) {
                        runnable.run();
                    }
                });
            }
        }
    }

    public Layout findLayoutForHorizontalOffset(int i) {
        int size = this.layouts.size();
        int cellWidth = i / cellWidth(size);
        if (cellWidth >= size) {
            return null;
        }
        return this.layouts.get(cellWidth);
    }

    public int cellWidth() {
        return cellWidth(this.layouts.size());
    }

    protected int cellWidth(int i) {
        return (int) (((this.width * 1.0f) / i) + 0.5f);
    }

    private static Layout.Alignment alignment(int i) {
        if (i == 1) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (i == 2) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        return Layout.Alignment.ALIGN_NORMAL;
    }

    public void invalidator(Invalidator invalidator) {
        this.invalidator = invalidator;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static abstract class CallbackAdapter implements Drawable.Callback {
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        private CallbackAdapter() {
        }
    }
}
