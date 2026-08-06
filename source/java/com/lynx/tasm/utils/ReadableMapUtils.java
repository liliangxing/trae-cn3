package com.lynx.tasm.utils;

import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.text.TextHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ReadableMapUtils {
    public static Map<String, String> ConvertReadableMapToStringStringMap(ReadableMap readableMap) {
        HashMap hashMap = new HashMap();
        HashMap asHashMap = readableMap.asHashMap();
        for (String str : asHashMap.keySet()) {
            Object obj = asHashMap.get(str);
            if (obj instanceof List) {
                hashMap.put(str, android.text.TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, (Iterable) obj));
            } else if (obj instanceof Number) {
                hashMap.put(str, TextHelper.formatDoubleToStringManually(((Number) obj).doubleValue()));
            } else if (obj != null) {
                hashMap.put(str, obj.toString());
            }
        }
        return hashMap;
    }
}
