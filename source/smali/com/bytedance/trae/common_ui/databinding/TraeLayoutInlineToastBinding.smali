# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;
.super Ljava/lang/Object;
.source "TraeLayoutInlineToastBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivInlineToastIcon:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvInlineToastMessage:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.TextView)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->ivInlineToastIcon Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->tvInlineToastMessage Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.common_ui.databinding.TraeLayoutInlineToastBinding
    .registers 4
    # ins_size=1
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->iv_inline_toast_icon I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/ImageView;
    if-eqz v1, +014h
    sget v0, Lcom/bytedance/trae/common_ui/R$id;->tv_inline_toast_message I
    invoke-static v3, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    check-cast v2, Landroid/widget/TextView;
    if-eqz v2, +00ah
    new-instance v0, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;
    check-cast v3, Landroid/widget/LinearLayout;
    invoke-direct v0, v3, v1, v2, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.common_ui.databinding.TraeLayoutInlineToastBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.common_ui.databinding.TraeLayoutInlineToastBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/common_ui/R$layout;->trae_layout_inline_toast I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/common_ui/databinding/TraeLayoutInlineToastBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
