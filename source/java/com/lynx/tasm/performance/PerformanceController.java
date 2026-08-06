package com.lynx.tasm.performance;

import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.LynxBooleanOption;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.TimingHandler;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.eventreport.LynxEventReporter;
import com.lynx.tasm.p001ui.image.TraceEventDef;
import com.lynx.tasm.performance.memory.IMemoryMonitor;
import com.lynx.tasm.performance.memory.IMemoryRecordBuilder;
import com.lynx.tasm.performance.memory.MemoryRecord;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntryConverter;
import com.lynx.tasm.performance.timing.EmbeddedTimingCollector;
import com.lynx.tasm.performance.timing.ITimingCollector;
import com.lynx.tasm.performance.timing.TimingConstants;
import com.lynx.tasm.service.ILynxEventReporterService;
import com.lynx.tasm.service.LynxServiceCenter;
import com.lynx.tasm.utils.UIThreadUtils;
import com.optimize.statistics.FrescoMonitorConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class PerformanceController implements IMemoryMonitor, ITimingCollector {
    private static final String TAG = "PerformanceController";
    private static volatile boolean sIsNativeLibraryLoaded;
    private EmbeddedTimingCollector mEmbeddedTimingCollector;
    private WeakReference<ILynxEventReporterService> mEventReporterService;
    private JavaOnlyMap mHostPlatformTiming;
    private WeakReference<IPerformanceObserver> mObserver;
    private static volatile LynxBooleanOption sIsMemoryMonitorEnabled = LynxBooleanOption.UNSET;
    private static volatile long sMemoryAcquisitionDelaySec = -1;
    private volatile long mNativePerformanceActorPtr = 0;
    private boolean mUseEmbeddedMode = false;
    private JavaOnlyArray mPendingPaintEndPipelineIds = new JavaOnlyArray();
    private int mInstanceId = -1;

    private native void nativeAllocateMemory(long j, String str, long j2, String str2, String str3);

    private static native long nativeCurrentSystemTimeMicroseconds();

    private native void nativeDeallocateMemory(long j, String str, long j2, String str2, String str3);

    private static native boolean nativeIsMemoryMonitorEnabled();

    private native void nativeSetPaintEndTimingAndHostPlatformTiming(long j, long j2, JavaOnlyMap javaOnlyMap, JavaOnlyArray javaOnlyArray);

    private native void nativeSetTiming(long j, String str, long j2, String str2);

    private native void nativeUpdateMemoryUsage(long j, String str, long j2, int i, Map<String, String> map);

    public void setEmbeddedMode(boolean z) {
        this.mUseEmbeddedMode = z;
    }

    public boolean isEmbeddedMode() {
        return this.mUseEmbeddedMode;
    }

    private void ensureEmbeddedCollectorInitialized() {
        if (isEmbeddedMode() && this.mEmbeddedTimingCollector == null) {
            EmbeddedTimingCollector embeddedTimingCollector = new EmbeddedTimingCollector();
            this.mEmbeddedTimingCollector = embeddedTimingCollector;
            embeddedTimingCollector.setObserver(this.mObserver);
        }
    }

    public static boolean isMemoryMonitorEnabled() {
        LynxBooleanOption lynxBooleanOption;
        if (!isNativeLibraryLoaded() || (lynxBooleanOption = sIsMemoryMonitorEnabled) == LynxBooleanOption.FALSE) {
            return false;
        }
        if (lynxBooleanOption != LynxBooleanOption.UNSET) {
            return true;
        }
        boolean nativeIsMemoryMonitorEnabled = nativeIsMemoryMonitorEnabled();
        sIsMemoryMonitorEnabled = nativeIsMemoryMonitorEnabled ? LynxBooleanOption.TRUE : LynxBooleanOption.FALSE;
        return nativeIsMemoryMonitorEnabled;
    }

    public static long getMemoryAcquisitionDelaySec() {
        if (sMemoryAcquisitionDelaySec >= 0) {
            return sMemoryAcquisitionDelaySec;
        }
        String memoryAcquisitionDelaySec = LynxEnv.inst().getMemoryAcquisitionDelaySec();
        long j = 2;
        if (memoryAcquisitionDelaySec == null || memoryAcquisitionDelaySec.isEmpty()) {
            return 2L;
        }
        try {
            j = Long.parseLong(memoryAcquisitionDelaySec);
            sMemoryAcquisitionDelaySec = j;
            return j;
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public void setPerformanceObserver(IPerformanceObserver iPerformanceObserver) {
        WeakReference<IPerformanceObserver> weakReference = new WeakReference<>(iPerformanceObserver);
        this.mObserver = weakReference;
        EmbeddedTimingCollector embeddedTimingCollector = this.mEmbeddedTimingCollector;
        if (embeddedTimingCollector != null) {
            embeddedTimingCollector.setObserver(weakReference);
        }
    }

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }

    @Override // com.lynx.tasm.performance.memory.IMemoryMonitor
    public void allocateMemory(final IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (isEmbeddedMode() || iMemoryRecordBuilder == null) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m13xf343b396(iMemoryRecordBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$allocateMemory$0$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m13xf343b396(IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        MemoryRecord build = iMemoryRecordBuilder.build();
        nativeAllocateMemory(this.mNativePerformanceActorPtr, build.getCategory(), build.mSizeBytes, null, null);
    }

    @Override // com.lynx.tasm.performance.memory.IMemoryMonitor
    public void deallocateMemory(final IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (isEmbeddedMode() || iMemoryRecordBuilder == null) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m14x59ae76d8(iMemoryRecordBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$deallocateMemory$1$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m14x59ae76d8(IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        MemoryRecord build = iMemoryRecordBuilder.build();
        nativeDeallocateMemory(this.mNativePerformanceActorPtr, build.getCategory(), build.mSizeBytes, null, null);
    }

    @Override // com.lynx.tasm.performance.memory.IMemoryMonitor
    public void updateMemoryUsage(final IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (isEmbeddedMode() || iMemoryRecordBuilder == null) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m19xe43331b7(iMemoryRecordBuilder);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateMemoryUsage$2$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m19xe43331b7(IMemoryRecordBuilder iMemoryRecordBuilder) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        MemoryRecord build = iMemoryRecordBuilder.build();
        nativeUpdateMemoryUsage(this.mNativePerformanceActorPtr, build.getCategory(), build.mSizeBytes, build.mInstanceCount, null);
    }

    @Override // com.lynx.tasm.performance.memory.IMemoryMonitor
    public void updateMemoryUsage(final Map<String, MemoryRecord> map) {
        if (isEmbeddedMode() || map == null) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m20xe3bccbb8(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$updateMemoryUsage$3$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m20xe3bccbb8(Map map) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            MemoryRecord memoryRecord = (MemoryRecord) ((Map.Entry) it.next()).getValue();
            if (memoryRecord != null) {
                nativeUpdateMemoryUsage(this.mNativePerformanceActorPtr, memoryRecord.getCategory(), memoryRecord.mSizeBytes, memoryRecord.mInstanceCount, memoryRecord.mDetail);
            }
        }
    }

    @Override // com.lynx.tasm.performance.timing.ITimingCollector
    public void setMsTiming(final String str, final long j, final String str2) {
        if (isEmbeddedMode()) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m18x28decab4(str, j, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setMsTiming$4$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m18x28decab4(String str, long j, String str2) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        nativeSetTiming(this.mNativePerformanceActorPtr, str, j * 1000, str2);
    }

    @Override // com.lynx.tasm.performance.timing.ITimingCollector
    public void markTiming(final String str, final String str2) {
        final long currentSystemTimeMicroseconds = currentSystemTimeMicroseconds();
        makeTraceEventInstant("Timing::Mark", str, currentSystemTimeMicroseconds, str2);
        if (isEmbeddedMode()) {
            ensureEmbeddedCollectorInitialized();
            this.mEmbeddedTimingCollector.markTiming(str, currentSystemTimeMicroseconds);
        } else {
            runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    PerformanceController.this.m16xc316d2b4(str, currentSystemTimeMicroseconds, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$markTiming$5$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m16xc316d2b4(String str, long j, String str2) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        nativeSetTiming(this.mNativePerformanceActorPtr, str, j, str2);
    }

    @Override // com.lynx.tasm.performance.timing.ITimingCollector
    public void markHostPlatformTiming(String str) {
        if (isEmbeddedMode() || !UIThreadUtils.isOnUiThread() || this.mPendingPaintEndPipelineIds.isEmpty() || str == null) {
            return;
        }
        if (this.mHostPlatformTiming != null) {
            if (str.endsWith("Start") && this.mHostPlatformTiming.containsKey(str)) {
                return;
            }
        } else {
            this.mHostPlatformTiming = new JavaOnlyMap();
        }
        long currentSystemTimeMicroseconds = currentSystemTimeMicroseconds();
        makeTraceEventInstants("Timing::MarkHostPlatformTiming", str, currentSystemTimeMicroseconds);
        this.mHostPlatformTiming.put(str, Long.valueOf(currentSystemTimeMicroseconds));
    }

    @Override // com.lynx.tasm.performance.timing.ITimingCollector
    public void markPaintEndTimingIfNeeded() {
        if (isEmbeddedMode()) {
            ensureEmbeddedCollectorInitialized();
            if (!this.mEmbeddedTimingCollector.hasEmitLoadBundleEvent() || this.mEmbeddedTimingCollector.hasPendingUpdateEvent()) {
                long currentSystemTimeMicroseconds = currentSystemTimeMicroseconds();
                makeTraceEventInstant("Timing::Mark", TimingConstants.PAINT_END, currentSystemTimeMicroseconds, "");
                this.mEmbeddedTimingCollector.markTiming(TimingConstants.PAINT_END, currentSystemTimeMicroseconds);
                return;
            }
            return;
        }
        if (!UIThreadUtils.isOnUiThread() || this.mPendingPaintEndPipelineIds.isEmpty()) {
            return;
        }
        final long currentSystemTimeMicroseconds2 = currentSystemTimeMicroseconds();
        makeTraceEventInstants("Timing::Mark", TimingConstants.PAINT_END, currentSystemTimeMicroseconds2);
        final JavaOnlyMap javaOnlyMap = this.mHostPlatformTiming;
        this.mHostPlatformTiming = null;
        final JavaOnlyArray javaOnlyArray = this.mPendingPaintEndPipelineIds;
        this.mPendingPaintEndPipelineIds = new JavaOnlyArray();
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m15x1d504144(currentSystemTimeMicroseconds2, javaOnlyMap, javaOnlyArray);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$markPaintEndTimingIfNeeded$6$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m15x1d504144(long j, JavaOnlyMap javaOnlyMap, JavaOnlyArray javaOnlyArray) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        nativeSetPaintEndTimingAndHostPlatformTiming(this.mNativePerformanceActorPtr, j, javaOnlyMap, javaOnlyArray);
    }

    @Override // com.lynx.tasm.performance.timing.ITimingCollector
    public void setNeedMarkPaintEndTiming(String str) {
        if (isEmbeddedMode() || !UIThreadUtils.isOnUiThread()) {
            return;
        }
        this.mPendingPaintEndPipelineIds.add(str);
    }

    public void setExtraTiming(final TimingHandler.ExtraTimingInfo extraTimingInfo) {
        if (isEmbeddedMode()) {
            return;
        }
        runOnReportThread(new Runnable() { // from class: com.lynx.tasm.performance.PerformanceController$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                PerformanceController.this.m17x277a3737(extraTimingInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setExtraTiming$7$com-lynx-tasm-performance-PerformanceController */
    public /* synthetic */ void m17x277a3737(TimingHandler.ExtraTimingInfo extraTimingInfo) {
        if (this.mNativePerformanceActorPtr == 0) {
            return;
        }
        if (extraTimingInfo.mOpenTime > 0) {
            nativeSetTiming(this.mNativePerformanceActorPtr, "openTime", extraTimingInfo.mOpenTime * 1000, null);
        }
        if (extraTimingInfo.mContainerInitStart > 0) {
            nativeSetTiming(this.mNativePerformanceActorPtr, "containerInitStart", extraTimingInfo.mContainerInitStart * 1000, null);
        }
        if (extraTimingInfo.mContainerInitEnd > 0) {
            nativeSetTiming(this.mNativePerformanceActorPtr, "containerInitEnd", extraTimingInfo.mContainerInitEnd * 1000, null);
        }
        if (extraTimingInfo.mPrepareTemplateStart > 0) {
            nativeSetTiming(this.mNativePerformanceActorPtr, "prepareTemplateStart", extraTimingInfo.mPrepareTemplateStart * 1000, null);
        }
        if (extraTimingInfo.mPrepareTemplateEnd > 0) {
            nativeSetTiming(this.mNativePerformanceActorPtr, "prepareTemplateEnd", extraTimingInfo.mPrepareTemplateEnd * 1000, null);
        }
    }

    protected void setNativePtr(long j) {
        if (isEmbeddedMode()) {
            return;
        }
        this.mNativePerformanceActorPtr = j;
    }

    protected void onPerformanceEvent(ReadableMap readableMap) {
        int i;
        if (isEmbeddedMode()) {
            return;
        }
        IPerformanceObserver iPerformanceObserver = this.mObserver.get();
        PerformanceEntry makePerformanceEntry = PerformanceEntryConverter.makePerformanceEntry(readableMap);
        if (iPerformanceObserver != null) {
            iPerformanceObserver.onPerformanceEvent(makePerformanceEntry);
        }
        ILynxEventReporterService eventReporterService = getEventReporterService();
        if (eventReporterService == null || (i = readableMap.getInt("instanceId", -1)) == -1) {
            return;
        }
        HashMap<String, Object> genericInfoWithExtraParams = LynxEventReporter.getGenericInfoWithExtraParams(Integer.valueOf(i));
        genericInfoWithExtraParams.putAll(readableMap.asHashMap());
        eventReporterService.onPerformanceEvent(PerformanceEntryConverter.makePerformanceEntry(JavaOnlyMap.from(genericInfoWithExtraParams)));
    }

    private void runOnReportThread(Runnable runnable) {
        if (isEmbeddedMode()) {
            return;
        }
        LynxEventReporter.runOnReportThread(runnable);
    }

    private static boolean isNativeLibraryLoaded() {
        if (!sIsNativeLibraryLoaded) {
            sIsNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
        }
        return sIsNativeLibraryLoaded;
    }

    private void makeTraceEventInstants(String str, String str2, long j) {
        if (TraceEvent.isTracingStarted()) {
            Iterator it = this.mPendingPaintEndPipelineIds.iterator();
            while (it.hasNext()) {
                makeTraceEventInstant(str, str2, j, (String) it.next());
            }
        }
    }

    private void makeTraceEventInstant(String str, String str2, long j, String str3) {
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("timing_key", str2);
            hashMap.put(FrescoMonitorConst.TIMESTAMP, String.valueOf(j));
            hashMap.put("pipeline_id", str3);
            hashMap.put(TraceEventDef.INSTANCE_ID, String.valueOf(this.mInstanceId));
            TraceEvent.instant(0L, str + "." + str2, hashMap);
        }
    }

    public static long currentSystemTimeMicroseconds() {
        if (isNativeLibraryLoaded()) {
            return nativeCurrentSystemTimeMicroseconds();
        }
        LLog.e(TAG, "Failed to call currentSystemTimeMicroseconds to obtain the timestamp.");
        return 0L;
    }

    private ILynxEventReporterService getEventReporterService() {
        WeakReference<ILynxEventReporterService> weakReference = this.mEventReporterService;
        if (weakReference != null) {
            return weakReference.get();
        }
        ILynxEventReporterService iLynxEventReporterService = (ILynxEventReporterService) LynxServiceCenter.inst().getService(ILynxEventReporterService.class);
        if (iLynxEventReporterService != null) {
            this.mEventReporterService = new WeakReference<>(iLynxEventReporterService);
        }
        return iLynxEventReporterService;
    }

    public JavaOnlyArray getPendingPaintEndPipelineIds() {
        return this.mPendingPaintEndPipelineIds;
    }
}
