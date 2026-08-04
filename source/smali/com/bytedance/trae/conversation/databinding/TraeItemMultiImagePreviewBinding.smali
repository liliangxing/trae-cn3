# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;
.super Ljava/lang/Object;
.source "TraeItemMultiImagePreviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivPagerImage:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final rootView:Landroid/widget/FrameLayout;


.method private constructor <init>(android.widget.FrameLayout  com.facebook.drawee.view.SimpleDraweeView)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->ivPagerImage Lcom/facebook/drawee/view/SimpleDraweeView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemMultiImagePreviewBinding
    .registers 3
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_pager_image I
    invoke-static v2, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v1, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;
    check-cast v2, Landroid/widget/FrameLayout;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;-><init>(Landroid/widget/FrameLayout; Lcom/facebook/drawee/view/SimpleDraweeView;)V
    return-object v0
    invoke-virtual v2, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v2
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v2, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v2, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemMultiImagePreviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemMultiImagePreviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_multi_image_preview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemMultiImagePreviewBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
