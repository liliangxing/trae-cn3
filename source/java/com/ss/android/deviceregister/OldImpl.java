package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.ss.android.CountryCommomParams;
import com.ss.android.common.AppContext;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.DrHelperWithRegion;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.DeviceRegisterConfig;
import com.ss.android.deviceregister.core.PrivateAgreement;
import com.ss.android.deviceregister.core.RealRegisterServiceController;
import com.ss.android.deviceregister.core.RegisterServiceController;
import com.ss.android.deviceregister.core.cache.IDeviceRegisterParameter;
import com.ss.android.deviceregister.utils.Cdid;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class OldImpl implements InstallApi {
    private static final String TAG = "OldImpl";
    private static volatile boolean sChildMode;
    private static String sDeviceRequestId;
    private static final Object sLock = new Object();
    private RealRegisterServiceController mRegisterService;
    private boolean sInitWithActivity;
    private boolean sIsLocalTest = false;

    @Override // com.ss.android.deviceregister.InstallApi
    public void activeUser(Context context, String str, String str2) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppVersionMinor(String str) {
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void init(Context context, boolean z, boolean z2, boolean z3) {
        if (RegistrationHeaderHelper.getEnableMigrate()) {
            MigrateDetectorHelper.clearMigrationInfo(context);
        }
        DrHelperWithRegion.doInDeviceRegisterInit(context);
        this.mRegisterService = new RealRegisterServiceController(context, z2);
        DeviceRegisterConfig.setInitWithActivity(this.sInitWithActivity);
        RegistrationHeaderHelper.setRegisterController(this.mRegisterService);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onCreate(Context context) {
        this.mRegisterService.init();
        PrivateAgreement.setAccepted(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void clearDidAndIid(Context context, String str) {
        IDeviceRegisterParameter deviceParamsProvider;
        if (this.mRegisterService != null) {
            deviceParamsProvider = DeviceRegisterParameterFactory.getProvider(context);
        } else {
            deviceParamsProvider = new DeviceParamsProvider(context, DeviceRegisterManager.isLocalTest());
        }
        if (deviceParamsProvider instanceof DeviceParamsProvider) {
            ((DeviceParamsProvider) deviceParamsProvider).clearDidAndIid(context, str);
        }
        AppLogConstants.getApplogStatsSp(context).edit().remove(RegisterServiceController.KEY_DEVICE_TOKEN).commit();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setInitWithActivity(boolean z) {
        this.sInitWithActivity = z;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppContext(AppContext appContext) {
        RegistrationHeaderHelper.setAppContext(appContext);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAntiCheatingSwitch(boolean z) {
        DeviceRegisterConfig.setAntiCheatingSwitch(z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceRegisterURL(String[] strArr, String str) {
        DeviceRegisterConfig.setDeviceRegisterURL(strArr);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceRegisterURL(String[] strArr, String[] strArr2) {
        DeviceRegisterConfig.setDeviceRegisterURL(strArr);
        DeviceRegisterConfig.setDeviceActiveURL(strArr2);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAccount(Context context, Account account) {
        DeviceRegisterParameterFactory.setAccount(context, account);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addCustomerHeaser(Bundle bundle) {
        if (bundle == null || bundle.size() <= 0) {
            return;
        }
        RegisterServiceController.addCustomHeader(bundle);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppId(int i) {
        RegistrationHeaderHelper.setAppId(i);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setChannel(String str) {
        RegistrationHeaderHelper.setChannel(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setCustomMonitor(ICustomMonitor iCustomMonitor) {
        RegisterServiceController.setCustomMonitor(iCustomMonitor);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        RegisterServiceController.setPreInstallChannelCallback(preInstallChannelCallback);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getInstallId() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController == null) {
            return "";
        }
        String installId = realRegisterServiceController.getInstallId();
        if (!Logger.debug()) {
            return installId;
        }
        TLog.m73d("OldImpl getInstallId() called,return value : " + installId);
        return installId;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getDeviceId() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        String deviceId = realRegisterServiceController != null ? realRegisterServiceController.getDeviceId() : "";
        if (Logger.debug()) {
            TLog.m73d("OldImpl getDeviceId() called,return value : " + deviceId);
        }
        return deviceId;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getOpenUdId() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        String openUdid = realRegisterServiceController != null ? realRegisterServiceController.getOpenUdid() : "";
        if (Logger.debug()) {
            TLog.m73d("OldImpl getOpenUdId() called,return value : " + openUdid);
        }
        return openUdid;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getClientUDID() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        String clientUDID = realRegisterServiceController != null ? realRegisterServiceController.getClientUDID() : "";
        if (Logger.debug()) {
            TLog.m73d("OldImpl getClientUDID() called,return value : " + clientUDID);
        }
        return clientUDID;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getRequestId() {
        if (TextUtils.isEmpty(sDeviceRequestId)) {
            synchronized (sLock) {
                if (TextUtils.isEmpty(sDeviceRequestId)) {
                    sDeviceRequestId = UUID.randomUUID().toString();
                }
            }
        }
        return sDeviceRequestId;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void updateDeviceInfo() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController != null) {
            realRegisterServiceController.updateDeviceInfo();
            if (Logger.debug()) {
                TLog.m73d("OldImpl updateDeviceInfo call  device_register");
            }
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setILogDepend(ILogDepend iLogDepend) {
        RegisterServiceController.setILogDepend(iLogDepend);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void tryWaitDeviceIdInit(Context context) {
        RegisterServiceController.tryWaitDeviceInit(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setLocalTest(boolean z) {
        this.sIsLocalTest = z;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isLocalTest() {
        return this.sIsLocalTest;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAnonymous(boolean z) {
        AppLogConstants.setAnonymous(z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setForbidReportPhoneDetailInfo(boolean z) {
        RegistrationHeaderHelper.setForbidReportPhoneDetailInfo(z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUserMode(Context context) {
        return DeviceRegisterParameterFactory.isNewUserMode(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setNewUserMode(Context context, boolean z) {
        DeviceRegisterParameterFactory.setNewUserMode(context, z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onResume(Context context) {
        RegisterServiceController.onUpdateActivityTime();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void onPause(Context context) {
        RegisterServiceController.onUpdateActivityTime();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void saveAppTrack(Context context, JSONObject jSONObject) {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController != null) {
            realRegisterServiceController.saveAppTrack(context, jSONObject);
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addOnDeviceConfigUpdateListener(DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener) {
        RegisterServiceController.addOnDeviceRegisterConfigUpdateListener(onDeviceConfigUpdateListener);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void getSSIDs(Map<String, String> map, Context context) {
        if (map == null || this.mRegisterService == null) {
            if (this.mRegisterService != null || context == null) {
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(AppLogConstants.getSPName(), 0);
            String string = sharedPreferences.getString("device_id", "");
            if (!TextUtils.isEmpty(string)) {
                map.put("device_id", string);
            }
            String string2 = sharedPreferences.getString("install_id", "");
            if (!TextUtils.isEmpty(string2)) {
                map.put("install_id", string2);
            }
            String string3 = context.getSharedPreferences(AppLogConstants.getDeviceParamsSpName(), 0).getString("openudid", null);
            if (!TextUtils.isEmpty(string3)) {
                map.put("openudid", string3);
            }
            String edgi = getEdgi(context);
            if (TextUtils.isEmpty(edgi)) {
                return;
            }
            map.put(AppLogConstants.KLINK_EGDI, edgi);
            return;
        }
        String openUdId = getOpenUdId();
        if (openUdId != null) {
            map.put("openudid", openUdId);
        }
        String clientUDID = getClientUDID();
        if (clientUDID != null) {
            map.put("clientudid", clientUDID);
        }
        String installId = getInstallId();
        if (installId != null) {
            map.put("install_id", installId);
        }
        String deviceId = getDeviceId();
        if (deviceId != null) {
            map.put("device_id", deviceId);
        }
        String edgi2 = getEdgi(context);
        if (TextUtils.isEmpty(edgi2)) {
            return;
        }
        map.put(AppLogConstants.KLINK_EGDI, edgi2);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getDeviceIdWithBackup(Context context) {
        if (this.mRegisterService == null && context != null) {
            return context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString("device_id", "");
        }
        return getDeviceId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getOpenIdWithBackup(Context context) {
        if (this.mRegisterService == null && context != null) {
            return context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString("openudid", null);
        }
        return getOpenUdId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getClientUDIDWithBackup(Context context) {
        if (this.mRegisterService == null && context != null) {
            return context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString("clientudid", null);
        }
        return getClientUDID();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getInstallIdWithBackup(Context context) {
        if (this.mRegisterService == null && context != null) {
            return context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString("install_id", null);
        }
        return getInstallId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setCustomVersion(String str) {
        RegistrationHeaderHelper.setCustomVersion(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setFakePackage(String str) {
        RegistrationHeaderHelper.setFakePackage(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getFakePackage() {
        return RegistrationHeaderHelper.getFakePackage();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean getHeader(Context context, JSONObject jSONObject, boolean z) {
        return RegistrationHeaderHelper.getHeader(context, jSONObject, z);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setReleaseBuild(String str) {
        RegistrationHeaderHelper.setReleaseBuild(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void addCustomHeader(String str, Object obj) {
        RegistrationHeaderHelper.addCustomHeader(str, obj);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getCustomVersion() {
        return RegistrationHeaderHelper.getCustomVersion();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public int getAppId() {
        return RegistrationHeaderHelper.getAppId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getVersionName() {
        return RegistrationHeaderHelper.getVersionName();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public int getVersionCode() {
        return RegistrationHeaderHelper.getVersionCode();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getUserAgent(Context context) {
        return RegistrationHeaderHelper.getUserAgent(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void updateUserAgent(Context context, String str) {
        RegistrationHeaderHelper.setUserAgent(context, str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void filterHeader(JSONObject jSONObject) {
        RegistrationHeaderHelper.filterHeader(jSONObject);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setSDKVersion(String str) {
        RegistrationHeaderHelper.setSDKVersion(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getChannel(Context context) {
        return RegistrationHeaderHelper.getChannelCompat(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public String getCdid(Context context) {
        return Cdid.get(context);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean reportPhoneDetailInfo() {
        return RegistrationHeaderHelper.reportPhoneDetailInfo();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppLanguage(String str) {
        CountryCommomParams.setAppLanguage(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setAppRegion(String str) {
        CountryCommomParams.setAppRegion(str);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUserAvailable(Context context) {
        try {
            if (!DeviceRegisterParameterFactory.isDebugChannel() && !DeviceRegisterManager.isForceOpenNewUserMode()) {
                return false;
            }
            Class.forName(DeviceRegisterParameterFactory.CLASS_NAME_NEW_USER_MODE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isNewUser() {
        return RegisterServiceController.isNewUser();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public Map<String, String> getRequestHeader(Context context) {
        if (context == null) {
            return Collections.emptyMap();
        }
        String string = AppLogConstants.getApplogStatsSp(context).getString(RegisterServiceController.KEY_DEVICE_TOKEN, "");
        HashMap hashMap = new HashMap();
        hashMap.put("x-tt-dt", string);
        return hashMap;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setChildModeBeforeInit(boolean z) {
        sChildMode = z;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean isChildMode() {
        return sChildMode;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public boolean clearWhenSwitchChildMode(boolean z) {
        sChildMode = z;
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController == null) {
            return false;
        }
        sDeviceRequestId = null;
        realRegisterServiceController.clearWhenSwitchChildMode(z);
        return true;
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void resetDidWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        sChildMode = z;
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController == null) {
            return;
        }
        realRegisterServiceController.resetDidWhenSwitchChildMode(z, j, onResetListener);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void tryUpdateDeviceId() {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController == null) {
            return;
        }
        realRegisterServiceController.tryUpdateDeviceId();
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setDeviceCategory(DeviceCategory deviceCategory) {
        RegistrationHeaderHelper.setDeviceCategory(deviceCategory);
    }

    @Override // com.ss.android.deviceregister.InstallApi
    public void setEnableMigrate(boolean z) {
        RegistrationHeaderHelper.setEnableMigrate(z);
    }

    public String getEdgi(Context context) {
        RealRegisterServiceController realRegisterServiceController = this.mRegisterService;
        if (realRegisterServiceController == null) {
            return context.getSharedPreferences(AppLogConstants.getSPName(), 0).getString(AppLogConstants.KLINK_EGDI, "");
        }
        return realRegisterServiceController.getEgdi();
    }
}
