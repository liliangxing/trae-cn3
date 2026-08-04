# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;
.super Ljava/lang/Object;
.source "TraeFragmentBrainstormIntroBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnStart:Landroid/widget/Button;
.field public final descContainer:Landroid/widget/LinearLayout;
.field public final ivPhoneMockup:Landroid/widget/ImageView;
.field public final mockupContainer:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final sphereArea:Landroid/widget/FrameLayout;
.field public final topBar:Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
.field public final tvDescLine1:Landroid/widget/TextView;
.field public final tvDescLine2:Landroid/widget/TextView;
.field public final tvTitle:Landroid/widget/TextView;
.field public final webviewSphere:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.Button  android.widget.LinearLayout  android.widget.ImageView  android.widget.FrameLayout  android.widget.FrameLayout  com.bytedance.trae.conversation.brainstorm.widget.BrainstormTopBar  android.widget.TextView  android.widget.TextView  android.widget.TextView  android.webkit.WebView)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->btnStart Landroid/widget/Button;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->descContainer Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->ivPhoneMockup Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->mockupContainer Landroid/widget/FrameLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->sphereArea Landroid/widget/FrameLayout;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->topBar Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->tvDescLine1 Landroid/widget/TextView;
    iput-object v9, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->tvDescLine2 Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->tvTitle Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->webviewSphere Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormIntroBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->btn_start I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/Button;
    if-eqz v4, +06fh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->desc_container I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +064h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_phone_mockup I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +059h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->mockup_container I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/FrameLayout;
    if-eqz v7, +04eh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->sphere_area I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +043h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->top_bar I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar;
    if-eqz v9, +038h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_desc_line1 I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_desc_line2 I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_title I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->webview_sphere I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/webkit/WebView;
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/Button; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Lcom/bytedance/trae/conversation/brainstorm/widget/BrainstormTopBar; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/webkit/WebView;)V
    return-object v0
    invoke-virtual v14, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v14
    invoke-virtual v14, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v14
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v14, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v14
    invoke-direct v0, v14, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormIntroBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeFragmentBrainstormIntroBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_fragment_brainstorm_intro I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeFragmentBrainstormIntroBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
