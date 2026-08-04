# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAppLog;
.super Ljava/lang/Object;
.source "InitAppLog.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private final scene:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitAppLog;->scene Ljava/lang/String;
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
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAppLog;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 24
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v1, Lcom/bytedance/trae/init/task/InitAppLog$runInternal$1;
    invoke-direct v1, Lcom/bytedance/trae/init/task/InitAppLog$runInternal$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    const-class v0, Lcom/bytedance/trae/applog/init/IAppLogInitiator;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/applog/init/IAppLogInitiator;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/applog/init/IAppLogInitiator;
    if-eqz v0, +048h
    new-instance v15, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;
    move-object v1, v15
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v2
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v4
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v6
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v7
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 100
    const-wide/16 v16, 5000
    move-object/from16 v22, v15
    move-wide/from16 v15, v16
    const-wide/32 v17, 60000
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    invoke-direct/range v1 ... v21, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;-><init>(I Ljava/lang/String; I Ljava/lang/String; I Ljava/lang/String; Z Z Z Z Z Z I J J Z Z Z)V
    move-object/from16 v1, v22
    invoke-interface v0, v1, Lcom/bytedance/trae/applog/init/IAppLogInitiator;->initAppLog(Lcom/bytedance/trae/applog/api/AppLogConfigInfo;)V
    sget-object v0, Lcom/bytedance/trae/init/task/TrackerCommonParams;->INSTANCE Lcom/bytedance/trae/init/task/TrackerCommonParams;
    invoke-virtual v0, Lcom/bytedance/trae/init/task/TrackerCommonParams;->register()V
    return-void 
.end method
