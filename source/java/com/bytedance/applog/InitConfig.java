package com.bytedance.applog;

import android.accounts.Account;
import android.text.TextUtils;
import com.bytedance.applog.util.Utils;
import com.bytedance.bdinstall.IAbContext;
import com.bytedance.bdinstall.ILogger;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.PreInstallChannelCallback;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.bytedance.mpaas.IEncryptor;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InitConfig {
    private static final String DEFAULT_DB_NAME = "bd_tea_agent.db";
    private DefaultSensitiveInterceptor defaultSensitiveInterceptor;
    private DeviceCategory deviceCategory;
    private Account mAccount;
    private final String mAid;
    private boolean mAnonymous;
    private String mAppImei;
    private String mAppName;
    private volatile IAppTraitCallback mAppTraitCallback;
    private BDInstallInitHook mBDInstallInitHook;
    private String mChannel;
    private Map<String, Object> mCommonHeader;
    private String mDbName;
    private boolean mEnableListenNetChange;
    private boolean mEnablePlay;
    private IEncryptor mEncrytor;
    private boolean mEventFilterEnable;
    private String mLanguage;
    private ILogger mLogger;
    private String mManifestVersion;
    private long mManifestVersionCode;
    private PreInstallChannelCallback mPreInstallCallback;
    private String mRegion;
    private String mReleaseBuild;
    private ISstInfoProvider mSensitiveInfoProvider;
    private boolean mSilenceInBackground;
    private String mSpName;
    private boolean mTouristMode;
    private String mTweakedChannel;
    private long mUpdateVersionCode;
    private UriConfig mUriConfig;
    private String mVersion;
    private long mVersionCode;
    private String mVersionMinor;
    private INetworkClient mWrapperClient;
    private String mZiJieCloudPkg;
    private boolean mAutoStart = true;
    private boolean mLocalTest = false;
    private int mProcess = 0;
    private boolean mAutoActive = true;
    private boolean mAntiCheatingEnable = false;
    private boolean mHandleLifeCycle = false;
    private boolean mCongestionControlEnable = true;
    private boolean mMacEnable = true;
    private boolean mImeiEnable = true;
    private IpcDataChecker mIpcDataChecker = null;
    private IAbContext mAbContext = null;
    private boolean mLogEnable = false;
    private boolean flushOnEnterBackgroundEnabled = false;
    private boolean stopOnEnterBackgroundEnabled = false;
    private boolean enableNetCommOpt = false;
    private boolean mOneKeyMigrateDetectEnabled = true;
    private boolean mCollectIpv6Enabled = true;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public interface IpcDataChecker {
        boolean checkIpcData(String[] strArr);
    }

    @Deprecated
    public InitConfig setAliyunUdid(String str) {
        return this;
    }

    @Deprecated
    public InitConfig setGoogleAid(String str) {
        return this;
    }

    public InitConfig(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("App id must not be empty!");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalStateException("Channel must not be empty!");
        }
        this.mAid = str;
        this.mChannel = str2;
    }

    public InitConfig setLogger(ILogger iLogger) {
        this.mLogger = iLogger;
        return this;
    }

    public ILogger getLogger() {
        return this.mLogger;
    }

    public boolean autoStart() {
        return this.mAutoStart;
    }

    public InitConfig setAutoStart(boolean z) {
        this.mAutoStart = z;
        return this;
    }

    public InitConfig setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        this.mPreInstallCallback = preInstallChannelCallback;
        return this;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public InitConfig setReleaseBuild(String str) {
        this.mReleaseBuild = str;
        return this;
    }

    public String getReleaseBuild() {
        return this.mReleaseBuild;
    }

    public InitConfig putCommonHeader(Map<String, Object> map) {
        this.mCommonHeader = map;
        return this;
    }

    public Map<String, Object> getCommonHeader() {
        return this.mCommonHeader;
    }

    public InitConfig setEnablePlay(boolean z) {
        this.mEnablePlay = z;
        return this;
    }

    public boolean isPlayEnable() {
        return this.mEnablePlay;
    }

    public String getAid() {
        return this.mAid;
    }

    public String getChannel() {
        return this.mChannel;
    }

    public InitConfig setLanguage(String str) {
        this.mLanguage = str;
        return this;
    }

    public String getLanguage() {
        return this.mLanguage;
    }

    public InitConfig setRegion(String str) {
        this.mRegion = str;
        return this;
    }

    public String getRegion() {
        return this.mRegion;
    }

    public InitConfig setProcess(boolean z) {
        this.mProcess = z ? 1 : 2;
        return this;
    }

    public int getProcess() {
        return this.mProcess;
    }

    public void setNeedAntiCheating(boolean z) {
        this.mAntiCheatingEnable = z;
    }

    public boolean isAntiCheatingEnable() {
        return this.mAntiCheatingEnable;
    }

    public InitConfig setUriConfig(int i) {
        this.mUriConfig = UriConfig.createUriConfig(i);
        return this;
    }

    public InitConfig setUriConfig(UriConfig uriConfig) {
        this.mUriConfig = uriConfig;
        return this;
    }

    public UriConfig getUriConfig() {
        return this.mUriConfig;
    }

    public InitConfig setEncryptor(IEncryptor iEncryptor) {
        this.mEncrytor = iEncryptor;
        return this;
    }

    public IEncryptor getEncryptor() {
        return this.mEncrytor;
    }

    public InitConfig setAnonymous(boolean z) {
        this.mAnonymous = z;
        return this;
    }

    public boolean getAnonymous() {
        return this.mAnonymous;
    }

    public InitConfig setLocalTest(boolean z) {
        this.mLocalTest = z;
        return this;
    }

    public boolean getLocalTest() {
        return this.mLocalTest;
    }

    public InitConfig setAccount(Account account) {
        this.mAccount = account;
        return this;
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public InitConfig setNetworkClient(INetworkClient iNetworkClient) {
        this.mWrapperClient = iNetworkClient;
        return this;
    }

    public INetworkClient getNetworkClient() {
        return this.mWrapperClient;
    }

    public InitConfig setAppName(String str) {
        this.mAppName = str;
        return this;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public InitConfig setVersion(String str) {
        this.mVersion = str;
        return this;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public InitConfig setTweakedChannel(String str) {
        this.mTweakedChannel = str;
        return this;
    }

    public String getTweakedChannel() {
        return this.mTweakedChannel;
    }

    public InitConfig setTouristMode(boolean z) {
        this.mTouristMode = z;
        return this;
    }

    public boolean isTouristMode() {
        return this.mTouristMode;
    }

    public InitConfig setVersionCode(long j) {
        this.mVersionCode = j;
        return this;
    }

    public long getVersionCode() {
        return this.mVersionCode;
    }

    public InitConfig setUpdateVersionCode(long j) {
        this.mUpdateVersionCode = j;
        return this;
    }

    public long getUpdateVersionCode() {
        return this.mUpdateVersionCode;
    }

    public InitConfig setManifestVersionCode(long j) {
        this.mManifestVersionCode = j;
        return this;
    }

    public long getManifestVersionCode() {
        return this.mManifestVersionCode;
    }

    public InitConfig setManifestVersion(String str) {
        this.mManifestVersion = str;
        return this;
    }

    public String getManifestVersion() {
        return this.mManifestVersion;
    }

    public InitConfig setVersionMinor(String str) {
        this.mVersionMinor = str;
        return this;
    }

    public String getVersionMinor() {
        return this.mVersionMinor;
    }

    public InitConfig setZiJieCloudPkg(String str) {
        this.mZiJieCloudPkg = str;
        return this;
    }

    public String getZiJieCloudPkg() {
        return this.mZiJieCloudPkg;
    }

    public boolean isSilenceInBackground() {
        return this.mSilenceInBackground;
    }

    public void setSilenceInBackground(boolean z) {
        this.mSilenceInBackground = z;
    }

    public boolean isAutoActive() {
        return this.mAutoActive;
    }

    public void setAutoActive(boolean z) {
        this.mAutoActive = z;
    }

    public boolean isHandleLifeCycle() {
        return this.mHandleLifeCycle;
    }

    public void setHandleLifeCycle(boolean z) {
        this.mHandleLifeCycle = z;
    }

    public boolean isCongestionControlEnable() {
        return this.mCongestionControlEnable;
    }

    public void setCongestionControlEnable(boolean z) {
        this.mCongestionControlEnable = z;
    }

    public String getDbName() {
        if (TextUtils.isEmpty(this.mDbName)) {
            return Utils.toString(this.mAid) + "@bd_tea_agent.db";
        }
        return this.mDbName;
    }

    public InitConfig setDbName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mDbName = str;
        }
        return this;
    }

    public String getSpName() {
        return this.mSpName;
    }

    public InitConfig setSpName(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mSpName = str;
        }
        return this;
    }

    public InitConfig setAbContext(IAbContext iAbContext) {
        this.mAbContext = iAbContext;
        return this;
    }

    public IAbContext getAbContext() {
        return this.mAbContext;
    }

    public PreInstallChannelCallback getPreInstallCallback() {
        return this.mPreInstallCallback;
    }

    public ISstInfoProvider getSensitiveInfoProvider() {
        return this.mSensitiveInfoProvider;
    }

    public void setSensitiveInfoProvider(ISstInfoProvider iSstInfoProvider) {
        this.mSensitiveInfoProvider = iSstInfoProvider;
    }

    public boolean isMacEnable() {
        return this.mMacEnable;
    }

    public void setMacEnable(boolean z) {
        this.mMacEnable = z;
    }

    public boolean isImeiEnable() {
        return this.mImeiEnable;
    }

    public void setImeiEnable(boolean z) {
        this.mImeiEnable = z;
    }

    public String getAppImei() {
        return this.mAppImei;
    }

    public void setAppImei(String str) {
        this.mAppImei = str;
    }

    public boolean isEventFilterEnable() {
        return this.mEventFilterEnable;
    }

    public void setEventFilterEnable(boolean z) {
        this.mEventFilterEnable = z;
    }

    public InitConfig setIpcDataChecker(IpcDataChecker ipcDataChecker) {
        this.mIpcDataChecker = ipcDataChecker;
        return this;
    }

    public IpcDataChecker getIpcDataChecker() {
        return this.mIpcDataChecker;
    }

    public void setAppTraitCallback(IAppTraitCallback iAppTraitCallback) {
        this.mAppTraitCallback = iAppTraitCallback;
    }

    public IAppTraitCallback getAppTraitCallback() {
        return this.mAppTraitCallback;
    }

    public InitConfig setBDInstallInitHook(BDInstallInitHook bDInstallInitHook) {
        this.mBDInstallInitHook = bDInstallInitHook;
        return this;
    }

    public BDInstallInitHook getBDInstallInitHook() {
        return this.mBDInstallInitHook;
    }

    public boolean isEnableListenNetChange() {
        return this.mEnableListenNetChange;
    }

    public void setEnableListenNetChange(boolean z) {
        this.mEnableListenNetChange = z;
    }

    public InitConfig setLogEnable(boolean z) {
        this.mLogEnable = z;
        return this;
    }

    public boolean isLogEnable() {
        return this.mLogEnable;
    }

    public InitConfig setFlushOnEnterBackgroundEnabled(boolean z) {
        this.flushOnEnterBackgroundEnabled = z;
        return this;
    }

    public boolean isFlushOnEnterBackgroundEnabled() {
        return this.flushOnEnterBackgroundEnabled;
    }

    public InitConfig setStopOnEnterBackgroundEnabled(boolean z) {
        this.stopOnEnterBackgroundEnabled = z;
        return this;
    }

    public boolean isStopOnEnterBackgroundEnabled() {
        return this.stopOnEnterBackgroundEnabled;
    }

    public void setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
    }

    public DeviceCategory getDeviceCategory() {
        return this.deviceCategory;
    }

    public void setNetCommOptEnabled(boolean z) {
        this.enableNetCommOpt = z;
    }

    public boolean isNetCommOptEnabled() {
        return this.enableNetCommOpt;
    }

    public void setOneKeyMigrateDetectEnabled(boolean z) {
        this.mOneKeyMigrateDetectEnabled = z;
    }

    public boolean isOneKeyMigrateDetectEnabled() {
        return this.mOneKeyMigrateDetectEnabled;
    }

    public void setCollectIpv6Enabled(boolean z) {
        this.mCollectIpv6Enabled = z;
    }

    public boolean isCollectIpv6Enabled() {
        return this.mCollectIpv6Enabled;
    }

    public void setDefaultSensitiveInterceptor(DefaultSensitiveInterceptor defaultSensitiveInterceptor) {
        this.defaultSensitiveInterceptor = defaultSensitiveInterceptor;
    }

    public DefaultSensitiveInterceptor getDefaultSensitiveInterceptor() {
        return this.defaultSensitiveInterceptor;
    }
}
