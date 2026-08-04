# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
.super Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;
.source "DeviceFlowDeviceClickPolicy.kt"

.field private final isPaired:Z
.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;


.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  boolean)void
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const/4 v0, 0
    invoke-direct v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-boolean v3, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  boolean  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 5
    # ins_size=5
    and-int/lit8 v3, v3, 2
    if-eqz v3, +003h
    const/4 v2, 1
    invoke-direct v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute$OfflineActivation  com.bytedance.trae.conversation.devices.DeviceProductType  boolean  int  java.lang.Object)com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute$OfflineActivation
    .registers 5
    # ins_size=5
    and-int/lit8 v4, v3, 1
    if-eqz v4, +004h
    iget-object v1, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    and-int/lit8 v3, v3, 2
    if-eqz v3, +004h
    iget-boolean v2, v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    invoke-virtual v0, v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->copy(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z)Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    move-result-object v0
    return-object v0
.end method

.method public final component1()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component2()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    return v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.DeviceProductType  boolean)com.bytedance.trae.conversation.devices.flow.DeviceFlowDeviceClickRoute$OfflineActivation
    .registers 4
    # ins_size=3
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    invoke-direct v0, v2, v3, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Z)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget-boolean v1, v4, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    iget-boolean v5, v5, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    if-eq v1, v5, +003h
    return v2
    return v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public hashCode()int
    .registers 3
    # ins_size=1
    iget-object v0, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    invoke-static v1, Ljava/lang/Boolean;->hashCode(Z)I
    move-result v1
    add-int/2addr v0, v1
    return v0
.end method

.method public final isPaired()boolean
    .registers 2
    # ins_size=1
    iget-boolean v0, v1, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "OfflineActivation(productType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", isPaired="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-boolean v1, v2, Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowDeviceClickRoute$OfflineActivation;->isPaired Z
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
