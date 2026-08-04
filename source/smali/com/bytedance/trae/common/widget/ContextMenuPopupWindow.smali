# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;
.super Ljava/lang/Object;
.source "ContextMenuPopupWindow.kt"

.field private final popupWindow:Landroid/widget/PopupWindow;


.method public static synthetic $r8$lambda$HEz_gTUMF_D6hgyB-6ORZ6vemAg(com.bytedance.trae.common.widget.ContextMenuPopupWindow  com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-static v0, v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->createItemView$lambda$7$lambda$3(Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow; Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.util.List  int)void
    .registers 8
    # ins_size=4
    const-string v0, "context"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "items"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v4, Ljava/lang/Object;-><init>()V
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v5, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setOrientation(I)V
    sget v2, Lcom/bytedance/trae/common_ui/R$drawable;->trae_bg_context_menu_popup I
    invoke-static v5, v2, Landroidx/core/content/ContextCompat;->getDrawable(Landroid/content/Context; I)Landroid/graphics/drawable/Drawable;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v0, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_vertical_padding I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    const/4 v3, 0
    invoke-virtual v0, v3, v2, v3, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    check-cast v6, Ljava/lang/Iterable;
    invoke-interface v6, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;
    move-result-object v6
    invoke-interface v6, Ljava/util/Iterator;->hasNext()Z
    move-result v2
    if-eqz v2, +010h
    invoke-interface v6, Ljava/util/Iterator;->next()Ljava/lang/Object;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;
    invoke-direct v4, v5, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->createItemView(Landroid/content/Context; Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;)Landroid/view/View;
    move-result-object v2
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    goto -13h
    check-cast v0, Landroid/view/View;
    invoke-direct v4, v5, v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->createShadowRootView(Landroid/content/Context; Landroid/view/View;)Landroid/widget/FrameLayout;
    move-result-object v6
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_horizontal I
    invoke-virtual v0, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    new-instance v2, Landroid/widget/PopupWindow;
    check-cast v6, Landroid/view/View;
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, v7, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v7
    mul-int/lit8 v0, v0, 2
    add-int/2addr v7, v0
    const/4 v0, -2
    invoke-direct v2, v6, v7, v0, v1, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    invoke-virtual v5, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_elevation I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    int-to-float v5, v5
    invoke-virtual v2, v5, Landroid/widget/PopupWindow;->setElevation(F)V
    const v5, 16973826
    invoke-virtual v2, v5, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    invoke-virtual v2, v1, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    iput-object v2, v4, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.util.List  int  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_width I
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;-><init>(Landroid/content/Context; Ljava/util/List; I)V
    return-void 
.end method

.method private final adjustXForShadow(android.content.Context  int)int
    .registers 4
    # ins_size=3
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_horizontal I
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    sub-int/2addr v3, v2
    return v3
.end method

.method private final adjustYForShadow(android.content.Context  int)int
    .registers 4
    # ins_size=3
    invoke-virtual v2, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v0, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_top I
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    sub-int/2addr v3, v2
    return v3
.end method

.method private final createItemView(android.content.Context  com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item)android.view.View
    .registers 11
    # ins_size=3
    new-instance v0, Landroid/widget/LinearLayout;
    invoke-direct v0, v9, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getViewId()I
    move-result v1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setId(I)V
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_item_height I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    const/4 v3, -1
    invoke-direct v1, v3, v2, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v1, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    const/4 v1, 1
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setClickable(Z)V
    invoke-virtual v0, v1, Landroid/widget/LinearLayout;->setFocusable(Z)V
    const/4 v2, 0
    invoke-virtual v0, v2, Landroid/widget/LinearLayout;->setOrientation(I)V
    const/16 v3, 16
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setGravity(I)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_item_horizontal_padding I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v0, v3, v2, v3, v2, Landroid/widget/LinearLayout;->setPadding(I I I I)V
    invoke-direct v8, v9, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->resolveSelectableItemBackground(Landroid/content/Context;)I
    move-result v3
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setBackgroundResource(I)V
    new-instance v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;
    invoke-direct v3, v8, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow; Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;)V
    invoke-virtual v0, v3, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getDestructive()Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    goto +3h
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_icon_icon_default I
    new-instance v4, Landroid/widget/ImageView;
    invoke-direct v4, v9, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_icon_size I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    new-instance v6, Landroid/widget/LinearLayout$LayoutParams;
    invoke-direct v6, v5, v5, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I)V
    check-cast v6, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v6, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getIconRes()I
    move-result v5
    invoke-virtual v4, v5, Landroid/widget/ImageView;->setImageResource(I)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getIconTintRes()Ljava/lang/Integer;
    move-result-object v5
    if-eqz v5, +006h
    invoke-virtual v5, Ljava/lang/Integer;->intValue()I
    move-result v3
    invoke-static v9, v3, Landroidx/core/content/ContextCompat;->getColorStateList(Landroid/content/Context; I)Landroid/content/res/ColorStateList;
    move-result-object v3
    invoke-static v4, v3, Landroidx/core/widget/ImageViewCompat;->setImageTintList(Landroid/widget/ImageView; Landroid/content/res/ColorStateList;)V
    const/4 v3, 2
    invoke-virtual v4, v3, Landroid/widget/ImageView;->setImportantForAccessibility(I)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getTextColorRes()Ljava/lang/Integer;
    move-result-object v3
    if-eqz v3, +007h
    invoke-virtual v3, Ljava/lang/Integer;->intValue()I
    move-result v3
    goto +ch
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getDestructive()Z
    move-result v3
    if-eqz v3, +005h
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_status_error_default I
    goto +3h
    sget v3, Lcom/bytedance/trae/common_ui/R$color;->trae_text_text_default I
    new-instance v4, Landroid/widget/TextView;
    invoke-direct v4, v9, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;
    const/4 v6, -2
    const/high16 v7, 1065353216
    invoke-direct v5, v2, v6, v7, Landroid/widget/LinearLayout$LayoutParams;-><init>(I I F)V
    invoke-virtual v9, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_text_margin_start I
    invoke-virtual v2, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    invoke-virtual v5, v2, Landroid/widget/LinearLayout$LayoutParams;->setMarginStart(I)V
    check-cast v5, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v4, v5, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    sget v2, Lcom/bytedance/trae/common_ui/R$style;->Trae_Text_Body_Base I
    invoke-static v4, v2, Landroidx/core/widget/TextViewCompat;->setTextAppearance(Landroid/widget/TextView; I)V
    invoke-virtual v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getTitle()Ljava/lang/CharSequence;
    move-result-object v10
    invoke-virtual v4, v10, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    invoke-static v9, v3, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v9
    invoke-virtual v4, v9, Landroid/widget/TextView;->setTextColor(I)V
    invoke-virtual v4, v1, Landroid/widget/TextView;->setMaxLines(I)V
    sget-object v9, Landroid/text/TextUtils$TruncateAt;->END Landroid/text/TextUtils$TruncateAt;
    invoke-virtual v4, v9, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V
    check-cast v4, Landroid/view/View;
    invoke-virtual v0, v4, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    check-cast v0, Landroid/view/View;
    return-object v0
