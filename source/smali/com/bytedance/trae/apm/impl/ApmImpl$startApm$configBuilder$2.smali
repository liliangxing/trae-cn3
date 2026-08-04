# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$2;
.super Ljava/lang/Object;
.source "ApmImpl.kt"

.implements Lcom/bytedance/apm/core/IDynamicParams;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getCommonParams()java.util.Map
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/util/HashMap;
    sget-object v1, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getDynamicParams()Ljava/util/Map;
    move-result-object v1
    invoke-direct v0, v1, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V
    check-cast v0, Ljava/util/Map;
    return-object v0
.end method

.method public getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getSessionId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getUid()long
    .registers 4
    # ins_size=1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$2;
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getUserID()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    const-wide/16 v1, 0
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v0, v1
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
    :try_start_0x0
.end method
