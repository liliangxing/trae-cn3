# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $localTaskId:Ljava/lang/String;
.field final synthetic $proxyConvId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$proxyConvId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$localTaskId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$proxyConvId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$localTaskId Ljava/lang/String;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lkotlinx/coroutines/CoroutineScope;
    iget-object v7, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$proxyConvId Ljava/lang/String;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->$localTaskId Ljava/lang/String;
    sget-object v3, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v3, Lcom/bytedance/trae/im/service/ICancelTaskApi;->Companion Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;
    new-instance v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1;
    const/4 v5, 0
    invoke-direct v4, v7, v1, v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1$1$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    iput v2, v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$maybeCancelClientProxyTask$1;->label I
    invoke-virtual v3, v4, v6, Lcom/bytedance/trae/im/service/ICancelTaskApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v7
    if-eqz v7, +00bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "VoiceSubTaskCoord"
    const-string v2, "maybeCancelClientProxyTask: bg cancel failed"
    invoke-virtual v0, v1, v2, v7, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
    :try_start_0xb
    :try_start_0x22
.end method
