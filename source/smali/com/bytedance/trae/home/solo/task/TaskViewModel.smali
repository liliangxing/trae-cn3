# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskViewModel;
.super Landroidx/lifecycle/AndroidViewModel;
.source "TaskViewModel.kt"

.field public static final $stable:I
.field private static final CODE_PIN_VERSION_INCOMPATIBLE:J
.field public static final Companion:Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
.field private static final LOCAL_SEARCH_MESSAGE_LIMIT:I
.field private static final TAG:Ljava/lang/String;
.field private static final enOtherYearFormat:Ljava/lang/ThreadLocal;
.field private static final enSameYearFormat:Ljava/lang/ThreadLocal;
.field private static final jaOtherYearFormat:Ljava/lang/ThreadLocal;
.field private static final jaSameYearFormat:Ljava/lang/ThreadLocal;
.field private static final parseDateFormats:Ljava/lang/ThreadLocal;
.field private static final timeOnlyFormat:Ljava/lang/ThreadLocal;
.field private static final zhOtherYearFormat:Ljava/lang/ThreadLocal;
.field private static final zhSameYearFormat:Ljava/lang/ThreadLocal;
.field private final _allTasks:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _contentReady:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _devices:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _isRefreshing:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _isSearchLoading:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _isSearchMode:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _loadError:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _searchQuery:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _searchResults:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _selectedFilter:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final _toastMessage:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final cliRegisterListener:Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;
.field private final cliStatusChangeListener:Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
.field private final cliUnbindListener:Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;
.field private final contentReady:Lkotlinx/coroutines/flow/StateFlow;
.field private final conversationChangeListener:Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
.field private final conversationDao:Lcom/bytedance/trae/im/database/ConversationDao;
.field private final conversationDetailCacheRepository:Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
.field private final conversationMap:Ljava/util/Map;
.field private final dbHelper:Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
.field private final defaultTaskTitle:Ljava/lang/String;
.field private final devices:Lkotlinx/coroutines/flow/StateFlow;
.field private bridge isFirstLoadCompleted:Z
.field private bridge isLoadingTasks:Z
.field private final isRefreshing:Lkotlinx/coroutines/flow/StateFlow;
.field private final isSearchLoading:Lkotlinx/coroutines/flow/StateFlow;
.field private final isSearchMode:Lkotlinx/coroutines/flow/StateFlow;
.field private lastLoadTime:J
.field private final loadError:Lkotlinx/coroutines/flow/StateFlow;
.field private loadTasksJob:Lkotlinx/coroutines/Job;
.field private final minLoadIntervalMs:J
.field private final pendingDeleteIds:Ljava/util/Set;
.field private bridge pendingReload:Z
.field private final pollingIntervalMs:J
.field private pollingJob:Lkotlinx/coroutines/Job;
.field private final refreshIntervalMs:J
.field private final searchDebouncer:Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
.field private final searchQuery:Lkotlinx/coroutines/flow/StateFlow;
.field private final searchResults:Lkotlinx/coroutines/flow/StateFlow;
.field private final selectedFilter:Lkotlinx/coroutines/flow/StateFlow;
.field private final tasks:Lkotlinx/coroutines/flow/StateFlow;
.field private final toastMessage:Lkotlinx/coroutines/flow/SharedFlow;
.field private final userId:Ljava/lang/String;


