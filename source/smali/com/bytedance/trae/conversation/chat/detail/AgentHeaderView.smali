# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;
.super Landroid/widget/LinearLayout;
.source "AgentHeaderView.kt"

.field private final density:F
.field private final descView:Landroid/widget/TextView;
.field private final iconView:Landroid/widget/ImageView;
.field private final nameView:Landroid/widget/TextView;


.method public constructor <init>(android.content.Context)void
    .registers 14
    # ins_size=2
    const-string v0, "context"
    invoke-static v13, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v12, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v13, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    iput v0, v12, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->density F
    const/4 v1, 0
    invoke-virtual v12, v1, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v12, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->setGravity(I)V
    const/16 v2, 12
    int-to-float v2, v2
    mul-float v3, v2, v0
    float-to-int v3, v3
    const/16 v4, 8
    int-to-float v5, v4
    mul-float/2addr v5, v0
    float-to-int v5, v5
    invoke-virtual v12, v3, v5, v3, v5, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->setPadding(I I I I)V
    new-instance v3, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v3, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v5, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v13, v5, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v3, v5, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    const/16 v5, 10
    int-to-float v5, v5
    mul-float/2addr v5, v0
    invoke-virtual v3, v5, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    check-cast v3, Landroid/graphics/drawable/Drawable;
    invoke-virtual v12, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v5, -1
    const/4 v6, -2
    invoke-direct v3, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v13, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget-object v7, Landroid/widget/ImageView$ScaleType;->CENTER_CROP Landroid/widget/ImageView$ScaleType;
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->avatar_coder I
    invoke-virtual v3, v7, Landroid/widget/ImageView;->setImageResource(I)V
    iput-object v3, v12, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->iconView Landroid/widget/ImageView;
    const/16 v7, 24
    int-to-float v7, v7
    mul-float/2addr v7, v0
    float-to-int v7, v7
    check-cast v3, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v8, v7, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v3, v8, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/LinearLayout;
    invoke-direct v3, v13, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v7, 1
    invoke-virtual v3, v7, Landroid/widget/LinearLayout;->setOrientation(I)V
    move-object v8, v3
    check-cast v8, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v9, v1, v6, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    mul-float/2addr v2, v0
    float-to-int v1, v2
    invoke-virtual v9, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v8, v9, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v13, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/4 v2, 2
    const/high16 v8, 1095761920
    invoke-virtual v1, v2, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-static v7, Landroid/graphics/Typeface;->defaultFromStyle(I)Landroid/graphics/Typeface;
    move-result-object v9
    invoke-virtual v1, v9, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    const v9, -1144313505
    invoke-virtual v1, v9, Landroid/widget/TextView;->setLetterSpacing(F)V
    const/16 v10, 17
    int-to-float v10, v10
    mul-float v11, v10, v0
    float-to-int v11, v11
    invoke-static v1, v11, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v1, v7, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v11, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v11, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    iput-object v1, v12, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->nameView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v1, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v1, Landroid/widget/TextView;
    invoke-direct v1, v13, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v13, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v13
    invoke-virtual v1, v13, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v1, v2, v8, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v1, v9, Landroid/widget/TextView;->setLetterSpacing(F)V
    mul-float/2addr v10, v0
    float-to-int v13, v10
    invoke-static v1, v13, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v1, v7, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v13, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v1, v13, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v1, v4, Landroid/widget/TextView;->setVisibility(I)V
    iput-object v1, v12, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->descView Landroid/widget/TextView;
    check-cast v1, Landroid/view/View;
    new-instance v13, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v13, v5, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    int-to-float v2, v2
    mul-float/2addr v2, v0
    float-to-int v0, v2
    iput v0, v13, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v13, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v1, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method public static synthetic bind$default(com.bytedance.trae.conversation.chat.detail.AgentHeaderView  java.lang.String  java.lang.String  java.lang.String  int  java.lang.Object)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +003h
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->bind(Ljava/lang/String; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public final bind(java.lang.String  java.lang.String  java.lang.String)void
    .registers 6
    # ins_size=4
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->nameView Landroid/widget/TextView;
    if-eqz v3, +003h
    goto +10h
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->getContext()Landroid/content/Context;
    move-result-object v3
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_sub_agent_default I
    invoke-virtual v3, v1, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    const-string v1, "getString(...)"
    invoke-static v3, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v0, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->iconView Landroid/widget/ImageView;
    sget-object v0, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;->INSTANCE Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;
    invoke-virtual v0, v5, Lcom/bytedance/trae/conversation/chat/detail/AgentAvatarHelper;->getAvatarResId(Ljava/lang/String;)I
    move-result v5
    invoke-virtual v3, v5, Landroid/widget/ImageView;->setImageResource(I)V
    check-cast v4, Ljava/lang/CharSequence;
    const/4 v3, 0
    if-eqz v4, +00bh
    invoke-static v4, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v5
    if-eqz v5, +003h
    goto +3h
    move v5, v3
    goto +2h
    const/4 v5, 1
    if-eqz v5, +00ah
    iget-object v3, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->descView Landroid/widget/TextView;
    const/16 v4, 8
    invoke-virtual v3, v4, Landroid/widget/TextView;->setVisibility(I)V
    goto +bh
    iget-object v5, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->descView Landroid/widget/TextView;
    invoke-virtual v5, v4, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    iget-object v4, v2, Lcom/bytedance/trae/conversation/chat/detail/AgentHeaderView;->descView Landroid/widget/TextView;
    invoke-virtual v4, v3, Landroid/widget/TextView;->setVisibility(I)V
    return-void 
.end method
