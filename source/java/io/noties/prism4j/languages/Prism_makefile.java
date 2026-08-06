package io.noties.prism4j.languages;

import com.bytedance.forest.model.SourceType;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_makefile {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("makefile", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("(^|[^\\\\])#(?:\\\\(?:\\r\\n|[\\s\\S])|[^\\\\\\r\\n])*"), true)), Prism4j.token("string", Prism4j.pattern(Pattern.compile("([\"'])(?:\\\\(?:\\r\\n|[\\s\\S])|(?!\\1)[^\\\\\\r\\n])*\\1"), false, true)), Prism4j.token(SourceType.BUILTIN, Prism4j.pattern(Pattern.compile("\\.[A-Z][^:#=\\s]+(?=\\s*:(?!=))"))), Prism4j.token("symbol", Prism4j.pattern(Pattern.compile("^[^:=\\r\\n]+(?=\\s*:(?!=))", 8), false, false, null, Prism4j.grammar("inside", Prism4j.token("variable", Prism4j.pattern(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|(?=[({]))")))))), Prism4j.token("variable", Prism4j.pattern(Pattern.compile("\\$+(?:[^(){}:#=\\s]+|\\([@*%<^+?][DF]\\)|(?=[({]))"))), Prism4j.token("keyword", Prism4j.pattern(Pattern.compile("-include\\b|\\b(?:define|else|endef|endif|export|ifn?def|ifn?eq|include|override|private|sinclude|undefine|unexport|vpath)\\b")), Prism4j.pattern(Pattern.compile("(\\()(?:addsuffix|abspath|and|basename|call|dir|error|eval|file|filter(?:-out)?|findstring|firstword|flavor|foreach|guile|if|info|join|lastword|load|notdir|or|origin|patsubst|realpath|shell|sort|strip|subst|suffix|value|warning|wildcard|word(?:s|list)?)(?=[ \\t])"), true)), Prism4j.token(OnekeyLoginConstants.CU_KEY_OPERATOR, Prism4j.pattern(Pattern.compile("(?:::|[?:+!])?=|[|@]"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[:;(){}]"))));
    }
}
