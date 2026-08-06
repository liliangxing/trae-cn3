package com.bytedance.push.utils;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes4.dex */
public class ProxyUtils {
    public static boolean isWifiProxy(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }
}
