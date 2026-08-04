# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
.super Ljava/lang/Object;
.source "ISendMessageService.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/ISendMessageService$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ISendMessageService$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic createService$default(com.bytedance.trae.im.service.ISendMessageService$Companion  java.util.Map  int  java.lang.Object)com.bytedance.trae.im.service.ISendMessageService
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->createService(Ljava/util/Map;)Lcom/bytedance/trae/im/service/ISendMessageService;
    move-result-object v0
    return-object v0
.end method

.method private final getDEFAULT_HEADERS()java.util.Map
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/DebugSettings;->INSTANCE Lcom/bytedance/trae/network/DebugSettings;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/network/DebugSettings;->buildDefaultHeaders$default(Lcom/bytedance/trae/network/DebugSettings; Ljava/util/Map; I Ljava/lang/Object;)Ljava/util/Map;
    move-result-object v0
    return-object v0
.end method

.method public final createService(java.util.Map)com.bytedance.trae.im.service.ISendMessageService
    .registers 12
    # ins_size=2
    const-string v0, "extraHeaders"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v2, send_message
    const-class v3, Lcom/bytedance/trae/im/service/ISendMessageService;
    const/4 v4, 0
    const/4 v5, 0
    invoke-direct v10, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/collections/MapsKt;->plus(Ljava/util/Map; Ljava/util/Map;)Ljava/util/Map;
    move-result-object v6
    const/4 v7, 0
    const/16 v8, 12
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->createService$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Lcom/bytedance/retrofit2/Converter$Factory; Ljava/lang/String; Ljava/util/Map; Z I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Lcom/bytedance/trae/im/service/ISendMessageService;
    return-object v11
.end method

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, send_message
    const-class v2, Lcom/bytedance/trae/im/service/ISendMessageService;
    invoke-direct v10, Lcom/bytedance/trae/im/service/ISendMessageService$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v3
    const/4 v5, 0
    const/4 v6, 0
    const/16 v8, 48
    const/4 v9, 0
    move-object v4, v11
    move-object v7, v12
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method
