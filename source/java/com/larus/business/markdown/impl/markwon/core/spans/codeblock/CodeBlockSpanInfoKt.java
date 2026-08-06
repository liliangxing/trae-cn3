package com.larus.business.markdown.impl.markwon.core.spans.codeblock;

import io.noties.markwon.Prop;
import io.noties.markwon.scrollable.HorizontalScrollable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CodeBlockSpanInfo.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"7\u0010\u0006\u001a(\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002 \u0003*\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00070\u00070\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0005\"\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\f0\f0\u0001¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0005\"\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0005¨\u0006\u0010"}, d2 = {"CODE_BLOCK_END_INDEX", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getCODE_BLOCK_END_INDEX", "()Lio/noties/markwon/Prop;", "CODE_BLOCK_LINE_NUMBER_MAP", "", "getCODE_BLOCK_LINE_NUMBER_MAP", "CODE_BLOCK_MAX_LINE", "getCODE_BLOCK_MAX_LINE", "CODE_BLOCK_SCROLLABLE", "Lio/noties/markwon/scrollable/HorizontalScrollable;", "getCODE_BLOCK_SCROLLABLE", "CODE_BLOCK_START_INDEX", "getCODE_BLOCK_START_INDEX", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class CodeBlockSpanInfoKt {
    private static final Prop<Integer> CODE_BLOCK_END_INDEX;
    private static final Prop<Map<Integer, Integer>> CODE_BLOCK_LINE_NUMBER_MAP;
    private static final Prop<Integer> CODE_BLOCK_MAX_LINE;
    private static final Prop<HorizontalScrollable> CODE_BLOCK_SCROLLABLE;
    private static final Prop<Integer> CODE_BLOCK_START_INDEX;

    static {
        Prop<Integer> of = Prop.of("code-block-start-index");
        Intrinsics.checkNotNullExpressionValue(of, "of<Int>(\"code-block-start-index\")");
        CODE_BLOCK_START_INDEX = of;
        Prop<Integer> of2 = Prop.of("code-block-end-index");
        Intrinsics.checkNotNullExpressionValue(of2, "of<Int>(\"code-block-end-index\")");
        CODE_BLOCK_END_INDEX = of2;
        Prop<HorizontalScrollable> of3 = Prop.of("code-block-scrollable");
        Intrinsics.checkNotNullExpressionValue(of3, "of<HorizontalScrollable>(\"code-block-scrollable\")");
        CODE_BLOCK_SCROLLABLE = of3;
        Prop<Integer> of4 = Prop.of("code-block-max-line");
        Intrinsics.checkNotNullExpressionValue(of4, "of<Int>(\"code-block-max-line\")");
        CODE_BLOCK_MAX_LINE = of4;
        Prop<Map<Integer, Integer>> of5 = Prop.of("code-block-line-number-map");
        Intrinsics.checkNotNullExpressionValue(of5, "of<Map<Int, Int>>(\"code-block-line-number-map\")");
        CODE_BLOCK_LINE_NUMBER_MAP = of5;
    }

    public static final Prop<Integer> getCODE_BLOCK_START_INDEX() {
        return CODE_BLOCK_START_INDEX;
    }

    public static final Prop<Integer> getCODE_BLOCK_END_INDEX() {
        return CODE_BLOCK_END_INDEX;
    }

    public static final Prop<HorizontalScrollable> getCODE_BLOCK_SCROLLABLE() {
        return CODE_BLOCK_SCROLLABLE;
    }

    public static final Prop<Integer> getCODE_BLOCK_MAX_LINE() {
        return CODE_BLOCK_MAX_LINE;
    }

    public static final Prop<Map<Integer, Integer>> getCODE_BLOCK_LINE_NUMBER_MAP() {
        return CODE_BLOCK_LINE_NUMBER_MAP;
    }
}
