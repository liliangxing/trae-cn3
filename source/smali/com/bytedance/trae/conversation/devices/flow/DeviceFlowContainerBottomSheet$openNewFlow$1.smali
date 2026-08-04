# Decompiled TRAE business class
# Source DEX: classes5.dex
.class final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$1;
.super Lkotlin/jvm/internal/AdaptedFunctionReference;
.source "DeviceFlowContainerBottomSheet.kt"

.implements Lkotlin/jvm/functions/Function0;


.method constructor <init>(java.lang.Object)void
    .registers 9
    # ins_size=2
    const/4 v1, 0
    const-class v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    const-string v4, "notifyCurrentRouteConnectionSuccess"
    const-string v5, "notifyCurrentRouteConnectionSuccess(Ljava/lang/String;)V"
    const/4 v6, 0
    move-object v0, v7
    move-object v2, v8
    invoke-direct/range v0 ... v6, Lkotlin/jvm/internal/AdaptedFunctionReference;-><init>(I Ljava/lang/Object; Ljava/lang/Class; Ljava/lang/String; Ljava/lang/String; I)V
    return-void 
.end method

.method public bridge synthetic invoke()java.lang.Object
    .registers 2
    # ins_size=1
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$1;->invoke()V
    sget-object v0, Lkotlin/Unit;->INSTANCE Lkotlin/Unit;
    return-object v0
.end method

.method public final invoke()void
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet$openNewFlow$1;->receiver Ljava/lang/Object;
    check-cast v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;
    const/4 v1, 0
    const/4 v2, 1
    invoke-static v0, v1, v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet;->notifyCurrentRouteConnectionSuccess$default(Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowContainerBottomSheet; Ljava/lang/String; I Ljava/lang/Object;)V
    return-void 
.end method
