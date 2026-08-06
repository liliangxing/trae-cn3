package com.ss.android.common.applog;

import com.bytedance.bdinstall.BDInstall;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BDInstallAdaptor {
    public static void setEnableGetEgdi(boolean z) {
        BDInstall.getBDInstallConfig().setEnableGetEgdi(z);
    }

    public static void setEgdiRetryInterval(int i) {
        BDInstall.getBDInstallConfig().setEgdiRetryInterval(i);
    }
}
