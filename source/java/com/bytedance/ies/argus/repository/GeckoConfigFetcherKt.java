package com.bytedance.ies.argus.repository;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.ies.argus.api.interfaces.ArgusGeckoResponse;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.base.ArgusMonitor;
import com.bytedance.ies.argus.bean.ArgusGlobalCommonConfig;
import com.bytedance.ies.argus.bean.ArgusInitSetting;
import com.bytedance.ies.argus.bean.ArgusMonitorKeyName;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import com.bytedance.ies.bullet.kit.resourceloader.loader.LoaderUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

/* compiled from: GeckoConfigFetcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a$\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¨\u0006\r"}, d2 = {"asyncFetchCdnConfig", "", "Lcom/bytedance/ies/argus/repository/ArgusConfigManager;", "configType", "Lcom/bytedance/ies/argus/repository/ArgusConfigType;", "retry", "", "asyncFetchOfflineConfig", "parseResponse", "fetchType", "Lcom/bytedance/ies/argus/repository/ArgusGeckoFetchType;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/bytedance/ies/argus/api/interfaces/ArgusGeckoResponse;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class GeckoConfigFetcherKt {

    /* compiled from: GeckoConfigFetcher.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArgusConfigType.values().length];
            try {
                iArr[ArgusConfigType.GLOBAL_CONFIG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArgusConfigType.CONTAINER_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void asyncFetchCdnConfig(ArgusConfigManager argusConfigManager, ArgusConfigType argusConfigType, boolean z) {
        Intrinsics.checkNotNullParameter(argusConfigManager, "<this>");
        Intrinsics.checkNotNullParameter(argusConfigType, "configType");
        BuildersKt.launch$default(argusConfigManager.getScope(), (CoroutineContext) null, (CoroutineStart) null, new GeckoConfigFetcherKt$asyncFetchCdnConfig$1(z, argusConfigType, argusConfigManager, null), 3, (Object) null);
    }

    public static final void asyncFetchOfflineConfig(ArgusConfigManager argusConfigManager, ArgusConfigType argusConfigType) {
        Intrinsics.checkNotNullParameter(argusConfigManager, "<this>");
        Intrinsics.checkNotNullParameter(argusConfigType, "configType");
        BuildersKt.launch$default(argusConfigManager.getScope(), (CoroutineContext) null, (CoroutineStart) null, new GeckoConfigFetcherKt$asyncFetchOfflineConfig$1(argusConfigType, argusConfigManager, null), 3, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00f1 A[Catch: Exception -> 0x03c1, TryCatch #2 {Exception -> 0x03c1, blocks: (B:3:0x0070, B:7:0x0092, B:8:0x0095, B:11:0x00a0, B:13:0x00d3, B:18:0x00e0, B:23:0x00f1, B:25:0x0138, B:27:0x013c, B:29:0x0142, B:30:0x01a0, B:32:0x01a6, B:34:0x01ac, B:38:0x01b9, B:42:0x0286, B:43:0x0324, B:45:0x0380, B:46:0x0387, B:49:0x03b8, B:53:0x02b8, B:54:0x01c4, B:56:0x01ca, B:58:0x01d0, B:60:0x01dd, B:61:0x01ea, B:67:0x01fa, B:69:0x01ff, B:72:0x0214, B:74:0x021f, B:79:0x0264, B:80:0x0259, B:81:0x025f, B:82:0x027a, B:94:0x020d, B:95:0x0210, B:96:0x01e0, B:101:0x02f3, B:63:0x01ec, B:65:0x01f1, B:90:0x020a), top: B:2:0x0070, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0138 A[Catch: Exception -> 0x03c1, TryCatch #2 {Exception -> 0x03c1, blocks: (B:3:0x0070, B:7:0x0092, B:8:0x0095, B:11:0x00a0, B:13:0x00d3, B:18:0x00e0, B:23:0x00f1, B:25:0x0138, B:27:0x013c, B:29:0x0142, B:30:0x01a0, B:32:0x01a6, B:34:0x01ac, B:38:0x01b9, B:42:0x0286, B:43:0x0324, B:45:0x0380, B:46:0x0387, B:49:0x03b8, B:53:0x02b8, B:54:0x01c4, B:56:0x01ca, B:58:0x01d0, B:60:0x01dd, B:61:0x01ea, B:67:0x01fa, B:69:0x01ff, B:72:0x0214, B:74:0x021f, B:79:0x0264, B:80:0x0259, B:81:0x025f, B:82:0x027a, B:94:0x020d, B:95:0x0210, B:96:0x01e0, B:101:0x02f3, B:63:0x01ec, B:65:0x01f1, B:90:0x020a), top: B:2:0x0070, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0286 A[Catch: Exception -> 0x03c1, TryCatch #2 {Exception -> 0x03c1, blocks: (B:3:0x0070, B:7:0x0092, B:8:0x0095, B:11:0x00a0, B:13:0x00d3, B:18:0x00e0, B:23:0x00f1, B:25:0x0138, B:27:0x013c, B:29:0x0142, B:30:0x01a0, B:32:0x01a6, B:34:0x01ac, B:38:0x01b9, B:42:0x0286, B:43:0x0324, B:45:0x0380, B:46:0x0387, B:49:0x03b8, B:53:0x02b8, B:54:0x01c4, B:56:0x01ca, B:58:0x01d0, B:60:0x01dd, B:61:0x01ea, B:67:0x01fa, B:69:0x01ff, B:72:0x0214, B:74:0x021f, B:79:0x0264, B:80:0x0259, B:81:0x025f, B:82:0x027a, B:94:0x020d, B:95:0x0210, B:96:0x01e0, B:101:0x02f3, B:63:0x01ec, B:65:0x01f1, B:90:0x020a), top: B:2:0x0070, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02b8 A[Catch: Exception -> 0x03c1, TryCatch #2 {Exception -> 0x03c1, blocks: (B:3:0x0070, B:7:0x0092, B:8:0x0095, B:11:0x00a0, B:13:0x00d3, B:18:0x00e0, B:23:0x00f1, B:25:0x0138, B:27:0x013c, B:29:0x0142, B:30:0x01a0, B:32:0x01a6, B:34:0x01ac, B:38:0x01b9, B:42:0x0286, B:43:0x0324, B:45:0x0380, B:46:0x0387, B:49:0x03b8, B:53:0x02b8, B:54:0x01c4, B:56:0x01ca, B:58:0x01d0, B:60:0x01dd, B:61:0x01ea, B:67:0x01fa, B:69:0x01ff, B:72:0x0214, B:74:0x021f, B:79:0x0264, B:80:0x0259, B:81:0x025f, B:82:0x027a, B:94:0x020d, B:95:0x0210, B:96:0x01e0, B:101:0x02f3, B:63:0x01ec, B:65:0x01f1, B:90:0x020a), top: B:2:0x0070, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c4 A[Catch: Exception -> 0x03c1, TryCatch #2 {Exception -> 0x03c1, blocks: (B:3:0x0070, B:7:0x0092, B:8:0x0095, B:11:0x00a0, B:13:0x00d3, B:18:0x00e0, B:23:0x00f1, B:25:0x0138, B:27:0x013c, B:29:0x0142, B:30:0x01a0, B:32:0x01a6, B:34:0x01ac, B:38:0x01b9, B:42:0x0286, B:43:0x0324, B:45:0x0380, B:46:0x0387, B:49:0x03b8, B:53:0x02b8, B:54:0x01c4, B:56:0x01ca, B:58:0x01d0, B:60:0x01dd, B:61:0x01ea, B:67:0x01fa, B:69:0x01ff, B:72:0x0214, B:74:0x021f, B:79:0x0264, B:80:0x0259, B:81:0x025f, B:82:0x027a, B:94:0x020d, B:95:0x0210, B:96:0x01e0, B:101:0x02f3, B:63:0x01ec, B:65:0x01f1, B:90:0x020a), top: B:2:0x0070, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void parseResponse(ArgusConfigManager argusConfigManager, ArgusConfigType argusConfigType, ArgusGeckoFetchType argusGeckoFetchType, ArgusGeckoResponse argusGeckoResponse) {
        JSONObject jSONObject;
        ArrayList arrayList;
        Long l;
        boolean z;
        boolean z2;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        BufferedReader bufferedReader;
        ArgusInitSetting innerInitSettings;
        Intrinsics.checkNotNullParameter(argusConfigManager, "<this>");
        Intrinsics.checkNotNullParameter(argusConfigType, "configType");
        Intrinsics.checkNotNullParameter(argusGeckoFetchType, "fetchType");
        Intrinsics.checkNotNullParameter(argusGeckoResponse, ApmTrafficStats.TTNET_RESPONSE);
        String str = "configType=" + argusConfigType.getStr() + ",fetchType=" + argusGeckoFetchType.getStr() + ",reqLogId=" + argusGeckoResponse.getRequestLogId() + ",fetchUrl=" + argusGeckoResponse.getFetchUrl();
        try {
            boolean isSucceed = argusGeckoResponse.isSucceed();
            ArrayList arrayList2 = new ArrayList();
            String msg = argusGeckoResponse.getMsg();
            String str2 = LoaderUtil.INSTANCE.isNotNullOrEmpty(msg) ? msg : null;
            if (str2 != null) {
                arrayList2.add(str2);
            }
            JSONObject jSONObject4 = new JSONObject();
            boolean z3 = false;
            if (isSucceed) {
                ArgusLog.i$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "fetch gecko success:" + str + ",msg=" + argusGeckoResponse.getMsg(), null, 4, null);
                String geckoVersion = argusGeckoResponse.getGeckoVersion();
                String str3 = geckoVersion;
                if (str3 != null && str3.length() != 0) {
                    z = false;
                    if (!z && Long.parseLong(geckoVersion) > 0) {
                        z2 = false;
                        if (z2) {
                            ArgusLog.e$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "gecko version " + geckoVersion + " is invalid when parse response. pkgInfo=" + str, null, null, 12, null);
                            argusGeckoResponse.setGeckoVersion(ArgusGeckoResponse.GeckoVersionId.PKG_NOT_FOUND.getString());
                            arrayList2.add("get gecko response but version(" + geckoVersion + ") is invalid");
                        }
                        if (z2) {
                            JSONObject jsonResponse = argusGeckoResponse.getJsonResponse();
                            if (jsonResponse == null) {
                                InputStream response = argusGeckoResponse.getResponse();
                                if (response != null) {
                                    Reader inputStreamReader = new InputStreamReader(response, Charsets.UTF_8);
                                    bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
                                } else {
                                    bufferedReader = null;
                                }
                                BufferedReader bufferedReader2 = bufferedReader;
                                try {
                                    BufferedReader bufferedReader3 = bufferedReader2;
                                    String readText = bufferedReader3 != null ? TextStreamsKt.readText(bufferedReader3) : null;
                                    jSONObject2 = null;
                                    CloseableKt.closeFinally(bufferedReader2, (Throwable) null);
                                    jsonResponse = readText != null ? new JSONObject(readText) : null;
                                } finally {
                                }
                            } else {
                                jSONObject2 = null;
                            }
                            JSONObject optJSONObject = jsonResponse != null ? jsonResponse.optJSONObject("data") : jSONObject2;
                            if (optJSONObject != null) {
                                Long valueOf = Long.valueOf(jsonResponse.optLong("create_time_stamp"));
                                jSONObject = jSONObject4;
                                arrayList = arrayList2;
                                ConfigInfo configInfo = new ConfigInfo(ConfigFrom.GECKO, null, valueOf, argusGeckoFetchType, argusGeckoResponse.getGeckoVersion(), 2, null);
                                int i = WhenMappings.$EnumSwitchMapping$0[argusConfigType.ordinal()];
                                if (i == 1) {
                                    argusConfigManager.onGlobalConfigUpdate$anniex_release(optJSONObject, configInfo);
                                } else if (i == 2) {
                                    argusConfigManager.onContainerConfigUpdate$anniex_release(optJSONObject, configInfo);
                                }
                                arrayList.add("finish parsing,pkg_time_stamp=" + valueOf);
                                jSONObject3 = valueOf;
                                z3 = true;
                            } else {
                                jSONObject = jSONObject4;
                                arrayList = arrayList2;
                                arrayList.add("pkg data key is null");
                                jSONObject3 = jSONObject2;
                            }
                        } else {
                            if (argusGeckoFetchType == ArgusGeckoFetchType.CDN) {
                                if (argusConfigManager.getGeckoCdnFetcherRetryLimit() > 0) {
                                    ArgusLog.w$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "retry fetch cdn config, times left: " + argusConfigManager.getGeckoCdnFetcherRetryLimit(), null, 4, null);
                                    arrayList2.add("retry limit is " + argusConfigManager.getGeckoCdnFetcherRetryLimit() + ", trigger retry in 5s.");
                                    JSONUtilsKt.safelyPut(jSONObject4, "retry", true);
                                    JSONUtilsKt.safelyPut(jSONObject4, "retry_limit", Integer.valueOf(argusConfigManager.getGeckoCdnFetcherRetryLimit()));
                                    argusConfigManager.setGeckoCdnFetcherRetryLimit(argusConfigManager.getGeckoCdnFetcherRetryLimit() - 1);
                                    asyncFetchCdnConfig(argusConfigManager, argusConfigType, true);
                                } else {
                                    ArgusGlobalCommonConfig argusSecuritySettingConfig = argusConfigManager.getArgusSecuritySettingConfig();
                                    if ((argusSecuritySettingConfig == null || (innerInitSettings = argusSecuritySettingConfig.getInnerInitSettings()) == null || !innerInitSettings.getForceSkipInvalidGecko()) ? false : true) {
                                        arrayList2.add("exceed retry limit and enable force skip invalid, skip parse this response");
                                    }
                                }
                            }
                            jSONObject = jSONObject4;
                            arrayList = arrayList2;
                            jSONObject3 = null;
                        }
                        if (z3) {
                            ArgusLog.e$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "parse gecko response failed:msg=" + CollectionsKt.joinToString$default(arrayList, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), null, null, 12, null);
                            l = jSONObject3;
                        } else {
                            ArgusLog.i$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "parse gecko response success:msg=" + CollectionsKt.joinToString$default(arrayList, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), null, 4, null);
                            l = jSONObject3;
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                    if (z2) {
                    }
                    if (z3) {
                    }
                }
                z = true;
                if (!z) {
                    z2 = false;
                    if (z2) {
                    }
                    if (z2) {
                    }
                    if (z3) {
                    }
                }
                z2 = true;
                if (z2) {
                }
                if (z2) {
                }
                if (z3) {
                }
            } else {
                jSONObject = jSONObject4;
                arrayList = arrayList2;
                ArgusLog.e$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "fetch gecko failed:msg=" + argusGeckoResponse.getMsg() + ',' + str, null, null, 12, null);
                l = 0;
            }
            JSONObject jSONObject5 = jSONObject;
            JSONUtilsKt.safelyPut(jSONObject5, ArgusMonitorKeyName.SEC_EVENT_TYPE, "config_updated");
            JSONUtilsKt.safelyPut(jSONObject5, "config_type", argusConfigType.getStr());
            JSONUtilsKt.safelyPut(jSONObject5, "fetch_type", argusGeckoFetchType.getStr());
            JSONUtilsKt.safelyPut(jSONObject5, "msg", CollectionsKt.joinToString$default(arrayList, ">", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
            JSONUtilsKt.safelyPut(jSONObject5, "fetch_success", Boolean.valueOf(isSucceed));
            JSONUtilsKt.safelyPut(jSONObject5, "parse_success", Boolean.valueOf(z3));
            JSONUtilsKt.safelyPut(jSONObject5, "gecko_version", argusGeckoResponse.getGeckoVersion());
            JSONUtilsKt.safelyPut(jSONObject5, "pkg_timestamp", Long.valueOf(l != 0 ? l.longValue() : -1L));
            JSONUtilsKt.safelyPut(jSONObject5, "fetch_url", argusGeckoResponse.getFetchUrl());
            JSONUtilsKt.safelyPut(jSONObject5, "request_log_id", argusGeckoResponse.getRequestLogId());
            JSONUtilsKt.safelyPut(jSONObject5, "from_retry", Boolean.valueOf(argusGeckoResponse.getFromRetry()));
            String networkLogicVersion = argusGeckoResponse.getNetworkLogicVersion();
            if (networkLogicVersion == null) {
                networkLogicVersion = "";
            }
            JSONUtilsKt.safelyPut(jSONObject5, "network_logic_version", networkLogicVersion);
            ArgusMonitor.INSTANCE.asyncReportLifeCycle(jSONObject5);
        } catch (Exception e) {
            ArgusLog.e$default(ArgusLog.INSTANCE, ArgusConfigManager.TAG, "fetchGeckoConfig catch: " + e + ", pkg:" + str, null, null, 12, null);
        }
    }
}
