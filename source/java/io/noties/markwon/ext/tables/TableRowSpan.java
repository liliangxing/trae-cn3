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
import io.noties.markwon.core.spans.TextLayoutSpan;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.utils.LeadingMarginUtils;
import io.noties.markwon.utils.SpanUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TableRowSpan extends AbsTableRowSpan {
    private final List<Cell> cells;
    private final boolean header;
    private int height;
    private final List<Layout> layouts;
    private final boolean odd;
    private final TableTheme theme;
    private int width;
    private final Rect rect = new Rect();
    private final Paint paint = new Paint(1);
    private final TextPaint textPaint = new TextPaint();

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <Span> List<Span> findSpanInRow(Class<Span> cls) {
        return null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Cell {
        public final int alignment;
        public final CharSequence text;

        public Cell(int i, CharSequence charSequence) {
            this.alignment = i;
            this.text = charSequence;
        }
    }

    public TableRowSpan(TableTheme tableTheme, List<Cell> list, boolean z, boolean z2) {
        this.theme = tableTheme;
        this.cells = list;
        this.layouts = new ArrayList(list.size());
        this.header = z;
        this.odd = z2;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
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

    /* JADX WARN: Removed duplicated region for block: B:46:0x0164 A[Catch: all -> 0x0177, TRY_LEAVE, TryCatch #0 {all -> 0x0177, blocks: (B:37:0x011c, B:40:0x0123, B:41:0x0131, B:43:0x013c, B:44:0x0152, B:46:0x0164, B:51:0x012a), top: B:36:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0169 A[SYNTHETIC] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        int i6;
        int i7;
        boolean z;
        int save;
        int i8;
        boolean z2;
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
        int i9 = cellWidth - (this.width / size);
        if (this.header) {
            this.theme.applyTableHeaderRowStyle(this.paint);
        } else if (this.odd) {
            this.theme.applyTableOddRowStyle(this.paint);
        } else {
            this.theme.applyTableEvenRowStyle(this.paint);
        }
        if (this.paint.getColor() != 0) {
            save = canvas.save();
            try {
                i6 = tableCellPadding;
                this.rect.set(0, 0, this.width, i5 - i3);
                canvas.translate(f2, i3);
                canvas.drawRect(this.rect, this.paint);
            } finally {
            }
        } else {
            i6 = tableCellPadding;
        }
        this.paint.set(paint);
        this.theme.applyTableBorderStyle(this.paint);
        int tableBorderWidth = this.theme.tableBorderWidth(this.paint);
        boolean z3 = tableBorderWidth > 0;
        int i10 = i5 - i3;
        int i11 = (i10 - this.height) / 4;
        if (z3) {
            i7 = i11;
            TableSpan[] tableSpanArr = (TableSpan[]) ((Spanned) charSequence).getSpans(i, i2, TableSpan.class);
            if (tableSpanArr == null || tableSpanArr.length <= 0 || !LeadingMarginUtils.selfStart(i, charSequence, tableSpanArr[0])) {
                z2 = false;
            } else {
                this.rect.set((int) f2, i3, this.width, i3 + tableBorderWidth);
                canvas.drawRect(this.rect, this.paint);
                z2 = true;
            }
            this.rect.set((int) f2, i5 - tableBorderWidth, this.width, i5);
            canvas.drawRect(this.rect, this.paint);
            z = z2;
        } else {
            i7 = i11;
            z = false;
        }
        int i12 = tableBorderWidth / 2;
        int i13 = z ? tableBorderWidth : 0;
        int i14 = i10 - tableBorderWidth;
        int i15 = 0;
        int i16 = 0;
        while (i15 < size) {
            Layout layout = this.layouts.get(i15);
            save = canvas.save();
            try {
                canvas.translate((i15 * cellWidth) + f2, i3);
                if (z3) {
                    if (i15 == 0) {
                        this.rect.set(0, i13, tableBorderWidth, i14);
                    } else {
                        this.rect.set(-i12, i13, i12, i14);
                    }
                    canvas.drawRect(this.rect, this.paint);
                    if (i15 == size - 1) {
                        i8 = i12;
                        this.rect.set((cellWidth - tableBorderWidth) - i9, i13, cellWidth - i9, i14);
                        canvas.drawRect(this.rect, this.paint);
                        int i17 = i6;
                        canvas.translate(i17, i17 + i7);
                        layout.draw(canvas);
                        if (layout.getHeight() <= i16) {
                            i16 = layout.getHeight();
                        }
                        canvas.restoreToCount(save);
                        i15++;
                        f2 = f;
                        i6 = i17;
                        i12 = i8;
                    }
                }
                i8 = i12;
                int i172 = i6;
                canvas.translate(i172, i172 + i7);
                layout.draw(canvas);
                if (layout.getHeight() <= i16) {
                }
                canvas.restoreToCount(save);
                i15++;
                f2 = f;
                i6 = i172;
                i12 = i8;
            } finally {
            }
        }
        if (this.height != i16) {
            invalidateSelf();
        }
    }

    private boolean recreateLayouts(int i) {
        return this.width != i;
    }

    private void makeNewLayouts() {
        this.textPaint.setFakeBoldText(this.header);
        int size = this.cells.size();
        int cellWidth = cellWidth(size) - (this.theme.tableCellPadding() * 2);
        this.layouts.clear();
        int size2 = this.cells.size();
        for (int i = 0; i < size2; i++) {
            makeLayout(i, cellWidth, this.cells.get(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(final int i, final int i2, final Cell cell) {
        Spannable spannableString;
        Runnable runnable = new Runnable() { // from class: io.noties.markwon.ext.tables.TableRowSpan.1
            @Override // java.lang.Runnable
            public void run() {
                if (TableRowSpan.this.getInvalidator() != null) {
                    TableRowSpan.this.layouts.remove(i);
                    TableRowSpan.this.makeLayout(i, i2, cell);
                    TableRowSpan.this.invalidateSelf();
                }
            }
        };
        CharSequence charSequence = cell.text;
        if (charSequence instanceof Spannable) {
            spannableString = (Spannable) charSequence;
        } else {
            spannableString = new SpannableString(charSequence);
        }
        StaticLayout staticLayout = new StaticLayout(spannableString, this.textPaint, i2, AlignmentKt.layoutAlignment(cell.alignment), 1.0f, 0.0f, false);
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
                drawable.setCallback2(new CallbackAdapter() { // from class: io.noties.markwon.ext.tables.TableRowSpan.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // io.noties.markwon.ext.tables.TableRowSpan.CallbackAdapter, android.graphics.drawable.Drawable.Callback
                    public void invalidateDrawable(Drawable drawable2) {
                        runnable.run();
                    }
                });
            }
        }
    }

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <Span> Span[] findSpanInTable(int i, int i2, Class<Span> cls) {
        int size = this.layouts.size();
        int cellWidth = i / cellWidth(size);
        if (cellWidth >= size) {
            return null;
        }
        Layout layout = this.layouts.get(cellWidth);
        int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(i2), i % cellWidth(this.layouts.size()));
        return (Span[]) ((Spanned) layout.getText()).getSpans(offsetForHorizontal, offsetForHorizontal, cls);
    }

    protected int cellWidth(int i) {
        return (int) (((this.width * 1.0f) / i) + 0.5f);
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
