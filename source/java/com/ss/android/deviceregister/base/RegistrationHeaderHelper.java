package com.ss.android.deviceregister.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.CountryCommomParams;
import com.ss.android.common.AppContext;
import com.ss.android.common.util.TLog;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.deviceregister.BuildConfig;
import com.ss.android.deviceregister.DeviceCategory;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.GaidGetter;
import com.ss.android.deviceregister.core.RealRegisterServiceController;
import com.ss.android.deviceregister.utils.Cdid;
import com.ss.android.deviceregister.utils.DeviceRegistrationUtils;
import com.ss.android.deviceregister.utils.HardwareUtils;
import com.ss.android.deviceregister.utils.RomUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RegistrationHeaderHelper {
    private static final int DENSITY_XHIGH = 320;
    static final String KEY_ACCESS = "access";
    static final String KEY_APPKEY = "appkey";
    public static final String KEY_APP_LANGUAGE = "app_language";
    public static final String KEY_APP_REGION = "app_region";
    private static final String KEY_APP_TRACK = "app_track";
    public static final String KEY_APP_VERSION = "app_version";
    static final String KEY_APP_VERSION_MINOR = "app_version_minor";
    static final String KEY_CARRIER = "carrier";
    public static final String KEY_CDID = "cdid";
    static final String KEY_CHANNEL = "channel";
    static final String KEY_CPU_ABI = "cpu_abi";
    static final String KEY_DENSITY_DPI = "density_dpi";
    static final String KEY_DEVICE_BRAND = "device_brand";
    public static final String KEY_DEVICE_CATEGORY = "device_category";
    static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    static final String KEY_DEVICE_MODEL = "device_model";
    static final String KEY_DISPLAY_DENSITY = "display_density";
    static final String KEY_DISPLAY_NAME = "display_name";
    static final String KEY_GIT_HASH = "git_hash";
    public static final String KEY_GOOGLE_AID = "google_aid";
    public static final String KEY_GOOGLE_AID_LIMIT = "gaid_limited";
    static final String KEY_LANGUAGE = "language";
    static final String KEY_MANIFEST_VERSION_CODE = "manifest_version_code";
    static final String KEY_MCC_MNC = "mcc_mnc";
    public static final String KEY_NEW_USER_MODE = "new_user_mode";
    public static final String KEY_NOT_REQUEST_SENDER = "not_request_sender";
    public static final String KEY_OS = "os";
    public static final String KEY_OS_API = "os_api";
    public static final String KEY_OS_VERSION = "os_version";
    public static final String KEY_PACKAGE = "package";
    public static final String KEY_REAL_PACKAGE_NAME = "real_package_name";
    public static final String KEY_REGISON = "region";
    static final String KEY_RELEASE_BUILD = "release_build";
    static final String KEY_RESOLUTION = "resolution";
    static final String KEY_ROM = "rom";
    static final String KEY_ROM_VERSION = "rom_version";
    static final String KEY_SDK_TARGET_VERSION = "sdk_target_version";
    public static final String KEY_SDK_VERSION = "sdk_version";
    static final String KEY_SIG_HASH = "sig_hash";
    public static final String KEY_SIM_REGION = "sim_region";
    static final String KEY_TIMEZONE = "timezone";
    public static final String KEY_TIMEZONE_NAME = "tz_name";
    public static final String KEY_TIMEZONE_OFFSET = "tz_offset";
    static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    public static final String KEY_VERSION_CODE = "version_code";
    public static final String SP_KEY_APP_LANGUAGE = "app_language";
    public static final String SP_KEY_APP_REGION = "app_region";
    public static final String SP_KEY_GOOGLE_AID = "google_aid";
    private static final String TAG = "RegistrationHeaderHelper";
    private static volatile DeviceCategory deviceCategory = null;
    private static int sAid = 0;
    private static AppContext sAppContext = null;
    private static String sAppTrack = null;
    private static ConcurrentHashMap<String, Object> sCache = null;
    private static String sChannel = null;
    private static volatile boolean sChildMode = false;
    private static String sCustomVersion = null;
    private static ILogDepend sDepend = null;
    private static String sFakePackage = null;
    private static volatile JSONObject sHeader = null;
    private static String sOldDeviceId = null;
    private static RealRegisterServiceController sRegisterService = null;
    private static String sReleaseBuild = null;
    private static String sRomInfo = null;
    private static String sSDKVersion = "2.15.0";
    private static String sSigHash;
    private static String sUserAgent;
    private static int sVersionCode;
    private static String sVersionName;
    private static ConcurrentHashMap<String, Object> sCustomHeaderMap = new ConcurrentHashMap<>();
    private static boolean sIsNotRequestSender = false;
    private static final Object sLock = new Object();
    private static boolean sForbidReportPhoneDetailInfo = false;
    private static volatile boolean sEnableMigrate = true;

    public static String getFakePackage() {
        return sFakePackage;
    }

    public static void setFakePackage(String str) {
        sFakePackage = str;
    }

    private RegistrationHeaderHelper() {
    }

    public static boolean getHeader(Context context, JSONObject jSONObject, boolean z) {
        boolean z2;
        AppContext appContext;
        int i;
        HashMap hashMap = new HashMap();
        synchronized (sLock) {
            if (sHeader != null && sChildMode == z) {
                copy(sHeader, jSONObject);
                return true;
            }
            boolean isTouristMode = DeviceRegisterManager.isTouristMode();
            JSONObject jSONObject2 = new JSONObject();
            boolean z3 = false;
            try {
                String packageName = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(packageName, 128).metaData;
                    String str = sChannel;
                    if (str != null && str.length() > 0) {
                        hashMap.put("channel", sChannel);
                    } else if (bundle != null && !TextUtils.isEmpty("UMENG_CHANNEL")) {
                        hashMap.put("channel", DrHelperWithRegion.getChannel(bundle));
                    }
                    if (bundle != null && !TextUtils.isEmpty("UMENG_APPKEY")) {
                        hashMap.put(KEY_APPKEY, bundle.getString("UMENG_APPKEY"));
                    }
                } catch (Exception e) {
                    onEvent(e);
                    e.printStackTrace();
                }
                if (!TextUtils.isEmpty(sFakePackage)) {
                    hashMap.put("package", sFakePackage);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(KEY_REAL_PACKAGE_NAME, context.getPackageName());
                    DeviceRegisterManager.addCustomerHeaser(bundle2);
                } else {
                    hashMap.put("package", context.getPackageName());
                }
                AppContext appContext2 = sAppContext;
                if (appContext2 != null) {
                    sVersionName = appContext2.getVersion();
                }
                if (!StringUtils.isEmpty(sCustomVersion)) {
                    sVersionName = sCustomVersion;
                }
                hashMap.put("app_version", sVersionName);
                AppContext appContext3 = sAppContext;
                if (appContext3 != null) {
                    sVersionCode = appContext3.getVersionCode();
                }
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                    jSONObject2.put(KEY_DISPLAY_NAME, context.getString(i));
                }
                AppContext appContext4 = sAppContext;
                if (appContext4 != null) {
                    int updateVersionCode = appContext4.getUpdateVersionCode();
                    if (updateVersionCode > 0) {
                        jSONObject2.put("update_version_code", updateVersionCode);
                    }
                    int manifestVersionCode = sAppContext.getManifestVersionCode();
                    if (manifestVersionCode > 0) {
                        jSONObject2.put(KEY_MANIFEST_VERSION_CODE, manifestVersionCode);
                    }
                    if (!TextUtils.isEmpty(DeviceRegisterManager.getAppVersionMinor())) {
                        jSONObject2.put(KEY_APP_VERSION_MINOR, DeviceRegisterManager.getAppVersionMinor());
                    } else {
                        jSONObject2.put(KEY_APP_VERSION_MINOR, "");
                    }
                }
                String[] strArr = {"channel", KEY_APPKEY, "package", "app_version"};
                try {
                    if (sAid == 0 && (appContext = sAppContext) != null) {
                        sAid = appContext.getAid();
                    }
                    jSONObject2.put("aid", sAid);
                    for (int i2 = 0; i2 < 4; i2++) {
                        String str2 = strArr[i2];
                        String str3 = (String) hashMap.get(str2);
                        if (StringUtils.isEmpty(str3)) {
                            TLog.m81w("RegistrationHeaderHelper init fail empty field: " + str2);
                            if (!KEY_APPKEY.equals(str2)) {
                                return false;
                            }
                        } else {
                            jSONObject2.put(str2, str3);
                        }
                    }
                    jSONObject2.put("version_code", sVersionCode);
                    jSONObject2.put(KEY_SDK_VERSION, sSDKVersion);
                    jSONObject2.put(KEY_SDK_TARGET_VERSION, 29);
                    jSONObject2.put(KEY_GIT_HASH, BuildConfig.GIT_HASH);
                    jSONObject2.put(KEY_OS, "Android");
                    jSONObject2.put(KEY_OS_VERSION, Build.VERSION.RELEASE);
                    jSONObject2.put(KEY_OS_API, Build.VERSION.SDK_INT);
                    jSONObject2.put(KEY_DEVICE_MODEL, Build.MODEL);
                    jSONObject2.put(KEY_DEVICE_BRAND, Build.BRAND);
                    jSONObject2.put(KEY_DEVICE_MANUFACTURER, Build.MANUFACTURER);
                    if (deviceCategory != null) {
                        jSONObject2.put(KEY_DEVICE_CATEGORY, deviceCategory.getLower());
                    }
                    jSONObject2.put(KEY_CPU_ABI, Build.CPU_ABI);
                    String str4 = sReleaseBuild;
                    if (str4 == null) {
                        str4 = "";
                    }
                    jSONObject2.put(KEY_RELEASE_BUILD, str4);
                } catch (Exception e2) {
                    onEvent(e2);
                }
                try {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i3 = displayMetrics.densityDpi;
                    jSONObject2.put(KEY_DENSITY_DPI, i3);
                    jSONObject2.put(KEY_DISPLAY_DENSITY, i3 != 120 ? i3 != 240 ? i3 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi");
                    jSONObject2.put(KEY_RESOLUTION, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
                } catch (Exception e3) {
                    onEvent(e3);
                }
                SharedPreferences applogStatsSp = AppLogConstants.getApplogStatsSp(context);
                try {
                    String language = context.getResources().getConfiguration().locale.getLanguage();
                    if (!StringUtils.isEmpty(language)) {
                        jSONObject2.put("language", language);
                    }
                    float rawOffset = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
                    if (rawOffset < -12.0f) {
                        rawOffset = -12.0f;
                    }
                    if (rawOffset > 12.0f) {
                        rawOffset = 12.0f;
                    }
                    jSONObject2.put(KEY_TIMEZONE, rawOffset);
                    String networkAccessType = NetworkUtils.getNetworkAccessType(context);
                    if (networkAccessType != null) {
                        jSONObject2.put(KEY_ACCESS, networkAccessType);
                    }
                } catch (Exception e4) {
                    onEvent(e4);
                    e4.printStackTrace();
                }
                try {
                    if (!sCustomHeaderMap.isEmpty()) {
                        for (Map.Entry<String, Object> entry : sCustomHeaderMap.entrySet()) {
                            if (entry != null) {
                                jSONObject2.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                    jSONObject2.put("not_request_sender", sIsNotRequestSender ? 1 : 0);
                } catch (Exception e5) {
                    onEvent(e5);
                    e5.printStackTrace();
                }
                try {
                    String carrier = HardwareUtils.getCarrier(context);
                    String mccMnc = HardwareUtils.getMccMnc(context);
                    if (!StringUtils.isEmpty(carrier)) {
                        jSONObject2.put(KEY_CARRIER, carrier);
                    }
                    if (!StringUtils.isEmpty(mccMnc)) {
                        jSONObject2.put(KEY_MCC_MNC, mccMnc);
                    }
                } catch (Exception e6) {
                    onEvent(e6);
                    e6.printStackTrace();
                }
                StringBuilder sb = new StringBuilder();
                try {
                    if (ToolUtils.isMiui()) {
                        sb.append("MIUI-");
                    } else if (ToolUtils.isFlyme()) {
                        sb.append("FLYME-");
                    } else {
                        String emuiInfo = ToolUtils.getEmuiInfo();
                        if (RomUtils.isHwOrHonor(emuiInfo)) {
                            sb.append("EMUI-");
                        }
                        if (!TextUtils.isEmpty(emuiInfo)) {
                            sb.append(emuiInfo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                        }
                    }
                    sb.append(Build.VERSION.INCREMENTAL);
                    if (sb.length() > 0) {
                        String sb2 = sb.toString();
                        sRomInfo = sb2;
                        jSONObject2.put(KEY_ROM, sb2);
                    }
                } catch (Throwable th) {
                    onEvent(th);
                }
                try {
                    String romInfo = RomUtils.getRomInfo();
                    if (!StringUtils.isEmpty(romInfo)) {
                        jSONObject2.put(KEY_ROM_VERSION, romInfo);
                    }
                } catch (Throwable th2) {
                    onEvent(th2);
                    th2.printStackTrace();
                }
                try {
                    String str5 = Cdid.get(context);
                    if (!StringUtils.isEmpty(str5)) {
                        jSONObject2.put(KEY_CDID, str5);
                    }
                } catch (Throwable th3) {
                    onEvent(th3);
                    th3.printStackTrace();
                }
                prepareSigHash(context, jSONObject2);
                String string = applogStatsSp.getString("app_language", null);
                String string2 = applogStatsSp.getString("app_region", null);
                try {
                    String appLanguage = CountryCommomParams.getAppLanguage();
                    String appRegion = CountryCommomParams.getAppRegion();
                    if (!z && !isTouristMode) {
                        Pair<String, Boolean> gaid = GaidGetter.getGaid(context);
                        if (!DeviceRegisterManager.isNewUserMode(context) && gaid != null) {
                            jSONObject2.put(KEY_GOOGLE_AID_LIMIT, gaid.second != null && ((Boolean) gaid.second).booleanValue() ? 1 : 0);
                            jSONObject2.put("google_aid", gaid.first);
                        }
                    }
                    if (StringUtils.isEmpty(appLanguage) || appLanguage.equals(string)) {
                        z2 = false;
                    } else {
                        string = appLanguage;
                        z2 = true;
                    }
                    if (!StringUtils.isEmpty(string)) {
                        jSONObject2.put("app_language", string);
                    }
                    if (!StringUtils.isEmpty(appRegion) && !appRegion.equals(string2)) {
                        z3 = true;
                        string2 = appRegion;
                    }
                    if (!StringUtils.isEmpty(string2)) {
                        jSONObject2.put("app_region", string2);
                    }
                    SharedPreferences.Editor edit = applogStatsSp.edit();
                    if (z2) {
                        edit.putString("app_language", string);
                    }
                    if (z3) {
                        edit.putString("app_region", string2);
                    }
                    if (z2 || z3) {
                        edit.commit();
                    }
                } catch (Throwable th4) {
                    onEvent(th4);
                }
                String string3 = applogStatsSp.getString(KEY_APP_TRACK, "");
                sAppTrack = string3;
                try {
                    if (!StringUtils.isEmpty(string3)) {
                        jSONObject2.put(KEY_APP_TRACK, new JSONObject(sAppTrack));
                    }
                } catch (Throwable th5) {
                    onEvent(th5);
                    th5.printStackTrace();
                }
                RealRegisterServiceController realRegisterServiceController = sRegisterService;
                if (realRegisterServiceController != null) {
                    try {
                        String deviceId = realRegisterServiceController.getDeviceId();
                        if (!StringUtils.isEmpty(deviceId)) {
                            jSONObject2.put("device_id", deviceId);
                        }
                        if (!z) {
                            String openUdid = sRegisterService.getOpenUdid();
                            if (!StringUtils.isEmpty(openUdid)) {
                                jSONObject2.put("openudid", openUdid);
                            }
                        }
                        String installId = sRegisterService.getInstallId();
                        if (!StringUtils.isEmpty(installId)) {
                            jSONObject2.put("install_id", installId);
                        }
                        String clientUDID = sRegisterService.getClientUDID();
                        if (!StringUtils.isEmpty(clientUDID)) {
                            jSONObject2.put("clientudid", clientUDID);
                        }
                        String egdi = sRegisterService.getEgdi();
                        if (!StringUtils.isEmpty(egdi)) {
                            jSONObject2.put(AppLogConstants.KLINK_EGDI, egdi);
                        }
                    } catch (Exception e7) {
                        onEvent(e7);
                        e7.printStackTrace();
                    }
                }
                if (DeviceRegisterManager.isNewUserMode(context)) {
                    try {
                        if (DeviceRegistrationUtils.isInValidId(DeviceRegisterManager.getDeviceId()) || DeviceRegistrationUtils.isInValidId(DeviceRegisterManager.getInstallId())) {
                            jSONObject2.put(KEY_NEW_USER_MODE, 1);
                        }
                    } catch (JSONException e8) {
                        e8.printStackTrace();
                    }
                }
                ConcurrentHashMap<String, Object> concurrentHashMap = sCache;
                if (concurrentHashMap != null) {
                    for (Map.Entry<String, Object> entry2 : concurrentHashMap.entrySet()) {
                        try {
                            if (entry2.getValue() != null) {
                                jSONObject2.put(entry2.getKey(), entry2.getValue());
                            }
                        } catch (JSONException e9) {
                            e9.printStackTrace();
                        }
                    }
                }
                try {
                    String country = HardwareUtils.getCountry();
                    if (!StringUtils.isEmpty(country)) {
                        jSONObject2.put(KEY_REGISON, country);
                    }
                    String id = Calendar.getInstance().getTimeZone().getID();
                    if (!StringUtils.isEmpty(id)) {
                        jSONObject2.put(KEY_TIMEZONE_NAME, id);
                    }
                    jSONObject2.put(KEY_TIMEZONE_OFFSET, Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                    String simRegion = HardwareUtils.getSimRegion(context);
                    if (!StringUtils.isEmpty(simRegion)) {
                        jSONObject2.put(KEY_SIM_REGION, simRegion);
                    }
                } catch (Throwable th6) {
                    onEvent(th6);
                }
                if (!z) {
                    DrHelperWithRegion.updateHeader(context, sRegisterService, jSONObject2, reportPhoneDetailInfo(), isTouristMode);
                }
                if (!TextUtils.isEmpty(sOldDeviceId)) {
                    try {
                        jSONObject2.put("old_did", sOldDeviceId);
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                }
                synchronized (sLock) {
                    sHeader = jSONObject2;
                    sChildMode = z;
                    copy(jSONObject2, jSONObject);
                }
                return true;
            } catch (Exception e11) {
                TLog.m76e("RegistrationHeaderHelper init exception: ", e11);
                onEvent(e11);
                return false;
            }
        }
    }

    private static void onEvent(Throwable th) {
        AppContext appContext = sAppContext;
        if (appContext == null) {
            return;
        }
        ILogDepend iLogDepend = sDepend;
        appContext.getContext();
        if (th == null || iLogDepend == null) {
            return;
        }
        String stackTraceString = Log.getStackTraceString(th);
        if (StringUtils.isEmpty(stackTraceString)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stack", stackTraceString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        iLogDepend.onDeviceRegisterEvent("device_register", jSONObject);
    }

    private static void prepareSigHash(Context context, JSONObject jSONObject) {
        String sigHash = getSigHash(context);
        if (sigHash != null) {
            try {
                jSONObject.put(KEY_SIG_HASH, sigHash);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getSigHash(Context context) {
        if (StringUtils.isEmpty(sSigHash) && context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length >= 1) {
                    Signature signature = packageInfo.signatures[0];
                    if (signature == null) {
                        return sSigHash;
                    }
                    sSigHash = DigestUtils.md5Hex(signature.toByteArray());
                }
                return sSigHash;
            } catch (Exception e) {
                TLog.m76e("RegistrationHeaderHelperfailed to inst package sianature: ", e);
            }
        }
        return sSigHash;
    }

    public static void copy(JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                jSONObject2.put(next, jSONObject.opt(next));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setAppContext(AppContext appContext) {
        sAppContext = appContext;
    }

    @Deprecated
    public static void setAppId(int i) {
        sAid = i;
    }

    public static void setReleaseBuild(String str) {
        sReleaseBuild = str;
    }

    public static void addCustomHeader(String str, Object obj) {
        sCustomHeaderMap.put(str, obj);
    }

    public static void setIsNotRequestSender(boolean z) {
        sIsNotRequestSender = z;
    }

    public static void setCustomVersion(String str) {
        sCustomVersion = str;
    }

    public static String getCustomVersion() {
        return sCustomVersion;
    }

    public static String getReleaseBuild() {
        return sReleaseBuild;
    }

    public static int getAppId() {
        AppContext appContext;
        if (sAid <= 0 && (appContext = sAppContext) != null) {
            appContext.getAid();
        }
        return sAid;
    }

    public static void putCommonHeader(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        if (Logger.debug()) {
            TLog.m73d("RegistrationHeaderHelper put header : key = " + str + ", val = " + obj);
        }
        if (sCache == null) {
            sCache = new ConcurrentHashMap<>();
        }
        sCache.put(str, obj);
    }

    public static void putCommonHeaders(HashMap<String, Object> hashMap) {
        if (hashMap == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            putCommonHeader(entry.getKey(), entry.getValue());
        }
    }

    public static int getVersionCode() {
        AppContext appContext;
        if (sVersionCode <= 0 && (appContext = sAppContext) != null) {
            sVersionCode = appContext.getVersionCode();
        }
        return sVersionCode;
    }

    public static String getUserAgent(Context context) {
        if (StringUtils.isEmpty(sUserAgent)) {
            sUserAgent = AppLogConstants.getApplogStatsSp(context).getString(AppLogConstants.KEY_USER_AGENT, null);
        }
        return sUserAgent;
    }

    public static void setUserAgent(Context context, String str) {
        if (StringUtils.isEmpty(str) || str.equals(sUserAgent)) {
            return;
        }
        sUserAgent = str;
        SharedPreferences.Editor edit = AppLogConstants.getApplogStatsSp(context).edit();
        edit.putString(AppLogConstants.KEY_USER_AGENT, str);
        edit.commit();
    }

    public static void setChannel(String str) {
        sChannel = str;
    }

    public static String getChannel() {
        return sChannel;
    }

    public static String getChannelCompat(Context context) {
        if (!TextUtils.isEmpty(sChannel)) {
            return sChannel;
        }
        AppContext appContext = sAppContext;
        if (appContext != null) {
            return appContext.getTweakedChannel();
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                return null;
            }
            sChannel = DrHelperWithRegion.getChannel(bundle);
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void saveAppTrack(Context context, String str) {
        try {
            SharedPreferences.Editor edit = AppLogConstants.getApplogStatsSp(context).edit();
            edit.putString(KEY_APP_TRACK, str);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    public static String getVersionName() {
        AppContext appContext;
        if (TextUtils.isEmpty(sVersionName) && (appContext = sAppContext) != null) {
            sVersionName = appContext.getVersion();
        }
        return sVersionName;
    }

    public static void setRegisterController(RealRegisterServiceController realRegisterServiceController) {
        sRegisterService = realRegisterServiceController;
    }

    public static void setILogDepend(ILogDepend iLogDepend) {
        sDepend = iLogDepend;
    }

    public static void setForbidReportPhoneDetailInfo(boolean z) {
        sForbidReportPhoneDetailInfo = z;
        if (sHeader != null) {
            synchronized (sLock) {
                filterHeader(sHeader);
            }
        }
    }

    public static boolean reportPhoneDetailInfo() {
        return !sForbidReportPhoneDetailInfo;
    }

    public static void filterHeader(JSONObject jSONObject) {
        DrHelperWithRegion.filterHeader(jSONObject);
    }

    public static void setSDKVersion(String str) {
        sSDKVersion = str;
    }

    public static void setOldDeviceId(String str) {
        sOldDeviceId = str;
    }

    public static void clearHeaderCache() {
        sHeader = null;
    }

    public static void updateHeaderDidAndIid(String str, String str2) {
        synchronized (sLock) {
            if (sHeader != null) {
                try {
                    sHeader.put("device_id", str);
                    sHeader.put("install_id", str2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setDeviceCategory(DeviceCategory deviceCategory2) {
        deviceCategory = deviceCategory2;
    }

    public static void setEnableMigrate(boolean z) {
        sEnableMigrate = z;
    }

    public static boolean getEnableMigrate() {
        return sEnableMigrate;
    }
}
