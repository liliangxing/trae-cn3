# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
.super Ljava/lang/Object;
.source "HubNetFallbackApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
.field private static final POLL_SUCCESS_CODES:Ljava/util/Set;
.field public static final SSE_POLL_PATH:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;
    const-wide/16 v0, 200
    invoke-static v0, v1, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf(Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->POLL_SUCCESS_CODES Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final getPOLL_SUCCESS_CODES$ttnet_mainlandRelease()java.util.Set
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->POLL_SUCCESS_CODES Ljava/util/Set;
    return-object v0
.end method

.method public final pollRawCall$ttnet_mainlandRelease(java.util.Map  long  java.lang.String  java.lang.Long  java.lang.Integer  kotlin.coroutines.Continuation)java.lang.Object
    .registers 19
    # ins_size=8
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "hub_fallback"
    const-class v2, Lcom/bytedance/trae/network/HubNetFallbackApi;
    new-instance v10, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;
    const/4 v9, 0
    move-object v3, v10
    move-wide v4, v13
    move-object v6, v15
    move-object/from16 v7, v16
    move-object/from16 v8, v17
    invoke-direct/range v3 ... v9, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion$pollRawCall$2;-><init>(J Ljava/lang/String; Ljava/lang/Long; Ljava/lang/Integer; Lkotlin/coroutines/Continuation;)V
    move-object v4, v10
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/4 v5, 0
    sget-object v6, Lcom/bytedance/trae/network/HubNetFallbackApi$Companion;->POLL_SUCCESS_CODES Ljava/util/Set;
    const/16 v8, 16
    move-object v3, v12
    move-object/from16 v7, v18
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method
