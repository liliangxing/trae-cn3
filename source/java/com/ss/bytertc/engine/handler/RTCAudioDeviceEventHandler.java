package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IRTCAudioDeviceManagerEx;
import com.ss.bytertc.engine.engineimpl.RTCEngineImpl;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCAudioDeviceEventHandler {
    private static final String TAG = "RtcAudioDeviceEventHandler";

    void OnLoopbackAudioVolumeIndication(int volume) {
    }

    void onRecordingAudioVolumeIndication(int volume) {
        IRTCAudioDeviceManagerEx.IRTCAudioDeviceEventHandler audioDeviceManagerEvent = RTCEngineImpl.getAudioDeviceManagerEvent();
        if (audioDeviceManagerEvent != null) {
            audioDeviceManagerEvent.onRecordingAudioVolumeIndication(volume);
        }
    }
}
