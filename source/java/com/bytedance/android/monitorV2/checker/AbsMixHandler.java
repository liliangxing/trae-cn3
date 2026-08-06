package com.bytedance.android.monitorV2.checker;

import android.net.Uri;
import com.bytedance.android.monitorV2.constant.MonitorConstant;
import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.JsonAccessor;
import com.bytedance.android.monitorV2.webview.constant.WebViewMonitorConstant;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.forest.model.Timing;
import com.bytedance.forest.pollyfill.CDNFetchDepender;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: PerfMixHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J\u001a\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010$2\u0006\u0010&\u001a\u00020\u0015H\u0004J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0004J\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020$J\u0010\u0010,\u001a\u00020(2\u0006\u0010!\u001a\u00020\"H&J\u0016\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020$J\u0018\u00100\u001a\u00020(2\u0006\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020$H&R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R!\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0018j\b\u0012\u0004\u0012\u00020\u0015`\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u000eX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u00062"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/AbsMixHandler;", "", "()V", MonitorConstant.BLANK_ALL_ELEMENTS, "", "Lcom/bytedance/android/monitorV2/checker/AbsMixHandler$SubPerf;", "getElements", "()Ljava/util/List;", "firstElement", "getFirstElement", "()Lcom/bytedance/android/monitorV2/checker/AbsMixHandler$SubPerf;", "setFirstElement", "(Lcom/bytedance/android/monitorV2/checker/AbsMixHandler$SubPerf;)V", "limit", "", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "requestJsbFilter", "", "", "getRequestJsbFilter", "resTypeFilter", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getResTypeFilter", "()Ljava/util/HashSet;", "topN", "getTopN", "()I", "canHandle", "", "accessor", "Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "createNewResDur", "Lorg/json/JSONObject;", "sourceDur", "resType", "decreaseAdd", "", "data", "handle", "nativeInfo", "realHandle", "result", "fmpEnd", "", "settle", "SubPerf", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbsMixHandler {
    private final List<SubPerf> elements;
    private SubPerf firstElement;
    private final Object lock;
    private final int limit = 10;
    private final int topN = 3;
    private final HashSet<String> resTypeFilter = SetsKt.hashSetOf(new String[]{CDNFetchDepender.DEFAULT_EXTENSION, PreloadConfig.KEY_STYLESHEET});
    private final List<String> requestJsbFilter = CollectionsKt.listOf(new String[]{"fetch", "x.request", "__prefetch"});

    public abstract boolean canHandle(JsonAccessor accessor);

    public abstract void realHandle(JsonAccessor accessor);

    public abstract void settle(long fmpEnd, JSONObject result);

    public AbsMixHandler() {
        List<SubPerf> synchronizedList = Collections.synchronizedList(new ArrayList());
        Intrinsics.checkNotNullExpressionValue(synchronizedList, "synchronizedList(ArrayList<SubPerf>())");
        this.elements = synchronizedList;
        this.lock = new Object();
    }

    public final int getTopN() {
        return this.topN;
    }

    public final HashSet<String> getResTypeFilter() {
        return this.resTypeFilter;
    }

    public final List<String> getRequestJsbFilter() {
        return this.requestJsbFilter;
    }

    public final SubPerf getFirstElement() {
        return this.firstElement;
    }

    public final void setFirstElement(SubPerf subPerf) {
        this.firstElement = subPerf;
    }

    public final List<SubPerf> getElements() {
        return this.elements;
    }

    public final Object getLock() {
        return this.lock;
    }

    public final void handle(JSONObject nativeInfo) {
        Intrinsics.checkNotNullParameter(nativeInfo, "nativeInfo");
        synchronized (this.lock) {
            JsonAccessor jsonAccessor = new JsonAccessor(nativeInfo);
            if (canHandle(jsonAccessor)) {
                realHandle(jsonAccessor);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void result(long fmpEnd, JSONObject result) {
        Object obj;
        Intrinsics.checkNotNullParameter(result, "result");
        try {
            Result.Companion companion = Result.Companion;
            AbsMixHandler absMixHandler = this;
            synchronized (this.lock) {
                CollectionsKt.sort(this.elements);
                settle(fmpEnd, result);
                Unit unit = Unit.INSTANCE;
            }
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            MonitorLog.m27e("PerfMixHandler", "result error: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b1 A[Catch: all -> 0x0115, TryCatch #0 {all -> 0x0115, blocks: (B:25:0x0090, B:27:0x00a5, B:32:0x00b1, B:34:0x00b8, B:35:0x00c4, B:37:0x00dd, B:38:0x0110, B:45:0x00e8), top: B:24:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject createNewResDur(JSONObject sourceDur, String resType) {
        Object obj;
        String path;
        String str;
        boolean z;
        String str2;
        Intrinsics.checkNotNullParameter(resType, "resType");
        JSONObject optJSONObject = sourceDur != null ? sourceDur.optJSONObject("res_info") : null;
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = sourceDur != null ? sourceDur.optJSONObject("res_load_perf") : null;
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        JSONObject optJSONObject3 = sourceDur != null ? sourceDur.optJSONObject("res_loader_info") : null;
        if (optJSONObject3 == null) {
            optJSONObject3 = new JSONObject();
        }
        JSONObject jSONObject = optJSONObject3;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("is_memory", optJSONObject.optBoolean("is_memory") ? 1 : 0);
        jSONObject2.put("is_preload", optJSONObject.optBoolean("is_preload") ? 1 : 0);
        jSONObject2.put("is_preloaded", optJSONObject.optBoolean("is_preloaded") ? 1 : 0);
        jSONObject2.put(WebViewMonitorConstant.Web.RES_FROM, optJSONObject.optString(WebViewMonitorConstant.Web.RES_FROM));
        jSONObject2.put(WebViewMonitorConstant.Web.RES_SIZE, optJSONObject.optLong(WebViewMonitorConstant.Web.RES_SIZE));
        if (Intrinsics.areEqual(resType, PerfMixHandler.RES_TEMPLATE_DUR)) {
            jSONObject2.put("res_src", optJSONObject.optString("res_src"));
        } else if (Intrinsics.areEqual(resType, PerfMixHandler.SUB_RES_DUR)) {
            try {
                Result.Companion companion = Result.Companion;
                path = Uri.parse(optJSONObject.optString("res_src")).getPath();
                str = path;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (str != null && str.length() != 0) {
                z = false;
                if (!z) {
                    if (StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                        path = path.subSequence(1, path.length()).toString();
                    }
                    List split$default = StringsKt.split$default(path, new String[]{"/"}, false, 0, 6, (Object) null);
                    int size = split$default.size();
                    if (size == 1) {
                        str2 = String.valueOf(split$default.get(0));
                    } else if (size > 1) {
                        str2 = ((String) split$default.get(size - 2)) + '/' + ((String) split$default.get(size - 1));
                    }
                    obj = Result.constructor-impl(str2);
                    jSONObject2.put("res_src", (String) (Result.isFailure-impl(obj) ? "" : obj));
                }
                str2 = "";
                obj = Result.constructor-impl(str2);
                jSONObject2.put("res_src", (String) (Result.isFailure-impl(obj) ? "" : obj));
            }
            z = true;
            if (!z) {
            }
            str2 = "";
            obj = Result.constructor-impl(str2);
            jSONObject2.put("res_src", (String) (Result.isFailure-impl(obj) ? "" : obj));
        }
        jSONObject2.put("res_version", String.valueOf(optJSONObject.optLong("res_version")));
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(Timing.RES_LOAD_START, optJSONObject2.optLong(Timing.RES_LOAD_START));
        jSONObject3.put(Timing.RES_LOAD_FINISH, optJSONObject2.optLong(Timing.RES_LOAD_FINISH));
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("res_loader_name", jSONObject.optString("res_loader_name"));
        JSONObject jSONObject5 = new JSONObject();
        jSONObject5.put("res_info", jSONObject2);
        jSONObject5.put("res_load_perf", jSONObject3);
        jSONObject5.put("res_loader_info", jSONObject4);
        return jSONObject5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void decreaseAdd(SubPerf data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.firstElement == null) {
            this.firstElement = data;
            Unit unit = Unit.INSTANCE;
        }
        if (this.elements.size() < this.limit) {
            this.elements.add(data);
        }
    }

    /* compiled from: PerfMixHandler.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/monitorV2/checker/AbsMixHandler$SubPerf;", "", "cost", "", "data", "Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "(JLcom/bytedance/android/monitorV2/util/JsonAccessor;)V", "getCost", "()J", "getData", "()Lcom/bytedance/android/monitorV2/util/JsonAccessor;", "compareTo", "", PreloadConfig.KEY_OTHER, "component1", "component2", "copy", "equals", "", "", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final /* data */ class SubPerf implements Comparable<SubPerf> {
        private final long cost;
        private final JsonAccessor data;

        public static /* synthetic */ SubPerf copy$default(SubPerf subPerf, long j, JsonAccessor jsonAccessor, int i, Object obj) {
            if ((i & 1) != 0) {
                j = subPerf.cost;
            }
            if ((i & 2) != 0) {
                jsonAccessor = subPerf.data;
            }
            return subPerf.copy(j, jsonAccessor);
        }

        /* renamed from: component1, reason: from getter */
        public final long getCost() {
            return this.cost;
        }

        /* renamed from: component2, reason: from getter */
        public final JsonAccessor getData() {
            return this.data;
        }

        public final SubPerf copy(long cost, JsonAccessor data) {
            Intrinsics.checkNotNullParameter(data, "data");
            return new SubPerf(cost, data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SubPerf)) {
                return false;
            }
            SubPerf subPerf = (SubPerf) other;
            return this.cost == subPerf.cost && Intrinsics.areEqual(this.data, subPerf.data);
        }

        public int hashCode() {
            return (Long.hashCode(this.cost) * 31) + this.data.hashCode();
        }

        public String toString() {
            return "SubPerf(cost=" + this.cost + ", data=" + this.data + ')';
        }

        public SubPerf(long j, JsonAccessor jsonAccessor) {
            Intrinsics.checkNotNullParameter(jsonAccessor, "data");
            this.cost = j;
            this.data = jsonAccessor;
        }

        public final long getCost() {
            return this.cost;
        }

        public final JsonAccessor getData() {
            return this.data;
        }

        @Override // java.lang.Comparable
        public int compareTo(SubPerf other) {
            Intrinsics.checkNotNullParameter(other, PreloadConfig.KEY_OTHER);
            return ((int) other.cost) - ((int) this.cost);
        }
    }
}
