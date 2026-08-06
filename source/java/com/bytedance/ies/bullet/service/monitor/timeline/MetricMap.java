package com.bytedance.ies.bullet.service.monitor.timeline;

import android.util.Log;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.api.LogLevel;
import com.bytedance.ies.bullet.service.monitor.utils.JsonUtilsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MetricMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ \u0010\f\u001a\u00020\u00062\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000eJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001d\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0015J\u001d\u0010\u0016\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ies/bullet/service/monitor/timeline/MetricMap;", "", "()V", "mMap", "Lorg/json/JSONObject;", "addJson", "", "jsonObject", "contains", "", "key", "", "forEach", "handler", "Lkotlin/Function2;", "", "get", "getJson", "hasKey", "record", "metric", "(Ljava/lang/String;Ljava/lang/Long;)V", "recordWithOverride", "remove", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class MetricMap {
    public static final String moduleName = "Monitor-Timeline";
    private final JSONObject mMap = new JSONObject();

    public final void record(String key, Long metric) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.mMap.optLong(key) != 0) {
            BulletLogger.INSTANCE.printLog("redundancy record: " + key + ", " + metric, LogLevel.W, moduleName);
        } else {
            recordWithOverride(key, metric);
        }
    }

    public final void recordWithOverride(String key, Long metric) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (metric == null) {
            BulletLogger.INSTANCE.printLog("record with null metric: " + key + ", " + metric, LogLevel.W, moduleName);
            return;
        }
        Log.i(moduleName, "record " + key + ", " + metric);
        try {
            this.mMap.put(key, metric.longValue());
        } catch (Exception e) {
            BulletLogger.INSTANCE.printLog("record exception: key=" + key + ", msg=" + e.getMessage(), LogLevel.W, moduleName);
        }
    }

    public long get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        long optLong = this.mMap.optLong(key);
        if (optLong != 0) {
            return optLong;
        }
        BulletLogger.INSTANCE.printLog("get null metric: " + key, LogLevel.W, moduleName);
        return -1L;
    }

    public final boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mMap.optLong(key) != 0;
    }

    public final void remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.mMap.remove(key);
    }

    public final void forEach(Function2<? super String, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Iterator<String> keys = this.mMap.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "mMap.keys()");
        while (keys.hasNext()) {
            String key = keys.next();
            Intrinsics.checkNotNullExpressionValue(key, "key");
            handler.invoke(key, Long.valueOf(get(key)));
        }
    }

    public final void addJson(JSONObject jsonObject) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        JsonUtilsKt.wrap(getMMap(), jsonObject);
    }

    /* renamed from: getJson, reason: from getter */
    public final JSONObject getMMap() {
        return this.mMap;
    }

    public final boolean hasKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.mMap.has(key);
    }
}
