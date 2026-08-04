# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;
.super Ljava/lang/Object;
.source "TraeLayoutArtifactPreviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnDownload:Landroid/widget/FrameLayout;
.field public final btnMainDownload:Landroid/widget/TextView;
.field public final downloadStatusTile:Landroid/widget/TextView;
.field public final imageContainer:Landroid/widget/FrameLayout;
.field public final ivPreview:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final layoutContent:Landroid/widget/LinearLayout;
.field public final llTitleContainer:Landroid/widget/LinearLayout;
.field public final llTrailingActions:Landroid/widget/LinearLayout;
.field public final progressBar:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final scrollMarkdown:Landroid/widget/ScrollView;
.field public final scrollTxt:Landroid/widget/ScrollView;
.field public final tvMarkdown:Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
.field public final tvSubtitle:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final tvTxt:Landroid/widget/TextView;
.field public final webview:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView  android.widget.FrameLayout  com.facebook.drawee.view.SimpleDraweeView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.ScrollView  android.widget.ScrollView  com.bytedance.trae.conversation.chat.block.renderer.SimpleMarkdownTextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.webkit.WebView)void
    .registers 21
    # ins_size=19
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->rootView Landroid/widget/LinearLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->btnBack Landroid/widget/ImageView;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->btnDownload Landroid/widget/FrameLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->btnMainDownload Landroid/widget/TextView;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->downloadStatusTile Landroid/widget/TextView;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->imageContainer Landroid/widget/FrameLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->ivPreview Lcom/facebook/drawee/view/SimpleDraweeView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->layoutContent Landroid/widget/LinearLayout;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->llTitleContainer Landroid/widget/LinearLayout;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->llTrailingActions Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->progressBar Landroid/widget/ProgressBar;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->scrollMarkdown Landroid/widget/ScrollView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->scrollTxt Landroid/widget/ScrollView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->tvMarkdown Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->tvSubtitle Landroid/widget/TextView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->tvTitle Landroid/widget/TextView;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->tvTxt Landroid/widget/TextView;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->webview Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeLayoutArtifactPreviewBinding
    .registers 23
    # ins_size=1
    move-object/from16 v0, v22
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +0c2h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/FrameLayout;
    if-eqz v6, +0b7h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_main_download I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +0ach
    sget v1, Lcom/bytedance/trae/conversation/R$id;->download_status_tile I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +0a1h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->image_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +096h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_preview I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v10, +08bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->layout_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +080h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_title_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/LinearLayout;
    if-eqz v12, +075h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->ll_trailing_actions I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +06ah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/ProgressBar;
    if-eqz v14, +05fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->scroll_markdown I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/ScrollView;
    if-eqz v15, +054h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->scroll_txt I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/ScrollView;
    if-eqz v16, +048h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_markdown I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView;
    if-eqz v17, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/TextView;
    if-eqz v18, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/TextView;
    if-eqz v19, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_txt I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/TextView;
    if-eqz v20, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->webview I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/webkit/WebView;
    if-eqz v21, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct/range v3 ... v21, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/FrameLayout; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/ScrollView; Landroid/widget/ScrollView; Lcom/bytedance/trae/conversation/chat/block/renderer/SimpleMarkdownTextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/webkit/WebView;)V
    return-object v1
    invoke-virtual/range v22, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeLayoutArtifactPreviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeLayoutArtifactPreviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_artifact_preview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutArtifactPreviewBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
