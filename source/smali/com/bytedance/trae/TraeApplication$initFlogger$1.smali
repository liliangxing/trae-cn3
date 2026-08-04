# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/TraeApplication$initFlogger$1;
.super Ljava/lang/Object;
.source "TraeApplication.kt"

.implements Lcom/bytedance/trae/utils/logger/ILogger;


.method constructor <init>()void
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
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, Landroid/util/Log;->d(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public e(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public e(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, v4, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
.end method

.method public getDirPath()java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, ""
    return-object v0
.end method

.method public i(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, Landroid/util/Log;->i(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public isDebug()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isInitSuccess()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
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
    .registers 7
    # ins_size=7
    const-string/jumbo v2, scene
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public uploadAllLog(java.lang.String  kotlin.jvm.functions.Function1)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, scene
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public uploadAllLogV2(java.lang.String  kotlin.jvm.functions.Function3)void
    .registers 3
    # ins_size=3
    const-string/jumbo v2, scene
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public v(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, Landroid/util/Log;->v(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public w(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String;)I
    return-void 
.end method

.method public w(java.lang.String  java.lang.String  java.lang.Throwable)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +004h
    const-string v3, ""
    invoke-static v2, v3, v4, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
.end method

.method public w(java.lang.String  java.lang.Throwable)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, tag
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Landroid/util/Log;->w(Ljava/lang/String; Ljava/lang/Throwable;)I
    return-void 
.end method
