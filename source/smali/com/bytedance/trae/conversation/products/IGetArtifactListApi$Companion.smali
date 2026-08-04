# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;
.super Ljava/lang/Object;
.source "IGetArtifactListApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    move-object/from16 v0, v18
    instance-of v1, v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;
    iget v2, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->label I
    move-object/from16 v2, v16
    goto +8h
    new-instance v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;
    move-object/from16 v2, v16
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->label I
    const-string v5, "IGetArtifactListApi"
    const/4 v6, 1
    if-eqz v4, +017h
    if-ne v4, v6, +00dh
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +31h
    move-exception v0
    move-object v6, v0
    goto/16 +07dh
    move-exception v0
    goto/16 +090h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v8, "artifact_list"
    const-class v9, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 60
    const/4 v15, 0
    invoke-static/range v7 ... v15, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi;
    iput v6, v1, Lcom/bytedance/trae/conversation/products/IGetArtifactListApi$Companion$safeCall$1;->label I
    move-object/from16 v4, v17
    invoke-interface v4, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    check-cast v0, Lcom/bytedance/trae/network/response/BizResponse;
    if-nez v0, +01dh
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v7, -1005
    const-string v8, "BizResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v3, "BizResponse is null"
    invoke-direct v1, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v9, v1
    check-cast v9, Ljava/lang/Throwable;
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +5fh
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v3, Lcom/bytedance/trae/network/response/BizResponse;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v6
    const-wide/16 v8, 200
    cmp-long v4, v6, v8
    if-nez v4, +005h
    const-wide/16 v6, 0
    goto +5h
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getCode()J
    move-result-wide v6
    move-wide v7, v6
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getMsg()Ljava/lang/String;
    move-result-object v9
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v12
    const/4 v13, 0
    const/16 v14, 44
    const/4 v15, 0
    move-object v6, v3
    invoke-direct/range v6 ... v15, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v0, 0
    invoke-direct v1, v3, v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +2fh
    const-string v0, "Error"
    invoke-static v5, v0, v6, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1000
    const-string v5, ""
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v0
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +19h
    move-object v9, v0
    check-cast v9, Ljava/lang/Throwable;
    const-string v0, "CancellationException"
    invoke-static v5, v0, v9, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v7, -1001
    const-string v8, ""
    const/4 v10, 0
    const/16 v11, 8
    const/4 v12, 0
    move-object v6, v0
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x2e
    :try_start_0x44
.end method
