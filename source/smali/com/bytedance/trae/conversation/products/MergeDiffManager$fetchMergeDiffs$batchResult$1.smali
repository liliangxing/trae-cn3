# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MergeDiffManager.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $baseRef:Ljava/lang/String;
.field final synthetic $filePaths:Ljava/util/List;
.field final synthetic $headRef:Ljava/lang/String;
.field private synthetic L$0:Ljava/lang/Object;
.field  label:I


.method constructor <init>(java.lang.String  java.lang.String  java.util.List  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$baseRef Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$headRef Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$filePaths Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 7
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$baseRef Ljava/lang/String;
    iget-object v2, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$headRef Ljava/lang/String;
    iget-object v3, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$filePaths Ljava/util/List;
    invoke-direct v0, v1, v2, v3, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public final invoke(com.bytedance.trae.im.service.IGitBatchDiffApi  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lcom/bytedance/trae/im/service/IGitBatchDiffApi;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->invoke(Lcom/bytedance/trae/im/service/IGitBatchDiffApi; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/im/service/IGitBatchDiffApi;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$baseRef Ljava/lang/String;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$headRef Ljava/lang/String;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->$filePaths Ljava/util/List;
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    if-eqz v5, +003h
    const/4 v4, 0
    check-cast v4, Ljava/util/List;
    new-instance v5, Lcom/bytedance/trae/im/service/GitBatchDiffRequest;
    invoke-direct v5, v1, v3, v4, Lcom/bytedance/trae/im/service/GitBatchDiffRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)V
    move-object v1, v6
    check-cast v1, Lkotlin/coroutines/Continuation;
    iput v2, v6, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;->label I
    invoke-interface v7, v5, v1, Lcom/bytedance/trae/im/service/IGitBatchDiffApi;->batchDiff(Lcom/bytedance/trae/im/service/GitBatchDiffRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v0, +003h
    return-object v0
    return-object v7
.end method
