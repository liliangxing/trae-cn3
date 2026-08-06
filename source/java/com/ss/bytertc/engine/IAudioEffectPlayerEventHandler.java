package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.PlayerError;
import com.ss.bytertc.engine.data.PlayerState;

/* loaded from: classes7.dex */
public interface IAudioEffectPlayerEventHandler {
    void onAudioEffectPlayerStateChanged(int effectId, PlayerState state, PlayerError error);
}
