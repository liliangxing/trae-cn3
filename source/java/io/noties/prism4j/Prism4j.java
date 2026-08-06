package io.noties.prism4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public class Prism4j {
    private final GrammarLocator grammarLocator;

    /* loaded from: classes3.dex */
    public interface Grammar {
        String name();

        List<Token> tokens();
    }

    /* loaded from: classes3.dex */
    public interface Node {
        boolean isSyntax();

        int textLength();
    }

    /* loaded from: classes3.dex */
    public interface Pattern {
        String alias();

        boolean greedy();

        Grammar inside();

        boolean lookbehind();

        java.util.regex.Pattern regex();
    }

    /* loaded from: classes3.dex */
    public interface Syntax extends Node {
        String alias();

        List<? extends Node> children();

        boolean greedy();

        String matchedString();

        boolean tokenized();

        String type();
    }

    /* loaded from: classes3.dex */
    public interface Text extends Node {
        String literal();
    }

    /* loaded from: classes3.dex */
    public interface Token {
        String name();

        List<Pattern> patterns();
    }

    /* loaded from: classes3.dex */
    public interface Visitor {
        void visit(List<? extends Node> list);
    }

    public static Grammar grammar(String str, List<Token> list) {
        return new GrammarImpl(str, list);
    }

    public static Grammar grammar(String str, Token... tokenArr) {
        return new GrammarImpl(str, ArrayUtils.toList(tokenArr));
    }

    public static Token token(String str, List<Pattern> list) {
        return new TokenImpl(str, list);
    }

    public static Token token(String str, Pattern... patternArr) {
        return new TokenImpl(str, ArrayUtils.toList(patternArr));
    }

    public static Pattern pattern(java.util.regex.Pattern pattern) {
        return new PatternImpl(pattern, false, false, null, null);
    }

    public static Pattern pattern(java.util.regex.Pattern pattern, boolean z) {
        return new PatternImpl(pattern, z, false, null, null);
    }

    public static Pattern pattern(java.util.regex.Pattern pattern, boolean z, boolean z2) {
        return new PatternImpl(pattern, z, z2, null, null);
    }

    public static Pattern pattern(java.util.regex.Pattern pattern, boolean z, boolean z2, String str) {
        return new PatternImpl(pattern, z, z2, str, null);
    }

    public static Pattern pattern(java.util.regex.Pattern pattern, boolean z, boolean z2, String str, Grammar grammar) {
        return new PatternImpl(pattern, z, z2, str, grammar);
    }

    public Prism4j(GrammarLocator grammarLocator) {
        this.grammarLocator = grammarLocator;
    }

    public List<Node> tokenize(String str, Grammar grammar) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(new TextImpl(str));
        matchGrammar(str, arrayList, grammar, 0, 0, false, null);
        return arrayList;
    }

    public Grammar grammar(String str) {
        return this.grammarLocator.grammar(this, str);
    }

    private void matchGrammar(String str, List<Node> list, Grammar grammar, int i, int i2, boolean z, Token token) {
        Token next;
        Iterator<Token> it;
        Iterator<Pattern> it2;
        int i3;
        int i4;
        String str2;
        int i5;
        int i6;
        Matcher matcher;
        boolean z2;
        int i7;
        String group;
        int i8;
        int i9;
        int i10;
        List<Node> singletonList;
        int i11;
        int i12;
        java.util.regex.Pattern pattern;
        int i13;
        int length = str.length();
        if (length == 0) {
            return;
        }
        Iterator<Token> it3 = grammar.tokens().iterator();
        while (it3.hasNext() && (next = it3.next()) != token) {
            Iterator<Pattern> it4 = next.patterns().iterator();
            while (it4.hasNext()) {
                Pattern next2 = it4.next();
                boolean lookbehind = next2.lookbehind();
                boolean greedy = next2.greedy();
                java.util.regex.Pattern regex = next2.regex();
                int i14 = 0;
                int i15 = i;
                int i16 = i2;
                int i17 = 0;
                while (i15 < list.size()) {
                    if (list.size() > length) {
                        throw new RuntimeException("Prism4j internal error. Number of entry nodes is greater that the text length.\nNodes: " + list + "\nText: " + str);
                    }
                    Node node = list.get(i15);
                    if (isSyntaxNode(node)) {
                        i12 = 1;
                        i11 = i14;
                        i3 = length;
                        it = it3;
                        it2 = it4;
                    } else {
                        String literal = ((Text) node).literal();
                        if (greedy && i15 != list.size() - 1) {
                            Matcher matcher2 = regex.matcher(str);
                            matcher2.region(i16, length);
                            if (!matcher2.find()) {
                                break;
                            }
                            int start = matcher2.start();
                            if (lookbehind) {
                                start += matcher2.group(1).length();
                            }
                            int start2 = matcher2.start() + matcher2.group(i14).length();
                            int size = list.size();
                            i4 = i17;
                            int i18 = i16;
                            int i19 = i18;
                            int i20 = i15;
                            while (i15 < size) {
                                if (i18 >= start2) {
                                    if (isSyntaxNode(list.get(i15))) {
                                        break;
                                    }
                                    i13 = size;
                                    if (isGreedyNode(list.get(i15 - 1))) {
                                        break;
                                    }
                                } else {
                                    i13 = size;
                                }
                                i18 += list.get(i15).textLength();
                                if (start >= i18) {
                                    i20++;
                                    i19 = i18;
                                }
                                i15++;
                                size = i13;
                            }
                            if (isSyntaxNode(list.get(i20))) {
                                i15 = i20;
                                i16 = i19;
                                i3 = length;
                                it = it3;
                                it2 = it4;
                                i17 = i4;
                                i12 = 1;
                                i11 = 0;
                            } else {
                                i5 = -i19;
                                i6 = i15 - i20;
                                i15 = i20;
                                str2 = str.substring(i19, i18);
                                i16 = i19;
                                matcher = matcher2;
                                z2 = true;
                            }
                        } else {
                            i4 = i17;
                            str2 = literal;
                            i5 = 0;
                            i6 = 1;
                            matcher = regex.matcher(literal);
                            z2 = false;
                        }
                        if (z2 || matcher.find()) {
                            if (lookbehind) {
                                String group2 = matcher.group(1);
                                int length2 = group2 != null ? group2.length() : 0;
                                i3 = length;
                                i7 = length2;
                            } else {
                                i3 = length;
                                i7 = i4;
                            }
                            int start3 = matcher.start() + i5 + i7;
                            if (i7 > 0) {
                                group = matcher.group().substring(i7);
                            } else {
                                group = matcher.group();
                            }
                            java.util.regex.Pattern pattern2 = regex;
                            int length3 = start3 + group.length();
                            for (int i21 = 0; i21 < i6; i21++) {
                                list.remove(i15);
                            }
                            if (start3 != 0) {
                                String substring = str2.substring(0, start3);
                                i9 = i15 + 1;
                                int length4 = i16 + substring.length();
                                list.add(i15, new TextImpl(substring));
                                i10 = length4;
                                i8 = i9;
                            } else {
                                i8 = i15;
                                i9 = i8;
                                i10 = i16;
                            }
                            Grammar inside = next2.inside();
                            boolean z3 = inside != null;
                            if (z3) {
                                singletonList = tokenize(group, inside);
                            } else {
                                singletonList = Collections.singletonList(new TextImpl(group));
                            }
                            int i22 = i8 + 1;
                            int i23 = i7;
                            i11 = 0;
                            it = it3;
                            String str3 = str2;
                            i12 = 1;
                            it2 = it4;
                            int i24 = i6;
                            list.add(i8, new SyntaxImpl(next.name(), singletonList, next2.alias(), group, greedy, z3));
                            if (length3 < str3.length()) {
                                list.add(i22, new TextImpl(str3.substring(length3)));
                            }
                            if (i24 != 1) {
                                pattern = pattern2;
                                matchGrammar(str, list, grammar, i9, i10, true, next);
                            } else {
                                pattern = pattern2;
                            }
                            if (z) {
                                break;
                            }
                            i15 = i9;
                            i16 = i10;
                            i17 = i23;
                            i16 += list.get(i15).textLength();
                            i15 += i12;
                            regex = pattern;
                            length = i3;
                            i14 = i11;
                            it4 = it2;
                            it3 = it;
                        } else {
                            if (z) {
                                break;
                            }
                            i3 = length;
                            it = it3;
                            it2 = it4;
                            i17 = i4;
                            i12 = 1;
                            i11 = 0;
                        }
                    }
                    pattern = regex;
                    i16 += list.get(i15).textLength();
                    i15 += i12;
                    regex = pattern;
                    length = i3;
                    i14 = i11;
                    it4 = it2;
                    it3 = it;
                }
                i3 = length;
                it = it3;
                it2 = it4;
                length = i3;
                it4 = it2;
                it3 = it;
            }
        }
    }

    private static boolean isSyntaxNode(Node node) {
        return node.isSyntax();
    }

    private static boolean isGreedyNode(Node node) {
        return node.isSyntax() && ((Syntax) node).greedy();
    }
}
