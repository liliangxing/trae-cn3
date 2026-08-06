package com.bytedance.sync;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes5.dex */
public final class SyncConstants {
    public static final String BD_NAME = "bd_sync_sdk.db";
    public static final int BUSINESS_UPLOAD_MSG_SIZE = 100;
    public static final long CHANNEL_HTTP_FIRST = 1;
    public static final long CHANNEL_WS_FIRST = 0;
    public static final String DB_V4 = "bd_sync_sdk_v4.db";
    public static final String DEVICE_ID = "device_id";
    public static final String DIR_NAME = "bd_sync_sdk";
    public static final int DOWN_STREAM_SERVICE_ID = 20032;
    public static final int ERROR_UNKNOWN = 1;
    public static final long EVENT_BLOCK_TIME = 2000;
    public static final String FLAG_CLOSE_AND_CLEAR = "1002";
    public static final String FLAG_CLOSE_SYNC = "1001";
    public static final String FLAG_SYNC = "x-bytesync-flag";
    public static final String KEY_SETTING = "server_settings";
    public static final String KEY_VERSION_CODE = "bytesync_sdk_version";
    public static final int MAX_PATCH_SIZE = 100;
    public static final int METHOD_ID = 1;
    public static final int METHOD_ID_V2 = 2;
    public static final String MONITOR_CHANNEL_HTTP = "http";
    public static final String MONITOR_CHANNEL_WS = "frontier";
    public static final int MONITOR_STATUS_CURSOR_TOO_LARGE = 2;
    public static final int MONITOR_STATUS_CURSOR_TOO_SMALL = 1;
    public static final int MONITOR_STATUS_CURSOR_UNKNOWN = 3;
    public static final int NOTIFY_LIMIT = 50;
    public static final String PREV_VERSION = "bd_sync_sdk_prev_version";
    public static final String SEPARATOR = "_";
    public static final int SIZE_PENDING_TASK = 200;
    public static final String SP_NAME = "byte_sync_settings";
    public static final int SUCCESS = 0;
    public static final String SYNC_ENABLE = "sync_enable";
    public static final long SYNC_SETTING_BUSINESS_ID = 1;
    public static final long TIMESTAMP_WS_BLOCK = 5000;
    public static final String UTF_8 = "UTF-8";
    public static final List<Long> SYNC_MOCK_BUSINESS_ID_LIST = Arrays.asList(2L, 3L, 4L, 5L);
    public static final CharSequence GZIP = "gzip";
}
