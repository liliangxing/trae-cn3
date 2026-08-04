# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
.super Ljava/lang/Object;
.source "SiteMessageApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
.field private static final BOE_BASE_URL:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;->$$INSTANCE Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final createService()com.bytedance.trae.home.solo.sitemessage.ISiteMessageApi
    .registers 12
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    invoke-virtual v0, Lcom/bytedance/trae/network/DebugSettings;->getNotificationBoe()Z
    move-result v0
    if-eqz v0, +005h
    const-string v1, "https://icube-boe-api.bytedance.net"
    goto +9h
    sget-object v1, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v2, Lcom/bytedance/trae/network/HostType;->NOTIFICATION Lcom/bytedance/trae/network/HostType;
    invoke-virtual v1, v2, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v1
    move-object v6, v1
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v1
    const-class v2, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v1, v2, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/login/api/ILoginService;
    if-eqz v1, +007h
    invoke-interface v1, Lcom/bytedance/trae/login/api/ILoginService;->getXTToken()Ljava/lang/String;
    move-result-object v1
    goto +2h
    const/4 v1, 0
    if-nez v1, +004h
    const-string v1, ""
    invoke-static Lkotlin/collections/MapsKt;->createMapBuilder()Ljava/util/Map;
    move-result-object v2
    move-object v3, v1
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-lez v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    if-eqz v3, +016h
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "Cloud-IDE-JWT "
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v3, "Authorization"
    invoke-interface v2, v3, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    if-eqz v0, +012h
    const-string/jumbo v0, x-tt-env
    const-string v1, "boe_notification"
    invoke-interface v2, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    const-string/jumbo v0, x-use-boe
    const-string v1, "1"
    invoke-interface v2, v0, v1, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static v2, Lkotlin/collections/MapsKt;->build(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v7
    sget-object v2, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v3, site_message
    const-class v4, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    const/4 v5, 0
    const/4 v8, 0
    const/16 v9, 36
    const/4 v10, 0
    invoke-static/range v2 ... v10, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/home/solo/sitemessage/ISiteMessageApi;
    return-object v0
.end method
