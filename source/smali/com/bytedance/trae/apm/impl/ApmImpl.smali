# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/apm/impl/ApmImpl;
.super Ljava/lang/Object;
.source "ApmImpl.kt"

.implements Lcom/bytedance/trae/apm/api/IApm;

.field public static final Companion:Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;
.field private static final TAG:Ljava/lang/String;
.field private static final enableOptApmLooper$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$rfEHf14nGaZTRHgp1HUAM0EgLw8(android.app.Activity)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/apm/impl/ApmImpl;->initApm$lambda$3(Landroid/app/Activity;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$yZVuGf-bCsp7VcqZbOzFEUWD3e4()boolean
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/apm/impl/ApmImpl;->enableOptApmLooper_delegate$lambda$6()Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/apm/impl/ApmImpl;->Companion Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;
    new-instance v0, Lcom/bytedance/trae/apm/impl/ApmImpl$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ApmImpl$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/apm/impl/ApmImpl;->enableOptApmLooper$delegate Lkotlin/Lazy;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getEnableOptApmLooper$delegate$cp()kotlin.Lazy
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/apm/impl/ApmImpl;->enableOptApmLooper$delegate Lkotlin/Lazy;
    return-object v0
.end method

.method public static final synthetic access$startApm(com.bytedance.trae.apm.impl.ApmImpl  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->startApm(Ljava/lang/String;)V
    return-void 
.end method

.method private final configApmOpt(com.bytedance.apm.config.ApmInitConfig$Builder)void
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/apm/impl/ApmImpl;->Companion Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;
    invoke-static v0, Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;->access$getEnableOptApmLooper(Lcom/bytedance/trae/apm/impl/ApmImpl$Companion;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +00bh
    sput-boolean v1, Lcom/bytedance/monitor/collector/Util;->enableLooperObserver Z
    invoke-virtual v3, v1, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->enableLooperOpt(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->enableLooperDeepOpt(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    invoke-virtual v3, v1, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->enableCpuAllocOpt(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    return-void 
.end method

.method private final configBinderMonitor(com.bytedance.apm.config.ApmInitConfig$Builder)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method private final configBlockDetect(com.bytedance.apm.config.ApmInitConfig$Builder)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method private static final enableOptApmLooper_delegate$lambda$6()boolean
    .registers 1
    # ins_size=0
    const/4 v0, 0
    return v0
.end method

.method private static final initApm$lambda$3(android.app.Activity)void
    .registers 1
    # ins_size=1
    return-void 
.end method

.method private final startApm(java.lang.String)void
    .registers 6
    # ins_size=2
    invoke-static Lcom/bytedance/apm/config/ApmStartConfig;->builder()Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->aid(I)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->channel(Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->appVersion(Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->updateVersionCode(Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v0
    invoke-virtual v0, v5, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->deviceId(Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    const/4 v0, 1
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->useDefaultTTNetImpl(Z)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    invoke-static Lcom/bytedance/apm/util/SlardarProperties;->getReleaseBuild()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->releaseBuild(Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    new-instance v1, Lcom/bytedance/memory/MemoryWidget;
    invoke-static Lcom/bytedance/memory/model/MemoryWidgetConfig;->newBuilder()Lcom/bytedance/memory/model/MemoryWidgetConfig$Builder;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/memory/model/MemoryWidgetConfig$Builder;->build()Lcom/bytedance/memory/model/MemoryWidgetConfig;
    move-result-object v2
    const/4 v3, 0
    invoke-direct v1, v2, v3, Lcom/bytedance/memory/MemoryWidget;-><init>(Lcom/bytedance/memory/model/MemoryWidgetConfig; Lcom/bytedance/memory/watcher/OnGetMemoryResultListener;)V
    check-cast v1, Lcom/bytedance/services/apm/api/IWidget;
    invoke-virtual v5, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->widget(Lcom/bytedance/services/apm/api/IWidget;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->blockDetect(Z)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->seriousBlockDetect(Z)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    new-instance v1, Lcom/monitor/cloudmessage/CloudMessageWidget;
    invoke-direct v1, Lcom/monitor/cloudmessage/CloudMessageWidget;-><init>()V
    check-cast v1, Lcom/bytedance/services/apm/api/IWidget;
    invoke-virtual v5, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->widget(Lcom/bytedance/services/apm/api/IWidget;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->blockDetectOnlySampled(Z)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->batteryDetect(Z)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$1;-><init>()V
    check-cast v0, Lcom/bytedance/services/apm/api/IRequestTagHeaderProvider;
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->requestTagHeaderProvider(Lcom/bytedance/services/apm/api/IRequestTagHeaderProvider;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    new-instance v0, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$2;
    invoke-direct v0, Lcom/bytedance/trae/apm/impl/ApmImpl$startApm$configBuilder$2;-><init>()V
    check-cast v0, Lcom/bytedance/apm/core/IDynamicParams;
    invoke-virtual v5, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->dynamicParams(Lcom/bytedance/apm/core/IDynamicParams;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getStaticParams()Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v0
    invoke-interface v0, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +018h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/util/Map$Entry;
    invoke-interface v1, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-interface v1, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v5, v2, v1, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->param(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    goto -1bh
    sget-object v0, Lcom/bytedance/trae/apm/api/IExtraParams;->Companion Lcom/bytedance/trae/apm/api/IExtraParams$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/apm/api/IExtraParams$Companion;->getDynamicParams()Ljava/util/Map;
    move-result-object v0
    const-string/jumbo v1, scope
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    if-eqz v0, +005h
    invoke-virtual v5, v1, v0, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->param(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/apm/config/ApmStartConfig$Builder;
    invoke-static Lcom/bytedance/apm/Apm;->getInstance()Lcom/bytedance/apm/Apm;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/apm/config/ApmStartConfig$Builder;->build()Lcom/bytedance/apm/config/ApmStartConfig;
    move-result-object v5
    invoke-virtual v0, v5, Lcom/bytedance/apm/Apm;->start(Lcom/bytedance/apm/config/ApmStartConfig;)V
    return-void 
.end method

.method static synthetic startApm$default(com.bytedance.trae.apm.impl.ApmImpl  java.lang.String  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    const-string v1, ""
    invoke-direct v0, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->startApm(Ljava/lang/String;)V
    return-void 
.end method

.method public initApm()void
    .registers 7
    # ins_size=1
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/apm/ApmAgent;->FAST_MODE Z
    sput-boolean v0, Lcom/bytedance/apm6/commonevent/CommonEventDeliverer;->FAST_MODE Z
    invoke-static Lcom/bytedance/apm/data/pipeline/CommonDataPipeline;->getInstance()Lcom/bytedance/apm/data/pipeline/CommonDataPipeline;
    move-result-object v1
    iput-boolean v0, v1, Lcom/bytedance/apm/data/pipeline/CommonDataPipeline;->fastMode Z
    invoke-static Lcom/bytedance/apm/data/pipeline/NetDataPipeline;->getInstance()Lcom/bytedance/apm/data/pipeline/NetDataPipeline;
    move-result-object v1
    iput-boolean v0, v1, Lcom/bytedance/apm/data/pipeline/NetDataPipeline;->fastMode Z
    new-instance v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    invoke-direct v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;-><init>()V
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->collectPerfData()Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->collectNetData()Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->collectTimingTrace()Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->collectDeviceInfo()Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->collectSlowLaunchTrace()Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    const-wide/16 v2, 3000
    invoke-virtual v1, v2, v3, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->setSlowLaunchThreshold(J)Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/launch/LaunchInitConfig$Builder;->build()Lcom/bytedance/apm/launch/LaunchInitConfig;
    move-result-object v1
    invoke-static Lcom/bytedance/apm/config/ApmInitConfig;->builder()Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v2
    invoke-virtual v2, v1, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->launchInitConfig(Lcom/bytedance/apm/launch/LaunchInitConfig;)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->viewIdMonitorPageSwitch(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->fullFpsTracer(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v6, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->configBlockDetect(Lcom/bytedance/apm/config/ApmInitConfig$Builder;)V
    const-wide/32 v2, 20000000
    invoke-virtual v1, v2, v3, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->maxValidPageLoadTimeMs(J)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->enableActivityFps(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v6, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->configBinderMonitor(Lcom/bytedance/apm/config/ApmInitConfig$Builder;)V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    invoke-virtual v1, v3, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->debugMode(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, v0, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->enableDeviceInfoOnPerfData(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, v2, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->supportMultiFrameRate(Z)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v6, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->configApmOpt(Lcom/bytedance/apm/config/ApmInitConfig$Builder;)V
    invoke-static Lcom/bytedance/apm/config/ActivityLeakDetectConfig;->builder()Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    invoke-virtual v3, v2, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->gcDetectActivityLeak(Z)Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->reportActivityLeakEvent(Z)Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    const-wide/32 v4, 60000
    invoke-virtual v3, v4, v5, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->waitDetectActivityTimeMs(J)Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    invoke-virtual v3, v0, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->unbindActivityLeakSwitch(Z)Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/apm/impl/ApmImpl$$ExternalSyntheticLambda0;
    invoke-direct v4, Lcom/bytedance/trae/apm/impl/ApmImpl$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v3, v4, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->activityLeakListener(Lcom/bytedance/apm/perf/memory/IActivityLeakListener;)Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/apm/config/ActivityLeakDetectConfig$Builder;->build()Lcom/bytedance/apm/config/ActivityLeakDetectConfig;
    move-result-object v3
    invoke-virtual v1, v3, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->detectActivityLeak(Lcom/bytedance/apm/config/ActivityLeakDetectConfig;)Lcom/bytedance/apm/config/ApmInitConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/apm/config/ApmInitConfig$Builder;->build()Lcom/bytedance/apm/config/ApmInitConfig;
    move-result-object v1
    invoke-static Lcom/bytedance/apm/Apm;->getInstance()Lcom/bytedance/apm/Apm;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v4
    check-cast v4, Landroid/content/Context;
    invoke-virtual v3, v4, v1, Lcom/bytedance/apm/Apm;->init(Landroid/content/Context; Lcom/bytedance/apm/config/ApmInitConfig;)V
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +003h
    goto +2h
    move v0, v2
    if-eqz v0, +006h
    invoke-direct v6, v1, Lcom/bytedance/trae/apm/impl/ApmImpl;->startApm(Ljava/lang/String;)V
    goto +dh
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/apm/impl/ApmImpl$initApm$1;
    invoke-direct v1, v6, Lcom/bytedance/trae/apm/impl/ApmImpl$initApm$1;-><init>(Lcom/bytedance/trae/apm/impl/ApmImpl;)V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public initLogAndALog(boolean  int  android.app.Application)void
    .registers 5
    # ins_size=4
    const-string v0, "application"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/impl/Logger;->INSTANCE Lcom/bytedance/trae/apm/impl/Logger;
    check-cast v4, Landroid/content/Context;
    invoke-virtual v0, v2, v3, v4, Lcom/bytedance/trae/apm/impl/Logger;->initLogAndALog(Z I Landroid/content/Context;)V
    return-void 
.end method

.method public isMainProcess(android.content.Context)boolean
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/apm/util/AppUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v2
    return v2
.end method

.method public registerDolaCloudControlConsumer(boolean)void
    .registers 3
    # ins_size=2
    new-instance v0, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;
    invoke-direct v0, v2, Lcom/bytedance/trae/apm/impl/ApmImpl$registerDolaCloudControlConsumer$1;-><init>(Z)V
    check-cast v0, Lcom/monitor/cloudmessage/callback/IAlogConsumer;
    invoke-static v0, Lcom/monitor/cloudmessage/CloudMessageManager;->setAlogConsumerSafely(Lcom/monitor/cloudmessage/callback/IAlogConsumer;)V
    return-void 
.end method
