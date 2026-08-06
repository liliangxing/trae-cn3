package com.ss.bytertc.ktv;

import com.ss.bytertc.engine.NativeKTVPlayerFunctions;
import com.ss.bytertc.engine.handler.KTVPlayEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.data.AudioPlayType;
import com.ss.bytertc.ktv.data.AudioTrackType;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class KTVPlayerImpl extends IKTVPlayer {
    private static final String TAG = "KTVPlayerImpl";
    private KTVPlayEventHandler handler;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeKTVPlayer;
    private long mNativePlayerEventHandler;
    private final ReentrantReadWriteLock mReadWriteLock;

    public KTVPlayerImpl(long nativeKTVPlayer) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mNativeKTVPlayer = nativeKTVPlayer;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setPlayerEventHandler(IKTVPlayerEventHandler playerEventHandler) {
        KTVPlayEventHandler kTVPlayEventHandler = new KTVPlayEventHandler(playerEventHandler);
        this.handler = kTVPlayEventHandler;
        long j = this.mNativePlayerEventHandler;
        this.mNativePlayerEventHandler = NativeKTVPlayerFunctions.nativeSetPlayerEventHandler(this.mNativeKTVPlayer, kTVPlayEventHandler);
        if (j != 0) {
            NativeKTVPlayerFunctions.nativeReleaseKTVPlayerEventHandler(j);
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void playMusic(String musicId, AudioTrackType trackType, AudioPlayType playType) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, playMusic failed.");
            } else {
                NativeKTVPlayerFunctions.nativePlayMusic(j, musicId, trackType.value(), playType.value());
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void pauseMusic(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, pauseMusic failed.");
            } else {
                NativeKTVPlayerFunctions.nativePauseMusic(j, musicId);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void resumeMusic(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, resumeMusic failed.");
            } else {
                NativeKTVPlayerFunctions.nativeResumeMusic(j, musicId);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void stopMusic(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, stopMusic failed.");
            } else {
                NativeKTVPlayerFunctions.nativeStopMusic(j, musicId);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void seekMusic(String musicId, int position) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, seekMusic failed.");
            } else {
                NativeKTVPlayerFunctions.nativeSeekMusic(j, musicId, position);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setMusicVolume(String musicId, int volume) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, setMusicVolume failed.");
            } else {
                NativeKTVPlayerFunctions.nativeSetMusicVolume(j, musicId, volume);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void switchAudioTrackType(String musicId) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, switchAudioTrackType failed.");
            } else {
                NativeKTVPlayerFunctions.nativeSwitchAudioTrackType(j, musicId);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setMusicPitch(String musicId, int pitch) {
        this.mJniReadLock.lock();
        try {
            long j = this.mNativeKTVPlayer;
            if (j == 0) {
                LogUtil.m216e(TAG, "native mNativeKTVPlayer is invalid, setMusicPitch failed.");
            } else {
                NativeKTVPlayerFunctions.nativeSetMusicPitch(j, musicId, pitch);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public void destroy() {
        this.mJniWriteLock.lock();
        try {
            long j = this.mNativePlayerEventHandler;
            if (j != 0) {
                NativeKTVPlayerFunctions.nativeReleaseKTVPlayerEventHandler(j);
                this.mNativePlayerEventHandler = 0L;
            }
            this.mNativeKTVPlayer = 0L;
            this.handler = null;
        } finally {
            this.mJniWriteLock.unlock();
        }
    }
}
