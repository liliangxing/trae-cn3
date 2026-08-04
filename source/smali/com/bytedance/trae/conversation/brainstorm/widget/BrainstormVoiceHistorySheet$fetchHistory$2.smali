# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "BrainstormVoiceHistorySheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;


.method constructor <init>(com.bytedance.trae.conversation.brainstorm.widget.BrainstormVoiceHistorySheet  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi;->Companion Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;
    iget-object v11, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-static v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->access$getSessionId(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;)Ljava/lang/String;
    move-result-object v11
    iget-object v3, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-static v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->access$getConversationId(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;)Ljava/lang/String;
    move-result-object v3
    const-string v4, "chat"
    const/4 v5, 0
    const/4 v6, 0
    move-object v7, v10
    check-cast v7, Lkotlin/coroutines/Continuation;
    const/16 v8, 24
    const/4 v9, 0
    iput v2, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->label I
    move-object v2, v11
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion;->getVoiceChatHistory$default(Lcom/bytedance/trae/conversation/voice/network/IVoiceChatApi$Companion; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->isAdded()Z
    move-result v0
    if-nez v0, +005h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    iget-object v0, v10, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet$fetchHistory$2;->this$0 Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;
    invoke-static v0, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet;->access$renderResult(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormVoiceHistorySheet; Lcom/bytedance/trae/network/response/HttpDataResult;)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
.end method
