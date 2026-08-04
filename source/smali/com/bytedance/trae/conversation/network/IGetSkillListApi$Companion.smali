# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
.super Ljava/lang/Object;
.source "IGetSkillListApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$Q__BY5HLLlaUCwpfcSDFH6QnFF8(java.util.Map  com.bytedance.trae.conversation.network.IGetSkillListApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->listSkillsFromHub$lambda$0(Ljava/util/Map; Lcom/bytedance/trae/conversation/network/IGetSkillListApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getDEFAULT_HEADERS()java.util.Map
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders$default(Lcom/bytedance/trae/network/DebugSettings; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method private static final listSkillsFromHub$lambda$0(java.util.Map  com.bytedance.trae.conversation.network.IGetSkillListApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCall"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;->listSkillsFromHubRaw(Ljava/util/Map; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final listSkillsFromHub(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 17
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, skills
    const-class v2, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;
    const-class v3, Lcom/bytedance/trae/conversation/network/ListSkillsData;
    check-cast v3, Ljava/lang/reflect/Type;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct v14, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v6
    const/4 v7, 1
    sget-object v8, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v9, 1
    new-instance v10, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$$ExternalSyntheticLambda0;
    move-object v11, v15
    invoke-direct v10, v15, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$$ExternalSyntheticLambda0;-><init>(Ljava/util/Map;)V
    const/16 v12, 24
    const/4 v13, 0
    move-object/from16 v11, v16
    invoke-static/range v0 ... v13, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final safeCall(java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=4
    instance-of v13, v15, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;
    if-eqz v13, +012h
    move-object v13, v15
    check-cast v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;
    iget v0, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->label I
    const/high16 v1, -2147483648
    and-int/2addr v0, v1
    if-eqz v0, +008h
    iget v15, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->label I
    sub-int/2addr v15, v1
    iput v15, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->label I
    goto +6h
    new-instance v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;
    invoke-direct v13, v12, v15, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->label I
    const/4 v2, 1
    if-eqz v1, +016h
    if-ne v1, v2, +00ch
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    move-exception v13
    move-object v3, v13
    goto +6ch
    move-exception v13
    goto/16 +07bh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v14, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v14, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v4, skills
    const-class v5, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 60
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/network/IGetSkillListApi;
    iput v2, v13, Lcom/bytedance/trae/conversation/network/IGetSkillListApi$Companion$safeCall$1;->label I
    invoke-interface v14, v15, v13, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v0, +003h
    return-object v0
    check-cast v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;
    if-nez v15, +01dh
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string v2, "BizResponse is null"
    new-instance v14, Ljava/lang/Exception;
    const-string v15, "BizResponse is null"
    invoke-direct v14, v15, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v3, v14
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v13
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +47h
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v14, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getCode()J
    move-result-wide v1
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getMsg()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/RemoteResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 44
    const/4 v9, 0
    move-object v0, v14
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v15, 0
    invoke-direct v13, v14, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v13, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1000
    const-string v2, ""
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v13
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1001
    const-string v2, ""
    move-object v3, v13
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v13, v14
    check-cast v13, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v13
    :try_start_0x26
    :try_start_0x3b
.end method
