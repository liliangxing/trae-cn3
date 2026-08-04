# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;
.super Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
.source "HistorySubtitleAdapter.kt"

.field private static final BADGE_LOADING_DURATION_MS:J
.field private static final BADGE_LOADING_STEPS:I
.field public static final Companion:Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$Companion;
.field private final badgeContainer:Landroid/widget/LinearLayout;
.field private final badgeIcon:Landroid/widget/ImageView;
.field private final badgeLoading:Landroid/widget/ImageView;
.field private final badgeLoadingAnim$delegate:Lkotlin/Lazy;
.field private final badgeText:Landroid/widget/TextView;
.field private final container:Landroid/widget/LinearLayout;
.field private final textView:Landroid/widget/TextView;


.method public static synthetic $r8$lambda$wSEWG8Lw2PIkOtJDcRc9rhEWMXU()android.view.animation.RotateAnimation
    .registers 1
    # ins_size=0
    invoke-static Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoadingAnim_delegate$lambda$1()Landroid/view/animation/RotateAnimation;
    move-result-object v0
    return-object v0
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->Companion Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$Companion;
    return-void 
.end method

.method public constructor <init>(android.widget.LinearLayout)void
    .registers 4
    # ins_size=2
    const-string v0, "container"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    move-object v0, v3
    check-cast v0, Landroid/view/View;
    invoke-direct v2, v0, Landroidx/recyclerview/widget/RecyclerView$ViewHolder;-><init>(Landroid/view/View;)V
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->container Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle_content I
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    const-string v1, "findViewById(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/TextView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtask_badge_container I
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/LinearLayout;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeContainer Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_subtask_loading I
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoading Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_subtask_status_icon I
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v0
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v0, Landroid/widget/ImageView;
    iput-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeIcon Landroid/widget/ImageView;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtask_status_text I
    invoke-virtual v3, v0, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Landroid/widget/TextView;
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeText Landroid/widget/TextView;
    new-instance v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$$ExternalSyntheticLambda0;
    invoke-direct v3, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$$ExternalSyntheticLambda0;-><init>()V
    invoke-static v3, Lkotlin/LazyKt;->lazy(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    move-result-object v3
    iput-object v3, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoadingAnim$delegate Lkotlin/Lazy;
    return-void 
.end method

.method private static final badgeLoadingAnim_delegate$lambda$1()android.view.animation.RotateAnimation
    .registers 8
    # ins_size=0
    new-instance v7, Landroid/view/animation/RotateAnimation;
    const/4 v1, 0
    const/high16 v2, 1135869952
    const/4 v3, 1
    const/high16 v4, 1056964608
    const/4 v5, 1
    const/high16 v6, 1056964608
    move-object v0, v7
    invoke-direct/range v0 ... v6, Landroid/view/animation/RotateAnimation;-><init>(F F I F I F)V
    const-wide/16 v0, 1000
    invoke-virtual v7, v0, v1, Landroid/view/animation/RotateAnimation;->setDuration(J)V
    const/4 v0, -1
    invoke-virtual v7, v0, Landroid/view/animation/RotateAnimation;->setRepeatCount(I)V
    new-instance v0, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;
    const/16 v1, 8
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/brainstorm/widget/StepInterpolator;-><init>(I)V
    check-cast v0, Landroid/view/animation/Interpolator;
    invoke-virtual v7, v0, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V
    return-object v7
.end method

.method private final getBadgeLoadingAnim()android.view.animation.RotateAnimation
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoadingAnim$delegate Lkotlin/Lazy;
    invoke-interface v0, Lkotlin/Lazy;->getValue()Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/animation/RotateAnimation;
    return-object v0
.end method

.method private final startBadgeLoading()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoading Landroid/widget/ImageView;
    invoke-virtual v0, Landroid/widget/ImageView;->getAnimation()Landroid/view/animation/Animation;
    move-result-object v0
    if-nez v0, +00dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoading Landroid/widget/ImageView;
    invoke-direct v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->getBadgeLoadingAnim()Landroid/view/animation/RotateAnimation;
    move-result-object v1
    check-cast v1, Landroid/view/animation/Animation;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V
    return-void 
.end method

.method private final stopBadgeLoading()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoading Landroid/widget/ImageView;
    invoke-virtual v0, Landroid/widget/ImageView;->getAnimation()Landroid/view/animation/Animation;
    move-result-object v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeLoading Landroid/widget/ImageView;
    invoke-virtual v0, Landroid/widget/ImageView;->clearAnimation()V
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.brainstorm.adapter.HistorySubtitleAdapter$SubtitleItem)void
    .registers 9
    # ins_size=2
    const-string v0, "item"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getContent()Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v0, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getRole()Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;
    move-result-object v1
    sget-object v2, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v1, Lcom/bytedance/trae/conversation/brainstorm/model/MessageRole;->ordinal()I
    move-result v1
    aget v1, v2, v1
    const/4 v2, 1
    const/16 v3, 24
    const/4 v4, 0
    const/4 v5, 0
    if-eq v1, v2, +044h
    const/4 v2, 2
    if-ne v1, v2, +03bh
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->container Landroid/widget/LinearLayout;
    const v2, 8388611
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v2, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, v4, v5, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface; I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, v5, v5, v5, v5, Landroid/widget/TextView;->setPadding(I I I I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    const/16 v2, 280
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxWidth(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    int-to-float v2, v3
    mul-float/2addr v2, v0
    float-to-int v0, v2
    invoke-static v1, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    goto +4bh
    new-instance v8, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v8, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v8
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->container Landroid/widget/LinearLayout;
    const v2, 8388613
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, Landroid/widget/TextView;->getContext()Landroid/content/Context;
    move-result-object v2
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v2, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v1, v4, v5, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface; I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_voice_history_user_bubble I
    invoke-virtual v1, v2, Landroid/widget/TextView;->setBackgroundResource(I)V
    const/16 v1, 16
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v1, v1
    const/16 v2, 12
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    iget-object v4, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    invoke-virtual v4, v1, v2, v1, v2, Landroid/widget/TextView;->setPadding(I I I I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    const/16 v2, 302
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v2, v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setMaxWidth(I)V
    iget-object v1, v7, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    int-to-float v2, v3
    mul-float/2addr v2, v0
    float-to-int v0, v2
    invoke-static v1, v0, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$SubtitleItem;->getSubTaskBadge()Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;
    move-result-object v8
    invoke-virtual v7, v8, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->updateSubTaskBadge(Lcom/bytedance/trae/conversation/voice/subtask/SubTaskUiState;)V
    return-void 
.end method

.method public final updateSubTaskBadge(com.bytedance.trae.conversation.voice.subtask.SubTaskUiState)void
    .registers 3
    # ins_size=2
    iget-object v2, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->badgeContainer Landroid/widget/LinearLayout;
    check-cast v2, Landroid/view/View;
    const/16 v0, 8
    invoke-virtual v2, v0, Landroid/view/View;->setVisibility(I)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->stopBadgeLoading()V
    return-void 
.end method

.method public final updateText(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, text
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/brainstorm/adapter/HistorySubtitleAdapter$MessageViewHolder;->textView Landroid/widget/TextView;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
