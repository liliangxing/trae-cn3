# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;
.super Ljava/lang/Object;
.source "AvatarRenderer.kt"

.implements Lcom/bytedance/trae/conversation/chat/block/renderer/IBlockRenderer;

.field public static final BLOCK_TAG:Ljava/lang/String;
.field private static final Companion:Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$Companion;
.field public static final WORKSPACE_HEADER_NAME_LETTER_SPACING_EM:F
.field private currentPopup:Landroid/widget/PopupWindow;


.method public static synthetic $r8$lambda$I8uDfBzAl6spddmPIu51RbTV0GI(android.widget.PopupWindow)void
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->showFastTooltip$lambda$11(Landroid/widget/PopupWindow;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$MQOnvgGoAkL7c1Bb9cFl1tIUStk(android.view.View  java.lang.Runnable  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$showFastTooltip$attachListener$1  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.widget.PopupWindow)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->showFastTooltip$lambda$12(Landroid/view/View; Ljava/lang/Runnable; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/widget/PopupWindow;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$X2mvjr042Tqamuj1eHBwDkl14rg(android.view.View  android.widget.PopupWindow  int[]  android.view.View  com.bytedance.trae.conversation.widget.BubbleDrawable  float)void
    .registers 6
    # ins_size=6
    invoke-static/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->showFastTooltip$lambda$10(Landroid/view/View; Landroid/widget/PopupWindow; [I Landroid/view/View; Lcom/bytedance/trae/conversation/widget/BubbleDrawable; F)V
    return-void 
.end method

.method public static synthetic $r8$lambda$XXHGHxeFEA1P9t9JXVF_Ii1IcAk(android.view.GestureDetector  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->setupDoubleTapCopy$lambda$13(Landroid/view/GestureDetector; Landroid/view/View; Landroid/view/MotionEvent;)Z
    move-result v0
    return v0
.end method

.method public static synthetic $r8$lambda$ko11uVHcLK4eQ2BNyV6HKb33Oik(com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.content.Context  android.widget.ImageView  android.view.View)void
    .registers 4
    # ins_size=4
    invoke-static v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->render$lambda$6(Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/content/Context; Landroid/widget/ImageView; Landroid/view/View;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->Companion Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method private final applyNameStyle(android.widget.TextView  android.content.Context)void
    .registers 5
    # ins_size=3
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-virtual v4, v1, Landroid/content/Context;->getColor(I)I
    move-result v4
    invoke-virtual v3, v4, Landroid/widget/TextView;->setTextColor(I)V
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_font_size_sp I
    invoke-virtual v0, v4, Landroid/content/res/Resources;->getDimension(I)F
    move-result v4
    const/4 v1, 0
    invoke-virtual v3, v1, v4, Landroid/widget/TextView;->setTextSize(I F)V
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_body_body_base_line_height_dp I
    invoke-virtual v0, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-static v3, v4, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    const v4, -1127271012
    invoke-virtual v3, v4, Landroid/widget/TextView;->setLetterSpacing(F)V
    const-string/jumbo v4, sans-serif
    invoke-static v4, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v3, v1, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    return-void 
.end method

.method private final getAvatarIconSize(android.content.res.Resources)int
    .registers 3
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_18 I
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    return v2
.end method

.method private final getAvatarNameStartMargin(android.content.res.Resources)int
    .registers 3
    # ins_size=2
    sget v0, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_4 I
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    return v2
.end method

.method private static final render$lambda$6(com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.content.Context  android.widget.ImageView  android.view.View)void
    .registers 4
    # ins_size=4
    sget-object v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v3
    if-eqz v3, +003h
    return-void 
    check-cast v2, Landroid/view/View;
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->showFastTooltip(Landroid/content/Context; Landroid/view/View;)V
    return-void 
.end method

.method private final setupDoubleTapCopy(android.content.Context  android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar)void
    .registers 6
    # ins_size=4
    new-instance v0, Landroid/view/GestureDetector;
    new-instance v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;
    invoke-direct v1, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$setupDoubleTapCopy$gestureDetector$1;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;)V
    check-cast v1, Landroid/view/GestureDetector$OnGestureListener;
    invoke-direct v0, v3, v1, Landroid/view/GestureDetector;-><init>(Landroid/content/Context; Landroid/view/GestureDetector$OnGestureListener;)V
    const/4 v3, 1
    invoke-virtual v4, v3, Landroid/view/View;->setClickable(Z)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda0;
    invoke-direct v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda0;-><init>(Landroid/view/GestureDetector;)V
    invoke-virtual v4, v3, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V
    return-void 
.end method

.method private static final setupDoubleTapCopy$lambda$13(android.view.GestureDetector  android.view.View  android.view.MotionEvent)boolean
    .registers 3
    # ins_size=3
    invoke-virtual v0, v2, Landroid/view/GestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z
    const/4 v0, 1
    return v0
.end method

.method private final showFastTooltip(android.content.Context  android.view.View)void
    .registers 19
    # ins_size=3
    move-object/from16 v7, v16
    move-object/from16 v8, v18
    invoke-virtual/range v18, Landroid/view/View;->isAttachedToWindow()Z
    move-result v0
    if-eqz v0, +0f8h
    invoke-virtual/range v18, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;
    move-result-object v0
    if-nez v0, +004h
    goto/16 +0f0h
    iget-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->currentPopup Landroid/widget/PopupWindow;
    if-eqz v0, +00bh
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v1
    if-eqz v1, +005h
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    const/4 v0, 0
    iput-object v0, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->currentPopup Landroid/widget/PopupWindow;
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v6, v1, Landroid/util/DisplayMetrics;->density F
    invoke-static/range v17, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$layout;->trae_avatar_fast_tooltip I
    invoke-virtual v1, v2, v0, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup;)Landroid/view/View;
    move-result-object v15
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_tooltip_text I
    invoke-virtual v15, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/TextView;
    const/4 v2, 0
    if-eqz v1, +01ah
    sget-object v3, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual/range v17, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    const-string v5, "getResources(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v5, Lcom/bytedance/trae/multilanguage/R$string;->imkit_fast_pass_used I
    new-array v9, v2, [Ljava/lang/Object;
    invoke-virtual v3, v4, v5, v9, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v1, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v5, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;
    move-object/from16 v1, v17
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;-><init>(Landroid/content/Context;)V
    const/high16 v1, 1094713344
    invoke-virtual v5, v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setCornerRadius(F F)V
    const/high16 v1, 1101004800
    const/high16 v3, 1088421888
    invoke-virtual v5, v1, v3, v6, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setArrowSize(F F F)V
    const/high16 v10, 1092616192
    const/4 v11, 0
    const/high16 v12, 1082130432
    const/16 v1, 38
    invoke-static v1, v2, v2, v2, Landroid/graphics/Color;->argb(I I I I)I
    move-result v13
    move-object v9, v5
    move v14, v6
    invoke-virtual/range v9 ... v14, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setShadow(F F F I F)V
    move-object v1, v5
    check-cast v1, Landroid/graphics/drawable/Drawable;
    invoke-virtual v15, v1, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/4 v1, 1
    invoke-virtual v15, v1, v0, Landroid/view/View;->setLayerType(I Landroid/graphics/Paint;)V
    invoke-static v2, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v0
    invoke-static v2, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-virtual v15, v0, v3, Landroid/view/View;->measure(I I)V
    invoke-virtual v15, Landroid/view/View;->getMeasuredWidth()I
    move-result v0
    invoke-virtual v15, Landroid/view/View;->getMeasuredHeight()I
    move-result v3
    new-instance v9, Landroid/widget/PopupWindow;
    const/4 v4, -2
    invoke-direct v9, v15, v4, v4, v1, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    invoke-virtual v9, v1, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v4, v2, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v9, v4, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/4 v4, 4
    invoke-virtual v15, v4, Landroid/view/View;->setVisibility(I)V
    const/4 v10, 2
    new-array v11, v10, [I
    invoke-virtual v8, v11, Landroid/view/View;->getLocationOnScreen([I)V
    aget v12, v11, v2
    invoke-virtual/range v18, Landroid/view/View;->getWidth()I
    move-result v13
    div-int/2addr v13, v10
    add-int/2addr v12, v13
    div-int/2addr v0, v10
    sub-int/2addr v12, v0
    aget v0, v11, v1
    sub-int/2addr v0, v3
    int-to-float v1, v4
    mul-float/2addr v1, v6
    float-to-int v1, v1
    sub-int/2addr v0, v1
    invoke-virtual v9, v8, v2, v12, v0, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    iput-object v9, v7, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->currentPopup Landroid/widget/PopupWindow;
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;
    move-object v0, v10
    move-object v1, v15
    move-object v2, v9
    move-object v3, v11
    move-object/from16 v4, v18
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda2;-><init>(Landroid/view/View; Landroid/widget/PopupWindow; [I Landroid/view/View; Lcom/bytedance/trae/conversation/widget/BubbleDrawable; F)V
    invoke-virtual v15, v10, Landroid/view/View;->post(Ljava/lang/Runnable;)Z
    new-instance v10, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda3;
    invoke-direct v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda3;-><init>(Landroid/widget/PopupWindow;)V
    new-instance v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;
    invoke-direct v4, v15, v10, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1;-><init>(Landroid/view/View; Ljava/lang/Runnable; Landroid/widget/PopupWindow;)V
    move-object v0, v4
    check-cast v0, Landroid/view/View$OnAttachStateChangeListener;
    invoke-virtual v8, v0, Landroid/view/View;->addOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    new-instance v11, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;
    move-object v0, v11
    move-object v1, v15
    move-object v2, v10
    move-object/from16 v3, v18
    move-object/from16 v5, v16
    move-object v6, v9
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda4;-><init>(Landroid/view/View; Ljava/lang/Runnable; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$showFastTooltip$attachListener$1; Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/widget/PopupWindow;)V
    invoke-virtual v9, v11, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    const-wide/16 v0, 2000
    invoke-virtual v15, v10, v0, v1, Landroid/view/View;->postDelayed(Ljava/lang/Runnable; J)Z
    nop 
    return-void 
    :try_start_0x4
    :try_start_0x12
    :try_start_0x20
.end method

.method private static final showFastTooltip$lambda$10(android.view.View  android.widget.PopupWindow  int[]  android.view.View  com.bytedance.trae.conversation.widget.BubbleDrawable  float)void
    .registers 7
    # ins_size=6
    const/4 v0, 0
    invoke-virtual v1, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v2, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v2
    if-eqz v2, +024h
    invoke-virtual v1, Landroid/view/View;->isAttachedToWindow()Z
    move-result v2
    if-nez v2, +003h
    goto +1ch
    const/4 v2, 2
    new-array v2, v2, [I
    invoke-virtual v1, v2, Landroid/view/View;->getLocationOnScreen([I)V
    aget v1, v3, v0
    int-to-float v1, v1
    invoke-virtual v4, Landroid/view/View;->getWidth()I
    move-result v3
    int-to-float v3, v3
    const/high16 v4, 1073741824
    div-float/2addr v3, v4
    add-float/2addr v1, v3
    aget v2, v2, v0
    int-to-float v2, v2
    sub-float/2addr v1, v2
    div-float/2addr v1, v6
    invoke-virtual v5, v1, v6, Lcom/bytedance/trae/conversation/widget/BubbleDrawable;->setArrowCenterX(F F)V
    nop 
    return-void 
    :try_start_0x1
.end method

.method private static final showFastTooltip$lambda$11(android.widget.PopupWindow)void
    .registers 2
    # ins_size=1
    invoke-virtual v1, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +005h
    invoke-virtual v1, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
    :try_start_0x0
.end method

.method private static final showFastTooltip$lambda$12(android.view.View  java.lang.Runnable  android.view.View  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer$showFastTooltip$attachListener$1  com.bytedance.trae.conversation.chat.block.renderer.AvatarRenderer  android.widget.PopupWindow)void
    .registers 6
    # ins_size=6
    invoke-virtual v0, v1, Landroid/view/View;->removeCallbacks(Ljava/lang/Runnable;)Z
    check-cast v3, Landroid/view/View$OnAttachStateChangeListener;
    invoke-virtual v2, v3, Landroid/view/View;->removeOnAttachStateChangeListener(Landroid/view/View$OnAttachStateChangeListener;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->currentPopup Landroid/widget/PopupWindow;
    if-ne v0, v5, +005h
    const/4 v0, 0
    iput-object v0, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->currentPopup Landroid/widget/PopupWindow;
    return-void 
.end method

.method public render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar)android.view.View
    .registers 14
    # ins_size=3
    const-string v0, "context"
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    sget-object v0, Lcom/bytedance/trae/utils/logger/FLogger;->INSTANCE Lcom/bytedance/trae/utils/logger/FLogger;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "[AvatarRenderer] render: agentType="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getAgentType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliType="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getCliType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", agentName="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getAgentName()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "AgentBlock"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/FLogger;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v12, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v12, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v12, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 0
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v4, 16
    invoke-virtual v2, v4, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v1, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v6
    const/4 v7, -1
    invoke-direct v5, v7, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    move-object v5, v2
    check-cast v5, Landroid/view/View;
    invoke-direct v11, v12, v5, v13, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->setupDoubleTapCopy(Landroid/content/Context; Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;)V
    sget-object v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getAgentType()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getCliType()Ljava/lang/String;
    move-result-object v8
    invoke-virtual v6, v7, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->resolve(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    move-result-object v6
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->getAvatarIconSize(Landroid/content/res/Resources;)I
    move-result v7
    sget-object v8, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;->getAvatarKey()Ljava/lang/String;
    move-result-object v9
    invoke-virtual v8, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->avatarResId(Ljava/lang/String;)I
    move-result v8
    new-instance v9, Landroid/widget/ImageView;
    invoke-direct v9, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v10, Lcom/bytedance/trae/conversation/R$id;->iv_avatar_icon I
    invoke-virtual v9, v10, Landroid/widget/ImageView;->setId(I)V
    invoke-virtual v9, v8, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v8, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v9, v8, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    check-cast v9, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v9, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v12, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v8, Lcom/bytedance/trae/conversation/R$id;->tv_avatar_name I
    invoke-virtual v7, v8, Landroid/widget/TextView;->setId(I)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;->getDisplayName()Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v7, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-direct v11, v7, v12, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->applyNameStyle(Landroid/widget/TextView; Landroid/content/Context;)V
    const/4 v6, 1
    invoke-virtual v7, v6, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v8, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v7, v8, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v9, -2
    invoke-direct v8, v9, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-direct v11, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->getAvatarNameStartMargin(Landroid/content/res/Resources;)I
    move-result v1
    invoke-virtual v8, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    int-to-float v1, v4
    mul-float/2addr v1, v0
    float-to-int v1, v1
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v12, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getUserPayIdentity()I
    move-result v7
    const/16 v8, 100
    if-ne v7, v8, +008h
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_express_999 I
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setImageResource(I)V
    goto +6h
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->ic_input_bar_use_express_pass I
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->iv_avatar_fast I
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setId(I)V
    sget-object v7, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v4, v7, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    move-object v7, v4
    check-cast v7, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v1, 4
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v0, v1
    invoke-virtual v8, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v7, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v13, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass()Ljava/lang/Boolean;
    move-result-object v13
    invoke-static v6, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v13
    if-eqz v13, +00eh
    sget-object v13, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v13, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v13
    if-nez v13, +006h
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setVisibility(I)V
    goto +6h
    const/16 v13, 8
    invoke-virtual v4, v13, Landroid/widget/ImageView;->setVisibility(I)V
    new-instance v13, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;
    invoke-direct v13, v11, v12, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer; Landroid/content/Context; Landroid/widget/ImageView;)V
    invoke-virtual v4, v13, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-object v5
.end method

.method public bridge synthetic render(android.content.Context  com.bytedance.trae.conversation.chat.block.AgentContentBlock)android.view.View
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->render(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;)Landroid/view/View;
    move-result-object v1
    return-object v1
.end method

.method public update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock$Avatar)void
    .registers 10
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "block"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    instance-of v0, v8, Landroid/widget/LinearLayout;
    if-eqz v0, +0b4h
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getAgentType()Ljava/lang/String;
    move-result-object v1
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->getCliType()Ljava/lang/String;
    move-result-object v2
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->resolve(Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;
    move-result-object v0
    move-object v1, v8
    check-cast v1, Landroid/widget/LinearLayout;
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$id;->iv_avatar_icon I
    invoke-virtual v8, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/ImageView;
    const/4 v3, 0
    if-eqz v2, +02dh
    sget-object v4, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->INSTANCE Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;->getAvatarKey()Ljava/lang/String;
    move-result-object v5
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;->avatarResId(Ljava/lang/String;)I
    move-result v4
    invoke-virtual v2, v4, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->getAvatarIconSize(Landroid/content/res/Resources;)I
    move-result v4
    invoke-virtual v2, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v5
    instance-of v6, v5, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v6, +005h
    check-cast v5, Landroid/widget/LinearLayout$LayoutParams;
    goto +2h
    move-object v5, v3
    if-eqz v5, +00bh
    iput v4, v5, Landroid/widget/LinearLayout$LayoutParams;->width I
    iput v4, v5, Landroid/widget/LinearLayout$LayoutParams;->height I
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v5, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v2, Lcom/bytedance/trae/conversation/R$id;->tv_avatar_name I
    invoke-virtual v8, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +036h
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;->getDisplayName()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    move-object v0, v8
    check-cast v0, Landroid/widget/LinearLayout;
    invoke-virtual v0, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;
    move-result-object v0
    const-string v4, "getContext(...)"
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v7, v2, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->applyNameStyle(Landroid/widget/TextView; Landroid/content/Context;)V
    invoke-virtual v2, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v0
    instance-of v4, v0, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v4, +005h
    move-object v3, v0
    check-cast v3, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v3, +011h
    invoke-static v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object;)V
    invoke-direct v7, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->getAvatarNameStartMargin(Landroid/content/res/Resources;)I
    move-result v0
    invoke-virtual v3, v0, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_avatar_fast I
    invoke-virtual v8, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +023h
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;->isExpressPass()Ljava/lang/Boolean;
    move-result-object v9
    const/4 v0, 1
    invoke-static v0, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;
    move-result-object v0
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v9
    if-eqz v9, +00fh
    sget-object v9, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->INSTANCE Lcom/bytedance/trae/conversation/TocCreditsPolicy;
    invoke-virtual v9, Lcom/bytedance/trae/conversation/TocCreditsPolicy;->isEnabled()Z
    move-result v9
    if-nez v9, +007h
    const/4 v9, 0
    invoke-virtual v8, v9, Landroid/view/View;->setVisibility(I)V
    goto +6h
    const/16 v9, 8
    invoke-virtual v8, v9, Landroid/view/View;->setVisibility(I)V
    return-void 
    :try_start_0xf
.end method

.method public bridge synthetic update(android.view.View  com.bytedance.trae.conversation.chat.block.AgentContentBlock)void
    .registers 3
    # ins_size=3
    check-cast v2, Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/AvatarRenderer;->update(Landroid/view/View; Lcom/bytedance/trae/conversation/chat/block/AgentContentBlock$Avatar;)V
    return-void 
.end method
