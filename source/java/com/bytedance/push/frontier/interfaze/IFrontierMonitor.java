package com.bytedance.push.frontier.interfaze;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IFrontierMonitor {
    public static final String EVENT_REGISTER_FRONTIER = "register_frontier";
    public static final String EVENT_UPDATE_SETTING = "update_frontier_setting";
    public static final String KEY_FRONTIER_SERVICE_IS_NULL = "frontier_service_is_null";
    public static final String KEY_FRONTIER_STRATEGY = "frontier_strategy";
    public static final String KEY_LOG = "log";
    public static final String KEY_STATUS = "status";
    public static final String KEY_TIME_CONSUMING = "time_consuming";
    public static final int STATUS_FAILED_EMPTY_RESPONSE = 304;
    public static final int STATUS_FAILED_ERROR_SETTING = 303;
    public static final int STATUS_FAILED_EXCEPTION = 301;
    public static final int STATUS_FAILED_NOT_SUCCESS = 302;
    public static final int STATUS_SUCCESS = 0;

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);

    void onRequestFrontierSettingFailed(int i, String str, long j);

    void onRequestFrontierSettingSuccess(long j);
}
