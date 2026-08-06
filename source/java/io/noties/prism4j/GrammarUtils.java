package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class GrammarUtils {
    private static final Cloner CLONER = Cloner.create();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface TokenFilter {
        boolean test(Prism4j.Token token);
    }

    public static Prism4j.Token findToken(Prism4j.Grammar grammar, String str) {
        return findToken(grammar, str.split("/"), 0);
    }

    private static Prism4j.Token findToken(Prism4j.Grammar grammar, String[] strArr, int i) {
        String str = strArr[i];
        boolean z = i == strArr.length - 1;
        for (Prism4j.Token token : grammar.tokens()) {
            if (str.equals(token.name())) {
                if (z) {
                    return token;
                }
                Prism4j.Grammar findFirstInsideGrammar = findFirstInsideGrammar(token);
                if (findFirstInsideGrammar != null) {
                    return findToken(findFirstInsideGrammar, strArr, i + 1);
                }
                return null;
            }
        }
        return null;
    }

    public static void insertBeforeToken(Prism4j.Grammar grammar, String str, Prism4j.Token... tokenArr) {
        if (tokenArr == null || tokenArr.length == 0) {
            return;
        }
        insertBeforeToken(grammar, str.split("/"), 0, tokenArr);
    }

    private static void insertBeforeToken(Prism4j.Grammar grammar, String[] strArr, int i, Prism4j.Token[] tokenArr) {
        String str = strArr[i];
        boolean z = i == strArr.length - 1;
        List<Prism4j.Token> list = grammar.tokens();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Prism4j.Token token = list.get(i2);
            if (str.equals(token.name())) {
                if (z) {
                    insertTokensAt(i2, list, tokenArr);
                    return;
                }
                Prism4j.Grammar findFirstInsideGrammar = findFirstInsideGrammar(token);
                if (findFirstInsideGrammar != null) {
                    insertBeforeToken(findFirstInsideGrammar, strArr, i + 1, tokenArr);
                    return;
                }
                return;
            }
        }
    }

    public static Prism4j.Grammar findFirstInsideGrammar(Prism4j.Token token) {
        for (Prism4j.Pattern pattern : token.patterns()) {
            if (pattern.inside() != null) {
                return pattern.inside();
            }
        }
        return null;
    }

    private static void insertTokensAt(int i, List<Prism4j.Token> list, Prism4j.Token[] tokenArr) {
        int length = tokenArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            list.add(i + i2, tokenArr[i2]);
        }
    }

    public static Prism4j.Grammar clone(Prism4j.Grammar grammar) {
        return CLONER.clone(grammar);
    }

    public static Prism4j.Token clone(Prism4j.Token token) {
        return CLONER.clone(token);
    }

    public static Prism4j.Pattern clone(Prism4j.Pattern pattern) {
        return CLONER.clone(pattern);
    }

    public static Prism4j.Grammar extend(Prism4j.Grammar grammar, String str, Prism4j.Token... tokenArr) {
        int length = tokenArr != null ? tokenArr.length : 0;
        if (length == 0) {
            return new GrammarImpl(str, clone(grammar).tokens());
        }
        HashMap hashMap = new HashMap(length);
        for (Prism4j.Token token : tokenArr) {
            hashMap.put(token.name(), token);
        }
        List<Prism4j.Token> list = grammar.tokens();
        ArrayList arrayList = new ArrayList(list.size());
        for (Prism4j.Token token2 : list) {
            Prism4j.Token token3 = (Prism4j.Token) hashMap.get(token2.name());
            if (token3 != null) {
                arrayList.add(token3);
            } else {
                arrayList.add(clone(token2));
            }
        }
        return new GrammarImpl(str, arrayList);
    }

    public static Prism4j.Grammar extend(Prism4j.Grammar grammar, String str, TokenFilter tokenFilter, Prism4j.Token... tokenArr) {
        Map map;
        int length = tokenArr != null ? tokenArr.length : 0;
        if (length == 0) {
            map = Collections.emptyMap();
        } else {
            HashMap hashMap = new HashMap(length);
            for (Prism4j.Token token : tokenArr) {
                hashMap.put(token.name(), token);
            }
            map = hashMap;
        }
        List<Prism4j.Token> list = grammar.tokens();
        ArrayList arrayList = new ArrayList(list.size());
        for (Prism4j.Token token2 : list) {
            if (tokenFilter.test(token2)) {
                Prism4j.Token token3 = (Prism4j.Token) map.get(token2.name());
                if (token3 != null) {
                    arrayList.add(token3);
                } else {
                    arrayList.add(clone(token2));
                }
            }
        }
        return new GrammarImpl(str, arrayList);
    }

    public static Prism4j.Grammar require(Prism4j prism4j, String str) {
        Prism4j.Grammar grammar = prism4j.grammar(str);
        if (grammar != null) {
            return grammar;
        }
        throw new IllegalStateException("Unexpected state, requested language is not found: " + str);
    }

    private GrammarUtils() {
    }
}
