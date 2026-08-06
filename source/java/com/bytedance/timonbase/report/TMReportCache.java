package com.bytedance.timonbase.report;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.account.api.call.BaseApiResponse;
import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.timonbase.TMEnv;
import com.bytedance.timonbase.cache.TMCacheTaskManager;
import com.bytedance.timonbase.report.TMReportCache;
import com.bytedance.timonbase.utils.ProcessUtil;
import com.bytedance.timonbase.utils.TMThreadUtils;
import com.bytedance.tracing.log.Fields;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: TMReportCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001f !B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\u0006\u0010\u001e\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/bytedance/timonbase/report/TMReportCache;", "", "()V", "WHAT_APPEND_API_CALL", "", "WHAT_BASIC_MODE_REPORT", "WHAT_REPORT", "apiCallCache", "", "Lcom/bytedance/timonbase/report/TMReportCache$ApiCallBatch;", "<set-?>", "", "reportApiCallEnable", "getReportApiCallEnable", "()Z", "reportHandler", "Lcom/bytedance/timonbase/report/TMReportCache$ReportHandler;", "getReportHandler", "()Lcom/bytedance/timonbase/report/TMReportCache$ReportHandler;", "reportHandler$delegate", "Lkotlin/Lazy;", "addHitIntercept", "", "id", "addHitReport", "append", Fields.EVENT, "Lcom/bytedance/timonbase/report/TMReportCache$ApiCallEvent;", "appendApiCall", "report", "triggerReport", "ApiCallBatch", "ApiCallEvent", "ReportHandler", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TMReportCache {
    private static final int WHAT_APPEND_API_CALL = 1;
    private static final int WHAT_BASIC_MODE_REPORT = 1001;
    private static final int WHAT_REPORT = 1000;
    public static final TMReportCache INSTANCE = new TMReportCache();

    /* renamed from: reportHandler$delegate, reason: from kotlin metadata */
    private static final Lazy reportHandler = LazyKt.lazy(new Function0<ReportHandler>() { // from class: com.bytedance.timonbase.report.TMReportCache$reportHandler$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final TMReportCache.ReportHandler m1066invoke() {
            Looper looper = TMThreadUtils.INSTANCE.getHandlerThread().getLooper();
            Intrinsics.checkExpressionValueIsNotNull(looper, "TMThreadUtils.handlerThread.looper");
            return new TMReportCache.ReportHandler(looper);
        }
    });
    private static final Map<Integer, ApiCallBatch> apiCallCache = new LinkedHashMap();
    private static volatile boolean reportApiCallEnable = true;

    private final ReportHandler getReportHandler() {
        return (ReportHandler) reportHandler.getValue();
    }

    private TMReportCache() {
    }

    public final boolean getReportApiCallEnable() {
        return reportApiCallEnable;
    }

    public final void append(ApiCallEvent event) {
        Intrinsics.checkParameterIsNotNull(event, Fields.EVENT);
        Message.obtain(getReportHandler(), 1, event).sendToTarget();
    }

    public final void triggerReport() {
        Message.obtain(getReportHandler(), 1000).sendToTarget();
        Message.obtain(getReportHandler(), 1001).sendToTarget();
    }

    public final void addHitReport(int id) {
        ApiCallBatch apiCallBatch = apiCallCache.get(Integer.valueOf(id));
        if (apiCallBatch != null) {
            apiCallBatch.setReportCount(apiCallBatch.getReportCount() + 1);
        }
    }

    public final void addHitIntercept(int id) {
        ApiCallBatch apiCallBatch = apiCallCache.get(Integer.valueOf(id));
        if (apiCallBatch != null) {
            apiCallBatch.setInterceptCount(apiCallBatch.getInterceptCount() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void appendApiCall(ApiCallEvent event) {
        if (event.getHeliosSetup() && event.getRulerSetup()) {
            reportApiCallEnable = false;
        }
        Map<Integer, ApiCallBatch> map = apiCallCache;
        if (!map.containsKey(Integer.valueOf(event.getId()))) {
            map.put(Integer.valueOf(event.getId()), new ApiCallBatch(event.getId(), 0, 0, 0, 0, 0, 0, 0.0f, 0, 0, BaseApiResponse.API_MOBILE_QUEICK_LOGIN_CONTINUE, null));
        }
        ApiCallBatch apiCallBatch = map.get(Integer.valueOf(event.getId()));
        if (apiCallBatch != null) {
            Long cost = event.getCost();
            if (cost != null) {
                cost.longValue();
                if (apiCallBatch.getCount() > 0) {
                    apiCallBatch.setCost((apiCallBatch.getCost() * (apiCallBatch.getCount() / (apiCallBatch.getCount() + 1))) + ((float) (event.getCost().longValue() * (1 / (apiCallBatch.getCount() + 1)))));
                } else {
                    apiCallBatch.setCost((float) event.getCost().longValue());
                }
            }
            if (event.getHeliosSetup()) {
                apiCallBatch.setHeliosSetup(apiCallBatch.getHeliosSetup() + 1);
            }
            if (event.getRulerSetup()) {
                apiCallBatch.setRulerSetup(apiCallBatch.getRulerSetup() + 1);
            }
            if (event.getRulerReady()) {
                apiCallBatch.setRulerReady(apiCallBatch.getRulerReady() + 1);
            }
            if (event.isMainThread()) {
                apiCallBatch.setMainThread(apiCallBatch.isMainThread() + 1);
            }
            if (event.getIntercept()) {
                apiCallBatch.setIntercept(apiCallBatch.getIntercept() + 1);
            }
            apiCallBatch.setCount(apiCallBatch.getCount() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final void report() {
        Map<Integer, ApiCallBatch> map = apiCallCache;
        if (map.isEmpty()) {
            return;
        }
        Iterator<T> it = map.values().iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((ApiCallBatch) it.next()).getCount();
        }
        for (Map.Entry<Integer, ApiCallBatch> entry : apiCallCache.entrySet()) {
            ApiCallBatch value = entry.getValue();
            Application application = TMEnv.INSTANCE.getApplication();
            int isMainProcess = application != null ? ProcessUtil.INSTANCE.isMainProcess(application) : 0;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("api_id", entry.getKey().intValue());
            jSONObject.put("main_process", isMainProcess);
            jSONObject.put("count", value.getCount());
            jSONObject.put("sum_count", i);
            jSONObject.put("helios_setup", value.getHeliosSetup());
            jSONObject.put("ruler_setup", value.getRulerSetup());
            jSONObject.put("ruler_ready", value.getRulerReady());
            jSONObject.put("main_thread", value.isMainThread());
            jSONObject.put("cost", Float.valueOf(value.getCost()));
            jSONObject.put("basicModeEnable", TMEnv.INSTANCE.getBasicModeEnable() ? 1 : 0);
            jSONObject.put("is_intercept", value.getInterceptCount());
            jSONObject.put("hit_report", value.getReportCount());
            TMDataCollector.reportAppLog$default(TMDataCollector.INSTANCE, TMMetric.EVENT_API_CALL, jSONObject, false, null, 12, null);
        }
        apiCallCache.clear();
    }

    /* compiled from: TMReportCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/timonbase/report/TMReportCache$ReportHandler;", "Landroid/os/Handler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class ReportHandler extends Handler {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReportHandler(Looper looper) {
            super(looper);
            Intrinsics.checkParameterIsNotNull(looper, "looper");
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.checkParameterIsNotNull(msg, "msg");
            int i = msg.what;
            if (i == 1) {
                TMReportCache tMReportCache = TMReportCache.INSTANCE;
                Object obj = msg.obj;
                if (obj == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.timonbase.report.TMReportCache.ApiCallEvent");
                }
                tMReportCache.appendApiCall((ApiCallEvent) obj);
                return;
            }
            if (i == 1000) {
                TMReportCache.INSTANCE.report();
            } else {
                if (i != 1001) {
                    return;
                }
                TMCacheTaskManager.INSTANCE.flushCache();
            }
        }
    }

    /* compiled from: TMReportCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jx\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020\u00052\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\t\u0010-\u001a\u00020\u000eHÖ\u0001R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015¨\u0006."}, d2 = {"Lcom/bytedance/timonbase/report/TMReportCache$ApiCallEvent;", "", "id", "", "rulerSetup", "", "heliosSetup", "rulerReady", "isMainThread", "intercept", "cost", "", "isTimonInitialized", "rulerBlockResult", "", "rulerReportResult", "(IZZZZZLjava/lang/Long;ZLjava/lang/String;Ljava/lang/String;)V", "getCost", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHeliosSetup", "()Z", "getId", "()I", "getIntercept", "getRulerBlockResult", "()Ljava/lang/String;", "getRulerReady", "getRulerReportResult", "getRulerSetup", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IZZZZZLjava/lang/Long;ZLjava/lang/String;Ljava/lang/String;)Lcom/bytedance/timonbase/report/TMReportCache$ApiCallEvent;", "equals", "other", "hashCode", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ApiCallEvent {
        private final Long cost;
        private final boolean heliosSetup;
        private final int id;
        private final boolean intercept;
        private final boolean isMainThread;
        private final boolean isTimonInitialized;
        private final String rulerBlockResult;
        private final boolean rulerReady;
        private final String rulerReportResult;
        private final boolean rulerSetup;

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final String getRulerReportResult() {
            return this.rulerReportResult;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getRulerSetup() {
            return this.rulerSetup;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getHeliosSetup() {
            return this.heliosSetup;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getRulerReady() {
            return this.rulerReady;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsMainThread() {
            return this.isMainThread;
        }

        /* renamed from: component6, reason: from getter */
        public final boolean getIntercept() {
            return this.intercept;
        }

        /* renamed from: component7, reason: from getter */
        public final Long getCost() {
            return this.cost;
        }

        /* renamed from: component8, reason: from getter */
        public final boolean getIsTimonInitialized() {
            return this.isTimonInitialized;
        }

        /* renamed from: component9, reason: from getter */
        public final String getRulerBlockResult() {
            return this.rulerBlockResult;
        }

        public final ApiCallEvent copy(int id, boolean rulerSetup, boolean heliosSetup, boolean rulerReady, boolean isMainThread, boolean intercept, Long cost, boolean isTimonInitialized, String rulerBlockResult, String rulerReportResult) {
            return new ApiCallEvent(id, rulerSetup, heliosSetup, rulerReady, isMainThread, intercept, cost, isTimonInitialized, rulerBlockResult, rulerReportResult);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiCallEvent)) {
                return false;
            }
            ApiCallEvent apiCallEvent = (ApiCallEvent) other;
            return this.id == apiCallEvent.id && this.rulerSetup == apiCallEvent.rulerSetup && this.heliosSetup == apiCallEvent.heliosSetup && this.rulerReady == apiCallEvent.rulerReady && this.isMainThread == apiCallEvent.isMainThread && this.intercept == apiCallEvent.intercept && Intrinsics.areEqual(this.cost, apiCallEvent.cost) && this.isTimonInitialized == apiCallEvent.isTimonInitialized && Intrinsics.areEqual(this.rulerBlockResult, apiCallEvent.rulerBlockResult) && Intrinsics.areEqual(this.rulerReportResult, apiCallEvent.rulerReportResult);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = Integer.hashCode(this.id) * 31;
            boolean z = this.rulerSetup;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.heliosSetup;
            int i3 = z2;
            if (z2 != 0) {
                i3 = 1;
            }
            int i4 = (i2 + i3) * 31;
            boolean z3 = this.rulerReady;
            int i5 = z3;
            if (z3 != 0) {
                i5 = 1;
            }
            int i6 = (i4 + i5) * 31;
            boolean z4 = this.isMainThread;
            int i7 = z4;
            if (z4 != 0) {
                i7 = 1;
            }
            int i8 = (i6 + i7) * 31;
            boolean z5 = this.intercept;
            int i9 = z5;
            if (z5 != 0) {
                i9 = 1;
            }
            int i10 = (i8 + i9) * 31;
            Long l = this.cost;
            int hashCode2 = (i10 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z6 = this.isTimonInitialized;
            int i11 = (hashCode2 + (z6 ? 1 : z6 ? 1 : 0)) * 31;
            String str = this.rulerBlockResult;
            int hashCode3 = (i11 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.rulerReportResult;
            return hashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ApiCallEvent(id=" + this.id + ", rulerSetup=" + this.rulerSetup + ", heliosSetup=" + this.heliosSetup + ", rulerReady=" + this.rulerReady + ", isMainThread=" + this.isMainThread + ", intercept=" + this.intercept + ", cost=" + this.cost + ", isTimonInitialized=" + this.isTimonInitialized + ", rulerBlockResult=" + this.rulerBlockResult + ", rulerReportResult=" + this.rulerReportResult + ")";
        }

        public ApiCallEvent(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Long l, boolean z6, String str, String str2) {
            this.id = i;
            this.rulerSetup = z;
            this.heliosSetup = z2;
            this.rulerReady = z3;
            this.isMainThread = z4;
            this.intercept = z5;
            this.cost = l;
            this.isTimonInitialized = z6;
            this.rulerBlockResult = str;
            this.rulerReportResult = str2;
        }

        public final int getId() {
            return this.id;
        }

        public final boolean getRulerSetup() {
            return this.rulerSetup;
        }

        public final boolean getHeliosSetup() {
            return this.heliosSetup;
        }

        public final boolean getRulerReady() {
            return this.rulerReady;
        }

        public final boolean isMainThread() {
            return this.isMainThread;
        }

        public final boolean getIntercept() {
            return this.intercept;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ ApiCallEvent(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Long l, boolean z6, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, z, z2, z3, z4, z5, r10, z6, r12, r13);
            Long l2;
            String str3;
            String str4;
            if ((i2 & 64) != 0) {
                l2 = null;
            } else {
                l2 = l;
            }
            if ((i2 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0) {
                str3 = null;
            } else {
                str3 = str;
            }
            if ((i2 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
        }

        public final Long getCost() {
            return this.cost;
        }

        public final boolean isTimonInitialized() {
            return this.isTimonInitialized;
        }

        public final String getRulerBlockResult() {
            return this.rulerBlockResult;
        }

        public final String getRulerReportResult() {
            return this.rulerReportResult;
        }
    }

    /* compiled from: TMReportCache.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003Jm\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u0003HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0014\"\u0004\b$\u0010\u0016¨\u00066"}, d2 = {"Lcom/bytedance/timonbase/report/TMReportCache$ApiCallBatch;", "", "id", "", "count", "rulerSetup", "heliosSetup", "rulerReady", "isMainThread", "intercept", "cost", "", "interceptCount", "reportCount", "(IIIIIIIFII)V", "getCost", "()F", "setCost", "(F)V", "getCount", "()I", "setCount", "(I)V", "getHeliosSetup", "setHeliosSetup", "getId", "getIntercept", "setIntercept", "getInterceptCount", "setInterceptCount", "setMainThread", "getReportCount", "setReportCount", "getRulerReady", "setRulerReady", "getRulerSetup", "setRulerSetup", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class ApiCallBatch {
        private float cost;
        private int count;
        private int heliosSetup;
        private final int id;
        private int intercept;
        private int interceptCount;
        private int isMainThread;
        private int reportCount;
        private int rulerReady;
        private int rulerSetup;

        /* renamed from: component1, reason: from getter */
        public final int getId() {
            return this.id;
        }

        /* renamed from: component10, reason: from getter */
        public final int getReportCount() {
            return this.reportCount;
        }

        /* renamed from: component2, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRulerSetup() {
            return this.rulerSetup;
        }

        /* renamed from: component4, reason: from getter */
        public final int getHeliosSetup() {
            return this.heliosSetup;
        }

        /* renamed from: component5, reason: from getter */
        public final int getRulerReady() {
            return this.rulerReady;
        }

        /* renamed from: component6, reason: from getter */
        public final int getIsMainThread() {
            return this.isMainThread;
        }

        /* renamed from: component7, reason: from getter */
        public final int getIntercept() {
            return this.intercept;
        }

        /* renamed from: component8, reason: from getter */
        public final float getCost() {
            return this.cost;
        }

        /* renamed from: component9, reason: from getter */
        public final int getInterceptCount() {
            return this.interceptCount;
        }

        public final ApiCallBatch copy(int id, int count, int rulerSetup, int heliosSetup, int rulerReady, int isMainThread, int intercept, float cost, int interceptCount, int reportCount) {
            return new ApiCallBatch(id, count, rulerSetup, heliosSetup, rulerReady, isMainThread, intercept, cost, interceptCount, reportCount);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiCallBatch)) {
                return false;
            }
            ApiCallBatch apiCallBatch = (ApiCallBatch) other;
            return this.id == apiCallBatch.id && this.count == apiCallBatch.count && this.rulerSetup == apiCallBatch.rulerSetup && this.heliosSetup == apiCallBatch.heliosSetup && this.rulerReady == apiCallBatch.rulerReady && this.isMainThread == apiCallBatch.isMainThread && this.intercept == apiCallBatch.intercept && Float.compare(this.cost, apiCallBatch.cost) == 0 && this.interceptCount == apiCallBatch.interceptCount && this.reportCount == apiCallBatch.reportCount;
        }

        public int hashCode() {
            return (((((((((((((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.rulerSetup)) * 31) + Integer.hashCode(this.heliosSetup)) * 31) + Integer.hashCode(this.rulerReady)) * 31) + Integer.hashCode(this.isMainThread)) * 31) + Integer.hashCode(this.intercept)) * 31) + Float.hashCode(this.cost)) * 31) + Integer.hashCode(this.interceptCount)) * 31) + Integer.hashCode(this.reportCount);
        }

        public String toString() {
            return "ApiCallBatch(id=" + this.id + ", count=" + this.count + ", rulerSetup=" + this.rulerSetup + ", heliosSetup=" + this.heliosSetup + ", rulerReady=" + this.rulerReady + ", isMainThread=" + this.isMainThread + ", intercept=" + this.intercept + ", cost=" + this.cost + ", interceptCount=" + this.interceptCount + ", reportCount=" + this.reportCount + ")";
        }

        public ApiCallBatch(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9) {
            this.id = i;
            this.count = i2;
            this.rulerSetup = i3;
            this.heliosSetup = i4;
            this.rulerReady = i5;
            this.isMainThread = i6;
            this.intercept = i7;
            this.cost = f;
            this.interceptCount = i8;
            this.reportCount = i9;
        }

        public final int getId() {
            return this.id;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public final int getRulerSetup() {
            return this.rulerSetup;
        }

        public final void setRulerSetup(int i) {
            this.rulerSetup = i;
        }

        public final int getHeliosSetup() {
            return this.heliosSetup;
        }

        public final void setHeliosSetup(int i) {
            this.heliosSetup = i;
        }

        public final int getRulerReady() {
            return this.rulerReady;
        }

        public final void setRulerReady(int i) {
            this.rulerReady = i;
        }

        public final int isMainThread() {
            return this.isMainThread;
        }

        public final void setMainThread(int i) {
            this.isMainThread = i;
        }

        public final int getIntercept() {
            return this.intercept;
        }

        public final void setIntercept(int i) {
            this.intercept = i;
        }

        public final float getCost() {
            return this.cost;
        }

        public final void setCost(float f) {
            this.cost = f;
        }

        public final int getInterceptCount() {
            return this.interceptCount;
        }

        public final void setInterceptCount(int i) {
            this.interceptCount = i;
        }

        public /* synthetic */ ApiCallBatch(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, (i10 & 2) != 0 ? 0 : i2, (i10 & 4) != 0 ? 0 : i3, (i10 & 8) != 0 ? 0 : i4, (i10 & 16) != 0 ? 0 : i5, (i10 & 32) != 0 ? 0 : i6, (i10 & 64) != 0 ? 0 : i7, (i10 & 128) != 0 ? 0.0f : f, (i10 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? 0 : i8, (i10 & StatusBarUtils.FLAG_NOTCH_PORTRAIT) == 0 ? i9 : 0);
        }

        public final int getReportCount() {
            return this.reportCount;
        }

        public final void setReportCount(int i) {
            this.reportCount = i;
        }
    }
}
