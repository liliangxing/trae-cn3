# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;
.super Ljava/lang/Object;
.source "TraeActivitySimpleWebviewBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final webview:Landroid/webkit/WebView;


.method private constructor <init>(android.widget.LinearLayout  com.bytedance.trae.common.widget.TraeTitleBar  android.webkit.WebView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v3, v0, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->webview Landroid/webkit/WebView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.common_ui.databinding.TraeActivitySimpleWebviewBinding
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->title_bar I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v1, +014h
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->webview I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/webkit/WebView;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;
    check-cast v3, Landroid/widget/LinearLayout;
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;-><init>(Landroid/widget/LinearLayout; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/webkit/WebView;)V
    return-object v0
    invoke-virtual v3, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v3
    invoke-virtual v3, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v3
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v3, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v3
    invoke-direct v0, v3, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.common_ui.databinding.TraeActivitySimpleWebviewBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.common_ui.databinding.TraeActivitySimpleWebviewBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/common_ui/R$layout;->trae_activity_simple_webview I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeActivitySimpleWebviewBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
