package com.bytedance.pia.core.tracing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: classes4.dex */
public class FeatureStatus {

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface HTMLPreloadStatus {
        public static final int FAIL = 1;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = -1;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface NSRStatus {
        public static final int BUILD_FLAG_ERROR = 2;
        public static final int CACHE_CAN_NOT_USE = 5;
        public static final int DISABLE = 1;
        public static final int MANIFEST_VERSION_NOT_MATCH = 4;
        public static final int NO_VALID_CACHE = 3;
        public static final int SUCCESS = 0;
        public static final int SWITCH_NOT_MATCH = 6;
        public static final int UNKNOWN = -1;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface PrefetchProcess {
        public static final int BootEnd = 1;
        public static final int DataEnd = 2;
        public static final int Start = 0;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface PrefetchStatus {
        public static final int BOOT_TIMEOUT = 3;
        public static final int DATA_TIMEOUT = 7;
        public static final int DISABLE = 1;
        public static final int FETCH_DATA_CODE_ERROR = 8;
        public static final int HTML_ERROR = 6;
        public static final int MANIFEST_VERSION_NOT_MATCH = 5;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = -1;
        public static final int WORKER_BOOT_ERROR = 4;
        public static final int WORKER_RUNTIME_ERROR = 2;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface SSRStatus {
        public static final int BUILD_FLAG_ERROR = 2;
        public static final int DISABLE = 1;
        public static final int DOWNGRADE_CSR = 3;
        public static final int FALLBACK_CUSTOM = 15;
        public static final int FALLBACK_ERROR = 13;
        public static final int FALLBACK_HEADER = 12;
        public static final int FALLBACK_MIDDLEWARE = 14;
        public static final int FALLBACK_QUERY = 11;
        public static final int SUCCESS = 0;
        public static final int UNKNOWN = -1;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface SnapshotStatus {
        public static final int BUILD_FLAG_ERROR = 2;
        public static final int CACHE_CAN_NOT_USE = 5;
        public static final int DISABLE = 1;
        public static final int MANIFEST_VERSION_NOT_MATCH = 4;
        public static final int NO_VALID_CACHE = 3;
        public static final int SUCCESS = 0;
        public static final int SWITCH_NOT_MATCH = 6;
        public static final int UNKNOWN = -1;
    }
}
