# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "PluginConnectorOAuthManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $appContext:Landroid/content/Context;
.field final synthetic $onBrowserOpened:Lkotlin/jvm/functions/Function0;
.field final synthetic $provider:Ljava/lang/String;
.field final synthetic $returnTo:Ljava/lang/String;
.field final synthetic $service:Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.plugin.authorization.IConnectorOAuthApi  java.lang.String  java.lang.String  android.content.Context  kotlin.jvm.functions.Function0  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$provider Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$returnTo Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$appContext Landroid/content/Context;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$onBrowserOpened Lkotlin/jvm/functions/Function0;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$provider Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$returnTo Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$appContext Landroid/content/Context;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$onBrowserOpened Lkotlin/jvm/functions/Function0;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;-><init>(Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi; Ljava/lang/String; Ljava/lang/String; Landroid/content/Context; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->label I
    const/4 v2, 4
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v1, +027h
    if-eq v1, v5, +01eh
    if-eq v1, v4, +018h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +102h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +09eh
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +6dh
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +20h
    move-exception v11
    goto/16 +096h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$service Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;
    iget-object v7, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$provider Ljava/lang/String;
    iget-object v8, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$returnTo Ljava/lang/String;
    const-string v9, "mobile"
    invoke-direct v1, v7, v8, v9, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v7, v10
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v5, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->label I
    invoke-interface v11, v1, v7, Lcom/bytedance/trae/conversation/plugin/authorization/IConnectorOAuthApi;->startOAuth(Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/conversation/plugin/authorization/ConnectorOAuthStartResponse;->getAuthorizeUrl()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v6
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    const/4 v5, 0
    if-nez v5, +036h
    new-instance v1, Landroid/content/Intent;
    const-string v3, "android.intent.action.VIEW"
    invoke-static v11, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v11
    invoke-direct v1, v3, v11, Landroid/content/Intent;-><init>(Ljava/lang/String; Landroid/net/Uri;)V
    const/high16 v11, 268435456
    invoke-virtual v1, v11, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$appContext Landroid/content/Context;
    invoke-virtual v11, v1, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v11
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$1;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$onBrowserOpened Lkotlin/jvm/functions/Function0;
    invoke-direct v1, v3, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$1;-><init>(Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v10
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v4, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->label I
    invoke-static v11, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lkotlin/Unit;
    goto/16 +083h
    sget-object v11, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v1, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$provider Ljava/lang/String;
    const-string v4, "empty_authorize_url"
    invoke-virtual v11, v1, v4, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$clearPendingAndGetCompletion(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;)Lkotlin/jvm/functions/Function1;
    move-result-object v11
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$2;
    invoke-direct v4, v11, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$2;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    move-object v11, v10
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v3, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->label I
    invoke-static v1, v4, v11, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lkotlin/Unit;
    goto +57h
    instance-of v1, v11, Ljava/util/concurrent/CancellationException;
    if-nez v1, +057h
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, startOAuth failed
    move-object v4, v11
    check-cast v4, Ljava/lang/Throwable;
    const-string v5, "ConnectorOAuth"
    invoke-virtual v1, v5, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v1, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/PluginTracker;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->$provider Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "oauth_start_error:"
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Ljava/lang/Exception;->getMessage()Ljava/lang/String;
    move-result-object v11
    if-eqz v11, +009h
    const/16 v5, 100
    invoke-static v11, v5, Lkotlin/text/StringsKt;->take(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v6
    invoke-virtual v4, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v1, v3, v11, Lcom/bytedance/trae/conversation/tracker/PluginTracker;->trackAuthFail(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->INSTANCE Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;
    invoke-static v11, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;->access$clearPendingAndGetCompletion(Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager;)Lkotlin/jvm/functions/Function1;
    move-result-object v11
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    new-instance v3, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$3;
    invoke-direct v3, v11, v6, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1$3;-><init>(Lkotlin/jvm/functions/Function1; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    move-object v11, v10
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/plugin/authorization/PluginConnectorOAuthManager$startOAuth$job$1;->label I
    invoke-static v1, v3, v11, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lkotlin/Unit;
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    throw v11
    :try_start_0x22
    :try_start_0x35
.end method
