package com.bytedance.ies.bullet.service.base.impl;

import android.util.Log;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import com.bytedance.ies.bullet.service.base.api.IServiceCenter;
import com.bytedance.ies.bullet.service.base.impl.ServiceMap;
import com.bytedance.ies.bullet.service.context.TypedMap;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J5\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f2\u0006\u0010\u0010\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u00052\u0010\u0010\u0014\u001a\f\u0012\u0004\u0012\u00020\u00160\u0015j\u0002`\u0017H\u0016J6\u0010\u0018\u001a\u00020\u0001\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0002J/\u0010\u001c\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\r2\u0006\u0010\n\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010\"\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u0005H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceCenter;", "Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "()V", "bidServiceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "initializeStateMap", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceCenter$InitializeState;", PhoneBindActivity.MODE_BIND, "bid", "serviceMap", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "Ljava/lang/Class;", "serviceInst", "(Ljava/lang/String;Ljava/lang/Class;Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "bindInitializeMethod", "", "initializeMethod", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/api/InitializeMethod;", "bindProvider", "provider", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceProvider;", "createOrGetBy", PrefetchRequestConfig.METHOD_GET, "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getMonitorInfo", "Lcom/bytedance/ies/bullet/service/context/TypedMap;", "", "sessionId", "tryInitialize", "Companion", "InitializeState", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ServiceCenter implements IServiceCenter {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static volatile IServiceCenter sServiceCenter = new ServiceCenter();
    private final ConcurrentHashMap<String, ServiceMap> bidServiceMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, InitializeState> initializeStateMap = new ConcurrentHashMap<>();

    @JvmStatic
    public static final IServiceCenter instance() {
        return INSTANCE.instance();
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IContextService
    public TypedMap<String, Object> getMonitorInfo(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return null;
    }

    private ServiceCenter() {
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public IServiceCenter bindDefault(ServiceMap serviceMap) {
        return IServiceCenter.DefaultImpls.bindDefault(this, serviceMap);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public <T extends IBulletService> IServiceCenter bindDefault(Class<T> cls, T t) {
        return IServiceCenter.DefaultImpls.bindDefault(this, cls, t);
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public <T extends IBulletService> T get(Class<T> cls) {
        return (T) IServiceCenter.DefaultImpls.get(this, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ServiceCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000f\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceCenter$InitializeState;", "", "method", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/api/InitializeMethod;", "shouldInvoke", "", "(Lkotlin/jvm/functions/Function0;Z)V", "getMethod", "()Lkotlin/jvm/functions/Function0;", "getShouldInvoke", "()Z", "setShouldInvoke", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class InitializeState {
        private final Function0<Unit> method;
        private boolean shouldInvoke;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ InitializeState copy$default(InitializeState initializeState, Function0 function0, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = initializeState.method;
            }
            if ((i & 2) != 0) {
                z = initializeState.shouldInvoke;
            }
            return initializeState.copy(function0, z);
        }

        public final Function0<Unit> component1() {
            return this.method;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getShouldInvoke() {
            return this.shouldInvoke;
        }

        public final InitializeState copy(Function0<Unit> method, boolean shouldInvoke) {
            Intrinsics.checkNotNullParameter(method, "method");
            return new InitializeState(method, shouldInvoke);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InitializeState)) {
                return false;
            }
            InitializeState initializeState = (InitializeState) other;
            return Intrinsics.areEqual(this.method, initializeState.method) && this.shouldInvoke == initializeState.shouldInvoke;
        }

        public int hashCode() {
            return (this.method.hashCode() * 31) + Boolean.hashCode(this.shouldInvoke);
        }

        public String toString() {
            return "InitializeState(method=" + this.method + ", shouldInvoke=" + this.shouldInvoke + ')';
        }

        public InitializeState(Function0<Unit> function0, boolean z) {
            Intrinsics.checkNotNullParameter(function0, "method");
            this.method = function0;
            this.shouldInvoke = z;
        }

        public final Function0<Unit> getMethod() {
            return this.method;
        }

        public final boolean getShouldInvoke() {
            return this.shouldInvoke;
        }

        public final void setShouldInvoke(boolean z) {
            this.shouldInvoke = z;
        }
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public boolean bindInitializeMethod(String bid, Function0<Unit> initializeMethod) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(initializeMethod, "initializeMethod");
        if (this.initializeStateMap.containsKey(bid)) {
            Log.w("XInit", "conflict InitializeState on bid=" + bid);
            return false;
        }
        Log.d("XInit", "bind InitializeState on bid=" + bid);
        this.initializeStateMap.put(bid, new InitializeState(initializeMethod, true));
        return true;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public IServiceCenter bind(String bid, ServiceMap serviceMap) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(serviceMap, "serviceMap");
        createOrGetBy(bid).merge(serviceMap);
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public <T extends IBulletService> IServiceCenter bind(String bid, Class<T> clazz, T serviceInst) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(serviceInst, "serviceInst");
        ServiceMap createOrGetBy = createOrGetBy(bid);
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        createOrGetBy.put(name, serviceInst);
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public <T extends IBulletService> IServiceCenter bindProvider(String bid, Class<T> clazz, ServiceProvider<T> provider) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(provider, "provider");
        ServiceMap createOrGetBy = createOrGetBy(bid);
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        createOrGetBy.put(name, provider);
        return this;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public <T extends IBulletService> T get(String bid, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ServiceMap createOrGetBy = createOrGetBy(bid);
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
        ServiceProvider serviceProvider = (T) createOrGetBy.get(name);
        if (serviceProvider instanceof ServiceProvider) {
            T t = (T) serviceProvider.createService();
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type T of com.bytedance.ies.bullet.service.base.impl.ServiceCenter.get");
            ServiceMap createOrGetBy2 = createOrGetBy(bid);
            String name2 = clazz.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "clazz.name");
            createOrGetBy2.put(name2, t);
            return t;
        }
        if (serviceProvider != null) {
            return serviceProvider;
        }
        ServiceMap createOrGetBy3 = createOrGetBy("default_bid");
        String name3 = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "clazz.name");
        T t2 = (T) createOrGetBy3.get(name3);
        if (t2 instanceof IBulletService) {
            return t2;
        }
        return null;
    }

    private final ServiceMap createOrGetBy(String bid) {
        ServiceMap serviceMap = this.bidServiceMap.get(bid);
        if (serviceMap != null) {
            return serviceMap;
        }
        Log.d("XInit", "no serviceMap for bid=" + bid);
        ServiceMap build = new ServiceMap.Builder().bid(bid).build();
        this.bidServiceMap.put(bid, build);
        tryInitialize(bid);
        return build;
    }

    @Override // com.bytedance.ies.bullet.service.base.api.IServiceCenter
    public boolean tryInitialize(String bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        InitializeState initializeState = this.initializeStateMap.get(bid);
        if (initializeState == null || !initializeState.getShouldInvoke()) {
            return false;
        }
        Log.d("XInit", "invoke initialize method for bid=" + bid);
        initializeState.setShouldInvoke(false);
        initializeState.getMethod().invoke();
        return true;
    }

    /* compiled from: ServiceCenter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceCenter$Companion;", "", "()V", "sServiceCenter", "Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "instance", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final IServiceCenter instance() {
            return ServiceCenter.sServiceCenter;
        }
    }
}
