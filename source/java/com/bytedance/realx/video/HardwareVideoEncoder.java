package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Surface;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.platform.thread.Constants;
import com.bytedance.realx.RXVideoSurfaceController;
import com.bytedance.realx.base.RXDeviceInfoAndroid;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EglBase14;
import com.bytedance.realx.video.EncodedImage;
import com.bytedance.realx.video.VideoEncoder;
import com.bytedance.realx.video.memory.NativeRXByteMemory;
import com.bytedance.realx.video.memory.NativeRXOpenGLMemory;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import com.bytedance.realx.video.memory.RXVideoMemoryInterface;
import com.bytedance.realx.video.memory.RXVideoOpenGLMemoryInterface;
import java.nio.ByteBuffer;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class HardwareVideoEncoder extends MediaCodec.Callback implements VideoEncoder {
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US_RELEASE_ASYNC = 40000;
    private static final int DTS_OFFSET_FRAME_NUM = 7;
    private static final String KEY_HISI_EXT_CODEC_MAX_QP = "vendor.hisi.hisi-ext-codec-max-qp";
    private static final String KEY_HISI_EXT_CODEC_MIN_QP = "vendor.hisi.hisi-ext-codec-min-qp";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES = "vendor.hisi.hisi-ext-codec-non-ref-p-frames";
    private static final String KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED = "vendor.hisi.hisi-ext-codec-non-ref-p-frames-supported";
    private static final String KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD = "vendor.hisi.hisi-ext-codec-qp-regulation-supported";
    private static final String KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE = "vendor.hisi.hisi-ext-codec-vendor-configure";
    private static final String KEY_PRIVATE_PARAM_CHECK_SVC_LAYER = "realx.check.svc.layer";
    private static final String KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT = "realx.force.surface.input";
    private static final String KEY_PRIVATE_PARAM_GLCLEAR = "realx.glclear";
    private static final String KEY_PRIVATE_PARAM_NATIVE_RENDER = "realx.native.render";
    private static final String KEY_PRIVATE_PARAM_RELEASE_ASYNC = "realx.release.async";
    private static final int MAX_VIDEO_FRAMERATE = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final int MIN_CODEC_HEIGHT_ALIGN = 4;
    private static final int MIN_CODEC_WIDTH_ALIGN = 16;
    private static final int RESTART_ENCODER_TIME_THRESHOLD_MS = 5000;
    private static final String TAG = "HardwareVideoEncoder";
    private int actualHeight;
    private int actualWidth;
    private int adjustedBitrate;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private boolean automaticResizeOn;
    private VideoEncoder.BitrateMode bitrateMode;
    private VideoEncoder.Callback callback;
    private final Object callbackLock;
    private MediaCodecInfo.CodecCapabilities capabilities;
    private boolean checkSVCLayer;
    private MediaCodecWrapper codec;
    private final RXVideoCodecDesc codecDesc;
    private int codecHeightAlign;
    private final String codecName;
    private int codecWidthAlign;
    private ByteBuffer configBuffer;
    private final Deque<Long> dtsQueue;
    private boolean enableGlClear;
    private boolean enableNativeRender;
    private final ThreadUtils.ThreadChecker encodeThreadChecker;
    private boolean encodedFirstFrame;
    private long firstFrameDiffUs;
    private Boolean forceSurfaceInput;
    private final long forcedKeyFrameNs;
    private int height;
    private LinkedList<Integer> inputBuffers;
    private boolean isError;
    private boolean isNeedSurfaceInputWorkaround;
    private boolean isStatisticsEnabled;
    private Boolean isTextureBuffer;
    private final int keyFrameIntervalSec;
    private long lastKeyFrameNs;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private Thread outputThread;
    private final ThreadUtils.ThreadChecker outputThreadChecker;
    private HashMap<String, String> privateParams;
    private boolean releaseAsync;
    private volatile boolean running;
    private VideoEncoder.ScaleMode scaleMode;
    private VideoEncoder.Settings settings;
    private EglBase14.Context sharedContext;
    private volatile Exception shutdownException;
    private final Integer surfaceColorFormat;
    private int svcRealLayerNum;
    private EglBase14 textureEglBase;
    private Surface textureInputSurface;
    private int updateBitrate;
    private long updateBitrateTimestamp;
    private boolean useAsyncMode;
    private boolean useSurfaceMode;
    private HashMap<String, String> vpassPrivateParams;
    private int width;
    private final Integer yuvColorFormat;
    private final YuvFormat yuvFormat;
    private int queriedGLESVersion = 2;
    private GlRectDrawer textureDrawer = null;
    private VideoFrameDrawer videoFrameDrawer = null;
    private long videoFrameDrawerHandler = 0;

    static native long nativeCreateDrawer();

    static native void nativeDestroyDrawer(long drawer);

    static native int nativeDrawFrame(long drawer, long frame, int viewWidth, int viewHeight, int frameWidth, int frameHeight);

    public HardwareVideoEncoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String codecName, RXVideoCodecDesc codecDesc, Integer surfaceColorFormat, Integer yuvColorFormat, int keyFrameIntervalSec, int forceKeyFrameIntervalMs, MediaCodecInfo.CodecCapabilities capabilities) {
        ThreadUtils.ThreadChecker threadChecker = new ThreadUtils.ThreadChecker();
        this.encodeThreadChecker = threadChecker;
        this.outputThreadChecker = new ThreadUtils.ThreadChecker();
        this.privateParams = new HashMap<>();
        this.vpassPrivateParams = new HashMap<>();
        this.forceSurfaceInput = null;
        this.isNeedSurfaceInputWorkaround = false;
        boolean z = true;
        this.svcRealLayerNum = 1;
        this.checkSVCLayer = false;
        this.encodedFirstFrame = false;
        this.firstFrameDiffUs = 0L;
        this.dtsQueue = new LinkedBlockingDeque();
        this.releaseAsync = true;
        this.enableGlClear = false;
        this.useAsyncMode = false;
        this.inputBuffers = new LinkedList<>();
        this.isError = false;
        this.callbackLock = new Object();
        this.enableNativeRender = false;
        this.isStatisticsEnabled = false;
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = codecName;
        this.codecDesc = codecDesc;
        this.surfaceColorFormat = surfaceColorFormat;
        this.yuvColorFormat = yuvColorFormat;
        this.yuvFormat = YuvFormat.valueOf(yuvColorFormat.intValue());
        this.keyFrameIntervalSec = keyFrameIntervalSec;
        this.forcedKeyFrameNs = TimeUnit.MILLISECONDS.toNanos(forceKeyFrameIntervalMs);
        String GetCpuModel = RXDeviceInfoAndroid.GetCpuModel();
        String GetDeviceModel = RXDeviceInfoAndroid.GetDeviceModel();
        if (GetCpuModel != null) {
            if (!GetCpuModel.contains("MT6785V/CC") && ((!GetCpuModel.contains("MT6833V/ZA") || "RMX3610".equalsIgnoreCase(GetDeviceModel)) && !GetCpuModel.contains("MT6833V/PNZA") && !GetCpuModel.contains("MT6853V/ZA") && !GetCpuModel.contains("MT6893Z_C/CZA"))) {
                z = false;
            }
            this.isNeedSurfaceInputWorkaround = z;
        }
        this.capabilities = capabilities;
        this.codecWidthAlign = 0;
        this.codecHeightAlign = 0;
        threadChecker.detachThread();
    }

    private void initMediaFormat(MediaFormat format) {
        int intValue = (this.useSurfaceMode ? this.surfaceColorFormat : this.yuvColorFormat).intValue();
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        setIntegerParam(format, "bitrate", Integer.valueOf(this.settings.targetBps));
        setIntegerParam(format, "color-format", Integer.valueOf(intValue));
        setIntegerParam(format, "frame-rate", Integer.valueOf(this.settings.targetFps));
        if (this.settings.targetKeyFrameIntervalMs <= 0) {
            setIntegerParam(format, "i-frame-interval", Integer.valueOf(this.keyFrameIntervalSec));
        } else {
            int i = this.settings.targetKeyFrameIntervalMs / BytePatchException.ErrorCode.paramsError;
            if (i <= 1) {
                i = 1;
            }
            setIntegerParam(format, "i-frame-interval", Integer.valueOf(i));
        }
        setBitrateMode(format);
        if (this.settings.encodeMode == VideoEncoder.EncodeMode.LIVE) {
            setProfileForLive(format);
        } else {
            setProfileForRTC(format);
            setColorSpace(format);
        }
        setBFrameNumber(format);
        setSVCNumber(format);
        if (standard != RXVideoCodecStandard.VP8 && this.settings.enableQpSetting) {
            if (this.codecName.contains("OMX.hisi.")) {
                setIntegerParam(format, KEY_HISI_EXT_CODEC_VENDOR_CONFIGURE, 1);
            }
            setIPFrameMinMaxQP(format);
            if (isBFrameEnabled()) {
                setBFrameMinMaxQP(format);
            }
        }
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            RXLogging.m287w(TAG, "set android hardware encoder private param with Key:" + entry.getKey() + " Value:" + entry.getValue());
            if (isNumeric(entry.getValue())) {
                format.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
            } else if (entry.getValue().length() > 0) {
                format.setString(entry.getKey(), entry.getValue());
            }
        }
    }

    private int queryCurerentRunningGlesVersion() {
        int[] iArr = new int[1];
        EGL14.eglQueryContext(EGL14.eglGetCurrentDisplay(), EGL14.eglGetCurrentContext(), 12440, iArr, 0);
        return iArr[0];
    }

    private void initFrameDrawer() {
        this.queriedGLESVersion = queryCurerentRunningGlesVersion();
        if (this.enableNativeRender) {
            this.videoFrameDrawerHandler = nativeCreateDrawer();
            RXLogging.m285i(TAG, "created native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
        } else {
            this.textureDrawer = new GlRectDrawer();
            this.videoFrameDrawer = new VideoFrameDrawer();
            RXLogging.m285i(TAG, "created java frame drawer " + this.videoFrameDrawer);
        }
    }

    private void releaseFrameDrawer() {
        long j = this.videoFrameDrawerHandler;
        if (j != 0) {
            nativeDestroyDrawer(j);
            RXLogging.m285i(TAG, "released native frame drawer 0x" + Long.toHexString(this.videoFrameDrawerHandler));
            this.videoFrameDrawerHandler = 0L;
        }
        GlRectDrawer glRectDrawer = this.textureDrawer;
        if (glRectDrawer != null) {
            glRectDrawer.release();
            this.textureDrawer = null;
        }
        VideoFrameDrawer videoFrameDrawer = this.videoFrameDrawer;
        if (videoFrameDrawer != null) {
            videoFrameDrawer.release();
            RXLogging.m285i(TAG, "released java frame drawer " + this.videoFrameDrawer);
            this.videoFrameDrawer = null;
        }
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setPrivateParam(String key, String value) {
        RXLogging.m287w(TAG, "got android hardware encoder setPrivateParam with key:" + key + " value:" + value);
        key.hashCode();
        char c = 65535;
        switch (key.hashCode()) {
            case -449636302:
                if (key.equals(KEY_PRIVATE_PARAM_FORCE_SURFACE_INPUT)) {
                    c = 0;
                    break;
                }
                break;
            case -365977292:
                if (key.equals(KEY_PRIVATE_PARAM_GLCLEAR)) {
                    c = 1;
                    break;
                }
                break;
            case 232994177:
                if (key.equals(KEY_PRIVATE_PARAM_RELEASE_ASYNC)) {
                    c = 2;
                    break;
                }
                break;
            case 775490441:
                if (key.equals(KEY_PRIVATE_PARAM_CHECK_SVC_LAYER)) {
                    c = 3;
                    break;
                }
                break;
            case 1064378105:
                if (key.equals(KEY_PRIVATE_PARAM_NATIVE_RENDER)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.forceSurfaceInput = Boolean.valueOf(RouterConstants.TRUE.equalsIgnoreCase(value));
                break;
            case 1:
                this.enableGlClear = RouterConstants.TRUE.equalsIgnoreCase(value);
                break;
            case 2:
                this.releaseAsync = RouterConstants.TRUE.equalsIgnoreCase(value);
                break;
            case 3:
                this.checkSVCLayer = RouterConstants.TRUE.equalsIgnoreCase(value);
                break;
            case 4:
                this.enableNativeRender = RouterConstants.TRUE.equalsIgnoreCase(value);
                break;
            default:
                this.vpassPrivateParams.put(key, value);
                break;
        }
        return VideoCodecStatus.OK;
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus initEncode(VideoEncoder.Settings settings, VideoEncoder.Callback callback) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.sharedContext = settings.sharedContext;
        this.callback = callback;
        this.automaticResizeOn = true;
        this.actualWidth = settings.width;
        this.actualHeight = settings.height;
        this.scaleMode = settings.scaleMode;
        this.bitrateMode = settings.bitrateMode;
        this.updateBitrate = settings.targetBps;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.settings = settings;
        boolean z = false;
        this.useAsyncMode = settings.enableAsyncMode;
        alignResolutionIfNeeded();
        if (RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
            RXLogging.m283e(TAG, "using pass surface mode");
            this.useSurfaceMode = true;
        } else {
            if (canUseSurface() && settings.useSurfaceMode && this.sharedContext != null) {
                z = true;
            }
            this.useSurfaceMode = z;
            if (isForceUseSurfaceInput(this.width)) {
                this.useSurfaceMode = true;
            }
        }
        RXLogging.m287w(TAG, "initEncode, codec name:" + this.codecName + ", with resolution:" + this.width + " x " + this.height + ". @ " + settings.targetBps + "bps. Fps: " + settings.targetFps + " Use surface mode: " + this.useSurfaceMode + " initUseSurfaceMode: " + settings.useSurfaceMode + " enableAlignment:" + settings.enableAlignment + " settings.bitrateMode:" + settings.bitrateMode + " qp_min:" + settings.minQp + " qp_max:" + settings.maxQp + " qp_i_min:" + settings.minIQp + " qp_i_max:" + settings.maxIQp + " useAsyncMode:" + this.useAsyncMode + " surfaceColorFormat: " + this.surfaceColorFormat + " yuvColorFormat: " + this.yuvColorFormat);
        return initEncodeInternal();
    }

    private void enableEncodingStatistics(MediaFormat format) {
        if (isEncodingStatisticsSupported() && this.settings.isStatisticsEnabled) {
            format.setInteger("video-encoding-statistics-level", 1);
            this.isStatisticsEnabled = true;
        }
    }

    private VideoCodecStatus initEncodeInternal() {
        MediaFormat outputFormat;
        this.encodeThreadChecker.checkIsOnValidThread();
        this.lastKeyFrameNs = -1L;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.dtsQueue.clear();
        this.isStatisticsEnabled = false;
        synchronized (this.callbackLock) {
            this.inputBuffers.clear();
            this.isError = false;
        }
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecDesc.getStandard().mimeType(), this.width, this.height);
                initMediaFormat(createVideoFormat);
                enableEncodingStatistics(createVideoFormat);
                RXLogging.m287w(TAG, "Format: " + createVideoFormat);
                if (this.useAsyncMode) {
                    HandlerThread handlerThread = new HandlerThread("asyncOutput");
                    this.asyncOutputThread = handlerThread;
                    handlerThread.start();
                    this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());
                    this.outputThreadChecker.detachThread();
                    this.running = true;
                    this.codec.setCallback(this, this.asyncHandler);
                }
                this.codec.configure(createVideoFormat, null, null, 1);
                if (isSvcEnabled() && (outputFormat = this.codec.getOutputFormat()) != null) {
                    this.svcRealLayerNum = parseRealLayerNum(outputFormat);
                    RXLogging.m287w(TAG, "" + this.svcRealLayerNum + "，output format after configure: " + outputFormat.toString());
                }
                if (RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
                    this.textureInputSurface = this.codec.createInputSurface();
                    RXVideoSurfaceController.getInstance().setSurface(this.textureInputSurface);
                } else if (this.useSurfaceMode) {
                    this.textureInputSurface = this.codec.createInputSurface();
                    EglBase14 eglBase14 = new EglBase14(this.sharedContext, EglBase.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));
                    this.textureEglBase = eglBase14;
                    eglBase14.createSurface(this.textureInputSurface);
                    this.textureEglBase.makeCurrent();
                    initFrameDrawer();
                }
                this.codec.start();
                setExtCodecForHisi(this.settings.maxQp, this.settings.minQp);
                if (this.settings.encodeMode == VideoEncoder.EncodeMode.LIVE) {
                    updateBitrate(this.settings.targetBps);
                }
                if (!this.useAsyncMode) {
                    this.running = true;
                    try {
                        this.outputThreadChecker.detachThread();
                        Thread createOutputThread = createOutputThread();
                        this.outputThread = createOutputThread;
                        createOutputThread.start();
                    } catch (Exception e) {
                        RXLogging.m284e(TAG, "output thread err", e);
                        release();
                        return VideoCodecStatus.FALLBACK_SOFTWARE;
                    }
                }
                return VideoCodecStatus.OK;
            } catch (Exception e2) {
                RXLogging.m284e(TAG, "initEncodeInternal failed", e2);
                release();
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } catch (Exception e3) {
            RXLogging.m284e(TAG, "Cannot create media encoder " + this.codecName, e3);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private void setExtCodecForHisi(int maxQP, int minQP) {
        MediaCodecWrapper mediaCodecWrapper;
        MediaFormat mediaFormat;
        if (!this.codecName.contains("OMX.hisi.") || (mediaCodecWrapper = this.codec) == null) {
            return;
        }
        try {
            mediaFormat = mediaCodecWrapper.getOutputFormat();
        } catch (Exception e) {
            RXLogging.m284e(TAG, "getOutputFormat failed", e);
            mediaFormat = null;
        }
        if (mediaFormat == null) {
            return;
        }
        RXLogging.m285i(TAG, "output format before start: " + mediaFormat.toString());
        boolean z = false;
        boolean z2 = mediaFormat != null && mediaFormat.containsKey(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) && mediaFormat.getInteger(KEY_HISI_EXT_CODEC_QP_REGULATION_SUPPORETD) == 1;
        if (mediaFormat.containsKey(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) && mediaFormat.getInteger(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES_SUPPORTED) == 1) {
            z = true;
        }
        Bundle bundle = new Bundle();
        if (z && isSvcEnabled() && this.svcRealLayerNum <= 1) {
            bundle.putInt(KEY_HISI_EXT_CODEC_NON_REF_P_FRAMES, 1);
            this.svcRealLayerNum = 2;
            RXLogging.m287w(TAG, "support Non Ref PFrame.");
        }
        if (z2) {
            bundle.putInt(KEY_HISI_EXT_CODEC_MAX_QP, maxQP);
            bundle.putInt(KEY_HISI_EXT_CODEC_MIN_QP, minQP);
        }
        if (z || z2) {
            try {
                this.codec.setParameters(bundle);
            } catch (Exception e2) {
                RXLogging.m284e(TAG, "setExtCodecForHisi failed", e2);
            }
        }
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus release() {
        this.encodeThreadChecker.checkIsOnValidThread();
        RXLogging.m287w(TAG, "hardware video encoder release start.");
        VideoCodecStatus videoCodecStatus = VideoCodecStatus.OK;
        if (this.useAsyncMode) {
            this.running = false;
            final HandlerThread handlerThread = this.asyncOutputThread;
            if (handlerThread != null) {
                this.asyncHandler.post(new Runnable() { // from class: com.bytedance.realx.video.HardwareVideoEncoder$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        HardwareVideoEncoder.this.m800lambda$release$0$combytedancerealxvideoHardwareVideoEncoder(handlerThread);
                    }
                });
                if (!ThreadUtils.joinUninterruptibly(this.asyncOutputThread, Constants.TASK_RUN_THRESHOLD)) {
                    RXLogging.m283e(TAG, "Media encoder release timeout");
                    videoCodecStatus = VideoCodecStatus.TIMEOUT;
                }
                this.asyncOutputThread = null;
                this.asyncHandler = null;
            }
        } else if (this.outputThread != null) {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, Constants.TASK_RUN_THRESHOLD)) {
                RXLogging.m283e(TAG, "Media encoder release timeout");
                videoCodecStatus = VideoCodecStatus.TIMEOUT;
            } else if (this.shutdownException != null) {
                RXLogging.m284e(TAG, "Media encoder release exception", this.shutdownException);
                videoCodecStatus = VideoCodecStatus.ERROR;
            } else {
                videoCodecStatus = VideoCodecStatus.OK;
            }
        }
        RXLogging.m287w(TAG, "Media encoder release ok.");
        releaseFrameDrawer();
        EglBase14 eglBase14 = this.textureEglBase;
        if (eglBase14 != null) {
            eglBase14.release();
            this.textureEglBase = null;
        }
        RXLogging.m287w(TAG, "textureEglBase release ok.");
        Surface surface = this.textureInputSurface;
        if (surface != null) {
            surface.release();
            this.textureInputSurface = null;
        }
        RXLogging.m287w(TAG, "textureInputSurface release ok.");
        this.codec = null;
        this.outputThread = null;
        this.encodeThreadChecker.detachThread();
        RXLogging.m287w(TAG, "hardware video encoder release end." + videoCodecStatus);
        return videoCodecStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$release$0$com-bytedance-realx-video-HardwareVideoEncoder, reason: not valid java name */
    public /* synthetic */ void m800lambda$release$0$combytedancerealxvideoHardwareVideoEncoder(HandlerThread handlerThread) {
        releaseCodecOnOutputThread();
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus requestKeyFrame() {
        requestKeyFrame(System.currentTimeMillis());
        return VideoCodecStatus.OK;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00be A[RETURN] */
    @Override // com.bytedance.realx.video.VideoEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VideoCodecStatus encode(RXVideoFrameInterface videoFrame, boolean keyFrameRequested) {
        VideoCodecStatus resetCodec;
        VideoCodecStatus encodeByteBuffer;
        EglBase14 eglBase14;
        EglBase14 eglBase142;
        this.encodeThreadChecker.checkIsOnValidThread();
        GlUtil.clearGLES2Error(TAG);
        if (this.codec == null) {
            return VideoCodecStatus.UNINITIALIZED;
        }
        synchronized (this.callbackLock) {
            if (this.isError) {
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            RXVideoMemoryInterface andRetainVideoFrameMemory = videoFrame.getAndRetainVideoFrameMemory();
            if (andRetainVideoFrameMemory == null) {
                return VideoCodecStatus.MEMORY;
            }
            boolean z = andRetainVideoFrameMemory instanceof NativeRXOpenGLMemory;
            Boolean bool = this.isTextureBuffer;
            if (bool == null || bool.booleanValue() != z) {
                this.isTextureBuffer = Boolean.valueOf(z);
                RXLogging.m283e(TAG, "isTextureBuffer: " + this.isTextureBuffer);
            }
            int width = videoFrame.getWidth();
            int height = videoFrame.getHeight();
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = (this.actualWidth == width && this.actualHeight == height) ? false : true;
            if (z4) {
                this.actualWidth = width;
                this.actualHeight = height;
                alignResolutionIfNeeded();
            }
            boolean z5 = canUseSurface() && (z || isForceUseSurfaceInput(this.width));
            if (z5 && z) {
                EglBase14.Context context = new EglBase14.Context(((NativeRXOpenGLMemory) andRetainVideoFrameMemory).getEGLContext(), EglBase.EglVersion.getPreferredEglVersion());
                if (this.sharedContext == null || context.getNativeEglContext() != this.sharedContext.getNativeEglContext()) {
                    this.sharedContext = context;
                    andRetainVideoFrameMemory.release();
                    if (z5 == this.useSurfaceMode || z4) {
                        resetCodec = resetCodec(z5);
                        if (resetCodec != VideoCodecStatus.OK) {
                            return resetCodec;
                        }
                    } else {
                        z3 = z2;
                    }
                    if (z3 && this.useSurfaceMode && !RXVideoSurfaceController.getInstance().usePassSurfaceMode()) {
                        RXLogging.m287w(TAG, "egl env changed, create new shared context from the new videoframe egl context");
                        releaseFrameDrawer();
                        eglBase142 = this.textureEglBase;
                        if (eglBase142 != null) {
                            eglBase142.release();
                            this.textureEglBase = null;
                        }
                        try {
                            EglBase14 eglBase143 = new EglBase14(this.sharedContext, EglBase.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));
                            this.textureEglBase = eglBase143;
                            eglBase143.createSurface(this.textureInputSurface);
                            this.textureEglBase.makeCurrent();
                            initFrameDrawer();
                        } catch (Exception e) {
                            RXLogging.m284e(TAG, "egl failed, fallback software:", e);
                            return VideoCodecStatus.FALLBACK_SOFTWARE;
                        }
                    }
                    resetCodecWhenBitrateChange();
                    if (keyFrameRequested) {
                        RXLogging.m285i(TAG, "Request key frame");
                    }
                    if (!keyFrameRequested || shouldForceKeyFrame(videoFrame.getTimestampNs())) {
                        requestKeyFrame(videoFrame.getTimestampNs());
                    }
                    if (isBFrameEnabled()) {
                        this.dtsQueue.push(Long.valueOf(videoFrame.getTimestampUs()));
                    }
                    if (!this.useSurfaceMode) {
                        if (this.enableGlClear && (eglBase14 = this.textureEglBase) != null) {
                            eglBase14.makeCurrent();
                        }
                        encodeByteBuffer = encodeTextureBuffer(videoFrame);
                    } else {
                        encodeByteBuffer = encodeByteBuffer(videoFrame);
                    }
                    if (encodeByteBuffer != VideoCodecStatus.OK && isBFrameEnabled()) {
                        this.dtsQueue.pollFirst();
                    }
                    return encodeByteBuffer;
                }
            }
            z2 = false;
            andRetainVideoFrameMemory.release();
            if (z5 == this.useSurfaceMode) {
            }
            resetCodec = resetCodec(z5);
            if (resetCodec != VideoCodecStatus.OK) {
            }
            if (z3) {
                RXLogging.m287w(TAG, "egl env changed, create new shared context from the new videoframe egl context");
                releaseFrameDrawer();
                eglBase142 = this.textureEglBase;
                if (eglBase142 != null) {
                }
                EglBase14 eglBase1432 = new EglBase14(this.sharedContext, EglBase.getEGLConfig(EglBase.EglVersion.getPreferredEglVersion(), EglBase.Config.CONFIG_RECORDABLE));
                this.textureEglBase = eglBase1432;
                eglBase1432.createSurface(this.textureInputSurface);
                this.textureEglBase.makeCurrent();
                initFrameDrawer();
            }
            resetCodecWhenBitrateChange();
            if (keyFrameRequested) {
            }
            if (!keyFrameRequested) {
            }
            requestKeyFrame(videoFrame.getTimestampNs());
            if (isBFrameEnabled()) {
            }
            if (!this.useSurfaceMode) {
            }
            if (encodeByteBuffer != VideoCodecStatus.OK) {
                this.dtsQueue.pollFirst();
            }
            return encodeByteBuffer;
        }
    }

    private VideoCodecStatus encodeTextureBuffer(RXVideoFrameInterface videoFrame) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                RXLogging.m283e(TAG, "got egl err:" + glGetError);
            }
            if (this.enableGlClear) {
                GLES20.glClear(16384);
            }
            if (this.queriedGLESVersion == 3) {
                RXVideoMemoryInterface andRetainVideoFrameMemory = videoFrame.getAndRetainVideoFrameMemory();
                if (andRetainVideoFrameMemory == null) {
                    RXLogging.m283e(TAG, "encodeTexture got empty frame, skip this frame");
                    return VideoCodecStatus.OK;
                }
                if (andRetainVideoFrameMemory.getMemoryType() == RXVideoMemoryType.kOPENGL_TEXTURE) {
                    long gLSync = ((RXVideoOpenGLMemoryInterface) andRetainVideoFrameMemory).getGLSync();
                    if (gLSync != 0) {
                        GLES30.glWaitSync(gLSync, 0, -1L);
                    }
                }
                andRetainVideoFrameMemory.release();
            }
            if (this.enableNativeRender) {
                nativeDrawFrame(this.videoFrameDrawerHandler, videoFrame.getNativeHandle(), this.width, this.height, videoFrame.getWidth(), videoFrame.getHeight());
            } else {
                videoFrame.setRotation(RXVideoRotation.VIDEO_ROTATION_0);
                VideoFrameDrawer videoFrameDrawer = this.videoFrameDrawer;
                GlRectDrawer glRectDrawer = this.textureDrawer;
                int i = this.width;
                int i2 = this.height;
                videoFrameDrawer.drawFrame(videoFrame, glRectDrawer, null, 0, 0, i, i2, i, i2);
            }
            this.textureEglBase.swapBuffers(videoFrame.getTimestampNs());
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "encodeTexture failed", e);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus encodeByteBuffer(RXVideoFrameInterface videoFrame) {
        int dequeueInputBuffer;
        ByteBuffer byteBuffer;
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode) {
            synchronized (this.callbackLock) {
                dequeueInputBuffer = this.inputBuffers.size() <= 0 ? -1 : this.inputBuffers.removeFirst().intValue();
            }
            if (dequeueInputBuffer == -1) {
                RXLogging.m285i(TAG, "Dropped frame, no input buffers available");
                return VideoCodecStatus.NO_OUTPUT;
            }
            try {
                byteBuffer = this.codec.getInputBuffer(dequeueInputBuffer);
            } catch (Exception e) {
                RXLogging.m284e(TAG, "getInputBuffer failed", e);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        } else {
            try {
                dequeueInputBuffer = this.codec.dequeueInputBuffer(0L);
                if (dequeueInputBuffer == -1) {
                    RXLogging.m285i(TAG, "Dropped frame, no input buffers available");
                    return VideoCodecStatus.NO_OUTPUT;
                }
                try {
                    byteBuffer = this.codec.getInputBuffers()[dequeueInputBuffer];
                } catch (Exception e2) {
                    RXLogging.m284e(TAG, "getInputBuffers failed", e2);
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            } catch (Exception e3) {
                RXLogging.m284e(TAG, "dequeueInputBuffer failed", e3);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
        }
        return drainInputData(dequeueInputBuffer, byteBuffer, videoFrame);
    }

    private VideoCodecStatus drainInputData(int index, ByteBuffer buffer, RXVideoFrameInterface videoFrame) {
        int i = ((this.width * this.height) * 3) / 2;
        long timestampNs = videoFrame.getTimestampNs() / 1000;
        fillInputBuffer(buffer, videoFrame);
        try {
            this.codec.queueInputBuffer(index, 0, i, timestampNs, 0);
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "queueInputBuffer failed", e);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    @Override // com.bytedance.realx.video.VideoEncoder
    public VideoCodecStatus setRateAllocation(int bitrateBitps, int framerate) {
        this.encodeThreadChecker.checkIsOnValidThread();
        updateBitrate(bitrateBitps);
        return VideoCodecStatus.OK;
    }

    public VideoEncoder.ScalingSettings getScalingSettings() {
        this.encodeThreadChecker.checkIsOnValidThread();
        if (this.automaticResizeOn) {
            if (this.codecDesc.getStandard() == RXVideoCodecStandard.VP8) {
                return new VideoEncoder.ScalingSettings(29, 95);
            }
            if (this.codecDesc.getStandard() == RXVideoCodecStandard.VP8) {
                return new VideoEncoder.ScalingSettings(24, 37);
            }
        }
        return VideoEncoder.ScalingSettings.OFF;
    }

    private VideoCodecStatus resetCodec(boolean newUseSurfaceMode) {
        this.encodeThreadChecker.checkIsOnValidThread();
        RXLogging.m287w(TAG, "resetCodec: " + this.width + " " + this.height + " " + newUseSurfaceMode);
        VideoCodecStatus release = release();
        if (release != VideoCodecStatus.OK) {
            return release;
        }
        this.useSurfaceMode = newUseSurfaceMode;
        this.settings.targetBps = this.updateBitrate;
        this.updateBitrateTimestamp = SystemClock.elapsedRealtime();
        this.callback.onEncodedEvent(VideoEncoder.EncodeEvent.RESET);
        return initEncodeInternal();
    }

    private boolean shouldForceKeyFrame(long presentationTimestampNs) {
        this.encodeThreadChecker.checkIsOnValidThread();
        long j = this.forcedKeyFrameNs;
        return j > 0 && presentationTimestampNs > this.lastKeyFrameNs + j;
    }

    private void requestKeyFrame(long presentationTimestampNs) {
        this.encodeThreadChecker.checkIsOnValidThread();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("request-sync", 0);
            this.codec.setParameters(bundle);
            this.lastKeyFrameNs = presentationTimestampNs;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "requestKeyFrame failed", e);
        }
    }

    private Thread createOutputThread() {
        return new Thread("video_encoded_thread") { // from class: com.bytedance.realx.video.HardwareVideoEncoder.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (HardwareVideoEncoder.this.running) {
                    HardwareVideoEncoder.this.deliverEncodedImage();
                }
                HardwareVideoEncoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    protected void deliverEncodedImage() {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, this.releaseAsync ? 40000L : 100000L);
            if (dequeueOutputBuffer == -2) {
                RXLogging.m285i(TAG, "output format changed: " + this.codec.getOutputFormat().toString());
                return;
            }
            if (dequeueOutputBuffer == -1) {
                return;
            }
            if (dequeueOutputBuffer != -3 && dequeueOutputBuffer < 0) {
                RXLogging.m283e(TAG, "should not be here: index:" + dequeueOutputBuffer);
                return;
            }
            drainOutputData(dequeueOutputBuffer, bufferInfo, this.codec.getOutputBuffers()[dequeueOutputBuffer]);
        } catch (Exception e) {
            RXLogging.m284e(TAG, "deliverOutput failed", e);
        }
    }

    private void drainOutputData(int index, MediaCodec.BufferInfo info, ByteBuffer codecOutputBuffer) {
        Integer num;
        ByteBuffer slice;
        EncodedImage.FrameType frameType;
        MediaFormat outputFormat;
        codecOutputBuffer.position(info.offset);
        codecOutputBuffer.limit(info.offset + info.size);
        if ((info.flags & 2) != 0) {
            RXLogging.m285i(TAG, "Config frame generated. Offset: " + info.offset + ". Size: " + info.size);
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(info.size);
            this.configBuffer = allocateDirect;
            allocateDirect.put(codecOutputBuffer);
        } else {
            boolean z = (info.flags & 1) != 0;
            if (z) {
                RXLogging.m285i(TAG, "Sync frame generated");
            }
            Integer num2 = null;
            if (!this.isStatisticsEnabled || (outputFormat = this.codec.getOutputFormat(index)) == null) {
                num = null;
            } else {
                num = outputFormat.containsKey("video-qp-average") ? Integer.valueOf(outputFormat.getInteger("video-qp-average")) : null;
                if (outputFormat.containsKey("picture-type")) {
                    num2 = Integer.valueOf(outputFormat.getInteger("picture-type"));
                }
            }
            if (z && (this.codecDesc.getStandard() == RXVideoCodecStandard.H264 || this.codecDesc.getStandard() == RXVideoCodecStandard.ByteVC1)) {
                RXLogging.m285i(TAG, "Prepending config frame of size " + this.configBuffer.capacity() + " to output buffer with offset " + info.offset + ", size " + info.size);
                slice = ByteBuffer.allocateDirect(info.size + this.configBuffer.capacity());
                this.configBuffer.rewind();
                slice.put(this.configBuffer);
                slice.put(codecOutputBuffer);
                slice.rewind();
            } else {
                slice = codecOutputBuffer.slice();
            }
            if (z) {
                frameType = EncodedImage.FrameType.kIntra;
            } else {
                frameType = EncodedImage.FrameType.kPredicted;
            }
            if (num2 != null) {
                frameType = EncodedImage.FrameType.valueOf(num2.intValue());
            }
            EncodedImage.Builder frameType2 = EncodedImage.builder().setEncodedWidth(this.width).setEncodedHeight(this.height).setActualWidth(this.actualWidth).setActualHeight(this.actualHeight).setCaptureTimeNs(info.presentationTimeUs * 1000).setBuffer(slice).setSvcLayerNum(this.checkSVCLayer ? this.svcRealLayerNum : this.settings.temporalLayerNum).setFrameType(frameType);
            if (num != null && num.intValue() > 0) {
                frameType2.setQp(num);
            }
            caculateDts(info.presentationTimeUs, frameType2);
            this.callback.onEncodedFrame(frameType2.createEncodedImage(), new VideoEncoder.CodecSpecificInfo(this.codecDesc.getStandard()));
        }
        this.codec.releaseOutputBuffer(index, false);
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec codec, int index) {
        MediaCodecWrapper mediaCodecWrapper;
        if (!this.running || (mediaCodecWrapper = this.codec) == null || mediaCodecWrapper.getRealCodec() != codec) {
            RXLogging.m283e(TAG, "onInputBufferAvailable not same codec");
        } else {
            synchronized (this.callbackLock) {
                this.inputBuffers.addLast(Integer.valueOf(index));
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
        MediaCodecWrapper mediaCodecWrapper;
        if (!this.running || (mediaCodecWrapper = this.codec) == null || mediaCodecWrapper.getRealCodec() != codec) {
            RXLogging.m283e(TAG, "onOutputBufferAvailable not same codec");
            return;
        }
        try {
            drainOutputData(index, info, codec.getOutputBuffer(index));
        } catch (Exception e) {
            RXLogging.m284e(TAG, "onOutputBufferAvailable failed", e);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec codec, MediaCodec.CodecException e) {
        MediaCodecWrapper mediaCodecWrapper;
        RXLogging.m287w(TAG, "mediacodec error: " + e.getDiagnosticInfo() + " " + e);
        if (!this.running || (mediaCodecWrapper = this.codec) == null || mediaCodecWrapper.getRealCodec() != codec) {
            RXLogging.m283e(TAG, "onError not same codec " + e);
        } else {
            synchronized (this.callbackLock) {
                this.isError = true;
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
        MediaCodecWrapper mediaCodecWrapper;
        if (!this.running || (mediaCodecWrapper = this.codec) == null || mediaCodecWrapper.getRealCodec() != codec) {
            RXLogging.m283e(TAG, "onOutputFormatChanged not same codec");
        } else {
            RXLogging.m285i(TAG, "output format changed: " + format.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        try {
            this.outputThreadChecker.checkIsOnValidThread();
        } catch (IllegalStateException unused) {
            RXLogging.m283e(TAG, "check thread error.");
        }
        RXLogging.m285i(TAG, "Releasing MediaCodec on output thread");
        final MediaCodecWrapper mediaCodecWrapper = this.codec;
        this.codec = null;
        if (this.releaseAsync) {
            try {
                new Thread(new Runnable() { // from class: com.bytedance.realx.video.HardwareVideoEncoder$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        HardwareVideoEncoder.this.m293xc85e0dbd(mediaCodecWrapper);
                    }
                }).start();
            } catch (Exception e) {
                RXLogging.m284e(TAG, "thread err when release codec", e);
            }
        } else if (mediaCodecWrapper != null) {
            try {
                mediaCodecWrapper.stop();
            } catch (Exception e2) {
                RXLogging.m284e(TAG, "Media encoder stop failed", e2);
            }
            try {
                mediaCodecWrapper.release();
            } catch (Exception e3) {
                RXLogging.m284e(TAG, "Media encoder release failed", e3);
                this.shutdownException = e3;
            }
        }
        this.configBuffer = null;
        RXLogging.m285i(TAG, "Release on output thread done");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseCodecOnOutputThread$1$com-bytedance-realx-video-HardwareVideoEncoder */
    public /* synthetic */ void m293xc85e0dbd(MediaCodecWrapper mediaCodecWrapper) {
        if (mediaCodecWrapper == null) {
            return;
        }
        RXLogging.m283e(TAG, "mediacodec release start!");
        try {
            mediaCodecWrapper.stop();
        } catch (Exception e) {
            RXLogging.m284e(TAG, "Media encoder stop failed", e);
        }
        try {
            mediaCodecWrapper.release();
        } catch (Exception e2) {
            RXLogging.m284e(TAG, "Media encoder release failed", e2);
            this.shutdownException = e2;
        }
        RXLogging.m283e(TAG, "mediacodec release end!");
    }

    private void caculateDts(long presentationTimeUs, EncodedImage.Builder builder) {
        if (isBFrameEnabled()) {
            Long pollLast = this.dtsQueue.pollLast();
            if (pollLast == null) {
                RXLogging.m283e(TAG, "dtsQueue is empty.");
                return;
            }
            if (!this.encodedFirstFrame) {
                this.encodedFirstFrame = true;
                this.firstFrameDiffUs = presentationTimeUs - pollLast.longValue();
                RXLogging.m287w(TAG, "firstFrameDiffUs: " + this.firstFrameDiffUs + " " + presentationTimeUs);
            }
            Long valueOf = Long.valueOf((pollLast.longValue() + this.firstFrameDiffUs) - ((1000000 / this.settings.targetFps) * 7));
            long longValue = presentationTimeUs - valueOf.longValue();
            if (valueOf.longValue() < 0 || longValue < 0) {
                RXLogging.m283e(TAG, "ctsUs < 0; " + longValue + " " + valueOf);
                return;
            }
            if (longValue == 0) {
                longValue = 1;
            }
            builder.setCompositionTimeUs(longValue);
        }
    }

    private VideoCodecStatus updateBitrate(int bitrateBitps) {
        this.encodeThreadChecker.checkIsOnValidThread();
        this.updateBitrate = bitrateBitps;
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("video-bitrate", bitrateBitps);
            this.codec.setParameters(bundle);
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "updateBitrate failed", e);
            return VideoCodecStatus.ERROR;
        }
    }

    private boolean canUseSurface() {
        return this.surfaceColorFormat != null;
    }

    private boolean isEncodingStatisticsSupported() {
        MediaCodecInfo codecInfo;
        MediaCodecInfo.CodecCapabilities capabilitiesForType;
        if (this.codecDesc.standard == RXVideoCodecStandard.VP8 || (codecInfo = this.codec.getCodecInfo()) == null || (capabilitiesForType = codecInfo.getCapabilitiesForType(this.codecDesc.standard.mimeType())) == null || Build.VERSION.SDK_INT < 33) {
            return false;
        }
        return capabilitiesForType.isFeatureSupported("encoding-statistics");
    }

    private void resetCodecWhenBitrateChange() {
        if ((isDeviceSupportResetBitrate() || this.updateBitrate == this.settings.targetBps || SystemClock.elapsedRealtime() - this.updateBitrateTimestamp < Constants.TASK_RUN_THRESHOLD) ? false : true) {
            resetCodec(this.useSurfaceMode);
        }
    }

    private boolean isForceUseSurfaceInput(int width) {
        if ((this.codecName.toLowerCase().contains("qti") || this.codecName.toLowerCase().contains("qcom")) && isBFrameEnabled()) {
            return true;
        }
        Boolean bool = this.forceSurfaceInput;
        if ((bool == null || !bool.booleanValue() || this.isNeedSurfaceInputWorkaround) ? false : true) {
            return true;
        }
        return this.isNeedSurfaceInputWorkaround && width % 16 != 0;
    }

    private boolean isDeviceSupportResetBitrate() {
        return !"M2007J17C".equalsIgnoreCase(RXDeviceInfoAndroid.GetDeviceModel());
    }

    protected void fillInputBuffer(ByteBuffer buffer, RXVideoFrameInterface videoFrame) {
        this.yuvFormat.fillBuffer(buffer, videoFrame, this.width, this.height);
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("[0-9]+");
    }

    private void setIntegerParam(MediaFormat format, String paramKey, Integer paramValue) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(paramKey)) {
                if (isNumeric(entry.getValue())) {
                    format.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
                    RXLogging.m287w(TAG, "the encoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                    this.privateParams.remove(paramKey);
                    return;
                } else {
                    this.privateParams.remove(paramKey);
                    if (entry.getValue().length() > 0) {
                        RXLogging.m287w(TAG, "the encoder params " + entry.getKey() + " set by vpaas is invalid with value:" + entry.getValue() + ",skip it");
                    } else {
                        RXLogging.m287w(TAG, "the encoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                        return;
                    }
                }
            }
        }
        RXLogging.m287w(TAG, "encoder int params has been set with Key:" + paramKey + " Value:" + paramValue);
        format.setInteger(paramKey, paramValue.intValue());
    }

    private void setStringParam(MediaFormat format, String paramKey, String paramValue) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(paramKey)) {
                if (entry.getValue().length() > 0) {
                    format.setString(entry.getKey(), entry.getValue());
                    RXLogging.m287w(TAG, "the encoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                } else {
                    RXLogging.m287w(TAG, "the encoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                }
                this.privateParams.remove(paramKey);
                return;
            }
        }
        RXLogging.m287w(TAG, "encoder string params has been set with Key:" + paramKey + " Value:" + paramValue);
        format.setString(paramKey, paramValue);
    }

    private void setBitrateMode(MediaFormat format) {
        this.codec.getCodecInfo();
        if (VideoEncoder.BitrateMode.CBR == this.settings.bitrateMode || VideoEncoder.BitrateMode.AUTO == this.settings.bitrateMode) {
            setIntegerParam(format, "bitrate-mode", 2);
        } else {
            setIntegerParam(format, "bitrate-mode", 1);
        }
    }

    private void setBFrameMinMaxQP(MediaFormat format) {
        if (Build.VERSION.SDK_INT >= 31) {
            setIntegerParam(format, "video-qp-b-max", Integer.valueOf(this.settings.maxQp));
            setIntegerParam(format, "video-qp-b-min", Integer.valueOf(this.settings.minQp));
        }
        if (this.codecName.toLowerCase().contains("qti")) {
            setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-b-min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-b-max", Integer.valueOf(this.settings.maxQp));
        }
    }

    private void setIPFrameMinMaxQP(MediaFormat format) {
        if (Build.VERSION.SDK_INT >= 31) {
            setIntegerParam(format, "video-qp-i-min", Integer.valueOf(this.settings.minIQp));
            setIntegerParam(format, "video-qp-i-max", Integer.valueOf(this.settings.maxIQp));
            setIntegerParam(format, "video-qp-p-min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(format, "video-qp-p-max", Integer.valueOf(this.settings.maxQp));
        }
        setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(format, "vendor.qti-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(format, "vendor.rtc-ext-enc-qp-range.qp-i-min", Integer.valueOf(this.settings.minIQp));
        setIntegerParam(format, "vendor.rtc-ext-enc-qp-range.qp-i-max", Integer.valueOf(this.settings.maxIQp));
        setIntegerParam(format, "vendor.rtc-ext-enc-qp-range.qp-p-min", Integer.valueOf(this.settings.minQp));
        setIntegerParam(format, "vendor.rtc-ext-enc-qp-range.qp-p-max", Integer.valueOf(this.settings.maxQp));
        setIntegerParam(format, "vendor.rtc-ext-enc-low-latency.enable", 1);
        if (this.codecName.toLowerCase().contains("exynos")) {
            setIntegerParam(format, "vendor.sec-ext-enc-qp-range.I-minQP", Integer.valueOf(this.settings.minIQp));
            setIntegerParam(format, "vendor.sec-ext-enc-qp-range.I-maxQP", Integer.valueOf(this.settings.maxIQp));
            setIntegerParam(format, "vendor.sec-ext-enc-qp-range.P-maxQP", Integer.valueOf(this.settings.maxQp));
            setIntegerParam(format, "vendor.sec-ext-enc-qp-range.P-minQP", Integer.valueOf(this.settings.minQp));
        }
        if (this.codecName.toLowerCase().contains("mtk")) {
            setIntegerParam(format, "vendor.mtk.venc.dynamic.qpbound.min", Integer.valueOf(this.settings.minQp));
            setIntegerParam(format, "vendor.mtk.venc.dynamic.qpbound.max", Integer.valueOf(this.settings.maxQp));
        }
    }

    private void setProfileForRTC(MediaFormat format) {
        RXLogging.m287w(TAG, "close setting profile:" + this.settings.closeSetProfile);
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        if (this.settings.closeSetProfile) {
            return;
        }
        if (standard == RXVideoCodecStandard.H264) {
            RXVideoCodecProfile profile = this.codecDesc.getProfile();
            int i = C06982.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[profile.ordinal()];
            if (i == 1 || i == 2) {
                RXLogging.m287w(TAG, "setting high profile ");
                setIntegerParam(format, "profile", 8);
                setIntegerParam(format, "level", 256);
                return;
            } else if (i == 3 || i == 4 || i == 5) {
                RXLogging.m287w(TAG, "setting baseline profile ");
                setIntegerParam(format, "profile", 1);
                setIntegerParam(format, "level", 256);
                return;
            } else {
                RXLogging.m287w(TAG, "Unknown profile level id: " + profile + "default to baseline profile");
                setIntegerParam(format, "profile", 1);
                setIntegerParam(format, "level", 256);
                return;
            }
        }
        if (standard == RXVideoCodecStandard.ByteVC1) {
            RXVideoCodecProfile profile2 = this.codecDesc.getProfile();
            int i2 = C06982.$SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[profile2.ordinal()];
            if (i2 == 6) {
                setIntegerParam(format, "profile", 1);
                setIntegerParam(format, "level", 8);
                return;
            }
            if (i2 == 7) {
                setIntegerParam(format, "profile", 2);
                setIntegerParam(format, "level", 8);
                return;
            } else if (i2 == 8) {
                setIntegerParam(format, "profile", 4096);
                setIntegerParam(format, "level", 8);
                return;
            } else {
                RXLogging.m287w(TAG, "Unknown profile level id: " + profile2 + "default to Main profile");
                setIntegerParam(format, "profile", 1);
                setIntegerParam(format, "level", 8);
                return;
            }
        }
        if (standard == RXVideoCodecStandard.VP8) {
            setIntegerParam(format, "profile", 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.realx.video.HardwareVideoEncoder$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C06982 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile;

        static {
            int[] iArr = new int[RXVideoCodecProfile.values().length];
            $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile = iArr;
            try {
                iArr[RXVideoCodecProfile.ProfileHigh.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedHigh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileBaseline.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileConstrainedBaseline.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ProfileMain.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$bytedance$realx$video$RXVideoCodecProfile[RXVideoCodecProfile.ByteVC1ProfileMain10HDR10.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private void setProfileForLive(MediaFormat format) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel;
        RXVideoCodecStandard standard = this.codecDesc.getStandard();
        MediaCodecInfo codecInfo = this.codec.getCodecInfo();
        RXVideoCodecProfile profile = this.codecDesc.getProfile();
        int i = 1;
        if (standard == RXVideoCodecStandard.H264) {
            try {
                i = profile.toSystemProfile();
            } catch (Exception e) {
                RXLogging.m287w(TAG, "" + e);
            }
            MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = codecInfo.getCapabilitiesForType(standard.mimeType()).profileLevels;
            int length = codecProfileLevelArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    codecProfileLevel = null;
                    break;
                }
                codecProfileLevel = codecProfileLevelArr[i2];
                if (i == codecProfileLevel.profile) {
                    break;
                } else {
                    i2++;
                }
            }
            if (codecProfileLevel != null) {
                format.setInteger("profile", codecProfileLevel.profile);
                format.setInteger("level", codecProfileLevel.level);
                return;
            } else {
                RXLogging.m287w(TAG, "not set profile");
                return;
            }
        }
        if (standard == RXVideoCodecStandard.ByteVC1) {
            try {
                i = profile.toSystemProfile();
            } catch (Exception e2) {
                RXLogging.m287w(TAG, "" + e2);
            }
            format.setInteger("profile", i);
            format.setInteger("level", 256);
        }
    }

    void setColorSpace(MediaFormat format) {
        if (!this.useSurfaceMode && this.codecName.contains("OMX.hisi.") && this.settings.rangeId == 0 && (this.yuvColorFormat.intValue() == 19 || this.yuvColorFormat.intValue() == 21)) {
            RXLogging.m287w(TAG, "kirin chips skip setting MediaFormat COLOR_RANGE");
        } else if (this.settings.rangeId == 1) {
            RXLogging.m287w(TAG, "setting MediaFormat COLOR_RANGE_FULL");
            setIntegerParam(format, "color-range", 1);
        } else {
            RXLogging.m287w(TAG, "setting MediaFormat COLOR_RANGE_LIMITED");
            setIntegerParam(format, "color-range", 2);
        }
        setIntegerParam(format, "color-standard", 4);
        setIntegerParam(format, "color-transfer", 3);
    }

    private void setBFrameNumber(MediaFormat format) {
        RXVideoCodecProfile profile;
        if (isBFrameEnabled()) {
            if (this.codecDesc.getStandard() == RXVideoCodecStandard.H264 && (profile = this.codecDesc.getProfile()) != RXVideoCodecProfile.ProfileHigh && profile != RXVideoCodecProfile.ProfileConstrainedHigh) {
                RXLogging.m287w(TAG, "enabel b frame, set high profile explicitly");
                setIntegerParam(format, "profile", 8);
                setIntegerParam(format, "level", 256);
            }
            setIntegerParam(format, "max-bframes", 1);
            return;
        }
        setIntegerParam(format, "max-bframes", 0);
    }

    private void setSVCNumber(MediaFormat format) {
        if (Build.VERSION.SDK_INT < 25 || !isSvcEnabled()) {
            return;
        }
        setStringParam(format, "ts-schema", "android.generic." + this.settings.temporalLayerNum);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public enum YuvFormat {
        I420 { // from class: com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat.1
            @Override // com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer dstBuffer, RXVideoFrameInterface videoFrame, int dstWidth, int dstHeight) {
                RXVideoMemoryInterface andRetainVideoFrameMemory;
                if (videoFrame == null || (andRetainVideoFrameMemory = videoFrame.getAndRetainVideoFrameMemory()) == null) {
                    return;
                }
                if (andRetainVideoFrameMemory.getPixelFormat() == RXPixelFormat.kI420 && (andRetainVideoFrameMemory instanceof NativeRXByteMemory)) {
                    NativeRXByteMemory nativeRXByteMemory = (NativeRXByteMemory) andRetainVideoFrameMemory;
                    YuvHelper.I420Copy(nativeRXByteMemory.getPlaneData(0), nativeRXByteMemory.getPlaneLineSize(0), nativeRXByteMemory.getPlaneData(1), nativeRXByteMemory.getPlaneLineSize(1), nativeRXByteMemory.getPlaneData(2), nativeRXByteMemory.getPlaneLineSize(2), dstBuffer, videoFrame.getWidth(), videoFrame.getHeight(), dstWidth, dstHeight);
                } else {
                    RXVideoFrameInterface i420 = videoFrame.toI420();
                    if (i420 == null) {
                        andRetainVideoFrameMemory.release();
                        return;
                    }
                    RXVideoMemoryInterface andRetainVideoFrameMemory2 = i420.getAndRetainVideoFrameMemory();
                    if (andRetainVideoFrameMemory2 == null) {
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else if (!(andRetainVideoFrameMemory2 instanceof NativeRXByteMemory)) {
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else {
                        NativeRXByteMemory nativeRXByteMemory2 = (NativeRXByteMemory) andRetainVideoFrameMemory2;
                        YuvHelper.I420Copy(nativeRXByteMemory2.getPlaneData(0), nativeRXByteMemory2.getPlaneLineSize(0), nativeRXByteMemory2.getPlaneData(1), nativeRXByteMemory2.getPlaneLineSize(1), nativeRXByteMemory2.getPlaneData(2), nativeRXByteMemory2.getPlaneLineSize(2), dstBuffer, i420.getWidth(), i420.getHeight(), dstWidth, dstHeight);
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                    }
                }
                andRetainVideoFrameMemory.release();
            }
        },
        NV12 { // from class: com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat.2
            @Override // com.bytedance.realx.video.HardwareVideoEncoder.YuvFormat
            void fillBuffer(ByteBuffer dstBuffer, RXVideoFrameInterface videoFrame, int dstWidth, int dstHeight) {
                RXVideoMemoryInterface andRetainVideoFrameMemory;
                if (videoFrame == null || (andRetainVideoFrameMemory = videoFrame.getAndRetainVideoFrameMemory()) == null) {
                    return;
                }
                if (andRetainVideoFrameMemory.getPixelFormat() == RXPixelFormat.kNv12 && (andRetainVideoFrameMemory instanceof NativeRXByteMemory)) {
                    NativeRXByteMemory nativeRXByteMemory = (NativeRXByteMemory) andRetainVideoFrameMemory;
                    YuvHelper.NV12Copy(nativeRXByteMemory.getPlaneData(0), nativeRXByteMemory.getPlaneLineSize(0), nativeRXByteMemory.getPlaneData(1), nativeRXByteMemory.getPlaneLineSize(1), dstBuffer, videoFrame.getWidth(), videoFrame.getHeight(), dstWidth, dstHeight);
                } else {
                    RXVideoFrameInterface i420 = videoFrame.toI420();
                    if (i420 == null) {
                        andRetainVideoFrameMemory.release();
                        return;
                    }
                    RXVideoMemoryInterface andRetainVideoFrameMemory2 = i420.getAndRetainVideoFrameMemory();
                    if (andRetainVideoFrameMemory2 == null) {
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else if (!(andRetainVideoFrameMemory2 instanceof NativeRXByteMemory)) {
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                        andRetainVideoFrameMemory.release();
                        return;
                    } else {
                        NativeRXByteMemory nativeRXByteMemory2 = (NativeRXByteMemory) andRetainVideoFrameMemory2;
                        YuvHelper.I420ToNV12(nativeRXByteMemory2.getPlaneData(0), nativeRXByteMemory2.getPlaneLineSize(0), nativeRXByteMemory2.getPlaneData(1), nativeRXByteMemory2.getPlaneLineSize(1), nativeRXByteMemory2.getPlaneData(2), nativeRXByteMemory2.getPlaneLineSize(2), dstBuffer, i420.getWidth(), i420.getHeight(), dstWidth, dstHeight);
                        andRetainVideoFrameMemory2.release();
                        i420.release();
                    }
                }
                andRetainVideoFrameMemory.release();
            }
        };

        abstract void fillBuffer(ByteBuffer dstBuffer, RXVideoFrameInterface videoFrame, int dstWidth, int dstHeight);

        static YuvFormat valueOf(int colorFormat) {
            if (colorFormat == 19) {
                return I420;
            }
            if (colorFormat == 21 || colorFormat == 2141391872 || colorFormat == 2141391876) {
                return NV12;
            }
            throw new IllegalArgumentException("Unsupported colorFormat: " + colorFormat);
        }
    }

    private boolean isSvcEnabled() {
        return this.settings.temporalLayerNum > 1;
    }

    private boolean isBFrameEnabled() {
        return Build.VERSION.SDK_INT >= 29 && this.settings.bFrameNum > 0;
    }

    private int parseRealLayerNum(MediaFormat outputFormat) {
        String string = outputFormat.getString("ts-schema");
        if (TextUtils.isEmpty(string) || string.length() < 17) {
            RXLogging.m287w(TAG, "output temporal str is: " + string);
            return 1;
        }
        String substring = string.substring(16, 17);
        if (isNumeric(substring)) {
            try {
                int parseInt = Integer.parseInt(substring);
                if (parseInt <= this.settings.temporalLayerNum && parseInt > 0) {
                    return parseInt;
                }
            } catch (NumberFormatException e) {
                RXLogging.m283e(TAG, e.toString());
            }
        }
        RXLogging.m283e(TAG, "temporal layer invalid: " + string);
        return 1;
    }

    private void alignResolutionIfNeeded() {
        if (this.settings.enableAlignment) {
            if (this.codecWidthAlign == 0) {
                MediaCodecInfo.VideoCapabilities videoCapabilities = this.capabilities.getVideoCapabilities();
                int widthAlignment = videoCapabilities.getWidthAlignment();
                int heightAlignment = videoCapabilities.getHeightAlignment();
                this.codecWidthAlign = widthAlignment > 16 ? widthAlignment : 16;
                this.codecHeightAlign = heightAlignment > 4 ? heightAlignment : 4;
                RXLogging.m285i(TAG, "alignResolutionIfNeeded, capabilities align is: " + widthAlignment + "x" + heightAlignment + ", final codec align is: " + this.codecWidthAlign + "x" + this.codecHeightAlign);
            }
            int i = this.actualWidth;
            this.width = ((i + r3) - 1) & (~(this.codecWidthAlign - 1));
            int i2 = this.actualHeight;
            this.height = ((i2 + r3) - 1) & (~(this.codecHeightAlign - 1));
        } else {
            this.width = this.actualWidth;
            this.height = this.actualHeight;
        }
        RXLogging.m285i(TAG, "alignResolutionIfNeeded, actual: " + this.actualWidth + "x" + this.actualHeight + ", align to: " + this.width + "x" + this.height);
    }
}
