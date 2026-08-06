package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.List;

/* loaded from: classes3.dex */
public class TokenImpl implements Prism4j.Token {
    private final String name;
    private final List<Prism4j.Pattern> patterns;

    public TokenImpl(String str, List<Prism4j.Pattern> list) {
        this.name = str;
        this.patterns = list;
    }

    @Override // io.noties.prism4j.Prism4j.Token
    public String name() {
        return this.name;
    }

    @Override // io.noties.prism4j.Prism4j.Token
    public List<Prism4j.Pattern> patterns() {
        return this.patterns;
    }

    public String toString() {
        return ToString.toString(this);
    }
}
