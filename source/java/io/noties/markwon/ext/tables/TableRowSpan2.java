package io.noties.markwon.ext.tables;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.LeadingMarginSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.lynx.tasm.behavior.PropsConstants;
import io.noties.markwon.StatusSpan;
import io.noties.markwon.core.spans.TextLayoutSpan;
import io.noties.markwon.custom.TypingFreeSpan;
import io.noties.markwon.ext.tables.TablePlugin2;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TableRowSpan2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B3\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J \u00100\u001a\u00020-\"\b\b\u0000\u00101*\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016JT\u00104\u001a\u00020-2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\b\b\u0001\u00109\u001a\u00020$2\b\b\u0001\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u001dH\u0016J(\u0010A\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010\n\"\b\b\u0000\u00101*\u00020/2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016J=\u0010B\u001a\n\u0012\u0004\u0012\u0002H1\u0018\u00010C\"\b\b\u0000\u00101*\u00020/2\u0006\u0010;\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\f\u00102\u001a\b\u0012\u0004\u0012\u0002H103H\u0016¢\u0006\u0002\u0010DJ(\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$H\u0002J6\u0010K\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u00107\u001a\u0002082\b\b\u0001\u00109\u001a\u00020$2\b\b\u0001\u0010:\u001a\u00020$2\b\u0010L\u001a\u0004\u0018\u00010MH\u0016J(\u0010N\u001a\u00020-2\u0006\u0010I\u001a\u00020$2\u0006\u00107\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010J\u001a\u00020$H\u0002J \u0010O\u001a\u00020-2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0002J \u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020TH\u0002J,\u0010U\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J<\u0010W\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010X\u001a\u00020$2\u0006\u0010Y\u001a\u00020$2\u0006\u0010Z\u001a\u00020$2\u0006\u0010[\u001a\u00020$H\u0016J,\u0010\\\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010V2\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020$H\u0016J\u0010\u0010]\u001a\u00020-2\u0006\u0010^\u001a\u00020VH\u0002J>\u0010_\u001a\u00020-\"\b\b\u0000\u0010`*\u00020/\"\b\b\u0001\u0010a*\u00020/2\f\u0010b\u001a\b\u0012\u0004\u0012\u0002H`032\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u0002H`\u0012\u0004\u0012\u0002Ha0dH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\u00020$8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010'R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lio/noties/markwon/ext/tables/TableRowSpan2;", "Lio/noties/markwon/ext/tables/AbsTableRowSpan;", "Lio/noties/markwon/StatusSpan;", "Landroid/text/SpanWatcher;", "Lio/noties/markwon/custom/TypingFreeSpan;", "tableTheme", "Lio/noties/markwon/ext/tables/TableTheme2;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "wholeTable", "", "Lio/noties/markwon/ext/tables/TablePlugin2$Row;", "row", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "(Lio/noties/markwon/ext/tables/TableTheme2;Lio/noties/markwon/scrollable/ScrollBarTheme;Ljava/util/List;Lio/noties/markwon/ext/tables/TablePlugin2$Row;Lio/noties/markwon/scrollable/HorizontalScrollable;)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "generating", "", "getGenerating", "()Z", "setGenerating", "(Z)V", "layouts", "Ljava/util/ArrayList;", "Landroid/text/Layout;", "Lkotlin/collections/ArrayList;", "paint", "Landroid/graphics/Paint;", "reLayout", "rect", "Landroid/graphics/Rect;", "scrollBar", "shaderPaint", "startMargin", "", "tableContentWidth", "getTableContentWidth", "()I", "tableWidth", "getTableWidth", "textPaint", "Landroid/text/TextPaint;", "checkLayout", "", "what", "", "clearSpansInTable", "Span", "span", "Ljava/lang/Class;", "draw", "canvas", "Landroid/graphics/Canvas;", PropsConstants.TEXT, "", "start", "end", "x", "", PropsConstants.HIT_SLOP_TOP, "y", PropsConstants.HIT_SLOP_BOTTOM, "p", "findSpanInRow", "findSpanInTable", "", "(IILjava/lang/Class;)[Ljava/lang/Object;", "getCellWidth", "cell", "Lio/noties/markwon/ext/tables/TablePlugin2$Cell;", "padding", "index", "totalContentWidth", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "makeLayout", "makeNewLayouts", "newLayout", "content", "width", "alignment", "Landroid/text/Layout$Alignment;", "onSpanAdded", "Landroid/text/Spannable;", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "scheduleAsyncDrawables", "spannable", "setSpansInTable", "coveredSpan", "setSpan", "toCoveredSpan", "getToSetSpan", "Lkotlin/Function1;", "markwon-ext-tables_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TableRowSpan2 extends AbsTableRowSpan implements StatusSpan, SpanWatcher, TypingFreeSpan {
    private final GradientDrawable bgDrawable;
    private boolean generating;
    private final ArrayList<Layout> layouts;
    private final Paint paint;
    private boolean reLayout;
    private final Rect rect;
    private final TablePlugin2.Row row;
    private final GradientDrawable scrollBar;
    private final ScrollBarTheme scrollBarTheme;
    private final HorizontalScrollable scrollable;
    private final Paint shaderPaint;
    private int startMargin;
    private final TableTheme2 tableTheme;
    private final TextPaint textPaint;
    private final List<TablePlugin2.Row> wholeTable;

    public TableRowSpan2(TableTheme2 tableTheme2, ScrollBarTheme scrollBarTheme, List<TablePlugin2.Row> list, TablePlugin2.Row row, HorizontalScrollable horizontalScrollable) {
        Intrinsics.checkParameterIsNotNull(tableTheme2, "tableTheme");
        Intrinsics.checkParameterIsNotNull(scrollBarTheme, "scrollBarTheme");
        Intrinsics.checkParameterIsNotNull(list, "wholeTable");
        Intrinsics.checkParameterIsNotNull(row, "row");
        Intrinsics.checkParameterIsNotNull(horizontalScrollable, "scrollable");
        this.tableTheme = tableTheme2;
        this.scrollBarTheme = scrollBarTheme;
        this.wholeTable = list;
        this.row = row;
        this.scrollable = horizontalScrollable;
        this.layouts = new ArrayList<>(row.getCells().size());
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(tableTheme2.getTableTextSize());
        textPaint.setColor(tableTheme2.getTableTextColor());
        this.textPaint = textPaint;
        this.rect = new Rect();
        this.paint = new Paint(1);
        this.bgDrawable = new GradientDrawable();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.shaderPaint = paint;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(scrollBarTheme.getScrollBarColor());
        gradientDrawable.setBounds(0, 0, scrollBarTheme.getScrollBarWidth(), scrollBarTheme.getScrollBarHeight());
        gradientDrawable.setCornerRadius(scrollBarTheme.getScrollBarHeight() * 0.5f);
        this.scrollBar = gradientDrawable;
    }

    public boolean getGenerating() {
        return this.generating;
    }

    public void setGenerating(boolean z) {
        this.generating = z;
    }

    private final int getTableContentWidth() {
        Iterator<T> it = this.layouts.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((Layout) it.next()).getWidth() + (this.tableTheme.getTableCellHorizontalPadding() * 2);
        }
        return i;
    }

    private final int getTableWidth() {
        if (this.tableTheme.getEnableTableWidthMatchParent()) {
            return this.tableTheme.getTableWidth() - this.startMargin;
        }
        return Math.min(getTableContentWidth(), this.tableTheme.getTableWidth() - this.startMargin);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        int tableCellVerticalPadding;
        Intrinsics.checkParameterIsNotNull(paint, "paint");
        Intrinsics.checkParameterIsNotNull(text, PropsConstants.TEXT);
        makeNewLayouts(text, start, end);
        HorizontalScrollable horizontalScrollable = this.scrollable;
        horizontalScrollable.setMaxScroll(Math.max(horizontalScrollable.getMaxScroll(), getTableContentWidth() - (this.tableTheme.getTableWidth() - this.startMargin)));
        if (this.layouts.size() > 0 && fm != null) {
            if (this.row.getIndex() == CollectionsKt.getLastIndex(this.wholeTable)) {
                tableCellVerticalPadding = Math.max(this.tableTheme.getTableCellVerticalPadding(), MathKt.roundToInt(this.scrollBarTheme.getScrollBarHeight() + this.scrollBarTheme.getScrollBarPadding()));
            } else {
                tableCellVerticalPadding = this.tableTheme.getTableCellVerticalPadding();
            }
            ArrayList<Layout> arrayList = this.layouts;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(Integer.valueOf(((Layout) it.next()).getHeight()));
            }
            Integer num = (Integer) CollectionsKt.max(arrayList2);
            fm.ascent = -((num != null ? num.intValue() : 0) + this.tableTheme.getTableCellVerticalPadding() + tableCellVerticalPadding);
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
            this.reLayout = false;
        }
        return getTableWidth();
    }

    private final void scheduleAsyncDrawables(Spannable spannable) {
        AsyncDrawableSpan[] asyncDrawableSpanArr = (AsyncDrawableSpan[]) spannable.getSpans(0, spannable.length(), AsyncDrawableSpan.class);
        if (asyncDrawableSpanArr != null) {
            if (!(asyncDrawableSpanArr.length == 0)) {
                for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArr) {
                    Intrinsics.checkExpressionValueIsNotNull(asyncDrawableSpan, "span");
                    AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
                    Intrinsics.checkExpressionValueIsNotNull(drawable, "span.drawable");
                    if (!drawable.isAttached()) {
                        drawable.setCallback2(new Drawable.Callback() { // from class: io.noties.markwon.ext.tables.TableRowSpan2$scheduleAsyncDrawables$1
                            @Override // android.graphics.drawable.Drawable.Callback
                            public void scheduleDrawable(Drawable who, Runnable what, long when) {
                                Intrinsics.checkParameterIsNotNull(who, "who");
                                Intrinsics.checkParameterIsNotNull(what, "what");
                            }

                            @Override // android.graphics.drawable.Drawable.Callback
                            public void unscheduleDrawable(Drawable who, Runnable what) {
                                Intrinsics.checkParameterIsNotNull(who, "who");
                                Intrinsics.checkParameterIsNotNull(what, "what");
                            }

                            @Override // android.graphics.drawable.Drawable.Callback
                            public void invalidateDrawable(Drawable who) {
                                Intrinsics.checkParameterIsNotNull(who, "who");
                                TableRowSpan2.this.invalidateSelf();
                            }
                        });
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x013c A[Catch: all -> 0x02ad, TRY_LEAVE, TryCatch #2 {all -> 0x02ad, blocks: (B:68:0x009c, B:70:0x00ba, B:71:0x00c2, B:73:0x00d2, B:74:0x00da, B:76:0x00e2, B:79:0x00e9, B:80:0x0126, B:82:0x013c, B:85:0x00ef), top: B:67:0x009c }] */
    /* JADX WARN: Type inference failed for: r0v31, types: [io.noties.markwon.ext.tables.TableRowSpan2$draw$3] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(final Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint p) {
        int i;
        int save;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(text, PropsConstants.TEXT);
        Intrinsics.checkParameterIsNotNull(p, "p");
        if (this.reLayout) {
            makeNewLayouts(text, start, end);
        }
        Paint paint = this.paint;
        if (this.row.isHeader()) {
            i = this.tableTheme.tableHeaderRowBackgroundColor;
        } else if (this.row.getIndex() % 2 == 1) {
            i = this.tableTheme.tableOddRowBackgroundColor;
        } else {
            i = this.tableTheme.tableEvenRowBackgroundColor;
        }
        paint.setColor(i);
        this.paint.setStyle(Paint.Style.FILL);
        int tableBorderWidth = this.tableTheme.tableBorderWidth(this.paint);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = this.tableTheme.getTopRoundCornerRadius();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.element = this.tableTheme.getBottomRoundCornerRadius();
        ForegroundProvider foregroundProvider = this.tableTheme.getForegroundProvider();
        Drawable drawable = foregroundProvider != null ? foregroundProvider.getDrawable(text, start, end) : null;
        if (this.paint.getColor() != 0 || this.tableTheme.tableBorderColor != 0 || drawable != null) {
            save = canvas.save();
            try {
                this.bgDrawable.setStroke(tableBorderWidth, this.tableTheme.tableBorderColor);
                int i2 = (bottom - top) + tableBorderWidth;
                this.bgDrawable.setBounds(0, 0, getTableWidth(), i2);
                floatRef.element = this.row.getIndex() == 0 ? this.tableTheme.getTopRoundCornerRadius() : 0.0f;
                floatRef2.element = this.row.getIndex() == CollectionsKt.getLastIndex(this.wholeTable) ? this.tableTheme.getBottomRoundCornerRadius() : 0.0f;
                if (floatRef.element == 0.0f && floatRef2.element == 0.0f) {
                    this.bgDrawable.setCornerRadius(0.0f);
                    this.bgDrawable.setColor(this.paint.getColor());
                    canvas.translate(x, top);
                    this.bgDrawable.draw(canvas);
                    if (drawable != null) {
                        drawable.setBounds(0, 0, getTableWidth(), i2);
                        drawable.draw(canvas);
                    }
                }
                this.bgDrawable.setCornerRadii(new float[]{floatRef.element, floatRef.element, floatRef.element, floatRef.element, floatRef2.element, floatRef2.element, floatRef2.element, floatRef2.element});
                this.bgDrawable.setColor(this.paint.getColor());
                canvas.translate(x, top);
                this.bgDrawable.draw(canvas);
                if (drawable != null) {
                }
            } finally {
            }
        }
        this.paint.set(p);
        this.tableTheme.applyTableBorderStyle(this.paint);
        int i3 = tableBorderWidth / 2;
        int i4 = bottom - top;
        Iterator it = this.layouts.iterator();
        int i5 = 0;
        int i6 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            int i7 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Layout layout = (Layout) next;
            save = canvas.save();
            Iterator it2 = it;
            int i8 = (int) x;
            try {
                canvas.clipRect(i8, top, i8 + getTableWidth(), bottom);
                canvas.translate(i6 + x + this.scrollable.getScrollX(), top);
                i6 += layout.getWidth() + (this.tableTheme.getTableCellHorizontalPadding() * 2);
                if (tableBorderWidth > 0 && i5 != 0) {
                    this.rect.set(-i3, 0, i3, i4);
                    canvas.drawRect(this.rect, this.paint);
                }
                canvas.translate(this.tableTheme.getTableCellHorizontalPadding(), this.tableTheme.getTableCellVerticalPadding() + tableBorderWidth);
                layout.draw(canvas);
                canvas.restoreToCount(save);
                it = it2;
                i5 = i7;
            } finally {
            }
        }
        if (this.scrollable.isScrollable() && this.tableTheme.getShaderColor() != 0 && this.tableTheme.getBottomRoundCornerRadius() != 0.0f) {
            ?? r0 = new Function1<Boolean, Unit>() { // from class: io.noties.markwon.ext.tables.TableRowSpan2$draw$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Boolean) obj).booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    GradientDrawable gradientDrawable;
                    TableTheme2 tableTheme2;
                    float bottomRoundCornerRadius;
                    GradientDrawable gradientDrawable2;
                    GradientDrawable gradientDrawable3;
                    float f;
                    GradientDrawable gradientDrawable4;
                    Paint paint2;
                    TableTheme2 tableTheme22;
                    Paint paint3;
                    GradientDrawable gradientDrawable5;
                    TableTheme2 tableTheme23;
                    GradientDrawable gradientDrawable6;
                    if (z) {
                        gradientDrawable6 = TableRowSpan2.this.bgDrawable;
                        bottomRoundCornerRadius = gradientDrawable6.getBounds().left;
                    } else {
                        gradientDrawable = TableRowSpan2.this.bgDrawable;
                        float f2 = gradientDrawable.getBounds().right;
                        tableTheme2 = TableRowSpan2.this.tableTheme;
                        bottomRoundCornerRadius = f2 - tableTheme2.getBottomRoundCornerRadius();
                    }
                    gradientDrawable2 = TableRowSpan2.this.bgDrawable;
                    float f3 = gradientDrawable2.getBounds().top;
                    if (z) {
                        gradientDrawable5 = TableRowSpan2.this.bgDrawable;
                        float f4 = gradientDrawable5.getBounds().left;
                        tableTheme23 = TableRowSpan2.this.tableTheme;
                        f = f4 + tableTheme23.getBottomRoundCornerRadius();
                    } else {
                        gradientDrawable3 = TableRowSpan2.this.bgDrawable;
                        f = gradientDrawable3.getBounds().right;
                    }
                    gradientDrawable4 = TableRowSpan2.this.bgDrawable;
                    RectF rectF = new RectF(bottomRoundCornerRadius, f3, f, gradientDrawable4.getBounds().bottom);
                    paint2 = TableRowSpan2.this.shaderPaint;
                    float f5 = z ? rectF.left : rectF.right;
                    float f6 = z ? rectF.right : rectF.left;
                    tableTheme22 = TableRowSpan2.this.tableTheme;
                    paint2.setShader(new LinearGradient(f5, 0.0f, f6, 0.0f, new int[]{tableTheme22.getShaderColor(), 0}, (float[]) null, Shader.TileMode.CLAMP));
                    Path path = new Path();
                    float[] fArr = new float[8];
                    fArr[0] = z ? floatRef.element : 0.0f;
                    fArr[1] = z ? floatRef.element : 0.0f;
                    fArr[2] = z ? 0.0f : floatRef.element;
                    fArr[3] = z ? 0.0f : floatRef.element;
                    fArr[4] = z ? 0.0f : floatRef2.element;
                    fArr[5] = z ? 0.0f : floatRef2.element;
                    fArr[6] = z ? floatRef2.element : 0.0f;
                    fArr[7] = z ? floatRef2.element : 0.0f;
                    path.addRoundRect(rectF, fArr, Path.Direction.CW);
                    Canvas canvas2 = canvas;
                    paint3 = TableRowSpan2.this.shaderPaint;
                    canvas2.drawPath(path, paint3);
                }
            };
            save = canvas.save();
            canvas.translate(x, top);
            if (Math.abs(this.scrollable.getScrollX()) > 0.0f) {
                r0.invoke(true);
            }
            if (Math.abs(this.scrollable.getScrollX()) < this.scrollable.getMaxScroll()) {
                r0.invoke(false);
            }
        }
        if (this.row.getIndex() != CollectionsKt.getLastIndex(this.wholeTable) || getGenerating()) {
            return;
        }
        save = canvas.save();
        try {
            canvas.translate(((-this.scrollable.getScrollX()) / this.scrollable.getMaxScroll()) * ((this.tableTheme.getTableWidth() - this.startMargin) - this.scrollBarTheme.getScrollBarWidth()), (bottom - this.scrollBarTheme.getScrollBarHeight()) - this.scrollBarTheme.getScrollBarPadding());
            if (this.scrollBar.getBounds().left == 0) {
                this.scrollBar.getBounds().left += this.startMargin;
                this.scrollBar.getBounds().right += this.startMargin;
            }
            this.scrollBar.draw(canvas);
        } finally {
        }
    }

    private final void makeNewLayouts(CharSequence text, int start, int end) {
        List<TablePlugin2.Cell> cells;
        TablePlugin2.Cell cell;
        int i = 0;
        this.startMargin = 0;
        SpannableString spannableString = (SpannableString) (!(text instanceof SpannableString) ? null : text);
        if (spannableString != null) {
            Object[] spans = spannableString.getSpans(start, end, LeadingMarginSpan.class);
            Intrinsics.checkExpressionValueIsNotNull(spans, "sb.getSpans(start, end, …ngMarginSpan::class.java)");
            int i2 = 0;
            for (Object obj : spans) {
                i2 += ((LeadingMarginSpan) obj).getLeadingMargin(false);
            }
            this.startMargin = i2 + 0;
        }
        this.textPaint.setFakeBoldText(this.row.isHeader());
        this.layouts.clear();
        if (this.row.getIndex() == 0 || ((cell = (TablePlugin2.Cell) CollectionsKt.firstOrNull(this.row.getCells())) != null && cell.getMaxWidth() == 0.0f)) {
            TablePlugin2.Row row = (TablePlugin2.Row) CollectionsKt.firstOrNull(this.wholeTable);
            IntIterator it = RangesKt.until(0, (row == null || (cells = row.getCells()) == null) ? 0 : cells.size()).iterator();
            while (it.hasNext()) {
                int nextInt = it.nextInt();
                float f = 0.0f;
                for (TablePlugin2.Row row2 : this.wholeTable) {
                    f = Math.max(f, newLayout(row2.getCells().get(nextInt).getText(), Integer.MAX_VALUE, AlignmentKt.layoutAlignment(row2.getCells().get(nextInt).getAlignment())).getLineWidth(0));
                }
                Iterator<T> it2 = this.wholeTable.iterator();
                while (it2.hasNext()) {
                    ((TablePlugin2.Row) it2.next()).getCells().get(nextInt).setMaxWidth$markwon_ext_tables_release(f);
                }
            }
        }
        Iterator<T> it3 = this.row.getCells().iterator();
        int i3 = 0;
        while (it3.hasNext()) {
            i3 += (int) (((TablePlugin2.Cell) it3.next()).getMaxWidth() + (this.tableTheme.getTableCellHorizontalPadding() * 2));
        }
        for (Object obj2 : this.row.getCells()) {
            int i4 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            makeLayout(i, text, (TablePlugin2.Cell) obj2, i3);
            i = i4;
        }
    }

    private final void makeLayout(int index, CharSequence text, TablePlugin2.Cell cell, int totalContentWidth) {
        SpannableString spannableString = new SpannableString(cell.getText());
        if ((text instanceof Spanned) && cell.getStart() > -1 && cell.getEnd() > -1) {
            CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) text).getSpans(cell.getStart(), cell.getEnd(), CharacterStyle.class);
            Intrinsics.checkExpressionValueIsNotNull(characterStyleArr, "extraSpans");
            for (CharacterStyle characterStyle : characterStyleArr) {
                if (characterStyle != this) {
                    spannableString.setSpan(characterStyle, 0, spannableString.length(), 33);
                }
            }
        }
        int tableCellHorizontalPadding = this.tableTheme.getTableCellHorizontalPadding() * 2;
        Layout newLayout = newLayout(spannableString, getCellWidth(cell, tableCellHorizontalPadding, index, totalContentWidth) - tableCellHorizontalPadding, AlignmentKt.layoutAlignment(cell.getAlignment()));
        SpannableString spannableString2 = spannableString;
        TextLayoutSpan.applyTo(spannableString2, newLayout);
        this.layouts.add(index, newLayout);
        scheduleAsyncDrawables(spannableString2);
    }

    private final int getCellWidth(TablePlugin2.Cell cell, int padding, int index, int totalContentWidth) {
        int size = this.row.getCells().size();
        int min = Math.min(Math.max(this.tableTheme.getCellMinWidth(), ((int) cell.getMaxWidth()) + padding), this.tableTheme.getCellMaxWidth());
        if (!this.tableTheme.getEnableTableWidthMatchParent() || size <= 0) {
            return min;
        }
        return index == size + (-1) ? Math.max(getTableWidth() - getTableContentWidth(), min) : min;
    }

    private final Layout newLayout(CharSequence content, int width, Layout.Alignment alignment) {
        StaticLayout build = StaticLayout.Builder.obtain(content, 0, content.length(), this.textPaint, width).setIncludePad(false).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setMaxLines(Integer.MAX_VALUE).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "StaticLayout.Builder\n   …\n                .build()");
        return build;
    }

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <Span> Span[] findSpanInTable(int x, int y, Class<Span> span) {
        Intrinsics.checkParameterIsNotNull(span, "span");
        int tableCellVerticalPadding = y - this.tableTheme.getTableCellVerticalPadding();
        int roundToInt = x - MathKt.roundToInt(this.scrollable.getScrollX());
        int tableCellHorizontalPadding = this.tableTheme.getTableCellHorizontalPadding();
        Iterator<Layout> it = this.layouts.iterator();
        while (it.hasNext()) {
            Layout next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "layout");
            int width = next.getWidth() + tableCellHorizontalPadding;
            if (tableCellHorizontalPadding <= roundToInt && width >= roundToInt) {
                int height = next.getHeight();
                if (tableCellVerticalPadding >= 0 && height >= tableCellVerticalPadding) {
                    int offsetForHorizontal = next.getOffsetForHorizontal(next.getLineForVertical(tableCellVerticalPadding), roundToInt - tableCellHorizontalPadding);
                    CharSequence text = next.getText();
                    if (!(text instanceof Spanned)) {
                        text = null;
                    }
                    Spanned spanned = (Spanned) text;
                    if (spanned != null) {
                        return (Span[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, span);
                    }
                    return null;
                }
            }
            tableCellHorizontalPadding = (this.tableTheme.getTableCellHorizontalPadding() * 2) + width;
        }
        return null;
    }

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <Span> List<Span> findSpanInRow(Class<Span> span) {
        Intrinsics.checkParameterIsNotNull(span, "span");
        ArrayList arrayList = new ArrayList();
        List<TablePlugin2.Cell> cells = this.row.getCells();
        ArrayList arrayList2 = new ArrayList();
        for (TablePlugin2.Cell cell : cells) {
            CharSequence text = cell.getText();
            if (!(text instanceof Spanned)) {
                text = null;
            }
            Spanned spanned = (Spanned) text;
            Object[] spans = spanned != null ? spanned.getSpans(0, cell.getText().length(), span) : null;
            if (spans != null) {
                arrayList2.add(spans);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, (Object[]) it.next());
        }
        return arrayList;
    }

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <coveredSpan, setSpan> void setSpansInTable(Class<coveredSpan> toCoveredSpan, Function1<? super coveredSpan, ? extends setSpan> getToSetSpan) {
        Intrinsics.checkParameterIsNotNull(toCoveredSpan, "toCoveredSpan");
        Intrinsics.checkParameterIsNotNull(getToSetSpan, "getToSetSpan");
        for (TablePlugin2.Cell cell : this.row.getCells()) {
            int length = cell.getText().length();
            CharSequence text = cell.getText();
            if (!(text instanceof Spannable)) {
                text = null;
            }
            Spannable spannable = (Spannable) text;
            if (spannable != null) {
                Object[] spans = spannable.getSpans(0, length, toCoveredSpan);
                Intrinsics.checkExpressionValueIsNotNull(spans, "cellText.getSpans(0, length, toCoveredSpan)");
                for (Object obj : spans) {
                    Intrinsics.checkExpressionValueIsNotNull(obj, "it");
                    spannable.setSpan(getToSetSpan.invoke(obj), spannable.getSpanStart(obj), spannable.getSpanEnd(obj), 17);
                }
            }
        }
    }

    @Override // io.noties.markwon.ext.tables.AbsTableRowSpan
    public <Span> void clearSpansInTable(Class<Span> span) {
        Intrinsics.checkParameterIsNotNull(span, "span");
        Iterator<Layout> it = this.layouts.iterator();
        while (it.hasNext()) {
            Layout next = it.next();
            Intrinsics.checkExpressionValueIsNotNull(next, "layout");
            int length = next.getText().length();
            CharSequence text = next.getText();
            if (!(text instanceof Spanned)) {
                text = null;
            }
            Spanned spanned = (Spanned) text;
            if (spanned != null) {
                Object[] spans = spanned.getSpans(0, length, span);
                Intrinsics.checkExpressionValueIsNotNull(spans, "text.getSpans(0, length, span)");
                for (Object obj : spans) {
                    CharSequence text2 = next.getText();
                    if (!(text2 instanceof SpannableString)) {
                        text2 = null;
                    }
                    SpannableString spannableString = (SpannableString) text2;
                    if (spannableString != null) {
                        spannableString.removeSpan(obj);
                    }
                }
            }
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable text, Object what, int start, int end) {
        checkLayout(what);
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable text, Object what, int start, int end) {
        checkLayout(what);
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable text, Object what, int ostart, int oend, int nstart, int nend) {
        checkLayout(what);
    }

    private final void checkLayout(Object what) {
        if (!(what instanceof UpdateAppearance) || (what instanceof UpdateLayout)) {
            return;
        }
        this.reLayout = true;
    }
}
