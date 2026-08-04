# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field final synthetic $sceneId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.network.StartVoiceChatData  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$sceneId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$sceneId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=2
    move-object/from16 v1, v17
    const-string v0, "release stopVoiceChat request: scene="
    const-string v2, "release stopVoiceChat success: room="
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->label I
    const-string v5, ", task="
    const/4 v6, 1
    const-string v7, "BMVoiceChatSession"
    if-eqz v4, +014h
    if-ne v4, v6, +00ah
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +08fh
    move-exception v0
    goto/16 +0b8h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v18, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +09fh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +097h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +08fh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$sceneId Ljava/lang/String;
    invoke-virtual v8, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v8, ", room="
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v8, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v0, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v7, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v8, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v9
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v10
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$sceneId Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v12
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v13
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v14
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getPpeEnv$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v15
    move-object/from16 v16, v1
    check-cast v16, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->label I
    invoke-virtual/range v8 ... v16, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v7, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->releaseFinally()V
    goto +ah
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, stopVoiceChat on release failed
    invoke-virtual v2, v7, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto -eh
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$release$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->releaseFinally()V
    throw v0
    :try_start_0x15
    :try_start_0x28
    :try_start_0xd3
.end method
