package com.ss.bytertc.engine;

import com.ss.bytertc.engine.utils.IAudioFrame;

/* loaded from: classes7.dex */
public interface IWTNAudioFrameObserver {
    void onWTNRemoteAudioFrame(String streamId, IAudioFrame audioFrame);
}
