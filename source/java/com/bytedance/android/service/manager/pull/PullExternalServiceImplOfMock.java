package com.bytedance.android.service.manager.pull;

import android.content.Context;
import android.util.Log;
import com.bytedance.push.pull.PullScene;

/* loaded from: classes3.dex */
public class PullExternalServiceImplOfMock implements PullExternalService {
    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void initOnApplication() {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void requestAndShowContent(String str) {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void setBadgeNumberToPushSdk(Context context, int i, PullScene pullScene) {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public void start(PullConfiguration pullConfiguration) {
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewApi() {
        Log.w("PullExternalService", "cur isUseNewApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewApi(int i) {
        Log.w("PullExternalService", "cur isUseNewApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isNeedRequestOldComposeApi(int i) {
        Log.w("PullExternalService", "cur isNeedRequestOldComposeApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewOnlineRedBadgeApi() {
        Log.w("PullExternalService", "cur isUseNewOnlineRedBadgeApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewOnlineLocalPushApi() {
        Log.w("PullExternalService", "cur isUseNewOnlineLocalPushApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewAllianceRedBadgeApi() {
        Log.w("PullExternalService", "cur isUseNewAllianceRedBadgeApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean isUseNewAllianceLocalPushApi() {
        Log.w("PullExternalService", "cur isUseNewAllianceLocalPushApi method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }

    @Override // com.bytedance.android.service.manager.pull.PullExternalService
    public boolean allowAutoDismissBadge() {
        Log.w("PullExternalService", "cur allowAutoDismissBadge method is empty impl in PullExternalServiceImplOfMockClass");
        return false;
    }
}
