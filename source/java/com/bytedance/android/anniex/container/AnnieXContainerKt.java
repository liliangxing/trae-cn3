package com.bytedance.android.anniex.container;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\u001a2\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u0001H\u0000¨\u0006\u0004"}, d2 = {"toNonNullValue", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class AnnieXContainerKt {
    public static final <K, V> Map<K, V> toNonNullValue(Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, ? extends V> entry : map.entrySet()) {
            V value = entry.getValue();
            if (value != null) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }
}
