# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/GodzillaImpl$init$2;
.super Ljava/lang/Object;
.source "GodzillaImpl.kt"

.implements Lcom/bytedance/platform/godzilla/common/IReflectHackHelper;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getField(java.lang.Class  java.lang.String)java.lang.reflect.Field
    .registers 4
    # ins_size=3
    const-string v0, "fieldName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/platform/godzilla/common/DoubleReflectHelper;->getField(Ljava/lang/Class; Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v2
    const-string v3, "getField(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method

.method public varargs getMethod(java.lang.Class  java.lang.String  java.lang.Class[])java.lang.reflect.Method
    .registers 5
    # ins_size=4
    const-string v0, "methodName"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    array-length v0, v4
    invoke-static v4, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v4
    check-cast v4, [Ljava/lang/Class;
    invoke-static v2, v3, v4, Lcom/bytedance/platform/godzilla/common/DoubleReflectHelper;->getMethod(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v2
    const-string v3, "getMethod(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v2
.end method
