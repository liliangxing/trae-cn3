# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;
.super Ljava/lang/Object;
.source "ItemSettingsDeviceBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final btnDelete:Landroid/widget/LinearLayout;
.field public final btnRename:Landroid/widget/LinearLayout;
.field public final ivDeviceIcon:Landroid/widget/ImageView;
.field public final layoutContent:Landroid/widget/LinearLayout;
.field public final layoutDeviceIconContainer:Landroid/widget/FrameLayout;
.field public final layoutSwipeActions:Landroid/widget/LinearLayout;
.field public final llProductType:Landroid/widget/LinearLayout;
.field private final rootView:Landroid/widget/FrameLayout;
.field public final tvDeviceName:Landroid/widget/TextView;
.field public final tvDeviceStatus:Landroid/widget/TextView;
.field public final tvProductType:Landroid/widget/TextView;


.method private constructor <init>(android.widget.FrameLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.ImageView  android.widget.LinearLayout  android.widget.FrameLayout  android.widget.LinearLayout  android.widget.LinearLayout  android.widget.TextView  android.widget.TextView  android.widget.TextView)void
    .registers 12
    # ins_size=12
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->btnDelete Landroid/widget/LinearLayout;
    iput-object v3, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->btnRename Landroid/widget/LinearLayout;
    iput-object v4, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->ivDeviceIcon Landroid/widget/ImageView;
    iput-object v5, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->layoutContent Landroid/widget/LinearLayout;
    iput-object v6, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->layoutDeviceIconContainer Landroid/widget/FrameLayout;
    iput-object v7, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->layoutSwipeActions Landroid/widget/LinearLayout;
    iput-object v8, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->llProductType Landroid/widget/LinearLayout;
    iput-object v9, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->tvDeviceName Landroid/widget/TextView;
    iput-object v10, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->tvDeviceStatus Landroid/widget/TextView;
    iput-object v11, v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->tvProductType Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.home.databinding.ItemSettingsDeviceBinding
    .registers 15
    # ins_size=1
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_delete I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/LinearLayout;
    if-eqz v4, +06fh
    sget v0, Lcom/bytedance/trae/home/R$id;->btn_rename I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Landroid/widget/LinearLayout;
    if-eqz v5, +064h
    sget v0, Lcom/bytedance/trae/home/R$id;->iv_device_icon I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/ImageView;
    if-eqz v6, +059h
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_content I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/LinearLayout;
    if-eqz v7, +04eh
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_device_icon_container I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v8, v1
    check-cast v8, Landroid/widget/FrameLayout;
    if-eqz v8, +043h
    sget v0, Lcom/bytedance/trae/home/R$id;->layout_swipe_actions I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v9, v1
    check-cast v9, Landroid/widget/LinearLayout;
    if-eqz v9, +038h
    sget v0, Lcom/bytedance/trae/home/R$id;->ll_product_type I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v10, v1
    check-cast v10, Landroid/widget/LinearLayout;
    if-eqz v10, +02dh
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_device_name I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v11, v1
    check-cast v11, Landroid/widget/TextView;
    if-eqz v11, +022h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_device_status I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v12, v1
    check-cast v12, Landroid/widget/TextView;
    if-eqz v12, +017h
    sget v0, Lcom/bytedance/trae/home/R$id;->tv_product_type I
    invoke-static v14, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v13, v1
    check-cast v13, Landroid/widget/TextView;
    if-eqz v13, +00ch
    new-instance v0, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;
    move-object v3, v14
    check-cast v3, Landroid/widget/FrameLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v13, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/ImageView; Landroid/widget/LinearLayout; Landroid/widget/FrameLayout; Landroid/widget/LinearLayout; Landroid/widget/LinearLayout; Landroid/widget/TextView; Landroid/widget/TextView; Landroid/widget/TextView;)V
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.home.databinding.ItemSettingsDeviceBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.home.databinding.ItemSettingsDeviceBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/home/R$layout;->item_settings_device I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/home/databinding/ItemSettingsDeviceBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
