# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/ViewSplashBinding;
.super Ljava/lang/Object;
.source "ViewSplashBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final logoImage:Landroid/widget/ImageView;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final sloganText:Landroid/widget/TextView;
.field public final splashContainer:Landroidx/constraintlayout/widget/ConstraintLayout;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.ImageView  android.widget.TextView  androidx.constraintlayout.widget.ConstraintLayout)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->logoImage Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->sloganText Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->splashContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.ViewSplashBinding
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->logo_image I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    if-eqz v1, +014h
    sget v0, Lcom/bytedance/trae/home/R$id;->slogan_text I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +00ah
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    new-instance v0, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;
    invoke-direct v0, v3, v1, v2, v3, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/ImageView; Landroid/widget/TextView; Landroidx/constraintlayout/widget/ConstraintLayout;)V
    return-object v0
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v3
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v3, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.ViewSplashBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/ViewSplashBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.ViewSplashBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->view_splash I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/ViewSplashBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/ViewSplashBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
