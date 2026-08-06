package io.noties.prism4j.languages;

import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_java {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Token token = Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:abstract|continue|for|new|switch|assert|default|goto|package|synchronized|boolean|do|if|private|this|break|double|implements|protected|throw|byte|else|import|public|throws|case|enum|instanceof|return|transient|catch|extends|int|short|try|char|final|interface|static|void|class|finally|long|strictfp|volatile|const|float|native|super|while)\\b")));
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "java", token, Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b0b[01]+\\b|\\b0x[\\da-f]*\\.?[\\da-fp-]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?[df]?", 2))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("(^|[^.])(?:\\+[+=]?|-[-=]?|!=?|<<?=?|>>?>?=?|==?|&[&=]?|\\|[|=]?|\\*=?|\\/=?|%=?|\\^=?|[?:~])", 8), true)));
        GrammarUtils.insertBeforeToken(extend, "function", Prism4j.token("annotation", Prism4j.pattern(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")));
        GrammarUtils.insertBeforeToken(extend, "class-name", Prism4j.token("generics", Prism4j.pattern(Pattern.compile("<\\s*\\w+(?:\\.\\w+)?(?:\\s*,\\s*\\w+(?:\\.\\w+)?)*>", 2), false, false, "function", Prism4j.grammar("inside", token, Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[<>(),.:]")))))));
        return extend;
    }
}
