package com.ss.ttm.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AJVoice implements AudioTrack.OnPlaybackPositionUpdateListener {
    private static final int DISCONTINGUNITY_MS = 200;
    private static final int ERROR_FORMAT_ILLEGAL = -12;
    private static final int ERROR_NULL_BUFFER = -10;
    private static final int ERROR_SIZE_ILLEGAL = -11;
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final int MAX_LATENCY_MS = 5000;
    private static final int MIN_LATENCY_CHECK_MS = 500;
    private static final int MS_UNIT = 1000;
    private static final int REASON_DISABLE_POOL = 1;
    private static final int REASON_EMPTY_POOL = 2;
    private static final int REASON_PARA_NOT_MATCH = 3;
    private static final long RELEASE_WORKAROUND_TIME_MS = 80;
    private static final int SDK_INT = Build.VERSION.SDK_INT;
    private static final int START_NO_SET = -1;
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "JAJVoice";
    private static final long TIME_UNSET = -9223372036854775807L;
    private static final int kNoSettingVolume = -1;
    private static String mDeviceName;
    private static boolean mNeedReleaseWorkAround;
    private AudioTrackPositionTracker audioTrackPositionTracker;
    private boolean mEnableAudioTrackPoolRefactor;
    private byte[] mMinBytes;
    private int mOutputPcmFrameSize;
    private long mRawPlaybackHeadWrapCount;
    private ConditionVariable mReleasingConditionVariable;
    private int mStartMediaTimeMs;
    private int mReuseFailReason = -1;
    private AudioTrack mAudioTrack = null;
    private Context mContext = null;
    private int mBlockSize = 2048;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mSampleBytes = 2;
    private int mSampleFormat = 0;
    private int mFrameSamples = 0;
    private AudioManager mAudioManager = null;
    private int mChannelsLayout = 0;
    private int mAudioFormat = 2;
    private float mLeftVolume = -1.0f;
    private int mMaxVolume = 0;
    private volatile boolean mStoped = true;
    private ByteBuffer mFloatWriteBuffer = null;
    private int mSerial = -1;
    private Method getLatencyMethod = null;
    private int mTrackBufferSize = 0;
    private int mLatencyMs = 0;
    private int mBufferSizeMs = 0;
    private long mLastGetLatencyMs = 0;
    private long mWrittenPcmBytes = 0;
    private long lastRawPlaybackHeadPosition = 0;
    private long forceResetWorkaroundTimeMs = -9223372036854775807L;
    private long mStartTime = 0;
    private int mStreamType = 3;
    private int mEnableAudioTrackSmoothClock = 0;
    private int mSessionId = -1;
    private int mContentType = -1;
    private float mSpeed = 1.0f;
    private ByteBuffer mPCMFrameBuffer = null;
    private boolean mUseDirectBuffer = false;
    private int mCalibrationType = 0;
    private AudioTrackPool mAudioTrackPool = null;
    private AudioTrackPoolRefactor mAudioTrackPoolRefactor = null;
    private boolean mEnableAudioTrackPool = false;
    private boolean mForceReleaseAudioTrackByPool = false;
    private int mUsedCount = 0;
    private int mErrorOccurred = 0;
    private int mAudioPerformanceMode = 0;
    private int mMuteOptType = 0;
    private VolumeKeyReceiver mVolumeReceiver = null;
    private boolean mIsSysMute = false;
    private int mDirectBufferSize = 0;
    private float mIsSetVolume = 1.0f;
    private boolean mEnableFixAudioTrackFlush = false;
    private boolean mEnableAudioTrackCreateOpt = false;
    private AudioLatencyTuner mAudioLatencyTuner = null;
    private int mAvailableSize = -1;
    private boolean mEnableMemSizeOpt = false;
    private boolean mEnableAudioTrackReuseWhenPause = false;
    private boolean mEnableDirectBufferPool = false;
    private DirectBufferPool mDirectBufferPool = null;
    private boolean mEnableDirectBufferReuseWhenPause = false;
    private boolean mIsReuseAudioTrack = false;
    private boolean mEnableResetLogicOpt = false;
    private int mEnableAudioManagerStateDetect = 0;
    private long mNativeObject = 0;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public @interface AJVoiceOptionDef {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onSysVolumeChange(long handle, int type);

    public static int getAudioTrackChannelConfig(int channelCount) {
        switch (channelCount) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM;
            case 6:
                return MediaPlayer.MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF;
            case 7:
                return 1276;
            case 8:
                return 6396;
            default:
                return 0;
        }
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack arg0) {
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack arg0) {
    }

    public AJVoice() {
        this.mEnableAudioTrackPoolRefactor = false;
        AVLogger.InfoTrackLife(TAG, this, "JAJVoice#^");
        this.mEnableAudioTrackPoolRefactor = TTPlayerConfiger.getValue(90, 0) != 0;
        this.mStartMediaTimeMs = -1;
        if (mDeviceName == null) {
            String str = Build.DEVICE;
            mDeviceName = str;
            if (str.equals("OnePlus6T")) {
                AVLogger.Debug(TAG, this, "device need workaround");
                mNeedReleaseWorkAround = true;
            }
        }
    }

    public int open(long nativeObject, Context ctx) {
        if (this.mEnableAudioTrackPool) {
            if (this.mEnableAudioTrackPoolRefactor) {
                this.mAudioTrackPoolRefactor = AudioTrackPoolRefactor.getInstance();
            } else {
                this.mAudioTrackPool = AudioTrackPool.getInstance();
            }
        }
        if (this.mEnableDirectBufferPool && this.mUseDirectBuffer) {
            this.mDirectBufferPool = DirectBufferPool.getInstance();
        }
        this.mNativeObject = nativeObject;
        AVLogger.Debug(TAG, this, String.format(Locale.US, "native object:%d", Long.valueOf(this.mNativeObject)));
        this.mContext = ctx;
        int reconfigure = reconfigure();
        if (reconfigure == 0) {
            float f = this.mLeftVolume;
            if (f != -1.0f) {
                setVolume(f, f);
            }
            try {
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        return reconfigure;
    }

    public void releaseTrack(AudioTrack toRelease) {
        if (toRelease == null) {
            return;
        }
        try {
            if (mNeedReleaseWorkAround) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                if (elapsedRealtime <= RELEASE_WORKAROUND_TIME_MS) {
                    Thread.sleep(RELEASE_WORKAROUND_TIME_MS - elapsedRealtime);
                }
            }
        } catch (Exception unused) {
        }
        try {
            toRelease.release();
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "release in invalid state = " + e);
        }
    }

    public void close() {
        VolumeKeyReceiver volumeKeyReceiver;
        Context context;
        AudioManager audioManager;
        if (this.mEnableAudioTrackPool) {
            int i = this.mEnableAudioManagerStateDetect;
            if (i == 1 && (audioManager = this.mAudioManager) != null) {
                int mode = audioManager.getMode();
                if (mode != 0) {
                    AVLogger.InfoTrackLife(TAG, this, "audio mode:" + mode + ", force release audioTrack");
                    this.mForceReleaseAudioTrackByPool = true;
                }
            } else if (i == 2 && this.mAudioTrack != null) {
                this.mAudioTrack.setVolume(1.0f);
            }
            if (!this.mForceReleaseAudioTrackByPool && this.mSpeed != 1.0f) {
                setPlaybackSpeed(1.0f);
                AVLogger.InfoTrackLife(TAG, this, "reset AudioTrack playSpeed");
            }
            if (this.mEnableAudioTrackPoolRefactor) {
                this.mAudioTrackPoolRefactor.pushAudioTrackBack(new AudioTrackBufferRefactor(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mTrackBufferSize, this.mUsedCount), this.mIsSetVolume, this.mForceReleaseAudioTrackByPool);
                this.mAudioTrack = null;
            } else if (!this.mForceReleaseAudioTrackByPool) {
                if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                    this.mAudioTrack = null;
                }
            }
        }
        if (this.mAudioTrack != null) {
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null) {
                audioLatencyTuner.close();
            }
            final AudioTrack audioTrack = this.mAudioTrack;
            this.mAudioTrack = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AVLogger.Debug(AJVoice.TAG, this, "start release task");
                        AJVoice.this.releaseTrack(audioTrack);
                    }
                });
            } catch (Throwable th) {
                AVLogger.Warn(TAG, this, "create close thread fail = " + th);
                releaseTrack(audioTrack);
            }
        }
        if (this.mMuteOptType == 2 && (volumeKeyReceiver = this.mVolumeReceiver) != null && (context = this.mContext) != null) {
            m238xdc75bc47(context, volumeKeyReceiver);
        }
        if (this.mEnableDirectBufferPool && this.mUseDirectBuffer) {
            this.mDirectBufferPool.pushDirectBufferBack(this.mPCMFrameBuffer);
        }
        AVLogger.InfoTrackLife(TAG, this, "JAJVoice#$");
    }

    public int start() {
        AVLogger.Debug(TAG, this, "start--->");
        if (this.mAudioTrack == null) {
            AVLogger.Error(TAG, this, "audiotrack start before created");
            return -2;
        }
        this.mStoped = false;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
            }
            this.mAudioTrack.play();
            this.mSerial = -1;
            AVLogger.Debug(TAG, this, "end---->");
            if (mNeedReleaseWorkAround) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
            return 0;
        } catch (Throwable th) {
            AVLogger.Error(TAG, this, "audioTrack start failed = " + th);
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
            return -3;
        }
    }

    public void pause() {
        AudioManager audioManager;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
            if (this.mEnableAudioTrackPool && this.mEnableAudioTrackReuseWhenPause) {
                int i = this.mEnableAudioManagerStateDetect;
                if (i == 1 && (audioManager = this.mAudioManager) != null) {
                    int mode = audioManager.getMode();
                    if (mode != 0) {
                        AVLogger.InfoTrackLife(TAG, this, "audio mode:" + mode + ", force release audioTrack");
                        this.mForceReleaseAudioTrackByPool = true;
                    }
                } else if (i == 2 && this.mAudioTrack != null) {
                    this.mAudioTrack.setVolume(1.0f);
                }
                if (!this.mForceReleaseAudioTrackByPool && this.mSpeed != 1.0f) {
                    setPlaybackSpeed(1.0f);
                    AVLogger.InfoTrackLife(TAG, this, "reset AudioTrack playSpeed");
                }
                if (this.mEnableAudioTrackPoolRefactor) {
                    this.mAudioTrackPoolRefactor.pushAudioTrackBack(new AudioTrackBufferRefactor(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mTrackBufferSize, this.mUsedCount), this.mIsSetVolume, this.mForceReleaseAudioTrackByPool);
                    this.mAudioTrack = null;
                } else if (!this.mForceReleaseAudioTrackByPool) {
                    if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                        this.mAudioTrack = null;
                    }
                }
                AudioTrack audioTrack = this.mAudioTrack;
                if (audioTrack != null) {
                    this.mAudioTrack = null;
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } catch (Exception unused) {
                    }
                }
            }
            if (this.mEnableDirectBufferPool && this.mUseDirectBuffer && this.mEnableDirectBufferReuseWhenPause) {
                this.mDirectBufferPool.pushDirectBufferBack(this.mPCMFrameBuffer);
                this.mPCMFrameBuffer = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
    }

    public void resume() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
                this.audioTrackPositionTracker.start();
            }
            if (this.mEnableAudioTrackPool && this.mEnableAudioTrackReuseWhenPause) {
                if (this.mEnableAudioTrackPoolRefactor) {
                    AudioTrackBufferRefactor reuseAudioTrack = this.mAudioTrackPoolRefactor.getReuseAudioTrack(new AudioTrackBufferRefactor(null, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mTrackBufferSize, 0));
                    this.mAudioTrack = reuseAudioTrack.AudioTrack;
                    this.mUsedCount = reuseAudioTrack.usedCount;
                    if (reuseAudioTrack.reuseFailReason > 0) {
                        this.mReuseFailReason = reuseAudioTrack.reuseFailReason;
                    }
                } else {
                    int audioTrackPoolSize = this.mAudioTrackPool.getAudioTrackPoolSize();
                    AudioTrackBuffer reuseAudioTrack2 = this.mAudioTrackPool.getReuseAudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples);
                    if (reuseAudioTrack2 != null) {
                        this.mAudioTrack = reuseAudioTrack2.AudioTrack;
                        this.mUsedCount = reuseAudioTrack2.usedCount;
                    } else {
                        if (audioTrackPoolSize <= 0) {
                            this.mReuseFailReason = 2;
                        } else {
                            this.mReuseFailReason = 3;
                        }
                        this.mAudioTrack = createAudioTrack();
                        this.mUsedCount = 0;
                    }
                }
                float f = this.mIsSetVolume;
                if (f != 1.0f) {
                    setTrackVolume(f, f);
                }
                if (this.mCalibrationType >= 1) {
                    this.lastRawPlaybackHeadPosition = 0L;
                    this.mRawPlaybackHeadWrapCount = 0L;
                    this.mWrittenPcmBytes = 0L;
                }
                AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: try get resume AudioTrack: " + this.mAudioTrack);
            } else {
                this.mReuseFailReason = 1;
            }
            if (this.mEnableDirectBufferPool && this.mUseDirectBuffer && this.mEnableDirectBufferReuseWhenPause) {
                ByteBuffer reuseDirectBuffer = this.mDirectBufferPool.getReuseDirectBuffer(this.mDirectBufferSize);
                this.mPCMFrameBuffer = reuseDirectBuffer;
                if (reuseDirectBuffer == null) {
                    try {
                        this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
                    } catch (Exception unused) {
                        AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
                    }
                }
            }
            this.mAudioTrack.play();
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
    }

    public void flush() {
        if (this.mAudioTrack == null) {
            return;
        }
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.reset();
            }
            this.mStartMediaTimeMs = -1;
            if (this.mCalibrationType >= 1) {
                this.lastRawPlaybackHeadPosition = 0L;
                this.mRawPlaybackHeadWrapCount = 0L;
            }
            this.mAudioTrack.flush();
            this.mAvailableSize = -1;
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
        }
    }

    public void flushV2() {
        boolean z;
        try {
            this.mStartMediaTimeMs = -1;
            this.lastRawPlaybackHeadPosition = 0L;
            this.mRawPlaybackHeadWrapCount = 0L;
            if (this.mAudioTrack.getPlayState() == 3) {
                this.mAudioTrack.pause();
                z = true;
            } else {
                z = false;
            }
            this.mAudioTrack.flush();
            if (z && this.mAudioTrack.getPlayState() != 3) {
                this.mAudioTrack.play();
            }
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
        }
    }

    public void stop() {
        AVLogger.Debug(TAG, this, "stop");
        if (this.mStoped) {
            return;
        }
        this.mStoped = true;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            th.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
        }
        AVLogger.Debug(TAG, this, "stop");
    }

    public int write(byte[] buffer, int offset, int size, int serial) {
        int write;
        if (buffer == null || buffer.length == 0) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -10;
        }
        int i = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != serial) {
            this.mSerial = serial;
            if (this.mWrittenPcmBytes > 0) {
                if (this.mEnableFixAudioTrackFlush) {
                    flushV2();
                } else {
                    this.mAudioTrack.flush();
                }
            }
        }
        long currentTimeMillis = this.mAudioLatencyTuner != null ? System.currentTimeMillis() : 0L;
        try {
            if (this.mAudioFormat == 4) {
                if ((offset & 3) == 0 && (size & 3) == 0) {
                    ByteBuffer byteBuffer = this.mFloatWriteBuffer;
                    if (byteBuffer == null || byteBuffer.array() != buffer) {
                        byteBuffer = ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN);
                        this.mFloatWriteBuffer = byteBuffer;
                    }
                    byteBuffer.limit(offset + size);
                    byteBuffer.position(offset);
                    write = this.mAudioTrack.write(byteBuffer, size, 0);
                }
                AVLogger.Error(TAG, this, "pcm float write with unaligned offset/size, offset=" + offset + ", size=" + size);
                return -11;
            }
            write = this.mAudioTrack.write(buffer, offset, size);
            if (write < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + write + ", size = " + size);
                this.mForceReleaseAudioTrackByPool = true;
                this.mErrorOccurred = 1;
                return write;
            }
            this.mWrittenPcmBytes += write;
            this.mAvailableSize = -1;
            if (this.mAudioLatencyTuner != null) {
                this.mTrackBufferSize = this.mAudioLatencyTuner.update(getAvailableBufferSize(), System.currentTimeMillis() - currentTimeMillis);
            }
            if (needsReset() && reset() == 0) {
                i = start();
            }
            return i == 0 ? write : i;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
            return -1;
        }
    }

    public int write(byte[] buffer, int offset, int size, int serial, long pts) {
        if (buffer == null || buffer.length == 0) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -10;
        }
        int i = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != serial) {
            this.mSerial = serial;
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker == null || this.mReleasingConditionVariable == null) {
                if (this.mWrittenPcmBytes > 0) {
                    if (this.mEnableFixAudioTrackFlush) {
                        flushV2();
                    } else {
                        this.mAudioTrack.flush();
                    }
                }
            } else if (this.mWrittenPcmBytes > 0) {
                if (audioTrackPositionTracker.isPlaying()) {
                    this.mAudioTrack.pause();
                }
                this.audioTrackPositionTracker.reset();
                this.mStartMediaTimeMs = -1;
                this.mReleasingConditionVariable.close();
                this.mWrittenPcmBytes = 0L;
                final AudioTrack audioTrack = this.mAudioTrack;
                this.mAudioTrack = null;
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AVLogger.Debug(AJVoice.TAG, this, "release old track");
                            audioTrack.flush();
                            audioTrack.release();
                            AVLogger.Debug(AJVoice.TAG, this, "release old track done");
                        } finally {
                            if (AJVoice.this.mReleasingConditionVariable != null) {
                                AJVoice.this.mReleasingConditionVariable.open();
                            }
                        }
                    }
                });
                this.mReleasingConditionVariable.block();
                reconfigure();
                start();
                this.mSerial = serial;
            }
        }
        int i2 = this.mStartMediaTimeMs;
        if (i2 == -1) {
            this.mStartMediaTimeMs = (int) Math.max(0L, pts);
        } else {
            long writtenDurationMs = i2 + getWrittenDurationMs();
            if (Math.abs(writtenDurationMs - pts) > FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
                AVLogger.Error(TAG, this, "Discontinuity detected [expected " + writtenDurationMs + ", got " + pts + "]");
                this.mStartMediaTimeMs = (int) (this.mStartMediaTimeMs + (pts - writtenDurationMs));
            }
        }
        try {
            int write = this.mAudioTrack.write(buffer, offset, size);
            if (write < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + write + ", size = " + size);
                this.mErrorOccurred = 1;
                return write;
            }
            this.mWrittenPcmBytes += write;
            if (needsReset() && reset() == 0) {
                i = start();
                this.mSerial = serial;
            }
            return i == 0 ? write : i;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            this.mErrorOccurred = 1;
            return -1;
        }
    }

    public int write(ByteBuffer buffer, int serial) {
        if (buffer == null) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -1;
        }
        if (this.mAudioTrack.write(buffer, 0, buffer.capacity()) != buffer.capacity()) {
            return -1;
        }
        buffer.flip();
        return 0;
    }

    public int write(int offset, int size, int serial) {
        int write;
        int i = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != serial) {
            this.mSerial = serial;
            if (this.mWrittenPcmBytes > 0) {
                if (this.mEnableFixAudioTrackFlush) {
                    flushV2();
                } else {
                    this.mAudioTrack.flush();
                }
            }
        }
        long currentTimeMillis = this.mAudioLatencyTuner != null ? System.currentTimeMillis() : 0L;
        try {
            if (Util.SDK_INT >= 21) {
                write = this.mAudioTrack.write(this.mPCMFrameBuffer, size, 0);
            } else {
                this.mPCMFrameBuffer.get(this.mMinBytes, offset, size);
                write = this.mAudioTrack.write(this.mMinBytes, 0, size);
            }
            if (write < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + write + ", size = " + size);
                this.mForceReleaseAudioTrackByPool = true;
                this.mErrorOccurred = 1;
                return write;
            }
            this.mWrittenPcmBytes += write;
            this.mAvailableSize = -1;
            if (this.mAudioLatencyTuner != null) {
                this.mTrackBufferSize = this.mAudioLatencyTuner.update(getAvailableBufferSize(), System.currentTimeMillis() - currentTimeMillis);
            }
            if (needsReset() && reset() == 0) {
                i = start();
            }
            this.mPCMFrameBuffer.clear();
            return i == 0 ? write : i;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            this.mForceReleaseAudioTrackByPool = true;
            this.mErrorOccurred = 1;
            return -1;
        }
    }

    public void setTrackVolume(float leftVolume, float rightVolume) {
        this.mIsSetVolume = leftVolume;
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            if (SDK_INT < 21) {
                audioTrack.setStereoVolume(leftVolume, rightVolume);
            } else {
                audioTrack.setVolume(leftVolume);
            }
        }
    }

    public void setVolume(float leftVolume, float rightVolume) {
        AudioTrack audioTrack;
        try {
            int i = this.mMaxVolume;
            if (i < leftVolume) {
                leftVolume = i;
            }
            if (rightVolume == -1048575.0f && (audioTrack = this.mAudioTrack) != null) {
                audioTrack.setStereoVolume(leftVolume, rightVolume);
            } else {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.setStreamVolume(this.mStreamType, (int) leftVolume, 0);
                }
            }
            this.mLeftVolume = leftVolume;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float getVolume() {
        int i;
        AudioManager audioManager;
        int i2 = 0;
        if (this.mLeftVolume == -1.0f && (audioManager = this.mAudioManager) != null) {
            try {
                i = audioManager.getStreamMaxVolume(this.mStreamType);
                try {
                    i2 = this.mAudioManager.getStreamVolume(this.mStreamType);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
            if (i2 < 0) {
                return i2;
            }
            if (i > 0) {
                return i / 4;
            }
            return 10.0f;
        }
        i = 0;
        if (i2 < 0) {
        }
    }

    public int getMaxVolume() {
        AVLogger.m239d("ttmn", "getMaxVolume:" + this.mMaxVolume);
        return this.mMaxVolume;
    }

    public void setSampleInfo(int format, int sampleRate, int channels, int bufferSize, int frameSampleNumber, int sampleBits) {
        this.mSampleRate = sampleRate;
        this.mChannels = channels;
        this.mBlockSize = bufferSize;
        this.mSampleBytes = sampleBits;
        this.mSampleFormat = format;
        this.mFrameSamples = frameSampleNumber;
        AVLogger.Debug(TAG, this, "mBlockSize:" + this.mBlockSize);
    }

    public void setStreamType(int streamType) {
        AVLogger.Debug(TAG, this, "set Stream type : " + streamType);
        this.mStreamType = streamType;
        if (!(this.mEnableResetLogicOpt && this.mAudioTrack == null) && reset() == 0) {
            start();
        }
    }

    public void setSessionId(int sessionId) {
        AVLogger.Debug(TAG, this, "setSessionId : " + sessionId);
        this.mSessionId = sessionId;
        if (!(this.mEnableResetLogicOpt && this.mAudioTrack == null) && reset() == 0) {
            start();
        }
    }

    public void setContentType(int contentType) {
        AVLogger.Debug(TAG, this, "setContentType contentType=" + contentType);
        this.mContentType = contentType;
        if (!(this.mEnableResetLogicOpt && this.mAudioTrack == null) && reset() == 0) {
            start();
        }
    }

    public int getSessionId() {
        AudioTrack audioTrack;
        int i = this.mSessionId;
        return (i != -1 || (audioTrack = this.mAudioTrack) == null) ? i : audioTrack.getAudioSessionId();
    }

    public int getUnderRunCount() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            return audioTrack.getUnderrunCount();
        }
        return -1;
    }

    public void setUseDirectBuffer(boolean enable) {
        AVLogger.Debug(TAG, this, "useDirectBuffer: " + enable);
        this.mUseDirectBuffer = enable;
    }

    public void setIntOption(int key, int value) {
        AVLogger.Debug(TAG, this, "setAjvoiceOption, key:" + key + ", value:" + value);
        switch (key) {
            case 1:
                if (Util.SDK_INT >= 21) {
                    this.mEnableAudioTrackSmoothClock = value;
                    if (value > 0) {
                        this.audioTrackPositionTracker = new AudioTrackPositionTracker(null);
                        this.mReleasingConditionVariable = new ConditionVariable(true);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                this.mCalibrationType = value;
                return;
            case 3:
                this.mEnableAudioTrackCreateOpt = value > 0;
                return;
            case 4:
            case 11:
            case 12:
            default:
                return;
            case 5:
                this.mEnableAudioTrackPool = value > 0;
                return;
            case 6:
                this.mEnableFixAudioTrackFlush = value > 0;
                return;
            case 7:
                this.mMuteOptType = value;
                return;
            case 8:
                if (value < 0 || value > 2) {
                    return;
                }
                this.mAudioPerformanceMode = value;
                return;
            case 9:
                this.mAudioLatencyTuner = new AudioLatencyTuner();
                return;
            case 10:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
                if (audioLatencyTuner != null) {
                    audioLatencyTuner.setIntOption(key, value);
                    return;
                }
                return;
            case 19:
                this.mEnableMemSizeOpt = value > 0;
                return;
            case 20:
                this.mEnableAudioTrackReuseWhenPause = value > 0;
                return;
            case 21:
                this.mEnableDirectBufferPool = value > 0;
                return;
            case 22:
                this.mEnableDirectBufferReuseWhenPause = value > 0;
                return;
            case 23:
                this.mEnableResetLogicOpt = value > 0;
                return;
            case 24:
                this.mEnableAudioManagerStateDetect = value;
                return;
        }
    }

    public void setFloatOption(int key, float value) {
        AudioLatencyTuner audioLatencyTuner;
        AVLogger.Debug(TAG, this, "setAjvoiceOption, key:" + key + ", value:" + value);
        if (key != 11) {
            if (key == 12 && (audioLatencyTuner = this.mAudioLatencyTuner) != null) {
                audioLatencyTuner.setFloatOption(key, value);
                return;
            }
            return;
        }
        AudioLatencyTuner audioLatencyTuner2 = this.mAudioLatencyTuner;
        if (audioLatencyTuner2 != null) {
            audioLatencyTuner2.setFloatOption(key, value);
        }
    }

    public int setPlaybackSpeed(float speed) {
        if (this.mAudioTrack == null) {
            AVLogger.Error(TAG, this, "setPlaybackSpeed failed: mAudioTrack is null");
            return -1;
        }
        if (speed == this.mSpeed) {
            return 0;
        }
        try {
            AVLogger.InfoTrackLife(TAG, this, "setPlaybackSpeed by PlaybackParams requires API 23, sdk=" + Build.VERSION.SDK_INT);
            android.media.PlaybackParams playbackParams = new android.media.PlaybackParams();
            playbackParams.allowDefaults();
            playbackParams.setSpeed(speed);
            playbackParams.setPitch(1.0f);
            this.mAudioTrack.setPlaybackParams(playbackParams);
            this.mSpeed = speed;
            AVLogger.InfoTrackLife(TAG, this, "setPlaybackSpeed success, speed=" + speed);
            return 0;
        } catch (Throwable th) {
            AVLogger.Error(TAG, this, "setPlaybackSpeed exception: " + th);
            return -1;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class VolumeKeyReceiver extends BroadcastReceiver {
        public VolumeKeyReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", 0);
            if (!AJVoice.this.mIsSysMute || intExtra <= 0) {
                if (AJVoice.this.mIsSysMute || intExtra != 0) {
                    return;
                }
                AJVoice.this.mIsSysMute = true;
                AJVoice._onSysVolumeChange(AJVoice.this.mNativeObject, 1);
                return;
            }
            AJVoice.this.mIsSysMute = false;
            AJVoice._onSysVolumeChange(AJVoice.this.mNativeObject, 0);
        }
    }

    private int configureDirectBuffer() {
        if (this.mEnableMemSizeOpt) {
            this.mDirectBufferSize = Math.min(this.mTrackBufferSize, this.mBlockSize);
        } else {
            this.mDirectBufferSize = this.mTrackBufferSize;
        }
        if (!this.mUseDirectBuffer || Util.SDK_INT < 21) {
            try {
                this.mMinBytes = new byte[this.mDirectBufferSize];
            } catch (OutOfMemoryError unused) {
                AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
                return -10;
            }
        }
        if (this.mUseDirectBuffer) {
            if (this.mEnableDirectBufferPool) {
                this.mPCMFrameBuffer = this.mDirectBufferPool.getReuseDirectBuffer(this.mDirectBufferSize);
            }
            if (this.mPCMFrameBuffer == null) {
                try {
                    this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
                } catch (Exception unused2) {
                    AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
                    return -10;
                }
            }
        }
        this.mBufferSizeMs = ((this.mTrackBufferSize / this.mOutputPcmFrameSize) * 1000) / this.mSampleRate;
        return 0;
    }

    private int reconfigure() {
        int configureDirectBuffer;
        Context context = this.mContext;
        if (context != null) {
            this.mAudioManager = (AudioManager) context.getSystemService(MediaFormat.KEY_AUDIO);
        }
        AudioManager audioManager = this.mAudioManager;
        if (audioManager != null) {
            this.mMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
            if (this.mMuteOptType == 2) {
                boolean z = getVolume() == 0.0f;
                this.mIsSysMute = z;
                if (z) {
                    _onSysVolumeChange(this.mNativeObject, 1);
                }
                this.mVolumeReceiver = new VolumeKeyReceiver();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
                m237xa2c14eae(this.mContext, this.mVolumeReceiver, intentFilter);
            }
        }
        int audioTrackChannelConfig = getAudioTrackChannelConfig(this.mChannels);
        this.mChannelsLayout = audioTrackChannelConfig;
        if (audioTrackChannelConfig == 0) {
            AVLogger.Debug(TAG, this, String.format(Locale.US, "not supoort channel:%d", Integer.valueOf(this.mChannels)));
            return -1;
        }
        int i = this.mSampleBytes;
        if (i == 1) {
            this.mAudioFormat = 3;
        } else if (i == 2) {
            this.mAudioFormat = 2;
        } else {
            if (i != 4) {
                AVLogger.Debug(TAG, this, String.format(Locale.US, "not supoort format:%d", Integer.valueOf(this.mSampleBytes)));
                return -12;
            }
            this.mAudioFormat = 4;
        }
        AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
        if (audioLatencyTuner != null) {
            this.mTrackBufferSize = audioLatencyTuner.getSuggestedInitialSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat, this.mBlockSize);
        } else {
            this.mTrackBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat);
        }
        if (this.mTrackBufferSize <= 0) {
            AVLogger.Error(TAG, this, "getMinBufferSize failed, trace: sampleRate = " + this.mSampleRate + ", mChannelsLayout = " + this.mChannelsLayout + ", mAudioFormat = " + this.mAudioFormat);
            return this.mTrackBufferSize;
        }
        this.mOutputPcmFrameSize = getPcmFrameSize(this.mAudioFormat, this.mChannels);
        if (!this.mEnableMemSizeOpt && (configureDirectBuffer = configureDirectBuffer()) != 0) {
            return configureDirectBuffer;
        }
        AVLogger.Debug(TAG, this, String.format(Locale.US, "mNativeObject:%d,mBlockSize:%d,mSampleRate:%d,mChannels:%d,mSampBit:%d,minBufSize:%d,mFrameSamples:%d,format:%d", Long.valueOf(this.mNativeObject), Integer.valueOf(this.mBlockSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(this.mChannelsLayout), Integer.valueOf(this.mSampleBytes), Integer.valueOf(this.mTrackBufferSize), Integer.valueOf(this.mFrameSamples), Integer.valueOf(this.mAudioFormat)));
        this.mRawPlaybackHeadWrapCount = 0L;
        return initAudioTrack();
    }

    private int initAudioTrack() {
        if (this.mEnableAudioTrackPool) {
            if (this.mEnableAudioTrackPoolRefactor) {
                AudioTrackBufferRefactor reuseAudioTrack = this.mAudioTrackPoolRefactor.getReuseAudioTrack(new AudioTrackBufferRefactor(null, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mTrackBufferSize, 0));
                this.mAudioTrack = reuseAudioTrack.AudioTrack;
                this.mUsedCount = reuseAudioTrack.usedCount;
                if (reuseAudioTrack.reuseFailReason > 0) {
                    this.mReuseFailReason = reuseAudioTrack.reuseFailReason;
                    this.mIsReuseAudioTrack = false;
                } else {
                    this.mIsReuseAudioTrack = true;
                }
            } else {
                int audioTrackPoolSize = this.mAudioTrackPool.getAudioTrackPoolSize();
                AudioTrackBuffer reuseAudioTrack2 = this.mAudioTrackPool.getReuseAudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples);
                if (reuseAudioTrack2 != null) {
                    this.mAudioTrack = reuseAudioTrack2.AudioTrack;
                    this.mUsedCount = reuseAudioTrack2.usedCount;
                    this.mIsReuseAudioTrack = true;
                } else {
                    if (audioTrackPoolSize <= 0) {
                        this.mReuseFailReason = 2;
                    } else {
                        this.mReuseFailReason = 3;
                    }
                    this.mIsReuseAudioTrack = false;
                }
            }
        } else {
            this.mReuseFailReason = 1;
        }
        if (this.mAudioTrack == null) {
            try {
                this.mAudioTrack = createAudioTrack();
                this.mUsedCount = 0;
            } catch (Throwable th) {
                AVLogger.Error(TAG, this, "create audio track failed ,detail = " + th);
                return -1;
            }
        }
        if (this.mAudioLatencyTuner != null) {
            this.mTrackBufferSize = this.mAudioLatencyTuner.updateAudioTrack(this.mAudioTrack, this.mOutputPcmFrameSize);
        } else if (this.mCalibrationType > 0) {
            this.mTrackBufferSize = this.mAudioTrack.getBufferSizeInFrames() * this.mOutputPcmFrameSize;
        }
        int configureDirectBuffer = this.mEnableMemSizeOpt ? configureDirectBuffer() : 0;
        if (this.mAudioTrack.getState() == 1) {
            return configureDirectBuffer;
        }
        try {
            this.mAudioTrack.release();
            this.mAudioTrack = null;
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null) {
                audioLatencyTuner.close();
            }
            AVLogger.Error(TAG, this, "create audiotrack but failed to initialize");
            return -3;
        } catch (Exception unused) {
            this.mAudioTrack = null;
            AudioLatencyTuner audioLatencyTuner2 = this.mAudioLatencyTuner;
            if (audioLatencyTuner2 != null) {
                audioLatencyTuner2.close();
            }
            AVLogger.Error(TAG, this, "create audiotrack but failed to initialize");
            return -3;
        } catch (Throwable unused2) {
            this.mAudioTrack = null;
            AudioLatencyTuner audioLatencyTuner3 = this.mAudioLatencyTuner;
            if (audioLatencyTuner3 != null) {
                audioLatencyTuner3.close();
            }
            AVLogger.Error(TAG, this, "create audiotrack but failed to initialize");
            return -3;
        }
    }

    private AudioTrack createAudioTrack() {
        if (Util.SDK_INT >= 26 && (this.mAudioPerformanceMode != 0 || this.mEnableAudioTrackCreateOpt)) {
            return createAudioTrackV26();
        }
        if (Util.SDK_INT >= 21 && (this.mAudioPerformanceMode != 0 || this.mEnableAudioTrackCreateOpt)) {
            return createAudioTrackV21();
        }
        return createAudioTrackV9();
    }

    private AudioTrack createAudioTrackV9() {
        if (this.mSessionId == -1) {
            return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1);
        }
        return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1, this.mSessionId);
    }

    private AudioTrack createAudioTrackV21() {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(this.mStreamType);
        int i = this.mContentType;
        if (i != -1) {
            builder.setContentType(i);
        }
        if (this.mAudioPerformanceMode == 1) {
            builder.setFlags(256);
        }
        AudioAttributes build = builder.build();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.mChannelsLayout).setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).build();
        int i2 = this.mTrackBufferSize;
        int i3 = this.mSessionId;
        if (i3 == -1) {
            i3 = 0;
        }
        return new AudioTrack(build, build2, i2, 1, i3);
    }

    private AudioTrack createAudioTrackV26() {
        AudioAttributes.Builder legacyStreamType = new AudioAttributes.Builder().setUsage(1).setLegacyStreamType(this.mStreamType);
        int i = this.mContentType;
        if (i != -1) {
            legacyStreamType.setContentType(i);
        }
        AudioTrack.Builder bufferSizeInBytes = new AudioTrack.Builder().setAudioAttributes(legacyStreamType.build()).setAudioFormat(new AudioFormat.Builder().setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).setChannelMask(this.mChannelsLayout).build()).setBufferSizeInBytes(this.mTrackBufferSize);
        int i2 = this.mSessionId;
        if (i2 == -1) {
            i2 = 0;
        }
        return bufferSizeInBytes.setSessionId(i2).setPerformanceMode(this.mAudioPerformanceMode).build();
    }

    private int reset() {
        AudioManager audioManager;
        this.mWrittenPcmBytes = 0L;
        this.mLatencyMs = 0;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mLeftVolume = -1.0f;
        this.mAvailableSize = -1;
        if (this.mEnableAudioTrackPool) {
            AVLogger.InfoTrackLife(TAG, this, "AudioTrackPool log: reset try pushback AudioTrack: " + this.mAudioTrack);
            int i = this.mEnableAudioManagerStateDetect;
            if (i == 1 && (audioManager = this.mAudioManager) != null) {
                int mode = audioManager.getMode();
                if (mode != 0) {
                    AVLogger.InfoTrackLife(TAG, this, "audio mode:" + mode + ", force release audioTrack");
                    this.mForceReleaseAudioTrackByPool = true;
                }
            } else if (i == 2 && this.mAudioTrack != null) {
                this.mAudioTrack.setVolume(1.0f);
            }
            if (!this.mForceReleaseAudioTrackByPool && this.mSpeed != 1.0f) {
                setPlaybackSpeed(1.0f);
                AVLogger.InfoTrackLife(TAG, this, "reset AudioTrack playSpeed");
            }
            if (this.mEnableAudioTrackPoolRefactor) {
                this.mAudioTrackPoolRefactor.pushAudioTrackBack(new AudioTrackBufferRefactor(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mTrackBufferSize, this.mUsedCount), this.mIsSetVolume, this.mForceReleaseAudioTrackByPool);
                this.mAudioTrack = null;
            } else if (!this.mForceReleaseAudioTrackByPool) {
                if (this.mAudioTrackPool.pushAudioTrackBack(new AudioTrackBuffer(this.mAudioTrack, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mFrameSamples, this.mUsedCount), this.mIsSetVolume) == 0) {
                    this.mAudioTrack = null;
                }
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = null;
            AudioLatencyTuner audioLatencyTuner = this.mAudioLatencyTuner;
            if (audioLatencyTuner != null) {
                audioLatencyTuner.close();
            }
            try {
                audioTrack.flush();
                audioTrack.release();
            } catch (Exception unused) {
            }
        }
        return reconfigure();
    }

    public int getCurrentPositionMs() {
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        if (audioTrackPositionTracker != null) {
            return this.mStartMediaTimeMs + ((int) (audioTrackPositionTracker.getCurrentPositionUs(false) / 1000));
        }
        return 0;
    }

    public int getCurrentAudioOutputDeviceType() {
        AudioDeviceInfo routedDevice;
        if (this.mAudioTrack == null || (routedDevice = this.mAudioTrack.getRoutedDevice()) == null) {
            return 0;
        }
        return routedDevice.getType();
    }

    public String getCurrentAudioOutputDeviceName() {
        AudioDeviceInfo routedDevice;
        return (this.mAudioTrack == null || (routedDevice = this.mAudioTrack.getRoutedDevice()) == null) ? "" : routedDevice.getProductName().toString();
    }

    public int getLatency() {
        if (this.mCalibrationType == 0) {
            getPlaybackHeadPosition();
        }
        if (this.getLatencyMethod != null) {
            long nanoTime = System.nanoTime() / 1000000;
            if (nanoTime - this.mLastGetLatencyMs > 500) {
                try {
                    int intValue = ((Integer) this.getLatencyMethod.invoke(this.mAudioTrack, null)).intValue();
                    this.mLatencyMs = intValue;
                    int max = Math.max(intValue, 0);
                    this.mLatencyMs = max;
                    if (max > 5000) {
                        AVLogger.Warn(TAG, this, "Ignoring impossibly large audio latency: " + this.mLatencyMs);
                        this.mLatencyMs = 0;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
                this.mLastGetLatencyMs = nanoTime;
            }
        }
        return this.mLatencyMs;
    }

    private boolean needsReset() {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && this.mWrittenPcmBytes > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    private long getPlaybackHeadPosition() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
            if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
            }
            return this.lastRawPlaybackHeadPosition;
        }
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private long getPlaybackHeadPositionV2() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = this.mAudioTrack.getPlaybackHeadPosition() & 4294967295L;
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.mRawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.mRawPlaybackHeadWrapCount << 32);
    }

    private long getWrittenDurationMs() {
        return ((this.mWrittenPcmBytes / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
    }

    private long getPlaybackPositionMs() {
        return (getPlaybackHeadPosition() * 1000) / this.mSampleRate;
    }

    private long getPlaybackBytes() {
        return getPlaybackHeadPosition() * getPcmFrameSize(this.mAudioFormat, this.mChannels);
    }

    public int getAvailableBufferSize() {
        if (this.mAvailableSize < 0) {
            this.mAvailableSize = this.mTrackBufferSize - ((int) (this.mWrittenPcmBytes - (getPlaybackHeadPositionV2() * this.mOutputPcmFrameSize)));
        }
        return this.mAvailableSize;
    }

    public int getBufferCacheMS() {
        if (this.mAudioTrack == null) {
            return -1;
        }
        return (int) (getWrittenDurationMs() - getPlaybackPositionMs());
    }

    public int getEOSDelayMs() {
        return (int) ((getWrittenDurationMs() - getPlaybackPositionMs()) + (getLatency() > 0 ? this.mLatencyMs - this.mBufferSizeMs : 0L));
    }

    public static int getPcmFrameSize(int pcmEncoding, int channelCount) {
        if (pcmEncoding == 2) {
            return channelCount * 2;
        }
        if (pcmEncoding == 3) {
            return channelCount;
        }
        if (pcmEncoding == 4) {
            return channelCount * 4;
        }
        throw new IllegalArgumentException();
    }

    public int getTrackBufferSize() {
        return this.mTrackBufferSize;
    }

    public ByteBuffer getPCMFrameBuffer() {
        return this.mPCMFrameBuffer;
    }

    public int reconfigPCMFrameBuffer() {
        int i;
        if (!this.mUseDirectBuffer || (i = this.mDirectBufferSize) <= 0) {
            return 0;
        }
        if (this.mEnableDirectBufferPool) {
            this.mPCMFrameBuffer = this.mDirectBufferPool.getReuseDirectBuffer(i);
        }
        if (this.mPCMFrameBuffer != null) {
            return 0;
        }
        try {
            this.mPCMFrameBuffer = ByteBuffer.allocateDirect(this.mDirectBufferSize);
            return 0;
        } catch (Exception unused) {
            AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
            return -10;
        }
    }

    public void flushAndStop() {
        AVLogger.Debug(TAG, this, "flushAndStop");
        this.mStoped = true;
        this.mWrittenPcmBytes = 0L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLatencyMs = 0;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mRawPlaybackHeadWrapCount = 0L;
        this.mStartMediaTimeMs = -1;
        this.mLeftVolume = -1.0f;
        this.mNativeObject = 0L;
        this.mContext = null;
        try {
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                audioTrack.stop();
            }
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "flushAndStop failed: " + e);
            this.mErrorOccurred = 1;
        }
    }

    public void resetQueue() {
        AudioTrackPool audioTrackPool;
        if (!this.mEnableAudioTrackPool || (audioTrackPool = this.mAudioTrackPool) == null || this.mEnableAudioTrackPoolRefactor) {
            return;
        }
        audioTrackPool.resetQueue();
    }

    public void setPlayerHandler(long nativeObject, Context ctx) {
        this.mNativeObject = nativeObject;
        this.mContext = ctx;
        if (this.mIsSetVolume != 1.0f) {
            setTrackVolume(1.0f, 1.0f);
        }
    }

    public int getErrorOccurred() {
        return this.mErrorOccurred;
    }

    public int getReuseFailReason() {
        return this.mReuseFailReason;
    }

    public boolean getIsReuseAudioTrack() {
        return this.mIsReuseAudioTrack;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m237xa2c14eae(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_ttm_player_AJVoice_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m238xdc75bc47(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
