package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.SourceType;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_go {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "go", new GrammarUtils.TokenFilter() { // from class: io.noties.prism4j.languages.Prism_go.1
            @Override // io.noties.prism4j.GrammarUtils.TokenFilter
            public boolean test(Prism4j.Token token) {
                return !"class-name".equals(token.name());
            }
        }, Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:break|case|chan|const|continue|default|defer|else|fallthrough|for|func|go(?:to)?|if|import|interface|map|package|range|return|select|struct|switch|type|var)\\b"))), Prism4j.token(WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, Prism4j.pattern(Pattern.compile("\\b(?:_|iota|nil|true|false)\\b"))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("[*\\/%^!=]=?|\\+[=+]?|-[=-]?|\\|[=|]?|&(?:=|&|\\^=?)?|>(?:>=?|=)?|<(?:<=?|=|-)?|:=|\\.\\.\\."))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("(?:\\b0x[a-f\\d]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[-+]?\\d+)?)i?", 2))), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("([\"'`])(\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false, true)));
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE, Prism4j.token(SourceType.BUILTIN, Prism4j.pattern(Pattern.compile("\\b(?:bool|byte|complex(?:64|128)|error|float(?:32|64)|rune|string|u?int(?:8|16|32|64)?|uintptr|append|cap|close|complex|copy|delete|imag|len|make|new|panic|print(?:ln)?|real|recover)\\b"))));
        return extend;
    }
}
