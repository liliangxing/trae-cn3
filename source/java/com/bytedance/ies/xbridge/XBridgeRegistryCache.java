package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.utils.XLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\u00072\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0007R\"\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeRegistryCache;", "", "()V", "cache", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "", "find", "clazz", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class XBridgeRegistryCache {
    public static final XBridgeRegistryCache INSTANCE = new XBridgeRegistryCache();
    private static final Map<Class<? extends XBridgeMethod>, String> cache = new LinkedHashMap();

    private XBridgeRegistryCache() {
    }

    @JvmStatic
    public static final String find(Class<? extends XBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            Map<Class<? extends XBridgeMethod>, String> map = cache;
            String str = map.get(clazz);
            if (str == null) {
                map.put(clazz, clazz.newInstance().getName());
                str = map.get(clazz);
                XLog.INSTANCE.info("Register local bridge named :" + str);
            }
            return str == null ? "" : str;
        } catch (Exception unused) {
            return "";
        }
    }
}
