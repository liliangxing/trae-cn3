# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;
.super Ljava/lang/Object;
.source "TraeRefRenderer.kt"

.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
.field private static final PLACEHOLDER_PATTERN:Lkotlin/text/Regex;
.field private static final PLACEHOLDER_PREFIX:Ljava/lang/String;
.field private static final PLACEHOLDER_SUFFIX:Ljava/lang/String;
.field private final clickListener:Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
    new-instance v0, Lkotlin/text/Regex;
    const-string/jumbo v1, ⁠​([​‌]+)​⁡
    invoke-direct v0, v1, Lkotlin/text/Regex;-><init>(Ljava/lang/String;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->PLACEHOLDER_PATTERN Lkotlin/text/Regex;
    return-void 
.end method

.method public constructor <init>()void
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 1
    invoke-direct v2, v0, v1, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener)void
    .registers 3
    # ins_size=2
    const-string v0, "clickListener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->clickListener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefClickListener  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +008h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefDialog;->getDEFAULT_LISTENER()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    move-result-object v1
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    return-void 
.end method

.method private final applyLegacy(android.widget.TextView  android.text.Spanned)android.text.Spanned
    .registers 21
    # ins_size=3
    move-object/from16 v0, v18
    invoke-virtual/range v20, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    const-string v2, "$TRAE_REF"
    move-object v3, v2
    check-cast v3, Ljava/lang/CharSequence;
    const/4 v4, 0
    const/4 v5, 2
    const/4 v6, 0
    invoke-static v1, v3, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-object v20
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
    invoke-virtual/range v19, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v3
    const-string v7, "getContext(...)"
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v1, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;->from(Landroid/content/Context;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    move-result-object v1
    new-instance v3, Landroid/text/SpannableStringBuilder;
    move-object/from16 v7, v20
    check-cast v7, Ljava/lang/CharSequence;
    invoke-direct v3, v7, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v7
    const-class v8, Landroid/text/style/URLSpan;
    invoke-virtual v3, v4, v7, v8, Landroid/text/SpannableStringBuilder;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v7
    const-string v8, "getSpans(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v8, Ljava/util/ArrayList;
    invoke-direct v8, Ljava/util/ArrayList;-><init>()V
    check-cast v8, Ljava/util/Collection;
    array-length v9, v7
    move v10, v4
    if-ge v10, v9, +02fh
    aget-object v11, v7, v10
    move-object v12, v11
    check-cast v12, Landroid/text/style/URLSpan;
    invoke-virtual v3, v12, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I
    move-result v13
    invoke-virtual v3, v12, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I
    move-result v12
    if-ltz v13, +017h
    if-gez v12, +003h
    goto +13h
    invoke-virtual v3, v13, v12, Landroid/text/SpannableStringBuilder;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v12
    invoke-virtual v12, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v12
    check-cast v12, Ljava/lang/CharSequence;
    move-object v13, v2
    check-cast v13, Ljava/lang/CharSequence;
    invoke-static v12, v13, v4, v5, v6, Lkotlin/text/StringsKt;->contains$default(Ljava/lang/CharSequence; Ljava/lang/CharSequence; Z I Ljava/lang/Object;)Z
    move-result v12
    goto +2h
    move v12, v4
    if-eqz v12, +005h
    invoke-interface v8, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v10, v10, 1
    goto -2eh
    check-cast v8, Ljava/util/List;
    check-cast v8, Ljava/lang/Iterable;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$1;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$1;-><init>(Landroid/text/SpannableStringBuilder;)V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v8, v2, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v2
    new-instance v5, Ljava/util/ArrayList;
    invoke-direct v5, Ljava/util/ArrayList;-><init>()V
    check-cast v5, Ljava/util/List;
    new-instance v6, Ljava/util/ArrayList;
    invoke-direct v6, Ljava/util/ArrayList;-><init>()V
    check-cast v6, Ljava/util/List;
    invoke-static v2, Lkotlin/collections/CollectionsKt;->asReversed(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    const/4 v8, 1
    if-eqz v7, +04dh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    check-cast v7, Landroid/text/style/URLSpan;
    invoke-virtual v3, v7, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I
    move-result v9
    invoke-virtual v3, v7, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I
    move-result v10
    if-ltz v9, -015h
    if-gez v10, +003h
    goto -19h
    invoke-interface v6, Ljava/util/List;->isEmpty()Z
    move-result v10
    if-eqz v10, +009h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -26h
    invoke-static v6, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v10
    invoke-virtual v3, v10, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I
    move-result v10
    invoke-virtual v3, v10, v9, Landroid/text/SpannableStringBuilder;->subSequence(I I)Ljava/lang/CharSequence;
    move-result-object v9
    invoke-virtual v9, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-static v9, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v9
    if-eqz v9, +009h
    invoke-static v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-interface v6, v7, Ljava/util/List;->add(Ljava/lang/Object;)Z
    goto -45h
    invoke-interface v5, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    new-array v6, v8, [Landroid/text/style/URLSpan;
    aput-object v7, v6, v4
    invoke-static v6, Lkotlin/collections/CollectionsKt;->mutableListOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v6
    goto -51h
    move-object v2, v6
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    xor-int/2addr v2, v8
    if-eqz v2, +005h
    invoke-interface v5, v6, Ljava/util/List;->add(Ljava/lang/Object;)Z
    check-cast v5, Ljava/lang/Iterable;
    new-instance v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$applyLegacy$$inlined$sortedByDescending$2;-><init>(Landroid/text/SpannableStringBuilder;)V
    check-cast v2, Ljava/util/Comparator;
    invoke-static v5, v2, Lkotlin/collections/CollectionsKt;->sortedWith(Ljava/lang/Iterable; Ljava/util/Comparator;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    const-string/jumbo v5, ￼
    const/16 v6, 33
    if-eqz v4, +091h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/util/List;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->first(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v7
    invoke-virtual v3, v7, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I
    move-result v7
    invoke-static v4, Lkotlin/collections/CollectionsKt;->last(Ljava/util/List;)Ljava/lang/Object;
    move-result-object v8
    invoke-virtual v3, v8, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I
    move-result v8
    if-ltz v7, -021h
    if-ltz v8, -023h
    if-lt v7, v8, +003h
    goto -27h
    move-object v9, v4
    check-cast v9, Ljava/lang/Iterable;
    new-instance v10, Ljava/util/ArrayList;
    const/16 v11, 10
    invoke-static v9, v11, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-direct v10, v11, Ljava/util/ArrayList;-><init>(I)V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v9, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v11
    if-eqz v11, +024h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v11
    check-cast v11, Landroid/text/style/URLSpan;
    invoke-virtual v11, Landroid/text/style/URLSpan;->getURL()Ljava/lang/String;
    move-result-object v13
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;
    invoke-static v13, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    sget-object v12, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    invoke-virtual v12, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->extractHost(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    const/4 v15, 0
    const/16 v16, 4
    const/16 v17, 0
    move-object v12, v11
    invoke-direct/range v12 ... v17, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefSource;-><init>(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v10, v11, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -27h
    check-cast v10, Ljava/util/List;
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;-><init>(Ljava/util/List;)V
    invoke-interface v4, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v4
    invoke-interface v4, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +00ch
    invoke-interface v4, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Landroid/text/style/URLSpan;
    invoke-virtual v3, v10, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V
    goto -fh
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v3, v7, v8, v5, Landroid/text/SpannableStringBuilder;->replace(I I Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    add-int/lit8 v4, v7, 1
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;
    invoke-direct v5, v9, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V
    invoke-virtual v3, v5, v7, v4, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    new-instance v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;
    iget-object v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->clickListener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    invoke-direct v5, v9, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    invoke-virtual v3, v5, v7, v4, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    goto/16 -098h
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->toString()Ljava/lang/String;
    move-result-object v2
    const-string/jumbo v4, toString(...)
    invoke-static v2, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    invoke-virtual v4, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->parse(Ljava/lang/String;)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v4, Ljava/util/ArrayList;
    invoke-direct v4, Ljava/util/ArrayList;-><init>()V
    check-cast v4, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v7
    if-eqz v7, +00eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v7
    instance-of v8, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    if-eqz v8, -00ch
    invoke-interface v4, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -11h
    check-cast v4, Ljava/util/List;
    invoke-static v4, Lkotlin/collections/CollectionsKt;->asReversed(Ljava/util/List;)Ljava/util/List;
    move-result-object v2
    invoke-interface v2, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v4
    if-eqz v4, +03eh
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getRawStart()I
    move-result v7
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getRawEnd()I
    move-result v8
    if-ltz v7, -014h
    invoke-virtual v3, Landroid/text/SpannableStringBuilder;->length()I
    move-result v9
    if-gt v8, v9, -01ah
    if-lt v7, v8, +003h
    goto -1eh
    move-object v9, v5
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v3, v7, v8, v9, Landroid/text/SpannableStringBuilder;->replace(I I Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    add-int/lit8 v8, v7, 1
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v10
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V
    invoke-virtual v3, v9, v7, v8, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    new-instance v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v4
    iget-object v10, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->clickListener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    invoke-direct v9, v4, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    invoke-virtual v3, v9, v7, v8, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    goto -41h
    invoke-direct/range v18 ... v19, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->ensureClickable(Landroid/widget/TextView;)V
    check-cast v3, Landroid/text/Spanned;
    return-object v3
.end method

.method private final applyWithPlaceholders(android.widget.TextView  android.text.Spanned  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$StripResult)android.text.Spanned
    .registers 19
    # ins_size=4
    move-object/from16 v0, v17
    invoke-virtual/range v17, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->PLACEHOLDER_PATTERN Lkotlin/text/Regex;
    check-cast v1, Ljava/lang/CharSequence;
    const/4 v3, 2
    const/4 v4, 0
    const/4 v5, 0
    invoke-static v2, v1, v5, v3, v4, Lkotlin/text/Regex;->findAll$default(Lkotlin/text/Regex; Ljava/lang/CharSequence; I I Ljava/lang/Object;)Lkotlin/sequences/Sequence;
    move-result-object v1
    invoke-static v1, Lkotlin/sequences/SequencesKt;->toList(Lkotlin/sequences/Sequence;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->isEmpty()Z
    move-result v2
    if-eqz v2, +003h
    return-object v0
    invoke-interface/range v17, Landroid/text/Spanned;->length()I
    move-result v2
    const-class v3, Lio/noties/markwon/ext/tables/TableSpan;
    invoke-interface v0, v5, v2, v3, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v2
    const-string v3, "getSpans(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v3, Ljava/util/ArrayList;
    array-length v4, v2
    invoke-direct v3, v4, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    array-length v4, v2
    move v6, v5
    if-ge v6, v4, +019h
    aget-object v7, v2, v6
    check-cast v7, Lio/noties/markwon/ext/tables/TableSpan;
    new-instance v8, Lkotlin/ranges/IntRange;
    invoke-interface v0, v7, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I
    move-result v9
    invoke-interface v0, v7, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I
    move-result v7
    invoke-direct v8, v9, v7, Lkotlin/ranges/IntRange;-><init>(I I)V
    invoke-interface v3, v8, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    add-int/lit8 v6, v6, 1
    goto -18h
    check-cast v3, Ljava/util/List;
    move-object v2, v3
    check-cast v2, Ljava/util/Collection;
    invoke-interface v2, Ljava/util/Collection;->isEmpty()Z
    move-result v2
    const/4 v4, 1
    xor-int/2addr v2, v4
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
    invoke-virtual/range v16, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v7
    const-string v8, "getContext(...)"
    invoke-static v7, v8, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;->from(Landroid/content/Context;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    move-result-object v6
    new-instance v7, Landroid/text/SpannableStringBuilder;
    move-object v8, v0
    check-cast v8, Ljava/lang/CharSequence;
    invoke-direct v7, v8, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V
    invoke-static v1, Lkotlin/collections/CollectionsKt;->asReversed(Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    invoke-interface v1, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +0ach
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    check-cast v8, Lkotlin/text/MatchResult;
    sget-object v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;
    invoke-interface v8, Lkotlin/text/MatchResult;->getGroupValues()Ljava/util/List;
    move-result-object v10
    invoke-interface v10, v4, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Ljava/lang/String;
    invoke-static v9, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion;->access$decodePlaceholderIndex(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$Companion; Ljava/lang/String;)Ljava/lang/Integer;
    move-result-object v9
    if-eqz v9, +091h
    invoke-virtual v9, Ljava/lang/Integer;->intValue()I
    move-result v9
    if-ltz v9, +08bh
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;->getGroups()Ljava/util/List;
    move-result-object v10
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v10
    if-lt v9, v10, +003h
    goto -2eh
    invoke-virtual/range v18, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;->getGroups()Ljava/util/List;
    move-result-object v10
    invoke-interface v10, v9, Ljava/util/List;->get(I)Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    invoke-interface v8, Lkotlin/text/MatchResult;->getRange()Lkotlin/ranges/IntRange;
    move-result-object v10
    invoke-virtual v10, Lkotlin/ranges/IntRange;->getFirst()I
    move-result v10
    invoke-interface v8, Lkotlin/text/MatchResult;->getRange()Lkotlin/ranges/IntRange;
    move-result-object v8
    invoke-virtual v8, Lkotlin/ranges/IntRange;->getLast()I
    move-result v8
    add-int/2addr v8, v4
    if-ltz v10, +063h
    invoke-virtual v7, Landroid/text/SpannableStringBuilder;->length()I
    move-result v11
    if-le v8, v11, +003h
    goto -52h
    move-object v11, v3
    check-cast v11, Ljava/lang/Iterable;
    instance-of v12, v11, Ljava/util/Collection;
    if-eqz v12, +00dh
    move-object v12, v11
    check-cast v12, Ljava/util/Collection;
    invoke-interface v12, Ljava/util/Collection;->isEmpty()Z
    move-result v12
    if-eqz v12, +004h
    move v11, v5
    goto +23h
    invoke-interface v11, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, -00ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lkotlin/ranges/IntRange;
    invoke-virtual v12, Lkotlin/ranges/IntRange;->getFirst()I
    move-result v13
    invoke-virtual v12, Lkotlin/ranges/IntRange;->getLast()I
    move-result v12
    if-gt v10, v12, +006h
    if-gt v13, v10, +004h
    move v12, v4
    goto +2h
    move v12, v5
    if-eqz v12, -01bh
    move v11, v4
    if-nez v11, +026h
    if-eqz v2, +003h
    goto +bh
    const-string/jumbo v11, ￼
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v7, v10, v8, v11, Landroid/text/SpannableStringBuilder;->replace(I I Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    add-int/lit8 v8, v10, 1
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;
    invoke-direct v11, v9, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V
    const/16 v12, 33
    invoke-virtual v7, v11, v10, v8, v12, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;
    move-object v13, v15
    iget-object v14, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->clickListener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    invoke-direct v11, v9, v14, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    invoke-virtual v7, v11, v10, v8, v12, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    goto/16 -0abh
    move-object v13, v15
    goto/16 -0aeh
    move-object v13, v15
    if-eqz v2, +032h
    invoke-interface/range v17, Landroid/text/Spanned;->length()I
    move-result v1
    const-class v2, Landroid/text/NoCopySpan;
    invoke-interface v0, v5, v1, v2, Landroid/text/Spanned;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v1
    check-cast v1, [Landroid/text/NoCopySpan;
    invoke-static v1, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +01ch
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Landroid/text/NoCopySpan;
    invoke-interface v0, v2, Landroid/text/Spanned;->getSpanStart(Ljava/lang/Object;)I
    move-result v3
    invoke-interface v0, v2, Landroid/text/Spanned;->getSpanEnd(Ljava/lang/Object;)I
    move-result v4
    invoke-interface v0, v2, Landroid/text/Spanned;->getSpanFlags(Ljava/lang/Object;)I
    move-result v5
    if-ltz v3, -018h
    if-ltz v4, -01ah
    invoke-virtual v7, v2, v3, v4, v5, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    goto -1fh
    invoke-direct/range v15 ... v16, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->ensureClickable(Landroid/widget/TextView;)V
    check-cast v7, Landroid/text/Spanned;
    return-object v7
.end method

.method private final ensureClickable(android.widget.TextView)void
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/widget/TextView;->getMovementMethod()Landroid/text/method/MovementMethod;
    move-result-object v0
    instance-of v0, v0, Landroid/text/method/LinkMovementMethod;
    if-nez v0, +009h
    invoke-static Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setHighlightColor(I)V
    return-void 
.end method

.method public final applyOnSpanned(android.widget.TextView  android.text.Spanned  com.bytedance.trae.conversation.chat.block.renderer.ref.TraeRefRenderer$StripResult)android.text.Spanned
    .registers 5
    # ins_size=4
    const-string/jumbo v0, textView
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, source
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    if-eqz v4, +00dh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;->getHasRefs()Z
    move-result v0
    if-eqz v0, +007h
    invoke-direct v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->applyWithPlaceholders(Landroid/widget/TextView; Landroid/text/Spanned; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer$StripResult;)Landroid/text/Spanned;
    move-result-object v2
    return-object v2
    invoke-direct v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->applyLegacy(Landroid/widget/TextView; Landroid/text/Spanned;)Landroid/text/Spanned;
    move-result-object v2
    return-object v2
.end method

.method public final renderPlain(android.widget.TextView  java.lang.String)android.text.Spannable
    .registers 10
    # ins_size=3
    const-string/jumbo v0, textView
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "raw"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;
    invoke-virtual v8, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style$Companion;->from(Landroid/content/Context;)Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;
    move-result-object v0
    new-instance v1, Landroid/text/SpannableStringBuilder;
    invoke-direct v1, Landroid/text/SpannableStringBuilder;-><init>()V
    sget-object v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;
    invoke-virtual v2, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser;->parse(Ljava/lang/String;)Ljava/util/List;
    move-result-object v9
    invoke-interface v9, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +055h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment;
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    if-eqz v3, +00eh
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Text;->getText()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    goto -1bh
    instance-of v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    if-eqz v3, +035h
    invoke-virtual v1, Landroid/text/SpannableStringBuilder;->length()I
    move-result v3
    const-string/jumbo v4, ￼
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v1, v4, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v5
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefChipSpan$Style;)V
    invoke-virtual v1, Landroid/text/SpannableStringBuilder;->length()I
    move-result v5
    const/16 v6, 33
    invoke-virtual v1, v4, v3, v5, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefParser$Segment$Ref;->getGroup()Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup;
    move-result-object v2
    iget-object v5, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->clickListener Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;
    invoke-direct v4, v2, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickableSpan;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefGroup; Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefClickListener;)V
    invoke-virtual v1, Landroid/text/SpannableStringBuilder;->length()I
    move-result v2
    invoke-virtual v1, v4, v3, v2, v6, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object; I I I)V
    goto -52h
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    invoke-direct v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ref/TraeRefRenderer;->ensureClickable(Landroid/widget/TextView;)V
    check-cast v1, Ljava/lang/CharSequence;
    invoke-static v1, Landroid/text/SpannableString;->valueOf(Ljava/lang/CharSequence;)Landroid/text/SpannableString;
    move-result-object v8
    const-string/jumbo v9, valueOf(...)
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/text/Spannable;
    return-object v8
.end method
