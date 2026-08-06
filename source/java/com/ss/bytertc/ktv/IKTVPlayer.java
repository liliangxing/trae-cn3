package com.ss.bytertc.ktv;

import com.ss.bytertc.ktv.data.AudioPlayType;
import com.ss.bytertc.ktv.data.AudioTrackType;

/* loaded from: classes7.dex */
public abstract class IKTVPlayer {
    public abstract void pauseMusic(String musicId);

    public abstract void playMusic(String musicId, AudioTrackType trackType, AudioPlayType playType);

    public abstract void resumeMusic(String musicId);

    public abstract void seekMusic(String musicId, int position);

    public abstract void setMusicPitch(String musicId, int pitch);

    public abstract void setMusicVolume(String musicId, int volume);

    public abstract void setPlayerEventHandler(IKTVPlayerEventHandler playerEventHandler);

    public abstract void stopMusic(String musicId);

    public abstract void switchAudioTrackType(String musicId);
}
