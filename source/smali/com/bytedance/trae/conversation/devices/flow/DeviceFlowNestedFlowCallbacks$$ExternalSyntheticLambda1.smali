# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final synthetic Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;
.super Ljava/lang/Object;
.source "D8$$SyntheticClass"

.implements Lkotlin/jvm/functions/Function0;

.field public final synthetic f$0:Lkotlin/jvm/internal/Ref$BooleanRef;
.field public final synthetic f$1:Lkotlin/jvm/functions/Function0;
.field public final synthetic f$2:Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;


.method public synthetic constructor <init>(kotlin.jvm.internal.Ref$BooleanRef  kotlin.jvm.functions.Function0  com.bytedance.trae.conversation.devices.flow.DeviceFlowCallbacks)void
    .registers 4
    # ins_size=4
    invoke-direct v0, Ljava/lang/Object;-><init>()V
    iput-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iput-object v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function0;
    iput-object v3, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    return-void 
.end method

.method public final invoke()java.lang.Object
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$0 Lkotlin/jvm/internal/Ref$BooleanRef;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$1 Lkotlin/jvm/functions/Function0;
    iget-object v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks$$ExternalSyntheticLambda1;->f$2 Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;
    invoke-static v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNestedFlowCallbacks;->$r8$lambda$-zVC47Q-dD-KHW3SRRWKQ4bechk(Lkotlin/jvm/internal/Ref$BooleanRef; Lkotlin/jvm/functions/Function0; Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowCallbacks;)Lkotlin/Unit;
    move-result-object v0
    return-object v0
.end method
