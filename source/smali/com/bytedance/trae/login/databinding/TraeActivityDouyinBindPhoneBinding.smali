# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
.super Ljava/lang/Object;
.source "TraeActivityDouyinBindPhoneBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final fragmentContainer:Landroid/widget/FrameLayout;
.field public final ivBack:Landroid/widget/ImageView;
.field public final loadingOverlay:Landroid/widget/FrameLayout;
.field public final navBar:Landroidx/constraintlayout/widget/ConstraintLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.FrameLayout  android.widget.ImageView  android.widget.FrameLayout  androidx.constraintlayout.widget.ConstraintLayout)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->fragmentContainer Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->ivBack Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->loadingOverlay Landroid/widget/FrameLayout;
    iput-object v5, v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->navBar Landroidx/constraintlayout/widget/ConstraintLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeActivityDouyinBindPhoneBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->fragment_container I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/login/R$id;->iv_back I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/login/R$id;->loading_overlay I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/FrameLayout;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/login/R$id;->nav_bar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    move-object v3, v8
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroidx/constraintlayout/widget/ConstraintLayout;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeActivityDouyinBindPhoneBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeActivityDouyinBindPhoneBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_douyin_bind_phone I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityDouyinBindPhoneBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
