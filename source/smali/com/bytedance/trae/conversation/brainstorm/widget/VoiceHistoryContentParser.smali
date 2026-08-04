# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
.super Ljava/lang/Object;
.source "VoiceHistoryContentParser.kt"

.field private static final CHAT_SESSION_ID_KEYS:Ljava/util/List;
.field private static final IMAGE_EXT:Ljava/util/Set;
.field public static final INSTANCE:Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
.field private static final REMOTE_RESOURCE_PREFIX:Ljava/lang/String;
.field private static final TAG:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    const-string v1, "chat_session_id"
    const-string v2, "chatSessionId"
    const-string v3, "cli_conversation_id"
    const-string v4, "cliConversationId"
    const-string v5, "parent_chat_session_id"
    const-string v6, "parentChatSessionId"
    const-string/jumbo v7, voice_conversation_id
    const-string/jumbo v8, voiceConversationId
    const-string/jumbo v9, session_id
    const-string/jumbo v10, sessionId
    const-string/jumbo v11, session
    filled-new-array/range v1 ... v11, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->CHAT_SESSION_ID_KEYS Ljava/util/List;
    const-string v1, "jpg"
    const-string v2, "jpeg"
    const-string v3, "png"
    const-string v4, "gif"
    const-string/jumbo v5, webp
    const-string v6, "bmp"
    const-string v7, "heic"
    const-string v8, "heif"
    filled-new-array/range v1 ... v8, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->IMAGE_EXT Ljava/util/Set;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final varargs extractChatSessionId(com.google.gson.JsonObject[])java.lang.String
    .registers 9
    # ins_size=2
    array-length v0, v8
    const/4 v1, 0
    const/4 v2, 0
    if-ge v1, v0, +03fh
    aget-object v3, v8, v1
    sget-object v4, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->CHAT_SESSION_ID_KEYS Ljava/util/List;
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +02eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    invoke-virtual v3, v5, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v5
    if-eqz v5, +01eh
    invoke-virtual v5, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v6
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    if-eqz v5, +014h
    invoke-virtual v5, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +00eh
    move-object v6, v5
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v6
    xor-int/lit8 v6, v6, 1
    if-eqz v6, +003h
    goto +2h
    move-object v5, v2
    if-eqz v5, -02fh
    return-object v5
    add-int/lit8 v1, v1, 1
    goto -3fh
    return-object v2
.end method

.method private final fallbackFilenameFromUri(java.lang.String)java.lang.String
    .registers 4
    # ins_size=2
    const/16 v0, 47
    const-string v1, ""
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    const-string v3, "file"
    check-cast v3, Ljava/lang/String;
    return-object v3
.end method

.method private final isImageByFilename(java.lang.String)boolean
    .registers 4
    # ins_size=2
    const/16 v0, 46
    const-string v1, ""
    invoke-static v3, v0, v1, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v3, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v3
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->IMAGE_EXT Ljava/util/Set;
    invoke-interface v0, v3, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v3
    return v3
.end method

.method private final normalizeImageUri(java.lang.String)java.lang.String
    .registers 6
    # ins_size=2
    const/4 v0, 0
    if-eqz v5, +00dh
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    goto +2h
    move-object v5, v0
    if-nez v5, +004h
    const-string v5, ""
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v5, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v5
    const/4 v1, 0
    const/4 v2, 2
    const-string/jumbo v3, tos-
    invoke-static v5, v3, v1, v2, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v5
    return-object v0
.end method

