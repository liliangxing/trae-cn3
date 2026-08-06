package com.bytedance.apm.trace.mapping;

import java.util.HashMap;

/* loaded from: classes3.dex */
public final class ApmPageLoadMappingTool {
    private static HashMap<String, Integer> sPageViewIdMap = new HashMap<>();

    static {
        initMap();
    }

    public static void put(String str, int i) {
        sPageViewIdMap.put(str, Integer.valueOf(i));
    }

    private static void initMap() {
        put("xx", 12334);
    }

    public static HashMap<String, Integer> getsPageViewIdMap() {
        return sPageViewIdMap;
    }

    public static Integer queryViewId(String str) {
        return sPageViewIdMap.get(str);
    }
}
