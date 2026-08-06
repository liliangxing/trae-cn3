package com.vivo.push.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.ss.android.common.util.NetUtils;

/* compiled from: NetUtils.java */
/* renamed from: com.vivo.push.util.x */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1397x {
    /* renamed from: a */
    public static NetworkInfo m1056a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            C1393t.m1036a(NetUtils.TAG, e);
            return null;
        }
    }
}
