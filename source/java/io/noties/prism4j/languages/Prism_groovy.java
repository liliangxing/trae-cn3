package io.noties.prism4j.languages;

import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_groovy {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar extend = GrammarUtils.extend(GrammarUtils.require(prism4j, "clike"), "groovy", Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:as|def|in|abstract|assert|boolean|break|byte|case|catch|char|class|const|continue|default|do|double|else|enum|extends|final|finally|float|for|goto|if|implements|import|instanceof|int|interface|long|native|new|package|private|protected|public|return|short|static|strictfp|super|switch|synchronized|this|throw|throws|trait|transient|try|void|volatile|while)\\b"))), Prism4j.token(WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.pattern(Pattern.compile("(\"\"\"|''')[\\s\\S]*?\\1|(?:\\$\\/)(?:\\$\\/\\$|[\\s\\S])*?\\/\\$"), false, true), Prism4j.pattern(Pattern.compile("([\"'\\/])(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b(?:0b[01_]+|0x[\\da-f_]+(?:\\.[\\da-f_p\\-]+)?|[\\d_]+(?:\\.[\\d_]+)?(?:e[+-]?[\\d]+)?)[glidf]?\\b", 2))), Prism4j.token("operator", Prism4j.pattern(Pattern.compile("(^|[^.])(?:~|==?~?|\\?[.:]?|\\*(?:[.=]|\\*=?)?|\\.[@&]|\\.\\.<|\\.{1,2}(?!\\.)|-[-=>]?|\\+[+=]?|!=?|<(?:<=?|=>?)?|>(?:>>?=?|=)?|&[&=]?|\\|[|=]?|\\/=?|\\^=?|%=?)"), true)), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("\\.+|[{}\\[\\];(),:$]"))));
        GrammarUtils.insertBeforeToken(extend, WsChannelMultiProcessSharedProvider.STRING_TYPE, Prism4j.token("shebang", Prism4j.pattern(Pattern.compile("#!.+"), false, false, "comment")));
        GrammarUtils.insertBeforeToken(extend, "punctuation", Prism4j.token("spock-block", Prism4j.pattern(Pattern.compile("\\b(?:setup|given|when|then|and|cleanup|expect|where):"))));
        GrammarUtils.insertBeforeToken(extend, "function", Prism4j.token("annotation", Prism4j.pattern(Pattern.compile("(^|[^.])@\\w+"), true, false, "punctuation")));
        return extend;
    }
}
