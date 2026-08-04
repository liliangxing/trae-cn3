# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/model/MessagePartNormalizer;
.super Ljava/lang/Object;
.source "MessagePartNormalizer.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/im/model/MessagePartNormalizer;
.field private static final gson$delegate:Lkotlin/Lazy;


.method public static synthetic $r8$lambda$4XxeInVZBDSo-5_k-D-b2YCf9VI()com.google.gson.Gson
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/im/model/MessagePartNormalizer;->gson_delegate$lambda$0()Lcom/google/gson/Gson;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    new-instance v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v0, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->gson$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static synthetic extractText$default(com.bytedance.trae.im.model.MessagePartNormalizer  java.util.List  java.lang.String  int  java.lang.Object)java.lang.String
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    const-string v2, ""
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->extractText(Ljava/util/List; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final getGson()com.google.gson.Gson
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->gson$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/Gson;
    return-object v0
.end method

.method private final getStringOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +010h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +006h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private static final gson_delegate$lambda$0()com.google.gson.Gson
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    return-object v0
.end method

.method private final normalizePart(com.google.gson.JsonElement)com.bytedance.trae.im.model.MessagePart
    .registers 12
    # ins_size=2
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v11
    invoke-static v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string/jumbo v0, type
    invoke-direct v10, v11, v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    const-string v3, "data"
    invoke-virtual v11, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v3, +01ah
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +010h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +00ah
    invoke-virtual v3, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +004h
    goto/16 +071h
    new-instance v3, Lcom/google/gson/JsonObject;
    invoke-direct v3, Lcom/google/gson/JsonObject;-><init>()V
    invoke-virtual v11, Lcom/google/gson/JsonObject;->entrySet()Ljava/util/Set;
    move-result-object v6
    const-string v7, "entrySet(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +018h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Ljava/util/Map$Entry;
    invoke-interface v9, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v9
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    xor-int/2addr v9, v5
    if-eqz v9, -016h
    invoke-interface v7, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v7, Ljava/util/List;
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01fh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/Map$Entry;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Ljava/lang/String;
    invoke-interface v6, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/google/gson/JsonElement;
    invoke-virtual v6, Lcom/google/gson/JsonElement;->deepCopy()Lcom/google/gson/JsonElement;
    move-result-object v6
    invoke-virtual v3, v7, v6, Lcom/google/gson/JsonObject;->add(Ljava/lang/String; Lcom/google/gson/JsonElement;)V
    goto -22h
    invoke-virtual v3, Lcom/google/gson/JsonObject;->size()I
    move-result v0
    if-lez v0, +004h
    move v0, v5
    goto +2h
    move v0, v4
    if-eqz v0, +003h
    goto +2h
    move-object v3, v1
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +054h
    invoke-direct v10, v3, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textFromData(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v6
    const-string v7, "content"
    if-nez v6, +015h
    invoke-direct v10, v11, v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +00fh
    const-string/jumbo v6, text_content
    invoke-direct v10, v11, v6, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +006h
    invoke-direct v10, v11, v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v11
    if-nez v11, +007h
    new-instance v11, Lcom/google/gson/JsonObject;
    invoke-direct v11, Lcom/google/gson/JsonObject;-><init>()V
    move-object v0, v6
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v4
    goto +2h
    move v0, v5
    if-nez v0, +00bh
    invoke-virtual v11, v7, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v0
    if-nez v0, +005h
    invoke-virtual v11, v7, v6, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v11, Lcom/google/gson/JsonObject;->size()I
    move-result v0
    if-lez v0, +003h
    move v4, v5
    if-eqz v4, +003h
    move-object v1, v11
    new-instance v11, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-direct v11, v2, v1, Lcom/bytedance/trae/im/model/MessagePart;-><init>(Ljava/lang/String; Lcom/google/gson/JsonObject;)V
    return-object v11
    move-object v11, v2
    check-cast v11, Ljava/lang/CharSequence;
    if-eqz v11, +008h
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-nez v11, +003h
    move v4, v5
    if-eqz v4, +005h
    if-nez v3, +003h
    return-object v1
    new-instance v11, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-direct v11, v2, v3, Lcom/bytedance/trae/im/model/MessagePart;-><init>(Ljava/lang/String; Lcom/google/gson/JsonObject;)V
    return-object v11
.end method

.method private final textFromData(com.google.gson.JsonObject)java.lang.String
    .registers 4
    # ins_size=2
    if-eqz v3, +00ah
    const-string v0, "content"
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-nez v0, +01bh
    const/4 v0, 0
    if-eqz v3, +00ah
    const-string/jumbo v1, text_content
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    goto +2h
    move-object v1, v0
    if-nez v1, +00ch
    if-eqz v3, +00bh
    const-string/jumbo v0, text
    invoke-direct v2, v3, v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    return-object v0
.end method

.method private final textPart(java.lang.String)com.bytedance.trae.im.model.MessagePart
    .registers 4
    # ins_size=2
    new-instance v0, Lcom/google/gson/JsonObject;
    invoke-direct v0, Lcom/google/gson/JsonObject;-><init>()V
    const-string v1, "content"
    invoke-virtual v0, v1, v3, Lcom/google/gson/JsonObject;->addProperty(Ljava/lang/String; Ljava/lang/String;)V
    new-instance v3, Lcom/bytedance/trae/im/model/MessagePart;
    const-string/jumbo v1, text
    invoke-direct v3, v1, v0, Lcom/bytedance/trae/im/model/MessagePart;-><init>(Ljava/lang/String; Lcom/google/gson/JsonObject;)V
    return-object v3
.end method

.method public final extractText(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 3
    # ins_size=2
    const-string v0, "part"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textFromData(Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final extractText(java.util.List  java.lang.String)java.lang.String
    .registers 16
    # ins_size=3
    const-string/jumbo v0, separator
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v14
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    const/4 v3, 0
    if-eqz v0, +003h
    return-object v3
    check-cast v14, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v14, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v14
    invoke-interface v14, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +01ah
    invoke-interface v14, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v5, v4
    check-cast v5, Lcom/bytedance/trae/im/model/MessagePart;
    invoke-virtual v5, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v6, text
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -018h
    invoke-interface v0, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v14, Ljava/util/ArrayList;
    invoke-direct v14, Ljava/util/ArrayList;-><init>()V
    check-cast v14, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/im/model/MessagePart;
    sget-object v5, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-virtual v5, v4, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->extractText(Lcom/bytedance/trae/im/model/MessagePart;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, -012h
    invoke-interface v14, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -17h
    check-cast v14, Ljava/util/List;
    move-object v4, v14
    check-cast v4, Ljava/lang/Iterable;
    move-object v5, v15
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/4 v10, 0
    const/16 v11, 62
    const/4 v12, 0
    invoke-static/range v4 ... v12, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    check-cast v14, Ljava/lang/CharSequence;
    invoke-interface v14, Ljava/lang/CharSequence;->length()I
    move-result v15
    if-nez v15, +003h
    move v1, v2
    if-eqz v1, +003h
    goto +2h
    move-object v3, v14
    check-cast v3, Ljava/lang/String;
    return-object v3
.end method

.method public final parseContent(com.google.gson.JsonElement)java.util.List
    .registers 5
    # ins_size=2
    const/4 v0, 0
    if-eqz v4, +0a6h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonNull()Z
    move-result v1
    if-eqz v1, +004h
    goto/16 +09eh
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v3
    check-cast v1, Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    if-eqz v1, +03fh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v4
    const-string v1, "getAsJsonArray(...)"
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +015h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/google/gson/JsonElement;
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v3, v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->normalizePart(Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v2
    if-eqz v2, -013h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -18h
    check-cast v1, Ljava/util/List;
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    move-object v1, v0
    check-cast v1, Ljava/util/List;
    goto +3bh
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +00dh
    invoke-direct v3, v4, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->normalizePart(Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v4
    if-eqz v4, +02fh
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    goto +2ah
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +024h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    goto +2h
    move-object v4, v0
    if-eqz v4, +00bh
    invoke-direct v3, v4, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textPart(Ljava/lang/String;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v4
    invoke-static v4, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    goto +2h
    move-object v1, v0
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v4
    check-cast v0, Ljava/util/List;
    return-object v0
    :try_start_0xb
.end method

.method public final parseContentString(java.lang.String)java.util.List
    .registers 9
    # ins_size=2
    const-string v0, "rawContent"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v8
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, {
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v1, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    const/4 v6, 1
    if-nez v2, +022h
    const-string v2, "["
    invoke-static v1, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v3, v6
    if-eqz v3, +003h
    goto +2h
    move-object v8, v5
    if-eqz v8, +00ch
    sget-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v0, v8, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textPart(Ljava/lang/String;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v8
    invoke-static v8, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    return-object v5
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v7
    check-cast v2, Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getGson()Lcom/google/gson/Gson;
    move-result-object v2
    const-class v4, Lcom/google/gson/JsonElement;
    invoke-virtual v2, v1, v4, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    goto +ch
    move-exception v1
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v1, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v1
    invoke-static v1, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    move-object v1, v5
    check-cast v1, Lcom/google/gson/JsonElement;
    invoke-virtual v7, v1, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->parseContent(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v1
    if-nez v1, +01ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v3, v6
    if-eqz v3, +003h
    goto +2h
    move-object v8, v5
    if-eqz v8, +00eh
    sget-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v0, v8, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textPart(Ljava/lang/String;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v8
    invoke-static v8, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    goto +2h
    move-object v5, v1
    return-object v5
    :try_start_0x3d
.end method

.method public final parseQuery(java.lang.String)java.util.List
    .registers 8
    # ins_size=2
    const-string v0, "queryString"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v7
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "["
    const/4 v3, 0
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v1, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +023h
    const-string/jumbo v2, {
    invoke-static v1, v2, v3, v4, v5, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +01ah
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    const/4 v3, 1
    if-eqz v3, +003h
    goto +2h
    move-object v7, v5
    if-eqz v7, +00ch
    sget-object v0, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->INSTANCE Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v0, v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->textPart(Ljava/lang/String;)Lcom/bytedance/trae/im/model/MessagePart;
    move-result-object v7
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v5
    return-object v5
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;
    invoke-direct v6, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->getGson()Lcom/google/gson/Gson;
    move-result-object v7
    const-class v0, Lcom/google/gson/JsonElement;
    invoke-virtual v7, v1, v0, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/google/gson/JsonElement;
    invoke-virtual v6, v7, Lcom/bytedance/trae/im/model/MessagePartNormalizer;->parseContent(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v5, v7
    check-cast v5, Ljava/util/List;
    return-object v5
    :try_start_0x3c
.end method
