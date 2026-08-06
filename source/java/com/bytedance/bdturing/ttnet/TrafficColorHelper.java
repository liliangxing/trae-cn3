package com.bytedance.bdturing.ttnet;

import android.content.Context;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* loaded from: classes3.dex */
public class TrafficColorHelper {
    private static final String TRAFFIC_COLOR_KEY = "x-tt-request-tag";

    public static void addColorToHeader(Context context, String str, Map<String, String> map) {
        try {
            map.put("x-tt-request-tag", ("n=" + (isNewUser(context, str) ? 1 : 0) + ";") + "t=0");
        } catch (Exception unused) {
        }
    }

    private static boolean isNewUser(Context context, String str) throws Exception {
        URL url = new URL(str);
        if (TextUtils.isEmpty(url.getPath()) || !url.getPath().contains("vc/setting")) {
            return true;
        }
        return true ^ context.getSharedPreferences("bd_turning_settings_init", 0).getBoolean("inited", false);
    }
}
