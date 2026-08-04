# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
.super Ljava/lang/Object;
.source "TobAppLogBridge.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
.field private static final TOB_AID:Ljava/lang/String;
.field private static final TOB_DOMAIN:Ljava/lang/String;
.field private static bridge tobAppLogInstance:Lcom/bytedance/tobshadow/applog/IAppLogInstance;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    invoke-direct v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;-><init>()V
    sput-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->INSTANCE Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getDid()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->getDid()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public final init(com.bytedance.trae.applog.api.AppLogConfigInfo)boolean
    .registers 6
    # ins_size=2
    const-string v0, "configInfo"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;
    new-instance v0, Lcom/bytedance/tobshadow/applog/InitConfig;
    const-string v2, "20014039"
    invoke-virtual v5, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getChannel()Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v2, v3, Lcom/bytedance/tobshadow/applog/InitConfig;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getAppName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setAppName(Ljava/lang/String;)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getVersionName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setVersion(Ljava/lang/String;)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getVersionCode()I
    move-result v2
    invoke-virtual v0, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setVersionCode(I)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v0
    invoke-virtual v5, Lcom/bytedance/trae/applog/api/AppLogConfigInfo;->getUpdateVersionCode()I
    move-result v5
    invoke-virtual v0, v5, Lcom/bytedance/tobshadow/applog/InitConfig;->setUpdateVersionCode(I)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    invoke-virtual v5, v1, Lcom/bytedance/tobshadow/applog/InitConfig;->setAutoStart(Z)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    const/4 v2, 0
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    invoke-virtual v5, v0, Lcom/bytedance/tobshadow/applog/InitConfig;->setLocalTest(Z)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v0
    if-nez v0, +00dh
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isTestChannel()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v1
    invoke-virtual v5, v0, Lcom/bytedance/tobshadow/applog/InitConfig;->setLogEnable(Z)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    const-string/jumbo v0, tob_applog.db
    invoke-virtual v5, v0, Lcom/bytedance/tobshadow/applog/InitConfig;->setDbName(Ljava/lang/String;)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    const-string/jumbo v0, tob_applog_sp
    invoke-virtual v5, v0, Lcom/bytedance/tobshadow/applog/InitConfig;->setSpName(Ljava/lang/String;)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    const-string v0, "https://gator.volces.com"
    const/4 v3, 0
    invoke-static v0, v3, Lcom/bytedance/tobshadow/applog/UriConfig;->createByDomain(Ljava/lang/String; [Ljava/lang/String;)Lcom/bytedance/tobshadow/applog/UriConfig;
    move-result-object v0
    invoke-virtual v5, v0, Lcom/bytedance/tobshadow/applog/InitConfig;->setUriConfig(Lcom/bytedance/tobshadow/applog/UriConfig;)Lcom/bytedance/tobshadow/applog/InitConfig;
    move-result-object v5
    invoke-virtual v5, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setHandleLifeCycle(Z)V
    invoke-virtual v5, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setAbEnable(Z)V
    invoke-virtual v5, v2, Lcom/bytedance/tobshadow/applog/InitConfig;->setAutoTrackEnabled(Z)V
    invoke-virtual v5, v1, Lcom/bytedance/tobshadow/applog/InitConfig;->setTrackEventEnabled(Z)V
    invoke-static Lcom/bytedance/tobshadow/applog/AppLog;->newInstance()Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    move-result-object v0
    sget-object v3, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v3, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isDebug()Z
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v1, v2
    invoke-interface v0, v1, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->setEncryptAndCompress(Z)V
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-interface v0, v1, v5, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->init(Landroid/content/Context; Lcom/bytedance/tobshadow/applog/InitConfig;)V
    sput-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->isSuccess-impl(Ljava/lang/Object;)Z
    move-result v5
    return v5
    :try_start_0xb
.end method

.method public final isSupported()boolean
    .registers 2
    # ins_size=1
    const/4 v0, 1
    return v0
.end method

.method public final onEventV3(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "event"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->onEventV3(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final onMiscEvent(java.lang.String  org.json.JSONObject)void
    .registers 4
    # ins_size=3
    const-string v0, "logType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "params"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->onMiscEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method

.method public final setHeaderInfo(java.lang.String  java.lang.String)void
    .registers 4
    # ins_size=3
    const-string v0, "key"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, value
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    if-eqz v0, +005h
    invoke-interface v0, v2, v3, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->setHeaderInfo(Ljava/lang/String; Ljava/lang/Object;)V
    return-void 
.end method

.method public final setUserUniqueID(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, userId
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/applog/impl/TobAppLogBridge;->tobAppLogInstance Lcom/bytedance/tobshadow/applog/IAppLogInstance;
    if-eqz v0, +005h
    invoke-interface v0, v2, Lcom/bytedance/tobshadow/applog/IAppLogInstance;->setUserUniqueID(Ljava/lang/String;)V
    return-void 
.end method
