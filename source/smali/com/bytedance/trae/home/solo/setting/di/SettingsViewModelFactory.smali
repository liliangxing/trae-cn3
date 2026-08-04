# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;
.super Ljava/lang/Object;
.source "SettingsViewModelFactory.kt"

.implements Landroidx/lifecycle/ViewModelProvider$Factory;

.field public static final $stable:I
.field private final hostInfo:Lcom/bytedance/trae/kmp/host/KmpHostInfo;
.field private final settingsViewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;


.method public static synthetic $r8$lambda$LhoWLP0uVfWMLBVU96kCyt-o4Ew(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->create$lambda$0(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  com.bytedance.trae.kmp.host.KmpHostInfo)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, settingsViewModel
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "hostInfo"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    iput-object v3, v1, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel  com.bytedance.trae.kmp.host.KmpHostInfo  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +006h
    sget-object v2, Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;->INSTANCE Lcom/bytedance/trae/kmp/host/KmpHostEnvironment;
    check-cast v2, Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    return-void 
.end method

.method private static final create$lambda$0(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider)void
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->removeObserver()V
    return-void 
.end method

.method public create(java.lang.Class)androidx.lifecycle.ViewModel
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    const-string v1, "modelClass"
    move-object/from16 v2, v20
    invoke-static v2, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->INSTANCE Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;
    invoke-virtual v1, Lcom/bytedance/trae/kmp/network/AndroidKmpHttpClientFactory;->get()Lcom/bytedance/trae/kmp/network/KmpHttpClient;
    move-result-object v1
    new-instance v8, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-direct v8, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;-><init>(Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;)V
    invoke-virtual v8, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->observeForever()V
    new-instance v9, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v9
    move-object v3, v1
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultPayRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v10, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-object v2, v10
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultNotificationRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v11, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;
    iget-object v4, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-object v2, v11
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/solo/setting/data/DefaultSettingsCreditsRepository;-><init>(Lcom/bytedance/trae/kmp/network/KmpHttpClient; Lcom/bytedance/trae/kmp/host/KmpHostInfo; Lkotlinx/coroutines/CoroutineDispatcher; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v1, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;
    move-object v13, v8
    check-cast v13, Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;
    move-object v14, v9
    check-cast v14, Lcom/bytedance/trae/home/solo/setting/data/PayRepository;
    move-object v15, v10
    check-cast v15, Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository;
    move-object/from16 v16, v11
    check-cast v16, Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository;
    sget-object v2, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v2, Lcom/bytedance/trae/network/DebugSettings;->getPpeEnv()Ljava/lang/String;
    move-result-object v17
    iget-object v2, v0, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory;->hostInfo Lcom/bytedance/trae/kmp/host/KmpHostInfo;
    move-object v12, v1
    move-object/from16 v18, v2
    invoke-direct/range v12 ... v18, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;-><init>(Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider; Lcom/bytedance/trae/home/solo/setting/data/PayRepository; Lcom/bytedance/trae/home/solo/setting/data/NotificationRepository; Lcom/bytedance/trae/home/solo/setting/data/SettingsCreditsRepository; Ljava/lang/String; Lcom/bytedance/trae/kmp/host/KmpHostInfo;)V
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory$$ExternalSyntheticLambda0;
    invoke-direct v2, v8, Lcom/bytedance/trae/home/solo/setting/di/SettingsViewModelFactory$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;)V
    check-cast v2, Ljava/lang/AutoCloseable;
    invoke-virtual v1, v2, Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryViewModel;->addCloseable(Ljava/lang/AutoCloseable;)V
    check-cast v1, Landroidx/lifecycle/ViewModel;
    return-object v1
.end method
