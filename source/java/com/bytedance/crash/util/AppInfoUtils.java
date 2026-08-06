package com.bytedance.crash.util;

import com.bytedance.crash.dumper.BytestConfig;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class AppInfoUtils {
    public static String getBytraceId() {
        return BytestConfig.getBytraceId();
    }

    public static void expandFilters(JSONObject jSONObject) {
        BytestConfig.expandFilters(jSONObject);
    }
}
