# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "UserMessageViewHolder.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $missing:Ljava/util/List;
.field private synthetic L$0:Ljava/lang/Object;
.field  L$1:Ljava/lang/Object;
.field  L$2:Ljava/lang/Object;
.field  L$3:Ljava/lang/Object;
.field  L$4:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;


.method constructor <init>(java.util.List  com.bytedance.trae.conversation.chat.viewholder.UserMessageViewHolder  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->$missing Ljava/util/List;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->$missing Ljava/util/List;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    invoke-direct v0, v1, v2, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder; Lkotlin/coroutines/Continuation;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/coroutines/Continuation;
    return-object v0
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v1, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/16 v5, 10
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v0, +064h
    if-eq v0, v8, +03fh
    if-eq v0, v4, +020h
    if-ne v0, v3, +016h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    move-object v2, v0
    check-cast v2, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    move-object v3, v0
    check-cast v3, Ljava/util/Map;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v17
    goto/16 +2dah
    move-exception v0
    goto/16 +303h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$3 Ljava/lang/Object;
    move-object v4, v0
    check-cast v4, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$2 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v17
    goto/16 +1c9h
    move-exception v0
    goto/16 +1d4h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$4 Ljava/lang/Object;
    move-object v9, v0
    check-cast v9, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$3 Ljava/lang/Object;
    move-object v10, v0
    check-cast v10, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$2 Ljava/lang/Object;
    move-object v11, v0
    check-cast v11, Ljava/util/List;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    move-object v12, v0
    check-cast v12, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    move-object v13, v0
    check-cast v13, Lkotlinx/coroutines/CoroutineScope;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v0, v17
    goto/16 +14fh
    move-exception v0
    goto/16 +155h
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    move-object v13, v0
    check-cast v13, Lkotlinx/coroutines/CoroutineScope;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    move-object v9, v0
    check-cast v9, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->$missing Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    invoke-direct v10, Ljava/util/ArrayList;-><init>()V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +01ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v12
    sget-object v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->IMAGE_ID Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v12, v14, +004h
    move v12, v8
    goto +2h
    const/4 v12, 0
    if-eqz v12, -018h
    invoke-interface v10, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v10, Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-static v10, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-direct v0, v11, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +010h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v11
    invoke-interface v0, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v0
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->$missing Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +01ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    move-object v14, v12
    check-cast v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v14, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v14
    sget-object v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->REMOTE_RESOURCE Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v14, v15, +004h
    move v14, v8
    goto +2h
    const/4 v14, 0
    if-eqz v14, -018h
    invoke-interface v11, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    invoke-static v11, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v12
    invoke-direct v10, v12, Ljava/util/ArrayList;-><init>(I)V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +010h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v12
    invoke-interface v10, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v10, Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    invoke-static v10, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v11
    iget-object v10, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->$missing Ljava/util/List;
    check-cast v10, Ljava/lang/Iterable;
    new-instance v12, Ljava/util/ArrayList;
    invoke-direct v12, Ljava/util/ArrayList;-><init>()V
    check-cast v12, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +01ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    move-object v15, v14
    check-cast v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getKind()Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    move-result-object v15
    sget-object v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    if-ne v15, v6, +004h
    move v6, v8
    goto +2h
    const/4 v6, 0
    if-eqz v6, -018h
    invoke-interface v12, v14, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v12, Ljava/util/List;
    check-cast v12, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-static v12, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v10
    invoke-direct v6, v10, Ljava/util/ArrayList;-><init>(I)V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +010h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    invoke-virtual v12, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;->getSourceId()Ljava/lang/String;
    move-result-object v12
    invoke-interface v6, v12, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v6, Ljava/util/List;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v6, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v10
    move-object v6, v0
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    xor-int/2addr v6, v8
    if-eqz v6, +045h
    iget-object v6, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    sget-object v12, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getImageUploadApi(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;
    move-result-object v6
    iput-object v13, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    iput-object v11, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$2 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$3 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$4 Ljava/lang/Object;
    iput v8, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->label I
    invoke-virtual v6, v0, v1, Lcom/bytedance/trae/conversation/imageupload/ConversationCopilotImageUploadApi;->getImageUrls(Ljava/util/List; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v12, v9
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +dh
    move-exception v0
    move-object v12, v9
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    move-object v0, v7
    check-cast v0, Ljava/util/Map;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    invoke-interface v9, v0, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    move-object v9, v11
    goto +3h
    move-object v12, v9
    goto -3h
    move-object v0, v9
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v8
    if-eqz v0, +092h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getResourceUploadApi(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;
    move-result-object v0
    new-instance v6, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;
    sget-object v11, Lcom/bytedance/trae/conversation/fileupload/BizType;->RemoteResource Lcom/bytedance/trae/conversation/fileupload/BizType;
    invoke-direct v6, v9, v11, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest;-><init>(Ljava/util/List; Lcom/bytedance/trae/conversation/fileupload/BizType;)V
    iput-object v13, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    iput-object v12, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    iput-object v9, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$2 Ljava/lang/Object;
    iput-object v10, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$3 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$4 Ljava/lang/Object;
    iput v4, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->label I
    invoke-virtual v0, v6, v1, Lcom/bytedance/trae/conversation/fileupload/ConversationCopilotResourceUploadApi;->getResourceUrl(Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v4, v10
    move-object v10, v12
    check-cast v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/fileupload/GetResourceUrlResponse;->getUrlMap()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +eh
    move-exception v0
    move-object v4, v10
    move-object v10, v12
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    move-object v0, v7
    check-cast v0, Ljava/util/Map;
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    check-cast v9, Ljava/lang/Iterable;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +03dh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/String;
    invoke-interface v0, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-nez v11, +018h
    new-instance v11, Ljava/lang/StringBuilder;
    const-string/jumbo v12, trae-res://remote_resource/
    invoke-direct v11, v12, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    invoke-interface v0, v11, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    move-object v12, v11
    check-cast v12, Ljava/lang/CharSequence;
    if-eqz v12, +00bh
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-nez v12, +003h
    goto +3h
    const/4 v12, 0
    goto +2h
    move v12, v8
    if-nez v12, -039h
    invoke-interface v10, v9, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -3eh
    move-object v4, v10
    move-object v10, v12
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v8
    if-eqz v0, +0fdh
    check-cast v4, Ljava/lang/Iterable;
    sget-object v0, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->INSTANCE Lcom/bytedance/trae/conversation/products/LocalArtifactPath;
    new-instance v6, Ljava/util/LinkedHashMap;
    invoke-static v4, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapCapacity(I)I
    move-result v5
    const/16 v9, 16
    invoke-static v5, v9, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v5
    invoke-direct v6, v5, Ljava/util/LinkedHashMap;-><init>(I)V
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +014h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v9, v6
    check-cast v9, Ljava/util/Map;
    move-object v11, v5
    check-cast v11, Ljava/lang/String;
    invoke-virtual v0, v11, Lcom/bytedance/trae/conversation/products/LocalArtifactPath;->requestTarget(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-interface v9, v5, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -17h
    move-object v4, v6
    check-cast v4, Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->this$0 Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    sget-object v5, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi;->Companion Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;
    new-instance v6, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;
    invoke-interface v4, Ljava/util/Map;->values()Ljava/util/Collection;
    move-result-object v9
    check-cast v9, Ljava/lang/Iterable;
    invoke-static v9, Lkotlin/collections/CollectionsKt;->distinct(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v9
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getAttachmentAdapter$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->getConversationId()Ljava/lang/String;
    move-result-object v11
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;->access$getAttachmentAdapter$p(Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder;)Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$AttachmentListAdapter;->getMessageId()Ljava/lang/String;
    move-result-object v0
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v12
    invoke-direct v6, v9, v11, v0, v12, Lcom/bytedance/trae/im/service/GetDownloadUrlRequest;-><init>(Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean;)V
    iput-object v10, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$0 Ljava/lang/Object;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$1 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$2 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$3 Ljava/lang/Object;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->L$4 Ljava/lang/Object;
    iput v3, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolder$bind$1$fetched$1;->label I
    invoke-virtual v5, v6, v1, Lcom/bytedance/trae/im/service/IGetDownloadUrlApi$Companion;->getDownloadUrlRawCall(Lcom/bytedance/trae/im/service/GetDownloadUrlRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v2, v4
    move-object v3, v10
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v4, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v4, +005h
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    goto +2h
    move-object v0, v7
    if-eqz v0, +014h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;
    if-eqz v0, +006h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/GetDownloadUrlData;->getUrlMap()Ljava/util/Map;
    move-result-object v7
    if-nez v7, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +eh
    move-exception v0
    move-object v2, v4
    move-object v3, v10
    sget-object v4, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    move-object v10, v3
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    move-object v0, v3
    check-cast v0, Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +037h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v0, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    if-nez v3, +008h
    invoke-interface v0, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +3h
    const/4 v5, 0
    goto +2h
    move v5, v8
    if-nez v5, -035h
    invoke-interface v10, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -3ah
    return-object v10
    :try_start_0x20
    :try_start_0x45
    :try_start_0x68
    :try_start_0x1a2
    :try_start_0x1bc
    :try_start_0x1f1
    :try_start_0x213
    :try_start_0x2c3
    :try_start_0x2ff
.end method
