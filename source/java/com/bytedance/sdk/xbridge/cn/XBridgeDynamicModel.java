package com.bytedance.sdk.xbridge.cn;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import java.lang.annotation.Annotation;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeDynamicModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u0006\u0010\u000b\u001a\u00020\u0007J,\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00052\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\u0005J\u001c\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005J\u001c\u0010\u0010\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005R\"\u0010\u0003\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/XBridgeDynamicModel;", "", "()V", "methodModelMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLXBridgeMethod;", "Lcom/bytedance/sdk/xbridge/cn/MethodModelBean;", "addMethodModelMap", "", "clazz", "methodModelBean", "findModelClassByAnnotation", "annotation", "", "findParamModelByAnnotation", "findResultModelByAnnotation", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class XBridgeDynamicModel {
    public static final XBridgeDynamicModel INSTANCE = new XBridgeDynamicModel();
    private static final ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, MethodModelBean> methodModelMap = new ConcurrentHashMap<>();

    private XBridgeDynamicModel() {
    }

    public final void addMethodModelMap(Class<? extends IDLXBridgeMethod> clazz, MethodModelBean methodModelBean) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(methodModelBean, "methodModelBean");
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, MethodModelBean> concurrentHashMap = methodModelMap;
        if (concurrentHashMap.containsKey(clazz)) {
            return;
        }
        concurrentHashMap.put(clazz, methodModelBean);
    }

    public final Class<?> findModelClassByAnnotation(Class<? extends IDLXBridgeMethod> clazz, Class<? extends Annotation> annotation) {
        MethodModelBean methodModelBean;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        if (Intrinsics.areEqual(annotation, XBridgeParamModel.class)) {
            MethodModelBean methodModelBean2 = methodModelMap.get(clazz);
            if (methodModelBean2 != null) {
                return methodModelBean2.getParamMode();
            }
            return null;
        }
        if (!Intrinsics.areEqual(annotation, XBridgeResultModel.class) || (methodModelBean = methodModelMap.get(clazz)) == null) {
            return null;
        }
        return methodModelBean.getResultModel();
    }

    public final Class<?> findParamModelByAnnotation(Class<? extends IDLXBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return findModelClassByAnnotation(clazz, XBridgeParamModel.class);
    }

    public final Class<?> findResultModelByAnnotation(Class<? extends IDLXBridgeMethod> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return findModelClassByAnnotation(clazz, XBridgeResultModel.class);
    }
}
