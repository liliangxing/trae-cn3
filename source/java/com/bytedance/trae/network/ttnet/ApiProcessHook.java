package com.bytedance.trae.network.ttnet;

import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Level;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.network.E2ENetworkOverrides;
import com.bytedance.ttnet.http.HttpRequestInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TTNetExt.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u001e\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J1\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0016¢\u0006\u0002\u0010\u0015J*\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u001d\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J$\u0010\u001f\u001a\u00020\u00172\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010!\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/network/ttnet/ApiProcessHook;", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "<init>", "()V", "TAG", "", "hasDeviceId", "", "addCommonParams", "url", "isApi", "getCommonParamsByLevel", "", "level", "", "addRequestVertifyParams", "isAddCommonParam", "extra", "", "", "(Ljava/lang/String;Z[Ljava/lang/Object;)Ljava/lang/String;", "handleApiError", "", "e", "", "time", "", "info", "handleApiOk", "onTryInit", "putCommonParams", "params", "waitDidandBDAccountCallback", "ttnet_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ApiProcessHook implements NetworkParams.ApiProcessHook<HttpRequestInfo> {
    public static final ApiProcessHook INSTANCE = new ApiProcessHook();
    public static final String TAG = "ApiProcessHook";
    private static boolean hasDeviceId;

    public String addRequestVertifyParams(String url, boolean isAddCommonParam, Object... extra) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(extra, "extra");
        return url;
    }

    public Map<String, String> getCommonParamsByLevel(int level) {
        return null;
    }

    public void handleApiError(String url, Throwable e, long time, HttpRequestInfo info) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(e, "e");
    }

    public void handleApiOk(String url, long time, HttpRequestInfo info) {
        Intrinsics.checkNotNullParameter(url, "url");
    }

    public void onTryInit() {
    }

    public void putCommonParams(Map<String, String> params, boolean isApi) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    private ApiProcessHook() {
    }

    public String addCommonParams(String url, boolean isApi) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (!E2ENetworkOverrides.INSTANCE.shouldBypassAppLogDidWaitForMockE2E()) {
            waitDidandBDAccountCallback(url);
        }
        String addNetCommonParams = AppLog.addNetCommonParams(AppHost.Companion.getApplication(), url, isApi, Level.L1);
        Intrinsics.checkNotNullExpressionValue(addNetCommonParams, "addNetCommonParams(...)");
        return addNetCommonParams;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:2|3|(3:8|(4:15|16|(6:17|(2:22|(1:31))|33|(1:24)|29|31)|27)|12)|36|(1:10)|15|16|(6:17|(5:19|22|(0)|29|31)|33|(0)|29|31)|27|12) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0056, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0057, code lost:
    
        r0 = kotlin.Result.Companion;
        kotlin.Result.constructor-impl(kotlin.ResultKt.createFailure(r5));
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[Catch: all -> 0x0056, TryCatch #1 {all -> 0x0056, blocks: (B:16:0x0023, B:17:0x0029, B:19:0x0031, B:24:0x003d, B:27:0x0050, B:31:0x0047), top: B:15:0x0023, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void waitDidandBDAccountCallback(String url) {
        boolean z;
        int i;
        String did;
        boolean z2;
        Intrinsics.checkNotNullParameter(url, "url");
        String did2 = AppLog.getDid();
        if (did2 != null && did2.length() != 0) {
            z = false;
            if (!z || AppLog.getBDAccountCallback() == null) {
                Result.Companion companion = Result.Companion;
                ApiProcessHook apiProcessHook = this;
                i = 0;
                while (true) {
                    did = AppLog.getDid();
                    if (did != null && did.length() != 0) {
                        z2 = false;
                        if ((!z2 || AppLog.getBDAccountCallback() == null) && i < 5000) {
                            i += 50;
                            Thread.sleep(50);
                        }
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    i += 50;
                    Thread.sleep(50);
                }
                Result.constructor-impl(Unit.INSTANCE);
            }
        }
        z = true;
        if (!z) {
        }
        Result.Companion companion2 = Result.Companion;
        ApiProcessHook apiProcessHook2 = this;
        i = 0;
        while (true) {
            did = AppLog.getDid();
            if (did != null) {
                z2 = false;
                if (!z2) {
                }
                i += 50;
                Thread.sleep(50);
            }
            z2 = true;
            if (!z2) {
            }
            i += 50;
            Thread.sleep(50);
        }
        Result.constructor-impl(Unit.INSTANCE);
    }
}
