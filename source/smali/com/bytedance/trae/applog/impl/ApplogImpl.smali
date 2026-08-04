# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/ApplogImpl;
.super Ljava/lang/Object;
.source "ApplogImpl.kt"

.implements Lcom/bytedance/trae/applog/api/IApplog;

.field private vidsFromAbTest:Ljava/lang/String;
.field private vidsFromSettings:Ljava/lang/String;


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final isTestChannel()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    return v0
.end method

.method private final updateExternalAbVersion()void
    .registers 13
    # ins_size=1
    const-string v0, "ApplogImpl"
    const-string/jumbo v1, updateExternalAbVersion: vidsFromSettings=
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v12, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v3, ", vidsFromAbTest="
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v3, v12, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v1, 2
    new-array v1, v1, [Ljava/lang/String;
    iget-object v2, v12, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    const/4 v3, 0
    aput-object v2, v1, v3
    iget-object v2, v12, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    const/4 v3, 1
    aput-object v2, v1, v3
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOfNotNull([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +016h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Ljava/lang/String;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    xor-int/2addr v5, v3
    if-eqz v5, -014h
    invoke-interface v2, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v2, Ljava/util/List;
    move-object v3, v2
    check-cast v3, Ljava/lang/Iterable;
    const-string v1, ","
    move-object v4, v1
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, Lcom/bytedance/applog/AppLog;->setExternalAbVersion(Ljava/lang/String;)V
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    invoke-direct v3, Ljava/lang/StringBuilder;-><init>()V
    const-string/jumbo v4, updateExternalAbVersion: setExternalAbVersion=
    invoke-virtual v3, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v2, v0, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    :try_start_0x5
.end method

.method public addEventCommonParams(java.lang.String  kotlin.jvm.functions.Function0)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, valueGenerator
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addEventCommonParams(Ljava/lang/String; Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public addGetAppLogIdListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addGetAppLogIdListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public addLaunchObserver(com.bytedance.trae.applog.api.OnLaunchCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addLaunchObserver(Lcom/bytedance/trae/applog/api/OnLaunchCallback;)V
    return-void 
.end method

.method public addNavigatorCallback(com.bytedance.trae.applog.api.OnNavigateCallback)void
    .registers 3
    # ins_size=2
    const-string v0, "callback"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->addNavigationCallback(Lcom/bytedance/trae/applog/api/OnNavigateCallback;)V
    return-void 
.end method

.method public doWhenIdsReady(kotlin.jvm.functions.Function2)void
    .registers 3
    # ins_size=2
    const-string v0, "action"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->doWhenIdsReady(Lkotlin/jvm/functions/Function2;)V
    return-void 
.end method

.method public flush()void
    .registers 1
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->flush()V
    return-void 
.end method

.method public getAbSdkVersion()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getAbSdkVersion()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getClientDid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getClientUdid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getDid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getInstallId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getIid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getNetworkClient()java.lang.Object
    .registers 2
    # ins_size=1
    new-instance v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/AppLogHelper$CommonNetworkClient;-><init>()V
    return-object v0
.end method

.method public getOpenUDid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getOpenUdid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getSessionId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getSessionId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getSsid()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getSsid()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUriConfig(boolean)java.lang.Object
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->uriConfig(Z)Lcom/bytedance/applog/UriConfig;
    move-result-object v2
    return-object v2
.end method

.method public getUserID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getUserID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getUserUniqueID()java.lang.String
    .registers 2
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->getUserUniqueID()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final getVidsFromAbTest()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    return-object v0
.end method

.method public final getVidsFromSettings()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    return-object v0
.end method

.method public isAutoNewUserMode(android.content.Context)boolean
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/applog/AppLog;->isNewUserMode(Landroid/content/Context;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +015h
    invoke-static v3, Lcom/bytedance/applog/AppLog;->newUserMode(Landroid/content/Context;)Lcom/bytedance/bdinstall/service/NUApi;
    move-result-object v3
    const/4 v0, 1
    if-eqz v3, +00ah
    invoke-interface v3, Lcom/bytedance/bdinstall/service/NUApi;->isAutoMode()Z
    move-result v3
    if-ne v3, v0, +004h
    move v3, v0
    goto +2h
    move v3, v1
    if-eqz v3, +003h
    move v1, v0
    return v1
.end method

.method public isNormalNewUserMode(android.content.Context)boolean
    .registers 4
    # ins_size=2
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v3, Lcom/bytedance/applog/AppLog;->isNewUserMode(Landroid/content/Context;)Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +015h
    invoke-static v3, Lcom/bytedance/applog/AppLog;->newUserMode(Landroid/content/Context;)Lcom/bytedance/bdinstall/service/NUApi;
    move-result-object v3
    const/4 v0, 1
    if-eqz v3, +00ah
    invoke-interface v3, Lcom/bytedance/bdinstall/service/NUApi;->isAutoMode()Z
    move-result v3
    if-ne v3, v0, +004h
    move v3, v0
    goto +2h
    move v3, v1
    if-nez v3, +003h
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
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, v4, v5, Lcom/bytedance/trae/applog/impl/AppLogHelper;->onAccountTypeChanged(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public onBgSessionTaskPause()void
    .registers 1
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->onBgSessionTaskPause()V
    return-void 
.end method

.method public onBgSessionTaskResume()void
    .registers 1
    # ins_size=1
    invoke-static Lcom/bytedance/applog/AppLog;->onBgSessionTaskResume()V
    return-void 
.end method

.method public onMiscEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "logType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "obj"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->onMiscEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public openETVerify()void
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->openETVerify()V
    return-void 
.end method

.method public putCommonParams(java.util.Map)void
    .registers 5
    # ins_size=2
    const-string v0, "params"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    const/4 v1, 1
    sget-object v2, Lcom/bytedance/bdinstall/Level;->L1 Lcom/bytedance/bdinstall/Level;
    invoke-static v0, v4, v1, v2, Lcom/bytedance/applog/AppLog;->putCommonParams(Landroid/content/Context; Ljava/util/Map; Z Lcom/bytedance/bdinstall/Level;)V
    return-void 
.end method

.method public putEventCommonParams(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->putEventCommonParams(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public removeDidListener(com.bytedance.trae.applog.api.OnGetAppLogIdListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->removeDidListener(Lcom/bytedance/trae/applog/api/OnGetAppLogIdListener;)V
    return-void 
.end method

.method public removeHeaderInfo(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, Lcom/bytedance/applog/AppLog;->removeHeaderInfo(Ljava/lang/String;)V
    return-void 
.end method

.method public reportEvent(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "event"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-static Landroidx/core/os/BundleKt;->bundleOf()Landroid/os/Bundle;
    move-result-object v1
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportEvent(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, v3, Lcom/bytedance/trae/applog/impl/AppLogHelper;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public setBDAccountCallback(android.util.Pair)void
    .registers 3
    # ins_size=2
    const-string v0, "pair"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->setBDAccountCallback(Landroid/util/Pair;)V
    return-void 
.end method

.method public setBDAccountCallbackProvider(kotlin.jvm.functions.Function0)void
    .registers 3
    # ins_size=2
    const-string v0, "provider"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/AppLogHelper;->INSTANCE Lcom/bytedance/trae/applog/impl/AppLogHelper;
    invoke-virtual v0, v2, Lcom/bytedance/trae/applog/impl/AppLogHelper;->setBDAccountCallbackProvider(Lkotlin/jvm/functions/Function0;)V
    return-void 
.end method

.method public setExternalAbVersionFromAbTest(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, vid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v2, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->updateExternalAbVersion()V
    return-void 
.end method

.method public setExternalAbVersionFromSettings(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, vid
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iput-object v2, v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/ApplogImpl;->updateExternalAbVersion()V
    return-void 
.end method

.method public setHeaderInfo(java.lang.String  java.lang.Object)void
    .registers 5
    # ins_size=3
    const-string v0, "key"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;
    move-result-object v0
    invoke-virtual v0, Landroid/os/Looper;->getThread()Ljava/lang/Thread;
    move-result-object v0
    invoke-static Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +019h
    invoke-direct v2, Lcom/bytedance/trae/applog/impl/ApplogImpl;->isTestChannel()Z
    move-result v0
    if-eqz v0, +013h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +003h
    goto +9h
    new-instance v3, Ljava/lang/IllegalStateException;
    const-string v4, "AppLog.setHeaderInfo MUST NOT be called in main thread (For Cici App)"
    invoke-direct v3, v4, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v3
    invoke-static v3, v4, Lcom/bytedance/applog/AppLog;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public setNewUserMode(android.content.Context  boolean  boolean)boolean
    .registers 6
    # ins_size=4
    const-string v0, "context"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lcom/bytedance/applog/AppLog;->isNewUserModeAvailable()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +014h
    invoke-static v3, Lcom/bytedance/applog/AppLog;->newUserMode(Landroid/content/Context;)Lcom/bytedance/bdinstall/service/NUApi;
    move-result-object v3
    if-eqz v3, +00eh
    invoke-interface v3, v4, Lcom/bytedance/bdinstall/service/NUApi;->setNUMode(Z)Lcom/bytedance/bdinstall/nu/Action;
    move-result-object v3
    invoke-interface v3, v5, Lcom/bytedance/bdinstall/nu/Action;->setAutoMode(Z)Lcom/bytedance/bdinstall/nu/Action;
    move-result-object v3
    invoke-interface v3, Lcom/bytedance/bdinstall/nu/Action;->done()V
    const/4 v1, 1
    return v1
.end method

.method public setSwitchToBdtracker(boolean)void
    .registers 2
    # ins_size=2
    invoke-static v1, Lcom/ss/android/common/applog/AppLog;->setSwitchToBdtracker(Z)V
    return-void 
.end method

.method public final setVidsFromAbTest(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromAbTest Ljava/lang/String;
    return-void 
.end method

.method public final setVidsFromSettings(java.lang.String)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/applog/impl/ApplogImpl;->vidsFromSettings Ljava/lang/String;
    return-void 
.end method
