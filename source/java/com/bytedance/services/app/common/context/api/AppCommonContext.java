package com.bytedance.services.app.common.context.api;

import android.content.Context;
import com.bytedance.news.common.service.manager.IService;

/* loaded from: classes5.dex */
public interface AppCommonContext extends IService {
    String getAbClient();

    String getAbFeature();

    @Deprecated
    long getAbFlag();

    String getAbGroup();

    String getAbVersion();

    int getAid();

    String getAppName();

    String getChannel();

    Context getContext();

    String getDeviceId();

    String getFeedbackAppKey();

    String getManifestVersion();

    int getManifestVersionCode();

    String getSdkAppId();

    String getStringAppName();

    String getTweakedChannel();

    int getUpdateVersionCode();

    String getVersion();

    int getVersionCode();
}
