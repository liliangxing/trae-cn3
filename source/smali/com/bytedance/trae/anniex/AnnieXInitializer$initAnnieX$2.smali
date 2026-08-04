# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$2;
.super Ljava/lang/Object;
.source "AnnieXInitializer.kt"

.implements Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;


.method constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getAppId()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v0
    return v0
.end method

.method public getAppName()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getApplication()android.app.Application
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    return-object v0
.end method

.method public getApplicationContext()android.content.Context
    .registers 2
    # ins_size=1
    invoke-static v1, Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend$DefaultImpls;->getApplicationContext(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;)Landroid/content/Context;
    move-result-object v0
    return-object v0
.end method

.method public getBoeChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnv()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getCurrentTelcomCarrier()java.lang.String
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return-object v0
.end method

.method public getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getLanguage()java.lang.String
    .registers 3
    # ins_size=1
    invoke-static Ljava/util/Locale;->getDefault()Ljava/util/Locale;
    move-result-object v0
    invoke-virtual v0, Ljava/util/Locale;->getLanguage()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getLanguage(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getPPEChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnv()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getPackageName()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    invoke-virtual v0, Landroid/app/Application;->getPackageName()Ljava/lang/String;
    move-result-object v0
    const-string v1, "getPackageName(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v0
.end method

.method public getSettings(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    const-string/jumbo v0, settingKeys
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public getSkinName()java.lang.String
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$2;->getSkinType()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getSkinType()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-virtual v0, Lcom/bytedance/trae/common/theme/ThemeManager;->isDarkMode()Z
    move-result v0
    if-eqz v0, +005h
    const-string v0, "black"
    goto +4h
    const-string/jumbo v0, white
    return-object v0
.end method

.method public getUpdateVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v0
    invoke-static v0, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getVersionCode()long
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v0
    int-to-long v0, v0
    return-wide v0
.end method

.method public getVersionName()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public isBaseMode()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public isBoeEnable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getBoeEnable()Z
    move-result v0
    return v0
.end method

.method public isDebuggable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    return v0
.end method

.method public isPPEEnable()boolean
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;->getPpeEnable()Z
    move-result v0
    return v0
.end method

.method public isTeenMode()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 0
    return v0
.end method
