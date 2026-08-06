package io.noties.prism4j;

import io.noties.prism4j.Prism4j;

/* loaded from: classes3.dex */
public class TextImpl implements Prism4j.Text {
    private final String literal;

    @Override // io.noties.prism4j.Prism4j.Node
    public final boolean isSyntax() {
        return false;
    }

    public TextImpl(String str) {
        this.literal = str;
    }

    @Override // io.noties.prism4j.Prism4j.Node
    public int textLength() {
        return this.literal.length();
    }

    @Override // io.noties.prism4j.Prism4j.Text
    public String literal() {
        return this.literal;
    }

    public String toString() {
        return "TextImpl{literal='" + this.literal + "'}";
    }
}
