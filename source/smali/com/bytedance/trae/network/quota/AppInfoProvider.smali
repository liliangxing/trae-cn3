# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/quota/AppInfoProvider;
.super Ljava/lang/Object;
.source "AppInfoProvider.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/quota/AppInfoProvider;
.field private static final KEY_IS_FIRST_START_APP:Ljava/lang/String;
.field private static final REPO_NAME:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final firstStartFlag$delegate:Lkotlin/Lazy;
.field private static final initialized:Ljava/util/concurrent/atomic/AtomicBoolean;
.field private static final keva$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$3Ww4s7p1crro6c52QUc1kig0nj4()boolean
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/quota/AppInfoProvider;->firstStartFlag_delegate$lambda$1()Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$DBH7tXKFeFs4dAGrATQJ7VtaKZI()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/quota/AppInfoProvider;->keva_delegate$lambda$0()Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->INSTANCE Lcom/bytedance/trae/network/quota/AppInfoProvider;
    new-instance v0, Lcom/bytedance/trae/network/quota/AppInfoProvider$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppInfoProvider$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->keva$delegate Lkotlin/Lazy;
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;
    const/4 v1, 0
    invoke-direct v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V
    sput-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->initialized Ljava/util/concurrent/atomic/AtomicBoolean;
    new-instance v0, Lcom/bytedance/trae/network/quota/AppInfoProvider$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppInfoProvider$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->firstStartFlag$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final firstStartFlag_delegate$lambda$1()boolean
    .registers 4
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->INSTANCE Lcom/bytedance/trae/network/quota/AppInfoProvider;
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v1
    const/4 v2, 1
    const-string v3, "is_first_start_app"
    invoke-virtual v1, v3, v2, Lcom/bytedance/keva/Keva;->getBoolean(Ljava/lang/String; Z)Z
    move-result v1
    if-eqz v1, +00ah
    invoke-direct v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->getKeva()Lcom/bytedance/keva/Keva;
    move-result-object v0
    const/4 v2, 0
    invoke-virtual v0, v3, v2, Lcom/bytedance/keva/Keva;->storeBoolean(Ljava/lang/String; Z)V
    return v1
.end method

.method private final getFirstStartFlag()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->firstStartFlag$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Boolean;
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
.end method

.method private final getKeva()com.bytedance.keva.Keva
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->keva$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/keva/Keva;
    return-object v0
.end method

.method private static final keva_delegate$lambda$0()com.bytedance.keva.Keva
    .registers 1
    # ins_size=0
    const-string v0, "flow_infra_app_state_bind_with_device"
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    return-object v0
.end method

.method public final init()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->initialized Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v1
    if-eqz v1, +003h
    return-void 
    monitor-enter v2
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v1
    if-eqz v1, +004h
    monitor-exit v2
    return-void 
    const/4 v1, 1
    invoke-virtual v0, v1, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    monitor-exit v2
    return-void 
    move-exception v0
    monitor-exit v2
    throw v0
    :try_start_0xa
    :try_start_0x13
.end method

.method public final isFirstStartApp()boolean
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/network/quota/AppInfoProvider;->getFirstStartFlag()Z
    move-result v0
    return v0
.end method

.method public final isInitialized()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/quota/AppInfoProvider;->initialized Ljava/util/concurrent/atomic/AtomicBoolean;
    invoke-virtual v0, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z
    move-result v0
    return v0
.end method
