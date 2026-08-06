package com.ss.android.socialbase.downloader.service;

import android.content.Context;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.IDirectoryCleanerListener;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadPluginDegradeListener;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.IMemoryListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.downloader.IDownloadMemoryInfoListener;
import com.ss.android.socialbase.downloader.downloader.IReserveWifiStatusListener;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public interface IDownloadComponentManagerService {
    long clearAllDownloadCache(boolean z, Set<String> set);

    void clearDBSuccessedDownloadInfo(String str, String str2);

    void clearDirectory(IDirectoryCleanerListener iDirectoryCleanerListener);

    void clearMemoryCacheData(double d);

    void coverComponent(DownloaderBuilder downloaderBuilder);

    void enableLruCache();

    Context getAppContext();

    IDownloadInterceptor getDownloadInterceptor();

    JSONObject getDownloadSetting();

    IReserveWifiStatusListener getReserveWifiStatusListener();

    ITTNetHandler getTTNetHandler();

    void initComponent(DownloaderBuilder downloaderBuilder);

    void initDownloadCacheImmediately();

    boolean isInit();

    void resetSleepDownloadingTaskState();

    void setAppContext(Context context);

    void setAppInfo(String str, String str2);

    void setDownloadDBListener(IDownloadDBListener iDownloadDBListener);

    void setDownloadInMultiProcess();

    void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener);

    void setDownloadMemoryListener(IMemoryListener iMemoryListener);

    void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener);

    void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler);

    void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener);

    void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener);

    void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener);

    void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback);

    void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener);

    void sleepDownloadingTask();

    void startThrottle(String[] strArr, long j);

    void stopThrottle(String[] strArr);

    void submitIOTask(Runnable runnable);

    void submitScheduleTask(Runnable runnable, long j, TimeUnit timeUnit);

    void submitSingleTask(Runnable runnable);

    void unRegisterDownloadReceiver();

    void updateDownloadInfo(DownloadInfo downloadInfo);

    void updateDownloadSpInfo();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class DefaultDownloadComponentManagerService implements IDownloadComponentManagerService {
        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public long clearAllDownloadCache(boolean z, Set<String> set) {
            return 0L;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearDBSuccessedDownloadInfo(String str, String str2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearDirectory(IDirectoryCleanerListener iDirectoryCleanerListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void clearMemoryCacheData(double d) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void coverComponent(DownloaderBuilder downloaderBuilder) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void enableLruCache() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public Context getAppContext() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IDownloadInterceptor getDownloadInterceptor() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public IReserveWifiStatusListener getReserveWifiStatusListener() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initComponent(DownloaderBuilder downloaderBuilder) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void initDownloadCacheImmediately() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public boolean isInit() {
            return false;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void resetSleepDownloadingTaskState() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setAppContext(Context context) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setAppInfo(String str, String str2) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadDBListener(IDownloadDBListener iDownloadDBListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadInMultiProcess() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMemoryListener(IMemoryListener iMemoryListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadPluginDegradeListener(IDownloadPluginDegradeListener iDownloadPluginDegradeListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void sleepDownloadingTask() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void startThrottle(String[] strArr, long j) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void stopThrottle(String[] strArr) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitIOTask(Runnable runnable) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitScheduleTask(Runnable runnable, long j, TimeUnit timeUnit) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void submitSingleTask(Runnable runnable) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void unRegisterDownloadReceiver() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadInfo(DownloadInfo downloadInfo) {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public void updateDownloadSpInfo() {
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public JSONObject getDownloadSetting() {
            return DownloadConstants.EMPTY_JSON;
        }

        @Override // com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService
        public ITTNetHandler getTTNetHandler() {
            return new ITTNetHandler.DefaultTTNetHandler();
        }
    }
}
