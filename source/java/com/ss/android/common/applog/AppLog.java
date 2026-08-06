package com.ss.android.common.applog;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.bytedance.applog.BDInstallInitHook;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.applog.concurrent.AppLogExecutors;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogMessageConstants;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.v3.MonitorV3AppLogConfig;
import com.bytedance.applog.monitor.v3.MonitorV3Config;
import com.bytedance.applog.monitor.v3.MonitorV3Helper;
import com.bytedance.applog.monitor.v3.StatsCountKeys;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.applog.sampling.EventSamplingLoader;
import com.bytedance.applog.sampling.SamplingUser;
import com.bytedance.applog.util.BlockHelper;
import com.bytedance.bdinstall.Cdid;
import com.bytedance.bdinstall.intf.IParamFilter;
import com.bytedance.bdinstall.util.SystemPropertiesWithCache;
import com.bytedance.common.utility.AppLogNetworkStatusMonitor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkStatusMonitor;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.lynx.tasm.service.LynxMemoryInfo;
import com.optimize.statistics.FrescoMonitorConst;
import com.service.middleware.applog.IHeaderCustomTimelyCallback;
import com.ss.android.CountryCommomParams;
import com.ss.android.common.AppContext;
import com.ss.android.common.active.ActiveUser;
import com.ss.android.common.applog.LogTrace;
import com.ss.android.common.applog.UserProfileHelper;
import com.ss.android.common.applog.filter.AbstractEventFilter;
import com.ss.android.common.applog.task.TaskCallback;
import com.ss.android.common.applog.task.TaskPresenter;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.AppLogDevToolsUtils;
import com.ss.android.common.util.ILogger;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.DeviceCategory;
import com.ss.android.deviceregister.DeviceRegisterInitiator;
import com.ss.android.deviceregister.DeviceRegisterManager;
import com.ss.android.deviceregister.INewUserModeManager;
import com.ss.android.deviceregister.MacAddressApiCallback;
import com.ss.android.deviceregister.OnResetListener;
import com.ss.android.deviceregister.PreInstallChannelCallback;
import com.ss.android.deviceregister.SensitiveApiCallback;
import com.ss.android.deviceregister.base.AppLogConstants;
import com.ss.android.deviceregister.base.ICustomMonitor;
import com.ss.android.deviceregister.base.ILogDepend;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.ss.android.deviceregister.core.RegisterServiceController;
import com.ss.android.deviceregister.core.cache.internal.EncryptUtils;
import com.ss.android.deviceregister.service.ServiceManager;
import com.ss.android.deviceregister.utils.RomUtils;
import com.ss.android.http.legacy.protocol.HTTP;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class AppLog {
    private static final long ACTIVE_RETRY_TIME = 900000;
    public static final int ALIYUN_PUSH = 9;
    public static final int ALLOW_PUSH_SERVICE = 1;
    static final long BATCH_EVENT_INTERVAL_DEFAULT = 60000;
    static final String BLOCK_LIST_KEY = "blocklist";
    static final String BLOCK_LIST_V1 = "v1";
    static final String BLOCK_LIST_V3 = "v3";
    private static final String CONTENT_ENCODE_METHOD = "content_encode_method";
    static final String CONTENT_TYPE = "application/octet-stream;tt-data=b";
    private static final int DENSITY_XHIGH = 320;
    static final String EVENT_TIMELY = "real_time_events";
    public static final String EVENT_V1_CATEGORY = "event_v1";
    private static final String FORBID_REPORT_PHONE_DETAIL_INFO = "forbid_report_phone_detail_info";
    public static final int GCM_PUSH = 5;
    public static final int GETUI_PUSH = 4;
    private static final int GLOBAL_EVENT_INDEX_INTERVAL = 1000;
    public static final int HW_PUSH = 7;
    private static final long INTERVAL_LOG_SETTING_DEFAULT = 21600;
    public static final int IXINTUI_PUSH = 3;
    public static final String KEY_ACTIVITES = "activites";
    public static final String KEY_AID = "aid";
    private static final String KEY_ALLOW_KEEP_ALIVE = "allow_keep_alive";
    private static final String KEY_ALLOW_OLD_IMAGE_SAMPLE = "allow_old_image_sample";
    private static final String KEY_ALLOW_PUSH_LIST = "allow_push_list";
    private static final String KEY_APP_LOG_CONFIG_LAST_CONFIG_TIME = "app_log_last_config_time";
    private static final String KEY_APP_LOG_CONFIG_LAST_CONFIG_VERSION = "app_log_last_config_version";
    static final String KEY_APP_VERSION = "app_version";
    static final String KEY_BATCH_EVENT_INTERVAL = "batch_event_interval";
    static final String KEY_BG_SESSION = "bg_session";
    public static final String KEY_CATEGORY = "category";
    static final String KEY_CHANNEL = "channel";
    public static final String KEY_CLIENTUDID = "clientudid";
    static final String KEY_CNT_FAILURE = "cnt_failure";
    static final String KEY_CNT_SUCCESS = "cnt_success";
    static final String KEY_CRASH_SESSION_ID = "session_id";
    static final String KEY_CUSTOM = "custom";
    static final String KEY_DATA = "data";
    public static final String KEY_DATETIME = "datetime";
    public static final String KEY_DEVICE_ID = "device_id";
    private static final String KEY_DEVICE_REGISTER_THROTTLE = "device_register_throttle";
    public static final String KEY_DISABLE_PERSONALIZATION = "disable_personalization";
    private static final String KEY_DNS_REPORT_TIME = "dns_report_time";
    public static final String KEY_DURATION = "duration";
    private static final String KEY_ENABLE_EVENT_FILTER = "event_filter";
    public static final String KEY_ENCRYPT_RESP_IV = "iv";
    public static final String KEY_ENCRYPT_RESP_KEY = "key";
    public static final String KEY_EVENT = "event";
    public static final String KEY_EVENT_ID = "event_id";
    public static final String KEY_EVENT_INDEX = "tea_event_index";
    public static final String KEY_EVENT_UID_ENABLE = "uid_enable";
    public static final String KEY_EVENT_V3 = "event_v3";
    public static final String KEY_EXT_JSON = "ext_json";
    public static final String KEY_EXT_VALUE = "ext_value";
    static final String KEY_FROM_SESSION = "from_session";
    static final String KEY_GEN_TIME = "_gen_time";
    private static final String KEY_GLOBAL_EVENT_INDEX_MATRIX = "key_global_event_index_matrix";
    static final String KEY_HEADER = "header";
    private static final String KEY_HP_STAT_SAMPLE = "hp_stat_sampling_ratio";
    private static final String KEY_HTTP_MONITOR_PORT = "http_monitor_port";
    private static final String KEY_IMAGE_ERROR_CODES = "image_error_codes";
    private static final String KEY_IMAGE_ERROR_REPORT = "image_error_report";
    private static final String KEY_IMAGE_SAMPLE = "image_sampling_ratio";
    public static final String KEY_INSTALL_ID = "install_id";
    static final String KEY_IS_BACKGROUND = "is_background";
    private static final long KEY_IS_RETRY_INTERVAL = 600000;
    static final String KEY_ITEM_IMPRESSION = "item_impression";
    public static final String KEY_LABEL = "label";
    static final String KEY_LANGUAGE = "language";
    private static final String KEY_LAST_ANR_TAG = "last_anr_tag";
    static final String KEY_LATEST_FORGROUND_SESSION_TIME = "latest_forground_session_time";
    public static final String KEY_LAUNCH = "launch";
    public static final String KEY_LAUNCH_FROM = "launch_from";
    static final String KEY_LOCAL_TIME = "local_time";
    public static final String KEY_LOCAL_TIME_MS = "local_time_ms";
    public static final String KEY_LOG_DATA = "log_data";
    private static final String KEY_LOG_SETTING_INTERVAL = "fetch_interval";
    static final String KEY_MAGIC_TAG = "magic_tag";
    static final String KEY_MESSAGE = "message";
    static final String KEY_MONITOR_SWITCH = "monitor_switch";
    static final String KEY_NETWORKTYPE = "networktype";
    public static final String KEY_NOT_REQUEST_SENDER = "not_request_sender";
    public static final String KEY_OPENUDID = "openudid";
    public static final String KEY_OPTIONS = "options";
    static final String KEY_OS = "os";
    static final String KEY_OS_API = "os_api";
    static final String KEY_OS_VERSION = "os_version";
    static final String KEY_PACKAGE = "package";
    private static final String KEY_PLATFORM = "platform";
    static final String KEY_SAMPLES = "samples";
    static final String KEY_SDK_VERSION = "sdk_version";
    private static final String KEY_SEND_ANR_LOG = "send_anr_log";
    private static final String KEY_SEND_LAUNCH_TIMELY = "send_launch_timely";
    private static final String KEY_SEND_POLICY = "send_policy";
    static final String KEY_SERVER_TIME = "server_time";
    public static final String KEY_SESSION_ID = "session_id";
    private static final String KEY_SESSION_INTERVAL = "session_interval";
    static final String KEY_SESSION_TYPE = "session_type";
    public static final String KEY_TAG = "tag";
    public static final String KEY_TERMINATE = "terminate";
    static final String KEY_TIME = "time";
    static final String KEY_TIMESTAMP = "timestamp";
    static final String KEY_TIME_SYNC = "time_sync";
    static final String KEY_TO_SESSION = "to_session";
    public static final String KEY_UID = "uid";
    static final String KEY_UPDATE_VERSION_CODE = "update_version_code";
    static final String KEY_URL = "url";
    public static final String KEY_USER_ID = "user_id";
    public static final String KEY_USER_IS_AUTH = "user_is_auth";
    public static final String KEY_USER_IS_LOGIN = "user_is_login";
    public static final String KEY_USER_TYPE = "user_type";
    public static final String KEY_VALUE = "value";
    static final String KEY_VERSION_CODE = "version_code";
    static final int LIMIT_EVENT_SIZE = 50000;
    static final int LIMIT_PACK_SIZE = 995000;
    private static final int LOG_MAX_RETRY = 10;
    static final String MAGIC_TAG = "ss_app_log";
    private static final long MAX_BATCH_EVENT_INTERVAL = 300000;
    public static final int MAX_UDID_LENGTH = 160;
    private static final long MIN_BATCH_EVENT_INTERVAL = 10000;
    public static final int MIN_UDID_LENGTH = 13;
    public static final int MI_PUSH = 1;
    public static final int MYSELF_PUSH = 2;
    public static final int MZ_PUSH = 8;
    public static final int NOT_ALLOW_PUSH_SERVICE = 0;
    public static final int SC_BIND_EXCEPTION = 7;
    public static final int SC_CLIENT_PROTOCOL_EXCEPTION = 19;
    public static final int SC_CONNECT_EXCEPTION = 8;
    public static final int SC_CONNECT_TIMEOUT = 2;
    public static final int SC_EACCES = 36;
    public static final int SC_EADDRINUSE = 17;
    public static final int SC_EADDRNOTAVAIL = 16;
    public static final int SC_ECONNREFUSED = 13;
    public static final int SC_ECONNRESET = 12;
    public static final int SC_EDQUOT = 34;
    public static final int SC_EHOSTUNREACH = 14;
    public static final int SC_EIO = 37;
    public static final int SC_ENETUNREACH = 15;
    public static final int SC_ENOENT = 33;
    public static final int SC_EROFS = 35;
    public static final int SC_FILE_TOO_LARGE = 20;
    public static final int SC_IO_EXCEPTION = 4;
    public static final int SC_JSON_EXCEPTION = 38;
    public static final int SC_NO_HTTP_RESPONSE = 18;
    public static final int SC_NO_REOUTE_TO_HOST = 9;
    public static final int SC_NO_SPACE = 32;
    public static final int SC_PORT_UNREACHABLE = 10;
    public static final int SC_RESET_BY_PEER = 6;
    public static final int SC_SECURITY_EXCEPTION = 39;
    public static final int SC_SOCKET_EXCEPTION = 5;
    public static final int SC_SOCKET_TIMEOUT = 3;
    public static final int SC_TOO_MANY_REDIRECT = 21;
    public static final int SC_UNKNOWN = 1;
    public static final int SC_UNKNOWN_CLIENT_ERROR = 31;
    public static final int SC_UNKNOWN_HOST = 11;
    private static final String SDK_VERSION = "2.14.0";
    private static final String SP_KEY_STATS_VALUE = "stats_value";
    static final String STATUS_OK = "success";
    private static final long STOP_EVENT_SEND_TIMELY_INTERVAL = 900000;
    private static final String TAG = "AppLog";
    public static final String THREAD_NAME_ACTIONREAPER = "ActionReaper";
    private static volatile ILogCompressor logCompressor = null;
    private static volatile boolean mCollectFreeSpace = false;
    private static volatile FreeSpaceCollector mFreeSpaceCollector = null;
    private static boolean mHasHandledCache = false;
    private static volatile long mLastGetAppConfigTime = 0;
    public static int mLaunchFrom = 0;
    private static volatile boolean realtimeEventUseSessionUuid = false;
    private static volatile String sAbSDKVersion = null;
    private static boolean sActiveOnce = false;
    private static boolean sAnonymous = false;
    private static AppContext sAppContext = null;
    private static BDInstallInitHook sBDInstallInitHook = null;
    private static volatile boolean sChildMode = false;
    private static volatile long sConfigStartTime = 0;
    static ICustomInfo sCustomInfo = null;
    private static volatile Integer sDisablePersonalization = null;
    private static volatile boolean sEnableListenNetChange = false;
    private static volatile AbstractEventFilter sEventFilter = null;
    private static volatile int sEventFilterEnable = 0;
    private static volatile AbstractEventFilter sEventFilterFromClient = null;
    static volatile EventSampling sEventSampling = null;
    static volatile GlobalEventCallback sGlobalEventCallback = null;
    static volatile IAbSdkVersion sIAbSdkVersion = null;
    private static volatile IBDAccountCallback sIBDAccountCallback = null;
    static volatile IHeaderCustomTimelyCallback sIHeaderCustomTimelyCallback = null;
    private static volatile boolean sInitGuard = false;
    private static volatile AppLog sInstance = null;
    static String sLastCreateActivityName = null;
    static String sLastCreateActivityNameAndTime = null;
    static String sLastResumeActivityName = null;
    static String sLastResumeActivityNameAndTime = null;
    static ILogEncryptConfig sLogEncryptCfg = null;
    private static int sRetryCount = -1;
    static volatile SendLogCallback sSendLogCallback = null;
    private static long sStartLogReaperDelay = 0;
    protected static volatile UserIdIsolateCallback sUserIdIsolateCallback = null;
    private static String sUserUniqueId = null;
    private static long sWaitDid = -1;
    static volatile String tempAbSDKVersion;
    private static UrlConfig urlConfig;
    ActivityRecord mActivityRecord;
    private long mActivityTime;
    private volatile boolean mAllowOldImageSample;
    private String mAllowPushListJsonStr;
    private final HashSet<Integer> mAllowPushSet;
    private long mBatchEventInterval;
    private final ConcurrentHashMap<String, String> mBlockV1;
    private final ConcurrentHashMap<String, String> mBlockV3;
    private final Context mContext;
    private final ConcurrentHashMap<String, String> mEventTimely;
    private boolean mForbidReportPhoneDetailInfo;
    private final AtomicLong mGlobalEventIndexMatrix;
    private final AtomicLong mGlobalEventIndexMatrixV1;
    private long mGlobalEventIndexSavePoint;
    private boolean mHasSetup;
    private boolean mHasTryResendConfig;
    private boolean mHasUpdateConfig;
    private final JSONObject mHeader;
    private long mHeartbeatTime;
    private int mHttpMonitorPort;
    private AtomicInteger mImageFailureCount;
    private AtomicInteger mImageSuccessCount;
    volatile boolean mInitOk;
    private int mLastConfigVersion;
    private volatile boolean mLoadingOnlineConfig;
    final LinkedList<LogQueueItem> mLogQueue;
    volatile LogReaper mLogReaper;
    private volatile long mLogSettingInterval;
    private final AppLogNetworkStatusMonitor mNetWorkMonitor;
    final LinkedList<ActionQueueItem> mQueue;
    private LinkedList<ImageSample> mSamples;
    private int mSendLaunchTimely;
    private LogSession mSession;
    private long mSessionInterval;
    private boolean mSetupOk;
    private volatile long mStartWaitSendTimely;
    private final AtomicBoolean mStopFlag;
    private JSONObject mTimeSync;
    private volatile long mTryUpdateConfigTime;
    private volatile long mUpdateConfigTime;
    private int mVersionCode;
    private static volatile AtomicInteger sEventSamplingValue = new AtomicInteger(0);
    private static volatile boolean sAdjustTerminate = false;
    private static volatile boolean sIsTouristMode = false;
    private static volatile boolean sEnableEventInTouristMode = true;
    private static final long LOG_EXPIRE_TIME = 432000000;
    static volatile long sLogExpireTime = LOG_EXPIRE_TIME;
    static volatile int sLogRetryMaxCount = 10;
    private static volatile boolean sAbortPackMiscIfException = false;
    private static volatile boolean sExtendCursorWindowIfOverflow = false;
    private static volatile boolean sEnableMigrate = true;
    private static volatile int sSwitchToBdtracker = -1;
    private static volatile boolean isMainProcess = true;
    private static volatile boolean sFixSessionLost = false;
    protected static volatile boolean sUserIdIsolateEnabled = false;
    private static boolean sTerminateImmediately = false;
    static final AtomicLong sGlobalEventId = new AtomicLong(System.currentTimeMillis());
    private static IAppLogApi sAppLogApi = new OldAppLogImpl();
    private static boolean sMiPushInclude = true;
    private static boolean sMyPushInclude = true;
    private static boolean sHwPushInclude = true;
    private static boolean sMzPushInclude = true;
    private static boolean sAliyunPushInclude = true;
    private static boolean sHasManualInvokeActiveUser = false;
    private static volatile boolean sNewMonitorEnabled = false;
    static final String KEY_APPKEY = "appkey";
    static final String KEY_DISPLAY_NAME = "display_name";
    static final String KEY_TIMEZONE = "timezone";
    static final String KEY_ACCESS = "access";
    static final String KEY_DEVICE_MODEL = "device_model";
    static final String KEY_DEVICE_BRAND = "device_brand";
    static final String KEY_DEVICE_MANUFACTURER = "device_manufacturer";
    static final String KEY_RESOLUTION = "resolution";
    static final String KEY_DISPLAY_DENSITY = "display_density";
    static final String KEY_DENSITY_DPI = "density_dpi";
    static final String KEY_CARRIER = "carrier";
    static final String KEY_MCC_MNC = "mcc_mnc";
    static final String KEY_SIG_HASH = "sig_hash";
    static final String KEY_PUSH_SDK = "push_sdk";
    static final String KEY_ROM = "rom";
    static final String KEY_RELEASE_BUILD = "release_build";
    static final String KEY_MANIFEST_VERSION_CODE = "manifest_version_code";
    static final String KEY_APP_VERSION_MINOR = "app_version_minor";
    static final String KEY_CPU_ABI = "cpu_abi";
    static final String KEY_APP_TRACK = "app_track";
    static final String KEY_ROM_VERSION = "rom_version";
    public static final String KEY_AB_SDK_VERSION = "ab_sdk_version";
    public static final String KEY_USER_UNIQUE_ID = "user_unique_id";
    private static final String KEY_HARMONY_OS_API = "harmony_os_api";
    private static final String KEY_HARMONY_OS_VERSION = "harmony_os_version";
    private static final String KEY_HARMONY_RELEASE_TYPE = "harmony_release_type";
    private static final String KEY_SYS_REGION = "sys_region";
    private static final String KEY_CARRIER_REGION = "carrier_region";
    private static final String KEY_TZ_OFFSET = "timezone_offset";
    private static final String KEY_TZ_NAME = "timezone_name";
    public static final String[] BASE_HEADER_KEYS = {AppLogConstants.KLINK_EGDI, KEY_APPKEY, "openudid", "sdk_version", "package", "channel", KEY_DISPLAY_NAME, "app_version", "version_code", KEY_TIMEZONE, KEY_ACCESS, "os", "os_version", "os_api", KEY_DEVICE_MODEL, KEY_DEVICE_BRAND, KEY_DEVICE_MANUFACTURER, "language", KEY_RESOLUTION, KEY_DISPLAY_DENSITY, KEY_DENSITY_DPI, KEY_CARRIER, KEY_MCC_MNC, "clientudid", "install_id", "device_id", KEY_SIG_HASH, "aid", KEY_PUSH_SDK, KEY_ROM, KEY_RELEASE_BUILD, "update_version_code", KEY_MANIFEST_VERSION_CODE, KEY_APP_VERSION_MINOR, KEY_CPU_ABI, KEY_APP_TRACK, "not_request_sender", KEY_ROM_VERSION, RegistrationHeaderHelper.KEY_REGISON, RegistrationHeaderHelper.KEY_TIMEZONE_NAME, RegistrationHeaderHelper.KEY_TIMEZONE_OFFSET, RegistrationHeaderHelper.KEY_SIM_REGION, "custom", "google_aid", "app_language", "app_region", RegistrationHeaderHelper.KEY_DEVICE_CATEGORY, KEY_AB_SDK_VERSION, KEY_USER_UNIQUE_ID, "platform", KEY_HARMONY_OS_API, KEY_HARMONY_OS_VERSION, KEY_HARMONY_RELEASE_TYPE, RegistrationHeaderHelper.KEY_CDID, KEY_SYS_REGION, KEY_CARRIER_REGION, KEY_TZ_OFFSET, KEY_TZ_NAME};
    public static volatile int MAX_QUEUE_SIZE = 2000;
    private static final Object sLock = new Object();
    static volatile boolean sStopped = false;
    public static AtomicLong sUserId = new AtomicLong();
    static volatile long sUidFromResp = 0;
    static volatile int sUserTypeFromResp = 0;
    static volatile int sUserIsLoginFromResp = 0;
    static volatile int sUserIsAuthFromResp = 0;
    static String sSessionKey = "";
    static final List<ILogSessionHook> sSessionHookList = new ArrayList(2);
    static String sRomInfo = null;
    private static volatile JSONObject sHeaderCopy = null;
    private static boolean sInitWithActivity = false;
    static int sAppCount = 0;
    private static final ConcurrentHashMap<String, String> sLogHttpHeader = new ConcurrentHashMap<>();
    private static final Bundle sCustomBundle = new Bundle();
    static final SimpleDateFormat sDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
    private static final SimpleDateFormat sCompatDateTimeFormat = TeaUtils.getCompatFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    private static final SimpleDateFormat sDateCompatFormat = TeaUtils.getCompatFormat("yyyy-MM-dd");
    private static final Object sLogConfigLock = new Object();
    private static final ThreadLocal<Boolean> sIsConfigThread = new ThreadLocal<>();
    private static WeakReference<ConfigUpdateListener> sConfigUpdateListener = null;
    private static volatile boolean sHasLoadDid = false;
    private static volatile boolean sPendingActiveUser = false;
    private static long sFetchActiveTime = 0;
    private static long sBatchEventInterval = -1;
    private static volatile boolean sInterceptLogSetting = false;
    static volatile boolean sInterceptAppLog = false;
    private static volatile boolean sEnableEventUserId = false;
    private static volatile boolean sEnableKeepUserId = false;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ConfigUpdateListener {
        void onConfigUpdate();

        void onRemoteConfigUpdate(boolean z);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ConfigUpdateListenerEnhanced extends ConfigUpdateListener {
        void handleConfigUpdate(JSONObject jSONObject);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface FreeSpaceCollector {
        JSONObject getFreeSpace();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface IAbSdkVersion {
        String getAbSdkVersion(String str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ICustomInfo extends ICustomMonitor {
        JSONObject getUserDefineInfo();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ILogEncryptConfig {
        boolean getEncryptSwitch();

        boolean getEventV3Switch();

        boolean getRecoverySwitch();
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface ILogSessionHook {
        void onLogSessionBatchEvent(long j, String str, JSONObject jSONObject);

        void onLogSessionStart(long j);

        void onLogSessionTerminate(long j, String str, JSONObject jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkValidInterval(long j) {
        return j >= MIN_BATCH_EVENT_INTERVAL && j <= 300000;
    }

    public static boolean getDebugNetError() {
        return false;
    }

    public static void onNetConfigUpdate(JSONObject jSONObject, boolean z) {
    }

    public static void reportNetError(Throwable th, String str, String str2) {
    }

    public static boolean getSwitchToBdtracker() {
        if (sSwitchToBdtracker < 0) {
            TLog.m81w("AppLog SwitchToBdtracker has not been set!");
        }
        return sSwitchToBdtracker > 0;
    }

    public static void setSwitchToBdtracker(boolean z) {
        sSwitchToBdtracker = z ? 1 : 0;
        DeviceRegisterManager.setSwitchToBdtracker(z);
        if (z) {
            sAppLogApi = new NewAppLogBdtrackerImpl();
        }
    }

    public static void setRealtimeEventUseSessionUuid(boolean z) {
        realtimeEventUseSessionUuid = z;
    }

    public static void setMacAddressApiCallback(MacAddressApiCallback macAddressApiCallback) {
        if (sInitGuard) {
            throw new IllegalStateException("please call before init");
        }
        DeviceRegisterManager.setMacAddressApiCallback(macAddressApiCallback);
    }

    public static void setWaitDid(long j) {
        sWaitDid = j;
    }

    public static long getWaitDid() {
        return sWaitDid;
    }

    public static void setRetryCount(int i) {
        sRetryCount = i;
        DeviceRegisterManager.setRetryCount(i);
    }

    public static int getRetryCount() {
        return sRetryCount;
    }

    public static void setAnonymous(boolean z) {
        sAppLogApi.setAnonymous(z);
    }

    public static void setPreInstallChannelCallback(PreInstallChannelCallback preInstallChannelCallback) {
        if (sInitGuard) {
            throw new IllegalStateException("please call before init");
        }
        DeviceRegisterManager.setPreInstallChannelCallback(preInstallChannelCallback);
    }

    public static void setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback) {
        sAppLogApi.setSensitiveApiCallback(sensitiveApiCallback);
    }

    public static void setBDInstallInitHook(BDInstallInitHook bDInstallInitHook) {
        sBDInstallInitHook = bDInstallInitHook;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BDInstallInitHook getBDInstallInitHook() {
        return sBDInstallInitHook;
    }

    public static void setFixSessionLost(boolean z) {
        sFixSessionLost = z;
    }

    public static boolean isFixSessionLost() {
        return sFixSessionLost;
    }

    public static void registerTaskCallback(TaskCallback taskCallback) {
        sAppLogApi.registerTaskCallback(taskCallback);
    }

    public static void onTaskResume(Context context) {
        sAppLogApi.onTaskResume(context);
    }

    public static void onTaskPause(Context context) {
        sAppLogApi.onTaskPause(context);
    }

    public static void registerLogRequestCallback(LogTrace.LogRequestTraceCallback logRequestTraceCallback) {
        sAppLogApi.registerLogRequestCallback(logRequestTraceCallback);
    }

    public static void setFakePackage(String str) {
        DeviceRegisterManager.setFakePackage(str);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ActivityRecord {
        public String mActivityClassName;
        public int mHashcode;

        public ActivityRecord(String str, int i) {
            this.mActivityClassName = str;
            this.mHashcode = i;
        }

        public ActivityRecord() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum ActionQueueType {
        PAGE_START(0),
        PAGE_END(1),
        EVENT(2),
        IMAGE_SAMPLE(3),
        CONFIG_UPDATE(4),
        API_SAMPLE(5),
        UA_UPDATE(6),
        SAVE_ANR_TAG(7),
        SAVE_DNS_REPORT(8),
        SAVE_MISC_LOG(9),
        DEVICE_ID_UPDATE(10),
        CUSTOMER_HEADER_UPDATE(11),
        UPDATE_GOOGLE_AID(12),
        UPDATE_APP_LANGUAGE_REGION(13),
        CLEAR_WHEN_SWITCH_CHILD_MODE(14),
        RESET_WHEN_SWITCH_CHILD_MODE(15),
        FLUSH_EVENT(16),
        UPDATE_USER_UNIQUE_ID(17),
        DELAY_START_LOG_REAPER(18);

        final int nativeInt;

        ActionQueueType(int i) {
            this.nativeInt = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ActionQueueItem {
        public long arg;
        public CountDownLatch countDownLatch;
        public Object obj;
        public String strArg;
        public final ActionQueueType type;

        public ActionQueueItem(ActionQueueType actionQueueType) {
            this.type = actionQueueType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class ImageSample {
        public final int networktype;
        public final long time;
        public final long timestamp;
        public final String url;

        public ImageSample(String str, int i, long j, long j2) {
            this.url = str;
            this.networktype = i;
            this.time = j;
            this.timestamp = j2;
        }
    }

    static String[] APPLOG_TIMELY_URL() {
        return urlConfig.mApplogTimelyUrl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] APPLOG_URL() {
        return urlConfig.mApplogURL;
    }

    static String APPLOG_CONFIG_URL() {
        return urlConfig.mApplogSettingsUrl;
    }

    static String APPLOG_CONFIG_URL_FALLBACK() {
        return urlConfig.mApplogSettingsFallbackUrl;
    }

    static String[] ACTIVE_USER_URL() {
        return urlConfig.mAppActiveUrl;
    }

    static String USER_PROFILE_URL() {
        return urlConfig.mUserProfileUrl;
    }

    public static SimpleDateFormat getDateFormat() {
        return sDateCompatFormat;
    }

    public static SimpleDateFormat getDateTimeFormat() {
        return sCompatDateTimeFormat;
    }

    public long getTerminateSessionInterval() {
        if (sTerminateImmediately) {
            return 500L;
        }
        return this.mSessionInterval;
    }

    public static void setCollectFreeSpace(boolean z, FreeSpaceCollector freeSpaceCollector) {
        sAppLogApi.setCollectFreeSpace(z, freeSpaceCollector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDeviceRegisterURL(String[] strArr, String[] strArr2) {
        DeviceRegisterManager.setDeviceRegisterURL(strArr, strArr2);
    }

    public static void setDBNamme(String str) {
        sAppLogApi.setDBNamme(str);
    }

    public static void setSPName(String str) {
        sAppLogApi.setSPName(str);
    }

    public static void setEncryptCountSPName(String str) {
        sAppLogApi.setEncryptCountSPName(str);
    }

    public static void addAppCount() {
        sAppLogApi.addAppCount();
    }

    public static void setAppContext(AppContext appContext) {
        sAppLogApi.setAppContext(appContext);
    }

    public static void init(Context context, boolean z, UrlConfig urlConfig2) {
        sAppLogApi.init(context, z, urlConfig2);
    }

    @Deprecated
    public static int getAllowPushService(int i) {
        AppLog appLog = sInstance;
        synchronized (sLock) {
            if (appLog != null) {
                return appLog.mAllowPushSet.contains(Integer.valueOf(i)) ? 1 : 0;
            }
            return 0;
        }
    }

    @Deprecated
    public static void setPushCustomValues(boolean z, boolean z2, boolean z3, boolean z4) {
        sAppLogApi.setPushCustomValues(z, z2, z3, z4);
    }

    @Deprecated
    public static void setMyPushIncludeValues(boolean z) {
        sAppLogApi.setMyPushIncludeValues(z);
    }

    @Deprecated
    public static void setAllowPushService(int i, int i2) {
        sAppLogApi.setAllowPushService(i, i2);
    }

    public static void setHttpMonitorPort(int i) {
        sAppLogApi.setHttpMonitorPort(i);
    }

    public static void setAppTrack(JSONObject jSONObject) {
        sAppLogApi.setAppTrack(jSONObject);
    }

    public static void getSSIDs(Map<String, String> map) {
        sAppLogApi.getSSIDs(map);
    }

    @Deprecated
    public static void setCustomerHeader(Bundle bundle) {
        sAppLogApi.setCustomerHeader(bundle);
    }

    void addCustomerHeader(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.CUSTOMER_HEADER_UPDATE);
            actionQueueItem.obj = bundle2;
            enqueue(actionQueueItem);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Deprecated
    public static String getInstallId() {
        return sAppLogApi.getInstallId();
    }

    @Deprecated
    public static void setSessionKey(String str) {
        sAppLogApi.setSessionKey(str);
    }

    @Deprecated
    public static String getSessionKey() {
        return sAppLogApi.getSessionKey();
    }

    public static int getAppId() {
        return DeviceRegisterManager.getAppId();
    }

    public static String getUserId() {
        return sAppLogApi.getUserId();
    }

    public static String getRomInfo() {
        return sRomInfo;
    }

    @Deprecated
    public static String getClientId() {
        return sAppLogApi.getClientId();
    }

    @Deprecated
    public static String getServerDeviceId() {
        return sAppLogApi.getServerDeviceId();
    }

    public static long getLastActiveTime() {
        return sAppLogApi.getLastActiveTime();
    }

    static boolean isInForeground() {
        AppLog appLog = sInstance;
        return (appLog == null || Looper.myLooper() != Looper.getMainLooper() || appLog.mActivityRecord == null) ? false : true;
    }

    public static boolean isBadDeviceId(String str) {
        return sAppLogApi.isBadDeviceId(str);
    }

    public static int getHttpMonitorPort() {
        return sAppLogApi.getHttpMonitorPort();
    }

    public static String getVersion(Context context) {
        return sAppLogApi.getVersion(context);
    }

    @Deprecated
    public static void setDefaultUserAgent(String str) {
        sAppLogApi.setDefaultUserAgent(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUserAgent() {
        return DeviceRegisterManager.getUserAgent(this.mContext);
    }

    public static void setUserId(long j) {
        sAppLogApi.setUserId(j);
    }

    @Deprecated
    public static void setGoogleAId(String str) {
        if (StringUtils.isEmpty(str)) {
            return;
        }
        CountryCommomParams.setGoogleAID(str);
        AppLog appLog = sInstance;
        if (appLog != null) {
            ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.UPDATE_GOOGLE_AID);
            actionQueueItem.obj = str;
            appLog.enqueue(actionQueueItem);
        }
    }

    public static void setAppLanguageAndRegion(String str, String str2) {
        sAppLogApi.setAppLanguageAndRegion(str, str2);
    }

    public static void setAppId(int i) {
        DeviceRegisterManager.setAppId(i);
    }

    @Deprecated
    public static void setChannel(String str) {
        if (sInitGuard) {
            throw new IllegalStateException("please call before init");
        }
        DeviceRegisterManager.setChannel(str);
    }

    public static void setCustomVersion(String str) {
        DeviceRegisterManager.setCustomVersion(str);
    }

    public static String getCustomVersion() {
        return DeviceRegisterManager.getCustomVersion();
    }

    public static void setReleaseBuild(String str) {
        DeviceRegisterManager.setReleaseBuild(str);
    }

    @Deprecated
    public static void setSessionHook(ILogSessionHook iLogSessionHook) {
        addSessionHook(iLogSessionHook);
    }

    public static void addSessionHook(ILogSessionHook iLogSessionHook) {
        if (iLogSessionHook == null) {
            return;
        }
        sAppLogApi.addSessionHook(iLogSessionHook);
    }

    public static void removeSessionHook(ILogSessionHook iLogSessionHook) {
        if (iLogSessionHook == null) {
            return;
        }
        sAppLogApi.removeSessionHook(iLogSessionHook);
    }

    public static void setLogEncryptConfig(ILogEncryptConfig iLogEncryptConfig) {
        sAppLogApi.setLogEncryptConfig(iLogEncryptConfig);
    }

    public static void setCustomInfo(ICustomInfo iCustomInfo) {
        sAppLogApi.setCustomInfo(iCustomInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getLogEncryptSwitch() {
        ILogEncryptConfig iLogEncryptConfig = sLogEncryptCfg;
        if (iLogEncryptConfig != null) {
            return iLogEncryptConfig.getEncryptSwitch();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getEventV3Switch() {
        ILogEncryptConfig iLogEncryptConfig = sLogEncryptCfg;
        if (iLogEncryptConfig != null) {
            return iLogEncryptConfig.getEventV3Switch();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getLogRecoverySwitch() {
        ILogEncryptConfig iLogEncryptConfig = sLogEncryptCfg;
        if (iLogEncryptConfig != null) {
            return iLogEncryptConfig.getRecoverySwitch();
        }
        return true;
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        appendParamsToEvent(jSONObject);
        sAppLogApi.onEvent(context, str, str2, str3, j, j2, z, jSONObject);
    }

    public static String getCurrentSessionId() {
        return sAppLogApi.getCurrentSessionId();
    }

    private static void appendParamsToEvent(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.has(KEY_AB_SDK_VERSION)) {
            return;
        }
        String abSDKVersion = getAbSDKVersion();
        if (TextUtils.isEmpty(abSDKVersion)) {
            return;
        }
        try {
            jSONObject.put(KEY_AB_SDK_VERSION, abSDKVersion);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, JSONObject jSONObject) {
        onEvent(context, str, str2, str3, j, j2, false, jSONObject);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z) {
        onEvent(context, str, str2, str3, j, j2, z, null);
    }

    public static void onEvent(Context context, String str, String str2, String str3, long j, long j2) {
        onEvent(context, str, str2, str3, j, j2, false, null);
    }

    public static void onEvent(Context context, String str, String str2) {
        onEvent(context, "event_v1", str, str2, 0L, 0L, false, null);
    }

    public static void onEvent(Context context, String str) {
        onEvent(context, "event_v1", str, null, 0L, 0L, false, null);
    }

    public static void recordMiscLog(Context context, String str, JSONObject jSONObject) {
        sAppLogApi.recordMiscLog(context, str, jSONObject);
    }

    @Deprecated
    public static void onImageSuccess() {
        sAppLogApi.onImageSuccess();
    }

    @Deprecated
    public static void onImageFailure() {
        sAppLogApi.onImageFailure();
    }

    @Deprecated
    public static void onImageFailure(String str, int i, int i2) {
        sAppLogApi.onImageFailure(str, i, i2);
    }

    @Deprecated
    public static void onImageSample(String str, int i, long j) {
        sAppLogApi.onImageSample(str, i, j);
    }

    static void saveDnsReportTime(long j) {
        AppLog appLog = sInstance;
        if (j <= 0 || appLog == null) {
            return;
        }
        ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.SAVE_DNS_REPORT);
        actionQueueItem.arg = j;
        appLog.enqueue(actionQueueItem);
    }

    public static void setAliYunHanlder(IAliYunHandler iAliYunHandler) {
        sAppLogApi.setAliYunHanlder(iAliYunHandler);
    }

    public static void tryWaitDeviceInit() {
        DeviceRegisterManager.tryWaitDeviceIdInit();
    }

    public static int checkHttpRequestException(Throwable th, String[] strArr) {
        return sAppLogApi.checkHttpRequestException(th, strArr);
    }

    @Deprecated
    public static String addCommonParams(String str, boolean z) {
        return NetUtil.addCommonParams(str, z);
    }

    @Deprecated
    public static void appendCommonParams(StringBuilder sb, boolean z) {
        NetUtil.appendCommonParams(sb, z);
    }

    public static void onQuit() {
        sAppLogApi.onQuit();
    }

    public static void onResume(Context context) {
        sAppLogApi.onResume(context);
    }

    public static void onResume(Context context, String str, int i) {
        sAppLogApi.onResume(context, str, i);
    }

    public static void onPause(Context context) {
        sAppLogApi.onPause(context);
    }

    public static void onPause(Context context, String str, int i) {
        sAppLogApi.onPause(context, str, i);
    }

    public static void onActivityCreate(Context context) {
        sAppLogApi.onActivityCreate(context);
    }

    public static void onActivityCreate(String str) {
        sAppLogApi.onActivityCreate(str);
    }

    public static AppLog getInstance(Context context) {
        return sAppLogApi.getInstance(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AppLog getInstance(Context context, boolean z) {
        synchronized (sLock) {
            if (sStopped) {
                return null;
            }
            if (sInstance == null) {
                sInstance = new AppLog(context, z);
                if (Logger.debug()) {
                    TLog.m81w("AppLog Process AppLog = " + sInstance.toString() + " pid = " + String.valueOf(Process.myPid()));
                }
            }
            return sInstance;
        }
    }

    private boolean initHeader(JSONObject jSONObject, Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            if (sMiPushInclude) {
                jSONArray.put(1);
            }
            if (sMyPushInclude) {
                jSONArray.put(2);
            }
            if (sHwPushInclude) {
                jSONArray.put(7);
            }
            if (sMzPushInclude) {
                jSONArray.put(8);
            }
            if (sAliyunPushInclude) {
                jSONArray.put(9);
            }
            jSONObject.put(KEY_PUSH_SDK, jSONArray);
            String userUniqueId = getUserUniqueId();
            if (!TextUtils.isEmpty(userUniqueId)) {
                jSONObject.put(KEY_USER_UNIQUE_ID, userUniqueId);
            }
            loadHarmonyInfo(jSONObject);
        } catch (Exception unused) {
        }
        return DeviceRegisterManager.getHeader(context, jSONObject, sChildMode);
    }

    private void loadHarmonyInfo(JSONObject jSONObject) {
        boolean isHarmonyUI = RomUtils.isHarmonyUI();
        try {
            jSONObject.put("platform", isHarmonyUI ? "Harmony" : "Android");
        } catch (JSONException e) {
            TLog.m76e("AppLog loadHarmonyInfo ", e);
        }
        if (isHarmonyUI) {
            try {
                jSONObject.put(KEY_HARMONY_OS_API, SystemPropertiesWithCache.get("hw_sc.build.os.apiversion"));
                jSONObject.put(KEY_HARMONY_OS_VERSION, SystemPropertiesWithCache.get("hw_sc.build.platform.version"));
                jSONObject.put(KEY_HARMONY_RELEASE_TYPE, SystemPropertiesWithCache.get("hw_sc.build.os.releasetype"));
            } catch (Throwable th) {
                TLog.m82w("AppLog loadHarmonyInfo ", th);
            }
        }
    }

    public static String formatDate(long j) {
        return sDateTimeFormat.format(new Date(j));
    }

    private void initDataFromSp(Context context) {
        loadSSIDs();
        loadGlobalEventIndex();
        this.mForbidReportPhoneDetailInfo = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).getInt(FORBID_REPORT_PHONE_DETAIL_INFO, 0) > 0;
        if (getEventSamplingValue() > 0) {
            sEventSampling = EventSamplingLoader.parseEventSamplingFromLocal(this.mContext, (String) null);
        }
    }

    private AppLog(Context context, boolean z) {
        this.mForbidReportPhoneDetailInfo = false;
        this.mHasUpdateConfig = false;
        this.mVersionCode = 1;
        this.mInitOk = false;
        this.mQueue = new LinkedList<>();
        this.mLogQueue = new LinkedList<>();
        this.mLogReaper = null;
        this.mActivityTime = 0L;
        this.mSetupOk = false;
        this.mHasSetup = false;
        this.mHasTryResendConfig = false;
        this.mAllowPushSet = new HashSet<>();
        this.mAllowPushListJsonStr = "";
        this.mAllowOldImageSample = false;
        this.mStopFlag = new AtomicBoolean();
        this.mSessionInterval = 30000L;
        this.mBatchEventInterval = BATCH_EVENT_INTERVAL_DEFAULT;
        this.mLogSettingInterval = 21600000L;
        this.mSendLaunchTimely = 1;
        this.mHttpMonitorPort = 0;
        this.mTimeSync = null;
        this.mImageSuccessCount = new AtomicInteger();
        this.mImageFailureCount = new AtomicInteger();
        this.mSamples = new LinkedList<>();
        this.mHeartbeatTime = System.currentTimeMillis();
        this.mUpdateConfigTime = 0L;
        this.mTryUpdateConfigTime = 0L;
        this.mLoadingOnlineConfig = false;
        this.mBlockV1 = new ConcurrentHashMap<>();
        this.mBlockV3 = new ConcurrentHashMap<>();
        this.mEventTimely = new ConcurrentHashMap<>();
        this.mGlobalEventIndexMatrix = new AtomicLong();
        this.mGlobalEventIndexMatrixV1 = new AtomicLong();
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mNetWorkMonitor = new AppLogNetworkStatusMonitor(applicationContext);
        this.mHeader = null;
    }

    private AppLog(Context context) {
        this.mForbidReportPhoneDetailInfo = false;
        this.mHasUpdateConfig = false;
        this.mVersionCode = 1;
        this.mInitOk = false;
        this.mQueue = new LinkedList<>();
        this.mLogQueue = new LinkedList<>();
        this.mLogReaper = null;
        this.mActivityTime = 0L;
        this.mSetupOk = false;
        this.mHasSetup = false;
        this.mHasTryResendConfig = false;
        this.mAllowPushSet = new HashSet<>();
        this.mAllowPushListJsonStr = "";
        this.mAllowOldImageSample = false;
        this.mStopFlag = new AtomicBoolean();
        this.mSessionInterval = 30000L;
        this.mBatchEventInterval = BATCH_EVENT_INTERVAL_DEFAULT;
        this.mLogSettingInterval = 21600000L;
        this.mSendLaunchTimely = 1;
        this.mHttpMonitorPort = 0;
        this.mTimeSync = null;
        this.mImageSuccessCount = new AtomicInteger();
        this.mImageFailureCount = new AtomicInteger();
        this.mSamples = new LinkedList<>();
        this.mHeartbeatTime = System.currentTimeMillis();
        this.mUpdateConfigTime = 0L;
        this.mTryUpdateConfigTime = 0L;
        this.mLoadingOnlineConfig = false;
        this.mBlockV1 = new ConcurrentHashMap<>();
        this.mBlockV3 = new ConcurrentHashMap<>();
        this.mEventTimely = new ConcurrentHashMap<>();
        this.mGlobalEventIndexMatrix = new AtomicLong();
        this.mGlobalEventIndexMatrixV1 = new AtomicLong();
        DeviceRegisterManager.setSDKVersion(SDK_VERSION);
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        DeviceRegisterManager.setContext(applicationContext);
        this.mHeader = new JSONObject();
        initDataFromSp(context);
        this.mInitOk = true;
        new ActionReaper().start();
        this.mNetWorkMonitor = new AppLogNetworkStatusMonitor(applicationContext);
        LogUtils.sendString("init_end", String.valueOf(DeviceRegisterManager.getAppId()));
    }

    void enqueue(ActionQueueItem actionQueueItem) {
        if (actionQueueItem == null) {
            return;
        }
        synchronized (this.mQueue) {
            if (sStopped) {
                return;
            }
            if (this.mQueue.size() >= MAX_QUEUE_SIZE) {
                monitorActionQueueCacheDrop(this.mQueue.poll());
            }
            this.mQueue.add(actionQueueItem);
            this.mQueue.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.common.applog.AppLog$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class C03705 {
        static final /* synthetic */ int[] $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType;

        static {
            int[] iArr = new int[ActionQueueType.values().length];
            $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType = iArr;
            try {
                iArr[ActionQueueType.EVENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.SAVE_MISC_LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.PAGE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.PAGE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.IMAGE_SAMPLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.API_SAMPLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.CONFIG_UPDATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.UA_UPDATE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.SAVE_ANR_TAG.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.SAVE_DNS_REPORT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.CUSTOMER_HEADER_UPDATE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.DEVICE_ID_UPDATE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.UPDATE_GOOGLE_AID.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.UPDATE_APP_LANGUAGE_REGION.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.CLEAR_WHEN_SWITCH_CHILD_MODE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.RESET_WHEN_SWITCH_CHILD_MODE.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.FLUSH_EVENT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.UPDATE_USER_UNIQUE_ID.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[ActionQueueType.DELAY_START_LOG_REAPER.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    private void monitorActionQueueCacheDrop(ActionQueueItem actionQueueItem) {
        if (actionQueueItem != null) {
            int i = C03705.$SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[actionQueueItem.type.ordinal()];
            if (i == 1 || i == 2) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CACHE_DROP_EVENT_COUNT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enqueue(LogQueueItem logQueueItem) {
        LogQueueItem poll;
        if (logQueueItem == null) {
            return;
        }
        this.mHeartbeatTime = System.currentTimeMillis();
        synchronized (this.mLogQueue) {
            if (this.mLogQueue.size() >= MAX_QUEUE_SIZE && (poll = this.mLogQueue.poll()) != null) {
                TLog.m75e("log queue poll out: " + poll);
            }
            this.mLogQueue.add(logQueueItem);
            this.mLogQueue.notify();
        }
    }

    void sendHeartbeat() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mHeartbeatTime > BATCH_EVENT_INTERVAL_DEFAULT) {
            this.mHeartbeatTime = currentTimeMillis;
            synchronized (this.mLogQueue) {
                this.mLogQueue.notify();
            }
        }
    }

    void stop() {
        this.mNetWorkMonitor.onDestroy();
        synchronized (this.mQueue) {
            this.mQueue.clear();
            this.mQueue.notify();
        }
        this.mStopFlag.set(true);
        synchronized (this.mLogQueue) {
            this.mLogQueue.clear();
            this.mLogQueue.notifyAll();
        }
        DBHelper.closeDB();
    }

    public SamplingUser buildSamplingUser() {
        SamplingUser samplingUser = new SamplingUser(String.valueOf(getAppId()), getServerDeviceId(), getUserUniqueId());
        IBDAccountCallback iBDAccountCallback = sIBDAccountCallback;
        if (iBDAccountCallback != null) {
            Pair odinUserInfo = iBDAccountCallback.getOdinUserInfo();
            if (((Long) odinUserInfo.second).longValue() > 0) {
                samplingUser.setUserId(String.valueOf(odinUserInfo.second));
                samplingUser.setUserType(String.valueOf(odinUserInfo.first));
            } else if (sUserIsLoginFromResp == 0) {
                samplingUser.setUserId(String.valueOf(sUidFromResp));
                samplingUser.setUserType(String.valueOf(sUserTypeFromResp));
            }
        } else {
            samplingUser.setUserId(String.valueOf(sUserId.get()));
        }
        return samplingUser;
    }

    void onEvent(String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
        EventSampling eventSampling;
        AbstractEventFilter abstractEventFilter;
        JSONObject jSONObject2 = jSONObject;
        if (!this.mInitOk) {
            LogTrace.notifyLogTrace(1, 3, null);
            return;
        }
        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COLLECT_EVENT_COUNT);
        try {
            if (getLogRecoverySwitch()) {
                if ("event_v3".equalsIgnoreCase(str)) {
                    ConcurrentHashMap<String, String> concurrentHashMap = this.mBlockV3;
                    if (concurrentHashMap != null && concurrentHashMap.size() > 0 && !StringUtils.isEmpty(str2) && this.mBlockV3.containsKey(str2)) {
                        TLog.m81w("AppLog hit block event v3");
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
                        LogTrace.notifyLogTrace(1, 2, null);
                        return;
                    }
                } else {
                    ConcurrentHashMap<String, String> concurrentHashMap2 = this.mBlockV1;
                    if (concurrentHashMap2 != null && concurrentHashMap2.size() > 0) {
                        if (this.mBlockV1.containsKey(!StringUtils.isEmpty(str3) ? str2 + str3 : str2)) {
                            TLog.m81w("AppLog hit block event v1");
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
                            LogTrace.notifyLogTrace(1, 2, null);
                            return;
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (sEventFilterEnable > 0 && "event_v3".equalsIgnoreCase(str) && (abstractEventFilter = sEventFilter) != null && !abstractEventFilter.filter(str2, jSONObject2)) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
            return;
        }
        AbstractEventFilter abstractEventFilter2 = sEventFilterFromClient;
        if (abstractEventFilter2 != null && !abstractEventFilter2.filter(str2, jSONObject2)) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
            return;
        }
        if (getEventSamplingValue() > 0 && "event_v3".equalsIgnoreCase(str) && (eventSampling = sEventSampling) != null && eventSampling.isHitSamplingDrop(buildSamplingUser(), str2, jSONObject2)) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
            return;
        }
        LogEvent logEvent = new LogEvent();
        logEvent.f36id = sGlobalEventId.incrementAndGet();
        logEvent.category = str;
        logEvent.tag = str2;
        logEvent.label = str3;
        logEvent.value = j;
        logEvent.ext_value = j2;
        logEvent.disable_personalization = sDisablePersonalization;
        NetworkUtils.NetworkType networkType = this.mNetWorkMonitor.getNetworkType();
        if (networkType != null) {
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            try {
                jSONObject2.put("nt", networkType.getValue());
            } catch (Exception unused2) {
            }
        }
        JSONObject jSONObject3 = jSONObject2;
        long j3 = sUserId.get();
        IBDAccountCallback iBDAccountCallback = sIBDAccountCallback;
        if (sEnableEventUserId && iBDAccountCallback != null) {
            Pair odinUserInfo = iBDAccountCallback.getOdinUserInfo();
            if (((Long) odinUserInfo.second).longValue() > 0) {
                logEvent.user_id = ((Long) odinUserInfo.second).longValue();
                logEvent.user_is_login = 1;
                logEvent.user_is_auth = 1;
                logEvent.user_type = ((Integer) odinUserInfo.first).intValue();
                logEvent.uid = ((Long) odinUserInfo.second).longValue();
            } else if (sUserIsLoginFromResp == 0) {
                logEvent.user_is_login = sUserIsLoginFromResp;
                logEvent.user_is_auth = sUserIsAuthFromResp;
                logEvent.user_type = sUserTypeFromResp;
                logEvent.uid = sUidFromResp;
            }
        } else {
            logEvent.user_id = j3;
        }
        if (sEnableKeepUserId && jSONObject3 != null) {
            String str4 = sAbSDKVersion;
            IAbSdkVersion iAbSdkVersion = sIAbSdkVersion;
            if (iAbSdkVersion != null) {
                str4 = iAbSdkVersion.getAbSdkVersion(String.valueOf(logEvent.user_id));
            }
            try {
                try {
                    if (!TextUtils.isEmpty(str4)) {
                        jSONObject3 = jSONObject3;
                        jSONObject3.put(KEY_AB_SDK_VERSION, str4);
                    } else {
                        jSONObject3 = jSONObject3;
                        jSONObject3.remove(KEY_AB_SDK_VERSION);
                    }
                } catch (JSONException unused3) {
                }
            } catch (JSONException unused4) {
                jSONObject3 = jSONObject3;
            }
        }
        if (jSONObject3 != null && jSONObject3.has(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP)) {
            try {
                logEvent.timestamp = jSONObject3.getLong(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
            } catch (Throwable th) {
                th.printStackTrace();
                logEvent.timestamp = System.currentTimeMillis();
            }
            jSONObject3.remove(AppLogNewUtils.EVENT_RESERVED_FIELD_TIME_STAMP);
        } else {
            logEvent.timestamp = System.currentTimeMillis();
        }
        if (jSONObject3 != null) {
            AppContext appContext = sAppContext;
            boolean z2 = appContext != null && "local_test".equalsIgnoreCase(appContext.getChannel());
            try {
                try {
                    logEvent.ext_json = jSONObject3.toString();
                } catch (Throwable th2) {
                    if (z2) {
                        throw new RuntimeException("ext json exception tag: " + str2 + ", label: " + str3, th2);
                    }
                    TLog.m76e("ext json exception tag: " + str2 + ", label: " + str3, th2);
                }
            } catch (StackOverflowError e) {
                if (z2) {
                    throw new RuntimeException("ext json toString stack overflow tag: " + str2 + ", label: " + str3, e);
                }
                TLog.m76e("ext json toString stack overflow tag: " + str2 + ", label: " + str3, e);
            } catch (ConcurrentModificationException unused5) {
                logEvent.ext_json = jSONObject3.toString();
            }
        }
        if (logEvent.ext_json != null && logEvent.ext_json.length() > LIMIT_EVENT_SIZE) {
            LogTrace.notifyLogTrace(5, 0, new Object[]{str, str2, str3, Integer.valueOf(logEvent.ext_json.length())});
        }
        logEvent.instant_only = z;
        logEvent.mHasTimelySend = false;
        if (Logger.debug()) {
            StringBuilder sb = new StringBuilder("onEvent ");
            sb.append(str).append(" ").append(str2).append(" ").append(str3);
            if (j != 0 || j2 != 0 || jSONObject3 != null) {
                sb.append(" ").append(j);
            }
            if (j2 != 0 || jSONObject3 != null) {
                sb.append(" ").append(j2);
            }
            if (jSONObject3 != null) {
                sb.append(" ").append(jSONObject3);
            }
            TLog.m79v("AppLog " + ((Object) sb));
        }
        try {
            if (EventVerify.inst().isEnable()) {
                EventVerify.inst().putEvent(str, str2, str3, j, j2, logEvent.user_id, logEvent.timestamp, jSONObject3);
            }
        } catch (Exception unused6) {
        }
        AppLogDevToolsUtils.sendReceiveEvent(AppLogDevToolsUtils.getEventType(logEvent.category), logEvent);
        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ACCEPT_EVENT_COUNT);
        ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.EVENT);
        actionQueueItem.obj = logEvent;
        enqueue(actionQueueItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long doGetLastActivteTime() {
        if (this.mActivityRecord != null) {
            return System.currentTimeMillis();
        }
        return this.mActivityTime;
    }

    void onActivityResume(ActivityRecord activityRecord) {
        if (!this.mInitOk || activityRecord == null) {
            return;
        }
        if (this.mActivityRecord != null) {
            TLog.m81w("AppLog onPause not call on " + this.mActivityRecord.mActivityClassName);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.mActivityTime = currentTimeMillis;
        this.mActivityRecord = activityRecord;
        if (Logger.debug()) {
            TLog.m79v("AppLog onResume " + activityRecord.mActivityClassName);
        }
        ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.PAGE_START);
        actionQueueItem.arg = currentTimeMillis;
        enqueue(actionQueueItem);
    }

    void onActivityPause(ActivityRecord activityRecord) {
        if (!this.mInitOk || activityRecord == null) {
            return;
        }
        String str = activityRecord.mActivityClassName;
        long currentTimeMillis = System.currentTimeMillis();
        ActivityRecord activityRecord2 = this.mActivityRecord;
        if (activityRecord2 == null || (activityRecord2 != null && activityRecord2.mHashcode != activityRecord.mHashcode)) {
            TLog.m81w("AppLog unmatched onPause: " + str + " " + (activityRecord2 != null ? activityRecord2.mActivityClassName : "(null)"));
            this.mActivityTime = currentTimeMillis - 1010;
        }
        this.mActivityRecord = null;
        int i = (int) ((currentTimeMillis - this.mActivityTime) / 1000);
        if (i <= 0) {
            i = 1;
        }
        this.mActivityTime = currentTimeMillis;
        if (Logger.debug()) {
            TLog.m79v("AppLog onPause " + i + " " + str);
        }
        LogPage logPage = new LogPage();
        logPage.name = str;
        logPage.duration = i;
        ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.PAGE_END);
        actionQueueItem.obj = logPage;
        actionQueueItem.arg = currentTimeMillis;
        enqueue(actionQueueItem);
    }

    void updateUserAgentString(String str) {
        DeviceRegisterManager.updateUserAgentString(this.mContext, str);
    }

    void doSaveDnsReportTime(long j) {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
        edit.putLong(KEY_DNS_REPORT_TIME, j);
        edit.commit();
    }

    void doRecordMiscLog(String str, JSONObject jSONObject) {
        try {
            LogSession logSession = this.mSession;
            long j = logSession != null ? logSession.f39id : 0L;
            if (!this.mInitOk || j <= 0 || StringUtils.isEmpty(str) || jSONObject == null) {
                return;
            }
            String jSONObject2 = jSONObject.toString();
            long insertMiscLog = DBHelper.getInstance(this.mContext).insertMiscLog(j, str, jSONObject2, jSONObject.optLong(KEY_EVENT_ID));
            if (jSONObject2 != null && jSONObject2.length() > LIMIT_EVENT_SIZE) {
                LogTrace.notifyLogTrace(5, 0, new Object[]{"misc", str, "", Integer.valueOf(jSONObject2.length())});
            }
            if (insertMiscLog < 0) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            } else {
                AppLogDevToolsUtils.sendSaveDbMiscEvent(str, jSONObject);
            }
        } catch (Exception unused) {
        }
    }

    void incImageSuccessCount() {
        this.mImageSuccessCount.incrementAndGet();
    }

    void incImageFailureCount() {
        this.mImageFailureCount.incrementAndGet();
    }

    void doOnImageSample(String str, int i, long j) {
        if (this.mAllowOldImageSample) {
            ImageSample imageSample = new ImageSample(str, i, j, System.currentTimeMillis());
            ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.IMAGE_SAMPLE);
            actionQueueItem.obj = imageSample;
            enqueue(actionQueueItem);
        }
    }

    void processItem(ActionQueueItem actionQueueItem) {
        OnResetListener onResetListener;
        long j;
        if ((sIsTouristMode && !sEnableEventInTouristMode && (ActionQueueType.PAGE_START == actionQueueItem.type || ActionQueueType.PAGE_END == actionQueueItem.type || ActionQueueType.EVENT == actionQueueItem.type || ActionQueueType.SAVE_MISC_LOG == actionQueueItem.type)) || !this.mInitOk || sStopped) {
            return;
        }
        BlockHelper.tryBlock();
        boolean z = false;
        switch (C03705.$SwitchMap$com$ss$android$common$applog$AppLog$ActionQueueType[actionQueueItem.type.ordinal()]) {
            case 1:
                if (actionQueueItem.obj instanceof LogEvent) {
                    handleEvent((LogEvent) actionQueueItem.obj);
                    return;
                }
                return;
            case 2:
                if (StringUtils.isEmpty(actionQueueItem.strArg) || !(actionQueueItem.obj instanceof JSONObject)) {
                    return;
                }
                doRecordMiscLog(actionQueueItem.strArg, (JSONObject) actionQueueItem.obj);
                return;
            case 3:
                tryExtendSession(actionQueueItem.arg, false);
                long j2 = actionQueueItem.arg;
                LogSession logSession = this.mSession;
                TaskPresenter.inst(this.mContext).onExitBg(j2, logSession != null ? logSession.value : "");
                sendHeartbeat();
                return;
            case 4:
                long j3 = actionQueueItem.arg;
                LogSession logSession2 = this.mSession;
                TaskPresenter.inst(this.mContext).onEnterBg(j3, logSession2 != null ? logSession2.value : "");
                if (actionQueueItem.obj instanceof LogPage) {
                    handlePageEnd((LogPage) actionQueueItem.obj, actionQueueItem.arg);
                }
                sendHeartbeat();
                return;
            case 5:
                if (actionQueueItem.obj instanceof ImageSample) {
                    handleImageSample((ImageSample) actionQueueItem.obj);
                    return;
                }
                return;
            case 6:
            case 9:
            default:
                return;
            case 7:
                if (actionQueueItem.obj instanceof JSONObject) {
                    try {
                        z = Boolean.valueOf(actionQueueItem.strArg).booleanValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    handleConfigUpdate((JSONObject) actionQueueItem.obj, z);
                }
                notifyRemoteConfigUpdate(true);
                return;
            case 8:
                if (actionQueueItem.obj instanceof String) {
                    updateUserAgentString((String) actionQueueItem.obj);
                    return;
                }
                return;
            case 10:
                if (actionQueueItem.arg > 0) {
                    doSaveDnsReportTime(actionQueueItem.arg);
                    return;
                }
                return;
            case 11:
                if (actionQueueItem.obj instanceof Bundle) {
                    updateCustomerHeader((Bundle) actionQueueItem.obj);
                    return;
                }
                return;
            case 12:
                if (actionQueueItem.obj instanceof JSONObject) {
                    updateDid((JSONObject) actionQueueItem.obj);
                    return;
                }
                return;
            case 13:
                if (actionQueueItem.obj instanceof String) {
                    updateGoogleAID((String) actionQueueItem.obj);
                    return;
                }
                return;
            case 14:
                if (actionQueueItem.obj instanceof JSONObject) {
                    updateAppLanguageAndRegion((JSONObject) actionQueueItem.obj);
                    return;
                }
                return;
            case 15:
                doClearWhenSwitchChildMode(actionQueueItem.arg > 0);
                if (actionQueueItem.countDownLatch != null) {
                    actionQueueItem.countDownLatch.countDown();
                    return;
                }
                return;
            case 16:
                if (actionQueueItem.obj instanceof Pair) {
                    onResetListener = (OnResetListener) ((Pair) actionQueueItem.obj).first;
                    j = ((Long) ((Pair) actionQueueItem.obj).second).longValue();
                } else {
                    onResetListener = null;
                    j = 0;
                }
                doResetWhenSwitchChildMode(actionQueueItem.arg > 0, j, onResetListener);
                if (actionQueueItem.countDownLatch != null) {
                    actionQueueItem.countDownLatch.countDown();
                    return;
                }
                return;
            case 17:
                forceFlushEvent();
                return;
            case 18:
                updateUserUniqueId((String) actionQueueItem.obj);
                return;
            case 19:
                if (this.mLogReaper == null || this.mLogReaper.isAlive()) {
                    return;
                }
                try {
                    this.mLogReaper.start();
                    return;
                } catch (Throwable th) {
                    TLog.m76e("AppLog delay start LogReaper", th);
                    return;
                }
        }
    }

    private void updateGoogleAID(String str) {
        if (StringUtils.isEmpty(str) || this.mLogReaper == null) {
            return;
        }
        try {
            if (str.equals(this.mHeader.optString("google_aid", null))) {
                return;
            }
            if (!sChildMode) {
                this.mHeader.put("google_aid", str);
                if (this.mLogReaper != null) {
                    this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
                }
            }
            this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit().putString("google_aid", str).commit();
        } catch (Throwable unused) {
        }
    }

    private void updateAppLanguageAndRegion(JSONObject jSONObject) {
        if (updateAppLanguage(jSONObject.optString("app_language", null)) || updateAppRegion(jSONObject.optString("app_region", null))) {
            DeviceRegisterManager.updateDeviceInfo();
            TLog.m73d("AppLog updateDeviceInfo call device_register");
        }
    }

    private boolean updateAppLanguage(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.equals(this.mHeader.optString("app_language", null))) {
                this.mHeader.put("app_language", str);
                if (this.mLogReaper != null) {
                    this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
                }
                this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit().putString("app_language", str).commit();
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private boolean updateAppRegion(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.equals(this.mHeader.optString("app_region", null))) {
                this.mHeader.put("app_region", str);
                if (this.mLogReaper != null) {
                    this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
                }
                this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit().putString("app_region", str).commit();
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void updateCustomerHeader(Bundle bundle) {
        if (bundle == null || bundle.size() <= 0 || this.mLogReaper == null) {
            return;
        }
        try {
            JSONObject optJSONObject = this.mHeader.optJSONObject("custom");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            for (String str : bundle.keySet()) {
                optJSONObject.put(str, bundle.get(str));
            }
            this.mHeader.put("custom", optJSONObject);
            if (this.mLogReaper != null) {
                this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
            }
            ensureHeaderCopy();
        } catch (Throwable unused) {
        }
    }

    private void updateDid(JSONObject jSONObject) {
        Log.d(TAG, "updateDid " + jSONObject);
        if (jSONObject == null) {
            return;
        }
        boolean isBadDeviceId = isBadDeviceId(this.mHeader.optString("device_id", null));
        String optString = jSONObject.optString("device_id", null);
        String optString2 = jSONObject.optString("install_id", null);
        if (!StringUtils.isEmpty(optString)) {
            try {
                this.mHeader.put("device_id", optString);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (!StringUtils.isEmpty(optString2)) {
            try {
                this.mHeader.put("install_id", optString2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (this.mLogReaper != null) {
            try {
                this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        ensureHeaderCopy();
        tryUpdateConfig(true, true, isBadDeviceId);
    }

    void checkSessionEnd() {
        LogSession logSession = this.mSession;
        if (logSession == null || logSession.non_page) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mSession.active || currentTimeMillis - this.mSession.pausetime < getTerminateSessionInterval()) {
            return;
        }
        LogSession logSession2 = this.mSession;
        onSessionEnd();
        this.mSession = null;
        LogQueueSwitchSession logQueueSwitchSession = new LogQueueSwitchSession();
        logQueueSwitchSession.old = logSession2;
        enqueue(logQueueSwitchSession);
    }

    void onSessionEnd() {
        LogSession logSession = this.mSession;
        if (logSession == null) {
            return;
        }
        DBHelper dBHelper = DBHelper.getInstance(this.mContext);
        int i = 0;
        int andSet = this.mImageSuccessCount.getAndSet(0);
        int andSet2 = this.mImageFailureCount.getAndSet(0);
        if (logSession != null && logSession.f39id > 0) {
            if (andSet > 0 || andSet2 > 0) {
                LogEvent logEvent = new LogEvent();
                logEvent.category = LynxMemoryInfo.TYPE_IMAGE;
                logEvent.tag = "stats";
                logEvent.value = andSet;
                logEvent.ext_value = andSet2;
                logEvent.timestamp = logSession.pausetime;
                logEvent.session_id = logSession.f39id;
                dBHelper.insertEvent(logEvent);
            }
            if (!this.mAllowOldImageSample) {
                this.mSamples.clear();
            }
            Iterator<ImageSample> it = this.mSamples.iterator();
            while (it.hasNext()) {
                ImageSample next = it.next();
                LogEvent logEvent2 = new LogEvent();
                logEvent2.category = LynxMemoryInfo.TYPE_IMAGE;
                logEvent2.tag = "sample";
                logEvent2.label = next.url;
                logEvent2.value = next.networktype;
                logEvent2.ext_value = next.time;
                logEvent2.timestamp = next.timestamp;
                logEvent2.session_id = logSession.f39id;
                dBHelper.insertEvent(logEvent2);
                i++;
                if (i >= 5) {
                    break;
                }
            }
        }
        this.mSamples.clear();
    }

    void tryExtendSession(long j, boolean z) {
        DBHelper dBHelper = DBHelper.getInstance(this.mContext);
        LogSession logSession = this.mSession;
        if (!(logSession == null || (!logSession.active && j - this.mSession.pausetime >= getTerminateSessionInterval()) || (this.mSession.non_page && !z))) {
            if (z) {
                return;
            }
            this.mSession.active = true;
            this.mSession.pausetime = j;
            return;
        }
        onSessionEnd();
        LogSession logSession2 = this.mSession;
        LogSession logSession3 = new LogSession();
        logSession3.value = genSession();
        logSession3.timestamp = j;
        resetEventIndex();
        logSession3.eventIndex = this.mGlobalEventIndexMatrix.getAndIncrement();
        logSession3.pausetime = logSession3.timestamp;
        logSession3.duration = 0;
        logSession3.app_version = RegistrationHeaderHelper.getVersionName();
        logSession3.version_code = RegistrationHeaderHelper.getVersionCode();
        logSession3.non_page = z;
        if (!z) {
            logSession3.active = true;
        }
        long insertSession = dBHelper.insertSession(logSession3);
        if (insertSession > 0) {
            logSession3.f39id = insertSession;
            this.mSession = logSession3;
            TLog.m77i("AppLog start new session " + logSession3.value);
            notifySessionStart(insertSession);
        } else {
            this.mSession = null;
        }
        if (logSession2 != null || this.mSession != null) {
            LogQueueSwitchSession logQueueSwitchSession = new LogQueueSwitchSession();
            logQueueSwitchSession.old = logSession2;
            if (mLaunchFrom <= 0) {
                mLaunchFrom = 6;
            }
            LogSession logSession4 = this.mSession;
            if (logSession4 != null && !logSession4.non_page) {
                logQueueSwitchSession.launch_session = this.mSession;
            }
            enqueue(logQueueSwitchSession);
        }
        LaunchObserverHolder.getInstance().onLaunch(String.valueOf(insertSession), j, z);
    }

    private void notifySessionStart(long j) {
        List<ILogSessionHook> list = sSessionHookList;
        if (list == null) {
            return;
        }
        synchronized (list) {
            Iterator<ILogSessionHook> it = list.iterator();
            while (it.hasNext()) {
                it.next().onLogSessionStart(j);
            }
        }
    }

    void handlePageEnd(LogPage logPage, long j) {
        LogSession logSession = this.mSession;
        if (logSession == null) {
            TLog.m81w("AppLog no session when onPause: " + logPage.name);
            return;
        }
        if (logSession.non_page) {
            TLog.m81w("AppLog non-page session when onPause: " + logPage.name);
            return;
        }
        this.mSession.active = false;
        this.mSession.pausetime = j;
        logPage.session_id = this.mSession.f39id;
        DBHelper.getInstance(this.mContext).insertPage(logPage, j);
        try {
            JSONObject jSONObject = new JSONObject();
            int i = this.mImageSuccessCount.get();
            int i2 = this.mImageFailureCount.get();
            jSONObject.put("session_id", this.mSession.value);
            jSONObject.put(KEY_CNT_SUCCESS, i);
            jSONObject.put(KEY_CNT_FAILURE, i2);
            JSONArray jSONArray = new JSONArray();
            Iterator<ImageSample> it = this.mSamples.iterator();
            while (it.hasNext()) {
                ImageSample next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", next.url);
                jSONObject2.put(KEY_NETWORKTYPE, next.networktype);
                jSONObject2.put("time", next.time);
                jSONObject2.put("timestamp", next.timestamp);
                jSONArray.put(jSONObject2);
            }
            if (jSONArray.length() > 0) {
                jSONObject.put(KEY_SAMPLES, jSONArray);
            }
            SharedPreferences.Editor edit = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
            edit.putString(SP_KEY_STATS_VALUE, jSONObject.toString());
            edit.commit();
        } catch (Exception unused) {
        }
    }

    private void loadGlobalEventIndex() {
        this.mGlobalEventIndexMatrix.set(0L);
        this.mGlobalEventIndexMatrixV1.set(0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void tryPutEventIndex(JSONObject jSONObject) {
        AppLog appLog = sInstance;
        if (appLog != null) {
            try {
                jSONObject.put(KEY_EVENT_INDEX, appLog.mGlobalEventIndexMatrix.getAndIncrement());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    static void resetEventIndex() {
        AppLog appLog = sInstance;
        if (appLog != null) {
            appLog.mGlobalEventIndexMatrix.set(0L);
            appLog.mGlobalEventIndexMatrixV1.set(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long genEventIndex() {
        AppLog appLog = sInstance;
        if (appLog != null) {
            return appLog.mGlobalEventIndexMatrix.getAndIncrement();
        }
        return -1L;
    }

    void handleEvent(LogEvent logEvent) {
        notifyOnEvent(logEvent);
        tryExtendSession(logEvent.timestamp, true);
        if (this.mSession == null) {
            LogTrace.notifyLogTrace(1, 4, null);
            return;
        }
        if ("event_v3".equalsIgnoreCase(logEvent.category)) {
            logEvent.teaEventIndex = this.mGlobalEventIndexMatrix.getAndIncrement();
        } else {
            logEvent.teaEventIndex = this.mGlobalEventIndexMatrixV1.getAndIncrement();
        }
        logEvent.session_id = this.mSession.f39id;
        if (handleEventTimely(logEvent, this.mSession.value)) {
            return;
        }
        long insertEvent = DBHelper.getInstance(this.mContext).insertEvent(logEvent);
        if (insertEvent > 0) {
            AppLogDevToolsUtils.sendSaveDbEvent(AppLogDevToolsUtils.getEventType(logEvent.category), logEvent);
            sendHeartbeat();
        }
        if (insertEvent < 0) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
        }
    }

    private void notifyOnEvent(LogEvent logEvent) {
        if (sGlobalEventCallback != null) {
            sGlobalEventCallback.onEvent(logEvent.category, logEvent.tag, logEvent.label, logEvent.value, logEvent.ext_value, logEvent.instant_only, logEvent.ext_json);
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [com.ss.android.common.applog.AppLog$1] */
    private boolean handleEventTimely(final LogEvent logEvent, String str) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (logEvent != null && !logEvent.mHasTimelySend && currentTimeMillis - this.mStartWaitSendTimely >= 900000 && "event_v3".equalsIgnoreCase(logEvent.category) && (concurrentHashMap = this.mEventTimely) != null && concurrentHashMap.size() > 0 && !StringUtils.isEmpty(logEvent.tag) && this.mEventTimely.containsKey(logEvent.tag) && !StringUtils.isEmpty(logEvent.ext_json)) {
                JSONObject jSONObject = new JSONObject(logEvent.ext_json);
                if (jSONObject.optInt("_event_v3", 0) == 1) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REALTIME_EVENT_COUNT);
                    AppLogDevToolsUtils.sendRealtimeEvent(logEvent);
                    JSONObject jSONObject2 = new JSONObject();
                    JSONObject jSONObject3 = new JSONObject();
                    if (jSONObject.has("nt")) {
                        jSONObject3.put("nt", jSONObject.optInt("nt"));
                    }
                    if (logEvent.user_id > 0) {
                        jSONObject3.put("user_id", logEvent.user_id);
                        jSONObject3.put(KEY_USER_IS_LOGIN, logEvent.user_is_login);
                        jSONObject3.put(KEY_USER_TYPE, logEvent.user_type);
                        jSONObject3.put(KEY_USER_IS_AUTH, logEvent.user_is_auth);
                    }
                    jSONObject.remove("nt");
                    jSONObject.remove("_event_v3");
                    jSONObject3.put("event", logEvent.tag);
                    jSONObject3.put("params", jSONObject);
                    jSONObject3.put("session_id", realtimeEventUseSessionUuid ? str : Long.valueOf(logEvent.session_id));
                    jSONObject3.put(KEY_DATETIME, formatDate(logEvent.timestamp));
                    jSONObject3.put(KEY_LOCAL_TIME_MS, logEvent.timestamp);
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject2.put("event_v3", jSONArray);
                    JSONObject jSONObject4 = this.mTimeSync;
                    if (jSONObject4 != null) {
                        jSONObject2.put(KEY_TIME_SYNC, jSONObject4);
                    }
                    jSONObject2.put(KEY_MAGIC_TAG, MAGIC_TAG);
                    JSONObject updateEventTimelyHeader = ApplogHeaderUtils.updateEventTimelyHeader(this.mContext, this.mHeader);
                    updateEventTimelyHeader.optString("device_id");
                    jSONObject2.put("header", updateEventTimelyHeader);
                    jSONObject2.put(KEY_GEN_TIME, System.currentTimeMillis());
                    final String jSONObject5 = jSONObject2.toString();
                    new ThreadPlus() { // from class: com.ss.android.common.applog.AppLog.1
                        public void run() {
                            super.run();
                            try {
                                if (!AppLog.this.sendTimelyEvent(jSONObject5)) {
                                    AppLogDevToolsUtils.sendReportedEvent(logEvent, false);
                                    LogEvent logEvent2 = new LogEvent();
                                    logEvent2.category = logEvent.category;
                                    logEvent2.tag = logEvent.tag;
                                    logEvent2.label = logEvent.label;
                                    logEvent2.value = logEvent.value;
                                    logEvent2.ext_value = logEvent.ext_value;
                                    logEvent2.mHasTimelySend = true;
                                    logEvent2.user_id = logEvent.user_id;
                                    logEvent2.user_is_login = logEvent.user_is_login;
                                    logEvent2.user_type = logEvent.user_type;
                                    logEvent2.user_is_auth = logEvent.user_is_auth;
                                    logEvent2.ext_json = logEvent.ext_json;
                                    logEvent2.instant_only = logEvent.instant_only;
                                    logEvent2.timestamp = logEvent.timestamp;
                                    ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.EVENT);
                                    actionQueueItem.obj = logEvent2;
                                    AppLog.this.enqueue(actionQueueItem);
                                } else {
                                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_SUCCESS_EVENT_COUNT);
                                    AppLogDevToolsUtils.sendReportedEvent(logEvent, true);
                                }
                            } catch (Throwable th) {
                                TLog.m76e("send timely event failed", th);
                            }
                        }
                    }.start();
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e6 A[Catch: all -> 0x0106, TryCatch #0 {all -> 0x0106, blocks: (B:3:0x0007, B:5:0x0023, B:7:0x002a, B:9:0x0032, B:11:0x0057, B:14:0x005d, B:17:0x0077, B:19:0x00b6, B:23:0x00bd, B:25:0x00d1, B:29:0x00e6, B:34:0x00f0, B:38:0x0080, B:41:0x009d), top: B:2:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sendTimelyEvent(String str) {
        int responseCode;
        boolean z;
        int i;
        String doPost;
        boolean z2;
        try {
            TLog.m73d("AppLog app_log_config: " + str);
            byte[] bytes = str.getBytes(HTTP.UTF_8);
            if (APPLOG_TIMELY_URL() != null && APPLOG_TIMELY_URL().length != 0) {
                String[] APPLOG_TIMELY_URL = APPLOG_TIMELY_URL();
                int length = APPLOG_TIMELY_URL.length;
                int i2 = 0;
                while (i2 < length) {
                    String filterQuery = NetUtilWrapper.filterQuery(NetUtil.addCommonParams(APPLOG_TIMELY_URL[i2], true), NetUtilWrapper.KEYS_REPORT_QUERY);
                    byte[] bArr = (byte[]) bytes.clone();
                    Map<String, String> logHttpHeader = getLogHttpHeader();
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_COUNT);
                    if (this.mContext != null && getLogEncryptSwitch()) {
                        try {
                            z = true;
                            i = i2;
                            try {
                                doPost = NetUtil.sendEncryptLog(getLogCompressor(), filterQuery, bArr, this.mContext, false, null, logHttpHeader, str, false, true);
                            } catch (RuntimeException unused) {
                                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                doPost = NetUtil.doPost(getLogCompressor(), filterQuery, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
                                if (doPost != null) {
                                    JSONObject jSONObject = new JSONObject(doPost);
                                    if (MAGIC_TAG.equals(jSONObject.optString(KEY_MAGIC_TAG))) {
                                    }
                                    if (!z2) {
                                    }
                                    return z2;
                                }
                                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                                i2 = i + 1;
                            }
                        } catch (RuntimeException unused2) {
                            z = true;
                            i = i2;
                        }
                    } else {
                        z = true;
                        i = i2;
                        doPost = NetUtil.doPost(getLogCompressor(), filterQuery, bytes, true, CONTENT_TYPE, false, logHttpHeader, false, true);
                    }
                    if (doPost != null && doPost.length() != 0) {
                        JSONObject jSONObject2 = new JSONObject(doPost);
                        z2 = (MAGIC_TAG.equals(jSONObject2.optString(KEY_MAGIC_TAG)) || !"success".equals(jSONObject2.optString("message"))) ? false : z;
                        if (!z2) {
                            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                        }
                        return z2;
                    }
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REPORT_REQUEST_FAILED_COUNT);
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                    i2 = i + 1;
                }
            }
        } catch (Throwable th) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
            if ((th instanceof CommonHttpException) && (responseCode = th.getResponseCode()) >= 500 && responseCode < 600) {
                this.mStartWaitSendTimely = System.currentTimeMillis();
            }
            TLog.m76e("AppLog updateConfig exception: ", th);
        }
        return false;
    }

    void handleImageSample(ImageSample imageSample) {
        if (this.mSamples.size() >= 5) {
            this.mSamples.removeFirst();
        }
        this.mSamples.add(imageSample);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAppTrack(JSONObject jSONObject) {
        DeviceRegisterManager.saveAppTrack(this.mContext, jSONObject);
    }

    private static boolean isApiSuccess(JSONObject jSONObject) {
        return "success".equals(jSONObject.optString("message"));
    }

    private static boolean optBoolean(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return z;
        }
        int optInt = jSONObject.optInt(str, -1);
        if (optInt >= 1) {
            return true;
        }
        if (optInt == 0) {
            return false;
        }
        return jSONObject.optBoolean(str, z);
    }

    public static JSONObject getHeaderCopy() {
        return sAppLogApi.getHeaderCopy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ensureHeaderCopy() {
        try {
            sHeaderCopy = new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS);
        } catch (JSONException e) {
            TLog.m76e("ensureHeaderCopy error", e);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(47:4|5|6|(2:8|(1:10))|12|(1:14)|15|16|17|(3:19|56|24)|29|(1:31)(1:129)|32|(2:36|(30:38|39|(3:43|(3:45|(1:47)(1:49)|48)|50)|51|(1:127)|55|(1:57)|58|(3:60|(1:62)|63)|64|(1:126)(1:68)|69|(1:71)(1:125)|72|(1:74)(1:124)|75|(1:77)|78|(4:80|(1:82)(1:86)|83|(1:85))|(1:88)|(1:90)|(1:92)|(1:94)|(1:96)|97|98|99|(1:121)(4:103|(3:105|(2:107|108)(1:110)|109)|111|112)|113|(1:119)(2:117|118)))|128|39|(4:41|43|(0)|50)|51|(1:53)|127|55|(0)|58|(0)|64|(1:66)|126|69|(0)(0)|72|(0)(0)|75|(0)|78|(0)|(0)|(0)|(0)|(0)|(0)|97|98|99|(1:101)|121|113|(2:115|119)(1:120)) */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x022e, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x022f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleConfigUpdate(JSONObject jSONObject, boolean z) {
        boolean z2;
        boolean z3;
        long optLong;
        long optLong2;
        int optInt;
        int optInt2;
        boolean z4;
        boolean z5;
        boolean z6;
        int optInt3;
        SharedPreferences.Editor edit;
        JSONArray optJSONArray;
        if (jSONObject == null) {
            return;
        }
        this.mUpdateConfigTime = System.currentTimeMillis();
        this.mLastConfigVersion = this.mVersionCode;
        try {
            long optLong3 = jSONObject.optLong(KEY_SERVER_TIME);
            if (optLong3 > 0) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(KEY_SERVER_TIME, optLong3);
                jSONObject2.put(KEY_LOCAL_TIME, System.currentTimeMillis() / 1000);
                this.mTimeSync = jSONObject2;
                if (this.mLogReaper != null) {
                    this.mLogReaper.setTimeSync(this.mTimeSync);
                }
            }
        } catch (Exception unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("config");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String str = null;
        try {
            JSONArray optJSONArray2 = optJSONObject.optJSONArray(KEY_ALLOW_PUSH_LIST);
            if (optJSONArray2 != null) {
                synchronized (sLock) {
                    parseIntSet(this.mAllowPushSet, optJSONArray2);
                }
                str = optJSONArray2.toString();
                this.mAllowPushListJsonStr = str;
            }
        } catch (Exception unused2) {
        }
        boolean optBoolean = optBoolean(optJSONObject, KEY_ALLOW_OLD_IMAGE_SAMPLE, false);
        if (optBoolean != this.mAllowOldImageSample) {
            this.mAllowOldImageSample = optBoolean;
            z2 = true;
        } else {
            z2 = false;
        }
        long optLong4 = optJSONObject.optLong(KEY_SESSION_INTERVAL, 0L);
        if (optLong4 >= 15 && optLong4 <= 300) {
            long j = optLong4 * 1000;
            if (j != this.mSessionInterval) {
                this.mSessionInterval = j;
                z3 = true;
                optLong = optJSONObject.optLong(KEY_BATCH_EVENT_INTERVAL, 60L) * 1000;
                if (checkValidInterval(optLong) && optLong != this.mBatchEventInterval) {
                    this.mBatchEventInterval = optLong;
                    if (this.mLogReaper != null) {
                        this.mLogReaper.setBatchEventInterval(checkValidInterval(sBatchEventInterval) ? sBatchEventInterval : this.mBatchEventInterval);
                    }
                    z3 = true;
                }
                optLong2 = optJSONObject.optLong(KEY_LOG_SETTING_INTERVAL, INTERVAL_LOG_SETTING_DEFAULT) * 1000;
                if (optLong2 >= 1800000 || optLong2 > 172800000) {
                    optLong2 = 21600000;
                }
                if (optLong2 != this.mLogSettingInterval) {
                    this.mLogSettingInterval = optLong2;
                    z3 = true;
                }
                optInt = optJSONObject.optInt(KEY_SEND_LAUNCH_TIMELY);
                if (optInt != this.mSendLaunchTimely) {
                    this.mSendLaunchTimely = optInt;
                    if (this.mLogReaper != null) {
                        this.mLogReaper.setSendLaunchTimely(this.mSendLaunchTimely);
                    }
                    z3 = true;
                }
                optInt2 = optJSONObject.optInt(KEY_HTTP_MONITOR_PORT);
                if (optInt2 > 0 || optInt2 == this.mHttpMonitorPort) {
                    z4 = false;
                } else {
                    this.mHttpMonitorPort = optInt2;
                    z4 = true;
                }
                z5 = optJSONObject.optInt(KEY_DEVICE_REGISTER_THROTTLE, 0) == 0;
                TLog.m73d("AppLog get_deviceRegisterThrottle: " + z5);
                if (z5 == RegisterServiceController.sThrottleByAppLogConfig) {
                    TLog.m73d("AppLog change_deviceRegisterThrottle: " + RegisterServiceController.sThrottleByAppLogConfig);
                    RegisterServiceController.sThrottleByAppLogConfig = z5;
                    z6 = true;
                } else {
                    z6 = false;
                }
                if (sEventFilterEnable > 0) {
                    sEventFilter = AbstractEventFilter.parseFilterFromServer(this.mContext, optJSONObject);
                }
                optInt3 = optJSONObject.optInt(FORBID_REPORT_PHONE_DETAIL_INFO, -1);
                edit = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
                if (optInt3 >= 0) {
                    edit.putInt(FORBID_REPORT_PHONE_DETAIL_INFO, optInt3);
                    boolean z7 = optInt3 > 0;
                    this.mForbidReportPhoneDetailInfo = z7;
                    DeviceRegisterManager.setForbidReportPhoneDetailInfo(z7);
                    RegistrationHeaderHelper.filterHeader(this.mHeader);
                    ensureHeaderCopy();
                    if (this.mLogReaper != null) {
                        this.mLogReaper.filterHeader();
                    }
                }
                if (z3) {
                    edit.putLong(KEY_SESSION_INTERVAL, this.mSessionInterval);
                    edit.putLong(KEY_BATCH_EVENT_INTERVAL, this.mBatchEventInterval);
                    edit.putLong(KEY_LOG_SETTING_INTERVAL, this.mLogSettingInterval);
                    edit.putInt(KEY_SEND_LAUNCH_TIMELY, this.mSendLaunchTimely);
                }
                if (str != null) {
                    edit.putString(KEY_ALLOW_PUSH_LIST, str);
                }
                if (z2) {
                    edit.putBoolean(KEY_ALLOW_OLD_IMAGE_SAMPLE, this.mAllowOldImageSample);
                }
                if (z4) {
                    edit.putInt(KEY_HTTP_MONITOR_PORT, this.mHttpMonitorPort);
                }
                if (z6) {
                    TLog.m73d("AppLog save_deviceRegisterThrottle: " + z5);
                    edit.putBoolean(KEY_DEVICE_REGISTER_THROTTLE, z5);
                }
                edit.putLong(KEY_APP_LOG_CONFIG_LAST_CONFIG_TIME, this.mUpdateConfigTime);
                edit.putInt(KEY_APP_LOG_CONFIG_LAST_CONFIG_VERSION, this.mLastConfigVersion);
                optJSONArray = optJSONObject.optJSONArray(EVENT_TIMELY);
                this.mEventTimely.clear();
                if (optJSONArray == null && optJSONArray.length() > 0) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        String string = optJSONArray.getString(i);
                        if (!StringUtils.isEmpty(string)) {
                            this.mEventTimely.put(string, "timely");
                        }
                    }
                    edit.putString(EVENT_TIMELY, optJSONArray.toString());
                } else {
                    edit.remove(EVENT_TIMELY);
                }
                edit.putInt(CONTENT_ENCODE_METHOD, optJSONObject.optInt(CONTENT_ENCODE_METHOD, 0));
                edit.apply();
                handleConfigUpdate(optJSONObject);
                notifyConfigUpdate();
                if (z || this.mHasTryResendConfig) {
                }
                this.mHasTryResendConfig = true;
                tryUpdateConfig(true, true, false);
                return;
            }
        }
        z3 = false;
        optLong = optJSONObject.optLong(KEY_BATCH_EVENT_INTERVAL, 60L) * 1000;
        if (checkValidInterval(optLong)) {
            this.mBatchEventInterval = optLong;
            if (this.mLogReaper != null) {
            }
            z3 = true;
        }
        optLong2 = optJSONObject.optLong(KEY_LOG_SETTING_INTERVAL, INTERVAL_LOG_SETTING_DEFAULT) * 1000;
        if (optLong2 >= 1800000) {
        }
        optLong2 = 21600000;
        if (optLong2 != this.mLogSettingInterval) {
        }
        optInt = optJSONObject.optInt(KEY_SEND_LAUNCH_TIMELY);
        if (optInt != this.mSendLaunchTimely) {
        }
        optInt2 = optJSONObject.optInt(KEY_HTTP_MONITOR_PORT);
        if (optInt2 > 0) {
        }
        z4 = false;
        if (optJSONObject.optInt(KEY_DEVICE_REGISTER_THROTTLE, 0) == 0) {
        }
        TLog.m73d("AppLog get_deviceRegisterThrottle: " + z5);
        if (z5 == RegisterServiceController.sThrottleByAppLogConfig) {
        }
        if (sEventFilterEnable > 0) {
        }
        optInt3 = optJSONObject.optInt(FORBID_REPORT_PHONE_DETAIL_INFO, -1);
        edit = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
        if (optInt3 >= 0) {
        }
        if (z3) {
        }
        if (str != null) {
        }
        if (z2) {
        }
        if (z4) {
        }
        if (z6) {
        }
        edit.putLong(KEY_APP_LOG_CONFIG_LAST_CONFIG_TIME, this.mUpdateConfigTime);
        edit.putInt(KEY_APP_LOG_CONFIG_LAST_CONFIG_VERSION, this.mLastConfigVersion);
        optJSONArray = optJSONObject.optJSONArray(EVENT_TIMELY);
        this.mEventTimely.clear();
        if (optJSONArray == null) {
        }
        edit.remove(EVENT_TIMELY);
        edit.putInt(CONTENT_ENCODE_METHOD, optJSONObject.optInt(CONTENT_ENCODE_METHOD, 0));
        edit.apply();
        handleConfigUpdate(optJSONObject);
        notifyConfigUpdate();
        if (z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyConfigUpdate() {
        ConfigUpdateListener configUpdateListener;
        WeakReference<ConfigUpdateListener> weakReference = sConfigUpdateListener;
        if (weakReference == null || (configUpdateListener = weakReference.get()) == null) {
            return;
        }
        try {
            configUpdateListener.onConfigUpdate();
        } catch (Exception unused) {
        }
    }

    private void handleConfigUpdate(JSONObject jSONObject) {
        WeakReference<ConfigUpdateListener> weakReference = sConfigUpdateListener;
        if (weakReference != null) {
            ConfigUpdateListener configUpdateListener = weakReference.get();
            if (configUpdateListener instanceof ConfigUpdateListenerEnhanced) {
                try {
                    ((ConfigUpdateListenerEnhanced) configUpdateListener).handleConfigUpdate(jSONObject);
                } catch (Exception unused) {
                }
            }
        }
    }

    private void notifyRemoteConfigUpdate(boolean z) {
        ConfigUpdateListener configUpdateListener;
        WeakReference<ConfigUpdateListener> weakReference = sConfigUpdateListener;
        if (weakReference == null || (configUpdateListener = weakReference.get()) == null) {
            return;
        }
        try {
            configUpdateListener.onRemoteConfigUpdate(z);
        } catch (Exception unused) {
        }
    }

    @Deprecated
    public static void setConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        sAppLogApi.setConfigUpdateListener(configUpdateListener);
    }

    public static void setConfigUpdateListener(ConfigUpdateListenerEnhanced configUpdateListenerEnhanced) {
        sAppLogApi.setConfigUpdateListener(configUpdateListenerEnhanced);
    }

    void parseIntSet(HashSet<Integer> hashSet, JSONArray jSONArray) throws JSONException {
        if (hashSet == null || jSONArray == null) {
            return;
        }
        hashSet.clear();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            int i2 = jSONArray.getInt(i);
            if (i2 > 0) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
    }

    HashSet<Integer> parseIntSet(JSONArray jSONArray) throws JSONException {
        HashSet<Integer> hashSet = new HashSet<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            int i2 = jSONArray.getInt(i);
            if (i2 > 0) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        return hashSet;
    }

    public static String genSession() {
        return UUID.randomUUID().toString();
    }

    public static boolean isValidUDID(String str) {
        int length;
        if (str == null || (length = str.length()) < 13 || length > 160) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    void loadSSIDs() {
        try {
            AppContext appContext = sAppContext;
            if (appContext != null) {
                this.mVersionCode = appContext.getVersionCode();
            }
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0);
            int i = sharedPreferences.getInt(KEY_APP_LOG_CONFIG_LAST_CONFIG_VERSION, 0);
            this.mLastConfigVersion = i;
            if (i == this.mVersionCode) {
                long j = sharedPreferences.getLong(KEY_APP_LOG_CONFIG_LAST_CONFIG_TIME, 0L);
                if (j <= currentTimeMillis) {
                    currentTimeMillis = j;
                }
                this.mUpdateConfigTime = currentTimeMillis;
            }
            try {
                String string = sharedPreferences.getString(KEY_ALLOW_PUSH_LIST, null);
                this.mAllowPushListJsonStr = string;
                if (string != null) {
                    synchronized (sLock) {
                        parseIntSet(this.mAllowPushSet, new JSONArray(string));
                    }
                }
            } catch (Exception e) {
                TLog.m76e("AppLog load allow_push_list exception: ", e);
            }
            this.mAllowOldImageSample = sharedPreferences.getBoolean(KEY_ALLOW_OLD_IMAGE_SAMPLE, false);
            try {
                String string2 = sharedPreferences.getString(EVENT_TIMELY, null);
                if (StringUtils.isEmpty(string2)) {
                    return;
                }
                JSONArray jSONArray = new JSONArray(string2);
                if (jSONArray.length() > 0) {
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        String string3 = jSONArray.getString(i2);
                        if (!StringUtils.isEmpty(string3)) {
                            this.mEventTimely.put(string3, "timely");
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    void loadStats(LogSession logSession) {
        JSONObject jSONObject;
        String optString;
        try {
            this.mSamples.clear();
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0);
            long j = sharedPreferences.getLong(KEY_SESSION_INTERVAL, 30000L);
            if (j >= com.ss.android.common.util.NetworkUtils.DEFAULT_CONN_POOL_TIMEOUT && j <= 300000) {
                this.mSessionInterval = j;
            }
            this.mBatchEventInterval = sharedPreferences.getLong(KEY_BATCH_EVENT_INTERVAL, BATCH_EVENT_INTERVAL_DEFAULT);
            if (checkValidInterval(sBatchEventInterval)) {
                long j2 = this.mBatchEventInterval;
                long j3 = sBatchEventInterval;
                if (j2 != j3) {
                    this.mBatchEventInterval = j3;
                }
            }
            this.mSendLaunchTimely = sharedPreferences.getInt(KEY_SEND_LAUNCH_TIMELY, 1);
            this.mLogSettingInterval = sharedPreferences.getLong(KEY_LOG_SETTING_INTERVAL, 21600000L);
            this.mHttpMonitorPort = sharedPreferences.getInt(KEY_HTTP_MONITOR_PORT, 0);
            RegisterServiceController.sThrottleByAppLogConfig = sharedPreferences.getBoolean(KEY_DEVICE_REGISTER_THROTTLE, false);
            if (logSession == null) {
                return;
            }
            String string = sharedPreferences.getString(SP_KEY_STATS_VALUE, null);
            if (!StringUtils.isEmpty(string) && (optString = (jSONObject = new JSONObject(string)).optString("session_id", null)) != null && optString.equals(logSession.value)) {
                int optInt = jSONObject.optInt(KEY_CNT_SUCCESS, 0);
                int optInt2 = jSONObject.optInt(KEY_CNT_FAILURE, 0);
                if (optInt > 0) {
                    this.mImageSuccessCount.addAndGet(optInt);
                }
                if (optInt2 > 0) {
                    this.mImageFailureCount.addAndGet(optInt2);
                }
                if (jSONObject.isNull(KEY_SAMPLES)) {
                    return;
                }
                JSONArray jSONArray = jSONObject.getJSONArray(KEY_SAMPLES);
                int length = jSONArray.length();
                if (length > 5) {
                    length = 5;
                }
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String optString2 = jSONObject2.optString("url", null);
                    int i2 = jSONObject2.getInt(KEY_NETWORKTYPE);
                    long j4 = jSONObject2.getLong("time");
                    long j5 = jSONObject2.getLong("timestamp");
                    if (!StringUtils.isEmpty(optString2)) {
                        this.mSamples.add(new ImageSample(optString2, i2, j4, j5));
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    boolean updateConfig(String str, boolean z, long j) {
        sIsConfigThread.set(Boolean.TRUE);
        boolean doUpdateConfig = doUpdateConfig(str, z);
        if (doUpdateConfig && sConfigStartTime > 0) {
            sConfigStartTime = 0L;
        }
        Object obj = sLogConfigLock;
        synchronized (obj) {
            this.mLoadingOnlineConfig = false;
            try {
                obj.notifyAll();
            } catch (Exception unused) {
            }
        }
        sIsConfigThread.remove();
        if (!doUpdateConfig) {
            notifyRemoteConfigUpdate(false);
        }
        return doUpdateConfig;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007c, code lost:
    
        r15 = "&config_retry=b";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008d, code lost:
    
        r0 = com.ss.android.common.applog.NetUtil.sendEncryptLog(getLogCompressor(), r0, r6, r19.mContext, r16, r14, null, null, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0096, code lost:
    
        com.ss.android.common.applog.AppLogNewMonitor.getNewMonitor().increaseStats(com.bytedance.applog.monitor.v3.StatsCountKeys.REQUEST_ERROR_COUNT);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x009f, code lost:
    
        if (r16 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a1, code lost:
    
        r0 = r0 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b2, code lost:
    
        r0 = com.ss.android.common.applog.NetUtil.doPost(null, r0, r3, true, com.ss.android.common.applog.AppLog.CONTENT_TYPE, false, null, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c5, code lost:
    
        if (r16 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00c7, code lost:
    
        r0 = r0 + "&config_retry=b";
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        r0 = com.ss.android.common.applog.NetUtil.doPost(null, r0, r3, true, com.ss.android.common.applog.AppLog.CONTENT_TYPE, false, null, false, false);
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0170 A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:3:0x0005, B:6:0x003f, B:9:0x004f, B:11:0x005c, B:12:0x0060, B:28:0x013f, B:31:0x0146, B:33:0x0170, B:36:0x017a, B:38:0x018e, B:54:0x00ec, B:56:0x00f9, B:62:0x0109, B:63:0x0132, B:65:0x0135, B:67:0x013b), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x017a A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:3:0x0005, B:6:0x003f, B:9:0x004f, B:11:0x005c, B:12:0x0060, B:28:0x013f, B:31:0x0146, B:33:0x0170, B:36:0x017a, B:38:0x018e, B:54:0x00ec, B:56:0x00f9, B:62:0x0109, B:63:0x0132, B:65:0x0135, B:67:0x013b), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean doUpdateConfig(String str, boolean z) {
        String str2;
        int i;
        int responseCode;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] fillKeyIvForEncryptResp = fillKeyIvForEncryptResp(jSONObject, false);
            String jSONObject2 = jSONObject.toString();
            TLog.m73d("AppLog app_log_config: " + jSONObject2);
            byte[] bytes = jSONObject2.getBytes(HTTP.UTF_8);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = true;
            boolean z3 = currentTimeMillis - mLastGetAppConfigTime < KEY_IS_RETRY_INTERVAL;
            mLastGetAppConfigTime = currentTimeMillis;
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CONFIG_REQUEST_COUNT);
            boolean z4 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= 2) {
                    str2 = null;
                    break;
                }
                byte[] bArr = (byte[]) bytes.clone();
                String APPLOG_CONFIG_URL = APPLOG_CONFIG_URL();
                if (z4) {
                    APPLOG_CONFIG_URL = APPLOG_CONFIG_URL_FALLBACK();
                }
                String filterQuery = NetUtilWrapper.filterQuery(NetUtil.addCommonParams(APPLOG_CONFIG_URL, z2), NetUtilWrapper.KEYS_CONFIG_QUERY);
                try {
                    try {
                        if (this.mContext == null || !getLogEncryptSwitch()) {
                            break;
                        }
                        try {
                            break;
                        } catch (RuntimeException unused) {
                            String str3 = "&config_retry=b";
                        }
                    } catch (Throwable th) {
                        th = th;
                        AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
                        if ((th instanceof CommonHttpException) && (responseCode = ((CommonHttpException) th).getResponseCode()) >= 500 && responseCode < 600) {
                            this.mUpdateConfigTime = System.currentTimeMillis();
                            this.mLastConfigVersion = this.mVersionCode;
                            SharedPreferences.Editor edit = this.mContext.getSharedPreferences(AppLogConstants.getSPName(), 0).edit();
                            edit.putLong(KEY_APP_LOG_CONFIG_LAST_CONFIG_TIME, this.mUpdateConfigTime);
                            edit.putInt(KEY_APP_LOG_CONFIG_LAST_CONFIG_VERSION, this.mLastConfigVersion);
                            edit.commit();
                            throw th;
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = i2;
                }
                i2 = i + 1;
                z4 = true;
                z2 = true;
            }
            if (str2 != null && str2.length() != 0) {
                TLog.m73d("AppLog app_log_config response: " + str2);
                JSONObject jSONObject3 = new JSONObject(str2);
                if (MAGIC_TAG.equals(jSONObject3.optString(KEY_MAGIC_TAG))) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT);
                    return false;
                }
                ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.CONFIG_UPDATE);
                actionQueueItem.obj = jSONObject3;
                actionQueueItem.strArg = String.valueOf(z);
                enqueue(actionQueueItem);
                return true;
            }
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.CONFIG_REQUEST_FAILED_COUNT);
            return false;
        } catch (Throwable th3) {
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.REQUEST_ERROR_COUNT);
            TLog.m76e("AppLog updateConfig exception: ", th3);
            return false;
        }
    }

    public static String packJsonObject(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        return packString(jSONObject.toString());
    }

    public static String packString(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                byte[] bytes = str.getBytes(HTTP.UTF_8);
                int length = bytes.length;
                for (int i = 0; i < length; i++) {
                    bytes[i] = (byte) (bytes[i] ^ (-99));
                }
                return Base64.encodeToString(bytes, 10);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    void tryUpdateConfig(boolean z, boolean z2) {
        tryUpdateConfig(z, false, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tryUpdateConfig(boolean z, boolean z2, final boolean z3) {
        JSONObject jSONObject;
        FreeSpaceCollector freeSpaceCollector;
        JSONObject freeSpace;
        if (this.mLoadingOnlineConfig || (jSONObject = this.mHeader) == null) {
            return;
        }
        if (isBadDeviceId(jSONObject.optString("device_id", null))) {
            Log.e(TAG, "tryUpdateConfig no did");
            return;
        }
        if (StringUtils.isEmpty(this.mHeader.optString("install_id", null))) {
            Log.e(TAG, "tryUpdateConfig no iid");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.mLogSettingInterval;
        boolean z4 = this.mLastConfigVersion == this.mVersionCode;
        if (!sInitWithActivity && this.mActivityTime < 0 && z4) {
            j = 2 * this.mLogSettingInterval;
        }
        long j2 = z4 ? 180000L : BATCH_EVENT_INTERVAL_DEFAULT;
        if (z2) {
            if (this.mTryUpdateConfigTime > this.mUpdateConfigTime && currentTimeMillis - this.mTryUpdateConfigTime < j2) {
                return;
            }
        } else {
            if (currentTimeMillis - this.mUpdateConfigTime < j) {
                return;
            }
            if (currentTimeMillis - this.mTryUpdateConfigTime < j2) {
                TLog.m73d("AppLog next query time : " + DateFormat.getDateTimeInstance().format(new Date(this.mTryUpdateConfigTime + j2)));
                return;
            }
        }
        try {
            final long currentTimeMillis2 = System.currentTimeMillis();
            if (sConfigStartTime <= 0) {
                sConfigStartTime = currentTimeMillis2;
            }
            if (sInterceptLogSetting) {
                return;
            }
            if (!NetworkUtils.isNetworkAvailable(this.mContext)) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
                return;
            }
            this.mTryUpdateConfigTime = currentTimeMillis;
            this.mLoadingOnlineConfig = true;
            JSONObject jSONObject2 = new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS);
            String userAgent = RegistrationHeaderHelper.getUserAgent(this.mContext);
            if (!StringUtils.isEmpty(userAgent)) {
                jSONObject2.put(AppLogConstants.KEY_USER_AGENT, userAgent);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(KEY_MAGIC_TAG, MAGIC_TAG);
            jSONObject3.put("header", jSONObject2);
            jSONObject3.put(KEY_GEN_TIME, System.currentTimeMillis());
            if (mCollectFreeSpace && (freeSpaceCollector = mFreeSpaceCollector) != null && (freeSpace = freeSpaceCollector.getFreeSpace()) != null) {
                jSONObject3.put("photoinfo", freeSpace);
            }
            final String jSONObject4 = jSONObject3.toString();
            if (z) {
                new Thread() { // from class: com.ss.android.common.applog.AppLog.2
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        AppLog.this.updateConfig(jSONObject4, z3, currentTimeMillis2);
                    }
                }.start();
            } else {
                updateConfig(jSONObject4, z3, currentTimeMillis2);
            }
        } catch (Exception unused) {
        }
    }

    boolean trySetupLogReaper() {
        synchronized (this.mHeader) {
            if (this.mHasSetup) {
                return this.mSetupOk;
            }
            boolean z = setupLogReaper();
            this.mSetupOk = z;
            this.mHasSetup = true;
            return z;
        }
    }

    public static String getSigHash(Context context) {
        return sAppLogApi.getSigHash(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setupLogReaper() {
        try {
            try {
                DeviceRegisterInitiator.init(this.mContext, this.mForbidReportPhoneDetailInfo, new ILogDepend() { // from class: com.ss.android.common.applog.AppLog.3
                    @Override // com.ss.android.deviceregister.base.ILogDepend
                    public void onDeviceRegisterEvent(String str, JSONObject jSONObject) {
                        AppLogNewUtils.onEventV3(str, jSONObject);
                    }
                }, sAnonymous, sInitWithActivity, sChildMode, !sHasManualInvokeActiveUser);
            } catch (Exception e) {
                if (Logger.debug()) {
                    throw e;
                }
            }
            this.mInitOk = initHeader(this.mHeader, this.mContext);
            this.mSession = DBHelper.getInstance(this.mContext).getSession(0L);
            initNewMonitor();
            loadStats(this.mSession);
            notifyConfigUpdate();
            if (this.mSession != null) {
                TLog.m73d("AppLog start with last session " + this.mSession.value);
                LogQueueCleanSession logQueueCleanSession = new LogQueueCleanSession();
                logQueueCleanSession.max_session = this.mSession.f39id;
                enqueue(logQueueCleanSession);
            }
            try {
                Bundle bundle = new Bundle();
                Bundle bundle2 = sCustomBundle;
                synchronized (bundle2) {
                    bundle.putAll(bundle2);
                }
                if (bundle.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : bundle.keySet()) {
                        jSONObject.put(str, bundle.get(str));
                    }
                    this.mHeader.put("custom", jSONObject);
                }
            } catch (Throwable unused) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
            }
            this.mLogReaper = new LogReaper(this.mContext, new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS), this.mLogQueue, this.mStopFlag, sSessionHookList, this.mSession, this.mBlockV1, this.mBlockV3);
            this.mLogReaper.setBatchEventInterval(this.mBatchEventInterval);
            this.mLogReaper.setSendLaunchTimely(this.mSendLaunchTimely);
            if (sStartLogReaperDelay > 0) {
                TeaThread.getInst().postDelay(new Runnable() { // from class: com.ss.android.common.applog.AppLog.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AppLog.this.enqueue(new ActionQueueItem(ActionQueueType.DELAY_START_LOG_REAPER));
                    }
                }, sStartLogReaperDelay);
            } else {
                this.mLogReaper.start();
            }
            if (sEventFilterEnable > 0) {
                if (this.mLastConfigVersion == this.mVersionCode) {
                    sEventFilter = AbstractEventFilter.parseFilterFromLocal(this.mContext);
                } else {
                    this.mUpdateConfigTime = 0L;
                    sEventFilter = AbstractEventFilter.parseFilterFromServer(this.mContext, null);
                }
            }
            return true;
        } catch (Exception e2) {
            if (e2 instanceof SQLiteException) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.DB_ERROR_COUNT);
            }
            TLog.m76e("failed to start LogReaper", e2);
            return false;
        }
    }

    private void initNewMonitor() {
        if (sNewMonitorEnabled) {
            MonitorV3AppLogConfig.Builder logEventFilterEnabled = new MonitorV3AppLogConfig.Builder().appId(String.valueOf(getAppId())).channel(DeviceRegisterManager.getChannel(this.mContext)).logSdkVersion(SDK_VERSION).cdid(Cdid.getMainInstanceCdid(this.mContext)).devtoolsEnabled(!LogUtils.isDisabled()).logEventFilterEnabled(sEventFilterEnable > 0);
            AppContext appContext = sAppContext;
            if (appContext != null) {
                logEventFilterEnabled.appName(appContext.getAppName()).version(sAppContext.getVersion()).updateVersionCode(sAppContext.getUpdateVersionCode());
            }
            ILogEncryptConfig iLogEncryptConfig = sLogEncryptCfg;
            if (iLogEncryptConfig != null) {
                logEventFilterEnabled.frequencyControlEnabled(iLogEncryptConfig.getRecoverySwitch());
            }
            MonitorV3Helper newMonitor = AppLogNewMonitor.getNewMonitor();
            MonitorV3Config.Builder networkClient = new MonitorV3Config.Builder().appLogConfig(logEventFilterEnabled.build()).eventReportInterval(this.mBatchEventInterval).networkClient(new BDTrackerNetworkClientWrapper());
            UrlConfig urlConfig2 = urlConfig;
            newMonitor.init(networkClient.reportUrl((urlConfig2 == null || urlConfig2.mApplogURL == null || urlConfig.mApplogURL.length <= 0) ? null : urlConfig.mApplogURL[0]).context(this.mContext).executor(AppLogExecutors.getSingleExecutor()).build());
            return;
        }
        AppLogNewMonitor.getNewMonitor().init(new MonitorV3Config.Builder().build());
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private class ActionReaper extends Thread implements DeviceRegisterManager.OnDeviceConfigUpdateListener {
        private boolean mCheckEnd;

        public ActionReaper() {
            super(AppLog.THREAD_NAME_ACTIONREAPER);
            this.mCheckEnd = false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0078, code lost:
        
            if (r1 == null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x007a, code lost:
        
            r4.this$0.processItem(r1);
            r4.mCheckEnd = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
        
            if (r4.mCheckEnd == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0086, code lost:
        
            r4.mCheckEnd = false;
            r4.this$0.checkSessionEnd();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            ActionQueueItem poll;
            tryPrepareUpdateConfig();
            if (AppLog.this.setupLogReaper()) {
                AppLog.this.ensureHeaderCopy();
                AppLog.this.checkSessionEnd();
                while (true) {
                    synchronized (AppLog.this.mQueue) {
                        if (!AppLog.sStopped) {
                            if (AppLog.this.mQueue.isEmpty()) {
                                try {
                                    if (this.mCheckEnd) {
                                        AppLog.this.mQueue.wait(AppLog.this.getTerminateSessionInterval());
                                    } else {
                                        AppLog.this.mQueue.wait();
                                    }
                                } catch (InterruptedException unused) {
                                }
                                if (!AppLog.sStopped) {
                                    poll = !AppLog.this.mQueue.isEmpty() ? AppLog.this.mQueue.poll() : null;
                                }
                            } else {
                                poll = AppLog.this.mQueue.poll();
                            }
                        }
                    }
                    AppLog.this.tryUpdateConfig(true, false);
                }
                TLog.m73d("AppLog ActionReadper quit");
                return;
            }
            TLog.m75e("AppLog can not setup LogReaper");
        }

        private void tryPrepareUpdateConfig() {
            DeviceRegisterManager.addOnDeviceConfigUpdateListener(this);
        }

        @Override // com.ss.android.deviceregister.DeviceRegisterManager.OnDeviceConfigUpdateListener
        public void onDeviceRegistrationInfoChanged(final String str, final String str2) {
            ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.DEVICE_ID_UPDATE);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("device_id", str);
                jSONObject.put("install_id", str2);
                actionQueueItem.obj = jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
            }
            AppLog.this.enqueue(actionQueueItem);
            AppLog.this.mHasUpdateConfig = true;
            if (LogUtils.isDisabled()) {
                return;
            }
            LogUtils.sendJsonFetcher("device_register_end", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.AppLog.ActionReaper.1
                public Object fetch() {
                    JSONObject jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("appId", String.valueOf(DeviceRegisterManager.getAppId()));
                        jSONObject2.put("did", str);
                        jSONObject2.put("installId", str2);
                    } catch (Throwable unused) {
                    }
                    return jSONObject2;
                }
            });
        }

        @Override // com.ss.android.deviceregister.DeviceRegisterManager.OnDeviceConfigUpdateListener
        public void onRemoteConfigUpdate(boolean z, boolean z2) {
            if (AppLog.this.mHasUpdateConfig) {
                AppLog.this.mHasUpdateConfig = false;
            } else if (z && AppLog.sInitGuard) {
                AppLog.this.tryUpdateConfig(false, true, z2);
            }
        }

        @Override // com.ss.android.deviceregister.DeviceRegisterManager.OnDeviceConfigUpdateListener
        public void onDidLoadLocally(boolean z) {
            synchronized (AppLog.class) {
                boolean unused = AppLog.sHasLoadDid = true;
                if (AppLog.sPendingActiveUser) {
                    AppLog.activeUserInvokeInternal(AppLog.this.mContext);
                }
            }
            if (LogUtils.isDisabled()) {
                return;
            }
            LogUtils.sendJsonFetcher("local_did_load", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.AppLog.ActionReaper.2
                public Object fetch() {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appId", String.valueOf(DeviceRegisterManager.getAppId()));
                        jSONObject.put("did", AppLog.getServerDeviceId());
                        jSONObject.put("installId", DeviceRegisterManager.getInstallId());
                    } catch (Throwable unused2) {
                    }
                    return jSONObject;
                }
            });
        }
    }

    public JSONObject getTimeSync() {
        return sAppLogApi.getTimeSync();
    }

    public static String getAllowPushListJsonStr() {
        AppLog appLog = sInstance;
        return appLog != null ? appLog.mAllowPushListJsonStr : "";
    }

    public static void setAccount(Context context, Account account) {
        DeviceRegisterManager.setAccount(context, account);
    }

    public static void setIsNotRequestSender(boolean z) {
        RegistrationHeaderHelper.setIsNotRequestSender(z);
    }

    public static void setNeedAntiCheating(boolean z) {
        DeviceRegisterManager.setAntiCheatingSwitch(z);
    }

    public static void setOpenBpea(boolean z) {
        DeviceRegisterManager.setOpenBpea(z);
    }

    public void setNewUserMode(boolean z) {
        DeviceRegisterManager.setNewUserMode(this.mContext, z);
    }

    public void setNewUserMode(Context context, boolean z) {
        DeviceRegisterManager.setNewUserMode(context, z);
    }

    public void setAutoNewUserMode(boolean z) {
        INewUserModeManager iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class);
        if (iNewUserModeManager != null) {
            iNewUserModeManager.setAutoNewUserMode(z);
        }
    }

    public boolean isNewUserMode() {
        return DeviceRegisterManager.isNewUserMode(this.mContext);
    }

    public INewUserModeManager newUserMode(Context context) {
        INewUserModeManager iNewUserModeManager = (INewUserModeManager) ServiceManager.getService(INewUserModeManager.class);
        if (iNewUserModeManager != null) {
            return iNewUserModeManager.newUserMode(context);
        }
        return null;
    }

    public static void enableEarlyRegisterNewUserModeService(Context context, String str) {
        DeviceRegisterManager.enableEarlyRegisterNewUserModeService(context, str);
    }

    public static void activeUser(Context context) {
        sAppLogApi.activeUser(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void activeUserInvokeInternal(Context context) {
        if (!sHasLoadDid) {
            synchronized (AppLog.class) {
                if (!sHasLoadDid) {
                    sPendingActiveUser = true;
                    return;
                }
            }
        }
        sPendingActiveUser = false;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - sFetchActiveTime < 900000 || !NetworkUtils.isNetworkAvailable(context)) {
            return;
        }
        sFetchActiveTime = currentTimeMillis;
        ActiveUser.requestActive(context, ACTIVE_USER_URL(), sChildMode, sActiveOnce);
    }

    public static void onAppQuit() {
        sAppLogApi.onAppQuit();
    }

    public static void clearDidAndIid(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        DeviceRegisterManager.clearDidAndIid(context, str);
    }

    @Deprecated
    public static void setUseGoogleAdId(boolean z) {
        sAppLogApi.setUseGoogleAdId(z);
    }

    public static void userProfileCheck(UserProfileHelper.UserProfileCheckCallback userProfileCheckCallback) {
        sAppLogApi.userProfileCheck(userProfileCheckCallback);
    }

    public static void registerAbSdkVersionCallback(IAbSdkVersion iAbSdkVersion) {
        sAppLogApi.registerAbSdkVersionCallback(iAbSdkVersion);
    }

    public static void setAbSDKVersion(String str) {
        tempAbSDKVersion = str;
        sAppLogApi.setAbSDKVersion(str);
    }

    public static String getAbSDKVersion() {
        return sAppLogApi.getAbSDKVersion();
    }

    public static void registerGlobalEventCallback(GlobalEventCallback globalEventCallback) {
        sAppLogApi.registerGlobalEventCallback(globalEventCallback);
    }

    public static void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
        sAppLogApi.registerHeaderCustomCallback(iHeaderCustomTimelyCallback);
    }

    public static IHeaderCustomTimelyCallback getIHeaderCustomTimelyCallback() {
        return sAppLogApi.getIHeaderCustomTimelyCallback();
    }

    public static String getAppVersionMinor() {
        return sAppLogApi.getAppVersionMinor();
    }

    public static void setAppVersionMinor(String str) {
        sAppLogApi.setAppVersionMinor(str);
    }

    public static String getUserUniqueId() {
        return sAppLogApi.getUserUniqueId();
    }

    public static void setUserUniqueId(String str) {
        sAppLogApi.setUserUniqueId(str);
    }

    private void updateUserUniqueId(String str) {
        if (this.mLogReaper != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    this.mHeader.remove(KEY_USER_UNIQUE_ID);
                } else {
                    this.mHeader.put(KEY_USER_UNIQUE_ID, str);
                }
                this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
            } catch (Exception unused) {
            }
        }
    }

    public static void setBatchEventInterval(long j) {
        sBatchEventInterval = j;
    }

    public static void setEventFilterEnable(Context context, int i) {
        sAppLogApi.setEventFilterEnable(context, i);
    }

    public static void setEventSamplingEnable(boolean z) {
        sAppLogApi.setEventSamplingEnable(z);
    }

    public static void setTeaEventSamplingEnable(boolean z) {
        sAppLogApi.setTeaEventSamplingEnable(z);
    }

    public static int getEventSamplingValue() {
        return sEventSamplingValue.get();
    }

    public static void setChildModeBeforeInit(boolean z) {
        sAppLogApi.setChildModeBeforeInit(z);
        DeviceRegisterManager.setChildModeBeforeInit(z);
    }

    public static void clearWhenSwitchChildMode(boolean z) {
        sAppLogApi.clearWhenSwitchChildMode(z);
    }

    public static void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener) {
        sAppLogApi.resetDidWhenSwitchChildMode(context, z, j, onResetListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearOrResetWhenSwitchChildMode(boolean z, ActionQueueType actionQueueType, long j, OnResetListener onResetListener) {
        sChildMode = z;
        AppLog appLog = sInstance;
        if (appLog != null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ActionQueueItem actionQueueItem = new ActionQueueItem(actionQueueType);
            actionQueueItem.arg = z ? 1L : 0L;
            actionQueueItem.obj = new Pair(onResetListener, Long.valueOf(j));
            actionQueueItem.countDownLatch = countDownLatch;
            appLog.enqueue(actionQueueItem);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                TLog.m76e("AppLog clearOrResetWhenSwitchChildMode", e);
            }
        }
    }

    private void doClearWhenSwitchChildMode(boolean z) {
        DeviceRegisterManager.clearWhenSwitchChildMode(z);
        if (z) {
            this.mHeader.remove("openudid");
            this.mHeader.remove("google_aid");
            this.mHeader.remove("device_id");
            this.mHeader.remove("install_id");
        }
        updateHeader(this.mContext, z);
        DBHelper.getInstance(this.mContext).clearAllEvents();
        LogSession logSession = this.mSession;
        boolean z2 = logSession != null ? logSession.non_page : true;
        this.mSession = null;
        tryExtendSession(System.currentTimeMillis(), z2);
    }

    private void doResetWhenSwitchChildMode(boolean z, long j, OnResetListener onResetListener) {
        ActiveUser.requestActive(this.mContext, ACTIVE_USER_URL(), z, false);
        DeviceRegisterManager.resetDidWhenSwitchChildMode(z, j, onResetListener);
        updateHeader(this.mContext, z);
    }

    private void updateHeader(Context context, boolean z) {
        RegistrationHeaderHelper.getHeader(context, this.mHeader, z);
        if (this.mLogReaper != null) {
            try {
                this.mLogReaper.updateHeader(new JSONObject(this.mHeader, ApplogHeaderUtils.HEADER_KEYS));
            } catch (JSONException e) {
                TLog.m76e("AppLog updateHeader", e);
            }
        }
    }

    public static void setEventFilterByClient(List<String> list, boolean z) {
        sAppLogApi.setEventFilterByClient(list, z);
    }

    public static void addLogHttpHeader(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            sLogHttpHeader.remove(str);
        } else {
            sLogHttpHeader.put(str, str2);
        }
    }

    public static Map<String, String> getLogHttpHeader() {
        return sLogHttpHeader;
    }

    public static void setInterceptLogSetting(boolean z) {
        sInterceptLogSetting = z;
    }

    public static void setInterceptAppLog(boolean z) {
        sInterceptAppLog = z;
    }

    public static void setActiveOnce(boolean z) {
        sActiveOnce = z;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class OldAppLogImpl implements IAppLogApi {

        /* renamed from: sp */
        private SharedPreferences f35sp;

        private OldAppLogImpl() {
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAnonymous(boolean z) {
            if (!AppLog.sInitGuard) {
                boolean unused = AppLog.sAnonymous = z;
                return;
            }
            throw new IllegalStateException("please call before init");
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void registerLogRequestCallback(LogTrace.LogRequestTraceCallback logRequestTraceCallback) {
            LogTrace.registerLogRequestCallback(logRequestTraceCallback);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setCollectFreeSpace(boolean z, FreeSpaceCollector freeSpaceCollector) {
            boolean unused = AppLog.mCollectFreeSpace = z;
            FreeSpaceCollector unused2 = AppLog.mFreeSpaceCollector = freeSpaceCollector;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setDBNamme(String str) {
            if (StringUtils.isEmpty(str)) {
                return;
            }
            DBHelper.setDBName(str);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setSPName(String str) {
            if (StringUtils.isEmpty(str)) {
                return;
            }
            AppLogConstants.setSPName(str);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEncryptCountSPName(String str) {
            if (StringUtils.isEmpty(str)) {
                return;
            }
            NetUtilWrapper.setEncryptSPName(str);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void addAppCount() {
            AppLog.sAppCount++;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAppContext(AppContext appContext) {
            AppContext unused = AppLog.sAppContext = appContext;
            DeviceRegisterManager.setAppContext(appContext);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void init(final Context context, boolean z, UrlConfig urlConfig) {
            if (!AppLog.isMainProcess) {
                throw new IllegalArgumentException("Only support main process init!");
            }
            if (urlConfig != null) {
                UrlConfig unused = AppLog.urlConfig = urlConfig;
                AppLog.setDeviceRegisterURL(urlConfig.mDeviceRegisterUrl, urlConfig.mAppActiveUrl);
                if (!LogUtils.isDisabled()) {
                    LogUtils.sendJsonFetcher("init_begin", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.AppLog.OldAppLogImpl.1
                        public Object fetch() {
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("appId", DeviceRegisterManager.getAppId());
                                jSONObject.put("channel", DeviceRegisterManager.getChannel(context));
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(LogMessageConstants.CONFIG_VERSION, DeviceRegisterManager.getVersionName());
                                jSONObject2.put(LogMessageConstants.CONFIG_REQUEST_ENCRYPT_SWITCH, AppLog.getLogEncryptSwitch());
                                jSONObject2.put(LogMessageConstants.CONFIG_EVENT_USER_ID, AppLog.getEnableEventUserId());
                                boolean z2 = true;
                                jSONObject2.put(LogMessageConstants.CONFIG_EVENT_SAMPLING, (AppLog.getEventSamplingValue() & 1) > 0);
                                String str = LogMessageConstants.CONFIG_TEA_EVENT_SAMPLING;
                                if ((AppLog.getEventSamplingValue() & 2) <= 0) {
                                    z2 = false;
                                }
                                jSONObject2.put(str, z2);
                                jSONObject.put("config", jSONObject2);
                            } catch (Throwable unused2) {
                            }
                            return jSONObject;
                        }
                    });
                }
                boolean unused2 = AppLog.sInitGuard = true;
                if (context instanceof Activity) {
                    boolean unused3 = AppLog.sInitWithActivity = true;
                }
                initDefaultCompress(context);
                getInstance(context);
                if (!AppLog.mHasHandledCache) {
                    boolean unused4 = AppLog.mHasHandledCache = true;
                    AppLogCache.getCacheInstance().handleCacheEvent();
                }
                boolean unused5 = AppLog.sHasManualInvokeActiveUser = !z;
                AppLog.mLaunchFrom = 1;
                this.f35sp = context.getSharedPreferences(AppLogConstants.getSPName(), 0);
                if (AppLog.isEnableNetCommOpt()) {
                    NetUtilWrapper.setNetworkProvider(NetworkStatusMonitor.getInstance(context));
                }
                ApplogServiceImpl.isServicePrepared = true;
                ApplogServiceImpl.handleCachedData();
                if (LogUtils.isDisabled()) {
                    return;
                }
                LogUtils.sendString("init_end", String.valueOf(AppLog.getAppId()));
                LogUtils.sendJsonFetcher("start_end", new EventBus.DataFetcher() { // from class: com.ss.android.common.applog.AppLog.OldAppLogImpl.2
                    public Object fetch() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("appId", String.valueOf(AppLog.getAppId()));
                        } catch (Throwable unused6) {
                        }
                        return jSONObject;
                    }
                });
                return;
            }
            throw new IllegalArgumentException("urlConfig must not be null");
        }

        private void initDefaultCompress(Context context) {
            if (getLogCompressor() == null) {
                setLogCompressor(new DefaultCompress(context));
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setPushCustomValues(boolean z, boolean z2, boolean z3, boolean z4) {
            boolean unused = AppLog.sMiPushInclude = z;
            boolean unused2 = AppLog.sHwPushInclude = z2;
            boolean unused3 = AppLog.sMzPushInclude = z3;
            boolean unused4 = AppLog.sAliyunPushInclude = z4;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setMyPushIncludeValues(boolean z) {
            boolean unused = AppLog.sMyPushInclude = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAllowPushService(int i, int i2) {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                if (i2 == 1 || i2 == 0) {
                    synchronized (AppLog.sLock) {
                        if ((appLog.mAllowPushSet.contains(Integer.valueOf(i)) && i2 == 0) || (!appLog.mAllowPushSet.contains(Integer.valueOf(i)) && i2 == 1)) {
                            if (i2 == 1) {
                                appLog.mAllowPushSet.add(Integer.valueOf(i));
                            } else {
                                appLog.mAllowPushSet.remove(Integer.valueOf(i));
                            }
                            appLog.notifyConfigUpdate();
                        }
                    }
                }
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setHttpMonitorPort(int i) {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                synchronized (AppLog.sLock) {
                    if (appLog.mHttpMonitorPort != i) {
                        appLog.mHttpMonitorPort = i;
                        appLog.notifyConfigUpdate();
                    }
                }
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAppTrack(JSONObject jSONObject) {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                synchronized (AppLog.sLock) {
                    if (jSONObject == null) {
                        return;
                    }
                    try {
                        if (appLog.mHeader != null) {
                            appLog.mHeader.put(AppLog.KEY_APP_TRACK, jSONObject);
                        }
                        appLog.saveAppTrack(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void getSSIDs(Map<String, String> map) {
            AppLog appLog;
            synchronized (AppLog.sLock) {
                appLog = !AppLog.sStopped ? AppLog.sInstance : null;
            }
            if (appLog == null) {
                return;
            }
            DeviceRegisterManager.getSSIDs(map);
            String valueOf = String.valueOf(AppLog.sUserId.get());
            if (valueOf != null) {
                map.put("user_id", valueOf);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setCustomerHeader(Bundle bundle) {
            if (bundle != null) {
                try {
                    if (bundle.size() <= 0) {
                        return;
                    }
                    AppLog appLog = AppLog.sInstance;
                    if (appLog == null) {
                        synchronized (AppLog.sCustomBundle) {
                            AppLog.sCustomBundle.putAll(bundle);
                        }
                    } else {
                        appLog.addCustomerHeader(bundle);
                    }
                    DeviceRegisterManager.addCustomerHeaser(bundle);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getInstallId() {
            if (AppLog.sInstance != null) {
                return DeviceRegisterManager.getInstallId();
            }
            return null;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setSessionKey(String str) {
            AppLog.sSessionKey = str;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getSessionKey() {
            return AppLog.sSessionKey;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getUserId() {
            return String.valueOf(AppLog.sUserId.get());
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getClientId() {
            if (AppLog.sInstance != null) {
                return DeviceRegisterManager.getClientUDID();
            }
            return null;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getServerDeviceId() {
            if (AppLog.sInstance != null) {
                return DeviceRegisterManager.getDeviceId();
            }
            return null;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public long getLastActiveTime() {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                return appLog.doGetLastActivteTime();
            }
            return 0L;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public boolean isBadDeviceId(String str) {
            return NetUtil.isBadId(str);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public int getHttpMonitorPort() {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                return appLog.mHttpMonitorPort;
            }
            return 0;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getVersion(Context context) {
            String versionName = AppLog.sInstance != null ? RegistrationHeaderHelper.getVersionName() : null;
            if (StringUtils.isEmpty(versionName) && context != null) {
                try {
                    versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (Exception unused) {
                }
            }
            return versionName == null ? "" : versionName;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setDefaultUserAgent(String str) {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                String userAgent = appLog.getUserAgent();
                if (StringUtils.isEmpty(str) || str.equals(userAgent)) {
                    return;
                }
                ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.UA_UPDATE);
                actionQueueItem.obj = str;
                appLog.enqueue(actionQueueItem);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setUserId(long j) {
            AppLog.sUserId.set(j);
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                appLog.notifyConfigUpdate();
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAppLanguageAndRegion(String str, String str2) {
            if (StringUtils.isEmpty(str) && StringUtils.isEmpty(str2)) {
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (!StringUtils.isEmpty(str)) {
                CountryCommomParams.setAppLanguage(str);
                try {
                    jSONObject.put("app_language", str);
                } catch (JSONException unused) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
            }
            if (!StringUtils.isEmpty(str2)) {
                CountryCommomParams.setAppRegion(str2);
                try {
                    jSONObject.put("app_region", str2);
                } catch (JSONException unused2) {
                    AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.JSON_ERROR_COUNT);
                }
            }
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.UPDATE_APP_LANGUAGE_REGION);
                actionQueueItem.obj = jSONObject;
                appLog.enqueue(actionQueueItem);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void addSessionHook(ILogSessionHook iLogSessionHook) {
            synchronized (AppLog.sSessionHookList) {
                if (AppLog.sSessionHookList.contains(iLogSessionHook)) {
                    return;
                }
                AppLog.sSessionHookList.add(iLogSessionHook);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void removeSessionHook(ILogSessionHook iLogSessionHook) {
            synchronized (AppLog.sSessionHookList) {
                AppLog.sSessionHookList.remove(iLogSessionHook);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setLogEncryptConfig(ILogEncryptConfig iLogEncryptConfig) {
            AppLog.sLogEncryptCfg = iLogEncryptConfig;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setCustomInfo(ICustomInfo iCustomInfo) {
            AppLog.sCustomInfo = iCustomInfo;
            DeviceRegisterManager.setCustomMonitor(iCustomInfo);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onEvent(Context context, String str, String str2, String str3, long j, long j2, boolean z, JSONObject jSONObject) {
            AppLog appLog = AppLog.sInstance;
            if (appLog == null) {
                AppLogCache.getCacheInstance().cacheEvent(str, str2, str3, j, j2, z, jSONObject);
                TLog.m81w("AppLog null context when onEvent");
            } else if (StringUtils.isEmpty(str) || StringUtils.isEmpty(str2)) {
                LogTrace.notifyLogTrace(1, 0, null);
            } else if (appLog != null) {
                appLog.onEvent(str, str2, str3, j, j2, z, jSONObject);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getCurrentSessionId() {
            AppLog appLog = AppLog.sInstance;
            if (appLog == null || appLog.mSession == null) {
                return null;
            }
            return appLog.mSession.value;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void recordMiscLog(Context context, String str, JSONObject jSONObject) {
            AppLog appLog;
            EventSampling eventSampling;
            if (AppLog.sStopped || StringUtils.isEmpty(str) || jSONObject == null || jSONObject.length() <= 0 || (appLog = AppLog.sInstance) == null) {
                return;
            }
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.COLLECT_EVENT_COUNT);
            if (AppLog.getEventSamplingValue() > 0 && (eventSampling = AppLog.sEventSampling) != null && eventSampling.isHitSamplingDrop(appLog.buildSamplingUser(), "log_data", jSONObject)) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FILTER_DROP_EVENT_COUNT);
                return;
            }
            if (EventVerify.inst().isEnable()) {
                jSONObject.put(FrescoMonitorConst.LOG_TYPE, str);
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(jSONObject);
                EventVerify.inst().putEvent("log_data", jSONArray);
            }
            jSONObject.put(AppLog.KEY_EVENT_ID, AppLog.sGlobalEventId.incrementAndGet());
            AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.ACCEPT_EVENT_COUNT);
            AppLogDevToolsUtils.sendReceiveMiscEvent(str, jSONObject);
            ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.SAVE_MISC_LOG);
            actionQueueItem.strArg = str;
            actionQueueItem.obj = jSONObject;
            appLog.enqueue(actionQueueItem);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onImageSuccess() {
            AppLog appLog;
            if (AppLog.sStopped || (appLog = AppLog.sInstance) == null) {
                return;
            }
            appLog.incImageSuccessCount();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onImageFailure() {
            AppLog appLog;
            if (AppLog.sStopped || (appLog = AppLog.sInstance) == null) {
                return;
            }
            appLog.incImageFailureCount();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onImageFailure(String str, int i, int i2) {
            AppLog appLog;
            if (AppLog.sStopped || (appLog = AppLog.sInstance) == null || !appLog.mAllowOldImageSample) {
                return;
            }
            appLog.onEvent(LynxMemoryInfo.TYPE_IMAGE, "fail", str, i, i2, true, (JSONObject) null);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onImageSample(String str, int i, long j) {
            AppLog appLog;
            if (AppLog.sStopped || (appLog = AppLog.sInstance) == null) {
                return;
            }
            appLog.doOnImageSample(str, i, j);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAliYunHanlder(IAliYunHandler iAliYunHandler) {
            NetUtil.setAliYunHanlder(iAliYunHandler);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public int checkHttpRequestException(Throwable th, String[] strArr) {
            return NetUtil.checkHttpRequestException(th, strArr);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onQuit() {
            synchronized (AppLog.sLock) {
                if (AppLog.sStopped) {
                    return;
                }
                AppLog.sStopped = true;
                if (AppLog.sInstance != null) {
                    AppLog.sInstance.stop();
                }
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onResume(Context context) {
            if (context instanceof Activity) {
                onResume(context, context.getClass().getName(), context.hashCode());
            }
            if (AppLog.sHasManualInvokeActiveUser) {
                return;
            }
            AppLog.activeUserInvokeInternal(context.getApplicationContext());
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onResume(Context context, String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            AppLog.sLastResumeActivityName = str;
            AppLog.sLastResumeActivityNameAndTime = AppLog.sLastResumeActivityName + "(" + String.valueOf(System.currentTimeMillis()) + ")";
            ActivityRecord activityRecord = new ActivityRecord(str, i);
            AppLog oldAppLogImpl = getInstance(context);
            if (oldAppLogImpl != null) {
                oldAppLogImpl.onActivityResume(activityRecord);
            }
            DeviceRegisterManager.onResume(context);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onPause(Context context) {
            if (context instanceof Activity) {
                onPause(context, context.getClass().getName(), context.hashCode());
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onPause(Context context, String str, int i) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ActivityRecord activityRecord = new ActivityRecord(str, i);
            AppLog oldAppLogImpl = getInstance(context);
            if (oldAppLogImpl != null) {
                oldAppLogImpl.onActivityPause(activityRecord);
            }
            DeviceRegisterManager.onPause(context);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onActivityCreate(Context context) {
            if (context instanceof Activity) {
                AppLog.sLastCreateActivityName = context.getClass().getName();
                AppLog.sLastCreateActivityNameAndTime = AppLog.sLastCreateActivityName + "(" + String.valueOf(System.currentTimeMillis()) + ")";
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onActivityCreate(String str) {
            AppLog.sLastCreateActivityName = str;
            AppLog.sLastCreateActivityNameAndTime = AppLog.sLastCreateActivityName + "(" + String.valueOf(System.currentTimeMillis()) + ")";
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public AppLog getInstance(Context context) {
            AppLog.enableEarlyRegisterNewUserModeService(context, RegistrationHeaderHelper.getChannel());
            synchronized (AppLog.sLock) {
                if (AppLog.sStopped) {
                    return null;
                }
                if (AppLog.sInstance == null) {
                    AppLog unused = AppLog.sInstance = new AppLog(context);
                    if (Logger.debug()) {
                        TLog.m73d("Process AppLog = " + AppLog.sInstance.toString() + " pid = " + Process.myPid());
                    }
                }
                return AppLog.sInstance;
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public JSONObject getHeaderCopy() {
            return AppLog.sHeaderCopy;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
            if (configUpdateListener == null) {
                WeakReference unused = AppLog.sConfigUpdateListener = null;
            } else {
                WeakReference unused2 = AppLog.sConfigUpdateListener = new WeakReference(configUpdateListener);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setConfigUpdateListener(ConfigUpdateListenerEnhanced configUpdateListenerEnhanced) {
            if (configUpdateListenerEnhanced == null) {
                WeakReference unused = AppLog.sConfigUpdateListener = null;
            } else {
                WeakReference unused2 = AppLog.sConfigUpdateListener = new WeakReference(configUpdateListenerEnhanced);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getSigHash(Context context) {
            return DeviceRegisterManager.getSigHash(context);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public JSONObject getTimeSync() {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                return appLog.mTimeSync;
            }
            return null;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void activeUser(Context context) {
            boolean unused = AppLog.sHasManualInvokeActiveUser = true;
            AppLog.activeUserInvokeInternal(context.getApplicationContext());
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onAppQuit() {
            long unused = AppLog.sFetchActiveTime = 0L;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setUseGoogleAdId(boolean z) {
            if (AppLog.sInitGuard) {
                throw new IllegalStateException("please call before init");
            }
            DeviceRegisterManager.setUseGoogleAdId(z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void userProfileCheck(UserProfileHelper.UserProfileCheckCallback userProfileCheckCallback) {
            Context context;
            AppLog appLog = AppLog.sInstance;
            if (appLog != null && (context = appLog.mContext) != null) {
                String serverDeviceId = getServerDeviceId();
                int appId = AppLog.getAppId();
                String USER_PROFILE_URL = AppLog.USER_PROFILE_URL();
                if (!TextUtils.isEmpty(serverDeviceId) && appId != 0 && !TextUtils.isEmpty(USER_PROFILE_URL)) {
                    if (userProfileCheckCallback != null) {
                        userProfileCheckCallback.onCheckSuccess(String.valueOf(appId), context, serverDeviceId, USER_PROFILE_URL);
                        return;
                    }
                    return;
                }
            }
            if (userProfileCheckCallback != null) {
                userProfileCheckCallback.onCheckFail();
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAbSDKVersion(String str) {
            String unused = AppLog.sAbSDKVersion = str;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getAbSDKVersion() {
            IAbSdkVersion iAbSdkVersion = AppLog.sIAbSdkVersion;
            if (iAbSdkVersion == null) {
                return AppLog.sAbSDKVersion;
            }
            long j = AppLog.sUserId.get();
            IBDAccountCallback iBDAccountCallback = AppLog.sIBDAccountCallback;
            if (iBDAccountCallback != null) {
                j = ((Long) iBDAccountCallback.getOdinUserInfo().second).longValue();
            }
            return iAbSdkVersion.getAbSdkVersion(String.valueOf(j));
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void registerGlobalEventCallback(GlobalEventCallback globalEventCallback) {
            AppLog.sGlobalEventCallback = globalEventCallback;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void registerHeaderCustomCallback(IHeaderCustomTimelyCallback iHeaderCustomTimelyCallback) {
            AppLog.sIHeaderCustomTimelyCallback = iHeaderCustomTimelyCallback;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public IHeaderCustomTimelyCallback getIHeaderCustomTimelyCallback() {
            return AppLog.sIHeaderCustomTimelyCallback;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getAppVersionMinor() {
            return DeviceRegisterManager.getAppVersionMinor();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAppVersionMinor(String str) {
            DeviceRegisterManager.setAppVersionMinor(str);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public String getUserUniqueId() {
            return AppLog.sUserUniqueId;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setUserUniqueId(String str) {
            if ((!TextUtils.isEmpty(str) || TextUtils.isEmpty(AppLog.sUserUniqueId)) && (TextUtils.isEmpty(str) || TextUtils.equals(str, AppLog.sUserUniqueId))) {
                return;
            }
            String unused = AppLog.sUserUniqueId = str;
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                ActionQueueItem actionQueueItem = new ActionQueueItem(ActionQueueType.UPDATE_USER_UNIQUE_ID);
                actionQueueItem.obj = str;
                appLog.enqueue(actionQueueItem);
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEventFilterByClient(List<String> list, boolean z) {
            AbstractEventFilter unused = AppLog.sEventFilterFromClient = AbstractEventFilter.parseFilterFromClient(list, z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setChildModeBeforeInit(boolean z) {
            boolean unused = AppLog.sChildMode = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void clearWhenSwitchChildMode(boolean z) {
            AppLog.clearOrResetWhenSwitchChildMode(z, ActionQueueType.CLEAR_WHEN_SWITCH_CHILD_MODE, 0L, null);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void resetDidWhenSwitchChildMode(Context context, boolean z, long j, OnResetListener onResetListener) {
            AppLog.clearOrResetWhenSwitchChildMode(z, ActionQueueType.RESET_WHEN_SWITCH_CHILD_MODE, j, onResetListener);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEventFilterEnable(Context context, int i) {
            int unused = AppLog.sEventFilterEnable = i;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEventSamplingEnable(boolean z) {
            if (z) {
                AppLog.sEventSamplingValue.set(AppLog.sEventSamplingValue.get() | 1);
            } else {
                AppLog.sEventSamplingValue.set(AppLog.sEventSamplingValue.get() & (-2));
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setTeaEventSamplingEnable(boolean z) {
            if (z) {
                AppLog.sEventSamplingValue.set(AppLog.sEventSamplingValue.get() | 2);
            } else {
                AppLog.sEventSamplingValue.set(AppLog.sEventSamplingValue.get() & (-3));
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void registerAbSdkVersionCallback(IAbSdkVersion iAbSdkVersion) {
            AppLog.sIAbSdkVersion = iAbSdkVersion;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEnableEventUserId(boolean z) {
            boolean unused = AppLog.sEnableEventUserId = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setTouristMode(boolean z) {
            boolean unused = AppLog.sIsTouristMode = z;
            DeviceRegisterManager.setTouristMode(z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEnableEventInTouristMode(boolean z) {
            boolean unused = AppLog.sEnableEventInTouristMode = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setAdjustTerminate(boolean z) {
            boolean unused = AppLog.sAdjustTerminate = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void flush() {
            AppLog appLog = AppLog.sInstance;
            if (appLog != null) {
                AppLogNewMonitor.getNewMonitor().increaseStats(StatsCountKeys.FLUSH_COUNT);
                appLog.enqueue(new ActionQueueItem(ActionQueueType.FLUSH_EVENT));
            }
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setBDAccountCallback(IBDAccountCallback iBDAccountCallback) {
            IBDAccountCallback unused = AppLog.sIBDAccountCallback = iBDAccountCallback;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setLogger(ILogger iLogger) {
            TLog.setLogger(iLogger);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setDisablePersonalization(int i) {
            Integer unused = AppLog.sDisablePersonalization = Integer.valueOf(i);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void addLaunchObserver(ILaunchObserver iLaunchObserver) {
            LaunchObserverHolder.getInstance().addObserver(iLaunchObserver);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void removeLaunchObserver(ILaunchObserver iLaunchObserver) {
            LaunchObserverHolder.getInstance().removeObserver(iLaunchObserver);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public int getEncodeType() {
            SharedPreferences sharedPreferences = this.f35sp;
            if (sharedPreferences != null) {
                return sharedPreferences.getInt(AppLog.CONTENT_ENCODE_METHOD, 0);
            }
            return 0;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setLogCompressor(ILogCompressor iLogCompressor) {
            ILogCompressor unused = AppLog.logCompressor = iLogCompressor;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public ILogCompressor getLogCompressor() {
            return AppLog.logCompressor;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setStartLogReaperDelay(long j) {
            long unused = AppLog.sStartLogReaperDelay = j;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setIsMainProcess(boolean z) {
            boolean unused = AppLog.isMainProcess = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onTaskPause(Context context) {
            TaskPresenter.inst(context).onTaskPause();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void onTaskResume(Context context) {
            TaskPresenter.inst(context).onTaskResume();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void registerTaskCallback(TaskCallback taskCallback) {
            TaskPresenter.registerTaskCallback(taskCallback);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setDeviceCategory(DeviceCategory deviceCategory) {
            DeviceRegisterManager.setDeviceCategory(deviceCategory);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEnableNetCommOpt(boolean z) {
            DeviceRegisterManager.setEnableNetCommOpt(z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public boolean isEnableNetCommOpt() {
            return DeviceRegisterManager.isEnableNetCommOpt();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEnableMigrate(boolean z) {
            DeviceRegisterManager.setEnableMigrate(z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setSensitiveApiCallback(SensitiveApiCallback sensitiveApiCallback) {
            DeviceRegisterManager.setSensitiveApiCallback(sensitiveApiCallback);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setUserIdIsolateEnabled(boolean z) {
            AppLog.sUserIdIsolateEnabled = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setUserIdIsolateCallback(UserIdIsolateCallback userIdIsolateCallback) {
            AppLog.sUserIdIsolateCallback = userIdIsolateCallback;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public boolean isNewUser() {
            return RegisterServiceController.isNewUser();
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setTerminateImmediately(boolean z) {
            boolean unused = AppLog.sTerminateImmediately = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEnableGetEgdi(boolean z) {
            DeviceRegisterManager.setEnableGetEdgi(z);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setEgdiRetryInterval(int i) {
            DeviceRegisterManager.setEdgiRetryInterval(i);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public void setNewMonitorEnabled(boolean z) {
            boolean unused = AppLog.sNewMonitorEnabled = z;
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public boolean isHitStickySamplingDrop(String str) {
            if (AppLog.sEventSampling == null || AppLog.sInstance == null || AppLog.getEventSamplingValue() <= 0) {
                return false;
            }
            return AppLog.sEventSampling.isHitStickySamplingDrop(AppLog.sInstance.buildSamplingUser(), str, (JSONObject) null);
        }

        @Override // com.ss.android.common.applog.IAppLogApi
        public boolean isHitStickySamplingDrop(String str, JSONObject jSONObject) {
            if (AppLog.sEventSampling == null || AppLog.sInstance == null || AppLog.getEventSamplingValue() <= 0) {
                return false;
            }
            return AppLog.sEventSampling.isHitStickySamplingDrop(AppLog.sInstance.buildSamplingUser(), str, jSONObject);
        }
    }

    public static void setEnableEventUserId(boolean z) {
        sAppLogApi.setEnableEventUserId(z);
    }

    public static boolean getEnableEventUserId() {
        return sEnableEventUserId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] fillKeyIvForEncryptResp(JSONObject jSONObject, boolean z) {
        boolean z2;
        String[] strArr = null;
        try {
            if (z) {
                if (sEnableEventUserId) {
                    jSONObject.put(KEY_EVENT_UID_ENABLE, 1);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (getEventSamplingValue() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("capability", getEventSamplingValue());
                    EventSampling eventSampling = sEventSampling;
                    if (eventSampling != null) {
                        if (eventSampling.getCapability() == getEventSamplingValue()) {
                            jSONObject2.put(Constants.VERSION, eventSampling.getSamplingVersion());
                        }
                        jSONObject2.put("config_ids", eventSampling.getConfigIdArray());
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject(KEY_OPTIONS);
                    if (optJSONObject == null) {
                        optJSONObject = new JSONObject();
                    }
                    optJSONObject.put("event_sampling", jSONObject2);
                    jSONObject.put(KEY_OPTIONS, optJSONObject);
                }
            } else if (sEventFilterEnable > 0) {
                jSONObject.put(KEY_ENABLE_EVENT_FILTER, sEventFilterEnable);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && getLogEncryptSwitch()) {
                strArr = EncryptUtils.genRandomKeyAndIv();
                if (EncryptUtils.isValidKeyIv(strArr)) {
                    jSONObject.put(KEY_ENCRYPT_RESP_KEY, strArr[0]);
                    jSONObject.put(KEY_ENCRYPT_RESP_IV, strArr[1]);
                }
            }
        } catch (JSONException e) {
            TLog.m76e("AppLog fillKeyIvForEncryptResp", e);
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getAdjustTerminate() {
        return sAdjustTerminate;
    }

    public static void setAdjustTerminate(boolean z) {
        sAppLogApi.setAdjustTerminate(z);
    }

    public static void setTouristMode(boolean z) {
        sAppLogApi.setTouristMode(z);
    }

    public static boolean isTouristMode() {
        return sIsTouristMode;
    }

    public static void setEnableEventInTouristMode(boolean z) {
        sAppLogApi.setEnableEventInTouristMode(z);
    }

    public static boolean isEnableEventInTouristMode() {
        return sEnableEventInTouristMode;
    }

    public static void setParamsFilter(IParamFilter iParamFilter) {
        NetUtil.setParamsFilter(iParamFilter);
    }

    public static void setLogExpireTime(long j) {
        if (j > LOG_EXPIRE_TIME) {
            sLogExpireTime = j;
        }
    }

    public static void setLogRetryMaxCount(int i) {
        if (i > 10) {
            sLogRetryMaxCount = i;
        }
    }

    public static void flush() {
        sAppLogApi.flush();
    }

    private void forceFlushEvent() {
        if (this.mSession != null) {
            LogQueueSwitchSession logQueueSwitchSession = new LogQueueSwitchSession();
            logQueueSwitchSession.old = this.mSession;
            logQueueSwitchSession.isFlush = true;
            enqueue(logQueueSwitchSession);
        }
    }

    public static void setBDAccountCallback(IBDAccountCallback iBDAccountCallback) {
        sAppLogApi.setBDAccountCallback(iBDAccountCallback);
    }

    public static void setAbortPackMiscIfException(boolean z) {
        sAbortPackMiscIfException = z;
    }

    public static boolean getAbortPackMiscIfException() {
        return sAbortPackMiscIfException;
    }

    public static void setExtendCursorWindowIfOverflow(boolean z) {
        sExtendCursorWindowIfOverflow = z;
    }

    public static boolean getExtendCursorWindowIfOverflow() {
        return sExtendCursorWindowIfOverflow;
    }

    public static void setLogger(ILogger iLogger) {
        sAppLogApi.setLogger(iLogger);
    }

    public static void setEnableKeepUserId(boolean z) {
        sEnableKeepUserId = z;
    }

    public static boolean isEnableListenNetChange() {
        return sEnableListenNetChange;
    }

    public static void setEnableListenNetChange(boolean z) {
        sEnableListenNetChange = z;
    }

    public static void setDisablePersonalization(int i) {
        sAppLogApi.setDisablePersonalization(i);
    }

    public static void addLaunchObserver(ILaunchObserver iLaunchObserver) {
        sAppLogApi.addLaunchObserver(iLaunchObserver);
    }

    public static void removeLaunchObserver(ILaunchObserver iLaunchObserver) {
        sAppLogApi.removeLaunchObserver(iLaunchObserver);
    }

    public static void setStartLogReaperDelay(long j) {
        sAppLogApi.setStartLogReaperDelay(j);
    }

    public static int getEncodeType() {
        return sAppLogApi.getEncodeType();
    }

    public static void setLogCompressor(ILogCompressor iLogCompressor) {
        sAppLogApi.setLogCompressor(iLogCompressor);
    }

    public static ILogCompressor getLogCompressor() {
        return sAppLogApi.getLogCompressor();
    }

    public static void setSendLogCallback(SendLogCallback sendLogCallback) {
        sSendLogCallback = sendLogCallback;
    }

    public static void setIsMainProcess(boolean z) {
        sAppLogApi.setIsMainProcess(z);
    }

    public static void setDeviceCategory(DeviceCategory deviceCategory) {
        sAppLogApi.setDeviceCategory(deviceCategory);
    }

    public static void setEnableNetCommOpt(boolean z) {
        sAppLogApi.setEnableNetCommOpt(z);
    }

    public static boolean isEnableNetCommOpt() {
        return sAppLogApi.isEnableNetCommOpt();
    }

    public static void stopNetwCommOpt() {
        if (sInitGuard) {
            NetworkStatusMonitor.getInstance(sAppContext.getContext()).stop();
        }
    }

    public static void setEnableMigrate(boolean z) {
        sAppLogApi.setEnableMigrate(z);
    }

    public static void setUserIdIsolateEnabled(boolean z) {
        sAppLogApi.setUserIdIsolateEnabled(z);
    }

    public static void setUserIdIsolateCallback(UserIdIsolateCallback userIdIsolateCallback) {
        sAppLogApi.setUserIdIsolateCallback(userIdIsolateCallback);
    }

    public static boolean isNewUser() {
        return sAppLogApi.isNewUser();
    }

    public static void setTerminateImmediately(boolean z) {
        sAppLogApi.setTerminateImmediately(z);
    }

    public static void setEnableGetEgdi(boolean z) {
        sAppLogApi.setEnableGetEgdi(z);
    }

    public static void setEgdiRetryInterval(int i) {
        sAppLogApi.setEgdiRetryInterval(i);
    }

    public static void setNewMonitorEnabled(boolean z) {
        sAppLogApi.setNewMonitorEnabled(z);
    }

    public static boolean isHitStickySamplingDrop(String str) {
        return sAppLogApi.isHitStickySamplingDrop(str);
    }

    public static boolean isHitStickySamplingDrop(String str, JSONObject jSONObject) {
        return sAppLogApi.isHitStickySamplingDrop(str, jSONObject);
    }
}
