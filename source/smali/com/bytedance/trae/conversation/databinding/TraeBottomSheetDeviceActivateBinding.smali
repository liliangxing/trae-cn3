# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;
.super Ljava/lang/Object;
.source "TraeBottomSheetDeviceActivateBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final ivDeviceActivate:Landroid/widget/ImageView;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;
.field public final tvDeviceActivateDescription:Landroid/widget/TextView;
.field public final tvDeviceActivateTitle:Landroid/widget/TextView;


.method private constructor <init>(android.widget.LinearLayout  android.widget.ImageView  com.bytedance.trae.common.widget.TraeTitleBar  android.widget.TextView  android.widget.TextView)void
    .registers 6
    # ins_size=6
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->ivDeviceActivate Landroid/widget/ImageView;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->tvDeviceActivateDescription Landroid/widget/TextView;
    iput-object v5, v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->tvDeviceActivateTitle Landroid/widget/TextView;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.TraeBottomSheetDeviceActivateBinding
    .registers 9
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->iv_device_activate I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v4, v1
    check-cast v4, Landroid/widget/ImageView;
    if-eqz v4, +02dh
    sget v0, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v5, v1
    check-cast v5, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v5, +022h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_device_activate_description I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v6, v1
    check-cast v6, Landroid/widget/TextView;
    if-eqz v6, +017h
    sget v0, Lcom/bytedance/trae/conversation/R$id;->tv_device_activate_title I
    invoke-static v8, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    move-object v7, v1
    check-cast v7, Landroid/widget/TextView;
    if-eqz v7, +00ch
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;
    move-object v3, v8
    check-cast v3, Landroid/widget/LinearLayout;
    move-object v2, v0
    invoke-direct/range v2 ... v7, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;-><init>(Landroid/widget/LinearLayout; Landroid/widget/ImageView; Lcom/bytedance/trae/common/widget/TraeTitleBar; Landroid/widget/TextView; Landroid/widget/TextView;)V
    return-object v0
    invoke-virtual v8, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v8
    invoke-virtual v8, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v8
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v8, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v8
    invoke-direct v0, v8, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.TraeBottomSheetDeviceActivateBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.TraeBottomSheetDeviceActivateBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->trae_bottom_sheet_device_activate I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/TraeBottomSheetDeviceActivateBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
