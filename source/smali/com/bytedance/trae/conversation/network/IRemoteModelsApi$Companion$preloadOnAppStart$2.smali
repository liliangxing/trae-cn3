# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "IRemoteModelsApi.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $trigger:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  L$6:Ljava/lang/Object;
.field  L$7:Ljava/lang/Object;
.field  L$8:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 28
    # ins_size=2
    move-object/from16 v1, v26
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->label I
    const-string v3, ", functions="
    const/4 v4, 3
    const-string v5, "IRemoteModelsApi"
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v0, +07eh
    if-eq v0, v8, +05ah
    if-eq v0, v6, +047h
    if-ne v0, v4, +03dh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$8 Ljava/lang/Object;
    move-object v6, v0
    check-cast v6, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$7 Ljava/lang/Object;
    move-object v8, v0
    check-cast v8, Ljava/util/Iterator;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$6 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$5 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Lcom/bytedance/trae/im/service/Cli;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$4 Ljava/lang/Object;
    move-object v11, v0
    check-cast v11, Ljava/util/Iterator;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$3 Ljava/lang/Object;
    move-object v12, v0
    check-cast v12, Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$2 Ljava/lang/Object;
    move-object v13, v0
    check-cast v13, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$1 Ljava/lang/Object;
    move-object v14, v0
    check-cast v14, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    move-object v15, v0
    check-cast v15, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v27
    move v7, v4
    move-object v4, v1
    goto/16 +285h
    move-exception v0
    move v7, v4
    move-object v4, v1
    goto/16 +293h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v27
    move-object v12, v1
    goto/16 +0fbh
    move-exception v0
    move-object v12, v1
    goto/16 +0ffh
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$3 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$2 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Ljava/util/Iterator;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$1 Ljava/lang/Object;
    move-object v11, v0
    check-cast v11, Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    move-object v12, v0
    check-cast v12, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v27
    move-object v13, v12
    move-object v12, v1
    goto/16 +082h
    move-exception v0
    move-object v13, v12
    move-object v12, v1
    goto/16 +08ch
    invoke-static/range v27, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    sget-object v9, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "preloadOnAppStart: start, trigger="
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v11, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v9, v5, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-array v9, v6, [Ljava/util/List;
    const-string/jumbo v10, solo_agent_remote
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    aput-object v10, v9, v7
    const-string/jumbo v10, solo_work_remote
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    aput-object v10, v9, v8
    invoke-static v9, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    iget-object v10, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    move-object v12, v1
    move-object v11, v10
    move-object v10, v9
    move-object v9, v0
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +074h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v13, v0
    check-cast v13, Ljava/util/List;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v14, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v15, "_remote"
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    iput-object v9, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    iput-object v11, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$1 Ljava/lang/Object;
    iput-object v10, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$2 Ljava/lang/Object;
    iput-object v13, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$3 Ljava/lang/Object;
    iput v8, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->label I
    invoke-virtual v0, v13, v14, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchModelsForUi(Ljava/util/List; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object/from16 v25, v13
    move-object v13, v9
    move-object/from16 v9, v25
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +13h
    move-exception v0
    goto +7h
    move-exception v0
    move-object/from16 v25, v13
    move-object v13, v9
    move-object/from16 v9, v25
    sget-object v14, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +01eh
    sget-object v14, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v15, Ljava/lang/StringBuilder;
    const-string v4, "preloadOnAppStart: remote preload failed, trigger="
    invoke-direct v15, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v14, v5, v4, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    move-object v9, v13
    const/4 v4, 3
    goto -77h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    iput-object v9, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    const/4 v4, 0
    iput-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$1 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$2 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$3 Ljava/lang/Object;
    iput v6, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->label I
    invoke-virtual v0, v12, Lcom/bytedance/trae/conversation/CliListRepository;->getClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    iget-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v10
    if-nez v10, +003h
    goto +19h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v11, Ljava/lang/StringBuilder;
    const-string v13, "preloadOnAppStart: list clis failed, trigger="
    invoke-direct v11, v13, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v5, v4, v10, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    new-array v4, v6, [Lkotlin/Pair;
    sget-object v10, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v10
    new-array v6, v6, [Ljava/util/List;
    const-string/jumbo v11, solo_agent_lite
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    aput-object v11, v6, v7
    const-string/jumbo v11, solo_work_lite
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    aput-object v11, v6, v8
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    invoke-static v10, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v4, v7
    sget-object v6, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v6, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v6
    const-string/jumbo v10, solo_agent
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-static v10, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    invoke-static v6, v10, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v4, v8
    invoke-static v4, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v4
    move-object v6, v0
    check-cast v6, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    invoke-direct v10, Ljava/util/ArrayList;-><init>()V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +03eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v13, v11
    check-cast v13, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v13, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v14
    sget-object v15, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v15
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-nez v14, +012h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v14
    sget-object v15, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v15, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v15
    invoke-static v14, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +010h
    invoke-virtual v13, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v13
    const-string v14, "online"
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +004h
    move v13, v8
    goto +2h
    move v13, v7
    if-eqz v13, -03ch
    invoke-interface v10, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -41h
    check-cast v10, Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    iget-object v6, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +100h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +004h
    const-string v11, ""
    move-object v13, v11
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    if-nez v13, +0e4h
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v13
    invoke-interface v4, v13, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Ljava/util/List;
    if-nez v13, +004h
    goto/16 +0d6h
    check-cast v13, Ljava/lang/Iterable;
    invoke-interface v13, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v13
    move-object v14, v0
    move-object v15, v9
    move-object v9, v11
    move-object v11, v8
    move-object v8, v13
    move-object v13, v4
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +0c0h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v4, v0
    check-cast v4, Ljava/util/List;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v17, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v21
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v0
    sget-object v18, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual/range v18, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v7
    invoke-static v0, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object/from16 v23, v0
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v7, "_pc"
    invoke-virtual v0, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v22
    const/16 v20, 1
    iput-object v15, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$0 Ljava/lang/Object;
    iput-object v14, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$1 Ljava/lang/Object;
    iput-object v13, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$2 Ljava/lang/Object;
    iput-object v6, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$3 Ljava/lang/Object;
    iput-object v11, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$4 Ljava/lang/Object;
    iput-object v10, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$5 Ljava/lang/Object;
    iput-object v9, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$6 Ljava/lang/Object;
    iput-object v8, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$7 Ljava/lang/Object;
    iput-object v4, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->L$8 Ljava/lang/Object;
    const/4 v7, 3
    iput v7, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->label I
    move-object/from16 v18, v9
    move-object/from16 v19, v4
    move-object/from16 v24, v12
    invoke-virtual/range v17 ... v24, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchPcModelsForUi(Ljava/lang/String; Ljava/util/List; Z Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object/from16 v25, v6
    move-object v6, v4
    move-object v4, v12
    move-object/from16 v12, v25
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +17h
    move-exception v0
    goto +bh
    move-exception v0
    goto +3h
    move-exception v0
    const/4 v7, 3
    move-object/from16 v25, v6
    move-object v6, v4
    move-object v4, v12
    move-object/from16 v12, v25
    sget-object v16, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v25, v12
    move-object v12, v4
    move-object v4, v6
    move-object/from16 v6, v25
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +02bh
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    move-object/from16 v27, v2
    const-string v2, "preloadOnAppStart: pc preload failed, trigger="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, v5, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto +3h
    move-object/from16 v27, v2
    move-object/from16 v1, v26
    move-object/from16 v2, v27
    const/4 v7, 0
    goto/16 -0c2h
    move-object v8, v11
    move-object v4, v13
    move-object v0, v14
    move-object v9, v15
    move-object/from16 v1, v26
    const/4 v7, 0
    goto/16 -102h
    sget-object v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "preloadOnAppStart: end, trigger="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;->$trigger Ljava/lang/String;
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", localCliCount="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    check-cast v0, Ljava/lang/Iterable;
    instance-of v3, v0, Ljava/util/Collection;
    if-eqz v3, +00dh
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    const/4 v7, 0
    goto +26h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v7, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v3
    const-string v4, "local"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -016h
    add-int/lit8 v7, v7, 1
    if-gez v7, -01ah
    invoke-static Lkotlin/collections/CollectionsKt;->throwCountOverflow()V
    goto -1fh
    invoke-virtual v2, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v1, v5, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x45
    :try_start_0x60
    :try_start_0x80
    :try_start_0xdc
    :try_start_0x109
    :try_start_0x147
    :try_start_0x275
    :try_start_0x2bc
    :try_start_0x2d1
.end method
