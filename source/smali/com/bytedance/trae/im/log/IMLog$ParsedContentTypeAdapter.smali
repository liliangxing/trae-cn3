# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;
.super Ljava/lang/Object;
.source "IMLog.kt"

.implements Lcom/google/gson/JsonSerializer;
.implements Lcom/google/gson/JsonDeserializer;

.field private final innerGson:Lcom/google/gson/Gson;


.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    iput-object v0, v1, Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;->innerGson Lcom/google/gson/Gson;
    return-void 
.end method

.method public deserialize(com.google.gson.JsonElement  java.lang.reflect.Type  com.google.gson.JsonDeserializationContext)java.lang.Object
    .registers 5
    # ins_size=4
    const-string v0, "json"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, typeOfT
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "context"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +011h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v3
    invoke-virtual v3, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v3
    if-eqz v3, +007h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v2
    goto +11h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v3
    if-eqz v3, +00bh
    iget-object v3, v1, Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;->innerGson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    invoke-virtual v3, v2, v4, Lcom/google/gson/Gson;->fromJson(Lcom/google/gson/JsonElement; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v2
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method public serialize(java.lang.Object  java.lang.reflect.Type  com.google.gson.JsonSerializationContext)com.google.gson.JsonElement
    .registers 5
    # ins_size=4
    const-string/jumbo v0, typeOfSrc
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v3, "context"
    invoke-static v4, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v3, v2, Ljava/lang/String;
    if-eqz v3, +00ch
    new-instance v3, Lcom/google/gson/JsonPrimitive;
    check-cast v2, Ljava/lang/String;
    invoke-direct v3, v2, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/String;)V
    check-cast v3, Lcom/google/gson/JsonElement;
    goto +20h
    instance-of v3, v2, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    if-eqz v3, +013h
    iget-object v3, v1, Lcom/bytedance/trae/im/log/IMLog$ParsedContentTypeAdapter;->innerGson Lcom/google/gson/Gson;
    const-class v4, Lcom/bytedance/trae/im/model/ParsedTaskContent;
    check-cast v4, Ljava/lang/reflect/Type;
    invoke-virtual v3, v2, v4, Lcom/google/gson/Gson;->toJsonTree(Ljava/lang/Object; Ljava/lang/reflect/Type;)Lcom/google/gson/JsonElement;
    move-result-object v3
    const-string/jumbo v2, toJsonTree(...)
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +bh
    invoke-interface v4, v2, Lcom/google/gson/JsonSerializationContext;->serialize(Ljava/lang/Object;)Lcom/google/gson/JsonElement;
    move-result-object v3
    const-string/jumbo v2, serialize(...)
    invoke-static v3, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v3
.end method
