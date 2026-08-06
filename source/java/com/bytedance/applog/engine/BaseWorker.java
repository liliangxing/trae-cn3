package com.bytedance.applog.engine;

import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.common.utility.NetworkUtils;
import org.json.JSONException;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class BaseWorker {
    static final long[] RETRY_SAME = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    public static volatile boolean fixNoNetworkDoWork = false;
    public static volatile long noNetworkCheckWorkIntervalMs = 5000;
    protected final Engine mEngine;
    private int mFailCount;
    volatile boolean mImmediately;
    private long mLastTime;
    private boolean mStop;

    protected abstract boolean doWork(int i) throws JSONException;

    protected abstract String getName();

    protected abstract long[] getRetryIntervals();

    protected abstract boolean needNet();

    protected abstract long nextInterval();

    public BaseWorker(Engine engine) {
        this.mEngine = engine;
    }

    public BaseWorker(Engine engine, long j) {
        this(engine);
        this.mLastTime = j;
    }

    public void setStop(boolean z) {
        this.mStop = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isStop() {
        return !getAppLog().hasStarted() || this.mStop;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AppLogInstance getAppLog() {
        return this.mEngine.getAppLog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long checkToWork(int i) {
        long checkWorkTime = checkWorkTime();
        return checkWorkTime <= System.currentTimeMillis() ? work(i) : checkWorkTime;
    }

    private long checkWorkTime() {
        long nextInterval = nextInterval();
        if (needNet() && !NetworkUtils.isNetworkAvailableFast(this.mEngine.getContext())) {
            getAppLog().getLogger().warn("checkWorkTime {} network not available, will try again next interval!", getName());
            this.mEngine.getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.NO_NETWORK_COUNT);
            if (fixNoNetworkDoWork) {
                this.mLastTime = Math.max(this.mLastTime, (System.currentTimeMillis() - nextInterval) + noNetworkCheckWorkIntervalMs);
            }
        } else if (this.mImmediately) {
            nextInterval = 0;
            this.mLastTime = 0L;
            this.mImmediately = false;
        } else {
            int i = this.mFailCount;
            if (i > 0) {
                nextInterval = getFailInterval(i - 1);
            }
        }
        return this.mLastTime + nextInterval;
    }

    private synchronized long work(int i) {
        try {
            boolean doWork = doWork(i);
            this.mLastTime = System.currentTimeMillis();
            if (doWork) {
                this.mFailCount = 0;
            } else {
                this.mFailCount++;
            }
            getAppLog().getLogger().debug(getName() + " worked: {}", Boolean.valueOf(doWork));
        } catch (Throwable th) {
            try {
                getAppLog().getLogger().error("work failed", th, new Object[0]);
                this.mLastTime = System.currentTimeMillis();
                this.mFailCount++;
                getAppLog().getLogger().debug(getName() + " worked: {}", false);
            } catch (Throwable th2) {
                this.mLastTime = System.currentTimeMillis();
                this.mFailCount++;
                getAppLog().getLogger().debug(getName() + " worked: {}", false);
                throw th2;
            }
        }
        return checkWorkTime();
    }

    private long getFailInterval(int i) {
        long[] retryIntervals = getRetryIntervals();
        return retryIntervals[i % retryIntervals.length];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends BaseWorker> T setImmediately() {
        this.mImmediately = true;
        return this;
    }
}
