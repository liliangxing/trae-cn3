# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;
.super Ljava/lang/Object;
.source "UserMessageViewHolder.kt"

.field private static final AGENT_TYPE_VOICE_SUMMARY:Ljava/lang/String;
.field private static final CHAT_SESSION_ID_KEYS:Ljava/util/List;
.field private static final REMOTE_RESOURCE_PREFIX:Ljava/lang/String;
.field private static final USER_MESSAGE_ATTACHMENT_TAG:Ljava/lang/String;
.field private static final USER_MESSAGE_IMAGE_EXTENSIONS:Ljava/util/Set;
.field private static final USER_MESSAGE_REMOTE_RESOURCE_CACHE_DIR:Ljava/lang/String;


.method static constructor <clinit>()void
    .registers 12
    # ins_size=0
    const-string v0, "jpg"
    const-string v1, "jpeg"
    const-string v2, "png"
    const-string v3, "gif"
    const-string/jumbo v4, webp
    const-string v5, "bmp"
    const-string v6, "heic"
    const-string v7, "heif"
    filled-new-array/range v0 ... v7, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->USER_MESSAGE_IMAGE_EXTENSIONS Ljava/util/Set;
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
    sput-object v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->CHAT_SESSION_ID_KEYS Ljava/util/List;
    return-void 
.end method

.method public static final synthetic access$isImageAttachmentPart(com.bytedance.trae.im.model.MessagePart)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isImageAttachmentPart(Lcom/bytedance/trae/im/model/MessagePart;)Z
    move-result v0
    return v0
.end method

