# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "ConversationViewModel.kt"

.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    iput-object v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->result Ljava/lang/Object;
    iget v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v7, v0
    iput v7, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->label I
    iget-object v0, v6, Lcom/bytedance/trae/conversation/ConversationViewModel$handleCreateTaskErrorWithoutModelFallbackIfNeeded$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    move-object v5, v6
    check-cast v5, Lkotlin/coroutines/Continuation;
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->access$handleCreateTaskErrorWithoutModelFallbackIfNeeded(Lcom/bytedance/trae/conversation/ConversationViewModel; J Ljava/lang/String; Lcom/google/gson/JsonObject; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method
