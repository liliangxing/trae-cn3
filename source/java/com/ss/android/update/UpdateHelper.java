package com.ss.android.update;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.bytedance.common.utility.DigestUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.SignUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.utility.persistent.SharedPrefsEditorCompat;
import com.bytedance.services.app.common.context.api.AppCommonContext;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.common.AbsApiThread;
import com.ss.android.common.app.permission.PermissionsManager;
import com.ss.android.common.dialog.AlertDialog;
import com.ss.android.common.util.NetworkUtils;
import com.ss.android.common.util.ToolUtils;
import com.ss.android.download.api.constant.Downloads;
import com.ss.android.http.legacy.message.BasicHeader;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.depend.AbsDownloadListener;
import com.ss.android.update.UpdateDownloadHelper;
import com.ss.android.update.UpdateEventUtils;
import com.ss.ttm.player.C0968C;
import com.ss.ttm.utils.AVLogger;
import com.vivo.push.PushClient;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class UpdateHelper implements IUpdateDownloadListener {
    static final String ALPHA_UPDATE_BG_DOWNLOAD_APK_NAME = "alpha_ud_bg.apk.part";
    static final String APK_ALPHA_NAME = "update_alpha.apk";
    static final String APK_NAME = "update.apk";
    public static final String BUNDLE_FROM_UPDATE_AVAIL = "from_update_avail";
    public static final String BUNDLE_FROM_UPDATE_READY = "from_update_ready";
    public static final int DEFAULT_INTERVAL_SINCE_NOTIFY_UPDATE = 2;
    public static final String KEY_ALREADY_DOWNLOAD_TIPS = "already_download_tips";
    public static final String KEY_ARTIFACT_ID = "artifact_id";
    public static final String KEY_BIND_APP = "bind_download_data";
    public static final String KEY_BIND_APP_CHECKED = "hint_checked";
    public static final String KEY_BIND_APP_DOWNLOAD_URL = "bind_app_download_url";
    public static final String KEY_BIND_APP_NAME = "name";
    public static final String KEY_BIND_APP_PACKAGE = "package";
    public static final String KEY_BIND_APP_TIPS = "hint_text";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_DISTRIBUTE_ID = "distribute_id";
    public static final String KEY_DOWNLOAD_ETAG = "download_etag";
    public static final String KEY_DOWNLOAD_SIZE = "download_size";
    public static final String KEY_DOWNLOAD_VERSION = "download_version";
    public static final String KEY_ENABLE_CLIENT_STRATEGY = "enable_client_strategy";
    public static final String KEY_FORCE_UPDATE = "force_update";
    public static final String KEY_INTERVAL_SINCE_NOTIFY_UPDATE = "interval_since_notify_update";
    public static final String KEY_INTERVAL_SINCE_NOTIFY_UPDATE_SECOND = "pre_download_max_wait_seconds";
    private static final String KEY_LAST_ANY_DIALOG_SHOW_TIME = "last_any_dialog_show_time";
    public static final String KEY_LAST_CHECK_TIME = "last_check_time";
    public static final String KEY_LATENCY = "latency";
    public static final String KEY_MARKET_UPDATE = "market_update";
    public static final String KEY_MARKET_UPDATE_ENABLE = "market_update_enable";
    public static final String KEY_MARKET_UPDATE_PACKAGE = "market_update_package";
    public static final String KEY_MARKET_UPDATE_TIPS = "market_update_intent_tips";
    public static final String KEY_MARKET_UPDTATE_INTENT_URL = "market_update_intent_url";
    public static final String KEY_MD5 = "md5";
    public static final String KEY_OFFICIAL = "official";
    public static final String KEY_PACKAGE_TYPE = "package_type";
    public static final String KEY_PERSISTENT_CHANNEL = "persistent_channel";
    public static final String KEY_PERSISTENT_RELEASE_RULE_ID = "persistent_release_rule_id";
    public static final String KEY_PERSISTENT_STRATEGY_ID = "persistent_strategy_id";
    public static final String KEY_PERSISTENT_TIP_VERSION_CODE = "persistent_tip_version_code";
    public static final String KEY_POPUP_TYPE = "popup_type";
    public static final String KEY_PRE_DOWNLOAD = "pre_download";
    public static final String KEY_PRE_DOWNLOAD_SIZE = "pre_download_size";
    public static final String KEY_REAL_VERSION_CODE = "real_version_code";
    public static final String KEY_REAL_VERSION_NAME = "real_version_name";
    public static final String KEY_RELEASE_RULE_ID = "release_rule_id";
    public static final String KEY_STRATEGY_ID = "strategy_id";
    public static final String KEY_TIP_VERSION_CODE = "tip_version_code";
    public static final String KEY_TIP_VERSION_NAME = "tip_version_name";
    public static final String KEY_TITLE = "title";
    public static final String KEY_UPDATE_BUTTON_TEXT = "update_button_text";
    public static final String KEY_URL = "download_url";
    public static final String KEY_WHATS_NEW = "whats_new";
    public static final int MSG_ALPHA_UPDATE_BG_DOWNLOAD_SUCCESS = 16;
    public static final int MSG_ALPHA_UPDATE_BG_SHOW_DIALOG = 17;
    public static final int MSG_CANCEL_AVAIL = 11;

    @Deprecated
    public static final int MSG_CANCEL_FAIL = 12;
    public static final int MSG_CANCEL_PROGRESS = 13;
    public static final int MSG_CANCEL_READY = 10;
    public static final int MSG_CHECK_UPDATE_FAIL = 7;
    public static final int MSG_CHECK_UPDATE_OK = 6;
    public static final int MSG_DOWNLOAD_CHECK_FAIL = 9;
    public static final int MSG_DOWNLOAD_CHECK_OK = 8;
    public static final int MSG_DOWNLOAD_FAIL = 4;
    public static final int MSG_DOWNLOAD_INIT = 3;
    public static final int MSG_DOWNLOAD_PROGRESS = 5;
    public static final int MSG_OPEN_ALPHA_APP = 14;
    public static final int MSG_REPORT_UPDATE_DIALOG = 15;

    @Deprecated
    public static final int MSG_UPDATE_AVAIL = 2;
    public static final int MSG_UPDATE_READY = 1;
    private static final String NOTIFICATION_CHANNEL_ID = "update_channel_01";
    private static final String NOTIFICATION_CHANNEL_NAME = "update_channel_name";
    public static final int POPUP_TYPE_UPDATE_LOCAL = 0;
    public static final int POPUP_TYPE_UPDATE_NORMAL = 2;
    public static final int POPUP_TYPE_USE_LOCAL = 1;
    static final String PRE_DOWNLOAD_APK_NAME = "predownload.apk";
    public static final String SP_UPDATE_INFO = "update_info";
    static final String TAG = "UpdateHelper";
    public static final int TIME_FOR_EXPIRE = 259200000;
    public static final int TIME_FOR_PRE_DOWNLOAD_EXPIRE = 604800000;
    public static final int TIME_FOR_UPDATE = 86400000;
    public static final int TIME_FOR_UPDATE_EXPIRE = 86400000;
    static final String TMP_ALPHA_UPDATE_BG_DOWNLOAD_APK_NAME = "tmp_alhpa_ud_bg.apk.part";
    static final String TMP_APK_ALPHA_NAME = "update_alpha.apk.part";
    static final String TMP_APK_NAME = "update.apk.part";
    static final String TMP_PRE_DOWNLOAD_APK_NAME = "predownload.apk.part";
    private static UpdateHelper mInstance;
    private volatile boolean isClickUpdateButton;
    private String mApkName;
    private AppCommonContext mAppCommonContext;
    private Context mContext;
    private UpdateDownloadHelper mDownloadHelper;
    private OnDownloadStatusChangedListener mDownloadStatusListener;
    private ExecutorService mExecutorService;
    private String mFilesDir;
    private final Handler mHandler;
    private final DownloadInfo mInfo;
    private NotificationManager mNm;
    private NotificationCompat.Builder mNotificationBuilder;
    private int mOfficial;
    private String mPersistentChannel;
    private int mPersistentReleaseRuleId;
    private int mPersistentStrategyId;
    private int mPersistentTipVersionCode;
    private String mPreDownloadApkName;
    private final DownloadInfo mPreDownloadInfo;
    private String mTmpApkName;
    private String mTmpPreDownloadApkName;
    private IUpdateAlphaDialog mUpdateAlphaDialogs;
    private IUpdateCheckDialog mUpdateCheckDialogs;
    private UpdateConfig mUpdateHostConfig;
    private IUpdateMainDialog mUpdateMainDialogs;
    private UpdateShowServiceImpl mUpdateShowService;
    public volatile boolean mCheckSignature = true;
    private boolean mInited = false;
    private String mDownloadUrl = "";
    private int mCurrentUpdateVersion = 0;
    private int mCurrentVersionCode = 0;
    private int mTipVersionCode = 0;
    private int mRealVersionCode = 0;
    private String mTipVersionName = "";
    private String mRealVersionName = "";
    private String mWhatsNew = "";
    private long mLastCheckTime = 0;
    private String mAlreadyDownloadTips = "";
    private String mTitle = "";
    private boolean mForceUpdate = false;
    private boolean mBindApp = false;
    private boolean mBindAppChecked = false;
    private String mBindAppTips = "";
    private String mBindAppName = "";
    private String mBindAppPackage = "";
    private String mBindAppDownloadUrl = "";
    private boolean mPreDownload = false;
    private int mIntervalSinceNotifyUpdate = 2;
    private long mIntervalSinceNotifyUpdate_second = -1;
    private int mLatency = 0;
    private String mDownloadEtag = "";
    private int mDownloadVersion = 0;
    private int mDownloadSize = 0;
    private volatile boolean mUpdating = false;
    private UpdateNotifyThread mNotifyThread = null;
    private int mPreDownloadSize = 0;
    private volatile boolean mPreDownloading = false;
    private int mEnableClientStrategy = 0;
    private String mDistributeId = "";
    private int mArtifactId = 0;
    private int mPackageType = 0;
    private int mPopupType = -1;
    private String mUpdateButtonText = "";
    private String mMd5 = "";
    private volatile boolean mAnyDialogShowing = false;
    private int mReleaseRuleId = 0;
    private int mStrategyId = 0;
    private String mChannel = "";
    private DownloadCountDownLatchRunnable mDownloadCountDownLatchRunnable = null;
    private final DownloadInfoListener mDownloadInfoListener = new DownloadInfoListener();
    private List<OnUpdateStatusChangedListener> mUpdateStatusListeners = new ArrayList();
    private String mMarketUpdatePackage = "";
    private String mMarketUpdateIntentUrl = "";
    private String mMarketUpdateTips = "";
    private boolean mMarketUpdateEnable = false;
    private AlertDialog mCheckDialog = null;
    private volatile int mDialogStyle = 2;
    private volatile int mLocalDialogStyle = 3;
    private IUpdateCheckDialog mCheckDialogNew = null;
    private IUpdateAlphaDialog mAlphaDialog = null;
    private IUpdateMainDialog mMainDialog = null;
    private IInstallAlphaDialog mAlphaUpdateInstallDialog = null;
    private volatile boolean showAlphaDialogEnable = false;
    private boolean canUpdate = false;
    private String mAppExtra = "";
    private long mLastAnyDialogShowTime = 0;
    private IUpdateConfig mIUpdateConfig = UpdateSDK.getConfig();

    public void setCheckSignature(boolean z) {
        this.mCheckSignature = z;
    }

    public static UpdateHelper getInstance() {
        if (mInstance == null) {
            synchronized (UpdateHelper.class) {
                if (mInstance == null) {
                    mInstance = new UpdateHelper();
                }
            }
        }
        return mInstance;
    }

    private UpdateHelper() {
        this.mContext = null;
        this.mPersistentReleaseRuleId = 0;
        this.mPersistentStrategyId = 0;
        this.mPersistentTipVersionCode = 0;
        this.mPersistentChannel = "";
        int i = 3;
        this.mAppCommonContext = UpdateSDK.getAppCommonContext();
        IUpdateConfig iUpdateConfig = this.mIUpdateConfig;
        if (iUpdateConfig != null) {
            UpdateConfig updateConfig = iUpdateConfig.getUpdateConfig();
            this.mUpdateHostConfig = updateConfig;
            this.mDownloadStatusListener = updateConfig.getDownloadStatusListener();
        }
        if (this.mUpdateHostConfig.getExecutorService() != null) {
            this.mExecutorService = this.mUpdateHostConfig.getExecutorService();
        } else {
            this.mExecutorService = Executors.newFixedThreadPool(2);
        }
        AppCommonContext appCommonContext = this.mAppCommonContext;
        if (appCommonContext != null) {
            this.mContext = appCommonContext.getContext().getApplicationContext();
        } else if (this.mUpdateHostConfig.getAppContext() != null) {
            AppCommonContext appContext = this.mUpdateHostConfig.getAppContext();
            this.mAppCommonContext = appContext;
            this.mContext = appContext.getContext().getApplicationContext();
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0);
        this.mPersistentReleaseRuleId = sharedPreferences.getInt(KEY_PERSISTENT_RELEASE_RULE_ID, 0);
        this.mPersistentStrategyId = sharedPreferences.getInt(KEY_PERSISTENT_STRATEGY_ID, 0);
        this.mPersistentChannel = sharedPreferences.getString(KEY_PERSISTENT_CHANNEL, "");
        this.mPersistentTipVersionCode = sharedPreferences.getInt(KEY_PERSISTENT_TIP_VERSION_CODE, 0);
        this.mDownloadHelper = new UpdateDownloadHelper(this.mContext);
        this.mNm = (NotificationManager) this.mContext.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            UpdateConfig updateConfig2 = this.mUpdateHostConfig;
            if (updateConfig2 != null && updateConfig2.isHideNotice()) {
                i = 0;
            }
            UpdateConfig updateConfig3 = this.mUpdateHostConfig;
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, (updateConfig3 == null || TextUtils.isEmpty(updateConfig3.getNotificationChannelName())) ? NOTIFICATION_CHANNEL_NAME : this.mUpdateHostConfig.getNotificationChannelName(), i);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            this.mNm.createNotificationChannel(notificationChannel);
        }
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.ss.android.update.UpdateHelper.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                UpdateHelper.this.handleMsg(message);
            }
        };
        this.mFilesDir = getSaveFileDir(this.mContext, this.mUpdateHostConfig);
        this.mApkName = this.mFilesDir + File.separator + APK_NAME;
        this.mTmpApkName = this.mFilesDir + File.separator + TMP_APK_NAME;
        this.mPreDownloadApkName = this.mFilesDir + File.separator + PRE_DOWNLOAD_APK_NAME;
        this.mTmpPreDownloadApkName = this.mFilesDir + File.separator + TMP_PRE_DOWNLOAD_APK_NAME;
        DownloadInfo downloadInfo = new DownloadInfo();
        this.mInfo = downloadInfo;
        downloadInfo.status = 0;
        downloadInfo.byteSoFar = 0;
        downloadInfo.contentLength = 0;
        DownloadInfo downloadInfo2 = new DownloadInfo();
        this.mPreDownloadInfo = downloadInfo2;
        downloadInfo2.status = 0;
        downloadInfo2.byteSoFar = 0;
        downloadInfo2.contentLength = 0;
        try {
            this.mNm.cancel(C0749R.id.ssl_notify_downloading);
        } catch (Exception unused) {
        }
    }

    String getSaveFileDir(Context context, UpdateConfig updateConfig) {
        String str;
        if (updateConfig != null && !TextUtils.isEmpty(updateConfig.getSaveFileDir())) {
            try {
                File file = new File(updateConfig.getSaveFileDir());
                if (file.exists() && file.isDirectory()) {
                    return file.getAbsolutePath();
                }
                if (file.mkdirs()) {
                    return file.getAbsolutePath();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            str = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + context.getPackageName() + "/files";
        } catch (Exception e2) {
            e2.printStackTrace();
            File cacheDirectory = UpdateFileProviderUtils.getCacheDirectory(context, true);
            if (cacheDirectory != null) {
                str = cacheDirectory.getPath();
            } else {
                str = "/sdcard/Android/data/" + context.getPackageName() + "/files";
            }
        }
        if (str.isEmpty()) {
            return str;
        }
        File file2 = new File(str, "update");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2.getPath();
    }

    /* JADX WARN: Code restructure failed: missing block: B:184:0x01a7, code lost:
    
        r4 = 1;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000b. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void handleMsg(Message message) {
        r4 = null;
        r4 = null;
        Object[] objArr = null;
        try {
            switch (message.what) {
                case 1:
                    try {
                        this.mNm.cancel(C0749R.id.ssl_notify_downloading);
                        this.mNm.cancel(C0749R.id.ssl_notify_update_avail);
                        this.mNm.cancel(C0749R.id.ssl_notify_download_fail);
                    } catch (Exception unused) {
                    }
                    notifyDownloadReady();
                    if (this.mDownloadCountDownLatchRunnable != null) {
                        if (com.bytedance.common.utility.Logger.debug()) {
                            com.bytedance.common.utility.Logger.d(TAG, "from MSG_UPDATE_READY");
                        }
                        countDown();
                        return;
                    }
                    return;
                case 2:
                    try {
                        this.mNm.cancel(C0749R.id.ssl_notify_download_ok);
                        this.mNm.cancel(C0749R.id.ssl_notify_download_fail);
                    } catch (Exception unused2) {
                    }
                    notifyUpdateAvail();
                    return;
                case 3:
                    try {
                        this.mNm.cancel(C0749R.id.ssl_notify_downloading);
                        this.mNm.cancel(C0749R.id.ssl_notify_download_fail);
                        this.mNm.cancel(C0749R.id.ssl_notify_download_ok);
                        this.mNm.cancel(C0749R.id.ssl_notify_update_avail);
                    } catch (Exception unused3) {
                    }
                    this.mNm.notify(C0749R.id.ssl_notify_downloading, getNotification(0));
                    return;
                case 4:
                    try {
                        this.mNm.cancel(C0749R.id.ssl_notify_downloading);
                        this.mNm.cancel(C0749R.id.ssl_notify_download_ok);
                        this.mNm.cancel(C0749R.id.ssl_notify_update_avail);
                    } catch (Exception unused4) {
                    }
                    notifyDownloadFail();
                    return;
                case 5:
                    int i = message.arg1;
                    int i2 = i >= 0 ? i : 0;
                    if (i2 > 99) {
                        i2 = 99;
                    }
                    this.mNm.notify(C0749R.id.ssl_notify_downloading, getNotification(i2));
                    return;
                case 6:
                    final boolean z = message.arg1 == 1;
                    if (this.showAlphaDialogEnable) {
                        if (isClientStrategyEnable() && !UpdateAlphaManager.inst().currentAppOpenAlphaEnable()) {
                            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_BLOCK_DIALOG);
                            this.showAlphaDialogEnable = false;
                            return;
                        } else {
                            this.mHandler.postDelayed(new Runnable() { // from class: com.ss.android.update.UpdateHelper.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    UpdateHelper.this.showOpenAlphaDialog(z);
                                }
                            }, Math.min(Math.max(this.mLatency, 0), 60) * 1000);
                            return;
                        }
                    }
                    if (this.mDialogStyle != -2) {
                        break;
                    }
                    if (z && this.mUpdateHostConfig.isLocalApp() && UpdateAlphaManager.inst().alphaBgAutoDownloadEnable() && UpdateAlphaManager.inst().getUserAgreeBgDownload() && !UpdateAlphaManager.inst().getBgDownloadIgnoreThisVersion(this.mRealVersionCode)) {
                        ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.update.UpdateHelper.3
                            @Override // java.lang.Runnable
                            public void run() {
                                if (UpdateHelper.this.checkBgDownloadApkValid()) {
                                    Message obtainMessage = UpdateHelper.this.mHandler.obtainMessage(17);
                                    obtainMessage.arg1 = 2;
                                    obtainMessage.sendToTarget();
                                    return;
                                }
                                UpdateHelper.this.checkBgDownloadAlphaUpdateApkDownload();
                            }
                        });
                        UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_ALPHA_UPDATE_BG_DOWNLOAD);
                        return;
                    }
                    if (objArr != null) {
                        synchronized (this.mUpdateStatusListeners) {
                            for (OnUpdateStatusChangedListener onUpdateStatusChangedListener : this.mUpdateStatusListeners) {
                                if (onUpdateStatusChangedListener != null) {
                                    onUpdateStatusChangedListener.onUpdateStatusChanged(1);
                                }
                            }
                        }
                    } else {
                        synchronized (this.mUpdateStatusListeners) {
                            for (OnUpdateStatusChangedListener onUpdateStatusChangedListener2 : this.mUpdateStatusListeners) {
                                if (onUpdateStatusChangedListener2 != null) {
                                    onUpdateStatusChangedListener2.onUpdateStatusChanged(-2);
                                }
                            }
                        }
                    }
                    if (this.mUpdateShowService == null) {
                        this.mUpdateShowService = new UpdateShowServiceImpl();
                    }
                    UpdateShowServiceImpl updateShowServiceImpl = this.mUpdateShowService;
                    IUpdateCheckDialog iUpdateCheckDialog = this.mUpdateCheckDialogs;
                    updateShowServiceImpl.setUpdateCheckDialogs(iUpdateCheckDialog != null ? iUpdateCheckDialog : null);
                    if (this.mDialogStyle == 2) {
                        this.mUpdateShowService.tryShowBigDialog(z);
                        return;
                    } else {
                        if (this.mDialogStyle == 1) {
                            this.mUpdateShowService.tryShowCheckDialog(isRealCurrentVersionOut() ? 1 : -2);
                            return;
                        }
                        return;
                    }
                case 7:
                    this.showAlphaDialogEnable = false;
                    if (com.bytedance.common.utility.Logger.debug()) {
                        com.bytedance.common.utility.Logger.d(TAG, "from MSG_CHECK_UPDATE_FAIL");
                    }
                    countDown();
                    synchronized (this.mUpdateStatusListeners) {
                        for (OnUpdateStatusChangedListener onUpdateStatusChangedListener3 : this.mUpdateStatusListeners) {
                            if (onUpdateStatusChangedListener3 != null) {
                                if (isRealCurrentVersionOut()) {
                                    onUpdateStatusChangedListener3.onUpdateStatusChanged(-1);
                                } else {
                                    onUpdateStatusChangedListener3.onUpdateStatusChanged(-2);
                                }
                            }
                        }
                    }
                    if (this.mDialogStyle == 1) {
                        if (this.mUpdateShowService == null) {
                            this.mUpdateShowService = new UpdateShowServiceImpl();
                        }
                        UpdateShowServiceImpl updateShowServiceImpl2 = this.mUpdateShowService;
                        IUpdateCheckDialog iUpdateCheckDialog2 = this.mUpdateCheckDialogs;
                        updateShowServiceImpl2.setUpdateCheckDialogs(iUpdateCheckDialog2 != null ? iUpdateCheckDialog2 : null);
                        if (isRealCurrentVersionOut()) {
                            this.mUpdateShowService.tryShowCheckDialog(-1);
                            return;
                        } else {
                            this.mUpdateShowService.tryShowCheckDialog(-2);
                            return;
                        }
                    }
                    return;
                case 8:
                    doStartDownload(message.arg1 == 1, message.arg2 == 1, message.obj instanceof UpdateDownloadHelper.DownloadExtraInfo ? (UpdateDownloadHelper.DownloadExtraInfo) message.obj : null);
                    return;
                case 9:
                    this.showAlphaDialogEnable = false;
                    if (this.mUpdating) {
                        this.mUpdating = false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    Utils.safePutJsonKV(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, "has not get positive result from update checking");
                    Utils.safePutJsonKV(jSONObject, "url", this.mDownloadUrl);
                    Utils.safePutJsonKV(jSONObject, "pre", Integer.valueOf(message.arg1 == 1 ? 1 : 0));
                    Utils.safePutJsonKV(jSONObject, "canceled", 0);
                    Utils.safePutJsonKV(jSONObject, "success", 0);
                    EventReporter.onEvent("app_update_download", jSONObject);
                    UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, message.arg1 == 1, "fail", "has not get positive result from update checking");
                    return;
                case 10:
                    this.mNm.cancel(C0749R.id.ssl_notify_download_ok);
                    return;
                case 11:
                    this.mNm.cancel(C0749R.id.ssl_notify_update_avail);
                    return;
                case 12:
                    this.mNm.cancel(C0749R.id.ssl_notify_download_fail);
                    return;
                case 13:
                    try {
                        this.mNm.cancel(C0749R.id.ssl_notify_downloading);
                    } catch (Exception unused5) {
                    }
                    if (com.bytedance.common.utility.Logger.debug()) {
                        com.bytedance.common.utility.Logger.d(TAG, "from MSG_CANCEL_PROGRESS");
                    }
                    countDown();
                    return;
                case 14:
                    showOpenAlphaDialog(message.arg1 == 1);
                    return;
                case 15:
                    final int i3 = message.arg1;
                    final int i4 = message.arg2;
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.update.UpdateHelper.4
                        @Override // java.lang.Runnable
                        public void run() {
                            UpdateHelper.this.reportDialogInfoTask(i3, i4);
                        }
                    });
                    return;
                case 16:
                    if (UpdateAlphaManager.inst().getBgDownloadIgnoreThisVersion(this.mRealVersionCode)) {
                        return;
                    }
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.ss.android.update.UpdateHelper.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (UpdateHelper.this.checkBgDownloadApkValid()) {
                                Message obtainMessage = UpdateHelper.this.mHandler.obtainMessage(17);
                                obtainMessage.arg1 = 2;
                                obtainMessage.sendToTarget();
                            }
                        }
                    });
                    return;
                case 17:
                    showBgDownloadAlphaUpdateInstallDialog(message.arg1);
                    return;
                default:
                    return;
            }
        } catch (Exception unused6) {
        }
    }

    public void cancelNotifyAvai() {
        this.mHandler.sendEmptyMessage(11);
    }

    public void cancelNotifyReady() {
        this.mHandler.sendEmptyMessage(10);
    }

    public String getVerboseAppName() {
        AppCommonContext appCommonContext = this.mAppCommonContext;
        return appCommonContext != null ? appCommonContext.getStringAppName() : "";
    }

    public synchronized int getVersionCode() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mTipVersionCode;
    }

    public synchronized String getDownloadingUrl() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mDownloadUrl;
    }

    public synchronized String getLastVersion() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        if (!TextUtils.isEmpty(this.mRealVersionName)) {
            return this.mRealVersionName;
        }
        return this.mTipVersionName;
    }

    public synchronized String getWhatsNew() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mWhatsNew;
    }

    public synchronized String getUpdateButtonText() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mUpdateButtonText;
    }

    public synchronized boolean isUpdating() {
        return this.mUpdating;
    }

    public synchronized boolean isCurrentVersionOut() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        if (this.mPopupType == 1) {
            return true;
        }
        return this.mCurrentUpdateVersion < this.mTipVersionCode;
    }

    public synchronized boolean isRealCurrentVersionOut() {
        boolean z;
        z = true;
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        if (this.mCurrentUpdateVersion >= this.mRealVersionCode) {
            if (!this.showAlphaDialogEnable) {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
    
        if (com.ss.android.update.UpdateAlphaManager.inst().isInstallAlphaApp() == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized boolean canDownloadApk() {
        boolean z;
        z = true;
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        int i = this.mCurrentUpdateVersion;
        if (i >= this.mRealVersionCode && i >= this.mTipVersionCode) {
            if (this.showAlphaDialogEnable) {
            }
            z = false;
        }
        return z;
    }

    public synchronized boolean isLastCheckingTimeOut() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return System.currentTimeMillis() > this.mLastCheckTime + DownloadConstants.DAY;
    }

    public synchronized boolean needPreDownload() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mPreDownload;
    }

    public synchronized int getPreDownloadDelayDays() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mIntervalSinceNotifyUpdate;
    }

    public synchronized long getPreDownloadDelaySecond() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mIntervalSinceNotifyUpdate_second;
    }

    public synchronized boolean isForceUpdate() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mForceUpdate;
    }

    public synchronized String getAlreadyDownloadTips() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mAlreadyDownloadTips;
    }

    public synchronized String getTitle() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mTitle;
    }

    public synchronized int getLatency() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return Math.min(Math.max(this.mLatency, 0), 60);
    }

    public synchronized int getOfficial() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mOfficial;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean getBindApp() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        if (cantShowBindApp()) {
            return false;
        }
        return this.mBindApp;
    }

    private boolean cantShowBindApp() {
        boolean isBindAppDownloadSuccess = UpdateBindDownloadHelper.inst().isBindAppDownloadSuccess(this.mContext, this.mBindAppDownloadUrl);
        if (StringUtils.isEmpty(this.mBindAppPackage) || !ToolUtils.isInstalledApp(this.mContext, this.mBindAppPackage)) {
            return isBindAppDownloadSuccess;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean getBindAppChecked() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mBindAppChecked;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String getBindAppTips() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mBindAppTips;
    }

    public synchronized String getBindAppName() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mBindAppName;
    }

    public synchronized String getBindAppDownloadUrl() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mBindAppDownloadUrl;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0057, code lost:
    
        if ((r4 - r0.lastModified()) < 604800000) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isUpdateApkPreDownloaded() {
        boolean z = true;
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        if (this.mDownloadVersion != this.mRealVersionCode) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.mApkName);
        if (file.exists() && file.isFile() && currentTimeMillis - file.lastModified() < DownloadConstants.DAY) {
            return false;
        }
        File file2 = new File(this.mPreDownloadApkName);
        if (file2.exists() && file2.isFile()) {
        }
        z = false;
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00bb A[Catch: all -> 0x014b, TryCatch #1 {all -> 0x014b, blocks: (B:9:0x0019, B:11:0x0034, B:13:0x0085, B:15:0x008d, B:17:0x0095, B:19:0x009b, B:22:0x00ae, B:24:0x00bb, B:26:0x0120, B:28:0x0128, B:30:0x0130, B:32:0x0136, B:36:0x0146, B:41:0x00aa), top: B:8:0x0019, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized File getUpdateReadyApk(boolean z) {
        File file;
        File file2;
        setDownloadApkName(z);
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0);
            File file3 = new File(this.mApkName);
            if (file3.exists()) {
                String string = sharedPreferences.getString("md5_" + file3.getAbsolutePath(), null);
                com.bytedance.common.utility.Logger.i(TAG, "realVersion:" + this.mRealVersionName + ",downloadVersion:" + this.mDownloadVersion + ",md5" + this.mMd5 + ",fileMd5:" + string);
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(this.mMd5) || !string.equals(this.mMd5) || this.mDownloadVersion != this.mRealVersionCode || currentTimeMillis - file3.lastModified() >= DownloadConstants.DAY) {
                    file3.delete();
                } else {
                    file = file3;
                    file2 = new File(this.mPreDownloadApkName);
                    if (file2.exists()) {
                        sharedPreferences.getString("md5_" + file3.getAbsolutePath(), null);
                        String string2 = sharedPreferences.getString("md5_" + file3.getAbsolutePath(), null);
                        com.bytedance.common.utility.Logger.i(TAG, "realVersion:" + this.mRealVersionName + ",downloadVersion:" + this.mDownloadVersion + ",md5" + this.mMd5 + ",preFileMd5:" + string2);
                        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(this.mMd5) || !string2.equals(this.mMd5) || this.mDownloadVersion != this.mRealVersionCode || currentTimeMillis - file2.lastModified() >= 604800000) {
                            file2.delete();
                        } else if (file == null) {
                            file = file2;
                        }
                    }
                }
            }
            file = null;
            file2 = new File(this.mPreDownloadApkName);
            if (file2.exists()) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
        return file;
    }

    public synchronized File getAlphaUpdateBgDownloadReadyApk() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        String str = this.mFilesDir + File.separator + PRE_DOWNLOAD_APK_NAME;
        this.mPreDownloadApkName = str;
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            if (!file.isFile()) {
                return null;
            }
            if (System.currentTimeMillis() - file.lastModified() <= DownloadConstants.DAY) {
                return file;
            }
            file.delete();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public synchronized File getUpdateReadyApk() {
        return getUpdateReadyApk(false);
    }

    public synchronized int getPopupType() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mPopupType;
    }

    public synchronized int getPackageType() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mPackageType;
    }

    public synchronized int getReleaseRuleId() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mReleaseRuleId;
    }

    public synchronized int getStrategyId() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mStrategyId;
    }

    private synchronized void deleteApkFile() {
        try {
            File file = new File(this.mTmpApkName);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(this.mApkName);
            if (file2.exists()) {
                file2.delete();
            }
        } finally {
        }
    }

    private synchronized void deletePreApkFile() {
        try {
            File file = new File(this.mTmpPreDownloadApkName);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(this.mPreDownloadApkName);
            if (file2.exists()) {
                file2.delete();
            }
        } finally {
        }
    }

    private boolean isUpdateDataValid(boolean z) {
        int i = this.mPopupType;
        if ((i == 2 || i == 0) && (TextUtils.isEmpty(this.mTitle) || this.mRealVersionCode == -1 || this.mTipVersionCode == -1 || TextUtils.isEmpty(this.mWhatsNew))) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LACK_INFORMATION_NORMAL);
            this.canUpdate = false;
            this.showAlphaDialogEnable = false;
            return false;
        }
        if (this.mPopupType == 1 && (TextUtils.isEmpty(this.mTitle) || TextUtils.isEmpty(this.mWhatsNew))) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LACK_INFORMATION_NORMAL);
            this.canUpdate = false;
            this.showAlphaDialogEnable = false;
            return false;
        }
        int i2 = this.mPopupType;
        if (i2 == 0 || i2 == 1) {
            if (!UpdateAlphaManager.inst().isOpenUpdateFormalStrategy()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NO_LOCAL_GUIDE);
                this.canUpdate = false;
                this.showAlphaDialogEnable = false;
                return false;
            }
            if (TextUtils.isEmpty(this.mUpdateButtonText)) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NO_BUTTON_TEXT);
                this.canUpdate = false;
                this.showAlphaDialogEnable = false;
                return false;
            }
            if (!UpdateAlphaManager.inst().isNetworkInHouse()) {
                this.showAlphaDialogEnable = false;
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_OUT_OF_HOUSE);
                this.canUpdate = false;
                return false;
            }
            this.showAlphaDialogEnable = true;
            if (this.mPopupType == 1) {
                if (!UpdateAlphaManager.inst().openAlphaAppEnable()) {
                    UpdateEventUtils.noShowDialogEvent("reason_cannot_open_local_package");
                    this.showAlphaDialogEnable = false;
                    this.canUpdate = false;
                    return false;
                }
                if (!isInDialogShowInterval(z)) {
                    return true;
                }
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_LIMIT_BLOCK_DIALOG);
                this.showAlphaDialogEnable = false;
                this.canUpdate = false;
                return false;
            }
        } else if (i2 == 2) {
            if (!UpdateAlphaManager.inst().isUpdateNormalEnabled()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NO_NORMAL_GUIDE);
                this.canUpdate = false;
                return false;
            }
            this.showAlphaDialogEnable = false;
        }
        if (StringUtils.isEmpty(this.mDownloadUrl)) {
            UpdateEventUtils.noShowDialogEvent("reason_no_updating_url_from_server");
            this.showAlphaDialogEnable = false;
            this.canUpdate = false;
            return false;
        }
        if (this.mUpdateHostConfig.isLocalApp()) {
            if (this.mPackageType != 1) {
                UpdateEventUtils.noShowDialogEvent("reason_local_package_should_not_upgrade_to_other_package");
                this.showAlphaDialogEnable = false;
                this.canUpdate = false;
                return false;
            }
            if (!UpdateAlphaManager.inst().isNetworkInHouse()) {
                UpdateEventUtils.noShowDialogEvent("reason_local_package_should_not_work_out_of_house");
                this.showAlphaDialogEnable = false;
                this.canUpdate = false;
                return false;
            }
        }
        if (isInDialogShowInterval(z)) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_LIMIT_BLOCK_DIALOG);
            this.showAlphaDialogEnable = false;
            this.canUpdate = false;
            return false;
        }
        if (!isCurrentVersionOut()) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
            this.showAlphaDialogEnable = false;
            this.canUpdate = false;
            return false;
        }
        this.canUpdate = true;
        return true;
    }

    @Deprecated
    public boolean isCanUpdate() {
        return isCanUpdate(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x048a A[Catch: all -> 0x0580, TryCatch #0 {all -> 0x0580, blocks: (B:7:0x0019, B:9:0x0023, B:14:0x003a, B:16:0x0045, B:18:0x004b, B:19:0x0060, B:21:0x0064, B:23:0x0068, B:25:0x006e, B:27:0x007a, B:28:0x0089, B:30:0x008d, B:32:0x0093, B:34:0x00b1, B:35:0x00ba, B:37:0x00c0, B:38:0x00c9, B:40:0x00cf, B:41:0x00d8, B:43:0x00e2, B:44:0x00eb, B:47:0x00fd, B:49:0x010a, B:52:0x0118, B:55:0x0137, B:58:0x0160, B:61:0x017f, B:64:0x019e, B:66:0x01b4, B:67:0x01c0, B:69:0x01d6, B:70:0x021c, B:72:0x0222, B:75:0x022b, B:76:0x0245, B:78:0x0249, B:80:0x0253, B:81:0x025c, B:83:0x028f, B:88:0x02ab, B:90:0x02c5, B:96:0x02e2, B:99:0x0328, B:102:0x033c, B:116:0x041e, B:119:0x0424, B:124:0x0431, B:130:0x043e, B:133:0x048a, B:135:0x0490, B:140:0x04be, B:147:0x0541, B:155:0x057f, B:158:0x0473, B:173:0x0403, B:184:0x0242, B:142:0x04bf, B:144:0x04c3, B:145:0x04c9, B:146:0x0540), top: B:6:0x0019, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x04bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x028f A[Catch: all -> 0x0580, TRY_LEAVE, TryCatch #0 {all -> 0x0580, blocks: (B:7:0x0019, B:9:0x0023, B:14:0x003a, B:16:0x0045, B:18:0x004b, B:19:0x0060, B:21:0x0064, B:23:0x0068, B:25:0x006e, B:27:0x007a, B:28:0x0089, B:30:0x008d, B:32:0x0093, B:34:0x00b1, B:35:0x00ba, B:37:0x00c0, B:38:0x00c9, B:40:0x00cf, B:41:0x00d8, B:43:0x00e2, B:44:0x00eb, B:47:0x00fd, B:49:0x010a, B:52:0x0118, B:55:0x0137, B:58:0x0160, B:61:0x017f, B:64:0x019e, B:66:0x01b4, B:67:0x01c0, B:69:0x01d6, B:70:0x021c, B:72:0x0222, B:75:0x022b, B:76:0x0245, B:78:0x0249, B:80:0x0253, B:81:0x025c, B:83:0x028f, B:88:0x02ab, B:90:0x02c5, B:96:0x02e2, B:99:0x0328, B:102:0x033c, B:116:0x041e, B:119:0x0424, B:124:0x0431, B:130:0x043e, B:133:0x048a, B:135:0x0490, B:140:0x04be, B:147:0x0541, B:155:0x057f, B:158:0x0473, B:173:0x0403, B:184:0x0242, B:142:0x04bf, B:144:0x04c3, B:145:0x04c9, B:146:0x0540), top: B:6:0x0019, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02ab A[Catch: all -> 0x0580, TRY_ENTER, TryCatch #0 {all -> 0x0580, blocks: (B:7:0x0019, B:9:0x0023, B:14:0x003a, B:16:0x0045, B:18:0x004b, B:19:0x0060, B:21:0x0064, B:23:0x0068, B:25:0x006e, B:27:0x007a, B:28:0x0089, B:30:0x008d, B:32:0x0093, B:34:0x00b1, B:35:0x00ba, B:37:0x00c0, B:38:0x00c9, B:40:0x00cf, B:41:0x00d8, B:43:0x00e2, B:44:0x00eb, B:47:0x00fd, B:49:0x010a, B:52:0x0118, B:55:0x0137, B:58:0x0160, B:61:0x017f, B:64:0x019e, B:66:0x01b4, B:67:0x01c0, B:69:0x01d6, B:70:0x021c, B:72:0x0222, B:75:0x022b, B:76:0x0245, B:78:0x0249, B:80:0x0253, B:81:0x025c, B:83:0x028f, B:88:0x02ab, B:90:0x02c5, B:96:0x02e2, B:99:0x0328, B:102:0x033c, B:116:0x041e, B:119:0x0424, B:124:0x0431, B:130:0x043e, B:133:0x048a, B:135:0x0490, B:140:0x04be, B:147:0x0541, B:155:0x057f, B:158:0x0473, B:173:0x0403, B:184:0x0242, B:142:0x04bf, B:144:0x04c3, B:145:0x04c9, B:146:0x0540), top: B:6:0x0019, inners: #6 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isCanUpdate(boolean z) {
        UpdateConfig updateConfig;
        String executeGet;
        String str;
        int i;
        boolean z2;
        String str2;
        String str3;
        String str4;
        boolean z3;
        String str5;
        boolean z4;
        boolean z5;
        JSONObject optJSONObject;
        UpdateConfig updateConfig2;
        if (!this.mUpdateHostConfig.isUpdateEnabled()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (!UpdateAlphaManager.inst().localUpdateEnable()) {
                UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "ping_fail", "ping_fail");
                this.canUpdate = false;
                return false;
            }
            StringBuilder sb = new StringBuilder(UpdateConstants.UPDATE_CHECK_VERSION_URL);
            Context context = this.mContext;
            if (context != null && context.getApplicationInfo() != null) {
                sb.append("?target_sdk_version=").append(String.valueOf(this.mContext.getApplicationInfo().targetSdkVersion));
            }
            if (this.mContext != null && (updateConfig2 = this.mUpdateHostConfig) != null && updateConfig2.usePackageNameInCheckVersion() && !TextUtils.isEmpty(this.mContext.getPackageName())) {
                sb.append("&package_name=").append(this.mContext.getPackageName());
            }
            UpdateConfig updateConfig3 = this.mUpdateHostConfig;
            if (updateConfig3 != null && updateConfig3.getUpdateCityInfo() != null) {
                String str6 = this.mUpdateHostConfig.getUpdateCityInfo().city;
                String str7 = this.mUpdateHostConfig.getUpdateCityInfo().longitude;
                String str8 = this.mUpdateHostConfig.getUpdateCityInfo().latitude;
                if (!TextUtils.isEmpty(str6)) {
                    sb.append("&city=").append(str6);
                }
                if (!TextUtils.isEmpty(str7)) {
                    sb.append("&longitude=").append(str7);
                }
                if (!TextUtils.isEmpty(str8)) {
                    sb.append("&latitude=").append(str8);
                }
            }
            String cpuAbi = UpdateWifiUtils.getCpuAbi();
            if (!TextUtils.isEmpty(cpuAbi)) {
                sb.append("&cpu_abi=").append(cpuAbi);
            }
            sb.append("&app_extra=").append(this.mAppExtra);
            sb.append("&call_type=").append(z ? PushClient.DEFAULT_REQUEST_ID : "0");
            UpdateConfig updateConfig4 = this.mUpdateHostConfig;
            String str9 = updateConfig4 != null ? updateConfig4.isLocalApp() ? PushClient.DEFAULT_REQUEST_ID : "0" : "0";
            sb.append("&package_type=").append(str9);
            UpdateEventUtils.reportPackageType(Integer.parseInt(str9));
            sb.append("&inhouse_network=").append(UpdateAlphaManager.inst().isNetworkInHouse() ? PushClient.DEFAULT_REQUEST_ID : "0");
            sb.append("&inhouse_network_attr=").append(UpdateAlphaManager.inst().getWifiListInfo());
            String str10 = UpdateAlphaManager.inst().isOpenUpdateFormalStrategy() ? PushClient.DEFAULT_REQUEST_ID : "0";
            sb.append("&enable_intranet_guide=").append(str10);
            UpdateEventUtils.reportIntranetGuideState(Integer.parseInt(str10));
            String str11 = UpdateAlphaManager.inst().isInstallAlphaApp() ? PushClient.DEFAULT_REQUEST_ID : "0";
            sb.append("&is_local_installed=").append(str11);
            UpdateEventUtils.reportLocalInstalled(Integer.parseInt(str11));
            String str12 = UpdateAlphaManager.inst().isUpdateNormalEnabled() ? PushClient.DEFAULT_REQUEST_ID : "0";
            sb.append("&enable_normal_popup=").append(str12);
            UpdateEventUtils.reportNormalUpdateState(Integer.parseInt(str12));
            String str13 = "";
            AppCommonContext appCommonContext = this.mAppCommonContext;
            if (appCommonContext != null) {
                this.mCurrentUpdateVersion = appCommonContext.getUpdateVersionCode();
                str13 = this.mAppCommonContext.getChannel();
            }
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0);
            int i2 = sharedPreferences.getInt(KEY_TIP_VERSION_CODE, 0);
            this.mTipVersionCode = i2;
            if (i2 == this.mCurrentUpdateVersion) {
                this.mPersistentReleaseRuleId = sharedPreferences.getInt(KEY_RELEASE_RULE_ID, 0);
                this.mPersistentStrategyId = sharedPreferences.getInt(KEY_STRATEGY_ID, 0);
                this.mPersistentTipVersionCode = this.mTipVersionCode;
                this.mPersistentChannel = sharedPreferences.getString("channel", "");
                sharedPreferences.edit().putInt(KEY_PERSISTENT_RELEASE_RULE_ID, this.mPersistentReleaseRuleId).putInt(KEY_PERSISTENT_STRATEGY_ID, this.mPersistentStrategyId).putInt(KEY_PERSISTENT_TIP_VERSION_CODE, this.mPersistentTipVersionCode).putString(KEY_PERSISTENT_CHANNEL, this.mPersistentChannel).apply();
            }
            if (this.mPersistentTipVersionCode == this.mCurrentUpdateVersion && str13.equals(this.mPersistentChannel)) {
                sb.append("&release_rule_id=").append(this.mPersistentReleaseRuleId);
                sb.append("&strategy_id=").append(this.mPersistentStrategyId);
                updateConfig = this.mUpdateHostConfig;
                if (updateConfig != null && !StringUtils.isEmpty(updateConfig.getAddedQuery())) {
                    sb.append(this.mUpdateHostConfig.getAddedQuery());
                }
                String sb2 = sb.toString();
                Utils.safePutJsonKV(jSONObject, "request", sb2);
                ArrayList arrayList = new ArrayList();
                Pair<String, String> header = RequestTagHeaderManager.getHeader();
                arrayList.add(new BasicHeader((String) header.first, (String) header.second));
                executeGet = NetworkUtils.executeGet(8192, sb2, true, true, arrayList, null, true, null);
                if (!StringUtils.isEmpty(executeGet)) {
                    UpdateEventUtils.checkVersionV7Event(0);
                    UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "check_fail", jSONObject.toString());
                    this.canUpdate = false;
                    if (this.mContext != null) {
                        EventReporter.onEvent("app_update_check", jSONObject);
                    }
                    return false;
                }
                Utils.safePutJsonKV(jSONObject, "respone", executeGet);
                JSONObject jSONObject2 = new JSONObject(executeGet);
                if (!"success".equals(jSONObject2.getString("message"))) {
                    UpdateEventUtils.checkVersionV7Event(1);
                    UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "check_fail", jSONObject.toString());
                    this.canUpdate = false;
                    if (this.mContext != null) {
                        EventReporter.onEvent("app_update_check", jSONObject);
                    }
                    return false;
                }
                UpdateEventUtils.checkVersionV7Event(-1);
                JSONObject jSONObject3 = jSONObject2.getJSONObject("data");
                int optInt = jSONObject3.optInt(KEY_TIP_VERSION_CODE, -1);
                String optString = jSONObject3.optString(KEY_TIP_VERSION_NAME);
                String optString2 = jSONObject3.optString(KEY_REAL_VERSION_NAME);
                int optInt2 = jSONObject3.optInt(KEY_REAL_VERSION_CODE, -1);
                String optString3 = jSONObject3.optString(KEY_URL);
                String optString4 = jSONObject3.optString(KEY_WHATS_NEW, "");
                String optString5 = jSONObject3.optString("title", "");
                boolean z6 = jSONObject3.optInt(KEY_FORCE_UPDATE, 0) == 1;
                String optString6 = jSONObject3.optString(KEY_ALREADY_DOWNLOAD_TIPS, "");
                boolean z7 = jSONObject3.optInt(KEY_PRE_DOWNLOAD, 0) == 1;
                int optInt3 = jSONObject3.optInt(KEY_INTERVAL_SINCE_NOTIFY_UPDATE, 2);
                boolean z8 = z6;
                long optLong = jSONObject3.optLong(KEY_INTERVAL_SINCE_NOTIFY_UPDATE_SECOND, -1L);
                int optInt4 = jSONObject3.optInt(KEY_LATENCY, 0);
                int optInt5 = jSONObject3.optInt(KEY_OFFICIAL, 0);
                int optInt6 = jSONObject3.optInt(KEY_ENABLE_CLIENT_STRATEGY, 0);
                String optString7 = jSONObject3.optString(KEY_DISTRIBUTE_ID, "");
                int optInt7 = jSONObject3.optInt(KEY_ARTIFACT_ID, 0);
                int optInt8 = jSONObject3.optInt(KEY_PACKAGE_TYPE, 0);
                int optInt9 = jSONObject3.optInt(KEY_POPUP_TYPE, -1);
                String optString8 = jSONObject3.optString(KEY_UPDATE_BUTTON_TEXT, "");
                String optString9 = jSONObject3.optString("md5", "");
                int optInt10 = jSONObject3.optInt(KEY_RELEASE_RULE_ID, 0);
                int optInt11 = jSONObject3.optInt(KEY_STRATEGY_ID, 0);
                String optString10 = jSONObject3.optString("channel", "");
                String str14 = "";
                String str15 = "";
                String str16 = "";
                try {
                    JSONObject optJSONObject2 = jSONObject3.optJSONObject(KEY_MARKET_UPDATE);
                    str = optString10;
                    i = optInt11;
                    try {
                        z2 = jSONObject3.optInt(KEY_MARKET_UPDATE_ENABLE, 0) > 0;
                        if (optJSONObject2 != null) {
                            try {
                                str14 = optJSONObject2.optString(KEY_MARKET_UPDATE_PACKAGE);
                                str15 = optJSONObject2.optString(KEY_MARKET_UPDTATE_INTENT_URL);
                                str16 = optJSONObject2.optString(KEY_MARKET_UPDATE_TIPS);
                            } catch (Throwable th) {
                                th = th;
                                boolean z9 = z2;
                                com.bytedance.common.utility.Logger.d(TAG, th.getMessage(), th);
                                str2 = str14;
                                str3 = str15;
                                str4 = "";
                                z3 = z9;
                                String str17 = "";
                                String str18 = "";
                                String str19 = "";
                                String str20 = "";
                                z4 = jSONObject3.has(KEY_BIND_APP);
                                optJSONObject = jSONObject3.optJSONObject(KEY_BIND_APP);
                                if (optJSONObject != null) {
                                }
                                String str21 = str17;
                                String str22 = str18;
                                String str23 = str20;
                                boolean z10 = z5;
                                String str24 = str2;
                                boolean z11 = z4;
                                if (optInt <= 0) {
                                }
                                synchronized (this) {
                                }
                            }
                        }
                        str2 = str14;
                        str4 = str16;
                        z3 = z2;
                        str3 = str15;
                    } catch (Throwable th2) {
                        th = th2;
                        z2 = false;
                        boolean z92 = z2;
                        com.bytedance.common.utility.Logger.d(TAG, th.getMessage(), th);
                        str2 = str14;
                        str3 = str15;
                        str4 = "";
                        z3 = z92;
                        String str172 = "";
                        String str182 = "";
                        String str192 = "";
                        String str202 = "";
                        z4 = jSONObject3.has(KEY_BIND_APP);
                        optJSONObject = jSONObject3.optJSONObject(KEY_BIND_APP);
                        if (optJSONObject != null) {
                        }
                        String str212 = str172;
                        String str222 = str182;
                        String str232 = str202;
                        boolean z102 = z5;
                        String str242 = str2;
                        boolean z112 = z4;
                        if (optInt <= 0) {
                        }
                        synchronized (this) {
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    str = optString10;
                    i = optInt11;
                }
                String str1722 = "";
                String str1822 = "";
                String str1922 = "";
                String str2022 = "";
                try {
                    z4 = jSONObject3.has(KEY_BIND_APP);
                    try {
                        optJSONObject = jSONObject3.optJSONObject(KEY_BIND_APP);
                        if (optJSONObject != null) {
                            str5 = str3;
                            try {
                                z5 = optJSONObject.optInt(KEY_BIND_APP_CHECKED, 1) == 1;
                                try {
                                    str1722 = optJSONObject.optString(KEY_BIND_APP_TIPS, "");
                                    str1822 = optJSONObject.optString("name", "");
                                    str1922 = optJSONObject.optString("package", "");
                                    str2022 = optJSONObject.optString(KEY_BIND_APP_DOWNLOAD_URL);
                                } catch (Exception e) {
                                    e = e;
                                    com.bytedance.common.utility.Logger.d(TAG, e.getMessage(), e);
                                    String str2122 = str1722;
                                    String str2222 = str1822;
                                    String str2322 = str2022;
                                    boolean z1022 = z5;
                                    String str2422 = str2;
                                    boolean z1122 = z4;
                                    if (optInt <= 0) {
                                    }
                                    synchronized (this) {
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                                z5 = true;
                                com.bytedance.common.utility.Logger.d(TAG, e.getMessage(), e);
                                String str21222 = str1722;
                                String str22222 = str1822;
                                String str23222 = str2022;
                                boolean z10222 = z5;
                                String str24222 = str2;
                                boolean z11222 = z4;
                                if (optInt <= 0) {
                                }
                                synchronized (this) {
                                }
                            }
                        } else {
                            str5 = str3;
                            z5 = true;
                        }
                    } catch (Exception e3) {
                        e = e3;
                        str5 = str3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    str5 = str3;
                    z4 = false;
                }
                String str212222 = str1722;
                String str222222 = str1822;
                String str232222 = str2022;
                boolean z102222 = z5;
                String str242222 = str2;
                boolean z112222 = z4;
                if (optInt <= 0 && !URLUtil.isValidUrl(optString3)) {
                    Utils.safePutJsonKV(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, "url is not valid:" + optString3);
                    UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "check_fail", jSONObject.toString());
                    this.showAlphaDialogEnable = false;
                    this.canUpdate = false;
                    if (this.mContext != null) {
                        EventReporter.onEvent("app_update_check", jSONObject);
                    }
                    return false;
                }
                synchronized (this) {
                    if (!this.mInited) {
                        loadData();
                        this.mInited = true;
                    }
                    this.mTipVersionCode = optInt;
                    this.mRealVersionCode = optInt2;
                    this.mTipVersionName = optString;
                    this.mRealVersionName = optString2;
                    this.mDownloadUrl = optString3;
                    this.mWhatsNew = optString4;
                    this.mLastCheckTime = System.currentTimeMillis();
                    this.mTitle = optString5;
                    this.mForceUpdate = z8;
                    this.mAlreadyDownloadTips = optString6;
                    this.mPreDownload = z7;
                    this.mIntervalSinceNotifyUpdate = optInt3;
                    this.mIntervalSinceNotifyUpdate_second = optLong;
                    this.mLatency = optInt4;
                    this.mOfficial = optInt5;
                    this.mBindApp = z112222;
                    this.mBindAppChecked = z102222;
                    this.mBindAppTips = str212222;
                    this.mBindAppName = str222222;
                    this.mBindAppPackage = str1922;
                    this.mBindAppDownloadUrl = str232222;
                    this.mMarketUpdatePackage = str242222;
                    this.mMarketUpdateIntentUrl = str5;
                    this.mMarketUpdateTips = str4;
                    this.mMarketUpdateEnable = z3;
                    this.mEnableClientStrategy = optInt6;
                    this.mDistributeId = optString7;
                    this.mArtifactId = optInt7;
                    this.mPackageType = optInt8;
                    this.mPopupType = optInt9;
                    this.mUpdateButtonText = optString8;
                    this.mMd5 = optString9;
                    this.mReleaseRuleId = optInt10;
                    this.mStrategyId = i;
                    this.mChannel = str;
                    saveData();
                }
                com.bytedance.common.utility.Logger.i(TAG, "update info: latest version " + this.mTipVersionCode + " " + this.mRealVersionCode + ", now " + this.mCurrentUpdateVersion);
                boolean isUpdateDataValid = isUpdateDataValid(z);
                if (this.mContext != null) {
                    EventReporter.onEvent("app_update_check", jSONObject);
                }
                return isUpdateDataValid;
            }
            sb.append("&release_rule_id=0&strategy_id=0");
            updateConfig = this.mUpdateHostConfig;
            if (updateConfig != null) {
                sb.append(this.mUpdateHostConfig.getAddedQuery());
            }
            String sb22 = sb.toString();
            Utils.safePutJsonKV(jSONObject, "request", sb22);
            ArrayList arrayList2 = new ArrayList();
            Pair<String, String> header2 = RequestTagHeaderManager.getHeader();
            arrayList2.add(new BasicHeader((String) header2.first, (String) header2.second));
            executeGet = NetworkUtils.executeGet(8192, sb22, true, true, arrayList2, null, true, null);
            if (!StringUtils.isEmpty(executeGet)) {
            }
        } catch (Throwable th4) {
            try {
                com.bytedance.common.utility.Logger.w(TAG, "check update error: " + th4);
                int checkApiException = UpdateBindDownloadHelper.inst().checkApiException(this.mContext, th4);
                if (18 != checkApiException) {
                    Utils.safePutJsonKV(jSONObject, "errorCode", Integer.valueOf(checkApiException));
                } else {
                    Utils.safePutJsonKV(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, th4.getMessage());
                }
                UpdateEventUtils.downloadEvent(jSONObject.optString("request"), this.mRealVersionCode, false, "check_fail", jSONObject.toString());
                if (this.mContext != null) {
                    EventReporter.onEvent("app_update_check", jSONObject);
                }
                this.canUpdate = false;
                return false;
            } finally {
                if (this.mContext != null) {
                    EventReporter.onEvent("app_update_check", jSONObject);
                }
            }
        }
    }

    public void startCheckUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener) {
        startCheckUpdate(i, 3, onUpdateStatusChangedListener, true);
    }

    public void startCheckUpdate(int i, OnUpdateStatusChangedListener onUpdateStatusChangedListener, boolean z) {
        startCheckUpdate(i, 3, onUpdateStatusChangedListener, z);
    }

    public void startCheckUpdate(int i, int i2, OnUpdateStatusChangedListener onUpdateStatusChangedListener, final boolean z) {
        synchronized (this) {
            this.mDialogStyle = i;
            this.mLocalDialogStyle = i2;
            synchronized (this.mUpdateStatusListeners) {
                this.mUpdateStatusListeners.add(onUpdateStatusChangedListener);
            }
            if (!this.mInited) {
                loadData();
                this.mInited = true;
            }
            if (this.mUpdating) {
                return;
            }
            new AbsApiThread("UpdateHelper-Thread") { // from class: com.ss.android.update.UpdateHelper.6
                public void run() {
                    try {
                        UpdateHelper.this.doUpdate(z);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void removeUpdateStatusListener(OnUpdateStatusChangedListener onUpdateStatusChangedListener) {
        synchronized (this) {
            synchronized (this.mUpdateStatusListeners) {
                this.mUpdateStatusListeners.remove(onUpdateStatusChangedListener);
            }
        }
    }

    public void addUpdateStatusListener(OnUpdateStatusChangedListener onUpdateStatusChangedListener) {
        synchronized (this) {
            synchronized (this.mUpdateStatusListeners) {
                this.mUpdateStatusListeners.add(onUpdateStatusChangedListener);
            }
        }
    }

    void doUpdate(boolean z) {
        if (isCanUpdate(z)) {
            boolean z2 = true;
            if (this.mPopupType == 1) {
                if (UpdateAlphaManager.inst().openAlphaAppEnable()) {
                    Message obtain = Message.obtain();
                    obtain.what = 14;
                    obtain.arg1 = z ? 1 : 0;
                    this.mHandler.sendMessageDelayed(obtain, Math.max(this.mLatency, 10));
                } else {
                    UpdateEventUtils.noShowDialogEvent("reason_local_package_not_installed");
                }
            } else {
                boolean alphaBgAutoDownloadEnable = UpdateAlphaManager.inst().alphaBgAutoDownloadEnable();
                boolean userAgreeBgDownload = UpdateAlphaManager.inst().getUserAgreeBgDownload();
                boolean bgDownloadIgnoreThisVersion = UpdateAlphaManager.inst().getBgDownloadIgnoreThisVersion(this.mRealVersionCode);
                if (z && this.mPopupType == 2 && alphaBgAutoDownloadEnable && !bgDownloadIgnoreThisVersion && userAgreeBgDownload && checkBgDownloadApkValid()) {
                    Message obtainMessage = this.mHandler.obtainMessage(17);
                    obtainMessage.arg1 = 1;
                    obtainMessage.sendToTarget();
                    z2 = false;
                }
                if ((z && z2 && this.mPopupType == 2 && alphaBgAutoDownloadEnable && userAgreeBgDownload && bgDownloadIgnoreThisVersion) ? false : z2) {
                    Message obtain2 = Message.obtain();
                    obtain2.what = 6;
                    obtain2.arg1 = z ? 1 : 0;
                    this.mHandler.sendMessage(obtain2);
                }
            }
        } else {
            this.mHandler.sendEmptyMessage(7);
        }
        UpdateEventUtils.localTestOnCheckUpdateEvent();
    }

    public void initBindApp() {
        this.mDownloadCountDownLatchRunnable = new DownloadCountDownLatchRunnable(new CountDownLatch(2));
        new ThreadPlus(this.mDownloadCountDownLatchRunnable, "DownloadCountDownLatchThread", true).start();
    }

    public void startBindAppDownload() {
        if (!TextUtils.isEmpty(this.mBindAppDownloadUrl) && !TextUtils.isEmpty(this.mBindAppName)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("label", "detail_ad");
                jSONObject.put("ext_json", (Object) null);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (PermissionsManager.getInstance().hasPermission(this.mContext, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                UpdateBindDownloadHelper.inst().bindDownloadUrlLink(this.mBindAppDownloadUrl, this.mBindAppName, this.mContext, true, true, false, this.mDownloadInfoListener);
                return;
            }
            return;
        }
        if (com.bytedance.common.utility.Logger.debug()) {
            com.bytedance.common.utility.Logger.d(TAG, "from startBindAppDownload has no Permission");
        }
        countDown();
    }

    public void countDown() {
        DownloadCountDownLatchRunnable downloadCountDownLatchRunnable = this.mDownloadCountDownLatchRunnable;
        if (downloadCountDownLatchRunnable != null) {
            downloadCountDownLatchRunnable.countDown();
        }
    }

    public void cancelCountDown() {
        DownloadCountDownLatchRunnable downloadCountDownLatchRunnable = this.mDownloadCountDownLatchRunnable;
        if (downloadCountDownLatchRunnable != null) {
            downloadCountDownLatchRunnable.cancel();
        }
    }

    public void showUpdateDialogScene(boolean z) {
        this.mAnyDialogShowing = true;
        UpdateEventUtils.popupDialogEvent(0);
        reportDialogInfo(1, z);
    }

    public void showUpdateAlphaDialogScene(boolean z) {
        this.mAnyDialogShowing = true;
        UpdateEventUtils.popupDialogEvent(0);
        reportDialogInfo(1, z);
    }

    public void clickUpdateButton(boolean z) {
        reportDialogInfo(2, z);
        UpdateEventUtils.popupDialogEvent(1);
        UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_CLICK, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, -1, this.mForceUpdate);
        this.mAnyDialogShowing = false;
    }

    public void clickCloseButton(boolean z) {
        reportDialogInfo(3, z);
        UpdateEventUtils.popupDialogEvent(2);
        UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_CLOSE, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, -1, this.mForceUpdate);
        this.mAnyDialogShowing = false;
    }

    public void clickOpenAlphaButton(boolean z) {
        reportDialogInfo(2, z);
        int i = UpdateAlphaManager.inst().isInstallAlphaApp() ? 4 : 3;
        UpdateEventUtils.popupDialogEvent(1);
        UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_CLICK, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, i, this.mForceUpdate);
        this.mAnyDialogShowing = false;
    }

    public void clickCloseAlphaButton(boolean z) {
        reportDialogInfo(3, z);
        int i = UpdateAlphaManager.inst().isInstallAlphaApp() ? 4 : 3;
        UpdateEventUtils.popupDialogEvent(2);
        UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_CLOSE, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, i, this.mForceUpdate);
        this.mAnyDialogShowing = false;
    }

    public void onInstallAlphaCloseClick() {
        this.mAnyDialogShowing = false;
        UpdateEventUtils.alphaUpdateBgDownloadEvent(2);
        reportDialogInfo(1, true);
        reportDialogInfo(3, true);
    }

    public void onInstallAlphaIgnoreClick() {
        this.mAnyDialogShowing = false;
        UpdateAlphaManager.inst().setBgDownloadIgnoreThisVersion(this.mRealVersionCode);
        UpdateEventUtils.alphaUpdateBgDownloadEvent(5);
        reportDialogInfo(1, true);
        reportDialogInfo(3, true);
    }

    public void onInstallAlphaInstallNowClick() {
        this.mAnyDialogShowing = false;
        UpdateEventUtils.alphaUpdateBgDownloadEvent(3);
        reportDialogInfo(1, true);
        reportDialogInfo(2, true);
    }

    public void onAllDialogDismiss() {
        this.mAnyDialogShowing = false;
    }

    public void onInstallAlphaDialogShow(int i) {
        this.mAnyDialogShowing = true;
        UpdateEventUtils.alphaUpdateBgDownloadEvent(1, null, UpdateEventUtils.ParamsBuilder.begin().add(FrescoMonitorConst.URI_QUERY_PARAM_FROM, String.valueOf(i)).end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkBgDownloadAlphaUpdateApkDownload() {
        if (!UpdateAlphaManager.inst().alphaBgAutoDownloadEnable()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "condition not match");
            return;
        }
        if (!UpdateAlphaManager.inst().isNetworkAvailable()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "network not available");
            return;
        }
        if (!UpdateAlphaManager.inst().isNetworkWifi()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "network not wifi");
            return;
        }
        if (!UpdateAlphaManager.inst().isNetworkInHouse()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "network not in house");
        } else if (!URLUtil.isValidUrl(this.mDownloadUrl)) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "url not valid");
        } else {
            doBgDownloadAlphaUpdateApk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkBgDownloadApkValid() {
        File file = new File(this.mPreDownloadApkName);
        if (!file.isFile() || !file.exists()) {
            file = new File(this.mApkName);
            if (!file.isFile() || !file.exists()) {
                UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "downloaded file not exist");
                com.bytedance.common.utility.Logger.w(TAG, "checkBgDownloadApkValid: downloaded file not exist");
                return false;
            }
        }
        String md5Hex = DigestUtils.md5Hex(file);
        if (TextUtils.isEmpty(md5Hex) || TextUtils.isEmpty(this.mMd5) || !md5Hex.equalsIgnoreCase(this.mMd5)) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "md5 not match");
            com.bytedance.common.utility.Logger.w(TAG, "checkBgDownloadApkValid: md5 not match");
            return false;
        }
        if (SignUtils.checkSignature(this.mContext, file.getPath())) {
            return true;
        }
        UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "signature not match");
        com.bytedance.common.utility.Logger.w(TAG, "checkBgDownloadApkValid: signature not match");
        return false;
    }

    private void showBgDownloadAlphaUpdateInstallDialog(int i) {
        if (this.mAnyDialogShowing) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "other dialog showing");
            return;
        }
        IInstallAlphaDialog iInstallAlphaDialog = this.mAlphaUpdateInstallDialog;
        if (iInstallAlphaDialog != null && iInstallAlphaDialog.isInstallDialogShowing()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "already shown");
            return;
        }
        if (UpdateAlphaManager.inst().getBgDownloadIgnoreThisVersion(this.mRealVersionCode)) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "ignore version:" + this.mRealVersionCode);
            return;
        }
        if (!UpdateAlphaManager.inst().alphaBgAutoDownloadEnable()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, "condition not match2");
            return;
        }
        WeakReference<Activity> currentActivity = this.mIUpdateConfig.getUpdateConfig().getICurrentActivityCallback().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        Activity activity = currentActivity.get();
        if (activity == null || activity.isFinishing()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, UpdateService.REASON_NOT_ACTIVE);
            return;
        }
        if (activity.getResources().getConfiguration().orientation == 2 && !this.mIUpdateConfig.getUpdateConfig().isLandscapeEnabled()) {
            UpdateEventUtils.alphaUpdateBgDownloadEvent(6, UpdateService.REASON_NO_ORIENTAL_DIALOG);
            return;
        }
        IInstallAlphaDialog iInstallAlphaDialog2 = this.mAlphaUpdateInstallDialog;
        if (iInstallAlphaDialog2 == null || !iInstallAlphaDialog2.isInstallDialogShowing()) {
            this.mAlphaUpdateInstallDialog = new AlphaUpdateInstallDialog(activity);
        }
        this.mAlphaUpdateInstallDialog.showInstallDialog(i);
    }

    private void doBgDownloadAlphaUpdateApk() {
        startPreDownload(true);
    }

    private void setDownloadApkName(boolean z) {
        if (z) {
            this.mCheckSignature = false;
            this.mApkName = this.mFilesDir + File.separator + APK_ALPHA_NAME;
            this.mTmpApkName = this.mFilesDir + File.separator + TMP_APK_ALPHA_NAME;
        } else {
            this.mApkName = this.mFilesDir + File.separator + APK_NAME;
            this.mTmpApkName = this.mFilesDir + File.separator + TMP_APK_NAME;
            if (this.mCheckSignature) {
                return;
            }
            this.mCheckSignature = true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.ss.android.update.UpdateHelper$7] */
    public void startDownload(final boolean z) {
        synchronized (this) {
            if (!this.mInited) {
                loadData();
                this.mInited = true;
            }
            if (this.mUpdating) {
                UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "start_download", "mUpdating");
                return;
            }
            setDownloadApkName(z);
            this.mInfo.status = 1;
            this.mInfo.byteSoFar = 0;
            this.mInfo.contentLength = 0;
            this.mUpdating = true;
            deleteApkFile();
            int i = this.mDownloadVersion;
            int i2 = this.mRealVersionCode;
            if (i != i2) {
                this.mDownloadVersion = i2;
                saveDownloadInfo(i2, -1, "", false);
            }
            new ThreadPlus("StartDownload-Thread") { // from class: com.ss.android.update.UpdateHelper.7
                public void run() {
                    try {
                        if (UpdateHelper.this.canUpdate) {
                            Message obtain = Message.obtain();
                            obtain.what = 8;
                            obtain.arg1 = 0;
                            if (z) {
                                obtain.arg2 = 1;
                            }
                            UpdateHelper.this.mHandler.sendMessage(obtain);
                            return;
                        }
                        Message obtain2 = Message.obtain();
                        obtain2.what = 9;
                        obtain2.arg1 = 0;
                        UpdateHelper.this.mHandler.sendMessage(obtain2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public void startDownload() {
        startDownload(false);
    }

    void doStartDownload(boolean z, boolean z2, UpdateDownloadHelper.DownloadExtraInfo downloadExtraInfo) {
        String str;
        if (downloadExtraInfo == null) {
            downloadExtraInfo = UpdateDownloadHelper.DownloadExtraInfo.makeDefault();
        }
        UpdateDownloadHelper.DownloadExtraInfo downloadExtraInfo2 = downloadExtraInfo;
        JSONObject jSONObject = new JSONObject();
        if (canDownloadApk()) {
            File file = new File(this.mFilesDir);
            if (file.isDirectory() || file.mkdirs()) {
                str = null;
            } else {
                str = "can not mkdir files dir: " + this.mFilesDir;
                com.bytedance.common.utility.Logger.e(TAG, str);
            }
        } else {
            str = "canDownloadApk = false";
        }
        if (TextUtils.isEmpty(str)) {
            this.mDownloadHelper.downloadFile(this.mDownloadUrl, z ? TMP_PRE_DOWNLOAD_APK_NAME : z2 ? TMP_APK_ALPHA_NAME : TMP_APK_NAME, this.mFilesDir + File.separator, z, this.mRealVersionCode, this, downloadExtraInfo2);
            if (z) {
                return;
            }
            this.mHandler.sendEmptyMessage(3);
            return;
        }
        this.mUpdating = false;
        if (!downloadExtraInfo2.isAlphaUpdateBgDownload) {
            Utils.safePutJsonKV(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, str);
            Utils.safePutJsonKV(jSONObject, "url", this.mDownloadUrl);
            Utils.safePutJsonKV(jSONObject, "pre", Integer.valueOf(z ? 1 : 0));
            Utils.safePutJsonKV(jSONObject, "canceled", 0);
            Utils.safePutJsonKV(jSONObject, "success", 0);
            EventReporter.onEvent("app_update_download", jSONObject);
            UpdateEventUtils.downloadResultEvent(str);
            UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, z, "fail", str);
            return;
        }
        if (getInstance().getDownloadHelper().getExtraInfo() == null) {
            getInstance().getDownloadHelper().setExtraInfo(downloadExtraInfo2);
        }
        UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, z, "fail", str);
    }

    public void startPreDownload() {
        startPreDownload(false);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.update.UpdateHelper$8] */
    public void startPreDownload(final boolean z) {
        synchronized (this) {
            if (!this.mInited) {
                loadData();
                this.mInited = true;
            }
            if (this.mPreDownloading) {
                return;
            }
            this.mPreDownloadInfo.byteSoFar = 0;
            this.mPreDownloadInfo.contentLength = 0;
            this.mPreDownloading = true;
            deletePreApkFile();
            int i = this.mDownloadVersion;
            int i2 = this.mRealVersionCode;
            if (i != i2) {
                this.mDownloadVersion = i2;
                saveDownloadInfo(i2, -1, "", true);
            }
            new ThreadPlus("StartDownload-Thread") { // from class: com.ss.android.update.UpdateHelper.8
                public void run() {
                    try {
                        UpdateDownloadHelper.DownloadExtraInfo downloadExtraInfo = new UpdateDownloadHelper.DownloadExtraInfo();
                        downloadExtraInfo.isAlphaUpdateBgDownload = z;
                        if (!UpdateHelper.this.canUpdate) {
                            UpdateHelper.this.mPreDownloading = false;
                            Message obtain = Message.obtain();
                            obtain.what = 9;
                            obtain.arg1 = 1;
                            obtain.obj = downloadExtraInfo;
                            UpdateHelper.this.mHandler.sendMessage(obtain);
                        } else {
                            Message obtain2 = Message.obtain();
                            obtain2.what = 8;
                            obtain2.arg1 = 1;
                            obtain2.obj = downloadExtraInfo;
                            UpdateHelper.this.mHandler.sendMessage(obtain2);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static String getApkPackage(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 64).packageName;
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.w(TAG, "failed to get package signatures: " + th);
            return null;
        }
    }

    public void onExit() {
        synchronized (this.mInfo) {
            UpdateNotifyThread updateNotifyThread = this.mNotifyThread;
            if (updateNotifyThread != null) {
                updateNotifyThread.cancel();
            }
            UpdateDownloadHelper updateDownloadHelper = this.mDownloadHelper;
            if (updateDownloadHelper != null) {
                updateDownloadHelper.cancel();
            }
            try {
                this.mNm.cancel(C0749R.id.ssl_notify_downloading);
                this.mNm.cancel(C0749R.id.ssl_notify_download_fail);
            } catch (Exception unused) {
            }
        }
    }

    public String parseWhatsNew(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] split = str.split("\\\\n");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            sb.append(str2.trim());
            sb.append(UpdateDialogNewBase.TYPE);
        }
        return sb.toString();
    }

    public void cancelDownload() {
        synchronized (this.mInfo) {
            UpdateNotifyThread updateNotifyThread = this.mNotifyThread;
            if (updateNotifyThread != null) {
                updateNotifyThread.cancel();
            }
            UpdateDownloadHelper updateDownloadHelper = this.mDownloadHelper;
            if (updateDownloadHelper != null) {
                updateDownloadHelper.cancel();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class UpdateNotifyThread extends Thread {
        volatile boolean mCanceled = false;

        UpdateNotifyThread() {
        }

        public void cancel() {
            this.mCanceled = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j;
            while (true) {
                try {
                    Thread.sleep(1500L);
                } catch (Exception unused) {
                }
                synchronized (UpdateHelper.this.mInfo) {
                    if (this.mCanceled) {
                        return;
                    }
                    if (com.bytedance.common.utility.Logger.debug()) {
                        com.bytedance.common.utility.Logger.d(UpdateHelper.TAG, "mUpdating " + UpdateHelper.this.mUpdating);
                    }
                    if (!UpdateHelper.this.mUpdating) {
                        return;
                    }
                    int i = UpdateHelper.this.mInfo.byteSoFar;
                    int i2 = UpdateHelper.this.mInfo.contentLength;
                    if (i2 > 0) {
                        j = (i * 100) / i2;
                        if (j > 99) {
                            j = 99;
                        }
                    } else {
                        j = 1;
                    }
                    Message obtainMessage = UpdateHelper.this.mHandler.obtainMessage(5);
                    obtainMessage.arg1 = (int) j;
                    UpdateHelper.this.mHandler.sendMessage(obtainMessage);
                }
            }
        }
    }

    private void saveLastAnyDialogShowTime(boolean z) {
        if (!this.mInited) {
            synchronized (this) {
                if (!this.mInited) {
                    loadData();
                    this.mInited = true;
                }
            }
        }
        if (this.mForceUpdate || !z) {
            return;
        }
        this.mLastAnyDialogShowTime = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0).edit();
        edit.putLong(KEY_LAST_ANY_DIALOG_SHOW_TIME, this.mLastAnyDialogShowTime);
        SharedPrefsEditorCompat.apply(edit);
    }

    private boolean isInDialogShowInterval(boolean z) {
        if (!this.mInited) {
            synchronized (this) {
                if (!this.mInited) {
                    loadData();
                    this.mInited = true;
                }
            }
        }
        if (this.mForceUpdate || !z) {
            return false;
        }
        return System.currentTimeMillis() - this.mLastAnyDialogShowTime < this.mUpdateHostConfig.getDialogShowInterval();
    }

    private void saveData() {
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0).edit();
        edit.putInt(KEY_TIP_VERSION_CODE, this.mTipVersionCode);
        edit.putInt(KEY_REAL_VERSION_CODE, this.mRealVersionCode);
        edit.putString(KEY_TIP_VERSION_NAME, this.mTipVersionName);
        edit.putString(KEY_REAL_VERSION_NAME, this.mRealVersionName);
        edit.putString("title", this.mTitle);
        edit.putString(KEY_URL, this.mDownloadUrl);
        edit.putString(KEY_WHATS_NEW, this.mWhatsNew);
        edit.putLong(KEY_LAST_CHECK_TIME, this.mLastCheckTime);
        edit.putBoolean(KEY_FORCE_UPDATE, this.mForceUpdate);
        edit.putString(KEY_ALREADY_DOWNLOAD_TIPS, this.mAlreadyDownloadTips);
        edit.putBoolean(KEY_PRE_DOWNLOAD, this.mPreDownload);
        edit.putInt(KEY_INTERVAL_SINCE_NOTIFY_UPDATE, this.mIntervalSinceNotifyUpdate);
        edit.putLong(KEY_INTERVAL_SINCE_NOTIFY_UPDATE_SECOND, this.mIntervalSinceNotifyUpdate_second);
        edit.putInt(KEY_LATENCY, this.mLatency);
        edit.putInt(KEY_OFFICIAL, this.mOfficial);
        edit.putBoolean(KEY_BIND_APP, this.mBindApp);
        edit.putBoolean(KEY_BIND_APP_CHECKED, this.mBindAppChecked);
        edit.putString(KEY_BIND_APP_TIPS, this.mBindAppTips);
        edit.putString("name", this.mBindAppName);
        edit.putString("package", this.mBindAppPackage);
        edit.putString(KEY_BIND_APP_DOWNLOAD_URL, this.mBindAppDownloadUrl);
        edit.putString(KEY_MARKET_UPDATE_PACKAGE, this.mMarketUpdatePackage);
        edit.putString(KEY_MARKET_UPDATE_TIPS, this.mMarketUpdateTips);
        edit.putString(KEY_MARKET_UPDTATE_INTENT_URL, this.mMarketUpdateIntentUrl);
        edit.putBoolean(KEY_MARKET_UPDATE_ENABLE, this.mMarketUpdateEnable);
        edit.putInt(KEY_ENABLE_CLIENT_STRATEGY, this.mEnableClientStrategy);
        edit.putString(KEY_DISTRIBUTE_ID, this.mDistributeId);
        edit.putInt(KEY_ARTIFACT_ID, this.mArtifactId);
        edit.putInt(KEY_PACKAGE_TYPE, this.mPackageType);
        edit.putInt(KEY_POPUP_TYPE, this.mPopupType);
        edit.putString(KEY_UPDATE_BUTTON_TEXT, this.mUpdateButtonText);
        edit.putString("md5", this.mMd5);
        edit.putInt(KEY_RELEASE_RULE_ID, this.mReleaseRuleId);
        edit.putInt(KEY_STRATEGY_ID, this.mStrategyId);
        edit.putString("channel", this.mChannel);
        SharedPrefsEditorCompat.apply(edit);
    }

    synchronized void saveDownloadInfo(int i, int i2, String str, boolean z) {
        this.mDownloadVersion = i;
        if (z) {
            this.mPreDownloadSize = i2;
        } else {
            this.mDownloadSize = i2;
        }
        this.mDownloadEtag = str;
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0).edit();
        edit.putInt(KEY_DOWNLOAD_VERSION, this.mDownloadVersion);
        if (z) {
            edit.putInt(KEY_PRE_DOWNLOAD_SIZE, this.mPreDownloadSize);
        } else {
            edit.putInt(KEY_DOWNLOAD_SIZE, this.mDownloadSize);
        }
        edit.putString(KEY_DOWNLOAD_ETAG, this.mDownloadEtag);
        SharedPrefsEditorCompat.apply(edit);
    }

    @Override // com.ss.android.update.IUpdateDownloadListener
    public synchronized void saveDownloadInfo(int i, String str, boolean z) {
        synchronized (this.mUpdateStatusListeners) {
            for (OnUpdateStatusChangedListener onUpdateStatusChangedListener : this.mUpdateStatusListeners) {
                if (onUpdateStatusChangedListener != null) {
                    onUpdateStatusChangedListener.saveDownloadInfo(i, str, z);
                }
            }
        }
        if (z) {
            this.mPreDownloadSize = i;
        } else {
            this.mDownloadSize = i;
        }
        this.mDownloadEtag = str;
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0).edit();
        if (z) {
            edit.putInt(KEY_PRE_DOWNLOAD_SIZE, this.mPreDownloadSize);
        } else {
            edit.putInt(KEY_DOWNLOAD_SIZE, this.mDownloadSize);
        }
        edit.putString(KEY_DOWNLOAD_ETAG, this.mDownloadEtag);
        SharedPrefsEditorCompat.apply(edit);
    }

    @Override // com.ss.android.update.IUpdateDownloadListener
    public void updateProgress(int i, int i2, boolean z) {
        synchronized (this.mInfo) {
            if (!z) {
                this.mInfo.byteSoFar = i;
                this.mInfo.contentLength = i2;
            }
            synchronized (this.mUpdateStatusListeners) {
                for (OnUpdateStatusChangedListener onUpdateStatusChangedListener : this.mUpdateStatusListeners) {
                    if (onUpdateStatusChangedListener != null) {
                        onUpdateStatusChangedListener.updateProgress(i, i2, z);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.update.IUpdateDownloadListener
    public void downloadResult(final boolean z, final boolean z2) {
        com.bytedance.common.utility.Logger.e(TAG, "downloadResult isSuccess:" + z + ",pre:" + z2);
        final UpdateDownloadHelper.DownloadExtraInfo extraInfo = this.mDownloadHelper.getExtraInfo() != null ? this.mDownloadHelper.getExtraInfo() : UpdateDownloadHelper.DownloadExtraInfo.makeDefault();
        synchronized (this.mInfo) {
            if (!z2) {
                this.mInfo.status = z ? 3 : 2;
            }
        }
        this.mExecutorService.execute(new Runnable() { // from class: com.ss.android.update.UpdateHelper.9
            @Override // java.lang.Runnable
            public void run() {
                UpdateHelper.this.downloadResultMethod(z, z2, extraInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x007c  */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void downloadResultMethod(boolean z, boolean z2, UpdateDownloadHelper.DownloadExtraInfo downloadExtraInfo) {
        File file;
        File file2;
        boolean z3;
        String str;
        JSONObject jSONObject = new JSONObject();
        String str2 = null;
        ?? r10 = z;
        if (z) {
            if (!z2) {
                file = new File(this.mApkName);
                file.delete();
                file2 = new File(this.mTmpApkName);
                if (!file2.isFile()) {
                    file2.delete();
                    str2 = this.mTmpApkName + " is not a file.";
                    r10 = z;
                }
                if (!SignUtils.checkSignature(this.mContext, file2.getPath())) {
                    Utils.safePutJsonKV(jSONObject, "wrong_apk", true);
                    String apkPackage = getApkPackage(this.mContext, file2.getPath());
                    if (!TextUtils.isEmpty(apkPackage)) {
                        Utils.safePutJsonKV(jSONObject, "apk_package", apkPackage);
                    }
                    if (this.mCheckSignature) {
                        file2.delete();
                        com.bytedance.common.utility.Logger.e(TAG, "sign check error");
                        str2 = "sign check error";
                        r10 = z;
                    }
                }
                z3 = z;
                if (file2.renameTo(file)) {
                    z3 = true;
                }
                if (z3) {
                    str = null;
                } else {
                    str = DigestUtils.md5Hex(file);
                    SharedPreferences.Editor edit = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0).edit();
                    edit.putString("md5_" + file.getAbsolutePath(), str);
                    edit.apply();
                }
                r10 = z3;
                if (!StringUtils.isEmpty(str)) {
                    Utils.safePutJsonKV(jSONObject, "md5", str);
                    r10 = z3;
                }
            } else {
                file = new File(this.mPreDownloadApkName);
                file.delete();
                file2 = new File(this.mTmpPreDownloadApkName);
                if (!file2.isFile()) {
                    file2.delete();
                    str2 = this.mTmpPreDownloadApkName + " is not a file.";
                    r10 = z;
                }
                if (!SignUtils.checkSignature(this.mContext, file2.getPath())) {
                }
                z3 = z;
                if (file2.renameTo(file)) {
                }
                if (z3) {
                }
                r10 = z3;
                if (!StringUtils.isEmpty(str)) {
                }
            }
        }
        if (r10 != 0) {
            if (!new File(z2 ? this.mPreDownloadApkName : this.mApkName).isFile()) {
                r10 = 0;
            }
        }
        boolean isCanceled = this.mDownloadHelper.isCanceled();
        synchronized (this.mInfo) {
            if (z2) {
                this.mPreDownloading = false;
                if (r10 != 0 && downloadExtraInfo != null && downloadExtraInfo.isAlphaUpdateBgDownload) {
                    this.mHandler.sendEmptyMessage(16);
                }
            } else {
                this.mUpdating = false;
                if (r10 != 0) {
                    this.mHandler.sendEmptyMessage(1);
                    OnDownloadStatusChangedListener onDownloadStatusChangedListener = this.mDownloadStatusListener;
                    if (onDownloadStatusChangedListener != null) {
                        onDownloadStatusChangedListener.onDownloadStatusChanged(1);
                    }
                } else if (isCanceled) {
                    this.mHandler.sendEmptyMessage(13);
                    OnDownloadStatusChangedListener onDownloadStatusChangedListener2 = this.mDownloadStatusListener;
                    if (onDownloadStatusChangedListener2 != null) {
                        onDownloadStatusChangedListener2.onDownloadStatusChanged(-2);
                    }
                } else {
                    this.mHandler.sendEmptyMessage(4);
                    OnDownloadStatusChangedListener onDownloadStatusChangedListener3 = this.mDownloadStatusListener;
                    if (onDownloadStatusChangedListener3 != null) {
                        onDownloadStatusChangedListener3.onDownloadStatusChanged(-1);
                    }
                }
            }
            synchronized (this.mUpdateStatusListeners) {
                for (OnUpdateStatusChangedListener onUpdateStatusChangedListener : this.mUpdateStatusListeners) {
                    if (onUpdateStatusChangedListener != 0) {
                        onUpdateStatusChangedListener.downloadResult(r10, z2);
                    }
                }
            }
        }
        Utils.safePutJsonKV(jSONObject, Downloads.Impl.COLUMN_ERROR_MSG, str2);
        Utils.safePutJsonKV(jSONObject, "url", this.mDownloadUrl);
        Utils.safePutJsonKV(jSONObject, "pre", Integer.valueOf(z2 ? 1 : 0));
        Utils.safePutJsonKV(jSONObject, "canceled", Integer.valueOf(isCanceled ? 1 : 0));
        Utils.safePutJsonKV(jSONObject, "success", Integer.valueOf((int) r10));
        EventReporter.onEvent("app_update_download", jSONObject);
        if (r10 == 0 && !TextUtils.isEmpty(str2)) {
            UpdateEventUtils.downloadResultEvent(str2);
            UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, z2, "fail", str2);
        }
        this.mDownloadHelper.resetExtraInfo();
    }

    @Override // com.ss.android.update.IUpdateDownloadListener
    public void onPrepare(boolean z) {
        synchronized (this.mUpdateStatusListeners) {
            for (OnUpdateStatusChangedListener onUpdateStatusChangedListener : this.mUpdateStatusListeners) {
                if (onUpdateStatusChangedListener != null) {
                    onUpdateStatusChangedListener.onPrepare(z);
                }
            }
        }
        UpdateNotifyThread updateNotifyThread = new UpdateNotifyThread();
        this.mNotifyThread = updateNotifyThread;
        updateNotifyThread.start();
    }

    public void getProgress(DownloadInfo downloadInfo) {
        synchronized (this.mInfo) {
            downloadInfo.status = this.mInfo.status;
            downloadInfo.byteSoFar = this.mInfo.byteSoFar;
            downloadInfo.contentLength = this.mInfo.contentLength;
        }
    }

    private void loadData() {
        AppCommonContext appCommonContext = this.mAppCommonContext;
        if (appCommonContext != null) {
            this.mCurrentUpdateVersion = appCommonContext.getUpdateVersionCode();
        }
        if (this.mCurrentUpdateVersion < 1) {
            this.mCurrentUpdateVersion = 1;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SP_UPDATE_INFO, 0);
        this.mTipVersionCode = sharedPreferences.getInt(KEY_TIP_VERSION_CODE, 0);
        this.mRealVersionCode = sharedPreferences.getInt(KEY_REAL_VERSION_CODE, 0);
        this.mTipVersionName = sharedPreferences.getString(KEY_TIP_VERSION_NAME, "");
        this.mRealVersionName = sharedPreferences.getString(KEY_REAL_VERSION_NAME, "");
        this.mWhatsNew = sharedPreferences.getString(KEY_WHATS_NEW, "");
        this.mLastCheckTime = sharedPreferences.getLong(KEY_LAST_CHECK_TIME, 0L);
        this.mTitle = sharedPreferences.getString("title", "");
        this.mDownloadUrl = sharedPreferences.getString(KEY_URL, "");
        this.mForceUpdate = sharedPreferences.getBoolean(KEY_FORCE_UPDATE, false);
        this.mAlreadyDownloadTips = sharedPreferences.getString(KEY_ALREADY_DOWNLOAD_TIPS, "");
        this.mPreDownload = sharedPreferences.getBoolean(KEY_PRE_DOWNLOAD, false);
        this.mIntervalSinceNotifyUpdate = sharedPreferences.getInt(KEY_INTERVAL_SINCE_NOTIFY_UPDATE, 2);
        this.mIntervalSinceNotifyUpdate_second = sharedPreferences.getLong(KEY_INTERVAL_SINCE_NOTIFY_UPDATE_SECOND, -1L);
        this.mLatency = sharedPreferences.getInt(KEY_LATENCY, 0);
        this.mOfficial = sharedPreferences.getInt(KEY_OFFICIAL, 0);
        this.mDownloadEtag = sharedPreferences.getString(KEY_DOWNLOAD_ETAG, "");
        this.mDownloadVersion = sharedPreferences.getInt(KEY_DOWNLOAD_VERSION, 0);
        this.mDownloadSize = sharedPreferences.getInt(KEY_DOWNLOAD_SIZE, -1);
        this.mPreDownloadSize = sharedPreferences.getInt(KEY_PRE_DOWNLOAD_SIZE, -1);
        this.mBindApp = sharedPreferences.getBoolean(KEY_BIND_APP, false);
        this.mBindAppChecked = sharedPreferences.getBoolean(KEY_BIND_APP_CHECKED, false);
        this.mBindAppTips = sharedPreferences.getString(KEY_BIND_APP_TIPS, "");
        this.mBindAppName = sharedPreferences.getString("name", "");
        this.mBindAppPackage = sharedPreferences.getString("package", "");
        this.mBindAppDownloadUrl = sharedPreferences.getString(KEY_BIND_APP_DOWNLOAD_URL, "");
        this.mMarketUpdateTips = sharedPreferences.getString(KEY_MARKET_UPDATE_TIPS, "");
        this.mMarketUpdateIntentUrl = sharedPreferences.getString(KEY_MARKET_UPDTATE_INTENT_URL, "");
        this.mMarketUpdatePackage = sharedPreferences.getString(KEY_MARKET_UPDATE_PACKAGE, "");
        this.mMarketUpdateEnable = sharedPreferences.getBoolean(KEY_MARKET_UPDATE_ENABLE, false);
        this.mEnableClientStrategy = sharedPreferences.getInt(KEY_ENABLE_CLIENT_STRATEGY, 0);
        this.mDistributeId = sharedPreferences.getString(KEY_DISTRIBUTE_ID, "");
        this.mArtifactId = sharedPreferences.getInt(KEY_ARTIFACT_ID, 0);
        this.mPackageType = sharedPreferences.getInt(KEY_PACKAGE_TYPE, 0);
        this.mPopupType = sharedPreferences.getInt(KEY_POPUP_TYPE, -1);
        this.mUpdateButtonText = sharedPreferences.getString(KEY_UPDATE_BUTTON_TEXT, "");
        this.mMd5 = sharedPreferences.getString("md5", "");
        this.mReleaseRuleId = sharedPreferences.getInt(KEY_RELEASE_RULE_ID, 0);
        this.mStrategyId = sharedPreferences.getInt(KEY_STRATEGY_ID, 0);
        this.mChannel = sharedPreferences.getString("channel", "");
        this.mLastAnyDialogShowTime = sharedPreferences.getLong(KEY_LAST_ANY_DIALOG_SHOW_TIME, 0L);
    }

    public void showUpdateCheckDialog(final Context context) {
        UpdateStrategyManager.getInstance().applyUpdateBySelf();
        if (!isRealCurrentVersionOut()) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_CHECK_VERSION_CODE_FAIL);
            return;
        }
        final boolean canUseMarketUpdate = canUseMarketUpdate();
        String parseWhatsNew = parseWhatsNew(getWhatsNew());
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.ss.android.update.UpdateHelper.10
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (canUseMarketUpdate) {
                    UpdateHelper.this.updateWithMarket(context);
                    dialogInterface.dismiss();
                    return;
                }
                if (UpdateHelper.this.isRealCurrentVersionOut()) {
                    UpdateHelper.this.isClickUpdateButton = true;
                    UpdateHelper.this.cancelNotifyAvai();
                    File updateReadyApk = UpdateHelper.this.getUpdateReadyApk();
                    if (updateReadyApk != null) {
                        UpdateHelper.this.cancelNotifyReady();
                        UpdateHelper.this.installApk(context, updateReadyApk);
                    } else {
                        UpdateHelper.this.startDownload();
                    }
                    UpdateHelper.this.clickUpdateButton(false);
                    return;
                }
                dialogInterface.dismiss();
            }
        };
        if (this.mAnyDialogShowing) {
            UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_OTHER_DIALOG_SHOWING);
            return;
        }
        IUpdateCheckDialog iUpdateCheckDialog = this.mUpdateCheckDialogs;
        if (iUpdateCheckDialog == null) {
            showDefaultCheckVersionDialog(context, canUseMarketUpdate, parseWhatsNew, onClickListener);
        } else if (iUpdateCheckDialog != null) {
            if (!iUpdateCheckDialog.isShowCheckDialog()) {
                iUpdateCheckDialog.showCheckDialog(1);
            }
        } else {
            showDefaultCheckVersionDialog(context, canUseMarketUpdate, parseWhatsNew, onClickListener);
        }
        UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_SHOW, this.mDownloadUrl, this.mRealVersionCode, UpdateEventUtils.SOURCE_TRIGGER, -1, this.mForceUpdate);
    }

    private void showDefaultCheckVersionDialog(Context context, boolean z, String str, DialogInterface.OnClickListener onClickListener) {
        IUpdateCheckDialog iUpdateCheckDialog = this.mCheckDialogNew;
        if (iUpdateCheckDialog != null && !iUpdateCheckDialog.isShowCheckDialog()) {
            this.mCheckDialogNew = null;
        }
        if (this.mCheckDialogNew == null) {
            this.mCheckDialogNew = new UpdateCheckDialog(context);
        }
        if (this.mCheckDialogNew.isShowCheckDialog()) {
            return;
        }
        this.mCheckDialogNew.showCheckDialog(1);
    }

    public boolean isShowingUpdateCheckDialog() {
        IUpdateCheckDialog iUpdateCheckDialog = this.mUpdateCheckDialogs;
        if (iUpdateCheckDialog != null && iUpdateCheckDialog != null) {
            return iUpdateCheckDialog.isShowCheckDialog();
        }
        AlertDialog alertDialog = this.mCheckDialog;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public void installApk(Context context, File file) {
        if (context == null || file == null) {
            UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "install_fail", "context == null || file == null");
            return;
        }
        try {
            IUpdateAlphaDialog iUpdateAlphaDialog = this.mAlphaDialog;
            if (iUpdateAlphaDialog instanceof UpdateAlphaDialogNew) {
                if (iUpdateAlphaDialog.isShowAlphaDialog()) {
                    ((UpdateAlphaDialogNew) this.mAlphaDialog).updateBtnText();
                }
            } else {
                IUpdateMainDialog iUpdateMainDialog = this.mMainDialog;
                if ((iUpdateMainDialog instanceof UpdateDialogNew) && iUpdateMainDialog.isShowMainDialog()) {
                    ((UpdateDialogNew) this.mMainDialog).updateBtnText();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UpdateConfig updateConfig = this.mUpdateHostConfig;
            if (updateConfig != null && updateConfig.getAutoInstallApk() != null) {
                this.mUpdateHostConfig.getAutoInstallApk().installApk(context, file);
            } else {
                context.startActivity(getIntent(context, file));
            }
            UpdateEventUtils.installStatusEvent(1, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "install_fail", Log.getStackTraceString(e2));
            UpdateEventUtils.installStatusEvent(2, Log.getStackTraceString(e2));
        }
    }

    private Intent getIntent(Context context, File file) {
        UpdateConfig updateConfig = this.mUpdateHostConfig;
        Uri uriForFile = FileProvider.getUriForFile(context, updateConfig != null ? updateConfig.getFormalAuthority() : "com.ss.android.uri.key", file);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriForFile, "application/vnd.android.package-archive");
        intent.addFlags(268435457);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showOpenAlphaDialog(boolean z) {
        int i;
        if (this.showAlphaDialogEnable) {
            this.showAlphaDialogEnable = false;
            if (this.mPopupType == 1 && !UpdateAlphaManager.inst().openAlphaAppEnable()) {
                UpdateEventUtils.noShowDialogEvent("reason_cannot_local_package");
                return;
            }
            if (this.mDialogStyle == 3 || this.mDialogStyle == -3) {
                i = this.mDialogStyle;
            } else {
                i = this.mLocalDialogStyle;
            }
            WeakReference<Activity> currentActivity = this.mIUpdateConfig.getUpdateConfig().getICurrentActivityCallback().getCurrentActivity();
            if (currentActivity == null) {
                return;
            }
            Activity activity = currentActivity.get();
            if (activity == null || activity.isFinishing()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NOT_ACTIVE);
                return;
            }
            IUpdateAlphaDialog iUpdateAlphaDialog = this.mAlphaDialog;
            if (iUpdateAlphaDialog != null && !iUpdateAlphaDialog.isShowAlphaDialog()) {
                this.mAlphaDialog = null;
            }
            if (this.mAlphaDialog == null) {
                if (i == -3) {
                    IUpdateAlphaDialog iUpdateAlphaDialog2 = this.mUpdateAlphaDialogs;
                    this.mAlphaDialog = iUpdateAlphaDialog2;
                    if (iUpdateAlphaDialog2 == null) {
                        if (this.mIUpdateConfig.getUpdateConfig().isNewUiEnable()) {
                            this.mAlphaDialog = new UpdateAlphaDialogNew(activity, z);
                        } else {
                            this.mAlphaDialog = new UpdateAlphaDialog(activity, z);
                        }
                    }
                } else if (this.mIUpdateConfig.getUpdateConfig().isNewUiEnable()) {
                    this.mAlphaDialog = new UpdateAlphaDialogNew(activity, z);
                } else {
                    this.mAlphaDialog = new UpdateAlphaDialog(activity, z);
                }
            }
            if (!UpdateAlphaManager.inst().isNetworkInHouse()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_OUT_OF_HOUSE);
                this.mAlphaDialog = null;
                return;
            }
            if (this.mAlphaDialog.isShowAlphaDialog()) {
                return;
            }
            if (activity.getResources().getConfiguration().orientation == 2 && !this.mIUpdateConfig.getUpdateConfig().isLandscapeEnabled()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NO_ORIENTAL_DIALOG);
            } else {
                if (this.mAnyDialogShowing) {
                    UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_OTHER_DIALOG_SHOWING);
                    return;
                }
                this.mAlphaDialog.showAlphaDialog();
                UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_SHOW, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, UpdateAlphaManager.inst().isInstallAlphaApp() ? 4 : 3, this.mForceUpdate);
            }
        }
    }

    public void showUpdateAvailDialog(Context context, boolean z) {
        if (isCurrentVersionOut()) {
            IUpdateMainDialog iUpdateMainDialog = this.mUpdateMainDialogs;
            if (iUpdateMainDialog == null) {
                if (this.mIUpdateConfig.getUpdateConfig().isNewUiEnable()) {
                    this.mMainDialog = new UpdateDialogNew(context, z);
                } else {
                    this.mMainDialog = new UpdateDialog(context, z);
                }
            } else {
                this.mMainDialog = iUpdateMainDialog;
                if (iUpdateMainDialog == null) {
                    if (this.mIUpdateConfig.getUpdateConfig().isNewUiEnable()) {
                        this.mMainDialog = new UpdateDialogNew(context, z);
                    } else {
                        this.mMainDialog = new UpdateDialog(context, z);
                    }
                }
            }
            if (this.mMainDialog.isShowMainDialog()) {
                return;
            }
            if (context.getResources().getConfiguration().orientation == 2 && !this.mIUpdateConfig.getUpdateConfig().isLandscapeEnabled()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_NO_ORIENTAL_DIALOG);
                return;
            }
            if (this.mAnyDialogShowing) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_OTHER_DIALOG_SHOWING);
                return;
            }
            if (this.mUpdateHostConfig.isLocalApp() && !UpdateAlphaManager.inst().isNetworkInHouse()) {
                UpdateEventUtils.noShowDialogEvent(UpdateService.REASON_LOCAL_OUT_OF_HOUSE);
                this.mMainDialog = null;
                return;
            }
            try {
                this.mMainDialog.isAutoUpdate(z);
                this.mMainDialog.showMainDialog(z);
            } catch (Exception e) {
                UpdateEventUtils.noShowDialogEvent(e.toString());
            }
            UpdateEventUtils.popupEvent(UpdateEventUtils.EVENT_POPUP_SHOW, this.mDownloadUrl, this.mRealVersionCode, z ? UpdateEventUtils.SOURCE_AUTO : UpdateEventUtils.SOURCE_TRIGGER, -1, this.mForceUpdate);
        }
    }

    public boolean isShowingUpdateAvailDialog() {
        IUpdateMainDialog iUpdateMainDialog = this.mMainDialog;
        if (iUpdateMainDialog != null) {
            return iUpdateMainDialog.isShowMainDialog();
        }
        return false;
    }

    public void updateWithMarket(Context context) {
        if (context == null) {
            return;
        }
        try {
            context.startActivity(getMarketUpdateIntent());
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.d(TAG, th.getMessage(), th);
        }
    }

    public String getMarketUpdateTips() {
        return this.mMarketUpdateTips;
    }

    public boolean canUseMarketUpdate() {
        if (!this.mMarketUpdateEnable || this.mForceUpdate || this.mPreDownload || getBindApp()) {
            return false;
        }
        return canResolveIntent(getMarketUpdateIntent());
    }

    public Intent getMarketUpdateIntent() {
        try {
            if (TextUtils.isEmpty(this.mMarketUpdatePackage) || TextUtils.isEmpty(this.mMarketUpdateIntentUrl)) {
                return null;
            }
            Intent intent = new Intent();
            intent.setPackage(this.mMarketUpdatePackage);
            intent.setData(Uri.parse(this.mMarketUpdateIntentUrl));
            intent.addFlags(C0968C.ENCODING_PCM_MU_LAW);
            return intent;
        } catch (Exception e) {
            com.bytedance.common.utility.Logger.d(TAG, e.getMessage(), e);
            return null;
        }
    }

    private boolean canResolveIntent(Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = this.mContext.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null) {
                return queryIntentActivities.size() > 0;
            }
            return false;
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.d(TAG, th.getMessage(), th);
            return false;
        }
    }

    private void notifyDownloadReady() {
        File file = new File(this.mApkName);
        if (!file.exists() || !file.isFile()) {
            UpdateEventUtils.downloadEvent(this.mDownloadUrl, this.mRealVersionCode, false, "install_fail", "notifyDownloadReady");
            return;
        }
        AppCommonContext appCommonContext = this.mAppCommonContext;
        String stringAppName = appCommonContext != null ? appCommonContext.getStringAppName() : "";
        String format = String.format(this.mContext.getString(C0749R.string.ssl_notify_ready_ticker), stringAppName, getLastVersion());
        String format2 = String.format(this.mContext.getString(C0749R.string.ssl_notify_ready_fmt), getLastVersion());
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, getIntent(this.mContext, file), AVLogger.LEVEL_LOG_ERROR);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mContext);
        if (Build.VERSION.SDK_INT >= 26) {
            builder.setChannelId(NOTIFICATION_CHANNEL_ID);
            builder.setVibrate(new long[]{0});
        }
        UpdateConfig updateConfig = this.mUpdateHostConfig;
        builder.setSmallIcon(updateConfig != null ? updateConfig.getNotifyIcon() : C0749R.drawable.status_icon_l);
        builder.setTicker(format);
        builder.setWhen(System.currentTimeMillis());
        builder.setContentTitle(stringAppName).setContentText(format2);
        builder.setContentIntent(activity);
        builder.setAutoCancel(true);
        this.mNm.notify(C0749R.id.ssl_notify_download_ok, builder.build());
        installApk(this.mContext, file);
    }

    private void notifyDownloadFail() {
        if (canDownloadApk()) {
            AppCommonContext appCommonContext = this.mAppCommonContext;
            String stringAppName = appCommonContext != null ? appCommonContext.getStringAppName() : "";
            String string = this.mContext.getString(C0749R.string.ssl_download_fail);
            PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, new Intent(), AVLogger.LEVEL_LOG_ERROR);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mContext);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setChannelId(NOTIFICATION_CHANNEL_ID);
                builder.setVibrate(new long[]{0});
            }
            builder.setSmallIcon(android.R.drawable.stat_notify_error).setChannelId(NOTIFICATION_CHANNEL_ID).setTicker(string).setWhen(System.currentTimeMillis()).setContentTitle(stringAppName).setContentText(string).setContentIntent(activity).setAutoCancel(true);
            this.mNm.notify(C0749R.id.ssl_notify_download_fail, builder.build());
        }
    }

    private void notifyUpdateAvail() {
        if (canDownloadApk()) {
            AppCommonContext appCommonContext = this.mAppCommonContext;
            String stringAppName = appCommonContext != null ? appCommonContext.getStringAppName() : "";
            String format = String.format(this.mContext.getString(C0749R.string.ssl_notify_avail_ticker), stringAppName, getLastVersion());
            String format2 = String.format(this.mContext.getString(C0749R.string.ssl_notify_avail_fmt), getLastVersion());
            UpdateConfig updateConfig = this.mUpdateHostConfig;
            String updateActivityClassName = updateConfig != null ? updateConfig.getUpdateActivityClassName() : null;
            Intent intent = new Intent();
            if (!TextUtils.isEmpty(updateActivityClassName)) {
                if (com.bytedance.common.utility.Logger.debug()) {
                    com.bytedance.common.utility.Logger.d(TAG, "iUpdateActivity.getClass().getName() " + updateActivityClassName);
                }
                intent.setClassName(this.mContext, updateActivityClassName);
            } else {
                intent.setClassName(this.mContext, UpdateProgressActivity.class.getName());
            }
            intent.putExtra("from_update_avail", true);
            intent.addFlags(C0968C.ENCODING_PCM_A_LAW);
            PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, intent, AVLogger.LEVEL_LOG_ERROR);
            UpdateConfig updateConfig2 = this.mUpdateHostConfig;
            PendingIntent pendingIntent = (updateConfig2 == null || !updateConfig2.isUpdateActivityOff()) ? activity : null;
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mContext);
            if (Build.VERSION.SDK_INT >= 26) {
                builder.setChannelId(NOTIFICATION_CHANNEL_ID);
                builder.setVibrate(new long[]{0});
            }
            UpdateConfig updateConfig3 = this.mUpdateHostConfig;
            builder.setSmallIcon(updateConfig3 != null ? updateConfig3.getNotifyIcon() : C0749R.drawable.status_icon_l).setTicker(format).setWhen(System.currentTimeMillis()).setContentTitle(stringAppName).setContentText(format2).setContentIntent(pendingIntent).setAutoCancel(true);
            this.mNm.notify(C0749R.id.ssl_notify_update_avail, builder.build());
        }
    }

    private Notification getNotification(int i) {
        NotificationCompat.Builder builder;
        AppCommonContext appCommonContext = this.mAppCommonContext;
        String stringAppName = appCommonContext != null ? appCommonContext.getStringAppName() : "";
        String format = String.format(this.mContext.getString(C0749R.string.ssl_notify_download_fmt), stringAppName, getLastVersion());
        String str = "" + i + "%";
        UpdateConfig updateConfig = this.mUpdateHostConfig;
        String updateActivityClassName = updateConfig != null ? updateConfig.getUpdateActivityClassName() : null;
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(updateActivityClassName)) {
            if (com.bytedance.common.utility.Logger.debug()) {
                com.bytedance.common.utility.Logger.d(TAG, "iUpdateActivity.getClass().getName() " + updateActivityClassName);
            }
            intent.setClassName(this.mContext, updateActivityClassName);
        } else {
            intent.setClassName(this.mContext, UpdateProgressActivity.class.getName());
        }
        intent.addFlags(C0968C.ENCODING_PCM_A_LAW);
        PendingIntent activity = PendingIntent.getActivity(this.mContext, 0, intent, AVLogger.LEVEL_LOG_ERROR);
        UpdateConfig updateConfig2 = this.mUpdateHostConfig;
        PendingIntent pendingIntent = (updateConfig2 == null || !updateConfig2.isUpdateActivityOff()) ? activity : null;
        if (i == 0 || (builder = this.mNotificationBuilder) == null) {
            NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.mContext);
            this.mNotificationBuilder = builder2;
            builder2.setChannelId(NOTIFICATION_CHANNEL_ID);
            return NotificationBuilder.initProgressNotification(this.mContext, this.mNotificationBuilder, android.R.drawable.stat_sys_download, null, stringAppName, format, str, i, pendingIntent);
        }
        return NotificationBuilder.updateProgressNotification(this.mContext, builder, format, str, i);
    }

    public void setCustomUpdateDialog(IUpdateMainDialog iUpdateMainDialog, IUpdateCheckDialog iUpdateCheckDialog) {
        synchronized (this) {
            this.mUpdateMainDialogs = iUpdateMainDialog;
            this.mUpdateCheckDialogs = iUpdateCheckDialog;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class DownloadCountDownLatchRunnable implements Runnable {
        private CountDownLatch mCountDownLatch;
        private AtomicBoolean mIsCancle;

        public void countDown() {
            CountDownLatch countDownLatch = this.mCountDownLatch;
            if (countDownLatch == null) {
                return;
            }
            countDownLatch.countDown();
            if (com.bytedance.common.utility.Logger.debug()) {
                com.bytedance.common.utility.Logger.d(UpdateHelper.TAG, "countDown current count = " + this.mCountDownLatch.getCount());
            }
        }

        public void cancel() {
            this.mIsCancle.getAndSet(true);
            CountDownLatch countDownLatch = this.mCountDownLatch;
            long count = countDownLatch == null ? 0L : countDownLatch.getCount();
            for (int i = 0; i < count; i++) {
                this.mCountDownLatch.countDown();
            }
            if (!com.bytedance.common.utility.Logger.debug() || this.mCountDownLatch == null) {
                return;
            }
            com.bytedance.common.utility.Logger.d(UpdateHelper.TAG, "cancel current count = " + this.mCountDownLatch.getCount());
        }

        private DownloadCountDownLatchRunnable(CountDownLatch countDownLatch) {
            this.mIsCancle = new AtomicBoolean(false);
            this.mCountDownLatch = countDownLatch;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread.currentThread().setName("DownloadCountDownLatchThread");
            try {
                this.mCountDownLatch.await();
                if (this.mIsCancle.get()) {
                    return;
                }
                UpdateBindDownloadHelper.inst().handleBindAppOpen(UpdateHelper.this.mContext, UpdateHelper.this.mBindAppDownloadUrl);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    class DownloadInfoListener extends AbsDownloadListener {
        private boolean mHasCountDown = false;

        DownloadInfoListener() {
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onSuccessed(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            tryCountDown();
        }

        @Override // com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
        public void onFirstSuccess(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
            tryCountDown();
        }

        private void tryCountDown() {
            try {
                if (this.mHasCountDown) {
                    return;
                }
                this.mHasCountDown = true;
                UpdateHelper.this.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean isClientStrategyEnable() {
        if (!this.mInited) {
            loadData();
            this.mInited = true;
        }
        return this.mEnableClientStrategy != 0;
    }

    public void setAppExtra(String str) {
        this.mAppExtra = str;
    }

    public void reportDialogInfo(int i, boolean z) {
        Message obtain = Message.obtain();
        obtain.what = 15;
        obtain.arg1 = i;
        obtain.arg2 = z ? 1 : 0;
        this.mHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportDialogInfoTask(int i, int i2) {
        boolean z = i2 == 1;
        if (!this.mInited) {
            synchronized (this) {
                if (!this.mInited) {
                    loadData();
                    this.mInited = true;
                }
            }
        }
        if (i == 1) {
            saveLastAnyDialogShowTime(z);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("event_type", i);
            jSONObject.put(KEY_DISTRIBUTE_ID, this.mDistributeId);
            jSONObject.put(KEY_ARTIFACT_ID, this.mArtifactId);
            jSONObject.put("device_id", this.mUpdateHostConfig.getDeviceId());
            jSONObject.put(KEY_PACKAGE_TYPE, this.mPackageType);
            jSONObject.put(KEY_ENABLE_CLIENT_STRATEGY, this.mEnableClientStrategy);
            jSONObject.put(KEY_TIP_VERSION_CODE, this.mTipVersionCode);
            jSONObject.put(KEY_TIP_VERSION_NAME, this.mTipVersionName);
            if (z) {
                jSONObject.put("call_type", 1);
            } else {
                jSONObject.put("call_type", 0);
            }
            jSONObject.put("ac", com.bytedance.common.utility.NetworkUtils.getNetworkAccessType(this.mUpdateHostConfig.getAppContext().getContext()));
            byte[] bytes = jSONObject.toString().getBytes();
            String str = UpdateConstants.UPDATE_DIALOG_REPORT_URL;
            if (!StringUtils.isEmpty(this.mUpdateHostConfig.getAddedQuery())) {
                str = UpdateConstants.UPDATE_DIALOG_REPORT_URL + this.mUpdateHostConfig.getAddedQuery();
            }
            com.bytedance.common.utility.Logger.d(TAG, "update dialog report result: " + NetworkUtils.executePost(20480, str, bytes, NetworkUtils.CompressType.NONE, com.ss.android.common.util.NetworkUtils.CONTENT_TYPE_JSON));
        } catch (Throwable th) {
            com.bytedance.common.utility.Logger.w(TAG, "update dialog report error: " + th);
        }
    }

    public void setCustomUpdateAlphaDialog(IUpdateAlphaDialog iUpdateAlphaDialog) {
        synchronized (this) {
            this.mUpdateAlphaDialogs = iUpdateAlphaDialog;
        }
    }

    public Intent getIntentForLocalApp() {
        Context context;
        if (!UpdateAlphaManager.inst().isInstallAlphaApp() || (context = this.mContext) == null) {
            return null;
        }
        PackageManager packageManager = context.getPackageManager();
        UpdateConfig updateConfig = this.mUpdateHostConfig;
        if (updateConfig == null) {
            return null;
        }
        String localAppPackageName = updateConfig.getLocalAppPackageName();
        if (TextUtils.isEmpty(localAppPackageName)) {
            return null;
        }
        return packageManager.getLaunchIntentForPackage(localAppPackageName);
    }

    public boolean formalUpdateEnable() {
        int i = this.mPopupType;
        return i == 0 || i == 1;
    }

    public UpdateDownloadHelper getDownloadHelper() {
        return this.mDownloadHelper;
    }

    public int getRealVersionCode() {
        return this.mRealVersionCode;
    }

    public boolean isLocalApp() {
        UpdateConfig updateConfig = this.mUpdateHostConfig;
        return updateConfig != null && updateConfig.isLocalApp();
    }
}
