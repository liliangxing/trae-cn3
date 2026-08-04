# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
.super Ljava/lang/Object;
.source "DeviceManagementRepository.kt"

.implements Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;

.field public static final $stable:I
.field private static final CLI_TYPE_IDE:Ljava/lang/String;
.field private static final CLI_TYPE_WORK:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Companion;
.field private static final DELETE_CLI_PATH:Ljava/lang/String;
.field private static final LIST_CLIS_PATH:Ljava/lang/String;
.field private static final RENAME_CLI_PATH:Ljava/lang/String;
.field private static final SOLO_HUB_OPTIONS:Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
.field private static final STATUS_ONLINE:Ljava/lang/String;
.field private static final SUCCESS_CODES:Ljava/util/Set;
.field private static final json:Lkotlinx/serialization/json/Json;
.field private final _devices:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final activeMutations:Ljava/util/Map;
.field private final devices:Lkotlinx/coroutines/flow/StateFlow;
.field private final events:Lkotlinx/coroutines/channels/Channel;
.field private final httpClient:Lcom/bytedance/trae/kmp/network/KmpHttpClient;
.field private final mutationQueues:Ljava/util/Map;
.field private nextOperationId:J
.field private final overlays:Ljava/util/Map;
.field private refreshInFlight:Z
.field private refreshQueued:Z
.field private final refreshWaiters:Ljava/util/List;
.field private final repositoryScope:Lkotlinx/coroutines/CoroutineScope;


