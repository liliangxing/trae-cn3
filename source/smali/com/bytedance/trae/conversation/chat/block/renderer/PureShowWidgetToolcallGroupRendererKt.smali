# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;
.super Ljava/lang/Object;
.source "PureShowWidgetToolcallGroupRenderer.kt"

.field private static final PURE_SHOW_WIDGET_TOOL:Ljava/lang/String;
.field private static final TAG_DIV:I
.field private static final TAG_SCRIPT:I
.field private static final TAG_STYLE:I


.method public static final synthetic access$hasBalancedWidgetTags(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->hasBalancedWidgetTags(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static final synthetic access$pureShowWidgetPayload(com.bytedance.trae.conversation.chat.block.AgentContentBlock$PureShowWidgetToolcallGroup)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->pureShowWidgetPayload(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    move-result-object v0
    return-object v0
.end method

.method private static final hasBalancedWidgetTags(java.lang.String)boolean
    .registers 16
    # ins_size=1
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    const/4 v1, 0
    move v4, v1
    invoke-virtual v15, Ljava/lang/String;->length()I
    move-result v2
    if-ge v4, v2, +0ech
    move-object v8, v15
    check-cast v8, Ljava/lang/CharSequence;
    const/16 v3, 60
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    move-object v2, v8
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v2
    if-ltz v2, +0ddh
    const-string v10, "<!--"
    const/4 v12, 0
    const/4 v13, 4
    const/4 v14, 0
    move-object v9, v15
    move v11, v2
    invoke-static/range v9 ... v14, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; I Z I Ljava/lang/Object;)Z
    move-result v3
    if-eqz v3, +019h
    const-string v6, "-->"
    add-int/lit8 v7, v2, 4
    const/4 v2, 0
    const/4 v9, 4
    const/4 v10, 0
    move-object v5, v8
    move v8, v2
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v2
    if-gez v2, +007h
    invoke-virtual v0, Ljava/util/ArrayList;->isEmpty()Z
    move-result v15
    return v15
    add-int/lit8 v4, v2, 3
    goto -38h
    add-int/lit8 v4, v2, 1
    invoke-virtual v15, Ljava/lang/String;->length()I
    move-result v2
    if-ge v4, v2, +0b1h
    invoke-virtual v15, v4, Ljava/lang/String;->charAt(I)C
    move-result v2
    const/16 v3, 47
    const/4 v5, 1
    if-ne v2, v3, +004h
    move v2, v5
    goto +2h
    move v2, v1
    if-eqz v2, +005h
    add-int/lit8 v3, v4, 1
    goto +2h
    move v3, v4
    invoke-virtual v15, Ljava/lang/String;->length()I
    move-result v6
    if-ge v3, v6, +00fh
    invoke-virtual v15, v3, Ljava/lang/String;->charAt(I)C
    move-result v6
    invoke-static v6, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v6
    if-eqz v6, +005h
    add-int/lit8 v3, v3, 1
    goto -12h
    move v11, v3
    invoke-virtual v15, Ljava/lang/String;->length()I
    move-result v6
    if-ge v11, v6, +00fh
    invoke-virtual v15, v11, Ljava/lang/String;->charAt(I)C
    move-result v6
    invoke-static v6, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->isAsciiLetter(C)Z
    move-result v6
    if-eqz v6, +005h
    add-int/lit8 v11, v11, 1
    goto -12h
    if-ne v3, v11, +003h
    goto -7ch
    invoke-static v15, v3, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->widgetTagId(Ljava/lang/String; I I)I
    move-result v3
    if-nez v3, +003h
    goto +29h
    move-object v4, v0
    check-cast v4, Ljava/util/List;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->lastOrNull(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Integer;
    const/4 v7, 0
    if-eqz v6, +013h
    move-object v9, v6
    check-cast v9, Ljava/lang/Number;
    invoke-virtual v9, Ljava/lang/Number;->intValue()I
    move-result v9
    if-eq v9, v5, +007h
    const/4 v10, 3
    if-ne v9, v10, +003h
    goto +2h
    move v5, v1
    if-eqz v5, +003h
    goto +2h
    move-object v6, v7
    if-eqz v6, +00dh
    if-eqz v2, +008h
    invoke-virtual v6, Ljava/lang/Integer;->intValue()I
    move-result v5
    if-eq v3, v5, +005h
    move v4, v11
    goto/16 -0adh
    const/16 v6, 62
    const/4 v9, 0
    const/4 v10, 4
    const/4 v12, 0
    move-object v5, v8
    move v7, v11
    move v8, v9
    move v9, v10
    move-object v10, v12
    invoke-static/range v5 ... v10, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v5
    if-gez v5, +003h
    return v1
    if-nez v2, +009h
    invoke-static v15, v11, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetToolcallGroupRendererKt;->isSelfClosingTag(Ljava/lang/String; I I)Z
    move-result v6
    if-eqz v6, +003h
    return v1
    if-eqz v2, +01ch
    invoke-virtual v0, Ljava/util/ArrayList;->isEmpty()Z
    move-result v2
    if-nez v2, +015h
    invoke-static v4, Lkotlin/collections/CollectionsKt;->getLastIndex(Ljava/util/List;)I
    move-result v2
    invoke-virtual v0, v2, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Integer;
    if-nez v2, +003h
    goto +7h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    if-eq v2, v3, +00ah
    return v1
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-virtual v0, v2, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    add-int/lit8 v4, v5, 1
    goto/16 -0eeh
    invoke-virtual v0, Ljava/util/ArrayList;->isEmpty()Z
    move-result v15
    return v15
.end method

.method private static final isAsciiLetter(char)boolean
    .registers 4
    # ins_size=1
    const/16 v0, 97
    const/4 v1, 1
    const/4 v2, 0
    if-gt v0, v3, +008h
    const/16 v0, 123
    if-ge v3, v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +011h
    const/16 v0, 65
    if-gt v0, v3, +008h
    const/16 v0, 91
    if-ge v3, v0, +004h
    move v3, v1
    goto +2h
    move v3, v2
    if-eqz v3, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private static final isSelfClosingTag(java.lang.String  int  int)boolean
    .registers 5
    # ins_size=3
    const/4 v0, 1
    sub-int/2addr v4, v0
    if-lt v4, v3, +00fh
    invoke-virtual v2, v4, Ljava/lang/String;->charAt(I)C
    move-result v1
    invoke-static v1, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v1
    if-eqz v1, +005h
    add-int/lit8 v4, v4, -1
    goto -eh
    if-lt v4, v3, +00bh
    invoke-virtual v2, v4, Ljava/lang/String;->charAt(I)C
    move-result v2
    const/16 v3, 47
    if-ne v2, v3, +003h
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method private static final pureShowWidgetPayload(com.bytedance.trae.conversation.chat.block.AgentContentBlock$PureShowWidgetToolcallGroup)com.bytedance.trae.conversation.chat.block.renderer.PureShowWidgetPayload
    .registers 5
    # ins_size=1
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$PureShowWidgetToolcallGroup;->getChildren()Ljava/util/List;
    move-result-object v4
    check-cast v4, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +00eh
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    instance-of v2, v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-eqz v2, -00ch
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    const/4 v1, 0
    if-eqz v0, +01ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v2, v0
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v2
    invoke-virtual v2, Lcom/bytedance/trae/im/model/ParsedToolCallInfo;->getName()Ljava/lang/String;
    move-result-object v2
    const-string v3, "PureShowWidget"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -01ch
    goto +2h
    move-object v0, v1
    check-cast v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;
    if-nez v0, +003h
    return-object v1
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Toolcall;->getToolCallInfo()Lcom/bytedance/trae/im/model/ParsedToolCallInfo;
    move-result-object v0
    invoke-virtual v4, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload$Companion;->from(Lcom/bytedance/trae/im/model/ParsedToolCallInfo;)Lcom/bytedance/trae/conversation/chat/block/renderer/PureShowWidgetPayload;
    move-result-object v4
    return-object v4
.end method

.method private static final widgetTagId(java.lang.String  int  int)int
    .registers 12
    # ins_size=3
    sub-int/2addr v11, v10
    const/4 v0, 3
    const/4 v1, 0
    if-eq v11, v0, +029h
    const/4 v2, 5
    if-eq v11, v2, +016h
    const/4 v2, 6
    if-eq v11, v2, +004h
    move v0, v1
    goto +2eh
    const-string/jumbo v5, script
    const/4 v6, 0
    const/4 v7, 6
    const/4 v8, 1
    move-object v3, v9
    move v4, v10
    invoke-static/range v3 ... v8, Lkotlin/text/StringsKt;->regionMatches(Ljava/lang/String; I Ljava/lang/String; I I Z)Z
    move-result v9
    if-eqz v9, -00eh
    goto +1fh
    const-string/jumbo v4, style
    const/4 v5, 0
    const/4 v6, 5
    const/4 v7, 1
    move-object v2, v9
    move v3, v10
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->regionMatches(Ljava/lang/String; I Ljava/lang/String; I I Z)Z
    move-result v9
    if-eqz v9, -01dh
    const/4 v0, 1
    goto +fh
    const-string v4, "div"
    const/4 v5, 0
    const/4 v6, 3
    const/4 v7, 1
    move-object v2, v9
    move v3, v10
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->regionMatches(Ljava/lang/String; I Ljava/lang/String; I I Z)Z
    move-result v9
    if-eqz v9, -02ch
    const/4 v0, 2
    return v0
.end method
