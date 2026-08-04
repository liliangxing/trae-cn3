# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;
.super Ljava/lang/Object;
.source "FragmentSiteMessageListBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final dimOverlay:Landroid/view/View;
.field public final emptyState:Landroid/widget/LinearLayout;
.field public final floatingCard:Landroid/widget/ImageView;
.field public final rootContainer:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final rvMessages:Landroidx/recyclerview/widget/RecyclerView;
.field public final swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvEmpty:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.view.View  android.widget.LinearLayout  android.widget.ImageView  android.widget.FrameLayout  androidx.recyclerview.widget.RecyclerView  androidx.swiperefreshlayout.widget.SwipeRefreshLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->dimOverlay Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->emptyState Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->floatingCard Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->rootContainer Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->tvEmpty Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentSiteMessageListBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->dim_overlay I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +04fh
    sget v0, Lcom/bytedance/trae/home/R$id;->empty_state I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +044h
    sget v0, Lcom/bytedance/trae/home/R$id;->floating_card I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +039h
    move-object v6, v11
    check-cast v6, Landroid/widget/FrameLayout;
    sget v0, Lcom/bytedance/trae/home/R$id;->rv_messages I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v7, +02bh
    sget v0, Lcom/bytedance/trae/home/R$id;->swipe_refresh I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v8, +020h
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v9, +015h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_empty I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +00ah
    new-instance v11, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;
    move-object v1, v11
    move-object v2, v6
    invoke-direct/range v1 ... v10, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;-><init>(Landroid/widget/FrameLayout; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroidx/recyclerview/widget/RecyclerView; Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
    return-object v11
    invoke-virtual v11, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    invoke-virtual v11, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v11
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v11, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-direct v0, v11, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentSiteMessageListBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentSiteMessageListBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_site_message_list I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentSiteMessageListBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
