package com.ss.android.socialbase.downloader.setting;

/* loaded from: classes7.dex */
public interface DownloadSettingValues {
    public static final int APK_PARSER_ANDROID_API = 3;
    public static final int APK_PARSER_ANT_ZIP_FILE = 2;
    public static final int APK_PARSER_JAR_FILE = 1;
    public static final int DNS_EXPIRE_MIN = 10;
    public static final int PARSE_PACKAGE_INFO_BY_READ_FILE = 1;
    public static final int PARSE_PACKAGE_INFO_BY_READ_FILE_AND_NATIVE_API = 2;
    public static final int SPACE_FILL_MIN_KEEP_MB = 100;
    public static final int SYNC_INTERVAL_MS_BG = 1000;
    public static final int SYNC_INTERVAL_MS_FG = 5000;

    /* loaded from: classes7.dex */
    public interface RetryScheduleConfig {
        public static final int INTERVAL_SEC = 60;
        public static final int INTERVAL_SEC_ACCELERATION = 60;
        public static final int MAX_COUNT = 60;
    }

    /* loaded from: classes7.dex */
    public interface SegmentConfig {
        public static final int BUFFER_COUNT = 512;
        public static final int BUFFER_SIZE = 8192;
        public static final int CONNECT_TIMEOUT = -1;
        public static final int IP_STRATEGY = 0;
        public static final int READ_TIMEOUT = -1;
        public static final int SEGMENT_MIN_INIT_MB = 10;
        public static final int SEGMENT_MIN_KB = 512;
        public static final int THREAD_COUNT = 4;
        public static final int URL_BALANCE = 2;
    }
}
