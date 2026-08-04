# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "DeviceManagementViewModel.kt"

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$Companion;
.field private static final POLLING_INTERVAL_MS:J
.field private final _effects:Lkotlinx/coroutines/flow/MutableSharedFlow;
.field private final effects:Lkotlinx/coroutines/flow/SharedFlow;
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private pollingJob:Lkotlinx/coroutines/Job;
.field private final repository:Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
.field private final state:Lkotlinx/coroutines/flow/StateFlow;
.field private final uiState:Lkotlinx/coroutines/flow/MutableStateFlow;


.method public static synthetic $r8$lambda$HyzFNGDyYVGYR62vRxP171ThCkA(com.bytedance.trae.kmp.network.KmpHttpClient  kotlinx.coroutines.CoroutineDispatcher  kotlinx.coroutines.CoroutineScope)com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->_init_$lambda$1(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lkotlinx/coroutines/CoroutineDispatcher; Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oK8U0UTIxcL5F0XWXWso72_hn64(com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository  kotlinx.coroutines.CoroutineScope)com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->_init_$lambda$0(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository; Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->Companion Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->$stable I
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, repository
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda1;
    invoke-direct v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;)V
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
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
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lkotlinx/coroutines/CoroutineDispatcher;)V
    invoke-direct v1, v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;-><init>(Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.kmp.network.KmpHttpClient  com.bytedance.trae.kmp.host.KmpHostInfo  kotlinx.coroutines.CoroutineDispatcher  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +006h
    invoke-static Lkotlinx/coroutines/Dispatchers;->getDefault()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v3
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher;)V
    return-void 
.end method

