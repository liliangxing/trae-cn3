# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitAbTestSdkTask;
.super Ljava/lang/Object;
.source "InitAbTestSdkTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field public static final Companion:Lcom/bytedance/trae/init/task/InitAbTestSdkTask$Companion;
.field public static final TAG:Ljava/lang/String;
.field private final firstStyle:Ljava/lang/String;
.field private final scene:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/task/InitAbTestSdkTask$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/init/task/InitAbTestSdkTask$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/init/task/InitAbTestSdkTask;->Companion Lcom/bytedance/trae/init/task/InitAbTestSdkTask$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "Infra"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitAbTestSdkTask;->scene Ljava/lang/String;
    const-string v0, "asyncThreadWhenFirst"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitAbTestSdkTask;->firstStyle Ljava/lang/String;
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
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAbTestSdkTask;->firstStyle Ljava/lang/String;
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitAbTestSdkTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 3
    # ins_size=1
    const-class v0, Lcom/larus/init/IAbTestInitiator;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/larus/init/IAbTestInitiator;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/larus/init/IAbTestInitiator;
    if-eqz v0, +005h
    invoke-interface v0, Lcom/larus/init/IAbTestInitiator;->initAbTest()V
    return-void 
.end method
