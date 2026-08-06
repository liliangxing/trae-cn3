package io.noties.prism4j.languages;

import com.bytedance.forest.model.PreloadConfig;
import io.noties.prism4j.GrammarUtils;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Prism_css_extras {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        Prism4j.Grammar grammar = prism4j.grammar(PreloadConfig.KEY_STYLESHEET);
        if (grammar != null) {
            Prism4j.Token findToken = GrammarUtils.findToken(grammar, "selector");
            if (findToken != null) {
                Prism4j.Pattern pattern = Prism4j.pattern(Pattern.compile("[^{}\\s][^{}]*(?=\\s*\\{)"), false, false, null, Prism4j.grammar("inside", Prism4j.token("pseudo-element", Prism4j.pattern(Pattern.compile(":(?:after|before|first-letter|first-line|selection)|::[-\\w]+"))), Prism4j.token("pseudo-class", Prism4j.pattern(Pattern.compile(":[-\\w]+(?:\\(.*\\))?"))), Prism4j.token("class", Prism4j.pattern(Pattern.compile("\\.[-:.\\w]+"))), Prism4j.token("id", Prism4j.pattern(Pattern.compile("#[-:.\\w]+"))), Prism4j.token("attribute", Prism4j.pattern(Pattern.compile("\\[[^\\]]+\\]")))));
                findToken.patterns().clear();
                findToken.patterns().add(pattern);
            }
            GrammarUtils.insertBeforeToken(grammar, "function", Prism4j.token("hexcode", Prism4j.pattern(Pattern.compile("#[\\da-f]{3,8}", 2))), Prism4j.token("entity", Prism4j.pattern(Pattern.compile("\\\\[\\da-f]{1,8}", 2))), Prism4j.token("number", Prism4j.pattern(Pattern.compile("[\\d%.]+"))));
        }
        return null;
    }
}
