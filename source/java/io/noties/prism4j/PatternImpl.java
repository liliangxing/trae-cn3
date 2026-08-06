package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class PatternImpl implements Prism4j.Pattern {
    private final String alias;
    private final boolean greedy;
    private final Prism4j.Grammar inside;
    private final boolean lookbehind;
    private final Pattern regex;

    public PatternImpl(Pattern pattern, boolean z, boolean z2, String str, Prism4j.Grammar grammar) {
        this.regex = pattern;
        this.lookbehind = z;
        this.greedy = z2;
        this.alias = str;
        this.inside = grammar;
    }

    @Override // io.noties.prism4j.Prism4j.Pattern
    public Pattern regex() {
        return this.regex;
    }

    @Override // io.noties.prism4j.Prism4j.Pattern
    public boolean lookbehind() {
        return this.lookbehind;
    }

    @Override // io.noties.prism4j.Prism4j.Pattern
    public boolean greedy() {
        return this.greedy;
    }

    @Override // io.noties.prism4j.Prism4j.Pattern
    public String alias() {
        return this.alias;
    }

    @Override // io.noties.prism4j.Prism4j.Pattern
    public Prism4j.Grammar inside() {
        return this.inside;
    }

    public String toString() {
        return ToString.toString(this);
    }
}
