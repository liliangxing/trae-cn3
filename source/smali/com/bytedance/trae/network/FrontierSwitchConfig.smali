# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/FrontierSwitchConfig;
.super Ljava/lang/Object;
.source "FrontierSwitchConfig.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/FrontierSwitchConfig;
.field private static final KEY_DISABLED:Ljava/lang/String;
.field private static final LOG_TYPE_KEY:Ljava/lang/String;
.field private static final REPO_NAME:Ljava/lang/String;
.field private static final VALUE_DISABLED:Ljava/lang/String;
.field private static final VALUE_ENABLED:Ljava/lang/String;
.field private static final configListener:Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
.field private static final disabled:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final listenerRegistered:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final repo$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$OoCSs8gJEMrnx6NyhEeVuGBDQDM()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/FrontierSwitchConfig;->repo_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-direct v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->INSTANCE Lcom/bytedance/trae/network/FrontierSwitchConfig;
    new-instance v0, Lcom/bytedance/trae/network/FrontierSwitchConfig$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/network/FrontierSwitchConfig$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->repo$delegate Lkotlin/Lazy;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->disabled Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->listenerRegistered Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    invoke-direct v0, Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->configListener Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getRepo(com.bytedance.trae.network.FrontierSwitchConfig)com.bytedance.keva.Keva
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method private final getRepo()com.bytedance.keva.Keva
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->repo$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    const-string v1, "getValue(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final repo_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 2
    # ins_size=0
    const-string v0, "frontier_switch_config"
    const/4 v1, 0
    invoke-static v0, v1, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String; I)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final isDisabled()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->disabled Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v0
    return v0
.end method

.method public final loadFromCache()void
    .registers 4
    # ins_size=1
    const-string v0, "0"
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/network/FrontierSwitchConfig;
    invoke-direct v3, Lcom/bytedance/trae/network/FrontierSwitchConfig;->getRepo()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const-string v2, "disable_frontier_reconnect"
    invoke-virtual v1, v2, v0, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/lang/String;
    sget-object v1, Lcom/bytedance/trae/network/FrontierSwitchConfig;->disabled Ljava/util/concurrent/atomic/AtomicBoolean;
    const-string v2, "1"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    invoke-virtual v1, v0, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    return-void 
    :try_start_0x2
.end method

.method public final registerConfigListener()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->listenerRegistered Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 1
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(Z Z)Z
    move-result v1
    if-nez v1, +003h
    return-void 
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/network/FrontierSwitchConfig;
    const-class v1, Lcom/bytedance/services/slardar/config/IConfigManager;
    invoke-static v1, Lcom/bytedance/news/common/service/manager/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/services/slardar/config/IConfigManager;
    if-nez v1, +006h
    invoke-virtual v0, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    goto +8h
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->configListener Lcom/bytedance/trae/network/FrontierSwitchConfig$configListener$1;
    check-cast v0, Lcom/bytedance/services/slardar/config/IConfigListener;
    invoke-interface v1, v0, Lcom/bytedance/services/slardar/config/IConfigManager;->registerConfigListener(Lcom/bytedance/services/slardar/config/IConfigListener;)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v0, Lcom/bytedance/trae/network/FrontierSwitchConfig;->listenerRegistered Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v0, v2, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    return-void 
    :try_start_0xb
.end method
