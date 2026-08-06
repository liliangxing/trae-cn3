package com.bytedance.ies.bullet.service.context;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HashTypedMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u001e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003j\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002`\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ies/bullet/service/context/HashTypedMap;", "K", "V", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lcom/bytedance/ies/bullet/service/context/TypedMap;", "()V", "getAny", "k", "(Ljava/lang/Object;)Ljava/lang/Object;", "getBoolean", "", "(Ljava/lang/Object;)Ljava/lang/Boolean;", "getString", "", "(Ljava/lang/Object;)Ljava/lang/String;", "putAnyIfAbsent", "v", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "putBooleanIfAbsent", "(Ljava/lang/Object;Z)Z", "putStringIfAbsent", "(Ljava/lang/Object;Ljava/lang/String;)Z", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class HashTypedMap<K, V> extends HashMap<K, V> implements TypedMap<K, V> {
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return (Set<Map.Entry<K, V>>) getEntries();
    }

    public /* bridge */ Set<Map.Entry<Object, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<Object> getKeys() {
        return super.keySet();
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return (Set<K>) getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return (Collection<V>) getValues();
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public Boolean getBoolean(K k) {
        V v = get(k);
        if (v instanceof Boolean) {
            return (Boolean) v;
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public String getString(K k) {
        V v = get(k);
        if (v instanceof String) {
            return (String) v;
        }
        return null;
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public V getAny(K k) {
        return get(k);
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public boolean putAnyIfAbsent(K k, V v) {
        if (containsKey(k)) {
            return false;
        }
        put(k, v);
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public boolean putBooleanIfAbsent(K k, boolean v) {
        Object obj;
        if (containsKey(k)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(put(k, Boolean.valueOf(v)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isSuccess-impl(obj);
    }

    @Override // com.bytedance.ies.bullet.service.context.TypedMap
    public boolean putStringIfAbsent(K k, String v) {
        Object obj;
        Intrinsics.checkNotNullParameter(v, "v");
        if (containsKey(k)) {
            return false;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(put(k, v));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        return Result.isSuccess-impl(obj);
    }
}
