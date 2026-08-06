package com.bytedance.sdk.xbridge.cn.registry.core;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\u0010\u000bJ\r\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\r\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00060\tHÆ\u0003JW\u0010\u0019\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00060\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R%\u0010\b\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0003\u0012\u0004\u0012\u00020\u00060\t¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006!"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationData;", "", "paramClass", "Ljava/lang/Class;", "resultClass", "xBridgeParamModel", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;", "xBridgeResultModel", StrategyConstants.MODELS, "", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "(Ljava/lang/Class;Ljava/lang/Class;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;Ljava/util/Map;)V", "getModels", "()Ljava/util/Map;", "getParamClass", "()Ljava/lang/Class;", "getResultClass", "getXBridgeParamModel", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/IDLAnnotationModel;", "getXBridgeResultModel", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IDLAnnotationData {
    private final Map<Class<? extends XBaseModel>, IDLAnnotationModel> models;
    private final Class<?> paramClass;
    private final Class<?> resultClass;
    private final IDLAnnotationModel xBridgeParamModel;
    private final IDLAnnotationModel xBridgeResultModel;

    public static /* synthetic */ IDLAnnotationData copy$default(IDLAnnotationData iDLAnnotationData, Class cls, Class cls2, IDLAnnotationModel iDLAnnotationModel, IDLAnnotationModel iDLAnnotationModel2, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = iDLAnnotationData.paramClass;
        }
        if ((i & 2) != 0) {
            cls2 = iDLAnnotationData.resultClass;
        }
        Class cls3 = cls2;
        if ((i & 4) != 0) {
            iDLAnnotationModel = iDLAnnotationData.xBridgeParamModel;
        }
        IDLAnnotationModel iDLAnnotationModel3 = iDLAnnotationModel;
        if ((i & 8) != 0) {
            iDLAnnotationModel2 = iDLAnnotationData.xBridgeResultModel;
        }
        IDLAnnotationModel iDLAnnotationModel4 = iDLAnnotationModel2;
        if ((i & 16) != 0) {
            map = iDLAnnotationData.models;
        }
        return iDLAnnotationData.copy(cls, cls3, iDLAnnotationModel3, iDLAnnotationModel4, map);
    }

    public final Class<?> component1() {
        return this.paramClass;
    }

    public final Class<?> component2() {
        return this.resultClass;
    }

    /* renamed from: component3, reason: from getter */
    public final IDLAnnotationModel getXBridgeParamModel() {
        return this.xBridgeParamModel;
    }

    /* renamed from: component4, reason: from getter */
    public final IDLAnnotationModel getXBridgeResultModel() {
        return this.xBridgeResultModel;
    }

    public final Map<Class<? extends XBaseModel>, IDLAnnotationModel> component5() {
        return this.models;
    }

    public final IDLAnnotationData copy(Class<?> paramClass, Class<?> resultClass, IDLAnnotationModel xBridgeParamModel, IDLAnnotationModel xBridgeResultModel, Map<Class<? extends XBaseModel>, IDLAnnotationModel> models) {
        Intrinsics.checkNotNullParameter(paramClass, "paramClass");
        Intrinsics.checkNotNullParameter(resultClass, "resultClass");
        Intrinsics.checkNotNullParameter(xBridgeParamModel, "xBridgeParamModel");
        Intrinsics.checkNotNullParameter(xBridgeResultModel, "xBridgeResultModel");
        Intrinsics.checkNotNullParameter(models, "models");
        return new IDLAnnotationData(paramClass, resultClass, xBridgeParamModel, xBridgeResultModel, models);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDLAnnotationData)) {
            return false;
        }
        IDLAnnotationData iDLAnnotationData = (IDLAnnotationData) other;
        return Intrinsics.areEqual(this.paramClass, iDLAnnotationData.paramClass) && Intrinsics.areEqual(this.resultClass, iDLAnnotationData.resultClass) && Intrinsics.areEqual(this.xBridgeParamModel, iDLAnnotationData.xBridgeParamModel) && Intrinsics.areEqual(this.xBridgeResultModel, iDLAnnotationData.xBridgeResultModel) && Intrinsics.areEqual(this.models, iDLAnnotationData.models);
    }

    public int hashCode() {
        return (((((((this.paramClass.hashCode() * 31) + this.resultClass.hashCode()) * 31) + this.xBridgeParamModel.hashCode()) * 31) + this.xBridgeResultModel.hashCode()) * 31) + this.models.hashCode();
    }

    public String toString() {
        return "IDLAnnotationData(paramClass=" + this.paramClass + ", resultClass=" + this.resultClass + ", xBridgeParamModel=" + this.xBridgeParamModel + ", xBridgeResultModel=" + this.xBridgeResultModel + ", models=" + this.models + ')';
    }

    public IDLAnnotationData(Class<?> paramClass, Class<?> resultClass, IDLAnnotationModel xBridgeParamModel, IDLAnnotationModel xBridgeResultModel, Map<Class<? extends XBaseModel>, IDLAnnotationModel> models) {
        Intrinsics.checkNotNullParameter(paramClass, "paramClass");
        Intrinsics.checkNotNullParameter(resultClass, "resultClass");
        Intrinsics.checkNotNullParameter(xBridgeParamModel, "xBridgeParamModel");
        Intrinsics.checkNotNullParameter(xBridgeResultModel, "xBridgeResultModel");
        Intrinsics.checkNotNullParameter(models, "models");
        this.paramClass = paramClass;
        this.resultClass = resultClass;
        this.xBridgeParamModel = xBridgeParamModel;
        this.xBridgeResultModel = xBridgeResultModel;
        this.models = models;
    }

    public final Class<?> getParamClass() {
        return this.paramClass;
    }

    public final Class<?> getResultClass() {
        return this.resultClass;
    }

    public final IDLAnnotationModel getXBridgeParamModel() {
        return this.xBridgeParamModel;
    }

    public final IDLAnnotationModel getXBridgeResultModel() {
        return this.xBridgeResultModel;
    }

    public /* synthetic */ IDLAnnotationData(Class cls, Class cls2, IDLAnnotationModel iDLAnnotationModel, IDLAnnotationModel iDLAnnotationModel2, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, cls2, iDLAnnotationModel, iDLAnnotationModel2, (i & 16) != 0 ? new HashMap() : hashMap);
    }

    public final Map<Class<? extends XBaseModel>, IDLAnnotationModel> getModels() {
        return this.models;
    }
}
