# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
.super Ljava/lang/Object;
.source "VoiceSummaryPayloadParser.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
.field private static final gson:Lcom/google/gson/Gson;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    new-instance v0, Lcom/google/gson/Gson;
    invoke-direct v0, Lcom/google/gson/Gson;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->gson Lcom/google/gson/Gson;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final buildPayload(com.google.gson.JsonObject)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 6
    # ins_size=2
    const-string v0, "header"
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    const-string/jumbo v2, summary
    invoke-direct v4, v5, v2, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v1
    const-string v3, "bottom"
    invoke-direct v4, v5, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v5
    if-nez v5, +003h
    goto +2h
    move-object v1, v5
    invoke-direct v4, v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPayload(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v5
    return-object v5
.end method

.method private final buildPayload(java.lang.String  java.lang.String  java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 5
    # ins_size=4
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +004h
    const/4 v2, 0
    return-object v2
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    invoke-direct v0, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method private final buildPlainMarkdownPayload(java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=2
    move-object v0, v3
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    goto +2h
    move-object v3, v1
    if-nez v3, +003h
    return-object v1
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    const-string v1, ""
    invoke-direct v0, v1, v3, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method private final getStringOrNull(com.google.gson.JsonObject  java.lang.String)java.lang.String
    .registers 4
    # ins_size=3
    invoke-virtual v2, v3, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v2
    const/4 v3, 0
    if-nez v2, +003h
    return-object v3
    invoke-virtual v2, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    if-nez v0, +003h
    return-object v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-virtual v2, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
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
    check-cast v3, Ljava/lang/String;
    return-object v3
    :try_start_0xf
.end method

.method private final parseJsonStringPayload(java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 6
    # ins_size=2
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, {
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v5, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return-object v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v4
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->gson Lcom/google/gson/Gson;
    const-class v1, Lcom/google/gson/JsonObject;
    invoke-virtual v0, v5, v1, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String; Ljava/lang/Class;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Lcom/google/gson/JsonObject;
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    goto +ch
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v3, v0
    check-cast v3, Lcom/google/gson/JsonObject;
    if-eqz v3, +007h
    invoke-direct v4, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPayload(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v5
    goto +30h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/chat/block/LenientJsonObjectParser;->parseTopLevelStrings(Ljava/lang/String;)Ljava/util/Map;
    move-result-object v5
    const-string v0, "header"
    invoke-interface v5, v0, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    const-string v1, ""
    if-nez v0, +003h
    move-object v0, v1
    const-string/jumbo v2, summary
    invoke-interface v5, v2, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-nez v2, +003h
    move-object v2, v1
    const-string v3, "bottom"
    invoke-interface v5, v3, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Ljava/lang/String;
    if-nez v5, +003h
    goto +2h
    move-object v1, v5
    invoke-direct v4, v0, v2, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPayload(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v5
    return-object v5
    :try_start_0x17
.end method

.method private final parseSummaryElement(com.google.gson.JsonElement)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v0
    if-eqz v0, +010h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    const-string v0, "getAsJsonObject(...)"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPayload(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    goto +3bh
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +034h
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    goto +ch
    move-exception v3
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v3, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v3
    invoke-static v3, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v1, v3
    check-cast v1, Ljava/lang/String;
    if-nez v1, +004h
    const-string v1, ""
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseJsonStringPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    if-nez v3, +008h
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPlainMarkdownPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    goto +2h
    move-object v3, v1
    return-object v3
    :try_start_0x1b
.end method

.method public final extractSummaryText(com.google.gson.JsonElement)java.lang.String
    .registers 4
    # ins_size=2
    const-string v0, ""
    if-nez v3, +003h
    return-object v0
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonObject()Z
    move-result v1
    if-eqz v1, +017h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsJsonObject()Lcom/google/gson/JsonObject;
    move-result-object v3
    const-string v1, "getAsJsonObject(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v1, summary
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->getStringOrNull(Lcom/google/gson/JsonObject; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +003h
    goto +3bh
    move-object v0, v3
    goto +39h
    invoke-virtual v3, Lcom/google/gson/JsonElement;->isJsonPrimitive()Z
    move-result v1
    if-eqz v1, +034h
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;
    invoke-virtual v3, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v3
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
    const/4 v3, 0
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    goto +2h
    move-object v0, v3
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseJsonStringPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    if-eqz v3, +008h
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;->getMarkdown()Ljava/lang/String;
    move-result-object v3
    if-nez v3, -038h
    return-object v0
    :try_start_0x26
.end method

.method public final parseParams(com.google.gson.JsonObject)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    const-string v1, "header"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v1
    if-nez v1, +01ah
    const-string v1, "bottom"
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->has(Ljava/lang/String;)Z
    move-result v1
    if-eqz v1, +003h
    goto +10h
    const-string/jumbo v1, summary
    invoke-virtual v3, v1, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v3
    if-nez v3, +003h
    return-object v0
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseSummaryElement(Lcom/google/gson/JsonElement;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    return-object v3
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->buildPayload(Lcom/google/gson/JsonObject;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v3
    return-object v3
.end method

.method public final parseThought(java.lang.String)com.bytedance.trae.conversation.chat.block.VoiceSummaryPayload
    .registers 6
    # ins_size=2
    const/4 v0, 0
    if-eqz v5, +023h
    check-cast v5, Ljava/lang/CharSequence;
    invoke-static v5, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v5
    if-eqz v5, +017h
    const/4 v1, 0
    const/4 v2, 2
    const-string/jumbo v3, {
    invoke-static v5, v3, v1, v2, v0, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move-object v5, v0
    if-nez v5, +003h
    goto +6h
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayloadParser;->parseJsonStringPayload(Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/VoiceSummaryPayload;
    move-result-object v5
    return-object v5
    return-object v0
.end method
