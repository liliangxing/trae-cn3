# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;
.super Ljava/lang/Object;
.source "FragmentTaskBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnRetryNetwork:Landroid/widget/Button;
.field public final btnTaskSearchClear:Landroid/widget/ImageButton;
.field public final btnTaskSearchExit:Landroid/widget/ImageButton;
.field public final etTaskSearch:Landroid/widget/EditText;
.field public final fabAdd:Lcom/google/android/material/floatingactionbutton/FloatingActionButton;
.field public final ivTaskSearchInputIcon:Landroid/widget/ImageView;
.field public final ivTaskSearchLoading:Lcom/bytedance/trae/common/widget/TraeLoadingView;
.field public final layoutEmptyState:Landroid/widget/LinearLayout;
.field public final layoutNetworkError:Landroid/widget/LinearLayout;
.field public final layoutTaskSearchEmptyState:Landroid/widget/LinearLayout;
.field public final layoutTaskSearchHeader:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final layoutTaskSearchInput:Landroid/widget/LinearLayout;
.field public final layoutTaskSearchLoading:Landroid/widget/LinearLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final rvTasks:Landroidx/recyclerview/widget/RecyclerView;
.field public final swipeRefresh:Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvTaskSearchEmptyText:Landroid/widget/TextView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.Button  android.widget.ImageButton  android.widget.ImageButton  android.widget.EditText  com.google.android.material.floatingactionbutton.FloatingActionButton  android.widget.ImageView  com.bytedance.trae.common.widget.TraeLoadingView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  androidx.constraintlayout.widget.ConstraintLayout  android.widget.LinearLayout  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  androidx.swiperefreshlayout.widget.SwipeRefreshLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 21
    # ins_size=19
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->btnRetryNetwork Landroid/widget/Button;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->btnTaskSearchClear Landroid/widget/ImageButton;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->btnTaskSearchExit Landroid/widget/ImageButton;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->etTaskSearch Landroid/widget/EditText;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->fabAdd Lcom/google/android/material/floatingactionbutton/FloatingActionButton;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->ivTaskSearchInputIcon Landroid/widget/ImageView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->ivTaskSearchLoading Lcom/bytedance/trae/common/widget/TraeLoadingView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutEmptyState Landroid/widget/LinearLayout;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutNetworkError Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutTaskSearchEmptyState Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutTaskSearchHeader Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutTaskSearchInput Landroid/widget/LinearLayout;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->layoutTaskSearchLoading Landroid/widget/LinearLayout;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->rvTasks Landroidx/recyclerview/widget/RecyclerView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->swipeRefresh Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->tvTaskSearchEmptyText Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentTaskBinding
    .registers 23
    # ins_size=1
    move-object/from16 v0, v22
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_retry_network I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/Button;
    if-eqz v5, +0c2h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_task_search_clear I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/ImageButton;
    if-eqz v6, +0b7h
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_task_search_exit I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/ImageButton;
    if-eqz v7, +0ach
    sget v1, Lcom/bytedance/trae/home/R$id;->et_task_search I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/EditText;
    if-eqz v8, +0a1h
    sget v1, Lcom/bytedance/trae/home/R$id;->fab_add I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Lcom/google/android/material/floatingactionbutton/FloatingActionButton;
    if-eqz v9, +096h
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_task_search_input_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/ImageView;
    if-eqz v10, +08bh
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_task_search_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeLoadingView;
    if-eqz v11, +080h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_state I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +075h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_network_error I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +06ah
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_empty_state I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +05fh
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_header I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v15, +054h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_input I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/LinearLayout;
    if-eqz v16, +048h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_task_search_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/LinearLayout;
    if-eqz v17, +03ch
    sget v1, Lcom/bytedance/trae/home/R$id;->rv_tasks I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v18, +030h
    sget v1, Lcom/bytedance/trae/home/R$id;->swipe_refresh I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;
    if-eqz v19, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v20, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_task_search_empty_text I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/TextView;
    if-eqz v21, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout;
    invoke-direct/range v3 ... v21, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/Button; Landroid/widget/ImageButton; Landroid/widget/ImageButton; Landroid/widget/EditText; Lcom/google/android/material/floatingactionbutton/FloatingActionButton; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/TraeLoadingView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v22, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentTaskBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentTaskBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_task I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentTaskBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
