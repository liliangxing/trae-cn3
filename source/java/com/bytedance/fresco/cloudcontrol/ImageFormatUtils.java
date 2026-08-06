package com.bytedance.fresco.cloudcontrol;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public class ImageFormatUtils {
    private static Set<String> customFormats = new LinkedHashSet(Arrays.asList("webp", "jpeg", "png", "image"));

    public static void addCustomFormat(String str) {
        customFormats.add(str);
    }

    public static void setCustomFormats(Set<String> set) {
        customFormats.addAll(set);
    }

    public static String getExpectImageFormat() {
        if (CloudControl.getStaticAdaptivePolicy() == null) {
            return "image";
        }
        for (String str : CloudControl.getStaticAdaptivePolicy()) {
            if (customFormats.contains(str)) {
                return str;
            }
        }
        return "image";
    }
}
