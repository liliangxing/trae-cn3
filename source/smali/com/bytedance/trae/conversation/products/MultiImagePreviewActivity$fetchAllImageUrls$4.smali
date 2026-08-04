# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MultiImagePreviewActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;


.method constructor <init>(com.bytedance.trae.conversation.products.MultiImagePreviewActivity  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->label I
    const/4 v2, 1
    const-string/jumbo v3, viewPager
    const-string v4, "progressBar"
    const/16 v5, 8
    const/4 v6, 0
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +29h
    move-exception v9
    goto +5eh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v9
    check-cast v9, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4$urlMap$1;
    iget-object v7, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-direct v1, v7, v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4$urlMap$1;-><init>(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v7, v8
    check-cast v7, Lkotlin/coroutines/Continuation;
    iput v2, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->label I
    invoke-static v9, v1, v7, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v0, +003h
    return-object v0
    check-cast v9, Ljava/util/Map;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getImageUrls$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v9, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v6
    invoke-virtual v9, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v6
    invoke-virtual v9, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v9
    instance-of v0, v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v0, +005h
    move-object v6, v9
    check-cast v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v6, +038h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->notifyDataSetChanged()V
    goto +33h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "MultiImagePreviewActivity"
    const-string v2, "fetchAllImageUrls (local_artifact) error"
    invoke-virtual v0, v1, v2, v9, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v6
    invoke-virtual v9, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v9
    if-nez v9, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v6
    invoke-virtual v9, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v9
    instance-of v0, v9, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v0, +005h
    move-object v6, v9
    check-cast v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v6, +003h
    goto -35h
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
    move-exception v9
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getProgressBar$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroid/widget/ProgressBar;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v6
    invoke-virtual v0, v5, Landroid/widget/ProgressBar;->setVisibility(I)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$fetchAllImageUrls$4;->this$0 Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;
    invoke-static v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;->access$getViewPager$p(Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity;)Landroidx/viewpager2/widget/ViewPager2;
    move-result-object v0
    if-nez v0, +006h
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v6
    invoke-virtual v0, Landroidx/viewpager2/widget/ViewPager2;->getAdapter()Landroidx/recyclerview/widget/RecyclerView$Adapter;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v1, +005h
    move-object v6, v0
    check-cast v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;
    if-eqz v6, +005h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/products/MultiImagePreviewActivity$ImagePagerAdapter;->notifyDataSetChanged()V
    throw v9
    :try_start_0x13
    :try_start_0x24
    :try_start_0x76
.end method
