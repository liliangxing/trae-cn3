# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;
.super Ljava/lang/Object;
.source "TraeDialogDocumentSelectBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomSheetContainer:Landroidx/constraintlayout/widget/ConstraintLayout;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final rvDocuments:Landroidx/recyclerview/widget/RecyclerView;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  androidx.constraintlayout.widget.ConstraintLayout  androidx.recyclerview.widget.RecyclerView  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->bottomSheetContainer Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->rvDocuments Landroidx/recyclerview/widget/RecyclerView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeDialogDocumentSelectBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->bottom_sheet_container I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v1, +01eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->rv_documents I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v2, +014h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;
    check-cast v4, Landroidx/constraintlayout/widget/ConstraintLayout;
    invoke-direct v0, v4, v1, v2, v3, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroidx/recyclerview/widget/RecyclerView; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    return-object v0
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v4
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v4, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeDialogDocumentSelectBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeDialogDocumentSelectBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_document_select I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogDocumentSelectBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
