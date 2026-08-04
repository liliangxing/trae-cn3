# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "HtmlArtifactRemoteArchiveUrlResolver.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method public static synthetic $r8$lambda$WJlaivRNP0z6XSvpsolIL6F6cxY(kotlinx.coroutines.channels.ProducerScope  int  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->invokeSuspend$lambda$4(Lkotlinx/coroutines/channels/ProducerScope; I Ljava/lang/String; Z)V
    return-void 
.end method

.method public static synthetic $r8$lambda$xKJ_VMfDH6Mx761dFxLDGhF-dKs(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetMessageListener)kotlin.Unit
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->invokeSuspend$lambda$5(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetMessageListener;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method private static final invokeSuspend$lambda$4(kotlinx.coroutines.channels.ProducerScope  int  java.lang.String  boolean)void
    .registers 8
    # ins_size=4
    const-string v7, "HtmlArtifactRemoteArchiveUrlResolver"
    const-string/jumbo v0, ws proto=9 parse sandbox status failed: data=
    const-string/jumbo v1, ws proto=9 raw sandbox status: data=
    const/16 v2, 9
    if-eq v5, v2, +003h
    return-void 
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v7, v1, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v5
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v5, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v5, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v5
    const-class v1, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    invoke-virtual v5, v6, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v1
    if-eqz v1, +026h
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v7, v6, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v6
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v5, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    const/4 v5, 0
    check-cast v5, Lcom/bytedance/trae/conversation/products/RealtimeSandboxStatusUpdate;
    if-nez v5, +003h
    return-void 
    invoke-interface v4, v5, Lkotlinx/coroutines/channels/ProducerScope;->trySend-JP2dKIU(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0xd
    :try_start_0x31
    :try_start_0x57
.end method

.method private static final invokeSuspend$lambda$5(com.bytedance.trae.network.HubNetConnection  com.bytedance.trae.network.HubNetMessageListener)kotlin.Unit
    .registers 2
    # ins_size=2
    if-eqz v0, +005h
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HubNetConnection;->unregisterMessageListener(Lcom/bytedance/trae/network/HubNetMessageListener;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/channels/ProducerScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->invoke(Lkotlinx/coroutines/channels/ProducerScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.channels.ProducerScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +35h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lkotlinx/coroutines/channels/ProducerScope;
    sget-object v1, Lcom/bytedance/trae/im/network/INetworkDepend;->Companion Lcom/bytedance/trae/im/network/INetworkDepend$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/im/network/INetworkDepend$Companion;->getInstance()Lcom/bytedance/trae/im/network/INetworkDepend;
    move-result-object v1
    invoke-interface v1, Lcom/bytedance/trae/im/network/INetworkDepend;->getHubNetConnection()Lcom/bytedance/trae/network/HubNetConnection;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0;
    invoke-direct v3, v6, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda0;-><init>(Lkotlinx/coroutines/channels/ProducerScope;)V
    if-eqz v1, +005h
    invoke-virtual v1, v3, Lcom/bytedance/trae/network/HubNetConnection;->registerMessageListener(Lcom/bytedance/trae/network/HubNetMessageListener;)V
    new-instance v4, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;
    invoke-direct v4, v1, v3, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/network/HubNetConnection; Lcom/bytedance/trae/network/HubNetMessageListener;)V
    move-object v1, v5
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/products/DefaultHtmlArtifactRemoteSandboxStatusSource$updates$1;->label I
    invoke-static v6, v4, v1, Lkotlinx/coroutines/channels/ProduceKt;->awaitClose(Lkotlinx/coroutines/channels/ProducerScope; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
