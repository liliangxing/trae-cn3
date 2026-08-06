package com.bytedance.crash.runtime;

import android.text.TextUtils;
import com.bytedance.crash.monitor.MonitorManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class SettingManager {
    public static final int AID_DEFAULT = 4444;
    private final int mAid = -1;
    private String mDid;

    public void setDeviceId(String str) {
        this.mDid = str;
    }

    public int getAid() {
        try {
            return Integer.parseInt(MonitorManager.getAppMonitorAid());
        } catch (Throwable unused) {
            return AID_DEFAULT;
        }
    }

    public String getDeviceId() {
        if (TextUtils.isEmpty(this.mDid)) {
            this.mDid = "0";
        }
        return this.mDid;
    }

    public boolean isDidSet() {
        return (TextUtils.isEmpty(this.mDid) || "0".equals(this.mDid)) ? false : true;
    }
}
