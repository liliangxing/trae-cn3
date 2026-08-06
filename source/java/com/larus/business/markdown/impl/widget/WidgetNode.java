package com.larus.business.markdown.impl.widget;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Node;
import org.commonmark.node.Visitor;

/* compiled from: WidgetNode.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/larus/business/markdown/impl/widget/WidgetNode;", "Lorg/commonmark/node/Node;", "()V", "nodeList", "", "getNodeList", "()Ljava/util/List;", "setNodeList", "(Ljava/util/List;)V", "accept", "", "visitor", "Lorg/commonmark/node/Visitor;", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class WidgetNode extends Node {
    private List<Node> nodeList = new ArrayList();

    public void accept(Visitor visitor) {
        Node node = ((Node) this).firstChild;
    }

    public final List<Node> getNodeList() {
        return this.nodeList;
    }

    public final void setNodeList(List<Node> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.nodeList = list;
    }
}
