# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapterKt;
.super Ljava/lang/Object;
.source "HistorySubtitleAdapter.kt"


.method public static final synthetic access$isImageAttachment(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapterKt;->isImageAttachment(Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;)Z
    move-result v0
    return v0
.end method

.method private static final isImageAttachment(com.bytedance.trae.conversation.brainstorm.model.BrainstormAttachment)boolean
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->isImage()Z
    move-result v0
    if-nez v0, +01dh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormAttachment;->getMimeType()Ljava/lang/String;
    move-result-object v4
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-virtual v4, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    const/4 v1, 0
    const-string v2, "image/"
    const/4 v3, 0
    invoke-static v4, v2, v3, v0, v1, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +003h
    const/4 v3, 1
    return v3
.end method
