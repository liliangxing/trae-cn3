# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;
.super Ljava/lang/Object;
.source "BMVoiceChatSessionManager.kt"

.implements Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAudioInputDeviceStateChanged(java.lang.String  int  int)void
    .registers 5
    # ins_size=4
    const-string v0, "deviceId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v2, v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitRtcAudioInputDeviceStateChanged(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; I I)V
    return-void 
.end method

.method public onError(java.lang.Throwable)void
    .registers 6
    # ins_size=2
    const-string v0, "error"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string/jumbo v3, rtcListener.onError: scene=
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getCurrentSceneId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", task="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    iget-object v3, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getVoiceChat$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v3, ", message="
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v5, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "BMVoiceChatSession"
    invoke-virtual v0, v2, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitError(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/Throwable;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v0, 1
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$stopInternal(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Z)V
    return-void 
.end method

.method public onJoinedRoom(java.lang.String)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, roomId
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onJoinedRoom: roomId="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", micMutedRequested="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getMicMutedRequested$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Z
    move-result v2
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", scene="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getCurrentSceneId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", task="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getVoiceChat$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v1, "BMVoiceChatSession"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->JOIN_ROOM_SUCCESS Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-static v5, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitPerfTimestamp(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;->JoinedRoom Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;
    invoke-static v5, v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitStatus(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Status;)V
    return-void 
.end method

.method public onLocalAudioLevel(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitLocalAudioVolume(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; I)V
    return-void 
.end method

.method public onLocalAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 3
    # ins_size=2
    const-string v0, "properties"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitRtcAudioProperties(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;)V
    return-void 
.end method

.method public onNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 4
    # ins_size=3
    const-string v0, "local"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remotes"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitRtcNetworkQuality(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List;)V
    return-void 
.end method

.method public onRemoteUserJoined(java.lang.String)void
    .registers 5
    # ins_size=2
    const-string/jumbo v0, uid
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;->BOT_JOINED Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-static v4, v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$emitPerfTimestamp(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$PerfEvent; J)V
    return-void 
.end method

.method public onRoomBinaryMessage(java.lang.String  byte[])void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$handleBinaryMessage(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; [B)V
    return-void 
.end method

.method public onServerParamsSetResult(int)void
    .registers 6
    # ins_size=2
    if-eqz v5, +046h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "onServerParamsSetResult: error="
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", scene="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getCurrentSceneId$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v2, ", task="
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    iget-object v2, v4, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getVoiceChat$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/network/StartVoiceChatData;->getTaskId()Ljava/lang/String;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$rtcDiag(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    const-string v1, "BMVoiceChatSession"
    invoke-virtual v0, v1, v5, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onUserMessage(java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;->access$getUiScope$p(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager;
    const/4 v5, 0
    invoke-direct v0, v4, v8, v9, v5, Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$rtcListener$1$onUserMessage$1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
