package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.android.anniex.assemble.AnnieX;
import com.bytedance.sdk.account.platform.api.IWeixinService;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.net.URLDecoder;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* compiled from: XBridgeAuthRecoveryManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0006J\u001e\u0010\u0016\u001a\u00020\r2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00182\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/XBridgeAuthRecoveryManager;", "", "()V", "MIN_AUTO_REQUEST_INTERNAL", "", "TAG", "", "configProvider", "Lcom/bytedance/sdk/xbridge/cn/auth/XBridgeRecoveryConfigProvider;", "lastRequestStamp", "Ljava/lang/Long;", "getMinAutoRequestInternal", "isPatternMatch", "", ReportConstant.COMMON_CONTENT, "pattern", "onAppShow", "", "setConfigProvider", "skipAllAuth", "skipAuth", IWeixinService.ResponseConstants.URL, "verifyUrl", "safeUrls", "", "remoteUrl", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBridgeAuthRecoveryManager {
    public static final XBridgeAuthRecoveryManager INSTANCE = new XBridgeAuthRecoveryManager();
    private static final long MIN_AUTO_REQUEST_INTERNAL = 900;
    private static final String TAG = "XBridgeAuthRecoveryManager";
    private static XBridgeRecoveryConfigProvider configProvider;
    private static Long lastRequestStamp;

    private XBridgeAuthRecoveryManager() {
    }

    public final void setConfigProvider(XBridgeRecoveryConfigProvider configProvider2) {
        Intrinsics.checkNotNullParameter(configProvider2, "configProvider");
        XBridge.log("XBridgeAuthRecoveryManager.setConfigProvider: configProvider=" + configProvider2.getClass().getName());
        configProvider = configProvider2;
        if (lastRequestStamp == null) {
            lastRequestStamp = Long.valueOf(System.currentTimeMillis());
        }
    }

    public final boolean skipAllAuth() {
        XBridgeRecoveryConfigProvider xBridgeRecoveryConfigProvider = configProvider;
        if (xBridgeRecoveryConfigProvider != null) {
            return xBridgeRecoveryConfigProvider.isCloseAllAuth();
        }
        return false;
    }

    public final boolean skipAuth(String url) {
        List<String> emptyList;
        Intrinsics.checkNotNullParameter(url, IWeixinService.ResponseConstants.URL);
        if (skipAllAuth()) {
            return true;
        }
        XBridgeRecoveryConfigProvider xBridgeRecoveryConfigProvider = configProvider;
        if (xBridgeRecoveryConfigProvider == null || (emptyList = xBridgeRecoveryConfigProvider.getCloseAuthUrls()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        if (emptyList.isEmpty()) {
            return false;
        }
        return verifyUrl(emptyList, url);
    }

    public final void onAppShow() {
        XBridge.log("XBridgeAuthRecoveryManager.onAppShow");
        XBridgeRecoveryConfigProvider xBridgeRecoveryConfigProvider = configProvider;
        boolean z = false;
        if (xBridgeRecoveryConfigProvider != null && xBridgeRecoveryConfigProvider.enableAuthConfigRequest()) {
            z = true;
        }
        if (z) {
            XBridgeRecoveryConfigProvider xBridgeRecoveryConfigProvider2 = configProvider;
            long authRequestInterval = xBridgeRecoveryConfigProvider2 != null ? xBridgeRecoveryConfigProvider2.authRequestInterval() : 3600L;
            long coerceAtLeast = RangesKt.coerceAtLeast(authRequestInterval, getMinAutoRequestInternal());
            XBridge.log("lastRequestStamp :" + lastRequestStamp + ", expectInterval:" + authRequestInterval + ", realInterval:" + coerceAtLeast);
            Long l = lastRequestStamp;
            if (l != null) {
                if (System.currentTimeMillis() - l.longValue() > coerceAtLeast * 1000) {
                    IPermissionConfigProvider currentPermissionConfigProvider$anniex_release = BDXBridgePermission.INSTANCE.getCurrentPermissionConfigProvider$anniex_release();
                    if (currentPermissionConfigProvider$anniex_release != null) {
                        XBridge.log("update BDXBridgePermission");
                        BDXBridgePermission.INSTANCE.init(currentPermissionConfigProvider$anniex_release);
                    }
                    lastRequestStamp = Long.valueOf(System.currentTimeMillis());
                }
            }
        }
    }

    private final long getMinAutoRequestInternal() {
        if (AnnieX.isDebug()) {
            return 1L;
        }
        return MIN_AUTO_REQUEST_INTERNAL;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean verifyUrl(List<String> safeUrls, String remoteUrl) {
        String str;
        try {
            Result.Companion companion = Result.Companion;
            XBridgeAuthRecoveryManager xBridgeAuthRecoveryManager = this;
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
            XBridgeAuthRecoveryManager xBridgeAuthRecoveryManager2 = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(str2, IWeixinService.ResponseConstants.URL);
            if (xBridgeAuthRecoveryManager2.isPatternMatch(str2, str3)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isPatternMatch(String content, String pattern) {
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
