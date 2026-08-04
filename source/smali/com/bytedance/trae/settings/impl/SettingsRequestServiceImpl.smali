# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;
.super Ljava/lang/Object;
.source "SettingsRequestServiceImpl.kt"

.implements Lcom/bytedance/news/common/settings/api/RequestService;

.field public static final Companion:Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$Companion;
.field private static final SETTINGS_PATH:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;->Companion Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildRequestParams()java.util.Map
    .registers 5
    # ins_size=1
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getDeviceId()Ljava/lang/String;
    move-result-object v1
    const-string v2, "device_id"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/applog/api/IApplog$Companion;->getInstallId()Ljava/lang/String;
    move-result-object v1
    const-string v2, "iid"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getAppId()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    const-string v2, "aid"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionName()Ljava/lang/String;
    move-result-object v1
    const-string v2, "app_version"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getVersionCode()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, version_code
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getUpdateVersionCode()I
    move-result v1
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, update_version_code
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getBuildChannel()Ljava/lang/String;
    move-result-object v1
    const-string v2, "channel"
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "device_platform"
    const-string v2, "android"
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "device_brand"
    sget-object v2, Landroid/os/Build;->BRAND Ljava/lang/String;
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string v1, "device_type"
    sget-object v2, Landroid/os/Build;->MODEL Ljava/lang/String;
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v1, os_version
    sget-object v2, Landroid/os/Build$VERSION;->RELEASE Ljava/lang/String;
    invoke-interface v0, v1, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    invoke-static v1, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, os_api
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v1, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->getApplication()Landroid/app/Application;
    move-result-object v1
    check-cast v1, Landroid/content/Context;
    invoke-static v1, Lcom/bytedance/news/common/settings/api/cache/CtxInfoManager;->getInstance(Landroid/content/Context;)Lcom/bytedance/news/common/settings/api/cache/CtxInfoManager;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/news/common/settings/api/cache/CtxInfoManager;->getCtxInfo()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +004h
    const-string v2, ""
    const-string v3, "ctx_infos"
    invoke-interface v0, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v1, Lcom/bytedance/news/common/settings/api/cache/CtxInfoManager;->geSettingsTime()J
    move-result-wide v1
    invoke-static v1, v2, Ljava/lang/String;->valueOf(J)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, settings_time
    invoke-interface v0, v2, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    return-object v0
.end method

.method public request()com.bytedance.news.common.settings.api.Response
    .registers 17
    # ins_size=1
    const-string v1, "Settings"
    const-string v0, "SettingsRequest: success, settingsTime="
    const-string v2, "SettingsRequest: code="
    new-instance v3, Lcom/bytedance/news/common/settings/api/Response;
    invoke-direct v3, Lcom/bytedance/news/common/settings/api/Response;-><init>()V
    const/4 v4, 0
    sget-object v5, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v6, Lcom/bytedance/trae/network/HostType;->SETTINGS Lcom/bytedance/trae/network/HostType;
    invoke-virtual v5, v6, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v5
    sget-object v7, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v8, settings_v3
    const-class v9, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$SettingsApi;
    const/4 v10, 0
    const/4 v12, 0
    const/4 v13, 0
    const/16 v14, 52
    const/4 v15, 0
    move-object v11, v5
    invoke-static/range v7 ... v15, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$SettingsApi;
    invoke-direct/range v16, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;->buildRequestParams()Ljava/util/Map;
    move-result-object v7
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v8, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string/jumbo v8, service/settings/v3/
    invoke-virtual v5, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-interface v6, v5, v7, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl$SettingsApi;->fetchSettings(Ljava/lang/String; Ljava/util/Map;)Lcom/bytedance/retrofit2/Call;
    move-result-object v5
    invoke-interface v5, Lcom/bytedance/retrofit2/Call;->execute()Lcom/bytedance/retrofit2/SsResponse;
    move-result-object v5
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->body()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    sget-object v7, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v8, Ljava/lang/StringBuilder;
    invoke-direct v8, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/retrofit2/SsResponse;->code()I
    move-result v2
    invoke-virtual v8, v2, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    const-string v5, ", bodyLen="
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    if-eqz v6, +007h
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v5
    goto +2h
    move v5, v4
    invoke-virtual v2, v5, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v7, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    move-object v2, v6
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v5, 1
    if-eqz v2, +00bh
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +003h
    goto +3h
    move v2, v4
    goto +2h
    move v2, v5
    if-eqz v2, +00ah
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "SettingsRequest: body is null or empty"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v3
    new-instance v2, Lorg/json/JSONObject;
    invoke-direct v2, v6, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    const-string v6, "data"
    invoke-virtual v2, v6, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v2
    if-nez v2, +00eh
    move-object/from16 v0, v16
    check-cast v0, Lcom/bytedance/trae/settings/impl/SettingsRequestServiceImpl;
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v2, "SettingsRequest: data field is null"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String;)V
    return-object v3
    iput-boolean v5, v3, Lcom/bytedance/news/common/settings/api/Response;->success Z
    const-string/jumbo v5, settings
    invoke-virtual v2, v5, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v5
    if-eqz v5, +00ah
    new-instance v6, Lcom/bytedance/news/common/settings/api/SettingsData;
    const/4 v7, 0
    invoke-direct v6, v5, v7, Lcom/bytedance/news/common/settings/api/SettingsData;-><init>(Lorg/json/JSONObject; Lorg/json/JSONObject;)V
    iput-object v6, v3, Lcom/bytedance/news/common/settings/api/Response;->settingsData Lcom/bytedance/news/common/settings/api/SettingsData;
    const-string/jumbo v5, vid_info
    invoke-virtual v2, v5, Lorg/json/JSONObject;->optJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    move-result-object v5
    iput-object v5, v3, Lcom/bytedance/news/common/settings/api/Response;->vidInfo Lorg/json/JSONObject;
    const-string v5, "ctx_infos"
    const-string v6, ""
    invoke-virtual v2, v5, v6, Lorg/json/JSONObject;->optString(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    iput-object v5, v3, Lcom/bytedance/news/common/settings/api/Response;->ctxInfos Ljava/lang/String;
    const-string/jumbo v5, settings_time
    const-wide/16 v6, 0
    invoke-virtual v2, v5, v6, v7, Lorg/json/JSONObject;->optLong(Ljava/lang/String; J)J
    move-result-wide v5
    iput-wide v5, v3, Lcom/bytedance/news/common/settings/api/Response;->settingsTime J
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v5, Ljava/lang/StringBuilder;
    invoke-direct v5, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-wide v6, v3, Lcom/bytedance/news/common/settings/api/Response;->settingsTime J
    invoke-virtual v5, v6, v7, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +dh
    move-exception v0
    sget-object v2, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    const-string v5, "SettingsRequest: exception "
    check-cast v0, Ljava/lang/Throwable;
    invoke-virtual v2, v1, v5, v0, Lcom/bytedance/trae/utils/logger/FLogger;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    iput-boolean v4, v3, Lcom/bytedance/news/common/settings/api/Response;->success Z
    return-object v3
    :try_start_0xc
.end method
