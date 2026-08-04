# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;
.super Ljava/lang/Object;
.source "SkillDetailCardCreator.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion;-><init>()V
    return-void 
.end method

.method public final parseSkillDetail(java.lang.String)com.bytedance.trae.conversation.chat.toolcall.cards.detail.SkillDetailCardCreator$Companion$SkillDetailParsed
    .registers 11
    # ins_size=2
    check-cast v10, Ljava/lang/CharSequence;
    const/4 v0, 0
    const/4 v1, 1
    if-eqz v10, +00bh
    invoke-static v10, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    move v2, v0
    goto +2h
    move v2, v1
    const-string v3, ""
    if-eqz v2, +008h
    new-instance v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    invoke-direct v10, v3, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v10
    new-instance v2, Lkotlin/text/Regex;
    const-string v4, "^#\s*(.+?)$"
    sget-object v5, Lkotlin/text/RegexOption;->MULTILINE Lkotlin/text/RegexOption;
    invoke-direct v2, v4, v5, Lkotlin/text/Regex;-><init>(Ljava/lang/String; Lkotlin/text/RegexOption;)V
    const/4 v4, 2
    const/4 v5, 0
    invoke-static v2, v10, v0, v4, v5, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v2
    if-eqz v2, +01ch
    invoke-interface v2, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v2
    if-eqz v2, +016h
    invoke-static v2, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    if-eqz v2, +00eh
    check-cast v2, Ljava/lang/CharSequence;
    invoke-static v2, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    move-object v2, v3
    new-instance v6, Lkotlin/text/Regex;
    const-string v7, "\*\*Description:\*\*\s*(.+?)(?=\*\*Details:\*\*|$)"
    sget-object v8, Lkotlin/text/RegexOption;->DOT_MATCHES_ALL Lkotlin/text/RegexOption;
    invoke-direct v6, v7, v8, Lkotlin/text/Regex;-><init>(Ljava/lang/String; Lkotlin/text/RegexOption;)V
    invoke-static v6, v10, v0, v4, v5, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v10
    if-eqz v10, +01eh
    invoke-interface v10, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v10
    if-eqz v10, +018h
    invoke-static v10, v1, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    if-eqz v10, +010h
    check-cast v10, Ljava/lang/CharSequence;
    invoke-static v10, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    goto +2h
    move-object v3, v10
    new-instance v10, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;
    invoke-direct v10, v2, v3, Lcom/bytedance/trae/conversation/chat/toolcall/cards/detail/SkillDetailCardCreator$Companion$SkillDetailParsed;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    return-object v10
.end method
