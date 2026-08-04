# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
.super Ljava/lang/Object;
.source "SettingsCreditsRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;

.field public static final $stable:I
.field private static final CREDITS_USAGE_PATH:Ljava/lang/String;
.field private static final CREDITS_USAGE_REQUEST_OPTIONS:Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.field private static final Companion:Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$Companion;
.field private static final INFINITE_BALANCE_TEXT:Ljava/lang/String;
.field private static final INFINITE_LIMIT:J
.field private static final SUCCESS_CODE:J
.field private final _creditsState:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final creditsState:Lkotlinx/coroutines/flow/StateFlow;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final httpClient:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field private ownedCreditsBalance:Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
.field private final repositoryDispatcher:Lkotlinx/coroutines/CoroutineDispatcher;


.method static constructor <clinit>()void
    .registers 10
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->Companion Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->$stable I
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string/jumbo v2, user_ent_status
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v8, 28
    const/4 v9, 0
    move-object v1, v0
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->CREDITS_USAGE_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher)void
    .registers 5
    # ins_size=4
    const-string v0, "httpClient"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repositoryDispatcher
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->initialState()Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->_creditsState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->creditsState Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method public static final synthetic access$currentEligibleUserId(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->currentEligibleUserId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchCreditsUsage(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->fetchCreditsUsage(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getOwnedCreditsBalance$p(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository)com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository$OwnedCreditsBalance
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
    return-object v0
.end method

.method public static final synthetic access$get_creditsState$p(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->_creditsState Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$setOwnedCreditsBalance$p(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository  com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository$OwnedCreditsBalance)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->ownedCreditsBalance Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$OwnedCreditsBalance;
    return-void 
.end method

.method public static final synthetic access$toBalancePresentation(com.bytedance.trae.home.solo.setting.data.DefaultSettingsCreditsRepository  com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto)com.bytedance.trae.home.solo.setting.data.SettingsCreditsState$Visible
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->toBalancePresentation(Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;)Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    move-result-object v0
    return-object v0
.end method

.method private final creditsUsageRequestBody()java.lang.String
    .registers 4
    # ins_size=1
    new-instance v0, Lkotlinx/serialization/json/JsonObjectBuilder;
    invoke-direct v0, Lkotlinx/serialization/json/JsonObjectBuilder;-><init>()V
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    const-string/jumbo v2, require_usage
    invoke-static v0, v2, v1, Lkotlinx/serialization/json/JsonElementBuildersKt;->put(Lkotlinx/serialization/json/JsonObjectBuilder; Ljava/lang/String; Ljava/lang/Boolean;)Lkotlinx/serialization/json/JsonElement;
    invoke-virtual v0, Lkotlinx/serialization/json/JsonObjectBuilder;->build()Lkotlinx/serialization/json/JsonObject;
    move-result-object v0
    invoke-virtual v0, Lkotlinx/serialization/json/JsonObject;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final currentEligibleUserId()java.lang.String
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;
    iget-object v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$SettingsCreditsPolicy;->isEligible(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Z
    move-result v1
    if-eqz v1, +00eh
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v2, 1
    xor-int/2addr v1, v2
    if-eqz v1, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final fetchCreditsUsage(kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=2
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;
    if-eqz v0, +012h
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v13, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->label I
    sub-int/2addr v13, v2
    iput v13, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lkotlin/coroutines/Continuation;)V
    move-object v9, v0
    iget-object v13, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->label I
    const/4 v2, 1
    if-eqz v1, +010h
    if-ne v1, v2, +006h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2fh
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v13, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v3, "/trae/api/v2/pay/ide_user_ent_usage"
    invoke-direct v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->creditsUsageRequestBody()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->CREDITS_USAGE_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v8
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v10, 24
    const/4 v11, 0
    iput v2, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$fetchCreditsUsage$1;->label I
    move-object v2, v13
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->postResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v13
    return-object v13
.end method

.method private final formatFiniteBalance(long)java.lang.String
    .registers 12
    # ins_size=3
    invoke-static v10, v11, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->reversed(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    const/4 v11, 3
    invoke-static v10, v11, Lkotlin/text/StringsKt;->chunked(Ljava/lang/CharSequence; I)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, ","
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v10
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->reversed(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final initialState()com.bytedance.trae.home.solo.setting.data.SettingsCreditsState
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->currentEligibleUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +007h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    goto +5h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;
    return-object v0
.end method

.method private final toBalancePresentation(com.bytedance.trae.home.solo.setting.data.model.CreditsUsageResponseDto)com.bytedance.trae.home.solo.setting.data.SettingsCreditsState$Visible
    .registers 21
    # ins_size=2
    invoke-virtual/range v20, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->getEffectiveCode()Ljava/lang/Long;
    move-result-object v0
    const/4 v1, 0
    const-wide/16 v2, 0
    if-eqz v0, +00bh
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v4
    cmp-long v0, v4, v2
    if-eqz v0, +003h
    return-object v1
    invoke-virtual/range v20, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto;->getEffectiveEntitlementPacks()Ljava/util/List;
    move-result-object v0
    if-nez v0, +003h
    return-object v1
    check-cast v0, Ljava/lang/Iterable;
    instance-of v4, v0, Ljava/util/Collection;
    const/4 v5, 1
    const/4 v6, 0
    if-eqz v4, +00dh
    move-object v4, v0
    check-cast v4, Ljava/util/Collection;
    invoke-interface v4, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +004h
    move v4, v6
    goto +34h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, -00ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    move-result-object v7
    if-eqz v7, +01bh
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;->getQuota()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    move-result-object v7
    if-eqz v7, +015h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->getCreditsLimit()Ljava/lang/Long;
    move-result-object v7
    if-nez v7, +003h
    goto +dh
    invoke-virtual v7, Ljava/lang/Long;->longValue()J
    move-result-wide v7
    const-wide/16 v9, -1
    cmp-long v7, v7, v9
    if-nez v7, +004h
    move v7, v5
    goto +2h
    move v7, v6
    if-eqz v7, -02ch
    move v4, v5
    if-eqz v4, +00bh
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    const-string/jumbo v1, ∞
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;-><init>(Ljava/lang/String;)V
    return-object v0
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    const-wide/16 v7, 0
    move-wide v9, v2
    move-wide v11, v7
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +05ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->getEntitlementBaseInfo()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;
    move-result-object v13
    if-eqz v13, +013h
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementBaseInfoDto;->getQuota()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;
    move-result-object v13
    if-eqz v13, +00dh
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntQuotaDto;->getCreditsLimit()Ljava/lang/Long;
    move-result-object v13
    if-eqz v13, +007h
    invoke-virtual v13, Ljava/lang/Long;->longValue()J
    move-result-wide v13
    goto +2h
    move-wide v13, v2
    cmp-long v15, v13, v2
    if-lez v15, -026h
    const-wide v15, 9223372036854775807
    sub-long/2addr v15, v9
    cmp-long v15, v15, v13
    if-gez v15, +003h
    return-object v1
    add-long/2addr v9, v13
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntitlementPackDto;->getUsage()Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;
    move-result-object v4
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/model/CreditsUsageResponseDto$EntUsageDto;->getCreditsAmount()Ljava/lang/Double;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Ljava/lang/Double;->doubleValue()D
    move-result-wide v13
    goto +2h
    move-wide v13, v7
    invoke-static v13, v14, Ljava/lang/Math;->abs(D)D
    move-result-wide v15
    const-wide v17, 9218868437227405311
    cmpg-double v4, v15, v17
    if-gtz v4, +004h
    move v4, v5
    goto +2h
    move v4, v6
    if-eqz v4, +009h
    cmpg-double v4, v13, v7
    if-gez v4, +003h
    goto +3h
    add-double/2addr v11, v13
    goto -5eh
    return-object v1
    invoke-static v11, v12, Lkotlin/math/MathKt;->roundToLong(D)J
    move-result-wide v0
    sub-long/2addr v9, v0
    invoke-static v9, v10, v2, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(J J)J
    move-result-wide v0
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    move-object/from16 v3, v19
    invoke-direct v3, v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->formatFiniteBalance(J)Ljava/lang/String;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;-><init>(Ljava/lang/String;)V
    return-object v2
.end method

.method public getCreditsState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->creditsState Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public refresh(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository$refresh$2;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v4, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->withRepositoryContext(Lkotlinx/coroutines/CoroutineDispatcher; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    if-ne v4, v0, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
