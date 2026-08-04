# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
.super Ljava/lang/Object;
.source "OverseaProfileApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;->$$INSTANCE Lcom/bytedance/trae/login/service/IOverseaProfileApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final create()com.bytedance.trae.login.service.IOverseaProfileApi
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, oversea_profile
    const-class v2, Lcom/bytedance/trae/login/service/IOverseaProfileApi;
    const/4 v3, 0
    sget-object v4, Lcom/bytedance/trae/network/HostResolver;->INSTANCE Lcom/bytedance/trae/network/HostResolver;
    sget-object v5, Lcom/bytedance/trae/network/HostType;->ONLINE Lcom/bytedance/trae/network/HostType;
    invoke-virtual v4, v5, Lcom/bytedance/trae/network/HostResolver;->getBaseUrl(Lcom/bytedance/trae/network/HostType;)Ljava/lang/String;
    move-result-object v4
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 20
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/service/IOverseaProfileApi;
    return-object v0
.end method
