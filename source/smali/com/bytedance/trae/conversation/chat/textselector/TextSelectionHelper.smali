# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
.super Ljava/lang/Object;
.source "TextSelectionHelper.kt"

.field public static final INSTANCE:Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
.field private static final TAG:Ljava/lang/String;
.field private static editorField:Ljava/lang/reflect/Field;
.field private static bridge isEnteringSelection:Z
.field private static pendingTextViewRef:Ljava/lang/ref/WeakReference;
.field private static pendingUpRunnable:Ljava/lang/Runnable;
.field private static selectionActionMethod:Ljava/lang/reflect/Method;
.field private static selectionActionModeAvailable:Ljava/lang/Boolean;


.method public static synthetic $r8$lambda$2lvOV8S-tkhEwJNN24kOczT--b8(android.widget.TextView  float  float)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionMode$lambda$1(Landroid/widget/TextView; F F)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7KHID-swcj4YZal5IIeHpRkmQC4(java.lang.ref.WeakReference  float  float  int  int)void
    .registers 5
    # ins_size=5
    invoke-static v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionByTouch$lambda$9(Ljava/lang/ref/WeakReference; F F I I)V
    return-void 
.end method

.method public static synthetic $r8$lambda$R3P1qbo0B7Wy77_lxvKCVXq552A(androidx.recyclerview.widget.RecyclerView)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionMode$lambda$0(Landroidx/recyclerview/widget/RecyclerView;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VnPEO05EOFahejpU4vBorRuF_dI()void
    .registers 0
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionByTouch$lambda$9$lambda$8()V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 1
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    return-void 
.end method

.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final checkBold(android.text.Spannable  int)kotlin.Pair
    .registers 8
    # ins_size=3
    invoke-interface v6, Landroid/text/Spannable;->length()I
    move-result v0
    const-class v1, Lio/noties/markwon/core/spans/StrongEmphasisSpan;
    const/4 v2, 0
    invoke-interface v6, v2, v0, v1, Landroid/text/Spannable;->getSpans(I I Ljava/lang/Class;)[Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Lio/noties/markwon/core/spans/StrongEmphasisSpan;
    invoke-static v0, Lkotlin/jvm/internal/ArrayIteratorKt;->iterator([Ljava/lang/Object;)Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +026h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lio/noties/markwon/core/spans/StrongEmphasisSpan;
    invoke-interface v6, v1, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I
    move-result v3
    invoke-interface v6, v1, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I
    move-result v1
    if-gt v3, v7, +006h
    if-ge v7, v1, +004h
    const/4 v4, 1
    goto +2h
    move v4, v2
    if-eqz v4, -01bh
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v6, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v6
    return-object v6
    const/4 v6, 0
    return-object v6
.end method

.method private final checkBookMark(java.lang.String  int)kotlin.Pair
    .registers 9
    # ins_size=3
    move v0, v8
    const/16 v1, 10
    const/16 v2, 12299
    const/16 v3, 12298
    const/4 v4, 0
    if-lez v0, +018h
    invoke-virtual v7, v0, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v3, +012h
    invoke-virtual v7, v0, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v2, +00ch
    invoke-virtual v7, v0, Ljava/lang/String;->charAt(I)C
    move-result v2
    if-ne v2, v1, +003h
    return-object v4
    add-int/lit8 v0, v0, -1
    goto -1eh
    invoke-virtual v7, v0, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v3, +003h
    return-object v4
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v5
    add-int/lit8 v5, v5, -1
    if-ge v8, v5, +018h
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v3, +012h
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-eq v5, v2, +00ch
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v5
    if-ne v5, v1, +003h
    return-object v4
    add-int/lit8 v8, v8, 1
    goto -1dh
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v7
    if-eq v7, v2, +003h
    return-object v4
    add-int/lit8 v0, v0, 1
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method private final checkBracket(java.lang.String  int)kotlin.Pair
    .registers 12
    # ins_size=3
    const/4 v0, 2
    new-array v1, v0, [Ljava/lang/Character;
    const/16 v2, 40
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v1, v3
    const v4, 65288
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    const/4 v5, 1
    aput-object v4, v1, v5
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    new-array v0, v0, [Lkotlin/Pair;
    const/16 v6, 41
    invoke-static v6, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v7
    invoke-static v2, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    aput-object v2, v0, v3
    const v2, 65289
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v3
    invoke-static v4, v3, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v3
    aput-object v3, v0, v5
    invoke-static v0, Lkotlin/collections/MapsKt;->mapOf([Lkotlin/Pair;)Ljava/util/Map;
    move-result-object v0
    move v3, v11
    const/16 v4, 10
    const/4 v7, 0
    if-lez v3, +026h
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v8
    invoke-static v8, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v8
    invoke-interface v1, v8, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v8
    if-nez v8, +018h
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v8
    if-eq v8, v6, +012h
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v8
    if-eq v8, v2, +00ch
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v8
    if-ne v8, v4, +003h
    return-object v7
    add-int/lit8 v3, v3, -1
    goto -28h
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-interface v1, v2, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return-object v7
    invoke-virtual v10, v3, Ljava/lang/String;->charAt(I)C
    move-result v1
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Character;
    if-eqz v0, +032h
    invoke-virtual v0, Ljava/lang/Character;->charValue()C
    move-result v0
    invoke-virtual v10, Ljava/lang/String;->length()I
    move-result v1
    sub-int/2addr v1, v5
    if-ge v11, v1, +012h
    invoke-virtual v10, v11, Ljava/lang/String;->charAt(I)C
    move-result v1
    if-eq v1, v0, +00ch
    invoke-virtual v10, v11, Ljava/lang/String;->charAt(I)C
    move-result v1
    if-ne v1, v4, +003h
    return-object v7
    add-int/lit8 v11, v11, 1
    goto -16h
    invoke-virtual v10, v11, Ljava/lang/String;->charAt(I)C
    move-result v10
    if-eq v10, v0, +003h
    return-object v7
    add-int/2addr v3, v5
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v10
    invoke-static v11, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v10, v11, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v10
    return-object v10
    return-object v7
.end method

.method private final checkContinuousLetterInNonLetter(java.lang.String  int)kotlin.Pair
    .registers 9
    # ins_size=3
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v0
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isNumOrLetter(C)Z
    move-result v0
    const/4 v1, 0
    if-nez v0, +003h
    return-object v1
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v0
    invoke-direct v6, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v0
    move v2, v8
    const/4 v3, 1
    if-lez v2, +018h
    add-int/lit8 v4, v2, -1
    invoke-direct v6, v7, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isWordChar(Ljava/lang/String; I)Z
    move-result v4
    if-eqz v4, +010h
    add-int/lit8 v2, v2, -1
    invoke-virtual v7, v2, Ljava/lang/String;->charAt(I)C
    move-result v4
    invoke-direct v6, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v4
    if-eqz v4, -015h
    move v0, v3
    goto -18h
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v4
    sub-int/2addr v4, v3
    if-ge v8, v4, +017h
    add-int/lit8 v4, v8, 1
    invoke-direct v6, v7, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isWordChar(Ljava/lang/String; I)Z
    move-result v5
    if-eqz v5, +00fh
    invoke-virtual v7, v4, Ljava/lang/String;->charAt(I)C
    move-result v8
    invoke-direct v6, v8, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v8
    if-eqz v8, +003h
    move v0, v3
    move v8, v4
    goto -1bh
    if-nez v0, +003h
    return-object v1
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    add-int/2addr v8, v3
    invoke-static v8, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method private final checkQuotation(java.lang.String  int)kotlin.Pair
    .registers 13
    # ins_size=3
    const/4 v0, 3
    new-array v0, v0, [Lkotlin/Pair;
    const/16 v1, 34
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-static v2, v2, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v3, 0
    aput-object v2, v0, v3
    const/16 v2, 8220
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    const/16 v4, 8221
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    invoke-static v2, v4, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v4, 1
    aput-object v2, v0, v4
    const/16 v2, 8216
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    const/16 v5, 8217
    invoke-static v5, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v5
    invoke-static v2, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v2
    const/4 v5, 2
    aput-object v2, v0, v5
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    move v2, v12
    const/16 v5, 10
    const/4 v6, 0
    if-lez v2, +016h
    invoke-virtual v11, v2, Ljava/lang/String;->charAt(I)C
    move-result v7
    invoke-direct v10, v7, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isQuoteChar(C)Z
    move-result v7
    if-nez v7, +00ch
    invoke-virtual v11, v2, Ljava/lang/String;->charAt(I)C
    move-result v7
    if-ne v7, v5, +003h
    return-object v6
    add-int/lit8 v2, v2, -1
    goto -18h
    invoke-virtual v11, v2, Ljava/lang/String;->charAt(I)C
    move-result v7
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v8
    if-eqz v8, +01bh
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v8
    move-object v9, v8
    check-cast v9, Lkotlin/Pair;
    invoke-virtual v9, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v9
    check-cast v9, Ljava/lang/Character;
    invoke-virtual v9, Ljava/lang/Character;->charValue()C
    move-result v9
    if-ne v9, v7, +004h
    move v9, v4
    goto +2h
    move v9, v3
    if-eqz v9, -01ch
    goto +2h
    move-object v8, v6
    check-cast v8, Lkotlin/Pair;
    if-eqz v8, +00dh
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Character;
    invoke-virtual v0, Ljava/lang/Character;->charValue()C
    move-result v1
    goto +6h
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    if-ne v7, v1, +031h
    invoke-virtual v11, Ljava/lang/String;->length()I
    move-result v0
    sub-int/2addr v0, v4
    if-ge v12, v0, +012h
    invoke-virtual v11, v12, Ljava/lang/String;->charAt(I)C
    move-result v0
    if-eq v0, v1, +00ch
    invoke-virtual v11, v12, Ljava/lang/String;->charAt(I)C
    move-result v0
    if-ne v0, v5, +003h
    return-object v6
    add-int/lit8 v12, v12, 1
    goto -16h
    invoke-virtual v11, v12, Ljava/lang/String;->charAt(I)C
    move-result v11
    if-eq v11, v1, +003h
    return-object v6
    if-ne v2, v12, +003h
    return-object v6
    add-int/2addr v2, v4
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v11
    invoke-static v12, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v12
    invoke-static v11, v12, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v11
    return-object v11
    return-object v6
.end method

.method private final enterSelectionByTouch(android.widget.TextView  float  float  int  int)void
    .registers 13
    # ins_size=6
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->cancelPendingSelection()V
    const/4 v0, 1
    sput-boolean v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection Z
    new-instance v2, Ljava/lang/ref/WeakReference;
    invoke-direct v2, v8, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V
    sput-object v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingTextViewRef Ljava/lang/ref/WeakReference;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;
    move-object v1, v0
    move v3, v9
    move v4, v10
    move v5, v11
    move v6, v12
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda3;-><init>(Ljava/lang/ref/WeakReference; F F I I)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingUpRunnable Ljava/lang/Runnable;
    invoke-virtual v8, v0, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final enterSelectionByTouch$lambda$9(java.lang.ref.WeakReference  float  float  int  int)void
    .registers 8
    # ins_size=5
    const/4 v0, 0
    sput-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingUpRunnable Ljava/lang/Runnable;
    sput-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingTextViewRef Ljava/lang/ref/WeakReference;
    invoke-virtual v3, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    const/4 v1, 0
    if-eqz v3, +044h
    invoke-virtual v3, Landroid/widget/TextView;->isAttachedToWindow()Z
    move-result v2
    if-eqz v2, +003h
    goto +2h
    move-object v3, v0
    if-nez v3, +003h
    goto +38h
    invoke-virtual v3, v4, v5, Landroid/widget/TextView;->performLongClick(F F)Z
    invoke-virtual v3, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v4
    instance-of v5, v4, Landroid/text/Spannable;
    if-eqz v5, +005h
    move-object v0, v4
    check-cast v0, Landroid/text/Spannable;
    if-eqz v0, +020h
    const/4 v4, 1
    if-ltz v6, +00ah
    invoke-interface v0, Landroid/text/Spannable;->length()I
    move-result v5
    if-gt v6, v5, +004h
    move v5, v4
    goto +2h
    move v5, v1
    if-eqz v5, +012h
    if-gt v6, v7, +009h
    invoke-interface v0, Landroid/text/Spannable;->length()I
    move-result v5
    if-gt v7, v5, +003h
    move v1, v4
    if-eqz v1, +007h
    if-eq v6, v7, +005h
    invoke-static v0, v6, v7, Landroid/text/Selection;->setSelection(Landroid/text/Spannable; I I)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda2;
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda2;-><init>()V
    invoke-virtual v3, v4, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
    sput-boolean v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection Z
    return-void 
.end method

.method private static final enterSelectionByTouch$lambda$9$lambda$8()void
    .registers 1
    # ins_size=0
    const/4 v0, 0
    sput-boolean v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection Z
    return-void 
.end method

.method private static final enterSelectionMode$lambda$0(androidx.recyclerview.widget.RecyclerView)void
    .registers 2
    # ins_size=1
    const/4 v0, 0
    invoke-virtual v1, v0, Landroidx/recyclerview/widget/RecyclerView;->suppressLayout(Z)V
    return-void 
.end method

.method private static final enterSelectionMode$lambda$1(android.widget.TextView  float  float)void
    .registers 12
    # ins_size=3
    invoke-virtual v9, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    instance-of v1, v0, Landroid/text/Spannable;
    if-eqz v1, +005h
    check-cast v0, Landroid/text/Spannable;
    goto +2h
    const/4 v0, 0
    if-nez v0, +003h
    return-void 
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v1
    move-object v2, v1
    check-cast v2, Ljava/lang/CharSequence;
    invoke-interface v2, Ljava/lang/CharSequence;->length()I
    move-result v2
    if-nez v2, +004h
    const/4 v2, 1
    goto +2h
    const/4 v2, 0
    if-eqz v2, +003h
    return-void 
    sget-object v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v3, v9, v10, v11, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->getCharIndexAtPosition(Landroid/widget/TextView; F F)I
    move-result v2
    invoke-direct v3, v0, v1, v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->getSelectPair(Landroid/text/Spannable; Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v1
    invoke-virtual v1, Lkotlin/Pair;->component1()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v7
    invoke-virtual v1, Lkotlin/Pair;->component2()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v8
    invoke-static v0, v7, v8, Landroid/text/Selection;->setSelection(Landroid/text/Spannable; I I)V
    sget v0, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v1, 26
    if-ge v0, v1, +007h
    invoke-direct v3, v9, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->tryReflectStartSelectionLess26(Landroid/widget/TextView;)Z
    move-result v0
    goto +5h
    invoke-direct v3, v9, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->tryReflectStartSelection(Landroid/widget/TextView;)Z
    move-result v0
    if-nez v0, +008h
    move-object v4, v9
    move v5, v10
    move v6, v11
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->enterSelectionByTouch(Landroid/widget/TextView; F F I I)V
    return-void 
.end method

.method private final varargs findMethodUpHierarchy(java.lang.Class  java.lang.String  java.lang.Class[])java.lang.reflect.Method
    .registers 6
    # ins_size=4
    if-eqz v3, +03ch
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v2
    check-cast v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    array-length v0, v5
    invoke-static v5, v0, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v0
    check-cast v0, [Ljava/lang/Class;
    invoke-virtual v3, v4, v0, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v3
    return-object v3
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    sget-object v0, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    move-object v0, v3
    check-cast v0, Ljava/lang/Class;
    const/4 v0, 0
    new-array v0, v0, [Ljava/lang/Class;
    invoke-virtual v3, v4, v0, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v3
    return-object v3
    move-exception v0
    sget-object v1, Lkotlin/Result;->Companion Lkotlin/Result$Companion;
    invoke-static v0, Lkotlin/ResultKt;->createFailure(Ljava/lang/Throwable;)Ljava/lang/Object;
    move-result-object v0
    invoke-static v0, Lkotlin/Result;->constructor-impl(Ljava/lang/Object;)Ljava/lang/Object;
    move-object v0, v3
    check-cast v0, Ljava/lang/Class;
    invoke-virtual v3, Ljava/lang/Class;->getSuperclass()Ljava/lang/Class;
    move-result-object v3
    goto -3bh
    const/4 v3, 0
    return-object v3
    :try_start_0x2
    :try_start_0x1d
.end method

.method private final findParentRecyclerView(android.view.View)androidx.recyclerview.widget.RecyclerView
    .registers 3
    # ins_size=2
    invoke-virtual v2, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    if-eqz v2, +00eh
    instance-of v0, v2, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v0, +005h
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView;
    return-object v2
    invoke-interface v2, Landroid/view/ViewParent;->getParent()Landroid/view/ViewParent;
    move-result-object v2
    goto -dh
    const/4 v2, 0
    return-object v2
.end method

.method private final getCharIndexAtPosition(android.widget.TextView  float  float)int
    .registers 8
    # ins_size=4
    invoke-virtual v5, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;
    move-result-object v0
    if-nez v0, +004h
    const/4 v5, 0
    return v5
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingLeft()I
    move-result v1
    int-to-float v1, v1
    sub-float/2addr v6, v1
    invoke-virtual v5, Landroid/widget/TextView;->getWidth()I
    move-result v1
    int-to-float v1, v1
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingLeft()I
    move-result v2
    int-to-float v2, v2
    sub-float/2addr v1, v2
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingRight()I
    move-result v2
    int-to-float v2, v2
    sub-float/2addr v1, v2
    const/4 v2, 0
    invoke-static v6, v2, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v6
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingTop()I
    move-result v1
    int-to-float v1, v1
    sub-float/2addr v7, v1
    invoke-virtual v5, Landroid/widget/TextView;->getHeight()I
    move-result v1
    int-to-float v1, v1
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingTop()I
    move-result v3
    int-to-float v3, v3
    sub-float/2addr v1, v3
    invoke-virtual v5, Landroid/widget/TextView;->getTotalPaddingBottom()I
    move-result v5
    int-to-float v5, v5
    sub-float/2addr v1, v5
    invoke-static v7, v2, v1, Lkotlin/ranges/RangesKt;->coerceIn(F F F)F
    move-result v5
    float-to-int v5, v5
    invoke-virtual v0, v5, Landroid/text/Layout;->getLineForVertical(I)I
    move-result v5
    invoke-virtual v0, v5, v6, Landroid/text/Layout;->getOffsetForHorizontal(I F)I
    move-result v5
    return v5
.end method

.method private final getSelectPair(android.text.Spannable  java.lang.String  int)kotlin.Pair
    .registers 6
    # ins_size=4
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v0
    add-int/lit8 v0, v0, -1
    const/4 v1, 0
    invoke-static v5, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v5
    invoke-direct v2, v3, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->checkBold(Landroid/text/Spannable; I)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, +003h
    return-object v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->checkBookMark(Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v5, v4, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->trimResult(Ljava/lang/String; Lkotlin/Pair;)Lkotlin/Pair;
    move-result-object v3
    return-object v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->checkQuotation(Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v5, v4, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->trimResult(Ljava/lang/String; Lkotlin/Pair;)Lkotlin/Pair;
    move-result-object v3
    return-object v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->checkBracket(Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v5, v4, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->trimResult(Ljava/lang/String; Lkotlin/Pair;)Lkotlin/Pair;
    move-result-object v3
    return-object v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->checkContinuousLetterInNonLetter(Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v3
    if-eqz v3, +009h
    sget-object v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;
    invoke-direct v5, v4, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->trimResult(Ljava/lang/String; Lkotlin/Pair;)Lkotlin/Pair;
    move-result-object v3
    return-object v3
    invoke-direct v2, v4, v5, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->getSentencePair(Ljava/lang/String; I)Lkotlin/Pair;
    move-result-object v3
    invoke-direct v2, v4, v3, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->trimResult(Ljava/lang/String; Lkotlin/Pair;)Lkotlin/Pair;
    move-result-object v3
    return-object v3
.end method

.method private final getSentencePair(java.lang.String  int)kotlin.Pair
    .registers 6
    # ins_size=3
    const/4 v0, 7
    new-array v0, v0, [Ljava/lang/Character;
    const/16 v1, 12290
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 0
    aput-object v1, v0, v2
    const v1, 65281
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 1
    aput-object v1, v0, v2
    const v1, 65311
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 2
    aput-object v1, v0, v2
    const/16 v1, 46
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 3
    aput-object v1, v0, v2
    const/16 v1, 33
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 4
    aput-object v1, v0, v2
    const/16 v1, 63
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 5
    aput-object v1, v0, v2
    const/16 v1, 10
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v1
    const/4 v2, 6
    aput-object v1, v0, v2
    invoke-static v0, Lkotlin/collections/SetsKt;->setOf([Ljava/lang/Object;)Ljava/util/Set;
    move-result-object v0
    move v1, v5
    if-lez v1, +015h
    add-int/lit8 v2, v1, -1
    invoke-virtual v4, v2, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +005h
    add-int/lit8 v1, v1, -1
    goto -14h
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v2
    if-ge v5, v2, +013h
    invoke-virtual v4, v5, Ljava/lang/String;->charAt(I)C
    move-result v2
    invoke-static v2, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v2
    invoke-interface v0, v2, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-nez v2, +005h
    add-int/lit8 v5, v5, 1
    goto -16h
    invoke-virtual v4, Ljava/lang/String;->length()I
    move-result v2
    if-ge v5, v2, +012h
    invoke-virtual v4, v5, Ljava/lang/String;->charAt(I)C
    move-result v4
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    invoke-interface v0, v4, Ljava/util/Set;->contains(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +004h
    add-int/lit8 v5, v5, 1
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v4
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    invoke-static v4, v5, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v4
    return-object v4
.end method

.method private final isLetter(char)boolean
    .registers 5
    # ins_size=2
    const/16 v0, 65
    const/4 v1, 1
    const/4 v2, 0
    if-gt v0, v4, +008h
    const/16 v0, 91
    if-ge v4, v0, +004h
    move v0, v1
    goto +2h
    move v0, v2
    if-nez v0, +011h
    const/16 v0, 97
    if-gt v0, v4, +008h
    const/16 v0, 123
    if-ge v4, v0, +004h
    move v4, v1
    goto +2h
    move v4, v2
    if-eqz v4, +003h
    goto +2h
    move v1, v2
    return v1
.end method

.method private final isNumOrLetter(char)boolean
    .registers 3
    # ins_size=2
    invoke-static v2, Ljava/lang/Character;->isDigit(C)Z
    move-result v0
    if-nez v0, +00bh
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v2
    if-eqz v2, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final isQuoteChar(char)boolean
    .registers 3
    # ins_size=2
    const/16 v0, 34
    if-eq v2, v0, +00dh
    const/16 v0, 8220
    if-eq v2, v0, +009h
    const/16 v0, 8216
    if-ne v2, v0, +003h
    goto +3h
    const/4 v2, 0
    goto +2h
    const/4 v2, 1
    return v2
.end method

.method private final isWordChar(java.lang.String  int)boolean
    .registers 9
    # ins_size=3
    const/4 v0, 0
    if-ltz v8, +08ch
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v1
    if-lt v8, v1, +004h
    goto/16 +084h
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v1
    invoke-direct v6, v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isNumOrLetter(C)Z
    move-result v2
    const/4 v3, 1
    if-eqz v2, +003h
    return v3
    const/4 v2, 5
    new-array v2, v2, [Ljava/lang/Character;
    const/16 v4, 32
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    aput-object v4, v2, v0
    const/16 v4, 47
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    aput-object v4, v2, v3
    const/16 v4, 45
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    const/4 v5, 2
    aput-object v4, v2, v5
    const/16 v4, 37
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    const/4 v5, 3
    aput-object v4, v2, v5
    const/16 v4, 8240
    invoke-static v4, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    const/4 v5, 4
    aput-object v4, v2, v5
    invoke-static v2, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v2
    invoke-static v1, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;
    move-result-object v4
    invoke-interface v2, v4, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +003h
    return v3
    const/16 v2, 44
    const/16 v4, 46
    if-eq v1, v2, +005h
    if-eq v1, v4, +003h
    goto +31h
    if-lez v8, +030h
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v2
    sub-int/2addr v2, v3
    if-ge v8, v2, +029h
    add-int/lit8 v2, v8, -1
    invoke-virtual v7, v2, Ljava/lang/String;->charAt(I)C
    move-result v2
    add-int/2addr v8, v3
    invoke-virtual v7, v8, Ljava/lang/String;->charAt(I)C
    move-result v7
    if-ne v1, v4, +00fh
    invoke-direct v6, v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v8
    if-eqz v8, +009h
    invoke-direct v6, v7, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isLetter(C)Z
    move-result v8
    if-eqz v8, +003h
    return v3
    invoke-static v2, Ljava/lang/Character;->isDigit(C)Z
    move-result v8
    if-eqz v8, +009h
    invoke-static v7, Ljava/lang/Character;->isDigit(C)Z
    move-result v7
    if-eqz v7, +003h
    return v3
    return v0
.end method

.method private final trimResult(java.lang.String  kotlin.Pair)kotlin.Pair
    .registers 9
    # ins_size=3
    invoke-virtual v8, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    const/4 v2, 0
    if-ge v0, v1, +0a9h
    invoke-virtual v8, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    if-ltz v0, +09dh
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v1
    if-le v0, v1, +004h
    goto/16 +08bh
    invoke-virtual v8, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Ljava/lang/Number;
    invoke-virtual v0, Ljava/lang/Number;->intValue()I
    move-result v0
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    invoke-virtual v7, v0, v1, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v7
    const-string/jumbo v0, substring(...)
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v8, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Ljava/lang/Number;
    invoke-virtual v1, Ljava/lang/Number;->intValue()I
    move-result v1
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v3
    move v4, v2
    if-ge v4, v3, +017h
    invoke-virtual v7, v4, Ljava/lang/String;->charAt(I)C
    move-result v5
    invoke-static v5, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v5
    if-nez v5, +00ah
    invoke-virtual v7, v2, v4, Ljava/lang/String;->substring(I I)Ljava/lang/String;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +5h
    add-int/lit8 v4, v4, 1
    goto -16h
    move-object v2, v7
    invoke-virtual v2, Ljava/lang/String;->length()I
    move-result v2
    add-int/2addr v1, v2
    invoke-virtual v8, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Ljava/lang/Number;
    invoke-virtual v2, Ljava/lang/Number;->intValue()I
    move-result v2
    move-object v3, v7
    check-cast v3, Ljava/lang/CharSequence;
    invoke-static v3, Lkotlin/text/StringsKt;->getLastIndex(Ljava/lang/CharSequence;)I
    move-result v3
    const/4 v4, -1
    if-ge v4, v3, +019h
    invoke-virtual v7, v3, Ljava/lang/String;->charAt(I)C
    move-result v4
    invoke-static v4, Lkotlin/text/CharsKt;->isWhitespace(C)Z
    move-result v4
    if-nez v4, +00ch
    add-int/lit8 v3, v3, 1
    invoke-virtual v7, v3, Ljava/lang/String;->substring(I)Ljava/lang/String;
    move-result-object v7
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    goto +4h
    add-int/lit8 v3, v3, -1
    goto -19h
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v7
    sub-int/2addr v2, v7
    if-ge v1, v2, +00eh
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-static v7, v8, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v8
    return-object v8
    invoke-static v2, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-virtual v7, Ljava/lang/String;->length()I
    move-result v7
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    invoke-static v8, v7, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v7
    return-object v7
.end method

.method private final tryReflectStartSelection(android.widget.TextView)boolean
    .registers 8
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-nez v1, +00ch
    const-class v1, Landroid/widget/TextView;
    const-string v2, "mEditor"
    invoke-virtual v1, v2, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-nez v1, +003h
    return v0
    const/4 v2, 1
    if-eqz v1, +005h
    invoke-virtual v1, v2, Ljava/lang/reflect/Field;->setAccessible(Z)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-eqz v1, +05ch
    invoke-virtual v1, v7, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-nez v7, +003h
    goto +54h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-nez v1, +018h
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    const-string/jumbo v3, startSelectionActionModeAsync
    new-array v4, v2, [Ljava/lang/Class;
    sget-object v5, Ljava/lang/Boolean;->TYPE Ljava/lang/Class;
    aput-object v5, v4, v0
    invoke-direct v6, v1, v3, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->findMethodUpHierarchy(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v1
    if-nez v1, +003h
    return v0
    sput-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +005h
    invoke-virtual v1, v2, Ljava/lang/reflect/Method;->setAccessible(Z)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +012h
    invoke-virtual v1, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;
    move-result-object v1
    if-eqz v1, +00ch
    array-length v1, v1
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v0
    if-ne v1, v2, +004h
    move v1, v2
    goto +2h
    move v1, v0
    if-eqz v1, +00ch
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +017h
    new-array v3, v0, [Ljava/lang/Object;
    invoke-virtual v1, v7, v3, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    goto +10h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +00dh
    new-array v3, v2, [Ljava/lang/Object;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    aput-object v4, v3, v0
    invoke-virtual v1, v7, v3, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move v0, v2
    nop 
    return v0
    :try_start_0x1
.end method

.method private final tryReflectStartSelectionLess26(android.widget.TextView)boolean
    .registers 8
    # ins_size=2
    const/4 v0, 0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-nez v1, +00ch
    const-class v1, Landroid/widget/TextView;
    const-string v2, "mEditor"
    invoke-virtual v1, v2, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-nez v1, +003h
    return v0
    const/4 v2, 1
    if-eqz v1, +005h
    invoke-virtual v1, v2, Ljava/lang/reflect/Field;->setAccessible(Z)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->editorField Ljava/lang/reflect/Field;
    if-eqz v1, +05ch
    invoke-virtual v1, v7, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v7
    if-nez v7, +003h
    goto +54h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-nez v1, +018h
    invoke-virtual v7, Ljava/lang/Object;->getClass()Ljava/lang/Class;
    move-result-object v1
    const-string/jumbo v3, startSelectionActionMode
    new-array v4, v2, [Ljava/lang/Class;
    sget-object v5, Ljava/lang/Boolean;->TYPE Ljava/lang/Class;
    aput-object v5, v4, v0
    invoke-direct v6, v1, v3, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->findMethodUpHierarchy(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v1
    if-nez v1, +003h
    return v0
    sput-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +005h
    invoke-virtual v1, v2, Ljava/lang/reflect/Method;->setAccessible(Z)V
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +012h
    invoke-virtual v1, Ljava/lang/reflect/Method;->getParameterTypes()[Ljava/lang/Class;
    move-result-object v1
    if-eqz v1, +00ch
    array-length v1, v1
    if-nez v1, +004h
    move v1, v2
    goto +2h
    move v1, v0
    if-ne v1, v2, +004h
    move v1, v2
    goto +2h
    move v1, v0
    if-eqz v1, +00ch
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +017h
    new-array v3, v0, [Ljava/lang/Object;
    invoke-virtual v1, v7, v3, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    goto +10h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionMethod Ljava/lang/reflect/Method;
    if-eqz v1, +00dh
    new-array v3, v2, [Ljava/lang/Object;
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v4
    aput-object v4, v3, v0
    invoke-virtual v1, v7, v3, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object; [Ljava/lang/Object;)Ljava/lang/Object;
    move v0, v2
    nop 
    return v0
    :try_start_0x1
.end method

.method public final cancelPendingSelection()void
    .registers 4
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingUpRunnable Ljava/lang/Runnable;
    sget-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingTextViewRef Ljava/lang/ref/WeakReference;
    const/4 v2, 0
    if-eqz v1, +009h
    invoke-virtual v1, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    goto +2h
    move-object v1, v2
    if-eqz v0, +007h
    if-eqz v1, +005h
    invoke-virtual v1, v0, Landroid/widget/TextView;->removeCallbacks(Ljava/lang/Runnable;)Z
    sput-object v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingUpRunnable Ljava/lang/Runnable;
    sput-object v2, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->pendingTextViewRef Ljava/lang/ref/WeakReference;
    const/4 v0, 0
    sput-boolean v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection Z
    return-void 
.end method

.method public final enterSelectionMode(android.widget.TextView  float  float)void
    .registers 7
    # ins_size=4
    const-string/jumbo v0, textView
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v4
    check-cast v0, Landroid/view/View;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->findParentRecyclerView(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView;
    move-result-object v0
    const/4 v1, 1
    if-eqz v0, +005h
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->suppressLayout(Z)V
    invoke-virtual v4, v1, Landroid/widget/TextView;->setTextIsSelectable(Z)V
    invoke-virtual v4, v1, Landroid/widget/TextView;->setFocusable(Z)V
    invoke-virtual v4, v1, Landroid/widget/TextView;->setFocusableInTouchMode(Z)V
    invoke-virtual v4, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$color;->trae_text_select_highlight I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v4, v1, Landroid/widget/TextView;->setHighlightColor(I)V
    invoke-virtual v4, Landroid/widget/TextView;->requestFocus()Z
    if-eqz v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda0;
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda0;-><init>(Landroidx/recyclerview/widget/RecyclerView;)V
    invoke-virtual v0, v1, Landroidx/recyclerview/widget/RecyclerView;->post(Ljava/lang/Runnable;)Z
    new-instance v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;
    invoke-direct v0, v4, v5, v6, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper$$ExternalSyntheticLambda1;-><init>(Landroid/widget/TextView; F F)V
    invoke-virtual v4, v0, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final isEnteringSelection()boolean
    .registers 2
    # ins_size=1
    sget-boolean v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->isEnteringSelection Z
    return v0
.end method

.method public final isSelectionActionModeAvailable()boolean
    .registers 7
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionModeAvailable Ljava/lang/Boolean;
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Boolean;->booleanValue()Z
    move-result v0
    return v0
    const/4 v0, 0
    const-class v1, Landroid/widget/TextView;
    const-string v2, "mEditor"
    invoke-virtual v1, v2, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;
    move-result-object v1
    if-nez v1, +003h
    return v0
    const-string v1, "android.widget.Editor"
    invoke-static v1, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    move-result-object v1
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v3, 26
    if-ge v2, v3, +006h
    const-string/jumbo v2, startSelectionActionMode
    goto +4h
    const-string/jumbo v2, startSelectionActionModeAsync
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    const/4 v3, 1
    new-array v4, v3, [Ljava/lang/Class;
    sget-object v5, Ljava/lang/Boolean;->TYPE Ljava/lang/Class;
    aput-object v5, v4, v0
    invoke-direct v6, v1, v2, v4, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->findMethodUpHierarchy(Ljava/lang/Class; Ljava/lang/String; [Ljava/lang/Class;)Ljava/lang/reflect/Method;
    move-result-object v1
    if-eqz v1, +00ch
    move v0, v3
    goto +9h
    move-exception v1
    const-string v2, "TextSelectionHelper"
    const-string v3, "isSelectionActionModeAvailable"
    invoke-static v2, v3, v1, Landroid/util/Log;->e(Ljava/lang/String; Ljava/lang/String; Ljava/lang/Throwable;)I
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v1
    sput-object v1, Lcom/bytedance/trae/conversation/chat/textselector/TextSelectionHelper;->selectionActionModeAvailable Ljava/lang/Boolean;
    return v0
    :try_start_0xa
.end method
