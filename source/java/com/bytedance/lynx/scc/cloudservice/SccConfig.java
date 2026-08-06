package com.bytedance.lynx.scc.cloudservice;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.lynx.scc.cloudservice.utils.SccUtils;
import com.bytedance.upc.Constants;

/* loaded from: classes4.dex */
public class SccConfig {
    public static final String CS_LINK = "https://scc.bytedance.com/scc_sdk/url_scan_v4?scc_mode=coreless&scc_from=Bullet&scc_sdk_version=30";
    private static final int SCC_VERSION = 30;
    private String mServiceUrl = CS_LINK;

    public String getServiceUrl() {
        return this.mServiceUrl;
    }

    public void setServiceUrl(String serviceUrl, String from) {
        if (TextUtils.isEmpty(serviceUrl)) {
            Log.d(SccUtils.LOG_TAG, "set service url is empty!");
            return;
        }
        Uri.Builder buildUpon = Uri.parse(this.mServiceUrl).buildUpon();
        buildUpon.appendQueryParameter("scc_mode", "coreless");
        if (TextUtils.isEmpty(from)) {
            from = "unknown";
        }
        buildUpon.appendQueryParameter("scc_from", from);
        buildUpon.appendQueryParameter("scc_sdk_version", Constants.CONTENT_RICHNESS_EXPANSION_FREQUENCY_TEEN_MODE);
        this.mServiceUrl = buildUpon.build().toString();
    }

    public String toString() {
        return "SccConfig{mServiceUrl='" + this.mServiceUrl + "'}";
    }
}
