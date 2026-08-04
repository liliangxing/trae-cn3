# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;
.super Lkotlin/coroutines/jvm/internal/SuspendLambda;
.source "ArtifactListActivity.kt"

.implements Lkotlin/jvm/functions/Function2;

.field final synthetic $chatSessionId:Ljava/lang/String;
.field final synthetic $cliType:Ljava/lang/String;
.field final synthetic $conversationId:Ljava/lang/String;
.field final synthetic $turnId:Ljava/lang/String;
.field  L$0:Ljava/lang/Object;
.field  label:I
.field final synthetic this$0:Lcom/bytedance/trae/conversation/products/ArtifactListActivity;


.method constructor <init>(java.lang.String  java.lang.String  com.bytedance.trae.conversation.products.ArtifactListActivity  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)void
    .registers 7
    # ins_size=7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$conversationId Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$chatSessionId Ljava/lang/String;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$turnId Ljava/lang/String;
    const/4 v1, 2
    invoke-direct v0, v1, v6, Lkotlin/coroutines/jvm/internal/SuspendLambda;-><init>(I Lkotlin/coroutines/Continuation;)V
    return-void 
.end method

.method public final create(java.lang.Object  kotlin.coroutines.Continuation)kotlin.coroutines.Continuation
    .registers 10
    # ins_size=3
    new-instance v8, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    iget-object v2, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$conversationId Ljava/lang/String;
    iget-object v3, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    iget-object v4, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$chatSessionId Ljava/lang/String;
    iget-object v5, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$turnId Ljava/lang/String;
    move-object v0, v8
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v8, Lkotlin/coroutines/Continuation;
    return-object v8
.end method

