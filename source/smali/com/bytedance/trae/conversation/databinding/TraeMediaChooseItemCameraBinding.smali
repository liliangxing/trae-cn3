# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
.super Ljava/lang/Object;
.source "TraeMediaChooseItemCameraBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivCamera:Landroid/widget/ImageView;
.field private final rootView:Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;


.method private constructor <init>(com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout  android.widget.ImageView)void
    .registers 3
    # ins_size=3
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->rootView Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->ivCamera Landroid/widget/ImageView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemCameraBinding
    .registers 3
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_camera I
    invoke-static v2, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    if-eqz v1, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    check-cast v2, Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    invoke-direct v0, v2, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;-><init>(Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout; Landroid/widget/ImageView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemCameraBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeMediaChooseItemCameraBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_media_choose_item_camera I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->getRoot()Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()com.bytedance.trae.conversation.mediachoose.widget.SquareFrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseItemCameraBinding;->rootView Lcom/bytedance/trae/conversation/mediachoose/widget/SquareFrameLayout;
    return-object v0
.end method
