# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/network/TraeRequestEventReporter;
.super Ljava/lang/Object;
.source "TraeRequestEventReporter.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/network/TraeRequestEventReporter;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/network/TraeRequestEventReporter;
    invoke-direct v0, Lcom/bytedance/trae/network/TraeRequestEventReporter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/network/TraeRequestEventReporter;->INSTANCE Lcom/bytedance/trae/network/TraeRequestEventReporter;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final firstHeader(java.util.Map  java.lang.String)java.lang.String
    .registers 7
    # ins_size=3
    invoke-interface v5, Ljava/util/Map;->entrySet()Ljava/util/Set;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +017h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Ljava/util/Map$Entry;
    invoke-interface v2, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    const/4 v3, 1
    invoke-static v2, v6, v3, Lkotlin/text/StringsKt;->equals(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v2
    if-eqz v2, -019h
    goto +2h
    move-object v0, v1
    check-cast v0, Ljava/util/Map$Entry;
    if-eqz v0, +009h
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v5
    move-object v1, v5
    check-cast v1, Ljava/lang/String;
    return-object v1
.end method

.method private final parseServerTimingDuration(java.lang.String)java.lang.Double
    .registers 6
    # ins_size=2
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "dur=([\d.]+)"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v0, v5, v1, v2, v3, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v5
    if-eqz v5, +015h
    invoke-interface v5, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v5
    if-eqz v5, +00fh
    const/4 v0, 1
    invoke-static v5, v0, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-eqz v5, +006h
    invoke-static v5, Lkotlin/text/StringsKt;->toDoubleOrNull(Ljava/lang/String;)Ljava/lang/Double;
    move-result-object v3
    return-object v3
.end method

.method public final report(java.lang.String  long  long  java.lang.String  java.util.Map)void
    .registers 10
    # ins_size=8
    const-string v0, "message"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "headers"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lorg/json/JSONObject;
    invoke-direct v0, Lorg/json/JSONObject;-><init>()V
    if-nez v3, +004h
    const-string v3, ""
    const-string/jumbo v1, path
    invoke-virtual v0, v1, v3, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string v3, "cost_time"
    invoke-virtual v0, v3, v4, v5, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v3, "code"
    invoke-virtual v0, v3, v6, v7, Lorg/json/JSONObject;->put(Ljava/lang/String; J)Lorg/json/JSONObject;
    const-string v3, "msg"
    invoke-virtual v0, v3, v8, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/network/TraeRequestEventReporter;->INSTANCE Lcom/bytedance/trae/network/TraeRequestEventReporter;
    const-string/jumbo v4, x-tt-logid
    invoke-direct v3, v9, v4, Lcom/bytedance/trae/network/TraeRequestEventReporter;->firstHeader(Ljava/util/Map; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +007h
    const-string v5, "logid"
    invoke-virtual v0, v5, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; Ljava/lang/Object;)Lorg/json/JSONObject;
    const-string/jumbo v4, server-timing
    invoke-direct v3, v9, v4, Lcom/bytedance/trae/network/TraeRequestEventReporter;->firstHeader(Ljava/util/Map; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +013h
    invoke-direct v3, v4, Lcom/bytedance/trae/network/TraeRequestEventReporter;->parseServerTimingDuration(Ljava/lang/String;)Ljava/lang/Double;
    move-result-object v3
    if-eqz v3, +00dh
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->doubleValue()D
    move-result-wide v3
    const-string v5, "inner_duration"
    invoke-virtual v0, v5, v3, v4, Lorg/json/JSONObject;->put(Ljava/lang/String; D)Lorg/json/JSONObject;
    sget-object v3, Lcom/bytedance/trae/applog/api/IApplog;->Companion Lcom/bytedance/trae/applog/api/IApplog$Companion;
    const-string/jumbo v4, solo_request_event
    invoke-virtual v3, v4, v0, Lcom/bytedance/trae/applog/api/IApplog$Companion;->reportEvent(Ljava/lang/String; Lorg/json/JSONObject;)V
    return-void 
.end method
