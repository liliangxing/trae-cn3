package com.ss.android.ugc.quota;

import java.util.Map;

/* loaded from: classes7.dex */
public class BDNetworkTagContextProviderAdapter implements IBDNetworkTagContextProvider {
    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public Map<String, Object> extra() {
        return null;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int triggerType() {
        return 1;
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public boolean markAsNewUser() {
        return BDNetworkTagManager.getInstance().isFirstInstallLaunch();
    }

    @Override // com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public int launchType() {
        int currentLaunchType = BDNetworkTagManager.getInstance().currentLaunchType();
        if (currentLaunchType == -999 || currentLaunchType == -1 || currentLaunchType == 0 || currentLaunchType == 1 || currentLaunchType == 2) {
            return currentLaunchType;
        }
        throw new IllegalStateException("BDNetworkTagManager#updateLaunchType should be called while launch type changed");
    }
}
