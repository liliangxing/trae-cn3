package com.bytedance.rts.foundation;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.bdturing.methods.JsCallParser;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RTSMap.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a.\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b\u001a?\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u00032\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\f\u001aj\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u000326\u0010\u000f\u001a2\u0012\u0013\u0012\u0011H\b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e0\u0010\u001a?\u0010\u0014\u001a\u00020\n\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u00032\u0006\u0010\u000b\u001a\u0002H\u0007¢\u0006\u0002\u0010\f\u001aB\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u0002H\u00070\u0016j\b\u0012\u0004\u0012\u0002H\u0007`\u0017\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u0003\u001ac\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u0003\"\u0004\b\u0000\u0010\u0007\"\u0004\b\u0001\u0010\b*\u001e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002j\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b`\u00032\u0006\u0010\u000b\u001a\u0002H\u00072\u0006\u0010\u0013\u001a\u0002H\b¢\u0006\u0002\u0010\u0019\")\u0010\u0000\u001a\u00020\u0001*\u0016\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002j\n\u0012\u0002\b\u0003\u0012\u0002\b\u0003`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005*.\u0010\u0006\u001a\u0004\b\u0000\u0010\u0007\u001a\u0004\b\u0001\u0010\b\"\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u00022\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\b0\u0002¨\u0006\u001a"}, d2 = {"size", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", "getSize", "(Ljava/util/Map;)I", "RTSMap", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "delete", "", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "forEach", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "has", "keys", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;", "lib_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class RTSMapKt {
    public static final <K, V> Map<K, V> RTSMap() {
        return new LinkedHashMap();
    }

    public static final int getSize(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.size();
    }

    public static final <K, V> Map<K, V> set(Map<K, V> map, K k, V v) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        map.put(k, v);
        return map;
    }

    public static final <K, V> boolean has(Map<K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.containsKey(k);
    }

    public static final <K, V> ArrayList<K> keys(Map<K, V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return new ArrayList<>(map.keySet());
    }

    public static final <K, V> boolean delete(Map<K, V> map, K k) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        return map.remove(k) != null;
    }

    public static final <K, V> void forEach(Map<K, V> map, Function2<? super V, ? super K, Unit> callback) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        for (Map.Entry<K, V> entry : map.entrySet()) {
            callback.invoke(entry.getValue(), entry.getKey());
        }
    }
}
