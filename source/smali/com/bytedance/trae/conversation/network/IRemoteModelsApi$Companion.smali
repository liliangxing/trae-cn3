# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
.super Ljava/lang/Object;
.source "IRemoteModelsApi.kt"

.field static final synthetic $$INSTANCE:Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
.field private static final CACHE_TYPE_PC:Ljava/lang/String;
.field private static final CACHE_TYPE_REMOTE:Ljava/lang/String;
.field private static final CODE_CLI_OFFLINE:I
.field private static final CODE_CLI_UNREGISTERED:I
.field private static final CODE_PC_MODEL_LIST_UNSUPPORTED:I
.field private static final TAG:Ljava/lang/String;
.field private static final modelListMemoryCache:Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    new-instance v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$currentModelListUserId(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->currentModelListUserId()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$findCliIdeVersion(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->findCliIdeVersion(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getCachedModelsOrAuto(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  java.lang.String)java.util.List
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->getCachedModelsOrAuto(Ljava/lang/String; Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$getModelListMemoryCache$p()com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    return-object v0
.end method

.method public static final synthetic access$isExpectedPcModelListBizCode(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  int)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->isExpectedPcModelListBizCode(I)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$isSuccessBizCode(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  int)boolean
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->isSuccessBizCode(I)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$minSupportedIdeVersion(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion)java.lang.String
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->minSupportedIdeVersion()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$normalizeModels(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.util.List)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->normalizeModels(Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$parseBizCode(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String)java.lang.Integer
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->parseBizCode(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$parseModels(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String)java.util.List
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->parseModels(Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$pcCacheKey(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  java.util.List)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->pcCacheKey(Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$putModelsCache(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner  java.lang.String  java.util.List)boolean
    .registers 4
    # ins_size=4
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->putModelsCache(Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner; Ljava/lang/String; Ljava/util/List;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$readBody(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  com.bytedance.retrofit2.mime.TypedInput)java.lang.String
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBody(Ljava/lang/String; Lcom/bytedance/retrofit2/mime/TypedInput;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$remoteCacheKey(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.util.List)java.lang.String
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->remoteCacheKey(Ljava/util/List;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final synthetic access$resolvePcCliInfo(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->resolvePcCliInfo(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final asArrayOrNull(com.google.gson.JsonElement)com.google.gson.JsonArray
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v1
    return-object v1
.end method

.method private final asObjectOrNull(com.google.gson.JsonElement)com.google.gson.JsonObject
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v1
    if-eqz v3, +006h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v1
    return-object v1
.end method

.method private final collectGroupedModels(com.google.gson.JsonElement)java.util.List
    .registers 35
    # ins_size=2
    invoke-virtual/range v34, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +015h
    invoke-virtual/range v34, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    const-string v2, "list"
    invoke-virtual v0, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    move-object/from16 v2, v33
    if-eqz v0, +014h
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asArrayOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;
    move-result-object v0
    goto +fh
    move-object/from16 v2, v33
    invoke-virtual/range v34, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v0
    if-eqz v0, +007h
    invoke-virtual/range v34, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    goto +2h
    move-object v0, v1
    if-nez v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    invoke-direct v3, Ljava/util/ArrayList;-><init>()V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +10ah
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/google/gson/JsonElement;
    sget-object v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v4
    if-eqz v4, +0ebh
    const-string v6, "models"
    invoke-virtual v4, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +0e3h
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asArrayOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;
    move-result-object v4
    if-eqz v4, +0ddh
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +0c7h
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/google/gson/JsonElement;
    sget-object v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v8
    const/4 v9, 1
    const/4 v10, 0
    if-eqz v8, +00ah
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->shouldDisplayModel(Lcom/google/gson/JsonObject;)Z
    move-result v11
    if-nez v11, +004h
    move v11, v9
    goto +2h
    move v11, v10
    if-eqz v11, +005h
    move-object v6, v1
    goto/16 +09fh
    const-string v11, "id"
    const-string v12, "model_name"
    const-string v13, "name"
    if-eqz v8, +010h
    filled-new-array v13, v12, v11, [Ljava/lang/String;
    move-result-object v14
    invoke-direct v7, v8, v14, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    if-nez v14, +003h
    goto +4h
    move-object/from16 v17, v14
    goto +15h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v14
    if-eqz v14, +003h
    goto +2h
    move-object v6, v1
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    move-object v14, v6
    goto +2h
    move-object v14, v1
    if-nez v14, -014h
    goto -2ch
    if-eqz v8, +015h
    const-string v6, "display_name"
    const-string/jumbo v14, title
    filled-new-array v6, v14, [Ljava/lang/String;
    move-result-object v6
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +4h
    move-object/from16 v18, v6
    goto +3h
    move-object/from16 v18, v17
    if-eqz v8, +012h
    const-string v6, "model_id"
    filled-new-array v11, v6, v12, v13, [Ljava/lang/String;
    move-result-object v6
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +4h
    move-object/from16 v16, v6
    goto +3h
    move-object/from16 v16, v17
    if-eqz v8, +006h
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBuiltin(Lcom/google/gson/JsonObject; Z)Z
    move-result v9
    move/from16 v19, v9
    if-eqz v8, +00eh
    const-string v6, "is_default"
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v6
    if-eqz v6, +006h
    invoke-virtual v6, Ljava/lang/Boolean;->booleanValue()Z
    move-result v10
    move/from16 v30, v10
    if-eqz v8, +012h
    move-object/from16 v9, v16
    move-object/from16 v10, v17
    move-object/from16 v11, v18
    move/from16 v12, v19
    move/from16 v13, v30
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->toRemoteModelItem(Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v6
    if-nez v6, +020h
    new-instance v6, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object v15, v6
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v28, 0
    const/16 v29, 0
    const/16 v31, 16368
    const/16 v32, 0
    invoke-direct/range v15 ... v32, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v6, -0c4h
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0c9h
    check-cast v5, Ljava/util/List;
    goto +2h
    move-object v5, v1
    if-nez v5, +006h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v5
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v3, v5, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto/16 -10ch
    check-cast v3, Ljava/util/List;
    return-object v3
.end method

.method private final varargs collectModels(com.google.gson.JsonElement  boolean  java.lang.String[])java.util.List
    .registers 35
    # ins_size=4
    move-object/from16 v0, v34
    invoke-virtual/range v32, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v1
    const/4 v2, 0
    const/4 v3, 0
    if-eqz v1, +00bh
    invoke-virtual/range v32, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +36h
    invoke-virtual/range v32, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +02dh
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    array-length v4, v0
    move v5, v2
    if-ge v5, v4, +01eh
    aget-object v6, v0, v5
    invoke-virtual/range v32, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v7
    invoke-virtual v7, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v6
    if-eqz v6, +009h
    sget-object v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asArrayOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonArray;
    move-result-object v6
    goto +2h
    move-object v6, v3
    if-eqz v6, +005h
    invoke-interface v1, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v5, v5, 1
    goto -1dh
    move-object v0, v1
    check-cast v0, Ljava/util/List;
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +0f1h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/google/gson/JsonArray;
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v4, Ljava/lang/Iterable;
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +0cah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/google/gson/JsonElement;
    sget-object v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->$$INSTANCE Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v8
    if-eqz v8, +00ah
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->shouldDisplayModel(Lcom/google/gson/JsonObject;)Z
    move-result v9
    if-nez v9, +004h
    const/4 v9, 1
    goto +2h
    move v9, v2
    if-eqz v9, +007h
    move/from16 v6, v33
    move-object v7, v3
    goto/16 +0a2h
    const-string v9, "id"
    const-string v10, "model_name"
    const-string v11, "name"
    if-eqz v8, +00fh
    filled-new-array v11, v10, v9, [Ljava/lang/String;
    move-result-object v12
    invoke-direct v7, v8, v12, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +003h
    goto +3h
    move-object v15, v12
    goto +15h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    move-object v6, v3
    if-eqz v6, +008h
    invoke-virtual v6, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v6
    move-object v12, v6
    goto +2h
    move-object v12, v3
    if-nez v12, -013h
    goto -2dh
    if-eqz v8, +015h
    const-string v6, "display_name"
    const-string/jumbo v12, title
    filled-new-array v6, v12, [Ljava/lang/String;
    move-result-object v6
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +4h
    move-object/from16 v16, v6
    goto +3h
    move-object/from16 v16, v15
    if-eqz v8, +011h
    const-string v6, "model_id"
    filled-new-array v9, v6, v10, v11, [Ljava/lang/String;
    move-result-object v6
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +003h
    goto +3h
    move-object v14, v6
    goto +2h
    move-object v14, v15
    move/from16 v6, v33
    if-eqz v8, +009h
    invoke-direct v7, v8, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBuiltin(Lcom/google/gson/JsonObject; Z)Z
    move-result v9
    move/from16 v17, v9
    goto +3h
    move/from16 v17, v6
    if-eqz v8, +011h
    const-string v9, "is_default"
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v9
    if-eqz v9, +009h
    invoke-virtual v9, Ljava/lang/Boolean;->booleanValue()Z
    move-result v9
    move/from16 v28, v9
    goto +3h
    move/from16 v28, v2
    if-eqz v8, +010h
    move-object v9, v14
    move-object v10, v15
    move-object/from16 v11, v16
    move/from16 v12, v17
    move/from16 v13, v28
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->toRemoteModelItem(Lcom/google/gson/JsonObject; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Z)Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v7
    if-nez v7, +020h
    new-instance v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object v13, v7
    const/16 v18, 0
    const/16 v19, 0
    const/16 v20, 0
    const/16 v21, 0
    const/16 v22, 0
    const/16 v23, 0
    const/16 v24, 0
    const/16 v25, 0
    const/16 v26, 0
    const/16 v27, 0
    const/16 v29, 16368
    const/16 v30, 0
    invoke-direct/range v13 ... v30, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    if-eqz v7, -0c7h
    invoke-interface v5, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -0cch
    move/from16 v6, v33
    check-cast v5, Ljava/util/List;
    check-cast v5, Ljava/lang/Iterable;
    invoke-static v1, v5, Lkotlin/collections/CollectionsKt;->addAll(Ljava/util/Collection; Ljava/lang/Iterable;)Z
    goto/16 -0f3h
    check-cast v1, Ljava/util/List;
    return-object v1
.end method

.method private final currentModelListUserId()java.lang.String
    .registers 4
    # ins_size=1
    const-class v0, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-static Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->get()Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;
    move-result-object v0
    const-class v1, Lcom/bytedance/trae/login/api/ILoginService;
    invoke-virtual v0, v1, Lcom/ss/android/ugc/aweme/framework/services/ServiceManager;->getService(Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/bytedance/trae/login/api/ILoginService;
    const/4 v1, 0
    if-eqz v0, +01ah
    invoke-interface v0, Lcom/bytedance/trae/login/api/ILoginService;->getAccountInfo()Lcom/bytedance/trae/login/api/AccountInfo;
    move-result-object v0
    if-eqz v0, +014h
    invoke-virtual v0, Lcom/bytedance/trae/login/api/AccountInfo;->getUserId()Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +00eh
    move-object v2, v0
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, +003h
    move-object v1, v0
    return-object v1
.end method

.method public static synthetic fetchModelsForUi$default(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.util.List  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 2
    if-eqz v4, +005h
    const-string/jumbo v2, unknown
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchModelsForUi(Ljava/util/List; Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic fetchPcModelsForUi$default(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  java.util.List  boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 19
    # ins_size=10
    and-int/lit8 v0, v17, 4
    if-eqz v0, +005h
    const/4 v0, 0
    move v4, v0
    goto +2h
    move v4, v12
    and-int/lit8 v0, v17, 8
    if-eqz v0, +005h
    const/4 v0, 0
    move-object v5, v0
    goto +2h
    move-object v5, v13
    and-int/lit8 v0, v17, 16
    if-eqz v0, +007h
    const-string/jumbo v0, unknown
    move-object v6, v0
    goto +2h
    move-object v6, v14
    and-int/lit8 v0, v17, 32
    if-eqz v0, +006h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    move-object v7, v0
    goto +2h
    move-object v7, v15
    move-object v1, v9
    move-object v2, v10
    move-object v3, v11
    move-object/from16 v8, v16
    invoke-virtual/range v1 ... v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->fetchPcModelsForUi(Ljava/lang/String; Ljava/util/List; Z Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final findCliIdeVersion(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;-><init>(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->label I
    const/4 v3, 1
    const/4 v4, 0
    if-eqz v2, +018h
    if-ne v2, v3, +00eh
    iget-object v7, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->L$0 Ljava/lang/Object;
    check-cast v7, Ljava/lang/String;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto/16 +06bh
    move-exception v7
    goto/16 +096h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    sget-object v8, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v8
    invoke-virtual v8, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +014h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -015h
    goto +2h
    move-object v2, v4
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    if-eqz v2, +007h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v8
    goto +2h
    move-object v8, v4
    move-object v2, v8
    check-cast v2, Ljava/lang/CharSequence;
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    move v2, v3
    if-nez v2, +003h
    return-object v8
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v8, v6
    check-cast v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    sget-object v8, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v8
    iput-object v7, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->L$0 Ljava/lang/Object;
    iput v3, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$findCliIdeVersion$1;->label I
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/CliListRepository;->getClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    check-cast v8, Ljava/lang/Iterable;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +014h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v7, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -015h
    goto +2h
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/im/service/Cli;
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v7
    goto +2h
    move-object v7, v4
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +bh
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    move-object v4, v7
    return-object v4
    :try_start_0x2b
    :try_start_0x83
.end method

.method private final findSingleOnlineLocalCli(java.util.List)com.bytedance.trae.im.service.Cli
    .registers 8
    # ins_size=2
    check-cast v7, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +052h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Lcom/bytedance/trae/im/service/Cli;
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v3
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v4, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v4
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    const/4 v4, 0
    if-nez v3, +012h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getType()Ljava/lang/String;
    move-result-object v3
    sget-object v5, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v5
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +024h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getStatus()Ljava/lang/String;
    move-result-object v3
    const-string v5, "online"
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +018h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v2, +00bh
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v4
    goto +2h
    move v2, v3
    if-nez v2, +003h
    move v4, v3
    if-eqz v4, -050h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -55h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/collections/CollectionsKt;->singleOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/im/service/Cli;
    return-object v7
.end method

.method private final getCachedModelsOrAuto(java.lang.String  java.lang.String)java.util.List
    .registers 9
    # ins_size=3
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    invoke-direct v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->currentModelListUserId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, v7, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->get(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/util/List;
    const-string v1, ", key="
    const-string v2, "IRemoteModelsApi"
    if-eqz v0, +068h
    sget-object v3, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v5, "getCachedModelsOrAuto: hit, reason="
    invoke-direct v4, v5, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", count="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-interface v0, Ljava/util/List;->size()I
    move-result v8
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v7
    const-string v8, ", names="
    invoke-virtual v7, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    move-object v8, v0
    check-cast v8, Ljava/lang/Iterable;
    const/4 v1, 6
    invoke-static v8, v1, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v8
    check-cast v8, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v8, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v4
    invoke-direct v1, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v8, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v8
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +010h
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v4
    invoke-interface v1, v4, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    invoke-virtual v7, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v3, v2, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v3, Ljava/lang/StringBuilder;
    const-string v4, "getCachedModelsOrAuto: miss, reason="
    invoke-direct v3, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v3, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v8
    invoke-virtual v8, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v7
    invoke-virtual v7, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v0, v2, v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v7
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    return-object v7
.end method

.method private final isExpectedPcModelListBizCode(int)boolean
    .registers 3
    # ins_size=2
    const v0, 2900101
    if-eq v2, v0, +00fh
    const v0, 2900102
    if-eq v2, v0, +00ah
    const v0, 2900104
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final isSuccessBizCode(int)boolean
    .registers 3
    # ins_size=2
    if-eqz v2, +009h
    const/16 v0, 200
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final minSupportedIdeVersion()java.lang.String
    .registers 2
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/network/ModelListSettings;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelListSettings;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/ModelListSettings;->minSupportedIdeVersion()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method private final modelListCacheKey(java.lang.String  java.lang.String  java.util.List)java.lang.String
    .registers 13
    # ins_size=4
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v0, v10, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    const/16 v0, 124
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, v0, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v10
    move-object v0, v12
    check-cast v0, Ljava/lang/Iterable;
    const-string v11, ","
    move-object v1, v11
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 62
    const/4 v8, 0
    invoke-static/range v0 ... v8, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    invoke-virtual v10, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v10
    return-object v10
.end method

.method private final normalizeBody(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    const-string v0, """
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v6, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +016h
    invoke-static v6, v0, v1, v2, v3, Lkotlin/text/StringsKt;->endsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +010h
    sget-object v0, Lcom/bytedance/trae/network/TraeHttpConnection;->INSTANCE Lcom/bytedance/trae/network/TraeHttpConnection;
    invoke-virtual v0, Lcom/bytedance/trae/network/TraeHttpConnection;->getHttpGson()Lcom/google/gson/Gson;
    move-result-object v0
    const-class v1, Ljava/lang/String;
    invoke-virtual v0, v6, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/String;
    const-string v0, "let(...)"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    return-object v6
.end method

.method private final normalizeModels(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    if-eqz v0, +00ch
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/List;
    return-object v2
.end method

.method private final parseBizCode(java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->normalizeBody(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    const-string v1, "parseString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v3
    if-eqz v3, +01dh
    const-string v1, "code"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +015h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    if-eqz v3, +00bh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    goto +2h
    move-object v3, v0
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v0, v3
    check-cast v0, Ljava/lang/Integer;
    return-object v0
    :try_start_0x1
.end method

.method private final parseModels(java.lang.String)java.util.List
    .registers 8
    # ins_size=2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v6
    check-cast v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->normalizeBody(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v7
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v0
    if-eqz v0, +00ch
    const-string v1, "data"
    invoke-virtual v0, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v7, v0
    const/4 v0, 1
    new-array v1, v0, [Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    sget-object v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    invoke-static v1, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const-string v2, "builtin_models"
    const-string v4, "built_in_models"
    const-string v5, "builtins"
    filled-new-array v2, v4, v5, [Ljava/lang/String;
    move-result-object v2
    invoke-direct v6, v7, v0, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->collectModels(Lcom/google/gson/JsonElement; Z [Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    const-string v2, "custom_models"
    const-string v4, "customModels"
    filled-new-array v2, v4, [Ljava/lang/String;
    move-result-object v2
    invoke-direct v6, v7, v3, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->collectModels(Lcom/google/gson/JsonElement; Z [Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, v2, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    const-string v2, "models"
    const-string v3, "items"
    filled-new-array v2, v3, [Ljava/lang/String;
    move-result-object v2
    invoke-direct v6, v7, v0, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->collectModels(Lcom/google/gson/JsonElement; Z [Ljava/lang/String;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/util/Collection;
    invoke-interface v1, v0, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->collectGroupedModels(Lcom/google/gson/JsonElement;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/Collection;
    invoke-interface v1, v7, Ljava/util/List;->addAll(Ljava/util/Collection;)Z
    check-cast v1, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/HashSet;
    invoke-direct v7, Ljava/util/HashSet;-><init>()V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +025h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +006h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/String;
    invoke-virtual v7, v4, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, -023h
    invoke-virtual v0, v2, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -28h
    check-cast v0, Ljava/util/List;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +ch
    move-exception v7
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v0
    if-nez v0, +003h
    goto +14h
    sget-object v7, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "IRemoteModelsApi"
    const-string v2, "parseModels failed"
    invoke-virtual v7, v1, v2, v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    sget-object v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v7
    invoke-static v7, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/util/List;
    return-object v7
    :try_start_0x0
.end method

.method private final pcCacheKey(java.lang.String  java.util.List)java.lang.String
    .registers 4
    # ins_size=3
    const-string v0, "pc"
    invoke-direct v1, v0, v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListCacheKey(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public static synthetic preloadOnAppStart$default(com.bytedance.trae.conversation.network.IRemoteModelsApi$Companion  java.lang.String  kotlin.coroutines.Continuation  int  java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 1
    if-eqz v3, +005h
    const-string/jumbo v1, unknown
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->preloadOnAppStart(Ljava/lang/String; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method private final putModelsCache(com.bytedance.trae.conversation.network.UserScopedModelListMemoryCache$Owner  java.lang.String  java.util.List)boolean
    .registers 7
    # ins_size=4
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    invoke-direct v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->currentModelListUserId()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v4, v1, v5, v6, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->putIfCurrent(Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache$Owner; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Object;)Z
    move-result v4
    const-string v0, "IRemoteModelsApi"
    if-nez v4, +018h
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v1, "putModelsCache: ignored because account changed, key="
    invoke-direct v6, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v6, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 0
    return v4
    sget-object v4, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "putModelsCache: key="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", count="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", names="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    check-cast v6, Ljava/lang/Iterable;
    const/4 v1, 6
    invoke-static v6, v1, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v1, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v6, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v1, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v1, Ljava/util/List;
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v0, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    const/4 v4, 1
    return v4
.end method

.method private final readBody(java.lang.String  com.bytedance.retrofit2.mime.TypedInput)java.lang.String
    .registers 5
    # ins_size=3
    if-nez v3, +03ah
    const/4 v3, 0
    if-eqz v4, +037h
    invoke-interface v4, Lcom/bytedance/retrofit2/mime/TypedInput;->in()Ljava/io/InputStream;
    move-result-object v4
    if-eqz v4, +031h
    sget-object v0, Lkotlin/text/Charsets;->UTF_8 Ljava/nio/charset/Charset;
    new-instance v1, Ljava/io/InputStreamReader;
    invoke-direct v1, v4, v0, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream; Ljava/nio/charset/Charset;)V
    check-cast v1, Ljava/io/Reader;
    instance-of v4, v1, Ljava/io/BufferedReader;
    if-eqz v4, +005h
    check-cast v1, Ljava/io/BufferedReader;
    goto +9h
    new-instance v4, Ljava/io/BufferedReader;
    const/16 v0, 8192
    invoke-direct v4, v1, v0, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader; I)V
    move-object v1, v4
    check-cast v1, Ljava/io/Closeable;
    move-object v4, v1
    check-cast v4, Ljava/io/BufferedReader;
    check-cast v4, Ljava/io/Reader;
    invoke-static v4, Lkotlin/io/TextStreamsKt;->readText(Ljava/io/Reader;)Ljava/lang/String;
    move-result-object v4
    invoke-static v1, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    move-object v3, v4
    goto +8h
    move-exception v3
    throw v3
    move-exception v4
    invoke-static v1, v3, Lkotlin/io/CloseableKt;->closeFinally(Ljava/io/Closeable; Ljava/lang/Throwable;)V
    throw v4
    return-object v3
    :try_start_0x25
    :try_start_0x34
.end method

.method private final readBoolean(com.google.gson.JsonObject  java.lang.String)java.lang.Boolean
    .registers 7
    # ins_size=3
    invoke-virtual v5, v6, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    const/4 v6, 0
    if-eqz v5, +0cah
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v5, v6
    if-eqz v5, +0c0h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsJsonPrimitive()Lcom/google/gson/JsonPrimitive;
    move-result-object v5
    if-nez v5, +004h
    goto/16 +0b8h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->isBoolean()Z
    move-result v0
    if-eqz v0, +00ch
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->getAsBoolean()Z
    move-result v5
    invoke-static v5, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    goto/16 +08ch
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->isNumber()Z
    move-result v0
    const/4 v1, 0
    const/4 v2, 1
    if-eqz v0, +018h
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->getAsInt()I
    move-result v5
    if-eqz v5, +00ch
    if-eq v5, v2, +004h
    goto/16 +079h
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    goto/16 +074h
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    goto/16 +06eh
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->isString()Z
    move-result v0
    if-eqz v0, +067h
    invoke-virtual v5, Lcom/google/gson/JsonPrimitive;->getAsString()Ljava/lang/String;
    move-result-object v5
    const-string v0, "getAsString(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v5, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Ljava/lang/String;->hashCode()I
    move-result v0
    const/16 v3, 48
    if-eq v0, v3, +032h
    const/16 v3, 49
    if-eq v0, v3, +020h
    const v3, 3569038
    if-eq v0, v3, +011h
    const v2, 97196323
    if-eq v0, v2, +003h
    goto +2ah
    const-string v0, "false"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +024h
    goto +21h
    const-string/jumbo v0, true
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00ch
    goto +17h
    const-string v0, "1"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +eh
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    goto +10h
    const-string v0, "0"
    invoke-virtual v5, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    goto +6h
    invoke-static v1, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v5
    goto +2h
    move-object v5, v6
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    goto +ch
    move-exception v5
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v5, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    invoke-static v5, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v6, v5
    check-cast v6, Ljava/lang/Boolean;
    return-object v6
    :try_start_0x19
.end method

.method private final readBuiltin(com.google.gson.JsonObject  boolean)boolean
    .registers 10
    # ins_size=3
    const-string v0, "is_builtin"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    return v8
    const-string v0, "builtin"
    invoke-direct v7, v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    return v8
    const-string v1, "config_source"
    invoke-direct v7, v8, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v1
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +013h
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    const/4 v4, 3
    if-ne v1, v4, +003h
    return v2
    if-eq v1, v3, +006h
    const/4 v4, 2
    if-eq v1, v4, +003h
    goto +2h
    return v3
    const-string v1, "is_preset"
    invoke-direct v7, v8, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v1
    if-eqz v1, +007h
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v8
    return v8
    const-string/jumbo v1, source
    const-string v4, "account_type"
    const-string/jumbo v5, type
    const-string v6, "model_type"
    filled-new-array v5, v6, v1, v4, [Ljava/lang/String;
    move-result-object v1
    invoke-direct v7, v8, v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-eqz v8, +00fh
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v8, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +2h
    const/4 v8, 0
    if-eqz v8, +056h
    invoke-virtual v8, Ljava/lang/String;->hashCode()I
    move-result v1
    sparse-switch v1, +0000052h
    goto +4dh
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +047h
    goto +46h
    const-string/jumbo v0, user
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +032h
    goto +3ch
    const-string v0, "byok"
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +035h
    goto +27h
    const-string/jumbo v0, user_custom
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +01fh
    goto +29h
    const-string v0, "official"
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +021h
    goto +20h
    const-string/jumbo v0, system
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +017h
    goto +16h
    const-string v0, "custom"
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    goto +dh
    move v9, v2
    goto +bh
    const-string v0, "built_in"
    invoke-virtual v8, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +003h
    goto +2h
    move v9, v3
    return v9
    nop 
    sparse-switch-payload -553ecd7a -5069748f -34e38dd1 -2d9d6515 -24302d9b 2e6073 36ebcb dc42c23
.end method

.method private final readInt(com.google.gson.JsonObject  java.lang.String)java.lang.Integer
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +030h
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v2, v3
    if-eqz v2, +026h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsInt()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    goto +ch
    move-exception v2
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v2, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    invoke-static v2, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v2
    check-cast v3, Ljava/lang/Integer;
    return-object v3
    :try_start_0x11
.end method

.method private final varargs readString(com.google.gson.JsonObject  java.lang.String[])java.lang.String
    .registers 9
    # ins_size=3
    array-length v0, v8
    const/4 v1, 0
    move v2, v1
    const/4 v3, 0
    if-ge v2, v0, +02dh
    aget-object v4, v8, v2
    invoke-virtual v7, v4, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v4
    if-eqz v4, +010h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v5
    if-eqz v5, +003h
    goto +2h
    move-object v4, v3
    if-eqz v4, +006h
    invoke-virtual v4, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    move-object v4, v3
    check-cast v4, Ljava/lang/CharSequence;
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-eqz v4, +003h
    goto +3h
    move v4, v1
    goto +2h
    const/4 v4, 1
    if-nez v4, +003h
    return-object v3
    add-int/lit8 v2, v2, 1
    goto -2dh
    return-object v3
.end method

.method private final remoteCacheKey(java.util.List)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, "remote"
    const-string v1, ""
    invoke-direct v2, v0, v1, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListCacheKey(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v3
    return-object v3
.end method

.method private final resolveCachedPcCliId(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    return-object v4
    sget-object v4, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v4
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->findSingleOnlineLocalCli(Ljava/util/List;)Lcom/bytedance/trae/im/service/Cli;
    move-result-object v4
    if-eqz v4, +007h
    invoke-virtual v4, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v4
    goto +2h
    const/4 v4, 0
    if-nez v4, +004h
    const-string v4, ""
    move-object v0, v4
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +018h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getCachedModelsForUi: resolved empty cliId from cache, cliId="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "IRemoteModelsApi"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
.end method

.method private final resolvePcCliInfo(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 9
    # ins_size=3
    instance-of v0, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;
    if-eqz v0, +012h
    move-object v0, v8
    check-cast v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;
    iget v1, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->label I
    const/high16 v2, -2147483648
    and-int/2addr v1, v2
    if-eqz v1, +008h
    iget v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->label I
    sub-int/2addr v8, v2
    iput v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->label I
    goto +6h
    new-instance v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;
    invoke-direct v0, v6, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;-><init>(Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion; Lkotlin/coroutines/Continuation;)V
    iget-object v8, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->result Ljava/lang/Object;
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v1
    iget v2, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->label I
    const-string v3, ""
    const/4 v4, 0
    const/4 v5, 1
    if-eqz v2, +016h
    if-ne v2, v5, +00ch
    iget-object v7, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->L$0 Ljava/lang/Object;
    check-cast v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    goto +57h
    move-exception v7
    goto +60h
    new-instance v7, Ljava/lang/IllegalStateException;
    const-string v8, "call to 'resume' before 'invoke' with coroutine"
    invoke-direct v7, v8, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V
    throw v7
    invoke-static v8, Lkotlin/ResultKt;->throwOnFailure(Ljava/lang/Object;)V
    move-object v8, v7
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v8
    xor-int/2addr v8, v5
    if-eqz v8, +008h
    new-instance v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;
    invoke-direct v8, v7, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v8
    sget-object v7, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/CliListRepository;->getCacheClis()Ljava/util/List;
    move-result-object v7
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->findSingleOnlineLocalCli(Ljava/util/List;)Lcom/bytedance/trae/im/service/Cli;
    move-result-object v7
    if-eqz v7, +014h
    new-instance v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v3, v0
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v7
    invoke-direct v8, v3, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v8
    sget-object v7, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v7, v6
    check-cast v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    sget-object v7, Lcom/bytedance/trae/conversation/CliListRepository;->Companion Lcom/bytedance/trae/conversation/CliListRepository$Companion;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/CliListRepository$Companion;->getInstance()Lcom/bytedance/trae/conversation/CliListRepository;
    move-result-object v7
    iput-object v6, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->L$0 Ljava/lang/Object;
    iput v5, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$resolvePcCliInfo$1;->label I
    invoke-virtual v7, v0, Lcom/bytedance/trae/conversation/CliListRepository;->getClis(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v8
    if-ne v8, v1, +003h
    return-object v1
    move-object v7, v6
    check-cast v8, Ljava/util/List;
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->findSingleOnlineLocalCli(Ljava/util/List;)Lcom/bytedance/trae/im/service/Cli;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    goto +bh
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v7, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    invoke-static v7, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    move-object v7, v4
    check-cast v7, Lcom/bytedance/trae/im/service/Cli;
    if-eqz v7, +013h
    new-instance v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Cli;->getId()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    invoke-virtual v7, Lcom/bytedance/trae/im/service/Cli;->getIdeVersion()Ljava/lang/String;
    move-result-object v7
    invoke-direct v4, v3, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$PcCliInfo;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v4
    :try_start_0x2d
    :try_start_0x70
.end method

.method private final shouldDisplayModel(com.google.gson.JsonObject)boolean
    .registers 5
    # ins_size=2
    const-string/jumbo v0, status
    invoke-virtual v4, v0, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v1
    const/4 v2, 1
    if-nez v1, +003h
    return v2
    invoke-direct v3, v4, v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v4
    invoke-static v2, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    return v4
.end method

.method private final toRemoteModelItem(com.google.gson.JsonObject  java.lang.String  java.lang.String  java.lang.String  boolean  boolean)com.bytedance.trae.conversation.network.RemoteModelItem
    .registers 26
    # ins_size=7
    move-object/from16 v0, v19
    move-object/from16 v1, v20
    const-string v2, "config_source"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readInt(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v10
    const-string v2, "icon"
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-eqz v2, +007h
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->asObjectOrNull(Lcom/google/gson/JsonElement;)Lcom/google/gson/JsonObject;
    move-result-object v2
    goto +2h
    move-object v2, v3
    const-string v4, "features"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v16
    const-string v4, "multimodal"
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v8
    const-string v4, "is_preset"
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v4
    const/4 v5, 0
    if-nez v4, +017h
    if-eqz v10, +013h
    move-object v4, v10
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    const/4 v6, 1
    if-ne v4, v6, +003h
    goto +2h
    move v6, v5
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    goto +3h
    move-object v9, v3
    goto +2h
    move-object v9, v4
    const-string v4, "provider"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    const-string v4, "custom_model_id"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v1, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    if-eqz v2, +00eh
    const-string v4, "light"
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v2, v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    move-object v13, v4
    goto +2h
    move-object v13, v3
    if-eqz v2, +00eh
    const-string v3, "dark"
    filled-new-array v3, [Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readString(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    move-object v14, v2
    goto +2h
    move-object v14, v3
    const-string v2, "is_internal_usage_limit"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v15
    invoke-virtual/range v20, Lcom/google/gson/JsonObject;->deepCopy()Lcom/google/gson/JsonObject;
    move-result-object v17
    const-string v2, "is_default"
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->readBoolean(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/Boolean;
    move-result-object v1
    if-eqz v1, +009h
    invoke-virtual v1, Ljava/lang/Boolean;->booleanValue()Z
    move-result v1
    move/from16 v18, v1
    goto +3h
    move/from16 v18, v5
    new-instance v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-object v3, v1
    move-object/from16 v4, v21
    move-object/from16 v5, v22
    move-object/from16 v6, v23
    move/from16 v7, v24
    invoke-direct/range v3 ... v18, Lcom/bytedance/trae/conversation/network/RemoteModelItem;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z Ljava/lang/Boolean; Ljava/lang/Boolean; Ljava/lang/Integer; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/Boolean; Ljava/lang/String; Lcom/google/gson/JsonObject; Z)V
    return-object v1
.end method

.method public final fetchModelsForUi(java.util.List  java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 7
    # ins_size=4
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;
    const/4 v2, 0
    invoke-direct v1, v5, v4, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchModelsForUi$2;-><init>(Ljava/lang/String; Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v6, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    return-object v4
.end method

.method public final fetchPcModelsForUi(java.lang.String  java.util.List  boolean  java.lang.String  java.lang.String  com.bytedance.trae.im.service.CliType  kotlin.coroutines.Continuation)java.lang.Object
    .registers 18
    # ins_size=8
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v9, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;
    const/4 v8, 0
    move-object v1, v9
    move-object v2, v15
    move-object/from16 v3, v16
    move-object v4, v11
    move-object v5, v12
    move v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v8, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$fetchPcModelsForUi$2;-><init>(Ljava/lang/String; Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/util/List; Z Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v9, Lkotlin/jvm/functions/Function2;
    move-object/from16 v1, v17
    invoke-static v0, v9, v1, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v0
    return-object v0
.end method

.method public final getCachedModelsForUi(com.bytedance.trae.im.service.CliType  java.lang.String  java.util.List)java.util.List
    .registers 8
    # ins_size=4
    const-string v0, "cliType"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "cliId"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "functions"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v7, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v5, 0
    return-object v5
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-eq v5, v0, +006h
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v5, v0, +006h
    invoke-direct v4, v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->resolveCachedPcCliId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v5, Lcom/bytedance/trae/im/service/CliType;->ordinal()I
    move-result v5
    aget v5, v0, v5
    const/4 v0, 1
    if-eq v5, v0, +018h
    const/4 v0, 2
    if-eq v5, v0, +010h
    const/4 v6, 3
    if-ne v5, v6, +007h
    invoke-direct v4, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->remoteCacheKey(Ljava/util/List;)Ljava/lang/String;
    move-result-object v5
    goto +10h
    new-instance v5, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v5, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v5
    invoke-direct v4, v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->pcCacheKey(Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v5
    goto +5h
    invoke-direct v4, v6, v7, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->pcCacheKey(Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v5
    sget-object v6, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    invoke-direct v4, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->currentModelListUserId()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, v5, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->get(Ljava/lang/String; Ljava/lang/String;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/util/List;
    const-string v7, "IRemoteModelsApi"
    if-eqz v6, +060h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getCachedModelsForUi: hit, key="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", count="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-interface v6, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v5
    const-string v1, ", names="
    invoke-virtual v5, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    move-object v1, v6
    check-cast v1, Ljava/lang/Iterable;
    const/4 v2, 6
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v1, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +010h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v2, Ljava/util/List;
    invoke-virtual v5, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v7, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    goto +15h
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "getCachedModelsForUi: miss, key="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v0, v7, v5, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-object v6
.end method

.method public final onAccountChanged()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->modelListMemoryCache Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/UserScopedModelListMemoryCache;->onAccountChanged()V
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "IRemoteModelsApi"
    const-string v2, "onAccountChanged: model list cache invalidated"
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final preloadOnAppStart(java.lang.String  kotlin.coroutines.Continuation)java.lang.Object
    .registers 6
    # ins_size=3
    invoke-static Lkotlinx/coroutines/Dispatchers;->getIO()Lkotlinx/coroutines/CoroutineDispatcher;
    move-result-object v0
    check-cast v0, Lkotlin/coroutines/CoroutineContext;
    new-instance v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;
    const/4 v2, 0
    invoke-direct v1, v4, v2, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion$preloadOnAppStart$2;-><init>(Ljava/lang/String; Lkotlin/coroutines/Continuation;)V
    check-cast v1, Lkotlin/jvm/functions/Function2;
    invoke-static v0, v1, v5, Lkotlinx/coroutines/BuildersKt;->withContext(Lkotlin/coroutines/CoroutineContext; Lkotlin/jvm/functions/Function2; Lkotlin/coroutines/Continuation;)Ljava/lang/Object;
    move-result-object v4
    invoke-static Lkotlin/coroutines/intrinsics/IntrinsicsKt;->getCOROUTINE_SUSPENDED()Ljava/lang/Object;
    move-result-object v5
    if-ne v4, v5, +003h
    return-object v4
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v4
.end method
