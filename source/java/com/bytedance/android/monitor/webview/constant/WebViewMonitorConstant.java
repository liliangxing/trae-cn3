package com.bytedance.android.monitor.webview.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public interface WebViewMonitorConstant {
    public static final String EVENT_TYPE_OFFLINE = "is_offline";
    public static final String EVENT_TYPE_PRE_CREATE = "is_preload_container";
    public static final String EVENT_TYPE_PRE_FETCH = "is_prefetch_data";
    public static final String LOC_AFTER_DETACH = "loc_after_detach";
    public static final String LOC_AFTER_TTI = "loc_after_tti";
    public static final String LOC_FORCE = "loc_force";
    public static final String REPORT_BLANK = "report_blank_detect";
    public static final String REPORT_PAGE_PERF = "report_page_perf";
    public static final int STATE_FALSE = 2;
    public static final int STATE_TRUE = 1;
    public static final int STATE_UNDEFINE = 0;

    /* loaded from: classes3.dex */
    public interface Blank {
        public static final String COST_TIME = "cost_time";
        public static final String DETECT_TYPE = "detect_type";
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MESSAGE = "error_msg";
        public static final String IS_BLANK = "is_blank";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface EventType {
    }

    /* loaded from: classes3.dex */
    public interface FalconX {
        public static final String AC = "ac";
        public static final String CHANNEL = "channel";
        public static final String ERROR_CODE = "error_code";
        public static final String IS_CUSTOM_INTERCEPTOR = "is_custom_interceptor";
        public static final String MIME_TYPE = "mime_type";
        public static final String OFFLINE_DURATION = "offline_duration";
        public static final String OFFLINE_RULE = "offline_rule";
        public static final String OFFLINE_STATUS = "offline_status";
        public static final String PACKAGE_VERSION = "package_version";
        public static final String RESOURCE_LIST = "resource_list";
        public static final String RESOURCE_URL = "resource_url";
    }

    /* loaded from: classes3.dex */
    public interface FetchError {
        public static final String ERROR_CODE = "error_no";
        public static final String ERROR_MESSAGE = "error_msg";
        public static final String HIT_PREFETCH = "hit_prefetch";
        public static final String JSB_RETURN = "jsb_ret";
        public static final String METHOD = "method";
        public static final String REQUEST_ERROR_CODE = "request_error_code";
        public static final String REQUEST_ERROR_MESSAGE = "request_error_msg";
        public static final String STATUS_CODE = "status_code";
        public static final String URL = "url";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface LocType {
    }

    /* loaded from: classes3.dex */
    public interface Params {
        public static final String CLICK_START = "click_start";
        public static final String EVENT_COUNTS = "event_counts";
        public static final String INIT_TIME = "init_time";
        public static final String INJECT_JS_TIME = "inject_js_time";
        public static final String LOCAL_EVENT_TYPE = "event_type";
        public static final String PERFORMANCE_TEST = "performance_test";
        public static final String SERVICE_TYPE = "serviceType";
        public static final String SHOW_END = "show_end";
        public static final String SHOW_STAET = "show_start";
        public static final String URL = "url";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ReportType {
    }

    /* loaded from: classes3.dex */
    public interface RequestError {
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MESSAGE = "error_msg";
        public static final String ERROR_URL = "error_url";
        public static final String HTTP_STATUS = "http_status";
        public static final String SCENE = "scene";
    }

    /* loaded from: classes3.dex */
    public interface Setting {
        public static final String WEB_CLASSES_KEY = "webview_classes";
        public static final String WEB_IS_INJECT_JS = "webview_is_inject_js";
        public static final String WEB_IS_NEED_BLANK_DETECT = "webview_is_open_blankdetect";
        public static final String WEB_IS_NEED_MONITOR = "webview_is_need_monitor";
        public static final String WEB_IS_OPEN_FETCH = "webview_is_open_fetch";
        public static final String WEB_IS_OPEN_JSB = "webview_is_open_jsb";
        public static final String WEB_IS_UPDATE_PAGE_DATA = "webview_is_update_page_data";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface State {
    }

    /* loaded from: classes3.dex */
    public interface Web {
        public static final String BLANK_URL = "about:blank";
        public static final String IS_TTWEB_ENABLE = "is_ttweb_enable";
        public static final String JS_VERSION = "js_dependency_version";
        public static final String LOAD_START = "load_start";
        public static final String NATIVE_PAGE = "native_page";
        public static final String PAGE_FINISH = "page_finish";
        public static final String PAGE_PROGRESS_END = "page_progress_100";
        public static final String PAGE_START = "page_start";
        public static final String WEBVIEW_TYPE = "webview_type";
    }
}