.method public static synthetic $r8$lambda$x7zq51aq61StJWGVgWgfYlJQ4TI(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->json$lambda$10(Lkotlinx/serialization/json/JsonBuilder;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 11
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->Companion Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->$stable I
    const-wide/16 v2, 200
    invoke-static v2, v3, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SUCCESS_CODES Ljava/util/Set;
    new-instance v0, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    const-string v3, "device_management"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    const/16 v9, 30
    const/4 v10, 0
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;-><init>(Ljava/lang/String; Z Z Z Lcom/bytedance/trae/kmp/network/KmpRequestAuth; Lcom/bytedance/trae/kmp/network/KmpHostType; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SOLO_HUB_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$$ExternalSyntheticLambda0;-><init>()V
    const/4 v2, 1
    invoke-static v1, v0, v2, v1, Lkotlinx/serialization/json/JsonKt;->Json$default(Lkotlinx/serialization/json/Json; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/serialization/json/Json;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->json Lkotlinx/serialization/json/Json;
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  kotlinx.coroutines.CoroutineScope  kotlinx.coroutines.CoroutineDispatcher)void
    .registers 11
    # ins_size=4
    const-string v0, "httpClient"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "ownerScope"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, repositoryDispatcher
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, Ljava/lang/Object;-><init>()V
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    invoke-static v9, v10, Lcom/bytedance/trae/kmp/repository/KmpRepositoryCoroutinesKt;->repositoryScope(Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/CoroutineDispatcher;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    iput-object v1, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->repositoryScope Lkotlinx/coroutines/CoroutineScope;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v8
    invoke-static v8, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v8
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v8, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v8
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->devices Lkotlinx/coroutines/flow/StateFlow;
    const/4 v8, 6
    const v9, 2147483647
    const/4 v10, 0
    invoke-static v9, v10, v10, v8, v10, Lkotlinx/coroutines/channels/ChannelKt;->Channel$default(I Lkotlinx/coroutines/channels/BufferOverflow; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Lkotlinx/coroutines/channels/Channel;
    move-result-object v8
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->events Lkotlinx/coroutines/channels/Channel;
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/List;
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshWaiters Ljava/util/List;
    new-instance v8, Ljava/util/LinkedHashMap;
    invoke-direct v8, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v8, Ljava/util/Map;
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->overlays Ljava/util/Map;
    new-instance v8, Ljava/util/LinkedHashMap;
    invoke-direct v8, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v8, Ljava/util/Map;
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->mutationQueues Ljava/util/Map;
    new-instance v8, Ljava/util/LinkedHashMap;
    invoke-direct v8, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v8, Ljava/util/Map;
    iput-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->activeMutations Ljava/util/Map;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;
    invoke-direct v8, v7, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    move-object v4, v8
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  kotlinx.coroutines.CoroutineScope  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method public static final synthetic access$executeMutation(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->executeMutation(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$fetchDevices(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository  kotlin.coroutines.Continuation)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->fetchDevices(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getEvents$p(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository)kotlinx.coroutines.channels.Channel
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->events Lkotlinx/coroutines/channels/Channel;
    return-object v0
.end method

.method public static final synthetic access$reduce(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->reduce(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event;)V
    return-void 
.end method

.method private final applyOptimisticMutation(java.util.List  com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation)java.util.List
    .registers 14
    # ins_size=3
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getType()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    if-eqz v1, +049h
    check-cast v12, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v12, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +02dh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +014h
    const/4 v4, 0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;->getName()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 29
    const/4 v10, 0
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->copy$default(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -30h
    check-cast v1, Ljava/util/List;
    goto +38h
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +032h
    check-cast v12, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +01bh
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, -019h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1eh
    move-object v1, v0
    check-cast v1, Ljava/util/List;
    return-object v1
    new-instance v12, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v12, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v12
.end method

.method private final applyOverlays(java.util.List)java.util.List
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +03fh
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->overlays Ljava/util/Map;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-interface v1, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;
    instance-of v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;
    if-eqz v3, +014h
    const/4 v3, 0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;->getName()Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 29
    const/4 v9, 0
    invoke-static/range v2 ... v9, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->copy$default(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v2
    goto +9h
    instance-of v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Delete;
    if-eqz v3, +004h
    const/4 v2, 0
    goto +3h
    if-nez v1, +008h
    if-eqz v2, -037h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    check-cast v0, Ljava/util/List;
    return-object v0
.end method

.method private final defaultModel(com.bytedance.trae.home.solo.setting.data.DeviceManagementProduct)java.lang.String
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +00eh
    const/4 v0, 2
    if-ne v2, v0, +005h
    const-string v2, "TRAE IDE"
    goto +9h
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    const-string v2, "MacBook Pro 16''"
    return-object v2
.end method

.method private final executeMutation(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Mutation  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    move-object/from16 v1, v16
    move-object/from16 v0, v18
    instance-of v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;
    iget v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    move-object v11, v2
    iget-object v0, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->label I
    const/4 v14, 0
    const/4 v15, 1
    if-eqz v3, +011h
    if-ne v3, v15, +007h
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +091h
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getType()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-result-object v0
    instance-of v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    if-eqz v3, +027h
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;
    const-string v4, "/api/solo_hub/v1/apps/rename_cli"
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->json Lkotlinx/serialization/json/Json;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;->Companion Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v6
    check-cast v6, Lkotlinx/serialization/SerializationStrategy;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getCliId()Ljava/lang/String;
    move-result-object v8
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/home/solo/setting/data/RenameCliRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, v6, v7, Lkotlinx/serialization/json/Json;->encodeToString(Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    goto +27h
    sget-object v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +074h
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;
    const-string v0, "/api/solo_hub/v1/clis/unregister"
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->json Lkotlinx/serialization/json/Json;
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;->Companion Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v5
    check-cast v5, Lkotlinx/serialization/SerializationStrategy;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/setting/data/DeleteCliRequest;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v5, v6, Lkotlinx/serialization/json/Json;->encodeToString(Lkotlinx/serialization/SerializationStrategy; Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v0, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v4, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;->getPath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationRequest;->getBody()Ljava/lang/String;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SOLO_HUB_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->Companion Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
    sget-object v10, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse;->Companion Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/EmptyResponse$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v10
    invoke-virtual v3, v10, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;->serializer(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v3
    move-object v10, v3
    check-cast v10, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v12, 24
    const/4 v13, 0
    iput v15, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$executeMutation$1;->label I
    move-object v3, v0
    invoke-static/range v3 ... v13, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->postResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getError()Ljava/lang/Throwable;
    move-result-object v2
    if-nez v2, +018h
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    if-eqz v0, +00ch
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v0, v2, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->isSuccess(Ljava/util/Set;)Z
    move-result v0
    if-ne v0, v15, +004h
    move v0, v15
    goto +2h
    move v0, v14
    if-eqz v0, +003h
    goto +2h
    move v15, v14
    invoke-static v15, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +12h
    new-instance v0, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v0, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v0
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v14, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +003h
    move-object v0, v2
    return-object v0
    :try_start_0x2c
    :try_start_0x3c
.end method

.method private final fetchDevices(kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=2
    move-object/from16 v1, v16
    move-object/from16 v0, v17
    instance-of v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;
    if-eqz v2, +012h
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;
    iget v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->label I
    sub-int/2addr v0, v4
    iput v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;
    invoke-direct v2, v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    move-object v10, v2
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v2
    iget v3, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->label I
    const/4 v14, 0
    const/4 v15, 0
    const/4 v12, 1
    if-eqz v3, +015h
    if-ne v3, v12, +00bh
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move v13, v12
    goto +3bh
    new-instance v0, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v0, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v0
    invoke-static v0, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    iget-object v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->httpClient Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    sget-object v4, Lcom/bytedance/trae/kmp/network/KmpHostType;->Ai Lcom/bytedance/trae/kmp/network/KmpHostType;
    const-string v5, "/api/solo_hub/v1/clis"
    const/4 v6, 0
    const/4 v7, 0
    sget-object v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SOLO_HUB_OPTIONS Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions;
    sget-object v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->Companion Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;
    sget-object v9, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->Companion Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData$Companion;->serializer()Lkotlinx/serialization/KSerializer;
    move-result-object v9
    invoke-virtual v0, v9, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse$Companion;->serializer(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;
    move-result-object v0
    move-object v9, v0
    check-cast v9, Lkotlinx/serialization/DeserializationStrategy;
    const/16 v11, 12
    const/4 v0, 0
    iput-object v1, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->L$0 Ljava/lang/Object;
    iput v12, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$fetchDevices$1;->label I
    move v13, v12
    move-object v12, v0
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/kmp/network/KmpHttpClient$DefaultImpls;->getResult$default(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/network/KmpHostType; Ljava/lang/String; Ljava/util/Map; Ljava/util/Map; Lcom/bytedance/trae/kmp/network/KmpHttpRequestOptions; Lkotlinx/serialization/DeserializationStrategy; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    if-ne v0, v2, +003h
    return-object v2
    move-object v2, v1
    check-cast v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getData()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;
    invoke-virtual v0, Lcom/bytedance/trae/kmp/network/KmpHttpResult;->getError()Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +051h
    if-eqz v3, +00ch
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->SUCCESS_CODES Ljava/util/Set;
    invoke-virtual v3, v0, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->isSuccess(Ljava/util/Set;)Z
    move-result v0
    if-ne v0, v13, +004h
    move v12, v13
    goto +2h
    move v12, v14
    if-nez v12, +003h
    goto +40h
    invoke-virtual v3, Lcom/bytedance/trae/kmp/network/KmpBusinessResponse;->getData()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/ListClisResponseData;->getClis()Ljava/util/List;
    move-result-object v0
    goto +2h
    move-object v0, v15
    if-nez v0, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/setting/data/CliDto;
    invoke-direct v2, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->toDeviceOrNull(Lcom/bytedance/trae/home/solo/setting/data/CliDto;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v4
    if-eqz v4, -010h
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v3, Ljava/util/List;
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    invoke-direct v0, v13, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;-><init>(Z Ljava/util/List;)V
    goto +7h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    const/4 v2, 2
    invoke-direct v0, v14, v15, v2, v15, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;-><init>(Z Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v2
    if-nez v2, +003h
    goto +7h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    const/4 v2, 2
    invoke-direct v0, v14, v15, v2, v15, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;-><init>(Z Ljava/util/List; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
    :try_start_0x31
    :try_start_0x41
.end method

.method private final handleMutationCompleted(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationCompleted)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->activeMutations Ljava/util/Map;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    const/4 v1, 0
    if-eqz v0, +00fh
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getOperationId()J
    move-result-wide v2
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->getOperationId()J
    move-result-wide v4
    cmp-long v2, v2, v4
    if-nez v2, +003h
    const/4 v1, 1
    if-nez v1, +003h
    return-void 
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->activeMutations Ljava/util/Map;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;->getResult()Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v0
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->getSuccess()Z
    move-result v1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->startNextMutation(Ljava/lang/String;)V
    return-void 
.end method

.method private final handleMutationRequested(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$MutationRequested)void
    .registers 12
    # ins_size=2
    iget-wide v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->nextOperationId J
    const-wide/16 v2, 1
    add-long/2addr v0, v2
    iput-wide v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->nextOperationId J
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getType()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-result-object v8
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getResult()Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v9
    move-object v4, v2
    move-wide v5, v0
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;-><init>(J Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)V
    iget-object v3, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->overlays Ljava/util/Map;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getType()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-result-object v5
    instance-of v6, v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    if-eqz v6, +014h
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getType()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;->getName()Ljava/lang/String;
    move-result-object v6
    invoke-direct v5, v0, v1, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Rename;-><init>(J Ljava/lang/String;)V
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;
    goto +10h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +048h
    new-instance v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Delete;
    invoke-direct v5, v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay$Delete;-><init>(J)V
    check-cast v5, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$OperationOverlay;
    invoke-interface v3, v4, v5, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    invoke-direct v10, v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->applyOptimisticMutation(Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;)Ljava/util/List;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->mutationQueues Ljava/util/Map;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    if-nez v3, +00ah
    new-instance v3, Lkotlin/collections/ArrayDeque;
    invoke-direct v3, Lkotlin/collections/ArrayDeque;-><init>()V
    invoke-interface v0, v1, v3, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    check-cast v3, Lkotlin/collections/ArrayDeque;
    invoke-virtual v3, v2, Lkotlin/collections/ArrayDeque;->addLast(Ljava/lang/Object;)V
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->activeMutations Ljava/util/Map;
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getCliId()Ljava/lang/String;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +009h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;->getCliId()Ljava/lang/String;
    move-result-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->startNextMutation(Ljava/lang/String;)V
    return-void 
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
.end method

.method private final handleRefreshCompleted(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$RefreshResult)void
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->getDevices()Ljava/util/List;
    move-result-object v0
    if-eqz v0, +00fh
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->getDevices()Ljava/util/List;
    move-result-object v1
    invoke-direct v3, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->applyOverlays(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->overlays Ljava/util/Map;
    invoke-interface v0, Ljava/util/Map;->clear()V
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->getSuccess()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +00ch
    iget-boolean v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshQueued Z
    if-eqz v0, +008h
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshQueued Z
    invoke-direct v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->startRefresh()V
    return-void 
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshInFlight Z
    iput-boolean v1, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshQueued Z
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshWaiters Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lkotlinx/coroutines/CompletableDeferred;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;->getSuccess()Z
    move-result v2
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v1, v2, Lkotlinx/coroutines/CompletableDeferred;->complete(Ljava/lang/Object;)Z
    goto -17h
    iget-object v4, v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshWaiters Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->clear()V
    return-void 
.end method

.method private final handleRefreshRequested(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event$RefreshRequested)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshWaiters Ljava/util/List;
    check-cast v0, Ljava/util/Collection;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;->getResult()Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iget-boolean v2, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshInFlight Z
    const/4 v0, 1
    if-eqz v2, +005h
    iput-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshQueued Z
    return-void 
    iput-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->refreshInFlight Z
    invoke-direct v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->startRefresh()V
    return-void 
.end method

.method private static final json$lambda$10(kotlinx.serialization.json.JsonBuilder)kotlin.Unit
    .registers 2
    # ins_size=1
    const-string v0, "$this$Json"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-virtual v1, v0, Lkotlinx/serialization/json/JsonBuilder;->setIgnoreUnknownKeys(Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final reduce(com.bytedance.trae.home.solo.setting.data.DefaultDeviceManagementRepository$Event)void
    .registers 3
    # ins_size=2
    instance-of v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;
    if-eqz v0, +008h
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->handleRefreshRequested(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;)V
    goto +22h
    instance-of v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshCompleted;
    if-eqz v0, +00ch
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshCompleted;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshCompleted;->getResult()Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->handleRefreshCompleted(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$RefreshResult;)V
    goto +14h
    instance-of v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    if-eqz v0, +008h
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->handleMutationRequested(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;)V
    goto +ah
    instance-of v0, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    if-eqz v0, +008h
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->handleMutationCompleted(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationCompleted;)V
    return-void 
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
.end method

.method private final startNextMutation(java.lang.String)void
    .registers 10
    # ins_size=2
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->mutationQueues Ljava/util/Map;
    invoke-interface v0, v9, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lkotlin/collections/ArrayDeque;
    if-eqz v0, +027h
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +1fh
    invoke-virtual v0, Lkotlin/collections/ArrayDeque;->removeFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation;
    iget-object v1, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->activeMutations Ljava/util/Map;
    invoke-interface v1, v9, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->repositoryScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v3, 0
    const/4 v4, 0
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;
    const/4 v1, 0
    invoke-direct v9, v8, v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startNextMutation$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Mutation; Lkotlin/coroutines/Continuation;)V
    move-object v5, v9
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->mutationQueues Ljava/util/Map;
    invoke-interface v0, v9, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final startRefresh()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->repositoryScope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startRefresh$1;
    const/4 v4, 0
    invoke-direct v3, v6, v4, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$startRefresh$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final toDeviceOrNull(com.bytedance.trae.home.solo.setting.data.CliDto)com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice
    .registers 11
    # ins_size=2
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getType()Ljava/lang/String;
    move-result-object v0
    const-string v1, "local"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +006h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->Work Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    move-object v8, v0
    goto +ch
    const-string v1, "local_ide"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +050h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;->Ide Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    goto -ch
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +041h
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +33h
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getIdeVersion()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    const/4 v3, 1
    xor-int/2addr v1, v3
    if-eqz v1, +003h
    move-object v2, v0
    if-nez v2, +008h
    invoke-direct v9, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->defaultModel(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)Ljava/lang/String;
    move-result-object v0
    move-object v6, v0
    goto +2h
    move-object v6, v2
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/CliDto;->getStatus()Ljava/lang/String;
    move-result-object v10
    const-string v0, "online"
    invoke-static v10, v0, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v7
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-object v3, v10
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;)V
    return-object v10
    return-object v2
.end method

.method public deleteDevice(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 11
    # ins_size=3
    instance-of v0, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;
    if-eqz v0, +012h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v10, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    sub-int/2addr v10, v2
    iput v10, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;
    invoke-direct v0, v8, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +01ah
    if-eq v2, v5, +010h
    if-ne v2, v3, +006h
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ah
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1fh
    invoke-static v10, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static v4, v5, v4, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v10
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->events Lkotlinx/coroutines/channels/Channel;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    sget-object v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Delete;
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-direct v6, v9, v7, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)V
    iput-object v10, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    invoke-interface v2, v6, v0, Lkotlinx/coroutines/channels/Channel;->send(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    move-object v9, v10
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$deleteDevice$1;->label I
    invoke-interface v9, v0, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v10
    if-ne v10, v1, +003h
    return-object v1
    return-object v10
.end method

.method public getDevices()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->devices Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public refresh(kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=2
    instance-of v0, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;
    invoke-direct v0, v7, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +01ah
    if-eq v2, v5, +010h
    if-ne v2, v3, +006h
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +35h
    new-instance v8, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v8, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v8
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +1ah
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static v4, v5, v4, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v2
    iget-object v8, v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->events Lkotlinx/coroutines/channels/Channel;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;
    invoke-direct v6, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$RefreshRequested;-><init>(Lkotlinx/coroutines/CompletableDeferred;)V
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    invoke-interface v8, v6, v0, Lkotlinx/coroutines/channels/Channel;->send(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$refresh$1;->label I
    invoke-interface v2, v0, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    return-object v8
.end method

.method public renameDevice(java.lang.String  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 12
    # ins_size=4
    instance-of v0, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;
    if-eqz v0, +012h
    move-object v0, v11
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v11, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    sub-int/2addr v11, v2
    iput v11, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;
    invoke-direct v0, v8, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v11, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +01ah
    if-eq v2, v5, +010h
    if-ne v2, v3, +006h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3dh
    new-instance v9, Ljava/lang/IllegalStateException;
    const-string v10, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v9, v10, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v9
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->L$0 Ljava/lang/Object;
    check-cast v9, Lkotlinx/coroutines/CompletableDeferred;
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +22h
    invoke-static v11, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    invoke-static v4, v5, v4, Lkotlinx/coroutines/CompletableDeferredKt;->CompletableDeferred$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableDeferred;
    move-result-object v11
    iget-object v2, v8, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;->events Lkotlinx/coroutines/channels/Channel;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;
    invoke-direct v7, v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType$Rename;-><init>(Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType;
    invoke-direct v6, v9, v7, v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$Event$MutationRequested;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$MutationType; Lkotlinx/coroutines/CompletableDeferred;)V
    iput-object v11, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    invoke-interface v2, v6, v0, Lkotlinx/coroutines/channels/Channel;->send(Ljava/lang/Object; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    move-object v9, v11
    iput-object v4, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository$renameDevice$1;->label I
    invoke-interface v9, v0, Lkotlinx/coroutines/CompletableDeferred;->await(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v11
    if-ne v11, v1, +003h
    return-object v1
    return-object v11
.end method
