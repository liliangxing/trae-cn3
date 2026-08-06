package com.bytedance.geckox.net;

import android.util.Pair;
import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.android.sdk.bdticketguard.TicketGuardApiKt;
import com.bytedance.android.sdk.bdticketguard.TicketGuardProviderKt;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.geckox.AppSettingsManager;
import com.bytedance.geckox.GeckoGlobalConfig;
import com.bytedance.geckox.GeckoGlobalManager;
import com.bytedance.geckox.gson.GsonUtil;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.probe.ProbeManager;
import com.bytedance.geckox.utils.LibLoader;
import com.bytedance.geckox.utils.SPManager;
import com.bytedance.iesgurd.core.CacheManager;
import com.bytedance.iesgurd.model.RequestBodyBase;
import com.bytedance.iesgurd.settings.GlobalSettingsManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: RequestExecutor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBJ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u001b\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0082 J\b\u0010\u0017\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u001a\u001a\u00020\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/bytedance/geckox/net/RequestExecutor;", "", ReportConst.ValidationReport.BODY, "Lcom/bytedance/iesgurd/model/RequestBodyBase;", "url", "", "isAuto", "", "probe", "onFinish", "Lkotlin/Function1;", "Lcom/bytedance/geckox/net/Response;", "Lkotlin/ParameterName;", "name", ApmTrafficStats.TTNET_RESPONSE, "", "(Lcom/bytedance/iesgurd/model/RequestBodyBase;Ljava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;)V", "deleteResAfterSwitchEnv", "config", "Lcom/bytedance/geckox/GeckoGlobalConfig;", TicketGuardProviderKt.PATH_ENCRYPT, "requestBody", com.bytedance.applog.server.Api.KEY_ENCRYPT_RESP_KEY, "postRequest", "proceedRequest", "hash", "run", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class RequestExecutor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RequestBodyBase body;
    private final boolean isAuto;
    private final Function1<Response, Unit> onFinish;
    private final String probe;
    private final String url;

    private final native void encrypt(String requestBody, String key) throws Throwable;

    /* JADX WARN: Multi-variable type inference failed */
    public RequestExecutor(RequestBodyBase requestBodyBase, String str, boolean z, String str2, Function1<? super Response, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(requestBodyBase, ReportConst.ValidationReport.BODY);
        Intrinsics.checkParameterIsNotNull(str, "url");
        Intrinsics.checkParameterIsNotNull(function1, "onFinish");
        this.body = requestBodyBase;
        this.url = str;
        this.isAuto = z;
        this.probe = str2;
        this.onFinish = function1;
    }

    /* compiled from: RequestExecutor.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/geckox/net/RequestExecutor$Companion;", "", "()V", "getLogId", "", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/geckox/net/Response;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getLogId(Response response) {
            Intrinsics.checkParameterIsNotNull(response, ApmTrafficStats.TTNET_RESPONSE);
            Map<String, String> map = response.headers;
            if (map == null || map.isEmpty()) {
                return "";
            }
            String str = map.get("x-tt-logid");
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                return str;
            }
            String str3 = map.get(TicketGuardApiKt.HEADER_LOGID);
            String str4 = str3;
            if (!(str4 == null || str4.length() == 0)) {
                return str3;
            }
            String str5 = map.get("X-TT-LOGID");
            String str6 = str5;
            return !(str6 == null || str6.length() == 0) ? str5 : "";
        }
    }

    static {
        LibLoader.INSTANCE.loadLib("gecko_encrypt");
    }

    public final void run() throws Throwable {
        AppSettingsManager inst = AppSettingsManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "AppSettingsManager.inst()");
        AppSettingsManager.IGeckoAppSettings geckoAppSettings = inst.getGeckoAppSettings();
        if (geckoAppSettings == null || geckoAppSettings.isUseEncrypt()) {
            encrypt(this.body.getCommon().getEncryptStr(), this.body.getAuth().getRandom());
        } else {
            postRequest();
        }
    }

    public final void proceedRequest(String hash) {
        if (hash != null) {
            this.body.getAuth().setSign(StringsKt.trim(hash).toString());
        }
        postRequest();
    }

    private final void postRequest() {
        Response requestWithMethodPost;
        Pair<String, String> requestTagHeader;
        String json = GsonUtil.INSTANCE.inst().getGson().toJson(this.body);
        GeckoGlobalManager inst = GeckoGlobalManager.inst();
        Intrinsics.checkExpressionValueIsNotNull(inst, "GeckoGlobalManager.inst()");
        GeckoGlobalConfig globalConfig = inst.getGlobalConfig();
        Intrinsics.checkExpressionValueIsNotNull(globalConfig, "config");
        INetWork netWork = globalConfig.getNetWork();
        if (netWork instanceof IExtendNetWork) {
            HashMap hashMap = new HashMap();
            GeckoGlobalConfig.IRequestTagHeaderProvider requestTagHeaderProvider = globalConfig.getRequestTagHeaderProvider();
            if (requestTagHeaderProvider != null && (requestTagHeader = requestTagHeaderProvider.getRequestTagHeader(this.isAuto)) != null) {
                Object obj = requestTagHeader.first;
                Intrinsics.checkExpressionValueIsNotNull(obj, "header.first");
                Object obj2 = requestTagHeader.second;
                Intrinsics.checkExpressionValueIsNotNull(obj2, "header.second");
                hashMap.put(obj, obj2);
            }
            String str = this.probe;
            if (str != null) {
                hashMap.put("x-gecko-probe", str);
                ProbeManager.INSTANCE.uploadProbeEvent("request_start", str, this.url);
            }
            GeckoNetWorkRequest geckoNetWorkRequest = GeckoNetWorkRequest.INSTANCE;
            String str2 = this.url;
            Intrinsics.checkExpressionValueIsNotNull(json, "requestBodyStr");
            requestWithMethodPost = geckoNetWorkRequest.requestWithMethodPost(netWork, str2, json, hashMap);
        } else {
            GeckoNetWorkRequest geckoNetWorkRequest2 = GeckoNetWorkRequest.INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(netWork, "netWork");
            String str3 = this.url;
            Intrinsics.checkExpressionValueIsNotNull(json, "requestBodyStr");
            requestWithMethodPost = geckoNetWorkRequest2.requestWithMethodPost(netWork, str3, json, null);
        }
        deleteResAfterSwitchEnv(globalConfig, requestWithMethodPost);
        this.onFinish.invoke(requestWithMethodPost);
    }

    private final void deleteResAfterSwitchEnv(GeckoGlobalConfig config, Response response) {
        if (config.getEnv() == GeckoGlobalConfig.ENVType.PROD) {
            return;
        }
        String str = response.headers.get("X-Gecko-Tt-Env");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = response.headers.get("x-gecko-tt-env");
        }
        String string = SPManager.inst().getString(config.getContext(), "gecko_x_tt_env", null);
        if (str == null || !(!Intrinsics.areEqual(str, string))) {
            return;
        }
        GeckoLogger.m296d("X-Gecko-Tt-Env change from " + string + " to " + str + ", delete all resources");
        CacheManager.INSTANCE.deleteAll();
        GlobalSettingsManager.INSTANCE.cleanSettings();
        SPManager.inst().putString(config.getContext(), "gecko_x_tt_env", str);
    }
}
