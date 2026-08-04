# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "BrainstormViewModel.kt"

.field  L$0:Ljava/lang/Object;
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.BrainstormViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->result Ljava/lang/Object;
    iget v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v2, v0
    iput v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->label I
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel$resolveVoiceConversationIdForRecording$1;->this$0 Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;
    move-object v0, v1
    check-cast v0, Lkotlin/coroutines/Continuation;
    invoke-static v2, v0, Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel;->access$resolveVoiceConversationIdForRecording(Lcom/bytedance/trae/conversation/brainstorm/BrainstormViewModel; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    return-object v2
.end method
