package com.bytedance.crash.runtime;

import com.bytedance.crash.ICommonParams;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.InnerAppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import java.util.HashMap;
import java.util.Map;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonParams {
    private static CommonParams sCommonParams;

    public static CommonParams getInstance() {
        if (sCommonParams == null) {
            sCommonParams = new CommonParams();
        }
        return sCommonParams;
    }

    public ICommonParams getCommonParams() {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor instanceof InnerAppMonitor) {
            return ((InnerAppMonitor) appMonitor).getICommonParams();
        }
        return null;
    }

    public Map<String, Object> getParamsMap() {
        HashMap hashMap = new HashMap();
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                hashMap.put("aid", Integer.decode(appMonitor.getAppId()));
                hashMap.put("channel", appMonitor.getChannel());
                hashMap.put("app_version", appMonitor.getVersion().getVersionName());
                hashMap.put("update_version_code", Long.valueOf(appMonitor.getVersion().getVersionCode()));
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static void setMPParams(Map<String, Object> map) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor != null) {
            appMonitor.setMPParams(map);
        }
    }

    public long getUserId() {
        try {
            AppMonitor appMonitor = MonitorManager.getAppMonitor();
            if (appMonitor != null) {
                return appMonitor.getUserId();
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
