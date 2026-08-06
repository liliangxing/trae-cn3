package com.bytedance.push.interfaze;

import android.app.NotificationChannel;
import com.bytedance.push.Keep;

/* loaded from: classes4.dex */
public interface IMonitor extends Keep {
    void init();

    void markOuterSwitchStatusFailed(int i, String str);

    void markOuterSwitchStatusSuccess();

    void markOuterSwitchUploadFailed(int i, String str);

    void markOuterSwitchUploadSuccess();

    void markUpdateSenderFailed(int i, int i2, String str, String str2);

    void markUpdateSenderSuccess();

    void monitorDecryptResult(int i, int i2);

    void monitorEvent(String str, String str2);

    void monitorHarmonyOs4Compliance(boolean z, int i);

    void monitorInitTimeCoast(long j);

    void monitorNotificationCreate(NotificationChannel notificationChannel);

    void monitorRegisterSender(int i);

    void monitorRegisterSenderFailed(int i, int i2, String str, String str2);

    void monitorRegisterSenderSuccess(int i);

    void monitorSenderSupport(boolean z, String str);

    void monitorShowEmpty(int i, String str, int i2, int i3);

    void monitorStart();
}
