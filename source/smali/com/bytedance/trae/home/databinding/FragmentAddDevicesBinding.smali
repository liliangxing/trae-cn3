# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;
.super Ljava/lang/Object;
.source "FragmentAddDevicesBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnCopyUrl:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvStep1Url:Lcom/bytedance/trae/common/widget/UrlSpanTextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  com.bytedance.trae.common.widget.TraeTitleBar  com.bytedance.trae.common.widget.UrlSpanTextView)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->btnCopyUrl Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->tvStep1Url Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.FragmentAddDevicesBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_copy_url I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    if-eqz v1, +01eh
    sget v0, Lcom/bytedance/trae/home/R$id;->title_bar I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v2, +014h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_step1_url I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/UrlSpanTextView;
    if-eqz v3, +00ah
    new-instance v0, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct v0, v4, v1, v2, v3, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/TraeTitleBar; Lcom/bytedance/trae/common/widget/UrlSpanTextView;)V
    return-object v0
    invoke-virtual v4, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v4
    invoke-virtual v4, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v4
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v4, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v4
    invoke-direct v0, v4, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.FragmentAddDevicesBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.FragmentAddDevicesBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->fragment_add_devices I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/FragmentAddDevicesBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
