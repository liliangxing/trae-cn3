# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;
.super Ljava/lang/Object;
.source "BottomSheetSkillsBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final contentContainer:Landroid/widget/LinearLayout;
.field public final errorContainer:Landroid/widget/LinearLayout;
.field public final etSearch:Landroid/widget/EditText;
.field public final ivSearchClear:Landroid/widget/ImageView;
.field public final ivSearchIcon:Landroid/widget/ImageView;
.field public final loadingContainer:Landroid/widget/LinearLayout;
.field public final recyclerView:Landroidx/recyclerview/widget/RecyclerView;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final searchContainer:Landroid/widget/FrameLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvEmptyState:Landroid/widget/TextView;
.field public final tvErrorContent:Landroid/widget/TextView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.EditText  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  android.widget.FrameLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->contentContainer Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->errorContainer Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->etSearch Landroid/widget/EditText;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->ivSearchClear Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->ivSearchIcon Landroid/widget/ImageView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->loadingContainer Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->recyclerView Landroidx/recyclerview/widget/RecyclerView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->searchContainer Landroid/widget/FrameLayout;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->tvEmptyState Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->tvErrorContent Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.BottomSheetSkillsBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->content_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +07ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->error_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->et_search I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/EditText;
    if-eqz v6, +064h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_search_clear I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_search_icon I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/ImageView;
    if-eqz v8, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->loading_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->recycler_view I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v10, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->search_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/FrameLayout;
    if-eqz v11, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_empty_state I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_error_content I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;
    move-object v3, v15
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/FrameLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v15, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v15
    invoke-virtual v15, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v15
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v15, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v15
    invoke-direct v0, v15, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.BottomSheetSkillsBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.BottomSheetSkillsBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_skills I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetSkillsBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
