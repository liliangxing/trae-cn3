# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginConnectorOAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $onComplete:Lkotlin/jvm/functions/Function1;
.field final synthetic $provider:Ljava/lang/String;
.field final synthetic $service:Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
.field final synthetic $transactionId:Ljava/lang/String;
.field  I$0:I
.field  I$1:I
.field  label:I


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$transactionId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$onComplete Lkotlin/jvm/functions/Function1;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$transactionId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$onComplete Lkotlin/jvm/functions/Function1;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->label I
    const/4 v3, 4
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 0
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v0, +045h
    if-eq v0, v7, +03ah
    if-eq v0, v5, +022h
    if-eq v0, v4, +016h
    if-ne v0, v3, +00ch
    iget v9, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iget v10, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    goto/16 +163h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget v9, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iget v10, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    goto/16 +0d8h
    iget v9, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iget v10, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v18
    move-object v11, v1
    move/from16 v16, v10
    move v10, v9
    move/from16 v9, v16
    goto/16 +068h
    move-exception v0
    move v11, v10
    move-object v10, v1
    goto/16 +14eh
    iget v0, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iget v9, v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v1
    goto +2ah
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v10, v1
    move v0, v6
    move v9, v7
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getPendingProvider$p()Ljava/lang/String;
    move-result-object v11
    iget-object v12, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +164h
    if-eqz v9, +005h
    move v9, v0
    move v11, v6
    goto +15h
    move-object v11, v10
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v9, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    iput v0, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iput v7, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->label I
    const-wide/16 v12, 1000
    invoke-static v12, v13, v11, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v2, +003h
    return-object v2
    move v11, v9
    move v9, v0
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getPendingProvider$p()Ljava/lang/String;
    move-result-object v0
    iget-object v12, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    invoke-static v0, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +13fh
    iget-object v0, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    new-instance v12, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollRequest;
    iget-object v13, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    iget-object v14, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$transactionId Ljava/lang/String;
    invoke-direct v12, v13, v14, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    move-object v13, v10
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput v11, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    iput v9, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iput v5, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->label I
    invoke-interface v0, v12, v13, Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;->pollAuth(Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object/from16 v16, v10
    move v10, v9
    move v9, v11
    move-object/from16 v11, v16
    check-cast v0, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollResponse;
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollResponse;->getStatus()Ljava/lang/String;
    move-result-object v10
    goto +8h
    move-exception v0
    move-object v10, v11
    move v11, v9
    move v9, v6
    goto/16 +0deh
    move-object v10, v8
    if-eqz v10, +0ceh
    invoke-virtual v10, Ljava/lang/String;->hashCode()I
    move-result v12
    const v13, -591252731
    if-eq v12, v13, +05bh
    const v13, 1818119806
    if-eq v12, v13, +04dh
    const v0, 1925346054
    if-eq v12, v0, +004h
    goto/16 +0b9h
    const-string v0, "ACTIVE"
    invoke-virtual v10, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0afh
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getLock$p()Ljava/lang/Object;
    move-result-object v10
    monitor-enter v10
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$setPendingProvider$p(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v10
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1$2;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$onComplete Lkotlin/jvm/functions/Function1;
    invoke-direct v10, v12, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1$2;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    move-object v12, v11
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput v9, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    iput v6, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iput v4, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->label I
    invoke-static v0, v10, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move v10, v9
    move v9, v6
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    move-object/from16 v16, v11
    move v11, v10
    goto/16 +081h
    move-exception v0
    monitor-exit v10
    throw v0
    const-string v12, "REVOKED"
    invoke-virtual v10, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +00ch
    goto +6bh
    const-string v12, "EXPIRED"
    invoke-virtual v10, v12, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v10
    if-nez v10, +003h
    goto +62h
    sget-object v10, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, Ljava/lang/StringBuilder;-><init>()V
    const-string v14, "qrcode_poll_"
    invoke-virtual v13, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v13
    invoke-virtual v0, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthPollResponse;->getStatus()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v14, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v14, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v14, toLowerCase(...)
    invoke-static v0, v14, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v13, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v10, v12, v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getLock$p()Ljava/lang/Object;
    move-result-object v10
    monitor-enter v10
    sget-object v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$setPendingProvider$p(Ljava/lang/String;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v10
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1$4;
    iget-object v12, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$onComplete Lkotlin/jvm/functions/Function1;
    invoke-direct v10, v12, v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1$4;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v10, Lkotlin/jvm/functions/Function2;
    move-object v12, v11
    check-cast v12, Lkotlin/coroutines/Continuation;
    iput v9, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$0 I
    iput v6, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->I$1 I
    iput v3, v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->label I
    invoke-static v0, v10, v12, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move v10, v9
    move v9, v6
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    monitor-exit v10
    throw v0
    move v0, v6
    move-object v10, v11
    goto/16 -132h
    move-exception v0
    move-object/from16 v16, v11
    move v11, v9
    move v9, v10
    move-object/from16 v10, v16
    goto +2h
    move-exception v0
    instance-of v12, v0, Ljava/util/concurrent/CancellationException;
    if-nez v12, +02eh
    add-int/2addr v9, v7
    const/4 v12, 5
    if-ne v9, v12, +026h
    sget-object v12, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v13, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startPolling$result$1;->$provider Ljava/lang/String;
    new-instance v14, Ljava/lang/StringBuilder;
    const-string v15, "qrcode_poll_network_error:"
    invoke-direct v14, v15, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +009h
    const/16 v15, 80
    invoke-static v0, v15, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v8
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v12, v13, v0, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    move v0, v9
    move v9, v11
    goto/16 -16bh
    throw v0
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x1c
    :try_start_0x2e
    :try_start_0x38
    :try_start_0x8a
    :try_start_0xab
    :try_start_0xaf
    :try_start_0xe1
    :try_start_0xe8
    :try_start_0x10a
    :try_start_0x114
    :try_start_0x15a
    :try_start_0x161
    :try_start_0x183
    :try_start_0x187
.end method
