package com.bytedance.bdinstall.intf;

import com.bytedance.bdinstall.util.RomUtils;

/* loaded from: classes3.dex */
public interface IAdIdConfig {
    boolean enablePrefetchAdId();

    long getAdIdWaitTime();

    /* loaded from: classes3.dex */
    public static class AdIdConfig implements IAdIdConfig {
        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public long getAdIdWaitTime() {
            return 100L;
        }

        @Override // com.bytedance.bdinstall.intf.IAdIdConfig
        public boolean enablePrefetchAdId() {
            return !RomUtils.isMeizu();
        }
    }
}
