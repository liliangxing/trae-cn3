# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/NullSafeJsonObjectAdapter;
.super Lcom/google/gson/TypeAdapter;
.source "ParsedChatMessage.kt"


.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/google/gson/TypeAdapter;-><init>()V
    return-void 
.end method

.method public read(com.google.gson.stream.JsonReader)com.google.gson.JsonObject
    .registers 5
    # ins_size=2
    const-string v0, "reader"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Lcom/google/gson/stream/JsonReader;->peek()Lcom/google/gson/stream/JsonToken;
    move-result-object v0
    sget-object v1, Lcom/google/gson/stream/JsonToken;->NULL Lcom/google/gson/stream/JsonToken;
    const/4 v2, 0
    if-ne v0, v1, +006h
    invoke-virtual v4, Lcom/google/gson/stream/JsonReader;->nextNull()V
    return-object v2
    invoke-static v4, Lcom/google/gson/internal/Streams;->parse(Lcom/google/gson/stream/JsonReader;)Lcom/google/gson/JsonElement;
    move-result-object v4
    instance-of v0, v4, Lcom/google/gson/JsonObject;
    if-eqz v0, +005h
    move-object v2, v4
    check-cast v2, Lcom/google/gson/JsonObject;
    return-object v2
.end method

.method public bridge synthetic read(com.google.gson.stream.JsonReader)java.lang.Object
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Lcom/bytedance/trae/im/model/NullSafeJsonObjectAdapter;->read(Lcom/google/gson/stream/JsonReader;)Lcom/google/gson/JsonObject;
    move-result-object v1
    return-object v1
.end method

.method public write(com.google.gson.stream.JsonWriter  com.google.gson.JsonObject)void
    .registers 4
    # ins_size=3
    const-string v0, "out"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v3, +006h
    invoke-virtual v2, Lcom/google/gson/stream/JsonWriter;->nullValue()Lcom/google/gson/stream/JsonWriter;
    goto +6h
    check-cast v3, Lcom/google/gson/JsonElement;
    invoke-static v3, v2, Lcom/google/gson/internal/Streams;->write(Lcom/google/gson/JsonElement; Lcom/google/gson/stream/JsonWriter;)V
    return-void 
.end method

.method public bridge synthetic write(com.google.gson.stream.JsonWriter  java.lang.Object)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/google/gson/JsonObject;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/model/NullSafeJsonObjectAdapter;->write(Lcom/google/gson/stream/JsonWriter; Lcom/google/gson/JsonObject;)V
    return-void 
.end method
