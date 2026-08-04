# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
.super Ljava/lang/Object;
.source "IdeVersionComparator.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/network/IdeVersionComparator;


.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-direct v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final parse(java.lang.String)com.bytedance.trae.conversation.network.IdeVersionComparator$Version
    .registers 10
    # ins_size=2
    check-cast v9, Ljava/lang/CharSequence;
    if-eqz v9, +00bh
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    const/4 v0, 0
    goto +2h
    const/4 v0, 1
    const/4 v1, 0
    if-eqz v0, +003h
    return-object v1
    invoke-static v9, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    move-object v2, v9
    check-cast v2, Ljava/lang/CharSequence;
    const-string v9, "."
    filled-new-array v9, [Ljava/lang/String;
    move-result-object v3
    const/4 v4, 0
    const/4 v5, 0
    const/4 v6, 6
    const/4 v7, 0
    invoke-static/range v2 ... v7, Lkotlin/text/StringsKt;->split$default(Ljava/lang/CharSequence; [Ljava/lang/String; Z I I Ljava/lang/Object;)Ljava/util/List;
    move-result-object v9
    invoke-interface v9, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-object v1
    check-cast v9, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    const/16 v2, 10
    invoke-static v9, v2, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v2
    invoke-direct v0, v2, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01dh
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/String;
    sget-object v3, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->INSTANCE Lcom/bytedance/trae/conversation/network/IdeVersionComparator;
    invoke-direct v3, v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->parsePart(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v2
    if-eqz v2, +00eh
    invoke-virtual v2, Ljava/lang/Integer;->intValue()I
    move-result v2
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1fh
    return-object v1
    check-cast v0, Ljava/util/List;
    new-instance v9, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    invoke-direct v9, v0, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;-><init>(Ljava/util/List;)V
    return-object v9
.end method

.method private final parsePart(java.lang.String)java.lang.Integer
    .registers 6
    # ins_size=2
    invoke-virtual v5, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 0
    move v2, v1
    if-ge v2, v0, +01ah
    invoke-virtual v5, v2, Ljava/lang/String;->charAt(I)C
    move-result v3
    invoke-static v3, Ljava/lang/Character;->isDigit(C)Z
    move-result v3
    if-nez v3, +00dh
    invoke-virtual v5, v1, v2, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v5
    const-string/jumbo v0, substring(...)
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +4h
    add-int/lit8 v2, v2, 1
    goto -19h
    move-object v0, v5
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-lez v0, +003h
    const/4 v1, 1
    const/4 v0, 0
    if-eqz v1, +003h
    goto +2h
    move-object v5, v0
    if-eqz v5, +006h
    invoke-static v5, Lkotlin/text/StringsKt;->toIntOrNull(Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v0
    return-object v0
.end method

.method public final isGreaterOrEqual(java.lang.String  java.lang.String)boolean
    .registers 4
    # ins_size=3
    const-string v0, "minimum"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->parse(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    move-result-object v2
    const/4 v0, 0
    if-nez v2, +003h
    return v0
    invoke-direct v1, v3, Lcom/bytedance/trae/conversation/network/IdeVersionComparator;->parse(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;
    move-result-object v3
    if-nez v3, +003h
    return v0
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;->compareTo(Lcom/bytedance/trae/conversation/network/IdeVersionComparator$Version;)I
    move-result v2
    if-ltz v2, +003h
    const/4 v0, 1
    return v0
.end method
