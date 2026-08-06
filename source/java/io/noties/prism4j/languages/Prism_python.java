package io.noties.prism4j.languages;

import com.bytedance.forest.model.SourceType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_python {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("python", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("(^|[^\\\\])#.*"), true)), Prism4j.token("triple-quoted-string", Prism4j.pattern(Pattern.compile("(\"\"\"|''')[\\s\\S]+?\\1"), false, true, "string")), Prism4j.token("string", Prism4j.pattern(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token("function", Prism4j.pattern(Pattern.compile("((?:^|\\s)def[ \\t]+)[a-zA-Z_]\\w*(?=\\s*\\()"), true)), Prism4j.token("class-name", Prism4j.pattern(Pattern.compile("(\\bclass\\s+)\\w+", 2), true)), Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("\\b(?:as|assert|async|await|break|class|continue|def|del|elif|else|except|exec|finally|for|from|global|if|import|in|is|lambda|nonlocal|pass|print|raise|return|try|while|with|yield)\\b"))), Prism4j.token(SourceType.BUILTIN, Prism4j.pattern(Pattern.compile("\\b(?:__import__|abs|all|any|apply|ascii|basestring|bin|bool|buffer|bytearray|bytes|callable|chr|classmethod|cmp|coerce|compile|complex|delattr|dict|dir|divmod|enumerate|eval|execfile|file|filter|float|format|frozenset|getattr|globals|hasattr|hash|help|hex|id|input|int|intern|isinstance|issubclass|iter|len|list|locals|long|map|max|memoryview|min|next|object|oct|open|ord|pow|property|range|raw_input|reduce|reload|repr|reversed|round|set|setattr|slice|sorted|staticmethod|str|sum|super|tuple|type|unichr|unicode|vars|xrange|zip)\\b"))), Prism4j.token("boolean", Prism4j.pattern(Pattern.compile("\\b(?:True|False|None)\\b"))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("(?:\\b(?=\\d)|\\B(?=\\.))(?:0[bo])?(?:(?:\\d|0x[\\da-f])[\\da-f]*\\.?\\d*|\\.\\d+)(?:e[+-]?\\d+)?j?\\b", 2))), Prism4j.token(OnekeyLoginConstants.CU_KEY_OPERATOR, Prism4j.pattern(Pattern.compile("[-+%=]=?|!=|\\*\\*?=?|\\/\\/?=?|<[<=>]?|>[=>]?|[&|^~]|\\b(?:or|and|not)\\b"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[{}\\[\\];(),.:]"))));
    }
}
