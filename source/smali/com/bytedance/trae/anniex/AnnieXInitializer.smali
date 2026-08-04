# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/anniex/AnnieXInitializer;
.super Ljava/lang/Object;
.source "AnnieXInitializer.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/anniex/AnnieXInitializer;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;
    invoke-direct v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;->INSTANCE Lcom/bytedance/trae/anniex/AnnieXInitializer;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final init()void
    .registers 4
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "AnnieX init start"
    const-string v3, "AnnieXInitializer"
    invoke-virtual v1, v3, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/anniex/AnnieXInitializer;->INSTANCE Lcom/bytedance/trae/anniex/AnnieXInitializer;
    invoke-direct v1, v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;->tryInitPiaEnv(Landroid/app/Application;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;->initGecko(Landroid/app/Application;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/anniex/AnnieXInitializer;->initAnnieX(Landroid/app/Application;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v1, "AnnieX init success"
    invoke-virtual v0, v3, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method private final initAnnieX(android.app.Application)void
    .registers 22
    # ins_size=2
    move-object/from16 v0, v21
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v1
    new-instance v2, Lcom/bytedance/ies/bullet/core/common/DebugInfo;
    invoke-direct v2, Lcom/bytedance/ies/bullet/core/common/DebugInfo;-><init>()V
    invoke-virtual v2, v1, Lcom/bytedance/ies/bullet/core/common/DebugInfo;->setShowDebugTagView(Z)V
    const-string v3, "Trae"
    invoke-virtual v2, v3, Lcom/bytedance/ies/bullet/core/common/DebugInfo;->setDebugTagPrefix(Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/ies/bullet/base/InitializeConfig;
    const-string v4, "default_bid"
    invoke-direct v3, v0, v4, Lcom/bytedance/ies/bullet/base/InitializeConfig;-><init>(Landroid/app/Application; Ljava/lang/String;)V
    invoke-virtual v3, v1, Lcom/bytedance/ies/bullet/base/InitializeConfig;->setDebuggable(Z)V
    invoke-virtual v3, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->setDebugInfo(Lcom/bytedance/ies/bullet/core/common/DebugInfo;)V
    new-instance v2, Lcom/bytedance/ies/bullet/service/schema/BulletGlobalSchemaConfig;
    invoke-direct v2, v4, Lcom/bytedance/ies/bullet/service/schema/BulletGlobalSchemaConfig;-><init>(Ljava/lang/String;)V
    check-cast v2, Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;
    invoke-virtual v3, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->setSchemaConfig(Lcom/bytedance/ies/bullet/service/sdk/GlobalSchemaConfig;)V
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v2
    invoke-static v2, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v8
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    move-object v7, v2
    check-cast v7, Ljava/util/List;
    sget-object v2, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v9
    sget-object v2, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v2, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v10
    new-instance v2, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;
    const-string v12, "2373bbcf94c1b893dad48961d0a2d086"
    const-string v13, "offlineX"
    new-instance v4, Lcom/bytedance/ies/bullet/kit/resourceloader/GeckoXDepender;
    invoke-direct v4, Lcom/bytedance/ies/bullet/kit/resourceloader/GeckoXDepender;-><init>()V
    move-object v14, v4
    check-cast v14, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender;
    const/4 v15, 0
    const/16 v16, 0
    const/16 v17, 24
    const/16 v18, 0
    move-object v11, v2
    invoke-direct/range v11 ... v18, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ILoaderDepender; Z Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    new-instance v4, Lcom/bytedance/ies/bullet/kit/resourceloader/DownloaderDepend;
    invoke-direct v4, Lcom/bytedance/ies/bullet/kit/resourceloader/DownloaderDepend;-><init>()V
    new-instance v15, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;
    const-string v5, "gecko.snssdk.com"
    const-string v6, "CN"
    const/4 v12, 0
    move-object v13, v4
    check-cast v13, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender;
    const/4 v14, 0
    const/16 v16, 0
    const/16 v17, 0
    const/16 v18, 3712
    const/16 v19, 0
    move-object v4, v15
    move-object v2, v15
    move-object/from16 v15, v16
    move/from16 v16, v17
    move/from16 v17, v18
    move-object/from16 v18, v19
    invoke-direct/range v4 ... v18, Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/util/List; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/ies/bullet/service/base/resourceloader/config/GeckoConfig; Ljava/util/Map; Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ICdnDownloadDepender; Ljava/lang/Object; Ljava/lang/Object; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v3, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->setResourceLoaderConfig(Lcom/bytedance/ies/bullet/service/base/resourceloader/config/ResourceLoaderConfig;)V
    new-instance v2, Lcom/bytedance/ies/bullet/service/page/PageConfig;
    const-class v4, Lcom/bytedance/trae/anniex/AnnieXHostActivity;
    invoke-direct v2, v4, Lcom/bytedance/ies/bullet/service/page/PageConfig;-><init>(Ljava/lang/Class;)V
    check-cast v2, Lcom/bytedance/ies/bullet/service/base/IPageConfig;
    invoke-virtual v3, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->setPageConfig(Lcom/bytedance/ies/bullet/service/base/IPageConfig;)V
    const-class v2, Lcom/bytedance/ies/bullet/service/base/web/IWebKitService;
    new-instance v4, Lcom/bytedance/ies/bullet/service/webkit/WebKitService;
    const/4 v5, 3
    const/4 v6, 0
    invoke-direct v4, v6, v6, v5, v6, Lcom/bytedance/ies/bullet/service/webkit/WebKitService;-><init>(Lcom/bytedance/ies/bullet/service/base/IKitConfig; Lcom/bytedance/ies/bullet/service/webkit/IWebKitDelegateProvider; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v4, Lcom/bytedance/ies/bullet/service/base/api/IBulletService;
    invoke-virtual v3, v2, v4, Lcom/bytedance/ies/bullet/base/InitializeConfig;->addService(Ljava/lang/Class; Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V
    const-class v2, Lcom/bytedance/ies/bullet/kit/web/service/IWebGlobalConfigService;
    new-instance v4, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;
    invoke-direct v4, Lcom/bytedance/trae/anniex/TraeWebGlobalConfigService;-><init>()V
    check-cast v4, Lcom/bytedance/ies/bullet/service/base/api/IBulletService;
    invoke-virtual v3, v2, v4, Lcom/bytedance/ies/bullet/base/InitializeConfig;->addService(Ljava/lang/Class; Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V
    new-instance v2, Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;
    invoke-direct v2, v0, Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;-><init>(Landroid/app/Application;)V
    invoke-virtual v2, v1, Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;->setDebug(Z)Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/ies/bullet/lynx/init/LynxConfig$Builder;->build()Lcom/bytedance/ies/bullet/lynx/init/LynxConfig;
    move-result-object v1
    const-class v2, Lcom/bytedance/ies/bullet/service/base/lynx/ILynxKitService;
    new-instance v4, Lcom/bytedance/ies/bullet/lynx/LynxKitService;
    check-cast v1, Lcom/bytedance/ies/bullet/service/base/IKitConfig;
    const/4 v5, 2
    invoke-direct v4, v1, v6, v5, v6, Lcom/bytedance/ies/bullet/lynx/LynxKitService;-><init>(Lcom/bytedance/ies/bullet/service/base/IKitConfig; Lcom/bytedance/ies/bullet/lynx/ILynxDelegateProvider; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v4, Lcom/bytedance/ies/bullet/service/base/api/IBulletService;
    invoke-virtual v3, v2, v4, Lcom/bytedance/ies/bullet/base/InitializeConfig;->addService(Ljava/lang/Class; Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V
    const-class v1, Lcom/bytedance/ies/bullet/core/kit/service/IBridgeService;
    new-instance v2, Lcom/bytedance/trae/anniex/DefaultBridgeService;
    invoke-direct v2, Lcom/bytedance/trae/anniex/DefaultBridgeService;-><init>()V
    check-cast v2, Lcom/bytedance/ies/bullet/service/base/api/IBulletService;
    invoke-virtual v3, v1, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->addService(Ljava/lang/Class; Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V
    const-class v1, Lcom/bytedance/android/anniex/ability/service/IAnnieXPiaMethodProvider;
    new-instance v2, Lcom/bytedance/android/anniex/ability/DefaultAnnieXPIAMethodProvider;
    invoke-direct v2, Lcom/bytedance/android/anniex/ability/DefaultAnnieXPIAMethodProvider;-><init>()V
    check-cast v2, Lcom/bytedance/ies/bullet/service/base/api/IBulletService;
    invoke-virtual v3, v1, v2, Lcom/bytedance/ies/bullet/base/InitializeConfig;->addService(Ljava/lang/Class; Lcom/bytedance/ies/bullet/service/base/api/IBulletService;)V
    sget-object v1, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    invoke-virtual v1, v3, Lcom/bytedance/android/anniex/assemble/AnnieX;->init(Lcom/bytedance/ies/bullet/base/InitializeConfig;)V
    sget-object v1, Lcom/bytedance/android/anniex/assemble/AnnieX;->INSTANCE Lcom/bytedance/android/anniex/assemble/AnnieX;
    check-cast v0, Landroid/content/Context;
    invoke-virtual v1, v0, Lcom/bytedance/android/anniex/assemble/AnnieX;->ensureLynxInitialized(Landroid/content/Context;)V
    sget-object v0, Lcom/bytedance/sdk/xbridge/cn/auth/BDXBridgePermission;->INSTANCE Lcom/bytedance/sdk/xbridge/cn/auth/BDXBridgePermission;
    new-instance v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;
    invoke-direct v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$1;-><init>()V
    check-cast v1, Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;
    invoke-virtual v0, v1, Lcom/bytedance/sdk/xbridge/cn/auth/BDXBridgePermission;->init(Lcom/bytedance/sdk/xbridge/cn/auth/IPermissionConfigProvider;)V
    sget-object v0, Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XBaseRuntime;->INSTANCE Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XBaseRuntime;
    new-instance v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$2;
    invoke-direct v1, Lcom/bytedance/trae/anniex/AnnieXInitializer$initAnnieX$2;-><init>()V
    check-cast v1, Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;
    invoke-virtual v0, v1, Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XBaseRuntime;->setHostContextDepend(Lcom/bytedance/sdk/xbridge/cn/runtime/depend/IHostContextDepend;)Lcom/bytedance/sdk/xbridge/cn/runtime/depend/XBaseRuntime;
    return-void 
.end method

.method private final initGecko(android.app.Application)void
    .registers 6
    # ins_size=2
    invoke-static Lcom/bytedance/geckox/logger/GeckoLogger;->enable()V
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getDeviceId()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +005h
    const-string/jumbo v0, unknown
    check-cast v0, Ljava/lang/String;
    new-instance v1, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    check-cast v5, Landroid/content/Context;
    invoke-direct v1, v5, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;-><init>(Landroid/content/Context;)V
    sget-object v5, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v5, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v5
    int-to-long v2, v5
    invoke-virtual v1, v2, v3, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->appId(J)Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    move-result-object v5
    const-string/jumbo v1, trae
    invoke-virtual v5, v1, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->host(Ljava/lang/String;)Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    move-result-object v5
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v5, v1, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->appVersion(Ljava/lang/String;)Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    move-result-object v5
    invoke-virtual v5, v0, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->deviceId(Ljava/lang/String;)Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    move-result-object v5
    sget-object v0, Lcom/bytedance/geckox/GeckoGlobalConfig$ENVType;->PROD Lcom/bytedance/geckox/GeckoGlobalConfig$ENVType;
    invoke-virtual v5, v0, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->env(Lcom/bytedance/geckox/GeckoGlobalConfig$ENVType;)Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/geckox/GeckoGlobalConfig$Builder;->build()Lcom/bytedance/geckox/GeckoGlobalConfig;
    move-result-object v5
    invoke-static Lcom/bytedance/geckox/GeckoGlobalManager;->inst()Lcom/bytedance/geckox/GeckoGlobalManager;
    move-result-object v0
    invoke-virtual v0, v5, Lcom/bytedance/geckox/GeckoGlobalManager;->init(Lcom/bytedance/geckox/GeckoGlobalConfig;)V
    invoke-static Lcom/bytedance/geckox/GeckoGlobalManager;->inst()Lcom/bytedance/geckox/GeckoGlobalManager;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/geckox/GeckoGlobalManager;->syncGlobalSettings()V
    return-void 
.end method

.method private final tryInitPiaEnv(android.app.Application)void
    .registers 8
    # ins_size=2
    const-string v0, "com.bytedance.pia.core.api.PiaEnv$Default"
    invoke-static v0, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v0
    const-string/jumbo v1, setApplicationContext
    const/4 v2, 1
    new-array v3, v2, [Ljava/lang/Class;
    const-class v4, Landroid/content/Context;
    const/4 v5, 0
    aput-object v4, v3, v5
    invoke-virtual v0, v1, v3, Ljava/lang/Class;->getMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v0
    new-array v1, v2, [Ljava/lang/Object;
    aput-object v7, v1, v5
    const/4 v7, 0
    invoke-virtual v0, v7, v1, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
    :try_start_0x0
.end method
