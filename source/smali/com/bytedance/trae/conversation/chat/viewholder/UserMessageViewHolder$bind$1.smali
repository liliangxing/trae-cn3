# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $cached:Ljava/util/Map;
.field final synthetic $missing:Ljava/util/List;
.field final synthetic $previewImages:Ljava/util/List;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(java.util.List  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  java.util.Map  java.util.List  kotlin.coroutines.Continuation)void
    .registers 6
    # ins_size=6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$previewImages Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$cached Ljava/util/Map;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$missing Ljava/util/List;
    const/4 v1, 2
    invoke-direct v0, v1, v5, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 9
    # ins_size=3
    new-instance v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$previewImages Ljava/util/List;
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    iget-object v3, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$cached Ljava/util/Map;
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$missing Ljava/util/List;
    move-object v0, v7
    move-object v5, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Ljava/util/Map; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v7, Lkotlin/coroutines/Continuation;
    return-object v7
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 9
    # ins_size=2
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2ah
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v8
    check-cast v8, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$missing Ljava/util/List;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    const/4 v5, 0
    invoke-direct v1, v3, v4, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    move-object v3, v7
    check-cast v3, Lkotlin/coroutines/Continuation;
    iput v2, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->label I
    invoke-static v8, v1, v3, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v0, +003h
    return-object v0
    check-cast v8, Ljava/util/Map;
    invoke-interface v8, Ljava/util/Map;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v2
    if-eqz v0, +0a8h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$previewImages Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v4, v5, +004h
    move v4, v2
    goto +2h
    const/4 v4, 0
    if-eqz v4, -018h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v0, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->INSTANCE Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;
    new-instance v3, Ljava/util/LinkedHashMap;
    invoke-direct v3, Ljava/util/LinkedHashMap;-><init>()V
    invoke-interface v8, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v4
    invoke-interface v4, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +021h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/util/Map$Entry;
    invoke-interface v5, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    invoke-interface v0, v6, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v6
    xor-int/2addr v6, v2
    if-eqz v6, -017h
    invoke-interface v5, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v6
    invoke-interface v5, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    invoke-virtual v3, v6, v5, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -24h
    check-cast v3, Ljava/util/Map;
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/imageupload/ResourceRepoManager;->putAll(Ljava/util/Map;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getAttachmentAdapter$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    move-result-object v0
    iget-object v1, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1;->$cached Ljava/util/Map;
    invoke-static v1, v8, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v8
    invoke-virtual v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->updateResolvedUrls(Ljava/util/Map;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
.end method
