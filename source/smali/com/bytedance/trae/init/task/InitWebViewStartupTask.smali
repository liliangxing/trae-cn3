# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitWebViewStartupTask;
.super Ljava/lang/Object;
.source "InitWebViewStartupTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private static final Companion:Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;
.field private static final MAIN_HANDLER:Landroid/os/Handler;
.field public static final STARTUP_DELAY_MS:J
.field public static final TAG:Ljava/lang/String;
.field private final scene:Ljava/lang/String;


.method public static synthetic $r8$lambda$3OFmrrgTdwDpDt0IU4E8cR23Cl8(com.bytedance.trae.init.task.InitWebViewStartupTask)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->startUpWebView()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->Companion Lcom/bytedance/trae/init/task/InitWebViewStartupTask$Companion;
    new-instance v0, Landroid/os/Handler;
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v1
    invoke-direct v0, v1, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V
    sput-object v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->MAIN_HANDLER Landroid/os/Handler;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->scene Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getMAIN_HANDLER$cp()android.os.Handler
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->MAIN_HANDLER Landroid/os/Handler;
    return-object v0
.end method

.method private final startUpWebView()void
    .registers 6
    # ins_size=1
    invoke-static Landroid/os/SystemClock;->elapsedRealtime()J
    move-result-wide v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v3, "WebViewStartup"
    const-string/jumbo v4, startUpWebView start
    invoke-virtual v2, v3, v4, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v2, Landroidx/webkit/WebViewStartUpConfig$Builder;
    sget-object v3, Lcom/bytedance/trae/init/LaunchBoostExecutor;->INSTANCE Lcom/bytedance/trae/init/LaunchBoostExecutor;
    invoke-virtual v3, Lcom/bytedance/trae/init/LaunchBoostExecutor;->executors$app_mainlandRelease()Ljava/util/concurrent/ThreadPoolExecutor;
    move-result-object v3
    check-cast v3, Ljava/util/concurrent/Executor;
    invoke-direct v2, v3, Landroidx/webkit/WebViewStartUpConfig$Builder;-><init>(Ljava/util/concurrent/Executor;)V
    invoke-virtual v2, Landroidx/webkit/WebViewStartUpConfig$Builder;->build()Landroidx/webkit/WebViewStartUpConfig;
    move-result-object v2
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v3
    check-cast v3, Landroid/content/Context;
    new-instance v4, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;
    invoke-direct v4, v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$startUpWebView$1;-><init>(J)V
    check-cast v4, Landroidx/webkit/WebViewOutcomeReceiver;
    invoke-static v3, v2, v4, Landroidx/webkit/WebViewCompat;->startUpWebView(Landroid/content/Context; Landroidx/webkit/WebViewStartUpConfig; Landroidx/webkit/WebViewOutcomeReceiver;)V
    return-void 
.end method

.method public checkFirstStartAsyncTaskInit(java.lang.String)boolean
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->checkFirstStartAsyncTaskInit(Lcom/bytedance/trae/init/task/base/IInitReportTask; Ljava/lang/String;)Z
    move-result v1
    return v1
.end method

.method public getFirstStyle()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->getFirstStyle(Lcom/bytedance/trae/init/task/base/IInitReportTask;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "WebViewStartup"
    const-string/jumbo v2, startUpWebView scheduled, delayMs=3000
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/init/task/InitWebViewStartupTask;->MAIN_HANDLER Landroid/os/Handler;
    new-instance v1, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$$ExternalSyntheticLambda0;
    invoke-direct v1, v4, Lcom/bytedance/trae/init/task/InitWebViewStartupTask$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/init/task/InitWebViewStartupTask;)V
    const-wide/16 v2, 3000
    invoke-virtual v0, v1, v2, v3, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable; J)Z
    return-void 
.end method
