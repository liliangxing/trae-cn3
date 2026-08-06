package com.monitor.cloudmessage.utils;

/* loaded from: classes7.dex */
public class DecodeUtils {
    public static String decodeData(byte[] bArr) {
        return com.bytedance.apm.util.DecodeUtils.decodeCloudData(bArr, "");
    }

    public static String decodeData(byte[] bArr, String str) {
        return com.bytedance.apm.util.DecodeUtils.decodeCloudData(bArr, str);
    }
}
