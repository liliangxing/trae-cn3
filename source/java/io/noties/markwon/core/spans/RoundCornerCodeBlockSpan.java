package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.GradientDrawable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.ReplacementSpan;
import android.text.style.UpdateAppearance;
import android.text.style.UpdateLayout;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.StatusSpan;
import io.noties.markwon.core.CodeBlockTheme;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: RoundCornerCodeBlockSpan.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0012\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0002JR\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\u0006\u00101\u001a\u000202H\u0016Jn\u00103\u001a\u00020\"2\u0006\u0010&\u001a\u00020'2\b\u00101\u001a\u0004\u0018\u0001022\u0006\u0010,\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u0010.\u001a\u00020\n2\u0006\u00105\u001a\u00020\n2\u0006\u00100\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00132\b\u00107\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u00108\u001a\u0004\u0018\u00010\u001b2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002J\u0010\u00109\u001a\u00020\n2\u0006\u00106\u001a\u00020\u0013H\u0016J4\u0010:\u001a\u00020\n2\u0006\u00101\u001a\u0002022\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n2\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J \u0010=\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0002J \u0010>\u001a\u00020\u001b2\u0006\u0010?\u001a\u00020)2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0002J,\u0010B\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010C2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0016J<\u0010D\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010C2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\nH\u0016J,\u0010I\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010C2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0016J\u0012\u0010J\u001a\u00020\"2\b\u0010K\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010L\u001a\u00020\"2\u0006\u00101\u001a\u00020\u001dH\u0016R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lio/noties/markwon/core/spans/RoundCornerCodeBlockSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/StatusSpan;", "Landroid/text/SpanWatcher;", "theme", "Lio/noties/markwon/core/CodeBlockTheme;", "scrollBarTheme", "Lio/noties/markwon/scrollable/ScrollBarTheme;", "startIndex", "", "endIndex", "scrollable", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "(Lio/noties/markwon/core/CodeBlockTheme;Lio/noties/markwon/scrollable/ScrollBarTheme;IILio/noties/markwon/scrollable/HorizontalScrollable;)V", "bgDrawable", "Landroid/graphics/drawable/GradientDrawable;", "contentMaxWidth", "generating", "", "getGenerating", "()Z", "setGenerating", "(Z)V", "layouts", "Ljava/util/TreeMap;", "Landroid/graphics/Point;", "Landroid/text/Layout;", "paint", "Landroid/text/TextPaint;", "reLayout", "scrollBar", "strokeDrawable", "checkLayout", "", "what", "", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "p", "Landroid/graphics/Paint;", "drawLeadingMargin", "dir", "baseline", "first", "l", "findLayout", "getLeadingMargin", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "makeNewLayout", "newLayout", "content", AnimationConstant.PROP_STR_WIDTH, "maxLine", "onSpanAdded", "Landroid/text/Spannable;", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "updateDrawState", "ds", "updateMeasureState", "markwon-core_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class RoundCornerCodeBlockSpan extends ReplacementSpan implements LeadingMarginSpan, StatusSpan, SpanWatcher {
    private final GradientDrawable bgDrawable;
    private final int contentMaxWidth;
    private final int endIndex;
    private boolean generating;
    private final TreeMap<Point, Layout> layouts;
    private final TextPaint paint;
    private boolean reLayout;
    private final GradientDrawable scrollBar;
    private final ScrollBarTheme scrollBarTheme;
    private final HorizontalScrollable scrollable;
    private final int startIndex;
    private final GradientDrawable strokeDrawable;
    private final CodeBlockTheme theme;

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return 0;
    }

    public RoundCornerCodeBlockSpan(CodeBlockTheme codeBlockTheme, ScrollBarTheme scrollBarTheme, int i, int i2, HorizontalScrollable horizontalScrollable) {
        Intrinsics.checkParameterIsNotNull(codeBlockTheme, "theme");
        Intrinsics.checkParameterIsNotNull(scrollBarTheme, "scrollBarTheme");
        this.theme = codeBlockTheme;
        this.scrollBarTheme = scrollBarTheme;
        this.startIndex = i;
        this.endIndex = i2;
        this.scrollable = horizontalScrollable;
        TextPaint textPaint = new TextPaint();
        textPaint.setTypeface(codeBlockTheme.getCodeTypeface());
        textPaint.setTextSize(codeBlockTheme.getCodeBlockTextSize());
        this.paint = textPaint;
        this.contentMaxWidth = MathKt.roundToInt(codeBlockTheme.getCodeBlockWidth() - (codeBlockTheme.getCodeBlockHPadding() * 2));
        this.layouts = new TreeMap<>(new Comparator<K>() { // from class: io.noties.markwon.core.spans.RoundCornerCodeBlockSpan$layouts$1
            @Override // java.util.Comparator
            public final int compare(Point point, Point point2) {
                int i3;
                int i4;
                if (point.x == point2.x) {
                    i3 = point.y;
                    i4 = point2.y;
                } else {
                    i3 = point.x;
                    i4 = point2.x;
                }
                return i3 - i4;
            }
        });
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(codeBlockTheme.getCodeBlockBgColor());
        this.bgDrawable = gradientDrawable;
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(codeBlockTheme.getBorderColor());
        this.strokeDrawable = gradientDrawable2;
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(scrollBarTheme.getScrollBarColor());
        gradientDrawable3.setBounds(0, 0, scrollBarTheme.getScrollBarWidth(), scrollBarTheme.getScrollBarHeight());
        gradientDrawable3.setCornerRadius(scrollBarTheme.getScrollBarHeight() * 0.5f);
        this.scrollBar = gradientDrawable3;
    }

    @Override // io.noties.markwon.StatusSpan
    public boolean getGenerating() {
        return this.generating;
    }

    @Override // io.noties.markwon.StatusSpan
    public void setGenerating(boolean z) {
        this.generating = z;
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        if (ds != null) {
            this.paint.set(ds);
        }
        this.paint.setTypeface(this.theme.getCodeTypeface());
        this.paint.setTextSize(this.theme.getCodeBlockTextSize());
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        Intrinsics.checkParameterIsNotNull(p, "p");
        this.paint.set(p);
        this.paint.setTypeface(this.theme.getCodeTypeface());
        this.paint.setTextSize(this.theme.getCodeBlockTextSize());
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint p, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        float codeBlockVPadding;
        Intrinsics.checkParameterIsNotNull(p, "p");
        if (text == null) {
            return 0;
        }
        Layout makeNewLayout = makeNewLayout(text, start, end);
        this.layouts.put(new Point(start, end), makeNewLayout);
        HorizontalScrollable horizontalScrollable = this.scrollable;
        if (horizontalScrollable != null) {
            horizontalScrollable.setMaxScroll(Math.max(horizontalScrollable.getMaxScroll(), makeNewLayout.getLineWidth(0) - this.contentMaxWidth));
        }
        if (fm != null) {
            boolean z = start == this.startIndex;
            boolean z2 = end == this.endIndex;
            if (z2 && this.theme.getScrollable()) {
                codeBlockVPadding = Math.max(this.theme.getCodeBlockVPadding(), this.scrollBarTheme.getScrollBarHeight() + this.scrollBarTheme.getScrollBarPadding());
            } else {
                codeBlockVPadding = this.theme.getCodeBlockVPadding();
            }
            fm.ascent = -makeNewLayout.getHeight();
            if (z) {
                fm.ascent -= MathKt.roundToInt(codeBlockVPadding);
            }
            if (z2) {
                fm.ascent -= MathKt.roundToInt(codeBlockVPadding);
            }
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
            this.reLayout = false;
        }
        if (this.scrollable != null) {
            return Math.min(this.theme.getCodeBlockWidth(), MathKt.roundToInt(this.theme.getCodeBlockHPadding() + makeNewLayout.getLineWidth(0)));
        }
        return this.theme.getCodeBlockWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint p) {
        Layout findLayout;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        Intrinsics.checkParameterIsNotNull(p, "p");
        if (text != null) {
            if (this.reLayout) {
                findLayout = makeNewLayout(text, start, end);
                this.layouts.put(new Point(start, end), findLayout);
            } else {
                findLayout = findLayout(start, end);
            }
            boolean z = start == this.startIndex;
            int save = canvas.save();
            try {
                float codeBlockHPadding = this.theme.getCodeBlockHPadding();
                HorizontalScrollable horizontalScrollable = this.scrollable;
                canvas.translate(codeBlockHPadding + (horizontalScrollable != null ? horizontalScrollable.getScrollX() : 0.0f), z ? this.theme.getCodeBlockVPadding() + top : top);
                if (findLayout != null) {
                    findLayout.draw(canvas);
                }
            } finally {
                canvas.restoreToCount(save);
            }
        }
    }

    private final Layout findLayout(int start, int end) {
        Object obj;
        Layout layout = this.layouts.get(new Point(start, end));
        if (layout != null) {
            return layout;
        }
        Set<Map.Entry<Point, Layout>> entrySet = this.layouts.entrySet();
        Intrinsics.checkExpressionValueIsNotNull(entrySet, "layouts.entries");
        Iterator<T> it = entrySet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map.Entry entry = (Map.Entry) obj;
            if (((Point) entry.getKey()).x == start && ((Point) entry.getKey()).y >= end) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) obj;
        if (entry2 != null) {
            return (Layout) entry2.getValue();
        }
        return null;
    }

    private final Layout makeNewLayout(CharSequence text, int start, int end) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text, start, end);
        spannableStringBuilder.removeSpan(this);
        CharSequence removeSuffix = StringsKt.removeSuffix(spannableStringBuilder, "\n");
        if (this.theme.getScrollable()) {
            return newLayout(removeSuffix, Integer.MAX_VALUE, 1);
        }
        return newLayout(removeSuffix, this.contentMaxWidth, Integer.MAX_VALUE);
    }

    private final Layout newLayout(CharSequence content, int width, int maxLine) {
        StaticLayout build = StaticLayout.Builder.obtain(content, 0, content.length(), this.paint, width).setIncludePad(false).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setMaxLines(maxLine).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "StaticLayout.Builder\n   …\n                .build()");
        return build;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout l) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        boolean z = start == this.startIndex;
        boolean z2 = end == this.endIndex - 1;
        int save = canvas.save();
        try {
            canvas.translate(0.0f, top);
            float codeBlockRadius = z ? this.theme.getCodeBlockRadius() : 0.0f;
            float codeBlockRadius2 = z2 ? this.theme.getCodeBlockRadius() : 0.0f;
            int i = bottom - top;
            this.strokeDrawable.setBounds(0, 0, this.theme.getCodeBlockWidth(), i);
            this.strokeDrawable.setCornerRadii(new float[]{codeBlockRadius, codeBlockRadius, codeBlockRadius, codeBlockRadius, codeBlockRadius2, codeBlockRadius2, codeBlockRadius2, codeBlockRadius2});
            this.strokeDrawable.draw(canvas);
            canvas.translate(this.theme.getBorderWidth(), z ? this.theme.getBorderWidth() : 0.0f);
            this.bgDrawable.setBounds(0, 0, MathKt.roundToInt(this.theme.getCodeBlockWidth() - (2 * this.theme.getBorderWidth())), (i - (z ? MathKt.roundToInt(this.theme.getBorderWidth()) : 0)) - (z2 ? MathKt.roundToInt(this.theme.getBorderWidth()) : 0));
            this.bgDrawable.setCornerRadii(new float[]{codeBlockRadius, codeBlockRadius, codeBlockRadius, codeBlockRadius, codeBlockRadius2, codeBlockRadius2, codeBlockRadius2, codeBlockRadius2});
            this.bgDrawable.draw(canvas);
            if (!z2 || this.scrollable == null || getGenerating()) {
                return;
            }
            save = canvas.save();
            try {
                canvas.translate(((-this.scrollable.getScrollX()) / this.scrollable.getMaxScroll()) * (this.theme.getCodeBlockWidth() - this.scrollBarTheme.getScrollBarWidth()), (bottom - this.scrollBarTheme.getScrollBarHeight()) - this.scrollBarTheme.getScrollBarPadding());
                this.scrollBar.draw(canvas);
            } finally {
            }
        } finally {
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
