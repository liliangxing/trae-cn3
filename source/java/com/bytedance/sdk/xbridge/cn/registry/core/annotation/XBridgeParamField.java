package com.bytedance.sdk.xbridge.cn.registry.core.annotation;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: XBridgeParamField.kt */
@Target({ElementType.METHOD})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\u0002\u0018\u00002\u00020\u0001BV\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000eR\u000f\u0010\r\u001a\u00020\u000e¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u000f\u0010\u000b\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0010R\u000f\u0010\f\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0011R\u0017\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0012R\u0017\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0007¢\u0006\u0006\u001a\u0004\b\t\u0010\u0012R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeParamField;", "", "required", "", "keyPath", "", "nestedClassType", "Lkotlin/reflect/KClass;", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/XBaseModel;", "primitiveClassType", "", "isEnum", "isGetter", "defaultValue", "Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeDefaultValue;", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeDefaultValue;", "()Z", "()Ljava/lang/String;", "()Ljava/lang/Class;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes5.dex */
public @interface XBridgeParamField {
    XBridgeDefaultValue defaultValue() default @XBridgeDefaultValue;

    boolean isEnum() default false;

    boolean isGetter() default true;

    String keyPath() default "";

    Class<? extends XBaseModel> nestedClassType() default XBaseModel.Default.class;

    Class<? extends Object> primitiveClassType() default Object.class;

    boolean required() default false;
}
