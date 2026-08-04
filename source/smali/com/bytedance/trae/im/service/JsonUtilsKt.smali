# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/JsonUtilsKt;
.super Ljava/lang/Object;
.source "JsonUtils.kt"


.method public static final calculateLeftTurnsSteps(int  java.util.List)int
    .registers 4
    # ins_size=2
    const-string v0, "maxLeftTurns"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +012h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    if-ge v2, v1, +004h
    sub-int/2addr v1, v2
    return v1
    sub-int/2addr v2, v1
    goto -15h
    invoke-static v3, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Integer;
    if-eqz v3, +00dh
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v0
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    rem-int/2addr v2, v3
    sub-int/2addr v0, v2
    return v0
    const/4 v2, 1
    return v2
.end method

.method public static final mergeJsonObjects(com.google.gson.JsonObject  com.google.gson.JsonObject)com.google.gson.JsonObject
    .registers 3
    # ins_size=2
    const-string v0, "oldObj"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newObj"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v1
    check-cast v0, Lcom/google/gson/JsonElement;
    check-cast v2, Lcom/google/gson/JsonElement;
    invoke-static v0, v2, Lcom/bytedance/trae/im/service/JsonUtilsKt;->mergeJsonValues(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    move-result-object v2
    instance-of v0, v2, Lcom/google/gson/JsonObject;
    if-eqz v0, +005h
    check-cast v2, Lcom/google/gson/JsonObject;
    goto +2h
    const/4 v2, 0
    if-nez v2, +003h
    goto +2h
    move-object v1, v2
    return-object v1
.end method

.method public static final mergeJsonStrings(java.lang.String  java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    const-string v0, "oldJsonStr"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "newJsonStr"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-nez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +00ah
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    check-cast v0, Lcom/google/gson/JsonElement;
    goto +10h
    invoke-static v4, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    goto +8h
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v3, v5
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v3
    if-nez v3, +003h
    goto +2h
    move v1, v2
    if-eqz v1, +00ah
    new-instance v5, Lcom/google/gson/JsonObject;
    invoke-direct v5, Lcom/google/gson/JsonObject;-><init>()V
    check-cast v5, Lcom/google/gson/JsonElement;
    goto +10h
    invoke-static v5, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    goto +8h
    new-instance v5, Lcom/google/gson/JsonObject;
    invoke-direct v5, Lcom/google/gson/JsonObject;-><init>()V
    check-cast v5, Lcom/google/gson/JsonElement;
    invoke-static v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-static v0, v5, Lcom/bytedance/trae/im/service/JsonUtilsKt;->mergeJsonValues(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +00ah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->toString()Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v4, v5
    return-object v4
    :try_start_0x2c
    :try_start_0x5a
.end method

.method public static final mergeJsonValues(com.google.gson.JsonElement  com.google.gson.JsonElement)com.google.gson.JsonElement
    .registers 7
    # ins_size=2
    if-eqz v6, +0e4h
    instance-of v0, v6, Lcom/google/gson/JsonNull;
    if-eqz v0, +004h
    goto/16 +0deh
    if-eqz v5, +0d8h
    instance-of v0, v5, Lcom/google/gson/JsonNull;
    if-eqz v0, +004h
    goto/16 +0d2h
    instance-of v0, v5, Lcom/google/gson/JsonPrimitive;
    if-eqz v0, +03ah
    move-object v0, v5
    check-cast v0, Lcom/google/gson/JsonPrimitive;
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v1
    if-eqz v1, +031h
    instance-of v1, v6, Lcom/google/gson/JsonPrimitive;
    if-eqz v1, +02dh
    move-object v1, v6
    check-cast v1, Lcom/google/gson/JsonPrimitive;
    invoke-virtual v1, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v2
    if-eqz v2, +024h
    new-instance v5, Lcom/google/gson/JsonPrimitive;
    new-instance v6, Ljava/lang/StringBuilder;
    invoke-direct v6, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v1, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v0
    invoke-virtual v6, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-direct v5, v6, Lcom/google/gson/JsonPrimitive;-><init>(Ljava/lang/String;)V
    check-cast v5, Lcom/google/gson/JsonElement;
    goto/16 +095h
    instance-of v0, v5, Lcom/google/gson/JsonArray;
    if-eqz v0, +03dh
    instance-of v0, v6, Lcom/google/gson/JsonArray;
    if-eqz v0, +039h
    move-object v0, v5
    check-cast v0, Lcom/google/gson/JsonArray;
    invoke-virtual v0, Lcom/google/gson/JsonArray;->size()I
    move-result v1
    move-object v2, v6
    check-cast v2, Lcom/google/gson/JsonArray;
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v3
    if-ge v1, v3, +00ah
    sget-object v1, Lcom/google/gson/JsonNull;->INSTANCE Lcom/google/gson/JsonNull;
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, Lcom/google/gson/JsonArray;->add(Lcom/google/gson/JsonElement;)V
    goto -17h
    invoke-virtual v2, Lcom/google/gson/JsonArray;->size()I
    move-result v6
    const/4 v1, 0
    if-ge v1, v6, +06eh
    invoke-virtual v0, v1, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v3
    invoke-virtual v2, v1, Lcom/google/gson/JsonArray;->get(I)Lcom/google/gson/JsonElement;
    move-result-object v4
    invoke-static v3, v4, Lcom/bytedance/trae/im/service/JsonUtilsKt;->mergeJsonValues(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-nez v3, +006h
    sget-object v3, Lcom/google/gson/JsonNull;->INSTANCE Lcom/google/gson/JsonNull;
    check-cast v3, Lcom/google/gson/JsonElement;
    invoke-virtual v0, v1, v3, Lcom/google/gson/JsonArray;->set(I Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    add-int/lit8 v1, v1, 1
    goto -19h
    instance-of v0, v5, Lcom/google/gson/JsonObject;
    if-eqz v0, +04eh
    instance-of v0, v6, Lcom/google/gson/JsonObject;
    if-eqz v0, +04ah
    check-cast v6, Lcom/google/gson/JsonObject;
    invoke-virtual v6, Lcom/google/gson/JsonObject;->entrySet()Ljava/util/Set;
    move-result-object v6
    invoke-interface v6, Ljava/util/Set;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +03eh
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/Map$Entry;
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v0, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-interface v0, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    move-object v2, v5
    check-cast v2, Lcom/google/gson/JsonObject;
    invoke-virtual v2, v1, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v3
    if-eqz v3, +014h
    invoke-virtual v2, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    invoke-static v3, v0, Lcom/bytedance/trae/im/service/JsonUtilsKt;->mergeJsonValues(Lcom/google/gson/JsonElement; Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-nez v0, +006h
    sget-object v0, Lcom/google/gson/JsonNull;->INSTANCE Lcom/google/gson/JsonNull;
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-virtual v2, v1, v0, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    goto -35h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->deepCopy()Lcom/google/gson/JsonElement;
    move-result-object v0
    invoke-virtual v2, v1, v0, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    goto -3dh
    invoke-virtual v6, Lcom/google/gson/JsonElement;->deepCopy()Lcom/google/gson/JsonElement;
    move-result-object v5
    return-object v5
    invoke-virtual v6, Lcom/google/gson/JsonElement;->deepCopy()Lcom/google/gson/JsonElement;
    move-result-object v5
    return-object v5
.end method
