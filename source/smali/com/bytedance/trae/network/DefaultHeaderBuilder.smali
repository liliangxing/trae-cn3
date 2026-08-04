# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/DefaultHeaderBuilder;
.super Ljava/lang/Object;
.source "DefaultHeaderBuilder.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/DefaultHeaderBuilder;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/DefaultHeaderBuilder;
    invoke-direct v0, Lcom/bytedance/trae/network/DefaultHeaderBuilder;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/DefaultHeaderBuilder;->INSTANCE Lcom/bytedance/trae/network/DefaultHeaderBuilder;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final build(java.util.Map  java.lang.String  java.util.Map)java.util.Map
    .registers 9
    # ins_size=4
    const-string/jumbo v0, ppeHeaders
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "envLane"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "extras"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 3
    new-array v0, v0, [Lkotlin/Pair;
    const-string v1, "Content-Type"
    const-string v2, "application/json"
    invoke-static v1, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const-string v1, "X-App-Id"
    const-string v3, "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8"
    invoke-static v1, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v3, 1
    aput-object v1, v0, v3
    const-string v1, "X-App-Version-Code"
    const-string v4, "20260310"
    invoke-static v1, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v1
    const/4 v4, 2
    aput-object v1, v0, v4
    invoke-static v0, Lkotlin/collections/MapsKt;->mutableMapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    invoke-interface v0, v6, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    move-object v6, v7
    check-cast v6, Ljava/lang/CharSequence;
    invoke-interface v6, Ljava/lang/CharSequence;->length()I
    move-result v6
    if-lez v6, +003h
    move v2, v3
    if-eqz v2, +007h
    const-string v6, "X-Env-Lane"
    invoke-interface v0, v6, v7, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    invoke-interface v0, v8, Ljava/util/Map;->putAll(Ljava/util/Map;)V
    return-object v0
.end method
