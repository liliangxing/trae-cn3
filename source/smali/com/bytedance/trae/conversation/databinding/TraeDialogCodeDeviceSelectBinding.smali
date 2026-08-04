# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;
.super Ljava/lang/Object;
.source "TraeDialogCodeDeviceSelectBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final contentContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final progressLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final rvDevices:Landroidx/recyclerview/widget/RecyclerView;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  androidx.constraintlayout.widget.ConstraintLayout  android.widget.ProgressBar  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->contentContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->progressLoading Landroid/widget/ProgressBar;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->rvDevices Landroidx/recyclerview/widget/RecyclerView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeDialogCodeDeviceSelectBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->content_container I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ProgressBar;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_devices I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;
    move-object v3, v8
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/ProgressBar; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeDialogCodeDeviceSelectBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeDialogCodeDeviceSelectBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_code_device_select I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogCodeDeviceSelectBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
