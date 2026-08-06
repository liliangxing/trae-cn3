package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IMediaPlayer;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.MediaPlayerConfig;
import com.ss.bytertc.engine.data.MediaPlayerCustomSource;
import com.ss.bytertc.engine.data.PlayerState;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.handler.RTCMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.handler.RTCMediaPlayerEventHandler;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RtcMediaPlayer extends IMediaPlayer {
    private static final String TAG = "MediaPlayer";
    private RTCMediaPlayerAudioFrameObserver mAudioFrameObserver;
    private long mLingeringNativeMediaPlayer;
    private RTCMediaPlayerCustomSourceProvider mMediaPlayerCustomSourceProvider;
    private RTCMediaPlayerEventHandler mMediaPlayerEventHandler;
    private long mNativeMediaPlayer;
    private long mNativeRTCEngine;

    public RtcMediaPlayer(long nativeMediaPlayer) {
        this(nativeMediaPlayer, 0L);
    }

    public RtcMediaPlayer(long nativeMediaPlayer, long nativeRTCEngine) {
        this.mLingeringNativeMediaPlayer = 0L;
        this.mAudioFrameObserver = null;
        this.mMediaPlayerEventHandler = null;
        this.mMediaPlayerCustomSourceProvider = null;
        this.mNativeMediaPlayer = nativeMediaPlayer;
        this.mNativeRTCEngine = nativeRTCEngine;
        this.mAudioFrameObserver = new RTCMediaPlayerAudioFrameObserver();
        this.mMediaPlayerEventHandler = new RTCMediaPlayerEventHandler();
        this.mMediaPlayerCustomSourceProvider = new RTCMediaPlayerCustomSourceProvider();
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int open(String filePath, MediaPlayerConfig config) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, open failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeOpen(j, filePath, config.type.value(), config.playCount, config.startPos, config.autoPlay, config.callbackOnProgressInterval, config.syncProgressToRecordFrame);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int start() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, start failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeStart(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int openWithCustomSource(MediaPlayerCustomSource source, MediaPlayerConfig config) {
        if (this.mNativeMediaPlayer == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, openWithCustomSource failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        this.mMediaPlayerCustomSourceProvider.setCustomSourceProvider(source.provider);
        return NativeMediaPlayerFunctions.nativeOpenWithCustomSource(this.mNativeMediaPlayer, source.mode.value(), source.type.value(), this.mMediaPlayerCustomSourceProvider, config.type.value(), config.playCount, config.startPos, config.autoPlay, config.callbackOnProgressInterval, config.syncProgressToRecordFrame);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int stop() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, stop failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeStop(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int pause() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, pause failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativePause(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int resume() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, resume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeResume(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setVolume(int volume, AudioMixingType type) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setVolume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetVolume(j, volume, type.value());
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getVolume(AudioMixingType type) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getVolume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeGetVolume(j, type.value());
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getTotalDuration() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getTotalDuration failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeGetTotalDuration(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getPlaybackDuration() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getPlaybackDuration failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeGetPlaybackDuration(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getPosition() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getPosition failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeGetPosition(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized PlayerState getState() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getState failed.");
            return PlayerState.IDLE;
        }
        return PlayerState.fromId(NativeMediaPlayerFunctions.nativeGetState(j));
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setAudioPitch(int pitch) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setAudioPitch failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetAudioPitch(j, pitch);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setPosition(int position) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setPosition failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetPosition(j, position);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setAudioDualMonoMode(AudioMixingDualMonoMode mode) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setAudioDualMonoMode failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetAudioDualMonoMode(j, mode.value());
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getAudioTrackCount() {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, getAudioTrackCount failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeGetAudioTrackCount(j);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int selectAudioTrack(int index) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, selectAudioTrack failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSelectAudioTrack(j, index);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setPlaybackSpeed(int speed) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setPlaybackSpeed failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetPlaybackSpeed(j, speed);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setProgressInterval(long interval) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setProgressInterval failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetProgressInterval(j, interval);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setLoudness(float loudness) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setLoudness failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativeSetLoudness(j, loudness);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int registerAudioFrameObserver(IMediaPlayerAudioFrameObserver observer) {
        if (this.mNativeMediaPlayer == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, registerAudioFrameObserver failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        this.mAudioFrameObserver.setAudioFrameObserver(observer);
        if (observer == null) {
            return NativeMediaPlayerFunctions.nativeRegisterAudioFrameObserver(this.mNativeMediaPlayer, null);
        }
        return NativeMediaPlayerFunctions.nativeRegisterAudioFrameObserver(this.mNativeMediaPlayer, this.mAudioFrameObserver);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int pushExternalAudioFrame(AudioFrame audioFrame) {
        long j = this.mNativeMediaPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, pushExternalAudioFrame failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeMediaPlayerFunctions.nativePushExternalAudioFrame(j, audioFrame.buffer, audioFrame.samples, audioFrame.sampleRate.value(), audioFrame.channel.value());
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setEventHandler(IMediaPlayerEventHandler handler) {
        if (this.mNativeMediaPlayer == 0) {
            LogUtil.m216e(TAG, "native MediaPlayer is invalid, setEventHandler failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        this.mMediaPlayerEventHandler.setMediaPlayerEventHandler(handler);
        if (handler == null) {
            return NativeMediaPlayerFunctions.nativeSetEventHandler(this.mNativeMediaPlayer, null);
        }
        return NativeMediaPlayerFunctions.nativeSetEventHandler(this.mNativeMediaPlayer, this.mMediaPlayerEventHandler);
    }

    public synchronized void destroy() {
        long j = this.mNativeMediaPlayer;
        if (j != 0) {
            NativeMediaPlayerFunctions.nativeDestory(j);
            this.mNativeMediaPlayer = 0L;
        }
        long j2 = this.mLingeringNativeMediaPlayer;
        if (j2 != 0) {
            NativeMediaPlayerFunctions.nativeDestory(j2);
            this.mLingeringNativeMediaPlayer = 0L;
        }
        this.mNativeRTCEngine = 0L;
        this.mAudioFrameObserver = null;
        this.mMediaPlayerEventHandler = null;
        this.mMediaPlayerCustomSourceProvider = null;
    }

    public synchronized void destroyResourceInternal() {
        this.mLingeringNativeMediaPlayer = this.mNativeMediaPlayer;
        this.mNativeMediaPlayer = 0L;
    }
}
