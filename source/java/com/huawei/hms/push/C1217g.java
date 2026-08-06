package com.huawei.hms.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hms.support.log.HMSLog;

/* compiled from: NetworkUtil.java */
/* renamed from: com.huawei.hms.push.g */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1217g {
    /* renamed from: a */
    public static int m1956a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return activeNetworkInfo.getType();
        }
        HMSLog.m2120i("NetworkUtil", "no connected network");
        return -1;
    }
}
