# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
.super Ljava/lang/Object;
.source "MenuPopupWindow.java"

.field private contentView:Landroid/view/View;
.field private isPinned:Z
.field private listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
.field private popupWindow:Landroid/widget/PopupWindow;
.field private showArtifact:Z
.field private showPin:Z


.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.widget.MenuPopupWindow$OnMenuClickListener)void
    .registers 9
    # ins_size=3
    const/4 v3, 1
    const/4 v4, 0
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener; Z Z Z)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.widget.MenuPopupWindow$OnMenuClickListener  boolean)void
    .registers 10
    # ins_size=4
    const/4 v4, 0
    const/4 v5, 0
    move-object v0, v6
    move-object v1, v7
    move-object v2, v8
    move v3, v9
    invoke-direct/range v0 ... v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;-><init>(Landroid/content/Context; Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener; Z Z Z)V
    return-void 
.end method

.method public constructor <init>(android.content.Context  com.bytedance.trae.conversation.widget.MenuPopupWindow$OnMenuClickListener  boolean  boolean  boolean)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v2, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    iput-boolean v3, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showArtifact Z
    iput-boolean v4, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin Z
    iput-boolean v5, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned Z
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->init(Landroid/content/Context;)V
    return-void 
.end method

.method private dp2px(android.content.Context  float)float
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

