package com.bytedance.android.monitor.webview.base;

import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitorHelper;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public interface IMonitorConfig {
    void addConfig(ITTLiveWebViewMonitorHelper.Config config);

    ITTLiveWebViewMonitorHelper.Config buildConfig();

    @Deprecated
    void setDefaultConfig(ITTLiveWebViewMonitorHelper.Config config);
}
