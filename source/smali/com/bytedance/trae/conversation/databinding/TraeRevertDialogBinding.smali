# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;
.super Ljava/lang/Object;
.source "TraeRevertDialogBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCancel:Landroid/widget/TextView;
.field public final btnConfirm:Landroid/widget/TextView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final rvFileList:Landroidx/recyclerview/widget/RecyclerView;
.field public final tvDialogTitle:Landroid/widget/TextView;
.field public final tvMessage:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  androidx.recyclerview.widget.RecyclerView  android.widget.TextView  android.widget.TextView)void
    .registers 7
    # ins_size=7
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->btnCancel Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->btnConfirm Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->rvFileList Landroidx/recyclerview/widget/RecyclerView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->tvDialogTitle Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->tvMessage Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeRevertDialogBinding
    .registers 10
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_confirm I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_file_list I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v6, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_dialog_title I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_message I
    invoke-static v9, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;
    move-object v3, v9
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v8, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroidx/recyclerview/widget/RecyclerView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v9, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v9
    invoke-virtual v9, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v9
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v9, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v9
    invoke-direct v0, v9, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeRevertDialogBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeRevertDialogBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_revert_dialog I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeRevertDialogBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
