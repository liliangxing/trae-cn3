# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;
.super Ljava/lang/Object;
.source "ISendUserDecisionApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;->$$INSTANCE Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
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

.method public final safeCall(kotlin.jvm.functions.Function2  kotlin.coroutines.Continuation)java.lang.Object
    .registers 13
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string/jumbo v1, user_decision
    const-class v2, Lcom/bytedance/trae/im/service/ISendUserDecisionApi;
    invoke-direct v10, Lcom/bytedance/trae/im/service/ISendUserDecisionApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
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
