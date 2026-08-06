package com.bytedance.crash.monitor;

import com.bytedance.crash.Global;
import com.bytedance.crash.UserDataCenter;
import com.bytedance.crash.event.EnsureDeliverer;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class AppMonitor extends CrashListener {
    private static final UserDataCenter sUserDataCenter = new UserDataCenter();

    @Override // com.bytedance.crash.monitor.EventMonitor
    public Map<String, Object> getCommParams() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UserDataCenter getDefaultUserDataCenter() {
        return sUserDataCenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppMonitor(String str, String str2, long j) {
        super(sUserDataCenter, str, str2, j);
        Global.setAppVersion(j, 0L, 0L, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppMonitor() {
        super(sUserDataCenter);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class Holder {
        public static final AppMonitor DEFAULT = new AppMonitor("4444", "0", 0);

        private Holder() {
        }
    }

    public static AppMonitor getDefault() {
        return Holder.DEFAULT;
    }

    public AppVersionModel getVersionByAppUpdateTime(long j) {
        return this.mCacheManager.getVersionAfter(j);
    }

    @Override // com.bytedance.crash.monitor.EventMonitor
    public EnsureDeliverer getEnsureDeliver() {
        EnsureDeliverer appEnsureManager = MonitorManager.getAppEnsureManager();
        appEnsureManager.setMonitor(this);
        return appEnsureManager;
    }
}
