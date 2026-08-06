package io.noties.prism4j.languages;

import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_latex {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Pattern compile = Pattern.compile("\\\\(?:[^a-z()\\[\\]]|[a-z*]+)", 2);
        Prism4j.Grammar grammar = Prism4j.grammar("inside", Prism4j.token("equation-command", Prism4j.pattern(compile, false, false, "regex")));
        return Prism4j.grammar("latex", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("%.*", 8))), Prism4j.token("cdata", Prism4j.pattern(Pattern.compile("(\\\\begin\\{((?:verbatim|lstlisting)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true)), Prism4j.token("equation", Prism4j.pattern(Pattern.compile("\\$(?:\\\\[\\s\\S]|[^\\\\$])*\\$|\\\\\\([\\s\\S]*?\\\\\\)|\\\\\\[[\\s\\S]*?\\\\\\]"), false, false, "string", grammar), Prism4j.pattern(Pattern.compile("(\\\\begin\\{((?:equation|math|eqnarray|align|multline|gather)\\*?)\\})[\\s\\S]*?(?=\\\\end\\{\\2\\})"), true, false, "string", grammar)), Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("(\\\\(?:begin|end|ref|cite|label|usepackage|documentclass)(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\})"), true)), Prism4j.token("url", Prism4j.pattern(Pattern.compile("(\\\\url\\{)[^}]+(?=\\})"), true)), Prism4j.token("headline", Prism4j.pattern(Pattern.compile("(\\\\(?:part|chapter|section|subsection|frametitle|subsubsection|paragraph|subparagraph|subsubparagraph|subsubsubparagraph)\\*?(?:\\[[^\\]]+\\])?\\{)[^}]+(?=\\}(?:\\[[^\\]]+\\])?)"), true, false, "class-name")), Prism4j.token("function", Prism4j.pattern(compile, false, false, "selector")), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[\\[\\]{}&]"))));
    }
}
