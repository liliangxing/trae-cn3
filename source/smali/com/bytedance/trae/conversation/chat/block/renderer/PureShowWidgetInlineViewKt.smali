# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;
.super Ljava/lang/Object;
.source "PureShowWidgetInlineView.kt"


.method public static final synthetic access$readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->readString(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$readStringArray(com.google.gson.JsonObject  java.lang.String)java.util.List
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetInlineViewKt;->readStringArray(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private static final readString(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    const/4 v0, 0
    if-eqz v1, +024h
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v0, v1
    return-object v0
    :try_start_0x3
.end method

.method private static final readStringArray(com.google.gson.JsonObject  java.lang.String)java.util.List
    .registers 5
    # ins_size=2
    if-eqz v3, +05bh
    invoke-virtual v3, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +055h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v4
    const/4 v0, 0
    if-eqz v4, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +04ah
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v3
    if-nez v3, +003h
    goto +42h
    check-cast v3, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v3, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +02dh
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/google/gson/JsonElement;
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    goto +2h
    move-object v1, v0
    if-eqz v1, -02bh
    invoke-interface v4, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -30h
    check-cast v4, Ljava/util/List;
    goto +ah
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v3
    return-object v3
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v4
    return-object v4
    :try_start_0x2
.end method
