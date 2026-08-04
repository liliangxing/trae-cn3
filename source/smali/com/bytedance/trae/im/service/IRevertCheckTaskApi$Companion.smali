# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
.super Ljava/lang/Object;
.source "IRevertCheckTaskApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
.field private static final SUCCESS_CODES:Ljava/util/Set;


.method public static synthetic $r8$lambda$Foek32ZTwb-gEHpvq7lT_KB5Jkg(com.bytedance.trae.im.service.RevertCheckTaskRequest  com.bytedance.trae.im.service.IRevertCheckTaskApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->revertCheckTaskRawCall$lambda$0(Lcom/bytedance/trae/im/service/RevertCheckTaskRequest; Lcom/bytedance/trae/im/service/IRevertCheckTaskApi; Lcom/bytedance/ttnet/http/RequestContext;)Lcom/bytedance/retrofit2/Call;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;
    sget-object v0, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->SUCCESS_CODES Ljava/util/Set;
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

.method private static final revertCheckTaskRawCall$lambda$0(com.bytedance.trae.im.service.RevertCheckTaskRequest  com.bytedance.trae.im.service.IRevertCheckTaskApi  com.bytedance.ttnet.http.RequestContext)com.bytedance.retrofit2.Call
    .registers 4
    # ins_size=3
    const-string v0, "$this$rawBizCallWithBody"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, requestContext
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v2, v1, v3, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;->revertCheckTaskRaw(Lcom/bytedance/trae/im/service/RevertCheckTaskRequest; Ljava/lang/Object;)Lcom/bytedance/retrofit2/Call;
    move-result-object v1
    return-object v1
.end method

.method public final revertCheckTaskRawCall(com.bytedance.trae.im.service.RevertCheckTaskRequest  kotlin.coroutines.Continuation)java.lang.Object
    .registers 20
    # ins_size=3
    move-object/from16 v0, v19
    instance-of v1, v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
    if-eqz v1, +014h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
    iget v2, v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->label I
    const/high16 v3, -2147483648
    and-int/2addr v2, v3
    if-eqz v2, +00ah
    iget v0, v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->label I
    sub-int/2addr v0, v3
    iput v0, v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->label I
    move-object/from16 v2, v17
    goto +8h
    new-instance v1, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;
    move-object/from16 v2, v17
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;-><init>(Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion; Lkotlin/coroutines/Continuation;)V
    move-object v14, v1
    iget-object v0, v14, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v3, v14, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->label I
    const/4 v4, 1
    if-eqz v3, +010h
    if-ne v3, v4, +006h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +36h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v1, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v1, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v3, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v0, revert_check_task
    const-class v5, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi;
    const-class v6, Lcom/bytedance/trae/im/service/RevertCheckTaskResponse;
    check-cast v6, Ljava/lang/reflect/Type;
    const/4 v7, 0
    const/4 v8, 0
    invoke-direct/range v17, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v9
    const/4 v10, 1
    sget-object v11, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion;->SUCCESS_CODES Ljava/util/Set;
    const/4 v12, 0
    new-instance v13, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$$ExternalSyntheticLambda0;
    move-object/from16 v15, v18
    invoke-direct v13, v15, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/im/service/RevertCheckTaskRequest;)V
    const/16 v15, 280
    const/16 v16, 0
    iput v4, v14, Lcom/bytedance/trae/im/service/IRevertCheckTaskApi$Companion$revertCheckTaskRawCall$1;->label I
    move-object v4, v0
    invoke-static/range v3 ... v16, Lcom/bytedance/trae/network/TraeHttpConnection;->rawBizCallWithBody$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/lang/reflect/Type; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Z Ljava/util/Set; Z Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    check-cast v0, Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;
    invoke-static v0, Lcom/bytedance/trae/im/service/IRevertCheckTaskApiKt;->access$toHttpResultPreservingBizError(Lcom/bytedance/trae/network/TraeHttpConnection$RawBizCallResult;)Lcom/bytedance/trae/network/response/HttpDataResult;
    move-result-object v0
    return-object v0
.end method
