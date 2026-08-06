package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public interface IRTCAudioDeviceManager {
    int startAudioDeviceRecordTest(int interval);

    int startAudioPlaybackDeviceTest(String testAudioFilePath, int interval);

    int stopAudioDevicePlayTest();

    int stopAudioDeviceRecordAndPlayTest();

    int stopAudioPlaybackDeviceTest();
}
