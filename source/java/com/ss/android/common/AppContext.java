package com.ss.android.common;

import android.content.Context;

/* loaded from: classes7.dex */
public interface AppContext {
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

    String getStringAppName();

    String getTweakedChannel();

    int getUpdateVersionCode();

    String getVersion();

    int getVersionCode();
}
