# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;
.super Ljava/lang/Object;
.source "TraeItemCodeDeviceBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivIcon:Landroid/widget/ImageView;
.field public final ivRadio:Landroid/widget/ImageView;
.field public final llContainer:Landroid/widget/LinearLayout;
.field public final llProductType:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvName:Landroid/widget/TextView;
.field public final tvProductType:Landroid/widget/TextView;
.field public final tvStatus:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 9
    # ins_size=9
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->ivIcon Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->ivRadio Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->llContainer Landroid/widget/LinearLayout;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->llProductType Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->tvName Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->tvProductType Landroid/widget/TextView;
    iput-object v8, v0, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->tvStatus Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeItemCodeDeviceBinding
    .registers 12
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_icon I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +044h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_radio I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +039h
    move-object v6, v11
    check-cast v6, Landroid/widget/LinearLayout;
    sget v0, Lcom/bytedance/trae/conversation/R$id;->ll_product_type I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +02bh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_name I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +020h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_product_type I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +015h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_status I
    invoke-static v11, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/TextView;
    if-eqz v10, +00ah
    new-instance v11, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;
    move-object v2, v11
    move-object v3, v6
    invoke-direct/range v2 ... v10, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v11
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeItemCodeDeviceBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeItemCodeDeviceBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_item_code_device I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeItemCodeDeviceBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
