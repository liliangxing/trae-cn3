# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function1;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$BooleanRef;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function1;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function1  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-void 
.end method

.method public final invoke(java.lang.Object)java.lang.Object
    .registers 5
    # ins_size=2
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$1 Lkotlin/jvm/functions/Function1;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda2;->f$2 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    check-cast v4, Lcom/bytedance/trae/conversation/devices/MobileDevice;
    invoke-static v0, v1, v2, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->$r8$lambda$2nS_WikWr3hZEXdnFDxgkt2R1x0(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function1; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks; Lcom/bytedance/trae/conversation/devices/MobileDevice;)Lkotlin/Unit;
    move-result-object v4
    return-object v4
.end method
