# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public interface abstract Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;
.super Ljava/lang/Object;
.source "IVoiceChatApi.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    sput-object v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    return-void 
.end method

.method public abstract getVoiceChatHistory(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract startVoiceChat(com.bytedance.trae.conversation.voice.network.StartVoiceChatRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method

.method public abstract stopVoiceChat(com.bytedance.trae.conversation.voice.network.StopVoiceChatRequest  kotlin.coroutines.Continuation)java.lang.Object
    # abstract or native
.end method
