package com.bytedance.ttnet;

import com.bytedance.retrofit2.AppLaunchTimeStampProvider;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class AbsOptionalTTNetDepend implements AppLaunchTimeStampProvider {
    @Override // com.bytedance.retrofit2.AppLaunchTimeStampProvider
    public long getAppStartCPUTimeStamp() {
        return -1L;
    }

    @Override // com.bytedance.retrofit2.AppLaunchTimeStampProvider
    public long getAppStartWallClockTimeStamp() {
        return -1L;
    }

    public String[] getHttpDnsHardCodeIps() {
        return null;
    }

    public String[] getPreloadDomains() {
        return null;
    }

    public int getProcessFlag() {
        return 0;
    }

    public boolean getRefineAppDelayEnable() {
        return true;
    }

    public Map<String, String> getTNCExtraParam() {
        return null;
    }

    public boolean isPrivacyAccessEnabled() {
        return false;
    }
}
