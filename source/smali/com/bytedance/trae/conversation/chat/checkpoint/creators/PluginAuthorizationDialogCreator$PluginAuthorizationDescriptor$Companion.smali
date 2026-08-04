# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
.super Ljava/lang/Object;
.source "PluginAuthorizationDialogCreator.kt"


.method public static synthetic $r8$lambda$UFNRfVLwd8enS7kdVYuQSTJeUAU(java.lang.String)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;->displayName$lambda$4(Ljava/lang/String;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;-><init>()V
    return-void 
.end method

.method private final displayName(java.lang.String)java.lang.String
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v2, "ROOT"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v1, toLowerCase(...)
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, Ljava/lang/String;->hashCode()I
    move-result v1
    sparse-switch v1, +00000afh
    goto +4fh
    const-string/jumbo v1, tencent-docs
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +45h
    const-string v11, "Tencent Docs"
    goto/16 +09dh
    const-string v1, "dingtalk"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +38h
    const-string v11, "DingTalk"
    goto/16 +090h
    const-string/jumbo v1, wecom
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +2ah
    const-string v11, "WeCom"
    goto/16 +082h
    const-string v1, "kdocs"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +1dh
    const-string v11, "KDocs"
    goto/16 +075h
    const-string v1, "lark"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +10h
    const-string v11, "Lark"
    goto +68h
    const-string v1, "feishu"
    invoke-virtual v0, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    goto +4h
    const-string v11, "Feishu"
    goto +5ch
    invoke-static v11, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v11
    move-object v0, v11
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v11, 2
    new-array v1, v11, [C
    fill-array-data v1, +0000069h
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    invoke-static/range v0 ... v5, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [C Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v11
    check-cast v11, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +017h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    xor-int/lit8 v2, v2, 1
    if-eqz v2, -015h
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v11, " "
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    new-instance v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion$$ExternalSyntheticLambda0;
    invoke-direct v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion$$ExternalSyntheticLambda0;-><init>()V
    const/16 v8, 30
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    return-object v11
    nop 
    sparse-switch-payload -4c30f30a 32926e 612f526 6bc57f3 7fa92aa 81e93c3
    fill-array-data-payload b'-\x00_\x00' | \x2d\x00\x5f\x00
.end method

.method private static final displayName$lambda$4(java.lang.String)java.lang.CharSequence
    .registers 6
    # ins_size=1
    const-string/jumbo v0, word
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 1
    const/4 v2, 0
    if-lez v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +039h
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v5, v2, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-static v2, Ljava/lang/Character;->isLowerCase(C)Z
    move-result v3
    if-eqz v3, +00eh
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v4, "ROOT"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v2, v3, Lkotlin/text/CharsKt;->titlecase(C Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    goto +5h
    invoke-static v2, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v5, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v1, substring(...)
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v5, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v5
    invoke-virtual v5, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    return-object v5
.end method

.method public final from(com.bytedance.trae.im.model.ParsedToolCallInfo)com.bytedance.trae.conversation.chat.checkpoint.creators.PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor
    .registers 15
    # ins_size=2
    const-string v0, ""
    const-string/jumbo v1, toolCallInfo
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v2, v13
    check-cast v2, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;
    invoke-virtual v14, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getParams()Lcom/google/gson/JsonObject;
    move-result-object v14
    if-eqz v14, +010h
    const-string/jumbo v2, service
    invoke-virtual v14, v2, Lcom/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/google/gson/JsonElement;
    move-result-object v14
    if-eqz v14, +007h
    invoke-virtual v14, Lcom/google/gson/JsonElement;->getAsString()Ljava/lang/String;
    move-result-object v14
    goto +2h
    move-object v14, v1
    if-nez v14, +003h
    move-object v14, v0
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    goto +ch
    move-exception v14
    sget-object v2, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v14, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v14
    invoke-static v14, Lkotlin/Result;->isFailure-impl(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v0, v14
    move-object v6, v0
    check-cast v6, Ljava/lang/String;
    move-object v7, v6
    check-cast v7, Ljava/lang/CharSequence;
    const-string v8, "::"
    const/4 v9, 0
    const/4 v10, 0
    const/4 v11, 6
    const/4 v12, 0
    invoke-static/range v7 ... v12, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v14
    const-string/jumbo v0, substring(...)
    if-lez v14, +00ch
    const/4 v2, 0
    invoke-virtual v6, v2, v14, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v7, v2
    goto +2h
    move-object v7, v6
    const/4 v2, 2
    if-ltz v14, +00ch
    add-int/2addr v14, v2
    invoke-virtual v6, v14, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v14
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v5, v14
    goto +2h
    move-object v5, v6
    invoke-direct v13, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;->displayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const/16 v14, 58
    invoke-static v7, v14, v1, v2, v1, Lkotlin/text/StringsKt;->substringAfterLast$default(Ljava/lang/String; C Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v14
    invoke-direct v13, v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor$Companion;->displayName(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    move-object v0, v14
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +003h
    move-object v1, v14
    if-nez v1, +004h
    move-object v3, v4
    goto +2h
    move-object v3, v1
    new-instance v14, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;
    move-object v2, v14
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/chat/checkpoint/creators/PluginAuthorizationDialogCreator$PluginAuthorizationDescriptor;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-object v14
    :try_start_0x9
.end method
