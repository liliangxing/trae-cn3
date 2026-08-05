.class public Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;
.super Ljava/lang/Object;
.source "MenuPopupWindow.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;
    }
.end annotation


# instance fields
.field private contentView:Landroid/view/View;

.field private isPinned:Z

.field private listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

.field private popupWindow:Landroid/widget/PopupWindow;

.field private showArtifact:Z

.field private showPin:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;)V
    .locals 6

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    .line 41
    invoke-direct/range {v0 .. v5}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;-><init>(Landroid/content/Context;Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;ZZZ)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;Z)V
    .locals 6

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    .line 45
    invoke-direct/range {v0 .. v5}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;-><init>(Landroid/content/Context;Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;ZZZ)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;ZZZ)V
    .locals 0

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p2, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    .line 50
    iput-boolean p3, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showArtifact:Z

    .line 51
    iput-boolean p4, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin:Z

    .line 52
    iput-boolean p5, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned:Z

    .line 53
    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->init(Landroid/content/Context;)V

    return-void
.end method

.method private dp2px(Landroid/content/Context;F)F
    .locals 0

    .line 194
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object p1

    invoke-virtual {p1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object p1

    iget p1, p1, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr p2, p1

    return p2
.end method

.method private init(Landroid/content/Context;)V
    .locals 5

    .line 58
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/bytedance/trae/conversation/R$layout;->conversation_popup_menu:I

    const/4 v2, 0x0

    const/4 v3, 0x0

    .line 59
    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    .line 62
    new-instance v0, Landroid/widget/PopupWindow;

    iget-object v1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    const/4 v2, -0x2

    const/4 v4, 0x1

    invoke-direct {v0, v1, v2, v2, v4}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;IIZ)V

    iput-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    .line 70
    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-direct {v1, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 73
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    const/high16 v1, 0x41000000    # 8.0f

    invoke-direct {p0, p1, v1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dp2px(Landroid/content/Context;F)F

    move-result p1

    invoke-virtual {v0, p1}, Landroid/widget/PopupWindow;->setElevation(F)V

    .line 76
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    const v0, 0x1030002

    invoke-virtual {p1, v0}, Landroid/widget/PopupWindow;->setAnimationStyle(I)V

    .line 79
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {p1, v4}, Landroid/widget/PopupWindow;->setOutsideTouchable(Z)V

    .line 80
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda0;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda0;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/widget/PopupWindow;->setOnDismissListener(Landroid/widget/PopupWindow$OnDismissListener;)V

    # Extract button setup
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_extract:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda5;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda5;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_artifact:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda1;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda1;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_pin:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda2;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda2;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 99
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_rename:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda3;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda3;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_delete:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    new-instance v0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda4;

    invoke-direct {v0, p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$$ExternalSyntheticLambda4;-><init>(Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;)V

    invoke-virtual {p1, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    iget-boolean p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showArtifact:Z

    if-nez p1, :cond_0

    .line 113
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->menu_artifact:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 114
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v1, Lcom/bytedance/trae/conversation/R$id;->menu_divider_artifact:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 117
    :cond_0
    iget-boolean p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin:Z

    iget-boolean v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned:Z

    invoke-virtual {p0, p1, v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->updatePinState(ZZ)V

    return-void
.end method

.method private trackMenuActionClick(Ljava/lang/String;)V
    .locals 1

    .line 190
    sget-object v0, Lcom/bytedance/trae/conversation/tracker/InputTracker;->INSTANCE:Lcom/bytedance/trae/conversation/tracker/InputTracker;

    invoke-virtual {v0, p1}, Lcom/bytedance/trae/conversation/tracker/InputTracker;->trackConversationMenuItemClick(Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public dismiss()V
    .locals 1

    .line 180
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 181
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->dismiss()V

    :cond_0
    return-void
.end method

.method public isShowing()Z
    .locals 1

    .line 186
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method synthetic lambda$init$0$com-bytedance-trae-conversation-widget-MenuPopupWindow()V
    .locals 2

    .line 81
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    if-eqz v0, :cond_0

    const/16 v1, 0x8

    .line 82
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    :cond_0
    return-void
.end method

.method synthetic lambda$init$1$com-bytedance-trae-conversation-widget-MenuPopupWindow(Landroid/view/View;)V
    .locals 0

    const-string p1, "artifacts"

    .line 88
    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V

    .line 89
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onArtifactClick()V

    .line 90
    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    return-void
.end method

.method synthetic lambda$init$2$com-bytedance-trae-conversation-widget-MenuPopupWindow(Landroid/view/View;)V
    .locals 0

    .line 94
    iget-boolean p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned:Z

    if-eqz p1, :cond_0

    const-string/jumbo p1, "unpin"

    goto :goto_0

    :cond_0
    const-string p1, "pin"

    :goto_0
    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V

    .line 95
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    if-eqz p1, :cond_1

    invoke-interface {p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onPinClick()V

    .line 96
    :cond_1
    invoke-virtual {p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    return-void
.end method

.method synthetic lambda$init$3$com-bytedance-trae-conversation-widget-MenuPopupWindow(Landroid/view/View;)V
    .locals 0

    const-string/jumbo p1, "rename"

    .line 100
    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V

    .line 101
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onRenameClick()V

    .line 102
    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    return-void
.end method

.method synthetic lambda$init$4$com-bytedance-trae-conversation-widget-MenuPopupWindow(Landroid/view/View;)V
    .locals 0

    const-string p1, "delete"

    .line 106
    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V

    .line 107
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onDeleteClick()V

    .line 108
    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    return-void
.end method

.method synthetic lambda$init$5$com-bytedance-trae-conversation-widget-MenuPopupWindow(Landroid/view/View;)V
    .locals 0

    const-string p1, "extract"

    invoke-direct {p0, p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->trackMenuActionClick(Ljava/lang/String;)V

    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->listener:Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;

    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow$OnMenuClickListener;->onExtractClick()V

    :cond_0
    invoke-virtual {p0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dismiss()V

    return-void
.end method

.method public showAsDropDown(Landroid/view/View;II)V
    .locals 2

    .line 153
    iget-object p2, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result p2

    if-nez p2, :cond_0

    .line 154
    iget-object p2, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    const/4 v0, 0x0

    invoke-virtual {p2, v0}, Landroid/view/View;->setVisibility(I)V

    .line 155
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object p2

    const/high16 v0, 0x41800000    # 16.0f

    invoke-direct {p0, p2, v0}, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->dp2px(Landroid/content/Context;F)F

    move-result p2

    float-to-int p2, p2

    const/4 v0, 0x2

    new-array v0, v0, [I

    .line 158
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationOnScreen([I)V

    const/4 v1, 0x1

    aget v0, v0, v1

    .line 159
    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v1

    add-int/2addr v0, v1

    add-int/2addr v0, p3

    .line 161
    iget-object p3, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    const v1, 0x800035

    invoke-virtual {p3, p1, v1, p2, v0}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    :cond_0
    return-void
.end method

.method public showAtLocation(Landroid/view/View;III)V
    .locals 1

    .line 174
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/widget/PopupWindow;->isShowing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->popupWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/widget/PopupWindow;->showAtLocation(Landroid/view/View;III)V

    :cond_0
    return-void
.end method

.method public updatePinState(ZZ)V
    .locals 3

    .line 121
    iput-boolean p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->showPin:Z

    .line 122
    iput-boolean p2, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->isPinned:Z

    .line 123
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    if-nez v0, :cond_0

    return-void

    .line 126
    :cond_0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->menu_pin:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 127
    iget-object v1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v2, Lcom/bytedance/trae/conversation/R$id;->menu_divider_pin:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz p1, :cond_3

    const/4 p1, 0x0

    .line 129
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 130
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 131
    iget-object p1, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_menu_pin:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object p1

    check-cast p1, Landroid/widget/ImageView;

    .line 132
    iget-object v0, p0, Lcom/bytedance/trae/conversation/widget/MenuPopupWindow;->contentView:Landroid/view/View;

    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_menu_pin:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    if-eqz p2, :cond_1

    .line 134
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_unpin:I

    goto :goto_0

    .line 135
    :cond_1
    sget v1, Lcom/bytedance/trae/common_ui/R$drawable;->trae_ic_context_menu_pin:I

    .line 133
    :goto_0
    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    if-eqz p2, :cond_2

    .line 137
    sget p1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_menu_unpin:I

    goto :goto_1

    .line 138
    :cond_2
    sget p1, Lcom/bytedance/trae/multilanguage/R$string;->trae_conversation_menu_pin:I

    .line 136
    :goto_1
    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_2

    :cond_3
    const/16 p1, 0x8

    .line 140
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 141
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    :goto_2
    return-void
.end method
