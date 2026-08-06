package com.bytedance.reparo;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.core.Options;
import com.bytedance.reparo.core.PatchEventReporter;
import com.bytedance.reparo.core.common.utils.DigestUtils;
import com.bytedance.reparo.core.common.utils.FileUtils;
import com.bytedance.reparo.core.exception.PatchException;
import com.bytedance.reparo.core.utils.AutoFailSyncHelper;
import com.bytedance.reparo.model.PatchFetchInfo;
import com.bytedance.reparo.secondary.AppMonitorService;
import com.bytedance.reparo.secondary.CheckedReparoConfig;
import com.bytedance.reparo.secondary.EventReporter;
import com.bytedance.reparo.secondary.Logger;
import com.bytedance.reparo.secondary.SecondaryService;
import java.io.File;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class Reparo {
    private static final long DEFAULT_REQUEST_INTERVAL = 5000;
    private static final String TAG = "Reparo";
    private static volatile Reparo sInstance = null;
    private static long sRequestInterval = 5000;
    volatile boolean intoBackground;
    private IReparoConfig mConfig;
    private Application mContext;
    private PatchEventReporter.IReporter mEventReporter;
    private volatile long mLastRequestTime;
    private Options mOptions;
    private volatile boolean mInited = false;
    private int mLocalPatchId = 1;
    private volatile boolean mInitApplicationStateManager = false;
    private boolean mSubProcessSwitch = true;
    private String mServerUrl = com.bytedance.reparo.core.BuildConfig.SERVICE_URL;
    private final PatchUpdateManager mPatchUpdateManager = PatchUpdateManager.getInstance();
    private final ApplicationStateManager mApplicationStateManager = ApplicationStateManager.getInstance();

    private Reparo() {
    }

    public static Reparo getInstance() {
        if (sInstance == null) {
            synchronized (Reparo.class) {
                if (sInstance == null) {
                    sInstance = new Reparo();
                }
            }
        }
        return sInstance;
    }

    public synchronized void init(IReparoConfig iReparoConfig) {
        if (iReparoConfig.autoFetchPatch()) {
            initApplicationStateManager(iReparoConfig);
        }
        if (iReparoConfig.enable()) {
            if (iReparoConfig.autoFailThenSyncMode()) {
                AutoFailSyncHelper.mAutoFailThenSyncMode = true;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            CheckedReparoConfig checkedReparoConfig = new CheckedReparoConfig(iReparoConfig);
            if (checkedReparoConfig.isMainProcess() || this.mSubProcessSwitch) {
                if (this.mInited) {
                    return;
                }
                try {
                    initInternal(checkedReparoConfig);
                    this.mInited = true;
                    EventReporter.reportSdkInitSuccessEvent(TAG, elapsedRealtime);
                    this.mPatchUpdateManager.getExecutorService().execute(new Runnable() { // from class: com.bytedance.reparo.Reparo.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AppMonitorService.reportLocalPatchList();
                        }
                    });
                } catch (Throwable th) {
                    Logger.m327e(TAG, "init failed. ", th);
                    EventReporter.reportSdkInitFailedEvent(TAG, new PatchException("init failed. ", th, 0), elapsedRealtime);
                }
            }
        }
    }

    private synchronized void initApplicationStateManager(final IReparoConfig iReparoConfig) {
        if (this.mInitApplicationStateManager) {
            return;
        }
        this.mApplicationStateManager.init(iReparoConfig.getApplication());
        this.mApplicationStateManager.addAppStateListener(new ApplicationStateListener() { // from class: com.bytedance.reparo.Reparo.2
            @Override // com.bytedance.reparo.ApplicationStateListener
            public void startFirstActivity() {
            }

            @Override // com.bytedance.reparo.ApplicationStateListener
            public void intoFront() {
                if (Reparo.this.intoBackground) {
                    if (!Reparo.this.mInited) {
                        Reparo.this.init(iReparoConfig);
                    }
                    Reparo.this.loadRemotePatchAsync();
                    Reparo.this.intoBackground = false;
                }
            }

            @Override // com.bytedance.reparo.ApplicationStateListener
            public void intoBackground() {
                Reparo.this.intoBackground = true;
            }
        });
        this.mInitApplicationStateManager = true;
    }

    private synchronized void initInternal(IReparoConfig iReparoConfig) {
        checkParameters(iReparoConfig);
        this.mConfig = iReparoConfig;
        Application application = iReparoConfig.getApplication();
        this.mContext = application;
        SecondaryService.init(application, iReparoConfig, this.mPatchUpdateManager.getExecutorService());
        this.mPatchUpdateManager.init(this.mContext, iReparoConfig, iReparoConfig.isMainProcess(), iReparoConfig.getUpdateVersionCode(), getOptions());
    }

    public void setOptions(Options options) {
        this.mOptions = options;
    }

    private Options getOptions() {
        if (this.mOptions == null) {
            this.mOptions = new Options();
        }
        return this.mOptions;
    }

    public void setServerUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("url is empty");
        }
        this.mServerUrl = str;
    }

    public String getServerUrl() {
        return this.mServerUrl;
    }

    public void setRequestInterval(long j) {
        sRequestInterval = j;
    }

    public void loadRemotePatch() {
        if (this.mInited) {
            long currentTimeMillis = System.currentTimeMillis();
            Logger.m328i(TAG, "now = " + currentTimeMillis + ", last = " + this.mLastRequestTime + " inter = " + sRequestInterval);
            if (currentTimeMillis - this.mLastRequestTime > sRequestInterval) {
                this.mLastRequestTime = currentTimeMillis;
                this.mPatchUpdateManager.update();
            } else {
                Logger.m328i(TAG, " not load");
            }
        }
    }

    public void loadRemotePatchAsync() {
        if (this.mInited) {
            this.mPatchUpdateManager.getExecutorService().execute(new Runnable() { // from class: com.bytedance.reparo.Reparo.3
                @Override // java.lang.Runnable
                public void run() {
                    Reparo.this.loadRemotePatch();
                }
            });
        }
    }

    public void updateFromLocal(File file) {
        if (this.mInited) {
            if (!FileUtils.isExist(file)) {
                throw new IllegalArgumentException("patch file not exist.");
            }
            PatchFetchInfo patchFetchInfo = new PatchFetchInfo();
            patchFetchInfo.setVersionCode(this.mLocalPatchId);
            patchFetchInfo.setPatchName(file.getName());
            patchFetchInfo.setHostAppVersion(this.mConfig.getUpdateVersionCode());
            patchFetchInfo.setMd5(DigestUtils.md5Hex(file));
            patchFetchInfo.setSupportSubProcess(true);
            patchFetchInfo.setPatchId(this.mLocalPatchId);
            StringBuilder sb = new StringBuilder("");
            int i = this.mLocalPatchId;
            this.mLocalPatchId = i + 1;
            patchFetchInfo.setIssueId(sb.append(i).toString());
            this.mPatchUpdateManager.updateFromLocal(patchFetchInfo, file);
        }
    }

    public IReparoConfig getFrankieConfig() {
        return this.mConfig;
    }

    public Application getApplication() {
        return this.mContext;
    }

    public void setEventReport(PatchEventReporter.IReporter iReporter) {
        this.mEventReporter = iReporter;
    }

    public PatchEventReporter.IReporter getEventReporter() {
        return this.mEventReporter;
    }

    public void disableSubProcess() {
        this.mSubProcessSwitch = false;
        Logger.m328i(TAG, "disableSubProcess:" + this.mSubProcessSwitch);
    }

    public void enableSubProcess() {
        this.mSubProcessSwitch = true;
        Logger.m328i(TAG, "enableSubProcess:" + this.mSubProcessSwitch);
    }

    public boolean isHotFixReady() {
        return this.mInited && this.mPatchUpdateManager.hasInited();
    }

    public void rescueIfNeed() {
        if (this.mInited) {
            CrashRescuer.getInstance(this.mContext).rescueIfNeeded();
        }
    }

    @Deprecated
    public boolean clearPatchForCrash(Application application, String str) {
        clearPatchForCrash();
        return true;
    }

    public void clearPatchForCrash() {
        this.mPatchUpdateManager.clearPatches();
    }

    private void checkParameters(IReparoConfig iReparoConfig) {
        if (iReparoConfig == null) {
            throw new IllegalArgumentException("IFrankieConfig can not be null!");
        }
        if (iReparoConfig.getApplication() == null) {
            throw new IllegalArgumentException("IFrankieConfig.getApplication() can not be null!");
        }
        if (iReparoConfig.getUpdateVersionCode() == null) {
            throw new IllegalArgumentException("IFrankieConfig.getUpdateVersionCode() can not be null!");
        }
    }
}
