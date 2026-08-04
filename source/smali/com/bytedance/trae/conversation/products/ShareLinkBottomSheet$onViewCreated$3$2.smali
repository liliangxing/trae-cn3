# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ShareLinkBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $sid:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;


.method constructor <init>(com.bytedance.trae.conversation.products.ShareLinkBottomSheet  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->$sid Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->$sid Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;-><init>(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    new-instance v1, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->this$0 Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;
    invoke-static v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;->access$getConversationId$p(Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet;)Ljava/lang/String;
    move-result-object v3
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->$sid Ljava/lang/String;
    const-string v5, "disabled"
    invoke-direct v1, v3, v4, v5, Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    move-object v3, v6
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$2;->label I
    invoke-virtual v7, v1, v3, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->updateLocalShareLinkStatus(Lcom/bytedance/trae/conversation/products/UpdateLocalShareLinkStatusRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v7
.end method