.end method

.method private static final createItemView$lambda$7$lambda$3(com.bytedance.trae.common.widget.ContextMenuPopupWindow  com.bytedance.trae.common.widget.ContextMenuPopupWindow$Item  android.view.View)void
    .registers 3
    # ins_size=3
    invoke-virtual v0, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->dismiss()V
    invoke-virtual v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow$Item;->getOnClick()Lkotlin/jvm/functions/Function0;
    move-result-object v0
    invoke-interface v0, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;
    return-void 
.end method

.method private final createShadowRootView(android.content.Context  android.view.View)android.widget.FrameLayout
    .registers 16
    # ins_size=3
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_horizontal I
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v0
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_top I
    invoke-virtual v1, v2, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v1
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_bottom I
    invoke-virtual v2, v3, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v2
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_radius I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_blur_radius I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v14, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_offset_y I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    sget v6, Lcom/bytedance/trae/common_ui/R$color;->trae_context_menu_shadow I
    invoke-static v14, v6, Landroidx/core/content/ContextCompat;->getColor(Landroid/content/Context; I)I
    move-result v11
    new-instance v6, Landroid/widget/FrameLayout;
    invoke-direct v6, v14, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V
    const/4 v14, 0
    invoke-virtual v6, v14, Landroid/widget/FrameLayout;->setClipChildren(Z)V
    invoke-virtual v6, v14, Landroid/widget/FrameLayout;->setClipToPadding(Z)V
    const/4 v14, 1
    const/4 v7, 0
    invoke-virtual v6, v14, v7, Landroid/widget/FrameLayout;->setLayerType(I Landroid/graphics/Paint;)V
    new-instance v14, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;
    int-to-float v8, v3
    int-to-float v9, v4
    int-to-float v10, v5
    new-instance v12, Landroid/graphics/Rect;
    invoke-direct v12, v0, v1, v0, v2, Landroid/graphics/Rect;-><init>(I I I I)V
    move-object v7, v14
    invoke-direct/range v7 ... v12, Lcom/bytedance/trae/common/widget/ContextMenuShadowDrawable;-><init>(F F F I Landroid/graphics/Rect;)V
    check-cast v14, Landroid/graphics/drawable/Drawable;
    invoke-virtual v6, v14, Landroid/widget/FrameLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V
    invoke-virtual v6, v0, v1, v0, v2, Landroid/widget/FrameLayout;->setPadding(I I I I)V
    new-instance v14, Landroid/widget/FrameLayout$LayoutParams;
    const/4 v0, -1
    const/4 v1, -2
    invoke-direct v14, v0, v1, Landroid/widget/FrameLayout$LayoutParams;-><init>(I I)V
    check-cast v14, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v6, v15, v14, Landroid/widget/FrameLayout;->addView(Landroid/view/View; Landroid/view/ViewGroup$LayoutParams;)V
    return-object v6
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

