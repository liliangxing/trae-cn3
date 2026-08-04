# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "IVoiceChatApi.kt"

.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;


.method constructor <init>(com.bytedance.trae.conversation.voice.network.IVoiceChatApi$Companion  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->this$0 Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 13
    # ins_size=2
    iput-object v12, v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->result Ljava/lang/Object;
    iget v12, v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v12, v0
    iput v12, v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->label I
    iget-object v0, v11, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion$startVoiceChat$1;->this$0 Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    move-object v10, v11
    check-cast v10, Lkotlin/coroutines/Continuation;
    invoke-virtual/range v0 ... v10, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->startVoiceChat(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v12
    return-object v12
.end method
