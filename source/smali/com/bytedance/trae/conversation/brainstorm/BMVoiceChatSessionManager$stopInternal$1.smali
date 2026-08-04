# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $current:Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
.field final synthetic $forceCleanup:Z
.field final synthetic $sceneId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.network.StartVoiceChatData  boolean  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iput-boolean v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$forceCleanup Z
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$sceneId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    iget-boolean v2, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$forceCleanup Z
    iget-object v3, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$sceneId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;-><init>(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Z Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 22
    # ins_size=2
    move-object/from16 v1, v20
    const-string/jumbo v0, stopVoiceChat request: scene=
    const-string/jumbo v2, stopVoiceChat success: room=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->label I
    const-string v5, ", task="
    const/4 v6, 1
    const-string v7, "access$getAppContext$p(...)"
    const-string v8, "leaveRoom after stopInternal: room="
    const/4 v9, 0
    const-string v10, "BMVoiceChatSession"
    if-eqz v4, +014h
    if-ne v4, v6, +00ah
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +097h
    move-exception v0
    goto/16 +0efh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v21, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v9
    if-eqz v4, +0a3h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +09bh
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +093h
    iget-boolean v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$forceCleanup Z
    if-nez v4, +08fh
    sget-object v4, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v11, Ljava/lang/StringBuilder;
    invoke-direct v11, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$sceneId Ljava/lang/String;
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v11, ", room="
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, v10, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v12
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v13
    iget-object v14, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$sceneId Ljava/lang/String;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v15
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v16
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v17
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getPpeEnv$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v18
    move-object/from16 v19, v1
    check-cast v19, Lkotlin/coroutines/Continuation;
    iput v6, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->label I
    invoke-virtual/range v11 ... v19, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->stopVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getAppContext$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->stop(Landroid/content/Context;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Stopped Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    goto +15h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string/jumbo v3, stopVoiceChat failed
    invoke-virtual v2, v10, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v3, -037h
    goto -3dh
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->$current Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v3, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v10, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->leaveRoom()V
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getAppContext$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Landroid/content/Context;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->stop(Landroid/content/Context;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$stopInternal$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->Stopped Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    throw v0
    :try_start_0x1c
    :try_start_0x2f
    :try_start_0x111
.end method
