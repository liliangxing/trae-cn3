# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/voice/TranscriptionVoiceManager$Listener;
.super Ljava/lang/Object;
.source "TranscriptionVoiceManager.kt"


.method public abstract onError(java.lang.Throwable)void
    # abstract or native
.end method

.method public abstract onFinalText(java.lang.String)void
    # abstract or native
.end method

.method public abstract onLocalAudioVolume(float)void
    # abstract or native
.end method

.method public abstract onRecognizedText(java.lang.String)void
    # abstract or native
.end method

.method public abstract onStatus(com.bytedance.trae.conversation.voice.TranscriptionVoiceManager$Status)void
    # abstract or native
.end method
