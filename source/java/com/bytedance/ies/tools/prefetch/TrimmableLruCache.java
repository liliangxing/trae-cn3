package com.bytedance.ies.tools.prefetch;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.pia.core.metrics.ErrorType;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: TrimmableLruCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003BA\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000bJ\u0017\u0010\u0015\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0017J\u0006\u0010\f\u001a\u00020\u0005J/\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00028\u00012\b\u0010\u001b\u001a\u0004\u0018\u00018\u0001H\u0004¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\u0005J\u0018\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0017J\u0006\u0010\u000e\u001a\u00020\u0005J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0012\u001a\u00020\u0005J\u001d\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001¢\u0006\u0002\u0010#J\u0006\u0010\u0013\u001a\u00020\u0005J\u0015\u0010$\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J\u000e\u0010%\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005J\u001d\u0010&\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010*J\u0006\u0010\u0014\u001a\u00020\u0005J\u001d\u0010+\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00028\u00002\u0006\u0010\"\u001a\u00028\u0001H\u0004¢\u0006\u0002\u0010'J\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-J\b\u0010.\u001a\u00020/H\u0016J\u0006\u00100\u001a\u00020\nJ\u0010\u00101\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/TrimmableLruCache;", "K", "V", "", "maxSize", "", "expireRule", "Lkotlin/Function2;", "", "onValueTrimmed", "", "(ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "createCount", "evictionCount", "hitCount", "map", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "missCount", "putCount", "size", "create", "key", "(Ljava/lang/Object;)Ljava/lang/Object;", "entryRemoved", "evicted", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "evictAll", PrefetchRequestConfig.METHOD_GET, "keys", "", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "resize", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "set", "id", "(Ljava/lang/Object;Ljava/lang/Object;)V", "sizeOf", ErrorType.SNAPSHOT, "", "toString", "", "trim", "trimToSize", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class TrimmableLruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private final Function2<K, V, Boolean> expireRule;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final Function2<K, V, Unit> onValueTrimmed;
    private int putCount;
    private int size;

    protected final V create(K key) {
        return null;
    }

    protected final void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    protected final int sizeOf(K key, V value) {
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TrimmableLruCache(int i, Function2<? super K, ? super V, Boolean> function2, Function2<? super K, ? super V, Unit> function22) {
        Intrinsics.checkParameterIsNotNull(function2, "expireRule");
        Intrinsics.checkParameterIsNotNull(function22, "onValueTrimmed");
        this.maxSize = i;
        this.expireRule = function2;
        this.onValueTrimmed = function22;
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    public final void resize(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = maxSize;
            Unit unit = Unit.INSTANCE;
        }
        trimToSize(maxSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V get(K key) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            objectRef.element = this.map.get(key);
            if (objectRef.element != null) {
                this.hitCount++;
                return (V) objectRef.element;
            }
            this.missCount++;
            V v = (V) create(key);
            if (v == null) {
                return null;
            }
            synchronized (this) {
                this.createCount++;
                objectRef.element = this.map.put(key, v);
                if (objectRef.element != null) {
                    LinkedHashMap<K, V> linkedHashMap = this.map;
                    Object obj = objectRef.element;
                    if (obj == null) {
                        Intrinsics.throwNpe();
                    }
                    linkedHashMap.put(key, obj);
                } else {
                    this.size += safeSizeOf(key, v);
                    Unit unit = Unit.INSTANCE;
                }
            }
            if (objectRef.element != null) {
                entryRemoved(false, key, v, objectRef.element);
                return (V) objectRef.element;
            }
            trimToSize(this.maxSize);
            return v;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V put(K key, V value) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(key, value);
            objectRef.element = this.map.put(key, value);
            if (objectRef.element != null) {
                int i = this.size;
                Object obj = objectRef.element;
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                this.size = i - safeSizeOf(key, obj);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (objectRef.element != null) {
            Object obj2 = objectRef.element;
            if (obj2 == null) {
                Intrinsics.throwNpe();
            }
            entryRemoved(false, key, obj2, value);
        }
        trimToSize(this.maxSize);
        return (V) objectRef.element;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x007f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void trimToSize(int maxSize) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size <= maxSize) {
                    return;
                }
                Set<Map.Entry<K, V>> entrySet = this.map.entrySet();
                Intrinsics.checkExpressionValueIsNotNull(entrySet, "map.entries");
                Map.Entry entry = (Map.Entry) CollectionsKt.firstOrNull(entrySet);
                if (entry == null) {
                    return;
                }
                key = entry.getKey();
                value = entry.getValue();
                LinkedHashMap<K, V> linkedHashMap = this.map;
                if (key == null) {
                    Intrinsics.throwNpe();
                }
                linkedHashMap.remove(key);
                int i = this.size;
                if (value == null) {
                    Intrinsics.throwNpe();
                }
                this.size = i - safeSizeOf(key, value);
                this.evictionCount++;
            }
            entryRemoved(true, key, value, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V remove(K key) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        synchronized (this) {
            objectRef.element = this.map.remove(key);
            if (objectRef.element != null) {
                int i = this.size;
                Object obj = objectRef.element;
                if (obj == null) {
                    Intrinsics.throwNpe();
                }
                this.size = i - safeSizeOf(key, obj);
            }
            Unit unit = Unit.INSTANCE;
        }
        if (objectRef.element != null) {
            Object obj2 = objectRef.element;
            if (obj2 == null) {
                Intrinsics.throwNpe();
            }
            entryRemoved(false, key, obj2, null);
        }
        return (V) objectRef.element;
    }

    private final int safeSizeOf(K key, V value) {
        int sizeOf = sizeOf(key, value);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + key + '=' + value);
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized void trim() {
        LogUtil.INSTANCE.m57i("Start trimming, entry count: " + this.map.size() + '.');
        Iterator<Map.Entry<K, V>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (((Boolean) this.expireRule.invoke(next.getKey(), next.getValue())).booleanValue()) {
                it.remove();
                this.onValueTrimmed.invoke(next.getKey(), next.getValue());
                this.size -= safeSizeOf(next.getKey(), next.getValue());
                LogUtil.INSTANCE.m57i("Entry removed: " + next.getKey() + '.');
            }
        }
    }

    public final synchronized Set<K> keys() {
        Set<K> keySet;
        keySet = this.map.keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "map.keys");
        return keySet;
    }

    public final void set(K id, V value) {
        put(id, value);
    }

    public synchronized String toString() {
        int i;
        int i2;
        i = this.hitCount;
        i2 = this.missCount + i;
        return "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%%]";
    }
}
