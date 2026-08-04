# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;
.super Ljava/lang/Object;
.source "MultiInstanceAppLogServiceImpl.kt"

.implements Lcom/bytedance/trae/applog/api/IMultiInstanceAppLog;

.field private final instance:Lcom/bytedance/applog/IAppLogInstance;


.method public constructor <init>(com.bytedance.applog.IAppLogInstance)void
    .registers 3
    # ins_size=2
    const-string v0, "instance"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    return-void 
.end method

.method public init(android.content.Context  com.bytedance.trae.applog.api.MultiInstanceAppLogInitConfig)void
    .registers 8
    # ins_size=3
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "config"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/applog/InitConfig;
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getChannel()Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v1, v2, Lcom/bytedance/applog/InitConfig;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getAppName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setAppName(Ljava/lang/String;)Lcom/bytedance/applog/InitConfig;
    sget-object v1, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->isBoe()Z
    move-result v2
    invoke-virtual v1, v2, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->uriConfig(Z)Lcom/bytedance/applog/UriConfig;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setUriConfig(Lcom/bytedance/applog/UriConfig;)Lcom/bytedance/applog/InitConfig;
    new-instance v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogNetworkClient;
    invoke-direct v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogNetworkClient;-><init>()V
    check-cast v1, Lcom/bytedance/bdinstall/INetworkClient;
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setNetworkClient(Lcom/bytedance/bdinstall/INetworkClient;)Lcom/bytedance/applog/InitConfig;
    const/4 v1, 1
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setAutoStart(Z)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v0, v1, Lcom/bytedance/applog/InitConfig;->setHandleLifeCycle(Z)V
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getVersionCode()I
    move-result v2
    int-to-long v2, v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/applog/InitConfig;->setVersionCode(J)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getVersionName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setVersion(Ljava/lang/String;)Lcom/bytedance/applog/InitConfig;
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getUpdateVersinCode()I
    move-result v2
    int-to-long v2, v2
    invoke-virtual v0, v2, v3, Lcom/bytedance/applog/InitConfig;->setUpdateVersionCode(J)Lcom/bytedance/applog/InitConfig;
    new-instance v2, Lcom/bytedance/trae/applog/impl/AppLogLogger;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "AppLog_"
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/applog/api/MultiInstanceAppLogInitConfig;->getAppId()I
    move-result v7
    invoke-virtual v3, v7, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-direct v2, v7, Lcom/bytedance/trae/applog/impl/AppLogLogger;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/bdinstall/ILogger;
    invoke-virtual v0, v2, Lcom/bytedance/applog/InitConfig;->setLogger(Lcom/bytedance/bdinstall/ILogger;)Lcom/bytedance/applog/InitConfig;
    sget-object v7, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->INSTANCE Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;
    invoke-virtual v7, v0, Lcom/bytedance/trae/applog/impl/BDTrackerConfigs;->configSensitiveApi(Lcom/bytedance/applog/InitConfig;)V
    iget-object v7, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v2
    xor-int/2addr v2, v1
    invoke-interface v7, v2, Lcom/bytedance/applog/IAppLogInstance;->setEncryptAndCompress(Z)V
    iget-object v7, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v7, v6, v0, Lcom/bytedance/applog/IAppLogInstance;->init(Landroid/content/Context; Lcom/bytedance/applog/InitConfig;)V
    iget-object v6, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v7
    check-cast v7, Landroid/content/Context;
    invoke-static v7, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/news/common/settings/api/exposed/ExposedManager;->getExposedVids()Ljava/lang/String;
    move-result-object v7
    invoke-interface v6, v7, Lcom/bytedance/applog/IAppLogInstance;->setExternalAbVersion(Ljava/lang/String;)V
    iget-object v6, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    new-instance v7, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogDataObserver;
    invoke-direct v7, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLogDataObserver;-><init>()V
    check-cast v7, Lcom/bytedance/applog/IDataObserver;
    invoke-interface v6, v7, Lcom/bytedance/applog/IAppLogInstance;->addDataObserver(Lcom/bytedance/applog/IDataObserver;)V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v6
    if-nez v6, +00ah
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v6
    if-eqz v6, +03eh
    iget-object v6, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v6, Lcom/bytedance/applog/IAppLogInstance;->getAppId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/String;->toString()Ljava/lang/String;
    move-result-object v6
    sget-object v7, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v7
    check-cast v7, Landroid/content/Context;
    invoke-static v6, v1, v7, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventsSenderEnable(Ljava/lang/String; Z Landroid/content/Context;)V
    sget-object v6, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v6, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v6
    if-eqz v6, +012h
    iget-object v6, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v6, Lcom/bytedance/applog/IAppLogInstance;->getAppId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/String;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "https://log.byteoversea.net"
    invoke-static v6, v7, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventVerifyHost(Ljava/lang/String; Ljava/lang/String;)V
    goto +10h
    iget-object v6, v5, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v6, Lcom/bytedance/applog/IAppLogInstance;->getAppId()Ljava/lang/String;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/String;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v7, "https://log.snssdk.com"
    invoke-static v6, v7, Lcom/bytedance/applog/util/EventsSenderUtils;->setEventVerifyHost(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public removeHeaderInfo(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, Lcom/bytedance/applog/IAppLogInstance;->removeHeaderInfo(Ljava/lang/String;)V
    return-void 
.end method

.method public reportEvent(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, Lcom/bytedance/applog/IAppLogInstance;->onEventV3(Ljava/lang/String;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, v3, Lcom/bytedance/applog/IAppLogInstance;->onEventV3(Ljava/lang/String; Landroid/os/Bundle;)V
    return-void 
.end method

.method public reportEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, v3, Lcom/bytedance/applog/IAppLogInstance;->onEventV3(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public setHeaderInfo(java.lang.String  java.lang.Object)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, v3, Lcom/bytedance/applog/IAppLogInstance;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public setHeaderInfo(java.util.HashMap)void
    .registers 3
    # ins_size=2
    const-string v0, "custom"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/applog/impl/MultiInstanceAppLog;->instance Lcom/bytedance/applog/IAppLogInstance;
    invoke-interface v0, v2, Lcom/bytedance/applog/IAppLogInstance;->setHeaderInfo(Ljava/util/HashMap;)V
    return-void 
.end method
