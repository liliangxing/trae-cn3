# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;
.source "DeviceFlowRoute.kt"

.field private final target:Lcom/bytedance/trae/conversation/devices/BindingTarget;


.method public constructor <init>(com.bytedance.trae.conversation.devices.BindingTarget)void
    .registers 3
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ConnectGuide  com.bytedance.trae.conversation.devices.BindingTarget  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ConnectGuide
    .registers 4
    # ins_size=4
    and-int/lit8 v2, v2, 1
    if-eqz v2, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->copy(Lcom/bytedance/trae/conversation/devices/BindingTarget;)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.BindingTarget
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.BindingTarget)com.bytedance.trae.conversation.devices.flow.DeviceFlowRoute$ConnectGuide
    .registers 3
    # ins_size=2
    const-string/jumbo v0, target
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    invoke-direct v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;-><init>(Lcom/bytedance/trae/conversation/devices/BindingTarget;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 5
    # ins_size=2
    const/4 v0, 1
    if-ne v3, v4, +003h
    return v0
    instance-of v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    iget-object v4, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-static v1, v4, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v4
    if-nez v4, +003h
    return v2
    return v0
.end method

.method public final getTarget()com.bytedance.trae.conversation.devices.BindingTarget
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    return-object v0
.end method

.method public hashCode()int
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;->hashCode()I
    move-result v0
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "ConnectGuide(target="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowRoute$ConnectGuide;->target Lcom/bytedance/trae/conversation/devices/BindingTarget;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
