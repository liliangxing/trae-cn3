package com.ss.mediakit.medialoader;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.boringssl.so.BoringsslLoaderWrapper;
import com.lynx.tasm.core.ResManager;
import com.lynx.tasm.utils.LynxConstants;
import com.ss.android.http.legacy.protocol.HTTP;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.mediakit.downloader.AVMDLHttpExcutor;
import com.ss.mediakit.image.ImageLoader;
import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLDNSInfo;
import com.ss.mediakit.net.AVMDLDNSParser;
import com.ss.mediakit.net.AVMDLMultiNetwork;
import com.ss.mediakit.net.IPCache;
import com.ss.mediakit.utils.AVMDLDeviceUtil;
import com.ss.mediakit.vcnlib.VcnlibloadWrapper;
import com.ss.ttm.player.MediaFormat;
import com.vivo.push.PushClient;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okhttp3.OkHttpClient;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class AVMDLDataLoader implements Handler.Callback {
    public static final int AVMDLCopyErrorFileCopyFailed = -5;
    public static final int AVMDLCopyErrorFileHaveHole = -6;
    public static final int AVMDLCopyErrorFileKeyNotCaching = -4;
    public static final int AVMDLCopyErrorInvalidParameter = -1;
    public static final int AVMDLCopyErrorMdlNotRunning = -2;
    public static final int AVMDLCopyErrorNotCached = -3;
    public static final int AVMDLErrorIsCreateTask = -1000;
    public static final int AVMDLErrorIsInvalidContentLenth = -2000;
    public static final int AVMDLErrorIsInvalidFileWrite = -5000;
    public static final int AVMDLErrorIsInvalidRequestInfo = -4000;
    public static final int AVMDLErrorIsStatusCodeMoreThan400 = -3000;
    public static final int AVMDLErrorIsStatusCodeMoreThan500 = -3001;
    public static final int AVMDLErrorIsTheSameKeyTask = -1001;
    public static final int AVMDLErrorIsTooManyTask = -1002;
    public static final int AVMDLLoaderTypeNone = 10000;
    public static final int AVMDLTaskStateStart = 1;
    public static final int AVMDLTaskStateStop = 2;
    public static final int AVMDLTaskTypeDownloadTask = 3;
    public static final int AVMDLTaskTypePlayTask = 1;
    public static final int AVMDLTaskTypePreconnectTask = 4;
    public static final int AVMDLTaskTypePreloadTask = 2;
    public static final int AVMDLoaderTypeAliP2P = 5;
    public static final int AVMDLoaderTypeHttp = 0;
    public static final int AVMDLoaderTypeKsyP2P = 3;
    public static final int AVMDLoaderTypeOwnLiveVDP = 7;
    public static final int AVMDLoaderTypeOwnVDP = 2;
    public static final int AVMDLoaderTypeWsuP2P = 6;
    public static final int AVMDLoaderTypeXYVod = 1;
    public static final int AVMDLoaderTypeYFP2P = 4;
    public static final int IsCellular = 1;
    public static final int IsClose = 5;
    public static final int IsComplete = 3;
    public static final int IsDefault = 0;
    public static final int IsFail = 2;
    public static final int IsInit = 0;
    public static final int IsStart = 1;
    public static final int IsStop = 4;
    public static final int IsWifi = 2;
    public static final int KeyIsAccessCheckLevel = 3511;
    public static final int KeyIsAllowTryTheLastUrl = 7357;
    public static final int KeyIsAlogEnable = 7225;
    public static final int KeyIsAlogInfo = 14;
    public static final int KeyIsBusinessDirControlConfig = 7448;
    public static final int KeyIsByteMediaNetLoaderCronetBufSizeKB = 7351;
    public static final int KeyIsCDNLog = 6;
    public static final int KeyIsCacheDirListsStr = 7399;
    public static final int KeyIsCheckCacheDir = 7430;
    public static final int KeyIsCheckContentTypeMethod = 7407;
    public static final int KeyIsCloseFileCache = 800;
    public static final int KeyIsCloseLocalServer = 7441;
    public static final int KeyIsCloseThreadPool = 7408;
    public static final int KeyIsConnectPoolStragetyValue = 7363;
    public static final int KeyIsControlCDNRangeType = 703;
    public static final int KeyIsCopyOperation = 23;
    public static final int KeyIsCustomUA = 8222;
    public static final int KeyIsDNSLog = 15;
    public static final int KeyIsDeviceScoreEx = 7426;
    public static final int KeyIsDisableRecentCache = 7435;
    public static final int KeyIsDownloadDir = 7300;
    public static final int KeyIsDownloadEnd = 21;
    public static final int KeyIsDownloadSuspend = 22;
    public static final int KeyIsDownloaderLog = 19;
    public static final int KeyIsDownloaderLogTTNet = 16;
    public static final int KeyIsDynamicPreconnectConfigStr = 7501;
    public static final int KeyIsEnableByteMediaNetLoader = 7350;
    public static final int KeyIsEnableCacheReqRange = 7358;
    public static final int KeyIsEnableCellularUp = 8215;
    public static final int KeyIsEnableCustomDirSearchAllPath = 7447;
    public static final int KeyIsEnableDynamicSocketTimeout = 7362;
    public static final int KeyIsEnableEarlyData = 8219;
    public static final int KeyIsEnableEventInfo = 9999;
    public static final int KeyIsEnableExternDNS = 700;
    public static final int KeyIsEnableFileCacheV2 = 7222;
    public static final int KeyIsEnableFileMutexOptimize = 7420;
    public static final int KeyIsEnableFileRingBuffer = 7228;
    public static final int KeyIsEnableIOManager = 7391;
    public static final int KeyIsEnableIpBucket = 901;
    public static final int KeyIsEnableLazyBufferpool = 7332;
    public static final int KeyIsEnableLoaderLogExtractUrls = 7405;
    public static final int KeyIsEnableLoaderPreempt = 2510;
    public static final int KeyIsEnableLoaderSeek = 7369;
    public static final int KeyIsEnableMissReasonRecord = 7438;
    public static final int KeyIsEnableMultiDownloadPath = 7411;
    public static final int KeyIsEnableNetScheduler = 7342;
    public static final int KeyIsEnableNewBufferpool = 7334;
    public static final int KeyIsEnableOkHttpLoader = 9300;
    public static final int KeyIsEnableOptimizeRange = 7428;
    public static final int KeyIsEnableP2PPreDown = 7340;
    public static final int KeyIsEnableP2PUpload = 11000;
    public static final int KeyIsEnablePlayInfoCache = 7339;
    public static final int KeyIsEnablePlayLog = 7341;
    public static final int KeyIsEnablePreconnect = 2508;
    public static final int KeyIsEnablePreloadReUse = 105;
    public static final int KeyIsEnableQuicRegisterWithoutPluginI32 = 7354;
    public static final int KeyIsEnableSessionReuse = 5511;
    public static final int KeyIsEnableSocketReuse = 701;
    public static final int KeyIsEnableSpeedEngine = 8224;
    public static final int KeyIsEnableSpeedPredict = 8220;
    public static final int KeyIsEnableSpeedReport = 8225;
    public static final int KeyIsEnableStorageModule = 10000;
    public static final int KeyIsEnableSyncDnsForPcdn = 7226;
    public static final int KeyIsEnableTTQuicHeLoaderCheckWithNetworkTypeI32 = 7353;
    public static final int KeyIsEnableThreadPoolCheckIdle = 7413;
    public static final int KeyIsEnableTraceidPreloadLog = 7440;
    public static final int KeyIsEnableUseFileExtendLoaderBuffer = 7229;
    public static final int KeyIsEnableUseGroupId = 7431;
    public static final int KeyIsEnableUseOriginalUrl = 7404;
    public static final int KeyIsEnableWaitNetReachable = 7419;
    public static final int KeyIsEnginePortraitStr = 7445;
    public static final int KeyIsEnginePortraitUpdateStr = 7446;
    public static final int KeyIsErrorStateTrustTime = 902;
    public static final int KeyIsFileCacheProgress = 3;
    public static final int KeyIsFileDeleteSizeByUsedTime = 902;
    public static final int KeyIsFileKeyRule = 12000;
    public static final int KeyIsFileManagerInterval = 7443;
    public static final int KeyIsFileRingBufferOptStr = 8302;
    public static final int KeyIsFirstRangeLeftThreshold = 7346;
    public static final int KeyIsForbidByPassCookie = 1510;
    public static final int KeyIsGetAllCacheSize = 100;
    public static final int KeyIsGetBatteryPct = 11009;
    public static final int KeyIsGetCacheInfo = 101;
    public static final int KeyIsGetCacheSize = 103;
    public static final int KeyIsGetCookieTokenLevel = 8303;
    public static final int KeyIsGetCostLog = 1011;
    public static final int KeyIsGetCustomHttpHeader = 1509;
    public static final int KeyIsGetDemuxerVersion = 7433;
    public static final int KeyIsGetDevModel = 11012;
    public static final int KeyIsGetDownloadCountByVid = 9217;
    public static final int KeyIsGetEnableHls = 9407;
    public static final int KeyIsGetFreeStorageKB = 11008;
    public static final int KeyIsGetFsV4Domain = 6401;
    public static final int KeyIsGetFsV6Domain = 6402;
    public static final int KeyIsGetIOManagerHandle = 7390;
    public static final int KeyIsGetIOManagerInterfaceVersion = 7402;
    public static final int KeyIsGetIoDiskEmptyHoleInfo = 1014;
    public static final int KeyIsGetIoWriteError = 1013;
    public static final int KeyIsGetIsOverHeat = 11011;
    public static final int KeyIsGetIsPowerSaveMode = 11010;
    public static final int KeyIsGetLoaderVersion = 11;
    public static final int KeyIsGetLocalAddr = 4;
    public static final int KeyIsGetLongestUnusedTimeOfCacheDir = 115;
    public static final int KeyIsGetMdlProtocolHandle = 7218;
    public static final int KeyIsGetMissReason = 112;
    public static final int KeyIsGetNetInfoForCdnQualitySchedule = 1015;
    public static final int KeyIsGetOfflineCacheFileInfo = 114;
    public static final int KeyIsGetPlayLog = 1010;
    public static final int KeyIsGetPreloadTraceId = 1012;
    public static final int KeyIsGetProxyUrl = 3512;
    public static final int KeyIsGetResStatus = 7231;
    public static final int KeyIsGetSpeedStatus = 7230;
    public static final int KeyIsGetTotalStorageKB = 11007;
    public static final int KeyIsGetUrlGenerator = 7425;
    public static final int KeyIsGetVersionInfo = 830;
    public static final int KeyIsGlobalSpeedSample = 703;
    public static final int KeyIsHeartBeatLog = 70;
    public static final int KeyIsHiJackError = 701;
    public static final int KeyIsHlsTsFileKeyGenerateType = 12001;
    public static final int KeyIsIOSpeedInfo = 5;
    public static final int KeyIsIgnorePlayInfo = 9400;
    public static final int KeyIsIgnoreTextSpeedTest = 7427;
    public static final int KeyIsInitialSocketTimeout = 7360;
    public static final int KeyIsIsCheckPreloadLevel = 6512;
    public static final int KeyIsIsChecksumLevel = 1504;
    public static final int KeyIsIsDownloadSource = 1506;
    public static final int KeyIsIsEnableDownloaderLog = 7347;
    public static final int KeyIsIsEnableTTNetLoader = 7348;
    public static final int KeyIsIsEnableTTQuicHeLoader = 7352;
    public static final int KeyIsIsEncryptVersion = 1505;
    public static final int KeyIsIsGetChecksumInfo = 1503;
    public static final int KeyIsIsMaxTlsVersion = 5512;
    public static final int KeyIsIsPreloadCancel = 7;
    public static final int KeyIsIsTestSpeedVersion = 1502;
    public static final int KeyIsLiveCacheThresholdHttpToP2p = 8006;
    public static final int KeyIsLiveCacheThresholdP2pToHttp = 8007;
    public static final int KeyIsLiveContainerString = 8021;
    public static final int KeyIsLiveEnableMdlProto = 8102;
    public static final int KeyIsLiveGetCurrentBitRate = 8004;
    public static final int KeyIsLiveGetLoaderType = 8103;
    public static final int KeyIsLiveGetP2pState = 8002;
    public static final int KeyIsLiveGetPlayCacheSec = 8003;
    public static final int KeyIsLiveLoaderEnable = 8100;
    public static final int KeyIsLiveLoaderP2pEnable = 8101;
    public static final int KeyIsLiveMaxTrySwitchP2pTimes = 8008;
    public static final int KeyIsLiveMobileDownloadAllow = 8011;
    public static final int KeyIsLiveMobileUploadAllow = 8010;
    public static final int KeyIsLivePlayInfoAudioMixingEnd = 8014;
    public static final int KeyIsLivePlayInfoAudioMixingStart = 8013;
    public static final int KeyIsLivePlayInfoIsPreview = 8016;
    public static final int KeyIsLivePlayInfoIsStreamReceived = 8015;
    public static final int KeyIsLiveRecvDataTimeout = 8012;
    public static final int KeyIsLiveSetLoaderType = 8000;
    public static final int KeyIsLiveSetP2pAllow = 8001;
    public static final int KeyIsLiveSetPrepareTask = 8017;
    public static final int KeyIsLiveSetTaskFinish = 8018;
    public static final int KeyIsLiveWaitP2pReadyThreshold = 8009;
    public static final int KeyIsLiveWatchDurationThreshold = 8005;
    public static final int KeyIsLoadMonitorMinAllowLoadSize = 7397;
    public static final int KeyIsLoadMonitorTimeInternal = 7396;
    public static final int KeyIsLoaderCacheSize = 9216;
    public static final int KeyIsLoaderEventCancel = 72;
    public static final int KeyIsLoaderEventCompleted = 73;
    public static final int KeyIsLoaderEventStart = 71;
    public static final int KeyIsLoaderEventUnKnown = 74;

    @Deprecated
    public static final int KeyIsLoaderFactoryP2PLevel = 8216;
    public static final int KeyIsLoaderFactoryP2PStragetyLevel = 8218;
    public static final int KeyIsLoaderFactoryXYLibValue = 8217;
    public static final int KeyIsLoaderTypeSwitch = 12;
    public static final int KeyIsMAXIPV4Num = 7331;
    public static final int KeyIsMAXIPV6Num = 7330;
    public static final int KeyIsMarkedFileIOSpeed = 1508;
    public static final int KeyIsMaxCacheSizeForDefaultDir = 7449;
    public static final int KeyIsMaxFileMemCacheNum = 5515;
    public static final int KeyIsMaxFileMemCacheSize = 5513;
    public static final int KeyIsMaxIpCountEachDomain = 900;
    public static final int KeyIsMaxIpNum = 8301;
    public static final int KeyIsMaxKeepAliveHostNum = 7364;
    public static final int KeyIsMaxLoaderLogNum = 7406;
    public static final int KeyIsMaxSocketReuseNum = 7361;
    public static final int KeyIsN80OptsStr = 7503;
    public static final int KeyIsNeedNetworkSwitch = 901;
    public static final int KeyIsNetCacheDir = 5510;
    public static final int KeyIsNetSchedulerBlockAllNetErr = 7343;
    public static final int KeyIsNetSchedulerBlockDurationMs = 7345;
    public static final int KeyIsNetSchedulerBlockErrCount = 7344;
    public static final int KeyIsNetSchedulerConfigStr = 7403;
    public static final int KeyIsNetUnreachableStopRetry = 7418;
    public static final int KeyIsNetUnreachableTimeout = 7422;
    public static final int KeyIsNetworkAccessType = 7219;
    public static final int KeyIsNetworkChanged = 7217;
    public static final int KeyIsNewBufferPoolGrowBlockCount = 7337;
    public static final int KeyIsNewBufferpoolBlockSize = 7335;
    public static final int KeyIsNewBufferpoolResidentSize = 7336;
    public static final int KeyIsNewPreloadLog = 1002;
    public static final int KeyIsNewProtocolLog = 1001;
    public static final int KeyIsNewProxyLog = 1000;
    public static final int KeyIsNewSampleLog = 1004;
    public static final int KeyIsNewTaskLog = 1003;
    public static final int KeyIsNextDownloadThreshold = 2511;
    public static final int KeyIsNonBlockRangeMaxSizeKB = 7417;
    public static final int KeyIsNonBlockRangeMode = 7416;
    public static final int KeyIsOnLiveLoaderError = 9;
    public static final int KeyIsOwnLiveLoaderLog = 10;
    public static final int KeyIsOwnLiveLoaderLogSample = 11;
    public static final int KeyIsOwnVdpLog = 1;
    public static final int KeyIsP2PConfigStr = 8221;
    public static final int KeyIsP2PCostTag = 7423;
    public static final int KeyIsP2PFirstRangeLoaderType = 7372;
    public static final int KeyIsP2PPredownPeerCount = 7359;
    public static final int KeyIsPlayInfoBufferingEnd = 7214;
    public static final int KeyIsPlayInfoBufferingStart = 7213;
    public static final int KeyIsPlayInfoCurrentBuffer = 7215;
    public static final int KeyIsPlayInfoLoadPercent = 7212;
    public static final int KeyIsPlayInfoPlayingPos = 7211;
    public static final int KeyIsPlayInfoRenderStart = 7210;
    public static final int KeyIsPlayTaskCacheEnd = 52;
    public static final int KeyIsPlayTaskEnd = 51;
    public static final int KeyIsPlayTaskState = 50;
    public static final int KeyIsPrecisePreloadConfig = 7434;
    public static final int KeyIsPreconnectNum = 2509;
    public static final int KeyIsPreloadEnd = 4;
    public static final int KeyIsPreloadFail = 8;
    public static final int KeyIsPreloadInfoRecordMaxCnt = 7439;
    public static final int KeyIsPreloadStragetyWhenPlay = 1030;
    public static final int KeyIsPreloadTraceIdRecordMaxCntI32 = 7424;
    public static final int KeyIsPreloadWaitListType = 1040;
    public static final int KeyIsProtectCacheDirAvoidClear = 7444;
    public static final int KeyIsQuickGetCacheSize = 106;
    public static final int KeyIsQuickQueryCacheSize = 113;
    public static final int KeyIsRingBufferSizeKB = 7221;
    public static final int KeyIsSessionCacheInterval = 7442;
    public static final int KeyIsSessionTimeout = 7333;
    public static final int KeyIsSetAlogFuncPtr = 1100;
    public static final int KeyIsSetBackupLoaderType = 7227;
    public static final int KeyIsSetCacheDir = 0;
    public static final int KeyIsSetCurDiskSizeMB = 11003;
    public static final int KeyIsSetCurMemorySizeMB = 11005;
    public static final int KeyIsSetDMDomain = 9402;
    public static final int KeyIsSetDemuxerHandle = 7432;
    public static final int KeyIsSetDevDiskSizeMB = 11002;
    public static final int KeyIsSetDevMemorySizeMB = 11004;
    public static final int KeyIsSetDomains = 9404;
    public static final int KeyIsSetDownLogMaxSize = 7429;
    public static final int KeyIsSetEnableMaxCacheAgeForAllDir = 111;
    public static final int KeyIsSetEnableOwnVdpPreloadNotify = 7395;
    public static final int KeyIsSetEnableReportTaskLog = 7371;
    public static final int KeyIsSetFileExtendSize = 7392;
    public static final int KeyIsSetForesightDomain = 9403;
    public static final int KeyIsSetGlobalSpeedSampleInterval = 7370;
    public static final int KeyIsSetKeyDomain = 9405;
    public static final int KeyIsSetKeyToken = 9406;
    public static final int KeyIsSetLiveListener = 107;
    public static final int KeyIsSetLoaderFactoryAppInfo = 10;
    public static final int KeyIsSetLoaderFactoryCacheDir = 9;
    public static final int KeyIsSetLoaderFactoryMaxCacheSize = 7;
    public static final int KeyIsSetLoaderFactoryMaxMemorySize = 8;
    public static final int KeyIsSetLoaderType = 6;
    public static final int KeyIsSetMaxCacheAge = 104;
    public static final int KeyIsSetMaxCacheSize = 1;
    public static final int KeyIsSetMdlExtensionOpts = 7500;
    public static final int KeyIsSetMdlTTQuicHeOpts = 7504;
    public static final int KeyIsSetMinAllowSpeed = 7393;
    public static final int KeyIsSetNetSchedulerBlockHostErrIpCount = 7394;
    public static final int KeyIsSetOnlyUseCdn = 7216;
    public static final int KeyIsSetOpenTimeOut = 3;
    public static final int KeyIsSetPcdnAuto = 12;
    public static final int KeyIsSetPlayInfoSeekAction = 7338;
    public static final int KeyIsSetPreconnectState = 8223;
    public static final int KeyIsSetPreloadParallelNum = 102;
    public static final int KeyIsSetRWTimeOut = 2;
    public static final int KeyIsSetSettingsDomain = 9401;
    public static final int KeyIsSetSocketRecvBuffer = 7401;
    public static final int KeyIsSetSpeedSampleInterval = 7368;
    public static final int KeyIsSetTryCount = 5;
    public static final int KeyIsSetUseNewSingSpeedTest = 7400;
    public static final int KeyIsSetVdpExtDynamicInfo = 11006;
    public static final int KeyIsSetVdpExtGlobalInfo = 11001;
    public static final int KeyIsSkipCDNBeforeExpiredSec = 7421;
    public static final int KeyIsSocketIdleTimeout = 702;
    public static final int KeyIsSocketSendBufferKB = 7220;
    public static final int KeyIsSocketTrainingCenterConfigStr = 7398;
    public static final int KeyIsSpeedCoefficientValue = 1507;
    public static final int KeyIsSpeedEngineSetting = 8226;
    public static final int KeyIsSpeedInfo = 2;
    public static final int KeyIsSpeedTestSampledByTime = 700;
    public static final int KeyIsSpeedTestSampledByTimeV2 = 702;
    public static final int KeyIsStoIoWriteLimitKBTh1 = 10004;
    public static final int KeyIsStoIoWriteLimitKBTh2 = 10005;
    public static final int KeyIsStoMaxIdleTimeSec = 10006;
    public static final int KeyIsStoPlayDldWinSizeKBLS = 10002;
    public static final int KeyIsStoPlayDldWinSizeKBNM = 10001;
    public static final int KeyIsStoRingBufferSizeKB = 10003;
    public static final int KeyIsStoStrategyConfig = 10007;
    public static final int KeyIsStoUpdateCacheDir = 7437;
    public static final int KeyIsStorageLog = 1005;
    public static final int KeyIsTTNetLoaderCronetBufSizeKB = 7349;
    public static final int KeyIsTTQuicHeCacheDir = 6513;
    public static final int KeyIsTaskFail = 20;
    public static final int KeyIsTaskLog = 0;
    public static final int KeyIsTaskOpen = 24;
    public static final int KeyIsTemporaryOptStr = 7502;
    public static final int KeyIsThreadPoolIdleTTLSecond = 7414;
    public static final int KeyIsThreadPoolMinCount = 7415;
    public static final int KeyIsThreadStackSizeLevel = 7412;
    public static final int KeyIsUpdateCacheFileInternal = 7436;
    public static final int KeyIsUpdateNetworkScore = 7409;
    public static final int KeyIsUpdateNetworkStrength = 7410;
    public static final int KeyIsVdpABTestId = 7223;
    public static final int KeyIsVdpGroupId = 7224;
    public static final int KeyIsWriteFileNotifyIntervalMS = 110;
    public static final int LogInfoKeyIsPcdnTaskLog = 13;
    public static final long LongValueViaConfigNotReady = -998;
    public static final long LongValueViaUnknownKey = -1;
    public static final int S_FAIL = -1;
    public static final int S_OK = 0;
    private static final String TAG = "AVMDLDataLoader";
    private static boolean isSupportQueryEncode = true;
    private static Context mGlobalApplicationContext = null;
    private static volatile AVMDLDataLoader mInstance = null;
    public static Boolean mIsByteMediaNetInit = false;
    private static volatile boolean mIsLibraryLoaded = false;
    private static volatile boolean mIsMdlByteMediaNetPluginLoaded = false;
    private static volatile boolean mIsMdlTtnetPluginLoaded = false;
    private static String mLoadFailMsg = "";
    private boolean isSupportGetAuth;
    private AVMDLDataLoaderConfigure mConfigure;
    private MDLDownloaderCallback mDownloaderCallback;
    private long mEndTime;
    private LoaderListener mEventListener;
    private long mHandle;
    private AVMDLDataLoaderListener mLiveListener;
    private Map<Integer, MDLDownloader> mMDLDownloaderMap;
    private Thread mMsgThread;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private long mSartTime;
    private AVMDLStartCompleteListener mStartCompleteListener;
    private volatile int mState;
    private AVMDLTaskEventListener mTaskListener;
    private boolean mTryedLoadP2pPlugin;
    private AVMDLDataLoaderListener mVodListener;
    private Map<String, AVMDLCopyOperation> mWaitingCopyItem;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private Handler mHandler = null;
    private Handler mLogHandler = null;
    private IAVMDLLibraryLoader mPluginLibraryLoader = null;

    private static native void _addDataSource(long j, int i, String str);

    private static native void _cancel(long j, String str);

    private static native void _cancelAll(long j);

    private static native void _cancelAllPreloadWaitReqs(long j);

    private static native void _cleanCacheDir(long j, long j2);

    private static native void _cleanCacheDirForExpiredFiles(long j, String str, long j2);

    private static native void _cleanSpecifiedCacheDir(long j, String str, int i);

    private static native void _clearAllCaches(long j);

    private static native long _clearAndGetCachesByUsedTime(long j, long j2, int i);

    private static native void _clearCachesByUsedTime(long j, long j2);

    private static native void _clearNetinfoCache(long j);

    private static native void _close(long j);

    private static native int _copyFile(long j, String str, String str2);

    private static native long _copyFile64(long j, String str, String str2);

    private static native int _copyFileWithCustomDir(long j, String str, String str2, String str3);

    private static native long _copyFileWithCustomDir64(long j, String str, String str2, String str3);

    private static native long _copyFileWithDir64(long j, String str, String str2, String str3, int i);

    private static native int _copyFileWithForceFlag(long j, String str, String str2, int i);

    private static native long _copyFileWithForceFlag64(long j, String str, String str2, int i);

    private final native long _create();

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dhAsyncStart(long j, long j2, MDLDownloader.MDLTaskCallback mDLTaskCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String _dhGetValue(long j, long j2, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dhRead(long j, long j2, long j3, int i, byte[] bArr, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dhSetValue(long j, long j2, String str, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dhStop(long j, long j2, int i);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dmBussinessInit(long j, int i, String str, MDLDownloaderCallback mDLDownloaderCallback);

    /* JADX INFO: Access modifiers changed from: private */
    public static native long _dmCreateHandler(long j, int i, String str, Map<String, String> map, Map<String, String> map2, String str2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dmDeleteHandler(long j, int i, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native String _dmGetValue(long j, int i, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public static native int _dmSetValue(long j, int i, String str, String str2);

    private static native void _downloadResource(long j, String str);

    private static native String _encodeUrl(String str, int i);

    private static native void _forceClearAllCaches(long j);

    private static native void _forceRemoveCacheFile(long j, String str);

    private static native String _getAuth(long j, String str);

    private static native String _getCDNLog(long j, String str);

    private static native long _getContinueCacheSize(long j, String str, int i, long j2);

    private static native int _getIsFileCacheComplete(long j, String str);

    private static native long _getLongValue(long j, int i);

    private static native long _getLongValueByStr(long j, String str, int i);

    private static native long _getLongValueByStrStr(long j, String str, String str2, int i);

    private static native String _getStringValue(long j, int i);

    private static native String _getStringValueByStr(long j, String str, int i);

    private static native String _getStringValueByStrStr(long j, String str, String str2, int i);

    private static native int _haveRunningPlayTask(long j, String str);

    private static native void _makeFileAutoDeleteFlag(long j, String str, int i);

    private static native String _makeTsFileKey(String str, String str2);

    private static native int _onCellularAlwaysUp(long j, long j2, int i);

    private static native int _onInitMultiNetworkEnv(long j, int i);

    @Deprecated
    private static native void _p2pPredown(long j, String str);

    private static native void _preConnectByHost(long j, String str, int i);

    private static native void _preloadGroupResource(long j, String str, String str2, long j2, long j3);

    private static native void _preloadResource(long j, String str, long j2);

    private static native void _preloadResourceWithOffset(long j, String str, long j2, long j3);

    private static native String _protectFile(long j, String str, int i);

    private static native void _removeCacheFile(long j, String str);

    private static native void _resetPreloadTraceId(long j, String str);

    private static native void _resumeFileWriteIO(long j);

    private static native void _setInt64Value(long j, int i, long j2);

    private static native void _setInt64ValueByStrKey(long j, int i, String str, long j2);

    private static native void _setIntValue(long j, int i, int i2);

    private static native void _setStringValue(long j, int i, String str);

    private static native int _start(long j);

    private static native int _startPcdn(long j);

    private static native void _stop(long j);

    private static native void _suspendedDownload(long j, String str);

    private static native int _tryDownloadPlayReqByKey(long j, String str);

    private static native void _updateDNSInfo(long j, String str, String str2, long j2, String str3, int i);

    private static native int _writeDataToFile(long j, String str, long j2, long j3, int i, byte[] bArr);

    private boolean isNotifyInfo(int i) {
        return i == 4 || i == 20 || i == 50 || i == 8 || i == 3 || i == 21 || i == 51 || i == 7 || i == 22 || i == 52 || i == 901 || i == 24 || i == 902;
    }

    public static boolean isVCBasekitStaticLinked() {
        return false;
    }

    public static void initApplicationContext(Context context) {
        synchronized (AVMDLDataLoader.class) {
            if (mGlobalApplicationContext == null) {
                mGlobalApplicationContext = context;
            }
        }
    }

    public static Context getApplicationContext() {
        Context context;
        synchronized (AVMDLDataLoader.class) {
            context = mGlobalApplicationContext;
        }
        return context;
    }

    public static void setOkhttpClient(OkHttpClient okHttpClient) {
        AVMDLHttpExcutor.setOkHttpClient(okHttpClient);
    }

    public static void initByteMediaNetEnv(Context context, ClassLoader classLoader) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsByteMediaNetInit.booleanValue()) {
                Log.e("bytemedianetinit", "has init, not need again");
                return;
            }
            try {
                Class<?> cls = Class.forName("com.ss.avframework.transport.ContextUtils");
                if (cls != null) {
                    Method method = cls.getMethod("initApplicationContext", Context.class);
                    method.setAccessible(true);
                    method.invoke(null, context);
                    Log.e("bytemedianetinit", "init application context");
                }
                Class<?> cls2 = Class.forName("com.ss.avframework.transport.JNIUtils");
                if (cls2 != null) {
                    Method method2 = cls2.getMethod("setClassLoader", ClassLoader.class);
                    method2.setAccessible(true);
                    method2.invoke(null, classLoader);
                    Log.e("bytemedianetinit", "init classloader");
                }
                if (cls != null && cls2 != null) {
                    mIsByteMediaNetInit = true;
                    Log.e("bytemedianetinit", "init bytemedianet suc");
                }
            } catch (Throwable th) {
                Log.e("bytemedianetinit", "init bytemedianet exception, " + th.toString());
                Log.e("bytemedianetinit", "init bytemedianet exception,msg: " + th.getLocalizedMessage());
            }
        }
    }

    public static boolean tryLoadVcnverifylib() {
        AVMDLLog.m226d("vcn", "not need load vcnverify");
        return true;
    }

    private AVMDLDataLoader(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) throws Exception {
        this.mState = -1;
        this.mConfigure = null;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mMsgThread = null;
        this.isSupportGetAuth = true;
        this.mStartCompleteListener = null;
        this.mWaitingCopyItem = new HashMap();
        this.mTaskListener = null;
        this.mMDLDownloaderMap = new HashMap();
        this.mTryedLoadP2pPlugin = false;
        initNativeHandle();
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        if (this.mHandle == 0) {
            throw new Exception("create native mdl fail");
        }
        initLogThread(this);
        this.mConfigure = aVMDLDataLoaderConfigure;
        this.mState = 0;
        this.isSupportGetAuth = true;
    }

    private void initLogThread(final Handler.Callback callback) {
        if (this.mMsgThread == null) {
            Thread thread = new Thread() { // from class: com.ss.mediakit.medialoader.AVMDLDataLoader.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    if (Looper.myLooper() == null) {
                        Looper.prepare();
                    }
                    AVMDLDataLoader.this.mLogHandler = new Handler(callback);
                    Looper.loop();
                }
            };
            this.mMsgThread = thread;
            thread.setName("mdl_log_handler");
            this.mMsgThread.start();
        }
    }

    public static AVMDLDataLoader getInstance() {
        if (mInstance == null) {
            synchronized (AVMDLDataLoader.class) {
                if (mInstance == null) {
                    try {
                        mInstance = new AVMDLDataLoader(null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        Log.e("ttmdljava", "create native exception" + e);
                        mInstance = null;
                    }
                }
            }
        }
        return mInstance;
    }

    private void initNativeHandle() {
        if (this.mHandle != 0) {
            return;
        }
        try {
            this.mHandle = _create();
        } catch (Throwable th) {
            this.mHandle = 0L;
            th.printStackTrace();
        }
        if (this.mHandle == 0 || this.mHandler != null) {
            return;
        }
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    private void setConfigureInternal(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        if (this.mHandle == 0 || aVMDLDataLoaderConfigure == null) {
            return;
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mCacheDir)) {
            String createFilePathBaseDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "loaderFactory");
            if (!TextUtils.isEmpty(createFilePathBaseDir)) {
                _setStringValue(this.mHandle, 9, createFilePathBaseDir);
            }
            if (TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
                aVMDLDataLoaderConfigure.mNetCacheDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mCacheDir, "netCache");
            }
            _setStringValue(this.mHandle, 0, aVMDLDataLoaderConfigure.mCacheDir);
        }
        if (!TextUtils.isEmpty(this.mConfigure.mNetCacheDir)) {
            _setStringValue(this.mHandle, KeyIsNetCacheDir, aVMDLDataLoaderConfigure.mNetCacheDir);
            aVMDLDataLoaderConfigure.mTTquicheCacheDir = createFilePathBaseDir(aVMDLDataLoaderConfigure.mNetCacheDir, "ttquiche");
            _setStringValue(this.mHandle, KeyIsTTQuicHeCacheDir, aVMDLDataLoaderConfigure.mTTquicheCacheDir);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mAppInfo)) {
            _setStringValue(this.mHandle, 10, aVMDLDataLoaderConfigure.mAppInfo);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDownloadDir)) {
            _setStringValue(this.mHandle, KeyIsDownloadDir, aVMDLDataLoaderConfigure.mDownloadDir);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mMdlExtensionOptsStr)) {
            _setStringValue(this.mHandle, KeyIsSetMdlExtensionOpts, aVMDLDataLoaderConfigure.mMdlExtensionOptsStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mMdlTTQuicHeOptsStr)) {
            _setStringValue(this.mHandle, KeyIsSetMdlTTQuicHeOpts, aVMDLDataLoaderConfigure.mMdlTTQuicHeOptsStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mTemporaryOptStr)) {
            _setStringValue(this.mHandle, KeyIsTemporaryOptStr, aVMDLDataLoaderConfigure.mTemporaryOptStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mN80OptsStr)) {
            _setStringValue(this.mHandle, KeyIsN80OptsStr, aVMDLDataLoaderConfigure.mN80OptsStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mSpeedEngineSetting)) {
            _setStringValue(this.mHandle, KeyIsSpeedEngineSetting, aVMDLDataLoaderConfigure.mSpeedEngineSetting);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mPrecisePreloadConfigStr)) {
            _setStringValue(this.mHandle, KeyIsPrecisePreloadConfig, aVMDLDataLoaderConfigure.mPrecisePreloadConfigStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mImageLoaderConfigStr)) {
            ImageLoader.get().setConfigString(aVMDLDataLoaderConfigure.mImageLoaderConfigStr);
        }
        _setIntValue(this.mHandle, 8001, aVMDLDataLoaderConfigure.mLiveP2pAllow);
        _setIntValue(this.mHandle, 8000, aVMDLDataLoaderConfigure.mLiveLoaderType);
        _setIntValue(this.mHandle, KeyIsLiveWatchDurationThreshold, aVMDLDataLoaderConfigure.mLiveWatchDurationThreshold);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdHttpToP2p, aVMDLDataLoaderConfigure.mLiveCacheThresholdHttpToP2p);
        _setIntValue(this.mHandle, KeyIsLiveCacheThresholdP2pToHttp, aVMDLDataLoaderConfigure.mLiveCacheThresholdP2pToHttp);
        _setIntValue(this.mHandle, KeyIsLiveMaxTrySwitchP2pTimes, aVMDLDataLoaderConfigure.mLiveMaxTrySwitchP2pTimes);
        _setIntValue(this.mHandle, KeyIsLiveWaitP2pReadyThreshold, aVMDLDataLoaderConfigure.mLiveWaitP2pReadyThreshold);
        _setIntValue(this.mHandle, KeyIsLiveMobileUploadAllow, aVMDLDataLoaderConfigure.mLiveMobileUploadAllow);
        _setIntValue(this.mHandle, KeyIsLiveMobileDownloadAllow, aVMDLDataLoaderConfigure.mLiveMobileDownloadAllow);
        _setIntValue(this.mHandle, KeyIsLiveRecvDataTimeout, aVMDLDataLoaderConfigure.mLiveRecvDataTimeout);
        _setStringValue(this.mHandle, KeyIsLiveContainerString, aVMDLDataLoaderConfigure.mLiveContainerString);
        _setIntValue(this.mHandle, 1, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 2, aVMDLDataLoaderConfigure.mRWTimeOut);
        _setIntValue(this.mHandle, 3, aVMDLDataLoaderConfigure.mOpenTimeOut);
        _setIntValue(this.mHandle, 5, aVMDLDataLoaderConfigure.mTryCount);
        _setIntValue(this.mHandle, 7, aVMDLDataLoaderConfigure.mMaxCacheSize);
        _setIntValue(this.mHandle, 8, aVMDLDataLoaderConfigure.mLoaderFactoryMaxMemorySize);
        if (aVMDLDataLoaderConfigure.mEnablePcdnAuto == 1) {
            _setIntValue(this.mHandle, 12, aVMDLDataLoaderConfigure.mEnablePcdnAuto);
        } else {
            _setIntValue(this.mHandle, 6, aVMDLDataLoaderConfigure.mLoaderType);
        }
        _setIntValue(this.mHandle, 102, aVMDLDataLoaderConfigure.mPreloadParallelNum);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        if (aVMDLDataLoaderConfigure.mMaxCacheAge > 0) {
            _setIntValue(this.mHandle, 104, aVMDLDataLoaderConfigure.mMaxCacheAge);
        }
        _setIntValue(this.mHandle, 111, aVMDLDataLoaderConfigure.mEnableMaxCacheAgeForAllDir);
        _setIntValue(this.mHandle, 1030, aVMDLDataLoaderConfigure.mPreloadStrategy);
        _setIntValue(this.mHandle, 1040, aVMDLDataLoaderConfigure.mPreloadWaitListType);
        _setIntValue(this.mHandle, 105, aVMDLDataLoaderConfigure.mEnablePreloadReUse);
        _setIntValue(this.mHandle, 700, aVMDLDataLoaderConfigure.mEnableExternDNS);
        _setIntValue(this.mHandle, 701, aVMDLDataLoaderConfigure.mEnableSocketReuse);
        _setIntValue(this.mHandle, 703, aVMDLDataLoaderConfigure.mControlCDNRangeType);
        _setIntValue(this.mHandle, 702, aVMDLDataLoaderConfigure.mSocketIdleTimeOut);
        _setIntValue(this.mHandle, 800, aVMDLDataLoaderConfigure.mIsCloseFileCache);
        _setIntValue(this.mHandle, 1502, aVMDLDataLoaderConfigure.mTestSpeedTypeVersion);
        _setIntValue(this.mHandle, KeyIsIsChecksumLevel, aVMDLDataLoaderConfigure.mCheckSumLevel);
        _setIntValue(this.mHandle, KeyIsIsEncryptVersion, aVMDLDataLoaderConfigure.mEncryptVersion);
        _setIntValue(this.mHandle, KeyIsSpeedCoefficientValue, aVMDLDataLoaderConfigure.mSpeedCoefficientValue);
        _setIntValue(this.mHandle, KeyIsMaxIpCountEachDomain, aVMDLDataLoaderConfigure.mMaxIpCountEachDomain);
        _setIntValue(this.mHandle, 901, aVMDLDataLoaderConfigure.mEnableIpBucket);
        _setIntValue(this.mHandle, 902, aVMDLDataLoaderConfigure.mErrorStateTrustTime);
        _setIntValue(this.mHandle, KeyIsEnablePreconnect, aVMDLDataLoaderConfigure.mEnablePreconnect);
        _setIntValue(this.mHandle, KeyIsPreconnectNum, aVMDLDataLoaderConfigure.mPreconnectNum);
        _setIntValue(this.mHandle, KeyIsEnableLoaderPreempt, aVMDLDataLoaderConfigure.mEnableLoaderPreempt);
        _setIntValue(this.mHandle, KeyIsNextDownloadThreshold, aVMDLDataLoaderConfigure.mNextDownloadThreshold);
        _setIntValue(this.mHandle, KeyIsSetOnlyUseCdn, aVMDLDataLoaderConfigure.mOnlyUseCdn);
        _setIntValue(this.mHandle, KeyIsAccessCheckLevel, aVMDLDataLoaderConfigure.mAccessCheckLevel);
        _setIntValue(this.mHandle, KeyIsEnableSessionReuse, aVMDLDataLoaderConfigure.mEnableSessionReuse);
        _setIntValue(this.mHandle, KeyIsIsMaxTlsVersion, aVMDLDataLoaderConfigure.mMaxTlsVersion);
        _setIntValue(this.mHandle, KeyIsIsCheckPreloadLevel, aVMDLDataLoaderConfigure.mCheckPreloadLevel);
        _setIntValue(this.mHandle, KeyIsLoaderFactoryXYLibValue, aVMDLDataLoaderConfigure.mXYLibValue);
        _setIntValue(this.mHandle, KeyIsEnableP2PPreDown, aVMDLDataLoaderConfigure.mEnableP2PPreDown);
        _setIntValue(this.mHandle, KeyIsEnablePlayLog, aVMDLDataLoaderConfigure.mEnablePlayLog);
        _setIntValue(this.mHandle, KeyIsEnableNetScheduler, aVMDLDataLoaderConfigure.mEnableNetScheduler);
        _setIntValue(this.mHandle, KeyIsEnableCacheReqRange, aVMDLDataLoaderConfigure.mEnableCacheReqRange);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockAllNetErr, aVMDLDataLoaderConfigure.mNetSchedulerBlockAllNetErr);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockErrCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockErrCount);
        _setIntValue(this.mHandle, KeyIsNetSchedulerBlockDurationMs, aVMDLDataLoaderConfigure.mNetSChedulerBlockDurationMs);
        _setIntValue(this.mHandle, KeyIsFirstRangeLeftThreshold, aVMDLDataLoaderConfigure.mFirstRangeLeftThreshold);
        _setIntValue(this.mHandle, KeyIsSetNetSchedulerBlockHostErrIpCount, aVMDLDataLoaderConfigure.mNetSchedulerBlockHostIpErrCount);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheSize, aVMDLDataLoaderConfigure.mMaxFileMemCacheSize);
        _setIntValue(this.mHandle, KeyIsMaxFileMemCacheNum, aVMDLDataLoaderConfigure.mMaxFileMemCacheNum);
        _setIntValue(this.mHandle, 110, aVMDLDataLoaderConfigure.mWriteFileNotifyIntervalMS);
        _setIntValue(this.mHandle, KeyIsP2PPredownPeerCount, aVMDLDataLoaderConfigure.mP2PPreDownPeerCount);
        _setIntValue(this.mHandle, KeyIsP2PFirstRangeLoaderType, aVMDLDataLoaderConfigure.mP2PFirstRangeLoaderType);
        if (aVMDLDataLoaderConfigure.mSocketSendBufferKB > 0) {
            _setIntValue(this.mHandle, KeyIsSocketSendBufferKB, aVMDLDataLoaderConfigure.mSocketSendBufferKB);
        }
        if (aVMDLDataLoaderConfigure.mRingBufferSizeKB > 0) {
            _setIntValue(this.mHandle, KeyIsRingBufferSizeKB, aVMDLDataLoaderConfigure.mRingBufferSizeKB);
        }
        _setIntValue(this.mHandle, KeyIsEnableFileCacheV2, aVMDLDataLoaderConfigure.mEnableFileCacheV2);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpABTestId)) {
            _setStringValue(this.mHandle, KeyIsVdpABTestId, aVMDLDataLoaderConfigure.mVdpABTestId);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpGroupId)) {
            _setStringValue(this.mHandle, KeyIsVdpGroupId, aVMDLDataLoaderConfigure.mVdpGroupId);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mNetSchedulerConfigStr)) {
            _setStringValue(this.mHandle, KeyIsNetSchedulerConfigStr, aVMDLDataLoaderConfigure.mNetSchedulerConfigStr);
        }
        _setIntValue(this.mHandle, KeyIsAlogEnable, aVMDLDataLoaderConfigure.mAlogEnable);
        _setIntValue(this.mHandle, KeyIsEnableSyncDnsForPcdn, aVMDLDataLoaderConfigure.mEnableSyncDnsForPcdn);
        _setIntValue(this.mHandle, KeyIsEnableFileRingBuffer, aVMDLDataLoaderConfigure.mEnableFileRingBuffer);
        _setIntValue(this.mHandle, KeyIsEnableLazyBufferpool, aVMDLDataLoaderConfigure.mEnableLazyBufferpool);
        _setIntValue(this.mHandle, KeyIsEnableNewBufferpool, aVMDLDataLoaderConfigure.mEnableNewBufferpool);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolBlockSize, aVMDLDataLoaderConfigure.mNewBufferPoolBlockSize);
        _setIntValue(this.mHandle, KeyIsNewBufferpoolResidentSize, aVMDLDataLoaderConfigure.mNewBufferPoolResidentSize);
        _setIntValue(this.mHandle, KeyIsNewBufferPoolGrowBlockCount, aVMDLDataLoaderConfigure.mNewBufferPoolGrowBlockCount);
        _setIntValue(this.mHandle, KeyIsEnableUseFileExtendLoaderBuffer, aVMDLDataLoaderConfigure.mEnableUseFileExtendLoaderBuffer);
        _setIntValue(this.mHandle, KeyIsMAXIPV6Num, aVMDLDataLoaderConfigure.mMaxIPV6Num);
        _setIntValue(this.mHandle, KeyIsMAXIPV4Num, aVMDLDataLoaderConfigure.mMaxIPV4Num);
        _setIntValue(this.mHandle, KeyIsForbidByPassCookie, aVMDLDataLoaderConfigure.mForbidByPassCookie);
        _setIntValue(this.mHandle, KeyIsSessionTimeout, aVMDLDataLoaderConfigure.mSessionTimeout);
        _setIntValue(this.mHandle, KeyIsEnablePlayInfoCache, aVMDLDataLoaderConfigure.mEnablePlayInfoCache);
        _setIntValue(this.mHandle, KeyIsIsEnableDownloaderLog, aVMDLDataLoaderConfigure.mEnableDownloaderLog);
        _setIntValue(this.mHandle, KeyIsIsEnableTTNetLoader, aVMDLDataLoaderConfigure.mEnableTTNetLoader);
        _setIntValue(this.mHandle, KeyIsTTNetLoaderCronetBufSizeKB, aVMDLDataLoaderConfigure.mTTNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsAllowTryTheLastUrl, aVMDLDataLoaderConfigure.mIsAllowTryTheLastUrl);
        _setIntValue(this.mHandle, KeyIsSetSpeedSampleInterval, aVMDLDataLoaderConfigure.mSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsSetUseNewSingSpeedTest, aVMDLDataLoaderConfigure.mUseNewSpeedTestForSingle);
        _setIntValue(this.mHandle, KeyIsIsEnableTTQuicHeLoader, aVMDLDataLoaderConfigure.mEnableTTQuicHeLoader);
        _setIntValue(this.mHandle, KeyIsEnableTTQuicHeLoaderCheckWithNetworkTypeI32, aVMDLDataLoaderConfigure.mEnableTTQuicHeLoaderCheckWithNetworkType);
        _setIntValue(this.mHandle, KeyIsEnableQuicRegisterWithoutPluginI32, aVMDLDataLoaderConfigure.mEnableQuicRegisterWithoutPlugin);
        _setIntValue(this.mHandle, KeyIsEnableIOManager, aVMDLDataLoaderConfigure.mEnableIOManager);
        _setIntValue(this.mHandle, KeyIsEnableLoaderSeek, aVMDLDataLoaderConfigure.mEnableLoaderSeek);
        _setIntValue(this.mHandle, KeyIsSetGlobalSpeedSampleInterval, aVMDLDataLoaderConfigure.mGlobalSpeedSampleInterval);
        _setIntValue(this.mHandle, KeyIsEnableDynamicSocketTimeout, aVMDLDataLoaderConfigure.mEnableDynamicTimeout);
        _setIntValue(this.mHandle, KeyIsInitialSocketTimeout, aVMDLDataLoaderConfigure.mSocketInitialTimeout);
        _setIntValue(this.mHandle, KeyIsMaxSocketReuseNum, aVMDLDataLoaderConfigure.mMaxSocketReuseCount);
        _setIntValue(this.mHandle, KeyIsSetEnableReportTaskLog, aVMDLDataLoaderConfigure.mEnableReportTaskLog);
        _setInt64Value(this.mHandle, KeyIsLoaderFactoryP2PStragetyLevel, aVMDLDataLoaderConfigure.mP2PStragetyLevel);
        _setInt64Value(this.mHandle, KeyIsConnectPoolStragetyValue, aVMDLDataLoaderConfigure.mConnectPoolStragetyValue);
        _setIntValue(this.mHandle, KeyIsMaxKeepAliveHostNum, aVMDLDataLoaderConfigure.mMaxAliveHostNum);
        _setIntValue(this.mHandle, KeyIsSetFileExtendSize, aVMDLDataLoaderConfigure.mFileExtendSizeKB);
        _setIntValue(this.mHandle, KeyIsSetMinAllowSpeed, aVMDLDataLoaderConfigure.mMinAllowSpeed);
        _setIntValue(this.mHandle, KeyIsSetEnableOwnVdpPreloadNotify, aVMDLDataLoaderConfigure.mEnableOwnVDPPreloadNotify);
        _setIntValue(this.mHandle, KeyIsEnableEarlyData, aVMDLDataLoaderConfigure.mEnableEarlyData);
        _setIntValue(this.mHandle, KeyIsEnableSpeedPredict, aVMDLDataLoaderConfigure.mEnableSpeedPredict);
        _setIntValue(this.mHandle, KeyIsEnableSpeedEngine, aVMDLDataLoaderConfigure.mEnableSpeedEngine);
        _setIntValue(this.mHandle, KeyIsEnableSpeedReport, aVMDLDataLoaderConfigure.mEnableSpeedReport);
        _setIntValue(this.mHandle, KeyIsEnableUseOriginalUrl, aVMDLDataLoaderConfigure.mEnableUseOriginalUrl);
        _setIntValue(this.mHandle, KeyIsEnableLoaderLogExtractUrls, aVMDLDataLoaderConfigure.mEnableLoaderLogExtractUrls);
        _setIntValue(this.mHandle, KeyIsMaxLoaderLogNum, aVMDLDataLoaderConfigure.mMaxLoaderLogNum);
        _setIntValue(this.mHandle, KeyIsCheckContentTypeMethod, aVMDLDataLoaderConfigure.mCheckContentTypeMethod);
        _setIntValue(this.mHandle, KeyIsThreadStackSizeLevel, aVMDLDataLoaderConfigure.mThreadStackSizeLevel);
        _setIntValue(this.mHandle, KeyIsEnableThreadPoolCheckIdle, aVMDLDataLoaderConfigure.mEnableThreadPoolCheckIdle);
        _setIntValue(this.mHandle, KeyIsThreadPoolIdleTTLSecond, aVMDLDataLoaderConfigure.mThreadPoolTTLSecond);
        _setIntValue(this.mHandle, KeyIsThreadPoolMinCount, aVMDLDataLoaderConfigure.mThreadPoolMinCount);
        _setIntValue(this.mHandle, KeyIsNonBlockRangeMode, aVMDLDataLoaderConfigure.mNonBlockRangeMode);
        if (aVMDLDataLoaderConfigure.mNonBlockRangeMaxSizeKB > 0) {
            _setIntValue(this.mHandle, KeyIsNonBlockRangeMaxSizeKB, aVMDLDataLoaderConfigure.mNonBlockRangeMaxSizeKB);
        }
        _setIntValue(this.mHandle, KeyIsNetUnreachableStopRetry, aVMDLDataLoaderConfigure.mNetUnreachableStopRetry);
        _setIntValue(this.mHandle, KeyIsEnableWaitNetReachable, aVMDLDataLoaderConfigure.mEnableWaitNetReachable);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorMinAllowLoadSize, aVMDLDataLoaderConfigure.mMonitorMinAllowLoadSize);
        _setInt64Value(this.mHandle, KeyIsLoadMonitorTimeInternal, aVMDLDataLoaderConfigure.mMonitorTimeInternal);
        _setStringValue(this.mHandle, KeyIsSocketTrainingCenterConfigStr, aVMDLDataLoaderConfigure.mSocketTraingCenterConfigStr);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mEnginePortraitStr)) {
            _setStringValue(this.mHandle, KeyIsEnginePortraitStr, aVMDLDataLoaderConfigure.mEnginePortraitStr);
        }
        _setStringValue(this.mHandle, KeyIsCacheDirListsStr, aVMDLDataLoaderConfigure.mCacheDirListsStr);
        _setStringValue(this.mHandle, KeyIsP2PConfigStr, aVMDLDataLoaderConfigure.mP2PConfigStr);
        _setIntValue(this.mHandle, KeyIsSetSocketRecvBuffer, aVMDLDataLoaderConfigure.mSocketRecvBufferSize);
        _setIntValue(this.mHandle, KeyIsEnableByteMediaNetLoader, aVMDLDataLoaderConfigure.mEnableByteMediaNetLoader);
        _setIntValue(this.mHandle, KeyIsByteMediaNetLoaderCronetBufSizeKB, aVMDLDataLoaderConfigure.mByteMediaNetLoaderCronetBufSizeKB);
        _setIntValue(this.mHandle, KeyIsEnableCellularUp, aVMDLDataLoaderConfigure.mEnableCellularUp);
        _setIntValue(this.mHandle, KeyIsCloseThreadPool, aVMDLDataLoaderConfigure.mCloseThreadPool);
        _setIntValue(this.mHandle, KeyIsMaxIpNum, aVMDLDataLoaderConfigure.mMaxIpNum);
        _setIntValue(this.mHandle, KeyIsIgnoreTextSpeedTest, aVMDLDataLoaderConfigure.mIgnoreTextSpeedTest);
        _setIntValue(this.mHandle, KeyIsEnableOptimizeRange, aVMDLDataLoaderConfigure.mEnableOptimizeRange);
        _setIntValue(this.mHandle, KeyIsCheckCacheDir, aVMDLDataLoaderConfigure.mCheckCacheDir);
        _setIntValue(this.mHandle, KeyIsEnableUseGroupId, aVMDLDataLoaderConfigure.mEnableUseGroupId);
        _setIntValue(this.mHandle, KeyIsEnableMissReasonRecord, aVMDLDataLoaderConfigure.mEnableMissReason);
        _setIntValue(this.mHandle, KeyIsPreloadInfoRecordMaxCnt, aVMDLDataLoaderConfigure.mPreloadInfoRecordMaxCnt);
        _setIntValue(this.mHandle, KeyIsEnableTraceidPreloadLog, aVMDLDataLoaderConfigure.mEnableTraceIdPreloadLog);
        if (aVMDLDataLoaderConfigure.mCloseLocalServer > 0) {
            _setIntValue(this.mHandle, KeyIsCloseLocalServer, aVMDLDataLoaderConfigure.mCloseLocalServer);
        }
        if (aVMDLDataLoaderConfigure.mGetCookieTokenLevel > 0) {
            _setIntValue(this.mHandle, KeyIsGetCookieTokenLevel, aVMDLDataLoaderConfigure.mGetCookieTokenLevel);
        }
        _setIntValue(this.mHandle, KeyIsDisableRecentCache, aVMDLDataLoaderConfigure.mDisableRecentCache);
        _setIntValue(this.mHandle, KeyIsUpdateCacheFileInternal, aVMDLDataLoaderConfigure.mUpdateCacheFileInternal);
        _setIntValue(this.mHandle, KeyIsEnableCustomDirSearchAllPath, aVMDLDataLoaderConfigure.mEnableCustomDirSearchAllPath);
        _setIntValue(this.mHandle, KeyIsHlsTsFileKeyGenerateType, aVMDLDataLoaderConfigure.mHlsTsFileKeyGenerateType);
        _setStringValue(this.mHandle, KeyIsProtectCacheDirAvoidClear, aVMDLDataLoaderConfigure.mProtectCacheDirsStr);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mBusinessDirControlConfigStr)) {
            _setStringValue(this.mHandle, KeyIsBusinessDirControlConfig, aVMDLDataLoaderConfigure.mBusinessDirControlConfigStr);
        }
        if (aVMDLDataLoaderConfigure.mMaxCacheSize64 > 0) {
            _setInt64Value(this.mHandle, KeyIsMaxCacheSizeForDefaultDir, aVMDLDataLoaderConfigure.mMaxCacheSize64);
        }
        if (aVMDLDataLoaderConfigure.mEnableEventInfo > 0) {
            _setIntValue(this.mHandle, KeyIsEnableEventInfo, aVMDLDataLoaderConfigure.mEnableEventInfo);
        }
        if (aVMDLDataLoaderConfigure.mDownLogMaxSize > 0) {
            _setIntValue(this.mHandle, KeyIsSetDownLogMaxSize, aVMDLDataLoaderConfigure.mDownLogMaxSize);
        }
        if (aVMDLDataLoaderConfigure.mEnableStorageModule > 0) {
            _setIntValue(this.mHandle, 10000, aVMDLDataLoaderConfigure.mEnableStorageModule);
            if (aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBNM > 0) {
                _setIntValue(this.mHandle, 10001, aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBNM);
            }
            if (aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBLS > 0) {
                _setIntValue(this.mHandle, KeyIsStoPlayDldWinSizeKBLS, aVMDLDataLoaderConfigure.mStoPlayDldWinSizeKBLS);
            }
            if (aVMDLDataLoaderConfigure.mStoRingBufferSizeKB > 0) {
                _setIntValue(this.mHandle, KeyIsStoRingBufferSizeKB, aVMDLDataLoaderConfigure.mStoRingBufferSizeKB);
            }
            if (aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh1 > 0) {
                _setIntValue(this.mHandle, KeyIsStoIoWriteLimitKBTh1, aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh1);
            }
            if (aVMDLDataLoaderConfigure.mStoMaxIdleTimeSec > 0) {
                _setIntValue(this.mHandle, KeyIsStoMaxIdleTimeSec, aVMDLDataLoaderConfigure.mStoMaxIdleTimeSec);
            }
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mStoStrategyConfig)) {
            _setStringValue(this.mHandle, KeyIsStoStrategyConfig, aVMDLDataLoaderConfigure.mStoStrategyConfig);
        }
        if (aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh2 > 0) {
            _setIntValue(this.mHandle, KeyIsStoIoWriteLimitKBTh2, aVMDLDataLoaderConfigure.mStoIoWriteLimitKBTh2);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mP2PCostTag)) {
            _setStringValue(this.mHandle, KeyIsP2PCostTag, aVMDLDataLoaderConfigure.mP2PCostTag);
        }
        _setIntValue(this.mHandle, KeyIsIgnorePlayInfo, aVMDLDataLoaderConfigure.mIgnorePlayInfo);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mSettingsDomain)) {
            _setStringValue(this.mHandle, KeyIsSetSettingsDomain, aVMDLDataLoaderConfigure.mSettingsDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDmDomain)) {
            _setStringValue(this.mHandle, KeyIsSetDMDomain, aVMDLDataLoaderConfigure.mDmDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mForesightDomain)) {
            _setStringValue(this.mHandle, KeyIsSetForesightDomain, aVMDLDataLoaderConfigure.mForesightDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDomains)) {
            _setStringValue(this.mHandle, KeyIsSetDomains, aVMDLDataLoaderConfigure.mDomains);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyDomain)) {
            _setStringValue(this.mHandle, KeyIsSetKeyDomain, aVMDLDataLoaderConfigure.mKeyDomain);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mKeyToken)) {
            _setStringValue(this.mHandle, KeyIsSetKeyToken, aVMDLDataLoaderConfigure.mKeyToken);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mDynamicPreconnectConfigStr)) {
            _setStringValue(this.mHandle, KeyIsDynamicPreconnectConfigStr, aVMDLDataLoaderConfigure.mDynamicPreconnectConfigStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mCustomUA)) {
            _setStringValue(this.mHandle, KeyIsCustomUA, aVMDLDataLoaderConfigure.mCustomUA);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mFileRingBufferOptStr)) {
            _setStringValue(this.mHandle, KeyIsFileRingBufferOptStr, aVMDLDataLoaderConfigure.mFileRingBufferOptStr);
        }
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mFileKeyRule)) {
            _setStringValue(this.mHandle, KeyIsFileKeyRule, aVMDLDataLoaderConfigure.mFileKeyRule);
        }
        _setIntValue(this.mHandle, KeyIsEnableOkHttpLoader, aVMDLDataLoaderConfigure.mEnableOkHttpLoader);
        _setIntValue(this.mHandle, KeyIsEnableP2PUpload, aVMDLDataLoaderConfigure.mEnableP2pUpload);
        _setIntValue(this.mHandle, KeyIsSetDevDiskSizeMB, aVMDLDataLoaderConfigure.mDevDiskSizeMB);
        _setIntValue(this.mHandle, KeyIsSetDevMemorySizeMB, aVMDLDataLoaderConfigure.mDevMemorySizeMB);
        if (!TextUtils.isEmpty(aVMDLDataLoaderConfigure.mVdpExtGlobalInfo)) {
            _setStringValue(this.mHandle, KeyIsSetVdpExtGlobalInfo, aVMDLDataLoaderConfigure.mVdpExtGlobalInfo);
        }
        _setIntValue(this.mHandle, KeyIsEnableMultiDownloadPath, aVMDLDataLoaderConfigure.mEnableMultiDownloadPath);
        _setIntValue(this.mHandle, KeyIsEnableFileMutexOptimize, aVMDLDataLoaderConfigure.mEnableFileMutexOptimize);
        _setIntValue(this.mHandle, KeyIsSkipCDNBeforeExpiredSec, aVMDLDataLoaderConfigure.mSkipCDNBeforeExpiredSec);
        _setIntValue(this.mHandle, KeyIsNetUnreachableTimeout, aVMDLDataLoaderConfigure.mNetUnreachableTimeout);
        if (aVMDLDataLoaderConfigure.mDeviceScoreEx > 0) {
            _setIntValue(this.mHandle, KeyIsDeviceScoreEx, aVMDLDataLoaderConfigure.mDeviceScoreEx);
        }
        if (aVMDLDataLoaderConfigure.mSessionCacheInterval > 0) {
            _setIntValue(this.mHandle, KeyIsSessionCacheInterval, aVMDLDataLoaderConfigure.mSessionCacheInterval);
        }
        if (aVMDLDataLoaderConfigure.mFileManagerInterval > 0) {
            _setIntValue(this.mHandle, KeyIsFileManagerInterval, aVMDLDataLoaderConfigure.mFileManagerInterval);
        }
        AVMDLDNSParser.setIntValue(0, this.mConfigure.mDNSMainType);
        AVMDLDNSParser.setIntValue(1, this.mConfigure.mDNSBackType);
        AVMDLDNSParser.setIntValue(2, this.mConfigure.mDefaultExpiredTime);
        AVMDLDNSParser.setIntValue(3, this.mConfigure.mMainToBackUpDelayedTime);
    }

    private String createFilePathBaseDir(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.charAt(str.length() - 1) == '/') {
            str3 = str + str2;
        } else {
            str3 = str + "/" + str2;
        }
        if (!TextUtils.isEmpty(str3)) {
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return str3;
    }

    public void setConfigure(AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure) {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                this.mConfigure = aVMDLDataLoaderConfigure;
                aVMDLDataLoaderConfigure.ParseJsonConfig();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public static synchronized int init(boolean z) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z;
            if (!mIsLibraryLoaded) {
                if (!BoringsslLoaderWrapper.loadBoringssl()) {
                    Log.e("ttmn", "load boringssl fail!");
                }
                loadAVMDLBaseLibrary();
                try {
                    System.loadLibrary("avmdl");
                    mIsLibraryLoaded = true;
                } catch (UnsatisfiedLinkError e) {
                    mLoadFailMsg = "Can't load avmdl library: " + e;
                    Log.e("ttmn", "Can't load avmdl library: " + e);
                } catch (Throwable th) {
                    mLoadFailMsg = "other exception when loading avmdl library: " + th;
                    Log.e("ttmn", "other exception when loading avmdl library: " + th);
                }
                if (!VcnlibloadWrapper.tryLoadVcnverifylib()) {
                    Log.e("ttmn", "Can't load vcnverify lib ");
                }
                tryLoadTTNetLoaderPlugin();
                tryLoadByteMediaNetLoaderPlugin();
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }

    public static synchronized int init(boolean z, boolean z2) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            mIsLibraryLoaded = z;
            if (!mIsLibraryLoaded) {
                if (!BoringsslLoaderWrapper.loadBoringssl()) {
                    Log.e("ttmn", "load boringssl fail!");
                }
                loadAVMDLBaseLibrary();
                try {
                    try {
                        System.loadLibrary("avmdl");
                        mIsLibraryLoaded = true;
                    } catch (Throwable th) {
                        mLoadFailMsg = "other exception when loading avmdl library: " + th;
                        Log.e("ttmn", "other exception when loading avmdl library: " + th);
                    }
                } catch (UnsatisfiedLinkError e) {
                    mLoadFailMsg = "Can't load avmdl library: " + e;
                    Log.e("ttmn", "Can't load avmdl library: " + e);
                }
                if (!VcnlibloadWrapper.tryLoadVcnverifylib()) {
                    Log.e("ttmn", "Can't load vcnverify lib ");
                }
                if (z2) {
                    Log.e("ttmn", "try to load pcdn lib");
                    try {
                        System.loadLibrary("avmdlp2p");
                    } catch (UnsatisfiedLinkError e2) {
                        Log.e("ttmn", "Can't load avmdlp2p library: " + e2);
                    } catch (Throwable th2) {
                        Log.e("ttmn", "other exception when loading avmdl library: " + th2);
                    }
                }
                tryLoadTTNetLoaderPlugin();
                tryLoadByteMediaNetLoaderPlugin();
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }

    public static synchronized int init(boolean z, boolean z2, boolean z3) {
        int init;
        synchronized (AVMDLDataLoader.class) {
            init = init(z, z2, z3, false);
        }
        return init;
    }

    public static synchronized int init(boolean z, boolean z2, boolean z3, boolean z4) {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            Locale locale = Locale.US;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(z ? 1 : 0);
            objArr[1] = Integer.valueOf(z2 ? 1 : 0);
            objArr[2] = Integer.valueOf(z3 ? 1 : 0);
            AVMDLLog.m228e(TAG, String.format(locale, "init loadLibrary:%d, needLoadP2PLib:%d, useV2:%d", objArr));
            mIsLibraryLoaded = z;
            if (!mIsLibraryLoaded) {
                if (!BoringsslLoaderWrapper.loadBoringssl()) {
                    Log.e("ttmn", "load boringssl fail!");
                }
                loadAVMDLBaseLibrary();
                if (z3) {
                    Log.e("ttmn", "try load avmdlv2");
                    try {
                        System.loadLibrary("avmdlv2");
                        mIsLibraryLoaded = true;
                        Log.e("ttmn", "load avmdlv2 suc");
                        if (z2) {
                            Log.e("ttmn", "try to load pcdn lib");
                        }
                    } catch (UnsatisfiedLinkError e) {
                        Log.e("ttmn", "load avmdlv2 failed: " + e);
                        Log.e("ttmn", "load avmdlv2 failed msg:" + e.getMessage());
                    }
                }
                if (!mIsLibraryLoaded) {
                    try {
                        try {
                            System.loadLibrary("avmdl");
                            mIsLibraryLoaded = true;
                        } catch (Throwable th) {
                            mLoadFailMsg = "other exception when loading avmdl library: " + th;
                            Log.e("ttmn", "other exception when loading avmdl library: " + th);
                        }
                    } catch (UnsatisfiedLinkError e2) {
                        mLoadFailMsg = "Can't load avmdl library: " + e2;
                        Log.e("ttmn", "Can't load avmdl library: " + e2);
                    }
                    if (!VcnlibloadWrapper.tryLoadVcnverifylib()) {
                        Log.e("ttmn", "Can't load vcnverify lib ");
                    }
                    if (z2) {
                        Log.e("ttmn", "try to load pcdn lib");
                        try {
                            try {
                                System.loadLibrary("avmdlp2p");
                            } catch (Throwable th2) {
                                Log.e("ttmn", "other exception when loading avmdl library: " + th2);
                            }
                        } catch (UnsatisfiedLinkError e3) {
                            Log.e("ttmn", "Can't load avmdlp2p library: " + e3);
                        }
                    }
                    tryLoadTTNetLoaderPlugin();
                    tryLoadByteMediaNetLoaderPlugin();
                }
            }
            return !mIsLibraryLoaded ? -1 : 0;
        }
    }

    public static synchronized String getLoadFailMsg() {
        String str;
        synchronized (AVMDLDataLoader.class) {
            str = mLoadFailMsg;
        }
        return str;
    }

    public static synchronized int initDependency() {
        synchronized (AVMDLDataLoader.class) {
            if (!BoringsslLoaderWrapper.loadBoringssl()) {
                Log.e("ttmn", "load boringssl fail!");
            }
        }
        return 0;
    }

    public static synchronized int initWithLibraryManager() {
        synchronized (AVMDLDataLoader.class) {
            if (mIsLibraryLoaded) {
                return 0;
            }
            if (AVMDLLibraryManager.loadLibraries()) {
                mIsLibraryLoaded = true;
            }
            return mIsLibraryLoaded ? 0 : -1;
        }
    }

    public static synchronized void loadAVMDLBaseLibrary() {
        synchronized (AVMDLDataLoader.class) {
            initDependency();
            try {
                System.loadLibrary("avmdlbase");
            } catch (UnsatisfiedLinkError e) {
                Log.e("ttmn", "Can't load avmdlbase library: " + e);
            } catch (Throwable th) {
                Log.e("ttmn", "other exception when loading avmdlbase library: " + th);
            }
        }
    }

    public static synchronized boolean tryLoadTTNetLoaderPlugin() {
        boolean z;
        synchronized (AVMDLDataLoader.class) {
            z = mIsMdlTtnetPluginLoaded;
        }
        return z;
    }

    public static synchronized boolean tryLoadByteMediaNetLoaderPlugin() {
        boolean z;
        synchronized (AVMDLDataLoader.class) {
            Log.e("ttmdljava", "do load bytemedianet");
            Log.e("ttmdljava", "end do load bytemedianet");
            z = mIsMdlByteMediaNetPluginLoaded;
        }
        return z;
    }

    public int start() {
        if (this.mState == 1) {
            return 0;
        }
        ImageLoader.get().setInnerDataLoader(this);
        initNativeHandle();
        new Thread(new Runnable() { // from class: com.ss.mediakit.medialoader.AVMDLDataLoader.2
            @Override // java.lang.Runnable
            public void run() {
                AVMDLDataLoader aVMDLDataLoader = AVMDLDataLoader.this;
                aVMDLDataLoader.getDownloader(-1, aVMDLDataLoader.mDownloaderCallback);
                AVMDLDataLoader.this.startInternal();
            }
        }).start();
        return 0;
    }

    public int startPcdn() {
        if (this.mState != 1) {
            return -1;
        }
        new Thread(new Runnable() { // from class: com.ss.mediakit.medialoader.AVMDLDataLoader.3
            @Override // java.lang.Runnable
            public void run() {
                AVMDLDataLoader.this.startPcdnInternal();
            }
        }).start();
        return 0;
    }

    public long syncCopyOperation(AVMDLCopyOperation aVMDLCopyOperation) {
        long j = -1;
        int i = 1;
        if (this.mState != 1 || aVMDLCopyOperation == null || aVMDLCopyOperation.mFileKey == null || aVMDLCopyOperation.mFileKey.isEmpty() || aVMDLCopyOperation.mDestPath == null || aVMDLCopyOperation.mDestPath.isEmpty()) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    String str = aVMDLCopyOperation.mFileKey;
                    String str2 = aVMDLCopyOperation.mCustomDir;
                    String str3 = aVMDLCopyOperation.mDestPath;
                    if (!aVMDLCopyOperation.mForceCopyUnfinished) {
                        i = 0;
                    }
                    j = _copyFileWithDir64(j2, str, str2, str3, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public int asyncCopyOperation(AVMDLCopyOperation aVMDLCopyOperation) {
        Handler handler;
        if (this.mState != 1 || (handler = this.mLogHandler) == null) {
            return -1;
        }
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.what = 23;
        obtainMessage.obj = aVMDLCopyOperation;
        obtainMessage.sendToTarget();
        return 0;
    }

    public long copyFile(String str, String str2) {
        long j = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _copyFile64(j2, str, str2);
                }
            } catch (UnsatisfiedLinkError e) {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    try {
                        j = _copyFile(j3, str, str2);
                    } catch (UnsatisfiedLinkError e2) {
                        e2.printStackTrace();
                    }
                }
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long copyFile(String str, String str2, boolean z) {
        long j = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mWriteLock.lock();
        boolean z2 = false;
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _copyFileWithForceFlag64(j2, str, str2, z ? 1 : 0);
                }
            } catch (UnsatisfiedLinkError e) {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    try {
                        j = _copyFileWithForceFlag(j3, str, str2, z ? 1 : 0);
                    } catch (UnsatisfiedLinkError e2) {
                        e2.printStackTrace();
                        z2 = true;
                    }
                    if (z2 && !z) {
                        j = copyFile(str, str2);
                    }
                }
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long copyFile(String str, String str2, String str3) {
        long j = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _copyFileWithCustomDir64(j2, str, str2, str3);
                }
            } catch (UnsatisfiedLinkError e) {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    try {
                        j = _copyFileWithCustomDir(j3, str, str2, str3);
                    } catch (UnsatisfiedLinkError e2) {
                        e2.printStackTrace();
                    }
                }
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    private void copyInternal(AVMDLCopyOperation aVMDLCopyOperation) {
        if (aVMDLCopyOperation == null || TextUtils.isEmpty(aVMDLCopyOperation.mFileKey) || TextUtils.isEmpty(aVMDLCopyOperation.mDestPath)) {
            AVMDLLog.m226d(TAG, "copy file invalid filekey or destpath is null");
            if (aVMDLCopyOperation == null || aVMDLCopyOperation.mListener == null) {
                return;
            }
            aVMDLCopyOperation.mListener.onCopyComplete(false, -1, "invalid parameter");
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    int _getIsFileCacheComplete = _getIsFileCacheComplete(j, aVMDLCopyOperation.mFileKey);
                    if (_getIsFileCacheComplete == 1) {
                        _copyInternal(aVMDLCopyOperation);
                    } else if (_getIsFileCacheComplete == -1) {
                        if (aVMDLCopyOperation.mListener != null) {
                            aVMDLCopyOperation.mListener.onCopyComplete(false, -6, "cache file read writer failed.");
                        }
                    } else if (aVMDLCopyOperation.mForceCopyUnfinished) {
                        _copyInternal(aVMDLCopyOperation);
                    } else if (aVMDLCopyOperation.mWaitIfCaching) {
                        int _haveRunningPlayTask = _haveRunningPlayTask(this.mHandle, aVMDLCopyOperation.mFileKey);
                        AVMDLLog.m226d(TAG, "try download play " + aVMDLCopyOperation.mFileKey + " result: " + _haveRunningPlayTask);
                        if (_haveRunningPlayTask > 0) {
                            this.mWaitingCopyItem.put(aVMDLCopyOperation.mFileKey, aVMDLCopyOperation);
                        } else if (aVMDLCopyOperation.mListener != null) {
                            aVMDLCopyOperation.mListener.onCopyComplete(false, -4, "file key not playing.");
                        }
                    } else if (aVMDLCopyOperation.mListener != null) {
                        aVMDLCopyOperation.mListener.onCopyComplete(false, -3, "cache not finish.");
                    }
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                if (aVMDLCopyOperation.mListener != null) {
                    aVMDLCopyOperation.mListener.onCopyComplete(false, -2, "medialoader not running");
                }
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    private void _copyInternal(AVMDLCopyOperation aVMDLCopyOperation) {
        long copyFile;
        if (TextUtils.isEmpty(aVMDLCopyOperation.mCustomDir)) {
            copyFile = copyFile(aVMDLCopyOperation.mFileKey, aVMDLCopyOperation.mDestPath, aVMDLCopyOperation.mForceCopyUnfinished);
        } else {
            copyFile = copyFile(aVMDLCopyOperation.mFileKey, aVMDLCopyOperation.mCustomDir, aVMDLCopyOperation.mDestPath);
        }
        AVMDLFileInfo cacheInfo = getCacheInfo(aVMDLCopyOperation.mFileKey);
        if (cacheInfo == null) {
            if (aVMDLCopyOperation.mListener != null) {
                aVMDLCopyOperation.mListener.onCopyComplete(false, -5, "copy failed. file info null " + copyFile);
                return;
            }
            return;
        }
        if (aVMDLCopyOperation.mListener != null) {
            aVMDLCopyOperation.mListener.onFileInfo(cacheInfo);
        }
        AVMDLLog.m226d(TAG, "copy file result: " + copyFile);
        if (aVMDLCopyOperation.mListener != null) {
            if (copyFile == cacheInfo.mCacheSize || copyFile == cacheInfo.mContentLenght || copyFile == 0) {
                aVMDLCopyOperation.mListener.onCopyComplete(true, 0, "copy success.");
            } else {
                aVMDLCopyOperation.mListener.onCopyComplete(false, -5, "copy failed.copy error code " + copyFile);
            }
        }
    }

    private void handleCopyMsg(AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo) {
        if (aVMDLDataLoaderNotifyInfo == null || TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
            return;
        }
        if (aVMDLDataLoaderNotifyInfo.what == 3 || aVMDLDataLoaderNotifyInfo.what == 51) {
            String[] split = aVMDLDataLoaderNotifyInfo.logInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length < 4) {
                return;
            }
            long longValue = Long.valueOf(split[0]).longValue();
            long longValue2 = Long.valueOf(split[1]).longValue();
            if (longValue2 > 0 || aVMDLDataLoaderNotifyInfo.what == 4) {
                String str = split[2];
                if (this.mWaitingCopyItem.containsKey(str)) {
                    final AVMDLCopyOperation aVMDLCopyOperation = this.mWaitingCopyItem.get(str);
                    if (longValue == longValue2) {
                        if (aVMDLCopyOperation == null || TextUtils.isEmpty(aVMDLCopyOperation.mFileKey)) {
                            return;
                        }
                        long copyFile = copyFile(aVMDLCopyOperation.mFileKey, aVMDLCopyOperation.mDestPath, aVMDLCopyOperation.mForceCopyUnfinished);
                        if (aVMDLCopyOperation.mListener != null) {
                            if (copyFile == 0) {
                                aVMDLCopyOperation.mListener.onCopyComplete(true, 0, "copy success.");
                                return;
                            } else {
                                aVMDLCopyOperation.mListener.onCopyComplete(false, -5, "copy failed.");
                                return;
                            }
                        }
                        return;
                    }
                    if (aVMDLDataLoaderNotifyInfo.what == 51) {
                        if (_haveRunningPlayTask(this.mHandle, aVMDLCopyOperation.mFileKey) > 0) {
                            AVMDLLog.m225d(TAG, new AVMDLLog.LogMessageSupplier() { // from class: com.ss.mediakit.medialoader.AVMDLDataLoader$$ExternalSyntheticLambda0
                                @Override // com.ss.mediakit.medialoader.AVMDLLog.LogMessageSupplier
                                public final String get() {
                                    String format;
                                    format = String.format(Locale.US, "have running playtask skip, %s", AVMDLCopyOperation.this.mFileKey);
                                    return format;
                                }
                            });
                        } else if (aVMDLCopyOperation.mListener != null) {
                            aVMDLCopyOperation.mListener.onCopyComplete(false, -3, "copy failed.");
                        }
                    }
                }
            }
        }
    }

    public boolean isRunning() {
        return this.mState == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startInternal() {
        this.mWriteLock.lock();
        try {
            if (this.mState != 1) {
                initLogThread(this);
                if (this.mHandle != 0) {
                    if (this.mConfigure.mLoadP2pPluginAfterMdlStart == 0) {
                        this.mTryedLoadP2pPlugin = true;
                        tryLoadP2pPluginInternal();
                    }
                    tryLoadQuicPluginInternal();
                    setConfigureInternal(this.mConfigure);
                    if (_start(this.mHandle) >= 0) {
                        this.mState = 1;
                    }
                }
            }
            this.mWriteLock.unlock();
            if (this.mConfigure.mEnableBenchMarkIOSpeed > 0) {
                int testFileIOSpeed = testFileIOSpeed();
                AVMDLLog.m226d("BENCHMARKIO", String.format(Locale.US, "test io average speed:%d", Integer.valueOf(testFileIOSpeed)));
                if (testFileIOSpeed > 0) {
                    setIntValue(KeyIsMarkedFileIOSpeed, testFileIOSpeed);
                }
            }
            AVMDLStartCompleteListener aVMDLStartCompleteListener = this.mStartCompleteListener;
            if (aVMDLStartCompleteListener != null) {
                aVMDLStartCompleteListener.onStartComplete();
            }
            if (this.mConfigure.mLoadP2pPluginAfterMdlStart != 0) {
                this.mWriteLock.lock();
                if (!this.mTryedLoadP2pPlugin) {
                    this.mTryedLoadP2pPlugin = true;
                    tryLoadP2pPluginInternal();
                }
            }
            if (this.mState == 1 && this.mConfigure.mEnableCellularUp > 0) {
                AVMDLLog.m226d(TAG, "start try up cellular");
                AVMDLMultiNetwork.alwayUpCellular(getApplicationContext());
                AVMDLLog.m226d(TAG, "end try up cellular");
            }
            AVMDLMultiNetwork.registerNetworkChangeCallback(getApplicationContext());
        } finally {
            this.mWriteLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPcdnInternal() {
        this.mWriteLock.lock();
        try {
            try {
                if (this.mState == 1) {
                    long j = this.mHandle;
                    if (j != 0 && _startPcdn(j) >= 0) {
                        AVMDLLog.m226d(TAG, "delay start pcdn succ");
                    }
                }
            } finally {
                this.mWriteLock.unlock();
            }
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Can't start pcdn: " + e);
        } catch (Throwable th) {
            Log.e(TAG, "Can't start pcdn: " + th);
        }
    }

    private void tryLoadP2pPluginInternal() {
        if (this.mPluginLibraryLoader != null) {
            try {
                AVMDLLog.m228e(TAG, "try to load p2p lib by mdl");
                boolean loadLibrary = this.mPluginLibraryLoader.loadLibrary("avmdlp2p");
                Locale locale = Locale.US;
                int i = 1;
                Object[] objArr = new Object[1];
                if (!loadLibrary) {
                    i = 0;
                }
                objArr[0] = Integer.valueOf(i);
                AVMDLLog.m228e(TAG, String.format(locale, "load p2p lib by mdl result:%d", objArr));
            } catch (UnsatisfiedLinkError e) {
                Log.e(TAG, "Can't load p2p library: " + e);
            } catch (Throwable th) {
                Log.e(TAG, "Can't load p2p library: " + th);
            }
        }
    }

    private void tryLoadQuicPluginInternal() {
        AVMDLDataLoaderConfigure aVMDLDataLoaderConfigure = this.mConfigure;
        if (aVMDLDataLoaderConfigure != null) {
            int i = aVMDLDataLoaderConfigure.mEnableQuicRegisterWithoutPlugin;
        }
    }

    private int testFileIOSpeed() {
        String format;
        double d;
        if (TextUtils.isEmpty(this.mConfigure.mCacheDir)) {
            return -1;
        }
        if (this.mConfigure.mCacheDir.charAt(this.mConfigure.mCacheDir.length() - 1) == '/') {
            format = String.format(Locale.US, "%siospeed", this.mConfigure.mCacheDir);
        } else {
            format = String.format(Locale.US, "%s/iospeed", this.mConfigure.mCacheDir);
        }
        String str = format;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(str, "iospeed.cach");
        if (file2.exists()) {
            file2.delete();
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
            double d2 = 0.0d;
            double d3 = 0.0d;
            for (int i = 0; i < 30; i++) {
                try {
                    d = testFileIO(str, i, randomAccessFile);
                } catch (Exception e) {
                    e = e;
                    d = 0.0d;
                }
                try {
                    AVMDLLog.m226d("BENCHMARKIO", String.format(Locale.US, "num:%d result:%f", Integer.valueOf(i), Double.valueOf(d)));
                } catch (Exception e2) {
                    e = e2;
                    AVMDLLog.m226d("BENCHMARKIO", "test fileio exception:" + e);
                    e.printStackTrace();
                    if (d > 0.0d) {
                        try {
                            d3 += d;
                            d2 += 1.0d;
                        } catch (Exception unused) {
                        }
                    }
                }
                if (d > 0.0d && i >= 20) {
                    d3 += d;
                    d2 += 1.0d;
                }
            }
            randomAccessFile.close();
            file2.delete();
            if (d2 > 0.0d) {
                return (int) (d3 / d2);
            }
            return 0;
        } catch (Exception e3) {
            AVMDLLog.m226d("BENCHMARKIO", "create accefile exception:" + e3);
            return -1;
        }
    }

    private double testFileIO(String str, int i, RandomAccessFile randomAccessFile) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return -1.0d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        randomAccessFile.seek(i);
        byte[] bArr = new byte[4096];
        for (int i2 = 0; i2 < 200; i2++) {
            Thread.sleep(5);
            randomAccessFile.write(bArr, 0, 1024);
        }
        long currentTimeMillis2 = ((System.currentTimeMillis() - currentTimeMillis) - 1000) + 0;
        if (currentTimeMillis2 <= 0) {
            return -1.0d;
        }
        AVMDLLog.m226d("BENCHMARKIO", String.format(Locale.US, "size:%d costtime:%d", 819200, Long.valueOf(currentTimeMillis2)));
        return 819200 / currentTimeMillis2;
    }

    public void stop() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _stop(j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void close() {
        this.mWriteLock.lock();
        if (this.mState != 1) {
            return;
        }
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _close(j);
                    this.mHandle = 0L;
                    this.mState = 5;
                    Handler handler = this.mHandler;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                        this.mHandler = null;
                    }
                    Handler handler2 = this.mLogHandler;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.mLogHandler.getLooper().quit();
                        this.mLogHandler = null;
                        this.mMsgThread = null;
                    }
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAll() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancelAll(j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cancelAllPreloadWaitReqs() {
        if (this.mState != 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancelAllPreloadWaitReqs(j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void cancel(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cancel(j, str);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void clearAllCaches() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _clearAllCaches(j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void forceClearAllCaches() {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _forceClearAllCaches(j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void cleanSpecifiedCacheDir(String str, int i) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _cleanSpecifiedCacheDir(j, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void tryToClearCachesByUsedTime(long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            long j2 = this.mHandle;
            if (j2 != 0) {
                _clearCachesByUsedTime(j2, j);
            }
        } catch (UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void cleanCacheDirForExpiredFiles(String str, long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            long j2 = this.mHandle;
            if (j2 != 0) {
                _cleanCacheDirForExpiredFiles(j2, str, j);
            }
        } catch (UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public long tryToClearAndGetCachesByUsedTime(long j, boolean z) {
        long j2 = 0;
        int i = 1;
        if (this.mState != 1) {
            return 0L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    if (!z) {
                        i = 0;
                    }
                    j2 = _clearAndGetCachesByUsedTime(j3, j, i);
                }
            } catch (UnsatisfiedLinkError e) {
                Log.e("testcacheinterface", "call exception" + e.getMessage());
            }
            return j2;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void removeFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _removeCacheFile(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void forceRemoveFileCache(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _forceRemoveCacheFile(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void makeFileAutoDeleteFlag(String str, int i) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _makeFileAutoDeleteFlag(j, str, i);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void preloadResource(String str, int i) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || i == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _preloadResource(j, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadResource(String str, long j) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || j == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    _preloadResource(j2, str, j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadResource(String str, long j, long j2) {
        if (this.mState != 1 || TextUtils.isEmpty(str) || j2 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    _preloadResourceWithOffset(j3, str, j, j2);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preloadGroupResource(String str, String str2, long j, long j2) {
        if (this.mState != 1 || TextUtils.isEmpty(str2) || j2 == 0) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    _preloadGroupResource(j3, str, str2, j, j2);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setStringValue(int i, String str) {
        if (!TextUtils.isEmpty(str) && this.mState == 1) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _setStringValue(j, i, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void setInt64ValueByStrKey(int i, String str, long j) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    _setInt64ValueByStrKey(j2, i, str, j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setLongValue(int i, long j) {
        if (i == 7432) {
            long j2 = this.mHandle;
            if (j2 != 0) {
                _setInt64Value(j2, i, j);
                return;
            }
            return;
        }
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    _setInt64Value(j3, i, j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public long getLongValue(int i) {
        int i2;
        long j;
        long j2 = -1;
        if (i == 7218 || i == 7390 || i == 9407 || i == 7402 || i == 7433) {
            long j3 = this.mHandle;
            if (j3 != 0) {
                return _getLongValue(j3, i);
            }
            return -1L;
        }
        if (this.mState != 1) {
            AVMDLLog.m226d("ttmdljava", "getLongValue key: " + i + " result: -1");
            return -1L;
        }
        if (this.mConfigure == null) {
            AVMDLLog.m226d("ttmdljava", "getLongValue key: " + i + " result: -998");
            return -998L;
        }
        this.mReadLock.lock();
        try {
            try {
                switch (i) {
                    case KeyIsLiveLoaderEnable /* 8100 */:
                        i2 = this.mConfigure.mLiveLoaderEnable;
                        j = i2;
                        j2 = j;
                        break;
                    case KeyIsLiveLoaderP2pEnable /* 8101 */:
                        i2 = this.mConfigure.mLiveP2pAllow;
                        j = i2;
                        j2 = j;
                        break;
                    case KeyIsLiveEnableMdlProto /* 8102 */:
                        i2 = this.mConfigure.mLiveEnableMdlProto;
                        j = i2;
                        j2 = j;
                        break;
                    case KeyIsLiveGetLoaderType /* 8103 */:
                        i2 = this.mConfigure.mLiveLoaderType;
                        j = i2;
                        j2 = j;
                        break;
                    default:
                        long j4 = this.mHandle;
                        if (j4 != 0) {
                            j = _getLongValue(j4, i);
                            j2 = j;
                            break;
                        }
                        break;
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            AVMDLLog.m226d("ttmdljava", "getLongValue key: " + i + " result: " + j2);
            return j2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringValue(int i) {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str = _getStringValue(j, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getCacheSize(String str, String str2) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStrStr(j2, str, str2, 103);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getCacheSize(String str) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, 103);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getMissReason(String str, String str2) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStrStr(j2, str, str2, 112);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getContinueCacheSize(String str, int i, long j) {
        long j2 = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                if (j3 != 0) {
                    j2 = _getContinueCacheSize(j3, str, i, j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void cleanCacheDir(long j) {
        if (this.mState != 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    _cleanCacheDir(j2, j);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getDownloadCount(String str) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, KeyIsGetDownloadCountByVid);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long tryQuickGetCacheSize(String str) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, 106);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long quickQueryCacheSize(String str) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, 113);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getLongValueByStr(String str, int i) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public String getStringValueByStr(String str, int i) {
        String str2 = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str2 = _getStringValueByStr(j, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringCacheInfo(String str) {
        String str2 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str2 = _getStringValueByStr(j, str, 101);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getStringCacheInfo(String str, String str2) {
        String str3 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str3 = _getStringValueByStrStr(j, str, str2, 101);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str3;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getOfflineCacheInfo(String str, String str2) {
        String str3 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str3 = _getStringValueByStrStr(j, str, str2, 114);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str3;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public AVMDLFileInfo getCacheInfo(String str) {
        AVMDLFileInfo aVMDLFileInfo = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    String _getStringValueByStr = _getStringValueByStr(j, str, 101);
                    if (TextUtils.isEmpty(_getStringValueByStr)) {
                        return null;
                    }
                    String[] split = _getStringValueByStr.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length >= 3) {
                        AVMDLFileInfo aVMDLFileInfo2 = new AVMDLFileInfo();
                        try {
                            aVMDLFileInfo2.mFilePath = split[2];
                            if (!TextUtils.isEmpty(split[0])) {
                                aVMDLFileInfo2.mCacheSize = Long.valueOf(split[0]).longValue();
                            }
                            if (!TextUtils.isEmpty(split[1])) {
                                aVMDLFileInfo2.mContentLenght = Long.valueOf(split[1]).longValue();
                            }
                            aVMDLFileInfo = aVMDLFileInfo2;
                        } catch (UnsatisfiedLinkError e) {
                            e = e;
                            aVMDLFileInfo = aVMDLFileInfo2;
                            e.printStackTrace();
                            return aVMDLFileInfo;
                        }
                    }
                }
            } finally {
                this.mReadLock.unlock();
            }
        } catch (UnsatisfiedLinkError e2) {
            e = e2;
        }
        return aVMDLFileInfo;
    }

    public long getLongestUnusedTimeOfCacheDir(String str) {
        long j = -1;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValueByStr(j2, str, 115);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String ProtectFile(String str, int i) {
        String str2 = null;
        if (this.mState != 1 || TextUtils.isEmpty(str)) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str2 = _protectFile(j, str, i);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getLocalAddr() {
        String str = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    str = _getStringValue(j, 4);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return str;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public long getAllCacheSize() {
        long j = -1;
        if (this.mState != 1) {
            return -1L;
        }
        this.mReadLock.lock();
        try {
            try {
                long j2 = this.mHandle;
                if (j2 != 0) {
                    j = _getLongValue(j2, 100);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public void setIntValue(int i, int i2) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _setIntValue(j, i, i2);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        try {
            this.mVodListener = aVMDLDataLoaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setListener(int i, AVMDLDataLoaderListener aVMDLDataLoaderListener) {
        this.mWriteLock.lock();
        if (i == 107) {
            try {
                this.mLiveListener = aVMDLDataLoaderListener;
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void setEventListener(LoaderListener loaderListener) {
        this.mWriteLock.lock();
        try {
            this.mEventListener = loaderListener;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void setPluginLibraryLoader(IAVMDLLibraryLoader iAVMDLLibraryLoader) {
        this.mWriteLock.lock();
        try {
            this.mPluginLibraryLoader = iAVMDLLibraryLoader;
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void clearNetinfoCache() {
        if (this.mState != 1) {
            return;
        }
        IPCache.getInstance().clear();
        this.mWriteLock.lock();
        try {
            try {
                _clearNetinfoCache(this.mHandle);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void preConnectByHost(String str, int i) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _preConnectByHost(this.mHandle, str, i);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void suspendDownload(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _suspendedDownload(j, str);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void downloadResource(String str) {
        if (this.mState == 1 && !TextUtils.isEmpty(str)) {
            this.mWriteLock.lock();
            try {
                try {
                    long j = this.mHandle;
                    if (j != 0) {
                        _downloadResource(j, str);
                    }
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                }
            } finally {
                this.mWriteLock.unlock();
            }
        }
    }

    public void resetPreloadTraceId(String str) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                long j = this.mHandle;
                if (j != 0) {
                    _resetPreloadTraceId(j, str);
                }
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public void onNotify(int i, long j, int i2) {
        if (this.mState != 1 || this.mHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i;
        aVMDLDataLoaderNotifyInfo.parameter = j;
        aVMDLDataLoaderNotifyInfo.code = i2;
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.what = i;
        obtainMessage.sendToTarget();
    }

    public void onLogInfo(int i, int i2, String str) {
        onLogInfo(i, i2, -1, str);
    }

    public void onLogInfo(int i, int i2, int i3, String str) {
        boolean z;
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = new AVMDLDataLoaderNotifyInfo();
        aVMDLDataLoaderNotifyInfo.what = i;
        aVMDLDataLoaderNotifyInfo.code = i2;
        aVMDLDataLoaderNotifyInfo.logInfo = str;
        aVMDLDataLoaderNotifyInfo.parameter = i3;
        AVMDLLog.m226d("ttmdljava", "onLogInfo what:" + aVMDLDataLoaderNotifyInfo.what);
        if (!isNotifyInfo(i)) {
            AVMDLLog.m226d("ttmdljava", "onLogInfo what: " + aVMDLDataLoaderNotifyInfo.what + " is not notify");
            if (i != 4 && i != 14) {
                aVMDLDataLoaderNotifyInfo.logToJson();
            }
            if (i != 0) {
                z = false;
                if (i == 1) {
                    aVMDLDataLoaderNotifyInfo.logType = "own_vdp";
                } else if (i == 10) {
                    aVMDLDataLoaderNotifyInfo.logType = "own_live_loader";
                } else if (i == 11) {
                    aVMDLDataLoaderNotifyInfo.logType = "own_live_loader_sample";
                } else if (i == 19) {
                    aVMDLDataLoaderNotifyInfo.logType = "mdl_downloader_log";
                } else if (i == 70) {
                    aVMDLDataLoaderNotifyInfo.logType = "heart_beat";
                    z = true;
                } else if (i == 700) {
                    try {
                        if (!TextUtils.isEmpty(aVMDLDataLoaderNotifyInfo.logInfo)) {
                            String[] split = aVMDLDataLoaderNotifyInfo.logInfo.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (split.length >= 4) {
                                aVMDLDataLoaderNotifyInfo.logType = "unknown";
                                if (split[0].equals("0")) {
                                    aVMDLDataLoaderNotifyInfo.logType = MediaFormat.KEY_VIDEO;
                                } else if (split[0].equals(PushClient.DEFAULT_REQUEST_ID)) {
                                    aVMDLDataLoaderNotifyInfo.logType = MediaFormat.KEY_AUDIO;
                                }
                                aVMDLDataLoaderNotifyInfo.logInfo = split[1];
                                try {
                                    aVMDLDataLoaderNotifyInfo.code = Long.parseLong(split[2]);
                                } catch (NumberFormatException unused) {
                                }
                                try {
                                    aVMDLDataLoaderNotifyInfo.parameter = Integer.parseInt(split[3]);
                                } catch (NumberFormatException unused2) {
                                }
                                int length = split.length;
                                String str2 = LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                String str3 = length >= 5 ? split[4] : LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                String str4 = split.length >= 6 ? split[5] : LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                String str5 = split.length >= 7 ? split[6] : "unknown";
                                String str6 = split.length >= 8 ? split[7] : LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                String str7 = split.length >= 9 ? split[8] : LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                String str8 = split.length >= 10 ? split[9] : LynxConstants.LYNX_DEFAULT_COMPONENT_ID;
                                if (split.length >= 11) {
                                    str2 = split[10];
                                }
                                JSONObject jSONObject = new JSONObject();
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("tcpRtt", str3);
                                jSONObject2.put("tcpLastRecvDate", str4);
                                jSONObject.put("tcpInfo", jSONObject2);
                                jSONObject.put(MonitorConstants.PROTOCOL, str5);
                                jSONObject.put("downStart", str6);
                                jSONObject.put("downEnd", str7);
                                jSONObject.put("curBuf", str8);
                                jSONObject.put("fullBuf", str2);
                                aVMDLDataLoaderNotifyInfo.logExtraJsonStr = jSONObject.toString();
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException | Exception unused3) {
                    }
                } else if (i == 702) {
                    aVMDLDataLoaderNotifyInfo.logType = "speed_info";
                } else if (i == 703) {
                    aVMDLDataLoaderNotifyInfo.logType = "global_speed";
                } else {
                    switch (i) {
                        case 13:
                            aVMDLDataLoaderNotifyInfo.logType = "pcdn_task";
                            break;
                        case 14:
                            aVMDLDataLoaderNotifyInfo.logType = "alog_info";
                            break;
                        case 15:
                            aVMDLDataLoaderNotifyInfo.logType = "mdl_dns_log";
                            break;
                        case 16:
                            break;
                        default:
                            switch (i) {
                                case 1000:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_proxy";
                                    break;
                                case 1001:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_protocol";
                                    break;
                                case 1002:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_preload";
                                    break;
                                case 1003:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_task";
                                    break;
                                case 1004:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_sample";
                                    break;
                                case 1005:
                                    aVMDLDataLoaderNotifyInfo.logType = "bb_storage";
                                    break;
                            }
                    }
                }
                if (z && aVMDLDataLoaderNotifyInfo.jsonLog == null) {
                    return;
                }
            }
            aVMDLDataLoaderNotifyInfo.logType = "media_loader";
            z = true;
            if (z) {
                return;
            }
        }
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = i;
        obtainMessage.obj = aVMDLDataLoaderNotifyInfo;
        obtainMessage.sendToTarget();
    }

    public String getStringValueByStrkey(int i, long j, String str) {
        if (this.mState != 1) {
            return null;
        }
        if (i == 1503) {
            if (this.mVodListener == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mVodListener.getCheckSumInfo(str);
        }
        if (i == 1506 || i == 1509) {
            if (this.mVodListener == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return this.mVodListener.getStringValue(i, j, str);
        }
        if (i == 3512) {
            return getProxyUrl();
        }
        if (i == 11012) {
            return AVMDLDeviceUtil.getDeviceModel();
        }
        if ((i != 6401 && i != 6402) || this.mVodListener == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String stringValue = this.mVodListener.getStringValue(i, j, str);
        AVMDLLog.m226d("ttmdljava", "what:" + i + ", code:" + j + ", key3" + str + ", result:" + stringValue);
        return stringValue;
    }

    private String getProxyUrl() {
        String str;
        AVMDLLog.m226d("AVMDLProxy", "----try get proxyaddr");
        String property = System.getProperty("http.proxyHost");
        AVMDLLog.m226d("AVMDLProxy", "proxy host:" + property);
        if (!TextUtils.isEmpty(property)) {
            String property2 = System.getProperty("http.proxyPort");
            AVMDLLog.m226d("AVMDLProxy", "proxy port:" + property2);
            if (!TextUtils.isEmpty(property2)) {
                str = ResManager.HTTP_SCHEME + property + Constants.COLON_SEPARATOR + property2 + "/";
                AVMDLLog.m226d("AVMDLProxy", "****end get proxyaddr, result:" + str);
                return str;
            }
        }
        str = null;
        AVMDLLog.m226d("AVMDLProxy", "****end get proxyaddr, result:" + str);
        return str;
    }

    public void onEventInfo(Object obj) {
        String str;
        if (this.mState != 1 || this.mLogHandler == null) {
            return;
        }
        LoaderEventInfo loaderEventInfo = new LoaderEventInfo();
        loaderEventInfo.what = 74;
        try {
            HashMap hashMap = (HashMap) obj;
            HashMap hashMap2 = hashMap;
            if (hashMap.containsKey("what")) {
                loaderEventInfo.what = ((Integer) hashMap.get("what")).intValue();
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains What" + loaderEventInfo.what);
            }
            if (hashMap.containsKey("taskType")) {
                loaderEventInfo.taskType = ((Integer) hashMap.get("taskType")).intValue();
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains taskType" + loaderEventInfo.taskType);
            }
            if (hashMap.containsKey("off")) {
                loaderEventInfo.off = ((Long) hashMap.get("off")).longValue();
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains off" + loaderEventInfo.off);
            }
            if (hashMap.containsKey("endOff")) {
                loaderEventInfo.endOff = ((Long) hashMap.get("endOff")).longValue();
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains endOff" + loaderEventInfo.endOff);
            }
            if (hashMap.containsKey("fileHash")) {
                loaderEventInfo.fileHash = String.valueOf(hashMap.get("fileHash"));
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains fileHash" + loaderEventInfo.fileHash);
            }
            if (hashMap.containsKey("bytesLoaded")) {
                loaderEventInfo.bytesLoaded = ((Long) hashMap.get("bytesLoaded")).longValue();
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains bytesLoaded" + loaderEventInfo.bytesLoaded);
            }
            if (hashMap.containsKey("headers")) {
                str = String.valueOf(hashMap.get("headers"));
                AVMDLLog.m226d(TAG, "[debugUI] eventMap contains headers" + str);
            } else {
                str = "";
            }
            if (str != "") {
                for (String str2 : str.split("\r\n")) {
                    String[] split = str2.split(Constants.COLON_SEPARATOR);
                    loaderEventInfo.mHeaders.put(split[0], split[1]);
                }
            } else {
                AVMDLLog.m226d(TAG, "[debugUI] what" + loaderEventInfo.what);
                AVMDLLog.m226d(TAG, "[debugUI]no headers");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Message obtainMessage = this.mLogHandler.obtainMessage();
        obtainMessage.what = loaderEventInfo.what;
        obtainMessage.obj = loaderEventInfo;
        obtainMessage.sendToTarget();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0044, code lost:
    
        if (com.ss.mediakit.utils.AVMDLDeviceUtil.isPowerSaveMode(getApplicationContext()) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        if (com.ss.mediakit.utils.AVMDLDeviceUtil.isOverHeat(getApplicationContext()) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        r8 = 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getInt64Value(int i, long j) {
        if (i == 8003 || i == 8004) {
            AVMDLDataLoaderListener aVMDLDataLoaderListener = this.mLiveListener;
            if (aVMDLDataLoaderListener != null) {
                return aVMDLDataLoaderListener.getInt64Value(i, j);
            }
            AVMDLLog.m228e("ttmdljava", "getInt64Value mLiveListener is nullptr, code: " + i);
        }
        switch (i) {
            case KeyIsGetTotalStorageKB /* 11007 */:
                j = AVMDLDeviceUtil.getTotalStorageSpaceKB();
                break;
            case KeyIsGetFreeStorageKB /* 11008 */:
                j = AVMDLDeviceUtil.getTotalFreeStorageKB();
                break;
            case KeyIsGetBatteryPct /* 11009 */:
                j = AVMDLDeviceUtil.getBatteryPercentage(getApplicationContext());
                break;
        }
        AVMDLLog.m226d("ttmdljava", "getInt64Value code: " + i + " defaultValue: " + j);
        return j;
    }

    public void doParseHosts(String[] strArr) {
        AVMDLDNSParser.getInstance().doParseHosts(strArr);
    }

    private void hijack() {
        AVMDLLog.m226d("ttmdljava", "----hijack start");
        AVMDLDNSParser.processHijack();
        AVMDLLog.m226d("ttmdljava", "hijack clear net cache: ");
        clearNetinfoCache();
        AVMDLLog.m226d("ttmdljava", "****hijack end");
    }

    private boolean postMessage(AVMDLDataLoaderListener aVMDLDataLoaderListener, Message message) {
        AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo;
        if (message.what == 701) {
            AVMDLLog.m226d("ttmdljava", "receive hijack err: ");
            hijack();
            return true;
        }
        if (aVMDLDataLoaderListener != null && message.obj != null && (aVMDLDataLoaderNotifyInfo = (AVMDLDataLoaderNotifyInfo) message.obj) != null) {
            aVMDLDataLoaderListener.onNotify(aVMDLDataLoaderNotifyInfo);
        }
        return true;
    }

    private boolean postMessage(LoaderListener loaderListener, Message message) {
        LoaderEventInfo loaderEventInfo;
        if (loaderListener != null && message.obj != null && (loaderEventInfo = (LoaderEventInfo) message.obj) != null) {
            if (message.what == 71) {
                loaderListener.onLoaderTaskStart(loaderEventInfo);
                AVMDLLog.m226d("ttmdljava", "receive eventLog KeyIsLoaderEventStart");
            } else if (message.what == 72) {
                loaderListener.onLoaderTaskCancel(loaderEventInfo);
                AVMDLLog.m226d("ttmdljava", "receive eventLog KeyIsLoaderEventCancel");
            } else if (message.what == 73) {
                loaderListener.onLoaderTaskCompleted(loaderEventInfo);
                AVMDLLog.m226d("ttmdljava", "receive eventLog KeyIsLoaderEventCompleted");
            } else {
                AVMDLLog.m226d("ttmdljava", "receive eventLog fail");
            }
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 23) {
            AVMDLCopyOperation aVMDLCopyOperation = (AVMDLCopyOperation) message.obj;
            if (aVMDLCopyOperation == null) {
                return true;
            }
            copyInternal(aVMDLCopyOperation);
            return true;
        }
        if (i == 3 || i == 51) {
            AVMDLDataLoaderNotifyInfo aVMDLDataLoaderNotifyInfo = (AVMDLDataLoaderNotifyInfo) message.obj;
            if (this.mWaitingCopyItem.size() > 0 && aVMDLDataLoaderNotifyInfo != null) {
                handleCopyMsg(aVMDLDataLoaderNotifyInfo);
            }
        }
        if (i == 12 || i == 9) {
            return postMessage(this.mLiveListener, message);
        }
        if (i == 71 || i == 72 || i == 73 || i == 74) {
            return postMessage(this.mEventListener, message);
        }
        return postMessage(this.mVodListener, message);
    }

    public void setBackUpIp(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        IPCache.getInstance().putBackUpIp(str, new AVMDLDNSInfo(11, str, str2, 0L, (String) null, -1));
    }

    public void updateDNSInfo(String str, String str2, long j, String str3, int i) {
        if (this.mState != 1) {
            return;
        }
        this.mWriteLock.lock();
        try {
            try {
                _updateDNSInfo(this.mHandle, str, str2, j, str3, i);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
            }
        } finally {
            this.mWriteLock.unlock();
        }
    }

    public String getAuth(String str) {
        String str2 = null;
        if (this.mState != 1 || !this.isSupportGetAuth) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                str2 = _getAuth(this.mHandle, str);
            } catch (UnsatisfiedLinkError e) {
                e.printStackTrace();
                this.isSupportGetAuth = false;
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    public String getCDNLog(String str) {
        String str2 = null;
        if (this.mState != 1) {
            return null;
        }
        this.mReadLock.lock();
        try {
            try {
                str2 = _getCDNLog(this.mHandle, str);
            } catch (UnsatisfiedLinkError e) {
                AVMDLLog.m226d(TAG, "not support get cdnlog," + e.toString());
            }
            return str2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    private String encodeUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, HTTP.UTF_8);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    public void addDataSource(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AVMDLLog.m226d(TAG, "addDataSource: id: " + i + ", queyr: " + str);
        this.mWriteLock.lock();
        try {
            _addDataSource(this.mHandle, i, str);
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public void setStartCompleteListener(AVMDLStartCompleteListener aVMDLStartCompleteListener) {
        this.mStartCompleteListener = aVMDLStartCompleteListener;
    }

    public void resumeFileWriteIO() {
        if (this.mState != 1) {
            return;
        }
        AVMDLLog.m226d(TAG, "resume file write io: ");
        this.mWriteLock.lock();
        try {
            if (this.mConfigure.mMaxFileMemCacheSize > 0) {
                _resumeFileWriteIO(this.mHandle);
                this.mConfigure.mMaxFileMemCacheSize = 0;
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
    }

    public int onCellularAlwaysUp(long j) {
        AVMDLLog.m226d(TAG, "start on cellular netId: " + j);
        this.mWriteLock.lock();
        int i = -1;
        try {
            long j2 = this.mHandle;
            if (j2 != 0) {
                i = _onCellularAlwaysUp(j2, j, Build.VERSION.SDK_INT);
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
        AVMDLLog.m226d(TAG, "end on cellular netId: " + j + " ret: " + i);
        return i;
    }

    public int onInitMultiNetworkEnv() {
        AVMDLLog.m226d(TAG, "start on init multinetwork env");
        this.mWriteLock.lock();
        int i = -1;
        try {
            long j = this.mHandle;
            if (j != 0) {
                i = _onInitMultiNetworkEnv(j, Build.VERSION.SDK_INT);
            }
        } catch (Exception | UnsatisfiedLinkError unused) {
        } catch (Throwable th) {
            this.mWriteLock.unlock();
            throw th;
        }
        this.mWriteLock.unlock();
        AVMDLLog.m226d(TAG, "end on init multinetwork env");
        return i;
    }

    public int writeDataToFile(String str, long j, long j2, int i, byte[] bArr) {
        String str2;
        int i2;
        if (this.mState != 1) {
            return -1;
        }
        AVMDLLog.m226d(TAG, "start write data to file filekey:" + str + " off:" + j2 + " length:" + i);
        this.mWriteLock.lock();
        try {
            try {
                long j3 = this.mHandle;
                str2 = TAG;
                try {
                    i2 = _writeDataToFile(j3, str, j, j2, i, bArr);
                } catch (Exception unused) {
                    this.mWriteLock.unlock();
                    i2 = -3;
                    AVMDLLog.m226d(str2, "end write data to file filekey:" + str + " off:" + j2 + " length:" + i);
                    return i2;
                } catch (UnsatisfiedLinkError unused2) {
                    this.mWriteLock.unlock();
                    i2 = -2;
                    AVMDLLog.m226d(str2, "end write data to file filekey:" + str + " off:" + j2 + " length:" + i);
                    return i2;
                }
            } finally {
                this.mWriteLock.unlock();
            }
        } catch (Exception unused3) {
            str2 = TAG;
        } catch (UnsatisfiedLinkError unused4) {
            str2 = TAG;
        }
        AVMDLLog.m226d(str2, "end write data to file filekey:" + str + " off:" + j2 + " length:" + i);
        return i2;
    }

    public static String queryComponentEncode(String str) {
        if (isSupportQueryEncode && !TextUtils.isEmpty(str)) {
            AVMDLLog.m226d(TAG, "before encode, src: " + str);
            try {
                return _encodeUrl(str, 4);
            } catch (Exception e) {
                AVMDLLog.m226d(TAG, "query ComponentEncode:err " + e.getMessage());
                AVMDLLog.m226d(TAG, "query ComponentEncode:stacktrace " + e.getStackTrace());
            } catch (UnsatisfiedLinkError e2) {
                isSupportQueryEncode = false;
                AVMDLLog.m226d(TAG, "query ComponentEncode:err " + e2.getMessage());
                AVMDLLog.m226d(TAG, "query ComponentEncode:stacktrace " + e2.getStackTrace());
            }
        }
        return null;
    }

    public static String makeTsFileKey(String str, String str2) {
        try {
            return _makeTsFileKey(str, str2);
        } catch (Exception e) {
            AVMDLLog.m228e(TAG, "makeTsFileKey failed, other reason:  " + e.getMessage());
            return null;
        } catch (UnsatisfiedLinkError e2) {
            AVMDLLog.m228e(TAG, "makeTsFileKey failed, native not support: " + e2.getMessage());
            return null;
        }
    }

    public synchronized void onTaskEvent(int i, String str, int i2, int i3, String str2) {
        JSONObject jSONObject;
        if (this.mTaskListener == null) {
            return;
        }
        if (AVMDLTaskEventID.taskTypeIsValid(i2)) {
            if (AVMDLTaskEventID.eventTypeIsValid(i3)) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        jSONObject = new JSONObject(str2);
                    } catch (Exception unused) {
                    }
                    this.mTaskListener.onTaskEventNotify(i, str, i2, i3, jSONObject);
                }
                jSONObject = null;
                this.mTaskListener.onTaskEventNotify(i, str, i2, i3, jSONObject);
            }
        }
    }

    public synchronized void setTaskEventListener(AVMDLTaskEventListener aVMDLTaskEventListener) {
        this.mTaskListener = aVMDLTaskEventListener;
    }

    public AVMDLDataLoaderConfigure getConfig() {
        if (this.mState != 1) {
            return null;
        }
        return this.mConfigure;
    }

    public void suspendPreconnect() {
        setIntValue(KeyIsSetPreconnectState, 1);
    }

    public void resumePreConnect() {
        setIntValue(KeyIsSetPreconnectState, 0);
    }

    public void setDownloaderCallback(MDLDownloaderCallback mDLDownloaderCallback) {
        this.mDownloaderCallback = mDLDownloaderCallback;
    }

    public MDLDownloader getDownloader(int i, MDLDownloaderCallback mDLDownloaderCallback) {
        AVMDLLog.m226d(TAG, "getDownloader bid: " + i);
        if (this.mMDLDownloaderMap.containsKey(Integer.valueOf(i))) {
            AVMDLLog.m226d(TAG, "mMDLDownloaderMap.get(bid) but no init");
            return this.mMDLDownloaderMap.get(Integer.valueOf(i));
        }
        MDLDownloader mDLDownloader = new MDLDownloader();
        AVMDLLog.m226d(TAG, "InitDownloader downloader: " + mDLDownloader);
        mDLDownloader.Init(i, "", mDLDownloaderCallback);
        this.mMDLDownloaderMap.put(Integer.valueOf(i), mDLDownloader);
        return mDLDownloader;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class MDLDownloaderCallback {
        public int onInfos(int i, int i2, long j, String str) {
            return 0;
        }

        public MDLDownloaderCallback() {
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class MDLDownloader {
        private static final String TAG = "MDLDownloader";
        private MDLDownloadConfig mConfig;

        public MDLDownloader() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class MDLDownloadConfig {
            public long mBid;
            public Map<String, String> mOptions;

            MDLDownloadConfig(long j, String str) {
                this.mBid = j;
                AVMDLLog.m226d(MDLDownloader.TAG, "MDLDownloadConfig mBid: " + this.mBid);
            }
        }

        public int Init(int i, String str, MDLDownloaderCallback mDLDownloaderCallback) {
            this.mConfig = new MDLDownloadConfig(i, str);
            return AVMDLDataLoader._dmBussinessInit(AVMDLDataLoader.this.mHandle, i, str, mDLDownloaderCallback);
        }

        public int setValue(int i, String str, String str2) {
            return AVMDLDataLoader._dmSetValue(AVMDLDataLoader.this.mHandle, i, str, str2);
        }

        public String getValue(int i, String str) {
            return AVMDLDataLoader._dmGetValue(AVMDLDataLoader.this.mHandle, i, str);
        }

        public MDLDownloadTask createTask(int i, String str, Map<String, String> map, Map<String, String> map2, String str2) {
            long _dmCreateHandler = AVMDLDataLoader._dmCreateHandler(AVMDLDataLoader.this.mHandle, i, str, map, map2, str2);
            AVMDLLog.m226d(TAG, "createHandler dlHandler: " + _dmCreateHandler);
            if (_dmCreateHandler == 0) {
                AVMDLLog.m226d(TAG, "createHandler dlHandler = 0 ");
                return null;
            }
            MDLDownloadTask mDLDownloadTask = new MDLDownloadTask(i, _dmCreateHandler) { // from class: com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.1
                private int mBid;
                private long mDlHandler;
                private long mMdlMgr;
                final /* synthetic */ long val$dlHandler;
                final /* synthetic */ int val$taskBid;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                    this.val$taskBid = i;
                    this.val$dlHandler = _dmCreateHandler;
                    this.mBid = i;
                    this.mMdlMgr = AVMDLDataLoader.this.mHandle;
                    this.mDlHandler = _dmCreateHandler;
                }

                @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLDownloadTask
                public int asyncStart(MDLTaskCallback mDLTaskCallback) {
                    return AVMDLDataLoader._dhAsyncStart(this.mMdlMgr, this.mDlHandler, mDLTaskCallback);
                }

                @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLDownloadTask
                public int read(long j, int i2, byte[] bArr, int i3) {
                    return AVMDLDataLoader._dhRead(this.mMdlMgr, this.mDlHandler, j, i2, bArr, i3);
                }

                @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLDownloadTask
                public int stop(int i2) {
                    long j = this.mDlHandler;
                    if (j <= 0) {
                        return -1;
                    }
                    int _dhStop = AVMDLDataLoader._dhStop(this.mMdlMgr, j, i2);
                    AVMDLDataLoader._dmDeleteHandler(this.mMdlMgr, this.mBid, this.mDlHandler);
                    this.mDlHandler = 0L;
                    return _dhStop;
                }

                @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLDownloadTask
                public int setValue(String str3, String str4) {
                    return AVMDLDataLoader._dhSetValue(this.mMdlMgr, this.mDlHandler, str3, str4);
                }

                @Override // com.ss.mediakit.medialoader.AVMDLDataLoader.MDLDownloader.MDLDownloadTask
                public String getValue(String str3) {
                    return AVMDLDataLoader._dhGetValue(this.mMdlMgr, this.mDlHandler, str3);
                }
            };
            AVMDLLog.m226d(TAG, "new MDLDownloadTask");
            AVMDLLog.m226d(TAG, "task != null");
            return mDLDownloadTask;
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class MDLDownloadTask {
            public int asyncStart(MDLTaskCallback mDLTaskCallback) {
                return -1;
            }

            public String getValue(String str) {
                return null;
            }

            public int read(long j, int i, byte[] bArr, int i2) {
                return -1;
            }

            public int setValue(String str, String str2) {
                return -1;
            }

            public int stop(int i) {
                return -1;
            }

            public MDLDownloadTask() {
            }
        }

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class MDLTaskCallback {
            public int onData(int i, long j, long j2, byte[] bArr) {
                return 0;
            }

            public int onError(int i, int i2, String str) {
                return 0;
            }

            public int onInfos(int i, String str, String str2) {
                return 0;
            }

            public int onResponse(int i, int i2, long j, String str) {
                return 0;
            }

            public MDLTaskCallback() {
            }
        }
    }
}
