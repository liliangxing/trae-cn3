package com.bytedance.realx.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Range;
import android.view.Choreographer;
import android.view.Surface;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.notification.Constants;
import com.bytedance.pia.core.misc.UrlMatcher;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.realx.base.ThreadUtils;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.EncodedImage;
import com.bytedance.realx.video.MediaCodecTextureBufferHelper;
import com.bytedance.realx.video.VideoDecoder;
import com.bytedance.realx.video.memory.NativeRXByteMemory;
import com.bytedance.realx.video.memory.NativeRXVideoFrame;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class AndroidVideoDecoder extends MediaCodec.Callback implements VideoDecoder, VideoSink {
    private static final int ADAPTIVE_PLAYBACK_MAX_DIMENSION = 9000;
    private static final int DEFAULT_OUTPUT_FRAME_WAIT_TIME_MS = 16;
    private static final int DEQUEUE_INPUT_INDEX_TIME_US = 5000;
    private static final int DEQUEUE_INPUT_TIMEOUT_US = 500000;
    private static final int DEQUEUE_OUTPUT_BUFFER_TIMEOUT_US = 100000;
    private static final String DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE = "bytertc.hw.decoder.dr.vsync.cache.size";
    private static final int DIRECT_RENDER_MODE_BY_VSYNC = 2;
    private static final int DIRECT_RENDER_MODE_NONE = 0;
    private static final int DIRECT_RENDER_MODE_NORMAL = 1;
    private static final String ENABLE_CHECK_SYS_RESOLUTION_SUPPORT = "bytertc.check.sys.resolution.support.enable";
    private static final String FLAG_CHECK_TEXTURE_SIZE = "bytertc.hw.decoder.check.texture.size";
    private static final String FLAG_TEXTURE_MEMORY_REUSE = "bytertc.hw.decoder.texture.memory.reuse";
    private static final String HISI_DECODER_END_CODE = "bytertc.hisi.decoder.endcode.enable";
    private static final String MAX_EGL_NUM = "bytertc.hw.decoder.maxeglnum";
    private static final int MAX_OUTPUT_FRAME_WAIT_TIME_MS = 1300;
    private static final int MAX_RECREATE_DECODER_COUNT = 2;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 6000;
    private static final String MEDIA_FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String MEDIA_FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String MEDIA_FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String MEDIA_FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String MEDIA_FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String MEDIA_FORMAT_KEY_STRIDE = "stride";
    private static final int MIN_OUTPUT_FRAME_TIME_DELTA_MS = 10;
    private static final String NEW_INPUT_BUFFER_API = "bytertc.hw.decoder.newinputbuffer";
    private static final String NEW_OUTPUT_BUFFER_API = "bytertc.hw.decoder.newoutputbuffer";
    private static final String TAG = "AndroidVideoDecoder";
    private static final int TEXTURE_PLAYOUT_INSIDE_DECODER = 0;
    private static final int TEXTURE_PLAYOUT_OUTSIDE_DECODER = 1;
    private static int curEglContextNum = 0;
    private static int maxDirectRenderCacheSize = 5;
    private static int maxEglContextNum = 16;
    private Handler asyncHandler;
    private HandlerThread asyncOutputThread;
    private VideoDecoder.Callback callback;
    private MediaCodecWrapper codec;
    private final String codecName;
    private final RXVideoCodecStandard codecType;
    private int colorFormat;
    private Surface exSurface;
    private boolean hasDecodedFirstFrame;
    private int height;
    private boolean keyFrameRequired;
    private final MediaCodecWrapperFactory mediaCodecWrapperFactory;
    private SurfaceTextureHelper outSideSurfaceTextureHelper;
    private Thread outputThread;
    private DecodedTextureMetadata renderedTextureMetadata;
    private volatile boolean running;
    private VideoDecoder.Settings settings;
    private EglBase.Context sharedContext;
    private volatile Exception shutdownException;
    private int sliceHeight;
    private int stride;
    private Surface surface;
    private SurfaceTextureHelper surfaceTextureHelper;
    private int width;
    boolean enableHisiEndCode = true;
    boolean enableCheckSysResolutionSupport = false;
    boolean enableTextureSizeCheck = true;
    boolean enableTextureMemoryReuse = false;
    private int maxExSurfaceRecreateDecoderCount = 0;
    private Thread directRenderThread = null;
    private final Object outputBufferQueueLock = new Object();
    private LinkedBlockingQueue<OutputBufferInfo> outputBufferQueue = new LinkedBlockingQueue<>();
    private ThreadUtils.ThreadChecker outputThreadChecker = new ThreadUtils.ThreadChecker();
    private final Object dimensionLock = new Object();
    private int encoded_width = 0;
    private int encoded_height = 0;
    private final Object surfaceTextureHelperLock = new Object();
    private long lastOutputTime = 0;
    private long currentOutputTime = 0;
    private long lastInputTime = 0;
    private long currentInputTimeDelta = 0;
    private long packetCount2s = 0;
    private long timeForAvg = 0;
    private long avgInputTimeDelta = 0;
    private long inputFrameCount = 0;
    private long outputFrameCount = 0;
    private long dropDecodedFrameCount = 0;
    private long callbackDecodedFrameCount = 0;
    private long minFrameCache = -1;
    private long currentFrameCache = -1;
    private final Object smoothOutputLock = new Object();
    private boolean usingInternalSurfaceLast = true;
    private HashMap<String, String> privateParams = new HashMap<>();
    private HashMap<String, String> vpassPrivateParams = new HashMap<>();
    private boolean mustUseYUVoutput = false;
    private boolean useNewInputBufferAPI = true;
    private boolean useNewOutputBufferAPI = true;
    private boolean enable_adaptive_playback = false;
    private int adaptive_playback_max_width = 0;
    private int adaptive_playback_max_height = 0;
    private boolean enableRetryDeliver = false;
    private int maxTryCount = 16;
    private float minAccelerateRatio = 0.0f;
    private float maxDeaccelerateRatio = 1.0f;
    private int frameCacheThreshold = 2;
    private int directRenderMode = 2;
    private int texturePlayoutMode = 0;
    private final Object renderedTextureMetadataLock = new Object();
    private boolean useAsyncMode = false;
    private LinkedList<Integer> inputBuffers = new LinkedList<>();
    private final Object callbackLock = new Object();
    private AtomicBoolean isError = new AtomicBoolean(false);

    @Override // com.bytedance.realx.video.VideoDecoder
    public boolean getPrefersLateDecoding() {
        return true;
    }

    static /* synthetic */ long access$508(AndroidVideoDecoder androidVideoDecoder) {
        long j = androidVideoDecoder.dropDecodedFrameCount;
        androidVideoDecoder.dropDecodedFrameCount = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class OutputBufferInfo {
        final int bufferIndex;
        final long presentationTimestampUs;

        OutputBufferInfo(long presentationTimestampUs, int bufferIndex) {
            this.presentationTimestampUs = presentationTimestampUs;
            this.bufferIndex = bufferIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class DecodedTextureMetadata {
        final long presentationTimestampUs;

        DecodedTextureMetadata(long presentationTimestampUs) {
            this.presentationTimestampUs = presentationTimestampUs;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec codec, int index) {
        MediaCodecWrapper mediaCodecWrapper;
        if (this.running && (mediaCodecWrapper = this.codec) != null && mediaCodecWrapper.getRealCodec() == codec) {
            synchronized (this.callbackLock) {
                this.inputBuffers.addLast(Integer.valueOf(index));
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec codec, int index, MediaCodec.BufferInfo info) {
        MediaCodecWrapper mediaCodecWrapper;
        if (this.running && (mediaCodecWrapper = this.codec) != null && mediaCodecWrapper.getRealCodec() == codec) {
            try {
                drainOutputFrame(info, index);
            } catch (Exception e) {
                RXLogging.m283e(TAG, "" + e);
            }
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec codec, MediaCodec.CodecException e) {
        MediaCodecWrapper mediaCodecWrapper;
        if (this.running && (mediaCodecWrapper = this.codec) != null && mediaCodecWrapper.getRealCodec() == codec) {
            this.isError.set(true);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec codec, MediaFormat format) {
        MediaCodecWrapper mediaCodecWrapper;
        RXLogging.m283e(TAG, "onOutputFormatChanged ");
        if (this.running && (mediaCodecWrapper = this.codec) != null && mediaCodecWrapper.getRealCodec() == codec) {
            reformat(format);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidVideoDecoder(MediaCodecWrapperFactory mediaCodecWrapperFactory, String codecName, RXVideoCodecStandard codecType, int colorFormat) {
        if (!isSupportedColorFormat(colorFormat)) {
            throw new IllegalArgumentException("Unsupported color format: " + colorFormat);
        }
        RXLogging.m287w(TAG, "ctor name: " + codecName + " type: " + codecType + " color format(19:I420 21:NV12): " + colorFormat);
        this.mediaCodecWrapperFactory = mediaCodecWrapperFactory;
        this.codecName = codecName;
        this.codecType = codecType;
        this.colorFormat = colorFormat;
        this.width = 0;
        this.height = 0;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public void setExternalSurface(Surface surface) {
        MediaCodecWrapper mediaCodecWrapper;
        RXLogging.m287w(TAG, "set external surface:" + surface);
        if (surface != this.exSurface && (mediaCodecWrapper = this.codec) != null) {
            try {
                mediaCodecWrapper.setOutputSurface(surface);
            } catch (Exception e) {
                RXLogging.m283e(TAG, "setOutputSurface error:" + e);
            }
        }
        this.exSurface = surface;
        this.surface = null;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public void disableExternalSurface() {
        RXLogging.m287w(TAG, "disable external surface.");
        this.exSurface = null;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus initDecode(VideoDecoder.Settings settings, VideoDecoder.Callback callback) {
        this.callback = callback;
        this.settings = settings;
        if (settings.sharedContext != null) {
            this.sharedContext = settings.sharedContext;
        }
        this.useAsyncMode = settings.enableAsyncMode;
        int i = settings.directRenderMode;
        this.directRenderMode = i;
        if (i == 2) {
            this.texturePlayoutMode = 0;
        } else {
            this.texturePlayoutMode = settings.texturePlayoutMode;
        }
        return VideoCodecStatus.OK;
    }

    private boolean isNumeric(String str) {
        return str != null && str.matches("[0-9]+");
    }

    private boolean setAdaptivePlaybackParam(MediaFormat format, String paramKey, Integer paramValue) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(paramKey) && isNumeric(entry.getValue())) {
                int max = Math.max(Integer.parseInt(entry.getValue()), paramValue.intValue());
                if (max <= ADAPTIVE_PLAYBACK_MAX_DIMENSION && max > 0) {
                    format.setInteger(entry.getKey(), max);
                    RXLogging.m287w(TAG, "setAdaptivePlaybackParam params key: " + entry.getKey() + ", value:" + Math.max(Integer.parseInt(entry.getValue()), paramValue.intValue()) + " {privateConfig: " + Integer.parseInt(entry.getValue()) + ", resoluion: " + paramValue + "}");
                    return true;
                }
                RXLogging.m287w(TAG, "setAdaptivePlaybackParam failed! exceeding the valid range(0, 10000], key: " + entry.getKey() + ", value: " + max + " {privateConfig: " + Integer.parseInt(entry.getValue()) + ", resoluion: " + paramValue + "}");
                return false;
            }
        }
        RXLogging.m287w(TAG, "setAdaptivePlaybackParam, but private key isn't setted, params: " + paramKey);
        return false;
    }

    private void setIntegerParam(MediaFormat format, String paramKey, Integer paramValue) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(paramKey)) {
                if (isNumeric(entry.getValue())) {
                    format.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
                    RXLogging.m287w(TAG, "the decoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                    this.privateParams.remove(paramKey);
                    return;
                } else {
                    this.privateParams.remove(paramKey);
                    if (entry.getValue().length() > 0) {
                        RXLogging.m287w(TAG, "the decoder params " + entry.getKey() + " set by vpaas is invalid with value:" + entry.getValue() + ",skip it");
                    } else {
                        RXLogging.m287w(TAG, "the decoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                        return;
                    }
                }
            }
        }
        RXLogging.m287w(TAG, "decoder int params has been set with Key:" + paramKey + " Value:" + paramValue);
        format.setInteger(paramKey, paramValue.intValue());
    }

    private void setStringParam(MediaFormat format, String paramKey, String paramValue) {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(paramKey)) {
                if (entry.getValue().length() > 0) {
                    format.setString(entry.getKey(), entry.getValue());
                    RXLogging.m287w(TAG, "the decoder params " + entry.getKey() + " is coverd by vpaas with value:" + entry.getValue());
                } else {
                    RXLogging.m287w(TAG, "the decoder params " + entry.getKey() + " is disabled by vpaas,skip it");
                }
                this.privateParams.remove(paramKey);
                return;
            }
        }
        RXLogging.m287w(TAG, "decoder string params has been set with Key:" + paramKey + " Value:" + paramValue);
        format.setString(paramKey, paramValue);
    }

    private void initMediaFormat(MediaFormat format) {
        if ((this.sharedContext == null || this.settings.enableYUVOutput) && this.exSurface == null) {
            RXLogging.m287w(TAG, "init colorFormat is(I420:19):" + this.colorFormat);
            setIntegerParam(format, "color-format", Integer.valueOf(this.colorFormat));
        }
        if (this.codec != null && this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).isFeatureSupported("adaptive-playback")) {
            boolean z = setAdaptivePlaybackParam(format, "max-width", Integer.valueOf(format.getInteger("width"))) && setAdaptivePlaybackParam(format, "max-height", Integer.valueOf(format.getInteger("height")));
            this.enable_adaptive_playback = z;
            if (z) {
                this.adaptive_playback_max_width = format.getInteger("max-width");
                this.adaptive_playback_max_height = format.getInteger("max-height");
                RXLogging.m287w(TAG, "enable adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);
            }
        }
        if (this.settings.outputByDts && !this.settings.latencyInsensitiveMode) {
            setIntegerParam(format, "low-latency", 1);
            setIntegerParam(format, "vendor.qti-ext-dec-picture-order.enable", 1);
            setIntegerParam(format, "vendor.qti-ext-dec-low-latency.enable", 1);
            setIntegerParam(format, "vendor.rtc-ext-dec-low-latency.enable", 1);
            if (this.width < this.height) {
                setIntegerParam(format, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
            }
            setIntegerParam(format, "vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            setIntegerParam(format, "fast-output-mode", 1);
            setStringParam(format, "vendor.vdec.example-ext-dec-low-latency.enable", RouterConstants.TRUE);
        }
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (!entry.getKey().equals("max-width") && !entry.getKey().equals("max-height")) {
                RXLogging.m287w(TAG, "set android hardware decoder private param with Key:" + entry.getKey() + " Value:" + entry.getValue());
                if (entry.getKey().equals(HISI_DECODER_END_CODE) && ViewVisibleBridge.INVISIBLE.equals(entry.getValue())) {
                    this.enableHisiEndCode = false;
                    RXLogging.m287w(TAG, "set android hardware decoder close hisi hw decoder endcode");
                } else {
                    RXLogging.m287w(TAG, "set android hardware decoder private param with Key:" + entry.getKey() + " Value:" + entry.getValue());
                    if (isNumeric(entry.getValue())) {
                        format.setInteger(entry.getKey(), Integer.parseInt(entry.getValue()));
                    } else if (entry.getValue().length() > 0) {
                        format.setString(entry.getKey(), entry.getValue());
                    }
                }
            }
        }
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus setPrivateParam(String key, String value) {
        RXLogging.m287w(TAG, "got android hardware decoder setPrivateParam key:" + key + " value:" + value);
        if (key.equals(DIRECT_RENDER_BY_VSYNC_MAX_CACHE_SIZE)) {
            if (isNumeric(value)) {
                maxDirectRenderCacheSize = Integer.parseInt(value);
            }
            return VideoCodecStatus.OK;
        }
        if (key.equals(MAX_EGL_NUM)) {
            if (isNumeric(value)) {
                maxEglContextNum = Integer.parseInt(value);
            }
            RXLogging.m287w(TAG, "this is not a param set to HW Decoder, only for control.");
            return VideoCodecStatus.OK;
        }
        if (key.equals(FLAG_CHECK_TEXTURE_SIZE)) {
            this.enableTextureSizeCheck = RouterConstants.TRUE.equalsIgnoreCase(value);
            RXLogging.m287w(TAG, "set FLAG_CHECK_TEXTURE_SIZE to " + this.enableTextureSizeCheck);
            return VideoCodecStatus.OK;
        }
        if (key.equals(FLAG_TEXTURE_MEMORY_REUSE)) {
            this.enableTextureMemoryReuse = RouterConstants.TRUE.equalsIgnoreCase(value);
            RXLogging.m287w(TAG, "set FLAG_TEXTURE_MEMORY_REUSE to " + this.enableTextureMemoryReuse);
            return VideoCodecStatus.OK;
        }
        if (key.equals(NEW_INPUT_BUFFER_API)) {
            if (isNumeric(value)) {
                this.useNewInputBufferAPI = Integer.parseInt(value) >= 1;
            }
            RXLogging.m287w(TAG, "this is not a param set to HW Decoder, only for control. useNewInputBufferAPI:" + this.useNewInputBufferAPI);
            return VideoCodecStatus.OK;
        }
        if (key.equals(NEW_OUTPUT_BUFFER_API)) {
            if (isNumeric(value)) {
                this.useNewOutputBufferAPI = Integer.parseInt(value) >= 1;
            }
            RXLogging.m287w(TAG, "this is not a param set to HW Decoder, only for control. useNewOutputBufferAPI:" + this.useNewOutputBufferAPI);
            return VideoCodecStatus.OK;
        }
        this.vpassPrivateParams.put(key, value);
        return VideoCodecStatus.OK;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus updateSettings(VideoDecoder.Settings setting) {
        this.settings = setting;
        RXLogging.m287w(TAG, "updateSettings outputByDts:" + this.settings.outputByDts + ", smoothOutput:" + this.settings.enableSmoothOutput + ", yuv mode:" + this.settings.enableYUVOutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", context: " + this.settings.sharedContext + ", enableAsyncMode:" + setting.enableAsyncMode + ", directRenderMode:" + setting.directRenderMode + ", texturePlayoutMode:" + setting.texturePlayoutMode);
        return VideoCodecStatus.OK;
    }

    private void updateCheckSysResolutionStatus() {
        for (Map.Entry<String, String> entry : this.privateParams.entrySet()) {
            if (entry.getKey().equals(ENABLE_CHECK_SYS_RESOLUTION_SUPPORT)) {
                if (entry.getValue() == ViewVisibleBridge.INVISIBLE) {
                    this.enableCheckSysResolutionSupport = false;
                    RXLogging.m287w(TAG, "set android hardware decoder close check sys resolution support");
                } else if (entry.getValue() == "1") {
                    this.enableCheckSysResolutionSupport = true;
                    RXLogging.m287w(TAG, "set android hardware decoder open check sys resolution support");
                }
            }
        }
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus setDeliverParams(boolean enable, int maxTryCount, float minAccelerateRatio, float maxDeaccelerateRatio, int frameCacheThreshold) {
        RXLogging.m287w(TAG, "got android hardware decoder setDeliverParams enable:" + enable + ", maxTryCount:" + maxTryCount + ", minAccelerateRatio:" + minAccelerateRatio + ", maxDeaccelerateRatio:" + maxDeaccelerateRatio + ", frameCacheThreshold:" + frameCacheThreshold);
        this.enableRetryDeliver = enable;
        this.maxTryCount = maxTryCount;
        this.minAccelerateRatio = minAccelerateRatio;
        this.maxDeaccelerateRatio = maxDeaccelerateRatio;
        this.frameCacheThreshold = frameCacheThreshold;
        return VideoCodecStatus.OK;
    }

    private VideoCodecStatus initSurfaceTextureHelper() {
        try {
            if ((this.sharedContext != null || this.settings.enableAGFXSurfaceTextureHelper) && this.exSurface == null && !this.settings.enableYUVOutput && curEglContextNum < maxEglContextNum && (this.surfaceTextureHelper == null || !this.settings.enableSurfaceTextureReuse)) {
                SurfaceTextureHelper createSurfaceTextureHelper = createSurfaceTextureHelper();
                this.surfaceTextureHelper = createSurfaceTextureHelper;
                initSurfaceTextureHelper(createSurfaceTextureHelper, false);
            }
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.m283e(TAG, "err when create surface:" + e);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus initOutSideSurfaceTextureHelper(int width, int height) {
        try {
            if (!this.settings.enableYUVOutput && curEglContextNum < maxEglContextNum && this.outSideSurfaceTextureHelper == null) {
                SurfaceTextureHelper createSurfaceTextureHelper = createSurfaceTextureHelper();
                this.outSideSurfaceTextureHelper = createSurfaceTextureHelper;
                initSurfaceTextureHelper(createSurfaceTextureHelper, true);
            }
            return VideoCodecStatus.OK;
        } catch (Exception e) {
            RXLogging.m283e(TAG, "err when create surface:" + e);
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    private VideoCodecStatus initDecodeInternal(int width, int height) {
        VideoCodecStatus initSurfaceTextureHelper;
        Surface surface;
        if (this.callback == null) {
            RXLogging.m282d(TAG, "callback uninitalized");
            return VideoCodecStatus.UNINITIALIZED;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        VideoCodecStatus videoCodecStatus = VideoCodecStatus.ERROR;
        if (1 == this.texturePlayoutMode) {
            initSurfaceTextureHelper = initOutSideSurfaceTextureHelper(width, height);
        } else {
            initSurfaceTextureHelper = initSurfaceTextureHelper();
        }
        if (initSurfaceTextureHelper != VideoCodecStatus.OK) {
            return initSurfaceTextureHelper;
        }
        RXLogging.m287w(TAG, "initDecodeInternal name: " + this.codecName + " type: " + this.codecType + " width: " + width + " height: " + height + " sharedContext:" + this.sharedContext + " outputByDts:" + this.settings.outputByDts + ", external surface:" + this.exSurface + ", internal surface:" + this.surface + " smoothOutput:" + this.settings.enableSmoothOutput + " yuv mode:" + this.settings.enableYUVOutput + " mustUseYUVoutput:" + this.mustUseYUVoutput + ", latencyInsensitiveMode:" + this.settings.latencyInsensitiveMode + ", enableRecreateByResolution:" + this.settings.enableRecreateByResolution + ", enableBFrameDecode:" + this.settings.enableBFrameDecode + ", useAsyncMode:" + this.useAsyncMode + ", texturePlayoutMode:" + this.texturePlayoutMode + ", directRenderMode:" + this.directRenderMode + ", curEglContextNum:" + curEglContextNum);
        if (this.outputThread != null) {
            RXLogging.m283e(TAG, "initDecodeInternal called while the codec is already running");
            releaseSurface();
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
        this.width = width;
        this.height = height;
        this.stride = width;
        this.sliceHeight = height;
        this.hasDecodedFirstFrame = false;
        this.keyFrameRequired = true;
        this.inputFrameCount = 0L;
        this.outputFrameCount = 0L;
        this.dropDecodedFrameCount = 0L;
        this.callbackDecodedFrameCount = 0L;
        this.minFrameCache = -1L;
        this.currentFrameCache = -1L;
        this.privateParams.clear();
        this.privateParams.putAll(this.vpassPrivateParams);
        this.isError.set(false);
        synchronized (this.callbackLock) {
            this.inputBuffers.clear();
        }
        try {
            this.codec = this.mediaCodecWrapperFactory.createByCodecName(this.codecName);
            updateCheckSysResolutionStatus();
            if (this.enableCheckSysResolutionSupport && !this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType()).getVideoCapabilities().isSizeSupported(width, height)) {
                this.codec.release();
                releaseSurface();
                RXLogging.m287w(TAG, "isSizeSupported return false with the resolution:" + width + "xheight, fallback software");
                this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "isSizeSupported return false with the resolution:" + width + "x" + height);
                return VideoCodecStatus.FALLBACK_SOFTWARE;
            }
            try {
                MediaFormat createVideoFormat = MediaFormat.createVideoFormat(this.codecType.mimeType(), width, height);
                initMediaFormat(createVideoFormat);
                if (this.useAsyncMode) {
                    HandlerThread handlerThread = new HandlerThread("asyncOutput");
                    this.asyncOutputThread = handlerThread;
                    handlerThread.start();
                    this.asyncHandler = new Handler(this.asyncOutputThread.getLooper());
                    this.running = true;
                    this.outputThreadChecker.detachThread();
                    this.codec.setCallback(this, this.asyncHandler);
                }
                int i = this.maxExSurfaceRecreateDecoderCount;
                if (i >= -1) {
                    this.exSurface = null;
                }
                if (this.outSideSurfaceTextureHelper != null && (surface = this.surface) != null) {
                    this.codec.configure(createVideoFormat, surface, null, 0);
                    RXLogging.m287w(TAG, "init codec done control by outside with internal surface:" + this.surface);
                } else {
                    Surface surface2 = this.exSurface;
                    if (surface2 != null) {
                        this.maxExSurfaceRecreateDecoderCount = i + 1;
                        this.codec.configure(createVideoFormat, surface2, null, 0);
                        RXLogging.m287w(TAG, "init codec done with external surface:" + this.exSurface);
                    } else {
                        this.codec.configure(createVideoFormat, this.surface, null, 0);
                        RXLogging.m287w(TAG, "init codec done with internal surface:" + this.surface);
                    }
                }
                this.codec.start();
            } catch (IllegalArgumentException | IllegalStateException unused) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = this.codec.getCodecInfo().getCapabilitiesForType(this.codecType.mimeType());
                RXLogging.m287w(TAG, "current decoder SupportedHeights:" + capabilitiesForType.getVideoCapabilities().getSupportedHeights());
                RXLogging.m287w(TAG, "current decoder SupportedWidths:" + capabilitiesForType.getVideoCapabilities().getSupportedWidths());
                RXLogging.m287w(TAG, "current decoder SupportedFrameRates:" + capabilitiesForType.getVideoCapabilities().getSupportedFrameRates());
                if (!capabilitiesForType.getVideoCapabilities().getSupportedHeights().contains((Range<Integer>) Integer.valueOf(height)) || !capabilitiesForType.getVideoCapabilities().getSupportedWidths().contains((Range<Integer>) Integer.valueOf(width))) {
                    this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_OUT_OF_RESOLUTION, "hardware decoder not support the resolution:" + width + "x" + height);
                    this.codec.release();
                    releaseSurface();
                    RXLogging.m287w(TAG, "initDecodeInternal err,decoder not support the resolution:" + width + "xheight, fallback software");
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
                RXLogging.m283e(TAG, "initDecode Argument err, try reset Argument and reconfig");
                this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, "initDecode Argument err, try reset Argument and reconfig");
                MediaFormat createVideoFormat2 = MediaFormat.createVideoFormat(this.codecType.mimeType(), width, height);
                if (this.sharedContext == null || this.settings.enableYUVOutput) {
                    createVideoFormat2.setInteger("color-format", this.colorFormat);
                }
                try {
                    this.codec.configure(createVideoFormat2, this.surface, null, 0);
                    this.codec.start();
                } catch (IllegalArgumentException | IllegalStateException e) {
                    RXLogging.m283e(TAG, "initDecode failed when retry config:" + e);
                    StringWriter stringWriter = new StringWriter();
                    e.printStackTrace(new PrintWriter(stringWriter));
                    this.callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, stringWriter.toString());
                    this.codec.release();
                    releaseSurface();
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            }
            this.maxExSurfaceRecreateDecoderCount = 0;
            if (!this.useAsyncMode) {
                this.running = true;
                try {
                    this.outputThreadChecker.detachThread();
                    Thread createOutputThread = createOutputThread();
                    this.outputThread = createOutputThread;
                    createOutputThread.start();
                } catch (Exception e2) {
                    this.codec.release();
                    releaseSurface();
                    RXLogging.m284e(TAG, "outputThread create err, fallback software:", e2);
                    return VideoCodecStatus.FALLBACK_SOFTWARE;
                }
            }
            if (this.directRenderMode == 2) {
                createDirectRenderVSyncThread();
            }
            RXLogging.m287w(TAG, "initDecodeInternal done,init video decoder cost time:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            Surface surface3 = this.exSurface;
            if (surface3 != null && this.surface == null) {
                this.usingInternalSurfaceLast = false;
            } else if (surface3 == null && this.surface != null && !this.usingInternalSurfaceLast) {
                this.usingInternalSurfaceLast = true;
                this.callback.onMediaCodecStatus(VideoCodecStatus.USING_INTERNAL_SURFACE, "using internal surface");
            }
            return VideoCodecStatus.OK;
        } catch (IOException | IllegalArgumentException | IllegalStateException | NullPointerException unused2) {
            RXLogging.m283e(TAG, "Cannot create media decoder " + this.codecName);
            releaseSurface();
            return VideoCodecStatus.FALLBACK_SOFTWARE;
        }
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus decode(EncodedImage frame) {
        VideoCodecStatus reinitDecode;
        VideoCodecStatus feedInputBufferSync;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.lastInputTime;
        if (j > 0) {
            this.currentInputTimeDelta = elapsedRealtime - j;
        }
        this.lastInputTime = elapsedRealtime;
        long j2 = this.packetCount2s + 1;
        this.packetCount2s = j2;
        if (0 == this.timeForAvg) {
            this.timeForAvg = elapsedRealtime;
        }
        long j3 = this.timeForAvg;
        if (elapsedRealtime - j3 >= 2000 && j2 > 0) {
            this.avgInputTimeDelta = (elapsedRealtime - j3) / j2;
            this.packetCount2s = 0L;
            this.timeForAvg = elapsedRealtime;
        }
        if (this.isError.get()) {
            RXLogging.m283e(TAG, "mediacodec error.");
            return VideoCodecStatus.ERROR;
        }
        try {
            boolean z = true;
            if (frame.encodedWidth != this.encoded_width || frame.encodedHeight != this.encoded_height) {
                if (this.codec != null && this.enable_adaptive_playback && (frame.encodedWidth > this.adaptive_playback_max_width || frame.encodedHeight > this.adaptive_playback_max_height)) {
                    RXLogging.m287w(TAG, "frame resolution(" + frame.encodedWidth + UrlMatcher.WILDCARD + frame.encodedHeight + " exceeded maximum limit of adaptive playback max_width: " + this.adaptive_playback_max_width + ", max_height: " + this.adaptive_playback_max_height);
                    this.enable_adaptive_playback = false;
                }
                RXLogging.m287w(TAG, "resolution changed, try to reinit decoder. enable_adaptive_playback: " + this.enable_adaptive_playback + ", is first init: " + (this.encoded_width == 0) + ", new width: " + frame.encodedWidth + ", new height: " + frame.encodedHeight);
                if ((this.encoded_width == 0 || !this.enable_adaptive_playback) && (reinitDecode = reinitDecode(frame.encodedWidth, frame.encodedHeight)) != VideoCodecStatus.OK) {
                    return reinitDecode;
                }
                synchronized (this.dimensionLock) {
                    this.encoded_width = frame.encodedWidth;
                    this.encoded_height = frame.encodedHeight;
                    this.width = frame.encodedWidth;
                    this.height = frame.encodedHeight;
                }
            }
            if (this.codec != null && this.callback != null) {
                if (frame.buffer == null) {
                    RXLogging.m283e(TAG, "decode() - no input data");
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                if (frame.buffer.remaining() == 0) {
                    RXLogging.m283e(TAG, "decode() - input buffer empty");
                    return VideoCodecStatus.ERR_PARAMETER;
                }
                if (this.keyFrameRequired) {
                    if (frame.frameType != EncodedImage.FrameType.kIntra) {
                        RXLogging.m283e(TAG, "decode() - key frame required first");
                        return VideoCodecStatus.NO_OUTPUT;
                    }
                    if (!frame.completeFrame) {
                        RXLogging.m283e(TAG, "decode() - complete frame required first");
                        return VideoCodecStatus.NO_OUTPUT;
                    }
                }
                VideoCodecStatus videoCodecStatus = VideoCodecStatus.OK;
                if (this.useAsyncMode) {
                    feedInputBufferSync = feedInputBufferAsync(frame);
                } else {
                    feedInputBufferSync = feedInputBufferSync(frame);
                }
                if (feedInputBufferSync != VideoCodecStatus.OK) {
                    return feedInputBufferSync;
                }
                if (this.keyFrameRequired) {
                    this.keyFrameRequired = false;
                }
                if (this.settings.enableSmoothOutput && !this.settings.latencyInsensitiveMode && !this.settings.enableBFrameDecode) {
                    long j4 = this.inputFrameCount - this.outputFrameCount;
                    if (j4 <= 0) {
                        j4 = this.currentFrameCache;
                    }
                    this.currentFrameCache = j4;
                    long j5 = this.minFrameCache;
                    if (j5 >= 0 && j4 > j5) {
                        try {
                            synchronized (this.smoothOutputLock) {
                                this.smoothOutputLock.notify();
                            }
                        } catch (Exception unused) {
                            RXLogging.m283e(TAG, "currentFrameCache:" + this.currentFrameCache + " minFrameCache:" + this.minFrameCache);
                        }
                    }
                }
                this.inputFrameCount++;
                return VideoCodecStatus.OK;
            }
            StringBuilder sb = new StringBuilder("decode uninitalized, codec: ");
            if (this.codec == null) {
                z = false;
            }
            RXLogging.m282d(TAG, sb.append(z).append(", callback: ").append(this.callback).toString());
            return VideoCodecStatus.UNINITIALIZED;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "android decode err", e);
            return VideoCodecStatus.ERROR;
        }
    }

    private VideoCodecStatus feedInputBufferAsync(EncodedImage frame) {
        int intValue;
        int remaining = frame.buffer.remaining();
        int i = (this.settings.latencyInsensitiveMode ? Constants.NOTIFICATION_STRIP_REMOTEVIEW_SIZE_BYTES : DEQUEUE_INPUT_TIMEOUT_US) / DEQUEUE_INPUT_INDEX_TIME_US;
        do {
            synchronized (this.callbackLock) {
                intValue = this.inputBuffers.size() <= 0 ? -1 : this.inputBuffers.removeFirst().intValue();
            }
            if (intValue == -1) {
                i--;
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException e) {
                    RXLogging.m285i(TAG, "" + e);
                }
            }
            if (intValue != -1) {
                break;
            }
        } while (i > 0);
        if (intValue == -1) {
            RXLogging.m287w(TAG, "decode() - no HW buffers available; decoder falling behind");
            return VideoCodecStatus.OVERLOAD;
        }
        try {
            ByteBuffer inputBuffer = this.codec.getInputBuffer(intValue);
            if (inputBuffer.capacity() < remaining) {
                RXLogging.m283e(TAG, "decode() - HW buffer too small");
                return VideoCodecStatus.OVERLOAD;
            }
            inputBuffer.put(frame.buffer);
            try {
                this.codec.queueInputBuffer(intValue, 0, appendHisiEndCode(inputBuffer, remaining), TimeUnit.NANOSECONDS.toMicros(frame.captureTimeNs), 0);
                return VideoCodecStatus.OK;
            } catch (IllegalStateException e2) {
                RXLogging.m284e(TAG, "queueInputBuffer failed", e2);
                return VideoCodecStatus.ERROR;
            }
        } catch (Exception e3) {
            RXLogging.m284e(TAG, "getInputBuffer failed", e3);
            return VideoCodecStatus.ERROR;
        }
    }

    private VideoCodecStatus feedInputBufferSync(EncodedImage frame) {
        ByteBuffer byteBuffer;
        int remaining = frame.buffer.remaining();
        try {
            int dequeueInputBuffer = this.codec.dequeueInputBuffer(this.settings.latencyInsensitiveMode ? 5000000L : 500000L);
            if (dequeueInputBuffer < 0) {
                RXLogging.m283e(TAG, "decode() - no HW buffers available; decoder falling behind");
                return VideoCodecStatus.OVERLOAD;
            }
            try {
                if (this.useNewInputBufferAPI) {
                    byteBuffer = this.codec.getInputBuffer(dequeueInputBuffer);
                } else {
                    byteBuffer = this.codec.getInputBuffers()[dequeueInputBuffer];
                }
                if (byteBuffer == null) {
                    RXLogging.m283e(TAG, "decode() - HW buffer is null");
                    return VideoCodecStatus.OVERLOAD;
                }
                if (byteBuffer.remaining() < remaining) {
                    RXLogging.m283e(TAG, "decode() - HW buffer too small");
                    return VideoCodecStatus.OVERLOAD;
                }
                byteBuffer.put(frame.buffer);
                try {
                    this.codec.queueInputBuffer(dequeueInputBuffer, 0, appendHisiEndCode(byteBuffer, remaining), TimeUnit.NANOSECONDS.toMicros(frame.captureTimeNs), 0);
                    return VideoCodecStatus.OK;
                } catch (IllegalStateException e) {
                    RXLogging.m284e(TAG, "queueInputBuffer failed", e);
                    return VideoCodecStatus.ERROR;
                }
            } catch (Exception e2) {
                RXLogging.m283e(TAG, "getInputBuffers failed,useNewInputBufferAPI" + this.useNewInputBufferAPI + "exception:" + e2);
                return VideoCodecStatus.ERROR;
            }
        } catch (IllegalStateException e3) {
            RXLogging.m284e(TAG, "dequeueInputBuffer failed", e3);
            return VideoCodecStatus.ERROR;
        }
    }

    private int appendHisiEndCode(ByteBuffer buffer, int size) {
        if (!this.enableHisiEndCode || !this.codecName.startsWith("OMX.hisi")) {
            return size;
        }
        byte[] bArr = {0, 0, 0, 1, 30, 72, 83, 80, 73, 67, 69, 78, 68, 0, 0, 0, 1, 0};
        int i = size + 18;
        if (buffer.capacity() < i) {
            return size;
        }
        buffer.put(bArr);
        return i;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public String getImplementationName() {
        return this.codecName;
    }

    @Override // com.bytedance.realx.video.VideoDecoder
    public VideoCodecStatus release() {
        RXLogging.m287w(TAG, "mediacodec release start");
        VideoCodecStatus releaseInternal = releaseInternal();
        releaseSurface();
        releaseSurfaceTextureHelper();
        synchronized (this.renderedTextureMetadataLock) {
            this.renderedTextureMetadata = null;
        }
        this.callback = null;
        this.encoded_width = 0;
        this.encoded_height = 0;
        return releaseInternal;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private VideoCodecStatus releaseInternal() {
        if (!this.running) {
            RXLogging.m282d(TAG, "release: Decoder is not running.");
            return VideoCodecStatus.OK;
        }
        try {
            Thread thread = this.directRenderThread;
            if (thread != null) {
                thread.join(6000L);
                this.directRenderThread = null;
            }
        } catch (Exception e) {
            RXLogging.m284e(TAG, "directRenderThread join error", e);
        }
        if (this.useAsyncMode) {
            VideoCodecStatus videoCodecStatus = VideoCodecStatus.OK;
            this.running = false;
            final HandlerThread handlerThread = this.asyncOutputThread;
            if (handlerThread != null) {
                this.asyncHandler.post(new Runnable() { // from class: com.bytedance.realx.video.AndroidVideoDecoder$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidVideoDecoder.this.m291x31e4d2f4(handlerThread);
                    }
                });
                if (!ThreadUtils.joinUninterruptibly(this.asyncOutputThread, 6000L)) {
                    RXLogging.m284e(TAG, "Media decoder release timeout", new RuntimeException());
                    videoCodecStatus = VideoCodecStatus.TIMEOUT;
                }
                this.asyncOutputThread = null;
                this.asyncHandler = null;
            }
            return videoCodecStatus;
        }
        try {
            this.running = false;
            if (!ThreadUtils.joinUninterruptibly(this.outputThread, 6000L)) {
                RXLogging.m284e(TAG, "Media decoder release timeout", new RuntimeException());
                return VideoCodecStatus.TIMEOUT;
            }
            this.codec = null;
            this.outputThread = null;
            if (this.shutdownException != null) {
                RXLogging.m284e(TAG, "Media decoder release error", new RuntimeException(this.shutdownException));
                this.shutdownException = null;
                return VideoCodecStatus.ERROR;
            }
            return VideoCodecStatus.OK;
        } finally {
            this.codec = null;
            this.outputThread = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$releaseInternal$0$com-bytedance-realx-video-AndroidVideoDecoder */
    public /* synthetic */ void m291x31e4d2f4(HandlerThread handlerThread) {
        releaseCodecOnOutputThread();
        if (handlerThread != null) {
            handlerThread.quit();
        }
    }

    private VideoCodecStatus reinitDecode(int newWidth, int newHeight) {
        VideoCodecStatus releaseInternal = releaseInternal();
        if (!this.settings.enableSurfaceTextureReuse) {
            releaseSurface();
        }
        if (releaseInternal != VideoCodecStatus.OK) {
            RXLogging.m283e(TAG, "releaseInternal err");
            return releaseInternal;
        }
        VideoCodecStatus videoCodecStatus = VideoCodecStatus.FALLBACK_SOFTWARE;
        for (int i = 0; i < 2 && VideoCodecStatus.OK != (videoCodecStatus = initDecodeInternal(newWidth, newHeight)); i++) {
            releaseSurface();
        }
        return videoCodecStatus;
    }

    private void createDirectRenderVSyncThread() {
        Thread thread = new Thread(new Runnable() { // from class: com.bytedance.realx.video.AndroidVideoDecoder.1
            @Override // java.lang.Runnable
            public void run() {
                AndroidVideoDecoder.this.directRenderByVSync();
            }
        });
        this.directRenderThread = thread;
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void directRenderByVSync() {
        try {
            Looper.prepare();
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.bytedance.realx.video.AndroidVideoDecoder.2
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long l) {
                    OutputBufferInfo outputBufferInfo;
                    boolean z;
                    synchronized (AndroidVideoDecoder.this.outputBufferQueueLock) {
                        outputBufferInfo = AndroidVideoDecoder.this.outputBufferQueue.size() > 0 ? (OutputBufferInfo) AndroidVideoDecoder.this.outputBufferQueue.poll() : null;
                    }
                    if (outputBufferInfo != null) {
                        try {
                            AndroidVideoDecoder.this.codec.releaseOutputBuffer(outputBufferInfo.bufferIndex, outputBufferInfo.presentationTimestampUs * 1000);
                            z = true;
                        } catch (Exception e) {
                            RXLogging.m284e(AndroidVideoDecoder.TAG, "releaseOutputBuffer err:", e);
                            VideoDecoder.Callback callback = AndroidVideoDecoder.this.callback;
                            if (callback != null) {
                                callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, "releaseOutputBuffer err");
                                callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "releaseOutputBuffer err");
                            }
                            AndroidVideoDecoder.access$508(AndroidVideoDecoder.this);
                            z = false;
                        }
                        if (z) {
                            AndroidVideoDecoder.this.callbackDirectRenderFrame(outputBufferInfo.presentationTimestampUs);
                        }
                    }
                    if (AndroidVideoDecoder.this.running) {
                        Choreographer.getInstance().postFrameCallback(this);
                    }
                }
            });
            Looper.loop();
        } catch (Exception e) {
            RXLogging.m284e(TAG, "direct render by vsync is error", e);
        }
    }

    private Thread createOutputThread() {
        return new Thread("AndroidVideoDecoder.outputThread") { // from class: com.bytedance.realx.video.AndroidVideoDecoder.3
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (AndroidVideoDecoder.this.running) {
                    AndroidVideoDecoder.this.deliverDecodedFrame();
                }
                AndroidVideoDecoder.this.releaseCodecOnOutputThread();
            }
        };
    }

    protected void deliverDecodedFrame() {
        try {
            this.outputThreadChecker.checkIsOnValidThread();
            if (this.codec == null) {
                RXLogging.m287w(TAG, "codec is null when call deliverDecodedFrame");
                return;
            }
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.codec.dequeueOutputBuffer(bufferInfo, this.settings.latencyInsensitiveMode ? 25000L : 100000L);
            if (dequeueOutputBuffer == -2) {
                reformat(this.codec.getOutputFormat());
            } else if (dequeueOutputBuffer < 0) {
                RXLogging.m287w(TAG, "dequeueOutputBuffer err, returned " + dequeueOutputBuffer);
            } else {
                drainOutputFrame(bufferInfo, dequeueOutputBuffer);
            }
        } catch (Exception unused) {
            RXLogging.m283e(TAG, "deliverDecodedFrame failed");
        }
    }

    private void drainOutputFrame(MediaCodec.BufferInfo info, int result) {
        OutputBufferInfo poll;
        this.outputFrameCount++;
        if (this.isError.get()) {
            RXLogging.m287w(TAG, "codec is error when call drainOutputFrame");
            return;
        }
        VideoDecoder.Callback callback = this.callback;
        if (callback == null) {
            RXLogging.m283e(TAG, "callback is null, return");
            return;
        }
        boolean z = true;
        if (this.exSurface != null) {
            int i = this.texturePlayoutMode;
            if (i != 0) {
                if (1 == i) {
                    deliverTextureFrameOutSide(result, info);
                    return;
                }
                return;
            }
            try {
                int i2 = this.directRenderMode;
                if (1 == i2) {
                    this.codec.releaseOutputBuffer(result, info.presentationTimeUs * 1000);
                } else if (2 == i2) {
                    synchronized (this.outputBufferQueueLock) {
                        this.outputBufferQueue.put(new OutputBufferInfo(info.presentationTimeUs, result));
                        if (this.outputBufferQueue.size() > maxDirectRenderCacheSize && (poll = this.outputBufferQueue.poll()) != null) {
                            this.codec.releaseOutputBuffer(poll.bufferIndex, false);
                            callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "direct render drop frame");
                            this.dropDecodedFrameCount++;
                        }
                    }
                    z = false;
                } else {
                    this.codec.releaseOutputBuffer(result, true);
                }
                if (z) {
                    callbackDirectRenderFrame(info.presentationTimeUs);
                    return;
                }
                return;
            } catch (Exception e) {
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                callback.onMediaCodecStatus(VideoCodecStatus.MEDIACODEC_EXCEPTION, stringWriter.toString());
                callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "releaseOutputBuffer err");
                this.dropDecodedFrameCount++;
                return;
            }
        }
        if (!this.hasDecodedFirstFrame) {
            this.hasDecodedFirstFrame = true;
        }
        if (this.surfaceTextureHelper != null && this.texturePlayoutMode == 0) {
            deliverTextureFrame(result, info);
        } else if (this.outSideSurfaceTextureHelper != null && 1 == this.texturePlayoutMode) {
            deliverTextureFrameOutSide(result, info);
        } else {
            deliverByteFrame(result, info);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackDirectRenderFrame(long presentationTimeUs) {
        VideoDecoder.Callback callback = this.callback;
        if (callback == null) {
            return;
        }
        if (!this.hasDecodedFirstFrame) {
            this.hasDecodedFirstFrame = true;
        }
        NativeRXByteMemory nativeRXByteMemory = new NativeRXByteMemory(this.width, this.height, 0L, null, null, RXPixelFormat.kUnknown);
        NativeRXVideoFrame createRXVideoFrame = NativeRXVideoFrame.createRXVideoFrame(nativeRXByteMemory, presentationTimeUs * 1000, (ByteBuffer) null, RXColorSpace.kUnknown, RXVideoRotation.VIDEO_ROTATION_0);
        callback.onDecodedFrame(createRXVideoFrame);
        this.callbackDecodedFrameCount++;
        nativeRXByteMemory.release();
        createRXVideoFrame.release();
    }

    private void smoothOutputFrame() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.currentOutputTime = elapsedRealtime;
        long j = this.outputFrameCount;
        long j2 = this.inputFrameCount;
        if (j > j2) {
            this.outputFrameCount = j2;
        }
        long j3 = this.minFrameCache;
        if (j3 < 0) {
            this.minFrameCache = this.currentFrameCache;
        } else {
            long j4 = this.currentFrameCache;
            if (j3 > j4 && j4 >= 0) {
                j3 = j4;
            }
            this.minFrameCache = j3;
        }
        long j5 = this.lastOutputTime;
        long j6 = elapsedRealtime - j5;
        long j7 = this.avgInputTimeDelta;
        if (j7 <= 0) {
            j7 = this.currentInputTimeDelta;
            if (j7 <= 0) {
                j7 = 16;
            }
        } else {
            long j8 = this.currentInputTimeDelta;
            if (j8 < j7) {
                j7 = 10;
                if (j8 > 10) {
                    j7 = j8;
                }
            }
        }
        if (j5 > 0 && j6 < j7) {
            long j9 = j7 - j6;
            if (this.currentFrameCache > this.minFrameCache) {
                j9 /= 2;
            }
            if (j9 > 1300) {
                j9 = 1300;
            }
            if (j9 > 0) {
                try {
                    synchronized (this.smoothOutputLock) {
                        this.smoothOutputLock.wait(j9);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.lastOutputTime = SystemClock.elapsedRealtime();
    }

    private void deliverTextureFrame(final int index, final MediaCodec.BufferInfo info) {
        int i;
        int i2;
        MediaCodecWrapper mediaCodecWrapper;
        float f;
        float f2;
        boolean z;
        boolean z2;
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
        }
        if (this.settings.enableSmoothOutput && !this.settings.latencyInsensitiveMode) {
            smoothOutputFrame();
        }
        if (this.settings.latencyInsensitiveMode && this.running) {
            int i3 = 0;
            boolean z3 = true;
            while (z3 && i3 < 200) {
                i3++;
                synchronized (this.renderedTextureMetadataLock) {
                    z2 = this.renderedTextureMetadata != null;
                }
                if (z2) {
                    try {
                        Thread.sleep(10L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                z3 = z2;
            }
        }
        if (this.enableRetryDeliver && this.running) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j = this.inputFrameCount - this.outputFrameCount;
            if (j < 0) {
                j = this.frameCacheThreshold + 1;
            }
            this.currentFrameCache = j;
            RXLogging.m285i(TAG, "currentFrameCache:" + this.currentFrameCache);
            if (this.currentFrameCache <= this.frameCacheThreshold) {
                f = this.maxTryCount;
                f2 = this.maxDeaccelerateRatio;
            } else {
                f = this.maxTryCount;
                f2 = this.minAccelerateRatio;
            }
            int i4 = (int) (f * f2);
            boolean z4 = true;
            while (z4 && SystemClock.elapsedRealtime() - elapsedRealtime < i4) {
                synchronized (this.renderedTextureMetadataLock) {
                    z = this.renderedTextureMetadata != null;
                }
                if (z) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
                z4 = z;
            }
            RXLogging.m285i(TAG, "retry delivering frame take ms: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        VideoDecoder.Callback callback = this.callback;
        synchronized (this.renderedTextureMetadataLock) {
            if (this.renderedTextureMetadata != null && (mediaCodecWrapper = this.codec) != null) {
                try {
                    mediaCodecWrapper.releaseOutputBuffer(index, false);
                } catch (IllegalStateException e3) {
                    RXLogging.m284e(TAG, "releaseOutputBuffer failed", e3);
                }
                this.dropDecodedFrameCount++;
                if (callback != null) {
                    callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "waiting for texture for the previous frame");
                }
                return;
            }
            synchronized (this.surfaceTextureHelperLock) {
                SurfaceTextureHelper surfaceTextureHelper = this.surfaceTextureHelper;
                if (surfaceTextureHelper != null) {
                    surfaceTextureHelper.setTextureSize(i, i2, this.enableTextureSizeCheck);
                    this.renderedTextureMetadata = new DecodedTextureMetadata(info.presentationTimeUs);
                    MediaCodecWrapper mediaCodecWrapper2 = this.codec;
                    if (mediaCodecWrapper2 != null) {
                        try {
                            mediaCodecWrapper2.releaseOutputBuffer(index, true);
                        } catch (IllegalStateException e4) {
                            RXLogging.m284e(TAG, "releaseOutputBuffer failed!", e4);
                        }
                    }
                    return;
                }
                this.dropDecodedFrameCount++;
                if (callback != null) {
                    callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "surfaceTextureHelper is null");
                }
                RXLogging.m283e(TAG, "surfaceTextureHelper is null, drop current decoded frame.");
                MediaCodecWrapper mediaCodecWrapper3 = this.codec;
                if (mediaCodecWrapper3 != null) {
                    try {
                        mediaCodecWrapper3.releaseOutputBuffer(index, false);
                    } catch (IllegalStateException e5) {
                        RXLogging.m284e(TAG, "releaseOutputBuffer failed", e5);
                    }
                }
                return;
            }
        }
    }

    private void deliverTextureFrameOutSide(final int index, final MediaCodec.BufferInfo info) {
        this.renderedTextureMetadata = new DecodedTextureMetadata(info.presentationTimeUs);
        synchronized (this.surfaceTextureHelperLock) {
            SurfaceTextureHelper surfaceTextureHelper = this.outSideSurfaceTextureHelper;
            if (surfaceTextureHelper != null) {
                surfaceTextureHelper.setTextureSize(this.width, this.height);
                this.outSideSurfaceTextureHelper.onFrame(new MediaCodecTextureBufferHelper(new MediaCodecTextureBufferHelper.ReleaseOutPutBuffer() { // from class: com.bytedance.realx.video.AndroidVideoDecoder$$ExternalSyntheticLambda1
                    @Override // com.bytedance.realx.video.MediaCodecTextureBufferHelper.ReleaseOutPutBuffer
                    public final int release(boolean z) {
                        return AndroidVideoDecoder.this.m290x7f89619(index, info, z);
                    }
                }));
                return;
            }
            this.dropDecodedFrameCount++;
            this.callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "outSideSurfaceTextureHelper is null");
            RXLogging.m283e(TAG, "outSideSurfaceTextureHelper is null, drop current decoded frame.");
            MediaCodecWrapper mediaCodecWrapper = this.codec;
            if (mediaCodecWrapper != null) {
                try {
                    mediaCodecWrapper.releaseOutputBuffer(index, false);
                } catch (Exception e) {
                    RXLogging.m284e(TAG, "releaseOutputBuffer failed", e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deliverTextureFrameOutSide$1$com-bytedance-realx-video-AndroidVideoDecoder */
    public /* synthetic */ int m290x7f89619(int i, MediaCodec.BufferInfo bufferInfo, boolean z) {
        try {
            if (z) {
                this.codec.releaseOutputBuffer(i, bufferInfo.presentationTimeUs * 1000);
            } else {
                this.codec.releaseOutputBuffer(i, z);
            }
            return 0;
        } catch (Exception e) {
            RXLogging.m288w(TAG, "releaseOutputBuffer failed", e);
            return 0;
        }
    }

    @Override // com.bytedance.realx.video.VideoDecoder, com.bytedance.realx.video.VideoSink
    public void onFrame(RXVideoFrameInterface frame) {
        VideoDecoder.Callback callback = this.callback;
        if (callback == null) {
            this.dropDecodedFrameCount++;
            RXLogging.m283e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
            return;
        }
        synchronized (this.renderedTextureMetadataLock) {
            DecodedTextureMetadata decodedTextureMetadata = this.renderedTextureMetadata;
            if (decodedTextureMetadata == null) {
                RXLogging.m283e(TAG, "renderedTextureMetadata is null drop current decoded frame,running:" + this.running);
                callback.onMediaCodecStatus(VideoCodecStatus.DROP_DECODED_FRAME, "renderedTextureMetadata is null");
                this.dropDecodedFrameCount++;
            } else {
                long j = decodedTextureMetadata.presentationTimestampUs * 1000;
                this.renderedTextureMetadata = null;
                frame.setTimestampNs(j);
                callback.onDecodedFrame(frame);
                this.callbackDecodedFrameCount++;
            }
        }
    }

    private void deliverByteFrame(int result, MediaCodec.BufferInfo info) {
        int i;
        int i2;
        int i3;
        int i4;
        ByteBuffer byteBuffer;
        NativeRXByteMemory copyNV12Buffer;
        synchronized (this.dimensionLock) {
            i = this.width;
            i2 = this.height;
            i3 = this.stride;
            i4 = this.sliceHeight;
        }
        VideoDecoder.Callback callback = this.callback;
        if (info.size < ((i * i2) * 3) / 2) {
            RXLogging.m283e(TAG, "Insufficient output buffer size: " + info.size);
            return;
        }
        int i5 = (info.size >= ((i3 * i2) * 3) / 2 || i4 != i2 || i3 <= i) ? i3 : (info.size * 2) / (i2 * 3);
        try {
            if (this.useAsyncMode) {
                byteBuffer = this.codec.getOutputBuffer(result);
            } else if (this.useNewOutputBufferAPI) {
                byteBuffer = this.codec.getOutputBuffer(result);
            } else {
                byteBuffer = this.codec.getOutputBuffers()[result];
            }
            byteBuffer.position(info.offset);
            byteBuffer.limit(info.offset + info.size);
            ByteBuffer slice = byteBuffer.slice();
            try {
                if (this.colorFormat == 19) {
                    copyNV12Buffer = copyI420Buffer(slice, i5, i4, i, i2);
                } else {
                    copyNV12Buffer = copyNV12Buffer(slice, i5, i4, i, i2);
                }
                if (copyNV12Buffer == null) {
                    RXLogging.m283e(TAG, "byteMemory is null, colorFormat:" + this.colorFormat);
                    this.dropDecodedFrameCount++;
                    return;
                }
                try {
                    this.codec.releaseOutputBuffer(result, false);
                    NativeRXVideoFrame createRXVideoFrame = NativeRXVideoFrame.createRXVideoFrame(copyNV12Buffer, info.presentationTimeUs * 1000, (ByteBuffer) null, RXColorSpace.kUnknown, RXVideoRotation.VIDEO_ROTATION_0);
                    if (callback == null) {
                        RXLogging.m283e(TAG, "callback is null, dropDecodedFrameCount:" + this.dropDecodedFrameCount);
                        this.dropDecodedFrameCount++;
                        copyNV12Buffer.release();
                        createRXVideoFrame.release();
                        return;
                    }
                    callback.onDecodedFrame(createRXVideoFrame);
                    this.callbackDecodedFrameCount++;
                    copyNV12Buffer.release();
                    createRXVideoFrame.release();
                } catch (Exception e) {
                    RXLogging.m284e(TAG, "releaseOutputBuffer failed!", e);
                    copyNV12Buffer.release();
                }
            } catch (Exception e2) {
                RXLogging.m284e(TAG, "buffer err!", e2);
                this.dropDecodedFrameCount++;
            }
        } catch (Exception e3) {
            RXLogging.m284e(TAG, "getOutputBuffer failed!", e3);
        }
    }

    private NativeRXByteMemory copyNV12Buffer(ByteBuffer buffer, int stride, int sliceHeight, int width, int height) {
        int i = (height + 1) / 2;
        int i2 = (stride * height) + 0;
        int i3 = (stride * sliceHeight) + 0;
        int i4 = i3 + (stride * i);
        NativeRXByteMemory createRXByteMemory = NativeRXByteMemory.createRXByteMemory(width, height, RXPixelFormat.kNv12, 0L);
        if (createRXByteMemory == null) {
            return null;
        }
        if (createRXByteMemory.getNumberOfPlanes() != 2) {
            createRXByteMemory.release();
            return null;
        }
        try {
            buffer.limit(i2);
            buffer.position(0);
            copyPlane(buffer.slice(), stride, createRXByteMemory.getPlaneData(0), createRXByteMemory.getPlaneLineSize(0), width, height);
            buffer.limit(i4);
            buffer.position(i3);
            copyPlane(buffer.slice(), stride, createRXByteMemory.getPlaneData(1), createRXByteMemory.getPlaneLineSize(1), width, i);
            return createRXByteMemory;
        } catch (Exception e) {
            RXLogging.m284e(TAG, "copyNV12Buffer err:", e);
            createRXByteMemory.release();
            return null;
        }
    }

    private NativeRXByteMemory copyI420Buffer(ByteBuffer buffer, int stride, int sliceHeight, int width, int height) {
        NativeRXByteMemory nativeRXByteMemory;
        if (stride % 2 != 0) {
            RXLogging.m283e(TAG, "Stride is not divisible by two: " + stride);
            return null;
        }
        int i = (width + 1) / 2;
        int i2 = sliceHeight % 2 == 0 ? (height + 1) / 2 : height / 2;
        int i3 = stride / 2;
        int i4 = (stride * height) + 0;
        int i5 = (stride * sliceHeight) + 0;
        int i6 = i3 * i2;
        int i7 = i5 + i6;
        int i8 = i5 + ((i3 * sliceHeight) / 2);
        int i9 = i8 + i6;
        NativeRXByteMemory allocateI420Buffer = allocateI420Buffer(width, height);
        if (allocateI420Buffer == null) {
            return null;
        }
        if (allocateI420Buffer.getNumberOfPlanes() != 3) {
            allocateI420Buffer.release();
            return null;
        }
        try {
            buffer.limit(i4);
            buffer.position(0);
            nativeRXByteMemory = allocateI420Buffer;
        } catch (Exception e) {
            e = e;
            nativeRXByteMemory = allocateI420Buffer;
        }
        try {
            copyPlane(buffer.slice(), stride, allocateI420Buffer.getPlaneData(0), allocateI420Buffer.getPlaneLineSize(0), width, height);
            buffer.limit(i7);
            buffer.position(i5);
            copyPlane(buffer.slice(), i3, nativeRXByteMemory.getPlaneData(1), nativeRXByteMemory.getPlaneLineSize(1), i, i2);
            if (sliceHeight % 2 == 1) {
                buffer.position(i5 + ((i2 - 1) * i3));
                ByteBuffer planeData = nativeRXByteMemory.getPlaneData(1);
                planeData.position(nativeRXByteMemory.getPlaneLineSize(1) * i2);
                planeData.put(buffer);
            }
            buffer.limit(i9);
            buffer.position(i8);
            copyPlane(buffer.slice(), i3, nativeRXByteMemory.getPlaneData(2), nativeRXByteMemory.getPlaneLineSize(2), i, i2);
            if (sliceHeight % 2 == 1) {
                buffer.position(i8 + (i3 * (i2 - 1)));
                ByteBuffer planeData2 = nativeRXByteMemory.getPlaneData(2);
                planeData2.position(nativeRXByteMemory.getPlaneLineSize(2) * i2);
                planeData2.put(buffer);
            }
            return nativeRXByteMemory;
        } catch (Exception e2) {
            e = e2;
            RXLogging.m284e(TAG, "buffer err:", e);
            nativeRXByteMemory.release();
            return null;
        }
    }

    private void reformat(MediaFormat format) {
        int integer;
        int integer2;
        this.outputThreadChecker.checkIsOnValidThread();
        if (format.containsKey(MEDIA_FORMAT_KEY_CROP_LEFT) && format.containsKey(MEDIA_FORMAT_KEY_CROP_RIGHT) && format.containsKey(MEDIA_FORMAT_KEY_CROP_BOTTOM) && format.containsKey(MEDIA_FORMAT_KEY_CROP_TOP)) {
            integer = (format.getInteger(MEDIA_FORMAT_KEY_CROP_RIGHT) + 1) - format.getInteger(MEDIA_FORMAT_KEY_CROP_LEFT);
            integer2 = (format.getInteger(MEDIA_FORMAT_KEY_CROP_BOTTOM) + 1) - format.getInteger(MEDIA_FORMAT_KEY_CROP_TOP);
            RXLogging.m285i(TAG, "stream have crop info newWidth:" + integer + " newHeight:" + integer2);
        } else {
            integer = format.getInteger("width");
            integer2 = format.getInteger("height");
        }
        synchronized (this.dimensionLock) {
            if (this.hasDecodedFirstFrame && (this.width != integer || this.height != integer2)) {
                stopOnOutputThread(new RuntimeException("Unexpected size change. Configured " + this.width + UrlMatcher.WILDCARD + this.height + ". New " + integer + UrlMatcher.WILDCARD + integer2));
                return;
            }
            this.width = integer;
            this.height = integer2;
            if (((this.surfaceTextureHelper == null && this.outSideSurfaceTextureHelper == null && this.exSurface == null) || this.settings.enableYUVOutput) && format.containsKey("color-format")) {
                this.colorFormat = format.getInteger("color-format");
                RXLogging.m285i(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                if (!isSupportedColorFormat(this.colorFormat)) {
                    stopOnOutputThread(new IllegalStateException("Unsupported color format: " + this.colorFormat));
                    return;
                }
            }
            synchronized (this.dimensionLock) {
                if (format.containsKey(MEDIA_FORMAT_KEY_STRIDE)) {
                    this.stride = format.getInteger(MEDIA_FORMAT_KEY_STRIDE);
                }
                if (format.containsKey(MEDIA_FORMAT_KEY_SLICE_HEIGHT)) {
                    this.sliceHeight = format.getInteger(MEDIA_FORMAT_KEY_SLICE_HEIGHT);
                }
                RXLogging.m285i(TAG, "Frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                this.sliceHeight = Math.max(this.height, this.sliceHeight);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseCodecOnOutputThread() {
        try {
            this.outputThreadChecker.checkIsOnValidThread();
        } catch (IllegalStateException unused) {
            RXLogging.m283e(TAG, "thread check err");
        }
        RXLogging.m285i(TAG, "Releasing MediaCodec on output thread");
        try {
            this.codec.stop();
        } catch (Exception e) {
            RXLogging.m284e(TAG, "Media decoder stop failed", e);
        }
        try {
            this.codec.release();
        } catch (Exception e2) {
            RXLogging.m284e(TAG, "Media decoder release failed", e2);
            this.shutdownException = e2;
        }
        if (!this.settings.enableSurfaceTextureReuse) {
            releaseSurface();
        }
        RXLogging.m285i(TAG, "Release on output thread done");
    }

    private void stopOnOutputThread(Exception e) {
        this.outputThreadChecker.checkIsOnValidThread();
        if (this.useAsyncMode) {
            this.isError.set(true);
        } else {
            this.running = false;
            this.shutdownException = e;
        }
    }

    private boolean isSupportedColorFormat(int colorFormat) {
        for (int i : MediaCodecUtils.DECODER_COLOR_FORMATS) {
            if (i == colorFormat) {
                return true;
            }
        }
        return false;
    }

    protected SurfaceTextureHelper createSurfaceTextureHelper() {
        if (this.settings.enableAGFXSurfaceTextureHelper) {
            return SurfaceTextureHelper.createWithAGFX("decoder-texture-thread");
        }
        return SurfaceTextureHelper.create("decoder-texture-thread", this.sharedContext);
    }

    protected void initSurfaceTextureHelper(SurfaceTextureHelper helper, boolean outSideControlTexflag) {
        if (helper == null) {
            RXLogging.m287w(TAG, "surfaceTextureHelper create fail,egl context maybe is full, the hw decoder should use yuvoutput mode");
            this.mustUseYUVoutput = true;
            return;
        }
        RXLogging.m287w(TAG, "surfaceTextureHelper create successful.");
        if (!this.settings.enableAGFXSurfaceTextureHelper) {
            curEglContextNum++;
        }
        helper.setTextureMemoryReuse(this.enableTextureMemoryReuse);
        helper.setEnableOutsideControlTextureMemory(outSideControlTexflag);
        this.surface = new Surface(helper.getSurfaceTexture());
        helper.startListening(this);
    }

    protected void releaseSurface() {
        RXLogging.m287w(TAG, "releaseSurface start");
        try {
            if (this.surface != null) {
                RXLogging.m287w(TAG, "release surface");
                this.surface.release();
                this.surface = null;
            }
            synchronized (this.surfaceTextureHelperLock) {
                if (this.surfaceTextureHelper != null) {
                    RXLogging.m287w(TAG, "surfaceTextureHelper.stopListening()");
                    this.surfaceTextureHelper.stopListening();
                }
            }
            if (!this.settings.enableSurfaceTextureReuse) {
                releaseSurfaceTextureHelper();
            }
        } catch (Exception e) {
            RXLogging.m283e(TAG, "releaseSurface:" + e);
        }
        RXLogging.m287w(TAG, "releaseSurface end");
    }

    protected void releaseSurfaceTextureHelper() {
        synchronized (this.surfaceTextureHelperLock) {
            if (this.surfaceTextureHelper != null) {
                RXLogging.m287w(TAG, "release surfaceTextureHelper");
                this.surfaceTextureHelper.dispose();
                this.surfaceTextureHelper = null;
                curEglContextNum--;
                RXLogging.m287w(TAG, "release surfaceTextureHelper done, curEglContextNum:" + curEglContextNum);
            }
        }
    }

    protected NativeRXByteMemory allocateI420Buffer(int width, int height) {
        return NativeRXByteMemory.createRXByteMemory(width, height, RXPixelFormat.kI420, 0L);
    }

    protected void copyPlane(ByteBuffer src, int srcStride, ByteBuffer dst, int dstStride, int width, int height) {
        YuvHelper.copyPlane(src, srcStride, dst, dstStride, width, height);
    }
}
