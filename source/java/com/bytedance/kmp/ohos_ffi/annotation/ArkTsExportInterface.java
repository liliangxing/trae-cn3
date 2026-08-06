package com.bytedance.kmp.ohos_ffi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;

/* compiled from: export.kt */
@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/kmp/ohos_ffi/annotation/ArkTsExportInterface;", "", "annotation_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.WARNING, message = "ArkTsExportInterface 已废弃，请使用 KotlinExportInterface", replaceWith = @ReplaceWith(expression = "KotlinExportInterface", imports = {"com.bytedance.kmp.ohos_ffi.annotation.KotlinExportInterface"}))
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.BINARY)
/* loaded from: classes4.dex */
public @interface ArkTsExportInterface {
}
