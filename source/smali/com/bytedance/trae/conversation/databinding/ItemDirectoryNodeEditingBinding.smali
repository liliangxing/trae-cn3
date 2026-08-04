# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;
.super Ljava/lang/Object;
.source "ItemDirectoryNodeEditingBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final etFolderName:Landroid/widget/EditText;
.field public final ivIconEditing:Landroid/widget/ImageView;
.field public final progressCreating:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final viewIndentEditing:Landroid/view/View;


.method private constructor <init>(android.widget.LinearLayout  android.widget.EditText  android.widget.ImageView  android.widget.ProgressBar  android.view.View)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->etFolderName Landroid/widget/EditText;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->ivIconEditing Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->progressCreating Landroid/widget/ProgressBar;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->viewIndentEditing Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeEditingBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->et_folder_name I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/EditText;
    if-eqz v4, +02ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon_editing I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +01fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_creating I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ProgressBar;
    if-eqz v6, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->view_indent_editing I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v7
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/EditText; Landroid/widget/ImageView; Landroid/widget/ProgressBar; Landroid/view/View;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeEditingBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.ItemDirectoryNodeEditingBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->item_directory_node_editing I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/ItemDirectoryNodeEditingBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
