# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->label I
    const/4 v2, 2
    const-string/jumbo v3, viewPager
    const-string v4, "progressBar"
    const/16 v5, 8
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v1, +01ah
    if-eq v1, v6, +011h
    if-ne v1, v2, +007h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0c3h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ch
    move-exception v11
    goto/16 +10ch
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getCliType$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/lang/String;
    move-result-object v11
    if-nez v11, +008h
    const-string v11, "cliType"
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v7
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v11, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +085h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v11
    check-cast v11, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v1, v2, v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1$result$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v2, v10
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v6, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->label I
    invoke-static v11, v1, v2, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +0a2h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v7
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getWorkspacePath()Ljava/lang/String;
    move-result-object v11
    goto +2h
    move-object v11, v7
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +00ah
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    const/4 v6, 0
    if-nez v6, +06ah
    iget-object v1, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getPaths$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    iget-object v2, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +056h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-static v2, v6, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$normalizeFilePath(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-static v2, v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$buildFileUrl(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-static v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getImageUrls$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/Map;
    move-result-object v9
    invoke-interface v9, v6, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1bh
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getPaths$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/List;
    move-result-object v1
    move-object v6, v10
    check-cast v6, Lkotlin/coroutines/Continuation;
    iput v2, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->label I
    invoke-static v11, v1, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$fetchDownloadUrlsWithRetry(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Ljava/util/Map;
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-interface v11, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v11
    invoke-interface v11, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01ch
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getImageUrls$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/Map;
    move-result-object v6
    invoke-interface v6, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1fh
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v7
    invoke-virtual v11, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v7
    invoke-virtual v11, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v11
    instance-of v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v0, +005h
    move-object v7, v11
    check-cast v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v7, +038h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->notifyDataSetChanged()V
    goto +33h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "MultiImagePreviewActivity"
    const-string v2, "fetchAllImageUrls error"
    invoke-virtual v0, v1, v2, v11, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v7
    invoke-virtual v11, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v11, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v11
    if-nez v11, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v11, v7
    invoke-virtual v11, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v11
    instance-of v0, v11, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v0, +005h
    move-object v7, v11
    check-cast v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v7, +003h
    goto -35h
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    move-exception v11
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    invoke-virtual v0, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v10, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchArtifactImageUrls$1;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v7
    invoke-virtual v0, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v1, +005h
    move-object v7, v0
    check-cast v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v7, +005h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->notifyDataSetChanged()V
    throw v11
    :try_start_0x16
    :try_start_0x23
    :try_start_0x2d
    :try_start_0x134
.end method