.method private final screenToWindowOffset(android.view.View)kotlin.Pair
    .registers 6
    # ins_size=2
    const/4 v0, 2
    new-array v1, v0, [I
    new-array v0, v0, [I
    invoke-virtual v5, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v2
    invoke-virtual v2, v1, Landroid/view/View;->getLocationOnScreen([I)V
    invoke-virtual v5, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v5
    invoke-virtual v5, v0, Landroid/view/View;->getLocationInWindow([I)V
    new-instance v5, Lkotlin/Pair;
    const/4 v2, 0
    aget v3, v1, v2
    aget v2, v0, v2
    sub-int/2addr v3, v2
    invoke-static v3, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v2
    const/4 v3, 1
    aget v1, v1, v3
    aget v0, v0, v3
    sub-int/2addr v1, v0
    invoke-static v1, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;
    move-result-object v0
    invoke-direct v5, v2, v0, Lkotlin/Pair;-><init>(Ljava/lang/Object; Ljava/lang/Object;)V
    return-object v5
.end method

.method public static synthetic showAbove$default(com.bytedance.trae.common.widget.ContextMenuPopupWindow  android.view.View  android.view.View  int  java.lang.Object)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    move-object v2, v1
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->showAbove(Landroid/view/View; Landroid/view/View;)V
    return-void 
.end method

.method private final visibleWindowFrame(android.view.View  kotlin.Pair)android.graphics.Rect
    .registers 5
    # ins_size=3
    new-instance v0, Landroid/graphics/Rect;
    invoke-direct v0, Landroid/graphics/Rect;-><init>()V
    invoke-virtual v3, Landroid/view/View;->getRootView()Landroid/view/View;
    move-result-object v1
    invoke-virtual v1, v0, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V
    invoke-virtual v0, Landroid/graphics/Rect;->isEmpty()Z
    move-result v1
    if-nez v1, +01ch
    invoke-virtual v4, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v3
    check-cast v3, Ljava/lang/Number;
    invoke-virtual v3, Ljava/lang/Number;->intValue()I
    move-result v3
    neg-int v3, v3
    invoke-virtual v4, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v4
    check-cast v4, Ljava/lang/Number;
    invoke-virtual v4, Ljava/lang/Number;->intValue()I
    move-result v4
    neg-int v4, v4
    invoke-virtual v0, v3, v4, Landroid/graphics/Rect;->offset(I I)V
    return-object v0
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v3
    new-instance v4, Landroid/graphics/Rect;
    iget v0, v3, Landroid/util/DisplayMetrics;->widthPixels I
    iget v3, v3, Landroid/util/DisplayMetrics;->heightPixels I
    const/4 v1, 0
    invoke-direct v4, v1, v1, v0, v3, Landroid/graphics/Rect;-><init>(I I I I)V
    return-object v4
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method public final isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setOnDismissListener(android.widget.PopupWindow$OnDismissListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v2, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    return-void 
.end method

.method public final showAbove(android.view.View  android.view.View)void
    .registers 10
    # ins_size=3
    const-string v0, "anchor"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "horizontalAnchor"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v2
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-virtual v0, v2, v3, Landroid/view/View;->measure(I I)V
    invoke-virtual v0, Landroid/view/View;->getMeasuredHeight()I
    move-result v2
    invoke-virtual v0, Landroid/view/View;->getMeasuredWidth()I
    move-result v0
    const/4 v3, 2
    new-array v4, v3, [I
    invoke-virtual v8, v4, Landroid/view/View;->getLocationOnScreen([I)V
    new-array v3, v3, [I
    invoke-virtual v9, v3, Landroid/view/View;->getLocationOnScreen([I)V
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_horizontal I
    invoke-virtual v9, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v9
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_top I
    invoke-virtual v5, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v5
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v6
    invoke-virtual v6, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v6
    iget v6, v6, Landroid/util/DisplayMetrics;->widthPixels I
    aget v3, v3, v1
    sub-int/2addr v3, v9
    sub-int/2addr v6, v0
    invoke-static v1, v6, Ljava/lang/Math;->max(I I)I
    move-result v9
    invoke-static v3, v1, v9, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v9
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->heightPixels I
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v6, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_anchor_gap I
    invoke-virtual v3, v6, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    const/4 v6, 1
    aget v4, v4, v6
    sub-int/2addr v4, v3
    sub-int/2addr v4, v5
    sub-int/2addr v0, v2
    invoke-static v1, v0, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-static v4, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v0
    iget-object v2, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v2, v8, v1, v9, v0, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public final showAtLocation(android.view.View  int  int  int)void
    .registers 8
    # ins_size=5
    const-string v0, "parent"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +01fh
    iget-object v0, v3, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    const-string v2, "getContext(...)"
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v1, v6, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->adjustXForShadow(Landroid/content/Context; I)I
    move-result v6
    invoke-virtual v4, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v1
    invoke-static v1, v2, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v3, v1, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->adjustYForShadow(Landroid/content/Context; I)I
    move-result v7
    invoke-virtual v0, v4, v5, v6, v7, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public final showBelow(android.view.View  int)void
    .registers 10
    # ins_size=3
    const-string v0, "anchor"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v0
    const/4 v1, 0
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v2
    invoke-static v1, v1, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-virtual v0, v2, v3, Landroid/view/View;->measure(I I)V
    invoke-virtual v0, Landroid/view/View;->getMeasuredHeight()I
    move-result v2
    invoke-virtual v0, Landroid/view/View;->getMeasuredWidth()I
    move-result v0
    const/4 v3, 2
    new-array v3, v3, [I
    invoke-virtual v8, v3, Landroid/view/View;->getLocationOnScreen([I)V
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_horizontal I
    invoke-virtual v4, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v5
    invoke-virtual v5, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v5
    iget v5, v5, Landroid/util/DisplayMetrics;->widthPixels I
    aget v6, v3, v1
    sub-int/2addr v6, v4
    sub-int/2addr v5, v0
    invoke-static v1, v5, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-static v6, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v4
    iget v4, v4, Landroid/util/DisplayMetrics;->heightPixels I
    const/4 v5, 1
    aget v3, v3, v5
    add-int/2addr v3, v9
    sub-int/2addr v4, v2
    invoke-static v1, v4, Ljava/lang/Math;->max(I I)I
    move-result v9
    invoke-static v3, v1, v9, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v9
    iget-object v1, v7, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const/16 v2, 48
    invoke-virtual v1, v8, v2, v0, v9, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public final showNear(android.view.View  float  float)void
    .registers 14
    # ins_size=4
    const-string v0, "parent"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +003h
    return-void 
    iget-object v0, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->getContentView()Landroid/view/View;
    move-result-object v0
    iget-object v1, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v1, Landroid/widget/PopupWindow;->getWidth()I
    move-result v1
    const/high16 v2, 1073741824
    invoke-static v1, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v1
    const/4 v2, 0
    invoke-static v2, v2, Landroid/view/View$MeasureSpec;->makeMeasureSpec(I I)I
    move-result v3
    invoke-virtual v0, v1, v3, Landroid/view/View;->measure(I I)V
    iget-object v1, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v1, Landroid/widget/PopupWindow;->getWidth()I
    move-result v1
    invoke-virtual v0, Landroid/view/View;->getMeasuredHeight()I
    move-result v0
    invoke-virtual v11, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    sget v4, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_top I
    invoke-virtual v3, v4, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v4
    sget v5, Lcom/bytedance/trae/common_ui/R$dimen;->trae_context_menu_shadow_padding_bottom I
    invoke-virtual v3, v5, Landroid/content/res/Resources;->getDimensionPixelSize(I)I
    move-result v3
    invoke-direct v10, v11, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->screenToWindowOffset(Landroid/view/View;)Lkotlin/Pair;
    move-result-object v5
    invoke-virtual v5, Lkotlin/Pair;->getFirst()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->floatValue()F
    move-result v6
    sub-float/2addr v12, v6
    invoke-virtual v5, Lkotlin/Pair;->getSecond()Ljava/lang/Object;
    move-result-object v6
    check-cast v6, Ljava/lang/Number;
    invoke-virtual v6, Ljava/lang/Number;->floatValue()F
    move-result v6
    sub-float/2addr v13, v6
    invoke-direct v10, v11, v5, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->visibleWindowFrame(Landroid/view/View; Lkotlin/Pair;)Landroid/graphics/Rect;
    move-result-object v5
    int-to-float v6, v1
    const/high16 v7, 1073741824
    div-float/2addr v6, v7
    sub-float/2addr v12, v6
    invoke-static v12, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v12
    iget v6, v5, Landroid/graphics/Rect;->left I
    iget v8, v5, Landroid/graphics/Rect;->left I
    iget v9, v5, Landroid/graphics/Rect;->right I
    sub-int/2addr v9, v1
    invoke-static v8, v9, Ljava/lang/Math;->max(I I)I
    move-result v1
    invoke-static v12, v6, v1, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v12
    sub-int v1, v0, v4
    sub-int/2addr v1, v3
    int-to-float v3, v4
    sub-float/2addr v13, v3
    int-to-float v1, v1
    div-float/2addr v1, v7
    sub-float/2addr v13, v1
    invoke-static v13, Lkotlin/math/MathKt;->roundToInt(F)I
    move-result v13
    iget v1, v5, Landroid/graphics/Rect;->top I
    iget v3, v5, Landroid/graphics/Rect;->top I
    iget v4, v5, Landroid/graphics/Rect;->bottom I
    sub-int/2addr v4, v0
    invoke-static v3, v4, Ljava/lang/Math;->max(I I)I
    move-result v0
    invoke-static v13, v1, v0, Lkotlin/ranges/RangesKt;->coerceIn(I I I)I
    move-result v13
    iget-object v0, v10, Lcom/bytedance/trae/common/widget/ContextMenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v11, v2, v12, v13, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method
