package io.noties.prism4j.languages;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.ss.android.download.api.constant.Downloads;
import com.xiaomi.mipush.sdk.Constants;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_brainfuck {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("brainfuck", Prism4j.token("pointer", Prism4j.pattern(Pattern.compile("<|>"), false, false, "keyword")), Prism4j.token("increment", Prism4j.pattern(Pattern.compile("\\+"), false, false, "inserted")), Prism4j.token("decrement", Prism4j.pattern(Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SERVER), false, false, Downloads.Impl.COLUMN_DELETED)), Prism4j.token("branching", Prism4j.pattern(Pattern.compile("\\[|\\]"), false, false, "important")), Prism4j.token(OnekeyLoginConstants.CU_KEY_OPERATOR, Prism4j.pattern(Pattern.compile("[.,]"))), Prism4j.token("comment", Prism4j.pattern(Pattern.compile("\\S+"))));
    }
}
