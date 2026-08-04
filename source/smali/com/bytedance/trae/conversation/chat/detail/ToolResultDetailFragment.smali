# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
.super Landroidx/fragment/app/Fragment;
.source "ToolResultDetailFragment.kt"

.field private static final ARG_COMMAND:Ljava/lang/String;
.field private static final ARG_COMMAND_LABEL:Ljava/lang/String;
.field private static final ARG_OUTPUT:Ljava/lang/String;
.field private static final ARG_OUTPUT_LABEL:Ljava/lang/String;
.field private static final ARG_TITLE:Ljava/lang/String;
.field private static final ARG_WARNING_MESSAGE:Ljava/lang/String;
.field private static final ARG_WARNING_TITLE:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
.field private monoTypeface:Landroid/graphics/Typeface;


.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->Companion Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Landroidx/fragment/app/Fragment;-><init>()V
    return-void 
.end method

.method private final buildSection(android.content.Context  float  java.lang.String  java.lang.String  java.lang.Integer  int  boolean)android.view.View
    .registers 24
    # ins_size=8
    move-object/from16 v1, v17
    move/from16 v6, v22
    new-instance v7, Landroid/widget/LinearLayout;
    invoke-direct v7, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v8, 1
    invoke-virtual v7, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    if-lez v6, +005h
    invoke-virtual v7, v6, Landroid/widget/LinearLayout;->setMinimumHeight(I)V
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v9, -1
    const/4 v10, -2
    invoke-direct v0, v9, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    move-object/from16 v2, v19
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v0, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v0, v2, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v2, 1097859072
    const/4 v3, 2
    invoke-virtual v0, v3, v2, Landroid/widget/TextView;->setTextSize(I F)V
    check-cast v0, Landroid/view/View;
    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v2, v10, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v2, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v0, 12
    int-to-float v0, v0
    mul-float v0, v0, v18
    float-to-int v11, v0
    new-instance v12, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v12, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_overlay_l1 I
    invoke-static v1, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    invoke-virtual v12, v0, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    int-to-float v0, v8
    mul-float v0, v0, v18
    float-to-int v0, v0
    sget v2, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l2 I
    invoke-static v1, v2, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v2
    invoke-virtual v12, v0, v2, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    const/16 v0, 10
    int-to-float v0, v0
    mul-float v0, v0, v18
    invoke-virtual v12, v0, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    if-eqz v23, +009h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v1, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    goto +7h
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v1, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v0
    new-instance v13, Landroid/widget/TextView;
    invoke-direct v13, v1, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    move-object/from16 v2, v20
    check-cast v2, Ljava/lang/CharSequence;
    invoke-virtual v13, v2, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v13, v0, Landroid/widget/TextView;->setTextColor(I)V
    const/high16 v0, 1098907648
    invoke-virtual v13, v3, v0, Landroid/widget/TextView;->setTextSize(I F)V
    sget-object v0, Landroid/graphics/Typeface;->MONOSPACE Landroid/graphics/Typeface;
    invoke-virtual v13, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    move-object/from16 v14, v16
    iget-object v0, v14, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->monoTypeface Landroid/graphics/Typeface;
    if-eqz v0, +005h
    invoke-virtual v13, v0, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    if-eqz v21, +035h
    new-instance v15, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v15
    move-object/from16 v1, v17
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-virtual/range v21, Ljava/lang/Integer;->intValue()I
    move-result v0
    if-lez v0, +009h
    invoke-virtual/range v21, Ljava/lang/Integer;->intValue()I
    move-result v0
    invoke-virtual v15, v0, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->setMaxHeight(I)V
    invoke-virtual v15, v8, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->setVerticalScrollBarEnabled(Z)V
    invoke-virtual v15, v11, v11, v11, v11, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->setPadding(I I I I)V
    check-cast v12, Landroid/graphics/drawable/Drawable;
    invoke-virtual v15, v12, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v13, Landroid/view/View;
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;
    invoke-direct v0, v9, v10, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v15, v13, v0, Lcom/bytedance/trae/conversation/widget/BottomSheetNestedScrollView;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v15, Landroid/view/View;
    goto +20h
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v1, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v0, v8, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v0, v11, v11, v11, v11, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    check-cast v12, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v12, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    check-cast v13, Landroid/view/View;
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v1, v9, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v13, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v15, v0
    check-cast v15, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    if-lez v6, +003h
    const/4 v10, 0
    if-lez v6, +005h
    const/high16 v1, 1065353216
    goto +2h
    const/4 v1, 0
    invoke-direct v0, v9, v10, v1, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    iput v11, v0, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v15, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    return-object v7
    :try_start_0x98
.end method

