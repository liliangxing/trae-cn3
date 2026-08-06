package org.commonmark.node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class Emphasis extends Node implements Delimited {
    private String delimiter;

    public Emphasis() {
    }

    public Emphasis(String str) {
        this.delimiter = str;
    }

    public void setDelimiter(String str) {
        this.delimiter = str;
    }

    @Override // org.commonmark.node.Delimited
    public String getOpeningDelimiter() {
        return this.delimiter;
    }

    @Override // org.commonmark.node.Delimited
    public String getClosingDelimiter() {
        return this.delimiter;
    }

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
