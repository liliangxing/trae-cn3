package com.bytedance.crash;

import com.bytedance.crash.monitor.MonitorManager;
import com.bytedance.crash.util.ListMap;
import java.util.List;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppDataCenter extends ListMap<CrashType, AttachUserData> {
    public List<AttachUserData> getAttachUserData(CrashType crashType) {
        if (MonitorManager.getAppMonitor() == null) {
            return null;
        }
        return MonitorManager.getAppMonitor().getUserDataCenter().getAttachUserData(crashType);
    }
}
