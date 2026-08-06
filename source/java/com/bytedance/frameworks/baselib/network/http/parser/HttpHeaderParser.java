package com.bytedance.frameworks.baselib.network.http.parser;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class HttpHeaderParser {
    public static String parseCharset(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (TextUtils.isEmpty(str2)) {
            str2 = map.get("Content-Type".toLowerCase());
        }
        if (str2 != null) {
            String[] split = str2.split(";");
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static String parseCharset(Map<String, String> map) {
        return parseCharset(map, "ISO-8859-1");
    }
}
