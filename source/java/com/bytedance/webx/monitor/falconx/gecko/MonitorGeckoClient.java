package com.bytedance.webx.monitor.falconx.gecko;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.android.monitor.HybridMonitor;
import com.bytedance.android.monitor.webview.gecko.IMonitorGeckoClient;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import com.bytedance.geckox.utils.ResLoadUtils;
import com.bytedance.webx.monitor.falconx.DigestUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MonitorGeckoClient extends IMonitorGeckoClient {
    private static final String SP_MONITOR_GECKO_CLIENT = "sp_monitor_gecko_client";
    private static final String SP_SAVED_MD5 = "sp_saved_md5";
    private GeckoClient client;
    private String dir;

    /* renamed from: sp */
    private SharedPreferences f9sp;

    public void setClient(GeckoClient geckoClient) {
        this.client = geckoClient;
    }

    public GeckoClient getClient() {
        return this.client;
    }

    public void setResDir(String str) {
        this.dir = str;
    }

    public String getResDir() {
        return this.dir;
    }

    public void checkAndInit() {
        if (this.client == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(getChannel());
        HashMap hashMap = new HashMap();
        hashMap.put("business_version", getVersion());
        this.client.checkUpdateTarget(arrayList, hashMap, new GeckoUpdateListener() { // from class: com.bytedance.webx.monitor.falconx.gecko.MonitorGeckoClient.1
            public void onDownloadSuccess(UpdatePackage updatePackage) {
                super.onDownloadSuccess(updatePackage);
                if (MonitorGeckoClient.this.f9sp == null && HybridMonitor.getInstance().getApplication() != null) {
                    MonitorGeckoClient.this.f9sp = HybridMonitor.getInstance().getApplication().getSharedPreferences(MonitorGeckoClient.SP_MONITOR_GECKO_CLIENT, 0);
                }
                if (MonitorGeckoClient.this.f9sp != null) {
                    MonitorGeckoClient.this.f9sp.edit().putString(MonitorGeckoClient.SP_SAVED_MD5, DigestUtil.md5Hex(new File(MonitorGeckoClient.this.getResDir()))).apply();
                }
            }
        });
    }

    public String getResourcePath() {
        if (this.f9sp == null && HybridMonitor.getInstance().getApplication() != null) {
            this.f9sp = HybridMonitor.getInstance().getApplication().getSharedPreferences(SP_MONITOR_GECKO_CLIENT, 0);
        }
        SharedPreferences sharedPreferences = this.f9sp;
        return (TextUtils.isEmpty(this.dir) || !(sharedPreferences != null ? sharedPreferences.getString(SP_SAVED_MD5, "") : "").equals(DigestUtil.md5Hex(new File(this.dir)))) ? "" : ResLoadUtils.getChannelPath(new File(this.dir), getAccessKey(), getChannel());
    }
}
