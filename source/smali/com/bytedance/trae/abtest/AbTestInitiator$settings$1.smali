# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/abtest/AbTestInitiator$settings$1;
.super Ljava/lang/Object;
.source "AbTestInitiator.kt"

.implements Lcom/bytedance/dataplatform/ISettings;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getValue(java.lang.String  java.lang.reflect.Type  java.lang.Object)java.lang.Object
    .registers 4
    # ins_size=4
    const-string/jumbo v1, tClass
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    return-object v1
.end method
