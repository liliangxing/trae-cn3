# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitPraiseDialogTask;
.super Ljava/lang/Object;
.source "InitPraiseDialogTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private final scene:Ljava/lang/String;


.method public static synthetic $r8$lambda$lqDdGl1cuyBdbyypuT49-LPbpZw(com.bytedance.trae.init.task.InitPraiseDialogTask)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/InitPraiseDialogTask;->checkOldUserIfNeeded$lambda$2(Lcom/bytedance/trae/init/task/InitPraiseDialogTask;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Basic"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitPraiseDialogTask;->scene Ljava/lang/String;
    return-void 
.end method

.method private final checkOldUserIfNeeded()void
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogTrigger;
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialogTrigger;->isOldUserDetermined()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    invoke-static Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/init/task/InitPraiseDialogTask$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/init/task/InitPraiseDialogTask$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/init/task/InitPraiseDialogTask;)V
    invoke-interface v0, v1, Ljava/util/concurrent/ExecutorService;->execute(Ljava/lang/Runnable;)V
    return-void 
.end method

.method private static final checkOldUserIfNeeded$lambda$2(com.bytedance.trae.init.task.InitPraiseDialogTask)void
    .registers 3
    # ins_size=1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v2
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v2, v0, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v2, +00fh
    invoke-interface v2, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v2
    if-eqz v2, +009h
    invoke-virtual v2, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +003h
    goto +3h
    const-string v2, "anonymous"
    sget-object v0, Lcom/bytedance/trae/im/database/DatabaseManager;->INSTANCE Lcom/bytedance/trae/im/database/DatabaseManager;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/database/DatabaseManager;->getDatabase(Landroid/content/Context; Ljava/lang/String;)Lcom/bytedance/trae/im/database/DatabaseOpenHelper;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/im/database/ConversationDao;
    invoke-direct v0, v2, Lcom/bytedance/trae/im/database/ConversationDao;-><init>(Lcom/bytedance/trae/im/database/DatabaseOpenHelper;)V
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/im/database/ConversationDao;->queryAll()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +003h
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogHelper;
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    invoke-virtual v0, v2, Lcom/bytedance/trae/praise/PraiseDialogHelper;->setHasTaskHistory(Z)V
    return-void 
    :try_start_0x0
    :try_start_0x32
    :try_start_0x3e
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
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitPraiseDialogTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 4
    # ins_size=1
    invoke-static Lcom/bytedance/praisedialoglib/manager/PraiseSdkManager;->getInstance()Lcom/bytedance/praisedialoglib/manager/PraiseSdkManager;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/praise/PraiseDialogConfigImpl;
    invoke-direct v1, Lcom/bytedance/trae/praise/PraiseDialogConfigImpl;-><init>()V
    check-cast v1, Lcom/bytedance/praisedialoglib/depend/IPraiseDialogConfig;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/praisedialoglib/manager/PraiseSdkManager;->init(Lcom/bytedance/praisedialoglib/depend/IPraiseDialogConfig; Landroid/app/Application;)V
    sget-object v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->INSTANCE Lcom/bytedance/trae/praise/PraiseDialogHelper;
    invoke-virtual v0, Lcom/bytedance/trae/praise/PraiseDialogHelper;->registerSettingsListener()V
    invoke-direct v3, Lcom/bytedance/trae/init/task/InitPraiseDialogTask;->checkOldUserIfNeeded()V
    return-void 
.end method
