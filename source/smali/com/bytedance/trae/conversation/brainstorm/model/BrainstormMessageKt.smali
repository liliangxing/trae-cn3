# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;
.super Ljava/lang/Object;
.source "BrainstormMessage.kt"

.field private static final SUB_TASK_ID_HEAD_FIXED_PREFIXES:Ljava/util/List;
.field private static final SUB_TASK_ID_HEAD_MAX_LEN:I
.field private static final SUB_TASK_ID_HEAD_PREFIX:Ljava/lang/String;
.field private static final SUB_TASK_ID_HEAD_REGEX:Lkotlin/text/Regex;
.field private static final SUB_TASK_ID_HEAD_VARIABLE_TAIL:Lkotlin/text/Regex;
.field private static final SUB_TASK_ID_TAIL_REGEX:Lkotlin/text/Regex;


.method static constructor <clinit>()void
    .registers 3
    # ins_size=0
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^\((task_task_(?:create|update|stop)_\d+_[0-9a-zA-Z\s]+)(?:,([a-zA-Z_]+))?\)"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_REGEX Lkotlin/text/Regex;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "\s*\((task_task_(?:create|update|stop)_\d+_[0-9a-zA-Z\s]+)(?:,([a-zA-Z_]+))?\)\s*$"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_TAIL_REGEX Lkotlin/text/Regex;
    const-string v0, "(task_task_update_"
    const-string v1, "(task_task_stop_"
    const-string v2, "(task_task_create_"
    filled-new-array v2, v0, v1, [Ljava/lang/String;
    move-result-object v0
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_FIXED_PREFIXES Ljava/util/List;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "\d*(?:_[0-9a-zA-Z\s]{0,32})?(?:,[a-zA-Z_]*)?"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_VARIABLE_TAIL Lkotlin/text/Regex;
    return-void 
.end method

.method private static final isIncompleteHeadPrefix(java.lang.String)boolean
    .registers 10
    # ins_size=1
    const-string v0, "("
    const/4 v1, 0
    const/4 v2, 2
    const/4 v3, 0
    invoke-static v9, v0, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v0
    if-nez v0, +003h
    return v1
    move-object v0, v9
    check-cast v0, Ljava/lang/CharSequence;
    const/16 v4, 41
    invoke-static v0, v4, v1, v2, v3, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; C Z I Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    return v1
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v0
    const/16 v4, 100
    if-le v0, v4, +003h
    return v1
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v0
    const/16 v4, 11
    if-gt v0, v4, +009h
    const-string v0, "(task_task_"
    invoke-static v0, v9, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v9
    return v9
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_FIXED_PREFIXES Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const/4 v5, 1
    if-eqz v4, +025h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    move-object v6, v4
    check-cast v6, Ljava/lang/String;
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v7
    invoke-virtual v6, Ljava/lang/String;->length()I
    move-result v8
    if-gt v7, v8, +008h
    invoke-static v6, v9, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v7
    if-nez v7, +008h
    invoke-static v9, v6, v1, v2, v3, Lkotlin/text/StringsKt;->startsWith$default(Ljava/lang/String; Ljava/lang/String; Z I Ljava/lang/Object;)Z
    move-result v6
    if-eqz v6, +004h
    move v6, v5
    goto +2h
    move v6, v1
    if-eqz v6, -027h
    move-object v3, v4
    check-cast v3, Ljava/lang/String;
    if-nez v3, +003h
    return v1
    invoke-virtual v9, Ljava/lang/String;->length()I
    move-result v0
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v1
    if-gt v0, v1, +003h
    return v5
    invoke-virtual v3, Ljava/lang/String;->length()I
    move-result v0
    invoke-virtual v9, v0, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v9
    const-string/jumbo v0, substring(...)
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_VARIABLE_TAIL Lkotlin/text/Regex;
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v0, v9, Lkotlin/text/Regex;->matches(Ljava/lang/CharSequence;)Z
    move-result v9
    return v9
.end method

.method private static final normalizeSubTaskId(java.lang.String)java.lang.String
    .registers 5
    # ins_size=1
    check-cast v4, Ljava/lang/CharSequence;
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    check-cast v0, Ljava/lang/Appendable;
    const/4 v1, 0
    invoke-interface v4, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-ge v1, v2, +012h
    invoke-interface v4, v1, Ljava/lang/CharSequence;->charAt(I)C
    move-result v2
    invoke-static v2, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v3
    if-nez v3, +005h
    invoke-interface v0, v2, Ljava/lang/Appendable;->append(C)Ljava/lang/Appendable;
    add-int/lit8 v1, v1, 1
    goto -15h
    check-cast v0, Ljava/lang/StringBuilder;
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method public static final parseAttachedSubTaskId(java.lang.String)com.bytedance.trae.conversation.brainstorm.model.ParsedSubTaskTag
    .registers 16
    # ins_size=1
    const-string/jumbo v0, text
    invoke-static v15, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_HEAD_REGEX Lkotlin/text/Regex;
    move-object v1, v15
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v2, 0
    const/4 v3, 2
    const/4 v4, 0
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v0
    const-string/jumbo v5, substring(...)
    const/4 v6, 1
    if-eqz v0, +06fh
    invoke-interface v0, Lkotlin/text/MatchResult;->getRange()Lkotlin/ranges/IntRange;
    move-result-object v1
    invoke-virtual v1, Lkotlin/ranges/IntRange;->getLast()I
    move-result v1
    add-int/2addr v1, v6
    invoke-virtual v15, v1, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v1, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_TAIL_REGEX Lkotlin/text/Regex;
    move-object v7, v15
    check-cast v7, Ljava/lang/CharSequence;
    invoke-static v1, v7, v2, v3, v4, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v1
    if-eqz v1, +01fh
    invoke-interface v1, Lkotlin/text/MatchResult;->getRange()Lkotlin/ranges/IntRange;
    move-result-object v1
    invoke-virtual v1, Lkotlin/ranges/IntRange;->getFirst()I
    move-result v1
    invoke-virtual v15, v2, v1, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v1
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    if-eqz v1, +004h
    move-object v8, v1
    goto +2h
    move-object v8, v15
    invoke-interface v0, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v15
    invoke-interface v15, v6, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-static v15, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->normalizeSubTaskId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-interface v0, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v15
    invoke-static v15, v3, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    if-eqz v15, +010h
    move-object v0, v15
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v2, v6
    if-eqz v2, +004h
    move-object v10, v15
    goto +2h
    move-object v10, v4
    const/4 v11, 0
    const/16 v12, 8
    const/4 v13, 0
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-object v7, v15
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v15
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->SUB_TASK_ID_TAIL_REGEX Lkotlin/text/Regex;
    invoke-static v0, v1, v2, v3, v4, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v0
    if-eqz v0, +04fh
    invoke-interface v0, Lkotlin/text/MatchResult;->getRange()Lkotlin/ranges/IntRange;
    move-result-object v1
    invoke-virtual v1, Lkotlin/ranges/IntRange;->getFirst()I
    move-result v1
    invoke-virtual v15, v2, v1, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v15
    invoke-static v15, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v15, Ljava/lang/CharSequence;
    invoke-static v15, Lkotlin/text/StringsKt;->trimEnd(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v15
    invoke-virtual v15, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v8
    invoke-interface v0, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v15
    invoke-interface v15, v6, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    invoke-static v15, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->normalizeSubTaskId(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-interface v0, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v15
    invoke-static v15, v3, Lkotlin/collections/CollectionsKt;->getOrNull(Ljava/util/List; I)Ljava/lang/Object;
    move-result-object v15
    check-cast v15, Ljava/lang/String;
    if-eqz v15, +010h
    move-object v0, v15
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    move v2, v6
    if-eqz v2, +004h
    move-object v10, v15
    goto +2h
    move-object v10, v4
    const/4 v11, 0
    const/16 v12, 8
    const/4 v13, 0
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    move-object v7, v15
    invoke-direct/range v7 ... v13, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v15
    invoke-static v15, Lcom/bytedance/trae/conversation/brainstorm/model/BrainstormMessageKt;->isIncompleteHeadPrefix(Ljava/lang/String;)Z
    move-result v0
    if-eqz v0, +010h
    new-instance v15, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    const-string v2, ""
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 1
    const/4 v6, 4
    const/4 v7, 0
    move-object v1, v15
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v15
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;
    const/4 v10, 0
    const/4 v11, 0
    const/4 v12, 0
    const/16 v13, 12
    const/4 v14, 0
    move-object v8, v0
    move-object v9, v15
    invoke-direct/range v8 ... v14, Lcom/bytedance/trae/conversation/brainstorm/model/ParsedSubTaskTag;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-object v0
.end method
