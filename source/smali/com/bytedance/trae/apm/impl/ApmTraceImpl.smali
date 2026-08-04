# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmTraceImpl;
.super Ljava/lang/Object;
.source "ApmTraceImpl.kt"

.implements Lcom/bytedance/trae/apm/api/IApmTrace;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public addPerfTag(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/apm/ApmAgent;->addPerfTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public addTag(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/crash/Npth;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public reportApmEvent(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "category"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, v4, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public reportTeaEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public startApmScene(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm6/cpu/ApmCpuManager;->getInstance()Lcom/bytedance/apm6/cpu/ApmCpuManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/apm6/cpu/ApmCpuManager;->startScene(Ljava/lang/String;)V
    return-void 
.end method

.method public stopApmScene(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm6/cpu/ApmCpuManager;->getInstance()Lcom/bytedance/apm6/cpu/ApmCpuManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/apm6/cpu/ApmCpuManager;->stopScene(Ljava/lang/String;)V
    return-void 
.end method

.method public traceAll(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/apm/ApmAgent;->addPerfTag(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v2, v3, Lcom/bytedance/crash/Npth;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
