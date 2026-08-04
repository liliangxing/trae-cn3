# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;
.super Ljava/lang/Object;
.source "TraeDialogHumanCheckpointBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final actionGroup:Landroid/widget/LinearLayout;
.field public final btnCancel:Landroid/widget/TextView;
.field public final btnClose:Landroid/widget/FrameLayout;
.field public final btnHeaderNext:Landroid/widget/FrameLayout;
.field public final btnHeaderPrev:Landroid/widget/FrameLayout;
.field public final btnNext:Landroid/widget/TextView;
.field public final btnPrev:Landroid/widget/TextView;
.field public final cardContainer:Landroidx/cardview/widget/CardView;
.field public final header:Landroid/widget/LinearLayout;
.field public final headerNavGroup:Landroid/widget/LinearLayout;
.field public final ivHeaderNext:Landroid/widget/ImageView;
.field public final ivHeaderPrev:Landroid/widget/ImageView;
.field public final normalContent:Landroid/widget/LinearLayout;
.field private final rootView:Landroidx/core/widget/NestedScrollView;
.field public final rvOptions:Landroidx/recyclerview/widget/RecyclerView;
.field public final titleScrollView:Landroidx/core/widget/NestedScrollView;
.field public final tvProgress:Landroid/widget/TextView;
.field public final tvQuestion:Landroid/widget/TextView;


.method private constructor <init>(androidx.core.widget.NestedScrollView  android.widget.LinearLayout  android.widget.TextView  android.widget.FrameLayout  android.widget.FrameLayout  android.widget.FrameLayout  android.widget.TextView  android.widget.TextView  androidx.cardview.widget.CardView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  androidx.recyclerview.widget.RecyclerView  androidx.core.widget.NestedScrollView  android.widget.TextView  android.widget.TextView)void
    .registers 21
    # ins_size=19
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->rootView Landroidx/core/widget/NestedScrollView;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->actionGroup Landroid/widget/LinearLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnCancel Landroid/widget/TextView;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnClose Landroid/widget/FrameLayout;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnHeaderNext Landroid/widget/FrameLayout;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnHeaderPrev Landroid/widget/FrameLayout;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnNext Landroid/widget/TextView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->btnPrev Landroid/widget/TextView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->cardContainer Landroidx/cardview/widget/CardView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->header Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->headerNavGroup Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->ivHeaderNext Landroid/widget/ImageView;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->ivHeaderPrev Landroid/widget/ImageView;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->normalContent Landroid/widget/LinearLayout;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->rvOptions Landroidx/recyclerview/widget/RecyclerView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->titleScrollView Landroidx/core/widget/NestedScrollView;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->tvProgress Landroid/widget/TextView;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->tvQuestion Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeDialogHumanCheckpointBinding
    .registers 23
    # ins_size=1
    move-object/from16 v0, v22
    sget v1, Lcom/bytedance/trae/conversation/R$id;->action_group I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +0c2h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_cancel I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +0b7h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_close I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +0ach
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_header_next I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +0a1h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_header_prev I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +096h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_next I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +08bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_prev I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +080h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->card_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroidx/cardview/widget/CardView;
    if-eqz v12, +075h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->header I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +06ah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->header_nav_group I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +05fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_header_next I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/ImageView;
    if-eqz v15, +054h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_header_prev I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/ImageView;
    if-eqz v16, +048h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->normal_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/LinearLayout;
    if-eqz v17, +03ch
    sget v1, Lcom/bytedance/trae/conversation/R$id;->rv_options I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroidx/recyclerview/widget/RecyclerView;
    if-eqz v18, +030h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_scroll_view I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroidx/core/widget/NestedScrollView;
    if-eqz v19, +024h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_progress I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/TextView;
    if-eqz v20, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_question I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/TextView;
    if-eqz v21, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroidx/core/widget/NestedScrollView;
    invoke-direct/range v3 ... v21, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;-><init>(Landroidx/core/widget/NestedScrollView; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroidx/cardview/widget/CardView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroidx/recyclerview/widget/RecyclerView; Landroidx/core/widget/NestedScrollView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeDialogHumanCheckpointBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeDialogHumanCheckpointBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_dialog_human_checkpoint I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->getRoot()Landroidx/core/widget/NestedScrollView;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.core.widget.NestedScrollView
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeDialogHumanCheckpointBinding;->rootView Landroidx/core/widget/NestedScrollView;
    return-object v0
.end method
