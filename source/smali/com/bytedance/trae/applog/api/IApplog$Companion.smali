# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/api/IApplog$Companion;
.super Ljava/lang/Object;
.source "IApplog.kt"

.implements Lcom/bytedance/trae/applog/api/IApplog;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/applog/api/IApplog$Companion;
.field private static final impl$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$-Vc4fzV4TxQID_CA4G23tYCqT8g()com.bytedance.trae.applog.api.IApplog
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/applog/api/IApplog$Companion;->impl_delegate$lambda$0()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-direct v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->$$INSTANCE Lcom/bytedance/trae/applog/api/IApplog$Companion;
    new-instance v0, Lcom/bytedance/trae/applog/api/IApplog$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/applog/api/IApplog$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->impl$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getImpl()com.bytedance.trae.applog.api.IApplog
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->impl$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/applog/api/IApplog;
    return-object v0
.end method

.method private static final impl_delegate$lambda$0()com.bytedance.trae.applog.api.IApplog
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/applog/api/IApplog;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/applog/api/IApplog;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/applog/api/IApplog;
    return-object v0
.end method

.method public addEventCommonParams(java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, valueGenerator
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->addEventCommonParams(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public addGetAppLogIdListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public addLaunchObserver(com.bytedance.trae.applog.api.OnLaunchCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->addLaunchObserver(Lcom/bytedance/trae/applog/api/OnLaunchCallback;)V
    return-void 
.end method

.method public addNavigatorCallback(com.bytedance.trae.applog.api.OnNavigateCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->addNavigatorCallback(Lcom/bytedance/trae/applog/api/OnNavigateCallback;)V
    return-void 
.end method

.method public doWhenIdsReady(kotlin.jvm.functions.Function2)void
    .registers 3
    # ins_size=2
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public flush()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->flush()V
    return-void 
.end method

.method public getAbSdkVersion()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getAbSdkVersion()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public getClientDid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getClientDid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getInstallId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getInstallId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getNetworkClient()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getNetworkClient()Ljava/lang/Object;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public getOpenUDid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getOpenUDid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getSessionId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getSsid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getSsid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUriConfig(boolean)java.lang.Object
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->getUriConfig(Z)Ljava/lang/Object;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public getUserID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getUserID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUserUniqueID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->getUserUniqueID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public isAutoNewUserMode(android.content.Context)boolean
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, v3, Lcom/bytedance/trae/applog/api/IApplog;->isAutoNewUserMode(Landroid/content/Context;)Z
    move-result v3
    const/4 v0, 1
    if-ne v3, v0, +003h
    move v1, v0
    return v1
.end method

.method public isNormalNewUserMode(android.content.Context)boolean
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, v3, Lcom/bytedance/trae/applog/api/IApplog;->isNormalNewUserMode(Landroid/content/Context;)Z
    move-result v3
    const/4 v0, 1
    if-ne v3, v0, +003h
    move v1, v0
    return v1
.end method

.method public onAccountTypeChanged(java.lang.String  java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=5
    const-string v0, "accountType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, userId
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tenantId
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, tenantName
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, v4, v5, Lcom/bytedance/trae/applog/api/IApplog;->onAccountTypeChanged(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onBgSessionTaskPause()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->onBgSessionTaskPause()V
    return-void 
.end method

.method public onBgSessionTaskResume()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->onBgSessionTaskResume()V
    return-void 
.end method

.method public onMiscEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "logType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "obj"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->onMiscEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public openETVerify()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, Lcom/bytedance/trae/applog/api/IApplog;->openETVerify()V
    return-void 
.end method

.method public putCommonParams(java.util.Map)void
    .registers 3
    # ins_size=2
    const-string v0, "params"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->putCommonParams(Ljava/util/Map;)V
    return-void 
.end method

.method public putEventCommonParams(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->putEventCommonParams(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public removeDidListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public removeHeaderInfo(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->removeHeaderInfo(Ljava/lang/String;)V
    return-void 
.end method

.method public reportEvent(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->reportEvent(Ljava/lang/String;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public setBDAccountCallback(android.util.Pair)void
    .registers 3
    # ins_size=2
    const-string v0, "pair"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->setBDAccountCallback(Landroid/util/Pair;)V
    return-void 
.end method

.method public setBDAccountCallbackProvider(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->setBDAccountCallbackProvider(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public setExternalAbVersionFromAbTest(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, vid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->setExternalAbVersionFromAbTest(Ljava/lang/String;)V
    return-void 
.end method

.method public setExternalAbVersionFromSettings(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, vid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->setExternalAbVersionFromSettings(Ljava/lang/String;)V
    return-void 
.end method

.method public setHeaderInfo(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/trae/applog/api/IApplog;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public setNewUserMode(android.content.Context  boolean  boolean)boolean
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    invoke-interface v0, v3, v4, v5, Lcom/bytedance/trae/applog/api/IApplog;->setNewUserMode(Landroid/content/Context; Z Z)Z
    move-result v3
    const/4 v4, 1
    if-ne v3, v4, +003h
    move v1, v4
    return v1
.end method

.method public setSwitchToBdtracker(boolean)void
    .registers 3
    # ins_size=2
    invoke-direct v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getImpl()Lcom/bytedance/trae/applog/api/IApplog;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/trae/applog/api/IApplog;->setSwitchToBdtracker(Z)V
    return-void 
.end method
