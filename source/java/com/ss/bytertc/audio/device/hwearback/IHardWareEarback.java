package com.ss.bytertc.audio.device.hwearback;

/* loaded from: classes7.dex */
public interface IHardWareEarback {
    int close();

    int getLatency();

    int init();

    boolean isSupport();

    void notifyEarbackRecordStateChanged(boolean recordStart);

    int open();

    int release();

    int setEffect(int value);

    int setEqualizer(int value);

    int setVolume(int volume);
}
