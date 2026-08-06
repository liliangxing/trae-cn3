package com.bytedance.timon.pipeline;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: ComponentDeps.kt */
@Target({ElementType.TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0002\u0018\u00002\u00020\u0001B0\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003R\u001d\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/timon/pipeline/ComponentDeps;", "", "required", "", "Lkotlin/reflect/KClass;", "Lcom/bytedance/timon/pipeline/TimonComponent;", "optional", "()[Ljava/lang/Class;", "pipeline_release"}, k = 1, mv = {1, 1, 16})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
/* loaded from: classes5.dex */
public @interface ComponentDeps {
    Class<? extends TimonComponent>[] optional() default {};

    Class<? extends TimonComponent>[] required() default {};
}
