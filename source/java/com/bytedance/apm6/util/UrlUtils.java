package com.bytedance.apm6.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

/* loaded from: classes3.dex */
public class UrlUtils {
    static int SDK_VERSION = 1;

    public static String addParamsToURL(String str, Map<String, String> map) {
        if (!TextUtils.isDigitsOnly(str) && map != null && !map.isEmpty()) {
            if (str.indexOf("?") < 0) {
                str = str + "?";
            }
            if (str.endsWith("?")) {
                str = str + encode("sdk_version", "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + encode(String.valueOf(SDK_VERSION), "UTF-8");
            } else {
                str = str + ContainerUtils.FIELD_DELIMITER + encode("sdk_version", "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + encode(String.valueOf(SDK_VERSION), "UTF-8");
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (map.get(entry.getKey()) != null) {
                        if (str.endsWith("?")) {
                            str = str + encode(entry.getKey().toString(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + encode(map.get(entry.getKey()).toString(), "UTF-8");
                        } else {
                            str = str + ContainerUtils.FIELD_DELIMITER + encode(entry.getKey().toString(), "UTF-8") + ContainerUtils.KEY_VALUE_DELIMITER + encode(map.get(entry.getKey()).toString(), "UTF-8");
                        }
                    }
                }
            }
        }
        return str;
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "UTF-8";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String sanitizeUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            URL url = new URL(str);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(url.getProtocol());
            stringBuffer.append("://");
            stringBuffer.append(url.getHost());
            if (url.getPort() != -1) {
                stringBuffer.append(Constants.COLON_SEPARATOR);
                stringBuffer.append(url.getPort());
            }
            stringBuffer.append(url.getPath());
            return stringBuffer.toString();
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
