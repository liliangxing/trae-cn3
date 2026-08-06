package com.bytedance.push.interfaze;

import android.content.Intent;

/* loaded from: classes4.dex */
public interface ISystemBroadcastService {
    public static final String KEY_IS_ENTER = "isEnter";
    public static final String KEY_TYPE_FROM = "typeFrom";
    public static final String MIUI_NOTIFICATION_ACTION = "com.android.systemui.fsgesture";
    public static final String VALUE_TYPE_FROM_STATUS_BAR_EXPANSION = "typefrom_status_bar_expansion";

    /* loaded from: classes4.dex */
    public interface IBroadcastReceiver {
        void onReceiveFromPushSystemBroadcastService(Intent intent);
    }

    void addNotificationBarPullDownListener(IBroadcastReceiver iBroadcastReceiver);
}
