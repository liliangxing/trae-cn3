# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/service/ApmService;
.super Ljava/lang/Object;
.source "ApmService.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkApm;

.field public static final INSTANCE:Lcom/bytedance/trae/platform/service/ApmService;
.field private static final service$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$Rjnk3WJlY4Bw6rdVIwYf53YlysI()com.bytedance.trae.platform.api.ISdkApm
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/platform/service/ApmService;->service_delegate$lambda$0()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/platform/service/ApmService;
    invoke-direct v0, Lcom/bytedance/trae/platform/service/ApmService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/platform/service/ApmService;->INSTANCE Lcom/bytedance/trae/platform/service/ApmService;
    new-instance v0, Lcom/bytedance/trae/platform/service/ApmService$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/platform/service/ApmService$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/platform/service/ApmService;->service$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getService()com.bytedance.trae.platform.api.ISdkApm
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/service/ApmService;->service$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkApm;
    return-object v0
.end method

.method private static final service_delegate$lambda$0()com.bytedance.trae.platform.api.ISdkApm
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;->getApmService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public ensureNotReachHere(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "msg"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApm;->ensureNotReachHere(Ljava/lang/String;)V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.Throwable)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, t
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApm;->ensureNotReachHere(Ljava/lang/Throwable;)V
    return-void 
.end method

.method public ensureNotReachHere(java.lang.Throwable  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, t
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "msg"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/platform/api/ISdkApm;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String;)V
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
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, Lcom/bytedance/trae/platform/api/ISdkApm;->ensureNotReachHere(Ljava/lang/Throwable; Ljava/lang/String; Ljava/util/Map;)V
    return-void 
.end method

.method public getPageLoadTrace(java.lang.String)com.bytedance.trae.platform.api.IPageLoadTrace
    .registers 3
    # ins_size=2
    const-string/jumbo v0, pageName
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApm;->getPageLoadTrace(Ljava/lang/String;)Lcom/bytedance/trae/platform/api/IPageLoadTrace;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public handleCloudMessage(byte[]  java.util.Map)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, payload
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "msgHeaders"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/platform/api/ISdkApm;->handleCloudMessage([B Ljava/util/Map;)V
    return-void 
.end method

.method public monitorEventForSlardar(java.lang.String  org.json.JSONObject  org.json.JSONObject  org.json.JSONObject)void
    .registers 6
    # ins_size=5
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/platform/api/ISdkApm;->monitorEventForSlardar(Ljava/lang/String; Lorg/json/JSONObject; Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public startCpuMonitor(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApm;->startCpuMonitor(Ljava/lang/String;)V
    return-void 
.end method

.method public stopCpuMonitor(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, scene
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApmService;->getService()Lcom/bytedance/trae/platform/api/ISdkApm;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApm;->stopCpuMonitor(Ljava/lang/String;)V
    return-void 
.end method
