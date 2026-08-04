# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
.super Ljava/lang/Object;
.source "TraeRefParser.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
.field private static final SINGLE_REF:Ljava/util/regex/Pattern;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    const-string v0, "\[\$TRAE_REF\]\((https?://[^)\s]+)\)"
    invoke-static v0, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;
    move-result-object v0
    const-string v1, "compile(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->SINGLE_REF Ljava/util/regex/Pattern;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final fallbackHost(java.lang.String)java.lang.String
    .registers 5
    # ins_size=2
    const-string v0, "://"
    invoke-static v4, v0, v4, Lkotlin/text/StringsKt;->substringAfter(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    const-string v0, "/"
    const/4 v1, 0
    const/4 v2, 2
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v0, "?"
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string v0, "#"
    invoke-static v4, v0, v1, v2, v1, Lkotlin/text/StringsKt;->substringBefore$default(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v4
    const-string/jumbo v0, www.
    check-cast v0, Ljava/lang/CharSequence;
    invoke-static v4, v0, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v4
    return-object v4
.end method

.method private static final parse$flushGroup(java.util.List  java.util.List  kotlin.jvm.internal.Ref$IntRef  kotlin.jvm.internal.Ref$IntRef)void
    .registers 8
    # ins_size=4
    move-object v0, v4
    check-cast v0, Ljava/util/Collection;
    invoke-interface v0, Ljava/util/Collection;->isEmpty()Z
    move-result v0
    xor-int/lit8 v0, v0, 1
    if-eqz v0, +022h
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-object v2, v4
    check-cast v2, Ljava/lang/Iterable;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->toList(Ljava/lang/Iterable;)Ljava/util/List;
    move-result-object v2
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;-><init>(Ljava/util/List;)V
    iget v2, v6, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iget v3, v7, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; I I)V
    invoke-interface v5, v0, Ljava/util/List;->add(Ljava/lang/Object;)Z
    invoke-interface v4, Ljava/util/List;->clear()V
    const/4 v4, -1
    iput v4, v6, Lkotlin/jvm/internal/Ref$IntRef;->element I
    iput v4, v7, Lkotlin/jvm/internal/Ref$IntRef;->element I
    return-void 
.end method

.method public final extractHost(java.lang.String)java.lang.String
    .registers 8
    # ins_size=2
    const-string v0, "https://"
    const-string/jumbo v1, url
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v1
    if-eqz v1, +005h
    const-string v7, ""
    return-object v7
    move-object v1, v7
    check-cast v1, Ljava/lang/CharSequence;
    const-string v2, "://"
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    invoke-static v1, v2, v5, v3, v4, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +004h
    move-object v0, v7
    goto +eh
    new-instance v1, Ljava/lang/StringBuilder;
    invoke-direct v1, v0, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/net/URI;
    invoke-direct v1, v0, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, Ljava/net/URI;->getHost()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +007h
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->fallbackHost(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    const-string/jumbo v1, www.
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v0, v1, Lkotlin/text/StringsKt;->removePrefix(Ljava/lang/String; Ljava/lang/CharSequence;)Ljava/lang/String;
    move-result-object v7
    goto +5h
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->fallbackHost(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v7
    return-object v7
    :try_start_0x14
.end method

.method public final parse(java.lang.String)java.util.List
    .registers 22
    # ins_size=2
    move-object/from16 v0, v21
    const-string v1, "raw"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v1, v0
    check-cast v1, Ljava/lang/CharSequence;
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v2
    const/4 v3, 1
    const/4 v4, 0
    if-nez v2, +004h
    move v2, v3
    goto +2h
    move v2, v4
    if-nez v2, +0d3h
    const-string v2, "$TRAE_REF"
    check-cast v2, Ljava/lang/CharSequence;
    const/4 v5, 2
    const/4 v6, 0
    invoke-static v1, v2, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +004h
    goto/16 +0c5h
    new-instance v2, Ljava/util/ArrayList;
    invoke-direct v2, Ljava/util/ArrayList;-><init>()V
    check-cast v2, Ljava/util/List;
    sget-object v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->SINGLE_REF Ljava/util/regex/Pattern;
    invoke-virtual v5, v1, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    move-result-object v1
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    new-instance v7, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v7, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    const/4 v8, -1
    iput v8, v7, Lkotlin/jvm/internal/Ref$IntRef;->element I
    new-instance v9, Lkotlin/jvm/internal/Ref$IntRef;
    invoke-direct v9, Lkotlin/jvm/internal/Ref$IntRef;-><init>()V
    iput v8, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move v8, v4
    invoke-virtual v1, Ljava/util/regex/Matcher;->find()Z
    move-result v10
    const-string/jumbo v11, substring(...)
    if-eqz v10, +07dh
    invoke-virtual v1, Ljava/util/regex/Matcher;->start()I
    move-result v10
    invoke-virtual v1, Ljava/util/regex/Matcher;->end()I
    move-result v12
    invoke-virtual v1, v3, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;
    move-result-object v13
    if-eqz v13, +00dh
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v13, Lkotlin/text/StringsKt;->trim(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    move-result-object v13
    invoke-virtual v13, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v6
    if-nez v13, +004h
    const-string v13, ""
    move-object v15, v13
    if-le v10, v8, +03ah
    invoke-virtual v0, v8, v10, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v8
    invoke-static v8, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v11, v5
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    xor-int/2addr v11, v3
    if-eqz v11, +00dh
    move-object v11, v8
    check-cast v11, Ljava/lang/CharSequence;
    invoke-static v11, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v11
    if-eqz v11, +004h
    move v11, v3
    goto +2h
    move v11, v4
    if-nez v11, +01bh
    invoke-static v5, v2, v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->parse$flushGroup(Ljava/util/List; Ljava/util/List; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef;)V
    move-object v11, v8
    check-cast v11, Ljava/lang/CharSequence;
    invoke-interface v11, Ljava/lang/CharSequence;->length()I
    move-result v11
    if-lez v11, +004h
    move v11, v3
    goto +2h
    move v11, v4
    if-eqz v11, +00ah
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    invoke-direct v11, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;-><init>(Ljava/lang/String;)V
    invoke-interface v2, v11, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-instance v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    move-object/from16 v13, v20
    invoke-virtual v13, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->extractHost(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v16
    const/16 v17, 0
    const/16 v18, 4
    const/16 v19, 0
    move-object v14, v8
    invoke-direct/range v14 ... v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v11
    if-eqz v11, +004h
    iput v10, v7, Lkotlin/jvm/internal/Ref$IntRef;->element I
    invoke-interface v5, v8, Ljava/util/List;->add(Ljava/lang/Object;)Z
    iput v12, v9, Lkotlin/jvm/internal/Ref$IntRef;->element I
    move v8, v12
    goto/16 -082h
    move-object/from16 v13, v20
    invoke-static v5, v2, v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->parse$flushGroup(Ljava/util/List; Ljava/util/List; Lkotlin/jvm/internal/Ref$IntRef; Lkotlin/jvm/internal/Ref$IntRef;)V
    invoke-virtual/range v21, Ljava/lang/String;->length()I
    move-result v1
    if-ge v8, v1, +011h
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    invoke-virtual v0, v8, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v0
    invoke-static v0, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;-><init>(Ljava/lang/String;)V
    invoke-interface v2, v1, Ljava/util/List;->add(Ljava/lang/Object;)Z
    return-object v2
    move-object/from16 v13, v20
    invoke-interface v1, Ljava/lang/CharSequence;->length()I
    move-result v1
    if-nez v1, +003h
    goto +2h
    move v3, v4
    if-eqz v3, +007h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    goto +ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;-><init>(Ljava/lang/String;)V
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    return-object v0
.end method
