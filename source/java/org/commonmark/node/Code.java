package org.commonmark.node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class Code extends Node {
    private String literal;

    public Code() {
    }

    public Code(String str) {
        this.literal = str;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getLiteral() {
        return this.literal;
    }

    public void setLiteral(String str) {
        this.literal = str;
    }
}
