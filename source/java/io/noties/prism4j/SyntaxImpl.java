package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class SyntaxImpl implements Prism4j.Syntax {
    private final String alias;
    private final List<? extends Prism4j.Node> children;
    private final boolean greedy;
    private final String matchedString;
    private final boolean tokenized;
    private final String type;

    @Override // io.noties.prism4j.Prism4j.Node
    public final boolean isSyntax() {
        return true;
    }

    public SyntaxImpl(String str, List<? extends Prism4j.Node> list, String str2, String str3, boolean z, boolean z2) {
        this.type = str;
        this.children = list;
        this.alias = str2;
        this.matchedString = str3;
        this.greedy = z;
        this.tokenized = z2;
    }

    @Override // io.noties.prism4j.Prism4j.Node
    public int textLength() {
        return this.matchedString.length();
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public String type() {
        return this.type;
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public List<? extends Prism4j.Node> children() {
        return this.children;
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public String alias() {
        return this.alias;
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public String matchedString() {
        return this.matchedString;
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public boolean greedy() {
        return this.greedy;
    }

    @Override // io.noties.prism4j.Prism4j.Syntax
    public boolean tokenized() {
        return this.tokenized;
    }

    public String toString() {
        return "SyntaxImpl{type='" + this.type + "', children=" + this.children + ", alias='" + this.alias + "', matchedString='" + this.matchedString + "', greedy=" + this.greedy + ", tokenized=" + this.tokenized + AbstractJsonLexerKt.END_OBJ;
    }
}
