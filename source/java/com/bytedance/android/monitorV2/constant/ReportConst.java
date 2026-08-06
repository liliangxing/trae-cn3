package com.bytedance.android.monitorV2.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public interface ReportConst {
    public static final String CLICK_START = "click_start";
    public static final String CONTAINER_TYPE = "container_type";
    public static final String LYNX_VERSION = "lynx_version";
    public static final String NATIVE_PAGE = "native_page";
    public static final String NAVIGATION_ID = "navigation_id";
    public static final String PAGE_VERSION = "page_version";
    public static final int PLATFORM_INT_FLUTTER = 4;
    public static final int PLATFORM_INT_LYNX = 3;
    public static final int PLATFORM_INT_RN = 2;
    public static final int PLATFORM_INT_TIMOR = 1;
    public static final int PLATFORM_INT_WEB = 0;
    public static final String SDK_VERSION = "sdk_version";
    public static final String TEMPLATE_STATE = "template_state";
    public static final String TYPE_LYNX = "lynx";
    public static final String TYPE_RN = "reactnative";
    public static final String TYPE_WEB = "web";
    public static final String URL = "url";
    public static final String WEBVIEW_TYPE_TTWEBVIEW = "ttweb";
    public static final String WEB_VERSION = "web_version";

    /* loaded from: classes3.dex */
    public interface BidSourceInfo {
        public static final String BID_REGEX_SOURCE = "regex_source";
        public static final String BID_SOURCE = "bid_source";
        public static final String BID_SOURCE_DEFAULT = "default_bid";
        public static final String BID_SOURCE_REGEX_LIST = "regex_list_bid";
        public static final String BID_SOURCE_REGEX_PARAM = "regex_param_bid";
        public static final String CONFIG_BID = "config_bid";
        public static final String CUSTOM_BID = "custom_bid";
        public static final String DEFAULT_BID = "default_bid";
        public static final String JSB_BID = "jsb_bid";
        public static final String REGEX_BID = "regex_bid";
    }

    /* loaded from: classes3.dex */
    public interface ContainerError {
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MESSAGE = "error_message";
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface ContainerType {
    }

    /* loaded from: classes3.dex */
    public interface Custom {
        public static final String CLIENT_CATEGORY = "client_category";
        public static final String CLIENT_EXTRA = "client_extra";
        public static final String CLIENT_METRIC = "client_metric";
        public static final String CLIENT_TIMING = "client_timing";
        public static final String CUSTOM = "custom";
        public static final String EVENT_NAME = "event_name";
        public static final String EV_TYPE = "ev_type";
        public static final String HOST = "host";
        public static final String PATH = "path";
        public static final String URL = "url";
    }

    /* loaded from: classes3.dex */
    public interface Event {
        public static final String AJAX = "ajax";
        public static final String ANNIEX_SSP_PV = "anniex_ssp_pv";
        public static final String ANNIEX_SSP_RES_LOADER_INFO = "anniex_ssp_res_loader_info";
        public static final String BLANK = "blank";
        public static final String CONTAINER_ERROR = "containerError";
        public static final String CUSTOM = "newcustom";
        public static final String FALCON_PERF = "falconPerf";
        public static final String FETCH_ERROR = "fetchError";
        public static final String JSB_ERROR = "jsbError";
        public static final String JSB_PAGE_VISIT = "jsbPv";
        public static final String JSB_PER = "jsbPerf";
        public static final String JSB_PER_V2 = "jsbPerfV2";
        public static final String JS_EXCEPTION = "js_exception";
        public static final String JS_PERFORMANCE = "perf";
        public static final String NATIVE_ERROR = "nativeError";
        public static final String NAVIGATION_START = "navigationStart";
        public static final String PERFORMANCE = "performance";
        public static final String PERFORMANCE_TEST = "performance_test";
        public static final String RESOURCE_PERFORMANCE = "resource_performance";
        public static final String RES_LOADER_ERROR = "res_loader_error";
        public static final String RES_LOADER_ERROR_TEMPLATE = "res_loader_error_template";
        public static final String RES_LOADER_PERF = "res_loader_perf";
        public static final String RES_LOADER_PERF_TEMPLATE = "res_loader_perf_template";
        public static final String STATIC = "static";
        public static final String STATIC_SRI = "static_sri";

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface EventType {
        }
    }

    /* loaded from: classes3.dex */
    public interface FallbackPage {
        public static final String EVENT_NAME = "bd_monitor_fallback_page";
        public static final String FALLBACK_TYPE = "fallback_type";
        public static final String LYNX = "lynx";
        public static final String SOURCE_CONTAINER = "source_container";
        public static final String SOURCE_URL = "source_url";
        public static final String TARGET_CONTAINER = "target_container";
        public static final String TARGET_URL = "target_url";
        public static final String TYPE_LOAD_ERROR = "loadError";
        public static final String TYPE_SCHEMA_ERROR = "schemaError";
        public static final String WEB = "web";

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface Container {
        }
    }

    /* loaded from: classes3.dex */
    public interface GeckoInfo {
        public static final String ASSET = "buildIn";
        public static final String CDN = "cdn";
        public static final String CDN_CACHE = "cdnCache";
        public static final String CONTAINER = "container";
        public static final String EVENT_NAME = "bd_monitor_get_resource";
        public static final String GECKO = "gecko";
        public static final String LYNX = "lynx";
        public static final String OFFLINE = "offline";
        public static final String RES = "res";
        public static final String RES_STATUS = "res_status";
        public static final String RES_TYPE = "res_type";
        public static final String RES_URL = "res_url";
        public static final String RES_VERSION = "res_version";
        public static final String TEMPLATE = "template";
        public static final String WEB = "web";

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface Container {
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface ResStatus {
        }

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface ResType {
        }
    }

    /* loaded from: classes3.dex */
    public interface JSBConfigParam {
        public static final String BID = "bid";
        public static final String CONTEXT = "context";
        public static final String ENV = "env";
        public static final String PID = "pid";
        public static final String RELEASE = "release";
    }

    /* loaded from: classes3.dex */
    public interface JSBError {
        public static final String BRIDGE_NAME = "bridge_name";
        public static final String ERROR_ACTIVITY = "error_activity";
        public static final String ERROR_CODE = "error_code";
        public static final String ERROR_MESSAGE = "error_message";
        public static final String ERROR_URL = "error_url";
        public static final String IS_SYNC = "is_sync";
        public static final String JS_TYPE = "js_type";
    }

    /* loaded from: classes3.dex */
    public interface JSBInfo {
        public static final String BRIDGE_NAME = "bridge_name";
        public static final String CALLBACK_TS = "callback_ts";
        public static final String COST_TIME = "cost_time";
        public static final String FIRE_EVENT_TS = "fireEvent_ts";
        public static final String INVOKE_TS = "invoke_ts";
        public static final String PROTOCOL_VERSION = "protocol_version";
        public static final String REQUEST_URL = "request_url";
        public static final String STATUS_CODE = "status_code";
        public static final String STATUS_DESCRIPTION = "status_description";
    }

    /* loaded from: classes3.dex */
    public interface NativeErrorScene {
        public static final String CHILD_RESOURCE = "child_resource";
        public static final String LYNX_CUSTOM_ERROR = "lynx_error_custom";
        public static final String LYNX_ERROR = "lynx_error";
        public static final String MAIN_FRAME = "main_frame";
        public static final String WEB_PROCESS_TERMINATE = "web_process_terminate";
    }

    /* loaded from: classes3.dex */
    public interface Params {
        public static final String ATTACH_TS = "attach_ts";
        public static final String BID = "bid";
        public static final String BID_INFO = "bid_info";
        public static final String CAN_SAMPLE = "can_sample";
        public static final String CONFIG_BID = "config_bid";
        public static final String CONTAINER_BASE = "containerBase";
        public static final String CONTAINER_INFO = "containerInfo";
        public static final String CONTAINER_REUSE = "container_reuse";
        public static final String CONTEXT = "context";
        public static final String DEBUG_CONTEXT = "debug_context";
        public static final String DEBUG_LOG = "debugLog";
        public static final String DETACH_TS = "detach_ts";
        public static final String EVENT_EXTRA = "extra";
        public static final String FULL_LINK_ID = "full_link_id";
        public static final String HIT_SAMPLE = "hit_sample";
        public static final String INC_ID = "inc_id";
        public static final String INIT_TS = "container_init_ts";
        public static final String JS_BASE = "jsBase";
        public static final String JS_INFO = "jsInfo";
        public static final String LOCAL_EVENT_TYPE = "event_type";
        public static final String MONITOR_PACKAGE = "monitor_package";
        public static final String NATIVE_BASE = "nativeBase";
        public static final String NATIVE_INFO = "nativeInfo";
        public static final String NATIVE_REPEAT_COUNT = "native_repeat_count";
        public static final String NEED_REPORT = "need_report";
        public static final String PLATFORM = "platform";
        public static final String SDK_VERSION = "sdk_version";
        public static final String SETTING_BID = "setting_bid";
        public static final String SETTING_ID = "setting_id";
        public static final String URL = "url";
        public static final String UUID = "uuid";
        public static final String VIRTUAL_AID = "virtual_aid";
    }

    /* loaded from: classes3.dex */
    public interface ReportCheck {
        public static final String BID = "bid";
        public static final String CATEGORY = "category";
        public static final String CONTAINER_NAME = "containerName";
        public static final String CONTAINER_TYPE = "containerType";
        public static final String EVENT_TYPE = "eventType";
        public static final String FILTER = "filter";
        public static final List<String> FILTER_LIST = Arrays.asList("containerName", "bid", "eventType", "containerType", "sdkVersion");
        public static final String ID = "id";
        public static final String SDK_VERSION = "sdkVersion";
    }

    /* loaded from: classes3.dex */
    public interface ResourceLoadFail {
        public static final String CDN_STATUS = "cdnStatus";
        public static final String ERROR_MESSAGE = "errorMsg";
        public static final String EVENT_NAME = "bd_monitor_lynxResLoadError";
        public static final String GECKO_STATUS = "geckoStatus";
        public static final String HTTP_STATUS = "httpStatus";
        public static final String RES_TYPE = "resType";
        public static final String TYPE = "type";
        public static final int TYPE_ASSET = 3;
        public static final int TYPE_CDN = 2;
        public static final int TYPE_GECKO = 1;
        public static final int TYPE_OTHER = 4;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes3.dex */
        public @interface ResStatus {
        }
    }

    /* loaded from: classes3.dex */
    public interface ValidationReport {
        public static final String AID = "aid";
        public static final String BID = "bid";
        public static final String BODY = "body";
        public static final String CONTAINER_NAME = "container_name";
        public static final String CONTAINER_TYPE = "container_type";
        public static final String DEVICE_ID = "device_id";
        public static final String EV_TYPE = "ev_type";
        public static final String HIT_SAMPLE = "hit_sample";
        public static final String MODULE = "module";
        public static final String OS = "os";
        public static final String SDK_NAME = "sdk_name";
        public static final String SDK_VERSION = "sdk_version";
        public static final String TIMESTAMP = "timestamp";
        public static final String TRACE_CONTENT = "trace_content";
        public static final String TRACE_ID = "trace_id";
        public static final String TRACE_TYPE = "trace_type";
        public static final String URL = "url";
    }
}
