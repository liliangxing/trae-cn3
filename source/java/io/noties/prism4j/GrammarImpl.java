package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.List;

/* loaded from: classes3.dex */
public class GrammarImpl implements Prism4j.Grammar {
    private final String name;
    private final List<Prism4j.Token> tokens;

    public GrammarImpl(String str, List<Prism4j.Token> list) {
        this.name = str;
        this.tokens = list;
    }

    @Override // io.noties.prism4j.Prism4j.Grammar
    public String name() {
        return this.name;
    }

    @Override // io.noties.prism4j.Prism4j.Grammar
    public List<Prism4j.Token> tokens() {
        return this.tokens;
    }

    public String toString() {
        return ToString.toString(this);
    }
}
