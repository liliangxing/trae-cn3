package com.bytedance.pia.core.metrics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: classes4.dex */
public @interface ErrorCode {
    public static final int BRIDGE_FAILED = 0;
    public static final int BRIDGE_INVALID_PARAMS = -3;
    public static final int BRIDGE_INVALID_RESULT = -4;
    public static final int BRIDGE_SETTINGS_DISABLE = -6;
    public static final int BRIDGE_UNAUTHORIZED = -1;
    public static final int BRIDGE_UNREGISTERED = -2;
    public static final int NO_VALID_NSR_RESULT = 1008;
    public static final int NO_VALID_SNAPSHOT = 1013;
    public static final int NSR_EXECUTE_FAILED = 1009;
    public static final int NSR_NOT_ENABLED = 1007;
    public static final int PARSE_MANIFEST_FAILED = 1005;
    public static final int PARSE_PUBLIC_PATH_FAILED = 1006;
    public static final int PREFETCH_HANDLE_TRACE_FAILED = 1002;
    public static final int PREFETCH_NOT_ENABLED = 1004;
    public static final int PREFETCH_WORKER_CREATE_FAILED = 1003;
    public static final int PREFETCH_WORKER_ERROR = 1001;
    public static final int READ_SNAPSHOT_STR_FAILED = 1014;
    public static final int SNAPSHOT_NOT_ENABLED = 1010;
    public static final int SNAPSHOT_NOT_ENABLE_REQUEST = 1011;
    public static final int SNAPSHOT_RES_REQUEST_FAILED = 1012;
    public static final int SNAPSHOT_SAVE_FAIL_FOR_CONFLICT = 1015;
    public static final int UNKNOWN = 0;
    public static final int WORKER_DISABLED_BY_SETTINGS = -1;
    public static final int WORKER_ENGINE_LOAD_FAILED = -3;
    public static final int WORKER_FAILED = 0;
    public static final int WORKER_INITIALIZE_FAILED = -5;
    public static final int WORKER_INVALID_SCRIPT_URL = -2;
    public static final int WORKER_JS_EXECUTE_ERROR = -7;
    public static final int WORKER_POLYFILL_LOAD_FAILED = -4;
    public static final int WORKER_SCRIPT_LOAD_FAILED = -6;
}
