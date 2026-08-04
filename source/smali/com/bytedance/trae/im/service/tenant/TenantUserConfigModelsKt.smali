# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;
.super Ljava/lang/Object;
.source "TenantUserConfigModels.kt"


.method public static final synthetic access$stringListFromArrayOrJsonString(com.google.gson.JsonElement)java.util.List
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->stringListFromArrayOrJsonString(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$stringOrNumber(com.google.gson.JsonElement)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/im/service/tenant/TenantUserConfigModelsKt;->stringOrNumber(Lcom/google/gson/JsonElement;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private static final stringListFromArrayOrJsonString(com.google.gson.JsonElement)java.util.List
    .registers 7
    # ins_size=1
    if-eqz v6, +161h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v0
    const/4 v1, 1
    xor-int/2addr v0, v1
    const/4 v2, 0
    if-eqz v0, +003h
    goto +2h
    move-object v6, v2
    if-nez v6, +004h
    goto/16 +152h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    const/4 v3, 0
    if-eqz v0, +082h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v6
    const-string v0, "getAsJsonArray(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +039h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/google/gson/JsonElement;
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v5
    if-nez v5, +00ah
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +004h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +017h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-eqz v4, -037h
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, -014h
    invoke-interface v6, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    check-cast v6, Ljava/util/List;
    goto/16 +0cah
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +0c0h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v0
    invoke-virtual v0, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v0
    if-eqz v0, +0b6h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v6, v2
    if-eqz v6, +07eh
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v6
    if-eqz v6, +078h
    check-cast v6, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +039h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/google/gson/JsonElement;
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v5
    if-nez v5, +00ah
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +004h
    move v5, v1
    goto +2h
    move v5, v3
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +017h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v4
    if-eqz v4, +011h
    invoke-virtual v4, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v2
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v2
    if-eqz v4, -037h
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -3ch
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +016h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Ljava/lang/String;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v1
    if-eqz v3, -014h
    invoke-interface v6, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -19h
    move-object v2, v6
    check-cast v2, Ljava/util/List;
    if-nez v2, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    goto +ch
    move-exception v6
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v6, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v6
    invoke-static v6, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v6
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    invoke-static v6, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v6, v0
    check-cast v6, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    return-object v6
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v6
    return-object v6
    :try_start_0xa8
.end method

.method private static final stringOrNumber(com.google.gson.JsonElement)java.lang.String
    .registers 3
    # ins_size=1
    const-string v0, ""
    if-eqz v2, +03eh
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v1
    if-nez v1, +00ah
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +029h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v2
    if-nez v2, +003h
    goto +21h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v2
    check-cast v0, Ljava/lang/String;
    return-object v0
    :try_start_0x20
.end method
