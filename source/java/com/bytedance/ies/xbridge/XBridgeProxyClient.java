package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeProxyClient.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0004¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xbridge/XBridgeProxyClient;", "", "()V", "retrieveParamModel", "Ljava/lang/Class;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseParamModel;", "clazz", "Lcom/bytedance/ies/xbridge/IDLXBridgeMethod;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeProxyClient {
    public static final XBridgeProxyClient INSTANCE = new XBridgeProxyClient();

    private XBridgeProxyClient() {
    }

    public final Class<? extends XBaseParamModel> retrieveParamModel(Class<? extends IDLXBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Class<?>[] declaredClasses = clazz.getDeclaredClasses();
        Intrinsics.checkNotNullExpressionValue(declaredClasses, "clazz.declaredClasses");
        Class<?>[] clsArr = declaredClasses;
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
            Class<?>[] declaredClasses2 = clazz.getSuperclass().getDeclaredClasses();
            Intrinsics.checkNotNullExpressionValue(declaredClasses2, "clazz.superclass.declaredClasses");
            ArrayList arrayList3 = new ArrayList();
            for (Class<?> cls2 : declaredClasses2) {
                if (cls2.getAnnotation(XBridgeParamModel.class) != null) {
                    arrayList3.add(cls2);
                }
            }
            arrayList2 = arrayList3;
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        Object first = CollectionsKt.first(arrayList2);
        Intrinsics.checkNotNull(first, "null cannot be cast to non-null type java.lang.Class<out com.bytedance.ies.xbridge.model.idl.XBaseParamModel>");
        return (Class) first;
    }
}
