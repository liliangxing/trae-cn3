# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;
.super Ljava/lang/Object;
.source "BottomSheetNewFeaturePromptBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomPromptSpacer:Landroid/widget/Space;
.field public final btnConnect:Landroid/widget/TextView;
.field public final ivPromptImage:Landroid/widget/ImageView;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final topPromptSpacer:Landroid/widget/Space;
.field public final tvPromptMessage:Landroid/widget/TextView;
.field public final tvPromptTitle:Landroid/widget/TextView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.Space  android.widget.TextView  android.widget.ImageView  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.Space  android.widget.TextView  android.widget.TextView)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->bottomPromptSpacer Landroid/widget/Space;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->btnConnect Landroid/widget/TextView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->ivPromptImage Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->topPromptSpacer Landroid/widget/Space;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->tvPromptMessage Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->tvPromptTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.BottomSheetNewFeaturePromptBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->bottom_prompt_spacer I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/Space;
    if-eqz v4, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_connect I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/TextView;
    if-eqz v5, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_prompt_image I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v7, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_prompt_spacer I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/Space;
    if-eqz v8, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_prompt_message I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_prompt_title I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;
    move-object v3, v11
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/Space; Landroid/widget/TextView; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/Space; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.BottomSheetNewFeaturePromptBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.BottomSheetNewFeaturePromptBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_new_feature_prompt I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetNewFeaturePromptBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
