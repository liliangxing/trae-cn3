package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpService;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloaderBuilder {
    private ExecutorService chunkDownloadExecutor;
    private final Context context;
    private ExecutorService cpuThreadExecutor;
    private ExecutorService customThreadExecutor;
    private ExecutorService dbThreadExecutor;
    private IDownloadDns downloadDns;
    private boolean downloadInMultiProcess;
    private IDownloadInterceptor downloadInterceptor;
    private IDownloadLaunchHandler downloadLaunchHandler;
    private IDownloadMonitorListener downloadMonitorListener;
    private IDownloadSettings downloadSetting;
    private IDownloadHttpService httpService;
    private IDownloadIdGenerator idGenerator;
    private ExecutorService ioThreadExecutor;
    private int maxDownloadPoolSize;
    private ExecutorService mixApkDownloadExecutor;
    private ExecutorService mixDefaultDownloadExecutor;
    private ExecutorService mixFrequentDownloadExecutor;
    private IMonitorConfig monitorConfig;
    private INotificationClickCallback notificationClickCallback;
    private ExecutorService okHttpDispatcherExecutor;
    private ITTNetHandler ttNetHandler;
    private int writeBufferSize;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers = new ArrayList();
    private boolean needAutoRefreshUnSuccessTask = true;

    @Deprecated
    public DownloaderBuilder downloadExpSwitch(int i) {
        return this;
    }

    @Deprecated
    public DownloaderBuilder headHttpService(IDownloadHeadHttpService iDownloadHeadHttpService) {
        return this;
    }

    @Deprecated
    public DownloaderBuilder maxDownloadPoolSize(int i) {
        return this;
    }

    public DownloaderBuilder(Context context) {
        this.context = context;
    }

    public DownloaderBuilder writeBufferSize(int i) {
        this.writeBufferSize = i;
        return this;
    }

    public DownloaderBuilder idGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        this.idGenerator = iDownloadIdGenerator;
        return this;
    }

    public DownloaderBuilder httpService(IDownloadHttpService iDownloadHttpService) {
        this.httpService = iDownloadHttpService;
        return this;
    }

    public DownloaderBuilder downloadLaunchHandler(IDownloadLaunchHandler iDownloadLaunchHandler) {
        this.downloadLaunchHandler = iDownloadLaunchHandler;
        return this;
    }

    public DownloaderBuilder cpuThreadExecutor(ExecutorService executorService) {
        this.cpuThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder ioThreadExecutor(ExecutorService executorService) {
        this.ioThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixDefaultDownloadExecutor(ExecutorService executorService) {
        this.mixDefaultDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixFrequentDownloadExecutor(ExecutorService executorService) {
        this.mixFrequentDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder mixApkDownloadExecutor(ExecutorService executorService) {
        this.mixApkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder dbThreadExecutor(ExecutorService executorService) {
        this.dbThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder chunkThreadExecutor(ExecutorService executorService) {
        this.chunkDownloadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder okHttpDispatcherExecutor(ExecutorService executorService) {
        this.okHttpDispatcherExecutor = executorService;
        return this;
    }

    public DownloaderBuilder customThreadExecutor(ExecutorService executorService) {
        this.customThreadExecutor = executorService;
        return this;
    }

    public DownloaderBuilder downloadInMultiProcess(boolean z) {
        this.downloadInMultiProcess = z;
        return this;
    }

    public DownloaderBuilder monitorConfig(IMonitorConfig iMonitorConfig) {
        this.monitorConfig = iMonitorConfig;
        return this;
    }

    public DownloaderBuilder ttNetHandler(ITTNetHandler iTTNetHandler) {
        this.ttNetHandler = iTTNetHandler;
        return this;
    }

    public DownloaderBuilder downloadInterceptor(IDownloadInterceptor iDownloadInterceptor) {
        this.downloadInterceptor = iDownloadInterceptor;
        return this;
    }

    public DownloaderBuilder addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
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

    public DownloaderBuilder needAutoRefreshUnSuccessTask(boolean z) {
        this.needAutoRefreshUnSuccessTask = z;
        return this;
    }

    public DownloaderBuilder notificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public DownloaderBuilder downloadSetting(IDownloadSettings iDownloadSettings) {
        this.downloadSetting = iDownloadSettings;
        return this;
    }

    public DownloaderBuilder downloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        this.downloadMonitorListener = iDownloadMonitorListener;
        return this;
    }

    public DownloaderBuilder downloadDns(IDownloadDns iDownloadDns) {
        this.downloadDns = iDownloadDns;
        return this;
    }

    public Context getContext() {
        return this.context;
    }

    public IDownloadIdGenerator getIdGenerator() {
        return this.idGenerator;
    }

    public IDownloadHttpService getHttpService() {
        return this.httpService;
    }

    public IDownloadLaunchHandler getDownloadLaunchHandler() {
        return this.downloadLaunchHandler;
    }

    public ExecutorService getCPUThreadExecutor() {
        return this.cpuThreadExecutor;
    }

    public ExecutorService getIOThreadExecutor() {
        return this.ioThreadExecutor;
    }

    public ExecutorService getMixDefaultDownloadExecutor() {
        return this.mixDefaultDownloadExecutor;
    }

    public ExecutorService getMixFrequentDownloadExecutor() {
        return this.mixFrequentDownloadExecutor;
    }

    public ExecutorService getMixApkDownloadExecutor() {
        return this.mixApkDownloadExecutor;
    }

    public ExecutorService getDBThreadExecutor() {
        return this.dbThreadExecutor;
    }

    public ExecutorService getChunkThreadExecutor() {
        return this.chunkDownloadExecutor;
    }

    public ExecutorService getOkHttpDispatcherExecutor() {
        return this.okHttpDispatcherExecutor;
    }

    public ExecutorService getCustomThreadExecutor() {
        return this.customThreadExecutor;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public boolean isDownloadInMultiProcess() {
        return this.downloadInMultiProcess;
    }

    public IMonitorConfig getMonitorConfig() {
        return this.monitorConfig;
    }

    public ITTNetHandler getTTNetHandler() {
        return this.ttNetHandler;
    }

    public IDownloadInterceptor getDownloadInterceptor() {
        return this.downloadInterceptor;
    }

    public boolean needAutoRefreshUnSuccessTask() {
        return this.needAutoRefreshUnSuccessTask;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public IDownloadSettings getDownloadSetting() {
        return this.downloadSetting;
    }

    public IDownloadMonitorListener getDownloadMonitorListener() {
        return this.downloadMonitorListener;
    }

    public IDownloadDns getDownloadDns() {
        return this.downloadDns;
    }

    public Downloader build() {
        return new Downloader(this);
    }
}
