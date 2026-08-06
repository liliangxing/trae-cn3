package com.ss.android.socialbase.downloader.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import com.lynx.tasm.p001ui.image.ImageDelegate;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.AsyncHandleStatus;
import com.ss.android.socialbase.downloader.constants.ByteInvalidRetryStatus;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.file.DownloadFile;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.service.DownloadServiceManager;
import com.ss.android.socialbase.downloader.service.IDownloadComponentManagerService;
import com.ss.android.socialbase.downloader.service.IDownloadIdGeneratorService;
import com.ss.android.socialbase.downloader.service.IDownloadProcessDispatcherService;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadDirUtils;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new Parcelable.Creator<DownloadInfo>() { // from class: com.ss.android.socialbase.downloader.model.DownloadInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadInfo[] newArray(int i) {
            return new DownloadInfo[i];
        }
    };
    private static final int DEFAULT_MAX_PROCESS_POST_COUNT = 100;
    private static final long DEFAULT_MIN_BYTES_INTERVAL = 1048576;
    private static boolean OPTIMIZE_MONITOR_LOAD = false;
    private static final int RESERVE_STATUS_NEVER = 0;
    private static final int RESERVE_STATUS_NOW = 2;
    private static final int RESERVE_STATUS_ONCE = 1;
    private static final String TAG = "DownloadInfo";
    private List<String> accessHttpHeaderKeys;
    private boolean addListenerToSameTask;
    private boolean addTTNetCommonParam;
    private AtomicLong allConnectTime;
    private int appVersionCode;
    private AsyncHandleStatus asyncHandleStatus;
    private boolean autoResumed;
    private AtomicLong backCurBytes;
    private int backUpUrlRetryCount;
    private boolean backUpUrlUsed;
    private List<String> backUpUrls;
    private String backUpUrlsStr;
    private int bindValueCount;
    private ByteInvalidRetryStatus byteInvalidRetryStatus;
    private long cacheLifeTimeMax;
    private List<String> cdnUrls;
    private String cdnUrlsStr;
    private int chunkCount;
    private String contentEncoding;
    private int curBackUpUrlIndex;
    private AtomicLong curBytes;
    private int curNetworkRetryCount;
    private int curRetryTime;
    private JSONObject dbJsonData;
    private String dbJsonDataString;
    private boolean deleteCacheIfCheckFailed;
    private long downloadFinishTimeStamp;
    private long downloadStartTimeStamp;
    private long downloadTime;
    private String eTag;
    private EnqueueType enqueueType;
    private boolean expiredHttpCheck;
    private boolean expiredRedownload;
    private String extra;
    private List<HttpHeader> extraHeaders;
    private int[] extraMonitorStatus;
    private BaseException failedException;
    private boolean fastDownload;
    private String filePackageName;
    private List<String> forbiddenBackupUrls;
    private boolean force;
    private boolean handleRequest;
    private boolean hasDoInstallation;
    private Map<String, String> httpHeaders;
    private String httpRequestHeader;
    private String httpResponseHeader;
    private int httpStatusCode;
    private String httpStatusMessage;
    private boolean httpsToHttpRetryUsed;
    private String iconUrl;

    /* renamed from: id */
    private int f75id;
    private boolean ignoreDataVerify;
    private Boolean ignoreInterceptor;
    private long installedTimeStamp;
    private int interceptFlag;
    private Boolean isAutoInstallWithoutNotification;
    private boolean isCacheExistsInDownloading;
    private boolean isFirstDownload;
    private boolean isFirstSuccess;
    private boolean isForbiddenRetryed;
    private long lastNotifyProgressTime;
    private int mDBInitStatus;
    private boolean mDownloadFromReserveWifi;
    private int mTaskSleepTime;
    private int maxBytes;
    private int maxProgressCount;
    private String md5;
    private long md5Time;
    private String mimeType;
    private int minProgressTimeMsInterval;
    private String monitorScene;
    private String name;
    private boolean needCurrentProcess;
    private boolean needDefaultHttpServiceBackUp;
    private boolean needHttpsToHttpRetry;
    private boolean needIndependentProcess;
    private boolean needPostProgress;
    private boolean needSDKMonitor;
    private String networkQuality;
    private int notificationVisibility;
    private boolean onlyWifi;
    private boolean openLimitSpeed;
    private String[] outIp;
    private int[] outSize;
    private SoftReference<PackageInfo> packageInfoRef;
    private String packageName;
    private JSONObject pcdnStats;
    private List<String> pcdnUrls;
    private String pcdnUrlsStr;
    private long realBackDownloadTime;
    private long realDownloadTime;
    private long realStartDownloadTime;
    private String requestLog;
    private int retryCount;
    private String savePath;
    private boolean showNotification;
    private boolean showNotificationForAutoResumed;
    private boolean showNotificationForNetworkResumed;
    private JSONObject spData;
    private long startDownloadTime;
    private AtomicInteger status;
    private int statusAtDbInit;
    private boolean successByCache;
    private boolean supportPartial;
    private ConcurrentHashMap<String, Object> tempCacheData;
    private String tempPath;
    private long throttleNetSpeed;
    private int throttleSmoothness;
    private String title;
    private long totalBytes;
    private long ttnetProtectTimeout;
    private String url;
    private long verifyCurBytes;
    private long xTotalBytes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static void setOptimizeMonitorLoad(boolean z) {
        OPTIMIZE_MONITOR_LOAD = z;
    }

    public DownloadInfo() {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0L;
        this.downloadFinishTimeStamp = 0L;
        this.installedTimeStamp = 0L;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    @Deprecated
    public DownloadInfo(Cursor cursor) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0L;
        this.downloadFinishTimeStamp = 0L;
        this.installedTimeStamp = 0L;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
    }

    private DownloadInfo(Builder builder) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        int i = 0;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0L;
        this.downloadFinishTimeStamp = 0L;
        this.installedTimeStamp = 0L;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        if (builder == null) {
            return;
        }
        this.status = new AtomicInteger(0);
        this.curBytes = new AtomicLong(0L);
        this.monitorScene = builder.monitorScene;
        this.fastDownload = builder.fastDownload;
        this.name = builder.name;
        this.url = builder.url;
        String str = builder.savePath;
        if (TextUtils.isEmpty(str)) {
            try {
                str = DownloadDirUtils.getDownloadPath();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.savePath = str;
        this.handleRequest = builder.handleRequest;
        if (builder.fastDownload) {
            this.tempPath = DownloadDirUtils.getDownloadFastTempPath();
            return;
        }
        this.backCurBytes = new AtomicLong(0L);
        this.tempPath = builder.tempPath;
        unsafeEnsureDBJsonData();
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_TASK_KEY, builder.taskKey);
        if (TextUtils.isEmpty(this.tempPath) && !DownloadDirUtils.isSavePathSecurity(str)) {
            this.tempPath = DownloadDirUtils.getDownloadTempPath();
        }
        if (builder.distinctDirectory && ((IDownloadProcessDispatcherService) DownloadServiceManager.getService(IDownloadProcessDispatcherService.class)).getDownloadInfo(getId()) == null) {
            this.savePath = DownloadUtils.generateDistinctDirectory(this.savePath, this.url);
            this.tempPath = DownloadUtils.generateDistinctDirectory(this.tempPath, this.url);
        }
        this.extra = builder.extra;
        this.onlyWifi = builder.onlyWifi;
        this.extraHeaders = builder.extraHeaders;
        this.maxBytes = builder.maxBytes;
        this.retryCount = builder.retryCount;
        this.backUpUrlRetryCount = builder.backUpUrlRetryCount;
        this.force = builder.force;
        this.outIp = builder.outIp;
        this.outSize = builder.outSize;
        this.needPostProgress = builder.needPostProgress;
        this.maxProgressCount = builder.maxProgressCount;
        this.minProgressTimeMsInterval = builder.minProgressTimeMsInterval;
        this.backUpUrls = builder.backUpUrls;
        this.showNotification = builder.showNotification;
        this.mimeType = builder.mimeType;
        this.needHttpsToHttpRetry = builder.needHttpsToHttpRetry;
        this.autoResumed = builder.autoResumed;
        this.showNotificationForAutoResumed = builder.showNotificationForAutoResumed;
        this.needDefaultHttpServiceBackUp = builder.needDefaultHttpServiceBackUp;
        this.packageName = builder.packageName;
        this.md5 = builder.md5;
        this.needIndependentProcess = builder.needIndependentProcess;
        this.needCurrentProcess = builder.needCurrentProcess;
        this.enqueueType = builder.enqueueType;
        this.ignoreDataVerify = builder.ignoreDataVerify;
        this.addListenerToSameTask = builder.addListenerToSameTask;
        this.iconUrl = builder.iconUrl;
        this.throttleNetSpeed = builder.throttleNetSpeed;
        this.throttleSmoothness = builder.throttleSmoothness;
        this.openLimitSpeed = builder.openLimitSpeed;
        this.title = builder.title;
        JSONObject jSONObject = builder.downloadSetting;
        if (jSONObject != null) {
            DownloadSetting.addTaskDownloadSetting(getId(), builder.monitorScene, jSONObject);
            unsafePutToDBJsonData(DbJsonConstants.DOWNLOAD_SETTING, jSONObject.toString());
        }
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH, Long.valueOf(builder.expectFileLength));
        unsafePutToDBJsonData("executor_group", Integer.valueOf(builder.executorGroup));
        unsafePutToDBJsonData(DbJsonConstants.AUTO_INSTALL, Integer.valueOf(builder.autoInstall ? 1 : 0));
        this.needSDKMonitor = builder.needSDKMonitor;
        this.extraMonitorStatus = builder.extraMonitorStatus;
        this.expiredRedownload = builder.expiredRedownload;
        this.expiredHttpCheck = builder.expiredHttpCheck;
        this.deleteCacheIfCheckFailed = builder.deleteCacheIfCheckFailed;
        this.ttnetProtectTimeout = builder.ttnetProtectTimeout;
        this.addTTNetCommonParam = builder.addTTNetCommonParam;
        Boolean valueOf = Boolean.valueOf(builder.ignoreInterceptor);
        this.ignoreInterceptor = valueOf;
        if (valueOf.booleanValue() || ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getDownloadInterceptor() == null) {
            this.interceptFlag = 0;
        }
        this.accessHttpHeaderKeys = builder.accessHttpHeaderKeys;
        this.pcdnUrls = builder.pcdnUrls;
        this.cdnUrls = builder.cdnUrls;
        this.cacheLifeTimeMax = builder.cacheLifeTimeMax;
        unsafePutToDBJsonData(DbJsonConstants.IGNORE_INTERCEPT, Integer.valueOf(builder.ignoreInterceptor ? 1 : 0));
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_START_OFFSET, Long.valueOf(builder.startOffset));
        unsafePutToDBJsonData(DbJsonConstants.DBJSON_KEY_END_OFFSET, Long.valueOf(builder.endOffset));
        if (OPTIMIZE_MONITOR_LOAD) {
            return;
        }
        unsafePutToDBJsonData(DbJsonConstants.NEED_SDK_MONITOR, Boolean.valueOf(this.needSDKMonitor));
        unsafePutToDBJsonData(DbJsonConstants.MONITOR_SCENE, this.monitorScene);
        try {
            JSONArray jSONArray = new JSONArray();
            int[] iArr = this.extraMonitorStatus;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.extraMonitorStatus;
                    if (i >= iArr2.length) {
                        break;
                    }
                    jSONArray.put(iArr2[i]);
                    i++;
                }
            }
            unsafePutToDBJsonData(DbJsonConstants.EXTRA_MONITOR_STATUS, jSONArray);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private DownloadInfo(RawBuilder rawBuilder) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0L;
        this.downloadFinishTimeStamp = 0L;
        this.installedTimeStamp = 0L;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        this.f75id = rawBuilder.f76id;
        this.name = rawBuilder.name;
        this.title = rawBuilder.title;
        this.url = rawBuilder.url;
        this.savePath = rawBuilder.savePath;
        this.tempPath = rawBuilder.tempPath;
        this.chunkCount = rawBuilder.chunkCount;
        setStatus(rawBuilder.status);
        setCurBytes(rawBuilder.curBytes);
        setBackCurBytes(rawBuilder.backCurBytes);
        this.totalBytes = rawBuilder.totalBytes;
        this.eTag = rawBuilder.etag;
        this.onlyWifi = rawBuilder.onlyWifi;
        this.force = rawBuilder.force;
        this.retryCount = rawBuilder.retryCount;
        this.extra = rawBuilder.extra;
        this.mimeType = rawBuilder.mimeType;
        this.showNotification = rawBuilder.showNotification;
        this.notificationVisibility = rawBuilder.notificationVisibility;
        this.isFirstDownload = rawBuilder.isFirstDownload;
        this.isFirstSuccess = rawBuilder.isFirstSuccess;
        this.needHttpsToHttpRetry = rawBuilder.needHttpsToHttpRetry;
        this.downloadTime = rawBuilder.downloadTime;
        this.packageName = rawBuilder.packageName;
        this.md5 = rawBuilder.md5;
        this.curRetryTime = rawBuilder.curRetryTime;
        this.needDefaultHttpServiceBackUp = rawBuilder.needDefaultHttpServiceBackUp;
        this.backUpUrlsStr = rawBuilder.backUpUrlsStr;
        this.backUpUrlRetryCount = rawBuilder.backUpUrlRetryCount;
        this.realDownloadTime = rawBuilder.realDownloadTime;
        this.realBackDownloadTime = rawBuilder.realBackDownloadTime;
        this.needIndependentProcess = rawBuilder.needIndependentProcess;
        this.needCurrentProcess = rawBuilder.needCurrentProcess;
        this.dbJsonDataString = rawBuilder.dbJsonDataString;
        this.iconUrl = rawBuilder.iconUrl;
        this.appVersionCode = rawBuilder.appVersionCode;
        this.downloadStartTimeStamp = rawBuilder.downloadStartTimeStamp;
        this.downloadFinishTimeStamp = rawBuilder.downloadFinishTimeStamp;
        this.installedTimeStamp = rawBuilder.installedTimeStamp;
        this.hasDoInstallation = rawBuilder.hasDoInstallation;
        this.pcdnUrlsStr = rawBuilder.pcdnUrlsStr;
        this.cdnUrlsStr = rawBuilder.cdnUrlsStr;
        this.cacheLifeTimeMax = rawBuilder.cacheLifeTimeMax;
        this.monitorScene = rawBuilder.monitorScene;
        try {
            parseMonitorSetting();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setAddListenerToSameTask(boolean z) {
        this.addListenerToSameTask = z;
    }

    private void parseMonitorSetting() {
        if (!OPTIMIZE_MONITOR_LOAD || TextUtils.isEmpty(this.monitorScene)) {
            unsafeEnsureDBJsonData();
            this.needSDKMonitor = this.dbJsonData.optBoolean(DbJsonConstants.NEED_SDK_MONITOR, false);
            this.monitorScene = this.dbJsonData.optString(DbJsonConstants.MONITOR_SCENE, "");
            JSONArray optJSONArray = this.dbJsonData.optJSONArray(DbJsonConstants.EXTRA_MONITOR_STATUS);
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            this.extraMonitorStatus = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                this.extraMonitorStatus[i] = optJSONArray.optInt(i);
            }
        }
    }

    public void readFromParcel(Parcel parcel) {
        this.f75id = parcel.readInt();
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.url = parcel.readString();
        this.savePath = parcel.readString();
        this.tempPath = parcel.readString();
        this.onlyWifi = parcel.readByte() != 0;
        this.extra = parcel.readString();
        this.extraHeaders = parcel.createTypedArrayList(HttpHeader.CREATOR);
        this.maxBytes = parcel.readInt();
        this.outIp = parcel.createStringArray();
        this.outSize = parcel.createIntArray();
        this.retryCount = parcel.readInt();
        this.backUpUrlRetryCount = parcel.readInt();
        this.force = parcel.readByte() != 0;
        this.needPostProgress = parcel.readByte() != 0;
        this.maxProgressCount = parcel.readInt();
        this.minProgressTimeMsInterval = parcel.readInt();
        this.backUpUrls = parcel.createStringArrayList();
        this.showNotification = parcel.readByte() != 0;
        this.mimeType = parcel.readString();
        this.needHttpsToHttpRetry = parcel.readByte() != 0;
        this.packageName = parcel.readString();
        this.md5 = parcel.readString();
        this.needDefaultHttpServiceBackUp = parcel.readByte() != 0;
        this.eTag = parcel.readString();
        this.curRetryTime = parcel.readInt();
        this.networkQuality = parcel.readString();
        this.curBackUpUrlIndex = parcel.readInt();
        this.notificationVisibility = parcel.readInt();
        this.chunkCount = parcel.readInt();
        setCurBytes(parcel.readLong());
        setBackCurBytes(parcel.readLong());
        this.totalBytes = parcel.readLong();
        setStatus(parcel.readInt());
        this.downloadTime = parcel.readLong();
        this.realDownloadTime = parcel.readLong();
        this.realBackDownloadTime = parcel.readLong();
        this.backUpUrlUsed = parcel.readByte() != 0;
        this.httpsToHttpRetryUsed = parcel.readByte() != 0;
        this.autoResumed = parcel.readByte() != 0;
        this.showNotificationForAutoResumed = parcel.readByte() != 0;
        this.showNotificationForNetworkResumed = parcel.readByte() != 0;
        this.forbiddenBackupUrls = parcel.createStringArrayList();
        this.needIndependentProcess = parcel.readByte() != 0;
        convertEnqueueType(parcel.readInt());
        this.httpStatusCode = parcel.readInt();
        this.httpStatusMessage = parcel.readString();
        this.isForbiddenRetryed = parcel.readByte() != 0;
        this.addListenerToSameTask = parcel.readByte() != 0;
        this.failedException = (BaseException) parcel.readParcelable(BaseException.class.getClassLoader());
        this.dbJsonDataString = parcel.readString();
        this.supportPartial = parcel.readByte() != 0;
        this.iconUrl = parcel.readString();
        this.appVersionCode = parcel.readInt();
        this.expiredRedownload = parcel.readByte() != 0;
        this.deleteCacheIfCheckFailed = parcel.readByte() != 0;
        this.successByCache = parcel.readByte() != 0;
        this.expiredHttpCheck = parcel.readByte() != 0;
        this.xTotalBytes = parcel.readLong();
        this.interceptFlag = parcel.readInt();
        this.accessHttpHeaderKeys = parcel.createStringArrayList();
        this.httpHeaders = parcel.readHashMap(getClass().getClassLoader());
        this.downloadStartTimeStamp = parcel.readLong();
        this.downloadFinishTimeStamp = parcel.readLong();
        this.installedTimeStamp = parcel.readLong();
        this.hasDoInstallation = parcel.readByte() != 0;
        this.isCacheExistsInDownloading = parcel.readByte() != 0;
        this.cacheLifeTimeMax = parcel.readLong();
        this.pcdnUrls = parcel.createStringArrayList();
        this.cdnUrls = parcel.createStringArrayList();
        this.contentEncoding = parcel.readString();
        this.fastDownload = parcel.readByte() != 0;
        this.handleRequest = parcel.readByte() != 0;
        this.md5Time = parcel.readLong();
        this.httpRequestHeader = parcel.readString();
        this.httpResponseHeader = parcel.readString();
        this.requestLog = parcel.readString();
        this.verifyCurBytes = parcel.readLong();
        this.needCurrentProcess = parcel.readByte() != 0;
        this.monitorScene = parcel.readString();
        parseMonitorSetting();
    }

    public String getBackUpUrlsStr() {
        if (this.backUpUrlsStr == null) {
            this.backUpUrlsStr = DownloadUtils.listToJsonString(this.backUpUrls);
        }
        return this.backUpUrlsStr;
    }

    public void setBackUpUrlsStr(String str) {
        if (TextUtils.isEmpty(str) || getStatus() == -3) {
            return;
        }
        this.backUpUrlsStr = str;
        this.backUpUrls = DownloadUtils.jsonStringTolist(str);
    }

    public String getPcdnUrlsStr() {
        if (this.pcdnUrlsStr == null) {
            this.pcdnUrlsStr = DownloadUtils.listToJsonString(this.pcdnUrls);
        }
        return this.pcdnUrlsStr;
    }

    public String getCdnUrlsStr() {
        if (this.cdnUrlsStr == null) {
            this.cdnUrlsStr = DownloadUtils.listToJsonString(this.cdnUrls);
        }
        return this.cdnUrlsStr;
    }

    public boolean isWaitingWifiStatus() {
        BaseException baseException = this.failedException;
        return baseException != null && baseException.getErrorCode() == 1013;
    }

    public boolean canNotifyProgress() {
        return this.lastNotifyProgressTime == 0 || SystemClock.uptimeMillis() - this.lastNotifyProgressTime > 20;
    }

    public void setLastNotifyProgressTime() {
        this.lastNotifyProgressTime = SystemClock.uptimeMillis();
    }

    protected DownloadInfo(Parcel parcel) {
        this.needDefaultHttpServiceBackUp = true;
        this.asyncHandleStatus = AsyncHandleStatus.ASYNC_HANDLE_NONE;
        this.supportPartial = true;
        this.needSDKMonitor = true;
        this.expiredRedownload = false;
        this.expiredHttpCheck = false;
        this.deleteCacheIfCheckFailed = false;
        this.successByCache = false;
        this.ignoreInterceptor = null;
        this.interceptFlag = -1;
        this.downloadStartTimeStamp = 0L;
        this.downloadFinishTimeStamp = 0L;
        this.installedTimeStamp = 0L;
        this.hasDoInstallation = false;
        this.chunkCount = 1;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.byteInvalidRetryStatus = ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_NONE;
        this.enqueueType = EnqueueType.ENQUEUE_NONE;
        this.isAutoInstallWithoutNotification = null;
        readFromParcel(parcel);
    }

    private void convertEnqueueType(int i) {
        if (i == EnqueueType.ENQUEUE_HEAD.ordinal()) {
            this.enqueueType = EnqueueType.ENQUEUE_HEAD;
            return;
        }
        if (i == EnqueueType.ENQUEUE_TAIL.ordinal()) {
            this.enqueueType = EnqueueType.ENQUEUE_TAIL;
            return;
        }
        if (i == EnqueueType.NEW_ENQUEUE_NORMAL.ordinal()) {
            this.enqueueType = EnqueueType.NEW_ENQUEUE_NORMAL;
        } else if (i == EnqueueType.NEW_ENQUEUE_IMMEDIATE.ordinal()) {
            this.enqueueType = EnqueueType.NEW_ENQUEUE_IMMEDIATE;
        } else {
            this.enqueueType = EnqueueType.ENQUEUE_NONE;
        }
    }

    public int getDownloadProcess() {
        if (this.totalBytes <= 0) {
            return 0;
        }
        if (getCurBytes() > this.totalBytes) {
            return 100;
        }
        return (int) ((getCurBytes() * 100) / this.totalBytes);
    }

    public String getDBJsonDataString() {
        String jSONObject;
        String str = this.dbJsonDataString;
        if (str != null) {
            return str;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            jSONObject = this.dbJsonData.toString();
            this.dbJsonDataString = jSONObject;
        }
        return jSONObject;
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i = this.bindValueCount + 1;
        this.bindValueCount = i;
        sQLiteStatement.bindLong(i, this.f75id);
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        String str = this.url;
        if (str == null) {
            str = "";
        }
        sQLiteStatement.bindString(i2, str);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        String str2 = this.savePath;
        if (str2 == null) {
            str2 = "";
        }
        sQLiteStatement.bindString(i3, str2);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        String str3 = this.tempPath;
        if (str3 == null) {
            str3 = "";
        }
        sQLiteStatement.bindString(i4, str3);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        String str4 = this.name;
        if (str4 == null) {
            str4 = "";
        }
        sQLiteStatement.bindString(i5, str4);
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.chunkCount);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, getStatus());
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getCurBytes());
        int i9 = this.bindValueCount + 1;
        this.bindValueCount = i9;
        sQLiteStatement.bindLong(i9, this.totalBytes);
        int i10 = this.bindValueCount + 1;
        this.bindValueCount = i10;
        String str5 = this.eTag;
        if (str5 == null) {
            str5 = "";
        }
        sQLiteStatement.bindString(i10, str5);
        int i11 = this.bindValueCount + 1;
        this.bindValueCount = i11;
        sQLiteStatement.bindLong(i11, this.onlyWifi ? 1L : 0L);
        int i12 = this.bindValueCount + 1;
        this.bindValueCount = i12;
        sQLiteStatement.bindLong(i12, this.force ? 1L : 0L);
        int i13 = this.bindValueCount + 1;
        this.bindValueCount = i13;
        sQLiteStatement.bindLong(i13, this.retryCount);
        int i14 = this.bindValueCount + 1;
        this.bindValueCount = i14;
        String str6 = this.extra;
        if (str6 == null) {
            str6 = "";
        }
        sQLiteStatement.bindString(i14, str6);
        int i15 = this.bindValueCount + 1;
        this.bindValueCount = i15;
        String str7 = this.mimeType;
        if (str7 == null) {
            str7 = "";
        }
        sQLiteStatement.bindString(i15, str7);
        int i16 = this.bindValueCount + 1;
        this.bindValueCount = i16;
        String str8 = this.title;
        if (str8 == null) {
            str8 = "";
        }
        sQLiteStatement.bindString(i16, str8);
        int i17 = this.bindValueCount + 1;
        this.bindValueCount = i17;
        sQLiteStatement.bindLong(i17, this.showNotification ? 1L : 0L);
        int i18 = this.bindValueCount + 1;
        this.bindValueCount = i18;
        sQLiteStatement.bindLong(i18, this.notificationVisibility);
        int i19 = this.bindValueCount + 1;
        this.bindValueCount = i19;
        sQLiteStatement.bindLong(i19, this.isFirstDownload ? 1L : 0L);
        int i20 = this.bindValueCount + 1;
        this.bindValueCount = i20;
        sQLiteStatement.bindLong(i20, this.isFirstSuccess ? 1L : 0L);
        int i21 = this.bindValueCount + 1;
        this.bindValueCount = i21;
        sQLiteStatement.bindLong(i21, this.needHttpsToHttpRetry ? 1L : 0L);
        int i22 = this.bindValueCount + 1;
        this.bindValueCount = i22;
        sQLiteStatement.bindLong(i22, this.downloadTime);
        int i23 = this.bindValueCount + 1;
        this.bindValueCount = i23;
        String str9 = this.packageName;
        if (str9 == null) {
            str9 = "";
        }
        sQLiteStatement.bindString(i23, str9);
        int i24 = this.bindValueCount + 1;
        this.bindValueCount = i24;
        String str10 = this.md5;
        if (str10 == null) {
            str10 = "";
        }
        sQLiteStatement.bindString(i24, str10);
        int i25 = this.bindValueCount + 1;
        this.bindValueCount = i25;
        sQLiteStatement.bindLong(i25, 0L);
        int i26 = this.bindValueCount + 1;
        this.bindValueCount = i26;
        sQLiteStatement.bindLong(i26, this.curRetryTime);
        int i27 = this.bindValueCount + 1;
        this.bindValueCount = i27;
        sQLiteStatement.bindLong(i27, 0L);
        int i28 = this.bindValueCount + 1;
        this.bindValueCount = i28;
        sQLiteStatement.bindLong(i28, this.needDefaultHttpServiceBackUp ? 1L : 0L);
        int i29 = this.bindValueCount + 1;
        this.bindValueCount = i29;
        sQLiteStatement.bindLong(i29, 0L);
        int i30 = this.bindValueCount + 1;
        this.bindValueCount = i30;
        sQLiteStatement.bindString(i30, "");
        int i31 = this.bindValueCount + 1;
        this.bindValueCount = i31;
        sQLiteStatement.bindLong(i31, 0L);
        int i32 = this.bindValueCount + 1;
        this.bindValueCount = i32;
        sQLiteStatement.bindString(i32, getBackUpUrlsStr());
        int i33 = this.bindValueCount + 1;
        this.bindValueCount = i33;
        sQLiteStatement.bindLong(i33, this.backUpUrlRetryCount);
        int i34 = this.bindValueCount + 1;
        this.bindValueCount = i34;
        sQLiteStatement.bindLong(i34, this.realDownloadTime);
        int i35 = this.bindValueCount + 1;
        this.bindValueCount = i35;
        sQLiteStatement.bindLong(i35, 0L);
        int i36 = this.bindValueCount + 1;
        this.bindValueCount = i36;
        sQLiteStatement.bindLong(i36, this.needIndependentProcess ? 1L : 0L);
        int i37 = this.bindValueCount + 1;
        this.bindValueCount = i37;
        sQLiteStatement.bindString(i37, getDBJsonDataString());
        int i38 = this.bindValueCount + 1;
        this.bindValueCount = i38;
        String str11 = this.iconUrl;
        if (str11 == null) {
            str11 = "";
        }
        sQLiteStatement.bindString(i38, str11);
        int i39 = this.bindValueCount + 1;
        this.bindValueCount = i39;
        sQLiteStatement.bindLong(i39, this.appVersionCode);
        int i40 = this.bindValueCount + 1;
        this.bindValueCount = i40;
        sQLiteStatement.bindString(i40, "");
        int i41 = this.bindValueCount + 1;
        this.bindValueCount = i41;
        sQLiteStatement.bindLong(i41, this.downloadStartTimeStamp);
        int i42 = this.bindValueCount + 1;
        this.bindValueCount = i42;
        sQLiteStatement.bindLong(i42, this.downloadFinishTimeStamp);
        int i43 = this.bindValueCount + 1;
        this.bindValueCount = i43;
        sQLiteStatement.bindLong(i43, this.installedTimeStamp);
        int i44 = this.bindValueCount + 1;
        this.bindValueCount = i44;
        sQLiteStatement.bindLong(i44, this.hasDoInstallation ? 1L : 0L);
        int i45 = this.bindValueCount + 1;
        this.bindValueCount = i45;
        sQLiteStatement.bindLong(i45, this.cacheLifeTimeMax);
        int i46 = this.bindValueCount + 1;
        this.bindValueCount = i46;
        sQLiteStatement.bindString(i46, getPcdnUrlsStr());
        int i47 = this.bindValueCount + 1;
        this.bindValueCount = i47;
        sQLiteStatement.bindString(i47, getCdnUrlsStr());
        int i48 = this.bindValueCount + 1;
        this.bindValueCount = i48;
        sQLiteStatement.bindLong(i48, getBackCurBytes());
        int i49 = this.bindValueCount + 1;
        this.bindValueCount = i49;
        sQLiteStatement.bindLong(i49, this.realBackDownloadTime);
        int i50 = this.bindValueCount + 1;
        this.bindValueCount = i50;
        String str12 = this.monitorScene;
        sQLiteStatement.bindString(i50, str12 != null ? str12 : "");
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getId() {
        if (this.f75id == 0) {
            this.f75id = ((IDownloadIdGeneratorService) DownloadServiceManager.getService(IDownloadIdGeneratorService.class)).generate(this);
        }
        return this.f75id;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        if (TextUtils.isEmpty(this.title)) {
            return this.name;
        }
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getTempPath() {
        return DownloadUtils.getTempFileSavePath(this.savePath, this.tempPath);
    }

    public String getTempName() {
        return DownloadUtils.getTempFileName(this.name);
    }

    public String getTargetFilePath() {
        return DownloadUtils.getTargetFilePath(this.savePath, this.name);
    }

    public String getTempFilePath() {
        return DownloadUtils.getTempFilePath(this.savePath, this.tempPath, this.name);
    }

    public int getDBInitStatus() {
        return this.mDBInitStatus;
    }

    public void setDBInitStatus(int i) {
        this.mDBInitStatus = i;
    }

    public long getStartOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_START_OFFSET);
    }

    public long getEndOffset() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_END_OFFSET, -1L);
    }

    public boolean isNeedDefaultHttpServiceBackUp() {
        return this.needDefaultHttpServiceBackUp;
    }

    public int getStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger == null) {
            return 0;
        }
        int i = atomicInteger.get();
        if (i == -5) {
            return -2;
        }
        return i;
    }

    public EnqueueType getEnqueueType() {
        return this.enqueueType;
    }

    public int getCurBackUpUrlIndex() {
        return this.curBackUpUrlIndex;
    }

    public boolean isHttpsToHttpRetryUsed() {
        return this.httpsToHttpRetryUsed;
    }

    public boolean isAutoResumed() {
        return this.autoResumed;
    }

    public void setAutoResumed(boolean z) {
        this.autoResumed = z;
    }

    public boolean isShowNotificationForAutoResumed() {
        return this.showNotificationForAutoResumed;
    }

    public void setShowNotificationForAutoResumed(boolean z) {
        this.showNotificationForAutoResumed = z;
    }

    public boolean isShowNotificationForNetworkResumed() {
        return this.showNotificationForNetworkResumed;
    }

    public void setShowNotificationForNetworkResumed(boolean z) {
        this.showNotificationForNetworkResumed = z;
    }

    public int getRealStatus() {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            return atomicInteger.get();
        }
        return 0;
    }

    public boolean isOnlyWifi() {
        return this.onlyWifi;
    }

    public void setOnlyWifi(boolean z) {
        this.onlyWifi = z;
    }

    public long getFirstSpeedTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME);
    }

    public void setFirstSpeedTime(long j) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_FIRST_SPEED_TIME, Long.valueOf(j));
    }

    public String getTaskKey() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_TASK_KEY);
    }

    public int getTTMd5CheckStatus() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, -1);
    }

    public void setTTMd5CheckStatus(int i) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_TTMD5_CHECK_STATUS, Integer.valueOf(i));
    }

    public long getAllConnectTime() {
        ensureDBJsonData();
        if (this.allConnectTime == null) {
            this.allConnectTime = new AtomicLong(this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME));
        }
        return this.allConnectTime.get();
    }

    public void increaseAllConnectTime(long j) {
        if (j > 0) {
            getAllConnectTime();
            safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ALL_CONNECT_TIME, Long.valueOf(this.allConnectTime.addAndGet(j)));
        }
    }

    public long getDownloadPrepareTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME);
    }

    public void increaseDownloadPrepareTime(long j) {
        if (this.fastDownload) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (currentTimeMillis > 0) {
            safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_DOWNLOAD_PREPARE_TIME, Long.valueOf(getDownloadPrepareTime() + currentTimeMillis));
        }
    }

    public String getExtra() {
        return this.extra;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getFilePackageName() {
        return this.filePackageName;
    }

    public void setFilePackageName(String str) {
        this.filePackageName = str;
    }

    public String getMd5() {
        return this.md5;
    }

    public long getExpectFileLength() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_EXPECT_FILE_LENGTH);
    }

    public List<HttpHeader> getExtraHeaders() {
        return this.extraHeaders;
    }

    public int getMaxBytes() {
        return this.maxBytes;
    }

    public String[] getOutIp() {
        return this.outIp;
    }

    public int[] getOutSize() {
        return this.outSize;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public void setRetryCount(int i) {
        this.retryCount = i;
    }

    public int getBackUpUrlRetryCount() {
        return this.backUpUrlRetryCount;
    }

    public int getTotalRetryCount() {
        int i = this.retryCount;
        List<String> list = this.backUpUrls;
        return (list == null || list.isEmpty()) ? i : i + (this.backUpUrlRetryCount * this.backUpUrls.size());
    }

    public int getCurRetryTimeInTotal() {
        int i = this.curRetryTime;
        if (!this.backUpUrlUsed) {
            return i;
        }
        int i2 = i + this.retryCount;
        int i3 = this.curBackUpUrlIndex;
        return i3 > 0 ? i2 + (i3 * this.backUpUrlRetryCount) : i2;
    }

    public List<String> getForbiddenBackupUrls() {
        return this.forbiddenBackupUrls;
    }

    public void setForbiddenBackupUrls(List<String> list, boolean z) {
        this.forbiddenBackupUrls = list;
        refreshBackupUrls(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void refreshBackupUrls(boolean z) {
        List<String> list = this.forbiddenBackupUrls;
        if (list == null || list.size() <= z) {
            return;
        }
        List<String> list2 = this.backUpUrls;
        if (list2 == null) {
            this.backUpUrls = new ArrayList();
        } else {
            list2.clear();
        }
        this.backUpUrlUsed = false;
        this.curBackUpUrlIndex = 0;
        for (int i = z; i < this.forbiddenBackupUrls.size(); i++) {
            this.backUpUrls.add(this.forbiddenBackupUrls.get(i));
        }
    }

    public String getConnectionUrl() {
        List<String> list;
        int i;
        List<String> list2;
        String str = this.url;
        if (getStatus() == 8 && (list2 = this.forbiddenBackupUrls) != null && !list2.isEmpty() && !this.backUpUrlUsed) {
            return this.forbiddenBackupUrls.get(0);
        }
        if (!this.backUpUrlUsed || (list = this.backUpUrls) == null || list.size() <= 0 || (i = this.curBackUpUrlIndex) < 0 || i >= this.backUpUrls.size()) {
            return (!TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && this.httpsToHttpRetryUsed) ? this.url.replaceFirst("https", ImageDelegate.HTTP_PREFIX) : str;
        }
        String str2 = this.backUpUrls.get(this.curBackUpUrlIndex);
        return !TextUtils.isEmpty(str2) ? str2 : str;
    }

    public boolean isBackUpUrlUsed() {
        return this.backUpUrlUsed;
    }

    public String getBackUpUrl() {
        List<String> list;
        int i;
        if (this.backUpUrlUsed && (list = this.backUpUrls) != null && list.size() > 0 && (i = this.curBackUpUrlIndex) >= 0 && i < this.backUpUrls.size()) {
            String str = this.backUpUrls.get(this.curBackUpUrlIndex);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public boolean isFastDownload() {
        return this.fastDownload;
    }

    public boolean isHandleRequest() {
        return this.handleRequest;
    }

    public void updateStartDownloadTime() {
        this.startDownloadTime = SystemClock.uptimeMillis();
        if (this.fastDownload) {
            return;
        }
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, Long.valueOf(System.currentTimeMillis()));
    }

    public void safePutToDBJsonData(String str, Object obj) {
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                this.dbJsonData.put(str, obj);
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
    }

    private void unsafePutToDBJsonData(String str, Object obj) {
        try {
            this.dbJsonData.put(str, obj);
        } catch (Exception unused) {
        }
    }

    public String getDownloadSettingString() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DOWNLOAD_SETTING);
    }

    public int getRetryScheduleCount() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.RETRY_SCHEDULE_COUNT, 0);
    }

    public void setRetryScheduleCount(int i) {
        safePutToDBJsonData(DbJsonConstants.RETRY_SCHEDULE_COUNT, Integer.valueOf(i));
    }

    public boolean isDownloadFromReserveWifi() {
        return this.mDownloadFromReserveWifi;
    }

    public void setDownloadFromReserveWifi(boolean z) {
        this.mDownloadFromReserveWifi = z;
    }

    public int getLinkMode() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_LINK_MODE);
    }

    public void setLinkMode(int i) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_LINK_MODE, Integer.valueOf(i));
    }

    public boolean isPauseReserveOnWifi() {
        return (getReserveWifiStatus() & 2) > 0;
    }

    public boolean hasPauseReservedOnWifi() {
        return (getReserveWifiStatus() & 1) > 0;
    }

    public boolean statusInPause() {
        return getRealStatus() == -2 || getRealStatus() == -5;
    }

    private int getReserveWifiStatus() {
        ensureSpData();
        try {
            return this.spData.optInt(SpJsonConstants.PAUSE_RESERVE_ON_WIFI, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public void startPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.PAUSE_RESERVE_ON_WIFI, 3);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void stopPauseReserveOnWifi() {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.PAUSE_RESERVE_ON_WIFI, 1);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public void setCacheExpiredTime(long j) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, j);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public long getCacheExpiredTime() {
        ensureSpData();
        try {
            return this.spData.optLong(SpJsonConstants.CACHE_CONTROL_EXPIRED_TIME, -1L);
        } catch (Exception unused) {
            return -1L;
        }
    }

    public void setLastModified(String str) {
        ensureSpData();
        try {
            this.spData.put("last-modified", str);
            updateSpData();
        } catch (Exception unused) {
        }
    }

    public String getLastModified() {
        ensureSpData();
        try {
            return this.spData.optString("last-modified", null);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean isCacheExistsInDownloading() {
        return this.isCacheExistsInDownloading;
    }

    public void setCacheExistsInDownloading(boolean z) {
        this.isCacheExistsInDownloading = z;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public void setContentEncoding(String str) {
        this.contentEncoding = str;
    }

    public boolean isNeedSDKMonitor() {
        return this.needSDKMonitor;
    }

    public String getMonitorScene() {
        return this.monitorScene;
    }

    public int[] getExtraMonitorStatus() {
        return this.extraMonitorStatus;
    }

    public void updateDownloadTime() {
        if (this.startDownloadTime == 0) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.startDownloadTime;
        if (this.downloadTime < 0) {
            this.downloadTime = 0L;
        }
        if (uptimeMillis > 0) {
            this.downloadTime = uptimeMillis;
        }
    }

    public void updateRealStartDownloadTime() {
        if (this.realStartDownloadTime == 0) {
            this.realStartDownloadTime = System.nanoTime();
        }
    }

    public void resetRealStartDownloadTime() {
        this.realStartDownloadTime = 0L;
    }

    public void updateRealDownloadTime(boolean z) {
        long nanoTime = System.nanoTime();
        long j = this.realStartDownloadTime;
        if (j <= 0) {
            if (z) {
                this.realStartDownloadTime = nanoTime;
                return;
            }
            return;
        }
        long j2 = nanoTime - j;
        if (z) {
            this.realStartDownloadTime = nanoTime;
        } else {
            this.realStartDownloadTime = 0L;
        }
        if (j2 > 0) {
            this.realDownloadTime += j2;
            if (this.fastDownload || !AppStatusManager.getInstance().isAppBackground()) {
                return;
            }
            this.realBackDownloadTime += j2;
        }
    }

    public boolean isNeedIndependentProcess() {
        return this.needIndependentProcess;
    }

    public boolean isNeedCurrentProcess() {
        return this.needCurrentProcess;
    }

    public boolean isDeleteCacheIfCheckFailed() {
        return this.deleteCacheIfCheckFailed;
    }

    public void setDeleteCacheIfCheckFailed() {
        this.deleteCacheIfCheckFailed = true;
    }

    public boolean isIgnoreDataVerify() {
        return this.ignoreDataVerify;
    }

    public void setIgnoreDataVerify(boolean z) {
        this.ignoreDataVerify = z;
    }

    public boolean isAddListenerToSameTask() {
        return this.addListenerToSameTask;
    }

    public boolean isForce() {
        return this.force;
    }

    public boolean isExpiredRedownload() {
        return this.expiredRedownload;
    }

    public boolean isExpiredHttpCheck() {
        return this.expiredHttpCheck;
    }

    public boolean isIgnoreInterceptor() {
        if (this.ignoreInterceptor == null) {
            ensureDBJsonData();
            this.ignoreInterceptor = Boolean.valueOf(this.dbJsonData.optInt(DbJsonConstants.IGNORE_INTERCEPT, 0) == 1);
        }
        return this.ignoreInterceptor.booleanValue();
    }

    public void setInterceptFlag(int i) {
        this.interceptFlag = i;
    }

    public int getInterceptFlag() {
        return this.interceptFlag;
    }

    public boolean isSuccessByCache() {
        return this.successByCache;
    }

    public void setSuccessByCache(boolean z) {
        this.successByCache = z;
    }

    public long getCurBytes() {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long getBackCurBytes() {
        AtomicLong atomicLong = this.backCurBytes;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public void setCurBytes(long j) {
        AtomicLong atomicLong = this.curBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.curBytes = new AtomicLong(j);
        }
    }

    public void setBackCurBytes(long j) {
        AtomicLong atomicLong = this.backCurBytes;
        if (atomicLong != null) {
            atomicLong.set(j);
        } else {
            this.backCurBytes = new AtomicLong(j);
        }
    }

    public void setCurBytes(long j, boolean z) {
        if (z) {
            setCurBytes(j);
        } else if (j > getCurBytes()) {
            setCurBytes(j);
        }
    }

    public ByteInvalidRetryStatus getByteInvalidRetryStatus() {
        return this.byteInvalidRetryStatus;
    }

    public void setByteInvalidRetryStatus(ByteInvalidRetryStatus byteInvalidRetryStatus) {
        this.byteInvalidRetryStatus = byteInvalidRetryStatus;
    }

    public void setFirstDownload(boolean z) {
        this.isFirstDownload = z;
    }

    public void setFirstSuccess(boolean z) {
        this.isFirstSuccess = z;
    }

    public void increaseCurBytes(long j) {
        this.curBytes.addAndGet(j);
        if (this.fastDownload || !AppStatusManager.getInstance().isAppBackground()) {
            return;
        }
        this.backCurBytes.addAndGet(j);
    }

    public void seteTag(String str) {
        this.eTag = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public void setXTotalBytes(long j) {
        this.xTotalBytes = j;
    }

    public void setStatus(int i) {
        AtomicInteger atomicInteger = this.status;
        if (atomicInteger != null) {
            atomicInteger.set(i);
        } else {
            this.status = new AtomicInteger(i);
        }
    }

    public void setSupportPartial(boolean z) {
        this.supportPartial = z;
    }

    public void setExtra(String str) {
        this.extra = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public long getXTotalBytes() {
        return this.xTotalBytes;
    }

    public String geteTag() {
        return this.eTag;
    }

    public String getNetworkQuality() {
        return this.networkQuality;
    }

    public void setNetworkQuality(String str) {
        this.networkQuality = str;
    }

    public void setChunkCount(int i) {
        this.chunkCount = i;
    }

    public int getNotificationVisibility() {
        return this.notificationVisibility;
    }

    public void setNotificationVisibility(int i) {
        this.notificationVisibility = i;
    }

    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }

    public void setHttpStatusCode(int i) {
        this.httpStatusCode = i;
    }

    public String getHttpStatusMessage() {
        return this.httpStatusMessage;
    }

    public void setHttpStatusMessage(String str) {
        this.httpStatusMessage = str;
    }

    public String getHttpRequestHeader() {
        return this.httpRequestHeader;
    }

    public void setHttpRequestHeader(String str) {
        this.httpRequestHeader = str;
    }

    public String getHttpResponseHeader() {
        return this.httpResponseHeader;
    }

    public void setHttpResponseHeader(String str) {
        this.httpResponseHeader = str;
    }

    public String getRequestLog() {
        return this.requestLog;
    }

    public void setRequestLog(String str) {
        this.requestLog = str;
    }

    public long getVerifyCurBytes() {
        return this.verifyCurBytes;
    }

    public void setVerifyCurBytes(long j) {
        this.verifyCurBytes = j;
    }

    public List<String> getAccessHttpHeaderKeys() {
        return this.accessHttpHeaderKeys;
    }

    public void setHttpHeaders(Map<String, String> map) {
        this.httpHeaders = map;
    }

    public Map<String, String> getHttpHeaders() {
        return this.httpHeaders;
    }

    public boolean canShowNotification() {
        boolean z = this.autoResumed;
        return (!z && this.showNotification) || (z && (this.showNotificationForAutoResumed || this.showNotificationForNetworkResumed));
    }

    public void setShowNotification(boolean z) {
        this.showNotification = z;
    }

    public boolean isShowNotification() {
        return this.showNotification;
    }

    public boolean isAutoInstallWithoutNotification() {
        if (this.isAutoInstallWithoutNotification == null) {
            if (!TextUtils.isEmpty(this.extra)) {
                try {
                    this.isAutoInstallWithoutNotification = Boolean.valueOf(new JSONObject(this.extra).optBoolean(DownloadConstants.AUTO_INSTALL_WITHOUT_NOTIFICATION, false));
                } catch (JSONException unused) {
                    this.isAutoInstallWithoutNotification = false;
                }
            } else {
                this.isAutoInstallWithoutNotification = false;
            }
        }
        return this.isAutoInstallWithoutNotification.booleanValue();
    }

    public void setPauseByNotification(boolean z) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(this.extra)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(this.extra);
            }
            jSONObject.put(DownloadConstants.PAUSE_BY_NOTIFICATION, z);
            this.extra = jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean isPauseByNotification() {
        if (TextUtils.isEmpty(this.extra)) {
            return false;
        }
        try {
            return new JSONObject(this.extra).optBoolean(DownloadConstants.PAUSE_BY_NOTIFICATION);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isAutoInstall() {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.AUTO_INSTALL, 1) == 1;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public boolean isNeedHttpsToHttpRetry() {
        return this.needHttpsToHttpRetry;
    }

    public int getCurRetryTime() {
        return this.curRetryTime;
    }

    public boolean isForbiddenRetryed() {
        return this.isForbiddenRetryed;
    }

    public void setForbiddenRetryed() {
        this.isForbiddenRetryed = true;
    }

    public void setIconUrl(String str) {
        this.iconUrl = str;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public void setAppVersionCode(int i) {
        this.appVersionCode = i;
    }

    public int getAppVersionCode() {
        return this.appVersionCode;
    }

    public AsyncHandleStatus getAsyncHandleStatus() {
        return this.asyncHandleStatus;
    }

    public boolean canSkipStatusHandler() {
        return getStatus() == 8 || this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_RESTART || this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART;
    }

    public void changeSkipStatus() {
        if (getStatus() == 8 || this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING || this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_RESTART) {
            setAsyncHandleStatus(AsyncHandleStatus.ASYNC_HANDLE_DOWNLOADING);
        }
        if (this.byteInvalidRetryStatus == ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_RESTART) {
            setByteInvalidRetryStatus(ByteInvalidRetryStatus.BYTE_INVALID_RETRY_STATUS_DOWNLOADING);
        }
    }

    public boolean canReStartAsyncTask() {
        return getStatus() != -3 && this.asyncHandleStatus == AsyncHandleStatus.ASYNC_HANDLE_WAITING;
    }

    public void setAsyncHandleStatus(AsyncHandleStatus asyncHandleStatus) {
        this.asyncHandleStatus = asyncHandleStatus;
    }

    public void updateCurRetryTime(int i) {
        int i2 = (this.backUpUrlUsed ? this.backUpUrlRetryCount : this.retryCount) - i;
        this.curRetryTime = i2;
        if (i2 < 0) {
            this.curRetryTime = 0;
        }
    }

    public long getDownloadTime() {
        return this.downloadTime;
    }

    public long getRealDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realDownloadTime);
    }

    public long getRealBackDownloadTime() {
        return TimeUnit.NANOSECONDS.toMillis(this.realBackDownloadTime);
    }

    public void copyFromCacheData(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        setChunkCount(downloadInfo.getChunkCount());
        setTotalBytes(downloadInfo.getTotalBytes());
        setCurBytes(downloadInfo.getCurBytes(), true);
        setBackCurBytes(downloadInfo.getBackCurBytes());
        this.realDownloadTime = downloadInfo.realDownloadTime;
        this.realBackDownloadTime = downloadInfo.realBackDownloadTime;
        if (!downloadInfo.canSkipStatusHandler() && !canSkipStatusHandler()) {
            this.curRetryTime = 0;
            this.isForbiddenRetryed = false;
            this.backUpUrlUsed = false;
            this.curBackUpUrlIndex = 0;
            this.httpsToHttpRetryUsed = false;
        } else {
            this.curRetryTime = downloadInfo.getCurRetryTime();
        }
        seteTag(downloadInfo.geteTag());
        setMimeType(downloadInfo.getMimeType());
        if (z) {
            setStatus(downloadInfo.getStatus());
        }
        this.isFirstDownload = downloadInfo.getIsFirstDownload();
        this.isFirstSuccess = downloadInfo.isFirstSuccess();
        this.downloadStartTimeStamp = downloadInfo.getDownloadStartTimeStamp();
        this.downloadFinishTimeStamp = downloadInfo.getDownloadFinishTimeStamp();
        this.installedTimeStamp = downloadInfo.getInstalledTimeStamp();
        this.hasDoInstallation = downloadInfo.hasDoInstallation;
        mergeAuxiliaryJSONObject(downloadInfo.dbJsonData);
    }

    private void ensureDBJsonData() {
        if (this.dbJsonData == null) {
            synchronized (this) {
                if (this.dbJsonData == null) {
                    try {
                        if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                            this.dbJsonData = new JSONObject(this.dbJsonDataString);
                            this.dbJsonDataString = null;
                        } else {
                            this.dbJsonData = new JSONObject();
                        }
                    } catch (Throwable unused) {
                        this.dbJsonData = new JSONObject();
                    }
                }
            }
        }
    }

    public void unsafeEnsureDBJsonData() {
        if (this.dbJsonData != null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(this.dbJsonDataString)) {
                this.dbJsonData = new JSONObject(this.dbJsonDataString);
            } else {
                this.dbJsonData = new JSONObject();
            }
        } catch (Throwable unused) {
            this.dbJsonData = new JSONObject();
        }
        this.dbJsonDataString = null;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    private void mergeAuxiliaryJSONObject(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ensureDBJsonData();
        synchronized (this.dbJsonData) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (!this.dbJsonData.has(next) && opt != null) {
                        this.dbJsonData.put(next, opt);
                    }
                }
            } catch (Exception unused) {
            }
            this.dbJsonDataString = null;
        }
        parseMonitorSetting();
    }

    public boolean getIsFirstDownload() {
        return this.isFirstDownload;
    }

    public boolean isFirstSuccess() {
        return this.isFirstSuccess;
    }

    public boolean equalsTask(DownloadInfo downloadInfo) {
        String str;
        String str2;
        return (downloadInfo == null || (str = this.url) == null || !str.equals(downloadInfo.getUrl()) || (str2 = this.savePath) == null || !str2.equals(downloadInfo.getSavePath())) ? false : true;
    }

    public void setId(int i) {
        this.f75id = i;
    }

    public boolean isDownloadWithWifiValid() {
        return !isOnlyWifi() || DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
    }

    public boolean isPauseReserveWithWifiValid() {
        if (this.mDownloadFromReserveWifi) {
            return isPauseReserveOnWifi() && DownloadUtils.isWifi(((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext());
        }
        return true;
    }

    public boolean isDownloadingStatus() {
        return DownloadStatus.isDownloading(getStatus());
    }

    public boolean isDownloadOverStatus() {
        return DownloadStatus.isDownloadOver(getStatus());
    }

    public List<String> getBackUpUrls() {
        return this.backUpUrls;
    }

    public List<String> getPcdnUrls() {
        return this.pcdnUrls;
    }

    public List<String> getCdnUrls() {
        return this.cdnUrls;
    }

    public boolean isChunked() {
        return DownloadUtils.isChunkedTask(this.totalBytes);
    }

    public boolean isNeedPostProgress() {
        return this.needPostProgress;
    }

    public int getMaxProgressCount() {
        return this.maxProgressCount;
    }

    public long getMinByteIntervalForPostToMainThread(long j) {
        int i = this.maxProgressCount;
        if (i <= 0) {
            i = 100;
        }
        long j2 = j / (i + 1);
        if (j2 <= 0) {
            return 1048576L;
        }
        return j2;
    }

    public int getMinProgressTimeMsInterval() {
        int i = this.minProgressTimeMsInterval;
        if (i < 1000) {
            return 1000;
        }
        return i;
    }

    public boolean isEntityInvalid() {
        return TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.savePath);
    }

    public boolean isDownloaded() {
        return DownloadUtils.isFileDownloaded(this);
    }

    public boolean trySwitchToNextBackupUrl() {
        if (this.backUpUrlUsed) {
            this.curBackUpUrlIndex++;
        }
        List<String> list = this.backUpUrls;
        if (list != null && list.size() != 0 && this.curBackUpUrlIndex >= 0) {
            while (this.curBackUpUrlIndex < this.backUpUrls.size()) {
                if (!TextUtils.isEmpty(this.backUpUrls.get(this.curBackUpUrlIndex))) {
                    this.backUpUrlUsed = true;
                    return true;
                }
                this.curBackUpUrlIndex++;
            }
        }
        return false;
    }

    public boolean hasNextBackupUrl() {
        List<String> list = this.backUpUrls;
        if (list != null && list.size() > 0) {
            if (!this.backUpUrlUsed) {
                return true;
            }
            int i = this.curBackUpUrlIndex;
            if (i >= 0 && i < this.backUpUrls.size() - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canReplaceHttpForRetry() {
        return !TextUtils.isEmpty(this.url) && this.url.startsWith("https") && this.needHttpsToHttpRetry && !this.httpsToHttpRetryUsed;
    }

    public void setHttpsToHttpRetryUsed(boolean z) {
        this.httpsToHttpRetryUsed = z;
    }

    public void setSavePath(String str) {
        this.savePath = str;
    }

    public int getCurNetworkRetryCount() {
        return this.curNetworkRetryCount;
    }

    public void setCurNetworkRetryCount(int i) {
        this.curNetworkRetryCount = i;
    }

    public void resetDataForEtagEndure(String str) {
        setCurBytes(0L, true);
        setBackCurBytes(0L);
        setTotalBytes(0L);
        seteTag(str);
        setChunkCount(1);
        setLastModified(null);
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.realBackDownloadTime = 0L;
    }

    public void reset() {
        setCurBytes(0L, true);
        setBackCurBytes(0L);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.realBackDownloadTime = 0L;
    }

    public void erase() {
        setCurBytes(0L, true);
        setBackCurBytes(0L);
        this.totalBytes = 0L;
        this.chunkCount = 1;
        this.downloadTime = 0L;
        this.realStartDownloadTime = 0L;
        this.realDownloadTime = 0L;
        this.realBackDownloadTime = 0L;
        this.curRetryTime = 0;
        this.isFirstDownload = true;
        this.isFirstSuccess = true;
        this.backUpUrlUsed = false;
        this.httpsToHttpRetryUsed = false;
        this.eTag = null;
        this.failedException = null;
        this.tempCacheData = null;
        this.packageInfoRef = null;
    }

    public boolean isFileDataValid() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        boolean isDirectory = file.isDirectory();
        if (Logger.debugScene(this)) {
            Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + file + "IsExists:" + exists + " isDirectory: " + isDirectory);
        }
        if (exists && !isDirectory) {
            long length = file.length();
            long curBytes = getCurBytes();
            if (curBytes > 0) {
                long j = this.totalBytes;
                if (j > 0 && this.chunkCount > 0 && length >= curBytes && length <= j) {
                    if (!Logger.debugScene(this)) {
                        return true;
                    }
                    Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + length + " curBytes:" + curBytes);
                    return true;
                }
            }
            if (Logger.debugScene(this)) {
                Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length + ", chunkCount:" + this.chunkCount);
            }
        }
        return false;
    }

    public boolean isFileDataValidOptimize() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        boolean exists = file.exists();
        if (!exists) {
            if (Logger.debugScene(this)) {
                Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + file + "IsExists:" + exists);
            }
            return false;
        }
        boolean isDirectory = file.isDirectory();
        if (isDirectory) {
            if (Logger.debugScene(this)) {
                Logger.taskDebug(TAG, this, "isFileDataValid", "Temp file:" + file + "IsDirectory:" + isDirectory);
            }
            return false;
        }
        long curBytes = getCurBytes();
        if (curBytes <= 0 || this.totalBytes <= 0 || this.chunkCount <= 0) {
            if (Logger.debugScene(this)) {
                Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + curBytes + ",totalBytes =" + this.totalBytes + ", chunkCount:" + this.chunkCount);
            }
            return false;
        }
        long length = file.length();
        if (length < curBytes || length > this.totalBytes) {
            if (Logger.debugScene(this)) {
                Logger.taskDebug(TAG, this, "isFileDataValid", "Invalid, Cur = " + curBytes + ",totalBytes =" + this.totalBytes + ",fileLength=" + length + ", chunkCount:" + this.chunkCount);
            }
            return false;
        }
        if (!Logger.debugScene(this)) {
            return true;
        }
        Logger.taskDebug(TAG, this, "isFileDataValid", "Valid, FileLength+" + length + " curBytes:" + curBytes);
        return true;
    }

    public boolean isFileDataExists() {
        if (isEntityInvalid()) {
            return false;
        }
        File file = new File(getTempPath(), getTempName());
        return file.exists() && !file.isDirectory();
    }

    public boolean isFirstDownload() {
        if (!this.isFirstDownload || TextUtils.isEmpty(getTempPath()) || TextUtils.isEmpty(getTempName())) {
            return false;
        }
        return !new File(getTempPath(), getTempName()).exists();
    }

    public boolean checkMd5Valid() {
        return DownloadUtils.checkMd5Valid(getSavePath(), getName(), this.md5);
    }

    public int checkMd5Status() {
        return DownloadUtils.checkMd5Status(new DownloadFile(getSavePath(), getName()), this.md5);
    }

    public boolean isCanResumeFromBreakPointStatus() {
        int status = getStatus();
        if (status == 4 || status == 3 || status == -1 || status == 5 || status == 8) {
            return true;
        }
        return (status == 1 || status == 2) && getCurBytes() > 0;
    }

    public boolean isNewTask() {
        return getStatus() == 0;
    }

    @Deprecated
    public int getChunkCount() {
        return this.chunkCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f75id);
        parcel.writeString(this.name);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeString(this.savePath);
        parcel.writeString(this.tempPath);
        parcel.writeByte(this.onlyWifi ? (byte) 1 : (byte) 0);
        parcel.writeString(this.extra);
        parcel.writeTypedList(this.extraHeaders);
        parcel.writeInt(this.maxBytes);
        parcel.writeStringArray(this.outIp);
        parcel.writeIntArray(this.outSize);
        parcel.writeInt(this.retryCount);
        parcel.writeInt(this.backUpUrlRetryCount);
        parcel.writeByte(this.force ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.needPostProgress ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.maxProgressCount);
        parcel.writeInt(this.minProgressTimeMsInterval);
        parcel.writeStringList(this.backUpUrls);
        parcel.writeByte(this.showNotification ? (byte) 1 : (byte) 0);
        parcel.writeString(this.mimeType);
        parcel.writeByte(this.needHttpsToHttpRetry ? (byte) 1 : (byte) 0);
        parcel.writeString(this.packageName);
        parcel.writeString(this.md5);
        parcel.writeByte(this.needDefaultHttpServiceBackUp ? (byte) 1 : (byte) 0);
        parcel.writeString(this.eTag);
        parcel.writeInt(this.curRetryTime);
        parcel.writeString(this.networkQuality);
        parcel.writeInt(this.curBackUpUrlIndex);
        parcel.writeInt(this.notificationVisibility);
        parcel.writeInt(this.chunkCount);
        parcel.writeLong(getCurBytes());
        parcel.writeLong(getBackCurBytes());
        parcel.writeLong(this.totalBytes);
        parcel.writeInt(getRealStatus());
        parcel.writeLong(this.downloadTime);
        parcel.writeLong(this.realDownloadTime);
        parcel.writeLong(this.realBackDownloadTime);
        parcel.writeByte(this.backUpUrlUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.httpsToHttpRetryUsed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.autoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForAutoResumed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.showNotificationForNetworkResumed ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.forbiddenBackupUrls);
        parcel.writeByte(this.needIndependentProcess ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.enqueueType.ordinal());
        parcel.writeInt(this.httpStatusCode);
        parcel.writeString(this.httpStatusMessage);
        parcel.writeByte(this.isForbiddenRetryed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.addListenerToSameTask ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.failedException, i);
        parcel.writeString(getDBJsonDataString());
        parcel.writeByte(this.supportPartial ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.appVersionCode);
        parcel.writeByte(this.expiredRedownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.deleteCacheIfCheckFailed ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.successByCache ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.expiredHttpCheck ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.xTotalBytes);
        parcel.writeInt(this.interceptFlag);
        parcel.writeStringList(this.accessHttpHeaderKeys);
        parcel.writeMap(this.httpHeaders);
        parcel.writeLong(this.downloadStartTimeStamp);
        parcel.writeLong(this.downloadFinishTimeStamp);
        parcel.writeLong(this.installedTimeStamp);
        parcel.writeByte(this.hasDoInstallation ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isCacheExistsInDownloading ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.cacheLifeTimeMax);
        parcel.writeStringList(this.pcdnUrls);
        parcel.writeStringList(this.cdnUrls);
        parcel.writeString(this.contentEncoding);
        parcel.writeByte(this.fastDownload ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.handleRequest ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.md5Time);
        parcel.writeString(this.httpRequestHeader);
        parcel.writeString(this.httpResponseHeader);
        parcel.writeString(this.requestLog);
        parcel.writeLong(this.verifyCurBytes);
        parcel.writeByte(this.needCurrentProcess ? (byte) 1 : (byte) 0);
        parcel.writeString(this.monitorScene);
    }

    public BaseException getFailedException() {
        return this.failedException;
    }

    public void setFailedException(BaseException baseException) {
        this.failedException = baseException;
    }

    private void ensureSpData() {
        if (this.spData == null) {
            Context appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext();
            if (appContext != null) {
                String string = appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).getString(Long.toString(getId()), "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        this.spData = new JSONObject(string);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (this.spData == null) {
                this.spData = new JSONObject();
            }
        }
    }

    public void updateSpData() {
        Context appContext;
        if (this.spData == null || (appContext = ((IDownloadComponentManagerService) DownloadServiceManager.getService(IDownloadComponentManagerService.class)).getAppContext()) == null) {
            return;
        }
        appContext.getSharedPreferences(DownloadConstants.SP_DOWNLOAD_INFO, 0).edit().putString(Integer.toString(getId()), this.spData.toString()).apply();
    }

    public int getFailedResumeCount() {
        ensureSpData();
        return this.spData.optInt(SpJsonConstants.KEY_FAILED_RESUME_COUNT, 0);
    }

    public void setFailedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_FAILED_RESUME_COUNT, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastFailedResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, 0L);
    }

    public void setLastFailedResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_LAST_FAILED_RESUME_TIME, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getUninstallResumeCount() {
        ensureSpData();
        return this.spData.optInt(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, 0);
    }

    public void setUninstallResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_UNINSTALL_RESUME_COUNT, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastUninstallResumeTime() {
        ensureSpData();
        return this.spData.optLong(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, 0L);
    }

    public void setLastUninstallResumeTime(long j) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_LAST_UNINSTALL_RESUME_TIME, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getSpStringVal(String str) {
        ensureSpData();
        return this.spData.optString(str, null);
    }

    public int getSpIntVal(String str) {
        ensureSpData();
        return this.spData.optInt(str, 0);
    }

    public long getSpLongVal(String str) {
        ensureSpData();
        return this.spData.optLong(str, 0L);
    }

    public void setSpValue(String str, String str2) {
        ensureSpData();
        try {
            this.spData.put(str, str2);
            updateSpData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getLastDownloadTime() {
        ensureDBJsonData();
        return this.dbJsonData.optLong(DbJsonConstants.DBJSON_KEY_LAST_START_DOWNLOAD_TIME, 0L);
    }

    public int getAntiHijackErrorCode(int i) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, i);
    }

    public void setAntiHijackErrorCode(int i) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_ANTI_HIJACK_ERROR_CODE, Integer.valueOf(i));
    }

    public boolean isSavePathRedirected() {
        ensureDBJsonData();
        return this.dbJsonData.optBoolean(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, false);
    }

    public void setSavePathRedirected(boolean z) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_IS_SAVE_PATH_REDIRECTED, Boolean.valueOf(z));
    }

    public void setInstallBizType(String str) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_INSTALL_BIZ_TYPE, str);
        } catch (Exception e) {
            Logger.taskError(TAG, this.f75id, "setInstallBizType", "Error:" + e);
        }
    }

    public String getInstallBizType() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_BIZ_TYPE);
    }

    public void setInstallCertId(String str) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_INSTALL_CERT_ID, str);
        } catch (Exception e) {
            Logger.taskError(TAG, this.f75id, "setInstallCertId", "Error:" + e);
        }
    }

    public String getInstallCertId() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_CERT_ID);
    }

    public void setInstallBizParamsJson(String str) {
        ensureSpData();
        try {
            this.spData.put(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON, str);
        } catch (Exception e) {
            Logger.taskError(TAG, this.f75id, "setInstallBizParamsJson", "Error:" + e);
        }
    }

    public String getInstallBizParamsJson() {
        ensureSpData();
        return this.spData.optString(SpJsonConstants.KEY_INSTALL_BIZ_PARAMS_JSON);
    }

    public long getMd5Time() {
        return this.md5Time;
    }

    public void setMd5Time(long j) {
        this.md5Time = j;
    }

    public String toString() {
        return "DownloadInfo{id=" + this.f75id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "'}";
    }

    public String toDetailString() {
        return "DownloadInfo{id=" + this.f75id + ", name='" + this.name + "', title='" + this.title + "', url='" + this.url + "', savePath='" + this.savePath + "', tempPath='" + this.tempPath + "', onlyWifi=" + this.onlyWifi + ", extra='" + this.extra + "', extraHeaders=" + this.extraHeaders + ", maxBytes=" + this.maxBytes + ", outIp=" + Arrays.toString(this.outIp) + ", outSize=" + Arrays.toString(this.outSize) + ", retryCount=" + this.retryCount + ", backUpUrlRetryCount=" + this.backUpUrlRetryCount + ", force=" + this.force + ", needPostProgress=" + this.needPostProgress + ", maxProgressCount=" + this.maxProgressCount + ", minProgressTimeMsInterval=" + this.minProgressTimeMsInterval + ", backUpUrls=" + this.backUpUrls + ", showNotification=" + this.showNotification + ", mimeType='" + this.mimeType + "', needHttpsToHttpRetry=" + this.needHttpsToHttpRetry + ", cacheLifeTimeMax=" + this.cacheLifeTimeMax + ", pcdnUrls=" + this.pcdnUrls + ", cdnUrls=" + this.cdnUrls + ", pcdnUrlsStr='" + this.pcdnUrlsStr + "', cdnUrlsStr='" + this.cdnUrlsStr + "', packageName='" + this.packageName + "', filePackageName='" + this.filePackageName + "', md5='" + this.md5 + "', allConnectTime=" + this.allConnectTime + ", needDefaultHttpServiceBackUp=" + this.needDefaultHttpServiceBackUp + ", eTag='" + this.eTag + "', curRetryTime=" + this.curRetryTime + ", asyncHandleStatus=" + this.asyncHandleStatus + ", ignoreDataVerify=" + this.ignoreDataVerify + ", needIndependentProcess=" + this.needIndependentProcess + ", needCurrentProcess=" + this.needCurrentProcess + ", supportPartial=" + this.supportPartial + ", iconUrl='" + this.iconUrl + "', curNetworkRetryCount=" + this.curNetworkRetryCount + ", needSDKMonitor=" + this.needSDKMonitor + ", monitorScene='" + this.monitorScene + "', extraMonitorStatus=" + Arrays.toString(this.extraMonitorStatus) + ", expiredRedownload=" + this.expiredRedownload + ", expiredHttpCheck=" + this.expiredHttpCheck + ", deleteCacheIfCheckFailed=" + this.deleteCacheIfCheckFailed + ", successByCache=" + this.successByCache + ", ignoreInterceptor=" + this.ignoreInterceptor + ", interceptFlag=" + this.interceptFlag + ", downloadStartTimeStamp=" + this.downloadStartTimeStamp + ", downloadFinishTimeStamp=" + this.downloadFinishTimeStamp + ", installedTimeStamp=" + this.installedTimeStamp + ", hasDoInstallation=" + this.hasDoInstallation + ", networkQuality='" + this.networkQuality + "', curBackUpUrlIndex=" + this.curBackUpUrlIndex + ", notificationVisibility=" + this.notificationVisibility + ", chunkCount=" + this.chunkCount + ", curBytes=" + this.curBytes + ", totalBytes=" + this.totalBytes + ", xTotalBytes=" + this.xTotalBytes + ", status=" + this.status + ", isFirstDownload=" + this.isFirstDownload + ", isFirstSuccess=" + this.isFirstSuccess + ", downloadTime=" + this.downloadTime + ", realDownloadTime=" + this.realDownloadTime + ", backUpUrlUsed=" + this.backUpUrlUsed + ", httpsToHttpRetryUsed=" + this.httpsToHttpRetryUsed + ", startDownloadTime=" + this.startDownloadTime + ", realStartDownloadTime=" + this.realStartDownloadTime + ", bindValueCount=" + this.bindValueCount + ", autoResumed=" + this.autoResumed + ", showNotificationForAutoResumed=" + this.showNotificationForAutoResumed + ", showNotificationForNetworkResumed=" + this.showNotificationForNetworkResumed + ", forbiddenBackupUrls=" + this.forbiddenBackupUrls + ", byteInvalidRetryStatus=" + this.byteInvalidRetryStatus + ", enqueueType=" + this.enqueueType + ", httpStatusCode=" + this.httpStatusCode + ", httpStatusMessage='" + this.httpStatusMessage + "', lastNotifyProgressTime=" + this.lastNotifyProgressTime + ", isForbiddenRetryed=" + this.isForbiddenRetryed + ", appVersionCode=" + this.appVersionCode + ", throttleNetSpeed=" + this.throttleNetSpeed + ", throttleSmoothness=" + this.throttleSmoothness + ", openLimitSpeed=" + this.openLimitSpeed + ", isCacheExistsInDownloading=" + this.isCacheExistsInDownloading + ", contentEncoding='" + this.contentEncoding + "', addListenerToSameTask=" + this.addListenerToSameTask + ", backUpUrlsStr='" + this.backUpUrlsStr + "', failedException=" + this.failedException + ", pcdnStats=" + this.pcdnStats + ", spData=" + this.spData + ", dbJsonData=" + this.dbJsonData + ", dbJsonDataString='" + this.dbJsonDataString + "', tempCacheData=" + this.tempCacheData + ", statusAtDbInit=" + this.statusAtDbInit + ", mDownloadFromReserveWifi=" + this.mDownloadFromReserveWifi + ", packageInfoRef=" + this.packageInfoRef + ", ttnetProtectTimeout=" + this.ttnetProtectTimeout + ", addTTNetCommonParam=" + this.addTTNetCommonParam + ", accessHttpHeaderKeys=" + this.accessHttpHeaderKeys + ", httpHeaders=" + this.httpHeaders + ", isAutoInstallWithoutNotification=" + this.isAutoInstallWithoutNotification + '}';
    }

    private void ensureTempCacheData() {
        if (this.tempCacheData == null) {
            synchronized (this) {
                if (this.tempCacheData == null) {
                    this.tempCacheData = new ConcurrentHashMap<>();
                }
            }
        }
    }

    public ConcurrentHashMap<String, Object> getTempCacheData() {
        ensureTempCacheData();
        return this.tempCacheData;
    }

    public boolean isSupportPartial() {
        return this.supportPartial;
    }

    public int getExecutorGroup() {
        ensureDBJsonData();
        return this.dbJsonData.optInt("executor_group", 2);
    }

    public String getDBJsonString(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optString(str);
    }

    public int getDBJsonInt(String str) {
        ensureDBJsonData();
        return this.dbJsonData.optInt(str);
    }

    public void setThrottleNetSpeed(long j) {
        setThrottleNetSpeed(j, -1);
    }

    public void setThrottleNetSpeed(long j, int i) {
        this.throttleNetSpeed = j;
        this.throttleSmoothness = i;
    }

    public void setOpenLimitSpeed(boolean z) {
        this.openLimitSpeed = z;
    }

    public boolean getOpenLimitSpeed() {
        return this.openLimitSpeed;
    }

    public long getThrottleNetSpeed() {
        return this.throttleNetSpeed;
    }

    public int getThrottleSmoothness() {
        return this.throttleSmoothness;
    }

    public int getStatusAtDbInit() {
        return this.statusAtDbInit;
    }

    public void setStatusAtDbInit(int i) {
        this.statusAtDbInit = i;
    }

    public void setPackageInfo(PackageInfo packageInfo) {
        this.packageInfoRef = new SoftReference<>(packageInfo);
    }

    public PackageInfo getPackageInfo() {
        SoftReference<PackageInfo> softReference = this.packageInfoRef;
        if (softReference == null) {
            return null;
        }
        return softReference.get();
    }

    public void setPackageInfoToCache(PackageInfo packageInfo) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_APP_PACKAGE_INFO, packageInfo.packageName + Constants.ACCEPT_TIME_SEPARATOR_SP + packageInfo.versionName + Constants.ACCEPT_TIME_SEPARATOR_SP + packageInfo.versionCode);
    }

    public PackageInfo getPackageInfoWithCache() {
        ensureDBJsonData();
        String optString = this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_APP_PACKAGE_INFO);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        try {
            String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            PackageInfo packageInfo = new PackageInfo();
            packageInfo.packageName = split[0];
            packageInfo.versionName = split[1];
            packageInfo.versionCode = Integer.parseInt(split[2]);
            return packageInfo;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public double getDownloadSpeed() {
        double curBytes = getCurBytes() / 1048576.0d;
        double realDownloadTime = getRealDownloadTime() / 1000.0d;
        if (curBytes <= 0.0d || realDownloadTime <= 0.0d) {
            return -1.0d;
        }
        return curBytes / realDownloadTime;
    }

    public long getTtnetProtectTimeout() {
        return this.ttnetProtectTimeout;
    }

    public boolean isAddTTNetCommonParam() {
        return this.addTTNetCommonParam;
    }

    public int getPausedResumeCount() {
        ensureSpData();
        return this.spData.optInt(DownloadConstants.KEY_PAUSED_RESUME_COUNT, 0);
    }

    public void setPausedResumeCount(int i) {
        ensureSpData();
        try {
            this.spData.put(DownloadConstants.KEY_PAUSED_RESUME_COUNT, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRawId() {
        return this.f75id;
    }

    public String getRawTempPath() {
        return this.tempPath;
    }

    public String getRawTitle() {
        return this.title;
    }

    public long getRawRealDownloadTime() {
        return this.realDownloadTime;
    }

    public long getRawRealBackDownloadTime() {
        return this.realBackDownloadTime;
    }

    public boolean cacheExpierd() {
        if (isDownloaded()) {
            return DownloadUtils.cacheExpired(this);
        }
        return true;
    }

    public void setRedirectPartialUrlResults(String str) {
        safePutToDBJsonData(DbJsonConstants.DBJSON_KEY_REDIRECT_PARTIAL_URL_RESULTS, str);
    }

    public String getRedirectPartialUrlResults() {
        ensureDBJsonData();
        return this.dbJsonData.optString(DbJsonConstants.DBJSON_KEY_REDIRECT_PARTIAL_URL_RESULTS);
    }

    public void setDownloadStartTimeStamp(long j) {
        this.downloadStartTimeStamp = j;
    }

    public void setDownloadFinishTimeStamp(long j) {
        this.downloadFinishTimeStamp = j;
    }

    public void setInstalledTimeStamp(long j) {
        this.installedTimeStamp = j;
    }

    public void setHasDoInstallation(boolean z) {
        this.hasDoInstallation = z;
    }

    public long getDownloadStartTimeStamp() {
        return this.downloadStartTimeStamp;
    }

    public long getDownloadFinishTimeStamp() {
        return this.downloadFinishTimeStamp;
    }

    public long getInstalledTimeStamp() {
        return this.installedTimeStamp;
    }

    public boolean isHasDoInstallation() {
        return this.hasDoInstallation;
    }

    public long getCacheLifeTimeMax() {
        return this.cacheLifeTimeMax;
    }

    public void resetCacheLifeTimeMax() {
        this.cacheLifeTimeMax = 0L;
    }

    public JSONObject getPcdnStats() {
        return this.pcdnStats;
    }

    public void setPcdnStats(JSONObject jSONObject) {
        this.pcdnStats = jSONObject;
    }

    public int getTaskSleepTime() {
        return this.mTaskSleepTime;
    }

    public void setTaskSleepTime(int i) {
        this.mTaskSleepTime = i;
    }

    public void setPcdnUrlsStr(String str) {
        this.pcdnUrlsStr = str;
    }

    public void setCdnUrlsStr(String str) {
        this.cdnUrlsStr = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setNeedDefaultHttpServiceBackUp(boolean z) {
        this.needDefaultHttpServiceBackUp = z;
    }

    public void setBackUpUrlRetryCount(int i) {
        this.backUpUrlRetryCount = i;
    }

    public void setMonitorScene(String str) {
        this.monitorScene = str;
    }

    public void setNeedIndependentProcess(boolean z) {
        this.needIndependentProcess = z;
    }

    public void setForce(boolean z) {
        this.force = z;
    }

    public void setCurRetryTime(int i) {
        this.curRetryTime = i;
    }

    public void setRealDownloadTime(long j) {
        this.realDownloadTime = j;
    }

    public void setRealBackDownloadTime(long j) {
        this.realBackDownloadTime = j;
    }

    public void setNeedHttpsToHttpRetry(boolean z) {
        this.needHttpsToHttpRetry = z;
    }

    public void setDownloadTime(long j) {
        this.downloadTime = j;
    }

    public void setTempPath(String str) {
        this.tempPath = str;
    }

    public void setCacheLifeTimeMax(long j) {
        this.cacheLifeTimeMax = j;
    }

    public void setDbJsonDataString(String str) {
        this.dbJsonDataString = str;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class Builder {
        private List<String> accessHttpHeaderKeys;
        private boolean addListenerToSameTask;
        private boolean addTTNetCommonParam;
        protected int appVersionCode;
        private boolean autoResumed;
        protected int backUpUrlRetryCount;
        private List<String> backUpUrls;
        protected long cacheLifeTimeMax;
        protected List<String> cdnUrls;
        private boolean deleteCacheIfCheckFailed;
        private boolean distinctDirectory;
        private JSONObject downloadSetting;
        private int executorGroup;
        private long expectFileLength;
        private boolean expiredHttpCheck;
        private boolean expiredRedownload;
        protected String extra;
        private List<HttpHeader> extraHeaders;
        private int[] extraMonitorStatus;
        private boolean fastDownload;
        protected boolean force;
        private boolean handleRequest;
        protected String iconUrl;
        private boolean ignoreDataVerify;
        private boolean ignoreInterceptor;
        private int maxBytes;
        private int maxProgressCount;
        protected String md5;
        protected String mimeType;
        private int minProgressTimeMsInterval;
        protected String monitorScene;
        protected String name;
        protected boolean needCurrentProcess;
        protected boolean needHttpsToHttpRetry;
        protected boolean needIndependentProcess;
        protected boolean onlyWifi;
        private boolean openLimitSpeed;
        private String[] outIp;
        private int[] outSize;
        protected String packageName;
        protected List<String> pcdnUrls;
        protected int retryCount;
        protected String savePath;
        protected boolean showNotification;
        private boolean showNotificationForAutoResumed;
        private String taskKey;
        protected String tempPath;
        private long throttleNetSpeed;
        private int throttleSmoothness;
        protected String title;
        private long ttnetProtectTimeout;
        protected String url;
        private boolean needPostProgress = true;
        private boolean autoInstall = true;
        protected boolean needDefaultHttpServiceBackUp = true;
        private EnqueueType enqueueType = EnqueueType.ENQUEUE_NONE;
        private long startOffset = 0;
        private long endOffset = -1;
        private boolean needSDKMonitor = true;

        public Builder() {
        }

        public Builder(String str) {
            this.url = str;
        }

        public Builder taskKey(String str) {
            this.taskKey = str;
            return this;
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public Builder url(String str) {
            this.url = str;
            return this;
        }

        public Builder pcdnUrls(List<String> list) {
            this.pcdnUrls = list;
            return this;
        }

        public Builder cdnUrls(List<String> list) {
            this.cdnUrls = list;
            return this;
        }

        public Builder savePath(String str) {
            this.savePath = str;
            return this;
        }

        public Builder ignoreInterceptor(boolean z) {
            this.ignoreInterceptor = z;
            return this;
        }

        public Builder tempPath(String str) {
            this.tempPath = str;
            return this;
        }

        public Builder extra(String str) {
            this.extra = str;
            return this;
        }

        public Builder onlyWifi(boolean z) {
            this.onlyWifi = z;
            return this;
        }

        public Builder extraHeaders(List<HttpHeader> list) {
            this.extraHeaders = list;
            return this;
        }

        public Builder accessHttpHeaderKeys(List<String> list) {
            this.accessHttpHeaderKeys = list;
            return this;
        }

        public Builder maxBytes(int i) {
            this.maxBytes = i;
            return this;
        }

        public Builder outIp(String[] strArr) {
            this.outIp = strArr;
            return this;
        }

        public Builder outSize(int[] iArr) {
            this.outSize = iArr;
            return this;
        }

        public Builder retryCount(int i) {
            this.retryCount = i;
            return this;
        }

        public Builder backUpUrlRetryCount(int i) {
            this.backUpUrlRetryCount = i;
            return this;
        }

        public Builder force(boolean z) {
            this.force = z;
            return this;
        }

        public Builder needPostProgress(boolean z) {
            this.needPostProgress = z;
            return this;
        }

        public Builder maxProgressCount(int i) {
            this.maxProgressCount = i;
            return this;
        }

        public Builder minProgressTimeMsInterval(int i) {
            this.minProgressTimeMsInterval = i;
            return this;
        }

        public Builder backUpUrls(List<String> list) {
            this.backUpUrls = list;
            return this;
        }

        public Builder mimeType(String str) {
            this.mimeType = str;
            return this;
        }

        public Builder needHttpsToHttpRetry(boolean z) {
            this.needHttpsToHttpRetry = z;
            return this;
        }

        public Builder showNotification(boolean z) {
            this.showNotification = z;
            return this;
        }

        public Builder autoResumed(boolean z) {
            this.autoResumed = z;
            return this;
        }

        public Builder showNotificationForAutoResumed(boolean z) {
            this.showNotificationForAutoResumed = z;
            return this;
        }

        public Builder needDefaultHttpServiceBackUp(boolean z) {
            this.needDefaultHttpServiceBackUp = z;
            return this;
        }

        public Builder packageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder md5(String str) {
            this.md5 = str;
            return this;
        }

        public Builder expectFileLength(long j) {
            this.expectFileLength = j;
            return this;
        }

        public Builder needIndependentProcess(boolean z) {
            this.needIndependentProcess = z;
            return this;
        }

        public Builder needCurrentProcess(boolean z) {
            this.needCurrentProcess = z;
            return this;
        }

        public Builder enqueueType(EnqueueType enqueueType) {
            this.enqueueType = enqueueType;
            return this;
        }

        public Builder ignoreDataVerify(boolean z) {
            this.ignoreDataVerify = z;
            return this;
        }

        public Builder addListenerToSameTask(boolean z) {
            this.addListenerToSameTask = z;
            return this;
        }

        public Builder downloadSetting(JSONObject jSONObject) {
            this.downloadSetting = jSONObject;
            return this;
        }

        public Builder needSDKMonitor(boolean z) {
            this.needSDKMonitor = z;
            return this;
        }

        public Builder monitorScene(String str) {
            this.monitorScene = str;
            return this;
        }

        public Builder extraMonitorStatus(int[] iArr) {
            this.extraMonitorStatus = iArr;
            return this;
        }

        public Builder iconUrl(String str) {
            this.iconUrl = str;
            return this;
        }

        public Builder executorGroup(int i) {
            this.executorGroup = i;
            return this;
        }

        public Builder throttleNetSpeed(long j) {
            this.throttleNetSpeed = j;
            return this;
        }

        public Builder throttleSmoothness(int i) {
            this.throttleSmoothness = i;
            return this;
        }

        public Builder isOpenLimitSpeed(boolean z) {
            this.openLimitSpeed = z;
            return this;
        }

        public Builder expiredRedownload(boolean z) {
            this.expiredRedownload = z;
            return this;
        }

        public Builder expiredHttpCheck(boolean z) {
            this.expiredHttpCheck = z;
            return this;
        }

        public Builder deleteCacheIfCheckFailed(boolean z) {
            this.deleteCacheIfCheckFailed = z;
            return this;
        }

        public Builder startOffset(long j) {
            if (j > 0) {
                this.startOffset = j;
            }
            return this;
        }

        public Builder endOffset(long j) {
            this.endOffset = j;
            return this;
        }

        public Builder ttnetProtectTimeout(long j) {
            this.ttnetProtectTimeout = j;
            return this;
        }

        public Builder addTTNetCommonParam(boolean z) {
            this.addTTNetCommonParam = z;
            return this;
        }

        public Builder distinctDirectory(boolean z) {
            this.distinctDirectory = z;
            return this;
        }

        public Builder setAutoInstall(boolean z) {
            this.autoInstall = z;
            return this;
        }

        public Builder appVersionCode(int i) {
            this.appVersionCode = i;
            return this;
        }

        public Builder cacheLifeTimeMax(long j) {
            this.cacheLifeTimeMax = j;
            return this;
        }

        public Builder fastDownload() {
            this.fastDownload = true;
            return this;
        }

        public Builder handleRequest() {
            this.handleRequest = true;
            return this;
        }

        public DownloadInfo build() {
            return new DownloadInfo(this);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class RawBuilder extends Builder {
        public long backCurBytes;
        public String backUpUrlsStr;
        public String cdnUrlsStr;
        public int chunkCount;
        public long curBytes;
        public int curRetryTime;
        public String dbJsonDataString;
        public long downloadFinishTimeStamp;
        public long downloadStartTimeStamp;
        public long downloadTime;
        public String etag;
        public boolean hasDoInstallation;

        /* renamed from: id */
        public int f76id;
        public long installedTimeStamp;
        public boolean isFirstDownload;
        public boolean isFirstSuccess;
        public int notificationVisibility;
        public String pcdnUrlsStr;
        public long realBackDownloadTime;
        public long realDownloadTime;
        public int status;
        public long totalBytes;

        @Override // com.ss.android.socialbase.downloader.model.DownloadInfo.Builder
        public DownloadInfo build() {
            return new DownloadInfo(this);
        }
    }
}
