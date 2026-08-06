package com.bytedance.bdinstall;

import android.content.Context;
import com.bytedance.bdinstall.InstallDispatcher;
import com.bytedance.bdinstall.util.NetUtils;
import org.json.JSONException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseWorker {
    private static final long NEXT_CHECK_NET = 60000;
    private static final long NEXT_CHECK_SILENCE = 60000;
    final Context mApp;
    protected BdInstallInstance mBdInstallInstance;
    protected int mFailCount = 0;
    private long mLastTime;
    private InstallDispatcher.NetworkObserver.OnNetworkReadyListener mNetListener;
    private boolean mStop;
    final InstallOptions sOptions;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    @interface Error {
        public static final int ERR_NETWORK = 1;
        public static final int ERR_REQUEST_FAILED = 3;
        public static final int ERR_RETRY_LIMIT_FAILED = 4;
        public static final int ERR_TIME_NOT_READY = 2;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void doEventTrack();

    protected abstract boolean doWork() throws JSONException;

    protected abstract String getName();

    protected abstract long[] getRetryIntervals();

    public abstract boolean needListenNetChange();

    protected abstract boolean needNet();

    protected abstract long nextInterval();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void onResult(boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long silenceCheckInterval() {
        return 60000L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void updateFailCount(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseWorker(Context context, InstallOptions installOptions) {
        this.mApp = context;
        this.sOptions = installOptions;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(installOptions.getAid()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseWorker(Context context, InstallOptions installOptions, long j) {
        this.mApp = context;
        this.sOptions = installOptions;
        this.mLastTime = j;
        this.mBdInstallInstance = BdInstallInstance.getInstance(String.valueOf(installOptions.getAid()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void stop() {
        this.mStop = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStop() {
        return this.mStop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final WorkResult work() {
        boolean z;
        char c;
        long j;
        int i = 1;
        char c2 = 0;
        r2 = 0;
        boolean z2 = 0;
        Object[] objArr = !needNet() || NetUtils.isNetReady(this.mApp);
        WorkResult workResult = new WorkResult();
        if (objArr == false) {
            DrLog.m140e("network not ready. delay 60000 ms do " + getName());
            j = 60000;
        } else {
            long nextInterval = this.mLastTime + nextInterval();
            long currentTimeMillis = System.currentTimeMillis();
            if (nextInterval <= 1000 + currentTimeMillis) {
                try {
                    z = doWork();
                } catch (Exception e) {
                    e.printStackTrace();
                    DrLog.ysnp(e);
                    z = false;
                }
                if (z) {
                    workResult.retryCount = this.mFailCount;
                    this.mFailCount = 0;
                    this.mLastTime = System.currentTimeMillis();
                    j = nextInterval();
                } else {
                    long[] retryIntervals = getRetryIntervals();
                    int i2 = this.mFailCount;
                    int i3 = i2 + 1;
                    this.mFailCount = i3;
                    int length = i2 % retryIntervals.length;
                    long j2 = retryIntervals[length];
                    if (length == retryIntervals.length - 1) {
                        workResult.retryCount = i3;
                        c = 4;
                    } else {
                        c = 3;
                    }
                    j = j2;
                    c2 = c;
                    i = 0;
                }
                DrLog.m142i(getName() + " worked:" + z + " " + j, null);
                char c3 = c2;
                z2 = i;
                i = c3;
            } else {
                j = nextInterval - currentTimeMillis;
                DrLog.m139d(getName() + "time not ready. need " + j);
                i = 2;
            }
        }
        workResult.errReason = i;
        workResult.success = z2;
        workResult.nextDelay = j;
        return workResult;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseWorker> T setImmediately() {
        this.mLastTime = 0L;
        return this;
    }

    public void setNetObserver(InstallDispatcher.NetworkObserver.OnNetworkReadyListener onNetworkReadyListener) {
        this.mNetListener = onNetworkReadyListener;
    }

    public InstallDispatcher.NetworkObserver.OnNetworkReadyListener getNetObserver() {
        return this.mNetListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class WorkResult {
        boolean success = false;
        int errReason = 0;
        long nextDelay = 0;
        int retryCount = 0;

        WorkResult() {
        }
    }
}
