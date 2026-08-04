# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactListActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $conversationId:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->$conversationId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->$conversationId Ljava/lang/String;
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.conversation.products.IGetArtifactListApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->invoke(Lcom/bytedance/trae/conversation/products/IGetArtifactListApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +39h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;
    const/4 v1, 2
    new-array v1, v1, [Lkotlin/Pair;
    const-string v3, "conversation_id"
    iget-object v4, v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->$conversationId Ljava/lang/String;
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    const/4 v4, 0
    aput-object v3, v1, v4
    const-string v3, "check_exist"
    const-string/jumbo v4, true
    invoke-static v3, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v1, v2
    invoke-static v1, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v1
    move-object v3, v5
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;->label I
    invoke-interface v6, v1, v3, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;->getArtifactList(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v0, +003h
    return-object v0
    return-object v6
.end method
