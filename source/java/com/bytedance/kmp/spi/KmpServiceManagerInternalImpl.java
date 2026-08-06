package com.bytedance.kmp.spi;

import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: KmpServiceManager.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u00020\u0005\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0002J'\u0010\r\u001a\u0004\u0018\u0001H\n\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0016¢\u0006\u0002\u0010\u000eJ(\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u0010\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0016J-\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\u0006\u0010\u0013\u001a\u0002H\nH\u0016¢\u0006\u0002\u0010\u0014J.\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\n*\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010H\u0016R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/kmp/spi/KmpServiceManagerInternalImpl;", "Lcom/bytedance/kmp/spi/IKmpServiceManagerHost;", "()V", "serviceMap", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/kmp/spi/IKmpService;", "Lkotlin/collections/HashMap;", "generateKey", "T", "clazz", "Lkotlin/reflect/KClass;", PrefetchRequestConfig.METHOD_GET, "(Lkotlin/reflect/KClass;)Lcom/bytedance/kmp/spi/IKmpService;", "getAll", "", "put", "", "impl", "(Lkotlin/reflect/KClass;Lcom/bytedance/kmp/spi/IKmpService;)V", "implList", "spi_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
final class KmpServiceManagerInternalImpl implements IKmpServiceManagerHost {
    public static final KmpServiceManagerInternalImpl INSTANCE = new KmpServiceManagerInternalImpl();
    private static final HashMap<String, List<IKmpService>> serviceMap = new HashMap<>();

    private KmpServiceManagerInternalImpl() {
    }

    @Override // com.bytedance.kmp.spi.IKmpServiceManagerHost
    public <T extends IKmpService> void put(KClass<T> clazz, T impl) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(impl, "impl");
        HashMap<String, List<IKmpService>> hashMap = serviceMap;
        String generateKey = generateKey(clazz);
        ArrayList arrayList = hashMap.get(generateKey);
        if (arrayList == null) {
            arrayList = new ArrayList();
            hashMap.put(generateKey, arrayList);
        }
        arrayList.add(impl);
    }

    @Override // com.bytedance.kmp.spi.IKmpServiceManagerHost
    public <T extends IKmpService> void put(KClass<T> clazz, List<? extends T> implList) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(implList, "implList");
        HashMap<String, List<IKmpService>> hashMap = serviceMap;
        String generateKey = generateKey(clazz);
        ArrayList arrayList = hashMap.get(generateKey);
        if (arrayList == null) {
            arrayList = new ArrayList();
            hashMap.put(generateKey, arrayList);
        }
        arrayList.addAll(implList);
    }

    @Override // com.bytedance.kmp.spi.IKmpServiceManagerHost
    public <T extends IKmpService> T get(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        List<IKmpService> list = serviceMap.get(generateKey(clazz));
        IKmpService iKmpService = list != null ? (IKmpService) CollectionsKt.first(list) : null;
        if (iKmpService instanceof IKmpService) {
            return (T) iKmpService;
        }
        return null;
    }

    @Override // com.bytedance.kmp.spi.IKmpServiceManagerHost
    public <T extends IKmpService> List<T> getAll(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Collection collection = serviceMap.get(generateKey(clazz));
        if (collection instanceof List) {
            return (List) collection;
        }
        return null;
    }

    private final <T extends IKmpService> String generateKey(KClass<T> clazz) {
        String qualifiedName = clazz.getQualifiedName();
        if (qualifiedName != null) {
            return qualifiedName;
        }
        String simpleName = clazz.getSimpleName();
        return simpleName == null ? "" : simpleName;
    }
}
