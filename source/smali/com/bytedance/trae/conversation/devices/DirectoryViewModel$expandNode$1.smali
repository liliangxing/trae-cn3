# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DirectoryViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $id:Ljava/lang/String;
.field final synthetic $node:Lcom/bytedance/trae/conversation/devices/DirectoryNode;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;


.method constructor <init>(java.lang.String  com.bytedance.trae.conversation.devices.DirectoryNode  com.bytedance.trae.conversation.devices.DirectoryViewModel  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$id Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$id Ljava/lang/String;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DirectoryNode; Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 27
    # ins_size=2
    move-object/from16 v0, v25
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->label I
    const/4 v3, 3
    const/4 v4, 2
    const/4 v5, 0
    const/4 v6, 1
    if-eqz v2, +01ch
    if-eq v2, v6, +014h
    if-eq v2, v4, +00dh
    if-ne v2, v3, +003h
    goto +9h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v26, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +2cah
    invoke-static/range v26, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v26
    goto +3ah
    invoke-static/range v26, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-array v2, v3, [Lkotlin/Pair;
    const-string v7, "cli_id"
    iget-object v8, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$id Ljava/lang/String;
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v5
    iget-object v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getPath()Ljava/lang/String;
    move-result-object v7
    const-string v8, "path"
    invoke-static v8, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v6
    const-string v7, "depth"
    const-string v8, "3"
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v4
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->label I
    invoke-virtual v7, v2, v8, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->listFolderRawCall(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v7, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v8, -1
    if-eqz v7, +1d9h
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-eqz v3, +128h
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/ListFolderData;
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ListFolderData;->getFolder()Lcom/bytedance/trae/conversation/network/FolderNode;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-eqz v1, +078h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +072h
    check-cast v1, Ljava/lang/Iterable;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v1, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +054h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/FolderNode;
    new-instance v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getName()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v9
    add-int/lit8 v13, v9, 1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v14
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getHasChildren()Z
    move-result v9
    if-nez v9, +019h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/FolderNode;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v5
    goto +2h
    move v4, v6
    if-nez v4, +003h
    goto +3h
    move v15, v5
    goto +2h
    move v15, v6
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 1984
    const/16 v22, 0
    move-object v9, v7
    invoke-direct/range v9 ... v22, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -57h
    move-object v2, v3
    check-cast v2, Ljava/util/List;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-static v1, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v10
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    goto +5h
    add-int/lit8 v5, v5, 1
    goto -1dh
    move v5, v8
    if-ne v5, v8, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v11, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 1
    const/16 v19, 0
    const/16 v20, 1
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 1599
    const/16 v24, 0
    invoke-static/range v11 ... v24, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v1
    invoke-interface v10, v5, v1, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    add-int/2addr v5, v6
    move-object v1, v2
    check-cast v1, Ljava/util/Collection;
    invoke-interface v10, v5, v1, Ljava/util/List;->addAll(I Ljava/util/Collection;)Z
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$getChildrenCache$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Ljava/util/Map;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 62
    const/16 v17, 0
    invoke-static/range v9 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +152h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    invoke-static v3, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v10
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    goto +5h
    add-int/lit8 v5, v5, 1
    goto -1dh
    move v5, v8
    if-eq v5, v8, +043h
    iget-object v11, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 1919
    const/16 v24, 0
    invoke-static/range v11 ... v24, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v3
    invoke-interface v10, v5, v3, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v9, v5
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 62
    const/16 v17, 0
    invoke-static/range v9 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v5
    invoke-interface v3, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_expand_failed I
    invoke-static v6, v7, v8, v2, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; J Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->label I
    invoke-interface v3, v5, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +0aeh
    return-object v1
    instance-of v4, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v4, +0ach
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v10
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +01ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v9
    invoke-static v7, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    goto +5h
    add-int/lit8 v5, v5, 1
    goto -1dh
    move v5, v8
    if-eq v5, v8, +043h
    iget-object v11, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->$node Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 1919
    const/16 v24, 0
    invoke-static/range v11 ... v24, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryNode; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    move-result-object v4
    invoke-interface v10, v5, v4, Ljava/util/List;->set(I Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v9, v5
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v11, 0
    const/4 v12, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 62
    const/16 v17, 0
    invoke-static/range v9 ... v17, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v5
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_expand_failed I
    invoke-static v6, v7, v2, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; I Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$expandNode$1;->label I
    invoke-interface v4, v5, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