.method private static final varargs firstStringValue(com.google.gson.JsonObject  java.lang.String[])java.lang.String
    .registers 5
    # ins_size=2
    array-length v0, v4
    const/4 v1, 0
    if-ge v1, v0, +00eh
    aget-object v2, v4, v1
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->stringValue(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +003h
    return-object v2
    add-int/lit8 v1, v1, 1
    goto -dh
    const/4 v3, 0
    return-object v3
.end method

.method public static final isBrainstormMessage(com.bytedance.trae.im.model.ParsedChatMessage)boolean
    .registers 2
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/model/ParsedChatMessage;->getAgentType()Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v0, voice_summary
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    return v1
.end method

.method private static final isImageAttachmentPart(com.bytedance.trae.im.model.MessagePart)boolean
    .registers 7
    # ins_size=1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v0
    const-string v1, "image"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v1, 1
    if-eqz v0, +003h
    return v1
    invoke-virtual v6, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v0
    const-string v2, "attachment"
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    const/4 v2, 0
    if-nez v0, +003h
    return v2
    invoke-virtual v6, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v6
    if-nez v6, +003h
    return v2
    const-string v0, "content_type"
    const-string v3, "contentType"
    const-string v4, "mime_type"
    const-string v5, "mimeType"
    filled-new-array v4, v5, v0, v3, [Ljava/lang/String;
    move-result-object v0
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v0, +01bh
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v0, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v3, toLowerCase(...)
    invoke-static v0, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v0, +00dh
    const/4 v3, 2
    const/4 v4, 0
    const-string v5, "image/"
    invoke-static v0, v5, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-ne v0, v1, +003h
    move v2, v1
    if-eqz v2, +003h
    return v1
    const-string v0, "file_name"
    const-string v2, "name"
    const-string v3, "filename"
    filled-new-array v3, v0, v2, [Ljava/lang/String;
    move-result-object v0
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isImageFilename(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +003h
    return v1
    const-string/jumbo v0, tos_oid
    const-string/jumbo v1, tosOid
    const-string/jumbo v2, uri
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v6, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isImageFilename(Ljava/lang/String;)Z
    move-result v6
    return v6
.end method

.method private static final isImageFilename(java.lang.String)boolean
    .registers 5
    # ins_size=1
    const-string v0, ""
    const/4 v1, 0
    if-eqz v4, +01fh
    const/16 v2, 63
    const/4 v3, 2
    invoke-static v4, v2, v1, v3, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +016h
    const/16 v2, 46
    invoke-static v4, v2, v0, Lkotlin/text/StringsKt;->substringAfterLast(Ljava/lang/String; C Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-eqz v4, +00eh
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v4, toLowerCase(...)
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    if-nez v1, +003h
    goto +2h
    move-object v0, v1
    sget-object v4, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->USER_MESSAGE_IMAGE_EXTENSIONS Ljava/util/Set;
    invoke-interface v4, v0, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    return v4
.end method

.method private static final isLocalArtifactPath(java.lang.String)boolean
    .registers 6
    # ins_size=1
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
    move-result v2
    const/4 v3, 0
    if-eqz v2, +003h
    return v3
    const-string v2, "content://"
    const/4 v4, 2
    invoke-static v5, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +032h
    const-string v2, "file://"
    invoke-static v5, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +28h
    const-string v2, "http://"
    invoke-static v5, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +021h
    const-string v2, "https://"
    invoke-static v5, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +17h
    const-string v2, "/"
    invoke-static v5, v2, v3, v4, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +00fh
    new-instance v5, Lkotlin/text/Regex;
    const-string v0, "^[A-Za-z]:[\\/].*"
    invoke-direct v5, v0, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-virtual v5, v1, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    const/4 v3, 1
    return v3
.end method

.method private static final normalizeImageResourceId(java.lang.String)java.lang.String
    .registers 5
    # ins_size=1
    const/4 v0, 0
    if-eqz v4, +00dh
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-nez v4, +004h
    const-string v4, ""
    move-object v1, v4
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v4, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    const/4 v1, 0
    const/4 v2, 2
    const-string/jumbo v3, tos-
    invoke-static v4, v3, v1, v2, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    move-object v0, v4
    return-object v0
.end method

.method private static final normalizeRemoteResourceId(java.lang.String)java.lang.String
    .registers 3
    # ins_size=1
    const/4 v0, 0
    if-eqz v2, +00dh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v0
    if-nez v2, +004h
    const-string v2, ""
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +003h
    return-object v0
    const-string/jumbo v1, trae-res://remote_resource/
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v2, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v2
    move-object v1, v2
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    xor-int/lit8 v1, v1, 1
    if-eqz v1, +003h
    move-object v0, v2
    return-object v0
.end method

.method private static final normalizeRemoteResourceUri(java.lang.String)java.lang.String
    .registers 6
    # ins_size=1
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
    const/4 v2, 0
    const/4 v3, 2
    invoke-static v5, v1, v2, v3, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    move-object v0, v5
    goto +17h
    const-string/jumbo v4, tos-
    invoke-static v5, v4, v2, v3, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +00fh
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static final previewChatSessionIdFromData(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->CHAT_SESSION_ID_KEYS Ljava/util/List;
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +00fh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->stringValue(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, -010h
    return-object v2
    return-object v0
.end method

.method public static final previewImageItemFromData(com.bytedance.trae.im.model.MessagePart)com.bytedance.trae.conversation.chat.viewholder.UserPreviewImageItem
    .registers 9
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v8, Lcom/bytedance/trae/im/model/MessagePart;->getType()Ljava/lang/String;
    move-result-object v2
    const-string v3, "image"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v3
    const-string/jumbo v4, uri
    const-string v5, "name"
    const-string v6, "file_name"
    const-string v7, "filename"
    if-eqz v3, +02fh
    const-string v8, "image_id"
    const-string v2, "imageId"
    filled-new-array v8, v2, [Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +011h
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeImageResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    return-object v1
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->IMAGE_ID Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    filled-new-array v7, v6, v5, [Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v2, v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind; Ljava/lang/String; Ljava/lang/String;)V
    goto +6bh
    const-string v3, "attachment"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +064h
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isImageAttachmentPart(Lcom/bytedance/trae/im/model/MessagePart;)Z
    move-result v8
    if-nez v8, +003h
    return-object v1
    filled-new-array v4, [Ljava/lang/String;
    move-result-object v8
    invoke-static v0, v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    const-string/jumbo v2, tos_oid
    const-string/jumbo v3, tosOid
    filled-new-array v2, v3, [Ljava/lang/String;
    move-result-object v2
    invoke-static v0, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +009h
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +003h
    goto +dh
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-eqz v2, +007h
    invoke-static v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    filled-new-array v7, v6, v5, [Ljava/lang/String;
    move-result-object v3
    invoke-static v0, v3, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->firstStringValue(Lcom/google/gson/JsonObject; [Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    if-eqz v2, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    sget-object v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->REMOTE_RESOURCE Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    invoke-direct v1, v8, v2, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind; Ljava/lang/String; Ljava/lang/String;)V
    goto +1bh
    invoke-static v8, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->isLocalArtifactPath(Ljava/lang/String;)Z
    move-result v2
    if-eqz v2, +016h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;
    sget-object v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;->LOCAL_ARTIFACT Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind;
    invoke-static v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-static v8, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v8
    invoke-virtual v8, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-direct v1, v2, v8, v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageItem;-><init>(Lcom/bytedance/trae/conversation/chat/viewholder/UserPreviewImageKind; Ljava/lang/String; Ljava/lang/String;)V
    return-object v1
.end method

.method public static final previewOidIdFromData(com.bytedance.trae.im.model.MessagePart)java.lang.String
    .registers 4
    # ins_size=1
    const-string v0, "<this>"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, Lcom/bytedance/trae/im/model/MessagePart;->getData()Lcom/google/gson/JsonObject;
    move-result-object v3
    const-string v0, ""
    if-nez v3, +003h
    return-object v0
    const-string/jumbo v1, tos_oid
    invoke-static v3, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->stringValue(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    const-string/jumbo v2, uri
    invoke-static v3, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->stringValue(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +009h
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/viewholder/UserMessageViewHolderKt;->normalizeRemoteResourceUri(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    return-object v0
.end method

.method private static final stringValue(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 3
    # ins_size=2
    invoke-virtual v1, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v1
    const/4 v2, 0
    if-eqz v1, +01eh
    invoke-virtual v1, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v1, v2
    if-eqz v1, +014h
    invoke-virtual v1, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +00eh
    move-object v0, v1
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v2, v1
    return-object v2
.end method
