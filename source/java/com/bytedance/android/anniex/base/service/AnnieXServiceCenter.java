package com.bytedance.android.anniex.base.service;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.assemble.initialize.IAnnieXHostDepend;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.android.anniex.base.service.AnnieXServiceCenter;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.base.utils.logger.LoggerContext;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXServiceCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u0005H\u0002J-\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001b¢\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0010R9\u0010\u0003\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR-\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00060\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\t¨\u0006 "}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXServiceCenter;", "", "()V", "bidServicesMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/android/anniex/base/service/AnnieXServiceCenter$InstanceHolder;", "Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "getBidServicesMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "bidServicesMap$delegate", "Lkotlin/Lazy;", "createServiceMethodMap", "getCreateServiceMethodMap", "createServiceMethodMap$delegate", "serviceProviderMap", "Lcom/bytedance/android/anniex/base/service/AnnieXServiceProvider;", "getServiceProviderMap", "serviceProviderMap$delegate", "createServiceByProvider", "clazzName", "serviceProvider", "getDowngradeService", "getService", ExifInterface.GPS_DIRECTION_TRUE, "bid", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/android/anniex/base/service/IAnnieXService;", "registerServiceProvider", "", "InstanceHolder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXServiceCenter {
    public static final AnnieXServiceCenter INSTANCE = new AnnieXServiceCenter();

    /* renamed from: bidServicesMap$delegate, reason: from kotlin metadata */
    private static final Lazy bidServicesMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXServiceCenter$bidServicesMap$2
        public final ConcurrentHashMap<String, ConcurrentHashMap<String, AnnieXServiceCenter.InstanceHolder<IAnnieXService>>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    /* renamed from: serviceProviderMap$delegate, reason: from kotlin metadata */
    private static final Lazy serviceProviderMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, InstanceHolder<AnnieXServiceProvider>>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXServiceCenter$serviceProviderMap$2
        public final ConcurrentHashMap<String, AnnieXServiceCenter.InstanceHolder<AnnieXServiceProvider>> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    /* renamed from: createServiceMethodMap$delegate, reason: from kotlin metadata */
    private static final Lazy createServiceMethodMap = LazyKt.lazy(new Function0<ConcurrentHashMap<String, String>>() { // from class: com.bytedance.android.anniex.base.service.AnnieXServiceCenter$createServiceMethodMap$2
        public final ConcurrentHashMap<String, String> invoke() {
            return new ConcurrentHashMap<>();
        }
    });

    private AnnieXServiceCenter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnnieXServiceCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/base/service/AnnieXServiceCenter$InstanceHolder;", "I", "", "instance", "(Ljava/lang/Object;)V", "getInstance", "()Ljava/lang/Object;", "Ljava/lang/Object;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static final class InstanceHolder<I> {
        private final I instance;

        public InstanceHolder(I i) {
            this.instance = i;
        }

        public final I getInstance() {
            return this.instance;
        }
    }

    private final ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>> getBidServicesMap() {
        return (ConcurrentHashMap) bidServicesMap.getValue();
    }

    private final ConcurrentHashMap<String, InstanceHolder<AnnieXServiceProvider>> getServiceProviderMap() {
        return (ConcurrentHashMap) serviceProviderMap.getValue();
    }

    private final ConcurrentHashMap<String, String> getCreateServiceMethodMap() {
        return (ConcurrentHashMap) createServiceMethodMap.getValue();
    }

    public final boolean registerServiceProvider(String bid, AnnieXServiceProvider serviceProvider) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(serviceProvider, "serviceProvider");
        if (getServiceProviderMap().containsKey(bid)) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "XInit", "duplicate register ServiceProvider on bid=" + bid, (Map) null, (LoggerContext) null, 12, (Object) null);
            return false;
        }
        getServiceProviderMap().put(bid, new InstanceHolder<>(serviceProvider));
        return true;
    }

    public final <T extends IAnnieXService> T getService(String bid, Class<T> clazz) {
        AnnieXServiceProvider createServiceProvider;
        AnnieXServiceProvider instanceHolder;
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        String simpleName = clazz.getSimpleName();
        ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap = getBidServicesMap().get(bid);
        if (concurrentHashMap != null) {
            InstanceHolder<IAnnieXService> instanceHolder2 = concurrentHashMap.get(simpleName);
            if (instanceHolder2 != null) {
                if (instanceHolder2.getInstance() != null) {
                    IAnnieXService instanceHolder3 = instanceHolder2.getInstance();
                    if (instanceHolder3 instanceof IAnnieXService) {
                        return (T) instanceHolder3;
                    }
                    return null;
                }
                AnnieXServiceCenter annieXServiceCenter = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazzName");
                T t = (T) annieXServiceCenter.getDowngradeService(simpleName);
                if (t instanceof IAnnieXService) {
                    return t;
                }
                return null;
            }
            AnnieXServiceCenter annieXServiceCenter2 = INSTANCE;
            InstanceHolder<AnnieXServiceProvider> instanceHolder4 = annieXServiceCenter2.getServiceProviderMap().get(bid);
            if (instanceHolder4 != null && (instanceHolder = instanceHolder4.getInstance()) != null) {
                Intrinsics.checkNotNullExpressionValue(simpleName, "clazzName");
                IAnnieXService createServiceByProvider = annieXServiceCenter2.createServiceByProvider(simpleName, instanceHolder);
                concurrentHashMap.put(simpleName, new InstanceHolder<>(createServiceByProvider));
                if (createServiceByProvider == null) {
                    createServiceByProvider = annieXServiceCenter2.getDowngradeService(simpleName);
                    if (!(createServiceByProvider instanceof IAnnieXService)) {
                        return null;
                    }
                }
                return (T) createServiceByProvider;
            }
            Intrinsics.checkNotNullExpressionValue(simpleName, "clazzName");
            concurrentHashMap.put(simpleName, new InstanceHolder<>(null));
            T t2 = (T) annieXServiceCenter2.getDowngradeService(simpleName);
            if (t2 instanceof IAnnieXService) {
                return t2;
            }
            return null;
        }
        if (getServiceProviderMap().containsKey(bid)) {
            InstanceHolder<AnnieXServiceProvider> instanceHolder5 = getServiceProviderMap().get(bid);
            createServiceProvider = instanceHolder5 != null ? instanceHolder5.getInstance() : null;
        } else {
            IAnnieXHostDepend hostDepend = AnnieXRuntime.INSTANCE.getHostDepend();
            createServiceProvider = hostDepend != null ? hostDepend.createServiceProvider(bid) : null;
            getServiceProviderMap().put(bid, new InstanceHolder<>(createServiceProvider));
        }
        if (createServiceProvider != null) {
            Intrinsics.checkNotNullExpressionValue(simpleName, "clazzName");
            T t3 = (T) createServiceByProvider(simpleName, createServiceProvider);
            ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>> bidServicesMap2 = getBidServicesMap();
            ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(simpleName, new InstanceHolder<>(t3));
            bidServicesMap2.put(bid, concurrentHashMap2);
            if (t3 != null) {
                return t3;
            }
            T t4 = (T) getDowngradeService(simpleName);
            if (t4 instanceof IAnnieXService) {
                return t4;
            }
            return null;
        }
        ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>> bidServicesMap3 = getBidServicesMap();
        ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap3 = new ConcurrentHashMap<>();
        Intrinsics.checkNotNullExpressionValue(simpleName, "clazzName");
        concurrentHashMap3.put(simpleName, new InstanceHolder<>(null));
        bidServicesMap3.put(bid, concurrentHashMap3);
        T t5 = (T) getDowngradeService(simpleName);
        if (t5 instanceof IAnnieXService) {
            return t5;
        }
        return null;
    }

    private final IAnnieXService getDowngradeService(String clazzName) {
        AnnieXServiceProvider instanceHolder;
        ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap = getBidServicesMap().get("default_bid");
        if (concurrentHashMap != null) {
            InstanceHolder<IAnnieXService> instanceHolder2 = concurrentHashMap.get(clazzName);
            if (instanceHolder2 != null) {
                return instanceHolder2.getInstance();
            }
            AnnieXServiceCenter annieXServiceCenter = INSTANCE;
            InstanceHolder<AnnieXServiceProvider> instanceHolder3 = annieXServiceCenter.getServiceProviderMap().get("default_bid");
            if (instanceHolder3 != null && (instanceHolder = instanceHolder3.getInstance()) != null) {
                IAnnieXService createServiceByProvider = annieXServiceCenter.createServiceByProvider(clazzName, instanceHolder);
                concurrentHashMap.put(clazzName, new InstanceHolder<>(createServiceByProvider));
                return createServiceByProvider;
            }
            HybridLogger.e$default(HybridLogger.INSTANCE, "XInit", "miss AnnieXServiceProvider on default bid", (Map) null, (LoggerContext) null, 12, (Object) null);
            concurrentHashMap.put(clazzName, new InstanceHolder<>(null));
            return null;
        }
        IAnnieXHostDepend hostDepend = AnnieXRuntime.INSTANCE.getHostDepend();
        AnnieXServiceProvider createServiceProvider = hostDepend != null ? hostDepend.createServiceProvider("default_bid") : null;
        if (createServiceProvider != null) {
            getServiceProviderMap().put("default_bid", new InstanceHolder<>(createServiceProvider));
            IAnnieXService createServiceByProvider2 = createServiceByProvider(clazzName, createServiceProvider);
            ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>> bidServicesMap2 = getBidServicesMap();
            ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap2 = new ConcurrentHashMap<>();
            concurrentHashMap2.put(clazzName, new InstanceHolder<>(createServiceByProvider2));
            bidServicesMap2.put("default_bid", concurrentHashMap2);
            return createServiceByProvider2;
        }
        HybridLogger.e$default(HybridLogger.INSTANCE, "XInit", "miss AnnieXServiceProvider on default bid", (Map) null, (LoggerContext) null, 12, (Object) null);
        ConcurrentHashMap<String, ConcurrentHashMap<String, InstanceHolder<IAnnieXService>>> bidServicesMap3 = getBidServicesMap();
        ConcurrentHashMap<String, InstanceHolder<IAnnieXService>> concurrentHashMap3 = new ConcurrentHashMap<>();
        concurrentHashMap3.put(clazzName, new InstanceHolder<>(null));
        bidServicesMap3.put("default_bid", concurrentHashMap3);
        return null;
    }

    private final IAnnieXService createServiceByProvider(String clazzName, AnnieXServiceProvider serviceProvider) {
        String str = getCreateServiceMethodMap().get(clazzName);
        if (str == null) {
            str = "create" + clazzName;
            ConcurrentHashMap<String, String> createServiceMethodMap2 = INSTANCE.getCreateServiceMethodMap();
            Intrinsics.checkNotNullExpressionValue(str, "this");
            createServiceMethodMap2.put(clazzName, str);
        }
        Intrinsics.checkNotNullExpressionValue(str, "createServiceMethodMap[c…azzName] = this\n        }");
        try {
            Object invoke = serviceProvider.getClass().getMethod(str, new Class[0]).invoke(serviceProvider, new Object[0]);
            if (invoke instanceof IAnnieXService) {
                return (IAnnieXService) invoke;
            }
            return null;
        } catch (Exception e) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "XInit", "createServiceByProvider failed: methodName=" + str + ", message=" + e.getMessage(), (Map) null, (LoggerContext) null, 12, (Object) null);
            return null;
        }
    }
}
