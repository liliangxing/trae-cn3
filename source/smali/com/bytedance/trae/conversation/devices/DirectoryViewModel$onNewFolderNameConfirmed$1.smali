# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "DirectoryViewModel.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $placeholderId:Ljava/lang/String;
.field final synthetic $trimmedName:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;


.method constructor <init>(com.bytedance.trae.conversation.devices.DirectoryViewModel  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 5
    # ins_size=5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v4, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 6
    # ins_size=3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    invoke-direct v4, v0, v1, v2, v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;-><init>(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/coroutines/Continuation;
    return-object v4
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 30
    # ins_size=2
    move-object/from16 v0, v28
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->label I
    const-string v3, ""
    const/4 v4, 4
    const/4 v5, 3
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v2, +023h
    if-eq v2, v8, +016h
    if-eq v2, v6, +00fh
    if-eq v2, v5, +00dh
    if-ne v2, v4, +003h
    goto +9h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +1e6h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v2
    move-object/from16 v2, v29
    goto +42h
    invoke-static/range v29, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    iget-object v10, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    invoke-static v2, v9, v7, v8, v10, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$updatePlaceholderState(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; Ljava/lang/String; Z Z Ljava/lang/String;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->getCliId()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +005h
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    iget-object v9, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v9
    invoke-interface v9, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    new-instance v10, Lcom/bytedance/trae/conversation/network/CreateFolderRequest;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentParentId()Ljava/lang/String;
    move-result-object v11
    if-nez v11, +003h
    move-object v11, v3
    iget-object v12, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    invoke-direct v10, v2, v11, v12, Lcom/bytedance/trae/conversation/network/CreateFolderRequest;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/conversation/network/IGetProjectApi;->Companion Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;
    move-object v11, v0
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->L$0 Ljava/lang/Object;
    iput v8, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->label I
    invoke-virtual v2, v10, v11, Lcom/bytedance/trae/conversation/network/IGetProjectApi$Companion;->createFolderRawCall(Lcom/bytedance/trae/conversation/network/CreateFolderRequest; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v8, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v10, 0
    if-eqz v8, +15dh
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v4
    if-eqz v4, +121h
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/CreateFolderData;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/CreateFolderData;->getFolder()Lcom/bytedance/trae/conversation/network/FolderNode;
    move-result-object v2
    goto +2h
    move-object v2, v10
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v4
    invoke-interface v4, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getNodes()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->toMutableList(Ljava/util/Collection;)Ljava/util/List;
    move-result-object v12
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    invoke-interface v12, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    move v8, v7
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    const/4 v13, -1
    if-eqz v11, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +003h
    goto +5h
    add-int/lit8 v8, v8, 1
    goto -1ah
    move v8, v13
    if-eq v8, v13, +0bdh
    invoke-interface v12, v8, Ljava/util/List;->remove(I)Ljava/lang/Object;
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    move-object v15, v4
    if-eqz v2, +008h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/FolderNode;->getName()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    move-object/from16 v16, v4
    if-eqz v2, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/FolderNode;->getPath()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +4h
    move-object/from16 v17, v2
    goto +3h
    move-object/from16 v17, v3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentDepth()I
    move-result v18
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentParentId()Ljava/lang/String;
    move-result-object v19
    new-instance v2, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 1344
    const/16 v27, 0
    move-object v14, v2
    invoke-direct/range v14 ... v27, Lcom/bytedance/trae/conversation/devices/DirectoryNode;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->getCurrentParentId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v4
    if-eqz v3, +045h
    invoke-interface v12, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getId()Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    goto +5h
    add-int/lit8 v7, v7, 1
    goto -19h
    move v7, v13
    if-eq v7, v13, +024h
    add-int/lit8 v3, v7, 1
    move v4, v3
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v3
    if-ge v4, v3, +01bh
    invoke-interface v12, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v3
    invoke-interface v12, v7, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/devices/DirectoryNode;->getDepth()I
    move-result v5
    if-le v3, v5, +005h
    add-int/lit8 v4, v4, 1
    goto -1eh
    invoke-interface v12, v4, v2, Ljava/util/List;->add(I Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_uiState$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v11, v3
    check-cast v11, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 62
    const/16 v19, 0
    invoke-static/range v11 ... v19, Lcom/bytedance/trae/conversation/devices/DirectoryUiState;->copy$default(Lcom/bytedance/trae/conversation/devices/DirectoryUiState; Ljava/util/List; Ljava/lang/String; Z Ljava/lang/String; I Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$Mode; I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/DirectoryUiState;
    move-result-object v3
    invoke-interface v2, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v2, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FolderCreated;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$trimmedName Ljava/lang/String;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$FolderCreated;-><init>(Ljava/lang/String;)V
    move-object v4, v0
    check-cast v4, Lkotlin/coroutines/Continuation;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->L$0 Ljava/lang/Object;
    iput v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->label I
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +069h
    return-object v1
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cancelNewFolder(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v9, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_create_failed I
    invoke-static v6, v7, v8, v2, v9, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; J Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->label I
    invoke-interface v3, v4, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +039h
    return-object v1
    instance-of v3, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v3, +037h
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    iget-object v5, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->$placeholderId Ljava/lang/String;
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->cancelNewFolder(Ljava/lang/String;)V
    iget-object v3, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    invoke-static v3, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$get_events$p(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v3
    new-instance v5, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->this$0 Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v7
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v2
    sget v8, Lcom/bytedance/trae/multilanguage/R$string;->trae_dir_create_failed I
    invoke-static v6, v7, v2, v8, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel;->access$errorMessage(Lcom/bytedance/trae/conversation/devices/DirectoryViewModel; I Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v2
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/devices/DirectoryEvent$ShowToast;-><init>(Ljava/lang/String;)V
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/Continuation;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/devices/DirectoryViewModel$onNewFolderNameConfirmed$1;->label I
    invoke-interface v3, v5, v2, Lkotlinx/coroutines/flow/MutableSharedFlow;->emit(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
