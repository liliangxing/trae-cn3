# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
.super Ljava/lang/Object;
.source "SiteMessageRepository.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
.field private static final _unreadCount:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private static bridge initialized:Z
.field private static final readTracker:Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
.field private static final scope:Lkotlinx/coroutines/CoroutineScope;
.field private static final unreadCount:Lkotlinx/coroutines/flow/StateFlow;


.method public static synthetic $r8$lambda$YBWQ0xIi-R-eEX7UY-sRF3Lvm88()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->init$lambda$0()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;
    const/4 v0, 0
    const/4 v1, 1
    invoke-static v0, v1, v0, Lkotlinx/coroutines/SupervisorKt;->SupervisorJob$default(Lkotlinx/coroutines/Job; I Ljava/lang/Object;)Lkotlinx/coroutines/CompletableJob;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    invoke-virtual v1, Lkotlinx/coroutines/MainCoroutineDispatcher;->getImmediate()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v1
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    invoke-interface v0, v1, Lkotlinx/coroutines/CompletableJob;->plus(Lkotlin/coroutines/CoroutineContext;)Lkotlin/coroutines/CoroutineContext;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v0, 0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->unreadCount Lkotlinx/coroutines/flow/StateFlow;
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->readTracker Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$get_unreadCount$p()kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$migrateDefaultPreferences(com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->migrateDefaultPreferences()V
    return-void 
.end method

.method public static synthetic fetchList$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository  int  int  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +004h
    const/16 v2, 10
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->fetchList(I I Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private static final init$lambda$0()void
    .registers 2
    # ins_size=0
    sget-object v0, Landroidx/lifecycle/ProcessLifecycleOwner;->Companion Landroidx/lifecycle/ProcessLifecycleOwner$Companion;
    invoke-virtual v0, Landroidx/lifecycle/ProcessLifecycleOwner$Companion;->get()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    invoke-interface v0, Landroidx/lifecycle/LifecycleOwner;->getLifecycle()Landroidx/lifecycle/Lifecycle;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$init$register$1$1;
    invoke-direct v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$init$register$1$1;-><init>()V
    check-cast v1, Landroidx/lifecycle/LifecycleObserver;
    invoke-virtual v0, v1, Landroidx/lifecycle/Lifecycle;->addObserver(Landroidx/lifecycle/LifecycleObserver;)V
    return-void 
.end method

.method private final initPreferences()void
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v1, 0
    const/4 v2, 0
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;
    const/4 v4, 0
    invoke-direct v3, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$initPreferences$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final migrateDefaultPreferences()void
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->defaultPreferences()Ljava/util/Map;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;
    const/4 v5, 0
    invoke-direct v4, v0, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$migrateDefaultPreferences$1;-><init>(Ljava/util/Map; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public static synthetic updateStatus$default(com.bytedance.trae.home.solo.sitemessage.SiteMessageRepository  java.util.List  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0  int  java.lang.Object)void
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 0
    if-eqz v7, +003h
    move-object v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move-object v5, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->updateStatus(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public final clearLocalUnreadBadge()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final fetchList(int  int  kotlin.coroutines.Continuation)java.lang.Object
    .registers 10
    # ins_size=4
    instance-of v0, v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;
    if-eqz v0, +012h
    move-object v0, v9
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v9, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->label I
    sub-int/2addr v9, v2
    iput v9, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;
    invoke-direct v0, v6, v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v9, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->label I
    const/4 v3, 0
    const/4 v4, 1
    if-eqz v2, +010h
    if-ne v2, v4, +006h
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +40h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v9, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;
    const/4 v2, 2
    new-array v2, v2, [Lkotlin/Pair;
    const-string v5, "page"
    invoke-static v7, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v5, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v3
    const-string v7, "pageSize"
    invoke-static v8, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    aput-object v7, v2, v4
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v7
    invoke-virtual v9, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageParams;->buildQueryParams(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    sget-object v8, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->createService()Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    move-result-object v8
    iput v4, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchList$1;->label I
    invoke-interface v8, v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->getList(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v9
    if-ne v9, v1, +003h
    return-object v1
    check-cast v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    move-result-object v7
    if-eqz v7, +008h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;->getList()Ljava/util/List;
    move-result-object v7
    if-nez v7, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v7
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;
    move-result-object v8
    if-eqz v8, +00ch
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;->getHasMore()Ljava/lang/Boolean;
    move-result-object v8
    if-eqz v8, +006h
    invoke-virtual v8, Ljava/lang/Boolean;->booleanValue()Z
    move-result v3
    invoke-static v3, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method public final fetchPreferences(kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=2
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;
    invoke-direct v0, v6, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +3ch
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v0, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v0, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v7, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->createService()Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    move-result-object v7
    const/4 v2, 2
    new-array v2, v2, [Lkotlin/Pair;
    const-string v4, "platform"
    const-string v5, "Android"
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    const/4 v5, 0
    aput-object v4, v2, v5
    sget-object v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->getStoreCountryCode()Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v5, storeCountryCode
    invoke-static v5, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v2, v3
    invoke-static v2, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v2
    iput v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$fetchPreferences$1;->label I
    invoke-interface v7, v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->getPreferences(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;->getData()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;
    move-result-object v7
    return-object v7
.end method

.method public final getReadTracker()com.bytedance.trae.home.solo.sitemessage.SiteMessageReadTracker
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->readTracker Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    return-object v0
.end method

.method public final getUnreadCount()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->unreadCount Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final handleLogout()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->_unreadCount Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->readTracker Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->clearAll()V
    sget-object v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesCache;->clear()V
    sput-boolean v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->initialized Z
    return-void 
.end method

.method public final init(android.app.Application)void
    .registers 4
    # ins_size=2
    const-string v0, "app"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-boolean v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->initialized Z
    if-eqz v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v3, Lcom/bytedance/trae/network/HostResolver;->isBytecloudLogin()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v3, Lcom/bytedance/trae/network/HostResolver;->isEnterpriseLogin()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    const/4 v3, 1
    sput-boolean v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->initialized Z
    new-instance v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$$ExternalSyntheticLambda0;-><init>()V
    invoke-static Landroid/os/Looper;->myLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +006h
    invoke-interface v3, Ljava/lang/Runnable;->run()V
    goto +dh
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    invoke-virtual v0, v3, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->refreshUnreadCount()V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v3
    if-eqz v3, +005h
    invoke-direct v2, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->initPreferences()V
    sget-object v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->readTracker Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageReadTracker;->retryPendingEvents()V
    return-void 
.end method

.method public final refreshUnreadCount()void
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v0, Lcom/bytedance/trae/network/HostResolver;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    invoke-virtual v0, Lcom/bytedance/trae/network/HostResolver;->isEnterpriseLogin()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$refreshUnreadCount$1;
    const/4 v4, 0
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$refreshUnreadCount$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final updatePreferences(java.util.Map  kotlin.coroutines.Continuation)java.lang.Object
    .registers 8
    # ins_size=3
    instance-of v0, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;
    if-eqz v0, +012h
    move-object v0, v7
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->label I
    sub-int/2addr v7, v2
    iput v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;
    invoke-direct v0, v5, v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;-><init>(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository; Lkotlin/coroutines/Continuation;)V
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->label I
    const/4 v3, 1
    if-eqz v2, +010h
    if-ne v2, v3, +006h
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +58h
    new-instance v6, Ljava/lang/IllegalStateException;
    const-string v7, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v6, v7, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v6
    invoke-static v7, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    new-array v7, v3, [Lkotlin/Pair;
    const-string v2, "platform"
    const-string v4, "Android"
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v4, 0
    aput-object v2, v7, v4
    invoke-static v7, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v7
    invoke-interface v6, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +020h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-interface v2, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Boolean;
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    invoke-static v2, Lkotlin/coroutines/jvm/internal/Boxing;->boxBoolean(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v7, v4, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -23h
    sget-object v6, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->Companion Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->createService()Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    move-result-object v6
    iput v3, v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updatePreferences$1;->label I
    invoke-interface v6, v7, v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;->updatePreferences(Ljava/util/Map; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v7
    if-ne v7, v1, +003h
    return-object v1
    check-cast v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesPostResponse;
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesPostResponse;->getData()Ljava/util/Map;
    move-result-object v6
    return-object v6
.end method

.method public final updateStatus(java.util.List  java.lang.String  kotlin.jvm.functions.Function0  kotlin.jvm.functions.Function0)void
    .registers 15
    # ins_size=5
    const-string v0, "ids"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "action"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository;->scope Lkotlinx/coroutines/CoroutineScope;
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;
    const/4 v9, 0
    move-object v4, v0
    move-object v5, v11
    move-object v6, v12
    move-object v7, v13
    move-object v8, v14
    invoke-direct/range v4 ... v9, Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageRepository$updateStatus$1;-><init>(Ljava/util/List; Ljava/lang/String; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
