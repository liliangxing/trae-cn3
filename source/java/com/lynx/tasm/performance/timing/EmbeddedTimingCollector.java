package com.lynx.tasm.performance.timing;

import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.performance.IPerformanceObserver;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntryConverter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class EmbeddedTimingCollector {
    private long mLoadBundleStartUs;
    private WeakReference<IPerformanceObserver> mObserver;
    private long mPaintEndUs;
    private final ArrayList<Long> mUpdateDataStartUsList = new ArrayList<>();
    private boolean mHasEmitLoadBundleEvent = false;

    public void setObserver(WeakReference<IPerformanceObserver> weakReference) {
        this.mObserver = weakReference;
    }

    public boolean hasEmitLoadBundleEvent() {
        return this.mHasEmitLoadBundleEvent;
    }

    public boolean hasPendingUpdateEvent() {
        return !this.mUpdateDataStartUsList.isEmpty();
    }

    public void markTiming(String str, long j) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1930716102:
                if (str.equals(TimingConstants.LOAD_BUNDLE_START)) {
                    c = 0;
                    break;
                }
                break;
            case 831051791:
                if (str.equals(TimingConstants.UPDATE_DATA_START)) {
                    c = 1;
                    break;
                }
                break;
            case 925946781:
                if (str.equals(TimingConstants.PAINT_END)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.mLoadBundleStartUs = j;
                return;
            case 1:
                this.mUpdateDataStartUsList.add(Long.valueOf(j));
                return;
            case 2:
                this.mPaintEndUs = j;
                emitLoadBundleIfReady();
                emitUpdateDataIfReady();
                return;
            default:
                return;
        }
    }

    private void emitLoadBundleIfReady() {
        WeakReference<IPerformanceObserver> weakReference;
        IPerformanceObserver iPerformanceObserver;
        if (this.mHasEmitLoadBundleEvent || (weakReference = this.mObserver) == null || (iPerformanceObserver = weakReference.get()) == null) {
            return;
        }
        this.mHasEmitLoadBundleEvent = true;
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.put("entryType", "pipeline");
        javaOnlyMap.put("name", TimingConstants.LOAD_BUNDLE);
        javaOnlyMap.put(TimingConstants.LOAD_BUNDLE_START, Double.valueOf(this.mLoadBundleStartUs / 1000.0d));
        javaOnlyMap.put(TimingConstants.PAINT_END, Double.valueOf(this.mPaintEndUs / 1000.0d));
        iPerformanceObserver.onPerformanceEvent(PerformanceEntryConverter.makePerformanceEntry(javaOnlyMap));
    }

    private void emitUpdateDataIfReady() {
        IPerformanceObserver iPerformanceObserver;
        WeakReference<IPerformanceObserver> weakReference = this.mObserver;
        if (weakReference == null || (iPerformanceObserver = weakReference.get()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.mUpdateDataStartUsList);
        this.mUpdateDataStartUsList.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l = (Long) it.next();
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            javaOnlyMap.put("entryType", "pipeline");
            javaOnlyMap.put("name", TimingConstants.UPDATE_TRIGGERED_BY_NATIVE);
            javaOnlyMap.put(TimingConstants.PIPELINE_START, Double.valueOf(l.longValue() / 1000.0d));
            javaOnlyMap.put(TimingConstants.PAINT_END, Double.valueOf(this.mPaintEndUs / 1000.0d));
            iPerformanceObserver.onPerformanceEvent(PerformanceEntryConverter.makePerformanceEntry(javaOnlyMap));
        }
    }
}
