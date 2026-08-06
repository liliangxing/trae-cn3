package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_csharp {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar grammar = Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("\\."))));
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "csharp", Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:abstract|add|alias|as|ascending|async|await|base|bool|break|byte|case|catch|char|checked|class|const|continue|decimal|default|delegate|descending|do|double|dynamic|else|enum|event|explicit|extern|false|finally|fixed|float|for|foreach|from|get|global|goto|group|if|implicit|in|int|interface|internal|into|is|join|let|lock|long|namespace|new|null|object|operator|orderby|out|override|params|partial|private|protected|public|readonly|ref|remove|return|sbyte|sealed|select|set|short|sizeof|stackalloc|static|string|struct|switch|this|throw|true|try|typeof|uint|ulong|unchecked|unsafe|ushort|using|value|var|virtual|void|volatile|where|while|yield)\\b"))), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("@(\"|')(?:\\1\\1|\\\\[\\s\\S]|(?!\\1)[^\\\\])*\\1"), false, true), Prism4j.pattern(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*?\\1"), false, true)), Prism4j.token("class-name", Prism4j.pattern(Pattern.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b(?=\\s+\\w+)"), false, false, null, grammar), Prism4j.pattern(Pattern.compile("(\\[)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, grammar), Prism4j.pattern(Pattern.compile("(\\b(?:class|interface)\\s+[A-Z]\\w*(?:\\.\\w+)*\\s*:\\s*)[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, grammar), Prism4j.pattern(Pattern.compile("((?:\\b(?:class|interface|new)\\s+)|(?:catch\\s+\\())[A-Z]\\w*(?:\\.\\w+)*\\b"), true, false, null, grammar)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)f?", 2))));
        GrammarUtils.insertBeforeToken(extend, "class-name", Prism4j.token("generic-method", Prism4j.pattern(Pattern.compile("\\w+\\s*<[^>\\r\\n]+?>\\s*(?=\\()"), false, false, null, Prism4j.grammar("inside", Prism4j.token("function", Prism4j.pattern(Pattern.compile("^\\w+"))), Prism4j.token("class-name", Prism4j.pattern(Pattern.compile("\\b[A-Z]\\w*(?:\\.\\w+)*\\b"), false, false, null, grammar)), GrammarUtils.findToken(extend, "keyword"), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[<>(),.:]")))))), Prism4j.token("preprocessor", Prism4j.pattern(Pattern.compile("(^\\s*)#.*", 8), true, false, "property", Prism4j.grammar("inside", Prism4j.token("directive", Prism4j.pattern(Pattern.compile("(\\s*#)\\b(?:define|elif|else|endif|endregion|error|if|line|pragma|region|undef|warning)\\b"), true, false, "keyword"))))));
        return extend;
    }
}
