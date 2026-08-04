# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;
.super Landroidx/recyclerview/widget/RecyclerView;
.source "AiSubtitleView.kt"

.field private final aiSubtitleAdapter:Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
.field private autoScrollToBottom:Z
.field private final fadeHeight:F
.field private final fadePaint:Landroid/graphics/Paint;
.field private final itemHorizontalPaddingPx:I
.field private final lineHeightPx:I
.field private maxLineWidthPx:F
.field private final measurePaint:Landroid/graphics/Paint;
.field private showTopFade:Z
.field private subtitleLineIdCounter:I
.field private final visibleLineCount:I


.method public static synthetic $r8$lambda$x9TTJqG_fnc1K6NxRgmR4zi5Y9c(com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView  int)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->scrollToBottom$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView; I)V
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 9
    # ins_size=2
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v3, 0
    const/4 v4, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet)void
    .registers 10
    # ins_size=3
    const-string v0, "context"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v4, 0
    const/4 v5, 4
    const/4 v6, 0
    move-object v1, v7
    move-object v2, v8
    move-object v3, v9
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 10
    # ins_size=4
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, v7, v8, v9, Landroidx/recyclerview/widget/RecyclerView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    new-instance v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-direct v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;-><init>()V
    iput-object v8, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    const/4 v9, 3
    iput v9, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->visibleLineCount I
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    const/4 v1, 1
    const/high16 v2, 1107820544
    invoke-static v1, v2, v0, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v0
    float-to-int v0, v0
    iput v0, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->lineHeightPx I
    iput-boolean v1, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->autoScrollToBottom Z
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, Landroid/graphics/Paint;-><init>()V
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    const/4 v4, 2
    const/high16 v5, 1099431936
    invoke-static v4, v5, v3, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v3
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setTextSize(F)V
    const v3, -1134206910
    invoke-virtual v2, v3, Landroid/graphics/Paint;->setLetterSpacing(F)V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->measurePaint Landroid/graphics/Paint;
    new-instance v2, Landroid/graphics/Paint;
    invoke-direct v2, Landroid/graphics/Paint;-><init>()V
    iput-object v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadePaint Landroid/graphics/Paint;
    int-to-float v2, v0
    iput v2, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadeHeight F
    invoke-virtual v6, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->setHasFixedSize(Z)V
    new-instance v1, Landroidx/recyclerview/widget/LinearLayoutManager;
    invoke-direct v1, v7, Landroidx/recyclerview/widget/LinearLayoutManager;-><init>(Landroid/content/Context;)V
    check-cast v1, Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    invoke-virtual v6, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->setLayoutManager(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V
    check-cast v8, Landroidx/recyclerview/widget/RecyclerView$Adapter;
    invoke-virtual v6, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->setAdapter(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V
    const/4 v7, 0
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->setNestedScrollingEnabled(Z)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v7
    if-eqz v7, +005h
    mul-int/2addr v9, v0
    iput v9, v7, Landroid/view/ViewGroup$LayoutParams;->height I
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  android.util.AttributeSet  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v5, v4, 2
    if-eqz v5, +003h
    const/4 v2, 0
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private final appendCharsToLines(java.lang.String)void
    .registers 14
    # ins_size=2
    invoke-virtual v13, Ljava/lang/String;->length()I
    move-result v0
    const/4 v1, 0
    move v2, v1
    if-ge v1, v0, +0adh
    invoke-virtual v13, v1, Ljava/lang/String;->charAt(I)C
    move-result v3
    const/16 v4, 10
    const/4 v5, 1
    if-ne v3, v4, +01eh
    invoke-direct v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->flushLastLineAnimation()V
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    iget v7, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    add-int/lit8 v4, v7, 1
    iput v4, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    const-string v8, ""
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    move-object v6, v3
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;-><init>(I Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v2, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->appendLine(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    move v2, v5
    goto/16 +084h
    iget-object v4, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->getLastLine()Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    move-result-object v6
    if-nez v6, +01bh
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    iget v7, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    add-int/lit8 v6, v7, 1
    iput v6, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    invoke-static v3, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    move-object v6, v4
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;-><init>(I Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->appendLine(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    goto -23h
    new-instance v4, Ljava/lang/StringBuilder;
    invoke-direct v4, Ljava/lang/StringBuilder;-><init>()V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->getText()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v4, v7, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, v3, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v4
    invoke-virtual v4, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v4
    iget-object v7, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->measurePaint Landroid/graphics/Paint;
    invoke-virtual v7, v4, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F
    move-result v7
    iget v8, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->maxLineWidthPx F
    const/4 v9, 0
    cmpl-float v9, v8, v9
    if-lez v9, +024h
    cmpl-float v7, v7, v8
    if-lez v7, +020h
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v2, v6, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->forceUpdateLastLine(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    iget-object v2, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    new-instance v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    iget v7, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    add-int/lit8 v6, v7, 1
    iput v6, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    invoke-static v3, Ljava/lang/String;->valueOf(C)Ljava/lang/String;
    move-result-object v8
    const/4 v9, 0
    const/4 v10, 4
    const/4 v11, 0
    move-object v6, v4
    invoke-direct/range v6 ... v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;-><init>(I Ljava/lang/String; Z I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v2, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->appendLine(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    goto -67h
    const/4 v7, 0
    const/4 v9, 0
    const/4 v10, 5
    const/4 v11, 0
    move-object v8, v4
    invoke-static/range v6 ... v11, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;->copy$default(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine; I Ljava/lang/String; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;
    move-result-object v3
    iget-object v5, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->updateLastLineData(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    invoke-direct v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getLastLineViewHolder()Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    move-result-object v5
    if-eqz v5, +006h
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->animateAppend(Ljava/lang/String;)V
    goto +6h
    iget-object v4, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v4, v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->forceUpdateLastLine(Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$SubtitleLine;)V
    add-int/lit8 v1, v1, 1
    goto/16 -0abh
    if-eqz v2, +009h
    iget-boolean v13, v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->autoScrollToBottom Z
    if-eqz v13, +005h
    invoke-direct v12, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->scrollToBottom()V
    return-void 
.end method

.method private final flushLastLineAnimation()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getLastLineViewHolder()Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    move-result-object v0
    if-eqz v0, +00dh
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->cancelAnimation()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->getTextView()Landroid/widget/TextView;
    move-result-object v0
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTranslationX(F)V
    return-void 
.end method

.method private final getLastLineViewHolder()com.bytedance.trae.conversation.brainstorm.adapter.AiSubtitleAdapter$LineViewHolder
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->getItemCount()I
    move-result v0
    add-int/lit8 v0, v0, -1
    const/4 v1, 0
    if-gez v0, +003h
    return-object v1
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->findViewHolderForAdapterPosition(I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    move-result-object v0
    instance-of v2, v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    if-eqz v2, +005h
    move-object v1, v0
    check-cast v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    return-object v1
.end method

.method private final scrollToBottom()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->getItemCount()I
    move-result v0
    if-lez v0, +00ah
    new-instance v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView; I)V
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method private static final scrollToBottom$lambda$2(com.bytedance.trae.conversation.brainstorm.widget.AiSubtitleView  int)void
    .registers 2
    # ins_size=2
    add-int/lit8 v1, v1, -1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->scrollToPosition(I)V
    return-void 
.end method

.method private final updateFadeVisibility()void
    .registers 3
    # ins_size=1
    iget-boolean v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->showTopFade Z
    if-nez v0, +00fh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->getItemCount()I
    move-result v0
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->visibleLineCount I
    if-le v0, v1, +005h
    const/4 v0, 1
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->showTopFade Z
    return-void 
.end method

.method public final appendText(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string v0, "newChars"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +003h
    return-void 
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->appendCharsToLines(Ljava/lang/String;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->updateFadeVisibility()V
    return-void 
.end method

.method public final clearAll()void
    .registers 3
    # ins_size=1
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getLastLineViewHolder()Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;
    move-result-object v0
    if-eqz v0, +005h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter$LineViewHolder;->cancelAnimation()V
    const/4 v0, 0
    iput v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->subtitleLineIdCounter I
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->aiSubtitleAdapter Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/AiSubtitleAdapter;->clearAll()V
    iput-boolean v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->showTopFade Z
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->invalidate()V
    return-void 
.end method

.method protected dispatchDraw(android.graphics.Canvas)void
    .registers 9
    # ins_size=2
    const-string v0, "canvas"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v7, v8, Landroidx/recyclerview/widget/RecyclerView;->dispatchDraw(Landroid/graphics/Canvas;)V
    iget-boolean v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->showTopFade Z
    if-eqz v0, +011h
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getWidth()I
    move-result v0
    int-to-float v4, v0
    iget v5, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadeHeight F
    iget-object v6, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadePaint Landroid/graphics/Paint;
    move-object v1, v8
    invoke-virtual/range v1 ... v6, Landroid/graphics/Canvas;->drawRect(F F F F Landroid/graphics/Paint;)V
    return-void 
.end method

.method public final getAutoScrollToBottom()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->autoScrollToBottom Z
    return v0
.end method

.method public onInterceptTouchEvent(android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return v1
.end method

.method protected onSizeChanged(int  int  int  int)void
    .registers 13
    # ins_size=5
    invoke-super v8, v9, v10, v11, v12, Landroidx/recyclerview/widget/RecyclerView;->onSizeChanged(I I I I)V
    if-ne v9, v11, +003h
    return-void 
    if-gtz v9, +003h
    return-void 
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getPaddingLeft()I
    move-result v10
    sub-int/2addr v9, v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getPaddingRight()I
    move-result v10
    sub-int/2addr v9, v10
    iget v10, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->itemHorizontalPaddingPx I
    sub-int/2addr v9, v10
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->getContext()Landroid/content/Context;
    move-result-object v10
    invoke-virtual v10, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v10
    const/4 v11, 1
    const/high16 v12, 1098907648
    invoke-static v11, v12, v10, Landroid/util/TypedValue;->applyDimension(I F Landroid/util/DisplayMetrics;)F
    move-result v10
    int-to-float v9, v9
    sub-float/2addr v9, v10
    const/4 v10, 0
    invoke-static v9, v10, Lkotlin/ranges/RangesKt;->coerceAtLeast(F F)F
    move-result v9
    iput v9, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->maxLineWidthPx F
    iget-object v9, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadePaint Landroid/graphics/Paint;
    new-instance v10, Landroid/graphics/LinearGradient;
    const/4 v1, 0
    const/4 v2, 0
    const/4 v3, 0
    iget v4, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->fadeHeight F
    const v5, -419957003
    const v6, 16250613
    sget-object v7, Landroid/graphics/Shader$TileMode;->CLAMP Landroid/graphics/Shader$TileMode;
    move-object v0, v10
    invoke-direct/range v0 ... v7, Landroid/graphics/LinearGradient;-><init>(F F F F I I Landroid/graphics/Shader$TileMode;)V
    check-cast v10, Landroid/graphics/Shader;
    invoke-virtual v9, v10, Landroid/graphics/Paint;->setShader(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    return-void 
.end method

.method public onTouchEvent(android.view.MotionEvent)boolean
    .registers 2
    # ins_size=2
    const/4 v1, 0
    return v1
.end method

.method public final setAutoScrollToBottom(boolean)void
    .registers 2
    # ins_size=2
    iput-boolean v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->autoScrollToBottom Z
    return-void 
.end method

.method public setLayoutParams(android.view.ViewGroup$LayoutParams)void
    .registers 4
    # ins_size=2
    if-eqz v3, +009h
    iget v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->visibleLineCount I
    iget v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/AiSubtitleView;->lineHeightPx I
    mul-int/2addr v0, v1
    iput v0, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-super v2, v3, Landroidx/recyclerview/widget/RecyclerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method
