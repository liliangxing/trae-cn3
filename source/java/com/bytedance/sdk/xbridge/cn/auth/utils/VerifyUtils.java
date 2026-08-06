package com.bytedance.sdk.xbridge.cn.auth.utils;

import android.util.Log;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: VerifyUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\tJ#\u0010\n\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\r\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/utils/VerifyUtils;", "", "()V", "TAG", "", "isPatternMatch", "", ReportConstant.COMMON_CONTENT, "pattern", "isPatternMatch$anniex_release", "verifyUrl", "safeUrls", "", "remoteUrl", "verifyUrl$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VerifyUtils {
    public static final VerifyUtils INSTANCE = new VerifyUtils();
    private static final String TAG = "VerifyUtils";

    private VerifyUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean verifyUrl$anniex_release(List<String> safeUrls, String remoteUrl) {
        String str;
        Intrinsics.checkNotNullParameter(safeUrls, "safeUrls");
        Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
        Log.d(TAG, "remoteUrl: " + remoteUrl);
        try {
            Result.Companion companion = Result.Companion;
            VerifyUtils verifyUtils = this;
            str = Result.constructor-impl(URLDecoder.decode(remoteUrl, Charsets.UTF_8.name()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            str = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.exceptionOrNull-impl(str) == null) {
            remoteUrl = str;
        }
        String str2 = remoteUrl;
        List<String> list = safeUrls;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        for (String str3 : list) {
            Log.d(TAG, "safeUrl: " + str3 + ", remoteUrl: " + str2);
            VerifyUtils verifyUtils2 = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str2, IWeixinService.ResponseConstants.URL);
            if (verifyUtils2.isPatternMatch$anniex_release(str2, str3)) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPatternMatch$anniex_release(String content, String pattern) {
        Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        try {
            Result.Companion companion = Result.Companion;
            return Pattern.compile(pattern).matcher(content).find();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            return false;
        }
    }
}
