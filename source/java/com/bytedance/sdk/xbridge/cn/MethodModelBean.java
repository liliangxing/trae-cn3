package com.bytedance.sdk.xbridge.cn;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: XBridgeDynamicModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0005J\r\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J\r\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0003J%\u0010\u000b\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\b\u0002\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/MethodModelBean;", "", "paramMode", "Ljava/lang/Class;", "resultModel", "(Ljava/lang/Class;Ljava/lang/Class;)V", "getParamMode", "()Ljava/lang/Class;", "getResultModel", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MethodModelBean {
    private final Class<?> paramMode;
    private final Class<?> resultModel;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MethodModelBean copy$default(MethodModelBean methodModelBean, Class cls, Class cls2, int i, Object obj) {
        if ((i & 1) != 0) {
            cls = methodModelBean.paramMode;
        }
        if ((i & 2) != 0) {
            cls2 = methodModelBean.resultModel;
        }
        return methodModelBean.copy(cls, cls2);
    }

    public final Class<?> component1() {
        return this.paramMode;
    }

    public final Class<?> component2() {
        return this.resultModel;
    }

    public final MethodModelBean copy(Class<?> paramMode, Class<?> resultModel) {
        Intrinsics.checkNotNullParameter(paramMode, "paramMode");
        Intrinsics.checkNotNullParameter(resultModel, "resultModel");
        return new MethodModelBean(paramMode, resultModel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MethodModelBean)) {
            return false;
        }
        MethodModelBean methodModelBean = (MethodModelBean) other;
        return Intrinsics.areEqual(this.paramMode, methodModelBean.paramMode) && Intrinsics.areEqual(this.resultModel, methodModelBean.resultModel);
    }

    public int hashCode() {
        return (this.paramMode.hashCode() * 31) + this.resultModel.hashCode();
    }

    public String toString() {
        return "MethodModelBean(paramMode=" + this.paramMode + ", resultModel=" + this.resultModel + ')';
    }

    public MethodModelBean(Class<?> paramMode, Class<?> resultModel) {
        Intrinsics.checkNotNullParameter(paramMode, "paramMode");
        Intrinsics.checkNotNullParameter(resultModel, "resultModel");
        this.paramMode = paramMode;
        this.resultModel = resultModel;
    }

    public final Class<?> getParamMode() {
        return this.paramMode;
    }

    public final Class<?> getResultModel() {
        return this.resultModel;
    }
}
