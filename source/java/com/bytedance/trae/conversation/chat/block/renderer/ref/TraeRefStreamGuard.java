package com.bytedance.trae.conversation.chat.block.renderer.ref;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: TraeRefStreamGuard.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0002\u0010\u000eJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefStreamGuard;", "", "<init>", "()V", "TRAE_REF_PATTERN", "Ljava/util/regex/Pattern;", "getTRAE_REF_PATTERN", "()Ljava/util/regex/Pattern;", "TOKEN_HEAD", "", "TOKEN_HEAD_WITH_PAREN", "findIncompleteTRAERef", "", AccountMonitorConstants.CommonParameter.RAW, "(Ljava/lang/String;)Ljava/lang/Integer;", "findTrailingPartialHead", "safeTruncate", "canEmit", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TraeRefStreamGuard {
    public static final TraeRefStreamGuard INSTANCE = new TraeRefStreamGuard();
    private static final String TOKEN_HEAD = "[$TRAE_REF]";
    private static final String TOKEN_HEAD_WITH_PAREN = "[$TRAE_REF](";
    private static final Pattern TRAE_REF_PATTERN;

    private TraeRefStreamGuard() {
    }

    static {
        Pattern compile = Pattern.compile("\\[\\$TRAE_REF\\]\\((https?://[^)\\s]+)\\)");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(...)");
        TRAE_REF_PATTERN = compile;
    }

    public final Pattern getTRAE_REF_PATTERN() {
        return TRAE_REF_PATTERN;
    }

    public final Integer findIncompleteTRAERef(String raw) {
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        String str = raw;
        if (str.length() == 0) {
            return null;
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(str, TOKEN_HEAD, 0, false, 6, (Object) null);
        if (lastIndexOf$default >= 0) {
            String substring = raw.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            Matcher matcher = TRAE_REF_PATTERN.matcher(substring);
            if (!matcher.lookingAt() || matcher.start() != 0) {
                return Integer.valueOf(lastIndexOf$default);
            }
        }
        Integer findTrailingPartialHead = findTrailingPartialHead(raw);
        if (findTrailingPartialHead != null) {
            return findTrailingPartialHead;
        }
        return null;
    }

    private final Integer findTrailingPartialHead(String raw) {
        CollectionsKt.listOf(new String[]{TOKEN_HEAD_WITH_PAREN, TOKEN_HEAD});
        for (int i = 11; i > 0; i--) {
            String substring = TOKEN_HEAD.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            if (StringsKt.endsWith$default(raw, substring, false, 2, (Object) null) && !StringsKt.endsWith$default(raw, TOKEN_HEAD, false, 2, (Object) null)) {
                return Integer.valueOf(raw.length() - i);
            }
        }
        int lastIndexOf$default = StringsKt.lastIndexOf$default(raw, TOKEN_HEAD_WITH_PAREN, 0, false, 6, (Object) null);
        if (lastIndexOf$default >= 0) {
            String substring2 = raw.substring(lastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            if (!StringsKt.contains$default(substring2, ")", false, 2, (Object) null)) {
                return Integer.valueOf(lastIndexOf$default);
            }
        }
        return null;
    }

    public final String safeTruncate(String raw) {
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        Integer findIncompleteTRAERef = findIncompleteTRAERef(raw);
        if (findIncompleteTRAERef == null) {
            return raw;
        }
        String substring = raw.substring(0, findIncompleteTRAERef.intValue());
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    public final boolean canEmit(String raw) {
        Intrinsics.checkNotNullParameter(raw, AccountMonitorConstants.CommonParameter.RAW);
        return findIncompleteTRAERef(raw) == null;
    }
}
