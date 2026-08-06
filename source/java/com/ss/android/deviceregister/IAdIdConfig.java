package com.ss.android.deviceregister;

import com.bytedance.bdinstall.intf.IAdIdConfig;

/* loaded from: classes7.dex */
public interface IAdIdConfig {
    boolean enablePrefetchAdId();

    long getAdIdWaitTime();

    /* loaded from: classes7.dex */
    public static class AdIdConfig implements IAdIdConfig {
        com.bytedance.bdinstall.intf.IAdIdConfig adIdConfig = new IAdIdConfig.AdIdConfig();

        @Override // com.ss.android.deviceregister.IAdIdConfig
        public long getAdIdWaitTime() {
            return this.adIdConfig.getAdIdWaitTime();
        }

        @Override // com.ss.android.deviceregister.IAdIdConfig
        public boolean enablePrefetchAdId() {
            return this.adIdConfig.enablePrefetchAdId();
        }
    }
}
