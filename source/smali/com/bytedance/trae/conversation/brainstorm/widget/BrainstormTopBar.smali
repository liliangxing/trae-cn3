# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
.super Landroidx/constraintlayout/widget/ConstraintLayout;
.source "BrainstormTopBar.kt"

.field private final actionPill:Landroid/widget/LinearLayout;
.field private final actionPillShadow:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
.field private final btnLeft:Landroid/widget/ImageView;
.field private final btnLeftShadow:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
.field private final btnMinimize:Landroid/widget/ImageView;
.field private final btnSubtitleToggle:Landroid/widget/ImageView;
.field private currentTimeoutState:Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
.field private final defaultActionPillWidth:I
.field private onBackClick:Lkotlin/jvm/functions/Function0;
.field private onMinimizeClick:Lkotlin/jvm/functions/Function0;
.field private onSubtitleToggleClick:Lkotlin/jvm/functions/Function0;
.field private final shadowDy:I
.field private final shadowPaddingBottom:I
.field private final shadowPaddingTop:I
.field private final shadowRadius:I
.field private final spacePillGap:Landroid/widget/Space;
.field private final timerContainer:Landroid/widget/LinearLayout;
.field private final tvTimeoutChip:Landroid/widget/TextView;
.field private final tvTimer:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$-O4NXDnSH3nvdEzuqBBt1mpFbe8(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->_init_$lambda$0(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$2HJQC5rahkxonzjIKDKn0sI3mVQ(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->_init_$lambda$2(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$7A-KNNKLr0GLZokXNxudoNh16bo(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setMinimizeVisible$lambda$6(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$M0bGR7cauRkIa1Q0dZsqk-w5WuU(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->_init_$lambda$1(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Wn60qY1k7itAFGCYLLVJIbAUyrI(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setMode$lambda$7(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
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
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  android.util.AttributeSet  int)void
    .registers 9
    # ins_size=4
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, v6, v7, v8, Landroidx/constraintlayout/widget/ConstraintLayout;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_shadow_blur_radius I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    iput v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowRadius I
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_title_bar_shadow_offset_y I
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    iput v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowDy I
    sub-int v0, v7, v8
    const/4 v1, 0
    invoke-static v0, v1, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v0
    iput v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingTop I
    add-int/2addr v7, v8
    iput v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingBottom I
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Normal Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    iput-object v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->currentTimeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    invoke-static v6, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v6
    sget v7, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_brainstorm_top_bar I
    move-object v8, v5
    check-cast v8, Landroid/view/ViewGroup;
    const/4 v0, 1
    invoke-virtual v6, v7, v8, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    sget v6, Lcom/bytedance/trae/conversation/R$id;->btn_left I
    invoke-virtual v5, v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v6
    const-string v7, "findViewById(...)"
    invoke-static v6, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v6, Landroid/widget/ImageView;
    iput-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeft Landroid/widget/ImageView;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->timer_container I
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/widget/LinearLayout;
    iput-object v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->timerContainer Landroid/widget/LinearLayout;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tv_timer I
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/widget/TextView;
    iput-object v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimer Landroid/widget/TextView;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tv_timeout_chip I
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/widget/TextView;
    iput-object v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimeoutChip Landroid/widget/TextView;
    sget v8, Lcom/bytedance/trae/conversation/R$id;->action_pill I
    invoke-virtual v5, v8, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v8
    invoke-static v8, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v8, Landroid/widget/LinearLayout;
    iput-object v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->btn_subtitle_toggle I
    invoke-virtual v5, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    iput-object v2, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnSubtitleToggle Landroid/widget/ImageView;
    sget v3, Lcom/bytedance/trae/conversation/R$id;->btn_minimize I
    invoke-virtual v5, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/ImageView;
    iput-object v3, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnMinimize Landroid/widget/ImageView;
    sget v4, Lcom/bytedance/trae/conversation/R$id;->space_pill_gap I
    invoke-virtual v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->findViewById(I)Landroid/view/View;
    move-result-object v4
    invoke-static v4, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/Space;
    iput-object v4, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->spacePillGap Landroid/widget/Space;
    invoke-virtual v8, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v7
    iget v7, v7, Landroid/view/ViewGroup$LayoutParams;->width I
    iput v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->defaultActionPillWidth I
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->createTopButtonShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v7
    iput-object v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeftShadow Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->createTopButtonShadowView()Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    move-result-object v8
    iput-object v8, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPillShadow Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    check-cast v7, Landroid/view/View;
    new-instance v4, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-direct v4, v1, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v7, v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v8, Landroid/view/View;
    new-instance v7, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-direct v7, v1, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v8, v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->addView(Landroid/view/View; I Landroid/view/ViewGroup$LayoutParams;)V
    invoke-direct v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->applyTopButtonShadows()V
    new-instance v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda0;
    invoke-direct v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    invoke-virtual v6, v7, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda1;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    invoke-virtual v2, v6, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda2;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    invoke-virtual v3, v6, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
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
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onBackClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onSubtitleToggleClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private static final _init_$lambda$2(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v0, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onMinimizeClick Lkotlin/jvm/functions/Function0;
    if-eqz v0, +005h
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final allowShadowOverflow()void
    .registers 3
    # ins_size=1
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getParent()Landroid/view/ViewParent;
    move-result-object v0
    instance-of v1, v0, Landroid/view/ViewGroup;
    if-eqz v1, +005h
    check-cast v0, Landroid/view/ViewGroup;
    goto +2h
    const/4 v0, 0
    if-eqz v0, +009h
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipChildren(Z)V
    invoke-virtual v0, v1, Landroid/view/ViewGroup;->setClipToPadding(Z)V
    return-void 
.end method

.method private final applyTopButtonShadows()void
    .registers 4
    # ins_size=1
    const/4 v0, 0
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setClipChildren(Z)V
    invoke-virtual v3, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->setClipToPadding(Z)V
    const/4 v1, 2
    new-array v1, v1, [Landroid/view/View;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeft Landroid/widget/ImageView;
    aput-object v2, v1, v0
    const/4 v0, 1
    iget-object v2, v3, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    aput-object v2, v1, v0
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf([Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    check-cast v0, Ljava/lang/Iterable;
    invoke-interface v0, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v0
    invoke-interface v0, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +014h
    invoke-interface v0, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Landroid/view/View;
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/view/View;->setElevation(F)V
    invoke-virtual v1, v2, Landroid/view/View;->setTranslationZ(F)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/view/View;->setStateListAnimator(Landroid/animation/StateListAnimator;)V
    goto -17h
    return-void 
.end method

.method private final createTopButtonShadowView()com.bytedance.trae.conversation.brainstorm.widget.BrainstormActionShadowView
    .registers 8
    # ins_size=1
    new-instance v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v0, "getContext(...)"
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_title_bar_shadow I
    invoke-static v0, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->getContext()Landroid/content/Context;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_base_default I
    invoke-static v0, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowRadius I
    int-to-float v3, v0
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowDy I
    int-to-float v4, v0
    iget v0, v7, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingTop I
    int-to-float v5, v0
    move-object v0, v6
    invoke-virtual/range v0 ... v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->configure(I I F F F)V
    return-object v6
.end method

.method private static final setMinimizeVisible$lambda$6(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTopButtonShadows()V
    return-void 
.end method

.method private static final setMode$lambda$7(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar)void
    .registers 1
    # ins_size=1
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTopButtonShadows()V
    return-void 
.end method

.method private final updateTopButtonShadow(com.bytedance.trae.conversation.brainstorm.widget.BrainstormActionShadowView  android.view.View)void
    .registers 7
    # ins_size=3
    invoke-virtual v6, Landroid/view/View;->getVisibility()I
    move-result v0
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setVisibility(I)V
    invoke-virtual v6, Landroid/view/View;->getVisibility()I
    move-result v0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    if-eqz v0, +043h
    invoke-virtual v6, Landroid/view/View;->getWidth()I
    move-result v0
    if-lez v0, +03dh
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v0
    if-gtz v0, +003h
    goto +35h
    invoke-virtual v6, Landroid/view/View;->getWidth()I
    move-result v0
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v1
    invoke-virtual v5, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->setContentSize(I I)V
    invoke-virtual v6, Landroid/view/View;->getWidth()I
    move-result v0
    iget v1, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowRadius I
    mul-int/lit8 v1, v1, 2
    add-int/2addr v0, v1
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v1
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingTop I
    add-int/2addr v1, v2
    iget v2, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingBottom I
    add-int/2addr v1, v2
    invoke-virtual v6, Landroid/view/View;->getLeft()I
    move-result v2
    iget v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowRadius I
    sub-int/2addr v2, v3
    invoke-virtual v6, Landroid/view/View;->getTop()I
    move-result v6
    iget v3, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->shadowPaddingTop I
    sub-int/2addr v6, v3
    add-int/2addr v0, v2
    add-int/2addr v1, v6
    invoke-virtual v5, v2, v6, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->layout(I I I I)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;->invalidate()V
    return-void 
.end method

.method private final updateTopButtonShadows()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeftShadow Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeft Landroid/widget/ImageView;
    check-cast v1, Landroid/view/View;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTopButtonShadow(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView; Landroid/view/View;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPillShadow Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView;
    iget-object v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    check-cast v1, Landroid/view/View;
    invoke-direct v2, v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTopButtonShadow(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormActionShadowView; Landroid/view/View;)V
    return-void 
.end method

.method public final getOnBackClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onBackClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnMinimizeClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onMinimizeClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method public final getOnSubtitleToggleClick()kotlin.jvm.functions.Function0
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onSubtitleToggleClick Lkotlin/jvm/functions/Function0;
    return-object v0
.end method

.method protected onAttachedToWindow()void
    .registers 1
    # ins_size=1
    invoke-super v0, Landroidx/constraintlayout/widget/ConstraintLayout;->onAttachedToWindow()V
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->allowShadowOverflow()V
    return-void 
.end method

.method protected onLayout(boolean  int  int  int  int)void
    .registers 6
    # ins_size=6
    invoke-super/range v0 ... v5, Landroidx/constraintlayout/widget/ConstraintLayout;->onLayout(Z I I I I)V
    invoke-direct v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->updateTopButtonShadows()V
    return-void 
.end method

.method public final setMinimizeVisible(boolean)void
    .registers 6
    # ins_size=2
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnMinimize Landroid/widget/ImageView;
    check-cast v0, Landroid/view/View;
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v5, +004h
    move v3, v2
    goto +2h
    move v3, v1
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->spacePillGap Landroid/widget/Space;
    check-cast v0, Landroid/view/View;
    if-eqz v5, +003h
    move v1, v2
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    if-eqz v5, +005h
    iget v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->defaultActionPillWidth I
    goto +bh
    invoke-virtual v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_brainstorm_header_action_button_size I
    invoke-virtual v5, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->width I
    if-eq v1, v5, +009h
    iput v5, v0, Landroid/view/ViewGroup$LayoutParams;->width I
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    invoke-virtual v5, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    invoke-virtual v5, v2, v2, v2, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda4;
    invoke-direct v5, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final setMode(com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar$TopBarMode)void
    .registers 3
    # ins_size=2
    const-string v0, "mode"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$TopBarMode;->ordinal()I
    move-result v2
    aget v2, v0, v2
    const/4 v0, 1
    if-eq v2, v0, +01eh
    const/4 v0, 2
    if-ne v2, v0, +015h
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeft Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_close I
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->timerContainer Landroid/widget/LinearLayout;
    const/4 v0, 0
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    goto +1bh
    new-instance v2, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v2, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnLeft Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_close I
    invoke-virtual v2, v0, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->timerContainer Landroid/widget/LinearLayout;
    const/4 v0, 4
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->actionPill Landroid/widget/LinearLayout;
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/widget/LinearLayout;->setVisibility(I)V
    new-instance v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda3;
    invoke-direct v2, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;)V
    invoke-virtual v1, v2, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->post(Ljava/lang/Runnable;)Z
    return-void 
.end method

.method public final setOnBackClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onBackClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnMinimizeClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onMinimizeClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setOnSubtitleToggleClick(kotlin.jvm.functions.Function0)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->onSubtitleToggleClick Lkotlin/jvm/functions/Function0;
    return-void 
.end method

.method public final setSubtitleToggleActive(boolean)void
    .registers 3
    # ins_size=2
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->btnSubtitleToggle Landroid/widget/ImageView;
    if-eqz v2, +005h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_subtitle_on I
    goto +3h
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_brainstorm_subtitle_off I
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setImageResource(I)V
    return-void 
.end method

.method public final updateTimeoutState(com.bytedance.trae.conversation.brainstorm.model.TimeoutState  int)void
    .registers 8
    # ins_size=3
    const-string/jumbo v0, state
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->currentTimeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    const/4 v1, 0
    const/4 v2, 1
    if-eq v0, v6, +046h
    iput-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->currentTimeoutState Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar$WhenMappings;->$EnumSwitchMapping$1 [I
    invoke-virtual v6, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->ordinal()I
    move-result v3
    aget v0, v0, v3
    if-eq v0, v2, +024h
    const/4 v3, 2
    if-eq v0, v3, +00ch
    const/4 v3, 3
    if-ne v0, v3, +003h
    goto +7h
    new-instance v6, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v6, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v6
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimer Landroid/widget/TextView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimeoutChip Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +17h
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimer Landroid/widget/TextView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimeoutChip Landroid/widget/TextView;
    const/16 v3, 8
    invoke-virtual v0, v3, Landroid/widget/TextView;->setVisibility(I)V
    sget-object v0, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Warning Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v6, v0, +03ah
    if-lez v7, +038h
    div-int/lit8 v6, v7, 60
    rem-int/lit8 v7, v7, 60
    if-lez v6, +015h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_timeout_minutes I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v1
    invoke-virtual v7, v0, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    goto +13h
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_timeout_seconds I
    new-array v2, v2, [Ljava/lang/Object;
    invoke-static v7, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v7
    aput-object v7, v2, v1
    invoke-virtual v6, v0, v2, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    iget-object v7, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimeoutChip Landroid/widget/TextView;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v7, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    goto +16h
    sget-object v7, Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;->Expired Lcom/bytedance/trae/conversation/brainstorm/model/TimeoutState;
    if-ne v6, v7, +013h
    iget-object v6, v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimeoutChip Landroid/widget/TextView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->getContext()Landroid/content/Context;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_brainstorm_timeout_ending I
    invoke-virtual v7, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v6, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final updateTimer(long)void
    .registers 7
    # ins_size=3
    const/16 v0, 1000
    int-to-long v0, v0
    div-long/2addr v5, v0
    long-to-int v5, v5
    div-int/lit8 v6, v5, 60
    rem-int/lit8 v5, v5, 60
    iget-object v0, v4, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;->tvTimer Landroid/widget/TextView;
    sget-object v1, Lkotlin/jvm/internal/StringCompanionObject;->INSTANCE Lkotlin/jvm/internal/StringCompanionObject;
    const/4 v1, 2
    new-array v2, v1, [Ljava/lang/Object;
    const/4 v3, 0
    invoke-static v6, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v6
    aput-object v6, v2, v3
    const/4 v6, 1
    invoke-static v5, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    aput-object v5, v2, v6
    invoke-static v2, v1, Ljava/util/Arrays;->copyOf([Ljava/lang/Object; I)[Ljava/lang/Object;
    move-result-object v5
    const-string v6, "%02d:%02d"
    invoke-static v6, v5, Ljava/lang/String;->format(Ljava/lang/String; [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v5
    const-string v6, "format(...)"
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v5, Ljava/lang/CharSequence;
    invoke-virtual v0, v5, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
