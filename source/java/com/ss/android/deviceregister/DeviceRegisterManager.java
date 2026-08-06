package com.ss.android.deviceregister;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.common.utility.Logger;
import com.ss.android.common.AppContext;
import com.ss.android.common.applog.NetUtil;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.IAdIdConfig;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.service.ServiceManager;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DeviceRegisterManager {
    private static final String TAG = "DeviceRegisterManager";
    private static InstallApi api = null;
    private static volatile int egdiRetryInterval = 0;
    private static volatile boolean enableGetEgdi = false;
    private static volatile boolean enableNetCommOpt = false;
    private static volatile boolean forceOpenNewUserMode = false;
    private static InstallApi mBdtrackerApi = null;
    private static InstallApi oldApi = null;
    private static volatile IAdIdConfig sAdIdConfig = null;
    private static volatile IAppTraitCallback sAppTraitCallback = null;
    private static volatile String sAppVersionMinor = "";
    private static boolean sCheckPermissionBeforeCallSensitiveApi = false;
    private static Context sContext = null;
    private static volatile boolean sDeleteSharedStorage = true;
    private static volatile boolean sInitGuard = false;
    private static volatile DeviceRegisterManager sInstance = null;
    private static boolean sIsBoe = false;
    private static volatile boolean sIsTouristMode = false;
    private static volatile MacAddressApiCallback sMacAddressApiCallback = null;
    private static volatile boolean sNeedSharedStorage = false;
    private static volatile boolean sOpenBpea = false;
    private static int sRetryCount = -1;
    private static volatile SensitiveApiCallback sSensitiveApiCallback = null;
    private static volatile int sSwitchToBdtracker = -1;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface OnDeviceConfigUpdateListener {
        void onDeviceRegistrationInfoChanged(String str, String str2);

        void onDidLoadLocally(boolean z);

        void onRemoteConfigUpdate(boolean z, boolean z2);
    }

    @Deprecated
    public static void setUseGoogleAdId(boolean z) {
    }

    public static boolean getSwitchToBdtracker() {
        if (sSwitchToBdtracker < 0) {
            TLog.m75e("DeviceRegisterManager SwitchToBdtracker has not been set!");
        }
        return sSwitchToBdtracker > 0;
    }

    public static void setSwitchToBdtracker(boolean z) {
        sSwitchToBdtracker = z ? 1 : 0;
        if (z) {
            api = mBdtrackerApi;
        }
    }

    static {
        OldImpl oldImpl = new OldImpl();
        oldApi = oldImpl;
        api = oldImpl;
        mBdtrackerApi = new BdtrackerImpl();
        sIsBoe = false;
    }

    public static void setIsBoe(boolean z) {
        sIsBoe = z;
        BdtrackerImpl.setIsBoe(z);
    }

    public static void setChildModeBeforeInit(boolean z) {
        api.setChildModeBeforeInit(z);
    }

    public static boolean isChildMode() {
        return api.isChildMode();
    }

    public static void setContext(Context context) {
        sContext = context.getApplicationContext();
    }

    public static boolean hasInit() {
        return sInitGuard;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void init(Context context, boolean z, boolean z2) throws IllegalArgumentException {
        if (context == null) {
            throw new IllegalArgumentException("context = null");
        }
        sInitGuard = true;
        if (context instanceof Activity) {
            setInitWithActivity(true);
        }
        sContext = context.getApplicationContext();
        if (sInstance == null) {
            synchronized (DeviceRegisterManager.class) {
                if (sInstance == null) {
                    sInstance = new DeviceRegisterManager(z, z2);
                    sInstance.onCreate(context);
                }
            }
        }
        if (Logger.debug()) {
            TLog.m73d("DeviceRegister init, DeviceRegister : " + sInstance.toString() + ", process : " + Process.myPid());
        }
    }

    private void onCreate(Context context) {
        api.onCreate(context);
    }

    public static void setInitWithActivity(boolean z) {
        api.setInitWithActivity(z);
    }

    public static void setAppContext(AppContext appContext) {
        api.setAppContext(appContext);
        if (getSwitchToBdtracker()) {
            oldApi.setAppContext(appContext);
        }
        NetUtil.setAppContext(appContext);
    }

    public static void setAntiCheatingSwitch(boolean z) {
        api.setAntiCheatingSwitch(z);
    }

    public static void setDeviceRegisterURL(String[] strArr, String[] strArr2) {
        api.setDeviceRegisterURL(strArr, strArr2);
    }

    public static void setAccount(Context context, Account account) {
        api.setAccount(context, account);
    }

    public static String getSigHash(Context context) {
        return RegistrationHeaderHelper.getSigHash(context);
    }

    public static void addCustomerHeaser(Bundle bundle) {
        api.addCustomerHeaser(bundle);
    }

    public static void setAppId(int i) {
        api.setAppId(i);
        if (getSwitchToBdtracker()) {
            oldApi.setAppId(i);
        }
    }

    public static void setChannel(String str) {
        api.setChannel(str);
        if (getSwitchToBdtracker()) {
            oldApi.setChannel(str);
        }
    }

    public static void setCustomMonitor(ICustomMonitor iCustomMonitor) {
        api.setCustomMonitor(iCustomMonitor);
    }

    public static void setSDKVersion(String str) {
        api.setSDKVersion(str);
    }

    public static String getAppVersionMinor() {
        return sAppVersionMinor;
    }

    public static void setAppVersionMinor(String str) {
        sAppVersionMinor = str;
        api.setAppVersionMinor(str);
    }

    private DeviceRegisterManager(boolean z, boolean z2) {
        try {
            api.init(sContext, sIsBoe, z, z2);
        } catch (Throwable th) {
            Log.e("BDInstall", "error when init ", th);
            th.printStackTrace();
        }
    }

    public static void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        api.setPreInstallChannelCallback(preInstallChannelCallback);
    }

    public static void setRetryCount(int i) {
        sRetryCount = i;
    }

    public static int getRetryCount() {
        return sRetryCount;
    }

    public static void setTouristMode(boolean z) {
        sIsTouristMode = z;
    }

    public static boolean isTouristMode() {
        return sIsTouristMode;
    }

    public static void setAppTraitCallback(IAppTraitCallback iAppTraitCallback) {
        sAppTraitCallback = iAppTraitCallback;
    }

    public static IAppTraitCallback getAppTraitCallback() {
        return sAppTraitCallback;
    }

    public static String getInstallId() {
        return api.getInstallId();
    }

    public static String getDeviceId() {
        return api.getDeviceId();
    }

    public static String getOpenUdId() {
        return api.getOpenUdId();
    }

    public static String getClientUDID() {
        return api.getClientUDID();
    }

    public static void onPause(Context context) {
        api.onPause(context);
    }

    public static void onResume(Context context) {
        api.onResume(context);
    }

    public static void saveAppTrack(Context context, JSONObject jSONObject) {
        api.saveAppTrack(context, jSONObject);
    }

    public static void addOnDeviceConfigUpdateListener(OnDeviceConfigUpdateListener onDeviceConfigUpdateListener) {
        api.addOnDeviceConfigUpdateListener(onDeviceConfigUpdateListener);
    }

    public static void getSSIDs(Map<String, String> map) {
        api.getSSIDs(map, sContext);
    }

    public static String getDeviceIdWithBackup() {
        return api.getDeviceIdWithBackup(sContext);
    }

    public static String getOpenIdWithBackup() {
        return api.getOpenIdWithBackup(sContext);
    }

    public static String getClientUDIDWithBackup() {
        return api.getClientUDIDWithBackup(sContext);
    }

    public static String getInstallIdWithBackup() {
        return api.getInstallIdWithBackup(sContext);
    }

    public static void setCustomVersion(String str) {
        api.setCustomVersion(str);
    }

    public static void setForceOpenNewUserMode(boolean z) {
        forceOpenNewUserMode = z;
    }

    public static boolean isForceOpenNewUserMode() {
        return forceOpenNewUserMode;
    }

    public static void enableEarlyRegisterNewUserModeService(Context context, String str) {
        try {
            if (TextUtils.equals(str, "local_test") || forceOpenNewUserMode) {
                synchronized (INewUserModeManager.class) {
                    if (ServiceManager.getService(INewUserModeManager.class) == null) {
                        ServiceManager.registerService(INewUserModeManager.class, (INewUserModeManager) Class.forName(Constants.NEW_USER_MODE_MANAGER).getConstructor(Context.class).newInstance(context));
                        Log.d("AppLog# ", "enable early register NewUserModeManager to ServiceManager.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNewUserMode(Context context, boolean z) {
        api.setNewUserMode(context, z);
    }

    public static boolean isNewUserMode(Context context) {
        return api.isNewUserMode(context);
    }

    public static void clearDidAndIid(Context context, String str) {
        api.clearDidAndIid(context, str);
    }

    public static void setForbidReportPhoneDetailInfo(boolean z) {
        api.setForbidReportPhoneDetailInfo(z);
    }

    public static void setAnonymous(boolean z) {
        api.setAnonymous(z);
    }

    public static boolean isLocalTest() {
        return api.isLocalTest();
    }

    public static void setLocalTest(boolean z) {
        api.setLocalTest(z);
    }

    public static void activeUser(Context context, String str, String str2) {
        api.activeUser(context, str, str2);
    }

    public static InstallApi getBdtrackerImpl() {
        return mBdtrackerApi;
    }

    public static void setFakePackage(String str) {
        api.setFakePackage(str);
    }

    public static String getFakePackage() {
        return api.getFakePackage();
    }

    public static boolean getHeader(Context context, JSONObject jSONObject, boolean z) {
        return api.getHeader(context, jSONObject, z);
    }

    public static void setReleaseBuild(String str) {
        api.setReleaseBuild(str);
        if (getSwitchToBdtracker()) {
            oldApi.setReleaseBuild(str);
        }
    }

    public static void addCustomHeader(String str, Object obj) {
        api.addCustomHeader(str, obj);
    }

    public static String getCustomVersion() {
        return api.getCustomVersion();
    }

    public static int getAppId() {
        return api.getAppId();
    }

    public static String getVersionName() {
        return api.getVersionName();
    }

    public static int getVersionCode() {
        return api.getVersionCode();
    }

    public static String getUserAgent(Context context) {
        return api.getUserAgent(context);
    }

    public static void updateUserAgentString(Context context, String str) {
        api.updateUserAgent(context, str);
    }

    public static void filterHeader(JSONObject jSONObject) {
        api.filterHeader(jSONObject);
    }

    public static String getChannel(Context context) {
        return api.getChannel(context);
    }

    static String getCdid(Context context) {
        return api.getCdid(context);
    }

    public static void setAppLanguage(String str) {
        api.setAppLanguage(str);
    }

    public static void setAppRegion(String str) {
        api.setAppRegion(str);
    }

    public static void setDeviceCategory(DeviceCategory deviceCategory) {
        api.setDeviceCategory(deviceCategory);
    }

    public static void setEnableMigrate(boolean z) {
        api.setEnableMigrate(z);
    }

    public static void tryWaitDeviceIdInit() {
        api.tryWaitDeviceIdInit(sContext);
    }

    public static void setILogDepend(ILogDepend iLogDepend) {
        api.setILogDepend(iLogDepend);
    }

    public static void updateDeviceInfo() {
        api.updateDeviceInfo();
    }

    public static String getRequestId() {
        return api.getRequestId();
    }

    public static boolean clearWhenSwitchChildMode(boolean z) {
        DeviceRegisterManager deviceRegisterManager = sInstance;
        if (!hasInit() || deviceRegisterManager == null) {
            api.setChildModeBeforeInit(z);
            return false;
        }
        return api.clearWhenSwitchChildMode(z);
    }

    public static void resetDidWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        DeviceRegisterManager deviceRegisterManager = sInstance;
        if (!hasInit() || deviceRegisterManager == null) {
            api.setChildModeBeforeInit(z);
        } else {
            api.resetDidWhenSwitchChildMode(z, j, onResetListener);
        }
    }

    public static void updateDidAndIid() {
        DeviceRegisterManager deviceRegisterManager = sInstance;
        if (!hasInit() || deviceRegisterManager == null) {
            return;
        }
        api.tryUpdateDeviceId();
        TLog.m73d("updateDidAndIid call  device_register");
    }

    public static Map<String, String> getRequestHeader() {
        return api.getRequestHeader(sContext);
    }

    public static boolean isNeedSharedStorage() {
        return sNeedSharedStorage;
    }

    public static boolean isDeleteSharedStorage() {
        return sDeleteSharedStorage;
    }

    public static void setSharedStorageConfig(boolean z, boolean z2) {
        sNeedSharedStorage = z;
        sDeleteSharedStorage = z2;
    }

    public static void setOpenBpea(boolean z) {
        sOpenBpea = z;
    }

    public static IAdIdConfig getAdIdConfig() {
        if (sAdIdConfig == null) {
            sAdIdConfig = new IAdIdConfig.AdIdConfig();
        }
        return sAdIdConfig;
    }

    public static SensitiveApiCallback getBpeaApiCallback() {
        return sSensitiveApiCallback;
    }

    public static boolean isOpenBpe() {
        return sOpenBpea;
    }

    public static void setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback) {
        sSensitiveApiCallback = sensitiveApiCallback;
    }

    public static void setMacAddressApiCallback(MacAddressApiCallback macAddressApiCallback) {
        sMacAddressApiCallback = macAddressApiCallback;
    }

    public static MacAddressApiCallback getMacAddressApiCallback() {
        return sMacAddressApiCallback;
    }

    public static void setAdIdConfig(IAdIdConfig iAdIdConfig) {
        if (iAdIdConfig == null) {
            return;
        }
        sAdIdConfig = iAdIdConfig;
    }

    public static void checkPermissionBeforeCallSensitiveApi(boolean z) {
        sCheckPermissionBeforeCallSensitiveApi = z;
    }

    public static boolean checkPermissionBeforeCallSensitiveApi() {
        return sCheckPermissionBeforeCallSensitiveApi;
    }

    public static void setEnableNetCommOpt(boolean z) {
        enableNetCommOpt = z;
    }

    public static boolean isEnableNetCommOpt() {
        return enableNetCommOpt;
    }

    public static void setEnableGetEdgi(boolean z) {
        enableGetEgdi = z;
    }

    public static void setEdgiRetryInterval(int i) {
        egdiRetryInterval = i;
    }

    public static boolean isEnableGetEgdi() {
        return enableGetEgdi;
    }

    public static int getEgdiRetryInterval() {
        if (egdiRetryInterval > 0) {
            return egdiRetryInterval;
        }
        return 10000;
    }
}
