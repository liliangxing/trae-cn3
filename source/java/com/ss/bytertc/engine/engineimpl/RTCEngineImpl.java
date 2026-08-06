package com.ss.bytertc.engine.engineimpl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglBase14;
import com.lynx.tasm.behavior.PropsConstants;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.bytertc.base.utils.RtcContextUtils;
import com.ss.bytertc.engine.AudioEffectPlayer;
import com.ss.bytertc.engine.IAudioFrameObserver;
import com.ss.bytertc.engine.IAudioFrameProcessor;
import com.ss.bytertc.engine.IMetadataObserver;
import com.ss.bytertc.engine.IRTCAudioDeviceManager;
import com.ss.bytertc.engine.IRTCAudioDeviceManagerEx;
import com.ss.bytertc.engine.IRemoteEncodedAudioFrameObserver;
import com.ss.bytertc.engine.IWTNStream;
import com.ss.bytertc.engine.InternalCloudProxyInfo;
import com.ss.bytertc.engine.InternalLocalProxyConfiguration;
import com.ss.bytertc.engine.InternalMediaTypeEnhancementConfig;
import com.ss.bytertc.engine.InternalVideoCaptureConfig;
import com.ss.bytertc.engine.InternalVideoEncoderConfig;
import com.ss.bytertc.engine.InternalVideoSourceConfig;
import com.ss.bytertc.engine.NativeRTCVideoFunctions;
import com.ss.bytertc.engine.NativeRTCVideoFunctionsEx;
import com.ss.bytertc.engine.NetworkTimeInfo;
import com.ss.bytertc.engine.RTCAudioDeviceManager;
import com.ss.bytertc.engine.RTCEngineEx;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.RTCRoomEx;
import com.ss.bytertc.engine.RTCRoomImpl;
import com.ss.bytertc.engine.RTSRoom;
import com.ss.bytertc.engine.RTSRoomImpl;
import com.ss.bytertc.engine.RemoteVideoRenderConfig;
import com.ss.bytertc.engine.RtcMediaPlayer;
import com.ss.bytertc.engine.SimilaritySingScoringManager;
import com.ss.bytertc.engine.SingScoringManager;
import com.ss.bytertc.engine.VideoCanvas;
import com.ss.bytertc.engine.VideoDeviceManager;
import com.ss.bytertc.engine.VideoEncoderConfig;
import com.ss.bytertc.engine.WTNStream;
import com.ss.bytertc.engine.adapter.VideoSinkAdapter;
import com.ss.bytertc.engine.adapter.VideoSinkTask;
import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.audio.IMediaPlayer;
import com.ss.bytertc.engine.audio.ISimilaritySingScoringManager;
import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.AlphaLayout;
import com.ss.bytertc.engine.data.AudioAlignmentMode;
import com.ss.bytertc.engine.data.AudioContentTypeConfig;
import com.ss.bytertc.engine.data.AudioEncodeConfig;
import com.ss.bytertc.engine.data.AudioFormat;
import com.ss.bytertc.engine.data.AudioFrameCallbackMethod;
import com.ss.bytertc.engine.data.AudioProcessorMethod;
import com.ss.bytertc.engine.data.AudioPropertiesConfig;
import com.ss.bytertc.engine.data.AudioRecordingConfig;
import com.ss.bytertc.engine.data.AudioRenderType;
import com.ss.bytertc.engine.data.AudioRoute;
import com.ss.bytertc.engine.data.AudioSourceType;
import com.ss.bytertc.engine.data.CameraId;
import com.ss.bytertc.engine.data.CloudProxyInfo;
import com.ss.bytertc.engine.data.EarMonitorMode;
import com.ss.bytertc.engine.data.EchoTestConfig;
import com.ss.bytertc.engine.data.EffectBeautyMode;
import com.ss.bytertc.engine.data.EngineConfig;
import com.ss.bytertc.engine.data.MirrorType;
import com.ss.bytertc.engine.data.RTCLogConfig;
import com.ss.bytertc.engine.data.RecordingConfig;
import com.ss.bytertc.engine.data.RemoteMirrorType;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.data.SEICountPerFrame;
import com.ss.bytertc.engine.data.ScreenMediaType;
import com.ss.bytertc.engine.data.StreamIndex;
import com.ss.bytertc.engine.data.StreamPriority;
import com.ss.bytertc.engine.data.StreamSycnInfoConfig;
import com.ss.bytertc.engine.data.VideoDenoiseMode;
import com.ss.bytertc.engine.data.VideoFrameData;
import com.ss.bytertc.engine.data.VideoOrientation;
import com.ss.bytertc.engine.data.VideoPixelFormat;
import com.ss.bytertc.engine.data.VideoRotation;
import com.ss.bytertc.engine.data.VideoRotationMode;
import com.ss.bytertc.engine.data.VideoSimulcastMode;
import com.ss.bytertc.engine.data.VideoSourceType;
import com.ss.bytertc.engine.data.VideoSuperResolutionMode;
import com.ss.bytertc.engine.data.ZoomConfigType;
import com.ss.bytertc.engine.data.ZoomDirectionType;
import com.ss.bytertc.engine.handler.IExternalVideoEncoderEventHandler;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandler;
import com.ss.bytertc.engine.handler.IRTCEngineEventHandlerEx;
import com.ss.bytertc.engine.handler.RTCAudioDeviceEventHandler;
import com.ss.bytertc.engine.handler.RTCEncryptHandler;
import com.ss.bytertc.engine.handler.RTCExternalVideoEncoderEventHandler;
import com.ss.bytertc.engine.handler.RTCLocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.handler.RTCRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.handler.RTCVideoEventHandler;
import com.ss.bytertc.engine.handler.RTCVideoProcessor;
import com.ss.bytertc.engine.live.ChorusCacheSyncConfig;
import com.ss.bytertc.engine.live.ChorusCacheSyncObserver;
import com.ss.bytertc.engine.live.ClientMixedStreamConfig;
import com.ss.bytertc.engine.live.IChorusCacheSyncObserver;
import com.ss.bytertc.engine.live.IClientMixedStreamObserver;
import com.ss.bytertc.engine.live.MixedStreamConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetConfig;
import com.ss.bytertc.engine.live.MixedStreamPushTargetType;
import com.ss.bytertc.engine.live.PushMixedStreamToCDNObserver;
import com.ss.bytertc.engine.live.PushSingleStreamParam;
import com.ss.bytertc.engine.loader.RTCNativeLibraryListenerImpl;
import com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderInfo;
import com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener;
import com.ss.bytertc.engine.mediaio.ILocalEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.IRemoteEncodedVideoFrameObserver;
import com.ss.bytertc.engine.mediaio.RTCEncodedVideoFrame;
import com.ss.bytertc.engine.type.AnsMode;
import com.ss.bytertc.engine.type.AudioProfileType;
import com.ss.bytertc.engine.type.AudioScenarioType;
import com.ss.bytertc.engine.type.ErrorCode;
import com.ss.bytertc.engine.type.LocalProxyConfiguration;
import com.ss.bytertc.engine.type.MediaTypeEnhancementConfig;
import com.ss.bytertc.engine.type.MessageConfig;
import com.ss.bytertc.engine.type.ProblemFeedbackInfo;
import com.ss.bytertc.engine.type.ProblemFeedbackOption;
import com.ss.bytertc.engine.type.PublishFallbackOption;
import com.ss.bytertc.engine.type.RecordingType;
import com.ss.bytertc.engine.type.RemoteUserPriority;
import com.ss.bytertc.engine.type.SubscribeFallbackOptions;
import com.ss.bytertc.engine.type.TorchState;
import com.ss.bytertc.engine.type.VoiceChangerType;
import com.ss.bytertc.engine.type.VoiceEqualizationConfig;
import com.ss.bytertc.engine.type.VoiceReverbConfig;
import com.ss.bytertc.engine.type.VoiceReverbType;
import com.ss.bytertc.engine.utils.AppMonitor;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.EncodedAudioFrameData;
import com.ss.bytertc.engine.utils.LogRecover;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.engine.video.AmazingEffect;
import com.ss.bytertc.engine.video.IAmazingEffect;
import com.ss.bytertc.engine.video.ISnapshotResultCallback;
import com.ss.bytertc.engine.video.IVideoDeviceManager;
import com.ss.bytertc.engine.video.IVideoEffect;
import com.ss.bytertc.engine.video.IVideoProcessor;
import com.ss.bytertc.engine.video.IVideoSink;
import com.ss.bytertc.engine.video.LocalVideoSinkConfig;
import com.ss.bytertc.engine.video.RTCVideoEffect;
import com.ss.bytertc.engine.video.RTCWatermarkConfig;
import com.ss.bytertc.engine.video.RemoteVideoSinkConfig;
import com.ss.bytertc.engine.video.VideoCaptureConfig;
import com.ss.bytertc.engine.video.VideoDecoderConfig;
import com.ss.bytertc.engine.video.VideoPreprocessorConfig;
import com.ss.bytertc.ktv.IKTVManager;
import com.ss.bytertc.ktv.KTVManagerImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.microedition.khronos.egl.EGLContext;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RTCEngineImpl extends RTCEngineEx {
    protected static final String TAG = "RtcVideoImpl";
    private static WeakReference<IRTCAudioDeviceManagerEx.IRTCAudioDeviceEventHandler> mAudioDeviceManagerEventHandler = null;
    private static boolean mLibraryLoaded = false;
    private static final String nativeLibraryPrefix = "lib";
    private static final String nativeLibrarySurffix = ".so";
    private static final String sSoLibraryName = "volcenginertc";
    private AppMonitor.Callback appStateCallback;
    private boolean isExEngine;
    private RTCVideoEffect mAdvanceVideoEffect;
    private ChorusCacheSyncObserver mChorusObserver;
    private Context mContext;
    private EglBase.Context mEglBaseCtx;
    private Handler mEglHandler;
    private HandlerThread mEglThread;
    private RTCVideoEventHandler mEngineEventHandler;
    private IExternalVideoEncoderEventHandler mExternalVideoEncoderHandler;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private ILocalEncodedVideoFrameObserver mLocalEncodedVideoFrameObserver;
    private LogUtil.ILoggerSink mLoggerSink;
    private IMetadataObserver mMetadataObserver;
    private PushMixedStreamToCDNObserver mMixedStreamToCDNObserver;
    protected long mNativeEngine;
    private final ReentrantReadWriteLock mReadWriteLock;
    private IRemoteEncodedVideoFrameObserver mRemoteEncodedVideoFrameObserver;
    private Map<String, RTCRoomImpl> mRoomMap;
    private List<RTSRoomImpl> mRoomRtsLists;
    private IRTCEngineEventHandler mRtcEngineHandler;
    private IRTCEngineEventHandlerEx mRtcEngineHandlerEx;
    private RTCExternalVideoEncoderEventHandler mRtcExVideoEncoderHandler;
    private RTCLocalEncodedVideoFrameObserver mRtcLocalEncodedVideoFrameObserver;
    private RTCRemoteEncodedVideoFrameObserver mRtcRemoteEncodedVideoFrameObserver;
    private RTCVideoProcessor mRtcVideoPreprocessor;
    private RTCVideoProcessor mRtcVideoScreenPreprocessor;
    private State mState;
    private VideoSinkTask mVideoSinkTask;
    private static RTCNativeLibraryLoaderListener mRtcNativeLibraryListener = new RTCNativeLibraryListenerImpl();
    private static RTCNativeLibraryLoaderInfo sRtcLoaderInfo = new RTCNativeLibraryLoaderInfo();
    private static RTCAudioDeviceEventHandler mRTCAudioDeviceManagerEventHandler = null;
    private static String mDeviceId = "";
    private boolean mIsUseCustomEglEnv = false;
    private boolean mEnableTranscode = false;
    private Runnable mOnDestroyCompletedCallback = null;
    private EglBase mRootEglBase = null;
    private boolean mIsFront = true;
    private AudioEffectPlayer mAudioEffectPlayer = null;
    private Map<Integer, RtcMediaPlayer> mRtcMediaPlayerMap = null;
    private RTCAudioDeviceManager mAudioDeviceManagerInterval = null;
    private SingScoringManager mSingScoringManager = null;
    private SimilaritySingScoringManager mSimilaritySingScoringManager = null;
    private KTVManagerImpl mKTVManager = null;
    private WTNStream mWTNStream = null;
    private VideoDeviceManager mVideoDevicemanager = null;
    private AmazingEffect mAmazingEffect = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    enum State {
        IDLE,
        IN_ROOM,
        DESTORY
    }

    public static Context getApplicationContext() {
        return RtcContextUtils.getApplicationContext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-ss-bytertc-engine-engineimpl-RTCEngineImpl, reason: not valid java name */
    public /* synthetic */ void m4165lambda$new$0$comssbytertcengineengineimplRTCEngineImpl(LogUtil.LogLevel logLevel, String str, Throwable th) {
        IRTCEngineEventHandler rtcEngineHandler = getRtcEngineHandler();
        if (rtcEngineHandler != null) {
            try {
                rtcEngineHandler.onLoggerMessage(logLevel, str, th);
            } catch (Exception e) {
                Log.w(TAG, "Exception in App thread when handler onLoggerMessage , e : " + e.getMessage(), e);
            }
        }
    }

    public static synchronized boolean initializeNativeLibs() {
        boolean initializeNativeLibs;
        synchronized (RTCEngineImpl.class) {
            initializeNativeLibs = initializeNativeLibs(null);
        }
        return initializeNativeLibs;
    }

    public static synchronized boolean initializeNativeLibs(String nativeLibPath) {
        synchronized (RTCEngineImpl.class) {
            if (mLibraryLoaded) {
                mRtcNativeLibraryListener.onLoadAlready("volcenginertc");
            } else {
                boolean loadNativeLib = loadNativeLib(nativeLibPath, "bytenn");
                mLibraryLoaded = loadNativeLib;
                if (!loadNativeLib) {
                    mRtcNativeLibraryListener.onLoadError("bytenn");
                    return mLibraryLoaded;
                }
                boolean loadNativeLib2 = loadNativeLib(nativeLibPath, "volcenginertc");
                mLibraryLoaded = loadNativeLib2;
                if (!loadNativeLib2) {
                    mRtcNativeLibraryListener.onLoadError("volcenginertc");
                    return mLibraryLoaded;
                }
            }
            mRtcNativeLibraryListener.onLoadSuccess("volcenginertc");
            sRtcLoaderInfo.setLoadResult(mLibraryLoaded);
            sRtcLoaderInfo.setLoadTimeStampMs(System.currentTimeMillis());
            return mLibraryLoaded;
        }
    }

    private static boolean loadNativeLib(String nativeLibLoadPath, String name) {
        LogUtil.m218i(TAG, "Loading library: " + name);
        String str = nativeLibLoadPath + (nativeLibraryPrefix + name + nativeLibrarySurffix);
        if (mRtcNativeLibraryLoader != null) {
            return mRtcNativeLibraryLoader.load(name);
        }
        try {
            if (TextUtils.isEmpty(nativeLibLoadPath)) {
                System.loadLibrary(name);
            } else {
                System.load(str);
            }
            LogUtil.m218i(TAG, "loadNativeLib: Success Load " + name);
            return true;
        } catch (NullPointerException e) {
            LogUtil.m217e(TAG, "loadNativeLib: Failed to load native library: " + name, e);
            return false;
        } catch (SecurityException e2) {
            LogUtil.m217e(TAG, "loadNativeLib: Failed to load native library: " + name, e2);
            return false;
        } catch (Exception e3) {
            LogUtil.m217e(TAG, "loadNativeLib: Failed to load native library: " + name, e3);
            return false;
        } catch (UnsatisfiedLinkError e4) {
            LogUtil.m217e(TAG, "loadNativeLib: Failed to load native library: " + name, e4);
            return false;
        }
    }

    public EglBase getEGLContext() {
        EglBase eglBase = this.mRootEglBase;
        if (eglBase != null) {
            return eglBase;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-ss-bytertc-engine-engineimpl-RTCEngineImpl, reason: not valid java name */
    public /* synthetic */ void m4166lambda$new$1$comssbytertcengineengineimplRTCEngineImpl(int i) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetAppState failed.");
            } else {
                NativeRTCVideoFunctions.nativeSetAppState(this.mNativeEngine, i == 1 ? "active" : PropsConstants.BACKGROUND);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    private void initEglContext(Object eglContext) {
        if (eglContext == null) {
            this.mRootEglBase = EglBase.create();
            this.mIsUseCustomEglEnv = false;
            return;
        }
        if (eglContext instanceof EGLContext) {
            this.mRootEglBase = EglBase.createEgl10((EGLContext) eglContext, EglBase.CONFIG_PLAIN);
        } else if (eglContext instanceof android.opengl.EGLContext) {
            this.mRootEglBase = EglBase.createEgl14((android.opengl.EGLContext) eglContext, EglBase.CONFIG_PLAIN);
        } else if (eglContext instanceof EglBase) {
            this.mRootEglBase = EglBase.create(((EglBase) eglContext).getEglBaseContext(), EglBase.CONFIG_PLAIN);
        } else {
            this.mRootEglBase = EglBase.create();
        }
        this.mIsUseCustomEglEnv = true;
    }

    protected boolean engineInvalid() {
        return this.mNativeEngine == 0;
    }

    public long createRTCVideo(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath) {
        return NativeRTCVideoFunctions.nativeCreateRTCVideo(context, appId, eventHandler, parameters, eglBaseCtx, nativeLoadPath);
    }

    public long createRTCVideoMulti(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath) {
        return NativeRTCVideoFunctions.nativeCreateRTCVideoMulti(context, appId, eventHandler, parameters, eglBaseCtx, nativeLoadPath);
    }

    public void destroyRTCVideo(long nativeEngine) {
        NativeRTCVideoFunctions.nativeDestroyRTCVideo(nativeEngine);
    }

    public void destroyRTCVideoMulti(long nativeEngine) {
        NativeRTCVideoFunctions.nativeDestroyRTCVideoMulti(nativeEngine);
    }

    public long createRTCVideoEx(Context context, String appId, RTCVideoEventHandler eventHandler, String parameters, EglBase.Context eglBaseCtx, String nativeLoadPath) {
        return NativeRTCVideoFunctionsEx.nativeCreateRTCVideoEx(context, appId, eventHandler, parameters, eglBaseCtx, nativeLoadPath);
    }

    public void destroyRTCVideoEx(long nativeEngine) {
        NativeRTCVideoFunctionsEx.nativeDestroyRTCVideoEx(nativeEngine);
    }

    public static int setLogConfig(RTCLogConfig logConfig) {
        return NativeRTCVideoFunctions.nativeSetLogConfig(logConfig.logLevel.getValue(), logConfig.logPath, logConfig.logFileSize, logConfig.logFilenamePrefix);
    }

    public RTCEngineImpl(EngineConfig config, IRTCEngineEventHandler handler, IRTCEngineEventHandlerEx handlerEx, boolean isExEngine, boolean isMulti) throws IllegalStateException {
        this.isExEngine = false;
        this.mNativeEngine = 0L;
        this.mRtcVideoPreprocessor = null;
        this.mRtcVideoScreenPreprocessor = null;
        this.mRtcExVideoEncoderHandler = null;
        this.mRtcLocalEncodedVideoFrameObserver = null;
        this.mRtcRemoteEncodedVideoFrameObserver = null;
        this.mEglBaseCtx = null;
        this.mChorusObserver = null;
        this.mMixedStreamToCDNObserver = null;
        this.mAdvanceVideoEffect = null;
        this.mRoomMap = null;
        this.mRoomRtsLists = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWriteLock = reentrantReadWriteLock;
        this.mJniReadLock = reentrantReadWriteLock.readLock();
        this.mJniWriteLock = reentrantReadWriteLock.writeLock();
        this.mLoggerSink = new LogUtil.ILoggerSink() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda0
            @Override // com.ss.bytertc.engine.utils.LogUtil.ILoggerSink
            public final void onLoggerMessage(LogUtil.LogLevel logLevel, String str, Throwable th) {
                RTCEngineImpl.this.m4165lambda$new$0$comssbytertcengineengineimplRTCEngineImpl(logLevel, str, th);
            }
        };
        this.appStateCallback = new AppMonitor.Callback() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda1
            @Override // com.ss.bytertc.engine.utils.AppMonitor.Callback
            public final void callback(int i) {
                RTCEngineImpl.this.m4166lambda$new$1$comssbytertcengineengineimplRTCEngineImpl(i);
            }
        };
        Context context = config.context;
        String str = config.appID;
        Object obj = config.eglContext;
        JSONObject jSONObject = config.parameters;
        LogUtil.m215d(TAG, "create RtcEngineImpl with appId: " + str);
        if (obj != null && !(obj instanceof android.opengl.EGLContext)) {
            throw new IllegalArgumentException("eglContext is not an instance of android.opengl.EGLContext");
        }
        if (!mLibraryLoaded) {
            reportAndThrowError(str, "rtc sdk load so failed", ErrorCode.ERROR_CODE_LOAD_SO_LIB);
        }
        if (str == null) {
            reportAndThrowError(str, "app id is null", ErrorCode.ERROR_CODE_APP_ID_NULL);
        }
        try {
            HandlerThread handlerThread = new HandlerThread("rtc_egl_thread");
            this.mEglThread = handlerThread;
            try {
                handlerThread.start();
                VideoSinkTask videoSinkTask = new VideoSinkTask();
                this.mVideoSinkTask = videoSinkTask;
                videoSinkTask.init();
                Handler handler2 = new Handler(this.mEglThread.getLooper());
                this.mEglHandler = handler2;
                if (obj == null) {
                    if (!((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(handler2, new Callable() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda2
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return RTCEngineImpl.this.m4167lambda$new$2$comssbytertcengineengineimplRTCEngineImpl();
                        }
                    })).booleanValue()) {
                        throw new IllegalStateException("init egl context failed");
                    }
                    this.mEglBaseCtx = this.mRootEglBase.getEglBaseContext();
                } else {
                    this.mEglBaseCtx = new EglBase14.Context((android.opengl.EGLContext) obj);
                }
                this.mRtcVideoPreprocessor = new RTCVideoProcessor();
                this.mRtcVideoScreenPreprocessor = new RTCVideoProcessor();
                this.mContext = context.getApplicationContext();
                this.mState = State.IDLE;
                this.mRtcEngineHandler = handler;
                this.mRtcEngineHandlerEx = handlerEx;
                LogUtil.setLoggerSink(this.mLoggerSink);
                this.mEngineEventHandler = new RTCVideoEventHandler(this);
                this.mRtcLocalEncodedVideoFrameObserver = new RTCLocalEncodedVideoFrameObserver(this);
                this.mRtcRemoteEncodedVideoFrameObserver = new RTCRemoteEncodedVideoFrameObserver(this);
                this.mChorusObserver = new ChorusCacheSyncObserver();
                this.mMixedStreamToCDNObserver = new PushMixedStreamToCDNObserver();
                this.mRtcExVideoEncoderHandler = new RTCExternalVideoEncoderEventHandler(this);
                this.mRoomMap = new HashMap();
                this.mRoomRtsLists = new ArrayList();
                try {
                    if (isMulti) {
                        this.mNativeEngine = createRTCVideoMulti(this.mContext.getApplicationContext(), str, this.mEngineEventHandler, jSONObject == null ? "" : jSONObject.toString(), this.mEglBaseCtx, config.nativeLoadPath);
                    } else {
                        this.isExEngine = isExEngine;
                        if (isExEngine) {
                            this.mNativeEngine = createRTCVideoEx(this.mContext.getApplicationContext(), str, this.mEngineEventHandler, jSONObject == null ? "" : jSONObject.toString(), this.mEglBaseCtx, config.nativeLoadPath);
                        } else {
                            this.mNativeEngine = createRTCVideo(this.mContext.getApplicationContext(), str, this.mEngineEventHandler, jSONObject == null ? "" : jSONObject.toString(), this.mEglBaseCtx, config.nativeLoadPath);
                        }
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                    throw new UnsatisfiedLinkError("rtc loader info:" + sRtcLoaderInfo.toString() + " exception info:" + e.getStackTrace().toString());
                }
            } catch (OutOfMemoryError unused) {
                throw new IllegalStateException("egl thread create thread failed as out of memory");
            }
        } catch (IllegalStateException e2) {
            LogUtil.m216e(TAG, "create native engine error, native engine is invalid.");
            doDestroyOnCreate();
            reportAndThrowError(str, "system resources check failed. " + e2.getMessage(), 0);
        }
        if (engineInvalid()) {
            throw new IllegalStateException("create native engine error.");
        }
        this.mAdvanceVideoEffect = new RTCVideoEffect(this.mNativeEngine);
        LogRecover.getInstance().startTimer();
        AppMonitor.get(context).register(context, this.appStateCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$2$com-ss-bytertc-engine-engineimpl-RTCEngineImpl, reason: not valid java name */
    public /* synthetic */ Boolean m4167lambda$new$2$comssbytertcengineengineimplRTCEngineImpl() throws Exception {
        try {
            initEglContext(null);
            this.mRootEglBase.createDummyPbufferSurface();
            this.mRootEglBase.makeCurrent();
            return true;
        } catch (RuntimeException unused) {
            LogUtil.m216e(TAG, "init egl context falied");
            return false;
        }
    }

    private void reportAndThrowError(String appId, String errorMessage, int errorCode) throws IllegalStateException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_key", "rtc_error");
            jSONObject.put("rtc_app_id", appId);
            jSONObject.put("device_id", mDeviceId);
            jSONObject.put("error_code", errorCode);
            jSONObject.put("message", errorMessage);
            jSONObject.put(FrescoMonitorConst.TIMESTAMP, System.currentTimeMillis());
            jSONObject.put("rtc_timestamp", System.currentTimeMillis());
            jSONObject.put(RegistrationHeaderHelper.KEY_OS, RomUtils.OS_ANDROID);
            jSONObject.put("product_line", "rtc");
            jSONObject.put("report_version", 5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IRTCEngineEventHandler iRTCEngineEventHandler = this.mRtcEngineHandler;
        if (iRTCEngineEventHandler != null) {
            iRTCEngineEventHandler.onLogReport("live_webrtc_monitor_log", jSONObject);
            this.mRtcEngineHandler.onError(errorCode);
        }
        LogUtil.m216e(TAG, errorMessage);
        throw new IllegalStateException("Create engine failed " + errorMessage);
    }

    private void doDestroyOnCreate() {
        RTCVideoProcessor rTCVideoProcessor = this.mRtcVideoPreprocessor;
        if (rTCVideoProcessor != null) {
            rTCVideoProcessor.dispose();
            this.mRtcVideoPreprocessor = null;
        }
        RTCVideoProcessor rTCVideoProcessor2 = this.mRtcVideoScreenPreprocessor;
        if (rTCVideoProcessor2 != null) {
            rTCVideoProcessor2.dispose();
            this.mRtcVideoScreenPreprocessor = null;
        }
        Handler handler = this.mEglHandler;
        if (handler != null) {
            ThreadUtils.invokeAtFrontUninterruptibly(handler, new Runnable() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    RTCEngineImpl.this.m211xc16624b6();
                }
            });
        }
        HandlerThread handlerThread = this.mEglThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        VideoSinkTask videoSinkTask = this.mVideoSinkTask;
        if (videoSinkTask != null) {
            videoSinkTask.exit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doDestroyOnCreate$3$com-ss-bytertc-engine-engineimpl-RTCEngineImpl */
    public /* synthetic */ void m211xc16624b6() {
        EglBase eglBase = this.mRootEglBase;
        if (eglBase != null) {
            eglBase.release();
            this.mRootEglBase = null;
        }
    }

    public void doDestroy(boolean isMulti) {
        LogUtil.m215d(TAG, "destroy RtcEngineImpl.");
        this.mJniWriteLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, no need to destroy now.");
                return;
            }
            long j = this.mNativeEngine;
            this.mNativeEngine = 0L;
            this.mJniWriteLock.unlock();
            this.mState = State.DESTORY;
            SingScoringManager singScoringManager = this.mSingScoringManager;
            if (singScoringManager instanceof SingScoringManager) {
                singScoringManager.destroy();
            }
            SimilaritySingScoringManager similaritySingScoringManager = this.mSimilaritySingScoringManager;
            if (similaritySingScoringManager instanceof SimilaritySingScoringManager) {
                similaritySingScoringManager.destroy();
            }
            KTVManagerImpl kTVManagerImpl = this.mKTVManager;
            if (kTVManagerImpl instanceof KTVManagerImpl) {
                kTVManagerImpl.destroy();
            }
            RTCAudioDeviceManager rTCAudioDeviceManager = this.mAudioDeviceManagerInterval;
            if (rTCAudioDeviceManager instanceof RTCAudioDeviceManager) {
                rTCAudioDeviceManager.destroy();
            }
            Map<String, RTCRoomImpl> map = this.mRoomMap;
            if (map != null) {
                Iterator<RTCRoomImpl> it = map.values().iterator();
                while (it.hasNext()) {
                    it.next().destroy();
                }
            }
            List<RTSRoomImpl> list = this.mRoomRtsLists;
            if (list != null) {
                Iterator<RTSRoomImpl> it2 = list.iterator();
                while (it2.hasNext()) {
                    it2.next().destroy();
                }
            }
            AudioEffectPlayer audioEffectPlayer = this.mAudioEffectPlayer;
            boolean z = audioEffectPlayer instanceof AudioEffectPlayer;
            if (z) {
                audioEffectPlayer.setEventHandler(null);
                audioEffectPlayer.destroyResourceInternal();
            }
            Map<Integer, RtcMediaPlayer> map2 = this.mRtcMediaPlayerMap;
            if (map2 != null) {
                for (RtcMediaPlayer rtcMediaPlayer : map2.values()) {
                    rtcMediaPlayer.setEventHandler(null);
                    rtcMediaPlayer.destroyResourceInternal();
                }
            }
            if (isMulti) {
                destroyRTCVideoMulti(j);
            } else if (!this.isExEngine) {
                destroyRTCVideo(j);
            } else {
                destroyRTCVideoEx(j);
            }
            if (z) {
                audioEffectPlayer.destroy();
            }
            Map<Integer, RtcMediaPlayer> map3 = this.mRtcMediaPlayerMap;
            if (map3 != null) {
                Iterator<RtcMediaPlayer> it3 = map3.values().iterator();
                while (it3.hasNext()) {
                    it3.next().destroy();
                }
            }
            this.mIsFront = true;
            RTCVideoEffect rTCVideoEffect = this.mAdvanceVideoEffect;
            if (rTCVideoEffect instanceof RTCVideoEffect) {
                rTCVideoEffect.destroy();
                this.mAdvanceVideoEffect = null;
            }
            AmazingEffect amazingEffect = this.mAmazingEffect;
            if (amazingEffect != null) {
                amazingEffect.dispose();
                this.mAmazingEffect = null;
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    RTCEngineImpl.this.m209xdb14f310();
                }
            });
            AppMonitor.get(this.mContext).unRegister(this.appStateCallback).release(this.mContext);
            this.mRtcVideoPreprocessor.dispose();
            this.mRtcVideoPreprocessor = null;
            RTCVideoProcessor rTCVideoProcessor = this.mRtcVideoScreenPreprocessor;
            if (rTCVideoProcessor != null) {
                rTCVideoProcessor.dispose();
                this.mRtcVideoScreenPreprocessor = null;
            }
            ThreadUtils.invokeAtFrontUninterruptibly(this.mEglHandler, new Runnable() { // from class: com.ss.bytertc.engine.engineimpl.RTCEngineImpl$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    RTCEngineImpl.this.m210x14df94ef();
                }
            });
            HandlerThread handlerThread = this.mEglThread;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            VideoSinkTask videoSinkTask = this.mVideoSinkTask;
            if (videoSinkTask != null) {
                videoSinkTask.exit();
            }
            KTVManagerImpl kTVManagerImpl2 = this.mKTVManager;
            if (kTVManagerImpl2 != null) {
                kTVManagerImpl2.destroy();
                this.mKTVManager = null;
            }
            LogUtil.setLoggerSink(null);
        } finally {
            this.mJniWriteLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doDestroy$4$com-ss-bytertc-engine-engineimpl-RTCEngineImpl */
    public /* synthetic */ void m209xdb14f310() {
        Runnable runnable = this.mOnDestroyCompletedCallback;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$doDestroy$5$com-ss-bytertc-engine-engineimpl-RTCEngineImpl */
    public /* synthetic */ void m210x14df94ef() {
        EglBase eglBase = this.mRootEglBase;
        if (eglBase != null) {
            eglBase.release();
            this.mRootEglBase = null;
        }
    }

    public IRTCEngineEventHandler getRtcEngineHandler() {
        return this.mRtcEngineHandler;
    }

    public IRTCEngineEventHandlerEx getRtcEngineHandlerEx() {
        return this.mRtcEngineHandlerEx;
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setRtcVideoEventHandlerEx(IRTCEngineEventHandlerEx engineEventHandlerEx) {
        LogUtil.m215d(TAG, "setRtcEngineEventHandlerEx");
        this.mRtcEngineHandlerEx = engineEventHandlerEx;
        return 0;
    }

    public static String getSdkVersion() {
        return NativeRTCVideoFunctions.nativeGetSDKVersion();
    }

    public static IRTCAudioDeviceManagerEx.IRTCAudioDeviceEventHandler getAudioDeviceManagerEvent() {
        return mAudioDeviceManagerEventHandler.get();
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRtcVideoEventHandler(IRTCEngineEventHandler engineEventHandler) {
        LogUtil.m215d(TAG, "setRtcEngineEventHandler");
        this.mRtcEngineHandler = engineEventHandler;
        return 0;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public IRTCAudioDeviceManager getAudioDeviceManager() {
        LogUtil.m215d(TAG, "getAudioDeviceManager");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getAudioDeviceManager failed.");
                return null;
            }
            long nativeGetAudioDeviceManager = NativeRTCVideoFunctions.nativeGetAudioDeviceManager(this.mNativeEngine);
            if (nativeGetAudioDeviceManager != 0 && nativeGetAudioDeviceManager != -1) {
                this.mAudioDeviceManagerInterval = new RTCAudioDeviceManager(nativeGetAudioDeviceManager);
                return this.mAudioDeviceManagerInterval;
            }
            LogUtil.m216e(TAG, "getAudioDeviceManager failed");
            this.mAudioDeviceManagerInterval = null;
            return this.mAudioDeviceManagerInterval;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public ILocalEncodedVideoFrameObserver getEncodedVideoFrameObserver() {
        return this.mLocalEncodedVideoFrameObserver;
    }

    public IRemoteEncodedVideoFrameObserver getRemoteEncodedVideoFrameObserver() {
        return this.mRemoteEncodedVideoFrameObserver;
    }

    public IMetadataObserver getMetadataObserver() {
        return this.mMetadataObserver;
    }

    public IExternalVideoEncoderEventHandler getExternalVideoEncoderEventHandler() {
        return this.mExternalVideoEncoderHandler;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startVideoCapture() {
        int nativeStartVideoCapture;
        LogUtil.m215d(TAG, "startVideoCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startVideoCapture failed.");
                nativeStartVideoCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartVideoCapture = NativeRTCVideoFunctions.nativeStartVideoCapture(this.mNativeEngine);
            }
            return nativeStartVideoCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopVideoCapture() {
        int nativeStopVideoCapture;
        LogUtil.m215d(TAG, "stopVideoCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopVideoCapture failed.");
                nativeStopVideoCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopVideoCapture = NativeRTCVideoFunctions.nativeStopVideoCapture(this.mNativeEngine);
            }
            return nativeStopVideoCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startAudioCapture() {
        int nativeStartAudioCapture;
        LogUtil.m215d(TAG, "startAudioCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startAudioCapture failed.");
                nativeStartAudioCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartAudioCapture = NativeRTCVideoFunctions.nativeStartAudioCapture(this.mNativeEngine);
            }
            return nativeStartAudioCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopAudioCapture() {
        int nativeStopAudioCapture;
        LogUtil.m215d(TAG, "stopAudioCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopAudioCapture failed.");
                nativeStopAudioCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopAudioCapture = NativeRTCVideoFunctions.nativeStopAudioCapture(this.mNativeEngine);
            }
            return nativeStopAudioCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioScenario(AudioScenarioType audioScenario) {
        int nativeSetAudioScenario;
        LogUtil.m215d(TAG, "setAudioScenario...audioScenario: " + audioScenario);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setAudioScenario failed.");
                nativeSetAudioScenario = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioScenario = NativeRTCVideoFunctions.nativeSetAudioScenario(this.mNativeEngine, audioScenario.value());
            }
            return nativeSetAudioScenario;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioProfile(AudioProfileType audioProfile) {
        int nativeSetAudioProfile;
        LogUtil.m215d(TAG, "setAudioProfile:" + audioProfile);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setAudioProfile failed.");
                nativeSetAudioProfile = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (audioProfile == null) {
                LogUtil.m216e(TAG, "audioProfile is invalid, setAudioProfile failed.");
                nativeSetAudioProfile = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSetAudioProfile = NativeRTCVideoFunctions.nativeSetAudioProfile(this.mNativeEngine, audioProfile.value());
            }
            return nativeSetAudioProfile;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAnsMode(AnsMode ansMode) {
        int nativeSetAnsMode;
        LogUtil.m215d(TAG, "setAnsMode:" + ansMode);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setAnsMode failed.");
                nativeSetAnsMode = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (ansMode == null) {
                LogUtil.m216e(TAG, "ansMode is invalid, setAnsMode failed.");
                nativeSetAnsMode = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSetAnsMode = NativeRTCVideoFunctions.nativeSetAnsMode(this.mNativeEngine, ansMode.value());
            }
            return nativeSetAnsMode;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVoiceChangerType(VoiceChangerType voiceChanger) {
        int nativeSetVoiceChangerType;
        LogUtil.m215d(TAG, "setVoiceChangerType...voiceChanger: " + voiceChanger);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVoiceChangerType failed.");
                nativeSetVoiceChangerType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVoiceChangerType = NativeRTCVideoFunctions.nativeSetVoiceChangerType(this.mNativeEngine, voiceChanger.value());
            }
            return nativeSetVoiceChangerType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVoiceReverbType(VoiceReverbType voiceReverb) {
        int nativeSetVoiceReverbType;
        LogUtil.m215d(TAG, "setVoiceReverbType...voiceReverb: " + voiceReverb);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVoiceReverbType failed.");
                nativeSetVoiceReverbType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVoiceReverbType = NativeRTCVideoFunctions.nativeSetVoiceReverbType(this.mNativeEngine, voiceReverb.value());
            }
            return nativeSetVoiceReverbType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVoiceEqualization(VoiceEqualizationConfig config) {
        int nativeSetLocalVoiceEqualization;
        LogUtil.m215d(TAG, "setLocalVoiceEqualization...frequency : " + config.frequency + ", gain: " + config.gain);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVoiceEqualization failed.");
                nativeSetLocalVoiceEqualization = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalVoiceEqualization = NativeRTCVideoFunctions.nativeSetLocalVoiceEqualization(this.mNativeEngine, config.frequency.value(), config.gain);
            }
            return nativeSetLocalVoiceEqualization;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVoiceReverbParam(VoiceReverbConfig config) {
        int nativeSetLocalVoiceReverbParam;
        LogUtil.m215d(TAG, "setLocalVoiceReverbParam...roomSize: " + config.roomSize + ", decayTime: " + config.decayTime + ", damping:" + config.damping + ", wetGain:" + config.wetGain + ", dryGain:" + config.dryGain + ", preDelay:" + config.preDelay);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVoiceReverbParam failed.");
                nativeSetLocalVoiceReverbParam = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalVoiceReverbParam = NativeRTCVideoFunctions.nativeSetLocalVoiceReverbParam(this.mNativeEngine, config.roomSize, config.decayTime, config.damping, config.wetGain, config.dryGain, config.preDelay);
            }
            return nativeSetLocalVoiceReverbParam;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableLocalVoiceReverb(boolean enable) {
        int nativeEnableLocalVoiceReverb;
        LogUtil.m215d(TAG, "enableLocalVoiceReverb...enable: " + enable);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableLocalVoiceReverb failed.");
                nativeEnableLocalVoiceReverb = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableLocalVoiceReverb = NativeRTCVideoFunctions.nativeEnableLocalVoiceReverb(this.mNativeEngine, enable);
            }
            return nativeEnableLocalVoiceReverb;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVideoCanvas(StreamIndex streamIndex, VideoCanvas canvas) {
        int nativeSetLocalVideoCanvas;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVideoCanvas failed.");
                nativeSetLocalVideoCanvas = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                if (canvas == null) {
                    canvas = new VideoCanvas();
                }
                nativeSetLocalVideoCanvas = NativeRTCVideoFunctions.nativeSetLocalVideoCanvas(this.mNativeEngine, streamIndex.value(), canvas.renderView, canvas.renderSurface, canvas.renderMode, canvas.backgroundColor);
            }
            return nativeSetLocalVideoCanvas;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateLocalVideoCanvas(StreamIndex streamIndex, int renderMode, int background_color) {
        int nativeUpdateLocalVideoCanvas;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, updateLocalVideoCanvas failed.");
                nativeUpdateLocalVideoCanvas = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateLocalVideoCanvas = NativeRTCVideoFunctions.nativeUpdateLocalVideoCanvas(this.mNativeEngine, streamIndex.value(), renderMode, background_color);
            }
            return nativeUpdateLocalVideoCanvas;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVideoSink(StreamIndex index, IVideoSink videoSink, int requiredFormat) {
        int nativeSetLocalVideoSink;
        this.mJniReadLock.lock();
        try {
            if (index == null) {
                LogUtil.m216e(TAG, "EventType: setLocalVideoSink, streamIndex is null");
                nativeSetLocalVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVideoSink failed.");
                nativeSetLocalVideoSink = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalVideoSink = NativeRTCVideoFunctions.nativeSetLocalVideoSink(this.mNativeEngine, index.value(), videoSink != null ? new VideoSinkAdapter(videoSink) : null, requiredFormat);
            }
            return nativeSetLocalVideoSink;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVideoSink(StreamIndex index, IVideoSink videoSink, LocalVideoSinkConfig config) {
        int nativesetLocalVideoSink;
        this.mJniReadLock.lock();
        try {
            if (index == null) {
                LogUtil.m216e(TAG, "EventType: setLocalVideoSink, streamIndex is null");
                nativesetLocalVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVideoSink failed.");
                nativesetLocalVideoSink = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (config.pixelFormat.value() != VideoPixelFormat.I420.value() && config.pixelFormat.value() != VideoPixelFormat.RGBA.value() && config.pixelFormat.value() != VideoPixelFormat.UNKNOWN.value()) {
                nativesetLocalVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativesetLocalVideoSink = NativeRTCVideoFunctions.nativesetLocalVideoSink(this.mNativeEngine, index.value(), videoSink != null ? new VideoSinkAdapter(videoSink) : null, config.pixelFormat.value(), config.position.getValue());
            }
            return nativesetLocalVideoSink;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteVideoSink(RemoteStreamKey streamKey, IVideoSink videoSink, int requiredFormat) {
        int nativeSetRemoteVideoSink;
        this.mJniReadLock.lock();
        try {
            if (streamKey == null) {
                LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamKey is null");
                nativeSetRemoteVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (streamKey.getStreamIndex() == null) {
                LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamIndex is null");
                nativeSetRemoteVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setRemoteVideoSink failed.");
                nativeSetRemoteVideoSink = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteVideoSink = NativeRTCVideoFunctions.nativeSetRemoteVideoSink(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), videoSink != null ? new VideoSinkAdapter(videoSink) : null, requiredFormat);
            }
            return nativeSetRemoteVideoSink;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteVideoSink(RemoteStreamKey streamKey, IVideoSink videoSink, RemoteVideoSinkConfig config) {
        int nativesetRemoteVideoSink;
        this.mJniReadLock.lock();
        try {
            if (streamKey == null) {
                LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamKey is null");
                nativesetRemoteVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (streamKey.getStreamIndex() == null) {
                LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamIndex is null");
                nativesetRemoteVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setRemoteVideoSink failed.");
                nativesetRemoteVideoSink = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (config.pixelFormat.value() != VideoPixelFormat.I420.value() && config.pixelFormat.value() != VideoPixelFormat.RGBA.value() && config.pixelFormat.value() != VideoPixelFormat.UNKNOWN.value()) {
                nativesetRemoteVideoSink = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativesetRemoteVideoSink = NativeRTCVideoFunctions.nativesetRemoteVideoSink(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), videoSink != null ? new VideoSinkAdapter(videoSink) : null, config.pixelFormat.value(), config.position.getValue(), config.applyRotation.getValue(), config.mirrorType.getValue());
            }
            return nativesetRemoteVideoSink;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateRemoteStreamVideoCanvas(RemoteStreamKey stream_key, int renderMode, int background_color) {
        RemoteVideoRenderConfig remoteVideoRenderConfig = new RemoteVideoRenderConfig();
        remoteVideoRenderConfig.renderMode = renderMode;
        remoteVideoRenderConfig.backgroundColor = background_color;
        return updateRemoteStreamVideoCanvas(stream_key, remoteVideoRenderConfig);
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateRemoteStreamVideoCanvas(RemoteStreamKey stream_key, RemoteVideoRenderConfig remoteVideoRenderConfig) {
        int nativeUpdateRemoteVideoCanvas;
        this.mJniReadLock.lock();
        try {
            if (stream_key == null) {
                LogUtil.m216e(TAG, "EventType: updateRemoteStreamVideoCanvas, streamKey is null");
                nativeUpdateRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (stream_key.hasNullProperty()) {
                LogUtil.m216e(TAG, "EventType: updateRemoteStreamVideoCanvas, hasNullProperty");
                nativeUpdateRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, updateRemoteStreamVideoCanvas failed.");
                nativeUpdateRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateRemoteVideoCanvas = NativeRTCVideoFunctions.nativeUpdateRemoteVideoCanvas(this.mNativeEngine, stream_key.getRoomId(), stream_key.getUserId(), stream_key.getStreamIndex().value(), remoteVideoRenderConfig.renderMode, remoteVideoRenderConfig.backgroundColor, remoteVideoRenderConfig.renderRotation.value());
            }
            return nativeUpdateRemoteVideoCanvas;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteVideoCanvas(RemoteStreamKey stream_key, VideoCanvas canvas) {
        int nativeSetRemoteVideoCanvas;
        this.mJniReadLock.lock();
        if (stream_key != null) {
            try {
                if (!stream_key.hasNullProperty()) {
                    if (engineInvalid()) {
                        LogUtil.m216e(TAG, "native engine is invalid, setRemoteVideoCanvas failed.");
                        nativeSetRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
                    } else {
                        if (canvas == null) {
                            canvas = new VideoCanvas();
                        }
                        nativeSetRemoteVideoCanvas = NativeRTCVideoFunctions.nativeSetRemoteVideoCanvas(this.mNativeEngine, stream_key.getRoomId(), stream_key.getUserId(), stream_key.getStreamIndex().value(), canvas.renderView, canvas.renderSurface, canvas.renderMode, canvas.backgroundColor, canvas.renderRotation.value());
                    }
                    this.mJniReadLock.unlock();
                    return nativeSetRemoteVideoCanvas;
                }
            } catch (Throwable th) {
                this.mJniReadLock.unlock();
                throw th;
            }
        }
        LogUtil.m218i(TAG, "EventType: setupRemoteVideo stream_key has null property");
        nativeSetRemoteVideoCanvas = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
        this.mJniReadLock.unlock();
        return nativeSetRemoteVideoCanvas;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteVideoSuperResolution(RemoteStreamKey streamKey, VideoSuperResolutionMode mode) {
        int nativeSetRemoteVideoSuperResolution;
        LogUtil.m215d(TAG, "setRemoteVideoSuperResolution: " + streamKey.toString() + " " + mode.toString());
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setRemoteVideoSuperResolution failed.");
                nativeSetRemoteVideoSuperResolution = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteVideoSuperResolution = NativeRTCVideoFunctions.nativeSetRemoteVideoSuperResolution(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), mode.value());
            }
            return nativeSetRemoteVideoSuperResolution;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoDenoiser(VideoDenoiseMode mode) {
        int nativeSetVideoDenoiser;
        LogUtil.m215d(TAG, "setVideoDenoiser: " + mode.toString());
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoDenoiser failed.");
                nativeSetVideoDenoiser = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoDenoiser = NativeRTCVideoFunctions.nativeSetVideoDenoiser(this.mNativeEngine, mode.value());
            }
            return nativeSetVideoDenoiser;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVideoMirrorType(MirrorType mirrorType) {
        int nativeSetLocalVideoMirrorType;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVideoMirrorType failed.");
                nativeSetLocalVideoMirrorType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalVideoMirrorType = NativeRTCVideoFunctions.nativeSetLocalVideoMirrorType(this.mNativeEngine, mirrorType.value());
            }
            return nativeSetLocalVideoMirrorType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteVideoMirrorType(RemoteStreamKey remoteStreamKey, RemoteMirrorType mirrorType) {
        int nativeSetRemoteVideoMirrorType;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVideoMirrorType failed.");
                nativeSetRemoteVideoMirrorType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteVideoMirrorType = NativeRTCVideoFunctions.nativeSetRemoteVideoMirrorType(this.mNativeEngine, remoteStreamKey.getRoomId(), remoteStreamKey.getUserId(), remoteStreamKey.getStreamIndex().value(), mirrorType.value());
            }
            return nativeSetRemoteVideoMirrorType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoRotationMode(VideoRotationMode rotationMode) {
        int nativeSetVideoRotationMode;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoRotationMode failed.");
                nativeSetVideoRotationMode = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoRotationMode = NativeRTCVideoFunctions.nativeSetVideoRotationMode(this.mNativeEngine, rotationMode.value());
            }
            return nativeSetVideoRotationMode;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int switchCamera(CameraId cameraId) {
        int nativeSwitchCamera;
        LogUtil.m215d(TAG, "switchCamera");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, switchCamera failed.");
                nativeSwitchCamera = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSwitchCamera = NativeRTCVideoFunctions.nativeSwitchCamera(this.mNativeEngine, cameraId.value());
                this.mIsFront = !this.mIsFront;
            }
            return nativeSwitchCamera;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioRoute(AudioRoute audioRoute) {
        int nativeSetAudioRoute;
        LogUtil.m215d(TAG, "setAudioRoute: " + audioRoute.value());
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setAudioRoute failed.");
                nativeSetAudioRoute = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioRoute = NativeRTCVideoFunctions.nativeSetAudioRoute(this.mNativeEngine, audioRoute.value());
            }
            return nativeSetAudioRoute;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public AudioRoute getAudioRoute() {
        LogUtil.m215d(TAG, "getAudioRoute");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getAudioRoute failed.");
                this.mJniReadLock.unlock();
                return null;
            }
            return AudioRoute.fromId(NativeRTCVideoFunctions.nativeGetAudioRoute(this.mNativeEngine));
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableExternalSoundCard(boolean enable) {
        int nativeEnableExternalSoundCard;
        LogUtil.m215d(TAG, "enableExternalSoundCard");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableExternalSoundCard failed.");
                nativeEnableExternalSoundCard = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableExternalSoundCard = NativeRTCVideoFunctions.nativeEnableExternalSoundCard(this.mNativeEngine, enable);
            }
            return nativeEnableExternalSoundCard;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setDefaultAudioRoute(AudioRoute audioRoute) {
        int nativeSetDefaultAudioRoute;
        LogUtil.m215d(TAG, "setDefaultAudioRoute: " + audioRoute.value());
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setDefaultAudioRoute failed.");
                nativeSetDefaultAudioRoute = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetDefaultAudioRoute = NativeRTCVideoFunctions.nativeSetDefaultAudioRoute(this.mNativeEngine, audioRoute.value());
            }
            return nativeSetDefaultAudioRoute;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setPlaybackVolume(int volume) {
        int nativeSetPlaybackVolume;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setPlaybackVolume failed.");
                nativeSetPlaybackVolume = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetPlaybackVolume = NativeRTCVideoFunctions.nativeSetPlaybackVolume(this.mNativeEngine, volume);
            }
            return nativeSetPlaybackVolume;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalVoicePitch(int pitch) {
        int nativeSetLocalVoicePitch;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalVoicePitch failed.");
                nativeSetLocalVoicePitch = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalVoicePitch = NativeRTCVideoFunctions.nativeSetLocalVoicePitch(this.mNativeEngine, pitch);
            }
            return nativeSetLocalVoicePitch;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableVocalInstrumentBalance(boolean enable) {
        int nativeEnableVocalInstrumentBalance;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, EnableVocalInstrumentBalance failed.");
                nativeEnableVocalInstrumentBalance = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableVocalInstrumentBalance = NativeRTCVideoFunctions.nativeEnableVocalInstrumentBalance(this.mNativeEngine, enable);
            }
            return nativeEnableVocalInstrumentBalance;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enablePlaybackDucking(boolean enable) {
        int nativeEnablePlaybackDucking;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, EnablePlaybackDucking failed.");
                nativeEnablePlaybackDucking = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnablePlaybackDucking = NativeRTCVideoFunctions.nativeEnablePlaybackDucking(this.mNativeEngine, enable);
            }
            return nativeEnablePlaybackDucking;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int login(String token, String uid) {
        int nativeLogin;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeLogin = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeLogin = NativeRTCVideoFunctions.nativeLogin(this.mNativeEngine, token, uid);
            }
            return nativeLogin;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int logout() {
        int nativeLogout;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeLogout = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeLogout = NativeRTCVideoFunctions.nativeLogout(this.mNativeEngine);
            }
            return nativeLogout;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateLoginToken(String token) {
        int nativeUpdateLoginToken;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeUpdateLoginToken = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateLoginToken = NativeRTCVideoFunctions.nativeUpdateLoginToken(this.mNativeEngine, token);
            }
            return nativeUpdateLoginToken;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setServerParams(String signature, String url) {
        int nativeSetServerParams;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeSetServerParams = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetServerParams = NativeRTCVideoFunctions.nativeSetServerParams(this.mNativeEngine, signature, url);
            }
            return nativeSetServerParams;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int getPeerOnlineStatus(String peer_user_id) {
        int nativeGetPeerOnlineStatus;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeGetPeerOnlineStatus = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeGetPeerOnlineStatus = NativeRTCVideoFunctions.nativeGetPeerOnlineStatus(this.mNativeEngine, peer_user_id);
            }
            return nativeGetPeerOnlineStatus;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long sendUserMessageOutsideRoom(String uid, String message, MessageConfig config) {
        long nativeSendUserMessageOutsideRoom;
        int value;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (uid == null) {
                LogUtil.m216e(TAG, "sendUserMessageOutsideRoom: uid is null send failed");
                value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSendUserMessageOutsideRoom = NativeRTCVideoFunctions.nativeSendUserMessageOutsideRoom(this.mNativeEngine, uid, message, config.value());
                return nativeSendUserMessageOutsideRoom;
            }
            nativeSendUserMessageOutsideRoom = value;
            return nativeSendUserMessageOutsideRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long sendUserBinaryMessageOutsideRoom(String uid, byte[] buffer, MessageConfig config) {
        long nativeSendUserBinaryMessageOutsideRoom;
        int value;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (uid == null) {
                LogUtil.m216e(TAG, "sendUserBinaryMessageOutsideRoom: uid is null send failed");
                value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSendUserBinaryMessageOutsideRoom = NativeRTCVideoFunctions.nativeSendUserBinaryMessageOutsideRoom(this.mNativeEngine, uid, buffer, config.value());
                return nativeSendUserBinaryMessageOutsideRoom;
            }
            nativeSendUserBinaryMessageOutsideRoom = value;
            return nativeSendUserBinaryMessageOutsideRoom;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long sendServerMessage(String message) {
        long nativeSendServerMessage;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeSendServerMessage = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSendServerMessage = NativeRTCVideoFunctions.nativeSendServerMessage(this.mNativeEngine, message);
            }
            return nativeSendServerMessage;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long sendServerBinaryMessage(byte[] buffer) {
        long nativeSendServerBinaryMessage;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendBinaryMessage failed.");
                nativeSendServerBinaryMessage = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSendServerBinaryMessage = NativeRTCVideoFunctions.nativeSendServerBinaryMessage(this.mNativeEngine, buffer);
            }
            return nativeSendServerBinaryMessage;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startNetworkDetection(boolean isTestUplink, int expectedUplinkBitrate, boolean isTestDownlink, int expectedDownlinkBitrate) {
        int nativeStartNetworkProbe;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendCustomMessage failed.");
                nativeStartNetworkProbe = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartNetworkProbe = NativeRTCVideoFunctions.nativeStartNetworkProbe(this.mNativeEngine, isTestUplink, expectedUplinkBitrate, isTestDownlink, expectedDownlinkBitrate);
            }
            return nativeStartNetworkProbe;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopNetworkDetection() {
        int nativeStopNetworkProbe;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendCustomMessage failed.");
                nativeStopNetworkProbe = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopNetworkProbe = NativeRTCVideoFunctions.nativeStopNetworkProbe(this.mNativeEngine);
            }
            return nativeStopNetworkProbe;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAudioFrameCallback(AudioFrameCallbackMethod method, AudioFormat format) {
        int nativeEnableAudioFrameCallback;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableAudioFrameCallback failed.");
                nativeEnableAudioFrameCallback = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableAudioFrameCallback = NativeRTCVideoFunctions.nativeEnableAudioFrameCallback(this.mNativeEngine, method.value(), format.sampleRate.value(), format.channel.value());
            }
            return nativeEnableAudioFrameCallback;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int disableAudioFrameCallback(AudioFrameCallbackMethod method) {
        int nativeDisableAudioFrameCallback;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, disableAudioFrameCallback failed.");
                nativeDisableAudioFrameCallback = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeDisableAudioFrameCallback = NativeRTCVideoFunctions.nativeDisableAudioFrameCallback(this.mNativeEngine, method.value());
            }
            return nativeDisableAudioFrameCallback;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int registerAudioFrameObserver(IAudioFrameObserver observer) {
        int nativeSetAudioFrameObserver;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerAudioFrameObserver failed.");
                nativeSetAudioFrameObserver = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioFrameObserver = NativeRTCVideoFunctions.nativeSetAudioFrameObserver(this.mNativeEngine, observer);
            }
            return nativeSetAudioFrameObserver;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public void registerRemoteEncodedAudioFrameObserver(IRemoteEncodedAudioFrameObserver observer) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerRemoteEncodedAudioFrameObserver failed.");
            } else {
                NativeRTCVideoFunctions.nativeSetRemoteEncodedAudioFrameObserver(this.mNativeEngine, observer);
            }
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int registerAudioProcessor(IAudioFrameProcessor audioFrameProcessor) {
        int nativeSetAudioFrameProcessor;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerAudioProcessor failed.");
                nativeSetAudioFrameProcessor = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioFrameProcessor = NativeRTCVideoFunctions.nativeSetAudioFrameProcessor(this.mNativeEngine, audioFrameProcessor);
            }
            return nativeSetAudioFrameProcessor;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAudioProcessor(AudioProcessorMethod method, AudioFormat format) {
        int nativeEnableAudioProcessor;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableAudioProcessor failed.");
                nativeEnableAudioProcessor = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableAudioProcessor = NativeRTCVideoFunctions.nativeEnableAudioProcessor(this.mNativeEngine, method.value(), format.sampleRate.value(), format.channel.value(), format.samplesPerCall);
            }
            return nativeEnableAudioProcessor;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int disableAudioProcessor(AudioProcessorMethod method) {
        int nativeDisableAudioProcessor;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, disableAudioProcessor failed.");
                nativeDisableAudioProcessor = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeDisableAudioProcessor = NativeRTCVideoFunctions.nativeDisableAudioProcessor(this.mNativeEngine, method.value());
            }
            return nativeDisableAudioProcessor;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoDigitalZoomConfig(ZoomConfigType type, float size) {
        int nativeSetVideoDigitalZoomConfig;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoDigitalZoomConfig failed.");
                nativeSetVideoDigitalZoomConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoDigitalZoomConfig = NativeRTCVideoFunctions.nativeSetVideoDigitalZoomConfig(this.mNativeEngine, type.value(), size);
            }
            return nativeSetVideoDigitalZoomConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoDigitalZoomControl(ZoomDirectionType direction) {
        int nativeSetVideoDigitalZoomControl;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoDigitalZoomControl failed.");
                nativeSetVideoDigitalZoomControl = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoDigitalZoomControl = NativeRTCVideoFunctions.nativeSetVideoDigitalZoomControl(this.mNativeEngine, direction.value());
            }
            return nativeSetVideoDigitalZoomControl;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startVideoDigitalZoomControl(ZoomDirectionType direction) {
        int nativeStartVideoDigitalZoomControl;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startVideoDigitalZoomControl failed.");
                nativeStartVideoDigitalZoomControl = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartVideoDigitalZoomControl = NativeRTCVideoFunctions.nativeStartVideoDigitalZoomControl(this.mNativeEngine, direction.value());
            }
            return nativeStartVideoDigitalZoomControl;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopVideoDigitalZoomControl() {
        int nativeStopVideoDigitalZoomControl;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopVideoDigitalZoomControl failed.");
                nativeStopVideoDigitalZoomControl = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopVideoDigitalZoomControl = NativeRTCVideoFunctions.nativeStopVideoDigitalZoomControl(this.mNativeEngine);
            }
            return nativeStopVideoDigitalZoomControl;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007f A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0020, B:11:0x0025, B:13:0x002b, B:15:0x0031, B:17:0x0037, B:18:0x003e, B:20:0x0044, B:22:0x004a, B:23:0x0051, B:25:0x0057, B:27:0x005b, B:30:0x0062, B:31:0x0079, B:33:0x007f, B:34:0x008f, B:35:0x0065, B:36:0x006c, B:38:0x0070, B:41:0x0077, B:42:0x009f), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[Catch: all -> 0x00a7, TryCatch #0 {all -> 0x00a7, blocks: (B:3:0x0005, B:5:0x000b, B:10:0x0020, B:11:0x0025, B:13:0x002b, B:15:0x0031, B:17:0x0037, B:18:0x003e, B:20:0x0044, B:22:0x004a, B:23:0x0051, B:25:0x0057, B:27:0x005b, B:30:0x0062, B:31:0x0079, B:33:0x007f, B:34:0x008f, B:35:0x0065, B:36:0x006c, B:38:0x0070, B:41:0x0077, B:42:0x009f), top: B:2:0x0005 }] */
    @Override // com.ss.bytertc.engine.RTCEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int registerLocalVideoProcessor(IVideoProcessor processor, VideoPreprocessorConfig config) {
        int value;
        RTCVideoProcessor rTCVideoProcessor;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerLocalVideoProcessor failed.");
                value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                if (config == null) {
                    config = new VideoPreprocessorConfig();
                }
                if (config.requiredPixelFormat != VideoPixelFormat.UNKNOWN && config.requiredPixelFormat != VideoPixelFormat.I420 && config.requiredPixelFormat != VideoPixelFormat.TEXTURE_2D) {
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else if (config.streamIndex != StreamIndex.STREAM_INDEX_MAIN && config.streamIndex != StreamIndex.STREAM_INDEX_SCREEN) {
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else if (config.streamIndex == StreamIndex.STREAM_INDEX_MAIN) {
                    RTCVideoProcessor rTCVideoProcessor2 = this.mRtcVideoPreprocessor;
                    if (rTCVideoProcessor2 != null && rTCVideoProcessor2.registerLocalVideoProcessor(processor) == 0) {
                        rTCVideoProcessor = this.mRtcVideoPreprocessor;
                        VideoPixelFormat videoPixelFormat = config.requiredPixelFormat;
                        StreamIndex streamIndex = config.streamIndex;
                        if (processor != null) {
                            value = NativeRTCVideoFunctions.nativeRegisterLocalVideoProcessor(this.mNativeEngine, null, videoPixelFormat.value(), streamIndex.value());
                        } else {
                            value = NativeRTCVideoFunctions.nativeRegisterLocalVideoProcessor(this.mNativeEngine, rTCVideoProcessor, videoPixelFormat.value(), streamIndex.value());
                        }
                    }
                    value = ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
                } else {
                    RTCVideoProcessor rTCVideoProcessor3 = this.mRtcVideoScreenPreprocessor;
                    if (rTCVideoProcessor3 != null && rTCVideoProcessor3.registerLocalVideoProcessor(processor) == 0) {
                        rTCVideoProcessor = this.mRtcVideoScreenPreprocessor;
                        VideoPixelFormat videoPixelFormat2 = config.requiredPixelFormat;
                        StreamIndex streamIndex2 = config.streamIndex;
                        if (processor != null) {
                        }
                    }
                    value = ReturnStatus.RETURN_STATUS_WRONG_STATE.value();
                }
            }
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int registerLocalEncodedVideoFrameObserver(ILocalEncodedVideoFrameObserver observer) {
        int nativeRegisterLocalEncodedVideoFrameObserver;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerAudioFrameObserver failed.");
                nativeRegisterLocalEncodedVideoFrameObserver = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mLocalEncodedVideoFrameObserver = observer;
                if (observer == null) {
                    nativeRegisterLocalEncodedVideoFrameObserver = NativeRTCVideoFunctions.nativeRegisterLocalEncodedVideoFrameObserver(this.mNativeEngine, null);
                } else {
                    nativeRegisterLocalEncodedVideoFrameObserver = NativeRTCVideoFunctions.nativeRegisterLocalEncodedVideoFrameObserver(this.mNativeEngine, this.mRtcLocalEncodedVideoFrameObserver);
                }
            }
            return nativeRegisterLocalEncodedVideoFrameObserver;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int registerRemoteEncodedVideoFrameObserver(IRemoteEncodedVideoFrameObserver observer) {
        int nativeRegisterRemoteEncodedVideoFrameObserver;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, RegisterRemoteEncodedVideoFrameObserver failed.");
                nativeRegisterRemoteEncodedVideoFrameObserver = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mRemoteEncodedVideoFrameObserver = observer;
                if (observer == null) {
                    nativeRegisterRemoteEncodedVideoFrameObserver = NativeRTCVideoFunctions.nativeRegisterRemoteEncodedVideoFrameObserver(this.mNativeEngine, null);
                } else {
                    nativeRegisterRemoteEncodedVideoFrameObserver = NativeRTCVideoFunctions.nativeRegisterRemoteEncodedVideoFrameObserver(this.mNativeEngine, this.mRtcRemoteEncodedVideoFrameObserver);
                }
            }
            return nativeRegisterRemoteEncodedVideoFrameObserver;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoSourceType(StreamIndex index, VideoSourceType type) {
        int nativeSetVideoSourceTypeWithStreamId;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoInputType failed.");
                nativeSetVideoSourceTypeWithStreamId = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoSourceTypeWithStreamId = NativeRTCVideoFunctions.nativeSetVideoSourceTypeWithStreamId(this.mNativeEngine, index.value(), type.value());
            }
            return nativeSetVideoSourceTypeWithStreamId;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushExternalVideoFrame(VideoFrameData vfd) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (vfd == null) {
                    LogUtil.m218i(TAG, "pushExternalVideoFrame: videoFrame is null, drop frame.");
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    ReturnStatus returnStatus = ReturnStatus.RETURN_STATUS_SUCCESS;
                    value = ReturnStatus.fromId(NativeRTCVideoFunctions.nativePushExternalVideoFrame(this.mNativeEngine, vfd)).value();
                }
                return value;
            }
            LogUtil.m216e(TAG, "pushExternalVideoFrame: native engine is invalid, pushExternalVideoFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startChorusCacheSync(ChorusCacheSyncConfig chorusConfig, IChorusCacheSyncObserver chorusObserver) {
        int nativeStartChorusCacheSync;
        this.mJniReadLock.lock();
        if (chorusObserver != null) {
            try {
                this.mChorusObserver.setUserObserver(chorusObserver);
            } catch (Throwable th) {
                this.mJniReadLock.unlock();
                throw th;
            }
        }
        LogUtil.m215d(TAG, "startChorusCacheSync...");
        if (chorusConfig == null) {
            LogUtil.m215d(TAG, "startChorusCacheSync...chorusConfig is null, no effect, please check.");
            nativeStartChorusCacheSync = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
        } else if (engineInvalid()) {
            LogUtil.m216e(TAG, "native engine is invalid, startChorusCacheSync failed.");
            nativeStartChorusCacheSync = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        } else {
            nativeStartChorusCacheSync = NativeRTCVideoFunctions.nativeStartChorusCacheSync(this.mNativeEngine, chorusConfig, this.mChorusObserver);
        }
        this.mJniReadLock.unlock();
        return nativeStartChorusCacheSync;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopChorusCacheSync() {
        int nativeStopChorusCacheSync;
        LogUtil.m215d(TAG, "stopChorusCacheSync...");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopChorusCacheSync failed.");
                nativeStopChorusCacheSync = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopChorusCacheSync = NativeRTCVideoFunctions.nativeStopChorusCacheSync(this.mNativeEngine);
            }
            return nativeStopChorusCacheSync;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushClientMixedStreamExternalVideoFrame(String uid, VideoFrameData frame) {
        int value;
        LogUtil.m215d(TAG, "pushExternalVideoFrame");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (frame == null) {
                    LogUtil.m218i(TAG, "pushClientMixedStreamExternalVideoFrame: videoFrame is null, drop frame.");
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    ReturnStatus returnStatus = ReturnStatus.RETURN_STATUS_SUCCESS;
                    value = ReturnStatus.fromId(NativeRTCVideoFunctions.nativePushClientMixedStreamExternalVideoFrame(this.mNativeEngine, uid, frame)).value();
                }
                return value;
            }
            LogUtil.m216e(TAG, "pushClientMixedStreamExternalVideoFrame: native engine is invalid, pushExternalVideoFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setClientMixedStreamObserver(IClientMixedStreamObserver observer) {
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "setClientMixedStreamObserver...");
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setClientMixedStreamObserver failed.");
                this.mJniReadLock.unlock();
                return -1;
            }
            LogUtil.m215d(TAG, "setClientMixedStreamObserver...");
            this.mMixedStreamToCDNObserver.setUserObserver(observer);
            return NativeRTCVideoFunctions.nativeSetClientMixedStreamObserver(this.mNativeEngine, this.mMixedStreamToCDNObserver);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startClientMixedStream(String taskId, MixedStreamConfig mixedConfig, ClientMixedStreamConfig extra_config) {
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "startClientMixedStream...");
            if (mixedConfig != null && extra_config != null) {
                if (engineInvalid()) {
                    LogUtil.m216e(TAG, "native engine is invalid, startClientMixedStream failed.");
                } else {
                    this.mEnableTranscode = true;
                    if (mixedConfig.getTranscodeMessage() != null) {
                        LogUtil.m215d(TAG, "startClientMixedStream...");
                        return NativeRTCVideoFunctions.nativeStartClientMixedStream(this.mNativeEngine, taskId, mixedConfig, extra_config);
                    }
                }
                return -1;
            }
            LogUtil.m215d(TAG, "startClientMixedStream...liveTranscode is null, no effect, please check.");
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateClientMixedStream(String taskId, MixedStreamConfig mixedConfig, ClientMixedStreamConfig extra_config) {
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "updateClientMixedStream...");
            if (mixedConfig != null && extra_config != null) {
                if (engineInvalid()) {
                    LogUtil.m216e(TAG, "native engine is invalid, updateClientMixedStream failed.");
                } else if (mixedConfig.getTranscodeMessage() != null) {
                    LogUtil.m215d(TAG, "updateClientMixedStream...");
                    return NativeRTCVideoFunctions.nativeUpdateClientMixedStream(this.mNativeEngine, taskId, mixedConfig, extra_config);
                }
                return -1;
            }
            LogUtil.m215d(TAG, "updateClientMixedStream...mLiveTranscoding is null, no effect, please check.");
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopPushMixedStream(String taskId, MixedStreamPushTargetType targetType) {
        int nativeStopPushMixedStream;
        LogUtil.m215d(TAG, "stopPushMixedStream...");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopPushMixedStream failed.");
                nativeStopPushMixedStream = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopPushMixedStream = NativeRTCVideoFunctions.nativeStopPushMixedStream(this.mNativeEngine, taskId, targetType.value());
            }
            return nativeStopPushMixedStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startPushMixedStream(String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig liveTranscode) {
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "startPushMixedStream...");
            if (liveTranscode == null) {
                LogUtil.m215d(TAG, "startPushMixedStream...liveTranscode is null, no effect, please check.");
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startPushMixedStream failed.");
            } else {
                this.mEnableTranscode = true;
                if (liveTranscode.getTranscodeMessage() != null) {
                    LogUtil.m215d(TAG, "startPushMixedStream...");
                    return NativeRTCVideoFunctions.nativeStartPushMixedStream(this.mNativeEngine, taskId, pushTargetConfig, liveTranscode);
                }
            }
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopClientMixedStream(String taskId) {
        int nativeStopClientMixedStream;
        LogUtil.m215d(TAG, "stopClientMixedStream...");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopClientMixedStream failed.");
                nativeStopClientMixedStream = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopClientMixedStream = NativeRTCVideoFunctions.nativeStopClientMixedStream(this.mNativeEngine, taskId);
            }
            return nativeStopClientMixedStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updatePushMixedStream(String taskId, MixedStreamPushTargetConfig pushTargetConfig, MixedStreamConfig transcoding) {
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "updatePushMixedStream...");
            if (transcoding == null) {
                LogUtil.m215d(TAG, "updatePushMixedStream...mLiveTranscoding is null, no effect, please check.");
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, updatePushMixedStream failed.");
            } else if (transcoding.getTranscodeMessage() != null) {
                LogUtil.m215d(TAG, "updatePushMixedStream...");
                return NativeRTCVideoFunctions.nativeUpdatePushMixedStream(this.mNativeEngine, taskId, pushTargetConfig, transcoding);
            }
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startPushSingleStream(final String taskId, final PushSingleStreamParam param) {
        int nativeStartPushSingleStream;
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "startPushSingleStream...");
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startPushSingleStream failed.");
                nativeStartPushSingleStream = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartPushSingleStream = NativeRTCVideoFunctions.nativeStartPushSingleStream(this.mNativeEngine, taskId, param.roomId, param.userId, param.url, param.isScreen);
            }
            return nativeStartPushSingleStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopPushSingleStream(final String taskId) {
        int nativeStopPushSingleStream;
        LogUtil.m215d(TAG, "stopPushSingleStream...");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopPushSingleStream failed.");
                nativeStopPushSingleStream = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopPushSingleStream = NativeRTCVideoFunctions.nativeStopPushSingleStream(this.mNativeEngine, taskId);
            }
            return nativeStopPushSingleStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoCaptureConfig(VideoCaptureConfig videoCaptureConfig) {
        int nativeSetVideoCaptureConfig;
        this.mJniReadLock.lock();
        try {
            if (videoCaptureConfig == null) {
                LogUtil.m216e(TAG, "native engine is invalid or videoCaptureConfig is null, setVideoCaptureConfig failed.");
                nativeSetVideoCaptureConfig = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid or videoCaptureConfig is null, setVideoCaptureConfig failed.");
                nativeSetVideoCaptureConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "setVideoCaptureConfig: " + videoCaptureConfig.toString());
                nativeSetVideoCaptureConfig = NativeRTCVideoFunctions.nativeSetVideoCaptureConfig(this.mNativeEngine, new InternalVideoCaptureConfig(videoCaptureConfig.capturePreference.getValue(), videoCaptureConfig.width, videoCaptureConfig.height, videoCaptureConfig.frameRate));
            }
            return nativeSetVideoCaptureConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setVideoEncoderConfig(StreamIndex streamIndex, List<VideoEncoderConfig> videoEncoderConfigs) {
        int nativeSetVideoEncoderConfig;
        this.mJniReadLock.lock();
        if (videoEncoderConfigs == null) {
            try {
                videoEncoderConfigs = new ArrayList<>();
            } finally {
                this.mJniReadLock.unlock();
            }
        }
        if (engineInvalid()) {
            LogUtil.m216e(TAG, "native engine is invalid, setVideoResolutions failed.");
            nativeSetVideoEncoderConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<VideoEncoderConfig> it = videoEncoderConfigs.iterator();
            while (true) {
                if (it.hasNext()) {
                    VideoEncoderConfig next = it.next();
                    if (streamIndex == StreamIndex.STREAM_INDEX_MAIN && !next.isValid()) {
                        LogUtil.m216e(TAG, "setVideoResolutions with illegal params");
                        nativeSetVideoEncoderConfig = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                        break;
                    }
                    arrayList.add(new InternalVideoEncoderConfig(next));
                } else {
                    nativeSetVideoEncoderConfig = NativeRTCVideoFunctionsEx.nativeSetVideoEncoderConfig(this.mNativeEngine, streamIndex.value(), arrayList);
                    break;
                }
            }
        }
        return nativeSetVideoEncoderConfig;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoEncoderConfig(VideoEncoderConfig encoderConfig, JSONObject parameters) {
        int nativeSetVideoEncoderConfigV1;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoResolutions failed.");
                nativeSetVideoEncoderConfigV1 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoEncoderConfigV1 = NativeRTCVideoFunctions.nativeSetVideoEncoderConfigV1(this.mNativeEngine, new InternalVideoEncoderConfig(encoderConfig), parameters != null ? parameters.toString() : "");
            }
            return nativeSetVideoEncoderConfigV1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoEncoderConfig(VideoEncoderConfig encoderConfig) {
        return setVideoEncoderConfig(encoderConfig, (JSONObject) null);
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalSimulcastMode(VideoSimulcastMode mode) {
        int nativeSetLocalSimulcastMode;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setLocalSimulcastMode failed.");
                nativeSetLocalSimulcastMode = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetLocalSimulcastMode = NativeRTCVideoFunctions.nativeSetLocalSimulcastMode(this.mNativeEngine, mode.value());
            }
            return nativeSetLocalSimulcastMode;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalSimulcastMode(VideoSimulcastMode mode, VideoEncoderConfig[] streamConfig) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                if (streamConfig == null || mode == null) {
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    ArrayList arrayList = new ArrayList();
                    int length = streamConfig.length;
                    int i = 0;
                    while (true) {
                        if (i < length) {
                            VideoEncoderConfig videoEncoderConfig = streamConfig[i];
                            if (!videoEncoderConfig.isValid()) {
                                LogUtil.m216e(TAG, "setVideoEncoderConfig with illegal params");
                                value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                                break;
                            }
                            arrayList.add(new InternalVideoEncoderConfig(videoEncoderConfig));
                            i++;
                        } else {
                            value = NativeRTCVideoFunctions.nativeSetLocalSimulcastModeV1(this.mNativeEngine, mode.value(), arrayList);
                            break;
                        }
                    }
                }
            } else {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoEncoderConfig failed.");
                value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            }
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setScreenVideoEncoderConfig(VideoEncoderConfig screen_solution) {
        int nativeSetScreenVideoEncoderConfig;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setScreenVideoEncoderConfig failed.");
                nativeSetScreenVideoEncoderConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                if (screen_solution.encodePreference == VideoEncoderConfig.EncoderPreference.AUTO) {
                    screen_solution.encodePreference = VideoEncoderConfig.EncoderPreference.DISABLED;
                }
                nativeSetScreenVideoEncoderConfig = NativeRTCVideoFunctions.nativeSetScreenVideoEncoderConfig(this.mNativeEngine, new InternalVideoEncoderConfig(screen_solution));
            }
            return nativeSetScreenVideoEncoderConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAlphaChannelVideoEncode(StreamIndex streamIndex, AlphaLayout layout) {
        int value;
        LogUtil.m215d(TAG, "enableAlphaChannelVideoEncode");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (layout == null) {
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    value = NativeRTCVideoFunctions.nativeEnableAlphaChannelVideoEncode(this.mNativeEngine, streamIndex.value(), layout.value());
                }
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, enableAlphaChannelVideoEncode failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int disableAlphaChannelVideoEncode(StreamIndex streamIndex) {
        int value;
        LogUtil.m215d(TAG, "disableAlphaChannelVideoEncode");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeDisableAlphaChannelVideoEncode(this.mNativeEngine, streamIndex.value());
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, disableAlphaChannelVideoEncode failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushExternalEncodedAudioFrame(EncodedAudioFrameData audioFrame) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (audioFrame.extraInfo != null) {
                    value = NativeRTCVideoFunctions.nativePushExternalEncodedAudioFrame(this.mNativeEngine, audioFrame.codecType.value(), audioFrame.data, audioFrame.size, audioFrame.timestampUs, audioFrame.sampleRate.value(), audioFrame.channelNum.value(), audioFrame.frameSizeMs, audioFrame.extraInfo, audioFrame.extraInfo.capacity());
                } else {
                    value = NativeRTCVideoFunctions.nativePushExternalEncodedAudioFrame(this.mNativeEngine, audioFrame.codecType.value(), audioFrame.data, audioFrame.size, audioFrame.timestampUs, audioFrame.sampleRate.value(), audioFrame.channelNum.value(), audioFrame.frameSizeMs, null, 0);
                }
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, pushExternalEncodedAudioFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public void enableAudioEncoding(boolean enable) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                NativeRTCVideoFunctions.nativeEnableAudioEncoding(this.mNativeEngine, enable);
                return;
            }
            LogUtil.m216e(TAG, "native engine is invalid, enableAudioEncoding failed.");
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public void enableAudioDecoding(boolean enable) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                NativeRTCVideoFunctions.nativeEnableAudioDecoding(this.mNativeEngine, enable);
                return;
            }
            LogUtil.m216e(TAG, "native engine is invalid, enableAudioDecoding failed.");
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushExternalAudioFrame(AudioFrame audioFrame) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativePushExternalAudioFrame(this.mNativeEngine, audioFrame.buffer, audioFrame.samples, audioFrame.sampleRate.value(), audioFrame.channel.value(), audioFrame.extraInfo);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, pushExternalAudioFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pullExternalAudioFrame(AudioFrame audioFrame) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativePullExternalAudioFrame(this.mNativeEngine, audioFrame.buffer, audioFrame.samples, audioFrame.sampleRate.value(), audioFrame.channel.value());
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, pullExternalAudioFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioSourceType(AudioSourceType type) {
        int nativeSetAudioSourceType;
        LogUtil.m215d(TAG, "SetAudioSourceType");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetAudioSourceType failed.");
                nativeSetAudioSourceType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioSourceType = NativeRTCVideoFunctions.nativeSetAudioSourceType(this.mNativeEngine, type.value());
            }
            return nativeSetAudioSourceType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioRenderType(AudioRenderType type) {
        int nativeSetAudioRenderType;
        LogUtil.m215d(TAG, "SetAudioRenderType");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetAudioRenderType failed.");
                nativeSetAudioRenderType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioRenderType = NativeRTCVideoFunctions.nativeSetAudioRenderType(this.mNativeEngine, type.value());
            }
            return nativeSetAudioRenderType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushScreenVideoFrame(VideoFrameData frame) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (frame == null) {
                    LogUtil.m218i(TAG, "pushScreenVideoFrame: videoFrame is null, drop frame.");
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    value = ReturnStatus.fromId(NativeRTCVideoFunctions.nativePushScreenFrame(this.mNativeEngine, frame)).value();
                }
                return value;
            }
            LogUtil.m216e(TAG, "pushScreenVideoFrame: native engine is invalid, pushExternalVideoFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteAudioPlaybackVolume(RemoteStreamKey streamKey, int volume) {
        LogUtil.m215d(TAG, "setRemoteAudioPlaybackVolume");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (streamKey.getRoomId() == null) {
                    LogUtil.m216e(TAG, "setRemoteAudioPlaybackVolume: roomId is null adjust failed");
                    return ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                }
                if (streamKey.getUserId() != null) {
                    return NativeRTCVideoFunctions.nativeSetRemoteAudioPlaybackVolume(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), volume);
                }
                LogUtil.m216e(TAG, "setRemoteAudioPlaybackVolume: uid is null adjust failed");
                return ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            }
            LogUtil.m216e(TAG, "native engine is invalid, setRemoteAudioPlaybackVolume failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setAudioAlignmentProperty(RemoteStreamKey streamKey, AudioAlignmentMode mode) {
        int nativeSetAudioAlignmentProperty;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setAudioAlignmentProperty failed.");
                nativeSetAudioAlignmentProperty = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (streamKey == null) {
                LogUtil.m216e(TAG, "setAudioAlignmentProperty: streamKey is null");
                nativeSetAudioAlignmentProperty = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSetAudioAlignmentProperty = NativeRTCVideoFunctions.nativeSetAudioAlignmentProperty(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), mode.value());
            }
            return nativeSetAudioAlignmentProperty;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public RTCRoom createRTCRoom(String roomId) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, createRoom failed.");
            } else {
                if (roomId == null) {
                    roomId = "";
                }
                long nativeCreateRoom = NativeRTCVideoFunctions.nativeCreateRoom(this.mNativeEngine, roomId);
                if (nativeCreateRoom == 0) {
                    LogUtil.m216e(TAG, "createRoom failed, native room is invalid");
                } else {
                    Map<String, RTCRoomImpl> map = this.mRoomMap;
                    if (map != null && map.containsKey(roomId)) {
                        RTCRoomImpl rTCRoomImpl = this.mRoomMap.get(roomId);
                        if (rTCRoomImpl.getNativeHandle() == 0) {
                            this.mRoomMap.remove(roomId);
                        } else {
                            rTCRoomImpl.addRtcRoomCount();
                            return this.mRoomMap.get(roomId);
                        }
                    }
                    RTCRoomImpl rTCRoomImpl2 = new RTCRoomImpl(roomId, nativeCreateRoom);
                    this.mRoomMap.put(roomId, rTCRoomImpl2);
                    return rTCRoomImpl2;
                }
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public RTSRoom createRTSRoom(String roomId) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, createRoom failed.");
            } else {
                if (roomId == null) {
                    roomId = "";
                }
                long nativeCreateRtsRoom = NativeRTCVideoFunctions.nativeCreateRtsRoom(this.mNativeEngine, roomId);
                if (nativeCreateRtsRoom == 0) {
                    LogUtil.m216e(TAG, "createRoom failed, native room is invalid");
                } else {
                    RTSRoomImpl rTSRoomImpl = new RTSRoomImpl(roomId, nativeCreateRtsRoom);
                    this.mRoomRtsLists.add(rTSRoomImpl);
                    return rTSRoomImpl;
                }
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public RTCRoomEx createRTCRoomEx(String roomId) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, createRoom failed.");
            } else {
                if (roomId == null) {
                    roomId = "";
                }
                long nativeCreateRoomEx = NativeRTCVideoFunctions.nativeCreateRoomEx(this.mNativeEngine, roomId);
                if (nativeCreateRoomEx == 0) {
                    LogUtil.m216e(TAG, "createRoom failed, native room is invalid");
                } else {
                    Map<String, RTCRoomImpl> map = this.mRoomMap;
                    if (map != null && map.containsKey(roomId)) {
                        RTCRoomImpl rTCRoomImpl = this.mRoomMap.get(roomId);
                        if (rTCRoomImpl.getNativeHandle() == 0) {
                            this.mRoomMap.remove(roomId);
                        } else {
                            rTCRoomImpl.addRtcRoomCount();
                            return this.mRoomMap.get(roomId);
                        }
                    }
                    RTCRoomImpl rTCRoomImpl2 = new RTCRoomImpl(roomId, nativeCreateRoomEx);
                    this.mRoomMap.put(roomId, rTCRoomImpl2);
                    return rTCRoomImpl2;
                }
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setPublishFallbackOption(PublishFallbackOption option) {
        int nativeSetPublishFallbackOption;
        LogUtil.m215d(TAG, "setPublishFallbackOption: option: " + option);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setPublishFallbackOption failed.");
                nativeSetPublishFallbackOption = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetPublishFallbackOption = NativeRTCVideoFunctions.nativeSetPublishFallbackOption(this.mNativeEngine, option.value());
            }
            return nativeSetPublishFallbackOption;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setSubscribeFallbackOption(SubscribeFallbackOptions option) {
        int nativeSetRemoteSubscribeFallbackOption;
        LogUtil.m215d(TAG, "setRemoteSubscribeFallbackOption: option: " + option);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setRemoteSubscribeFallbackOption failed.");
                nativeSetRemoteSubscribeFallbackOption = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRemoteSubscribeFallbackOption = NativeRTCVideoFunctions.nativeSetRemoteSubscribeFallbackOption(this.mNativeEngine, option.value());
            }
            return nativeSetRemoteSubscribeFallbackOption;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRemoteUserPriority(String roomId, String uid, RemoteUserPriority priority) {
        int nativeSetRemoteUserPriority;
        LogUtil.m215d(TAG, "setRemoteUserPriority: uid: " + uid + ", priority: " + priority);
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setRemoteUserPriority failed.");
                nativeSetRemoteUserPriority = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else if (uid == null) {
                LogUtil.m216e(TAG, "setRemoteUserPriority: uid is null set failed");
                nativeSetRemoteUserPriority = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
            } else {
                nativeSetRemoteUserPriority = NativeRTCVideoFunctions.nativeSetRemoteUserPriority(this.mNativeEngine, roomId, uid, priority.value());
            }
            return nativeSetRemoteUserPriority;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCaptureVolume(StreamIndex index, int volume) {
        int nativeSetCaptureVolume;
        LogUtil.m215d(TAG, "setCaptureVolume");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setCaptureVolume failed.");
                nativeSetCaptureVolume = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetCaptureVolume = NativeRTCVideoFunctions.nativeSetCaptureVolume(this.mNativeEngine, volume, index.value());
            }
            return nativeSetCaptureVolume;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int muteAudioCapture(StreamIndex index, boolean mute) {
        int nativeMuteAudioCapture;
        LogUtil.m215d(TAG, "muteAudioCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, muteAudioCapture failed.");
                nativeMuteAudioCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeMuteAudioCapture = NativeRTCVideoFunctions.nativeMuteAudioCapture(this.mNativeEngine, index.value(), mute);
            }
            return nativeMuteAudioCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int sendSEIMessage(StreamIndex streamIndex, byte[] message, int repeatCount, SEICountPerFrame mode) {
        int nativeSendMultiSEIMessagePerVideoFrame;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerMetadataObserver failed.");
                nativeSendMultiSEIMessagePerVideoFrame = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSendMultiSEIMessagePerVideoFrame = NativeRTCVideoFunctions.nativeSendMultiSEIMessagePerVideoFrame(this.mNativeEngine, streamIndex.value(), message, repeatCount, mode.value());
            }
            return nativeSendMultiSEIMessagePerVideoFrame;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int sendSEIMessage(StreamIndex streamIndex, byte[] message, int repeatCount) {
        int nativeSendSEIMessage;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, registerMetadataObserver failed.");
                nativeSendSEIMessage = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSendSEIMessage = NativeRTCVideoFunctions.nativeSendSEIMessage(this.mNativeEngine, streamIndex.value(), message, repeatCount);
            }
            return nativeSendSEIMessage;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int sendPublicStreamSEIMessage(StreamIndex streamIndex, int channelId, byte[] message, int repeatCount, SEICountPerFrame mode) {
        int nativeSendPublicStreamSEIMessage;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, sendPublicStreamSEIMessage failed.");
                nativeSendPublicStreamSEIMessage = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSendPublicStreamSEIMessage = NativeRTCVideoFunctions.nativeSendPublicStreamSEIMessage(this.mNativeEngine, streamIndex.value(), channelId, message, repeatCount, mode.value());
            }
            return nativeSendPublicStreamSEIMessage;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setBusinessId(String businessId) {
        int nativeSetBusinessId;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setBusinessId failed.");
                nativeSetBusinessId = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetBusinessId = NativeRTCVideoFunctions.nativeSetBusinessId(this.mNativeEngine, businessId);
            }
            return nativeSetBusinessId;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setEncryptInfo(int aesType, String key) {
        int nativeSetEncryptInfo;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setEncryptInfo failed.");
                nativeSetEncryptInfo = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetEncryptInfo = NativeRTCVideoFunctions.nativeSetEncryptInfo(this.mNativeEngine, aesType, key);
            }
            return nativeSetEncryptInfo;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCustomizeEncryptHandler(RTCEncryptHandler handler) {
        int nativeSetCustomizeEncryptHandler;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setCustomizeEncryptHandler failed.");
                nativeSetCustomizeEncryptHandler = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetCustomizeEncryptHandler = NativeRTCVideoFunctions.nativeSetCustomizeEncryptHandler(this.mNativeEngine, handler);
            }
            return nativeSetCustomizeEncryptHandler;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public IVideoEffect getVideoEffectInterface() {
        LogUtil.m215d(TAG, "getVideoEffectInterface");
        return this.mAdvanceVideoEffect;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableEffectBeauty(boolean enable) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableEffectBeauty failed.");
                this.mJniReadLock.unlock();
                return 1000;
            }
            return NativeRTCVideoFunctions.nativeEnableEffectBeauty(this.mNativeEngine, enable);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setBeautyIntensity(EffectBeautyMode beautyMode, float intensity) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setBeautyIntensity failed.");
                this.mJniReadLock.unlock();
                return 1000;
            }
            return NativeRTCVideoFunctions.nativeSetBeautyIntensity(this.mNativeEngine, beautyMode.value(), intensity);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoOrientation(VideoOrientation orientation) {
        int nativeSetVideoOrientation;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoOrientation failed.");
                nativeSetVideoOrientation = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoOrientation = NativeRTCVideoFunctions.nativeSetVideoOrientation(this.mNativeEngine, orientation.value());
            }
            return nativeSetVideoOrientation;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setRuntimeParameters(JSONObject params) {
        int nativeSetRuntimeParameters;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetRuntimeParameters failed.");
                nativeSetRuntimeParameters = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetRuntimeParameters = NativeRTCVideoFunctions.nativeSetRuntimeParameters(this.mNativeEngine, params == null ? "" : params.toString());
            }
            return nativeSetRuntimeParameters;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int feedback(List<ProblemFeedbackOption> types, ProblemFeedbackInfo info) {
        int nativeReportFeedback;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetRuntimeParameters failed.");
                nativeReportFeedback = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                long j = 0;
                for (int i = 0; i < types.size(); i++) {
                    j |= types.get(i).value;
                }
                nativeReportFeedback = NativeRTCVideoFunctions.nativeReportFeedback(this.mNativeEngine, j, info);
            }
            return nativeReportFeedback;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long getNativeHandle() {
        if (engineInvalid()) {
            LogUtil.m216e(TAG, "native engine is invalid, getNativeHandle failed.");
            return -1L;
        }
        return this.mNativeEngine;
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startFileRecording(StreamIndex type, RecordingConfig config, RecordingType recordingType) {
        int nativeStartFileRecording;
        LogUtil.m215d(TAG, "startFileRecording");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startFileRecording failed.");
                nativeStartFileRecording = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartFileRecording = NativeRTCVideoFunctions.nativeStartFileRecording(this.mNativeEngine, type.value(), config.dirPath, config.recordingFileType.value(), recordingType.value());
            }
            return nativeStartFileRecording;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopFileRecording(StreamIndex type) {
        int nativeStopFileRecording;
        LogUtil.m215d(TAG, "stopFileRecording");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopFileRecording failed.");
                nativeStopFileRecording = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopFileRecording = NativeRTCVideoFunctions.nativeStopFileRecording(this.mNativeEngine, type.value());
            }
            return nativeStopFileRecording;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startAudioRecording(AudioRecordingConfig config) {
        int nativeStartAudioRecording;
        LogUtil.m215d(TAG, "startAudioRecording");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startFileRecording failed.");
                nativeStartAudioRecording = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartAudioRecording = NativeRTCVideoFunctions.nativeStartAudioRecording(this.mNativeEngine, config.absoluteFileName, config.sampleRate.value(), config.channel.value(), config.frameSource.value(), config.quality.value());
            }
            return nativeStartAudioRecording;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopAudioRecording() {
        int nativeStopAudioRecording;
        LogUtil.m215d(TAG, "startAudioRecording");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startFileRecording failed.");
                nativeStopAudioRecording = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopAudioRecording = NativeRTCVideoFunctions.nativeStopAudioRecording(this.mNativeEngine);
            }
            return nativeStopAudioRecording;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public synchronized IAudioEffectPlayer getAudioEffectPlayer() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getAudioEffectPlayer");
                return null;
            }
            AudioEffectPlayer audioEffectPlayer = this.mAudioEffectPlayer;
            if (audioEffectPlayer != null) {
                return audioEffectPlayer;
            }
            long nativeGetAudioEffectPlayer = NativeRTCVideoFunctions.nativeGetAudioEffectPlayer(this.mNativeEngine);
            if (nativeGetAudioEffectPlayer == 0) {
                LogUtil.m216e(TAG, "getAudioEffectPlayer failed");
                return null;
            }
            AudioEffectPlayer audioEffectPlayer2 = new AudioEffectPlayer(nativeGetAudioEffectPlayer, this.mNativeEngine);
            this.mAudioEffectPlayer = audioEffectPlayer2;
            return audioEffectPlayer2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public synchronized IMediaPlayer getMediaPlayer(int playerId) {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getMediaPlayer");
                return null;
            }
            Map<Integer, RtcMediaPlayer> map = this.mRtcMediaPlayerMap;
            if (map != null && map.containsKey(Integer.valueOf(playerId))) {
                return this.mRtcMediaPlayerMap.get(Integer.valueOf(playerId));
            }
            long nativeGetMediaPlayer = NativeRTCVideoFunctions.nativeGetMediaPlayer(this.mNativeEngine, playerId);
            if (nativeGetMediaPlayer == 0) {
                LogUtil.m216e(TAG, "getMediaPlayer failed");
                return null;
            }
            RtcMediaPlayer rtcMediaPlayer = new RtcMediaPlayer(nativeGetMediaPlayer, this.mNativeEngine);
            if (this.mRtcMediaPlayerMap == null) {
                this.mRtcMediaPlayerMap = new HashMap();
            }
            this.mRtcMediaPlayerMap.put(Integer.valueOf(playerId), rtcMediaPlayer);
            return rtcMediaPlayer;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setAudioContentType(StreamIndex streamIndex, AudioContentTypeConfig config) {
        int nativeSetAudioContentType;
        LogUtil.m215d(TAG, "SetAudioContentType");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetAudioContentType failed.");
                nativeSetAudioContentType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioContentType = NativeRTCVideoFunctionsEx.nativeSetAudioContentType(this.mNativeEngine, streamIndex.value(), config.hasMic, config.hasScreenAudio, config.hasMediaPlayer);
            }
            return nativeSetAudioContentType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setAudioEncodeConfig(StreamIndex streamIndex, AudioEncodeConfig config) {
        int nativeSetAudioEncodeConfig;
        LogUtil.m215d(TAG, "SetAudioEncodeConfig");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetAudioEncodeConfig failed.");
                nativeSetAudioEncodeConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetAudioEncodeConfig = NativeRTCVideoFunctionsEx.nativeSetAudioEncodeConfig(this.mNativeEngine, streamIndex.value(), config.codecType, config.encMode, config.channelNum, config.encBitrate, config.useDtx, config.useInbandfec, config.sampleRate, config.packetSize);
            }
            return nativeSetAudioEncodeConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setScreenAudioSourceType(AudioSourceType sourceType) {
        int nativeSetScreenAudioSourceType;
        LogUtil.m215d(TAG, "SetScreenAudioSourceType");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetScreenAudioSourceType failed.");
                nativeSetScreenAudioSourceType = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetScreenAudioSourceType = NativeRTCVideoFunctions.nativeSetScreenAudioSourceType(this.mNativeEngine, sourceType.value());
            }
            return nativeSetScreenAudioSourceType;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setScreenAudioStreamIndex(StreamIndex index) {
        int nativeSetScreenAudioStreamIndex;
        this.mJniReadLock.lock();
        try {
            LogUtil.m215d(TAG, "SetScreenAudioStreamIndex");
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetScreenAudioStreamIndex failed.");
                nativeSetScreenAudioStreamIndex = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetScreenAudioStreamIndex = NativeRTCVideoFunctions.nativeSetScreenAudioStreamIndex(this.mNativeEngine, index.value());
            }
            return nativeSetScreenAudioStreamIndex;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushScreenAudioFrame(AudioFrame audioFrame) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativePushScreenAudioFrame(this.mNativeEngine, audioFrame.buffer, audioFrame.samples, audioFrame.sampleRate.value(), audioFrame.channel.value());
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startScreenCapture(ScreenMediaType type, Intent mediaProjectionResultData) {
        int nativeStartScreenCapture;
        LogUtil.m215d(TAG, "StartScreenAudioCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, StopScreenAudioCapture failed.");
                nativeStartScreenCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStartScreenCapture = NativeRTCVideoFunctions.nativeStartScreenCapture(this.mNativeEngine, type.value(), mediaProjectionResultData);
            }
            return nativeStartScreenCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int updateScreenCapture(ScreenMediaType type) {
        int nativeUpdateScreenCapture;
        LogUtil.m215d(TAG, "UpdateScreenCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, StopScreenAudioCapture failed.");
                nativeUpdateScreenCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeUpdateScreenCapture = NativeRTCVideoFunctions.nativeUpdateScreenCapture(this.mNativeEngine, type.value());
            }
            return nativeUpdateScreenCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopScreenCapture() {
        int nativeStopScreenCapture;
        LogUtil.m215d(TAG, "StopScreenCapture");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, StopScreenAudioCapture failed.");
                nativeStopScreenCapture = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeStopScreenCapture = NativeRTCVideoFunctions.nativeStopScreenCapture(this.mNativeEngine);
            }
            return nativeStopScreenCapture;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setExternalVideoEncoderEventHandler(IExternalVideoEncoderEventHandler encoder_handler) {
        int nativeSetExternalVideoEncoderEventHandler;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setExternalVideoEncoderEventHandler failed.");
                nativeSetExternalVideoEncoderEventHandler = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                this.mExternalVideoEncoderHandler = encoder_handler;
                if (encoder_handler == null) {
                    nativeSetExternalVideoEncoderEventHandler = NativeRTCVideoFunctions.nativeSetExternalVideoEncoderEventHandler(this.mNativeEngine, null);
                } else {
                    nativeSetExternalVideoEncoderEventHandler = NativeRTCVideoFunctions.nativeSetExternalVideoEncoderEventHandler(this.mNativeEngine, this.mRtcExVideoEncoderHandler);
                }
            }
            return nativeSetExternalVideoEncoderEventHandler;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int pushExternalEncodedVideoFrame(StreamIndex index, int video_index, RTCEncodedVideoFrame video_stream) {
        int nativePushExternalEncodedVideoFrame;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, PushExternalEncodedVideoFrame failed.");
                nativePushExternalEncodedVideoFrame = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativePushExternalEncodedVideoFrame = NativeRTCVideoFunctions.nativePushExternalEncodedVideoFrame(this.mNativeEngine, index.value(), video_index, video_stream.buffer, video_stream.timestampUs, video_stream.timestampDtsUs, video_stream.width, video_stream.height, video_stream.videoCodecType.value(), video_stream.videoPictureType.value(), video_stream.videoRotation.value(), video_stream.seiData);
            }
            return nativePushExternalEncodedVideoFrame;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoDecoderConfig(RemoteStreamKey key, VideoDecoderConfig config) {
        int nativeSetVideoDecoderConfig;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, SetVideoDecoderConfig failed.");
                nativeSetVideoDecoderConfig = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoDecoderConfig = NativeRTCVideoFunctions.nativeSetVideoDecoderConfig(this.mNativeEngine, key.getRoomId(), key.getUserId(), key.getStreamIndex().value(), config.value());
            }
            return nativeSetVideoDecoderConfig;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int requestRemoteVideoKeyFrame(RemoteStreamKey stream_info) {
        int nativeRequestRemoteVideoKeyFrame;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, RequestRemoteVideoKeyFrame failed.");
                nativeRequestRemoteVideoKeyFrame = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeRequestRemoteVideoKeyFrame = NativeRTCVideoFunctions.nativeRequestRemoteVideoKeyFrame(this.mNativeEngine, stream_info.getRoomId(), stream_info.getUserId(), stream_info.getStreamIndex().value());
            }
            return nativeRequestRemoteVideoKeyFrame;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setEarMonitorMode(EarMonitorMode mode) {
        int nativeSetEarMonitorMode;
        LogUtil.m215d(TAG, "setEarMonitorMode");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setEarMonitorMode failed.");
                nativeSetEarMonitorMode = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetEarMonitorMode = NativeRTCVideoFunctions.nativeSetEarMonitorMode(this.mNativeEngine, mode.value());
            }
            return nativeSetEarMonitorMode;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setEarMonitorMode(EarMonitorMode mode, int filter) {
        int nativeSetEarMonitorMode2;
        LogUtil.m215d(TAG, "setEarMonitorMode");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setEarMonitorMode failed.");
                nativeSetEarMonitorMode2 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetEarMonitorMode2 = NativeRTCVideoFunctions.nativeSetEarMonitorMode2(this.mNativeEngine, mode.value(), filter);
            }
            return nativeSetEarMonitorMode2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setEarMonitorVolume(int volume) {
        int nativeSetEarMonitorVolume;
        LogUtil.m215d(TAG, "setEarMonitorVolume");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setEarMonitorVolume failed.");
                nativeSetEarMonitorVolume = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetEarMonitorVolume = NativeRTCVideoFunctions.nativeSetEarMonitorVolume(this.mNativeEngine, volume);
            }
            return nativeSetEarMonitorVolume;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAudioPropertiesReport(AudioPropertiesConfig config) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeEnableAudioPropertiesReport(this.mNativeEngine, config.interval, config.enableSpectrum, config.enableVad, config.localMainReportMode.value(), config.smooth, config.audioReportMode.value(), config.enableVoicePitch);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, EnableAudioPropertiesReport failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAudioVADReport(int interval) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeEnableAudioVADReport(this.mNativeEngine, interval);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, enableAudioVADReport failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableAudioAEDReport(int interval) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeEnableAudioAEDReport(this.mNativeEngine, interval);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, enableAudioAEDReport failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int sendStreamSyncInfo(byte[] data, StreamSycnInfoConfig config) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeSendStreamSyncInfo(this.mNativeEngine, data, config.streamIndex.value(), config.repeatCount, 0);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, SendStreamSyncInfo failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public boolean isCameraTorchSupported() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeIsSupportFlashLight(this.mNativeEngine);
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public boolean isCameraZoomSupported() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeIsCameraZoomSupported(this.mNativeEngine);
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraZoomRatio(float zoom) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCameraZoomRatio(this.mNativeEngine, zoom);
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public float getCameraZoomMaxRatio() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeGetCameraZoomMaxRatio(this.mNativeEngine);
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            this.mJniReadLock.unlock();
            return -1.0f;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraTorch(TorchState torch_state) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeEnableCameraTorch(this.mNativeEngine, torch_state == TorchState.TORCH_STATE_ON);
            }
            LogUtil.m216e(TAG, "native engine is invalid, PushScreenAudioFrame failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public boolean isCameraFocusPositionSupported() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeIsCameraFocusPositionSupported(this.mNativeEngine);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraFocusPosition(float x, float y) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCameraFocusPosition(this.mNativeEngine, x, y);
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public boolean isCameraExposurePositionSupported() {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeIsCameraExposurePositionSupported(this.mNativeEngine);
            }
            this.mJniReadLock.unlock();
            return false;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraExposurePosition(float x, float y) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCameraExposurePosition(this.mNativeEngine, x, y);
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraExposureCompensation(float val) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCameraExposureCompensation(this.mNativeEngine, val);
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableCameraAutoExposureFaceMode(boolean enable) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeEnableCameraAutoExposureFaceMode(this.mNativeEngine, enable);
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCameraAdaptiveMinimumFrameRate(int framerate) {
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCameraAdaptiveMinimumFrameRate(this.mNativeEngine, framerate);
            }
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoWatermark(StreamIndex streamIndex, String imagePath, RTCWatermarkConfig watermarkConfig) {
        int value;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (watermarkConfig.positionInLandscapeMode != null) {
                    float f9 = watermarkConfig.positionInLandscapeMode.f131x;
                    f = f9;
                    f2 = watermarkConfig.positionInLandscapeMode.f132y;
                    f3 = watermarkConfig.positionInLandscapeMode.width;
                    f4 = watermarkConfig.positionInLandscapeMode.height;
                } else {
                    f = 0.0f;
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f4 = 0.0f;
                }
                if (watermarkConfig.positionInPortraitMode != null) {
                    float f10 = watermarkConfig.positionInPortraitMode.f131x;
                    f6 = watermarkConfig.positionInPortraitMode.f132y;
                    f5 = f10;
                    f7 = watermarkConfig.positionInPortraitMode.width;
                    f8 = watermarkConfig.positionInPortraitMode.height;
                } else {
                    f5 = 0.0f;
                    f6 = 0.0f;
                    f7 = 0.0f;
                    f8 = 0.0f;
                }
                value = NativeRTCVideoFunctions.nativeSetVideoWatermark(this.mNativeEngine, streamIndex.value(), imagePath, watermarkConfig.visibleInPreview, f, f2, f3, f4, f5, f6, f7, f8);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, muteAudioPlayback failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int clearVideoWatermark(StreamIndex streamIndex) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeClearVideoWatermark(this.mNativeEngine, streamIndex.value());
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, clearVideoWatermark failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long takeLocalSnapshot(StreamIndex streamIndex, ISnapshotResultCallback callback) {
        long nativeTakeLocalSnapshot;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, takeLocalSnapshot failed.");
                nativeTakeLocalSnapshot = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeTakeLocalSnapshot = NativeRTCVideoFunctions.nativeTakeLocalSnapshot(this.mNativeEngine, streamIndex.value(), callback);
            }
            return nativeTakeLocalSnapshot;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public long takeRemoteSnapshot(RemoteStreamKey streamKey, ISnapshotResultCallback callback) {
        long nativeTakeRemoteSnapshot;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid()) {
                if (streamKey == null) {
                    LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamKey is null");
                } else if (streamKey.getStreamIndex() == null) {
                    LogUtil.m216e(TAG, "EventType: setupRemoteRenderInternal, streamIndex is null");
                } else {
                    nativeTakeRemoteSnapshot = NativeRTCVideoFunctions.nativeTakeRemoteSnapshot(this.mNativeEngine, streamKey.getRoomId(), streamKey.getUserId(), streamKey.getStreamIndex().value(), callback);
                }
                return -1L;
            }
            LogUtil.m216e(TAG, "native engine is invalid, takeRemoteSnapshot failed.");
            nativeTakeRemoteSnapshot = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return nativeTakeRemoteSnapshot;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setDummyCaptureImagePath(String filePath) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeSetDummyCaptureImagePath(this.mNativeEngine, filePath);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, setDummyCaptureImagePath failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startEchoTest(EchoTestConfig config, int delayTime) {
        int nativeStartEchoTest;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, startEchoTest failed.");
                nativeStartEchoTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "startEchoTest");
                nativeStartEchoTest = NativeRTCVideoFunctions.nativeStartEchoTest(this.mNativeEngine, config, delayTime);
            }
            return nativeStartEchoTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopEchoTest() {
        int nativeStopEchoTest;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, stopEchoTest failed.");
                nativeStopEchoTest = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                LogUtil.m215d(TAG, "stopEchoTest");
                nativeStopEchoTest = NativeRTCVideoFunctions.nativeStopEchoTest(this.mNativeEngine);
            }
            return nativeStopEchoTest;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startCloudProxy(List<CloudProxyInfo> cloudProxiesInfo) {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (cloudProxiesInfo == null) {
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    ArrayList arrayList = new ArrayList();
                    Iterator<CloudProxyInfo> it = cloudProxiesInfo.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new InternalCloudProxyInfo(it.next()));
                    }
                    value = NativeRTCVideoFunctions.nativeStartCloudProxy(this.mNativeEngine, arrayList);
                }
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, startCloudProxy failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopCloudProxy() {
        int value;
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                value = NativeRTCVideoFunctions.nativeStopCloudProxy(this.mNativeEngine);
                return value;
            }
            LogUtil.m216e(TAG, "native engine is invalid, stopCloudProxy failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public ISingScoringManager getSingScoringManager() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getSingScoringManager");
            } else {
                SingScoringManager singScoringManager = this.mSingScoringManager;
                if (singScoringManager == null) {
                    long nativeGetSingScoringManager = NativeRTCVideoFunctions.nativeGetSingScoringManager(this.mNativeEngine);
                    if (nativeGetSingScoringManager == 0) {
                        LogUtil.m216e(TAG, "getSingScoringManager failed");
                    } else {
                        singScoringManager = new SingScoringManager(this.mNativeEngine, nativeGetSingScoringManager);
                        this.mSingScoringManager = singScoringManager;
                    }
                }
                return singScoringManager;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public ISimilaritySingScoringManager getSimilaritySingScoringManager() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getSingScoringManager");
            } else {
                SimilaritySingScoringManager similaritySingScoringManager = this.mSimilaritySingScoringManager;
                if (similaritySingScoringManager == null) {
                    long nativeGetSimilaritySingScoringManager = NativeRTCVideoFunctions.nativeGetSimilaritySingScoringManager(this.mNativeEngine);
                    if (nativeGetSimilaritySingScoringManager == 0) {
                        LogUtil.m216e(TAG, "getSingScoringManager failed");
                    } else {
                        similaritySingScoringManager = new SimilaritySingScoringManager(nativeGetSimilaritySingScoringManager);
                        this.mSimilaritySingScoringManager = similaritySingScoringManager;
                    }
                }
                return similaritySingScoringManager;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public NetworkTimeInfo getNetworkTimeInfo() {
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getNetworkTimeInfo");
                this.mJniReadLock.unlock();
                return null;
            }
            return NativeRTCVideoFunctions.nativeGetNetworkTimeInfo(this.mNativeEngine);
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public IKTVManager getKTVManager() {
        this.mJniReadLock.lock();
        try {
            KTVManagerImpl kTVManagerImpl = null;
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getKTVManger failed.");
            } else {
                synchronized (RTCEngineImpl.class) {
                    KTVManagerImpl kTVManagerImpl2 = this.mKTVManager;
                    if (kTVManagerImpl2 != null) {
                        return kTVManagerImpl2;
                    }
                    long nativeGetKTVManager = NativeRTCVideoFunctions.nativeGetKTVManager(this.mNativeEngine);
                    if (nativeGetKTVManager == 0) {
                        LogUtil.m216e(TAG, "getKTVManger failed");
                    } else {
                        kTVManagerImpl = new KTVManagerImpl(nativeGetKTVManager);
                        this.mKTVManager = kTVManagerImpl;
                    }
                }
            }
            return kTVManagerImpl;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public IWTNStream getWTNStream() {
        this.mJniReadLock.lock();
        try {
            WTNStream wTNStream = null;
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getKTVManger failed.");
            } else {
                synchronized (RTCEngineImpl.class) {
                    WTNStream wTNStream2 = this.mWTNStream;
                    if (wTNStream2 != null) {
                        return wTNStream2;
                    }
                    long nativeGetWTNStream = NativeRTCVideoFunctions.nativeGetWTNStream(this.mNativeEngine);
                    if (nativeGetWTNStream == 0) {
                        LogUtil.m216e(TAG, "getWTNStream failed");
                    } else {
                        wTNStream = new WTNStream(nativeGetWTNStream);
                        this.mWTNStream = wTNStream;
                    }
                }
            }
            return wTNStream;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int startHardwareEchoDetection(String test_audio_file_path) {
        LogUtil.m215d(TAG, "startHardwareEchoDetection");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeStartHardwareEchoDetection(this.mNativeEngine, test_audio_file_path);
            }
            LogUtil.m216e(TAG, "native engine is invalid, startHardwareEchoDetection failed.");
            this.mJniReadLock.unlock();
            return -2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int stopHardwareEchoDetection() {
        LogUtil.m215d(TAG, "stopHardwareEchoDetection");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeStopHardwareEchoDetection(this.mNativeEngine);
            }
            LogUtil.m216e(TAG, "native engine is invalid, stopHardwareEchoDetection failed.");
            this.mJniReadLock.unlock();
            return -2;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setCellularEnhancement(MediaTypeEnhancementConfig config) {
        LogUtil.m215d(TAG, "setCellularEnhancement");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctions.nativeSetCellularEnhancement(this.mNativeEngine, new InternalMediaTypeEnhancementConfig(config));
            }
            LogUtil.m216e(TAG, "native engine is invalid, setCellularEnhancement failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setLocalProxy(List<LocalProxyConfiguration> configurations) {
        LogUtil.m215d(TAG, "setLocalProxy");
        this.mJniReadLock.lock();
        try {
            if (this.mNativeEngine != -1 && this.mState != State.DESTORY) {
                ArrayList arrayList = new ArrayList();
                Iterator<LocalProxyConfiguration> it = configurations.iterator();
                while (it.hasNext()) {
                    arrayList.add(new InternalLocalProxyConfiguration(it.next()));
                }
                return NativeRTCVideoFunctions.nativeSetLocalProxy(this.mNativeEngine, arrayList);
            }
            LogUtil.m216e(TAG, "native engine is invalid, setLocalProxy failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setVideoSource(StreamIndex streamIndex, InternalVideoSourceConfig config) {
        LogUtil.m215d(TAG, "setVideoSource");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetVideoSource(this.mNativeEngine, streamIndex.value(), config.getVideoSourceType(), config.getVideoSourceCategory());
            }
            LogUtil.m216e(TAG, "native engine is invalid, setVideoSource failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int pushExternalVideoFrame(StreamIndex streamIndex, VideoFrameData frame) {
        int value;
        LogUtil.m215d(TAG, "pushExternalVideoFrame");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                if (frame == null) {
                    LogUtil.m218i(TAG, "pushExternalVideoFrame: videoFrame is null, drop frame.");
                    value = ReturnStatus.RETURN_STATUS_PARAMETER_ERR.value();
                } else {
                    ReturnStatus returnStatus = ReturnStatus.RETURN_STATUS_SUCCESS;
                    value = ReturnStatus.fromId(NativeRTCVideoFunctionsEx.nativePushExternalVideoFrame(this.mNativeEngine, streamIndex.value(), frame)).value();
                }
                return value;
            }
            LogUtil.m216e(TAG, "pushExternalVideoFrame: native engine is invalid, pushExternalVideoFrame failed.");
            value = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            return value;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setLocalStreamPriority(StreamIndex streamIndex, StreamPriority priority) {
        LogUtil.m215d(TAG, "setLocalStreamPriority");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetLocalStreamPriority(this.mNativeEngine, streamIndex.value(), priority.value());
            }
            LogUtil.m216e(TAG, "native engine is invalid, setLocalStreamPriority failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int startVideoCapture(StreamIndex streamIndex, String deviceId) {
        LogUtil.m215d(TAG, "startVideoCapture");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeStartVideoCapture(this.mNativeEngine, streamIndex.value(), deviceId);
            }
            LogUtil.m216e(TAG, "native engine is invalid, startVideoCapture failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int stopVideoCapture(StreamIndex streamIndex) {
        LogUtil.m215d(TAG, "stopVideoCapture");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeStopVideoCapture(this.mNativeEngine, streamIndex.value());
            }
            LogUtil.m216e(TAG, "native engine is invalid, stopVideoCapture failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setVideoCaptureConfig(StreamIndex streamIndex, VideoCaptureConfig videoCaptureConfig) {
        LogUtil.m215d(TAG, "setVideoCaptureConfig");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetVideoCaptureConfig(this.mNativeEngine, streamIndex.value(), new InternalVideoCaptureConfig(videoCaptureConfig.capturePreference.getValue(), videoCaptureConfig.width, videoCaptureConfig.height, videoCaptureConfig.frameRate));
            }
            LogUtil.m216e(TAG, "native engine is invalid, setVideoCaptureConfig failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setCaptureVolume(int volume) {
        LogUtil.m215d(TAG, "setCaptureVolume");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetCaptureVolume(this.mNativeEngine, volume);
            }
            LogUtil.m216e(TAG, "native engine is invalid, setCaptureVolume failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setScreenCaptureVolume(int volume) {
        LogUtil.m215d(TAG, "setScreenCaptureVolume");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetScreenCaptureVolume(this.mNativeEngine, volume);
            }
            LogUtil.m216e(TAG, "native engine is invalid, setScreenCaptureVolume failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngineEx
    public int setAudioSourceVolume(StreamIndex streamIndex, int volume) {
        LogUtil.m215d(TAG, "setSourceVolume");
        this.mJniReadLock.lock();
        try {
            if (!engineInvalid() && this.mState != State.DESTORY) {
                return NativeRTCVideoFunctionsEx.nativeSetAudioSourceVolume(this.mNativeEngine, streamIndex.value(), volume);
            }
            LogUtil.m216e(TAG, "native engine is invalid, setSourceVolume failed.");
            this.mJniReadLock.unlock();
            return -1;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public IVideoDeviceManager getVideoDeviceManager() {
        LogUtil.m215d(TAG, "getVideoDeviceManager");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getVideoDeviceManager");
            } else {
                VideoDeviceManager videoDeviceManager = this.mVideoDevicemanager;
                if (videoDeviceManager == null) {
                    long nativeGetVideoDeviceManager = NativeRTCVideoFunctions.nativeGetVideoDeviceManager(this.mNativeEngine);
                    if (nativeGetVideoDeviceManager == 0) {
                        LogUtil.m216e(TAG, "getVideoDeviceManager failed");
                    } else {
                        videoDeviceManager = new VideoDeviceManager(nativeGetVideoDeviceManager);
                        this.mVideoDevicemanager = videoDeviceManager;
                    }
                }
                return videoDeviceManager;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    public IAmazingEffect getAmazingEffectInterface() {
        LogUtil.m215d(TAG, "getAmazingEffectInterface");
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, getAmazingEffectInterface");
            } else {
                AmazingEffect amazingEffect = this.mAmazingEffect;
                if (amazingEffect == null) {
                    long nativeGetAmazingEffectInterface = NativeRTCVideoFunctions.nativeGetAmazingEffectInterface(this.mNativeEngine);
                    if (nativeGetAmazingEffectInterface == 0) {
                        LogUtil.m216e(TAG, "getAmazingEffectInterface failed");
                    } else {
                        amazingEffect = new AmazingEffect(nativeGetAmazingEffectInterface);
                        this.mAmazingEffect = amazingEffect;
                    }
                }
                return amazingEffect;
            }
            return null;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int setVideoCaptureRotation(VideoRotation rotation) {
        int nativeSetVideoCaptureRotation;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, setVideoCaptureRotation failed.");
                nativeSetVideoCaptureRotation = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeSetVideoCaptureRotation = NativeRTCVideoFunctions.nativeSetVideoCaptureRotation(this.mNativeEngine, rotation.value());
            }
            return nativeSetVideoCaptureRotation;
        } finally {
            this.mJniReadLock.unlock();
        }
    }

    @Override // com.ss.bytertc.engine.RTCEngine
    public int enableNtpTimestampInRtp(boolean enable) {
        int nativeEnableNtpTimestampInRtp;
        this.mJniReadLock.lock();
        try {
            if (engineInvalid()) {
                LogUtil.m216e(TAG, "native engine is invalid, enableNtpTimestampInRtp failed.");
                nativeEnableNtpTimestampInRtp = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();
            } else {
                nativeEnableNtpTimestampInRtp = NativeRTCVideoFunctions.nativeEnableNtpTimestampInRtp(this.mNativeEngine, enable);
            }
            return nativeEnableNtpTimestampInRtp;
        } finally {
            this.mJniReadLock.unlock();
        }
    }
}
