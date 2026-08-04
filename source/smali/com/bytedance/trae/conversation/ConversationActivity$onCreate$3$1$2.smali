# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;
.super Ljava/lang/Object;
.source "ConversationActivity.kt"

.implements Lkotlinx/coroutines/flow/FlowCollector;

.field final synthetic $id:Ljava/lang/String;
.field final synthetic $pendingFetch:Lkotlin/jvm/internal/Ref$BooleanRef;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/ConversationActivity;


.method constructor <init>(kotlin.jvm.internal.Ref$BooleanRef  java.lang.String  com.bytedance.trae.conversation.ConversationActivity)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$pendingFetch Lkotlin/jvm/internal/Ref$BooleanRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$id Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public bridge synthetic emit(java.lang.Object  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->emit(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final emit(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    instance-of v4, v5, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;
    if-eqz v4, +012h
    move-object v4, v5
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;
    iget v0, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->label I
    const/high16 v1, -2147483648
    and-int/2addr v0, v1
    if-eqz v0, +008h
    iget v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->label I
    sub-int/2addr v5, v1
    iput v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;
    invoke-direct v4, v3, v5, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;-><init>(Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->label I
    const/4 v2, 1
    if-eqz v1, +014h
    if-ne v1, v2, +00ah
    iget-object v4, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +27h
    new-instance v4, Ljava/lang/IllegalStateException;
    const-string v5, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v4, v5, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v4
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$pendingFetch Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-boolean v5, v5, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    if-eqz v5, +04ah
    iget-object v5, v3, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$pendingFetch Lkotlin/jvm/internal/Ref$BooleanRef;
    const/4 v1, 0
    iput-boolean v1, v5, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    sget-object v5, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService;->Companion Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$id Ljava/lang/String;
    iput-object v3, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->L$0 Ljava/lang/Object;
    iput v2, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2$emit$1;->label I
    invoke-virtual v5, v1, v4, Lcom/bytedance/trae/im/service/IGetConversationFullDetailService$Companion;->getConversationFullDetailRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v0, +003h
    return-object v0
    move-object v4, v3
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +02bh
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +01fh
    iget-object v4, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->this$0 Lcom/bytedance/trae/conversation/ConversationActivity;
    invoke-static v4, Lcom/bytedance/trae/conversation/ConversationActivity;->access$getViewModel$p(Lcom/bytedance/trae/conversation/ConversationActivity;)Lcom/bytedance/trae/conversation/ConversationViewModel;
    move-result-object v4
    if-nez v4, +009h
    const-string/jumbo v4, viewModel
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v4, 0
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/ConversationViewModel;->onConversationFullDetailLoaded(Lcom/bytedance/trae/im/service/ConversationFullDetailResponse;)V
    goto +5h
    iget-object v4, v4, Lcom/bytedance/trae/conversation/ConversationActivity$onCreate$3$1$2;->$pendingFetch Lkotlin/jvm/internal/Ref$BooleanRef;
    iput-boolean v2, v4, Lkotlin/jvm/internal/Ref$BooleanRef;->element Z
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
