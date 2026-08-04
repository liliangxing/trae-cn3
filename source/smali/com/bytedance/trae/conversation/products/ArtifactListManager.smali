# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/ArtifactListManager;
.super Ljava/lang/Object;
.source "ArtifactListManager.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final fetchArtifactList(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 28
    # ins_size=5
    move-object/from16 v0, v25
    move-object/from16 v1, v27
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    move-object/from16 v3, v23
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;
    move-object/from16 v3, v23
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;-><init>(Lcom/bytedance/trae/conversation/products/ArtifactListManager; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    const-string v6, ""
    const/4 v7, 2
    const/4 v8, 1
    const/4 v9, 0
    if-eqz v5, +02bh
    if-eq v5, v8, +018h
    if-ne v5, v7, +00eh
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0f2h
    move-exception v0
    move-object v7, v0
    goto/16 +141h
    move-exception v0
    goto/16 +155h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$1 Ljava/lang/Object;
    check-cast v0, Ljava/lang/String;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$0 Ljava/lang/Object;
    check-cast v5, Ljava/lang/String;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v22, v5
    move-object v5, v0
    move-object/from16 v0, v22
    goto +15h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$0 Ljava/lang/Object;
    move-object/from16 v5, v26
    iput-object v5, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$1 Ljava/lang/Object;
    iput v8, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    invoke-virtual v1, v0, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v4, +003h
    return-object v4
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v10, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v10, +137h
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    if-eqz v1, +007h
    invoke-virtual v1, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v9
    if-nez v1, +01ch
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v11, -1005
    const-string v12, "explorer_url is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "explorer_url is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v13, v1
    check-cast v13, Ljava/lang/Throwable;
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "products-"
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v10, ".json"
    invoke-virtual v5, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    new-instance v10, Ljava/lang/StringBuilder;
    invoke-direct v10, Ljava/lang/StringBuilder;-><init>()V
    new-array v11, v8, [C
    const/4 v12, 0
    const/16 v13, 47
    aput-char v13, v11, v12
    invoke-static v1, v11, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v13, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v17
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v10, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v10, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v9
    if-nez v1, +003h
    move-object v1, v6
    new-array v8, v8, [Lkotlin/Pair;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string v11, "Cloud-IDE-JWT "
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v10, "authorization"
    invoke-static v10, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v8, v12
    invoke-static v8, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v18
    sget-object v13, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v14, "diff_view"
    const-class v15, Lcom/bytedance/trae/conversation/products/IArtifactListApi;
    const/16 v16, 0
    const/16 v19, 0
    const/16 v20, 36
    const/16 v21, 0
    invoke-static/range v13 ... v21, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/IArtifactListApi;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$0 Ljava/lang/Object;
    iput-object v9, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->L$1 Ljava/lang/Object;
    iput v7, v2, Lcom/bytedance/trae/conversation/products/ArtifactListManager$fetchArtifactList$1;->label I
    invoke-interface v1, v5, v0, v2, Lcom/bytedance/trae/conversation/products/IArtifactListApi;->getArtifactList(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v4, +003h
    return-object v4
    check-cast v1, Lcom/bytedance/retrofit2/SsResponse;
    if-eqz v1, +009h
    invoke-virtual v1, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    goto +2h
    move-object v0, v9
    if-nez v0, +01eh
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v11, -1005
    const-string v12, "Response body is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v2, "Response body is null"
    invoke-direct v1, v2, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v13, v1
    check-cast v13, Ljava/lang/Throwable;
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +55h
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v1, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;
    invoke-virtual v1, v0, v2, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    move-object/from16 v16, v0
    check-cast v16, Lcom/bytedance/trae/conversation/products/ArtifactListResponse;
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v1, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v17, 0
    const/16 v18, 47
    const/16 v19, 0
    move-object v10, v1
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v0, v1, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +2ch
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1000
    invoke-virtual v7, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v6, v1
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v0
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1001
    const-string v6, ""
    move-object v7, v0
    check-cast v7, Ljava/lang/Throwable;
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v1
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +003h
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    :try_start_0x34
    :try_start_0x108
.end method
