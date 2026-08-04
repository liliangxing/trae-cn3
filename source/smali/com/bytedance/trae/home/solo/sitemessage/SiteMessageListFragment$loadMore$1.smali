# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "SiteMessageListFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $nextPage:I
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;


.method constructor <init>(int  com.bytedance.trae.home.solo.sitemessage.SiteMessageListFragment  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->$nextPage I
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;
    iget v0, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->$nextPage I
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;-><init>(I Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 12
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->label I
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +012h
    if-ne v1, v2, +008h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +21h
    move-exception v11
    goto +53h
    new-instance v11, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v11, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v11
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    iget v5, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->$nextPage I
    const/4 v6, 0
    move-object v7, v10
    check-cast v7, Lkotlin/coroutines/Continuation;
    const/4 v8, 2
    const/4 v9, 0
    iput v2, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->label I
    invoke-static/range v4 ... v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->fetchList$default(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; I I Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v0, +003h
    return-object v0
    check-cast v11, Lkotlin/Pair;
    invoke-virtual v11, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    invoke-virtual v11, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/Boolean;
    invoke-virtual v11, Ljava/lang/Boolean;->booleanValue()Z
    move-result v11
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    iget v4, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->$nextPage I
    invoke-static v1, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$setCurrentPage$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; I)V
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    if-eqz v11, +003h
    goto +2h
    move v2, v3
    invoke-static v1, v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$setHasMore$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Z)V
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v11, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$getAdapter$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;
    move-result-object v11
    if-nez v11, +008h
    const-string v11, "adapter"
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v11, 0
    invoke-virtual v11, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageAdapter;->appendData(Ljava/util/List;)V
    goto +7h
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v0, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Z)V
    throw v11
    iget-object v11, v10, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment$loadMore$1;->this$0 Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;
    invoke-static v11, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment;->access$setLoading$p(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListFragment; Z)V
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v11
    :try_start_0xc
    :try_start_0x1d
.end method
