# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;
.super Ljava/lang/Object;
.source "BottomSheetDeviceTargetSelectBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final itemIde:Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
.field public final itemWork:Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
.field private final rootView:Landroid/widget/LinearLayout;
.field public final titleBar:Lcom/bytedance/trae/common/widget/TraeTitleBar;


.method private constructor <init>(android.widget.LinearLayout  com.bytedance.trae.conversation.databinding.IncludeDeviceTargetSelectItemBinding  com.bytedance.trae.conversation.databinding.IncludeDeviceTargetSelectItemBinding  com.bytedance.trae.common.widget.TraeTitleBar)void
    .registers 5
    # ins_size=5
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->rootView Landroid/widget/LinearLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->itemIde Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->itemWork Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
    iput-object v4, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->titleBar Lcom/bytedance/trae/common/widget/TraeTitleBar;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.BottomSheetDeviceTargetSelectBinding
    .registers 5
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->item_ide I
    invoke-static v4, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    if-eqz v1, +027h
    invoke-static v1, Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
    move-result-object v0
    sget v1, Lcom/bytedance/trae/conversation/R$id;->item_work I
    invoke-static v4, v1, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v2
    if-eqz v2, +01ah
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding;
    move-result-object v1
    sget v2, Lcom/bytedance/trae/conversation/R$id;->title_bar I
    invoke-static v4, v2, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v3
    check-cast v3, Lcom/bytedance/trae/common/widget/TraeTitleBar;
    if-eqz v3, +00ah
    new-instance v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;
    check-cast v4, Landroid/widget/LinearLayout;
    invoke-direct v2, v4, v0, v1, v3, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;-><init>(Landroid/widget/LinearLayout; Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding; Lcom/bytedance/trae/conversation/databinding/IncludeDeviceTargetSelectItemBinding; Lcom/bytedance/trae/common/widget/TraeTitleBar;)V
    return-object v2
    move v0, v2
    goto +2h
    move v0, v1
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

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.BottomSheetDeviceTargetSelectBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.BottomSheetDeviceTargetSelectBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_device_target_select I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->getRoot()Landroid/widget/LinearLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.LinearLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceTargetSelectBinding;->rootView Landroid/widget/LinearLayout;
    return-object v0
.end method
