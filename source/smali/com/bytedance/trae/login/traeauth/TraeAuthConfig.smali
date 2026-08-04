# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
.super Ljava/lang/Object;
.source "TraeAuthConfig.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
.field private static clientId:Ljava/lang/String;
.field private static clientSecret:Ljava/lang/String;
.field private static loginChannel:Ljava/lang/String;
.field private static platform:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    invoke-direct v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->INSTANCE Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;
    const-string/jumbo v0, ono9krqynydwx5
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientId Ljava/lang/String;
    const-string v0, "-"
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientSecret Ljava/lang/String;
    const-string v0, "Android"
    sput-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->loginChannel Ljava/lang/String;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getBaseUrl()java.lang.String
    .registers 3
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v1, Lcom/bytedance/trae/network/HostType;->LOGIN Lcom/bytedance/trae/network/HostType;
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getClientId()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientId Ljava/lang/String;
    return-object v0
.end method

.method public final getClientSecret()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientSecret Ljava/lang/String;
    return-object v0
.end method

.method public final getLoginChannel()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->loginChannel Ljava/lang/String;
    return-object v0
.end method

.method public final getPlatform()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->platform Ljava/lang/String;
    return-object v0
.end method

.method public final setClientId(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientId Ljava/lang/String;
    return-void 
.end method

.method public final setClientSecret(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "<set-?>"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v2, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->clientSecret Ljava/lang/String;
    return-void 
.end method

.method public final setLoginChannel(java.lang.String)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->loginChannel Ljava/lang/String;
    return-void 
.end method

.method public final setPlatform(java.lang.String)void
    .registers 2
    # ins_size=2
    sput-object v1, Lcom/bytedance/trae/login/traeauth/TraeAuthConfig;->platform Ljava/lang/String;
    return-void 
.end method
