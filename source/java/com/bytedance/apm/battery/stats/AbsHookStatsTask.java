package com.bytedance.apm.battery.stats;

import com.bytedance.apm.ApmContext;
import com.bytedance.apm.battery.stats.info.BaseHookInfo;
import com.bytedance.apm.battery.util.BatteryUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsHookStatsTask<T extends BaseHookInfo> implements IBatteryStats {
    private final String mType;
    ConcurrentHashMap<Integer, T> mDetectMap = new ConcurrentHashMap<>();
    volatile boolean mIsFront = ActivityLifeObserver.getInstance().isForeground();
    volatile long mLastPollingTime = System.currentTimeMillis();
    volatile boolean mIsCharging = BatteryUtils.isCharging(ApmContext.getContext());

    protected abstract void checkStats(T t, long j, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsHookStatsTask(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onFront(boolean z) {
        this.mIsFront = true;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onBack(boolean z) {
        this.mIsFront = false;
    }

    @Override // com.bytedance.apm.battery.stats.IBatteryStats
    public void onTimer(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mDetectMap.size() != 0) {
            pollingTask(this.mLastPollingTime, currentTimeMillis, z);
        }
        this.mLastPollingTime = currentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pollingTask(long j, long j2, boolean z) {
        Iterator<Map.Entry<Integer, T>> it = this.mDetectMap.entrySet().iterator();
        while (it.hasNext()) {
            T value = it.next().getValue();
            if (0 < value.endTime && value.endTime < value.startTime) {
                it.remove();
            } else if (0 < value.endTime && value.endTime < j) {
                it.remove();
            } else if (j2 >= value.startTime) {
                checkStats(value, j, j2);
            }
        }
    }
}
