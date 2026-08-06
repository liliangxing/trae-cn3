package com.bytedance.android.anniex.scene.core;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HotUrlCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\bH\u0014¨\u0006\t"}, d2 = {"com/bytedance/android/anniex/scene/core/HotUrlCache$map$1", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class HotUrlCache$map$1 extends LinkedHashMap<String, Integer> {
    final /* synthetic */ HotUrlCache this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUrlCache$map$1(HotUrlCache hotUrlCache) {
        super(50, 0.75f, true);
        this.this$0 = hotUrlCache;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    public /* bridge */ boolean containsValue(Integer num) {
        return super.containsValue((Object) num);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Integer) {
            return containsValue((Integer) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Integer>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Integer get(String str) {
        return (Integer) super.get((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<String, Integer>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Integer getOrDefault(Object obj, Integer num) {
        return !(obj instanceof String) ? num : getOrDefault((String) obj, num);
    }

    public /* bridge */ Integer getOrDefault(String str, Integer num) {
        return (Integer) super.getOrDefault((Object) str, (String) num);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Integer) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Integer> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Integer remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public /* bridge */ Integer remove(String str) {
        return (Integer) super.remove((Object) str);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Integer)) {
            return remove((String) obj, (Integer) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, Integer num) {
        return super.remove((Object) str, (Object) num);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Integer> values() {
        return getValues();
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
        int i;
        Intrinsics.checkNotNullParameter(eldest, "eldest");
        int size = size();
        i = this.this$0.maxSize;
        return size > i;
    }
}
