package com.ss.android.deviceregister;

import android.content.Context;
import com.ss.android.deviceregister.base.ILogDepend;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DeviceRegisterInitiator {
    public static void init(Context context, boolean z, ILogDepend iLogDepend, boolean z2, boolean z3, boolean z4, boolean z5) {
        DeviceRegisterManager.setForbidReportPhoneDetailInfo(z);
        DeviceRegisterManager.setILogDepend(iLogDepend);
        DeviceRegisterManager.setAnonymous(z2);
        DeviceRegisterManager.setInitWithActivity(z3);
        DeviceRegisterManager.init(context, z4, z5);
    }
}
