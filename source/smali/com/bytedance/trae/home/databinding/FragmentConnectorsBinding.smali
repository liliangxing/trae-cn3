# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;
.super Ljava/lang/Object;
.source "FragmentConnectorsBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final cardGithub:Landroid/widget/LinearLayout;
.field public final cardManageGithub:Landroid/widget/LinearLayout;
.field public final dividerGithub:Landroid/view/View;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final switchGithub:Landroidx/appcompat/widget/SwitchCompat;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvGithubTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.view.View  androidx.appcompat.widget.SwitchCompat  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->cardGithub Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->cardManageGithub Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->dividerGithub Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->switchGithub Landroidx/appcompat/widget/SwitchCompat;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->tvGithubTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentConnectorsBinding
    .registers 11
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->card_github I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +040h
    sget v0, Lcom/bytedance/trae/home/R$id;->card_manage_github I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +035h
    sget v0, Lcom/bytedance/trae/home/R$id;->divider_github I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v6
    if-eqz v6, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->switch_github I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroidx/appcompat/widget/SwitchCompat;
    if-eqz v7, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v8, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_github_title I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;
    move-object v3, v10
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/view/View; Landroidx/appcompat/widget/SwitchCompat; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v10, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v10
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v10, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentConnectorsBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentConnectorsBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_connectors I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentConnectorsBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
