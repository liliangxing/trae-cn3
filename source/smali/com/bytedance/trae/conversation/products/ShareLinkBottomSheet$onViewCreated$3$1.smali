# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ShareLinkBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $sessionId:Ljava/lang/String;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->$sessionId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->$sessionId Ljava/lang/String;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +23h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/conversation/products/IShareLinkApi;->Companion Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->$sessionId Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;
    const-string v4, "disabled"
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest;-><init>(Ljava/lang/String;)V
    move-object v4, v5
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/products/ShareLinkBottomSheet$onViewCreated$3$1;->label I
    invoke-virtual v6, v1, v3, v4, Lcom/bytedance/trae/conversation/products/IShareLinkApi$Companion;->updateShareLinkStatus(Ljava/lang/String; Lcom/bytedance/trae/conversation/products/UpdateShareLinkStatusRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method
