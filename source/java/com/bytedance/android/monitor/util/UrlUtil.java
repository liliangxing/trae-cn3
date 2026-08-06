package com.bytedance.android.monitor.util;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class UrlUtil {
    public static String getPath(String str) {
        try {
            return Uri.parse(str).getPath();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String formatUrlKey(String str) {
        int indexOf;
        return (!TextUtils.isEmpty(str) && (indexOf = str.indexOf("?")) >= 0) ? str.substring(0, indexOf) : str;
    }
}
