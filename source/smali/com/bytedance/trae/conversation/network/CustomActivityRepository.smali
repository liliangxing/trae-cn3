# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
.super Ljava/lang/Object;
.source "CustomActivityRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
.field private static final MAX_RETRY_COUNT:I
.field private static final RETRY_INTERVAL_MS:J
.field private static final SUCCESS_POLL_INTERVAL_MS:J
.field private static final instance$delegate:Lkotlin/Lazy;
.field private final _cachedActivities:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _firstBanner:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final cachedActivities:Lkotlinx/coroutines/flow/StateFlow;
.field private final firstBanner:Lkotlinx/coroutines/flow/StateFlow;
.field private h5Url:Ljava/lang/String;
.field private lastFetchSuccessAt:J
.field private postUrl:Ljava/lang/String;
.field private shareUrl:Ljava/lang/String;


.method public static synthetic $r8$lambda$gXSRp5wtWvmcbANyKpSR24fx3x8()com.bytedance.trae.conversation.network.CustomActivityRepository
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->instance_delegate$lambda$0()Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->Companion Lcom/bytedance/trae/conversation/network/CustomActivityRepository$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->instance$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    const/4 v0, 0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v1
    iput-object v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_cachedActivities Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->cachedActivities Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_firstBanner Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->firstBanner Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method public static final synthetic access$getInstance$delegate$cp()kotlin.Lazy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->instance$delegate Lkotlin/Lazy;
    return-object v0
.end method

.method public static synthetic fetchActivities$default(com.bytedance.trae.conversation.network.CustomActivityRepository  boolean  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    const/4 v1, 0
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->fetchActivities(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private static final instance_delegate$lambda$0()com.bytedance.trae.conversation.network.CustomActivityRepository
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;-><init>()V
    return-object v0
.end method

.method public final clearCache()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_cachedActivities Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    const-wide/16 v0, 0
    iput-wide v0, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->lastFetchSuccessAt J
    return-void 
.end method

.method public final fetchActivities(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 24
    # ins_size=3
    move-object/from16 v0, v21
    move-object/from16 v1, v23
    instance-of v2, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;
    iget v3, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;-><init>(Lcom/bytedance/trae/conversation/network/CustomActivityRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    const/16 v5, 10
    const/4 v6, 2
    const/4 v7, 0
    const/4 v8, 1
    const/4 v9, 0
    if-eqz v4, +024h
    if-eq v4, v8, +017h
    if-ne v4, v6, +00dh
    iget v4, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->I$0 I
    iget-object v10, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +17fh
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    iget v4, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->I$0 I
    iget-object v10, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->L$0 Ljava/lang/Object;
    check-cast v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +0a8h
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v10
    if-nez v22, +080h
    iget-wide v12, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->lastFetchSuccessAt J
    const-wide/16 v14, 0
    cmp-long v1, v12, v14
    if-lez v1, +078h
    sub-long/2addr v10, v12
    const-wide/32 v12, 1800000
    cmp-long v1, v10, v12
    if-gez v1, +070h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_cachedActivities Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object/from16 v16, v1
    check-cast v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v16, +064h
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v1
    if-eqz v1, +00eh
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ActivityItem;->getHitActivityTime()Ljava/lang/Boolean;
    move-result-object v1
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +02eh
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_firstBanner Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ActivityItem;->getIconUrl()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ActivityItem;->getH5Url()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ActivityItem;->getShareUrl()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    invoke-virtual/range v16, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/ActivityItem;->getPostUrl()Ljava/lang/String;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    goto +ch
    iget-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_firstBanner Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, v9, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    new-instance v2, Lcom/bytedance/trae/network/response/BizResponse;
    const-wide/16 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v17, 0
    const/16 v18, 46
    const/16 v19, 0
    move-object v10, v2
    invoke-direct/range v10 ... v19, Lcom/bytedance/trae/network/response/BizResponse;-><init>(J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-direct v1, v2, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;-><init>(Lcom/bytedance/trae/network/response/BizResponse; Ljava/lang/Throwable;)V
    return-object v1
    move-object v1, v0
    move v4, v7
    if-ge v4, v5, +0e4h
    sget-object v10, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi;->Companion Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;
    new-instance v11, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;
    invoke-direct v11, v9, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$result$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v11, Lkotlin/jvm/functions/Function2;
    iput-object v1, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->L$0 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->I$0 I
    iput v8, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    invoke-virtual v10, v11, v2, Lcom/bytedance/trae/conversation/network/IGeneralActivityApi$Companion;->safeCall(Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v3, +003h
    return-object v3
    move-object/from16 v20, v10
    move-object v10, v1
    move-object/from16 v1, v20
    check-cast v1, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v11, v1, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v11, +0aeh
    iget-object v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_cachedActivities Lkotlinx/coroutines/flow/MutableStateFlow;
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    invoke-interface v2, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v2, +014h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v2
    if-eqz v2, +00eh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ActivityItem;->getHitActivityTime()Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v8, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +06ch
    iget-object v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_firstBanner Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/ActivityItem;->getIconUrl()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v9
    invoke-interface v2, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ActivityItem;->getH5Url()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v9
    iput-object v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v2, +00dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ActivityItem;->getShareUrl()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v9
    iput-object v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;
    if-eqz v2, +00ch
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/GeneralActivityData;->getFirst()Lcom/bytedance/trae/conversation/network/ActivityItem;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/ActivityItem;->getPostUrl()Ljava/lang/String;
    move-result-object v9
    iput-object v9, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    goto +ch
    iget-object v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->_firstBanner Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, v9, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iput-object v9, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    iput-object v9, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    iput-object v9, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v2
    iput-wide v2, v10, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->lastFetchSuccessAt J
    return-object v1
    add-int/2addr v4, v8
    if-ge v4, v5, +011h
    iput-object v10, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->L$0 Ljava/lang/Object;
    iput v4, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->I$0 I
    iput v6, v2, Lcom/bytedance/trae/conversation/network/CustomActivityRepository$fetchActivities$1;->label I
    const-wide/16 v11, 30000
    invoke-static v11, v12, v2, Lkotlinx/coroutines/DelayKt;->delay(J Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v1, v10
    goto/16 -0e2h
    new-instance v1, Lcom/bytedance/trae/network/response/HttpDataResult$Error;
    const/16 v11, -1000
    const-string v12, "Failed after 10 retries"
    new-instance v2, Ljava/lang/Exception;
    const-string v3, "Failed after 10 retries"
    invoke-direct v2, v3, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V
    move-object v13, v2
    check-cast v13, Ljava/lang/Throwable;
    const/4 v14, 0
    const/16 v15, 8
    const/16 v16, 0
    move-object v10, v1
    invoke-direct/range v10 ... v16, Lcom/bytedance/trae/network/response/HttpDataResult$Error;-><init>(I Ljava/lang/String; Ljava/lang/Throwable; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method public final getCachedActivities()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->cachedActivities Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getFirstBanner()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->firstBanner Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getH5Url()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    return-object v0
.end method

.method public final getPostUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    return-object v0
.end method

.method public final getShareUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    return-object v0
.end method

.method public final setH5Url(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->h5Url Ljava/lang/String;
    return-void 
.end method

.method public final setPostUrl(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->postUrl Ljava/lang/String;
    return-void 
.end method

.method public final setShareUrl(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/network/CustomActivityRepository;->shareUrl Ljava/lang/String;
    return-void 
.end method
