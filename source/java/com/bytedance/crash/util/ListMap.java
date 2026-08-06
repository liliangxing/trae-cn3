package com.bytedance.crash.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class ListMap<K, V> extends ConcurrentHashMap<K, List<V>> {
    private static final long serialVersionUID = -8278080958339137414L;

    public List<V> newList() {
        return new ArrayList();
    }

    public void add(K k, V v) {
        getList(k).add(v);
    }

    public void addMulti(V v, K... kArr) {
        if (v == null || kArr == null || kArr.length <= 0) {
            return;
        }
        for (K k : kArr) {
            getList(k).add(v);
        }
    }

    public void removeAll(V v) {
        Iterator<V> it = values().iterator();
        while (it.hasNext()) {
            ((List) it.next()).remove(v);
        }
    }

    public void removeInList(K k, V v) {
        getList(k).remove(v);
    }

    public List<V> getList(K k) {
        List<V> list = (List) super.get(k);
        if (list != null) {
            return list;
        }
        List<V> newList = newList();
        put(k, newList);
        return newList;
    }
}
