# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/LoggerImpl;
.super Ljava/lang/Object;
.source "LoggerImpl.kt"

.implements Lcom/bytedance/trae/utils/logger/ILogger;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public d(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public e(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->e(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public e(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public getDirPath()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, Lcom/bytedance/trae/apm/impl/Logger;->getDirPath()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public i(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, Lcom/bytedance/trae/apm/impl/Logger;->isDebug()Z
    move-result v0
    return v0
.end method

.method public isInitSuccess()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, Lcom/bytedance/trae/apm/impl/Logger;->isInitSuccess()Z
    move-result v0
    return v0
.end method

.method public perfSceneTraceStart(java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    const-string/jumbo v2, tag
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public perfTSceneTraceEnd(java.lang.String  java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=4
    const-string/jumbo v2, tag
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public perfTraceLog(java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, tag
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public uploadALog(java.lang.String  long  long  kotlin.jvm.functions.Function1)void
    .registers 15
    # ins_size=7
    const-string/jumbo v0, scene
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    move-object v2, v9
    move-wide v3, v10
    move-wide v5, v12
    move-object v7, v14
    invoke-virtual/range v1 ... v7, Lcom/bytedance/trae/apm/impl/Logger;->uploadALog(Ljava/lang/String; J J Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public uploadAllLog(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->uploadAllLog(Ljava/lang/String; Lkotlin/jvm/functions/Function1;)V
    return-void 
.end method

.method public uploadAllLogV2(java.lang.String  kotlin.jvm.functions.Function3)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->uploadAllLogV2(Ljava/lang/String; Lkotlin/jvm/functions/Function3;)V
    return-void 
.end method

.method public v(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->v(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method

.method public w(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/apm/impl/Logger;->w(Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
.end method
