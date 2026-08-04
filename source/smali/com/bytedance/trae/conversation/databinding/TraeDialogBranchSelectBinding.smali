# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;
.super Ljava/lang/Object;
.source "TraeDialogBranchSelectBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomSheetContainer:Landroid/widget/LinearLayout;
.field public final btnGoToGithub:Landroid/widget/TextView;
.field public final etSearch:Landroid/widget/EditText;
.field public final ivSearchClear:Landroid/widget/ImageView;
.field public final ivSearchIcon:Landroid/widget/ImageView;
.field public final layoutContent:Landroid/widget/LinearLayout;
.field public final layoutEmptyState:Landroid/widget/LinearLayout;
.field public final pbLoadingMore:Landroid/widget/ProgressBar;
.field public final progressBar:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rvBranches:Landroidx/recyclerview/widget/RecyclerView;
.field public final searchContainer:Landroid/widget/FrameLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvEmptyHint:Landroid/widget/TextView;
.field public final tvSearchEmpty:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.EditText  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView)void
    .registers 16
    # ins_size=16
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->bottomSheetContainer Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->btnGoToGithub Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->etSearch Landroid/widget/EditText;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->ivSearchClear Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->ivSearchIcon Landroid/widget/ImageView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->layoutContent Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->layoutEmptyState Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->pbLoadingMore Landroid/widget/ProgressBar;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->progressBar Landroid/widget/ProgressBar;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->rvBranches Landroidx/recyclerview/widget/RecyclerView;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->searchContainer Landroid/widget/FrameLayout;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->tvEmptyHint Landroid/widget/TextView;
    iput-object v15, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->tvSearchEmpty Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeDialogBranchSelectBinding
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    move-object v2, v0
    check-cast v2, Landroid/widget/LinearLayout;
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_go_to_github I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Landroid/widget/TextView;
    if-eqz v3, +083h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->et_search I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v4
    check-cast v4, Landroid/widget/EditText;
    if-eqz v4, +079h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_search_clear I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v5
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +06fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_search_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v6
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +065h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v7
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +05bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_empty_state I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +051h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->pb_loading_more I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v9
    check-cast v9, Landroid/widget/ProgressBar;
    if-eqz v9, +047h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v10
    check-cast v10, Landroid/widget/ProgressBar;
    if-eqz v10, +03dh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_branches I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v11
    check-cast v11, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v11, +033h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->search_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v12
    check-cast v12, Landroid/widget/FrameLayout;
    if-eqz v12, +029h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v13
    check-cast v13, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v13, +01fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_empty_hint I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v14
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +015h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_search_empty I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v15
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +00bh
    new-instance v16, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;
    move-object/from16 v0, v16
    move-object v1, v2
    invoke-direct/range v0 ... v15, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v16
    invoke-virtual/range v17, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v0
    invoke-virtual v0, v1, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v0
    new-instance v1, Ljava/lang/NullPointerException;
    const-string v2, "Missing required view with ID: "
    invoke-virtual v2, v0, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v0
    invoke-direct v1, v0, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v1
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeDialogBranchSelectBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeDialogBranchSelectBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_branch_select I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogBranchSelectBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
