package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.ss.android.socialbase.appdownloader.depend.IAppDownloadEventListener;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadCdnListener;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.IDownloadMonitorDepend;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.IRetryDelayTimeCalculator;
import com.ss.android.socialbase.downloader.model.HttpHeader;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppTaskBuilder {
    private int antiHijackErrorCode;
    private IAppDownloadEventListener appDownloadEventListener;
    private boolean autoInstall;
    private boolean autoInstallWithNotification;
    private boolean autoInstallWithoutNotification;
    private boolean autoResumed;
    private int backUpUrlRetryCount;
    private List<String> backUpUrls;
    private Object bpeaToken;
    private long cacheLifeTimeMax;
    private IDownloadCdnListener cdnListener;
    private List<String> cdnUrls;
    private Context context;
    private IDownloadDepend depend;
    private IDownloadDiskSpaceHandler diskSpaceHandler;
    private boolean distinctDirectory;
    private List<IDownloadCompleteHandler> downloadCompleteHandlers;
    private JSONObject downloadSetting;
    private EnqueueType enqueueType;
    private int executorGroup;
    private long expectFileLength;
    private String extra;
    private int[] extraMonitorStatus;
    private IDownloadFileUriProvider fileUriProvider;
    private boolean force;
    private List<HttpHeader> headers;
    private String iconUrl;
    private boolean ignoreInterceptor;
    private String mExternalSavePath;
    private boolean mHandleRequest;
    private String mInstallBizParamsJson;
    private String mInstallBizType;
    private String mInstallCertId;
    private IDownloadListener mSubThreadListener;
    private IDownloadListener mainThreadListener;
    private int maxProgressCount;
    private String md5;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private IDownloadMonitorDepend monitorDepend;
    private String monitorScene;
    private String name;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needSDKMonitor;
    private boolean needWifi;
    private INotificationClickCallback notificationClickCallback;
    private AbsNotificationItem notificationItem;
    private IDownloadListener notificationListener;
    private String packageName;
    private List<String> pcdnUrls;
    private int retryCount;
    private String saveName;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private String taskKey;
    private int taskPriority;
    private long throttleNetSpeed;
    private int throttleSmoothness;
    private String url;

    @Deprecated
    public AppTaskBuilder headConnectionAvailable(boolean z) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder needChunkDowngradeRetry(boolean z) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder needRetryDelay(boolean z) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder needReuseChunkRunnable(boolean z) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder needReuseFirstConnection(boolean z) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder retryDelayTimeArray(String str) {
        return this;
    }

    @Deprecated
    public AppTaskBuilder retryDelayTimeCalculator(IRetryDelayTimeCalculator iRetryDelayTimeCalculator) {
        return this;
    }

    public AppTaskBuilder(Context context, String str) {
        this(context, str, null);
    }

    public AppTaskBuilder(Context context, String str, Object obj) {
        this.taskPriority = 0;
        this.showNotification = true;
        this.autoInstallWithoutNotification = false;
        this.autoInstallWithNotification = true;
        this.needWifi = false;
        this.mimeType = "application/vnd.android.package-archive";
        this.retryCount = 5;
        this.needDefaultHttpServiceBackUp = true;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.minProgressTimeMsInterval = 150;
        this.downloadCompleteHandlers = new ArrayList();
        this.autoInstall = true;
        this.ignoreInterceptor = false;
        this.needSDKMonitor = true;
        this.context = context.getApplicationContext();
        this.url = str;
        this.bpeaToken = obj;
    }

    public Context getContext() {
        return this.context;
    }

    public String getUrl() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public int getTaskPriority() {
        return this.taskPriority;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public List<HttpHeader> getHeaders() {
        return this.headers;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isAutoInstallWithoutNotification() {
        return this.autoInstallWithoutNotification;
    }

    public boolean isAutoInstallWithNotification() {
        return this.autoInstallWithNotification;
    }

    public boolean isNeedWifi() {
        return this.needWifi;
    }

    public IDownloadListener getMainThreadListener() {
        return this.mainThreadListener;
    }

    public IDownloadListener getNotificationListener() {
        return this.notificationListener;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public AbsNotificationItem getNotificationItem() {
        return this.notificationItem;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public int getAntiHijackErrorCode() {
        return this.antiHijackErrorCode;
    }

    public void setAntiHijackErrorCode(int i) {
        this.antiHijackErrorCode = i;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getExpectFileLength() {
        return this.expectFileLength;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public int getMinProgressTimeMsInterval() {
        return this.minProgressTimeMsInterval;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public boolean isForce() {
        return this.force;
    }

    public String getSaveName() {
        return this.saveName;
    }

    public IDownloadMonitorDepend getMonitorDepend() {
        return this.monitorDepend;
    }

    public IDownloadDepend getDepend() {
        return this.depend;
    }

    public IAppDownloadEventListener getAppDownloadEventListener() {
        return this.appDownloadEventListener;
    }

    public IDownloadFileUriProvider getFileUriProvider() {
        return this.fileUriProvider;
    }

    public INotificationClickCallback getNotificationClickCallback() {
        return this.notificationClickCallback;
    }

    public List<IDownloadCompleteHandler> getDownloadCompleteHandlers() {
        return this.downloadCompleteHandlers;
    }

    public IDownloadCdnListener getCdnListener() {
        return this.cdnListener;
    }

    public int getExecutorGroup() {
        return this.executorGroup;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public boolean isDistinctDirectory() {
        return this.distinctDirectory;
    }

    public boolean isAutoInstall() {
        return this.autoInstall;
    }

    public String getTaskKey() {
        return this.taskKey;
    }

    public Object getBpeaToken() {
        return this.bpeaToken;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public String getExternalSavePath() {
        return this.mExternalSavePath;
    }

    public String getInstallBizType() {
        return this.mInstallBizType;
    }

    public String getInstallCertId() {
        return this.mInstallCertId;
    }

    public String getInstallBizParamsJson() {
        return this.mInstallBizParamsJson;
    }

    public AppTaskBuilder taskKey(String str) {
        this.taskKey = str;
        return this;
    }

    public AppTaskBuilder name(String str) {
        this.name = str;
        return this;
    }

    public AppTaskBuilder taskPriority(int i) {
        this.taskPriority = i;
        return this;
    }

    public AppTaskBuilder saveName(String str) {
        this.saveName = str;
        return this;
    }

    public AppTaskBuilder savePath(String str) {
        this.savePath = str;
        return this;
    }

    public AppTaskBuilder headers(List<HttpHeader> list) {
        this.headers = list;
        return this;
    }

    public AppTaskBuilder showNotification(boolean z) {
        this.showNotification = z;
        return this;
    }

    @Deprecated
    public AppTaskBuilder autoInstallWithNotification(boolean z) {
        this.autoInstallWithNotification = z;
        return this;
    }

    public AppTaskBuilder autoInstallWithoutNotification(boolean z) {
        this.autoInstallWithoutNotification = z;
        return this;
    }

    public AppTaskBuilder needWifi(boolean z) {
        this.needWifi = z;
        return this;
    }

    public AppTaskBuilder mainThreadListener(IDownloadListener iDownloadListener) {
        this.mainThreadListener = iDownloadListener;
        return this;
    }

    public IDownloadListener getSubThreadListener() {
        return this.mSubThreadListener;
    }

    public AppTaskBuilder subThreadListener(IDownloadListener iDownloadListener) {
        this.mSubThreadListener = iDownloadListener;
        return this;
    }

    public AppTaskBuilder notificationListener(IDownloadListener iDownloadListener) {
        this.notificationListener = iDownloadListener;
        return this;
    }

    public AppTaskBuilder extra(String str) {
        this.extra = str;
        return this;
    }

    public AppTaskBuilder mimeType(String str) {
        this.mimeType = str;
        return this;
    }

    public AppTaskBuilder needHttpsToHttpRetry(boolean z) {
        this.needHttpsToHttpRetry = z;
        return this;
    }

    public AppTaskBuilder notificationItem(AbsNotificationItem absNotificationItem) {
        this.notificationItem = absNotificationItem;
        return this;
    }

    public AppTaskBuilder autoResumed(boolean z) {
        this.autoResumed = z;
        return this;
    }

    public AppTaskBuilder showNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
        return this;
    }

    public AppTaskBuilder packageName(String str) {
        this.packageName = str;
        return this;
    }

    public AppTaskBuilder md5(String str) {
        this.md5 = str;
        return this;
    }

    public AppTaskBuilder expectFileLength(long j) {
        this.expectFileLength = j;
        return this;
    }

    public AppTaskBuilder retryCount(int i) {
        this.retryCount = i;
        return this;
    }

    public AppTaskBuilder cdnListener(IDownloadCdnListener iDownloadCdnListener) {
        this.cdnListener = iDownloadCdnListener;
        return this;
    }

    public AppTaskBuilder backUpUrlRetryCount(int i) {
        this.backUpUrlRetryCount = i;
        return this;
    }

    public AppTaskBuilder needDefaultHttpServiceBackUp(boolean z) {
        this.needDefaultHttpServiceBackUp = z;
        return this;
    }

    public AppTaskBuilder needIndependentProcess(boolean z) {
        this.needIndependentProcess = z;
        return this;
    }

    public AppTaskBuilder minProgressTimeMsInterval(int i) {
        this.minProgressTimeMsInterval = i;
        return this;
    }

    public AppTaskBuilder maxProgressCount(int i) {
        this.maxProgressCount = i;
        return this;
    }

    public AppTaskBuilder enqueueType(EnqueueType enqueueType) {
        this.enqueueType = enqueueType;
        return this;
    }

    public AppTaskBuilder force(boolean z) {
        this.force = z;
        return this;
    }

    public AppTaskBuilder depend(IDownloadDepend iDownloadDepend) {
        this.depend = iDownloadDepend;
        return this;
    }

    public AppTaskBuilder monitorDepend(IDownloadMonitorDepend iDownloadMonitorDepend) {
        this.monitorDepend = iDownloadMonitorDepend;
        return this;
    }

    public AppTaskBuilder appDownloadEventListener(IAppDownloadEventListener iAppDownloadEventListener) {
        this.appDownloadEventListener = iAppDownloadEventListener;
        return this;
    }

    public AppTaskBuilder fileUriProvider(IDownloadFileUriProvider iDownloadFileUriProvider) {
        this.fileUriProvider = iDownloadFileUriProvider;
        return this;
    }

    public AppTaskBuilder notificationClickCallback(INotificationClickCallback iNotificationClickCallback) {
        this.notificationClickCallback = iNotificationClickCallback;
        return this;
    }

    public AppTaskBuilder needSDKMonitor(boolean z) {
        this.needSDKMonitor = z;
        return this;
    }

    public AppTaskBuilder monitorScene(String str) {
        this.monitorScene = str;
        return this;
    }

    public AppTaskBuilder setCacheLifeTimeMax(long j) {
        this.cacheLifeTimeMax = j;
        return this;
    }

    public AppTaskBuilder extraMonitorStatus(int[] iArr) {
        this.extraMonitorStatus = iArr;
        return this;
    }

    public AppTaskBuilder pcdnUrls(List<String> list) {
        this.pcdnUrls = list;
        return this;
    }

    public AppTaskBuilder cdnUrls(List<String> list) {
        this.cdnUrls = list;
        return this;
    }

    public AppTaskBuilder iconUrl(String str) {
        this.iconUrl = str;
        return this;
    }

    public AppTaskBuilder externalSavePath(String str) {
        this.mExternalSavePath = str;
        return this;
    }

    public AppTaskBuilder ignoreInterceptor(boolean z) {
        this.ignoreInterceptor = z;
        return this;
    }

    public AppTaskBuilder installBizType(String str) {
        this.mInstallBizType = str;
        return this;
    }

    public AppTaskBuilder installCertId(String str) {
        this.mInstallCertId = str;
        return this;
    }

    public AppTaskBuilder installBizParamsJson(String str) {
        this.mInstallBizParamsJson = str;
        return this;
    }

    public AppTaskBuilder handleRequest() {
        this.mHandleRequest = true;
        return this;
    }

    public boolean isHandleRequest() {
        return this.mHandleRequest;
    }

    public boolean isIgnoreInterceptor() {
        return this.ignoreInterceptor;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public AppTaskBuilder executorGroup(int i) {
        this.executorGroup = i;
        return this;
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public AppTaskBuilder backUpUrls(List<String> list) {
        this.backUpUrls = list;
        return this;
    }

    public IDownloadDiskSpaceHandler getDiskSpaceHandler() {
        return this.diskSpaceHandler;
    }

    public AppTaskBuilder diskSpaceHandler(IDownloadDiskSpaceHandler iDownloadDiskSpaceHandler) {
        this.diskSpaceHandler = iDownloadDiskSpaceHandler;
        return this;
    }

    public JSONObject getDownloadSetting() {
        return this.downloadSetting;
    }

    public AppTaskBuilder downloadSetting(JSONObject jSONObject) {
        this.downloadSetting = jSONObject;
        return this;
    }

    public AppTaskBuilder addDownloadCompleteHandler(IDownloadCompleteHandler iDownloadCompleteHandler) {
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

    public AppTaskBuilder throttleNetSpeed(long j) {
        this.throttleNetSpeed = j;
        return this;
    }

    public AppTaskBuilder throttleSmoothness(int i) {
        this.throttleSmoothness = i;
        return this;
    }

    public AppTaskBuilder distinctDirectory(boolean z) {
        this.distinctDirectory = z;
        return this;
    }

    public AppTaskBuilder autoInstall(boolean z) {
        this.autoInstall = z;
        return this;
    }

    public String toString() {
        return "AppTaskBuilder{context=" + this.context + ", url='" + this.url + "', backUpUrls=" + this.backUpUrls + ", name='" + this.name + "', taskPriority=" + this.taskPriority + ", saveName='" + this.saveName + "', savePath='" + this.savePath + "', headers=" + this.headers + ", showNotification=" + this.showNotification + ", autoInstallWithoutNotification=" + this.autoInstallWithoutNotification + ", autoInstallWithNotification=" + this.autoInstallWithNotification + ", needWifi=" + this.needWifi + ", mainThreadListener=" + this.mainThreadListener + ", notificationListener=" + this.notificationListener + ", extra='" + this.extra + "', mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", notificationItem=" + this.notificationItem + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", packageName='" + this.packageName + "', md5='" + this.md5 + "', expectFileLength=" + this.expectFileLength + ", force=" + this.force + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", needIndependentProcess=" + this.needIndependentProcess + ", enqueueType=" + this.enqueueType + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", maxProgressCount=" + this.maxProgressCount + ", monitorDepend=" + this.monitorDepend + ", depend=" + this.depend + ", appDownloadEventListener=" + this.appDownloadEventListener + ", fileUriProvider=" + this.fileUriProvider + ", diskSpaceHandler=" + this.diskSpaceHandler + ", notificationClickCallback=" + this.notificationClickCallback + ", cdnListener=" + this.cdnListener + ", downloadSetting=" + this.downloadSetting + ", iconUrl='" + this.iconUrl + "', downloadCompleteHandlers=" + this.downloadCompleteHandlers + ", executorGroup=" + this.executorGroup + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", antiHijackErrorCode=" + this.antiHijackErrorCode + ", distinctDirectory=" + this.distinctDirectory + ", autoInstall=" + this.autoInstall + ", ignoreInterceptor=" + this.ignoreInterceptor + ", bpeaToken=" + this.bpeaToken + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", taskKey='" + this.taskKey + "', pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", mExternalSavePath='" + this.mExternalSavePath + "', mInstallBizType=" + this.mInstallBizType + ", mInstallCertId='" + this.mInstallCertId + "', mInstallBizParamsJson='" + this.mInstallBizParamsJson + "'}";
    }
}
