package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;

/* loaded from: classes7.dex */
public interface IRemoteEncodedAudioFrameObserver {
    void onRemoteEncodedAudioFrame(RemoteStreamKey streamInfo, EncodedAudioFrameData audioStream);
}
