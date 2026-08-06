package com.bytedance.apm.perf.memory.utils;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class KeyedWeakReference extends WeakReference<Object> {
    public final String key;
    public final String name;

    public KeyedWeakReference(Object obj, String str, String str2, ReferenceQueue<Object> referenceQueue) {
        super(checkNotNull(obj, "referent"), (ReferenceQueue) checkNotNull(referenceQueue, "referenceQueue"));
        this.key = (String) checkNotNull(str, "key");
        this.name = (String) checkNotNull(str2, "name");
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }
}
