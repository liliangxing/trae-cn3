package com.ss.android.socialbase.appdownloader.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.SystemClock;
import com.ss.android.socialbase.appdownloader.AppDownloadUtils;
import com.ss.android.socialbase.appdownloader.AppDownloader;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallDetectorListener;
import com.ss.android.socialbase.appdownloader.depend.IPrivacyPolicyCallback;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ApkInstallDetector implements AppStatusManager.AppStatusChangeListener {
    private static final String TAG = "ApkInstallDetector";
    private IAppInstallDetectorListener mAppInstallDetectorListener;
    private Map<Integer, DetectItem> mBackgroundDownloadInfo;
    private volatile boolean mIsRunDetector;
    private Object mLock;
    private Map<Integer, DetectItem> mMonitorDownloadInfo;
    private AtomicBoolean mRegisterAppStatusManager;

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppBackground() {
    }

    private ApkInstallDetector() {
        this.mLock = new Object();
        this.mMonitorDownloadInfo = new ConcurrentHashMap();
        this.mBackgroundDownloadInfo = new ConcurrentHashMap();
        this.mRegisterAppStatusManager = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class SingletonHolder {
        private static final ApkInstallDetector INSTANCE = new ApkInstallDetector();

        private SingletonHolder() {
        }
    }

    public static ApkInstallDetector getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DetectItem {
        long detectCount;
        DownloadInfo downloadInfo;
        PackageInfo packageInfo;
        long time;

        private DetectItem(DownloadInfo downloadInfo, PackageInfo packageInfo) {
            this.time = SystemClock.uptimeMillis();
            this.downloadInfo = downloadInfo;
            this.packageInfo = packageInfo;
        }
    }

    public void start(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        start(context, downloadInfo, packageInfo, DownloadSetting.getGlobalSettings());
    }

    public void start(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, JSONObject jSONObject) {
        try {
            startImpl(context, downloadInfo, packageInfo, jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
            Logger.globalError(TAG, "start", "Error:" + th);
        }
    }

    private void startImpl(final Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, JSONObject jSONObject) {
        IPrivacyPolicyCallback privacyPolicyCallback = AppDownloader.getInstance().getPrivacyPolicyCallback();
        if (privacyPolicyCallback != null && !privacyPolicyCallback.isUserAgreePrivacyPolicy()) {
            Logger.globalError(TAG, "startImpl", "Before UserAgreePrivacyPolicy:" + downloadInfo);
            return;
        }
        if (context == null || packageInfo == null || downloadInfo == null || jSONObject == null) {
            Logger.globalError(TAG, "startImpl", "Disable downloadInfo:" + downloadInfo);
            return;
        }
        final int optInt = jSONObject.optInt(DownloadSettingKeys.APP_INSTALL_DETECT_INTERVAL_MS, 2000);
        final int optInt2 = jSONObject.optInt(DownloadSettingKeys.APP_INSTALL_DETECT_COUNT, 400);
        final int optInt3 = jSONObject.optInt(DownloadSettingKeys.APP_BACKGROUND_INSTALL_DETECT_LIMIT_S, 120);
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "startImpl", "DetectInterval:" + optInt + " detectCount:" + optInt2 + " backgroundLimitTime:" + optInt3);
        }
        if (optInt <= 0 || optInt2 <= 0) {
            return;
        }
        if (Logger.debugScene(downloadInfo)) {
            Logger.taskDebug(TAG, downloadInfo, "startImpl", "PackageInfo:" + packageInfo);
        }
        registerAppStatusManager(context);
        if (this.mBackgroundDownloadInfo.containsKey(Integer.valueOf(downloadInfo.getId()))) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, downloadInfo, "startImpl", "In background");
                return;
            }
            return;
        }
        synchronized (this.mLock) {
            this.mMonitorDownloadInfo.put(Integer.valueOf(downloadInfo.getId()), new DetectItem(downloadInfo, packageInfo));
            if (this.mIsRunDetector) {
                return;
            }
            this.mIsRunDetector = true;
            DownloadComponentManager.getApkInstallThreadExecutor().submit(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.util.ApkInstallDetector.1
                /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void run() {
                    if (Logger.debug()) {
                        Logger.globalDebug(ApkInstallDetector.TAG, "run", "Before");
                    }
                    beforeDetect();
                    try {
                        runDetect();
                    } finally {
                        try {
                            if (Logger.debug()) {
                            }
                        } finally {
                        }
                    }
                    if (Logger.debug()) {
                        return;
                    }
                    Logger.globalDebug(ApkInstallDetector.TAG, "run", "After");
                }

                private void beforeDetect() {
                    if (ApkInstallDetector.this.mAppInstallDetectorListener == null) {
                        return;
                    }
                    try {
                        ApkInstallDetector.this.mAppInstallDetectorListener.onStart();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                private void afterDetect() {
                    if (ApkInstallDetector.this.mAppInstallDetectorListener == null) {
                        return;
                    }
                    try {
                        ApkInstallDetector.this.mAppInstallDetectorListener.onFinish();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                private void runDetect() {
                    SystemClock.sleep(optInt);
                    while (true) {
                        synchronized (ApkInstallDetector.this.mLock) {
                            if (ApkInstallDetector.this.mMonitorDownloadInfo.isEmpty()) {
                                ApkInstallDetector.this.mIsRunDetector = false;
                                return;
                            }
                        }
                        Iterator it = ApkInstallDetector.this.mMonitorDownloadInfo.values().iterator();
                        while (it.hasNext()) {
                            DetectItem detectItem = (DetectItem) it.next();
                            if (canCheckPackageInfo(detectItem) && AppDownloadUtils.isApkInstalled(context, detectItem.downloadInfo, detectItem.packageInfo)) {
                                if (Logger.debugScene(detectItem.downloadInfo)) {
                                    Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "runDetect", "Installed detectCount:" + detectItem.detectCount + " duration:" + (SystemClock.uptimeMillis() - detectItem.time));
                                }
                                ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).handleApkInstalled(detectItem.packageInfo.packageName);
                                it.remove();
                            } else {
                                long j = detectItem.detectCount + 1;
                                detectItem.detectCount = j;
                                if (j > optInt2) {
                                    if (Logger.debugScene(detectItem.downloadInfo)) {
                                        Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "runDetect", "Not Installed detectCount:" + detectItem.detectCount + " duration:" + (SystemClock.uptimeMillis() - detectItem.time));
                                    }
                                    it.remove();
                                    if (AppStatusManager.getInstance().isAppBackground()) {
                                        ApkInstallDetector.this.mBackgroundDownloadInfo.put(Integer.valueOf(detectItem.downloadInfo.getId()), detectItem);
                                    }
                                }
                            }
                        }
                        SystemClock.sleep(optInt);
                    }
                }

                private boolean canCheckPackageInfo(DetectItem detectItem) {
                    if (AppStatusManager.getInstance().isAppForeground() || optInt3 < 0) {
                        if (Logger.debugScene(detectItem.downloadInfo)) {
                            Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "canCheckPackageInfo", "Foreground");
                        }
                        return true;
                    }
                    long uptimeMillis = (SystemClock.uptimeMillis() - detectItem.time) / 1000;
                    if (uptimeMillis < optInt3) {
                        if (Logger.debugScene(detectItem.downloadInfo)) {
                            Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "canCheckPackageInfo", "BackgroundTime: " + uptimeMillis + " < backgroundLimitTime:" + optInt3);
                        }
                        return true;
                    }
                    if (!Logger.debugScene(detectItem.downloadInfo)) {
                        return false;
                    }
                    Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "canCheckPackageInfo", "Can't detect");
                    return false;
                }
            });
        }
    }

    private void registerAppStatusManager(Context context) {
        if (this.mRegisterAppStatusManager.compareAndSet(false, true)) {
            try {
                AppStatusManager.getInstance().init(context);
                AppStatusManager.getInstance().registerAppSwitchListener(this);
            } catch (Throwable th) {
                th.printStackTrace();
                Logger.globalError(TAG, "startImpl", "Error:" + th);
                this.mRegisterAppStatusManager.set(false);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
    public void onAppForeground() {
        if (this.mBackgroundDownloadInfo.isEmpty()) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        Iterator<DetectItem> it = this.mBackgroundDownloadInfo.values().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        this.mBackgroundDownloadInfo.clear();
        DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.util.ApkInstallDetector.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    checkApkInstall();
                } catch (Throwable th) {
                    th.printStackTrace();
                    Logger.globalError(ApkInstallDetector.TAG, "onAppForeground", "Error:" + th);
                }
            }

            private void checkApkInstall() {
                int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.APP_INSTALL_DETECT_INTERVAL_MS);
                if (optInt <= 0) {
                    return;
                }
                for (DetectItem detectItem : arrayList) {
                    SystemClock.sleep(optInt);
                    if (AppDownloadUtils.isApkInstalled(DownloadComponentManager.getAppContext(), detectItem.downloadInfo, detectItem.packageInfo)) {
                        if (Logger.debugScene(detectItem.downloadInfo)) {
                            Logger.taskDebug(ApkInstallDetector.TAG, detectItem.downloadInfo, "checkApkInstall", "Installed detectCount:" + detectItem.detectCount + " duration:" + (SystemClock.uptimeMillis() - detectItem.time));
                        }
                        ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).handleApkInstalled(detectItem.packageInfo.packageName);
                    }
                }
            }
        });
    }

    public void setAppInstallDetectorListener(IAppInstallDetectorListener iAppInstallDetectorListener) {
        this.mAppInstallDetectorListener = iAppInstallDetectorListener;
    }
}
