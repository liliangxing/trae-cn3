package com.bytedance.rts.foundation;

import com.bytedance.ies.bullet.kit.resourceloader.monitor.RLMonitorReporter;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.monitor.MetricConstant;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: Json.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/rts/foundation/JsonHelper;", "", "()V", "Companion", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class JsonHelper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: Json.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u0006J&\u0010\t\u001a\u00020\n2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u00072\u0006\u0010\b\u001a\u00020\u0006J.\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\fj\b\u0012\u0004\u0012\u00020\u0006`\r2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u0007J\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u00102\u0006\u0010\u0011\u001a\u00020\u0006J0\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u00102\u0006\u0010\b\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001J\u001e\u0010\u0015\u001a\u00020\u00062\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u0010J.\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u00072\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u0010J.\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u0007JF\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u00102\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u00102\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u0010JF\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u00072\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005j\u0002`\u00072\u0016\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u0010¨\u0006\u001b"}, d2 = {"Lcom/bytedance/rts/foundation/JsonHelper$Companion;", "", "()V", PrefetchRequestConfig.METHOD_GET, "json", "", "", "Lcom/bytedance/rts/foundation/ImmutableJson;", "key", "has", "", "keys", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", RLMonitorReporter.PARSE, "", "Lcom/bytedance/rts/foundation/Json;", "jsonStr", "set", "", "value", "stringify", "toImmutable", "toMutable", MetricConstant.MONITOR_STAGE_UPDATE, "data", "updateImmutable", "lib_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.rts.foundation.JsonHelper$Companion$parse$mapType$1] */
        public final Map<String, Object> parse(String jsonStr) {
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            Object fromJson = new Gson().fromJson(jsonStr, new TypeToken<Map<String, Object>>() { // from class: com.bytedance.rts.foundation.JsonHelper$Companion$parse$mapType$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(jsonStr, mapType)");
            return (Map) fromJson;
        }

        public final String stringify(Map<String, Object> json) {
            Intrinsics.checkNotNullParameter(json, "json");
            String json2 = new Gson().toJson(json);
            Intrinsics.checkNotNullExpressionValue(json2, "Gson().toJson(json)");
            return json2;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.bytedance.rts.foundation.JsonHelper$Companion$toMutable$mapType$1] */
        public final Map<String, Object> toMutable(Map<String, ? extends Object> json) {
            Intrinsics.checkNotNullParameter(json, "json");
            Object fromJson = new Gson().fromJson(new Gson().toJson(json), new TypeToken<Map<String, Object>>() { // from class: com.bytedance.rts.foundation.JsonHelper$Companion$toMutable$mapType$1
            }.getType());
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(jsonStr, mapType)");
            return (Map) fromJson;
        }

        public final Map<String, Object> toImmutable(Map<String, Object> json) {
            Intrinsics.checkNotNullParameter(json, "json");
            TypeIntrinsics.isMutableMap(json);
            return json;
        }

        public final Map<String, Object> updateImmutable(Map<String, ? extends Object> json, Map<String, Object> data) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(data, "data");
            return MapsKt.plus(json, data);
        }

        public final Map<String, Object> update(Map<String, Object> json, Map<String, Object> data) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(data, "data");
            json.putAll(data);
            return json;
        }

        public final boolean has(Map<String, ? extends Object> json, String key) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            return json.containsKey(key);
        }

        public final Object get(Map<String, ? extends Object> json, String key) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            return json.get(key);
        }

        public final ArrayList<String> keys(Map<String, ? extends Object> json) {
            Intrinsics.checkNotNullParameter(json, "json");
            return new ArrayList<>(json.keySet());
        }

        public final void set(Map<String, Object> json, String key, Object value) {
            Intrinsics.checkNotNullParameter(json, "json");
            Intrinsics.checkNotNullParameter(key, "key");
            if (value == null) {
                json.remove(key);
            } else {
                json.put(key, value);
            }
        }
    }
}
