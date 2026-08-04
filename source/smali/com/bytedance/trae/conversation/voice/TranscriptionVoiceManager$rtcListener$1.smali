# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;
.super Ljava/lang/Object;
.source "TranscriptionVoiceManager.kt"

.implements Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;

.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;


.method constructor <init>(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public onAudioInputDeviceStateChanged(java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener$DefaultImpls;->onAudioInputDeviceStateChanged(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Ljava/lang/String; I I)V
    return-void 
.end method

.method public onError(java.lang.Throwable)void
    .registers 3
    # ins_size=2
    const-string v0, "error"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitError(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/Throwable;)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getHasStartedVoiceChat$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)Z
    move-result v2
    if-nez v2, +003h
    return-void 
    iget-object v2, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->onError()V
    return-void 
.end method

.method public onJoinedRoom(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string/jumbo v0, roomId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-static v3, v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfJoinRoomSuccessTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    sget-object v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;->JoinedRoom Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;
    invoke-static v3, v0, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitStatus(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Status;)V
    return-void 
.end method

.method public onLocalAudioLevel(int)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$emitLocalAudioVolume(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; I)V
    return-void 
.end method

.method public onLocalAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener$DefaultImpls;->onLocalAudioProperties(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcLocalAudioProperties;)V
    return-void 
.end method

.method public onNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener$DefaultImpls;->onNetworkQuality(Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener; Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$RtcNetworkQuality; Ljava/util/List;)V
    return-void 
.end method

.method public onRemoteUserJoined(java.lang.String)void
    .registers 6
    # ins_size=2
    const-string/jumbo v0, uid
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v5, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$getPerfPublishStreamTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;)J
    move-result-wide v0
    const-wide/16 v2, 0
    cmp-long v5, v0, v2
    if-nez v5, +00bh
    iget-object v5, v4, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    invoke-static v5, v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$setPerfPublishStreamTimestamp$p(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; J)V
    return-void 
.end method

.method public onRoomBinaryMessage(java.lang.String  byte[])void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$rtcListener$1;->this$0 Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;
    invoke-static v0, v2, v3, Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager;->access$handleBinaryMessage(Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager; Ljava/lang/String; [B)V
    return-void 
.end method

.method public onServerParamsSetResult(int)void
    .registers 4
    # ins_size=2
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "onServerParamsSetResult: error="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    const-string v0, "VoiceChatSession"
    invoke-static v0, v3, Lcom/facebook/common/logging/FLog;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onUserMessage(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v2, "message"
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
