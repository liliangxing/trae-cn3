package com.bytedance.bdinstall.util;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class MultiSingleton<T> {
    private volatile ConcurrentHashMap<String, T> instanceMap;

    protected abstract T create(String str, Object... objArr);

    public final T get(String str, Object... objArr) {
        T t = null;
        T t2 = this.instanceMap == null ? null : this.instanceMap.get(str);
        if (t2 == null) {
            synchronized (this) {
                if (this.instanceMap != null) {
                    t = this.instanceMap.get(str);
                }
                if (t == null) {
                    T create = create(str, objArr);
                    if (create != null) {
                        if (this.instanceMap == null) {
                            this.instanceMap = new ConcurrentHashMap<>(4);
                        }
                        this.instanceMap.put(str, create);
                    }
                    t2 = create;
                } else {
                    t2 = t;
                }
            }
        }
        return t2;
    }
}
