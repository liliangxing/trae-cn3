package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.HashSet;
import java.util.Set;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
abstract class ToString {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public interface Cache {
        void markVisited(Object obj);

        boolean visited(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(Prism4j.Grammar grammar) {
        StringBuilder sb = new StringBuilder();
        toString(sb, new CacheImpl(), grammar);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(Prism4j.Token token) {
        StringBuilder sb = new StringBuilder();
        toString(sb, new CacheImpl(), token);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String toString(Prism4j.Pattern pattern) {
        StringBuilder sb = new StringBuilder();
        toString(sb, new CacheImpl(), pattern);
        return sb.toString();
    }

    private ToString() {
    }

    private static void toString(StringBuilder sb, Cache cache, Prism4j.Grammar grammar) {
        sb.append("Grammar{id=0x").append(Integer.toHexString(System.identityHashCode(grammar))).append(",name=\"").append(grammar.name()).append('\"');
        if (cache.visited(grammar)) {
            sb.append(",[...]");
        } else {
            cache.markVisited(grammar);
            sb.append(",tokens=[");
            boolean z = true;
            for (Prism4j.Token token : grammar.tokens()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                toString(sb, cache, token);
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
    }

    private static void toString(StringBuilder sb, Cache cache, Prism4j.Token token) {
        sb.append("Token{id=0x").append(Integer.toHexString(System.identityHashCode(token))).append(",name=\"").append(token.name()).append('\"');
        if (cache.visited(token)) {
            sb.append(",[...]");
        } else {
            cache.markVisited(token);
            sb.append(",patterns=[");
            boolean z = true;
            for (Prism4j.Pattern pattern : token.patterns()) {
                if (z) {
                    z = false;
                } else {
                    sb.append(',');
                }
                toString(sb, cache, pattern);
            }
            sb.append(AbstractJsonLexerKt.END_LIST);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
    }

    private static void toString(StringBuilder sb, Cache cache, Prism4j.Pattern pattern) {
        sb.append("Pattern{id=0x").append(Integer.toHexString(System.identityHashCode(pattern)));
        if (cache.visited(pattern)) {
            sb.append(",[...]");
        } else {
            cache.markVisited(pattern);
            sb.append(",regex=\"").append(pattern.regex()).append('\"');
            if (pattern.lookbehind()) {
                sb.append(",lookbehind=true");
            }
            if (pattern.greedy()) {
                sb.append(",greedy=true");
            }
            if (pattern.alias() != null) {
                sb.append(",alias=\"").append(pattern.alias()).append('\"');
            }
            Prism4j.Grammar inside = pattern.inside();
            if (inside != null) {
                sb.append(",inside=");
                toString(sb, cache, inside);
            }
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class CacheImpl implements Cache {
        private final Set<Integer> cache;

        private CacheImpl() {
            this.cache = new HashSet(3);
        }

        @Override // io.noties.prism4j.ToString.Cache
        public boolean visited(Object obj) {
            return this.cache.contains(key(obj));
        }

        @Override // io.noties.prism4j.ToString.Cache
        public void markVisited(Object obj) {
            this.cache.add(key(obj));
        }

        private static Integer key(Object obj) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
    }
}
