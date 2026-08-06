package com.bytedance.ies.xbridge;

import com.bytedance.ies.xbridge.model.idl.XBaseModel;
import com.bytedance.mt.protector.ThrowableDisposer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: XBridgeRegistryCache.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\u0002\u0010\u0014J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u0011\u0010&\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007HÆ\u0003J\u0011\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\rHÆ\u0003J\r\u0010+\u001a\u0006\u0012\u0002\b\u00030\u000fHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011HÆ\u0003J\u008d\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\f\b\u0002\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011HÆ\u0001J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0013HÖ\u0001J\t\u00101\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0015\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018¨\u00062"}, d2 = {"Lcom/bytedance/ies/xbridge/IDLParamField;", "", "required", "", "keyPath", "", "nestedClassType", "Lkotlin/reflect/KClass;", "Lcom/bytedance/ies/xbridge/model/idl/XBaseModel;", "primitiveClassType", "isEnum", "isGetter", "defaultValue", "Lcom/bytedance/ies/xbridge/IDLDefaultValue;", ThrowableDisposer.ConfItem.RETURN_TYPE, "Ljava/lang/Class;", "stringEnum", "", "intEnum", "", "(ZLjava/lang/String;Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;ZZLcom/bytedance/ies/xbridge/IDLDefaultValue;Ljava/lang/Class;Ljava/util/List;Ljava/util/List;)V", "getDefaultValue", "()Lcom/bytedance/ies/xbridge/IDLDefaultValue;", "getIntEnum", "()Ljava/util/List;", "()Z", "getKeyPath", "()Ljava/lang/String;", "getNestedClassType", "()Lkotlin/reflect/KClass;", "getPrimitiveClassType", "getRequired", "getReturnType", "()Ljava/lang/Class;", "getStringEnum", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class IDLParamField {
    private final IDLDefaultValue defaultValue;
    private final List<Integer> intEnum;
    private final boolean isEnum;
    private final boolean isGetter;
    private final String keyPath;
    private final KClass<? extends XBaseModel> nestedClassType;
    private final KClass<? extends Object> primitiveClassType;
    private final boolean required;
    private final Class<?> returnType;
    private final List<String> stringEnum;

    /* renamed from: component1, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    public final List<Integer> component10() {
        return this.intEnum;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKeyPath() {
        return this.keyPath;
    }

    public final KClass<? extends XBaseModel> component3() {
        return this.nestedClassType;
    }

    public final KClass<? extends Object> component4() {
        return this.primitiveClassType;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsEnum() {
        return this.isEnum;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsGetter() {
        return this.isGetter;
    }

    /* renamed from: component7, reason: from getter */
    public final IDLDefaultValue getDefaultValue() {
        return this.defaultValue;
    }

    public final Class<?> component8() {
        return this.returnType;
    }

    public final List<String> component9() {
        return this.stringEnum;
    }

    public final IDLParamField copy(boolean required, String keyPath, KClass<? extends XBaseModel> nestedClassType, KClass<? extends Object> primitiveClassType, boolean isEnum, boolean isGetter, IDLDefaultValue defaultValue, Class<?> returnType, List<String> stringEnum, List<Integer> intEnum) {
        Intrinsics.checkNotNullParameter(keyPath, "keyPath");
        Intrinsics.checkNotNullParameter(nestedClassType, "nestedClassType");
        Intrinsics.checkNotNullParameter(primitiveClassType, "primitiveClassType");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(returnType, ThrowableDisposer.ConfItem.RETURN_TYPE);
        Intrinsics.checkNotNullParameter(stringEnum, "stringEnum");
        Intrinsics.checkNotNullParameter(intEnum, "intEnum");
        return new IDLParamField(required, keyPath, nestedClassType, primitiveClassType, isEnum, isGetter, defaultValue, returnType, stringEnum, intEnum);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IDLParamField)) {
            return false;
        }
        IDLParamField iDLParamField = (IDLParamField) other;
        return this.required == iDLParamField.required && Intrinsics.areEqual(this.keyPath, iDLParamField.keyPath) && Intrinsics.areEqual(this.nestedClassType, iDLParamField.nestedClassType) && Intrinsics.areEqual(this.primitiveClassType, iDLParamField.primitiveClassType) && this.isEnum == iDLParamField.isEnum && this.isGetter == iDLParamField.isGetter && Intrinsics.areEqual(this.defaultValue, iDLParamField.defaultValue) && Intrinsics.areEqual(this.returnType, iDLParamField.returnType) && Intrinsics.areEqual(this.stringEnum, iDLParamField.stringEnum) && Intrinsics.areEqual(this.intEnum, iDLParamField.intEnum);
    }

    public int hashCode() {
        return (((((((((((((((((Boolean.hashCode(this.required) * 31) + this.keyPath.hashCode()) * 31) + this.nestedClassType.hashCode()) * 31) + this.primitiveClassType.hashCode()) * 31) + Boolean.hashCode(this.isEnum)) * 31) + Boolean.hashCode(this.isGetter)) * 31) + this.defaultValue.hashCode()) * 31) + this.returnType.hashCode()) * 31) + this.stringEnum.hashCode()) * 31) + this.intEnum.hashCode();
    }

    public String toString() {
        return "IDLParamField(required=" + this.required + ", keyPath=" + this.keyPath + ", nestedClassType=" + this.nestedClassType + ", primitiveClassType=" + this.primitiveClassType + ", isEnum=" + this.isEnum + ", isGetter=" + this.isGetter + ", defaultValue=" + this.defaultValue + ", returnType=" + this.returnType + ", stringEnum=" + this.stringEnum + ", intEnum=" + this.intEnum + ')';
    }

    public IDLParamField(boolean z, String str, KClass<? extends XBaseModel> kClass, KClass<? extends Object> kClass2, boolean z2, boolean z3, IDLDefaultValue iDLDefaultValue, Class<?> cls, List<String> list, List<Integer> list2) {
        Intrinsics.checkNotNullParameter(str, "keyPath");
        Intrinsics.checkNotNullParameter(kClass, "nestedClassType");
        Intrinsics.checkNotNullParameter(kClass2, "primitiveClassType");
        Intrinsics.checkNotNullParameter(iDLDefaultValue, "defaultValue");
        Intrinsics.checkNotNullParameter(cls, ThrowableDisposer.ConfItem.RETURN_TYPE);
        Intrinsics.checkNotNullParameter(list, "stringEnum");
        Intrinsics.checkNotNullParameter(list2, "intEnum");
        this.required = z;
        this.keyPath = str;
        this.nestedClassType = kClass;
        this.primitiveClassType = kClass2;
        this.isEnum = z2;
        this.isGetter = z3;
        this.defaultValue = iDLDefaultValue;
        this.returnType = cls;
        this.stringEnum = list;
        this.intEnum = list2;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final String getKeyPath() {
        return this.keyPath;
    }

    public /* synthetic */ IDLParamField(boolean z, String str, KClass kClass, KClass kClass2, boolean z2, boolean z3, IDLDefaultValue iDLDefaultValue, Class cls, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? Reflection.getOrCreateKotlinClass(XBaseModel.Default.class) : kClass, (i & 8) != 0 ? Reflection.getOrCreateKotlinClass(Object.class) : kClass2, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? new IDLDefaultValue(null, 0.0d, null, 0, false, 0L, 63, null) : iDLDefaultValue, cls, (i & 256) != 0 ? CollectionsKt.emptyList() : list, (i & 512) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final KClass<? extends XBaseModel> getNestedClassType() {
        return this.nestedClassType;
    }

    public final KClass<? extends Object> getPrimitiveClassType() {
        return this.primitiveClassType;
    }

    public final boolean isEnum() {
        return this.isEnum;
    }

    public final boolean isGetter() {
        return this.isGetter;
    }

    public final IDLDefaultValue getDefaultValue() {
        return this.defaultValue;
    }

    public final Class<?> getReturnType() {
        return this.returnType;
    }

    public final List<String> getStringEnum() {
        return this.stringEnum;
    }

    public final List<Integer> getIntEnum() {
        return this.intEnum;
    }
}
