package io.noties.prism4j.languages;

import com.bytedance.applog.server.Api;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.SourceType;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_kotlin {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "kotlin", new GrammarUtils.TokenFilter() { // from class: io.noties.prism4j.languages.Prism_kotlin.1
            @Override // io.noties.prism4j.GrammarUtils.TokenFilter
            public boolean test(Prism4j.Token token) {
                return !"class-name".equals(token.name());
            }
        }, Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("(^|[^.])\\b(?:abstract|actual|annotation|as|break|by|catch|class|companion|const|constructor|continue|crossinline|data|do|dynamic|else|enum|expect|external|final|finally|for|fun|get|if|import|in|infix|init|inline|inner|interface|internal|is|lateinit|noinline|null|object|open|operator|out|override|package|private|protected|public|reified|return|sealed|set|super|suspend|tailrec|this|throw|to|try|typealias|val|var|vararg|when|where|while)\\b"), true)), Prism4j.token("function", Prism4j.pattern(Pattern.compile("\\w+(?=\\s*\\()")), Prism4j.pattern(Pattern.compile("(\\.)\\w+(?=\\s*\\{)"), true)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b(?:0[xX][\\da-fA-F]+(?:_[\\da-fA-F]+)*|0[bB][01]+(?:_[01]+)*|\\d+(?:_\\d+)*(?:\\.\\d+(?:_\\d+)*)?(?:[eE][+-]?\\d+(?:_\\d+)*)?[fFL]?)\\b"))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("\\+[+=]?|-[-=>]?|==?=?|!(?:!|==?)?|[\\/*%<>]=?|[?:]:?|\\.\\.|&&|\\|\\||\\b(?:and|inv|or|shl|shr|ushr|xor)\\b"))));
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.token("raw-string", Prism4j.pattern(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1"), false, false, WsChannelMultiProcessSharedProvider.STRING_TYPE)));
        GrammarUtils.insertBeforeToken(extend, "keyword", Prism4j.token("annotation", Prism4j.pattern(Pattern.compile("\\B@(?:\\w+:)?(?:[A-Z]\\w*|\\[[^\\]]+\\])"), false, false, SourceType.BUILTIN)));
        GrammarUtils.insertBeforeToken(extend, "function", Prism4j.token(Api.COL_LABEL, Prism4j.pattern(Pattern.compile("\\w+@|@\\w+"), false, false, "symbol")));
        ArrayList arrayList = new ArrayList(extend.tokens().size() + 1);
        arrayList.add(Prism4j.token("delimiter", Prism4j.pattern(Pattern.compile("^\\$\\{|\\}$"), false, false, "variable")));
        arrayList.addAll(extend.tokens());
        Prism4j.Grammar grammar = Prism4j.grammar("inside", Prism4j.token("interpolation", Prism4j.pattern(Pattern.compile("\\$\\{[^}]+\\}"), false, false, null, Prism4j.grammar("inside", arrayList)), Prism4j.pattern(Pattern.compile("\\$\\w+"), false, false, "variable")));
        Prism4j.Token findToken = GrammarUtils.findToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE);
        Prism4j.Token findToken2 = GrammarUtils.findToken(extend, "raw-string");
        if (findToken != null && findToken2 != null) {
            Prism4j.Pattern pattern = findToken.patterns().get(0);
            Prism4j.Pattern pattern2 = findToken2.patterns().get(0);
            findToken.patterns().add(Prism4j.pattern(pattern.regex(), pattern.lookbehind(), pattern.greedy(), pattern.alias(), grammar));
            findToken2.patterns().add(Prism4j.pattern(pattern2.regex(), pattern2.lookbehind(), pattern2.greedy(), pattern2.alias(), grammar));
            findToken.patterns().remove(0);
            findToken2.patterns().remove(0);
            return extend;
        }
        throw new RuntimeException("Unexpected state, cannot find `string` and/or `raw-string` tokens inside kotlin grammar");
    }
}
