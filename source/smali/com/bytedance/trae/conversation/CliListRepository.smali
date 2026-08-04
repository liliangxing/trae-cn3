# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/CliListRepository;
.super Ljava/lang/Object;
.source "CliListRepository.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/CliListRepository$Companion;
.field private static final KEVA_REPO_NAME:Ljava/lang/String;
.field private static final KEY_CLI_ID_TO_TYPE:Ljava/lang/String;
.field private static final instance$delegate:Lkotlin/Lazy;
.field private final _cachedClis:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _cachedDiscoverableDevices:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final cachedClis:Lkotlinx/coroutines/flow/StateFlow;
.field private cachedDeviceItems:Ljava/util/List;
.field private final cachedDiscoverableDevices:Lkotlinx/coroutines/flow/StateFlow;
.field private cachedDiscoveryDevices:Ljava/util/List;
.field private bridge cachedTypes:Ljava/util/Map;
.field private final cachedTypesLock:Ljava/lang/Object;
.field private final deviceCountEventTracker:Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
.field private final discoveryRefreshMutex:Lkotlinx/coroutines/sync/Mutex;
.field private fetchedAt:J
.field private bridge isInited:Z
.field private final keva$delegate:Lkotlin/Lazy;
.field private final service:Lcom/bytedance/trae/conversation/CliListService;


.method public static synthetic $r8$lambda$eI8iXgG978MhyWj1n6EnquyhmHY()com.bytedance.trae.conversation.CliListRepository
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/CliListRepository;->instance_delegate$lambda$14()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$rotbnkwZ4HYuau1TCEyHOXS-jWk()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/CliListRepository;->keva_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/conversation/CliListRepository$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->instance$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 3
    invoke-direct v2, v0, v0, v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;-><init>(Lcom/bytedance/trae/conversation/CliListService; Lcom/bytedance/trae/conversation/DeviceCountEventTracker; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.CliListService  com.bytedance.trae.conversation.DeviceCountEventTracker)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, service
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "deviceCountEventTracker"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/CliListRepository;->deviceCountEventTracker Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    new-instance v2, Ljava/util/HashMap;
    invoke-direct v2, Ljava/util/HashMap;-><init>()V
    check-cast v2, Ljava/util/Map;
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    new-instance v2, Ljava/lang/Object;
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypesLock Ljava/lang/Object;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->_cachedClis Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedClis Lkotlinx/coroutines/flow/StateFlow;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoveryDevices Ljava/util/List;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->_cachedDiscoverableDevices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoverableDevices Lkotlinx/coroutines/flow/StateFlow;
    const/4 v2, 1
    const/4 v3, 0
    const/4 v0, 0
    invoke-static v0, v2, v3, Lkotlinx/coroutines/sync/MutexKt;->Mutex$default(Z I Ljava/lang/Object;)Lkotlinx/coroutines/sync/Mutex;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->discoveryRefreshMutex Lkotlinx/coroutines/sync/Mutex;
    new-instance v2, Lcom/bytedance/trae/conversation/CliListRepository$$ExternalSyntheticLambda0;
    invoke-direct v2, Lcom/bytedance/trae/conversation/CliListRepository$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v2, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;->keva$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.CliListService  com.bytedance.trae.conversation.DeviceCountEventTracker  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +006h
    sget-object v1, Lcom/bytedance/trae/conversation/DefaultCliListService;->INSTANCE Lcom/bytedance/trae/conversation/DefaultCliListService;
    check-cast v1, Lcom/bytedance/trae/conversation/CliListService;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +010h
    new-instance v2, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    new-instance v3, Lcom/bytedance/trae/conversation/CliListRepository$1;
    sget-object v4, Lcom/bytedance/trae/conversation/tracker/DeviceTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/DeviceTracker;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/CliListRepository$1;-><init>(Ljava/lang/Object;)V
    check-cast v3, Lkotlin/jvm/functions/Function1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;-><init>(Lcom/bytedance/trae/conversation/CliListService; Lcom/bytedance/trae/conversation/DeviceCountEventTracker;)V
    return-void 
.end method

.method public static final synthetic access$getInstance$delegate$cp()kotlin.Lazy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->instance$delegate Lkotlin/Lazy;
    return-object v0
.end method

