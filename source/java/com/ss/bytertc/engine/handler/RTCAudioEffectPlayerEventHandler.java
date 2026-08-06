package com.ss.bytertc.engine.handler;

import com.ss.bytertc.engine.IAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerState;

/* loaded from: classes7.dex */
public class RTCAudioEffectPlayerEventHandler {
    private IAudioEffectPlayerEventHandler mAudioEffectHandler;

    public synchronized void setAudioEffectPlayerEventHandler(IAudioEffectPlayerEventHandler handler) {
        this.mAudioEffectHandler = handler;
    }

    synchronized void onAudioEffectPlayerStateChanged(int effectId, PlayerState state, PlayerError error) {
        IAudioEffectPlayerEventHandler iAudioEffectPlayerEventHandler = this.mAudioEffectHandler;
        if (iAudioEffectPlayerEventHandler != null) {
            iAudioEffectPlayerEventHandler.onAudioEffectPlayerStateChanged(effectId, state, error);
        }
    }
}
