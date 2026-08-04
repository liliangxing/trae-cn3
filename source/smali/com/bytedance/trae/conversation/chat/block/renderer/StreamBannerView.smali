# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
.super Landroid/widget/LinearLayout;
.source "StreamBannerView.kt"

.field private final backgroundDrawable:Landroid/graphics/drawable/GradientDrawable;
.field private final iconView:Landroid/widget/ImageView;
.field private final messageView:Landroid/widget/TextView;
.field private final titleView:Landroid/widget/TextView;


.method public constructor <init>(android.content.Context)void
    .registers 10
    # ins_size=2
    const-string v0, "context"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v8, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setOrientation(I)V
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    const/16 v2, 16
    int-to-float v3, v2
    mul-float/2addr v3, v1
    float-to-int v3, v3
    const/16 v4, 12
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v5, v4
    invoke-virtual v8, v3, v5, v3, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    invoke-virtual v3, v4, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    int-to-float v4, v0
    mul-float/2addr v4, v1
    float-to-int v4, v4
    const/4 v5, 0
    invoke-virtual v3, v4, v5, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    iput-object v3, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v8, v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v3, v5, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    new-instance v2, Landroid/widget/ImageView;
    invoke-direct v2, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v4, Landroid/widget/ImageView$ScaleType;->FIT_CENTER Landroid/widget/ImageView$ScaleType;
    invoke-virtual v2, v4, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    iput-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    const/16 v4, 20
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v4, v4
    check-cast v2, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v2, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v4, 1096810496
    const/4 v6, 2
    invoke-virtual v2, v6, v4, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v4, Landroid/graphics/Typeface;->DEFAULT Landroid/graphics/Typeface;
    invoke-static v4, v0, Landroid/graphics/Typeface;->create(Landroid/graphics/Typeface; I)Landroid/graphics/Typeface;
    move-result-object v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v9, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v2, v0, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v4, 1065353216
    const/4 v7, -2
    invoke-direct v0, v5, v7, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/4 v4, 4
    int-to-float v4, v4
    mul-float/2addr v4, v1
    float-to-int v1, v4
    invoke-virtual v0, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v0, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v2, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    check-cast v2, Landroid/view/View;
    invoke-virtual v3, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v3, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v2, -1
    invoke-direct v0, v2, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v3, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/high16 v3, 1095761920
    invoke-virtual v0, v6, v3, Landroid/widget/TextView;->setTextSize(I F)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v9, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v0, v9, Landroid/widget/TextView;->setTextColor(I)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v2, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v1, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    iput-object v0, v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    check-cast v0, Landroid/view/View;
    invoke-virtual v8, v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->addView(Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic configureInlineAlert$default(com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView  java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style  java.lang.Integer  int  java.lang.Object)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +003h
    const/4 v4, 0
    invoke-virtual v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->configureInlineAlert(Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style; Ljava/lang/Integer;)V
    return-void 
.end method

.method private final inlineAlertBackgroundColor(com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style)int
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-ne v0, v1, +009h
    const-string v3, "#1FE8463A"
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    goto +dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getBgColorRes()I
    move-result v3
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    return v3
.end method

.method private final inlineAlertBorderColor(com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style)int
    .registers 4
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->ordinal()I
    move-result v1
    aget v0, v0, v1
    const/4 v1, 1
    if-ne v0, v1, +009h
    const-string v3, "#29E8463A"
    invoke-static v3, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v3
    goto +dh
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getBorderColorRes()I
    move-result v3
    invoke-static v0, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    return v3
.end method

.method public final configure(java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style  int)void
    .registers 10
    # ins_size=5
    const-string/jumbo v0, title
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, style
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getBgColorRes()I
    move-result v3
    invoke-static v2, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    iget-object v1, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    const/4 v2, 1
    int-to-float v3, v2
    mul-float/2addr v3, v0
    float-to-int v0, v3
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v3
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getBorderColorRes()I
    move-result v4
    invoke-static v3, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v1, v0, v3, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v0, v9, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v9, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v0
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getTintColorRes()I
    move-result v8
    invoke-static v0, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v9, v8, Landroid/widget/ImageView;->setColorFilter(I)V
    iget-object v8, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v8, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v7, Ljava/lang/CharSequence;
    invoke-interface v7, Ljava/lang/CharSequence;->length()I
    move-result v6
    const/4 v8, 0
    if-nez v6, +003h
    goto +2h
    move v2, v8
    if-eqz v2, +00ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    const/16 v7, 8
    invoke-virtual v6, v7, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v6, v8, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v6, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final configureInlineAlert(java.lang.String  java.lang.String  com.bytedance.trae.conversation.chat.block.renderer.StreamBannerView$Style  java.lang.Integer)void
    .registers 11
    # ins_size=5
    const-string/jumbo v0, title
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "message"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, style
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    const/16 v2, 20
    int-to-float v2, v2
    mul-float/2addr v2, v0
    invoke-virtual v1, v2, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v6, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->inlineAlertBackgroundColor(Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;)I
    move-result v2
    invoke-virtual v1, v2, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    iget-object v1, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->backgroundDrawable Landroid/graphics/drawable/GradientDrawable;
    const/4 v2, 1
    int-to-float v3, v2
    mul-float/2addr v3, v0
    float-to-int v3, v3
    invoke-static v2, v3, Ljava/lang/Math;->max(I I)I
    move-result v3
    invoke-direct v6, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->inlineAlertBorderColor(Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;)I
    move-result v4
    invoke-virtual v1, v3, v4, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    const/4 v1, 0
    const/16 v3, 8
    const/4 v4, 0
    if-eqz v10, +03eh
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v5, v4, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v5, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v10, Ljava/lang/Integer;->intValue()I
    move-result v10
    invoke-virtual v5, v10, Landroid/widget/ImageView;->setImageResource(I)V
    iget-object v10, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getContext()Landroid/content/Context;
    move-result-object v5
    invoke-virtual v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->getTintColorRes()I
    move-result v9
    invoke-static v5, v9, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v10, v9, Landroid/widget/ImageView;->setColorFilter(I)V
    iget-object v9, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    invoke-virtual v9, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v9
    instance-of v10, v9, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v10, +005h
    move-object v1, v9
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v1, +027h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v10, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_4 I
    invoke-virtual v9, v10, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v9
    invoke-virtual v1, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    goto +18h
    iget-object v9, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->iconView Landroid/widget/ImageView;
    invoke-virtual v9, v3, Landroid/widget/ImageView;->setVisibility(I)V
    iget-object v9, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    invoke-virtual v9, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v9
    instance-of v10, v9, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v10, +005h
    move-object v1, v9
    check-cast v1, Landroid/widget/LinearLayout$LayoutParams;
    if-eqz v1, +005h
    invoke-virtual v1, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    iget-object v9, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v9, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/high16 v7, 1098907648
    const/4 v10, 2
    invoke-virtual v9, v10, v7, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v7, sans-serif-medium
    invoke-static v7, v4, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v7
    invoke-virtual v9, v7, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const-string v7, "#0A0A0A"
    invoke-static v7, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v7
    invoke-virtual v9, v7, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v9, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/16 v7, 22
    int-to-float v7, v7
    mul-float/2addr v7, v0
    float-to-int v7, v7
    invoke-static v9, v7, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    iget-object v7, v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    const/high16 v9, 1095761920
    invoke-virtual v7, v10, v9, Landroid/widget/TextView;->setTextSize(I F)V
    const-string v9, "#404040"
    invoke-static v9, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    move-result v9
    invoke-virtual v7, v9, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v7, v2, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    const/16 v9, 17
    int-to-float v9, v9
    mul-float/2addr v9, v0
    float-to-int v9, v9
    invoke-static v7, v9, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    check-cast v8, Ljava/lang/CharSequence;
    invoke-interface v8, Ljava/lang/CharSequence;->length()I
    move-result v9
    if-nez v9, +003h
    goto +2h
    move v2, v4
    if-eqz v2, +006h
    invoke-virtual v7, v3, Landroid/widget/TextView;->setVisibility(I)V
    goto +7h
    invoke-virtual v7, v4, Landroid/widget/TextView;->setVisibility(I)V
    invoke-virtual v7, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final updateMessage(java.lang.String)void
    .registers 4
    # ins_size=2
    const-string v0, "message"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-interface v3, Ljava/lang/CharSequence;->length()I
    move-result v0
    const/4 v1, 0
    if-nez v0, +004h
    const/4 v0, 1
    goto +2h
    move v0, v1
    if-eqz v0, +00ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    const/16 v0, 8
    invoke-virtual v3, v0, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v1, Landroid/widget/TextView;->setVisibility(I)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->messageView Landroid/widget/TextView;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method

.method public final updateTitle(java.lang.String)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, title
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->titleView Landroid/widget/TextView;
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    return-void 
.end method
