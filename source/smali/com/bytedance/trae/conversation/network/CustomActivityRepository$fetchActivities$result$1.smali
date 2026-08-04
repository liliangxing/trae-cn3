# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "CustomActivityRepository.kt"

.implements Lkotlin/jvm/functions/Function2;

.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=2
    const/4 v0, 2
    invoke-direct v1, v0, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;
    invoke-direct v0, v3, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;-><init>(Lkotlin/coroutines/Continuation;)V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.network.IGeneralActivityApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->invoke(Lcom/bytedance/trae/conversation/network/IGeneralActivityApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->label I
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
    iget-object v6, v5, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;
    new-instance v1, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;
    const/4 v3, 0
    const/4 v4, 0
    invoke-direct v1, v3, v2, v4, Lcom/bytedance/trae/conversation/network/MobileActivityRequest;-><init>(I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;->getGeneralActivities(Lcom/bytedance/trae/conversation/network/MobileActivityRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    return-object v6
.end method
