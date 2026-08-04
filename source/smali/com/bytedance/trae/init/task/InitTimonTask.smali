# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitTimonTask;
.super Ljava/lang/Object;
.source "InitTimonTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private final scene:Ljava/lang/String;


.method public static synthetic $r8$lambda$6OyIJf_jBbz2FrWHc51Ow7PL4O8()java.lang.String
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/InitTimonTask;->runInternal$lambda$1()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$WJQof-lNG2gCd7-fuJMLqpUIK1Y()boolean
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/init/task/InitTimonTask;->runInternal$lambda$0()Z
    move-result v0
    return v0
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
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitTimonTask;->scene Ljava/lang/String;
    return-void 
.end method

.method private static final runInternal$lambda$0()boolean
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    return v0
.end method

.method private static final runInternal$lambda$1()java.lang.String
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
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
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitTimonTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 21
    # ins_size=1
    sget-object v0, Lcom/bytedance/timonkit/Timon;->INSTANCE Lcom/bytedance/timonkit/Timon;
    new-instance v1, Lcom/bytedance/trae/init/task/InitTimonTask$$ExternalSyntheticLambda0;
    invoke-direct v1, Lcom/bytedance/trae/init/task/InitTimonTask$$ExternalSyntheticLambda0;-><init>()V
    invoke-virtual v0, v1, Lcom/bytedance/timonkit/Timon;->registerAgreedPrivacyReferee(Lkotlin/jvm/functions/Function0;)V
    sget-object v0, Lcom/bytedance/timonkit/Timon;->INSTANCE Lcom/bytedance/timonkit/Timon;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/timonkit/Timon;->enableClipboardCompliance(Z)V
    sget-object v2, Lcom/bytedance/timonkit/Timon;->INSTANCE Lcom/bytedance/timonkit/Timon;
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v3
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v4
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v6
    new-instance v0, Lcom/bytedance/timonbase/TMInitialExtra;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v8
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v1
    int-to-long v9, v1
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v1
    int-to-long v11, v1
    new-instance v1, Lcom/bytedance/upc/Configuration$Builder;
    invoke-direct v1, Lcom/bytedance/upc/Configuration$Builder;-><init>()V
    invoke-virtual v1, Lcom/bytedance/upc/Configuration$Builder;->build()Lcom/bytedance/upc/Configuration;
    move-result-object v13
    const/4 v14, 0
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 240
    const/16 v19, 0
    move-object v7, v0
    invoke-direct/range v7 ... v19, Lcom/bytedance/timonbase/TMInitialExtra;-><init>(Ljava/lang/String; J J Lcom/bytedance/upc/Configuration; Z Lcom/bytedance/timonbase/teen/ITeenExtra; Ljava/lang/Integer; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v5, Lcom/bytedance/trae/init/task/InitTimonTask$$ExternalSyntheticLambda1;
    invoke-direct v5, Lcom/bytedance/trae/init/task/InitTimonTask$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual/range v2 ... v7, Lcom/bytedance/timonkit/Timon;->init(Ljava/lang/String; I Lkotlin/jvm/functions/Function0; Landroid/app/Application; Lcom/bytedance/timonbase/TMInitialExtra;)V
    return-void 
.end method
