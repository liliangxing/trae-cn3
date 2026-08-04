# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $data:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field final synthetic $listener:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.voice.network.StartVoiceChatData  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$data Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$data Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    iget v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->label I
    if-nez v0, +045h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    if-eqz v5, +03bh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$data Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-interface v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;->onVoiceChatDataReady(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    goto +34h
    move-exception v5
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onVoiceChatDataReady forward failed: roomId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$data Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", taskId="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;->$data Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "BMVoiceChatSession"
    invoke-virtual v0, v2, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    :try_start_0xa
.end method
