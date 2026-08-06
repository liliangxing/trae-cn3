package com.bytedance.ies.bullet.service.base.impl;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.ies.bullet.service.base.api.IBulletService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ServiceMap.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0007J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0000J\u0016\u0010\u0012\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "", "builder", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap$Builder;", "(Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap$Builder;)V", "()V", "bid", "", "serviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "get", "clazzName", "getAllClazzName", "", "merge", "", PreloadConfig.KEY_OTHER, "put", "serviceInst", "Builder", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class ServiceMap {
    private String bid;
    private final ConcurrentHashMap<String, IBulletService> serviceMap;

    public /* synthetic */ ServiceMap(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private ServiceMap() {
        this.serviceMap = new ConcurrentHashMap<>();
    }

    public final void put(String clazzName, IBulletService serviceInst) {
        Intrinsics.checkNotNullParameter(clazzName, "clazzName");
        Intrinsics.checkNotNullParameter(serviceInst, "serviceInst");
        IBulletService iBulletService = this.serviceMap.get(clazzName);
        if (iBulletService != null) {
            iBulletService.onUnRegister();
        }
        String str = this.bid;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bid");
            str = null;
        }
        serviceInst.onRegister(str);
        this.serviceMap.put(clazzName, serviceInst);
    }

    public final List<String> getAllClazzName() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, IBulletService>> it = this.serviceMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        return arrayList;
    }

    public final IBulletService get(String clazzName) {
        Intrinsics.checkNotNullParameter(clazzName, "clazzName");
        return this.serviceMap.get(clazzName);
    }

    public final void merge(ServiceMap other) {
        Intrinsics.checkNotNullParameter(other, "other");
        for (Map.Entry<String, IBulletService> entry : other.serviceMap.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    private ServiceMap(Builder builder) {
        this();
        this.bid = builder.getBid();
        this.serviceMap.putAll(builder.getServiceMap());
    }

    /* compiled from: ServiceMap.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ-\u0010\u0010\u001a\u00020\u0000\"\b\b\u0000\u0010\u0011*\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u00132\u0006\u0010\u0014\u001a\u0002H\u0011¢\u0006\u0002\u0010\u0015J.\u0010\u0016\u001a\u00020\u0000\"\b\b\u0000\u0010\u0011*\u00020\u000b2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap$Builder;", "", "()V", "bid", "", "getBid", "()Ljava/lang/String;", "setBid", "(Ljava/lang/String;)V", "serviceMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "getServiceMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "build", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "register", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "serviceInst", "(Ljava/lang/Class;Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap$Builder;", "registerProvider", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceProvider;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private final ConcurrentHashMap<String, IBulletService> serviceMap = new ConcurrentHashMap<>();
        private String bid = "default_bid";

        public final ConcurrentHashMap<String, IBulletService> getServiceMap() {
            return this.serviceMap;
        }

        public final String getBid() {
            return this.bid;
        }

        public final void setBid(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.bid = str;
        }

        public final <T extends IBulletService> Builder register(Class<? extends T> clazz, T serviceInst) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(serviceInst, "serviceInst");
            ConcurrentHashMap<String, IBulletService> concurrentHashMap = this.serviceMap;
            String name = clazz.getName();
            Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
            concurrentHashMap.put(name, serviceInst);
            return this;
        }

        public final <T extends IBulletService> Builder registerProvider(Class<? extends T> clazz, ServiceProvider<T> serviceInst) {
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(serviceInst, "serviceInst");
            ConcurrentHashMap<String, IBulletService> concurrentHashMap = this.serviceMap;
            String name = clazz.getName();
            Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
            concurrentHashMap.put(name, serviceInst);
            return this;
        }

        public final Builder bid(String bid) {
            Intrinsics.checkNotNullParameter(bid, "bid");
            this.bid = bid;
            return this;
        }

        public final ServiceMap build() {
            return new ServiceMap(this, null);
        }
    }
}
