# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
.super Ljava/lang/Object;
.source "GitRemoteRepository.kt"

.field public static final CODE_GIT_DISCONNECTED:J
.field public static final CODE_GIT_TOKEN_EXPIRE:J
.field public static final Companion:Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
.field private static final MAX_BRANCH_CACHE_SIZE:I
.field private static final instance$delegate:Lkotlin/Lazy;
.field private _gitConnectionState:Lcom/bytedance/trae/conversation/git/GitConnectionState;
.field private final branchCacheMap:Ljava/util/Map;
.field private cachedAllRepos:Ljava/util/List;
.field private cachedRepos:Ljava/util/List;
.field private final mutex:Lkotlinx/coroutines/sync/Mutex;
.field private nextPageToken:Ljava/lang/String;
.field private preloaded:Z
.field private total:Ljava/lang/Long;


.method public static synthetic $r8$lambda$F8UrkwRdZJhKFBV0nQtlqg7a6Zk()com.bytedance.trae.conversation.network.GitRemoteRepository
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->instance_delegate$lambda$8()Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->Companion Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->instance$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 4
    # ins_size=1
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    const/4 v0, 1
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v2, v0, v1, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    sget-object v0, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    return-void 
.end method

.method public static final synthetic access$getInstance$delegate$cp()kotlin.Lazy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->instance$delegate Lkotlin/Lazy;
    return-object v0
.end method

