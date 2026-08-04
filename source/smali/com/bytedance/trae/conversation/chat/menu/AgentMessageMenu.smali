# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;
.super Ljava/lang/Object;
.source "AgentMessageMenu.kt"

.field private final density:F
.field private final listener:Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;
.field private final popupWindow:Landroid/widget/PopupWindow;


.method public static synthetic $r8$lambda$8ud1CXGU40qTPSqiR5Aq3devikg(com.bytedance.trae.conversation.chat.menu.AgentMessageMenu)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->buildContentView$lambda$4$lambda$2(Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$Hb4THBgHRRIdk2GaPuLC2UpiAdY(com.bytedance.trae.conversation.chat.menu.AgentMessageMenu)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-static v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->buildContentView$lambda$4$lambda$3(Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method

.method public static synthetic $r8$lambda$hgL76siuVLfQvZFfnFcIdbhvf9Y(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->createItemView$lambda$9$lambda$5(Lkotlin/jvm/functions/Function0; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.menu.AgentMessageMenu$OnMenuClickListener)void
    .registers 6
    # ins_size=3
    const-string v0, "context"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "listener"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, Ljava/lang/Object;-><init>()V
    iput-object v5, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->listener Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;
    invoke-virtual v4, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->density F
    iput v5, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->density F
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->buildContentView(Landroid/content/Context;)Landroid/view/View;
    move-result-object v4
    const/16 v5, 180
    invoke-direct v3, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v5
    new-instance v0, Landroid/widget/PopupWindow;
    const/4 v1, -2
    const/4 v2, 1
    invoke-direct v0, v4, v5, v1, v2, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    new-instance v4, Landroid/graphics/drawable/ColorDrawable;
    const/4 v5, 0
    invoke-direct v4, v5, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v4, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v4, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/16 v4, 8
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v4
    int-to-float v4, v4
    invoke-virtual v0, v4, Landroid/widget/PopupWindow;->setElevation(F)V
    const v4, 16973826
    invoke-virtual v0, v4, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    invoke-virtual v0, v2, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    iput-object v0, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    return-void 
.end method

.method private final buildContentView(android.content.Context)android.view.View
    .registers 6
    # ins_size=2
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v5, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_context_menu_popup I
    invoke-static v5, v1, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    const/16 v1, 8
    invoke-direct v4, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v1
    const/4 v2, 0
    invoke-virtual v0, v2, v1, v2, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_copy I
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_copy I
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda0;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;)V
    invoke-direct v4, v5, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->createItemView(Landroid/content/Context; I I Lkotlin/jvm/functions/Function0;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-direct v4, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->createDivider(Landroid/content/Context;)Landroid/view/View;
    move-result-object v1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    sget v1, Lcom/bytedance/trae/conversation/R$drawable;->trae_ic_select_text I
    sget v2, Lcom/bytedance/trae/conversation/R$string;->trae_message_menu_select_text I
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda1;
    invoke-direct v3, v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;)V
    invoke-direct v4, v5, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->createItemView(Landroid/content/Context; I I Lkotlin/jvm/functions/Function0;)Landroid/view/View;
    move-result-object v5
    invoke-virtual v0, v5, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final buildContentView$lambda$4$lambda$2(com.bytedance.trae.conversation.chat.menu.AgentMessageMenu)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->listener Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;->onCopyClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private static final buildContentView$lambda$4$lambda$3(com.bytedance.trae.conversation.chat.menu.AgentMessageMenu)kotlin.Unit
    .registers 1
    # ins_size=1
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dismiss()V
    iget-object v0, v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->listener Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;
    invoke-interface v0, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$OnMenuClickListener;->onSelectTextClick()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method private final createDivider(android.content.Context)android.view.View
    .registers 6
    # ins_size=2
    new-instance v0, Landroid/view/View;
    invoke-direct v0, v5, Landroid/view/View;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/high16 v2, 1056964608
    iget v3, v4, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->density F
    mul-float/2addr v3, v2
    invoke-static v3, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    const/16 v2, 16
    invoke-direct v4, v2, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v2
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    invoke-virtual v1, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginEnd(I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v1, Lcom/bytedance/trae/common_ui/R$color;->trae_border_border_neutral_l1 I
    invoke-static v5, v1, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v5
    invoke-virtual v0, v5, Landroid/view/View;->setBackgroundColor(I)V
    return-object v0
.end method

.method private final createItemView(android.content.Context  int  int  kotlin.jvm.functions.Function0)android.view.View
    .registers 10
    # ins_size=5
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v6, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    const/16 v2, 44
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v1, 0
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v2, 16
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-direct v5, v2, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v2
    invoke-virtual v0, v2, v1, v2, v1, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    const/4 v2, 1
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setFocusable(Z)V
    invoke-direct v5, v6, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->resolveSelectableItemBackground(Landroid/content/Context;)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda2;
    invoke-direct v3, v9, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu$$ExternalSyntheticLambda2;-><init>(Lkotlin/jvm/functions/Function0;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v9, Landroid/widget/ImageView;
    invoke-direct v9, v6, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    const/16 v3, 20
    invoke-direct v5, v3, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v3
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v4, v3, v3, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v9, v4, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v9, v7, Landroid/widget/ImageView;->setImageResource(I)V
    sget v7, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    invoke-static v6, v7, Landroidx/core/content/ContextCompat;->getColorStateList(Landroid/content/Context; I)Landroid/content/res/ColorStateList;
    move-result-object v7
    invoke-static v9, v7, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    const/4 v7, 2
    invoke-virtual v9, v7, Landroid/widget/ImageView;->setImportantForAccessibility(I)V
    check-cast v9, Landroid/view/View;
    invoke-virtual v0, v9, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    new-instance v7, Landroid/widget/TextView;
    invoke-direct v7, v6, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v9, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v3, -2
    const/high16 v4, 1065353216
    invoke-direct v9, v1, v3, v4, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    const/16 v1, 13
    invoke-direct v5, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v1
    invoke-virtual v9, v1, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v9, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v7, v9, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v9, Lcom/bytedance/trae/common_ui/R$style;->Trae_Text_Body_Base I
    invoke-static v7, v9, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    invoke-virtual v6, v8, Landroid/content/Context;->getString(I)Ljava/lang/String;
    move-result-object v8
    check-cast v8, Ljava/lang/CharSequence;
    invoke-virtual v7, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    sget v8, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    invoke-static v6, v8, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v7, v6, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v7, v2, Landroid/widget/TextView;->setMaxLines(I)V
    check-cast v7, Landroid/view/View;
    invoke-virtual v0, v7, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createItemView$lambda$9$lambda$5(kotlin.jvm.functions.Function0  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final dp(int)int
    .registers 3
    # ins_size=2
    int-to-float v2, v2
    iget v0, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->density F
    mul-float/2addr v2, v0
    invoke-static v2, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v2
    return v2
.end method

.method private final resolveSelectableItemBackground(android.content.Context)int
    .registers 5
    # ins_size=2
    new-instance v0, Landroid/util/TypedValue;
    invoke-direct v0, Landroid/util/TypedValue;-><init>()V
    invoke-virtual v4, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;
    move-result-object v4
    const v1, 16843534
    const/4 v2, 1
    invoke-virtual v4, v1, v0, v2, Landroid/content/res/Resources$Theme;->resolveAttribute(I Landroid/util/TypedValue; Z)Z
    iget v4, v0, Landroid/util/TypedValue;->resourceId I
    return v4
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method public final isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final showNear(android.view.View  float  float)void
    .registers 12
    # ins_size=4
    const-string v0, "parent"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v0
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v1, Landroid/widget/PopupWindow;->getWidth()I
    move-result v1
    const/high16 v2, 1073741824
    invoke-static v1, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v1
    const/4 v2, 0
    invoke-static v2, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-virtual v0, v1, v3, Landroid/view/View;->measure(I I)V
    iget-object v1, v8, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v1, Landroid/widget/PopupWindow;->getWidth()I
    move-result v1
    invoke-virtual v0, Landroid/view/View;->getMeasuredHeight()I
    move-result v0
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    iget v3, v3, Landroid/util/DisplayMetrics;->widthPixels I
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->heightPixels I
    int-to-float v5, v1
    const/high16 v6, 1073741824
    div-float/2addr v5, v6
    sub-float/2addr v10, v5
    invoke-static v10, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v10
    const/16 v5, 8
    invoke-direct v8, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v6
    invoke-direct v8, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v7
    sub-int/2addr v3, v1
    invoke-direct v8, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v1
    sub-int/2addr v3, v1
    invoke-static v7, v3, Ljava/lang/Math;->max(I I)I
    move-result v1
    invoke-static v10, v6, v1, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v10
    int-to-float v1, v0
    sub-float v1, v11, v1
    invoke-direct v8, v5, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v3
    int-to-float v3, v3
    sub-float/2addr v1, v3
    invoke-static v1, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    if-ltz v1, +003h
    goto +dh
    const/16 v1, 16
    invoke-direct v8, v1, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->dp(I)I
    move-result v1
    int-to-float v1, v1
    add-float/2addr v11, v1
    invoke-static v11, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v1
    sub-int/2addr v4, v0
    invoke-static v2, v4, Ljava/lang/Math;->max(I I)I
    move-result v11
    invoke-static v1, v2, v11, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v11
    iget-object v0, v8, Lcom/bytedance/trae/conversation/chat/menu/AgentMessageMenu;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v9, v2, v10, v11, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method
