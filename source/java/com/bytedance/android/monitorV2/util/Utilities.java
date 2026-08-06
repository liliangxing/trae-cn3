package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.HybridMultiMonitor;
import com.bytedance.android.monitorV2.executor.HybridMonitorSingleExecutor;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Utilities.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u001c\u0010\u000b\u001a\u00020\f2\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0086\bø\u0001\u0000J\u001a\u0010\u000e\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0006H\u0086\bø\u0001\u0000J\u0018\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0010JI\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u0002H\u0017\u0012\u0006\u0012\u0004\u0018\u0001H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u00192\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00170\u001b\"\u0002H\u0017¢\u0006\u0002\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/monitorV2/util/Utilities;", "", "()V", "callQuietly", "T", "callable", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isOnlineChannel", "", "isOnlineEnv", "runAsyncQuietly", "", "closure", "runQuietly", "truncate", "", "msg", "length", "", "uuid", "pick", "", "K", "V", "", "keys", "", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Utilities {
    public static final Utilities INSTANCE = new Utilities();

    private Utilities() {
    }

    public final String uuid() {
        return new StringBuilder().append(System.currentTimeMillis()).append('-').append(UUID.randomUUID()).toString();
    }

    public final void runAsyncQuietly(Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        HybridMonitorSingleExecutor.INSTANCE.execute(new Utilities$runAsyncQuietly$1(closure));
    }

    public final void runQuietly(Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter(closure, "closure");
        try {
            closure.invoke();
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
        }
    }

    public final <T> T callQuietly(Function0<? extends T> callable) {
        Intrinsics.checkNotNullParameter(callable, "callable");
        try {
            return (T) callable.invoke();
        } catch (Throwable th) {
            ExceptionUtil.handleException(th);
            return null;
        }
    }

    public final String truncate(String msg, int length) {
        if (msg == null) {
            return "";
        }
        if (msg.length() <= length) {
            return msg;
        }
        String substring = msg.substring(0, length);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final <K, V> Map<K, V> pick(Map<K, ? extends V> map, K... kArr) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(kArr, "keys");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (K k : kArr) {
            if (map.containsKey(k)) {
                linkedHashMap.put(k, map.get(k));
            }
        }
        return linkedHashMap;
    }

    public final boolean isOnlineChannel() {
        return !Intrinsics.areEqual(HybridMultiMonitor.getInstance().getHybridSettingManager().getInitConfig().getChannel(), "local_test");
    }

    public final boolean isOnlineEnv() {
        return !HybridMultiMonitor.isDebuggable();
    }
}
