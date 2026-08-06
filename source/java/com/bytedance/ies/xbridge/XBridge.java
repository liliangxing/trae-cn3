package com.bytedance.ies.xbridge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridge.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J,\u0010\u0014\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J0\u0010\u0016\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\n\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J.\u0010\u0018\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\n\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004J%\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u000b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\n¢\u0006\u0002\u0010\u001cJ.\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\n\u0018\u00010\u00172\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004J.\u0010\u001e\u001a\u00020\u001f2\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000f\u0018\u00010\n2\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J.\u0010!\u001a\u00020\u001f2\u0010\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\n2\b\b\u0002\u0010 \u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u0004H\u0007J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0007J\u000e\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridge;", "", "()V", "DEFAULT_NAMESPACE", "", "idlRegistryMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/xbridge/IDLXBridgeRegistry;", "platformMap", "", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/XBridgePlatform;", "registryMap", "Lcom/bytedance/ies/xbridge/XBridgeRegistry;", "findIDLMethodClass", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "platformType", "Lcom/bytedance/ies/xbridge/XBridgePlatformType;", "name", "namespace", "findMethodClass", "Lcom/bytedance/ies/xbridge/XBridgeMethod;", "getIDLMethodList", "", "getMethodList", "getPlatform", "T", "clazz", "(Ljava/lang/Class;)Lcom/bytedance/ies/xbridge/XBridgePlatform;", "getStandardMethodList", "registerIDLMethod", "", "scope", "registerMethod", "registerRegistry", "registry", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridge {
    public static final String DEFAULT_NAMESPACE = "DEFAULT";
    public static final XBridge INSTANCE = new XBridge();
    private static final Map<Class<XBridgePlatform>, XBridgePlatform> platformMap = new LinkedHashMap();
    private static final ConcurrentHashMap<String, XBridgeRegistry> registryMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, IDLXBridgeRegistry> idlRegistryMap = new ConcurrentHashMap<>();

    @JvmStatic
    public static final Class<? extends IDLXBridgeMethod> findIDLMethodClass(XBridgePlatformType xBridgePlatformType, String str) {
        Intrinsics.checkNotNullParameter(xBridgePlatformType, "platformType");
        Intrinsics.checkNotNullParameter(str, "name");
        return findIDLMethodClass$default(xBridgePlatformType, str, null, 4, null);
    }

    @JvmStatic
    public static final Class<? extends XBridgeMethod> findMethodClass(XBridgePlatformType xBridgePlatformType, String str) {
        Intrinsics.checkNotNullParameter(xBridgePlatformType, "platformType");
        Intrinsics.checkNotNullParameter(str, "name");
        return findMethodClass$default(xBridgePlatformType, str, null, 4, null);
    }

    @JvmStatic
    public static final Map<String, Class<? extends IDLXBridgeMethod>> getIDLMethodList(XBridgePlatformType xBridgePlatformType) {
        Intrinsics.checkNotNullParameter(xBridgePlatformType, "platformType");
        return getIDLMethodList$default(xBridgePlatformType, null, 2, null);
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> cls) {
        registerIDLMethod$default(this, cls, null, null, 6, null);
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> cls, XBridgePlatformType xBridgePlatformType) {
        Intrinsics.checkNotNullParameter(xBridgePlatformType, "scope");
        registerIDLMethod$default(this, cls, xBridgePlatformType, null, 4, null);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> cls) {
        registerMethod$default(this, cls, null, null, 6, null);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> cls, XBridgePlatformType xBridgePlatformType) {
        Intrinsics.checkNotNullParameter(xBridgePlatformType, "scope");
        registerMethod$default(this, cls, xBridgePlatformType, null, 4, null);
    }

    private XBridge() {
    }

    public final <T extends XBridgePlatform> T getPlatform(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Map<Class<XBridgePlatform>, XBridgePlatform> map = platformMap;
        T t = (T) map.get(clazz);
        if (t != null) {
            return t;
        }
        try {
            T newInstance = clazz.newInstance();
            Intrinsics.checkNotNullExpressionValue(newInstance, "tmp");
            map.put(clazz, newInstance);
            return newInstance;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void registerRegistry(XBridgeRegistry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        ConcurrentHashMap<String, XBridgeRegistry> concurrentHashMap = registryMap;
        if (concurrentHashMap.get(registry.getNamespace()) == null) {
            concurrentHashMap.put(registry.getNamespace(), registry);
        }
    }

    public final void registerRegistry(IDLXBridgeRegistry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        ConcurrentHashMap<String, IDLXBridgeRegistry> concurrentHashMap = idlRegistryMap;
        if (concurrentHashMap.get(registry.getNamespace()) == null) {
            concurrentHashMap.put(registry.getNamespace(), registry);
        }
    }

    public static /* synthetic */ void registerMethod$default(XBridge xBridge, Class cls, XBridgePlatformType xBridgePlatformType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            xBridgePlatformType = XBridgePlatformType.ALL;
        }
        if ((i & 4) != 0) {
            str = DEFAULT_NAMESPACE;
        }
        xBridge.registerMethod(cls, xBridgePlatformType, str);
    }

    public final void registerMethod(Class<? extends XBridgeMethod> clazz, XBridgePlatformType scope, String namespace) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        if (clazz != null) {
            ConcurrentHashMap<String, XBridgeRegistry> concurrentHashMap = registryMap;
            if (concurrentHashMap.get(namespace) == null) {
                concurrentHashMap.put(namespace, new XBridgeRegistry());
            }
            XBridgeRegistry xBridgeRegistry = concurrentHashMap.get(namespace);
            if (xBridgeRegistry != null) {
                Intrinsics.checkNotNullExpressionValue(xBridgeRegistry, "registryMap[namespace]");
                XBridgeRegistry.registerMethod$default(xBridgeRegistry, clazz, scope, false, 4, null);
            }
        }
    }

    public static /* synthetic */ Class findMethodClass$default(XBridgePlatformType xBridgePlatformType, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = DEFAULT_NAMESPACE;
        }
        return findMethodClass(xBridgePlatformType, str, str2);
    }

    @JvmStatic
    public static final Class<? extends XBridgeMethod> findMethodClass(XBridgePlatformType platformType, String name, String namespace) {
        XBridgeRegistry xBridgeRegistry;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        ConcurrentHashMap<String, XBridgeRegistry> concurrentHashMap = registryMap;
        if (concurrentHashMap.get(namespace) == null || (xBridgeRegistry = concurrentHashMap.get(namespace)) == null) {
            return null;
        }
        return xBridgeRegistry.findMethodClass(platformType, name);
    }

    public static /* synthetic */ Map getMethodList$default(XBridge xBridge, XBridgePlatformType xBridgePlatformType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = DEFAULT_NAMESPACE;
        }
        return xBridge.getMethodList(xBridgePlatformType, str);
    }

    public final Map<String, Class<? extends XBridgeMethod>> getMethodList(XBridgePlatformType platformType, String namespace) {
        XBridgeRegistry xBridgeRegistry;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        ConcurrentHashMap<String, XBridgeRegistry> concurrentHashMap = registryMap;
        if (concurrentHashMap.get(namespace) == null || (xBridgeRegistry = concurrentHashMap.get(namespace)) == null) {
            return null;
        }
        return xBridgeRegistry.getMethodList(platformType);
    }

    public static /* synthetic */ Map getStandardMethodList$default(XBridge xBridge, XBridgePlatformType xBridgePlatformType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = DEFAULT_NAMESPACE;
        }
        return xBridge.getStandardMethodList(xBridgePlatformType, str);
    }

    public final Map<String, Class<? extends XBridgeMethod>> getStandardMethodList(XBridgePlatformType platformType, String namespace) {
        Map<String, Class<? extends XBridgeMethod>> methodList;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        ConcurrentHashMap<String, XBridgeRegistry> concurrentHashMap = registryMap;
        LinkedHashMap linkedHashMap = null;
        if (concurrentHashMap.get(namespace) == null) {
            return null;
        }
        XBridgeRegistry xBridgeRegistry = concurrentHashMap.get(namespace);
        if (xBridgeRegistry != null && (methodList = xBridgeRegistry.getMethodList(platformType)) != null) {
            linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, Class<? extends XBridgeMethod>> entry : methodList.entrySet()) {
                if (StandardsMethodList.INSTANCE.getList().contains(entry.getKey())) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return linkedHashMap;
    }

    public static /* synthetic */ void registerIDLMethod$default(XBridge xBridge, Class cls, XBridgePlatformType xBridgePlatformType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            xBridgePlatformType = XBridgePlatformType.ALL;
        }
        if ((i & 4) != 0) {
            str = DEFAULT_NAMESPACE;
        }
        xBridge.registerIDLMethod(cls, xBridgePlatformType, str);
    }

    public final void registerIDLMethod(Class<? extends IDLXBridgeMethod> clazz, XBridgePlatformType scope, String namespace) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        if (clazz != null) {
            ConcurrentHashMap<String, IDLXBridgeRegistry> concurrentHashMap = idlRegistryMap;
            if (concurrentHashMap.get(namespace) == null) {
                concurrentHashMap.put(namespace, new IDLXBridgeRegistry());
            }
            IDLXBridgeRegistry iDLXBridgeRegistry = concurrentHashMap.get(namespace);
            if (iDLXBridgeRegistry != null) {
                Intrinsics.checkNotNullExpressionValue(iDLXBridgeRegistry, "idlRegistryMap[namespace]");
                IDLXBridgeRegistry.registerMethod$default(iDLXBridgeRegistry, clazz, scope, false, 4, null);
            }
        }
    }

    public static /* synthetic */ Class findIDLMethodClass$default(XBridgePlatformType xBridgePlatformType, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = DEFAULT_NAMESPACE;
        }
        return findIDLMethodClass(xBridgePlatformType, str, str2);
    }

    @JvmStatic
    public static final Class<? extends IDLXBridgeMethod> findIDLMethodClass(XBridgePlatformType platformType, String name, String namespace) {
        IDLXBridgeRegistry iDLXBridgeRegistry;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        ConcurrentHashMap<String, IDLXBridgeRegistry> concurrentHashMap = idlRegistryMap;
        if (concurrentHashMap.get(namespace) == null || (iDLXBridgeRegistry = concurrentHashMap.get(namespace)) == null) {
            return null;
        }
        return iDLXBridgeRegistry.findMethodClass(platformType, name);
    }

    public static /* synthetic */ Map getIDLMethodList$default(XBridgePlatformType xBridgePlatformType, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = DEFAULT_NAMESPACE;
        }
        return getIDLMethodList(xBridgePlatformType, str);
    }

    @JvmStatic
    public static final Map<String, Class<? extends IDLXBridgeMethod>> getIDLMethodList(XBridgePlatformType platformType, String namespace) {
        IDLXBridgeRegistry iDLXBridgeRegistry;
        Intrinsics.checkNotNullParameter(platformType, "platformType");
        Intrinsics.checkNotNullParameter(namespace, "namespace");
        ConcurrentHashMap<String, IDLXBridgeRegistry> concurrentHashMap = idlRegistryMap;
        if (concurrentHashMap.get(namespace) == null || (iDLXBridgeRegistry = concurrentHashMap.get(namespace)) == null) {
            return null;
        }
        return iDLXBridgeRegistry.getMethodList(platformType);
    }
}
