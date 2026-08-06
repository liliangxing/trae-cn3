package com.ss.ttm.player;

import android.hardware.HardwareBuffer;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceControl;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.ttm.player.UnifiedCodec.UnifiedMediaCodec;
import com.ss.ttm.player.UnifiedCodec.callback.Callback;
import com.ss.ttm.player.UnifiedCodec.util.MimeTypes;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.Constants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class AJMediaCodec {
    private static final int AVCOL_PRI_709 = 1;
    private static final int AVCOL_PRI_BT2020 = 9;
    private static final int AVCOL_RANGE_JPEG = 2;
    private static final int AVCOL_RANGE_MPEG = 1;
    private static final int AVCOL_RANGE_UNSPECIFIED = 0;
    private static final int AV_TRC_ARIB_STD_B67 = 18;
    private static final int AV_TRC_SMPTE2084 = 16;
    private static final int CODEC_ERROR = -10000;
    private static final int CODEC_EXCEPTION_ERROR = -10001;
    private static final int CODEC_ILLEGAL_ARGUMENT = -10003;
    private static final int CODEC_ILLEGAL_STATE = -10002;
    private static final int CODEC_TIME_OUT = 3000;
    private static final double FIX_VERSION = 0.18041d;
    private static final long INPUT_TIMEOUT_US = 30000;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int NO_VALUE = -1;
    private static final int PIXEL_FORMAT_NV12 = 3;
    private static final int PIXEL_FORMAT_YUV420P = 0;
    private static final String TAG = "JAJMediaCodec";
    private static final String VENDOR_OPPO_PROPERTY = "persist.sys.aweme.hdsupport";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private static final Condition mSingleCodecCond;
    private static final ReentrantLock mSingleCodecLock;
    private Handler mAsyncHandler;
    private HandlerThread mAsyncThread;
    private MediaCodec.BufferInfo mBufferInfo;
    private DummySurface mDummySurface;
    private Surface mDummySurfaceV29;
    private String mExceptionInfo;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private UnifiedMediaCodec mUnifiedCodec;
    private static final ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = new ArrayList<>();
    private static final ArrayList<MediaCodecInfo> mVideoSWDecoderCodecs = new ArrayList<>();
    private static final ArrayList<MediaCodecInfo> mAudioSWDecoderCodecs = new ArrayList<>();
    private static final Object mCodecListLock = new Object();
    private static boolean mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mDeviceNeedsSetOutputSurfaceWorkaround = false;
    private static boolean mIsInitDetected = false;
    private static boolean mIsByteVC1Blocklist = false;
    private static boolean mNeedByteVC1WorkAround = false;
    private static int mIsByteVC1BlocklistEnable = 1;
    private static int mEnableMediaCodecSyncClose = 0;
    private static final Object mAsyncLock = new Object();
    private static int mCodecInstanceNums = 0;
    private boolean mInputBuffersValid = false;
    private android.media.MediaFormat mOutputMediaFormat = null;
    private final AJMediaFormat mAJMediaFormat = new AJMediaFormat();
    private int mMcMode = 0;
    private long mHandler = 0;
    private int mPendingFlushCount = 0;
    private final Object mAsyncLock2 = new Object();
    private volatile boolean mCodecIsClosed = false;
    private MediaCodecInfo mCodecInfo = null;
    private String mCodecType = null;
    private int mSupportAdaptivePlayBack = -1;
    private int mFixedMemcpyCrash = 0;
    private int mEnableSingleCodec = 0;
    private int mDowngradeSw = 0;
    private int mHandleOutputBuffersChanged = 0;
    private int mHandleStopAsync = 0;
    private boolean mStopAsync = false;
    private boolean mEnableUnifyCodec = false;
    private boolean mUnifyCodecReuse = false;
    private int mEnableBlockMode = 0;
    private int mEnableUseCodec2 = 0;
    private ConcurrentHashMap<Integer, MediaCodec.LinearBlock> mBlockHashMap = new ConcurrentHashMap<>();
    private int mMCOperatingRateMode = 0;
    private int mMCPriority = 0;
    private int mEnableMCVppLevel = 0;
    private int mMCVppLevel = 0;
    private int mEnableMCVppDebug = 0;
    private int mHisiFrequenceValue = -1;
    private int mEnableQcomOrder = 0;
    private int mEnableQcomSliceDelivery = 0;
    private int mEnableQcomTimestampReorder = 0;
    private int mEnableQcomCpuAffinityMask = 0;
    private int mQcomCpuAffinityMaskValue = 0;
    private int mEnableQcomEarlyNotify = 0;
    private int mQcomEarlyNotifyValue = 0;
    private int mEnableLowLatency = 0;
    private int mEnableHisiLowLatency = 0;
    private int mDecoderType = 0;
    private int mLowLatencyType = 0;
    private int mEnableSetVideoScalingMode = 0;
    private int mMCOperatingRateBeforeOpen = -1;
    private int mImportanceValue = -1;
    private int mDisableAllowFrameDrop = 0;
    private int mSpecifyMaxInputSize = -1;
    private int mEnableGetCodecInfosOpt = 0;
    private int mCreateCodecTimeoutMs = 0;
    private boolean mEnableCacheCodecAsync = false;

    private static native void _clearBufferIndex(long handle);

    private static native void _clearBufferIndex2(long handle);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onClosed2(long handle);

    private static native void _onDrawFrame(long handle, HardwareBuffer buffer, int[] roi, int rotation, int colorSpace);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onEmptyBuffer(long handle, int index);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onEmptyBuffer2(long handle, int index);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onError(long handle);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onError2(long handle, int code, String info);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFilledBuffer(long handle, int index, int offset, int size, long pts, int flags);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFilledBuffer2(long handle, int index, int offset, int size, long pts, int flags);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFormatChanged(long handle, int index, int w, int h, int sampleRate, int channelCount, int colorFmt, int colorTrans, int sliceHeight, int stride, int colorSpace, int colorRange);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void _onFormatChanged2(long handle, int index, int w, int h, int sampleRate, int channelCount, int colorFmt, int colorTrans, int sliceHeight, int stride, int colorSpace, int colorRange);

    private static native void _setSurfaceCompleted(long handle);

    private static native void _setSurfaceCompleted2(long handle);

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        mSingleCodecLock = reentrantLock;
        mSingleCodecCond = reentrantLock.newCondition();
    }

    public boolean MTKByteVC1NeedWorkAround() {
        return mNeedByteVC1WorkAround;
    }

    public static String getProperty(String key, String defaultValue) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, key, defaultValue);
            } catch (Exception e) {
                e.printStackTrace();
                return defaultValue;
            }
        } catch (Throwable unused) {
            return defaultValue;
        }
    }

    public AJMediaCodec() {
        boolean z = false;
        if (!mIsInitDetected) {
            if (Util.HARDWARE.toLowerCase(Locale.US).startsWith("mt") && Util.SDK_INT < 26) {
                z = true;
            }
            mNeedByteVC1WorkAround = z;
            if (isHisiByteVC1BlockList() || isMtkByteVC1BlockList()) {
                mIsByteVC1Blocklist = true;
            }
        }
        codecNeedsSetOutputSurfaceWorkaround();
        mIsInitDetected = true;
        AVLogger.InfoTrackLife(TAG, this, "JAJMediaCodec#^workaround:" + mDeviceNeedsSetOutputSurfaceWorkaround);
    }

    public void setHandler(long handler) {
        AVLogger.Debug(TAG, this, "ttmn: setHandler " + handler);
        this.mHandler = handler;
    }

    public void setMode(int mode, int memcpyCrash) {
        AVLogger.Debug(TAG, this, "ttmn: mode " + mode + ", memcpyCrash " + memcpyCrash);
        this.mMcMode = mode;
        this.mFixedMemcpyCrash = memcpyCrash;
    }

    public void setSingleCodec(int enable) {
        AVLogger.Debug(TAG, this, "ttmn: EnableSingleCodec " + enable);
        this.mEnableSingleCodec = enable;
    }

    public void setBlockMode(int enable) {
        AVLogger.Debug(TAG, this, "ttmn: EnableBlockModel " + enable);
        this.mEnableBlockMode = enable;
    }

    public void setUseCodec2(int enable) {
        AVLogger.Debug(TAG, this, "ttmn: EnableUseCodec2 " + enable);
        this.mEnableUseCodec2 = enable;
    }

    public void setDowngradeSw(int downgradeSw) {
        AVLogger.Debug(TAG, this, "ttmn: downgradeSw " + downgradeSw);
        this.mDowngradeSw = downgradeSw;
    }

    public void setHandleStopAsync(int handleStopAsync) {
        AVLogger.Debug(TAG, this, "ttmn: handleStopAsync " + handleStopAsync);
        this.mHandleStopAsync = handleStopAsync;
    }

    public void setHandleOutputBuffersChanged(int handleOutputBuffersChanged) {
        AVLogger.Debug(TAG, this, "ttmn: handleOutputBuffersChanged " + handleOutputBuffersChanged);
        this.mHandleOutputBuffersChanged = handleOutputBuffersChanged;
    }

    public String getErrorInfo() {
        return this.mExceptionInfo;
    }

    private boolean isHisiByteVC1BlockList() {
        double d;
        String property = getProperty("ro.board.platform", null);
        if (Util.SDK_INT != 26 || property == null) {
            return false;
        }
        if (!property.startsWith("kirin960") && !property.startsWith("hi3660")) {
            return false;
        }
        try {
            d = Double.parseDouble(getProperty(VERSION_PROPERTY, "0.0"));
        } catch (NumberFormatException unused) {
            AVLogger.Warn(TAG, this, "vendor property abnormal");
            d = 0.0d;
        }
        return d < FIX_VERSION;
    }

    private boolean supportSetSurface() {
        return !mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private boolean isMtkByteVC1BlockList() {
        String lowerCase = Util.HARDWARE.toLowerCase(Locale.US);
        return lowerCase.startsWith("mt6763") || lowerCase.startsWith("mt6757") || lowerCase.startsWith("mt6739") || lowerCase.startsWith("mt6750");
    }

    public int vendorOppoHWEnable() {
        if (Util.BARND.equals("OPPO")) {
            String property = getProperty(VENDOR_OPPO_PROPERTY, PushClient.DEFAULT_REQUEST_ID);
            AVLogger.Debug(TAG, this, "oppo property = " + property);
            try {
                return Integer.parseInt(property);
            } catch (NumberFormatException unused) {
                AVLogger.Warn(TAG, this, "vendor oppo property abnormal");
            }
        }
        return 1;
    }

    public int createByCodecName(String codecName) {
        UnifiedMediaCodec unifiedMediaCodec;
        AVLogger.Info(TAG, this, "createByCodecName = " + codecName);
        try {
            boolean z = true;
            if (this.mEnableSingleCodec == 1) {
                try {
                    ReentrantLock reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    if (mCodecInstanceNums > 0) {
                        mSingleCodecCond.await(3000L, TimeUnit.MILLISECONDS);
                    }
                    if (mCodecInstanceNums > 0) {
                        AVLogger.Warn(TAG, this, "already create a media codec");
                        reentrantLock.unlock();
                        return -1;
                    }
                    if (this.mEnableUnifyCodec) {
                        UnifiedMediaCodec createByCodecName = UnifiedMediaCodec.createByCodecName(codecName);
                        this.mUnifiedCodec = createByCodecName;
                        createByCodecName.setEnableReuse(this.mUnifyCodecReuse);
                        this.mUnifiedCodec.createCodecEarly();
                        UnifiedMediaCodec unifiedMediaCodec2 = this.mUnifiedCodec;
                        if (unifiedMediaCodec2 != null) {
                            mCodecInstanceNums++;
                        }
                        if (this.mOutputMediaFormat == null && unifiedMediaCodec2 != null) {
                            this.mOutputMediaFormat = unifiedMediaCodec2.getOutputFormat();
                        }
                    } else {
                        MediaCodec createByCodecName2 = MediacodecBlockManager.createByCodecName(codecName, this.mCreateCodecTimeoutMs, mEnableMediaCodecSyncClose > 0);
                        this.mMediaCodec = createByCodecName2;
                        if (createByCodecName2 != null) {
                            mCodecInstanceNums++;
                        }
                    }
                    reentrantLock.unlock();
                } catch (Throwable th) {
                    mSingleCodecLock.unlock();
                    throw th;
                }
            } else if (this.mEnableUnifyCodec) {
                UnifiedMediaCodec createByCodecName3 = UnifiedMediaCodec.createByCodecName(codecName);
                this.mUnifiedCodec = createByCodecName3;
                createByCodecName3.setEnableReuse(this.mUnifyCodecReuse);
                this.mUnifiedCodec.createCodecEarly();
                if (this.mOutputMediaFormat == null && (unifiedMediaCodec = this.mUnifiedCodec) != null) {
                    this.mOutputMediaFormat = unifiedMediaCodec.getOutputFormat();
                }
            } else {
                long j = this.mCreateCodecTimeoutMs;
                if (mEnableMediaCodecSyncClose <= 0) {
                    z = false;
                }
                this.mMediaCodec = MediacodecBlockManager.createByCodecName(codecName, j, z);
            }
            if (this.mEnableUnifyCodec) {
                if (this.mUnifiedCodec == null) {
                    return -1;
                }
            } else if (this.mMediaCodec == null) {
                return -1;
            }
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Error(TAG, this, "createByCodecName failed, exception = " + e);
            return -1;
        }
    }

    private static void maybeSetInteger(AJMediaFormat format, String key, int value) {
        if (value != -1) {
            format.setInteger(key, value);
        }
    }

    private static void maybeSetCsdBuffers(AJMediaFormat format, ByteBuffer csd, int idx) {
        if (csd == null) {
            return;
        }
        format.setByteBuffer("csd-" + idx, csd);
    }

    private Surface createDummySurface(boolean optimize) {
        AVLogger.Info(TAG, this, "create dummy surface, optimize = " + optimize);
        if (Util.SDK_INT >= 29 && optimize) {
            try {
                Surface surface = new Surface(new SurfaceControl.Builder().setName("mc_dummy_surface").setBufferSize(1, 1).build());
                this.mDummySurfaceV29 = surface;
                return surface;
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "create dummy surface exp = " + e);
                this.mDummySurfaceV29 = null;
            }
        }
        DummySurface newInstanceV17 = DummySurface.newInstanceV17(false);
        this.mDummySurface = newInstanceV17;
        return newInstanceV17;
    }

    private void releaseDummySurface() {
        AVLogger.Info(TAG, this, "release dummy surface");
        Surface surface = this.mDummySurfaceV29;
        if (surface != null) {
            surface.release();
            this.mDummySurfaceV29 = null;
        }
        DummySurface dummySurface = this.mDummySurface;
        if (dummySurface != null) {
            dummySurface.release();
            this.mDummySurface = null;
        }
    }

    private void setMediaCodecCallback(int mode) {
        MediaCodec.Callback callback = new MediaCodec.Callback() { // from class: com.ss.ttm.player.AJMediaCodec.1
            @Override // android.media.MediaCodec.Callback
            public void onInputBufferAvailable(MediaCodec codec, int index) {
                if (codec == AJMediaCodec.this.mMediaCodec) {
                    synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        if (AJMediaCodec.this.mMcMode == 2) {
                            AJMediaCodec._onEmptyBuffer2(AJMediaCodec.this.mHandler, index);
                        } else {
                            AJMediaCodec._onEmptyBuffer(AJMediaCodec.this.mHandler, index);
                        }
                    }
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
                if (codec == AJMediaCodec.this.mMediaCodec) {
                    synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        if (AJMediaCodec.this.mMcMode == 2) {
                            AJMediaCodec._onFilledBuffer2(AJMediaCodec.this.mHandler, index, info.offset, info.size, info.presentationTimeUs, info.flags);
                        } else {
                            AJMediaCodec._onFilledBuffer(AJMediaCodec.this.mHandler, index, info.offset, info.size, info.presentationTimeUs, info.flags);
                        }
                    }
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onError(MediaCodec codec, MediaCodec.CodecException e) {
                AVLogger.Error(AJMediaCodec.TAG, this, "ttmn: " + e + " closed = " + AJMediaCodec.this.mCodecIsClosed);
                synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                    if (AJMediaCodec.this.mCodecIsClosed) {
                        return;
                    }
                    if (AJMediaCodec.this.mMcMode == 2) {
                        AJMediaCodec._onError2(AJMediaCodec.this.mHandler, AJMediaCodec.this.handleCodecException(e), AJMediaCodec.this.mExceptionInfo);
                    } else {
                        AJMediaCodec._onError(AJMediaCodec.this.mHandler);
                    }
                }
            }

            @Override // android.media.MediaCodec.Callback
            public void onOutputFormatChanged(MediaCodec codec, android.media.MediaFormat format) {
                int integer;
                int integer2;
                AVLogger.Info(AJMediaCodec.TAG, this, "onOutputFormatChanged = " + format);
                AJMediaCodec.this.mOutputMediaFormat = format;
                if (AJMediaCodec.this.mEnableSetVideoScalingMode > 0 && !AJMediaCodec.this.mCodecIsClosed) {
                    codec.setVideoScalingMode(2);
                }
                if (format != null) {
                    try {
                        String string = format.getString("mime");
                        if (string.startsWith(MediaFormat.KEY_VIDEO)) {
                            boolean z = format.containsKey(AJMediaCodec.KEY_CROP_RIGHT) && format.containsKey(AJMediaCodec.KEY_CROP_LEFT) && format.containsKey(AJMediaCodec.KEY_CROP_BOTTOM) && format.containsKey(AJMediaCodec.KEY_CROP_TOP);
                            AJMediaFormat aJMediaFormat = AJMediaCodec.this.mAJMediaFormat;
                            if (z) {
                                integer = (format.getInteger(AJMediaCodec.KEY_CROP_RIGHT) - format.getInteger(AJMediaCodec.KEY_CROP_LEFT)) + 1;
                            } else {
                                integer = format.getInteger("width");
                            }
                            aJMediaFormat.width = integer;
                            AJMediaFormat aJMediaFormat2 = AJMediaCodec.this.mAJMediaFormat;
                            if (z) {
                                integer2 = (format.getInteger(AJMediaCodec.KEY_CROP_BOTTOM) - format.getInteger(AJMediaCodec.KEY_CROP_TOP)) + 1;
                            } else {
                                integer2 = format.getInteger("height");
                            }
                            aJMediaFormat2.height = integer2;
                            int integer3 = format.containsKey("color-format") ? format.getInteger("color-format") : 0;
                            if (integer3 == 21 || integer3 == 2130706688 || integer3 == 2141391872) {
                                AJMediaCodec.this.mAJMediaFormat.colorFormat = 3;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorFormat = 0;
                            }
                            int integer4 = format.containsKey("color-transfer") ? format.getInteger("color-transfer") : 0;
                            if (integer4 == 6) {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 16;
                            } else if (integer4 != 7) {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 18;
                            }
                            int integer5 = format.containsKey("color-standard") ? format.getInteger("color-standard") : 0;
                            if (integer5 == 1) {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 1;
                            } else if (integer5 != 6) {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 9;
                            }
                            int integer6 = format.containsKey("color-range") ? format.getInteger("color-range") : 0;
                            if (integer6 == 1) {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 2;
                            } else if (integer6 != 2) {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 1;
                            }
                            AJMediaCodec.this.mAJMediaFormat.sliceHeight = format.containsKey("slice-height") ? format.getInteger("slice-height") : 0;
                            AJMediaCodec.this.mAJMediaFormat.stride = format.containsKey("stride") ? format.getInteger("stride") : 0;
                        }
                        if (string.startsWith(MediaFormat.KEY_AUDIO)) {
                            AJMediaCodec.this.mAJMediaFormat.sampleRate = format.containsKey(MediaFormat.KEY_SAMPLE_RATE) ? format.getInteger(MediaFormat.KEY_SAMPLE_RATE) : 0;
                            AJMediaCodec.this.mAJMediaFormat.channelCount = format.containsKey(MediaFormat.KEY_CHANNEL_COUNT) ? format.getInteger(MediaFormat.KEY_CHANNEL_COUNT) : 0;
                        }
                    } catch (Exception e) {
                        AVLogger.Error(AJMediaCodec.TAG, this, e.toString());
                        AJMediaCodec.this.mAJMediaFormat.reset();
                        if (AJMediaCodec.this.mMcMode == 2) {
                            synchronized (AJMediaCodec.this.mAsyncLock2) {
                                if (AJMediaCodec.this.mCodecIsClosed) {
                                    return;
                                }
                                AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                                return;
                            }
                        }
                        AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                        return;
                    }
                }
                if (AJMediaCodec.this.mMcMode == 2) {
                    synchronized (AJMediaCodec.this.mAsyncLock2) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride, AJMediaCodec.this.mAJMediaFormat.colorSpace, AJMediaCodec.this.mAJMediaFormat.colorRange);
                        return;
                    }
                }
                AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride, AJMediaCodec.this.mAJMediaFormat.colorSpace, AJMediaCodec.this.mAJMediaFormat.colorRange);
            }
        };
        if (Util.SDK_INT < 23) {
            this.mMediaCodec.setCallback(callback);
            this.mAsyncHandler = new Handler(Looper.getMainLooper());
        } else {
            AVLogger.Debug(TAG, this, "create async thread");
            HandlerThread handlerThread = new HandlerThread("mc_async");
            this.mAsyncThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.mAsyncThread.getLooper());
            this.mAsyncHandler = handler;
            this.mMediaCodec.setCallback(callback, handler);
        }
        AVLogger.Debug(TAG, this, "success to set callback = " + callback);
    }

    private void setUnifiedCodecCallback(int mode) {
        Callback callback = new Callback() { // from class: com.ss.ttm.player.AJMediaCodec.2
            @Override // com.ss.ttm.player.UnifiedCodec.callback.Callback
            public void onInputBufferAvailable(UnifiedMediaCodec codec, int index) {
                if (codec == AJMediaCodec.this.mUnifiedCodec) {
                    synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        if (AJMediaCodec.this.mMcMode == 2) {
                            AJMediaCodec._onEmptyBuffer2(AJMediaCodec.this.mHandler, index);
                        } else {
                            AJMediaCodec._onEmptyBuffer(AJMediaCodec.this.mHandler, index);
                        }
                    }
                }
            }

            @Override // com.ss.ttm.player.UnifiedCodec.callback.Callback
            public void onOutputBufferAvailable(UnifiedMediaCodec codec, int index, MediaCodec.BufferInfo info) {
                if (codec == AJMediaCodec.this.mUnifiedCodec) {
                    synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        if (AJMediaCodec.this.mMcMode == 2) {
                            AJMediaCodec._onFilledBuffer2(AJMediaCodec.this.mHandler, index, info.offset, info.size, info.presentationTimeUs, info.flags);
                        } else {
                            AJMediaCodec._onFilledBuffer(AJMediaCodec.this.mHandler, index, info.offset, info.size, info.presentationTimeUs, info.flags);
                        }
                    }
                }
            }

            @Override // com.ss.ttm.player.UnifiedCodec.callback.Callback
            public void onError(UnifiedMediaCodec codec, MediaCodec.CodecException e) {
                AVLogger.Error(AJMediaCodec.TAG, this, "ttmn: " + e + " closed = " + AJMediaCodec.this.mCodecIsClosed);
                synchronized ((AJMediaCodec.this.mMcMode == 2 ? AJMediaCodec.this.mAsyncLock2 : AJMediaCodec.mAsyncLock)) {
                    if (AJMediaCodec.this.mCodecIsClosed) {
                        return;
                    }
                    if (AJMediaCodec.this.mMcMode == 2) {
                        AJMediaCodec._onError2(AJMediaCodec.this.mHandler, AJMediaCodec.this.handleCodecException(e), AJMediaCodec.this.mExceptionInfo);
                    } else {
                        AJMediaCodec._onError(AJMediaCodec.this.mHandler);
                    }
                }
            }

            @Override // com.ss.ttm.player.UnifiedCodec.callback.Callback
            public void onOutputFormatChanged(UnifiedMediaCodec codec, android.media.MediaFormat format) {
                int integer;
                int integer2;
                AVLogger.Info(AJMediaCodec.TAG, this, "onOutputFormatChanged = " + format);
                AJMediaCodec.this.mOutputMediaFormat = format;
                if (AJMediaCodec.this.mEnableSetVideoScalingMode > 0) {
                    codec.setVideoScalingMode(2);
                }
                if (format != null) {
                    try {
                        String string = format.getString("mime");
                        if (string.startsWith(MediaFormat.KEY_VIDEO)) {
                            boolean z = format.containsKey(AJMediaCodec.KEY_CROP_RIGHT) && format.containsKey(AJMediaCodec.KEY_CROP_LEFT) && format.containsKey(AJMediaCodec.KEY_CROP_BOTTOM) && format.containsKey(AJMediaCodec.KEY_CROP_TOP);
                            AJMediaFormat aJMediaFormat = AJMediaCodec.this.mAJMediaFormat;
                            if (z) {
                                integer = (format.getInteger(AJMediaCodec.KEY_CROP_RIGHT) - format.getInteger(AJMediaCodec.KEY_CROP_LEFT)) + 1;
                            } else {
                                integer = format.getInteger("width");
                            }
                            aJMediaFormat.width = integer;
                            AJMediaFormat aJMediaFormat2 = AJMediaCodec.this.mAJMediaFormat;
                            if (z) {
                                integer2 = (format.getInteger(AJMediaCodec.KEY_CROP_BOTTOM) - format.getInteger(AJMediaCodec.KEY_CROP_TOP)) + 1;
                            } else {
                                integer2 = format.getInteger("height");
                            }
                            aJMediaFormat2.height = integer2;
                            int integer3 = format.containsKey("color-format") ? format.getInteger("color-format") : 0;
                            if (integer3 == 21 || integer3 == 2130706688 || integer3 == 2141391872) {
                                AJMediaCodec.this.mAJMediaFormat.colorFormat = 3;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorFormat = 0;
                            }
                            int integer4 = format.containsKey("color-transfer") ? format.getInteger("color-transfer") : 0;
                            if (integer4 == 6) {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 16;
                            } else if (integer4 != 7) {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorTrans = 18;
                            }
                            int integer5 = format.containsKey("color-standard") ? format.getInteger("color-standard") : 0;
                            if (integer5 == 1) {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 1;
                            } else if (integer5 != 6) {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorSpace = 9;
                            }
                            int integer6 = format.containsKey("color-range") ? format.getInteger("color-range") : 0;
                            if (integer6 == 1) {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 2;
                            } else if (integer6 != 2) {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 0;
                            } else {
                                AJMediaCodec.this.mAJMediaFormat.colorRange = 1;
                            }
                            AJMediaCodec.this.mAJMediaFormat.sliceHeight = format.containsKey("slice-height") ? format.getInteger("slice-height") : 0;
                            AJMediaCodec.this.mAJMediaFormat.stride = format.containsKey("stride") ? format.getInteger("stride") : 0;
                        }
                        if (string.startsWith(MediaFormat.KEY_AUDIO)) {
                            AJMediaCodec.this.mAJMediaFormat.sampleRate = format.containsKey(MediaFormat.KEY_SAMPLE_RATE) ? format.getInteger(MediaFormat.KEY_SAMPLE_RATE) : 0;
                            AJMediaCodec.this.mAJMediaFormat.channelCount = format.containsKey(MediaFormat.KEY_CHANNEL_COUNT) ? format.getInteger(MediaFormat.KEY_CHANNEL_COUNT) : 0;
                        }
                    } catch (Exception e) {
                        AVLogger.Error(AJMediaCodec.TAG, this, e.toString());
                        AJMediaCodec.this.mAJMediaFormat.reset();
                        if (AJMediaCodec.this.mMcMode == 2) {
                            synchronized (AJMediaCodec.this.mAsyncLock2) {
                                if (AJMediaCodec.this.mCodecIsClosed) {
                                    return;
                                }
                                AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                                return;
                            }
                        }
                        AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
                        return;
                    }
                }
                if (AJMediaCodec.this.mMcMode == 2) {
                    synchronized (AJMediaCodec.this.mAsyncLock2) {
                        if (AJMediaCodec.this.mCodecIsClosed) {
                            return;
                        }
                        AJMediaCodec._onFormatChanged2(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride, AJMediaCodec.this.mAJMediaFormat.colorSpace, AJMediaCodec.this.mAJMediaFormat.colorRange);
                        return;
                    }
                }
                AJMediaCodec._onFormatChanged(AJMediaCodec.this.mHandler, 0, AJMediaCodec.this.mAJMediaFormat.width, AJMediaCodec.this.mAJMediaFormat.height, AJMediaCodec.this.mAJMediaFormat.sampleRate, AJMediaCodec.this.mAJMediaFormat.channelCount, AJMediaCodec.this.mAJMediaFormat.colorFormat, AJMediaCodec.this.mAJMediaFormat.colorTrans, AJMediaCodec.this.mAJMediaFormat.sliceHeight, AJMediaCodec.this.mAJMediaFormat.stride, AJMediaCodec.this.mAJMediaFormat.colorSpace, AJMediaCodec.this.mAJMediaFormat.colorRange);
            }
        };
        if (Util.SDK_INT < 23) {
            this.mUnifiedCodec.setCallback(callback);
            this.mAsyncHandler = new Handler(Looper.getMainLooper());
        } else {
            AVLogger.Debug(TAG, this, "create async thread");
            HandlerThread handlerThread = new HandlerThread("mc_async");
            this.mAsyncThread = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.mAsyncThread.getLooper());
            this.mAsyncHandler = handler;
            this.mUnifiedCodec.setCallback(callback, handler);
        }
        AVLogger.Debug(TAG, this, "success to set unifield callback = " + callback);
    }

    public int setCallback(int mode) {
        if (mode == 0) {
            return 0;
        }
        try {
            AVLogger.Debug(TAG, this, "ttmn: set callback func.");
            if (this.mUnifiedCodec != null) {
                setUnifiedCodecCallback(mode);
            } else {
                setMediaCodecCallback(mode);
            }
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "failed to set callback, exception = " + e);
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFlushCompleted(Runnable onFlushCompleted) {
        AVLogger.Debug(TAG, this, "onFlushCompleted, closed = " + this.mCodecIsClosed);
        synchronized ((this.mMcMode == 2 ? this.mAsyncLock2 : mAsyncLock)) {
            if (this.mCodecIsClosed) {
                return;
            }
            int i = this.mPendingFlushCount - 1;
            this.mPendingFlushCount = i;
            if (i > 0) {
                return;
            }
            if (i < 0) {
                return;
            }
            if (this.mMcMode == 2) {
                _clearBufferIndex2(this.mHandler);
            } else {
                _clearBufferIndex(this.mHandler);
            }
            try {
                onFlushCompleted.run();
            } catch (Exception e) {
                if (e instanceof IllegalStateException) {
                    if (this.mMcMode == 2) {
                        _onError2(this.mHandler, CODEC_ILLEGAL_STATE, "onFlushCompleted exception");
                    } else {
                        _onError(this.mHandler);
                    }
                } else {
                    AVLogger.Error(TAG, this, e.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSetSurfaceCompleted() {
        AVLogger.Debug(TAG, this, "onSetSurfaceCompleted, closed = " + this.mCodecIsClosed);
        synchronized ((this.mMcMode == 2 ? this.mAsyncLock2 : mAsyncLock)) {
            if (this.mCodecIsClosed) {
                return;
            }
            if (this.mMcMode == 2) {
                _setSurfaceCompleted2(this.mHandler);
            } else {
                _setSurfaceCompleted(this.mHandler);
            }
        }
    }

    private int setExtOptions(AJMediaFormat format, boolean enableVpp, int vppLevel, boolean debugVpp, boolean lowLatency, int doviProfile, int doviLevel, int lowLatencyV30, String extConfig) {
        if (this.mMCOperatingRateMode == 2) {
            MediaCodecHelper.setMaxOperatingRate(format);
        } else {
            int i = this.mMCOperatingRateBeforeOpen;
            if (i >= 0) {
                MediaCodecHelper.setOperatingRateBeforeOpen(format, i);
            }
        }
        MediaCodecHelper.setPriority(format, this.mMCPriority);
        if (this.mEnableMCVppLevel > 0) {
            MediaCodecHelper.setupVpp(format, this.mMCVppLevel, this.mCodecInfo.getName());
        }
        if (this.mEnableMCVppDebug > 0) {
            MediaCodecHelper.debugEffect(format, this.mCodecInfo.getName());
        }
        int i2 = this.mHisiFrequenceValue;
        if (i2 >= 0) {
            MediaCodecHelper.setHisiFrequence(format, i2, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomOrder > 0) {
            MediaCodecHelper.setQcomOrder(format, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomSliceDelivery > 0) {
            MediaCodecHelper.setQcomSliceDeliveryMode(format, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomTimestampReorder > 0) {
            MediaCodecHelper.setQcomTimestampReorder(format, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomCpuAffinityMask > 0) {
            MediaCodecHelper.setQcomCpuAffinityMask(format, this.mQcomCpuAffinityMaskValue, this.mCodecInfo.getName());
        }
        if (this.mEnableQcomEarlyNotify > 0) {
            MediaCodecHelper.setQcomEarlyNotifyValue(format, this.mQcomEarlyNotifyValue, this.mCodecInfo.getName());
        }
        int i3 = this.mEnableLowLatency;
        if (i3 > 0) {
            MediaCodecHelper.setLowLatency(format, this.mCodecInfo, i3);
        }
        if (this.mEnableHisiLowLatency > 0) {
            MediaCodecHelper.setHisiLowLatency(format, this.mCodecInfo.getName());
        }
        int i4 = this.mImportanceValue;
        if (i4 >= 0) {
            MediaCodecHelper.setImportance(format, i4);
        }
        if (this.mDisableAllowFrameDrop > 0) {
            MediaCodecHelper.disableAllowFrameDrop(format);
        }
        if (enableVpp) {
            VendorQTI.setupVpp(format, vppLevel);
        }
        if (debugVpp) {
            VendorQTI.debugEffect(format);
        }
        if (lowLatency) {
            VendorQTI.enableLowLatency(format);
        }
        if (lowLatencyV30 > 0 && isLowLatencyDecode() > 0) {
            AVLogger.Debug(TAG, this, "low latency works.");
            maybeSetInteger(format, "low-latency", 1);
        }
        if (doviLevel > 0 && doviProfile >= 0) {
            String dolbyCodecs = MediaCodecUtil.getDolbyCodecs(doviProfile, doviLevel);
            AVLogger.Debug(TAG, this, "dv codecs = " + dolbyCodecs);
            Pair<Integer, Integer> dolbyVisionProfileAndLevel = MediaCodecUtil.getDolbyVisionProfileAndLevel(dolbyCodecs, dolbyCodecs != null ? dolbyCodecs.split("\\.") : null);
            if (dolbyVisionProfileAndLevel != null) {
                AVLogger.Info(TAG, this, "dv profile & level  = " + dolbyVisionProfileAndLevel.toString());
                maybeSetInteger(format, "profile", ((Integer) dolbyVisionProfileAndLevel.first).intValue());
            }
        }
        if (!TextUtils.isEmpty(extConfig)) {
            try {
                for (String str : extConfig.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
                    String[] split = str.split(RomUtils.SEPARATOR);
                    if (split.length == 2) {
                        try {
                            maybeSetInteger(format, split[0], Integer.parseInt(split[1]));
                            AVLogger.Info(TAG, this, "ext config " + split[0] + " = " + split[1]);
                        } catch (Exception e) {
                            AVLogger.Warn(TAG, this, "set ext config = " + str + " exp = " + e);
                        }
                    } else {
                        AVLogger.Warn(TAG, this, "unsupported ext config = " + str);
                    }
                }
            } catch (Exception e2) {
                AVLogger.Warn(TAG, this, "parse ext config = " + extConfig + " exp = " + e2);
            }
        }
        return format.getMap().size();
    }

    public int configure(int width, int height, int rotation, int sampleRate, int channelCount, String codecType, ByteBuffer csd0, ByteBuffer csd1, ByteBuffer csd2, Surface surface, boolean surfaceConfigure, boolean realTime, int maxWidth, int maxHeight, boolean enableVpp, int vppLevel, boolean debugVpp, boolean lowLatency, int doviProfile, int doviLevel, int lowLatencyV30, String extConfig) {
        Surface surface2 = surface;
        int i = maxWidth;
        int i2 = maxHeight;
        AVLogger.Info(TAG, this, "configure surface = " + surface2 + ", surfaceConfigure = " + surfaceConfigure);
        if (Util.SDK_INT >= 21 && setCallback(this.mMcMode) == -1) {
            return -1;
        }
        AJMediaFormat aJMediaFormat = new AJMediaFormat();
        aJMediaFormat.setString("mime", codecType);
        maybeSetInteger(aJMediaFormat, "width", width);
        maybeSetInteger(aJMediaFormat, "height", height);
        if (i != -1 && i2 != -1) {
            if (i <= width) {
                i = width;
            }
            maybeSetInteger(aJMediaFormat, "max-width", i);
            if (i2 <= height) {
                i2 = height;
            }
            maybeSetInteger(aJMediaFormat, "max-height", i2);
        }
        maybeSetInteger(aJMediaFormat, MediaFormat.KEY_SAMPLE_RATE, sampleRate);
        maybeSetInteger(aJMediaFormat, MediaFormat.KEY_CHANNEL_COUNT, channelCount);
        int i3 = this.mSpecifyMaxInputSize;
        if (i3 < 0) {
            i3 = getMaxInputSize(codecType, width, height);
        }
        AVLogger.Debug(TAG, this, "max input = " + i3);
        maybeSetInteger(aJMediaFormat, "max-input-size", i3);
        maybeSetCsdBuffers(aJMediaFormat, csd0, 0);
        maybeSetCsdBuffers(aJMediaFormat, csd1, 1);
        maybeSetCsdBuffers(aJMediaFormat, csd2, 2);
        if (surfaceConfigure) {
            if (Util.SDK_INT >= 21) {
                maybeSetInteger(aJMediaFormat, "rotation-degrees", rotation);
            }
            if ((surface2 == null || !surface.isValid()) && Util.SDK_INT >= 23 && !mDeviceNeedsSetOutputSurfaceWorkaround) {
                if (this.mDummySurface == null) {
                    createDummySurface(false);
                }
                AVLogger.Info(TAG, this, "use dummy surface = " + this.mDummySurface);
                surface2 = this.mDummySurface;
            }
            if (surface2 == null) {
                this.mExceptionInfo = "Error: configure with null surface";
                AVLogger.Error(TAG, this, "Error: configure with null surface");
                return CODEC_ILLEGAL_ARGUMENT;
            }
        }
        if (this.mCodecInfo == null || TextUtils.isEmpty(this.mCodecType)) {
            try {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    this.mCodecInfo = unifiedMediaCodec.getCodecInfo();
                } else {
                    this.mCodecInfo = this.mMediaCodec.getCodecInfo();
                }
                this.mCodecType = codecType;
            } catch (Exception unused) {
            }
        }
        setExtOptions(aJMediaFormat, enableVpp, vppLevel, debugVpp, lowLatency, doviProfile, doviLevel, lowLatencyV30, extConfig);
        AVLogger.Info(TAG, this, "format = " + aJMediaFormat.getMediaFormat());
        try {
            if (Util.SDK_INT >= 30) {
                AVLogger.Info(TAG, this, "block mode = " + this.mEnableBlockMode);
                if (this.mEnableUnifyCodec) {
                    this.mUnifiedCodec.configure(aJMediaFormat.getMediaFormat(), surface2, (MediaCrypto) null, this.mEnableBlockMode == 1 ? 2 : 0);
                } else {
                    this.mMediaCodec.configure(aJMediaFormat.getMediaFormat(), surface2, (MediaCrypto) null, this.mEnableBlockMode == 1 ? 2 : 0);
                }
            } else if (this.mEnableUnifyCodec) {
                this.mUnifiedCodec.configure(aJMediaFormat.getMediaFormat(), surface2, (MediaCrypto) null, 0);
            } else {
                this.mMediaCodec.configure(aJMediaFormat.getMediaFormat(), surface2, (MediaCrypto) null, 0);
            }
            if (this.mEnableSetVideoScalingMode > 0) {
                if (this.mEnableUnifyCodec) {
                    this.mUnifiedCodec.setVideoScalingMode(2);
                } else {
                    this.mMediaCodec.setVideoScalingMode(2);
                }
            }
            return 0;
        } catch (Exception e) {
            handleCodecException(e);
            AVLogger.Error(TAG, this, "configure failed, codec = " + (this.mEnableUnifyCodec ? this.mUnifiedCodec : this.mMediaCodec) + ", exception = " + e);
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public int start() {
        AVLogger.Info(TAG, this, "start");
        try {
            if (this.mEnableUnifyCodec) {
                this.mUnifiedCodec.start();
            } else {
                this.mMediaCodec.start();
            }
            if (this.mMcMode == 0) {
                if (this.mEnableUnifyCodec) {
                    this.mInputBuffers = this.mUnifiedCodec.getInputBuffers();
                } else {
                    this.mInputBuffers = this.mMediaCodec.getInputBuffers();
                }
                if (Util.SDK_INT >= 21) {
                    UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                    this.mOutputBuffers = unifiedMediaCodec != null ? unifiedMediaCodec.getOutputBuffers() : this.mMediaCodec.getOutputBuffers();
                }
            } else {
                this.mInputBuffers = null;
                this.mOutputBuffers = null;
            }
            this.mInputBuffersValid = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            AVLogger.Info(TAG, this, "start end");
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "start failed, exception = " + e);
            handleCodecException(e);
            return -1;
        }
    }

    public int stop() {
        if (this.mHandleStopAsync == 1) {
            AVLogger.Info(TAG, this, "stop async");
            this.mInputBuffersValid = false;
            this.mStopAsync = true;
            return 0;
        }
        if (this.mInputBuffersValid) {
            AVLogger.Info(TAG, this, "stop");
            try {
                this.mInputBuffersValid = false;
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    unifiedMediaCodec.stop();
                } else {
                    this.mMediaCodec.stop();
                }
            } catch (Exception e) {
                AVLogger.Error(TAG, this, "stop failed, exception = " + e);
                handleCodecException(e);
                return -1;
            }
        }
        return 0;
    }

    private void stopCodec(final MediaCodec codec) {
        if (codec == null) {
            return;
        }
        try {
            codec.stop();
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "stop failed, exception = " + e);
        }
        AVLogger.Info(TAG, this, "codec stop end");
    }

    private void stopCodec(final UnifiedMediaCodec codec) {
        if (codec == null) {
            return;
        }
        try {
            codec.stop();
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "stop failed, exception = " + e);
        }
        AVLogger.Info(TAG, this, "codec stop end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(final MediaCodec codec) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        if (codec == null) {
            return;
        }
        try {
            try {
                codec.release();
                if (this.mDummySurface != null) {
                    AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "release failed, exception = " + e);
                if (this.mDummySurface != null) {
                    AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
                if (this.mEnableSingleCodec == 1) {
                    try {
                        reentrantLock = mSingleCodecLock;
                        reentrantLock.lock();
                        mCodecInstanceNums--;
                        mSingleCodecCond.signal();
                    } catch (Exception unused) {
                        reentrantLock = mSingleCodecLock;
                    } catch (Throwable th) {
                        mSingleCodecLock.unlock();
                        throw th;
                    }
                }
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused2) {
                    reentrantLock = mSingleCodecLock;
                } catch (Throwable th2) {
                    mSingleCodecLock.unlock();
                    throw th2;
                }
                reentrantLock.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info(TAG, this, "codec release end");
        } catch (Throwable th3) {
            if (this.mDummySurface != null) {
                AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock2 = mSingleCodecLock;
                    reentrantLock2.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused3) {
                    reentrantLock2 = mSingleCodecLock;
                } catch (Throwable th4) {
                    mSingleCodecLock.unlock();
                    throw th4;
                }
                reentrantLock2.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info(TAG, this, "codec release end");
            throw th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodec(final UnifiedMediaCodec codec) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        if (codec == null) {
            return;
        }
        try {
            try {
                codec.release();
                if (this.mDummySurface != null) {
                    AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "release failed, exception = " + e);
                if (this.mDummySurface != null) {
                    AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                    this.mDummySurface.release();
                    this.mDummySurface = null;
                }
                if (this.mEnableSingleCodec == 1) {
                    try {
                        reentrantLock = mSingleCodecLock;
                        reentrantLock.lock();
                        mCodecInstanceNums--;
                        mSingleCodecCond.signal();
                    } catch (Exception unused) {
                        reentrantLock = mSingleCodecLock;
                    } catch (Throwable th) {
                        mSingleCodecLock.unlock();
                        throw th;
                    }
                }
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock = mSingleCodecLock;
                    reentrantLock.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused2) {
                    reentrantLock = mSingleCodecLock;
                } catch (Throwable th2) {
                    mSingleCodecLock.unlock();
                    throw th2;
                }
                reentrantLock.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info(TAG, this, "codec release end");
        } catch (Throwable th3) {
            if (this.mDummySurface != null) {
                AVLogger.Info(TAG, this, "release dummy surface:" + this.mDummySurface);
                this.mDummySurface.release();
                this.mDummySurface = null;
            }
            if (this.mEnableSingleCodec == 1) {
                try {
                    reentrantLock2 = mSingleCodecLock;
                    reentrantLock2.lock();
                    mCodecInstanceNums--;
                    mSingleCodecCond.signal();
                } catch (Exception unused3) {
                    reentrantLock2 = mSingleCodecLock;
                } catch (Throwable th4) {
                    mSingleCodecLock.unlock();
                    throw th4;
                }
                reentrantLock2.unlock();
            }
            releaseBlockHashMap();
            AVLogger.Info(TAG, this, "codec release end");
            throw th3;
        }
    }

    private void releaseBlockHashMap() {
        ConcurrentHashMap<Integer, MediaCodec.LinearBlock> concurrentHashMap = this.mBlockHashMap;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<Integer, MediaCodec.LinearBlock> entry : this.mBlockHashMap.entrySet()) {
            if (Build.VERSION.SDK_INT >= 30) {
                entry.getValue().recycle();
            }
        }
        this.mBlockHashMap.clear();
    }

    public void close() {
        HandlerThread handlerThread;
        HandlerThread handlerThread2;
        AVLogger.Info(TAG, this, "~JAJMediaCodec#{");
        final UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
        if (unifiedMediaCodec != null) {
            if (this.mHandleStopAsync == 0) {
                stop();
            } else if (this.mStopAsync) {
                stopCodec(unifiedMediaCodec);
                this.mStopAsync = false;
            }
            this.mInputBuffers = null;
            this.mOutputBuffers = null;
            if (this.mMcMode == 1 && Util.SDK_INT >= 23) {
                synchronized (mAsyncLock) {
                    HandlerThread handlerThread3 = this.mAsyncThread;
                    if (handlerThread3 != null) {
                        handlerThread3.quit();
                    }
                    _clearBufferIndex(this.mHandler);
                    this.mCodecIsClosed = true;
                    this.mUnifiedCodec = null;
                }
            } else if (this.mMcMode == 2) {
                if (Util.SDK_INT >= 23 && (handlerThread2 = this.mAsyncThread) != null) {
                    handlerThread2.quit();
                }
                this.mCodecIsClosed = true;
                this.mUnifiedCodec = null;
                try {
                    AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.3
                        @Override // java.lang.Runnable
                        public void run() {
                            synchronized (AJMediaCodec.this.mAsyncLock2) {
                                AVLogger.Debug(AJMediaCodec.TAG, this, "onClosed");
                                AJMediaCodec._onClosed2(AJMediaCodec.this.mHandler);
                            }
                        }
                    });
                } catch (Throwable unused) {
                    AVLogger.Warn(TAG, this, "onClosed in current thread");
                    synchronized (this.mAsyncLock2) {
                        _onClosed2(this.mHandler);
                    }
                }
            } else {
                this.mUnifiedCodec = null;
            }
            if (mEnableMediaCodecSyncClose > 0) {
                AVLogger.Info(TAG, this, "sync releaseCodec");
                releaseCodec(unifiedMediaCodec);
            } else {
                Runnable runnable = new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AVLogger.Info(AJMediaCodec.TAG, this, "start releaseCodec task");
                        AJMediaCodec.this.releaseCodec(unifiedMediaCodec);
                    }
                };
                try {
                    AVThreadPool.addTask(runnable);
                } catch (Throwable unused2) {
                    AVLogger.Warn(TAG, this, "new thread failed");
                    runnable.run();
                }
            }
        } else {
            final MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec != null) {
                if (this.mHandleStopAsync == 0) {
                    stop();
                } else if (this.mStopAsync) {
                    stopCodec(mediaCodec);
                    this.mStopAsync = false;
                }
                this.mInputBuffers = null;
                this.mOutputBuffers = null;
                if (this.mMcMode == 1 && Util.SDK_INT >= 23) {
                    synchronized (mAsyncLock) {
                        HandlerThread handlerThread4 = this.mAsyncThread;
                        if (handlerThread4 != null) {
                            handlerThread4.quit();
                        }
                        _clearBufferIndex(this.mHandler);
                        this.mCodecIsClosed = true;
                        this.mMediaCodec = null;
                    }
                } else if (this.mMcMode == 2) {
                    if (Util.SDK_INT >= 23 && (handlerThread = this.mAsyncThread) != null) {
                        handlerThread.quit();
                    }
                    this.mCodecIsClosed = true;
                    this.mMediaCodec = null;
                    try {
                        AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.5
                            @Override // java.lang.Runnable
                            public void run() {
                                synchronized (AJMediaCodec.this.mAsyncLock2) {
                                    AVLogger.Debug(AJMediaCodec.TAG, this, "onClosed");
                                    AJMediaCodec._onClosed2(AJMediaCodec.this.mHandler);
                                }
                            }
                        });
                    } catch (Throwable unused3) {
                        AVLogger.Warn(TAG, this, "onClosed in current thread");
                        synchronized (this.mAsyncLock2) {
                            _onClosed2(this.mHandler);
                        }
                    }
                } else {
                    this.mMediaCodec = null;
                }
                if (mEnableMediaCodecSyncClose > 0) {
                    AVLogger.Info(TAG, this, "sync releaseCodec");
                    releaseCodec(mediaCodec);
                } else {
                    Runnable runnable2 = new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.6
                        @Override // java.lang.Runnable
                        public void run() {
                            AVLogger.Info(AJMediaCodec.TAG, this, "start releaseCodec task");
                            AJMediaCodec.this.releaseCodec(mediaCodec);
                        }
                    };
                    try {
                        AVThreadPool.addTask(runnable2);
                    } catch (Throwable unused4) {
                        AVLogger.Warn(TAG, this, "new thread failed");
                        runnable2.run();
                    }
                }
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "~JAJMediaCodec#}");
    }

    private int renderOutputBufferV21(int idx, long relaseNanoTime) {
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                unifiedMediaCodec.releaseOutputBuffer(idx, relaseNanoTime);
                return 0;
            }
            this.mMediaCodec.releaseOutputBuffer(idx, relaseNanoTime);
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "releaseOutputBufferV21 failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    public int handleCodecExceptionV21(Exception e) {
        if (e instanceof MediaCodec.CodecException) {
            MediaCodec.CodecException codecException = (MediaCodec.CodecException) e;
            if (Util.SDK_INT >= 23) {
                AVLogger.Debug(TAG, this, "exception codecExc isRecoverable: " + codecException.isRecoverable() + ", errorcode: " + codecException.getErrorCode());
                if (!codecException.isRecoverable() && codecException.getErrorCode() != 1100 && codecException.getErrorCode() != 1101) {
                    return CODEC_EXCEPTION_ERROR;
                }
            } else {
                AVLogger.Debug(TAG, this, "exception codecExc isRecoverable: " + codecException.isRecoverable());
                if (!codecException.isRecoverable()) {
                    return CODEC_EXCEPTION_ERROR;
                }
            }
        }
        return e instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int handleCodecException(Exception e) {
        this.mExceptionInfo = e.toString();
        if (Util.SDK_INT >= 21) {
            return handleCodecExceptionV21(e);
        }
        return e instanceof IllegalStateException ? CODEC_ILLEGAL_STATE : CODEC_ERROR;
    }

    public int dequeueInputBuffer(long timeoutUs) {
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                return unifiedMediaCodec.dequeueInputBuffer(timeoutUs);
            }
            return this.mMediaCodec.dequeueInputBuffer(timeoutUs);
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "dequeueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mInputBuffers;
        }
        return null;
    }

    public ByteBuffer[] getOutputBuffers() {
        if (this.mInputBuffersValid) {
            return this.mOutputBuffers;
        }
        return null;
    }

    public ByteBuffer getInputBufferByQueueRequest(int index) {
        if (Build.VERSION.SDK_INT < 30) {
            return null;
        }
        if (this.mBlockHashMap.get(Integer.valueOf(index)) != null && this.mBlockHashMap.get(Integer.valueOf(index)).isMappable()) {
            return this.mBlockHashMap.get(Integer.valueOf(index)).map();
        }
        String[] strArr = new String[1];
        UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
        strArr[0] = unifiedMediaCodec != null ? unifiedMediaCodec.getName() : this.mMediaCodec.getName();
        MediaCodec.LinearBlock obtain = MediaCodec.LinearBlock.obtain(1048576, strArr);
        this.mBlockHashMap.put(Integer.valueOf(index), obtain);
        return obtain.map();
    }

    public ByteBuffer getInputBuffer(int index) {
        if (this.mInputBuffersValid) {
            try {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    return unifiedMediaCodec.getInputBuffer(index);
                }
                return this.mMediaCodec.getInputBuffer(index);
            } catch (Exception e) {
                AVLogger.Error(TAG, this, "getInputBuffer failed, exception = " + e);
            }
        }
        return null;
    }

    public int queueInputBuffer(int idx, int offset, int size, long presentationTimeUs, int flags) {
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                unifiedMediaCodec.queueInputBuffer(idx, offset, size, presentationTimeUs, flags);
                return 0;
            }
            this.mMediaCodec.queueInputBuffer(idx, offset, size, presentationTimeUs, flags);
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "queueInputBuffer failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    public int queueInputBufferByQueueRequest(int idx, int offset, int size, long presentationTimeUs, int flags) {
        MediaCodec.LinearBlock linearBlock;
        try {
            if (Build.VERSION.SDK_INT >= 30) {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                MediaCodec.QueueRequest queueRequest = unifiedMediaCodec != null ? unifiedMediaCodec.getQueueRequest(idx) : this.mMediaCodec.getQueueRequest(idx);
                ConcurrentHashMap<Integer, MediaCodec.LinearBlock> concurrentHashMap = this.mBlockHashMap;
                if (concurrentHashMap != null && (linearBlock = concurrentHashMap.get(Integer.valueOf(idx))) != null) {
                    queueRequest.setLinearBlock(linearBlock, 0, size);
                }
                queueRequest.setFlags(flags);
                queueRequest.setPresentationTimeUs(presentationTimeUs);
                queueRequest.queue();
            }
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "queueInputBuffer failed, exception: " + e);
            return handleCodecException(e);
        }
    }

    public int getOutputFrameByQueueRequest(int idx, int flags, int offset, int size, RenderTrait trait, int packDataSpace, long nativeTraitHandle) {
        HardwareBuffer hardwareBuffer;
        int i;
        if (Build.VERSION.SDK_INT < 30 || (trait == null && nativeTraitHandle == 0)) {
            hardwareBuffer = null;
        } else {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            hardwareBuffer = (unifiedMediaCodec != null ? unifiedMediaCodec.getOutputFrame(idx) : this.mMediaCodec.getOutputFrame(idx)).getHardwareBuffer();
        }
        if (hardwareBuffer != null) {
            android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
            int i2 = -1;
            int integer = mediaFormat != null ? mediaFormat.getInteger("color-standard") : -1;
            if (packDataSpace == 1) {
                android.media.MediaFormat mediaFormat2 = this.mOutputMediaFormat;
                if (mediaFormat2 != null) {
                    i2 = mediaFormat2.getInteger("color-range");
                    i = this.mOutputMediaFormat.getInteger("color-transfer");
                } else {
                    i = -1;
                }
                if (integer > 0 && i2 > 0 && i > 0) {
                    integer = (integer << 16) | (i << 22) | (i2 << 27);
                }
            }
            AJCodecHardwareBuffer aJCodecHardwareBuffer = new AJCodecHardwareBuffer(hardwareBuffer, new int[]{0, 0, this.mAJMediaFormat.width, this.mAJMediaFormat.height}, 0, integer);
            if (trait != null) {
                trait.onDrawFrame(aJCodecHardwareBuffer);
            } else {
                _onDrawFrame(nativeTraitHandle, aJCodecHardwareBuffer.hardwareBuffer, aJCodecHardwareBuffer.roi, aJCodecHardwareBuffer.rotation, aJCodecHardwareBuffer.colorSpace);
            }
        }
        return 0;
    }

    public int setOutputSurface(Surface surface) {
        AVLogger.Info(TAG, this, "setOutputSurface surface = " + surface);
        if (mDeviceNeedsSetOutputSurfaceWorkaround || !this.mInputBuffersValid) {
            return -1;
        }
        if (surface == null) {
            if (this.mDummySurface == null) {
                createDummySurface(false);
            }
            AVLogger.Info(TAG, this, "use dummy surface = " + this.mDummySurface);
            surface = this.mDummySurface;
        }
        if (Util.SDK_INT < 23) {
            return -1;
        }
        return setOutputSurfaceV23(this.mMediaCodec, surface);
    }

    public int write(AJMediaCodecFrame buffer) {
        int dequeueInputBuffer;
        if (buffer == null || buffer.data == null) {
            AVLogger.Debug(TAG, this, "buffer is nullpoint");
            return -1;
        }
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                dequeueInputBuffer = unifiedMediaCodec.dequeueInputBuffer(INPUT_TIMEOUT_US);
            } else {
                dequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(INPUT_TIMEOUT_US);
            }
            int i = dequeueInputBuffer;
            if (i < 0) {
                return i == -1 ? 4 : -1;
            }
            this.mInputBuffers[i].put(buffer.data);
            UnifiedMediaCodec unifiedMediaCodec2 = this.mUnifiedCodec;
            if (unifiedMediaCodec2 != null) {
                unifiedMediaCodec2.queueInputBuffer(i, 0, buffer.size, buffer.pts, 0);
                return 0;
            }
            this.mMediaCodec.queueInputBuffer(i, 0, buffer.size, buffer.pts, 0);
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "write meet exception =" + e);
            return -1;
        }
    }

    public int read(AJMediaCodecFrame frame, long timeoutUs) {
        int dequeueOutputBuffer;
        UnifiedMediaCodec unifiedMediaCodec;
        do {
            try {
                UnifiedMediaCodec unifiedMediaCodec2 = this.mUnifiedCodec;
                if (unifiedMediaCodec2 != null) {
                    dequeueOutputBuffer = unifiedMediaCodec2.dequeueOutputBuffer(this.mBufferInfo, timeoutUs);
                } else {
                    dequeueOutputBuffer = this.mMediaCodec.dequeueOutputBuffer(this.mBufferInfo, timeoutUs);
                }
                if (dequeueOutputBuffer >= 0) {
                    if (this.mOutputMediaFormat == null && (unifiedMediaCodec = this.mUnifiedCodec) != null) {
                        this.mOutputMediaFormat = unifiedMediaCodec.getOutputFormat();
                    }
                    frame.data = this.mOutputBuffers[dequeueOutputBuffer];
                    frame.pts = this.mBufferInfo.presentationTimeUs;
                    frame.index = dequeueOutputBuffer;
                    frame.size = this.mBufferInfo.size;
                    frame.flags = this.mBufferInfo.flags;
                    return 0;
                }
                if (dequeueOutputBuffer != -3) {
                    if (dequeueOutputBuffer != -2) {
                        if (dequeueOutputBuffer != -1) {
                            AVLogger.Error(TAG, this, "error, idx = " + dequeueOutputBuffer);
                        }
                        return -1;
                    }
                    AVLogger.Debug(TAG, this, "INFO_OUTPUT_FORMAT_CHANGED");
                    try {
                        if (this.mEnableSetVideoScalingMode > 0) {
                            UnifiedMediaCodec unifiedMediaCodec3 = this.mUnifiedCodec;
                            if (unifiedMediaCodec3 != null) {
                                unifiedMediaCodec3.setVideoScalingMode(2);
                            } else {
                                this.mMediaCodec.setVideoScalingMode(2);
                            }
                        }
                        UnifiedMediaCodec unifiedMediaCodec4 = this.mUnifiedCodec;
                        if (unifiedMediaCodec4 != null) {
                            this.mOutputMediaFormat = unifiedMediaCodec4.getOutputFormat();
                        } else {
                            this.mOutputMediaFormat = this.mMediaCodec.getOutputFormat();
                        }
                        AVLogger.Info(TAG, this, "getOutputFormat = " + this.mOutputMediaFormat);
                        if (this.mOutputBuffers == null) {
                            try {
                                UnifiedMediaCodec unifiedMediaCodec5 = this.mUnifiedCodec;
                                if (unifiedMediaCodec5 != null) {
                                    this.mOutputBuffers = unifiedMediaCodec5.getOutputBuffers();
                                } else {
                                    this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                                }
                            } catch (Exception e) {
                                AVLogger.Error(TAG, this, "getOutputBuffers failed, exception = " + e);
                                return handleCodecException(e);
                            }
                        }
                        return dequeueOutputBuffer;
                    } catch (Exception e2) {
                        AVLogger.Error(TAG, this, "getOutputFormat failed, exception =" + e2);
                        return handleCodecException(e2);
                    }
                }
                AVLogger.Debug(TAG, this, "INFO_OUTPUT_BUFFERS_CHANGED");
                try {
                    if (this.mEnableSetVideoScalingMode > 0) {
                        UnifiedMediaCodec unifiedMediaCodec6 = this.mUnifiedCodec;
                        if (unifiedMediaCodec6 != null) {
                            unifiedMediaCodec6.setVideoScalingMode(2);
                        } else {
                            this.mMediaCodec.setVideoScalingMode(2);
                        }
                    }
                    UnifiedMediaCodec unifiedMediaCodec7 = this.mUnifiedCodec;
                    if (unifiedMediaCodec7 != null) {
                        this.mOutputBuffers = unifiedMediaCodec7.getOutputBuffers();
                    } else {
                        this.mOutputBuffers = this.mMediaCodec.getOutputBuffers();
                    }
                } catch (Exception e3) {
                    AVLogger.Error(TAG, this, "getOutputBuffers failed, exception = " + e3);
                    return handleCodecException(e3);
                }
            } catch (Exception e4) {
                AVLogger.Error(TAG, this, "dequeueOutputBuffer failed, exception = " + e4);
                return handleCodecException(e4);
            }
        } while (this.mHandleOutputBuffersChanged != 1);
        return -3;
    }

    public int flush() {
        AVLogger.Info(TAG, this, "flush");
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                unifiedMediaCodec.flush();
            } else {
                this.mMediaCodec.flush();
            }
            releaseBlockHashMap();
            int i = this.mMcMode;
            if (i == 1) {
                synchronized (mAsyncLock) {
                    this.mPendingFlushCount++;
                    this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.7
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (AJMediaCodec.this.mMediaCodec == null && AJMediaCodec.this.mUnifiedCodec == null) {
                                    return;
                                }
                                AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.7.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AJMediaCodec.this.mUnifiedCodec != null) {
                                            AJMediaCodec.this.mUnifiedCodec.start();
                                        } else if (AJMediaCodec.this.mMediaCodec != null) {
                                            AJMediaCodec.this.mMediaCodec.start();
                                        }
                                    }
                                });
                            } catch (Exception unused) {
                            }
                        }
                    });
                }
            } else if (i == 2) {
                this.mPendingFlushCount++;
                this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (AJMediaCodec.this.mUnifiedCodec != null) {
                                AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.8.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AJMediaCodec.this.mUnifiedCodec != null) {
                                            AJMediaCodec.this.mUnifiedCodec.start();
                                        }
                                    }
                                });
                            } else if (AJMediaCodec.this.mMediaCodec != null) {
                                AJMediaCodec.this.onFlushCompleted(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (AJMediaCodec.this.mMediaCodec != null) {
                                            AJMediaCodec.this.mMediaCodec.start();
                                        }
                                    }
                                });
                            }
                        } catch (Exception e) {
                            AVLogger.Error(AJMediaCodec.TAG, this, e.toString());
                        }
                    }
                });
            }
            AVLogger.Info(TAG, this, "flush done");
            return 0;
        } catch (Exception unused) {
            return -1;
        }
    }

    public int releaseBuffer(int idx, boolean render, long releaseNanoTime, boolean needCrop) {
        if (render && this.mEnableSetVideoScalingMode > 0) {
            if (needCrop) {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    unifiedMediaCodec.setVideoScalingMode(2);
                } else {
                    this.mMediaCodec.setVideoScalingMode(2);
                }
            } else {
                UnifiedMediaCodec unifiedMediaCodec2 = this.mUnifiedCodec;
                if (unifiedMediaCodec2 != null) {
                    unifiedMediaCodec2.setVideoScalingMode(1);
                } else {
                    this.mMediaCodec.setVideoScalingMode(1);
                }
            }
        }
        if (Util.SDK_INT >= 21 && render) {
            return renderOutputBufferV21(idx, releaseNanoTime);
        }
        try {
            UnifiedMediaCodec unifiedMediaCodec3 = this.mUnifiedCodec;
            if (unifiedMediaCodec3 != null) {
                unifiedMediaCodec3.releaseOutputBuffer(idx, render);
                return 0;
            }
            this.mMediaCodec.releaseOutputBuffer(idx, render);
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "releaseOutputBuffer failed, exception = " + e);
            return handleCodecException(e);
        }
    }

    public int getFormatWidth() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_RIGHT) - this.mOutputMediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("width");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getFormatHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                if (mediaFormat.containsKey(KEY_CROP_RIGHT) && this.mOutputMediaFormat.containsKey(KEY_CROP_LEFT) && this.mOutputMediaFormat.containsKey(KEY_CROP_BOTTOM) && this.mOutputMediaFormat.containsKey(KEY_CROP_TOP)) {
                    return (this.mOutputMediaFormat.getInteger(KEY_CROP_BOTTOM) - this.mOutputMediaFormat.getInteger(KEY_CROP_TOP)) + 1;
                }
                return this.mOutputMediaFormat.getInteger("height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getStride() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("stride");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSliceHeight() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger("slice-height");
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getSampleRate() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_SAMPLE_RATE);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getChannelCount() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                return mediaFormat.getInteger(MediaFormat.KEY_CHANNEL_COUNT);
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorFormat() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-format");
                return (integer == 21 || integer == 2130706688 || integer == 2141391872) ? 3 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorTransfer() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-transfer");
                if (integer != 6) {
                    return integer != 7 ? 0 : 18;
                }
                return 16;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getOSVerion() {
        return Util.SDK_INT;
    }

    public int getColorStandard() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-standard");
                if (integer != 1) {
                    return integer != 6 ? 0 : 9;
                }
                return 1;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public int getColorRange() {
        android.media.MediaFormat mediaFormat = this.mOutputMediaFormat;
        if (mediaFormat != null) {
            try {
                int integer = mediaFormat.getInteger("color-range");
                if (integer != 1) {
                    return integer != 2 ? 0 : 1;
                }
                return 2;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void speedEnhance(float rate) {
        if (!(this.mMediaCodec == null && this.mUnifiedCodec == null) && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            if (rate > 30.0f || (this.mMCOperatingRateMode == 1 && rate >= 0.0f)) {
                AVLogger.Debug(TAG, this, "rate " + rate);
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", rate);
                try {
                    UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                    if (unifiedMediaCodec != null) {
                        unifiedMediaCodec.setParameters(bundle);
                    } else {
                        this.mMediaCodec.setParameters(bundle);
                    }
                } catch (Exception e) {
                    AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
                }
            }
        }
    }

    public void hisiFrenquenceChange(int value) {
        if (!(this.mMediaCodec == null && this.mUnifiedCodec == null) && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            AVLogger.Debug(TAG, this, "hisiFrenquence value " + value);
            Bundle bundle = new Bundle();
            bundle.putInt("vendor.hisi-ext-frequence-request-video-dec.video-scene-for-frequence-req", value);
            try {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    unifiedMediaCodec.setParameters(bundle);
                } else {
                    this.mMediaCodec.setParameters(bundle);
                }
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
            }
        }
    }

    public void importanceChange(int value) {
        if (!(this.mMediaCodec == null && this.mUnifiedCodec == null) && this.mInputBuffersValid && Util.SDK_INT >= 35) {
            AVLogger.Debug(TAG, this, "importance value " + value);
            Bundle bundle = new Bundle();
            bundle.putInt("importance", value);
            try {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    unifiedMediaCodec.setParameters(bundle);
                } else {
                    this.mMediaCodec.setParameters(bundle);
                }
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
            }
        }
    }

    public void decodeFRC(int level) {
        if (!(this.mMediaCodec == null && this.mUnifiedCodec == null) && this.mInputBuffersValid && Util.SDK_INT >= 23) {
            AVLogger.Debug(TAG, this, "frc level = " + level);
            Bundle bundle = new Bundle();
            bundle.putInt("vivo.video-dec.dynamic-frc", level);
            try {
                UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
                if (unifiedMediaCodec != null) {
                    unifiedMediaCodec.setParameters(bundle);
                } else {
                    this.mMediaCodec.setParameters(bundle);
                }
            } catch (Exception e) {
                AVLogger.Warn(TAG, this, "setParameters failed ret = " + e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:214:0x032e, code lost:
    
        if (r10 != false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0308, code lost:
    
        if (r9.startsWith("omx") != false) goto L176;
     */
    /* JADX WARN: Removed duplicated region for block: B:167:0x03c8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ac A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x036e A[Catch: all -> 0x0400, TryCatch #0 {, blocks: (B:21:0x0077, B:23:0x0080, B:25:0x0084, B:28:0x008d, B:30:0x0097, B:32:0x009b, B:35:0x00a4, B:37:0x00ac, B:40:0x00b5, B:42:0x00bb, B:45:0x00c4, B:47:0x00cc, B:50:0x00d4, B:52:0x00db, B:55:0x0269, B:56:0x0107, B:58:0x010f, B:61:0x0118, B:63:0x0120, B:65:0x0129, B:68:0x013c, B:71:0x0143, B:73:0x0147, B:77:0x0261, B:78:0x0153, B:80:0x0159, B:82:0x0162, B:84:0x016b, B:86:0x016f, B:87:0x0175, B:88:0x017a, B:90:0x0180, B:92:0x0188, B:94:0x0190, B:95:0x0195, B:98:0x019c, B:100:0x01be, B:103:0x01c6, B:105:0x01ce, B:107:0x01d6, B:109:0x01de, B:111:0x01e6, B:115:0x01f1, B:117:0x01f9, B:121:0x0200, B:125:0x0207, B:129:0x0210, B:131:0x0240, B:133:0x0246, B:135:0x024f, B:137:0x0255, B:139:0x025e, B:146:0x012e, B:148:0x0137, B:152:0x0271, B:154:0x0277, B:156:0x027a, B:157:0x02ac, B:159:0x02b2, B:161:0x02bc, B:165:0x03c2, B:175:0x02ca, B:178:0x02d0, B:180:0x02e4, B:184:0x02f0, B:188:0x030b, B:194:0x0331, B:201:0x0368, B:203:0x036e, B:204:0x03a4, B:206:0x0316, B:211:0x0323, B:215:0x02f9, B:219:0x0302, B:226:0x03cd, B:227:0x03ed, B:228:0x03fb, B:230:0x03fd), top: B:20:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0302 A[Catch: all -> 0x0400, TryCatch #0 {, blocks: (B:21:0x0077, B:23:0x0080, B:25:0x0084, B:28:0x008d, B:30:0x0097, B:32:0x009b, B:35:0x00a4, B:37:0x00ac, B:40:0x00b5, B:42:0x00bb, B:45:0x00c4, B:47:0x00cc, B:50:0x00d4, B:52:0x00db, B:55:0x0269, B:56:0x0107, B:58:0x010f, B:61:0x0118, B:63:0x0120, B:65:0x0129, B:68:0x013c, B:71:0x0143, B:73:0x0147, B:77:0x0261, B:78:0x0153, B:80:0x0159, B:82:0x0162, B:84:0x016b, B:86:0x016f, B:87:0x0175, B:88:0x017a, B:90:0x0180, B:92:0x0188, B:94:0x0190, B:95:0x0195, B:98:0x019c, B:100:0x01be, B:103:0x01c6, B:105:0x01ce, B:107:0x01d6, B:109:0x01de, B:111:0x01e6, B:115:0x01f1, B:117:0x01f9, B:121:0x0200, B:125:0x0207, B:129:0x0210, B:131:0x0240, B:133:0x0246, B:135:0x024f, B:137:0x0255, B:139:0x025e, B:146:0x012e, B:148:0x0137, B:152:0x0271, B:154:0x0277, B:156:0x027a, B:157:0x02ac, B:159:0x02b2, B:161:0x02bc, B:165:0x03c2, B:175:0x02ca, B:178:0x02d0, B:180:0x02e4, B:184:0x02f0, B:188:0x030b, B:194:0x0331, B:201:0x0368, B:203:0x036e, B:204:0x03a4, B:206:0x0316, B:211:0x0323, B:215:0x02f9, B:219:0x0302, B:226:0x03cd, B:227:0x03ed, B:228:0x03fb, B:230:0x03fd), top: B:20:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0143 A[Catch: all -> 0x0400, TryCatch #0 {, blocks: (B:21:0x0077, B:23:0x0080, B:25:0x0084, B:28:0x008d, B:30:0x0097, B:32:0x009b, B:35:0x00a4, B:37:0x00ac, B:40:0x00b5, B:42:0x00bb, B:45:0x00c4, B:47:0x00cc, B:50:0x00d4, B:52:0x00db, B:55:0x0269, B:56:0x0107, B:58:0x010f, B:61:0x0118, B:63:0x0120, B:65:0x0129, B:68:0x013c, B:71:0x0143, B:73:0x0147, B:77:0x0261, B:78:0x0153, B:80:0x0159, B:82:0x0162, B:84:0x016b, B:86:0x016f, B:87:0x0175, B:88:0x017a, B:90:0x0180, B:92:0x0188, B:94:0x0190, B:95:0x0195, B:98:0x019c, B:100:0x01be, B:103:0x01c6, B:105:0x01ce, B:107:0x01d6, B:109:0x01de, B:111:0x01e6, B:115:0x01f1, B:117:0x01f9, B:121:0x0200, B:125:0x0207, B:129:0x0210, B:131:0x0240, B:133:0x0246, B:135:0x024f, B:137:0x0255, B:139:0x025e, B:146:0x012e, B:148:0x0137, B:152:0x0271, B:154:0x0277, B:156:0x027a, B:157:0x02ac, B:159:0x02b2, B:161:0x02bc, B:165:0x03c2, B:175:0x02ca, B:178:0x02d0, B:180:0x02e4, B:184:0x02f0, B:188:0x030b, B:194:0x0331, B:201:0x0368, B:203:0x036e, B:204:0x03a4, B:206:0x0316, B:211:0x0323, B:215:0x02f9, B:219:0x0302, B:226:0x03cd, B:227:0x03ed, B:228:0x03fb, B:230:0x03fd), top: B:20:0x0077 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getBestCodecName(String codecType) {
        ArrayList<MediaCodecInfo> arrayList;
        boolean z;
        int i;
        String[] supportedTypes;
        ArrayList<MediaCodecInfo> arrayList2;
        AJMediaCodecRank aJMediaCodecRank;
        if (Util.SDK_INT < 16) {
            AVLogger.Error(TAG, this, "API < 16");
            return null;
        }
        if (TextUtils.isEmpty(codecType)) {
            AVLogger.Error(TAG, this, "codecType is empty");
            return null;
        }
        if (codecType.equals(MimeTypes.VIDEO_H265) && mIsByteVC1Blocklist && mIsByteVC1BlocklistEnable > 0) {
            AVLogger.Warn(TAG, this, "the device is hw decoder blocklist," + Util.HARDWARE);
            return null;
        }
        AVLogger.Debug(TAG, this, "detect hardware codec by codecType = " + codecType + " downgradeSw = " + this.mDowngradeSw);
        ArrayList arrayList3 = new ArrayList();
        ArrayList<MediaCodecInfo> arrayList4 = new ArrayList<>();
        synchronized (mCodecListLock) {
            if (codecType.startsWith("video/") && this.mDowngradeSw == 0) {
                ArrayList<MediaCodecInfo> arrayList5 = mVideoHWDecoderCodecs;
                if (!arrayList5.isEmpty()) {
                    arrayList4 = arrayList5;
                }
            }
            int i2 = 1;
            if (codecType.startsWith("video/") && this.mDowngradeSw == 1) {
                ArrayList<MediaCodecInfo> arrayList6 = mVideoSWDecoderCodecs;
                if (!arrayList6.isEmpty()) {
                    arrayList4 = arrayList6;
                }
            }
            if (codecType.startsWith("audio/")) {
                ArrayList<MediaCodecInfo> arrayList7 = mAudioSWDecoderCodecs;
                if (!arrayList7.isEmpty()) {
                    arrayList4 = arrayList7;
                }
            }
            if (arrayList4.isEmpty()) {
                arrayList = MediacodecBlockManager.getCodecs(this.mEnableCacheCodecAsync, this.mEnableGetCodecInfosOpt > 0);
            } else {
                arrayList = arrayList4;
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    MediaCodecInfo mediaCodecInfo = arrayList.get(i3);
                    String name = mediaCodecInfo.getName();
                    AVLogger.Debug(TAG, this, "found codec name : " + name);
                    if (!mediaCodecInfo.isEncoder()) {
                        if (!name.startsWith("OMX.google") && !name.startsWith("c2.android")) {
                            if (!codecType.startsWith("audio/")) {
                                if (codecType.startsWith("video/") && this.mDowngradeSw == i2) {
                                }
                                supportedTypes = mediaCodecInfo.getSupportedTypes();
                                if (supportedTypes == null) {
                                    int length = supportedTypes.length;
                                    int i4 = 0;
                                    while (i4 < length) {
                                        String str = supportedTypes[i4];
                                        if (!TextUtils.isEmpty(str)) {
                                            if (arrayList4.isEmpty() && codecType.startsWith("video/") && str.startsWith("video/")) {
                                                if (this.mDowngradeSw == i2) {
                                                    mVideoSWDecoderCodecs.add(mediaCodecInfo);
                                                } else {
                                                    mVideoHWDecoderCodecs.add(mediaCodecInfo);
                                                }
                                            }
                                            if (arrayList4.isEmpty() && codecType.startsWith("audio/") && str.startsWith("audio/")) {
                                                mAudioSWDecoderCodecs.add(mediaCodecInfo);
                                            }
                                            if (str.equalsIgnoreCase(codecType)) {
                                                arrayList2 = arrayList4;
                                                AVLogger.Debug(TAG, this, "codec type : " + str);
                                                if ((name.startsWith("OMX.") || name.startsWith("c2.")) && !name.startsWith("OMX.pv") && !name.startsWith("OMX.ittiam") && !name.contains("ffmpeg") && !name.contains("avcodec") && !name.contains("secure") && ((!name.startsWith("OMX.MTK.") || Util.SDK_INT >= 18) && !codecNeedsFlushWorkaround(name) && (aJMediaCodecRank = AJMediaCodecRank.setupRank(mediaCodecInfo, codecType, this.mEnableUseCodec2)) != null)) {
                                                    AVLogger.Debug(TAG, this, "codec : " + aJMediaCodecRank.mMediaCodecInfo.getName() + ",  rank : " + aJMediaCodecRank.mRank);
                                                    if (aJMediaCodecRank.mRank == 40 && Util.SDK_INT < 21) {
                                                        AVLogger.Warn(TAG, this, "skip vendor mediacodec api impl ambiguous");
                                                    } else if (aJMediaCodecRank.mRank == 20) {
                                                        AVLogger.Warn(TAG, this, "skip vendor software codec");
                                                    } else {
                                                        arrayList3.add(aJMediaCodecRank);
                                                    }
                                                }
                                                i4++;
                                                arrayList4 = arrayList2;
                                                i2 = 1;
                                            }
                                        }
                                        arrayList2 = arrayList4;
                                        i4++;
                                        arrayList4 = arrayList2;
                                        i2 = 1;
                                    }
                                }
                            }
                        }
                        if (codecType.startsWith("video/") && this.mDowngradeSw == 0) {
                        }
                        supportedTypes = mediaCodecInfo.getSupportedTypes();
                        if (supportedTypes == null) {
                        }
                    }
                    i3++;
                    arrayList4 = arrayList4;
                    i2 = 1;
                }
                if (arrayList3.isEmpty()) {
                    return null;
                }
                AJMediaCodecRank aJMediaCodecRank2 = (AJMediaCodecRank) arrayList3.get(0);
                AVLogger.InfoTrackLife(TAG, this, "decoderType:" + this.mDecoderType + ", lowLatencyType:" + this.mLowLatencyType);
                Iterator it = arrayList3.iterator();
                AJMediaCodecRank aJMediaCodecRank3 = null;
                while (it.hasNext()) {
                    AJMediaCodecRank aJMediaCodecRank4 = (AJMediaCodecRank) it.next();
                    int i5 = this.mDecoderType;
                    if (i5 <= 0 && this.mLowLatencyType <= 0) {
                        if (aJMediaCodecRank4.mRank > aJMediaCodecRank2.mRank) {
                            aJMediaCodecRank2 = aJMediaCodecRank4;
                        }
                    }
                    int i6 = -1;
                    int i7 = i5 > 0 ? -1 : 0;
                    if (this.mLowLatencyType <= 0) {
                        i6 = 0;
                    }
                    String lowerCase = aJMediaCodecRank4.mMediaCodecInfo.getName().toLowerCase(Locale.US);
                    if (!lowerCase.endsWith("low_latency") && !lowerCase.endsWith("lowlatency")) {
                        z = false;
                        i = this.mDecoderType;
                        if (i == 1) {
                            if (i == 2 && lowerCase.startsWith("c2")) {
                                i7 = 1;
                            }
                            int i8 = this.mLowLatencyType;
                            if (i8 != 1) {
                                if (i8 == 2) {
                                    if (MediaCodecHelper.decoderSupportsAndroidRLowLatency(aJMediaCodecRank4.mMediaCodecInfo, aJMediaCodecRank4.mCodecType)) {
                                        i6 = 1;
                                    }
                                    AVLogger.InfoTrackLife(TAG, this, "name:" + lowerCase + ", decoderTypeMatch:" + i7 + ", lowLatencyMatch:" + i6);
                                    if (i7 <= 0) {
                                    }
                                    if (aJMediaCodecRank3 != null) {
                                        if (aJMediaCodecRank4.mRank > aJMediaCodecRank3.mRank) {
                                        }
                                        AVLogger.InfoTrackLife(TAG, this, "find specify codec:" + aJMediaCodecRank3.mMediaCodecInfo.getName());
                                    }
                                    aJMediaCodecRank3 = aJMediaCodecRank4;
                                    AVLogger.InfoTrackLife(TAG, this, "find specify codec:" + aJMediaCodecRank3.mMediaCodecInfo.getName());
                                } else {
                                    if (i8 == 3) {
                                        if (!MediaCodecHelper.decoderSupportsAndroidRLowLatency(aJMediaCodecRank4.mMediaCodecInfo, aJMediaCodecRank4.mCodecType)) {
                                            if (z) {
                                            }
                                        }
                                        i6 = 1;
                                    }
                                    AVLogger.InfoTrackLife(TAG, this, "name:" + lowerCase + ", decoderTypeMatch:" + i7 + ", lowLatencyMatch:" + i6);
                                    if (i7 <= 0 || i6 > 0) {
                                        if (aJMediaCodecRank3 != null && (i7 <= 0 || i6 <= 0)) {
                                            if (aJMediaCodecRank4.mRank > aJMediaCodecRank3.mRank) {
                                                AVLogger.InfoTrackLife(TAG, this, "update specify codec name:" + lowerCase + ", rank:" + aJMediaCodecRank4.mRank + ", specify codec:" + aJMediaCodecRank4.mMediaCodecInfo.getName());
                                            }
                                            AVLogger.InfoTrackLife(TAG, this, "find specify codec:" + aJMediaCodecRank3.mMediaCodecInfo.getName());
                                        }
                                        aJMediaCodecRank3 = aJMediaCodecRank4;
                                        AVLogger.InfoTrackLife(TAG, this, "find specify codec:" + aJMediaCodecRank3.mMediaCodecInfo.getName());
                                    }
                                }
                            }
                        }
                        if (aJMediaCodecRank4.mRank > aJMediaCodecRank2.mRank) {
                        }
                    }
                    z = true;
                    i = this.mDecoderType;
                    if (i == 1) {
                    }
                    if (aJMediaCodecRank4.mRank > aJMediaCodecRank2.mRank) {
                    }
                }
                if (aJMediaCodecRank3 != null) {
                    AVLogger.InfoTrackLife(TAG, this, "use specify codec:" + aJMediaCodecRank3.mMediaCodecInfo.getName());
                    aJMediaCodecRank2 = aJMediaCodecRank3;
                }
                this.mCodecInfo = aJMediaCodecRank2.mMediaCodecInfo;
                this.mCodecType = aJMediaCodecRank2.mCodecType;
                return aJMediaCodecRank2.mMediaCodecInfo.getName();
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007f A[Catch: all -> 0x0096, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000e, B:10:0x0018, B:11:0x0090, B:12:0x001c, B:15:0x0022, B:27:0x0064, B:36:0x008e, B:37:0x0075, B:40:0x007f, B:43:0x0062, B:44:0x003b, B:47:0x0046, B:50:0x0050, B:53:0x0092), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean codecNeedsSetOutputSurfaceWorkaround() {
        char c;
        int hashCode;
        synchronized (AJMediaCodec.class) {
            if (!mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                if (Util.SDK_INT <= 27 && "dangal".equals(Util.DEVICE)) {
                    mDeviceNeedsSetOutputSurfaceWorkaround = true;
                } else if (Util.SDK_INT < 27) {
                    String str = Util.DEVICE;
                    int hashCode2 = str.hashCode();
                    boolean z = false;
                    if (hashCode2 == 99329) {
                        if (str.equals("deb")) {
                            c = 0;
                            if (c != 0) {
                            }
                            mDeviceNeedsSetOutputSurfaceWorkaround = true;
                            String str2 = Util.MODEL;
                            hashCode = str2.hashCode();
                            if (hashCode == 2006354) {
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                        String str22 = Util.MODEL;
                        hashCode = str22.hashCode();
                        if (hashCode == 2006354) {
                        }
                    } else if (hashCode2 != 3351335) {
                        if (hashCode2 == 1865889110 && str.equals("santoni")) {
                            c = 2;
                            if (c != 0 || c == 1 || c == 2) {
                                mDeviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                            String str222 = Util.MODEL;
                            hashCode = str222.hashCode();
                            if (hashCode == 2006354) {
                                if (hashCode == 2006367 && str222.equals("AFTN")) {
                                    z = true;
                                    if (z || z) {
                                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                                    }
                                }
                                z = -1;
                                if (z) {
                                }
                                mDeviceNeedsSetOutputSurfaceWorkaround = true;
                            } else {
                                if (str222.equals("AFTA")) {
                                    if (z) {
                                    }
                                    mDeviceNeedsSetOutputSurfaceWorkaround = true;
                                }
                                z = -1;
                                if (z) {
                                }
                                mDeviceNeedsSetOutputSurfaceWorkaround = true;
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                        String str2222 = Util.MODEL;
                        hashCode = str2222.hashCode();
                        if (hashCode == 2006354) {
                        }
                    } else {
                        if (str.equals("mido")) {
                            c = 1;
                            if (c != 0) {
                            }
                            mDeviceNeedsSetOutputSurfaceWorkaround = true;
                            String str22222 = Util.MODEL;
                            hashCode = str22222.hashCode();
                            if (hashCode == 2006354) {
                            }
                        }
                        c = 65535;
                        if (c != 0) {
                        }
                        mDeviceNeedsSetOutputSurfaceWorkaround = true;
                        String str222222 = Util.MODEL;
                        hashCode = str222222.hashCode();
                        if (hashCode == 2006354) {
                        }
                    }
                }
                mEvaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return mDeviceNeedsSetOutputSurfaceWorkaround;
    }

    private int setOutputSurfaceV23(MediaCodec codec, Surface surface) {
        try {
            UnifiedMediaCodec unifiedMediaCodec = this.mUnifiedCodec;
            if (unifiedMediaCodec != null) {
                unifiedMediaCodec.setOutputSurface(surface);
            } else {
                codec.setOutputSurface(surface);
            }
            if (this.mMcMode == 1 && this.mFixedMemcpyCrash == 1) {
                synchronized (mAsyncLock) {
                    this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.9
                        @Override // java.lang.Runnable
                        public void run() {
                            AJMediaCodec.this.onSetSurfaceCompleted();
                        }
                    });
                }
            }
            if (this.mMcMode != 2 || this.mFixedMemcpyCrash != 1) {
                return 0;
            }
            this.mAsyncHandler.post(new Runnable() { // from class: com.ss.ttm.player.AJMediaCodec.10
                @Override // java.lang.Runnable
                public void run() {
                    AJMediaCodec.this.onSetSurfaceCompleted();
                }
            });
            return 0;
        } catch (Exception e) {
            AVLogger.Error(TAG, this, "setOutputSurface failed, exception = " + e);
            handleCodecException(e);
            DummySurface dummySurface = this.mDummySurface;
            if (dummySurface != null) {
                dummySurface.addEvent(surface == dummySurface ? 1 : 2);
            }
            if (e instanceof IllegalArgumentException) {
                return CODEC_ILLEGAL_ARGUMENT;
            }
            return -1;
        }
    }

    public static int ceilDivide(int numerator, int denominator) {
        return ((numerator + denominator) - 1) / denominator;
    }

    private static int getMaxInputSize(String sampleMimeType, int width, int height) {
        int i;
        int i2;
        if (width == -1 || height == -1) {
            return -1;
        }
        if (!sampleMimeType.equals(MimeTypes.VIDEO_H263) && !sampleMimeType.equals(MimeTypes.VIDEO_MP4V)) {
            if (sampleMimeType.equals(MimeTypes.VIDEO_H264)) {
                if ("BRAVIA 4K 2015".equals(Util.MODEL)) {
                    return -1;
                }
                i = ceilDivide(width, 16) * ceilDivide(height, 16) * 16 * 16;
                i2 = 2;
                return (i * 3) / (i2 * 2);
            }
            if (!sampleMimeType.equals(MimeTypes.VIDEO_VP8)) {
                if (!sampleMimeType.equals(MimeTypes.VIDEO_H265) && !sampleMimeType.equals(MimeTypes.VIDEO_VP9)) {
                    return -1;
                }
                i = width * height;
                i2 = 4;
                return (i * 3) / (i2 * 2);
            }
        }
        i = width * height;
        i2 = 2;
        return (i * 3) / (i2 * 2);
    }

    private static boolean codecNeedsFlushWorkaround(String name) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(name) || "OMX.SEC.avc.dec.secure".equals(name))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(name) || "OMX.Exynos.avc.dec.secure".equals(name)));
    }

    public void setEnableVC1BlockList(int enableVC1BlockList) {
        mIsByteVC1BlocklistEnable = enableVC1BlockList;
    }

    public void setEnableMediaCodecSyncClose(int enableMediaCodecSyncClose) {
        mEnableMediaCodecSyncClose = enableMediaCodecSyncClose;
    }

    public void setCreateCodecTimeoutMs(int timeoutMs) {
        this.mCreateCodecTimeoutMs = timeoutMs;
    }

    public void setEnableCacheCodecAsync(int async) {
        this.mEnableCacheCodecAsync = async != 0;
    }

    private int isLowLatencyDecode() {
        MediaCodecInfo mediaCodecInfo;
        String str;
        if (Build.VERSION.SDK_INT >= 30 && (mediaCodecInfo = this.mCodecInfo) != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("low-latency") ? 1 : 0;
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    private boolean isAdaptivePlaybackV19() {
        String str;
        MediaCodecInfo mediaCodecInfo = this.mCodecInfo;
        if (mediaCodecInfo != null && (str = this.mCodecType) != null) {
            try {
                return mediaCodecInfo.getCapabilitiesForType(str).isFeatureSupported("adaptive-playback");
            } catch (Exception unused) {
            }
        }
        return true;
    }

    public int isAdaptivePlayback() {
        int i = this.mSupportAdaptivePlayBack;
        if (i != -1) {
            return i;
        }
        this.mSupportAdaptivePlayBack = isAdaptivePlaybackV19() ? 1 : 0;
        if ("Q7-G1".equals(Build.MODEL) && "kunlun".equals(Build.HARDWARE)) {
            "GK6323V100C".equals(Build.BOARD);
        }
        return this.mSupportAdaptivePlayBack;
    }

    public void setIntOption(int key, int value) {
        switch (key) {
            case 1:
                this.mMCOperatingRateMode = value;
                return;
            case 2:
                this.mMCPriority = value;
                return;
            case 3:
                this.mEnableMCVppLevel = value;
                return;
            case 4:
                this.mMCVppLevel = value;
                return;
            case 5:
                this.mEnableMCVppDebug = value;
                return;
            case 6:
            default:
                return;
            case 7:
                this.mHisiFrequenceValue = value;
                return;
            case 8:
                this.mEnableQcomOrder = value;
                return;
            case 9:
                this.mEnableQcomSliceDelivery = value;
                return;
            case 10:
                this.mEnableQcomTimestampReorder = value;
                return;
            case 11:
                this.mEnableQcomCpuAffinityMask = value;
                return;
            case 12:
                this.mQcomCpuAffinityMaskValue = value;
                return;
            case 13:
                this.mEnableQcomEarlyNotify = value;
                return;
            case 14:
                this.mQcomEarlyNotifyValue = value;
                return;
            case 15:
                this.mEnableLowLatency = value;
                return;
            case 16:
                this.mEnableHisiLowLatency = value;
                return;
            case 17:
                this.mDecoderType = value;
                return;
            case 18:
                this.mLowLatencyType = value;
                return;
            case 19:
                this.mEnableSetVideoScalingMode = value;
                return;
            case 20:
                this.mMCOperatingRateBeforeOpen = value;
                return;
            case 21:
                this.mImportanceValue = value;
                return;
            case 22:
                this.mDisableAllowFrameDrop = value;
                return;
            case 23:
                this.mSpecifyMaxInputSize = value;
                return;
            case 24:
                this.mEnableGetCodecInfosOpt = value;
                return;
        }
    }

    public void setEnableUnifiedCodec(boolean enable, boolean reuse) {
        this.mEnableUnifyCodec = enable;
        this.mUnifyCodecReuse = reuse;
        Log.i(TAG, "EnableUnifyCodec:" + this.mEnableUnifyCodec + ",UnifyCodecReuse:" + this.mUnifyCodecReuse);
    }
}
