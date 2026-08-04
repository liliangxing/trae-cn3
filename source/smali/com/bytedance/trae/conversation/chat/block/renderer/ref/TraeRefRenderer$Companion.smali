# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
.super Ljava/lang/Object;
.source "TraeRefRenderer.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;-><init>()V
    return-void 
.end method

.method public static final synthetic access$decodePlaceholderIndex(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$Companion  java.lang.String)java.lang.Integer
    .registers 2
    # ins_size=2
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;->decodePlaceholderIndex(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method private final decodePlaceholderIndex(java.lang.String)java.lang.Integer
    .registers 12
    # ins_size=2
    check-cast v11, Ljava/lang/CharSequence;
    new-instance v0, Ljava/util/ArrayList;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-ge v1, v2, +019h
    invoke-interface v11, v1, Ljava/lang/CharSequence;->charAt(I)C
    move-result v2
    const/16 v3, 8203
    if-ne v2, v3, +005h
    const/16 v2, 48
    goto +3h
    const/16 v2, 49
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v1, v1, 1
    goto -1ch
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v11, ""
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    const/4 v0, 2
    invoke-static v11, v0, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String; I)Ljava/lang/Integer;
    move-result-object v11
    return-object v11
.end method

.method private final placeholder(int)java.lang.String
    .registers 12
    # ins_size=2
    const/4 v0, 2
    invoke-static v0, Lkotlin/text/CharsKt;->checkRadix(I)I
    move-result v0
    invoke-static v11, v0, Ljava/lang/Integer;->toString(I I)Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toString(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/CharSequence;
    new-instance v0, Ljava/util/ArrayList;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    const/4 v1, 0
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-ge v1, v2, +019h
    invoke-interface v11, v1, Ljava/lang/CharSequence;->charAt(I)C
    move-result v2
    const/16 v3, 48
    if-ne v2, v3, +005h
    const/16 v2, 8203
    goto +3h
    const/16 v2, 8204
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v1, v1, 1
    goto -1ch
    check-cast v0, Ljava/util/List;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v11, ""
    move-object v2, v11
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v11
    new-instance v0, Ljava/lang/StringBuilder;
    const-string/jumbo v1, ⁠​
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string/jumbo v0, ​⁡
    invoke-virtual v11, v0, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    return-object v11
.end method

.method public final stripBeforeMarkdown(java.lang.String)com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$StripResult
    .registers 15
    # ins_size=2
    const-string v0, "raw"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v14
    check-cast v0, Ljava/lang/CharSequence;
    const-string v1, "$TRAE_REF"
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    invoke-virtual v1, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->parse(Ljava/lang/String;)Ljava/util/List;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    instance-of v6, v5, Ljava/util/Collection;
    const/4 v7, 1
    if-eqz v6, +00dh
    move-object v6, v5
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v5, v7
    goto +16h
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;
    instance-of v6, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    if-eqz v6, -00eh
    move v5, v2
    if-eqz v5, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v1
    invoke-direct v0, v14, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-object v0
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    move v6, v2
    move v8, v6
    const-string/jumbo v9, |
    const-string/jumbo v10, substring(...)
    if-ge v6, v0, +02eh
    invoke-virtual v14, v6, Ljava/lang/String;->charAt(I)C
    move-result v11
    const/16 v12, 10
    if-ne v11, v12, +023h
    invoke-virtual v14, v8, v6, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v11
    invoke-static v11, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v10, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v10
    invoke-static v10, v9, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +00ah
    new-instance v9, Lkotlin/ranges/IntRange;
    invoke-direct v9, v8, v6, Lkotlin/ranges/IntRange;-><init>(I I)V
    invoke-interface v5, v9, Ljava/util/List;->add(Ljava/lang/Object;)Z
    add-int/lit8 v8, v6, 1
    add-int/lit8 v6, v6, 1
    goto -33h
    invoke-virtual v14, Ljava/lang/String;->length()I
    move-result v0
    if-ge v8, v0, +024h
    invoke-virtual v14, v8, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v10, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v0, Lkotlin/text/StringsKt;->trimStart(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v9, v2, v3, v4, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +00dh
    invoke-virtual v14, Ljava/lang/String;->length()I
    move-result v14
    invoke-static v8, v14, Lkotlin/ranges/RangesKt;->until(I I)Lkotlin/ranges/IntRange;
    move-result-object v14
    invoke-interface v5, v14, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v14, Ljava/util/ArrayList;
    invoke-direct v14, Ljava/util/ArrayList;-><init>()V
    check-cast v14, Ljava/util/List;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +0bch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    if-eqz v4, +00ch
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;->getText()Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto -19h
    instance-of v4, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    if-eqz v4, +09eh
    move-object v4, v5
    check-cast v4, Ljava/lang/Iterable;
    instance-of v6, v4, Ljava/util/Collection;
    if-eqz v6, +00dh
    move-object v6, v4
    check-cast v6, Ljava/util/Collection;
    invoke-interface v6, Ljava/util/Collection;->isEmpty()Z
    move-result v6
    if-eqz v6, +004h
    move v4, v2
    goto +2ah
    invoke-interface v4, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, -00ah
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Lkotlin/ranges/IntRange;
    invoke-virtual v6, Lkotlin/ranges/IntRange;->getFirst()I
    move-result v8
    invoke-virtual v6, Lkotlin/ranges/IntRange;->getLast()I
    move-result v6
    move-object v9, v3
    check-cast v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getRawStart()I
    move-result v9
    if-gt v8, v9, +006h
    if-gt v9, v6, +004h
    move v6, v7
    goto +2h
    move v6, v2
    if-eqz v6, -022h
    move v4, v7
    if-eqz v4, +04bh
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;->getSources()Ljava/util/List;
    move-result-object v3
    invoke-interface v3, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v3
    invoke-interface v3, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +033h
    invoke-interface v3, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    new-instance v6, Ljava/lang/StringBuilder;
    const-string v8, "["
    invoke-direct v6, v8, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getHost()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    const-string v8, "]("
    invoke-virtual v6, v8, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v6
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;->getUrl()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v6, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    const/16 v6, 41
    invoke-virtual v4, v6, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    invoke-virtual v0, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto -36h
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    goto/16 -0a2h
    invoke-interface v14, Ljava/util/List;->size()I
    move-result v4
    check-cast v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v3
    invoke-interface v14, v3, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-direct v13, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;->placeholder(I)Ljava/lang/String;
    move-result-object v3
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    goto/16 -0b8h
    new-instance v14, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v14, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v14
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    const-string/jumbo v2, toString(...)
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v0, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;-><init>(Ljava/lang/String; Ljava/util/List;)V
    return-object v1
.end method
