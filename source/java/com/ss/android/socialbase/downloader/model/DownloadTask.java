package com.ss.android.socialbase.downloader.model;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.ListenerType;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IDownloadStartCallback;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadMonitorHelperService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadTask {
    private static final String TAG = "DownloadTask";
    private boolean autoRemoveCallback;
    private boolean autoSetHashCodeForSameTask;
    private IDownloadCdnListener cdnListener;
    private IDownloadDepend depend;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private final List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private DownloadInfo downloadInfo;
    private DownloadInfo.Builder downloadInfoBuilder;
    private IDownloadFileUriProvider fileUriProvider;
    private IDownloadForbiddenHandler forbiddenHandler;
    private int hashCodeForSameTask;
    private IDownloadInterceptor interceptor;
    private int mPriority;
    private JSONObject mReplaceSetting;
    private final Map<Integer, IDownloadListener> mainThreadListeners;
    private IDownloadMonitorDepend monitorDepend;
    private boolean needDelayForCacheSync;
    private INotificationClickCallback notificationClickCallback;
    private IDownloadNotificationEventListener notificationEventListener;
    private final Map<Integer, IDownloadListener> notificationListeners;
    private final Map<Integer, ListenerType> singleListenerHashCodeMap;
    private final Map<ListenerType, IDownloadListener> singleListenerMap;
    private final Map<Integer, IDownloadListener> subThreadListeners;
    private DownloadThreadInfo threadInfo;
    private DownloadTimingInfo timingInfo;

    @Deprecated
    public DownloadTask headConnectionAvailable(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask needChunkDowngradeRetry(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask needRetryDelay(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask needReuseChunkRunnable(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask needReuseFirstConnection(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask newSaveTempFileEnable(boolean z) {
        return this;
    }

    @Deprecated
    public DownloadTask retryDelayTimeArray(String str) {
        return this;
    }

    @Deprecated
    public DownloadTask retryDelayTimeCalculator(IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        return this;
    }

    public DownloadInfo getDownloadInfo() {
        return this.downloadInfo;
    }

    public DownloadTask() {
        this.singleListenerMap = new ConcurrentHashMap();
        this.singleListenerHashCodeMap = new ConcurrentHashMap();
        this.needDelayForCacheSync = false;
        this.downloadCompleteHandlers = new CopyOnWriteArrayList();
        this.autoRemoveCallback = false;
        this.timingInfo = new DownloadTimingInfo();
        this.threadInfo = new DownloadThreadInfo();
        this.autoSetHashCodeForSameTask = true;
        this.mPriority = 0;
        this.downloadInfoBuilder = new DownloadInfo.Builder();
        this.mainThreadListeners = new ConcurrentHashMap();
        this.subThreadListeners = new ConcurrentHashMap();
        this.notificationListeners = new ConcurrentHashMap();
    }

    public DownloadTask(DownloadInfo downloadInfo) {
        this();
        this.downloadInfo = downloadInfo;
    }

    public DownloadTask setTaskPriority(int i) {
        this.mPriority = i;
        return this;
    }

    public int getTaskPriority() {
        return this.mPriority;
    }

    public boolean isNeedDelayForCacheSync() {
        return this.needDelayForCacheSync;
    }

    public void setNeedDelayForCacheSync(boolean z) {
        this.needDelayForCacheSync = z;
    }

    public IDownloadInterceptor getInterceptor() {
        return this.interceptor;
    }

    public IDownloadDepend getDepend() {
        return this.depend;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public IDownloadForbiddenHandler getForbiddenHandler() {
        return this.forbiddenHandler;
    }

    public IDownloadDiskSpaceHandler getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public IDownloadNotificationEventListener getNotificationEventListener() {
        return this.notificationEventListener;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public IDownloadCdnListener getCdnListener() {
        return this.cdnListener;
    }

    public int getHashCodeForSameTask() {
        return this.hashCodeForSameTask;
    }

    public boolean isAutoSetHashCodeForSameTask() {
        return this.autoSetHashCodeForSameTask;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public boolean canShowNotification() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            return downloadInfo.canShowNotification();
        }
        return false;
    }

    public DownloadTask mainThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : mainThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask mainThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.mainThreadListeners) {
                this.mainThreadListeners.put(Integer.valueOf(i), iDownloadListener);
            }
            this.singleListenerMap.put(ListenerType.MAIN, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(Integer.valueOf(i), ListenerType.MAIN);
            }
        }
        return this;
    }

    public DownloadTask subThreadListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : subThreadListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask subThreadListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.subThreadListeners) {
                this.subThreadListeners.put(Integer.valueOf(i), iDownloadListener);
            }
            this.singleListenerMap.put(ListenerType.SUB, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(Integer.valueOf(i), ListenerType.SUB);
            }
        }
        return this;
    }

    public DownloadTask notificationListener(IDownloadListener iDownloadListener) {
        return iDownloadListener == null ? this : notificationListenerWithHashCode(iDownloadListener.hashCode(), iDownloadListener);
    }

    public DownloadTask notificationListenerWithHashCode(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener != null) {
            synchronized (this.notificationListeners) {
                this.notificationListeners.put(Integer.valueOf(i), iDownloadListener);
            }
            this.singleListenerMap.put(ListenerType.NOTIFICATION, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(Integer.valueOf(i), ListenerType.NOTIFICATION);
            }
        }
        return this;
    }

    public DownloadTask notificationEventListener(IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
        return this;
    }

    public DownloadTask interceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.interceptor = iDownloadInterceptor;
        return this;
    }

    public DownloadTask depend(IDownloadDepend iDownloadDepend) {
        this.depend = iDownloadDepend;
        return this;
    }

    public DownloadTask monitorDepend(IDownloadMonitorDepend iDownloadMonitorDepend) {
        this.monitorDepend = iDownloadMonitorDepend;
        return this;
    }

    public DownloadTask notificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public DownloadTask forbiddenHandler(IDownloadForbiddenHandler iDownloadForbiddenHandler) {
        this.forbiddenHandler = iDownloadForbiddenHandler;
        return this;
    }

    public DownloadTask diskSpaceHandler(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.diskSpaceHandler = iDownloadDiskSpaceHandler;
        return this;
    }

    public DownloadTask name(String str) {
        this.downloadInfoBuilder.name(str);
        return this;
    }

    public DownloadTask title(String str) {
        this.downloadInfoBuilder.title(str);
        return this;
    }

    public DownloadTask url(String str) {
        this.downloadInfoBuilder.url(str);
        return this;
    }

    public DownloadTask pcdnUrls(List<String> list) {
        this.downloadInfoBuilder.pcdnUrls(list);
        return this;
    }

    public DownloadTask cdnUrls(List<String> list) {
        this.downloadInfoBuilder.cdnUrls(list);
        return this;
    }

    public DownloadTask ignoreInterceptor(boolean z) {
        this.downloadInfoBuilder.ignoreInterceptor(z);
        return this;
    }

    public DownloadTask savePath(String str) {
        this.downloadInfoBuilder.savePath(str);
        return this;
    }

    public DownloadTask tempPath(String str) {
        this.downloadInfoBuilder.tempPath(str);
        return this;
    }

    public DownloadTask startOffset(long j) {
        this.downloadInfoBuilder.startOffset(j);
        return this;
    }

    public DownloadTask endOffset(long j) {
        this.downloadInfoBuilder.endOffset(j);
        return this;
    }

    public DownloadTask autoRemoveCallback(boolean z) {
        this.autoRemoveCallback = z;
        return this;
    }

    public DownloadTask extra(String str) {
        this.downloadInfoBuilder.extra(str);
        return this;
    }

    public DownloadTask onlyWifi(boolean z) {
        this.downloadInfoBuilder.onlyWifi(z);
        return this;
    }

    public DownloadTask extraHeaders(List<HttpHeader> list) {
        this.downloadInfoBuilder.extraHeaders(list);
        return this;
    }

    public DownloadTask maxBytes(int i) {
        this.downloadInfoBuilder.maxBytes(i);
        return this;
    }

    public DownloadTask outIp(String[] strArr) {
        this.downloadInfoBuilder.outIp(strArr);
        return this;
    }

    public DownloadTask outSize(int[] iArr) {
        this.downloadInfoBuilder.outSize(iArr);
        return this;
    }

    public DownloadTask retryCount(int i) {
        this.downloadInfoBuilder.retryCount(i);
        return this;
    }

    public DownloadTask backUpUrlRetryCount(int i) {
        this.downloadInfoBuilder.backUpUrlRetryCount(i);
        return this;
    }

    public DownloadTask force(boolean z) {
        this.downloadInfoBuilder.force(z);
        return this;
    }

    public DownloadTask needPostProgress(boolean z) {
        this.downloadInfoBuilder.needPostProgress(z);
        return this;
    }

    public DownloadTask maxProgressCount(int i) {
        this.downloadInfoBuilder.maxProgressCount(i);
        return this;
    }

    public DownloadTask minProgressTimeMsInterval(int i) {
        this.downloadInfoBuilder.minProgressTimeMsInterval(i);
        return this;
    }

    public DownloadTask backUpUrls(List<String> list) {
        this.downloadInfoBuilder.backUpUrls(list);
        return this;
    }

    public DownloadTask accessHttpHeaderKeys(List<String> list) {
        this.downloadInfoBuilder.accessHttpHeaderKeys(list);
        return this;
    }

    public DownloadTask mimeType(String str) {
        this.downloadInfoBuilder.mimeType(str);
        return this;
    }

    public DownloadTask showNotification(boolean z) {
        this.downloadInfoBuilder.showNotification(z);
        return this;
    }

    public DownloadTask needHttpsToHttpRetry(boolean z) {
        this.downloadInfoBuilder.needHttpsToHttpRetry(z);
        return this;
    }

    public DownloadTask autoResumed(boolean z) {
        this.downloadInfoBuilder.autoResumed(z);
        return this;
    }

    public DownloadTask cdnListener(IDownloadCdnListener iDownloadCdnListener) {
        this.cdnListener = iDownloadCdnListener;
        return this;
    }

    public DownloadTask showNotificationForAutoResumed(boolean z) {
        this.downloadInfoBuilder.showNotificationForAutoResumed(z);
        return this;
    }

    public DownloadTask packageName(String str) {
        this.downloadInfoBuilder.packageName(str);
        return this;
    }

    public DownloadTask md5(String str) {
        this.downloadInfoBuilder.md5(str);
        return this;
    }

    public DownloadTask expectFileLength(long j) {
        this.downloadInfoBuilder.expectFileLength(j);
        return this;
    }

    public DownloadTask needDefaultHttpServiceBackUp(boolean z) {
        this.downloadInfoBuilder.needDefaultHttpServiceBackUp(z);
        return this;
    }

    public DownloadTask needIndependentProcess(boolean z) {
        this.downloadInfoBuilder.needIndependentProcess(z);
        return this;
    }

    public DownloadTask needCurrentProcess(boolean z) {
        this.downloadInfoBuilder.needCurrentProcess(z);
        return this;
    }

    public DownloadTask enqueueType(EnqueueType enqueueType) {
        this.downloadInfoBuilder.enqueueType(enqueueType);
        return this;
    }

    public DownloadTask ignoreDataVerify(boolean z) {
        this.downloadInfoBuilder.ignoreDataVerify(z);
        return this;
    }

    public DownloadTask fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public DownloadTask addListenerToSameTask(boolean z) {
        this.downloadInfoBuilder.addListenerToSameTask(z);
        return this;
    }

    public DownloadTask hashCodeForSameTask(int i) {
        this.hashCodeForSameTask = i;
        return this;
    }

    public DownloadTask autoSetHashCodeForSameTask(boolean z) {
        this.autoSetHashCodeForSameTask = z;
        return this;
    }

    public DownloadTask downloadSetting(JSONObject jSONObject) {
        this.downloadInfoBuilder.downloadSetting(jSONObject);
        return this;
    }

    public DownloadTask iconUrl(String str) {
        this.downloadInfoBuilder.iconUrl(str);
        return this;
    }

    public DownloadTask taskKey(String str) {
        this.downloadInfoBuilder.taskKey(str);
        return this;
    }

    public DownloadTask executorGroup(int i) {
        this.downloadInfoBuilder.executorGroup(i);
        return this;
    }

    public DownloadTask throttleNetSpeed(long j) {
        this.downloadInfoBuilder.throttleNetSpeed(j);
        return this;
    }

    public DownloadTask throttleSmoothness(int i) {
        this.downloadInfoBuilder.throttleSmoothness(i);
        return this;
    }

    public DownloadTask isOpenLimitSpeed(boolean z) {
        this.downloadInfoBuilder.isOpenLimitSpeed(z);
        return this;
    }

    public DownloadTask needSDKMonitor(boolean z) {
        this.downloadInfoBuilder.needSDKMonitor(z);
        return this;
    }

    public DownloadTask monitorScene(String str) {
        this.downloadInfoBuilder.monitorScene(str);
        return this;
    }

    public DownloadTask extraMonitorStatus(int[] iArr) {
        this.downloadInfoBuilder.extraMonitorStatus(iArr);
        return this;
    }

    public DownloadTask expiredRedownload(boolean z) {
        this.downloadInfoBuilder.expiredRedownload(z);
        return this;
    }

    public DownloadTask expiredHttpCheck(boolean z) {
        this.downloadInfoBuilder.expiredHttpCheck(z);
        return this;
    }

    public DownloadTask deleteCacheIfCheckFailed(boolean z) {
        this.downloadInfoBuilder.deleteCacheIfCheckFailed(z);
        return this;
    }

    public DownloadTask ttnetProtectTimeout(long j) {
        this.downloadInfoBuilder.ttnetProtectTimeout(j);
        return this;
    }

    public DownloadTask addTTNetCommonParam(boolean z) {
        this.downloadInfoBuilder.addTTNetCommonParam(z);
        return this;
    }

    public DownloadTask distinctDirectory(boolean z) {
        this.downloadInfoBuilder.distinctDirectory(z);
        return this;
    }

    public DownloadTask fastDownload() {
        this.downloadInfoBuilder.fastDownload();
        return this;
    }

    public DownloadTask handleRequest() {
        this.downloadInfoBuilder.handleRequest();
        return this;
    }

    public DownloadTask setAutoInstall(boolean z) {
        this.downloadInfoBuilder.setAutoInstall(z);
        return this;
    }

    public DownloadTask setCacheLifeTimeMax(long j) {
        this.downloadInfoBuilder.cacheLifeTimeMax(j);
        return this;
    }

    public int download() {
        if (DownloadSetting.obtainGlobal().optInt(DownloadSettingKeys.FIX_ANR_REMOVE_REPORT_IDLE_STATUS) <= 0) {
            return downloadImpl();
        }
        long currentTimeMillis = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        this.timingInfo.callDownloadTime = currentTimeMillis;
        this.timingInfo.buildDownloadInfoTime = System.currentTimeMillis();
        int id = this.downloadInfo.getId();
        ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).tryDownload(this);
        return id;
    }

    private int downloadImpl() {
        long currentTimeMillis = System.currentTimeMillis();
        handleBuildParams();
        this.downloadInfo = this.downloadInfoBuilder.build();
        this.timingInfo.callDownloadTime = currentTimeMillis;
        this.timingInfo.buildDownloadInfoTime = System.currentTimeMillis();
        IDownloadProcessDispatcherService iDownloadProcessDispatcherService = (IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class);
        if (iDownloadProcessDispatcherService.getDownloadInfo(this.downloadInfo.getId()) == null) {
            ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSend(this, null, 0);
        }
        iDownloadProcessDispatcherService.tryDownload(this);
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    private void handleBuildParams() {
        JSONObject globalTaskSettings;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (TextUtils.isEmpty(this.downloadInfoBuilder.monitorScene) || (globalTaskSettings = DownloadSetting.getGlobalTaskSettings()) == null || (optJSONObject = globalTaskSettings.optJSONObject(this.downloadInfoBuilder.monitorScene)) == null) {
                return;
            }
            JSONObject optJSONObject3 = optJSONObject.optJSONObject(DownloadSettingKeys.REPLACE_DOWNLOAD_TASK_PARAM);
            this.mReplaceSetting = optJSONObject3;
            if (optJSONObject3 == null) {
                return;
            }
            if (optJSONObject3.has(DownloadSettingKeys.DownloadTaskParam.IGNORE_INTERCEPTOR)) {
                this.downloadInfoBuilder.ignoreInterceptor(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.IGNORE_INTERCEPTOR) > 0);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.INNER_SAVE_PATH)) {
                this.downloadInfoBuilder.savePath(DownloadDirUtils.getDownloadPath());
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.AUTO_REMOVE_CALLBACK)) {
                this.autoRemoveCallback = this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.AUTO_REMOVE_CALLBACK) > 0;
            }
            if (this.mReplaceSetting.has("extra")) {
                this.downloadInfoBuilder.extra(this.mReplaceSetting.optString("extra"));
            }
            if (this.mReplaceSetting.has("only_wifi")) {
                this.downloadInfoBuilder.onlyWifi(this.mReplaceSetting.optInt("only_wifi") > 0);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS) && (optJSONObject2 = this.mReplaceSetting.optJSONObject(DownloadSettingKeys.DownloadTaskParam.EXTRA_HEADERS)) != null) {
                ArrayList arrayList = new ArrayList();
                Iterator<String> keys = optJSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList.add(new HttpHeader(next, optJSONObject2.optString(next)));
                }
                this.downloadInfoBuilder.extraHeaders(arrayList);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.MAX_BYTES)) {
                this.downloadInfoBuilder.maxBytes(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.MAX_BYTES));
            }
            if (this.mReplaceSetting.has("retry_count")) {
                this.downloadInfoBuilder.retryCount(this.mReplaceSetting.optInt("retry_count"));
            }
            if (this.mReplaceSetting.has("force")) {
                this.downloadInfoBuilder.force(this.mReplaceSetting.optInt("force") > 0);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION)) {
                this.downloadInfoBuilder.showNotification(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION) > 0);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION_FOR_AUTO_RESUMED)) {
                this.downloadInfoBuilder.showNotificationForAutoResumed(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.SHOW_NOTIFICATION_FOR_AUTO_RESUMED) > 0);
            }
            if (this.mReplaceSetting.has("executor_group")) {
                this.downloadInfoBuilder.executorGroup(this.mReplaceSetting.optInt("executor_group"));
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.TTNET_PROTECT_TIMEOUT)) {
                this.downloadInfoBuilder.ttnetProtectTimeout(this.mReplaceSetting.optLong(DownloadSettingKeys.DownloadTaskParam.TTNET_PROTECT_TIMEOUT));
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.ADD_TTNET_COMMON_PARAM)) {
                this.downloadInfoBuilder.addTTNetCommonParam(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.ADD_TTNET_COMMON_PARAM) > 0);
            }
            if (this.mReplaceSetting.has(DownloadSettingKeys.DownloadTaskParam.DISTINCT_DIRECTORY)) {
                this.downloadInfoBuilder.distinctDirectory(this.mReplaceSetting.optInt(DownloadSettingKeys.DownloadTaskParam.DISTINCT_DIRECTORY) > 0);
            }
            if (!this.mReplaceSetting.has("fast_download") || this.mReplaceSetting.optInt("fast_download") <= 0) {
                return;
            }
            this.downloadInfoBuilder.fastDownload();
        } catch (Throwable th) {
            Logger.globalError(TAG, "beforeBuild", "Error:" + th);
        }
    }

    public void asyncDownload(final IDownloadStartCallback iDownloadStartCallback) {
        ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).submitSingleTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.model.DownloadTask.1
            @Override // java.lang.Runnable
            public void run() {
                int download = DownloadTask.this.download();
                IDownloadStartCallback iDownloadStartCallback2 = iDownloadStartCallback;
                if (iDownloadStartCallback2 != null) {
                    iDownloadStartCallback2.onStart(download);
                }
            }
        });
    }

    public DownloadInfo buildDownloadInfo() {
        return this.downloadInfoBuilder.build();
    }

    public int getDownloadId() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo == null) {
            return 0;
        }
        return downloadInfo.getId();
    }

    public void addListenerToDownloadingSameTask() {
        DownloadInfo downloadInfo = this.downloadInfo;
        if (downloadInfo != null) {
            if (Logger.debugScene(downloadInfo)) {
                Logger.taskDebug(TAG, this.downloadInfo, "addListenerToDownloadingSameTask", "Same task just tryDownloading, so add listener in last task instead of tryDownload");
            }
            if (!this.downloadInfo.isAddListenerToSameTask()) {
                this.downloadInfo.setAddListenerToSameTask(true);
            }
        }
        addListenerToDownloadingSameTask(ListenerType.MAIN);
        addListenerToDownloadingSameTask(ListenerType.SUB);
        ((IDownloadMonitorHelperService) DownloadServiceManager.getService(IDownloadMonitorHelperService.class)).monitorSendWithTaskMonitor(this.monitorDepend, this.downloadInfo, new BaseException(1003, "has another same task, add Listener to old task"), 0);
    }

    private void addListenerToDownloadingSameTask(ListenerType listenerType) {
        Map<Integer, IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            Logger.taskError(TAG, getDownloadId(), "addListenerToDownloadingSameTask", "ListenerType is null");
            return;
        }
        for (IDownloadListener iDownloadListener : downloadListeners.values()) {
            if (iDownloadListener != null) {
                ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).addDownloadListener(getDownloadId(), iDownloadListener, listenerType, false);
            }
        }
    }

    public Map<Integer, IDownloadListener> getDownloadListeners(ListenerType listenerType) {
        if (listenerType == ListenerType.MAIN) {
            return this.mainThreadListeners;
        }
        if (listenerType == ListenerType.SUB) {
            return this.subThreadListeners;
        }
        if (listenerType == ListenerType.NOTIFICATION) {
            return this.notificationListeners;
        }
        return null;
    }

    public int[] getDownloadListenerHashCodeLists(ListenerType listenerType) {
        if (listenerType == ListenerType.MAIN) {
            return setToInt(this.mainThreadListeners.keySet());
        }
        if (listenerType == ListenerType.SUB) {
            return setToInt(this.subThreadListeners.keySet());
        }
        if (listenerType == ListenerType.NOTIFICATION) {
            return setToInt(this.notificationListeners.keySet());
        }
        return null;
    }

    private int[] setToInt(Set<Integer> set) {
        if (set == null || set.isEmpty()) {
            return null;
        }
        Object[] array = set.toArray();
        int[] iArr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            iArr[i] = ((Integer) array[i]).intValue();
        }
        return iArr;
    }

    public IDownloadListener getDownloadListenerByHashCode(ListenerType listenerType, int i) {
        if (listenerType == ListenerType.MAIN) {
            return this.mainThreadListeners.get(Integer.valueOf(i));
        }
        if (listenerType == ListenerType.SUB) {
            return this.subThreadListeners.get(Integer.valueOf(i));
        }
        if (listenerType == ListenerType.NOTIFICATION) {
            return this.notificationListeners.get(Integer.valueOf(i));
        }
        return null;
    }

    public synchronized int autoCalAndGetHashCodeForSameTask() {
        IDownloadListener singleDownloadListener = getSingleDownloadListener(ListenerType.MAIN);
        if (singleDownloadListener == null) {
            singleDownloadListener = getSingleDownloadListener(ListenerType.SUB);
        }
        if (singleDownloadListener != null) {
            this.hashCodeForSameTask = singleDownloadListener.hashCode();
        }
        return this.hashCodeForSameTask;
    }

    public IDownloadListener getSingleDownloadListener(ListenerType listenerType) {
        return this.singleListenerMap.get(listenerType);
    }

    public void removeDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        Map<Integer, IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            if (z && this.singleListenerMap.containsKey(listenerType)) {
                this.singleListenerMap.remove(listenerType);
                return;
            }
            return;
        }
        synchronized (downloadListeners) {
            if (z) {
                if (this.singleListenerMap.containsKey(listenerType)) {
                    iDownloadListener = this.singleListenerMap.get(listenerType);
                    this.singleListenerMap.remove(listenerType);
                }
                if (iDownloadListener != null) {
                    Iterator<Map.Entry<Integer, IDownloadListener>> it = downloadListeners.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        } else if (it.next().getValue() == iDownloadListener) {
                            it.remove();
                            break;
                        }
                    }
                }
            } else {
                downloadListeners.remove(Integer.valueOf(i));
                synchronized (this.singleListenerHashCodeMap) {
                    ListenerType listenerType2 = this.singleListenerHashCodeMap.get(Integer.valueOf(i));
                    if (listenerType2 != null && this.singleListenerMap.containsKey(listenerType2)) {
                        this.singleListenerMap.remove(listenerType2);
                        this.singleListenerHashCodeMap.remove(Integer.valueOf(i));
                    }
                }
            }
        }
    }

    public void addDownloadListener(int i, IDownloadListener iDownloadListener, ListenerType listenerType, boolean z) {
        Map<ListenerType, IDownloadListener> map;
        if (iDownloadListener == null) {
            return;
        }
        if (z && (map = this.singleListenerMap) != null) {
            map.put(listenerType, iDownloadListener);
            synchronized (this.singleListenerHashCodeMap) {
                this.singleListenerHashCodeMap.put(Integer.valueOf(i), listenerType);
            }
        }
        Map<Integer, IDownloadListener> downloadListeners = getDownloadListeners(listenerType);
        if (downloadListeners == null) {
            return;
        }
        synchronized (downloadListeners) {
            downloadListeners.put(Integer.valueOf(i), iDownloadListener);
        }
    }

    private void copyListeners(Map<Integer, IDownloadListener> map, Map<Integer, IDownloadListener> map2) {
        map.clear();
        for (Map.Entry<Integer, IDownloadListener> entry : map2.entrySet()) {
            if (entry.getValue() != null) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void setDownloadListeners(Map<Integer, IDownloadListener> map, ListenerType listenerType) {
        if (map == null) {
            return;
        }
        try {
            if (listenerType == ListenerType.MAIN) {
                synchronized (this.mainThreadListeners) {
                    copyListeners(this.mainThreadListeners, map);
                }
                return;
            } else if (listenerType == ListenerType.SUB) {
                synchronized (this.subThreadListeners) {
                    copyListeners(this.subThreadListeners, map);
                }
                return;
            } else {
                if (listenerType == ListenerType.NOTIFICATION) {
                    synchronized (this.notificationListeners) {
                        copyListeners(this.notificationListeners, map);
                    }
                    return;
                }
                return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void setNotificationEventListener(IDownloadNotificationEventListener iDownloadNotificationEventListener) {
        this.notificationEventListener = iDownloadNotificationEventListener;
    }

    public void copyInterfaceFromNewTask(DownloadTask downloadTask) {
        this.singleListenerMap.clear();
        this.singleListenerMap.putAll(downloadTask.singleListenerMap);
        synchronized (this.mainThreadListeners) {
            this.mainThreadListeners.clear();
            addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
        }
        synchronized (this.subThreadListeners) {
            this.subThreadListeners.clear();
            addAll(downloadTask.subThreadListeners, this.subThreadListeners);
        }
        synchronized (this.notificationListeners) {
            this.notificationListeners.clear();
            addAll(downloadTask.notificationListeners, this.notificationListeners);
        }
        this.notificationEventListener = downloadTask.notificationEventListener;
        this.interceptor = downloadTask.interceptor;
        this.depend = downloadTask.depend;
        this.monitorDepend = downloadTask.monitorDepend;
        this.forbiddenHandler = downloadTask.forbiddenHandler;
        this.diskSpaceHandler = downloadTask.diskSpaceHandler;
        this.notificationClickCallback = downloadTask.notificationClickCallback;
        this.fileUriProvider = downloadTask.fileUriProvider;
        synchronized (this.downloadCompleteHandlers) {
            this.downloadCompleteHandlers.clear();
            this.downloadCompleteHandlers.addAll(downloadTask.downloadCompleteHandlers);
        }
    }

    public void copyListenerFromPendingTask(DownloadTask downloadTask) {
        for (Map.Entry<ListenerType, IDownloadListener> entry : downloadTask.singleListenerMap.entrySet()) {
            if (entry != null && !this.singleListenerMap.containsKey(entry.getKey())) {
                this.singleListenerMap.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            if (downloadTask.mainThreadListeners.size() != 0) {
                synchronized (this.mainThreadListeners) {
                    removeAll(this.mainThreadListeners, downloadTask.mainThreadListeners);
                    addAll(downloadTask.mainThreadListeners, this.mainThreadListeners);
                }
            }
            if (downloadTask.subThreadListeners.size() != 0) {
                synchronized (this.subThreadListeners) {
                    removeAll(this.subThreadListeners, downloadTask.subThreadListeners);
                    addAll(downloadTask.subThreadListeners, this.subThreadListeners);
                }
            }
            if (downloadTask.notificationListeners.size() != 0) {
                synchronized (this.notificationListeners) {
                    removeAll(this.notificationListeners, downloadTask.notificationListeners);
                    addAll(downloadTask.notificationListeners, this.notificationListeners);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void addAll(Map<Integer, IDownloadListener> map, Map<Integer, IDownloadListener> map2) {
        if (map == null || map2 == null) {
            return;
        }
        for (Map.Entry<Integer, IDownloadListener> entry : map.entrySet()) {
            map2.put(entry.getKey(), entry.getValue());
        }
    }

    private void removeAll(Map<Integer, IDownloadListener> map, Map<Integer, IDownloadListener> map2) {
        if (map == null || map2 == null) {
            return;
        }
        Iterator<Map.Entry<Integer, IDownloadListener>> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            map.remove(it.next().getKey());
        }
    }

    public void removeCallback(ListenerType listenerType, IDownloadListener iDownloadListener) {
        if (!this.autoRemoveCallback || listenerType == ListenerType.NONE) {
            return;
        }
        if (Logger.debugScene(this.downloadInfo)) {
            Logger.taskDebug(TAG, this.downloadInfo, "removeCallback", "ListenerType:" + listenerType + " listener:" + iDownloadListener);
        }
        removeDownloadListener(iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, listenerType, false);
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public IDownloadCompleteHandler getDownloadCompleteHandlerByIndex(int i) {
        synchronized (this.downloadCompleteHandlers) {
            if (i >= this.downloadCompleteHandlers.size()) {
                return null;
            }
            return this.downloadCompleteHandlers.get(i);
        }
    }

    public DownloadTask addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        synchronized (this.downloadCompleteHandlers) {
            if (iDownloadCompleteHandler != null) {
                if (!this.downloadCompleteHandlers.contains(iDownloadCompleteHandler)) {
                    this.downloadCompleteHandlers.add(iDownloadCompleteHandler);
                    return this;
                }
            }
            return this;
        }
    }

    public DownloadTask setDownloadCompleteHandlers(List<IDownloadCompleteHandler> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<IDownloadCompleteHandler> it = list.iterator();
            while (it.hasNext()) {
                addDownloadCompleteHandler(it.next());
            }
        }
        return this;
    }

    public DownloadTimingInfo getTimingInfo() {
        return this.timingInfo;
    }

    public DownloadThreadInfo getThreadInfo() {
        return this.threadInfo;
    }
}
