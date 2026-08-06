package com.ss.android.update;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public class Utils {
    public static void safePutJsonKV(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
