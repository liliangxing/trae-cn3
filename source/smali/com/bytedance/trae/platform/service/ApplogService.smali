# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/service/ApplogService;
.super Ljava/lang/Object;
.source "ApplogService.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkApplog;

.field public static final INSTANCE:Lcom/bytedance/trae/platform/service/ApplogService;
.field private static final service$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$mJsaatVKzsPnuQ0pT5UDcVSTtjI()com.bytedance.trae.platform.api.ISdkApplog
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/platform/service/ApplogService;->service_delegate$lambda$0()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-direct v0, Lcom/bytedance/trae/platform/service/ApplogService;-><init>()V
    sput-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    new-instance v0, Lcom/bytedance/trae/platform/service/ApplogService$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/platform/service/ApplogService$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->service$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getService()com.bytedance.trae.platform.api.ISdkApplog
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->service$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkApplog;
    return-object v0
.end method

.method private static final service_delegate$lambda$0()com.bytedance.trae.platform.api.ISdkApplog
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
    invoke-interface v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;->getApplogService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public addApplogIdCallback(com.bytedance.trae.platform.api.IApplogIdCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApplog;->addApplogIdCallback(Lcom/bytedance/trae/platform/api/IApplogIdCallback;)V
    return-void 
.end method

.method public changeBgSessionTask(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApplog;->changeBgSessionTask(Z)V
    return-void 
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkApplog;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getInstallId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkApplog;->getInstallId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUserID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkApplog;->getUserID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUserUniqueID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkApplog;->getUserUniqueID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public putCommonParams(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, params
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/platform/api/ISdkApplog;->putCommonParams(Ljava/util/Map;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/platform/api/ISdkApplog;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/platform/api/ISdkApplog;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public setHeaderInfo(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/platform/service/ApplogService;->getService()Lcom/bytedance/trae/platform/api/ISdkApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/platform/api/ISdkApplog;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method
