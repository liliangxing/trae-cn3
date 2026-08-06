package com.bytedance.lynx.scc.cloudservice.worker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.lynx.scc.cloudservice.SccCloudServiceManager;
import com.bytedance.lynx.scc.cloudservice.utils.Logger;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class EventTracker {
    private static final String SCC_CS_URL = "scc_cloudservice_url";
    private static final String SCC_REPORT_REASON = "scc_report_reason";
    private static final String SCC_VERSION = "1";
    private long mCsStartTime;
    private final Map<String, String> mParams;
    private long mPrefetchStartTime;
    private long mStartTime;
    private long mUserStartTime;

    public EventTracker() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mParams = concurrentHashMap;
        concurrentHashMap.put("scc_mode", "coreless");
        concurrentHashMap.put("scc_version", "1");
        this.mStartTime = 0L;
        this.mCsStartTime = 0L;
        this.mUserStartTime = 0L;
        this.mPrefetchStartTime = 0L;
    }

    public void onStart(String url) {
        this.mStartTime = SystemClock.uptimeMillis();
        this.mParams.put(SCC_CS_URL, url);
    }

    public void onDisabled() {
        this.mStartTime = SystemClock.uptimeMillis();
        this.mParams.put(SCC_REPORT_REASON, "internal_switch_off");
        report();
    }

    public void onHitAllowList(String matchRule) {
        this.mParams.put(SCC_REPORT_REASON, "scc_cloudservice_local_white_list");
        Map<String, String> map = this.mParams;
        if (matchRule == null) {
            matchRule = "";
        }
        map.put("scc_cs_local_white_list_matched_rule", matchRule);
        report();
    }

    public void onHitBlockList(String matchRule) {
        this.mParams.put(SCC_REPORT_REASON, "scc_cloudservice_local_block_list");
        this.mParams.put("scc_cs_local_block_list_matched_rule", matchRule);
        report();
    }

    public void onHitCache(String matchRule) {
        this.mParams.put(SCC_REPORT_REASON, "scc_cloudservice");
        this.mParams.put("scc_cloudservice_check_delta", "0");
        this.mParams.put("scc_cloudservice_label", "cache_white");
        report();
    }

    public void onUserSkip() {
        this.mParams.put(SCC_REPORT_REASON, "user_skip");
        report();
    }

    public void onCSStart() {
        this.mCsStartTime = SystemClock.uptimeMillis();
        this.mParams.put(SCC_REPORT_REASON, "scc_cloudservice");
        this.mParams.put("scc_cloudservice_check_delta", "-1");
        this.mParams.put("scc_cloudservice_label", "error");
        this.mParams.put("scc_cloudservice_backend_code", "-1");
        this.mParams.put("scc_cloudservice_ttnet_code", "-1");
        this.mParams.put("scc_cloudservice_user_wait_time", "-1");
        this.mParams.put("scc_cloudservice_result_apply", "0");
    }

    public void onCSEnd(int requestCode, int backEndCode, String label, String logid, JSONObject originRet) {
        this.mParams.put("scc_cloudservice_check_delta", (SystemClock.uptimeMillis() - this.mCsStartTime) + "");
        this.mParams.put("scc_cloudservice_ttnet_code", requestCode + "");
        this.mParams.put("scc_cloudservice_backend_code", backEndCode + "");
        if (!TextUtils.isEmpty(label)) {
            this.mParams.put("scc_cloudservice_label", label);
        }
        if (originRet != null) {
            if (!TextUtils.isEmpty(logid)) {
                try {
                    originRet.put("scc_logid", logid);
                } catch (JSONException e) {
                    Logger.e("json format error:" + e.toString());
                }
            }
            this.mParams.put(SccUtils.REPORT_EVENT_NAME, originRet.toString());
            return;
        }
        this.mParams.put(SccUtils.REPORT_EVENT_NAME, "{}");
    }

    public void onPrefetchStart() {
        this.mPrefetchStartTime = SystemClock.uptimeMillis();
        this.mParams.put("scc_cloudservice_prefetch_check_delta", "-1");
        this.mParams.put("scc_cloudservice_prefetch_ttnet_code", "-1");
    }

    public void onPrefetchEnd(int responseCode) {
        this.mParams.put("scc_cloudservice_prefetch_check_delta", (SystemClock.uptimeMillis() - this.mPrefetchStartTime) + "");
        this.mParams.put("scc_cloudservice_prefetch_ttnet_code", responseCode + "");
    }

    public void onUserRequestStart() {
        this.mUserStartTime = SystemClock.uptimeMillis();
    }

    public void onUserRequestEnd(boolean isSuccess, String failedReason) {
        this.mParams.put("scc_cloudservice_user_wait_time", (SystemClock.uptimeMillis() - this.mUserStartTime) + "");
        this.mParams.put("scc_cloudservice_result_apply", isSuccess ? "1" : "0");
        if (!TextUtils.isEmpty(failedReason)) {
            String str = this.mParams.get(SccUtils.REPORT_EVENT_NAME);
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    jSONObject.put("error", failedReason);
                    this.mParams.put(SccUtils.REPORT_EVENT_NAME, jSONObject.toString());
                } catch (JSONException unused) {
                    Logger.w("json format error:" + str);
                }
            }
        }
        report();
    }

    private void report() {
        if (this.mParams.size() <= 2 || this.mStartTime <= 0 || !this.mParams.containsKey(SCC_REPORT_REASON)) {
            return;
        }
        this.mParams.put("scc_total_cost", (SystemClock.uptimeMillis() - this.mStartTime) + "");
        SccCloudServiceManager.onDataReport("ttwebview_scc", new HashMap(this.mParams));
    }
}
