package com.bytedance.apm.block;

import java.util.Map;

/* loaded from: classes3.dex */
public class BlockDetectorUtil {
    public static Map<String, String> tags;

    public static void addUserDataTags(Map<String, String> map) {
        tags = map;
    }

    public static Map<String, String> getTags() {
        return tags;
    }
}
