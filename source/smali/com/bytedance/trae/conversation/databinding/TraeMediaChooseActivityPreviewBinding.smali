# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
.super Ljava/lang/Object;
.source "TraeMediaChooseActivityPreviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final bottomBar:Landroid/widget/LinearLayout;
.field public final btnBack:Landroid/widget/ImageView;
.field public final btnSend:Landroid/widget/TextView;
.field public final cbOrigin:Landroid/widget/CheckBox;
.field public final pager:Landroidx/viewpager2/widget/ViewPager2;
.field private final rootView:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final selectionContainer:Landroid/widget/FrameLayout;
.field public final topBar:Landroidx/constraintlayout/widget/ConstraintLayout;
.field public final tvOrder:Landroid/widget/TextView;


.method private constructor <init>(androidx.constraintlayout.widget.ConstraintLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.TextView  android.widget.CheckBox  androidx.viewpager2.widget.ViewPager2  android.widget.FrameLayout  androidx.constraintlayout.widget.ConstraintLayout  android.widget.TextView)void
    .registers 10
    # ins_size=10
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->bottomBar Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnBack Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->btnSend Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->cbOrigin Landroid/widget/CheckBox;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->pager Landroidx/viewpager2/widget/ViewPager2;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->selectionContainer Landroid/widget/FrameLayout;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->topBar Landroidx/constraintlayout/widget/ConstraintLayout;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->tvOrder Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeMediaChooseActivityPreviewBinding
    .registers 13
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->bottom_bar I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_back I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_send I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->cb_origin I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/CheckBox;
    if-eqz v7, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->pager I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroidx/viewpager2/widget/ViewPager2;
    if-eqz v8, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->selection_container I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/FrameLayout;
    if-eqz v9, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroidx/constraintlayout/widget/ConstraintLayout;
    if-eqz v10, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_order I
    invoke-static v12, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    move-object v3, v12
    check-cast v3, Landroidx/constraintlayout/widget/ConstraintLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v11, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;-><init>(Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/TextView; Landroid/widget/CheckBox; Landroidx/viewpager2/widget/ViewPager2; Landroid/widget/FrameLayout; Landroidx/constraintlayout/widget/ConstraintLayout; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v12, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v12
    invoke-virtual v12, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v12
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v12, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v12
    invoke-direct v0, v12, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeMediaChooseActivityPreviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeMediaChooseActivityPreviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_media_choose_activity_preview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->getRoot()Landroidx/constraintlayout/widget/ConstraintLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()androidx.constraintlayout.widget.ConstraintLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeMediaChooseActivityPreviewBinding;->rootView Landroidx/constraintlayout/widget/ConstraintLayout;
    return-object v0
.end method
