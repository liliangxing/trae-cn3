# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;
.super Ljava/lang/Object;
.source "TraeActivityDiffViewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnExtend:Landroid/widget/ImageView;
.field public final btnRetry:Landroid/widget/TextView;
.field public final btnRight:Landroid/widget/LinearLayout;
.field public final layoutError:Landroid/widget/LinearLayout;
.field public final llTitleContainer:Landroid/widget/LinearLayout;
.field public final progressBar:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final toolbar:Landroidx/appcompat/widget/Toolbar;
.field public final tvErrorSubtitle:Landroid/widget/TextView;
.field public final tvErrorTitle:Landroid/widget/TextView;
.field public final tvSubtitle:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final webviewDiff:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.TextView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  androidx.appcompat.widget.Toolbar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.webkit.WebView)void
    .registers 15
    # ins_size=15
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->btnBack Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->btnExtend Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->btnRetry Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->btnRight Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->layoutError Landroid/widget/LinearLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->llTitleContainer Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->progressBar Landroid/widget/ProgressBar;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->toolbar Landroidx/appcompat/widget/Toolbar;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->tvErrorSubtitle Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->tvErrorTitle Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->tvSubtitle Landroid/widget/TextView;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->tvTitle Landroid/widget/TextView;
    iput-object v14, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->webviewDiff Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeActivityDiffViewBinding
    .registers 19
    # ins_size=1
    move-object/from16 v0, v18
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +092h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_extend I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +087h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +07ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_right I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/LinearLayout;
    if-eqz v8, +071h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_error I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +066h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_title_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +05bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/ProgressBar;
    if-eqz v11, +050h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->toolbar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroidx/appcompat/widget/Toolbar;
    if-eqz v12, +045h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_error_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +03ah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_error_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +02fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->webview_diff I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/webkit/WebView;
    if-eqz v17, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    move-object v3, v1
    invoke-direct/range v3 ... v17, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroidx/appcompat/widget/Toolbar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/webkit/WebView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeActivityDiffViewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeActivityDiffViewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_diff_view I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityDiffViewBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
