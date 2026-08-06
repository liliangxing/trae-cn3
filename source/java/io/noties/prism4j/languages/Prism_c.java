package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_c {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "c", new GrammarUtils.TokenFilter() { // from class: io.noties.prism4j.languages.Prism_c.1
            @Override // io.noties.prism4j.GrammarUtils.TokenFilter
            public boolean test(Prism4j.Token token) {
                String name = token.name();
                return ("class-name".equals(name) || WsChannelMultiProcessSharedProvider.BOOLEAN_TYPE.equals(name)) ? false : true;
            }
        }, Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:_Alignas|_Alignof|_Atomic|_Bool|_Complex|_Generic|_Imaginary|_Noreturn|_Static_assert|_Thread_local|asm|typeof|inline|auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while)\\b"))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("-[>-]?|\\+\\+?|!=?|<<?=?|>>?=?|==?|&&?|\\|\\|?|[~^%?*\\/]"))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("(?:\\b0x[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?)[ful]*", 2))));
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.token("macro", Prism4j.pattern(Pattern.compile("(^\\s*)#\\s*[a-z]+(?:[^\\r\\n\\\\]|\\\\(?:\\r\\n|[\\s\\S]))*", 10), true, false, "property", Prism4j.grammar("inside", Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("(#\\s*include\\s*)(?:<.+?>|(\"|')(?:\\\\?.)+?\\2)"), true)), Prism4j.token("directive", Prism4j.pattern(Pattern.compile("(#\\s*)\\b(?:define|defined|elif|else|endif|error|ifdef|ifndef|if|import|include|line|pragma|undef|using)\\b"), true, false, "keyword"))))), Prism4j.token("constant", Prism4j.pattern(Pattern.compile("\\b(?:__FILE__|__LINE__|__DATE__|__TIME__|__TIMESTAMP__|__func__|EOF|NULL|SEEK_CUR|SEEK_END|SEEK_SET|stdin|stdout|stderr)\\b"))));
        return extend;
    }
}
