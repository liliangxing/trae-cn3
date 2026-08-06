package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.util;

import java.util.List;

/* loaded from: classes2.dex */
public class HttpDnsUtil {
    private static final String TAG = "HttpDnsUtil";

    public static boolean isValidHost(String str) {
        if (str != null) {
            char[] charArray = str.toCharArray();
            if (charArray.length > 0 && charArray.length <= 255) {
                for (char c : charArray) {
                    if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '.' || c == '-'))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static String transHostList2String(List<String> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(',');
            }
        }
        return sb.toString();
    }
}
