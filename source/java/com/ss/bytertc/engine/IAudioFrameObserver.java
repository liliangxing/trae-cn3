package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* loaded from: classes7.dex */
public interface IAudioFrameObserver {
    void onCaptureMixedAudioFrame(IAudioFrame audioFrame);

    void onMixedAudioFrame(IAudioFrame audioFrame);

    void onPlaybackAudioFrame(IAudioFrame audioFrame);

    void onRecordAudioFrame(IAudioFrame audioFrame);

    void onRemoteUserAudioFrame(RemoteStreamKey streamKey, IAudioFrame audioFrame);
}
