package com.bytedance.ttnet.config;

import android.os.Build;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.TTNetRequestLogReporterBridge;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.frameworks.baselib.network.log.NetworkLogReporter;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.config.JsonOptConfig;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ExperimentalSwitches {
    private static final String TAG = "ExperimentalSwitches";
    private static final AtomicBoolean sEnableJsonWrapperRefine = new AtomicBoolean(false);
    private static final AtomicBoolean sEnableTNCJsonoptRefine = new AtomicBoolean(false);
    private static final AtomicBoolean sEnableWithContainArmabi = new AtomicBoolean(false);
    private static final AtomicBoolean sDisableFallbackReasonBoot = new AtomicBoolean(false);
    private static final AtomicBoolean sDisableFallbackReasonCronetException = new AtomicBoolean(false);
    private static final AtomicBoolean sDisableFallbackReasonNullAppconfig = new AtomicBoolean(true);
    private static final List<String> sMergeModelBlackList = new CopyOnWriteArrayList();

    public static boolean isEnableJsonWrapperRefine() {
        return sEnableJsonWrapperRefine.get();
    }

    public static boolean isEnableTNCJsonoptRefine() {
        return sEnableTNCJsonoptRefine.get();
    }

    public static boolean isEnableWithContainArmabi() {
        return sEnableWithContainArmabi.get();
    }

    public static boolean isDisableFallbackReasonBoot() {
        return sDisableFallbackReasonBoot.get();
    }

    public static boolean isDisableFallbackReasonCronetException() {
        return sDisableFallbackReasonCronetException.get();
    }

    public static boolean isDisableFallbackReasonNullAppconfig() {
        return sDisableFallbackReasonNullAppconfig.get();
    }

    public static List<String> getMergeModelBlackList() {
        return sMergeModelBlackList;
    }

    public static void onServerConfigChanged(Object obj) {
        JSONObject jSONObject;
        try {
            if (obj instanceof JsonOptConfig.JsonWrapper) {
                JSONObject jsonObject = ((JsonOptConfig.JsonWrapper) obj).jsonObject();
                jSONObject = jsonObject != null ? jsonObject.optJSONObject("data") : null;
            } else if ((obj instanceof JSONObject) && !((JSONObject) obj).isNull("data")) {
                jSONObject = ((JSONObject) obj).optJSONObject("data");
            } else {
                jSONObject = (JSONObject) obj;
            }
            if (jSONObject == null) {
                return;
            }
            sEnableJsonWrapperRefine.set(jSONObject.optInt("enable_json_wrapper") > 0);
            sEnableTNCJsonoptRefine.set(jSONObject.optInt("enable_tnc_jsonopt") > 0);
            JSONObject optJSONObject = jSONObject.optJSONObject("cronet_fallback_config");
            if (optJSONObject != null) {
                AtomicBoolean atomicBoolean = sEnableWithContainArmabi;
                atomicBoolean.set(optJSONObject.optInt("enable_with_contain_armabi") > 0);
                AtomicBoolean atomicBoolean2 = sDisableFallbackReasonBoot;
                atomicBoolean2.set(optJSONObject.optInt("disable_reason_boot") > 0);
                AtomicBoolean atomicBoolean3 = sDisableFallbackReasonCronetException;
                atomicBoolean3.set(optJSONObject.optInt("disable_reason_cronet_exception") > 0);
                AtomicBoolean atomicBoolean4 = sDisableFallbackReasonNullAppconfig;
                atomicBoolean4.set(optJSONObject.optInt("disable_reason_null_appconfig", 1) > 0);
                JSONArray optJSONArray = optJSONObject.optJSONArray("merge_model_black_list");
                List<String> list = sMergeModelBlackList;
                convertJsonArrayToList(optJSONArray, list);
                if (atomicBoolean2.get()) {
                    AppConfig.getInstance(TTNetInit.getTTNetDepend().getContext()).resetCronetBootSucceed();
                }
                if (list.contains(Build.MODEL)) {
                    AppConfig.sCronetUnsupportedModel = true;
                }
                if (Logger.debug()) {
                    Logger.d(TAG, "sEnableWithContainArmabi is " + atomicBoolean);
                    Logger.d(TAG, "sDisableFallbackReasonCronetException is " + atomicBoolean3);
                    Logger.d(TAG, "sDisableFallbackReasonBoot is " + atomicBoolean2);
                    Logger.d(TAG, "sDisableFallbackReasonNullAppconfig is " + atomicBoolean4);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("ttnet_okio");
            if (optJSONObject2 != null) {
                BaseSsCall.setTncUseOkioRead(optJSONObject2.optInt("okio_read_enabled", 1) > 0);
                BaseCronetSsCall.setTncUseZeroCopyRead(optJSONObject2.optInt("zero_copy_enabled", 1) > 0);
            }
            boolean z = jSONObject.optInt("enable_monitor_v2") > 0;
            TTNetRequestLogReporterBridge.setUseMonitorV2(z);
            NetworkParams.setUseMonitorV2ForDeprecatedApi(z);
            boolean z2 = jSONObject.optInt("disallow_dup_report") > 0;
            TTNetRequestLogReporterBridge.setDisallowDupReport(z2);
            NetworkParams.setDisallowDupReport(z2);
            if (jSONObject.optInt("fix_cancel_req_report_v2") > 0) {
                BaseCronetSsCall.enableFixCancelReqReport();
            }
            RetrofitMetrics.setSyncReport(jSONObject.optInt("sync_report_log") > 0);
            RetrofitMetrics.setReportNewMetrics(jSONObject.optInt("report_new_metrics") > 0);
            if (jSONObject.optInt("use_thread_pool") > 0) {
                RetrofitMetrics.setLogReporter(new NetworkLogReporter());
            }
            if (jSONObject.optInt("opt_reflection") > 0) {
                ReflectWrap.setUseTTReflect(true);
                NetworkParams.setOptReflection(true);
            } else {
                ReflectWrap.setUseTTReflect(false);
                NetworkParams.setOptReflection(false);
            }
            RetrofitMetrics.setReportDetail(jSONObject.optInt("report_detail", -1));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static void convertJsonArrayToList(JSONArray jSONArray, List<String> list) {
        if (list == null) {
            return;
        }
        list.clear();
        if (jSONArray == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                list.add(jSONArray.getString(i));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
