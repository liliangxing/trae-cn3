# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/RegisterAppApi$Companion;
.super Ljava/lang/Object;
.source "RegisterAppApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/network/RegisterAppApi$Companion;
.field private static final TOB_REGISTER_SUCCESS_CODES:Ljava/util/Set;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->$$INSTANCE Lcom/bytedance/trae/network/RegisterAppApi$Companion;
    const/4 v0, 2
    new-array v0, v0, [Ljava/lang/Long;
    const-wide/16 v1, 0
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-wide/16 v1, 200
    invoke-static v1, v2, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->TOB_REGISTER_SUCCESS_CODES Ljava/util/Set;
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

.method public static synthetic safeCall$default(com.bytedance.trae.network.RegisterAppApi$Companion  com.bytedance.trae.network.RegisterAppRequest  java.util.Set  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +008h
    sget-object v2, Lcom/bytedance/trae/network/response/BizResponse;->Companion Lcom/bytedance/trae/network/response/BizResponse$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/network/response/BizResponse$Companion;->getDEFAULT_SUCCESS_CODES()Ljava/util/Set;
    move-result-object v2
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->safeCall(Lcom/bytedance/trae/network/RegisterAppRequest; Ljava/util/Set; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final getTOB_REGISTER_SUCCESS_CODES()java.util.Set
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->TOB_REGISTER_SUCCESS_CODES Ljava/util/Set;
    return-object v0
.end method

.method public final safeCall(com.bytedance.trae.network.RegisterAppRequest  java.util.Set  kotlin.coroutines.Continuation)java.lang.Object
    .registers 14
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    const-string v1, "base"
    const-class v2, Lcom/bytedance/trae/network/RegisterAppApi;
    invoke-direct v10, Lcom/bytedance/trae/network/RegisterAppApi$Companion;->getDEFAULT_HEADERS()Ljava/util/Map;
    move-result-object v3
    new-instance v4, Lcom/bytedance/trae/network/RegisterAppApi$Companion$safeCall$2;
    const/4 v5, 0
    invoke-direct v4, v11, v5, Lcom/bytedance/trae/network/RegisterAppApi$Companion$safeCall$2;-><init>(Lcom/bytedance/trae/network/RegisterAppRequest; Lkotlin/coroutines/Continuation;)V
    check-cast v4, Lkotlin/jvm/functions/Function2;
    const/16 v8, 16
    const/4 v9, 0
    move-object v6, v12
    move-object v7, v13
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/network/TraeHttpConnection;->safeCall$default(Lcom/bytedance/trae/network/TraeHttpConnection; Ljava/lang/String; Ljava/lang/Class; Ljava/util/Map; Lkotlin/jvm/functions/Function2; Ljava/lang/String; Ljava/util/Set; Lkotlin/coroutines/Continuation; I Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v11
    return-object v11
.end method
