package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.lynx.trace.BuildConfig;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.InitConfig;
import com.ss.ttm.utils.OnceConfig;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class TTPlayer {
    private static final String TAG = "TTPlayerJava";
    private static String mAppPath;
    private static String mCachePath;
    private static String mCrashPath;
    private static ILibraryLoader mDebugLibLoader = new DefaultLibraryLoader(true);
    private static boolean mIsIPCPlayer;
    private static boolean mSetLibraryLoader;
    private static int mSupportSampleRateNB;
    private static int[] mSupportSampleRates;
    private static String playerLibName;
    private Context mContext;
    private FrameMetadataListener mFrameMetadataListener;
    private long mHandle;
    private long mId;
    private long mMediaDataSource;
    private IPlayerNotifyer mNotifyer;
    private MediaPlayer.OnScreenshotListener mScreenshotListener;
    private StrategyParamsTransport mStrategyParamsTransport;
    private int mTracker = 0;

    private static final native void _close(long handle);

    private final native long _create(Context context, long configHandle, String appPath);

    private static final native String _getAppPath();

    private static final native int _getCurrentPosition(long handle);

    private static final native long _getDemuxerFactory(int version);

    private static final native double _getDoubleValue(long handle, int key, double dValue);

    private static final native int _getDuration(long handle);

    private static final native float _getFloatValue(long handle, int key, float dValue);

    private static final native int _getIntValue(long handle, int key, int dValue);

    private static final native Object _getJObjectValue(long handle, int key);

    private static final native long _getLongValue(long handle, int key, long dValue);

    private static final native Object[] _getStreamInfo(long handle);

    private static final native String _getStringValue(long handle, int key);

    private static final native String _getSubtitleContent(long handle, int queryTime);

    private static final native int _getVideoHeight(long handle);

    private static final native int _getVideoWidth(long handle);

    private static final native int _isLooping(long handle);

    private static final native int _isPlaying(long handle);

    private static final native void _mouseEvent(long handle, int action, int deltaX, int deltaY);

    private static final native int _pause(long handle);

    private static final native int _preDemux(long handle);

    private static final native int _prepare(long handle);

    private static final native long _prepareMix(long handle, String paramsJson);

    private static final native int _registerNativeMdl(long pointer);

    private static final native void _registerPlayerInfo();

    private static final native void _release(long handle);

    private static final native int _reset(long handle);

    private static final native void _rotateCamera(long handle, float angleX, float angleY);

    private static final native int _seek(long handle, int position);

    private static final native int _seek2(long handle, int position, int flag);

    private static final native void _setABRStrategy(long handle, ABRStrategy abrStrategy);

    private static final native void _setAIBarrageInfo(long handle, MaskInfo barrageInfo);

    private static final native void _setAudioProcessor(long handle, AudioProcessor processor);

    private static final native void _setDataSource(long handle, IMediaDataSource mediaDataSource);

    private static final native void _setDataSource(long handle, String path);

    private static final native void _setDataSourceFd(long handle, int fd);

    private static final native int _setDoubleValue(long handle, int key, double value);

    private static final native int _setFloatValue(long handle, int key, float value);

    private static final native int _setFloatValueArray(long handle, int[] keys, float[] values);

    private static final native void _setGlobalIntForKey(int key, int value);

    private static final native void _setGlobalStringForKey(int key, String value);

    private static final native int _setIntValue(long handle, int key, int value);

    private static final native int _setIntValueArray(long handle, int[] keys, int[] values);

    private static final native void _setLoadControl(long handle, LoadControl loadControl);

    private static final native int _setLongValue(long handle, int key, long value);

    private static final native int _setLongValueArray(long handle, int[] keys, long[] values);

    private static final native void _setLooping(long handle, int looping);

    private static final native void _setMaskInfo(long handle, MaskInfo maskInfo);

    private static final native void _setMediaTransport(long handle, MediaTransport mediaTransport);

    private static final native int _setStringValue(long handle, int key, String value);

    private static final native int _setStringValueArray(long handle, int[] keys, String[] values);

    private static final native void _setSubInfo(long handle, SubInfo subInfo);

    private static final native void _setSupportFormatNB(int supportFormats);

    private static final native void _setSupprotSampleRates(int[] sampleRates, int nb);

    private static final native int _setSurfaceValue(long handle, long surface);

    private static final native void _setTraitObject(long handle, int type, int version, TraitObject traitObject);

    private static final native int _setVideoSurface(long handle, Surface surface);

    private static final native int _setVideoSurfaceTimeout(long handle, Surface surface, int timeoutMs);

    private static final native void _setVolume(long handle, float left, float right);

    private static final native int _setupMediaCodec(long handle);

    private static final native int _start(long handle);

    private static final native void _stop(long handle);

    private static final native void _switchStream(long handle, int bitrate, int streamType);

    private static final native void _takeScreenshot(long handle);

    private static final void checkPlayerModel() {
    }

    static {
        playerLibName = "";
        synchronized (TTPlayer.class) {
            TTPlayerLibLoader.loadLibrary();
            playerLibName = TTPlayerLibLoader.getPlayerLibName();
            try {
                detectAudioFormat();
            } catch (UnsatisfiedLinkError e) {
                String errorInfo = TTPlayerLibLoader.getErrorInfo();
                if (errorInfo != null) {
                    throw new UnsatisfiedLinkError(errorInfo);
                }
                throw e;
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class DefaultLibraryLoader implements ILibraryLoader {
        boolean mLoadLibraryPath;

        public DefaultLibraryLoader(boolean loadLibraryPath) {
            this.mLoadLibraryPath = loadLibraryPath;
        }

        @Override // com.ss.ttm.player.ILibraryLoader
        public boolean onLoadNativeLibs(List<String> list) {
            for (String str : list) {
                try {
                    if (this.mLoadLibraryPath) {
                        System.load(str);
                    } else {
                        System.loadLibrary(str);
                    }
                } catch (Throwable th) {
                    AVLogger.Error(TTPlayer.TAG, this, "load lib failed = " + th.getMessage());
                    return false;
                }
            }
            return true;
        }
    }

    private static void detectAudioFormat() {
        if (mSupportSampleRateNB == 0) {
            int[] iArr = new int[AudioFormats.getDefaultSampleRatesNB()];
            mSupportSampleRates = iArr;
            int maxSupportedSampleRates = AudioFormats.getMaxSupportedSampleRates(iArr);
            mSupportSampleRateNB = maxSupportedSampleRates;
            _setSupprotSampleRates(mSupportSampleRates, maxSupportedSampleRates);
        }
    }

    public final long getHandle() {
        return this.mHandle;
    }

    public static final void setTempFileDir(String path) {
        mAppPath = path;
    }

    public static final String getAppPath() {
        return mAppPath;
    }

    public static final void setCachePath(String path) {
        mCachePath = path;
    }

    public static final String getCachePath() {
        return mCachePath;
    }

    public static final void setCrashPath(String path) {
        mCrashPath = path;
    }

    public static final String getCrashPath() {
        return mCrashPath;
    }

    public static void setIsIPPlayer(boolean isIPCPlayer) {
        mIsIPCPlayer = isIPCPlayer;
    }

    public static final void setGlobalIntOptionForKey(int key, int value) {
        if (key != 40058) {
            _setGlobalIntForKey(key, value);
        } else {
            if (value < 1 || value > 5) {
                return;
            }
            DummySurface.useCaches(true, value, 1);
        }
    }

    public static final void setGlobalStringOptionForKey(int key, String value) {
        _setGlobalStringForKey(key, value);
    }

    public static long getDemuxerFactory(int version) {
        return _getDemuxerFactory(version);
    }

    public static int registerNativeMdl(long pointer) {
        return _registerNativeMdl(pointer);
    }

    public static boolean isIPPlayer() {
        AVLogger.m239d(TAG, "mIsIPCPlayer:" + mIsIPCPlayer);
        return mIsIPCPlayer;
    }

    public static void registerPlayerInfo() {
        _registerPlayerInfo();
    }

    public long getNativePlayer() {
        return this.mHandle;
    }

    public TTPlayer(Context context, long id, OnceConfig config) throws Exception {
        this.mContext = context;
        create(id, config);
    }

    public Context getContext() {
        return this.mContext;
    }

    private void create(long id, InitConfig config) throws Exception {
        this.mNotifyer = null;
        this.mHandle = _create(this.mContext, config.nativeHandle(), mAppPath);
        AVLogger.InfoTrackLife(TAG, this, String.format(Locale.US, "create TTPlayer:%x", Long.valueOf(this.mHandle)));
        this.mId = id;
        if (this.mHandle == 0) {
            throw new Exception("create native player is fail.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int prepare() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _prepare(j);
    }

    public int close() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        _close(j);
        return 0;
    }

    public int prevClose() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        _setVideoSurface(j, null);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int start() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _start(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int pause() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _pause(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int preDemux() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _preDemux(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PipelineLoader prepareMix(PipelineLoadParams params) {
        String jsonString;
        if (this.mHandle != 0 && params != null && (jsonString = params.toJsonString()) != null && !jsonString.isEmpty()) {
            long _prepareMix = _prepareMix(this.mHandle, jsonString);
            if (_prepareMix != 0) {
                return new PipelineLoader(_prepareMix);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int reset() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        return _reset(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int stop() {
        long j = this.mHandle;
        if (j == 0) {
            return -1;
        }
        _stop(j);
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void release() {
        AVLogger.InfoTrackLife(TAG, this, String.format(Locale.US, "release TTPlayer:%x", Long.valueOf(this.mHandle)));
        long j = this.mHandle;
        if (j != 0) {
            _release(j);
            this.mHandle = 0L;
        }
        this.mNotifyer = null;
        this.mScreenshotListener = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int setVideoSurface(Surface surface) {
        long j = this.mHandle;
        if (j != 0) {
            return _setVideoSurface(j, surface);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int setVideoSurfaceTimeOut(Surface surface, int timeoutMs) {
        long j = this.mHandle;
        if (j != 0) {
            return _setVideoSurfaceTimeout(j, surface, timeoutMs);
        }
        return -1;
    }

    public int setSurfaceValue(long surface) {
        return _setSurfaceValue(this.mHandle, surface);
    }

    public void setDataSource(String path) {
        AVLogger.m239d(TAG, path);
        long j = this.mHandle;
        if (j != 0) {
            _setDataSource(j, path);
        }
    }

    public void setDataSourceFd(int fd) {
        long j = this.mHandle;
        if (j != 0) {
            _setDataSourceFd(j, fd);
        }
    }

    public int getIntOption(int key, int dValue) {
        if (key == 11) {
            return _getIntValue(this.mHandle, key, dValue);
        }
        if (key != 51) {
            switch (key) {
                case 1:
                    return _getDuration(this.mHandle);
                case 2:
                    return _getCurrentPosition(this.mHandle);
                case 3:
                    return _getVideoWidth(this.mHandle);
                case 4:
                    return _getVideoHeight(this.mHandle);
                case 5:
                    return _isLooping(this.mHandle);
                case 6:
                    return _isPlaying(this.mHandle);
                default:
                    return _getIntValue(this.mHandle, key, dValue);
            }
        }
        return this.mTracker;
    }

    public void setLooping(int looping) {
        _setLooping(this.mHandle, looping);
    }

    public void setVolume(float left, float right) {
        _setVolume(this.mHandle, left, right);
    }

    public void mouseEvent(int action, int deltaX, int deltaY) {
        _mouseEvent(this.mHandle, action, deltaX, deltaY);
    }

    public void seekTo(int msec) {
        _seek(this.mHandle, msec);
    }

    public void seekTo(int msec, int flag) {
        _seek2(this.mHandle, msec, flag);
    }

    public void setNotifyerState(long lState) {
        _setIntValue(this.mHandle, 16, (int) lState);
    }

    public void takeScreenshot() {
        _takeScreenshot(this.mHandle);
    }

    public void switchStream(int bitrate, int streamType) {
        _switchStream(this.mHandle, bitrate, streamType);
    }

    public void setOnScreenshotListener(MediaPlayer.OnScreenshotListener listener) {
        this.mScreenshotListener = listener;
    }

    public final void takeScreenshotComplete(Bitmap bitmap) {
        MediaPlayer.OnScreenshotListener onScreenshotListener = this.mScreenshotListener;
        if (onScreenshotListener != null) {
            onScreenshotListener.onTakeScreenShotCompletion(bitmap);
        }
    }

    public void onFrameAboutToBeRendered(int type, long pts, long wallClockTime, Map<Integer, String> frameData) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onFrameAboutToBeRendered(type, pts, wallClockTime, frameData);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void updateFrameTerminatedDTS(int streamType, long dts, long pts) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.updateFrameTerminatedDTS(streamType, dts, pts);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void didReceivePacket(int streamType, long dts, long pts, Map<Integer, String> packetInfo) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.didReceivePacket(streamType, dts, pts, packetInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void willRenderFrame(int streamType, long dts, long pts, String frameInfo) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.willRenderFrame(streamType, dts, pts, frameInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void frameDTSNotify(int streamType, long dts, long pts) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.frameDTSNotify(streamType, pts, dts);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNotify(int lifeId, int what, int parameter, String info) {
        try {
            IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
            if (iPlayerNotifyer != null) {
                iPlayerNotifyer.handlePlayerNotify(this.mId, lifeId, what, parameter, info);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void receiveBinarySei(ByteBuffer buffer) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.receiveBinarySei(buffer);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onAbrDecisionInfo(long offsetTime, String decisionInfo) {
        try {
            FrameMetadataListener frameMetadataListener = this.mFrameMetadataListener;
            if (frameMetadataListener != null) {
                frameMetadataListener.onAbrDecisionInfo(offsetTime, decisionInfo);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getStrategyParams(String key) {
        try {
            StrategyParamsTransport strategyParamsTransport = this.mStrategyParamsTransport;
            return strategyParamsTransport != null ? strategyParamsTransport.getStrategyParams(key) : BuildConfig.enable_trace;
        } catch (Throwable th) {
            th.printStackTrace();
            return BuildConfig.enable_trace;
        }
    }

    public final void onLogInfo(int type, int code, String logInfo) {
        AVLogger.m239d(TAG, "type:" + type + " code:" + code + logInfo);
        IPlayerNotifyer iPlayerNotifyer = this.mNotifyer;
        if (iPlayerNotifyer != null) {
            try {
                iPlayerNotifyer.handleErrorNotify(this.mId, type, code, logInfo);
            } catch (Throwable unused) {
            }
        }
    }

    public void setNotifyer(IPlayerNotifyer notifyer) {
        this.mNotifyer = notifyer;
    }

    public void setFrameMetadataListener(FrameMetadataListener listener) {
        this.mFrameMetadataListener = listener;
    }

    public void setStrategyParamsTransport(StrategyParamsTransport transport) {
        this.mStrategyParamsTransport = transport;
    }

    public int setIntOption(int key, int value) throws RemoteException {
        if (key == 111) {
            int length = TTPlayerKeys.SupportSampleRates.length;
            int[] iArr = new int[TTPlayerKeys.SupportSampleRates.length];
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                if (((1 << i2) & value) == 0) {
                    iArr[i] = TTPlayerKeys.SupportSampleRates[i2];
                    i++;
                }
            }
            _setSupprotSampleRates(iArr, i);
            return 0;
        }
        return _setIntValue(this.mHandle, key, value);
    }

    public void setDataSource(IMediaDataSource mediaDataSource) throws IllegalArgumentException, SecurityException, IllegalStateException {
        long j = this.mHandle;
        if (j != 0) {
            _setDataSource(j, mediaDataSource);
        }
    }

    public void setLoadControl(LoadControl loadControl) {
        long j = this.mHandle;
        if (j != 0) {
            _setLoadControl(j, loadControl);
        }
    }

    public void setMaskInfo(MaskInfo maskInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setMaskInfo(j, maskInfo);
        }
    }

    public void setAIBarrageInfo(MaskInfo barrageInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setAIBarrageInfo(j, barrageInfo);
        }
    }

    public void setSubInfo(SubInfo subInfo) {
        long j = this.mHandle;
        if (j != 0) {
            _setSubInfo(j, subInfo);
        }
    }

    public void setMediaTransport(MediaTransport mediaTransport) {
        long j = this.mHandle;
        if (j != 0) {
            _setMediaTransport(j, mediaTransport);
        }
    }

    public void setAudioProcessor(AudioProcessor processor) {
        long j = this.mHandle;
        if (j != 0) {
            _setAudioProcessor(j, processor);
        }
    }

    public void setABRStrategy(ABRStrategy abrStrategy) {
        long j = this.mHandle;
        if (j != 0) {
            _setABRStrategy(j, abrStrategy);
        }
    }

    public void setTraitObject(int type, TraitObject traitObject) {
        if (this.mHandle != 0) {
            _setTraitObject(this.mHandle, type, traitObject != null ? traitObject.version() : -1, traitObject);
        }
    }

    public int setIntOptionArray(int[] keys, int[] values) {
        return _setIntValueArray(this.mHandle, keys, values);
    }

    public int setLongOptionArray(int[] keys, long[] values) {
        return _setLongValueArray(this.mHandle, keys, values);
    }

    public int setFloatOptionArray(int[] keys, float[] values) {
        return _setFloatValueArray(this.mHandle, keys, values);
    }

    public int setStringOptionArray(int[] keys, String[] values) {
        return _setStringValueArray(this.mHandle, keys, values);
    }

    public static int isUsedThreadPool() {
        return TTPlayerConfiger.getValue(24, false) ? 1 : 0;
    }

    public static int getThreadPoolStackSize() {
        return TTPlayerConfiger.getValue(25, 32);
    }

    public static int isUseThreadV2() {
        return TTPlayerConfiger.getValue(38, 0);
    }

    public static int isEnableVC2ThreadPriority() {
        return TTPlayerConfiger.getValue(34, false) ? 1 : 0;
    }

    public static int getVC2ThreadPriorityValue() {
        return TTPlayerConfiger.getValue(35, 0);
    }

    public static int isEnableVC2ThreadPriorityLite() {
        return TTPlayerConfiger.getValue(36, false) ? 1 : 0;
    }

    public static int isVC2StackSizeOpt() {
        return TTPlayerConfiger.getValue(39, 0);
    }

    public static int getVC2StackSizeValue() {
        return TTPlayerConfiger.getValue(40, 0);
    }

    public static int isEnableVC2DecPool() {
        return TTPlayerConfiger.getValue(41, false) ? 1 : 0;
    }

    public static int getVC2DecPoolSize() {
        return TTPlayerConfiger.getValue(42, 0);
    }

    public int setStringOption(int key, String value) {
        return _setStringValue(this.mHandle, key, value);
    }

    public String getStringOption(int key) {
        if (key == 1095) {
            return playerLibName;
        }
        return _getStringValue(this.mHandle, key);
    }

    public String getSubtitleContent(int queryTime) {
        return _getSubtitleContent(this.mHandle, queryTime);
    }

    public int setLongOption(int key, long value) {
        return _setLongValue(this.mHandle, key, value);
    }

    public long getLongOption(int key, long dValue) {
        if (key == 50) {
            return this.mHandle;
        }
        return _getLongValue(this.mHandle, key, dValue);
    }

    public void rotateCamera(float angleX, float angleY) {
        _rotateCamera(this.mHandle, angleX, angleY);
    }

    public int setFloatOption(int key, float value) {
        return _setFloatValue(this.mHandle, key, value);
    }

    public int setDoubleOption(int key, double value) {
        return _setDoubleValue(this.mHandle, key, value);
    }

    public float getFloatOption(int key, float dValue) {
        return _getFloatValue(this.mHandle, key, dValue);
    }

    public double getDoubleOption(int key, double dValue) {
        return _getDoubleValue(this.mHandle, key, dValue);
    }

    public Object getObjectValue(int key) {
        return _getJObjectValue(this.mHandle, key);
    }

    public MediaPlayer.TrackInfo[] getTrackInfo() {
        StreamInfo[] streamInfoArr = (StreamInfo[]) _getStreamInfo(this.mHandle);
        if (streamInfoArr == null || streamInfoArr.length == 0) {
            return null;
        }
        int length = streamInfoArr.length;
        MediaPlayer.TrackInfo[] trackInfoArr = new MediaPlayer.TrackInfo[length];
        for (int i = 0; i < length; i++) {
            trackInfoArr[i] = streamInfoArr[i].convertToTrackInfo();
        }
        return trackInfoArr;
    }

    public StreamInfo[] getStreamInfo() {
        return (StreamInfo[]) _getStreamInfo(this.mHandle);
    }

    public int setupMediaCodec() {
        return _setupMediaCodec(this.mHandle);
    }

    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener listener, Handler handler) {
        AJProducerManager.setOnImageAvailableListener(this.mHandle, listener, handler);
    }

    public static int getAudioTrackPoolSize(int enablePreBuild) {
        int audioTrackPoolSize;
        if (TTPlayerConfiger.getValue(90, 0) != 0) {
            AudioTrackPoolRefactor audioTrackPoolRefactor = AudioTrackPoolRefactor.getInstance();
            audioTrackPoolSize = audioTrackPoolRefactor.getPoolSize();
            if (enablePreBuild > 0 && audioTrackPoolSize == 0) {
                audioTrackPoolRefactor.preCreate(1);
            }
        } else {
            AudioTrackPool audioTrackPool = AudioTrackPool.getInstance();
            audioTrackPoolSize = audioTrackPool.getAudioTrackPoolSize();
            if (enablePreBuild > 0 && audioTrackPoolSize == 0) {
                audioTrackPool.preBuild();
            }
        }
        return audioTrackPoolSize;
    }
}
