package com.bytedance.falconx.utils;

import android.webkit.WebResourceResponse;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class WebResourceUtils {
    public static WebResourceResponse getResponse(String str, String str2, InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Access-Control-Allow-Origin", "*");
            hashMap.put("Content-Type", str);
            if ("font/ttf".equals(str)) {
                return new WebResourceResponse(str, str2, 200, "OK", hashMap, inputStream);
            }
            WebResourceResponse webResourceResponse = new WebResourceResponse(str, str2, inputStream);
            webResourceResponse.setResponseHeaders(hashMap);
            return webResourceResponse;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
