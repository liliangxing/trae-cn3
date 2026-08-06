package com.ss.android.deviceregister;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.ss.android.common.AppContext;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface InstallApi {
    void activeUser(Context context, String str, String str2);

    void addCustomHeader(String str, Object obj);

    void addCustomerHeaser(Bundle bundle);

    void addOnDeviceConfigUpdateListener(DeviceRegisterManager.OnDeviceConfigUpdateListener onDeviceConfigUpdateListener);

    void clearDidAndIid(Context context, String str);

    boolean clearWhenSwitchChildMode(boolean z);

    void filterHeader(JSONObject jSONObject);

    int getAppId();

    String getCdid(Context context);

    String getChannel(Context context);

    String getClientUDID();

    String getClientUDIDWithBackup(Context context);

    String getCustomVersion();

    String getDeviceId();

    String getDeviceIdWithBackup(Context context);

    String getFakePackage();

    boolean getHeader(Context context, JSONObject jSONObject, boolean z);

    String getInstallId();

    String getInstallIdWithBackup(Context context);

    String getOpenIdWithBackup(Context context);

    String getOpenUdId();

    Map<String, String> getRequestHeader(Context context);

    String getRequestId();

    void getSSIDs(Map<String, String> map, Context context);

    String getUserAgent(Context context);

    int getVersionCode();

    String getVersionName();

    void init(Context context, boolean z, boolean z2, boolean z3);

    boolean isChildMode();

    boolean isLocalTest();

    boolean isNewUser();

    boolean isNewUserAvailable(Context context);

    boolean isNewUserMode(Context context);

    void onCreate(Context context);

    void onPause(Context context);

    void onResume(Context context);

    boolean reportPhoneDetailInfo();

    void resetDidWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener);

    void saveAppTrack(Context context, JSONObject jSONObject);

    void setAccount(Context context, Account account);

    void setAnonymous(boolean z);

    void setAntiCheatingSwitch(boolean z);

    void setAppContext(AppContext appContext);

    void setAppId(int i);

    void setAppLanguage(String str);

    void setAppRegion(String str);

    void setAppVersionMinor(String str);

    void setChannel(String str);

    void setChildModeBeforeInit(boolean z);

    void setCustomMonitor(ICustomMonitor iCustomMonitor);

    void setCustomVersion(String str);

    void setDeviceCategory(DeviceCategory deviceCategory);

    void setDeviceRegisterURL(String[] strArr, String str);

    void setDeviceRegisterURL(String[] strArr, String[] strArr2);

    void setEnableMigrate(boolean z);

    void setFakePackage(String str);

    void setForbidReportPhoneDetailInfo(boolean z);

    void setILogDepend(ILogDepend iLogDepend);

    void setInitWithActivity(boolean z);

    void setLocalTest(boolean z);

    void setNewUserMode(Context context, boolean z);

    void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback);

    void setReleaseBuild(String str);

    void setSDKVersion(String str);

    void tryUpdateDeviceId();

    void tryWaitDeviceIdInit(Context context);

    void updateDeviceInfo();

    void updateUserAgent(Context context, String str);
}
