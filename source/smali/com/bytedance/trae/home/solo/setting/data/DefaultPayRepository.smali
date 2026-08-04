# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
.super Ljava/lang/Object;
.source "PayRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/PayRepository;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$Companion;
.field private static final DEFAULT_FREE_BADGE_TEXT:Ljava/lang/String;
.field private static final PAY_STATUS_MAINLAND_PATH:Ljava/lang/String;
.field private static final PAY_STATUS_MAINLAND_REQUEST_OPTIONS:Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.field private static final PAY_STATUS_OVERSEA_PATH:Ljava/lang/String;
.field private static final PAY_STATUS_OVERSEA_REQUEST_OPTIONS:Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.field private static final PAY_STATUS_TAG:Ljava/lang/String;
.field private final _payIdentity:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final httpClient:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field private final payIdentity:Lkotlinx/coroutines/flow/StateFlow;
.field private final repositoryDispatcher:Lkotlinx/coroutines/CoroutineDispatcher;


.method static constructor <clinit>()void
    .registers 19
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->Companion Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->$stable I
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string/jumbo v2, user_pay_status
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v8, 30
    const/4 v9, 0
    move-object v1, v0
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->PAY_STATUS_OVERSEA_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string/jumbo v11, user_pay_status
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    sget-object v16, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v17, 30
    const/16 v18, 0
    move-object v10, v0
    invoke-direct/range v10 ... v18, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->PAY_STATUS_MAINLAND_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
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
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    iput-object v4, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    const/4 v2, 0
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->_payIdentity Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->payIdentity Lkotlinx/coroutines/flow/StateFlow;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method public static final synthetic access$fetchPayStatus(com.bytedance.trae.home.solo.setting.data.DefaultPayRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->fetchPayStatus(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getHostInfo$p(com.bytedance.trae.home.solo.setting.data.DefaultPayRepository)com.bytedance.trae.kmp.host.KmpHostInfo
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-object v0
.end method

.method public static final synthetic access$get_payIdentity$p(com.bytedance.trae.home.solo.setting.data.DefaultPayRepository)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->_payIdentity Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method private final fetchPayStatus(kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=2
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;
    if-eqz v0, +012h
    move-object v0, v13
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v13, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    sub-int/2addr v13, v2
    iput v13, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;
    invoke-direct v0, v12, v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository; Lkotlin/coroutines/Continuation;)V
    move-object v9, v0
    iget-object v13, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v0
    iget v1, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    const/4 v2, 2
    const/4 v3, 1
    if-eqz v1, +017h
    if-eq v1, v3, +011h
    if-ne v1, v2, +007h
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +089h
    new-instance v13, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v13, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v13
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    invoke-static v13, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v13, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v13, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isOversea()Z
    move-result v13
    if-eqz v13, +02dh
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v2, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v13, "/trae/api/v1/pay/ide_user_pay_status"
    const/4 v4, 0
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->PAY_STATUS_OVERSEA_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v7
    check-cast v7, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v10, 12
    const/4 v11, 0
    iput v3, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    move-object v3, v13
    move-object v8, v9
    move v9, v10
    move-object v10, v11
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->getResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    goto +4eh
    sget-object v13, Lkotlinx/serialization/json/Json;->Default Lkotlinx/serialization/json/Json$Default;
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v1
    check-cast v1, Lkotlinx/serialization/SerializationStrategy;
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto;
    iget-object v4, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v4, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isIOS()Z
    move-result v4
    if-eqz v4, +005h
    const-string v4, "iOS"
    goto +3h
    const-string v4, "Android"
    iget-object v5, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v5, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getDeviceId()Ljava/lang/String;
    move-result-object v5
    invoke-direct v3, v4, v5, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusRequestDto;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v13, v1, v3, Lkotlinx/serialization/json/Json$Default;->encodeToString(Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    iget-object v1, v12, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v13, Lcom/bytedance/trae/kmp/network/KmpHostType;->Login Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v3, "/trae/api/v2/pay/ide_user_pay_status"
    const/4 v5, 0
    const/4 v6, 0
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->PAY_STATUS_MAINLAND_REQUEST_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;->Companion Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v8
    check-cast v8, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v10, 24
    const/4 v11, 0
    iput v2, v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$fetchPayStatus$1;->label I
    move-object v2, v13
    invoke-static/range v1 ... v11, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->postResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v13
    if-ne v13, v0, +003h
    return-object v0
    check-cast v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v13, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/data/model/PayStatusResponseDto;
    return-object v13
.end method

.method public getPayIdentity()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->payIdentity Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public refresh(kotlin.coroutines.Continuation)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;->repositoryDispatcher Lkotlinx/coroutines/CoroutineDispatcher;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;
    const/4 v2, 0
    invoke-direct v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository$refresh$2;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository; Lkotlin/coroutines/Continuation;)V
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
