# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;
.super Ljava/lang/Object;
.source "TraeDialogShareLinkBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCopied:Landroid/widget/TextView;
.field public final btnCopyLink:Landroid/widget/TextView;
.field public final btnGenerateContainer:Landroid/widget/LinearLayout;
.field public final btnGenerateLink:Landroid/widget/TextView;
.field public final btnStopSharing:Landroid/widget/TextView;
.field public final ivLoading:Landroid/widget/ImageView;
.field public final llGenerating:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final shareLinkDesc:Landroid/widget/TextView;
.field public final successContainer:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvShareUrl:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.ImageView  android.widget.LinearLayout  android.widget.TextView  android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->btnCopied Landroid/widget/TextView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->btnCopyLink Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->btnGenerateContainer Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->btnGenerateLink Landroid/widget/TextView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->btnStopSharing Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->ivLoading Landroid/widget/ImageView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->llGenerating Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->shareLinkDesc Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->successContainer Landroid/widget/LinearLayout;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->tvShareUrl Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeDialogShareLinkBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_copied I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/TextView;
    if-eqz v4, +07ah
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_copy_link I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_generate_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +064h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_generate_link I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_stop_sharing I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_loading I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_generating I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->share_link_desc I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->success_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_share_url I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;
    move-object v3, v15
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeDialogShareLinkBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeDialogShareLinkBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_share_link I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogShareLinkBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
