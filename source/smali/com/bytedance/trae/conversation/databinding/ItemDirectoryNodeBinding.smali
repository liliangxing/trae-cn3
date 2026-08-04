# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;
.super Ljava/lang/Object;
.source "ItemDirectoryNodeBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final divider:Landroid/view/View;
.field public final ivArrow:Landroid/widget/ImageView;
.field public final ivIcon:Landroid/widget/ImageView;
.field public final progressLoading:Landroid/widget/ProgressBar;
.field public final rbSelect:Landroid/widget/RadioButton;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final tvName:Landroid/widget/TextView;
.field public final viewIndent:Landroid/view/View;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.view.View  android.widget.ImageView  android.widget.ImageView  android.widget.ProgressBar  android.widget.RadioButton  android.widget.TextView  android.view.View)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->divider Landroid/view/View;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->ivArrow Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->ivIcon Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->progressLoading Landroid/widget/ProgressBar;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->rbSelect Landroid/widget/RadioButton;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->tvName Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->viewIndent Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeBinding
    .registers 11
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->divider I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    if-eqz v3, +04bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_arrow I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +040h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +035h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_loading I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ProgressBar;
    if-eqz v6, +02ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rb_select I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/RadioButton;
    if-eqz v7, +01fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_name I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->view_indent I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v9
    if-eqz v9, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;
    move-object v2, v10
    check-cast v2, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v1, v0
    invoke-direct/range v1 ... v9, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/view/View; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ProgressBar; Landroid/widget/RadioButton; Landroid/widget/TextView; Landroid/view/View;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->item_directory_node I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
