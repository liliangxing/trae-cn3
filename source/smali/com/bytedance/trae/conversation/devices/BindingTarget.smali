# Decompiled TRAE business class
# Source DEX: classes5.dex
.class public final Lcom/bytedance/trae/conversation/devices/BindingTarget;
.super Ljava/lang/Object;
.source "DeviceBindingPolicy.kt"

.field private final deviceId:Ljava/lang/String;
.field private final deviceName:Ljava/lang/String;
.field private final enterFrom:Ljava/lang/String;
.field private final existingDeviceIds:Ljava/util/Set;
.field private final productType:Lcom/bytedance/trae/conversation/devices/DeviceProductType;
.field private final triggerBy:Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;


.method public constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Set  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger  java.lang.String  java.lang.String)void
    .registers 8
    # ins_size=7
    const-string v0, "productType"
    invoke-static v2, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIds"
    invoke-static v3, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v4, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v5, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    invoke-direct v1, Ljava/lang/Object;-><init>()V
    iput-object v2, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iput-object v3, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    iput-object v4, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    iput-object v5, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    iput-object v6, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    iput-object v7, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    return-void 
.end method

.method public synthetic constructor <init>(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Set  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger  java.lang.String  java.lang.String  int  kotlin.jvm.internal.DefaultConstructorMarker)void
    .registers 16
    # ins_size=9
    and-int/lit8 v15, v14, 8
    if-eqz v15, +004h
    sget-object v11, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->CONNECT_BUTTON Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-object v4, v11
    and-int/lit8 v11, v14, 16
    const/4 v15, 0
    if-eqz v11, +004h
    move-object v5, v15
    goto +2h
    move-object v5, v12
    and-int/lit8 v11, v14, 32
    if-eqz v11, +004h
    move-object v6, v15
    goto +2h
    move-object v6, v13
    move-object v0, v7
    move-object v1, v8
    move-object v2, v9
    move-object v3, v10
    invoke-direct/range v0 ... v6, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)V
    return-void 
.end method

.method public static synthetic copy$default(com.bytedance.trae.conversation.devices.BindingTarget  com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Set  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger  java.lang.String  java.lang.String  int  java.lang.Object)com.bytedance.trae.conversation.devices.BindingTarget
    .registers 13
    # ins_size=9
    and-int/lit8 v12, v11, 1
    if-eqz v12, +004h
    iget-object v5, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    and-int/lit8 v12, v11, 2
    if-eqz v12, +004h
    iget-object v6, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    move-object v12, v6
    and-int/lit8 v6, v11, 4
    if-eqz v6, +004h
    iget-object v7, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    move-object v0, v7
    and-int/lit8 v6, v11, 8
    if-eqz v6, +004h
    iget-object v8, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    move-object v1, v8
    and-int/lit8 v6, v11, 16
    if-eqz v6, +004h
    iget-object v9, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    move-object v2, v9
    and-int/lit8 v6, v11, 32
    if-eqz v6, +004h
    iget-object v10, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    move-object v3, v10
    move-object v6, v4
    move-object v7, v5
    move-object v8, v12
    move-object v9, v0
    move-object v10, v1
    move-object v11, v2
    move-object v12, v3
    invoke-virtual/range v6 ... v12, Lcom/bytedance/trae/conversation/devices/BindingTarget;->copy(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-result-object v4
    return-object v4
.end method

.method public final component1()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final component2()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    return-object v0
.end method

.method public final component3()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final component4()com.bytedance.trae.conversation.devices.DevicePairingTrigger
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    return-object v0
.end method

.method public final component5()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final component6()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final copy(com.bytedance.trae.conversation.devices.DeviceProductType  java.util.Set  java.lang.String  com.bytedance.trae.conversation.devices.DevicePairingTrigger  java.lang.String  java.lang.String)com.bytedance.trae.conversation.devices.BindingTarget
    .registers 15
    # ins_size=7
    const-string v0, "productType"
    invoke-static v9, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "existingDeviceIds"
    invoke-static v10, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string v0, "enterFrom"
    invoke-static v11, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    const-string/jumbo v0, triggerBy
    invoke-static v12, v0, Lkotlin/jvm/internal/Intrinsics;->checkNotNullParameter(Ljava/lang/Object; Ljava/lang/String;)V
    new-instance v0, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    move-object v1, v0
    move-object v2, v9
    move-object v3, v10
    move-object v4, v11
    move-object v5, v12
    move-object v6, v13
    move-object v7, v14
    invoke-direct/range v1 ... v7, Lcom/bytedance/trae/conversation/devices/BindingTarget;-><init>(Lcom/bytedance/trae/conversation/devices/DeviceProductType; Ljava/util/Set; Ljava/lang/String; Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger; Ljava/lang/String; Ljava/lang/String;)V
    return-object v0
.end method

.method public equals(java.lang.Object)boolean
    .registers 6
    # ins_size=2
    const/4 v0, 1
    if-ne v4, v5, +003h
    return v0
    instance-of v1, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    const/4 v2, 0
    if-nez v1, +003h
    return v2
    check-cast v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    if-eq v1, v3, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    iget-object v3, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    invoke-static v1, v3, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v1
    if-nez v1, +003h
    return v2
    iget-object v1, v4, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    iget-object v5, v5, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    invoke-static v1, v5, Lkotlin/jvm/internal/Intrinsics;->areEqual(Ljava/lang/Object; Ljava/lang/Object;)Z
    move-result v5
    if-nez v5, +003h
    return v2
    return v0
.end method

.method public final getDeviceId()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    return-object v0
.end method

.method public final getDeviceName()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    return-object v0
.end method

.method public final getEnterFrom()java.lang.String
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    return-object v0
.end method

.method public final getExistingDeviceIds()java.util.Set
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    return-object v0
.end method

.method public final getProductType()com.bytedance.trae.conversation.devices.DeviceProductType
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    return-object v0
.end method

.method public final getTriggerBy()com.bytedance.trae.conversation.devices.DevicePairingTrigger
    .registers 2
    # ins_size=1
    iget-object v0, v1, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    return-object v0
.end method

.method public hashCode()int
    .registers 4
    # ins_size=1
    iget-object v0, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, Lcom/bytedance/trae/conversation/devices/DeviceProductType;->hashCode()I
    move-result v0
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    invoke-virtual v1, Ljava/lang/Object;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v1, Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    const/4 v2, 0
    if-nez v1, +004h
    move v1, v2
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v1
    add-int/2addr v0, v1
    mul-int/lit8 v0, v0, 31
    iget-object v1, v3, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    if-nez v1, +003h
    goto +5h
    invoke-virtual v1, Ljava/lang/String;->hashCode()I
    move-result v2
    add-int/2addr v0, v2
    return v0
.end method

.method public toString()java.lang.String
    .registers 3
    # ins_size=1
    new-instance v0, Ljava/lang/StringBuilder;
    const-string v1, "BindingTarget(productType="
    invoke-direct v0, v1, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->productType Lcom/bytedance/trae/conversation/devices/DeviceProductType;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", existingDeviceIds="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->existingDeviceIds Ljava/util/Set;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", enterFrom="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->enterFrom Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", triggerBy="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->triggerBy Lcom/bytedance/trae/conversation/devices/DevicePairingTrigger;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceId="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceId Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const-string v1, ", deviceName="
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    iget-object v1, v2, Lcom/bytedance/trae/conversation/devices/BindingTarget;->deviceName Ljava/lang/String;
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    move-result-object v0
    const/16 v1, 41
    invoke-virtual v0, v1, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    move-result-object v0
    invoke-virtual v0, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    move-result-object v0
    return-object v0
.end method
