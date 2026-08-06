package com.bytedance.apm.config;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.abs.IEnhancedInterceptor;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.ReportUrl;
import com.bytedance.apm.core.IDynamicParams;
import com.bytedance.apm.core.IQueryParams;
import com.bytedance.apm.impl.DefaultTTNetImpl;
import com.bytedance.apm.listener.IApmLogListener;
import com.bytedance.apm.listener.IApmStartListener;
import com.bytedance.apm.listener.IBlockListener;
import com.bytedance.apm.listener.IMemoryReachTopListener;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm.listener.IStorageCheckListener;
import com.bytedance.apm.listener.ITrafficCallback;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.logging.IApmAlog;
import com.bytedance.apm.util.JsonUtils;
import com.bytedance.apm.util.Preconditions;
import com.bytedance.apm6.foundation.UnSampleListener;
import com.bytedance.apm6.monitor.MonitorableInterceptor;
import com.bytedance.frameworks.core.encrypt.TTEncryptUtils;
import com.bytedance.services.apm.api.IEncrypt;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IRequestTagHeaderProvider;
import com.bytedance.services.apm.api.IWidget;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ApmStartConfig {
    private final String mAlogFilesDir;
    private final IApmLogListener mApmLogListener;
    private final IApmStartListener mApmStartListener;
    private final IBlockListener mBlockListener;
    private final long mBlockThresholdMs;
    private final ITrafficCallback mCallback;
    private List<String> mDefaultLogReportUrls;
    private final long mDelayNetRequestSeconds;
    private final IDynamicParams mDynamicParams;
    private final boolean mEnableBatteryLocalRecord;
    private final boolean mEnableBlockOnlySampled;
    private final boolean mEnableMultiProcessRequestSetting;
    private final boolean mEnableTemperatureLocalRecord;
    private final boolean mEnableTrafficDetect;
    private final IEncrypt mEncryptor;
    private List<String> mExceptionLogReportUrls;
    private final ExecutorService mExecutor;
    private final boolean mForceUpdateSlardarSetting;
    private final JSONObject mHeader;
    private final IHttpService mHttpService;
    private final boolean mIgnoreInvalidStack;
    private final IEnhancedInterceptor mInterceptor;
    private IMemoryReachTopListener mMemoryReachTopListener;
    private final boolean mNetMonitorWithDisconnected;
    private final INtpTimeService mNtpTimeService;
    private final IQueryParams mQueryParams;
    private List<String> mSlardarConfigUrls;
    private final IStorageCheckListener mStorageCheckListener;
    private List<String> mTraceReportUrls;
    private final Set<IWidget> mWidgets;
    private final boolean mWithBatteryDetect;
    private final boolean mWithBlockDetect;
    private final boolean mWithExceptionTrafficDetect;
    private final boolean mWithSeriousBlockDetect;
    private final boolean mWithTemperatureDetect;
    private final boolean mWithWebViewTrafficDetect;
    private final IRequestTagHeaderProvider provider;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ApmStartConfig apmStartConfig) {
        return new Builder(apmStartConfig);
    }

    private ApmStartConfig(Builder builder) {
        this.mHeader = builder.paramsHeader;
        this.mForceUpdateSlardarSetting = builder.forceUpdateSlardarSetting;
        this.mEnableMultiProcessRequestSetting = builder.enableMultiProcessRequestSetting;
        this.mDynamicParams = builder.dynamicParams;
        this.mSlardarConfigUrls = builder.slardarConfigUrls;
        this.mHttpService = builder.httpService;
        this.mEnableTrafficDetect = builder.enableTrafficDetect;
        this.mWithExceptionTrafficDetect = builder.exceptionTrafficDetect;
        this.mWithBlockDetect = builder.blockDetect;
        this.mEnableBlockOnlySampled = builder.blockDetectOnlySampled;
        this.mWithSeriousBlockDetect = builder.seriousBlockDetect;
        this.mIgnoreInvalidStack = builder.ignoreInvalidStack;
        this.mBlockThresholdMs = builder.blockThresholdMs;
        this.mWithBatteryDetect = builder.batteryDetect;
        this.mEnableBatteryLocalRecord = builder.batteryLocalRecord;
        this.mEnableTemperatureLocalRecord = builder.temperatureLocalRecord;
        this.mWidgets = builder.widgets;
        this.mDefaultLogReportUrls = builder.normalLogReportUrls;
        this.mExceptionLogReportUrls = builder.exceptionLogReportUrls;
        this.mTraceReportUrls = builder.traceReportUrls;
        this.mDelayNetRequestSeconds = builder.delayNetRequestSeconds;
        this.mWithTemperatureDetect = builder.temperatureDetect;
        this.mWithWebViewTrafficDetect = builder.withWebViewTrafficDetect;
        this.mApmLogListener = builder.apmLogListener;
        this.mApmStartListener = builder.apmStartListener;
        this.mStorageCheckListener = builder.storageCheckListener;
        this.mExecutor = builder.executor;
        this.mMemoryReachTopListener = builder.memoryReachTopListener;
        this.mEncryptor = builder.encryptor;
        this.mNetMonitorWithDisconnected = builder.netMonitorWithDisconnected;
        this.mAlogFilesDir = builder.alogFilesDir;
        this.mCallback = builder.trafficCallback;
        this.mNtpTimeService = builder.nptTimeService;
        this.mQueryParams = builder.queryParams;
        this.mBlockListener = builder.blockListener;
        this.mInterceptor = builder.monitorableInterceptor;
        this.provider = builder.provider;
        ApmAlogHelper.setApmLogger(builder.apmAlogInstance);
        ApmAlogHelper.setUnSampleListener(builder.unSampleListener);
    }

    public INtpTimeService getNtpTimeService() {
        return this.mNtpTimeService;
    }

    public IQueryParams getQueryParams() {
        return this.mQueryParams;
    }

    public IDynamicParams getDynamicParams() {
        return this.mDynamicParams;
    }

    public IMemoryReachTopListener getMemoryReachTopListener() {
        return this.mMemoryReachTopListener;
    }

    public List<String> getSlardarConfigUrls() {
        return this.mSlardarConfigUrls;
    }

    public boolean isForceUpdateSlardarSetting() {
        return this.mForceUpdateSlardarSetting;
    }

    public boolean isEnableMultiProcessRequestSetting() {
        return this.mEnableMultiProcessRequestSetting;
    }

    public List<String> getDefaultLogReportUrls() {
        return this.mDefaultLogReportUrls;
    }

    public void setDefaultLogReportUrlsCompat(List<String> list) {
        this.mDefaultLogReportUrls = list;
    }

    public void setSlardarConfigUrlsCompat(List<String> list) {
        this.mSlardarConfigUrls = list;
    }

    public void setExceptionLogReportUrlsCompat(List<String> list) {
        this.mExceptionLogReportUrls = list;
    }

    public List<String> getExceptionLogReportUrls() {
        return this.mExceptionLogReportUrls;
    }

    public List<String> getTraceReportUrls() {
        return this.mTraceReportUrls;
    }

    public JSONObject getHeader() {
        return this.mHeader;
    }

    public long getDeviceId() {
        return this.mHeader.optLong("device_id");
    }

    public IHttpService getHttpService() {
        return this.mHttpService;
    }

    public IRequestTagHeaderProvider getRequestTagHeaderProvider() {
        return this.provider;
    }

    public Set<IWidget> getWidgets() {
        return this.mWidgets;
    }

    public boolean isWithExceptionTrafficDetect() {
        return this.mWithExceptionTrafficDetect;
    }

    public boolean isWithBlockDetect() {
        return this.mWithBlockDetect;
    }

    public boolean isEnableBlockOnlySampled() {
        return this.mEnableBlockOnlySampled;
    }

    public boolean isWithSeriousBlockDetect() {
        return this.mWithSeriousBlockDetect;
    }

    public boolean isIgnoreInvalidStack() {
        return this.mIgnoreInvalidStack;
    }

    public long getBlockThresholdMs() {
        return this.mBlockThresholdMs;
    }

    public boolean isWithTemperatureDetect() {
        return this.mWithTemperatureDetect;
    }

    public boolean isWithWebViewDetect() {
        return this.mWithWebViewTrafficDetect;
    }

    public long getDelayRequestSeconds() {
        return this.mDelayNetRequestSeconds;
    }

    public boolean isWithBatteryDetect() {
        return this.mWithBatteryDetect;
    }

    public boolean isBatteryLocalRecordEnable() {
        return this.mEnableBatteryLocalRecord;
    }

    public boolean isTemperatureLocalRecordEnable() {
        return this.mEnableTemperatureLocalRecord;
    }

    public boolean isEnableTrafficDetect() {
        return this.mEnableTrafficDetect;
    }

    public IApmStartListener getApmStartListener() {
        return this.mApmStartListener;
    }

    public IApmLogListener getApmLogListener() {
        return this.mApmLogListener;
    }

    public IStorageCheckListener getStorageCheckListener() {
        return this.mStorageCheckListener;
    }

    public ExecutorService getExecutor() {
        return this.mExecutor;
    }

    public IEncrypt getEncryptor() {
        return this.mEncryptor;
    }

    public boolean getNetMonitorWithDisconnected() {
        return this.mNetMonitorWithDisconnected;
    }

    public String getAlogFilesDir() {
        return this.mAlogFilesDir;
    }

    public ITrafficCallback getTrafficCallback() {
        return this.mCallback;
    }

    public IBlockListener getBlockListener() {
        return this.mBlockListener;
    }

    public String toString() {
        return "ApmStartConfig{mSlardarConfigUrls=" + this.mSlardarConfigUrls + ", mDefaultLogReportUrls=" + this.mDefaultLogReportUrls + ", mExceptionLogReportUrls=" + this.mExceptionLogReportUrls + ", mTraceReportUrls=" + this.mTraceReportUrls + ", mMemoryReachTopListener=" + this.mMemoryReachTopListener + ", mWithExceptionTrafficDetect=" + this.mWithExceptionTrafficDetect + ", mEnableTrafficDetect=" + this.mEnableTrafficDetect + ", mWithWebViewTrafficDetect=" + this.mWithWebViewTrafficDetect + ", mWithBlockDetect=" + this.mWithBlockDetect + ", mEnableBlockOnlySampled=" + this.mEnableBlockOnlySampled + ", mWithSeriousBlockDetect=" + this.mWithSeriousBlockDetect + ", mBlockThresholdMs=" + this.mBlockThresholdMs + ", mWithTemperatureDetect=" + this.mWithTemperatureDetect + ", mWithBatteryDetect=" + this.mWithBatteryDetect + ", mEnableBatteryLocalRecord=" + this.mEnableBatteryLocalRecord + ", mEnableTemperatureLocalRecord=" + this.mEnableTemperatureLocalRecord + ", mForceUpdateSlardarSetting=" + this.mForceUpdateSlardarSetting + ", mEnableMultiProcessRequestSetting=" + this.mEnableMultiProcessRequestSetting + ", mNetMonitorWithDisconnected=" + this.mNetMonitorWithDisconnected + ", mHeader=" + this.mHeader + ", mDynamicParams=" + this.mDynamicParams + ", mQueryParams=" + this.mQueryParams + ", mHttpService=" + this.mHttpService + ", mWidgets=" + this.mWidgets + ", mDelayNetRequestSeconds=" + this.mDelayNetRequestSeconds + ", mApmStartListener=" + this.mApmStartListener + ", mApmLogListener=" + this.mApmLogListener + ", mStorageCheckListener=" + this.mStorageCheckListener + ", mExecutor=" + this.mExecutor + ", mEncryptor=" + this.mEncryptor + ", mAlogFilesDir='" + this.mAlogFilesDir + "', mCallback=" + this.mCallback + ", mNtpTimeService=" + this.mNtpTimeService + '}';
    }

    public MonitorableInterceptor getInterceptor() {
        return this.mInterceptor;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Builder {
        String alogFilesDir;
        IApmAlog apmAlogInstance;
        IApmLogListener apmLogListener;
        IApmStartListener apmStartListener;
        boolean batteryDetect;
        boolean batteryLocalRecord;
        boolean blockDetect;
        boolean blockDetectOnlySampled;
        IBlockListener blockListener;
        long blockThresholdMs;
        long delayNetRequestSeconds;
        IDynamicParams dynamicParams;
        boolean enableMultiProcessRequestSetting;
        boolean enableTrafficDetect;
        IEncrypt encryptor;
        List<String> exceptionLogReportUrls;
        boolean exceptionTrafficDetect;
        ExecutorService executor;
        boolean forceUpdateSlardarSetting;
        IHttpService httpService;
        boolean ignoreInvalidStack;
        IMemoryReachTopListener memoryReachTopListener;
        IEnhancedInterceptor monitorableInterceptor;
        boolean netMonitorWithDisconnected;
        List<String> normalLogReportUrls;
        INtpTimeService nptTimeService;
        JSONObject paramsHeader;
        IRequestTagHeaderProvider provider;
        IQueryParams queryParams;
        boolean seriousBlockDetect;
        List<String> slardarConfigUrls;
        IStorageCheckListener storageCheckListener;
        boolean temperatureDetect;
        boolean temperatureLocalRecord;
        List<String> traceReportUrls;
        ITrafficCallback trafficCallback;
        UnSampleListener unSampleListener;
        Set<IWidget> widgets;
        boolean withWebViewTrafficDetect;

        Builder() {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = ReportUrl.FETCH_SETTING_LIST;
            this.normalLogReportUrls = ReportUrl.REPORT_URL_LIST;
            this.exceptionLogReportUrls = ReportUrl.EXCEPTION_UPLOAD_URL_LIST;
            this.traceReportUrls = ReportUrl.REPORT_TRACING_URL_LIST;
            this.paramsHeader = new JSONObject();
            this.widgets = new HashSet();
            this.delayNetRequestSeconds = 0L;
            this.blockThresholdMs = PerfConsts.DEFAULT_BLOCK_INTERVAL_MS;
            this.encryptor = new IEncrypt() { // from class: com.bytedance.apm.config.ApmStartConfig.Builder.1
                public byte[] encrypt(byte[] bArr) {
                    return TTEncryptUtils.encrypt(bArr, bArr.length);
                }
            };
            this.blockDetect = StartConfigParams.BLOCK_COLLECT_ENABLE_SWITCH;
            this.temperatureDetect = StartConfigParams.TEMPERATURE_COLLECT_ENABLE_SWITCH;
            this.exceptionTrafficDetect = StartConfigParams.TRAFFIC_EXCEPTION_COLLECT_ENABLE_SWITCH;
        }

        Builder(ApmStartConfig apmStartConfig) {
            this.blockDetectOnlySampled = false;
            this.enableTrafficDetect = true;
            this.slardarConfigUrls = apmStartConfig.mSlardarConfigUrls;
            this.normalLogReportUrls = apmStartConfig.mDefaultLogReportUrls;
            this.exceptionLogReportUrls = apmStartConfig.mExceptionLogReportUrls;
            this.traceReportUrls = apmStartConfig.mTraceReportUrls;
            this.blockDetect = apmStartConfig.mWithBlockDetect;
            this.ignoreInvalidStack = apmStartConfig.mIgnoreInvalidStack;
            this.blockDetectOnlySampled = apmStartConfig.mEnableBlockOnlySampled;
            this.seriousBlockDetect = apmStartConfig.mWithSeriousBlockDetect;
            this.blockThresholdMs = apmStartConfig.mBlockThresholdMs;
            this.temperatureDetect = apmStartConfig.mWithTemperatureDetect;
            this.withWebViewTrafficDetect = apmStartConfig.mWithWebViewTrafficDetect;
            this.batteryDetect = apmStartConfig.mWithBatteryDetect;
            this.batteryLocalRecord = apmStartConfig.mEnableBatteryLocalRecord;
            this.paramsHeader = apmStartConfig.mHeader;
            this.dynamicParams = apmStartConfig.mDynamicParams;
            this.widgets = apmStartConfig.mWidgets;
            this.httpService = apmStartConfig.mHttpService;
            this.apmLogListener = apmStartConfig.getApmLogListener();
            this.memoryReachTopListener = apmStartConfig.mMemoryReachTopListener;
            this.encryptor = apmStartConfig.mEncryptor;
            this.netMonitorWithDisconnected = apmStartConfig.mNetMonitorWithDisconnected;
            this.nptTimeService = apmStartConfig.mNtpTimeService;
            this.queryParams = apmStartConfig.mQueryParams;
            this.blockListener = apmStartConfig.mBlockListener;
            this.monitorableInterceptor = apmStartConfig.mInterceptor;
        }

        public Builder memoryReachTop(IMemoryReachTopListener iMemoryReachTopListener) {
            this.memoryReachTopListener = iMemoryReachTopListener;
            return this;
        }

        public Builder queryParams(IQueryParams iQueryParams) {
            this.queryParams = iQueryParams;
            return this;
        }

        public Builder releaseBuild(String str) {
            return param("release_build", str);
        }

        public Builder aid(int i) {
            return param("aid", i);
        }

        public Builder deviceId(String str) {
            return param("device_id", str);
        }

        public Builder appVersion(String str) {
            return param("app_version", str);
        }

        public Builder updateVersionCode(String str) {
            return param("update_version_code", str);
        }

        public Builder channel(String str) {
            return param("channel", str);
        }

        public Builder enableTrafficDetect(boolean z) {
            this.enableTrafficDetect = z;
            return this;
        }

        public Builder enableNetMonitorWithDisconnected(boolean z) {
            this.netMonitorWithDisconnected = z;
            return this;
        }

        public Builder exceptionTrafficDetect(boolean z) {
            this.exceptionTrafficDetect = z;
            return this;
        }

        public Builder webViewTrafficDetect(boolean z) {
            this.withWebViewTrafficDetect = z;
            return this;
        }

        public Builder blockDetect(boolean z) {
            this.blockDetect = z;
            return this;
        }

        public Builder blockDetectOnlySampled(boolean z) {
            this.blockDetectOnlySampled = z;
            return this;
        }

        public Builder blockThresholdMs(long j) {
            this.blockThresholdMs = j;
            return this;
        }

        public Builder seriousBlockDetect(boolean z) {
            this.seriousBlockDetect = z;
            return this;
        }

        public Builder ignoreInvalidStack(boolean z) {
            this.ignoreInvalidStack = z;
            return this;
        }

        public Builder forceUpdateSlardarSetting(boolean z) {
            this.forceUpdateSlardarSetting = z;
            return this;
        }

        public Builder enableMultiProcessRequestSetting(boolean z) {
            this.enableMultiProcessRequestSetting = z;
            return this;
        }

        public Builder batteryDetect(boolean z) {
            this.batteryDetect = z;
            return this;
        }

        public Builder batteryLocalRecord(boolean z) {
            this.batteryLocalRecord = z;
            return this;
        }

        public Builder temperatureLocalRecord(boolean z) {
            this.temperatureLocalRecord = z;
            return this;
        }

        public Builder temperatureDetect(boolean z) {
            this.temperatureDetect = z;
            return this;
        }

        public Builder injectExecutor(ExecutorService executorService) {
            this.executor = executorService;
            return this;
        }

        public Builder defaultReportUrls(List<String> list) {
            this.normalLogReportUrls = list;
            return this;
        }

        public Builder exceptionLogDefaultReportUrls(List<String> list) {
            this.exceptionLogReportUrls = list;
            return this;
        }

        public Builder configFetchUrl(List<String> list) {
            this.slardarConfigUrls = list;
            return this;
        }

        public Builder traceReportUrl(List<String> list) {
            this.traceReportUrls = list;
            return this;
        }

        public Builder delayReport(long j) {
            this.delayNetRequestSeconds = Math.min(j, 30L);
            return this;
        }

        public Builder dynamicParams(IDynamicParams iDynamicParams) {
            this.dynamicParams = iDynamicParams;
            return this;
        }

        public Builder useDefaultTTNetImpl(boolean z) {
            if (z) {
                this.httpService = new DefaultTTNetImpl();
            }
            return this;
        }

        public Builder useHttpService(IHttpService iHttpService) {
            this.httpService = iHttpService;
            return this;
        }

        public Builder apmStartListener(IApmStartListener iApmStartListener) {
            this.apmStartListener = iApmStartListener;
            return this;
        }

        public Builder apmLogListener(IApmLogListener iApmLogListener) {
            this.apmLogListener = iApmLogListener;
            return this;
        }

        public Builder setStorageCheckListener(IStorageCheckListener iStorageCheckListener) {
            this.storageCheckListener = iStorageCheckListener;
            return this;
        }

        public Builder setAlogInstance(IApmAlog iApmAlog) {
            this.apmAlogInstance = iApmAlog;
            return this;
        }

        public Builder setUnSampleListener(UnSampleListener unSampleListener) {
            this.unSampleListener = unSampleListener;
            return this;
        }

        public Builder setAlogFilesDir(String str) {
            this.alogFilesDir = str;
            return this;
        }

        public Builder requestTagHeaderProvider(IRequestTagHeaderProvider iRequestTagHeaderProvider) {
            this.provider = iRequestTagHeaderProvider;
            return this;
        }

        public Builder setTrafficCallback(ITrafficCallback iTrafficCallback) {
            this.trafficCallback = iTrafficCallback;
            return this;
        }

        public Builder setBlockListener(IBlockListener iBlockListener) {
            this.blockListener = iBlockListener;
            return this;
        }

        public Builder setNptTimeService(INtpTimeService iNtpTimeService) {
            this.nptTimeService = iNtpTimeService;
            return this;
        }

        public Builder setDiskMBThresholdToday(int i) {
            param(CommonKey.OUTSIDE_MAX_SIZE_MB_TODAY, i);
            return this;
        }

        public Builder setEncrypt(IEncrypt iEncrypt) {
            this.encryptor = iEncrypt;
            return this;
        }

        public Builder setMonitorInterceptor(IEnhancedInterceptor iEnhancedInterceptor) {
            this.monitorableInterceptor = iEnhancedInterceptor;
            return this;
        }

        public Builder widget(IWidget iWidget) {
            if (iWidget == null || (!ApmContext.isMainProcess() && iWidget.isOnlyMainProcess())) {
                return this;
            }
            this.widgets.add(iWidget);
            return this;
        }

        public Builder params(JSONObject jSONObject) {
            try {
                JsonUtils.copyJson2(this.paramsHeader, jSONObject);
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder param(String str, String str2) {
            try {
                this.paramsHeader.put(str, str2);
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder param(String str, int i) {
            try {
                this.paramsHeader.put(str, i);
            } catch (JSONException unused) {
            }
            return this;
        }

        public Builder param(String str, long j) {
            try {
                this.paramsHeader.put(str, j);
            } catch (JSONException unused) {
            }
            return this;
        }

        public ApmStartConfig build() {
            Preconditions.checkNotEmpty(this.paramsHeader.optString("aid"), "aid");
            Preconditions.checkNotNull(this.dynamicParams, "dynamicParams");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("app_version"), "app_version");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("update_version_code"), "update_version_code");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("device_id"), "device_id");
            Preconditions.checkNotEmptySafely(this.paramsHeader.optString("release_build"), "release_build");
            return new ApmStartConfig(this);
        }
    }
}
