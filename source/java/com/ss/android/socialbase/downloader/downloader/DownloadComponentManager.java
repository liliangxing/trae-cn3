package com.ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadCacheSyncStatus;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.GlobalListenerAdaptor;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDBListener;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadNetworkHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadSettings;
import com.ss.android.socialbase.downloader.depend.IDownloadStatusListener;
import com.ss.android.socialbase.downloader.depend.IDownloadTaskExecuteListener;
import com.ss.android.socialbase.downloader.depend.IDownloadThreadCheckListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.depend.ProcessCallback;
import com.ss.android.socialbase.downloader.downloader.ITTNetHandler;
import com.ss.android.socialbase.downloader.impls.AbsDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadCache;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadEngine;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadHttpService;
import com.ss.android.socialbase.downloader.impls.DefaultDownloadServiceHandler;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.impls.DownloadProxy;
import com.ss.android.socialbase.downloader.impls.NewDownloadEngine;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.DownloadThreadInfo;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.monitor.InnerEventListener;
import com.ss.android.socialbase.downloader.network.IDownloadDns;
import com.ss.android.socialbase.downloader.network.IDownloadHeadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpConnection;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadMultiProcService;
import com.ss.android.socialbase.downloader.service.IDownloadNetworkService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.DefaultThreadFactory;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadComponentManager {
    public static final int NET_LIB_DEFAULT = 0;
    public static final int NET_LIB_HOST = 1;
    public static final int NET_LIB_NO_BACKUP = 2;
    public static final String SINGLE_THREAD_NAME = "DTP-Single";
    private static final String TAG = "DownloadComponentManager";
    private static volatile ExecutorService apkInstallThreadExecutor;
    private static volatile Context appContext;
    private static volatile ExecutorService chunkDownloadExecutor;
    private static volatile ExecutorService cpuThreadExecutor;
    private static volatile ExecutorService customThreadExecutor;
    private static volatile ExecutorService dbThreadExecutor;
    private static volatile IDownloadDns defaultDownloadDns;
    private static volatile IDownloadHttpService defaultHttpService;
    private static volatile IDownloadCache downloadCache;
    private static final List<IDownloadCacheSyncStatusListener> downloadCacheSyncStatusListeners;
    private static volatile IDownloadDBListener downloadDBListener;
    private static volatile IDownloadDns downloadDns;
    private static volatile AbsDownloadEngine downloadEngine;
    private static InnerEventListener downloadEventListener;
    private static volatile IDownloadInterceptor downloadInterceptor;
    private static volatile IDownloadLaunchHandler downloadLaunchHandler;
    private static volatile IDownloadMemoryInfoListener downloadMemoryInfoListener;
    private static volatile IDownloadMonitorListener downloadMonitorListener;
    private static volatile IDownloadNetworkHandler downloadNetworkHandler;
    private static volatile DownloadReceiver downloadReceiver;
    private static volatile IDownloadServiceHandler downloadServiceHandler;
    private static volatile IDownloadSettings downloadSettings;
    private static volatile IDownloadStatusListener downloadStatusListener;
    private static final List<IDownloadTaskExecuteListener> downloadTaskExecuteListeners;
    private static volatile ExecutorService fastThreadExecutor;
    private static final int fixedCPUPoolSize;
    private static final int fixedDBPoolSize;
    private static final int fixedIOPoolSize;
    private static final int fixedMIXPoolSize;
    private static volatile ExecutorService globalThrottleDownloadExecutor;
    private static volatile boolean hasInit;
    private static volatile IDownloadHttpService httpService;
    private static boolean httpServiceInit;
    private static volatile ITTNetHandler iTTNetHandler;
    private static volatile IDownloadServiceHandler independentDownloadServiceHandler;
    private static volatile IndependentHolderCreator independentHolderCreator;
    private static volatile ExecutorService ioThreadExecutor;
    private static volatile ExecutorService mixApkDownloadExecutor;
    private static volatile ExecutorService mixDefaultDownloadExecutor;
    private static volatile ExecutorService mixFrequentDownloadExecutor;
    private static volatile IMonitorConfig monitorConfig;
    private static boolean needAutoRefreshUnSuccessTask;
    private static volatile INotificationClickCallback notificationClickCallback;
    private static volatile ExecutorService okHttpDispatcherExecutor;
    private static IReserveWifiStatusListener reserveWifiStatusListener;
    private static volatile ScheduledExecutorService scheduledExecutor;
    private static volatile ExecutorService segmentThreadExecutor;
    private static volatile ExecutorService singleThreadExecutor;
    private static volatile IDownloadThreadCheckListener threadCheckListener;
    private static int writeBufferSize;
    private static volatile List<ProcessCallback> processCallbacks = new CopyOnWriteArrayList();
    private static volatile boolean downloadInMultiProcess = false;
    private static volatile OkHttpClient sOkHttpClient = null;
    private static final List<IDownloadCompleteHandler> downloadCompleteHandlers = new ArrayList();
    private static boolean isReceiverRegistered = false;
    private static volatile boolean enableLruCache = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IndependentHolderCreator {

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public interface OnMainProcessRebindErrorListener {
            void onRebindError();
        }

        ISqlDownloadCache createCache(OnMainProcessRebindErrorListener onMainProcessRebindErrorListener);

        IDownloadProxy createProxy();

        IDownloadServiceHandler createServiceHandler();
    }

    @Deprecated
    public static void setNotAutoRebootService(boolean z) {
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        fixedCPUPoolSize = availableProcessors;
        fixedIOPoolSize = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        fixedMIXPoolSize = availableProcessors;
        fixedDBPoolSize = availableProcessors;
        writeBufferSize = DownloadConstants.TTNET_DEFAULT_BUFFER_SIZE;
        downloadCacheSyncStatusListeners = new ArrayList();
        downloadTaskExecuteListeners = new ArrayList();
        needAutoRefreshUnSuccessTask = true;
        hasInit = false;
        IDownloadMultiProcService iDownloadMultiProcService = (IDownloadMultiProcService) DownloadServiceManager.getService(IDownloadMultiProcService.class);
        if (iDownloadMultiProcService != null) {
            iDownloadMultiProcService.registerIndependentServiceCreator();
        }
    }

    private DownloadComponentManager() {
    }

    public static synchronized void initComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            if (hasInit) {
                Logger.globalError(TAG, "initComponent", "Component has init");
                return;
            }
            boolean z = downloadInMultiProcess;
            setDownloadBuilder(downloaderBuilder);
            setLoggerReport();
            if (downloadCache == null) {
                downloadCache = new DefaultDownloadCache();
            }
            if (downloadServiceHandler == null) {
                downloadServiceHandler = new DefaultDownloadServiceHandler();
            }
            if (independentDownloadServiceHandler == null && independentHolderCreator != null) {
                independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
            }
            if (downloadEngine == null) {
                setDownloadEngine();
            }
            registerAsync((!downloadInMultiProcess || z || DownloadHelper.isDownloaderProcess()) ? false : true);
            ensureOPPO();
            hasInit = true;
        }
    }

    public static synchronized void coverComponent(DownloaderBuilder downloaderBuilder) {
        synchronized (DownloadComponentManager.class) {
            setDownloadBuilder(downloaderBuilder);
        }
    }

    private static void setDownloadBuilder(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                setAppContext(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                setIdGenerator(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                setNotificationClickCallback(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getHttpService() != null) {
                setHttpService(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                setDownloadLaunchHandler(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                setCPUThreadExecutor(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                setIOThreadExecutor(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                setMixDefaultDownloadExecutor(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                setMixFrequentDownloadExecutor(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                setMixApkDownloadExecutor(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                setDBThreadExecutor(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                setChunkDownloadExecutor(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                setOkHttpDispatcherExecutor(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (downloaderBuilder.getCustomThreadExecutor() != null) {
                setCustomThreadExecutor(downloaderBuilder.getCustomThreadExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                setDownloadCompleteHandlers(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                monitorConfig = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                writeBufferSize = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                downloadInMultiProcess = true;
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                iTTNetHandler = downloaderBuilder.getTTNetHandler();
                if (iTTNetHandler.isTTNetEnable()) {
                    setHttpService(iTTNetHandler.getTTNetDownloadHttpService());
                } else {
                    setHttpService(getDefaultHttpService());
                }
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                setDownloadSetting(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                downloadDns = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getDownloadInterceptor() != null) {
                setDownloadInterceptor(downloaderBuilder.getDownloadInterceptor());
            }
            needAutoRefreshUnSuccessTask(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                setDownloadMonitorListener(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void registerAsync(final boolean z) {
        submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadComponentManager.registerIndependentService(z);
                DownloadComponentManager.registerDownloadReceiver();
                Context appContext2 = DownloadComponentManager.getAppContext();
                if (appContext2 != null) {
                    DownloadUtils.getCurProcessName(appContext2);
                }
                DownloadDirUtils.getDownloadFastTempPath();
                DownloadHelper.updateCacheSetting();
            }
        });
    }

    private static void setLoggerReport() {
        try {
            JSONObject downloadSetting = getDownloadSetting();
            int optInt = downloadSetting.optInt(DownloadSettingKeys.DOWNLOADER_ALOG_LEVEL);
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "setLoggerReport", "ALogLevel:" + optInt);
            }
            if (optInt <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.DOWNLOADER_ALOG_TASK_SCENE_LIST);
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    String optString = optJSONArray.optString(i);
                    if (!TextUtils.isEmpty(optString)) {
                        arrayList.add(optString);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            boolean z = downloadSetting.optInt(DownloadSettingKeys.DOWNLOADER_LOGGER_GLOBAL_REPORT) > 0;
            JSONArray optJSONArray2 = downloadSetting.optJSONArray(DownloadSettingKeys.DOWNLOADER_LOGGER_TASK_REPORT_SCENE_LIST);
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    String optString2 = optJSONArray2.optString(i2);
                    if (!TextUtils.isEmpty(optString2)) {
                        arrayList2.add(optString2);
                    }
                }
            }
            Logger.setLogReportParams(optInt, z, arrayList2, arrayList);
            if (Logger.alog()) {
                Logger.globalDebug(TAG, "setLoggerReport", "Setting: " + getDownloadSetting());
            }
        } catch (Throwable th) {
            Logger.globalError(TAG, "setLoggerReport", "Error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void registerIndependentService(boolean z) {
        if (!z || DownloadUtils.optimizeMultiProcess()) {
            return;
        }
        DownloadProxy.get(true).startService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void registerDownloadReceiver() {
        synchronized (DownloadComponentManager.class) {
            if (downloadReceiver == null) {
                downloadReceiver = new DownloadReceiver();
            }
            if (isReceiverRegistered) {
                return;
            }
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
                intentFilter.addAction("android.intent.action.MEDIA_REMOVED");
                intentFilter.addAction("android.intent.action.MEDIA_BAD_REMOVAL");
                intentFilter.addAction("android.intent.action.MEDIA_EJECT");
                m124x22dfecec(appContext, downloadReceiver, intentFilter);
                isReceiverRegistered = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized void unRegisterDownloadReceiver() {
        synchronized (DownloadComponentManager.class) {
            try {
                if (isReceiverRegistered && downloadReceiver != null && appContext != null) {
                    m125xcf65c305(appContext, downloadReceiver);
                    isReceiverRegistered = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static synchronized void setDownloadInMultiProcess() {
        synchronized (DownloadComponentManager.class) {
            if (downloadInMultiProcess || !supportMultiProc()) {
                return;
            }
            try {
                Intent intent = new Intent(getAppContext(), (Class<?>) DownloadHandleService.class);
                intent.setAction(DownloadConstants.ACTION_DOWNLOAD_MULTI_PROCESS_NOTIFY);
                getAppContext().startService(intent);
                if (!DownloadHelper.isDownloaderProcess()) {
                    submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadComponentManager.registerIndependentService(true);
                        }
                    });
                }
                downloadInMultiProcess = true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static synchronized boolean isDownloadInMultiProcess() {
        boolean z;
        synchronized (DownloadComponentManager.class) {
            z = downloadInMultiProcess;
        }
        return z;
    }

    public static IDownloadHttpService getHttpService() {
        return httpService;
    }

    public static void addProcessCallback(ProcessCallback processCallback) {
        if (processCallback == null) {
            return;
        }
        processCallbacks.add(processCallback);
    }

    public static List<ProcessCallback> getProcessCallbacks() {
        return processCallbacks;
    }

    public static void addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        List<IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                if (!list.contains(iDownloadCompleteHandler)) {
                    list.add(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static void removeDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
        List<IDownloadCompleteHandler> list = downloadCompleteHandlers;
        synchronized (list) {
            if (iDownloadCompleteHandler != null) {
                if (list.contains(iDownloadCompleteHandler)) {
                    list.remove(iDownloadCompleteHandler);
                }
            }
        }
    }

    public static void registerDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (!list.contains(iDownloadCacheSyncStatusListener)) {
                    list.add(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    public static void unRegisterDownloadCacheSyncListener(IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            if (iDownloadCacheSyncStatusListener != null) {
                if (list.contains(iDownloadCacheSyncStatusListener)) {
                    list.remove(iDownloadCacheSyncStatusListener);
                }
            }
        }
    }

    public static void registerDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                if (!list.contains(iDownloadTaskExecuteListener)) {
                    list.add(iDownloadTaskExecuteListener);
                }
            }
        }
    }

    public static void unRegisterDownloadTaskExecuteListener(IDownloadTaskExecuteListener iDownloadTaskExecuteListener) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            if (iDownloadTaskExecuteListener != null) {
                if (list.contains(iDownloadTaskExecuteListener)) {
                    list.remove(iDownloadTaskExecuteListener);
                }
            }
        }
    }

    public static void onDownloadCacheSyncCallback(DownloadCacheSyncStatus downloadCacheSyncStatus) {
        List<IDownloadCacheSyncStatusListener> list = downloadCacheSyncStatusListeners;
        synchronized (list) {
            for (IDownloadCacheSyncStatusListener iDownloadCacheSyncStatusListener : list) {
                if (iDownloadCacheSyncStatusListener != null) {
                    if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_START) {
                        iDownloadCacheSyncStatusListener.onStart();
                    } else if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                        iDownloadCacheSyncStatusListener.onSuccess();
                    }
                }
            }
            if (downloadCacheSyncStatus == DownloadCacheSyncStatus.SYNC_SUCCESS) {
                downloadCacheSyncStatusListeners.clear();
            }
        }
    }

    public static void onDownloadTaskStart(DownloadTask downloadTask, int i) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onStart(downloadTask, i);
                }
            }
        }
    }

    public static void onDownloadTaskFinish(DownloadTask downloadTask, int i) {
        List<IDownloadTaskExecuteListener> list = downloadTaskExecuteListeners;
        synchronized (list) {
            for (IDownloadTaskExecuteListener iDownloadTaskExecuteListener : list) {
                if (iDownloadTaskExecuteListener != null) {
                    iDownloadTaskExecuteListener.onFinish(downloadTask, i);
                }
            }
        }
    }

    public static IDownloadMonitorListener getDownloadMonitorListener() {
        return downloadMonitorListener;
    }

    public static IDownloadHttpService getDefaultHttpService() {
        if (defaultHttpService == null) {
            synchronized (DownloadComponentManager.class) {
                if (defaultHttpService == null) {
                    defaultHttpService = new DefaultDownloadHttpService();
                }
            }
        }
        return defaultHttpService;
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, List<HttpHeader> list) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(z, i, handleConnection(str, list), list);
    }

    public static IDownloadHttpConnection downloadWithConnection(boolean z, int i, String str, String str2, List<HttpHeader> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(z, i, handleConnection(str, list), str2, list, i2, z2, downloadInfo);
    }

    private static String handleConnection(String str, List<HttpHeader> list) {
        if (downloadNetworkHandler == null) {
            return str;
        }
        String handle = downloadNetworkHandler.handle(str, list);
        return !TextUtils.isEmpty(handle) ? handle : str;
    }

    @Deprecated
    public static IDownloadHeadHttpConnection downloadWithHeadConnection(String str, List<HttpHeader> list) throws Exception {
        return ((IDownloadNetworkService) DownloadServiceManager.getService(IDownloadNetworkService.class)).downloadWithConnection(true, 0, str, list);
    }

    public static synchronized void setDownloadLaunchHandler(IDownloadLaunchHandler iDownloadLaunchHandler) {
        synchronized (DownloadComponentManager.class) {
            if (iDownloadLaunchHandler != null) {
                downloadLaunchHandler = iDownloadLaunchHandler;
                if (downloadCache instanceof DefaultDownloadCache) {
                    ((DefaultDownloadCache) downloadCache).resumeUnCompleteTaskMayDelayed();
                }
            }
        }
    }

    private static void setCPUThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            cpuThreadExecutor = executorService;
        }
    }

    private static void setIOThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            ioThreadExecutor = executorService;
        }
    }

    private static void setMixDefaultDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixDefaultDownloadExecutor = executorService;
        }
    }

    private static void setMixFrequentDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixFrequentDownloadExecutor = executorService;
        }
    }

    private static void setMixApkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            mixApkDownloadExecutor = executorService;
        }
    }

    private static void setDBThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            dbThreadExecutor = executorService;
        }
    }

    public static void setChunkDownloadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            chunkDownloadExecutor = executorService;
        }
    }

    public static void setOkHttpDispatcherExecutor(ExecutorService executorService) {
        if (executorService != null) {
            okHttpDispatcherExecutor = executorService;
        }
    }

    public static void setCustomThreadExecutor(ExecutorService executorService) {
        if (executorService != null) {
            customThreadExecutor = executorService;
        }
    }

    public static void setDownloadInterceptor(IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor != null) {
            downloadInterceptor = GlobalListenerAdaptor.addListener(iDownloadInterceptor);
        }
    }

    public static void setDownloadThreadCheckListener(IDownloadThreadCheckListener iDownloadThreadCheckListener) {
        if (iDownloadThreadCheckListener != null) {
            threadCheckListener = iDownloadThreadCheckListener;
        }
    }

    private static void setDownloadCompleteHandlers(List<IDownloadCompleteHandler> list) {
        List<IDownloadCompleteHandler> list2 = downloadCompleteHandlers;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static synchronized IMonitorConfig getMonitorConfig() {
        IMonitorConfig iMonitorConfig;
        synchronized (DownloadComponentManager.class) {
            iMonitorConfig = monitorConfig;
        }
        return iMonitorConfig;
    }

    public static void submitCPUTask(Runnable runnable) {
        submitCPUTask(runnable, false);
    }

    public static void submitIOTask(Runnable runnable) {
        submitIOTask(runnable, false);
    }

    public static void submitCPUTask(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !DownloadUtils.isMainThread()) {
            runnable.run();
        } else {
            getCPUThreadExecutor().execute(runnable);
        }
    }

    public static void submitIOTask(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !DownloadUtils.isMainThread()) {
            runnable.run();
        } else {
            getIOThreadExecutor().execute(runnable);
        }
    }

    public static void submitDBTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!DownloadUtils.isMainThread()) {
            runnable.run();
        } else {
            getDBThreadExecutorService().execute(runnable);
        }
    }

    public static void submitSingleTask(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        getSingleThreadExecutorService().execute(runnable);
    }

    public static Future submitScheduleTask(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return getScheduledExecutorService().schedule(runnable, j, timeUnit);
    }

    public static ExecutorService getCPUThreadExecutor() {
        long j;
        int i;
        if (cpuThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (cpuThreadExecutor == null) {
                    int i2 = fixedCPUPoolSize;
                    if (isGlobalThreadPoolOptEnabled()) {
                        j = 8;
                        i = i2 / 2;
                    } else {
                        j = 15;
                        i = i2;
                    }
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-cpu-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    cpuThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return cpuThreadExecutor;
    }

    public static ExecutorService getApkInstallThreadExecutor() {
        if (apkInstallThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (apkInstallThreadExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, isGlobalThreadPoolOptEnabled() ? 15L : 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-apk-install", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    apkInstallThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return apkInstallThreadExecutor;
    }

    public static ExecutorService getIOThreadExecutor() {
        return ioThreadExecutor != null ? ioThreadExecutor : getCPUThreadExecutor();
    }

    public static ExecutorService getMixFrequentThreadExecutor() {
        return mixFrequentDownloadExecutor != null ? mixFrequentDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixApkThreadExecutor() {
        return mixApkDownloadExecutor != null ? mixApkDownloadExecutor : getMixDefaultThreadExecutor();
    }

    public static ExecutorService getMixDefaultThreadExecutor() {
        long j;
        int i;
        if (mixDefaultDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (mixDefaultDownloadExecutor == null) {
                    int i2 = fixedMIXPoolSize;
                    if (isGlobalThreadPoolOptEnabled()) {
                        j = 8;
                        i = i2 / 2;
                    } else {
                        j = 15;
                        i = i2;
                    }
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-mix-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    mixDefaultDownloadExecutor = threadPoolExecutor;
                }
            }
        }
        return mixDefaultDownloadExecutor;
    }

    public static ExecutorService getGlobalThrottleThreadExecutor() {
        int i;
        long j;
        if (globalThrottleDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (globalThrottleDownloadExecutor == null) {
                    int i2 = fixedMIXPoolSize;
                    int i3 = i2 * 2;
                    if (isThrottleThreadPoolOptEnabled()) {
                        i = i2;
                        j = 8;
                    } else {
                        i = i3;
                        j = 15;
                    }
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2 * 2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-global-throttle", true));
                    if (isThrottleThreadPoolOptEnabled()) {
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    globalThrottleDownloadExecutor = threadPoolExecutor;
                }
            }
        }
        return globalThrottleDownloadExecutor;
    }

    public static ExecutorService getChunkDownloadThreadExecutorService() {
        long j;
        int i;
        if (chunkDownloadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (chunkDownloadExecutor == null) {
                    int i2 = fixedIOPoolSize;
                    if (isGlobalThreadPoolOptEnabled()) {
                        j = 8;
                        i = i2 / 2;
                    } else {
                        j = 15;
                        i = i2;
                    }
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-chunk-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    chunkDownloadExecutor = threadPoolExecutor;
                }
            }
        }
        return chunkDownloadExecutor;
    }

    public static ExecutorService getSegmentDownloadThreadExecutorService() {
        if (segmentThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (segmentThreadExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-segment-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    segmentThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return segmentThreadExecutor;
    }

    static boolean isGlobalThreadPoolOptEnabled() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_GLOBAL_THREAD_POOL_OPT, 0) > 0;
    }

    static boolean isThrottleThreadPoolOptEnabled() {
        return DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.KEY_THROTTLE_THREAD_POOL_OPT, 0) > 0;
    }

    public static ExecutorService getDBThreadExecutorService() {
        long j;
        int i;
        if (dbThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (dbThreadExecutor == null) {
                    int i2 = fixedDBPoolSize;
                    if (isGlobalThreadPoolOptEnabled()) {
                        j = 8;
                        i = i2 / 2;
                    } else {
                        j = 15;
                        i = i2;
                    }
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i2, j, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("DownloadThreadPool-db-fixed", true));
                    try {
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    dbThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return dbThreadExecutor;
    }

    public static ExecutorService getSingleThreadExecutorService() {
        if (singleThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (singleThreadExecutor == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, isGlobalThreadPoolOptEnabled() ? 30L : 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory(SINGLE_THREAD_NAME, true));
                    if (isGlobalThreadPoolOptEnabled()) {
                        try {
                            threadPoolExecutor.allowCoreThreadTimeOut(true);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    singleThreadExecutor = threadPoolExecutor;
                }
            }
        }
        return singleThreadExecutor;
    }

    public static ExecutorService getCustomThreadExecutor() {
        return customThreadExecutor;
    }

    public static OkHttpClient getDownloadClient() {
        if (sOkHttpClient == null) {
            synchronized (DownloadComponentManager.class) {
                if (sOkHttpClient == null) {
                    sOkHttpClient = createDownloadClientBuilder().build();
                }
            }
        }
        return sOkHttpClient;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        if (scheduledExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (scheduledExecutor == null) {
                    scheduledExecutor = new ScheduledThreadPoolExecutor(4, new DefaultThreadFactory("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return scheduledExecutor;
    }

    public static OkHttpClient.Builder createDownloadClientBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        int optInt = DownloadSetting.getGlobalSettings().optInt("connect_timeout", 30000);
        long optInt2 = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.IO_TIMEOUT, 30000);
        builder.connectTimeout(optInt, TimeUnit.MILLISECONDS).readTimeout(optInt2, TimeUnit.MILLISECONDS).writeTimeout(optInt2, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (okHttpDispatcherExecutor != null) {
            builder.dispatcher(new Dispatcher(okHttpDispatcherExecutor));
        }
        return builder;
    }

    public static ExecutorService getFastThreadExecutor() {
        if (fastThreadExecutor == null) {
            synchronized (DownloadComponentManager.class) {
                if (fastThreadExecutor == null) {
                    int optInt = DownloadSetting.getGlobalSettings().optInt(DownloadSettingKeys.FAST_DOWNLOAD_THREAD_POOL_SIZE_LIMIT);
                    if (optInt <= 0) {
                        optInt = 20;
                    }
                    fastThreadExecutor = new ThreadPoolExecutor(0, optInt, isGlobalThreadPoolOptEnabled() ? 15L : 60L, TimeUnit.SECONDS, new SynchronousQueue(), new DefaultThreadFactory("DownloadThreadPool-Fast", true));
                }
            }
        }
        return fastThreadExecutor;
    }

    public static IDownloadDns getDownloadDns() {
        return downloadDns;
    }

    public static IDownloadDns getDefaultDownloadDns() {
        if (defaultDownloadDns == null) {
            synchronized (DownloadComponentManager.class) {
                if (defaultDownloadDns == null) {
                    defaultDownloadDns = new IDownloadDns() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.3
                        @Override // com.ss.android.socialbase.downloader.network.IDownloadDns
                        public List<InetAddress> lookup(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return defaultDownloadDns;
    }

    public static synchronized IDownloadLaunchHandler getDownloadLaunchHandler() {
        synchronized (DownloadComponentManager.class) {
            if (!DownloadUtils.ENABLE_APP_DOWNLOADER) {
                return null;
            }
            return downloadLaunchHandler;
        }
    }

    public static void setHttpService(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            httpService = iDownloadHttpService;
        }
        httpServiceInit = httpService != null;
    }

    public static IDownloadCache getDownloadCache() {
        if (downloadCache == null) {
            synchronized (DownloadComponentManager.class) {
                if (downloadCache == null) {
                    downloadCache = new DefaultDownloadCache();
                }
            }
        }
        return downloadCache;
    }

    public static IDownloadServiceHandler getDownloadServiceHandler() {
        if (downloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                if (downloadServiceHandler == null) {
                    downloadServiceHandler = new DefaultDownloadServiceHandler();
                }
            }
        }
        return downloadServiceHandler;
    }

    public static IDownloadServiceHandler getIndependentDownloadServiceHandler() {
        if (independentDownloadServiceHandler == null) {
            synchronized (DownloadComponentManager.class) {
                if (independentDownloadServiceHandler == null) {
                    if (independentHolderCreator != null) {
                        independentDownloadServiceHandler = independentHolderCreator.createServiceHandler();
                    } else {
                        return getDownloadServiceHandler();
                    }
                }
            }
        }
        return independentDownloadServiceHandler;
    }

    public static List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return downloadCompleteHandlers;
    }

    public static AbsDownloadEngine getDownloadEngine() {
        if (downloadEngine == null) {
            synchronized (DownloadComponentManager.class) {
                if (downloadEngine == null) {
                    setDownloadEngine();
                }
            }
        }
        return downloadEngine;
    }

    private static void setDownloadEngine() {
        if (DownloadHelper.getCacheSettingInt(DownloadSettingKeys.OPTIMIZE_DOWNLOAD_CACHE) > 0) {
            downloadEngine = new NewDownloadEngine();
        } else {
            downloadEngine = new DefaultDownloadEngine();
        }
    }

    private static void setIdGenerator(IDownloadIdGenerator iDownloadIdGenerator) {
        if (iDownloadIdGenerator != null) {
            ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).setDownloadIdGenerator(iDownloadIdGenerator);
        }
    }

    public static void setDownloadMonitorListener(IDownloadMonitorListener iDownloadMonitorListener) {
        if (iDownloadMonitorListener != null) {
            downloadMonitorListener = iDownloadMonitorListener;
        }
    }

    public static JSONObject getDownloadSetting() {
        JSONObject jSONObject = downloadSettings != null ? downloadSettings.get() : null;
        return jSONObject == null ? DownloadConstants.EMPTY_JSON : jSONObject;
    }

    public static void ensureOPPO() {
        if (TextUtils.isEmpty(DownloadConstants.LOWER_OPPO)) {
            DownloadConstants.LOWER_OPPO = "oppo";
            DownloadConstants.UPPER_OPPO = DownloadConstants.LOWER_OPPO.toUpperCase();
        }
    }

    public static void setDownloadSetting(IDownloadSettings iDownloadSettings) {
        downloadSettings = iDownloadSettings;
        DownloadSetting.init();
        Logger.alogE(TAG, "Run setDownloadSetting");
    }

    private static void needAutoRefreshUnSuccessTask(boolean z) {
        needAutoRefreshUnSuccessTask = z;
    }

    public static boolean needAutoRefreshUnSuccessTask() {
        return needAutoRefreshUnSuccessTask;
    }

    public static void setDownloadMemoryInfoListener(IDownloadMemoryInfoListener iDownloadMemoryInfoListener) {
        downloadMemoryInfoListener = iDownloadMemoryInfoListener;
    }

    public static IDownloadMemoryInfoListener getDownloadMemoryInfoListener() {
        return downloadMemoryInfoListener;
    }

    public static void setDownloadDBListener(IDownloadDBListener iDownloadDBListener) {
        downloadDBListener = iDownloadDBListener;
    }

    public static IDownloadDBListener getDownloadDBListener() {
        return downloadDBListener;
    }

    public static IDownloadStatusListener getDownloadStatusListener() {
        return downloadStatusListener;
    }

    public static void setDownloadStatusListener(IDownloadStatusListener iDownloadStatusListener) {
        downloadStatusListener = iDownloadStatusListener;
    }

    public static void setDownloadNetworkHandler(IDownloadNetworkHandler iDownloadNetworkHandler) {
        downloadNetworkHandler = iDownloadNetworkHandler;
    }

    public static void initDownloadCacheImmediately() {
        getDownloadCache().initImmediately();
    }

    public static int getWriteBufferSize() {
        return writeBufferSize;
    }

    public static void setNotificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        if (iNotificationClickCallback != null) {
            notificationClickCallback = GlobalListenerAdaptor.addListener(iNotificationClickCallback);
        }
    }

    public static INotificationClickCallback getNotificationClickCallback() {
        return notificationClickCallback;
    }

    public static ITTNetHandler getTTNetHandler() {
        if (iTTNetHandler == null) {
            synchronized (DownloadComponentManager.class) {
                if (iTTNetHandler == null) {
                    iTTNetHandler = new ITTNetHandler.DefaultTTNetHandler();
                }
            }
        }
        return iTTNetHandler;
    }

    public static IDownloadInterceptor getDownloadInterceptor() {
        return downloadInterceptor;
    }

    public static IDownloadThreadCheckListener getDownloadThreadCheckListener() {
        return threadCheckListener;
    }

    public static synchronized Context getAppContext() {
        Context context;
        synchronized (DownloadComponentManager.class) {
            context = appContext;
        }
        return context;
    }

    public static synchronized void setAppContext(Context context) {
        synchronized (DownloadComponentManager.class) {
            if (context != null) {
                if (appContext == null) {
                    appContext = context.getApplicationContext();
                    AppStatusManager.getInstance().init(appContext);
                    if (Logger.debug()) {
                        Logger.globalDebug(TAG, "setAppContext", "Context:" + context);
                    }
                }
            }
        }
    }

    public static int getDownloadId(DownloadInfo downloadInfo) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(downloadInfo);
    }

    public static int getDownloadId(String str, String str2) {
        return ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(str, str2);
    }

    public static synchronized boolean isHttpServiceInit() {
        boolean z;
        synchronized (DownloadComponentManager.class) {
            z = httpServiceInit;
        }
        return z;
    }

    public static InnerEventListener getEventListener() {
        if (downloadEventListener == null) {
            downloadEventListener = new InnerEventListener() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadComponentManager.4
                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onEvent(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.monitor.InnerEventListener
                public void onUnityEvent(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return downloadEventListener;
    }

    public static IReserveWifiStatusListener getReserveWifiStatusListener() {
        return reserveWifiStatusListener;
    }

    public static void setDownloadEventListener(InnerEventListener innerEventListener) {
        downloadEventListener = GlobalListenerAdaptor.addListener(innerEventListener);
    }

    public static void setReserveWifiStatusListener(IReserveWifiStatusListener iReserveWifiStatusListener) {
        reserveWifiStatusListener = GlobalListenerAdaptor.addListener(iReserveWifiStatusListener);
    }

    public static boolean isInit() {
        return hasInit;
    }

    public static void setIndependentServiceCreator(IndependentHolderCreator independentHolderCreator2) {
        if (DownloadUtils.optimizeMultiProcess()) {
            return;
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "setIndependentServiceCreator", "Creator: " + independentHolderCreator2);
        }
        independentHolderCreator = independentHolderCreator2;
    }

    public static boolean supportMultiProc() {
        return independentHolderCreator != null;
    }

    public static IndependentHolderCreator getIndependentHolderCreator() {
        return independentHolderCreator;
    }

    public static void updateCurrentDownloadThreadInfo(DownloadTask downloadTask, boolean z) {
        Map<String, DownloadThreadInfo.ThreadExecutorInfo> map;
        if (downloadTask == null || downloadTask.getDownloadInfo().isFastDownload()) {
            return;
        }
        if (z) {
            map = downloadTask.getThreadInfo().beforeDownloadThreadExecutors;
        } else {
            map = downloadTask.getThreadInfo().afterDownloadThreadExecutors;
        }
        if (map.isEmpty()) {
            map.put(MonitorConstants.CPU, DownloadThreadInfo.parse(cpuThreadExecutor));
            map.put(MonitorConstants.f71IO, DownloadThreadInfo.parse(ioThreadExecutor));
            map.put(MonitorConstants.MIX_DEFAULT, DownloadThreadInfo.parse(mixDefaultDownloadExecutor));
            map.put(MonitorConstants.MIX_APK, DownloadThreadInfo.parse(mixApkDownloadExecutor));
            map.put("db", DownloadThreadInfo.parse(dbThreadExecutor));
            map.put(MonitorConstants.CHUNK, DownloadThreadInfo.parse(chunkDownloadExecutor));
            map.put(MonitorConstants.SEGMENT, DownloadThreadInfo.parse(segmentThreadExecutor));
            map.put(MonitorConstants.OKHTTP, DownloadThreadInfo.parse(okHttpDispatcherExecutor));
            map.put(MonitorConstants.SCHEDULE, DownloadThreadInfo.parse(scheduledExecutor));
            map.put(MonitorConstants.SINGLE, DownloadThreadInfo.parse(singleThreadExecutor));
            map.put("custom", DownloadThreadInfo.parse(customThreadExecutor));
        }
    }

    public static void enableLruCache() {
        enableLruCache = true;
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "enableLruCache", "Run");
        }
    }

    public static boolean isEnableLruCache() {
        return enableLruCache;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long clearAllDownloadCache(boolean z, Set<String> set) {
        IDownloadCache downloadCache2;
        List<DownloadInfo> allDownloadInfo;
        long j = 0;
        try {
            downloadCache2 = getDownloadCache();
            boolean ensureDownloadCacheSyncSuccess = downloadCache2.ensureDownloadCacheSyncSuccess();
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadCache sync:" + ensureDownloadCacheSyncSuccess);
            }
            allDownloadInfo = downloadCache2.getAllDownloadInfo();
        } catch (Throwable th) {
            th = th;
        }
        if (allDownloadInfo == null) {
            if (Logger.debug()) {
                Logger.globalDebug(TAG, "clearAllDownloadCache", "DownloadInfos is null");
            }
            return 0L;
        }
        AbsDownloadEngine downloadEngine2 = getDownloadEngine();
        long j2 = 0;
        for (DownloadInfo downloadInfo : allDownloadInfo) {
            try {
                if (!downloadEngine2.isDownloading(downloadInfo.getId()) && DownloadDirUtils.isSavePathSecurity(downloadInfo.getSavePath()) && (set == null || TextUtils.isEmpty(downloadInfo.getMonitorScene()) || !set.contains(downloadInfo.getMonitorScene()))) {
                    if (downloadInfo.getCurBytes() > 0) {
                        j2 += downloadInfo.getCurBytes();
                    }
                    if (z) {
                        downloadCache2.removeDownloadTaskData(downloadInfo.getId());
                        DownloadUtils.clearDownloadFile(downloadInfo.getSavePath(), downloadInfo.getTempPath(), downloadInfo.getName());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                j = j2;
                th.printStackTrace();
                if (Logger.debug()) {
                    Logger.globalDebug(TAG, "clearAllDownloadCache", "Error:" + th);
                }
                j2 = j;
                if (Logger.debug()) {
                }
                return j2;
            }
        }
        if (Logger.debug()) {
            Logger.globalDebug(TAG, "clearAllDownloadCache", "ClearSize:" + j2 + " clear:" + z);
        }
        return j2;
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
    public static Intent m124x22dfecec(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        }
        try {
            if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                ReceiverRegisterLancet.initHandler();
                Context context2 = context;
                return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
            }
            if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                ReceiverRegisterLancet.initProxyHandler();
                Context context3 = context;
                return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
            }
            return context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Exception e) {
            if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                throw e;
            }
            return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    @Proxy("unregisterReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    /* renamed from: INVOKEVIRTUAL_com_ss_android_socialbase_downloader_downloader_DownloadComponentManager_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver */
    public static void m125xcf65c305(Context context, BroadcastReceiver broadcastReceiver) {
        ReceiverRegisterLancet.loge(broadcastReceiver, false);
        context.unregisterReceiver(broadcastReceiver);
    }
}
