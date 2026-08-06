package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AudioEffectPlayer extends IAudioEffectPlayer {
    private static final String TAG = "AudioEffectPlayer";
    private RTCAudioEffectPlayerEventHandler mAudioEffectPlayerEventHandler;
    private IAudioEffectPlayerEventHandler mCachedHandler;
    private long mLingeringNativeAudioEffectPlayer;
    private long mNativeAudioEffectPlayer;
    private long mNativeRTCEngine;

    public AudioEffectPlayer(long nativeAudioEffectPlayer) {
        this(nativeAudioEffectPlayer, 0L);
    }

    public AudioEffectPlayer(long nativeAudioEffectPlayer, long nativeRTCEngine) {
        this.mLingeringNativeAudioEffectPlayer = 0L;
        this.mAudioEffectPlayerEventHandler = null;
        this.mCachedHandler = null;
        this.mNativeAudioEffectPlayer = nativeAudioEffectPlayer;
        this.mNativeRTCEngine = nativeRTCEngine;
        this.mAudioEffectPlayerEventHandler = new RTCAudioEffectPlayerEventHandler();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int start(int effectId, String filePath, AudioEffectPlayerConfig config) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, start failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeStart(j, effectId, filePath, config.type.value(), config.playCount, config.startPos, config.pitch);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stop(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, stop failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeStop(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stopAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, stopAll failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeStopAll(j);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int preload(int effectId, String filePath) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, preload failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativePreload(j, effectId, filePath);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unload(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, unload failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeUnload(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unloadAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, unloadAll failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeUnloadAll(j);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pause(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, pause failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativePause(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pauseAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, pauseAll failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativePauseAll(j);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resume(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, resume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeResume(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resumeAll() {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, resumeAll failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeResumeAll(j);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setPosition(int effectId, int pos) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, setPosition failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeSetPosition(j, effectId, pos);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getPosition(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, getPosition failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeGetPosition(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolume(int effectId, int volume) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, setVolume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeSetVolume(j, effectId, volume);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolumeAll(int volume) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, setVolumeAll failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeSetVolumeAll(j, volume);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getVolume(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, getVolume failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeGetVolume(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getDuration(int effectId) {
        long j = this.mNativeAudioEffectPlayer;
        if (j == 0) {
            LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid, getDuration failed.");
            return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        }
        return NativeAudioEffectPlayerFunctions.nativeGetDuration(j, effectId);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setEventHandler(IAudioEffectPlayerEventHandler handler) {
        if (this.mNativeAudioEffectPlayer != 0 && this.mNativeRTCEngine != 0) {
            this.mAudioEffectPlayerEventHandler.setAudioEffectPlayerEventHandler(handler);
            IAudioEffectPlayerEventHandler iAudioEffectPlayerEventHandler = this.mCachedHandler;
            if (iAudioEffectPlayerEventHandler != null && iAudioEffectPlayerEventHandler == handler) {
                return ReturnStatus.RETURN_STATUS_SUCCESS.value();
            }
            this.mCachedHandler = handler;
            if (handler == null) {
                return NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, null);
            }
            return NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, this.mAudioEffectPlayerEventHandler);
        }
        LogUtil.m216e(TAG, "native AudioEffectPlayer is invalid or nativeEngine is invalid, setEventHandler failed.");
        return ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
    }

    public synchronized void destroy() {
        this.mLingeringNativeAudioEffectPlayer = 0L;
        this.mNativeAudioEffectPlayer = 0L;
    }

    public synchronized void destroyResourceInternal() {
        this.mLingeringNativeAudioEffectPlayer = this.mNativeAudioEffectPlayer;
        this.mNativeAudioEffectPlayer = 0L;
    }
}
