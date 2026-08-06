package com.bytedance.crash.upload;

import com.bytedance.crash.config.NetConfig;
import com.bytedance.crash.monitor.AppMonitor;
import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.NpthLog;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CrashUploadManager {
    private static volatile CrashUploadManager sInstance;

    public static CrashUploadManager getInstance() {
        if (sInstance == null) {
            sInstance = new CrashUploadManager();
        }
        return sInstance;
    }

    public boolean uploadAlogFile(String str, String str2, String str3, List<String> list) {
        AppMonitor appMonitor = MonitorManager.getAppMonitor();
        if (appMonitor == null) {
            return false;
        }
        NpthLog.m234i("npth", "real upload alog " + str3 + ": " + list);
        try {
            return CrashUploader.uploadAlogFiles(UploaderUrl.appendAlogUrlParams(NetConfig.getAlogUploadUrl(), Integer.parseInt(str), str2, appMonitor.getVersionName(), appMonitor.getUpdateVersionCode()), Integer.parseInt(str), str2, str3, list);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
