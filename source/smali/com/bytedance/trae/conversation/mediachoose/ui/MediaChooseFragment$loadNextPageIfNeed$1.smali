# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MediaChooseFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;


.method constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 14
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->label I
    const-string v2, "config"
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v1, +010h
    if-ne v1, v3, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +47h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getRepository$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    move-result-object v13
    if-nez v13, +00ah
    const-string/jumbo v13, repository
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v5, v4
    goto +2h
    move-object v5, v13
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getCurrentBucketId$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)J
    move-result-wide v6
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getConfig$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v13
    if-nez v13, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v4
    invoke-virtual v13, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMediaType()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v8
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getOffset$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)I
    move-result v9
    const/16 v10, 60
    move-object v11, v12
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput v3, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->label I
    invoke-virtual/range v5 ... v11, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->loadMediaPage(J Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; I I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Ljava/util/List;
    invoke-interface v13, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +00bh
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    const/4 v0, 0
    invoke-static v13, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$setHasMore$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Z)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
    iget-object v0, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getOffset$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)I
    move-result v1
    invoke-interface v13, Ljava/util/List;->size()I
    move-result v3
    add-int/2addr v1, v3
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$setOffset$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; I)V
    iget-object v0, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getMediaItems$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Ljava/util/ArrayList;
    move-result-object v0
    check-cast v13, Ljava/util/Collection;
    invoke-virtual v0, v13, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    move-result-object v13
    const-string v0, "adapter"
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v4
    iget-object v1, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getMediaItems$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Ljava/util/ArrayList;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    iget-object v3, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getConfig$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v3
    if-nez v3, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v3, v4
    invoke-virtual v3, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getShowCamera()Z
    move-result v2
    invoke-virtual v13, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->submit(Ljava/util/List; Z)V
    iget-object v13, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v13, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getAdapter$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;
    move-result-object v13
    if-nez v13, +006h
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v13, v4
    iget-object v0, v12, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$loadNextPageIfNeed$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getSelection$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;
    move-result-object v0
    if-nez v0, +009h
    const-string/jumbo v0, selection
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v4, v0
    invoke-virtual v13, v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaGridAdapter;->updateSelection(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaSelection;)V
    sget-object v13, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v13
.end method
