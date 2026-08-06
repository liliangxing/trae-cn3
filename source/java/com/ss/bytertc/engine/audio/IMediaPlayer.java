package com.ss.bytertc.engine.audio;

import com.ss.bytertc.engine.IMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.IMediaPlayerEventHandler;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.MediaPlayerConfig;
import com.ss.bytertc.engine.data.MediaPlayerCustomSource;
import com.ss.bytertc.engine.data.PlayerState;
import com.ss.bytertc.engine.utils.AudioFrame;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class IMediaPlayer {
    public abstract int getAudioTrackCount();

    public abstract int getPlaybackDuration();

    public abstract int getPosition();

    public abstract PlayerState getState();

    public abstract int getTotalDuration();

    public abstract int getVolume(AudioMixingType type);

    public abstract int open(String filePath, MediaPlayerConfig config);

    public abstract int openWithCustomSource(MediaPlayerCustomSource source, MediaPlayerConfig config);

    public abstract int pause();

    public abstract int pushExternalAudioFrame(AudioFrame audioFrame);

    public abstract int registerAudioFrameObserver(IMediaPlayerAudioFrameObserver observer);

    public abstract int resume();

    public abstract int selectAudioTrack(int index);

    public abstract int setAudioDualMonoMode(AudioMixingDualMonoMode mode);

    public abstract int setAudioPitch(int pitch);

    public abstract int setEventHandler(IMediaPlayerEventHandler handler);

    public abstract int setLoudness(float loudness);

    public abstract int setPlaybackSpeed(int speed);

    public abstract int setPosition(int position);

    public abstract int setProgressInterval(long interval);

    public abstract int setVolume(int volume, AudioMixingType type);

    public abstract int start();

    public abstract int stop();
}
