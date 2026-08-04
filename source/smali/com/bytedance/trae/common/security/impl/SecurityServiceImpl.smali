# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;
.super Ljava/lang/Object;
.source "SecurityServiceImpl.kt"

.implements Lcom/bytedance/trae/common/security/api/SecurityService;

.field public static final Companion:Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$Companion;
.field private static final MS_SDK_LICENSE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private final didListener:Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;


.method public static synthetic $r8$lambda$Mj0qw-tbBUHgkc2W7kzfkeaDhxk(android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->initAOPEnvironment$lambda$1(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$f8_ctQ8lXXRdnjdGdfLcFGM_110(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->msInit$lambda$0(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->Companion Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;
    invoke-direct v0, v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;-><init>(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;)V
    iput-object v0, v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->didListener Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;
    return-void 
.end method

.method public static final synthetic access$report(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context  java.lang.String  boolean)void
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->report(Landroid/content/Context; Ljava/lang/String; Z)V
    return-void 
.end method

.method public static final synthetic access$reportReceiveDid(com.bytedance.trae.common.security.impl.SecurityServiceImpl  java.lang.String  java.lang.String)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->reportReceiveDid(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private static final initAOPEnvironment$lambda$1(android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 4
    # ins_size=3
    const-string v0, "did"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v3, Lcom/bytedance/security/android/aopcheck/env/AOPEnvironment;->INSTANCE Lcom/bytedance/security/android/aopcheck/env/AOPEnvironment;
    new-instance v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$initAOPEnvironment$1$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$initAOPEnvironment$1$1;-><init>(Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/security/android/aopcheck/env/ICommonConfig;
    invoke-virtual v3, v1, v0, Lcom/bytedance/security/android/aopcheck/env/AOPEnvironment;->active(Landroid/content/Context; Lcom/bytedance/security/android/aopcheck/env/ICommonConfig;)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final initMsInternal(android.content.Context  boolean  boolean)void
    .registers 10
    # ins_size=4
    new-instance v8, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    const-string v1, "QgOQBrRT5fGyDbtY52i4z4HFVPb1QKNo5V9CmM9q13PpijZGpMGpmIl97Q+nimje9MSX7RVv7AlXPOM8pMApx5PpdkSNVwiqylpWPZ/bUDDZtf/fyDxN2kDpW6z4Mz4eM+Qe5enKwdxkMAcrsRonO1Q+4EfTvSL39iyLBCxiiz2Ybi6bSubaFOAp2eA4J0owrLPz+RyYf9eUICEAAzOCYScic/GD6cUayMVJbS/FD8m8vYcFKJh08NfL1S6KiHtUn1GXID8QLyZ31o5j0zvVbup9ermTNfJWbq9GfYh8LtqNM+VdZi6S68neWG6E8VXiUQfuEQ=="
    const/16 v2, 810
    invoke-direct v8, v0, v1, v2, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;-><init>(Ljava/lang/String; Ljava/lang/String; I)V
    const-string v0, "kS1"
    const-string v1, "1"
    invoke-virtual v8, v0, v1, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->addAdvanceInfo(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    const/4 v0, 0
    invoke-virtual v8, v0, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->setClientType(I)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v1, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->setChannel(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "https://"
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v3, Lcom/bytedance/trae/network/HostType;->MSSDK Lcom/bytedance/trae/network/HostType;
    invoke-virtual v2, v3, Lcom/bytedance/trae/network/HostResolver;->getHost(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v8, v1, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->setDefaultReportHost(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    const/4 v1, 1
    if-eqz v9, +019h
    sget-object v9, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v9
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    move v2, v1
    goto +2h
    move v2, v0
    if-eqz v2, +005h
    invoke-virtual v8, v9, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->setDeviceID(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    sget-object v9, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v9, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v9
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    move v0, v1
    if-eqz v0, +005h
    invoke-virtual v8, v9, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->setInstallID(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;
    invoke-virtual v8, Lcom/bytedance/mobsec/metasec/ml/MSConfig$Builder;->build()Lcom/bytedance/mobsec/metasec/ml/MSConfig;
    move-result-object v8
    invoke-static v7, v8, Lcom/bytedance/mobsec/metasec/ml/MSManagerUtils;->init(Landroid/content/Context; Lcom/bytedance/mobsec/metasec/ml/MSConfig;)Z
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v7
    check-cast v7, Lkotlin/coroutines/CoroutineContext;
    invoke-static v7, Lkotlinx/coroutines/CoroutineScopeKt;->CoroutineScope(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/CoroutineScope;
    move-result-object v0
    const/4 v1, 0
    const/4 v2, 0
    new-instance v7, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$initMsInternal$1;
    const/4 v8, 0
    invoke-direct v7, v8, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$initMsInternal$1;-><init>(Lkotlin/coroutines/Continuation;)V
    move-object v3, v7
    check-cast v3, Lkotlin/jvm/functions/Function2;
    const/4 v4, 3
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private static final msInit$lambda$0(com.bytedance.trae.common.security.impl.SecurityServiceImpl  android.content.Context  java.lang.String  java.lang.String)kotlin.Unit
    .registers 5
    # ins_size=4
    const-string v0, "<unused var>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "cold_start"
    const/4 v4, 1
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->report(Landroid/content/Context; Ljava/lang/String; Z)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v1
.end method

.method private final observeAndUpdateDid()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    iget-object v1, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->didListener Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    iget-object v1, v2, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->didListener Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$didListener$1;
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method private final report(android.content.Context  java.lang.String  boolean)void
    .registers 7
    # ins_size=4
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v4
    invoke-static v4, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lcom/bytedance/mobsec/metasec/ml/MSManagerUtils;->get(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSManager;
    move-result-object v4
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v6, +019h
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v6
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +004h
    move v2, v0
    goto +2h
    move v2, v1
    if-eqz v2, +005h
    invoke-virtual v4, v6, Lcom/bytedance/mobsec/metasec/ml/MSManager;->setDeviceID(Ljava/lang/String;)V
    sget-object v6, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v6
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-lez v2, +003h
    goto +2h
    move v0, v1
    if-eqz v0, +005h
    invoke-virtual v4, v6, Lcom/bytedance/mobsec/metasec/ml/MSManager;->setInstallID(Ljava/lang/String;)V
    invoke-virtual v4, v5, Lcom/bytedance/mobsec/metasec/ml/MSManager;->report(Ljava/lang/String;)V
    return-void 
.end method

.method private final reportReceiveDid(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/mobsec/metasec/ml/MSManagerUtils;->get(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/mobsec/metasec/ml/MSManager;->setDeviceID(Ljava/lang/String;)V
    invoke-virtual v0, v3, Lcom/bytedance/mobsec/metasec/ml/MSManager;->setInstallID(Ljava/lang/String;)V
    const-string v2, "did-iid-update"
    invoke-virtual v0, v2, Lcom/bytedance/mobsec/metasec/ml/MSManager;->report(Ljava/lang/String;)V
    return-void 
.end method

.method public createBdInterceptor()com.bytedance.retrofit2.intercept.Interceptor
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public enableTTNetEncrypt()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public forceTTNetRetry()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method

.method public getTTNetEncryptScene(java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return-object v1
.end method

.method public initAOPEnvironment(android.content.Context)void
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda1;
    invoke-direct v1, v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda1;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public initBdInstall()void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method public msFrameSign(java.lang.String)java.util.Map
    .registers 4
    # ins_size=2
    const-string v0, "rawStr"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/mobsec/metasec/ml/MSManagerUtils;->get(Ljava/lang/String;)Lcom/bytedance/mobsec/metasec/ml/MSManager;
    move-result-object v0
    const/4 v1, 1
    invoke-virtual v0, v3, v1, Lcom/bytedance/mobsec/metasec/ml/MSManager;->frameSign(Ljava/lang/String; I)Ljava/util/Map;
    move-result-object v3
    if-nez v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    return-object v3
.end method

.method public msInit(android.content.Context)void
    .registers 5
    # ins_size=2
    const-string v0, "appContext"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    goto +2h
    move v0, v1
    invoke-direct v3, v4, v0, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->initMsInternal(Landroid/content/Context; Z Z)V
    invoke-direct v3, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->observeAndUpdateDid()V
    if-eqz v0, +00dh
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    goto +22h
    const-string v0, "cold_start"
    invoke-direct v3, v4, v0, v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->report(Landroid/content/Context; Ljava/lang/String; Z)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +00eh
    new-instance v1, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl$msInit$2;-><init>(Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl; Landroid/content/Context;)V
    check-cast v1, Lcom/bytedance/trae/login/api/IAccountStatusListener;
    const/4 v4, 2
    const/4 v2, 0
    invoke-static v0, v1, v2, v4, v2, Lcom/bytedance/trae/login/api/ILoginService$DefaultImpls;->registerAccountStatusChangeListener$default(Lcom/bytedance/trae/login/api/ILoginService; Lcom/bytedance/trae/login/api/IAccountStatusListener; Ljava/lang/Boolean; I Ljava/lang/Object;)V
    return-void 
.end method

.method public msReport(android.content.Context  java.lang.String)void
    .registers 5
    # ins_size=3
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scene
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->isTraeLoggedIn()Z
    move-result v0
    goto +2h
    const/4 v0, 0
    invoke-direct v2, v3, v4, v0, Lcom/bytedance/trae/common/security/impl/SecurityServiceImpl;->report(Landroid/content/Context; Ljava/lang/String; Z)V
    return-void 
.end method

.method public shouldAddTTNetEncryptHeader(java.lang.String)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return v1
.end method

.method public tryMobTTNetEncryptResult(java.lang.String  java.lang.String  java.util.List)void
    .registers 4
    # ins_size=4
    const-string/jumbo v2, requestUrl
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, responseHeaders
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    return-void 
.end method
