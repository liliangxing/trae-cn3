# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener$DefaultImpls;
.super Ljava/lang/Object;
.source "VolcRtcClient.kt"


.method public static onAudioInputDeviceStateChanged(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  java.lang.String  int  int)void
    .registers 4
    # ins_size=4
    const-string v0, "deviceId"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onLocalAudioLevel(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  int)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public static onLocalAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    .registers 2
    # ins_size=2
    const-string v0, "properties"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    .registers 3
    # ins_size=3
    const-string v0, "local"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "remotes"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method

.method public static onRemoteUserJoined(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$Listener  java.lang.String)void
    .registers 2
    # ins_size=2
    const-string/jumbo v0, uid
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
