package com.bytedance.apm.battery.stats;

import android.os.SystemClock;
import com.bytedance.apm.battery.BatteryCollector;
import com.bytedance.apm.battery.config.Constants;
import com.bytedance.apm.battery.internal.BatteryDataManager;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.entity.BatteryLogEntity;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.thread.AsyncEventManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsBatteryTimeStats<T extends BaseHookInfo> extends AbsHookStatsTask<T> implements IBatteryStats {
    private static final Object innerLock = new Object();
    private volatile int mHoldCount;
    private volatile long mStartTime;
    private int mTotalCount;
    private long mTotalTime;

    abstract void reportAccumulatedIssue(double d, double d2);

    protected abstract void reportSingleIssue(T t, long j);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsBatteryTimeStats(String str) {
        super(str);
        this.mHoldCount = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    public void pollingTask(long j, long j2, boolean z) {
        this.mTotalCount = 0;
        this.mTotalTime = 0L;
        innerRecord(z);
        super.pollingTask(j, j2, z);
        long currentTimeMillis = System.currentTimeMillis();
        reportAccumulatedIssue((this.mTotalTime / (currentTimeMillis - this.mLastPollingTime)) * 60000.0d * 10.0d, (this.mTotalCount / (currentTimeMillis - this.mLastPollingTime)) * 60000.0d * 10.0d);
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask
    protected void checkStats(T t, long j, long j2) {
        this.mTotalCount++;
        long j3 = t.startTime;
        if (j3 >= j) {
            j = j3;
        }
        long j4 = t.endTime;
        if (j4 > 0 && j2 >= j4) {
            j2 = j4;
        }
        reportSingleIssue(t, j2 - t.startTime);
        long j5 = j2 - j;
        if (j5 > 0) {
            this.mTotalTime += j5;
        }
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean z) {
        innerRecord(z);
        super.onBack(z);
    }

    @Override // com.bytedance.apm.battery.stats.AbsHookStatsTask, com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean z) {
        innerRecord(z);
        super.onFront(z);
    }

    private void innerRecord(boolean z) {
        synchronized (innerLock) {
            if (this.mHoldCount > 0 && this.mStartTime > 0) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (z) {
                    record(elapsedRealtime - this.mStartTime, this.mIsFront, BatteryCollector.getInstance().getCurSceneSetStr());
                }
                this.mStartTime = elapsedRealtime;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addHolderCount() {
        synchronized (innerLock) {
            ApmAlogHelper.m77i(Constants.TAG_BATTERY, "addHolderCount:" + this.mHoldCount + " type:" + getType());
            this.mHoldCount++;
            if (this.mHoldCount == 1) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reduceHolderCount() {
        synchronized (innerLock) {
            ApmAlogHelper.m77i(Constants.TAG_BATTERY, "reduceHolderCount:" + this.mHoldCount + " type:" + getType());
            if (this.mHoldCount == 0) {
                return;
            }
            this.mHoldCount--;
            if (this.mHoldCount == 0) {
                final boolean z = this.mIsFront;
                final long elapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                AsyncEventManager.getInstance().post(new Runnable() { // from class: com.bytedance.apm.battery.stats.AbsBatteryTimeStats.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AbsBatteryTimeStats.this.record(elapsedRealtime, z, BatteryCollector.getInstance().getCurSceneSetStr());
                    }
                });
                this.mStartTime = -1L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void record(long j, boolean z, String str) {
        BatteryDataManager.getInstance().record(new BatteryLogEntity(z, System.currentTimeMillis(), getType(), this.mIsCharging, j, str));
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onChargeStatusChange(boolean z, boolean z2) {
        innerRecord(z2);
        this.mIsCharging = z;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void startSceneMonitor(String str, boolean z) {
        innerRecord(z);
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void stopSceneMonitor(String str, boolean z) {
        innerRecord(z);
    }
}
