package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.forest.model.SourceType;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_scala {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "java"), "scala", new GrammarUtils.TokenFilter() { // from class: io.noties.prism4j.languages.Prism_scala.1
            @Override // io.noties.prism4j.GrammarUtils.TokenFilter
            public boolean test(Prism4j.Token token) {
                String name = token.name();
                return ("class-name".equals(name) || "function".equals(name)) ? false : true;
            }
        }, Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("<-|=>|\\b(?:abstract|case|catch|class|def|do|else|extends|final|finally|for|forSome|if|implicit|import|lazy|match|new|null|object|override|package|private|protected|return|sealed|self|super|this|throw|trait|try|type|val|var|while|with|yield)\\b"))), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("\"\"\"[\\s\\S]*?\"\"\""), false, true), Prism4j.pattern(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b0x[\\da-f]*\\.?[\\da-f]+|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e\\d+)?[dfl]?", 2))));
        extend.tokens().add(Prism4j.token("symbol", Prism4j.pattern(Pattern.compile("'[^\\d\\s\\\\]\\w*"))));
        GrammarUtils.insertBeforeToken(extend, "number", Prism4j.token(SourceType.BUILTIN, Prism4j.pattern(Pattern.compile("\\b(?:String|Int|Long|Short|Byte|Boolean|Double|Float|Char|Any|AnyRef|AnyVal|Unit|Nothing)\\b"))));
        return extend;
    }
}
