# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ConversationActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $content:Ljava/lang/String;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $messageId:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(com.bytedance.trae.conversation.ConversationActivity  java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$messageId Ljava/lang/String;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$content Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$conversationId Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$messageId Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$content Ljava/lang/String;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +28h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/im/service/IReportMessageApi;->Companion Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1$result$1;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$conversationId Ljava/lang/String;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$messageId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->$content Ljava/lang/String;
    const/4 v6, 0
    invoke-direct v1, v3, v4, v5, v6, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1$result$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->label I
    invoke-virtual v8, v1, v3, Lcom/bytedance/trae/im/service/IReportMessageApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +00ch
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v8, Landroid/content/Context;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_report_submit_success I
    invoke-static v8, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    goto +eh
    instance-of v8, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v8, +00eh
    iget-object v8, v7, Lcom/bytedance/trae/conversation/ConversationActivity$submitReport$1;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    check-cast v8, Landroid/content/Context;
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_report_submit_failed I
    invoke-static v8, v0, Lcom/bytedance/trae/common/widget/CustomToast;->showLong(Landroid/content/Context; I)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
.end method
