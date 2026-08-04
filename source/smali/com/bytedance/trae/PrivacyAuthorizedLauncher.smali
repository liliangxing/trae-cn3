# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/PrivacyAuthorizedLauncher;
.super Ljava/lang/Object;
.source "PrivacyAuthorizedLauncher.kt"

.implements Lcom/bytedance/trae/ILauncher;

.field public static final $stable:I


.method public static synthetic $r8$lambda$hVZmDbEgt6kcAFdLX-emo337vdQ()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/PrivacyAuthorizedLauncher;->beforeAttachBaseContext$lambda$0()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final beforeAttachBaseContext$lambda$0()void
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/lego/init/InitScheduler;->initTasks()V
    invoke-static Lcom/bytedance/lego/init/InitScheduler;->initPeriodTask()V
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->markTaskInitialized()V
    return-void 
.end method

.method public afterAttachBaseContext(android.content.Context)void
    .registers 3
    # ins_size=2
    const-string v0, "context"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v2, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationAttachAfterSuper()V
    return-void 
.end method

.method public afterOnCreate(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v2, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationCreateAfterSuper()V
    return-void 
.end method

.method public beforeAttachBaseContext(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Ljava/lang/System;->currentTimeMillis()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/lego/init/monitor/InitMonitor;->INSTANCE Lcom/bytedance/lego/init/monitor/InitMonitor;
    invoke-virtual v2, Lcom/bytedance/lego/init/monitor/InitMonitor;->onAttachBase()V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v2
    new-instance v3, Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    invoke-static Lcom/bytedance/apm/ApmContext;->isMainProcessSimple()Z
    move-result v4
    invoke-static Lcom/bytedance/apm/ApmContext;->getCurrentProcessName()Ljava/lang/String;
    move-result-object v5
    const-string v6, "getCurrentProcessName(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v8, v4, v5, Lcom/bytedance/lego/init/config/TaskConfig$Builder;-><init>(Landroid/content/Context; Z Ljava/lang/String;)V
    const/4 v4, 1
    invoke-virtual v3, v4, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->isDebug(Z)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v3
    const/16 v5, 10000
    invoke-virtual v3, v5, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->setTimeOut(I)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v3
    xor-int/2addr v2, v4
    invoke-virtual v3, v2, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->enableCatchException(Z)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v2
    new-instance v3, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1;
    invoke-direct v3, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$beforeAttachBaseContext$config$1;-><init>()V
    check-cast v3, Ljava/util/concurrent/ThreadFactory;
    invoke-virtual v2, v3, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->setThreadFactory(Ljava/util/concurrent/ThreadFactory;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v2
    invoke-static Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Runtime;->availableProcessors()I
    move-result v3
    mul-int/lit8 v3, v3, 2
    invoke-virtual v2, v3, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->setCoreThreadNum(I)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/init/LaunchBoostExecutor;->INSTANCE Lcom/bytedance/trae/init/LaunchBoostExecutor;
    invoke-virtual v3, Lcom/bytedance/trae/init/LaunchBoostExecutor;->executors$app_mainlandRelease()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v3
    invoke-virtual v2, v3, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->setExecutorService(Ljava/util/concurrent/ThreadPoolExecutor;)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v2
    invoke-virtual v2, v0, v1, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->setApplicationStartTime(J)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v1, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v1
    invoke-virtual v0, v1, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->agreePrivacyPopupWindow(Z)Lcom/bytedance/lego/init/config/TaskConfig$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/lego/init/config/TaskConfig$Builder;->build()Lcom/bytedance/lego/init/config/TaskConfig;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/lego/init/InitScheduler;->config(Lcom/bytedance/lego/init/config/TaskConfig;)V
    sget-object v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->INSTANCE Lcom/bytedance/trae/init/task/base/TaskCollector;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/base/TaskCollector;->start()V
    new-instance v0, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/PrivacyAuthorizedLauncher$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lcom/bytedance/common/utility/concurrent/ThreadPlus;->submitRunnable(Ljava/lang/Runnable;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v0, v8, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationAttachBeforeSuper(Landroid/content/Context;)V
    return-void 
.end method

.method public beforeOnCreate(android.app.Application)void
    .registers 3
    # ins_size=2
    const-string v0, "application"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->INSTANCE Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/home/privacy/InitPeriodWrapper;->applicationCreateBeforeSuper(Landroid/app/Application;)V
    return-void 
.end method
