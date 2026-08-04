# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
.super Ljava/lang/Object;
.source "FragmentConnectComputerGuideBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnShare:Landroid/widget/LinearLayout;
.field public final ivConnectGuideImage:Lcom/facebook/drawee/view/SimpleDraweeView;
.field public final ivStep1Status:Landroid/widget/ImageView;
.field public final ivStep2Status:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final step1Card:Lcom/google/android/material/card/MaterialCardView;
.field public final step2Card:Lcom/google/android/material/card/MaterialCardView;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final traeUrl:Landroid/widget/TextView;
.field public final tvStep1:Landroid/widget/TextView;
.field public final tvStep1Status:Landroid/widget/TextView;
.field public final tvStep2:Landroid/widget/TextView;
.field public final tvStep2Status:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  com.facebook.drawee.view.SimpleDraweeView  android.widget.ImageView  android.widget.ImageView  com.google.android.material.card.MaterialCardView  com.google.android.material.card.MaterialCardView  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 14
    # ins_size=14
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->btnShare Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivConnectGuideImage Lcom/facebook/drawee/view/SimpleDraweeView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep1Status Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->ivStep2Status Landroid/widget/ImageView;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step1Card Lcom/google/android/material/card/MaterialCardView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->step2Card Lcom/google/android/material/card/MaterialCardView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->traeUrl Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1 Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep1Status Landroid/widget/TextView;
    iput-object v12, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2 Landroid/widget/TextView;
    iput-object v13, v0, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->tvStep2Status Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.FragmentConnectComputerGuideBinding
    .registers 18
    # ins_size=1
    move-object/from16 v0, v17
    sget v1, Lcom/bytedance/trae/conversation/R$id;->btn_share I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v5, v2
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +086h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_connect_guide_image I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v6, v2
    check-cast v6, Lcom/facebook/drawee/view/SimpleDraweeView;
    if-eqz v6, +07bh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_step1_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v7, v2
    check-cast v7, Landroid/widget/ImageView;
    if-eqz v7, +070h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->iv_step2_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v8, v2
    check-cast v8, Landroid/widget/ImageView;
    if-eqz v8, +065h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->step1_card I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v9, v2
    check-cast v9, Lcom/google/android/material/card/MaterialCardView;
    if-eqz v9, +05ah
    sget v1, Lcom/bytedance/trae/conversation/R$id;->step2_card I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v10, v2
    check-cast v10, Lcom/google/android/material/card/MaterialCardView;
    if-eqz v10, +04fh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v11, v2
    check-cast v11, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v11, +044h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->trae_url I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v12, v2
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +039h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_step1 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v13, v2
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +02eh
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_step1_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v14, v2
    check-cast v14, Landroid/widget/TextView;
    if-eqz v14, +023h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_step2 I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object v15, v2
    check-cast v15, Landroid/widget/TextView;
    if-eqz v15, +018h
    sget v1, Lcom/bytedance/trae/conversation/R$id;->tv_step2_status I
    invoke-static v0, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    move-object/from16 v16, v2
    check-cast v16, Landroid/widget/TextView;
    if-eqz v16, +00ch
    new-instance v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-object v4, v0
    check-cast v4, Landroid/widget/LinearLayout;
    move-object v3, v1
    invoke-direct/range v3 ... v16, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Lcom/facebook/drawee/view/SimpleDraweeView; Landroid/widget/ImageView; Landroid/widget/ImageView; Lcom/google/android/material/card/MaterialCardView; Lcom/google/android/material/card/MaterialCardView; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v1
    invoke-virtual/range v17, Landroid/view/View;->getResources()Landroid/content/res/Resources;
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.FragmentConnectComputerGuideBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.FragmentConnectComputerGuideBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->fragment_connect_computer_guide I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/FragmentConnectComputerGuideBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
