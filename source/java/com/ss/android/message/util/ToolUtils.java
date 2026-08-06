package com.ss.android.message.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.model.ProcessEnum;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.push.appstatus.AppStatusObserverForChildProcess;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomUtils;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.message.AnrOptManager;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.setting.PushCommonSetting;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import com.ss.android.ugc.quota.BDNetworkTagManager;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ToolUtils {
    public static int FALSE = 0;
    public static final int FOCUS_PERMISSION_STATUS_CLOSE = 1;
    public static final int FOCUS_PERMISSION_STATUS_OPEN = 2;
    public static final int FOCUS_PERMISSION_STATUS_UNKNOWN = -1;
    public static String HONOR = "honor";

    /* renamed from: HW */
    public static String f55HW = "huawei";
    public static String MESSAGE_PROCESS_SUFFIX = ":push";
    private static final long MIN_GET_RUNNING_APP_PROCESS_INVOKE_INTERVAL = 1000;
    public static String ONEPLUS = "oneplus";
    public static String OPPO = "oppo";
    public static String PUSH_SERVICE_PROCESS_SUFFIX = ":pushservice";
    public static String SMP_PROCESS_SUFFIX = ":smp";
    public static final String SMP_PROCESS_SUFFIX_V2 = ":widgetProvider";
    private static final String TAG = "ToolUtils";
    public static int TRUE = 1;
    public static String VIVO = "vivo";
    public static String XIAOMI = "xiaomi";
    private static int debugMode = -1;
    private static long initTimeStamp = 0;
    private static Boolean isMainProcess = null;
    private static long lastInvokeGetRunningAppProcessTimeStamp = 0;
    private static List<ActivityManager.RunningAppProcessInfo> lastRunningAppProcess = null;
    private static String sAndroidId = "";
    private static ProcessEnum sCurProcess = null;
    private static String sCurProcessName = null;
    private static String sCurProcessNameSuffix = null;
    private static String sImei = "";
    public static boolean sIsInited;
    public static boolean sIsMiui;
    private static long timeStampFromProc;
    private static final Object sPushFakeDeviceIdLock = new Object();
    private static final Object sProcessNameLock = new Object();
    private static final Object sAndroidIdLock = new Object();
    private static final Object runningAppLock = new Object();

    /* renamed from: com_ss_android_message_util_ToolUtils_android_provider_Settings$Secure_getString */
    private static String m106x6602ebc(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    /* renamed from: com_ss_android_message_util_ToolUtils_android_telephony_TelephonyManager_getDeviceId */
    private static String m107x52e5758e(TelephonyManager telephonyManager) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = new Object[0];
        ExtraInfo extraInfo = new ExtraInfo(false, "()Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, (Object) null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String deviceId = telephonyManager.getDeviceId();
        heliosApiHook.postInvoke(101600, "android/telephony/TelephonyManager", "getDeviceId", telephonyManager, objArr, deviceId, extraInfo, true);
        return deviceId;
    }

    public static void setMessageProcessSuffix(String str) {
        MESSAGE_PROCESS_SUFFIX = str;
    }

    public static void setPushServiceProcessSuffix(String str) {
        PUSH_SERVICE_PROCESS_SUFFIX = str;
    }

    public static ProcessEnum getCurProcess(Context context) {
        ProcessEnum processEnum = sCurProcess;
        if (processEnum != null) {
            return processEnum;
        }
        ProcessEnum parseProcess = ProcessEnum.parseProcess(getCurProcessName(context), context.getPackageName());
        sCurProcess = parseProcess;
        return parseProcess;
    }

    public static String getProcessSuffix(Context context, String str) {
        return TextUtils.equals(str, context.getPackageName()) ? "main" : str.contains(Constants.COLON_SEPARATOR) ? str.split(Constants.COLON_SEPARATOR)[1] : "";
    }

    public static String getCurProcessNameSuffix(Context context) {
        String str = sCurProcessNameSuffix;
        if (!StringUtils.isEmpty(str)) {
            return str;
        }
        String processSuffix = getProcessSuffix(context, getCurProcessName(context));
        sCurProcessNameSuffix = processSuffix;
        return processSuffix;
    }

    public static String getCurProcessName(Context context) {
        synchronized (sProcessNameLock) {
            if (sCurProcessName == null) {
                sCurProcessName = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mProcess;
            }
            if (!TextUtils.isEmpty(sCurProcessName)) {
                return sCurProcessName;
            }
            String currentProcessNameByApplication = getCurrentProcessNameByApplication();
            sCurProcessName = currentProcessNameByApplication;
            if (!TextUtils.isEmpty(currentProcessNameByApplication)) {
                return sCurProcessName;
            }
            String currentProcessNameByActivityThread = getCurrentProcessNameByActivityThread();
            sCurProcessName = currentProcessNameByActivityThread;
            if (!TextUtils.isEmpty(currentProcessNameByActivityThread)) {
                return sCurProcessName;
            }
            String curProcessNameFromProc = getCurProcessNameFromProc();
            sCurProcessName = curProcessNameFromProc;
            if (!TextUtils.isEmpty(curProcessNameFromProc)) {
                return sCurProcessName;
            }
            String currentProcessNameByActivityManager = getCurrentProcessNameByActivityManager(context);
            sCurProcessName = currentProcessNameByActivityManager;
            return currentProcessNameByActivityManager;
        }
    }

    private static String getCurrentProcessNameByApplication() {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return Application.getProcessName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameByActivityThread() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static String getCurrentProcessNameByActivityManager(Context context) {
        if (context == null) {
            return null;
        }
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    private static String getCurProcessNameFromProc() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                int read = bufferedReader.read();
                if (read <= 0) {
                    break;
                }
                sb.append((char) read);
            }
            if (Logger.debug()) {
                Logger.d("Process", "get processName = " + sb.toString());
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return sb2;
        } catch (Throwable unused3) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        }
    }

    public static String getUserSerial(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("user");
        if (systemService == null) {
            Logger.e(TAG, "userManager not exsit !!!");
            return null;
        }
        try {
            Object invoke = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);
            return String.valueOf(((Long) systemService.getClass().getMethod("getSerialNumberForUser", invoke.getClass()).invoke(systemService, invoke)).longValue());
        } catch (IllegalAccessException e) {
            Logger.e(TAG, e.getMessage());
            return null;
        } catch (IllegalArgumentException e2) {
            Logger.e(TAG, e2.getMessage());
            return null;
        } catch (NoSuchMethodException e3) {
            Logger.e(TAG, e3.getMessage());
            return null;
        } catch (InvocationTargetException e4) {
            Logger.e(TAG, e4.getMessage());
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Boolean isMainProcessStart(Context context) {
        IPushCommonConfiguration iPushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
        if (iPushCommonConfiguration == null || !iPushCommonConfiguration.hasAgreedForPrivacyDialog()) {
            Logger.d(TAG, "hasAgreedForPrivacyDialog return false when isMainProcessStart is invoked.");
            return null;
        }
        if (isMainProcess(context)) {
            Logger.d(TAG, "isMainProcess return true when isMainProcessStart is invoked.");
            return true;
        }
        Logger.d(TAG, "getRunningAppProcesses is to be invoked when isMainProcessStart is invoked.");
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
            String packageName = context.getPackageName();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (packageName.equals(it.next().processName)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isSmpProcessStart(Context context) {
        if (!PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.hasAgreedForPrivacyDialog()) {
            Logger.d(TAG, "hasAgreedForPrivacyDialog return false when isSmpProcessStart is invoked.");
            return false;
        }
        if (isSmpProcess(context)) {
            Logger.d(TAG, "isSmpProcess return true when isSmpProcessStart is invoked.");
            return true;
        }
        Logger.d(TAG, "getRunningAppProcesses is to be invoked when isSmpProcessStart is invoked.");
        try {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
            String str = context.getPackageName() + ":smp";
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().processName)) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean isApplicationForeground(Context context, String str) {
        if (context == null || StringUtils.isEmpty(str)) {
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (str.equals(runningAppProcessInfo.processName)) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public static List<ActivityManager.RunningTaskInfo> getRunningTasks(ActivityManager activityManager, int i) {
        return activityManager.getRunningTasks(i);
    }

    public static boolean isInstalledApp(Context context, String str) {
        if (context == null || StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isInstalledApp(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        return (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || queryIntentActivities.size() <= 0) ? false : true;
    }

    public static boolean isServiceRunning(Context context, String str, String str2) {
        if (context == null || StringUtils.isEmpty(str)) {
            return false;
        }
        if (!StringUtils.isEmpty(str2)) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(RXScreenCaptureService.KEY_LAUNCH_ACTIVITY)).getRunningServices(Integer.MAX_VALUE);
                if (runningServices == null || runningServices.size() <= 0) {
                    return false;
                }
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (!str.equals(runningServiceInfo.service.getPackageName()) || !str2.equals(runningServiceInfo.service.getClassName())) {
                    }
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMainProcess(Context context) {
        Boolean bool = isMainProcess;
        if (bool != null) {
            return bool.booleanValue();
        }
        String curProcessName = getCurProcessName(context);
        boolean z = false;
        if (curProcessName != null && curProcessName.contains(Constants.COLON_SEPARATOR)) {
            return false;
        }
        if (curProcessName != null && curProcessName.equals(context.getPackageName())) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        isMainProcess = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean isFlyme() {
        return Build.DISPLAY.indexOf("Flyme") >= 0 || Build.USER.equals("flyme");
    }

    public static String addUrlParam(String str, Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
        }
        return addUrlParam(str, arrayList);
    }

    public static String addUrlParam(String str, List<Pair<String, String>> list) {
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(63) < 0) {
            sb.append("?");
        } else {
            sb.append("&");
        }
        sb.append(NetworkUtils.format(list, HTTP.UTF_8));
        return sb.toString();
    }

    public static Map<String, String> addNetworkTagToHeader(Map<String, String> map) {
        try {
            BDNetworkTagContextProviderAdapter bDNetworkTagContextProviderAdapter = new BDNetworkTagContextProviderAdapter() { // from class: com.ss.android.message.util.ToolUtils.1
                @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
                public int triggerType() {
                    return 0;
                }

                @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
                public boolean markAsNewUser() {
                    return super.markAsNewUser();
                }
            };
            Map hashMap = map == null ? new HashMap() : map;
            Pair<String, String> buildBDNetworkTag = BDNetworkTagManager.getInstance().buildBDNetworkTag(bDNetworkTagContextProviderAdapter);
            hashMap.put(buildBDNetworkTag.first, buildBDNetworkTag.second);
            return hashMap;
        } catch (Exception unused) {
            return map;
        }
    }

    public static boolean hasCreatedNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        List<NotificationChannel> notificationChannels = notificationManager.getNotificationChannels();
        return notificationChannels != null && notificationChannels.size() > 0;
    }

    public static int areNotificationsEnabled(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            return ((Boolean) Reflect.on((NotificationManager) context.getSystemService("notification")).call("areNotificationsEnabled").get()).booleanValue() ? TRUE : FALSE;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i = applicationInfo.uid;
                Reflect on = Reflect.on(appOpsManager);
                if (((Integer) on.call("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}, new Object[]{Integer.valueOf(((Integer) on.field("OP_POST_NOTIFICATION", new Class[]{Integer.TYPE}).get()).intValue()), Integer.valueOf(i), packageName}).get()).intValue() == 0) {
                    return TRUE;
                }
                return FALSE;
            } catch (Throwable th) {
                th.printStackTrace();
                return -1;
            }
        }
    }

    public static ApplicationInfo getTargetApplicationInfo(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean isHuaweiDevice() {
        try {
            if (StringUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(f55HW)) {
                if (StringUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith(f55HW)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isOppoDevice() {
        String str = Build.MANUFACTURER;
        String str2 = Build.BRAND;
        return RomUtils.getInstance().isColorOS() || (!TextUtils.isEmpty(str) && (str.toLowerCase().contains(OPPO) || str.toLowerCase().contains(ONEPLUS))) || (!TextUtils.isEmpty(str2) && (str2.toLowerCase().contains(OPPO) || str2.toLowerCase().contains(ONEPLUS)));
    }

    public static boolean isTargetBrandDevice(String str) {
        try {
            if (StringUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(str)) {
                if (StringUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase().startsWith(str)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isEmui(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getEmuiInfo();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(com.ss.android.deviceregister.utils.RomUtils.EMUI)) || isHuaweiDevice();
    }

    public static String getEmuiInfo() {
        String systemProperty = getSystemProperty("ro.build.version.emui");
        return TextUtils.isEmpty(systemProperty) ? getSystemProperty("ro.build.version.magic") : systemProperty;
    }

    public static String getEMUI() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, "ro.build.version.emui");
            Logger.d(TAG, "getEMUI: emuiVersion " + invoke);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getMagicUI() {
        try {
            String systemProperty = getSystemProperty("ro.build.version.emui");
            return !TextUtils.isEmpty(systemProperty) ? getSystemProperty("ro.build.version.magic") : systemProperty;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getSystemProperty(String str) {
        String str2;
        Process exec;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str3 = null;
        try {
            exec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()), 1024);
        } catch (Throwable th) {
            th = th;
            str2 = null;
        }
        try {
            str3 = bufferedReader.readLine();
            exec.destroy();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Logger.e(TAG, "Exception while closing InputStream" + e.getMessage());
            }
            return str3;
        } catch (Throwable th2) {
            th = th2;
            str2 = str3;
            bufferedReader2 = bufferedReader;
            try {
                Logger.e(TAG, "Unable to read sysprop " + str + th.getMessage());
                return str2;
            } finally {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e2) {
                        Logger.e(TAG, "Exception while closing InputStream" + e2.getMessage());
                    }
                }
            }
        }
    }

    public static boolean isMiui() {
        if (!sIsInited) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    sIsMiui = true;
                    sIsInited = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            sIsInited = true;
        }
        return sIsMiui;
    }

    public static String getRomInfo() {
        StringBuilder sb = new StringBuilder();
        try {
            if (isMiui()) {
                sb.append("MIUI-");
            } else if (isFlyme()) {
                sb.append("FLYME-");
            } else {
                String emuiInfo = getEmuiInfo();
                if (isEmui(emuiInfo) && !isNexus6p()) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(emuiInfo)) {
                    sb.append(emuiInfo).append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static boolean isNexus6p() {
        return "angler".equals(Build.BOARD) && Build.MODEL != null && Build.MODEL.toLowerCase().contains("nexus") && Build.MODEL.toLowerCase().contains("6p");
    }

    public static void setProcessName(String str) {
        sCurProcessName = str;
    }

    public static boolean isSmpProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        if (curProcessName == null || !(curProcessName.endsWith(SMP_PROCESS_SUFFIX) || curProcessName.endsWith(SMP_PROCESS_SUFFIX_V2))) {
            return false;
        }
        isMainProcess = false;
        return true;
    }

    public static boolean isMessageProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        if (curProcessName == null || !curProcessName.endsWith(MESSAGE_PROCESS_SUFFIX)) {
            return false;
        }
        isMainProcess = false;
        return true;
    }

    public static boolean isPushServiceProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        if (curProcessName == null || !curProcessName.endsWith(PUSH_SERVICE_PROCESS_SUFFIX)) {
            return false;
        }
        isMainProcess = false;
        return true;
    }

    public static String getLaunchActivity(Context context) {
        try {
            ComponentName resolveActivity = com.ss.android.common.util.ToolUtils.getLaunchIntentForPackage(context, context.getPackageName()).resolveActivity(context.getPackageManager());
            if (resolveActivity != null) {
                return resolveActivity.getClassName();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String listToString(List<Long> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i < size - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb.toString();
    }

    public static List<Long> stringToList(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() > 0) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                Iterator it = new ArrayList(Arrays.asList(split)).iterator();
                while (it.hasNext()) {
                    if (TextUtils.isEmpty((String) it.next())) {
                        it.remove();
                    }
                }
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            arrayList.add(Long.valueOf(str2));
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String getAndroidId(Context context) {
        Logger.d(TAG, "[getAndroidId]sAndroidId:" + sAndroidId + " stack:" + Log.getStackTraceString(new Throwable()));
        synchronized (sAndroidIdLock) {
            if (!TextUtils.isEmpty(sAndroidId)) {
                Logger.d(TAG, "[getAndroidId]cur has valid android,return " + sAndroidId);
                return sAndroidId;
            }
            if (!isActiveUser(context)) {
                Logger.d(TAG, "[getAndroidId]return " + sAndroidId + " because cur is guest user");
                return sAndroidId;
            }
            if (AppStatusObserverForChildProcess.sIsInBackGround(!AnrOptManager.enableOptAnr())) {
                Logger.d(TAG, "[getAndroidId]use cache because cur is background");
                if (TextUtils.isEmpty(sAndroidId) && ((PushOnlineSettings) SettingsManager.obtain(context, PushOnlineSettings.class)).enableCachedAndroidId()) {
                    sAndroidId = ((LocalSettings) SettingsManager.obtain(context, LocalSettings.class)).getAndroidId();
                }
                return sAndroidId;
            }
            try {
                Logger.d(TAG, "[getAndroidId]invoke sys api to get android_id");
                String m106x6602ebc = m106x6602ebc(context.getContentResolver(), "android_id");
                sAndroidId = m106x6602ebc;
                if (!TextUtils.isEmpty(m106x6602ebc)) {
                    ((LocalSettings) SettingsManager.obtain(context, LocalSettings.class)).setAndroidId(sAndroidId);
                }
            } catch (Throwable th) {
                Logger.e(TAG, "error when get android_id", th);
            }
            return sAndroidId;
        }
    }

    public static String getImei(Context context) {
        synchronized (sImei) {
            if (!TextUtils.isEmpty(sImei)) {
                return sImei;
            }
            if (!isActiveUser(context)) {
                return sImei;
            }
            if (AppStatusObserverForChildProcess.sIsInBackGround()) {
                return sImei;
            }
            if (context == null) {
                return sImei;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return sImei;
            }
            if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                if (Build.VERSION.SDK_INT < 26) {
                    sImei = m107x52e5758e(telephonyManager);
                } else {
                    try {
                        Object invoke = Class.forName("android.telephony.TelephonyManager").getMethod("getMeid", new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null && (invoke instanceof String)) {
                            sImei = (String) invoke;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            return sImei;
        }
    }

    public static boolean isActiveUser(Context context) {
        IPushCommonConfiguration iPushCommonConfiguration;
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (pushCommonConfiguration == null || (iPushCommonConfiguration = pushCommonConfiguration.mIPushCommonConfiguration) == null || iPushCommonConfiguration.isGuestMode() || !iPushCommonConfiguration.hasAgreedForPrivacyDialog()) {
            return false;
        }
        return !TextUtils.isEmpty(getDeviceId(context));
    }

    public static String getDeviceId(Context context) {
        HashMap hashMap = new HashMap();
        getSSIDs(context, hashMap);
        return (String) hashMap.get("device_id");
    }

    public static String getPushFakeDeviceId(Context context) {
        synchronized (sPushFakeDeviceIdLock) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(PushMultiProcessSharedProvider.SP_CONFIG_NAME, 4);
                String string = sharedPreferences.getString(PushCommonSetting.DEPTHS_DEVICE_ID, "");
                Logger.d(TAG, "[getPushFakeDeviceId]cache id:" + string);
                if (!TextUtils.isEmpty(string)) {
                    return string;
                }
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                String sha256 = toSha256(Build.BOARD + Build.HARDWARE + (Build.SUPPORTED_ABIS.length > 0 ? Build.SUPPORTED_ABIS.hashCode() : 0) + Build.BRAND + System.currentTimeMillis() + new Random().nextInt(AVMDLDataLoader.KeyIsEnableEventInfo) + displayMetrics.widthPixels + displayMetrics.heightPixels);
                Logger.d(TAG, "[getPushFakeDeviceId]depths device id:" + sha256);
                sharedPreferences.edit().putString(PushCommonSetting.DEPTHS_DEVICE_ID, sha256).apply();
                return sha256;
            } catch (Throwable th) {
                Logger.e(TAG, "[getPushFakeDeviceId]exception ", th);
                return "";
            }
        }
    }

    public static String toSha256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    sb.append('0');
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (Throwable th) {
            Logger.e(TAG, "[toMd5]exception:" + th.getLocalizedMessage());
            return str;
        }
    }

    static void getSSIDs(Context context, Map<String, String> map) {
        if (map == null) {
            return;
        }
        String string = context.getSharedPreferences(PushMultiProcessSharedProvider.SP_CONFIG_NAME, 4).getString(PushCommonSetting.SSIDS, "");
        if (StringUtils.isEmpty(string)) {
            return;
        }
        StringUtils.stringToMap(string, map);
    }

    public static void setComponentEnable(Context context, String str, boolean z) {
        ComponentName componentName = new ComponentName(context.getPackageName(), str);
        PackageManager packageManager = context.getPackageManager();
        try {
            Logger.i("set " + str + " enable to " + z);
            packageManager.setComponentEnabledSetting(componentName, z ? 1 : 2, 1);
        } catch (Throwable th) {
            Logger.e("error to set " + str + " enable to " + z);
            th.printStackTrace();
        }
    }

    public static void killSelf() {
        Process.killProcess(Process.myPid());
    }

    public static void killAll(Context context) {
        Logger.d("kill all");
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid != Process.myPid()) {
                    Process.killProcess(runningAppProcessInfo.pid);
                }
            }
        }
        Process.killProcess(Process.myPid());
    }

    public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses() {
        if (!isActiveUser(AppProvider.getApp())) {
            Logger.d(TAG, "[getRunningAppProcesses]return  empty running process because cur is inactive user");
            return new ArrayList();
        }
        boolean optSensitiveApiInvoke = PushCommonSetting.optSensitiveApiInvoke();
        Logger.d(TAG, "[getRunningAppProcesses]optSensitiveApiInvoke:" + optSensitiveApiInvoke);
        if (optSensitiveApiInvoke) {
            synchronized (runningAppLock) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - lastInvokeGetRunningAppProcessTimeStamp >= 1000) {
                    Logger.d(TAG, "[getRunningAppProcesses]invoke getRunningAppProcess");
                    lastInvokeGetRunningAppProcessTimeStamp = currentTimeMillis;
                    lastRunningAppProcess = getRunningAppProcessesInternal();
                } else {
                    Logger.d(TAG, "[getRunningAppProcesses]api invoke frequency,return lastRunningAppProcess");
                }
            }
            return lastRunningAppProcess;
        }
        Logger.d(TAG, "[getRunningAppProcesses]invoke getRunningAppProcessesInternal without any frequency because settings of opt_sensitive_api_invoke is false");
        return getRunningAppProcessesInternal();
    }

    private static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcessesInternal() {
        return ((ActivityManager) AppProvider.getApp().getSystemService(RXScreenCaptureService.KEY_LAUNCH_ACTIVITY)).getRunningAppProcesses();
    }

    public static long currentTimeMillis() {
        long j = timeStampFromProc;
        if (j == 0) {
            String str = RomUtils.getInstance().get("log.tag.push.timestamp");
            if (TextUtils.isEmpty(str)) {
                timeStampFromProc = -1L;
            } else {
                try {
                    timeStampFromProc = Long.parseLong(str);
                } catch (Throwable unused) {
                    timeStampFromProc = -1L;
                }
                initTimeStamp = System.currentTimeMillis();
                return timeStampFromProc;
            }
        } else if (j != -1) {
            return j + (System.currentTimeMillis() - initTimeStamp);
        }
        return System.currentTimeMillis();
    }

    public static boolean isDebugModeFromProc() {
        if (debugMode == -1) {
            String str = RomUtils.getInstance().get("log.tag.push.debug_mode");
            if (TextUtils.isEmpty(str)) {
                debugMode = 0;
            } else {
                try {
                    debugMode = Integer.parseInt(str);
                } catch (Throwable unused) {
                    debugMode = 0;
                }
            }
        }
        return debugMode == 1;
    }

    public static String listToStringDivideByComma(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next())) {
                    it.remove();
                }
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i < size - 1) {
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
        }
        return sb.toString();
    }

    public static List<String> stringDividedByCommaToList(String str) {
        ArrayList arrayList = new ArrayList();
        if (str != null && str.length() > 0) {
            try {
                String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                Iterator it = new ArrayList(Arrays.asList(split)).iterator();
                while (it.hasNext()) {
                    if (TextUtils.isEmpty((String) it.next())) {
                        it.remove();
                    }
                }
                for (String str2 : split) {
                    if (!TextUtils.isEmpty(str2) && !arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return arrayList;
    }

    public static boolean parseBool(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Boolean.parseBoolean(str);
            } catch (Throwable th) {
                Logger.e(TAG, "[parseBool] ", th);
            }
        }
        return z;
    }

    public static long parseLong(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (Throwable th) {
                Logger.e(TAG, "[parseLong] ", th);
            }
        }
        return j;
    }

    public static int parseInt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (Throwable th) {
                Logger.e(TAG, "[parseLong] ", th);
            }
        }
        return i;
    }

    public static String bundleToString(Bundle bundle) {
        Set<String> keySet;
        if (bundle == null || (keySet = bundle.keySet()) == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : keySet) {
            Object obj = bundle.get(str);
            if (obj instanceof Intent) {
                sb.append(String.format("%s--%s\n", str, bundleToString(((Intent) obj).getExtras())));
            } else {
                sb.append(String.format("%s--%s\n", str, obj));
            }
        }
        return sb.toString();
    }

    public static int hasFocusPermission(Context context) {
        Logger.d(TAG, "[hasFocusPermission]");
        if (!RomUtils.getInstance().isMiOS()) {
            return -1;
        }
        try {
            Uri parse = Uri.parse("content://miui.statusbar.notification.public");
            Bundle bundle = new Bundle();
            bundle.putString("package", context.getPackageName());
            Bundle call = context.getContentResolver().call(parse, "canShowFocus", (String) null, bundle);
            if (call == null) {
                return -1;
            }
            boolean z = call.getBoolean("canShowFocus", false);
            Logger.d(TAG, "[hasFocusPermission]canShowFocus:" + z);
            return z ? 2 : 1;
        } catch (Throwable th) {
            Logger.e(TAG, "[hasFocusPermission]exception:" + th.getLocalizedMessage());
            return -1;
        }
    }

    public static String getFocusPermissionVersion(Context context) {
        Logger.d(TAG, "[getFocusPermissionVersion]");
        if (!RomUtils.getInstance().isMiOS()) {
            return LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
        }
        try {
            int i = Settings.System.getInt(context.getContentResolver(), "notification_focus_protocol", 0);
            Logger.d(TAG, "[getFocusPermissionVersion]notificationFocusProtocol:" + i);
            return String.valueOf(i);
        } catch (Throwable th) {
            Logger.e(TAG, "[getFocusPermissionVersion]exception:" + th.getLocalizedMessage());
            return LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
        }
    }
}
