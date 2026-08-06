package com.bytedance.sdk.account.utils;

import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TypeUtils {
    public static long parseLong(String str, long j) {
        if (str != null && !str.isEmpty()) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
            }
        }
        return j;
    }

    public static Map<String, String> convertPairListToMap(List<Pair<String, String>> list) {
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (Pair<String, String> pair : list) {
            if (!TextUtils.isEmpty((CharSequence) pair.first) && !TextUtils.isEmpty((CharSequence) pair.second)) {
                hashMap.put(pair.first, pair.second);
            }
        }
        return hashMap;
    }
}
