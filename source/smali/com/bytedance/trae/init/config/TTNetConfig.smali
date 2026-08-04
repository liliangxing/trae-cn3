# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/init/config/TTNetConfig;
.super Ljava/lang/Object;
.source "TTNetConfig.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/init/config/TTNetConfig;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/init/config/TTNetConfig;
    invoke-direct v0, Lcom/bytedance/trae/init/config/TTNetConfig;-><init>()V
    sput-object v0, Lcom/bytedance/trae/init/config/TTNetConfig;->INSTANCE Lcom/bytedance/trae/init/config/TTNetConfig;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getConfigServers()java.lang.String[]
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    if-eqz v0, +00dh
    const-string/jumbo v0, tnc-boot.trae.ai
    const-string/jumbo v1, tnc-normal.trae.ai
    filled-new-array v0, v1, [Ljava/lang/String;
    move-result-object v0
    goto +eh
    const-string/jumbo v0, tnc3-alisc1.zijieapi.com
    const-string/jumbo v1, tnc3-aliec2.zijieapi.com
    const-string/jumbo v2, tnc3-bjlgy.zijieapi.com
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final getServiceDomainMap()java.util.Map
    .registers 10
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v0
    const-string v1, ".boe-gateway.byted.org"
    const-string v2, "boe"
    const/4 v3, 2
    const-string v4, "netlog"
    const/4 v5, 1
    const-string v6, "httpdns"
    const/4 v7, 0
    const/4 v8, 3
    if-eqz v0, +020h
    new-array v0, v8, [Lkotlin/Pair;
    const-string v8, "34.102.215.99"
    invoke-static v6, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v0, v7
    const-string/jumbo v6, ttnet-sg.byteoversea.com
    invoke-static v4, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v0, v5
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v3
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    goto +1dh
    new-array v0, v8, [Lkotlin/Pair;
    const-string v8, "dig.bdurl.net"
    invoke-static v6, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    aput-object v6, v0, v7
    const-string v6, "crash.snssdk.com"
    invoke-static v4, v6, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    aput-object v4, v0, v5
    invoke-static v2, v1, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    aput-object v1, v0, v3
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method
