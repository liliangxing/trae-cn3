package io.noties.prism4j;

import io.noties.prism4j.Prism4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
abstract class Cloner {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Prism4j.Grammar clone(Prism4j.Grammar grammar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Prism4j.Pattern clone(Prism4j.Pattern pattern);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Prism4j.Token clone(Prism4j.Token token);

    Cloner() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Cloner create() {
        return new Impl();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    static class Impl extends Cloner {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public interface Context {
            Prism4j.Grammar grammar(Prism4j.Grammar grammar);

            Prism4j.Pattern pattern(Prism4j.Pattern pattern);

            void save(Prism4j.Grammar grammar, Prism4j.Grammar grammar2);

            void save(Prism4j.Pattern pattern, Prism4j.Pattern pattern2);

            void save(Prism4j.Token token, Prism4j.Token token2);

            Prism4j.Token token(Prism4j.Token token);
        }

        Impl() {
        }

        @Override // io.noties.prism4j.Cloner
        Prism4j.Grammar clone(Prism4j.Grammar grammar) {
            return clone(new ContextImpl(), grammar);
        }

        @Override // io.noties.prism4j.Cloner
        Prism4j.Token clone(Prism4j.Token token) {
            return clone(new ContextImpl(), token);
        }

        @Override // io.noties.prism4j.Cloner
        Prism4j.Pattern clone(Prism4j.Pattern pattern) {
            return clone(new ContextImpl(), pattern);
        }

        private Prism4j.Grammar clone(Context context, Prism4j.Grammar grammar) {
            Prism4j.Grammar grammar2 = context.grammar(grammar);
            if (grammar2 != null) {
                return grammar2;
            }
            List<Prism4j.Token> list = grammar.tokens();
            ArrayList arrayList = new ArrayList(list.size());
            GrammarImpl grammarImpl = new GrammarImpl(grammar.name(), arrayList);
            context.save(grammar, grammarImpl);
            Iterator<Prism4j.Token> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(clone(context, it.next()));
            }
            return grammarImpl;
        }

        private Prism4j.Token clone(Context context, Prism4j.Token token) {
            Prism4j.Token token2 = context.token(token);
            if (token2 != null) {
                return token2;
            }
            List<Prism4j.Pattern> patterns = token.patterns();
            ArrayList arrayList = new ArrayList(patterns.size());
            TokenImpl tokenImpl = new TokenImpl(token.name(), arrayList);
            context.save(token, tokenImpl);
            Iterator<Prism4j.Pattern> it = patterns.iterator();
            while (it.hasNext()) {
                arrayList.add(clone(context, it.next()));
            }
            return tokenImpl;
        }

        private Prism4j.Pattern clone(Context context, Prism4j.Pattern pattern) {
            Prism4j.Pattern pattern2 = context.pattern(pattern);
            if (pattern2 != null) {
                return pattern2;
            }
            Prism4j.Grammar inside = pattern.inside();
            PatternImpl patternImpl = new PatternImpl(pattern.regex(), pattern.lookbehind(), pattern.greedy(), pattern.alias(), inside != null ? clone(context, inside) : null);
            context.save(pattern, patternImpl);
            return patternImpl;
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        private static class ContextImpl implements Context {
            private final Map<Integer, Object> cache;

            private ContextImpl() {
                this.cache = new HashMap(3);
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public Prism4j.Grammar grammar(Prism4j.Grammar grammar) {
                return (Prism4j.Grammar) this.cache.get(Integer.valueOf(key(grammar)));
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public Prism4j.Token token(Prism4j.Token token) {
                return (Prism4j.Token) this.cache.get(Integer.valueOf(key(token)));
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public Prism4j.Pattern pattern(Prism4j.Pattern pattern) {
                return (Prism4j.Pattern) this.cache.get(Integer.valueOf(key(pattern)));
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public void save(Prism4j.Grammar grammar, Prism4j.Grammar grammar2) {
                this.cache.put(Integer.valueOf(key(grammar)), grammar2);
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public void save(Prism4j.Token token, Prism4j.Token token2) {
                this.cache.put(Integer.valueOf(key(token)), token2);
            }

            @Override // io.noties.prism4j.Cloner.Impl.Context
            public void save(Prism4j.Pattern pattern, Prism4j.Pattern pattern2) {
                this.cache.put(Integer.valueOf(key(pattern)), pattern2);
            }

            private static int key(Object obj) {
                return System.identityHashCode(obj);
            }
        }
    }
}
