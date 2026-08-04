# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "VoiceSubTaskCoordinator.kt"

.field  J$0:J
.field  J$1:J
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;


.method constructor <init>(com.bytedance.trae.conversation.voice.subtask.VoiceSubTaskCoordinator  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->this$0 Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    iput-object v8, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->result Ljava/lang/Object;
    iget v8, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v8, v0
    iput v8, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->label I
    iget-object v0, v7, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator$awaitCancelRemoteTerminal$1;->this$0 Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const-wide/16 v4, 0
    move-object v6, v7
    check-cast v6, Lkotlin/coroutines/Continuation;
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator;->access$awaitCancelRemoteTerminal(Lcom/bytedance/trae/conversation/voice/subtask/VoiceSubTaskCoordinator; Lkotlinx/coroutines/CompletableDeferred; Ljava/lang/String; Ljava/lang/String; J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    return-object v8
.end method