.method public static final synthetic access$listRepositoriesFromServer(com.bytedance.trae.conversation.network.GitRemoteRepository  java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listRepositoriesFromServer(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final varargs buildQuery(kotlin.Pair[])java.util.Map
    .registers 7
    # ins_size=2
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    array-length v1, v6
    const/4 v2, 0
    if-ge v2, v1, +01ah
    aget-object v3, v6, v2
    invoke-virtual v3, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v3, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v3
    if-eqz v3, +009h
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-interface v0, v4, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    add-int/lit8 v2, v2, 1
    goto -19h
    return-object v0
.end method

.method public static synthetic fetchBranches$default(com.bytedance.trae.conversation.network.GitRemoteRepository  java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 15
    # ins_size=8
    and-int/lit8 v14, v13, 2
    const/4 v0, 0
    if-eqz v14, +004h
    move-object v3, v0
    goto +2h
    move-object v3, v9
    and-int/lit8 v9, v13, 4
    if-eqz v9, +004h
    move-object v4, v0
    goto +2h
    move-object v4, v10
    and-int/lit8 v9, v13, 8
    if-eqz v9, +004h
    move-object v5, v0
    goto +2h
    move-object v5, v11
    move-object v1, v7
    move-object v2, v8
    move-object v6, v12
    invoke-virtual/range v1 ... v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->fetchBranches(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    return-object v7
.end method

.method private static final instance_delegate$lambda$8()com.bytedance.trae.conversation.network.GitRemoteRepository
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;-><init>()V
    return-object v0
.end method

.method public static synthetic listBranches$default(com.bytedance.trae.conversation.network.GitRemoteRepository  java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 2
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v3, v0
    and-int/lit8 v6, v6, 4
    if-eqz v6, +003h
    move-object v4, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listBranches(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    return-object v1
.end method

.method private final listRepositoriesFromServer(java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=5
    move-object/from16 v0, v20
    move-object/from16 v1, v21
    instance-of v2, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;
    if-eqz v2, +014h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +00ah
    iget v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->label I
    move-object/from16 v3, v17
    goto +8h
    new-instance v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;
    move-object/from16 v3, v17
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->label I
    const/4 v6, 0
    const/4 v7, 1
    if-eqz v5, +010h
    if-ne v5, v7, +006h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4dh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-instance v1, Ljava/util/HashMap;
    invoke-direct v1, Ljava/util/HashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    const-string v5, "page_size"
    invoke-static/range v19, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v8
    invoke-interface v1, v5, v8, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v0, +007h
    const-string v5, "page_token"
    invoke-interface v1, v5, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-object/from16 v0, v18
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v6
    goto +2h
    move v5, v7
    if-nez v5, +00fh
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v5, "keyword"
    invoke-interface v1, v5, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lcom/bytedance/trae/conversation/network/IGetGitApi;->Companion Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    iput v7, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listRepositoriesFromServer$1;->label I
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->listRepositoriesRawCall(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v4, +003h
    return-object v4
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    const-string/jumbo v2, 获取仓库列表失败
    if-eqz v0, +06bh
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-nez v1, +02ah
    new-instance v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v9
    invoke-static v9, v10, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v9
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +00ch
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMessage()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    move-object v10, v2
    goto +4h
    move-object v10, v0
    goto +2h
    move-object v10, v4
    const/16 v11, 14
    const/4 v12, 0
    move-object v4, v1
    invoke-direct/range v4 ... v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;-><init>(Z Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto/16 +068h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/network/ListRepositoriesData;
    new-instance v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    const/4 v5, 1
    const/4 v2, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ListRepositoriesData;->getItems()Ljava/util/List;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-nez v4, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    move-object v6, v4
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ListRepositoriesData;->getTotal()Ljava/lang/Long;
    move-result-object v4
    move-object v7, v4
    goto +2h
    move-object v7, v2
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ListRepositoriesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v0
    move-object v8, v0
    goto +2h
    move-object v8, v2
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 48
    const/4 v12, 0
    move-object v4, v1
    invoke-direct/range v4 ... v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;-><init>(Z Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    goto +32h
    instance-of v0, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    if-eqz v0, +030h
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getCode()I
    move-result v0
    int-to-long v4, v0
    invoke-static v4, v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v13
    invoke-virtual v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;->getMsg()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    move v6, v7
    if-eqz v6, +003h
    goto +2h
    move-object v2, v0
    move-object v14, v2
    check-cast v14, Ljava/lang/String;
    const/16 v15, 14
    const/16 v16, 0
    new-instance v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    const/4 v9, 0
    move-object v8, v1
    invoke-direct/range v8 ... v16, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;-><init>(Z Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
.end method

.method public final fetchBranches(java.lang.String  java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=6
    move-object/from16 v0, v18
    move-object/from16 v1, v19
    move-object/from16 v2, v20
    move-object/from16 v3, v21
    move-object/from16 v4, v23
    instance-of v5, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;
    if-eqz v5, +012h
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;
    iget v6, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->label I
    const/high16 v7, -2147483648
    and-int/2addr v6, v7
    if-eqz v6, +008h
    iget v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->label I
    sub-int/2addr v4, v7
    iput v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->label I
    goto +6h
    new-instance v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;
    invoke-direct v5, v0, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v6
    iget v7, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->label I
    const/4 v8, 0
    const/4 v9, 1
    if-eqz v7, +025h
    if-ne v7, v9, +01bh
    iget v1, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->I$0 I
    iget-object v2, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$2 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$1 Ljava/lang/Object;
    check-cast v3, Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v17, v4
    move v4, v1
    move-object v1, v3
    move-object/from16 v3, v17
    goto/16 +08fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v4, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v4, v22
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v8
    goto +2h
    move v4, v9
    if-eqz v22, +005h
    move-object/from16 v7, v22
    goto +3h
    const-string v7, "1"
    sget-object v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v10, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v10
    const-string v11, "page_size"
    const/4 v12, 2
    const-string v13, "keyword"
    const-string/jumbo v14, repo_url
    const/4 v15, 3
    if-eqz v10, +024h
    const/4 v10, 4
    new-array v10, v10, [Lkotlin/Pair;
    invoke-static v14, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v14
    aput-object v14, v10, v8
    invoke-static v13, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v13
    aput-object v13, v10, v9
    invoke-static v11, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v10, v12
    const-string v3, "page_token"
    invoke-static v3, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v10, v15
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->buildQuery([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    goto +19h
    new-array v7, v15, [Lkotlin/Pair;
    invoke-static v14, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    aput-object v10, v7, v8
    invoke-static v13, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    aput-object v10, v7, v9
    invoke-static v11, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v7, v12
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->buildQuery([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v3
    sget-object v7, Lcom/bytedance/trae/conversation/network/IGetGitApi;->Companion Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$result$1;
    const/4 v12, 0
    invoke-direct v11, v3, v12, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$result$1;-><init>(Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    iput-object v0, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$0 Ljava/lang/Object;
    iput-object v1, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$1 Ljava/lang/Object;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->L$2 Ljava/lang/Object;
    iput v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->I$0 I
    iput v9, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchBranches$1;->label I
    invoke-virtual v7, v10, v11, v5, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->safeCall(Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v3
    if-ne v3, v6, +003h
    return-object v6
    move-object v5, v0
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult;
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v8
    goto +2h
    move v2, v9
    if-nez v2, +003h
    return-object v3
    instance-of v2, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +0b0h
    move-object v2, v3
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v6
    if-eqz v6, +0a3h
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    if-eqz v2, +097h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getItems()Ljava/util/List;
    move-result-object v6
    if-nez v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    iget-object v7, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    invoke-interface v7, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    move-object v10, v7
    check-cast v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    const/16 v7, 50
    if-eqz v4, +02ah
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v4
    if-gt v4, v7, +07ah
    iget-object v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    new-instance v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getTotal()Ljava/lang/Long;
    move-result-object v7
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +008h
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    move v8, v9
    invoke-direct v5, v6, v7, v10, v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z)V
    invoke-interface v4, v1, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +57h
    if-eqz v10, +056h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull()Z
    move-result v4
    if-nez v4, +050h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/util/Collection;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v4, v6, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v4
    if-gt v4, v7, +026h
    iget-object v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    const/4 v12, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v14, v8
    goto +2h
    move v14, v9
    const/4 v15, 2
    const/16 v16, 0
    invoke-static/range v10 ... v16, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->copy$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache; Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    move-result-object v2
    invoke-interface v4, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +19h
    iget-object v4, v5, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    check-cast v11, Ljava/lang/Iterable;
    invoke-static v11, v7, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v11
    const/4 v12, 0
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 1
    const/4 v15, 2
    const/16 v16, 0
    invoke-static/range v10 ... v16, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->copy$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache; Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    move-result-object v2
    invoke-interface v4, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v3
.end method

.method public final fetchRepos(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=3
    move-object/from16 v1, v19
    move-object/from16 v0, v21
    instance-of v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    const/4 v5, 2
    const/4 v6, 1
    const/4 v7, 0
    if-eqz v4, +02bh
    if-eq v4, v6, +01bh
    if-ne v4, v5, +011h
    iget-object v3, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$1 Ljava/lang/Object;
    check-cast v3, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    move-exception v0
    goto/16 +0c4h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-boolean v4, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->Z$0 Z
    iget-object v8, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$1 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/sync/Mutex;
    iget-object v9, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +19h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$0 Ljava/lang/Object;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$1 Ljava/lang/Object;
    move/from16 v4, v20
    iput-boolean v4, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->Z$0 Z
    iput v6, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    invoke-interface v0, v7, v2, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v3, +003h
    return-object v3
    move-object v8, v0
    move-object v9, v1
    iget-object v0, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/2addr v0, v6
    if-eqz v0, +008h
    if-nez v4, +006h
    iget-object v0, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    move-object v3, v8
    goto +58h
    const/16 v0, 100
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v9, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$0 Ljava/lang/Object;
    iput-object v8, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->L$1 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchRepos$1;->label I
    invoke-direct v9, v7, v0, v7, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listRepositoriesFromServer(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v3, v8
    move-object v2, v9
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v4
    if-nez v4, +035h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v4
    if-nez v4, +003h
    goto +ch
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    const-wide/32 v8, 991402
    cmp-long v4, v4, v8
    if-eqz v4, +018h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v4
    if-nez v4, +003h
    goto +dh
    invoke-virtual v4, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    const-wide/32 v8, 991403
    cmp-long v4, v4, v8
    if-nez v4, +003h
    goto +4h
    sget-object v4, Lcom/bytedance/trae/conversation/git/GitConnectionState;->ERROR Lcom/bytedance/trae/conversation/git/GitConnectionState;
    goto +9h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    iput-object v4, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    sget-object v4, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v4, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    goto +2eh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    move-object v9, v2
    iput-object v0, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    iput-object v7, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->nextPageToken Ljava/lang/String;
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v0
    int-to-long v4, v0
    invoke-static v4, v5, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->total Ljava/lang/Long;
    sget-object v0, Lcom/bytedance/trae/conversation/git/GitConnectionState;->CONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v0, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    const/4 v11, 1
    iget-object v12, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    iget-object v13, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->total Ljava/lang/Long;
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 48
    const/16 v18, 0
    move-object v10, v0
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;-><init>(Z Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v3, v7, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v0
    move-object v3, v8
    invoke-interface v3, v7, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x36
    :try_start_0x6b
    :try_start_0x91
.end method

.method public final fetchReposPage(int  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=4
    instance-of v0, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;
    invoke-direct v0, v7, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +033h
    if-eq v2, v4, +01fh
    if-ne v2, v3, +015h
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$2 Ljava/lang/Object;
    check-cast v8, Lkotlinx/coroutines/sync/Mutex;
    iget-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4dh
    move-exception v9
    goto/16 +0b9h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v9, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v9, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->I$0 I
    iget-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$2 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/sync/Mutex;
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v10, v7, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$1 Ljava/lang/Object;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$2 Ljava/lang/Object;
    iput v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->I$0 I
    iput v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    invoke-interface v10, v5, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v4, v7
    move-object v2, v9
    move-object v9, v10
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v8
    iput-object v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$0 Ljava/lang/Object;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$1 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->L$2 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$fetchReposPage$1;->label I
    invoke-direct v4, v5, v8, v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listRepositoriesFromServer(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    move-object v8, v9
    move-object v9, v2
    move-object v0, v4
    check-cast v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v1
    if-eqz v1, +034h
    if-nez v9, +00fh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    goto +13h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    check-cast v9, Ljava/util/Collection;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-static v9, v1, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getNextPageToken()Ljava/lang/String;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->nextPageToken Ljava/lang/String;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getTotal()Ljava/lang/Long;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->total Ljava/lang/Long;
    sget-object v9, Lcom/bytedance/trae/conversation/git/GitConnectionState;->CONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    goto +2dh
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v9
    if-nez v9, +003h
    goto +ch
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    const-wide/32 v3, 991402
    cmp-long v9, v1, v3
    if-eqz v9, +018h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getErrorCode()Ljava/lang/Long;
    move-result-object v9
    if-nez v9, +003h
    goto +dh
    invoke-virtual v9, Ljava/lang/Long;->longValue()J
    move-result-wide v1
    const-wide/32 v3, 991403
    cmp-long v9, v1, v3
    if-nez v9, +003h
    goto +4h
    sget-object v9, Lcom/bytedance/trae/conversation/git/GitConnectionState;->ERROR Lcom/bytedance/trae/conversation/git/GitConnectionState;
    goto +3h
    sget-object v9, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    invoke-interface v8, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v10
    move-exception v8
    move-object v6, v9
    move-object v9, v8
    move-object v8, v6
    invoke-interface v8, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v9
    :try_start_0x36
    :try_start_0x70
    :try_start_0x86
.end method

.method public final getCachedRepos()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    return-object v0
.end method

.method public final getGitConnectionState()com.bytedance.trae.conversation.git.GitConnectionState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    return-object v0
.end method

.method public final getNextPageToken()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->nextPageToken Ljava/lang/String;
    return-object v0
.end method

.method public final getTotal()java.lang.Long
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->total Ljava/lang/Long;
    return-object v0
.end method

.method public final listBranches(java.lang.String  java.lang.Integer  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 26
    # ins_size=5
    move-object/from16 v0, v21
    move-object/from16 v1, v22
    move-object/from16 v2, v23
    move-object/from16 v3, v25
    instance-of v4, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;
    if-eqz v4, +012h
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;
    iget v5, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->label I
    const/high16 v6, -2147483648
    and-int/2addr v5, v6
    if-eqz v5, +008h
    iget v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->label I
    sub-int/2addr v3, v6
    iput v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->label I
    goto +6h
    new-instance v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;
    invoke-direct v4, v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    iget v6, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->label I
    const/4 v7, 0
    const/4 v8, 1
    if-eqz v6, +021h
    if-ne v6, v8, +017h
    iget v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->I$0 I
    iget-object v2, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->L$1 Ljava/lang/Object;
    check-cast v2, Ljava/lang/String;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->L$0 Ljava/lang/Object;
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v20, v3
    move v3, v1
    move-object v1, v2
    move-object/from16 v2, v20
    goto/16 +14fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v3, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v3, v24
    check-cast v3, Ljava/lang/CharSequence;
    if-eqz v3, +00bh
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    if-eqz v3, +003h
    goto +3h
    move v3, v7
    goto +2h
    move v3, v8
    iget-object v6, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    invoke-interface v6, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    const/4 v9, 0
    if-eqz v6, +0e4h
    if-eqz v3, +05eh
    if-eqz v2, +007h
    invoke-virtual/range v23, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +9h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, v1, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    if-ge v2, v3, +011h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +00fh
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v2
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v4, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    new-instance v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getTotal()Ljava/lang/Long;
    move-result-object v6
    invoke-direct v5, v1, v6, v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String;)V
    const/16 v17, 0
    const/16 v18, 44
    const/16 v19, 0
    move-object v10, v4
    move-object/from16 v16, v5
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v3, v4, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    return-object v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull()Z
    move-result v10
    if-nez v10, +080h
    if-eqz v24, +007h
    invoke-static/range v24, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v10
    goto +2h
    move-object v10, v9
    if-eqz v10, +076h
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v11
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v12
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v12
    if-ge v11, v12, +068h
    if-eqz v2, +007h
    invoke-virtual/range v23, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +eh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v2
    sub-int/2addr v1, v2
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v2, v3, Lkotlin/collections/CollectionsKt;->drop(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, v1, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v1
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v2
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v3
    add-int/2addr v2, v3
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->size()I
    move-result v3
    if-ge v2, v3, +007h
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getNextPageToken()Ljava/lang/String;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v4, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    new-instance v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getTotal()Ljava/lang/Long;
    move-result-object v6
    invoke-direct v5, v1, v6, v2, Lcom/bytedance/trae/conversation/network/ListBranchesData;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String;)V
    const/16 v17, 0
    const/16 v18, 44
    const/16 v19, 0
    move-object v10, v4
    move-object/from16 v16, v5
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v3, v4, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    return-object v3
    if-eqz v24, +005h
    move-object/from16 v6, v24
    goto +3h
    const-string v6, "1"
    const/4 v10, 3
    new-array v10, v10, [Lkotlin/Pair;
    const-string/jumbo v11, repo_url
    invoke-static v11, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v11
    aput-object v11, v10, v7
    const-string v11, "page_size"
    invoke-static v11, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v10, v8
    const-string v2, "page_token"
    invoke-static v2, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v6, 2
    aput-object v2, v10, v6
    invoke-direct v0, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->buildQuery([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    sget-object v6, Lcom/bytedance/trae/conversation/network/IGetGitApi;->Companion Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v10
    new-instance v11, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$result$1;
    invoke-direct v11, v2, v9, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$result$1;-><init>(Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    iput-object v0, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->L$0 Ljava/lang/Object;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->L$1 Ljava/lang/Object;
    iput v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->I$0 I
    iput v8, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$listBranches$1;->label I
    invoke-virtual v6, v10, v11, v4, Lcom/bytedance/trae/conversation/network/IGetGitApi$Companion;->safeCall(Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v5, +003h
    return-object v5
    move-object v4, v0
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v5, v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v5, +0b0h
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v6
    if-eqz v6, +0a3h
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;
    if-eqz v5, +097h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getItems()Ljava/util/List;
    move-result-object v6
    if-nez v6, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    iget-object v9, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    invoke-interface v9, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    move-object v10, v9
    check-cast v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    const/16 v9, 50
    if-eqz v3, +02ah
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v3
    if-gt v3, v9, +07ah
    iget-object v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    new-instance v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getTotal()Ljava/lang/Long;
    move-result-object v9
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    if-eqz v5, +008h
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    move v7, v8
    invoke-direct v4, v6, v9, v10, v7, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;-><init>(Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z)V
    invoke-interface v3, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +57h
    if-eqz v10, +056h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->isFull()Z
    move-result v3
    if-nez v3, +050h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v3
    check-cast v3, Ljava/util/Collection;
    check-cast v6, Ljava/lang/Iterable;
    invoke-static v3, v6, Lkotlin/collections/CollectionsKt;->plus(Ljava/util/Collection; Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v11
    invoke-interface v11, Ljava/util/List;->size()I
    move-result v3
    if-gt v3, v9, +026h
    iget-object v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    const/4 v12, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v13
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +3h
    move v14, v7
    goto +2h
    move v14, v8
    const/4 v15, 2
    const/16 v16, 0
    invoke-static/range v10 ... v16, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->copy$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache; Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    move-result-object v4
    invoke-interface v3, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto +19h
    iget-object v3, v4, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    check-cast v11, Ljava/lang/Iterable;
    invoke-static v11, v9, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v11
    const/4 v12, 0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/ListBranchesData;->getNextPageToken()Ljava/lang/String;
    move-result-object v13
    const/4 v14, 1
    const/4 v15, 2
    const/16 v16, 0
    invoke-static/range v10 ... v16, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->copy$default(Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache; Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    move-result-object v4
    invoke-interface v3, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v2
.end method

.method public final preload(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    instance-of v0, v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;
    invoke-direct v0, v7, v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +029h
    if-eq v2, v4, +01ah
    if-ne v2, v3, +010h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +4bh
    move-exception v8
    goto +64h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v2, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v2
    goto +14h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v7, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    invoke-interface v8, v5, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v6, v7
    iget-boolean v2, v6, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->preloaded Z
    if-eqz v2, +008h
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v8, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    const/16 v2, 100
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v2
    iput-object v6, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$0 Ljava/lang/Object;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$preload$1;->label I
    invoke-direct v6, v5, v2, v5, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listRepositoriesFromServer(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v8
    move-object v8, v0
    move-object v0, v6
    check-cast v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getSuccess()Z
    move-result v2
    if-eqz v2, +00ah
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;->getItems()Ljava/util/List;
    move-result-object v8
    iput-object v8, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->preloaded Z
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-interface v1, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    sget-object v8, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v8
    move-exception v0
    move-object v1, v8
    move-object v8, v0
    invoke-interface v1, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v8
    :try_start_0x32
    :try_start_0x60
    :try_start_0x6c
    :try_start_0x80
.end method

.method public final reset()void
    .registers 2
    # ins_size=1
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedRepos Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    const/4 v0, 0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->nextPageToken Ljava/lang/String;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->total Ljava/lang/Long;
    const/4 v0, 0
    iput-boolean v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->preloaded Z
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    sget-object v0, Lcom/bytedance/trae/conversation/git/GitConnectionState;->DISCONNECTED Lcom/bytedance/trae/conversation/git/GitConnectionState;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->_gitConnectionState Lcom/bytedance/trae/conversation/git/GitConnectionState;
    return-void 
.end method

.method public final searchBranches(java.lang.String  java.lang.String)java.util.List
    .registers 10
    # ins_size=3
    const-string/jumbo v0, repoUrl
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "keyword"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->branchCacheMap Ljava/util/Map;
    invoke-interface v0, v8, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;
    if-nez v8, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    return-object v8
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v9, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v9, Ljava/lang/CharSequence;
    invoke-interface v9, Ljava/lang/CharSequence;->length()I
    move-result v1
    const/4 v2, 0
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    move v1, v2
    if-eqz v1, +007h
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v8
    return-object v8
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$BranchCache;->getBranches()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +024h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/conversation/network/GitBranch;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GitBranch;->getName()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v5, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static v4, v9, v2, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -022h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -27h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method public final searchRepos(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 23
    # ins_size=3
    move-object/from16 v1, v20
    move-object/from16 v0, v22
    const-string/jumbo v2, toLowerCase(...)
    instance-of v3, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;
    if-eqz v3, +012h
    move-object v3, v0
    check-cast v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;
    iget v4, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    const/high16 v5, -2147483648
    and-int/2addr v4, v5
    if-eqz v4, +008h
    iget v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    sub-int/2addr v0, v5
    iput v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    goto +6h
    new-instance v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;-><init>(Lcom/bytedance/trae/conversation/network/GitRemoteRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v4
    iget v5, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    const/4 v6, 2
    const/4 v7, 1
    const/4 v8, 0
    if-eqz v5, +02eh
    if-eq v5, v7, +017h
    if-ne v5, v6, +00dh
    iget-object v2, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +57h
    move-exception v0
    goto/16 +0f8h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    iget-object v5, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$2 Ljava/lang/Object;
    check-cast v5, Lkotlinx/coroutines/sync/Mutex;
    iget-object v9, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$1 Ljava/lang/Object;
    check-cast v9, Ljava/lang/String;
    iget-object v10, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object/from16 v19, v9
    move-object v9, v5
    move-object/from16 v5, v19
    goto +19h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->mutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v1, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$0 Ljava/lang/Object;
    move-object/from16 v5, v21
    iput-object v5, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$1 Ljava/lang/Object;
    iput-object v0, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$2 Ljava/lang/Object;
    iput v7, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    invoke-interface v0, v8, v3, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v4, +003h
    return-object v4
    move-object v9, v0
    move-object v10, v1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +01dh
    const/16 v0, 100
    invoke-static v0, Lkotlin/coroutines/jvm/internal/Boxing;->boxInt(I)Ljava/lang/Integer;
    move-result-object v0
    iput-object v9, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$0 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$1 Ljava/lang/Object;
    iput-object v8, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->L$2 Ljava/lang/Object;
    iput v6, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$searchRepos$1;->label I
    invoke-direct v10, v5, v0, v8, v3, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->listRepositoriesFromServer(Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v4, +003h
    return-object v4
    move-object v2, v9
    check-cast v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    move-object v9, v2
    goto/16 +09ah
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    const/4 v4, 0
    if-nez v3, +004h
    move v3, v7
    goto +2h
    move v3, v4
    if-eqz v3, +006h
    iget-object v0, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    move-object v12, v0
    goto +5bh
    iget-object v3, v10, Lcom/bytedance/trae/conversation/network/GitRemoteRepository;->cachedAllRepos Ljava/util/List;
    check-cast v3, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +043h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    move-object v11, v10
    check-cast v11, Lcom/bytedance/trae/conversation/network/GitRepository;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/GitRepository;->getName()Ljava/lang/String;
    move-result-object v12
    sget-object v13, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v12, v13, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v12
    invoke-static v12, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Ljava/lang/CharSequence;
    move-object v13, v0
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v12, v13, v4, v6, v8, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v12
    if-nez v12, +01dh
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/GitRepository;->getFullName()Ljava/lang/String;
    move-result-object v11
    sget-object v12, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v11, v12, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/CharSequence;
    move-object v12, v0
    check-cast v12, Ljava/lang/CharSequence;
    invoke-static v11, v12, v4, v6, v8, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v11
    if-eqz v11, +003h
    goto +3h
    move v11, v4
    goto +2h
    move v11, v7
    if-eqz v11, -041h
    invoke-interface v5, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -46h
    move-object v0, v5
    check-cast v0, Ljava/util/List;
    goto -5bh
    new-instance v0, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;
    const/4 v11, 1
    invoke-interface v12, Ljava/util/List;->size()I
    move-result v2
    int-to-long v2, v2
    invoke-static v2, v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxLong(J)Ljava/lang/Long;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 48
    const/16 v18, 0
    move-object v10, v0
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/conversation/network/GitRemoteRepository$Result;-><init>(Z Ljava/util/List; Ljava/lang/Long; Ljava/lang/String; Ljava/lang/Long; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v9, v8, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v0
    move-object v2, v9
    invoke-interface v2, v8, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v0
    :try_start_0x35
    :try_start_0x71
    :try_start_0x8f
    :try_start_0x94
.end method
