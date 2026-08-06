package io.noties.prism4j.languages;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class Prism_clike {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("clike", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("(^|[^\\\\])\\/\\*[\\s\\S]*?(?:\\*\\/|$)"), true), Prism4j.pattern(Pattern.compile("(^|[^\\\\:])\\/\\/.*"), true, true)), Prism4j.token("string", Prism4j.pattern(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token("class-name", Prism4j.pattern(Pattern.compile("((?:\\b(?:class|interface|extends|implements|trait|instanceof|new)\\s+)|(?:catch\\s+\\())[\\w.\\\\]+"), true, false, null, Prism4j.grammar("inside", Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[.\\\\]")))))), Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:if|else|while|do|for|return|in|instanceof|function|new|try|throw|catch|finally|null|break|continue)\\b"))), Prism4j.token("boolean", Prism4j.pattern(Pattern.compile("\\b(?:true|false)\\b"))), Prism4j.token("function", Prism4j.pattern(Pattern.compile("[a-z0-9_]+(?=\\()", 2))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b0x[\\da-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:e[+-]?\\d+)?", 2))), Prism4j.token(OnekeyLoginConstants.CU_KEY_OPERATOR, Prism4j.pattern(Pattern.compile("--?|\\+\\+?|!=?=?|<=?|>=?|==?=?|&&?|\\|\\|?|\\?|\\*|\\/|~|\\^|%"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[{}\\[\\];(),.:]"))));
    }

    private Prism_clike() {
    }
}
