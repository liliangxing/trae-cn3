package com.bytedance.lynx.service.reporter.performance;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;
import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.lynx.service.reporter.LynxEventReporterService;
import com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageGlobalReporter;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import com.google.gson.Gson;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.performance.performanceobserver.MemoryUsageEntry;
import com.lynx.tasm.performance.performanceobserver.MemoryUsageItem;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: LynxMemoryUsageGlobalReporter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010%\n\u0002\b\u0006\b\u0017\u0018\u0000 C2\u00020\u0001:\u0002CDB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0002J\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\"2\u0006\u0010#\u001a\u00020\bJ\b\u0010$\u001a\u00020\nH\u0002J\u0015\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\bH\u0000¢\u0006\u0002\b'J\u0015\u0010(\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\bH\u0000¢\u0006\u0002\b)J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\bH\u0002J\u0015\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020\bH\u0000¢\u0006\u0002\b/J\u001d\u00100\u001a\u00020\n2\u0006\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0000¢\u0006\u0002\b1J\u001d\u00102\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020\bH\u0000¢\u0006\u0002\b3J\u0018\u00104\u001a\u00020\u001e2\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u0019H\u0002J\u0010\u00107\u001a\u00020\u001e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J \u00108\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001cJ\u0015\u00109\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\bH\u0010¢\u0006\u0002\b:J\u001d\u0010;\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b<J,\u0010=\u001a\u00020\u001e2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070?2\u0006\u0010&\u001a\u00020\b2\u0006\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u001eH\u0002J\"\u0010B\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u001cH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageGlobalReporter;", "", "()V", "context", "Landroid/content/Context;", "instanceIdToURLMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "lastReportTotalBytes", "", LynxMemoryUsageGlobalReporter.KEY_LYNX_VIEW_COUNT, LynxMemoryUsageGlobalReporter.KEY_REPORT_THRESHOLD_BYTES, "getReportThresholdBytes", "()J", "reportThresholdBytes$delegate", "Lkotlin/Lazy;", "sharedGroupIdToBytes", "sharedGroupIdToInstanceCount", "startTime", LynxMemoryUsageGlobalReporter.TRIGGER_TIMER, "Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryReportTimer;", LynxMemoryUsageGlobalReporter.KEY_TOTAL_BYTES, "totalSharedBytes", "urlToInfoMap", "Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageGlobalReporter$LynxURLMemoryInfo;", "btsEngineSizeBytes", "entry", "Lcom/lynx/tasm/performance/performanceobserver/MemoryUsageEntry;", "clearInstance", "", "instanceId", "lastEntry", "generateReportBody", "", LynxMemoryUsageGlobalReporter.KEY_TRIGGER_MODE, "getAppMemoryUsage", "getGlobalSharedGroupBytes", LynxMemoryUsageGlobalReporter.KEY_GROUP_ID, "getGlobalSharedGroupBytes$LynxService_release", "getGlobalSharedGroupInstanceCount", "getGlobalSharedGroupInstanceCount$LynxService_release", "getOrCreateUrlInfoForUrl", "url", "getUrlInfoInstanceCount", "getUrlInfoInstanceCount$LynxService_release", "getUrlInfoTotalBytes", "getUrlInfoTotalBytes$LynxService_release", "getUrlSharedGroupBytes", "getUrlSharedGroupBytes$LynxService_release", "getUrlSharedGroupInstanceCount", "getUrlSharedGroupInstanceCount$LynxService_release", "mergeUrlInfo", "target", EventConstants.PARAM_SOURCE, "onInitialize", "processMemoryUsageEntry", "reportWithTriggerMode", "reportWithTriggerMode$LynxService_release", "resolveUrlForInstance", "resolveUrlForInstance$LynxService_release", "sharedCount", "map", "", "delta", "startTimerIfNeeded", "updateWithEntry", "Companion", "LynxURLMemoryInfo", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class LynxMemoryUsageGlobalReporter {
    private static final String CATEGORY_BTS_ENGINE = "backgroundThreadScriptingEngine";
    private static final String KEY_APP_BYTES = "appBytes";
    private static final String KEY_DETAIL = "detail";
    private static final String KEY_GROUP_ID = "groupId";
    private static final String KEY_LYNX_VIEW_COUNT = "lynxViewCount";
    private static final String KEY_LYNX_VIEW_MEMORY_RATIO = "lynxViewMemoryRatio";
    private static final String KEY_PAGE_ID = "page_id";
    private static final String KEY_REPORT_THRESHOLD_BYTES = "reportThresholdBytes";
    private static final String KEY_SHARED_BTS_ENGINE_GROUP_COUNT = "sharedBTSEngineGroupCount";
    private static final String KEY_SHARED_BTS_ENGINE_SIZE = "sharedBTSEngineSize";
    private static final String KEY_SURVIVAL_DURATION_SEC = "timerSurvivalDurationSec";
    private static final String KEY_TIMER_INTERVAL = "timerReportIntervalSec";
    private static final String KEY_TOTAL_BYTES = "totalBytes";
    private static final String KEY_TRIGGER_MODE = "triggerMode";
    private static final String KEY_URL = "url";
    private static final String REPORT_EVENT_NAME = "lynxsdk_memory_usage";
    private static final String TRIGGER_THRESHOLD = "threshold";
    private static final String TRIGGER_TIMER = "timer";
    private static final String UNKNOWN_PAGE_ID = "unknown";
    private static final String UNKNOWN_URL_PREFIX = "unknown_url_";
    private Context context;
    private volatile long lastReportTotalBytes;
    private volatile int lynxViewCount;
    private LynxMemoryReportTimer timer;
    private volatile long totalBytes;
    private volatile long totalSharedBytes;
    private final ConcurrentHashMap<Integer, String> instanceIdToURLMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, LynxURLMemoryInfo> urlToInfoMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Long> sharedGroupIdToBytes = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> sharedGroupIdToInstanceCount = new ConcurrentHashMap<>();

    /* renamed from: reportThresholdBytes$delegate, reason: from kotlin metadata */
    private final Lazy reportThresholdBytes = LazyKt.lazy(new Function0<Long>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageGlobalReporter$reportThresholdBytes$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Long m711invoke() {
            return Long.valueOf(LynxEnv.inst().getGlobalMemoryReportThresholdMB() * 1024 * 1024);
        }
    });
    private final long startTime = System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LynxMemoryUsageGlobalReporter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0002\u0010\fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\nHÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\nHÆ\u0003J]\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/bytedance/lynx/service/reporter/performance/LynxMemoryUsageGlobalReporter$LynxURLMemoryInfo;", "", "url", "", LynxMemoryUsageGlobalReporter.KEY_TOTAL_BYTES, "", "totalSharedBytes", "instanceCount", "", "sharedGroupIdToBytes", "", "sharedGroupIdToInstanceCount", "(Ljava/lang/String;JJILjava/util/Map;Ljava/util/Map;)V", "getInstanceCount", "()I", "setInstanceCount", "(I)V", "getSharedGroupIdToBytes", "()Ljava/util/Map;", "getSharedGroupIdToInstanceCount", "getTotalBytes", "()J", "setTotalBytes", "(J)V", "getTotalSharedBytes", "setTotalSharedBytes", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "LynxService_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class LynxURLMemoryInfo {
        private int instanceCount;
        private final Map<String, Long> sharedGroupIdToBytes;
        private final Map<String, Integer> sharedGroupIdToInstanceCount;
        private long totalBytes;
        private long totalSharedBytes;
        private String url;

        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTotalBytes() {
            return this.totalBytes;
        }

        /* renamed from: component3, reason: from getter */
        public final long getTotalSharedBytes() {
            return this.totalSharedBytes;
        }

        /* renamed from: component4, reason: from getter */
        public final int getInstanceCount() {
            return this.instanceCount;
        }

        public final Map<String, Long> component5() {
            return this.sharedGroupIdToBytes;
        }

        public final Map<String, Integer> component6() {
            return this.sharedGroupIdToInstanceCount;
        }

        public final LynxURLMemoryInfo copy(String url, long totalBytes, long totalSharedBytes, int instanceCount, Map<String, Long> sharedGroupIdToBytes, Map<String, Integer> sharedGroupIdToInstanceCount) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(sharedGroupIdToBytes, "sharedGroupIdToBytes");
            Intrinsics.checkNotNullParameter(sharedGroupIdToInstanceCount, "sharedGroupIdToInstanceCount");
            return new LynxURLMemoryInfo(url, totalBytes, totalSharedBytes, instanceCount, sharedGroupIdToBytes, sharedGroupIdToInstanceCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LynxURLMemoryInfo)) {
                return false;
            }
            LynxURLMemoryInfo lynxURLMemoryInfo = (LynxURLMemoryInfo) other;
            return Intrinsics.areEqual(this.url, lynxURLMemoryInfo.url) && this.totalBytes == lynxURLMemoryInfo.totalBytes && this.totalSharedBytes == lynxURLMemoryInfo.totalSharedBytes && this.instanceCount == lynxURLMemoryInfo.instanceCount && Intrinsics.areEqual(this.sharedGroupIdToBytes, lynxURLMemoryInfo.sharedGroupIdToBytes) && Intrinsics.areEqual(this.sharedGroupIdToInstanceCount, lynxURLMemoryInfo.sharedGroupIdToInstanceCount);
        }

        public int hashCode() {
            return (((((((((this.url.hashCode() * 31) + Long.hashCode(this.totalBytes)) * 31) + Long.hashCode(this.totalSharedBytes)) * 31) + Integer.hashCode(this.instanceCount)) * 31) + this.sharedGroupIdToBytes.hashCode()) * 31) + this.sharedGroupIdToInstanceCount.hashCode();
        }

        public String toString() {
            return "LynxURLMemoryInfo(url=" + this.url + ", totalBytes=" + this.totalBytes + ", totalSharedBytes=" + this.totalSharedBytes + ", instanceCount=" + this.instanceCount + ", sharedGroupIdToBytes=" + this.sharedGroupIdToBytes + ", sharedGroupIdToInstanceCount=" + this.sharedGroupIdToInstanceCount + ')';
        }

        public LynxURLMemoryInfo(String str, long j, long j2, int i, Map<String, Long> map, Map<String, Integer> map2) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(map, "sharedGroupIdToBytes");
            Intrinsics.checkNotNullParameter(map2, "sharedGroupIdToInstanceCount");
            this.url = str;
            this.totalBytes = j;
            this.totalSharedBytes = j2;
            this.instanceCount = i;
            this.sharedGroupIdToBytes = map;
            this.sharedGroupIdToInstanceCount = map2;
        }

        public final String getUrl() {
            return this.url;
        }

        public final void setUrl(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.url = str;
        }

        public final long getTotalBytes() {
            return this.totalBytes;
        }

        public final void setTotalBytes(long j) {
            this.totalBytes = j;
        }

        public final long getTotalSharedBytes() {
            return this.totalSharedBytes;
        }

        public final void setTotalSharedBytes(long j) {
            this.totalSharedBytes = j;
        }

        public final int getInstanceCount() {
            return this.instanceCount;
        }

        public final void setInstanceCount(int i) {
            this.instanceCount = i;
        }

        public /* synthetic */ LynxURLMemoryInfo(String str, long j, long j2, int i, Map map, Map map2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? j2 : 0L, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? new LinkedHashMap() : map, (i2 & 32) != 0 ? new LinkedHashMap() : map2);
        }

        public final Map<String, Long> getSharedGroupIdToBytes() {
            return this.sharedGroupIdToBytes;
        }

        public final Map<String, Integer> getSharedGroupIdToInstanceCount() {
            return this.sharedGroupIdToInstanceCount;
        }
    }

    public final long getReportThresholdBytes() {
        return ((Number) this.reportThresholdBytes.getValue()).longValue();
    }

    public final void onInitialize(Context context) {
        this.context = context;
    }

    public final void processMemoryUsageEntry(MemoryUsageEntry entry, int instanceId, MemoryUsageEntry lastEntry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        startTimerIfNeeded();
        if (entry.sizeBytes == 0) {
            clearInstance(instanceId, lastEntry);
        } else {
            updateWithEntry(entry, instanceId, lastEntry);
        }
        if (Math.abs(this.totalBytes - this.lastReportTotalBytes) >= getReportThresholdBytes()) {
            reportWithTriggerMode$LynxService_release(TRIGGER_THRESHOLD);
        }
    }

    private final void updateWithEntry(MemoryUsageEntry entry, int instanceId, MemoryUsageEntry lastEntry) {
        long j;
        long j2;
        HashMap hashMap;
        MemoryUsageItem memoryUsageItem;
        HashMap hashMap2;
        HashMap hashMap3;
        LynxURLMemoryInfo orCreateUrlInfoForUrl = getOrCreateUrlInfoForUrl(resolveUrlForInstance$LynxService_release(instanceId, entry));
        if (lastEntry == null) {
            orCreateUrlInfoForUrl.setInstanceCount(orCreateUrlInfoForUrl.getInstanceCount() + 1);
            this.lynxViewCount++;
        }
        long j3 = entry.sizeBytes;
        long j4 = lastEntry != null ? lastEntry.sizeBytes : 0L;
        HashMap hashMap4 = entry.detail;
        MemoryUsageItem memoryUsageItem2 = hashMap4 != null ? (MemoryUsageItem) hashMap4.get(CATEGORY_BTS_ENGINE) : null;
        String str = (memoryUsageItem2 == null || (hashMap3 = memoryUsageItem2.detail) == null) ? null : (String) hashMap3.get(KEY_GROUP_ID);
        if (!(str instanceof String)) {
            str = null;
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            j2 = j3 - j4;
            j = j2;
        } else {
            String str3 = (lastEntry == null || (hashMap = lastEntry.detail) == null || (memoryUsageItem = (MemoryUsageItem) hashMap.get(CATEGORY_BTS_ENGINE)) == null || (hashMap2 = memoryUsageItem.detail) == null) ? null : (String) hashMap2.get(KEY_GROUP_ID);
            if ((str3 instanceof String ? str3 : null) == null) {
                sharedCount(orCreateUrlInfoForUrl.getSharedGroupIdToInstanceCount(), str, 1);
                sharedCount(this.sharedGroupIdToInstanceCount, str, 1);
            }
            Intrinsics.checkNotNull(memoryUsageItem2);
            long j5 = memoryUsageItem2.sizeBytes;
            long btsEngineSizeBytes = (j3 - j5) - (j4 - (lastEntry != null ? btsEngineSizeBytes(lastEntry) : 0L));
            Long l = orCreateUrlInfoForUrl.getSharedGroupIdToBytes().get(str);
            long longValue = j5 - (l != null ? l.longValue() : 0L);
            long j6 = btsEngineSizeBytes + longValue;
            orCreateUrlInfoForUrl.getSharedGroupIdToBytes().put(str, Long.valueOf(j5));
            orCreateUrlInfoForUrl.setTotalSharedBytes(longValue + orCreateUrlInfoForUrl.getTotalSharedBytes());
            Long l2 = this.sharedGroupIdToBytes.get(str);
            if (l2 == null) {
                l2 = 0L;
            }
            long longValue2 = j5 - l2.longValue();
            this.sharedGroupIdToBytes.put(str, Long.valueOf(j5));
            this.totalSharedBytes += longValue2;
            j = btsEngineSizeBytes + longValue2;
            j2 = j6;
        }
        orCreateUrlInfoForUrl.setTotalBytes(orCreateUrlInfoForUrl.getTotalBytes() + j2);
        this.totalBytes += j;
    }

    private final void clearInstance(int instanceId, MemoryUsageEntry lastEntry) {
        LynxURLMemoryInfo lynxURLMemoryInfo;
        long j;
        HashMap hashMap;
        if (lastEntry == null) {
            return;
        }
        String str = this.instanceIdToURLMap.get(Integer.valueOf(instanceId));
        if (str != null && (lynxURLMemoryInfo = this.urlToInfoMap.get(str)) != null) {
            lynxURLMemoryInfo.setInstanceCount(lynxURLMemoryInfo.getInstanceCount() - 1);
            this.lynxViewCount--;
            long j2 = lastEntry.sizeBytes;
            MemoryUsageItem memoryUsageItem = (MemoryUsageItem) lastEntry.detail.get(CATEGORY_BTS_ENGINE);
            String str2 = (memoryUsageItem == null || (hashMap = memoryUsageItem.detail) == null) ? null : (String) hashMap.get(KEY_GROUP_ID);
            String str3 = str2 instanceof String ? str2 : null;
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                j = j2;
            } else {
                Intrinsics.checkNotNull(memoryUsageItem);
                long j3 = j2 - memoryUsageItem.sizeBytes;
                Integer num = lynxURLMemoryInfo.getSharedGroupIdToInstanceCount().get(str3);
                int intValue = (num != null ? num.intValue() : 0) - 1;
                if (intValue <= 0) {
                    Long l = lynxURLMemoryInfo.getSharedGroupIdToBytes().get(str3);
                    long longValue = l != null ? l.longValue() : 0L;
                    j3 += longValue;
                    lynxURLMemoryInfo.getSharedGroupIdToBytes().remove(str3);
                    lynxURLMemoryInfo.getSharedGroupIdToInstanceCount().remove(str3);
                    lynxURLMemoryInfo.setTotalSharedBytes(lynxURLMemoryInfo.getTotalSharedBytes() - longValue);
                } else {
                    lynxURLMemoryInfo.getSharedGroupIdToInstanceCount().put(str3, Integer.valueOf(intValue));
                }
                long j4 = j2 - memoryUsageItem.sizeBytes;
                Integer num2 = this.sharedGroupIdToInstanceCount.get(str3);
                if (num2 == null) {
                    num2 = 0;
                }
                int intValue2 = num2.intValue() - 1;
                if (intValue2 <= 0) {
                    Long l2 = this.sharedGroupIdToBytes.get(str3);
                    if (l2 == null) {
                        l2 = 0L;
                    }
                    long longValue2 = l2.longValue();
                    j4 += longValue2;
                    this.sharedGroupIdToBytes.remove(str3);
                    this.sharedGroupIdToInstanceCount.remove(str3);
                    this.totalSharedBytes -= longValue2;
                } else {
                    this.sharedGroupIdToInstanceCount.put(str3, Integer.valueOf(intValue2));
                }
                j = j4;
                j2 = j3;
            }
            lynxURLMemoryInfo.setTotalBytes(lynxURLMemoryInfo.getTotalBytes() - j2);
            this.totalBytes -= j;
            if (lynxURLMemoryInfo.getInstanceCount() <= 0) {
                this.urlToInfoMap.remove(str);
            }
        }
        this.instanceIdToURLMap.remove(Integer.valueOf(instanceId));
    }

    private final long btsEngineSizeBytes(MemoryUsageEntry entry) {
        MemoryUsageItem memoryUsageItem = (MemoryUsageItem) entry.detail.get(CATEGORY_BTS_ENGINE);
        if (memoryUsageItem == null) {
            return 0L;
        }
        return memoryUsageItem.sizeBytes;
    }

    private final void sharedCount(Map<String, Integer> map, String groupId, int delta) {
        Integer num = map.get(groupId);
        map.put(groupId, Integer.valueOf((num != null ? num.intValue() : 0) + delta));
    }

    private final void mergeUrlInfo(LynxURLMemoryInfo target, LynxURLMemoryInfo source) {
        target.setTotalBytes(target.getTotalBytes() + source.getTotalBytes());
        target.setInstanceCount(target.getInstanceCount() + source.getInstanceCount());
        for (Map.Entry<String, Long> entry : source.getSharedGroupIdToBytes().entrySet()) {
            String key = entry.getKey();
            long longValue = entry.getValue().longValue();
            if (target.getSharedGroupIdToBytes().containsKey(key)) {
                target.setTotalBytes(target.getTotalBytes() - longValue);
            } else {
                target.getSharedGroupIdToBytes().put(key, Long.valueOf(longValue));
                target.setTotalSharedBytes(target.getTotalSharedBytes() + longValue);
            }
        }
        for (Map.Entry<String, Integer> entry2 : source.getSharedGroupIdToInstanceCount().entrySet()) {
            String key2 = entry2.getKey();
            int intValue = entry2.getValue().intValue();
            Map<String, Integer> sharedGroupIdToInstanceCount = target.getSharedGroupIdToInstanceCount();
            Integer num = target.getSharedGroupIdToInstanceCount().get(key2);
            sharedGroupIdToInstanceCount.put(key2, Integer.valueOf((num != null ? num.intValue() : 0) + intValue));
        }
    }

    public final String resolveUrlForInstance$LynxService_release(int instanceId, MemoryUsageEntry entry) {
        LynxURLMemoryInfo lynxURLMemoryInfo;
        Intrinsics.checkNotNullParameter(entry, "entry");
        String str = this.instanceIdToURLMap.get(Integer.valueOf(instanceId));
        String str2 = str;
        boolean z = true;
        if (!(str2 == null || str2.length() == 0) && !StringsKt.startsWith$default(str, UNKNOWN_URL_PREFIX, false, 2, (Object) null)) {
            return str;
        }
        Object obj = entry.rawMap.get(KEY_PAGE_ID);
        String str3 = obj instanceof String ? (String) obj : null;
        String str4 = str3;
        if ((str4 == null || str4.length() == 0) || Intrinsics.areEqual(str3, "unknown")) {
            Object obj2 = entry.rawMap.get("url");
            String str5 = obj2 instanceof String ? (String) obj2 : null;
            String str6 = str5;
            str3 = !(str6 == null || str6.length() == 0) ? LynxPerformanceReportProcessorUtils.INSTANCE.formatPath(str5) : null;
        }
        String str7 = str3;
        if (!(str7 == null || str7.length() == 0)) {
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (!z && StringsKt.startsWith$default(str, UNKNOWN_URL_PREFIX, false, 2, (Object) null) && (lynxURLMemoryInfo = this.urlToInfoMap.get(str)) != null) {
                this.urlToInfoMap.remove(str);
                LynxURLMemoryInfo lynxURLMemoryInfo2 = this.urlToInfoMap.get(str3);
                if (lynxURLMemoryInfo2 != null) {
                    mergeUrlInfo(lynxURLMemoryInfo2, lynxURLMemoryInfo);
                } else {
                    Intrinsics.checkNotNull(str3);
                    lynxURLMemoryInfo.setUrl(str3);
                    this.urlToInfoMap.put(str3, lynxURLMemoryInfo);
                }
            }
            Integer valueOf = Integer.valueOf(instanceId);
            ConcurrentHashMap<Integer, String> concurrentHashMap = this.instanceIdToURLMap;
            Intrinsics.checkNotNull(str3);
            concurrentHashMap.put(valueOf, str3);
            return str3;
        }
        if (str2 != null && str2.length() != 0) {
            z = false;
        }
        if (!z) {
            return str;
        }
        String str8 = UNKNOWN_URL_PREFIX + instanceId;
        this.instanceIdToURLMap.put(Integer.valueOf(instanceId), str8);
        return str8;
    }

    private final LynxURLMemoryInfo getOrCreateUrlInfoForUrl(String url) {
        LynxURLMemoryInfo putIfAbsent;
        ConcurrentHashMap<String, LynxURLMemoryInfo> concurrentHashMap = this.urlToInfoMap;
        LynxURLMemoryInfo lynxURLMemoryInfo = concurrentHashMap.get(url);
        if (lynxURLMemoryInfo == null && (putIfAbsent = concurrentHashMap.putIfAbsent(url, (lynxURLMemoryInfo = new LynxURLMemoryInfo(url, 0L, 0L, 0, null, null, 62, null)))) != null) {
            lynxURLMemoryInfo = putIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(lynxURLMemoryInfo, "urlToInfoMap.getOrPut(ur… LynxURLMemoryInfo(url) }");
        return lynxURLMemoryInfo;
    }

    public final long getUrlInfoTotalBytes$LynxService_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        LynxURLMemoryInfo lynxURLMemoryInfo = this.urlToInfoMap.get(url);
        if (lynxURLMemoryInfo != null) {
            return lynxURLMemoryInfo.getTotalBytes();
        }
        return 0L;
    }

    public final int getUrlInfoInstanceCount$LynxService_release(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        LynxURLMemoryInfo lynxURLMemoryInfo = this.urlToInfoMap.get(url);
        if (lynxURLMemoryInfo != null) {
            return lynxURLMemoryInfo.getInstanceCount();
        }
        return 0;
    }

    public final long getUrlSharedGroupBytes$LynxService_release(String url, String groupId) {
        Map<String, Long> sharedGroupIdToBytes;
        Long l;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(groupId, KEY_GROUP_ID);
        LynxURLMemoryInfo lynxURLMemoryInfo = this.urlToInfoMap.get(url);
        if (lynxURLMemoryInfo == null || (sharedGroupIdToBytes = lynxURLMemoryInfo.getSharedGroupIdToBytes()) == null || (l = sharedGroupIdToBytes.get(groupId)) == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final int getUrlSharedGroupInstanceCount$LynxService_release(String url, String groupId) {
        Map<String, Integer> sharedGroupIdToInstanceCount;
        Integer num;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(groupId, KEY_GROUP_ID);
        LynxURLMemoryInfo lynxURLMemoryInfo = this.urlToInfoMap.get(url);
        if (lynxURLMemoryInfo == null || (sharedGroupIdToInstanceCount = lynxURLMemoryInfo.getSharedGroupIdToInstanceCount()) == null || (num = sharedGroupIdToInstanceCount.get(groupId)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public final long getGlobalSharedGroupBytes$LynxService_release(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, KEY_GROUP_ID);
        Long l = this.sharedGroupIdToBytes.get(groupId);
        if (l == null) {
            return 0L;
        }
        return l.longValue();
    }

    public final int getGlobalSharedGroupInstanceCount$LynxService_release(String groupId) {
        Intrinsics.checkNotNullParameter(groupId, KEY_GROUP_ID);
        Integer num = this.sharedGroupIdToInstanceCount.get(groupId);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public void reportWithTriggerMode$LynxService_release(String triggerMode) {
        Intrinsics.checkNotNullParameter(triggerMode, KEY_TRIGGER_MODE);
        AppLogNewUtils.onEventV3(REPORT_EVENT_NAME, LynxEventReporterService.INSTANCE.convertBooleanToInt(new JSONObject(generateReportBody(triggerMode))));
        this.lastReportTotalBytes = this.totalBytes;
    }

    public final Map<String, Object> generateReportBody(String triggerMode) {
        Intrinsics.checkNotNullParameter(triggerMode, KEY_TRIGGER_MODE);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(KEY_TOTAL_BYTES, Long.valueOf(this.totalBytes));
        linkedHashMap.put(KEY_LYNX_VIEW_COUNT, Integer.valueOf(this.lynxViewCount));
        linkedHashMap.put(KEY_SHARED_BTS_ENGINE_GROUP_COUNT, Integer.valueOf(this.sharedGroupIdToInstanceCount.size()));
        linkedHashMap.put(KEY_SHARED_BTS_ENGINE_SIZE, Long.valueOf(this.totalSharedBytes));
        long appMemoryUsage = getAppMemoryUsage();
        linkedHashMap.put(KEY_APP_BYTES, Long.valueOf(appMemoryUsage));
        Double valueOf = Double.valueOf(0.0d);
        if (appMemoryUsage > 0) {
            linkedHashMap.put(KEY_LYNX_VIEW_MEMORY_RATIO, Double.valueOf(this.totalBytes / appMemoryUsage));
        } else {
            linkedHashMap.put(KEY_LYNX_VIEW_MEMORY_RATIO, valueOf);
        }
        linkedHashMap.put(KEY_TIMER_INTERVAL, Long.valueOf(LynxMemoryReportTimer.INSTANCE.getReportIntervalSec()));
        linkedHashMap.put(KEY_SURVIVAL_DURATION_SEC, Long.valueOf((System.currentTimeMillis() / BytePatchException.ErrorCode.paramsError) - this.startTime));
        linkedHashMap.put(KEY_REPORT_THRESHOLD_BYTES, Long.valueOf(getReportThresholdBytes()));
        linkedHashMap.put(KEY_TRIGGER_MODE, triggerMode);
        Collection<LynxURLMemoryInfo> values = this.urlToInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "urlToInfoMap.values");
        List sortedWith = CollectionsKt.sortedWith(values, new Comparator() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageGlobalReporter$generateReportBody$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((LynxMemoryUsageGlobalReporter.LynxURLMemoryInfo) t2).getTotalBytes()), Long.valueOf(((LynxMemoryUsageGlobalReporter.LynxURLMemoryInfo) t).getTotalBytes()));
            }
        });
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i = 0;
        for (Object obj : sortedWith) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            LynxURLMemoryInfo lynxURLMemoryInfo = (LynxURLMemoryInfo) obj;
            if (i2 <= 20) {
                linkedHashMap.put("top" + i2 + "Bytes", Long.valueOf(lynxURLMemoryInfo.getTotalBytes()));
                linkedHashMap.put("top" + i2 + "Url", lynxURLMemoryInfo.getUrl());
                linkedHashMap.put("top" + i2 + "LynxViewCount", Integer.valueOf(lynxURLMemoryInfo.getInstanceCount()));
                linkedHashMap.put("top" + i2 + "SharedBTSEngineGroupCount", Integer.valueOf(lynxURLMemoryInfo.getSharedGroupIdToInstanceCount().size()));
                linkedHashMap.put("top" + i2 + "SharedBTSEngineSize", Long.valueOf(lynxURLMemoryInfo.getTotalSharedBytes()));
                if (appMemoryUsage > 0) {
                    linkedHashMap.put("top" + i2 + "MemoryRatio", Double.valueOf(lynxURLMemoryInfo.getTotalBytes() / appMemoryUsage));
                } else {
                    linkedHashMap.put("top" + i2 + "MemoryRatio", valueOf);
                }
            } else {
                linkedHashMap2.put(lynxURLMemoryInfo.getUrl(), Long.valueOf(lynxURLMemoryInfo.getTotalBytes()));
            }
            i = i2;
        }
        if (!linkedHashMap2.isEmpty()) {
            try {
                String json = new Gson().toJson(linkedHashMap2);
                Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(detailDict)");
                linkedHashMap.put(KEY_DETAIL, json);
            } catch (Exception unused) {
            }
        }
        return linkedHashMap;
    }

    private final long getAppMemoryUsage() {
        try {
            Context context = this.context;
            if (context == null) {
                return 0L;
            }
            Object systemService = context.getSystemService("activity");
            ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
            if (activityManager == null) {
                return 0L;
            }
            Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            Intrinsics.checkNotNullExpressionValue(processMemoryInfo, "memoryInfo");
            if (true ^ (processMemoryInfo.length == 0)) {
                return processMemoryInfo[0].getTotalPss() * 1024;
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    private final void startTimerIfNeeded() {
        if (this.timer == null) {
            this.timer = LynxMemoryReportTimer.INSTANCE.startWithInstanceId(-1, new Function3<Long, Integer, Long, Unit>() { // from class: com.bytedance.lynx.service.reporter.performance.LynxMemoryUsageGlobalReporter$startTimerIfNeeded$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke(((Number) obj).longValue(), ((Number) obj2).intValue(), ((Number) obj3).longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j, int i, long j2) {
                    LynxMemoryUsageGlobalReporter.this.reportWithTriggerMode$LynxService_release("timer");
                }
            });
        }
    }
}
