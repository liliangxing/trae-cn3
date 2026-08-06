package com.vivo.push;

/* loaded from: classes7.dex */
public final class PushClientConstants {
    public static final String COM_ANDROID_SYSTEMUI = "com.android.systemui";
    public static final String NOTIFICATION_PERMISSION_ACTION = "com.android.notification.permission.action.FRONT";
    public static final String PUSH_APP_ALIAS = "com.vivo.pushservice.app.alias";
    public static final String PUSH_APP_TAGS = "com.vivo.pushservice.app.tags";
    public static final String TAG_CLASS_NAME = "className";
    public static final String TAG_PARAM_KEYS = "paramKeys";
    public static final String TAG_PARAM_TYPES = "paramTypes";
    public static final String TAG_PARAM_VALS = "paramVals";
    public static final String TAG_PKG_NAME = "pkgName";

    /* loaded from: classes7.dex */
    public interface NotifyDialogState {
        public static final int CLICK_NO = 2;
        public static final int CLICK_OK = 1;
        public static final int OTHER_DISMISS = 4;
        public static final int PRESS_BACK_DISMISS = 3;
        public static final int SHOW = 0;
        public static final int SHOW_FAIL = -1;
    }
}
