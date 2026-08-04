# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/TraeTTNet;
.super Ljava/lang/Object;
.source "TraeTTNet.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/TraeTTNet;


.method public static synthetic $r8$lambda$LlFMZey6RH6PvPL47gzObXXV99w(java.util.concurrent.atomic.AtomicBoolean  kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/network/TraeTTNet;->runAfterCronetInit$lambda$1(Ljava/util/concurrent/atomic/AtomicBoolean; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/TraeTTNet;
    invoke-direct v0, Lcom/bytedance/trae/network/TraeTTNet;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic addInterceptors$default(com.bytedance.trae.network.TraeTTNet  java.util.List  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/TraeTTNet;->addInterceptors(Ljava/util/List;)V
    return-void 
.end method

.method public static synthetic init$default(com.bytedance.trae.network.TraeTTNet  java.lang.String[]  java.util.Map  boolean  java.util.List  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/network/TraeTTNet;->init([Ljava/lang/String; Ljava/util/Map; Z Ljava/util/List;)V
    return-void 
.end method

.method private static final runAfterCronetInit$lambda$1(java.util.concurrent.atomic.AtomicBoolean  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=2
    const/4 v0, 0
    const/4 v1, 1
    invoke-virtual v2, v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v2
    if-eqz v2, +005h
    invoke-interface v3, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final addConnectionTypeListener(com.bytedance.trae.network.ConnectionTypeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getConnectionTypeListeners()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v2, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final addInterceptor(com.bytedance.retrofit2.intercept.Interceptor)void
    .registers 3
    # ins_size=2
    const-string v0, "interceptor"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    return-void 
.end method

.method public final addInterceptors(java.util.List)void
    .registers 3
    # ins_size=2
    const-string v0, "interceptors"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Ljava/lang/Iterable;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/retrofit2/intercept/Interceptor;
    invoke-static v0, Lcom/bytedance/ttnet/utils/RetrofitUtils;->addInterceptor(Lcom/bytedance/retrofit2/intercept/Interceptor;)V
    goto -fh
    return-void 
.end method

.method public final getAppLogExtraParams(int)java.util.HashMap
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->INSTANCE Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/ttnet/ApiUrlParamsProvider;->getCommonQueryParams(I)Ljava/util/HashMap;
    move-result-object v2
    return-object v2
.end method

.method public final getHttpEnv()com.bytedance.trae.platform.model.HttpEnvConfig
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DevConfig;->INSTANCE Lcom/bytedance/trae/network/DevConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/DevConfig;->initHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    return-object v0
.end method

.method public final getOpaqueDataEnable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DevConfig;->INSTANCE Lcom/bytedance/trae/network/DevConfig;
    invoke-virtual v0, Lcom/bytedance/trae/network/DevConfig;->getOpaqueDataEnable()Z
    move-result v0
    return v0
.end method

.method public final init(java.lang.String[]  java.util.Map  boolean  java.util.List)void
    .registers 6
    # ins_size=5
    const-string v0, "configServers"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, serviceDomainMap
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "interceptors"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v5, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v5, v2, v3, v4, Lcom/bytedance/trae/network/ttnet/TTNetExt;->init([Ljava/lang/String; Ljava/util/Map; Z)V
    return-void 
.end method

.method public final isCronetInitSuccess()boolean
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/frameworks/baselib/network/TTNetInitMetrics;->isCronetInitSuccess()Z
    move-result v0
    return v0
.end method

.method public final removeConnectionTypeListener(com.bytedance.trae.network.ConnectionTypeListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->INSTANCE Lcom/bytedance/trae/network/ttnet/TTNetExt;
    invoke-virtual v0, Lcom/bytedance/trae/network/ttnet/TTNetExt;->getConnectionTypeListeners()Ljava/util/List;
    move-result-object v0
    invoke-interface v0, v2, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    return-void 
.end method

.method public final runAfterCronetInit(kotlin.jvm.functions.Function0)void
    .registers 5
    # ins_size=2
    const-string v0, "action"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeTTNet;->isCronetInitSuccess()Z
    move-result v0
    if-eqz v0, +006h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    new-instance v2, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;
    invoke-direct v2, v0, v4, Lcom/bytedance/trae/network/TraeTTNet$$ExternalSyntheticLambda0;-><init>(Ljava/util/concurrent/atomic/AtomicBoolean; Lkotlin/jvm/functions/Function0;)V
    invoke-static v2, Lcom/bytedance/frameworks/baselib/network/TTNetInitMetrics;->setTTNetInitSuccessCallback(Lcom/bytedance/frameworks/baselib/network/TTNetInitMetrics$TTNetInitCallback;)V
    invoke-virtual v3, Lcom/bytedance/trae/network/TraeTTNet;->isCronetInitSuccess()Z
    move-result v2
    if-eqz v2, +00ch
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v0
    if-eqz v0, +005h
    invoke-interface v4, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method public final updateHttpEnv(boolean  java.lang.String  boolean  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "boeEnv"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, ppeEnv
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/network/DevConfig;->INSTANCE Lcom/bytedance/trae/network/DevConfig;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/network/DevConfig;->updateHttpEnv(Z Ljava/lang/String; Z Ljava/lang/String;)V
    return-void 
.end method

.method public final updateOpaqueDataEnable(boolean)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/network/DevConfig;->INSTANCE Lcom/bytedance/trae/network/DevConfig;
    invoke-virtual v0, v2, Lcom/bytedance/trae/network/DevConfig;->updateOpaqueDataEnable(Z)V
    return-void 
.end method
