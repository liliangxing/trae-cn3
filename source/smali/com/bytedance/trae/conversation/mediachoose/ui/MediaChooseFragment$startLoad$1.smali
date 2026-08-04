# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "MediaChooseFragment.kt"

.implements Lkotlin/jvm/functions/Function2;

.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;


.method constructor <init>(com.bytedance.trae.conversation.mediachoose.ui.MediaChooseFragment  kotlin.coroutines.Continuation)void
    .registers 3
    # ins_size=3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    const/4 v1, 2
    invoke-direct v0, v1, v2, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 4
    # ins_size=3
    new-instance v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-direct v2, v0, v3, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;-><init>(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Lkotlin/coroutines/Continuation;)V
    check-cast v2, Lkotlin/coroutines/Continuation;
    return-object v2
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 10
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->label I
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +014h
    if-ne v1, v3, +00ah
    iget-object v0, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getRepository$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;
    move-result-object v1
    if-nez v1, +009h
    const-string/jumbo v1, repository
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v1, v2
    iget-object v4, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v4, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getConfig$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;
    move-result-object v4
    if-nez v4, +008h
    const-string v4, "config"
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v4, v2
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/MediaChooseConfig;->getMediaType()Lcom/bytedance/trae/conversation/mediachoose/model/MediaType;
    move-result-object v4
    move-object v5, v8
    check-cast v5, Lkotlin/coroutines/Continuation;
    iput-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->L$0 Ljava/lang/Object;
    iput v3, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->label I
    invoke-virtual v1, v4, v5, Lcom/bytedance/trae/conversation/mediachoose/data/MediaStoreRepository;->loadBuckets(Lcom/bytedance/trae/conversation/mediachoose/model/MediaType; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v0, +003h
    return-object v0
    move-object v0, v9
    move-object v9, v1
    check-cast v9, Ljava/util/List;
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$setBuckets$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; Ljava/util/List;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getBuckets$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v3
    if-eqz v9, +05ah
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getBuckets$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Ljava/util/List;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    iget-object v0, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01bh
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getId()J
    move-result-wide v4
    invoke-static v0, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getCurrentBucketId$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)J
    move-result-wide v6
    cmp-long v4, v4, v6
    if-nez v4, +004h
    move v4, v3
    goto +2h
    const/4 v4, 0
    if-eqz v4, -01ch
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    if-nez v2, +00fh
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getBuckets$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Ljava/util/List;
    move-result-object v9
    invoke-static v9, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v9
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getId()J
    move-result-wide v0
    invoke-static v9, v0, v1, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$setCurrentBucketId$p(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment; J)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$getBinding(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;
    move-result-object v9
    iget-object v9, v9, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseFragmentBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/mediachoose/model/AlbumBucket;->getName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v9, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(Ljava/lang/CharSequence;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment$startLoad$1;->this$0 Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;
    invoke-static v9, Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;->access$resetAndReload(Lcom/bytedance/trae/conversation/mediachoose/ui/MediaChooseFragment;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v9
.end method
