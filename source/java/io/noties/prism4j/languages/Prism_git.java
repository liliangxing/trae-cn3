package io.noties.prism4j.languages;

import com.heytap.mcssdk.constant.b;
import com.ss.android.download.api.constant.Downloads;
import io.noties.prism4j.Prism4j;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class Prism_git {
    public static Prism4j.Grammar create(Prism4j prism4j) {
        return Prism4j.grammar("git", Prism4j.token("comment", Prism4j.pattern(Pattern.compile("^#.*", 8))), Prism4j.token(Downloads.Impl.COLUMN_DELETED, Prism4j.pattern(Pattern.compile("^[-–].*", 8))), Prism4j.token("inserted", Prism4j.pattern(Pattern.compile("^\\+.*", 8))), Prism4j.token("string", Prism4j.pattern(Pattern.compile("(\"|')(?:\\\\.|(?!\\1)[^\\\\\\r\\n])*\\1", 8))), Prism4j.token(b.y, Prism4j.pattern(Pattern.compile("^.*\\$ git .*$", 8), false, false, null, Prism4j.grammar("inside", Prism4j.token("parameter", Prism4j.pattern(Pattern.compile("\\s--?\\w+", 8)))))), Prism4j.token("coord", Prism4j.pattern(Pattern.compile("^@@.*@@$", 8))), Prism4j.token("commit_sha1", Prism4j.pattern(Pattern.compile("^commit \\w{40}$", 8))));
    }
}
