# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;
.super Ljava/lang/Object;
.source "MessagePopupWindow.kt"

.field private final listener:Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
.field private final mode:Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
.field private final popupWindow:Landroid/widget/PopupWindow;


.method public static synthetic $r8$lambda$BcypE9aWkwJmFsRR7djzfHazDro(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->_init_$lambda$2(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$e6ojbP060GWLnJYFCSJ5FUvhBpk(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->_init_$lambda$1(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$nN0JuvXhWJWNyUWmnrhdoE46VGk(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->_init_$lambda$3(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$opMmhmVhvHKbt09fkLZCOmzHSgk(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->_init_$lambda$0(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$OnMenuClickListener  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$Mode)void
    .registers 9
    # ins_size=4
    const-string v0, "context"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "listener"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v5, Ljava/lang/Object;-><init>()V
    iput-object v7, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    iput-object v8, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->mode Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    invoke-static v6, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v7
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->conversation_message_popup_menu I
    const/4 v1, 0
    const/4 v2, 0
    invoke-virtual v7, v0, v1, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v7
    const/high16 v0, 1131413504
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v0
    float-to-int v0, v0
    new-instance v1, Landroid/widget/PopupWindow;
    const/4 v3, -2
    const/4 v4, 1
    invoke-direct v1, v7, v0, v3, v4, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    iput-object v1, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v0, v2, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v0, Landroid/graphics/drawable/Drawable;
    invoke-virtual v1, v0, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/high16 v0, 1090519040
    invoke-direct v5, v6, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v6
    invoke-virtual v1, v6, Landroid/widget/PopupWindow;->setElevation(F)V
    const v6, 16973826
    invoke-virtual v1, v6, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    invoke-virtual v1, v4, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    sget v6, Lcom/bytedance/trae/conversation/R$id;->menu_copy I
    invoke-virtual v7, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda0;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v6, Lcom/bytedance/trae/conversation/R$id;->menu_copy I
    invoke-virtual v7, v6, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-virtual v7, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->menu_revert I
    invoke-virtual v7, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$id;->divider_delete I
    invoke-virtual v7, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v2
    sget v3, Lcom/bytedance/trae/conversation/R$id;->divider_revert I
    invoke-virtual v7, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    sget-object v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$WhenMappings;->$EnumSwitchMapping$0 [I
    invoke-virtual v8, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->ordinal()I
    move-result v8
    aget v8, v3, v8
    const/16 v3, 8
    if-eq v8, v4, +02bh
    const/4 v4, 2
    if-eq v8, v4, +013h
    new-instance v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda2;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;)V
    invoke-virtual v0, v6, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda3;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;)V
    invoke-virtual v1, v6, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +22h
    invoke-virtual v6, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v2, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v7, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, v3, Landroid/view/View;->setVisibility(I)V
    new-instance v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda1;
    invoke-direct v6, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;)V
    invoke-virtual v0, v6, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    goto +dh
    invoke-virtual v0, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v2, v3, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v7, v3, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$OnMenuClickListener  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$Mode  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 6
    # ins_size=6
    and-int/lit8 v4, v4, 4
    if-eqz v4, +004h
    sget-object v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Message Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    invoke-direct v0, v1, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onCopyClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onDeleteClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$2(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onDeleteClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$3(com.bytedance.trae.conversation.chat.menu.MessagePopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onRevertClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dismiss()V
    return-void 
.end method

.method private final dp2px(android.content.Context  float)float
    .registers 3
    # ins_size=3
    invoke-virtual v1, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->density F
    mul-float/2addr v2, v1
    return v2
.end method

.method public final dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method public final isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setOnDismissListener(android.widget.PopupWindow$OnDismissListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v2, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    return-void 
.end method

.method public final showAbove(android.view.View)void
    .registers 8
    # ins_size=2
    const-string v0, "anchor"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +044h
    iget-object v0, v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
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
    invoke-virtual v7, v3, Landroid/view/View;->getLocationOnScreen([I)V
    aget v4, v3, v1
    invoke-virtual v7, Landroid/view/View;->getWidth()I
    move-result v5
    add-int/2addr v4, v5
    sub-int/2addr v4, v0
    const/4 v0, 1
    aget v0, v3, v0
    sub-int/2addr v0, v2
    invoke-virtual v7, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v3, 1082130432
    invoke-direct v6, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v2
    float-to-int v2, v2
    sub-int/2addr v0, v2
    iget-object v2, v6, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v2, v7, v1, v4, v0, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public final showAsDropDown(android.view.View  int  int)void
    .registers 8
    # ins_size=4
    const-string v0, "anchor"
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v4, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +01ah
    const/4 v0, 2
    new-array v0, v0, [I
    invoke-virtual v5, v0, Landroid/view/View;->getLocationOnScreen([I)V
    const/4 v1, 0
    aget v2, v0, v1
    invoke-virtual v5, Landroid/view/View;->getWidth()I
    move-result v3
    add-int/2addr v2, v3
    add-int/2addr v2, v6
    const/4 v6, 1
    aget v6, v0, v6
    add-int/2addr v6, v7
    iget-object v7, v4, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v7, v5, v1, v2, v6, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public final showBelow(android.view.View)void
    .registers 7
    # ins_size=2
    const-string v0, "anchor"
    invoke-static v6, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +047h
    const/4 v0, 2
    new-array v0, v0, [I
    invoke-virtual v6, v0, Landroid/view/View;->getLocationOnScreen([I)V
    invoke-virtual v6, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v1
    invoke-virtual v1, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v1
    iget v1, v1, Landroid/util/DisplayMetrics;->widthPixels I
    invoke-virtual v6, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    const-string v3, "getContext(...)"
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v4, 1098907648
    invoke-direct v5, v2, v4, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v2
    float-to-int v2, v2
    iget-object v4, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v4, Landroid/widget/PopupWindow;->getWidth()I
    move-result v4
    sub-int/2addr v1, v4
    sub-int/2addr v1, v2
    const/4 v2, 1
    aget v0, v0, v2
    invoke-virtual v6, Landroid/view/View;->getHeight()I
    move-result v2
    add-int/2addr v0, v2
    invoke-virtual v6, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v2
    invoke-static v2, v3, Lkotlin/jvm/internal/Intrinsics;->checkNotNullExpressionValue(Ljava/lang/Object; Ljava/lang/String;)V
    const/high16 v3, 1082130432
    invoke-direct v5, v2, v3, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v2
    float-to-int v2, v2
    add-int/2addr v0, v2
    iget-object v2, v5, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const/4 v3, 0
    invoke-virtual v2, v6, v3, v1, v0, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method
