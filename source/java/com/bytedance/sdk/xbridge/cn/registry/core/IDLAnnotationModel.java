package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.forest.model.PreloadConfig;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0012$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0002\u0010\tJ%\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J%\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003JU\u0010\u000f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u00062$\b\u0002\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\bHÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR-\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;", "", "methodModel", "Ljava/util/HashMap;", "Ljava/lang/reflect/Method;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLParamField;", "Lkotlin/collections/HashMap;", "stringModel", "", "(Ljava/util/HashMap;Ljava/util/HashMap;)V", "getMethodModel", "()Ljava/util/HashMap;", "getStringModel", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IDLAnnotationModel {
    private final HashMap<Method, IDLParamField> methodModel;
    private final HashMap<String, IDLParamField> stringModel;

    /* JADX WARN: Multi-variable type inference failed */
    public IDLAnnotationModel() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IDLAnnotationModel copy$default(IDLAnnotationModel iDLAnnotationModel, HashMap hashMap, HashMap hashMap2, int i, Object obj) {
        if ((i & 1) != 0) {
            hashMap = iDLAnnotationModel.methodModel;
        }
        if ((i & 2) != 0) {
            hashMap2 = iDLAnnotationModel.stringModel;
        }
        return iDLAnnotationModel.copy(hashMap, hashMap2);
    }

    public final HashMap<Method, IDLParamField> component1() {
        return this.methodModel;
    }

    public final HashMap<String, IDLParamField> component2() {
        return this.stringModel;
    }

    public final IDLAnnotationModel copy(HashMap<Method, IDLParamField> methodModel, HashMap<String, IDLParamField> stringModel) {
        Intrinsics.checkNotNullParameter(methodModel, "methodModel");
        Intrinsics.checkNotNullParameter(stringModel, "stringModel");
        return new IDLAnnotationModel(methodModel, stringModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDLAnnotationModel)) {
            return false;
        }
        IDLAnnotationModel iDLAnnotationModel = (IDLAnnotationModel) other;
        return Intrinsics.areEqual(this.methodModel, iDLAnnotationModel.methodModel) && Intrinsics.areEqual(this.stringModel, iDLAnnotationModel.stringModel);
    }

    public int hashCode() {
        return (this.methodModel.hashCode() * 31) + this.stringModel.hashCode();
    }

    public String toString() {
        return "IDLAnnotationModel(methodModel=" + this.methodModel + ", stringModel=" + this.stringModel + ')';
    }

    public IDLAnnotationModel(HashMap<Method, IDLParamField> methodModel, HashMap<String, IDLParamField> stringModel) {
        Intrinsics.checkNotNullParameter(methodModel, "methodModel");
        Intrinsics.checkNotNullParameter(stringModel, "stringModel");
        this.methodModel = methodModel;
        this.stringModel = stringModel;
    }

    public /* synthetic */ IDLAnnotationModel(HashMap hashMap, HashMap hashMap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new HashMap() : hashMap, (i & 2) != 0 ? new HashMap() : hashMap2);
    }

    public final HashMap<Method, IDLParamField> getMethodModel() {
        return this.methodModel;
    }

    public final HashMap<String, IDLParamField> getStringModel() {
        return this.stringModel;
    }
}
