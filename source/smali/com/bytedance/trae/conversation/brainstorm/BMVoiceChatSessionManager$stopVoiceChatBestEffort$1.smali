# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field final synthetic $sceneId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  com.bytedance.trae.conversation.voice.network.StartVoiceChatData  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$sceneId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$sceneId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->label I
    const/4 v2, 1
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +49h
    move-exception v11
    goto +3dh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$conversationId Ljava/lang/String;
    iget-object v3, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v3
    iget-object v4, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$sceneId Ljava/lang/String;
    iget-object v5, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v6
    iget-object v7, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v7
    iget-object v8, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getPpeEnv$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v8
    move-object v9, v10
    check-cast v9, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopVoiceChatBestEffort$1;->label I
    move-object v2, v11
    invoke-virtual/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +00dh
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "BMVoiceChatSession"
    const-string/jumbo v2, stopVoiceChat after join refused failed
    invoke-virtual v0, v1, v2, v11, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    :try_start_0xb
    :try_start_0x1c
.end method
