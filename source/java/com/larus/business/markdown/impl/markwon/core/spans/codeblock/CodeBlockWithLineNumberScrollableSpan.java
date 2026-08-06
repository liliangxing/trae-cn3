package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
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
import com.larus.business.markdown.api.model.ICodeBlockWithLineNumberScrollableSpan;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.lynx.tasm.animation.AnimationConstant;
import io.noties.markwon.StatusSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.scrollable.HorizontalScrollable;
import io.noties.markwon.scrollable.ScrollBarTheme;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: CodeBlockWithLineNumberScrollableSpan.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0002J\u0012\u0010.\u001a\u00020,2\b\u0010/\u001a\u0004\u0018\u000100H\u0002JR\u00101\u001a\u00020,2\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>H\u0016Jh\u0010?\u001a\u00020,2\u0006\u0010@\u001a\u0002032\u0006\u0010-\u001a\u00020>2\u0006\u00108\u001a\u00020\u000b2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000b2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u001eH\u0016J\u001a\u0010E\u001a\u0004\u0018\u00010\u001e2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J\u0010\u0010F\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020\u0013H\u0016J4\u0010G\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020>2\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J \u0010J\u001a\u00020\u001e2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0002J \u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u0002052\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010N\u001a\u00020\u000bH\u0002J,\u0010O\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J<\u0010Q\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020\u000b2\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000bH\u0016J,\u0010V\u001a\u00020,2\b\u00104\u001a\u0004\u0018\u00010P2\b\u0010/\u001a\u0004\u0018\u0001002\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000bH\u0016J\u0010\u0010W\u001a\u00020,2\u0006\u0010X\u001a\u00020 H\u0016J\u0010\u0010Y\u001a\u00020,2\u0006\u0010-\u001a\u00020 H\u0016R\u001b\u0010\r\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR\u000e\u0010#\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010\u000fR\u000e\u0010'\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockWithLineNumberScrollableSpan;", "Landroid/text/style/ReplacementSpan;", "Landroid/text/style/LeadingMarginSpan;", "Lio/noties/markwon/StatusSpan;", "Landroid/text/SpanWatcher;", "Lcom/larus/business/markdown/api/model/ICodeBlockWithLineNumberScrollableSpan;", "theme", "Lio/noties/markwon/core/MarkwonTheme;", "info", "Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;", "screenWidth", "", "(Lio/noties/markwon/core/MarkwonTheme;Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/CodeBlockSpan2Info;I)V", "codeBlockWidth", "getCodeBlockWidth", "()I", "codeBlockWidth$delegate", "Lkotlin/Lazy;", "enableScroll", "", "getEnableScroll", "()Z", "enableScroll$delegate", "generating", "getGenerating", "setGenerating", "(Z)V", "layouts", "Ljava/util/TreeMap;", "Landroid/graphics/Point;", "Landroid/text/Layout;", "lineNumberPaint", "Landroid/text/TextPaint;", "lineNumberTotalWidth", "getLineNumberTotalWidth", "lineNumberWidth", "marginStart", "getMarginStart", "marginStart$delegate", "reLayout", "scrollBar", "Landroid/graphics/drawable/GradientDrawable;", "textPaint", "apply", "", "p", "checkLayout", "what", "", WebViewContainer.EVENT_draw, "canvas", "Landroid/graphics/Canvas;", "text", "", "start", "end", "x", "", AnimationConstant.PROP_STR_TOP, "y", AnimationConstant.PROP_STR_BOTTOM, "paint", "Landroid/graphics/Paint;", "drawLeadingMargin", "c", "dir", "baseline", "first", "layout", "findLayout", "getLeadingMargin", "getSize", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "makeNewLayout", "newLayout", "content", AnimationConstant.PROP_STR_WIDTH, "maxLine", "onSpanAdded", "Landroid/text/Spannable;", "onSpanChanged", "ostart", "oend", "nstart", "nend", "onSpanRemoved", "updateDrawState", "ds", "updateMeasureState", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class CodeBlockWithLineNumberScrollableSpan extends ReplacementSpan implements LeadingMarginSpan, StatusSpan, SpanWatcher, ICodeBlockWithLineNumberScrollableSpan {

    /* renamed from: codeBlockWidth$delegate, reason: from kotlin metadata */
    private final Lazy codeBlockWidth;

    /* renamed from: enableScroll$delegate, reason: from kotlin metadata */
    private final Lazy enableScroll;
    private boolean generating;
    private final CodeBlockSpan2Info info;
    private final TreeMap<Point, Layout> layouts;
    private final TextPaint lineNumberPaint;
    private final int lineNumberTotalWidth;
    private final int lineNumberWidth;

    /* renamed from: marginStart$delegate, reason: from kotlin metadata */
    private final Lazy marginStart;
    private boolean reLayout;
    private final int screenWidth;
    private final GradientDrawable scrollBar;
    private final TextPaint textPaint;
    private final MarkwonTheme theme;

    public CodeBlockWithLineNumberScrollableSpan(MarkwonTheme markwonTheme, CodeBlockSpan2Info codeBlockSpan2Info, int i) {
        Intrinsics.checkNotNullParameter(markwonTheme, "theme");
        Intrinsics.checkNotNullParameter(codeBlockSpan2Info, "info");
        this.theme = markwonTheme;
        this.info = codeBlockSpan2Info;
        this.screenWidth = i;
        GradientDrawable gradientDrawable = new GradientDrawable();
        CodeBlockScrollableInfo scrollableInfo = codeBlockSpan2Info.getScrollableInfo();
        ScrollBarTheme scrollBarTheme = scrollableInfo != null ? scrollableInfo.getScrollBarTheme() : null;
        if (scrollBarTheme != null) {
            gradientDrawable.setColor(scrollBarTheme.getScrollBarColor());
            gradientDrawable.setBounds(0, 0, scrollBarTheme.getScrollBarWidth(), scrollBarTheme.getScrollBarHeight());
            gradientDrawable.setCornerRadius(scrollBarTheme.getScrollBarHeight() * 0.5f);
        }
        this.scrollBar = gradientDrawable;
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(MarkdownDimensExtKt.getDp_14());
        CodeBlockScrollableInfo scrollableInfo2 = codeBlockSpan2Info.getScrollableInfo();
        if (scrollableInfo2 != null) {
            textPaint.setColor(scrollableInfo2.getCodeTextColor());
        }
        this.textPaint = textPaint;
        TextPaint textPaint2 = new TextPaint(1);
        CodeBlockLineNumberInfo numberInfo = codeBlockSpan2Info.getNumberInfo();
        if (numberInfo != null) {
            textPaint2.setTextSize(MarkdownDimensExtKt.getDp_14());
            textPaint2.setColor(numberInfo.getLineNumberColor());
            textPaint2.setTypeface(Typeface.MONOSPACE);
            textPaint2.setTextAlign(Paint.Align.RIGHT);
        }
        this.lineNumberPaint = textPaint2;
        CodeBlockLineNumberInfo numberInfo2 = codeBlockSpan2Info.getNumberInfo();
        this.lineNumberWidth = (int) textPaint2.measureText(String.valueOf(numberInfo2 != null ? Integer.valueOf(numberInfo2.getMaxLine()) : null));
        final CodeBlockWithLineNumberScrollableSpan$layouts$1 codeBlockWithLineNumberScrollableSpan$layouts$1 = new Function2<Point, Point, Integer>() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan$layouts$1
            public final Integer invoke(Point point, Point point2) {
                int i2;
                int i3;
                if (point.x == point2.x) {
                    i2 = point.y;
                    i3 = point2.y;
                } else {
                    i2 = point.x;
                    i3 = point2.x;
                }
                return Integer.valueOf(i2 - i3);
            }
        };
        this.layouts = new TreeMap<>(new Comparator() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int layouts$lambda$4;
                layouts$lambda$4 = CodeBlockWithLineNumberScrollableSpan.layouts$lambda$4(codeBlockWithLineNumberScrollableSpan$layouts$1, obj, obj2);
                return layouts$lambda$4;
            }
        });
        this.marginStart = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan$marginStart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m2891invoke() {
                int i2;
                i2 = CodeBlockWithLineNumberScrollableSpan.this.lineNumberWidth;
                return Integer.valueOf(i2 + MarkdownDimensExtKt.getDp_16());
            }
        });
        this.codeBlockWidth = LazyKt.lazy(new Function0<Integer>() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan$codeBlockWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Integer m2889invoke() {
                int i2;
                int marginStart;
                i2 = CodeBlockWithLineNumberScrollableSpan.this.screenWidth;
                marginStart = CodeBlockWithLineNumberScrollableSpan.this.getMarginStart();
                return Integer.valueOf(i2 - marginStart);
            }
        });
        this.enableScroll = LazyKt.lazy(new Function0<Boolean>() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan$enableScroll$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Boolean m2890invoke() {
                CodeBlockSpan2Info codeBlockSpan2Info2;
                codeBlockSpan2Info2 = CodeBlockWithLineNumberScrollableSpan.this.info;
                CodeBlockScrollableInfo scrollableInfo3 = codeBlockSpan2Info2.getScrollableInfo();
                return Boolean.valueOf(scrollableInfo3 != null ? scrollableInfo3.getEnableScroll() : false);
            }
        });
        this.lineNumberTotalWidth = getMarginStart() - getLeadingMargin(false);
    }

    @Override // io.noties.markwon.StatusSpan
    public boolean getGenerating() {
        return this.generating;
    }

    @Override // io.noties.markwon.StatusSpan
    public void setGenerating(boolean z) {
        this.generating = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int layouts$lambda$4(Function2 function2, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getMarginStart() {
        return ((Number) this.marginStart.getValue()).intValue();
    }

    private final int getCodeBlockWidth() {
        return ((Number) this.codeBlockWidth.getValue()).intValue();
    }

    private final boolean getEnableScroll() {
        return ((Boolean) this.enableScroll.getValue()).booleanValue();
    }

    @Override // com.larus.business.markdown.api.model.ICodeBlockWithLineNumberScrollableSpan
    public int getLineNumberTotalWidth() {
        return this.lineNumberTotalWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (text == null) {
            return 0;
        }
        Layout makeNewLayout = makeNewLayout(text, start, end);
        this.layouts.put(new Point(start, end), makeNewLayout);
        CodeBlockScrollableInfo scrollableInfo = this.info.getScrollableInfo();
        HorizontalScrollable scrollable = scrollableInfo != null ? scrollableInfo.getScrollable() : null;
        if (scrollable != null && getEnableScroll()) {
            scrollable.setMaxScroll(Math.max(scrollable.getMaxScroll(), makeNewLayout.getLineWidth(0) - getCodeBlockWidth()));
        }
        if (fm != null) {
            Integer codeBlockEndIndex = this.info.getCodeBlockEndIndex();
            boolean z = codeBlockEndIndex != null && end == codeBlockEndIndex.intValue();
            CodeBlockScrollableInfo scrollableInfo2 = this.info.getScrollableInfo();
            ScrollBarTheme scrollBarTheme = scrollableInfo2 != null ? scrollableInfo2.getScrollBarTheme() : null;
            float scrollBarHeight = (z && scrollBarTheme != null && getEnableScroll()) ? scrollBarTheme.getScrollBarHeight() + scrollBarTheme.getScrollBarPadding() : 0.0f;
            fm.ascent = -makeNewLayout.getHeight();
            if (z) {
                fm.ascent -= MathKt.roundToInt(scrollBarHeight);
            }
            fm.descent = 0;
            fm.top = fm.ascent;
            fm.bottom = 0;
            this.reLayout = false;
        }
        if (scrollable != null && getEnableScroll()) {
            return Math.min(getCodeBlockWidth(), MathKt.roundToInt(makeNewLayout.getLineWidth(0)));
        }
        return getCodeBlockWidth();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Layout findLayout;
        HorizontalScrollable scrollable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        if (text == null) {
            return;
        }
        if (this.reLayout) {
            findLayout = makeNewLayout(text, start, end);
            this.layouts.put(new Point(start, end), findLayout);
        } else {
            findLayout = findLayout(start, end);
        }
        int save = canvas.save();
        try {
            if (getEnableScroll()) {
                canvas.clipRect((int) (x + this.lineNumberWidth), top, this.screenWidth, bottom);
            }
            CodeBlockScrollableInfo scrollableInfo = this.info.getScrollableInfo();
            canvas.translate((scrollableInfo == null || (scrollable = scrollableInfo.getScrollable()) == null) ? getMarginStart() : scrollable.getScrollX() + getMarginStart(), top);
            if (findLayout != null) {
                findLayout.draw(canvas);
            }
        } finally {
            canvas.restoreToCount(save);
        }
    }

    private final Layout findLayout(int start, int end) {
        Object obj;
        Layout layout = this.layouts.get(new Point(start, end));
        if (layout != null) {
            return layout;
        }
        Set<Map.Entry<Point, Layout>> entrySet = this.layouts.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "layouts.entries");
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
        if (getEnableScroll()) {
            CodeBlockScrollableInfo scrollableInfo = this.info.getScrollableInfo();
            if ((scrollableInfo != null ? scrollableInfo.getScrollable() : null) != null) {
                return newLayout(removeSuffix, Integer.MAX_VALUE, 1);
            }
        }
        return newLayout(removeSuffix, getCodeBlockWidth(), Integer.MAX_VALUE);
    }

    private final Layout newLayout(CharSequence content, int width, int maxLine) {
        StaticLayout build = StaticLayout.Builder.obtain(content, 0, content.length(), this.textPaint, width).setIncludePad(false).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(0.0f, 1.0f).setMaxLines(maxLine).build();
        Intrinsics.checkNotNullExpressionValue(build, "{\n            StaticLayo…       .build()\n        }");
        return build;
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean first) {
        return MarkdownDimensExtKt.getDp_3();
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas c, Paint p, int x, int dir, int top, int baseline, int bottom, CharSequence text, int start, int end, boolean first, Layout layout) {
        Map<Integer, Integer> startToLineNumber;
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(layout, "layout");
        CodeBlockLineNumberInfo numberInfo = this.info.getNumberInfo();
        Integer num = (numberInfo == null || (startToLineNumber = numberInfo.getStartToLineNumber()) == null) ? null : startToLineNumber.get(Integer.valueOf(start));
        if (num != null) {
            c.drawText(num.toString(), x + this.lineNumberWidth + getLeadingMargin(false), top + (this.lineNumberPaint.descent() - this.lineNumberPaint.ascent()), this.lineNumberPaint);
        }
        Integer codeBlockEndIndex = this.info.getCodeBlockEndIndex();
        if (codeBlockEndIndex != null && end == codeBlockEndIndex.intValue()) {
            CodeBlockScrollableInfo scrollableInfo = this.info.getScrollableInfo();
            HorizontalScrollable scrollable = scrollableInfo != null ? scrollableInfo.getScrollable() : null;
            CodeBlockScrollableInfo scrollableInfo2 = this.info.getScrollableInfo();
            ScrollBarTheme scrollBarTheme = scrollableInfo2 != null ? scrollableInfo2.getScrollBarTheme() : null;
            if (scrollable == null || getGenerating() || !getEnableScroll() || scrollBarTheme == null) {
                return;
            }
            int save = c.save();
            try {
                c.translate((((-scrollable.getScrollX()) / scrollable.getMaxScroll()) * (getCodeBlockWidth() - scrollBarTheme.getScrollBarWidth())) + getMarginStart(), (bottom - scrollBarTheme.getScrollBarHeight()) - scrollBarTheme.getScrollBarPadding());
                this.scrollBar.draw(c);
            } finally {
                c.restoreToCount(save);
            }
        }
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint p) {
        Intrinsics.checkNotNullParameter(p, "p");
        apply(p);
    }

    @Override // android.text.style.ReplacementSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Intrinsics.checkNotNullParameter(ds, "ds");
        apply(ds);
    }

    private final void apply(TextPaint p) {
        this.theme.applyCodeBlockTextStyle(p);
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
