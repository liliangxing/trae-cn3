package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.AudioFrame;

/* loaded from: classes7.dex */
public interface IAudioFrameTestObserver {
    void onAudioRecordFrame(AudioFrame frame);

    void onLocalAudioVolume(int recordVolume, int playoutVolume);

    boolean onPlayoutBufferSink(int id, AudioFrame frame);
}
