# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/brainstorm/BMVoiceChatSessionManager$Listener;
.super Ljava/lang/Object;
.source "BMVoiceChatSessionManager.kt"


.method public abstract onConversationStateChanged(com.bytedance.trae.conversation.voice.ConversationStateMessage)void
    # abstract or native
.end method

.method public abstract onError(java.lang.Throwable)void
    # abstract or native
.end method

.method public abstract onFinalText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    # abstract or native
.end method

.method public abstract onLocalAudioVolume(float)void
    # abstract or native
.end method

.method public abstract onPerfTimestamp(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$PerfEvent  long)void
    # abstract or native
.end method

.method public abstract onRecognizedText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    # abstract or native
.end method

.method public abstract onRtcAudioInputDeviceStateChanged(java.lang.String  int  int)void
    # abstract or native
.end method

.method public abstract onRtcAudioProperties(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcLocalAudioProperties)void
    # abstract or native
.end method

.method public abstract onRtcNetworkQuality(com.bytedance.trae.conversation.voice.rtc.VolcRtcClient$RtcNetworkQuality  java.util.List)void
    # abstract or native
.end method

.method public abstract onRtcTextMessage(java.lang.String  java.lang.String)void
    # abstract or native
.end method

.method public abstract onStatus(com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$Status)void
    # abstract or native
.end method

.method public abstract onSubtitleText(java.lang.String  com.bytedance.trae.conversation.brainstorm.BMVoiceChatSessionManager$MessageRole)void
    # abstract or native
.end method

.method public abstract onVoiceChatDataReady(com.bytedance.trae.conversation.voice.network.StartVoiceChatData)void
    # abstract or native
.end method
