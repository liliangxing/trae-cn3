package org.commonmark.node;

/* loaded from: classes8.dex */
public class OrderedList extends ListBlock {
    private char delimiter;
    private int originalStartNumber;
    private int startNumber;

    @Override // org.commonmark.node.Node
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getStartNumber() {
        return this.startNumber;
    }

    public void setStartNumber(int i) {
        this.startNumber = i;
    }

    public int getOriginalStartNumber() {
        return this.originalStartNumber;
    }

    public void setOriginalStartNumber(int i) {
        this.originalStartNumber = i;
    }

    public char getDelimiter() {
        return this.delimiter;
    }

    public void setDelimiter(char c) {
        this.delimiter = c;
    }
}
