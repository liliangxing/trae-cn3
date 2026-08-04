# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;
.super Ljava/lang/Object;
.source "InitNpthGwpAsanTask.kt"

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
    const-string v0, "InitNpthGwpAsanTask"
    iput-object v0, v1, Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;->TAG Ljava/lang/String;
    return-void 
.end method

.method private final startGWPAsanMonitor()void
    .registers 5
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v4, Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;->TAG Ljava/lang/String;
    const-string/jumbo v2, startGWPAsanMonitor
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/api/INpth;->Companion Lcom/bytedance/trae/apm/api/INpth$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/apm/api/INpth$Companion;->enableGwpAsan()V
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    const-string v1, "gwp_asan_enable"
    const-string v2, "1"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    goto +ch
    move-exception v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v2, v4, Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;->TAG Ljava/lang/String;
    const-string/jumbo v3, startGWPAsanMonitor error
    invoke-virtual v1, v2, v3, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    return-void 
    :try_start_0x0
.end method

.method public run()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v3, Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;->TAG Ljava/lang/String;
    const-string/jumbo v2, startGWPAsanMonitor, isNpthGwpAsanEnable: false
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    iget-object v1, v3, Lcom/bytedance/trae/init/task/InitNpthGwpAsanTask;->TAG Ljava/lang/String;
    const-string/jumbo v2, runInternal, not enable
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/apm/api/IApmTrace;->Companion Lcom/bytedance/trae/apm/api/IApmTrace$Companion;
    const-string v1, "gwp_asan_enable"
    const-string v2, "0"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/apm/api/IApmTrace$Companion;->addTag(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method
