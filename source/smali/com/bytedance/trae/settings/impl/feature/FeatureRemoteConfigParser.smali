# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;
.super Ljava/lang/Object;
.source "FeatureRemoteConfigParser.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;
    invoke-direct v0, Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;->INSTANCE Lcom/bytedance/trae/settings/impl/feature/FeatureRemoteConfigParser;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public final parse(java.lang.String  com.bytedance.trae.settings.impl.feature.FeatureCapabilityScope)java.util.Map
    .registers 6
    # ins_size=3
    const-string v0, "json"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, scope
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v4, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v4
    invoke-virtual v5, Lcom/bytedance/trae/settings/impl/feature/FeatureCapabilityScope;->getRemoteKey()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/google/gson/JsonObject;->getAsJsonObject(Ljava/lang/String;)Lcom/google/gson/JsonObject;
    move-result-object v4
    if-nez v4, +004h
    const/4 v4, 0
    return-object v4
    new-instance v5, Ljava/util/LinkedHashMap;
    invoke-direct v5, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v5, Ljava/util/Map;
    invoke-virtual v4, Lcom/google/gson/JsonObject;->entrySet()Ljava/util/Set;
    move-result-object v4
    const-string v0, "entrySet(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +033h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, -01fh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v2
    invoke-virtual v2, Lcom/google/gson/JsonPrimitive;->isBoolean()Z
    move-result v2
    if-eqz v2, -029h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsBoolean()Z
    move-result v0
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-interface v5, v1, v0, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -36h
    return-object v5
.end method
