# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DirectoryViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $id:Ljava/lang/String;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;


.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 4
    # ins_size=4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->$id Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v3, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 5
    # ins_size=3
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->$id Ljava/lang/String;
    invoke-direct v3, v0, v1, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/coroutines/Continuation;
    return-object v3
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 26
    # ins_size=2
    move-object/from16 v0, v24
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->label I
    const/4 v3, 3
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 1
    if-eqz v2, +01ch
    if-eq v2, v6, +014h
    if-eq v2, v5, +00dh
    if-ne v2, v3, +003h
    goto +9h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +227h
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v2, v25
    goto +58h
    invoke-static/range v25, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iget-object v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v7
    invoke-interface v7, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v7
    move-object v8, v7
    check-cast v8, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 1
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v15, 59
    const/16 v16, 0
    invoke-static/range v8 ... v16, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v7
    invoke-interface v2, v7, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    new-array v2, v5, [Lkotlin/Pair;
    const-string v7, "cli_id"
    iget-object v8, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->$id Ljava/lang/String;
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v4
    iget-object v7, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getChatMode()Lcom/bytedance/trae/im/service/Mode;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Mode;->getValue()Ljava/lang/String;
    move-result-object v7
    const-string v8, "mode"
    invoke-static v8, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v6
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    move-object v8, v0
    check-cast v8, Lkotlin/coroutines/Continuation;
    iput v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->label I
    invoke-virtual v7, v2, v8, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->getUserProjectFoldersRawCall(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v7, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v7, +174h
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v3
    if-eqz v3, +11eh
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/UserProjectFoldersData;
    const/4 v2, 0
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/UserProjectFoldersData;->getPaths()Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v2
    if-nez v1, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_userFolders$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_defaultFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-static v1, Lkotlin/collections/CollectionsKt;->firstOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    invoke-interface v3, v7, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v1, v6, Lkotlin/collections/CollectionsKt;->drop(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    xor-int/2addr v3, v6
    if-eqz v3, +09ch
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    sget-object v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    invoke-virtual v3, v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->setMode(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V
    check-cast v1, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v7, 10
    invoke-static v1, v7, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v7
    invoke-direct v3, v7, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    move v7, v4
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +04eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    add-int/lit8 v9, v7, 1
    if-gez v7, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    move-object v13, v8
    check-cast v13, Ljava/lang/String;
    const/16 v7, 47
    invoke-static v13, v7, v2, v5, v2, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    const/16 v8, 92
    invoke-static v7, v8, v2, v5, v2, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    invoke-static v9, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v11
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v8
    if-nez v8, +004h
    move v8, v6
    goto +2h
    move v8, v4
    if-eqz v8, +003h
    move-object v7, v13
    move-object v12, v7
    check-cast v12, Ljava/lang/String;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v22, 2000
    const/16 v23, 0
    new-instance v7, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    move-object v10, v7
    invoke-direct/range v10 ... v23, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move v7, v9
    goto -51h
    check-cast v3, Ljava/util/List;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$applyPreselection(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    sget-object v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->RECENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    const/16 v11, 26
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto/16 +0e3h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    sget-object v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->DOCUMENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->setMode(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 1
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;->DOCUMENT Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode;
    const/16 v10, 27
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_defaultFolder$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    if-nez v1, +004h
    const-string v1, ""
    move-object v3, v1
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 2
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->loadDocumentFolder$default(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; I Z I Ljava/lang/Object;)V
    goto/16 +09ch
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 59
    const/4 v14, 0
    invoke-static/range v6 ... v14, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v4
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_fetch_project_failed I
    invoke-static v6, v7, v8, v2, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; J Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->label I
    invoke-interface v3, v4, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +053h
    return-object v1
    instance-of v4, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v4, +051h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 59
    const/4 v14, 0
    invoke-static/range v6 ... v14, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v5
    invoke-interface v4, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v4
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_fetch_project_failed I
    invoke-static v6, v7, v2, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; I Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$loadInitialData$1;->label I
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
