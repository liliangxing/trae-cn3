# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
.super Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;
.source "ModelSelectBottomSheet.kt"

.field private static final ARG_CHAT_MODE:Ljava/lang/String;
.field private static final ARG_CLI_ID:Ljava/lang/String;
.field private static final ARG_CLI_TYPE:Ljava/lang/String;
.field private static final ARG_FROM_IDE:Ljava/lang/String;
.field private static final ARG_IDE_VERSION:Ljava/lang/String;
.field private static final ARG_SELECTED_MODEL_ID:Ljava/lang/String;
.field public static final Companion:Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;
.field public static final TAG:Ljava/lang/String;
.field private chatMode:Lcom/bytedance/trae/conversation/widget/ChatMode;
.field private cliId:Ljava/lang/String;
.field private cliType:Lcom/bytedance/trae/im/service/CliType;
.field private contentLayout:Landroid/widget/LinearLayout;
.field private ideVersion:Ljava/lang/String;
.field private onModelListLoaded:Lkotlin/jvm/functions/Function1;
.field private onModelSelected:Lkotlin/jvm/functions/Function1;
.field private progressBar:Landroid/widget/ProgressBar;
.field private selectedModelId:Ljava/lang/String;


.method public static synthetic $r8$lambda$NJQIgwrU-whdwN9GvlPfDMav1uA(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  com.bytedance.trae.conversation.network.RemoteModelItem  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildModelRow$lambda$28$lambda$23(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Lcom/bytedance/trae/conversation/network/RemoteModelItem; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$e-Pfyrj5GR48s5BSBJnFMwgXTBI(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onCreateView$lambda$5$lambda$4(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$hiIarjIwgxWsTniJCe4cSwAZW0w(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  android.content.DialogInterface)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onCreateDialog$lambda$2(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Landroid/content/DialogInterface;)V
    return-void 
.end method

.method static constructor <clinit>()void
    .registers 2
    # ins_size=0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;
    const/4 v1, 0
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sput-object v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->Companion Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$Companion;
    return-void 
.end method

.method public constructor <init>()void
    .registers 2
    # ins_size=1
    invoke-direct v1, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;-><init>()V
    sget-object v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    sget-object v0, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v0, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    const-string v0, ""
    iput-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliId Ljava/lang/String;
    return-void 
.end method

.method public static final synthetic access$getCliId$p(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliId Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getCliType$p(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet)com.bytedance.trae.im.service.CliType
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    return-object v0
.end method

.method public static final synthetic access$getIdeVersion$p(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet)java.lang.String
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->ideVersion Ljava/lang/String;
    return-object v0
.end method

.method public static final synthetic access$getProgressBar$p(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet)android.widget.ProgressBar
    .registers 1
    # ins_size=1
    iget-object v0, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    return-object v0
.end method

.method public static final synthetic access$updateModelList(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  java.util.List  java.lang.String  boolean  android.content.Context)void
    .registers 5
    # ins_size=5
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->updateModelList(Ljava/util/List; Ljava/lang/String; Z Landroid/content/Context;)V
    return-void 
.end method

.method private final addSection(android.content.Context  int  java.util.List)void
    .registers 11
    # ins_size=4
    invoke-interface v10, Ljava/util/List;->isEmpty()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->contentLayout Landroid/widget/LinearLayout;
    const/4 v1, 0
    const-string v2, "contentLayout"
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    new-instance v3, Landroid/widget/TextView;
    invoke-direct v3, v8, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$style;->Trae_Text_ModelList_Footnote I
    invoke-static v3, v4, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    invoke-virtual v8, v9, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v9
    check-cast v9, Ljava/lang/CharSequence;
    invoke-virtual v3, v9, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    check-cast v3, Landroid/view/View;
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_footnote_footnote_line_height_dp I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    const/4 v5, -1
    invoke-direct v9, v5, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_12 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iput v4, v9, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v9, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v9, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v3, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    iget-object v9, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->contentLayout Landroid/widget/LinearLayout;
    if-nez v9, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v9, v1
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v8, Landroid/view/View;-><init>(Landroid/content/Context;)V
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v8, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    invoke-virtual v0, v3, Landroid/view/View;->setBackgroundColor(I)V
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_action_bar_divider_width I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-direct v3, v5, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    iput v4, v3, Landroid/widget/LinearLayout$LayoutParams;->bottomMargin I
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v3, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v3, v4, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v0, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-interface v10, Ljava/util/List;->iterator()Ljava/util/Iterator;
    move-result-object v9
    invoke-interface v9, Ljava/util/Iterator;->hasNext()Z
    move-result v10
    if-eqz v10, +029h
    invoke-interface v9, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v10
    check-cast v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    iget-object v0, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->contentLayout Landroid/widget/LinearLayout;
    if-nez v0, +006h
    invoke-static v2, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    move-object v0, v1
    invoke-direct v7, v8, v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildModelRow(Landroid/content/Context; Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;)Landroid/view/View;
    move-result-object v10
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v8, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_row_height I
    invoke-virtual v4, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-direct v3, v5, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v3, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v10, v3, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    goto -2ch
    return-void 
.end method

.method private final buildConsumptionRate(android.content.Context  java.math.BigDecimal)android.widget.TextView
    .registers 8
    # ins_size=3
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v6, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/conversation/R$style;->Trae_Text_ModelList_Footnote I
    invoke-static v0, v1, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    sget v1, Lcom/bytedance/trae/conversation/R$string;->imkit_model_discount_rate_format I
    const/4 v2, 1
    new-array v3, v2, [Ljava/lang/Object;
    sget-object v4, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
    invoke-virtual v4, v7, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->formatRateNumber(Ljava/math/BigDecimal;)Ljava/lang/String;
    move-result-object v7
    const/4 v4, 0
    aput-object v7, v3, v4
    invoke-virtual v6, v1, v3, Landroid/content/Context;->getString(I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v6
    check-cast v6, Ljava/lang/CharSequence;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-virtual v0, v2, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v6, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v0, v6, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    return-object v0
.end method

.method private final buildDiscountTag(android.content.Context  com.bytedance.trae.conversation.network.ModelDiscountTag)android.widget.TextView
    .registers 9
    # ins_size=3
    new-instance v0, Landroid/widget/TextView;
    invoke-direct v0, v7, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v1, Lcom/bytedance/trae/conversation/R$style;->Trae_Text_ModelList_Tag I
    invoke-static v0, v1, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    instance-of v1, v8, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;
    const-string v2, "getResources(...)"
    const/4 v3, 0
    if-eqz v1, +024h
    sget-object v1, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v2, Lcom/bytedance/trae/multilanguage/R$string;->business_member_discount I
    const/4 v4, 2
    new-array v4, v4, [Ljava/lang/Object;
    check-cast v8, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;->getDiscountFactor()Ljava/lang/String;
    move-result-object v5
    aput-object v5, v4, v3
    const/4 v5, 1
    invoke-virtual v8, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Member;->getOffPercent()Ljava/lang/String;
    move-result-object v8
    aput-object v8, v4, v5
    invoke-virtual v1, v7, v2, v4, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    goto +1ah
    sget-object v1, Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelDiscountTag$Exclusive;
    invoke-static v8, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v8
    if-eqz v8, +047h
    sget-object v8, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->INSTANCE Lcom/bytedance/trae/multilanguage/I18nTextProvider;
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    invoke-static v7, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    sget v1, Lcom/bytedance/trae/multilanguage/R$string;->business_exclusive_discount I
    new-array v2, v3, [Ljava/lang/Object;
    invoke-virtual v8, v7, v1, v2, Lcom/bytedance/trae/multilanguage/I18nTextProvider;->getString(Landroid/content/res/Resources; I [Ljava/lang/Object;)Ljava/lang/String;
    move-result-object v7
    check-cast v7, Ljava/lang/CharSequence;
    invoke-virtual v0, v7, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/16 v7, 17
    invoke-virtual v0, v7, Landroid/widget/TextView;->setGravity(I)V
    invoke-virtual v0, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_tag_min_width I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    invoke-virtual v0, v7, Landroid/widget/TextView;->setMinWidth(I)V
    invoke-virtual v0, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_tag_padding_start I
    invoke-virtual v7, v8, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    invoke-virtual v0, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_tag_padding_end I
    invoke-virtual v8, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v8
    invoke-virtual v0, v7, v3, v8, v3, Landroid/widget/TextView;->setPadding(I I I I)V
    sget v7, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_model_discount_tag I
    invoke-virtual v0, v7, Landroid/widget/TextView;->setBackgroundResource(I)V
    return-object v0
    new-instance v7, Lkotlin/NoWhenBranchMatchedException;
    invoke-direct v7, Lkotlin/NoWhenBranchMatchedException;-><init>()V
    throw v7
.end method

.method private final buildFallbackModelIcon(android.content.Context)android.widget.ImageView
    .registers 4
    # ins_size=2
    new-instance v0, Landroid/widget/ImageView;
    invoke-direct v0, v3, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-direct v2, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->modelIconColorFilter(Landroid/content/Context;)Landroid/graphics/PorterDuffColorFilter;
    move-result-object v1
    invoke-direct v2, v3, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->tintedModelLogo(Landroid/content/Context; Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/drawable/Drawable;
    move-result-object v3
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V
    sget-object v3, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE Landroid/widget/ImageView$ScaleType;
    invoke-virtual v0, v3, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V
    return-object v0
.end method

.method private final buildModelContent(android.content.Context  com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$ModelRowItem)android.view.View
    .registers 11
    # ins_size=3
    new-instance v0, Landroidx/constraintlayout/widget/ConstraintLayout;
    invoke-direct v0, v9, Landroidx/constraintlayout/widget/ConstraintLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-direct v8, v9, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildModelIcon(Landroid/content/Context; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)Landroid/view/View;
    move-result-object v1
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v2
    invoke-virtual v1, v2, Landroid/view/View;->setId(I)V
    new-instance v2, Landroid/widget/TextView;
    invoke-direct v2, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v3
    invoke-virtual v2, v3, Landroid/widget/TextView;->setId(I)V
    sget v3, Lcom/bytedance/trae/conversation/R$style;->Trae_Text_ModelList_Name I
    invoke-static v2, v3, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getDisplayName()Ljava/lang/String;
    move-result-object v3
    check-cast v3, Ljava/lang/CharSequence;
    invoke-virtual v2, v3, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v2, v4, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    invoke-virtual v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getPricing()Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->getDiscountTag()Lcom/bytedance/trae/conversation/network/ModelDiscountTag;
    move-result-object v10
    if-eqz v10, +00eh
    invoke-direct v8, v9, v10, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildDiscountTag(Landroid/content/Context; Lcom/bytedance/trae/conversation/network/ModelDiscountTag;)Landroid/widget/TextView;
    move-result-object v9
    invoke-static Landroid/view/View;->generateViewId()I
    move-result v10
    invoke-virtual v9, v10, Landroid/widget/TextView;->setId(I)V
    goto +2h
    const/4 v9, 0
    new-instance v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_icon_size I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_icon_size I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    invoke-direct v10, v4, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    const/4 v4, 0
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToStart I
    invoke-virtual v2, Landroid/widget/TextView;->getId()I
    move-result v5
    iput v5, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToStart I
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop I
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom I
    const/4 v5, 2
    iput v5, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->horizontalChainStyle I
    const/4 v5, 0
    iput v5, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->horizontalBias F
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, v10, Landroidx/constraintlayout/widget/ConstraintLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    move-object v10, v2
    check-cast v10, Landroid/view/View;
    new-instance v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    const/4 v6, -2
    invoke-direct v5, v6, v6, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v1, Landroid/view/View;->getId()I
    move-result v1
    iput v1, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToEnd I
    if-nez v9, +005h
    iput v4, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd I
    goto +7h
    invoke-virtual v9, Landroid/widget/TextView;->getId()I
    move-result v1
    iput v1, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToStart I
    iput v4, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop I
    iput v4, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom I
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v7, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    invoke-virtual v1, v7, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    invoke-virtual v5, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->setMarginStart(I)V
    iput-boolean v3, v5, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->constrainedWidth Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v10, v5, Landroidx/constraintlayout/widget/ConstraintLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    if-eqz v9, +035h
    check-cast v9, Landroid/view/View;
    new-instance v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_tag_height I
    invoke-virtual v1, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    invoke-direct v10, v6, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v2, Landroid/widget/TextView;->getId()I
    move-result v1
    iput v1, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->startToEnd I
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->endToEnd I
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->topToTop I
    iput v4, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->bottomToBottom I
    invoke-virtual v0, Landroidx/constraintlayout/widget/ConstraintLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_name_tag_gap I
    invoke-virtual v1, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    invoke-virtual v10, v1, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->setMarginStart(I)V
    iput-boolean v3, v10, Landroidx/constraintlayout/widget/ConstraintLayout$LayoutParams;->constrainedWidth Z
    sget-object v1, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v10, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v9, v10, Landroidx/constraintlayout/widget/ConstraintLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private final buildModelIcon(android.content.Context  com.bytedance.trae.conversation.network.RemoteModelItem)android.view.View
    .registers 8
    # ins_size=3
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +009h
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildFallbackModelIcon(Landroid/content/Context;)Landroid/widget/ImageView;
    move-result-object v6
    check-cast v6, Landroid/view/View;
    return-object v6
    sget-object v0, Lcom/bytedance/trae/common/theme/ThemeManager;->INSTANCE Lcom/bytedance/trae/common/theme/ThemeManager;
    invoke-virtual v0, Lcom/bytedance/trae/common/theme/ThemeManager;->isDarkMode()Z
    move-result v0
    if-eqz v0, +00dh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getIconDark()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +011h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getIconLight()Ljava/lang/String;
    move-result-object v0
    goto +bh
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getIconLight()Ljava/lang/String;
    move-result-object v0
    if-nez v0, +006h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getIconDark()Ljava/lang/String;
    move-result-object v0
    move-object v7, v0
    check-cast v7, Ljava/lang/CharSequence;
    const/4 v1, 1
    if-eqz v7, +00bh
    invoke-static v7, Lkotlin/text/StringsKt;->isBlank(Ljava/lang/CharSequence;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    const/4 v7, 0
    goto +2h
    move v7, v1
    if-eqz v7, +009h
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildFallbackModelIcon(Landroid/content/Context;)Landroid/widget/ImageView;
    move-result-object v6
    check-cast v6, Landroid/view/View;
    return-object v6
    new-instance v7, Lcom/facebook/drawee/view/SimpleDraweeView;
    invoke-direct v7, v6, Lcom/facebook/drawee/view/SimpleDraweeView;-><init>(Landroid/content/Context;)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->modelIconColorFilter(Landroid/content/Context;)Landroid/graphics/PorterDuffColorFilter;
    move-result-object v2
    invoke-virtual v6, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-static v3, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->newInstance(Landroid/content/res/Resources;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v3
    sget-object v4, Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;->FIT_CENTER Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;
    invoke-virtual v3, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setActualImageScaleType(Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v3
    move-object v4, v2
    check-cast v4, Landroid/graphics/ColorFilter;
    invoke-virtual v3, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setActualImageColorFilter(Landroid/graphics/ColorFilter;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v3
    invoke-direct v5, v6, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->tintedModelLogo(Landroid/content/Context; Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/drawable/Drawable;
    move-result-object v4
    invoke-virtual v3, v4, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setPlaceholderImage(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v3
    invoke-direct v5, v6, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->tintedModelLogo(Landroid/content/Context; Landroid/graphics/PorterDuffColorFilter;)Landroid/graphics/drawable/Drawable;
    move-result-object v6
    invoke-virtual v3, v6, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->setFailureImage(Landroid/graphics/drawable/Drawable;)Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;
    move-result-object v6
    invoke-virtual v6, Lcom/facebook/drawee/generic/GenericDraweeHierarchyBuilder;->build()Lcom/facebook/drawee/generic/GenericDraweeHierarchy;
    move-result-object v6
    check-cast v6, Lcom/facebook/drawee/interfaces/DraweeHierarchy;
    invoke-virtual v7, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setHierarchy(Lcom/facebook/drawee/interfaces/DraweeHierarchy;)V
    invoke-direct v5, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->isSvgUrl(Ljava/lang/String;)Z
    move-result v6
    if-eqz v6, +006h
    const/4 v6, 0
    invoke-virtual v7, v1, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setLayerType(I Landroid/graphics/Paint;)V
    invoke-static v0, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v6
    invoke-virtual v7, v6, Lcom/facebook/drawee/view/SimpleDraweeView;->setImageURI(Landroid/net/Uri;)V
    check-cast v7, Landroid/view/View;
    return-object v7
.end method

.method private final buildModelRow(android.content.Context  com.bytedance.trae.conversation.widget.ModelSelectBottomSheet$ModelRowItem)android.view.View
    .registers 10
    # ins_size=3
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v0
    new-instance v1, Landroid/widget/LinearLayout;
    invoke-direct v1, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/16 v2, 16
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    const/4 v2, 0
    invoke-virtual v1, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_16 I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v1, v3, v2, v3, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;
    invoke-direct v3, v7, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Lcom/bytedance/trae/conversation/network/RemoteModelItem;)V
    invoke-virtual v1, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-direct v7, v8, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildModelContent(Landroid/content/Context; Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;)Landroid/view/View;
    move-result-object v3
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v5, 1065353216
    const/4 v6, -2
    invoke-direct v4, v2, v6, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getPricing()Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->getConsumptionRate()Ljava/math/BigDecimal;
    move-result-object v3
    if-eqz v3, +021h
    invoke-direct v7, v8, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->buildConsumptionRate(Landroid/content/Context; Ljava/math/BigDecimal;)Landroid/widget/TextView;
    move-result-object v3
    check-cast v3, Landroid/view/View;
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v6, v6, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_content_rate_gap I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    invoke-virtual v4, v5, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v5, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v3, Landroid/widget/ImageView;
    invoke-direct v3, v8, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/conversation/R$drawable;->ic_checkmark I
    invoke-virtual v3, v4, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v0
    iget-object v4, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    invoke-static v0, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    const/4 v2, 4
    invoke-virtual v3, v2, Landroid/widget/ImageView;->setVisibility(I)V
    sget v0, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_brand I
    invoke-static v8, v0, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-virtual v3, v8, Landroid/widget/ImageView;->setColorFilter(I)V
    check-cast v3, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_icon_size I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_icon_size I
    invoke-virtual v2, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    invoke-direct v8, v0, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    invoke-virtual v1, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getPricing()Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    move-result-object v9
    invoke-virtual v9, Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;->getConsumptionRate()Ljava/math/BigDecimal;
    move-result-object v9
    if-nez v9, +005h
    sget v9, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_8 I
    goto +3h
    sget v9, Lcom/bytedance/trae/conversation/R$dimen;->trae_model_list_content_rate_gap I
    invoke-virtual v0, v9, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v9
    invoke-virtual v8, v9, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    sget-object v9, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v1, v3, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v1, Landroid/view/View;
    return-object v1
.end method

.method private static final buildModelRow$lambda$28$lambda$23(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  com.bytedance.trae.conversation.network.RemoteModelItem  android.view.View)void
    .registers 3
    # ins_size=3
    iget-object v2, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelSelected Lkotlin/jvm/functions/Function1;
    if-eqz v2, +005h
    invoke-interface v2, v1, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private final isSvgUrl(java.lang.String)boolean
    .registers 5
    # ins_size=2
    invoke-static v4, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;
    move-result-object v4
    invoke-virtual v4, Landroid/net/Uri;->getPath()Ljava/lang/String;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +00ch
    const-string v1, ".svg"
    const/4 v2, 1
    invoke-static v4, v1, v2, Lkotlin/text/StringsKt;->endsWith(Ljava/lang/String; Ljava/lang/String; Z)Z
    move-result v4
    if-ne v4, v2, +003h
    move v0, v2
    return v0
.end method

.method private final loadModels()void
    .registers 16
    # ins_size=1
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string v2, "loadModels: start, cliType="
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v2, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", chatMode="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", cliId="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliId Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    const-string v2, ", ideVersion="
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    iget-object v2, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->ideVersion Ljava/lang/String;
    invoke-virtual v1, v2, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v1
    invoke-virtual v1, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v1
    const-string v2, "ModelSelectBottomSheet"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getContext()Landroid/content/Context;
    move-result-object v0
    if-nez v0, +00dh
    move-object v0, v15
    check-cast v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    const-string v1, "loadModels: skip, fragment context is null"
    invoke-virtual v0, v2, v1, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    return-void 
    invoke-direct v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->resolveFunctions()Ljava/util/List;
    move-result-object v5
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v1
    if-eqz v1, +00dh
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v1
    goto +bh
    sget-object v1, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi;->Companion Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;
    iget-object v2, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    iget-object v3, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliId Ljava/lang/String;
    invoke-virtual v1, v2, v3, v5, Lcom/bytedance/trae/conversation/network/IRemoteModelsApi$Companion;->getCachedModelsForUi(Lcom/bytedance/trae/im/service/CliType; Ljava/lang/String; Ljava/util/List;)Ljava/util/List;
    move-result-object v1
    move-object v7, v1
    const/4 v1, 0
    if-eqz v7, +007h
    const-string v2, "cache"
    invoke-direct v15, v7, v2, v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->updateModelList(Ljava/util/List; Ljava/lang/String; Z Landroid/content/Context;)V
    invoke-interface v5, Ljava/util/List;->isEmpty()Z
    move-result v2
    const/4 v3, 0
    const-string v4, "progressBar"
    const/16 v6, 8
    const/4 v8, 1
    if-eqz v2, +020h
    iget-object v1, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    if-nez v1, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v1
    invoke-virtual v3, v6, Landroid/widget/ProgressBar;->setVisibility(I)V
    if-nez v7, +00ch
    sget-object v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-static v1, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v7
    const-string v1, "local"
    invoke-direct v15, v7, v1, v8, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->updateModelList(Ljava/util/List; Ljava/lang/String; Z Landroid/content/Context;)V
    return-void 
    if-eqz v7, +003h
    goto +2h
    move v8, v1
    iget-object v0, v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    if-nez v0, +006h
    invoke-static v4, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    goto +2h
    move-object v3, v0
    if-eqz v8, +003h
    move v1, v6
    invoke-virtual v3, v1, Landroid/widget/ProgressBar;->setVisibility(I)V
    invoke-virtual v15, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getViewLifecycleOwner()Landroidx/lifecycle/LifecycleOwner;
    move-result-object v0
    const-string v1, "getViewLifecycleOwner(...)"
    invoke-static v0, v1, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-static v0, Landroidx/lifecycle/LifecycleOwnerKt;->getLifecycleScope(Landroidx/lifecycle/LifecycleOwner;)Landroidx/lifecycle/LifecycleCoroutineScope;
    move-result-object v0
    move-object v9, v0
    check-cast v9, Lkotlinx/coroutines/CoroutineScope;
    const/4 v10, 0
    const/4 v11, 0
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;
    const/4 v1, 0
    move-object v3, v0
    move-object v4, v15
    move v6, v8
    move-object v8, v1
    invoke-direct/range v3 ... v8, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$loadModels$1;-><init>(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet; Ljava/util/List; Z Ljava/util/List; Lkotlin/coroutines/Continuation;)V
    move-object v12, v0
    check-cast v12, Lkotlin/jvm/functions/Function2;
    const/4 v13, 3
    const/4 v14, 0
    invoke-static/range v9 ... v14, Lkotlinx/coroutines/BuildersKt;->launch$default(Lkotlinx/coroutines/CoroutineScope; Lkotlin/coroutines/CoroutineContext; Lkotlinx/coroutines/CoroutineStart; Lkotlin/jvm/functions/Function2; I Ljava/lang/Object;)Lkotlinx/coroutines/Job;
    return-void 
.end method

.method private final modelIconColorFilter(android.content.Context)android.graphics.PorterDuffColorFilter
    .registers 4
    # ins_size=2
    new-instance v0, Landroid/graphics/PorterDuffColorFilter;
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v3, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v3
    sget-object v1, Landroid/graphics/PorterDuff$Mode;->SRC_IN Landroid/graphics/PorterDuff$Mode;
    invoke-direct v0, v3, v1, Landroid/graphics/PorterDuffColorFilter;-><init>(I Landroid/graphics/PorterDuff$Mode;)V
    return-object v0
.end method

.method private static final onCreateDialog$lambda$2(com.google.android.material.bottomsheet.BottomSheetDialog  com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  android.content.DialogInterface)void
    .registers 4
    # ins_size=3
    sget v3, Lcom/google/android/material/R$id;->design_bottom_sheet I
    invoke-virtual v1, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +030h
    const v3, 17170445
    invoke-virtual v1, v3, Landroid/view/View;->setBackgroundResource(I)V
    invoke-static v1, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->from(Landroid/view/View;)Lcom/google/android/material/bottomsheet/BottomSheetBehavior;
    move-result-object v3
    invoke-virtual v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v2
    iget v2, v2, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v2, v2
    const v0, 1064514355
    mul-float/2addr v2, v0
    float-to-int v2, v2
    invoke-virtual v3, v2, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setPeekHeight(I)V
    const/4 v0, 3
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setState(I)V
    const/4 v0, 1
    invoke-virtual v3, v0, Lcom/google/android/material/bottomsheet/BottomSheetBehavior;->setSkipCollapsed(Z)V
    invoke-virtual v1, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v3
    iput v2, v3, Landroid/view/ViewGroup$LayoutParams;->height I
    invoke-virtual v1, v3, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    return-void 
.end method

.method private static final onCreateView$lambda$5$lambda$4(com.bytedance.trae.conversation.widget.ModelSelectBottomSheet  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->dismissAllowingStateLoss()V
    return-void 
.end method

.method private final renderModels(java.util.List  android.content.Context)void
    .registers 7
    # ins_size=3
    iget-object v0, v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->contentLayout Landroid/widget/LinearLayout;
    if-nez v0, +008h
    const-string v0, "contentLayout"
    invoke-static v0, Lkotlin/jvm/internal/Intrinsics;->throwUninitializedPropertyAccessException(Ljava/lang/String;)V
    const/4 v0, 0
    invoke-virtual v0, Landroid/widget/LinearLayout;->removeAllViews()V
    check-cast v5, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-direct v0, Ljava/util/ArrayList;-><init>()V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +017h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin()Z
    move-result v3
    if-eqz v3, -015h
    invoke-interface v0, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ah
    check-cast v0, Ljava/util/List;
    new-instance v1, Ljava/util/ArrayList;
    invoke-direct v1, Ljava/util/ArrayList;-><init>()V
    check-cast v1, Ljava/util/Collection;
    invoke-interface v5, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v5
    invoke-interface v5, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +019h
    invoke-interface v5, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    move-object v3, v2
    check-cast v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v3
    invoke-virtual v3, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->isBuiltin()Z
    move-result v3
    xor-int/lit8 v3, v3, 1
    if-eqz v3, -017h
    invoke-interface v1, v2, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -1ch
    check-cast v1, Ljava/util/List;
    sget v5, Lcom/bytedance/trae/conversation/R$string;->imkit_model_builtin_models I
    invoke-direct v4, v6, v5, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->addSection(Landroid/content/Context; I Ljava/util/List;)V
    move-object v5, v1
    check-cast v5, Ljava/util/Collection;
    invoke-interface v5, Ljava/util/Collection;->isEmpty()Z
    move-result v5
    xor-int/lit8 v5, v5, 1
    if-eqz v5, +007h
    sget v5, Lcom/bytedance/trae/conversation/R$string;->imkit_model_custom_models I
    invoke-direct v4, v6, v5, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->addSection(Landroid/content/Context; I Ljava/util/List;)V
    return-void 
.end method

.method private final resolveFunctions()java.util.List
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +00ah
    const-string/jumbo v0, solo_agent
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +55h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v0, solo_agent_lite
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +41h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v0, solo_work_lite
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +2dh
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v0, solo_agent_remote
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +19h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    if-ne v0, v1, +010h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    sget-object v1, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    if-ne v0, v1, +00ah
    const-string/jumbo v0, solo_work_remote
    invoke-static v0, Lkotlin/collections/CollectionsKt;->listOf(Ljava/lang/Object;)Ljava/util/List;
    move-result-object v0
    goto +5h
    invoke-static Lkotlin/collections/CollectionsKt;->emptyList()Ljava/util/List;
    move-result-object v0
    return-object v0
.end method

.method private final tintedModelLogo(android.content.Context  android.graphics.PorterDuffColorFilter)android.graphics.drawable.Drawable
    .registers 4
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->logo I
    invoke-static v2, v0, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v2
    if-eqz v2, +00eh
    invoke-virtual v2, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;
    move-result-object v2
    if-eqz v2, +008h
    check-cast v3, Landroid/graphics/ColorFilter;
    invoke-virtual v2, v3, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V
    goto +2h
    const/4 v2, 0
    return-object v2
.end method

.method private final updateModelList(java.util.List  java.lang.String  boolean  android.content.Context)void
    .registers 14
    # ins_size=5
    sget-object v0, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->INSTANCE Lcom/bytedance/trae/utils/logger/TraeLogUtil;
    new-instance v1, Ljava/lang/StringBuilder;
    const-string/jumbo v2, updateModelList: source=
    invoke-direct v1, v2, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    invoke-virtual v1, v11, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v1, ", count="
    invoke-virtual v11, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-interface v10, Ljava/util/List;->size()I
    move-result v1
    invoke-virtual v11, v1, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;
    move-result-object v11
    const-string v1, ", names="
    invoke-virtual v11, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v11
    move-object v1, v10
    check-cast v1, Ljava/lang/Iterable;
    const/4 v2, 6
    invoke-static v1, v2, Lkotlin/collections/CollectionsKt;->take(Ljava/lang/Iterable; I)Ljava/util/List;
    move-result-object v2
    check-cast v2, Ljava/lang/Iterable;
    new-instance v3, Ljava/util/ArrayList;
    const/16 v4, 10
    invoke-static v2, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v5
    invoke-direct v3, v5, Ljava/util/ArrayList;-><init>(I)V
    check-cast v3, Ljava/util/Collection;
    invoke-interface v2, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v2
    invoke-interface v2, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +010h
    invoke-interface v2, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getName()Ljava/lang/String;
    move-result-object v5
    invoke-interface v3, v5, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v3, Ljava/util/List;
    invoke-virtual v11, v3, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v11
    invoke-virtual v11, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v11
    const-string v2, "ModelSelectBottomSheet"
    invoke-virtual v0, v2, v11, Lcom/bytedance/trae/utils/logger/TraeLogUtil;->i(Ljava/lang/String; Ljava/lang/String;)V
    sget-object v11, Lcom/bytedance/trae/common/apphost/AppHost;->Companion Lcom/bytedance/trae/common/apphost/AppHost$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/common/apphost/AppHost$Companion;->isOversea()Z
    move-result v11
    const/4 v0, 0
    const/4 v2, 0
    const/4 v3, 1
    if-nez v11, +0f9h
    sget-object v11, Lcom/bytedance/trae/conversation/LoginUtils;->INSTANCE Lcom/bytedance/trae/conversation/LoginUtils;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/LoginUtils;->shouldSkipTocCommercialFeatures()Z
    move-result v11
    if-nez v11, +0f1h
    invoke-static Lcom/bytedance/trae/conversation/chat/UserPayIdentityService;->getUserPayIdentity()I
    move-result v10
    new-instance v11, Ljava/util/ArrayList;
    invoke-direct v11, Ljava/util/ArrayList;-><init>()V
    check-cast v11, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v1
    invoke-interface v1, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, +069h
    invoke-interface v1, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    sget-object v6, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getFeatures()Ljava/lang/String;
    move-result-object v7
    invoke-virtual v6, v7, Lcom/bytedance/trae/conversation/network/ModelFeaturesParser;->parse(Ljava/lang/String;)Lcom/bytedance/trae/conversation/network/ModelFeatures;
    move-result-object v6
    if-eqz v6, +010h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getAccess()Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    move-result-object v7
    if-eqz v7, +00ah
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;->getEnable()Z
    move-result v7
    if-ne v7, v3, +004h
    move v7, v3
    goto +2h
    move v7, v2
    if-eqz v7, +030h
    invoke-virtual v6, Lcom/bytedance/trae/conversation/network/ModelFeatures;->getAccess()Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;
    move-result-object v7
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/ModelFeatureAccess;->getData()Lcom/bytedance/trae/conversation/network/ModelFeatureAccessData;
    move-result-object v7
    if-eqz v7, +007h
    invoke-virtual v7, Lcom/bytedance/trae/conversation/network/ModelFeatureAccessData;->getIdentityList()Ljava/util/List;
    move-result-object v7
    goto +2h
    move-object v7, v0
    move-object v8, v7
    check-cast v8, Ljava/util/Collection;
    if-eqz v8, +00bh
    invoke-interface v8, Ljava/util/Collection;->isEmpty()Z
    move-result v8
    if-eqz v8, +003h
    goto +3h
    move v8, v2
    goto +2h
    move v8, v3
    if-nez v8, +00fh
    invoke-static v10, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v8
    invoke-interface v7, v8, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    move-result v7
    if-eqz v7, +003h
    goto +3h
    move v7, v2
    goto +2h
    move v7, v3
    if-nez v7, +004h
    move-object v7, v0
    goto +ch
    new-instance v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    sget-object v8, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->INSTANCE Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;
    invoke-virtual v8, v6, Lcom/bytedance/trae/conversation/network/ModelPricingPolicy;->resolve(Lcom/bytedance/trae/conversation/network/ModelFeatures;)Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;
    move-result-object v6
    invoke-direct v7, v5, v6, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;-><init>(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Lcom/bytedance/trae/conversation/network/ModelPricingPresentation;)V
    if-eqz v7, -067h
    invoke-interface v11, v7, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -6ch
    check-cast v11, Ljava/util/List;
    move-object v10, v11
    check-cast v10, Ljava/lang/Iterable;
    new-instance v0, Ljava/util/ArrayList;
    invoke-static v10, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v1
    invoke-direct v0, v1, Ljava/util/ArrayList;-><init>(I)V
    check-cast v0, Ljava/util/Collection;
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, +010h
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;->getModel()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v1
    invoke-interface v0, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -13h
    check-cast v0, Ljava/util/List;
    move-object v10, v0
    check-cast v10, Ljava/lang/Iterable;
    instance-of v1, v10, Ljava/util/Collection;
    if-eqz v1, +00dh
    move-object v1, v10
    check-cast v1, Ljava/util/Collection;
    invoke-interface v1, Ljava/util/Collection;->isEmpty()Z
    move-result v1
    if-eqz v1, +004h
    move v2, v3
    goto +1dh
    invoke-interface v10, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v10
    invoke-interface v10, Ljava/util/Iterator;->hasNext()Z
    move-result v1
    if-eqz v1, -00ah
    invoke-interface v10, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v1
    iget-object v4, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, -016h
    if-eqz v2, +00eh
    sget-object v10, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v10
    invoke-virtual v10, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v10
    iput-object v10, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    if-eqz v12, +009h
    iget-object v10, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelListLoaded Lkotlin/jvm/functions/Function1;
    if-eqz v10, +005h
    invoke-interface v10, v0, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    invoke-direct v9, v11, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->renderModels(Ljava/util/List; Landroid/content/Context;)V
    goto +6dh
    instance-of v11, v1, Ljava/util/Collection;
    if-eqz v11, +00dh
    move-object v11, v1
    check-cast v11, Ljava/util/Collection;
    invoke-interface v11, Ljava/util/Collection;->isEmpty()Z
    move-result v11
    if-eqz v11, +004h
    move v2, v3
    goto +1dh
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v5
    if-eqz v5, -00ah
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v5
    check-cast v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    invoke-virtual v5, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v5
    iget-object v6, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    invoke-static v5, v6, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-eqz v5, -016h
    if-eqz v2, +00eh
    sget-object v11, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v11
    invoke-virtual v11, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v11
    iput-object v11, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    if-eqz v12, +009h
    iget-object v11, v9, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelListLoaded Lkotlin/jvm/functions/Function1;
    if-eqz v11, +005h
    invoke-interface v11, v10, Lkotlin/jvm/functions/Function1;->invoke(Ljava/lang/Object;)Ljava/lang/Object;
    new-instance v10, Ljava/util/ArrayList;
    invoke-static v1, v4, Lkotlin/collections/CollectionsKt;->collectionSizeOrDefault(Ljava/lang/Iterable; I)I
    move-result v11
    invoke-direct v10, v11, Ljava/util/ArrayList;-><init>(I)V
    check-cast v10, Ljava/util/Collection;
    invoke-interface v1, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v11
    invoke-interface v11, Ljava/util/Iterator;->hasNext()Z
    move-result v12
    if-eqz v12, +012h
    invoke-interface v11, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v12
    check-cast v12, Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    new-instance v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;
    const/4 v2, 2
    invoke-direct v1, v12, v0, v2, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelRowItem;-><init>(Lcom/bytedance/trae/conversation/network/RemoteModelItem; Lcom/bytedance/trae/conversation/network/ModelPricingPresentation; I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    invoke-interface v10, v1, Ljava/util/Collection;->add(Ljava/lang/Object;)Z
    goto -15h
    check-cast v10, Ljava/util/List;
    invoke-direct v9, v10, v13, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->renderModels(Ljava/util/List; Landroid/content/Context;)V
    return-void 
.end method

.method public final getOnModelListLoaded()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelListLoaded Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public final getOnModelSelected()kotlin.jvm.functions.Function1
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelSelected Lkotlin/jvm/functions/Function1;
    return-object v0
.end method

.method public onCreate(android.os.Bundle)void
    .registers 5
    # ins_size=2
    invoke-super v3, v4, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreate(Landroid/os/Bundle;)V
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +00bh
    const-string/jumbo v0, selected_model_id
    invoke-virtual v4, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    if-nez v4, +00ch
    sget-object v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->Companion Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem$Companion;->auto()Lcom/bytedance/trae/conversation/network/RemoteModelItem;
    move-result-object v4
    invoke-virtual v4, Lcom/bytedance/trae/conversation/network/RemoteModelItem;->getId()Ljava/lang/String;
    move-result-object v4
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->selectedModelId Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    const/4 v0, 0
    if-eqz v4, +009h
    const-string v1, "cli_type"
    invoke-virtual v4, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-eqz v1, +005h
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->LOCAL Lcom/bytedance/trae/im/service/CliType;
    goto +12h
    sget-object v1, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v1, Lcom/bytedance/trae/im/service/CliType;->getValue()Ljava/lang/String;
    move-result-object v1
    invoke-static v4, v1, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->IDE Lcom/bytedance/trae/im/service/CliType;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/im/service/CliType;->REMOTE Lcom/bytedance/trae/im/service/CliType;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliType Lcom/bytedance/trae/im/service/CliType;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v1, "chat_mode"
    invoke-virtual v4, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-eqz v4, +017h
    invoke-virtual v4, Ljava/lang/String;->hashCode()I
    move-result v1
    const v2, 2074093
    if-eq v1, v2, +003h
    goto +ch
    const-string v1, "CODE"
    invoke-virtual v4, v1, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    move-result v4
    if-eqz v4, +005h
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->CODE Lcom/bytedance/trae/conversation/widget/ChatMode;
    goto +3h
    sget-object v4, Lcom/bytedance/trae/conversation/widget/ChatMode;->MTC Lcom/bytedance/trae/conversation/widget/ChatMode;
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->chatMode Lcom/bytedance/trae/conversation/widget/ChatMode;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +009h
    const-string v1, "cli_id"
    invoke-virtual v4, v1, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    goto +2h
    move-object v4, v0
    if-nez v4, +004h
    const-string v4, ""
    iput-object v4, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->cliId Ljava/lang/String;
    invoke-virtual v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->getArguments()Landroid/os/Bundle;
    move-result-object v4
    if-eqz v4, +008h
    const-string v0, "ide_version"
    invoke-virtual v4, v0, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    iput-object v0, v3, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->ideVersion Ljava/lang/String;
    return-void 
.end method

.method public onCreateDialog(android.os.Bundle)android.app.Dialog
    .registers 3
    # ins_size=2
    invoke-super v1, v2, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    move-result-object v2
    const-string v0, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v2, Lcom/google/android/material/bottomsheet/BottomSheetDialog;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda0;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda0;-><init>(Lcom/google/android/material/bottomsheet/BottomSheetDialog; Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)V
    invoke-virtual v2, v0, Lcom/google/android/material/bottomsheet/BottomSheetDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V
    check-cast v2, Landroid/app/Dialog;
    return-object v2
.end method

.method public onCreateView(android.view.LayoutInflater  android.view.ViewGroup  android.os.Bundle)android.view.View
    .registers 11
    # ins_size=4
    const-string v9, "inflater"
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->requireContext()Landroid/content/Context;
    move-result-object v8
    const-string/jumbo v9, requireContext(...)
    invoke-static v8, v9, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v9, Landroid/widget/LinearLayout;
    invoke-direct v9, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v10, 1
    invoke-virtual v9, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v0, Lcom/bytedance/trae/conversation/R$drawable;->trae_bg_bottom_sheet_rounded I
    invoke-virtual v9, v0, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v6, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    const/4 v2, 0
    const/4 v3, 0
    const/4 v4, 6
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;-><init>(Landroid/content/Context; Landroid/util/AttributeSet; I I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;->SHEET Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode;
    const/4 v1, 2
    invoke-static v6, v0, v3, v1, v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setMode$default(Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/bytedance/trae/common/widget/TraeTitleBar$Mode; Z I Ljava/lang/Object;)V
    sget v0, Lcom/bytedance/trae/conversation/R$string;->imkit_model_title I
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setTitle(I)V
    sget-object v0, Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;->CLOSE Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setRightAction(Lcom/bytedance/trae/common/widget/TraeTitleBar$Action;)V
    new-instance v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda1;
    invoke-direct v0, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;)V
    invoke-virtual v6, v0, Lcom/bytedance/trae/common/widget/TraeTitleBar;->setOnRightActionClickListener(Landroid/view/View$OnClickListener;)V
    check-cast v6, Landroid/view/View;
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v1, -1
    const/4 v2, -2
    invoke-direct v0, v1, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v0, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v6, v0, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/FrameLayout;
    invoke-direct v0, v8, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    new-instance v4, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;
    invoke-direct v4, v8, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/LinearLayout;
    invoke-direct v5, v8, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v5, v10, Landroid/widget/LinearLayout;->setOrientation(I)V
    invoke-virtual v5, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_dp_24 I
    invoke-virtual v10, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v10
    invoke-virtual v5, v3, v3, v3, v10, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    iput-object v5, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->contentLayout Landroid/widget/LinearLayout;
    check-cast v5, Landroid/view/View;
    invoke-virtual v4, v5, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet$ModelListScrollView;->addView(Landroid/view/View;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v0, v4, v1, v1, Landroid/widget/FrameLayout;->addView(Landroid/view/View; I I)V
    new-instance v10, Landroid/widget/ProgressBar;
    invoke-direct v10, v8, Landroid/widget/ProgressBar;-><init>(Landroid/content/Context;)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_tertiary I
    invoke-static v8, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v8
    invoke-static v8, Landroid/content/res/ColorStateList;->valueOf(I)Landroid/content/res/ColorStateList;
    move-result-object v8
    invoke-virtual v10, v8, Landroid/widget/ProgressBar;->setIndeterminateTintList(Landroid/content/res/ColorStateList;)V
    const/16 v8, 8
    invoke-virtual v10, v8, Landroid/widget/ProgressBar;->setVisibility(I)V
    iput-object v10, v7, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->progressBar Landroid/widget/ProgressBar;
    check-cast v10, Landroid/view/View;
    new-instance v8, Landroid/widget/FrameLayout$LayoutParams;
    const/16 v4, 17
    invoke-direct v8, v2, v2, v4, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I I)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v10, v8, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v0, Landroid/view/View;
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v10, 1065353216
    invoke-direct v8, v1, v3, v10, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    check-cast v8, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v0, v8, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    check-cast v9, Landroid/view/View;
    return-object v9
.end method

.method public onViewCreated(android.view.View  android.os.Bundle)void
    .registers 4
    # ins_size=3
    const-string/jumbo v0, view
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-super v1, v2, v3, Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;->onViewCreated(Landroid/view/View; Landroid/os/Bundle;)V
    invoke-direct v1, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->loadModels()V
    return-void 
.end method

.method public final setOnModelListLoaded(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelListLoaded Lkotlin/jvm/functions/Function1;
    return-void 
.end method

.method public final setOnModelSelected(kotlin.jvm.functions.Function1)void
    .registers 2
    # ins_size=2
    iput-object v1, v0, Lcom/bytedance/trae/conversation/widget/ModelSelectBottomSheet;->onModelSelected Lkotlin/jvm/functions/Function1;
    return-void 
.end method
