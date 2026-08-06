package com.bytedance.frameworks.baselib.network;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.forest.model.Timing;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class TTNetInitMetrics {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String HTTP_CALLBACK_ADDRESS = "http_callback";
    public static final String LOG_TYPE = "ttnet_init";
    public static final String LOG_TYPE_V2 = "ttnet_init_v2";
    private static final String MSBridgeML = "com.bytedance.mobsec.metasec.ml.MSB";
    private static final String MSBridgeMethod = "a";
    private static final String MSBridgeOV = "com.bytedance.mobsec.metasec.ov.MSB";
    public static final String TAG = "TTNetInitMetrics";
    private static final int TTNET_TYPE = 1;
    private static final String WS_CALLBACK_ADDRESS = "ws_callback";
    public static volatile TTNetInitMetrics sInstance;
    public String abTestStr;
    public String cronetInitTimingInfoJsonStr;
    public int netThreadPriority;
    private static volatile CopyOnWriteArrayList<TTNetInitCallback> sInitCallbackList = new CopyOnWriteArrayList<>();
    private static AtomicBoolean sCronetInitSuccess = new AtomicBoolean(false);
    public CronetInitMode mode = CronetInitMode.NONE;
    public boolean isMainProcess = true;
    public long initTTNetStartTime = 0;
    public long initTTNetStart = 0;
    public long preInitMSSdkStart = 0;
    public long preInitMSSdkEnd = 0;
    public long initTTNetEnd = 0;
    public long initCookieManagerStart = 0;
    public long initCookieManagerEnd = 0;
    public long initMultiProcStackOptConfigStart = 0;
    public long initMultiProcStackOptConfigEnd = 0;
    public long createEngineStartTime = 0;
    public long createEngineStart = 0;
    public long getStackOptConfigStart = 0;
    public long getStackOptConfigEnd = 0;
    public long constructAppInfoSubsetStart = 0;
    public long constructAppInfoSubsetEnd = 0;
    public long constructThreadConfigListStart = 0;
    public long constructThreadConfigListEnd = 0;
    public long constructThreadConfigCallbackStart = 0;
    public long constructThreadConfigCallbackEnd = 0;
    public long constructSlaSamplingSettingStart = 0;
    public long constructSlaSamplingSettingEnd = 0;
    public long buildContextConfigStart = 0;
    public long buildContextConfigEnd = 0;
    public long buildBuilderStart = 0;
    public long buildBuilderEnd = 0;
    public long initMSSdkStart = 0;
    public long initMSSdkEnd = 0;
    public long createEngineEnd = 0;
    public long initThreadStart = 0;
    public long initThreadEnd = 0;
    public long loadCronetSoStart = 0;
    public long loadCronetSoEnd = 0;
    public long cronetInitEnd = 0;
    public long preconnectStartTime = 0;
    public long networkThreadStartTime = 0;
    public long networkThreadEndTime = 0;
    public long executeWaitingTaskEndTime = 0;
    public long nqeInitDuration = 0;
    public long prefsInitDuration = 0;
    public long channelInitDuration = 0;
    public long contextBuilderDuration = 0;
    public long tncConfigDuration = 0;
    public long updateAppinfoDuration = 0;
    public long netlogInitDuration = 0;
    public long nqeDetectDuration = 0;
    public long preconnectDuration = 0;
    public long sslSessionDuration = 0;
    public long ttnetConfigDuration = 0;
    public long installCertDuration = 0;

    /* loaded from: classes2.dex */
    public interface TTNetInitCallback {
        void ttnetInitSuccessCallback();
    }

    /* loaded from: classes2.dex */
    public enum CronetInitMode {
        NONE(0),
        LAZY_INIT(1),
        PRE_INIT(2),
        FORCE_INIT(3),
        DEPRECATED_API(4),
        BIZ_HTTPDNS_API(5),
        ZSTD_API(6),
        COOKIE_INIT_COMPLETE_API(7);

        final int initMode;

        CronetInitMode(int i) {
            this.initMode = i;
        }
    }

    public static void setTTNetInitSuccessCallback(TTNetInitCallback tTNetInitCallback) {
        sInitCallbackList.add(tTNetInitCallback);
    }

    public static void setCronetInitSuccess(boolean z) {
        sCronetInitSuccess.set(z);
        if (sInitCallbackList.isEmpty()) {
            return;
        }
        new ThreadPlus("ttnet-init") { // from class: com.bytedance.frameworks.baselib.network.TTNetInitMetrics.1
            @Override // com.bytedance.common.utility.concurrent.ThreadPlus, java.lang.Runnable
            public void run() {
                Iterator it = TTNetInitMetrics.sInitCallbackList.iterator();
                while (it.hasNext()) {
                    ((TTNetInitCallback) it.next()).ttnetInitSuccessCallback();
                }
            }
        }.start();
    }

    public static boolean isCronetInitSuccess() {
        return sCronetInitSuccess.get();
    }

    public boolean isPreOrForceInitCronet() {
        return this.mode == CronetInitMode.PRE_INIT || this.mode == CronetInitMode.FORCE_INIT;
    }

    public static TTNetInitMetrics inst() {
        if (sInstance == null) {
            synchronized (TTNetInitMetrics.class) {
                if (sInstance == null) {
                    sInstance = new TTNetInitMetrics();
                }
            }
        }
        return sInstance;
    }

    public void initMSSdk(Context context, List<Long> list) {
        if (list == null || list.size() != 2) {
            return;
        }
        if (Logger.debug()) {
            Logger.d(TAG, "http address: " + list.get(0) + " ws address: " + list.get(1));
        }
        this.initMSSdkStart = System.nanoTime();
        if (!setCallbackAddress(context, list) && Logger.debug()) {
            Logger.d(TAG, "init mssdk failed.");
        }
        this.initMSSdkEnd = System.nanoTime();
    }

    public void initMSSdkFromTTNet(Context context) {
        this.preInitMSSdkStart = System.nanoTime();
        setCallbackAddress(context, null);
        this.preInitMSSdkEnd = System.nanoTime();
    }

    private boolean setCallbackAddress(Context context, List<Long> list) {
        Class<?> cls;
        HashMap hashMap = null;
        try {
            cls = Class.forName(MSBridgeML);
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName(MSBridgeOV);
            } catch (ClassNotFoundException unused2) {
            }
        }
        if (cls == null) {
            return false;
        }
        if (list != null) {
            try {
                if (list.size() == 2) {
                    hashMap = new HashMap();
                    hashMap.put(HTTP_CALLBACK_ADDRESS, String.valueOf(list.get(0)));
                    hashMap.put(WS_CALLBACK_ADDRESS, String.valueOf(list.get(1)));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        cls.getMethod("a", Context.class, Integer.TYPE, Map.class).invoke(cls, context, 1, hashMap);
        return true;
    }

    public JSONObject constructTTNetInitTimingInfo() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject.put("mode", this.mode.initMode);
            jSONObject.put("is_main_process", this.isMainProcess);
            jSONObject.put("net_thread_priority", this.netThreadPriority);
            jSONObject2.put("ttnet_start", this.initTTNetStartTime);
            jSONObject2.put("ttnet_end", convertTimeStamp(this.initTTNetEnd));
            jSONObject2.put("engine_start", convertTimeStamp(this.createEngineStart));
            jSONObject2.put("engine_end", convertTimeStamp(this.createEngineEnd));
            jSONObject2.put(Timing.INIT_START, convertTimeStamp(this.initThreadStart));
            jSONObject2.put("init_end", convertTimeStamp(this.initThreadEnd));
            jSONObject2.put("preconnect_start", this.preconnectStartTime);
            jSONObject3.put("builder_build", convertTimeTicksToDurationMs(this.buildBuilderStart, this.buildBuilderEnd));
            jSONObject3.put("load_cronet", convertTimeTicksToDurationMs(this.loadCronetSoStart, this.loadCronetSoEnd));
            jSONObject3.put("init_metasec", convertTimeTicksToDurationMs(this.preInitMSSdkStart, this.preInitMSSdkEnd));
            jSONObject3.put("init_ttnet", convertTimeTicksToDurationMs(this.initTTNetStart, this.initTTNetEnd));
            jSONObject3.put("init_mssdk", convertTimeTicksToDurationMs(this.initMSSdkStart, this.initMSSdkEnd));
            jSONObject3.put("create_engine", convertTimeTicksToDurationMs(this.createEngineStart, this.createEngineEnd));
            jSONObject3.put("init_thread", convertTimeTicksToDurationMs(this.initThreadStart, this.initThreadEnd));
            jSONObject3.put("init_total", convertTimeTicksToDurationMs(Math.min(this.initTTNetStartTime, this.createEngineStartTime) * 1000000, this.networkThreadEndTime * 1000000));
            jSONObject3.put("init_preconnect", convertTimeTicksToDurationMs(this.initTTNetStartTime, this.preconnectStartTime));
            long j = this.networkThreadStartTime;
            long j2 = this.networkThreadEndTime;
            long j3 = -1;
            jSONObject3.put("network_thread", j > j2 ? -1L : j2 - j);
            long j4 = this.networkThreadEndTime;
            long j5 = this.executeWaitingTaskEndTime;
            if (j4 <= j5) {
                j3 = j5 - j4;
            }
            jSONObject3.put("exec_tasks", j3);
            jSONObject3.put("nqe_init", this.nqeInitDuration);
            jSONObject3.put("prefs_init", this.prefsInitDuration);
            jSONObject3.put("channel_init", this.channelInitDuration);
            jSONObject3.put("context_build", this.contextBuilderDuration);
            jSONObject3.put(MultiProcessFileUtils.KEY_TNC_CONFIG, this.tncConfigDuration);
            jSONObject3.put("update_appinfo", this.updateAppinfoDuration);
            jSONObject3.put("netlog_init", this.netlogInitDuration);
            jSONObject3.put("nqe_detect", this.nqeDetectDuration);
            jSONObject3.put("preconnect", this.preconnectDuration);
            jSONObject3.put("ssl_session", this.sslSessionDuration);
            jSONObject3.put("ttnet_config", this.ttnetConfigDuration);
            jSONObject3.put("install_cert", this.installCertDuration);
            jSONObject.put("ttnet_timestamp", jSONObject2);
            jSONObject.put("ttnet_duration", jSONObject3);
            jSONObject.put(BaseHttpRequestInfo.KEY_ABTEST, this.abTestStr);
        } catch (JSONException unused) {
        }
        if (Logger.debug()) {
            Logger.d(TAG, "cronet init metrics json: " + jSONObject.toString());
        }
        return jSONObject;
    }

    public JSONObject constructTTNetInitTimingInfoV2(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("mssdk", convertTimeTicksToDurationUsStr(this.initMSSdkStart, this.initMSSdkEnd));
            jSONObject4.put("app_info_subset", convertTimeTicksToDurationUsStr(this.constructAppInfoSubsetStart, this.constructAppInfoSubsetEnd));
            jSONObject4.put("thread_config_list", convertTimeTicksToDurationUsStr(this.constructThreadConfigListStart, this.constructThreadConfigListEnd));
            jSONObject4.put("sla_samp_setting", convertTimeTicksToDurationUsStr(this.constructSlaSamplingSettingStart, this.constructSlaSamplingSettingEnd));
            jSONObject4.put("build_ctx_config", convertTimeTicksToDurationUsStr(this.buildContextConfigStart, this.buildContextConfigEnd));
            jSONObject4.put("init_total", convertTimeTicksToDurationUsStr(Math.min(this.initTTNetStartTime, this.createEngineStartTime) * 1000000, this.networkThreadEndTime * 1000000));
            jSONObject4.put("app_init_time", j != -1 ? convertTimeTicksToDurationUsStr(j, this.initTTNetStart) : "-1");
            jSONObject3.put("cross_plfm", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put(LOG_TYPE, convertTimeTicksToDurationUsStr(this.initTTNetStart, this.initTTNetEnd));
            jSONObject5.put("init_stack_config", convertTimeTicksToDurationUsStr(this.initMultiProcStackOptConfigStart, this.initMultiProcStackOptConfigEnd));
            jSONObject5.put("get_stack_config", convertTimeTicksToDurationUsStr(this.getStackOptConfigStart, this.getStackOptConfigEnd));
            jSONObject5.put("init_cookie_mgr", convertTimeTicksToDurationUsStr(this.initCookieManagerStart, this.initCookieManagerEnd));
            jSONObject5.put("pre_init_mssdk", convertTimeTicksToDurationUsStr(this.preInitMSSdkStart, this.preInitMSSdkEnd));
            jSONObject5.put("builder_build", convertTimeTicksToDurationUsStr(this.buildBuilderStart, this.buildBuilderEnd));
            jSONObject5.put("create_engine", convertTimeTicksToDurationUsStr(this.createEngineStart, this.createEngineEnd));
            jSONObject5.put("cronet_init_thread", convertTimeTicksToDurationUsStr(this.initThreadStart, this.initThreadEnd));
            jSONObject5.put("cronet_load_so", convertTimeTicksToDurationUsStr(this.loadCronetSoStart, this.loadCronetSoEnd));
            jSONObject5.put("thread_config_callback", convertTimeTicksToDurationUsStr(this.constructThreadConfigCallbackStart, this.constructThreadConfigCallbackEnd));
            jSONObject3.put("android_spec", jSONObject5);
            jSONObject2.put("durations_us", jSONObject3);
            jSONObject2.put("cronet_init_mode", this.mode.initMode);
            jSONObject.put("ttnet_layer", jSONObject2);
            jSONObject.put("cronet_layer", new JSONObject(this.cronetInitTimingInfoJsonStr));
            jSONObject.put(BaseHttpRequestInfo.KEY_ABTEST, this.abTestStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public boolean checkTTNetLayerInitComplete() {
        return (this.initTTNetStartTime == 0 || this.initTTNetStart == 0 || this.preInitMSSdkStart == 0 || this.preInitMSSdkEnd == 0 || this.initTTNetEnd == 0 || this.initCookieManagerStart == 0 || this.initCookieManagerEnd == 0 || this.initMultiProcStackOptConfigStart == 0 || this.initMultiProcStackOptConfigEnd == 0 || this.createEngineStart == 0 || this.getStackOptConfigStart == 0 || this.getStackOptConfigEnd == 0 || this.constructAppInfoSubsetStart == 0 || this.constructAppInfoSubsetEnd == 0 || this.constructThreadConfigListStart == 0 || this.constructThreadConfigListEnd == 0 || this.constructThreadConfigCallbackStart == 0 || this.constructThreadConfigCallbackEnd == 0 || this.constructSlaSamplingSettingStart == 0 || this.constructSlaSamplingSettingEnd == 0 || this.buildContextConfigStart == 0 || this.buildContextConfigEnd == 0 || this.buildBuilderStart == 0 || this.buildBuilderEnd == 0 || this.initMSSdkStart == 0 || this.initMSSdkEnd == 0 || this.createEngineEnd == 0) ? false : true;
    }

    private long convertTimeStamp(long j) {
        return (this.initTTNetStartTime + j) - this.initTTNetStart;
    }

    private static String convertTimeTicksToDurationUsStr(long j, long j2) {
        return String.valueOf(convertTimeTicksToDurationUs(j, j2));
    }

    private static long convertTimeTicksToDurationUs(long j, long j2) {
        if (j == 0 || j2 == 0 || j > j2) {
            return -1L;
        }
        return (j2 - j) / 1000;
    }

    private static long convertTimeTicksToDurationMs(long j, long j2) {
        long convertTimeTicksToDurationUs = convertTimeTicksToDurationUs(j, j2);
        if (convertTimeTicksToDurationUs == -1) {
            return -1L;
        }
        return convertTimeTicksToDurationUs / 1000;
    }
}
