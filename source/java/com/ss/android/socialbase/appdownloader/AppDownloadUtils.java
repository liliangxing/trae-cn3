package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.constants.InstallErrorCode;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.AbsAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadFileUriProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.ApkInstallDetector;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.appdownloader.util.package_info.PackageInfoUtils;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import com.ss.ttm.player.C0968C;
import java.io.File;
import java.lang.ref.SoftReference;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloadUtils {
    public static final String BIND_APP_EXTRA = "bind_app";
    private static final String DEFAULT_CHANNEL_ID = "111111";
    private static final String DEFAULT_CHANNEL_NAME = "channel_appdownloader";
    public static final String MIUI_SECURITY_NAME = "com.miui.enterprise.service.EntInstallService";
    public static final String MIUI_SECURITY_PKG = "com.miui.securitycore";
    public static final int START_VIEW_INTENT_AND_INSTALLED = 3;
    public static final int START_VIEW_INTENT_FAILED = 0;
    public static final int START_VIEW_INTENT_INTERCEPT = 2;
    public static final int START_VIEW_INTENT_SUCCESS = 1;
    private static final String TAG = "AppDownloadUtils";
    public static final int TYPE_ACTIVE = 1;
    public static final int TYPE_COMPLETE = 3;
    public static final int TYPE_PREPARE = 4;
    public static final int TYPE_WAITING = 2;
    private static SoftReference<Activity> activityRef;
    private static boolean mStatsEnabled;
    private static int sStartViewIntentResult;
    private static Object mStatsLock = new Object();
    private static Map<String, String> mAppInstallStats = new LinkedHashMap();
    private static NotificationChannel mNotificationChannel = null;

    public static int getPackageInfoFlag() {
        return 16384;
    }

    public static void pushActivity(Activity activity) {
        activityRef = new SoftReference<>(activity);
    }

    public static Activity popActivity() {
        SoftReference<Activity> softReference = activityRef;
        Activity activity = softReference == null ? null : softReference.get();
        activityRef = null;
        return activity;
    }

    public static void addStats(String str, String str2) {
        if (!mStatsEnabled || str == null || str2 == null) {
            return;
        }
        synchronized (mStatsLock) {
            mAppInstallStats.put(str, str2);
        }
    }

    private static void beginStats(int i) {
        int optInt;
        if (AppDownloader.getInstance().getAppInstallMonitorListener() != null && (optInt = DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.APP_INSTALL_REPORT_STATS_DELAY_TIME_S)) > 0) {
            mStatsEnabled = true;
            synchronized (mStatsLock) {
                if (!mAppInstallStats.isEmpty()) {
                    if (mAppInstallStats.containsKey(String.valueOf(i))) {
                        return;
                    }
                    mAppInstallStats.put("reportStats", "Possible concurrent installation");
                    reportStats();
                }
                mAppInstallStats.put(String.valueOf(i), "id");
                ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).submitScheduleTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.AppDownloadUtils.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AppDownloadUtils.reportStats();
                    }
                }, optInt, TimeUnit.SECONDS);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportStats() {
        synchronized (mStatsLock) {
            if (mAppInstallStats.isEmpty()) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("reportStats", "Report with schedule");
                for (Map.Entry<String, String> entry : mAppInstallStats.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                AppDownloader.getInstance().getAppInstallMonitorListener().onMonitorSend(jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            mAppInstallStats.clear();
        }
    }

    private static String format(long j, long j2, String str, boolean z) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d) + " " + str;
        }
        return new DecimalFormat("#").format(d) + " " + str;
    }

    public static String bytesToHuman(long j) {
        return bytesToHuman(j, true);
    }

    public static String bytesToHuman(long j, boolean z) {
        long[] jArr = {DownloadConstants.f67TB, DownloadConstants.f64GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", TextAttributes.INLINE_BLOCK_PLACEHOLDER};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return format(j, j2, strArr[i], z);
            }
        }
        return null;
    }

    private static String formatOnSpaceError(long j, long j2, String str) {
        double d = j;
        if (j2 > 1) {
            d /= j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d) + str;
        }
        return new DecimalFormat("#.##").format(d) + str;
    }

    public static String bytesToHumanOnSpaceError(long j) {
        long[] jArr = {DownloadConstants.f67TB, DownloadConstants.f64GB, 1048576, 1024, 1};
        String[] strArr = {"TB", "GB", "MB", "KB", TextAttributes.INLINE_BLOCK_PLACEHOLDER};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        for (int i = 0; i < 5; i++) {
            long j2 = jArr[i];
            if (j >= j2) {
                return formatOnSpaceError(j, j2, strArr[i]);
            }
        }
        return null;
    }

    public static int startViewIntent(final Context context, final int i, final boolean z) {
        beginStats(i);
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.addStats(i, "AppDownloadUtils_startViewIntent", "Stack:" + Log.getStackTraceString(new Throwable()));
        }
        IBeforeAppInstallInterceptor beforeAppInstallInterceptor = AppDownloader.getInstance().getBeforeAppInstallInterceptor();
        if (beforeAppInstallInterceptor == null) {
            addStats("startViewIntent_1", "Run");
            return startViewIntentInner(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        sStartViewIntentResult = 1;
        addStats("startViewIntent_2", "Run");
        beforeAppInstallInterceptor.intercept(downloadInfo, new IAppInstallInterceptCallback() { // from class: com.ss.android.socialbase.appdownloader.AppDownloadUtils.2
            @Override // com.ss.android.socialbase.appdownloader.depend.IAppInstallInterceptCallback
            public void onInterceptFinish() {
                int unused = AppDownloadUtils.sStartViewIntentResult = AppDownloadUtils.startViewIntentInner(context, i, z);
            }
        });
        addStats("startViewIntent_3", "Run res:" + sStartViewIntentResult);
        return sStartViewIntentResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int startViewIntentInner(Context context, int i, boolean z) {
        if (DownloadSetting.obtain(i).optInt(DownloadSettingKeys.NOTIFICATION_OPT_2) == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i);
        }
        safeFinish(popActivity());
        return proxyStartViewIntent(context, i, z);
    }

    public static int proxyStartViewIntent(Context context, int i, boolean z) {
        beginStats(i);
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.addStats(i, "AppDownloadUtils_proxyStartViewIntent", "Stack:" + Log.getStackTraceString(new Throwable()));
        }
        addStats("proxyStartViewIntent_1", "ByUser:" + z);
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && !downloadInfo.isHasDoInstallation()) {
            downloadInfo.setHasDoInstallation(true);
            Downloader.getInstance(context).updateDownloadInfo(downloadInfo);
        }
        if (DownloadSetting.obtain(i).optInt("install_prepare_view_result", 1) == 1) {
            sendInstallPrepareViewResultEvent(downloadInfo, z);
        }
        if (isApkValid(downloadInfo)) {
            addStats("proxyStartViewIntent_2", "Run ApkValid url:" + downloadInfo.getUrl() + " curBytes:" + downloadInfo.getCurBytes() + " totalBytes:" + downloadInfo.getTotalBytes());
            if (!TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
                DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
                if (downloadFile.exists()) {
                    startInstallView(context, i, z, downloadFile, downloadInfo);
                    return 1;
                }
                addStats("proxyStartViewIntent_5", "File Not Found:" + downloadInfo.toDetailString());
            } else {
                addStats("proxyStartViewIntent_3", "Run ApkValid and info error:" + downloadInfo.toDetailString());
            }
        } else {
            addStats("proxyStartViewIntent_4", "ApkInvalid:" + downloadInfo);
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "installApk", "App invalid");
            }
        }
        sendInstallViewResultEvent(downloadInfo, z, 2);
        return 2;
    }

    private static void startInstallView(final Context context, final int i, final boolean z, final DownloadFile downloadFile, final DownloadInfo downloadInfo) {
        DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.AppDownloadUtils.3
            @Override // java.lang.Runnable
            public void run() {
                ((IDownloadReceiverService) AppDownloadServiceManager.getService(IDownloadReceiverService.class)).tryRegisterTempAppInstallDownloadReceiver(0);
                int realStartViewIntent = AppDownloadUtils.realStartViewIntent(context, i, z, downloadInfo, downloadFile.getFile());
                if (realStartViewIntent == 1 && AppDownloader.getInstance().getOpenInstallerListener() != null) {
                    AppDownloader.getInstance().getOpenInstallerListener().onOpenInstaller(downloadInfo, null);
                }
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(AppDownloadUtils.TAG, downloadInfo, "startInstallView", "Result:" + realStartViewIntent);
                }
                AppDownloadUtils.sendInstallViewResultEvent(downloadInfo, z, realStartViewIntent);
                ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorDownloadApp(downloadInfo, Constants.APP_INSTALL_START_VIEW, realStartViewIntent);
            }
        });
    }

    public static boolean isApkValid(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType())) {
            return true;
        }
        if (TextUtils.isEmpty(downloadInfo.getUrl()) || !downloadInfo.getUrl().endsWith(Constants.APK_SUFFIX)) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && downloadInfo.getName().endsWith(Constants.APK_SUFFIX);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendInstallViewResultEvent(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            addStats("sendInstallViewResultEvent_1", "DownloadInfo is null");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put(RegistrationHeaderHelper.KEY_REAL_PACKAGE_NAME, downloadInfo.getFilePackageName());
            addStats("sendInstallViewResultEvent_2", "Stats:" + jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
            addStats("sendInstallViewResultEvent_2", "Error:" + e);
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    private static void sendInstallPrepareViewResultEvent(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put(RegistrationHeaderHelper.KEY_REAL_PACKAGE_NAME, downloadInfo.getFilePackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), "install_prepare_view_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0086, code lost:
    
        if (r0 == null) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int realStartViewIntent(Context context, int i, boolean z, DownloadInfo downloadInfo, File file) {
        PackageInfo packageInfo;
        Intent buildViewIntent;
        Process process;
        addStats("realStartViewIntent_1", "Path:" + (file != null ? file.getAbsolutePath() : "null"));
        File dataDirectory = DownloadDirUtils.getDataDirectory(false);
        if (dataDirectory != null && file.getPath().startsWith(dataDirectory.getAbsolutePath())) {
            try {
                process = Runtime.getRuntime().exec("chmod 555 " + file.getAbsolutePath());
                try {
                    process.waitFor();
                } catch (Throwable th) {
                    th = th;
                    try {
                        th.printStackTrace();
                        addStats("realStartViewIntent_2", "Error:" + th);
                        Logger.taskError(TAG, i, "realStartViewIntent", "Error:" + th);
                    } finally {
                        if (process != null) {
                            process.destroy();
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                process = null;
            }
        }
        addStats("realStartViewIntent_11", "Before Parse PackageInfo");
        try {
            packageInfo = getPackageInfo(downloadInfo, file);
            if (packageInfo != null) {
                try {
                    downloadInfo.setFilePackageName(packageInfo.packageName);
                } catch (Throwable th3) {
                    th = th3;
                    Logger.taskError(TAG, i, "realStartViewIntent", "Error:" + th);
                    addStats("realStartViewIntent_3", "Error:" + th);
                    addStats("realStartViewIntent_4", getPackageInfoLog(packageInfo));
                    if (Logger.debugScene(downloadInfo)) {
                    }
                    if (AppDownloader.getInstance().getAppDownloadMonitorListener() != null) {
                    }
                    if (!forbidInstallWhenPkgNameError(context, downloadInfo, packageInfo)) {
                    }
                }
            }
            th = null;
        } catch (Throwable th4) {
            th = th4;
            packageInfo = null;
        }
        addStats("realStartViewIntent_4", getPackageInfoLog(packageInfo));
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", getPackageInfoLog(packageInfo));
        }
        if (AppDownloader.getInstance().getAppDownloadMonitorListener() != null) {
            if (packageInfo == null) {
                BaseException baseException = new BaseException(2001, th);
                AppDownloader.getInstance().getAppDownloadMonitorListener().onAppDownloadMonitorSend(downloadInfo, baseException, baseException.getErrorCode());
            } else {
                AppDownloader.getInstance().getAppDownloadMonitorListener().onAppDownloadMonitorSend(downloadInfo, null, 11);
            }
        }
        if (!forbidInstallWhenPkgNameError(context, downloadInfo, packageInfo)) {
            addStats("realStartViewIntent_5", "ForbidInstall");
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", "Forbid install");
            }
            return 2;
        }
        if (packageInfo != null) {
            downloadInfo.getTempCacheData().put(Constants.EXTRA_APK_PACKAGE_NAME, packageInfo.packageName);
            downloadInfo.getTempCacheData().put(Constants.EXTRA_APK_VERSION_CODE, Integer.valueOf(packageInfo.versionCode));
        }
        int[] iArr = new int[1];
        if (isApkInstalled(context, downloadInfo, packageInfo)) {
            addStats("realStartViewIntent_6", "IsApkInstalled");
            buildViewIntent = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", "Apk installed");
            }
        } else {
            if (!validateExternalMD5(context, downloadInfo)) {
                return 0;
            }
            ApkInstallDetector.getInstance().start(context, downloadInfo, packageInfo);
            addStats("realStartViewIntent_7", "IsApkUnInstalled");
            if (!z && silentInstallOnMiui(context, i, file)) {
                downloadInfo.getTempCacheData().put(Constants.EXTRA_SILENT_INSTALL_SUCCEED, true);
                return 1;
            }
            buildViewIntent = buildViewIntent(context, downloadInfo, file, z, iArr);
        }
        if (buildViewIntent == null) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", "Intent is null");
            }
            addStats("realStartViewIntent_8", "Intent is null");
            return iArr[0] == 1 ? 2 : 0;
        }
        if (DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.APP_INSTALL_REMOVE_FLAG_ACTIVITY_NEW_TASK) <= 0) {
            buildViewIntent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
        }
        if (downloadInfo.getLinkMode() > 0 && DownloadSetting.obtain(downloadInfo.getId()).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_APP_INSTALL_RETURN_RESULT, 0) == 1) {
            buildViewIntent.putExtra("android.intent.extra.RETURN_RESULT", true);
        }
        if (iArr[0] == 0) {
            addStats("realStartViewIntent_9", "AntiHijack:" + buildViewIntent + " byUser:" + z);
            boolean antiHijack = AhUtils.antiHijack(context, downloadInfo, buildViewIntent, z);
            addStats("realStartViewIntent_10", "res:" + antiHijack);
            if (antiHijack) {
                return 1;
            }
        }
        String installBizType = downloadInfo.getInstallBizType();
        if (!TextUtils.isEmpty(installBizType)) {
            buildViewIntent.putExtra(SpJsonConstants.KEY_INSTALL_BIZ_TYPE, installBizType);
        }
        String installCertId = downloadInfo.getInstallCertId();
        if (!TextUtils.isEmpty(installCertId)) {
            buildViewIntent.putExtra(SpJsonConstants.KEY_INSTALL_CERT_ID, installCertId);
        }
        String installBizParamsJson = downloadInfo.getInstallBizParamsJson();
        if (!TextUtils.isEmpty(installBizParamsJson)) {
            buildViewIntent.putExtra(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON, installBizParamsJson);
        }
        return startPackageInstaller(context, buildViewIntent);
    }

    private static boolean validateExternalMD5(Context context, DownloadInfo downloadInfo) {
        if (!DownloadFileUtils.isExternalDownloadEnabled() || !DownloadFileUtils.isMediaUri(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getMd5())) {
            return true;
        }
        if (DownloadUtils.isMd5Valid(DownloadUtils.checkMd5Status(downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getMd5()))) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", "Uri Md5 verification success");
            }
            return true;
        }
        addStats("validateExternalMD5", "Uri Md5 verification failed" + downloadInfo.getMd5());
        IAppDownloadMonitorListener appDownloadMonitorListener = AppDownloader.getInstance().getAppDownloadMonitorListener();
        if (appDownloadMonitorListener != null) {
            BaseException baseException = new BaseException(InstallErrorCode.ERROR_TTMD5, "Uri Md5 verification failed" + downloadInfo.getMd5());
            appDownloadMonitorListener.onAppDownloadMonitorSend(downloadInfo, baseException, baseException.getErrorCode());
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "realStartViewIntent", "Uri Md5 verification failed " + downloadInfo.getMd5());
        }
        downloadInfo.setMd5(null);
        Downloader.getInstance(context).updateDownloadInfo(downloadInfo);
        DownloadUtils.deleteAllDownloadFiles(downloadInfo);
        return false;
    }

    public static int startPackageInstaller(Context context, Intent intent) {
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.report();
        }
        try {
            addStats("startPackageInstaller_1", "Intent:" + intent);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "startPackageInstaller", "Intent:" + intent);
            }
            if (AppDownloader.getInstance().getInstallAppHandler() != null && AppDownloader.getInstance().getInstallAppHandler().installApp(intent)) {
                addStats("startPackageInstaller_2", "InstallAppHandler");
                return 1;
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "startPackageInstaller", "Error1:" + th);
            addStats("startPackageInstaller_3", "Error:" + th);
        }
        try {
            IDownloadAppInstallHandler appInstallHandler = AppDownloader.getInstance().getAppInstallHandler();
            if (appInstallHandler != null) {
                appInstallHandler.startActivity(context, intent);
            } else {
                context.startActivity(intent);
            }
            addStats("startPackageInstaller_4", "Install success");
            return 1;
        } catch (Throwable th2) {
            addStats("startPackageInstaller_5", "Error:" + th2);
            Logger.globalError(TAG, "startPackageInstaller", "Error2:" + th2);
            return 0;
        }
    }

    public static boolean forbidInstallWhenPkgNameError(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        IAppDownloadEventHandler appDownloadEventHandler = AppDownloader.getInstance().getAppDownloadEventHandler();
        if (appDownloadEventHandler != null) {
            appDownloadEventHandler.handleAppInstallError(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (appDownloadEventHandler instanceof AbsAppDownloadEventHandler) {
                if (((AbsAppDownloadEventHandler) appDownloadEventHandler).isForbidInvalidatePackageInstall(downloadInfo)) {
                    return true;
                }
            } else if (appDownloadEventHandler.isForbidInvalidatePackageInstall()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener == null) {
            return false;
        }
        downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
        IAppDownloadDepend appDownloadDepend = AppDownloader.getInstance().getAppDownloadDepend();
        return (appDownloadDepend instanceof AbsAppDownloadDepend) && ((AbsAppDownloadDepend) appDownloadDepend).isForbiddenInstallForInvalidatePackageName(downloadInfo);
    }

    public static boolean silentInstallOnMiui(Context context, int i, File file) {
        if (DownloadSetting.obtain(i).optInt(DownloadSettingKeys.BACK_MIUI_SILENT_INSTALL, 1) == 1) {
            return false;
        }
        if ((RomUtils.isMiuiV10() || RomUtils.isMiuiV11()) && SystemUtils.checkServiceExists(context, MIUI_SECURITY_PKG, MIUI_SECURITY_NAME)) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(MIUI_SECURITY_PKG, MIUI_SECURITY_NAME));
            Bundle bundle = new Bundle();
            bundle.putInt("userId", 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", MIUI_SECURITY_PKG);
            intent.putExtras(bundle);
            addStats("silentInstallOnMiui_1", "Intent:" + intent);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                addStats("silentInstallOnMiui_2", "Error:" + e);
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Uri getUriForFile(DownloadInfo downloadInfo, IDownloadFileUriProvider iDownloadFileUriProvider, Context context, String str, File file) {
        Uri fromFile;
        addStats("getUriForFile_1", "Authority:" + str + " apkFile:" + (file != null ? file.getAbsolutePath() : "null"));
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "getUriForFile", "Authority:" + str + " apkFile:" + (file != null ? file.getAbsolutePath() : "null"));
        }
        if (DownloadFileUtils.isExternalDownloadEnabled() && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath())) {
            return Uri.parse(downloadInfo.getSavePath());
        }
        Uri uri = null;
        if (DownloadFileUtils.isScopedStorage()) {
            if (DownloadFileUtils.isMediaUri(downloadInfo.getSavePath()) && DownloadFileUtils.exists(Uri.parse(downloadInfo.getSavePath()))) {
                uri = Uri.parse(downloadInfo.getSavePath());
            }
            if (Build.VERSION.SDK_INT >= 29 && DownloadFileUtils.isFilePathInExternalPublicDir(file.getPath())) {
                uri = DownloadFileUtils.getUriFromFilePath(file.getPath());
            }
            if (uri != null) {
                addStats("getUriForFile_2", "LocalUri:" + uri);
                return uri;
            }
        }
        if (iDownloadFileUriProvider != null) {
            try {
                uri = iDownloadFileUriProvider.getUriForFile(str, file.getAbsolutePath());
            } catch (Throwable th) {
                addStats("getUriForFile_3", "Error:" + th);
            }
        } else {
            IAppDownloadFileUriProvider appFileUriProvider = AppDownloader.getInstance().getAppFileUriProvider();
            if (appFileUriProvider != null) {
                try {
                    uri = appFileUriProvider.getUriForFile(downloadInfo.getId(), str, file.getAbsolutePath());
                } catch (Throwable th2) {
                    addStats("getUriForFile_4", "Error:" + th2);
                    Logger.taskError(TAG, downloadInfo.getId(), "getUriForFile", "Error for appFileUriProvider:" + th2);
                }
            }
        }
        if (uri == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    str = DownloadSetting.obtain(downloadInfo.getId()).optString(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.FILE_PROVIDER_AUTHORITY);
                }
                if (!TextUtils.isEmpty(str)) {
                    fromFile = FileProvider.getUriForFile(context, str, file);
                } else {
                    fromFile = Uri.fromFile(file);
                }
                uri = fromFile;
            } catch (Throwable th3) {
                th3.printStackTrace();
                addStats("getUriForFile_5", "Error:" + th3);
                Logger.taskError(TAG, downloadInfo.getId(), "getUriForFile", "Error for system FileProvider:" + th3);
            }
        }
        addStats("getUriForFile_6", "LocalUri" + uri);
        return uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Intent buildViewIntent(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        addStats("buildViewIntent_1", "Run");
        Uri uriForFile = getUriForFile(downloadInfo, Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, AppDownloader.getInstance().getFileProviderAuthority(), file);
        if (uriForFile == null) {
            addStats("buildViewIntent_2", "LocalUri is null");
            return null;
        }
        addStats("buildViewIntent_3", "LocalUri:" + uriForFile);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(1);
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        String sysPackageInstaller = RomUtils.getSysPackageInstaller(context);
        if (!TextUtils.isEmpty(sysPackageInstaller)) {
            intent.setPackage(sysPackageInstaller);
        }
        IAppDownloadEventHandler appDownloadEventHandler = AppDownloader.getInstance().getAppDownloadEventHandler();
        int installIntercept = appDownloadEventHandler != null ? appDownloadEventHandler.installIntercept(downloadInfo.getId(), z) : 0;
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        int i = installIntercept;
        if (downloadNotificationEventListener != null) {
            i = downloadNotificationEventListener.interceptAfterNotificationSuccess(z);
        }
        iArr[0] = i;
        if (i == 0) {
            return intent;
        }
        addStats("buildViewIntent_4", "Intercept");
        return null;
    }

    public static boolean isPackageNameValid(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && isPackageNameEqualsWithApk(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean isPackageNameEqualsWithApk(Context context, DownloadInfo downloadInfo, String str) {
        if (context == null) {
            return false;
        }
        try {
            DownloadFile downloadFile = new DownloadFile(downloadInfo.getSavePath(), downloadInfo.getName());
            PackageInfo packageInfo = null;
            if (downloadFile.exists()) {
                if (Logger.debugScene(downloadInfo)) {
                    Logger.taskDebug(TAG, downloadInfo, "isPackageNameEqualsWithApk", "fileName:" + downloadInfo.getName() + " apkFileSize：" + downloadFile.length() + " fileUrl：" + downloadInfo.getUrl());
                }
                PackageInfo packageInfo2 = getPackageInfo(downloadInfo, downloadFile.getFile());
                if (packageInfo2 == null || !packageInfo2.packageName.equals(str)) {
                    return false;
                }
                int i = packageInfo2.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, getPackageInfoFlag());
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (packageInfo == null || i != packageInfo.versionCode) {
                    return false;
                }
            } else {
                String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get(Constants.EXTRA_APK_PACKAGE_NAME), null);
                int i2 = DownloadUtils.getInt(downloadInfo.getTempCacheData().get(Constants.EXTRA_APK_VERSION_CODE), 0);
                if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                    return false;
                }
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, getPackageInfoFlag());
                } catch (PackageManager.NameNotFoundException unused2) {
                }
                if (packageInfo == null || i2 != packageInfo.versionCode) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isApkInstalled(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "isApkInstalled", "Run" + downloadInfo);
        }
        return isApkInstalled(context, downloadInfo, packageInfo, false);
    }

    public static boolean isApkInstalled(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        PackageInfo packageInfo2 = getPackageInfo(context, str);
        if (packageInfo2 == null || !isApkInstalledByLaunchIntent(context, str)) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        return z ? i < i2 : (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.INSTALL_WITH_SAME_VERSION_CODE, 0) != 1) ? i <= i2 : i < i2;
    }

    public static boolean isApkInstalledByLaunchIntent(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    return packageManager.getLaunchIntentForPackage(str) != null;
                }
            } catch (Exception e) {
                addStats("isApkInstalledByLaunchIntent", "Error:" + e + " packageName:" + str);
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean isApkInstalled(Context context, DownloadInfo downloadInfo) {
        return isApkInstalled(context, downloadInfo, true);
    }

    public static boolean isApkInstalled(Context context, DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0 || !z) {
            PackageInfo packageInfo = getPackageInfo(context, packageName);
            if (packageInfo != null && isApkInstalledByLaunchIntent(context, packageName)) {
                return DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.INSTALL_WITH_SAME_VERSION_CODE, 0) == 1 ? appVersionCode < packageInfo.versionCode : appVersionCode <= packageInfo.versionCode;
            }
            return false;
        }
        return isApkInstalledByFile(context, downloadInfo);
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, getPackageInfoFlag());
        } catch (PackageManager.NameNotFoundException e) {
            addStats("getPackageInfo", "Error:" + e + " packageName:" + str);
            return null;
        }
    }

    private static void reportViaMonitorListener(String str, String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    public static int getApkFileVersionCode(Context context, DownloadInfo downloadInfo) {
        if (context != null && downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            int appVersionCode = downloadInfo.getAppVersionCode();
            if (appVersionCode > 0) {
                return appVersionCode;
            }
            try {
                PackageInfo parseApkFile = parseApkFile(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
                if (parseApkFile != null) {
                    int i = parseApkFile.versionCode;
                    downloadInfo.setAppVersionCode(i);
                    return i;
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    public static boolean isApkInstalledByFile(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return isApkInstalled(context, downloadInfo, parseApkFile(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static boolean isApkInstalled(Context context, String str, String str2) {
        return isApkInstalled(context, (DownloadInfo) null, parseApkFile(context, null, str, str2));
    }

    public static boolean isApkInstalled(Context context, String str, String str2, boolean z) {
        return isApkInstalled(context, (DownloadInfo) null, parseApkFile(context, null, str, str2), z);
    }

    public static PackageInfo parseApkFile(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        DownloadFile downloadFile = new DownloadFile(str, str2);
        if (!downloadFile.exists()) {
            return null;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "parseApkFile", "IsApkInstalled apkFileSize：fileName:" + downloadFile.getPath() + " apkFileSize" + downloadFile.length());
        }
        return getPackageInfo(downloadInfo, downloadFile.getFile());
    }

    public static String createFileName(AppTaskBuilder appTaskBuilder, boolean z) {
        String url = appTaskBuilder.getUrl();
        String saveName = appTaskBuilder.getSaveName();
        String name = appTaskBuilder.getName();
        if (TextUtils.isEmpty(saveName)) {
            saveName = getValidName(url, name, appTaskBuilder.getMimeType(), z);
        }
        return saveName.length() > 255 ? saveName.substring(saveName.length() - 255) : saveName;
    }

    public static String getValidName(String str, String str2, String str3) {
        return getValidName(str, str2, str3, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        if (android.text.TextUtils.isEmpty(r2) == false) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getValidName(String str, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        if (z) {
            if (TextUtils.isEmpty(str2)) {
                if (!TextUtils.isEmpty(parse.getLastPathSegment())) {
                    str2 = parse.getLastPathSegment();
                }
                str2 = "default.apk";
            }
            return (!isApkMineType(str3) || str2.endsWith(Constants.APK_SUFFIX)) ? str2 : str2 + Constants.APK_SUFFIX;
        }
        String lastPathSegment = parse.getLastPathSegment();
        if (!TextUtils.isEmpty(lastPathSegment)) {
            str2 = lastPathSegment;
        }
        if (isApkMineType(str3)) {
            return str2;
        }
    }

    public static String getAppDownloadPath(Context context) {
        return getAppDownloadPath();
    }

    public static String getAppDownloadPath() {
        return DownloadUtils.getDownloadPath();
    }

    public static String getRedirectDir(String str, DownloadSetting downloadSetting) {
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            return "";
        }
        String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
        if (!TextUtils.isEmpty(optString) && optString.startsWith("/")) {
            optString = optString.substring(1);
        }
        if (TextUtils.isEmpty(optString)) {
            return optString;
        }
        if (!optString.contains("%s")) {
            format = optString + str;
        } else {
            try {
                format = String.format(optString, str);
            } catch (Throwable unused) {
            }
        }
        optString = format;
        return optString.length() > 255 ? optString.substring(optString.length() - 255) : optString;
    }

    public static boolean isBindApp(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject(str).optBoolean("bind_app", false);
    }

    public static boolean canNotAutoInstall(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (!jSONObject.optBoolean("bind_app", false)) {
            if (jSONObject.optBoolean(Constants.AUTO_INSTALL_WITH_NOTIFICATION, true)) {
                return false;
            }
        }
        return true;
    }

    public static int getNotificationType(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    public static boolean isApkMineType(String str) {
        return !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive");
    }

    public static boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0035, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r1.recycle();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
    
        if (r1 != null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isMaterialNotification(Context context) {
        if (context == null) {
            return false;
        }
        TypedArray typedArray = null;
        try {
            int color = context.getResources().getColor(AppResourceUtils.getNotificationTitleColor());
            typedArray = context.obtainStyledAttributes(AppResourceUtils.getNotificationTitleStyle(), new int[]{AppResourceUtils.getAndroidTextColor(), AppResourceUtils.getAndroidTextSize()});
            if (color == typedArray.getColor(0, 0)) {
                if (typedArray != null) {
                    try {
                        typedArray.recycle();
                    } catch (Throwable unused) {
                    }
                }
                return true;
            }
        } catch (Throwable unused2) {
        }
    }

    public static String getNotificationChannelId(Context context) {
        try {
            if (mNotificationChannel == null) {
                NotificationChannel notificationChannel = new NotificationChannel(DEFAULT_CHANNEL_ID, DEFAULT_CHANNEL_NAME, 3);
                mNotificationChannel = notificationChannel;
                notificationChannel.setSound(null, null);
                mNotificationChannel.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(mNotificationChannel);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return DEFAULT_CHANNEL_ID;
    }

    public static List<String> getApplicationMimeTypes() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add("application/vnd.android.package-archive");
        arrayList.add(Constants.MIME_PATCH);
        return arrayList;
    }

    public static void createDownloadTask(DownloadInfo downloadInfo, boolean z, boolean z2) {
        AppDownloader.getInstance().addDownloadTask(new AppTaskBuilder(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).name(downloadInfo.getTitle()).saveName(downloadInfo.getName()).savePath(downloadInfo.getSavePath()).showNotification(downloadInfo.isShowNotification()).autoInstallWithoutNotification(downloadInfo.isAutoInstallWithoutNotification()).needWifi(downloadInfo.isOnlyWifi() || z2).extra(downloadInfo.getExtra()).mimeType(downloadInfo.getMimeType()).headers(downloadInfo.getExtraHeaders()).autoResumed(true).monitorScene(downloadInfo.getMonitorScene() == null ? "createDownloadTask" : downloadInfo.getMonitorScene()).setCacheLifeTimeMax(downloadInfo.getCacheLifeTimeMax()).retryCount(downloadInfo.getRetryCount()).backUpUrlRetryCount(downloadInfo.getBackUpUrlRetryCount()).backUpUrls(downloadInfo.getBackUpUrls()).minProgressTimeMsInterval(downloadInfo.getMinProgressTimeMsInterval()).maxProgressCount(downloadInfo.getMaxProgressCount()).showNotificationForAutoResumed(z).needHttpsToHttpRetry(downloadInfo.isNeedHttpsToHttpRetry()).packageName(downloadInfo.getPackageName()).md5(downloadInfo.getMd5()).expectFileLength(downloadInfo.getExpectFileLength()).needDefaultHttpServiceBackUp(downloadInfo.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(downloadInfo.isNeedIndependentProcess()).enqueueType(downloadInfo.getEnqueueType()).force(downloadInfo.isForce()).pcdnUrls(downloadInfo.getPcdnUrls()).cdnUrls(downloadInfo.getCdnUrls()).downloadSetting(createJSONObject(downloadInfo.getDownloadSettingString())).iconUrl(downloadInfo.getIconUrl()).executorGroup(downloadInfo.getExecutorGroup()).autoInstall(downloadInfo.isAutoInstall()).taskKey(downloadInfo.getTaskKey()).ignoreInterceptor(downloadInfo.isIgnoreInterceptor()));
    }

    private static JSONObject createJSONObject(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void safeFinish(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static PackageInfo getPackageInfo(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return PackageInfoUtils.getPackageInfo(DownloadComponentManager.getAppContext(), file, getPackageInfoFlag());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        boolean z = DownloadSetting.obtainGlobal().optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_APP_PACKAGE_INFO_CACHE) > 0;
        if (z && packageInfo == null && (packageInfo = downloadInfo.getPackageInfoWithCache()) != null) {
            downloadInfo.setPackageInfo(packageInfo);
            return packageInfo;
        }
        if (packageInfo == null) {
            packageInfo = PackageInfoUtils.getPackageInfo(DownloadComponentManager.getAppContext(), file, getPackageInfoFlag());
            downloadInfo.setPackageInfo(packageInfo);
            if (z && packageInfo != null) {
                downloadInfo.setPackageInfoToCache(packageInfo);
                if (!DownloadUtils.isMainThread()) {
                    Downloader.getInstance(DownloadComponentManager.getAppContext()).updateDownloadInfo(downloadInfo);
                }
            }
        }
        return packageInfo;
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static String getPackageInfoLog(PackageInfo packageInfo) {
        return packageInfo == null ? "PackageInfo is null" : "PackageInfo: packageName:" + packageInfo.packageName + " versionCode:" + packageInfo.versionCode + " versionName:" + packageInfo.versionName;
    }
}
