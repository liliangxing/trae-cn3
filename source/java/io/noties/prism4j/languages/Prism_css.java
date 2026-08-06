package io.noties.prism4j.languages;

import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.PreloadConfig;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class Prism_css {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar grammar;
        Prism4j.Grammar grammar2 = Prism4j.grammar(PreloadConfig.KEY_STYLESHEET, Prism4j.token("comment", Prism4j.pattern(Pattern.compile("\\/\\*[\\s\\S]*?\\*\\/"))), Prism4j.token("atrule", Prism4j.pattern(Pattern.compile("@[\\w-]+?.*?(?:;|(?=\\s*\\{))", 2), false, false, null, Prism4j.grammar("inside", Prism4j.token("rule", Prism4j.pattern(Pattern.compile("@[\\w-]+")))))), Prism4j.token("url", Prism4j.pattern(Pattern.compile("url\\((?:([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1|.*?)\\)", 2))), Prism4j.token("selector", Prism4j.pattern(Pattern.compile("[^{}\\s][^{};]*?(?=\\s*\\{)"))), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("(\"|')(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token("property", Prism4j.pattern(Pattern.compile("[-_a-z\\xA0-\\uFFFF][-\\w\\xA0-\\uFFFF]*(?=\\s*:)", 2))), Prism4j.token("important", Prism4j.pattern(Pattern.compile("\\B!important\\b", 2))), Prism4j.token("function", Prism4j.pattern(Pattern.compile("[-a-z0-9]+(?=\\()", 2))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[(){};:]"))));
        Prism4j.Grammar findFirstInsideGrammar = GrammarUtils.findFirstInsideGrammar(grammar2.tokens().get(1));
        if (findFirstInsideGrammar != null) {
            for (Prism4j.Token token : grammar2.tokens()) {
                if (!"atrule".equals(token.name())) {
                    findFirstInsideGrammar.tokens().add(token);
                }
            }
        }
        Prism4j.Grammar grammar3 = prism4j.grammar("markup");
        if (grammar3 != null) {
            GrammarUtils.insertBeforeToken(grammar3, Api.COL_TAG, Prism4j.token("style", Prism4j.pattern(Pattern.compile("(<style[\\s\\S]*?>)[\\s\\S]*?(?=<\\/style>)", 2), true, true, "language-css", grammar2)));
            Prism4j.Token findToken = GrammarUtils.findToken(grammar3, Api.COL_TAG);
            if (findToken != null) {
                grammar = GrammarUtils.findFirstInsideGrammar(findToken);
                if (grammar != null) {
                    grammar = GrammarUtils.clone(grammar);
                }
            } else {
                grammar = null;
            }
            GrammarUtils.insertBeforeToken(grammar3, "tag/attr-value", Prism4j.token("style-attr", Prism4j.pattern(Pattern.compile("\\s*style=(\"|')(?:\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1", 2), false, false, "language-css", Prism4j.grammar("inside", Prism4j.token("attr-name", Prism4j.pattern(Pattern.compile("^\\s*style", 2), false, false, null, grammar)), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^\\s*=\\s*['\"]|['\"]\\s*$"))), Prism4j.token("attr-value", Prism4j.pattern(Pattern.compile(".+", 2), false, false, null, grammar2))))));
        }
        return grammar2;
    }

    private Prism_css() {
    }
}
