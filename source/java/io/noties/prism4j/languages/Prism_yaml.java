package io.noties.prism4j.languages;

import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_yaml {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("yaml", Prism4j.token("scalar", Prism4j.pattern(Pattern.compile("([\\-:]\\s*(?:![^\\s]+)?[ \\t]*[|>])[ \\t]*(?:((?:\\r?\\n|\\r)[ \\t]+)[^\\r\\n]+(?:\\2[^\\r\\n]+)*)"), true, false, "string")), Prism4j.token("comment", Prism4j.pattern(Pattern.compile("#.*"))), Prism4j.token("key", Prism4j.pattern(Pattern.compile("(\\s*(?:^|[:\\-,\\[{\\r\\n?])[ \\t]*(?:![^\\s]+)?[ \\t]*)[^\\r\\n{\\[\\]},#\\s]+?(?=\\s*:\\s)"), true, false, "atrule")), Prism4j.token("directive", Prism4j.pattern(Pattern.compile("(^[ \\t]*)%.+", 8), true, false, "important")), Prism4j.token("datetime", Prism4j.pattern(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:\\d{4}-\\d\\d?-\\d\\d?(?:[tT]|[ \\t]+)\\d\\d?:\\d{2}:\\d{2}(?:\\.\\d*)?[ \\t]*(?:Z|[-+]\\d\\d?(?::\\d{2})?)?|\\d{4}-\\d{2}-\\d{2}|\\d\\d?:\\d{2}(?::\\d{2}(?:\\.\\d*)?)?)(?=[ \\t]*(?:$|,|]|\\}))", 8), true, false, "number")), Prism4j.token("boolean", Prism4j.pattern(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:true|false)[ \\t]*(?=$|,|]|\\})", 10), true, false, "important")), Prism4j.token("null", Prism4j.pattern(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(?:null|~)[ \\t]*(?=$|,|]|\\})", 10), true, false, "important")), Prism4j.token("string", Prism4j.pattern(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)(\"|')(?:(?!\\2)[^\\\\\\r\\n]|\\\\.)*\\2(?=[ \\t]*(?:$|,|]|\\}))", 8), true, true)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("([:\\-,\\[{]\\s*(?:![^\\s]+)?[ \\t]*)[+-]?(?:0x[\\da-f]+|0o[0-7]+|(?:\\d+\\.?\\d*|\\.?\\d+)(?:e[+-]?\\d+)?|\\.inf|\\.nan)[ \\t]*(?=$|,|]|\\})", 10), true)), Prism4j.token("tag", Prism4j.pattern(Pattern.compile("![^\\s]+"))), Prism4j.token("important", Prism4j.pattern(Pattern.compile("[&*][\\w]+"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("---|[:\\[\\]{}\\-,|>?]|\\.\\.\\."))));
    }
}
