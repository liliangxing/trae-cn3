# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;
.super Landroidx/fragment/app/Fragment;
.source "FallbackDetailFragment.kt"

.field private static final ARG_INPUT:Ljava/lang/String;
.field private static final ARG_OUTPUT:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private final buildSection(android.content.Context  float  java.lang.String  java.lang.String  java.lang.Integer)android.view.View
    .registers 14
    # ins_size=6
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -1
    const/4 v4, -2
    invoke-direct v2, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v11, Ljava/lang/CharSequence;
    invoke-virtual v2, v11, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v11, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v9, v11, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    invoke-virtual v2, v11, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v11, 1097859072
    const/4 v5, 2
    invoke-virtual v2, v5, v11, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v2, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v4, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v2, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v11, 12
    int-to-float v11, v11
    mul-float/2addr v11, v10
    float-to-int v11, v11
    new-instance v2, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v2, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v9, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v2, v6, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    int-to-float v6, v1
    mul-float/2addr v6, v10
    float-to-int v6, v6
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v9, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v2, v6, v7, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    const/16 v6, 10
    int-to-float v6, v6
    mul-float/2addr v6, v10
    invoke-virtual v2, v6, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    check-cast v12, Ljava/lang/CharSequence;
    invoke-virtual v10, v12, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v12, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v9, v12, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v12
    invoke-virtual v10, v12, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v12, 1098907648
    invoke-virtual v10, v5, v12, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v12, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v10, v12, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    if-eqz v13, +021h
    new-instance v12, Landroid/widget/ScrollView;
    invoke-direct v12, v9, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V
    invoke-virtual v12, v1, Landroid/widget/ScrollView;->setVerticalScrollBarEnabled(Z)V
    invoke-virtual v12, v11, v11, v11, v11, Landroid/widget/ScrollView;->setPadding(I I I I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v12, v2, Landroid/widget/ScrollView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v10, Landroid/view/View;
    new-instance v9, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v9, v3, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v10, v9, Landroid/widget/ScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v12, Landroid/view/View;
    goto +1fh
    new-instance v12, Landroid/widget/LinearLayout;
    invoke-direct v12, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v12, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v12, v11, v11, v11, v11, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    check-cast v2, Landroid/graphics/drawable/Drawable;
    invoke-virtual v12, v2, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v10, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v10, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v12, Landroid/view/View;
    if-eqz v13, +006h
    invoke-virtual v13, Ljava/lang/Integer;->intValue()I
    move-result v4
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v9, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    iput v11, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v10, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v12, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 14
    # ins_size=4
    const-string v12, "inflater"
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v11
    const-string/jumbo v12, requireContext(...)
    invoke-static v11, v12, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v12
    iget v12, v12, Landroid/util/DisplayMetrics;->density F
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v13
    const/4 v0, 0
    if-eqz v13, +00ah
    const-string v1, "input"
    invoke-virtual v13, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    move-object v4, v13
    goto +2h
    move-object v4, v0
    invoke-virtual v10, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v13
    if-eqz v13, +009h
    const-string v0, "output"
    invoke-virtual v13, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    goto +2h
    move-object v13, v0
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v0, 1
    invoke-virtual v6, v0, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v0, 16
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v0, v0
    const/16 v1, 12
    int-to-float v1, v1
    mul-float/2addr v1, v12
    float-to-int v1, v1
    invoke-virtual v6, v0, v1, v0, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    const-string v7, "getString(...)"
    if-eqz v4, +016h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_input I
    invoke-virtual v11, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v5, 0
    move-object v0, v10
    move-object v1, v11
    move v2, v12
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->buildSection(Landroid/content/Context; F Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v6, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    const/4 v8, -2
    const/4 v9, -1
    if-eqz v13, +030h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_fallback_output I
    invoke-virtual v11, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v7, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/16 v0, 250
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v0, v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    move-object v0, v10
    move-object v1, v11
    move v2, v12
    move-object v4, v13
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/chat/detail/FallbackDetailFragment;->buildSection(Landroid/content/Context; F Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer;)Landroid/view/View;
    move-result-object v13
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v0, v9, v8, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v1, 24
    int-to-float v1, v1
    mul-float/2addr v1, v12
    float-to-int v12, v1
    iput v12, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v13, v0, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v6, v13, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v12, Landroid/widget/ScrollView;
    invoke-direct v12, v11, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V
    check-cast v6, Landroid/view/View;
    new-instance v11, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v11, v9, v8, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v12, v6, v11, Landroid/widget/ScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v12, Landroid/view/View;
    return-object v12
.end method
