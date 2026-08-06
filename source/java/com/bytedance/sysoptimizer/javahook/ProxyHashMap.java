package com.bytedance.sysoptimizer.javahook;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: classes5.dex */
public class ProxyHashMap<K, V> extends HashMap<K, V> {
    private static final String TAG = "ProxyHashMap";

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public int size() {
        return super.size();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        return (V) super.get(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        Log.d(TAG, "put() called with: key = [" + k + "], value = [" + v + "]");
        return (V) super.put(k, v);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) super.remove(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        super.clear();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        return super.keySet();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        return super.values();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.HashMap, java.util.Map
    public V getOrDefault(Object obj, V v) {
        return (V) super.getOrDefault(obj, v);
    }

    @Override // java.util.HashMap, java.util.Map
    public V putIfAbsent(K k, V v) {
        return (V) super.putIfAbsent(k, v);
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.Map
    public boolean replace(K k, V v, V v2) {
        return super.replace(k, v, v2);
    }

    @Override // java.util.HashMap, java.util.Map
    public V replace(K k, V v) {
        return (V) super.replace(k, v);
    }

    @Override // java.util.HashMap, java.util.Map
    public V computeIfAbsent(K k, Function<? super K, ? extends V> function) {
        return (V) super.computeIfAbsent(k, function);
    }

    @Override // java.util.HashMap, java.util.Map
    public V computeIfPresent(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        return (V) super.computeIfPresent(k, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public V compute(K k, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        return (V) super.compute(k, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public V merge(K k, V v, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        return (V) super.merge(k, v, biFunction);
    }

    @Override // java.util.HashMap, java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // java.util.HashMap, java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        super.replaceAll(biFunction);
    }

    @Override // java.util.HashMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }
}
