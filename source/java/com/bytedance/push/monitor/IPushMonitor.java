package com.bytedance.push.monitor;

import org.json.JSONObject;

/* loaded from: classes4.dex */
public interface IPushMonitor {
    public static final int DETAIL_CODE_UNKNOWN = -1;
    public static final String EVENT_APPLOG_CALLBACK_TIMEOUT = "push_monitor_applog_timeout";
    public static final String EVENT_APPLOG_REGISTER_RESULT = "push_monitor_register_result";
    public static final String EVENT_APPLOG_UPDATE_SENDER = "push_monitor_update_sender";
    public static final String EVENT_COMMON_EVENT = "push_monitor_common_event";
    public static final String EVENT_DECRYPT_RESULT = "push_monitor_decrypt_result";
    public static final String EVENT_MONITOR_GIF_NOTIFICATION = "push_monitor_gif_notification";
    public static final String EVENT_MONITOR_HARMONY_OS4_COMPLIANCE = "push_monitor_harmony_os4_compliance";
    public static final String EVENT_MONITOR_SHOW_EMPTY = "push_monitor_show_empty";
    public static final String EVENT_OUTER_SWITCH_STATUS_RESULT = "outer_switch_sync_result";
    public static final String EVENT_OUTER_SWITCH_UPLOAD_RESULT = "outer_switch_upload_result";
    public static final int MSG_WHAT_REGISTER_PUSH = 1001;
    public static final int STATUS_FAILED_EMPTY_RESPONSE = 304;
    public static final int STATUS_FAILED_ERROR_SENDER = 303;
    public static final int STATUS_FAILED_EXCEPTION = 301;
    public static final int STATUS_FAILED_NOT_SUCCESS = 302;
    public static final int STATUS_REGISTER_CHECK_BEFORE_REGISTER = 101;
    public static final int STATUS_REGISTER_EMPTY_CONFIG = 106;
    public static final int STATUS_REGISTER_ERROR_ALIAS = 105;
    public static final int STATUS_REGISTER_ERROR_TOKEN = 102;
    public static final int STATUS_REGISTER_FAILED = 104;
    public static final int STATUS_REGISTER_SENDER_NOT_SUPPORT = 107;
    public static final int STATUS_REGISTER_SENDER_TIMEOUT = 108;
    public static final int STATUS_REGISTER_SEND_TOKEN = 103;
    public static final int STATUS_SUCCESS = 0;

    void monitorEvent(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3);
}
