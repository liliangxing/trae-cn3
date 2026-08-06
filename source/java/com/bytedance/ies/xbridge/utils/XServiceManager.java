package com.bytedance.ies.xbridge.utils;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XLog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0006J%\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005¢\u0006\u0002\u0010\rR$\u0010\u0003\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ies/xbridge/utils/XServiceManager;", "", "()V", "services", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/utils/IXBridgeService;", "bind", "", "clazz", "service", "getService", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/Class;)Lcom/bytedance/ies/xbridge/utils/IXBridgeService;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XServiceManager {
    public static final XServiceManager INSTANCE = new XServiceManager();
    private static final Map<Class<? extends IXBridgeService>, IXBridgeService> services = new LinkedHashMap();

    private XServiceManager() {
    }

    public final void bind(Class<? extends IXBridgeService> clazz, IXBridgeService service) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        services.put(clazz, service);
    }

    public final <T extends IXBridgeService> T getService(Class<T> service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return (T) services.get(service);
    }
}
