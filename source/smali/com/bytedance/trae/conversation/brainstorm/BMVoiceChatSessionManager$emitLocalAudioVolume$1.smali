# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $l:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.field final synthetic $normalized:F
.field  label:I


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  float  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iput v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$normalized F
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$normalized F
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; F Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->label I
    if-nez v0, +00fh
    invoke-static v2, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$l Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$emitLocalAudioVolume$1;->$normalized F
    invoke-interface v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;->onLocalAudioVolume(F)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v2, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v2
.end method
