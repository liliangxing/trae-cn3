# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;
.super Lkotlin/coroutines/jvm/internal/ContinuationImpl;
.source "ConversationViewModel.kt"

.field  I$0:I
.field  I$1:I
.field  L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  L$5:Ljava/lang/Object;
.field  Z$0:Z
.field  label:I
.field synthetic result:Ljava/lang/Object;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationViewModel;


.method constructor <init>(com.bytedance.trae.conversation.ConversationViewModel  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    invoke-direct v0, v2, Lkotlin/coroutines/jvm/internal/ContinuationImpl;-><init>(Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    iput-object v9, v8, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->result Ljava/lang/Object;
    iget v9, v8, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    const/high16 v0, -2147483648
    or-int/2addr v9, v0
    iput v9, v8, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->label I
    iget-object v0, v8, Lcom/bytedance/trae/conversation/ConversationViewModel$loadMessagesByAnchorRawWithLargeFileRetry$1;->this$0 Lcom/bytedance/trae/conversation/ConversationViewModel;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    move-object v7, v8
    check-cast v7, Lkotlin/coroutines/Continuation;
    invoke-virtual/range v0 ... v7, Lcom/bytedance/trae/conversation/ConversationViewModel;->loadMessagesByAnchorRawWithLargeFileRetry$conversation_mainlandRelease(Ljava/lang/String; Ljava/lang/String; I I Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    return-object v9
.end method
