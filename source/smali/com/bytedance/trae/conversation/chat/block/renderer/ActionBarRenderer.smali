# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;
.super Ljava/lang/Object;
.source "ActionBarRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field private static final BLOCK_TAG:Ljava/lang/String;
.field public static final COPY_TAG:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;
.field public static final THUMBS_DOWN_TAG:Ljava/lang/String;
.field public static final THUMBS_UP_TAG:Ljava/lang/String;
.field private static final drawableCache:Ljava/util/HashMap;


.method public static synthetic $r8$lambda$E5RxkMHo8hB2o1uF54UHzM5k7T8(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->render$lambda$15(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$P4pCgD552LutZFbMVhK19X_xxw0(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->render$lambda$12(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$SPj7OJHEcke5M0S8fXLc9o8U0VY(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->render$lambda$13(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$VdLc5iynhs0R-KXurn5RH8zYdBI(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->render$lambda$14(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;
    new-instance v0, Ljava/util/HashMap;
    invoke-direct v0, Ljava/util/HashMap;-><init>()V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->drawableCache Ljava/util/HashMap;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public static final synthetic access$getDrawableCache$cp()java.util.HashMap
    .registers 1
    # ins_size=0
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->drawableCache Ljava/util/HashMap;
    return-object v0
.end method

.method private final createIconButton(android.content.Context  int  int  int  boolean  int)android.widget.FrameLayout
    .registers 8
    # ins_size=7
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v2, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v6, Landroid/widget/FrameLayout;->setEnabled(Z)V
    invoke-virtual v0, v6, Landroid/widget/FrameLayout;->setClickable(Z)V
    invoke-virtual v0, v6, Landroid/widget/FrameLayout;->setFocusable(Z)V
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v6, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v2, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;
    invoke-static v6, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion;->access$getCachedDrawable(Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$Companion; Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v2
    invoke-virtual v4, v2, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    sget-object v2, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v4, v2, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-direct v1, v4, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->setIconTint(Landroid/widget/ImageView; I)V
    new-instance v2, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v2, v5, v5, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    const/16 v3, 17
    iput v3, v2, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    check-cast v4, Landroid/view/View;
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, v2, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v0
.end method

.method static synthetic createIconButton$default(com.bytedance.trae.conversation.chat.block.renderer.ActionBarRenderer  android.content.Context  int  int  int  boolean  int  int  java.lang.Object)android.widget.FrameLayout
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 16
    if-eqz v15, +003h
    const/4 v12, 1
    move v5, v12
    and-int/lit8 v12, v14, 32
    if-eqz v12, +008h
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v8, v12, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v13
    move v6, v13
    move-object v0, v7
    move-object v1, v8
    move v2, v9
    move v3, v10
    move v4, v11
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->createIconButton(Landroid/content/Context; I I I Z I)Landroid/widget/FrameLayout;
    move-result-object v7
    return-object v7
.end method

.method private final dimenPx(android.content.Context  int)int
    .registers 3
    # ins_size=3
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    return v1
.end method

.method private static final render$lambda$12(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getOnActionClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final render$lambda$13(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getOnActionClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final render$lambda$14(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getOnActionClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->COPY Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final render$lambda$15(com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getOnActionClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +007h
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;->MORE Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionType;
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private final setIconTint(android.widget.ImageView  int)void
    .registers 3
    # ins_size=3
    invoke-static v2, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v2
    invoke-static v1, v2, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar)android.view.View
    .registers 31
    # ins_size=3
    move-object/from16 v9, v28
    move-object/from16 v10, v29
    move-object/from16 v11, v30
    const-string v0, "context"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v29, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v1
    if-eqz v1, +008h
    const/16 v1, 30
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v1, v1
    goto +7h
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_36 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v1
    move v13, v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v1
    if-eqz v1, +008h
    const/16 v1, 18
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v1, v1
    goto +7h
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_20 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v1
    move v14, v1
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v1
    if-eqz v1, +005h
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    goto +3h
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_2 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v1
    move v15, v1
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_4 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v7
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-direct v9, v10, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v1
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_action_bar_divider_width I
    invoke-direct v9, v10, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v2
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v10, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_brand I
    invoke-static v10, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v16
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowInterjectedStatus()Z
    move-result v3
    const/16 v17, 0
    if-eqz v3, +00bh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_append_interjected_status I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    move-object/from16 v18, v3
    goto +10h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowManualStopStatus()Z
    move-result v3
    if-eqz v3, +009h
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_manual_stop_status I
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v3
    goto -fh
    move-object/from16 v18, v17
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v4, 1
    invoke-virtual v5, v4, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v4, -1
    move/from16 v20, v15
    const/4 v15, -2
    invoke-direct v3, v4, v15, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v3, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v15, 0
    invoke-virtual v3, v15, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v15, 16
    invoke-virtual v3, v15, Landroid/widget/LinearLayout;->setGravity(I)V
    move-object v15, v3
    check-cast v15, Landroid/view/View;
    move/from16 v22, v1
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v4, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowFeedback()Z
    move-result v4
    if-eqz v4, +00eh
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v4
    if-eqz v4, +008h
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v4, v0
    float-to-int v0, v4
    goto +bh
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowFeedback()Z
    move-result v0
    if-eqz v0, +005h
    move/from16 v0, v22
    goto +2h
    move v0, v7
    iput v0, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v5, v15, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v18, +0e4h
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v10, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 16
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v0, v1, v1, v8, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    move-object v1, v0
    check-cast v1, Landroid/view/View;
    new-instance v15, Landroid/widget/LinearLayout$LayoutParams;
    move-object/from16 v22, v5
    const/4 v5, -2
    invoke-direct v15, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v4, v15, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v15, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v1, v15, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v10, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    move-object v4, v1
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_20 I
    invoke-direct v9, v10, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v15
    sget v11, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_20 I
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v11
    invoke-direct v5, v15, v11, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v11, 16
    iput v11, v5, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v4, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v10, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_minus_circle I
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v5, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    invoke-direct v9, v4, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->setIconTint(Landroid/widget/ImageView; I)V
    check-cast v4, Landroid/view/View;
    new-instance v5, Landroid/widget/FrameLayout$LayoutParams;
    sget v11, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_18 I
    invoke-direct v9, v10, v11, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v11
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_18 I
    invoke-direct v9, v10, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v15
    invoke-direct v5, v11, v15, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    const/16 v11, 17
    iput v11, v5, Landroid/widget/FrameLayout$LayoutParams;->gravity I
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v5, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-virtual/range v18, Ljava/lang/Integer;->intValue()I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setText(I)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v10, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v4, 0
    invoke-virtual v1, v4, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_xs_font_size_sp I
    invoke-virtual v12, v5, Landroid/content/res/Resources;->getDimension(I)F
    move-result v5
    invoke-virtual v1, v4, v5, Landroid/widget/TextView;->setTextSize(I F)V
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_xs_line_height_dp I
    invoke-virtual v12, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-static v1, v4, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    check-cast v1, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v5, 16
    iput v5, v4, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    invoke-virtual v4, v8, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v10, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v10, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-direct v9, v10, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->dimenPx(Landroid/content/Context; I)I
    move-result v4
    invoke-direct v1, v2, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 16
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->gravity I
    invoke-virtual v1, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto +3h
    move-object/from16 v22, v5
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowFeedback()Z
    move-result v0
    const-string v11, "null cannot be cast to non-null type android.widget.ImageView"
    if-eqz v0, +0c8h
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getFeedbackState()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_UP Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-ne v0, v1, +004h
    const/4 v15, 1
    goto +2h
    const/4 v15, 0
    if-eqz v15, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_up_filled I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_up I
    move v2, v0
    const/4 v5, 0
    const/16 v21, 0
    const/16 v23, 48
    const/16 v24, 0
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    move-object v4, v3
    move v3, v13
    move-object/from16 v25, v4
    const/16 v19, 1
    move v4, v14
    move-object/from16 v26, v22
    move/from16 v22, v6
    move/from16 v6, v21
    move/from16 v21, v7
    move/from16 v7, v23
    move/from16 v27, v8
    move-object/from16 v8, v24
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->createIconButton$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer; Landroid/content/Context; I I I Z I I Ljava/lang/Object;)Landroid/widget/FrameLayout;
    move-result-object v0
    const-string/jumbo v1, thumbs_up_button
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setTag(Ljava/lang/Object;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    if-eqz v15, +005h
    move/from16 v6, v16
    goto +3h
    move/from16 v6, v22
    invoke-direct v9, v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->setIconTint(Landroid/widget/ImageView; I)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda0;
    move-object/from16 v15, v30
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v0, Landroid/view/View;
    move-object/from16 v8, v25
    invoke-virtual v8, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getFeedbackState()Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;->THUMBS_DOWN Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$FeedbackState;
    if-ne v0, v1, +003h
    goto +3h
    const/16 v19, 0
    if-eqz v19, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_down_filled I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_thumbs_down I
    move v2, v0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 48
    const/16 v23, 0
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    move v3, v13
    move v4, v14
    move-object/from16 v24, v12
    move-object v12, v8
    move-object/from16 v8, v23
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->createIconButton$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer; Landroid/content/Context; I I I Z I I Ljava/lang/Object;)Landroid/widget/FrameLayout;
    move-result-object v0
    const-string/jumbo v1, thumbs_down_button
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setTag(Ljava/lang/Object;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    if-eqz v19, +005h
    move/from16 v6, v16
    goto +3h
    move/from16 v6, v22
    invoke-direct v9, v2, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->setIconTint(Landroid/widget/ImageView; I)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda1;
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    instance-of v2, v1, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v2, +005h
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;
    goto +3h
    move-object/from16 v1, v17
    move/from16 v8, v20
    if-eqz v1, +005h
    invoke-virtual v1, v8, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +10h
    move-object/from16 v15, v30
    move/from16 v21, v7
    move/from16 v27, v8
    move-object/from16 v24, v12
    move/from16 v8, v20
    move-object/from16 v26, v22
    move-object v12, v3
    move/from16 v22, v6
    sget v2, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_copy I
    const/4 v5, 0
    const/16 v7, 16
    const/16 v16, 0
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    move v3, v13
    move v4, v14
    move/from16 v6, v22
    move v9, v8
    move-object/from16 v8, v16
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->createIconButton$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer; Landroid/content/Context; I I I Z I I Ljava/lang/Object;)Landroid/widget/FrameLayout;
    move-result-object v0
    const-string v1, "copy_button"
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setTag(Ljava/lang/Object;)V
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_copy I
    invoke-virtual v10, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v1
    check-cast v1, Ljava/lang/CharSequence;
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setContentDescription(Ljava/lang/CharSequence;)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda2;
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowFeedback()Z
    move-result v1
    if-eqz v1, +004h
    move v7, v9
    goto +7h
    if-eqz v18, +005h
    move/from16 v7, v21
    goto +2h
    const/4 v7, 0
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    instance-of v2, v1, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v2, +005h
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;
    goto +3h
    move-object/from16 v1, v17
    if-eqz v1, +005h
    invoke-virtual v1, v7, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v0
    const/high16 v8, 1065353216
    if-eqz v0, +014h
    new-instance v0, Landroid/widget/Space;
    invoke-direct v0, v10, Landroid/widget/Space;-><init>(Landroid/content/Context;)V
    check-cast v0, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, 0
    invoke-direct v1, v2, v2, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v0
    if-eqz v0, +005h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_more I
    goto +3h
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_more I
    move v2, v0
    const/4 v5, 0
    const/4 v6, 0
    const/16 v7, 48
    const/16 v16, 0
    move-object/from16 v0, v28
    move-object/from16 v1, v29
    move v3, v13
    move v4, v14
    move v13, v8
    move-object/from16 v8, v16
    invoke-static/range v0 ... v8, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->createIconButton$default(Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer; Landroid/content/Context; I I I Z I I Ljava/lang/Object;)Landroid/widget/FrameLayout;
    move-result-object v0
    const-string v1, "more_button"
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setTag(Ljava/lang/Object;)V
    const-string v1, "null cannot be cast to non-null type android.widget.FrameLayout"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->getChildAt(I)Landroid/view/View;
    move-result-object v2
    invoke-static v2, v11, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Landroid/widget/ImageView;
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v1
    if-eqz v1, +00dh
    const/16 v1, 53
    const/16 v3, 58
    const/16 v4, 49
    invoke-static v4, v1, v3, Landroid/graphics/Color;->rgb(I I I)I
    move-result v6
    goto +3h
    move/from16 v6, v22
    invoke-virtual v2, v6, Landroid/widget/ImageView;->setColorFilter(I)V
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda3;
    invoke-direct v1, v15, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)V
    invoke-virtual v0, v1, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v0, Landroid/widget/FrameLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v1
    instance-of v2, v1, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v2, +006h
    move-object/from16 v17, v1
    check-cast v17, Landroid/widget/LinearLayout$LayoutParams;
    move-object/from16 v1, v17
    if-eqz v1, +005h
    invoke-virtual v1, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/View;
    invoke-virtual v12, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v0
    if-nez v0, +014h
    new-instance v0, Landroid/widget/Space;
    invoke-direct v0, v10, Landroid/widget/Space;-><init>(Landroid/content/Context;)V
    check-cast v0, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, 0
    invoke-direct v1, v2, v2, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->getShowFeedback()Z
    move-result v0
    if-eqz v0, +03dh
    invoke-virtual/range v30, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;->isVoiceSummaryStyle()Z
    move-result v0
    if-nez v0, +037h
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v10, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_generated_by_ai I
    invoke-virtual v0, v1, Landroid/widget/TextView;->setText(I)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v10, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/TextView;->setTextColor(I)V
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_font_size_sp I
    move-object/from16 v2, v24
    invoke-virtual v2, v1, Landroid/content/res/Resources;->getDimension(I)F
    move-result v1
    const/4 v2, 0
    invoke-virtual v0, v2, v1, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v0, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -2
    invoke-direct v1, v2, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    move/from16 v2, v27
    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v2, v26
    invoke-virtual v2, v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto +3h
    move-object/from16 v2, v26
    move-object v5, v2
    check-cast v5, Landroid/view/View;
    return-object v5
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$ActionBar)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer$DefaultImpls;->update(Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock;)V
    return-void 
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/ActionBarRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$ActionBar;)V
    return-void 
.end method