.method private constructor <init>(kotlin.jvm.functions.Function1  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    invoke-direct/range v18, Landroidx/lifecycle/ViewModel;-><init>()V
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-object v1, v0
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    move-object/from16 v3, v19
    invoke-interface v3, v2, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    iput-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->repository Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    new-instance v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 127
    const/4 v12, 0
    move-object v3, v13
    invoke-direct/range v3 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;-><init>(Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-static v13, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v3
    iput-object v3, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    move-object v4, v3
    check-cast v4, Lkotlinx/coroutines/flow/Flow;
    invoke-interface v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;->getDevices()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v5
    check-cast v5, Lkotlinx/coroutines/flow/Flow;
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;
    invoke-direct v6, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$state$1;-><init>(Lkotlin/coroutines/Continuation;)V
    check-cast v6, Lkotlin/jvm/functions/Function3;
    invoke-static v4, v5, v6, Lkotlinx/coroutines/flow/FlowKt;->combine(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;
    move-result-object v4
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    sget-object v5, Lkotlinx/coroutines/flow/SharingStarted;->Companion Lkotlinx/coroutines/flow/SharingStarted$Companion;
    invoke-virtual v5, Lkotlinx/coroutines/flow/SharingStarted$Companion;->getEagerly()Lkotlinx/coroutines/flow/SharingStarted;
    move-result-object v5
    invoke-interface v3, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v8, v3
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v9, 0
    const/4 v10, 0
    invoke-interface v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;->getDevices()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    invoke-interface v2, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Ljava/util/List;
    const/4 v13, 0
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 123
    const/16 v17, 0
    invoke-static/range v8 ... v17, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-static v4, v1, v5, v2, Lkotlinx/coroutines/flow/FlowKt;->stateIn(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/flow/SharingStarted; Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    const/4 v1, 0
    const/4 v2, 7
    invoke-static v1, v1, v7, v2, v7, Lkotlinx/coroutines/flow/SharedFlowKt;->MutableSharedFlow$default(I I Lkotlinx/coroutines/channels/BufferOverflow; I Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableSharedFlow;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->_effects Lkotlinx/coroutines/flow/MutableSharedFlow;
    invoke-static v1, Lkotlinx/coroutines/flow/FlowKt;->asSharedFlow(Lkotlinx/coroutines/flow/MutableSharedFlow;)Lkotlinx/coroutines/flow/SharedFlow;
    move-result-object v1
    iput-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->effects Lkotlinx/coroutines/flow/SharedFlow;
    invoke-direct/range v18, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->refresh()V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository  kotlinx.coroutines.CoroutineScope)com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    .registers 3
    # ins_size=2
    const-string v0, "it"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v1
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.kmp.network.KmpHttpClient  kotlinx.coroutines.CoroutineDispatcher  kotlinx.coroutines.CoroutineScope)com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    .registers 4
    # ins_size=3
    const-string/jumbo v0, scope
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;
    invoke-direct v0, v1, v3, v2, Lcom/bytedance/trae/home/solo/setting/data/DefaultDeviceManagementRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/CoroutineDispatcher;)V
    check-cast v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    return-object v0
.end method

.method public static final synthetic access$getRepository$p(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel)com.bytedance.trae.home.solo.setting.data.DeviceManagementRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->repository Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    return-object v0
.end method

.method public static final synthetic access$get_effects$p(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel)kotlinx.coroutines.flow.MutableSharedFlow
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->_effects Lkotlinx/coroutines/flow/MutableSharedFlow;
    return-object v0
.end method

.method public static final synthetic access$refreshDevices(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementViewModel  boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->refreshDevices(Z Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final copyGuideUrl()void
    .registers 9
    # ins_size=1
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->downloadUrl()Ljava/lang/String;
    move-result-object v0
    move-object v1, v8
    check-cast v1, Landroidx/lifecycle/ViewModel;
    invoke-static v1, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;
    const/4 v5, 0
    invoke-direct v1, v8, v0, v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$copyGuideUrl$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v5, v1
    check-cast v5, Lkotlin/jvm/functions/Function2;
    const/4 v6, 3
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final delete(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice)void
    .registers 14
    # ins_size=2
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 47
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -019h
    move-object v0, v12
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$delete$2;
    const/4 v4, 0
    invoke-direct v0, v12, v13, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$delete$2;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final refresh()void
    .registers 8
    # ins_size=1
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refresh$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refresh$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final refreshDevices(boolean  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=3
    move-object/from16 v0, v16
    move-object/from16 v1, v18
    instance-of v2, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;
    if-eqz v2, +012h
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;
    iget v3, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->label I
    const/high16 v4, -2147483648
    and-int/2addr v3, v4
    if-eqz v3, +008h
    iget v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->label I
    sub-int/2addr v1, v4
    iput v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->label I
    goto +6h
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/coroutines/Continuation;)V
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v3
    iget v4, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->label I
    const/4 v5, 1
    if-eqz v4, +014h
    if-ne v4, v5, +00ah
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->L$0 Ljava/lang/Object;
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +39h
    new-instance v1, Ljava/lang/IllegalStateException;
    const-string v2, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v1, v2, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v1
    invoke-static v1, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    if-eqz v17, +01fh
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v1, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v7, 1
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 126
    const/4 v15, 0
    invoke-static/range v6 ... v15, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v6
    invoke-interface v1, v4, v6, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, -019h
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->repository Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    iput-object v0, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->L$0 Ljava/lang/Object;
    iput v5, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$refreshDevices$1;->label I
    invoke-interface v1, v2, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;->refresh(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v1
    if-ne v1, v3, +003h
    return-object v3
    move-object v2, v0
    check-cast v1, Ljava/lang/Boolean;
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    iget-object v2, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v2, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v3
    move-object v6, v3
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v7, 0
    xor-int/lit8 v8, v1, 1
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 124
    const/4 v15, 0
    invoke-static/range v6 ... v15, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v4
    invoke-interface v2, v3, v4, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -01ah
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final rename(com.bytedance.trae.home.solo.setting.data.DeviceManagementDevice  java.lang.String)void
    .registers 16
    # ins_size=3
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v15
    move-object v0, v15
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->repository Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;
    invoke-interface v0, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementRepository;->getDevices()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v0
    invoke-interface v0, Lkotlinx/coroutines/flow/StateFlow;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v14, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getId()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -01ah
    goto +2h
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    if-nez v1, +003h
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;->getName()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v15, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +020h
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v14
    move-object v1, v14
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 79
    const/4 v10, 0
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v15
    invoke-interface v0, v14, v15, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v14
    if-eqz v14, -019h
    return-void 
    iget-object v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 79
    const/4 v12, 0
    invoke-static/range v3 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v3
    invoke-interface v0, v1, v3, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -019h
    move-object v0, v13
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;
    invoke-direct v0, v13, v14, v15, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$rename$3;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    move-object v6, v0
    check-cast v6, Lkotlin/jvm/functions/Function2;
    const/4 v7, 3
    const/4 v8, 0
    invoke-static/range v3 ... v8, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final displayUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isOversea()Z
    move-result v0
    if-eqz v0, +006h
    const-string/jumbo v0, trae.ai
    goto +4h
    const-string/jumbo v0, trae.cn
    return-object v0
.end method

.method public final downloadUrl()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isOversea()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "https://trae.ai"
    goto +3h
    const-string v0, "https://trae.cn"
    return-object v0
.end method

.method public final getEffects()kotlinx.coroutines.flow.SharedFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->effects Lkotlinx/coroutines/flow/SharedFlow;
    return-object v0
.end method

.method public final getState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final onAction(com.bytedance.trae.home.solo.setting.viewmodel.DeviceManagementAction)void
    .registers 14
    # ins_size=2
    const-string v0, "action"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$Refresh;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$Refresh;
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->refresh()V
    goto/16 +160h
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SelectGuideProduct;
    if-eqz v0, +027h
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    move-object v6, v13
    check-cast v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SelectGuideProduct;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SelectGuideProduct;->getProduct()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct;
    move-result-object v6
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 119
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -01fh
    goto/16 +137h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CopyGuideUrl;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CopyGuideUrl;
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->copyGuideUrl()V
    goto/16 +12ah
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    if-eqz v0, +038h
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;
    move-object v8, v13
    check-cast v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v9
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->getSource()Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource;
    move-result-object v10
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->getAnchorX()F
    move-result v11
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenMenu;->getAnchorY()F
    move-result v8
    invoke-direct v7, v9, v10, v11, v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuSource; F F)V
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 111
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -030h
    goto/16 +0f0h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseMenu;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseMenu;
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +021h
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 111
    const/4 v10, 0
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v1
    invoke-interface v0, v13, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    goto/16 +0c9h
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenRename;
    if-eqz v0, +02ch
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;
    move-object v9, v13
    check-cast v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenRename;
    invoke-virtual v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenRename;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v9
    invoke-direct v8, v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V
    const/4 v9, 0
    const/16 v10, 79
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -024h
    goto/16 +09bh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseRename;
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +021h
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 95
    const/4 v10, 0
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v1
    invoke-interface v0, v13, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    goto/16 +074h
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    if-eqz v0, +010h
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v0
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$SubmitRename;->getName()Ljava/lang/String;
    move-result-object v13
    invoke-direct v12, v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->rename(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice; Ljava/lang/String;)V
    goto +61h
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenDelete;
    if-eqz v0, +02bh
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;
    move-object v10, v13
    check-cast v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenDelete;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$OpenDelete;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v10
    invoke-direct v9, v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState;-><init>(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V
    const/16 v10, 47
    const/4 v11, 0
    invoke-static/range v2 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v2
    invoke-interface v0, v1, v2, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -024h
    goto +34h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$CloseDelete;
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +020h
    iget-object v0, v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->uiState Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v13
    move-object v1, v13
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 63
    const/4 v10, 0
    invoke-static/range v1 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;->copy$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState; Z Z Ljava/util/List; Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementProduct; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementMenuState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementRenameState; Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementDeleteState; I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementUiState;
    move-result-object v1
    invoke-interface v0, v13, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->compareAndSet(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, -019h
    goto +eh
    instance-of v0, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;
    if-eqz v0, +00ch
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;
    invoke-virtual v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementAction$ConfirmDelete;->getDevice()Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;
    move-result-object v13
    invoke-direct v12, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->delete(Lcom/bytedance/trae/home/solo/setting/data/DeviceManagementDevice;)V
    return-void 
    new-instance v13, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v13, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v13
.end method

.method public final startPolling$impl_mainlandRelease()void
    .registers 8
    # ins_size=1
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->stopPolling$impl_mainlandRelease()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel$startPolling$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    move-result-object v0
    iput-object v0, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method

.method public final stopPolling$impl_mainlandRelease()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->pollingJob Lkotlinx/coroutines/Job;
    const/4 v1, 0
    if-eqz v0, +006h
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lkotlinx/coroutines/Job$DefaultImpls;->cancel$default(Lkotlinx/coroutines/Job; Ljava/util/concurrent/CancellationException; I Ljava/lang/Object;)V
    iput-object v1, v3, Lcom/bytedance/trae/home/solo/setting/viewmodel/DeviceManagementViewModel;->pollingJob Lkotlinx/coroutines/Job;
    return-void 
.end method
