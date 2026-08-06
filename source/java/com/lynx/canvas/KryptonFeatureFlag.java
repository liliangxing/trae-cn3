package com.lynx.canvas;

/* loaded from: classes6.dex */
public class KryptonFeatureFlag {
    private boolean mAudioForceUseAdaptiveSampler;
    private int mCanvas2DCommandBufferSize;
    private boolean mDisableOffscreenCanvasBlitToScreen;
    private boolean mEnableAfterFrameCallback;
    private boolean mEnableAndroidSystemTrace;
    private boolean mEnableContextAttribute;
    private boolean mEnableDoFrameRefactor;
    private boolean mEnableDrawImageReuse;
    private boolean mEnableEventReport;
    private boolean mEnableFirstFrameCallback;
    private boolean mEnablePath2DRelatedApiSkity;
    private boolean mEnablePerformanceStatisticsRelatedInterface;
    private boolean mEnableSar;
    private boolean mEnableWebGLLowMemoryMode;
    private boolean mEnableWorkaroundFinishPerFrame;
    private boolean mExportExtraInfoInCanvasTouchEvent;
    private boolean mFirstOnScreenCanvasIsTheOnlyOnScreen;
    private boolean mForceTextureBackend;
    private boolean mForceUseShaderReplaceBlitFramebuffer;
    private int mGPUThreadGroup;
    private boolean mNeedBindingRaf;
    private boolean mNeedProcessGesture;
    private boolean mNeedUseShaderReplaceBlitFramebuffer;
    private boolean mUseAurumAudioEngine;
    private boolean mUseSkityAs2DBackend;
    private boolean mUseVsyncMonitorFromService;

    public int getGPUThreadGroup() {
        return this.mGPUThreadGroup;
    }

    public boolean isNeedBindingRaf() {
        return this.mNeedBindingRaf;
    }

    public boolean isFirstOnScreenCanvasIsTheOnlyOnScreen() {
        return this.mFirstOnScreenCanvasIsTheOnlyOnScreen;
    }

    public boolean enablePerformanceStatisticsRelatedInterface() {
        return this.mEnablePerformanceStatisticsRelatedInterface;
    }

    public boolean enableFirstFrameCallback() {
        return this.mEnableFirstFrameCallback;
    }

    public boolean enableSar() {
        return this.mEnableSar;
    }

    public boolean enableAfterFrameCallback() {
        return this.mEnableAfterFrameCallback;
    }

    public boolean needProcessGesture() {
        return this.mNeedProcessGesture;
    }

    public boolean enableWebGLLowMemoryMode() {
        return this.mEnableWebGLLowMemoryMode;
    }

    public boolean needUseShaderReplaceBlitFramebuffer() {
        return this.mNeedUseShaderReplaceBlitFramebuffer;
    }

    public boolean disableOffscreenCanvasBlitToScreen() {
        return this.mDisableOffscreenCanvasBlitToScreen;
    }

    public boolean enableAndroidSystemTrace() {
        return this.mEnableAndroidSystemTrace;
    }

    public int getCanvas2DCommandBufferSize() {
        return this.mCanvas2DCommandBufferSize;
    }

    public boolean getUseVsyncMonitorFromService() {
        return this.mUseVsyncMonitorFromService;
    }

    public boolean getEnablePath2DRelatedApiSkity() {
        return this.mEnablePath2DRelatedApiSkity;
    }

    public boolean getEnableWorkaroundFinishPerFrame() {
        return this.mEnableWorkaroundFinishPerFrame;
    }

    public boolean getForceTextureBackend() {
        return this.mForceTextureBackend;
    }

    public boolean getEnableDoFrameRefactor() {
        return this.mEnableDoFrameRefactor;
    }

    public boolean getExportExtraInfoInCanvasTouchEvent() {
        return this.mExportExtraInfoInCanvasTouchEvent;
    }

    public boolean getUseAurumAudioEngine() {
        return this.mUseAurumAudioEngine;
    }

