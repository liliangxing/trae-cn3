# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;
.super Ljava/lang/Object;
.source "TraeFragmentConversationDetailBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnScrollToBottom:Landroid/widget/ImageView;
.field public final progressNewerPageLoading:Lcom/bytedance/trae/common/widget/TraeLoadingView;
.field public final progressOlderPageLoading:Lcom/bytedance/trae/common/widget/TraeLoadingView;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final rvMessages:Landroidx/recyclerview/widget/RecyclerView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.ImageView  com.bytedance.trae.common.widget.TraeLoadingView  com.bytedance.trae.common.widget.TraeLoadingView  androidx.recyclerview.widget.RecyclerView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->btnScrollToBottom Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->progressNewerPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->progressOlderPageLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->rvMessages Landroidx/recyclerview/widget/RecyclerView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeFragmentConversationDetailBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_scroll_to_bottom I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_newer_page_loading I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeLoadingView;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_older_page_loading I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Lcom/bytedance/trae/common/widget/TraeLoadingView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_messages I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/TraeLoadingView; Lcom/bytedance/trae/common/widget/TraeLoadingView; Landroidx/recyclerview/widget/RecyclerView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeFragmentConversationDetailBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeFragmentConversationDetailBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_conversation_detail I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentConversationDetailBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
