package com.bytedance.frameworks.baselib.network.connectionclass;

/* loaded from: classes2.dex */
public class CdnDeviceBandwidthSampler extends DeviceBandwidthSampler {

    /* loaded from: classes2.dex */
    private static class CdnDeviceBandwidthSamplerHolder {
        public static final CdnDeviceBandwidthSampler instance = new CdnDeviceBandwidthSampler(CdnConnectionClassManager.getInstance());

        private CdnDeviceBandwidthSamplerHolder() {
        }
    }

    public static CdnDeviceBandwidthSampler getInstance() {
        return CdnDeviceBandwidthSamplerHolder.instance;
    }

    private CdnDeviceBandwidthSampler(CdnConnectionClassManager cdnConnectionClassManager) {
        super(cdnConnectionClassManager);
    }
}
