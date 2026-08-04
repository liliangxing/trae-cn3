# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/DiffViewManager;
.super Ljava/lang/Object;
.source "DiffViewManager.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final fetchDiffView(java.lang.String  java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=5
    instance-of v12, v15, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;
    if-eqz v12, +012h
    move-object v12, v15
    check-cast v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;
    iget v0, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    const/high16 v1, -2147483648
    and-int/2addr v0, v1
    if-eqz v0, +008h
    iget v15, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    sub-int/2addr v15, v1
    iput v15, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    goto +6h
    new-instance v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;
    invoke-direct v12, v11, v15, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;-><init>(Lcom/bytedance/trae/conversation/products/DiffViewManager; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +020h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0e3h
    new-instance v12, Ljava/lang/IllegalStateException;
    const-string v13, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v12, v13, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v12
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$1 Ljava/lang/Object;
    move-object v14, v13
    check-cast v14, Ljava/lang/String;
    iget-object v13, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$0 Ljava/lang/Object;
    check-cast v13, Ljava/lang/String;
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +13h
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput-object v13, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$0 Ljava/lang/Object;
    iput-object v14, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$1 Ljava/lang/Object;
    iput v3, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    invoke-virtual v15, v13, v12, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +0b7h
    check-cast v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v15
    invoke-virtual v15, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/im/service/ChatSessionResponse;
    const/4 v1, 0
    if-eqz v15, +007h
    invoke-virtual v15, Lcom/bytedance/trae/im/service/ChatSessionResponse;->getExplorerUrl()Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v1
    if-nez v15, +01bh
    new-instance v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v5, -1005
    const-string v6, "explorer_url is null"
    new-instance v13, Ljava/lang/Exception;
    const-string v14, "explorer_url is null"
    invoke-direct v13, v14, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v7, v13
    check-cast v7, Ljava/lang/Throwable;
    const/4 v8, 0
    const/16 v9, 8
    const/4 v10, 0
    move-object v4, v12
    invoke-direct/range v4 ... v10, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v12
    new-instance v4, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v4, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v5, Ljava/lang/StringBuilder;
    const-string/jumbo v6, turn-
    invoke-direct v5, v6, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const-string v5, ".json"
    invoke-virtual v14, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    iput-object v14, v4, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    new-instance v14, Ljava/lang/StringBuilder;
    invoke-direct v14, Ljava/lang/StringBuilder;-><init>()V
    new-array v5, v3, [C
    const/4 v6, 0
    const/16 v7, 47
    aput-char v7, v5, v6
    invoke-static v15, v5, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v15
    invoke-virtual v14, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v7, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v14
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v15
    const-class v5, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v15, v5, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v15, +007h
    invoke-interface v15, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v15
    goto +2h
    move-object v15, v1
    if-nez v15, +004h
    const-string v15, ""
    new-array v3, v3, [Lkotlin/Pair;
    new-instance v5, Ljava/lang/StringBuilder;
    const-string v7, "Cloud-IDE-JWT "
    invoke-direct v5, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v15, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v15
    const-string v5, "authorization"
    invoke-static v5, v15, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v15
    aput-object v15, v3, v6
    invoke-static v3, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v15
    sget-object v3, Lcom/bytedance/trae/im/service/IDiffViewApi;->Companion Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
    new-instance v5, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$2;
    invoke-direct v5, v4, v13, v1, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$2;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v5, Lkotlin/jvm/functions/Function2;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$0 Ljava/lang/Object;
    iput-object v1, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->L$1 Ljava/lang/Object;
    iput v2, v12, Lcom/bytedance/trae/conversation/products/DiffViewManager$fetchDiffView$1;->label I
    invoke-virtual v3, v14, v15, v5, v12, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;->safeCall(Ljava/lang/String; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    return-object v15
    instance-of v12, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v12, +003h
    return-object v15
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
.end method