.method public bridge synthetic invoke(java.lang.Object  java.lang.Object)java.lang.Object
    .registers 3
    # ins_size=3
    check-cast v1, Lkotlinx/coroutines/CoroutineScope;
    check-cast v2, Lkotlin/coroutines/Continuation;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->invoke(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invoke(kotlinx.coroutines.CoroutineScope  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->create(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->invokeSuspend(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method public final invokeSuspend(java.lang.Object)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v0, v16
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->label I
    const-string v3, "/"
    const/4 v4, 3
    const/4 v5, 4
    const-string v6, "ArtifactPreviewActivity:Error "
    const-string v7, "ArtifactListActivity"
    const/4 v8, 0
    const/4 v9, 2
    const/4 v10, 1
    if-eqz v2, +024h
    if-eq v2, v10, +017h
    if-ne v2, v9, +00dh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/util/Map;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v11, v17
    goto/16 +07ah
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->L$0 Ljava/lang/Object;
    check-cast v1, Ljava/util/Map;
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v17
    goto/16 +16ah
    invoke-static/range v17, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    sget-object v12, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v12, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v12
    invoke-static v2, v12, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    const-string v12, "cliType"
    const-string v13, "conversation_id"
    if-nez v2, +124h
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    sget-object v14, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v14
    invoke-static v2, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    goto/16 +114h
    new-array v2, v5, [Lkotlin/Pair;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$conversationId Ljava/lang/String;
    invoke-static v13, v14, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v13
    aput-object v13, v2, v8
    iget-object v13, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    invoke-static v12, v13, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v2, v10
    iget-object v12, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$chatSessionId Ljava/lang/String;
    invoke-static v12, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v2, v9
    iget-object v12, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$turnId Ljava/lang/String;
    invoke-static v12, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v12
    aput-object v12, v2, v4
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    new-instance v12, Lcom/bytedance/trae/conversation/products/ArtifactListManager;
    invoke-direct v12, Lcom/bytedance/trae/conversation/products/ArtifactListManager;-><init>()V
    iget-object v13, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    iget-object v14, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$chatSessionId Ljava/lang/String;
    iget-object v15, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$turnId Ljava/lang/String;
    move-object v11, v0
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->L$0 Ljava/lang/Object;
    iput v9, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->label I
    invoke-virtual v12, v13, v14, v15, v11, Lcom/bytedance/trae/conversation/products/ArtifactListManager;->fetchArtifactList(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    move-object v1, v2
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +0a8h
    check-cast v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v11, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;
    if-nez v2, +00ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v11, Ljava/lang/Throwable;
    invoke-direct v11, Ljava/lang/Throwable;-><init>()V
    new-instance v12, Ljava/lang/StringBuilder;
    invoke-direct v12, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v12, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v11, v1, Lcom/bytedance/crash/Ensure;->ensureNotReachHereWithLogType(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    const/4 v6, 7
    new-array v6, v6, [Ljava/util/List;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedCodes()Ljava/util/List;
    move-result-object v7
    aput-object v7, v6, v8
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedDocs()Ljava/util/List;
    move-result-object v7
    aput-object v7, v6, v10
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedImages()Ljava/util/List;
    move-result-object v7
    aput-object v7, v6, v9
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedSheets()Ljava/util/List;
    move-result-object v7
    aput-object v7, v6, v4
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedSlides()Ljava/util/List;
    move-result-object v4
    aput-object v4, v6, v5
    const/4 v4, 5
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getChangedSkills()Ljava/util/List;
    move-result-object v5
    aput-object v5, v6, v4
    const/4 v4, 6
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;->getMergeProducts()Ljava/util/List;
    move-result-object v2
    aput-object v2, v6, v4
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->flatten(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +028h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    const/4 v6, 0
    invoke-static v5, v3, v6, v9, v6, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    move-object v6, v7
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +004h
    move v6, v10
    goto +2h
    move v6, v8
    if-eqz v6, -01dh
    new-instance v6, Lcom/bytedance/trae/conversation/products/ArtifactItem;
    invoke-static v4, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$getIconForFileName(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String;)I
    move-result v11
    invoke-direct v6, v7, v11, v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    invoke-interface v1, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -2bh
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showContent(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/util/List;)V
    goto/16 +134h
    instance-of v2, v11, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +01eh
    new-instance v2, Ljava/lang/Throwable;
    invoke-direct v2, Ljava/lang/Throwable;-><init>()V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v2, v1, Lcom/bytedance/crash/Ensure;->ensureNotReachHereWithLogType(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    goto/16 +114h
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
    new-array v2, v9, [Lkotlin/Pair;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$conversationId Ljava/lang/String;
    invoke-static v13, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v2, v8
    iget-object v4, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$cliType Ljava/lang/String;
    invoke-static v12, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v2, v10
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;->Companion Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;
    new-instance v5, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;
    iget-object v11, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->$conversationId Ljava/lang/String;
    const/4 v12, 0
    invoke-direct v5, v11, v12, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1$result$1;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v11, v0
    check-cast v11, Lkotlin/coroutines/Continuation;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->L$0 Ljava/lang/Object;
    iput v10, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->label I
    invoke-virtual v4, v5, v11, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    if-ne v4, v1, +003h
    return-object v1
    move-object v1, v2
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +0b4h
    check-cast v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v4, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;
    if-nez v2, +00ah
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, ""
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->getArtifacts()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +00bh
    invoke-interface v5, Ljava/util/List;->size()I
    move-result v5
    invoke-static v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v6
    goto +2h
    const/4 v6, 0
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, result
    invoke-static v1, v5, v4, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v4, Ljava/lang/Throwable;
    invoke-direct v4, Ljava/lang/Throwable;-><init>()V
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v6, "ArtifactListActivity:Success "
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v4, v1, Lcom/bytedance/crash/Ensure;->ensureNotReachHereWithLogType(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/products/GetArtifactListData;->getArtifacts()Ljava/util/List;
    move-result-object v1
    if-eqz v1, +04eh
    check-cast v1, Ljava/lang/Iterable;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +035h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/products/HubArtifactItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/products/HubArtifactItem;->getPath()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +005h
    const/4 v6, 0
    const/4 v11, 0
    goto +1fh
    const/4 v6, 0
    invoke-static v5, v3, v6, v9, v6, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    move-object v11, v7
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +004h
    move v11, v10
    goto +2h
    move v11, v8
    if-eqz v11, +00ch
    new-instance v11, Lcom/bytedance/trae/conversation/products/ArtifactItem;
    invoke-static v2, v7, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$getIconForFileName(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/lang/String;)I
    move-result v12
    invoke-direct v11, v7, v12, v5, Lcom/bytedance/trae/conversation/products/ArtifactItem;-><init>(Ljava/lang/String; I Ljava/lang/String;)V
    goto +2h
    move-object v11, v6
    if-eqz v11, -033h
    invoke-interface v4, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -38h
    move-object v11, v4
    check-cast v11, Ljava/util/List;
    goto +3h
    const/4 v6, 0
    move-object v11, v6
    if-nez v11, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v11
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v1, v11, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showContent(Lcom/bytedance/trae/conversation/products/ArtifactListActivity; Ljava/util/List;)V
    goto +24h
    instance-of v2, v4, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v2, +024h
    const-string v2, "error"
    invoke-static v1, v2, v4, Lcom/larus/business/markdown/impl/common/utils/ExtrasKt;->putExtra(Ljava/lang/Object; Ljava/lang/String; Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v2, Ljava/lang/Throwable;
    invoke-direct v2, Ljava/lang/Throwable;-><init>()V
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static v7, v2, v1, Lcom/bytedance/crash/Ensure;->ensureNotReachHereWithLogType(Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/products/ArtifactListActivity$loadArtifactList$1;->this$0 Lcom/bytedance/trae/conversation/products/ArtifactListActivity;
    invoke-static v1, Lcom/bytedance/trae/conversation/products/ArtifactListActivity;->access$showError(Lcom/bytedance/trae/conversation/products/ArtifactListActivity;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
    new-instance v1, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v1, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v1
.end method