.method public static final synthetic access$refreshClis(com.bytedance.trae.conversation.CliListRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/CliListRepository;->keva$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final instance_delegate$lambda$14()com.bytedance.trae.conversation.CliListRepository
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository;
    const/4 v1, 0
    const/4 v2, 3
    invoke-direct v0, v1, v1, v2, v1, Lcom/bytedance/trae/conversation/CliListRepository;-><init>(Lcom/bytedance/trae/conversation/CliListService; Lcom/bytedance/trae/conversation/DeviceCountEventTracker; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method private static final keva_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "_cli_list_repo"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method private final persistCliIdToTypeMap(java.util.Map)void
    .registers 6
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-interface v5, Ljava/util/Map;->isEmpty()Z
    move-result v0
    const-string v1, "cli_id_to_type"
    if-eqz v0, +00ch
    invoke-direct v4, Lcom/bytedance/trae/conversation/CliListRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v5
    const-string v0, ""
    invoke-virtual v5, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    goto +35h
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    invoke-interface v5, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +018h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-virtual v0, v3, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    goto -1bh
    invoke-direct v4, Lcom/bytedance/trae/conversation/CliListRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v5
    invoke-virtual v0, Lorg/json/JSONObject;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v5, v1, v0, Lcom/bytedance/keva/Keva;->storeString(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    goto +bh
    move-exception v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
    :try_start_0xd
.end method

.method private final refreshClis(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +15h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClis$1;->label I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClisResult(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    check-cast v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;->getClis()Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method private final toMobileDevices(java.util.List)java.util.List
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +015h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Cli;
    const/4 v2, 1
    const/4 v3, 0
    const/4 v4, 0
    invoke-static v1, v4, v2, v3, Lcom/bytedance/trae/conversation/devices/MobileDeviceKt;->toMobileDeviceOrNull$default(Lcom/bytedance/trae/im/service/Cli; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/devices/MobileDevice;
    move-result-object v1
    if-eqz v1, -013h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -18h
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method private final updateCache(java.util.List)void
    .registers 6
    # ins_size=2
    iput-object v5, v4, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    iget-object v0, v4, Lcom/bytedance/trae/conversation/CliListRepository;->_cachedClis Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v5, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +021h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +003h
    goto +ch
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +5h
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, -01fh
    invoke-interface v0, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -24h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/MapsKt;->toMap(Ljava/lang/Iterable;)Ljava/util/Map;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/CliListRepository;->saveCliIdToTypeMap(Ljava/util/Map;)V
    return-void 
.end method

.method public final fetchClis(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=3
    instance-of v0, v6, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;
    invoke-direct v0, v4, v6, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->L$0 Ljava/lang/Object;
    check-cast v5, Lkotlin/jvm/functions/Function1;
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v6, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v6, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchClis$1;->label I
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    invoke-interface v5, v6, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v5
.end method

.method public final fetchDevices(kotlin.jvm.functions.Function1  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->label I
    const/4 v3, 1
    if-eqz v2, +01ch
    if-ne v2, v3, +012h
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->L$1 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/CliListRepository;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lkotlin/jvm/functions/Function1;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v4, v7
    move-object v7, v6
    move-object v6, v0
    move-object v0, v4
    goto +1bh
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$fetchDevices$1;->label I
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v0, v7
    move-object v7, v5
    check-cast v0, Ljava/util/List;
    invoke-direct v7, v0, Lcom/bytedance/trae/conversation/CliListRepository;->toMobileDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    invoke-interface v6, v7, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v6, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v6
.end method

.method public final getCacheCliTypes()java.util.Map
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->isInited Z
    if-nez v0, +00ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository;->getCliIdToTypeMapFromKeva()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    return-object v0
.end method

.method public final getCacheClis()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    return-object v0
.end method

.method public final getCachedClis()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedClis Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getCachedDevices()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;->toMobileDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public final getCachedDiscoverableDevices()java.util.List
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoveryDevices Ljava/util/List;
    return-object v0
.end method

.method public final getCachedDiscoverableDevices()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoverableDevices Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getCliIdToTypeMapFromKeva()java.util.Map
    .registers 7
    # ins_size=1
    const-string v0, ""
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v6
    check-cast v1, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-direct v6, Lcom/bytedance/trae/conversation/CliListRepository;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const-string v2, "cli_id_to_type"
    invoke-virtual v1, v2, v0, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v1, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    new-instance v1, Ljava/util/LinkedHashMap;
    invoke-direct v1, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v1, Ljava/util/Map;
    invoke-virtual v2, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v3
    const-string v4, "keys(...)"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +014h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v2, v4, v0, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    invoke-interface v1, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -13h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    return-object v1
    :try_start_0x2
    :try_start_0x40
.end method

.method public final getCliTypeById(java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->isInited Z
    if-nez v0, +00ch
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository;->getCliIdToTypeMapFromKeva()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    if-nez v2, +004h
    const/4 v2, 0
    return-object v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    return-object v2
.end method

.method public final getClis(kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=2
    instance-of v0, v9, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;
    invoke-direct v0, v8, v9, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +37h
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v4
    iget-object v9, v8, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    check-cast v9, Ljava/util/Collection;
    invoke-interface v9, Ljava/util/Collection;->isEmpty()Z
    move-result v9
    xor-int/2addr v9, v3
    if-eqz v9, +00eh
    iget-wide v6, v8, Lcom/bytedance/trae/conversation/CliListRepository;->fetchedAt J
    sub-long/2addr v4, v6
    const-wide/16 v6, 1000
    cmp-long v9, v4, v6
    if-gez v9, +005h
    iget-object v9, v8, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    return-object v9
    iget-object v9, v8, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    sget-object v2, Lcom/bytedance/trae/im/service/CliListSource;->REGISTERED Lcom/bytedance/trae/im/service/CliListSource;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$getClis$1;->label I
    invoke-interface v9, v2, v0, Lcom/bytedance/trae/conversation/CliListService;->listClis(Lcom/bytedance/trae/im/service/CliListSource; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    move-object v0, v8
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +037h
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-eqz v1, +02bh
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/service/ListClisResponse;
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/ListClisResponse;->getClis()Ljava/util/List;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    if-nez v9, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v9
    invoke-direct v0, v9, Lcom/bytedance/trae/conversation/CliListRepository;->updateCache(Ljava/util/List;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository;->deviceCountEventTracker Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    invoke-virtual v9, v1, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onFetchSucceeded(Ljava/util/List;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;->fetchedAt J
    goto +6h
    iget-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository;->deviceCountEventTracker Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onFetchFailed()V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    return-object v9
.end method

.method public final getDevices(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$getDevices$1;->label I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/CliListRepository;->getClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    move-object v0, v4
    check-cast v5, Ljava/util/List;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/CliListRepository;->toMobileDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v5
    return-object v5
.end method

.method public final getOnboardingState(kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=2
    instance-of v0, v6, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;
    if-eqz v0, +012h
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->label I
    sub-int/2addr v6, v2
    iput v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +17h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v6, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$getOnboardingState$1;->label I
    invoke-interface v6, v0, Lcom/bytedance/trae/conversation/CliListService;->getOnboardingState(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +003h
    return-object v1
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v0, v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v0, +043h
    check-cast v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v0
    if-eqz v0, +037h
    invoke-virtual v6, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v6
    invoke-virtual v6, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/im/service/OnboardingStateResponse;
    if-eqz v6, +02bh
    invoke-virtual v6, Lcom/bytedance/trae/im/service/OnboardingStateResponse;->getHasRegisteredWork()Ljava/lang/Boolean;
    move-result-object v0
    invoke-virtual v6, Lcom/bytedance/trae/im/service/OnboardingStateResponse;->getHasRegisteredIDE()Ljava/lang/Boolean;
    move-result-object v1
    invoke-virtual v6, Lcom/bytedance/trae/im/service/OnboardingStateResponse;->getHasConversation()Ljava/lang/Boolean;
    move-result-object v6
    if-eqz v0, +01dh
    if-eqz v1, +01bh
    if-eqz v6, +019h
    new-instance v2, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    new-instance v4, Lcom/bytedance/trae/conversation/OnboardingState;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v6
    invoke-direct v4, v0, v1, v6, Lcom/bytedance/trae/conversation/OnboardingState;-><init>(Z Z Z)V
    invoke-direct v2, v4, v3, Lcom/bytedance/trae/conversation/OnboardingStateResult;-><init>(Lcom/bytedance/trae/conversation/OnboardingState; Z)V
    return-object v2
    new-instance v6, Lcom/bytedance/trae/conversation/OnboardingStateResult;
    const/4 v0, 0
    const/4 v1, 0
    invoke-direct v6, v0, v1, Lcom/bytedance/trae/conversation/OnboardingStateResult;-><init>(Lcom/bytedance/trae/conversation/OnboardingState; Z)V
    return-object v6
.end method

.method public final hasMultipleLocalCliTypes()boolean
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, -010h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +01ah
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Ljava/lang/String;
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    xor-int/2addr v3, v4
    if-eqz v3, -019h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->toSet(Ljava/lang/Iterable;)Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->size()I
    move-result v0
    const/4 v1, 2
    if-lt v0, v1, +003h
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method public final refreshClisResult(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ch
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    sget-object v2, Lcom/bytedance/trae/im/service/CliListSource;->REGISTERED Lcom/bytedance/trae/im/service/CliListSource;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshClisResult$1;->label I
    invoke-interface v5, v2, v0, Lcom/bytedance/trae/conversation/CliListService;->listClis(Lcom/bytedance/trae/im/service/CliListSource; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    move-object v0, v4
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v1, v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v1, +03eh
    check-cast v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v1
    if-eqz v1, +032h
    invoke-virtual v5, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/im/service/ListClisResponse;
    if-eqz v5, +007h
    invoke-virtual v5, Lcom/bytedance/trae/im/service/ListClisResponse;->getClis()Ljava/util/List;
    move-result-object v5
    goto +2h
    const/4 v5, 0
    if-nez v5, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/CliListRepository;->updateCache(Ljava/util/List;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    iput-wide v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;->fetchedAt J
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository;->deviceCountEventTracker Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    iget-object v1, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    invoke-virtual v5, v1, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onFetchSucceeded(Ljava/util/List;)V
    new-instance v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    invoke-direct v5, v0, v3, Lcom/bytedance/trae/conversation/CliListRefreshResult;-><init>(Ljava/util/List; Z)V
    return-object v5
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository;->deviceCountEventTracker Lcom/bytedance/trae/conversation/DeviceCountEventTracker;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/DeviceCountEventTracker;->onFetchFailed()V
    new-instance v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDeviceItems Ljava/util/List;
    const/4 v1, 0
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/conversation/CliListRefreshResult;-><init>(Ljava/util/List; Z)V
    return-object v5
.end method

.method public final refreshDevices(kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=2
    instance-of v0, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;
    if-eqz v0, +012h
    move-object v0, v5
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->label I
    sub-int/2addr v5, v2
    iput v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;
    invoke-direct v0, v4, v5, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +18h
    new-instance v5, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v5, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v5
    invoke-static v5, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDevices$1;->label I
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClisResult(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v5
    if-ne v5, v1, +003h
    return-object v1
    move-object v0, v4
    check-cast v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;
    new-instance v1, Lcom/bytedance/trae/conversation/DeviceListRefreshResult;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;->getClis()Ljava/util/List;
    move-result-object v2
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/CliListRepository;->toMobileDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/conversation/CliListRefreshResult;->isSuccess()Z
    move-result v5
    invoke-direct v1, v0, v5, Lcom/bytedance/trae/conversation/DeviceListRefreshResult;-><init>(Ljava/util/List; Z)V
    return-object v1
.end method

.method public final refreshDiscoverableDevices(kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=2
    instance-of v0, v9, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;
    invoke-direct v0, v8, v9, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    const/4 v5, 0
    if-eqz v2, +02ah
    if-eq v2, v4, +01bh
    if-ne v2, v3, +011h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$1 Ljava/lang/Object;
    check-cast v1, Lkotlinx/coroutines/sync/Mutex;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$0 Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +40h
    move-exception v9
    goto/16 +08dh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$1 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/sync/Mutex;
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v9, v2
    goto +14h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v9, v8, Lcom/bytedance/trae/conversation/CliListRepository;->discoveryRefreshMutex Lkotlinx/coroutines/sync/Mutex;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$1 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    invoke-interface v9, v5, v0, Lkotlinx/coroutines/sync/Mutex;->lock(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v2
    if-ne v2, v1, +003h
    return-object v1
    move-object v6, v8
    iget-object v2, v6, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    sget-object v7, Lcom/bytedance/trae/im/service/CliListSource;->ALL Lcom/bytedance/trae/im/service/CliListSource;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$0 Ljava/lang/Object;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->L$1 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$refreshDiscoverableDevices$1;->label I
    invoke-interface v2, v7, v0, Lcom/bytedance/trae/conversation/CliListService;->listClis(Lcom/bytedance/trae/im/service/CliListSource; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v1, +003h
    return-object v1
    move-object v1, v9
    move-object v9, v0
    move-object v0, v6
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +03bh
    move-object v2, v9
    check-cast v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v2
    if-nez v2, +003h
    goto +2ch
    check-cast v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v9, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/network/response/BizResponse;->getData()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/im/service/ListClisResponse;
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/bytedance/trae/im/service/ListClisResponse;->getClis()Ljava/util/List;
    move-result-object v9
    goto +2h
    move-object v9, v5
    if-nez v9, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v9
    invoke-static v9, Lcom/bytedance/trae/conversation/CliListRepositoryKt;->mapDiscoverableDevices(Ljava/util/List;)Ljava/util/List;
    move-result-object v9
    iput-object v9, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoveryDevices Ljava/util/List;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository;->_cachedDiscoverableDevices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v9, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    new-instance v0, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    invoke-direct v0, v9, v4, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;-><init>(Ljava/util/List; Z)V
    goto +ah
    new-instance v9, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;
    iget-object v0, v0, Lcom/bytedance/trae/conversation/CliListRepository;->cachedDiscoveryDevices Ljava/util/List;
    const/4 v2, 0
    invoke-direct v9, v0, v2, Lcom/bytedance/trae/conversation/DeviceDiscoveryRefreshResult;-><init>(Ljava/util/List; Z)V
    move-object v0, v9
    invoke-interface v1, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    return-object v0
    move-exception v0
    move-object v1, v9
    move-object v9, v0
    invoke-interface v1, v5, Lkotlinx/coroutines/sync/Mutex;->unlock(Ljava/lang/Object;)V
    throw v9
    :try_start_0x32
    :try_start_0x61
    :try_start_0x75
.end method

.method public final renameCli(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=4
    instance-of v0, v8, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;
    invoke-direct v0, v5, v8, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +41h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v5, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    invoke-interface v8, v6, v7, v0, Lcom/bytedance/trae/conversation/CliListService;->renameCli(Ljava/lang/String; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v6, v5
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v7, v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v7, +01ah
    check-cast v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v8, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v7
    if-eqz v7, +00eh
    const/4 v7, 0
    iput-object v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$renameCli$1;->label I
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +004h
    return-object v1
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    return-object v6
.end method

.method public final saveCliId(java.lang.String  java.lang.String)void
    .registers 5
    # ins_size=3
    if-eqz v3, +026h
    if-nez v4, +003h
    goto +22h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypesLock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 1
    iput-boolean v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->isInited Z
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v1, v3, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    monitor-exit v0
    return-void 
    iget-object v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v1, v3, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v3, v2, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/CliListRepository;->persistCliIdToTypeMap(Ljava/util/Map;)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v3
    monitor-exit v0
    throw v3
    return-void 
    :try_start_0x9
    :try_start_0x15
.end method

.method public final saveCliIdToTypeMap(java.util.Map)void
    .registers 8
    # ins_size=2
    const-string v0, "map"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypesLock Ljava/lang/Object;
    monitor-enter v0
    const/4 v1, 1
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/CliListRepository;->isInited Z
    invoke-interface v7, Ljava/util/Map;->size()I
    move-result v2
    iget-object v3, v6, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v3, Ljava/util/Map;->size()I
    move-result v3
    if-ne v2, v3, +03ah
    invoke-interface v7, Ljava/util/Map;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    goto +2eh
    invoke-interface v7, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +021h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    iget-object v5, v6, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v5, v4, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, -022h
    const/4 v1, 0
    if-eqz v1, +004h
    monitor-exit v0
    return-void 
    invoke-static v7, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v1
    iput-object v1, v6, Lcom/bytedance/trae/conversation/CliListRepository;->cachedTypes Ljava/util/Map;
    invoke-interface v7, Ljava/util/Map;->isEmpty()Z
    move-result v1
    if-eqz v1, +00bh
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/CliListRepository;->persistCliIdToTypeMap(Ljava/util/Map;)V
    monitor-exit v0
    return-void 
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/CliListRepository;->persistCliIdToTypeMap(Ljava/util/Map;)V
    sget-object v7, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v0
    return-void 
    move-exception v7
    monitor-exit v0
    throw v7
    :try_start_0x9
    :try_start_0x4f
    :try_start_0x64
.end method

.method public final unregisterCli(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;-><init>(Lcom/bytedance/trae/conversation/CliListRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    const/4 v3, 2
    const/4 v4, 1
    if-eqz v2, +01ah
    if-eq v2, v4, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +41h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    iget-object v6, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->L$0 Ljava/lang/Object;
    check-cast v6, Lcom/bytedance/trae/conversation/CliListRepository;
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +12h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/CliListRepository;->service Lcom/bytedance/trae/conversation/CliListService;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->L$0 Ljava/lang/Object;
    iput v4, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    invoke-interface v7, v6, v0, Lcom/bytedance/trae/conversation/CliListService;->unregisterCli(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    move-object v6, v5
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult;
    instance-of v2, v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    if-eqz v2, +01ah
    check-cast v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;
    invoke-virtual v7, Lcom/bytedance/trae/network/response/HttpDataResult$Success;->getBizResp()Lcom/bytedance/trae/network/response/BizResponse;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/network/response/BizResponse;->isSuccess()Z
    move-result v7
    if-eqz v7, +00eh
    const/4 v7, 0
    iput-object v7, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/CliListRepository$unregisterCli$1;->label I
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/CliListRepository;->refreshClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v6
    if-ne v6, v1, +004h
    return-object v1
    const/4 v4, 0
    invoke-static v4, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v6
    return-object v6
.end method
