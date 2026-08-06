package com.bytedance.pia.core.runtime;

import android.text.TextUtils;
import com.bytedance.pia.core.api.context.IPiaContext;
import com.bytedance.pia.core.api.utils.IReleasable;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public class BaseContext implements IPiaContext, IReleasable {
    private final AtomicBoolean isClosed = new AtomicBoolean(false);
    private final ConcurrentHashMap<String, Object> items = new ConcurrentHashMap<>();

    @Override // com.bytedance.pia.core.api.context.IPiaContext
    public final String put(Object obj) {
        if (this.isClosed.get()) {
            return null;
        }
        String generateKey = generateKey(obj);
        if (!TextUtils.isEmpty(generateKey)) {
            this.items.putIfAbsent(generateKey, obj);
        }
        return generateKey;
    }

    public final String generateKey(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.hashCode() + String.valueOf(hashCode());
    }

    @Override // com.bytedance.pia.core.api.context.IPiaContext
    public final String put(Object obj, String str) {
        if (this.isClosed.get() || obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        this.items.putIfAbsent(str, obj);
        return str;
    }

    @Override // com.bytedance.pia.core.api.context.IPiaContext
    public final Object get(String str) {
        if (this.isClosed.get() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.items.get(str);
    }

    @Override // com.bytedance.pia.core.api.context.IPiaContext
    public final Object remove(String str) {
        if (this.isClosed.get() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.items.remove(str);
    }

    @Override // com.bytedance.pia.core.api.utils.IReleasable
    public void release() {
        if (this.isClosed.compareAndSet(false, true)) {
            Enumeration<Object> elements = this.items.elements();
            while (elements.hasMoreElements()) {
                try {
                    Object nextElement = elements.nextElement();
                    if (nextElement instanceof IReleasable) {
                        ((IReleasable) nextElement).release();
                    }
                } catch (Throwable unused) {
                }
            }
            this.items.clear();
        }
    }
}
