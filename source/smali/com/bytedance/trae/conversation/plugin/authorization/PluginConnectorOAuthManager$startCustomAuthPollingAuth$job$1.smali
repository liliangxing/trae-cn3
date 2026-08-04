# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginConnectorOAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $appContext:Landroid/content/Context;
.field final synthetic $onComplete:Lkotlin/jvm/functions/Function1;
.field final synthetic $provider:Ljava/lang/String;
.field final synthetic $returnTo:Ljava/lang/String;
.field final synthetic $service:Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
.field  L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  kotlin.jvm.functions.Function1  android.content.Context  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$returnTo Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$onComplete Lkotlin/jvm/functions/Function1;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$appContext Landroid/content/Context;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$returnTo Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$onComplete Lkotlin/jvm/functions/Function1;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$appContext Landroid/content/Context;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 16
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    const/4 v2, 5
    const/4 v3, 4
    const/4 v4, 3
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v1, +034h
    if-eq v1, v6, +02bh
    if-eq v1, v5, +024h
    if-eq v1, v4, +018h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +145h
    new-instance v15, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v15, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v15
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +138h
    iget-object v1, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/lang/String;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v1
    goto/16 +082h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c4h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    move-exception v15
    goto/16 +0c3h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v15, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;
    iget-object v8, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    iget-object v9, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$returnTo Ljava/lang/String;
    const-string v10, "mobile"
    invoke-direct v1, v8, v9, v10, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v8, v14
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v6, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    invoke-interface v15, v1, v8, Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;->startOAuth(Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;->getAuthorizeUrl()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v7
    if-eqz v15, +00dh
    invoke-virtual v15, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;->getMetadata()Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;
    move-result-object v15
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthMetadata;->getTransactionId()Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v7
    move-object v8, v1
    check-cast v8, Ljava/lang/CharSequence;
    const/4 v9, 0
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v9
    goto +2h
    move v8, v6
    if-nez v8, +046h
    move-object v8, v15
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00ah
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move v6, v9
    if-eqz v6, +003h
    goto +35h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v5
    check-cast v5, Lkotlin/coroutines/CoroutineContext;
    new-instance v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;
    iget-object v8, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$appContext Landroid/content/Context;
    invoke-direct v6, v1, v8, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$3;-><init>(Ljava/lang/String; Landroid/content/Context; Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function2;
    move-object v1, v14
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput-object v15, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->L$0 Ljava/lang/Object;
    iput v4, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    invoke-static v5, v6, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v11, v15
    sget-object v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    iget-object v9, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iget-object v10, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    iget-object v12, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$onComplete Lkotlin/jvm/functions/Function1;
    move-object v13, v14
    check-cast v13, Lkotlin/coroutines/Continuation;
    iput-object v7, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->L$0 Ljava/lang/Object;
    iput v3, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    invoke-static/range v8 ... v13, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$pollCustomAuth(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager; Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +099h
    return-object v0
    sget-object v15, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v1, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    const-string v3, "custom_auth_metadata_missing"
    invoke-virtual v15, v1, v3, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getLock$p()Ljava/lang/Object;
    move-result-object v15
    monitor-enter v15
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$setPendingProvider$p(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v15
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v15
    check-cast v15, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$2;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$onComplete Lkotlin/jvm/functions/Function1;
    invoke-direct v1, v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$2;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v14
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v5, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    invoke-static v15, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    move-exception v1
    monitor-exit v15
    throw v1
    instance-of v1, v15, Ljava/util/concurrent/CancellationException;
    if-nez v1, +063h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "ConnectorOAuth"
    const-string/jumbo v4, startCustomAuthPollingAuth failed
    move-object v5, v15
    check-cast v5, Ljava/lang/Throwable;
    invoke-virtual v1, v3, v4, v5, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$provider Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "custom_auth_start_error:"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v15, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v15
    if-eqz v15, +009h
    const/16 v5, 100
    invoke-static v15, v5, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v7
    invoke-virtual v4, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    invoke-virtual v1, v3, v15, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$getLock$p()Ljava/lang/Object;
    move-result-object v15
    monitor-enter v15
    sget-object v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$setPendingProvider$p(Ljava/lang/String;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v15
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v15
    check-cast v15, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$5;
    iget-object v3, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->$onComplete Lkotlin/jvm/functions/Function1;
    invoke-direct v1, v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1$5;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v14
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput-object v7, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->L$0 Ljava/lang/Object;
    iput v2, v14, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startCustomAuthPollingAuth$job$1;->label I
    invoke-static v15, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    sget-object v15, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v15
    move-exception v0
    monitor-exit v15
    throw v0
    throw v15
    :try_start_0x25
    :try_start_0x2e
    :try_start_0x43
    :try_start_0xd8
    :try_start_0xdf
    :try_start_0x13b
.end method
