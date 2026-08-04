# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;
.super Ljava/lang/Object;
.source "SettingsConfigProviderImpl.kt"

.implements Lcom/bytedance/news/common/settings/SettingsConfigProvider;

.field private requestParamsModel:Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
.field private final settingsAbVersionService:Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;
.field private settingsConfig:Lcom/bytedance/news/common/settings/SettingsConfig;
.field private settingsLazyConfig:Lcom/bytedance/news/common/settings/SettingsLazyConfig;
.field private final settingsRequestService:Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;
    invoke-direct v0, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsRequestService Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;
    new-instance v0, Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;
    invoke-direct v0, Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsAbVersionService Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;
    return-void 
.end method

.method private final getRequestParamsModel()com.bytedance.news.common.settings.api.model.SettingsRequestParamsModel
    .registers 8
    # ins_size=1
    iget-object v0, v7, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->requestParamsModel Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +071h
    new-instance v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
    invoke-direct v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;-><init>()V
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v3
    iput v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->appId I
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v3
    iput-object v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->channel Ljava/lang/String;
    const-string v3, "android"
    iput-object v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->devicePlatform Ljava/lang/String;
    sget-object v3, Landroid/os/Build;->BRAND Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->deviceBrand Ljava/lang/String;
    sget-object v3, Landroid/os/Build;->MODEL Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->deviceType Ljava/lang/String;
    sget v3, Landroid/os/Build$VERSION;->SDK_INT I
    iput v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->osApi I
    sget-object v3, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    iput-object v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->osVersion Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v3
    iput v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->versionCode I
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v3
    iput v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->updateVersionCode I
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +008h
    invoke-static v3, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->iid J
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +008h
    invoke-static v3, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v1
    iput-wide v1, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->deviceId J
    iput-object v0, v7, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->requestParamsModel Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
    goto +44h
    if-eqz v0, +043h
    iget-wide v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->iid J
    const-wide/16 v5, 0
    cmp-long v3, v3, v5
    if-nez v3, +01ch
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +008h
    invoke-static v3, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v3
    iput-wide v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->iid J
    iget-wide v3, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->deviceId J
    cmp-long v3, v3, v5
    if-nez v3, +01bh
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v4
    if-lez v4, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +008h
    invoke-static v3, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    move-result-wide v1
    iput-wide v1, v0, Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;->deviceId J
    iget-object v0, v7, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->requestParamsModel Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
    :try_start_0x53
    :try_start_0x6c
    :try_start_0x93
    :try_start_0xb2
.end method

.method public getConfig()com.bytedance.news.common.settings.SettingsConfig
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsConfig Lcom/bytedance/news/common/settings/SettingsConfig;
    if-nez v0, +039h
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    check-cast v0, Landroid/content/Context;
    invoke-static v0, Lcom/bytedance/trae/utils/AppUtils;->isMainProcess(Landroid/content/Context;)Z
    move-result v1
    new-instance v2, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    invoke-direct v2, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;-><init>()V
    invoke-virtual v2, v0, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->context(Landroid/content/Context;)Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    move-result-object v0
    iget-object v2, v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsRequestService Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;
    check-cast v2, Lcom/bytedance/news/common/settings/api/RequestService;
    invoke-virtual v0, v2, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->requestService(Lcom/bytedance/news/common/settings/api/RequestService;)Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    move-result-object v0
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->isMainProcess(Z)Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsAbVersionService Lcom/bytedance/trae/settings/impl/SettingsAbVersionServiceImpl;
    check-cast v1, Lcom/bytedance/news/common/settings/api/SettingsAbReportService;
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->setAbReportService(Lcom/bytedance/news/common/settings/api/SettingsAbReportService;)Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    move-result-object v0
    invoke-direct v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->getRequestParamsModel()Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->requestParamsModel(Lcom/bytedance/news/common/settings/api/model/SettingsRequestParamsModel;)Lcom/bytedance/news/common/settings/SettingsConfig$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/news/common/settings/SettingsConfig$Builder;->build()Lcom/bytedance/news/common/settings/SettingsConfig;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsConfig Lcom/bytedance/news/common/settings/SettingsConfig;
    iget-object v0, v3, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsConfig Lcom/bytedance/news/common/settings/SettingsConfig;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
.end method

.method public getLazyConfig()com.bytedance.news.common.settings.SettingsLazyConfig
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsLazyConfig Lcom/bytedance/news/common/settings/SettingsLazyConfig;
    if-nez v0, +01eh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    goto +3h
    const-string v0, "0"
    new-instance v1, Lcom/bytedance/news/common/settings/SettingsLazyConfig$Builder;
    invoke-direct v1, Lcom/bytedance/news/common/settings/SettingsLazyConfig$Builder;-><init>()V
    invoke-virtual v1, v0, Lcom/bytedance/news/common/settings/SettingsLazyConfig$Builder;->updateVersionCode(Ljava/lang/String;)Lcom/bytedance/news/common/settings/SettingsLazyConfig$Builder;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/news/common/settings/SettingsLazyConfig$Builder;->build()Lcom/bytedance/news/common/settings/SettingsLazyConfig;
    move-result-object v0
    iput-object v0, v2, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsLazyConfig Lcom/bytedance/news/common/settings/SettingsLazyConfig;
    iget-object v0, v2, Lcom/bytedance/trae/settings/impl/SettingsConfigProviderImpl;->settingsLazyConfig Lcom/bytedance/news/common/settings/SettingsLazyConfig;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    return-object v0
    :try_start_0x4
.end method
