package com.bytedance.kmp.spi;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: KmpServiceManager.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001a\u001d\u0010\u0004\u001a\n\u0012\u0004\u0012\u0002H\u0001\u0018\u00010\u0005\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b\u001a\"\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\b\u001a\u0002H\u0001H\u0086\b¢\u0006\u0002\u0010\t\u001a#\u0010\u0006\u001a\u00020\u0007\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0086\b¨\u0006\u000b"}, d2 = {"kmpService", "T", "Lcom/bytedance/kmp/spi/IKmpService;", "()Lcom/bytedance/kmp/spi/IKmpService;", "kmpServices", "", "putKmpService", "", "impl", "(Lcom/bytedance/kmp/spi/IKmpService;)V", "implList", "spi_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpServiceManagerKt {
    public static final /* synthetic */ <T extends IKmpService> T kmpService() {
        KmpServiceManager kmpServiceManager = KmpServiceManager.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) kmpServiceManager.get(Reflection.getOrCreateKotlinClass(IKmpService.class));
    }

    public static final /* synthetic */ <T extends IKmpService> List<T> kmpServices() {
        KmpServiceManager kmpServiceManager = KmpServiceManager.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        return kmpServiceManager.getAll(Reflection.getOrCreateKotlinClass(IKmpService.class));
    }

    public static final /* synthetic */ <T extends IKmpService> void putKmpService(T t) {
        Intrinsics.checkNotNullParameter(t, "impl");
        KmpServiceManager kmpServiceManager = KmpServiceManager.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        kmpServiceManager.put((KClass<KClass<T>>) Reflection.getOrCreateKotlinClass(IKmpService.class), (KClass<T>) t);
    }

    public static final /* synthetic */ <T extends IKmpService> void putKmpService(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "implList");
        KmpServiceManager kmpServiceManager = KmpServiceManager.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "T");
        kmpServiceManager.put(Reflection.getOrCreateKotlinClass(IKmpService.class), list);
    }
}
