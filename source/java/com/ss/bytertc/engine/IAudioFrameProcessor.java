package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.IAudioFrame;

/* loaded from: classes7.dex */
public interface IAudioFrameProcessor {
    int onProcessEarMonitorAudioFrame(IAudioFrame audioFrame);

    int onProcessPlayBackAudioFrame(IAudioFrame audioFrame);

    int onProcessRecordAudioFrame(IAudioFrame audioFrame);

    int onProcessRecordAudioFrame(IAudioFrame micAudioFrame, IAudioFrame refAudioFrame);

    int onProcessRemoteUserAudioFrame(RemoteStreamKey streamKey, IAudioFrame audioFrame);

    int onProcessScreenAudioFrame(IAudioFrame audioFrame);
}
