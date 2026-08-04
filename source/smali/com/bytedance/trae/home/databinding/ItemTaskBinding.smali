# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/ItemTaskBinding;
.super Ljava/lang/Object;
.source "ItemTaskBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnDelete:Landroid/widget/LinearLayout;
.field public final btnPin:Landroid/widget/LinearLayout;
.field public final btnRename:Landroid/widget/LinearLayout;
.field public final flIconContainer:Landroid/widget/FrameLayout;
.field public final ivEmojiIcon:Landroid/widget/ImageView;
.field public final ivPin:Landroid/widget/ImageView;
.field public final ivProductIcon:Landroid/widget/ImageView;
.field public final ivSourceIcon:Landroid/widget/ImageView;
.field public final layoutContent:Landroid/widget/LinearLayout;
.field public final layoutSwipeActions:Landroid/widget/LinearLayout;
.field public final llInfoLeft:Landroid/widget/LinearLayout;
.field public final pbLoading:Landroid/widget/ProgressBar;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvDot1:Landroid/widget/TextView;
.field public final tvLocation:Landroid/widget/TextView;
.field public final tvPin:Landroid/widget/TextView;
.field public final tvTime:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final vBadge:Landroid/view/View;


.method private constructor <init>(android.widget.FrameLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.FrameLayout  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ProgressBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.view.View)void
    .registers 22
    # ins_size=20
    move-object v0, v2
    invoke-direct v2, Ljava/lang/Object;-><init>()V
    move-object v1, v3
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->rootView Landroid/widget/FrameLayout;
    move-object v1, v4
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->btnDelete Landroid/widget/LinearLayout;
    move-object v1, v5
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->btnPin Landroid/widget/LinearLayout;
    move-object v1, v6
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->btnRename Landroid/widget/LinearLayout;
    move-object v1, v7
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->flIconContainer Landroid/widget/FrameLayout;
    move-object v1, v8
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->ivEmojiIcon Landroid/widget/ImageView;
    move-object v1, v9
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->ivPin Landroid/widget/ImageView;
    move-object v1, v10
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->ivProductIcon Landroid/widget/ImageView;
    move-object v1, v11
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->ivSourceIcon Landroid/widget/ImageView;
    move-object v1, v12
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->layoutContent Landroid/widget/LinearLayout;
    move-object v1, v13
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->layoutSwipeActions Landroid/widget/LinearLayout;
    move-object v1, v14
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->llInfoLeft Landroid/widget/LinearLayout;
    move-object v1, v15
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->pbLoading Landroid/widget/ProgressBar;
    move-object/from16 v1, v16
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->tvDot1 Landroid/widget/TextView;
    move-object/from16 v1, v17
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->tvLocation Landroid/widget/TextView;
    move-object/from16 v1, v18
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->tvPin Landroid/widget/TextView;
    move-object/from16 v1, v19
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->tvTime Landroid/widget/TextView;
    move-object/from16 v1, v20
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->tvTitle Landroid/widget/TextView;
    move-object/from16 v1, v21
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->vBadge Landroid/view/View;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.ItemTaskBinding
    .registers 24
    # ins_size=1
    move-object/from16 v0, v23
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +0cah
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_pin I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Landroid/widget/LinearLayout;
    if-eqz v6, +0bfh
    sget v1, Lcom/bytedance/trae/home/R$id;->btn_rename I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +0b4h
    sget v1, Lcom/bytedance/trae/home/R$id;->fl_icon_container I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +0a9h
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_emoji_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Landroid/widget/ImageView;
    if-eqz v9, +09eh
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_pin I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Landroid/widget/ImageView;
    if-eqz v10, +093h
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_product_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Landroid/widget/ImageView;
    if-eqz v11, +088h
    sget v1, Lcom/bytedance/trae/home/R$id;->iv_source_icon I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/ImageView;
    if-eqz v12, +07dh
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/LinearLayout;
    if-eqz v13, +072h
    sget v1, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/LinearLayout;
    if-eqz v14, +067h
    sget v1, Lcom/bytedance/trae/home/R$id;->ll_info_left I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/LinearLayout;
    if-eqz v15, +05ch
    sget v1, Lcom/bytedance/trae/home/R$id;->pb_loading I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/ProgressBar;
    if-eqz v16, +050h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_dot1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v17, v2
    check-cast v17, Landroid/widget/TextView;
    if-eqz v17, +044h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_location I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v18, v2
    check-cast v18, Landroid/widget/TextView;
    if-eqz v18, +038h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_pin I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v19, v2
    check-cast v19, Landroid/widget/TextView;
    if-eqz v19, +02ch
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_time I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v20, v2
    check-cast v20, Landroid/widget/TextView;
    if-eqz v20, +020h
    sget v1, Lcom/bytedance/trae/home/R$id;->tv_title I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v21, v2
    check-cast v21, Landroid/widget/TextView;
    if-eqz v21, +014h
    sget v1, Lcom/bytedance/trae/home/R$id;->v_badge I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v22
    if-eqz v22, +00ch
    new-instance v1, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;
    move-object v3, v1
    move-object v4, v0
    check-cast v4, Landroid/widget/FrameLayout;
    invoke-direct/range v3 ... v22, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ProgressBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/view/View;)V
    return-object v1
    invoke-virtual/range v23, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.ItemTaskBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/ItemTaskBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.ItemTaskBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_task I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/ItemTaskBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/ItemTaskBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