.method public static synthetic $r8$lambda$B4c89l6b5E1hzCq8DQKs-YDC35o(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationChangeListener$lambda$4(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$CZLNcO6KRo9Qcvuq6gpSEBNlZ78(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.home.solo.task.TaskModel  com.bytedance.trae.home.solo.task.TaskModel)int
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks$lambda$29(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/home/solo/task/TaskModel; Lcom/bytedance/trae/home/solo/task/TaskModel;)I
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$GPfPIVLt27RnhigRTgKwIx-wSXY(com.bytedance.trae.home.solo.task.TaskViewModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->scheduleSearch$lambda$9(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$KpbLETs9XUN5jzX_wWpdrd8jQpQ(com.bytedance.trae.home.solo.task.TaskViewModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->scheduleSearch$lambda$10(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$SKQ-BSOaaEkZToyJ86OxrVlN3A0(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliRegisterPayload)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliRegisterListener$lambda$7(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$XFpMdItyuqG-5m5G6CbjwiSgXws(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliUnbindPayload)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliUnbindListener$lambda$6(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jli5S0q6-Z1e5UHN5ISAW6BDctk(kotlin.jvm.functions.Function2  java.lang.Object  java.lang.Object)int
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks$lambda$30(Lkotlin/jvm/functions/Function2; Ljava/lang/Object; Ljava/lang/Object;)I
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$u_S6Vscr7rXGP6z1fANFImP1sK8(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliStatusChangeListener$lambda$5(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->Companion Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->$stable I
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->parseDateFormats Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->timeOnlyFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->zhSameYearFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->jaSameYearFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enSameYearFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->zhOtherYearFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->jaOtherYearFormat Ljava/lang/ThreadLocal;
    new-instance v0, Ljava/lang/ThreadLocal;
    invoke-direct v0, Ljava/lang/ThreadLocal;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enOtherYearFormat Ljava/lang/ThreadLocal;
    return-void 
.end method

.method public constructor <init>(android.app.Application)void
    .registers 16
    # ins_size=2
    const-string v0, "application"
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v14, v15, Landroidx/lifecycle/AndroidViewModel;-><init>(Landroid/app/Application;)V
    sget v0, Lcom/bytedance/trae/home/R$string;->solo_task_new_task I
    invoke-virtual v15, v0, Landroid/app/Application;->getString(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "getString(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->defaultTaskTitle Ljava/lang/String;
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00fh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +009h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +003h
    goto +3h
    const-string v0, "anonymous"
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->userId Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    check-cast v15, Landroid/content/Context;
    invoke-virtual v1, v15, v0, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context; Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->dbHelper Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    new-instance v1, Lcom/bytedance/trae/im/database/ConversationDao;
    invoke-direct v1, v0, Lcom/bytedance/trae/im/database/ConversationDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    iput-object v1, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationDao Lcom/bytedance/trae/im/database/ConversationDao;
    new-instance v1, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    new-instance v2, Lcom/bytedance/trae/im/database/ConversationDetailDao;
    invoke-direct v2, v0, Lcom/bytedance/trae/im/database/ConversationDetailDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;-><init>(Lcom/bytedance/trae/im/database/ConversationDetailDao;)V
    iput-object v1, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationDetailCacheRepository Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchMode Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v3
    iput-object v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchMode Lkotlinx/coroutines/flow/StateFlow;
    const-string v3, ""
    invoke-static v3, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    iput-object v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchQuery Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v3, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v4
    iput-object v4, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchQuery Lkotlinx/coroutines/flow/StateFlow;
    const/4 v4, 0
    invoke-static v4, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v5
    iput-object v5, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchResults Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v5, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    iput-object v6, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchResults Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v6
    invoke-static v6, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    iput-object v6, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v6, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v6
    iput-object v6, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchLoading Lkotlinx/coroutines/flow/StateFlow;
    sget-object v6, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    invoke-static v6, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v6
    iput-object v6, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_selectedFilter Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v6, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    iput-object v7, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->selectedFilter Lkotlinx/coroutines/flow/StateFlow;
    move-object v8, v0
    check-cast v8, Lkotlinx/coroutines/flow/Flow;
    move-object v9, v6
    check-cast v9, Lkotlinx/coroutines/flow/Flow;
    move-object v10, v2
    check-cast v10, Lkotlinx/coroutines/flow/Flow;
    move-object v11, v3
    check-cast v11, Lkotlinx/coroutines/flow/Flow;
    move-object v12, v5
    check-cast v12, Lkotlinx/coroutines/flow/Flow;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;
    invoke-direct v0, v14, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$tasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v13, v0
    check-cast v13, Lkotlin/jvm/functions/Function6;
    invoke-static/range v8 ... v13, Lkotlinx/coroutines/flow/FlowKt;->combine(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;
    move-result-object v0
    move-object v2, v14
    check-cast v2, Landroidx/lifecycle/ViewModel;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    sget-object v5, Lkotlinx/coroutines/flow/SharingStarted;->Companion Lkotlinx/coroutines/flow/SharingStarted$Companion;
    const-wide/16 v6, 5000
    const-wide/16 v8, 0
    const/4 v10, 2
    const/4 v11, 0
    invoke-static/range v5 ... v11, Lkotlinx/coroutines/flow/SharingStarted$Companion;->WhileSubscribed$default(Lkotlinx/coroutines/flow/SharingStarted$Companion; J J I Ljava/lang/Object;)Lkotlinx/coroutines/flow/SharingStarted;
    move-result-object v5
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    invoke-static v0, v3, v5, v6, Lkotlinx/coroutines/flow/FlowKt;->stateIn(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/flow/SharingStarted; Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->tasks Lkotlinx/coroutines/flow/StateFlow;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->devices Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadError Lkotlinx/coroutines/flow/StateFlow;
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isRefreshing Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isRefreshing Lkotlinx/coroutines/flow/StateFlow;
    const/4 v0, 7
    invoke-static v1, v1, v4, v0, v4, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_toastMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toastMessage Lkotlinx/coroutines/flow/SharedFlow;
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-static v0, Ljava/util/Collections;->newSetFromMap(Ljava/util/Map;)Ljava/util/Set;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingDeleteIds Ljava/util/Set;
    const-wide/16 v3, 30000
    iput-wide v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->refreshIntervalMs J
    const-wide/16 v3, 3000
    iput-wide v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->minLoadIntervalMs J
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
    invoke-static v2, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v6
    const-wide/16 v7, 0
    const/4 v9, 2
    const/4 v10, 0
    move-object v5, v0
    invoke-direct/range v5 ... v10, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;-><init>(Lkotlinx/coroutines/CoroutineScope; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchDebouncer Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
    const-wide/16 v2, 5000
    iput-wide v2, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingIntervalMs J
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v0, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_contentReady Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v0, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->contentReady Lkotlinx/coroutines/flow/StateFlow;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda2;
    invoke-direct v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    iput-object v0, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationChangeListener Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda3;
    invoke-direct v1, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    iput-object v1, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliStatusChangeListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    new-instance v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda4;
    invoke-direct v2, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    iput-object v2, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliUnbindListener Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda5;
    invoke-direct v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    iput-object v3, v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliRegisterListener Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;
    sget-object v4, Lcom/bytedance/trae/network/NetworkMonitor;->INSTANCE Lcom/bytedance/trae/network/NetworkMonitor;
    invoke-virtual v4, v15, Lcom/bytedance/trae/network/NetworkMonitor;->init(Landroid/content/Context;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v15, Lcom/bytedance/trae/im/service/IMService;->init()V
    sget-object v15, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v15, v0, Lcom/bytedance/trae/im/service/IMService;->addConversationChangeListener(Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v15, v1, Lcom/bytedance/trae/im/service/IMService;->addCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v15, v2, Lcom/bytedance/trae/im/service/IMService;->addCliUnbindListener(Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;)V
    sget-object v15, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    invoke-virtual v15, v3, Lcom/bytedance/trae/im/service/IMService;->addCliRegisterListener(Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;)V
    invoke-direct v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->observeCliCache()V
    invoke-direct v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadCachedTasks()V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadDevices()V
    invoke-direct v14, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->observeNetworkState()V
    return-void 
.end method

.method public static final synthetic access$applyDevices(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->applyDevices(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$applyPinSuccess(com.bytedance.trae.home.solo.task.TaskViewModel  java.lang.String  boolean  com.bytedance.trae.im.service.PinConversationResponse)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->applyPinSuccess(Ljava/lang/String; Z Lcom/bytedance/trae/im/service/PinConversationResponse;)V
    return-void 
.end method

.method public static final synthetic access$getConversationDao$p(com.bytedance.trae.home.solo.task.TaskViewModel)com.bytedance.trae.im.database.ConversationDao
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationDao Lcom/bytedance/trae/im/database/ConversationDao;
    return-object v0
.end method

.method public static final synthetic access$getConversationDetailCacheRepository$p(com.bytedance.trae.home.solo.task.TaskViewModel)com.bytedance.trae.im.repository.ConversationDetailCacheRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationDetailCacheRepository Lcom/bytedance/trae/im/repository/ConversationDetailCacheRepository;
    return-object v0
.end method

.method public static final synthetic access$getConversationMap$p(com.bytedance.trae.home.solo.task.TaskViewModel)java.util.Map
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    return-object v0
.end method

.method public static final synthetic access$getEnOtherYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enOtherYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getEnSameYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->enSameYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getJaOtherYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->jaOtherYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getJaSameYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->jaSameYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getParseDateFormats$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->parseDateFormats Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getPendingDeleteIds$p(com.bytedance.trae.home.solo.task.TaskViewModel)java.util.Set
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingDeleteIds Ljava/util/Set;
    return-object v0
.end method

.method public static final synthetic access$getPendingReload$p(com.bytedance.trae.home.solo.task.TaskViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingReload Z
    return v0
.end method

.method public static final synthetic access$getPollingIntervalMs$p(com.bytedance.trae.home.solo.task.TaskViewModel)long
    .registers 3
    # ins_size=1
    iget-wide v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingIntervalMs J
    return-wide v0
.end method

.method public static final synthetic access$getTimeOnlyFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->timeOnlyFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getZhOtherYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->zhOtherYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$getZhSameYearFormat$cp()java.lang.ThreadLocal
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->zhSameYearFormat Ljava/lang/ThreadLocal;
    return-object v0
.end method

.method public static final synthetic access$get_allTasks$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_contentReady$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_contentReady Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_isRefreshing$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isRefreshing Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_isSearchLoading$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_isSearchMode$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchMode Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_loadError$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_searchQuery$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchQuery Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_searchResults$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableStateFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchResults Lkotlinx/coroutines/flow/MutableStateFlow;
    return-object v0
.end method

.method public static final synthetic access$get_toastMessage$p(com.bytedance.trae.home.solo.task.TaskViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_toastMessage Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$isConversationDisplayable(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.Conversation)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isConversationDisplayable(Lcom/bytedance/trae/im/service/Conversation;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$isFirstLoadCompleted$p(com.bytedance.trae.home.solo.task.TaskViewModel)boolean
    .registers 1
    # ins_size=1
    iget-boolean v0, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isFirstLoadCompleted Z
    return v0
.end method

.method public static final synthetic access$persistConversations(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->persistConversations(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$pinFailureString(com.bytedance.trae.home.solo.task.TaskViewModel  boolean)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinFailureString(Z)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$pinSuccessString(com.bytedance.trae.home.solo.task.TaskViewModel  boolean)int
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pinSuccessString(Z)I
    move-result v0
    return v0
.end method

.method public static final synthetic access$replaceAllConversations(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->replaceAllConversations(Ljava/util/List;)V
    return-void 
.end method

.method public static final synthetic access$reportFirstLoadEvent(com.bytedance.trae.home.solo.task.TaskViewModel  int)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->reportFirstLoadEvent(I)V
    return-void 
.end method

.method public static final synthetic access$searchLocalTasks(com.bytedance.trae.home.solo.task.TaskViewModel  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchLocalTasks(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$setFirstLoadCompleted$p(com.bytedance.trae.home.solo.task.TaskViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isFirstLoadCompleted Z
    return-void 
.end method

.method public static final synthetic access$setLastLoadTime$p(com.bytedance.trae.home.solo.task.TaskViewModel  long)void
    .registers 3
    # ins_size=3
    iput-wide v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    return-void 
.end method

.method public static final synthetic access$setLoadingTasks$p(com.bytedance.trae.home.solo.task.TaskViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    return-void 
.end method

.method public static final synthetic access$setPendingReload$p(com.bytedance.trae.home.solo.task.TaskViewModel  boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingReload Z
    return-void 
.end method

.method public static final synthetic access$sortTasks(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$sortedForTaskList(com.bytedance.trae.home.solo.task.TaskViewModel  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortedForTaskList(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toTaskModel(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.Conversation)com.bytedance.trae.home.solo.task.TaskModel
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toTaskModel(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$toTaskModel(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.SearchConversationItem  java.lang.String  java.util.List)com.bytedance.trae.home.solo.task.TaskModel
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toTaskModel(Lcom/bytedance/trae/im/service/SearchConversationItem; Ljava/lang/String; Ljava/util/List;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v0
    return-object v0
.end method

.method private final applyDevices(java.util.List)void
    .registers 12
    # ins_size=2
    iget-object v0, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    check-cast v11, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +03ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v4
    const/4 v3, 0
    if-nez v4, +003h
    goto +25h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getName()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +1eh
    new-instance v9, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +004h
    const-string v3, "local"
    move-object v6, v3
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v7, "online"
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v7
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v8
    move-object v3, v9
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/home/solo/task/DeviceInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/String;)V
    if-eqz v3, -038h
    invoke-interface v1, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3dh
    check-cast v1, Ljava/util/List;
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->reconcileSelectedFilterWithDevices()V
    invoke-direct v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->rebuildTasksFromConversations()V
    sget-object v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "loadDevices: loaded "
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, " devices"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "TaskViewModel"
    invoke-virtual v11, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final applyPinSuccess(java.lang.String  boolean  com.bytedance.trae.im.service.PinConversationResponse)void
    .registers 66
    # ins_size=4
    move-object/from16 v0, v62
    move-object/from16 v1, v63
    if-eqz v65, +00dh
    invoke-virtual/range v65, Lcom/bytedance/trae/im/service/PinConversationResponse;->isPinned()Ljava/lang/Boolean;
    move-result-object v2
    if-eqz v2, +007h
    invoke-virtual v2, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    goto +3h
    move/from16 v2, v64
    const-string v28, ""
    const/4 v3, 0
    if-eqz v2, +012h
    if-eqz v65, +007h
    invoke-virtual/range v65, Lcom/bytedance/trae/im/service/PinConversationResponse;->getPinnedAt()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v3
    if-nez v4, +005h
    move-object/from16 v58, v28
    goto +6h
    move-object/from16 v58, v4
    goto +3h
    move-object/from16 v58, v3
    if-eqz v65, +007h
    invoke-virtual/range v65, Lcom/bytedance/trae/im/service/PinConversationResponse;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    goto +2h
    move-object v4, v3
    if-nez v4, +050h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v4, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    move-object/from16 v29, v4
    check-cast v29, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v29, +042h
    const/16 v30, 0
    const/16 v31, 0
    const/16 v32, 0
    const/16 v33, 0
    const/16 v34, 0
    const/16 v35, 0
    const/16 v36, 0
    const/16 v37, 0
    const/16 v38, 0
    const/16 v39, 0
    const/16 v40, 0
    const/16 v41, 0
    const/16 v42, 0
    const/16 v43, 0
    const/16 v44, 0
    const/16 v45, 0
    const/16 v46, 0
    const/16 v47, 0
    const/16 v48, 0
    const/16 v49, 0
    const/16 v50, 0
    const/16 v51, 0
    const/16 v52, 0
    const/16 v53, 0
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v54
    const v56, 16777215
    const/16 v57, 0
    move-object/from16 v55, v58
    invoke-static/range v29 ... v57, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    goto +3h
    move-object v15, v3
    goto +2h
    move-object v15, v4
    if-eqz v15, +006h
    invoke-virtual v15, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +015h
    if-eqz v15, +013h
    sget-object v3, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v3
    invoke-virtual v15, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v15, v3, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    if-eqz v15, +014h
    invoke-virtual v15, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +007h
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v4, v3, v15, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v15, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v3
    invoke-direct v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->persistConversations(Ljava/util/List;)V
    iget-object v14, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v14, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v3, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    move-object v13, v4
    check-cast v13, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v29
    invoke-interface/range v29, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +06bh
    invoke-interface/range v29, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +04dh
    if-eqz v15, +00ch
    invoke-direct v0, v15, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toTaskModel(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v3
    move-object v4, v13
    move-object/from16 v60, v14
    move-object/from16 v61, v15
    goto +45h
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v16, 0
    const/16 v30, 0
    if-nez v58, +005h
    move-object/from16 v31, v28
    goto +3h
    move-object/from16 v31, v58
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const v26, 4188159
    const/16 v27, 0
    move-object/from16 v59, v13
    move-object/from16 v13, v16
    move-object/from16 v60, v14
    move/from16 v14, v30
    move-object/from16 v61, v15
    move v15, v2
    move-object/from16 v16, v31
    invoke-static/range v3 ... v27, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v3
    move-object/from16 v4, v59
    goto +6h
    move-object/from16 v60, v14
    move-object/from16 v61, v15
    move-object v4, v13
    invoke-interface v4, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object v13, v4
    move-object/from16 v14, v60
    move-object/from16 v15, v61
    goto -6eh
    move-object v4, v13
    move-object/from16 v60, v14
    move-object/from16 v61, v15
    move-object v13, v4
    check-cast v13, Ljava/util/List;
    invoke-direct v0, v13, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    move-object/from16 v2, v60
    invoke-interface v2, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    move-object/from16 v4, v61
    if-eqz v4, +013h
    sget-object v1, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    new-instance v2, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;
    const-string/jumbo v3, update
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-direct v2, v3, v5, v4, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/Conversation;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/im/service/IMService;->notifyConversationChanged(Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;)V
    return-void 
.end method

.method private static final cliRegisterListener$lambda$7(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliRegisterPayload)void
    .registers 9
    # ins_size=2
    const-string v0, "payload"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliRegisterListener$1$1;
    const/4 v4, 0
    invoke-direct v0, v8, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliRegisterListener$1$1;-><init>(Lcom/bytedance/trae/im/service/IMService$CliRegisterPayload; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final cliStatusChangeListener$lambda$5(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliStatusChangePayload)void
    .registers 8
    # ins_size=2
    const-string v0, "payload"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cliStatusChange received: cliId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", available="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService$CliStatusChangePayload;->getAvailable()Z
    move-result v7
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v1, "TaskViewModel"
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v7, v6
    check-cast v7, Landroidx/lifecycle/ViewModel;
    invoke-static v7, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v7
    move-object v1, v7
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    const/4 v2, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliStatusChangeListener$1$1;
    const/4 v3, 0
    invoke-direct v7, v6, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliStatusChangeListener$1$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v7
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 2
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final cliUnbindListener$lambda$6(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$CliUnbindPayload)void
    .registers 8
    # ins_size=2
    const-string v0, "payload"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "cliUnbind received: cliId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/im/service/IMService$CliUnbindPayload;->getCliId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    const-string v1, "TaskViewModel"
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    move-object v7, v6
    check-cast v7, Landroidx/lifecycle/ViewModel;
    invoke-static v7, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    invoke-static Lkotlinx/coroutines/Dispatchers;->getMain()Lkotlinx/coroutines/MainCoroutineDispatcher;
    move-result-object v7
    move-object v1, v7
    check-cast v1, Lkotlin/coroutines/CoroutineContext;
    const/4 v2, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliUnbindListener$1$1;
    const/4 v3, 0
    invoke-direct v7, v6, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$cliUnbindListener$1$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v3, v7
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 2
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final compareTaskTime(java.lang.String  java.lang.String)int
    .registers 5
    # ins_size=3
    invoke-direct v2, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortableTimeKey(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    invoke-direct v2, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortableTimeKey(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v1
    if-eqz v0, +011h
    if-eqz v1, +00fh
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v3
    invoke-virtual v1, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    invoke-static v3, v4, v0, v1, Lkotlin/jvm/internal/Intrinsics;->compare(J J)I
    move-result v3
    goto +dh
    if-eqz v0, +004h
    const/4 v3, 1
    goto +9h
    if-eqz v1, +004h
    const/4 v3, -1
    goto +5h
    invoke-virtual v3, v4, Ljava/lang/String;->compareTo(Ljava/lang/String;)I
    move-result v3
    return v3
.end method

.method private static final conversationChangeListener$lambda$4(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.im.service.IMService$ConversationChangeEvent)void
    .registers 12
    # ins_size=2
    const-string v0, "event"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "onConversationChanged: changeType="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getChangeType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", conversationId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversationId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", isLoadingTasks="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-boolean v2, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "TaskViewModel"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getChangeType()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +1aeh
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, -1352294148
    const/4 v3, 1
    if-eq v1, v2, +150h
    const v2, -1335458389
    if-eq v1, v2, +0dbh
    const v2, -838846263
    if-eq v1, v2, +004h
    goto/16 +198h
    const-string/jumbo v1, update
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +18dh
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v11
    if-nez v11, +003h
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isConversationDisplayable(Lcom/bytedance/trae/im/service/Conversation;)Z
    move-result v1
    if-eqz v1, +0a9h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +013h
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v1, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v1, v0, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-direct v10, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->persistConversations(Ljava/util/List;)V
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toTaskModel(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v11
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/lang/Iterable;
    instance-of v2, v1, Ljava/util/Collection;
    const/4 v4, 0
    if-eqz v2, +00dh
    move-object v2, v1
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-eqz v2, +004h
    move v3, v4
    goto +1bh
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -014h
    if-eqz v3, +03ah
    iget-object v2, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v1, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, +003h
    move-object v4, v11
    invoke-interface v3, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v3, Ljava/util/List;
    invoke-direct v10, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks(Ljava/util/List;)Ljava/util/List;
    move-result-object v11
    invoke-interface v2, v11, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +10h
    iget-boolean v11, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    if-nez v11, +00dh
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    goto +8h
    iget-boolean v11, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    if-nez v11, +005h
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->startPollingIfNeeded()V
    goto/16 +0c6h
    const-string v1, "delete"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +004h
    goto/16 +0bch
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversationId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +029h
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingDeleteIds Ljava/util/Set;
    invoke-interface v1, v0, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v1, v0, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    move-object v1, v10
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Lkotlin/coroutines/CoroutineContext;
    const/4 v6, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$conversationChangeListener$1$3$1;
    const/4 v2, 0
    invoke-direct v1, v10, v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$conversationChangeListener$1$3$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v7, v1
    check-cast v7, Lkotlin/jvm/functions/Function2;
    const/4 v8, 2
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    iget-object v10, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v10, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v4, v2
    check-cast v4, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversationId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    xor-int/2addr v4, v3
    if-eqz v4, -01ah
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    check-cast v1, Ljava/util/List;
    invoke-interface v10, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    goto +55h
    const-string v1, "create"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4ch
    invoke-virtual v11, Lcom/bytedance/trae/im/service/IMService$ConversationChangeEvent;->getConversation()Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v11
    if-nez v11, +003h
    return-void 
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isConversationDisplayable(Lcom/bytedance/trae/im/service/Conversation;)Z
    move-result v1
    if-eqz v1, +039h
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getEnvironment()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v2
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +013h
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual v11, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v11, v1, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    iget-object v1, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v1, v0, v11, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    invoke-direct v10, v11, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->persistConversations(Ljava/util/List;)V
    iget-boolean v11, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    if-nez v11, +006h
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    goto +3h
    iput-boolean v3, v10, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingReload Z
    return-void 
.end method

.method private final extractLocation(java.lang.String  java.lang.String  java.lang.String  boolean)java.lang.String
    .registers 6
    # ins_size=5
    const-string v4, ""
    const/4 v0, 0
    if-eqz v5, +01ch
    if-eqz v2, +015h
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v2, v0
    if-eqz v2, +006h
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastPathComponent(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v4, v0
    return-object v4
    if-eqz v3, +019h
    move-object v2, v3
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +00ah
    invoke-direct v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastTwoPathComponents(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v4, v2
    return-object v4
.end method

.method private final formatTime(java.lang.String)java.lang.String
    .registers 15
    # ins_size=2
    move-object v0, v14
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +00bh
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    const-string v3, ""
    if-eqz v0, +003h
    return-object v3
    check-cast v14, Ljava/lang/CharSequence;
    invoke-static v14, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v14
    move-object v0, v14
    check-cast v0, Ljava/lang/CharSequence;
    move v4, v2
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-ge v4, v5, +011h
    invoke-interface v0, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-static v5, Ljava/lang/Character;->isDigit(C)Z
    move-result v5
    if-nez v5, +004h
    move v0, v2
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -14h
    move v0, v1
    const/4 v4, 0
    if-eqz v0, +02dh
    invoke-static v14, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v0
    if-eqz v0, +027h
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v5
    const-wide v7, 1000000000000
    cmp-long v5, v5, v7
    if-lez v5, +00ch
    new-instance v5, Ljava/util/Date;
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v6
    invoke-direct v5, v6, v7, Ljava/util/Date;-><init>(J)V
    goto +10h
    new-instance v5, Ljava/util/Date;
    invoke-virtual v0, Ljava/lang/Long;->longValue()J
    move-result-wide v6
    const/16 v0, 1000
    int-to-long v8, v0
    mul-long/2addr v6, v8
    invoke-direct v5, v6, v7, Ljava/util/Date;-><init>(J)V
    goto +2h
    move-object v5, v4
    if-nez v5, +03ah
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->Companion Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getParseDateFormats(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/util/List;
    move-result-object v0
    invoke-interface v0, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +02ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/text/SimpleDateFormat;
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v6, v13
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-virtual v5, v14, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v6, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +003h
    move-object v5, v4
    if-eqz v5, -02ch
    if-nez v5, +003h
    return-object v3
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v14
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v0
    move-object v4, v5
    check-cast v4, Ljava/util/Date;
    invoke-virtual v0, v4, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v4
    invoke-virtual v4, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v4
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v6
    const/16 v7, 11
    invoke-virtual v6, v7, v2, Ljava/util/Calendar;->set(I I)V
    const/16 v7, 12
    invoke-virtual v6, v7, v2, Ljava/util/Calendar;->set(I I)V
    const/16 v7, 13
    invoke-virtual v6, v7, v2, Ljava/util/Calendar;->set(I I)V
    const/16 v7, 14
    invoke-virtual v6, v7, v2, Ljava/util/Calendar;->set(I I)V
    invoke-static Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;
    move-result-object v2
    invoke-virtual v6, Ljava/util/Calendar;->getTimeInMillis()J
    move-result-wide v7
    invoke-virtual v2, v7, v8, Ljava/util/Calendar;->setTimeInMillis(J)V
    const/4 v7, 6
    const/4 v8, -1
    invoke-virtual v2, v7, v8, Ljava/util/Calendar;->add(I I)V
    sget-object v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->Companion Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getTimeOnlyFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v8
    move-object v9, v5
    check-cast v9, Ljava/util/Date;
    invoke-virtual v8, v9, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    move-object v9, v5
    check-cast v9, Ljava/util/Date;
    invoke-virtual v9, Ljava/util/Date;->getTime()J
    move-result-wide v9
    invoke-virtual v6, Ljava/util/Calendar;->getTimeInMillis()J
    move-result-wide v11
    cmp-long v6, v9, v11
    if-ltz v6, +004h
    goto/16 +0a7h
    move-object v6, v5
    check-cast v6, Ljava/util/Date;
    invoke-virtual v6, Ljava/util/Date;->getTime()J
    move-result-wide v9
    invoke-virtual v2, Ljava/util/Calendar;->getTimeInMillis()J
    move-result-wide v11
    cmp-long v2, v9, v11
    const-string v6, "ja"
    const-string/jumbo v9, zh
    if-ltz v2, +030h
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +006h
    const-string/jumbo v14, 昨天
    goto +dh
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +006h
    const-string/jumbo v14, 昨日
    goto +3h
    const-string v14, "Yesterday"
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v14, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    const/16 v0, 32
    invoke-virtual v14, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v14
    invoke-virtual v14, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v8
    goto +64h
    invoke-virtual v0, v1, Ljava/util/Calendar;->get(I)I
    move-result v0
    invoke-virtual v14, v1, Ljava/util/Calendar;->get(I)I
    move-result v14
    if-ne v0, v14, +02fh
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +00dh
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getZhSameYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    goto +49h
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +00dh
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getJaSameYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    goto +38h
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getEnSameYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    goto +2dh
    invoke-static v4, v9, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +00dh
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getZhOtherYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    goto +1ch
    invoke-static v4, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, +00dh
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getJaOtherYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    goto +bh
    invoke-static v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;->access$getEnOtherYearFormat(Lcom/bytedance/trae/home/solo/task/TaskViewModel$Companion;)Ljava/text/SimpleDateFormat;
    move-result-object v14
    check-cast v5, Ljava/util/Date;
    invoke-virtual v14, v5, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v3, v8
    return-object v3
    :try_start_0x16
    :try_start_0x81
    :try_start_0x90
    :try_start_0x116
.end method

.method private final isConversationDisplayable(com.bytedance.trae.im.service.Conversation)boolean
    .registers 5
    # ins_size=2
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 1
    invoke-static v0, v1, v2, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v0
    if-nez v0, +01ch
    sget-object v0, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    if-nez v4, +004h
    const-string v4, ""
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/trae/utils/StringKt;->isNotNullOrEmpty(Ljava/lang/String;)Z
    move-result v4
    if-eqz v4, +003h
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final lastPathComponent(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    const/4 v0, 0
    const-string v1, ".git"
    const/4 v2, 0
    const/4 v3, 2
    invoke-static v11, v1, v2, v3, v0, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    const/4 v0, 4
    invoke-static v11, v0, Lkotlin/text/StringsKt;->dropLast(Ljava/lang/String; I)Ljava/lang/String;
    move-result-object v11
    new-array v0, v3, [C
    fill-array-data v0, +000004ch
    invoke-static v11, v0, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v11
    move-object v4, v11
    check-cast v4, Ljava/lang/CharSequence;
    new-array v5, v3, [C
    fill-array-data v5, +0000046h
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Ljava/lang/String;
    if-nez v11, +004h
    const-string v11, ""
    return-object v11
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
.end method

.method private final lastTwoPathComponents(java.lang.String)java.lang.String
    .registers 11
    # ins_size=2
    const/4 v0, 2
    new-array v1, v0, [C
    fill-array-data v1, +000006bh
    invoke-static v10, v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/String; [C)Ljava/lang/String;
    move-result-object v10
    move-object v1, v10
    check-cast v1, Ljava/lang/CharSequence;
    new-array v2, v0, [C
    fill-array-data v2, +0000065h
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, -015h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v1, Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->size()I
    move-result v10
    if-lt v10, v0, +01bh
    invoke-static v1, v0, Lkotlin/collections/CollectionsKt;->takeLast(Ljava/util/List; I)Ljava/util/List;
    move-result-object v10
    move-object v0, v10
    check-cast v0, Ljava/lang/Iterable;
    const-string v10, "/"
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
    goto +bh
    invoke-static v1, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    if-nez v10, +004h
    const-string v10, ""
    return-object v10
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
    fill-array-data-payload b'/\x00\\\x00' | \x2f\x00\x5c\x00
.end method

.method private final loadCachedTasks()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadCachedTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeCliCache()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeCliCache$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final observeNetworkState()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeNetworkState$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$observeNetworkState$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final performPinAction(com.bytedance.trae.home.solo.task.TaskModel  boolean)void
    .registers 10
    # ins_size=3
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/TaskModel;->getSupportsPin()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v8
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;
    const/4 v4, 0
    invoke-direct v0, v9, v8, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$performPinAction$1;-><init>(Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final persistConversations(java.util.List)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$persistConversations$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final pinFailureString(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_pin_failed I
    goto +3h
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_unpin_failed I
    return v1
.end method

.method private final pinSuccessString(boolean)int
    .registers 2
    # ins_size=2
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_pin_success I
    goto +3h
    sget v1, Lcom/bytedance/trae/home/R$string;->solo_toast_unpin_success I
    return v1
.end method

.method private final rebuildTasksFromConversations()void
    .registers 32
    # ins_size=1
    move-object/from16 v0, v31
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v2, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v2
    invoke-interface v2, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +02ah
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/util/Map$Entry;
    invoke-interface v3, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getDisplayEnvironment()Ljava/lang/String;
    move-result-object v4
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, -020h
    invoke-virtual v3, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/bytedance/trae/im/service/Conversation;->setEnvironment(Ljava/lang/String;)V
    goto -2dh
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    invoke-interface v2, Ljava/util/List;->isEmpty()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    const/16 v5, 10
    invoke-static v2, v5, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v4, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +0feh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    move-object v6, v5
    check-cast v6, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v1, v5, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v23
    const-string v5, "remote"
    if-nez v23, +004h
    move-object v7, v5
    goto +3h
    move-object/from16 v7, v23
    const/4 v8, 1
    invoke-static v7, v5, v8, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v5
    xor-int/2addr v5, v8
    const/4 v9, 0
    if-eqz v5, +036h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v10, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +018h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, -019h
    goto +2h
    move-object v11, v9
    check-cast v11, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    if-eqz v11, +009h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->isOnline()Z
    move-result v10
    move/from16 v22, v10
    goto +3h
    move/from16 v22, v8
    if-eqz v5, +033h
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v10, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/Iterable;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +018h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    move-object v12, v11
    check-cast v12, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v12, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v12
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getCliId()Ljava/lang/String;
    move-result-object v13
    invoke-static v12, v13, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v12
    if-eqz v12, -019h
    goto +2h
    move-object v11, v9
    check-cast v11, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    if-eqz v11, +006h
    invoke-virtual v11, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getIdeVersion()Ljava/lang/String;
    move-result-object v9
    iget-object v10, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getId()Ljava/lang/String;
    move-result-object v11
    invoke-interface v10, v11, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/im/service/Conversation;
    if-eqz v10, +032h
    sget-object v11, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v11, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v11
    invoke-static v7, v11, v8, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v7
    if-eqz v7, +015h
    sget-object v7, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v10
    invoke-virtual v7, v8, v11, v10, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->formatIdeLocation(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    goto +16h
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getDisplayGitUri()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v10, Lcom/bytedance/trae/im/service/Conversation;->getDisplayRepoName()Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v7, v8, v10, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->extractLocation(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v7
    goto +5h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/TaskModel;->getLocation()Ljava/lang/String;
    move-result-object v7
    move-object v12, v7
    sget-object v7, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    invoke-virtual v7, v5, v9, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->isSupported(Z Ljava/lang/String;)Z
    move-result v20
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const v29, 4071391
    const/16 v30, 0
    move/from16 v21, v5
    invoke-static/range v6 ... v30, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v5
    invoke-interface v4, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -100h
    check-cast v4, Ljava/util/List;
    invoke-interface v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final reconcileSelectedFilterWithDevices()void
    .registers 7
    # ins_size=1
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_selectedFilter Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    const/4 v2, 0
    if-eqz v1, +005h
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    goto +2h
    move-object v0, v2
    if-nez v0, +003h
    return-void 
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +018h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getCliId()Ljava/lang/String;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -019h
    move-object v2, v3
    check-cast v2, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_selectedFilter Lkotlinx/coroutines/flow/MutableStateFlow;
    if-nez v2, +007h
    sget-object v0, Lcom/bytedance/trae/home/solo/task/FilterOption$All;->INSTANCE Lcom/bytedance/trae/home/solo/task/FilterOption$All;
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    goto +21h
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-nez v3, +012h
    new-instance v0, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v3, v2, Lcom/bytedance/trae/home/solo/task/FilterOption$Device;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    goto +3h
    check-cast v0, Lcom/bytedance/trae/home/solo/task/FilterOption;
    invoke-interface v1, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final replaceAllConversations(java.util.List)void
    .registers 9
    # ins_size=2
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$replaceAllConversations$1;
    const/4 v4, 0
    invoke-direct v0, v7, v8, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$replaceAllConversations$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final reportFirstLoadEvent(int)void
    .registers 5
    # ins_size=2
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    const-string v2, "did"
    invoke-virtual v0, v2, v1, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v1, task_count
    invoke-virtual v0, v1, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; I)Lorg/json/JSONObject;
    const-string/jumbo v4, timestamp
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v1
    invoke-virtual v0, v4, v1, v2, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v4, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string v1, "first_load_tasks_completed"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, reportFirstLoadEvent: 
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string v1, "TaskViewModel"
    invoke-virtual v4, v1, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final resetSearchResults()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchDebouncer Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->cancel()V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchResults Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method private final scheduleSearch(java.lang.String)void
    .registers 8
    # ins_size=2
    iget-object v0, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchDebouncer Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;
    iget-object v1, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchMode Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v2
    new-instance v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda0;
    invoke-direct v3, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda1;
    invoke-direct v4, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;
    const/4 v5, 0
    invoke-direct v1, v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$scheduleSearch$3;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    move-object v1, v7
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/home/solo/task/TaskSearchDebouncer;->submit(Ljava/lang/String; Z Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function0; Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method private static final scheduleSearch$lambda$10(com.bytedance.trae.home.solo.task.TaskViewModel)kotlin.Unit
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchLoading Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchResults Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v0, 0
    invoke-interface v2, v0, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v2
.end method

.method private static final scheduleSearch$lambda$9(com.bytedance.trae.home.solo.task.TaskViewModel)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->resetSearchResults()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final searchLocalTasks(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;
    iget v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->label I
    const/4 v3, 1
    if-eqz v2, +014h
    if-ne v2, v3, +00ah
    iget-object v7, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +2eh
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    iget-object v8, v6, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v8, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Ljava/util/List;
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v2
    check-cast v2, Lkotlin/coroutines/CoroutineContext;
    new-instance v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;
    const/4 v5, 0
    invoke-direct v4, v8, v7, v6, v5, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$2;-><init>(Ljava/util/List; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    iput-object v6, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$searchLocalTasks$1;->label I
    invoke-static v2, v4, v0, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v7, v6
    check-cast v8, Ljava/util/List;
    invoke-direct v7, v8, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortedForTaskList(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    return-object v7
.end method

.method private final sortTasks(java.util.List)java.util.List
    .registers 4
    # ins_size=2
    check-cast v3, Ljava/lang/Iterable;
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda6;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda6;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda7;
    invoke-direct v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$$ExternalSyntheticLambda7;-><init>(Lkotlin/jvm/functions/Function2;)V
    invoke-static v3, v1, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v3
    return-object v3
.end method

.method private static final sortTasks$lambda$29(com.bytedance.trae.home.solo.task.TaskViewModel  com.bytedance.trae.home.solo.task.TaskModel  com.bytedance.trae.home.solo.task.TaskModel)int
    .registers 6
    # ins_size=3
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +03bh
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    if-eqz v0, +035h
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->getPinnedAt()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getPinnedAt()Ljava/lang/String;
    move-result-object v2
    invoke-direct v3, v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->compareTaskTime(Ljava/lang/String; Ljava/lang/String;)I
    move-result v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    if-eqz v2, +003h
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2ch
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->compareTaskTime(Ljava/lang/String; Ljava/lang/String;)I
    move-result v1
    goto +1fh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v0
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v2
    if-eq v0, v2, +00ah
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->isPinned()Z
    move-result v3
    if-eqz v3, +010h
    const/4 v1, -1
    goto +dh
    invoke-virtual v5, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskModel;->getUpdatedAt()Ljava/lang/String;
    move-result-object v4
    invoke-direct v3, v5, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->compareTaskTime(Ljava/lang/String; Ljava/lang/String;)I
    move-result v1
    return v1
.end method

.method private static final sortTasks$lambda$30(kotlin.jvm.functions.Function2  java.lang.Object  java.lang.Object)int
    .registers 3
    # ins_size=3
    invoke-interface v0, v1, v2, Lkotlin/jvm/functions/Function2;->invoke(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    return v0
.end method

.method private final sortableTimeKey(java.lang.String)java.lang.Long
    .registers 8
    # ins_size=2
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v0
    goto +2h
    move v2, v1
    const/4 v3, 0
    if-eqz v2, +003h
    return-object v3
    invoke-static v7, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v7
    move-object v2, v7
    check-cast v2, Ljava/lang/CharSequence;
    move v4, v0
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-ge v4, v5, +010h
    invoke-interface v2, v4, Ljava/lang/CharSequence;->charAt(I)C
    move-result v5
    invoke-static v5, Ljava/lang/Character;->isDigit(C)Z
    move-result v5
    if-nez v5, +003h
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -13h
    move v0, v1
    if-eqz v0, +020h
    invoke-static v7, Lkotlin/text/StringsKt;->toLongOrNull(Ljava/lang/String;)Ljava/lang/Long;
    move-result-object v7
    if-eqz v7, +019h
    invoke-virtual v7, Ljava/lang/Long;->longValue()J
    move-result-wide v0
    const-wide v2, 1000000000000
    cmp-long v7, v0, v2
    if-lez v7, +003h
    goto +5h
    const/16 v7, 1000
    int-to-long v2, v7
    mul-long/2addr v0, v2
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    return-object v7
    return-object v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v7, Ljava/time/OffsetDateTime;->parse(Ljava/lang/CharSequence;)Ljava/time/OffsetDateTime;
    move-result-object v7
    invoke-virtual v7, Ljava/time/OffsetDateTime;->toInstant()Ljava/time/Instant;
    move-result-object v7
    invoke-virtual v7, Ljava/time/Instant;->toEpochMilli()J
    move-result-wide v0
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v7
    check-cast v3, Ljava/lang/Long;
    return-object v3
    :try_start_0x55
.end method

.method private final sortedForTaskList(java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->sortTasks(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    return-object v1
.end method

.method private final toTaskModel(com.bytedance.trae.im.service.Conversation)com.bytedance.trae.home.solo.task.TaskModel
    .registers 32
    # ins_size=2
    move-object/from16 v0, v30
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    const-string v4, ""
    if-eqz v1, +005h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->defaultTaskTitle Ljava/lang/String;
    goto +9h
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object v8, v4
    goto +2h
    move-object v8, v1
    move-object v1, v8
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->first(Ljava/lang/CharSequence;)C
    move-result v1
    invoke-static v1, Ljava/lang/Character;->toUpperCase(C)C
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v7
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->formatTime(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getStatus()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00dh
    invoke-static v1, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    goto +2h
    move v1, v2
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskStatus;->Companion Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;
    invoke-virtual v5, v1, Lcom/bytedance/trae/home/solo/task/TaskStatus$Companion;->fromStatusCode(I)Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getDisplayState()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-result-object v1
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->ERROR Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    if-ne v1, v5, +005h
    move/from16 v16, v3
    goto +3h
    move/from16 v16, v2
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    const-string v5, "code"
    invoke-static v1, v5, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, +006h
    const-string v1, "Code"
    move-object v10, v1
    goto +2bh
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v5, work
    invoke-static v1, v5, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, +005h
    const-string v1, "Work"
    goto -11h
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    if-eqz v1, +008h
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    move v2, v3
    if-nez v2, +00ah
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    goto -2ah
    move-object v10, v4
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string v2, "remote"
    if-nez v1, +003h
    move-object v1, v2
    invoke-static v1, v2, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    xor-int/2addr v2, v3
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v1, v5, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, +015h
    sget-object v1, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectAbsolutePath()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getOwnerProjectWorkSpaceStatus()Ljava/lang/String;
    move-result-object v6
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v11
    invoke-virtual v1, v5, v6, v11, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->formatIdeLocation(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    goto +11h
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getDisplayWorkspace()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getDisplayGitUri()Ljava/lang/String;
    move-result-object v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getDisplayRepoName()Ljava/lang/String;
    move-result-object v6
    invoke-direct v0, v1, v5, v6, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->extractLocation(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z)Ljava/lang/String;
    move-result-object v1
    move-object v11, v1
    const/4 v1, 0
    if-eqz v2, +036h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +018h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v13, v6
    check-cast v13, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v14
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    goto +2h
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    if-eqz v6, +009h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->isOnline()Z
    move-result v5
    move/from16 v21, v5
    goto +3h
    move/from16 v21, v3
    if-eqz v2, +033h
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_devices Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v5, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +018h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    move-object v13, v6
    check-cast v13, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getCliId()Ljava/lang/String;
    move-result-object v13
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v14
    invoke-static v13, v14, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    goto +2h
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/home/solo/task/DeviceInfo;
    if-eqz v6, +006h
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/task/DeviceInfo;->getIdeVersion()Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object v6, v4
    goto +2h
    move-object v6, v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object v13, v4
    goto +2h
    move-object v13, v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object v14, v4
    goto +2h
    move-object v14, v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getMode()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +004h
    move-object v15, v4
    goto +2h
    move-object v15, v5
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->isPinned()Ljava/lang/Boolean;
    move-result-object v5
    invoke-static v3, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v3
    invoke-static v5, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v17
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getPinnedAt()Ljava/lang/String;
    move-result-object v3
    if-nez v3, +005h
    move-object/from16 v18, v4
    goto +3h
    move-object/from16 v18, v3
    sget-object v3, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->INSTANCE Lcom/bytedance/trae/conversation/network/TaskPinCapability;
    invoke-virtual v3, v2, v1, Lcom/bytedance/trae/conversation/network/TaskPinCapability;->isSupported(Z Ljava/lang/String;)Z
    move-result v19
    sget-object v1, Lcom/bytedance/trae/home/solo/task/TaskIconType;->Companion Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getIconType()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/home/solo/task/TaskIconType$Companion;->fromString(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/task/TaskIconType;
    move-result-object v23
    sget-object v1, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v1
    invoke-virtual/range v31, Lcom/bytedance/trae/im/service/Conversation;->getCliId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v22
    new-instance v1, Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-object v5, v1
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/high16 v28, 3932160
    const/16 v29, 0
    move/from16 v20, v2
    invoke-direct/range v5 ... v29, Lcom/bytedance/trae/home/solo/task/TaskModel;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v1
.end method

.method private final toTaskModel(com.bytedance.trae.im.service.SearchConversationItem  java.lang.String  java.util.List)com.bytedance.trae.home.solo.task.TaskModel
    .registers 41
    # ins_size=4
    move-object/from16 v0, v37
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getConversationId()Ljava/lang/String;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +176h
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v1, v2
    if-nez v1, +004h
    goto/16 +165h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v3, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Lcom/bytedance/trae/im/service/Conversation;
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getConversationTitle()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +011h
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +003h
    goto +2h
    move-object v3, v2
    if-nez v3, +01bh
    if-eqz v4, +014h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getTitle()Ljava/lang/String;
    move-result-object v3
    if-eqz v3, +00eh
    move-object v5, v3
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +003h
    goto +2h
    move-object v3, v2
    if-nez v3, +004h
    iget-object v3, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->defaultTaskTitle Ljava/lang/String;
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getConversationUpdatedAt()Ljava/lang/String;
    move-result-object v5
    const-string v33, ""
    if-nez v5, +015h
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v2
    if-nez v5, +00bh
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getMessageCreatedAt()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +005h
    move-object/from16 v34, v33
    goto +3h
    move-object/from16 v34, v5
    move-object/from16 v5, v34
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    if-eqz v6, +00eh
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Conversation;->getUpdatedAt()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v2
    if-nez v5, +004h
    move-object/from16 v5, v33
    move-object/from16 v35, v5
    check-cast v35, Ljava/lang/String;
    if-eqz v4, +036h
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const v31, 67043263
    const/16 v32, 0
    move-object v11, v3
    move-object/from16 v21, v35
    invoke-static/range v4 ... v32, Lcom/bytedance/trae/im/service/Conversation;->copy$default(Lcom/bytedance/trae/im/service/Conversation; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/im/service/Conversation;
    move-result-object v4
    if-nez v4, +064h
    sget-object v4, Lcom/bytedance/trae/home/solo/task/TaskStatus;->FINISHED Lcom/bytedance/trae/home/solo/task/TaskStatus;
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getStatusCode()I
    move-result v4
    invoke-static v4, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v15
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getCliId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +009h
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    goto +fh
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v4
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getCliId()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/CliListRepository;->getCliTypeById(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    move-object/from16 v16, v4
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getCliId()Ljava/lang/String;
    move-result-object v10
    new-instance v36, Lcom/bytedance/trae/im/service/Conversation;
    move-object/from16 v4, v36
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v12, 0
    const/4 v13, 0
    const/4 v14, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v30, 0
    const v31, 67040158
    const/16 v32, 0
    move-object v5, v1
    move-object v11, v3
    move-object/from16 v21, v35
    invoke-direct/range v4 ... v32, Lcom/bytedance/trae/im/service/Conversation;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/ConversationSource; Ljava/lang/String; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iget-object v5, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v5, v1, v4, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v0, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toTaskModel(Lcom/bytedance/trae/im/service/Conversation;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getMessageCreatedAt()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    move-object/from16 v1, v34
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->formatTime(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getMessageContent()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +005h
    move-object/from16 v24, v33
    goto +3h
    move-object/from16 v24, v1
    invoke-virtual/range v38, Lcom/bytedance/trae/im/service/SearchConversationItem;->getMessageCreatedAtMs()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +010h
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    xor-int/lit8 v4, v4, 1
    if-eqz v4, +005h
    move-object/from16 v27, v1
    goto +3h
    move-object/from16 v27, v2
    const v28, 262075
    const/16 v29, 0
    move-object v8, v3
    move-object/from16 v25, v39
    move-object/from16 v26, v40
    invoke-static/range v5 ... v29, Lcom/bytedance/trae/home/solo/task/TaskModel;->copy$default(Lcom/bytedance/trae/home/solo/task/TaskModel; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskStatus; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z Ljava/lang/String; Z Z Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskIconType; Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/task/TaskModel;
    move-result-object v1
    return-object v1
    return-object v2
.end method

.method public final clearSearchQuery()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchQuery Lkotlinx/coroutines/flow/MutableStateFlow;
    const-string v1, ""
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->resetSearchResults()V
    return-void 
.end method

.method public final deleteConversation(java.lang.String)void
    .registers 9
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;
    const/4 v4, 0
    invoke-direct v0, v8, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$deleteConversation$1;-><init>(Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final enterSearchMode()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchMode Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final exitSearchMode()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchQuery Lkotlinx/coroutines/flow/MutableStateFlow;
    const-string v1, ""
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isSearchMode Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->resetSearchResults()V
    return-void 
.end method

.method public final extractIDELocation(java.lang.String  java.lang.String)java.lang.String
    .registers 5
    # ins_size=3
    const-string v0, "folderPath"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, workspaceType
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;
    const/4 v1, 0
    invoke-virtual v0, v3, v4, v1, Lcom/bytedance/trae/home/solo/task/TaskLocationFormatter;->formatIdeLocation(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method public final forceLoadTasks()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "TaskViewModel"
    const-string v2, "forceLoadTasks called"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    const-wide/16 v0, 0
    iput-wide v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    return-void 
.end method

.method public final getContentReady()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->contentReady Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getConversation(java.lang.String)com.bytedance.trae.im.service.Conversation
    .registers 3
    # ins_size=2
    const-string v0, "conversationId"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationMap Ljava/util/Map;
    invoke-interface v0, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/Conversation;
    return-object v2
.end method

.method public final getDevices()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->devices Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getLoadError()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadError Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getSearchQuery()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchQuery Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getSearchResults()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->searchResults Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getSelectedFilter()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->selectedFilter Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getTasks()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->tasks Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final getToastMessage()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->toastMessage Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final isRefreshing()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isRefreshing Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final isSearchLoading()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchLoading Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final isSearchMode()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isSearchMode Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final loadDevices()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadDevices$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadDevices$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadTasks()void
    .registers 8
    # ins_size=1
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-wide v2, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    sub-long v2, v0, v2
    iget-wide v4, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->minLoadIntervalMs J
    cmp-long v2, v2, v4
    const-string v3, "TaskViewModel"
    if-gez v2, +020h
    sget-object v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "loadTasks skipped: minLoadInterval not met, elapsed="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v5, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    sub-long/2addr v0, v5
    invoke-virtual v4, v0, v1, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, "ms"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v3, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iget-boolean v2, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    if-eqz v2, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "loadTasks skipped: already loading"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    iput-wide v0, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    const/4 v0, 1
    iput-boolean v0, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$loadTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasksJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final loadTasksOnResume()void
    .registers 5
    # ins_size=1
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    sub-long/2addr v0, v2
    iget-wide v2, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->refreshIntervalMs J
    cmp-long v0, v0, v2
    if-ltz v0, +005h
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasks()V
    return-void 
.end method

.method protected onCleared()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/lifecycle/AndroidViewModel;->onCleared()V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->stopPolling()V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->conversationChangeListener Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeConversationChangeListener(Lcom/bytedance/trae/im/service/IMService$ConversationChangeListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliStatusChangeListener Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeCliStatusChangeListener(Lcom/bytedance/trae/im/service/IMService$CliStatusChangeListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliUnbindListener Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeCliUnbindListener(Lcom/bytedance/trae/im/service/IMService$CliUnbindListener;)V
    sget-object v0, Lcom/bytedance/trae/im/service/IMService;->INSTANCE Lcom/bytedance/trae/im/service/IMService;
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->cliRegisterListener Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/IMService;->removeCliRegisterListener(Lcom/bytedance/trae/im/service/IMService$CliRegisterListener;)V
    return-void 
.end method

.method public final pinConversation(com.bytedance.trae.home.solo.task.TaskModel)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, task
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 1
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->performPinAction(Lcom/bytedance/trae/home/solo/task/TaskModel; Z)V
    return-void 
.end method

.method public final refreshTasks()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_isRefreshing Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 1
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v2
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadDevices()V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasksJob Lkotlinx/coroutines/Job;
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v2, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasksJob Lkotlinx/coroutines/Job;
    const/4 v0, 0
    iput-boolean v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->isLoadingTasks Z
    iput-boolean v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pendingReload Z
    const-wide/16 v0, 0
    iput-wide v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->lastLoadTime J
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;
    invoke-direct v0, v9, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$refreshTasks$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->loadTasksJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final renameConversation(java.lang.String  java.lang.String)void
    .registers 10
    # ins_size=3
    const-string v0, "conversationId"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newTitle"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;
    const/4 v4, 0
    invoke-direct v0, v8, v9, v7, v4, Lcom/bytedance/trae/home/solo/task/TaskViewModel$renameConversation$1;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final retry()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_loadError Lkotlinx/coroutines/flow/MutableStateFlow;
    const/4 v1, 0
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->forceLoadTasks()V
    return-void 
.end method

.method public final setFilter(com.bytedance.trae.home.solo.task.FilterOption)void
    .registers 3
    # ins_size=2
    const-string v0, "filter"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_selectedFilter Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public final startPollingIfNeeded()void
    .registers 10
    # ins_size=1
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 1
    const/4 v2, 0
    if-eqz v0, +005h
    invoke-static v0, v2, v1, v2, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iget-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_allTasks Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    instance-of v3, v0, Ljava/util/Collection;
    const/4 v4, 0
    if-eqz v3, +00dh
    move-object v3, v0
    check-cast v3, Ljava/util/Collection;
    invoke-interface v3, Ljava/util/Collection;->isEmpty()Z
    move-result v3
    if-eqz v3, +004h
    move v1, v4
    goto +22h
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, -00ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/home/solo/task/TaskModel;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskModel;->getStatus()Lcom/bytedance/trae/home/solo/task/TaskStatus;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskStatus;->getDisplayState()Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/home/solo/task/TaskDisplayState;->LOADING Lcom/bytedance/trae/home/solo/task/TaskDisplayState;
    if-ne v3, v5, +004h
    move v3, v1
    goto +2h
    move v3, v4
    if-eqz v3, -01bh
    if-nez v1, +003h
    return-void 
    move-object v0, v9
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;
    invoke-direct v0, v9, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel$startPollingIfNeeded$1;-><init>(Lcom/bytedance/trae/home/solo/task/TaskViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v9, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stopPolling()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final unpinConversation(com.bytedance.trae.home.solo.task.TaskModel)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, task
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->performPinAction(Lcom/bytedance/trae/home/solo/task/TaskModel; Z)V
    return-void 
.end method

.method public final updateSearchQuery(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "query"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->_searchQuery Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/task/TaskViewModel;->scheduleSearch(Ljava/lang/String;)V
    return-void 
.end method
