# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitTTnetTask;
.super Ljava/lang/Object;
.source "InitTTnetTask.kt"

.implements Lcom/bytedance/lego/init/model/IInitTask;
.implements Lcom/bytedance/trae/init/task/base/IInitReportTask;

.field public static final $stable:I
.field private final firstStyle:Ljava/lang/String;
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
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitTTnetTask;->scene Ljava/lang/String;
    const-string v0, "asyncThreadWhenFirst"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitTTnetTask;->firstStyle Ljava/lang/String;
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
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitTTnetTask;->firstStyle Ljava/lang/String;
    return-object v0
.end method

.method public getScene()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/init/task/InitTTnetTask;->scene Ljava/lang/String;
    return-object v0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/init/task/base/IInitReportTask$DefaultImpls;->run(Lcom/bytedance/trae/init/task/base/IInitReportTask;)V
    return-void 
.end method

.method public runInternal()void
    .registers 8
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    sget-object v1, Lcom/bytedance/trae/init/config/TTNetConfig;->INSTANCE Lcom/bytedance/trae/init/config/TTNetConfig;
    invoke-virtual v1, Lcom/bytedance/trae/init/config/TTNetConfig;->getConfigServers()[Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/init/config/TTNetConfig;->INSTANCE Lcom/bytedance/trae/init/config/TTNetConfig;
    invoke-virtual v2, Lcom/bytedance/trae/init/config/TTNetConfig;->getServiceDomainMap()Ljava/util/Map;
    move-result-object v2
    const/4 v3, 0
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/network/TraeTTNet;->init$default(Lcom/bytedance/trae/network/TraeTTNet; [Ljava/lang/String; Ljava/util/Map; Z Ljava/util/List; I Ljava/lang/Object;)V
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    new-instance v1, Lcom/bytedance/trae/init/task/InitTTnetTask$runInternal$1;
    invoke-direct v1, Lcom/bytedance/trae/init/task/InitTTnetTask$runInternal$1;-><init>()V
    check-cast v1, Lcom/bytedance/trae/network/ConnectionTypeListener;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/TraeTTNet;->addConnectionTypeListener(Lcom/bytedance/trae/network/ConnectionTypeListener;)V
    return-void 
.end method
