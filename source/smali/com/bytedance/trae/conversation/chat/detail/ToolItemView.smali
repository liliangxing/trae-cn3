# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;
.super Landroid/widget/LinearLayout;
.source "ToolItemView.kt"

.field private final badgeView:Landroid/widget/TextView;
.field private final chevronView:Landroid/widget/ImageView;
.field private final contentContainer:Landroid/widget/FrameLayout;
.field private final density:F
.field private final headerRow:Landroid/widget/LinearLayout;
.field private final iconColumnWidth:I
.field private final iconEmojiView:Landroid/widget/TextView;
.field private final iconImageView:Landroid/widget/ImageView;
.field private final subtitleView:Landroid/widget/TextView;
.field private final titleView:Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
.field private final verticalLine:Landroid/view/View;


.method public static synthetic $r8$lambda$Nh0cCTFaK72yUqGCo0aZrn9jq0I(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->bind$lambda$18(Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$gCVKEZPIDwPbdRCu-3DwYH-rVq4(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->update$lambda$20(Lkotlin/jvm/functions/Function1; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context)void
    .registers 21
    # ins_size=2
    move-object/from16 v0, v19
    move-object/from16 v7, v20
    const-string v1, "context"
    invoke-static v7, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct/range v19 ... v20, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual/range v20, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v8, v1, Landroid/util/DisplayMetrics;->density F
    iput v8, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->density F
    const/16 v1, 16
    int-to-float v9, v1
    mul-float v2, v9, v8
    float-to-int v10, v2
    iput v10, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconColumnWidth I
    const/4 v11, 1
    invoke-virtual v0, v11, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->setOrientation(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -1
    const/4 v13, -2
    invoke-direct v2, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/4 v3, 4
    int-to-float v14, v3
    mul-float v3, v14, v8
    float-to-int v3, v3
    iput v3, v2, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v15, Landroid/widget/LinearLayout;
    invoke-direct v15, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v6, 0
    invoke-virtual v15, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v15, v1, Landroid/widget/LinearLayout;->setGravity(I)V
    const/16 v1, 24
    int-to-float v1, v1
    mul-float/2addr v1, v8
    float-to-int v1, v1
    invoke-virtual v15, v1, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    iput-object v15, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    move-object v1, v15
    check-cast v1, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v12, v13, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/FrameLayout;
    invoke-direct v1, v7, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    const/16 v2, 20
    int-to-float v2, v2
    mul-float/2addr v2, v8
    float-to-int v2, v2
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v10, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    mul-float v2, v9, v8
    float-to-int v2, v2
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v7, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v7, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-static v4, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    const/16 v5, 8
    invoke-virtual v3, v5, Landroid/widget/ImageView;->setVisibility(I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v12, 17
    invoke-direct v4, v2, v2, v12, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v4, 1096810496
    const/4 v13, 2
    invoke-virtual v3, v13, v4, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v3, v12, Landroid/widget/TextView;->setGravity(I)V
    invoke-virtual v3, v5, Landroid/widget/TextView;->setVisibility(I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v4, v2, v2, v12, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    const/4 v3, 0
    const/16 v16, 0
    const/16 v17, 6
    const/16 v18, 0
    move-object v1, v4
    move-object/from16 v2, v20
    move-object v12, v4
    move/from16 v4, v16
    move/from16 v5, v17
    move-object/from16 v6, v18
    invoke-direct/range v1 ... v6, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v7, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v1
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextColor(I)V
    const/high16 v1, 1098907648
    invoke-virtual v12, v13, v1, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setTextSize(I F)V
    sget v2, Landroid/os/Build$VERSION;->SDK_INT I
    const/16 v3, 22
    const/16 v4, 28
    if-lt v2, v4, +008h
    int-to-float v2, v3
    mul-float/2addr v2, v8
    float-to-int v2, v2
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setLineHeight(I)V
    const v2, -1130650141
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setLetterSpacing(F)V
    invoke-virtual v12, v11, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setMaxLines(I)V
    sget-object v5, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v12, v5, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    iput-object v12, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    move-object v5, v12
    check-cast v5, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v12, -2
    invoke-direct v6, v12, v12, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v12, 8
    int-to-float v11, v12
    mul-float v12, v11, v8
    float-to-int v12, v12
    invoke-virtual v6, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v5, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v5, Landroid/widget/TextView;
    invoke-direct v5, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v7, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v5, v6, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v5, v13, v1, Landroid/widget/TextView;->setTextSize(I F)V
    sget v1, Landroid/os/Build$VERSION;->SDK_INT I
    if-lt v1, v4, +008h
    int-to-float v1, v3
    mul-float/2addr v1, v8
    float-to-int v1, v1
    invoke-virtual v5, v1, Landroid/widget/TextView;->setLineHeight(I)V
    invoke-virtual v5, v2, Landroid/widget/TextView;->setLetterSpacing(F)V
    const/4 v1, 1
    invoke-virtual v5, v1, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v5, v1, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    const/16 v1, 8
    invoke-virtual v5, v1, Landroid/widget/TextView;->setVisibility(I)V
    iput-object v5, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    check-cast v5, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v2, 1065353216
    const/4 v3, -2
    const/4 v6, 0
    invoke-direct v1, v6, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v3, 6
    int-to-float v3, v3
    mul-float v12, v3, v8
    float-to-int v12, v12
    invoke-virtual v1, v12, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v12, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v5, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_default I
    invoke-static v7, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v1, v5, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v5, 1095761920
    invoke-virtual v1, v13, v5, Landroid/widget/TextView;->setTextSize(I F)V
    sget v5, Landroid/os/Build$VERSION;->SDK_INT I
    if-lt v5, v4, +00ah
    const/16 v4, 17
    int-to-float v4, v4
    mul-float/2addr v4, v8
    float-to-int v4, v4
    invoke-virtual v1, v4, Landroid/widget/TextView;->setLineHeight(I)V
    const v4, -1144743002
    invoke-virtual v1, v4, Landroid/widget/TextView;->setLetterSpacing(F)V
    const/4 v4, 1
    invoke-virtual v1, v4, Landroid/widget/TextView;->setMaxLines(I)V
    mul-float v5, v14, v8
    float-to-int v5, v5
    int-to-float v12, v4
    mul-float v4, v12, v8
    float-to-int v4, v4
    invoke-virtual v1, v5, v4, v5, v4, Landroid/widget/TextView;->setPadding(I I I I)V
    new-instance v4, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v4, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_status_warning_surface_l1 I
    invoke-static v7, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 50
    int-to-float v5, v5
    mul-float/2addr v5, v8
    invoke-virtual v4, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v4, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/16 v4, 8
    invoke-virtual v1, v4, Landroid/widget/TextView;->setVisibility(I)V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    mul-float/2addr v3, v8
    float-to-int v3, v3
    invoke-virtual v4, v3, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v3, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v1, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    mul-float/2addr v9, v8
    float-to-int v1, v9
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v7, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_tool_chevron_right I
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageResource(I)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v7, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-static v4, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v4
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    const/16 v4, 8
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setVisibility(I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->chevronView Landroid/widget/ImageView;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v1, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    mul-float v1, v14, v8
    float-to-int v1, v1
    invoke-virtual v4, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v7, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v1, v6, Landroid/widget/LinearLayout;->setOrientation(I)V
    move-object v3, v1
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v9, -2
    invoke-direct v4, v5, v9, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v4, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/FrameLayout;
    invoke-direct v3, v7, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    move-object v4, v3
    check-cast v4, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v10, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v4, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v4, Landroid/view/View;
    invoke-direct v4, v7, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v7, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/view/View;->setBackgroundColor(I)V
    iput-object v4, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->verticalLine Landroid/view/View;
    mul-float/2addr v12, v8
    float-to-int v5, v12
    new-instance v9, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v10, 1
    const/4 v12, -1
    invoke-direct v9, v5, v12, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, v9, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/FrameLayout;
    invoke-direct v3, v7, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    mul-float/2addr v14, v8
    float-to-int v4, v14
    mul-float v5, v11, v8
    float-to-int v5, v5
    invoke-virtual v3, v6, v4, v6, v5, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    iput-object v3, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -2
    invoke-direct v4, v6, v5, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    mul-float/2addr v11, v8
    float-to-int v2, v11
    invoke-virtual v4, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v2, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final bind$lambda$18(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method private static final update$lambda$20(kotlin.jvm.functions.Function1  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    return-void 
.end method

.method public final bind(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard)void
    .registers 8
    # ins_size=2
    const-string v0, "card"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +040h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v3
    if-eqz v3, +013h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v4
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-static v3, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v3
    goto +fh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-static v3, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +16h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconEmoji()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getTitle()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getShimmerTitle()Z
    move-result v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +008h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +11h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +008h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +11h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->removeAllViews()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getContentView()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +018h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v4
    const-string v5, "getContext(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    if-eqz v0, +007h
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getChildCount()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v3, v2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->verticalLine Landroid/view/View;
    if-eqz v3, +004h
    move v4, v2
    goto +2h
    move v4, v1
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    if-eqz v3, +004h
    move v3, v2
    goto +2h
    move v3, v1
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    const/4 v3, 0
    if-eqz v0, +018h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->chevronView Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v7
    if-eqz v7, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView$$ExternalSyntheticLambda1;
    invoke-direct v3, v7, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView$$ExternalSyntheticLambda1;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +10h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->chevronView Landroid/widget/ImageView;
    invoke-virtual v7, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, v2, Landroid/widget/LinearLayout;->setClickable(Z)V
    return-void 
.end method

.method public final update(com.bytedance.trae.conversation.chat.toolcall.ToolDetailCard)void
    .registers 8
    # ins_size=2
    const-string v0, "card"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v0
    const/16 v1, 8
    const/4 v2, 0
    if-eqz v0, +040h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconResId()I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v3
    if-eqz v3, +013h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconTintColorRes()I
    move-result v4
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-static v3, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v3
    goto +fh
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-static v3, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageTintList(Landroid/content/res/ColorStateList;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +16h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getIconEmoji()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconEmojiView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->iconImageView Landroid/widget/ImageView;
    invoke-virtual v0, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getTitle()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->titleView Lcom/bytedance/trae/conversation/widget/ShimmerTextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getShimmerTitle()Z
    move-result v3
    invoke-virtual v0, v3, Lcom/bytedance/trae/conversation/widget/ShimmerTextView;->setShimmerEnabled(Z)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v3, 1
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +008h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +11h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getSubtitle()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->subtitleView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v0
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v2
    goto +2h
    move v0, v3
    if-eqz v0, +008h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    goto +11h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getBadgeText()Ljava/lang/String;
    move-result-object v4
    check-cast v4, Ljava/lang/CharSequence;
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->badgeView Landroid/widget/TextView;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->removeAllViews()V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getContentView()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    if-eqz v0, +018h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->getContext()Landroid/content/Context;
    move-result-object v4
    const-string v5, "getContext(...)"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-interface v0, v4, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    move-result-object v0
    check-cast v0, Landroid/view/View;
    if-eqz v0, +007h
    iget-object v4, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v4, v0, Landroid/widget/FrameLayout;->addView(Landroid/view/View;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    invoke-virtual v0, Landroid/widget/FrameLayout;->getChildCount()I
    move-result v0
    if-lez v0, +003h
    goto +2h
    move v3, v2
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->verticalLine Landroid/view/View;
    if-eqz v3, +004h
    move v4, v2
    goto +2h
    move v4, v1
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->contentContainer Landroid/widget/FrameLayout;
    if-eqz v3, +004h
    move v3, v2
    goto +2h
    move v3, v1
    invoke-virtual v0, v3, Landroid/widget/FrameLayout;->setVisibility(I)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v0
    const/4 v3, 0
    if-eqz v0, +018h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->chevronView Landroid/widget/ImageView;
    invoke-virtual v0, v2, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, Lcom/bytedance/trae/conversation/chat/toolcall/ToolDetailCard;->getOnDetailClick()Lkotlin/jvm/functions/Function1;
    move-result-object v7
    if-eqz v7, +007h
    new-instance v3, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView$$ExternalSyntheticLambda0;
    invoke-direct v3, v7, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView$$ExternalSyntheticLambda0;-><init>(Lkotlin/jvm/functions/Function1;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +10h
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->chevronView Landroid/widget/ImageView;
    invoke-virtual v7, v1, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/detail/ToolItemView;->headerRow Landroid/widget/LinearLayout;
    invoke-virtual v7, v2, Landroid/widget/LinearLayout;->setClickable(Z)V
    return-void 
.end method
