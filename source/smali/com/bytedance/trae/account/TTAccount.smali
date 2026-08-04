# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/account/TTAccount;
.super Ljava/lang/Object;
.source "TTAccount.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/account/TTAccount;
.field private static final TAG:Ljava/lang/String;
.field private static final accountEventsListener:Lcom/bytedance/sdk/account/api/BDAccountEventListener;


.method public static synthetic $r8$lambda$ZaHnHkAkju8mPJaeO_3zwdiPXTA()android.util.Pair
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/account/TTAccount;->init$lambda$2()Landroid/util/Pair;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$dpl1FyUT8EydzXXvcOXHkESHucQ(int  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/account/TTAccount;->init$lambda$1(I Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$u5Cw0V5V10P-VdmBlda__5yJr0Y(com.bytedance.sdk.account.api.BDAccountEvent)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/account/TTAccount;->accountEventsListener$lambda$0(Lcom/bytedance/sdk/account/api/BDAccountEvent;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/account/TTAccount;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccount;-><init>()V
    sput-object v0, Lcom/bytedance/trae/account/TTAccount;->INSTANCE Lcom/bytedance/trae/account/TTAccount;
    new-instance v0, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda0;-><init>()V
    sput-object v0, Lcom/bytedance/trae/account/TTAccount;->accountEventsListener Lcom/bytedance/sdk/account/api/BDAccountEventListener;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/account/TTAccount;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final accountEventsListener$lambda$0(com.bytedance.sdk.account.api.BDAccountEvent)void
    .registers 4
    # ins_size=1
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v3, +008h
    iget v3, v3, Lcom/bytedance/sdk/account/api/BDAccountEvent;->type I
    const/4 v2, 2
    if-ne v3, v2, +003h
    move v1, v0
    if-eqz v1, +031h
    sget-object v3, Lcom/bytedance/trae/account/TTAccount;->INSTANCE Lcom/bytedance/trae/account/TTAccount;
    invoke-direct v3, Lcom/bytedance/trae/account/TTAccount;->isNetworkAvailable()Z
    move-result v3
    const-string v1, "TTAccount"
    if-nez v3, +00ah
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v0, "SESSION_EXPIRED event received but network unavailable, ignoring logout"
    invoke-virtual v3, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "SESSION_EXPIRED event received with network available, performing logout"
    invoke-virtual v3, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const-class v3, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v3
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v3, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v3, +008h
    const/4 v1, 0
    const-string v2, "logout_by_session_expired"
    invoke-interface v3, v0, v1, v2, Lcom/bytedance/trae/login/api/ILoginService;->logout(Z Lcom/bytedance/trae/login/api/IAccountCallback; Ljava/lang/String;)V
    return-void 
.end method

.method private static final init$lambda$1(int  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    packed-switch v0, +0000028h
    goto +24h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    goto +12h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +9h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->v(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    packed-switch-payload 2 3 4 5 6 7
.end method

.method private static final init$lambda$2()android.util.Pair
    .registers 5
    # ins_size=0
    invoke-static Lcom/bytedance/sdk/account/impl/BDAccountDelegateInner;->instance()Lcom/bytedance/sdk/account/api/IBDAccount;
    move-result-object v0
    new-instance v1, Landroid/util/Pair;
    invoke-interface v0, Lcom/bytedance/sdk/account/api/IBDAccount;->getOdinUserType()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, Lcom/bytedance/sdk/account/api/IBDAccount;->isLogin()Z
    move-result v3
    if-eqz v3, +007h
    invoke-interface v0, Lcom/bytedance/sdk/account/api/IBDAccount;->getUserId()J
    move-result-wide v3
    goto +3h
    const-wide/16 v3, 0
    invoke-static v3, v4, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-direct v1, v2, v0, Landroid/util/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v1
.end method

.method private final isNetworkAvailable()boolean
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    const-string v1, "connectivity"
    invoke-virtual v0, v1, Landroid/app/Application;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    instance-of v1, v0, Landroid/net/ConnectivityManager;
    if-eqz v1, +005h
    check-cast v0, Landroid/net/ConnectivityManager;
    goto +2h
    const/4 v0, 0
    const/4 v1, 0
    if-nez v0, +003h
    return v1
    invoke-virtual v0, Landroid/net/ConnectivityManager;->getActiveNetwork()Landroid/net/Network;
    move-result-object v2
    if-nez v2, +003h
    return v1
    invoke-virtual v0, v2, Landroid/net/ConnectivityManager;->getNetworkCapabilities(Landroid/net/Network;)Landroid/net/NetworkCapabilities;
    move-result-object v0
    if-nez v0, +003h
    return v1
    const/16 v1, 12
    invoke-virtual v0, v1, Landroid/net/NetworkCapabilities;->hasCapability(I)Z
    move-result v0
    return v0
.end method

.method public final init()void
    .registers 5
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/account/TTAccount$init$1;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccount$init$1;-><init>()V
    check-cast v0, Lcom/ss/android/IRequestTagHeaderProvider;
    invoke-static v0, Lcom/ss/android/account/TTAccountInit;->setRequestTagHeaderProvider(Lcom/ss/android/IRequestTagHeaderProvider;)V
    new-instance v0, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lcom/ss/android/account/TTAccountInit;->setLogger(Lcom/bytedance/sdk/account/utils/ILogger;)V
    new-instance v0, Lcom/bytedance/trae/account/TTAccountConfig;
    invoke-direct v0, Lcom/bytedance/trae/account/TTAccountConfig;-><init>()V
    check-cast v0, Lcom/ss/android/TTAccountConfig;
    invoke-static v0, Lcom/ss/android/account/TTAccountInit;->init(Lcom/ss/android/TTAccountConfig;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getAllHosts(Lcom/bytedance/trae/network/HostType;)Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getAllHosts(Lcom/bytedance/trae/network/HostType;)Ljava/util/Set;
    move-result-object v1
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, v1, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    new-instance v1, Lcom/ss/android/token/TTTokenConfig;
    invoke-direct v1, Lcom/ss/android/token/TTTokenConfig;-><init>()V
    const-wide/32 v2, 600000
    invoke-virtual v1, v2, v3, Lcom/ss/android/token/TTTokenConfig;->setUpdateInterval(J)Lcom/ss/android/token/TTTokenConfig;
    move-result-object v1
    check-cast v0, Ljava/util/Collection;
    invoke-virtual v1, v0, Lcom/ss/android/token/TTTokenConfig;->addHostList(Ljava/util/Collection;)Lcom/ss/android/token/TTTokenConfig;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/ss/android/token/TTTokenConfig;->setTokenSign(Z)Lcom/ss/android/token/TTTokenConfig;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-static v1, v0, Lcom/ss/android/token/TTTokenManager;->initialize(Landroid/content/Context; Lcom/ss/android/token/TTTokenConfig;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Lcom/bytedance/sdk/account/impl/BDAccountDelegateInner;->instance(Landroid/content/Context;)Lcom/bytedance/sdk/account/api/IBDAccount;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/account/TTAccount;->accountEventsListener Lcom/bytedance/sdk/account/api/BDAccountEventListener;
    invoke-interface v0, v1, Lcom/bytedance/sdk/account/api/IBDAccount;->addListener(Lcom/bytedance/sdk/account/api/BDAccountEventListener;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda2;
    invoke-direct v1, Lcom/bytedance/trae/account/TTAccount$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->setBDAccountCallbackProvider(Lkotlin/jvm/functions/Function0;)V
    sget-object v0, Lcom/bytedance/trae/account/AccountInitExt;->INSTANCE Lcom/bytedance/trae/account/AccountInitExt;
    invoke-virtual v0, Lcom/bytedance/trae/account/AccountInitExt;->setupAuthExpirationConfig()V
    return-void 
.end method
