package com.ss.android.common.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.standard.tools.device.SystemPropertiesUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.helios.statichook.api.ExtraInfo;
import com.bytedance.helios.statichook.api.HeliosApiHook;
import com.bytedance.helios.statichook.api.Result;
import com.bytedance.trae.im.model.ParsedChatMessage;
import com.lynx.tasm.core.ResManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.ttm.player.C;
import com.ttnet.org.chromium.net.NetError;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes7.dex */
public final class ToolUtils {
    private static final int FLAGS_GET_ONLY_FROM_ANDROID = 16777216;
    public static final int FLAG_LOC_GPS = 1;
    public static final int FLAG_LOC_NETWORK = 2;
    public static final int FLAG_LOC_PASSIVE = 4;
    public static final String NODEX_PROCESS_SUFFIX = ":nodex";
    private static volatile boolean bAlreadyGetProp = false;
    public static String mMsgProcessSuffix = ":push";
    private static boolean sCanSetStatusBar = true;
    private static String sCurProcessName;
    public static boolean sIsInited;
    public static boolean sIsMiui;
    private static String systemProperty;

    private static String com_ss_android_common_util_ToolUtils_android_provider_Settings$Secure_getString(ContentResolver contentResolver, String str) {
        HeliosApiHook heliosApiHook = new HeliosApiHook();
        Object[] objArr = {contentResolver, str};
        ExtraInfo extraInfo = new ExtraInfo(false, "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;");
        Result preInvoke = heliosApiHook.preInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, "java.lang.String", extraInfo);
        if (preInvoke.isIntercept()) {
            heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, null, extraInfo, false);
            return (String) preInvoke.getReturnValue();
        }
        String string = Settings.Secure.getString(contentResolver, str);
        heliosApiHook.postInvoke(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, objArr, string, extraInfo, true);
        return string;
    }

    private ToolUtils() {
    }

    public static void setMessageProcessSuffix(String str) {
        mMsgProcessSuffix = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public static int getLocationMode(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (StringUtils.isEmpty(com_ss_android_common_util_ToolUtils_android_provider_Settings$Secure_getString(context.getContentResolver(), "location_providers_allowed"))) {
                return 0;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            boolean isProviderEnabled = locationManager.isProviderEnabled("gps");
            ?? r1 = isProviderEnabled;
            if (locationManager.isProviderEnabled("network")) {
                r1 = (isProviderEnabled ? 1 : 0) | 2;
            }
            return locationManager.isProviderEnabled("passive") ? r1 | 4 : r1;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static Intent getLaunchIntentForPackage(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return launchIntentForPackage;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
            Logger.d("ToolUtils", "add category LAUNCHER in launch intent");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
        return launchIntentForPackage;
    }

    public static boolean isInstalledApp(Context context, String str) {
        if (context == null || StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo(str, 16777216) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isInstalledApp(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities;
        return (intent == null || (queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536)) == null || queryIntentActivities.size() <= 0) ? false : true;
    }

    public static void runApplication(Context context, String str, String str2) {
        Intent launchIntentForPackage;
        if ((!StringUtils.isEmpty(str) ? isInstalledApp(context, str) : false) && (launchIntentForPackage = getLaunchIntentForPackage(context, str)) != null) {
            context.startActivity(launchIntentForPackage);
            return;
        }
        if (!StringUtils.isEmpty(str2)) {
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                return;
            } catch (Exception unused) {
            }
        }
        if (StringUtils.isEmpty(str)) {
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        intent.addFlags(C.ENCODING_PCM_MU_LAW);
        try {
            context.startActivity(intent);
        } catch (Exception unused2) {
        }
    }

    public static boolean isHuaweiDevice() {
        try {
            if (StringUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                if (StringUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
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
        return (!TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) || isHuaweiDevice();
    }

    public static String getEmuiInfo() {
        if (!StringUtils.isEmpty(systemProperty)) {
            return systemProperty;
        }
        if (!bAlreadyGetProp) {
            systemProperty = SystemPropertiesUtils.getSystemProperty("ro.build.version.emui");
            bAlreadyGetProp = true;
        }
        return systemProperty;
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

    public static boolean isFlyme() {
        if (StringUtils.isEmpty(Build.DISPLAY) || Build.DISPLAY.indexOf("Flyme") < 0) {
            return !StringUtils.isEmpty(Build.USER) && Build.USER.equals("flyme");
        }
        return true;
    }

    private static String getAuthorityFromPermission(Context context, String str) {
        List<PackageInfo> installedPackages;
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            installedPackages = context.getPackageManager().getInstalledPackages(8);
        } catch (Exception unused) {
        }
        if (installedPackages == null) {
            return null;
        }
        Iterator<PackageInfo> it = installedPackages.iterator();
        while (it.hasNext()) {
            ProviderInfo[] providerInfoArr = it.next().providers;
            if (providerInfoArr != null) {
                int length = providerInfoArr.length;
                while (i < length) {
                    ProviderInfo providerInfo = providerInfoArr[i];
                    i = (str.equals(providerInfo.readPermission) || str.equals(providerInfo.writePermission)) ? 0 : i + 1;
                    return providerInfo.authority;
                }
            }
        }
        return null;
    }

    public static boolean isShortcutInstalled(Context context, String str) {
        boolean z = false;
        try {
            String authorityFromPermission = getAuthorityFromPermission(context, "com.android.launcher.permission.READ_SETTINGS");
            if (authorityFromPermission == null) {
                authorityFromPermission = "com.android.launcher.settings";
            }
            Cursor query = context.getContentResolver().query(Uri.parse("content://" + authorityFromPermission + "/favorites?notify=true"), new String[]{"title"}, "title=?", new String[]{str}, null);
            if (query != null && query.getCount() > 0) {
                z = true;
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static void installShortcut(Context context, String str) {
        CharSequence applicationLabel;
        if (context == null) {
            return;
        }
        try {
            Intent launchIntentForPackage = getLaunchIntentForPackage(context, str);
            if (launchIntentForPackage == null) {
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            String resourceName = resourcesForApplication.getResourceName(applicationInfo.icon);
            try {
                int i = packageManager.getActivityInfo(launchIntentForPackage.getComponent(), 0).labelRes;
                applicationLabel = i > 0 ? resourcesForApplication.getString(i) : null;
            } catch (Resources.NotFoundException unused) {
                applicationLabel = packageManager.getApplicationLabel(applicationInfo);
            }
            if (applicationLabel == null) {
                return;
            }
            Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent.putExtra("android.intent.extra.shortcut.NAME", applicationLabel);
            intent.putExtra("android.intent.extra.shortcut.INTENT", launchIntentForPackage);
            intent.putExtra("launch_from", 1);
            Intent.ShortcutIconResource shortcutIconResource = new Intent.ShortcutIconResource();
            shortcutIconResource.packageName = str;
            shortcutIconResource.resourceName = resourceName;
            intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcutIconResource);
            intent.putExtra("duplicate", false);
            context.sendBroadcast(intent);
        } catch (Exception e) {
            Log.w("ToolUtils", "addAppShortcut failed: " + e);
        }
    }

    public static void clearDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath());
                } else if (listFiles[i].isFile()) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public static void removeDir(String str) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath());
                } else {
                    listFiles[i].delete();
                }
            }
            file.delete();
        }
    }

    public static void clearDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath(), set);
                } else if (listFiles[i].isFile()) {
                    String name = listFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static void removeDir(String str, Set<String> set) throws Exception {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            int length = listFiles.length;
            for (int i = 0; i < length; i++) {
                if (listFiles[i].isDirectory()) {
                    removeDir(listFiles[i].getAbsolutePath(), set);
                } else {
                    String name = listFiles[i].getName();
                    if (set == null || !set.contains(name)) {
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public static long getDirectorySize(File file, boolean z) {
        long length;
        long j = 0;
        if (!file.exists() && file.isDirectory()) {
            return 0L;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                length = getDirectorySize(file2, z);
            } else if (file2.isFile()) {
                length = file2.length();
            }
            j += length;
        }
        return j;
    }

    public static void addImageMedia(Context context, String str) {
        try {
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
        } catch (Exception e) {
            Logger.w("ToolUtils", "add image media exception: " + e);
        }
    }

    public static void addImageMedia2(Context context, String str) {
        try {
            new MyMediaScannerConnectionClient(context, str).startScan();
        } catch (Exception unused) {
        }
    }

    /* loaded from: classes7.dex */
    public static class MyMediaScannerConnectionClient implements MediaScannerConnection.MediaScannerConnectionClient {
        private MediaScannerConnection conn;
        private Context mContext;
        private String mImagePath;

        public MyMediaScannerConnectionClient(Context context, String str) {
            this.mContext = context;
            this.mImagePath = str;
        }

        public void startScan() {
            MediaScannerConnection mediaScannerConnection = this.conn;
            if (mediaScannerConnection != null && mediaScannerConnection.isConnected()) {
                this.conn.disconnect();
            }
            MediaScannerConnection mediaScannerConnection2 = new MediaScannerConnection(this.mContext, this);
            this.conn = mediaScannerConnection2;
            mediaScannerConnection2.connect();
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            try {
                this.conn.scanFile(this.mImagePath, "image/*");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.conn;
            if (mediaScannerConnection != null) {
                if (mediaScannerConnection.isConnected()) {
                    this.conn.disconnect();
                }
                this.conn = null;
            }
        }
    }

    public static boolean isPackageMatchApk(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null || !packageArchiveInfo.packageName.equals(str2)) {
                return false;
            }
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 1);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i == packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isApkInstalled(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 1);
            } catch (PackageManager.NameNotFoundException unused) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isSubProcess(Context context, String str) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.endsWith(str);
    }

    public static boolean isMessageProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.endsWith(mMsgProcessSuffix);
    }

    public static boolean isNoDexProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.endsWith(NODEX_PROCESS_SUFFIX);
    }

    public static boolean isMainProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return (curProcessName == null || !curProcessName.contains(Constants.COLON_SEPARATOR)) && curProcessName != null && curProcessName.equals(context.getPackageName());
    }

    public static boolean isSafeModeProcess(Context context) {
        String curProcessName = getCurProcessName(context);
        return curProcessName != null && curProcessName.endsWith(":safe_mode");
    }

    public static long isMainProcessRetId(Context context) {
        if (isMainProcess(context)) {
            return Thread.currentThread().getId();
        }
        return 0L;
    }

    public static String getCurProcessName(Context context) {
        String str = sCurProcessName;
        if (!StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid) {
                    if (Logger.debug()) {
                        Logger.d("Process", "processName = " + runningAppProcessInfo.processName);
                    }
                    String str2 = runningAppProcessInfo.processName;
                    sCurProcessName = str2;
                    return str2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String curProcessNameFromProc = getCurProcessNameFromProc();
        sCurProcessName = curProcessNameFromProc;
        return curProcessNameFromProc;
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

    public static boolean isApplicationForeground(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (context == null || StringUtils.isEmpty(str) || (runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (str.equals(runningAppProcessInfo.processName)) {
                return runningAppProcessInfo.importance == 100;
            }
        }
        return false;
    }

    public static void createShortCut(Context context, Intent intent, String str, Bitmap bitmap) {
        if (context == null || intent == null || StringUtils.isEmpty(str) || bitmap == null || isShortcutInstalled(context, str)) {
            return;
        }
        try {
            Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
            intent2.putExtra("android.intent.extra.shortcut.NAME", str);
            intent2.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent2.putExtra("duplicate", false);
            intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
            context.sendBroadcast(intent2);
            if (Logger.debug()) {
                Logger.d("launcher_ad", "createShortCut intent " + intent.toUri(0));
            }
        } catch (Exception unused) {
        }
    }

    public static void deleteShortCut(Context context, Intent intent, String str) {
        if (context != null && intent != null && !StringUtils.isEmpty(str)) {
            try {
                Intent intent2 = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
                intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
                intent2.putExtra("android.intent.extra.shortcut.NAME", str);
                intent2.putExtra("duplicate", false);
                context.sendBroadcast(intent2);
                if (!Logger.debug()) {
                } else {
                    Logger.d("launcher_ad", "deleteShortCut intent " + intent.toUri(0));
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void startPhoneScreen(Context context, String str) {
        if (context != null && !StringUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(C.ENCODING_PCM_MU_LAW);
                }
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static void openInstalledApp(Context context, String str) {
        if (context != null && !StringUtils.isEmpty(str)) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                launchIntentForPackage.addFlags(C.ENCODING_PCM_MU_LAW);
                context.startActivity(launchIntentForPackage);
            } catch (Exception unused) {
            }
        }
    }

    public static String getProviderAuthority(Context context, String str) {
        if (context != null && !StringUtils.isEmpty(str)) {
            try {
                for (ProviderInfo providerInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers) {
                    if (str.equals(providerInfo.name)) {
                        return providerInfo.authority;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static String getDefaultBrowserString(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setDataAndType(Uri.parse(ResManager.HTTP_SCHEME), null);
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65568);
            if (queryIntentActivities.size() <= 0) {
                return "com.android.browser/com.android.browser.BrowserActivity";
            }
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                if (resolveInfo != null && resolveInfo.activityInfo != null && "com.android.browser".equals(resolveInfo.activityInfo.packageName)) {
                    return resolveInfo.activityInfo.packageName + "/" + resolveInfo.activityInfo.name;
                }
            }
            ResolveInfo resolveInfo2 = queryIntentActivities.get(0);
            return (resolveInfo2 == null || resolveInfo2.activityInfo == null) ? "com.android.browser/com.android.browser.BrowserActivity" : resolveInfo2.activityInfo.packageName + "/" + resolveInfo2.activityInfo.name;
        } catch (Exception e) {
            e.printStackTrace();
            return "com.android.browser/com.android.browser.BrowserActivity";
        }
    }

    public static String handleZipEntryGetNameLeak(String str) {
        if (StringUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (Logger.debug()) {
                Logger.d("Process", "before handle = " + str);
            }
            str = str.replaceAll(DownloadConstants.VULNERABILITY_PATH + File.separator, "");
            if (Logger.debug()) {
                Logger.d("Process", "after handle = " + str);
            }
        } catch (Exception unused) {
        }
        return str;
    }

    public static String getRunningTaskInfoString(Context context) {
        List<ActivityManager.RunningTaskInfo> runningTasks;
        if (context == null) {
            return "";
        }
        try {
            runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(5);
        } catch (Throwable unused) {
        }
        if (runningTasks == null) {
            return "";
        }
        String packageName = context.getPackageName();
        StringBuilder sb = new StringBuilder();
        for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
            if (runningTaskInfo != null && runningTaskInfo.baseActivity != null && packageName.equals(runningTaskInfo.baseActivity.getPackageName())) {
                sb.append("id = ").append(runningTaskInfo.id).append(" ");
                sb.append("description = ").append(runningTaskInfo.description).append(" ");
                sb.append("number_of_activities = ").append(runningTaskInfo.numActivities).append(" ");
                sb.append("number_of_running_activities = ").append(runningTaskInfo.numRunning).append(" ");
                sb.append("topActivity = ").append(runningTaskInfo.topActivity.toString()).append(" ");
                sb.append("baseActivity = ").append(runningTaskInfo.baseActivity.toString());
                return sb.toString();
            }
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getCacheDirPath(Context context) throws NullPointerException {
        String path;
        if (context == null) {
            throw new NullPointerException("Context is NUll");
        }
        String str = null;
        if (context.getCacheDir() != null) {
            path = context.getCacheDir().getPath();
        } else {
            File dir = context.getDir("/data/data/" + context.getPackageName() + "/cache/", 0);
            if (dir != null) {
                path = dir.getPath();
            }
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            throw new NullPointerException("Cannot Create Cache Dir");
        }
        str = path;
        if (StringUtils.isEmpty(str)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFilesDirPath(Context context) throws NullPointerException {
        String path;
        if (context == null) {
            throw new NullPointerException("Context is NUll");
        }
        String str = null;
        if (context.getFilesDir() != null) {
            path = context.getFilesDir().getPath();
        } else {
            File dir = context.getDir("/data/data/" + context.getPackageName() + "/files/", 0);
            if (dir != null) {
                path = dir.getPath();
            }
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            throw new NullPointerException("Cannot Create Files Dir");
        }
        str = path;
        if (StringUtils.isEmpty(str)) {
        }
    }

    public static boolean isServiceRunning(Context context, String str, String str2) {
        if (context == null || StringUtils.isEmpty(str)) {
            return false;
        }
        if (!StringUtils.isEmpty(str2)) {
            try {
                List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
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

    public static String getUserSerial(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService(ParsedChatMessage.ROLE_USER);
        if (systemService == null) {
            Logger.e("ToolUtils", "userManager not exsit !!!");
            return null;
        }
        try {
            Object invoke = Process.class.getMethod("myUserHandle", null).invoke(Process.class, null);
            return String.valueOf(((Long) systemService.getClass().getMethod("getSerialNumberForUser", invoke.getClass()).invoke(systemService, invoke)).longValue());
        } catch (IllegalAccessException e) {
            Logger.e("ToolUtils", "", e);
            return null;
        } catch (IllegalArgumentException e2) {
            Logger.e("ToolUtils", "", e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Logger.e("ToolUtils", "", e3);
            return null;
        } catch (InvocationTargetException e4) {
            Logger.e("ToolUtils", "", e4);
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int areNotificationsEnabled(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Reflect on = Reflect.on(appOpsManager);
            return ((Integer) on.call("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}, Integer.valueOf(((Integer) on.field("OP_POST_NOTIFICATION", Integer.TYPE).get()).intValue()), Integer.valueOf(i), packageName).get()).intValue() == 0 ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static void trySetStatusBarWithFullScreen(Window window) {
        if (window == null) {
            return;
        }
        try {
            window.clearFlags(201326592);
            window.getDecorView().setSystemUiVisibility(1792);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void setCanSetStatusBar(boolean z) {
        sCanSetStatusBar = z;
    }

    public static void trySetStatusBar(Context context, Window window, int i, boolean z) {
        if (context == null || window == null) {
            return;
        }
        try {
            if (!sCanSetStatusBar) {
                window.clearFlags(Integer.MIN_VALUE);
                return;
            }
            if (isMiui()) {
                if (z) {
                    setMiuiStatusBarDarkMode(false, window);
                } else {
                    setMiuiStatusBarDarkMode(true, window);
                }
            } else if (!isFlyme()) {
                View decorView = window.getDecorView();
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z) {
                    decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
                } else {
                    decorView.setSystemUiVisibility(systemUiVisibility | 8192);
                }
            } else if (z) {
                setFlymeStatusBarDarkMode(false, window);
            } else {
                setFlymeStatusBarDarkMode(true, window);
            }
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(context.getResources().getColor(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void setMiuiStatusBarDarkMode(boolean z, Window window) {
        try {
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void setFlymeStatusBarDarkMode(boolean z, Window window) {
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            if (z) {
                declaredField.set(attributes, Integer.valueOf(declaredField.getInt(attributes) | 512));
            } else {
                declaredField.set(attributes, Integer.valueOf(declaredField.getInt(attributes) & NetError.ERR_TTNET_FT_INVALID_STREAM));
            }
            window.setAttributes(attributes);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