    public boolean getAudioForceUseAdaptiveSampler() {
        return this.mAudioForceUseAdaptiveSampler;
    }

    public boolean getEnableContextAttribute() {
        return this.mEnableContextAttribute;
    }

    public boolean getUseSkityAs2DBackend() {
        return this.mUseSkityAs2DBackend;
    }

    public boolean getForceUseShaderReplaceBlitFramebuffer() {
        return this.mForceUseShaderReplaceBlitFramebuffer;
    }

    public boolean getEnableEventReport() {
        return this.mEnableEventReport;
    }

    private KryptonFeatureFlag() {
        this.mEnableDrawImageReuse = true;
        this.mUseVsyncMonitorFromService = true;
        this.mEnableWorkaroundFinishPerFrame = true;
        this.mForceTextureBackend = false;
        this.mEnableDoFrameRefactor = false;
        this.mExportExtraInfoInCanvasTouchEvent = false;
        this.mUseAurumAudioEngine = true;
        this.mAudioForceUseAdaptiveSampler = false;
        this.mEnableContextAttribute = false;
        this.mUseSkityAs2DBackend = false;
        this.mForceUseShaderReplaceBlitFramebuffer = false;
        this.mEnableEventReport = false;
    }

    public String toString() {
        return "KryptonFeatureFlag{mGPUThreadGroup=" + this.mGPUThreadGroup + ", mNeedBindingRaf=" + this.mNeedBindingRaf + ", mFirstOnScreenCanvasIsTheOnlyOnScreen=" + this.mFirstOnScreenCanvasIsTheOnlyOnScreen + ", mEnablePerformanceStatisticsRelatedInterface=" + this.mEnablePerformanceStatisticsRelatedInterface + ", mEnableFirstFrameCallback=" + this.mEnableFirstFrameCallback + ", mEnableDrawImageReuse=" + this.mEnableDrawImageReuse + ", mEnableSar=" + this.mEnableSar + ", mNeedProcessGesture=" + this.mNeedProcessGesture + ", mEnableAfterFrameCallback=" + this.mEnableAfterFrameCallback + ", mEnableWebGLLowMemoryMode=" + this.mEnableWebGLLowMemoryMode + ", mNeedUseShaderReplaceBlitFramebuffer=" + this.mNeedUseShaderReplaceBlitFramebuffer + ", mDisableOffscreenCanvasBlitToScreen=" + this.mDisableOffscreenCanvasBlitToScreen + ", mEnableAndroidSystemTrace=" + this.mEnableAndroidSystemTrace + ", mUseVsyncMonitorFromService=" + this.mUseVsyncMonitorFromService + ", mCanvas2DCommandBufferSize=" + this.mCanvas2DCommandBufferSize + ", mEnablePath2DRelatedApiSkity=" + this.mEnablePath2DRelatedApiSkity + ", mEnableWorkaroundFinishPerFrame=" + this.mEnableWorkaroundFinishPerFrame + ", mForceTextureBackend=" + this.mForceTextureBackend + ", mEnableDoFrameRefactor=" + this.mEnableDoFrameRefactor + ", mExportExtraInfoInCanvasTouchEvent=" + this.mExportExtraInfoInCanvasTouchEvent + ", mUseAurumAudioEngine=" + this.mUseAurumAudioEngine + ", mAudioForceUseAdaptiveSampler=" + this.mAudioForceUseAdaptiveSampler + ", mEnableContextAttribute=" + this.mEnableContextAttribute + ", mUseSkityAs2DBackend=" + this.mUseSkityAs2DBackend + ", mForceUseShaderReplaceBlitFramebuffer=" + this.mForceUseShaderReplaceBlitFramebuffer + ", mEnableEventReport=" + this.mEnableEventReport + "}";
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private final KryptonFeatureFlag mFlag = new KryptonFeatureFlag();

        public KryptonFeatureFlag build() {
            return this.mFlag;
        }

        public Builder setGPUThreadGroup(int i) {
            this.mFlag.mGPUThreadGroup = i;
            return this;
        }

        public Builder setNeedBindingRaf(boolean z) {
            this.mFlag.mNeedBindingRaf = z;
            return this;
        }

        public Builder setFirstOnScreenCanvasIsTheOnlyOnScreen(boolean z) {
            this.mFlag.mFirstOnScreenCanvasIsTheOnlyOnScreen = z;
            return this;
        }

        public Builder setEnablePerformanceStatisticsRelatedInterface(boolean z) {
            this.mFlag.mEnablePerformanceStatisticsRelatedInterface = z;
            return this;
        }

        public Builder setEnableFirstFrameCallback(boolean z) {
            this.mFlag.mEnableFirstFrameCallback = z;
            return this;
        }

        public Builder setEnableSar(boolean z) {
            this.mFlag.mEnableSar = z;
            return this;
        }

        public Builder setNeedProcessGesture(boolean z) {
            this.mFlag.mNeedProcessGesture = z;
            return this;
        }

        public Builder setEnableAfterframeCallback(boolean z) {
            this.mFlag.mEnableAfterFrameCallback = z;
            return this;
        }

        public Builder setEnableWebGLLowMemoryMode(boolean z) {
            this.mFlag.mEnableWebGLLowMemoryMode = z;
            return this;
        }

        public Builder setNeedUseShaderReplaceBlitFramebuffer(boolean z) {
            this.mFlag.mNeedUseShaderReplaceBlitFramebuffer = z;
            return this;
        }

        public Builder setDisableOffscreenCanvasBlitToScreen(boolean z) {
            this.mFlag.mDisableOffscreenCanvasBlitToScreen = z;
            return this;
        }

        public Builder setEnableAndroidSystemTrace(boolean z) {
            this.mFlag.mEnableAndroidSystemTrace = z;
            return this;
        }

        public Builder setEnableDrawImageReuse(boolean z) {
            this.mFlag.mEnableDrawImageReuse = z;
            return this;
        }

        public Builder setCanvas2DCommandBufferSize(int i) {
            this.mFlag.mCanvas2DCommandBufferSize = i;
            return this;
        }

        public Builder setUseVsyncMonitorFromService(boolean z) {
            this.mFlag.mUseVsyncMonitorFromService = z;
            return this;
        }

        public Builder setEnablePath2DRelatedApiSkity(boolean z) {
            this.mFlag.mEnablePath2DRelatedApiSkity = z;
            return this;
        }

        public Builder setEnableWorkaroundFinishPerFrame(boolean z) {
            this.mFlag.mEnableWorkaroundFinishPerFrame = z;
            return this;
        }

        public Builder setForceTextureBackend(boolean z) {
            this.mFlag.mForceTextureBackend = z;
            return this;
        }

        public Builder setEnableDoFrameRefactor(boolean z) {
            this.mFlag.mEnableDoFrameRefactor = z;
            return this;
        }

        public Builder setExportExtraInfoInCanvasTouchEvent(boolean z) {
            this.mFlag.mExportExtraInfoInCanvasTouchEvent = z;
            return this;
        }

        public Builder setUseAurumAudioEngine(boolean z) {
            this.mFlag.mUseAurumAudioEngine = z;
            return this;
        }

        public Builder setAudioForceUseAdaptiveSampler(boolean z) {
            this.mFlag.mAudioForceUseAdaptiveSampler = z;
            return this;
        }

        public Builder setEnableContextAttribute(boolean z) {
            this.mFlag.mEnableContextAttribute = z;
            return this;
        }

        public Builder setUseSkityAs2DBackend(boolean z) {
            this.mFlag.mUseSkityAs2DBackend = z;
            return this;
        }

        public Builder setForceUseShaderReplaceBlitFramebuffer(boolean z) {
            this.mFlag.mForceUseShaderReplaceBlitFramebuffer = z;
            return this;
        }

        public Builder setEnableEventReport(boolean z) {
            this.mFlag.mEnableEventReport = z;
            return this;
        }
    }
}
