package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.bytedance.bdinstall.util.EventUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Builder {
    IAbContext abContext;
    Account account;
    IExtraParams activeExtraParam;
    int aid;
    String appLanguage;
    String appName;
    String appRegion;
    JSONObject appTrack;
    IAppTraitCallback appTraitCallback;
    boolean autoActive;
    String channel;
    Context context;
    ICustomExtraHeader customHeaders;
    Map<String, Object> customInfo;
    DeviceCategory deviceCategory;
    boolean encryptAndCompress;
    IEncryptor encryptor;
    IEventDepend eventDepend;
    String googleAid;
    boolean isAnonymous;
    boolean isDirectActive;
    boolean isLocalTest;
    boolean isOpenBpea;
    ILogger logger;
    long manifestVersionCode;
    TelephonyManager mgr;
    INetworkClient networkClient;
    IParamFilter paramFilter;
    PreInstallChannelCallback preInstallChannelCallback;
    String releaseBuild;
    DefaultSensitiveInterceptor sensitiveInterceptor;
    boolean silenceInBackground;
    String spFileName;
    ISstInfoProvider sstInfoProvider;
    boolean touristMode;
    String tweakedChannel;
    long updateVersionCode;
    String userAgent;
    String version;
    long versionCode;
    String versionMinor;
    String zijiePackage;
    boolean deleteSharedStorage = true;
    boolean needSharedStorage = false;
    boolean reportPhoneDetailInfo = true;
    boolean debuggable = false;
    boolean isMigrating = true;
    IAdIdConfig adidConfig = new IAdIdConfig.AdIdConfig();
    boolean enableOneKeyMigrateDetect = true;
    boolean enableListenNetChange = false;
    boolean checkPermissionBeforeCallSensitiveApi = false;
    boolean enableGetIPV6 = true;
    boolean isMainInstance = false;
    boolean enableLoadSN = true;
    public boolean enableNetCommOpt = false;

    @Deprecated
    public Builder setAntiCheatingEnable(boolean z) {
        return this;
    }

    public Builder() {
    }

    public Builder(Context context, int i, String str, boolean z) {
        this.context = context;
        this.aid = i;
        this.appName = str;
        this.autoActive = z;
    }

    public Builder setContext(Context context) {
        this.context = context;
        return this;
    }

    public Builder setAid(int i) {
        this.aid = i;
        return this;
    }

    public Builder setAppName(String str) {
        this.appName = str;
        return this;
    }

    public Builder setAutoActive(boolean z) {
        this.autoActive = z;
        return this;
    }

    public Builder setNetworkClient(INetworkClient iNetworkClient) {
        this.networkClient = iNetworkClient;
        return this;
    }

    public Builder setBDTrackerDepend(IEventDepend iEventDepend) {
        this.eventDepend = iEventDepend;
        return this;
    }

    public Builder setChannel(String str) {
        this.channel = str;
        return this;
    }

    public Builder setAnonymous(boolean z) {
        this.isAnonymous = z;
        return this;
    }

    public Builder setUpdateVersionName(String str) {
        this.versionMinor = str;
        return this;
    }

    public Builder setUpdateVersionCode(long j) {
        this.updateVersionCode = j;
        return this;
    }

    public Builder setReleaseBuild(String str) {
        this.releaseBuild = str;
        return this;
    }

    public Builder setAbContext(IAbContext iAbContext) {
        this.abContext = iAbContext;
        return this;
    }

    public Builder setDebug(boolean z) {
        this.debuggable = z;
        return this;
    }

    public Builder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public Builder setAccount(Account account) {
        this.account = account;
        return this;
    }

    public Builder setVersionName(String str) {
        this.version = str;
        return this;
    }

    public Builder setVersionCode(long j) {
        this.versionCode = j;
        return this;
    }

    public Builder setManifestVersionCode(long j) {
        this.manifestVersionCode = j;
        return this;
    }

    public Builder setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        this.preInstallChannelCallback = preInstallChannelCallback;
        return this;
    }

    public Builder isAb(boolean z) {
        this.isMigrating = z;
        return this;
    }

    @Deprecated
    public Builder setTweakedChannel(String str) {
        this.tweakedChannel = str;
        return this;
    }

    public Builder isMainProcess(boolean z) {
        Utils.setIsMainProcess(z);
        return this;
    }

    public Builder setAppLanguage(String str) {
        this.appLanguage = str;
        return this;
    }

    public Builder setAppRegion(String str) {
        this.appRegion = str;
        return this;
    }

    public Builder setAppTrack(JSONObject jSONObject) {
        this.appTrack = jSONObject;
        return this;
    }

    public Builder setSpFileName(String str) {
        this.spFileName = str;
        return this;
    }

    public Builder setZijiePackage(String str) {
        this.zijiePackage = str;
        return this;
    }

    public Builder setEncryptor(IEncryptor iEncryptor) {
        this.encryptor = iEncryptor;
        return this;
    }

    public Builder setGoogleAid(String str) {
        this.googleAid = str;
        return this;
    }

    public Builder setCustomInfo(Map<String, Object> map) {
        this.customInfo = map;
        return this;
    }

    public Builder setCustomHeaders(ICustomExtraHeader iCustomExtraHeader) {
        this.customHeaders = iCustomExtraHeader;
        return this;
    }

    public Builder setEncryptAndCompress(boolean z) {
        this.encryptAndCompress = z;
        return this;
    }

    public Builder setIsLocalTest(boolean z) {
        this.isLocalTest = z;
        return this;
    }

    public Builder setSilenceInBackground(boolean z) {
        this.silenceInBackground = z;
        return this;
    }

    public Builder setReportPhoneDetailInfo(boolean z) {
        this.reportPhoneDetailInfo = z;
        return this;
    }

    public Builder setDirectActive(boolean z) {
        this.isDirectActive = z;
        return this;
    }

    public Builder setLogger(ILogger iLogger) {
        this.logger = iLogger;
        return this;
    }

    public Builder setSSTInfoProvider(ISstInfoProvider iSstInfoProvider) {
        this.sstInfoProvider = iSstInfoProvider;
        return this;
    }

    public Builder setAppTraitCallback(IAppTraitCallback iAppTraitCallback) {
        this.appTraitCallback = iAppTraitCallback;
        return this;
    }

    public Builder setTouristMode(boolean z) {
        this.touristMode = z;
        return this;
    }

    public Builder needSharedStorage(boolean z) {
        this.needSharedStorage = z;
        return this;
    }

    public Builder needDeleteShardStorage(boolean z) {
        this.deleteSharedStorage = z;
        return this;
    }

    public Builder setParamFilter(IParamFilter iParamFilter) {
        this.paramFilter = iParamFilter;
        return this;
    }

    public Builder setAdIdConfig(IAdIdConfig iAdIdConfig) {
        if (iAdIdConfig != null) {
            this.adidConfig = iAdIdConfig;
        }
        return this;
    }

    public Builder setActiveExtraParam(IExtraParams iExtraParams) {
        this.activeExtraParam = iExtraParams;
        return this;
    }

    public Builder enableOneKeyMigrateDetect(boolean z) {
        this.enableOneKeyMigrateDetect = z;
        return this;
    }

    public Builder enableListenNetChange(boolean z) {
        this.enableListenNetChange = z;
        return this;
    }

    public Builder checkPermissionBeforeCallSensitiveApi(boolean z) {
        this.checkPermissionBeforeCallSensitiveApi = z;
        return this;
    }

    public Builder enableGetIPV6(boolean z) {
        this.enableGetIPV6 = z;
        return this;
    }

    public Builder setEnableLoadSN(boolean z) {
        this.enableLoadSN = z;
        return this;
    }

    public Builder setEnableNetCommOpt(boolean z) {
        this.enableNetCommOpt = z;
        return this;
    }

    public Builder setDeviceCategory(DeviceCategory deviceCategory) {
        this.deviceCategory = deviceCategory;
        return this;
    }

    public Builder setOpenBpea(boolean z) {
        this.isOpenBpea = z;
        return this;
    }

    public Builder setSensitiveInterceptor(DefaultSensitiveInterceptor defaultSensitiveInterceptor) {
        this.sensitiveInterceptor = defaultSensitiveInterceptor;
        return this;
    }

    public InstallOptions build() {
        if (this.context == null || this.aid <= 0 || TextUtils.isEmpty(this.channel)) {
            throw new IllegalArgumentException("parameters error:" + (this.context == null) + ", " + this.aid + ", " + this.channel);
        }
        if (TextUtils.isEmpty(this.appName)) {
            throw new IllegalArgumentException("appName is empty");
        }
        if (!DrLog.debug()) {
            if (this.networkClient == null) {
                throw new IllegalArgumentException("please set network client");
            }
            if (this.eventDepend == null) {
                throw new IllegalArgumentException("please set event depend");
            }
        }
        if (TextUtils.isEmpty(this.tweakedChannel)) {
            this.tweakedChannel = this.channel;
        }
        if (this.mgr == null) {
            this.mgr = (TelephonyManager) this.context.getSystemService("phone");
        }
        EventUtils.getInstance().setMonitors(this.aid);
        return new InstallOptions(this);
    }
}
