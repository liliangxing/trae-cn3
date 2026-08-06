package com.bytedance.ies.xbridge.utils;

import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.ies.xbridge.utils.IXAssignDir;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: XBridgeKTX.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u001f\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u0007\u001a\u001f\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0005*\b\u0012\u0004\u0012\u0002H\u00040\b¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"assignX", "Lcom/bytedance/ies/xbridge/utils/IXAssignDir;", "", "createXModel", "T", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "anniex_release"}, k = 2, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class XBridgeKTXKt {
    public static final <T extends XBaseModel> T createXModel(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return (T) XBridgeResultModelArguments.INSTANCE.createModel(cls);
    }

    public static final <T extends XBaseModel> T createXModel(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return (T) XBridgeResultModelArguments.INSTANCE.createModel(JvmClassMappingKt.getJavaClass(kClass));
    }

    public static final IXAssignDir<Object> assignX(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        return IXAssignDir.Creator.INSTANCE.create(obj);
    }
}
