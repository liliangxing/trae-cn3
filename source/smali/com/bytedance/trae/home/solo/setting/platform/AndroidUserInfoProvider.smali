# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;
.super Ljava/lang/Object;
.source "AndroidUserInfoProvider.kt"

.implements Lcom/bytedance/trae/home/solo/setting/platform/UserInfoProvider;

.field public static final $stable:I
.field private final _userInfo:Lkotlinx/coroutines/flow/MutableStateFlow;
.field private final observer:Landroidx/lifecycle/Observer;
.field private final settingsViewModel:Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
.field private final userInfo:Lkotlinx/coroutines/flow/StateFlow;


.method public static synthetic $r8$lambda$GZCML2yQyRsh_ZNx6ff-EoX6V2Y(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider  com.bytedance.trae.home.solo.setting.UserProfileState)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->observer$lambda$0(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider; Lcom/bytedance/trae/home/solo/setting/UserProfileState;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.home.solo.setting.SettingsViewModel)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, settingsViewModel
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v2, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v2
    invoke-virtual v2, Landroidx/lifecycle/LiveData;->getValue()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/home/solo/setting/UserProfileState;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->mapProfile(Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    move-result-object v2
    invoke-static v2, Lkotlinx/coroutines/flow/StateFlowKt;->MutableStateFlow(Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->_userInfo Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-static v2, Lkotlinx/coroutines/flow/FlowKt;->asStateFlow(Lkotlinx/coroutines/flow/MutableStateFlow;)Lkotlinx/coroutines/flow/StateFlow;
    move-result-object v2
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->userInfo Lkotlinx/coroutines/flow/StateFlow;
    new-instance v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider$$ExternalSyntheticLambda0;
    invoke-direct v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;)V
    iput-object v2, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->observer Landroidx/lifecycle/Observer;
    return-void 
.end method

.method private final mapProfile(com.bytedance.trae.home.solo.setting.UserProfileState)com.bytedance.trae.home.solo.setting.platform.UserInfo
    .registers 8
    # ins_size=2
    const/4 v0, 0
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getScreenName()Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    const-string v2, ""
    if-nez v1, +003h
    move-object v1, v2
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v4, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v4, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +00dh
    invoke-interface v3, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/bytedance/trae/login/api/AccountInfo;->getAccountType()Lcom/bytedance/trae/login/api/AccountType;
    move-result-object v3
    goto +2h
    move-object v3, v0
    sget-object v4, Lcom/bytedance/trae/login/api/AccountType;->TOB Lcom/bytedance/trae/login/api/AccountType;
    const/4 v5, 0
    if-ne v3, v4, +004h
    const/4 v3, 1
    goto +2h
    move v3, v5
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v4
    if-nez v4, +010h
    if-eqz v3, +003h
    goto +ch
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getPhoneNumber()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-nez v3, +00eh
    goto +bh
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getEmail()Ljava/lang/String;
    move-result-object v3
    goto +2h
    move-object v3, v0
    if-nez v3, +003h
    move-object v3, v2
    new-instance v4, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getAvatarUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v2, v0
    if-eqz v7, +006h
    invoke-virtual v7, Lcom/bytedance/trae/home/solo/setting/UserProfileState;->getProductType()I
    move-result v5
    invoke-direct v4, v1, v3, v2, v5, Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I)V
    return-object v4
.end method

.method private static final observer$lambda$0(com.bytedance.trae.home.solo.setting.platform.AndroidUserInfoProvider  com.bytedance.trae.home.solo.setting.UserProfileState)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->_userInfo Lkotlinx/coroutines/flow/MutableStateFlow;
    invoke-direct v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->mapProfile(Lcom/bytedance/trae/home/solo/setting/UserProfileState;)Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;
    move-result-object v1
    invoke-interface v0, v1, Lkotlinx/coroutines/flow/MutableStateFlow;->setValue(Ljava/lang/Object;)V
    return-void 
.end method

.method public getUserInfo()kotlinx.coroutines.flow.StateFlow
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->userInfo Lkotlinx/coroutines/flow/StateFlow;
    return-object v0
.end method

.method public final observeForever()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->observer Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, Landroidx/lifecycle/LiveData;->observeForever(Landroidx/lifecycle/Observer;)V
    return-void 
.end method

.method public refresh()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->loadUserInfo()V
    return-void 
.end method

.method public final removeObserver()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->settingsViewModel Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;
    invoke-virtual v0, Lcom/bytedance/trae/home/solo/setting/SettingsViewModel;->getUserProfile()Landroidx/lifecycle/LiveData;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/home/solo/setting/platform/AndroidUserInfoProvider;->observer Landroidx/lifecycle/Observer;
    invoke-virtual v0, v1, Landroidx/lifecycle/LiveData;->removeObserver(Landroidx/lifecycle/Observer;)V
    return-void 
.end method
