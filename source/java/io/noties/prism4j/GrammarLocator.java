package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.Set;

/* loaded from: classes3.dex */
public interface GrammarLocator {
    Prism4j.Grammar grammar(Prism4j prism4j, String str);

    Set<String> languages();
}
