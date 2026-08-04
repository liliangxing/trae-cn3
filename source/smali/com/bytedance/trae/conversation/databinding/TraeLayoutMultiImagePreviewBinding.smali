# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;
.super Ljava/lang/Object;
.source "TraeLayoutMultiImagePreviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnBack:Landroid/widget/ImageView;
.field public final btnDownload:Landroid/widget/FrameLayout;
.field public final progressBar:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final topBar:Landroid/widget/FrameLayout;
.field public final tvGeneratedByAi:Landroid/widget/TextView;
.field public final tvIndicator:Landroid/widget/TextView;
.field public final viewPager:Landroidx/viewpager2/widget/ViewPager2;


.method private constructor <init>(android.widget.FrameLayout  android.widget.ImageView  android.widget.FrameLayout  android.widget.ProgressBar  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView  androidx.viewpager2.widget.ViewPager2)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->btnBack Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->btnDownload Landroid/widget/FrameLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->progressBar Landroid/widget/ProgressBar;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->topBar Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->tvGeneratedByAi Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->tvIndicator Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->viewPager Landroidx/viewpager2/widget/ViewPager2;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeLayoutMultiImagePreviewBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_download I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/FrameLayout;
    if-eqz v5, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->progress_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ProgressBar;
    if-eqz v6, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_generated_by_ai I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_indicator I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->view_pager I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroidx/viewpager2/widget/ViewPager2;
    if-eqz v10, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;
    move-object v3, v11
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroid/widget/ProgressBar; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroidx/viewpager2/widget/ViewPager2;)V
    return-object v0
    invoke-virtual v11, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v11
    invoke-virtual v11, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v11
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v11, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v11
    invoke-direct v0, v11, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeLayoutMultiImagePreviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeLayoutMultiImagePreviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_layout_multi_image_preview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeLayoutMultiImagePreviewBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
