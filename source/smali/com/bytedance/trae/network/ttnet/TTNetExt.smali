# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/ttnet/TTNetExt;
.super Ljava/lang/Object;
.source "TTNetExt.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/ttnet/TTNetExt;
.field private static final TAG:Ljava/lang/String;
.field private static configServersArray:[Ljava/lang/String;
.field private static final connectionTypeListeners:Ljava/util/List;
.field private static enableAntiSniffing:Z
.field private static final enableBootNetOpt$delegate:Lkotlin/Lazy;
.field private static networkInfo:Lcom/bytedance/trae/network/ttnet/NetInfo;
.field private static serviceDomainMap:Ljava/util/Map;


.method public static synthetic $r8$lambda$Ko9HYPxXHvPiCuJ7oqDZtbRV0HM(java.lang.String  java.lang.String[])java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->init$lambda$3$lambda$1(Ljava/lang/String; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$arX6zJlPhynmVw26CovbJzGZr9g(com.bytedance.trae.network.ttnet.TTNetExt)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->init$lambda$3$lambda$2(Lcom/bytedance/trae/network/ttnet/TTNetExt;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$jhiegted1fyOREr7704mxDrsB50()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/ttnet/TTNetExt;->init$lambda$6()V
    return-void 
.end method

.method public static synthetic $r8$lambda$z6tO8skgafr1_K3gZDoZ6ae_THw()boolean
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableBootNetOpt_delegate$lambda$0()Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    const-string v0, "TTNetExt"
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->TAG Ljava/lang/String;
    const/4 v0, 0
    new-array v0, v0, [Ljava/lang/String;
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->configServersArray [Ljava/lang/String;
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->serviceDomainMap Ljava/util/Map;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->connectionTypeListeners Ljava/util/List;
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableAntiSniffing Z
    new-instance v0, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda3;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda3;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableBootNetOpt$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final enableBootNetOpt_delegate$lambda$0()boolean
    .registers 1
    # ins_size=0
    const/4 v0, 0
    return v0
.end method

.method private final getEnableBootNetOpt()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableBootNetOpt$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method private static final init$lambda$3$lambda$1(java.lang.String  java.lang.String[])java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v1, v0, Lcom/bytedance/android/jsonopt/JsonOptUtil;->optJSONData([Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final init$lambda$3$lambda$2(com.bytedance.trae.network.ttnet.TTNetExt)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->initZstd()V
    return-void 
.end method

.method private static final init$lambda$6()void
    .registers 4
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->INSTANCE Lcom/bytedance/trae/network/util/NetworkControlUtils;
    invoke-virtual v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->getEnableBootNqeOpt()I
    move-result v0
    if-lez v0, +003h
    return-void 
    sget-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->INSTANCE Lcom/bytedance/trae/network/util/NetworkControlUtils;
    sget-object v1, Lcom/bytedance/trae/network/util/NetworkControlUtils;->INSTANCE Lcom/bytedance/trae/network/util/NetworkControlUtils;
    invoke-virtual v1, Lcom/bytedance/trae/network/util/NetworkControlUtils;->getEnableBootPathOpt()Ljava/util/HashMap;
    move-result-object v1
    const v2, 60000
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const-string v3, "boot"
    invoke-virtual v0, v3, v1, v2, Lcom/bytedance/trae/network/util/NetworkControlUtils;->startSpeedStrategy(Ljava/lang/String; Ljava/util/HashMap; Ljava/lang/Integer;)V
    return-void 
.end method

.method private final initZstd()void
    .registers 21
    # ins_size=1
    const-string v0, "ZSTD_createDCtx"
    const-string v1, "ZSTD_decompressStream"
    const-string v2, "ZSTD_freeDCtx"
    const-string v3, "ZSTD_isError"
    const-string v4, "ZSTD_createDDict"
    const-string v5, "ZSTD_DCtx_refDDict"
    const-string v6, "ZSTD_freeDDict"
    const-string v7, "ZSTD_DCtx_reset"
    filled-new-array/range v0 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/compression/zstd/Zstd;->getFunAddressesBySymbols([Ljava/lang/String;)[J
    move-result-object v0
    if-eqz v0, +04dh
    array-length v1, v0
    const/16 v2, 8
    if-ne v1, v2, +048h
    const/4 v1, 0
    aget-wide v2, v0, v1
    const-wide/16 v4, 0
    cmp-long v1, v2, v4
    if-eqz v1, +03fh
    const/4 v1, 1
    aget-wide v6, v0, v1
    cmp-long v1, v6, v4
    if-eqz v1, +038h
    const/4 v1, 2
    aget-wide v8, v0, v1
    cmp-long v1, v8, v4
    if-eqz v1, +031h
    const/4 v1, 3
    aget-wide v10, v0, v1
    cmp-long v1, v10, v4
    if-eqz v1, +02ah
    const/4 v1, 4
    aget-wide v12, v0, v1
    cmp-long v1, v12, v4
    if-eqz v1, +023h
    const/4 v1, 5
    aget-wide v14, v0, v1
    cmp-long v1, v14, v4
    if-eqz v1, +01ch
    const/4 v1, 6
    aget-wide v16, v0, v1
    cmp-long v1, v16, v4
    if-eqz v1, +015h
    const/4 v1, 7
    aget-wide v18, v0, v1
    cmp-long v0, v18, v4
    if-eqz v0, +00eh
    move-wide v4, v6
    move-wide v6, v8
    move-wide v8, v10
    move-wide v10, v12
    move-wide v12, v14
    move-wide/from16 v14, v16
    move-wide/from16 v16, v18
    invoke-static/range v2 ... v17, Lcom/bytedance/ttnet/TTNetInit;->setZstdFuncAddr(J J J J J J J J)V
    new-instance v0, Lcom/bytedance/trae/network/ttnet/TTNetExt$initZstd$1;
    invoke-direct v0, Lcom/bytedance/trae/network/ttnet/TTNetExt$initZstd$1;-><init>()V
    check-cast v0, Lcom/bytedance/retrofit2/mime/TTRequestCompressManager$AddZstdCompressCallback;
    invoke-static v0, Lcom/bytedance/retrofit2/mime/TTRequestCompressManager;->setAddZstdCompressCallback(Lcom/bytedance/retrofit2/mime/TTRequestCompressManager$AddZstdCompressCallback;)V
    return-void 
    :try_start_0x62
.end method

.method public final getConfigServersArray()java.lang.String[]
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->configServersArray [Ljava/lang/String;
    return-object v0
.end method

.method public final getConnectionTypeListeners()java.util.List
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->connectionTypeListeners Ljava/util/List;
    return-object v0
.end method

.method public final getEnableAntiSniffing()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableAntiSniffing Z
    return v0
.end method

.method public final getServiceDomainMap()java.util.Map
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->serviceDomainMap Ljava/util/Map;
    return-object v0
.end method

.method public final getUserEsimNetworkInfo()com.bytedance.trae.network.ttnet.NetInfo
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->networkInfo Lcom/bytedance/trae/network/ttnet/NetInfo;
    return-object v0
.end method

.method public final init(java.lang.String[]  java.util.Map  boolean)void
    .registers 11
    # ins_size=4
    const-string v0, "configServersArray"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, serviceDomainMap
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v8, Lcom/bytedance/trae/network/ttnet/TTNetExt;->configServersArray [Ljava/lang/String;
    sput-object v9, Lcom/bytedance/trae/network/ttnet/TTNetExt;->serviceDomainMap Ljava/util/Map;
    sput-boolean v10, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableAntiSniffing Z
    const/4 v8, 1
    sget-object v9, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v9, v7
    check-cast v9, Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-static Lorg/chromium/CronetDependManager;->inst()Lorg/chromium/CronetDependManager;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    check-cast v10, Lcom/bytedance/frameworks/baselib/network/http/cronet/ICronetDepend;
    invoke-virtual v9, v10, Lorg/chromium/CronetDependManager;->setAdapter(Lcom/bytedance/frameworks/baselib/network/http/cronet/ICronetDepend;)V
    invoke-static Lorg/chromium/CronetAppProviderManager;->inst()Lorg/chromium/CronetAppProviderManager;
    move-result-object v9
    sget-object v10, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    invoke-virtual v9, v10, Lorg/chromium/CronetAppProviderManager;->setAdapter(Ljava/lang/Object;)V
    sget-object v9, Lcom/bytedance/trae/network/ttnet/TTNetDependency;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetDependency;
    check-cast v9, Lcom/bytedance/ttnet/ITTNetDepend;
    invoke-static v9, Lcom/bytedance/ttnet/TTNetInit;->setTTNetDepend(Lcom/bytedance/ttnet/ITTNetDepend;)V
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v9
    if-nez v9, +005h
    invoke-static v8, Lcom/bytedance/frameworks/baselib/network/http/storeregion/StoreRegionManager;->useDomesticStoreRegion(Z)V
    sget-object v9, Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;->INSTANCE Lcom/bytedance/trae/network/ttnet/CronetDependAdapter;
    check-cast v9, Lcom/bytedance/frameworks/baselib/network/http/cronet/ICronetAppProvider;
    invoke-static v9, Lcom/bytedance/ttnet/TTNetInit;->setCronetDepend(Lcom/bytedance/frameworks/baselib/network/http/cronet/ICronetAppProvider;)V
    invoke-static v8, Lcom/bytedance/ttnet/TTNetInit;->setBypassOfflineCheck(Z)V
    invoke-static v8, Lcom/bytedance/ttnet/TTNetInit;->setStateDelayNewStrategyEnabled(Z)V
    invoke-direct v7, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getEnableBootNetOpt()Z
    move-result v9
    if-eqz v9, +013h
    invoke-static v8, Lcom/bytedance/ttnet/config/JsonOptConfig;->enableJsonOpt(Z)V
    invoke-static v8, Lcom/bytedance/ttnet/config/JsonOptConfig;->enableTNCJsonOpt(Z)V
    new-instance v9, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda0;
    invoke-direct v9, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v9, Lcom/bytedance/ttnet/config/JsonOptConfig;->setJsonHandler(Lcom/bytedance/ttnet/config/JsonOptConfig$IJsonHandler;)V
    invoke-static v8, Lcom/bytedance/retrofit2/OptConfig;->setEnableRequestOpt(Z)V
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v9
    move-object v0, v9
    check-cast v0, Landroid/content/Context;
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    sget-object v9, Lcom/bytedance/trae/network/ttnet/ApiProcessHook;->INSTANCE Lcom/bytedance/trae/network/ttnet/ApiProcessHook;
    move-object v2, v9
    check-cast v2, Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;
    sget-object v9, Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;->INSTANCE Lcom/bytedance/trae/network/ttnet/MonitorProcessHook;
    move-object v3, v9
    check-cast v3, Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;
    new-instance v9, Lcom/bytedance/trae/network/ttnet/TTNetExt$init$1$2;
    invoke-direct v9, Lcom/bytedance/trae/network/ttnet/TTNetExt$init$1$2;-><init>()V
    move-object v4, v9
    check-cast v4, Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$CommandListener;
    const/4 v5, 1
    new-array v6, v8, [Z
    const/4 v9, 0
    aput-boolean v8, v6, v9
    invoke-static/range v0 ... v6, Lcom/bytedance/ttnet/TTNetInit;->tryInitTTNet(Landroid/content/Context; Landroid/app/Application; Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook; Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook; Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$CommandListener; Z [Z)V
    invoke-static Lcom/bytedance/ttnet/TTNetInit;->preInitCronetKernel()V
    new-instance v9, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda1;
    invoke-direct v9, v7, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/network/ttnet/TTNetExt;)V
    invoke-static v9, Lcom/bytedance/common/utility/concurrent/ThreadPlus;->submitRunnable(Ljava/lang/Runnable;)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    goto +ch
    move-exception v9
    sget-object v10, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v9, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    new-instance v9, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/IntranetTimeoutInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/trae/network/interceptor/HttpEnvInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/HttpEnvInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/trae/network/interceptor/AccountInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/AccountInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/TTNetEncryptHeaderInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/trae/network/interceptor/MinorModeInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/MinorModeInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;
    invoke-direct v9, Lcom/bytedance/trae/network/interceptor/MaxLengthMonitorInterceptor;-><init>()V
    check-cast v9, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    sget-object v9, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v9
    if-nez v9, +01bh
    const-class v9, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v9
    const-class v10, Lcom/bytedance/trae/common/security/api/SecurityService;
    invoke-virtual v9, v10, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/common/security/api/SecurityService;
    if-eqz v9, +00bh
    invoke-interface v9, Lcom/bytedance/trae/common/security/api/SecurityService;->createBdInterceptor()Lcom/bytedance/retrofit2/intercept/Interceptor;
    move-result-object v9
    if-eqz v9, +005h
    invoke-static v9, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    new-instance v9, Lcom/bytedance/article/common/network/SSNetworkClient;
    invoke-direct v9, Lcom/bytedance/article/common/network/SSNetworkClient;-><init>()V
    check-cast v9, Lcom/bytedance/common/utility/NetworkClient;
    invoke-static v9, Lcom/bytedance/common/utility/NetworkClient;->setDefault(Lcom/bytedance/common/utility/NetworkClient;)V
    invoke-static v8, Lcom/ttnet/org/chromium/net/urlconnection/MessageLoop;->disableVaildThreadAssert(Z)V
    new-instance v8, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda2;
    invoke-direct v8, Lcom/bytedance/trae/network/ttnet/TTNetExt$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v8, Lcom/bytedance/common/utility/concurrent/ThreadPlus;->submitRunnable(Ljava/lang/Runnable;)V
    return-void 
    :try_start_0x12
.end method

.method public final setConfigServersArray(java.lang.String[])void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/network/ttnet/TTNetExt;->configServersArray [Ljava/lang/String;
    return-void 
.end method

.method public final setEnableAntiSniffing(boolean)void
    .registers 2
    # ins_size=2
    sput-boolean v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->enableAntiSniffing Z
    return-void 
.end method

.method public final setServiceDomainMap(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/network/ttnet/TTNetExt;->serviceDomainMap Ljava/util/Map;
    return-void 
.end method

.method public final setUserRegionInfo(com.bytedance.trae.network.ttnet.NetInfo)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/network/ttnet/TTNetExt;->networkInfo Lcom/bytedance/trae/network/ttnet/NetInfo;
    return-void 
.end method
