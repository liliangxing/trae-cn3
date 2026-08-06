package com.bytedance.android.monitorV2;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MonitorService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0006\b\u0000\u0010\u000b\u0018\u0001H\u0086\b¢\u0006\u0002\u0010\fJ\u001a\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u0010\u001a\u00020\u0004J\u001c\u0010\u0011\u001a\u00020\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\u0014\u001a\u00020\u000e2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/monitorV2/MonitorService;", "", "()V", "TAG", "", "serviceMap", "", "Ljava/lang/Class;", "getServiceMap", "()Ljava/util/Map;", "get", "T", "()Ljava/lang/Object;", "registerClass", "", "intClazz", "serviceClassName", "registerInstance", "clazz", "serviceImpl", "unregister", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class MonitorService {
    public static final String TAG = "MonitorService";
    public static final MonitorService INSTANCE = new MonitorService();
    private static final Map<Class<?>, Object> serviceMap = new ConcurrentHashMap();

    private MonitorService() {
    }

    public final Map<Class<?>, Object> getServiceMap() {
        return serviceMap;
    }

    public final void registerClass(Class<?> intClazz, String serviceClassName) {
        Intrinsics.checkNotNullParameter(intClazz, "intClazz");
        Intrinsics.checkNotNullParameter(serviceClassName, "serviceClassName");
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls = Class.forName(serviceClassName);
            if (cls.getClass().isAssignableFrom(intClazz.getClass())) {
                INSTANCE.registerInstance(intClazz, cls.newInstance());
            }
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }

    public final void registerInstance(Class<?> clazz, Object serviceImpl) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (serviceImpl == null) {
            MonitorLog.m28e(TAG, "Null monitor service", new Throwable());
        } else {
            serviceMap.put(clazz, serviceImpl);
        }
    }

    public final void unregister(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        serviceMap.remove(clazz);
    }

    public final /* synthetic */ <T> T get() {
        Map<Class<?>, Object> serviceMap2 = getServiceMap();
        Intrinsics.reifiedOperationMarker(4, "T");
        T t = (T) serviceMap2.get(Object.class);
        if (t == null) {
            StringBuilder sb = new StringBuilder("Cannot find service implementation of ");
            Intrinsics.reifiedOperationMarker(4, "T");
            MonitorLog.m28e(TAG, sb.append(Object.class).toString(), new Throwable());
            return null;
        }
        Intrinsics.reifiedOperationMarker(3, "T");
        if (t instanceof Object) {
            return t;
        }
        StringBuilder sb2 = new StringBuilder("Internal error, service is not instance of ");
        Intrinsics.reifiedOperationMarker(4, "T");
        MonitorLog.m28e(TAG, sb2.append(Object.class).append(", is that call register and get in different classloader?").toString(), new Throwable());
        return null;
    }
}
