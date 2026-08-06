package com.ss.bytertc.engine;

/* loaded from: classes7.dex */
public interface IRTCAudioDeviceManagerEx {

    /* loaded from: classes7.dex */
    public interface IRTCAudioDeviceEventHandler {
        void onRecordingAudioVolumeIndication(int volume);
    }

    void setEnableSpeakerphone(boolean enable);

    int startAudioCaptureDeviceTest(int indicationInterval);

    int startAudioPlaybackDeviceTest(String testAudioFilePath, int interval);

    int stopAudioCaptureDeviceTest();

    int stopAudioPlaybackDeviceTest();
}
