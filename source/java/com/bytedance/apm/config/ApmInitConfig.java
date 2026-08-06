package com.bytedance.apm.config;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.alog.DefaultAlogUploadStrategy;
import com.bytedance.apm.alog.IAlogUploadStrategy;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.LaunchAnalysisContext;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.bytedance.apm.net.IHttpUrlConnectionInterceptor;
import com.bytedance.apm.trace.ITraceListener;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmInitConfig {
    private boolean isReportCacheException;
    private boolean mActivityFps;
    private ActivityLeakDetectConfig mActivityLeakDetectConfig;
    private IAlogUploadStrategy mAlogUploadStrategy;
    private boolean mBinderMonitor;
    private int mCacheBufferCount;
    private boolean mChangeFpsLifeCycle;
    private boolean mDisableFpsTracer;
    private boolean mEnableCloseListener;
    private boolean mEnableCpuAllocOpt;
    private boolean mEnableDeviceInfoOnPerfData;
    private boolean mEnableLooperDeepOpt;
    private boolean mEnableLooperOpt;
    private boolean mEnableSliverDump;
    private long mEvilMethodThresholdMs;
    private boolean mFullFpsTracer;
    private IHttpUrlConnectionInterceptor mHttpUrlConnectionInterceptor;
    private String mIgnoreNetMonitorUserAgentLabel;
    private LaunchInitConfig mLaunchConfig;
    private boolean mLimitEvilMethodDepth;
    private long mMaxValidLaunchTimeMs;
    private long mMaxValidPageLoadTimeMs;
    private String mProcessName;
    private boolean mReportEvilMethodSwitch;
    private boolean mSupportMultiFrameRate;
    private long mTraceExtraCollectTimeMs;
    private int mTraceExtraFlag;
    private ITraceListener mTraceListener;
    private boolean mViewIdmonitorPageSwitch;

    public int getCacheBufferCount() {
        return this.mCacheBufferCount;
    }

    public boolean isViewIdmonitorPageSwitch() {
        return this.mViewIdmonitorPageSwitch;
    }

    public long getMaxValidPageLoadTimeMs() {
        return this.mMaxValidPageLoadTimeMs;
    }

    public ITraceListener getTraceListener() {
        return this.mTraceListener;
    }

    public boolean isReportEvilMethodSwitch() {
        return this.mReportEvilMethodSwitch;
    }

    public long getEvilMethodThresholdMs() {
        return this.mEvilMethodThresholdMs;
    }

    public boolean isLimitEvilMethodDepth() {
        return this.mLimitEvilMethodDepth;
    }

    public boolean isFullFpsTracer() {
        return this.mFullFpsTracer;
    }

    public boolean isDisableFpsTracer() {
        return this.mDisableFpsTracer;
    }

    public boolean isChangeFpsLifeCyclesTracer() {
        return this.mChangeFpsLifeCycle;
    }

    public boolean isEnableCpuAllocOpt() {
        return this.mEnableCpuAllocOpt;
    }

    public boolean isEnableCloseListener() {
        return this.mEnableCloseListener;
    }

    public boolean isEnableLooperOpt() {
        return this.mEnableLooperOpt;
    }

    public boolean isActivityFps() {
        return this.mActivityFps;
    }

    public boolean isEnableBinderMonitor() {
        return this.mBinderMonitor;
    }

    public ActivityLeakDetectConfig getActivityLeakDetectConfig() {
        return this.mActivityLeakDetectConfig;
    }

    public void setCacheBufferCount(int i) {
        this.mCacheBufferCount = i;
    }

    public void setViewIdmonitorPageSwitch(boolean z) {
        this.mViewIdmonitorPageSwitch = z;
    }

    public void setMaxValidPageLoadTimeMs(long j) {
        this.mMaxValidPageLoadTimeMs = j;
    }

    public long getMaxValidLaunchTimeMs() {
        return this.mMaxValidLaunchTimeMs;
    }

    public void setTraceListener(ITraceListener iTraceListener) {
        this.mTraceListener = iTraceListener;
    }

    public void setReportEvilMethodSwitch(boolean z) {
        this.mReportEvilMethodSwitch = z;
    }

    public void setEvilMethodThresholdMs(long j) {
        this.mEvilMethodThresholdMs = j;
    }

    public String getIgnoreNetMonitorUserAgentLabel() {
        return this.mIgnoreNetMonitorUserAgentLabel;
    }

    public int getTraceExtraFlag() {
        return this.mTraceExtraFlag;
    }

    public long getTraceExtraCollectTimeMs() {
        long maxCollectTimeMs = LaunchAnalysisContext.getInstance().getConfig().getMaxCollectTimeMs();
        return maxCollectTimeMs != -1 ? maxCollectTimeMs : this.mTraceExtraCollectTimeMs;
    }

    public boolean isReportCacheException() {
        return this.isReportCacheException;
    }

    public String getProcessName() {
        return this.mProcessName;
    }

    public LaunchInitConfig getLaunchConfig() {
        if (this.mLaunchConfig == null) {
            this.mLaunchConfig = new LaunchInitConfig.Builder().build();
        }
        return this.mLaunchConfig;
    }

    public IAlogUploadStrategy getAlogUploadStrategy() {
        return this.mAlogUploadStrategy;
    }

    public boolean supportMultiFrameRate() {
        return this.mSupportMultiFrameRate;
    }

    public boolean isDeviceInfoOnPerfDataEnabled() {
        return this.mEnableDeviceInfoOnPerfData;
    }

    public boolean isEnableLooperDeepOpt() {
        return this.mEnableLooperDeepOpt;
    }

    public IHttpUrlConnectionInterceptor getHttpUrlConnectionInterceptor() {
        return this.mHttpUrlConnectionInterceptor;
    }

    public static Builder builder() {
        return new Builder();
    }

    public ApmInitConfig(Builder builder) {
        this.mCacheBufferCount = builder.cacheBufferCount;
        this.mViewIdmonitorPageSwitch = builder.viewIdMonitorPageSwitch;
        this.mMaxValidPageLoadTimeMs = builder.maxPageLoadTimeMs;
        this.mMaxValidLaunchTimeMs = builder.maxLaunchTimeMs;
        this.mTraceListener = builder.traceListener;
        this.mReportEvilMethodSwitch = builder.reportEvilMethodSwitch;
        this.mEvilMethodThresholdMs = builder.evilMethodThresholdMs;
        this.mLimitEvilMethodDepth = builder.limitEvilMethodDepth;
        this.mFullFpsTracer = builder.fullFpsTracer;
        this.mDisableFpsTracer = builder.disableFpsTracer;
        this.mChangeFpsLifeCycle = builder.changeFpsLifeCycle;
        this.mActivityFps = builder.activityFps;
        this.mBinderMonitor = builder.binderMonitor;
        this.mTraceExtraCollectTimeMs = builder.launchExtraInfoCollectTimeMs;
        this.mTraceExtraFlag = builder.launchExtraInfoFlag;
        this.mIgnoreNetMonitorUserAgentLabel = builder.ignoreNetMonitorUserAgentLabel;
        this.mProcessName = builder.processName;
        this.mActivityLeakDetectConfig = builder.activityLeakDetectConfig;
        this.mLaunchConfig = builder.mLaunchConfig;
        this.mSupportMultiFrameRate = builder.supportMultiFrameRate;
        ApmContext.setDebugMode(builder.debugMode);
        ApmContext.setInternalTest(builder.isInternalTest);
        this.mEnableDeviceInfoOnPerfData = builder.enableDeviceInfoOnPerfData;
        this.mAlogUploadStrategy = builder.mAlogUploadStrategy;
        this.isReportCacheException = builder.isReportCacheException;
        this.mEnableSliverDump = builder.enableSliverDump;
        this.mEnableCpuAllocOpt = builder.enableCpuAllocOpt;
        this.mEnableCloseListener = builder.enableCloseListener;
        this.mEnableLooperOpt = builder.enableLooperOpt;
        this.mEnableLooperDeepOpt = builder.enableLooperDeepOpt;
        this.mHttpUrlConnectionInterceptor = builder.urlConnectionInterceptor;
    }

    public String toString() {
        return "ApmInitConfig{mCacheBufferCount=" + this.mCacheBufferCount + ", isReportCacheException=" + this.isReportCacheException + ", mViewIdmonitorPageSwitch=" + this.mViewIdmonitorPageSwitch + ", mMaxValidPageLoadTimeMs=" + this.mMaxValidPageLoadTimeMs + ", mMaxValidLaunchTimeMs=" + this.mMaxValidLaunchTimeMs + ", mTraceListener=" + this.mTraceListener + ", mReportEvilMethodSwitch=" + this.mReportEvilMethodSwitch + ", mEvilMethodThresholdMs=" + this.mEvilMethodThresholdMs + ", mLimitEvilMethodDepth=" + this.mLimitEvilMethodDepth + ", mFullFpsTracer=" + this.mFullFpsTracer + ", mDisableFpsTracer=" + this.mDisableFpsTracer + ", mChangeFpsLifeCycle=" + this.mChangeFpsLifeCycle + ", mActivityFps=" + this.mActivityFps + ", mBinderMonitor=" + this.mBinderMonitor + ", mTraceExtraFlag=" + this.mTraceExtraFlag + ", mTraceExtraCollectTimeMs=" + this.mTraceExtraCollectTimeMs + ", mActivityLeakDetectConfig=" + this.mActivityLeakDetectConfig + ", mIgnoreNetMonitorUserAgentLabel='" + this.mIgnoreNetMonitorUserAgentLabel + "', mProcessName='" + this.mProcessName + "', mEnableDeviceInfoOnPerfData=" + this.mEnableDeviceInfoOnPerfData + ", mLaunchConfig=" + this.mLaunchConfig + ", mSupportMultiFrameRate=" + this.mSupportMultiFrameRate + ", mEnableSliverDump=" + this.mEnableSliverDump + ", mEnableCpuAllocOpt=" + this.mEnableCpuAllocOpt + ", mEnableCloseListener=" + this.mEnableCloseListener + ", mEnableLooperOpt=" + this.mEnableLooperOpt + ", mAlogUploadStrategy=" + this.mAlogUploadStrategy + '}';
    }

    public boolean isEnableSliverDump() {
        return this.mEnableSliverDump;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        private boolean activityFps;
        private ActivityLeakDetectConfig activityLeakDetectConfig;
        private boolean binderMonitor;
        private int cacheBufferCount;
        private boolean changeFpsLifeCycle;
        private boolean debugMode;
        private boolean disableFpsTracer;
        private boolean enableCloseListener;
        private boolean enableCpuAllocOpt;
        private boolean enableDeviceInfoOnPerfData;
        private boolean enableLooperDeepOpt;
        private boolean enableLooperOpt;
        private boolean enableSliverDump;
        private long evilMethodThresholdMs;
        private boolean fullFpsTracer;
        private String ignoreNetMonitorUserAgentLabel;
        private boolean isInternalTest;
        private boolean isReportCacheException;
        private long launchExtraInfoCollectTimeMs;
        private int launchExtraInfoFlag;
        private boolean limitEvilMethodDepth;
        private IAlogUploadStrategy mAlogUploadStrategy;
        private LaunchInitConfig mLaunchConfig;
        private long maxLaunchTimeMs;
        private long maxPageLoadTimeMs;
        private String processName;
        private boolean reportEvilMethodSwitch;
        private boolean supportMultiFrameRate;
        private ITraceListener traceListener;
        private IHttpUrlConnectionInterceptor urlConnectionInterceptor;
        private boolean viewIdMonitorPageSwitch;

        private Builder() {
            this.disableFpsTracer = false;
            this.changeFpsLifeCycle = false;
            this.activityFps = false;
            this.enableDeviceInfoOnPerfData = false;
            this.cacheBufferCount = 1000;
            this.viewIdMonitorPageSwitch = false;
            this.maxPageLoadTimeMs = TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS;
            this.maxLaunchTimeMs = TraceStatsConsts.APP_START_MAX_LIMIT_MS;
            this.reportEvilMethodSwitch = false;
            this.evilMethodThresholdMs = 1000L;
            this.launchExtraInfoFlag = 0;
            this.launchExtraInfoCollectTimeMs = 30000L;
            this.mAlogUploadStrategy = new DefaultAlogUploadStrategy();
        }

        public Builder launchInitConfig(LaunchInitConfig launchInitConfig) {
            this.mLaunchConfig = launchInitConfig;
            return this;
        }

        public Builder cacheBufferCount(int i) {
            this.cacheBufferCount = i;
            return this;
        }

        public Builder reportCacheExceptionEnable(boolean z) {
            this.isReportCacheException = z;
            return this;
        }

        public Builder viewIdMonitorPageSwitch(boolean z) {
            this.viewIdMonitorPageSwitch = z;
            return this;
        }

        public Builder detectActivityLeak(ActivityLeakDetectConfig activityLeakDetectConfig) {
            this.activityLeakDetectConfig = activityLeakDetectConfig;
            return this;
        }

        public Builder maxValidPageLoadTimeMs(long j) {
            this.maxPageLoadTimeMs = j;
            return this;
        }

        public Builder maxValidLaunchTimeMs(long j) {
            this.maxLaunchTimeMs = j;
            return this;
        }

        public Builder reportEvilMethodSwitch(boolean z) {
            this.reportEvilMethodSwitch = z;
            return this;
        }

        public Builder enableLooperDeepOpt(boolean z) {
            this.enableLooperDeepOpt = z;
            return this;
        }

        public Builder pageTraceListener(ITraceListener iTraceListener) {
            this.traceListener = iTraceListener;
            return this;
        }

        public Builder evilMethodThresholdMs(long j) {
            this.evilMethodThresholdMs = j;
            return this;
        }

        public Builder limitEvilMethodDepth(boolean z) {
            this.limitEvilMethodDepth = z;
            return this;
        }

        public Builder fullFpsTracer(boolean z) {
            this.fullFpsTracer = z;
            return this;
        }

        public Builder diableFpsTracer(boolean z) {
            this.disableFpsTracer = z;
            return this;
        }

        public Builder changeFpsLifeCycle(boolean z) {
            this.changeFpsLifeCycle = z;
            return this;
        }

        public Builder enableCpuAllocOpt(boolean z) {
            this.enableCpuAllocOpt = z;
            return this;
        }

        public Builder enableCloseListener(boolean z) {
            this.enableCloseListener = z;
            return this;
        }

        public Builder enableLooperOpt(boolean z) {
            this.enableLooperOpt = z;
            return this;
        }

        public Builder enableActivityFps(boolean z) {
            this.activityFps = z;
            return this;
        }

        public Builder binderMonitor(boolean z) {
            this.binderMonitor = z;
            return this;
        }

        @Deprecated
        public Builder traceExtraFlag(int i) {
            this.launchExtraInfoFlag = i;
            return this;
        }

        @Deprecated
        public Builder traceExtraCollectTimeMs(long j) {
            this.launchExtraInfoCollectTimeMs = j;
            return this;
        }

        public Builder ignoreNetMonitorUserAgentLabel(String str) {
            this.ignoreNetMonitorUserAgentLabel = str;
            return this;
        }

        public Builder processName(String str) {
            this.processName = str;
            return this;
        }

        public Builder debugMode(boolean z) {
            this.debugMode = z;
            return this;
        }

        public boolean isInternalTest() {
            return this.isInternalTest;
        }

        public Builder setInternalTest(boolean z) {
            this.isInternalTest = z;
            return this;
        }

        public Builder enableDeviceInfoOnPerfData(boolean z) {
            this.enableDeviceInfoOnPerfData = z;
            return this;
        }

        public Builder supportMultiFrameRate(boolean z) {
            this.supportMultiFrameRate = z;
            return this;
        }

        public Builder setAlogUploadStrategy(IAlogUploadStrategy iAlogUploadStrategy) {
            this.mAlogUploadStrategy = iAlogUploadStrategy;
            return this;
        }

        public Builder enableSliverDump(boolean z) {
            this.enableSliverDump = z;
            return this;
        }

        public Builder httpUrlConnectionInterceptor(IHttpUrlConnectionInterceptor iHttpUrlConnectionInterceptor) {
            this.urlConnectionInterceptor = iHttpUrlConnectionInterceptor;
            return this;
        }

        public ApmInitConfig build() {
            return new ApmInitConfig(this);
        }

        public boolean isEnableCpuAllocOpt() {
            return this.enableCpuAllocOpt;
        }

        public void setEnableCpuAllocOpt(boolean z) {
            this.enableCpuAllocOpt = z;
        }
    }
}
