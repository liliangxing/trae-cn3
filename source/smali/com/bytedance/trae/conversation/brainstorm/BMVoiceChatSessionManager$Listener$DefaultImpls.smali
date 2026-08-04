# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener$DefaultImpls;
.super Ljava/lang/Object;
.source "BMVoiceChatSessionManager.kt"


.method public static onConversationStateChanged(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    .registers 2
    # ins_size=2
    const-string/jumbo v0, state
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onLocalAudioVolume(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  float)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public static onPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    .registers 4
    # ins_size=4
    const-string v0, "event"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onRtcAudioInputDeviceStateChanged(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    const-string v0, "deviceId"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onRtcAudioProperties(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 2
    # ins_size=2
    const-string v0, "properties"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onRtcNetworkQuality(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 3
    # ins_size=3
    const-string v0, "local"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remotes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onRtcTextMessage(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    const-string/jumbo v0, uid
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onSubtitleText(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    .registers 3
    # ins_size=3
    const-string/jumbo v0, text
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, role
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onVoiceChatDataReady(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Listener  com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    .registers 2
    # ins_size=2
    const-string v0, "data"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
