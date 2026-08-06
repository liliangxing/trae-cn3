package com.bytedance.android.anniex.scene.core;

import com.bytedance.android.anniex.scene.settings.SwitchCenter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HotUrlCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r0\fJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/scene/core/HotUrlCache;", "", "()V", "map", "com/bytedance/android/anniex/scene/core/HotUrlCache$map$1", "Lcom/bytedance/android/anniex/scene/core/HotUrlCache$map$1;", "maxSize", "", "getHotCount", "url", "", "getWeightMap", "", "", "record", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class HotUrlCache {
    private final int maxSize = SwitchCenter.INSTANCE.getHotUrlCacheMaxSize();
    private final HotUrlCache$map$1 map = new HotUrlCache$map$1(this);

    public final synchronized void record(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        HotUrlCache$map$1 hotUrlCache$map$1 = this.map;
        hotUrlCache$map$1.put(url, Integer.valueOf(((Number) hotUrlCache$map$1.getOrDefault((Object) url, (Object) 0)).intValue() + 1));
    }

    public final synchronized Map<String, Double> getWeightMap() {
        LinkedHashMap linkedHashMap;
        HotUrlCache$map$1 hotUrlCache$map$1 = this.map;
        linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hotUrlCache$map$1.size()));
        Iterator<T> it = hotUrlCache$map$1.entrySet().iterator();
        while (it.hasNext()) {
            linkedHashMap.put(((Map.Entry) it.next()).getKey(), Double.valueOf(1.0d / (Math.log10(((Number) ((Map.Entry) r2).getValue()).intValue() + 1.0d) + 1.0d)));
        }
        return linkedHashMap;
    }

    public final synchronized int getHotCount(String url) {
        Object orDefault;
        Intrinsics.checkNotNullParameter(url, "url");
        orDefault = this.map.getOrDefault((Object) url, (Object) 0);
        Intrinsics.checkNotNullExpressionValue(orDefault, "map.getOrDefault(url, 0)");
        return ((Number) orDefault).intValue();
    }
}
