# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/ApmServiceImpl;
.super Ljava/lang/Object;
.source "ApmServiceImpl.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkApm;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/service/ApmServiceImpl;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/service/ApmServiceImpl;
    invoke-direct v0, Lcom/bytedance/trae/service/ApmServiceImpl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/service/ApmServiceImpl;->INSTANCE Lcom/bytedance/trae/service/ApmServiceImpl;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "msg"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static v2, Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere(Ljava/lang/String;)V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.Throwable)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, t
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static v2, Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.Throwable  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, t
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static v2, v3, Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String;)V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.Throwable  java.lang.String  java.util.Map)void
    .registers 5
    # ins_size=4
    const-string/jumbo v0, t
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, selfDefineData
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +00bh
    sget-object v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->INSTANCE Lcom/bytedance/trae/home/privacy/PrivacyManager;
    invoke-virtual v0, Lcom/bytedance/trae/home/privacy/PrivacyManager;->checkAgreed()Z
    move-result v0
    if-nez v0, +003h
    return-void 
    invoke-static v2, v3, v4, Lcom/bytedance/services/apm/api/EnsureManager;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String; Ljava/util/Map;)V
    return-void 
.end method

.method public bridge synthetic getPageLoadTrace(java.lang.String)com.bytedance.trae.platform.api.IPageLoadTrace
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/service/ApmServiceImpl;->getPageLoadTrace(Ljava/lang/String;)Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/platform/api/IPageLoadTrace;
    return-object v1
.end method

.method public getPageLoadTrace(java.lang.String)com.bytedance.trae.service.ApmServiceImpl$PageLoadTraceProxy
    .registers 3
    # ins_size=2
    const-string/jumbo v0, pageName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;
    invoke-direct v0, v2, Lcom/bytedance/trae/service/ApmServiceImpl$PageLoadTraceProxy;-><init>(Ljava/lang/String;)V
    return-object v0
.end method

.method public handleCloudMessage(byte[]  java.util.Map)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, payload
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "msgHeaders"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/monitor/cloudmessage/CloudMessageManager;->getInstance()Lcom/monitor/cloudmessage/CloudMessageManager;
    move-result-object v0
    invoke-virtual v0, v2, v3, Lcom/monitor/cloudmessage/CloudMessageManager;->handleCloudMessage([B Ljava/util/Map;)V
    return-void 
.end method

.method public monitorEventForSlardar(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, v4, v5, Lcom/bytedance/apm/ApmAgent;->monitorEvent(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public startCpuMonitor(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm6/cpu/ApmCpuManager;->getInstance()Lcom/bytedance/apm6/cpu/ApmCpuManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/apm6/cpu/ApmCpuManager;->startScene(Ljava/lang/String;)V
    return-void 
.end method

.method public stopCpuMonitor(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/apm6/cpu/ApmCpuManager;->getInstance()Lcom/bytedance/apm6/cpu/ApmCpuManager;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/apm6/cpu/ApmCpuManager;->stopScene(Ljava/lang/String;)V
    return-void 
.end method
