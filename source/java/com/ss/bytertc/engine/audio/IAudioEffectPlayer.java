package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;

/* loaded from: classes7.dex */
public abstract class IAudioEffectPlayer {
    public abstract int getDuration(int effectId);

    public abstract int getPosition(int effectId);

    public abstract int getVolume(int effectId);

    public abstract int pause(int effectId);

    public abstract int pauseAll();

    public abstract int preload(int effectId, String filePath);

    public abstract int resume(int effectId);

    public abstract int resumeAll();

    public abstract int setEventHandler(IAudioEffectPlayerEventHandler handler);

    public abstract int setPosition(int effectId, int position);

    public abstract int setVolume(int effectId, int volume);

    public abstract int setVolumeAll(int volume);

    public abstract int start(int effectId, String filePath, AudioEffectPlayerConfig config);

    public abstract int stop(int effectId);

    public abstract int stopAll();

    public abstract int unload(int effectId);

    public abstract int unloadAll();
}
