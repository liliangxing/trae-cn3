package com.ss.android.socialbase.downloader.monitor;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.IMonitorConfig;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.DownloadTTNetException;
import com.ss.android.socialbase.downloader.model.DownloadCdnStats;
import com.ss.android.socialbase.downloader.model.DownloadDBInitInfo;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTimingInfo;
import com.ss.android.socialbase.downloader.network.AbsDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDefaultDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.segment.Segment;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.ttm.player.MediaPlayer;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadMonitorHelper {
    private static final String DEFAULT_MONITOR_SCENE = "default";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DownloadMonitorInfo {
        boolean addListenerToSameTask;
        long allConnectTime;
        AsyncHandleStatus asyncHandleStatus;
        long backCurBytes;
        boolean backUpUrlUsed;
        List<String> backUpUrls;
        ByteInvalidRetryStatus byteInvalidRetryStatus;
        String contentEncoding;
        int curBackUpUrlIndex;
        long curBytes;
        int curNetworkRetryCount;
        long curRetryTime;
        long curRetryTimeInTotal;
        double downloadSpeed;
        DownloadThreadInfo downloadThreadInfo;
        long downloadTime;
        DownloadTimingInfo downloadTimingInfo;
        int enqueueType;
        String eventPage;
        BaseException exception;
        String extra;
        boolean fastDownload;
        long firstSpeedTime;
        List<String> forbiddenBackupUrls;
        boolean force;
        String httpRequestHeader;
        String httpResponseHeader;
        boolean httpsToHttpRetryUsed;

        /* renamed from: id */
        int f78id;
        boolean isCacheExistsInDownloading;
        String md5;
        long md5Time;
        String mimeType;
        int monitorStatus;
        String name;
        boolean needDefaultHttpServiceBackUp;
        boolean needHttpsToHttpRetry;
        boolean needIndependentProcess;
        String networkQuality;
        boolean onlyWifi;
        JSONObject pcdnStats;
        long realBackDownloadTime;
        long realDownloadTime;
        String requestLog;
        int retryCount;
        String savePath;
        int sleepTime;
        long throttleNetSpeed;
        long totalBytes;
        String url;

        private DownloadMonitorInfo() {
            this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
            this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        }
    }

    private static DownloadMonitorInfo translateDownloadMonitorInfo(String str, DownloadInfo downloadInfo, DownloadTask downloadTask, BaseException baseException, int i) {
        DownloadMonitorInfo downloadMonitorInfo = new DownloadMonitorInfo();
        downloadMonitorInfo.monitorStatus = i;
        downloadMonitorInfo.exception = baseException;
        downloadMonitorInfo.eventPage = str;
        if (downloadInfo != null) {
            downloadMonitorInfo.f78id = downloadInfo.getId();
            downloadMonitorInfo.name = downloadInfo.getName();
            downloadMonitorInfo.url = downloadInfo.getUrl();
            downloadMonitorInfo.savePath = downloadInfo.getSavePath();
            downloadMonitorInfo.downloadTime = downloadInfo.getDownloadTime();
            downloadMonitorInfo.curBytes = downloadInfo.getCurBytes();
            downloadMonitorInfo.backCurBytes = downloadInfo.getBackCurBytes();
            downloadMonitorInfo.totalBytes = downloadInfo.getTotalBytes();
            downloadMonitorInfo.networkQuality = downloadInfo.getNetworkQuality();
            downloadMonitorInfo.onlyWifi = downloadInfo.isOnlyWifi();
            downloadMonitorInfo.needHttpsToHttpRetry = downloadInfo.isNeedHttpsToHttpRetry();
            downloadMonitorInfo.httpsToHttpRetryUsed = downloadInfo.isHttpsToHttpRetryUsed();
            downloadMonitorInfo.md5 = downloadInfo.getMd5();
            downloadMonitorInfo.force = downloadInfo.isForce();
            downloadMonitorInfo.retryCount = downloadInfo.getRetryCount();
            downloadMonitorInfo.needDefaultHttpServiceBackUp = downloadInfo.isNeedDefaultHttpServiceBackUp();
            downloadMonitorInfo.byteInvalidRetryStatus = downloadInfo.getByteInvalidRetryStatus();
            downloadMonitorInfo.asyncHandleStatus = downloadInfo.getAsyncHandleStatus();
            downloadMonitorInfo.needIndependentProcess = downloadInfo.isNeedIndependentProcess();
            downloadMonitorInfo.extra = downloadInfo.getExtra();
            downloadMonitorInfo.addListenerToSameTask = downloadInfo.isAddListenerToSameTask();
            downloadMonitorInfo.backUpUrls = downloadInfo.getBackUpUrls();
            downloadMonitorInfo.curBackUpUrlIndex = downloadInfo.getCurBackUpUrlIndex();
            downloadMonitorInfo.forbiddenBackupUrls = downloadInfo.getForbiddenBackupUrls();
            downloadMonitorInfo.curNetworkRetryCount = downloadInfo.getCurNetworkRetryCount();
            downloadMonitorInfo.isCacheExistsInDownloading = downloadInfo.isCacheExistsInDownloading();
            downloadMonitorInfo.mimeType = downloadInfo.getMimeType();
            downloadMonitorInfo.contentEncoding = downloadInfo.getContentEncoding();
            downloadMonitorInfo.fastDownload = downloadInfo.isFastDownload();
            downloadMonitorInfo.pcdnStats = downloadInfo.getPcdnStats();
            downloadMonitorInfo.throttleNetSpeed = downloadInfo.getThrottleNetSpeed();
            downloadMonitorInfo.httpRequestHeader = downloadInfo.getHttpRequestHeader();
            downloadMonitorInfo.httpResponseHeader = downloadInfo.getHttpResponseHeader();
            downloadMonitorInfo.requestLog = downloadInfo.getRequestLog();
            downloadMonitorInfo.enqueueType = downloadInfo.getEnqueueType().ordinal();
            downloadMonitorInfo.sleepTime = downloadInfo.getTaskSleepTime();
            if (i == -3 || i == -4 || i == -1 || i == -2) {
                downloadMonitorInfo.allConnectTime = downloadInfo.getAllConnectTime();
                downloadMonitorInfo.firstSpeedTime = downloadInfo.getFirstSpeedTime();
                downloadMonitorInfo.realDownloadTime = downloadInfo.getRealDownloadTime();
                downloadMonitorInfo.realBackDownloadTime = downloadInfo.getRealBackDownloadTime();
                downloadMonitorInfo.backUpUrlUsed = downloadInfo.isBackUpUrlUsed();
                downloadMonitorInfo.curRetryTime = downloadInfo.getCurRetryTime();
                downloadMonitorInfo.curRetryTimeInTotal = downloadInfo.getCurRetryTimeInTotal();
                downloadMonitorInfo.md5Time = downloadInfo.getMd5Time();
            }
            if (i == -3) {
                downloadMonitorInfo.downloadSpeed = downloadInfo.getDownloadSpeed();
            }
        }
        if (downloadTask != null) {
            downloadMonitorInfo.downloadTimingInfo = downloadTask.getTimingInfo().copy();
            downloadMonitorInfo.downloadThreadInfo = downloadTask.getThreadInfo().copy();
        }
        return downloadMonitorInfo;
    }

    public static void monitorSend(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            IDownloadMonitorDepend monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!isMonitorStatus && !(isMonitorStatus = isMonitorStatus(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof AbsDownloadMonitorDepend)) {
                isMonitorStatus = isMonitorStatus(((AbsDownloadMonitorDepend) monitorDepend).getAdditionalMonitorStatus(), i);
            }
            if (isMonitorStatus) {
                try {
                    IDownloadDepend depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.monitorLogSend(downloadInfo, baseException, i);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                monitorSendWithTaskMonitor(monitorDepend, downloadInfo, baseException, i);
                monitorSendWithGlobalSdkMonitor(DownloadComponentManager.getDownloadMonitorListener(), downloadTask, downloadInfo, baseException, i);
            }
        } catch (Throwable th2) {
            monitorDownloadOtherError(th2);
            th2.printStackTrace();
        }
    }

    private static boolean isMonitorStatus(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void monitorSendWithTaskMonitor(final IDownloadMonitorDepend iDownloadMonitorDepend, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (iDownloadMonitorDepend == null) {
            return;
        }
        String eventPage = iDownloadMonitorDepend.getEventPage();
        if (TextUtils.isEmpty(eventPage)) {
            eventPage = "default";
        }
        final DownloadMonitorInfo translateDownloadMonitorInfo = translateDownloadMonitorInfo(eventPage, downloadInfo, null, baseException, i);
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject parseMonitorJson = DownloadMonitorHelper.parseMonitorJson(DownloadMonitorInfo.this);
                    if (parseMonitorJson == null) {
                        parseMonitorJson = new JSONObject();
                    }
                    iDownloadMonitorDepend.monitorLogSend(parseMonitorJson);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public static void monitorSendWithGlobalSdkMonitor(final IDownloadMonitorListener iDownloadMonitorListener, DownloadTask downloadTask, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (iDownloadMonitorListener == null || !downloadInfo.isNeedSDKMonitor()) {
            return;
        }
        final DownloadMonitorInfo translateDownloadMonitorInfo = translateDownloadMonitorInfo(downloadInfo.getMonitorScene(), downloadInfo, downloadTask, baseException, i);
        DownloadComponentManager.submitCPUTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.monitor.DownloadMonitorHelper.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject parseMonitorJson = DownloadMonitorHelper.parseMonitorJson(DownloadMonitorInfo.this);
                    if (parseMonitorJson == null) {
                        parseMonitorJson = new JSONObject();
                    }
                    if (DownloadMonitorInfo.this.monitorStatus != -1) {
                        DownloadMonitorHelper.putMonitorJsonStatus(DownloadMonitorInfo.this, parseMonitorJson);
                        iDownloadMonitorListener.monitorEvent(MonitorConstants.EXTRA_DOWNLOAD_SERVICE_NAME_COMMON, parseMonitorJson, null, null);
                    } else {
                        parseMonitorJson.put("status", DownloadMonitorInfo.this.exception.getErrorCode());
                        parseMonitorJson.put(MonitorConstants.NET_CONNECTED, DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) ? 1 : 0);
                        iDownloadMonitorListener.monitorEvent(MonitorConstants.EXTRA_DOWNLOAD_SERVICE_NAME_FAIL, parseMonitorJson, null, null);
                    }
                } catch (Throwable th) {
                    DownloadMonitorHelper.monitorDownloadOtherError(th);
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putMonitorJsonStatus(DownloadMonitorInfo downloadMonitorInfo, JSONObject jSONObject) throws JSONException {
        String str;
        int i = downloadMonitorInfo.monitorStatus;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            if (downloadMonitorInfo.downloadSpeed >= 0.0d) {
                jSONObject.put(MonitorConstants.DOWNLOAD_SPEED, downloadMonitorInfo.downloadSpeed);
            }
            jSONObject.put(MonitorConstants.THROTTLE_SPEED, downloadMonitorInfo.throttleNetSpeed);
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject parseMonitorJson(DownloadMonitorInfo downloadMonitorInfo) {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                IMonitorConfig monitorConfig = DownloadComponentManager.getMonitorConfig();
                if (monitorConfig != null) {
                    str = monitorConfig.getDeviceId();
                    str2 = DownloadUtils.parseDevicePostfix(str);
                    str3 = monitorConfig.getAppId();
                    i = monitorConfig.getUpdateVersion();
                } else {
                    i = 0;
                    str = "";
                    str2 = str;
                    str3 = str2;
                }
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, downloadMonitorInfo.eventPage);
                jSONObject2.put("app_id", str3);
                jSONObject2.put("device_id", str);
                jSONObject2.put(MonitorConstants.EXTRA_DEVICE_ID_POSTFIX, str2);
                jSONObject2.put(MonitorConstants.EXTRA_UPDATE_VERSION, i);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, downloadMonitorInfo.monitorStatus);
                jSONObject2.put(DownloadSettingKeys.SETTING_TAG, DownloadSetting.obtain(downloadMonitorInfo.f78id).optString(DownloadSettingKeys.SETTING_TAG));
                jSONObject2.put("download_id", downloadMonitorInfo.f78id);
                jSONObject2.put("name", downloadMonitorInfo.name);
                jSONObject2.put("url", downloadMonitorInfo.url);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadMonitorInfo.savePath);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_TIME, downloadMonitorInfo.downloadTime);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadMonitorInfo.curBytes);
                jSONObject2.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_BYTES, downloadMonitorInfo.backCurBytes);
                jSONObject2.put("total_bytes", downloadMonitorInfo.totalBytes);
                jSONObject2.put("network_quality", downloadMonitorInfo.networkQuality);
                int i2 = 1;
                jSONObject2.put("only_wifi", downloadMonitorInfo.onlyWifi ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_HTTPS_DEGRADE, downloadMonitorInfo.needHttpsToHttpRetry ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_HTTPS_DEGRADE_RETRY_USED, downloadMonitorInfo.httpsToHttpRetryUsed ? 1 : 0);
                jSONObject2.put("md5", downloadMonitorInfo.md5 == null ? "" : downloadMonitorInfo.md5);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_IS_FORCE, downloadMonitorInfo.force ? 1 : 0);
                jSONObject2.put("retry_count", downloadMonitorInfo.retryCount);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_DEFAULT_HTTP_SERVICE_BACKUP, downloadMonitorInfo.needDefaultHttpServiceBackUp ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BYTE_ERROR_RETRY_STATUS, downloadMonitorInfo.byteInvalidRetryStatus.ordinal());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_HANDLER_STATUS, downloadMonitorInfo.asyncHandleStatus.ordinal());
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NEED_INDEPENDENT_PROCESS, downloadMonitorInfo.needIndependentProcess ? 1 : 0);
                jSONObject2.put("extra", downloadMonitorInfo.extra != null ? downloadMonitorInfo.extra : "");
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_ADD_LISTENER_TO_SAME_TASK, downloadMonitorInfo.addListenerToSameTask ? 1 : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_COUNT, downloadMonitorInfo.backUpUrls != null ? downloadMonitorInfo.backUpUrls.size() : 0);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL, downloadMonitorInfo.backUpUrls != null ? downloadMonitorInfo.backUpUrls.toString() : "");
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BACKUP_URL_INDEX, downloadMonitorInfo.backUpUrls != null ? downloadMonitorInfo.curBackUpUrlIndex : -1);
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_FORBIDDEN_URLS, downloadMonitorInfo.forbiddenBackupUrls != null ? downloadMonitorInfo.forbiddenBackupUrls.toString() : "");
                jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_NETWORK_RETRY_COUNT, downloadMonitorInfo.curNetworkRetryCount);
                jSONObject2.put(MonitorConstants.EXTRA_CACHE_EXISTS_IN_DOWNLOADING, downloadMonitorInfo.isCacheExistsInDownloading);
                jSONObject2.put(MonitorConstants.EXTRA_CONTENT_TYPE, downloadMonitorInfo.mimeType);
                jSONObject2.put(MonitorConstants.EXTRA_CONTENT_ENCODING, downloadMonitorInfo.contentEncoding);
                jSONObject2.put("fast_download", downloadMonitorInfo.fastDownload ? 1 : 0);
                jSONObject2.put(MonitorConstants.REQUEST_LOG, downloadMonitorInfo.requestLog == null ? "" : downloadMonitorInfo.requestLog);
                jSONObject2.put(MonitorConstants.REQUEST_HEADER, downloadMonitorInfo.httpRequestHeader == null ? "" : downloadMonitorInfo.httpRequestHeader);
                jSONObject2.put(MonitorConstants.RESPONSE_HEADER, downloadMonitorInfo.httpResponseHeader == null ? "" : downloadMonitorInfo.httpResponseHeader);
                jSONObject2.put(MonitorConstants.ENQUEUE_TYPE, downloadMonitorInfo.enqueueType);
                jSONObject2.put(MonitorConstants.EXTRA_TASK_SLEEP_TIME, downloadMonitorInfo.sleepTime);
                String curProcessName = DownloadUtils.getCurProcessName(DownloadComponentManager.getAppContext());
                if (curProcessName == null) {
                    curProcessName = "";
                }
                jSONObject2.put(MonitorConstants.EXTRA_PROCESS_NAME, curProcessName);
                if (downloadMonitorInfo.pcdnStats != null) {
                    jSONObject2.put(MonitorConstants.EXTRA_PCDN_LOG, downloadMonitorInfo.pcdnStats);
                }
                if (downloadMonitorInfo.downloadTimingInfo != null) {
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_ORIGIN_TIMING_INFO, downloadMonitorInfo.downloadTimingInfo.obtainOriginStats());
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_TIMING_INFO, downloadMonitorInfo.downloadTimingInfo.obtainDurationStats());
                }
                if (downloadMonitorInfo.downloadThreadInfo != null) {
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_THREAD_INFO, downloadMonitorInfo.downloadThreadInfo.obtainStats());
                }
                if (downloadMonitorInfo.monitorStatus == -3 || downloadMonitorInfo.monitorStatus == -4 || downloadMonitorInfo.monitorStatus == -1 || downloadMonitorInfo.monitorStatus == -2) {
                    jSONObject2.put(MonitorConstants.ALL_CONNECT_TIME, downloadMonitorInfo.allConnectTime);
                    jSONObject2.put(MonitorConstants.FIRST_SPEED_TIME, downloadMonitorInfo.firstSpeedTime);
                    jSONObject2.put(MonitorConstants.REAL_DOWNLOAD_TIME, downloadMonitorInfo.realDownloadTime);
                    jSONObject2.put(MonitorConstants.EXTRA_BACKGROUND_DOWNLOAD_TIME, downloadMonitorInfo.realBackDownloadTime);
                    if (!downloadMonitorInfo.backUpUrlUsed) {
                        i2 = 0;
                    }
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_BACKUP_URL_USED, i2);
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_RETRY_TIME, downloadMonitorInfo.curRetryTime);
                    jSONObject2.put(MonitorConstants.EXTRA_CUR_RETRY_TIME_IN_TOTAL, downloadMonitorInfo.curRetryTimeInTotal);
                    jSONObject2.put(MonitorConstants.EXTRA_DOWNLOAD_MD5_TIME, downloadMonitorInfo.md5Time);
                    try {
                        jSONObject2.put(MonitorConstants.EXTRA_DEVICE_AVAILABLE_SPACE, ((DownloadUtils.getAvailableSpaceBytes(downloadMonitorInfo.savePath) / 1024) / 1024) / 100);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                try {
                    if (TextUtils.isEmpty(downloadMonitorInfo.url)) {
                        str4 = "";
                        str5 = str4;
                        str6 = str5;
                    } else {
                        Uri parse = Uri.parse(downloadMonitorInfo.url);
                        str5 = parse.getHost();
                        str6 = parse.getPath();
                        str4 = parse.getLastPathSegment();
                        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str4)) {
                            try {
                                str6 = str6.substring(0, str6.length() - str4.length());
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    }
                    jSONObject2.put(MonitorConstants.URL_HOST, str5);
                    jSONObject2.put(MonitorConstants.URL_PATH, str6);
                    jSONObject2.put(MonitorConstants.URL_LAST_PATH_SEGMENT, str4);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                jSONObject2.put("error_code", downloadMonitorInfo.exception != null ? downloadMonitorInfo.exception.getErrorCode() : 0);
                jSONObject2.put("error_msg", downloadMonitorInfo.exception != null ? downloadMonitorInfo.exception.getErrorMessage() : "");
                return jSONObject2;
            } catch (JSONException e) {
                e = e;
                jSONObject = jSONObject2;
                monitorDownloadOtherError(e);
                e.printStackTrace();
                return jSONObject;
            }
        } catch (JSONException e2) {
            e = e2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:12|(4:67|68|69|(15:71|15|(2:49|(1:(2:57|(2:62|63)(1:61)))(1:54))|18|19|(2:23|24)|27|28|29|(1:31)|32|33|(1:45)|36|(2:40|42)(1:39)))|14|15|(0)|49|(1:51)|(0)|18|19|(3:21|23|24)|27|28|29|(0)|32|33|(0)|43|45|36|(0)|40|42) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0114, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0115, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9 A[Catch: JSONException -> 0x0114, all -> 0x013a, TryCatch #0 {JSONException -> 0x0114, blocks: (B:29:0x00af, B:31:0x00e9, B:32:0x00fa), top: B:28:0x00af, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0057 A[Catch: all -> 0x013a, TryCatch #2 {all -> 0x013a, blocks: (B:69:0x0030, B:71:0x0034, B:19:0x0081, B:21:0x0097, B:27:0x00aa, B:29:0x00af, B:31:0x00e9, B:32:0x00fa, B:40:0x012e, B:43:0x0120, B:45:0x0126, B:48:0x0115, B:49:0x0046, B:51:0x004c, B:57:0x0057, B:59:0x0061, B:63:0x0070, B:66:0x0077, B:75:0x002d, B:68:0x0026), top: B:12:0x0024, inners: #0, #3, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void monitorDownloadConnect(IDownloadHeadHttpConnection iDownloadHeadHttpConnection, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        DownloadSetting obtain;
        int optInt;
        String hostIp;
        String errorMessage;
        int httpStatusCode;
        String path;
        String lastPathSegment;
        JSONObject jSONObject;
        IDownloadMonitorListener downloadMonitorListener;
        if (downloadInfo == null || (optInt = (obtain = DownloadSetting.obtain(downloadInfo.getId())).optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_CONNECT, 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = -1;
        try {
            if (iDownloadHeadHttpConnection != null) {
                try {
                    i2 = iDownloadHeadHttpConnection.getResponseCode();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                if (iDownloadHeadHttpConnection instanceof AbsDownloadHttpConnection) {
                    hostIp = ((AbsDownloadHttpConnection) iDownloadHeadHttpConnection).getHostIp();
                    if (i2 >= 200 || i2 >= 400) {
                        if (downloadInfo.getCurRetryTime() == 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                            return;
                        }
                        if (iOException != null) {
                            if (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) || DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK)) {
                                try {
                                    DownloadHelper.parseException(iOException, "");
                                } catch (BaseException e) {
                                    i2 = e.getErrorCode();
                                    errorMessage = e.getErrorMessage();
                                }
                            } else {
                                i2 = 1049;
                            }
                        }
                    }
                    errorMessage = null;
                    Uri parse = Uri.parse(str);
                    String host = parse.getHost();
                    path = parse.getPath();
                    lastPathSegment = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                        try {
                            path = path.substring(0, path.length() - lastPathSegment.length());
                        } catch (Throwable unused) {
                        }
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put(DownloadSettingKeys.SETTING_TAG, obtain.optString(DownloadSettingKeys.SETTING_TAG));
                    jSONObject.put(MonitorConstants.URL_HOST, host);
                    jSONObject.putOpt(MonitorConstants.HOST_IP, str2);
                    jSONObject.putOpt(MonitorConstants.HOST_REAL_IP, hostIp);
                    jSONObject.put(MonitorConstants.URL_PATH, path);
                    jSONObject.put(MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
                    jSONObject.put(MonitorConstants.NET_LIB, i);
                    jSONObject.put(MonitorConstants.CONNECT_TYPE, str3);
                    jSONObject.put(MonitorConstants.STATUS_CODE, i2);
                    if (errorMessage != null) {
                        jSONObject.put("error_msg", DownloadHelper.getFixLengthString(errorMessage, obtain.optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE)));
                    }
                    jSONObject.put(MonitorConstants.CONNECT_TIME, j);
                    jSONObject.put(MonitorConstants.PKG_NAME, downloadInfo.getPackageName());
                    jSONObject.put("name", downloadInfo.getTitle());
                    if ((optInt != 1 || optInt == 3) && (downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener()) != null) {
                        downloadMonitorListener.monitorEvent(MonitorConstants.DOWNLOAD_CONNECT, jSONObject, null, null);
                    }
                    if (optInt != 2 || optInt == 3) {
                        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.DOWNLOAD_CONNECT, jSONObject);
                    }
                    return;
                }
            }
            hostIp = null;
            if (i2 >= 200) {
            }
            if (downloadInfo.getCurRetryTime() == 0) {
            }
            if (iOException != null) {
            }
            errorMessage = null;
            Uri parse2 = Uri.parse(str);
            String host2 = parse2.getHost();
            path = parse2.getPath();
            lastPathSegment = parse2.getLastPathSegment();
            if (!TextUtils.isEmpty(path)) {
                path = path.substring(0, path.length() - lastPathSegment.length());
            }
            jSONObject = new JSONObject();
            jSONObject.put(DownloadSettingKeys.SETTING_TAG, obtain.optString(DownloadSettingKeys.SETTING_TAG));
            jSONObject.put(MonitorConstants.URL_HOST, host2);
            jSONObject.putOpt(MonitorConstants.HOST_IP, str2);
            jSONObject.putOpt(MonitorConstants.HOST_REAL_IP, hostIp);
            jSONObject.put(MonitorConstants.URL_PATH, path);
            jSONObject.put(MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
            jSONObject.put(MonitorConstants.NET_LIB, i);
            jSONObject.put(MonitorConstants.CONNECT_TYPE, str3);
            jSONObject.put(MonitorConstants.STATUS_CODE, i2);
            if (errorMessage != null) {
            }
            jSONObject.put(MonitorConstants.CONNECT_TIME, j);
            jSONObject.put(MonitorConstants.PKG_NAME, downloadInfo.getPackageName());
            jSONObject.put("name", downloadInfo.getTitle());
            if (optInt != 1) {
            }
            downloadMonitorListener.monitorEvent(MonitorConstants.DOWNLOAD_CONNECT, jSONObject, null, null);
            if (optInt != 2) {
            }
            DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.DOWNLOAD_CONNECT, jSONObject);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorDownloadIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        monitorIO(MonitorConstants.DOWNLOAD_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_DOWNLOAD_IO), downloadSetting, downloadInfo, str, null, null, iDownloadHttpConnection, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void monitorSegmentIO(DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, IDownloadHttpConnection iDownloadHttpConnection, BaseException baseException, long j, long j2) {
        monitorIO(MonitorConstants.SEGMENT_IO, downloadSetting.optInt(DownloadSettingKeys.MONITOR_SEGMENT_IO), downloadSetting, downloadInfo, str, str2, str3, iDownloadHttpConnection, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007b A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:6:0x0017, B:8:0x002e, B:17:0x0070, B:19:0x007b, B:22:0x0082, B:24:0x008e, B:25:0x0098, B:29:0x00a5, B:31:0x00a9, B:32:0x00af, B:34:0x00b3, B:36:0x00c7, B:38:0x0118, B:39:0x0129, B:41:0x013b, B:43:0x0144, B:44:0x0162, B:53:0x0195, B:56:0x0181, B:58:0x0187, B:66:0x004c, B:68:0x0056, B:71:0x0069, B:72:0x0065), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0118 A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:6:0x0017, B:8:0x002e, B:17:0x0070, B:19:0x007b, B:22:0x0082, B:24:0x008e, B:25:0x0098, B:29:0x00a5, B:31:0x00a9, B:32:0x00af, B:34:0x00b3, B:36:0x00c7, B:38:0x0118, B:39:0x0129, B:41:0x013b, B:43:0x0144, B:44:0x0162, B:53:0x0195, B:56:0x0181, B:58:0x0187, B:66:0x004c, B:68:0x0056, B:71:0x0069, B:72:0x0065), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013b A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:6:0x0017, B:8:0x002e, B:17:0x0070, B:19:0x007b, B:22:0x0082, B:24:0x008e, B:25:0x0098, B:29:0x00a5, B:31:0x00a9, B:32:0x00af, B:34:0x00b3, B:36:0x00c7, B:38:0x0118, B:39:0x0129, B:41:0x013b, B:43:0x0144, B:44:0x0162, B:53:0x0195, B:56:0x0181, B:58:0x0187, B:66:0x004c, B:68:0x0056, B:71:0x0069, B:72:0x0065), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0144 A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:6:0x0017, B:8:0x002e, B:17:0x0070, B:19:0x007b, B:22:0x0082, B:24:0x008e, B:25:0x0098, B:29:0x00a5, B:31:0x00a9, B:32:0x00af, B:34:0x00b3, B:36:0x00c7, B:38:0x0118, B:39:0x0129, B:41:0x013b, B:43:0x0144, B:44:0x0162, B:53:0x0195, B:56:0x0181, B:58:0x0187, B:66:0x004c, B:68:0x0056, B:71:0x0069, B:72:0x0065), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0193 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0187 A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:6:0x0017, B:8:0x002e, B:17:0x0070, B:19:0x007b, B:22:0x0082, B:24:0x008e, B:25:0x0098, B:29:0x00a5, B:31:0x00a9, B:32:0x00af, B:34:0x00b3, B:36:0x00c7, B:38:0x0118, B:39:0x0129, B:41:0x013b, B:43:0x0144, B:44:0x0162, B:53:0x0195, B:56:0x0181, B:58:0x0187, B:66:0x004c, B:68:0x0056, B:71:0x0069, B:72:0x0065), top: B:5:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c0  */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void monitorIO(String str, int i, DownloadSetting downloadSetting, DownloadInfo downloadInfo, String str2, String str3, String str4, IDownloadHttpConnection iDownloadHttpConnection, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        int i2;
        String errorMessage;
        long j6;
        String str5;
        int i3;
        int i4;
        double nanos;
        IDownloadMonitorListener downloadMonitorListener;
        String str6;
        int i5;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri parse = Uri.parse(str2);
            String host = parse.getHost();
            String path = parse.getPath();
            String lastPathSegment = parse.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                i2 = 1;
            } else if (z2) {
                i2 = 2;
            } else {
                if (baseException != null) {
                    i2 = (DownloadUtils.isNetworkConnected(DownloadComponentManager.getAppContext()) || DownloadSetting.getGlobalSettings().optBoolean(DownloadSettingKeys.DISABLE_CHECK_NO_NETWORK)) ? baseException.getErrorCode() : 1049;
                    errorMessage = baseException.getErrorMessage();
                    JSONObject jSONObject2 = new JSONObject();
                    if (iDownloadHttpConnection == null) {
                        i3 = iDownloadHttpConnection instanceof IDefaultDownloadHttpConnection ? 0 : 1;
                        String responseHeaderField = iDownloadHttpConnection.getResponseHeaderField(DownloadHelper.X_CACHE);
                        ?? contains = TextUtils.isEmpty(responseHeaderField) ? -1 : responseHeaderField.toLowerCase().contains("hit");
                        if (downloadSetting.optInt(DownloadSettingKeys.MONITOR_SLA, 1) == 1 && !z && !z2 && (iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
                            ((AbsDownloadHttpConnection) iDownloadHttpConnection).monitorNetworkInfo(jSONObject2, true);
                        }
                        j6 = j;
                        str5 = iDownloadHttpConnection instanceof AbsDownloadHttpConnection ? ((AbsDownloadHttpConnection) iDownloadHttpConnection).getRequestLog() : "";
                        i4 = contains;
                    } else {
                        j6 = j;
                        str5 = "";
                        i3 = -1;
                        i4 = -1;
                    }
                    double d = j6 / 1048576.0d;
                    double d2 = j2;
                    nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
                    jSONObject2.put(DownloadSettingKeys.SETTING_TAG, downloadSetting.optString(DownloadSettingKeys.SETTING_TAG));
                    jSONObject2.put(MonitorConstants.URL_HOST, host);
                    jSONObject2.putOpt(MonitorConstants.HOST_IP, str3);
                    jSONObject2.putOpt(MonitorConstants.HOST_REAL_IP, str4);
                    jSONObject2.put(MonitorConstants.URL_PATH, path);
                    jSONObject2.put(MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
                    jSONObject2.put(MonitorConstants.NET_LIB, i3);
                    jSONObject2.put("hit_cdn_cache", i4);
                    jSONObject2.put(MonitorConstants.STATUS_CODE, i2);
                    jSONObject2.put(MonitorConstants.REQUEST_LOG, str5);
                    if (errorMessage != null) {
                        jSONObject2.put("error_msg", DownloadHelper.getFixLengthString(errorMessage, downloadSetting.optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE)));
                    }
                    jSONObject2.put(MonitorConstants.DOWNLOAD_SEC, nanos);
                    jSONObject2.put(MonitorConstants.DOWNLOAD_MB, d);
                    if (nanos > 0.0d) {
                        jSONObject2.put(MonitorConstants.DOWNLOAD_SPEED, d / nanos);
                    }
                    if (z3) {
                        jSONObject2.put(MonitorConstants.RW_READ_TIME, j3 / d2);
                        jSONObject2.put(MonitorConstants.RW_WRITE_TIME, j4 / d2);
                        jSONObject2.put(MonitorConstants.RW_SYNC_TIME, j5 / d2);
                    }
                    jSONObject2.put(MonitorConstants.PKG_NAME, downloadInfo.getPackageName());
                    jSONObject2.put("name", downloadInfo.getTitle());
                    if (i != 1 && i != 3) {
                        i5 = 2;
                        str6 = str;
                        if (i != i5 || i == 3) {
                            DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject2);
                        }
                        return;
                    }
                    downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
                    if (downloadMonitorListener == null) {
                        str6 = str;
                        downloadMonitorListener.monitorEvent(str6, jSONObject2, null, null);
                    } else {
                        str6 = str;
                    }
                    i5 = 2;
                    if (i != i5) {
                    }
                    DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject2);
                }
                i2 = 0;
            }
            errorMessage = null;
            JSONObject jSONObject22 = new JSONObject();
            if (iDownloadHttpConnection == null) {
            }
            double d3 = j6 / 1048576.0d;
            double d22 = j2;
            nanos = d22 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject22.put(DownloadSettingKeys.SETTING_TAG, downloadSetting.optString(DownloadSettingKeys.SETTING_TAG));
            jSONObject22.put(MonitorConstants.URL_HOST, host);
            jSONObject22.putOpt(MonitorConstants.HOST_IP, str3);
            jSONObject22.putOpt(MonitorConstants.HOST_REAL_IP, str4);
            jSONObject22.put(MonitorConstants.URL_PATH, path);
            jSONObject22.put(MonitorConstants.URL_LAST_PATH_SEGMENT, lastPathSegment);
            jSONObject22.put(MonitorConstants.NET_LIB, i3);
            jSONObject22.put("hit_cdn_cache", i4);
            jSONObject22.put(MonitorConstants.STATUS_CODE, i2);
            jSONObject22.put(MonitorConstants.REQUEST_LOG, str5);
            if (errorMessage != null) {
            }
            jSONObject22.put(MonitorConstants.DOWNLOAD_SEC, nanos);
            jSONObject22.put(MonitorConstants.DOWNLOAD_MB, d3);
            if (nanos > 0.0d) {
            }
            if (z3) {
            }
            jSONObject22.put(MonitorConstants.PKG_NAME, downloadInfo.getPackageName());
            jSONObject22.put("name", downloadInfo.getTitle());
            if (i != 1) {
                i5 = 2;
                str6 = str;
                if (i != i5) {
                }
                DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject22);
            }
            downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
            if (downloadMonitorListener == null) {
            }
            i5 = 2;
            if (i != i5) {
            }
            DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), str6, jSONObject22);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorSegmentsError(DownloadInfo downloadInfo, List<Segment> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DBDefinition.SEGMENT_TABLE_NAME, Segment.toString(list));
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            InnerEventListener eventListener = DownloadComponentManager.getEventListener();
            if (eventListener != null) {
                eventListener.onEvent(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorDownloadDB(DownloadDBInitInfo downloadDBInitInfo) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MonitorConstants.DB_INIT_DURATION, downloadDBInitInfo.initDuration);
            jSONObject.put(MonitorConstants.DB_INIT_DISK_CACHE_COUNT, downloadDBInitInfo.diskCacheCount);
            jSONObject.put(MonitorConstants.DB_INIT_MEMORY_CACHE_COUNT, downloadDBInitInfo.memoryCacheCount);
            jSONObject.put(MonitorConstants.DB_INIT_DISK_CACHE_SIZE, downloadDBInitInfo.diskCacheSize);
            downloadMonitorListener.monitorEvent(MonitorConstants.DOWNLOAD_DB, jSONObject, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorDownloadCDN(String str, IDownloadHttpConnection iDownloadHttpConnection, Throwable th, IDownloadCdnListener iDownloadCdnListener) {
        if (iDownloadCdnListener == null || str == null) {
            return;
        }
        DownloadCdnStats downloadCdnStats = new DownloadCdnStats();
        boolean z = true;
        if (iDownloadHttpConnection != null && (iDownloadHttpConnection instanceof AbsDownloadHttpConnection)) {
            AbsDownloadHttpConnection absDownloadHttpConnection = (AbsDownloadHttpConnection) iDownloadHttpConnection;
            try {
                downloadCdnStats.isTTNet = absDownloadHttpConnection.isOkhttp() ? false : true;
                downloadCdnStats.responseCode = absDownloadHttpConnection.getResponseCode();
                downloadCdnStats.f74ip = absDownloadHttpConnection.getHostIp();
                downloadCdnStats.cacheHit = DownloadHelper.isCdnCacheHit(absDownloadHttpConnection.getResponseHeaders());
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            r1 = true;
        }
        if (th != null) {
            if (downloadCdnStats.responseCode <= 0) {
                downloadCdnStats.responseCode = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getTTNetHandler().getResponseCode(th);
            }
            try {
                DownloadHelper.parseException(th, "monitor_cdn");
            } catch (DownloadTTNetException e) {
                if (downloadCdnStats.f74ip == null) {
                    downloadCdnStats.f74ip = e.getRemoteIp();
                }
                downloadCdnStats.errorCode = e.getErrorCode();
            } catch (BaseException e2) {
                downloadCdnStats.errorCode = e2.getErrorCode();
            }
            downloadCdnStats.errorMsg = th.toString();
        } else {
            z = r1;
        }
        if (z) {
            try {
                downloadCdnStats.host = Uri.parse(str).getHost();
            } catch (Throwable unused) {
            }
            iDownloadCdnListener.onCollectStats(downloadCdnStats);
        }
    }

    public static void monitorDownloadOtherError(Throwable th) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error_code", 1091);
            jSONObject.put("error_msg", th.toString());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_STATUS, -1);
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ERROR_STACK, Log.getStackTraceString(th));
            downloadMonitorListener.monitorEvent(MonitorConstants.EXTRA_DOWNLOAD_SERVICE_NAME_FAIL, jSONObject, null, null);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void monitorDownloadApp(DownloadInfo downloadInfo, String str, int i) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, downloadInfo.getMonitorScene());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_CUR_BYTES, downloadInfo.getCurBytes());
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_SAVE_PATH, downloadInfo.getSavePath());
            jSONObject.put(MonitorConstants.APP_INSTALL_STATUS, str);
            jSONObject.put(MonitorConstants.APP_INSTALL_RESULT_CODE, i);
            downloadMonitorListener.monitorEvent(MonitorConstants.DOWNLOAD_INSTALL_APP, jSONObject, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void monitorDownloadDiskCache(JSONObject jSONObject) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(MonitorConstants.DISK_DATA, jSONObject.toString());
            downloadMonitorListener.monitorEvent(MonitorConstants.DOWNLOAD_DISK_CACHE, jSONObject2, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
