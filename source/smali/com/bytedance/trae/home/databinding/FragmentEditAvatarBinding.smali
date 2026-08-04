# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;
.super Ljava/lang/Object;
.source "FragmentEditAvatarBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomButtonsContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final btnCancel:Landroid/widget/TextView;
.field public final btnOk:Landroid/widget/TextView;
.field public final ivAvatarPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  androidx.constraintlayout.widget.ConstraintLayout  android.widget.TextView  android.widget.TextView  com.facebook.drawee.view.SimpleDraweeView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->bottomButtonsContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->btnCancel Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->btnOk Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->ivAvatarPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentEditAvatarBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->bottom_buttons_container I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cancel I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_ok I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_avatar_preview I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;
    move-object v3, v8
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/TextView; Landroid/widget/TextView; Lcom/facebook/drawee/view/SimpleDraweeView;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentEditAvatarBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentEditAvatarBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_edit_avatar I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentEditAvatarBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
