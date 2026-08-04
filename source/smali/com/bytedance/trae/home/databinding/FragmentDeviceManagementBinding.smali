# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;
.super Ljava/lang/Object;
.source "FragmentDeviceManagementBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnAddDevice:Landroid/widget/TextView;
.field public final emptyGuideContent:Landroid/widget/FrameLayout;
.field public final indicatorEmptyGuideIde:Landroid/view/View;
.field public final indicatorEmptyGuideWork:Landroid/view/View;
.field public final layoutEmptyGuide:Landroid/widget/LinearLayout;
.field public final layoutEmptyGuideTabs:Landroid/widget/LinearLayout;
.field public final progressLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rvDeviceManagement:Landroidx/recyclerview/widget/RecyclerView;
.field public final tabEmptyGuideIde:Landroid/widget/LinearLayout;
.field public final tabEmptyGuideWork:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvEmptyGuideIdeTab:Landroid/widget/TextView;
.field public final tvEmptyGuideWorkTab:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.FrameLayout  android.view.View  android.view.View  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  android.widget.LinearLayout  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView)void
    .registers 15
    # ins_size=15
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->btnAddDevice Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->emptyGuideContent Landroid/widget/FrameLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->indicatorEmptyGuideIde Landroid/view/View;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->indicatorEmptyGuideWork Landroid/view/View;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->layoutEmptyGuide Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->layoutEmptyGuideTabs Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->progressLoading Landroid/widget/ProgressBar;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->rvDeviceManagement Landroidx/recyclerview/widget/RecyclerView;
    iput-object v10, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->tabEmptyGuideIde Landroid/widget/LinearLayout;
    iput-object v11, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->tabEmptyGuideWork Landroid/widget/LinearLayout;
    iput-object v12, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v13, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->tvEmptyGuideIdeTab Landroid/widget/TextView;
    iput-object v14, v0, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->tvEmptyGuideWorkTab Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentDeviceManagementBinding
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_add_device I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +08ch
    sget v1, Lcom/bytedance/trae/home/R$id;->empty_guide_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/FrameLayout;
    if-eqz v6, +081h
    sget v1, Lcom/bytedance/trae/home/R$id;->indicator_empty_guide_ide I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v7
    if-eqz v7, +079h
    sget v1, Lcom/bytedance/trae/home/R$id;->indicator_empty_guide_work I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +071h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_guide I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +066h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_empty_guide_tabs I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +05bh
    sget v1, Lcom/bytedance/trae/home/R$id;->progress_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/ProgressBar;
    if-eqz v11, +050h
    sget v1, Lcom/bytedance/trae/home/R$id;->rv_device_management I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v12, +045h
    sget v1, Lcom/bytedance/trae/home/R$id;->tab_empty_guide_ide I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +03ah
    sget v1, Lcom/bytedance/trae/home/R$id;->tab_empty_guide_work I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +02fh
    sget v1, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v15, +024h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_empty_guide_ide_tab I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +018h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_empty_guide_work_tab I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    move-object v3, v1
    invoke-direct/range v3 ... v17, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/FrameLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v18, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentDeviceManagementBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentDeviceManagementBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_device_management I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentDeviceManagementBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
