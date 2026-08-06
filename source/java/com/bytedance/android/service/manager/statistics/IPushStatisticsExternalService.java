package com.bytedance.android.service.manager.statistics;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;

@ExternalService
/* loaded from: classes3.dex */
public interface IPushStatisticsExternalService {
    long getValidDeviceDozeDuration(Context context);

    long getValidDeviceKillDuration(Context context);

    boolean isEnablePushStatistics();

    void onProcessStart();

    void onPushStart();
}