.method static synthetic buildSection$default(com.bytedance.trae.conversation.chat.detail.ToolResultDetailFragment  android.content.Context  float  java.lang.String  java.lang.String  java.lang.Integer  int  boolean  int  java.lang.Object)android.view.View
    .registers 20
    # ins_size=10
    and-int/lit8 v0, v18, 32
    const/4 v1, 0
    if-eqz v0, +004h
    move v8, v1
    goto +3h
    move/from16 v8, v16
    and-int/lit8 v0, v18, 64
    if-eqz v0, +004h
    move v9, v1
    goto +3h
    move/from16 v9, v17
    move-object v2, v10
    move-object v3, v11
    move v4, v12
    move-object v5, v13
    move-object v6, v14
    move-object v7, v15
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->buildSection(Landroid/content/Context; F Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; I Z)Landroid/view/View;
    move-result-object v0
    return-object v0
.end method

.method private final buildWarningView(android.content.Context  java.lang.String  java.lang.String)android.view.View
    .registers 12
    # ins_size=4
    new-instance v7, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;
    invoke-direct v7, v9, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;-><init>(Landroid/content/Context;)V
    sget-object v3, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;->WARNING Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style;
    const/4 v4, 0
    const/16 v5, 8
    const/4 v6, 0
    move-object v0, v7
    move-object v1, v10
    move-object v2, v11
    invoke-static/range v0 ... v6, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->configureInlineAlert$default(Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView; Ljava/lang/String; Ljava/lang/String; Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView$Style; Ljava/lang/Integer; I Ljava/lang/Object;)V
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v11, -1
    const/4 v0, -2
    invoke-direct v10, v11, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v11, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v9, v11, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v9
    iput v9, v10, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v10, Lcom/bytedance/trae/conversation/chat/block/renderer/StreamBannerView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v7, Landroid/view/View;
    return-object v7
.end method

.method private final findBottomSheet(androidx.fragment.app.FragmentActivity)com.bytedance.trae.conversation.chat.detail.ProcessDetailBottomSheet
    .registers 4
    # ins_size=2
    const/4 v0, 0
    if-nez v3, +003h
    return-object v0
    invoke-virtual v3, Landroidx/fragment/app/FragmentActivity;->getSupportFragmentManager()Landroidx/fragment/app/FragmentManager;
    move-result-object v3
    const-string v1, "ProcessDetailBottomSheet"
    invoke-virtual v3, v1, Landroidx/fragment/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroidx/fragment/app/Fragment;
    move-result-object v3
    instance-of v1, v3, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    if-eqz v1, +005h
    move-object v0, v3
    check-cast v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    return-object v0
.end method

