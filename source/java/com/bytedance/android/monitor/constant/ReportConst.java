package com.bytedance.android.monitor.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public interface ReportConst {
    public static final String CLICK_START = "click_start";
    public static final String CONTAINER_TYPE = "container_type";
    public static final String LYNX_VERSION = "lynx_version";
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
    public static final String TYPE_TTWEBVIEW = "ttweb";
    public static final String TYPE_WEB = "web";
    public static final String URL = "url";

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
        public static final String BLANK = "blank";
        public static final String CONTAINER_ERROR = "containerError";
        public static final String CUSTOM = "newcustom";
        public static final String FALCON_PERF = "falconPerf";
        public static final String FETCH_ERROR = "fetchError";
        public static final String JSB_ERROR = "jsbError";
        public static final String JSB_PER = "jsbPerf";
        public static final String JS_PERFORMANCE = "perf";
        public static final String NATIVE_ERROR = "nativeError";
        public static final String NAVIGATION_START = "navigationStart";
        public static final String PERFORMANCE = "performance";
        public static final String PERFORMANCE_TEST = "performance_test";
        public static final String RESOURCE_PERFORMANCE = "resource_performance";

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
        public static final String CONTAINER_BUSINESS = "containerInfo";
        public static final String CONTAINER_COMMON = "containerBase";
        public static final String CONTAINER_REUSE = "container_reuse";
        public static final String CONTEXT = "context";
        public static final String DEBUG_CONTEXT = "debug_context";
        public static final String DETACH_TS = "detach_ts";
        public static final String INIT_TS = "container_init_ts";
        public static final String JS_BUSINESS = "jsInfo";
        public static final String JS_COMMON = "jsBase";
        public static final String LOCAL_EVENT_TYPE = "event_type";
        public static final String NATIVE_BUSINESS = "nativeInfo";
        public static final String NATIVE_COMMON = "nativeBase";
        public static final String PLATFORM = "platform";
        public static final String URL = "url";
        public static final String VIRTUAL_AID = "virtual_aid";
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
}
