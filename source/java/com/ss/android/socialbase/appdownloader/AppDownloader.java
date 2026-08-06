package com.ss.android.socialbase.appdownloader;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.android.socialbase.appdownloader.constants.AppDownloadErrorCode;
import com.ss.android.socialbase.appdownloader.constants.Constants;
import com.ss.android.socialbase.appdownloader.depend.AppGlobalListenerAdaptor;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadDepend;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventHandler;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadFileUriProvider;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadInterceptor;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadLaunchResumeListener;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadMonitorListener;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallDetectorListener;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallMonitorListener;
import com.ss.android.socialbase.appdownloader.depend.IAppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.depend.IAppStatusChangeListener;
import com.ss.android.socialbase.appdownloader.depend.IBeforeAppInstallInterceptor;
import com.ss.android.socialbase.appdownloader.depend.IDownloadAppInstallHandler;
import com.ss.android.socialbase.appdownloader.depend.IDownloadNotificationBuilder;
import com.ss.android.socialbase.appdownloader.depend.IPrivacyPolicyCallback;
import com.ss.android.socialbase.appdownloader.depend.ITempAppInstallDownloadReceiverListener;
import com.ss.android.socialbase.appdownloader.impls.DefaultDownloadLaunchHandler;
import com.ss.android.socialbase.appdownloader.notification.DownloadNotificationListener;
import com.ss.android.socialbase.appdownloader.notification.IMockNotificationProgressHandler;
import com.ss.android.socialbase.appdownloader.notification.NotificationIconCache;
import com.ss.android.socialbase.appdownloader.service.AppDownloadServiceManager;
import com.ss.android.socialbase.appdownloader.service.IDownloadAppInstallService;
import com.ss.android.socialbase.appdownloader.service.IDownloadReceiverService;
import com.ss.android.socialbase.appdownloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.appdownloader.util.AppInstallStatsReporter;
import com.ss.android.socialbase.appdownloader.view.DownloadHandleNotificationActivity;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.IInstallAppHandler;
import com.ss.android.socialbase.downloader.depend.IOpenInstallerListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.ss.android.socialbase.downloader.impls.RetryScheduler;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.ttm.player.C0968C;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppDownloader {
    private static final String TAG = "AppDownloader";
    private static boolean enableAppInstallDownloadReceiver;
    private static volatile AppDownloader instance;
    private static boolean isInited;
    private IAppDownloadDepend appDownloadDepend;
    private IAppDownloadEventHandler appDownloadEventHandler;
    private IAppDownloadInterceptor appDownloadInterceptor;
    private IAppDownloadLaunchResumeListener appDownloadLaunchResumeListener;
    private IAppDownloadMonitorListener appDownloadMonitorListener;
    private IDownloadNotificationBuilder appDownloadNotificationBuilder;
    private IAppDownloadFileUriProvider appFileUriProvider;
    private IDownloadAppInstallHandler appInstallHandler;
    private IAppInstallMonitorListener appInstallMonitorListener;
    private IBeforeAppInstallInterceptor beforeAppInstallInterceptor;
    private String fileProviderAuthority;
    private IInstallAppHandler installAppHandler;
    private IAppInstallStatsReporter mAppInstallStatsReporter;
    private IMockNotificationProgressHandler mockNotificationProgressHandler;
    private String notificationChannelId;
    private IOpenInstallerListener openInstallerListener;
    private IPrivacyPolicyCallback privacyPolicyCallback;
    private boolean useReflectParseRes = false;
    private Handler mainThreadHandler = null;

    @Deprecated
    public IAppStatusChangeListener getAppStatusChangeListener() {
        return null;
    }

    @Deprecated
    public void preconnect(int i, String str, String str2, List<HttpHeader> list, boolean z, boolean z2) {
    }

    @Deprecated
    public void setAppStatusChangeListener(IAppStatusChangeListener iAppStatusChangeListener) {
    }

    private synchronized Handler getMainThreadHandler() {
        if (this.mainThreadHandler == null) {
            this.mainThreadHandler = new Handler(Looper.getMainLooper());
        }
        return this.mainThreadHandler;
    }

    public IAppDownloadDepend getAppDownloadDepend() {
        return this.appDownloadDepend;
    }

    public IAppDownloadEventHandler getAppDownloadEventHandler() {
        return this.appDownloadEventHandler;
    }

    public IAppDownloadMonitorListener getAppDownloadMonitorListener() {
        return this.appDownloadMonitorListener;
    }

    public IAppInstallMonitorListener getAppInstallMonitorListener() {
        return this.appInstallMonitorListener;
    }

    public void setAppInstallMonitorListener(IAppInstallMonitorListener iAppInstallMonitorListener) {
        this.appInstallMonitorListener = iAppInstallMonitorListener;
    }

    public void setFileProviderAuthority(String str) {
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "setFileProviderAuthority", "FileProviderAuthority: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.fileProviderAuthority = str;
    }

    public void setAppDownloadInterceptor(IAppDownloadInterceptor iAppDownloadInterceptor) {
        this.appDownloadInterceptor = AppGlobalListenerAdaptor.addListener(iAppDownloadInterceptor);
    }

    public String getFileProviderAuthority() {
        return this.fileProviderAuthority;
    }

    public void setAppDownloadDepend(IAppDownloadDepend iAppDownloadDepend) {
        if (iAppDownloadDepend == null) {
            return;
        }
        this.appDownloadDepend = AppGlobalListenerAdaptor.addListener(iAppDownloadDepend);
    }

    public IAppDownloadFileUriProvider getAppFileUriProvider() {
        return this.appFileUriProvider;
    }

    public void setAppFileUriProvider(IAppDownloadFileUriProvider iAppDownloadFileUriProvider) {
        this.appFileUriProvider = iAppDownloadFileUriProvider;
    }

    public void setAppDownloadEventHandler(IAppDownloadEventHandler iAppDownloadEventHandler) {
        this.appDownloadEventHandler = AppGlobalListenerAdaptor.addListener(iAppDownloadEventHandler);
    }

    public IBeforeAppInstallInterceptor getBeforeAppInstallInterceptor() {
        return this.beforeAppInstallInterceptor;
    }

    public void setBeforeAppInstallInterceptor(IBeforeAppInstallInterceptor iBeforeAppInstallInterceptor) {
        this.beforeAppInstallInterceptor = AppGlobalListenerAdaptor.addListener(iBeforeAppInstallInterceptor);
    }

    @Deprecated
    public File getGlobalSaveDir() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getGlobalSaveDir();
    }

    public void setAppDownloadMonitorListener(IAppDownloadMonitorListener iAppDownloadMonitorListener) {
        this.appDownloadMonitorListener = AppGlobalListenerAdaptor.addListener(iAppDownloadMonitorListener);
    }

    public boolean useReflectParseRes() {
        return this.useReflectParseRes;
    }

    public void setUseReflectParseRes(boolean z) {
        this.useReflectParseRes = z;
    }

    public IMockNotificationProgressHandler getMockNotificationProgressHandler() {
        return this.mockNotificationProgressHandler;
    }

    public void setMockNotificationProgressHandler(IMockNotificationProgressHandler iMockNotificationProgressHandler) {
        this.mockNotificationProgressHandler = AppGlobalListenerAdaptor.addListener(iMockNotificationProgressHandler);
    }

    @Deprecated
    public void setMinResumeFailedIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            DownloadComponentManager.getDownloadSetting().put(DownloadSettingKeys.FAILED_RESUME_MIN_HOURS, j / 3600000.0d);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void setMinResumeUnInstallIntervalTime(long j) {
        if (j < 0) {
            j = 0;
        }
        try {
            DownloadComponentManager.getDownloadSetting().put(DownloadSettingKeys.UNINSTALL_RESUME_MIN_HOURS, j / 3600000.0d);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public void setMaxResumeFailedNotificationShowCount(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            DownloadComponentManager.getDownloadSetting().put(DownloadSettingKeys.FAILED_RESUME_MAX_COUNT, i);
        } catch (Exception unused) {
        }
    }

    public static void setEnableAppInstallDownloadReceiver(boolean z) {
        enableAppInstallDownloadReceiver = z;
    }

    public static boolean isEnableAppInstallDownloadReceiver() {
        return enableAppInstallDownloadReceiver;
    }

    @Deprecated
    public void setMaxResumeUnInstallNotificationShowCount(int i) {
        if (i < 0) {
            i = 0;
        }
        try {
            DownloadComponentManager.getDownloadSetting().put(DownloadSettingKeys.UNINSTALL_RESUME_MAX_COUNT, i);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public long getMinResumeFailedIntervalTime() {
        return ((long) DownloadComponentManager.getDownloadSetting().optDouble(DownloadSettingKeys.FAILED_RESUME_MIN_HOURS, 12.0d)) * DownloadConstants.HOUR;
    }

    @Deprecated
    public long getMinResumeUnInstallIntervalTime() {
        return ((long) DownloadComponentManager.getDownloadSetting().optDouble(DownloadSettingKeys.UNINSTALL_RESUME_MIN_HOURS, 12.0d)) * DownloadConstants.HOUR;
    }

    @Deprecated
    public int getMaxFailedNotificationShowCount() {
        return DownloadComponentManager.getDownloadSetting().optInt(DownloadSettingKeys.FAILED_RESUME_MAX_COUNT, 0);
    }

    @Deprecated
    public int getMaxUnInstallNotificationShowCount() {
        return DownloadComponentManager.getDownloadSetting().optInt(DownloadSettingKeys.UNINSTALL_RESUME_MAX_COUNT, 0);
    }

    public String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    public void setNotificationChannelId(String str) {
        this.notificationChannelId = str;
    }

    private AppDownloader() {
    }

    public static AppDownloader getInstance() {
        if (instance == null) {
            synchronized (AppDownloader.class) {
                if (instance == null) {
                    instance = new AppDownloader();
                }
            }
        }
        return instance;
    }

    @Deprecated
    public void init(Context context, String str, IAppDownloadDepend iAppDownloadDepend, IAppDownloadEventHandler iAppDownloadEventHandler, IAppDownloadMonitorListener iAppDownloadMonitorListener) {
        if (iAppDownloadDepend != null) {
            setAppDownloadDepend(iAppDownloadDepend);
        }
        if (iAppDownloadEventHandler != null) {
            setAppDownloadEventHandler(iAppDownloadEventHandler);
        }
        if (iAppDownloadMonitorListener != null) {
            setAppDownloadMonitorListener(iAppDownloadMonitorListener);
        }
        initInner(context);
    }

    private void initInner(Context context) {
        if (context == null || isInited) {
            return;
        }
        DownloadConstants.setMimeApk("application/vnd.android.package-archive");
        DownloadComponentManager.setAppContext(context);
        DownloadComponentManager.setDownloadLaunchHandler(new DefaultDownloadLaunchHandler());
        registerDownloadReceiver();
        initRetryScheduler();
        isInited = true;
    }

    public void setDefaultSavePath(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSavePath(str);
    }

    public void setDefaultSaveTempPath(String str) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDefaultSaveTempPath(str);
    }

    public void init(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.fileProviderAuthority = str;
        }
        initInner(context);
    }

    private void registerDownloadReceiver() {
        ((IDownloadReceiverService) AppDownloadServiceManager.getService(IDownloadReceiverService.class)).registerDownloadReceiver();
    }

    public void unRegisterDownloadReceiver() {
        ((IDownloadReceiverService) AppDownloadServiceManager.getService(IDownloadReceiverService.class)).unRegisterDownloadReceiver();
    }

    private void initRetryScheduler() {
        RetryScheduler.getInstance().setRetryScheduleHandler(new RetryScheduler.RetryScheduleHandler() { // from class: com.ss.android.socialbase.appdownloader.AppDownloader.1
            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void scheduleRetry(DownloadInfo downloadInfo, long j, boolean z, int i) {
                RetryJobSchedulerService.tryStartScheduleRetry(downloadInfo, j, z, i);
            }

            @Override // com.ss.android.socialbase.downloader.impls.RetryScheduler.RetryScheduleHandler
            public void cancelRetry(int i) {
                RetryJobSchedulerService.tryCancelScheduleRetry(i);
            }
        });
    }

    public static boolean startInstall(Context context, int i) {
        if (AppInstallStatsReporter.isEnabled()) {
            AppInstallStatsReporter.addStats(i, "AppDownloader_startInstall", "Run");
        }
        return AppDownloadUtils.startViewIntent(context, i, true) == 1;
    }

    public void handleStatusClick(Context context, int i, int i2) {
        try {
            if (i2 != -4) {
                if (i2 == -3) {
                    if (AppInstallStatsReporter.isEnabled()) {
                        AppInstallStatsReporter.addStats(i, "AppDownloader_handleStatusClick", "Run");
                    }
                    AppDownloadUtils.startViewIntent(context, i, true);
                    return;
                } else {
                    if (i2 == -2) {
                        Downloader.getInstance(context).resume(i);
                        return;
                    }
                    if (i2 != -1) {
                        if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) {
                            Downloader.getInstance(context).pause(i);
                            return;
                        }
                        return;
                    }
                }
            }
            Downloader.getInstance(context).restart(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:43|(1:45)|46|(2:136|137)|48|(1:135)(1:55)|56|(10:(2:62|(1:64)(23:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|78|79|(1:81)(1:132)|82|83|84|85|86|87|88|(6:93|(2:95|(4:97|98|(1:102)|(5:104|(1:106)|107|(1:119)(1:113)|(2:115|116)(2:117|118))(2:120|121))(1:122))(1:124)|123|98|(2:100|102)|(0)(0))|125|(0)(0)|123|98|(0)|(0)(0)))|87|88|(7:90|93|(0)(0)|123|98|(0)|(0)(0))|125|(0)(0)|123|98|(0)|(0)(0))|134|66|(0)|69|(0)|76|78|79|(0)(0)|82|83|84|85|86) */
    /* JADX WARN: Can't wrap try/catch for region: R(31:43|(1:45)|46|(2:136|137)|48|(1:135)(1:55)|56|(2:62|(1:64)(23:65|66|(1:68)|69|(3:71|(2:74|72)|75)|76|78|79|(1:81)(1:132)|82|83|84|85|86|87|88|(6:93|(2:95|(4:97|98|(1:102)|(5:104|(1:106)|107|(1:119)(1:113)|(2:115|116)(2:117|118))(2:120|121))(1:122))(1:124)|123|98|(2:100|102)|(0)(0))|125|(0)(0)|123|98|(0)|(0)(0)))|134|66|(0)|69|(0)|76|78|79|(0)(0)|82|83|84|85|86|87|88|(7:90|93|(0)(0)|123|98|(0)|(0)(0))|125|(0)(0)|123|98|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01af, code lost:
    
        r12 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01ab, code lost:
    
        r18 = "addDownloadTask";
        r16 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0355 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:88:0x01b1, B:90:0x01b7, B:95:0x01c3, B:97:0x01d2, B:98:0x01eb, B:100:0x0355, B:102:0x035f, B:104:0x0368, B:106:0x036e, B:107:0x0378, B:109:0x037c, B:111:0x0382, B:115:0x0395, B:117:0x039f), top: B:87:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0368 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:88:0x01b1, B:90:0x01b7, B:95:0x01c3, B:97:0x01d2, B:98:0x01eb, B:100:0x0355, B:102:0x035f, B:104:0x0368, B:106:0x036e, B:107:0x0378, B:109:0x037c, B:111:0x0382, B:115:0x0395, B:117:0x039f), top: B:87:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0188 A[Catch: all -> 0x01ab, TRY_LEAVE, TryCatch #1 {all -> 0x01ab, blocks: (B:79:0x017c, B:81:0x0182, B:132:0x0188), top: B:78:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152 A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:12:0x0031, B:16:0x0044, B:19:0x004d, B:22:0x005c, B:25:0x006a, B:28:0x0075, B:30:0x007f, B:32:0x0087, B:34:0x0091, B:35:0x0095, B:37:0x009f, B:38:0x00a3, B:40:0x00aa, B:43:0x00b2, B:46:0x00bd, B:48:0x00db, B:51:0x00f8, B:53:0x00fe, B:56:0x010f, B:58:0x0115, B:60:0x011b, B:62:0x0121, B:64:0x0127, B:65:0x0133, B:66:0x014c, B:68:0x0152, B:69:0x0157, B:71:0x0161, B:72:0x0165, B:74:0x016b, B:76:0x0178), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0161 A[Catch: all -> 0x03c3, TryCatch #0 {all -> 0x03c3, blocks: (B:12:0x0031, B:16:0x0044, B:19:0x004d, B:22:0x005c, B:25:0x006a, B:28:0x0075, B:30:0x007f, B:32:0x0087, B:34:0x0091, B:35:0x0095, B:37:0x009f, B:38:0x00a3, B:40:0x00aa, B:43:0x00b2, B:46:0x00bd, B:48:0x00db, B:51:0x00f8, B:53:0x00fe, B:56:0x010f, B:58:0x0115, B:60:0x011b, B:62:0x0121, B:64:0x0127, B:65:0x0133, B:66:0x014c, B:68:0x0152, B:69:0x0157, B:71:0x0161, B:72:0x0165, B:74:0x016b, B:76:0x0178), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0182 A[Catch: all -> 0x01ab, TryCatch #1 {all -> 0x01ab, blocks: (B:79:0x017c, B:81:0x0182, B:132:0x0188), top: B:78:0x017c }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b7 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:88:0x01b1, B:90:0x01b7, B:95:0x01c3, B:97:0x01d2, B:98:0x01eb, B:100:0x0355, B:102:0x035f, B:104:0x0368, B:106:0x036e, B:107:0x0378, B:109:0x037c, B:111:0x0382, B:115:0x0395, B:117:0x039f), top: B:87:0x01b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c3 A[Catch: all -> 0x03bf, TryCatch #3 {all -> 0x03bf, blocks: (B:88:0x01b1, B:90:0x01b7, B:95:0x01c3, B:97:0x01d2, B:98:0x01eb, B:100:0x0355, B:102:0x035f, B:104:0x0368, B:106:0x036e, B:107:0x0378, B:109:0x037c, B:111:0x0382, B:115:0x0395, B:117:0x039f), top: B:87:0x01b1 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int addDownloadTask(AppTaskBuilder appTaskBuilder) {
        String str;
        int i;
        IDownloadDepend depend;
        List<IDownloadCompleteHandler> downloadCompleteHandlers;
        String extra;
        boolean z;
        int i2;
        boolean z2;
        int i3;
        DownloadTask autoInstall;
        JSONObject jSONObject;
        if (appTaskBuilder == null || appTaskBuilder.getContext() == null || !DownloadUtils.ENABLE_APP_DOWNLOADER) {
            return 0;
        }
        if (Logger.alog()) {
            Logger.globalDebug(TAG, "addDownloadTask", "start appDownload :" + appTaskBuilder);
        }
        try {
            List<HttpHeader> putDefaultUa = putDefaultUa(appTaskBuilder.getHeaders());
            String url = appTaskBuilder.getUrl();
            if (TextUtils.isEmpty(url)) {
                return 0;
            }
            int antiHijackErrorCode = appTaskBuilder.getAntiHijackErrorCode();
            boolean z3 = antiHijackErrorCode == 0;
            String createFileName = AppDownloadUtils.createFileName(appTaskBuilder, z3);
            String name = appTaskBuilder.getName();
            if (TextUtils.isEmpty(name)) {
                name = createFileName;
            }
            String mimeType = appTaskBuilder.getMimeType();
            if (createFileName.endsWith(Constants.APK_SUFFIX) && !AppDownloadUtils.isApkMineType(appTaskBuilder.getMimeType())) {
                mimeType = "application/vnd.android.package-archive";
            }
            JSONObject downloadSetting = appTaskBuilder.getDownloadSetting();
            String savePath = appTaskBuilder.getSavePath();
            if (downloadSetting != null && downloadSetting.optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_REPLACE_EXTERNAL_PATH) > 0) {
                String externalUriPath = DownloadFileUtils.getExternalUriPath(url, createFileName, "application/vnd.android.package-archive");
                if (!TextUtils.isEmpty(externalUriPath)) {
                    appTaskBuilder.externalSavePath(externalUriPath);
                    savePath = externalUriPath;
                }
            }
            if (TextUtils.isEmpty(appTaskBuilder.getSavePath())) {
                savePath = AppDownloadUtils.getAppDownloadPath();
            }
            String str2 = savePath;
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(createFileName)) {
                String taskKey = appTaskBuilder.getTaskKey();
                if (TextUtils.isEmpty(taskKey)) {
                    taskKey = url;
                }
                int downloadId = DownloadComponentManager.getDownloadId(taskKey, str2);
                DownloadInfo downloadInfo = Downloader.getInstance(appTaskBuilder.getContext()).getDownloadInfo(downloadId);
                if (downloadInfo != null) {
                    try {
                        appTaskBuilder.downloadSetting(new JSONObject(downloadInfo.getDownloadSettingString()));
                    } catch (Throwable unused) {
                    }
                }
                DownloadSetting.addTaskDownloadSetting(downloadId, appTaskBuilder.getMonitorScene(), appTaskBuilder.getDownloadSetting());
                boolean isForce = appTaskBuilder.isForce();
                boolean z4 = (DownloadSetting.obtain(downloadId).optInt(DownloadSettingKeys.MODIFY_FORCE, 1) == 1 && !isForce && DownloadUtils.isFileExist(str2, createFileName) && Downloader.getInstance(appTaskBuilder.getContext()).getDownloadInfo(downloadId) == null) ? true : isForce;
                IDownloadListener notificationListener = appTaskBuilder.getNotificationListener();
                try {
                    if (notificationListener == null && (appTaskBuilder.isShowNotification() || appTaskBuilder.isAutoInstallWithoutNotification())) {
                        if (appTaskBuilder.getNotificationItem() != null) {
                            notificationListener = new DownloadNotificationListener(appTaskBuilder.getNotificationItem());
                        } else {
                            i = downloadId;
                            notificationListener = new DownloadNotificationListener(appTaskBuilder.getContext(), downloadId, name, str2, createFileName, appTaskBuilder.getExtra());
                            depend = appTaskBuilder.getDepend();
                            if (depend == null) {
                                depend = new IDownloadDepend() { // from class: com.ss.android.socialbase.appdownloader.AppDownloader.2
                                    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDepend
                                    public void monitorLogSend(DownloadInfo downloadInfo2, BaseException baseException, int i4) {
                                        if (AppDownloader.this.appDownloadMonitorListener != null) {
                                            AppDownloader.this.appDownloadMonitorListener.onAppDownloadMonitorSend(downloadInfo2, baseException, i4);
                                        }
                                    }
                                };
                            }
                            downloadCompleteHandlers = DownloadComponentManager.getDownloadCompleteHandlers();
                            if (!downloadCompleteHandlers.isEmpty()) {
                                Iterator<IDownloadCompleteHandler> it = downloadCompleteHandlers.iterator();
                                while (it.hasNext()) {
                                    appTaskBuilder.addDownloadCompleteHandler(it.next());
                                }
                            }
                            extra = appTaskBuilder.getExtra();
                            if (TextUtils.isEmpty(extra)) {
                                jSONObject = new JSONObject(extra);
                            } else {
                                jSONObject = new JSONObject();
                            }
                            String str3 = extra;
                            str = "addDownloadTask";
                            jSONObject.put(Constants.AUTO_INSTALL_WITH_NOTIFICATION, appTaskBuilder.isAutoInstallWithNotification());
                            jSONObject.put(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, appTaskBuilder.isAutoInstallWithoutNotification());
                            String str4 = jSONObject.toString();
                            if (!appTaskBuilder.isShowNotification() && !appTaskBuilder.isAutoInstallWithoutNotification()) {
                                z = false;
                                if (z) {
                                    z2 = z3;
                                    if (DownloadSetting.obtain(i).optInt("enable_notification_ui") >= 1) {
                                        i2 = antiHijackErrorCode;
                                        i3 = i;
                                        NotificationIconCache.inst().parseAndCacheIcon(i3, appTaskBuilder.getIconUrl());
                                        autoInstall = Downloader.with(appTaskBuilder.getContext()).url(url).backUpUrls(appTaskBuilder.getBackUpUrls()).name(createFileName).setTaskPriority(appTaskBuilder.getTaskPriority()).title(name).savePath(str2).onlyWifi(appTaskBuilder.isNeedWifi()).extraHeaders(putDefaultUa).depend(depend).retryCount(appTaskBuilder.getRetryCount()).backUpUrlRetryCount(appTaskBuilder.getBackUpUrlRetryCount()).showNotification(z).extra(str4).mimeType(mimeType).minProgressTimeMsInterval(appTaskBuilder.getMinProgressTimeMsInterval()).maxProgressCount(appTaskBuilder.getMaxProgressCount()).mainThreadListener(appTaskBuilder.getMainThreadListener()).notificationListener(notificationListener).notificationEventListener(createNotificationEventListener(appTaskBuilder.getAppDownloadEventListener())).force(z4).autoResumed(appTaskBuilder.isAutoResumed()).showNotificationForAutoResumed(appTaskBuilder.isShowNotificationForAutoResumed()).needHttpsToHttpRetry(appTaskBuilder.isNeedHttpsToHttpRetry()).packageName(appTaskBuilder.getPackageName()).md5(appTaskBuilder.getMd5()).expectFileLength(appTaskBuilder.getExpectFileLength()).needDefaultHttpServiceBackUp(appTaskBuilder.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(appTaskBuilder.isNeedIndependentProcess()).enqueueType(appTaskBuilder.getEnqueueType()).monitorDepend(appTaskBuilder.getMonitorDepend()).fileUriProvider(appTaskBuilder.getFileUriProvider()).diskSpaceHandler(appTaskBuilder.getDiskSpaceHandler()).notificationClickCallback(appTaskBuilder.getNotificationClickCallback()).pcdnUrls(appTaskBuilder.getPcdnUrls()).cdnUrls(appTaskBuilder.getCdnUrls()).downloadSetting(appTaskBuilder.getDownloadSetting()).iconUrl(appTaskBuilder.getIconUrl()).needSDKMonitor(appTaskBuilder.isNeedSDKMonitor()).monitorScene(appTaskBuilder.getMonitorScene()).setCacheLifeTimeMax(appTaskBuilder.getCacheLifeTimeMax()).extraMonitorStatus(appTaskBuilder.getExtraMonitorStatus()).executorGroup(appTaskBuilder.getExecutorGroup()).throttleNetSpeed(appTaskBuilder.getThrottleNetSpeed()).throttleSmoothness(appTaskBuilder.getThrottleSmoothness()).distinctDirectory(appTaskBuilder.isDistinctDirectory()).taskKey(appTaskBuilder.getTaskKey()).ignoreInterceptor(appTaskBuilder.isIgnoreInterceptor()).cdnListener(appTaskBuilder.getCdnListener()).setAutoInstall(appTaskBuilder.isAutoInstall());
                                        if (autoInstall != null && !appTaskBuilder.getDownloadCompleteHandlers().isEmpty()) {
                                            autoInstall.setDownloadCompleteHandlers(appTaskBuilder.getDownloadCompleteHandlers());
                                        }
                                        if (autoInstall != null) {
                                            return i3;
                                        }
                                        if (appTaskBuilder.isHandleRequest()) {
                                            autoInstall.handleRequest();
                                            autoInstall.subThreadListener(appTaskBuilder.getSubThreadListener());
                                        }
                                        IAppDownloadInterceptor iAppDownloadInterceptor = this.appDownloadInterceptor;
                                        if (iAppDownloadInterceptor != null && iAppDownloadInterceptor.intercept(appTaskBuilder) && Downloader.getInstance(appTaskBuilder.getContext()).getDownloadInfo(i3) == null) {
                                            handleIntercept(appTaskBuilder, autoInstall, appTaskBuilder.getMainThreadListener(), notificationListener);
                                            return AppDownloadErrorCode.INTERCEPT_RETURN_ERROR_CODE;
                                        }
                                        requestNotificationPermission(i3);
                                        int i4 = i3;
                                        startDownload(autoInstall, i2, z2, appTaskBuilder.getInstallBizType(), appTaskBuilder.getInstallCertId(), appTaskBuilder.getInstallBizParamsJson());
                                        autoInstall.getDownloadInfo();
                                        return i4;
                                    }
                                    i2 = antiHijackErrorCode;
                                } else {
                                    i2 = antiHijackErrorCode;
                                    z2 = z3;
                                }
                                i3 = i;
                                autoInstall = Downloader.with(appTaskBuilder.getContext()).url(url).backUpUrls(appTaskBuilder.getBackUpUrls()).name(createFileName).setTaskPriority(appTaskBuilder.getTaskPriority()).title(name).savePath(str2).onlyWifi(appTaskBuilder.isNeedWifi()).extraHeaders(putDefaultUa).depend(depend).retryCount(appTaskBuilder.getRetryCount()).backUpUrlRetryCount(appTaskBuilder.getBackUpUrlRetryCount()).showNotification(z).extra(str4).mimeType(mimeType).minProgressTimeMsInterval(appTaskBuilder.getMinProgressTimeMsInterval()).maxProgressCount(appTaskBuilder.getMaxProgressCount()).mainThreadListener(appTaskBuilder.getMainThreadListener()).notificationListener(notificationListener).notificationEventListener(createNotificationEventListener(appTaskBuilder.getAppDownloadEventListener())).force(z4).autoResumed(appTaskBuilder.isAutoResumed()).showNotificationForAutoResumed(appTaskBuilder.isShowNotificationForAutoResumed()).needHttpsToHttpRetry(appTaskBuilder.isNeedHttpsToHttpRetry()).packageName(appTaskBuilder.getPackageName()).md5(appTaskBuilder.getMd5()).expectFileLength(appTaskBuilder.getExpectFileLength()).needDefaultHttpServiceBackUp(appTaskBuilder.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(appTaskBuilder.isNeedIndependentProcess()).enqueueType(appTaskBuilder.getEnqueueType()).monitorDepend(appTaskBuilder.getMonitorDepend()).fileUriProvider(appTaskBuilder.getFileUriProvider()).diskSpaceHandler(appTaskBuilder.getDiskSpaceHandler()).notificationClickCallback(appTaskBuilder.getNotificationClickCallback()).pcdnUrls(appTaskBuilder.getPcdnUrls()).cdnUrls(appTaskBuilder.getCdnUrls()).downloadSetting(appTaskBuilder.getDownloadSetting()).iconUrl(appTaskBuilder.getIconUrl()).needSDKMonitor(appTaskBuilder.isNeedSDKMonitor()).monitorScene(appTaskBuilder.getMonitorScene()).setCacheLifeTimeMax(appTaskBuilder.getCacheLifeTimeMax()).extraMonitorStatus(appTaskBuilder.getExtraMonitorStatus()).executorGroup(appTaskBuilder.getExecutorGroup()).throttleNetSpeed(appTaskBuilder.getThrottleNetSpeed()).throttleSmoothness(appTaskBuilder.getThrottleSmoothness()).distinctDirectory(appTaskBuilder.isDistinctDirectory()).taskKey(appTaskBuilder.getTaskKey()).ignoreInterceptor(appTaskBuilder.isIgnoreInterceptor()).cdnListener(appTaskBuilder.getCdnListener()).setAutoInstall(appTaskBuilder.isAutoInstall());
                                if (autoInstall != null) {
                                    autoInstall.setDownloadCompleteHandlers(appTaskBuilder.getDownloadCompleteHandlers());
                                }
                                if (autoInstall != null) {
                                }
                            }
                            z = true;
                            if (z) {
                            }
                            i3 = i;
                            autoInstall = Downloader.with(appTaskBuilder.getContext()).url(url).backUpUrls(appTaskBuilder.getBackUpUrls()).name(createFileName).setTaskPriority(appTaskBuilder.getTaskPriority()).title(name).savePath(str2).onlyWifi(appTaskBuilder.isNeedWifi()).extraHeaders(putDefaultUa).depend(depend).retryCount(appTaskBuilder.getRetryCount()).backUpUrlRetryCount(appTaskBuilder.getBackUpUrlRetryCount()).showNotification(z).extra(str4).mimeType(mimeType).minProgressTimeMsInterval(appTaskBuilder.getMinProgressTimeMsInterval()).maxProgressCount(appTaskBuilder.getMaxProgressCount()).mainThreadListener(appTaskBuilder.getMainThreadListener()).notificationListener(notificationListener).notificationEventListener(createNotificationEventListener(appTaskBuilder.getAppDownloadEventListener())).force(z4).autoResumed(appTaskBuilder.isAutoResumed()).showNotificationForAutoResumed(appTaskBuilder.isShowNotificationForAutoResumed()).needHttpsToHttpRetry(appTaskBuilder.isNeedHttpsToHttpRetry()).packageName(appTaskBuilder.getPackageName()).md5(appTaskBuilder.getMd5()).expectFileLength(appTaskBuilder.getExpectFileLength()).needDefaultHttpServiceBackUp(appTaskBuilder.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(appTaskBuilder.isNeedIndependentProcess()).enqueueType(appTaskBuilder.getEnqueueType()).monitorDepend(appTaskBuilder.getMonitorDepend()).fileUriProvider(appTaskBuilder.getFileUriProvider()).diskSpaceHandler(appTaskBuilder.getDiskSpaceHandler()).notificationClickCallback(appTaskBuilder.getNotificationClickCallback()).pcdnUrls(appTaskBuilder.getPcdnUrls()).cdnUrls(appTaskBuilder.getCdnUrls()).downloadSetting(appTaskBuilder.getDownloadSetting()).iconUrl(appTaskBuilder.getIconUrl()).needSDKMonitor(appTaskBuilder.isNeedSDKMonitor()).monitorScene(appTaskBuilder.getMonitorScene()).setCacheLifeTimeMax(appTaskBuilder.getCacheLifeTimeMax()).extraMonitorStatus(appTaskBuilder.getExtraMonitorStatus()).executorGroup(appTaskBuilder.getExecutorGroup()).throttleNetSpeed(appTaskBuilder.getThrottleNetSpeed()).throttleSmoothness(appTaskBuilder.getThrottleSmoothness()).distinctDirectory(appTaskBuilder.isDistinctDirectory()).taskKey(appTaskBuilder.getTaskKey()).ignoreInterceptor(appTaskBuilder.isIgnoreInterceptor()).cdnListener(appTaskBuilder.getCdnListener()).setAutoInstall(appTaskBuilder.isAutoInstall());
                            if (autoInstall != null) {
                            }
                            if (autoInstall != null) {
                            }
                        }
                    }
                    if (!appTaskBuilder.isShowNotification()) {
                        z = false;
                        if (z) {
                        }
                        i3 = i;
                        autoInstall = Downloader.with(appTaskBuilder.getContext()).url(url).backUpUrls(appTaskBuilder.getBackUpUrls()).name(createFileName).setTaskPriority(appTaskBuilder.getTaskPriority()).title(name).savePath(str2).onlyWifi(appTaskBuilder.isNeedWifi()).extraHeaders(putDefaultUa).depend(depend).retryCount(appTaskBuilder.getRetryCount()).backUpUrlRetryCount(appTaskBuilder.getBackUpUrlRetryCount()).showNotification(z).extra(str4).mimeType(mimeType).minProgressTimeMsInterval(appTaskBuilder.getMinProgressTimeMsInterval()).maxProgressCount(appTaskBuilder.getMaxProgressCount()).mainThreadListener(appTaskBuilder.getMainThreadListener()).notificationListener(notificationListener).notificationEventListener(createNotificationEventListener(appTaskBuilder.getAppDownloadEventListener())).force(z4).autoResumed(appTaskBuilder.isAutoResumed()).showNotificationForAutoResumed(appTaskBuilder.isShowNotificationForAutoResumed()).needHttpsToHttpRetry(appTaskBuilder.isNeedHttpsToHttpRetry()).packageName(appTaskBuilder.getPackageName()).md5(appTaskBuilder.getMd5()).expectFileLength(appTaskBuilder.getExpectFileLength()).needDefaultHttpServiceBackUp(appTaskBuilder.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(appTaskBuilder.isNeedIndependentProcess()).enqueueType(appTaskBuilder.getEnqueueType()).monitorDepend(appTaskBuilder.getMonitorDepend()).fileUriProvider(appTaskBuilder.getFileUriProvider()).diskSpaceHandler(appTaskBuilder.getDiskSpaceHandler()).notificationClickCallback(appTaskBuilder.getNotificationClickCallback()).pcdnUrls(appTaskBuilder.getPcdnUrls()).cdnUrls(appTaskBuilder.getCdnUrls()).downloadSetting(appTaskBuilder.getDownloadSetting()).iconUrl(appTaskBuilder.getIconUrl()).needSDKMonitor(appTaskBuilder.isNeedSDKMonitor()).monitorScene(appTaskBuilder.getMonitorScene()).setCacheLifeTimeMax(appTaskBuilder.getCacheLifeTimeMax()).extraMonitorStatus(appTaskBuilder.getExtraMonitorStatus()).executorGroup(appTaskBuilder.getExecutorGroup()).throttleNetSpeed(appTaskBuilder.getThrottleNetSpeed()).throttleSmoothness(appTaskBuilder.getThrottleSmoothness()).distinctDirectory(appTaskBuilder.isDistinctDirectory()).taskKey(appTaskBuilder.getTaskKey()).ignoreInterceptor(appTaskBuilder.isIgnoreInterceptor()).cdnListener(appTaskBuilder.getCdnListener()).setAutoInstall(appTaskBuilder.isAutoInstall());
                        if (autoInstall != null) {
                        }
                        if (autoInstall != null) {
                        }
                    }
                    z = true;
                    if (z) {
                    }
                    i3 = i;
                    autoInstall = Downloader.with(appTaskBuilder.getContext()).url(url).backUpUrls(appTaskBuilder.getBackUpUrls()).name(createFileName).setTaskPriority(appTaskBuilder.getTaskPriority()).title(name).savePath(str2).onlyWifi(appTaskBuilder.isNeedWifi()).extraHeaders(putDefaultUa).depend(depend).retryCount(appTaskBuilder.getRetryCount()).backUpUrlRetryCount(appTaskBuilder.getBackUpUrlRetryCount()).showNotification(z).extra(str4).mimeType(mimeType).minProgressTimeMsInterval(appTaskBuilder.getMinProgressTimeMsInterval()).maxProgressCount(appTaskBuilder.getMaxProgressCount()).mainThreadListener(appTaskBuilder.getMainThreadListener()).notificationListener(notificationListener).notificationEventListener(createNotificationEventListener(appTaskBuilder.getAppDownloadEventListener())).force(z4).autoResumed(appTaskBuilder.isAutoResumed()).showNotificationForAutoResumed(appTaskBuilder.isShowNotificationForAutoResumed()).needHttpsToHttpRetry(appTaskBuilder.isNeedHttpsToHttpRetry()).packageName(appTaskBuilder.getPackageName()).md5(appTaskBuilder.getMd5()).expectFileLength(appTaskBuilder.getExpectFileLength()).needDefaultHttpServiceBackUp(appTaskBuilder.isNeedDefaultHttpServiceBackUp()).needIndependentProcess(appTaskBuilder.isNeedIndependentProcess()).enqueueType(appTaskBuilder.getEnqueueType()).monitorDepend(appTaskBuilder.getMonitorDepend()).fileUriProvider(appTaskBuilder.getFileUriProvider()).diskSpaceHandler(appTaskBuilder.getDiskSpaceHandler()).notificationClickCallback(appTaskBuilder.getNotificationClickCallback()).pcdnUrls(appTaskBuilder.getPcdnUrls()).cdnUrls(appTaskBuilder.getCdnUrls()).downloadSetting(appTaskBuilder.getDownloadSetting()).iconUrl(appTaskBuilder.getIconUrl()).needSDKMonitor(appTaskBuilder.isNeedSDKMonitor()).monitorScene(appTaskBuilder.getMonitorScene()).setCacheLifeTimeMax(appTaskBuilder.getCacheLifeTimeMax()).extraMonitorStatus(appTaskBuilder.getExtraMonitorStatus()).executorGroup(appTaskBuilder.getExecutorGroup()).throttleNetSpeed(appTaskBuilder.getThrottleNetSpeed()).throttleSmoothness(appTaskBuilder.getThrottleSmoothness()).distinctDirectory(appTaskBuilder.isDistinctDirectory()).taskKey(appTaskBuilder.getTaskKey()).ignoreInterceptor(appTaskBuilder.isIgnoreInterceptor()).cdnListener(appTaskBuilder.getCdnListener()).setAutoInstall(appTaskBuilder.isAutoInstall());
                    if (autoInstall != null) {
                    }
                    if (autoInstall != null) {
                    }
                } catch (Throwable th) {
                    th = th;
                    String str5 = str;
                    ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSendWithTaskMonitor(appTaskBuilder.getMonitorDepend(), null, new BaseException(1003, DownloadUtils.getErrorMsgWithTagPrefix(th, str5)), 0);
                    Logger.globalError(TAG, str5, String.format("Add download task error:%s", th));
                    return 0;
                }
                i = downloadId;
                depend = appTaskBuilder.getDepend();
                if (depend == null) {
                }
                downloadCompleteHandlers = DownloadComponentManager.getDownloadCompleteHandlers();
                if (!downloadCompleteHandlers.isEmpty()) {
                }
                extra = appTaskBuilder.getExtra();
                if (TextUtils.isEmpty(extra)) {
                }
                String str32 = extra;
                str = "addDownloadTask";
                jSONObject.put(Constants.AUTO_INSTALL_WITH_NOTIFICATION, appTaskBuilder.isAutoInstallWithNotification());
                jSONObject.put(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, appTaskBuilder.isAutoInstallWithoutNotification());
                String str42 = jSONObject.toString();
            }
            return 0;
        } catch (Throwable th2) {
            th = th2;
            str = "addDownloadTask";
        }
    }

    private void handleIntercept(AppTaskBuilder appTaskBuilder, DownloadTask downloadTask, final IDownloadListener iDownloadListener, final IDownloadListener iDownloadListener2) {
        final DownloadInfo buildDownloadInfo = downloadTask.buildDownloadInfo();
        buildDownloadInfo.setStatus(-1);
        buildDownloadInfo.setInterceptFlag(0);
        if (Logger.debugScene(buildDownloadInfo)) {
            Logger.taskDebug(TAG, buildDownloadInfo, "handleIntercept", "Intercept: " + appTaskBuilder.getUrl());
        }
        getMainThreadHandler().post(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.AppDownloader.3
            @Override // java.lang.Runnable
            public void run() {
                IDownloadListener iDownloadListener3;
                IDownloadListener iDownloadListener4 = iDownloadListener;
                if (iDownloadListener4 != null) {
                    iDownloadListener4.onFailed(buildDownloadInfo, new BaseException(1085, "AppDownloader Intercept"));
                }
                if (!(buildDownloadInfo.canShowNotification() || buildDownloadInfo.isAutoInstallWithoutNotification()) || (iDownloadListener3 = iDownloadListener2) == null) {
                    return;
                }
                iDownloadListener3.onFailed(buildDownloadInfo, new BaseException(1085, "AppDownloader Intercept"));
            }
        });
    }

    private void startDownload(DownloadTask downloadTask, int i, boolean z, String str, String str2, String str3) {
        if (downloadTask == null) {
            return;
        }
        downloadTask.download();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            downloadInfo.setInstallBizType(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            downloadInfo.setInstallCertId(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            downloadInfo.setInstallBizParamsJson(str3);
        }
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            downloadInfo.updateSpData();
        }
        downloadInfo.setAntiHijackErrorCode(i);
        if (z) {
            downloadInfo.setSavePathRedirected(z);
        }
    }

    private List<HttpHeader> putDefaultUa(List<HttpHeader> list) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        if (list != null && list.size() > 0) {
            for (HttpHeader httpHeader : list) {
                if (httpHeader != null && !TextUtils.isEmpty(httpHeader.getName()) && !TextUtils.isEmpty(httpHeader.getValue())) {
                    if (httpHeader.getName().equals("User-Agent")) {
                        z = true;
                    }
                    arrayList.add(new HttpHeader(httpHeader.getName(), httpHeader.getValue()));
                }
            }
        }
        if (!z) {
            arrayList.add(new HttpHeader("User-Agent", Constants.DEFAULT_USER_AGENT));
        }
        return arrayList;
    }

    public String getMimeType(String str, String str2) {
        return (TextUtils.isEmpty(str) || !str.endsWith(Constants.APK_SUFFIX) || AppDownloadUtils.isApkMineType(str2)) ? str2 : "application/vnd.android.package-archive";
    }

    public void setAppDownloadEventListener(int i, IAppDownloadEventListener iAppDownloadEventListener) {
        if (iAppDownloadEventListener == null) {
            return;
        }
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setDownloadNotificationEventListener(i, createNotificationEventListener(iAppDownloadEventListener));
    }

    private IDownloadNotificationEventListener createNotificationEventListener(final IAppDownloadEventListener iAppDownloadEventListener) {
        if (iAppDownloadEventListener == null) {
            return null;
        }
        return new IDownloadNotificationEventListener() { // from class: com.ss.android.socialbase.appdownloader.AppDownloader.4
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public void onNotificationEvent(int i, DownloadInfo downloadInfo, String str, String str2) {
                if (i != 1 && i != 3) {
                    switch (i) {
                        case 5:
                        case 6:
                        case 7:
                            break;
                        case 8:
                            iAppDownloadEventListener.onAppInstallError(i, downloadInfo.getPackageName(), str, str2);
                            return;
                        case 9:
                            iAppDownloadEventListener.onAppInstalled(DownloadComponentManager.getAppContext(), str);
                            return;
                        case 10:
                            iAppDownloadEventListener.onAppDownloadCancel(downloadInfo);
                            return;
                        default:
                            return;
                    }
                }
                iAppDownloadEventListener.onAppDownloadEvent(i, str, downloadInfo.getStatus(), downloadInfo.getDownloadTime());
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public boolean interceptAfterNotificationSuccess(boolean z) {
                return iAppDownloadEventListener.installIntercept(z);
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener
            public String getNotifyProcessName() {
                return iAppDownloadEventListener.getNotifyProcessName();
            }
        };
    }

    public int getDownloadId(Context context, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo appDownloadInfo = getAppDownloadInfo(context, str);
                if (appDownloadInfo != null) {
                    return appDownloadInfo.getId();
                }
                try {
                    str2 = AppDownloadUtils.getAppDownloadPath();
                } catch (Throwable unused) {
                    str2 = null;
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = DownloadDirUtils.getFilesDir(context, false).getPath();
                }
                return Downloader.getInstance(context).getDownloadId(str, str2);
            } catch (Throwable th) {
                Logger.globalError(TAG, "getDownloadId", "Error: " + th);
            }
        }
        return 0;
    }

    public DownloadInfo getAppDownloadInfo(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                DownloadInfo downloadInfoInDir = getDownloadInfoInDir(context, str, DownloadDirUtils.getGlobalSavePath());
                if (downloadInfoInDir == null && Build.VERSION.SDK_INT < 30) {
                    downloadInfoInDir = getDownloadInfoInDir(context, str, DownloadDirUtils.getDefaultExtPublicPath());
                }
                if (downloadInfoInDir == null) {
                    downloadInfoInDir = getDownloadInfoInDir(context, str, DownloadDirUtils.getDefaultExtPrivatePath());
                }
                if (downloadInfoInDir == null && Build.VERSION.SDK_INT < 30) {
                    downloadInfoInDir = getDownloadInfoInDir(context, str, DownloadDirUtils.getExtPublicDownloadPath());
                }
                if (downloadInfoInDir == null) {
                    downloadInfoInDir = getDownloadInfoInDir(context, str, DownloadDirUtils.getDefaultDataPath());
                }
                return downloadInfoInDir == null ? getDownloadInfoByUrlWithAntiHijack(context, str) : downloadInfoInDir;
            } catch (Throwable th) {
                Logger.globalError(TAG, "getAppDownloadInfo", "Error: " + th);
            }
        }
        return null;
    }

    private DownloadInfo getDownloadInfoInDir(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return Downloader.getInstance(context).getDownloadInfo(str, str2);
    }

    private DownloadInfo getDownloadInfoByUrlWithAntiHijack(Context context, String str) {
        List<DownloadInfo> downloadInfoList = Downloader.getInstance(context).getDownloadInfoList(str);
        if (downloadInfoList == null) {
            return null;
        }
        for (DownloadInfo downloadInfo : downloadInfoList) {
            if (downloadInfo != null && (downloadInfo.isSavePathRedirected() || (DownloadFileUtils.isExternalDownloadEnabled() && DownloadFileUtils.isMediaUri(downloadInfo.getSavePath())))) {
                return downloadInfo;
            }
        }
        return null;
    }

    public List<DownloadInfo> getUnCompletedDownloadAppInfos(Context context) {
        return Downloader.getInstance(context).getUnCompletedDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(Context context) {
        return Downloader.getInstance(context).getDownloadingDownloadInfosWithMimeType("application/vnd.android.package-archive");
    }

    public IDownloadNotificationBuilder getAppDownloadNotificationBuilder() {
        return this.appDownloadNotificationBuilder;
    }

    public void setAppDownloadNotificationBuilder(IDownloadNotificationBuilder iDownloadNotificationBuilder) {
        this.appDownloadNotificationBuilder = iDownloadNotificationBuilder;
    }

    public IAppDownloadLaunchResumeListener getAppDownloadLaunchResumeListener() {
        return this.appDownloadLaunchResumeListener;
    }

    public void setAppDownloadLaunchResumeListener(IAppDownloadLaunchResumeListener iAppDownloadLaunchResumeListener) {
        this.appDownloadLaunchResumeListener = AppGlobalListenerAdaptor.addListener(iAppDownloadLaunchResumeListener);
    }

    public IReserveWifiStatusListener getReserveWifiStatusListener() {
        return Downloader.getInstance(DownloadComponentManager.getAppContext()).getReserveWifiStatusListener();
    }

    public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        Downloader.getInstance(DownloadComponentManager.getAppContext()).setReserveWifiStatusListener(iReserveWifiStatusListener);
    }

    public void setInstallAppHandler(IInstallAppHandler iInstallAppHandler) {
        this.installAppHandler = iInstallAppHandler;
    }

    public IInstallAppHandler getInstallAppHandler() {
        return this.installAppHandler;
    }

    public void setOpenInstallerListener(IOpenInstallerListener iOpenInstallerListener) {
        this.openInstallerListener = AppGlobalListenerAdaptor.addListener(iOpenInstallerListener);
    }

    public IOpenInstallerListener getOpenInstallerListener() {
        return this.openInstallerListener;
    }

    public IDownloadAppInstallHandler getAppInstallHandler() {
        return this.appInstallHandler;
    }

    public void setAppInstallHandler(IDownloadAppInstallHandler iDownloadAppInstallHandler) {
        this.appInstallHandler = iDownloadAppInstallHandler;
    }

    public List<DownloadInfo> getAllAppDownloadInfos() {
        return ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfosByFilters("application/vnd.android.package-archive", Constants.APK_SUFFIX);
    }

    public IPrivacyPolicyCallback getPrivacyPolicyCallback() {
        return this.privacyPolicyCallback;
    }

    public void setPrivacyPolicyCallback(IPrivacyPolicyCallback iPrivacyPolicyCallback) {
        this.privacyPolicyCallback = iPrivacyPolicyCallback;
    }

    public void tryRegisterTempAppInstallDownloadReceiver(int i) {
        ((IDownloadReceiverService) AppDownloadServiceManager.getService(IDownloadReceiverService.class)).tryRegisterTempAppInstallDownloadReceiver(i);
    }

    public void setTempAppInstallDownloadReceiverListener(ITempAppInstallDownloadReceiverListener iTempAppInstallDownloadReceiverListener) {
        ((IDownloadReceiverService) AppDownloadServiceManager.getService(IDownloadReceiverService.class)).setTempAppInstallDownloadReceiverListener(iTempAppInstallDownloadReceiverListener);
    }

    public void startAppInstallDetector(Context context, PackageInfo packageInfo, JSONObject jSONObject) {
        ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).startAppInstallDetector(context, packageInfo, jSONObject);
    }

    public void setAppInstallDetectorListener(IAppInstallDetectorListener iAppInstallDetectorListener) {
        ((IDownloadAppInstallService) AppDownloadServiceManager.getService(IDownloadAppInstallService.class)).setAppInstallDetectorListener(iAppInstallDetectorListener);
    }

    public IAppInstallStatsReporter getAppInstallStatsReporter() {
        return this.mAppInstallStatsReporter;
    }

    public void setAppInstallStatsReporter(IAppInstallStatsReporter iAppInstallStatsReporter) {
        AppInstallStatsReporter.setReporter(iAppInstallStatsReporter);
    }

    public static Pair<Intent, Boolean> createHandlerIntent(Context context, int i) {
        return createHandlerIntent(context, i, false);
    }

    public static Pair<Intent, Boolean> createHandlerIntent(Context context, int i, boolean z) {
        Pair<Intent, Boolean> pair;
        if ((Build.VERSION.SDK_INT >= 31 && DownloadSetting.obtain(i).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_TARGET_34) > 0) && !z) {
            pair = new Pair<>(new Intent(context, (Class<?>) DownloadHandleNotificationActivity.class), true);
        } else {
            pair = new Pair<>(new Intent(context, (Class<?>) DownloadHandlerService.class), false);
        }
        if (DownloadUtils.optimizeMultiProcess() && !DownloadHelper.isMainProcess()) {
            ((Intent) pair.first).putExtra(Constants.EXTRA_NOTIFICATION_PID, DownloadUtils.getPid());
        }
        return pair;
    }

    public static PendingIntent getHandlerPendingIntent(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    private void requestNotificationPermission(int i) {
        Context appContext;
        if (Build.VERSION.SDK_INT < 33 || DownloadSetting.obtain(i).optInt(com.ss.android.socialbase.downloader.setting.DownloadSettingKeys.ENABLE_TARGET_34) <= 0 || (appContext = DownloadComponentManager.getAppContext()) == null) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) appContext.getSystemService("notification");
            if (notificationManager != null && !notificationManager.areNotificationsEnabled()) {
                Intent intent = new Intent(appContext, (Class<?>) DownloadHandleNotificationActivity.class);
                intent.setAction(Constants.ACTION_REQUEST_NOTIFICATION_PERMISSION);
                intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
                appContext.startActivity(intent);
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "requestNotificationPermission", "Error2:" + th);
        }
    }
}
