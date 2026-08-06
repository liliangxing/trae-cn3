package io.noties.prism4j.languages;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_markdown {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "markup"), "markdown", new Prism4j.Token[0]);
        Prism4j.Token token = Prism4j.token("bold", Prism4j.pattern(Pattern.compile("(^|[^\\\\])(\\*\\*|__)(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^\\*\\*|^__|\\*\\*$|__$"))))));
        Prism4j.Token token2 = Prism4j.token("italic", Prism4j.pattern(Pattern.compile("(^|[^\\\\])([*_])(?:(?:\\r?\\n|\\r)(?!\\r?\\n|\\r)|.)+?\\2"), true, false, null, Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^[*_]|[*_]$"))))));
        Prism4j.Token token3 = Prism4j.token("url", Prism4j.pattern(Pattern.compile("!?\\[[^\\]]+\\](?:\\([^\\s)]+(?:[\\t ]+\"(?:\\\\.|[^\"\\\\])*\")?\\)| ?\\[[^\\]\\n]*\\])"), false, false, null, Prism4j.grammar("inside", Prism4j.token("variable", Prism4j.pattern(Pattern.compile("(!?\\[)[^\\]]+(?=\\]$)"), true)), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("\"(?:\\\\.|[^\"\\\\])*\"(?=\\)$)"))))));
        GrammarUtils.insertBeforeToken(extend, "prolog", Prism4j.token("blockquote", Prism4j.pattern(Pattern.compile("^>(?:[\\t ]*>)*", 8))), Prism4j.token(AlogMonitor.ALOG_RESULT_CODE, Prism4j.pattern(Pattern.compile("^(?: {4}|\\t).+", 8), false, false, "keyword"), Prism4j.pattern(Pattern.compile("``.+?``|`[^`\\n]+`"), false, false, "keyword")), Prism4j.token("title", Prism4j.pattern(Pattern.compile("\\w+.*(?:\\r?\\n|\\r)(?:==+|--+)"), false, false, "important", Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("==+$|--+$"))))), Prism4j.pattern(Pattern.compile("(^\\s*)#+.+", 8), true, false, "important", Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^#+|#+$")))))), Prism4j.token("hr", Prism4j.pattern(Pattern.compile("(^\\s*)([*-])(?:[\\t ]*\\2){2,}(?=\\s*$)", 8), true, false, "punctuation")), Prism4j.token("list", Prism4j.pattern(Pattern.compile("(^\\s*)(?:[*+-]|\\d+\\.)(?=[\\t ].)", 8), true, false, "punctuation")), Prism4j.token("url-reference", Prism4j.pattern(Pattern.compile("!?\\[[^\\]]+\\]:[\\t ]+(?:\\S+|<(?:\\\\.|[^>\\\\])+>)(?:[\\t ]+(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\)))?"), false, false, "url", Prism4j.grammar("inside", Prism4j.token("variable", Prism4j.pattern(Pattern.compile("^(!?\\[)[^\\]]+"), true)), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("(?:\"(?:\\\\.|[^\"\\\\])*\"|'(?:\\\\.|[^'\\\\])*'|\\((?:\\\\.|[^)\\\\])*\\))$"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("^[\\[\\]!:]|[<>]")))))), token, token2, token3);
        add(GrammarUtils.findFirstInsideGrammar(token), token3, token2);
        add(GrammarUtils.findFirstInsideGrammar(token2), token3, token);
        return extend;
    }

    private static void add(Prism4j.Grammar grammar, Prism4j.Token token, Prism4j.Token token2) {
        if (grammar != null) {
            grammar.tokens().add(token);
            grammar.tokens().add(token2);
        }
    }
}
