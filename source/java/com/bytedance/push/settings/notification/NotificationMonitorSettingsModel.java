package com.bytedance.push.settings.notification;

import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.ss.android.message.AppProvider;
import java.util.List;

/* loaded from: classes4.dex */
public class NotificationMonitorSettingsModel {
    private static volatile NotificationMonitorSettingsModel sNotificationMonitorSettingsModel;
    public boolean allowInterceptForegroundNotification;
    public List<String> blackFiledList;
    public boolean enableMonitorNotificationShow;
    public List<String> groupNameList;
    public List<String> groupTagList;
    public List<List<String>> interceptStack;
    public long minMonitorInterval;
    public boolean needInterceptCancelError;
    public boolean needInterceptEmptyNotification;
    public boolean needInterceptGroup;
    public boolean needInterceptPendingIntentError;
    public boolean needInterceptStick;
    public List<String> needInterceptStyleList;
    public boolean needInterceptTop;
    public boolean reportValidNotification;
    public List<TargetNotificationMonitorModel> targetNotificationMonitorModelList;
    public List<String> whiteGroupList;

    public static NotificationMonitorSettingsModel getIns() {
        if (sNotificationMonitorSettingsModel == null) {
            synchronized (NotificationMonitorSettingsModel.class) {
                if (sNotificationMonitorSettingsModel == null) {
                    sNotificationMonitorSettingsModel = ((PushOnlineSettings) SettingsManager.obtain(AppProvider.getApp(), PushOnlineSettings.class)).getNotificationMonitorSettings();
                }
            }
        }
        return sNotificationMonitorSettingsModel;
    }
}
