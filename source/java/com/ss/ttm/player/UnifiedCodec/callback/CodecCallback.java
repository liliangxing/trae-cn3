package com.ss.ttm.player.UnifiedCodec.callback;

/* loaded from: classes7.dex */
public interface CodecCallback {
    void onCodecException(String errorMsg, Throwable th);

    void onCreate(Boolean isReused);

    void onRelease();

    void onStarted(Boolean isReused, String metrics);
}
