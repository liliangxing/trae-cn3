package com.bytedance.ies.xbridge;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegistry.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007J$\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u0005J \u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J*\u0010\u0018\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001aR.\u0010\u0003\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b0\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeRegistry;", "", "()V", "bridgeMap", "", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "namespace", "getNamespace", "()Ljava/lang/String;", "setNamespace", "(Ljava/lang/String;)V", "findMethodClass", "platformType", "name", "getMethodList", "", "innerRegisterMethod", "", "clazz", "scope", "registerMethod", "isIDLBridge", "", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeRegistry {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String namespace = XBridge.DEFAULT_NAMESPACE;
    private final Map<XBridgePlatformType, ConcurrentHashMap<String, Class<? extends XBridgeMethod>>> bridgeMap = new LinkedHashMap();

    @JvmStatic
    public static final XBridgeRegistry copyWith(XBridgeRegistry xBridgeRegistry) {
        return INSTANCE.copyWith(xBridgeRegistry);
    }

    /* compiled from: XBridgeRegistry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeRegistry$Companion;", "", "()V", "copyWith", "Lcom/bytedance/ies/xbridge/XBridgeRegistry;", "bridgeRegistry", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final XBridgeRegistry copyWith(XBridgeRegistry bridgeRegistry) {
            Intrinsics.checkNotNullParameter(bridgeRegistry, "bridgeRegistry");
            XBridgeRegistry xBridgeRegistry = new XBridgeRegistry();
            xBridgeRegistry.setNamespace(bridgeRegistry.getNamespace());
            for (Map.Entry entry : bridgeRegistry.bridgeMap.entrySet()) {
                XBridgePlatformType xBridgePlatformType = (XBridgePlatformType) entry.getKey();
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                concurrentHashMap.putAll((Map) entry.getValue());
                xBridgeRegistry.bridgeMap.put(xBridgePlatformType, concurrentHashMap);
            }
            return xBridgeRegistry;
        }
    }

    public final String getNamespace() {
        return this.namespace;
    }

    public final void setNamespace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.namespace = str;
    }

    private final void innerRegisterMethod(Class<? extends XBridgeMethod> clazz, XBridgePlatformType scope) {
        ConcurrentHashMap<String, Class<? extends XBridgeMethod>> concurrentHashMap = this.bridgeMap.get(scope);
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        }
        String find = XBridgeRegistryCache.find(clazz);
        if (find.length() > 0) {
            concurrentHashMap.put(find, clazz);
            this.bridgeMap.put(scope, concurrentHashMap);
        }
    }

    public static /* synthetic */ void registerMethod$default(XBridgeRegistry xBridgeRegistry, Class cls, XBridgePlatformType xBridgePlatformType, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            xBridgePlatformType = XBridgePlatformType.ALL;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        xBridgeRegistry.registerMethod(cls, xBridgePlatformType, z);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> clazz, XBridgePlatformType scope, boolean isIDLBridge) {
        List listOf;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (scope == XBridgePlatformType.ALL) {
            listOf = CollectionsKt.listOf(new XBridgePlatformType[]{XBridgePlatformType.ALL, XBridgePlatformType.WEB, XBridgePlatformType.LYNX, XBridgePlatformType.RN});
        } else {
            listOf = CollectionsKt.listOf(scope);
        }
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            innerRegisterMethod(clazz, (XBridgePlatformType) it.next());
        }
    }

    public final Class<? extends XBridgeMethod> findMethodClass(XBridgePlatformType platformType, String name) {
        ConcurrentHashMap<String, Class<? extends XBridgeMethod>> concurrentHashMap;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(name, "name");
        if (platformType == XBridgePlatformType.NONE || (concurrentHashMap = this.bridgeMap.get(platformType)) == null) {
            return null;
        }
        return concurrentHashMap.get(name);
    }

    public final Map<String, Class<? extends XBridgeMethod>> getMethodList(XBridgePlatformType platformType) {
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        if (platformType == XBridgePlatformType.NONE) {
            return null;
        }
        return this.bridgeMap.get(platformType);
    }
}
