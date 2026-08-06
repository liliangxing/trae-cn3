package com.bytedance.push.interfaze;

import android.content.Context;
import com.bytedance.push.Configuration;
import com.bytedance.push.Keep;
import com.bytedance.push.model.PushNotificationChannel;
import com.bytedance.push.model.SwitcherStatus;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface INotificationService extends Keep {
    String checkAndGetValidChannelId(Context context, String str);

    void createChannels(Context context, List<PushNotificationChannel> list);

    void createDefaultChannel(Context context);

    void createDefaultChannel(Context context, Configuration.Notification notification);

    void getChildrenSwitcherStatus(Context context, boolean z, OnSwitcherServerListener onSwitcherServerListener);

    void sendPushEnableToServer(Context context, boolean z);

    void sendPushEnableToServer(Context context, boolean z, String str);

    void syncChildrenSwitcherChange(Context context, boolean z, SwitcherStatus switcherStatus, OnSwitcherSyncListener onSwitcherSyncListener);

    void syncNotifySwitchStatus(Context context);

    void syncNotifySwitchStatusWithReportingTiming(Context context, String str);

    void trySyncNoticeStateOnce(Context context);

    void trySyncNoticeStateOnceWithReportingTiming(Context context, String str);
}
