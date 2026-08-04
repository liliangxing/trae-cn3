# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "CheckpointOptionAdapter.kt"

.field private final checkboxContainer:Landroid/widget/FrameLayout;
.field private final ivCheck:Landroid/widget/ImageView;
.field private final ivSingleCheck:Landroid/widget/ImageView;
.field private final root:Landroid/view/View;
.field private final subtitleBottomFade:Landroid/view/View;
.field private final subtitleTopFade:Landroid/view/View;
.field private final subtitleViewport:Landroid/view/View;
.field private final textContainer:Landroid/view/View;
.field final synthetic this$0:Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
.field private final tvOptionIndex:Landroid/widget/TextView;
.field private final tvSubtitle:Landroid/widget/TextView;
.field private final tvTitle:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$aSXXKJ4eeWrQxERoOAUb3jv2Zk0(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setupSubtitleScrolling$lambda$4(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$b0YZwTe185OaYm9S0gtdYm2G7Ts(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->bind$lambda$1(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$deOYJYV3QWBCdRTSv0Cs0g5lj3Y(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setupSubtitleScrolling$lambda$3(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$ym4BMzwkJerzUEP5omUD8LjWMtA(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  java.lang.String)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->bind$lambda$0(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; Ljava/lang/String;)V
    return-void 
.end method

.method public constructor <init>(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter  android.view.View)void
    .registers 7
    # ins_size=3
    const-string v0, "itemView"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-direct v4, v6, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    sget v5, Lcom/bytedance/trae/conversation/R$id;->option_root I
    invoke-virtual v6, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    const-string v0, "findViewById(...)"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->root Landroid/view/View;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->checkbox_container I
    invoke-virtual v6, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/FrameLayout;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->iv_check I
    invoke-virtual v6, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/ImageView;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivCheck Landroid/widget/ImageView;
    sget v5, Lcom/bytedance/trae/conversation/R$id;->tv_option_index I
    invoke-virtual v6, v5, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v5
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Landroid/widget/TextView;
    iput-object v5, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvOptionIndex Landroid/widget/TextView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_option_single_check I
    invoke-virtual v6, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/ImageView;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivSingleCheck Landroid/widget/ImageView;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->text_container I
    invoke-virtual v6, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->textContainer Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-virtual v6, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v1, Landroid/widget/TextView;
    iput-object v1, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvTitle Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->subtitle_viewport I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-virtual v6, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/TextView;
    iput-object v2, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->subtitle_top_fade I
    invoke-virtual v6, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleTopFade Landroid/view/View;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->subtitle_bottom_fade I
    invoke-virtual v6, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    iput-object v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleBottomFade Landroid/view/View;
    invoke-virtual v6, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->density F
    sget-object v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->INSTANCE Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointTypefaces;->defaultSemibold()Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v1, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const/16 v0, 22
    int-to-float v0, v0
    mul-float/2addr v0, v6
    float-to-int v0, v0
    invoke-static v1, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const/16 v0, 17
    int-to-float v0, v0
    mul-float/2addr v0, v6
    float-to-int v6, v0
    invoke-static v2, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-static v5, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-direct v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setupSubtitleScrolling()V
    return-void 
.end method

.method private final applySubtitleViewport()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Landroid/text/Layout;->getLineCount()I
    move-result v0
    goto +7h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getLineCount()I
    move-result v0
    const/4 v1, 4
    if-le v0, v1, +01ah
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleCollapsedHeightPx()I
    move-result v1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleCollapsedHeightPx()I
    move-result v1
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->updateSubtitleFadeVisibility()V
    goto +4h
    invoke-direct v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->hideSubtitleFades()V
    return-void 
.end method

.method private static final bind$lambda$0(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  java.lang.String)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;
    move-result-object v0
    if-eqz v0, +007h
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    goto +2h
    const/4 v0, 0
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v2
    if-eqz v2, +005h
    invoke-direct v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->applySubtitleViewport()V
    return-void 
.end method

.method private static final bind$lambda$1(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->selectOption(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;)V
    return-void 
.end method

.method private final dp(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->itemView Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v0
    float-to-int v2, v2
    return v2
.end method

.method private final hideSubtitleFades()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleTopFade Landroid/view/View;
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleBottomFade Landroid/view/View;
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method private final selectOption(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption)void
    .registers 11
    # ins_size=2
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->getBindingAdapterPosition()I
    move-result v0
    const/4 v1, -1
    if-ne v0, v1, +003h
    return-void 
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getMultiSelect$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Z
    move-result v1
    const/4 v2, 1
    if-eqz v1, +020h
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v1
    xor-int/2addr v1, v2
    invoke-virtual v10, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->setSelected(Z)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v10
    invoke-direct v9, v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->updateCheckState(Z)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-virtual v10, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->notifyItemChanged(I)V
    iget-object v10, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v10, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getOnSelectionChanged$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Lkotlin/jvm/functions/Function0;
    move-result-object v10
    invoke-interface v10, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    goto +53h
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getItems$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Ljava/util/List;
    move-result-object v1
    check-cast v1, Ljava/lang/Iterable;
    iget-object v3, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    const/4 v4, 0
    move v5, v4
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v6
    if-eqz v6, +01fh
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v6
    add-int/lit8 v7, v5, 1
    if-gez v5, +005h
    invoke-static Lkotlin/collections/CollectionsKt;->throwIndexOverflow()V
    check-cast v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v8
    if-eqz v8, +00ah
    if-eq v5, v0, +008h
    invoke-virtual v6, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->setSelected(Z)V
    invoke-virtual v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->notifyItemChanged(I)V
    move v5, v7
    goto -22h
    invoke-virtual v10, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->setSelected(Z)V
    invoke-direct v9, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->updateCheckState(Z)V
    iget-object v1, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-virtual v1, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->notifyItemChanged(I)V
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getOnSelectionChanged$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    iget-object v0, v9, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getOnSingleSelectConfirmed$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +005h
    invoke-interface v0, v10, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final setBoxSize(int)void
    .registers 4
    # ins_size=2
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->dp(I)I
    move-result v3
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->width I
    if-ne v1, v3, +006h
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    if-eq v1, v3, +00bh
    iput v3, v0, Landroid/view/ViewGroup$LayoutParams;->width I
    iput v3, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    invoke-virtual v3, v0, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setViewHeight(android.view.View  int)void
    .registers 5
    # ins_size=3
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    if-nez v0, +003h
    return-void 
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    if-eq v1, v4, +007h
    iput v4, v0, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v3, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private final setupSubtitleScrolling()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-static Landroid/text/method/ScrollingMovementMethod;->getInstance()Landroid/text/method/MovementMethod;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVerticalScrollBarEnabled(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVerticalFadingEdgeEnabled(Z)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const v1, 2147483647
    invoke-virtual v0, v1, Landroid/widget/TextView;->setMaxLines(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/16 v1, 17
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->dp(I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setFadingEdgeLength(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOverScrollMode(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;
    move-result-object v0
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda1;
    invoke-direct v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;)V
    invoke-virtual v0, v1, Landroid/view/ViewTreeObserver;->addOnScrollChangedListener(Landroid/view/ViewTreeObserver$OnScrollChangedListener;)V
    return-void 
.end method

.method private static final setupSubtitleScrolling$lambda$3(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder  android.view.View  android.view.MotionEvent)boolean
    .registers 6
    # ins_size=3
    const/4 v0, -1
    invoke-virtual v4, v0, Landroid/view/View;->canScrollVertically(I)Z
    move-result v0
    const/4 v1, 0
    const/4 v2, 1
    if-nez v0, +00bh
    invoke-virtual v4, v2, Landroid/view/View;->canScrollVertically(I)Z
    move-result v0
    if-eqz v0, +003h
    goto +3h
    move v0, v1
    goto +2h
    move v0, v2
    if-eqz v0, +026h
    invoke-virtual v5, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v0
    if-eq v0, v2, +00ah
    invoke-virtual v5, Landroid/view/MotionEvent;->getActionMasked()I
    move-result v5
    const/4 v0, 3
    if-eq v5, v0, +003h
    goto +2h
    move v2, v1
    invoke-virtual v4, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v4
    if-eqz v4, +005h
    invoke-interface v4, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    iget-object v3, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->itemView Landroid/view/View;
    invoke-virtual v3, Landroid/view/View;->getParent()Landroid/view/ViewParent;
    move-result-object v3
    if-eqz v3, +00ch
    invoke-interface v3, v2, Landroid/view/ViewParent;->requestDisallowInterceptTouchEvent(Z)V
    goto +7h
    iget-object v3, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->itemView Landroid/view/View;
    invoke-virtual v3, v5, Landroid/view/View;->onTouchEvent(Landroid/view/MotionEvent;)Z
    move v1, v2
    return v1
.end method

.method private static final setupSubtitleScrolling$lambda$4(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOptionAdapter$OptionViewHolder)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->updateSubtitleFadeVisibility()V
    return-void 
.end method

.method private final subtitleCollapsedHeightPx()int
    .registers 3
    # ins_size=1
    const/16 v0, 17
    int-to-float v0, v0
    const/high16 v1, 1083703296
    mul-float/2addr v0, v1
    iget-object v1, v2, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->itemView Landroid/view/View;
    invoke-virtual v1, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v0, v1
    float-to-int v0, v0
    return v0
.end method

.method private final updateCheckState(boolean)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->this$0 Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;->access$getMultiSelect$p(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter;)Z
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-nez v0, +03fh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    const/16 v0, 20
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setBoxSize(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    sget v3, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_option_index I
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setBackgroundResource(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvOptionIndex Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivCheck Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivSingleCheck Landroid/widget/ImageView;
    if-eqz v5, +003h
    move v1, v2
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->textContainer Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v1, v0, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v1, +005h
    check-cast v0, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +03bh
    const/16 v1, 12
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->dp(I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    goto +30h
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setVisibility(I)V
    const/16 v0, 16
    invoke-direct v4, v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setBoxSize(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvOptionIndex Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivSingleCheck Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    if-eqz v5, +00fh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_checkbox_checked I
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setBackgroundResource(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivCheck Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    goto +dh
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->checkboxContainer Landroid/widget/FrameLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_checkbox_unchecked I
    invoke-virtual v0, v2, Landroid/widget/FrameLayout;->setBackgroundResource(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->ivCheck Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->root Landroid/view/View;
    if-eqz v5, +005h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_option_selected I
    goto +3h
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_checkpoint_option_normal I
    invoke-virtual v0, v5, Landroid/view/View;->setBackgroundResource(I)V
    return-void 
.end method

.method private final updateSubtitleFadeVisibility()void
    .registers 6
    # ins_size=1
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    invoke-virtual v0, Landroid/view/View;->getVisibility()I
    move-result v0
    if-nez v0, +030h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getHeight()I
    move-result v0
    if-gtz v0, +003h
    goto +26h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleTopFade Landroid/view/View;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/4 v2, -1
    invoke-virtual v1, v2, Landroid/widget/TextView;->canScrollVertically(I)Z
    move-result v1
    const/4 v2, 0
    const/16 v3, 8
    if-eqz v1, +004h
    move v1, v2
    goto +2h
    move v1, v3
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleBottomFade Landroid/view/View;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/4 v4, 1
    invoke-virtual v1, v4, Landroid/widget/TextView;->canScrollVertically(I)Z
    move-result v1
    if-eqz v1, +003h
    goto +2h
    move v2, v3
    invoke-virtual v0, v2, Landroid/view/View;->setVisibility(I)V
    return-void 
    invoke-direct v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->hideSubtitleFades()V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.chat.checkpoint.CheckpointOption  int)void
    .registers 6
    # ins_size=3
    const-string v0, "option"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvTitle Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getLabel()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvOptionIndex Landroid/widget/TextView;
    const/4 v1, 1
    add-int/2addr v5, v1
    invoke-static v5, Ljava/lang/String;->valueOf(I)Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getDescription()Ljava/lang/String;
    move-result-object v5
    check-cast v5, Ljava/lang/CharSequence;
    const/4 v0, 0
    if-eqz v5, +00ah
    invoke-interface v5, Ljava/lang/CharSequence;->length()I
    move-result v5
    if-nez v5, +003h
    goto +2h
    move v1, v0
    const/4 v5, -2
    if-eqz v1, +024h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v1, v0, v0, Landroid/widget/TextView;->scrollTo(I I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->hideSubtitleFades()V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    invoke-direct v3, v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-direct v3, v0, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    const/16 v0, 8
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    goto +40h
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getDescription()Ljava/lang/String;
    move-result-object v2
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v1, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v1, v0, v0, Landroid/widget/TextView;->scrollTo(I I)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    const v2, 2147483647
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxLines(I)V
    invoke-direct v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->hideSubtitleFades()V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    invoke-direct v3, v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    iget-object v1, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    invoke-direct v3, v1, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->setViewHeight(Landroid/view/View; I)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->subtitleViewport Landroid/view/View;
    invoke-virtual v5, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    invoke-virtual v5, v0, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->getDescription()Ljava/lang/String;
    move-result-object v5
    iget-object v0, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->tvSubtitle Landroid/widget/TextView;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda2;
    invoke-direct v1, v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; Ljava/lang/String;)V
    invoke-virtual v0, v1, Landroid/widget/TextView;->post(Ljava/lang/Runnable;)Z
    invoke-virtual v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;->isSelected()Z
    move-result v5
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->updateCheckState(Z)V
    iget-object v5, v3, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder;->itemView Landroid/view/View;
    new-instance v0, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda3;
    invoke-direct v0, v3, v4, Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOptionAdapter$OptionViewHolder; Lcom/bytedance/trae/conversation/chat/checkpoint/CheckpointOption;)V
    invoke-virtual v5, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method
