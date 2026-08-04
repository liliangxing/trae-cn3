# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/service/SdkCommonHttpImpl;
.super Ljava/lang/Object;
.source "SdkCommonHttpImpl.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkCommonHttp;

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/service/SdkCommonHttpImpl;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/service/SdkCommonHttpImpl;
    invoke-direct v0, Lcom/bytedance/trae/service/SdkCommonHttpImpl;-><init>()V
    sput-object v0, Lcom/bytedance/trae/service/SdkCommonHttpImpl;->INSTANCE Lcom/bytedance/trae/service/SdkCommonHttpImpl;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public getBoeBaseUrl()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    invoke-virtual v0, Lcom/bytedance/trae/network/HttpConst;->getBOE()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getBoeHost()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HttpConst;->INSTANCE Lcom/bytedance/trae/network/HttpConst;
    invoke-virtual v0, Lcom/bytedance/trae/network/HttpConst;->getBOE_HOST()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getCommonAppendHeaders()java.util.Map
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUploadRegion()Ljava/lang/String;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
    const-string/jumbo v1, x-user-region
    invoke-static v1, v0, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf(Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public getCommonParams()java.util.Map
    .registers 2
    # ins_size=1
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public getFrontierUserId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->INSTANCE Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;
    invoke-virtual v0, Lcom/bytedance/trae/login/bytecloud/BytecloudAuthManager;->isBytecloudLogin()Z
    move-result v0
    if-eqz v0, +013h
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;
    invoke-virtual v0, Lcom/bytedance/trae/login/traeauth/TraeAuthStorage;->getUserInfo()Lcom/bytedance/trae/login/user/UserInfo;
    move-result-object v0
    if-eqz v0, +008h
    invoke-virtual v0, Lcom/bytedance/trae/login/user/UserInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
    sget-object v0, Lcom/bytedance/trae/platform/service/ApplogService;->INSTANCE Lcom/bytedance/trae/platform/service/ApplogService;
    invoke-virtual v0, Lcom/bytedance/trae/platform/service/ApplogService;->getUserID()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getHttpEnvConfig()com.bytedance.trae.platform.model.HttpEnvConfig
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeTTNet;->INSTANCE Lcom/bytedance/trae/network/TraeTTNet;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeTTNet;->getHttpEnv()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    return-object v0
.end method

.method public getOnlineBaseUrl()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getOnlineHost()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->AI Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public getPluginVersion()int
    .registers 2
    # ins_size=1
    const/4 v0, -1
    return v0
.end method

.method public getToken()java.lang.String
    .registers 3
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method
