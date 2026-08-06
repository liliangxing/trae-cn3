package com.bytedance.timonbase;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TimonIgnoreToken.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007R0\u0010\u0003\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/timonbase/TimonIgnoreToken;", "", "()V", "threadLocal", "Ljava/lang/ThreadLocal;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "add", "", "key", "value", "get", "remove", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class TimonIgnoreToken {
    public static final TimonIgnoreToken INSTANCE = new TimonIgnoreToken();
    private static final ThreadLocal<HashMap<String, String>> threadLocal = new ThreadLocal<>();

    private TimonIgnoreToken() {
    }

    @JvmStatic
    public static final void add(String key, String value) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        Intrinsics.checkParameterIsNotNull(value, "value");
        ThreadLocal<HashMap<String, String>> threadLocal2 = threadLocal;
        HashMap<String, String> hashMap = threadLocal2.get();
        if (hashMap == null) {
            hashMap = new HashMap<>();
            threadLocal2.set(hashMap);
        }
        hashMap.put(key, value);
    }

    @JvmStatic
    public static final void remove(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        HashMap<String, String> hashMap = threadLocal.get();
        if (hashMap != null) {
            hashMap.remove(key);
        }
    }

    public final String get(String key) {
        Intrinsics.checkParameterIsNotNull(key, "key");
        HashMap<String, String> hashMap = threadLocal.get();
        if (hashMap != null) {
            return hashMap.get(key);
        }
        return null;
    }
}
