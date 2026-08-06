package com.bytedance.ies.tools.prefetch;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RequestConfig.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0003\u001a\u00028\u0000X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0082\u0001\u0005\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/TypedParam;", ExifInterface.GPS_DIRECTION_TRUE, "", "value", "(Ljava/lang/Object;)V", "getValue$prefetch_release", "()Ljava/lang/Object;", "Ljava/lang/Object;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "WithSpecifiedType", "Lcom/bytedance/ies/tools/prefetch/StaticParam;", "Lcom/bytedance/ies/tools/prefetch/ParameterizedParam;", "Lcom/bytedance/ies/tools/prefetch/VariableParam;", "Lcom/bytedance/ies/tools/prefetch/PathParam;", "Lcom/bytedance/ies/tools/prefetch/NestedParam;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes4.dex */
public abstract class TypedParam<T> {
    private final T value;

    /* compiled from: RequestConfig.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ies/tools/prefetch/TypedParam$WithSpecifiedType;", "", "dataType", "", "getDataType", "()Ljava/lang/String;", "prefetch_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes4.dex */
    public interface WithSpecifiedType {
        String getDataType();
    }

    private TypedParam(T t) {
        this.value = t;
    }

    public /* synthetic */ TypedParam(Object obj, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj);
    }

    public final T getValue$prefetch_release() {
        return this.value;
    }

    public boolean equals(Object other) {
        if (((TypedParam) (!(other instanceof TypedParam) ? null : other)) == null) {
            return false;
        }
        TypedParam typedParam = (TypedParam) other;
        if (!Intrinsics.areEqual(typedParam.getClass(), getClass())) {
            return false;
        }
        return Intrinsics.areEqual(this.value, typedParam.value);
    }

    public int hashCode() {
        T t = this.value;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }
}
