# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;
.super Ljava/lang/Object;
.source "ConnectComputerGuideViewModel.kt"

.implements Landroidx/lifecycle/ViewModelProvider$Factory;

.field private final target:Lcom/bytedance/trae/conversation/devices/BindingTarget;


.method public constructor <init>(com.bytedance.trae.conversation.devices.BindingTarget)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-void 
.end method

.method public create(java.lang.Class)androidx.lifecycle.ViewModel
    .registers 9
    # ins_size=2
    const-string v0, "modelClass"
    invoke-static v8, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-class v0, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    invoke-virtual v8, v0, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z
    move-result v8
    if-eqz v8, +012h
    new-instance v8, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;
    iget-object v1, v7, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel$Factory;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    const/4 v2, 0
    const-wide/16 v3, 0
    const/4 v5, 6
    const/4 v6, 0
    move-object v0, v8
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/ConnectComputerGuideViewModel;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget; Lcom/bytedance/trae/conversation/devices/BindingDeviceDiscovery; J I Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    check-cast v8, Landroidx/lifecycle/ViewModel;
    return-object v8
    new-instance v8, Ljava/lang/IllegalArgumentException;
    const-string v0, "Failed requirement."
    invoke-virtual v0, Ljava/lang/Object;->toString()Ljava/lang/String;
    move-result-object v0
    invoke-direct v8, v0, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V
    throw v8
.end method
