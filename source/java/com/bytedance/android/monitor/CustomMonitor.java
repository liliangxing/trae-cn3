package com.bytedance.android.monitor;

import android.os.Looper;
import com.bytedance.android.monitor.entity.CustomInfo;
import com.bytedance.android.monitor.executor.MonitorExecutor;
import com.bytedance.android.monitor.webview.ITTLiveWebViewMonitor;
import com.bytedance.android.monitor.webview.TTLiveWebViewMonitorDefault;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CustomMonitor {
    private ITTLiveWebViewMonitor defaultMonitor = new TTLiveWebViewMonitorDefault();

    public void setMonitor(ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        this.defaultMonitor = iTTLiveWebViewMonitor;
    }

    public ITTLiveWebViewMonitor getMonitor() {
        return this.defaultMonitor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void report(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z) {
        report(str, str2, str3, jSONObject, jSONObject2, jSONObject3, jSONObject4, z, this.defaultMonitor);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void report(String str, String str2, String str3, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, boolean z, ITTLiveWebViewMonitor iTTLiveWebViewMonitor) {
        report(new CustomInfo.Builder(str3).setUrl(str).setBiz(str2).setCategory(jSONObject).setMetric(jSONObject2).setExtra(jSONObject3).setCommon(jSONObject4).setEnableSample(z).setMonitor(iTTLiveWebViewMonitor).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void report(final CustomInfo customInfo) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            MonitorExecutor.INSTANCE.getExecutor().submit(new Runnable() { // from class: com.bytedance.android.monitor.CustomMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    DataMonitor.monitorCustom(customInfo);
                }
            });
        } else {
            DataMonitor.monitorCustom(customInfo);
        }
    }
}
