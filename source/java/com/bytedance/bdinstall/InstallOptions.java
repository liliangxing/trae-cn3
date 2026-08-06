package com.bytedance.bdinstall;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdinstall.IEncryptor;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.bdinstall.util.DeviceCategory;
import com.bytedance.bdinstall.util.LocalConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InstallOptions {
    private static final String DEFAULT_SP_NAME = "applog_stats";
    private final IAbContext abContext;
    private Account account;
    private final IExtraParams activeExtraParam;
    private final IAdIdConfig adidConfig;
    private final int aid;
    private final String appLanguage;
    private final String appName;
    private final String appRegion;
    private final JSONObject appTrack;
    private final IAppTraitCallback appTraitCallback;
    private final boolean autoActive;
    private final String channel;
    private final boolean checkPermissionBeforeCallSensitiveApi;
    private final Map<String, Object> commonHeaders;
    private final Context context;
    private final ICustomExtraHeader customHeaders;
    private final boolean debuggable;
    private final DefaultSensitiveInterceptor defaultSensitiveInterceptor;
    private final boolean deleteSharedStorage;
    private final DeviceCategory deviceCategory;
    private final boolean enableGetIPV6;
    private final boolean enableListenNetChange;
    private final boolean enableLoadSN;
    private final boolean enableNetCommOpt;
    private final boolean enableOneKeyMigrateDetect;
    private final boolean encryptAndCompress;
    private final IEncryptor encryptor;
    private final IEventDepend eventDepend;
    private final String googleAid;
    private final boolean isAnonymous;
    private final boolean isDirectActive;
    private final boolean isLocalTest;
    boolean isMainInstance;
    private final boolean isMigrating;
    private final ILogger logger;
    private final AppVersionCompat mAppVersionCompat;
    TelephonyManager mgr;
    private final boolean needSharedStorage;
    private final INetworkClient networkClient;
    private final IParamFilter paramFilter;
    private final PreInstallChannelCallback preInstallChannelCallback;
    private final String releaseBuild;
    private final boolean reportPhoneDetailInfo;
    private final DefaultSensitiveInterceptor sensitiveInterceptor;
    private final boolean silenceInBackground;

    /* renamed from: sp */
    private SharedPreferences f85sp = null;
    private final String spFileName;
    private final ISstInfoProvider sstInfoProvider;
    private final boolean touristMode;
    private final String tweakedChannel;
    private final String userAgent;
    private final String zijiePackage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstallOptions(Builder builder) {
        this.context = builder.context;
        this.aid = builder.aid;
        this.networkClient = builder.networkClient != null ? builder.networkClient : new DefaultClient();
        this.spFileName = TextUtils.isEmpty(builder.spFileName) ? "applog_stats" : builder.spFileName;
        this.zijiePackage = builder.zijiePackage;
        this.appName = builder.appName;
        this.channel = builder.channel;
        this.tweakedChannel = builder.tweakedChannel;
        this.releaseBuild = builder.releaseBuild;
        this.abContext = builder.abContext;
        this.userAgent = builder.userAgent;
        this.googleAid = builder.googleAid;
        this.appLanguage = builder.appLanguage;
        this.appRegion = builder.appRegion;
        this.appTrack = builder.appTrack;
        this.commonHeaders = builder.customInfo;
        this.customHeaders = builder.customHeaders;
        this.encryptAndCompress = builder.encryptAndCompress;
        this.isLocalTest = builder.isLocalTest;
        this.autoActive = builder.autoActive;
        this.silenceInBackground = builder.silenceInBackground;
        this.reportPhoneDetailInfo = builder.reportPhoneDetailInfo;
        this.eventDepend = builder.eventDepend;
        this.isAnonymous = builder.isAnonymous;
        this.preInstallChannelCallback = builder.preInstallChannelCallback;
        this.mAppVersionCompat = new AppVersionCompat(builder);
        this.account = builder.account;
        this.debuggable = builder.debuggable;
        this.logger = builder.logger;
        this.encryptor = builder.encryptor != null ? builder.encryptor : new IEncryptor.DefaultEncryptor();
        this.isMigrating = builder.isMigrating;
        this.sstInfoProvider = builder.sstInfoProvider;
        this.touristMode = builder.touristMode;
        this.appTraitCallback = builder.appTraitCallback;
        this.needSharedStorage = builder.needSharedStorage;
        this.deleteSharedStorage = builder.deleteSharedStorage;
        this.paramFilter = builder.paramFilter;
        this.adidConfig = builder.adidConfig;
        this.activeExtraParam = builder.activeExtraParam;
        this.enableOneKeyMigrateDetect = builder.enableOneKeyMigrateDetect;
        this.enableListenNetChange = builder.enableListenNetChange;
        this.checkPermissionBeforeCallSensitiveApi = builder.checkPermissionBeforeCallSensitiveApi;
        this.enableGetIPV6 = builder.enableGetIPV6;
        this.isDirectActive = builder.isDirectActive;
        this.enableLoadSN = builder.enableLoadSN;
        this.enableNetCommOpt = builder.enableNetCommOpt;
        this.deviceCategory = builder.deviceCategory;
        DefaultSensitiveInterceptor defaultSensitiveInterceptor = builder.sensitiveInterceptor;
        this.sensitiveInterceptor = defaultSensitiveInterceptor;
        this.mgr = builder.mgr;
        if (defaultSensitiveInterceptor != null) {
            this.defaultSensitiveInterceptor = defaultSensitiveInterceptor;
            defaultSensitiveInterceptor.setOptions(this);
        } else {
            DefaultSensitiveInterceptor defaultSensitiveInterceptor2 = new DefaultSensitiveInterceptor();
            this.defaultSensitiveInterceptor = defaultSensitiveInterceptor2;
            defaultSensitiveInterceptor2.setOptions(this);
        }
    }

    public int getAid() {
        return this.aid;
    }

    public String getAidString() {
        return String.valueOf(this.aid);
    }

    public INetworkClient getNetworkClient() {
        return this.networkClient;
    }

    public Context getContext() {
        return this.context;
    }

    public String getZijiePackage() {
        return this.zijiePackage;
    }

    public String getVersion() {
        return this.mAppVersionCompat.getVersion();
    }

    public String getVersionMinor() {
        return this.mAppVersionCompat.getVersionMinor();
    }

    public long getVersionCode() {
        return this.mAppVersionCompat.getVersionCode();
    }

    public long getUpdateVersionCode() {
        return this.mAppVersionCompat.getUpdateVersionCode();
    }

    public long getManifestVersionCode() {
        return this.mAppVersionCompat.getManifestVersionCode();
    }

    public String getAppName() {
        return this.appName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getTweakedChannel() {
        return this.tweakedChannel;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public IAbContext getAbContext() {
        return this.abContext;
    }

    public boolean isMainInstance() {
        return this.isMainInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setIsMainInstance(boolean z) {
        this.isMainInstance = z;
    }

    public String getUserAgent() {
        if (!TextUtils.isEmpty(this.userAgent)) {
            return this.userAgent;
        }
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_USER_AGENT, null);
    }

    public String getGoogleAid() {
        return this.googleAid;
    }

    public String getAppLanguage() {
        if (!TextUtils.isEmpty(this.appLanguage)) {
            return this.appLanguage;
        }
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppRegion() {
        if (!TextUtils.isEmpty(this.appRegion)) {
            return this.appRegion;
        }
        return LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_REGION, null);
    }

    public JSONObject getAppTrack() {
        JSONObject jSONObject = this.appTrack;
        if (jSONObject != null) {
            return jSONObject;
        }
        String string = LocalConstants.getCommonSp(this.context, this).getString(Api.KEY_APP_TRACK, null);
        if (string != null) {
            try {
                return new JSONObject(string);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public Map<String, Object> getCommonHeader() {
        return this.commonHeaders;
    }

    public String getAbVersion() {
        IAbContext iAbContext = this.abContext;
        if (iAbContext != null) {
            return iAbContext.getAbVersion();
        }
        return null;
    }

    public SharedPreferences getSp() {
        if (this.f85sp == null) {
            this.f85sp = this.context.getSharedPreferences(this.isMainInstance ? this.spFileName : this.spFileName + "_" + this.aid, 0);
        }
        return this.f85sp;
    }

    public String getAppLanguageFromSp() {
        return getSp().getString(Api.KEY_APP_LANGUAGE, null);
    }

    public String getAppRegionFromSp() {
        return getSp().getString(Api.KEY_APP_REGION, null);
    }

    public boolean isSilenceInBackground() {
        return this.silenceInBackground;
    }

    public boolean reportPhoneDetailInfo() {
        return this.reportPhoneDetailInfo;
    }

    public Map<String, Object> getCustomHeader() {
        ICustomExtraHeader iCustomExtraHeader = this.customHeaders;
        if (iCustomExtraHeader != null) {
            return iCustomExtraHeader.getExtraParams();
        }
        return null;
    }

    public boolean encryptAndCompress() {
        if (isDebuggable()) {
            return this.encryptAndCompress;
        }
        return true;
    }

    public boolean isLocalTest() {
        return this.isLocalTest;
    }

    public boolean isAutoActive() {
        return this.autoActive;
    }

    public IEventDepend getEventDepend() {
        return this.eventDepend;
    }

    public boolean isAnonymous() {
        return this.isAnonymous;
    }

    public PreInstallChannelCallback getPreInstallChannelCallback() {
        return this.preInstallChannelCallback;
    }

    public Account getAccount() {
        return this.account;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isDebuggable() {
        return this.debuggable;
    }

    public boolean isDirectActive() {
        return this.isDirectActive;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IEncryptor getEncryptor() {
        return this.encryptor;
    }

    public String getUserUniqueId(Context context) {
        String string = LocalConstants.getCommonSp(context, this).getString("user_unique_id", null);
        return TextUtils.isEmpty(string) ? context.getSharedPreferences("header_custom", 0).getString("user_unique_id", null) : string;
    }

    public void saveConfigAfterRegister(SharedPreferences.Editor editor) {
        String appLanguage = getAppLanguage();
        String appRegion = getAppRegion();
        if (!TextUtils.isEmpty(appLanguage)) {
            editor.putString(Api.KEY_APP_LANGUAGE, appLanguage);
        }
        if (TextUtils.isEmpty(appRegion)) {
            return;
        }
        editor.putString(Api.KEY_APP_REGION, appRegion);
    }

    public ISstInfoProvider getSstInfoProvider() {
        return this.sstInfoProvider;
    }

    public boolean isTouristMode() {
        return this.touristMode;
    }

    public IAppTraitCallback getAppTraitCallback() {
        return this.appTraitCallback;
    }

    public boolean isNeedSharedStorage() {
        return this.needSharedStorage;
    }

    public boolean deleteSharedStorage() {
        return this.deleteSharedStorage;
    }

    public IAdIdConfig getAdIdConfig() {
        return this.adidConfig;
    }

    public IParamFilter getParamFilter() {
        return this.paramFilter;
    }

    public IExtraParams getActiveParam() {
        return this.activeExtraParam;
    }

    public boolean enableOneKeyMigrateDetect() {
        return this.enableOneKeyMigrateDetect;
    }

    public boolean isEnableListenNetChange() {
        return this.enableListenNetChange;
    }

    public boolean isCheckPermissionBeforeCallSensitiveApi() {
        return this.checkPermissionBeforeCallSensitiveApi;
    }

    public boolean isEnableGetIPV6() {
        return this.enableGetIPV6;
    }

    public boolean isEnableLoadSN() {
        return this.enableLoadSN;
    }

    public boolean isEnableNetCommOpt() {
        return this.enableNetCommOpt;
    }

    public String getDeviceCategory() {
        DeviceCategory deviceCategory = this.deviceCategory;
        if (deviceCategory != null) {
            return deviceCategory.getLower();
        }
        return null;
    }

    public DefaultSensitiveInterceptor getSensitiveInterceptor() {
        return this.defaultSensitiveInterceptor;
    }

    public TelephonyManager getTelephonyManager() {
        return this.mgr;
    }
}
