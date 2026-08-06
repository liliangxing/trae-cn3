package com.bytedance.crash.resource.tlsmonitor;

import com.bytedance.crash.resource.ResourceMonitorAdapter;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class TLSMonitorAdapter extends ResourceMonitorAdapter {
    private static TLSMonitorAdapter mInstance;
    private TLSMonitorConfig mConfig;

    public static TLSMonitorAdapter get() {
        if (mInstance == null) {
            synchronized (TLSMonitorAdapter.class) {
                if (mInstance == null) {
                    mInstance = new TLSMonitorAdapter();
                }
            }
        }
        return mInstance;
    }

    public static void updateConfig(TLSMonitorConfig tLSMonitorConfig) {
        TLSMonitorAdapter tLSMonitorAdapter = get();
        tLSMonitorAdapter.mConfig = tLSMonitorConfig;
        tLSMonitorAdapter.startMonitor(tLSMonitorConfig);
    }
}
