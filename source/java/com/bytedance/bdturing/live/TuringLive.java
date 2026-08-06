package com.bytedance.bdturing.live;

/* loaded from: classes3.dex */
public class TuringLive {
    private static volatile TuringLive sInstance;

    public native String detectImg(byte[] bArr, float[] fArr);

    public native int init(Config config);

    public native int release();

    public String versionName() {
        return "1.0.0";
    }

    static {
        System.loadLibrary("turing_live");
    }

    private TuringLive() {
    }

    public static TuringLive getInstance() {
        if (sInstance == null) {
            synchronized (TuringLive.class) {
                if (sInstance == null) {
                    sInstance = new TuringLive();
                }
            }
        }
        return sInstance;
    }
}
