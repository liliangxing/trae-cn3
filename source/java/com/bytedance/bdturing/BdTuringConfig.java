package com.bytedance.bdturing;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdturing.identityverify.IIdentityVerifyDepend;
import com.bytedance.bdturing.livedetect.IByteNNDepend;
import com.bytedance.bdturing.loginverify.ILoginVerifyDepend;
import com.bytedance.bdturing.senseless.ISecDepend;
import com.bytedance.bdturing.setting.ServiceInterceptor;
import com.bytedance.bdturing.theme.ThemeConfig;
import com.bytedance.bdturing.ttnet.HttpClient;
import com.bytedance.bdturing.twiceverify.TwiceVerifyDepend;
import com.bytedance.bdturing.uc_twiceverify.UCTwiceVerifyDepend;
import com.bytedance.bdturing.utils.Consts;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class BdTuringConfig {
    public static final int DEFAULT_EVENT_COUNT = 6000;
    private static final int MAX_LOCAL_PARAMS = 2;
    private static final int OS_TYPE = 0;
    private static final String TAG = "BdTuringConfig";
    private IBdTuringDepend bdTuringDepend;
    private EventClient eventClient;
    private HttpClient httpClient;
    private String mAppId;
    private AppInfoProvider mAppInfoProvider;
    private String mAppKey;
    private String mAppName;
    private IAppSateProvider mAppSateProvider;
    private String mAppVersion;
    private String mAppVersionCode;
    private boolean mBypassBdTuring;
    private IByteNNDepend mByteNNDepend;
    private int mChallengeCode;
    private String mChannel;
    private Context mContext;
    private JSONObject mDOWNSMSTheme;
    private String mDeviceBrand;
    private String mDeviceId;
    private String mDeviceModel;
    private JSONObject mECAFTheme;
    private JSONObject mEMAILTheme;
    private int mEmailDigits;
    private boolean mEnableTTNetProcessor;
    private boolean mFullScreen;
    private JSONObject mIDENTIFYTheme;
    private JSONObject mIMGTheme;
    private JSONObject mINFOVERIFYTheme;
    private IIdentityVerifyDepend mIdentityVerifyDepend;
    private boolean mInjectHeader;
    private String mInstallId;
    private String mLanguage;
    private boolean mLiveDebugMode;
    private String mLocale;
    private ILoginVerifyDepend mLoginVerifyDepend;
    private boolean mMaskCancel;
    private String mOpenUdid;
    private String mOsName;
    private String mOsVersion;
    private JSONObject mPASSWORDTheme;
    private JSONObject mQATheme;
    private RegionType mRegionType;
    private String mRiskInfo;
    private JSONObject mSMARTERTheme;
    private JSONObject mSMSTheme;
    private JSONObject mSMSVOICETheme;
    private String mScene;
    private String mSdkVersion;
    private ISecDepend mSecDepend;
    private ServiceInterceptor mServiceInterceptor;
    private String mSessionId;
    private boolean mShowToastSuccess;
    private int mSmsDigits;
    private ThemeConfig mThemeConfig;
    private ConcurrentHashMap<Integer, JSONObject> mThemeMap;
    private JSONObject mUPSMSTheme;
    private UCTwiceVerifyDepend mUcTwiceVerifyDepend;
    private JSONObject mVOICETheme;
    private HashMap<Integer, Pair<String, String>> testConfig;
    private String ticket;
    private TwiceVerifyDepend twiceVerifyDepend;

    @Deprecated
    public int getOsType() {
        return 0;
    }

    public boolean isLiveDebugMode() {
        return this.mLiveDebugMode;
    }

    public void setLiveDebugMode(boolean z) {
        this.mLiveDebugMode = z;
    }

    public IByteNNDepend getByteNNDepend() {
        return this.mByteNNDepend;
    }

    public void setByteNNDepend(IByteNNDepend iByteNNDepend) {
        this.mByteNNDepend = iByteNNDepend;
    }

    public ILoginVerifyDepend getLoginVerifyDepend() {
        return this.mLoginVerifyDepend;
    }

    public void setLoginVerifyDepend(ILoginVerifyDepend iLoginVerifyDepend) {
        this.mLoginVerifyDepend = iLoginVerifyDepend;
    }

    public UCTwiceVerifyDepend getUcTwiceVerifyDepend() {
        return this.mUcTwiceVerifyDepend;
    }

    public int getSmsDigits() {
        return this.mSmsDigits;
    }

    public BdTuringConfig setSmsDigits(int i) {
        this.mSmsDigits = i;
        return this;
    }

    public int getEmailDigits() {
        return this.mEmailDigits;
    }

    public BdTuringConfig setEmailDigits(int i) {
        this.mEmailDigits = i;
        return this;
    }

    public String toString() {
        return "BdTuringConfig{mRegionType=" + this.mRegionType + ", mAppId='" + this.mAppId + "', mLanguage='" + this.mLanguage + "', mAppName='" + this.mAppName + "', mChannel='" + this.mChannel + "', mSdkVersion='" + this.mSdkVersion + "', mAppKey='" + this.mAppKey + "', mInstallId='" + this.mInstallId + "', mAppVersion='" + this.mAppVersion + "', mAppVersionCode='" + this.mAppVersionCode + "', mOsName='" + this.mOsName + "', mOsVersion='" + this.mOsVersion + "', mDeviceId='" + this.mDeviceId + "', mDeviceBrand='" + this.mDeviceBrand + "', mDeviceModel='" + this.mDeviceModel + "', mContext=" + this.mContext + ", testConfig=" + this.testConfig + ", mLocale='" + this.mLocale + "', mMaskCancel=" + this.mMaskCancel + ", mQATheme=" + this.mQATheme + ", mSMSTheme=" + this.mSMSTheme + ", mIMGTheme=" + this.mIMGTheme + ", mIDENTIFYTheme=" + this.mIDENTIFYTheme + ", mSMARTERTheme=" + this.mSMARTERTheme + ", mUPSMSTheme=" + this.mUPSMSTheme + ", mDOWNSMSTheme=" + this.mDOWNSMSTheme + ", mPASSWORDTheme=" + this.mPASSWORDTheme + ", mECAFTheme=" + this.mECAFTheme + ", mINFOVERIFYTheme=" + this.mINFOVERIFYTheme + ", mEMAILTheme=" + this.mEMAILTheme + ", mVOICETheme=" + this.mVOICETheme + ", mSMSVOICETheme=" + this.mSMSVOICETheme + ", eventClient=" + this.eventClient + ", httpClient=" + this.httpClient + ", twiceVerifyDepend=" + this.twiceVerifyDepend + ", mInjectHeader=" + this.mInjectHeader + ", mSmsDigits=" + this.mSmsDigits + ", mEmailDigits=" + this.mEmailDigits + ", mThemeMap=" + this.mThemeMap + ", ticket='" + this.ticket + "', mRiskInfo='" + this.mRiskInfo + "', mFullScreen=" + this.mFullScreen + ", mChallengeCode=" + this.mChallengeCode + ", mScene='" + this.mScene + "', mShowToastSuccess=" + this.mShowToastSuccess + ", mSessionId='" + this.mSessionId + "', mOpenUdid='" + this.mOpenUdid + "', bdTuringDepend=" + this.bdTuringDepend + ", mServiceInterceptor=" + this.mServiceInterceptor + ", mEnableTTNetProcessor=" + this.mEnableTTNetProcessor + ", mBypassBdTuring=" + this.mBypassBdTuring + ", mAppInfoProvider=" + this.mAppInfoProvider + ", mThemeConfig=" + this.mThemeConfig + ", mIdentityVerifyDepend=" + this.mIdentityVerifyDepend + ", mLoginVerifyDepend=" + this.mLoginVerifyDepend + ", mAppSateProvider=" + this.mAppSateProvider + ", mLiveDebugMode=" + this.mLiveDebugMode + ", mUcTwiceVerifyDepend=" + this.mUcTwiceVerifyDepend + '}';
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum RegionType {
        REGION_CN("cn"),
        REGION_SINGAPOER("sg"),
        REGION_USA_EAST("va"),
        REGION_INDIA("in"),
        REGION_BOE("boe");

        private String mName;

        RegionType(String str) {
            this.mName = str;
        }

        public String getName() {
            return this.mName;
        }
    }

    private BdTuringConfig(Builder builder) {
        String str;
        String[] split;
        this.mSdkVersion = "4.1.1.cn";
        this.mAppVersionCode = "";
        this.mOsName = Consts.OS_NAME;
        this.mOsVersion = "" + Build.VERSION.SDK_INT;
        this.mDeviceBrand = Build.BRAND;
        this.mDeviceModel = Build.MODEL;
        this.testConfig = new HashMap<>();
        this.mQATheme = null;
        this.mSMSTheme = null;
        this.mIMGTheme = null;
        this.mIDENTIFYTheme = null;
        this.mSMARTERTheme = null;
        this.mUPSMSTheme = null;
        this.mDOWNSMSTheme = null;
        this.mPASSWORDTheme = null;
        this.mECAFTheme = null;
        this.mINFOVERIFYTheme = null;
        this.mEMAILTheme = null;
        this.mVOICETheme = null;
        this.mSMSVOICETheme = null;
        this.mThemeMap = new ConcurrentHashMap<>();
        this.ticket = null;
        this.mRiskInfo = null;
        this.mFullScreen = true;
        this.mScene = null;
        this.mShowToastSuccess = false;
        this.mRegionType = builder.mRegionType;
        this.mAppId = builder.mAppId;
        this.mLanguage = builder.mLanguage;
        this.mAppName = builder.mAppName;
        this.mChannel = builder.mChannel;
        this.mAppKey = builder.mAppKey;
        this.mAppVersion = builder.mAppVersion;
        this.mAppVersionCode = builder.mAppVersionCode;
        this.mLocale = TextUtils.isEmpty(builder.mLocale) ? Locale.getDefault().toString() : builder.mLocale;
        this.eventClient = builder.eventClient;
        this.httpClient = builder.httpClient;
        this.twiceVerifyDepend = builder.twiceVerifyDepend;
        this.mSmsDigits = builder.mSmsDigits;
        this.mEmailDigits = builder.mEmailDigits;
        this.bdTuringDepend = builder.bdTuringDepend;
        if (TextUtils.isEmpty(builder.mLocale) && (str = this.mLocale) != null && (split = str.split("_")) != null && split.length > 2) {
            this.mLocale = split[0] + "_" + split[1];
        }
        try {
            this.mDeviceBrand = URLEncoder.encode(Build.BRAND, "utf-8");
            this.mDeviceModel = URLEncoder.encode(Build.MODEL, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        this.mInstallId = builder.mInstallId;
        this.mDeviceId = builder.mDeviceId;
        this.mSessionId = builder.mSessionId;
        this.mOpenUdid = builder.mOpenDid;
        this.mContext = builder.mContext;
        this.mMaskCancel = builder.mMaskCancel;
        this.mInjectHeader = builder.mInjectHeader;
        this.mServiceInterceptor = builder.mServiceInterceptor;
        this.mEnableTTNetProcessor = builder.mEnableTTNetProcessor;
        this.mBypassBdTuring = builder.mBypassBdTuring;
        this.mAppInfoProvider = builder.mAppInfoProvider;
        this.mIdentityVerifyDepend = builder.mIdentityVerifyDepend;
        this.mLoginVerifyDepend = builder.mLoginVerifyDepend;
        this.mUcTwiceVerifyDepend = builder.mUCTwiceVerifyDepend;
        this.mAppSateProvider = builder.mAppSateProvider;
        this.mSecDepend = builder.mSecDepend;
        this.mByteNNDepend = builder.mByteNNDepend;
    }

    public IAppSateProvider getAppSateProvider() {
        return this.mAppSateProvider;
    }

    public void setAppSateProvider(IAppSateProvider iAppSateProvider) {
        this.mAppSateProvider = iAppSateProvider;
    }

    public RegionType getRegionType() {
        return this.mRegionType;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getAppVersionCode() {
        return !TextUtils.isEmpty(this.mAppVersionCode) ? this.mAppVersionCode : "";
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    @Deprecated
    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public String getAppKey() {
        return this.mAppKey;
    }

    public String getChannel() {
        return this.mChannel;
    }

    @Deprecated
    public String getDeviceBrand() {
        return this.mDeviceBrand;
    }

    @Deprecated
    public String getDeviceModel() {
        return this.mDeviceModel;
    }

    @Deprecated
    public String getOsVersion() {
        return this.mOsVersion;
    }

    @Deprecated
    public String getOsName() {
        return this.mOsName;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public Activity getTopActivity() {
        IBdTuringDepend iBdTuringDepend = this.bdTuringDepend;
        Activity activity = iBdTuringDepend != null ? iBdTuringDepend.getActivity() : null;
        return activity == null ? getTopActivityBlock() : activity;
    }

    public boolean privacyPolicyAgree() {
        IAppSateProvider iAppSateProvider = this.mAppSateProvider;
        if (iAppSateProvider != null) {
            return iAppSateProvider.privacyPolicyAgree();
        }
        return false;
    }

    public IBdTuringDepend getBdTuringDepend() {
        return this.bdTuringDepend;
    }

    public Activity getTopActivityBlock() {
        return TuringLifeCycleListener.getInstance().getTopActivity();
    }

    public Pair<String, String> getTestConfig(int i) {
        return this.testConfig.get(Integer.valueOf(i));
    }

    public String getInstallId() {
        String str = this.mInstallId;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppInfoProvider appInfoProvider = this.mAppInfoProvider;
        return appInfoProvider != null ? appInfoProvider.getInstallId() : "";
    }

    public String getDeviceId() {
        String str = this.mDeviceId;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppInfoProvider appInfoProvider = this.mAppInfoProvider;
        return appInfoProvider != null ? appInfoProvider.getDeviceId() : "";
    }

    public String getSessionId() {
        String str = this.mSessionId;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppInfoProvider appInfoProvider = this.mAppInfoProvider;
        return appInfoProvider != null ? appInfoProvider.getSessionId() : "";
    }

    public String getOpenUdid() {
        String str = this.mOpenUdid;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        AppInfoProvider appInfoProvider = this.mAppInfoProvider;
        return appInfoProvider != null ? appInfoProvider.getOpenUDid() : "";
    }

    public String getLocale() {
        String str = this.mLocale;
        try {
            if (TextUtils.isEmpty(str)) {
                str = Locale.getDefault().toString();
            }
            if (str == null) {
                return "";
            }
        } catch (Exception unused) {
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    public boolean getInjectHeader() {
        return this.mInjectHeader;
    }

    @Deprecated
    public boolean getMaskCancel() {
        return this.mMaskCancel;
    }

    public JSONObject getTheme(int i) {
        return this.mThemeMap.get(Integer.valueOf(i));
    }

    public EventClient getEventClient() {
        return this.eventClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    @Deprecated
    public int getChallengeCode() {
        return this.mChallengeCode;
    }

    @Deprecated
    public String getScene() {
        return this.mScene;
    }

    @Deprecated
    public boolean getShowToastSuccess() {
        return this.mShowToastSuccess;
    }

    @Deprecated
    public String getRiskInfo() {
        return this.mRiskInfo;
    }

    @Deprecated
    public boolean getFullScreen() {
        return this.mFullScreen;
    }

    @Deprecated
    public String getTicket() {
        return this.ticket;
    }

    public TwiceVerifyDepend getTwiceVerifyDepend() {
        return this.twiceVerifyDepend;
    }

    public BdTuringConfig setInstallId(String str) {
        this.mInstallId = str;
        return this;
    }

    public BdTuringConfig setTestConfig(int i, String str, String str2) {
        this.testConfig.put(Integer.valueOf(i), new Pair<>(str, str2));
        return this;
    }

    public BdTuringConfig removeTestConfig(int i) {
        this.testConfig.remove(Integer.valueOf(i));
        return this;
    }

    public BdTuringConfig setDeviceId(String str) {
        this.mDeviceId = str;
        return this;
    }

    public BdTuringConfig setSessionId(String str) {
        this.mSessionId = str;
        return this;
    }

    public BdTuringConfig setOpenUdid(String str) {
        this.mOpenUdid = str;
        return this;
    }

    @Deprecated
    public BdTuringConfig setMaskCancel(boolean z) {
        this.mMaskCancel = z;
        return this;
    }

    public BdTuringConfig setAppId(String str) {
        this.mAppId = str;
        return this;
    }

    @Deprecated
    public BdTuringConfig setChallengeCode(int i) {
        this.mChallengeCode = i;
        return this;
    }

    @Deprecated
    public BdTuringConfig setScene(String str) {
        this.mScene = str;
        return this;
    }

    @Deprecated
    public BdTuringConfig setShowToastSuccess(boolean z) {
        this.mShowToastSuccess = z;
        return this;
    }

    @Deprecated
    public BdTuringConfig setTicket(String str) {
        this.ticket = str;
        return this;
    }

    @Deprecated
    public BdTuringConfig setFullScreen(boolean z) {
        this.mFullScreen = z;
        return this;
    }

    @Deprecated
    public BdTuringConfig setRiskInfo(String str) {
        this.mRiskInfo = str;
        return this;
    }

    public ISecDepend getSecDepend() {
        return this.mSecDepend;
    }

    public void setSecDepend(ISecDepend iSecDepend) {
        this.mSecDepend = iSecDepend;
    }

    public BdTuringConfig setTheme(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return this;
        }
        try {
            this.mThemeMap.put(Integer.valueOf(i), jSONObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public BdTuringConfig setLanguage(String str) {
        this.mLanguage = str;
        return this;
    }

    public BdTuringConfig setLocale(String str) {
        this.mLocale = str;
        return this;
    }

    public BdTuringConfig setRegionType(RegionType regionType) {
        this.mRegionType = regionType;
        return this;
    }

    public BdTuringConfig setIBdturingDepend(IBdTuringDepend iBdTuringDepend) {
        this.bdTuringDepend = iBdTuringDepend;
        return this;
    }

    public BdTuringConfig setServiceInterceptor(ServiceInterceptor serviceInterceptor) {
        this.mServiceInterceptor = serviceInterceptor;
        return this;
    }

    public ServiceInterceptor getServiceInterceptor() {
        return this.mServiceInterceptor;
    }

    public boolean isTTNetProcessorEnable() {
        return this.mEnableTTNetProcessor;
    }

    public void enableTTNetProcessor(boolean z) {
        this.mEnableTTNetProcessor = z;
    }

    public boolean isBypassBdTuring() {
        return this.mBypassBdTuring;
    }

    public BdTuringConfig setBypassBdTuring(boolean z) {
        this.mBypassBdTuring = z;
        return this;
    }

    public BdTuringConfig setAppInfoProvider(AppInfoProvider appInfoProvider) {
        this.mAppInfoProvider = appInfoProvider;
        return this;
    }

    public ThemeConfig getThemeConfig() {
        return this.mThemeConfig;
    }

    public void setThemeConfig(ThemeConfig themeConfig) {
        this.mThemeConfig = themeConfig;
    }

    public AppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public IIdentityVerifyDepend getIdentityVerifyDepend() {
        if (this.mIdentityVerifyDepend == null) {
            try {
                this.mIdentityVerifyDepend = (IIdentityVerifyDepend) Class.forName("com.bytedance.bdturing.identity_verify_adapter.DefaultIdentityVerifyDepend").newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.mIdentityVerifyDepend;
    }

    public void setIdentityVerifyDepend(IIdentityVerifyDepend iIdentityVerifyDepend) {
        this.mIdentityVerifyDepend = iIdentityVerifyDepend;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class Builder {
        private IBdTuringDepend bdTuringDepend;
        private EventClient eventClient;
        private HttpClient httpClient;
        private String mAppId;
        private AppInfoProvider mAppInfoProvider;
        private String mAppName;
        private IAppSateProvider mAppSateProvider;
        private String mAppVersion;
        private IByteNNDepend mByteNNDepend;
        private String mChannel;
        private Context mContext;
        private String mDeviceId;
        private IIdentityVerifyDepend mIdentityVerifyDepend;
        private String mInstallId;
        private String mLanguage;
        private String mLocale;
        private ILoginVerifyDepend mLoginVerifyDepend;
        private String mOpenDid;
        private ISecDepend mSecDepend;
        private ServiceInterceptor mServiceInterceptor;
        private String mSessionId;
        private UCTwiceVerifyDepend mUCTwiceVerifyDepend;
        private String mUserId;
        private TwiceVerifyDepend twiceVerifyDepend;
        private RegionType mRegionType = RegionType.REGION_CN;
        private String mAppKey = "";
        private String mAppVersionCode = "";
        private boolean mMaskCancel = true;
        private boolean mInjectHeader = true;
        private boolean mEnableTTNetProcessor = true;
        private boolean mBypassBdTuring = false;
        private int mEmailDigits = 6;
        private int mSmsDigits = 4;

        public BdTuringConfig build(Context context) {
            this.mContext = context;
            return new BdTuringConfig(this);
        }

        private void initContextHolder(Context context) {
            TuringLifeCycleListener.getInstance().init(context);
        }

        private Application getApplicationByContext(Context context) {
            if (context != null) {
                if (context instanceof Application) {
                    return (Application) context;
                }
                if (context instanceof Activity) {
                    return ((Activity) context).getApplication();
                }
                if (context instanceof ContextWrapper) {
                    return getApplicationByContext(((ContextWrapper) context).getBaseContext());
                }
            }
            return null;
        }

        public Builder appId(String str) {
            this.mAppId = str;
            return this;
        }

        public Builder appName(String str) {
            this.mAppName = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.mAppVersion = str;
            return this;
        }

        public Builder appVersionCode(String str) {
            this.mAppVersionCode = str;
            return this;
        }

        public Builder language(String str) {
            this.mLanguage = str;
            return this;
        }

        public Builder locale(String str) {
            this.mLocale = str;
            return this;
        }

        public Builder channel(String str) {
            this.mChannel = str;
            return this;
        }

        public Builder regionType(RegionType regionType) {
            this.mRegionType = regionType;
            return this;
        }

        public Builder appKey(String str) {
            this.mAppKey = str;
            return this;
        }

        public Builder installId(String str) {
            this.mInstallId = str;
            return this;
        }

        public Builder deviceId(String str) {
            this.mDeviceId = str;
            return this;
        }

        public Builder userId(String str) {
            this.mUserId = str;
            return this;
        }

        public Builder sessionId(String str) {
            this.mSessionId = str;
            return this;
        }

        public Builder openDid(String str) {
            this.mOpenDid = str;
            return this;
        }

        public Builder maskCancel(boolean z) {
            this.mMaskCancel = z;
            return this;
        }

        public Builder injectHeader(boolean z) {
            this.mInjectHeader = z;
            return this;
        }

        public Builder eventClient(EventClient eventClient) {
            this.eventClient = eventClient;
            return this;
        }

        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder twiceVerifyDepend(TwiceVerifyDepend twiceVerifyDepend) {
            this.twiceVerifyDepend = twiceVerifyDepend;
            return this;
        }

        public Builder bdTuringDepend(IBdTuringDepend iBdTuringDepend) {
            this.bdTuringDepend = iBdTuringDepend;
            return this;
        }

        public Builder enableTTNetProcessor(boolean z) {
            this.mEnableTTNetProcessor = z;
            return this;
        }

        public Builder serviceInterceptor(ServiceInterceptor serviceInterceptor) {
            this.mServiceInterceptor = serviceInterceptor;
            return this;
        }

        public Builder byPassBdTuring(boolean z) {
            this.mBypassBdTuring = z;
            return this;
        }

        public Builder appInfoProvider(AppInfoProvider appInfoProvider) {
            this.mAppInfoProvider = appInfoProvider;
            return this;
        }

        public Builder identityVerifyDepend(IIdentityVerifyDepend iIdentityVerifyDepend) {
            this.mIdentityVerifyDepend = iIdentityVerifyDepend;
            return this;
        }

        public Builder smsDigits(int i) {
            this.mSmsDigits = i;
            return this;
        }

        public Builder emailDigits(int i) {
            this.mEmailDigits = i;
            return this;
        }

        public Builder loginVerifyDepend(ILoginVerifyDepend iLoginVerifyDepend) {
            this.mLoginVerifyDepend = iLoginVerifyDepend;
            return this;
        }

        public Builder ucTwiceVerifyDepend(UCTwiceVerifyDepend uCTwiceVerifyDepend) {
            this.mUCTwiceVerifyDepend = uCTwiceVerifyDepend;
            return this;
        }

        public Builder appStateProvider(IAppSateProvider iAppSateProvider) {
            this.mAppSateProvider = iAppSateProvider;
            return this;
        }

        public Builder secDepend(ISecDepend iSecDepend) {
            this.mSecDepend = iSecDepend;
            return this;
        }

        public Builder byteNNDepend(IByteNNDepend iByteNNDepend) {
            this.mByteNNDepend = iByteNNDepend;
            return this;
        }
    }
}
