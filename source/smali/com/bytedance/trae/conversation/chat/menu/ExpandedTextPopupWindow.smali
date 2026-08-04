# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;
.super Ljava/lang/Object;
.source "MessagePopupWindow.kt"

.field private final listener:Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
.field private final mode:Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
.field private final popupWindow:Landroid/widget/PopupWindow;


.method public static synthetic $r8$lambda$-NqMfKLXOKc3fAAtMS5bj6ZWSGg(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->_init_$lambda$1(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$KJwOfLhCL_jouA44nfsC5rZutTw(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->_init_$lambda$2(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$Uk9zCuYlPOKgb6OJAw9KtCNRjKA(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->_init_$lambda$3(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public static synthetic $r8$lambda$kK5DlVwNH2HVq92Qdsfu9yGKj1k(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-static v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->_init_$lambda$0(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow; Landroid/view/View;)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  java.lang.CharSequence  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$OnMenuClickListener  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$Mode)void
    .registers 11
    # ins_size=5
    const-string v0, "context"
    invoke-static v7, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, text
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "listener"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "mode"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v6, Ljava/lang/Object;-><init>()V
    iput-object v9, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    iput-object v10, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->mode Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    invoke-static v7, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->conversation_expanded_text_popup I
    const/4 v1, 0
    const/4 v2, 0
    invoke-virtual v9, v0, v1, v2, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v9
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_full_text I
    invoke-virtual v9, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    invoke-virtual v0, v8, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    new-instance v8, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda0;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;)V
    invoke-virtual v9, v8, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v8
    iget v8, v8, Landroid/util/DisplayMetrics;->widthPixels I
    invoke-virtual v7, Landroid/content/Context;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;
    move-result-object v0
    iget v0, v0, Landroid/util/DisplayMetrics;->density F
    const/16 v1, 180
    int-to-float v1, v1
    mul-float/2addr v1, v0
    float-to-int v1, v1
    add-int/2addr v1, v8
    div-int/lit8 v1, v1, 2
    const/16 v3, 22
    int-to-float v3, v3
    mul-float/2addr v3, v0
    float-to-int v0, v3
    sget v3, Lcom/bytedance/trae/conversation/R$id;->ll_menu_container I
    invoke-virtual v9, v3, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v3
    invoke-virtual v3, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    move-result-object v4
    const-string v5, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
    invoke-static v4, v5, Lkotlin/jvm/internal/Intrinsics;->checkNotNull(Ljava/lang/Object; Ljava/lang/String;)V
    check-cast v4, Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual v4, v0, Landroid/widget/FrameLayout$LayoutParams;->setMarginStart(I)V
    sub-int/2addr v1, v0
    iput v1, v4, Landroid/widget/FrameLayout$LayoutParams;->width I
    check-cast v4, Landroid/view/ViewGroup$LayoutParams;
    invoke-virtual v3, v4, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    new-instance v0, Landroid/widget/PopupWindow;
    const/4 v1, -1
    const/4 v3, 1
    invoke-direct v0, v9, v8, v1, v3, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    iput-object v0, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    new-instance v8, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v8, v2, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    check-cast v8, Landroid/graphics/drawable/Drawable;
    invoke-virtual v0, v8, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    const/high16 v8, 1090519040
    invoke-direct v6, v7, v8, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v7
    invoke-virtual v0, v7, Landroid/widget/PopupWindow;->setElevation(F)V
    const v7, 16973826
    invoke-virtual v0, v7, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    invoke-virtual v0, v3, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->menu_copy I
    invoke-virtual v9, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    new-instance v8, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda1;
    invoke-direct v8, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;)V
    invoke-virtual v7, v8, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    sget v7, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-virtual v9, v7, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v7
    sget v8, Lcom/bytedance/trae/conversation/R$id;->menu_revert I
    invoke-virtual v9, v8, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v8
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider_delete I
    invoke-virtual v9, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->divider_revert I
    invoke-virtual v9, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v9
    sget-object v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Event Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    if-ne v10, v1, +011h
    const/16 v10, 8
    invoke-virtual v7, v10, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v8, v10, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v0, v10, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v9, v10, Landroid/view/View;->setVisibility(I)V
    goto +11h
    new-instance v9, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda2;
    invoke-direct v9, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;)V
    invoke-virtual v7, v9, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    new-instance v7, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda3;
    invoke-direct v7, v6, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;)V
    invoke-virtual v8, v7, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    return-void 
.end method

.method public synthetic constructor <init>(android.content.Context  java.lang.CharSequence  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$OnMenuClickListener  com.bytedance.trae.conversation.chat.menu.MessagePopupWindow$Mode  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 7
    # ins_size=7
    and-int/lit8 v5, v5, 8
    if-eqz v5, +004h
    sget-object v4, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;->Message Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;
    invoke-direct v0, v1, v2, v3, v4, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;-><init>(Landroid/content/Context; Ljava/lang/CharSequence; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener; Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$Mode;)V
    return-void 
.end method

.method private static final _init_$lambda$0(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$1(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onCopyClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$2(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onDeleteClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dismiss()V
    return-void 
.end method

.method private static final _init_$lambda$3(com.bytedance.trae.conversation.chat.menu.ExpandedTextPopupWindow  android.view.View)void
    .registers 2
    # ins_size=2
    iget-object v1, v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->listener Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;
    invoke-interface v1, Lcom/bytedance/trae/conversation/chat/menu/MessagePopupWindow$OnMenuClickListener;->onRevertClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->dismiss()V
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
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method public final isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    return v0
.end method

.method public final setOnDismissListener(android.widget.PopupWindow$OnDismissListener)void
    .registers 3
    # ins_size=2
    const-string v0, "listener"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v1, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v2, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    return-void 
.end method

.method public final showBelow(android.view.View)void
    .registers 4
    # ins_size=2
    const-string v0, "anchor"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +008h
    iget-object v0, v2, Lcom/bytedance/trae/conversation/chat/menu/ExpandedTextPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const/4 v1, 0
    invoke-virtual v0, v3, v1, v1, v1, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method
