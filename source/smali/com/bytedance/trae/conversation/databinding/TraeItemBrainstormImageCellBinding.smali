# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;
.super Ljava/lang/Object;
.source "TraeItemBrainstormImageCellBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final cardImageCell:Landroid/widget/FrameLayout;
.field public final ivCellClose:Landroid/widget/ImageView;
.field public final ivCellPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final overlayCellFailed:Landroid/widget/FrameLayout;
.field public final overlayCellLoading:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout  android.widget.ImageView  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  android.widget.FrameLayout)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->cardImageCell Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->ivCellClose Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->ivCellPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->overlayCellFailed Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->overlayCellLoading Landroid/widget/FrameLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemBrainstormImageCellBinding
    .registers 10
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->card_image_cell I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_cell_close I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_cell_preview I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v6, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_failed I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->overlay_cell_loading I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;
    move-object v3, v9
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout;)V
    return-object v0
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v9
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v9, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v9, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemBrainstormImageCellBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemBrainstormImageCellBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_brainstorm_image_cell I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemBrainstormImageCellBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
