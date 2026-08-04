# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
.super Landroidx/lifecycle/ViewModel;
.source "SettingsEntryViewModel.kt"

.field public static final $stable:I
.field private static final CREDITS_LOADING_TEXT:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$Companion;
.field private static final SaaS_PRODUCT_TYPE_TEAM_GROUP:I
.field private static final SaaS_PRODUCT_TYPE_TEAM_GROUP_V2:I
.field private final creditsRepository:Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;
.field private final debugPpeEnv:Ljava/lang/String;
.field private hasResumed:Z
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final languageRefresh:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final notificationRepository:Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;
.field private final payRepository:Lcom/bytedance/trae/home/solo/setting/data/PayRepository;
.field private final state:Lkotlinx/coroutines/flow/StateFlow;
.field private final userInfoProvider:Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->Companion Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$Companion;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->$stable I
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.platform.UserInfoProvider  com.bytedance.trae.home.solo.setting.data.PayRepository  com.bytedance.trae.home.solo.setting.data.NotificationRepository  com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository  java.lang.String  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 13
    # ins_size=7
    const-string/jumbo v0, userInfoProvider
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "payRepository"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "notificationRepository"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "creditsRepository"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "debugPpeEnv"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, Landroidx/lifecycle/ViewModel;-><init>()V
    iput-object v7, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->userInfoProvider Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;
    iput-object v8, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->payRepository Lcom/bytedance/trae/home/solo/setting/data/PayRepository;
    iput-object v9, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->notificationRepository Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;
    iput-object v10, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->creditsRepository Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;
    iput-object v11, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->debugPpeEnv Ljava/lang/String;
    iput-object v12, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    const/4 v11, 0
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v11, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v11
    iput-object v11, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->languageRefresh Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v7, Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;->getUserInfo()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    move-object v0, v7
    check-cast v0, Lkotlinx/coroutines/flow/Flow;
    invoke-interface v8, Lcom/bytedance/trae/home/solo/setting/data/PayRepository;->getPayIdentity()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    move-object v1, v7
    check-cast v1, Lkotlinx/coroutines/flow/Flow;
    invoke-interface v9, Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;->getUnreadCount()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    move-object v2, v7
    check-cast v2, Lkotlinx/coroutines/flow/Flow;
    invoke-interface v10, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;->getCreditsState()Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    move-object v3, v7
    check-cast v3, Lkotlinx/coroutines/flow/Flow;
    move-object v4, v11
    check-cast v4, Lkotlinx/coroutines/flow/Flow;
    new-instance v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;
    const/4 v8, 0
    invoke-direct v7, v6, v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$state$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v5, v7
    check-cast v5, Lkotlin/jvm/functions/Function6;
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/flow/FlowKt;->combine(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/flow/Flow; Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;
    move-result-object v7
    move-object v9, v6
    check-cast v9, Landroidx/lifecycle/ViewModel;
    invoke-static v9, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v9
    sget-object v10, Lkotlinx/coroutines/flow/SharingStarted;->Companion Lkotlinx/coroutines/flow/SharingStarted$Companion;
    invoke-virtual v10, Lkotlinx/coroutines/flow/SharingStarted$Companion;->getEagerly()Lkotlinx/coroutines/flow/SharingStarted;
    move-result-object v10
    invoke-static v7, v9, v10, v8, Lkotlinx/coroutines/flow/FlowKt;->stateIn(Lkotlinx/coroutines/flow/Flow; Lkotlinx/coroutines/CoroutineScope; Lkotlinx/coroutines/flow/SharingStarted; Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v7
    iput-object v7, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    invoke-virtual v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->refresh()V
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.platform.UserInfoProvider  com.bytedance.trae.home.solo.setting.data.PayRepository  com.bytedance.trae.home.solo.setting.data.NotificationRepository  com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository  java.lang.String  com.bytedance.trae.kmp.host.KmpHostInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 16
    if-eqz v15, +004h
    const-string v12, ""
    move-object v5, v12
    and-int/lit8 v12, v14, 32
    if-eqz v12, +007h
    sget-object v12, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    move-object v13, v12
    check-cast v13, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-object v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;-><init>(Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider; Lcom/bytedance/trae/home/solo/setting/data/PayRepository; Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository; Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository; Ljava/lang/String; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-void 
.end method

.method public static final synthetic access$buildUiState(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel  com.bytedance.trae.home.solo.setting.platform.UserInfo  com.bytedance.trae.home.solo.setting.data.model.PayIdentity  int  com.bytedance.trae.home.solo.setting.data.SettingsCreditsState)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->buildUiState(Lcom/bytedance/trae/home/solo/setting/platform/UserInfo; Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity; I Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCreditsRepository$p(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel)com.bytedance.trae.home.solo.setting.data.SettingsCreditsRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->creditsRepository Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;
    return-object v0
.end method

.method public static final synthetic access$getNotificationRepository$p(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel)com.bytedance.trae.home.solo.setting.data.NotificationRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->notificationRepository Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;
    return-object v0
.end method

.method public static final synthetic access$getPayRepository$p(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel)com.bytedance.trae.home.solo.setting.data.PayRepository
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->payRepository Lcom/bytedance/trae/home/solo/setting/data/PayRepository;
    return-object v0
.end method

.method private final buildFooterState()com.bytedance.trae.home.solo.setting.viewmodel.SettingsFooterState
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v0, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v0
    if-eqz v0, +005h
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method private final buildGroups(boolean  com.bytedance.trae.home.solo.setting.data.SettingsCreditsState)java.util.List
    .registers 16
    # ins_size=3
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    if-nez v14, +048h
    move-object v1, v0
    check-cast v1, Ljava/util/Collection;
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v2
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Account Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 30
    const/4 v10, 0
    move-object v3, v13
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iget-object v3, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v3, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterprise()Z
    move-result v3
    if-nez v3, +013h
    sget-object v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Message Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 30
    const/4 v11, 0
    move-object v4, v13
    invoke-static/range v4 ... v11, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct v13, v15, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->toSettingsItem(Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v15
    if-eqz v15, +005h
    invoke-interface v2, v15, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v2, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v15
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-direct v2, v15, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    move-object v15, v0
    check-cast v15, Ljava/util/Collection;
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    const/4 v2, 2
    new-array v2, v2, [Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    sget-object v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Language Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    iget-object v3, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v3, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getLanguageCode()Ljava/lang/String;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/16 v9, 28
    const/4 v10, 0
    move-object v3, v13
    invoke-static/range v3 ... v10, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v3
    const/4 v4, 0
    aput-object v3, v2, v4
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Notification Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 30
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v3
    const/4 v4, 1
    aput-object v3, v2, v4
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v1
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->DeviceManagement Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    if-nez v14, +013h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Connectors Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 30
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v14
    invoke-interface v1, v14, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v1, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v14
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-direct v1, v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v14
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isIOS()Z
    move-result v1
    if-nez v1, +013h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->PrivacyPermission Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 30
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v1
    invoke-interface v14, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v14, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v14
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-direct v1, v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-static Lkotlin/collections/CollectionsKt;->createListBuilder()Ljava/util/List;
    move-result-object v14
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isIOS()Z
    move-result v1
    if-nez v1, +01bh
    iget-object v1, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isMainland()Z
    move-result v1
    if-eqz v1, +013h
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Update Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 30
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v1
    invoke-interface v14, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->About Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 30
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v1
    invoke-interface v14, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-static v14, Lkotlin/collections/CollectionsKt;->build(Ljava/util/List;)Ljava/util/List;
    move-result-object v14
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-direct v1, v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    iget-object v14, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v14, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isDebug()Z
    move-result v14
    if-eqz v14, +01dh
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Debug Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    iget-object v7, v13, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->debugPpeEnv Ljava/lang/String;
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 28
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-direct v14, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v14, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    new-instance v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    sget-object v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Logout Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const/4 v7, 0
    const/4 v8, 1
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 26
    const/4 v12, 0
    move-object v5, v13
    invoke-static/range v5 ... v12, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-direct v14, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;-><init>(Ljava/util/List;)V
    invoke-interface v15, v14, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    check-cast v0, Ljava/lang/Iterable;
    new-instance v14, Ljava/util/ArrayList;
    invoke-direct v14, Ljava/util/ArrayList;-><init>()V
    check-cast v14, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v15
    invoke-interface v15, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-interface v15, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;->getItems()Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    xor-int/2addr v1, v4
    if-eqz v1, -018h
    invoke-interface v14, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v14, Ljava/util/List;
    return-object v14
.end method

.method private final buildUiState(com.bytedance.trae.home.solo.setting.platform.UserInfo  com.bytedance.trae.home.solo.setting.data.model.PayIdentity  int  com.bytedance.trae.home.solo.setting.data.SettingsCreditsState)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryState
    .registers 20
    # ins_size=5
    move-object v0, v15
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isByteCloud()Z
    move-result v9
    iget-object v1, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v1, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->isEnterprise()Z
    move-result v1
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->getAccountText()Ljava/lang/String;
    move-result-object v4
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->getAvatarUrl()Ljava/lang/String;
    move-result-object v5
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;->Companion Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;
    iget-object v6, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-interface v6, Lcom/bytedance/trae/kmp/host/KmpHostInfo;->getThemeMode()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v2, v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode$Companion;->fromValue(Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;
    move-result-object v6
    const/4 v2, 0
    if-nez v9, +00ch
    if-eqz v1, +003h
    goto +8h
    if-eqz v17, +007h
    invoke-virtual/range v17, Lcom/bytedance/trae/home/solo/setting/data/model/PayIdentity;->getBadgeText()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v2
    if-eqz v1, +00ah
    invoke-virtual/range v16, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;->getProductType()I
    move-result v2
    invoke-direct v15, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->enterpriseBadge(I)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    move-result-object v2
    move-object v8, v2
    xor-int/lit8 v11, v9, 1
    move-object/from16 v2, v19
    invoke-direct v15, v9, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->buildGroups(Z Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState;)Ljava/util/List;
    move-result-object v10
    move/from16 v2, v18
    invoke-direct v15, v2, v9, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->formatUnreadBadge(I Z Z)Ljava/lang/String;
    move-result-object v12
    invoke-direct v15, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->buildFooterState()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;
    move-result-object v13
    sget-object v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->INSTANCE Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutStateFactory;->build(Lcom/bytedance/trae/kmp/host/KmpHostInfo;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;
    move-result-object v14
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;
    move-object v2, v1
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode; Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge; Z Ljava/util/List; Z Ljava/lang/String; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;)V
    return-object v1
.end method

.method private final enterpriseBadge(int)com.bytedance.trae.home.solo.setting.viewmodel.SettingsEnterpriseBadge
    .registers 3
    # ins_size=2
    const/16 v0, 220
    if-eq v2, v0, +009h
    const/16 v0, 221
    if-eq v2, v0, +005h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->Enterprise Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    goto +3h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;->Team Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;
    return-object v2
.end method

.method private final formatUnreadBadge(int  boolean  boolean)java.lang.String
    .registers 5
    # ins_size=4
    const/4 v0, 0
    if-nez v3, +013h
    if-eqz v4, +003h
    goto +fh
    if-gtz v2, +003h
    goto +ch
    const/16 v3, 99
    if-le v2, v3, +005h
    const-string v0, "99+"
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final item(com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean)com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem
    .registers 13
    # ins_size=6
    new-instance v6, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-object v0, v6
    move-object v1, v8
    move-object v2, v9
    move v3, v10
    move v4, v11
    move v5, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z)V
    return-object v6
.end method

.method static synthetic item$default(com.bytedance.trae.home.solo.setting.viewmodel.SettingsEntryViewModel  com.bytedance.trae.home.solo.setting.viewmodel.SettingsItemKey  java.lang.String  boolean  boolean  boolean  int  java.lang.Object)com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem
    .registers 14
    # ins_size=8
    and-int/lit8 v13, v12, 2
    if-eqz v13, +003h
    const/4 v8, 0
    move-object v2, v8
    and-int/lit8 v8, v12, 4
    if-eqz v8, +003h
    const/4 v9, 0
    move v3, v9
    and-int/lit8 v8, v12, 8
    const/4 v9, 1
    if-eqz v8, +004h
    move v4, v9
    goto +2h
    move v4, v10
    and-int/lit8 v8, v12, 16
    if-eqz v8, +004h
    move v5, v9
    goto +2h
    move v5, v11
    move-object v0, v6
    move-object v1, v7
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v6
    return-object v6
.end method

.method private final toSettingsItem(com.bytedance.trae.home.solo.setting.data.SettingsCreditsState)com.bytedance.trae.home.solo.setting.viewmodel.SettingsItem
    .registers 11
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Hidden;
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v10, 0
    goto +2eh
    sget-object v0, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;->INSTANCE Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Loading;
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +011h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Points Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    const-string v3, "--"
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v1, v9
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v10
    goto +17h
    instance-of v0, v10, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    if-eqz v0, +015h
    sget-object v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;->Points Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey;
    check-cast v10, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;
    invoke-virtual v10, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsState$Visible;->getBalanceText()Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 4
    const/4 v8, 0
    move-object v1, v9
    invoke-static/range v1 ... v8, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->item$default(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItemKey; Ljava/lang/String; Z Z Z I Ljava/lang/Object;)Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsItem;
    move-result-object v10
    return-object v10
    new-instance v10, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v10, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v10
.end method

.method public final getState()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->state Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final onResume()void
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hasResumed Z
    if-nez v0, +006h
    const/4 v0, 1
    iput-boolean v0, v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->hasResumed Z
    return-void 
    invoke-virtual v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->refresh()V
    return-void 
.end method

.method public final refresh()void
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->languageRefresh Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-interface v0, Lkotlinx/coroutines/flow/MutableStateFlow;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    add-int/lit8 v1, v1, 1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    iget-object v0, v7, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->userInfoProvider Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;
    invoke-interface v0, Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;->refresh()V
    move-object v0, v7
    check-cast v0, Landroidx/lifecycle/ViewModel;
    invoke-static v0, Landroidx/lifecycle/ViewModelKt;->getViewModelScope(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 0
    new-instance v0, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;
    const/4 v4, 0
    invoke-direct v0, v7, v4, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel$refresh$1;-><init>(Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel; Lkotlin/coroutines/Continuation;)V
    move-object v4, v0
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 3
    const/4 v6, 0
    invoke-static/range v1 ... v6, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method
