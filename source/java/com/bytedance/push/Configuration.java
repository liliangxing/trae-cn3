package com.bytedance.push;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.common.model.ClientDisplayFeature;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.AbProvider;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.push.user.AccountSDKImpl;
import com.bytedance.push.img.ImageDownloader;
import com.bytedance.push.img.UrlConnectionDownloader;
import com.bytedance.push.interfaze.HMSLowVersionCallback;
import com.bytedance.push.interfaze.I18nCommonParams;
import com.bytedance.push.interfaze.ICommonParams;
import com.bytedance.push.interfaze.ICustomNotificationBuilder;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.IPushMsgShowInterceptor;
import com.bytedance.push.interfaze.IRegisterResultCallback;
import com.bytedance.push.interfaze.IRevokeEventInterceptor;
import com.bytedance.push.interfaze.IVerifyFailedListener;
import com.bytedance.push.interfaze.OnPushClickListener;
import com.bytedance.push.interfaze.OnPushReceiveHandler;
import com.bytedance.push.interfaze.SoLoader;
import com.bytedance.push.interfaze.UrlFilter;
import com.bytedance.push.monitor.IPushMonitor;
import com.bytedance.push.monitor.opentracing.ITracingMonitor;
import com.bytedance.push.notification.AsyncSoundDownloaderWrapper;
import com.bytedance.push.notification.PushReceiveHandler;
import com.bytedance.push.sound.SoundDownloader;
import com.bytedance.push.sound.UrlConnectionSoundDownloader;
import com.bytedance.push.utils.Logger;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.ss.android.message.IPushLifeAdapter;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.KeyConfiguration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Configuration {
    public static final String DEFAULT_ADM_PAYLOAD_NAME = "payload";
    public static final String DEFAULT_FCM_PAYLOAD_NAME = "payload";
    public static final String NOTIFICATION_ID = "push";
    private static Configuration sInstance;
    public final boolean forbidSDKClickEvent;
    public final long initTimeout;
    public final AbProvider mAbProvider;
    public final IAccountService mAccountService;
    public final List<IPushLifeAdapter> mAdapters;
    public final String mAdmPayloadName;
    public final int mAid;
    public final String mAppName;
    public final Application mApplication;
    public final AsyncSoundDownloaderWrapper mAsyncSoundDownloaderWrapper;
    public final boolean mAutoInitRedBadge;
    public final boolean mAutoUpdateSettings;
    public final String mChannel;
    private final ClientDisplayFeature mClientDisplayFeature;
    public final boolean mDebug;
    public final Notification mDefaultNotificationChannel;
    public boolean mEnableAlog;
    public final boolean mEnableInitOnApplicationWithOldConfigurationDelay;
    public final boolean mEnableLazy;
    public final boolean mEnableOnInitDelay;
    public final boolean mEnableOnInitOnProcessIsolationProtectedModeDelay;
    public final boolean mEnableOnMainProcessInitDelay;
    public final boolean mEnableRealTimeReportEvent;
    public final IEventSender mEventCallback;
    public final ICommonParams mExtraParams;
    public final String mFcmPayloadName;
    public final UrlFilter mFilter;
    public final HMSLowVersionCallback mHMSCallback;
    public final String mHost;
    public final I18nCommonParams mI18nCommonParams;
    private final IPushCommonConfiguration mIPushCommonConfiguration;
    private final boolean mIsBoe;
    public final boolean mIsLaunchFromIcon;
    public boolean mIsNewUser;
    public final boolean mIsPreInstallVersion;
    public final boolean mIsThroughMsgEncrypt;
    public final KeyConfiguration mKeyConfiguration;
    public final int mLogLevel;
    public final IPushMonitor mMonitor;
    public final int[] mNotificationSoundsRes;
    public final OnPushClickListener mOnPushClickListener;
    public final String mProcess;
    public String mPushAlogInstanceName;
    private volatile PushCommonConfiguration mPushCommonConfiguration;
    public final PushReceiveHandler mPushReceiveHandler;
    private final IRegisterResultCallback mRegisterResultCallback;
    public final SoLoader mSoLoader;
    public final int mUpdateVersionCode;
    public final int mVersionCode;
    public final String mVersionName;
    public final ITracingMonitor openTracingMonitor;
    public final IRevokeEventInterceptor revokeEventInterceptor;
    public final IVerifyFailedListener verifyFailedListener;

    public static Configuration get() {
        return sInstance;
    }

    public static void setInstance(Configuration configuration) {
        sInstance = configuration;
    }

    private Configuration(Application application, AppInfo appInfo, boolean z, int i, String str, Notification notification, List<IPushLifeAdapter> list, IEventSender iEventSender, PushReceiveHandler pushReceiveHandler, String str2, UrlFilter urlFilter, HMSLowVersionCallback hMSLowVersionCallback, KeyConfiguration keyConfiguration, ICommonParams iCommonParams, I18nCommonParams i18nCommonParams, OnPushClickListener onPushClickListener, IPushMonitor iPushMonitor, SoLoader soLoader, String str3, boolean z2, IAccountService iAccountService, ITracingMonitor iTracingMonitor, AsyncSoundDownloaderWrapper asyncSoundDownloaderWrapper, int[] iArr, IRegisterResultCallback iRegisterResultCallback, String str4, Builder builder) {
        this.mIsNewUser = true;
        this.mApplication = application;
        this.mAid = appInfo.getAid();
        this.mVersionCode = appInfo.getVersionCode();
        this.mUpdateVersionCode = appInfo.getUpdateVersionCode();
        this.mVersionName = appInfo.getVersionName();
        this.mChannel = appInfo.getChannel();
        this.mAppName = appInfo.getAppName();
        this.mDebug = z;
        this.mLogLevel = i;
        this.mProcess = str;
        this.mDefaultNotificationChannel = notification;
        this.mAdapters = new CopyOnWriteArrayList(list);
        this.mEventCallback = iEventSender;
        this.mPushReceiveHandler = pushReceiveHandler;
        this.mHost = str2;
        this.mFilter = urlFilter;
        this.mHMSCallback = hMSLowVersionCallback;
        this.mKeyConfiguration = keyConfiguration;
        this.mExtraParams = iCommonParams;
        this.mI18nCommonParams = i18nCommonParams;
        this.mOnPushClickListener = onPushClickListener;
        this.mMonitor = iPushMonitor;
        this.mSoLoader = soLoader;
        this.mFcmPayloadName = str3;
        this.mIsPreInstallVersion = z2;
        this.mAccountService = iAccountService;
        this.openTracingMonitor = iTracingMonitor;
        this.forbidSDKClickEvent = builder.mForbidSDKClickEvent;
        this.initTimeout = builder.mInitTimeout;
        this.revokeEventInterceptor = builder.mRevokeEventInterceptor;
        this.verifyFailedListener = builder.mVerifyFailedListener;
        this.mAsyncSoundDownloaderWrapper = asyncSoundDownloaderWrapper;
        this.mNotificationSoundsRes = iArr;
        this.mRegisterResultCallback = iRegisterResultCallback;
        this.mAdmPayloadName = str4;
        this.mEnableAlog = builder.mEnableAlog;
        this.mPushAlogInstanceName = builder.mPushAlogInstanceName;
        this.mEnableRealTimeReportEvent = builder.mEnableRealTimeReportEvent;
        this.mAutoUpdateSettings = builder.mAutoUpdateSettings;
        this.mIsThroughMsgEncrypt = builder.mIsThroughMsgEncrypt;
        this.mAbProvider = builder.mAbProvider;
        this.mIPushCommonConfiguration = builder.mIPushCommonConfiguration;
        this.mAutoInitRedBadge = builder.mAutoInitRedBadge;
        this.mIsBoe = builder.mIsBoe;
        this.mClientDisplayFeature = builder.mClientDisplayFeature;
        this.mEnableLazy = builder.mEnableLazy;
        this.mEnableOnInitDelay = builder.mEnableOnInitDelay;
        this.mEnableInitOnApplicationWithOldConfigurationDelay = builder.mEnableInitOnApplicationWithOldConfigurationDelay;
        this.mEnableOnInitOnProcessIsolationProtectedModeDelay = builder.mEnableOnInitOnProcessIsolationProtectedModeDelay;
        this.mEnableOnMainProcessInitDelay = builder.mEnableOnMainProcessInitDelay;
        this.mIsLaunchFromIcon = builder.mIsLaunchFromIcon;
    }

    public IRegisterResultCallback getRegisterResultCallback() {
        return this.mRegisterResultCallback;
    }

    public PushCommonConfiguration getPushCommonConfiguration() {
        if (this.mPushCommonConfiguration == null) {
            synchronized (this) {
                if (this.mPushCommonConfiguration == null) {
                    this.mPushCommonConfiguration = new PushCommonConfiguration();
                    this.mPushCommonConfiguration.mApplication = this.mApplication;
                    this.mPushCommonConfiguration.mAid = this.mAid;
                    this.mPushCommonConfiguration.mHost = this.mHost;
                    this.mPushCommonConfiguration.mVersionCode = this.mVersionCode;
                    this.mPushCommonConfiguration.mUpdateVersionCode = this.mUpdateVersionCode;
                    this.mPushCommonConfiguration.mVersionName = this.mVersionName;
                    this.mPushCommonConfiguration.mAppName = this.mAppName;
                    this.mPushCommonConfiguration.mChannel = this.mChannel;
                    this.mPushCommonConfiguration.mExtraParams = this.mExtraParams;
                    this.mPushCommonConfiguration.mI18nCommonParams = this.mI18nCommonParams;
                    this.mPushCommonConfiguration.mEnableRealTimeReportEvent = this.mEnableRealTimeReportEvent;
                    this.mPushCommonConfiguration.mIsDebugMode = this.mDebug;
                    this.mPushCommonConfiguration.mIPushCommonEventSender = this.mEventCallback;
                    this.mPushCommonConfiguration.mIsThroughMsgEncrypt = this.mIsThroughMsgEncrypt;
                    this.mPushCommonConfiguration.mEnableAlog = this.mEnableAlog;
                    this.mPushCommonConfiguration.mAbProvider = this.mAbProvider;
                    this.mPushCommonConfiguration.mIPushCommonConfiguration = this.mIPushCommonConfiguration;
                    this.mPushCommonConfiguration.mIsBoe = this.mIsBoe;
                    this.mPushCommonConfiguration.mClientDisplayFeature = this.mClientDisplayFeature;
                    this.mPushCommonConfiguration.mSelfAid = String.valueOf(this.mAid);
                    this.mPushCommonConfiguration.mProcess = this.mProcess;
                    this.mPushCommonConfiguration.mEnableLazy = this.mEnableLazy;
                    this.mPushCommonConfiguration.mIsLaunchFromIcon = this.mIsLaunchFromIcon;
                }
            }
        }
        return this.mPushCommonConfiguration;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Builder {
        private AbProvider mAbProvider;
        private IAccountService mAccountService;
        private String mAdmPayloadName;
        private final AppInfo mAppInfo;
        private final Application mApplication;
        private ClientDisplayFeature mClientDisplayFeature;
        private ICustomNotificationBuilder mCustomNotificationBuilder;
        private boolean mDebug;
        private Notification mDefaultNotificationChannel;
        private boolean mEnableInitOnApplicationWithOldConfigurationDelay;
        private boolean mEnableLazy;
        private boolean mEnableOnInitDelay;
        private boolean mEnableOnInitOnProcessIsolationProtectedModeDelay;
        private boolean mEnableOnMainProcessInitDelay;
        private boolean mEnableRealTimeReportEvent;
        private ICommonParams mExtraParams;
        private String mFcmPayloadName;
        private UrlFilter mFilter;
        private boolean mForbidSDKClickEvent;
        private HMSLowVersionCallback mHMSLowVersionCallback;
        private final String mHost;
        private I18nCommonParams mI18nCommonParams;
        private IPushCommonConfiguration mIPushCommonConfiguration;
        private ImageDownloader mImageDownloader;
        private boolean mIsBoe;
        private boolean mIsI18n;
        private boolean mIsLaunchFromIcon;
        private boolean mIsPreInstallVersion;
        private KeyConfiguration mKeyConfiguration;
        private IPushMonitor mMonitor;
        private int[] mNotificationSoundsRes;
        private OnPushClickListener mOnPushClickListener;
        private ITracingMonitor mOpenTracingMonitor;
        private String mProcess;
        private String mPushAlogInstanceName;
        private IEventSender mPushEventCallback;
        private IPushMsgShowInterceptor mPushShowInterceptor;
        private IRegisterResultCallback mResult;
        private IRevokeEventInterceptor mRevokeEventInterceptor;
        private SoLoader mSoLoader;
        private SoundDownloader mSoundDownloader;
        private IVerifyFailedListener mVerifyFailedListener;
        private int mLogLevel = 3;
        private List<IPushLifeAdapter> mPushLifeAdapters = new ArrayList();
        private long mInitTimeout = TimeUnit.MINUTES.toMillis(2);
        private boolean mEnableAlog = true;
        private boolean mAutoUpdateSettings = false;
        private boolean mIsThroughMsgEncrypt = false;
        private boolean mAutoInitRedBadge = true;

        public Builder(Application application, AppInfo appInfo, String str) {
            this.mApplication = application;
            this.mAppInfo = appInfo;
            this.mHost = str;
        }

        public Builder withDebug(boolean z) {
            this.mDebug = z;
            return this;
        }

        public Builder withLogLevel(int i) {
            this.mLogLevel = i;
            return this;
        }

        public Builder withProcess(String str) {
            this.mProcess = str;
            return this;
        }

        public Builder withDefaultNotificationChannel(String str) {
            this.mDefaultNotificationChannel = new Notification(Configuration.NOTIFICATION_ID, str);
            return this;
        }

        public Builder addPushLifeAdapter(IPushLifeAdapter iPushLifeAdapter) {
            if (iPushLifeAdapter != null && !this.mPushLifeAdapters.contains(iPushLifeAdapter)) {
                this.mPushLifeAdapters.add(iPushLifeAdapter);
            }
            return this;
        }

        public Builder setPushLifeAdapters(List<IPushLifeAdapter> list) {
            if (list != null) {
                this.mPushLifeAdapters = list;
            }
            return this;
        }

        public Builder withPushEventCallback(IEventSender iEventSender) {
            this.mPushEventCallback = iEventSender;
            return this;
        }

        public Builder withAccountService(IAccountService iAccountService) {
            this.mAccountService = iAccountService;
            return this;
        }

        @Deprecated
        public Builder withPushReceiveHandler(OnPushReceiveHandler onPushReceiveHandler) {
            setCustomNotificationBuilder(onPushReceiveHandler);
            setPushShowInterceptor(onPushReceiveHandler);
            return this;
        }

        public Builder setPushShowInterceptor(IPushMsgShowInterceptor iPushMsgShowInterceptor) {
            this.mPushShowInterceptor = iPushMsgShowInterceptor;
            return this;
        }

        public Builder setCustomNotificationBuilder(ICustomNotificationBuilder iCustomNotificationBuilder) {
            this.mCustomNotificationBuilder = iCustomNotificationBuilder;
            return this;
        }

        public Builder isI18n(boolean z) {
            this.mIsI18n = z;
            return this;
        }

        public Builder withFilterUninstallUrl(UrlFilter urlFilter) {
            this.mFilter = urlFilter;
            return this;
        }

        public Builder withHMSLowVersionCallback(HMSLowVersionCallback hMSLowVersionCallback) {
            this.mHMSLowVersionCallback = hMSLowVersionCallback;
            return this;
        }

        public Builder withImageDownloader(ImageDownloader imageDownloader) {
            this.mImageDownloader = imageDownloader;
            return this;
        }

        public Builder withExtraCommonParam(ICommonParams iCommonParams) {
            this.mExtraParams = iCommonParams;
            return this;
        }

        public Builder withPushClickListener(OnPushClickListener onPushClickListener) {
            this.mOnPushClickListener = onPushClickListener;
            return this;
        }

        public Builder withMonitorImpl(IPushMonitor iPushMonitor) {
            this.mMonitor = iPushMonitor;
            return this;
        }

        public Builder withSoLoader(SoLoader soLoader) {
            this.mSoLoader = soLoader;
            return this;
        }

        public Builder withFcmPayloadName(String str) {
            this.mFcmPayloadName = str;
            return this;
        }

        public Builder forbidSDKClickEvent(boolean z) {
            this.mForbidSDKClickEvent = z;
            return this;
        }

        public Builder defaultInitTimeout(long j) {
            if (j > 0) {
                this.mInitTimeout = j;
            }
            return this;
        }

        public Builder setPreInstallVersion(boolean z) {
            this.mIsPreInstallVersion = z;
            return this;
        }

        public Builder withOpenTracingMonitor(ITracingMonitor iTracingMonitor) {
            this.mOpenTracingMonitor = iTracingMonitor;
            return this;
        }

        public Builder setMsgRevokeEventInterceptor(IRevokeEventInterceptor iRevokeEventInterceptor) {
            this.mRevokeEventInterceptor = iRevokeEventInterceptor;
            return this;
        }

        public Builder setOnVerifyFailedListener(IVerifyFailedListener iVerifyFailedListener) {
            this.mVerifyFailedListener = iVerifyFailedListener;
            return this;
        }

        public Builder withSoundDownloader(SoundDownloader soundDownloader) {
            this.mSoundDownloader = soundDownloader;
            return this;
        }

        public Builder withRegisterResultCallback(IRegisterResultCallback iRegisterResultCallback) {
            this.mResult = iRegisterResultCallback;
            return this;
        }

        public Builder withAdmPayloadName(String str) {
            this.mAdmPayloadName = str;
            return this;
        }

        public Builder setIPushCommonConfiguration(IPushCommonConfiguration iPushCommonConfiguration) {
            this.mIPushCommonConfiguration = iPushCommonConfiguration;
            return this;
        }

        public Builder setAutoInitRedBadge(boolean z) {
            this.mAutoInitRedBadge = z;
            return this;
        }

        public Builder setEnableLazy(boolean z) {
            this.mEnableLazy = z;
            return this;
        }

        public Builder setEnableInitOnApplicationWithOldConfigurationDelay(boolean z) {
            this.mEnableInitOnApplicationWithOldConfigurationDelay = z;
            return this;
        }

        public Builder setEnableOnInitDelay(boolean z) {
            this.mEnableOnInitDelay = z;
            return this;
        }

        public Builder setEnableOnInitOnProcessIsolationProtectedModeDelay(boolean z) {
            this.mEnableOnInitOnProcessIsolationProtectedModeDelay = z;
            return this;
        }

        public Builder setEnableOnMainProcessInitDelay(boolean z) {
            this.mEnableOnMainProcessInitDelay = z;
            return this;
        }

        public Builder setIsLaunchFromIcon(boolean z) {
            this.mIsLaunchFromIcon = z;
            return this;
        }

        public Configuration build() {
            if (TextUtils.isEmpty(this.mProcess)) {
                this.mProcess = ToolUtils.getCurProcessName(this.mApplication);
            }
            if (this.mKeyConfiguration == null) {
                DefaultKeyConfiguration defaultKeyConfiguration = new DefaultKeyConfiguration(this.mIsI18n, this.mAppInfo.getChannel());
                this.mKeyConfiguration = defaultKeyConfiguration;
                if (this.mDebug) {
                    defaultKeyConfiguration.checkVersion(this.mApplication);
                }
            }
            if (this.mImageDownloader == null) {
                this.mImageDownloader = new UrlConnectionDownloader();
            }
            if (this.mSoLoader == null) {
                this.mSoLoader = new SoLoader.DefaultSoLoader();
            }
            if (this.mAccountService == null) {
                this.mAccountService = new AccountSDKImpl();
            }
            PushReceiveHandler pushReceiveHandler = new PushReceiveHandler(this.mCustomNotificationBuilder, this.mPushShowInterceptor, this.mImageDownloader);
            if (this.mSoundDownloader == null) {
                this.mSoundDownloader = new UrlConnectionSoundDownloader();
            }
            AsyncSoundDownloaderWrapper asyncSoundDownloaderWrapper = new AsyncSoundDownloaderWrapper(this.mSoundDownloader);
            printConfigurationInformation();
            if (this.mIsI18n && this.mI18nCommonParams == null && this.mDebug) {
                throw new IllegalArgumentException("please set mI18nCommonParams with com.bytedance.push.Configuration.Builder.withI18nCommonParams function");
            }
            if (this.mIPushCommonConfiguration == null) {
                this.mIPushCommonConfiguration = new DefaultPushCommonConfiguration();
            }
            return new Configuration(this.mApplication, this.mAppInfo, this.mDebug, this.mLogLevel, this.mProcess, this.mDefaultNotificationChannel, this.mPushLifeAdapters, this.mPushEventCallback, pushReceiveHandler, this.mHost, this.mFilter, this.mHMSLowVersionCallback, this.mKeyConfiguration, this.mExtraParams, this.mI18nCommonParams, this.mOnPushClickListener, this.mMonitor, this.mSoLoader, this.mFcmPayloadName, this.mIsPreInstallVersion, this.mAccountService, this.mOpenTracingMonitor, asyncSoundDownloaderWrapper, this.mNotificationSoundsRes, this.mResult, this.mAdmPayloadName, this);
        }

        void printConfigurationInformation() {
            Logger.m274i(EventConstants.PARAM_SOURCE_INIT, "debuggable = " + this.mDebug);
            if (this.mDebug) {
                AppInfo appInfo = this.mAppInfo;
                Logger.m268d(EventConstants.PARAM_SOURCE_INIT, appInfo == null ? "" : appInfo.toString());
                Logger.m268d(EventConstants.PARAM_SOURCE_INIT, "process:\t" + this.mProcess);
            }
        }

        void checkArgumentsValid() {
            checkValidAppInfo(this.mAppInfo);
            if (TextUtils.isEmpty(this.mHost)) {
                tryThrowInitException("please set none empty host in builder constructor");
            }
            if (!this.mIsBoe && !this.mHost.startsWith("https:")) {
                tryThrowInitException("please set https host in builder constructor");
            }
            if (this.mPushEventCallback == null) {
                tryThrowInitException("please implement the event callback");
            }
            if (this.mOnPushClickListener == null) {
                tryThrowInitException("click event listener is null, you'll not receive the event when user click notifications.Please implement it.");
            }
        }

        private void checkValidAppInfo(AppInfo appInfo) {
            if (appInfo == null) {
                tryThrowInitException("appinfo is null");
                return;
            }
            if (appInfo.getAid() <= 0) {
                tryThrowInitException(" aid {" + appInfo.getAid() + "} is invalid");
            }
            if (TextUtils.isEmpty(appInfo.getAppName())) {
                tryThrowInitException("appName {" + appInfo.getAppName() + "} is invalid");
            }
            if (TextUtils.isEmpty(appInfo.getVersionName())) {
                tryThrowInitException("versionName {" + appInfo.getVersionName() + "} is invalid");
            }
            if (appInfo.getVersionCode() <= 0) {
                tryThrowInitException("versionCode {" + appInfo.getVersionCode() + "} is invalid");
            }
            if (appInfo.getUpdateVersionCode() <= 0) {
                tryThrowInitException("updateVersionCode {" + appInfo.getUpdateVersionCode() + "} is invalid");
            }
            if (TextUtils.isEmpty(appInfo.getChannel())) {
                tryThrowInitException("channel {" + appInfo.getChannel() + "} is invalid");
            }
        }

        private void tryThrowInitException(String str) {
            tryThrowInitException(this.mDebug, str);
        }

        private void tryThrowInitException(boolean z, String str) {
            if (z) {
                throw new IllegalArgumentException(str);
            }
            Logger.m271e(EventConstants.PARAM_SOURCE_INIT, str);
        }

        public Builder withPushKeyConfiguration(KeyConfiguration keyConfiguration) {
            this.mKeyConfiguration = keyConfiguration;
            return this;
        }

        public Builder withNotificationSoundsRes(int[] iArr) {
            this.mNotificationSoundsRes = iArr;
            return this;
        }

        public Builder withI18nCommonParams(I18nCommonParams i18nCommonParams) {
            this.mI18nCommonParams = i18nCommonParams;
            return this;
        }

        public Builder withIsBoe(boolean z) {
            this.mIsBoe = z;
            return this;
        }

        public Builder enableALog(boolean z) {
            this.mEnableAlog = z;
            return this;
        }

        public Builder setPushAlogInstanceName(String str) {
            this.mPushAlogInstanceName = str;
            return this;
        }

        public Builder withEnableRealTimeReportEvent(boolean z) {
            this.mEnableRealTimeReportEvent = z;
            return this;
        }

        public Builder setAutoUpdateSettings(boolean z) {
            this.mAutoUpdateSettings = z;
            return this;
        }

        public Builder withIsThoughMsgEncrypt(boolean z) {
            this.mIsThroughMsgEncrypt = z;
            return this;
        }

        public Builder withAbProvider(AbProvider abProvider) {
            this.mAbProvider = abProvider;
            return this;
        }

        public Builder setClientDisplayFeature(ClientDisplayFeature clientDisplayFeature) {
            this.mClientDisplayFeature = clientDisplayFeature;
            return this;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Notification {

        /* renamed from: id */
        public String f83id;
        public String name;

        public Notification(String str, String str2) {
            this.name = str2;
            this.f83id = str;
        }

        public boolean isValid() {
            return (TextUtils.isEmpty(this.f83id) || TextUtils.isEmpty(this.name)) ? false : true;
        }
    }
}
