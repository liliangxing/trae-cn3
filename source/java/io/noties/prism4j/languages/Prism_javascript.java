package io.noties.prism4j.languages;

import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.PreloadConfig;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_javascript {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "javascript", Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:as|async|await|break|case|catch|class|const|continue|debugger|default|delete|do|else|enum|export|extends|finally|for|from|function|get|if|implements|import|in|instanceof|interface|let|new|null|of|package|private|protected|public|return|set|static|super|switch|this|throw|try|typeof|var|void|while|with|yield)\\b"))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b(?:0[xX][\\dA-Fa-f]+|0[bB][01]+|0[oO][0-7]+|NaN|Infinity)\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))), Prism4j.token("function", Prism4j.pattern(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*\\()", 2))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("-[-=]?|\\+[+=]?|!=?=?|<<?=?|>>?>?=?|=(?:==?|>)?|&[&=]?|\\|[|=]?|\\*\\*?=?|\\/=?|~|\\^=?|%=?|\\?|\\.{3}"))));
        GrammarUtils.insertBeforeToken(extend, "keyword", Prism4j.token("regex", Prism4j.pattern(Pattern.compile("((?:^|[^$\\w\\xA0-\\uFFFF.\"'\\])\\s])\\s*)\\/(\\[[^\\]\\r\\n]+]|\\\\.|[^/\\\\\\[\\r\\n])+\\/[gimyu]{0,5}(?=\\s*($|[\\r\\n,.;})\\]]))"), true, true)), Prism4j.token("function-variable", Prism4j.pattern(Pattern.compile("[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*(?=\\s*=\\s*(?:function\\b|(?:\\([^()]*\\)|[_$a-z\\xA0-\\uFFFF][$\\w\\xA0-\\uFFFF]*)\\s*=>))", 2), false, false, "function")), Prism4j.token("constant", Prism4j.pattern(Pattern.compile("\\b[A-Z][A-Z\\d_]*\\b"))));
        Prism4j.Token token = Prism4j.token("interpolation", new Prism4j.Pattern[0]);
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.token("template-string", Prism4j.pattern(Pattern.compile("`(?:\\\\[\\s\\S]|\\$\\{[^}]+\\}|[^\\\\`])*`"), false, true, null, Prism4j.grammar("inside", token, Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("[\\s\\S]+")))))));
        ArrayList arrayList = new ArrayList(extend.tokens().size() + 1);
        arrayList.add(Prism4j.token("interpolation-punctuation", Prism4j.pattern(Pattern.compile("^\\$\\{|\\}$"), false, false, "punctuation")));
        arrayList.addAll(extend.tokens());
        token.patterns().add(Prism4j.pattern(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, Prism4j.grammar("inside", arrayList)));
        Prism4j.Grammar grammar = prism4j.grammar("markup");
        if (grammar != null) {
            GrammarUtils.insertBeforeToken(grammar, Api.COL_TAG, Prism4j.token(PreloadConfig.KEY_SCRIPT, Prism4j.pattern(Pattern.compile("(<script[\\s\\S]*?>)[\\s\\S]*?(?=<\\/script>)", 2), true, true, "language-javascript", extend)));
        }
        return extend;
    }
}
