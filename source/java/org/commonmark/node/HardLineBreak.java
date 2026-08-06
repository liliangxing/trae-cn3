package org.commonmark.node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class HardLineBreak extends Node {
    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
