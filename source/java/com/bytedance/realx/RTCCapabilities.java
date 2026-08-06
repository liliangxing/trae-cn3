package com.bytedance.realx;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class RTCCapabilities {
    private List<String> supportedVideoCodecs;

    private static native String[] nativeGetSupportedVideoCodecs(long capabilities);

    public RTCCapabilities(List<String> supportedVideoCodecs) {
        this.supportedVideoCodecs = supportedVideoCodecs;
    }

    public RTCCapabilities(long nativeCapabilities) {
        this.supportedVideoCodecs = Arrays.asList(nativeGetSupportedVideoCodecs(nativeCapabilities));
    }

    public List<String> getSupportedVideoCodecs() {
        return this.supportedVideoCodecs;
    }
}
