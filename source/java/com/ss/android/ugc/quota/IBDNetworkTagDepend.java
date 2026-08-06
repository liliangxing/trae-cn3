package com.ss.android.ugc.quota;

import com.ss.android.ugc.quota.launch.IBDNetworkLaunchMonitor;

/* loaded from: classes7.dex */
public interface IBDNetworkTagDepend {
    boolean enable();

    boolean isNewInstall();

    IBDNetworkLaunchMonitor launchMonitor();

    void onLaunchTypeUpdate(int i);
}
