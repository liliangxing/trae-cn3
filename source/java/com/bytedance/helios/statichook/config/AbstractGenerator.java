package com.bytedance.helios.statichook.config;

/* loaded from: classes3.dex */
public class AbstractGenerator {
    public static String generate(String str) {
        char[] charArray = str.toCharArray();
        long j = 0;
        for (int i = 0; i < str.length(); i++) {
            j = (j * 31) + charArray[i];
        }
        return String.valueOf(j);
    }
}
