# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "VoiceSubTaskCoordinator.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $config:Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.voice.subtask.ProxyConversationConfig  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->$config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->$config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;-><init>(Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v5, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->INSTANCE Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->$config Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig;
    move-object v3, v4
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v4, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$start$2;->label I
    invoke-static v5, v1, v3, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$createRemoteParentSession(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lcom/bytedance/trae/conversation/voice/subtask/ProxyConversationConfig; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method
