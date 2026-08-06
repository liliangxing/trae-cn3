package com.bytedance.android.service.manager.pull;

import android.content.Context;
import com.bytedance.android.push.service.manager.annotation.ExternalService;
import com.bytedance.push.pull.PullScene;

@ExternalService
/* loaded from: classes3.dex */
public interface PullExternalService {
    boolean allowAutoDismissBadge();

    void initOnApplication();

    boolean isNeedRequestOldComposeApi(int i);

    boolean isUseNewAllianceLocalPushApi();

    boolean isUseNewAllianceRedBadgeApi();

    boolean isUseNewApi();

    boolean isUseNewApi(int i);

    boolean isUseNewOnlineLocalPushApi();

    boolean isUseNewOnlineRedBadgeApi();

    void requestAndShowContent(String str);

    void setBadgeNumberToPushSdk(Context context, int i, PullScene pullScene);

    void start(PullConfiguration pullConfiguration);
}
