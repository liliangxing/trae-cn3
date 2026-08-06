package com.bytedance.kmp.spi;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ug.sdk.deeplink.EventConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: KmpServiceManager.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e¢\u0006\u0002\u0010\u000fJ&\u0010\u0010\u001a\n\u0012\u0004\u0012\u0002H\u000b\u0018\u00010\u0011\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eJ\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J+\u0010\u0019\u001a\u00020\u0013\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u001a\u001a\u0002H\u000b¢\u0006\u0002\u0010\u001bJ3\u0010\u0019\u001a\u00020\u0013\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u0002H\u000b¢\u0006\u0002\u0010\u001cJ,\u0010\u0019\u001a\u00020\u0013\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0011J\u000e\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/bytedance/kmp/spi/KmpServiceManager;", "", "()V", "_target", "", "host", "Lcom/bytedance/kmp/spi/IKmpServiceManagerHost;", "target", "getTarget", "()I", PrefetchRequestConfig.METHOD_GET, "T", "Lcom/bytedance/kmp/spi/IKmpService;", "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/bytedance/kmp/spi/IKmpService;", "getAll", "", EventConstants.PARAM_SOURCE_INIT, "", "matchesTarget", "", "onTarget", "", "currentTarget", "put", "impl", "(Lkotlin/reflect/KClass;Lcom/bytedance/kmp/spi/IKmpService;)V", "(Lkotlin/reflect/KClass;[ILcom/bytedance/kmp/spi/IKmpService;)V", "implList", "setTarget", "spi_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpServiceManager {
    private static int _target;
    public static final KmpServiceManager INSTANCE = new KmpServiceManager();
    private static IKmpServiceManagerHost host = KmpServiceManagerInternalImpl.INSTANCE;

    private KmpServiceManager() {
    }

    public final int getTarget() {
        return _target;
    }

    public static /* synthetic */ void init$default(KmpServiceManager kmpServiceManager, IKmpServiceManagerHost iKmpServiceManagerHost, int i, Object obj) {
        if ((i & 1) != 0) {
            iKmpServiceManagerHost = KmpServiceManagerInternalImpl.INSTANCE;
        }
        kmpServiceManager.init(iKmpServiceManagerHost);
    }

    public final void init(IKmpServiceManagerHost host2) {
        Intrinsics.checkNotNullParameter(host2, "host");
        host = host2;
    }

    public final <T extends IKmpService> void put(KClass<T> clazz, T impl) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(impl, "impl");
        host.put((KClass<KClass<T>>) clazz, (KClass<T>) impl);
    }

    public final <T extends IKmpService> void put(KClass<T> clazz, List<? extends T> implList) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(implList, "implList");
        host.put(clazz, implList);
    }

    public final <T extends IKmpService> void put(KClass<T> clazz, int[] onTarget, T impl) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(onTarget, "onTarget");
        Intrinsics.checkNotNullParameter(impl, "impl");
        if (matchesTarget(onTarget, getTarget())) {
            host.put((KClass<KClass<T>>) clazz, (KClass<T>) impl);
        }
    }

    public final <T extends IKmpService> T get(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) host.get(clazz);
    }

    public final <T extends IKmpService> List<T> getAll(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return host.getAll(clazz);
    }

    public final void setTarget(int target) {
        _target = target;
    }

    private final boolean matchesTarget(int[] onTarget, int currentTarget) {
        if (onTarget.length == 0) {
            return true;
        }
        for (int i : onTarget) {
            if (i == currentTarget) {
                return true;
            }
        }
        return false;
    }
}
