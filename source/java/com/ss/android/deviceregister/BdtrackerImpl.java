package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.IDataObserver;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.InstallInfo;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.ss.android.common.AppContext;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import com.ss.android.deviceregister.utils.Cdid;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class BdtrackerImpl implements InstallApi {
    private static final String KEY_APP_VERSION = "app_version";
    private static final String TAG = "BdWrapperImpl";
    private static volatile boolean mIsBoe;
    private static volatile String sActiveUrl;
    private static volatile boolean sAnonymous;
    private static volatile boolean sNeedAntiCheating;
    private static volatile PreInstallChannelCallback sPreInstallChannelCallback;
    private static volatile String[] sRegisterUrls;
    private static volatile String sReleaseBuild;
    private volatile AppContext mAppContext;
    private volatile int mAppId;
    private volatile String mChannel;
    private volatile String mCustomVersion;
    private volatile String mFakePackage;
    private volatile boolean mIsLocalTest = false;

    @Override // com.ss.android.deviceregister.InstallApi
    public void activeUser(Context context, String str, String str2) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addCustomerHeaser(Bundle bundle) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void clearDidAndIid(Context context, String str) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void filterHeader(JSONObject jSONObject) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getUserAgent(Context context) {
        return null;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void init(Context context, boolean z, boolean z2, boolean z3) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onCreate(Context context) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onPause(Context context) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onResume(Context context) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean reportPhoneDetailInfo() {
        return true;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void saveAppTrack(Context context, JSONObject jSONObject) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppVersionMinor(String str) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setChildModeBeforeInit(boolean z) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setCustomMonitor(ICustomMonitor iCustomMonitor) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceCategory(DeviceCategory deviceCategory) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setEnableMigrate(boolean z) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setForbidReportPhoneDetailInfo(boolean z) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setILogDepend(ILogDepend iLogDepend) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setInitWithActivity(boolean z) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setSDKVersion(String str) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void tryUpdateDeviceId() {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void updateDeviceInfo() {
    }

    public static void setIsBoe(boolean z) {
        mIsBoe = z;
    }

    public static boolean getIsBoe() {
        return mIsBoe;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppContext(final AppContext appContext) {
        this.mAppContext = appContext;
        BDInstall.setAppContext(new com.bytedance.bdinstall.AppContext() { // from class: com.ss.android.deviceregister.BdtrackerImpl.1
            public boolean isMainInstance() {
                return true;
            }

            public Context getContext() {
                return appContext.getContext();
            }

            public String getAppName() {
                return appContext.getAppName();
            }

            public String getVersion() {
                return appContext.getVersion();
            }

            public String getChannel() {
                return appContext.getChannel();
            }

            public String getTweakedChannel() {
                return appContext.getTweakedChannel();
            }

            public long getVersionCode() {
                return appContext.getVersionCode();
            }

            public long getUpdateVersionCode() {
                return appContext.getUpdateVersionCode();
            }

            public long getManifestVersionCode() {
                return appContext.getManifestVersionCode();
            }

            public int getAid() {
                return appContext.getAid();
            }

            public String getAbVersion() {
                return appContext.getAbVersion();
            }

            public String getAbClient() {
                return appContext.getAbClient();
            }

            public String getAbGroup() {
                return appContext.getAbGroup();
            }

            public String getAbFeature() {
                return appContext.getAbFeature();
            }

            public long getAbFlag() {
                return appContext.getAbFlag();
            }
        });
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAntiCheatingSwitch(boolean z) {
        sNeedAntiCheating = z;
    }

    public static boolean getAntiCheatingSwitch() {
        return sNeedAntiCheating;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceRegisterURL(String[] strArr, String str) {
        sRegisterUrls = strArr;
        sActiveUrl = str;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceRegisterURL(String[] strArr, String[] strArr2) {
        sRegisterUrls = strArr;
        sActiveUrl = strArr2[0];
    }

    public static String[] getRegisterUrls() {
        return sRegisterUrls;
    }

    public static String getActiveUrl() {
        return sActiveUrl;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAccount(Context context, Account account) {
        if (AppLog.hasStarted()) {
            AppLog.setAccount(account);
        } else {
            TLog.m81w("BdWrapperImpl setAccount should be called after init!");
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppId(int i) {
        this.mAppId = i;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getChannel(Context context) {
        String str = this.mChannel;
        if (TextUtils.isEmpty(str) && this.mAppContext != null) {
            str = this.mAppContext.getTweakedChannel();
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            str = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("UMENG_CHANNEL");
            this.mChannel = str;
            return str;
        } catch (Throwable th) {
            TLog.m82w("BdWrapperImpl getChannel", th);
            return str;
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setChannel(String str) {
        this.mChannel = str;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        sPreInstallChannelCallback = preInstallChannelCallback;
    }

    public static PreInstallChannelCallback getPreInstallChannelCallback() {
        return sPreInstallChannelCallback;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getInstallId() {
        return AppLog.getIid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getDeviceId() {
        String did = AppLog.getDid();
        return !TextUtils.isEmpty(did) ? did : "";
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getOpenUdId() {
        return AppLog.getOpenUdid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getClientUDID() {
        return AppLog.getClientUdid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getRequestId() {
        return RequestIdGenerator.getRequestId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void tryWaitDeviceIdInit(Context context) {
        try {
            BDInstall.waitingForInstallFinishWithOldWay();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setLocalTest(boolean z) {
        this.mIsLocalTest = z;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isLocalTest() {
        return this.mIsLocalTest;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAnonymous(boolean z) {
        sAnonymous = z;
    }

    public static boolean getAnonymous() {
        return sAnonymous;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUserMode(Context context) {
        return AppLog.isNewUserMode(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setNewUserMode(Context context, boolean z) {
        AppLog.setNewUserMode(context, z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addOnDeviceConfigUpdateListener(final DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener) {
        if (onDeviceConfigUpdateListener == null) {
            return;
        }
        AppLog.addDataObserver(new IDataObserver() { // from class: com.ss.android.deviceregister.BdtrackerImpl.2
            public void onAbVidsChange(String str, String str2) {
            }

            public void onRemoteAbConfigGet(boolean z, JSONObject jSONObject) {
            }

            public void onRemoteConfigGet(boolean z, JSONObject jSONObject) {
            }

            public void onIdLoaded(String str, String str2, String str3) {
                onDeviceConfigUpdateListener.onDidLoadLocally(!TextUtils.isEmpty(str));
            }

            public void onRemoteIdGet(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
                onDeviceConfigUpdateListener.onDeviceRegistrationInfoChanged(str2, str4);
                onDeviceConfigUpdateListener.onRemoteConfigUpdate(!TextUtils.isEmpty(str2), TextUtils.isEmpty(str));
            }
        });
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void getSSIDs(Map<String, String> map, Context context) {
        if (map != null) {
            AppLog.getSsidGroup(map);
            String userID = AppLog.getUserID();
            if (userID != null) {
                map.put("user_id", userID);
            }
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getDeviceIdWithBackup(Context context) {
        return AppLog.getDid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getOpenIdWithBackup(Context context) {
        return AppLog.getOpenUdid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getClientUDIDWithBackup(Context context) {
        return AppLog.getClientUdid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getInstallIdWithBackup(Context context) {
        return AppLog.getIid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getCustomVersion() {
        return this.mCustomVersion;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setCustomVersion(String str) {
        this.mCustomVersion = str;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setFakePackage(String str) {
        this.mFakePackage = str;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getFakePackage() {
        return this.mFakePackage;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean getHeader(Context context, JSONObject jSONObject, boolean z) {
        JSONObject header = AppLog.getHeader();
        if (header == null) {
            return false;
        }
        Utils.copy(jSONObject, header);
        return true;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setReleaseBuild(String str) {
        sReleaseBuild = str;
    }

    public static String getReleaseBuild() {
        return sReleaseBuild;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addCustomHeader(String str, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, obj);
        AppLog.setHeaderInfo(hashMap);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public int getAppId() {
        int i = this.mAppId;
        return (i > 0 || this.mAppContext == null) ? i : this.mAppContext.getAid();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getVersionName() {
        String str = (String) AppLog.getHeaderValue("app_version", "", String.class);
        if (TextUtils.isEmpty(str) && this.mAppContext != null) {
            str = this.mAppContext.getVersion();
        }
        return (TextUtils.equals(str, this.mCustomVersion) || TextUtils.isEmpty(this.mCustomVersion)) ? str : this.mCustomVersion;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public int getVersionCode() {
        if (this.mAppContext != null) {
            return this.mAppContext.getVersionCode();
        }
        return 0;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void updateUserAgent(Context context, String str) {
        AppLog.setUserAgent(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getCdid(Context context) {
        return Cdid.get(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppLanguage(String str) {
        AppLog.setAppLanguageAndRegion(str, (String) AppLog.getHeaderValue("app_region", "", String.class));
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppRegion(String str) {
        AppLog.setAppLanguageAndRegion((String) AppLog.getHeaderValue("app_region", "", String.class), str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUserAvailable(Context context) {
        return AppLog.isNewUserModeAvailable();
    }

    private boolean isDebugChannel() {
        return "local_test".equals(this.mChannel);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUser() {
        return AppLog.isNewUser();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public Map<String, String> getRequestHeader(Context context) {
        return AppLog.getRequestHeader();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isChildMode() {
        if (BDInstall.getCurrentEnv() == null) {
            return false;
        }
        return BDInstall.getCurrentEnv().isChildMode();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean clearWhenSwitchChildMode(boolean z) {
        AppLog.clearWhenSwitchChildMode(z);
        return true;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void resetDidWhenSwitchChildMode(boolean z, long j, final OnResetListener onResetListener) {
        AppLog.resetDidWhenSwitchChildMode(AppLog.getContext(), z, j, new com.bytedance.bdinstall.OnResetListener() { // from class: com.ss.android.deviceregister.BdtrackerImpl.3
            public void onDidUpdate(InstallInfo installInfo) {
                OnResetListener onResetListener2 = onResetListener;
                if (onResetListener2 != null) {
                    onResetListener2.onDidUpdate(installInfo.getDid(), installInfo.getIid());
                }
            }

            public void onTimeout() {
                OnResetListener onResetListener2 = onResetListener;
                if (onResetListener2 != null) {
                    onResetListener2.onTimeout();
                }
            }
        });
    }
}
