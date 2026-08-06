package com.bytedance.sdk.xbridge.cn.registry.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: XBridgeParamField.kt */
@Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0087\u0002\u0018\u00002\u00020\u0001B<\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\rR\u000f\u0010\n\u001a\u00020\u000b¢\u0006\u0006\u001a\u0004\b\n\u0010\u000eR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000fR\u000f\u0010\b\u001a\u00020\t¢\u0006\u0006\u001a\u0004\b\b\u0010\u0010R\u000f\u0010\f\u001a\u00020\r¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0012R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/XBridgeDefaultValue;", "", "type", "Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/DefaultType;", "doubleValue", "", "stringValue", "", "intValue", "", "boolValue", "", "longValue", "", "()Z", "()D", "()I", "()J", "()Ljava/lang/String;", "()Lcom/bytedance/sdk/xbridge/cn/registry/core/annotation/DefaultType;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes5.dex */
public @interface XBridgeDefaultValue {
    boolean boolValue() default false;

    double doubleValue() default 0.0d;

    int intValue() default 0;

    long longValue() default 0;

    String stringValue() default "";

    DefaultType type() default DefaultType.NONE;
}
