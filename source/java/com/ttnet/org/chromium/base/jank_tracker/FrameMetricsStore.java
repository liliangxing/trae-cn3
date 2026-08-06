package com.ttnet.org.chromium.base.jank_tracker;

import com.ttnet.org.chromium.build.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes7.dex */
class FrameMetricsStore {
    private final Object mLock = new Object();
    private final ArrayList<Long> mTimestampsNs = new ArrayList<>();
    private final ArrayList<Long> mTotalDurationsNs = new ArrayList<>();
    private final ArrayList<Integer> mSkippedFrames = new ArrayList<>();
    private final HashMap<Integer, Long> mScenarioPreviousFrameTimestampNs = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addFrameMeasurement(long j, long j2, int i) {
        synchronized (this.mLock) {
            if (this.mScenarioPreviousFrameTimestampNs.isEmpty()) {
                return;
            }
            this.mTimestampsNs.add(Long.valueOf(j));
            this.mTotalDurationsNs.add(Long.valueOf(j2));
            this.mSkippedFrames.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startTrackingScenario(int i) {
        synchronized (this.mLock) {
            if (this.mScenarioPreviousFrameTimestampNs.containsKey(Integer.valueOf(i))) {
                return;
            }
            Long l = 0L;
            if (!this.mTimestampsNs.isEmpty()) {
                l = this.mTimestampsNs.get(r1.size() - 1);
            }
            this.mScenarioPreviousFrameTimestampNs.put(Integer.valueOf(i), l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FrameMetrics stopTrackingScenario(int i) {
        int indexOf;
        synchronized (this.mLock) {
            Long remove = this.mScenarioPreviousFrameTimestampNs.remove(Integer.valueOf(i));
            if (remove == null) {
                return new FrameMetrics();
            }
            if (remove.longValue() == 0) {
                indexOf = 0;
            } else {
                indexOf = this.mTimestampsNs.indexOf(remove) + 1;
                if (indexOf >= this.mTimestampsNs.size()) {
                    return new FrameMetrics();
                }
            }
            int size = this.mTimestampsNs.size();
            int i2 = size - indexOf;
            FrameMetrics frameMetrics = new FrameMetrics((Long[]) this.mTimestampsNs.subList(indexOf, size).toArray(new Long[i2]), (Long[]) this.mTotalDurationsNs.subList(indexOf, size).toArray(new Long[i2]), (Integer[]) this.mSkippedFrames.subList(indexOf, size).toArray(new Integer[i2]));
            removeUnusedFrames();
            return frameMetrics;
        }
    }

    FrameMetrics getAllStoredMetricsForTesting() {
        FrameMetrics frameMetrics;
        synchronized (this.mLock) {
            ArrayList<Long> arrayList = this.mTimestampsNs;
            Long[] lArr = (Long[]) arrayList.toArray(new Long[arrayList.size()]);
            ArrayList<Long> arrayList2 = this.mTotalDurationsNs;
            Long[] lArr2 = (Long[]) arrayList2.toArray(new Long[arrayList2.size()]);
            ArrayList<Integer> arrayList3 = this.mSkippedFrames;
            frameMetrics = new FrameMetrics(lArr, lArr2, (Integer[]) arrayList3.toArray(new Integer[arrayList3.size()]));
        }
        return frameMetrics;
    }

    private void removeUnusedFrames() {
        if (this.mScenarioPreviousFrameTimestampNs.isEmpty()) {
            this.mTimestampsNs.clear();
            this.mTotalDurationsNs.clear();
            this.mSkippedFrames.clear();
            return;
        }
        long findFirstUsedTimestamp = findFirstUsedTimestamp();
        if (findFirstUsedTimestamp == 0) {
            return;
        }
        int indexOf = this.mTimestampsNs.indexOf(Long.valueOf(findFirstUsedTimestamp));
        if (indexOf == -1) {
            if (BuildConfig.ENABLE_ASSERTS) {
                throw new IllegalStateException("Timestamp for tracked scenario not found");
            }
        } else {
            this.mTimestampsNs.subList(0, indexOf).clear();
            this.mTotalDurationsNs.subList(0, indexOf).clear();
            this.mSkippedFrames.subList(0, indexOf).clear();
        }
    }

    private long findFirstUsedTimestamp() {
        Iterator<Long> it = this.mScenarioPreviousFrameTimestampNs.values().iterator();
        long j = Long.MAX_VALUE;
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            if (longValue < j) {
                j = longValue;
            }
        }
        return j;
    }
}
