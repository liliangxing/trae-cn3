# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/voice/rtc/VolcRtcClient$Listener;
.super Ljava/lang/Object;
.source "VolcRtcClient.kt"


.method public abstract onAudioInputDeviceStateChanged(java.lang.String  int  int)void
    # abstract or native
.end method

.method public abstract onError(java.lang.Throwable)void
    # abstract or native
.end method

.method public abstract onJoinedRoom(java.lang.String)void
    # abstract or native
.end method

.method public abstract onLocalAudioLevel(int)void
    # abstract or native
.end method

.method public abstract onLocalAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    # abstract or native
.end method

.method public abstract onNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    # abstract or native
.end method

.method public abstract onRemoteUserJoined(java.lang.String)void
    # abstract or native
.end method

.method public abstract onRoomBinaryMessage(java.lang.String  byte[])void
    # abstract or native
.end method

.method public abstract onServerParamsSetResult(int)void
    # abstract or native
.end method

.method public abstract onUserMessage(java.lang.String  java.lang.String)void
    # abstract or native
.end method
