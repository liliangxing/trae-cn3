package com.lynx.tasm.common;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public class NullableConcurrentHashMap<K, V> extends ConcurrentHashMap<K, V> {
    private static final Object NULL = new Object();

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            k = (K) NULL;
        }
        if (v == null) {
            v = (V) NULL;
        }
        V v2 = (V) super.put(k, v);
        if (v2 == NULL) {
            return null;
        }
        return v2;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        V v = (V) super.get(obj);
        if (v == NULL) {
            return null;
        }
        return v;
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        final Set<Map.Entry<K, V>> entrySet = super.entrySet();
        return new Set<Map.Entry<K, V>>() { // from class: com.lynx.tasm.common.NullableConcurrentHashMap.1
            @Override // java.util.Set, java.util.Collection
            public int size() {
                return entrySet.size();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return entrySet.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                Set set = entrySet;
                if (obj == null) {
                    obj = NullableConcurrentHashMap.NULL;
                }
                return set.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<Map.Entry<K, V>> iterator() {
                final Iterator it = entrySet.iterator();
                return new Iterator<Map.Entry<K, V>>() { // from class: com.lynx.tasm.common.NullableConcurrentHashMap.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public Map.Entry<K, V> next() {
                        final Map.Entry entry = (Map.Entry) it.next();
                        return new Map.Entry<K, V>() { // from class: com.lynx.tasm.common.NullableConcurrentHashMap.1.1.1
                            @Override // java.util.Map.Entry
                            public K getKey() {
                                K k = (K) entry.getKey();
                                if (k == NullableConcurrentHashMap.NULL) {
                                    return null;
                                }
                                return k;
                            }

                            @Override // java.util.Map.Entry
                            public V getValue() {
                                V v = (V) entry.getValue();
                                if (v == NullableConcurrentHashMap.NULL) {
                                    return null;
                                }
                                return v;
                            }

                            @Override // java.util.Map.Entry
                            public V setValue(V v) {
                                Map.Entry entry2 = entry;
                                if (v == null) {
                                    v = (V) NullableConcurrentHashMap.NULL;
                                }
                                return (V) entry2.setValue(v);
                            }
                        };
                    }
                };
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                Object[] array = entrySet.toArray();
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == NullableConcurrentHashMap.NULL) {
                        array[i] = null;
                    }
                }
                return array;
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) entrySet.toArray(tArr);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(Map.Entry<K, V> entry) {
                return entrySet.add(entry);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                return entrySet.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return entrySet.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                return entrySet.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                return entrySet.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                return entrySet.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                entrySet.clear();
            }
        };
    }
}
