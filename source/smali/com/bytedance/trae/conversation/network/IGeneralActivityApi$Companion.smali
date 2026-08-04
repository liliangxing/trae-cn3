# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
.super Ljava/lang/Object;
.source "ICustomActivityApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 16
    # ins_size=3
    instance-of v0, v15, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;
    if-eqz v0, +012h
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v15, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->label I
    sub-int/2addr v15, v2
    iput v15, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;
    invoke-direct v0, v13, v15, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;-><init>(Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v15, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->label I
    const/4 v3, 1
    if-eqz v2, +016h
    if-ne v2, v3, +00ch
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +35h
    move-exception v14
    move-object v3, v14
    goto +6dh
    move-exception v14
    goto/16 +07ch
    new-instance v14, Ljava/lang/IllegalStateException;
    const-string v15, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v14, v15, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v14
    invoke-static v15, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v4, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v5, "general_activity"
    const-class v6, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;
    const/4 v7, 0
    sget-object v15, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v15, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 52
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;
    iput v3, v0, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion$safeCall$1;->label I
    invoke-interface v14, v15, v0, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v15
    if-ne v15, v1, +003h
    return-object v1
    check-cast v15, Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;
    if-nez v15, +01dh
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1005
    const-string v2, "Response is null"
    new-instance v15, Ljava/lang/Exception;
    const-string v0, "Response is null"
    invoke-direct v15, v0, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v3, v15
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +42h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v10, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v1, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    invoke-virtual v15, Lcom/bytedance/trae/conversation/network/GeneralActivityResponse;->getData()Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 47
    const/4 v9, 0
    move-object v0, v10
    invoke-direct/range v0 ... v9, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const/4 v15, 0
    invoke-direct v14, v10, v15, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +26h
    new-instance v14, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1000
    const-string v2, ""
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v14
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    goto +15h
    new-instance v15, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v1, -1001
    const-string v2, ""
    move-object v3, v14
    check-cast v3, Ljava/lang/Throwable;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v15
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    move-object v14, v15
    check-cast v14, Lcom/bytedance/trae/network/response/HttpDataResult;
    return-object v14
    :try_start_0x26
    :try_start_0x3b
.end method
