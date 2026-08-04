# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
.super Ljava/lang/Object;
.source "AppDeviceEnv.kt"

.field public static final $stable:I
.field private static final EVENT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
.field private static final KEY_BUILD_ABI:Ljava/lang/String;
.field private static final KEY_CPU_PRIMARY_ABI:Ljava/lang/String;
.field private static final KEY_MEMORY_PAGE_SIZE:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;
.field private static final UNKNOWN:Ljava/lang/String;
.field private static final UNKNOWN_PAGE_SIZE:J
.field private static final buildAbi$delegate:Lkotlin/Lazy;
.field private static final cpuPrimaryAbi$delegate:Lkotlin/Lazy;
.field private static final memoryPageSize$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$46AVVGR4seO1fSAl-z2S6tAfmic()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->report$lambda$5$lambda$4()V
    return-void 
.end method

.method public static synthetic $r8$lambda$A86_GkiUaexw4-iaXSpmiUeGJXo()long
    .registers 2
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->memoryPageSize_delegate$lambda$2()J
    move-result-wide v0
    return-wide v0
.end method

.method public static synthetic $r8$lambda$cqfmLLWOCeeWzfS1AWL99vhkwrI()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->cpuPrimaryAbi_delegate$lambda$1()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$oD1vOpszmKixyMsaZf1czaruLOc()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->buildAbi_delegate$lambda$0()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$yQ1Oag97a5cR-b-ICg3rCvroeig()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->report$lambda$5()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
    invoke-direct v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->INSTANCE Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
    new-instance v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->buildAbi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->cpuPrimaryAbi$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda2;
    invoke-direct v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda2;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->memoryPageSize$delegate Lkotlin/Lazy;
    const/16 v0, 8
    sput v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->$stable I
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final buildAbi_delegate$lambda$0()java.lang.String
    .registers 1
    # ins_size=0
    const-string v0, ""
    return-object v0
.end method

.method private static final cpuPrimaryAbi_delegate$lambda$1()java.lang.String
    .registers 5
    # ins_size=0
    const-string v0, "AppDeviceEnv"
    sget-object v1, Landroid/os/Build;->SUPPORTED_ABIS [Ljava/lang/String;
    const/4 v2, 1
    const/4 v3, 0
    if-eqz v1, +00dh
    array-length v4, v1
    if-nez v4, +004h
    move v4, v2
    goto +2h
    move v4, v3
    if-eqz v4, +003h
    goto +3h
    move v4, v3
    goto +2h
    move v4, v2
    if-nez v4, +02dh
    aget-object v1, v1, v3
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00ah
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-nez v4, +003h
    goto +2h
    move v2, v3
    if-nez v2, +01ch
    goto +1dh
    move-exception v1
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "get cpu primary abi failed: "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String;)V
    const-string/jumbo v1, unknown
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string/jumbo v4, report cpu primary abi: 
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v2, v0, v3, Lcom/bytedance/trae/utils/logger/FLogger;->d(Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
    :try_start_0x2
.end method

.method private final getBuildAbi()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->buildAbi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method private final getCpuPrimaryAbi()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->cpuPrimaryAbi$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    return-object v0
.end method

.method private final getMemoryPageSize()long
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->memoryPageSize$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->longValue()J
    move-result-wide v0
    return-wide v0
.end method

.method private static final memoryPageSize_delegate$lambda$2()long
    .registers 2
    # ins_size=0
    sget v0, Landroid/system/OsConstants;->_SC_PAGESIZE I
    invoke-static v0, Landroid/system/Os;->sysconf(I)J
    move-result-wide v0
    goto +3h
    const-wide/16 v0, -1
    return-wide v0
    :try_start_0x0
.end method

.method private static final report$lambda$5()void
    .registers 2
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->INSTANCE Lcom/bytedance/trae/init/LaunchBoostExecutor;
    invoke-virtual v0, Lcom/bytedance/trae/init/LaunchBoostExecutor;->executors$app_mainlandRelease()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda3;
    invoke-direct v1, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda3;-><init>()V
    invoke-virtual v0, v1, Ljava/util/concurrent/ThreadPoolExecutor;->submit(Ljava/lang/Runnable;)Ljava/util/concurrent/Future;
    return-void 
.end method

.method private static final report$lambda$5$lambda$4()void
    .registers 6
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lorg/json/JSONObject;
    invoke-direct v1, Lorg/json/JSONObject;-><init>()V
    sget-object v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->INSTANCE Lcom/bytedance/trae/init/task/util/AppDeviceEnv;
    invoke-direct v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->getBuildAbi()Ljava/lang/String;
    move-result-object v3
    const-string v4, "build_abi"
    invoke-virtual v1, v4, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "cpu_primary_abi"
    invoke-direct v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->getCpuPrimaryAbi()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v1, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "memory_page_size"
    invoke-direct v2, Lcom/bytedance/trae/init/task/util/AppDeviceEnv;->getMemoryPageSize()J
    move-result-wide v4
    invoke-virtual v1, v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    const-string v2, "flow_app_device_env"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final report()void
    .registers 3
    # ins_size=1
    invoke-static Lcom/bytedance/apm/ApmContext;->isMainProcessSimple()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    new-instance v1, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda4;
    invoke-direct v1, Lcom/bytedance/trae/init/task/util/AppDeviceEnv$$ExternalSyntheticLambda4;-><init>()V
    invoke-virtual v0, v1, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method
