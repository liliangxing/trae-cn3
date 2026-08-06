package com.bytedance.sync;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.crash.Npth;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.security.android.aopcheck.reporter.Constant;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.util.JSONUtils;
import com.bytedance.tracing.log.Fields;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SyncMonitor.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u0011\u001a\u00020\u000bH\u0007J4\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00042\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0007J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0007J\u001c\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010!\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020$H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/sync/SyncMonitor;", "", "()V", "AID_SLARDAR", "", "mCurrentProcessSuffix", "monitorImpl", "Lcom/bytedance/framwork/core/sdkmonitor/SDKMonitor;", "sEnableMonitor", "", "init", "", "context", "Landroid/content/Context;", "configuration", "Lcom/bytedance/sync/Configuration;", "deviceId", "injectNpthVersion", "monitor", "serviceName", "category", "Lorg/json/JSONObject;", "metric", "logExtra", "monitorCompressRatio", "srcSize", "", "compressSize", "msgType", "monitorException", "e", "", "errMsg", "monitorStorageSize", "monitorSyncCost", "lastSendSyncTimeStamp", "", "sync-sdk_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SyncMonitor {
    private static final String AID_SLARDAR = "4119";
    public static final SyncMonitor INSTANCE = new SyncMonitor();
    private static String mCurrentProcessSuffix = "";
    private static volatile com.bytedance.framwork.core.sdkmonitor.SDKMonitor monitorImpl;
    private static volatile boolean sEnableMonitor;

    private SyncMonitor() {
    }

    @JvmStatic
    public static final void init(Context context, final Configuration configuration, String deviceId) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        if (TextUtils.isEmpty(configuration.monitorHost)) {
            return;
        }
        sEnableMonitor = true;
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_id", deviceId);
                jSONObject.put(Constant.KEY_HOST_AID, configuration.aid);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            SDKMonitorUtils.setDefaultReportUrl(AID_SLARDAR, CollectionsKt.listOf(Intrinsics.stringPlus(configuration.monitorHost, "/monitor/collect/")));
            SDKMonitorUtils.setConfigUrl(AID_SLARDAR, CollectionsKt.listOf(Intrinsics.stringPlus(configuration.monitorHost, "/monitor/appmonitor/v2/settings")));
            try {
                if (configuration.debug) {
                    jSONObject.put(Constant.KEY_CHANNEL, configuration.commonParamProvider.getCommonParams().get(Constant.KEY_CHANNEL));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Intrinsics.checkNotNull(context);
            SDKMonitorUtils.initMonitor(context, AID_SLARDAR, jSONObject, new SDKMonitor.IGetExtendParams() { // from class: com.bytedance.sync.SyncMonitor$init$1
                public String getSessionId() {
                    return null;
                }

                public Map<String, String> getCommonParams() {
                    Map<String, String> commonParams = Configuration.this.commonParamProvider.getCommonParams();
                    Intrinsics.checkNotNullExpressionValue(commonParams, "commonParam");
                    commonParams.put("oversea", Configuration.this.oversea ? "1" : "0");
                    commonParams.remove(Constant.KEY_AID);
                    commonParams.put(Constant.KEY_HOST_AID, Configuration.this.aid);
                    return commonParams;
                }
            });
            monitorImpl = SDKMonitorUtils.getInstance(AID_SLARDAR);
            String curProcessNameSuffix = ToolUtils.getCurProcessNameSuffix(context);
            Intrinsics.checkNotNullExpressionValue(curProcessNameSuffix, "getCurProcessNameSuffix(context)");
            mCurrentProcessSuffix = curProcessNameSuffix;
        } catch (Exception e3) {
            e3.printStackTrace();
            sEnableMonitor = false;
        }
    }

    public static /* synthetic */ void monitor$default(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, int i, Object obj) {
        if ((i & 2) != 0) {
            jSONObject = null;
        }
        if ((i & 4) != 0) {
            jSONObject2 = null;
        }
        if ((i & 8) != 0) {
            jSONObject3 = null;
        }
        monitor(str, jSONObject, jSONObject2, jSONObject3);
    }

    @JvmStatic
    public static final void monitor(String serviceName, JSONObject category, JSONObject metric, JSONObject logExtra) {
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        if (sEnableMonitor) {
            LogUtils.m187i("[Monitor] " + serviceName + ", " + category + ", " + metric + ", " + logExtra);
            com.bytedance.framwork.core.sdkmonitor.SDKMonitor sDKMonitor = monitorImpl;
            Intrinsics.checkNotNull(sDKMonitor);
            sDKMonitor.monitorEvent(Intrinsics.stringPlus(serviceName, TextUtils.isEmpty(mCurrentProcessSuffix) ? "" : Intrinsics.stringPlus(SyncConstants.SEPARATOR, mCurrentProcessSuffix)), category, metric, logExtra);
        }
    }

    public static /* synthetic */ void monitorException$default(Throwable th, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        monitorException(th, str);
    }

    @JvmStatic
    public static final void monitorException(Throwable e, String errMsg) {
        Intrinsics.checkNotNullParameter(e, "e");
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "errMsg", errMsg);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtils.safePutParam(jSONObject2, Fields.STACK, Log.getStackTraceString(e));
        JSONUtils.safePutParam(jSONObject2, DBData.FIELD_TYPE, e.getClass().getName());
        LogUtils.m185d(Intrinsics.stringPlus("[Monitor] -> syncsdk_exception,", jSONObject));
        try {
            EnsureManager.ensureNotReachHere(e, errMsg);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @JvmStatic
    public static final void monitorStorageSize(Context context) {
        double fileSizeKB;
        double fileSizeKB2;
        double fileSizeKB3;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            long length = context.getDatabasePath(SyncConstants.DB_V4).length();
            long length2 = ((IFileDataCacheService) UgBusFramework.getService(IFileDataCacheService.class)).getCachedDir().length();
            JSONObject jSONObject = new JSONObject();
            fileSizeKB = SyncMonitorKt.toFileSizeKB(length);
            jSONObject.put("db_size", fileSizeKB);
            fileSizeKB2 = SyncMonitorKt.toFileSizeKB(length2);
            jSONObject.put("file_size", fileSizeKB2);
            fileSizeKB3 = SyncMonitorKt.toFileSizeKB(length + length2);
            jSONObject.put("size", fileSizeKB3);
            monitor$default("sync_sdk_storage_size", null, jSONObject, null, 10, null);
        } catch (Exception e) {
            monitorException$default(e, null, 2, null);
        }
    }

    @JvmStatic
    public static final void monitorSyncCost(long lastSendSyncTimeStamp) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - lastSendSyncTimeStamp;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sync_cost", currentTimeMillis);
            monitor$default("sync_sdk_sync_cost", null, jSONObject, null, 10, null);
        } catch (Exception e) {
            monitorException$default(e, null, 2, null);
        }
    }

    @JvmStatic
    public static final void monitorCompressRatio(int srcSize, int compressSize, int msgType) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("compress_ratio", srcSize / compressSize);
            jSONObject.put("compress_msg_type", msgType);
            monitor$default("sync_sdk_compress", jSONObject, null, null, 12, null);
        } catch (Exception e) {
            monitorException$default(e, null, 2, null);
        }
    }

    @JvmStatic
    public static final void injectNpthVersion() {
        try {
            Npth.registerSdk(AID_SLARDAR, "");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
