# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/interceptor/HttpEnvInterceptor;
.super Ljava/lang/Object;
.source "HttpEnvInterceptor.kt"

.implements Lcom/bytedance/retrofit2/intercept/Interceptor;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public intercept(com.bytedance.retrofit2.intercept.Interceptor$Chain)com.bytedance.retrofit2.SsResponse
    .registers 11
    # ins_size=2
    if-eqz v10, +0e4h
    invoke-interface v10, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0dch
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->isAddCommonParam()Z
    invoke-interface v10, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v1
    const-string/jumbo v2, x-use-ppe
    invoke-virtual v1, v2, Lcom/bytedance/retrofit2/client/Request;->headers(Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    if-nez v1, +0bfh
    invoke-interface v10, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->request()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v1
    const-string/jumbo v3, x-use-boe
    invoke-virtual v1, v3, Lcom/bytedance/retrofit2/client/Request;->headers(Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    if-eqz v1, +004h
    goto/16 +0b0h
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    sget-object v4, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v4, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnable()Z
    move-result v4
    const-string/jumbo v5, x-tt-env
    const/4 v6, 1
    const/4 v7, 0
    const-string v8, "1"
    if-eqz v4, +033h
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v2, v3, v8, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v2, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v2, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnv()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    goto +2h
    move v6, v7
    if-eqz v6, +051h
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    sget-object v3, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnv()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v5, v3, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto +3dh
    sget-object v3, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnable()Z
    move-result v3
    if-eqz v3, +032h
    new-instance v3, Lcom/bytedance/retrofit2/client/Header;
    invoke-direct v3, v2, v8, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v2, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v2, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnv()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    goto +2h
    move v6, v7
    if-eqz v6, +014h
    new-instance v2, Lcom/bytedance/retrofit2/client/Header;
    sget-object v3, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnv()Ljava/lang/String;
    move-result-object v3
    invoke-direct v2, v5, v3, Lcom/bytedance/retrofit2/client/Header;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v2
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->getHeaders()Ljava/util/List;
    move-result-object v0
    const-string v3, "getHeaders(...)"
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/util/Collection;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v0
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v2, v0, Lcom/bytedance/retrofit2/client/Request$Builder;->headers(Ljava/util/List;)Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v10, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v10
    return-object v10
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request;->newBuilder()Lcom/bytedance/retrofit2/client/Request$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/retrofit2/client/Request$Builder;->build()Lcom/bytedance/retrofit2/client/Request;
    move-result-object v0
    invoke-interface v10, v0, Lcom/bytedance/retrofit2/intercept/Interceptor$Chain;->proceed(Lcom/bytedance/retrofit2/client/Request;)Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v10
    return-object v10
    const/4 v10, 0
    return-object v10
.end method
