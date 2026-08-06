package com.bytedance.realx.video;

import android.view.Surface;
import com.bytedance.realx.video.EglBase;
import com.bytedance.realx.video.memory.RXVideoFrameInterface;

/* loaded from: classes4.dex */
public interface VideoDecoder {

    /* loaded from: classes4.dex */
    public interface Callback {
        void onDecodedFrame(RXVideoFrameInterface frame);

        void onMediaCodecStatus(VideoCodecStatus type, String info);
    }

    default long createNativeVideoDecoder() {
        return 0L;
    }

    VideoCodecStatus decode(EncodedImage frame);

    void disableExternalSurface();

    String getImplementationName();

    boolean getPrefersLateDecoding();

    VideoCodecStatus initDecode(Settings settings, Callback decodeCallback);

    void onFrame(RXVideoFrameInterface frame);

    VideoCodecStatus release();

    VideoCodecStatus setDeliverParams(boolean enable, int maxTryCount, float minAccelerateRatio, float maxDeaccelerateRatio, int frameCacheThreshold);

    void setExternalSurface(Surface surface);

    VideoCodecStatus setPrivateParam(String key, String value);

    VideoCodecStatus updateSettings(Settings settings);

    /* loaded from: classes4.dex */
    public static class Settings {
        public final int directRenderMode;
        public final boolean enableAGFXSurfaceTextureHelper;
        public final boolean enableAsyncMode;
        public final boolean enableBFrameDecode;
        public final boolean enableRecreateByResolution;
        public final boolean enableSmoothOutput;
        public final boolean enableSurfaceTextureReuse;
        public final boolean enableYUVOutput;
        public final int height;
        public final boolean latencyInsensitiveMode;
        public final int numberOfCores;
        public final boolean outputByDts;
        public final EglBase.Context sharedContext;
        public final int texturePlayoutMode;
        public final int width;

        public Settings(int numberOfCores, int width, int height, boolean outputByDts, boolean enableSmoothOutput, boolean enableYUVOutput, boolean latencyInsensitiveMode, boolean enableSurfaceTextureReuse, boolean enableRecreateByResolution, boolean enableBFrameDecode, boolean enableAGFXSurfaceTextureHelper, EglBase.Context sharedContext, boolean enableAsyncMode, int directRenderMode, int texturePlayoutMode) {
            this.numberOfCores = numberOfCores;
            this.width = width;
            this.height = height;
            this.outputByDts = outputByDts;
            this.enableSmoothOutput = enableSmoothOutput;
            this.enableYUVOutput = enableYUVOutput;
            this.latencyInsensitiveMode = latencyInsensitiveMode;
            this.enableSurfaceTextureReuse = enableSurfaceTextureReuse;
            this.enableRecreateByResolution = enableRecreateByResolution;
            this.enableBFrameDecode = enableBFrameDecode;
            this.sharedContext = sharedContext;
            this.enableAGFXSurfaceTextureHelper = enableAGFXSurfaceTextureHelper;
            this.enableAsyncMode = enableAsyncMode;
            this.directRenderMode = directRenderMode;
            this.texturePlayoutMode = texturePlayoutMode;
        }
    }

    /* loaded from: classes4.dex */
    public static class DecodeInfo {
        public final boolean isMissingFrames;
        public final long renderTimeMs;

        public DecodeInfo(boolean isMissingFrames, long renderTimeMs) {
            this.isMissingFrames = isMissingFrames;
            this.renderTimeMs = renderTimeMs;
        }
    }
}
