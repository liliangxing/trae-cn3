# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
.super Ljava/lang/Object;
.source "TaskSearchTextFormatter.kt"

.field public static final $stable:I
.field public static final INSTANCE:Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
.field public static final MAX_PREFIX_CHARS_BEFORE_MATCH:I
.field private static final TRUNCATION_PREFIX:Ljava/lang/String;


.method public static synthetic $r8$lambda$owh5F7HcINoBY8124jh7OoPPruM(java.lang.String)boolean
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->mapNotBlank$lambda$7(Ljava/lang/String;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$s6FmWRG_VDo11c2m0UUsPnQiD4A(java.lang.String)java.lang.String
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->mapNotBlank$lambda$6(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final firstMatchStart(java.lang.String  java.util.List)int
    .registers 13
    # ins_size=3
    sget-object v0, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v1, "ROOT"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v0, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v0, toLowerCase(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v12, Ljava/lang/Iterable;
    new-instance v2, Ljava/util/ArrayList;
    const/16 v3, 10
    invoke-static v12, v3, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v3
    invoke-direct v2, v3, Ljava/util/ArrayList;-><init>(I)V
    check-cast v2, Ljava/util/Collection;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v3
    if-eqz v3, +027h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    move-object v4, v11
    check-cast v4, Ljava/lang/CharSequence;
    sget-object v5, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-static v5, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v3, v5, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v3
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -2ah
    check-cast v2, Ljava/util/List;
    check-cast v2, Ljava/lang/Iterable;
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +018h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    if-ltz v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, -016h
    invoke-interface v11, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1bh
    check-cast v11, Ljava/util/List;
    check-cast v11, Ljava/lang/Iterable;
    invoke-static v11, Lkotlin/collections/CollectionsKt;->minOrNull(Ljava/lang/Iterable;)Ljava/lang/Comparable;
    move-result-object v11
    check-cast v11, Ljava/lang/Integer;
    if-eqz v11, +007h
    invoke-virtual v11, Ljava/lang/Integer;->intValue()I
    move-result v11
    goto +2h
    const/4 v11, -1
    return v11
.end method

.method public static synthetic format$default(com.bytedance.trae.home.solo.task.TaskSearchTextFormatter  java.lang.String  java.lang.String  java.util.List  int  java.lang.Object)java.lang.String
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->format(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic highlightRanges$default(com.bytedance.trae.home.solo.task.TaskSearchTextFormatter  java.lang.String  java.lang.String  java.util.List  int  java.lang.Object)java.util.List
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->highlightRanges(Ljava/lang/String; Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final highlightTerms(java.lang.String  java.util.List)java.util.List
    .registers 8
    # ins_size=3
    const/4 v0, 0
    if-eqz v7, +007h
    invoke-direct v5, v7, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->mapNotBlank(Ljava/util/List;)Ljava/util/List;
    move-result-object v7
    goto +2h
    move-object v7, v0
    move-object v1, v7
    check-cast v1, Ljava/util/Collection;
    const/4 v2, 0
    const/4 v3, 1
    if-eqz v1, +00bh
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +003h
    goto +3h
    move v1, v2
    goto +2h
    move v1, v3
    if-nez v1, +003h
    move-object v0, v7
    if-nez v0, +03eh
    check-cast v6, Ljava/lang/CharSequence;
    invoke-static v6, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v6
    invoke-virtual v6, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    check-cast v6, Ljava/lang/Iterable;
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    check-cast v7, Ljava/util/Collection;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v0
    if-eqz v0, +01ah
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v0
    move-object v1, v0
    check-cast v1, Ljava/lang/String;
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    move v1, v3
    goto +2h
    move v1, v2
    if-eqz v1, -018h
    invoke-interface v7, v0, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1dh
    move-object v0, v7
    check-cast v0, Ljava/util/List;
    check-cast v0, Ljava/lang/Iterable;
    new-instance v6, Ljava/util/HashSet;
    invoke-direct v6, Ljava/util/HashSet;-><init>()V
    new-instance v7, Ljava/util/ArrayList;
    invoke-direct v7, Ljava/util/ArrayList;-><init>()V
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +024h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/String;
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v4, "ROOT"
    invoke-static v3, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, toLowerCase(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v2, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, -022h
    invoke-virtual v7, v1, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    goto -27h
    check-cast v7, Ljava/util/List;
    return-object v7
.end method

.method private final mapNotBlank(java.util.List)java.util.List
    .registers 3
    # ins_size=2
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$$ExternalSyntheticLambda0;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->map(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    new-instance v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$$ExternalSyntheticLambda1;
    invoke-direct v0, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$$ExternalSyntheticLambda1;-><init>()V
    invoke-static v2, v0, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v2
    invoke-static v2, Lkotlin/sequences/SequencesKt;->toList(Lkotlin/sequences/Sequence;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method private static final mapNotBlank$lambda$6(java.lang.String)java.lang.String
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    return-object v1
.end method

.method private static final mapNotBlank$lambda$7(java.lang.String)boolean
    .registers 2
    # ins_size=1
    const-string v0, "it"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-lez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    return v1
.end method

.method private final overlaps(com.bytedance.trae.home.solo.task.TaskSearchTextFormatter$HighlightRange  com.bytedance.trae.home.solo.task.TaskSearchTextFormatter$HighlightRange)boolean
    .registers 5
    # ins_size=3
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getStart()I
    move-result v0
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getEnd()I
    move-result v1
    if-ge v0, v1, +00eh
    invoke-virtual v4, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getStart()I
    move-result v4
    invoke-virtual v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;->getEnd()I
    move-result v3
    if-ge v4, v3, +004h
    const/4 v3, 1
    goto +2h
    const/4 v3, 0
    return v3
.end method

.method private final visibleStartForMatch(java.lang.String  int)int
    .registers 11
    # ins_size=3
    add-int/lit8 v0, v10, -24
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    const/16 v3, 10
    const/4 v9, 1
    add-int/lit8 v4, v10, -1
    const/4 v5, 0
    const/4 v6, 4
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->lastIndexOf$default(Ljava/lang/CharSequence; C I Z I Ljava/lang/Object;)I
    move-result v10
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    move-object v2, v10
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    if-lt v2, v0, +003h
    move v1, v9
    const/4 v2, 0
    if-eqz v1, +003h
    goto +2h
    move-object v10, v2
    if-eqz v10, +00bh
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v10
    add-int/2addr v10, v9
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +006h
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v0
    return v0
.end method

.method public final format(java.lang.String  java.lang.String  java.util.List)java.lang.String
    .registers 5
    # ins_size=4
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v3, v4, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->highlightTerms(Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v3
    move-object v4, v2
    check-cast v4, Ljava/lang/CharSequence;
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v4
    if-nez v4, +031h
    invoke-interface v3, Ljava/util/List;->isEmpty()Z
    move-result v4
    if-eqz v4, +003h
    goto +29h
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->firstMatchStart(Ljava/lang/String; Ljava/util/List;)I
    move-result v3
    if-ltz v3, +024h
    const/16 v4, 24
    if-gt v3, v4, +003h
    goto +1eh
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->visibleStartForMatch(Ljava/lang/String; I)I
    move-result v3
    new-instance v4, Ljava/lang/StringBuilder;
    const-string v0, "..."
    invoke-direct v4, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v3, substring(...)
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v2
    invoke-virtual v2, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    return-object v2
.end method

.method public final highlightRanges(java.lang.String  java.lang.String  java.util.List)java.util.List
    .registers 14
    # ins_size=4
    const-string/jumbo v0, text
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "query"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v10, v12, v13, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->highlightTerms(Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v12
    move-object v13, v11
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v13
    if-nez v13, +0aah
    invoke-interface v12, Ljava/util/List;->isEmpty()Z
    move-result v13
    if-eqz v13, +004h
    goto/16 +0a2h
    sget-object v13, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    const-string v0, "ROOT"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, v13, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v11
    const-string/jumbo v13, toLowerCase(...)
    invoke-static v11, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/List;
    check-cast v12, Ljava/lang/Iterable;
    invoke-interface v12, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v12
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +070h
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    sget-object v3, Ljava/util/Locale;->ROOT Ljava/util/Locale;
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v2, v3, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v3, v11
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 6
    const/4 v9, 0
    move-object v4, v3
    move-object v5, v2
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v4
    if-ltz v4, -025h
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v5
    add-int/2addr v5, v4
    new-instance v6, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;
    invoke-direct v6, v4, v5, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;-><init>(I I)V
    move-object v5, v1
    check-cast v5, Ljava/lang/Iterable;
    instance-of v7, v5, Ljava/util/Collection;
    const/4 v8, 1
    if-eqz v7, +00ch
    move-object v7, v5
    check-cast v7, Ljava/util/Collection;
    invoke-interface v7, Ljava/util/Collection;->isEmpty()Z
    move-result v7
    if-eqz v7, +003h
    goto +1ah
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +011h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;
    sget-object v9, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->INSTANCE Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;
    invoke-direct v9, v7, v6, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter;->overlaps(Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange; Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$HighlightRange;)Z
    move-result v7
    if-eqz v7, -012h
    const/4 v8, 0
    if-eqz v8, +008h
    move-object v5, v1
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, v6, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v5
    add-int v6, v4, v5
    const/4 v7, 0
    const/4 v8, 4
    const/4 v9, 0
    move-object v4, v3
    move-object v5, v2
    invoke-static/range v4 ... v9, Lkotlin/text/StringsKt;->indexOf$default(Ljava/lang/CharSequence; Ljava/lang/String; I Z I Ljava/lang/Object;)I
    move-result v4
    goto -4eh
    check-cast v1, Ljava/lang/Iterable;
    new-instance v11, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$highlightRanges$$inlined$sortedBy$1;
    invoke-direct v11, Lcom/bytedance/trae/home/solo/task/TaskSearchTextFormatter$highlightRanges$$inlined$sortedBy$1;-><init>()V
    check-cast v11, Ljava/util/Comparator;
    invoke-static v1, v11, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v11
    return-object v11
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v11
    return-object v11
.end method
