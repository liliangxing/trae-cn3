package com.bytedance.lynx.service.reporter.performance;

import android.content.Context;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.Npth;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.performance.performanceobserver.MemoryUsageEntry;
import com.lynx.tasm.performance.performanceobserver.MemoryUsageItem;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import com.ss.android.common.lib.AppLogNewUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LynxMemoryUsageProcessor.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001cH\u0002¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0019H\u0016J\u001e\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J.\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00172\u0014\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020$\u0018\u00010#H\u0002J\u0010\u0010)\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageProcessor;", "Lcom/bytedance/lynx/service/reporter/performance/ILynxPerformanceReportProcessor;", "()V", "allEntries", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/lynx/tasm/performance/performanceobserver/MemoryUsageEntry;", "allTimers", "Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryReportTimer;", "enable", "", "getEnable", "()Z", "enable$delegate", "Lkotlin/Lazy;", "globalReporter", "Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageGlobalReporter;", "getGlobalReporter", "()Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageGlobalReporter;", "globalReporter$delegate", "hasSetCustomFilter", "Ljava/util/concurrent/atomic/AtomicReference;", "jsonDataRef", "", "processorContext", "Landroid/content/Context;", "canProcess", "entry", "Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;", "getInstanceId", "(Lcom/lynx/tasm/performance/performanceobserver/PerformanceEntry;)Ljava/lang/Integer;", "onInitialize", "", "context", "processPerformanceEntry", "", "", "report", LynxMemoryUsageProcessor.KEY_INSTANCE_ID, "stage", "props", "startTimer", "stopTimer", "Companion", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxMemoryUsageProcessor implements ILynxPerformanceReportProcessor {
    private static final String CATEGORY_BTS_ENGINE = "backgroundThreadScriptingEngine";
    private static final String ENABLE_LYNX_MEMORY_MONITOR = "enableLynxMemoryMonitor";
    private static final String ENTRY_NAME_LOAD_BUNDLE = "loadBundle";
    private static final String ENTRY_TYPE_MEMORY = "memory";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_GROUP_ID = "groupId";
    private static final String KEY_INSTANCE_ID = "instanceId";
    private static final String KEY_LYNX_VIEW_COUNT = "lynxViewCount";
    private static final String KEY_REPORT_INTERVAL_SEC = "timerReportIntervalSec";
    private static final String KEY_SIZE_BYTES = "sizeBytes";
    private static final String KEY_STAGE = "stage";
    private static final String KEY_SURVIVAL_DURATION_SEC = "lynxViewSurvivalDurationSec";
    private static final String KEY_TOTAL_SIZE_BYTES = "totalSizeBytes";
    private static final String KEY_TRIGGER_COUNT = "timerTriggerCount";
    private static final String KEY_URL = "url";
    private static final String LYNX_SDK_MONITOR_TAG = "LynxSDKMonitor";
    private static final String REPORT_EVENT_NAME = "lynxsdk_performance_entry_memory";
    private static final String STAGE_ACTUAL_FMP = "actualFmp";
    private static final String STAGE_FCP = "fcp";
    private static final String STAGE_TIMER = "timer";
    private static final String TAG = "LynxMemoryUsageProcessor";
    private Context processorContext;
    private final ConcurrentHashMap<Integer, MemoryUsageEntry> allEntries = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, LynxMemoryReportTimer> allTimers = new ConcurrentHashMap<>();
    private final AtomicReference<String> jsonDataRef = new AtomicReference<>(null);
    private final AtomicReference<Boolean> hasSetCustomFilter = new AtomicReference<>(false);

    /* renamed from: globalReporter$delegate, reason: from kotlin metadata */
    private final Lazy globalReporter = LazyKt.lazy(new Function0<LynxMemoryUsageGlobalReporter>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor$globalReporter$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final LynxMemoryUsageGlobalReporter m715invoke() {
            Context context;
            LynxMemoryUsageGlobalReporter lynxMemoryUsageGlobalReporter = new LynxMemoryUsageGlobalReporter();
            context = LynxMemoryUsageProcessor.this.processorContext;
            lynxMemoryUsageGlobalReporter.onInitialize(context);
            return lynxMemoryUsageGlobalReporter;
        }
    });

    /* renamed from: enable$delegate, reason: from kotlin metadata */
    private final Lazy enable = LazyKt.lazy(new Function0<Boolean>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor$enable$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Boolean m714invoke() {
            return LynxEnv.inst().getEnableMemoryMonitor();
        }
    });

    public LynxMemoryUsageProcessor() {
        Npth.addAttachLongUserData(new AttachUserData() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor$$ExternalSyntheticLambda0
            public final Map getUserData(CrashType crashType) {
                Map m713_init_$lambda0;
                m713_init_$lambda0 = LynxMemoryUsageProcessor.m713_init_$lambda0(LynxMemoryUsageProcessor.this, crashType);
                return m713_init_$lambda0;
            }
        }, CrashType.ALL);
    }

    private final LynxMemoryUsageGlobalReporter getGlobalReporter() {
        return (LynxMemoryUsageGlobalReporter) this.globalReporter.getValue();
    }

    private final boolean getEnable() {
        Object value = this.enable.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-enable>(...)");
        return ((Boolean) value).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-0, reason: not valid java name */
    public static final Map m713_init_$lambda0(LynxMemoryUsageProcessor lynxMemoryUsageProcessor, CrashType crashType) {
        Intrinsics.checkNotNullParameter(lynxMemoryUsageProcessor, "this$0");
        String str = lynxMemoryUsageProcessor.jsonDataRef.get();
        if (str == null) {
            str = "Unknown";
        }
        return MapsKt.mapOf(TuplesKt.to("LynxSDKMemoryUsage", str));
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public void onInitialize(Context context) {
        ILynxPerformanceReportProcessor.DefaultImpls.onInitialize(this, context);
        this.processorContext = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0038  */
    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean canProcess(PerformanceEntry entry) {
        Integer instanceId;
        Integer instanceId2;
        Intrinsics.checkNotNullParameter(entry, "entry");
        getEnable();
        String str = entry.name;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != -701686520) {
                if (hashCode != 101203) {
                    instanceId2 = getInstanceId(entry);
                    if (instanceId2 != null) {
                        int intValue = instanceId2.intValue();
                        String str2 = entry.name;
                        Intrinsics.checkNotNullExpressionValue(str2, "entry.name");
                        report(intValue, str2, null);
                    }
                } else {
                    instanceId2 = getInstanceId(entry);
                    if (instanceId2 != null) {
                    }
                }
            } else if (str.equals("loadBundle") && (instanceId = getInstanceId(entry)) != null) {
                startTimer(instanceId.intValue());
            }
        }
        return Intrinsics.areEqual(entry.entryType, "memory");
    }

    @Override // com.bytedance.lynx.service.reporter.performance.ILynxPerformanceReportProcessor
    public Map<String, Object> processPerformanceEntry(PerformanceEntry entry) {
        Integer instanceId;
        String str;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if ((entry instanceof MemoryUsageEntry) && (instanceId = getInstanceId(entry)) != null) {
            int intValue = instanceId.intValue();
            MemoryUsageEntry memoryUsageEntry = (MemoryUsageEntry) entry;
            getGlobalReporter().processMemoryUsageEntry(memoryUsageEntry, intValue, this.allEntries.get(Integer.valueOf(intValue)));
            long j = 0;
            if (memoryUsageEntry.sizeBytes == 0) {
                this.allEntries.remove(Integer.valueOf(intValue));
                stopTimer(intValue);
            } else {
                this.allEntries.put(Integer.valueOf(intValue), entry);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Collection<MemoryUsageEntry> values = this.allEntries.values();
            Intrinsics.checkNotNullExpressionValue(values, "allEntries.values");
            for (MemoryUsageEntry memoryUsageEntry2 : values) {
                long j2 = memoryUsageEntry2.sizeBytes;
                MemoryUsageItem memoryUsageItem = (MemoryUsageItem) memoryUsageEntry2.detail.get(CATEGORY_BTS_ENGINE);
                if (memoryUsageItem != null && (str = (String) memoryUsageItem.detail.get(KEY_GROUP_ID)) != null) {
                    if (linkedHashSet.contains(str)) {
                        j2 -= memoryUsageItem.sizeBytes;
                    } else {
                        linkedHashSet.add(str);
                    }
                }
                Object obj = memoryUsageEntry2.rawMap.get("url");
                String str2 = obj instanceof String ? (String) obj : null;
                if (str2 != null) {
                    linkedHashMap.put(str2, new JSONObject(memoryUsageEntry2.rawMap));
                    j += j2;
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(KEY_SIZE_BYTES, j);
                jSONObject.put(KEY_LYNX_VIEW_COUNT, linkedHashMap.size());
                jSONObject.put(KEY_DETAIL, new JSONObject(linkedHashMap));
                LLog.i(LYNX_SDK_MONITOR_TAG, "LynxSDKMemoryUsage - totalSizeBytes: " + j + ", lynxViewCount: " + linkedHashMap.size());
                String str3 = "LynxSDKMemoryUsage - detail: " + jSONObject;
                this.jsonDataRef.set(str3);
                LLog.i(LYNX_SDK_MONITOR_TAG, str3);
                if (!this.hasSetCustomFilter.get().booleanValue()) {
                    this.hasSetCustomFilter.set(true);
                    Npth.addTag(ENABLE_LYNX_MEMORY_MONITOR, RouterConstants.TRUE);
                }
            } catch (JSONException e) {
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                LLog.e(TAG, message);
            }
        }
        return null;
    }

    private final Integer getInstanceId(PerformanceEntry entry) {
        Object obj = entry.rawMap.get(KEY_INSTANCE_ID);
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        return null;
    }

    private final void startTimer(final int instanceId) {
        if (this.allTimers.containsKey(Integer.valueOf(instanceId))) {
            return;
        }
        final WeakReference weakReference = new WeakReference(this);
        LynxMemoryReportTimer startWithInstanceId = LynxMemoryReportTimer.INSTANCE.startWithInstanceId(instanceId, new Function3<Long, Integer, Long, Unit>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageProcessor$startTimer$timer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke(((Number) obj).longValue(), ((Number) obj2).intValue(), ((Number) obj3).longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j, int i, long j2) {
                LynxMemoryUsageProcessor lynxMemoryUsageProcessor = weakReference.get();
                if (lynxMemoryUsageProcessor != null) {
                    lynxMemoryUsageProcessor.report(instanceId, "timer", MapsKt.mapOf(new Pair[]{TuplesKt.to("lynxViewSurvivalDurationSec", Long.valueOf(j2)), TuplesKt.to("timerReportIntervalSec", Long.valueOf(j)), TuplesKt.to("timerTriggerCount", Integer.valueOf(i))}));
                }
            }
        });
        this.allTimers.put(Integer.valueOf(instanceId), startWithInstanceId);
    }

    private final void stopTimer(int instanceId) {
        LynxMemoryReportTimer remove = this.allTimers.remove(Integer.valueOf(instanceId));
        if (remove != null) {
            remove.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(int instanceId, String stage, Map<String, ? extends Object> props) {
        MemoryUsageEntry memoryUsageEntry = this.allEntries.get(Integer.valueOf(instanceId));
        if (memoryUsageEntry == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_TOTAL_SIZE_BYTES, Long.valueOf(memoryUsageEntry.sizeBytes));
        linkedHashMap.put("stage", stage);
        HashMap hashMap = memoryUsageEntry.detail;
        Intrinsics.checkNotNullExpressionValue(hashMap, "entry.detail");
        for (Map.Entry entry : hashMap.entrySet()) {
            linkedHashMap.put(((String) entry.getKey()) + "SizeBytes", Long.valueOf(((MemoryUsageItem) entry.getValue()).sizeBytes));
        }
        HashMap hashMap2 = memoryUsageEntry.rawMap;
        if (hashMap2 != null) {
            linkedHashMap.putAll(hashMap2);
        }
        if (props != null) {
            linkedHashMap.putAll(props);
        }
        AppLogNewUtils.onEventV3(REPORT_EVENT_NAME, LynxEventReporterService.INSTANCE.convertBooleanToInt(new JSONObject(linkedHashMap)));
    }
}
