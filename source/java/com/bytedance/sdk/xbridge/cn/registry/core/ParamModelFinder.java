package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParamModelFinder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/ParamModelFinder;", "", "()V", "retrieveParamModel", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseParamModel;", "clazz", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ParamModelFinder {
    public static final ParamModelFinder INSTANCE = new ParamModelFinder();

    private ParamModelFinder() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.util.List] */
    public final Class<? extends XBaseParamModel> retrieveParamModel(Class<? extends IDLXBridgeMethod> clazz) {
        Class<?>[] declaredClasses;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Class<?>[] declaredClasses2 = clazz.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses2, "clazz.declaredClasses");
        Class<?>[] clsArr = declaredClasses2;
        ArrayList arrayList = new ArrayList();
        int length = clsArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            Class<?> cls = clsArr[i];
            if (cls.getAnnotation(XBridgeParamModel.class) != null) {
                arrayList.add(cls);
            }
            i++;
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            Class<? super Object> superclass = clazz.getSuperclass();
            if (superclass == null || (declaredClasses = superclass.getDeclaredClasses()) == null) {
                arrayList2 = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList3 = new ArrayList();
                for (Class<?> cls2 : declaredClasses) {
                    if (cls2.getAnnotation(XBridgeParamModel.class) != null) {
                        arrayList3.add(cls2);
                    }
                }
                arrayList2 = arrayList3;
            }
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        Object first = CollectionsKt.first(arrayList2);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type java.lang.Class<out com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel>");
        return (Class) first;
    }
}
