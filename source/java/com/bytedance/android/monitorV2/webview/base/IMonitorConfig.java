package com.bytedance.android.monitorV2.webview.base;

import com.bytedance.android.monitorV2.webview.IWebViewMonitorHelper;

/* loaded from: classes3.dex */
public interface IMonitorConfig {
    void addConfig(IWebViewMonitorHelper.Config config);

    IWebViewMonitorHelper.Config buildConfig();

    void removeConfig(String... strArr);
}
