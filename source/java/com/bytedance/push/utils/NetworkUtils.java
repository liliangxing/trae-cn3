package com.bytedance.push.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class NetworkUtils {
    public static boolean isProxyNetwork(Context context) {
        String property = System.getProperty("http.proxyHost");
        String property2 = System.getProperty("http.proxyPort");
        if (property2 == null) {
            property2 = "-1";
        }
        return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
    }

    public static String parsePathFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf(63);
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        try {
            Matcher matcher = Pattern.compile("https?://([^/]+)/(.*)").matcher(str);
            if (matcher.find()) {
                return matcher.group(2);
            }
        } catch (Throwable th) {
            Logger.e("error when parsePathFromUrl:" + th.getLocalizedMessage());
        }
        return str;
    }
}
