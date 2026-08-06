package com.larus.business.markdown.impl.markwon.visitor;

import io.noties.markwon.MarkwonVisitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.SoftLineBreak;

/* compiled from: SoftLineBreakVisitor.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/visitor/SoftLineBreakVisitor;", "Lio/noties/markwon/MarkwonVisitor$NodeVisitor;", "Lorg/commonmark/node/SoftLineBreak;", "()V", "visit", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "n", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class SoftLineBreakVisitor implements MarkwonVisitor.NodeVisitor<SoftLineBreak> {
    @Override // io.noties.markwon.MarkwonVisitor.NodeVisitor
    public void visit(MarkwonVisitor visitor, SoftLineBreak n) {
        Intrinsics.checkNotNullParameter(visitor, "visitor");
        Intrinsics.checkNotNullParameter(n, "n");
        if (n.next != null) {
            visitor.forceNewLine();
        }
    }
}
