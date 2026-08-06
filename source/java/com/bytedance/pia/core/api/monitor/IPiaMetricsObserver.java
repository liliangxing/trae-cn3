package com.bytedance.pia.core.api.monitor;

import android.webkit.WebView;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IPiaMetricsObserver {
    void onMetrics(String str, WebView webView, Map<String, Object> map, Map<String, Object> map2);
}
