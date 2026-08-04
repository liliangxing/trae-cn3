# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;
.super Ljava/lang/Object;
.source "TraeActivityWebPreviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnRetry:Landroid/widget/TextView;
.field public final btnStartAgent:Landroid/widget/TextView;
.field public final errorContainer:Landroid/widget/FrameLayout;
.field public final progressBar:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final statusError:Landroid/widget/TextView;
.field public final statusErrorDesc:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final webview:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.TextView  android.widget.TextView  android.widget.FrameLayout  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.webkit.WebView)void
    .registers 11
    # ins_size=11
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->btnBack Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->btnRetry Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->btnStartAgent Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->errorContainer Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->progressBar Landroid/widget/ProgressBar;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->statusError Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->statusErrorDesc Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->tvTitle Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->webview Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeActivityWebPreviewBinding
    .registers 14
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +064h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_retry I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_start_agent I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->error_container I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/ProgressBar;
    if-eqz v8, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->status_error I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->status_error_desc I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-static v13, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/webkit/WebView;
    if-eqz v12, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;
    move-object v3, v13
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v12, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/webkit/WebView;)V
    return-object v0
    invoke-virtual v13, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v13
    invoke-virtual v13, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v13
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v13, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v13
    invoke-direct v0, v13, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeActivityWebPreviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeActivityWebPreviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_activity_web_preview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeActivityWebPreviewBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
