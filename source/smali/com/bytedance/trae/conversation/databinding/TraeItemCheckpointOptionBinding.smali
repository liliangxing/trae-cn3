# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;
.super Ljava/lang/Object;
.source "TraeItemCheckpointOptionBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final checkboxContainer:Landroid/widget/FrameLayout;
.field public final ivCheck:Landroid/widget/ImageView;
.field public final ivOptionSingleCheck:Landroid/widget/ImageView;
.field public final optionRoot:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final subtitleBottomFade:Landroid/view/View;
.field public final subtitleTopFade:Landroid/view/View;
.field public final subtitleViewport:Landroid/widget/FrameLayout;
.field public final textContainer:Landroid/widget/LinearLayout;
.field public final tvOptionIndex:Landroid/widget/TextView;
.field public final tvSubtitle:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.FrameLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.view.View  android.view.View  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 13
    # ins_size=13
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->checkboxContainer Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->ivCheck Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->ivOptionSingleCheck Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->optionRoot Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->subtitleBottomFade Landroid/view/View;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->subtitleTopFade Landroid/view/View;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->subtitleViewport Landroid/widget/FrameLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->textContainer Landroid/widget/LinearLayout;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->tvOptionIndex Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->tvSubtitle Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->tvTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemCheckpointOptionBinding
    .registers 16
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->checkbox_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/FrameLayout;
    if-eqz v4, +074h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_check I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +069h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_option_single_check I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +05eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->option_root I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +053h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtitle_bottom_fade I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v8
    if-eqz v8, +04bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtitle_top_fade I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v9
    if-eqz v9, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->subtitle_viewport I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/FrameLayout;
    if-eqz v10, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->text_container I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/LinearLayout;
    if-eqz v11, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_option_index I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_subtitle I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v15, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v14, v1
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;
    move-object v3, v15
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v14, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/view/View; Landroid/view/View; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemCheckpointOptionBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemCheckpointOptionBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_checkpoint_option I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCheckpointOptionBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
