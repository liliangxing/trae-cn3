package com.larus.business.markdown.impl.markwon;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MarkwonExt.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/SpannedIndex;", "", "span", "start", "", "end", "(Ljava/lang/Object;II)V", "getEnd", "()I", "getSpan", "()Ljava/lang/Object;", "getStart", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class SpannedIndex {
    private final int end;
    private final Object span;
    private final int start;

    public SpannedIndex(Object span, int i, int i2) {
        Intrinsics.checkNotNullParameter(span, "span");
        this.span = span;
        this.start = i;
        this.end = i2;
    }

    public final int getEnd() {
        return this.end;
    }

    public final Object getSpan() {
        return this.span;
    }

    public final int getStart() {
        return this.start;
    }
}
