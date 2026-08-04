# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/MergeDiffManager;
.super Ljava/lang/Object;
.source "MergeDiffManager.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final decodeGitContent(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    const/4 v0, 1
    if-eqz v0, +005h
    const-string v3, ""
    return-object v3
    const-string v0, "base64"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +015h
    invoke-static v4, v1, Landroid/util/Base64;->decode(Ljava/lang/String; I)[B
    move-result-object v3
    invoke-static v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v3, Lcom/bytedance/trae/conversation/fileupload/ResourceUploadUtilKt;->decodeContent([B)[B
    move-result-object v3
    new-instance v0, Ljava/lang/String;
    sget-object v1, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    invoke-direct v0, v3, v1, Ljava/lang/String;-><init>([B Ljava/nio/charset/Charset;)V
    move-object v4, v0
    return-object v4
    :try_start_0x1d
.end method

.method private final extractFileName(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v1
    goto +2h
    const/4 v2, 1
    if-eqz v2, +005h
    const-string v6, ""
    return-object v6
    const/16 v2, 92
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v2, v1, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/16 v2, 47
    invoke-static v6, v2, v4, v3, v4, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    return-object v6
.end method

.method public final fetchMergeDiffs(java.lang.String  com.bytedance.trae.im.model.MergeChangedFilesData  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 35
    # ins_size=5
    move-object/from16 v0, v30
    move-object/from16 v1, v34
    instance-of v2, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;-><init>(Lcom/bytedance/trae/conversation/products/MergeDiffManager; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    const/4 v5, 2
    const-string v6, ""
    const/4 v8, 1
    if-eqz v4, +039h
    if-eq v4, v8, +022h
    if-ne v4, v5, +018h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$3 Ljava/lang/Object;
    check-cast v3, Ljava/util/Set;
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v5, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$1 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v11, v4
    goto/16 +1c5h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget-object v4, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$2 Ljava/lang/Object;
    check-cast v4, Ljava/lang/String;
    iget-object v10, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$1 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/im/model/MergeChangedFilesData;
    iget-object v11, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$0 Ljava/lang/Object;
    check-cast v11, Lcom/bytedance/trae/conversation/products/MergeDiffManager;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v29, v10
    move-object v10, v4
    move-object/from16 v4, v29
    goto +1ch
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v1, Lcom/bytedance/trae/im/service/IChatSessionApi;->Companion Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$0 Ljava/lang/Object;
    move-object/from16 v4, v32
    iput-object v4, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$1 Ljava/lang/Object;
    move-object/from16 v10, v33
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$2 Ljava/lang/Object;
    iput v8, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    move-object/from16 v11, v31
    invoke-virtual v1, v11, v2, Lcom/bytedance/trae/im/service/IChatSessionApi$Companion;->getChatSessionRawCall(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v11, v0
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v12, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v12, +331h
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
    const/4 v1, 0
    if-nez v1, +01dh
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v13, -1005
    const-string v14, "explorer_url is null"
    new-instance v2, Ljava/lang/Exception;
    const-string v3, "explorer_url is null"
    invoke-direct v2, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v15, v2
    check-cast v15, Ljava/lang/Throwable;
    const/16 v16, 0
    const/16 v17, 8
    const/16 v18, 0
    move-object v12, v1
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getMergeBaseHash()Ljava/lang/String;
    move-result-object v12
    if-nez v12, +01eh
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v14, -1005
    const-string v15, "merge_base_hash is null"
    new-instance v2, Ljava/lang/Exception;
    const-string v3, "merge_base_hash is null"
    invoke-direct v2, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object/from16 v16, v2
    check-cast v16, Ljava/lang/Throwable;
    const/16 v17, 0
    const/16 v18, 8
    const/16 v19, 0
    move-object v13, v1
    invoke-direct/range v13 ... v19, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getSourceBranchHash()Ljava/lang/String;
    move-result-object v13
    if-nez v13, +020h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v15, -1005
    const-string/jumbo v16, source_branch_hash is null
    new-instance v2, Ljava/lang/Exception;
    const-string/jumbo v3, source_branch_hash is null
    invoke-direct v2, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object/from16 v17, v2
    check-cast v17, Ljava/lang/Throwable;
    const/16 v18, 0
    const/16 v19, 8
    const/16 v20, 0
    move-object v14, v1
    invoke-direct/range v14 ... v20, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v14
    if-eqz v14, +02dh
    check-cast v14, Ljava/lang/Iterable;
    new-instance v15, Ljava/util/ArrayList;
    invoke-direct v15, Ljava/util/ArrayList;-><init>()V
    check-cast v15, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v16
    if-eqz v16, +017h
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v16
    check-cast v16, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;
    invoke-virtual/range v16, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v5
    invoke-direct v11, v5, Lcom/bytedance/trae/conversation/products/MergeDiffManager;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +005h
    invoke-interface v15, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    const/4 v5, 2
    goto -1ah
    check-cast v15, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v15
    invoke-virtual v4, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +065h
    check-cast v5, Ljava/lang/Iterable;
    new-instance v14, Ljava/util/ArrayList;
    invoke-direct v14, Ljava/util/ArrayList;-><init>()V
    check-cast v14, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v16
    if-eqz v16, +01eh
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v9
    move-object/from16 v17, v9
    check-cast v17, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;
    invoke-virtual/range v17, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->isConflict()Ljava/lang/Boolean;
    move-result-object v7
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +005h
    invoke-interface v14, v9, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object/from16 v0, v30
    goto -21h
    check-cast v14, Ljava/util/List;
    check-cast v14, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +016h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;
    invoke-virtual v7, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v7
    invoke-direct v11, v7, Lcom/bytedance/trae/conversation/products/MergeDiffManager;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    if-eqz v7, -014h
    invoke-interface v0, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    if-eqz v0, +003h
    goto +5h
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v0
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, Ljava/lang/StringBuilder;-><init>()V
    new-array v7, v8, [C
    const/16 v9, 47
    const/4 v14, 0
    aput-char v9, v7, v14
    invoke-static v1, v7, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, v9, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v5
    const-class v7, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v5, v7, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v5, +007h
    invoke-interface v5, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +003h
    move-object v5, v6
    new-instance v7, Ljava/lang/StringBuilder;
    const-string v9, "Cloud-IDE-JWT "
    invoke-direct v7, v9, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    const-string v7, "authorization"
    invoke-static v7, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v5
    invoke-static v5, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/im/service/IGitBatchDiffApi;->Companion Lcom/bytedance/trae/im/service/IGitBatchDiffApi$Companion;
    new-instance v9, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;
    const/4 v14, 0
    invoke-direct v9, v12, v13, v15, v14, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$batchResult$1;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    iput-object v11, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$0 Ljava/lang/Object;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$1 Ljava/lang/Object;
    iput-object v10, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$2 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->L$3 Ljava/lang/Object;
    const/4 v12, 2
    iput v12, v2, Lcom/bytedance/trae/conversation/products/MergeDiffManager$fetchMergeDiffs$1;->label I
    invoke-virtual v7, v1, v5, v9, v2, Lcom/bytedance/trae/im/service/IGitBatchDiffApi$Companion;->safeCall(Ljava/lang/String; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v3, v0
    move-object v5, v4
    move-object v2, v11
    move-object v11, v10
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +003h
    return-object v1
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +19bh
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/GitBatchDiffResponse;
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/GitBatchDiffResponse;->getDiffs()Ljava/util/List;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0e2h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/service/GitFileDiff;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->getPath()Ljava/lang/String;
    move-result-object v7
    if-nez v7, +005h
    const/4 v14, 0
    goto/16 +0cch
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->isConflict()Ljava/lang/Boolean;
    move-result-object v9
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v10
    invoke-static v9, v10, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-nez v9, +00ch
    invoke-interface v3, v7, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +003h
    goto +4h
    const/16 v27, 0
    goto +3h
    move/from16 v27, v8
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->getBaseContent()Lcom/bytedance/trae/im/service/GitFileContent;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/GitFileContent;->getEncoding()Ljava/lang/String;
    move-result-object v14
    goto +2h
    const/4 v14, 0
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->getBaseContent()Lcom/bytedance/trae/im/service/GitFileContent;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/GitFileContent;->getData()Ljava/lang/String;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    invoke-direct v2, v14, v9, Lcom/bytedance/trae/conversation/products/MergeDiffManager;->decodeGitContent(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v24
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->getHeadContent()Lcom/bytedance/trae/im/service/GitFileContent;
    move-result-object v9
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/GitFileContent;->getEncoding()Ljava/lang/String;
    move-result-object v14
    goto +2h
    const/4 v14, 0
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileDiff;->getHeadContent()Lcom/bytedance/trae/im/service/GitFileContent;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/GitFileContent;->getData()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    invoke-direct v2, v14, v4, Lcom/bytedance/trae/conversation/products/MergeDiffManager;->decodeGitContent(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v25
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getFileDiffInfos()Ljava/util/List;
    move-result-object v4
    if-eqz v4, +028h
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v9
    if-eqz v9, +018h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    move-object v9, v14
    check-cast v9, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;
    invoke-virtual v9, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v9
    invoke-direct v2, v9, Lcom/bytedance/trae/conversation/products/MergeDiffManager;->extractFileName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-static v9, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, -019h
    goto +2h
    const/4 v14, 0
    check-cast v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;
    goto +2h
    const/4 v14, 0
    if-nez v14, +004h
    goto/16 -084h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v4
    if-eqz v4, +009h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    move/from16 v22, v4
    goto +3h
    const/16 v22, 0
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v4
    if-eqz v4, +009h
    invoke-virtual v4, Ljava/lang/Integer;->intValue()I
    move-result v4
    move/from16 v23, v4
    goto +3h
    const/16 v23, 0
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFileAction()Ljava/lang/String;
    move-result-object v4
    const-string v9, "added"
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    const/16 v20, 0
    goto +7h
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    move-object/from16 v20, v4
    invoke-virtual v14, Lcom/bytedance/trae/im/model/MergeFileDiffInfo;->getFilePath()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +005h
    move-object/from16 v21, v7
    goto +3h
    move-object/from16 v21, v4
    new-instance v14, Lcom/bytedance/trae/conversation/products/DiffFile;
    const/16 v26, 0
    move-object/from16 v19, v14
    invoke-direct/range v19 ... v27, Lcom/bytedance/trae/conversation/products/DiffFile;-><init>(Ljava/lang/String; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String; Z Z)V
    if-eqz v14, -0dfh
    invoke-interface v1, v14, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0e4h
    move-object v10, v1
    check-cast v10, Ljava/util/List;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTotalDiffInfo()Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;
    move-result-object v0
    const-wide/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getInsertLineCount()Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +008h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    move v12, v1
    goto +1ch
    move-object v1, v10
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v2, 0
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +00eh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/products/DiffFile;->getInsertLineCount()I
    move-result v3
    add-int/2addr v2, v3
    goto -11h
    move v12, v2
    if-eqz v0, +00eh
    invoke-virtual v0, Lcom/bytedance/trae/im/model/MergeTotalDiffInfo;->getDeleteLineCount()Ljava/lang/Integer;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    move v13, v0
    goto +1ch
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const/4 v7, 0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/products/DiffFile;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/products/DiffFile;->getDeleteLineCount()I
    move-result v1
    add-int/2addr v7, v1
    goto -11h
    move v13, v7
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getSourceBranch()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v14, v6
    goto +2h
    move-object v14, v0
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MergeChangedFilesData;->getTargetBranch()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v15, v6
    goto +2h
    move-object v15, v0
    new-instance v25, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;
    move-object/from16 v9, v25
    invoke-direct/range v9 ... v15, Lcom/bytedance/trae/conversation/products/MergeDiffManager$MergeDiffResult;-><init>(Ljava/util/List; Ljava/lang/String; I I Ljava/lang/String; Ljava/lang/String;)V
    const/16 v26, 0
    const/16 v27, 47
    const/16 v28, 0
    new-instance v0, Lcom/bytedance/trae/network/response/BizResponse;
    move-object/from16 v19, v0
    invoke-direct/range v19 ... v28, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const/4 v2, 0
    invoke-direct v1, v0, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +003h
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method
