package com.bytedance.android.monitor.webview.abtest;

import android.net.Uri;
import android.webkit.WebView;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.util.JsonUtils;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorHelper;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AbData {
    private long mData;

    public void onPageStarted(String str) {
        if (HybridMonitor.getInstance().isAbTestEnable()) {
            this.mData = System.currentTimeMillis();
        }
    }

    public void onPageEnd(WebView webView, String str) {
        if (HybridMonitor.getInstance().isAbTestEnable()) {
            long j = this.mData;
            if (j != 0) {
                long currentTimeMillis = System.currentTimeMillis() - j;
                if (currentTimeMillis > 0) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        Uri parse = Uri.parse(str);
                        JsonUtils.safePut(jSONObject, "url", parse.toString());
                        JsonUtils.safePut(jSONObject, "host", parse.getHost());
                        JsonUtils.safePut(jSONObject, "path", parse.getPath());
                        JsonUtils.safePut(jSONObject, "hybrid_monitor_switch", "false");
                        JsonUtils.safePut(jSONObject, "js_inject_switch", "false");
                        JsonUtils.safePut(jSONObject, "container_type", "web");
                        JSONObject jSONObject2 = new JSONObject();
                        JsonUtils.safePut(jSONObject2, "web_page_cost", currentTimeMillis);
                        TTLiveWebViewMonitorHelper.getInstance().customReport(webView, str, "performance_test", jSONObject.toString(), jSONObject2.toString(), null, "0");
                        TTLiveWebViewMonitorHelper.getInstance().report(webView);
                        this.mData = 0L;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
