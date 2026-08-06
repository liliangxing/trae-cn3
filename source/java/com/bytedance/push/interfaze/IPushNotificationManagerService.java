package com.bytedance.push.interfaze;

import android.content.Context;

/* loaded from: classes4.dex */
public interface IPushNotificationManagerService {
    public static final String METHD_NAME_CREATE_NOTIFICATION_CHANNELS = "createNotificationChannels";
    public static final String METHOD_NAME_NOTIFY_NOTIFICATION = "enqueueNotificationWithTag";
    public static final String PERMISSTION_POST_NOTIFICATIONS = "android.permission.POST_NOTIFICATIONS";
    public static final int REQUEST_CODE_POST_NOTIFICATIONS = 61519;

    void init(Context context);

    void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    boolean requestNotificationPermission();

    boolean requestNotificationPermission(IRequestNotificationPermissionCallback iRequestNotificationPermissionCallback);
}
