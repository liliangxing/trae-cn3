# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
.super Ljava/lang/Object;
.source "TraeMediaChooseItemMediaBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivThumb:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final rootView:Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
.field public final selectionContainer:Landroid/widget/FrameLayout;
.field public final tvDuration:Landroid/widget/TextView;
.field public final tvOrder:Landroid/widget/TextView;
.field public final vMask:Landroid/view/View;


.method private constructor <init>(com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout  com.facebook.drawee.view.SimpleDraweeView  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView  android.view.View)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->rootView Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->ivThumb Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->selectionContainer Landroid/widget/FrameLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvDuration Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->tvOrder Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->vMask Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemMediaBinding
    .registers 10
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_thumb I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v4, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->selection_container I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +02ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_duration I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +01fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_order I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->v_mask I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    move-object v3, v9
    check-cast v3, Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;-><init>(Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/view/View;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemMediaBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemMediaBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_media_choose_item_media I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemMediaBinding;->rootView Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    return-object v0
.end method