.method public final getMonoTypeface()android.graphics.Typeface
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->monoTypeface Landroid/graphics/Typeface;
    return-object v0
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 24
    # ins_size=4
    move-object/from16 v10, v20
    const-string v0, "inflater"
    move-object/from16 v1, v21
    invoke-static v1, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->requireContext()Landroid/content/Context;
    move-result-object v11
    const-string/jumbo v0, requireContext(...)
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v11, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v12, v0, Landroid/util/DisplayMetrics;->density F
    new-instance v13, Landroid/widget/LinearLayout;
    invoke-direct v13, v11, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v14, 1
    invoke-virtual v13, v14, Landroid/widget/LinearLayout;->setOrientation(I)V
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;
    const/4 v1, -2
    const/4 v15, -1
    invoke-direct v0, v15, v1, Landroid/view/ViewGroup$LayoutParams;-><init>(I I)V
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/16 v0, 16
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v0, v0
    const/16 v1, 12
    int-to-float v1, v1
    mul-float/2addr v1, v12
    float-to-int v1, v1
    invoke-virtual v13, v0, v1, v0, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    const/4 v1, 0
    if-eqz v0, +00ah
    const-string v2, "command"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object v4, v0
    goto +2h
    move-object v4, v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +00bh
    const-string v2, "output"
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    move-object/from16 v16, v0
    goto +3h
    move-object/from16 v16, v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v0
    if-eqz v0, +00ah
    const-string/jumbo v2, title
    invoke-virtual v0, v2, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    goto +2h
    move-object v0, v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v2
    if-eqz v2, +00ah
    const-string/jumbo v3, warning_title
    invoke-virtual v2, v3, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    goto +2h
    move-object v2, v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v3
    if-eqz v3, +009h
    const-string/jumbo v1, warning_message
    invoke-virtual v3, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v1
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v3
    const-string v5, "getString(...)"
    if-eqz v3, +00ah
    const-string v6, "command_label"
    invoke-virtual v3, v6, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    if-nez v3, +00bh
    sget v3, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_command I
    invoke-virtual v11, v3, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v3
    invoke-static v3, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getArguments()Landroid/os/Bundle;
    move-result-object v6
    if-eqz v6, +00ah
    const-string v7, "output_label"
    invoke-virtual v6, v7, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v6
    if-nez v6, +00bh
    sget v6, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_output I
    invoke-virtual v11, v6, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v6
    invoke-static v6, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    move-object/from16 v17, v6
    invoke-virtual v11, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;
    move-result-object v5
    const-string v6, "fonts/JetBrainsMono-Regular.ttf"
    invoke-static v5, v6, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager; Ljava/lang/String;)Landroid/graphics/Typeface;
    move-result-object v5
    iput-object v5, v10, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->monoTypeface Landroid/graphics/Typeface;
    if-eqz v0, +00fh
    invoke-virtual/range v20, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v5
    invoke-direct v10, v5, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v5
    if-eqz v5, +005h
    invoke-virtual v5, v0, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->setTitle(Ljava/lang/String;)V
    move-object v0, v2
    check-cast v0, Ljava/lang/CharSequence;
    const/4 v9, 0
    if-eqz v0, +00bh
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v9
    goto +2h
    move v0, v14
    if-nez v0, +00dh
    if-nez v1, +004h
    const-string v1, ""
    invoke-direct v10, v11, v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->buildWarningView(Landroid/content/Context; Ljava/lang/String; Ljava/lang/String;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    move-object/from16 v18, v4
    check-cast v18, Ljava/lang/CharSequence;
    if-eqz v18, +00bh
    invoke-interface/range v18, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move v0, v9
    goto +2h
    move v0, v14
    if-nez v0, +021h
    const/16 v0, 120
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v0, v0
    invoke-static v0, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/4 v6, 0
    const/4 v7, 0
    const/16 v8, 96
    const/16 v19, 0
    move-object/from16 v0, v20
    move-object v1, v11
    move v2, v12
    move/from16 v21, v9
    move-object/from16 v9, v19
    invoke-static/range v0 ... v9, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->buildSection$default(Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment; Landroid/content/Context; F Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; I Z I Ljava/lang/Object;)Landroid/view/View;
    move-result-object v0
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto +3h
    move/from16 v21, v9
    move-object v0, v10
    check-cast v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;
    move-object/from16 v0, v16
    check-cast v0, Ljava/lang/CharSequence;
    if-eqz v0, +00ch
    invoke-interface v0, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +4h
    move/from16 v7, v21
    goto +2h
    move v7, v14
    if-eqz v7, +008h
    sget v0, Lcom/bytedance/trae/conversation/R$string;->trae_chat_tool_cmd_no_output I
    invoke-virtual v11, v0, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v16
    if-nez v16, +006h
    const-string v0, "No output"
    move-object v4, v0
    goto +3h
    move-object/from16 v4, v16
    if-eqz v18, +00bh
    invoke-interface/range v18, Ljava/lang/CharSequence;->length()I
    move-result v0
    if-nez v0, +003h
    goto +3h
    move/from16 v14, v21
    if-eqz v14, +005h
    move/from16 v9, v21
    goto +6h
    const/16 v0, 24
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v9, v0
    invoke-static/range v21, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v5
    const/16 v0, 250
    int-to-float v0, v0
    mul-float/2addr v0, v12
    float-to-int v6, v0
    move-object/from16 v0, v20
    move-object v1, v11
    move v2, v12
    move-object/from16 v3, v17
    invoke-direct/range v0 ... v7, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->buildSection(Landroid/content/Context; F Ljava/lang/String; Ljava/lang/String; Ljava/lang/Integer; I Z)Landroid/view/View;
    move-result-object v0
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v2, 1065353216
    move/from16 v3, v21
    invoke-direct v1, v15, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    iput v9, v1, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v13, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v13, Landroid/view/View;
    return-object v13
    :try_start_0xbb
    :try_start_0xc9
.end method

.method public onDestroyView()void
    .registers 3
    # ins_size=1
    invoke-super v2, Landroidx/fragment/app/Fragment;->onDestroyView()V
    invoke-virtual v2, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getActivity()Landroidx/fragment/app/FragmentActivity;
    move-result-object v0
    invoke-direct v2, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->findBottomSheet(Landroidx/fragment/app/FragmentActivity;)Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;
    move-result-object v0
    if-eqz v0, +00bh
    sget v1, Lcom/bytedance/trae/conversation/R$string;->trae_chat_process_detail_title I
    invoke-virtual v2, v1, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->getString(I)Ljava/lang/String;
    move-result-object v1
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/chat/detail/ProcessDetailBottomSheet;->setTitle(Ljava/lang/String;)V
    return-void 
    :try_start_0x3
.end method

.method public final setMonoTypeface(android.graphics.Typeface)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/chat/detail/ToolResultDetailFragment;->monoTypeface Landroid/graphics/Typeface;
    return-void 
.end method
