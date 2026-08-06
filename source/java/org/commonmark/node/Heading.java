package org.commonmark.node;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class Heading extends Block {
    private int level;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }
}
