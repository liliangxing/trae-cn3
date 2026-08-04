# Decompiled TRAE business class
# Source DEX: classes4.dex
.class public final Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;
.super Ljava/lang/Object;
.source "TraeActivityAccountLoginBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final fragmentContainer:Landroid/widget/FrameLayout;
.field public final loginLoadingOverlay:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout  android.widget.FrameLayout)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->fragmentContainer Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->loginLoadingOverlay Landroid/widget/FrameLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.login.databinding.TraeActivityAccountLoginBinding
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/login/R$id;->fragment_container I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +014h
    sget v0, Lcom/bytedance/trae/login/R$id;->login_loading_overlay I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/FrameLayout;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;
    check-cast v3, Landroid/widget/FrameLayout;
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.login.databinding.TraeActivityAccountLoginBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.login.databinding.TraeActivityAccountLoginBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/login/R$layout;->trae_activity_account_login I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/login/databinding/TraeActivityAccountLoginBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