.method private init(android.content.Context)void
    .registers 7
    # ins_size=2
    invoke-static v6, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$layout;->conversation_popup_menu I
    const/4 v2, 0
    const/4 v3, 0
    invoke-virtual v0, v1, v2, v3, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v0
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    new-instance v0, Landroid/widget/PopupWindow;
    iget-object v1, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    const/4 v2, -2
    const/4 v4, 1
    invoke-direct v0, v1, v2, v2, v4, Landroid/widget/PopupWindow;-><init>(Landroid/view/View; I I Z)V
    iput-object v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;
    invoke-direct v1, v3, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V
    invoke-virtual v0, v1, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    iget-object v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const/high16 v1, 1090519040
    invoke-direct v5, v6, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v6
    invoke-virtual v0, v6, Landroid/widget/PopupWindow;->setElevation(F)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const v0, 16973826
    invoke-virtual v6, v0, Landroid/widget/PopupWindow;->setAnimationStyle(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v6, v4, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda0;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V
    invoke-virtual v6, v0, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_artifact I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda1;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_pin I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda2;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_rename I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda3;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda4;
    invoke-direct v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V
    invoke-virtual v6, v0, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showArtifact Z
    if-nez v6, +01ah
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_artifact I
    invoke-virtual v6, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    const/16 v0, 8
    invoke-virtual v6, v0, Landroid/view/View;->setVisibility(I)V
    iget-object v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->menu_divider_artifact I
    invoke-virtual v6, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v6
    invoke-virtual v6, v0, Landroid/view/View;->setVisibility(I)V
    iget-boolean v6, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin Z
    iget-boolean v0, v5, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned Z
    invoke-virtual v5, v6, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->updatePinState(Z Z)V
    return-void 
.end method

.method private trackMenuActionClick(java.lang.String)void
    .registers 3
    # ins_size=2
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE Lcom/bytedance/trae/conversation/tracker/InputTracker;
    invoke-virtual v0, v2, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackConversationMenuItemClick(Ljava/lang/String;)V
    return-void 
.end method

.method public dismiss()void
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, Landroid/widget/PopupWindow;->dismiss()V
    return-void 
.end method

.method public isShowing()boolean
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    if-eqz v0, +00ah
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-eqz v0, +004h
    const/4 v0, 1
    goto +2h
    const/4 v0, 0
    return v0
.end method

.method synthetic lambda$init$0$com-bytedance-trae-conversation-widget-MenuPopupWindow()void
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    if-eqz v0, +007h
    const/16 v1, 8
    invoke-virtual v0, v1, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method

.method synthetic lambda$init$1$com-bytedance-trae-conversation-widget-MenuPopupWindow(android.view.View)void
    .registers 2
    # ins_size=2
    const-string v1, "artifacts"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onArtifactClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    return-void 
.end method

.method synthetic lambda$init$2$com-bytedance-trae-conversation-widget-MenuPopupWindow(android.view.View)void
    .registers 2
    # ins_size=2
    iget-boolean v1, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned Z
    if-eqz v1, +006h
    const-string/jumbo v1, unpin
    goto +3h
    const-string v1, "pin"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onPinClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    return-void 
.end method

.method synthetic lambda$init$3$com-bytedance-trae-conversation-widget-MenuPopupWindow(android.view.View)void
    .registers 2
    # ins_size=2
    const-string/jumbo v1, rename
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onRenameClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    return-void 
.end method

.method synthetic lambda$init$4$com-bytedance-trae-conversation-widget-MenuPopupWindow(android.view.View)void
    .registers 2
    # ins_size=2
    const-string v1, "delete"
    invoke-direct v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V
    iget-object v1, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    if-eqz v1, +005h
    invoke-interface v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onDeleteClick()V
    invoke-virtual v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V
    return-void 
.end method

.method public showAsDropDown(android.view.View  int  int)void
    .registers 6
    # ins_size=4
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    if-eqz v4, +030h
    invoke-virtual v4, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v4
    if-nez v4, +02ah
    iget-object v4, v2, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    const/4 v0, 0
    invoke-virtual v4, v0, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v3, Landroid/view/View;->getContext()Landroid/content/Context;
    move-result-object v4
    const/high16 v0, 1098907648
    invoke-direct v2, v4, v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dp2px(Landroid/content/Context; F)F
    move-result v4
    float-to-int v4, v4
    const/4 v0, 2
    new-array v0, v0, [I
    invoke-virtual v3, v0, Landroid/view/View;->getLocationOnScreen([I)V
    const/4 v1, 1
    aget v0, v0, v1
    invoke-virtual v3, Landroid/view/View;->getHeight()I
    move-result v1
    add-int/2addr v0, v1
    add-int/2addr v0, v5
    iget-object v5, v2, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    const v1, 8388661
    invoke-virtual v5, v3, v1, v4, v0, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public showAtLocation(android.view.View  int  int  int)void
    .registers 6
    # ins_size=5
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    if-eqz v0, +00dh
    invoke-virtual v0, Landroid/widget/PopupWindow;->isShowing()Z
    move-result v0
    if-nez v0, +007h
    iget-object v0, v1, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow Landroid/widget/PopupWindow;
    invoke-virtual v0, v2, v3, v4, v5, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View; I I I)V
    return-void 
.end method

.method public updatePinState(boolean  boolean)void
    .registers 6
    # ins_size=3
    iput-boolean v4, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin Z
    iput-boolean v5, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned Z
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    if-nez v0, +003h
    return-void 
    sget v1, Lcom/bytedance/trae/conversation/R$id;->menu_pin I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    iget-object v1, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v2, Lcom/bytedance/trae/conversation/R$id;->menu_divider_pin I
    invoke-virtual v1, v2, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v1
    if-eqz v4, +032h
    const/4 v4, 0
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    iget-object v4, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_menu_pin I
    invoke-virtual v4, v0, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/ImageView;
    iget-object v0, v3, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView Landroid/view/View;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_menu_pin I
    invoke-virtual v0, v1, Landroid/view/View;->findViewById(I)Landroid/view/View;
    move-result-object v0
    check-cast v0, Landroid/widget/TextView;
    if-eqz v5, +005h
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_unpin I
    goto +3h
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_pin I
    invoke-virtual v4, v1, Landroid/widget/ImageView;->setImageResource(I)V
    if-eqz v5, +005h
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_menu_unpin I
    goto +3h
    sget v4, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_menu_pin I
    invoke-virtual v0, v4, Landroid/widget/TextView;->setText(I)V
    goto +9h
    const/16 v4, 8
    invoke-virtual v0, v4, Landroid/view/View;->setVisibility(I)V
    invoke-virtual v1, v4, Landroid/view/View;->setVisibility(I)V
    return-void 
.end method
