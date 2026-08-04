# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;
.super Ljava/lang/Object;
.source "UpgradeReminderViewHolder.kt"


.method private constructor <init>()void
    .registers 1
    # ins_size=1
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    return-void 
.end method

.method public synthetic constructor <init>(kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 2
    # ins_size=2
    invoke-direct v0, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;-><init>()V
    return-void 
.end method

.method public static synthetic createView$default(com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder$Companion  android.content.Context  boolean  int  java.lang.Object)com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView(Landroid/content/Context; Z)Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    move-result-object v0
    return-object v0
.end method

.method private static final createView$dimen(android.content.res.Resources  int)int
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    return v0
.end method

.method private static final createView$dimenFloat(android.content.res.Resources  int)float
    .registers 2
    # ins_size=2
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimension(I)F
    move-result v0
    return v0
.end method

.method public final create(android.view.ViewGroup)com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder
    .registers 5
    # ins_size=2
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;
    move-result-object v4
    const-string v0, "getContext(...)"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 2
    const/4 v1, 0
    const/4 v2, 0
    invoke-static v3, v4, v2, v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$default(Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion; Landroid/content/Context; Z I Ljava/lang/Object;)Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    move-result-object v4
    return-object v4
.end method

.method public final createView(android.content.Context  boolean)com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder
    .registers 16
    # ins_size=3
    const-string v0, "context"
    invoke-static v14, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    const/4 v1, 0
    if-eqz v15, +009h
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_outer_padding_horizontal I
    invoke-static v0, v15, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v15
    goto +2h
    move v15, v1
    new-instance v2, Landroid/widget/LinearLayout;
    invoke-direct v2, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v3, 1
    invoke-virtual v2, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_outer_padding_top I
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v4
    sget v5, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_outer_padding_bottom I
    invoke-static v0, v5, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v5
    invoke-virtual v2, v15, v4, v15, v5, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v15, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;
    const/4 v4, -1
    const/4 v5, -2
    invoke-direct v15, v4, v5, Landroidx/recyclerview/widget/RecyclerView$LayoutParams;-><init>(I I)V
    check-cast v15, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v15, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v8, Landroid/widget/LinearLayout;
    invoke-direct v8, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    sget v15, Lcom/bytedance/trae/conversation/R$id;->upgrade_reminder_card I
    invoke-virtual v8, v15, Landroid/widget/LinearLayout;->setId(I)V
    invoke-virtual v8, v3, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_padding_horizontal I
    invoke-static v0, v15, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v15
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_padding_vertical I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v6
    sget v7, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_padding_horizontal I
    invoke-static v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v7
    sget v9, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_padding_vertical I
    invoke-static v0, v9, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v9
    invoke-virtual v8, v15, v6, v7, v9, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    new-instance v15, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v15, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_radius I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimenFloat(Landroid/content/res/Resources; I)F
    move-result v6
    invoke-virtual v15, v6, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v6, Lcom/bytedance/trae/conversation/R$color;->trae_upgrade_reminder_bg I
    invoke-static v14, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v15, v6, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_card_border_width I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v6
    invoke-static v6, v3, Lkotlin/ranges/RangesKt;->coerceAtLeast(I I)I
    move-result v6
    sget v7, Lcom/bytedance/trae/conversation/R$color;->trae_upgrade_reminder_border I
    invoke-static v14, v7, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v15, v6, v7, Landroid/graphics/drawable/GradientDrawable;->setStroke(I I)V
    check-cast v15, Landroid/graphics/drawable/Drawable;
    invoke-virtual v8, v15, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    move-object v15, v8
    check-cast v15, Landroid/view/View;
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v2, v15, v6, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v9, Landroid/widget/TextView;
    invoke-direct v9, v14, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v15, Lcom/bytedance/trae/conversation/R$color;->trae_upgrade_reminder_title_text I
    invoke-static v14, v15, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v15
    invoke-virtual v9, v15, Landroid/widget/TextView;->setTextColor(I)V
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_title_text_size I
    invoke-static v0, v15, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimenFloat(Landroid/content/res/Resources; I)F
    move-result v15
    invoke-virtual v9, v1, v15, Landroid/widget/TextView;->setTextSize(I F)V
    const-string/jumbo v15, sans-serif-medium
    invoke-static v15, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v6
    invoke-virtual v9, v6, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v9, v3, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_title_line_height I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v6
    invoke-static v9, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    move-object v6, v9
    check-cast v6, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v6, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v10, Landroid/widget/TextView;
    invoke-direct v10, v14, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_secondary I
    invoke-static v14, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v10, v6, Landroid/widget/TextView;->setTextColor(I)V
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_body_text_size I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimenFloat(Landroid/content/res/Resources; I)F
    move-result v6
    invoke-virtual v10, v1, v6, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-virtual v10, v3, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    sget v6, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_body_line_height I
    invoke-static v0, v6, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v6
    invoke-static v10, v6, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    move-object v6, v10
    check-cast v6, Landroid/view/View;
    new-instance v7, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v7, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    sget v11, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_body_margin_top I
    invoke-static v0, v11, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v11
    iput v11, v7, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v11, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v7, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v6, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v6, Landroid/widget/LinearLayout;
    invoke-direct v6, v14, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const v7, 8388613
    invoke-virtual v6, v7, Landroid/widget/LinearLayout;->setGravity(I)V
    move-object v7, v6
    check-cast v7, Landroid/view/View;
    new-instance v11, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v11, v4, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_actions_margin_top I
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v4
    iput v4, v11, Landroid/widget/LinearLayout$LayoutParams;->topMargin I
    sget-object v4, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    check-cast v11, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v8, v7, v11, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v11, Landroid/widget/TextView;
    invoke-direct v11, v14, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    const/16 v4, 17
    invoke-virtual v11, v4, Landroid/widget/TextView;->setGravity(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_height I
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v4
    invoke-virtual v11, v4, Landroid/widget/TextView;->setMinHeight(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_padding_horizontal I
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v4
    sget v7, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_padding_horizontal I
    invoke-static v0, v7, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v7
    invoke-virtual v11, v4, v1, v7, v1, Landroid/widget/TextView;->setPadding(I I I I)V
    sget v4, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_onaccent I
    invoke-static v14, v4, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v4
    invoke-virtual v11, v4, Landroid/widget/TextView;->setTextColor(I)V
    sget v4, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_text_size I
    invoke-static v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimenFloat(Landroid/content/res/Resources; I)F
    move-result v4
    invoke-virtual v11, v1, v4, Landroid/widget/TextView;->setTextSize(I F)V
    invoke-static v15, v1, Landroid/graphics/Typeface;->create(Ljava/lang/String; I)Landroid/graphics/Typeface;
    move-result-object v15
    invoke-virtual v11, v15, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V
    invoke-virtual v11, v3, Landroid/widget/TextView;->setIncludeFontPadding(Z)V
    sget v15, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_line_height I
    invoke-static v0, v15, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v15
    invoke-static v11, v15, Landroidx/core/widget/TextViewCompat;->setLineHeight(Landroid/widget/TextView; I)V
    invoke-virtual v11, v3, Landroid/widget/TextView;->setClickable(Z)V
    invoke-virtual v11, v3, Landroid/widget/TextView;->setFocusable(Z)V
    new-instance v15, Landroid/graphics/drawable/GradientDrawable;
    invoke-direct v15, Landroid/graphics/drawable/GradientDrawable;-><init>()V
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_radius I
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimenFloat(Landroid/content/res/Resources; I)F
    move-result v1
    invoke-virtual v15, v1, Landroid/graphics/drawable/GradientDrawable;->setCornerRadius(F)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_bg_bg_invert I
    invoke-static v14, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v14
    invoke-virtual v15, v14, Landroid/graphics/drawable/GradientDrawable;->setColor(I)V
    check-cast v15, Landroid/graphics/drawable/Drawable;
    invoke-virtual v11, v15, Landroid/widget/TextView;->setBackground(Landroid/graphics/drawable/Drawable;)V
    move-object v14, v11
    check-cast v14, Landroid/view/View;
    new-instance v15, Landroid/widget/LinearLayout$LayoutParams;
    sget v1, Lcom/bytedance/trae/conversation/R$dimen;->trae_upgrade_reminder_button_height I
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder$Companion;->createView$dimen(Landroid/content/res/Resources; I)I
    move-result v0
    invoke-direct v15, v5, v0, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v15, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v14, v15, Landroid/widget/LinearLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v14, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    move-object v7, v2
    check-cast v7, Landroid/view/View;
    const/4 v12, 0
    move-object v6, v14
    invoke-direct/range v6 ... v12, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;-><init>(Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    const-string/jumbo v15, upgrade_reminder_view_holder
    invoke-static v15, v14, Lkotlin/TuplesKt;->to(Ljava/lang/Object; Ljava/lang/Object;)Lkotlin/Pair;
    move-result-object v15
    invoke-virtual v2, v15, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V
    return-object v14
.end method

.method public final fromView(android.view.View)com.bytedance.trae.conversation.chat.viewholder.UpgradeReminderViewHolder
    .registers 5
    # ins_size=2
    const-string/jumbo v0, view
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-virtual v4, Landroid/view/View;->getTag()Ljava/lang/Object;
    move-result-object v4
    instance-of v0, v4, Lkotlin/Pair;
    const/4 v1, 0
    if-eqz v0, +005h
    check-cast v4, Lkotlin/Pair;
    goto +2h
    move-object v4, v1
    if-eqz v4, +018h
    invoke-virtual v4, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v0
    const-string/jumbo v2, upgrade_reminder_view_holder
    invoke-static v0, v2, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v0
    if-eqz v0, +003h
    goto +2h
    move-object v4, v1
    if-eqz v4, +007h
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v4
    goto +2h
    move-object v4, v1
    instance-of v0, v4, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    if-eqz v0, +005h
    move-object v1, v4
    check-cast v1, Lcom/bytedance/trae/conversation/chat/viewholder/UpgradeReminderViewHolder;
    return-object v1
.end method
