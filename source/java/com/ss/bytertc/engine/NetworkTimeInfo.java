package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public class NetworkTimeInfo {
    public long timestamp;

    public void nativeSetTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static NetworkTimeInfo create() {
        return new NetworkTimeInfo();
    }
}
