# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/utils/logger/FormatLogBuilderKt;
.super Ljava/lang/Object;
.source "FormatLogBuilder.kt"


.method public static final toLoggerParams(org.json.JSONObject)java.util.Map
    .registers 5
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lorg/json/JSONObject;->length()I
    move-result v0
    if-nez v0, +007h
    invoke-static Lkotlin/collections/MapsKt;->emptyMap()Ljava/util/Map;
    move-result-object v4
    return-object v4
    new-instance v0, Ljava/util/LinkedHashMap;
    invoke-direct v0, Ljava/util/LinkedHashMap;-><init>()V
    check-cast v0, Ljava/util/Map;
    invoke-virtual v4, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;
    move-result-object v1
    const-string v2, "keys(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +018h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    new-instance v3, Lcom/bytedance/trae/utils/logger/LogKey;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v2, Lcom/bytedance/trae/utils/logger/LogKey;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v2, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v2
    invoke-interface v0, v3, v2, Ljava/util/Map;->put(Ljava/lang/Object; Ljava/lang/Object;)Ljava/lang/Object;
    goto -1bh
    return-object v0
.end method
