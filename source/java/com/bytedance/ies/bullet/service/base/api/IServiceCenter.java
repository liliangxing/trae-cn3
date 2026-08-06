package com.bytedance.ies.bullet.service.base.api;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.impl.ServiceMap;
import com.bytedance.ies.bullet.service.base.impl.ServiceProvider;
import com.bytedance.trae.login.activity.PhoneBindActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IServiceCenter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J5\u0010\u0002\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u0002H\u0007H&¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J-\u0010\r\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\u0006\u0010\u000b\u001a\u0002H\u0007H\u0016¢\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0011\u001a\f\u0012\u0004\u0012\u00020\u00130\u0012j\u0002`\u0014H&J6\u0010\u0015\u001a\u00020\u0000\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0017H&J'\u0010\u0018\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH\u0016¢\u0006\u0002\u0010\u0019J/\u0010\u0018\u001a\u0004\u0018\u0001H\u0007\"\b\b\u0000\u0010\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\nH&¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "Lcom/bytedance/ies/bullet/service/base/api/IContextService;", PhoneBindActivity.MODE_BIND, "bid", "", "serviceMap", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceMap;", "T", "Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "clazz", "Ljava/lang/Class;", "serviceInst", "(Ljava/lang/String;Ljava/lang/Class;Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "bindDefault", "(Ljava/lang/Class;Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)Lcom/bytedance/ies/bullet/service/base/api/IServiceCenter;", "bindInitializeMethod", "", "initializeMethod", "Lkotlin/Function0;", "", "Lcom/bytedance/ies/bullet/service/base/api/InitializeMethod;", "bindProvider", "provider", "Lcom/bytedance/ies/bullet/service/base/impl/ServiceProvider;", PrefetchRequestConfig.METHOD_GET, "(Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "(Ljava/lang/String;Ljava/lang/Class;)Lcom/bytedance/ies/bullet/service/base/api/IBulletService;", "tryInitialize", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IServiceCenter extends IContextService {
    IServiceCenter bind(String bid, ServiceMap serviceMap);

    <T extends IBulletService> IServiceCenter bind(String bid, Class<T> clazz, T serviceInst);

    IServiceCenter bindDefault(ServiceMap serviceMap);

    <T extends IBulletService> IServiceCenter bindDefault(Class<T> clazz, T serviceInst);

    boolean bindInitializeMethod(String bid, Function0<Unit> initializeMethod);

    <T extends IBulletService> IServiceCenter bindProvider(String bid, Class<T> clazz, ServiceProvider<T> provider);

    <T extends IBulletService> T get(Class<T> clazz);

    <T extends IBulletService> T get(String bid, Class<T> clazz);

    boolean tryInitialize(String bid);

    /* compiled from: IServiceCenter.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class DefaultImpls {
        public static <T extends IBulletService> IServiceCenter bindDefault(IServiceCenter iServiceCenter, Class<T> cls, T t) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(t, "serviceInst");
            return iServiceCenter.bind("default_bid", cls, t);
        }

        public static IServiceCenter bindDefault(IServiceCenter iServiceCenter, ServiceMap serviceMap) {
            Intrinsics.checkNotNullParameter(serviceMap, "serviceMap");
            return iServiceCenter.bind("default_bid", serviceMap);
        }

        public static <T extends IBulletService> T get(IServiceCenter iServiceCenter, Class<T> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            return (T) iServiceCenter.get("default_bid", cls);
        }
    }
}
