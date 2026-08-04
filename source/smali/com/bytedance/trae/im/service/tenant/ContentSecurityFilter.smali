# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
.super Ljava/lang/Object;
.source "ContentSecurityFilter.kt"

.field private static final DEFAULT_REPLACEMENT:Ljava/lang/String;
.field public static final INSTANCE:Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;


.method public static synthetic $r8$lambda$Eruaq0Sg9ck9wncQup4Hj9BJsDI(int  int  com.bytedance.trae.im.service.tenant.ContentSecurityRule)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->filter$lambda$0(I I Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Z
    move-result v0
    return v0
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;-><init>()V
    sput-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final compileRegex(com.bytedance.trae.im.service.tenant.ContentSecurityRuleDetail)kotlin.text.Regex
    .registers 4
    # ins_size=2
    invoke-virtual v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRegexPattern()Ljava/lang/String;
    move-result-object v3
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v1, v2
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    new-instance v1, Lkotlin/text/Regex;
    invoke-direct v1, v3, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    invoke-static v1, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
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
    goto +2h
    move-object v0, v3
    check-cast v0, Lkotlin/text/Regex;
    return-object v0
    :try_start_0x8
.end method

.method private final executeBlock(java.lang.String  com.bytedance.trae.im.service.tenant.ContentSecurityRule)com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult
    .registers 11
    # ins_size=3
    invoke-direct v8, v10, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->sortedDetails(Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    const/4 v2, 0
    if-eqz v1, +066h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    sget-object v3, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v3, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->compileRegex(Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;)Lkotlin/text/Regex;
    move-result-object v3
    const-string v4, ""
    if-nez v3, +02fh
    new-instance v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleName()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    move-object v10, v4
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRuleDetailName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v4
    new-instance v2, Ljava/lang/StringBuilder;
    const-string v3, "Invalid regex pattern: "
    invoke-direct v2, v3, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRegexPattern()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +003h
    goto +2h
    move-object v4, v1
    invoke-virtual v2, v4, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v9, v10, v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v9
    move-object v5, v9
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v6, 0
    const/4 v7, 2
    invoke-static v3, v5, v6, v7, v2, Lkotlin/text/Regex;->find$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/text/MatchResult;
    move-result-object v2
    if-nez v2, +003h
    goto -4fh
    new-instance v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    invoke-virtual v10, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleName()Ljava/lang/String;
    move-result-object v10
    if-nez v10, +003h
    move-object v10, v4
    invoke-virtual v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRuleDetailName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v4, v0
    invoke-interface v2, Lkotlin/text/MatchResult;->getValue()Ljava/lang/String;
    move-result-object v0
    invoke-direct v9, v10, v4, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v9, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v9
    return-object v2
.end method

.method private final executeDesensitize(java.lang.String  com.bytedance.trae.im.service.tenant.ContentSecurityRule)com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult
    .registers 9
    # ins_size=3
    new-instance v0, Lkotlin/jvm/internal/Ref$ObjectRef;
    invoke-direct v0, Lkotlin/jvm/internal/Ref$ObjectRef;-><init>()V
    iput-object v7, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    invoke-direct v6, v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->sortedDetails(Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Ljava/util/List;
    move-result-object v7
    check-cast v7, Ljava/lang/Iterable;
    invoke-interface v7, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v7
    const/4 v1, 0
    invoke-interface v7, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    const-string v3, ""
    if-eqz v2, +099h
    invoke-interface v7, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;
    sget-object v4, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v4, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->compileRegex(Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;)Lkotlin/text/Regex;
    move-result-object v4
    if-nez v4, +02fh
    new-instance v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRuleDetailName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    move-object v0, v3
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v4, "Invalid regex pattern: "
    invoke-direct v1, v4, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRegexPattern()Ljava/lang/String;
    move-result-object v2
    if-nez v2, +003h
    goto +2h
    move-object v3, v2
    invoke-virtual v1, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    invoke-direct v7, v8, v0, v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v7
    iget-object v5, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, Lkotlin/text/Regex;->containsMatchIn(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, -04bh
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getReplacement()Ljava/lang/String;
    move-result-object v1
    if-nez v1, +004h
    const-string v1, "***"
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    iget-object v5, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v4, v5, v1, Lkotlin/text/Regex;->replace(Ljava/lang/CharSequence; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    goto +ch
    move-exception v4
    sget-object v5, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v4, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v4
    invoke-static v4, Lkotlin/Result;->exceptionOrNull-impl(Ljava/lang/Object;)Ljava/lang/Throwable;
    move-result-object v5
    if-nez v5, +006h
    iput-object v4, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    const/4 v1, 1
    goto -78h
    new-instance v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    move-object v8, v3
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRuleDetail;->getRuleDetailName()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +003h
    goto +2h
    move-object v3, v0
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v2, "Invalid regex replacement: "
    invoke-direct v0, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v7, v8, v3, v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v7
    if-eqz v1, +016h
    new-instance v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    invoke-virtual v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleName()Ljava/lang/String;
    move-result-object v8
    if-nez v8, +003h
    goto +2h
    move-object v3, v8
    iget-object v8, v0, Lkotlin/jvm/internal/Ref$ObjectRef;->element Ljava/lang/Object;
    check-cast v8, Ljava/lang/String;
    invoke-direct v7, v3, v8, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    goto +5h
    sget-object v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;
    check-cast v7, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v7
    :try_start_0x67
.end method

.method public static synthetic filter$default(com.bytedance.trae.im.service.tenant.ContentSecurityFilter  java.lang.String  java.util.List  int  int  int  java.lang.Object)com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult
    .registers 8
    # ins_size=7
    and-int/lit8 v7, v6, 4
    const/4 v0, 1
    if-eqz v7, +003h
    move v4, v0
    and-int/lit8 v6, v6, 8
    if-eqz v6, +003h
    move v5, v0
    invoke-virtual v1, v2, v3, v4, v5, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->filter(Ljava/lang/String; Ljava/util/List; I I)Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    move-result-object v1
    return-object v1
.end method

.method private static final filter$lambda$0(int  int  com.bytedance.trae.im.service.tenant.ContentSecurityRule)boolean
    .registers 4
    # ins_size=3
    const-string v0, "it"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->isApplicableTo(Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule; I I)Z
    move-result v1
    return v1
.end method

.method private final isApplicableTo(com.bytedance.trae.im.service.tenant.ContentSecurityRule  int  int)boolean
    .registers 5
    # ins_size=4
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->isEnabled()Z
    move-result v0
    if-eqz v0, +01fh
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getSceneType()Ljava/lang/Integer;
    move-result-object v0
    if-nez v0, +003h
    goto +17h
    invoke-virtual v0, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-ne v0, v3, +012h
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getExecutionPoints()Ljava/util/List;
    move-result-object v2
    invoke-static v4, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    invoke-interface v2, v3, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    return v2
.end method

.method private final sortedDetails(com.bytedance.trae.im.service.tenant.ContentSecurityRule)java.util.List
    .registers 3
    # ins_size=2
    invoke-virtual v2, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getRuleDetails()Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$sortedDetails$$inlined$sortedBy$1;
    invoke-direct v0, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$sortedDetails$$inlined$sortedBy$1;-><init>()V
    check-cast v0, Ljava/util/Comparator;
    invoke-static v2, v0, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v2
    return-object v2
.end method

.method public final filter(java.lang.String  java.util.List  int  int)com.bytedance.trae.im.service.tenant.ContentSecurityFilterResult
    .registers 15
    # ins_size=5
    const-string v0, "content"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, rules
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/List;
    check-cast v12, Ljava/lang/Iterable;
    invoke-static v12, Lkotlin/collections/CollectionsKt;->asSequence(Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    move-result-object v12
    new-instance v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;
    invoke-direct v1, v13, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter$$ExternalSyntheticLambda0;-><init>(I I)V
    invoke-static v12, v1, Lkotlin/sequences/SequencesKt;->filter(Lkotlin/sequences/Sequence; Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    move-result-object v12
    invoke-interface v12, Lkotlin/sequences/Sequence;->iterator()Ljava/util/Iterator;
    move-result-object v12
    move-object v13, v11
    invoke-interface v12, Ljava/util/Iterator;->hasNext()Z
    move-result v14
    if-eqz v14, +06ch
    invoke-interface v12, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v14
    check-cast v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;->getActionType()Ljava/lang/Integer;
    move-result-object v1
    const/4 v2, 1
    if-nez v1, +003h
    goto +10h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v3
    if-ne v3, v2, +00bh
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v1, v13, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->executeBlock(Ljava/lang/String; Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    move-result-object v14
    if-eqz v14, -020h
    return-object v14
    if-nez v1, +003h
    goto -25h
    invoke-virtual v1, Ljava/lang/Integer;->intValue()I
    move-result v1
    const/4 v3, 2
    if-ne v1, v3, -02bh
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;
    invoke-direct v1, v13, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilter;->executeDesensitize(Ljava/lang/String; Lcom/bytedance/trae/im/service/tenant/ContentSecurityRule;)Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    move-result-object v14
    instance-of v1, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    if-eqz v1, +023h
    check-cast v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;->getRuleName()Ljava/lang/String;
    move-result-object v13
    check-cast v13, Ljava/lang/CharSequence;
    invoke-interface v13, Ljava/lang/CharSequence;->length()I
    move-result v13
    if-lez v13, +003h
    goto +2h
    const/4 v2, 0
    if-eqz v2, +00ch
    move-object v13, v0
    check-cast v13, Ljava/util/Collection;
    invoke-virtual v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;->getRuleName()Ljava/lang/String;
    move-result-object v1
    invoke-interface v13, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    invoke-virtual v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;->getProcessedContent()Ljava/lang/String;
    move-result-object v13
    goto -57h
    instance-of v1, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Error;
    if-eqz v1, +003h
    return-object v14
    sget-object v1, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;
    invoke-static v14, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, -063h
    instance-of v11, v14, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Blocked;
    if-eqz v11, +003h
    return-object v14
    new-instance v11, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v11, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v11
    invoke-static v13, v11, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v11
    if-nez v11, +01eh
    new-instance v11, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;
    move-object v1, v0
    check-cast v1, Ljava/lang/Iterable;
    const-string v12, ", "
    move-object v2, v12
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 62
    const/4 v9, 0
    invoke-static/range v1 ... v9, Lkotlin/collections/CollectionsKt;->joinToString$default(Ljava/lang/Iterable; Ljava/lang/CharSequence; Ljava/lang/CharSequence; Ljava/lang/CharSequence; I Ljava/lang/CharSequence; Lkotlin/jvm/functions/Function1; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v11, v12, v13, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Desensitized;-><init>(Ljava/lang/String; Ljava/lang/String;)V
    check-cast v11, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    goto +5h
    sget-object v11, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;->INSTANCE Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult$Passed;
    check-cast v11, Lcom/bytedance/trae/im/service/tenant/ContentSecurityFilterResult;
    return-object v11
.end method
