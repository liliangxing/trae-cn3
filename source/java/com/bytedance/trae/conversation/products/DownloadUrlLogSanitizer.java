package com.bytedance.trae.conversation.products;

import com.bytedance.sdk.account.platform.api.IWeixinService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;

/* compiled from: FileDownloadHelper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/trae/conversation/products/DownloadUrlLogSanitizer;", "", "<init>", "()V", "sensitiveQueryParamRegex", "Lkotlin/text/Regex;", "redactSensitiveQueryParams", "", IWeixinService.ResponseConstants.URL, "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DownloadUrlLogSanitizer {
    public static final DownloadUrlLogSanitizer INSTANCE = new DownloadUrlLogSanitizer();
    private static final Regex sensitiveQueryParamRegex = new Regex("(?i)([?&]authorization=)[^&]*");

    private DownloadUrlLogSanitizer() {
    }

    public final String redactSensitiveQueryParams(String url) {
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        return sensitiveQueryParamRegex.replace(url, new Function1() { // from class: com.bytedance.trae.conversation.products.DownloadUrlLogSanitizer$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence redactSensitiveQueryParams$lambda$0;
                redactSensitiveQueryParams$lambda$0 = DownloadUrlLogSanitizer.redactSensitiveQueryParams$lambda$0((MatchResult) obj);
                return redactSensitiveQueryParams$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence redactSensitiveQueryParams$lambda$0(MatchResult matchResult) {
        Intrinsics.checkNotNullParameter(matchResult, "match");
        return ((String) matchResult.getGroupValues().get(1)) + "<redacted>";
    }
}
