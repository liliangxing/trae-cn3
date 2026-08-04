# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitNpthAsyncTask;
.super Ljava/lang/Object;
.source "InitNpthAsyncTask.kt"

.implements Lcom/bytedance/lego/init/model/BaseFeedShowTask;

.field public static final $stable:I
.field private final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 0
    # ins_size=0
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "InitNpthAsyncTask"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->TAG Ljava/lang/String;
    return-void 
.end method

.method private final setOpenLooperMonitor()void
    .registers 9
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v8, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->TAG Ljava/lang/String;
    const-string/jumbo v2, setOpenLooperMonitor
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v1
    invoke-direct v8, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->shouldDisableAnrLooperMonitor()Z
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +004h
    move v2, v4
    goto +6h
    if-nez v0, +004h
    if-eqz v1, -004h
    move v2, v3
    const-string v5, "anr_looper_monitor"
    if-eqz v2, +034h
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v4, v8, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->TAG Ljava/lang/String;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v7, "anr_looper_monitor, enable = true.  isDebug: "
    invoke-direct v6, v7, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v6, ", isTestChannel: "
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isAnrLooperMonitorEnable: false"
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v4, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    const-string/jumbo v1, true
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/crash/GlobalSwitch;->setOpenLooperMonitor(Z)V
    goto +14h
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v8, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->TAG Ljava/lang/String;
    const-string v2, "anr_looper_monitor, not enable"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    const-string v1, "false"
    invoke-virtual v0, v5, v1, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    invoke-static v4, Lcom/bytedance/crash/GlobalSwitch;->setOpenLooperMonitor(Z)V
    return-void 
.end method

.method private final shouldDisableAnrLooperMonitor()boolean
    .registers 5
    # ins_size=1
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 29
    if-ne v0, v1, +017h
    invoke-static Lcom/bytedance/crash/util/RomUtils;->isHarmonyOs()Z
    move-result v0
    if-eqz v0, +011h
    const/4 v0, 1
    return v0
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v4, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->TAG Ljava/lang/String;
    const-string/jumbo v3, shouldDisableAnrLooperMonitor
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v1, v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    const/4 v0, 0
    return v0
    :try_start_0x0
.end method

.method public run()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/init/task/InitNpthAsyncTask;->setOpenLooperMonitor()V
    return-void 
.end method
