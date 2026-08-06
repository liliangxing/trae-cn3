package com.bytedance.ies.bullet.service.base.standard;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ies.bullet.service.base.impl.ServiceCenter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StandardServiceManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0006¢\u0006\u0002\u0010\nJ+\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\u0004\b\u0000\u0010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u0006¢\u0006\u0002\u0010\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0001J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0007R*\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/standard/StandardServiceManager;", "", "()V", "serviceGroupMap", "", "", "Ljava/lang/Class;", "get", ExifInterface.GPS_DIRECTION_TRUE, "cls", "(Ljava/lang/Class;)Ljava/lang/Object;", "bid", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "put", "", "service", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class StandardServiceManager {
    public static final StandardServiceManager INSTANCE = new StandardServiceManager();
    private static final Map<String, Map<Class<?>, Object>> serviceGroupMap = new ConcurrentHashMap(3);

    private StandardServiceManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void put$default(StandardServiceManager standardServiceManager, Object obj, Class cls, int i, Object obj2) {
        if ((i & 2) != 0) {
            cls = null;
        }
        standardServiceManager.put(obj, (Class<?>) cls);
    }

    public final void put(Object service, Class<?> cls) {
        Intrinsics.checkNotNullParameter(service, "service");
        put("default_bid", service, cls);
    }

    public final void put(String bid, Object service) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(service, "service");
        put(bid, service, service.getClass());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void put$default(StandardServiceManager standardServiceManager, String str, Object obj, Class cls, int i, Object obj2) {
        if ((i & 4) != 0) {
            cls = null;
        }
        standardServiceManager.put(str, obj, cls);
    }

    @Deprecated(message = "为了平衡工作量提供的临时接口，请勿使用")
    public final void put(String bid, Object service, Class<?> cls) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(service, "service");
        Map<String, Map<Class<?>, Object>> map = serviceGroupMap;
        ConcurrentHashMap concurrentHashMap = map.get(bid);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap(3);
            map.put(bid, concurrentHashMap);
        }
        if (cls == null) {
            cls = service.getClass();
        }
        concurrentHashMap.put(cls, service);
    }

    public final <T> T get(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        return (T) get("default_bid", cls);
    }

    public final <T> T get(String bid, Class<T> cls) {
        Object obj;
        Intrinsics.checkNotNullParameter(cls, "cls");
        Map<String, Map<Class<?>, Object>> map = serviceGroupMap;
        Map<Class<?>, Object> map2 = map.get(bid);
        if (map2 == null) {
            Log.d("XInit", "no serviceGroup for bid=" + bid);
            if (ServiceCenter.INSTANCE.instance().tryInitialize(bid == null ? "default_bid" : bid)) {
                map2 = map.get(bid);
            }
        }
        if (map2 == null || (obj = map2.get(cls)) == null) {
            Map<Class<?>, Object> map3 = map.get("default_bid");
            obj = map3 != null ? map3.get(cls) : null;
        }
        if (obj == null) {
            return null;
        }
        return (T) obj;
    }
}
