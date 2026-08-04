# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/util/NetworkControlUtils;
.super Ljava/lang/Object;
.source "NetworkControlUtils.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/util/NetworkControlUtils;
.field private static final cacheMap:Ljava/util/concurrent/ConcurrentHashMap;
.field private static final enableBootNqeOpt$delegate:Lkotlin/Lazy;
.field private static final enableBootPathOpt$delegate:Lkotlin/Lazy;
.field private static nqeflag:Z


.method public static synthetic $r8$lambda$0kROdZoJOWy_-qpQZ5bjYYQlvDg()int
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootNqeOpt_delegate$lambda$1()I
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$X8EhWvq1a4ZaClSdF9SMlGyOkNE()java.util.HashMap
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootPathOpt_delegate$lambda$0()Ljava/util/HashMap;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;
    invoke-direct v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->INSTANCE Lcom/bytedance/trae/network/util/NetworkControlUtils;
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;
    invoke-direct v0, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->cacheMap Ljava/util/concurrent/ConcurrentHashMap;
    new-instance v0, Lcom/bytedance/trae/network/util/NetworkControlUtils$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/network/util/NetworkControlUtils$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootPathOpt$delegate Lkotlin/Lazy;
    new-instance v0, Lcom/bytedance/trae/network/util/NetworkControlUtils$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/network/util/NetworkControlUtils$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootNqeOpt$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final enableBootNqeOpt_delegate$lambda$1()int
    .registers 1
    # ins_size=0
    const/4 v0, 0
    return v0
.end method

.method private static final enableBootPathOpt_delegate$lambda$0()java.util.HashMap
    .registers 1
    # ins_size=0
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    return-object v0
.end method

.method public static synthetic startNQERequest$default(com.bytedance.trae.network.util.NetworkControlUtils  boolean  int  java.lang.Object)void
    .registers 4
    # ins_size=4
    const/4 v3, 1
    and-int/2addr v2, v3
    if-eqz v2, +003h
    move v1, v3
    invoke-virtual v0, v1, Lcom/bytedance/trae/network/util/NetworkControlUtils;->startNQERequest(Z)V
    return-void 
.end method

.method public final getEnableBootNqeOpt()int
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootNqeOpt$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    return v0
.end method

.method public final getEnableBootPathOpt()java.util.HashMap
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/network/util/NetworkControlUtils;->enableBootPathOpt$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/HashMap;
    return-object v0
.end method

.method public final startNQERequest(boolean)void
    .registers 2
    # ins_size=2
    return-void 
.end method

.method public final startSpeedStrategy(java.lang.String  java.util.HashMap  java.lang.Integer)void
    .registers 21
    # ins_size=4
    move-object/from16 v0, v18
    const-string v1, "key"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v19, +003h
    return-void 
    if-eqz v20, +063h
    invoke-virtual/range v20, Ljava/lang/Integer;->intValue()I
    invoke-virtual/range v19, Ljava/util/HashMap;->isEmpty()Z
    move-result v1
    if-nez v1, +05ah
    invoke-virtual/range v20, Ljava/lang/Integer;->intValue()I
    move-result v1
    if-gtz v1, +003h
    goto +52h
    sget-object v1, Lcom/bytedance/trae/network/util/NetworkControlUtils;->cacheMap Ljava/util/concurrent/ConcurrentHashMap;
    invoke-virtual v1, v0, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/ttnet/priority/ModePriorityManagement;
    if-eqz v2, +003h
    goto +40h
    new-instance v2, Lcom/bytedance/ttnet/priority/ModePriorityManagement;
    invoke-direct v2, Lcom/bytedance/ttnet/priority/ModePriorityManagement;-><init>()V
    invoke-virtual v2, v0, Lcom/bytedance/ttnet/priority/ModePriorityManagement;->setStateName(Ljava/lang/String;)V
    invoke-virtual/range v20, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-virtual v2, v3, Lcom/bytedance/ttnet/priority/ModePriorityManagement;->setDelayDisableTimeMs(I)V
    move-object/from16 v3, v19
    check-cast v3, Ljava/util/Map;
    invoke-static v3, Lkotlin/collections/MapsKt;->toMutableMap(Ljava/util/Map;)Ljava/util/Map;
    move-result-object v3
    if-nez v3, +006h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v3
    move-object v4, v3
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v5
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v6
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v7
    invoke-static Lkotlin/collections/SetsKt;->emptySet()Ljava/util/Set;
    move-result-object v8
    const-wide/16 v9, -1
    const-wide/16 v11, -1
    const-wide/16 v13, -1
    const-wide/16 v15, -1
    move-object v3, v2
    invoke-virtual/range v3 ... v16, Lcom/bytedance/ttnet/priority/ModePriorityManagement;->initRequestSpeedController(Ljava/util/Map; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; Ljava/util/Set; J J J J)V
    check-cast v1, Ljava/util/Map;
    invoke-interface v1, v0, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-static Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->getInstance()Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;
    move-result-object v0
    invoke-virtual v0, v2, Lcom/bytedance/ttnet/priority/TTHttpCallPriorityControl;->startAppStateFromCustom(Lcom/bytedance/ttnet/priority/ModePriorityManagement;)V
    return-void 
.end method
