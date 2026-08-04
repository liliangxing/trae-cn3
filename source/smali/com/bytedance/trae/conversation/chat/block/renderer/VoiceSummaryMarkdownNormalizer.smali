# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;
.super Ljava/lang/Object;
.source "VoiceSummaryMarkdownNormalizer.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;
.field private static final fencedCodeBlockRegex:Lkotlin/text/Regex;
.field private static final taskListItemRegex:Lkotlin/text/Regex;


.method public static synthetic $r8$lambda$UyDNWnvJVXNijp0tDzjZC8ne-gg(kotlin.text.MatchResult)java.lang.CharSequence
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->taskListAsBulletList$lambda$1$lambda$0(Lkotlin/text/MatchResult;)Ljava/lang/CharSequence;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$W5QuaMMNOe0ckjW8Bj7P656x6VY(kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$IntRef  java.lang.String)java.lang.String
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->taskListAsBulletList$lambda$1(Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$IntRef; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^(\s*)([-*+])\s+\[[ xX]\]\s+(.*)$"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->taskListItemRegex Lkotlin/text/Regex;
    new-instance v0, Lkotlin/text/Regex;
    const-string v1, "^\s*(`{3,}|~{3,}).*$"
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->fencedCodeBlockRegex Lkotlin/text/Regex;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private static final taskListAsBulletList$lambda$1(kotlin.jvm.internal.Ref$ObjectRef  kotlin.jvm.internal.Ref$IntRef  java.lang.String)java.lang.String
    .registers 6
    # ins_size=3
    const-string v0, "line"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->fencedCodeBlockRegex Lkotlin/text/Regex;
    move-object v1, v5
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Lkotlin/text/Regex;->matchEntire(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;
    move-result-object v0
    if-eqz v0, +041h
    invoke-interface v0, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v0
    const/4 v1, 1
    invoke-interface v0, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/String;
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->first(Ljava/lang/CharSequence;)C
    move-result v1
    iget-object v2, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-nez v2, +00fh
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    iput-object v1, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v3
    iput v3, v4, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto +2dh
    iget-object v2, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v2, Ljava/lang/Character;
    if-nez v2, +003h
    goto +26h
    invoke-virtual v2, Ljava/lang/Character;->charValue()C
    move-result v2
    if-ne v2, v1, +021h
    invoke-virtual v0, Ljava/lang/String;->length()I
    move-result v0
    iget v1, v4, Lkotlin/jvm/internal/Ref$IntRef;->element I
    if-lt v0, v1, +019h
    const/4 v0, 0
    iput-object v0, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v3, 0
    iput v3, v4, Lkotlin/jvm/internal/Ref$IntRef;->element I
    goto +11h
    iget-object v3, v3, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    if-eqz v3, +003h
    goto +ch
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer;->taskListItemRegex Lkotlin/text/Regex;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda1;
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda1;-><init>()V
    invoke-virtual v3, v1, v4, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1;)Ljava/lang/String;
    move-result-object v5
    return-object v5
.end method

.method private static final taskListAsBulletList$lambda$1$lambda$0(kotlin.text.MatchResult)java.lang.CharSequence
    .registers 4
    # ins_size=1
    const-string v0, "match"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/lang/StringBuilder;
    invoke-direct v0, Ljava/lang/StringBuilder;-><init>()V
    invoke-interface v3, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v1
    const/4 v2, 1
    invoke-interface v1, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-interface v3, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v1
    const/4 v2, 2
    invoke-interface v1, v2, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 32
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-interface v3, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v3
    const/4 v1, 3
    invoke-interface v3, v1, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/String;
    invoke-virtual v0, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v3
    invoke-virtual v3, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    return-object v3
.end method

.method public final taskListAsBulletList(java.lang.String)java.lang.String
    .registers 14
    # ins_size=2
    const-string v0, "markdown"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v13
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +004h
    const/4 v1, 1
    goto +2h
    const/4 v1, 0
    if-eqz v1, +003h
    return-object v13
    new-instance v13, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v13, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    new-instance v1, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v1, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    invoke-static v0, Lkotlin/text/StringsKt;->lineSequence(Ljava/lang/CharSequence;)Lkotlin/sequences/Sequence;
    move-result-object v0
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;
    invoke-direct v2, v13, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/VoiceSummaryMarkdownNormalizer$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/internal/Ref$ObjectRef; Lkotlin/jvm/internal/Ref$IntRef;)V
    invoke-static v0, v2, Lkotlin/sequences/SequencesKt;->map(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v3
    const-string v13, "
"
    move-object v4, v13
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/4 v8, 0
    const/4 v9, 0
    const/16 v10, 62
    const/4 v11, 0
    invoke-static/range v3 ... v11, Lkotlin/sequences/SequencesKt;->joinToString$default(Lkotlin/sequences/Sequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v13
    return-object v13
.end method
