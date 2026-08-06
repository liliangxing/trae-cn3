package com.bytedance.ug.sdk.deeplink.utils;

import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class CollectionsUtils {
    public static boolean isEmptyList(List list) {
        return list == null || list.size() <= 0;
    }

    public static boolean isEmptyMap(Map map) {
        return map == null || map.size() <= 0;
    }

    public static boolean isNotEmptyMap(Map map) {
        return map != null && map.size() > 0;
    }
}
