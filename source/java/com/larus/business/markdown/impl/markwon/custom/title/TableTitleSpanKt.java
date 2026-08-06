package com.larus.business.markdown.impl.markwon.custom.title;

import io.noties.markwon.Prop;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TableTitleSpan.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\"\u001f\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"TABLE_TITLE_END_INDEX", "Lio/noties/markwon/Prop;", "", "kotlin.jvm.PlatformType", "getTABLE_TITLE_END_INDEX", "()Lio/noties/markwon/Prop;", "TABLE_TITLE_START_INDEX", "getTABLE_TITLE_START_INDEX", "markdown-impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class TableTitleSpanKt {
    private static final Prop<Integer> TABLE_TITLE_END_INDEX;
    private static final Prop<Integer> TABLE_TITLE_START_INDEX;

    static {
        Prop<Integer> of = Prop.of("table-title-start-index");
        Intrinsics.checkNotNullExpressionValue(of, "of<Int>(\"table-title-start-index\")");
        TABLE_TITLE_START_INDEX = of;
        Prop<Integer> of2 = Prop.of("table-title-end-index");
        Intrinsics.checkNotNullExpressionValue(of2, "of<Int>(\"table-title-end-index\")");
        TABLE_TITLE_END_INDEX = of2;
    }

    public static final Prop<Integer> getTABLE_TITLE_START_INDEX() {
        return TABLE_TITLE_START_INDEX;
    }

    public static final Prop<Integer> getTABLE_TITLE_END_INDEX() {
        return TABLE_TITLE_END_INDEX;
    }
}
