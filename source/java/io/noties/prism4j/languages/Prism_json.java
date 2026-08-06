package io.noties.prism4j.languages;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.xiaomi.mipush.sdk.Constants;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_json {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("json", Prism4j.token("property", Prism4j.pattern(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?=\\s*:)", 2))), Prism4j.token("string", Prism4j.pattern(Pattern.compile("\"(?:\\\\.|[^\\\\\"\\r\\n])*\"(?!\\s*:)"), false, true)), Prism4j.token("number", Prism4j.pattern(Pattern.compile("\\b0x[\\dA-Fa-f]+\\b|(?:\\b\\d+\\.?\\d*|\\B\\.\\d+)(?:[Ee][+-]?\\d+)?"))), Prism4j.token("punctuation", Prism4j.pattern(Pattern.compile("[{}\\[\\]);,]"))), Prism4j.token(OnekeyLoginConstants.CU_KEY_OPERATOR, Prism4j.pattern(Pattern.compile(Constants.COLON_SEPARATOR))), Prism4j.token("boolean", Prism4j.pattern(Pattern.compile("\\b(?:true|false)\\b", 2))), Prism4j.token("null", Prism4j.pattern(Pattern.compile("\\bnull\\b", 2))));
    }
}
