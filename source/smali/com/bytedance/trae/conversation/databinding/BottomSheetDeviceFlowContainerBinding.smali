# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;
.super Ljava/lang/Object;
.source "BottomSheetDeviceFlowContainerBinding.java"

.implements Landroidx/viewbinding/ViewBinding;

.field public final deviceFlowContent:Landroid/widget/FrameLayout;
.field public final deviceFlowRoot:Landroid/widget/FrameLayout;
.field private final rootView:Landroid/widget/FrameLayout;


.method private constructor <init>(android.widget.FrameLayout  android.widget.FrameLayout  android.widget.FrameLayout)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->rootView Landroid/widget/FrameLayout;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->deviceFlowContent Landroid/widget/FrameLayout;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->deviceFlowRoot Landroid/widget/FrameLayout;
    return-void 
.end method

.method public static bind(android.view.View)com.bytedance.trae.conversation.databinding.BottomSheetDeviceFlowContainerBinding
    .registers 3
    # ins_size=1
    sget v0, Lcom/bytedance/trae/conversation/R$id;->device_flow_content I
    invoke-static v2, v0, Landroidx/viewbinding/ViewBindings;->findChildViewById(Landroid/view/View; I)Landroid/view/View;
    move-result-object v1
    check-cast v1, Landroid/widget/FrameLayout;
    if-eqz v1, +00ah
    check-cast v2, Landroid/widget/FrameLayout;
    new-instance v0, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;
    invoke-direct v0, v2, v1, v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;-><init>(Landroid/widget/FrameLayout; Landroid/widget/FrameLayout; Landroid/widget/FrameLayout;)V
    return-object v0
    invoke-virtual v2, Landroid/view/View;->getResources()Landroid/content/res/Resources;
    move-result-object v2
    invoke-virtual v2, v0, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;
    move-result-object v2
    new-instance v0, Ljava/lang/NullPointerException;
    const-string v1, "Missing required view with ID: "
    invoke-virtual v1, v2, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;
    move-result-object v2
    invoke-direct v0, v2, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V
    throw v0
.end method

.method public static inflate(android.view.LayoutInflater)com.bytedance.trae.conversation.databinding.BottomSheetDeviceFlowContainerBinding
    .registers 3
    # ins_size=1
    const/4 v0, 0
    const/4 v1, 0
    invoke-static v2, v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->inflate(Landroid/view/LayoutInflater; Landroid/view/ViewGroup; Z)Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;
    move-result-object v2
    return-object v2
.end method

.method public static inflate(android.view.LayoutInflater  android.view.ViewGroup  boolean)com.bytedance.trae.conversation.databinding.BottomSheetDeviceFlowContainerBinding
    .registers 5
    # ins_size=3
    sget v0, Lcom/bytedance/trae/conversation/R$layout;->bottom_sheet_device_flow_container I
    const/4 v1, 0
    invoke-virtual v2, v0, v3, v1, Landroid/view/LayoutInflater;->inflate(I Landroid/view/ViewGroup; Z)Landroid/view/View;
    move-result-object v2
    if-eqz v4, +005h
    invoke-virtual v3, v2, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V
    invoke-static v2, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->bind(Landroid/view/View;)Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;
    move-result-object v2
    return-object v2
.end method

.method public bridge synthetic getRoot()android.view.View
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->getRoot()Landroid/widget/FrameLayout;
    move-result-object v0
    return-object v0
.end method

.method public getRoot()android.widget.FrameLayout
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/databinding/BottomSheetDeviceFlowContainerBinding;->rootView Landroid/widget/FrameLayout;
    return-object v0
.end method
