package com.ttnet.org.chromium.net;

import java.nio.charset.StandardCharsets;

/* loaded from: classes7.dex */
public class NetworkTrafficAnnotationTag {
    private final int mHashCode;
    public static final NetworkTrafficAnnotationTag NO_TRAFFIC_ANNOTATION_YET = createComplete("undefined", "Nothing here yet.");
    public static final NetworkTrafficAnnotationTag MISSING_TRAFFIC_ANNOTATION = createComplete("undefined", "Function called without traffic annotation.");
    public static final NetworkTrafficAnnotationTag TRAFFIC_ANNOTATION_FOR_TESTS = createComplete("test", "Traffic annotation for unit, browser and other tests");

    public static NetworkTrafficAnnotationTag createComplete(String str, String str2) {
        return new NetworkTrafficAnnotationTag(str);
    }

    public int getHashCode() {
        return this.mHashCode;
    }

    private NetworkTrafficAnnotationTag(String str) {
        this.mHashCode = iterativeHash(str);
    }

    static int iterativeHash(String str) {
        long j = 0;
        for (int i = 0; i < str.getBytes(StandardCharsets.UTF_8).length; i++) {
            j = ((j * 31) + r7[i]) % 138003713;
        }
        return (int) j;
    }
}
