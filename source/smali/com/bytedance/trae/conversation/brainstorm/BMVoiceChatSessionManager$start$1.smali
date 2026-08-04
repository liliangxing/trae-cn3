# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BMVoiceChatSessionManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $listener:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.field final synthetic $sceneId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$sceneId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$sceneId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 27
    # ins_size=2
    move-object/from16 v1, v25
    const-string v0, ", taskId="
    const-string v2, ", roomId="
    const-string v3, "VolcRtcClient.join returned: joined="
    const-string/jumbo v4, startVoiceChat success: appId=
    const-string/jumbo v5, startVoiceChat returns invalid data: 
    const-string/jumbo v6, startVoiceChat failed: code=
    const-string/jumbo v7, startVoiceChat request: scene=
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v8
    iget v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->label I
    const-string v10, "BMVoiceChatSession"
    const/4 v11, 1
    if-eqz v9, +015h
    if-ne v9, v11, +00bh
    invoke-static/range v26, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v7, v26
    goto +71h
    move-exception v0
    goto/16 +299h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static/range v26, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v12, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->API_REQUEST_START Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v13
    invoke-static v9, v12, v13, v14, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitPerfTimestamp(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J)V
    sget-object v9, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v12, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v13, Ljava/lang/StringBuilder;
    invoke-direct v13, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$sceneId Ljava/lang/String;
    invoke-virtual v13, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v13, ", conversationId="
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    iget-object v13, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v13, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v13
    invoke-virtual v7, v13, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-static v12, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-virtual v9, v10, v7, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v12, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getConversationId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v13
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getXAppId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v14
    iget-object v15, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$sceneId Ljava/lang/String;
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    move-object/from16 v22, v1
    check-cast v22, Lkotlin/coroutines/Continuation;
    const/16 v23, 504
    const/16 v24, 0
    iput v11, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->label I
    invoke-static/range v12 ... v24, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v8, +003h
    return-object v8
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v8, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v9, 0
    if-nez v8, +042h
    const-string v0, "null cannot be cast to non-null type com.bytedance.trae.network.response.HttpDataResult.Error"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    new-instance v0, Ljava/lang/RuntimeException;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", msg="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", cause="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getThrowable()Ljava/lang/Throwable;
    move-result-object v3
    if-eqz v3, +006h
    invoke-virtual v3, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v2, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v2, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    throw v0
    move-object v6, v7
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    if-eqz v6, +1b9h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    const/4 v12, 0
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v12
    goto +2h
    move v8, v11
    if-nez v8, +1a4h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v12
    goto +2h
    move v8, v11
    if-nez v8, +190h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v12
    goto +2h
    move v8, v11
    if-nez v8, +17ch
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    if-eqz v8, +00bh
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v12
    goto +2h
    move v8, v11
    if-nez v8, +168h
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getAppId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v8, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", userId="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getUserId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", botName="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotName()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", botUserId="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getBotUserId()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", hasSubTaskConfig="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getSubTaskConfig()Lcom/bytedance/trae/conversation/voice/network/VoiceSubTaskConfig;
    move-result-object v8
    if-eqz v8, +004h
    move v8, v11
    goto +2h
    move v8, v12
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", tokenLength="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v8
    const-string v13, ""
    if-nez v8, +003h
    move-object v8, v13
    invoke-virtual v8, Ljava/lang/String;->length()I
    move-result v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    const-string v8, ", tokenHash="
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getToken()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v13, v8
    invoke-virtual v13, Ljava/lang/String;->hashCode()I
    move-result v8
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v7, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v5, v10, v4, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->API_REQUEST_END_JOIN_ROOM_START Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v7
    invoke-static v4, v5, v7, v8, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitPerfTimestamp(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J)V
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService;->Companion Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getAppContext$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Landroid/content/Context;
    move-result-object v5
    const-string v7, "access$getAppContext$p(...)"
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v5, v12, Lcom/bytedance/trae/conversation/brainstorm/BrainstormVoiceForegroundService$Companion;->start(Landroid/content/Context; Z)Z
    move-result v4
    if-eqz v4, +0a3h
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v4, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$setVoiceChat$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    iget-object v4, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getUiScope$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->$listener Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v4, v5, v6, v7, v9, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lkotlin/coroutines/Continuation;)V
    move-object/from16 v16, v4
    check-cast v16, Lkotlin/jvm/functions/Function2;
    const/16 v17, 3
    const/16 v18, 0
    invoke-static/range v13 ... v18, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    sget-object v4, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->INSTANCE Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;
    iget-object v5, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getRtcListener$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
    sget-object v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;->Brainstorm Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;
    invoke-virtual v4, v6, v5, v7, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient;->join$conversation_mainlandRelease(Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$CallerType;)Z
    move-result v4
    sget-object v5, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v7, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    if-eqz v4, +003h
    move v12, v11
    invoke-virtual v8, v12, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getRoomId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v2, ", micMutedRequested="
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getMicMutedRequested$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Z
    move-result v2
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v7, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v10, v0, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    if-nez v4, +025h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const-string v3, "VolcRtcClient busy, refuse to start brainstorm voice"
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v10, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v2, Ljava/lang/IllegalStateException;
    const-string v3, "Another voice session is active, cannot start brainstorm"
    invoke-direct v2, v3, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Throwable;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitError(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$handleJoinRefused(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->JoiningRoom Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    goto +4ch
    new-instance v0, Ljava/lang/RuntimeException;
    const-string/jumbo v2, voice foreground service start failed
    invoke-direct v0, v2, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    throw v0
    new-instance v0, Ljava/lang/RuntimeException;
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v2, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitError(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/Throwable;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v3, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string/jumbo v5, stopInternal caller: start() catch block, error=
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v10, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$start$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v11, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$stopInternal(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
    :try_start_0x21
    :try_start_0x35
    :try_start_0x1b3
.end method
