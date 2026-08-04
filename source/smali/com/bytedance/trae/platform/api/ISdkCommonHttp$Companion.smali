# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
.super Ljava/lang/Object;
.source "ISdkCommonHttp.kt"

.implements Lcom/bytedance/trae/platform/api/ISdkCommonHttp;

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
.field private static final service$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$Shu8kOnsJC1uMCtbPuQ7U6yqV-U()com.bytedance.trae.platform.api.ISdkCommonHttp
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->service_delegate$lambda$0()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    invoke-direct v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->$$INSTANCE Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;
    new-instance v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->service$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final getService()com.bytedance.trae.platform.api.ISdkCommonHttp
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->service$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    return-object v0
.end method

.method private static final service_delegate$lambda$0()com.bytedance.trae.platform.api.ISdkCommonHttp
    .registers 2
    # ins_size=0
    const-class v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/platform/ITraeSdkCommonDepend;->getCommonHttpService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    return-object v0
.end method

.method public getBoeBaseUrl()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getBoeBaseUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getBoeHost()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getBoeHost()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getCommonAppendHeaders()java.util.Map
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getCommonAppendHeaders()Ljava/util/Map;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public getCommonParams()java.util.Map
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getCommonParams()Ljava/util/Map;
    move-result-object v0
    if-nez v0, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public getFrontierUserId()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getFrontierUserId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getHttpEnvConfig()com.bytedance.trae.platform.model.HttpEnvConfig
    .registers 9
    # ins_size=1
    invoke-direct v8, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getHttpEnvConfig()Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    move-result-object v0
    if-nez v0, +00fh
    new-instance v0, Lcom/bytedance/trae/platform/model/HttpEnvConfig;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/16 v6, 15
    const/4 v7, 0
    move-object v1, v0
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/platform/model/HttpEnvConfig;-><init>(Z Ljava/lang/String; Z Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method

.method public getOnlineBaseUrl()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getOnlineBaseUrl()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getOnlineHost()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getOnlineHost()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method

.method public getPluginVersion()int
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +007h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getPluginVersion()I
    move-result v0
    goto +2h
    const/4 v0, -1
    return v0
.end method

.method public getToken()java.lang.String
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/bytedance/trae/platform/api/ISdkCommonHttp$Companion;->getService()Lcom/bytedance/trae/platform/api/ISdkCommonHttp;
    move-result-object v0
    if-eqz v0, +008h
    invoke-interface v0, Lcom/bytedance/trae/platform/api/ISdkCommonHttp;->getToken()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +004h
    const-string v0, ""
    return-object v0
.end method