.method private final normalizeRemoteResourceUri(java.lang.String)java.lang.String
    .registers 7
    # ins_size=2
    const/4 v0, 0
    if-eqz v6, +00dh
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    goto +2h
    move-object v6, v0
    if-nez v6, +004h
    const-string v6, ""
    move-object v1, v6
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    const/4 v2, 0
    const/4 v3, 2
    invoke-static v6, v1, v2, v3, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move-object v0, v6
    goto +17h
    const-string/jumbo v4, tos-
    invoke-static v6, v4, v2, v3, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00fh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v6, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public final parseUserContent(java.lang.String)java.util.List
    .registers 34
    # ins_size=2
    move-object/from16 v1, v32
    const-string v2, "image"
    if-eqz v33, +00fh
    move-object/from16 v0, v33
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    const-string v4, ""
    if-nez v0, +004h
    move-object v5, v4
    goto +2h
    move-object v5, v0
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v6, 0
    const/4 v7, 1
    if-nez v0, +004h
    move v0, v7
    goto +2h
    move v0, v6
    if-eqz v0, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    invoke-static v5, Lcom/google/gson/JsonParser;->parseString(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v8, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +003h
    const/4 v0, 0
    check-cast v0, Lcom/google/gson/JsonElement;
    if-eqz v0, +2b5h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonArray()Z
    move-result v8
    if-eqz v8, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +2abh
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonArray()Lcom/google/gson/JsonArray;
    move-result-object v0
    if-eqz v0, +2a5h
    new-instance v5, Ljava/util/ArrayList;
    invoke-virtual v0, Lcom/google/gson/JsonArray;->size()I
    move-result v8
    invoke-direct v5, v8, Ljava/util/ArrayList;-><init>(I)V
    invoke-virtual v0, Lcom/google/gson/JsonArray;->iterator()Ljava/util/Iterator;
    move-result-object v8
    const-string v0, "iterator(...)"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v8, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +28ah
    invoke-interface v8, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonElement;
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v9
    if-eqz v9, -010h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v0
    const-string/jumbo v9, type
    invoke-virtual v0, v9, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v9
    if-eqz v9, +011h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v10
    if-eqz v10, +003h
    goto +2h
    const/4 v9, 0
    if-eqz v9, +007h
    invoke-virtual v9, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v9
    goto +2h
    const/4 v9, 0
    if-nez v9, +003h
    move-object v9, v4
    const-string v10, "data"
    invoke-virtual v0, v10, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v10
    if-eqz v10, -038h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v11
    if-eqz v11, +003h
    goto +2h
    const/4 v10, 0
    if-eqz v10, -042h
    invoke-virtual v10, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v10
    if-nez v10, +003h
    goto -4ah
    invoke-virtual v9, Ljava/lang/String;->hashCode()I
    move-result v11
    const v12, -1963501277
    const-string v15, "file_size"
    const-string v3, "filename"
    const-string/jumbo v13, uri
    const/4 v14, 2
    if-eq v11, v12, +142h
    const v12, 3556653
    if-eq v11, v12, +102h
    const v12, 100313435
    if-eq v11, v12, +003h
    goto -66h
    invoke-virtual v9, v2, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +003h
    goto -6dh
    const-string v11, "image_id"
    invoke-virtual v10, v11, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +011h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    if-nez v11, +005h
    move-object/from16 v22, v4
    goto +3h
    move-object/from16 v22, v11
    invoke-virtual v10, v13, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +011h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    if-nez v11, +003h
    move-object v11, v4
    invoke-virtual v10, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual v10, v15, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +013h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    const/4 v12, 0
    if-eqz v12, +009h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v12
    move-wide/from16 v27, v12
    goto +3h
    const-wide/16 v27, 0
    move-object/from16 v12, v22
    check-cast v12, Ljava/lang/CharSequence;
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-lez v12, +004h
    move v12, v7
    goto +2h
    move v12, v6
    if-eqz v12, +030h
    move-object v11, v5
    check-cast v11, Ljava/util/Collection;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v12
    if-eqz v12, +003h
    move-object v3, v2
    move-object/from16 v18, v3
    check-cast v18, Ljava/lang/String;
    const/16 v19, 1
    const/16 v23, 0
    new-array v3, v14, [Lcom/google/gson/JsonObject;
    aput-object v10, v3, v6
    aput-object v0, v3, v7
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->extractChatSessionId([Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v24
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    move-object/from16 v16, v0
    move-object/from16 v17, v22
    move-wide/from16 v20, v27
    invoke-direct/range v16 ... v24, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v11, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -113h
    move-object v12, v11
    check-cast v12, Ljava/lang/CharSequence;
    invoke-interface v12, Ljava/lang/CharSequence;->length()I
    move-result v12
    if-lez v12, +004h
    move v12, v7
    goto +2h
    move v12, v6
    if-eqz v12, -121h
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->normalizeImageUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v29
    move-object v12, v5
    check-cast v12, Ljava/util/Collection;
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    if-eqz v13, +008h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    invoke-direct v3, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->fallbackFilenameFromUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    move-object/from16 v25, v3
    check-cast v25, Ljava/lang/String;
    const/16 v26, 1
    if-nez v29, +009h
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    move-object/from16 v30, v3
    goto +3h
    const/16 v30, 0
    new-array v3, v14, [Lcom/google/gson/JsonObject;
    aput-object v10, v3, v6
    aput-object v0, v3, v7
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->extractChatSessionId([Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v31
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    move-object/from16 v23, v0
    move-object/from16 v24, v11
    invoke-direct/range v23 ... v31, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v12, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -15fh
    const-string/jumbo v0, text
    invoke-virtual v9, v0, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, -168h
    const-string v0, "content"
    invoke-virtual v10, v0, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v0
    if-eqz v0, +011h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v3
    if-eqz v3, +003h
    goto +2h
    const/4 v0, 0
    if-eqz v0, +007h
    invoke-virtual v0, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    move-object v0, v4
    move-object v3, v0
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v3
    xor-int/2addr v3, v7
    if-eqz v3, -18dh
    move-object v3, v5
    check-cast v3, Ljava/util/Collection;
    new-instance v10, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;
    invoke-direct v10, v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;-><init>(Ljava/lang/String; Z)V
    invoke-interface v3, v10, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -19ah
    const-string v11, "attachment"
    invoke-virtual v9, v11, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +004h
    goto/16 -1a4h
    invoke-virtual v10, v13, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v11
    if-eqz v11, +011h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v11, 0
    if-eqz v11, +007h
    invoke-virtual v11, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v11
    goto +2h
    const/4 v11, 0
    if-nez v11, +003h
    move-object v11, v4
    invoke-virtual v10, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-eqz v3, +011h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v12
    if-eqz v12, +003h
    goto +2h
    const/4 v3, 0
    if-eqz v3, +007h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    goto +2h
    const/4 v3, 0
    if-nez v3, +003h
    move-object v3, v4
    invoke-virtual v10, v15, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +013h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    const/4 v12, 0
    if-eqz v12, +009h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsLong()J
    move-result-wide v12
    move-wide/from16 v20, v12
    goto +3h
    const-wide/16 v20, 0
    const-string/jumbo v12, tos_oid
    invoke-virtual v10, v12, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v12
    if-eqz v12, +011h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v13
    if-eqz v13, +003h
    goto +2h
    const/4 v12, 0
    if-eqz v12, +007h
    invoke-virtual v12, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v12
    goto +2h
    const/4 v12, 0
    if-nez v12, +003h
    move-object v12, v4
    move-object v13, v11
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +004h
    move v13, v7
    goto +2h
    move v13, v6
    if-nez v13, +010h
    move-object v13, v12
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +004h
    move v13, v7
    goto +2h
    move v13, v6
    if-eqz v13, -227h
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    if-eqz v13, +014h
    sget-object v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->INSTANCE Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;
    move-object v13, v11
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v15
    if-eqz v15, +003h
    move-object v13, v12
    check-cast v13, Ljava/lang/String;
    invoke-direct v3, v13, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->fallbackFilenameFromUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->isImageByFilename(Ljava/lang/String;)Z
    move-result v19
    move-object v13, v5
    check-cast v13, Ljava/util/Collection;
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;
    const/16 v22, 0
    invoke-direct v1, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    if-nez v12, +006h
    invoke-direct v1, v11, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    move-object/from16 v23, v12
    new-array v12, v14, [Lcom/google/gson/JsonObject;
    aput-object v10, v12, v6
    aput-object v0, v12, v7
    invoke-direct v1, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/VoiceHistoryContentParser;->extractChatSessionId([Lcom/google/gson/JsonObject;)Ljava/lang/String;
    move-result-object v24
    move-object/from16 v16, v15
    move-object/from16 v17, v11
    move-object/from16 v18, v3
    invoke-direct/range v16 ... v24, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Attachment;-><init>(Ljava/lang/String; Ljava/lang/String; Z J Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    invoke-interface v13, v15, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto/16 -272h
    move-exception v0
    sget-object v3, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v10, Ljava/lang/StringBuilder;
    const-string/jumbo v11, skip malformed part: type=
    invoke-direct v10, v11, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v10, v9, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v9
    const-string v10, "VoiceHistoryParser"
    invoke-virtual v3, v10, v9, v0, Lcom/bytedance/trae/utils/logger/FLogger;->w(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)V
    goto/16 -28ch
    check-cast v5, Ljava/util/List;
    return-object v5
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;
    invoke-direct v0, v5, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/UserHistoryPart$Text;-><init>(Ljava/lang/String; Z)V
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
    :try_start_0x30
    :try_start_0xc1
    :try_start_0xdd
.end method
