# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;
.super Ljava/lang/Object;
.source "ItemSiteMessageBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCta:Landroid/widget/TextView;
.field public final btnDelete:Landroid/widget/LinearLayout;
.field public final layoutContent:Landroid/widget/FrameLayout;
.field public final layoutSwipeActions:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvBody:Landroid/widget/TextView;
.field public final tvTime:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final vUnreadDot:Landroid/view/View;


.method private constructor <init>(android.widget.FrameLayout  android.widget.TextView  android.widget.LinearLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.view.View)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->btnCta Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->btnDelete Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->layoutContent Landroid/widget/FrameLayout;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->layoutSwipeActions Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->tvBody Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->tvTime Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->tvTitle Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->vUnreadDot Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.ItemSiteMessageBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_cta I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +056h
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +04bh
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/FrameLayout;
    if-eqz v6, +040h
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +035h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_body I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +02ah
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_time I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +01fh
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +014h
    sget v0, Lcom/bytedance/trae/home/R$id;->v_unread_dot I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v11
    if-eqz v11, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;
    move-object v3, v12
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/view/View;)V
    return-object v0
    invoke-virtual v12, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v12, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v0, v12, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.ItemSiteMessageBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.ItemSiteMessageBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_site_message I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/ItemSiteMessageBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
