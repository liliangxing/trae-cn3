# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/share/SharePanelService;
.super Ljava/lang/Object;
.source "SharePanelService.kt"

.field private final TAG:Ljava/lang/String;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    const-string v0, "SharePanelService"
    iput-object v0, v1, Lcom/bytedance/trae/conversation/share/SharePanelService;->TAG Ljava/lang/String;
    return-void 
.end method

.method public final init()void
    .registers 6
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const-string v1, ""
    if-eqz v0, +00eh
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v1
    new-instance v2, Ljava/lang/StringBuilder;
    invoke-direct v2, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v2, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string/jumbo v2, share
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/keva/Keva;->getRepo(Ljava/lang/String;)Lcom/bytedance/keva/Keva;
    move-result-object v0
    const-string/jumbo v2, weixin
    invoke-virtual v0, v2, v1, Lcom/bytedance/keva/Keva;->getString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    invoke-direct v1, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;-><init>()V
    new-instance v2, Lcom/bytedance/trae/conversation/share/ShareAppConfigImpl;
    invoke-direct v2, Lcom/bytedance/trae/conversation/share/ShareAppConfigImpl;-><init>()V
    check-cast v2, Lcom/bytedance/ug/sdk/share/api/depend/IShareAppConfig;
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setAppConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareAppConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/share/ShareEventConfigImpl;
    invoke-direct v2, Lcom/bytedance/trae/conversation/share/ShareEventConfigImpl;-><init>()V
    check-cast v2, Lcom/bytedance/ug/sdk/share/api/depend/IShareEventConfig;
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setEventConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareEventConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setLifecycleConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareLifecycleConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;
    invoke-direct v3, Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;-><init>()V
    check-cast v3, Lcom/bytedance/ug/sdk/share/api/depend/ISharePermissionConfig;
    invoke-virtual v1, v3, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setPermissionConfig(Lcom/bytedance/ug/sdk/share/api/depend/ISharePermissionConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    new-instance v3, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;
    const/4 v4, 1
    invoke-direct v3, v2, v4, v2, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;-><init>(Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v3, Lcom/bytedance/ug/sdk/share/api/depend/IShareKeyConfig;
    invoke-virtual v1, v3, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setKeyConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareKeyConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl;
    invoke-direct v2, Lcom/bytedance/trae/conversation/share/ShareNetworkImpl;-><init>()V
    check-cast v2, Lcom/bytedance/ug/sdk/share/api/depend/IShareNetworkConfig;
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setNetworkConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareNetworkConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    new-instance v2, Lcom/bytedance/trae/conversation/share/ShareUIConfigImpl;
    invoke-direct v2, Lcom/bytedance/trae/conversation/share/ShareUIConfigImpl;-><init>()V
    check-cast v2, Lcom/bytedance/ug/sdk/share/api/depend/IShareUIConfig;
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setUIConfig(Lcom/bytedance/ug/sdk/share/api/depend/IShareUIConfig;)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    const/4 v2, 0
    invoke-virtual v1, v2, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setBoe(Z)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    invoke-virtual v1, v4, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->setDebug(Z)Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig$Builder;->build()Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig;
    move-result-object v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    move-result v0
    if-nez v0, +007h
    sget-object v0, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl;->Companion Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;
    invoke-virtual v0, v4, Lcom/bytedance/trae/conversation/share/ShareKeyConfigImpl$Companion;->setWEIXIN_KEY_AVAILABLE(Z)V
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-static v0, v1, Lcom/bytedance/ug/sdk/share/ShareSdk;->init(Landroid/app/Application; Lcom/bytedance/ug/sdk/share/api/depend/ShareConfig;)V
    return-void 
.end method
