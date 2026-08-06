package com.ss.android.download.api.constant;

/* loaded from: classes7.dex */
public class BaseConstants {
    public static final int ACTION_TYPE_BUTTON = 2;
    public static final int ACTION_TYPE_ITEM = 1;
    public static final String CATEGORY_UMENG = "umeng";
    public static final String EVENT_LABEL_AD_EXTRA_DATA = "ad_extra_data";
    public static final String EVENT_LABEL_EXTRA = "extra";
    public static final String EVENT_LABEL_IS_AD_EVENT = "is_ad_event";
    public static final String EVENT_LABEL_LOG_EXTRA = "log_extra";
    public static final int EVENT_SOURCE_SDK_INSIDE = 2;
    public static final int EVENT_SOURCE_USER = 1;
    public static final int MSG_STATUS_CHANGED_FROM_CLICK = 2;
    public static final int MSG_STATUS_CHANGED_FROM_LISTENER = 1;
    public static final int TOAST_SHOW_TIME_LONG = 2000;
    public static final int TOAST_SHOW_TIME_SHORT = 1000;

    /* loaded from: classes7.dex */
    public interface DownloadConstants {
        public static final int ACTION_UNKNOWN = 0;
        public static final String BIND_APP_EXTRA = "bind_app";
        public static final int STATUS_FAILED = 16;
        public static final int STATUS_INSTALLED = 32;
        public static final int STATUS_PAUSED = 4;
        public static final int STATUS_PENDING = 1;
        public static final int STATUS_RUNNING = 2;
        public static final int STATUS_SUCCESSFUL = 8;
        public static final int TYPE_ACTIVE = 1;
        public static final int TYPE_COMPLETE = 3;
        public static final int TYPE_FAILED = 4;
        public static final int TYPE_IDLE = 0;
        public static final int TYPE_WAITING = 2;
    }

    /* loaded from: classes7.dex */
    public interface DownloadManager {
        public static final String ACTION_DOWNLOAD_COMPLETE = "android.ss.intent.action.DOWNLOAD_COMPLETE";
        public static final String ACTION_NOTIFICATION_CLICKED = "android.ss.intent.action.DOWNLOAD_NOTIFICATION_CLICKED";
        public static final String ACTION_VIEW_DOWNLOADS = "android.ss.intent.action.VIEW_DOWNLOADS";
        public static final String COLUMN_ALLOW_WRITE = "allow_write";
        public static final String COLUMN_BYTES_DOWNLOADED_SO_FAR = "bytes_so_far";
        public static final String COLUMN_DESCRIPTION = "description";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
        public static final String COLUMN_LOCAL_FILENAME = "local_filename";
        public static final String COLUMN_LOCAL_URI = "local_uri";
        public static final String COLUMN_MEDIAPROVIDER_URI = "mediaprovider_uri";
        public static final String COLUMN_MEDIA_TYPE = "media_type";
        public static final String COLUMN_REASON = "reason";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_TOTAL_SIZE_BYTES = "total_size";
        public static final String COLUMN_URI = "uri";
        public static final int DISPLAY_POSITION_ADBUTTON_DETAIL = 6;
        public static final int DISPLAY_POSITION_ADBUTTON_FEED = 7;
        public static final int DISPLAY_POSITION_COMMENT = 3;
        public static final int DISPLAY_POSITION_DETAIL = 2;
        public static final int DISPLAY_POSITION_DETAIL_CREATIVENESS = 5;
        public static final int DISPLAY_POSITION_FEED = 1;
        public static final int DISPLAY_POSITION_WAP = 4;
        public static final int ERROR_BLOCKED = 1010;
        public static final int ERROR_CANCELED = 1012;
        public static final int ERROR_CANNOT_RESUME = 1008;
        public static final int ERROR_DEVICE_NOT_FOUND = 1007;
        public static final int ERROR_FILE_ALREADY_EXISTS = 1009;
        public static final int ERROR_FILE_ERROR = 1001;
        public static final int ERROR_HTTPS_DATA_ERROR = 1011;
        public static final int ERROR_HTTP_DATA_ERROR = 1004;
        public static final int ERROR_INSUFFICIENT_SPACE = 1006;
        public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
        public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
        public static final int ERROR_UNKNOWN = 1000;
        public static final int EV_CLICK_CONTINUE = 3;
        public static final int EV_CLICK_DELETE = 7;
        public static final int EV_CLICK_INSTALL = 6;
        public static final int EV_CLICK_PAUSE = 2;
        public static final int EV_DOWNLOAD_FAILED = 5;
        public static final int EV_DOWNLOAD_FINISH = 1;
        public static final int EV_INSTALL_FINISH = 4;
        public static final String EXTRA_APP_PACKAGE = "extra_app_package";
        public static final String EXTRA_DOWNLOAD_ID = "extra_download_id";
        public static final String EXTRA_DOWNLOAD_VISIBILITY = "extra_download_visibility";
        public static final String EXTRA_NOTIFICATION_CLICK_DOWNLOAD_IDS = "extra_click_download_ids";
        public static final String EXTRA_NOTIFICATION_TAG = "extra_notification_tag";
        public static final String INTENT_EXTRAS_SORT_BY_SIZE = "android.app.DownloadManager.extra_sortBySize";
        public static final int PAUSED_QUEUED_FOR_WIFI = 3;
        public static final int PAUSED_UNKNOWN = 4;
        public static final int PAUSED_WAITING_FOR_NETWORK = 2;
        public static final int PAUSED_WAITING_TO_RETRY = 1;
        public static final int STATUS_FAILED = 16;
        public static final int STATUS_INSTALLED = 32;
        public static final int STATUS_PAUSED = 4;
        public static final int STATUS_PENDING = 1;
        public static final int STATUS_RUNNING = 2;
        public static final int STATUS_SUCCESSFUL = 8;
    }

    /* loaded from: classes7.dex */
    public interface DownloadNotifier {
        public static final String BIND_APP_EXTRA = "bind_app";
        public static final String EXTRA_STRING_SPLITTER = "##";
        public static final int TYPE_ACTIVE = 1;
        public static final int TYPE_COMPLETE = 3;
        public static final int TYPE_FAILED = 4;
        public static final int TYPE_IDLE = 0;
        public static final int TYPE_WAITING = 2;
    }

    /* loaded from: classes7.dex */
    public interface Request {
        public static final int NETWORK_MOBILE = 1;
        public static final int NETWORK_WIFI = 2;
        public static final int VISIBILITY_HIDDEN = 2;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_NOTIFY_COMPLETED = 1;
        public static final int VISIBILITY_VISIBLE_NOTIFY_ONLY_COMPLETION = 3;
    }
}
