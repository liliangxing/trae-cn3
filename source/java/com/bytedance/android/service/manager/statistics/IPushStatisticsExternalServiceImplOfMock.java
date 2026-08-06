package com.bytedance.android.service.manager.statistics;

import android.content.Context;
import android.util.Log;

/* loaded from: classes3.dex */
public class IPushStatisticsExternalServiceImplOfMock implements IPushStatisticsExternalService {
    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public void onProcessStart() {
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public void onPushStart() {
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public boolean isEnablePushStatistics() {
        Log.w("IPushStatisticsExternalService", "cur isEnablePushStatistics method is empty impl in IPushStatisticsExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public long getValidDeviceDozeDuration(Context context) {
        Log.w("IPushStatisticsExternalService", "cur getValidDeviceDozeDuration method is empty impl in IPushStatisticsExternalServiceImplOfMockClass");
        return 0L;
    }

    @Override // com.bytedance.android.service.manager.statistics.IPushStatisticsExternalService
    public long getValidDeviceKillDuration(Context context) {
        Log.w("IPushStatisticsExternalService", "cur getValidDeviceKillDuration method is empty impl in IPushStatisticsExternalServiceImplOfMockClass");
        return 0L;
    }
}
