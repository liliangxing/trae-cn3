# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;
.super Ljava/lang/Object;
.source "ItemFilterDeviceBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final itemDevice:Landroid/widget/LinearLayout;
.field public final ivCheckDevice:Landroid/widget/ImageView;
.field public final ivDeviceIcon:Landroid/widget/ImageView;
.field public final llProductTag:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final tvDeviceName:Landroid/widget/TextView;
.field public final tvProductType:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.ImageView  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView)void
    .registers 8
    # ins_size=8
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->itemDevice Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->ivCheckDevice Landroid/widget/ImageView;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->ivDeviceIcon Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->llProductTag Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->tvDeviceName Landroid/widget/TextView;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->tvProductType Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.ItemFilterDeviceBinding
    .registers 11
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->item_device I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +043h
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_check_device I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/ImageView;
    if-eqz v5, +038h
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_device_icon I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->ll_product_tag I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_device_name I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/TextView;
    if-eqz v8, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_product_type I
    invoke-static v10, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/TextView;
    if-eqz v9, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;
    move-object v3, v10
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v9, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v10, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v10
    invoke-virtual v10, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v10
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v10, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v10
    invoke-direct v0, v10, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.ItemFilterDeviceBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.ItemFilterDeviceBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_filter_device I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/ItemFilterDeviceBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
