# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
.super Ljava/lang/Object;
.source "IDiffViewApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic safeCall$default(com.bytedance.trae.im.service.IDiffViewApi$Companion  java.lang.String  java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 2
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v2
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion;->safeCall(Ljava/lang/String; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final safeCall(java.lang.String  java.util.Map  kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 22
    # ins_size=5
    move-object/from16 v0, v21
    instance-of v1, v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;
    iget v2, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->label I
    move-object/from16 v2, v17
    goto +8h
    new-instance v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;
    move-object/from16 v2, v17
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/im/service/IDiffViewApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v0, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->label I
    const/4 v5, 1
    if-eqz v4, +016h
    if-ne v4, v5, +00ch
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +32h
    move-exception v0
    move-object v6, v0
    goto +68h
    move-exception v0
    goto/16 +077h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v6, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v7, "diff_view"
    const-class v8, Lcom/bytedance/trae/im/service/IDiffViewApi;
    const/4 v9, 0
    const/4 v12, 0
    const/16 v13, 36
    const/4 v14, 0
    move-object/from16 v10, v18
    move-object/from16 v11, v19
    invoke-static/range v6 ... v14, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/im/service/IDiffViewApi;
    iput v5, v1, Lcom/bytedance/trae/im/service/IDiffViewApi$Companion$safeCall$1;->label I
    move-object/from16 v4, v20
    invoke-interface v4, v0, v1, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v3, +003h
    return-object v3
    move-object v9, v0
    check-cast v9, Lcom/bytedance/trae/im/service/DiffViewResponse;
    if-nez v9, +01eh
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v11, -1005
    const-string v12, "DiffViewResponse is null"
    new-instance v1, Ljava/lang/Exception;
    const-string v3, "DiffViewResponse is null"
    invoke-direct v1, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v13, v1
    check-cast v13, Ljava/lang/Throwable;
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v10, v0
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +3eh
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v1, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v4, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v10, 0
    const/16 v11, 47
    const/4 v12, 0
    move-object v3, v1
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v3, 0
    invoke-direct v0, v1, v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v0, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1000
    const-string v5, ""
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v0
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v4, -1001
    const-string v5, ""
    move-object v6, v0
    check-cast v6, Ljava/lang/Throwable;
    const/4 v7, 0
    const/16 v8, 8
    const/4 v9, 0
    move-object v3, v1
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v0
    :try_start_0x2c
    :try_start_0x41
.end method
